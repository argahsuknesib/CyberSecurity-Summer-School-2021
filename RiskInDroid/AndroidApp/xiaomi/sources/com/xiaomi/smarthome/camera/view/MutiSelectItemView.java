package com.xiaomi.smarthome.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class MutiSelectItemView extends FrameLayout {
    View mContainerView;
    private final ImageView mIconView;
    CheckBox multi_select_item_state_icon;
    TextView multi_select_item_title;
    public boolean selectState;

    public MutiSelectItemView(Context context) {
        this(context, null);
    }

    public MutiSelectItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MutiSelectItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectState = false;
        View inflate = LayoutInflater.from(context).inflate((int) R.layout.muti_select_item, (ViewGroup) null);
        this.mContainerView = inflate;
        this.multi_select_item_title = (TextView) this.mContainerView.findViewById(R.id.multi_select_item_title);
        this.multi_select_item_state_icon = (CheckBox) this.mContainerView.findViewById(R.id.multi_select_item_state_icon);
        this.multi_select_item_state_icon.setClickable(false);
        this.mIconView = (ImageView) this.mContainerView.findViewById(R.id.settings_icon);
        addView(inflate, new FrameLayout.LayoutParams(-1, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.item_icon, R.attr.item_info, R.attr.item_line, R.attr.item_line_margin, R.attr.item_select, R.attr.item_subtitle, R.attr.item_title, R.attr.item_title_color, R.attr.item_type}, 0, 0);
        String string = obtainStyledAttributes.getString(6);
        if (!TextUtils.isEmpty(string)) {
            this.multi_select_item_title.setText(string);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.mIconView.setVisibility(0);
            this.mIconView.setImageDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        setSelect(true);
    }

    public void setSelect(boolean z) {
        this.selectState = z;
        this.multi_select_item_state_icon.setChecked(this.selectState);
    }
}
