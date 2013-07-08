package com.richardxu.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author xufeng
 * Map 过程需要继承 org.apache.hadoop.mapreduce包中的Mapper类, 并重写其map方法
 */
public class WordMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
    private Text word = new Text();

    /* 
	 * 提取出IP 并计数
     * @see org.apache.hadoop.mapreduce.Mapper#map(KEYIN, VALUEIN, org.apache.hadoop.mapreduce.Mapper.Context)
     */
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String[] s = line.split("\\s+");
    	if (s[0].matches("(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((25[0-5])|(\\d{1,2})|(1\\d{2})|(2[0-4]\\d))")) {
    		System.out.println(s[0]);
    		word.set(s[0]);
        	context.write(word, new IntWritable(1));
        }
    }
}
