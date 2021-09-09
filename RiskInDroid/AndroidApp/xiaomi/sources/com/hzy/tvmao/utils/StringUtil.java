package com.hzy.tvmao.utils;

import _m_j.jdn;
import android.text.TextUtils;
import android.util.Base64;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String nullStrToEmpty(String str) {
        return str == null ? "" : str;
    }

    public static String base64Encode(String str) {
        return Base64.encodeToString(str.getBytes(), 0);
    }

    public static byte[] base64Decode(String str) {
        return Base64.decode(str, 0);
    }

    public static String getBuildString(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        LinkedHashSet<String> name = getName(str, str2);
        if (name.size() <= 0) {
            return null;
        }
        Iterator<String> it = name.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next() + ",");
        }
        PrintStream printStream = System.out;
        printStream.println("获得的上传的remotebuffer:" + stringBuffer.toString());
        String substring = stringBuffer.toString().substring(0, stringBuffer.toString().lastIndexOf(","));
        System.out.println("获得的上传的remote:".concat(String.valueOf(substring)));
        return substring;
    }

    public static LinkedHashSet<String> getName(String str, String str2) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (String add : str2.split(",")) {
            linkedHashSet.add(add);
        }
        for (String add2 : str.split(",")) {
            linkedHashSet2.add(add2);
        }
        linkedHashSet.removeAll(linkedHashSet2);
        return linkedHashSet;
    }

    public static long parseLong(String str) {
        try {
            return Long.parseLong(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNull(String str) {
        return str == null || str.length() == 0 || "null".equals(str);
    }

    public static String capitalizeFirstLetter(String str) {
        if (isNull(str)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!Character.isLetter(charAt) || Character.isUpperCase(charAt)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str.length());
        sb.append(Character.toUpperCase(charAt));
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static String utf8Encode(String str) {
        if (isNull(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String utf8Decode(String str) {
        if (isNull(str)) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
        }
    }

    public static String utf8Encode(String str, String str2) {
        if (isNull(str) || str.getBytes().length == str.length()) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            return str2;
        }
    }

    public static String getHrefInnerHtml(String str) {
        if (isNull(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile(".*<[\\s]*a[\\s]*.*>(.+?)<[\\s]*/a[\\s]*>.*", 2).matcher(str);
        return matcher.matches() ? matcher.group(1) : str;
    }

    public static String htmlEscapeCharsToString(String str) {
        return isNull(str) ? str : str.replaceAll("&lt;", "<").replaceAll("&gt;", ">").replaceAll("&amp;", "&").replaceAll("&quot;", jdn.f1779O000000o);
    }

    public static String fullWidthToHalfWidth(String str) {
        if (isNull(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 12288) {
                charArray[i] = ' ';
            } else if (charArray[i] < 65281 || charArray[i] > 65374) {
                charArray[i] = charArray[i];
            } else {
                charArray[i] = (char) (charArray[i] - 65248);
            }
        }
        return new String(charArray);
    }

    public static String halfWidthToFullWidth(String str) {
        if (isNull(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ' ') {
                charArray[i] = 12288;
            } else if (charArray[i] < '!' || charArray[i] > '~') {
                charArray[i] = charArray[i];
            } else {
                charArray[i] = (char) (charArray[i] + 65248);
            }
        }
        return new String(charArray);
    }

    public static final String md5(String str) {
        return md5(str.getBytes());
    }

    public static final String md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                byte b2 = b & 255;
                if (b2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(b2));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static boolean equals(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static int[] parseIntArray(String str) {
        return parseIntArray(str, ",");
    }

    public static int[] parseIntArray(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(str2);
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            iArr[i] = parseInt(split[i]);
        }
        return iArr;
    }

    public static String[] parseStringArray(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.split(str2);
    }

    public static String padStart(String str, int i, char c) {
        if (str.length() >= i) {
            return str;
        }
        StringBuilder sb = new StringBuilder(i);
        for (int length = str.length(); length < i; length++) {
            sb.append(c);
        }
        sb.append(str);
        return sb.toString();
    }

    public static String replaceBlank(String str) {
        if (str != null) {
            return Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        }
        return "";
    }

    public static byte[] hex2Bytes(String str) {
        String replaceAll = str.replaceAll("[^0-9,a-f,A-F]", "");
        byte[] bArr = new byte[(replaceAll.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) Integer.parseInt(replaceAll.substring(i2, i2 + 2), 16);
        }
        return bArr;
    }

    public static String sha(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bytes);
            return bytesToHex(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            byte b2 = b & 255;
            if (b2 < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(b2));
        }
        return stringBuffer.toString();
    }
}
