package _m_j;

import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.frame.ErrorCode;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class fdw {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fdw f16136O000000o;
    private static Object O00000Oo = new Object();
    private volatile ExecutorService O00000o0 = Executors.newCachedThreadPool();

    private fdw() {
    }

    public static fdw O000000o() {
        if (f16136O000000o == null) {
            synchronized (O00000Oo) {
                if (f16136O000000o == null) {
                    f16136O000000o = new fdw();
                }
            }
        }
        return f16136O000000o;
    }

    public final <R> void O000000o(final NetResult netResult, final fdv<R> fdv, final fde<R, fdg> fde) {
        if (this.O00000o0 != null && netResult != null) {
            this.O00000o0.submit(new Runnable() {
                /* class _m_j.fdw.AnonymousClass1 */

                public final void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(netResult.O00000o0);
                        int optInt = jSONObject.optInt("code");
                        if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject != null) {
                                jSONObject = optJSONObject;
                            }
                            if (fdv != null) {
                                Object parse = fdv.parse(jSONObject);
                                if (fde != null) {
                                    fde.sendSuccessMessage(parse);
                                }
                            } else if (fde != null) {
                                fde.sendSuccessMessage(null);
                            }
                        } else if (fde != null) {
                            fde.sendFailureMessage(new fdg(optInt, jSONObject.optString("message")));
                        }
                    } catch (Exception unused) {
                        fde fde = fde;
                        if (fde != null) {
                            fde.sendFailureMessage(new fdg(ErrorCode.INVALID.getCode(), "wrong response format"));
                        }
                    }
                }
            });
        } else if (fde != null) {
            fde.sendFailureMessage(new fdg(ErrorCode.INVALID.getCode(), ""));
        }
    }
}
