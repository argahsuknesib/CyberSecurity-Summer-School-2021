package com.xiaomi.passport.ui.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;

public class AreaCodePickerListItem extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public TextView f6288O000000o;
    public TextView O00000Oo;
    public View O00000o;
    public TextView O00000o0;

    public AreaCodePickerListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f6288O000000o = (TextView) findViewById(R$id.area);
        this.O00000Oo = (TextView) findViewById(R$id.area_code);
        this.O00000o0 = (TextView) findViewById(R$id.section_header);
        this.O00000o = findViewById(R$id.section_header_layout);
    }
}
