package com.wind.util.security;

import com.wind.util.logger.NLogger;
import com.wind.util.logger.NLoggerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class Base64Test {

    private static final NLogger LOGGER = NLoggerFactory.getLogger(Base64Test.class);


    @Test
    public void encodeToByte() throws Exception {
        byte[] s1 = Base64.encodeToByte("abc".getBytes(), false);
        LOGGER.info("after encode s1:{}", new String(s1));
    }

    @Test
    public void decode() throws Exception {
        byte[] s2 = Base64.decodeFast(Base64.encodeToByte("abc".getBytes(), false));
        LOGGER.info("after decode s2:{}", new String(s2));
    }

}