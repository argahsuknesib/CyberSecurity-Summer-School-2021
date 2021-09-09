package _m_j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.xiaomi.smarthome.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class cbv extends WebViewClient {
    private static InputStream O000000o(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return new FileInputStream(file);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final WebResourceResponse O000000o(String str, WebView webView, String str2, String[] strArr) {
        ccr.O00000Oo(str, "Resource Request PATH:" + strArr[1]);
        InputStream O000000o2 = O000000o(strArr[1]);
        if (O000000o2 == null) {
            return super.shouldInterceptRequest(webView, str2);
        }
        ccr.O00000Oo(str, "Resource Request file exists!");
        return new WebResourceResponse(strArr[0], "UTF-8", O000000o2);
    }

    public static boolean O000000o(Activity activity, String str) {
        if (!str.startsWith("mailto:") && !str.startsWith("tel:")) {
            return false;
        }
        try {
            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        } catch (ActivityNotFoundException unused) {
            if (str.startsWith("mailto:")) {
                cec.O000000o(byl.O00000oO(), (int) R.string.error_mailservice, 1);
            }
            if (str.startsWith("tel:")) {
                cec.O000000o(byl.O00000oO(), (int) R.string.error_phoneservice, 1);
            }
        }
        return true;
    }

    public static boolean O00000Oo(Activity activity, String str) {
        if (!cad.O00000o() || !cav.O00000oo(str).booleanValue()) {
            return false;
        }
        activity.startActivityForResult(new Intent(activity, ShoppingCartActivity.class), 22);
        return true;
    }

    public final boolean O00000o0(final Activity activity, String str) {
        if (!str.toLowerCase().contains("account.xiaomi.com/pass/serviceLogin".toLowerCase())) {
            return false;
        }
        if (ccn.O0000o00().O0000o0O()) {
            ccn.O0000o00().O0000Oo();
            new Handler().postDelayed(new Runnable() {
                /* class _m_j.cbv.AnonymousClass1 */

                public final void run() {
                    if (!"community_sdk".equals(byl.O0000O0o.O00000oo)) {
                        byl.O00000Oo();
                    } else if (BaseActivity.isActivityAlive(activity)) {
                        ((BaseActivity) activity).gotoAccount();
                    }
                }
            }, 1000);
            return true;
        } else if ("community_sdk".equals(byl.O0000O0o.O00000oo)) {
            ((BaseActivity) activity).gotoAccount();
            return true;
        } else {
            byl.O00000Oo();
            return true;
        }
    }
}
