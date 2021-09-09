package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SettingsItemView extends FrameLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f9248O000000o;
    TextView O00000Oo;
    SwitchButton O00000o;
    TextView O00000o0;
    ImageView O00000oO;
    View O00000oo;
    ImageView O0000O0o;
    View O0000OOo;
    View.OnClickListener O0000Oo;
    int O0000Oo0;
    CompoundButton.OnCheckedChangeListener O0000OoO;
    boolean O0000Ooo;
    O000000o O0000o00;

    public interface O000000o {
    }

    public void setOnSelectedListener(O000000o o000000o) {
        this.O0000o00 = o000000o;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.O0000Oo = onClickListener;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.O0000OoO = onCheckedChangeListener;
    }

    public void setChecked(boolean z) {
        SwitchButton switchButton = this.O00000o;
        if (switchButton != null) {
            switchButton.setOnCheckedChangeListener(null);
            this.O00000o.setChecked(z);
            this.O00000o.setOnCheckedChangeListener(this);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.O00000oo.setEnabled(z);
    }

    public TextView getInfoView() {
        return this.O00000o0;
    }

    public SettingsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000Ooo = false;
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.sm_widget_settings_item, (ViewGroup) null);
        this.O00000oo = inflate;
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        inflate.setBackgroundDrawable(getBackground());
        this.f9248O000000o = (TextView) inflate.findViewById(R.id.settings_item_title);
        this.O00000Oo = (TextView) inflate.findViewById(R.id.settings_item_sub_title);
        this.O00000o = (SwitchButton) inflate.findViewById(R.id.settings_item_switch_btn);
        this.O00000oO = (ImageView) inflate.findViewById(R.id.settings_item_arrow);
        this.O00000o0 = (TextView) inflate.findViewById(R.id.settings_item_info);
        this.O0000O0o = (ImageView) inflate.findViewById(R.id.settings_item_select);
        this.O0000OOo = inflate.findViewById(R.id.title_container);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.item_icon, R.attr.item_info, R.attr.item_line, R.attr.item_line_margin, R.attr.item_select, R.attr.item_subtitle, R.attr.item_title, R.attr.item_title_color, R.attr.item_type}, 0, 0);
        String string = obtainStyledAttributes.getString(6);
        String string2 = obtainStyledAttributes.getString(5);
        String string3 = obtainStyledAttributes.getString(1);
        this.O0000Oo0 = obtainStyledAttributes.getInt(8, 1);
        this.O0000Ooo = obtainStyledAttributes.getBoolean(4, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        obtainStyledAttributes.recycle();
        setTitle(string);
        setSubTitle(string2);
        setInfo(string3);
        setType(this.O0000Oo0);
        View view = new View(getContext());
        view.setBackgroundColor(-1710619);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.gravity = 80;
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(view, layoutParams);
    }

    public void setTitle(String str) {
        this.f9248O000000o.setText(str);
    }

    public String getTitle() {
        return this.f9248O000000o.getText().toString();
    }

    public void setSubTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O00000Oo.setVisibility(8);
            return;
        }
        this.O00000Oo.setText(str);
        this.O00000Oo.setVisibility(0);
    }

    public void setInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.O00000o0.setText(str);
            this.O00000o0.setVisibility(0);
            return;
        }
        this.O00000o0.setVisibility(8);
    }

    public void setSelect(boolean z) {
        this.O0000Ooo = z;
        if (z) {
            this.O0000O0o.setVisibility(0);
            this.f9248O000000o.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
            return;
        }
        this.f9248O000000o.setTextColor(getResources().getColor(R.color.mj_color_black_80_transparent));
        this.O0000O0o.setVisibility(4);
    }

    public boolean isSelected() {
        return this.O0000Ooo;
    }

    public void setType(int i) {
        this.O0000Oo0 = i;
        int i2 = this.O0000Oo0;
        if (i2 == 0) {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(8);
            this.O0000O0o.setVisibility(8);
            this.O00000oo.setOnClickListener(this);
        } else if (i2 == 1) {
            this.O00000o.setVisibility(8);
            this.O00000oo.setOnClickListener(this);
            this.O0000O0o.setVisibility(8);
        } else if (i2 == 2) {
            this.O00000oO.setVisibility(8);
            this.O00000o.setOnCheckedChangeListener(this);
            this.O0000O0o.setVisibility(8);
        } else if (i2 == 3) {
            this.O00000o.setVisibility(8);
            this.O00000oO.setVisibility(8);
            this.O00000oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.library.common.widget.SettingsItemView.AnonymousClass1 */

                public final void onClick(View view) {
                    if (!SettingsItemView.this.O0000Ooo) {
                        SettingsItemView settingsItemView = SettingsItemView.this;
                        settingsItemView.O0000Ooo = true;
                        settingsItemView.setSelect(settingsItemView.O0000Ooo);
                        if (SettingsItemView.this.O0000o00 == null) {
                            return;
                        }
                        return;
                    }
                    SettingsItemView settingsItemView2 = SettingsItemView.this;
                    settingsItemView2.O0000Ooo = false;
                    settingsItemView2.setSelect(settingsItemView2.O0000Ooo);
                }
            });
            setSelect(this.O0000Ooo);
        }
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.O0000Oo;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.O0000OoO;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    public void setSwitchEnable(boolean z) {
        SwitchButton switchButton = this.O00000o;
        if (switchButton != null) {
            switchButton.setEnabled(z);
        }
    }
}
