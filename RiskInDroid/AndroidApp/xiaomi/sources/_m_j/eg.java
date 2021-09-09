package _m_j;

import _m_j.fn;
import android.util.Log;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class eg extends fm {
    private static final fn.O00000Oo O00000oo = new fn.O00000Oo() {
        /* class _m_j.eg.AnonymousClass1 */

        public final <T extends fm> T O000000o(Class<T> cls) {
            return new eg(true);
        }
    };

    /* renamed from: O000000o  reason: collision with root package name */
    final HashSet<Fragment> f15238O000000o = new HashSet<>();
    final HashMap<String, eg> O00000Oo = new HashMap<>();
    final boolean O00000o;
    public final HashMap<String, fp> O00000o0 = new HashMap<>();
    boolean O00000oO = false;
    private boolean O0000O0o = false;

    static eg O000000o(fp fpVar) {
        return (eg) new fn(fpVar, O00000oo).O000000o(eg.class);
    }

    eg(boolean z) {
        this.O00000o = z;
    }

    public void onCleared() {
        if (ef.O00000o0) {
            Log.d("FragmentManager", "onCleared called for ".concat(String.valueOf(this)));
        }
        this.O00000oO = true;
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(Fragment fragment) {
        return this.f15238O000000o.add(fragment);
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000Oo(Fragment fragment) {
        if (!this.f15238O000000o.contains(fragment)) {
            return true;
        }
        if (this.O00000o) {
            return this.O00000oO;
        }
        if (!this.O0000O0o) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean O00000o0(Fragment fragment) {
        return this.f15238O000000o.remove(fragment);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o(Fragment fragment) {
        if (ef.O00000o0) {
            Log.d("FragmentManager", "Clearing non-config state for ".concat(String.valueOf(fragment)));
        }
        eg egVar = this.O00000Oo.get(fragment.mWho);
        if (egVar != null) {
            egVar.onCleared();
            this.O00000Oo.remove(fragment.mWho);
        }
        fp fpVar = this.O00000o0.get(fragment.mWho);
        if (fpVar != null) {
            fpVar.O000000o();
            this.O00000o0.remove(fragment.mWho);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            eg egVar = (eg) obj;
            return this.f15238O000000o.equals(egVar.f15238O000000o) && this.O00000Oo.equals(egVar.O00000Oo) && this.O00000o0.equals(egVar.O00000o0);
        }
    }

    public int hashCode() {
        return (((this.f15238O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f15238O000000o.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.O00000Oo.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.O00000o0.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
