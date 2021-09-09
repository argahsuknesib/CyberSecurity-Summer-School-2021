package _m_j;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

public final class O0OOOo0 implements ViewPager.O0000OOo {
    public final void transformPage(View view, float f) {
        view.setScaleX(1.0f - (Math.abs(f) * 0.33f));
        view.setScaleY(1.0f - (Math.abs(f) * 0.33f));
        view.setPivotX(((float) view.getWidth()) / 2.0f);
        view.setPivotY(((float) view.getHeight()) / 2.0f);
    }
}
