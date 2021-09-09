package _m_j;

import _m_j.OO00O0o;
import _m_j.OooOO;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.widget.Toolbar;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public abstract class O0o0000 {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static int f6697O000000o = -100;
    protected static final o0O0OOOo<WeakReference<O0o0000>> O00000Oo = new o0O0OOOo<>();
    protected static final Object O00000o0 = new Object();

    public abstract OO00O0o O000000o(OO00O0o.O000000o o000000o);

    public Context O000000o(Context context) {
        return context;
    }

    public abstract ActionBar O000000o();

    public void O000000o(int i) {
    }

    public abstract void O000000o(Configuration configuration);

    public abstract void O000000o(View view);

    public abstract void O000000o(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void O000000o(Toolbar toolbar);

    public abstract void O000000o(CharSequence charSequence);

    public abstract MenuInflater O00000Oo();

    public abstract <T extends View> T O00000Oo(int i);

    public abstract void O00000Oo(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void O00000o();

    public abstract boolean O00000o(int i);

    public abstract void O00000o0();

    public abstract void O00000o0(int i);

    public abstract void O00000oO();

    public abstract void O00000oo();

    public abstract void O0000O0o();

    public abstract void O0000OOo();

    public abstract OooOO.O000000o O0000Oo();

    public abstract void O0000Oo0();

    public abstract void O0000OoO();

    public abstract boolean O0000Ooo();

    public int O0000o00() {
        return -100;
    }

    public static O0o0000 O000000o(Activity activity, OoO0o ooO0o) {
        return new AppCompatDelegateImpl(activity, ooO0o);
    }

    public static O0o0000 O000000o(Dialog dialog, OoO0o ooO0o) {
        return new AppCompatDelegateImpl(dialog, ooO0o);
    }

    protected O0o0000() {
    }

    public static void O0000o0() {
        if (f6697O000000o != -1) {
            f6697O000000o = -1;
            synchronized (O00000o0) {
                Iterator<WeakReference<O0o0000>> it = O00000Oo.iterator();
                while (it.hasNext()) {
                    O0o0000 o0o0000 = (O0o0000) it.next().get();
                    if (o0o0000 != null) {
                        o0o0000.O0000Ooo();
                    }
                }
            }
        }
    }

    public static void O0000o0O() {
        o000.O000000o(true);
    }

    protected static void O000000o(O0o0000 o0o0000) {
        synchronized (O00000o0) {
            Iterator<WeakReference<O0o0000>> it = O00000Oo.iterator();
            while (it.hasNext()) {
                O0o0000 o0o00002 = (O0o0000) it.next().get();
                if (o0o00002 == o0o0000 || o0o00002 == null) {
                    it.remove();
                }
            }
        }
    }
}
