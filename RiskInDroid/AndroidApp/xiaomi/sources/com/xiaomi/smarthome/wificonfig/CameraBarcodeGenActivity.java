package com.xiaomi.smarthome.wificonfig;

import _m_j.gsy;
import _m_j.htq;
import _m_j.hua;
import _m_j.hud;
import _m_j.idm;
import _m_j.igw;
import _m_j.izb;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.smartconfig.step.QRCameraStep;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.EncodeHintType;
import java.util.Hashtable;
import java.util.TimeZone;

public class CameraBarcodeGenActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Dialog f11964O000000o;
    Bitmap O00000Oo;
    GifView O00000o;
    View O00000o0;
    private View O00000oO;
    private ImageView O00000oo;
    private String O0000O0o = null;
    private String O0000OOo = null;
    private View O0000Oo;
    private Button O0000Oo0;
    private TextView O0000OoO;
    public String bindKey;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(NotificationCompat.FLAG_HIGH_PRIORITY);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.screenBrightness = 1.0f;
        getWindow().setAttributes(attributes);
        setContentView((int) R.layout.activity_camera_gen_barcode);
        this.O0000O0o = getIntent().getStringExtra("ssid");
        this.O0000OOo = getIntent().getStringExtra("password");
        if (this.O0000OOo == null) {
            this.O0000OOo = "";
        }
        this.O00000oO = findViewById(R.id.reset_tips);
        findViewById(R.id.gen_barcode).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CameraBarcodeGenActivity.this.updateBarcode();
            }
        });
        this.O0000Oo0 = (Button) findViewById(R.id.next);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent(CameraBarcodeGenActivity.this, CameraBarcodeWaitingActivity.class);
                intent.putExtra("bindKey", CameraBarcodeGenActivity.this.bindKey);
                CameraBarcodeGenActivity.this.startActivityForResult(intent, 1);
            }
        });
        this.O0000OoO = (TextView) findViewById(R.id.help);
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf(getString(R.string.camera_gen_barcode_tips_help));
        valueOf.setSpan(new ClickableSpan() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass3 */

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(CameraBarcodeGenActivity.this.getResources().getColor(R.color.mj_color_gray_normal));
                textPaint.setUnderlineText(true);
            }

            public final void onClick(View view) {
                CameraBarcodeGenActivity.this.startActivity(new Intent(CameraBarcodeGenActivity.this, CameraBarcodeHelpActivity.class));
            }
        }, 0, valueOf.length(), 33);
        this.O0000OoO.setHighlightColor(0);
        this.O0000OoO.setText(valueOf);
        this.O0000OoO.setMovementMethod(LinkMovementMethod.getInstance());
        this.O00000oo = (ImageView) findViewById(R.id.barcode_image);
        this.O0000Oo = findViewById(R.id.content);
        this.O00000o0 = findViewById(R.id.tips);
        this.O00000o0.setVisibility(8);
        this.O00000o = (GifView) findViewById(R.id.tips_gif);
        this.O00000o.setMovieResource(R.drawable.barcode_use_tip);
        findViewById(R.id.tips_ok_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass4 */

            public final void onClick(View view) {
                CameraBarcodeGenActivity.this.O00000o0.setVisibility(8);
            }
        });
        showResetInfo();
    }

    public void showResetInfo() {
        this.O00000oO.setVisibility(0);
        this.O0000Oo.setVisibility(8);
        this.O00000o0.setVisibility(8);
    }

    public void updateBarcode() {
        showDialog();
        htq.O000000o().O000000o(new hua<String, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass5 */

            public final /* synthetic */ void O000000o(Object obj) {
                CameraBarcodeGenActivity cameraBarcodeGenActivity = CameraBarcodeGenActivity.this;
                cameraBarcodeGenActivity.bindKey = (String) obj;
                cameraBarcodeGenActivity.mHandler.sendEmptyMessage(1);
            }

            public final void O000000o(hud hud) {
                CameraBarcodeGenActivity.this.dismissDialog();
                CameraBarcodeGenActivity.this.showError();
            }
        });
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            new Thread() {
                /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity.AnonymousClass6 */

                public final void run() {
                    super.run();
                    CameraBarcodeGenActivity.this.genBarcodeBitmap();
                    CameraBarcodeGenActivity.this.mHandler.sendEmptyMessage(2);
                }
            }.run();
        } else if (message.what == 2) {
            if (this.O00000Oo != null) {
                ViewGroup.LayoutParams layoutParams = this.O00000oo.getLayoutParams();
                layoutParams.height = this.O00000Oo.getHeight();
                layoutParams.width = this.O00000Oo.getWidth();
                this.O00000oo.setLayoutParams(layoutParams);
                this.O00000oo.invalidate();
                this.O00000oo.setImageBitmap(this.O00000Oo);
                this.O0000Oo.setVisibility(0);
                this.O00000o0.setVisibility(0);
                this.O00000oO.setVisibility(8);
            } else {
                showError();
            }
            dismissDialog();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O00000Oo = null;
    }

    public void showError() {
        izb.O000000o(this, (int) R.string.camera_gen_barcode_error, 0).show();
    }

    public void showDialog() {
        dismissDialog();
        this.f11964O000000o = XQProgressDialog.O000000o(this, "", getString(R.string.camera_waiting));
    }

    public void dismissDialog() {
        Dialog dialog = this.f11964O000000o;
        if (dialog != null) {
            dialog.dismiss();
            this.f11964O000000o = null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.content.Context, java.lang.String, boolean):java.lang.String
     arg types: [com.xiaomi.smarthome.wificonfig.CameraBarcodeGenActivity, java.lang.String, int]
     candidates:
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(int, int, android.content.Intent):void
      com.xiaomi.smarthome.smartconfig.step.SmartConfigStep.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):void
      com.xiaomi.smarthome.smartconfig.step.QRCameraStep.O000000o(android.content.Context, java.lang.String, boolean):java.lang.String */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0051 A[Catch:{ Throwable -> 0x00b4 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0052 A[Catch:{ Throwable -> 0x00b4 }] */
    public Bitmap genBarcodeBitmap() {
        String str;
        try {
            this.O00000Oo = null;
            StringBuilder sb = new StringBuilder();
            String O000000o2 = QRCameraStep.O000000o((Context) this, this.O0000O0o, false);
            String O000000o3 = QRCameraStep.O000000o((Context) this, this.O0000OOo, true);
            if (O000000o2 != null) {
                if (O000000o3 != null) {
                    sb.append("b=");
                    sb.append(this.bindKey);
                    sb.append("&s=");
                    sb.append(O000000o2);
                    sb.append("&p=");
                    sb.append(O000000o3);
                    sb.append("&t=");
                    sb.append(TimeZone.getDefault().getID());
                    str = sb.toString();
                    if (!TextUtils.isEmpty(str)) {
                        return null;
                    }
                    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                    int i = (int) (((float) displayMetrics.widthPixels) - (displayMetrics.density * 0.0f));
                    Hashtable hashtable = new Hashtable();
                    hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
                    new igw();
                    idm O000000o4 = igw.O000000o(str, BarcodeFormat.QR_CODE, i, i, hashtable);
                    int[] iArr = new int[(i * i)];
                    for (int i2 = 0; i2 < i; i2++) {
                        for (int i3 = 0; i3 < i; i3++) {
                            if (O000000o4.O000000o(i3, i2)) {
                                iArr[(i2 * i) + i3] = -16777216;
                            } else {
                                iArr[(i2 * i) + i3] = -1;
                            }
                        }
                    }
                    this.O00000Oo = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
                    this.O00000Oo.setPixels(iArr, 0, i, 0, 0, i, i);
                    return this.O00000Oo;
                }
            }
            str = null;
            if (!TextUtils.isEmpty(str)) {
            }
        } catch (Throwable th) {
            gsy.O00000o0(LogType.KUAILIAN, "genBarcodeBitmap", th.getMessage());
            return null;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("ret");
            if ("cancel".equals(stringExtra)) {
                setResult(0);
                finish();
            } else if ("ok".equals(stringExtra)) {
                setResult(-1);
                finish();
            } else if ("retry".equals(stringExtra)) {
                setResult(-1, intent);
                finish();
            }
        }
    }
}
