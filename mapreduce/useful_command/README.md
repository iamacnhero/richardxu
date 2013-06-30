Useful command
==================

Sqoop
-----------------
* 从MySQL向HDFS导入数据: 
<pre><code>
sqoop import -m 5 --direct --connect jdbc:mysql://192.168.0.67/guang --username analyze -P --table guang_access_log --target-dir /tmp/xufeng/access_log/import</code></pre>

