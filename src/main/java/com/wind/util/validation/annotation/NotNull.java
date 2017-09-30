package com.wind.util.validation.annotation;

import java.lang.annotation.*;

/**
 * 用于标注在包装类和String类型的属性上
 *
 * @author wind
 * @since 06.05.2013
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {

}
