package com.xiaomi.shopviews.widget.homelabel;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class HomeLabelView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f3953O000000o = ((TextView) findViewById(R.id.label_content));
    private TextView O00000Oo = ((TextView) findViewById(R.id.label_title));

    public HomeLabelView(Context context) {
        super(context);
        LayoutInflater.from(getContext()).inflate((int) R.layout.listitem_label, this);
    }
}
