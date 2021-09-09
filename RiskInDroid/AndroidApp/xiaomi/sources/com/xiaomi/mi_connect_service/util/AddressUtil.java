package com.xiaomi.mi_connect_service.util;

public class AddressUtil {
    public static String convertMacAddressToString(byte[] bArr) {
        if (bArr == null || bArr.length != 6) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x:", Byte.valueOf(bArr[i])));
        }
        String sb2 = sb.toString();
        return sb2.substring(0, sb2.length() - 1);
    }

    public static byte[] convertStringToMacAddress(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(":");
        if (split.length != 6) {
            return null;
        }
        byte[] bArr = new byte[6];
        for (int i = 0; i < split.length; i++) {
            bArr[i] = (byte) (Integer.parseInt(split[i], 16) & 255);
        }
        return bArr;
    }
}
