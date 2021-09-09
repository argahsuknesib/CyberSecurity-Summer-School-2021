package _m_j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import java.net.URLEncoder;

public final class cqs {
    public static synchronized String O000000o(Bundle bundle) {
        String stringBuffer;
        synchronized (cqs.class) {
            try {
                O000000o("Extracting Strings from Bundle...");
                boolean z = true;
                StringBuffer stringBuffer2 = new StringBuffer();
                for (String next : bundle.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuffer2.append("&");
                    }
                    stringBuffer2.append(next);
                    stringBuffer2.append("=");
                    stringBuffer2.append(bundle.getString(next));
                }
                O000000o("Extracted String is " + stringBuffer2.toString());
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e) {
                O000000o(e);
                return null;
            }
        }
        return stringBuffer;
    }

    public static synchronized String O00000Oo(Bundle bundle) {
        String stringBuffer;
        synchronized (cqs.class) {
            try {
                O000000o("Extracting Strings from Bundle...");
                boolean z = true;
                StringBuffer stringBuffer2 = new StringBuffer();
                for (String next : bundle.keySet()) {
                    if (z) {
                        z = false;
                    } else {
                        stringBuffer2.append("&");
                    }
                    stringBuffer2.append(URLEncoder.encode(next, "UTF-8"));
                    stringBuffer2.append("=");
                    stringBuffer2.append(URLEncoder.encode(bundle.getString(next), "UTF-8"));
                }
                O000000o("URL encoded String is " + stringBuffer2.toString());
                stringBuffer = stringBuffer2.toString();
            } catch (Exception e) {
                O000000o(e);
                return null;
            }
        }
        return stringBuffer;
    }

    public static synchronized void O000000o(String str) {
        synchronized (cqs.class) {
            cqm.O000000o("PGSDK", str);
        }
    }

    public static synchronized void O000000o(Exception exc) {
        synchronized (cqs.class) {
            exc.printStackTrace();
        }
    }

    protected static synchronized boolean O000000o(Context context) {
        synchronized (cqs.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            boolean isConnected = activeNetworkInfo.isConnected();
            return isConnected;
        }
    }
}
