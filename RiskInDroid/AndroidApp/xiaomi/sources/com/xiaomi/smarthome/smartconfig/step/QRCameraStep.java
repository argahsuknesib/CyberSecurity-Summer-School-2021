package com.xiaomi.smarthome.smartconfig.step;

import _m_j.eyr;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ftn;
import _m_j.gnk;
import _m_j.gom;
import _m_j.gri;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.htq;
import _m_j.htr;
import _m_j.hua;
import _m_j.hud;
import _m_j.hzc;
import _m_j.hze;
import _m_j.iaa;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.framework.statistic.BindStep;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.security.SecurityCacheManager;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import java.io.UnsupportedEncodingException;
import org.json.JSONObject;

public class QRCameraStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11775O000000o;
    protected boolean O00000Oo = false;
    private XQProgressDialog O00000o;
    public boolean O00000o0 = false;
    private Bitmap O00000oO = null;
    private int O00000oo;
    private CompoundButton.OnCheckedChangeListener O0000O0o = new CompoundButton.OnCheckedChangeListener() {
        /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass6 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            QRCameraStep.this.O000000o("checkbox changed status =%s", String.valueOf(z), new Object[0]);
            QRCameraStep.this.mNextButton.setEnabled(z);
        }
    };
    @BindView(6167)
    ImageView mBarCodeImage;
    @BindView(6290)
    CheckBox mCbxHeard;
    @BindView(7512)
    SimpleDraweeView mGifTips;
    @BindView(7001)
    TextView mHelpView;
    @BindView(6920)
    ImageView mIvReturn;
    @BindView(6612)
    Button mNextButton;
    @BindView(7020)
    TextView mOpTips;
    @BindView(7661)
    TextView mReload;
    @BindView(7517)
    View mTitleBar;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    QRCameraStep() {
        this.O000Ooo = "camera-config :QRCameraStep";
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.app.Activity, float):void
     arg types: [android.app.Activity, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(android.content.Context, int):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.Throwable):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.app.Activity, float):void */
    public final void O000000o(Message message) {
        if (message.what == 120) {
            O000000o("handleMessage, do generate QR code", new Object[0]);
            new Thread() {
                /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass1 */

                public final void run() {
                    super.run();
                    QRCameraStep.this.O0000Oo();
                    Handler x_ = QRCameraStep.this.x_();
                    if (x_ != null) {
                        x_.sendEmptyMessage(121);
                    }
                }
            }.run();
        } else if (message.what == 121) {
            if (this.O00000oO != null) {
                O000000o("handleMessage refresh ui has new bitmap", new Object[0]);
                this.mBarCodeImage.setImageBitmap(this.O00000oO);
                if (this.O00000Oo) {
                    O000000o((Activity) this.O000O0oo, 0.8f);
                }
                this.mCbxHeard.setEnabled(true);
                this.mCbxHeard.setOnCheckedChangeListener(this.O0000O0o);
                O0000o0O();
            } else {
                O000000o("handle message refresh ui,but bitmap is null", new Object[0]);
                O0000Oo0();
            }
            O00000o();
        } else if (message.what == 122) {
            O000000o("handle message check bindKey", new Object[0]);
            O0000o0O();
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_qr_camera);
        gwg.O000000o(this.mTitleBar);
        this.O000OOOo = (String) htr.O000000o().O000000o("device_model", "");
        SmartConfigRouterFactory.getStatBindManager().startBindStep(this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
        final boolean booleanValue = ((Boolean) htr.O000000o().O000000o("enter_scan_qrcode_normal", Boolean.TRUE)).booleanValue();
        final String str = (String) htr.O000000o().O000000o("device_model");
        eyr O00000Oo2 = eyr.O00000Oo();
        this.O00000Oo = eyr.O000000o(str, O00000Oo2.O00000o, O00000Oo2.O00000oO, O00000Oo2.O00000o0);
        if (booleanValue) {
            this.mIvReturn.setImageResource(R.drawable.return_icon_nor_3x);
        } else {
            this.mIvReturn.setImageResource(R.drawable.common_close_img);
        }
        this.mIvReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass2 */

            public final void onClick(View view) {
                QRCameraStep.this.O000000o("create step, click return btn, isEnterNormal %s", String.valueOf(booleanValue), new Object[0]);
                if (booleanValue) {
                    QRCameraStep.this.b_(false);
                } else {
                    QRCameraStep.this.O000O0o();
                }
            }
        });
        this.mNextButton.setEnabled(false);
        this.mHelpView.getPaint().setAntiAlias(true);
        this.mHelpView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mHelpView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass3 */

            public final void onClick(View view) {
                Context context = QRCameraStep.this.O000O0oo;
                if (context == null) {
                    QRCameraStep.this.O000000o("create step, click help btn, but context is null and return .", new Object[0]);
                    return;
                }
                QRCameraStep.this.O000000o("create step,click help btn", new Object[0]);
                SmartConfigRouterFactory.getStatClickManager().adddevice_QR_novoice(str);
                fbt fbt = new fbt(context, "/userCenter/FeedbackCommonProblemActivity");
                fbt.O000000o("extra_model", str);
                fbs.O000000o(fbt);
            }
        });
        this.mCbxHeard.setOnCheckedChangeListener(null);
        this.mCbxHeard.setEnabled(false);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass4 */

            public final void onClick(View view) {
                QRCameraStep.this.O000000o("create step,click next btn", new Object[0]);
                SmartConfigRouterFactory.getStatClickManager().adddevice_QR_next(str);
                QRCameraStep qRCameraStep = QRCameraStep.this;
                qRCameraStep.O00000o0 = true;
                qRCameraStep.O000000o(10);
                SmartConfigRouterFactory.getStatBindManager().endBindStep(QRCameraStep.this.O000OOOo, BindStep.STEP_TRANSFER_CONFIG);
                QRCameraStep.this.O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
            }
        });
        this.mBarCodeImage.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.smartconfig.step.$$Lambda$QRCameraStep$JoyWy3IBHBHM0jsQv2IOEdvqyxA */

            public final void run() {
                QRCameraStep.this.O0000o0o();
            }
        }, 200);
        this.mGifTips.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(ftn.O000000o(CoreApi.O000000o().O0000ooO(), hzc.f1008O000000o.get("camera_gif_tips")))).setAutoPlayAnimations(true)).build());
        O00000Oo();
        SmartConfigRouterFactory.getStatPageV2Manager().adddevice_QR_show(str);
        this.mReload.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass5 */

            public final void onClick(View view) {
                QRCameraStep.this.O000000o("create step, click reload btn", new Object[0]);
                QRCameraStep.this.mReload.setVisibility(4);
                QRCameraStep.this.O00000Oo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000o0o() {
        int O000000o2 = gri.O000000o(this.O000O0oo) - (gri.O000000o(41.0f) * 2);
        int top = (this.mOpTips.getTop() - this.mBarCodeImage.getTop()) - gri.O000000o(15.0f);
        this.O00000oo = Math.min(O000000o2, top);
        gnk.O00000o0(String.format("Barcode width = %d, height = %d, size = %d", Integer.valueOf(O000000o2), Integer.valueOf(top), Integer.valueOf(this.O00000oo)));
    }

    private void O000000o(Activity activity, float f) {
        Window window;
        O000000o("set brightness %s", String.valueOf(f), new Object[0]);
        if (activity != null && (window = activity.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f;
            window.setAttributes(attributes);
        }
    }

    public final boolean G_() {
        O000000o("on backPressed", new Object[0]);
        b_(false);
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.app.Activity, float):void
     arg types: [android.app.Activity, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(android.content.Context, int):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.Throwable):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.app.Activity, float):void */
    private void O0000OoO() {
        O000000o((Activity) this.O000O0oo, -1.0f);
    }

    /* access modifiers changed from: protected */
    public final void b_(boolean z) {
        if (this.O00000Oo) {
            O0000OoO();
        }
        O000000o("finish smart config", new Object[0]);
        super.b_(z);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(SmartConfigStep.Step step) {
        if (this.O00000Oo) {
            O0000OoO();
        }
        O000000o("finish current step", new Object[0]);
        super.O000000o(step);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(int i) {
        gom.O000000o(this.O000OOOo, i);
    }

    public final void O00000Oo() {
        O0000Ooo();
        O000000o(2);
        O000000o("update bar code, get bind key and expire time", new Object[0]);
        htq.O000000o().O00000Oo(new hua<JSONObject, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                QRCameraStep.this.O000000o(4);
                QRCameraStep.this.O000000o(" get bind key onSuccess", new Object[0]);
                QRCameraStep.this.f11775O000000o = ((JSONObject) obj).optString("bindkey");
                htr.O000000o().O00000Oo("camera_bind_key", QRCameraStep.this.f11775O000000o);
                Handler x_ = QRCameraStep.this.x_();
                if (x_ != null) {
                    x_.sendEmptyMessageDelayed(120, 300);
                }
            }

            public final void O000000o(hud hud) {
                QRCameraStep.this.O000000o(1);
                QRCameraStep.this.O000000o("get bind key onfail code %d,msg=%s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                Handler x_ = QRCameraStep.this.x_();
                if (x_ != null) {
                    x_.post(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            QRCameraStep.this.O00000o();
                            QRCameraStep.this.O0000Oo0();
                        }
                    });
                }
            }
        });
    }

    private void O0000Ooo() {
        O00000o();
        this.O00000o = XQProgressDialog.O000000o(this.O000O0oo, "", this.O000O0oo.getString(R.string.camera_waiting));
    }

    public final void O00000o() {
        XQProgressDialog xQProgressDialog = this.O00000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.O00000o = null;
        }
    }

    private static boolean O0000o0() {
        String str = (String) htr.O000000o().O000000o("device_model");
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("chuangmi.camera.xiaobai")) {
            return true;
        }
        return false;
    }

    public final void O0000Oo0() {
        if (this.O000O0oo != null) {
            this.mReload.setVisibility(0);
            izb.O000000o(this.O000O0oo, (int) R.string.camera_gen_barcode_error, 0).show();
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
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bb A[Catch:{ Throwable -> 0x00d9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00c0 A[Catch:{ Throwable -> 0x00d9 }] */
    public final Bitmap O0000Oo() {
        String str;
        try {
            this.O00000oO = null;
            O000000o(6);
            StringBuilder sb = new StringBuilder();
            String O00000Oo2 = htr.O000000o().O00000Oo();
            String O00000o02 = htr.O000000o().O00000o0();
            String O000000o2 = O000000o(this.O000O0oo, O00000Oo2, false);
            String O000000o3 = O000000o(this.O000O0oo, O00000o02, true);
            if (O000000o2 != null) {
                if (O000000o3 != null) {
                    sb.append("b=");
                    sb.append(this.f11775O000000o);
                    sb.append("&s=");
                    sb.append(O000000o2);
                    sb.append("&p=");
                    sb.append(O000000o3);
                    ServerBean globalSettingServer = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServer();
                    if (O0000o0()) {
                        sb.append("&t=");
                        sb.append(htr.O000000o().O000000o("gmt_tz", ""));
                    }
                    if (!O0000o0() || globalSettingServer == null || SmartConfigRouterFactory.getSmartConfigManager().isChinaMainLand(globalSettingServer)) {
                        String globalSettingServerEnv = SmartConfigRouterFactory.getCoreApiManager().getGlobalSettingServerEnv();
                        if (!TextUtils.isEmpty(globalSettingServerEnv) && globalSettingServerEnv.equalsIgnoreCase("preview")) {
                            sb.append("&r=p1");
                        }
                    } else {
                        sb.append("&r=");
                        sb.append(globalSettingServer.f7546O000000o);
                    }
                    str = sb.toString();
                    if (!TextUtils.isEmpty(str)) {
                        O000000o(5);
                        return null;
                    }
                    O000000o(8);
                    this.O00000oO = hze.O000000o(this.O000O0oo, this.O00000oo, str);
                    O000000o("generate bar code bitmap success", new Object[0]);
                    return this.O00000oO;
                }
            }
            O000000o("get bar code, but name b64 or pwd b4 is null", new Object[0]);
            O000000o(3);
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Throwable th) {
            O000000o("generate bar code throw exception", th);
            O000000o(7);
            return null;
        }
    }

    public static String O000000o(Context context, String str, boolean z) {
        byte[] bArr;
        if (z) {
            try {
                gsy.O00000o0(LogType.KUAILIAN, "QRCameraStep", "start get QR security key");
                String qRCodeEncryptKey = SecurityCacheManager.getInstance().getQRCodeEncryptKey(context);
                LogType logType = LogType.KUAILIAN;
                StringBuilder sb = new StringBuilder("QR key ");
                sb.append(qRCodeEncryptKey.substring(0, 2));
                gsy.O00000o0(logType, "QRCameraStep", sb.toString());
                int length = str.length();
                int length2 = qRCodeEncryptKey.length();
                char[] cArr = new char[length];
                for (int i = 0; i < length; i++) {
                    cArr[i] = 0;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    cArr[i2] = (char) (str.charAt(i2) ^ qRCodeEncryptKey.charAt(i2 % length2));
                    if (cArr[i2] == 0) {
                        cArr[i2] = str.charAt(i2);
                    }
                }
                bArr = new String(cArr).getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        } else {
            bArr = str.getBytes("UTF-8");
        }
        return new String(iaa.O000000o(bArr));
    }

    public final void H_() {
        O000000o("onResume step", new Object[0]);
    }

    public final void I_() {
        O000000o("onPauseStep", new Object[0]);
    }

    public final void O0000O0o() {
        O000000o("onfFinishStep", new Object[0]);
        if (!this.O00000o0) {
            gom.O000000o(this.O000OOOo);
        }
    }

    public final void O000000o(int i, int i2, Intent intent) {
        super.O000000o(i, i2, intent);
    }

    private void O0000o0O() {
        O000000o("checkBindKey bindKey = %s", this.f11775O000000o, new Object[0]);
        htq.O000000o().O000000o(this.f11775O000000o, new hua<JSONObject, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass8 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Context context = QRCameraStep.this.O000O0oo;
                if (context == null) {
                    QRCameraStep.this.O000000o("checkBindKey onSuccess,but context is null", new Object[0]);
                } else if (!(context instanceof CommonActivity) || ((CommonActivity) context).isValid()) {
                    QRCameraStep.this.O000000o("checkBindKey onSuccess:".concat(String.valueOf(jSONObject)), new Object[0]);
                    int optInt = jSONObject.optInt("ret");
                    if (optInt == 0) {
                        int optInt2 = jSONObject.optInt("check_after");
                        Handler x_ = QRCameraStep.this.x_();
                        QRCameraStep.this.O000000o("checkBindKey, check interval duration is %d second", Integer.valueOf(optInt2));
                        if (x_ == null) {
                            return;
                        }
                        if (optInt2 > 0) {
                            QRCameraStep.this.x_().removeMessages(122);
                            QRCameraStep.this.x_().sendEmptyMessageDelayed(122, (long) (optInt2 * 1000));
                            return;
                        }
                        QRCameraStep.this.x_().removeMessages(122);
                        QRCameraStep.this.x_().sendEmptyMessageDelayed(122, 2000);
                    } else if (optInt == 1) {
                        htr.O000000o().O00000Oo("check_bind_key_did", QRCameraStep.O000000o(jSONObject.optString("bind_did")));
                        QRCameraStep.this.O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
                    } else if (optInt == -2) {
                        QRCameraStep.this.mCbxHeard.setOnCheckedChangeListener(null);
                        QRCameraStep.this.mCbxHeard.setEnabled(false);
                        QRCameraStep.this.mNextButton.setEnabled(false);
                        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
                        builder.O00000Oo((int) R.string.kuailian_falied_bindkey_invalide);
                        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.QRCameraStep.AnonymousClass8.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                QRCameraStep.this.O00000Oo();
                            }
                        }).O000000o(QRCameraStep.this.O000O0oo.getResources().getColor(R.color.mj_color_text_blue_bg), -1);
                        builder.O00000oo();
                    } else if (optInt == -3) {
                        QRCameraStep.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                    }
                } else {
                    QRCameraStep.this.O000000o("checkBindKey onSuccess,but activity is invalid", new Object[0]);
                }
            }

            public final void O000000o(hud hud) {
                if (!(QRCameraStep.this.O000O0oo instanceof CommonActivity) || ((CommonActivity) QRCameraStep.this.O000O0oo).isValid()) {
                    QRCameraStep.this.O000000o("checkBindKey onFailure ,code :%d,msg :%s", Integer.valueOf(hud.f693O000000o), hud.O00000Oo);
                    Handler x_ = QRCameraStep.this.x_();
                    if (x_ != null) {
                        x_.removeMessages(122);
                        x_.sendEmptyMessageDelayed(122, 2000);
                        return;
                    }
                    return;
                }
                QRCameraStep.this.O000000o("checkBindKey onFailure and activity is invalide", new Object[0]);
            }
        });
    }

    public static String O000000o(String str) {
        String str2 = (String) htr.O000000o().O000000o("device_model");
        return (!"yunyi.camera.mj1".equals(str2) && str2.contains("yunyi.camera") && !str.startsWith("yunyi.")) ? "yunyi.".concat(String.valueOf(str)) : str;
    }
}
