package _m_j;

import android.view.View;
import android.view.ViewGroup;
import com.mibigkoo.convenientbanner.view.CBLoopViewPager;
import com.xiaomi.smarthome.R;
import java.util.List;

public final class chk<T> extends jz {

    /* renamed from: O000000o  reason: collision with root package name */
    protected List<T> f13825O000000o;
    protected chl O00000Oo;
    public CBLoopViewPager O00000o;
    public boolean O00000o0 = true;
    public boolean O00000oO = false;
    private final int O00000oo = 300;

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public final int O000000o(int i) {
        int O000000o2 = O000000o();
        if (O000000o2 == 0) {
            return 0;
        }
        return i % O000000o2;
    }

    public final int getCount() {
        return this.O00000o0 ? O000000o() * 300 : O000000o();
    }

    public final int O000000o() {
        List<T> list = this.f13825O000000o;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final float getPageWidth(int i) {
        if (this.O00000oO) {
            return 0.5f;
        }
        return super.getPageWidth(i);
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        int O000000o2 = O000000o(i);
        chm chm = (chm) this.O00000Oo.createHolder();
        View O000000o3 = chm.O000000o(viewGroup.getContext(), viewGroup);
        O000000o3.setTag(R.id.cb_item_tag, chm);
        List<T> list = this.f13825O000000o;
        if (list != null && !list.isEmpty()) {
            chm.O000000o(viewGroup.getContext(), O000000o2, this.f13825O000000o.get(O000000o2));
        }
        viewGroup.addView(O000000o3);
        return O000000o3;
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final void finishUpdate(ViewGroup viewGroup) {
        int currentItem = this.O00000o.getCurrentItem();
        if (currentItem == 0) {
            currentItem = this.O00000o.getFristItem();
        } else if (currentItem == getCount() - 1) {
            currentItem = this.O00000o.getLastItem();
        }
        try {
            this.O00000o.setCurrentItem(currentItem, false);
        } catch (IllegalStateException unused) {
        }
    }

    public chk(chl chl, List<T> list) {
        this.O00000Oo = chl;
        this.f13825O000000o = list;
    }
}
