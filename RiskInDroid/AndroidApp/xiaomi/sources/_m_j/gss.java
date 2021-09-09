package _m_j;

import java.util.Map;
import okhttp3.Headers;

public final class gss {
    public static Headers O000000o(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        return Headers.of(map);
    }

    public static void O000000o(String str) throws Exception {
        if (str == null) {
            throw new IllegalArgumentException("name == null");
        } else if (!str.isEmpty()) {
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if (charAt <= 31 || charAt >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i), str));
                }
            }
        } else {
            throw new IllegalArgumentException("name is empty");
        }
    }
}
