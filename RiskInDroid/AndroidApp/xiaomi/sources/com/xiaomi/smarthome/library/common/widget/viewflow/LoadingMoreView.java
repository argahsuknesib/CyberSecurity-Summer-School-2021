package com.xiaomi.smarthome.library.common.widget.viewflow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class LoadingMoreView extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private LinearLayout f9334O000000o;
    private TextView O00000Oo;
    private View O00000o;
    private ViewGroup O00000o0;

    public LoadingMoreView(Context context) {
        super(context);
        O00000Oo();
    }

    public LoadingMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000Oo();
    }

    public LoadingMoreView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000Oo();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, com.xiaomi.smarthome.library.common.widget.viewflow.LoadingMoreView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    private void O00000Oo() {
        this.O00000o0 = (ViewGroup) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate((int) R.layout.sm_widget_load_more_layout, (ViewGroup) this, true);
        this.f9334O000000o = (LinearLayout) this.O00000o0.findViewById(R.id.load_more);
        this.O00000Oo = (TextView) this.O00000o0.findViewById(R.id.load_tip);
        this.O00000o = this.O00000o0.findViewById(R.id.click_load_more);
    }

    public final void O000000o() {
        setVisibility(0);
        this.f9334O000000o.setVisibility(0);
        this.O00000Oo.setVisibility(8);
        this.O00000o.setVisibility(8);
        setOnClickListener(null);
    }

    public final void O000000o(View.OnClickListener onClickListener) {
        setVisibility(0);
        this.f9334O000000o.setVisibility(8);
        this.O00000Oo.setVisibility(0);
        this.O00000Oo.setText((int) R.string.loading_more_error);
        this.O00000o.setVisibility(8);
        setOnClickListener(onClickListener);
    }
}
