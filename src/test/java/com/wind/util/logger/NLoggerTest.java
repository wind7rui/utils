package com.wind.util.logger;

import org.junit.Test;

public class NLoggerTest {

    private static final NLogger LOGGER = NLoggerFactory.getLogger(NLoggerTest.class);

    @Test
    public void info() throws Exception {
        LOGGER.info("info(String msg)");
    }

    @Test
    public void info1() throws Exception {
        LOGGER.info("info arg:{}", "test");
    }

    @Test
    public void info2() throws Exception {
        LOGGER.info("info arg1:{},arg2:{}", "test1", "test2");
    }

    @Test
    public void info3() throws Exception {
        LOGGER.info("info arg1:{},arg2:{},arg3:{},arg4:{}", "test1", "test2", "arg3", "arg4");
    }

    @Test
    public void info4() throws Exception {
        LOGGER.info("info arg", new RuntimeException("abc"));
    }

    @Test
    public void info5() throws Exception {
        LOGGER.info(new RuntimeException("abc"), "info arg:{}", "test");
    }

}