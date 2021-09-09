package _m_j;

import android.webkit.WebView;
import com.xiaomi.smarthome.WebViewRouterFactory;

public class hkz extends hkw {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.contains("home.mi.com/shop/shexiangyun")) {
            return false;
        }
        WebViewRouterFactory.getWebViewHelpManager().openUrl(str);
        return true;
    }
}
