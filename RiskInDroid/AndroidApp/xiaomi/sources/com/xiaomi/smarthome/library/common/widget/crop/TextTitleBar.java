package com.xiaomi.smarthome.library.common.widget.crop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class TextTitleBar extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f9311O000000o = ((TextView) findViewById(R.id.titlebar_left_btn));
    TextView O00000Oo = ((TextView) findViewById(R.id.titlebar_title));
    TextView O00000o0 = ((TextView) findViewById(R.id.titlebar_right_text));

    public TextTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        inflate(context, R.layout.sm_widget_text_title_bar_layout, this);
    }

    public void setTitle(int i) {
        this.O00000Oo.setText(i);
    }

    public void setTitle(String str) {
        this.O00000Oo.setText(str);
    }

    public void setRightText(int i) {
        this.O00000o0.setText(i);
    }

    public void setRightText(String str) {
        this.O00000o0.setText(str);
    }

    public void setLeftText(int i) {
        this.f9311O000000o.setText(i);
    }

    public void setLeftText(String str) {
        this.f9311O000000o.setText(str);
    }

    public void setRightBtnOnClickListener(View.OnClickListener onClickListener) {
        this.O00000o0.setOnClickListener(onClickListener);
    }

    public void setLeftOnClickListener(View.OnClickListener onClickListener) {
        this.f9311O000000o.setOnClickListener(onClickListener);
    }

    public TextView getLeftView() {
        return this.f9311O000000o;
    }

    public TextView getTitleView() {
        return this.O00000Oo;
    }

    public TextView getRightView() {
        return this.O00000o0;
    }
}
