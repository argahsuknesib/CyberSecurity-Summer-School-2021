package _m_j;

import android.app.Activity;
import android.content.Intent;

public final class cue extends cuc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final Class<? extends Activity> f14363O000000o;

    public cue(Class<? extends Activity> cls) {
        this.f14363O000000o = cls;
    }

    /* access modifiers changed from: protected */
    public final Intent O00000Oo(cvg cvg) {
        return new Intent(cvg.f14384O000000o, this.f14363O000000o);
    }

    public final String toString() {
        return "ActivityHandler (" + this.f14363O000000o.getSimpleName() + ")";
    }
}
