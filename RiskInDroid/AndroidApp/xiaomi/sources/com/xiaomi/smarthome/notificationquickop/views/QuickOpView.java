package com.xiaomi.smarthome.notificationquickop.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class QuickOpView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private LayoutInflater f10498O000000o = null;
    private View O00000Oo;
    private View O00000o;
    private View O00000o0;

    public QuickOpView(Context context) {
        super(context);
        O000000o();
    }

    public QuickOpView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public QuickOpView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.f10498O000000o = LayoutInflater.from(getContext());
        this.f10498O000000o.inflate((int) R.layout.notification_quick_op_view, this);
        this.O00000Oo = findViewById(R.id.left_btn);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.notificationquickop.views.QuickOpView.AnonymousClass1 */

            public final void onClick(View view) {
            }
        });
        this.O00000o0 = findViewById(R.id.right_btn);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.notificationquickop.views.QuickOpView.AnonymousClass2 */

            public final void onClick(View view) {
            }
        });
        this.O00000o = findViewById(R.id.power_btn);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.notificationquickop.views.QuickOpView.AnonymousClass3 */

            public final void onClick(View view) {
            }
        });
    }
}
