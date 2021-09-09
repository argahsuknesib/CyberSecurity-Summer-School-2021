package _m_j;

import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class fsx {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fsx f17080O000000o;
    private static Object O00000Oo = new Object();
    private ExecutorService O00000o0 = Executors.newCachedThreadPool();

    private fsx() {
    }

    public static fsx O000000o() {
        if (f17080O000000o == null) {
            synchronized (O00000Oo) {
                if (f17080O000000o == null) {
                    f17080O000000o = new fsx();
                }
            }
        }
        return f17080O000000o;
    }

    public final <R> void O000000o(NetResult netResult, fss<R> fss, fsm<R, fso> fsm) {
        O000000o(netResult, fss, fsm, false);
    }

    public final <R> void O000000o(NetResult netResult, fss<R> fss, fsm<R, fso> fsm, boolean z) {
        if (netResult != null) {
            final NetResult netResult2 = netResult;
            final boolean z2 = z;
            final fss<R> fss2 = fss;
            final fsm<R, fso> fsm2 = fsm;
            this.O00000o0.submit(new Runnable() {
                /* class _m_j.fsx.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ Exception -> 0x008e }] */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x0054 A[Catch:{ Exception -> 0x008e }] */
                public final void run() {
                    fsm fsm;
                    gtd gtd;
                    try {
                        JSONObject jSONObject = new JSONObject(netResult2.O00000o0);
                        int optInt = jSONObject.optInt("code");
                        if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject != null) {
                                if (!z2) {
                                    gtd = new gtd(optJSONObject);
                                    if (fss2 == null) {
                                        Object parse = fss2.parse(gtd);
                                        if (!netResult2.O00000Oo) {
                                            if (fsm2 != null) {
                                                fsm2.sendSuccessMessage(parse);
                                                return;
                                            }
                                            return;
                                        } else if (fsm2 != null) {
                                            fsm2.sendCacheMessage(parse);
                                            return;
                                        } else {
                                            return;
                                        }
                                    } else if (!netResult2.O00000Oo) {
                                        if (fsm2 != null) {
                                            fsm2.sendSuccessMessage(null);
                                            return;
                                        }
                                        return;
                                    } else if (fsm2 != null) {
                                        fsm2.sendCacheMessage(null);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            gtd = new gtd(jSONObject);
                            if (fss2 == null) {
                            }
                        } else if (!netResult2.O00000Oo && fsm2 != null) {
                            fsm2.sendFailureMessage(new fso(optInt, jSONObject.optString("message"), netResult2.O00000o0));
                        }
                    } catch (Exception unused) {
                        if (!netResult2.O00000Oo && (fsm = fsm2) != null) {
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
