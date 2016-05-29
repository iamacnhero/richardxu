package com.richardxu.io.serialize;

import java.io.*;

/**
 * jdk默认的序列化
 *
 * @author peiyu
 */
public class JdkSerializer implements Serializer {

    @Override
    public byte[] serialize(Object object) throws IOException {
        final byte[] bytes;
        // 定义一个字节数组输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 对象输出流
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        // 将对象写入到字节数组输出，进行序列化
        objectOutputStream.writeObject(object);
        bytes = outputStream.toByteArray();
        objectOutputStream.close();
        outputStream.close();
        return bytes;
    }

    @Override
    public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        final Object obj;
        // 字节数组输入流
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        // 执行反序列化，从流中读取对象
        final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        obj = objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        return obj;
    }

}