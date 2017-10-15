package com.wind.util.logger;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.helpers.MessageFormatter;

/**
 * NEW Logger
 * <p>
 * NLogger实现了org.slf4j.Logger接口，使用{}作为日志信息占位符，支持N个占位符
 * </p>
 *
 * @author wind
 * @since 05.01.2017
 */
public class NLogger implements org.slf4j.Logger {

    private final org.slf4j.Logger logger;

    public NLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public String getName() {
        return logger.getName();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String msg) {
        logger.trace(msg);
    }

    @Override
    public void trace(String format, Object arg) {
        logger.trace(MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        logger.trace(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void trace(String format, Object... arguments) {
        logger.trace(MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void trace(String msg, Throwable t) {
        logger.trace(msg, t);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void trace(Marker marker, String msg) {
        logger.trace(marker, msg);
    }

    @Override
    public void trace(Marker marker, String format, Object arg) {
        logger.trace(marker, MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void trace(Marker marker, String format, Object arg1, Object arg2) {
        logger.trace(marker, MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void trace(Marker marker, String format, Object... argArray) {
        logger.trace(marker, MessageFormatter.arrayFormat(format, argArray).getMessage());
    }

    public void trace(Throwable t, String format, Object... arguments) {
        logger.trace(MessageFormatter.arrayFormat(format, arguments).getMessage(), t);
    }

    @Override
    public void trace(Marker marker, String msg, Throwable t) {
        logger.trace(marker, msg, t);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String msg) {
        logger.debug(msg);
    }

    @Override
    public void debug(String format, Object arg) {
        logger.debug(MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void debug(String format, Object arg1, Object arg2) {
        logger.debug(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void debug(String format, Object... arguments) {
        logger.debug(MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void debug(String msg, Throwable t) {
        logger.debug(msg, t);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return logger.isTraceEnabled(marker);
    }

    @Override
    public void debug(Marker marker, String msg) {
        logger.debug(marker, msg);
    }

    @Override
    public void debug(Marker marker, String format, Object arg) {
        logger.debug(marker, MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void debug(Marker marker, String format, Object arg1, Object arg2) {
        logger.debug(marker, MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void debug(Marker marker, String format, Object... arguments) {
        logger.debug(marker, MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    public void debug(Throwable t, String format, Object... arguments) {
        logger.debug(MessageFormatter.arrayFormat(format, arguments).getMessage(), t);
    }

    @Override
    public void debug(Marker marker, String msg, Throwable t) {
        logger.debug(marker, msg, t);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        logger.info(msg);
    }

    @Override
    public void info(String format, Object arg) {
        logger.info(MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        logger.info(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void info(String format, Object... arguments) {
        logger.info(MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    public void info(Throwable t, String format, Object... arguments) {
        logger.info(MessageFormatter.arrayFormat(format, arguments).getMessage(), t);
    }

    @Override
    public void info(String msg, Throwable t) {
        logger.info(msg, t);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(Marker marker, String msg) {
        logger.info(marker, msg);
    }

    @Override
    public void info(Marker marker, String format, Object arg) {
        logger.info(marker, MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void info(Marker marker, String format, Object arg1, Object arg2) {
        logger.info(marker, MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void info(Marker marker, String format, Object... arguments) {
        logger.info(marker, MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void info(Marker marker, String msg, Throwable t) {
        logger.info(marker, msg, t);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        logger.warn(msg);
    }

    @Override
    public void warn(String format, Object arg) {
        logger.warn(MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void warn(String format, Object... arguments) {
        logger.warn(MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void warn(String format, Object arg1, Object arg2) {
        logger.warn(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    public void warn(Throwable t, String format, Object... arguments) {
        logger.warn(MessageFormatter.arrayFormat(format, arguments).getMessage(), t);
    }

    @Override
    public void warn(String msg, Throwable t) {
        logger.warn(msg, t);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return logger.isWarnEnabled(marker);
    }

    @Override
    public void warn(Marker marker, String msg) {
        logger.warn(marker, msg);
    }

    @Override
    public void warn(Marker marker, String format, Object arg) {
        logger.warn(marker, MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void warn(Marker marker, String format, Object arg1, Object arg2) {
        logger.warn(marker, MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void warn(Marker marker, String format, Object... arguments) {
        logger.warn(marker, MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void warn(Marker marker, String msg, Throwable t) {
        logger.warn(marker, msg, t);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(String msg) {
        logger.error(msg);
    }

    @Override
    public void error(String format, Object arg) {
        logger.error(MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        logger.error(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void error(String format, Object... arguments) {
        logger.error(MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    public void error(Throwable t, String format, Object... arguments) {
        logger.error(MessageFormatter.arrayFormat(format, arguments).getMessage(), t);
    }

    @Override
    public void error(String msg, Throwable t) {
        logger.error(msg, t);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return logger.isErrorEnabled(marker);
    }

    @Override
    public void error(Marker marker, String msg) {
        logger.error(marker, msg);
    }

    @Override
    public void error(Marker marker, String format, Object arg) {
        logger.error(marker, MessageFormatter.format(format, arg).getMessage());
    }

    @Override
    public void error(Marker marker, String format, Object arg1, Object arg2) {
        logger.error(marker, MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    @Override
    public void error(Marker marker, String format, Object... arguments) {
        logger.error(marker, MessageFormatter.arrayFormat(format, arguments).getMessage());
    }

    @Override
    public void error(Marker marker, String msg, Throwable t) {
        logger.error(marker, msg, t);
    }
}
