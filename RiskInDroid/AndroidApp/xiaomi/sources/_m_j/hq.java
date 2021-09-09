package _m_j;

import android.renderscript.RSRuntimeException;
import androidx.renderscript.Allocation;
import androidx.renderscript.Element;
import androidx.renderscript.RSIllegalArgumentException;
import androidx.renderscript.RenderScript;

public class hq extends hp {
    private final float[] O00000Oo = new float[9];
    private Allocation O00000o0;

    protected hq(int i, RenderScript renderScript) {
        super(i, renderScript);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int
     arg types: [int, int, int, int]
     candidates:
      androidx.renderscript.RenderScript.O000000o(int, int, android.graphics.Bitmap, int):int
      androidx.renderscript.RenderScript.O000000o(int, int, boolean, int):int */
    public static hq O000000o(RenderScript renderScript, Element element) {
        Element element2;
        if (RenderScript.O0000O0o) {
            return hr.O00000Oo(renderScript, element);
        }
        if (!element.O000000o(Element.O00000o0(renderScript))) {
            if (renderScript.O0000OoO == null) {
                Element.DataType dataType = Element.DataType.UNSIGNED_8;
                if (RenderScript.O0000O0o) {
                    element2 = hj.O000000o((hm) renderScript, dataType);
                } else {
                    Element.DataKind dataKind = Element.DataKind.USER;
                    element2 = new Element(renderScript.O000000o(dataType.mID, dataKind.mID, false, 1), renderScript, dataType, dataKind, false, 1);
                }
                renderScript.O0000OoO = element2;
            }
            if (!element.O000000o(renderScript.O0000OoO)) {
                throw new RSIllegalArgumentException("Unsuported element type.");
            }
        }
        hq hqVar = new hq(renderScript.O00000Oo(element.O000000o(renderScript)), renderScript);
        hqVar.O000000o(5.0f);
        return hqVar;
    }

    public void O000000o(Allocation allocation) {
        this.O00000o0 = allocation;
        int i = 0;
        if (this.f19065O000000o != null) {
            ho hoVar = this.f19065O000000o;
            if (allocation == null) {
                try {
                    hoVar.setVar(1, 0);
                } catch (RSRuntimeException e) {
                    throw hk.O000000o(e);
                }
            } else {
                try {
                    hoVar.setVar(1, allocation.O00000Oo());
                } catch (RSRuntimeException e2) {
                    throw hk.O000000o(e2);
                }
            }
        } else {
            RenderScript renderScript = this.O0000o0o;
            int O000000o2 = O000000o(this.O0000o0o);
            if (allocation != null) {
                i = allocation.O000000o(this.O0000o0o);
            }
            renderScript.O00000Oo(O000000o2, 1, i);
        }
    }

    public void O000000o(float f) {
        if (f <= 0.0f || f > 25.0f) {
            throw new RSIllegalArgumentException("Radius out of range (0 < r <= 25).");
        } else if (this.f19065O000000o != null) {
            try {
                this.f19065O000000o.setVar(0, f);
            } catch (RSRuntimeException e) {
                throw hk.O000000o(e);
            }
        } else {
            this.O0000o0o.O000000o(O000000o(this.O0000o0o), 0, f);
        }
    }

    public void O00000Oo(Allocation allocation) {
        if (this.f19065O000000o != null) {
            this.f19065O000000o.O000000o(0, null, allocation, null);
        } else if (allocation != null) {
            this.O0000o0o.O000000o(O000000o(this.O0000o0o), 0, 0, allocation != null ? allocation.O000000o(this.O0000o0o) : 0, null);
        } else {
            throw new RSIllegalArgumentException("At least one of ain or aout is required to be non-null.");
        }
    }
}
