package _m_j;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.titlebar.WebTitleBarView;

public class hke extends hkg {
    private View mRootView;
    private String mTitle = "";
    private String mUrl = "";
    private boolean mUseTitleBar = false;
    private CommonWebView mWebView;
    private WebTitleBarView mWebViewTitleBar;

    public static hke newInstance(String str, String str2, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", z);
        hke hke = new hke();
        hke.setArguments(bundle);
        return hke;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mRootView == null) {
            this.mRootView = layoutInflater.inflate((int) R.layout.choiceness_scene_web_view, viewGroup, false);
            this.mWebView = (CommonWebView) this.mRootView.findViewById(R.id.webview);
            this.mWebView.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
            this.mWebViewTitleBar = (WebTitleBarView) this.mRootView.findViewById(R.id.web_title_bar);
            if (getActivity() != null && !hyy.O000000o(getActivity().getIntent())) {
                gwg.O000000o(this.mWebViewTitleBar);
            }
            Bundle arguments = getArguments();
            if (arguments == null) {
                return this.mRootView;
            }
            this.mUrl = arguments.getString("arg_url");
            if (!isValidUrl(this.mUrl)) {
                return this.mRootView;
            }
            this.mTitle = arguments.getString("arg_title");
            this.mUseTitleBar = arguments.getBoolean("arg_use_title_bar");
        }
        return this.mRootView;
    }

    public CommonWebView getWebView() {
        return this.mWebView;
    }

    public WebTitleBarView getWebViewTitleBar() {
        this.mWebViewTitleBar.setWebView(this.mWebView);
        return this.mWebViewTitleBar;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getDefaultTitle() {
        return this.mTitle;
    }

    public boolean isUseTitleBar() {
        return this.mUseTitleBar;
    }

    public void loginStateUpdate() {
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4 && this.mWebView != null && isValidUrl(this.mUrl)) {
            hkv O000000o2 = this.mWebView.O00000Oo.f19027O000000o.O000000o(hla.class.getSimpleName());
            if (O000000o2 != null && (O000000o2 instanceof hla)) {
                hla hla = (hla) O000000o2;
                if (hla.f19028O000000o) {
                    hla.O000000o(this.mWebView);
                }
            }
            this.mWebView.reload();
        }
    }
}
