Useful command
==================

Sqoop
-----------------
* 从MySQL向HDFS导入数据: 
<pre><code>
sqoop import -m 5 --direct --connect jdbc:mysql://192.168.0.67/merchant --username analyze --password 123456 --table access_log --target-dir /tmp/xufeng/access_log/import
</code></pre>
* 从HDFS向MySQL中导入数据
<pre><code>
sqoop export -m 1 --connect jdbc:mysql://192.168.0.67/merchant --username analyze -P --table access_log --export-dir /tmp/xufeng/access_log/import  --input-fields-terminated-by ',' --mysql-delimiters
</code></pre>
