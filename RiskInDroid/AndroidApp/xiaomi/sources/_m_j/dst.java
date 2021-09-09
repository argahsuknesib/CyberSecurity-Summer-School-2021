package _m_j;

import com.google.android.exoplayer2.C;
import com.typesafe.config.ConfigException;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public final class dst {
    public static boolean O000000o(Object obj, Object obj2) {
        if (obj == null && obj2 != null) {
            return false;
        }
        if (obj != null && obj2 == null) {
            return false;
        }
        if (obj == obj2) {
            return true;
        }
        return obj.equals(obj2);
    }

    public static String O000000o(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 12) {
                sb.append("\\f");
            } else if (charAt == 13) {
                sb.append("\\r");
            } else if (charAt == '\"') {
                sb.append("\\\"");
            } else if (charAt != '\\') {
                switch (charAt) {
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    default:
                        if (!Character.isISOControl(charAt)) {
                            sb.append(charAt);
                            break;
                        } else {
                            sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String O00000Oo(String str) {
        if (str.length() == 0) {
            return O000000o(str);
        }
        int codePointAt = str.codePointAt(0);
        if (Character.isDigit(codePointAt) || codePointAt == 45) {
            return O000000o(str);
        }
        if (str.startsWith("include") || str.startsWith("true") || str.startsWith("false") || str.startsWith("null") || str.contains("//")) {
            return O000000o(str);
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!Character.isLetter(charAt) && !Character.isDigit(charAt) && charAt != '-') {
                return O000000o(str);
            }
        }
        return str;
    }

    public static boolean O000000o(int i) {
        if (i == 10 || i == 32 || i == 160 || i == 8199 || i == 8239 || i == 65279) {
            return true;
        }
        return Character.isWhitespace(i);
    }

    public static ConfigException O000000o(ExceptionInInitializerError exceptionInInitializerError) {
        Throwable cause = exceptionInInitializerError.getCause();
        if (cause != null && (cause instanceof ConfigException)) {
            return (ConfigException) cause;
        }
        throw exceptionInInitializerError;
    }

    static File O000000o(URL url) {
        try {
            return new File(url.toURI());
        } catch (URISyntaxException unused) {
            return new File(url.getPath());
        } catch (IllegalArgumentException unused2) {
            return new File(url.getPath());
        }
    }
}
