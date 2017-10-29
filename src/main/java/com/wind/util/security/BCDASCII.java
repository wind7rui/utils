package com.wind.util.security;

/**
 * @author wind
 * @since 2015/11/10
 */
public class BCDASCII {


    public final static byte ALPHA_A_ASCII_VALUE = 0x41;


    public final static byte ALPHA_a_ASCII_VALUE = 0x61;


    public final static byte DIGITAL_0_ASCII_VALUE = 0x30;

    private BCDASCII() {
    }


    public static void fromBCDToASCII(byte[] bcdBuf, int bcdOffset, byte[] asciiBuf, int asciiOffset, int asciiLen,
                                      boolean rightAlignFlag) {
        int cnt;

        if (((asciiLen & 1) == 1) && rightAlignFlag) {
            cnt = 1;
            asciiLen++;
        } else
            cnt = 0;

        for (; cnt < asciiLen; cnt++, asciiOffset++) {
            asciiBuf[asciiOffset] = (byte) ((((cnt) & 1) == 1) ? (bcdBuf[bcdOffset++] & 0x0f)
                    : ((bcdBuf[bcdOffset] >> 4) & 0x0f));
            asciiBuf[asciiOffset] = (byte) (asciiBuf[asciiOffset] + ((asciiBuf[asciiOffset] > 9) ? (ALPHA_A_ASCII_VALUE - 10)
                    : DIGITAL_0_ASCII_VALUE));
        }
    }

    public static byte[] fromBCDToASCII(byte[] bcdBuf, int bcdOffset, int asciiLen, boolean rightAlignFlag) {
        byte[] asciiBuf = new byte[asciiLen];
        fromBCDToASCII(bcdBuf, bcdOffset, asciiBuf, 0, asciiLen, rightAlignFlag);

        return asciiBuf;
    }

    public static String fromBCDToASCIIString(byte[] bcdBuf, int bcdOffset, int asciiLen, boolean rightAlignFlag) {
        try {
            return new String(fromBCDToASCII(bcdBuf, bcdOffset, asciiLen, rightAlignFlag), "GBK");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public static void fromASCIIToBCD(byte[] asciiBuf, int asciiOffset, int asciiLen, byte[] bcdBuf, int bcdOffset,
                                      boolean rightAlignFlag) {
        int cnt;
        byte ch, ch1;

        if (((asciiLen & 1) == 1) && rightAlignFlag) {
            ch1 = 0;
        } else {
            ch1 = 0x55;
        }

        for (cnt = 0; cnt < asciiLen; cnt++, asciiOffset++) {
            if (asciiBuf[asciiOffset] >= ALPHA_a_ASCII_VALUE)
                ch = (byte) (asciiBuf[asciiOffset] - ALPHA_a_ASCII_VALUE + 10);
            else if (asciiBuf[asciiOffset] >= ALPHA_A_ASCII_VALUE)
                ch = (byte) (asciiBuf[asciiOffset] - ALPHA_A_ASCII_VALUE + 10);
            else if (asciiBuf[asciiOffset] >= DIGITAL_0_ASCII_VALUE)
                ch = (byte) (asciiBuf[asciiOffset] - DIGITAL_0_ASCII_VALUE);
            else
                ch = 0x00;

            if (ch1 == 0x55)
                ch1 = ch;
            else {
                bcdBuf[bcdOffset] = (byte) (ch1 << 4 | ch);
                bcdOffset++;
                ch1 = 0x55;
            }
        }

        if (ch1 != 0x55)
            bcdBuf[bcdOffset] = (byte) (ch1 << 4);
    }

    public static void fromASCIIToBCD(String asciiStr, int asciiOffset, int asciiLen, byte[] bcdBuf, int bcdOffset,
                                      boolean rightAlignFlag) {
        try {
            byte[] asciiBuf = asciiStr.getBytes("GBK");
            fromASCIIToBCD(asciiBuf, asciiOffset, asciiLen, bcdBuf, bcdOffset, rightAlignFlag);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public static byte[] fromASCIIToBCD(byte[] asciiBuf, int asciiOffset, int asciiLen, boolean rightAlignFlag) {
        byte[] bcdBuf = new byte[(asciiLen + 1) / 2];
        fromASCIIToBCD(asciiBuf, asciiOffset, asciiLen, bcdBuf, 0, rightAlignFlag);

        return bcdBuf;
    }

    public static byte[] fromASCIIToBCD(String asciiStr, int asciiOffset, int asciiLen, boolean rightAlignFlag) {
        try {
            byte[] asciiBuf = asciiStr.getBytes("GBK");
            return fromASCIIToBCD(asciiBuf, asciiOffset, asciiLen, rightAlignFlag);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}