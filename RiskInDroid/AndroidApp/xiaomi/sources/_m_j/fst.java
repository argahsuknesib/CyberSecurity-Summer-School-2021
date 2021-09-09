package _m_j;

import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class fst {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fst f17072O000000o;
    private static Object O00000Oo = new Object();
    private ExecutorService O00000o0 = Executors.newCachedThreadPool();

    private fst() {
    }

    public static fst O000000o() {
        if (f17072O000000o == null) {
            synchronized (O00000Oo) {
                if (f17072O000000o == null) {
                    f17072O000000o = new fst();
                }
            }
        }
        return f17072O000000o;
    }

    public final <R> void O000000o(final NetResult netResult, final fss<R> fss, final fsm<R, fso> fsm) {
        if (netResult != null) {
            this.O00000o0.submit(new Runnable() {
                /* class _m_j.fst.AnonymousClass1 */

                public final void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(netResult.O00000o0);
                        Object obj = null;
                        if (fss != null) {
                            obj = fss.parse(jSONObject);
                        }
                        if (fsm != null) {
                            fsm.sendSuccessMessage(obj);
                        }
                    } catch (Exception unused) {
                        fsm fsm = fsm;
                        if (fsm != null) {
                            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), "wrong response format"));
                        }
                    }
                }
            });
        } else if (fsm != null) {
            fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
        }
    }
}
