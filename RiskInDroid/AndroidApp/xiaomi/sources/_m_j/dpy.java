package _m_j;

import _m_j.dpf;
import android.view.View;
import android.view.ViewGroup;
import com.tmall.wireless.vaf.framework.VafContext;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
public final class dpy extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f14846O000000o = -1;
    private dpc O000o00O;

    public dpy(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public final void O00000o() {
        super.O00000o();
        if (this.O000o00O != null) {
            this.O000OoO0.O0000OoO().O000000o((dpb) this.O000o00O);
            ((ViewGroup) this.O00000Oo.O00000o0).removeView((View) this.O000o00O);
            this.O000o00O = null;
        }
    }

    public final void onComMeasure(int i, int i2) {
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            dpc.onComMeasure(i, i2);
        }
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            dpc.onComLayout(z, i, i2, i3, i4);
        }
    }

    public final int getComMeasuredWidth() {
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            return dpc.getComMeasuredWidth();
        }
        return 0;
    }

    public final int getComMeasuredHeight() {
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            return dpc.getComMeasuredHeight();
        }
        return 0;
    }

    public final void measureComponent(int i, int i2) {
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            dpc.measureComponent(i, i2);
        }
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            dpc.comLayout(i, i2, i3, i4);
        }
    }

    public final void O00000Oo(Object obj) {
        JSONObject optJSONObject;
        super.O00000Oo(obj);
        don O0000OoO = this.O000OoO0.O0000OoO();
        dpc dpc = this.O000o00O;
        if (dpc != null) {
            O0000OoO.O000000o((dpb) dpc);
            ((ViewGroup) this.O00000Oo.O00000o0).removeView((View) this.O000o00O);
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (this.f14846O000000o < jSONArray.length() && (optJSONObject = jSONArray.optJSONObject(this.f14846O000000o)) != null) {
                this.O000o00O = (dpc) O0000OoO.O000000o(optJSONObject.optString("type"));
                dpc dpc2 = this.O000o00O;
                if (dpc2 != null) {
                    dpf virtualView = ((dpb) dpc2).getVirtualView();
                    virtualView.O000000o(optJSONObject);
                    ((ViewGroup) this.O00000Oo.O00000o0).addView((View) this.O000o00O);
                    if (virtualView.O0000oo0()) {
                        this.O000OoO0.O00000Oo().O000000o(1, dpj.O000000o(this.O000OoO0, virtualView));
                    }
                }
            }
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        if (i != 106006350) {
            return false;
        }
        this.f14846O000000o = i2;
        return true;
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dpy(vafContext, dpg);
        }
    }
}
