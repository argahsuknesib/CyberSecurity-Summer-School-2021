package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class fet {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fet f16190O000000o;
    private static Object O00000Oo = new Object();
    private ExecutorService O00000o0 = Executors.newCachedThreadPool();

    private fet() {
    }

    public static fet O000000o() {
        if (f16190O000000o == null) {
            synchronized (O00000Oo) {
                if (f16190O000000o == null) {
                    f16190O000000o = new fet();
                }
            }
        }
        return f16190O000000o;
    }

    public <R> void O000000o(String str, feq<R> feq, feo<R, fes> feo) {
        if (str != null) {
            this.O00000o0.submit(new Runnable(str, false, feq, feo) {
                /* class _m_j.fet.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f16191O000000o;
                final /* synthetic */ boolean O00000Oo = false;
                final /* synthetic */ feo O00000o;
                final /* synthetic */ feq O00000o0;

                {
                    this.f16191O000000o = r2;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x002c A[Catch:{ Exception -> 0x005e }] */
                /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ Exception -> 0x005e }] */
                public final void run() {
                    gtd gtd;
                    try {
                        JSONObject jSONObject = new JSONObject(this.f16191O000000o);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 0) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject != null) {
                                if (!this.O00000Oo) {
                                    gtd = new gtd(optJSONObject);
                                    if (this.O00000o0 == null) {
                                        Object O000000o2 = this.O00000o0.O000000o(gtd);
                                        if (this.O00000o != null) {
                                            this.O00000o.O00000Oo(O000000o2);
                                            return;
                                        }
                                        return;
                                    } else if (this.O00000o != null) {
                                        this.O00000o.O00000Oo((Object) null);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                            gtd = new gtd(jSONObject);
                            if (this.O00000o0 == null) {
                            }
                        } else if (this.O00000o != null) {
                            this.O00000o.O00000Oo(new fes(optInt, jSONObject.optString("message"), this.f16191O000000o));
                        }
                    } catch (Exception unused) {
                        feo feo = this.O00000o;
                        if (feo != null) {
                            feo.O00000Oo(new fes(-9999, "wrong response format"));
                        }
                    }
                }
            });
        } else if (feo != null) {
            feo.O00000Oo(new fes(-9999, ""));
        }
    }
}
