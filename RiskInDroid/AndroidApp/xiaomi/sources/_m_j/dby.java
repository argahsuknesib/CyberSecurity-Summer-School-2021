package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;

public final class dby {
    public static Bundle O000000o(String str) {
        try {
            URL url = new URL(str);
            Bundle O00000o0 = O00000o0(url.getQuery());
            O00000o0.putAll(O00000o0(url.getRef()));
            return O00000o0;
        } catch (MalformedURLException unused) {
            return new Bundle();
        }
    }

    private static Bundle O00000o0(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    if (split2.length == 2) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                    } else if (split2.length == 1) {
                        bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), "");
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String O000000o(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            for (Signature byteArray : packageInfo.signatures) {
                byte[] byteArray2 = byteArray.toByteArray();
                if (byteArray2 != null) {
                    return dbu.O000000o(byteArray2);
                }
            }
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        return null;
    }

    public static String O00000Oo(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String O00000Oo(Context context, String str) {
        return context == null ? "" : dbn.O000000o().O00000Oo(context, str);
    }
}
