package _m_j;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;

public final class hgj extends hke {
    public static hgj O000000o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", true);
        hgj hgj = new hgj();
        hgj.setArguments(bundle);
        return hgj;
    }

    public final void init() {
        getWebView().O000000o(O000000o.class.getSimpleName(), new O000000o());
        super.init();
    }

    public final hgi O000000o() {
        FragmentActivity activity = getActivity();
        if (activity instanceof hgi) {
            return (hgi) activity;
        }
        return null;
    }

    class O000000o extends hkw {
        O000000o() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (!str.startsWith("https://api.io.mi.com/v2/idverify")) {
                return false;
            }
            gsy.O00000Oo("AuthFragment", "shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
            if (hgj.this.O000000o() == null) {
                return true;
            }
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("code");
            String queryParameter2 = parse.getQueryParameter("message");
            if (!TextUtils.equals(queryParameter, "0") || TextUtils.isEmpty(queryParameter2)) {
                hgj.this.O000000o().onAuthFailed(queryParameter2);
                return true;
            }
            hgj.this.O000000o().onAuthSuccess(queryParameter2);
            return true;
        }
    }
}
