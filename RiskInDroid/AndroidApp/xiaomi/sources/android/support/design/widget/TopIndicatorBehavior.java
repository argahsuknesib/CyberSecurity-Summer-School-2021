package android.support.design.widget;

import _m_j.hht;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyIndicator;

public class TopIndicatorBehavior extends CoordinatorLayout.Behavior<MyIndicator> {
    private final int defaultViewpagerMargin = this.primaryIndicatorHeight;
    private final int indicatorDeltaHeight = hht.O000000o(CommonApplication.getAppContext(), 5.0d);
    private int mLastOffset = 0;
    private final int primaryIndicatorHeight = hht.O000000o(CommonApplication.getAppContext(), 37.0d);
    private final int viewPagerDeltaMargin = hht.O000000o(CommonApplication.getAppContext(), 7.0d);

    public TopIndicatorBehavior() {
    }

    public TopIndicatorBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, MyIndicator myIndicator, View view) {
        return view instanceof AppBarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, MyIndicator myIndicator, View view) {
        try {
            onOffsetChanged((AppBarLayout) view, myIndicator, coordinatorLayout.findViewById(R.id.viewpager), ((AppBarLayout.Behavior) ((CoordinatorLayout.O00000o) view.getLayoutParams()).f2811O000000o).getTopAndBottomOffset());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void onOffsetChanged(AppBarLayout appBarLayout, MyIndicator myIndicator, View view, int i) {
        if (i != 0 && this.mLastOffset != i) {
            this.mLastOffset = i;
            float abs = Math.abs(((float) i) / ((float) appBarLayout.getTotalScrollRange()));
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) myIndicator.getLayoutParams();
            marginLayoutParams.height = (int) (((float) this.primaryIndicatorHeight) + (((float) this.indicatorDeltaHeight) * abs));
            myIndicator.setLayoutParams(marginLayoutParams);
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams2.topMargin = (int) (((float) this.defaultViewpagerMargin) + (((float) this.viewPagerDeltaMargin) * abs));
            view.setLayoutParams(marginLayoutParams2);
        }
    }
}
