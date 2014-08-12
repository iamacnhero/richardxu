package com.richardxu.common.lang;

import java.util.Random;

/**
 * @author <a href="mailto:richardxu@live.cn">xufeng</a>
 * @date 2014-8-12 下午12:27:45
 *
 */
public final class EnumUtil {
    private static Random rand = new Random();

    private EnumUtil() {

    }

    public static <T extends Enum<T>, F extends Enum<F>> Enum<T> mapping(
            Class<T> type, Enum<F> from) {
        String name = from.name();
        return Enum.valueOf(type, name);
    }
    
    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
    
    /**
     * 随机返回一个枚举类里的元素
     * @param ec
     * @return
     */
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }
    
}