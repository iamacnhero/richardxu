#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# author: richardxu
# time: 2013-06-17
# purpose: 解析淘宝类目页面, 得到近一月的销量
# usage: python parse_tb_category.py $category_id $pagenum, eg: python parse_tb_category.py 50019172 5

import os
import sys
import re
import BeautifulSoup
from urllib2 import urlopen
from simplejson import loads

def removePrefix(text, prefix):
	return text[len(prefix):] if text.startswith(prefix) else text

def get_category_url(category_id, pagenum):
	pagesize = 96
	if pagenum == 0:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cat=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&s=192&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&module=page&data-key=s&data-value=0' % category_id
	elif pagenum == 1:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cat=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&data-key=s&data-value=96&module=page' % category_id
	else:
		api_url = 'http://list.taobao.com/itemlist/jiadiano.htm?cate=%s&sort=biz30day&user_type=0&isprepay=1&sd=0&as=1&viewIndex=1&commend=all&atype=b&style=grid&same_info=1&tid=0&olu=yes&isnew=2&smc=1&mSelect=false&tid=0&_input_charset=utf-8&json=on&module=page&data-key=s&s=%s&data-value=%s' % (category_id, (pagenum-2)*pagesize, (pagenum-1)*pagesize)
	return api_url

def main():
	if len(sys.argv) >= 3:
		category_id, pagenum = sys.argv[1:]
		url = get_category_url(category_id, int(pagenum))
		page_content = urlopen(url).read().decode('gbk')
		print loads(page_content)
	else:
		print "No taobao category_id provided!"
		sys.exit(1)

if __name__ == '__main__':
	main()