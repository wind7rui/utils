package com.wind.util.net;

import com.google.common.base.Optional;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url转码及验证工具类
 *
 * @author wind
 * @since 2014/3/11
 */
public class URLUtils {

    public static String encodeToUTF8(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Encode to UTF8 failed", e);
        }
    }

    public static String encode(String value, String charSet) {
        try {
            return URLEncoder.encode(value, charSet);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static String decodeToUTF8(Optional<String> encodeUrl) {
        try {
            return !encodeUrl.isPresent() ? "" : URLDecoder.decode(encodeUrl.get(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Decode to UTF8 failed", e);
        }
    }

    public static boolean isValid(String url) {
        return url.matches("((http|ftp|https)://)(([\\w-]+\\.[a-zA-Z]{2,10})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|localhost)(:[0-9]{1,6})*(/[\\w%\\./-~-]*)?(\\?[\\w\\&%\\./-~-=]*)?$");
    }

}
