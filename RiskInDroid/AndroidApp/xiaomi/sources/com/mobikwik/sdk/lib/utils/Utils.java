package com.mobikwik.sdk.lib.utils;

import android.app.Activity;
import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Utils {
    public static char[] allowedFirstDigitsInMobileNum = {'7', '8', '9'};

    public static String encrypt(String str) {
        StringBuilder sb;
        if (str.contains("@")) {
            String[] split = str.split("@");
            String str2 = split[0];
            String str3 = split[1];
            int length = str2.length() / 2;
            String substring = str2.substring(0, length);
            for (int length2 = str2.length() - length; length2 > 0; length2--) {
                substring = substring + "*";
            }
            sb = new StringBuilder();
            sb.append(substring);
            sb.append("@");
            sb.append(str3);
        } else {
            String substring2 = str.substring(7);
            String substring3 = str.substring(0, 2);
            sb = new StringBuilder();
            sb.append(substring3);
            sb.append("*****");
            sb.append(substring2);
        }
        return sb.toString();
    }

    public static void hideKeyBoard(View view) {
        try {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidEmail(EditText editText) {
        if (isValidEmail(editText.getText().toString())) {
            return true;
        }
        editText.setError("Enter Valid Email Id");
        editText.requestFocus();
        return false;
    }

    public static boolean isValidEmail(String str) {
        return Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }

    public static boolean isValidMobile(EditText editText) {
        if (isValidMobile(editText.getText().toString())) {
            return true;
        }
        editText.setError("Enter valid 10 digit number");
        editText.requestFocus();
        return false;
    }

    public static boolean isValidMobile(String str) {
        if (str != null && str.trim().length() == 10) {
            for (char c : allowedFirstDigitsInMobileNum) {
                if (c == str.charAt(0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void print(String str) {
    }

    private static void proceedAfterMappingCheck(Activity activity, Intent intent) {
    }

    public static void sendResultBack(Activity activity, Intent intent, String str, String str2) {
        Intent intent2 = new Intent();
        if (intent != null) {
            intent2 = new Intent(intent);
        }
        if (isNull(intent2.getStringExtra("statuscode"))) {
            if (isNull(str)) {
                intent2.putExtra("statuscode", "1");
            } else {
                intent2.putExtra("statuscode", str);
            }
        }
        if (isNull(intent2.getStringExtra("statusmessage"))) {
            if (isNull(str)) {
                intent2.putExtra("statusmessage", "Something went bad");
            } else {
                intent2.putExtra("statusmessage", str2);
            }
        }
        activity.setResult(1, intent2);
        activity.finish();
    }

    public static String utf8Encode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return URLEncoder.encode(str);
        }
    }
}
