package com.tiqiaa.icontrol.util;

import java.util.Locale;

public class LanguageUtils {
    public static int getLang() {
        Locale locale = Locale.getDefault();
        if (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.PRC) || locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            return 0;
        }
        if (locale.equals(Locale.TAIWAN) || locale.equals(Locale.TRADITIONAL_CHINESE)) {
            return 1;
        }
        if (locale.equals(Locale.ENGLISH) || locale.equals(Locale.US) || locale.equals(Locale.UK) || locale.equals(Locale.CANADA)) {
            return 2;
        }
        if (locale.equals(Locale.CANADA_FRENCH) || locale.equals(Locale.FRANCE) || locale.equals(Locale.FRENCH)) {
            return 3;
        }
        if (locale.equals(Locale.GERMAN) || locale.equals(Locale.GERMANY)) {
            return 4;
        }
        if (locale.equals(Locale.ITALIAN) || locale.equals(Locale.ITALY)) {
            return 5;
        }
        if (locale.equals(Locale.JAPAN) || locale.equals(Locale.JAPANESE)) {
            return 7;
        }
        return (locale.equals(Locale.KOREA) || locale.equals(Locale.KOREAN)) ? 6 : -1;
    }
}
