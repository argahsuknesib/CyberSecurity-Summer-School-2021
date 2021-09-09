package _m_j;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public final class dpj {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static List<dpj> f14838O000000o = new LinkedList();
    public dpf O00000Oo;
    public VafContext O00000o;
    public Activity O00000o0;
    public View O00000oO;
    public MotionEvent O00000oo;
    public HashMap<String, Object> O0000O0o = new HashMap<>();

    public dpj(VafContext vafContext, dpf dpf) {
        this.O00000o = vafContext;
        this.O00000o0 = vafContext.O0000Ooo();
        this.O00000Oo = dpf;
    }

    private dpj(VafContext vafContext, dpf dpf, View view, MotionEvent motionEvent) {
        this.O00000o = vafContext;
        this.O00000o0 = vafContext.O0000Ooo();
        this.O00000Oo = dpf;
        this.O00000oO = view;
        this.O00000oo = motionEvent;
    }

    public static dpj O000000o(VafContext vafContext, dpf dpf) {
        View view;
        if (dpf != null) {
            view = dpf.g_();
            if (view == null && dpf.O0000OOo() != null) {
                view = dpf.O0000OOo().O00000o0;
            }
        } else {
            view = null;
        }
        return O000000o(vafContext, dpf, view, null);
    }

    public static dpj O000000o(VafContext vafContext, dpf dpf, View view, MotionEvent motionEvent) {
        if (f14838O000000o.size() <= 0) {
            return new dpj(vafContext, dpf, view, motionEvent);
        }
        dpj remove = f14838O000000o.remove(0);
        remove.O00000Oo = dpf;
        remove.O00000oO = view;
        remove.O00000o = vafContext;
        remove.O00000o0 = vafContext.O0000Ooo();
        return remove;
    }

    public final void O000000o() {
        f14838O000000o.add(this);
        this.O00000Oo = null;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oO = null;
        this.O00000oo = null;
    }
}
