package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class TitleDescAndSwitcher extends FrameLayout {
    TextView desView;
    SlidingButton switcher;
    TextView titleView;
    protected View view;

    public TitleDescAndSwitcher(Context context) {
        super(context);
        init(context, null, 0);
    }

    public TitleDescAndSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public TitleDescAndSwitcher(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    public SlidingButton getSlidingButton() {
        return this.switcher;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.TitleDescAndSwitcher, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* access modifiers changed from: protected */
    public void init(Context context, AttributeSet attributeSet, int i) {
        this.view = LayoutInflater.from(context).inflate((int) R.layout.widget_title_desc_and_switcher, (ViewGroup) this, false);
        this.titleView = (TextView) this.view.findViewById(R.id.title);
        this.desView = (TextView) this.view.findViewById(R.id.description);
        this.switcher = (SlidingButton) this.view.findViewById(R.id.switcher);
        addView(this.view);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_checked, R.attr.mc_description, R.attr.mc_show_switcher, R.attr.mc_title}, i, 0);
            CharSequence text = obtainStyledAttributes.getText(3);
            CharSequence text2 = obtainStyledAttributes.getText(1);
            this.switcher.setChecked(obtainStyledAttributes.getBoolean(0, false), false);
            setTitle(text);
            setDescription(text2);
            this.titleView.setText(text);
            this.desView.setText(text2);
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height);
        } else {
            layoutParams2.height = layoutParams.height;
        }
        this.view.setLayoutParams(layoutParams2);
    }

    public void setTitle(CharSequence charSequence) {
        this.titleView.setText(charSequence);
    }

    public void setDescription(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.desView.setVisibility(8);
            return;
        }
        this.desView.setVisibility(0);
        this.desView.setText(charSequence);
    }
}
