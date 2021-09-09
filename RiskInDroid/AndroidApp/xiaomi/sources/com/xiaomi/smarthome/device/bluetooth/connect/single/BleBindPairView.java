package com.xiaomi.smarthome.device.bluetooth.connect.single;

import _m_j.ddf;
import _m_j.ddh;
import _m_j.hvg;
import _m_j.hzf;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class BleBindPairView extends RelativeLayout implements ddf {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f7124O000000o;
    public TextView O00000Oo;
    TextView O00000o;
    TextView O00000o0;
    TextView O00000oO;
    TextView O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    public ddh O0000Oo;
    TextView O0000Oo0;
    public Handler O0000OoO;
    public int O0000Ooo = 30;
    private View O0000o0;
    public Runnable O0000o00 = new Runnable() {
        /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView.AnonymousClass1 */

        public final void run() {
            if (BleBindPairView.this.O00000Oo.getVisibility() == 0) {
                BleBindPairView bleBindPairView = BleBindPairView.this;
                bleBindPairView.O0000Ooo--;
                if (BleBindPairView.this.O0000Ooo > 0) {
                    BleBindPairView.this.O00000Oo.setText(BleBindPairView.this.O0000Ooo + "s");
                    BleBindPairView.this.O0000OoO.postDelayed(BleBindPairView.this.O0000o00, 1000);
                    return;
                }
                BleBindPairView bleBindPairView2 = BleBindPairView.this;
                bleBindPairView2.f7124O000000o.setText((int) R.string.ble_auth_pair_code_expired);
                bleBindPairView2.f7124O000000o.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_black));
                bleBindPairView2.O00000o0.setVisibility(0);
                bleBindPairView2.O00000Oo.setVisibility(8);
                bleBindPairView2.O00000o.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O00000oO.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O00000oo.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O0000O0o.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O0000OOo.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O0000Oo0.setTextColor(bleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                bleBindPairView2.O0000OoO.removeCallbacks(bleBindPairView2.O0000o00);
            }
        }
    };
    private ImageView O0000o0O;

    public BleBindPairView(Context context) {
        super(context);
        O00000o();
    }

    public BleBindPairView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o();
    }

    public BleBindPairView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o();
    }

    private void O00000o() {
        this.O0000OoO = new Handler();
        LayoutInflater.from(getContext()).inflate((int) R.layout.ble_bind_pair_layout, this);
        this.O0000o0 = findViewById(R.id.paircode_title);
        this.O0000o0O = (ImageView) findViewById(R.id.close_btn);
        this.f7124O000000o = (TextView) findViewById(R.id.paircode_tip);
        this.O00000Oo = (TextView) findViewById(R.id.paircode_countdown);
        this.O00000o0 = (TextView) findViewById(R.id.retry_btn);
        this.O00000o = (TextView) findViewById(R.id.pair_code_text_1);
        this.O00000oO = (TextView) findViewById(R.id.pair_code_text_2);
        this.O00000oo = (TextView) findViewById(R.id.pair_code_text_3);
        this.O0000O0o = (TextView) findViewById(R.id.pair_code_text_4);
        this.O0000OOo = (TextView) findViewById(R.id.pair_code_text_5);
        this.O0000Oo0 = (TextView) findViewById(R.id.pair_code_text_6);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView.AnonymousClass2 */

            public final void onClick(View view) {
                if (BleBindPairView.this.O0000Oo != null) {
                    BleBindPairView.this.O0000Oo.O00000Oo();
                }
            }
        });
        this.O0000o0O.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView.AnonymousClass3 */

            public final void onClick(View view) {
                BleBindPairView.this.O00000o0();
            }
        });
        this.f7124O000000o.setText((int) R.string.ble_auth_pair_code_tips);
        TextView textView = this.O00000Oo;
        textView.setText(this.O0000Ooo + "s");
        this.O0000OoO.postDelayed(this.O0000o00, 1000);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int O000000o2;
        super.onAttachedToWindow();
        if (this.O0000o0 != null && (O000000o2 = hzf.O000000o(getContext())) != -1) {
            if (this.O0000o0.getLayoutParams().height > 0) {
                this.O0000o0.getLayoutParams().height += O000000o2;
            }
            this.O0000o0.setPadding(0, O000000o2, 0, 0);
            View view = this.O0000o0;
            view.setLayoutParams(view.getLayoutParams());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000Oo = null;
        this.O0000OoO.removeCallbacks(this.O0000o00);
    }

    public void setPairCallback(ddh ddh) {
        this.O0000Oo = ddh;
    }

    public void setPaircode(String str) {
        if (str != null && str.length() >= 6) {
            hvg.O000000o(getContext()).O00000Oo(46);
            TextView textView = this.O00000o;
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            textView.setText(sb.toString());
            TextView textView2 = this.O00000oO;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.charAt(1));
            textView2.setText(sb2.toString());
            TextView textView3 = this.O00000oo;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str.charAt(2));
            textView3.setText(sb3.toString());
            TextView textView4 = this.O0000O0o;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str.charAt(3));
            textView4.setText(sb4.toString());
            TextView textView5 = this.O0000OOo;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str.charAt(4));
            textView5.setText(sb5.toString());
            TextView textView6 = this.O0000Oo0;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str.charAt(5));
            textView6.setText(sb6.toString());
        }
    }

    public final void O00000Oo() {
        O00000o0();
    }

    public final void O000000o() {
        this.f7124O000000o.setText((int) R.string.ble_auth_pair_code_failed);
        this.f7124O000000o.setTextColor(getResources().getColor(R.color.mj_color_text_warning));
        this.O00000o0.setVisibility(0);
        this.O00000Oo.setVisibility(8);
        this.O0000OoO.removeCallbacks(this.O0000o00);
    }

    public final void O00000o0() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.ble_new_cancel_dialog_title).O00000Oo((int) R.string.ble_new_cancel_dialog_message).O000000o((int) R.string.ble_new_cancel_dialog_ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.device.bluetooth.connect.single.BleBindPairView.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (BleBindPairView.this.O0000Oo != null) {
                    BleBindPairView.this.O0000Oo.O000000o();
                }
            }
        }).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
    }
}
