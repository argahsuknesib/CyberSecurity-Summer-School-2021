package _m_j;

import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public final class chn implements ViewPager.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewPager.O0000O0o f13826O000000o;
    private ArrayList<ImageView> O00000Oo;
    private int[] O00000o0;

    public chn(ArrayList<ImageView> arrayList, int[] iArr) {
        this.O00000Oo = arrayList;
        this.O00000o0 = iArr;
    }

    public final void onPageScrollStateChanged(int i) {
        ViewPager.O0000O0o o0000O0o = this.f13826O000000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrollStateChanged(i);
        }
    }

    public final void onPageScrolled(int i, float f, int i2) {
        ViewPager.O0000O0o o0000O0o = this.f13826O000000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
    }

    public final void onPageSelected(int i) {
        for (int i2 = 0; i2 < this.O00000Oo.size(); i2++) {
            this.O00000Oo.get(i).setImageResource(this.O00000o0[1]);
            if (i != i2) {
                this.O00000Oo.get(i2).setImageResource(this.O00000o0[0]);
            }
        }
        ViewPager.O0000O0o o0000O0o = this.f13826O000000o;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i);
        }
    }
}
