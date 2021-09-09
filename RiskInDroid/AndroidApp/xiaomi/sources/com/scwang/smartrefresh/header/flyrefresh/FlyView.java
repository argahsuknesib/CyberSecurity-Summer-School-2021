package com.scwang.smartrefresh.header.flyrefresh;

import _m_j.dao;
import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.header.internal.pathview.PathsView;

public class FlyView extends PathsView {
    public FlyView(Context context) {
        this(context, null);
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.O000000o(-1);
        if (!this.f5549O000000o.O000000o("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z")) {
            this.f5549O000000o.O000000o(2, 3, 20, 18);
        }
        int O000000o2 = dao.O000000o(25.0f);
        this.f5549O000000o.setBounds(0, 0, O000000o2, O000000o2);
    }
}
