package com.mobikwik.sdk.lib.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public class ParamSanitizer {
    public static String SanitizeURLParam(String str) {
        return (str != null && Pattern.compile("^(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]").matcher(str).matches()) ? encodeUrl(str) : "";
    }

    public static String encodeUrl(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return URLEncoder.encode(str);
        }
    }

    public static String sanitizeParam(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("[>><>(){}?&* ~`!#$%^=+|\\:'\";,\\x5D\\x5B]+", " ");
    }
}
