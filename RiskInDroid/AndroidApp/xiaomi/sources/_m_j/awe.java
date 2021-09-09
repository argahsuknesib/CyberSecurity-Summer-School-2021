package _m_j;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

final class awe extends ContentObserver {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<awi> f12660O000000o;
    private Application O00000Oo;
    private Boolean O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final awe f12661O000000o = new awe((byte) 0);
    }

    /* synthetic */ awe(byte b) {
        this();
    }

    static awe O000000o() {
        return O000000o.f12661O000000o;
    }

    private awe() {
        super(new Handler(Looper.getMainLooper()));
        this.O00000o0 = Boolean.FALSE;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Application application) {
        Application application2;
        this.O00000Oo = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.O00000Oo) != null && application2.getContentResolver() != null && !this.O00000o0.booleanValue()) {
            Uri uri = null;
            if (awg.O000000o()) {
                uri = Settings.Global.getUriFor("force_fsg_nav_bar");
            } else if (awg.O00000o0()) {
                if (awg.O00000o() || Build.VERSION.SDK_INT < 21) {
                    uri = Settings.System.getUriFor("navigationbar_is_min");
                } else {
                    uri = Settings.Global.getUriFor("navigationbar_is_min");
                }
            }
            if (uri != null) {
                this.O00000Oo.getContentResolver().registerContentObserver(uri, true, this);
                this.O00000o0 = Boolean.TRUE;
            }
        }
    }

    public final void onChange(boolean z) {
        Application application;
        ArrayList<awi> arrayList;
        int i;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.O00000Oo) != null && application.getContentResolver() != null && (arrayList = this.f12660O000000o) != null && !arrayList.isEmpty()) {
            if (awg.O000000o()) {
                i = Settings.Global.getInt(this.O00000Oo.getContentResolver(), "force_fsg_nav_bar", 0);
            } else {
                i = awg.O00000o0() ? (awg.O00000o() || Build.VERSION.SDK_INT < 21) ? Settings.System.getInt(this.O00000Oo.getContentResolver(), "navigationbar_is_min", 0) : Settings.Global.getInt(this.O00000Oo.getContentResolver(), "navigationbar_is_min", 0) : 0;
            }
            Iterator<awi> it = this.f12660O000000o.iterator();
            while (it.hasNext()) {
                awi next = it.next();
                boolean z2 = true;
                if (i == 1) {
                    z2 = false;
                }
                next.O000000o(z2);
            }
        }
    }
}
