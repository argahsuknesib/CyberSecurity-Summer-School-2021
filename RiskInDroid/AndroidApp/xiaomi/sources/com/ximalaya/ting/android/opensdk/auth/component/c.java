package com.ximalaya.ting.android.opensdk.auth.component;

import _m_j.ihy;
import _m_j.iib;
import _m_j.iif;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;

public final class c extends d {

    /* renamed from: O000000o  reason: collision with root package name */
    public iif f12162O000000o;
    public ihy O00000Oo;
    public String O00000o0;

    public c(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("key_auth_info");
        if (bundle2 != null) {
            this.f12162O000000o = iif.O000000o(this.O00000o, bundle2);
        }
        this.O00000o0 = bundle.getString("key_listener");
        if (!TextUtils.isEmpty(this.O00000o0)) {
            this.O00000Oo = iib.O000000o(this.O00000o).O000000o(this.O00000o0);
        }
    }

    public final void O000000o(Activity activity) {
        XmlyBrowserComponent.closeBrowser(activity, this.O00000o0);
    }
}
