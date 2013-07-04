#!/usr/bin/evn python
# -*- encoding: utf-8 -*-
# author: richardxu
# time: 2013-07-04
# purpose: 解析淘宝店铺搜索页面, 得到店铺信息
# clean data first: UPDATE shop SET `type`=NULL, `url`=NULL, `vip_level`=NULL, `description_rate`=NULL, `service_attitude`=NULL, `deliver_speed`=NULL, `month_sales`=NULL;

import re
import urllib2
import MySQLdb
from simplejson import loads
from BeautifulSoup import BeautifulSoup

def process_sign(i):
	''' 处理数字的正负号,正数加+, 负数加- '''
	if not i.startswith('-'):
		return '+' + i
	else:
		return i

def get_shop_list(conn):
	cursor = conn.cursor()
	query = "SELECT id, name FROM shop WHERE id >= 282"
	cursor.execute(query)
	return cursor.fetchall()

def update_shop_info(conn, type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales, id):
	cursor = conn.cursor()
	query = ''' 
		UPDATE 
			shop 
		SET 
			`type` = '%s', url = "%s", vip_level = %s, description_rate = "%s",
			service_attitude = "%s", deliver_speed = "%s", month_sales = %s
		WHERE
			id = %s
		''' % (type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales, id)
	print query
	cursor.execute(query)
	conn.commit()

def get_vip_level(content):
	''' 得到店铺信誉级别 '''
	pattern = 'class="rank seller-rank-(\d+)"'
	return re.findall(pattern, content)[0]

def get_shop_info_by_name(shop_name):
	url = 'http://shopsearch.taobao.com/search?q=%s&rele_field=wangwang&fs=1' % shop_name.encode('utf8')
	content = urllib2.urlopen(url).read()
	soup = BeautifulSoup(content.decode('gbk'))
	result_shop_num = soup.find("span", {"class": "shop-count"}).find('b').text	# 搜索到的相关店铺数量
	print result_shop_num
	if int(result_shop_num) == 0:
		return False
	url = soup.find("span", {"class": "shop-info-list"}).find('a').get('href')	# 店铺URL
	
	# product_num = soup.find("span", {"class": "pro-sale-num"}).findAll('em')[0].text	# 宝贝数
	month_sales = soup.find("span", {"class": "pro-sale-num"}).findAll('em')[1].text	# 月销量
	
	dsr = loads(soup.find("div", {"class": "descr rank-dynamic J_descr"}).get("dsr"))	# 店铺动态评分
	description_rate = process_sign(dsr.get('mg').replace('%', ''))	# 描述相符
	service_attitude = process_sign(dsr.get('sg').replace('%', ''))	# 服务态度
	deliver_speed = process_sign(dsr.get('cg').replace('%', ''))	# 发货速度
	shop_type = "taobao"
	try:
		vip_level = get_vip_level(content)	# 得到店铺信誉级别
	except:
		shop_type = "tmall"
		vip_level = -100
	print shop_type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales
	return shop_type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales

def main():
	conn = MySQLdb.connect(host='127.0.0.1', user='root', passwd='123456', db='foo', port=3306, charset='utf8')
	shop_list = get_shop_list(conn)
	for row in shop_list:
		(id, name) = row
		print id, name

		shop_info = get_shop_info_by_name(name)
		if shop_info:
			shop_type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales = get_shop_info_by_name(name)
			update_shop_info(conn, shop_type, url, vip_level, description_rate, service_attitude, deliver_speed, month_sales, id)
	
if __name__ == '__main__':
	main()
