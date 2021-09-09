package _m_j;

import android.renderscript.BaseObj;
import androidx.renderscript.RSInvalidStateException;
import androidx.renderscript.RSRuntimeException;
import androidx.renderscript.RenderScript;

public class hi {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f18957O000000o = false;
    public int O0000o0O;
    protected RenderScript O0000o0o;

    public BaseObj O00000Oo() {
        return null;
    }

    protected hi(int i, RenderScript renderScript) {
        renderScript.O000000o();
        this.O0000o0o = renderScript;
        this.O0000o0O = i;
    }

    public final int O000000o(RenderScript renderScript) {
        this.O0000o0o.O000000o();
        if (RenderScript.O0000O0o && O00000Oo() != null) {
            return O00000Oo().hashCode();
        }
        if (this.f18957O000000o) {
            throw new RSInvalidStateException("using a destroyed object.");
        } else if (this.O0000o0O == 0) {
            throw new RSRuntimeException("Internal error: Object id 0.");
        } else if (renderScript == null || renderScript == this.O0000o0o) {
            return this.O0000o0O;
        } else {
            throw new RSInvalidStateException("using object with mismatched context.");
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!this.f18957O000000o) {
            if (this.O0000o0O != 0) {
                if (this.O0000o0o.O0000Oo0 != 0) {
                    this.O0000o0o.O000000o(this.O0000o0O);
                }
            }
            this.O0000o0o = null;
            this.O0000o0O = 0;
            this.f18957O000000o = true;
        }
        super.finalize();
    }

    public final synchronized void O00000o0() {
        if (!this.f18957O000000o) {
            this.f18957O000000o = true;
            this.O0000o0o.O000000o(this.O0000o0O);
        } else {
            throw new RSInvalidStateException("Object already destroyed.");
        }
    }

    public int hashCode() {
        return this.O0000o0O;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return getClass() == obj.getClass() && this.O0000o0O == ((hi) obj).O0000o0O;
    }
}
