package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.mi.global.shop.webview.WebViewHelper;
import com.mi.global.shop.widget.BaseWebView;
import com.xiaomi.smarthome.R;

public abstract class cao extends can {
    private static final String O00000o = "cao";

    /* renamed from: O000000o  reason: collision with root package name */
    public BaseWebView f13527O000000o;
    protected ProgressBar O00000Oo;
    public float O00000o0;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.shop_maintab_web_fragment, viewGroup, false);
        this.f13527O000000o = (BaseWebView) inflate.findViewById(R.id.browser);
        WebViewHelper.O000000o(this.f13527O000000o);
        this.O00000Oo = (ProgressBar) inflate.findViewById(R.id.browser_progress_bar);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onDestroy() {
        this.O00000o0 = O000000o(this.f13527O000000o);
        this.f13527O000000o.stopLoading();
        this.f13527O000000o.removeAllViews();
        this.f13527O000000o.destroy();
        super.onDestroy();
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.O00000o0 = O000000o(this.f13527O000000o);
        bundle.putFloat("mProgressToRestore", this.O00000o0);
        super.onSaveInstanceState(bundle);
        this.f13527O000000o.saveState(bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.O00000o0 = bundle.getFloat("mProgressToRestore");
        }
    }

    private static float O000000o(WebView webView) {
        return (((float) webView.getScrollY()) - ((float) webView.getTop())) / ((float) webView.getContentHeight());
    }
}
