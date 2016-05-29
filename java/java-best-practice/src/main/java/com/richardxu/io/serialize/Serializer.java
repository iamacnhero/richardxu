package com.richardxu.io.serialize;

import java.io.IOException;


/**
 * 序列化接口
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2016年5月29日
 */
public interface Serializer {

    byte[] serialize(Object object) throws IOException;

    Object deserialize(byte[] data) throws IOException, ClassNotFoundException;
}
