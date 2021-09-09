package com.xiaomi.youpin.login.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LoginCommonTitleBar extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f12109O000000o;
    private ImageView O00000Oo;
    private TextView O00000o;
    private TextView O00000o0;

    public LoginCommonTitleBar(Context context) {
        this(context, null);
    }

    public LoginCommonTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoginCommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(attributeSet);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.youpin.login.view.LoginCommonTitleBar, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O000000o(AttributeSet attributeSet) {
        LayoutInflater.from(getContext()).inflate((int) R.layout.mj_login_view_common_titlebar, (ViewGroup) this, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, (int) ((getContext().getResources().getDisplayMetrics().density * 45.0f) + 0.5f)));
        this.f12109O000000o = (ImageView) findViewById(R.id.title_bar_back);
        this.O00000Oo = (ImageView) findViewById(R.id.title_bar_close);
        this.O00000o0 = (TextView) findViewById(R.id.title_bar_center_text);
        this.O00000o = (TextView) findViewById(R.id.title_bar_right_button);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.centerText, R.attr.rightText, R.attr.showStyle2}, 0, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == 0) {
                    setCenterText(obtainStyledAttributes.getString(0));
                } else if (index == 1) {
                    String string = obtainStyledAttributes.getString(1);
                    if (TextUtils.isEmpty(string)) {
                        setRightButtonVisible(4);
                    } else {
                        setRightButtonVisible(0);
                        setRightButtonText(string);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.O00000Oo.setVisibility(0);
        this.O00000Oo.setOnClickListener(onClickListener);
    }

    public void setOnBackClickListener(View.OnClickListener onClickListener) {
        this.f12109O000000o.setOnClickListener(onClickListener);
    }

    public void setCenterText(String str) {
        this.O00000o0.setText(str);
    }

    public void setCenterText(int i) {
        this.O00000o0.setText(i);
    }

    public void setRightButtonVisible(int i) {
        this.O00000o.setVisibility(i);
    }

    public void setRightButtonText(String str) {
        this.O00000o.setText(str);
    }

    public void setRightButtonText(int i) {
        this.O00000o.setText(i);
    }

    public void setOnRightButtonClickListener(View.OnClickListener onClickListener) {
        this.O00000o.setOnClickListener(onClickListener);
    }
}
