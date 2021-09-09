package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class TitleDesAndMore extends FrameLayout {
    TextView descriptionView;
    private boolean mIsDefaultValueChanged;
    ImageView more;
    TextView titleView;
    private View view;

    public TitleDesAndMore(Context context) {
        super(context);
    }

    public TitleDesAndMore(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public TitleDesAndMore(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.TitleDesAndMore, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void init(Context context, AttributeSet attributeSet, int i) {
        int i2 = 0;
        this.view = LayoutInflater.from(context).inflate((int) R.layout.widget_title_desc_and_more, (ViewGroup) this, false);
        addView(this.view);
        this.titleView = (TextView) findViewById(R.id.title);
        this.descriptionView = (TextView) findViewById(R.id.description);
        this.more = (ImageView) findViewById(R.id.more);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_description, R.attr.mc_description_color, R.attr.mc_showMore, R.attr.mc_title}, i, 0);
        CharSequence text = obtainStyledAttributes.getText(3);
        CharSequence text2 = obtainStyledAttributes.getText(0);
        boolean z = obtainStyledAttributes.getBoolean(2, true);
        setTitle(text);
        setDescription(text2);
        int color = obtainStyledAttributes.getColor(1, -1);
        if (color != -1) {
            this.descriptionView.setTextColor(color);
        }
        this.mIsDefaultValueChanged = false;
        ImageView imageView = this.more;
        if (!z) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        obtainStyledAttributes.recycle();
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
            this.descriptionView.setVisibility(8);
        } else {
            this.descriptionView.setVisibility(0);
        }
        this.descriptionView.setText(charSequence);
        this.mIsDefaultValueChanged = true;
    }

    public boolean isDefaultValueChanged() {
        return this.mIsDefaultValueChanged;
    }

    public String getDescription() {
        return this.descriptionView.getText().toString();
    }
}
