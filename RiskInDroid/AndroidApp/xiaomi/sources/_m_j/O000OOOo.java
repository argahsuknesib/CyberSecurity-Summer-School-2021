package _m_j;

import O000000o.O000000o.O000000o.O00000oO.j;
import O000000o.O000000o.O000000o.O00000oO.p;
import O000000o.O000000o.O000000o.O00000oO.q;
import android.content.Context;
import android.widget.LinearLayout;
import com.hannto.circledialog.params.ButtonParams;
import com.hannto.circledialog.params.CircleParams;
import com.xiaomi.smarthome.R;

public final class O000OOOo extends p {

    /* renamed from: O000000o  reason: collision with root package name */
    public ButtonParams f5261O000000o;
    public ButtonParams O00000Oo;
    public q O00000o;
    public q O00000o0 = new q(getContext());

    public O000OOOo(Context context, CircleParams circleParams) {
        super(context);
        setOrientation(0);
        this.f5261O000000o = circleParams.O00000oO;
        this.O00000Oo = circleParams.O00000oo;
        this.O00000o0.setPadding(60, 0, 0, 0);
        this.O00000o0.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.O00000o0.setText(this.f5261O000000o.O0000Oo);
        this.O00000o0.setTextSize((float) this.f5261O000000o.O0000O0o);
        this.O00000o0.setTextColor(this.f5261O000000o.O00000oo);
        this.O00000o0.setHeight(this.f5261O000000o.O0000OOo);
        this.O00000o0.getPaint().setFakeBoldText(!this.f5261O000000o.O00000Oo);
        this.O00000o0.setBackgroundResource(R.drawable.ht_layer_dialog_negative_button_bg);
        this.O00000o0.setOnClickListener(new O000OO00(this));
        addView(this.O00000o0);
        addView(new j(getContext()));
        this.O00000o = new q(getContext());
        this.O00000o.setPadding(0, 0, 60, 0);
        this.O00000o.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        this.O00000o.setText(this.O00000Oo.O0000Oo);
        this.O00000o.setTextSize((float) this.O00000Oo.O0000O0o);
        this.O00000o.setTextColor(this.O00000Oo.O00000oo);
        this.O00000o.setHeight(this.O00000Oo.O0000OOo);
        this.O00000o.getPaint().setFakeBoldText(this.O00000Oo.O00000Oo);
        this.O00000o.setBackgroundResource(R.drawable.ht_layer_dialog_positive_button_bg);
        this.O00000o.setOnClickListener(new O000OO0o(this));
        addView(this.O00000o);
    }
}
