package _m_j;

import android.text.TextUtils;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.utils.CloudCoder;
import com.xiaomi.smarthome.application.CommonApplication;
import java.net.MalformedURLException;
import java.net.URL;

public final class hsz {
    public static String O000000o() {
        return CloudCoder.hashDeviceInfo(gsa.O000000o(CommonApplication.getAppContext()));
    }

    public static boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            URL url = new URL(str);
            URL url2 = new URL(XMPassport.ACCOUNT_DOMAIN);
            String protocol = url2.getProtocol();
            String protocol2 = url.getProtocol();
            String host = url2.getHost();
            String host2 = url.getHost();
            if (!protocol.equalsIgnoreCase(protocol2) || !host.equalsIgnoreCase(host2)) {
                return false;
            }
            return true;
        } catch (MalformedURLException unused) {
        }
    }
}
