package androidx.multidex;

import _m_j.gi;
import android.app.Application;
import android.content.Context;

public class MultiDexApplication extends Application {
    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        gi.O000000o(this);
    }
}
