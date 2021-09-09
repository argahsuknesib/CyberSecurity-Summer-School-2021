package com.xiaomi.mico.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;

public class SettingItem extends FrameLayout {
    View mDivider;
    ImageView mIcon;
    ImageView mIv;
    ImageView mMore;
    TextView mSubText;
    TextView mText;
    TextView tvBeta;

    public SettingItem(Context context) {
        this(context, null);
    }

    public SettingItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate((int) R.layout.view_setting_item, this);
        ButterKnife.bind(this);
        this.mIcon = (ImageView) findViewById(R.id.setting_item_icon);
        this.mText = (TextView) findViewById(R.id.setting_item_text);
        this.mIv = (ImageView) findViewById(R.id.setting_item_iv);
        this.mSubText = (TextView) findViewById(R.id.setting_item_subtext);
        this.mMore = (ImageView) findViewById(R.id.setting_item_more);
        this.mDivider = findViewById(R.id.setting_item_divider);
        this.tvBeta = (TextView) findViewById(R.id.setting_item_tv);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_divider, R.attr.mc_icon, R.attr.mc_iv, R.attr.mc_more_iv, R.attr.mc_show_beta, R.attr.mc_title});
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(5);
            boolean z = obtainStyledAttributes.getBoolean(0, true);
            boolean z2 = obtainStyledAttributes.getBoolean(4, false);
            int resourceId2 = obtainStyledAttributes.getResourceId(3, -1);
            obtainStyledAttributes.recycle();
            if (resourceId != -1) {
                this.mIcon.setImageResource(resourceId);
            }
            if (resourceId2 != -1) {
                this.mMore.setImageResource(resourceId2);
                this.mMore.setVisibility(0);
            }
            this.mText.setText(string);
            int i = 8;
            this.mDivider.setVisibility(z ? 0 : 8);
            TextView textView = this.tvBeta;
            if (z2) {
                i = 0;
            }
            textView.setVisibility(i);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mText.setText(charSequence);
    }

    public void setContent(CharSequence charSequence) {
        this.mSubText.setText(charSequence);
        this.mSubText.setVisibility(0);
    }

    public void setContent(int i) {
        this.mSubText.setText(i);
        this.mSubText.setVisibility(0);
    }

    public void setMoreRes(int i) {
        ImageView imageView = this.mMore;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.mMore.setVisibility(0);
        }
    }

    public void setIConRes(int i) {
        ImageView imageView = this.mIcon;
        if (imageView != null) {
            imageView.setImageResource(i);
            this.mIcon.setVisibility(0);
        }
    }

    public void setDividerVisibility(int i) {
        View findViewById = findViewById(R.id.setting_item_divider);
        if (findViewById != null) {
            findViewById.setVisibility(i);
        }
    }

    public void setDivider(boolean z) {
        View view = this.mDivider;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTvBetaVisibility(int i) {
        TextView textView = this.tvBeta;
        if (textView != null) {
            textView.setVisibility(i);
        }
    }
}
