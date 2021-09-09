package _m_j;

import androidx.viewpager.widget.ViewPager;
import com.hannto.print.pickimage.activity.PickPhotoActivity;
import com.xiaomi.smarthome.R;

public final class O00O0Oo0 implements ViewPager.O0000O0o {

    /* renamed from: O000000o  reason: collision with root package name */
    public final /* synthetic */ PickPhotoActivity f6630O000000o;

    public O00O0Oo0(PickPhotoActivity pickPhotoActivity) {
        this.f6630O000000o = pickPhotoActivity;
    }

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    public final void onPageSelected(int i) {
        if (i == 0) {
            this.f6630O000000o.f.check(R.id.photo);
        } else if (i == 1) {
            this.f6630O000000o.f.check(R.id.album);
        }
    }
}
