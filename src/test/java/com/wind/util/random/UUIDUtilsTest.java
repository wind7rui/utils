package com.wind.util.random;

import com.wind.util.logger.NLogger;
import com.wind.util.logger.NLoggerFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class UUIDUtilsTest {

    private static final NLogger LOGGER = NLoggerFactory.getLogger(UUIDUtilsTest.class);

    @Test
    public void randomUUID() throws Exception {
        LOGGER.info("生成二进制UUID：{}", UUIDUtils.randomUUID(2));
        LOGGER.info("生成八进制UUID：{}", UUIDUtils.randomUUID(8));
        LOGGER.info("生成十进制UUID：{}", UUIDUtils.randomUUID(10));
        LOGGER.info("生成十二进制UUID：{}", UUIDUtils.randomUUID(12));
    }

}