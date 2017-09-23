package com.wind.utils.validation;

import org.junit.Test;

public class PropertyUtilsTest {

    @Test
    public void should_return_false() throws IllegalAccessException {
        User user = new User();
        user.setId(100L);
        user.setName("wind");

        System.out.println(PropertyUtils.hasNullValue(user));
    }

    @Test
    public void should_return_true() throws IllegalAccessException {
        User user = new User();
        user.setId(100L);

        System.out.println(PropertyUtils.hasNullValue(user));
    }
}
