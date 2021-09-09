package com.tiqiaa.icontrol.util;

public class UserVerifier {
    public static boolean isValidPhone(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("[1][3578]\\d{9}");
    }

    public static boolean isValidEmail(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    }

    public static boolean isValidName(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9_一-龥]{5,20}+$");
    }

    public static boolean isValidPassword(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return str.matches("^[a-z,A-Z0-9_]{6,16}$");
    }
}
