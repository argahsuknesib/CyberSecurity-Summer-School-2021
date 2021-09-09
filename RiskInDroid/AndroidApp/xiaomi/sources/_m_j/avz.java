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

final class avz extends ContentObserver {

    /* renamed from: O000000o  reason: collision with root package name */
    private ArrayList<awc> f12652O000000o;
    private Application O00000Oo;
    private Boolean O00000o0;

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final avz f12653O000000o = new avz((byte) 0);
    }

    /* synthetic */ avz(byte b) {
        this();
    }

    static avz O000000o() {
        return O000000o.f12653O000000o;
    }

    private avz() {
        super(new Handler(Looper.getMainLooper()));
        this.O00000o0 = Boolean.FALSE;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Application application) {
        Application application2;
        Uri uriFor;
        this.O00000Oo = application;
        if (Build.VERSION.SDK_INT >= 17 && (application2 = this.O00000Oo) != null && application2.getContentResolver() != null && !this.O00000o0.booleanValue() && (uriFor = Settings.System.getUriFor("navigationbar_is_min")) != null) {
            this.O00000Oo.getContentResolver().registerContentObserver(uriFor, true, this);
            this.O00000o0 = Boolean.TRUE;
        }
    }

    public final void onChange(boolean z) {
        Application application;
        ArrayList<awc> arrayList;
        super.onChange(z);
        if (Build.VERSION.SDK_INT >= 17 && (application = this.O00000Oo) != null && application.getContentResolver() != null && (arrayList = this.f12652O000000o) != null && !arrayList.isEmpty()) {
            int i = Settings.System.getInt(this.O00000Oo.getContentResolver(), "navigationbar_is_min", 0);
            Iterator<awc> it = this.f12652O000000o.iterator();
            while (it.hasNext()) {
                awc next = it.next();
                boolean z2 = true;
                if (i == 1) {
                    z2 = false;
                }
                next.O000000o(z2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(awc awc) {
        if (this.f12652O000000o == null) {
            this.f12652O000000o = new ArrayList<>();
        }
        if (!this.f12652O000000o.contains(awc)) {
            this.f12652O000000o.add(awc);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo(awc awc) {
        ArrayList<awc> arrayList = this.f12652O000000o;
        if (arrayList != null) {
            arrayList.remove(awc);
        }
    }
}
