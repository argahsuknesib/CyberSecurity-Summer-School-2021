package com.xiaomi.miot.localtranslatesrv.ruleEngines.yaccEngine.ExpressionParser.DataConvertUtils.lockutils;

import java.io.PrintStream;

public class LockUtils {
    public static String RevertBytes(String str) {
        if (str.length() == 0) {
            return str;
        }
        if ((str.length() & 1) != 0) {
            PrintStream printStream = System.out;
            printStream.println(str + "invalid length");
            return str;
        }
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length / 2; i += 2) {
            swap(bytes, i, (bytes.length - i) - 2);
            swap(bytes, i + 1, (bytes.length - i) - 1);
        }
        return new String(bytes);
    }

    private static void swap(byte[] bArr, int i, int i2) {
        byte b = bArr[i];
        bArr[i] = bArr[i2];
        bArr[i2] = b;
    }
}
