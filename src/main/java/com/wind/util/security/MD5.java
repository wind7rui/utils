package com.wind.util.security;

import com.google.common.base.Charsets;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.google.common.base.Strings.isNullOrEmpty;

/**
 * MD5
 *
 * @author wind
 * @since 2015/5/11
 */
public class MD5 {

    private MD5() {
    }

    static MessageDigest getDigest() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }


    private static byte[] md5(String data) {
        return md5(data.getBytes(Charsets.UTF_8));
    }

    public static String md5Hex(String data) {
        return isNullOrEmpty(data) ? "" : HexUtil.toHexString(md5(data));
    }

    /**
     * 转成大写字母的MD5值
     *
     * @param data
     * @return
     */
    public static String md5HexWithUpperCase(String data) {
        return isNullOrEmpty(data) ? "" : md5Hex(data).toUpperCase();
    }
}
