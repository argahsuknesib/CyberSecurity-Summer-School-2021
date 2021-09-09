package com.facebook.internal;

import _m_j.o0O00Oo0;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.facebook.FacebookSdk;

public class CustomTab {
    private Uri uri;

    public CustomTab(String str, Bundle bundle) {
        bundle = bundle == null ? new Bundle() : bundle;
        String dialogAuthority = ServerProtocol.getDialogAuthority();
        this.uri = Utility.buildUri(dialogAuthority, FacebookSdk.getGraphApiVersion() + "/dialog/" + str, bundle);
    }

    public void openCustomTab(Activity activity, String str) {
        o0O00Oo0.O000000o o000000o = new o0O00Oo0.O000000o();
        if (o000000o.O00000Oo != null) {
            o000000o.f2232O000000o.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", o000000o.O00000Oo);
        }
        if (o000000o.O00000o != null) {
            o000000o.f2232O000000o.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", o000000o.O00000o);
        }
        o000000o.f2232O000000o.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", o000000o.O00000oO);
        o0O00Oo0 o0o00oo0 = new o0O00Oo0(o000000o.f2232O000000o, o000000o.O00000o0);
        o0o00oo0.f2231O000000o.setPackage(str);
        o0o00oo0.f2231O000000o.addFlags(1073741824);
        o0o00oo0.f2231O000000o.setData(this.uri);
        ContextCompat.O000000o(activity, o0o00oo0.f2231O000000o, o0o00oo0.O00000Oo);
    }
}
