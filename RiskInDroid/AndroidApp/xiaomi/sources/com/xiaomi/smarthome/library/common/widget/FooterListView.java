package com.xiaomi.smarthome.library.common.widget;

import _m_j.gri;
import _m_j.gsy;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.xiaomi.smarthome.R;

public class FooterListView extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    public Handler f9185O000000o = new Handler() {
        /* class com.xiaomi.smarthome.library.common.widget.FooterListView.AnonymousClass1 */

        public final void handleMessage(Message message) {
        }
    };
    private LinearLayout O00000Oo;
    private View O00000o;
    private View O00000o0;
    private int O00000oO;

    public FooterListView(Context context) {
        super(context);
        O000000o();
    }

    public FooterListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public FooterListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = (LinearLayout) LayoutInflater.from(getContext()).inflate((int) R.layout.sm_widget_pull_footer, (ViewGroup) null);
        super.addFooterView(this.O00000Oo);
        this.O00000o0 = this.O00000Oo.findViewById(R.id.pull_footer);
        this.O00000oO = gri.O000000o(13.3f);
    }

    public void addFooterView(View view) {
        removeFooterView(this.O00000Oo);
        super.addFooterView(this.O00000Oo);
        super.addFooterView(view);
        O00000Oo();
        this.O00000o = view;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        O00000Oo();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        gsy.O000000o(3, getClass().getSimpleName(), "onLayout");
        super.onLayout(z, i, i2, i3, i4);
    }

    private void O00000Oo() {
        int heightWithoutFooter = getHeightWithoutFooter();
        if (getHeight() - heightWithoutFooter > gri.O000000o(13.3f)) {
            this.O00000oO = getHeight() - heightWithoutFooter;
        } else {
            this.O00000oO = gri.O000000o(13.3f);
        }
        ViewGroup.LayoutParams layoutParams = this.O00000o0.getLayoutParams();
        layoutParams.height = this.O00000oO;
        this.O00000o0.setLayoutParams(layoutParams);
    }

    public int getHeightWithoutFooter() {
        if (getAdapter() == null) {
            return -1;
        }
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (!childAt.equals(this.O00000Oo)) {
                i += childAt.getHeight();
            }
        }
        return i;
    }
}
