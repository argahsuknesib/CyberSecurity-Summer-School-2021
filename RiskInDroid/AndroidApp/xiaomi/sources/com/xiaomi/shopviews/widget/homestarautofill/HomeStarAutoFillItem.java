package com.xiaomi.shopviews.widget.homestarautofill;

import _m_j.ewd;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class HomeStarAutoFillItem extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public ewd f3989O000000o;

    public HomeStarAutoFillItem(Context context) {
        super(context);
    }

    public HomeStarAutoFillItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HomeStarAutoFillItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (childAt instanceof ImageView)) {
                ((ImageView) childAt).setImageBitmap(null);
            }
        }
    }

    public void setHomeSectionClickListener(ewd ewd) {
        this.f3989O000000o = ewd;
    }
}
