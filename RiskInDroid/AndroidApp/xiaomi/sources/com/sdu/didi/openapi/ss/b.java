package com.sdu.didi.openapi.ss;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sdu.didi.openapi.utils.Utils;

public class b {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5603O000000o;
    private O000000o O00000Oo;

    public b(Context context) {
        this.f5603O000000o = context;
    }

    public final void O000000o(String str) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new O000000o(this.f5603O000000o, str);
        }
        this.O00000Oo.show();
    }

    public class O000000o extends Dialog {
        protected O000000o(Context context, String str) {
            super(context);
            requestWindowFeature(1);
            d dVar = new d(getContext());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius((float) Utils.O000000o(getContext(), 6.0f));
            gradientDrawable.setColor(-1);
            getWindow().setBackgroundDrawable(gradientDrawable);
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.O000000o(getContext(), 300.0f), Utils.O000000o(getContext(), 260.0f));
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(dVar.O00000Oo("didi_info_icon"));
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(Utils.O000000o(getContext(), 60.0f), Utils.O000000o(getContext(), 60.0f));
            layoutParams2.addRule(14, 1);
            layoutParams2.topMargin = Utils.O000000o(getContext(), 30.0f);
            relativeLayout.addView(imageView, layoutParams2);
            TextView textView = new TextView(getContext());
            textView.setPadding(Utils.O000000o(getContext(), 20.0f), 0, Utils.O000000o(getContext(), 20.0f), 0);
            textView.setGravity(1);
            textView.setTextColor(Color.parseColor("#ff878787"));
            textView.setTextSize(2, 19.0f);
            textView.setText(str);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams3.topMargin = Utils.O000000o(getContext(), 100.0f);
            relativeLayout.addView(textView, layoutParams3);
            Button button = new Button(getContext());
            button.setTextSize(2, 16.0f);
            button.setTextColor(-1);
            button.setGravity(17);
            button.setText("我知道了");
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius((float) Utils.O000000o(getContext(), 6.0f));
            gradientDrawable2.setColor(Color.parseColor("#ffff8903"));
            button.setBackground(gradientDrawable2);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(Utils.O000000o(getContext(), 200.0f), Utils.O000000o(getContext(), 50.0f));
            layoutParams4.addRule(14, 1);
            layoutParams4.topMargin = Utils.O000000o(getContext(), 190.0f);
            relativeLayout.addView(button, layoutParams4);
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.sdu.didi.openapi.ss.b.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    O000000o.this.dismiss();
                }
            });
            setContentView(relativeLayout, layoutParams);
        }
    }
}
