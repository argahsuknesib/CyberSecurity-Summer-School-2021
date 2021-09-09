package _m_j;

import _m_j.dpd;
import _m_j.dpg;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class dpf implements dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14828O000000o;
    protected dpg O00000Oo;
    protected int O00000o;
    protected String O00000o0;
    protected boolean O00000oO;
    protected View O00000oo;
    protected int O0000O0o;
    protected int O0000OOo;
    protected int O0000Oo;
    protected Paint O0000Oo0;
    protected String O0000OoO;
    protected Bitmap O0000Ooo = null;
    protected int O0000o = 0;
    protected int O0000o0 = 0;
    protected Matrix O0000o00 = null;
    protected int O0000o0O = -16777216;
    protected int O0000o0o = 0;
    protected int O0000oO = 0;
    protected int O0000oO0 = 0;
    protected int O0000oOO = 0;
    protected float O0000oOo = Float.NaN;
    protected int O0000oo = 1;
    protected int O0000oo0;
    protected String O0000ooO;
    protected String O0000ooo;
    protected String O000O00o;
    protected String O000O0OO;
    protected String O000O0Oo;
    protected float O000O0o = 1.0f;
    protected int O000O0o0 = 0;
    protected float O000O0oO = 1.0f;
    protected int O000O0oo;
    protected int O000OO;
    protected int O000OO00;
    protected int O000OO0o;
    protected int O000OOOo;
    protected int O000OOo;
    protected int O000OOo0;
    protected int O000OOoO;
    protected int O000OOoo;
    protected int O000Oo0;
    protected int O000Oo00;
    protected String O000Oo0O;
    protected dpa O000Oo0o;
    protected Rect O000OoO;
    protected VafContext O000OoO0;
    protected dpd.O000000o O000OoOO;
    protected String O000OoOo;
    protected bnt O000Ooo;
    protected Object O000Ooo0;
    protected bnt O000OooO;
    protected bnt O000Oooo;
    private boolean O000o0;
    protected SparseArray<O00000Oo> O000o00;
    protected bnt O000o000;
    private boolean O000o00O;
    private boolean O000o00o;
    private o0OO00OO<String, Object> O000o0O;
    private boolean O000o0O0;
    private boolean O000o0OO;
    protected dpd O00O0Oo;
    protected String O00oOoOo;
    protected int O00oOooO = 1;
    protected Object O00oOooo;

    public interface O000000o {
        dpf O000000o(VafContext vafContext, dpg dpg);
    }

    public void O00000o0() {
    }

    public boolean O0000Oo0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void O000OOOo() {
    }

    public View g_() {
        return null;
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14830O000000o;
        Object O00000Oo;

        public O00000Oo(int i, Object obj) {
            this.f14830O000000o = i;
            this.O00000Oo = obj;
        }
    }

    public dpf(VafContext vafContext, dpg dpg) {
        this.O000OoO0 = vafContext;
        this.O00000Oo = dpg;
        this.O0000Oo = 0;
        this.O000OOOo = 9;
        this.O000OOoO = 0;
        this.O000O0oo = 0;
        this.O000OO0o = 0;
        this.O000OO00 = 0;
        this.O000OO = 0;
        this.O000OOoo = 0;
        this.O000Oo00 = 0;
        this.O0000oo0 = -1;
        this.O000OoOo = "";
        this.O00000o0 = "";
        this.O00000o = 0;
        this.O000Oo0 = 0;
    }

    public final void O000000o(View view) {
        this.O00000oo = view;
    }

    public final String O0000O0o() {
        return this.O000O0Oo;
    }

    public final dpg O0000OOo() {
        return this.O00000Oo;
    }

    /* access modifiers changed from: protected */
    public void O000000o(int i) {
        this.O0000Oo = i;
        View g_ = g_();
        if (g_ != null && !(g_ instanceof dqk)) {
            g_.setBackgroundColor(i);
        }
    }

    public final void O00000Oo(int i, int i2, int i3) {
        if (this.O000o00 == null) {
            this.O000o00 = new SparseArray<>();
        }
        Object obj = null;
        if (i == 1) {
            obj = Integer.valueOf(i3);
        } else if (i == 2) {
            obj = Float.valueOf(Float.intBitsToFloat(i3));
        } else if (i == 3) {
            obj = VafContext.O0000Oo0().O000000o(i3);
        }
        this.O000o00.put(i2, new O00000Oo(i, obj));
    }

    public final Object O00000Oo(int i) {
        O00000Oo o00000Oo;
        SparseArray<O00000Oo> sparseArray = this.O000o00;
        if (sparseArray == null || (o00000Oo = sparseArray.get(i)) == null) {
            return null;
        }
        return o00000Oo.O00000Oo;
    }

    public final boolean O00000o0(int i) {
        O00000Oo o00000Oo;
        SparseArray<O00000Oo> sparseArray = this.O000o00;
        if (sparseArray == null || (o00000Oo = sparseArray.get(i)) == null) {
            return false;
        }
        int i2 = o00000Oo.f14830O000000o;
        if (i2 == 1) {
            Log.e("ViewBase_TMTEST", "setUserVar set int failed");
            return false;
        } else if (i2 == 2) {
            Log.e("ViewBase_TMTEST", "setUserVar set float failed");
            return false;
        } else if (i2 != 3) {
            return false;
        } else {
            Log.e("ViewBase_TMTEST", "setUserVar set string failed");
            return false;
        }
    }

    public final int O0000Oo() {
        return this.O0000Oo;
    }

    public final int O0000OoO() {
        return this.O0000o0;
    }

    public final int O0000Ooo() {
        return this.O0000o;
    }

    public final int O0000o00() {
        return this.O0000oO0;
    }

    public final int O0000o0() {
        return this.O0000oO;
    }

    public final int O0000o0O() {
        return this.O0000oOO;
    }

    public final int O0000o0o() {
        return this.O000OOOo;
    }

    public final int O0000o() {
        return this.O000Oo0;
    }

    public final dpf O0000oO0() {
        dpd dpd = this.O00O0Oo;
        return dpd == null ? ((dpb) this.O00000Oo.O00000o0.getParent()).getVirtualView() : dpd;
    }

    private boolean O00000Oo() {
        return this.O00O0Oo == null;
    }

    public final int O0000oO() {
        dpd dpd = this.O00O0Oo;
        if (dpd == null) {
            return this.O0000oo;
        }
        int O0000oO2 = dpd.O0000oO();
        if (O0000oO2 == 1) {
            return this.O0000oo;
        }
        return O0000oO2 == 0 ? 0 : 2;
    }

    public final String O0000oOO() {
        return this.O00000o0;
    }

    public final void O00000Oo(String str) {
        this.O00000o0 = str;
    }

    public final void O00000o(int i) {
        this.O00000o = i;
    }

    public final boolean O0000oOo() {
        return (this.O000OOoO & 4) != 0;
    }

    public final boolean O0000oo0() {
        if ((this.O000OOoO & 16) != 0) {
            if (this.O0000oo == 1) {
                return true;
            }
        }
        return false;
    }

    private boolean O000OOo() {
        return (this.O000OOoO & 32) != 0;
    }

    private boolean O000OOoO() {
        return (this.O000OOoO & 64) != 0;
    }

    private boolean O000OOoo() {
        return (this.O000OOoO & NotificationCompat.FLAG_HIGH_PRIORITY) != 0;
    }

    /* access modifiers changed from: protected */
    public boolean O00000oo() {
        int O0000oO2 = O0000oO();
        View g_ = g_();
        if (g_ != null) {
            if (O0000oO2 == 0) {
                g_.setVisibility(4);
                return true;
            } else if (O0000oO2 == 1) {
                g_.setVisibility(0);
                return true;
            } else if (O0000oO2 != 2) {
                return true;
            } else {
                g_.setVisibility(8);
                return true;
            }
        } else if (!O0000Oo0()) {
            return false;
        } else {
            if (O0000oO2 == 0) {
                this.O00000Oo.O00000o0.setVisibility(4);
                return true;
            } else if (O0000oO2 == 1) {
                this.O00000Oo.O00000o0.setVisibility(0);
                return true;
            } else if (O0000oO2 != 2) {
                return true;
            } else {
                this.O00000Oo.O00000o0.setVisibility(8);
                return true;
            }
        }
    }

    public final boolean O0000oo() {
        return this.O0000oo == 2;
    }

    public final int O0000ooO() {
        return this.O0000oo;
    }

    public final int O0000ooo() {
        return this.O000OOo0;
    }

    public final String O00oOooO() {
        return this.O000OoOo;
    }

    public boolean O000000o(int i, int i2) {
        return O00000oO(this.O0000oo0);
    }

    /* access modifiers changed from: protected */
    public final boolean O00000oO(int i) {
        dpd dpd;
        boolean O000Oo002 = O000Oo00();
        return (O000Oo002 || (dpd = this.O00O0Oo) == null) ? O000Oo002 : dpd.O00000oO(i);
    }

    private boolean O000Oo00() {
        return O000OOo() || O000OOoO() || O000OOoo();
    }

    public boolean O000000o(int i, int i2, boolean z) {
        return O000000o(this.O0000oo0, z);
    }

    public final boolean O000000o(View view, MotionEvent motionEvent) {
        if (O000OOoo()) {
            return this.O000OoO0.O00000Oo().O000000o(5, dpj.O000000o(this.O000OoO0, this, view, motionEvent));
        }
        return false;
    }

    public final int O00oOooo() {
        return this.O0000O0o;
    }

    public final int O000O00o() {
        return this.O0000OOo;
    }

    public final void O00000Oo(View view) {
        this.O00000Oo.O00000o0 = view;
        if ((this.O000OOoO & 8) != 0) {
            view.setLayerType(1, null);
        }
    }

    public void O00000o() {
        this.O000OoO = null;
        this.O00000oO = false;
    }

    public final void O000O0OO() {
        int i = this.O0000O0o;
        int i2 = this.O0000OOo;
        int i3 = this.O000OOo0 + i;
        int i4 = this.O000OOo + i2;
        View view = this.O00000oo;
        if (view != null) {
            view.invalidate(i, i2, i3, i4);
        }
    }

    public dpf O000000o(String str) {
        if (TextUtils.equals(this.O000OoOo, str)) {
            return this;
        }
        return null;
    }

    public final boolean O000O0Oo() {
        return this.O0000oo == 1;
    }

    public final int O00oOoOo() {
        return this.O000O0oo;
    }

    public final int O000O0o0() {
        return this.O000OO0o;
    }

    public final int O000O0o() {
        return this.O000OO00;
    }

    public final int O000O0oO() {
        return this.O000OO;
    }

    public final void O000000o(dpd.O000000o o000000o) {
        this.O000OoOO = o000000o;
    }

    public final dpd.O000000o O000O0oo() {
        return this.O000OoOO;
    }

    /* access modifiers changed from: protected */
    public final void O00000o(int i, int i2) {
        this.O000OOo0 = i;
        this.O000OOo = i2;
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        this.O0000O0o = i;
        this.O0000OOo = i2;
        onComLayout(true, i, i2, i3, i4);
    }

    public void measureComponent(int i, int i2) {
        int i3 = this.O000O0o0;
        if (i3 > 0) {
            if (i3 != 1) {
                if (i3 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O000O0o) / this.O000O0oO), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O000O0oO) / this.O000O0o), 1073741824);
            }
        }
        onComMeasure(i, i2);
    }

    public final int O000OO00() {
        return getComMeasuredWidth() + this.O000OoOO.O00000o + this.O000OoOO.O00000oo;
    }

    public final int O000OO0o() {
        return getComMeasuredHeight() + this.O000OoOO.O0000OOo + this.O000OoOO.O0000Oo;
    }

    public final void O000000o(Object obj) {
        O00000o0(obj);
    }

    private void O00000o0(Object obj) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection("ViewBase.setVData");
        }
        this.O00000Oo.O00000Oo = obj;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            boolean optBoolean = jSONObject.optBoolean("_flag_invalidate_");
            List<dpf> list = this.O00000Oo.f14832O000000o;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    dpf dpf = list.get(i);
                    List<dpg.O000000o> O000000o2 = this.O00000Oo.O000000o(dpf);
                    if (O000000o2 != null) {
                        int size2 = O000000o2.size();
                        for (int i2 = 0; i2 < size2; i2++) {
                            dpg.O000000o o000000o = O000000o2.get(i2);
                            if (optBoolean) {
                                o000000o.O000000o(obj.hashCode());
                            }
                            o000000o.O000000o(obj, false);
                        }
                        dpf.O00000oO();
                        if (!dpf.O00000Oo() && dpf.O0000oo0()) {
                            this.O000OoO0.O00000Oo().O000000o(1, dpj.O000000o(this.O000OoO0, dpf));
                        }
                    }
                }
            }
            jSONObject.remove("_flag_invalidate_");
        }
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public void O00000Oo(Object obj) {
        this.O00oOooo = obj;
        if (this.O000o000 != null) {
            dmu O00000oO2 = this.O000OoO0.O00000oO();
            if (O00000oO2 == null || !O00000oO2.O000000o(this, this.O000o000)) {
                Log.e("ViewBase_TMTEST", "setData execute failed");
            }
        }
    }

    public void O000000o(Canvas canvas) {
        canvas.save();
        canvas.translate((float) this.O0000O0o, (float) this.O0000OOo);
        O00000Oo(canvas);
        canvas.restore();
        this.O00000oO = true;
    }

    /* access modifiers changed from: protected */
    public void O00000Oo(Canvas canvas) {
        if (g_() == null) {
            int i = this.O0000Oo;
            if (i != 0) {
                dov.O00000Oo(canvas, i, this.O000OOo0, this.O000OOo, this.O0000o0, this.O0000o, this.O0000oO0, this.O0000oO, this.O0000oOO);
                return;
            }
            Bitmap bitmap = this.O0000Ooo;
            if (bitmap != null) {
                this.O0000o00.setScale(((float) this.O000OOo0) / ((float) bitmap.getWidth()), ((float) this.O000OOo) / ((float) this.O0000Ooo.getHeight()));
                canvas.drawBitmap(this.O0000Ooo, this.O0000o00, null);
            }
        }
    }

    public final void O00000o0(Canvas canvas) {
        dov.O000000o(canvas, this.O0000o0O, this.O000OOo0, this.O000OOo, this.O0000o0, this.O0000o, this.O0000oO0, this.O0000oO, this.O0000oOO);
    }

    public int getComMeasuredWidth() {
        return this.O000OOo0;
    }

    public int getComMeasuredHeight() {
        return this.O000OOo;
    }

    public final boolean O000000o(int i, bnt bnt) {
        boolean O00000Oo2 = O00000Oo(i, bnt);
        if (O00000Oo2 || this.O000OoOO == null) {
            return O00000Oo2;
        }
        return false;
    }

    public final String O000OO() {
        return this.O000O0OO;
    }

    public final boolean O00000o0(int i, float f) {
        dpd.O000000o o000000o;
        boolean O000000o2 = O000000o(i, f);
        return (O000000o2 || (o000000o = this.O000OoOO) == null) ? O000000o2 : o000000o.O000000o(i, f);
    }

    public final boolean O00000o(int i, float f) {
        dpd.O000000o o000000o;
        boolean O00000Oo2 = O00000Oo(i, f);
        return (O00000Oo2 || (o000000o = this.O000OoOO) == null) ? O00000Oo2 : o000000o.O00000Oo(i, f);
    }

    public final boolean O00000oo(int i, int i2) {
        dpd.O000000o o000000o;
        boolean O00000Oo2 = O00000Oo(i, i2);
        return (O00000Oo2 || (o000000o = this.O000OoOO) == null) ? O00000Oo2 : o000000o.O000000o(i, i2);
    }

    public final boolean O0000O0o(int i, int i2) {
        dpd.O000000o o000000o;
        boolean O00000o02 = O00000o0(i, i2);
        return (O00000o02 || (o000000o = this.O000OoOO) == null) ? O00000o02 : o000000o.O00000Oo(i, i2);
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, bnt bnt) {
        switch (i) {
            case -1351902487:
                this.O000Ooo = bnt;
                break;
            case -974184371:
                this.O000o000 = bnt;
                break;
            case -251005427:
                this.O000Oooo = bnt;
                break;
            case 361078798:
                this.O000OooO = bnt;
                break;
            default:
                return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(int i, float f) {
        switch (i) {
            case -2037919555:
                this.O000OoOO.O0000OOo = bns.O000000o((double) f);
                this.O000OoOO.O0000Oo0 = true;
                return true;
            case -1501175880:
                this.O000O0oo = bns.O000000o((double) f);
                this.O000o00O = true;
                return true;
            case -1375815020:
                this.O000OOoo = bns.O000000o((double) f);
                return true;
            case -1228066334:
                this.O0000o = bns.O000000o((double) f);
                return true;
            case -806339567:
                this.f14828O000000o = bns.O000000o((double) f);
                if (!this.O000o00O) {
                    this.O000O0oo = this.f14828O000000o;
                }
                if (!this.O000o00o) {
                    this.O000OO00 = this.f14828O000000o;
                }
                if (!this.O000o0) {
                    this.O000OO0o = this.f14828O000000o;
                }
                if (this.O000o0O0) {
                    return true;
                }
                this.O000OO = this.f14828O000000o;
                return true;
            case -133587431:
                this.O000Oo00 = bns.O000000o((double) f);
                return true;
            case 62363524:
                this.O000OoOO.O00000oo = bns.O000000o((double) f);
                this.O000OoOO.O0000O0o = true;
                return true;
            case 90130308:
                this.O000OO0o = bns.O000000o((double) f);
                this.O000o0 = true;
                return true;
            case 202355100:
                this.O000OO = bns.O000000o((double) f);
                this.O000o0O0 = true;
                return true;
            case 333432965:
                this.O0000oO0 = bns.O000000o((double) f);
                return true;
            case 581268560:
                this.O0000oO = bns.O000000o((double) f);
                return true;
            case 588239831:
                this.O0000oOO = bns.O000000o((double) f);
                return true;
            case 713848971:
                this.O000OO00 = bns.O000000o((double) f);
                this.O000o00o = true;
                return true;
            case 741115130:
                this.O0000o0 = bns.O000000o((double) f);
                return true;
            case 1248755103:
                this.O000OoOO.O00000o = bns.O000000o((double) f);
                this.O000OoOO.O00000oO = true;
                return true;
            case 1349188574:
                this.O0000o0o = bns.O000000o((double) f);
                if (this.O0000o <= 0) {
                    this.O0000o = this.O0000o0o;
                }
                if (this.O0000oO0 <= 0) {
                    this.O0000oO0 = this.O0000o0o;
                }
                if (this.O0000oO <= 0) {
                    this.O0000oO = this.O0000o0o;
                }
                if (this.O0000oOO > 0) {
                    return true;
                }
                this.O0000oOO = this.O0000o0o;
                return true;
            case 1481142723:
                this.O000OoOO.O0000Oo = bns.O000000o((double) f);
                this.O000OoOO.O0000OoO = true;
                return true;
            case 1557524721:
                if (f > -1.0f) {
                    this.O000OoOO.O00000Oo = bns.O000000o((double) f);
                    return true;
                }
                this.O000OoOO.O00000Oo = (int) f;
                return true;
            case 1697244536:
                this.O000OoOO.O00000o0 = bns.O000000o((double) f);
                if (!this.O000OoOO.O00000oO) {
                    dpd.O000000o o000000o = this.O000OoOO;
                    o000000o.O00000o = o000000o.O00000o0;
                }
                if (!this.O000OoOO.O0000O0o) {
                    dpd.O000000o o000000o2 = this.O000OoOO;
                    o000000o2.O00000oo = o000000o2.O00000o0;
                }
                if (!this.O000OoOO.O0000Oo0) {
                    dpd.O000000o o000000o3 = this.O000OoOO;
                    o000000o3.O0000OOo = o000000o3.O00000o0;
                }
                if (this.O000OoOO.O0000OoO) {
                    return true;
                }
                dpd.O000000o o000000o4 = this.O000OoOO;
                o000000o4.O0000Oo = o000000o4.O00000o0;
                return true;
            case 2003872956:
                if (f > -1.0f) {
                    this.O000OoOO.f14826O000000o = bns.O000000o((double) f);
                    return true;
                }
                this.O000OoOO.f14826O000000o = (int) f;
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, float f) {
        switch (i) {
            case -2037919555:
                this.O000OoOO.O0000OOo = bns.O00000Oo((double) f);
                this.O000OoOO.O0000Oo0 = true;
                return true;
            case -1501175880:
                this.O000O0oo = bns.O00000Oo((double) f);
                this.O000o00O = true;
                return true;
            case -1375815020:
                this.O000OOoo = bns.O00000Oo((double) f);
                return true;
            case -1228066334:
                this.O0000o = bns.O00000Oo((double) f);
                return true;
            case -806339567:
                this.f14828O000000o = bns.O00000Oo((double) f);
                if (!this.O000o00O) {
                    this.O000O0oo = this.f14828O000000o;
                }
                if (!this.O000o00o) {
                    this.O000OO00 = this.f14828O000000o;
                }
                if (!this.O000o0) {
                    this.O000OO0o = this.f14828O000000o;
                }
                if (this.O000o0O0) {
                    return true;
                }
                this.O000OO = this.f14828O000000o;
                return true;
            case -133587431:
                this.O000Oo00 = bns.O00000Oo((double) f);
                return true;
            case 62363524:
                this.O000OoOO.O00000oo = bns.O00000Oo((double) f);
                this.O000OoOO.O0000O0o = true;
                return true;
            case 90130308:
                this.O000OO0o = bns.O00000Oo((double) f);
                this.O000o0 = true;
                return true;
            case 92909918:
                this.O0000oOo = f;
                return true;
            case 202355100:
                this.O000OO = bns.O00000Oo((double) f);
                this.O000o0O0 = true;
                return true;
            case 333432965:
                this.O0000oO0 = bns.O00000Oo((double) f);
                return true;
            case 581268560:
                this.O0000oO = bns.O00000Oo((double) f);
                return true;
            case 588239831:
                this.O0000oOO = bns.O00000Oo((double) f);
                return true;
            case 713848971:
                this.O000OO00 = bns.O00000Oo((double) f);
                this.O000o00o = true;
                return true;
            case 741115130:
                this.O0000o0 = bns.O00000Oo((double) f);
                return true;
            case 1248755103:
                this.O000OoOO.O00000o = bns.O00000Oo((double) f);
                this.O000OoOO.O00000oO = true;
                return true;
            case 1349188574:
                this.O0000o0o = bns.O00000Oo((double) f);
                if (this.O0000o <= 0) {
                    this.O0000o = this.O0000o0o;
                }
                if (this.O0000oO0 <= 0) {
                    this.O0000oO0 = this.O0000o0o;
                }
                if (this.O0000oO <= 0) {
                    this.O0000oO = this.O0000o0o;
                }
                if (this.O0000oOO > 0) {
                    return true;
                }
                this.O0000oOO = this.O0000o0o;
                return true;
            case 1438248735:
                this.O000O0o = f;
                return true;
            case 1438248736:
                this.O000O0oO = f;
                return true;
            case 1481142723:
                this.O000OoOO.O0000Oo = bns.O00000Oo((double) f);
                this.O000OoOO.O0000OoO = true;
                return true;
            case 1557524721:
                if (f > -1.0f) {
                    this.O000OoOO.O00000Oo = bns.O00000Oo((double) f);
                    return true;
                }
                this.O000OoOO.O00000Oo = (int) f;
                return true;
            case 1697244536:
                this.O000OoOO.O00000o0 = bns.O00000Oo((double) f);
                if (!this.O000OoOO.O00000oO) {
                    dpd.O000000o o000000o = this.O000OoOO;
                    o000000o.O00000o = o000000o.O00000o0;
                }
                if (!this.O000OoOO.O0000O0o) {
                    dpd.O000000o o000000o2 = this.O000OoOO;
                    o000000o2.O00000oo = o000000o2.O00000o0;
                }
                if (!this.O000OoOO.O0000Oo0) {
                    dpd.O000000o o000000o3 = this.O000OoOO;
                    o000000o3.O0000OOo = o000000o3.O00000o0;
                }
                if (this.O000OoOO.O0000OoO) {
                    return true;
                }
                dpd.O000000o o000000o4 = this.O000OoOO;
                o000000o4.O0000Oo = o000000o4.O00000o0;
                return true;
            case 2003872956:
                if (f > -1.0f) {
                    this.O000OoOO.f14826O000000o = bns.O00000Oo((double) f);
                    return true;
                }
                this.O000OoOO.f14826O000000o = (int) f;
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean O000000o(int i, String str) {
        switch (i) {
            case -2037919555:
                this.O00000Oo.O000000o(this, -2037919555, str, 1);
                break;
            case -1501175880:
                this.O00000Oo.O000000o(this, -1501175880, str, 1);
                break;
            case -1422950858:
                if (!bns.O000000o(str)) {
                    this.O000O0Oo = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, -1422950858, str, 2);
                    break;
                }
            case -1422893274:
                this.O00000Oo.O000000o(this, -1422893274, str, 0);
                break;
            case -1332194002:
                this.O00000Oo.O000000o(this, -1332194002, str, 3);
                break;
            case -1228066334:
                this.O00000Oo.O000000o(this, -1228066334, str, 1);
                break;
            case -806339567:
                this.O00000Oo.O000000o(this, -806339567, str, 1);
                break;
            case -377785597:
                if (!bns.O000000o(str)) {
                    this.O0000ooo = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, -377785597, str, 2);
                    break;
                }
            case 114586:
                if (!bns.O000000o(str)) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string = jSONObject.getString(next);
                                if (this.O000o0O == null) {
                                    this.O000o0O = new o0OO00OO<>();
                                }
                                this.O000o0O.put(next, string);
                            }
                            break;
                        } catch (JSONException unused) {
                            this.O000Ooo0 = str;
                            break;
                        }
                    }
                } else {
                    this.O00000Oo.O000000o(this, 114586, str, 2);
                    break;
                }
                break;
            case 3076010:
                if (!bns.O000000o(str)) {
                    this.O000O00o = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 3076010, str, 2);
                    break;
                }
            case 3373707:
                if (!bns.O000000o(str)) {
                    this.O000OoOo = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 3373707, str, 2);
                    break;
                }
            case 62363524:
                this.O00000Oo.O000000o(this, 62363524, str, 1);
                break;
            case 90130308:
                this.O00000Oo.O000000o(this, 90130308, str, 1);
                break;
            case 92909918:
                this.O00000Oo.O000000o(this, 92909918, str, 1);
                break;
            case 94742904:
                if (!bns.O000000o(str)) {
                    this.O000Oo0O = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 94742904, str, 2);
                    break;
                }
            case 202355100:
                this.O00000Oo.O000000o(this, 202355100, str, 1);
                break;
            case 280523342:
                this.O00000Oo.O000000o(this, 280523342, str, 6);
                break;
            case 333432965:
                this.O00000Oo.O000000o(this, 333432965, str, 1);
                break;
            case 581268560:
                this.O00000Oo.O000000o(this, 581268560, str, 1);
                break;
            case 588239831:
                this.O00000Oo.O000000o(this, 588239831, str, 1);
                break;
            case 713848971:
                this.O00000Oo.O000000o(this, 713848971, str, 1);
                break;
            case 722830999:
                this.O00000Oo.O000000o(this, 722830999, str, 3);
                break;
            case 741115130:
                this.O00000Oo.O000000o(this, 741115130, str, 1);
                break;
            case 1248755103:
                this.O00000Oo.O000000o(this, 1248755103, str, 1);
                break;
            case 1292595405:
                if (!bns.O000000o(str)) {
                    this.O0000OoO = str;
                    this.O0000Ooo = null;
                    if (this.O0000o00 == null) {
                        this.O0000o00 = new Matrix();
                    }
                    new Object() {
                        /* class _m_j.dpf.AnonymousClass1 */
                    };
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 1292595405, str, 2);
                    break;
                }
            case 1349188574:
                this.O00000Oo.O000000o(this, 1349188574, str, 1);
                break;
            case 1438248735:
                this.O00000Oo.O000000o(this, 1438248735, str, 1);
                break;
            case 1438248736:
                this.O00000Oo.O000000o(this, 1438248736, str, 1);
                break;
            case 1443184528:
                if (!bns.O000000o(str)) {
                    this.O000O0OO = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 1443184528, str, 7);
                    break;
                }
            case 1443186021:
                if (!bns.O000000o(str)) {
                    this.O0000ooO = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 1443186021, str, 2);
                    break;
                }
            case 1481142723:
                this.O00000Oo.O000000o(this, 1481142723, str, 1);
                break;
            case 1557524721:
                this.O00000Oo.O000000o(this, 1557524721, str, 1);
                this.O000OoOO.O00000Oo = -2;
                break;
            case 1569332215:
                if (!bns.O000000o(str)) {
                    this.O00oOoOo = str;
                    break;
                } else {
                    this.O00000Oo.O000000o(this, 1569332215, str, 2);
                    break;
                }
            case 1697244536:
                this.O00000Oo.O000000o(this, 1697244536, str, 1);
                break;
            case 1941332754:
                this.O00000Oo.O000000o(this, 1941332754, str, 5);
                break;
            case 2003872956:
                this.O00000Oo.O000000o(this, 2003872956, str, 1);
                this.O000OoOO.f14826O000000o = -2;
                break;
            default:
                return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    /* access modifiers changed from: protected */
    public boolean O00000Oo(int i, int i2) {
        switch (i) {
            case -2037919555:
                this.O000OoOO.O0000OOo = bns.O000000o((double) i2);
                this.O000OoOO.O0000Oo0 = true;
                return true;
            case -1501175880:
                this.O000O0oo = bns.O000000o((double) i2);
                this.O000o00O = true;
                return true;
            case -1375815020:
                this.O000OOoo = bns.O000000o((double) i2);
                return true;
            case -1228066334:
                this.O0000o = bns.O000000o((double) i2);
                return true;
            case -806339567:
                this.f14828O000000o = bns.O000000o((double) i2);
                if (!this.O000o00O) {
                    this.O000O0oo = this.f14828O000000o;
                }
                if (!this.O000o00o) {
                    this.O000OO00 = this.f14828O000000o;
                }
                if (!this.O000o0) {
                    this.O000OO0o = this.f14828O000000o;
                }
                if (this.O000o0O0) {
                    return true;
                }
                this.O000OO = this.f14828O000000o;
                return true;
            case -133587431:
                this.O000Oo00 = bns.O000000o((double) i2);
                return true;
            case 62363524:
                this.O000OoOO.O00000oo = bns.O000000o((double) i2);
                this.O000OoOO.O0000O0o = true;
                return true;
            case 90130308:
                this.O000OO0o = bns.O000000o((double) i2);
                this.O000o0 = true;
                return true;
            case 202355100:
                this.O000OO = bns.O000000o((double) i2);
                this.O000o0O0 = true;
                return true;
            case 333432965:
                this.O0000oO0 = bns.O000000o((double) i2);
                return true;
            case 581268560:
                this.O0000oO = bns.O000000o((double) i2);
                return true;
            case 588239831:
                this.O0000oOO = bns.O000000o((double) i2);
                return true;
            case 713848971:
                this.O000OO00 = bns.O000000o((double) i2);
                this.O000o00o = true;
                return true;
            case 741115130:
                this.O0000o0 = bns.O000000o((double) i2);
                return true;
            case 1248755103:
                this.O000OoOO.O00000o = bns.O000000o((double) i2);
                this.O000OoOO.O00000oO = true;
                return true;
            case 1349188574:
                this.O0000o0o = bns.O000000o((double) i2);
                if (this.O0000o <= 0) {
                    this.O0000o = this.O0000o0o;
                }
                if (this.O0000oO0 <= 0) {
                    this.O0000oO0 = this.O0000o0o;
                }
                if (this.O0000oO <= 0) {
                    this.O0000oO = this.O0000o0o;
                }
                if (this.O0000oOO > 0) {
                    return true;
                }
                this.O0000oOO = this.O0000o0o;
                return true;
            case 1481142723:
                this.O000OoOO.O0000Oo = bns.O000000o((double) i2);
                this.O000OoOO.O0000OoO = true;
                return true;
            case 1557524721:
                if (i2 >= 0) {
                    this.O000OoOO.O00000Oo = bns.O000000o((double) i2);
                    return true;
                }
                this.O000OoOO.O00000Oo = i2;
                return true;
            case 1697244536:
                this.O000OoOO.O00000o0 = bns.O000000o((double) i2);
                if (!this.O000OoOO.O00000oO) {
                    dpd.O000000o o000000o = this.O000OoOO;
                    o000000o.O00000o = o000000o.O00000o0;
                }
                if (!this.O000OoOO.O0000O0o) {
                    dpd.O000000o o000000o2 = this.O000OoOO;
                    o000000o2.O00000oo = o000000o2.O00000o0;
                }
                if (!this.O000OoOO.O0000Oo0) {
                    dpd.O000000o o000000o3 = this.O000OoOO;
                    o000000o3.O0000OOo = o000000o3.O00000o0;
                }
                if (this.O000OoOO.O0000OoO) {
                    return true;
                }
                dpd.O000000o o000000o4 = this.O000OoOO;
                o000000o4.O0000Oo = o000000o4.O00000o0;
                return true;
            case 2003872956:
                if (i2 >= 0) {
                    this.O000OoOO.f14826O000000o = bns.O000000o((double) i2);
                    return true;
                }
                this.O000OoOO.f14826O000000o = i2;
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean O00000o0(int i, int i2) {
        switch (i) {
            case -2037919555:
                this.O000OoOO.O0000OOo = bns.O00000Oo((double) i2);
                this.O000OoOO.O0000Oo0 = true;
                return true;
            case -1501175880:
                this.O000O0oo = bns.O00000Oo((double) i2);
                this.O000o00O = true;
                return true;
            case -1422893274:
                this.O000O0o0 = i2;
                return true;
            case -1375815020:
                this.O000OOoo = bns.O00000Oo((double) i2);
                return true;
            case -1332194002:
                O000000o(i2);
                return true;
            case -1228066334:
                this.O0000o = bns.O00000Oo((double) i2);
                return true;
            case -806339567:
                this.f14828O000000o = bns.O00000Oo((double) i2);
                if (!this.O000o00O) {
                    this.O000O0oo = this.f14828O000000o;
                }
                if (!this.O000o00o) {
                    this.O000OO00 = this.f14828O000000o;
                }
                if (!this.O000o0) {
                    this.O000OO0o = this.f14828O000000o;
                }
                if (this.O000o0O0) {
                    return true;
                }
                this.O000OO = this.f14828O000000o;
                return true;
            case -133587431:
                this.O000Oo00 = bns.O00000Oo((double) i2);
                return true;
            case 3355:
                this.O0000oo0 = i2;
                return true;
            case 3145580:
                this.O000OOoO = i2;
                return true;
            case 3601339:
                this.O000Oo0 = i2;
                return true;
            case 62363524:
                this.O000OoOO.O00000oo = bns.O00000Oo((double) i2);
                this.O000OoOO.O0000O0o = true;
                return true;
            case 90130308:
                this.O000OO0o = bns.O00000Oo((double) i2);
                this.O000o0 = true;
                return true;
            case 202355100:
                this.O000OO = bns.O00000Oo((double) i2);
                this.O000o0O0 = true;
                return true;
            case 280523342:
                this.O000OOOo = i2;
                return true;
            case 333432965:
                this.O0000oO0 = bns.O00000Oo((double) i2);
                return true;
            case 581268560:
                this.O0000oO = bns.O00000Oo((double) i2);
                return true;
            case 588239831:
                this.O0000oOO = bns.O00000Oo((double) i2);
                return true;
            case 713848971:
                this.O000OO00 = bns.O00000Oo((double) i2);
                this.O000o00o = true;
                return true;
            case 722830999:
                this.O0000o0O = i2;
                return true;
            case 741115130:
                this.O0000o0 = bns.O00000Oo((double) i2);
                return true;
            case 1248755103:
                this.O000OoOO.O00000o = bns.O00000Oo((double) i2);
                this.O000OoOO.O00000oO = true;
                return true;
            case 1349188574:
                this.O0000o0o = bns.O00000Oo((double) i2);
                if (this.O0000o <= 0) {
                    this.O0000o = this.O0000o0o;
                }
                if (this.O0000oO0 <= 0) {
                    this.O0000oO0 = this.O0000o0o;
                }
                if (this.O0000oO <= 0) {
                    this.O0000oO = this.O0000o0o;
                }
                if (this.O0000oOO > 0) {
                    return true;
                }
                this.O0000oOO = this.O0000o0o;
                return true;
            case 1438248735:
                this.O000O0o = (float) i2;
                return true;
            case 1438248736:
                this.O000O0oO = (float) i2;
                return true;
            case 1481142723:
                this.O000OoOO.O0000Oo = bns.O00000Oo((double) i2);
                this.O000OoOO.O0000OoO = true;
                return true;
            case 1557524721:
                if (i2 >= 0) {
                    this.O000OoOO.O00000Oo = bns.O00000Oo((double) i2);
                    return true;
                }
                this.O000OoOO.O00000Oo = i2;
                return true;
            case 1697244536:
                this.O000OoOO.O00000o0 = bns.O00000Oo((double) i2);
                if (!this.O000OoOO.O00000oO) {
                    dpd.O000000o o000000o = this.O000OoOO;
                    o000000o.O00000o = o000000o.O00000o0;
                }
                if (!this.O000OoOO.O0000O0o) {
                    dpd.O000000o o000000o2 = this.O000OoOO;
                    o000000o2.O00000oo = o000000o2.O00000o0;
                }
                if (!this.O000OoOO.O0000Oo0) {
                    dpd.O000000o o000000o3 = this.O000OoOO;
                    o000000o3.O0000OOo = o000000o3.O00000o0;
                }
                if (this.O000OoOO.O0000OoO) {
                    return true;
                }
                dpd.O000000o o000000o4 = this.O000OoOO;
                o000000o4.O0000Oo = o000000o4.O00000o0;
                return true;
            case 1788852333:
                this.O00oOooO = i2;
                return true;
            case 1941332754:
                this.O0000oo = i2;
                O00000oo();
                return true;
            case 2003872956:
                if (i2 >= 0) {
                    this.O000OoOO.f14826O000000o = bns.O00000Oo((double) i2);
                    return true;
                }
                this.O000OoOO.f14826O000000o = i2;
                return true;
            default:
                return false;
        }
    }

    public class O00000o0 implements dpc {

        /* renamed from: O000000o  reason: collision with root package name */
        protected dpf f14831O000000o;
        protected int O00000Oo = 0;
        protected boolean O00000o;
        protected int O00000o0 = 0;

        public final void comLayout(int i, int i2, int i3, int i4) {
        }

        public final int getComMeasuredHeight() {
            return 0;
        }

        public final int getComMeasuredWidth() {
            return 0;
        }

        public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public O00000o0() {
            dpf.this.O0000Oo0 = new Paint();
            dpf.this.O0000Oo0.setAntiAlias(true);
            O00000Oo();
        }

        public final void O000000o(dpf dpf) {
            this.f14831O000000o = dpf;
        }

        public final void O000000o() {
            dpf.this.O0000Oo0.setAntiAlias(true);
        }

        public final void O00000Oo() {
            this.O00000Oo = 0;
            this.O00000o0 = 0;
            this.O00000o = false;
            dpf dpf = dpf.this;
            dpf.O0000Ooo = null;
            dpf.O0000OoO = null;
        }

        public final void measureComponent(int i, int i2) {
            if (i != this.O00000Oo || i2 != this.O00000o0 || this.O00000o) {
                onComMeasure(i, i2);
                this.O00000Oo = i;
                this.O00000o0 = i2;
                this.O00000o = false;
            }
        }

        public final void onComMeasure(int i, int i2) {
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (dpf.this.O000OoO == null) {
                dpf.this.O000OOOo();
            }
            int i3 = this.f14831O000000o.O000O0o0;
            float f = this.f14831O000000o.O000O0o;
            float f2 = this.f14831O000000o.O000O0oO;
            if (i3 > 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        if (1073741824 == View.MeasureSpec.getMode(i2)) {
                            dpf.this.O000OOo = View.MeasureSpec.getSize(i2);
                            dpf dpf = dpf.this;
                            dpf.O000OOo0 = (int) ((((float) dpf.O000OOo) * f) / f2);
                            return;
                        }
                        return;
                    }
                } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                    dpf.this.O000OOo0 = View.MeasureSpec.getSize(i);
                    dpf dpf2 = dpf.this;
                    dpf2.O000OOo = (int) ((((float) dpf2.O000OOo0) * f2) / f);
                    return;
                } else {
                    return;
                }
            }
            if (-2 == dpf.this.O000OoOO.f14826O000000o) {
                if (dpf.this.O000OoO != null) {
                    dpf dpf3 = dpf.this;
                    dpf3.O000OOo0 = dpf3.O000OoO.width() + dpf.this.O000O0oo + dpf.this.O000OO00;
                } else {
                    dpf dpf4 = dpf.this;
                    dpf4.O000OOo0 = dpf4.O000OOoo;
                }
            } else if (-1 == dpf.this.O000OoOO.f14826O000000o) {
                if (1073741824 == mode) {
                    dpf.this.O000OOo0 = size;
                } else {
                    dpf.this.O000OOo0 = 0;
                }
            } else if (1073741824 == mode) {
                dpf.this.O000OOo0 = size;
            } else {
                dpf dpf5 = dpf.this;
                dpf5.O000OOo0 = dpf5.O000OoOO.f14826O000000o;
            }
            if (-2 == dpf.this.O000OoOO.O00000Oo) {
                if (dpf.this.O000OoO != null) {
                    dpf dpf6 = dpf.this;
                    dpf6.O000OOo = dpf6.O000OoO.height() + dpf.this.O000OO0o + dpf.this.O000OO;
                    return;
                }
                dpf dpf7 = dpf.this;
                dpf7.O000OOo = dpf7.O000Oo00;
            } else if (-1 == dpf.this.O000OoOO.O00000Oo) {
                if (1073741824 == mode2) {
                    dpf.this.O000OOo = size2;
                } else {
                    dpf.this.O000OOo = 0;
                }
            } else if (1073741824 == mode2) {
                dpf.this.O000OOo = size2;
            } else {
                dpf dpf8 = dpf.this;
                dpf8.O000OOo = dpf8.O000OoOO.O00000Oo;
            }
        }
    }

    public final boolean O000OOo0() {
        return dos.O000000o() && !this.O000o0OO;
    }

    /* access modifiers changed from: protected */
    public final boolean O000000o(int i, boolean z) {
        dpd dpd;
        boolean z2 = false;
        if (!z) {
            if (this.O000Ooo != null) {
                dmu O00000oO2 = this.O000OoO0.O00000oO();
                if (O00000oO2 != null) {
                    O00000oO2.f14795O000000o.O00000o0.O000000o((JSONObject) this.O00000Oo.O00000Oo);
                }
                if (O00000oO2 == null || !O00000oO2.O000000o(this, this.O000Ooo)) {
                    Log.e("ViewBase_TMTEST", "onClick execute failed");
                }
            }
            if (O000OOo()) {
                z2 = this.O000OoO0.O00000Oo().O000000o(0, dpj.O000000o(this.O000OoO0, this));
            }
        } else if (O000OOoO()) {
            z2 = this.O000OoO0.O00000Oo().O000000o(4, dpj.O000000o(this.O000OoO0, this));
        }
        return (z2 || (dpd = this.O00O0Oo) == null) ? z2 : dpd.O000000o(dpd.O0000oo0, z);
    }

    public void O00000oO() {
        if (O000OOo0()) {
            int i = this.O000O0oo;
            this.O000O0oo = this.O000OO00;
            this.O000OO00 = i;
        }
        if (g_() != null) {
            g_().setPadding(this.O000O0oo, this.O000OO0o, this.O000OO00, this.O000OO);
        }
        if (!TextUtils.isEmpty(this.O000Oo0O)) {
            try {
                dop O00000o02 = this.O000OoO0.O00000o0();
                Class cls = O00000o02.f14812O000000o.get(this.O000Oo0O);
                if (cls != null && this.O000Oo0o == null) {
                    Object newInstance = cls.newInstance();
                    if (newInstance instanceof dpa) {
                        this.O000Oo0o = (dpa) newInstance;
                        return;
                    }
                    Log.e("ViewBase_TMTEST", this.O000Oo0O + " is not bean");
                }
            } catch (InstantiationException e) {
                Log.e("ViewBase_TMTEST", "error:".concat(String.valueOf(e)));
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                Log.e("ViewBase_TMTEST", "error:".concat(String.valueOf(e2)));
                e2.printStackTrace();
            }
        }
    }

    public final boolean O00000oO(int i, int i2) {
        boolean O000000o2 = O000000o(i, VafContext.O0000Oo0().O000000o(i2));
        if (O000000o2 || this.O000OoOO == null) {
            return O000000o2;
        }
        return false;
    }
}
