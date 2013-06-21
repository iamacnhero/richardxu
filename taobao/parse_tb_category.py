#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# author: richardxu
# time: 2013-06-17
# purpose: 解析淘宝类目页面, 得到近一月的销量
# usage: python parse_tb_category.py $category_id, eg: python parse_tb_category.py 50049375

import os
import sys
import re
import time
import BeautifulSoup
import urllib2
import MySQLdb
from simplejson import loads, dumps

def removePrefix(text, prefix):
	return text[len(prefix):] if text.startswith(prefix) else text

def get_category_url(category_id, pagenum):
	pagesize = 96
	if pagenum == 1:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cat=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&data-key=s&s=%s&data-value=0&module=page' % (category_id, pagesize)
	elif pagenum == 2:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cat=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&data-key=s&data-value=%s&module=page' % (category_id, pagesize)
	else:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cat=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&data-key=s&s=%s&data-value=%s&module=page' % (category_id, (pagenum-2)*pagesize, (pagenum-1)*pagesize)
	return api_url

def get_itemlist(url):
	req = urllib2.Request(url)
	req.add_header('Referer', 'http://www.taobao.com')
	return loads(urllib2.urlopen(url, timeout = 300).read().decode('gbk'))	# 得到淘宝类目列表

def insert_record(conn, url, price, tradeNum, page):
    query = "INSERT INTO cate_product(url, price, tradeNum, page) VALUES('%s', %s, %s, %s)" % (url, price, tradeNum, page)
    cursor = conn.cursor()
    cursor.execute(query)
    conn.commit()

def main():
    conn = MySQLdb.connect(host='127.0.0.1', port=3306, db='taobao', user='root', passwd='123456')
    if len(sys.argv) >= 2:
        category_id = sys.argv[1]
        total_price = 0
        for pagenum in xrange(1, 101):
			print pagenum
			url = get_category_url(category_id, int(pagenum))
			page_content = get_itemlist(url)

			for item in page_content.get('itemList'):
				url = item.get('href')
				price = float(item.get('currentPrice')) * 100
				# print item.get('title')
				tradeNum = item.get('tradeNum')
				insert_record(conn, url, price, tradeNum, pagenum)
			time.sleep(15)
	else:
		print "No taobao category_id provided!"
		sys.exit(1)

if __name__ == '__main__':
	main()