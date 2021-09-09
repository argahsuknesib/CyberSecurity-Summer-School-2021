package _m_j;

import android.renderscript.BaseObj;
import android.renderscript.RSRuntimeException;
import android.renderscript.Script;
import android.renderscript.ScriptIntrinsicBlur;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;

final class hr extends hq {
    ScriptIntrinsicBlur O00000Oo;

    private hr(RenderScript renderScript) {
        super(0, renderScript);
    }

    public static hr O00000Oo(RenderScript renderScript, Element element) {
        hm hmVar = (hm) renderScript;
        hj hjVar = (hj) element;
        hr hrVar = new hr(renderScript);
        try {
            hrVar.O00000Oo = ScriptIntrinsicBlur.create(hmVar.O0000oO, hjVar.O00000oo);
            return hrVar;
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final void O000000o(Allocation allocation) {
        try {
            this.O00000Oo.setInput(((hh) allocation).O0000o00);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final void O000000o(float f) {
        try {
            this.O00000Oo.setRadius(f);
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final void O00000Oo(Allocation allocation) {
        hh hhVar = (hh) allocation;
        if (hhVar != null) {
            try {
                this.O00000Oo.forEach(hhVar.O0000o00);
            } catch (RSRuntimeException e) {
                throw hk.O000000o(e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ Script O000000o() {
        return this.O00000Oo;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ BaseObj O00000Oo() {
        return this.O00000Oo;
    }
}
