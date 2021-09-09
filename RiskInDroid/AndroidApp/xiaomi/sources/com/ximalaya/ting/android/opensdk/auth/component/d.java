package com.ximalaya.ting.android.opensdk.auth.component;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

public abstract class d {
    protected Context O00000o;
    protected String O00000oO;
    protected String O00000oo;

    public abstract void O000000o(Activity activity);

    /* access modifiers changed from: protected */
    public abstract void O000000o(Bundle bundle);

    public d(Context context) {
        this.O00000o = context.getApplicationContext();
    }

    public final void O00000Oo(Bundle bundle) {
        this.O00000oO = bundle.getString("key_url");
        this.O00000oo = bundle.getString("key_specify_title");
        O000000o(bundle);
    }

    public final String O000000o() {
        return this.O00000oO;
    }

    public final String O00000Oo() {
        return this.O00000oo;
    }
}
