package _m_j;

import _m_j.dxr;
import android.text.TextUtils;
import com.xiaomi.miot.support.monitor.exceptions.MiotMonitorLeakException;
import com.xiaomi.miot.support.monitor.leak.Retryable;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONException;
import org.json.JSONObject;

public final class dza {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final dza f15091O000000o = new dzb().O00000o();
    final dzc O00000Oo;
    final ReferenceQueue<Object> O00000o = new ReferenceQueue<>();
    final Set<String> O00000o0 = new CopyOnWriteArraySet();
    final Map<String, dyx> O00000oO = new HashMap();
    private final dyw O00000oo;

    dza(dzc dzc, dyw dyw) {
        this.O00000Oo = (dzc) dyz.O000000o(dzc, "watchExecutor");
        this.O00000oo = (dyw) dyz.O000000o(dyw, "gcTrigger");
    }

    /* access modifiers changed from: package-private */
    public final Retryable.Result O000000o(dyx dyx) {
        O000000o();
        if (O00000Oo(dyx)) {
            return Retryable.Result.DONE;
        }
        this.O00000oo.O000000o();
        O000000o();
        if (O00000Oo(dyx)) {
            return Retryable.Result.DONE;
        }
        String str = dyx.f15088O000000o;
        dxy O000000o2 = dxr.O000000o.f15041O000000o.O000000o();
        String concat = "Leak Activity:".concat(String.valueOf(str));
        if (TextUtils.equals(O000000o2.O00000o0.report_type, "1")) {
            O000000o2.f15049O000000o.O000000o(102, O000000o2.O00000Oo.report_type, new MiotMonitorLeakException(concat));
        } else {
            try {
                O000000o2.f15049O000000o.O000000o(100, O000000o2.O00000o0.report_type, new JSONObject().put("lan", str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        O000000o(str);
        return Retryable.Result.LEAKED;
    }

    private boolean O00000Oo(dyx dyx) {
        return !this.O00000o0.contains(dyx.f15088O000000o);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        while (true) {
            dyx dyx = (dyx) this.O00000o.poll();
            if (dyx != null) {
                O000000o(dyx.f15088O000000o);
            } else {
                return;
            }
        }
    }

    public final void O000000o(String str) {
        if (this.O00000o0.contains(str)) {
            this.O00000o0.remove(str);
        }
        if (this.O00000oO.containsKey(str)) {
            this.O00000oO.remove(str);
        }
    }

    public final void O00000Oo() {
        this.O00000o0.clear();
        this.O00000oO.clear();
    }
}
