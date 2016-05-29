package com.richardxu.io.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * Hessian的序列化
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2016年5月29日
 */
public class HessianSerializer {

    public static byte[] serialize(Object object) throws IOException {
        final byte[] bytes;
        // 定义一个字节数组输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // 对象输出流
        HessianOutput objectOutputStream = new HessianOutput(outputStream);
        // 将对象写入到字节数组输出，进行序列化
        objectOutputStream.writeObject(object);
        bytes = outputStream.toByteArray();
        objectOutputStream.close();
        outputStream.close();
        return bytes;
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        final Object obj;
        // 字节数组输入流
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        // 执行反序列化，从流中读取对象
        final HessianInput objectInputStream = new HessianInput(inputStream);
        obj = objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        return obj;
    }
    
//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        UserModel user = new UserModel();
//        user.setUserId("1");
//        user.setName("zhangsan");
//        user.setGender("Male");
//        user.setDeptId("AAA");
//        
//        byte[] data = HessianSerializer.serialize(user);
//        
//        user = (UserModel) HessianSerializer.deserialize(data);
//        System.out.println(user);
//    }

}