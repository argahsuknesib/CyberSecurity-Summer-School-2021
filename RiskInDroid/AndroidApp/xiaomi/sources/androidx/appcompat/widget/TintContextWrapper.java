package androidx.appcompat.widget;

import _m_j.Oo0;
import _m_j.o000;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TintContextWrapper extends ContextWrapper {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f2751O000000o = new Object();
    private static ArrayList<WeakReference<TintContextWrapper>> O00000Oo;
    private final Resources.Theme O00000o;
    private final Resources O00000o0;

    private TintContextWrapper(Context context) {
        super(context);
        if (o000.O000000o()) {
            this.O00000o0 = new o000(this, context.getResources());
            this.O00000o = this.O00000o0.newTheme();
            this.O00000o.setTo(context.getTheme());
            return;
        }
        this.O00000o0 = new Oo0(this, context.getResources());
        this.O00000o = null;
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.O00000o;
        return theme == null ? super.getTheme() : theme;
    }

    public void setTheme(int i) {
        Resources.Theme theme = this.O00000o;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }

    public Resources getResources() {
        return this.O00000o0;
    }

    public AssetManager getAssets() {
        return this.O00000o0.getAssets();
    }

    public static Context wrap(Context context) {
        boolean z = false;
        if (!(context instanceof TintContextWrapper) && !(context.getResources() instanceof Oo0) && !(context.getResources() instanceof o000) && (Build.VERSION.SDK_INT < 21 || o000.O000000o())) {
            z = true;
        }
        if (!z) {
            return context;
        }
        synchronized (f2751O000000o) {
            if (O00000Oo == null) {
                O00000Oo = new ArrayList<>();
            } else {
                for (int size = O00000Oo.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = O00000Oo.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        O00000Oo.remove(size);
                    }
                }
                for (int size2 = O00000Oo.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = O00000Oo.get(size2);
                    TintContextWrapper tintContextWrapper = weakReference2 != null ? (TintContextWrapper) weakReference2.get() : null;
                    if (tintContextWrapper != null && tintContextWrapper.getBaseContext() == context) {
                        return tintContextWrapper;
                    }
                }
            }
            TintContextWrapper tintContextWrapper2 = new TintContextWrapper(context);
            O00000Oo.add(new WeakReference(tintContextWrapper2));
            return tintContextWrapper2;
        }
    }
}
