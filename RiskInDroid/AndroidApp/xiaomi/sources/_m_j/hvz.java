package _m_j;

import _m_j.dxe;
import _m_j.hvz;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.miio.MiioLocalErrorCode;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.List;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public final class hvz extends gjq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f792O000000o = new dxf(MiioLocalErrorCode.EXCEPTION).O000000o();
    public String O00000Oo;
    protected String O00000o;
    protected long O00000o0;
    public byte[] O00000oO;
    private int O0000oo0 = 0;

    public final void O000000o() {
    }

    public final void O000000o(Message message) {
    }

    public final void O000000o(List<gke> list) {
    }

    public final void O000000o(Context context, List<gke> list, gkd gkd) {
        super.O000000o(context, list, gkd);
        this.O00000o0 = ((Long) htr.O000000o().O000000o("bind_device_did")).longValue();
        this.O00000o = (String) htr.O000000o().O000000o("bind_device_token");
        this.O00000oO = (byte[]) htr.O000000o().O000000o("sign");
    }

    public final void O000000o(int i, Bundle bundle) {
        if (i == 0) {
            O00000Oo();
        } else if (i == 5) {
            O000000o(bundle.getString("pincode"));
        }
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[(bArr3.length + bArr2.length)];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        System.arraycopy(bArr2, 0, bArr4, bArr3.length, bArr2.length);
        return fir.O000000o(bArr, bArr4);
    }

    public final void O00000Oo() {
        if (!this.O0000oOo) {
            O00000Oo("step1:notify firmware generate PIN-Code, and broadcast(voice) it");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", gjp.O0000Ooo());
                jSONObject.put("method", "miIO.handshake");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", 3);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("step", 1);
                jSONObject3.put("mode", 2);
                jSONObject2.put("oob", jSONObject3);
                jSONObject.put("params", jSONObject2);
                MiioLocalAPI.O00000Oo(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.O00000o0, this.O00000o, new dxe.O000000o() {
                    /* class _m_j.hvz.AnonymousClass1 */

                    public final void O000000o(JSONObject jSONObject) {
                        hvz.O00000Oo("step1:oobGetDevSign, response= ".concat(String.valueOf(jSONObject)));
                        hvz.this.O00000Oo = jSONObject.optJSONObject("oob").optString("sign");
                        hvz.this.O00000o();
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        StringBuilder sb = new StringBuilder("step1:oobGetDevSign onfail:");
                        sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                        hvz.O00000Oo(sb.toString());
                        if (!hvz.this.O0000oOo && !hvz.this.O0000oOO) {
                            hvz.this.O0000OOo().postDelayed(new Runnable() {
                                /* class _m_j.$$Lambda$hvz$1$kYvFcT8NL0Za9aWSoMKmxiodE */

                                public final void run() {
                                    hvz.AnonymousClass1.this.O000000o();
                                }
                            }, 1000);
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o() {
                        hvz.this.O00000Oo();
                    }
                });
            } catch (Exception e) {
                O00000Oo(Log.getStackTraceString(e));
            }
        }
    }

    public final void O000000o(final String str) {
        O000000o(114, 0);
        final byte[] bytes = str.getBytes();
        final byte[] bArr = new byte[16];
        new Random().nextBytes(bArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("step", 2);
            jSONObject3.put("sign", Base64.encodeToString(O000000o(this.O00000oO, bytes, bArr), 2));
            jSONObject2.put("oob", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            String O000000o2 = gkl.O000000o(this.O0000Oo0);
            O00000Oo("step2: start rpc oobGetRandomDev");
            MiioLocalAPI.O000000o(O000000o2, jSONObject4, this.O00000o0, this.O00000o, new dxe.O000000o() {
                /* class _m_j.hvz.AnonymousClass2 */

                public final void O000000o(JSONObject jSONObject) {
                    String encodeToString = Base64.encodeToString(hvz.O000000o(hvz.this.O00000oO, bytes, Base64.decode(jSONObject.optJSONObject("oob").optString("random"), 2)), 2);
                    hvz.O00000Oo("oobGetRandomDev, onResponse");
                    if (TextUtils.equals(hvz.this.O00000Oo, encodeToString)) {
                        hvz.O00000Oo("step2: device sign equal app sign, will execute step3 again");
                        hvz.this.O00000o(Base64.encodeToString(bArr, 2));
                        return;
                    }
                    hvz.O00000Oo("step2: device sign not equal app sign, should execute step2 again");
                    hvz.this.O00000o0();
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hvz.this.O0000oOo && !hvz.this.O0000oOO) {
                        if (hvz.f792O000000o.equals(str)) {
                            hvz.O000000o("step2: onFail %s", str + Log.getStackTraceString(th));
                            hvz.this.O0000OOo().postDelayed(new Runnable(str) {
                                /* class _m_j.$$Lambda$hvz$2$rZ8Xu7flLzPD98lTfTOct_hXbRA */
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hvz.AnonymousClass2.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        hvz.O000000o("step2:onFail %s", "oobGetRandomDev, onFail= ".concat(String.valueOf(str)));
                        hvz.this.O00000o0();
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    hvz.this.O000000o(str);
                }
            }, 5000);
        } catch (Exception e) {
            O00000Oo(Log.getStackTraceString(e));
        }
    }

    public final void O00000o0() {
        int i = this.O0000oo0;
        this.O0000oo0 = i + 1;
        if (i >= 2) {
            O000000o(11, 0);
            return;
        }
        O000000o(115, 0);
        O00000o();
    }

    public final void O00000o(final String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("step", 3);
            jSONObject3.put("random", str);
            jSONObject2.put("oob", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String O000000o2 = gkl.O000000o(this.O0000Oo0);
            String jSONObject4 = jSONObject.toString();
            O00000Oo("step3: start rpc oobGetIV");
            MiioLocalAPI.O00000Oo(O000000o2, jSONObject4, this.O00000o0, this.O00000o, new dxe.O000000o() {
                /* class _m_j.hvz.AnonymousClass3 */

                public final void O000000o(JSONObject jSONObject) {
                    hvz.O00000Oo("step3:oobGetIV, onSuccess");
                    htr.O000000o().O00000Oo("ticket", jSONObject.optJSONObject("oob").optString("iv"));
                    hvz.this.O00000oo();
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hvz.this.O0000oOo && !hvz.this.O0000oOO) {
                        if (hvz.f792O000000o.equals(str)) {
                            hvz.O00000Oo("step3:oobGetIV, onFail= " + Log.getStackTraceString(th));
                            hvz.this.O0000OOo().postDelayed(new Runnable(str) {
                                /* class _m_j.$$Lambda$hvz$3$Nljs49kw6NGPp2tozCkDjqhqwG4 */
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hvz.AnonymousClass3.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        hvz.this.O00000o0();
                        hvz.O00000Oo("step3:oobGetIV, onFail= ".concat(String.valueOf(str)));
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    hvz.this.O00000o(str);
                }
            });
        } catch (Exception e) {
            O00000Oo(Log.getStackTraceString(e));
        }
    }

    public final void O00000o() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "show_pin_code");
            jSONObject.put("params", "");
            O000000o("showPinCode: %s", jSONObject.toString());
            MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.O00000o0, this.O00000o, new dxe.O000000o() {
                /* class _m_j.hvz.AnonymousClass4 */

                public final void O000000o(JSONObject jSONObject) {
                    hvz.O00000Oo("showPinCode, onSuccess");
                }

                public final void O000000o(int i, String str, Throwable th) {
                    StringBuilder sb = new StringBuilder("showPinCode onfail:");
                    sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                    hvz.O00000Oo(sb.toString());
                    if (!hvz.this.O0000oOo && !hvz.this.O0000oOO) {
                        hvz.this.O0000OOo().postDelayed(new Runnable() {
                            /* class _m_j.$$Lambda$hvz$4$i7n11GRSnRFujFV5hYgjY6QGUzw */

                            public final void run() {
                                hvz.AnonymousClass4.this.O000000o();
                            }
                        }, 1000);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    hvz.this.O00000o();
                }
            });
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
        }
    }

    public final void O00000oo() {
        O000000o(11, 0);
    }

    public final void O00000oO() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", O0000Ooo());
            jSONObject.put("method", "stop_show_pin_code");
            jSONObject.put("params", "");
            O000000o("stopPinCode %s", jSONObject.toString());
            MiioLocalAPI.O000000o(gkl.O000000o(this.O0000Oo0), jSONObject.toString(), this.O00000o0, this.O00000o, new dxe.O000000o() {
                /* class _m_j.hvz.AnonymousClass5 */

                public final void O000000o(JSONObject jSONObject) {
                    hvz.O00000Oo("stopPinCode, response= ".concat(String.valueOf(jSONObject)));
                }

                public final void O000000o(int i, String str, Throwable th) {
                    StringBuilder sb = new StringBuilder("stopPinCode onfail:");
                    sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                    hvz.O00000Oo(sb.toString());
                }
            });
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
        }
    }
}
