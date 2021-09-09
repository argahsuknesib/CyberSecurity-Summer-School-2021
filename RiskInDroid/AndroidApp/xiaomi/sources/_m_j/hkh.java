package _m_j;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.xiaomi.smarthome.WebViewRouterFactory;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;

public final class hkh extends hkf {
    public static boolean O00000o0;

    public hkh(Activity activity, CommonWebView commonWebView) {
        super(activity, commonWebView);
    }

    @JavascriptInterface
    public final void openDownloadList() {
        Activity activity = (Activity) this.f19010O000000o.get();
        CommonWebView commonWebView = (CommonWebView) this.O00000Oo.get();
        if (activity != null && commonWebView != null) {
            String did = commonWebView.getDid();
            String userId = WebViewRouterFactory.getWebViewHelpManager().getUserId(did);
            if (!TextUtils.isEmpty(userId)) {
                fbs.O000000o(new fbt(activity, "CloudVideoDownloadActivity").O000000o("is_hs_panorama_video", O00000o0).O000000o("did", did).O000000o("uid", userId));
            }
        }
    }
}
