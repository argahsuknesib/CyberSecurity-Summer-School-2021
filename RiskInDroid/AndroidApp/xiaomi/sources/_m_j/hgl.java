package _m_j;

import _m_j.hgk;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.smarthome.R;

public final class hgl extends hke implements hgk.O000000o {
    public final boolean isFixedTitleText() {
        return true;
    }

    public static hgl O000000o(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("arg_url", str);
        bundle.putString("arg_title", str2);
        bundle.putBoolean("arg_use_title_bar", true);
        hgl hgl = new hgl();
        hgl.setArguments(bundle);
        return hgl;
    }

    public final void init() {
        super.init();
        getWebViewTitleBar().setOmitMenu(true);
        hgk hgk = new hgk(getActivity(), getWebView());
        hgk.f18899O000000o = this;
        getWebView().addJavascriptInterface(hgk, "unregister");
    }

    public final void O000000o() {
        hgm O00000o0 = O00000o0();
        if (O00000o0 != null) {
            O00000o0.unRegisterSuccess();
        }
    }

    public final void O00000Oo() {
        hgm O00000o0 = O00000o0();
        if (O00000o0 != null) {
            O00000o0.endUnRegister();
        }
    }

    private hgm O00000o0() {
        FragmentActivity activity = getActivity();
        if (activity instanceof hgm) {
            return (hgm) activity;
        }
        return null;
    }

    public final String getDefaultTitle() {
        return getString(R.string.device_more_activity_revoke_auth);
    }
}
