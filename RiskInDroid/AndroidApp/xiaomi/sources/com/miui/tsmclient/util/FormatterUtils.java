package com.miui.tsmclient.util;

import android.widget.EditText;

public class FormatterUtils {

    public enum FormatterType {
        TYPE_CARD_NUM(new CardNumFormatter()),
        TYPE_VALID_DATE(new ValidDateFormatter()),
        TYPE_PHONE(new PhoneFormatter()),
        TYPE_ID_CARD(new IdCardFormatter()),
        TYPE_QR_CODE(new QRCodeFormatter()),
        TYPE_STAR(new StarFormatter());
        
        private Formatter mFormatter;

        private FormatterType(Formatter formatter) {
            this.mFormatter = formatter;
        }

        public final Formatter getFormatter() {
            return this.mFormatter;
        }
    }

    public static void setFormatter(EditText editText, FormatterType formatterType) {
        formatterType.getFormatter().bindFormattingTextWatcher(editText);
    }

    public static String clean(String str) {
        return clean(str, FormatterType.TYPE_CARD_NUM);
    }

    public static String clean(String str, FormatterType formatterType) {
        return formatterType.getFormatter().clean(str);
    }

    public static String format(String str, FormatterType formatterType) {
        return formatterType.getFormatter().format(str);
    }

    public static boolean isValid(String str, FormatterType formatterType) {
        return formatterType.getFormatter().isValid(formatterType.getFormatter().clean(str));
    }
}
