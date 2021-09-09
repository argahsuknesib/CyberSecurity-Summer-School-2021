package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class RadioItemLinearView extends LinearLayout {
    private boolean checked;
    ImageView checkedState;
    View divider;
    ImageView mIcon;
    TextView mTitle;

    public RadioItemLinearView(Context context) {
        super(context);
        init(context, null);
    }

    public RadioItemLinearView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RadioItemLinearView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate((int) R.layout.view_radio_linear, this);
        this.mIcon = (ImageView) findViewById(R.id.icon_image);
        this.mTitle = (TextView) findViewById(R.id.tv_title);
        this.checkedState = (ImageView) findViewById(R.id.ckecked_state);
        this.divider = findViewById(R.id.divider_line);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_has_divider, R.attr.mc_icon, R.attr.mc_title});
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            boolean z = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            int i = 8;
            if (resourceId != -1) {
                setIcon(resourceId);
            } else {
                this.mIcon.setVisibility(8);
            }
            setTitle(string);
            setChecked(Boolean.valueOf(this.checked));
            View view = this.divider;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
        }
    }

    public void setIcon(int i) {
        this.mIcon.setImageResource(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
    }

    public void setChecked(Boolean bool) {
        ImageView imageView = this.checkedState;
        if (imageView != null) {
            imageView.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public boolean isChecked() {
        ImageView imageView = this.checkedState;
        return imageView != null && imageView.getVisibility() == 0;
    }
}
