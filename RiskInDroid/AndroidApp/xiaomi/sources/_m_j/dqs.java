package _m_j;

import _m_j.dpf;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.scroller.ScrollerStickyParent;
import org.json.JSONObject;

public class dqs extends dpe {
    protected int O000o0 = 1;
    protected dqt O000o00O;
    protected int O000o00o = 1;
    protected boolean O000o0O = false;
    protected bnt O000o0O0;
    protected int O000o0OO = 0;
    protected int O000o0Oo = 5;
    protected int O000o0o = 0;
    protected int O000o0o0 = 0;
    protected int O000o0oo = 0;

    public final boolean O0000Oo0() {
        return true;
    }

    public dqs(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o00O = new dqt(vafContext, this);
        this.f14827O000000o = this.O000o00O;
    }

    public final int O00000Oo() {
        return this.O000o00o;
    }

    public final void O00000Oo(Object obj) {
        super.O00000Oo(obj);
        if (obj instanceof JSONObject) {
            obj = ((JSONObject) obj).optJSONArray(this.O000O0OO);
        }
        this.O000o00O.setData(obj);
    }

    public final void O000OOo() {
        if (this.O000o0O0 != null) {
            dmu O00000oO = this.O000OoO0.O00000oO();
            if (O00000oO != null) {
                O00000oO.f14795O000000o.O00000o0.O000000o((JSONObject) O0000OOo().O00000Oo);
            }
            if (O00000oO == null || !O00000oO.O000000o(this, this.O000o0O0)) {
                Log.e("Scroller_TMTEST", "callAutoRefresh execute failed");
            }
        }
        this.O000OoO0.O00000Oo().O000000o(2, dpj.O000000o(this.O000OoO0, this));
    }

    public final void O00000oO() {
        super.O00000oO();
        if (!(this.O000o0o0 == 0 && this.O000o0o == 0 && this.O000o0oo == 0)) {
            this.O000o00O.addItemDecoration(new O00000Oo(this, this.O000o0o0, this.O000o0o, this.O000o0oo));
        }
        this.O000o00O.O000000o(this.O000o0, this.O000o00o);
        this.O000o00O.setSupportSticky(this.O000o0O);
        if (!this.O000o0O) {
            this.f14827O000000o = this.O000o00O;
        } else if (this.O000o00O.getParent() == null) {
            ScrollerStickyParent scrollerStickyParent = new ScrollerStickyParent(this.O000OoO0.O0000O0o());
            scrollerStickyParent.addView(this.O000o00O, this.O000OoOO.f14826O000000o, this.O000OoOO.O00000Oo);
            this.f14827O000000o = scrollerStickyParent;
        }
        this.O000o00O.setBackgroundColor(this.O0000Oo);
        this.O000o00O.setAutoRefreshThreshold(this.O000o0Oo);
        this.O000o00O.setSpan(this.O000o0OO);
    }

    public final boolean O00000Oo(int i, bnt bnt) {
        boolean O00000Oo2 = super.O00000Oo(i, bnt);
        if (O00000Oo2) {
            return O00000Oo2;
        }
        if (i != 173466317) {
            return false;
        }
        this.O000o0O0 = bnt;
        return true;
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo2 = super.O00000Oo(i, f);
        if (O00000Oo2) {
            return O00000Oo2;
        }
        switch (i) {
            case -1807275662:
                this.O000o0o0 = bns.O00000Oo((double) f);
                return true;
            case -172008394:
                this.O000o0o = bns.O00000Oo((double) f);
                return true;
            case 3536714:
                this.O000o0OO = bns.O00000Oo((double) f);
                return true;
            case 2002099216:
                this.O000o0oo = bns.O00000Oo((double) f);
                return true;
            default:
                return false;
        }
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        switch (i) {
            case -1807275662:
                this.O000o0o0 = bns.O000000o((double) f);
                return true;
            case -172008394:
                this.O000o0o = bns.O000000o((double) f);
                return true;
            case 3536714:
                this.O000o0OO = bns.O000000o((double) f);
                return true;
            case 2002099216:
                this.O000o0oo = bns.O000000o((double) f);
                return true;
            default:
                return false;
        }
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo2 = super.O00000Oo(i, i2);
        if (O00000Oo2) {
            return O00000Oo2;
        }
        switch (i) {
            case -1807275662:
                this.O000o0o0 = bns.O000000o((double) i2);
                return true;
            case -172008394:
                this.O000o0o = bns.O000000o((double) i2);
                return true;
            case 3536714:
                this.O000o0OO = bns.O000000o((double) i2);
                return true;
            case 2002099216:
                this.O000o0oo = bns.O000000o((double) i2);
                return true;
            default:
                return false;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        boolean z = false;
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case -1807275662:
                this.O000o0o0 = bns.O00000Oo((double) i2);
                break;
            case -1439500848:
                if (i2 != 1) {
                    if (i2 == 0) {
                        this.O000o00o = 1;
                        break;
                    }
                } else {
                    this.O000o00o = 0;
                    break;
                }
                break;
            case -977844584:
                if (i2 > 0) {
                    z = true;
                }
                this.O000o0O = z;
                break;
            case -172008394:
                this.O000o0o = bns.O00000Oo((double) i2);
                break;
            case -51356769:
                this.O000o0Oo = i2;
                break;
            case 3357091:
                this.O000o0 = i2;
                break;
            case 3536714:
                this.O000o0OO = bns.O00000Oo((double) i2);
                break;
            case 2002099216:
                this.O000o0oo = bns.O00000Oo((double) i2);
                break;
            default:
                return false;
        }
        return true;
    }

    public static class O00000Oo extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        private dqs f14852O000000o;
        private int O00000Oo;
        private int O00000o;
        private int O00000o0;

        public O00000Oo(dqs dqs, int i, int i2, int i3) {
            this.f14852O000000o = dqs;
            this.O00000Oo = i;
            this.O00000o0 = i2;
            this.O00000o = i3;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            dqt dqt;
            if (this.O00000o0 != 0 && recyclerView.getChildPosition(view) == 0) {
                if (this.f14852O000000o.O00000Oo() == 0) {
                    rect.left = this.O00000o0;
                } else {
                    rect.top = this.O00000o0;
                }
            }
            if (this.O00000o != 0) {
                View g_ = this.f14852O000000o.g_();
                if (g_ instanceof ScrollerStickyParent) {
                    dqt = (dqt) ((ScrollerStickyParent) g_).getChildAt(0);
                } else {
                    dqt = (dqt) this.f14852O000000o.g_();
                }
                RecyclerView.O000000o adapter = dqt.getAdapter();
                if (adapter != null && adapter.getItemCount() - 1 == recyclerView.getChildPosition(view)) {
                    if (this.f14852O000000o.O00000Oo() == 0) {
                        rect.right = this.O00000o;
                    } else {
                        rect.bottom = this.O00000o;
                    }
                }
            }
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqs(vafContext, dpg);
        }
    }
}
