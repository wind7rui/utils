package com.wind.util.validation;


import com.wind.util.validation.annotation.NotNull;

import java.lang.reflect.Field;

/**
 * 用于检查一个类中的包装类和String类型的属性值是否是null
 *
 * @author wind
 * @since 06.05.2013
 */
public class PropertyUtils {

    public static boolean hasNullValue(Object object) throws IllegalAccessException {
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            NotNull notNull = field.getAnnotation(NotNull.class);
            if (null == notNull) {
                field.setAccessible(false);
                continue;
            }

            if (null == field.get(object)) {
                field.setAccessible(false);
                return true;
            }

            field.setAccessible(false);
        }

        return false;
    }
}
