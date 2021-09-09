package _m_j;

import android.content.Intent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.xiaomi.accountsdk.utils.ServerTimeUtil;

public final class ekp extends WebView {

    /* renamed from: O000000o  reason: collision with root package name */
    private final ServerTimeUtil.ServerTimeAlignedListener f15581O000000o;
    private final boolean O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f15582O000000o;
        public final boolean O00000Oo;
        public final String O00000o;
        public final String O00000o0;

        public O000000o(String str, boolean z) {
            this(str, true, (byte) 0);
        }

        private O000000o(String str, boolean z, byte b) {
            this.f15582O000000o = str;
            this.O00000Oo = z;
            this.O00000o0 = null;
            this.O00000o = null;
        }
    }

    public static void O000000o(Intent intent, O000000o o000000o) {
        intent.putExtra("notification_url", o000000o.f15582O000000o);
        intent.putExtra("need_remove_all_cookies", o000000o.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ServerTimeUtil.addServerTimeChangedListener(this.f15581O000000o);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        ServerTimeUtil.removeServerTimeChangedListener(this.f15581O000000o);
        if (this.O00000Oo) {
            CookieSyncManager.createInstance(getContext());
            CookieManager.getInstance().removeAllCookie();
        }
        super.onDetachedFromWindow();
    }
}
