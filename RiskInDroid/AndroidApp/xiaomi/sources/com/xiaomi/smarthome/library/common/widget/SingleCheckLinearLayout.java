package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SingleCheckLinearLayout extends LinearLayout implements Checkable {

    /* renamed from: O000000o  reason: collision with root package name */
    View f9250O000000o;
    TextView O00000Oo;

    public void toggle() {
    }

    public SingleCheckLinearLayout(Context context) {
        super(context);
    }

    public SingleCheckLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f9250O000000o = findViewById(R.id.select_icon);
        this.O00000Oo = (TextView) findViewById(R.id.text1);
    }

    public void setChecked(boolean z) {
        if (z) {
            this.f9250O000000o.setVisibility(0);
        } else {
            this.f9250O000000o.setVisibility(4);
        }
        this.O00000Oo.setSelected(z);
    }

    public boolean isChecked() {
        return this.O00000Oo.isSelected();
    }
}
