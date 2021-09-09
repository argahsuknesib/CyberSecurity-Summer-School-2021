package _m_j;

import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public final class iin {
    public static Bundle O000000o(String str) {
        try {
            URL url = new URL(str);
            Bundle O00000Oo = O00000Oo(url.getQuery());
            O00000Oo.putAll(O00000Oo(url.getRef()));
            return O00000Oo;
        } catch (MalformedURLException unused) {
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }
}
