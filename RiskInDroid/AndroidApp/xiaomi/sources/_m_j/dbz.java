package _m_j;

import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;

public final class dbz {
    public static Bundle O000000o(String str) {
        try {
            return O00000Oo(new URI(str).getQuery());
        } catch (Exception unused) {
            return new Bundle();
        }
    }

    private static Bundle O00000Oo(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }
}
