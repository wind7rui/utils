package com.wind.util.logger;

public class NLoggerFactory {

    public static NLogger getLogger(final Class<?> clazz) {
        return new NLogger(org.slf4j.LoggerFactory.getLogger(clazz));
    }

    public static NLogger getLogger(final String loggerName) {
        return new NLogger(org.slf4j.LoggerFactory.getLogger(loggerName));
    }
}
