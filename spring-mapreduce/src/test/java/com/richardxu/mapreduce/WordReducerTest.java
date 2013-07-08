package com.richardxu.mapreduce;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import com.richardxu.mapreduce.WordReducer;

import java.io.IOException;
import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

/**
 * @author xufeng
 */
public class WordReducerTest {
    private static final String NOT_TARGET_WORD = "foobar";
    private Reducer.Context contextMock;
    private WordReducer reducer;

    @Before
    public void setUp() {
        contextMock = mock(Reducer.Context.class);
        reducer = new WordReducer();
    }
    
    @Test
    public void test() {
    	String line = "183.128.139.98 - - [06/Jul/2013:00:00:01 +0800] \"GET /hot-event7 HTTP/1.1\" 200 398 \"http://www.baidu.com/s?wd=%E5%8A%A8%E7%89%A9%E4%B9%8B%E6%A3%AE+%E6%89%A9%E5%BB%BA%E6%88%BF%E5%B1%8B&rsv_bp=0&ch=1&tn=98067068_dg&bar=&rsv_spt=3&rsv_sug3=19&rsv_sug1=17&rsv_sug4=5445&inputT=12248";
    	String[] s = line.split("\\s+");
    	if (s[0].matches("(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((25[0-5])|(\\d{1,2})|(1\\d{2})|(2[0-4]\\d))")) {
    		System.out.println(s[0]);
    	}
    }

    @Test
    public void reduceWhenTargetWordIsFound() throws IOException, InterruptedException {
        Text key = new Text("192.168.0.1");
        Iterable<IntWritable> values = createValues(1, 1, 1);
        reducer.reduce(key, values, contextMock);

        ArgumentCaptor<IntWritable> countArgument = ArgumentCaptor.forClass(IntWritable.class);

        verify(contextMock, times(1)).write(eq(key), countArgument.capture());
        verifyNoMoreInteractions(contextMock);

        IntWritable count = countArgument.getValue();
        assertEquals(3, count.get());
    }

//    @Test
//    public void reduceWhenTargetWordIsNotFound() throws IOException, InterruptedException {
//        Text key = new Text("192.168.0.1");
//        Iterable<IntWritable> values = createValues(1, 1, 1);
//        reducer.reduce(key, values, contextMock);
//
//        verifyZeroInteractions(contextMock);
//    }

    private Iterable<IntWritable> createValues(int ... values) {
        ArrayList<IntWritable> list = new ArrayList<IntWritable>();

        for (int value: values) {
            list.add(new IntWritable(value));
        }

        return list;
    }
}
