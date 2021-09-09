package com.xiaomi.shopviews.widget.homeluckydraw;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LuckyResultDialogTypeTwo extends Dialog {

    /* renamed from: O000000o  reason: collision with root package name */
    protected LinearLayout f3957O000000o;
    protected ImageView O00000Oo;
    protected TextView O00000o;
    protected RelativeLayout O00000o0;
    protected TextView O00000oO;
    private ImageView O00000oo;

    public LuckyResultDialogTypeTwo(Context context) {
        super(context, 2132739084);
        setContentView((int) R.layout.lucky_draw_result_dialog_type_two);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        onWindowAttributesChanged(attributes);
    }

    public void dismiss() {
        super.dismiss();
        this.O00000o0.setVisibility(8);
    }

    public void setContentView(int i) {
        super.setContentView(i);
        this.f3957O000000o = (LinearLayout) findViewById(R.id.container);
        this.O00000oO = (TextView) findViewById(R.id.text_title_lucky_title);
        this.O00000o = (TextView) findViewById(R.id.text_title_lucky_detail);
        this.O00000Oo = (ImageView) findViewById(R.id.icon_close);
        this.O00000oo = (ImageView) findViewById(R.id.igv_lucky_product);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.root_view);
        this.O00000o0 = relativeLayout;
        relativeLayout.setVisibility(8);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.shopviews.widget.homeluckydraw.LuckyResultDialogTypeTwo.AnonymousClass1 */

            public final void onClick(View view) {
                LuckyResultDialogTypeTwo.this.dismiss();
            }
        });
    }
}
