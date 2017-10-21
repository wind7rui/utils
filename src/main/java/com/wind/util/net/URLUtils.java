package com.wind.util.net;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

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

    /**
     * @param url <code>String</code> to be translated.
     * @return the translated <code>String</code>.
     */
    public static String encodeToUTF8(String url) {
        return encode(url, "UTF-8");
    }

    /**
     * @param url     <code>String</code> to be translated.
     * @param charSet The name of a supported
     *                <a href="../lang/package-summary.html#charenc">character
     *                encoding</a>.
     * @return the translated <code>String</code>.
     */
    public static String encode(String url, String charSet) {
        try {
            return URLEncoder.encode(url, charSet);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * @param encodeUrl the <code>String</code> to decode
     * @return the newly decoded <code>String</code>
     */
    public static String decodeToUTF8(Optional<String> encodeUrl) {
        return decode(encodeUrl, "UTF-8");
    }

    /**
     * @param encodeUrl the <code>String</code> to decode
     * @param charSet   The name of a supported
     *                  <a href="../lang/package-summary.html#charenc">character
     *                  encoding</a>.
     * @return the newly decoded <code>String</code>
     */
    public static String decode(Optional<String> encodeUrl, String charSet) {
        if (Strings.isNullOrEmpty(charSet)) {
            charSet = "UTF-8";
        }
        try {
            return !encodeUrl.isPresent() ? "" : URLDecoder.decode(encodeUrl.get(), charSet);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Decode to " + charSet + " failed", e);
        }
    }

    public static boolean isValid(String url) {
        return url.matches("((http|ftp|https)://)(([\\w-]+\\.[a-zA-Z]{2,10})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3})|localhost)(:[0-9]{1,6})*(/[\\w%\\./-~-]*)?(\\?[\\w\\&%\\./-~-=]*)?$");
    }

}
