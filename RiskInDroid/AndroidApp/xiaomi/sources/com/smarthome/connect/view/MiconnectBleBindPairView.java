package com.smarthome.connect.view;

import _m_j.ddf;
import _m_j.ddh;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class MiconnectBleBindPairView extends RelativeLayout implements ddf {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f5643O000000o;
    public TextView O00000Oo;
    TextView O00000o;
    public TextView O00000o0;
    TextView O00000oO;
    TextView O00000oo;
    TextView O0000O0o;
    TextView O0000OOo;
    TextView O0000Oo;
    TextView O0000Oo0;
    public ddh O0000OoO;
    public Handler O0000Ooo;
    public Runnable O0000o0 = new Runnable() {
        /* class com.smarthome.connect.view.MiconnectBleBindPairView.AnonymousClass1 */

        public final void run() {
            if (MiconnectBleBindPairView.this.O00000o0.getVisibility() == 0) {
                MiconnectBleBindPairView miconnectBleBindPairView = MiconnectBleBindPairView.this;
                miconnectBleBindPairView.O0000o00--;
                if (MiconnectBleBindPairView.this.O0000o00 > 0) {
                    MiconnectBleBindPairView.this.O00000Oo.setVisibility(0);
                    MiconnectBleBindPairView.this.O00000o0.setText(MiconnectBleBindPairView.this.O0000o00 + MiconnectBleBindPairView.this.getResources().getString(R.string.miconnect_ble_auth_pair_code_time_unit));
                    MiconnectBleBindPairView.this.O0000Ooo.postDelayed(MiconnectBleBindPairView.this.O0000o0, 1000);
                    return;
                }
                MiconnectBleBindPairView miconnectBleBindPairView2 = MiconnectBleBindPairView.this;
                miconnectBleBindPairView2.f5643O000000o.setText((int) R.string.miconnect_ble_auth_pair_code_expired);
                miconnectBleBindPairView2.f5643O000000o.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.black));
                miconnectBleBindPairView2.O00000o.setVisibility(0);
                miconnectBleBindPairView2.O00000o0.setVisibility(8);
                miconnectBleBindPairView2.O00000Oo.setVisibility(4);
                miconnectBleBindPairView2.O00000oO.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O00000oo.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O0000O0o.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O0000OOo.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O0000Oo0.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O0000Oo.setTextColor(miconnectBleBindPairView2.getResources().getColor(R.color.mj_color_separator));
                miconnectBleBindPairView2.O0000Ooo.removeCallbacks(miconnectBleBindPairView2.O0000o0);
            }
        }
    };
    public int O0000o00 = 30;

    public MiconnectBleBindPairView(Context context) {
        super(context);
        O00000o();
    }

    public MiconnectBleBindPairView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o();
    }

    public MiconnectBleBindPairView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o();
    }

    private void O00000o() {
        this.O0000Ooo = new Handler();
        LayoutInflater.from(getContext()).inflate((int) R.layout.miconnect_ble_bind_pair_layout, this);
        findViewById(R.id.blank_view).setOnTouchListener(new View.OnTouchListener() {
            /* class com.smarthome.connect.view.MiconnectBleBindPairView.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    MiconnectBleBindPairView.this.O00000o0();
                }
                return true;
            }
        });
        findViewById(R.id.content_layout).setOnTouchListener(new View.OnTouchListener() {
            /* class com.smarthome.connect.view.MiconnectBleBindPairView.AnonymousClass3 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        ((TextView) findViewById(R.id.common_tile_tv)).setText((int) R.string.miconnect_choose_device_title);
        this.O00000Oo = (TextView) findViewById(R.id.sub_parcode_tip);
        this.f5643O000000o = (TextView) findViewById(R.id.paircode_tip);
        this.O00000o0 = (TextView) findViewById(R.id.paircode_countdown);
        this.O00000o = (TextView) findViewById(R.id.common_bottom_tv);
        this.O00000oO = (TextView) findViewById(R.id.pair_code_text_1);
        this.O00000oo = (TextView) findViewById(R.id.pair_code_text_2);
        this.O0000O0o = (TextView) findViewById(R.id.pair_code_text_3);
        this.O0000OOo = (TextView) findViewById(R.id.pair_code_text_4);
        this.O0000Oo0 = (TextView) findViewById(R.id.pair_code_text_5);
        this.O0000Oo = (TextView) findViewById(R.id.pair_code_text_6);
        this.O00000o.setText((int) R.string.miui_connect_retry);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.connect.view.MiconnectBleBindPairView.AnonymousClass4 */

            public final void onClick(View view) {
                if (MiconnectBleBindPairView.this.O0000OoO != null) {
                    MiconnectBleBindPairView.this.O0000OoO.O00000Oo();
                }
            }
        });
        this.O00000o.setVisibility(8);
        this.O00000Oo.setVisibility(0);
        this.f5643O000000o.setText((int) R.string.miconnect_ble_auth_pair_code_tips);
        TextView textView = this.O00000o0;
        textView.setText(this.O0000o00 + getResources().getString(R.string.miconnect_ble_auth_pair_code_time_unit));
        this.O0000Ooo.postDelayed(this.O0000o0, 1000);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.O0000OoO = null;
        this.O0000Ooo.removeCallbacks(this.O0000o0);
    }

    public void setPairCallback(ddh ddh) {
        this.O0000OoO = ddh;
    }

    public void setPaircode(String str) {
        if (str != null && str.length() >= 6) {
            TextView textView = this.O00000oO;
            StringBuilder sb = new StringBuilder();
            sb.append(str.charAt(0));
            textView.setText(sb.toString());
            TextView textView2 = this.O00000oo;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.charAt(1));
            textView2.setText(sb2.toString());
            TextView textView3 = this.O0000O0o;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str.charAt(2));
            textView3.setText(sb3.toString());
            TextView textView4 = this.O0000OOo;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str.charAt(3));
            textView4.setText(sb4.toString());
            TextView textView5 = this.O0000Oo0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str.charAt(4));
            textView5.setText(sb5.toString());
            TextView textView6 = this.O0000Oo;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str.charAt(5));
            textView6.setText(sb6.toString());
        }
    }

    public final void O00000Oo() {
        O00000o0();
    }

    public final void O000000o() {
        this.f5643O000000o.setText((int) R.string.miconnect_ble_auth_pair_code_failed);
        this.O00000o.setVisibility(0);
        this.O00000o0.setVisibility(8);
        this.O0000Ooo.removeCallbacks(this.O0000o0);
    }

    public final void O00000o0() {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.miconnect_exit_confirm_title).O00000Oo((int) R.string.miconnect_exit_confirm_content).O000000o((int) R.string.miconnect_ble_new_cancel_dialog_ok_button, new DialogInterface.OnClickListener() {
            /* class com.smarthome.connect.view.MiconnectBleBindPairView.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (MiconnectBleBindPairView.this.O0000OoO != null) {
                    MiconnectBleBindPairView.this.O0000OoO.O000000o();
                }
            }
        }).O00000Oo((int) R.string.sh_common_lib_cancel, (DialogInterface.OnClickListener) null).O00000o().show();
    }
}
