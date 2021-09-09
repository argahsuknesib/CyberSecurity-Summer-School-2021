package _m_j;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public final class fxh extends Resources {

    /* renamed from: O000000o  reason: collision with root package name */
    private DisplayMetrics f17371O000000o;
    private Activity O00000Oo;

    public fxh(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
        super(assetManager, displayMetrics, configuration);
    }

    public final DisplayMetrics getDisplayMetrics() {
        if (this.f17371O000000o == null) {
            synchronized (this) {
                if (this.f17371O000000o == null) {
                    this.f17371O000000o = hyy.O00000Oo(this.O00000Oo == null ? null : this.O00000Oo.getIntent());
                }
            }
        }
        return this.f17371O000000o;
    }

    public final void O000000o(Activity activity) {
        this.O00000Oo = activity;
        this.f17371O000000o = null;
    }

    public final synchronized void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        this.f17371O000000o = null;
    }
}
