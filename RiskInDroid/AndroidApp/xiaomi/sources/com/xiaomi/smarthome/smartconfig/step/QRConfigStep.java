package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gnk;
import _m_j.htq;
import _m_j.htr;
import _m_j.hua;
import _m_j.hud;
import _m_j.hze;
import _m_j.izb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.wificonfig.CameraBarcodeHelpActivity;
import com.xiaomi.smarthome.wificonfig.GifView;
import org.json.JSONObject;

public class QRConfigStep extends SmartConfigStep {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f11787O000000o;
    private XQProgressDialog O00000Oo;
    private Bitmap O00000o0 = null;
    @BindView(6372)
    View contentView;
    @BindView(6168)
    ImageView mBarCodeImage;
    @BindView(6581)
    Button mGenCode;
    @BindView(6613)
    TextView mHelpView;
    @BindView(6985)
    Button mNextButton;
    @BindView(7194)
    View mResetTips;
    @BindView(7514)
    TextView mTipsBtn;
    @BindView(7512)
    GifView mTipsGifView;
    @BindView(7513)
    ImageView mTipsImageView;
    @BindView(7511)
    View mTipsView;

    public final SmartConfigStep.Step A_() {
        return null;
    }

    public final void H_() {
    }

    public final void I_() {
    }

    public final void O0000O0o() {
    }

    public final void O000000o(Message message) {
        if (message.what == 120) {
            new Thread() {
                /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass1 */

                public final void run() {
                    super.run();
                    QRConfigStep.this.O0000Oo();
                    QRConfigStep.this.x_().sendEmptyMessage(121);
                }
            }.run();
        } else if (message.what == 121) {
            if (this.O00000o0 != null) {
                ViewGroup.LayoutParams layoutParams = this.mBarCodeImage.getLayoutParams();
                layoutParams.height = this.O00000o0.getHeight();
                layoutParams.width = this.O00000o0.getWidth();
                this.mBarCodeImage.setLayoutParams(layoutParams);
                this.mBarCodeImage.invalidate();
                this.mBarCodeImage.setImageBitmap(this.O00000o0);
                this.contentView.setVisibility(0);
                this.mTipsView.setVisibility(0);
                this.mResetTips.setVisibility(8);
                O0000Ooo();
            } else {
                O0000Oo0();
            }
            O00000o();
        } else if (message.what == 122) {
            O0000Ooo();
        }
    }

    public final void O000000o(Context context) {
        O000000o(context, (int) R.layout.smart_config_qr_connect);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass2 */

            public final void onClick(View view) {
                QRConfigStep.this.O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
            }
        });
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(this.O000O0oo.getString(R.string.camera_gen_barcode_tips_help));
        valueOf.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass3 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(QRConfigStep.this.O000O0oo.getResources().getColor(R.color.mj_color_gray_normal));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                QRConfigStep.this.O000O0oo.startActivity(new Intent(QRConfigStep.this.O000O0oo, CameraBarcodeHelpActivity.class));
            }
        }, 0, valueOf.length(), 33);
        this.mHelpView.setHighlightColor(0);
        this.mHelpView.setText(valueOf);
        this.mHelpView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mTipsView.setVisibility(8);
        this.mTipsView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass4 */

            public final void onClick(View view) {
                QRConfigStep.this.mTipsView.setVisibility(8);
            }
        });
        String str = (String) htr.O000000o().O000000o("device_model");
        if (str != null && str.equals("yunyi.camera.v1")) {
            this.mTipsGifView.setMovieResource(R.drawable.barcode_use_tip);
        }
        this.mTipsBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass5 */

            public final void onClick(View view) {
                QRConfigStep.this.mTipsView.setVisibility(8);
            }
        });
        if (str == null || !str.equals("yunyi.camera.v1")) {
            this.mResetTips.setVisibility(8);
            O00000Oo();
            return;
        }
        this.mResetTips.setVisibility(0);
        this.contentView.setVisibility(8);
        this.mTipsView.setVisibility(8);
        this.mGenCode.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass6 */

            public final void onClick(View view) {
                QRConfigStep.this.O00000Oo();
            }
        });
    }

    public final void O00000Oo() {
        O0000OoO();
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass7 */

            public final /* synthetic */ void O000000o(Object obj) {
                QRConfigStep.this.f11787O000000o = (String) obj;
                htr.O000000o().O00000Oo("camera_bind_key", QRConfigStep.this.f11787O000000o);
                if (QRConfigStep.this.x_() != null) {
                    QRConfigStep.this.x_().sendEmptyMessage(120);
                }
            }

            public final void O000000o(hud hud) {
                if (QRConfigStep.this.x_() != null) {
                    QRConfigStep.this.O00000o();
                    QRConfigStep.this.O0000Oo0();
                }
            }
        });
    }

    private void O0000OoO() {
        O00000o();
        this.O00000Oo = XQProgressDialog.O000000o(this.O000O0oo, "", this.O000O0oo.getString(R.string.camera_waiting));
    }

    public final void O00000o() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
            this.O00000Oo = null;
        }
    }

    public final void O0000Oo0() {
        if (this.O000O0oo != null) {
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
    public final Bitmap O0000Oo() {
        String str = null;
        if (this.O000O0oo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String O00000Oo2 = htr.O000000o().O00000Oo();
        String O00000o02 = htr.O000000o().O00000o0();
        String O000000o2 = QRCameraStep.O000000o(this.O000O0oo, O00000Oo2, false);
        String O000000o3 = QRCameraStep.O000000o(this.O000O0oo, O00000o02, true);
        if (!(O000000o2 == null || O000000o3 == null)) {
            sb.append("b=");
            sb.append(this.f11787O000000o);
            sb.append("&s=");
            sb.append(O000000o2);
            sb.append("&p=");
            sb.append(O000000o3);
            sb.append("&t=");
            sb.append(htr.O000000o().O000000o("gmt_tz", ""));
            str = sb.toString();
        }
        DisplayMetrics displayMetrics = this.O000O0oo.getResources().getDisplayMetrics();
        this.O00000o0 = hze.O000000o(this.O000O0oo, (int) (((float) displayMetrics.widthPixels) - (displayMetrics.density * 0.0f)), str);
        return this.O00000o0;
    }

    private void O0000Ooo() {
        gnk.O00000o0(String.format("checkBindKey bindKey = %s", this.f11787O000000o));
        htq.O000000o().O000000o(this.f11787O000000o, new hua<JSONObject, hud>() {
            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass8 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (!(QRConfigStep.this.O000O0oo instanceof CommonActivity) || ((CommonActivity) QRConfigStep.this.O000O0oo).isValid()) {
                    gnk.O00000o0(String.format("onSuccess %s", jSONObject));
                    int optInt = jSONObject.optInt("ret");
                    if (optInt == 0) {
                        int optInt2 = jSONObject.optInt("check_after");
                        if (QRConfigStep.this.x_() == null) {
                            return;
                        }
                        if (optInt2 > 0) {
                            QRConfigStep.this.x_().removeMessages(122);
                            QRConfigStep.this.x_().sendEmptyMessageDelayed(122, (long) (optInt2 * 1000));
                            return;
                        }
                        QRConfigStep.this.x_().removeMessages(122);
                        QRConfigStep.this.x_().sendEmptyMessageDelayed(122, 2000);
                    } else if (optInt == 1) {
                        htr.O000000o().O00000Oo("check_bind_key_did", QRConfigStep.O000000o(jSONObject.optString("bind_did")));
                        QRConfigStep.this.O000000o(SmartConfigStep.Step.STEP_QR_SCAN);
                    } else if (optInt == -2) {
                        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(QRConfigStep.this.O000O0oo);
                        builder.O00000Oo((int) R.string.kuailian_falied_bindkey_invalide);
                        builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.smartconfig.step.QRConfigStep.AnonymousClass8.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                QRConfigStep.this.O00000Oo();
                            }
                        });
                        builder.O00000oo();
                    } else if (optInt == -3) {
                        QRConfigStep.this.O000000o(SmartConfigStep.Step.STEP_BIND_BY_OTHER_ERROR);
                    }
                }
            }

            public final void O000000o(hud hud) {
                if (!(QRConfigStep.this.O000O0oo instanceof CommonActivity) || ((CommonActivity) QRConfigStep.this.O000O0oo).isValid()) {
                    gnk.O00000o0(String.format("onFailure %s", hud));
                    Handler x_ = QRConfigStep.this.x_();
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
}
