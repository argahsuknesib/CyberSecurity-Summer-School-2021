package androidx.activity;

import _m_j.ey;
import _m_j.fa;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Field;

final class ImmLeaksCleaner implements ey {

    /* renamed from: O000000o  reason: collision with root package name */
    private static int f2629O000000o;
    private static Field O00000Oo;
    private static Field O00000o;
    private static Field O00000o0;
    private Activity O00000oO;

    ImmLeaksCleaner(Activity activity) {
        this.O00000oO = activity;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:32|33|34) */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0070, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x006f */
    public final void O000000o(fa faVar, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            if (f2629O000000o == 0) {
                try {
                    f2629O000000o = 2;
                    Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                    O00000o0 = declaredField;
                    declaredField.setAccessible(true);
                    Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                    O00000o = declaredField2;
                    declaredField2.setAccessible(true);
                    Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                    O00000Oo = declaredField3;
                    declaredField3.setAccessible(true);
                    f2629O000000o = 1;
                } catch (NoSuchFieldException unused) {
                }
            }
            if (f2629O000000o == 1) {
                InputMethodManager inputMethodManager = (InputMethodManager) this.O00000oO.getSystemService("input_method");
                try {
                    Object obj = O00000Oo.get(inputMethodManager);
                    if (obj != null) {
                        synchronized (obj) {
                            try {
                                View view = (View) O00000o0.get(inputMethodManager);
                                if (view != null) {
                                    if (!view.isAttachedToWindow()) {
                                        O00000o.set(inputMethodManager, null);
                                        inputMethodManager.isActive();
                                    }
                                }
                            } catch (IllegalAccessException unused2) {
                            } catch (ClassCastException unused3) {
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                } catch (IllegalAccessException unused4) {
                }
            }
        }
    }
}
