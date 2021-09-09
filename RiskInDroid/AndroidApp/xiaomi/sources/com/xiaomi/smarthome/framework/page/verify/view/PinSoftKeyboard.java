package com.xiaomi.smarthome.framework.page.verify.view;

import _m_j.hzf;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;

public class PinSoftKeyboard extends GridLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f8029O000000o;

    public interface O000000o {
        void onBackClick();

        void onDeleteClick();

        void onNumberClick(int i);
    }

    public PinSoftKeyboard(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.framework.page.verify.view.PinSoftKeyboard, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public PinSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pin_softkeyboard, (ViewGroup) this, true);
        ButterKnife.bind(this);
    }

    @OnClick({4367, 4368, 4369, 4370, 4371, 4372, 4373, 4374, 4375, 4366})
    public void onClickNumber(View view) {
        if (this.f8029O000000o != null) {
            TextView textView = (TextView) view;
            if (!TextUtils.isEmpty(textView.getText())) {
                try {
                    this.f8029O000000o.onNumberClick(Integer.valueOf(textView.getText().toString()).intValue());
                    hzf.O00000oO(view);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @OnClick({4376})
    public void onClickPinBack(View view) {
        O000000o o000000o = this.f8029O000000o;
        if (o000000o != null) {
            o000000o.onBackClick();
        }
    }

    @OnClick({4377})
    public void onClickPinDelete(View view) {
        O000000o o000000o = this.f8029O000000o;
        if (o000000o != null) {
            o000000o.onDeleteClick();
        }
    }

    public void setClickListener(O000000o o000000o) {
        this.f8029O000000o = o000000o;
    }
}
