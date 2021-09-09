package _m_j;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry$1;
import java.util.Map;

@SuppressLint({"RestrictedApi"})
public final class ht {

    /* renamed from: O000000o  reason: collision with root package name */
    public Bundle f612O000000o;
    public boolean O00000Oo;
    private o0OoO00O<String, O00000Oo> O00000o = new o0OoO00O<>();
    public boolean O00000o0 = true;

    public interface O000000o {
    }

    public interface O00000Oo {
        Bundle O000000o();
    }

    ht() {
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Lifecycle lifecycle, Bundle bundle) {
        if (!this.O00000Oo) {
            if (bundle != null) {
                this.f612O000000o = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
            }
            lifecycle.O000000o(new SavedStateRegistry$1(this));
            this.O00000Oo = true;
            return;
        }
        throw new IllegalStateException("SavedStateRegistry was already restored.");
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f612O000000o;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        o0OoO00O<K, V>.O00000o O000000o2 = this.O00000o.O000000o();
        while (O000000o2.hasNext()) {
            Map.Entry entry = (Map.Entry) O000000o2.next();
            bundle2.putBundle((String) entry.getKey(), ((O00000Oo) entry.getValue()).O000000o());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
