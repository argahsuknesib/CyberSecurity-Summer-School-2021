package com.xiaomi.smarthome.smartconfig.step;

import _m_j.bod;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.gwg;
import _m_j.htq;
import _m_j.htr;
import _m_j.hua;
import _m_j.hud;
import _m_j.hze;
import _m_j.izb;
import android.animation.Animator;
import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.newui.widget.RippleLayout;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

public class SWCameraStep extends SmartConfigStep implements bod.O000000o, View.OnClickListener, RippleLayout.O00000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11811O000000o;
    public bod O00000Oo;
    private XQProgressDialog O00000o0;
    @BindView(6920)
    ImageView mIvReturn;
    @BindView(6612)
    Button mNextButton;
    @BindView(7219)
    RippleLayout mRipple;
    @BindView(7517)
    View mTitleBar;
    @BindView(6588)
    TextView mTvGoQR;
    @BindView(7001)
    TextView mTvNothingHeared;
    @BindView(7306)
    TextView mTvSecDesc;
    @BindView(7552)
    TextView mTvTopDesc;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void I_() {
    }

    SWCameraStep() {
        this.O000Ooo = "camera-config :SWCameraStep";
    }

    public final void O000000o(Message message) {
        if (message.what == 120) {
            O0000o0();
            O0000Oo0();
        } else if (message.what == 122) {
            O0000o0();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        bod bod = this.O00000Oo;
        if (bod != null && bod.O000000o()) {
            bod.f13155O000000o.O00000o();
        }
    }

    private static boolean O0000Ooo() {
        String str = (String) htr.O000000o().O000000o("device_model");
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("chuangmi.camera.xiaobai")) {
            return true;
        }
        return false;
    }

    private void O0000o0() {
        O000000o("start checkBindKey", new Object[0]);
        htq.O000000o().O000000o(this.f11811O000000o, new hua<JSONObject, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.SWCameraStep.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                SWCameraStep.this.O000000o("checkBindKey onSuccess ", new Object[0]);
                Context context = SWCameraStep.this.O000O0oo;
                if (context == null) {
                    SWCameraStep.this.O000000o("checkBindKey onSuccess ,but context is null ,return ", new Object[0]);
                } else if (!(context instanceof CommonActivity) || ((CommonActivity) context).isValid()) {
                    int optInt = jSONObject.optInt("ret");
                    if (optInt == 0) {
                        int optInt2 = jSONObject.optInt("check_after");
                        if (SWCameraStep.this.x_() == null) {
                            return;
                        }
                        if (optInt2 > 0) {
                            SWCameraStep.this.x_().removeMessages(122);
                            SWCameraStep.this.x_().sendEmptyMessageDelayed(122, (long) (optInt2 * 1000));
                            return;
                        }
                        SWCameraStep.this.x_().removeMessages(122);
                        SWCameraStep.this.x_().sendEmptyMessageDelayed(122, 2000);
                    } else if (optInt == 1) {
                        htr.O000000o().O00000Oo("check_bind_key_did", SWCameraStep.O000000o(jSONObject.optString("bind_did")));
                        SWCameraStep.this.O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
                        SWCameraStep.this.mRipple.O00000oO = false;
                        SWCameraStep.this.O00000Oo.O00000o0();
                        SWCameraStep.this.O00000o();
                    } else if (optInt == -2) {
                        SWCameraStep.this.O0000Oo();
                    } else if (optInt == -3) {
                        SWCameraStep.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                        SWCameraStep.this.mRipple.O00000oO = false;
                        SWCameraStep.this.O00000Oo.O00000o0();
                        SWCameraStep.this.O00000o();
                    }
                }
            }

            public final void O000000o(hud hud) {
                if (!(SWCameraStep.this.O000O0oo instanceof CommonActivity) || ((CommonActivity) SWCameraStep.this.O000O0oo).isValid()) {
                    SWCameraStep.this.O000000o("checkBindKey onFailure code=%d, msg :%s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                    Handler x_ = SWCameraStep.this.x_();
                    if (x_ != null) {
                        x_.removeMessages(122);
                        x_.sendEmptyMessageDelayed(122, 2000);
                    }
                }
            }
        });
    }

    public static String O000000o(String str) {
        String str2 = (String) htr.O000000o().O000000o("device_model");
        return (!"yunyi.camera.mj1".equals(str2) && str2.contains("yunyi.camera") && !str.startsWith("yunyi.")) ? "yunyi.".concat(String.valueOf(str)) : str;
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_sw_camera);
        O000000o("create step", new Object[0]);
        gwg.O000000o(this.mTitleBar);
        final boolean booleanValue = ((Boolean) htr.O000000o().O000000o("enter_scan_qrcode_normal", Boolean.TRUE)).booleanValue();
        this.O00000Oo = new bod(this.O000O0oo, this);
        this.O00000Oo.O00000Oo();
        this.mRipple.setTouchListener(this);
        this.mRipple.post(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.step.SWCameraStep.AnonymousClass2 */

            public final void run() {
                RippleLayout rippleLayout = SWCameraStep.this.mRipple;
                if (!rippleLayout.O00000o) {
                    Iterator<Animator> it = rippleLayout.O0000Oo0.iterator();
                    while (it.hasNext()) {
                        it.next().start();
                    }
                    rippleLayout.O00000o = true;
                }
            }
        });
        this.mTvNothingHeared.getPaint().setFlags(8);
        this.mTvNothingHeared.getPaint().setAntiAlias(true);
        this.mTvGoQR.setOnClickListener(this);
        htr.O000000o().O000000o("device_model");
        if (booleanValue) {
            this.mIvReturn.setImageResource(R.drawable.return_icon_nor_3x);
        } else {
            this.mIvReturn.setImageResource(R.drawable.common_close_img);
        }
        this.mIvReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.SWCameraStep.AnonymousClass3 */

            public final void onClick(View view) {
                SWCameraStep.this.O000000o("user click btn back", new Object[0]);
                if (booleanValue) {
                    SWCameraStep.this.b_(false);
                } else {
                    SWCameraStep.this.O000O0o();
                }
                SWCameraStep.this.O00000o();
                SWCameraStep.this.mRipple.O00000oO = false;
                SWCameraStep.this.O00000Oo.O00000o0();
            }
        });
        this.mTvNothingHeared.setOnClickListener(this);
        this.mNextButton.setOnClickListener(this);
        this.mNextButton.setEnabled(false);
        this.mNextButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_gray_lighter));
        O0000Oo();
        O0000o0o();
    }

    public final void H_() {
        O000000o("onResume Step", new Object[0]);
    }

    public final void O0000O0o() {
        O000000o("onFinishStep", new Object[0]);
    }

    public void onClick(View view) {
        String str;
        if (view.getId() == R.id.heard_qr_scaned) {
            O00000o();
            this.mRipple.O00000oO = false;
            this.O00000Oo.O00000o0();
            O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
        }
        if (view.getId() == R.id.go_qr) {
            O00000o();
            this.O00000Oo.O00000o0();
            this.mRipple.O00000oO = false;
            O000000o(SmartConfigStep.Step.STEP_QR_CAMERA);
        }
        if (view.getId() == R.id.nothing_heard) {
            O000000o("go Help page", new Object[0]);
            fbt fbt = new fbt(this.O000O0oo, "WebShellActivity");
            Locale globalSettingLocale = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingLocale();
            if (globalSettingLocale == null) {
                globalSettingLocale = Locale.getDefault();
            }
            if (SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
                ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
                StringBuilder sb = new StringBuilder("https://");
                if (globalSettingServer != null) {
                    str = globalSettingServer.f7546O000000o + ".";
                } else {
                    str = "";
                }
                sb.append(str);
                sb.append("//home.mi.com/faq/detail.html?id=10164&locale=");
                sb.append(hze.O000000o(globalSettingLocale));
                fbt.O000000o("url", sb.toString());
            } else {
                fbt.O000000o("url", "https:////home.mi.com/faq/detail.html?id=10164&locale=" + hze.O000000o(globalSettingLocale));
            }
            fbs.O000000o(fbt);
            this.mRipple.O00000oO = false;
        }
    }

    private void O0000o0O() {
        O0000Oo0();
        this.O00000o0 = XQProgressDialog.O000000o(this.O000O0oo, "", this.O000O0oo.getString(R.string.camera_waiting));
    }

    public final void O0000Oo0() {
        XQProgressDialog xQProgressDialog = this.O00000o0;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.O00000o0 = null;
        }
    }

    public final void O0000Oo() {
        O0000o0O();
        O000000o("start request bindKey", new Object[0]);
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.SWCameraStep.AnonymousClass4 */

            public final /* synthetic */ void O000000o(Object obj) {
                String str = (String) obj;
                SWCameraStep.this.O000000o("start request bindKey onSuccess result=".concat(String.valueOf(str)), new Object[0]);
                SWCameraStep.this.f11811O000000o = str;
                htr.O000000o().O00000Oo("camera_bind_key", SWCameraStep.this.f11811O000000o);
                Handler x_ = SWCameraStep.this.x_();
                if (x_ != null) {
                    x_.sendEmptyMessageDelayed(120, 300);
                }
            }

            public final void O000000o(hud hud) {
                SWCameraStep.this.O000000o("start request bindKey onFail ".concat(String.valueOf(hud)), new Object[0]);
                SWCameraStep.this.O0000Oo0();
                SWCameraStep.this.O0000OoO();
            }
        });
    }

    public final void O0000OoO() {
        if (this.O000O0oo != null) {
            izb.O000000o(this.O000O0oo, (int) R.string.camera_gen_barcode_error, 0).show();
        }
    }

    public final void O000000o() {
        O000000o("---onSinVoiceSendFinish---", new Object[0]);
        if (!this.O000OO00) {
            this.mTvTopDesc.setText(this.O000O0oo.getString(R.string.camera_step_sw_desc_send_finish));
            this.mTvSecDesc.setVisibility(0);
            this.mRipple.setSending(false);
            this.O00000Oo.O00000o0();
            this.O00000Oo = new bod(this.O000O0oo, this);
            this.O00000Oo.O00000Oo();
            this.mNextButton.setEnabled(true);
            this.mNextButton.setTextColor(this.O000O0oo.getResources().getColor(R.color.mj_color_white_100_transparent));
        }
    }

    private void O0000o0o() {
        AudioManager audioManager = (AudioManager) this.O000O0oo.getSystemService("audio");
        if (((double) ((((float) audioManager.getStreamVolume(3)) + 0.0f) / ((float) audioManager.getStreamMaxVolume(3)))) < 0.8d) {
            izb.O000000o(this.O000O0oo, (int) R.string.camera_volume_too_low, 0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.content.Context, java.lang.String, boolean):java.lang.String
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.content.Context, java.lang.String, boolean):java.lang.String */
    public final void O00000Oo() {
        String str;
        bod bod;
        if (!this.O000OO00 && !this.O00000Oo.O000000o()) {
            O0000o0o();
            StringBuilder sb = new StringBuilder();
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            String O000000o2 = QRCameraStep.O000000o(this.O000O0oo, O00000Oo2, false);
            String O000000o3 = QRCameraStep.O000000o(this.O000O0oo, O00000o02, true);
            if (O000000o2 == null || O000000o3 == null) {
                str = null;
            } else {
                sb.append("b=");
                sb.append(this.f11811O000000o);
                sb.append("&s=");
                sb.append(O000000o2);
                sb.append("&p=");
                sb.append(O000000o3);
                String str2 = "";
                if (O0000Ooo()) {
                    sb.append("&t=");
                    sb.append(htr.O000000o().O000000o("gmt_tz", str2));
                }
                if (O0000Ooo() && SmartConfigRouterFactory.getCoreApiManager().isInternationalServer()) {
                    ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
                    sb.append("&r=");
                    if (globalSettingServer != null) {
                        str2 = globalSettingServer.f7546O000000o;
                    }
                    sb.append(str2);
                }
                str = sb.toString();
            }
            O000000o("sendVoice---code", new Object[0]);
            if (!TextUtils.isEmpty(str) && (bod = this.O00000Oo) != null) {
                if (bod.O000000o()) {
                    bod.f13155O000000o.O00000o();
                } else {
                    bod.f13155O000000o.O000000o(str);
                }
                this.mRipple.setSending(true);
            }
            this.mTvTopDesc.setText(this.O000O0oo.getString(R.string.camera_sound_sending));
            this.mTvSecDesc.setVisibility(8);
        }
    }
}
