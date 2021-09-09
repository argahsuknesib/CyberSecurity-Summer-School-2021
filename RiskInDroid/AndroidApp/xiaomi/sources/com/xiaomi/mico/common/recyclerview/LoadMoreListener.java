package com.xiaomi.mico.common.recyclerview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.xiaomi.mico.common.util.AssertionUtil;

public abstract class LoadMoreListener extends RecyclerView.O00oOooO {
    private boolean canLoadMore;
    private boolean loading;

    /* access modifiers changed from: protected */
    public abstract void onLoadMore();

    public final void setCanLoadMore(boolean z) {
        AssertionUtil.checkUiThread();
        this.canLoadMore = z;
    }

    public final void finishLoading() {
        AssertionUtil.checkUiThread();
        this.loading = false;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        int i4;
        super.onScrolled(recyclerView, i, i2);
        if (this.canLoadMore && i2 > 0) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int itemCount = layoutManager.getItemCount();
            if (layoutManager instanceof GridLayoutManager) {
                i3 = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.f2954O000000o];
                if (iArr.length >= staggeredGridLayoutManager.f2954O000000o) {
                    for (int i5 = 0; i5 < staggeredGridLayoutManager.f2954O000000o; i5++) {
                        StaggeredGridLayoutManager.O00000Oo o00000Oo = staggeredGridLayoutManager.O00000Oo[i5];
                        if (StaggeredGridLayoutManager.this.O00000oo) {
                            i4 = o00000Oo.O000000o(0, o00000Oo.f2960O000000o.size(), false);
                        } else {
                            i4 = o00000Oo.O000000o(o00000Oo.f2960O000000o.size() - 1, -1, false);
                        }
                        iArr[i5] = i4;
                    }
                    i3 = last(iArr);
                } else {
                    throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + staggeredGridLayoutManager.f2954O000000o + ", array size:" + iArr.length);
                }
            } else {
                i3 = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (!this.loading && layoutManager.getChildCount() > 0 && i3 >= itemCount - 1) {
                this.loading = true;
                onLoadMore();
            }
        }
    }

    private int last(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }
}
