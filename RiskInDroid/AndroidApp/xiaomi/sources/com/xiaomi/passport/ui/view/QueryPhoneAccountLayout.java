package com.xiaomi.passport.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class QueryPhoneAccountLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f6335O000000o;
    private Runnable O00000Oo;

    public interface O000000o {
        void O000000o();
    }

    public QueryPhoneAccountLayout(Context context) {
        super(context);
        O000000o(context);
    }

    public QueryPhoneAccountLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context);
    }

    public QueryPhoneAccountLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context);
    }

    private void O000000o(Context context) {
        LayoutInflater.from(context).inflate((int) R.layout.passport_layout_query_phone_account, this);
        final View findViewById = findViewById(R$id.query_skip);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.passport.ui.view.QueryPhoneAccountLayout.AnonymousClass1 */

            public final void onClick(View view) {
                if (QueryPhoneAccountLayout.this.f6335O000000o != null) {
                    QueryPhoneAccountLayout.this.f6335O000000o.O000000o();
                }
            }
        });
        findViewById.setVisibility(4);
        this.O00000Oo = new Runnable() {
            /* class com.xiaomi.passport.ui.view.QueryPhoneAccountLayout.AnonymousClass2 */

            public final void run() {
                findViewById.setVisibility(0);
            }
        };
        postDelayed(this.O00000Oo, 10000);
    }

    public void setOnActionClickListener(O000000o o000000o) {
        this.f6335O000000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.O00000Oo);
    }
}
