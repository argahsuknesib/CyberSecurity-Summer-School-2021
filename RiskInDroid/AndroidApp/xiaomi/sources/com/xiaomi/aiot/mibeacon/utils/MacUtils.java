package com.xiaomi.aiot.mibeacon.utils;

public class MacUtils {
    private static final char[] HEX_STR = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String btMacToWifiMac(String str) {
        String[] split = str.toUpperCase().split(":");
        StringBuilder sb = new StringBuilder();
        for (String append : split) {
            sb.append(append);
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        int length = sb2.length() - 1;
        int i = 1;
        int i2 = 0;
        while (length >= 0) {
            int hexNumIndex = getHexNumIndex(sb2.charAt(length));
            int i3 = (hexNumIndex - i) - i2;
            if (i3 >= 0) {
                sb3.append(HEX_STR[i3]);
                i2 = 0;
            } else {
                sb3.append(HEX_STR[((hexNumIndex + 16) - i) - i2]);
                i2 = 1;
            }
            length--;
            i = 0;
        }
        sb3.reverse();
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        for (int i4 = 0; i4 < sb3.length(); i4++) {
            if (i4 > 0 && i4 % 2 == 0) {
                sb5.append(":");
            }
            sb5.append(sb4.charAt(i4));
        }
        return sb5.toString();
    }

    private static int getHexNumIndex(char c) {
        int i = 0;
        for (char c2 : HEX_STR) {
            if (c2 == c) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
