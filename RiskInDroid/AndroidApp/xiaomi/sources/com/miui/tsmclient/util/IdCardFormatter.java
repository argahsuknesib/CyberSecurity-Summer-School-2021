package com.miui.tsmclient.util;

import _m_j.ayt;
import android.text.Editable;
import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class IdCardFormatter extends Formatter {
    private static int[] ID_CARD_SEP = {6, 10, 14};

    public boolean isValidCharacter(char c) {
        return Character.isDigit(c) || 'x' == Character.toLowerCase(c);
    }

    public void format(Editable editable) {
        clean(editable);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < editable.length()) {
            int[] iArr = ID_CARD_SEP;
            if (i2 < iArr.length && i3 == iArr[i2]) {
                editable.insert(i, Character.toString(this.SEPARATOR));
                i2++;
                i++;
            }
            i++;
            i3++;
        }
    }

    public boolean isValid(String str) {
        return checkIDCardNum(str);
    }

    private boolean checkIDCardNum(String str) {
        String str2;
        String str3 = str;
        if (!TextUtils.isEmpty(str) && str3.matches("^\\d{15}|\\d{17}[Xx\\d]$")) {
            String[] strArr = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};
            String[] strArr2 = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
            if (str.length() != 15 && str.length() != 18) {
                return false;
            }
            if (str.length() == 18) {
                str2 = str3.substring(0, 17);
            } else {
                str2 = str3.substring(0, 6) + "19" + str3.substring(6, 15);
            }
            if (!isNumeric(str2)) {
                return false;
            }
            String substring = str2.substring(6, 10);
            String substring2 = str2.substring(10, 12);
            String substring3 = str2.substring(12, 14);
            if (!isDate(substring + "-" + substring2 + "-" + substring3)) {
                return false;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                if (gregorianCalendar.get(1) - Integer.parseInt(substring) <= 150) {
                    if (gregorianCalendar.getTime().getTime() - simpleDateFormat.parse(substring + "-" + substring2 + "-" + substring3).getTime() < 0 || Integer.parseInt(substring2) > 12 || Integer.parseInt(substring2) == 0 || Integer.parseInt(substring3) > 31 || Integer.parseInt(substring3) == 0 || getRegionMap().get(str2.substring(0, 2)) == null) {
                        return false;
                    }
                    int i = 0;
                    for (int i2 = 0; i2 < 17; i2++) {
                        i += Integer.parseInt(String.valueOf(str2.charAt(i2))) * Integer.parseInt(strArr2[i2]);
                    }
                    String str4 = str2 + strArr[i % 11];
                    if (str.length() != 18 || str4.equals(str3)) {
                        return true;
                    }
                    return false;
                }
            } catch (ParseException unused) {
            }
        }
        return false;
    }

    private HashMap<String, String> getRegionMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("11", "??????");
        hashMap.put("12", "??????");
        hashMap.put("13", "??????");
        hashMap.put("14", "??????");
        hashMap.put("15", "?????????");
        hashMap.put("21", "??????");
        hashMap.put("22", "??????");
        hashMap.put(ayt.f12712O000000o, "?????????");
        hashMap.put("31", "??????");
        hashMap.put("32", "??????");
        hashMap.put("33", "??????");
        hashMap.put("34", "??????");
        hashMap.put("35", "??????");
        hashMap.put("36", "??????");
        hashMap.put("37", "??????");
        hashMap.put("41", "??????");
        hashMap.put("42", "??????");
        hashMap.put("43", "??????");
        hashMap.put("44", "??????");
        hashMap.put("45", "??????");
        hashMap.put("46", "??????");
        hashMap.put("50", "??????");
        hashMap.put("51", "??????");
        hashMap.put("52", "??????");
        hashMap.put("53", "??????");
        hashMap.put("54", "??????");
        hashMap.put("61", "??????");
        hashMap.put("62", "??????");
        hashMap.put("63", "??????");
        hashMap.put("64", "??????");
        hashMap.put("65", "??????");
        hashMap.put("71", "??????");
        hashMap.put("81", "??????");
        hashMap.put("82", "??????");
        hashMap.put("91", "??????");
        return hashMap;
    }

    private boolean isNumeric(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[0-9]*");
    }

    private boolean isDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
    }
}
