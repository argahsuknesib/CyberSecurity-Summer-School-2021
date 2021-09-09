package _m_j;

import android.content.Context;
import android.renderscript.RSRuntimeException;
import androidx.renderscript.RSInvalidStateException;
import androidx.renderscript.RenderScript;

public final class hm extends RenderScript {
    android.renderscript.RenderScript O0000oO;

    public final void O000000o() {
        if (this.O0000oO == null) {
            throw new RSInvalidStateException("Calling RS with no Context active.");
        }
    }

    private hm(Context context) {
        super(context);
        O0000O0o = true;
    }

    public static RenderScript O000000o(Context context, int i) {
        try {
            hm hmVar = new hm(context);
            hmVar.O0000oO = android.renderscript.RenderScript.create(context, i);
            return hmVar;
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }

    public final void O00000Oo() {
        try {
            this.O0000oO.destroy();
            this.O0000oO = null;
        } catch (RSRuntimeException e) {
            throw hk.O000000o(e);
        }
    }
}
