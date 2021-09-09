package _m_j;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public final class ke extends ViewPager2.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<ViewPager2.O0000O0o> f2132O000000o = new ArrayList(3);

    public final void O000000o(ViewPager2.O0000O0o o0000O0o) {
        this.f2132O000000o.add(o0000O0o);
    }

    public final void onPageScrolled(int i, float f, int i2) {
        try {
            for (ViewPager2.O0000O0o onPageScrolled : this.f2132O000000o) {
                onPageScrolled.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            O000000o(e);
        }
    }

    public final void onPageSelected(int i) {
        try {
            for (ViewPager2.O0000O0o onPageSelected : this.f2132O000000o) {
                onPageSelected.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            O000000o(e);
        }
    }

    public final void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.O0000O0o onPageScrollStateChanged : this.f2132O000000o) {
                onPageScrollStateChanged.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            O000000o(e);
        }
    }

    private static void O000000o(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
