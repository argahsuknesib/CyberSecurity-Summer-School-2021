package com.mijia.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;

public class SettingsDeviceItem extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public SimpleDraweeView f5244O000000o;
    TextView O00000Oo;
    CheckBox O00000o;
    TextView O00000o0;
    private View O00000oO;

    public SettingsDeviceItem(Context context) {
        this(context, null);
    }

    public SettingsDeviceItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingsDeviceItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.settings_device_item, (ViewGroup) null);
        this.O00000oO = inflate;
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        this.f5244O000000o = (SimpleDraweeView) inflate.findViewById(R.id.idm_device_icon);
        this.O00000Oo = (TextView) inflate.findViewById(R.id.settings_item_title);
        this.O00000o0 = (TextView) inflate.findViewById(R.id.settings_item_sub_title);
        this.O00000o = (CheckBox) inflate.findViewById(R.id.idm_device_check_box);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.item_icon, R.attr.item_info, R.attr.item_line, R.attr.item_line_margin, R.attr.item_select, R.attr.item_subtitle, R.attr.item_title, R.attr.item_title_color, R.attr.item_type}, 0, 0);
        String string = obtainStyledAttributes.getString(6);
        String string2 = obtainStyledAttributes.getString(5);
        obtainStyledAttributes.getDimensionPixelSize(3, 0);
        obtainStyledAttributes.getColor(7, getResources().getColor(R.color.mj_color_black_80_transparent));
        setTitle(string);
        setSubTitle(string2);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setTitle(String str) {
        TextView textView = this.O00000Oo;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSubTitle(String str) {
        if (this.O00000o0 != null) {
            if (TextUtils.isEmpty(str)) {
                this.O00000o0.setVisibility(8);
                return;
            }
            this.O00000o0.setVisibility(0);
            this.O00000o0.setText(str);
        }
    }

    public void setChecked(boolean z) {
        CheckBox checkBox = this.O00000o;
        if (checkBox != null) {
            checkBox.setChecked(z);
        }
    }
}
