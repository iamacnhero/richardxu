package com.richardxu.gof.simplefactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * 一个解决的方法是使用配置文件，当有了新的实现类后，只要在配置文件里添加上新的实现类即可。在简单工厂的方法里面可以使用反射，
 * 当然也可以使用IoC/DI（控制反转/依赖注入）来实现。
 * 下面的示例以反射加上配置文件，来实现添加新的实现类后，无须修改代码。配置文件使用最简单的properties文件，实际开发多用xml配置。
 * 
 * @author <a href="mailto:463692574@qq.com">许峰</a>
 * @version 1.0
 * @since 2015年10月27日
 */
public class ConfigurableFactory {
    public static Api createApi() {
        Properties p = new Properties();
        InputStream in = null;
        try {
            in = Factory.class.getResourceAsStream("factory.properties");
            p.load(in);
        } catch (Exception e) {
            System.out.println("装载工厂配置文件出错!");
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        // 用反射去创建，那些例外处理等完善的工作这里就不做了
        Api api = null;
        try {
            api = (Api) Class.forName(p.getProperty("ImplClass")).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return api;
    }
}