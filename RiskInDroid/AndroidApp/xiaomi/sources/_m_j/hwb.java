package _m_j;

import _m_j.dxe;
import _m_j.hwb;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.miio.MiioLocalErrorCode;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.Random;
import org.json.JSONObject;

public final class hwb {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f802O000000o = new dxf(MiioLocalErrorCode.EXCEPTION).O000000o();
    public byte[] O00000Oo;
    public O000000o O00000o;
    public String O00000o0;
    public boolean O00000oO = false;
    public Handler O00000oo;
    private long O0000O0o;
    private String O0000OOo;

    public interface O000000o {
        void O000000o();

        void O000000o(String str);
    }

    static void O000000o(String str, Object... objArr) {
        hts.O000000o("AP_CONFIG:ApSecureQRStep", str, objArr);
    }

    public hwb(long j, String str, byte[] bArr, O000000o o000000o) {
        this.O0000O0o = j;
        this.O0000OOo = str;
        this.O00000Oo = bArr;
        this.O00000o = o000000o;
        this.O00000oo = new Handler(Looper.getMainLooper());
        hts.O000000o("AP_CONFIG:ApSecureQRStep", "init instance did=%s", String.valueOf(j));
    }

    public final void O000000o(String str) {
        if (str.length() == 12) {
            O000000o(got.O000000o(str));
        } else {
            O000000o(str.getBytes());
        }
    }

    public final void O000000o() {
        hts.O000000o("AP_CONFIG:ApSecureQRStep", "stopBind", new Object[0]);
        this.O00000oO = true;
        this.O00000o = null;
    }

    public final void O000000o(final byte[] bArr) {
        if (!this.O00000oO) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                jSONObject.put("method", "miIO.handshake");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", 3);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("step", 1);
                jSONObject3.put("mode", 3);
                jSONObject2.put("oob", jSONObject3);
                jSONObject.put("params", jSONObject2);
                hts.O000000o("AP_CONFIG:ApSecureQRStep", "step1:OOB get device sign", new Object[0]);
                MiioLocalAPI.O000000o(O00000Oo(), jSONObject.toString(), this.O0000O0o, this.O0000OOo, new dxe.O000000o() {
                    /* class _m_j.hwb.AnonymousClass1 */

                    public final void O000000o(JSONObject jSONObject) {
                        hwb.O000000o("step1:oobGetDevSign, onSuccess", new Object[0]);
                        hwb.this.O00000o0 = jSONObject.optJSONObject("oob").optString("sign");
                        hwb.this.O00000Oo(bArr);
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        StringBuilder sb = new StringBuilder("step1:oobGetDevSign onfail:");
                        sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                        hwb.O000000o(sb.toString(), new Object[0]);
                        if (!hwb.this.O00000oO) {
                            hwb.this.O00000oo.postDelayed(new Runnable(bArr) {
                                /* class _m_j.$$Lambda$hwb$1$MmwBetBExkvp64rNwBS9fli1xo */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hwb.AnonymousClass1.this.O000000o(this.f$1);
                                }
                            }, 1000);
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(byte[] bArr) {
                        hwb.this.O000000o(bArr);
                    }
                }, 5000);
            } catch (Exception e) {
                gsy.O00000Oo(LogType.KUAILIAN, "ApSecureQRStep", Log.getStackTraceString(e));
                O000000o o000000o = this.O00000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        }
    }

    public final void O00000Oo(final byte[] bArr) {
        final byte[] bArr2 = new byte[16];
        new Random().nextBytes(bArr2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("step", 2);
            jSONObject3.put("sign", Base64.encodeToString(hvr.O000000o(this.O00000Oo, bArr, bArr2), 2));
            jSONObject2.put("oob", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            String O00000Oo2 = O00000Oo();
            hts.O000000o("AP_CONFIG:ApSecureQRStep", "step2:oobGetRandomDev", new Object[0]);
            MiioLocalAPI.O000000o(O00000Oo2, jSONObject4, this.O0000O0o, this.O0000OOo, new dxe.O000000o() {
                /* class _m_j.hwb.AnonymousClass2 */

                public final void O000000o(JSONObject jSONObject) {
                    String encodeToString = Base64.encodeToString(hvr.O000000o(hwb.this.O00000Oo, bArr, Base64.decode(jSONObject.optJSONObject("oob").optString("random"), 2)), 2);
                    hwb.O000000o("step2:oobGetRandomDev, onSuccess", new Object[0]);
                    if (TextUtils.equals(hwb.this.O00000o0, encodeToString)) {
                        hwb.this.O00000Oo(Base64.encodeToString(bArr2, 2));
                    } else if (hwb.this.O00000o != null) {
                        hwb.this.O00000o.O000000o();
                    }
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hwb.this.O00000oO) {
                        if (hwb.f802O000000o.equals(str)) {
                            hwb.O000000o("step2:oobGetRandomDev exception onFail" + str + Log.getStackTraceString(th), new Object[0]);
                            hwb.this.O00000oo.postDelayed(new Runnable(bArr) {
                                /* class _m_j.$$Lambda$hwb$2$Xq__SVtYd3Bchcrq8tFxqdiVCE */
                                private final /* synthetic */ byte[] f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hwb.AnonymousClass2.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        hwb.O000000o("step2:oobGetRandomDev, onFail= " + str.toString(), new Object[0]);
                        if (hwb.this.O00000o != null) {
                            hwb.this.O00000o.O000000o();
                        }
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(byte[] bArr) {
                    hwb.this.O00000Oo(bArr);
                }
            }, 5000);
        } catch (Exception e) {
            gsy.O00000Oo(LogType.KUAILIAN, "ApSecureQRStep", Log.getStackTraceString(e));
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }

    public final void O00000Oo(final String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("step", 3);
            jSONObject3.put("random", str);
            jSONObject2.put("oob", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String O00000Oo2 = O00000Oo();
            String jSONObject4 = jSONObject.toString();
            hts.O000000o("AP_CONFIG:ApSecureQRStep", "step3:oobGetIV ", new Object[0]);
            MiioLocalAPI.O000000o(O00000Oo2, jSONObject4, this.O0000O0o, this.O0000OOo, new dxe.O000000o() {
                /* class _m_j.hwb.AnonymousClass3 */

                public final void O000000o(JSONObject jSONObject) {
                    hwb.O000000o("step3:oobGetIV, onSuccess", new Object[0]);
                    htr.O000000o().O00000Oo("ticket", jSONObject.optJSONObject("oob").optString("iv"));
                    if (hwb.this.O00000o != null) {
                        hwb.this.O00000o.O000000o(jSONObject.optJSONObject("oob").optString("iv"));
                    }
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hwb.this.O00000oO) {
                        if (hwb.f802O000000o.equals(str)) {
                            hwb.O000000o("step3: exception onFail=" + Log.getStackTraceString(th), new Object[0]);
                            hwb.this.O00000oo.postDelayed(new Runnable(str) {
                                /* class _m_j.$$Lambda$hwb$3$9GJIFRwaclccou72Y_7MIbSA6Ug */
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hwb.AnonymousClass3.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        if (hwb.this.O00000o != null) {
                            hwb.this.O00000o.O000000o();
                        }
                        hwb.O000000o("step3:oobGetIV, onFail= " + str.toString(), new Object[0]);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    hwb.this.O00000Oo(str);
                }
            }, 5000);
        } catch (Exception e) {
            gsy.O00000Oo(LogType.KUAILIAN, "ApSecureQRStep", Log.getStackTraceString(e));
            O000000o o000000o = this.O00000o;
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
    }

    private static String O00000Oo() {
        Context appContext = SmartConfigRouterFactory.getSmartConfigManager().getAppContext();
        if (appContext == null) {
            return "";
        }
        return O000000o((long) ((WifiManager) appContext.getApplicationContext().getSystemService("wifi")).getDhcpInfo().gateway);
    }

    private static String O000000o(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }
}
