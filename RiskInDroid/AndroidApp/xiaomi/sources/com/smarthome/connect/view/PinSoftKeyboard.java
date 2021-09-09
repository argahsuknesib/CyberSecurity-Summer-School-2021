package com.smarthome.connect.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class PinSoftKeyboard extends GridLayout implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f5652O000000o;

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
     arg types: [?, com.smarthome.connect.view.PinSoftKeyboard, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public PinSoftKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate((int) R.layout.miconnect_pin_softkeyboard, (ViewGroup) this, true);
        findViewById(R.id.xiao_sm_pin_0).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_1).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_2).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_3).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_4).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_5).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_6).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_7).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_8).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_9).setOnClickListener(this);
        findViewById(R.id.xiao_sm_pin_back).setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.connect.view.PinSoftKeyboard.AnonymousClass1 */

            public final void onClick(View view) {
                PinSoftKeyboard pinSoftKeyboard = PinSoftKeyboard.this;
                if (pinSoftKeyboard.f5652O000000o != null) {
                    pinSoftKeyboard.f5652O000000o.onBackClick();
                }
            }
        });
        findViewById(R.id.xiao_sm_pin_delete).setOnClickListener(new View.OnClickListener() {
            /* class com.smarthome.connect.view.PinSoftKeyboard.AnonymousClass2 */

            public final void onClick(View view) {
                PinSoftKeyboard pinSoftKeyboard = PinSoftKeyboard.this;
                if (pinSoftKeyboard.f5652O000000o != null) {
                    pinSoftKeyboard.f5652O000000o.onDeleteClick();
                }
            }
        });
    }

    public void setClickListener(O000000o o000000o) {
        this.f5652O000000o = o000000o;
    }

    public void onClick(View view) {
        if (this.f5652O000000o != null) {
            TextView textView = (TextView) view;
            if (!TextUtils.isEmpty(textView.getText())) {
                try {
                    this.f5652O000000o.onNumberClick(Integer.valueOf(textView.getText().toString()).intValue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
