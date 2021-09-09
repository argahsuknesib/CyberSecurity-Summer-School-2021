package _m_j;

import _m_j.dxe;
import _m_j.hvr;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.miio.MiioLocalErrorCode;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.framework.page.verify.view.PinInputView;
import com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class hvr extends hvx implements PinSoftKeyboard.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f707O000000o = new dxf(MiioLocalErrorCode.EXCEPTION).O000000o();
    PinSoftKeyboard O00000Oo;
    PinInputView O00000o;
    View O00000o0;
    View O00000oO;
    public String O00000oo;
    public byte[] O0000O0o;
    public View O0000OOo;
    public ImageView O0000Oo0;
    private String O000OooO = "";
    private int O000Oooo = 0;
    private View O000o000;

    public final int O00000Oo() {
        return -1;
    }

    public final void e_(int i) {
    }

    hvr() {
        this.O000Ooo = "AP_CONFIG:APSecurePinStep";
    }

    public final void O000000o(Message message) {
        if (x_() != null) {
            x_().removeMessages(message.what);
        }
        int i = message.what;
        if (i == 101) {
            O000000o("handleMessage:  NETWORK_STATE_CHANGED ", new Object[0]);
            O00000Oo(true);
        } else if (i == 123) {
            O000000o("handleMessage:  MSG_RECONNECT_DEVICE_AP ", new Object[0]);
            super.O000000o(message);
        }
    }

    public final void O000000o(Context context) {
        O000000o("create step", new Object[0]);
        this.O000O0oO = LayoutInflater.from(context).inflate((int) R.layout.ap_secure_pin_code_layout, (ViewGroup) null);
        this.O00000Oo = (PinSoftKeyboard) this.O000O0oO.findViewById(R.id.xiaomi_sm_pin_softkeyboard);
        this.O00000o0 = this.O000O0oO.findViewById(R.id.cancel);
        this.O00000o = (PinInputView) this.O000O0oO.findViewById(R.id.xiaomi_sm_pin_inputs);
        this.O0000OOo = this.O000O0oO.findViewById(R.id.error_hint);
        this.O00000oO = this.O000O0oO.findViewById(R.id.ratio_container);
        this.O000o000 = this.O000O0oO.findViewById(R.id.fl_hint);
        this.O0000Oo0 = (ImageView) this.O000O0oO.findViewById(R.id.mj_loading);
        this.O00000Oo.setClickListener(this);
        this.O00000oO.setVisibility(8);
        int intValue = ((Integer) htr.O000000o().O000000o("length")).intValue();
        this.O0000Ooo = ((Long) htr.O000000o().O000000o("bind_device_did")).longValue();
        this.O0000o00 = (String) htr.O000000o().O000000o("bind_device_token");
        this.O0000O0o = (byte[]) htr.O000000o().O000000o("sign");
        O0000ooO = (WifiManager) this.O000O0oo.getApplicationContext().getSystemService("wifi");
        this.O0000ooo = (ConnectivityManager) this.O000O0oo.getSystemService("connectivity");
        if (intValue < 6 && (this.O00000o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.O00000o.getLayoutParams();
            marginLayoutParams.leftMargin = (marginLayoutParams.leftMargin * 3) / 2;
            marginLayoutParams.rightMargin = (marginLayoutParams.rightMargin * 3) / 2;
        }
        this.O00000o.setSpacing(gri.O000000o(18.0f));
        this.O00000o.setPincodeNumber(intValue);
        this.O000o000.setVisibility(0);
        this.O0000OOo.setVisibility(4);
        this.O0000Oo0.setVisibility(4);
        q_();
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.hvr.AnonymousClass2 */

            public final void onClick(View view) {
                hvr.this.O000000o("user click btn cancel", new Object[0]);
                hvr.this.G_();
            }
        });
    }

    public void onNumberClick(int i) {
        if (this.O0000Oo0.getVisibility() != 0) {
            String O000000o2 = this.O00000o.O000000o(i);
            this.O0000OOo.setVisibility(4);
            if (O000000o2.length() >= this.O00000o.getPincodeNumber()) {
                O000000o(O000000o2);
            }
        }
    }

    public void onBackClick() {
        G_();
    }

    public void onDeleteClick() {
        if (this.O0000Oo0.getVisibility() != 0) {
            this.O00000o.O000000o();
        }
    }

    public final void q_() {
        if (!this.O000OO00) {
            O000000o("step1:notify firmware generate PIN-Code, and broadcast(voice) it", new Object[0]);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
                jSONObject.put("method", "miIO.handshake");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", 3);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("step", 1);
                jSONObject3.put("mode", 2);
                jSONObject2.put("oob", jSONObject3);
                jSONObject.put("params", jSONObject2);
                hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(234);
                MiioLocalAPI.O00000Oo(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                    /* class _m_j.hvr.AnonymousClass3 */

                    public final void O000000o(JSONObject jSONObject) {
                        hvr.this.O000000o("step1:oobGetDevSign, response= ".concat(String.valueOf(jSONObject)), new Object[0]);
                        hvr.this.O00000oo = jSONObject.optJSONObject("oob").optString("sign");
                        hvr.this.r_();
                    }

                    public final void O000000o(int i, String str, Throwable th) {
                        hvr hvr = hvr.this;
                        StringBuilder sb = new StringBuilder("step1:oobGetDevSign onfail:");
                        sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                        hvr.O000000o(sb.toString(), new Object[0]);
                        if (!hvr.this.O000OO00 && !hvr.this.O000OO0o) {
                            hvr.this.x_().postDelayed(new Runnable() {
                                /* class _m_j.$$Lambda$hvr$3$hFmix6XP9XBH7yhrGv_2h8P5mGU */

                                public final void run() {
                                    hvr.AnonymousClass3.this.O000000o();
                                }
                            }, 1000);
                        }
                    }

                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o() {
                        hvr.this.q_();
                    }
                });
            } catch (Exception e) {
                gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
                G_();
            }
        }
    }

    public final void O000000o(final String str) {
        this.O0000Oo0.post(new Runnable() {
            /* class _m_j.hvr.AnonymousClass4 */

            public final void run() {
                hvr.this.O0000Oo0.setVisibility(0);
                Drawable drawable = hvr.this.O0000Oo0.getDrawable();
                if (drawable instanceof AnimationDrawable) {
                    ((AnimationDrawable) drawable).start();
                }
            }
        });
        final byte[] bytes = str.getBytes();
        final byte[] bArr = new byte[16];
        new Random().nextBytes(bArr);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "miIO.handshake");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", 3);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("step", 2);
            jSONObject3.put("sign", Base64.encodeToString(O000000o(this.O0000O0o, bytes, bArr), 2));
            jSONObject2.put("oob", jSONObject3);
            jSONObject.put("params", jSONObject2);
            String jSONObject4 = jSONObject.toString();
            String O0000o0 = O0000o0();
            O000000o("step2: start rpc oobGetRandomDev", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(236);
            MiioLocalAPI.O000000o(O0000o0, jSONObject4, this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                /* class _m_j.hvr.AnonymousClass5 */

                public final void O000000o(JSONObject jSONObject) {
                    String encodeToString = Base64.encodeToString(hvr.O000000o(hvr.this.O0000O0o, bytes, Base64.decode(jSONObject.optJSONObject("oob").optString("random"), 2)), 2);
                    hvr.this.O000000o("oobGetRandomDev, onResponse", new Object[0]);
                    if (TextUtils.equals(hvr.this.O00000oo, encodeToString)) {
                        hvr.this.O000000o("step2: device sign equal app sign, will execute step3 again", new Object[0]);
                        hvr.this.O00000Oo(Base64.encodeToString(bArr, 2));
                        return;
                    }
                    hvr.this.O000000o("step2: device sign not equal app sign, should execute step2 again", new Object[0]);
                    hvr.this.O00000o();
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hvr.this.O000OO00 && !hvr.this.O000OO0o) {
                        if (hvr.f707O000000o.equals(str)) {
                            hvr hvr = hvr.this;
                            hvr.O000000o("step2: onFail %s", str + Log.getStackTraceString(th), new Object[0]);
                            hvr.this.x_().postDelayed(new Runnable(str) {
                                /* class _m_j.$$Lambda$hvr$5$jQS0edD904fhbcOZzau1qpNS9Vs */
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hvr.AnonymousClass5.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        hvr.this.O000000o("step2:onFail %s", "oobGetRandomDev, onFail= ".concat(String.valueOf(str)), new Object[0]);
                        hvr.this.O00000o();
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    hvr.this.O000000o(str);
                }
            }, 5000);
        } catch (Exception e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
            G_();
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
            String O0000o0 = O0000o0();
            String jSONObject4 = jSONObject.toString();
            O000000o("step3: start rpc oobGetIV", new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(236);
            MiioLocalAPI.O00000Oo(O0000o0, jSONObject4, this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                /* class _m_j.hvr.AnonymousClass6 */

                public final void O000000o(JSONObject jSONObject) {
                    hvr.this.O000000o("step3:oobGetIV, onSuccess", new Object[0]);
                    htr.O000000o().O00000Oo("ticket", jSONObject.optJSONObject("oob").optString("iv"));
                    hvr.this.G_();
                }

                public final void O000000o(int i, String str, Throwable th) {
                    if (!hvr.this.O000OO00 && !hvr.this.O000OO0o) {
                        if (hvr.f707O000000o.equals(str)) {
                            hvr hvr = hvr.this;
                            hvr.O000000o("step3:oobGetIV, onFail= " + Log.getStackTraceString(th), new Object[0]);
                            hvr.this.x_().postDelayed(new Runnable(str) {
                                /* class _m_j.$$Lambda$hvr$6$rHYWPTKrUYcoin8D5QwUW5w5WXQ */
                                private final /* synthetic */ String f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    hvr.AnonymousClass6.this.O000000o(this.f$1);
                                }
                            }, 1000);
                            return;
                        }
                        hvr.this.O00000o();
                        hvr.this.O000000o("step3:oobGetIV, onFail= ".concat(String.valueOf(str)), new Object[0]);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(String str) {
                    hvr.this.O00000Oo(str);
                }
            });
        } catch (Exception e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
            G_();
        }
    }

    public final void O00000o() {
        int i = this.O000Oooo;
        this.O000Oooo = i + 1;
        if (i >= 2) {
            G_();
            return;
        }
        this.O0000OOo.post(new Runnable() {
            /* class _m_j.hvr.AnonymousClass7 */

            public final void run() {
                hvr.this.O00000o.O00000Oo();
                hvr.this.O0000Oo0.setVisibility(4);
                hvr.this.O0000OOo.setVisibility(0);
            }
        });
        r_();
    }

    public final void H_() {
        O000000o("onResumeStep", new Object[0]);
    }

    public final void I_() {
        O000000o("onPauseStep", new Object[0]);
    }

    public final void O0000O0o() {
        O000000o("onFinishStep", new Object[0]);
    }

    public final SmartConfigStep.Step A_() {
        return SmartConfigStep.Step.STEP_APSECURE_PIN_STEP;
    }

    public static byte[] O000000o(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4 = new byte[(bArr3.length + bArr2.length)];
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        System.arraycopy(bArr2, 0, bArr4, bArr3.length, bArr2.length);
        return fir.O000000o(bArr, bArr4);
    }

    public final void r_() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "show_pin_code");
            jSONObject.put("params", "");
            O000000o("showPinCode: %s", jSONObject.toString(), new Object[0]);
            hvg.O000000o(CommonApplication.getAppContext()).O00000Oo(235);
            MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                /* class _m_j.hvr.AnonymousClass8 */

                public final void O000000o(JSONObject jSONObject) {
                    hvr.this.O000000o("showPinCode, onSuccess", new Object[0]);
                }

                public final void O000000o(int i, String str, Throwable th) {
                    hvr hvr = hvr.this;
                    StringBuilder sb = new StringBuilder("showPinCode onfail:");
                    sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                    hvr.O000000o(sb.toString(), new Object[0]);
                    if (!hvr.this.O000OO00 && !hvr.this.O000OO0o) {
                        hvr.this.x_().postDelayed(new Runnable() {
                            /* class _m_j.$$Lambda$hvr$8$p0lbkMT9mXWQ_9P1rekEXvWudg */

                            public final void run() {
                                hvr.AnonymousClass8.this.O000000o();
                            }
                        }, 1000);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o() {
                    hvr.this.r_();
                }
            });
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
        }
    }

    public final boolean G_() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", SmartConfigRouterFactory.getSmartConfigManager().generateNonce());
            jSONObject.put("method", "stop_show_pin_code");
            jSONObject.put("params", "");
            O000000o("stopPinCode %s", jSONObject.toString(), new Object[0]);
            MiioLocalAPI.O000000o(O0000o0(), jSONObject.toString(), this.O0000Ooo, this.O0000o00, new dxe.O000000o() {
                /* class _m_j.hvr.AnonymousClass9 */

                public final void O000000o(JSONObject jSONObject) {
                    hvr.this.O000000o("stopPinCode, response= ".concat(String.valueOf(jSONObject)), new Object[0]);
                }

                public final void O000000o(int i, String str, Throwable th) {
                    hvr hvr = hvr.this;
                    StringBuilder sb = new StringBuilder("stopPinCode onfail:");
                    sb.append(str == null ? Log.getStackTraceString(th) : str.toString());
                    hvr.O000000o(sb.toString(), new Object[0]);
                }
            });
        } catch (JSONException e) {
            gsy.O00000Oo(LogType.KUAILIAN, "APSecurePinStep", Log.getStackTraceString(e));
        }
        O000000o("onBackPressed", new Object[0]);
        x_().post(new Runnable() {
            /* class _m_j.hvr.AnonymousClass1 */

            public final void run() {
                hvr.this.O000O0o();
            }
        });
        return true;
    }
}
