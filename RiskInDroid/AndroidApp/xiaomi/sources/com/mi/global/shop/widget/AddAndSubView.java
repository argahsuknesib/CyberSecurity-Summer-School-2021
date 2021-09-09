package com.mi.global.shop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class AddAndSubView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f4942O000000o;
    LinearLayout O00000Oo;
    LinearLayout O00000o;
    LinearLayout O00000o0;
    LinearLayout O00000oO;
    O00000Oo O00000oo;
    CustomButtonView O0000O0o;
    CustomButtonView O0000OOo;
    int O0000Oo;
    CustomTextView O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    int O0000o;
    int O0000o0;
    int O0000o00;
    int O0000o0O;
    int O0000o0o;
    int O0000oO0;

    public interface O00000Oo {
        void O000000o(int i);
    }

    public AddAndSubView(Context context) {
        super(context);
        this.f4942O000000o = context;
        this.O0000Oo = 0;
        O000000o();
    }

    public AddAndSubView(Context context, int i) {
        super(context);
        this.f4942O000000o = context;
        this.O0000Oo = i;
        O000000o();
    }

    public AddAndSubView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4942O000000o = context;
        this.O0000Oo = 0;
        O000000o();
    }

    public void setEnable(Boolean bool) {
        this.O0000O0o.setEnabled(bool.booleanValue());
        this.O0000OOo.setEnabled(bool.booleanValue());
        this.O0000Oo0.setEnabled(bool.booleanValue());
        if (bool.booleanValue()) {
            if (this.O0000Oo <= this.O0000Ooo) {
                this.O0000OOo.setEnabled(false);
            }
            if (this.O0000Oo >= this.O0000OoO) {
                this.O0000O0o.setEnabled(false);
            }
        }
    }

    private void O000000o() {
        O00000o0();
        O00000o();
        O00000oO();
        O00000Oo();
        O0000O0o();
        O0000OOo();
        this.O0000OoO = Integer.MAX_VALUE;
        this.O0000Ooo = 0;
        this.O0000OOo.setEnabled(false);
    }

    private void O00000Oo() {
        CustomButtonView customButtonView = this.O0000O0o;
        if (customButtonView != null) {
            customButtonView.setBackgroundResource(R.drawable.shop_btn_add_bg);
        }
        CustomButtonView customButtonView2 = this.O0000OOo;
        if (customButtonView2 != null) {
            customButtonView2.setBackgroundResource(R.drawable.shop_btn_sub_bg);
        }
        LinearLayout linearLayout = this.O00000Oo;
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.shop_border_confirm_payment_black);
        }
    }

    private void O00000o0() {
        this.O0000o00 = -1;
        this.O0000o0 = -1;
        this.O0000o0O = -1;
        this.O0000o0o = -1;
        this.O0000o = -1;
        this.O0000oO0 = -1;
    }

    private void O00000o() {
        this.O00000Oo = new LinearLayout(this.f4942O000000o);
        this.O00000o0 = new LinearLayout(this.f4942O000000o);
        this.O00000o = new LinearLayout(this.f4942O000000o);
        this.O00000oO = new LinearLayout(this.f4942O000000o);
        this.O0000O0o = new CustomButtonView(this.f4942O000000o);
        this.O0000OOo = new CustomButtonView(this.f4942O000000o);
        this.O0000Oo0 = new CustomTextView(this.f4942O000000o);
        this.O0000O0o.setTag("+");
        this.O0000OOo.setTag("-");
        this.O0000Oo0.setFocusable(false);
        this.O0000Oo0.setFocusableInTouchMode(false);
        this.O0000Oo0.setText(String.valueOf(this.O0000Oo));
    }

    private void O00000oO() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.O0000O0o.setLayoutParams(layoutParams);
        this.O0000OOo.setLayoutParams(layoutParams);
        this.O0000Oo0.setLayoutParams(layoutParams);
        this.O0000Oo0.setGravity(17);
        O00000oo();
        layoutParams.gravity = 17;
        this.O00000o.setLayoutParams(layoutParams);
        this.O00000o.setFocusable(true);
        this.O00000o.setFocusableInTouchMode(true);
        layoutParams.width = -2;
        layoutParams.weight = 1.0f;
        this.O00000o0.setLayoutParams(layoutParams);
        this.O00000oO.setLayoutParams(layoutParams);
        layoutParams.width = -1;
        this.O00000Oo.setLayoutParams(layoutParams);
        this.O00000Oo.setOrientation(0);
    }

    private static int O000000o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void O00000oo() {
        if (this.O0000o0O < 0) {
            this.O0000o0O = O000000o(this.f4942O000000o, 80.0f);
        }
        this.O0000Oo0.setMinimumWidth(O000000o(this.f4942O000000o, (float) this.O0000o0O));
        this.O00000o.setMinimumWidth(O000000o(this.f4942O000000o, (float) this.O0000o0O));
        int i = this.O0000oO0;
        if (i > 0) {
            int i2 = this.O0000o;
            if (i2 >= 0 && i2 > i) {
                this.O0000oO0 = i2;
            }
            this.O0000Oo0.setHeight(O000000o(this.f4942O000000o, (float) this.O0000oO0));
        }
        int i3 = this.O0000o0;
        if (i3 > 0) {
            int i4 = this.O0000o0o;
            if (i4 > 0 && i4 > i3) {
                this.O0000o0 = i4;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.O0000Oo0.getLayoutParams();
            layoutParams.height = O000000o(this.f4942O000000o, (float) this.O0000o0);
            this.O0000Oo0.setLayoutParams(layoutParams);
            this.O00000o.setLayoutParams(layoutParams);
        }
        int i5 = this.O0000o00;
        if (i5 > 0) {
            int i6 = this.O0000o0O;
            if (i6 > 0 && i6 > i5) {
                this.O0000o00 = i6;
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.O0000Oo0.getLayoutParams();
            layoutParams2.width = O000000o(this.f4942O000000o, (float) this.O0000o00);
            this.O0000Oo0.setLayoutParams(layoutParams2);
            this.O00000o.setLayoutParams(layoutParams2);
        }
    }

    private void O0000O0o() {
        this.O00000Oo.addView(this.O00000o0, 0);
        this.O00000Oo.addView(this.O00000o, 1);
        this.O00000Oo.addView(this.O00000oO, 2);
        this.O00000o0.addView(this.O0000OOo);
        this.O00000o.addView(this.O0000Oo0);
        this.O00000oO.addView(this.O0000O0o);
        addView(this.O00000Oo);
    }

    public void setNum(int i) {
        this.O0000Oo = i;
        this.O0000Oo0.setText(String.valueOf(i));
        int i2 = this.O0000OoO;
        if (i >= i2) {
            this.O0000Oo = i2;
            this.O0000O0o.setEnabled(false);
        }
        int i3 = this.O0000Ooo;
        if (i <= i3) {
            this.O0000Oo = i3;
            this.O0000OOo.setEnabled(false);
        }
        if (i > this.O0000Ooo) {
            this.O0000OOo.setEnabled(true);
        }
        if (i < this.O0000OoO) {
            this.O0000O0o.setEnabled(true);
        }
    }

    public void setMax(int i) {
        if (i >= this.O0000Ooo) {
            this.O0000OoO = i;
        }
    }

    public void setMin(int i) {
        if (i <= this.O0000OoO && i >= 0) {
            this.O0000Ooo = i;
        }
    }

    public int getNum() {
        if (this.O0000Oo0.getText().toString() != null) {
            return Integer.parseInt(this.O0000Oo0.getText().toString());
        }
        return 0;
    }

    public void setEditTextMinimumWidth(int i) {
        if (i > 0) {
            this.O0000o0O = i;
            this.O0000Oo0.setMinimumWidth(O000000o(this.f4942O000000o, (float) i));
        }
    }

    public void setEditTextMinimumHeight(int i) {
        if (i > 0) {
            this.O0000o0o = i;
            this.O0000Oo0.setMinimumHeight(O000000o(this.f4942O000000o, (float) i));
        }
    }

    public void setEditTextMinHeight(int i) {
        if (i > 0) {
            this.O0000o = i;
            this.O0000Oo0.setMinHeight(O000000o(this.f4942O000000o, (float) i));
        }
    }

    public void setEditTextHeight(int i) {
        this.O0000oO0 = i;
        O00000oo();
    }

    public void setEditTextLayoutWidth(int i) {
        this.O0000o00 = i;
        O00000oo();
    }

    public void setEditTextLayoutHeight(int i) {
        this.O0000o0 = i;
        O00000oo();
    }

    public void setTextSize(int i) {
        this.O0000Oo0.setTextSize((float) i);
    }

    public void setOnNumChangeListener(O00000Oo o00000Oo) {
        this.O00000oo = o00000Oo;
    }

    private void O0000OOo() {
        this.O0000O0o.setOnClickListener(new O000000o());
        this.O0000OOo.setOnClickListener(new O000000o());
    }

    class O000000o implements View.OnClickListener {
        O000000o() {
        }

        public final void onClick(View view) {
            String charSequence = AddAndSubView.this.O0000Oo0.getText().toString();
            if (charSequence == null || charSequence.equals("")) {
                AddAndSubView addAndSubView = AddAndSubView.this;
                addAndSubView.O0000Oo = 0;
                addAndSubView.O0000Oo0.setText(String.valueOf(AddAndSubView.this.O0000Oo));
            } else if (view.getTag().equals("+")) {
                AddAndSubView addAndSubView2 = AddAndSubView.this;
                int i = addAndSubView2.O0000Oo + 1;
                addAndSubView2.O0000Oo = i;
                if (i > AddAndSubView.this.O0000OoO) {
                    AddAndSubView addAndSubView3 = AddAndSubView.this;
                    addAndSubView3.O0000Oo--;
                    AddAndSubView addAndSubView4 = AddAndSubView.this;
                    addAndSubView4.setNum(addAndSubView4.O0000Oo);
                    return;
                }
                AddAndSubView addAndSubView5 = AddAndSubView.this;
                addAndSubView5.setNum(addAndSubView5.O0000Oo);
                if (AddAndSubView.this.O00000oo != null) {
                    AddAndSubView.this.O00000oo.O000000o(AddAndSubView.this.O0000Oo);
                }
            } else if (view.getTag().equals("-")) {
                AddAndSubView addAndSubView6 = AddAndSubView.this;
                int i2 = addAndSubView6.O0000Oo - 1;
                addAndSubView6.O0000Oo = i2;
                if (i2 < AddAndSubView.this.O0000Ooo) {
                    AddAndSubView.this.O0000Oo++;
                    AddAndSubView addAndSubView7 = AddAndSubView.this;
                    addAndSubView7.setNum(addAndSubView7.O0000Oo);
                    return;
                }
                AddAndSubView addAndSubView8 = AddAndSubView.this;
                addAndSubView8.setNum(addAndSubView8.O0000Oo);
                if (AddAndSubView.this.O00000oo != null) {
                    AddAndSubView.this.O00000oo.O000000o(AddAndSubView.this.O0000Oo);
                }
            }
        }
    }
}
