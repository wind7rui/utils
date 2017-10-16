package com.wind.util.random;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 生成指定进制的UUID
 *
 * @author wind
 * @since 10.6.2015
 */
public class UUIDUtils {

    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
            'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
            'Z'};

    private static final Map<Character, Integer> digitMap = new HashMap<>();
    private static final int MAX_RADIX = digits.length;
    private static final int MIN_RADIX = 2;

    static {
        for (int i = 0; i < digits.length; i++) {
            digitMap.put(digits[i], i);
        }
    }

    /**
     * 生成指定进制的UUID, 进制值2~62（字母加数字）, 生成字符串长度19~128位。
     * 当radix=16时, 方法同UUID.randomUUID().toString()
     */
    public static String randomUUID(int radix) {
        UUID uuid = UUID.randomUUID();
        return digits(uuid.getMostSignificantBits() >> 32, 8, radix) +
                digits(uuid.getMostSignificantBits() >> 16, 4, radix) +
                digits(uuid.getMostSignificantBits(), 4, radix) +
                digits(uuid.getLeastSignificantBits() >> 48, 4, radix) +
                digits(uuid.getLeastSignificantBits(), 12, radix);
    }

    private static String digits(long val, int digits, int radix) {
        long hi = 1L << (digits * 4);
        return UUIDUtils.toString(hi | (val & (hi - 1)), radix).substring(1);
    }

    /**
     * 将长整型数值转换为指定的进制数（最大支持62进制，字母数字已经用尽）
     *
     * @param radix 进制
     */
    private static String toString(long i, int radix) {
        if (radix < MIN_RADIX || radix > MAX_RADIX) {
            radix = 10;
        }

        final int size = 65;
        int charPos = 64;

        char[] buf = new char[size];
        boolean negative = (i < 0);

        if (!negative) {
            i = -i;
        }

        while (i <= -radix) {
            buf[charPos--] = digits[(int) (-(i % radix))];
            i = i / radix;
        }
        buf[charPos] = digits[(int) (-i)];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (size - charPos));
    }

}
