package _m_j;

import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.shopviews.adapter.discover.widget.BannerLayoutManager;

public final class evp extends RecyclerView.O0000o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public RecyclerView f15858O000000o;
    public Scroller O00000Oo;
    public final RecyclerView.O00oOooO O00000o = new RecyclerView.O00oOooO() {
        /* class _m_j.evp.AnonymousClass1 */

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f15859O000000o = false;

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            BannerLayoutManager bannerLayoutManager = (BannerLayoutManager) recyclerView.getLayoutManager();
            BannerLayoutManager.O000000o o000000o = bannerLayoutManager.O0000Oo;
            if (i == 0 && this.f15859O000000o) {
                this.f15859O000000o = false;
                if (!evp.this.O00000o0) {
                    evp evp = evp.this;
                    evp.O00000o0 = true;
                    evp.O000000o(bannerLayoutManager, o000000o);
                    return;
                }
                evp.this.O00000o0 = false;
            }
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i != 0 || i2 != 0) {
                this.f15859O000000o = true;
            }
        }
    };
    public boolean O00000o0 = false;

    public final boolean O000000o(int i, int i2) {
        BannerLayoutManager bannerLayoutManager = (BannerLayoutManager) this.f15858O000000o.getLayoutManager();
        if (bannerLayoutManager == null || this.f15858O000000o.getAdapter() == null) {
            return false;
        }
        if (!bannerLayoutManager.O0000OoO && (bannerLayoutManager.O00000oo == bannerLayoutManager.O00000Oo() || bannerLayoutManager.O00000oo == bannerLayoutManager.O00000o0())) {
            return false;
        }
        int minFlingVelocity = this.f15858O000000o.getMinFlingVelocity();
        this.O00000Oo.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (bannerLayoutManager.O00000o0 != 1 || Math.abs(i2) <= minFlingVelocity) {
            if (bannerLayoutManager.O00000o0 == 0 && Math.abs(i) > minFlingVelocity) {
                int O00000o2 = bannerLayoutManager.O00000o();
                int finalX = (int) ((((float) this.O00000Oo.getFinalX()) / bannerLayoutManager.O0000Oo0) / bannerLayoutManager.O000000o());
                this.f15858O000000o.smoothScrollToPosition(bannerLayoutManager.O0000OOo ? O00000o2 - finalX : O00000o2 + finalX);
            }
            return true;
        }
        int O00000o3 = bannerLayoutManager.O00000o();
        int finalY = (int) ((((float) this.O00000Oo.getFinalY()) / bannerLayoutManager.O0000Oo0) / bannerLayoutManager.O000000o());
        this.f15858O000000o.smoothScrollToPosition(bannerLayoutManager.O0000OOo ? O00000o3 - finalY : O00000o3 + finalY);
        return true;
    }

    public final void O000000o(BannerLayoutManager bannerLayoutManager, BannerLayoutManager.O000000o o000000o) {
        int O00000oO = bannerLayoutManager.O00000oO();
        if (O00000oO == 0) {
            this.O00000o0 = false;
        } else if (bannerLayoutManager.O00000o0 == 1) {
            this.f15858O000000o.smoothScrollBy(0, O00000oO);
        } else {
            this.f15858O000000o.smoothScrollBy(O00000oO, 0);
        }
        if (o000000o != null) {
            bannerLayoutManager.O00000o();
        }
    }
}
