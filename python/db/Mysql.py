# -*- encoding: utf-8 -*-
from __future__ import unicode_literals

import MySQLdb

class Mysql(object):
    def __init__(self, host, db, dbConfigFile, port=3306, charset='utf8'):
        self.host = host
        self.db = db
        self.dbConfigFile = dbConfigFile
        self.port = port
        self.charset = charset
        self.conn = MySQLdb.connect(read_default_file=dbConfigFile, host=host, db=db, port=port, charset='utf8')
        self.cursor = self.conn.cursor()
    
    def queryForDict(self, query):
        self.cursor.execute(query)
        col_names = [desc[0] for desc in self.cursor.description]
        while True:
            row = self.cursor.fetchone()
            if row is None:
                break
            row_dict = dict(izip(col_names, row))
            yield row_dict
        return

    def query(self, query):
        self.cursor.execute(query)
        return self.cursor.fetchall()


    def execute(self, query):
        self.cursor.execute(query)
        self.conn.commit()
        
    def queryForOne(self, query):
        self.cursor.execute(query)
        return self.cursor.fetchone()
        
    
    
    
