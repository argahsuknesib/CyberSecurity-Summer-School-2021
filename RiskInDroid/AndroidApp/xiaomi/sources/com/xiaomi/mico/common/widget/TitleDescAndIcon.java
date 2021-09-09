package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class TitleDescAndIcon extends FrameLayout {
    TextView mDescription;
    ImageView mIcon;
    TextView mTitle;
    ImageView more;

    public TitleDescAndIcon(Context context) {
        this(context, null);
    }

    public TitleDescAndIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.TitleDescAndIcon, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate((int) R.layout.widget_title_desc_and_icon, (ViewGroup) this, true);
        this.mIcon = (ImageView) findViewById(R.id.icon);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.mDescription = (TextView) findViewById(R.id.description);
        this.more = (ImageView) findViewById(R.id.more);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_description, R.attr.mc_icon, R.attr.mc_showMore, R.attr.mc_title});
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(3);
            int i = 0;
            String string2 = obtainStyledAttributes.getString(0);
            boolean z = obtainStyledAttributes.getBoolean(2, false);
            obtainStyledAttributes.recycle();
            if (resourceId != -1) {
                setIcon(resourceId);
            }
            setTitle(string);
            setDescription(string2);
            ImageView imageView = this.more;
            if (!z) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public void setIcon(int i) {
        this.mIcon.setImageResource(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle.setText(charSequence);
    }

    public void setDescription(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            this.mDescription.setVisibility(8);
            return;
        }
        this.mDescription.setVisibility(0);
        this.mDescription.setText(charSequence);
    }
}
