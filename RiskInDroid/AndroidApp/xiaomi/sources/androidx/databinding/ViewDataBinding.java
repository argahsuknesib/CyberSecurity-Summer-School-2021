package androidx.databinding;

import _m_j.di;
import _m_j.dk;
import _m_j.ez;
import _m_j.fa;
import _m_j.fi;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.xiaomi.smarthome.R;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public abstract class ViewDataBinding extends di {

    /* renamed from: O000000o  reason: collision with root package name */
    static int f2849O000000o = Build.VERSION.SDK_INT;
    public static final ReferenceQueue<ViewDataBinding> O00000Oo = new ReferenceQueue<>();
    public static final View.OnAttachStateChangeListener O00000o0;
    private static final int O0000OoO = 8;
    private static final boolean O0000Ooo = (f2849O000000o >= 16);
    private static final dk.O000000o<Object, ViewDataBinding, Void> O0000o = new dk.O000000o<Object, ViewDataBinding, Void>() {
        /* class androidx.databinding.ViewDataBinding.AnonymousClass5 */
    };
    private static final O000000o O0000o0 = new O000000o() {
        /* class androidx.databinding.ViewDataBinding.AnonymousClass2 */
    };
    private static final O000000o O0000o00 = new O000000o() {
        /* class androidx.databinding.ViewDataBinding.AnonymousClass1 */
    };
    private static final O000000o O0000o0O = new O000000o() {
        /* class androidx.databinding.ViewDataBinding.AnonymousClass3 */
    };
    private static final O000000o O0000o0o = new O000000o() {
        /* class androidx.databinding.ViewDataBinding.AnonymousClass4 */
    };
    public final Runnable O00000o;
    public boolean O00000oO;
    public boolean O00000oo;
    public final View O0000O0o;
    dk<Object, ViewDataBinding, Void> O0000OOo;
    ViewDataBinding O0000Oo;
    boolean O0000Oo0;
    private final Choreographer.FrameCallback O0000oO;
    private Choreographer O0000oO0;
    private Handler O0000oOO;
    private fa O0000oOo;

    interface O000000o {
    }

    public abstract boolean O000000o();

    static {
        if (Build.VERSION.SDK_INT < 19) {
            O00000o0 = null;
        } else {
            O00000o0 = new View.OnAttachStateChangeListener() {
                /* class androidx.databinding.ViewDataBinding.AnonymousClass6 */

                public final void onViewDetachedFromWindow(View view) {
                }

                @TargetApi(19)
                public final void onViewAttachedToWindow(View view) {
                    ViewDataBinding.O000000o(view).O00000o.run();
                    view.removeOnAttachStateChangeListener(this);
                }
            };
        }
    }

    static ViewDataBinding O000000o(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0029, code lost:
        if (androidx.databinding.ViewDataBinding.O0000Ooo == false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002b, code lost:
        r0.O0000oO0.postFrameCallback(r0.O0000oO);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0032, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0033, code lost:
        r0.O0000oOO.post(r0.O00000o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
        return;
     */
    public void O00000Oo() {
        ViewDataBinding viewDataBinding = this;
        while (true) {
            ViewDataBinding viewDataBinding2 = viewDataBinding.O0000Oo;
            if (viewDataBinding2 == null) {
                break;
            }
            viewDataBinding = viewDataBinding2;
        }
        fa faVar = viewDataBinding.O0000oOo;
        if (faVar == null || faVar.getLifecycle().O000000o().isAtLeast(Lifecycle.State.STARTED)) {
            synchronized (viewDataBinding) {
                if (!viewDataBinding.O00000oO) {
                    viewDataBinding.O00000oO = true;
                }
            }
        }
    }

    static class OnStartListener implements ez {

        /* renamed from: O000000o  reason: collision with root package name */
        final WeakReference<ViewDataBinding> f2850O000000o;

        @fi(O000000o = Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.f2850O000000o.get();
            if (viewDataBinding != null) {
                while (viewDataBinding.O0000Oo != null) {
                    viewDataBinding = viewDataBinding.O0000Oo;
                }
                if (viewDataBinding.O0000Oo0) {
                    viewDataBinding.O00000Oo();
                } else if (viewDataBinding.O000000o()) {
                    viewDataBinding.O0000Oo0 = true;
                    viewDataBinding.O00000oo = false;
                    if (viewDataBinding.O0000OOo != null) {
                        viewDataBinding.O0000OOo.O000000o(viewDataBinding, 1);
                        if (viewDataBinding.O00000oo) {
                            viewDataBinding.O0000OOo.O000000o(viewDataBinding, 2);
                        }
                    }
                    if (!viewDataBinding.O00000oo && viewDataBinding.O0000OOo != null) {
                        viewDataBinding.O0000OOo.O000000o(viewDataBinding, 3);
                    }
                    viewDataBinding.O0000Oo0 = false;
                }
            }
        }
    }
}
