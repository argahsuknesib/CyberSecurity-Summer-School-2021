package _m_j;

import android.os.IBinder;
import com.xiaomi.push.bc;

public final class ema implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ IBinder f15621O000000o;
    final /* synthetic */ bc.O00000Oo O00000Oo;

    public ema(bc.O00000Oo o00000Oo, IBinder iBinder) {
        this.O00000Oo = o00000Oo;
        this.f15621O000000o = iBinder;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x009c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x00c5 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0072 */
    public final void run() {
        try {
            String packageName = bc.this.O00000Oo.getPackageName();
            String O00000o0 = bc.this.O00000oo();
            bc.O000000o o000000o = new bc.O000000o(bc.this, (byte) 0);
            o000000o.f6367O000000o = bc.O00000o0.O000000o(this.f15621O000000o, packageName, O00000o0, "GUID");
            o000000o.O00000Oo = bc.O00000o0.O000000o(this.f15621O000000o, packageName, O00000o0, "OUID");
            o000000o.O00000o0 = bc.O00000o0.O000000o(this.f15621O000000o, packageName, O00000o0, "DUID");
            o000000o.O00000o = bc.O00000o0.O000000o(this.f15621O000000o, packageName, O00000o0, "AUID");
            bc.O000000o unused = bc.this.O00000oO = o000000o;
            bc.O00000o(bc.this);
            int unused2 = bc.this.O00000o = 2;
            synchronized (bc.this.O00000oo) {
                bc.this.O00000oo.notifyAll();
            }
        } catch (Exception unused3) {
            bc.O00000o(bc.this);
            int unused4 = bc.this.O00000o = 2;
            synchronized (bc.this.O00000oo) {
                bc.this.O00000oo.notifyAll();
            }
        } catch (Throwable th) {
            bc.O00000o(bc.this);
            int unused5 = bc.this.O00000o = 2;
            synchronized (bc.this.O00000oo) {
                bc.this.O00000oo.notifyAll();
                throw th;
            }
        }
    }
}
