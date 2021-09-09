package com.xiaomi.smarthome.wificonfig;

import _m_j.fno;
import _m_j.htq;
import _m_j.hua;
import _m_j.hud;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import org.json.JSONObject;

public class CameraBarcodeWaitingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected long f11976O000000o;
    private String O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;
    private PieProgressBar O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private TextView O0000OOo;
    private View O0000Oo;
    private ImageView O0000Oo0;
    private View O0000OoO;
    private View O0000Ooo;
    private View O0000o0;
    private View O0000o00;
    private View O0000o0O;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_camera_gen_barcode_waiting);
        this.O00000Oo = getIntent().getStringExtra("bindKey");
        this.O00000oO = (PieProgressBar) findViewById(R.id.kuailian_progress);
        this.O00000o0 = (TextView) findViewById(R.id.kuailianing_main_title);
        this.O00000o = (TextView) findViewById(R.id.kuailianing_main_sub_title);
        this.O00000oo = (TextView) findViewById(R.id.connecting_progress);
        this.O0000OOo = (TextView) findViewById(R.id.finish_title);
        this.O0000O0o = (TextView) findViewById(R.id.kuailianing_final_info);
        this.O0000Oo0 = (ImageView) findViewById(R.id.icon_final);
        this.O0000Oo = findViewById(R.id.fouth_step);
        this.O0000OoO = findViewById(R.id.final_step);
        this.O0000Ooo = findViewById(R.id.finish_error_btn_container);
        this.O0000o00 = findViewById(R.id.finish_success_btn);
        this.O0000o0 = findViewById(R.id.retry_btn);
        this.O0000o0O = findViewById(R.id.cancel_btn);
        this.O00000oO.setPercentView(this.O00000oo);
        this.f11976O000000o = System.currentTimeMillis();
        this.mHandler.sendEmptyMessageDelayed(1, 100);
        this.O00000o0.setText(String.format(getString(R.string.kuailian_main_title_3), SmartConfigRouterFactory.getSmartConfigManager().getAppContext().getString(R.string.camera_name)));
        this.O0000OOo.setVisibility(0);
        this.O0000OOo.setText((int) R.string.sh_common_cancel);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ret", "cancel");
                CameraBarcodeWaitingActivity.this.setResult(-1, intent);
                CameraBarcodeWaitingActivity.this.finish();
            }
        });
        O000000o();
    }

    private void O000000o() {
        htq.O000000o().O000000o(this.O00000Oo, new hua<JSONObject, hud>() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass1 */

            public final /* synthetic */ void O000000o(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                int optInt = jSONObject.optInt("ret");
                if (optInt == 0) {
                    int optInt2 = jSONObject.optInt("check_after");
                    if (optInt2 > 0) {
                        CameraBarcodeWaitingActivity.this.mHandler.removeMessages(2);
                        CameraBarcodeWaitingActivity.this.mHandler.sendEmptyMessageDelayed(2, (long) (optInt2 * 1000));
                        return;
                    }
                    CameraBarcodeWaitingActivity.this.switchToFinalStep(false, R.string.kuailian_failed);
                } else if (optInt == 1) {
                    String optString = jSONObject.optString("bind_did");
                    if (!optString.startsWith("yunyi.")) {
                        optString = "yunyi.".concat(String.valueOf(optString));
                    }
                    Device O000000o2 = fno.O000000o().O000000o(optString);
                    if (O000000o2 != null) {
                        O000000o2.setOwner(true);
                    }
                    fno.O000000o().O0000Oo0();
                    CameraBarcodeWaitingActivity.this.switchToFinalStep(true, R.string.kuailian_success);
                } else if (optInt == -2 || optInt == -3) {
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(CameraBarcodeWaitingActivity.this);
                    builder.O00000Oo((int) R.string.kuailian_falied_bindkey_invalide);
                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass1.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent();
                            intent.putExtra("ret", "retry");
                            CameraBarcodeWaitingActivity.this.setResult(-1, intent);
                            CameraBarcodeWaitingActivity.this.finish();
                        }
                    });
                    builder.O00000oo();
                } else {
                    CameraBarcodeWaitingActivity.this.switchToFinalStep(false, R.string.kuailian_failed);
                }
            }

            public final void O000000o(hud hud) {
                CameraBarcodeWaitingActivity.this.switchToFinalStep(false, R.string.kuailian_failed);
            }
        });
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.f11976O000000o)) * 100.0f) / 120000.0f;
            if (currentTimeMillis > 101.0f) {
                switchToFinalStep(false, R.string.kuailian_failed);
                return;
            }
            this.O00000oO.setPercent(currentTimeMillis);
            this.O00000o.setText((int) R.string.kuailian_sub_main_title_waiting);
            this.mHandler.sendEmptyMessageDelayed(1, 100);
        } else if (i == 2) {
            O000000o();
        }
    }

    public void switchToFinalStep(boolean z, int i) {
        this.O0000Oo.setVisibility(8);
        this.mHandler.removeMessages(1);
        this.O0000OOo.setVisibility(4);
        this.O0000OoO.setVisibility(0);
        this.O0000O0o.setText(i);
        if (z) {
            this.O0000Ooo.setVisibility(8);
            this.O0000Oo0.setImageResource(R.drawable.kuailian_success_icon);
            this.O0000o00.setVisibility(0);
            this.O0000o00.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("ret", "ok");
                    CameraBarcodeWaitingActivity.this.setResult(-1, intent);
                    CameraBarcodeWaitingActivity.this.finish();
                }
            });
            return;
        }
        this.O0000Oo0.setImageResource(R.drawable.kuailian_failed_icon);
        this.O0000Ooo.setVisibility(0);
        this.O0000o00.setVisibility(8);
        this.O0000o0O.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass4 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ret", "cancel");
                CameraBarcodeWaitingActivity.this.setResult(-1, intent);
                CameraBarcodeWaitingActivity.this.finish();
            }
        });
        this.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.wificonfig.CameraBarcodeWaitingActivity.AnonymousClass5 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ret", "retry");
                CameraBarcodeWaitingActivity.this.setResult(-1, intent);
                CameraBarcodeWaitingActivity.this.finish();
            }
        });
    }
}
