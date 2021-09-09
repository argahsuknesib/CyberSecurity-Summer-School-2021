package com.xiaomi.shopviews.widget.homeluckylottery;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LuckyResultDialog extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    protected TextView f3959O000000o;
    protected LinearLayout O00000Oo;
    protected RelativeLayout O00000o;
    protected ImageView O00000o0;
    protected TextView O00000oO;
    protected TextView O00000oo;
    protected TextView O0000O0o;

    public LuckyResultDialog(Context context) {
        super(context, 2132739084);
        setContentView((int) R.layout.lucky_draw_result_dialog);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        onWindowAttributesChanged(attributes);
    }

    public void dismiss() {
        super.dismiss();
        this.O00000o.setVisibility(8);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.O00000Oo = (LinearLayout) findViewById(R.id.container);
        this.O00000oo = (TextView) findViewById(R.id.text_title_lucky_no);
        this.O0000O0o = (TextView) findViewById(R.id.text_title_lucky_yes);
        this.O00000oO = (TextView) findViewById(R.id.text_title_lucky_goods);
        this.O00000o0 = (ImageView) findViewById(R.id.icon_close);
        this.f3959O000000o = (TextView) findViewById(R.id.btn_action);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_view);
        this.O00000o = relativeLayout;
        relativeLayout.setVisibility(8);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.widget.homeluckylottery.LuckyResultDialog.AnonymousClass1 */

            public final void onClick(View view) {
                LuckyResultDialog.this.dismiss();
            }
        });
    }
}
