package _m_j;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

public final class kg extends ViewPager2.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewPager2.O0000Oo0 f2134O000000o;
    private final LinearLayoutManager O00000Oo;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageSelected(int i) {
    }

    public kg(LinearLayoutManager linearLayoutManager) {
        this.O00000Oo = linearLayoutManager;
    }

    public final void onPageScrolled(int i, float f, int i2) {
        if (this.f2134O000000o != null) {
            int i3 = 0;
            while (i3 < this.O00000Oo.getChildCount()) {
                View childAt = this.O00000Oo.getChildAt(i3);
                if (childAt != null) {
                    this.O00000Oo.getPosition(childAt);
                    i3++;
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.O00000Oo.getChildCount())));
                }
            }
        }
    }
}
