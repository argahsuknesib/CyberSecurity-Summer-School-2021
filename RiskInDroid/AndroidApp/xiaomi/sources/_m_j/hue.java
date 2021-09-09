package _m_j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public final class hue {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hue f694O000000o;
    private static Object O00000Oo = new Object();
    private ExecutorService O00000o0 = Executors.newCachedThreadPool();

    private hue() {
    }

    public static hue O000000o() {
        if (f694O000000o == null) {
            synchronized (O00000Oo) {
                if (f694O000000o == null) {
                    f694O000000o = new hue();
                }
            }
        }
        return f694O000000o;
    }

    public <R> void O000000o(String str, hub<R> hub, hua<R, hud> hua) {
        if (str != null) {
            this.O00000o0.submit(new Runnable(str, false, hub, hua) {
                /* class _m_j.hue.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f695O000000o;
                final /* synthetic */ boolean O00000Oo = false;
                final /* synthetic */ hua O00000o;
                final /* synthetic */ hub O00000o0;

                {
                    this.f695O000000o = r2;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x002c A[Catch:{ Exception -> 0x005e }] */
                /* JADX WARNING: Removed duplicated region for block: B:15:0x003c A[Catch:{ Exception -> 0x005e }] */
                public final void run() {
                    gtd gtd;
                    try {
                        JSONObject jSONObject = new JSONObject(this.f695O000000o);
                        int optInt = jSONObject.optInt("code");
                        if (optInt == 0) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (optJSONObject != null) {
                                if (!this.O00000Oo) {
                                    gtd = new gtd(optJSONObject);
                                    if (this.O00000o0 == null) {
                                        Object parse = this.O00000o0.parse(gtd);
                                        if (this.O00000o != null) {
                                            this.O00000o.O00000Oo(parse);
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
                            this.O00000o.O00000Oo(new hud(optInt, jSONObject.optString("message"), this.f695O000000o));
                        }
                    } catch (Exception unused) {
                        hua hua = this.O00000o;
                        if (hua != null) {
                            hua.O00000Oo(new hud(-9999, "wrong response format"));
                        }
                    }
                }
            });
        } else if (hua != null) {
            hua.O00000Oo(new hud(-9999, ""));
        }
    }
}
