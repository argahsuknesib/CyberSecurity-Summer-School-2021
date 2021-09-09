package _m_j;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.viewpager.widget.ViewPager;

public final class dar {
    public static int O000000o(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        if (layoutParams.height > 0) {
            i = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
        return view.getMeasuredHeight();
    }

    public static boolean O00000Oo(View view) {
        return (view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof bz) || (view instanceof WebView) || (view instanceof bo);
    }

    public static boolean O00000o0(View view) {
        return O00000Oo(view) || (view instanceof ViewPager) || (view instanceof bs);
    }
}
