package _m_j;

import android.renderscript.BaseObj;
import android.renderscript.RSRuntimeException;
import android.renderscript.Type;
import androidx.renderscript.Element;
import androidx.renderscript.RenderScript;
import androidx.renderscript.Type;
import java.util.HashMap;

public final class hs extends Type {
    static HashMap<android.renderscript.Type, Type> O0000Oo = new HashMap<>();
    android.renderscript.Type O0000Oo0;

    private void O00000o() {
        this.f2970O000000o = this.O0000Oo0.getX();
        this.O00000Oo = this.O0000Oo0.getY();
        this.O00000o0 = this.O0000Oo0.getZ();
        this.O00000oO = this.O0000Oo0.hasFaces();
        this.O00000o = this.O0000Oo0.hasMipmaps();
        this.O00000oo = this.O0000Oo0.getYuv();
        O000000o();
    }

    hs(RenderScript renderScript, android.renderscript.Type type) {
        super(0, renderScript);
        this.O0000Oo0 = type;
        try {
            O00000o();
            this.O0000OOo = new hj(renderScript, type.getElement());
            synchronized (O0000Oo) {
                O0000Oo.put(this.O0000Oo0, this);
            }
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    static Type O000000o(android.renderscript.Type type) {
        return O0000Oo.get(type);
    }

    public static Type O000000o(RenderScript renderScript, Element element, int i, int i2, int i3, boolean z, boolean z2, int i4) {
        try {
            Type.Builder builder = new Type.Builder(((hm) renderScript).O0000oO, ((hj) element).O00000oo);
            if (i > 0) {
                builder.setX(i);
            }
            if (i2 > 0) {
                builder.setY(i2);
            }
            if (i3 > 0) {
                builder.setZ(i3);
            }
            if (z) {
                builder.setMipmaps(z);
            }
            if (z2) {
                builder.setFaces(z2);
            }
            if (i4 > 0) {
                builder.setYuvFormat(i4);
            }
            hs hsVar = new hs(renderScript, builder.create());
            hsVar.O00000o();
            return hsVar;
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ BaseObj O00000Oo() {
        return this.O0000Oo0;
    }
}
