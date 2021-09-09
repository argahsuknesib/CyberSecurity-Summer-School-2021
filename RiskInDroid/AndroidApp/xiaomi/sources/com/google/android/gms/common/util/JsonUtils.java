package com.google.android.gms.common.util;

import _m_j.jdn;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
public final class JsonUtils {
    private static final Pattern zzaae = Pattern.compile("\\\\.");
    private static final Pattern zzaaf = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        return areJsonValuesEquivalent(new org.json.JSONArray(r3), new org.json.JSONArray(r4));
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    public static boolean areJsonStringsEquivalent(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (!(str == null || str2 == null)) {
            return areJsonValuesEquivalent(new JSONObject(str), new JSONObject(str2));
        }
        return false;
    }

    public static boolean areJsonValuesEquivalent(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            JSONObject jSONObject2 = (JSONObject) obj2;
            if (jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!jSONObject2.has(next)) {
                    return false;
                }
                try {
                    if (!areJsonValuesEquivalent(jSONObject.get(next), jSONObject2.get(next))) {
                        return false;
                    }
                } catch (JSONException unused) {
                }
            }
            return true;
        } else if (!(obj instanceof JSONArray) || !(obj2 instanceof JSONArray)) {
            return obj.equals(obj2);
        } else {
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (jSONArray.length() != jSONArray2.length()) {
                return false;
            }
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    if (!areJsonValuesEquivalent(jSONArray.get(i), jSONArray2.get(i))) {
                        return false;
                    }
                    i++;
                } catch (JSONException unused2) {
                    return false;
                }
            }
            return true;
        }
    }

    public static String escapeString(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zzaaf.matcher(str);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char charAt = matcher.group().charAt(0);
            if (charAt == 12) {
                str2 = "\\\\f";
            } else if (charAt == 13) {
                str2 = "\\\\r";
            } else if (charAt == '\"') {
                str2 = "\\\\\\\"";
            } else if (charAt == '/') {
                str2 = "\\\\/";
            } else if (charAt != '\\') {
                switch (charAt) {
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        str2 = "\\\\b";
                        break;
                    case 9:
                        str2 = "\\\\t";
                        break;
                    case 10:
                        str2 = "\\\\n";
                        break;
                }
            } else {
                str2 = "\\\\\\\\";
            }
            matcher.appendReplacement(stringBuffer, str2);
        }
        if (stringBuffer == null) {
            return str;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static String unescapeString(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String unescape = UnicodeUtils.unescape(str);
        Matcher matcher = zzaae.matcher(unescape);
        StringBuffer stringBuffer = null;
        while (matcher.find()) {
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer();
            }
            char charAt = matcher.group().charAt(1);
            if (charAt == '\"') {
                str2 = jdn.f1779O000000o;
            } else if (charAt == '/') {
                str2 = "/";
            } else if (charAt == '\\') {
                str2 = "\\\\";
            } else if (charAt == 'b') {
                str2 = "\b";
            } else if (charAt == 'f') {
                str2 = "\f";
            } else if (charAt == 'n') {
                str2 = "\n";
            } else if (charAt == 'r') {
                str2 = "\r";
            } else if (charAt == 't') {
                str2 = "\t";
            } else {
                throw new IllegalStateException("Found an escaped character that should never be.");
            }
            matcher.appendReplacement(stringBuffer, str2);
        }
        if (stringBuffer == null) {
            return unescape;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
