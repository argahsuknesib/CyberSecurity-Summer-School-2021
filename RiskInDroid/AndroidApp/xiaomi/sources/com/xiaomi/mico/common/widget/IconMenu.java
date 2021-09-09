package com.xiaomi.mico.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class IconMenu extends FrameLayout {
    ImageView mIcon;
    private View mMenu;
    TextView mText;

    public IconMenu(Context context) {
        this(context, null);
    }

    public IconMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.mico.common.widget.IconMenu, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void init(Context context, AttributeSet attributeSet) {
        this.mMenu = LayoutInflater.from(context).inflate((int) R.layout.widget_icon_menu, (ViewGroup) this, false);
        addView(this.mMenu);
        this.mIcon = (ImageView) findViewById(R.id.icon_menu_icon);
        this.mText = (TextView) findViewById(R.id.icon_menu_text);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.mc_icon, R.attr.mc_title});
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            String string = obtainStyledAttributes.getString(1);
            obtainStyledAttributes.recycle();
            if (resourceId != -1) {
                this.mIcon.setImageResource(resourceId);
            }
            this.mText.setText(string);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mMenu.setOnClickListener(onClickListener);
    }

    public void setEnabled(boolean z) {
        this.mMenu.setEnabled(z);
    }

    public void setIcon(int i) {
        this.mIcon.setImageResource(i);
    }

    public void setText(String str) {
        this.mText.setText(str);
    }
}
