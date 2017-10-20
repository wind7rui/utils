package com.wind.util.security;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5Test {

    @Test
    public void md5Hex() throws Exception {
        System.out.println(MD5.md5Hex("摘要算法"));
    }

    @Test
    public void md5HexWithUpperCase() throws Exception {
        System.out.println(MD5.md5HexWithUpperCase("摘要算法"));
    }

}