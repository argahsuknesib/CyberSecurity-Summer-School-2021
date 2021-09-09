package _m_j;

import android.os.AsyncTask;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.sdu.didi.openapi.utils.Utils;
import java.util.ArrayList;

public final class dbc {

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<AsyncTask> f14431O000000o;
    public WebView O00000Oo;

    public dbc(WebView webView) {
        this.O00000Oo = webView;
        WebView webView2 = this.O00000Oo;
        WebSettings settings = webView2.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(false);
        String userAgentString = settings.getUserAgentString();
        if (!userAgentString.contains("didi.sdk")) {
            userAgentString = userAgentString + " didi.sdk" + Utils.getCurrentVersion();
        }
        settings.setUserAgentString(userAgentString);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(-1);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setLoadsImagesAutomatically(true);
        webView2.getSettings().setDomStorageEnabled(true);
        webView2.getSettings().setDatabaseEnabled(true);
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        if (Build.VERSION.SDK_INT < 19) {
            webView2.getSettings().setDatabasePath("/data/data/" + webView2.getContext().getPackageName() + "/databases/");
        }
    }
}
