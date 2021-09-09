package com.facebook.react.views.text;

import java.text.BreakIterator;

public enum TextTransform {
    NONE,
    UPPERCASE,
    LOWERCASE,
    CAPITALIZE,
    UNSET;

    /* renamed from: com.facebook.react.views.text.TextTransform$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$views$text$TextTransform = new int[TextTransform.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$react$views$text$TextTransform[TextTransform.UPPERCASE.ordinal()] = 1;
            $SwitchMap$com$facebook$react$views$text$TextTransform[TextTransform.LOWERCASE.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$react$views$text$TextTransform[TextTransform.CAPITALIZE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static String apply(String str, TextTransform textTransform) {
        if (str == null) {
            return null;
        }
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$views$text$TextTransform[textTransform.ordinal()];
        if (i == 1) {
            return str.toUpperCase();
        }
        if (i == 2) {
            return str.toLowerCase();
        }
        if (i != 3) {
            return str;
        }
        return capitalize(str);
    }

    private static String capitalize(String str) {
        BreakIterator wordInstance = BreakIterator.getWordInstance();
        wordInstance.setText(str);
        StringBuilder sb = new StringBuilder(str.length());
        int first = wordInstance.first();
        while (true) {
            int i = first;
            first = wordInstance.next();
            if (first == -1) {
                return sb.toString();
            }
            String substring = str.substring(i, first);
            if (Character.isLetterOrDigit(substring.charAt(0))) {
                sb.append(Character.toUpperCase(substring.charAt(0)));
                sb.append(substring.substring(1).toLowerCase());
            } else {
                sb.append(substring);
            }
        }
    }
}
