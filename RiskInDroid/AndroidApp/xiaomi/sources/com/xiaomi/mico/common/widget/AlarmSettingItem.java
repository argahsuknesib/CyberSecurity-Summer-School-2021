package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class AlarmSettingItem extends LinearLayout {
    TextView descriptionView;
    View divider;
    ImageView more;
    SeekBar progressBar;
    TextView titleView;

    public AlarmSettingItem(Context context) {
        super(context);
    }

    public AlarmSettingItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet, 0);
    }

    public AlarmSettingItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.AlarmSettingItem, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void init(Context context, AttributeSet attributeSet, int i) {
        LayoutInflater.from(context).inflate((int) R.layout.widget_alarm_setting_item, (ViewGroup) this, true);
        this.titleView = (TextView) findViewById(R.id.title);
        this.descriptionView = (TextView) findViewById(R.id.description);
        this.more = (ImageView) findViewById(R.id.more);
        this.divider = findViewById(R.id.divider);
        this.progressBar = (SeekBar) findViewById(R.id.progress);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.al_description, R.attr.al_showDivider, R.attr.al_showMore, R.attr.al_showProgress, R.attr.al_title});
            String string = obtainStyledAttributes.getString(4);
            String string2 = obtainStyledAttributes.getString(0);
            boolean z = obtainStyledAttributes.getBoolean(2, false);
            boolean z2 = obtainStyledAttributes.getBoolean(1, false);
            boolean z3 = obtainStyledAttributes.getBoolean(3, false);
            obtainStyledAttributes.recycle();
            if (!TextUtils.isEmpty(string)) {
                setTitle(string);
            }
            if (!TextUtils.isEmpty(string2)) {
                setDescription(string2);
            }
            setMore(z);
            setDivider(z2);
            setProgressBar(z3);
        }
        setGravity(16);
    }

    public void setTitle(String str) {
        this.titleView.setText(str);
    }

    public void setTitle(int i) {
        this.titleView.setText(i);
    }

    public void setDescription(String str) {
        this.descriptionView.setText(str);
    }

    public String getDescription() {
        return this.descriptionView.getText().toString();
    }

    public void setDivider(boolean z) {
        this.divider.setVisibility(z ? 0 : 8);
    }

    public void setMore(boolean z) {
        int i;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.more.getLayoutParams();
        layoutParams.width = z ? -2 : 0;
        Resources resources = this.more.getContext().getResources();
        if (z) {
            i = resources.getDimensionPixelSize(R.dimen.margin_17dp);
        } else {
            i = resources.getDimensionPixelSize(R.dimen.size_12dp);
        }
        layoutParams.rightMargin = i;
        this.more.setLayoutParams(layoutParams);
    }

    public void setProgressBar(boolean z) {
        this.progressBar.setVisibility(z ? 0 : 8);
    }

    public void setProgress(int i) {
        this.progressBar.setProgress(i);
    }

    public int getProgress() {
        return this.progressBar.getProgress();
    }

    public SeekBar getSeekBar() {
        return this.progressBar;
    }
}
