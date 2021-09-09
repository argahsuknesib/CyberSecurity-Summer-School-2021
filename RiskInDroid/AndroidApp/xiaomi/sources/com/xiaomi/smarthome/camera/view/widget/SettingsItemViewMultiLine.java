package com.xiaomi.smarthome.camera.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
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
import com.xiaomi.smarthome.library.common.widget.SwitchButton;

public class SettingsItemViewMultiLine extends FrameLayout implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    View mContainerView;
    ImageView mIconView;
    TextView mInfoTextView;
    CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    View.OnClickListener mOnClickListener;
    OnSelectedListener mOnSelectedListener;
    ImageView mOnclickImageView;
    ImageView mSelectImageView;
    boolean mSelected;
    TextView mSubTitleTextView;
    SwitchButton mSwitchButton;
    View mTitleContainer;
    TextView mTitleTextView;
    int mType;

    public interface OnSelectedListener {
        void onSelected(View view);
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.mOnSelectedListener = onSelectedListener;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
    }

    public void setChecked(boolean z) {
        SwitchButton switchButton = this.mSwitchButton;
        if (switchButton != null) {
            switchButton.setOnCheckedChangeListener(null);
            this.mSwitchButton.setChecked(z);
            this.mSwitchButton.setOnCheckedChangeListener(this);
        }
    }

    public boolean isChecked() {
        SwitchButton switchButton = this.mSwitchButton;
        if (switchButton != null) {
            return switchButton.isChecked();
        }
        return false;
    }

    public View getInfoView() {
        return this.mInfoTextView;
    }

    public SettingsItemViewMultiLine(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SettingsItemViewMultiLine(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSelected = false;
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.camera_settings_item_multi_line, (ViewGroup) null);
        this.mContainerView = inflate;
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        inflate.setBackgroundDrawable(getBackground());
        this.mTitleTextView = (TextView) inflate.findViewById(R.id.settings_item_title);
        this.mSubTitleTextView = (TextView) inflate.findViewById(R.id.settings_item_sub_title);
        this.mSwitchButton = (SwitchButton) inflate.findViewById(R.id.settings_item_switch_btn);
        this.mOnclickImageView = (ImageView) inflate.findViewById(R.id.settings_item_arrow);
        this.mInfoTextView = (TextView) inflate.findViewById(R.id.settings_item_info);
        this.mSelectImageView = (ImageView) inflate.findViewById(R.id.settings_item_select);
        this.mTitleContainer = inflate.findViewById(R.id.title_container);
        this.mIconView = (ImageView) findViewById(R.id.settings_icon);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.item_icon, R.attr.item_info, R.attr.item_line, R.attr.item_line_margin, R.attr.item_select, R.attr.item_subtitle, R.attr.item_title, R.attr.item_title_color, R.attr.item_type}, 0, 0);
        String string = obtainStyledAttributes.getString(6);
        String string2 = obtainStyledAttributes.getString(5);
        String string3 = obtainStyledAttributes.getString(1);
        this.mType = obtainStyledAttributes.getInt(8, 1);
        this.mSelected = obtainStyledAttributes.getBoolean(4, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        int color = obtainStyledAttributes.getColor(7, getResources().getColor(R.color.mj_color_black_80_transparent));
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.mIconView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        setTitle(string);
        setSubTitle(string2);
        setInfo(string3);
        setType(this.mType);
        this.mTitleTextView.setTextColor(color);
        View view = new View(getContext());
        view.setBackgroundColor(getResources().getColor(R.color.mj_color_separator));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 1);
        layoutParams.gravity = 80;
        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
        addView(view, layoutParams);
    }

    public void setTitle(String str) {
        this.mTitleTextView.setText(str);
    }

    public void setTitleColor(int i) {
        TextView textView = this.mTitleTextView;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setSubTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSubTitleTextView.setVisibility(8);
            return;
        }
        this.mSubTitleTextView.setText(str);
        this.mSubTitleTextView.setVisibility(0);
    }

    public void setInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mInfoTextView.setText(str);
            this.mInfoTextView.setVisibility(0);
            return;
        }
        this.mInfoTextView.setVisibility(8);
    }

    public void setSelect(boolean z) {
        this.mSelected = z;
        if (z) {
            this.mSelectImageView.setVisibility(0);
            this.mTitleTextView.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
            return;
        }
        this.mTitleTextView.setTextColor(getResources().getColor(R.color.mj_color_black_80_transparent));
        this.mSelectImageView.setVisibility(4);
    }

    public boolean isSelected() {
        return this.mSelected;
    }

    public void setType(int i) {
        this.mType = i;
        int i2 = this.mType;
        if (i2 == 0) {
            this.mSwitchButton.setVisibility(8);
            this.mOnclickImageView.setVisibility(8);
            this.mSelectImageView.setVisibility(8);
            this.mContainerView.setOnClickListener(this);
        } else if (i2 == 1) {
            this.mSwitchButton.setVisibility(8);
            this.mContainerView.setOnClickListener(this);
            this.mSelectImageView.setVisibility(8);
        } else if (i2 == 2) {
            this.mOnclickImageView.setVisibility(8);
            this.mSwitchButton.setOnCheckedChangeListener(this);
            this.mSelectImageView.setVisibility(8);
        } else if (i2 == 3) {
            this.mSwitchButton.setVisibility(8);
            this.mOnclickImageView.setVisibility(8);
            this.mContainerView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.view.widget.SettingsItemViewMultiLine.AnonymousClass1 */

                public void onClick(View view) {
                    if (!SettingsItemViewMultiLine.this.mSelected) {
                        SettingsItemViewMultiLine settingsItemViewMultiLine = SettingsItemViewMultiLine.this;
                        settingsItemViewMultiLine.mSelected = true;
                        settingsItemViewMultiLine.setSelect(settingsItemViewMultiLine.mSelected);
                        if (SettingsItemViewMultiLine.this.mOnSelectedListener != null) {
                            SettingsItemViewMultiLine.this.mOnSelectedListener.onSelected(SettingsItemViewMultiLine.this);
                        }
                    }
                }
            });
            setSelect(this.mSelected);
        }
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.mOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.mOnCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    public void setSwitchEnable(boolean z) {
        SwitchButton switchButton = this.mSwitchButton;
        if (switchButton != null) {
            switchButton.setEnabled(z);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        SwitchButton switchButton = this.mSwitchButton;
        if (switchButton != null) {
            switchButton.setEnabled(z);
        }
        this.mContainerView.setEnabled(z);
        if (z) {
            this.mTitleTextView.setAlpha(1.0f);
            this.mSubTitleTextView.setAlpha(1.0f);
            this.mInfoTextView.setAlpha(1.0f);
            return;
        }
        this.mTitleTextView.setAlpha(0.3f);
        this.mSubTitleTextView.setAlpha(0.3f);
        this.mInfoTextView.setAlpha(0.3f);
    }
}
