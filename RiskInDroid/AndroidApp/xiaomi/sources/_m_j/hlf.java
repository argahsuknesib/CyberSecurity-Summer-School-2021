package _m_j;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;

public class hlf extends hkw {
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            hld.O000000o();
            return hld.O000000o(Uri.parse(str));
        } catch (Exception e) {
            gsy.O000000o(6, "UrlJumpHandler", "shouldOverrideUrlLoading: " + Log.getStackTraceString(e));
            return false;
        }
    }
}
