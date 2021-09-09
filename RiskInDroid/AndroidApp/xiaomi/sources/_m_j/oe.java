package _m_j;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class oe {
    public static boolean O000000o(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String O000000o(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb.append("    at ");
            sb.append(stackTraceElement.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static Map<String, String> O000000o(Uri uri) {
        String str;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            String substring = encodedQuery.substring(i, indexOf2);
            if (!TextUtils.isEmpty(substring)) {
                if (indexOf2 == indexOf) {
                    str = "";
                } else {
                    str = encodedQuery.substring(indexOf2 + 1, indexOf);
                }
                linkedHashMap.put(Uri.decode(substring), Uri.decode(str));
            }
            i = indexOf + 1;
        } while (i < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static String O000000o(String str) {
        return (!str.contains("|") || str.endsWith("|")) ? str : str.substring(0, str.indexOf("|"));
    }
}
