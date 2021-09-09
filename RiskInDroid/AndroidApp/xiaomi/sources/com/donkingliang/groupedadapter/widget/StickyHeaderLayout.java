package com.donkingliang.groupedadapter.widget;

import _m_j.we;
import android.content.Context;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.donkingliang.groupedadapter.adapter.GroupedRecyclerViewAdapter;
import java.lang.reflect.Method;

public class StickyHeaderLayout extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f3577O000000o = true;
    private Context O00000Oo;
    private FrameLayout O00000o;
    private RecyclerView O00000o0;
    private final SparseArray<we> O00000oO = new SparseArray<>();
    private final int O00000oo = -101;
    private final int O0000O0o = -102;
    private int O0000OOo = -1;
    private boolean O0000Oo0 = false;

    public StickyHeaderLayout(Context context) {
        super(context);
        this.O00000Oo = context;
    }

    public StickyHeaderLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000Oo = context;
    }

    public StickyHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000Oo = context;
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0 || !(view instanceof RecyclerView)) {
            throw new IllegalArgumentException("StickyHeaderLayout can host only one direct child --> RecyclerView");
        }
        super.addView(view, i, layoutParams);
        this.O00000o0 = (RecyclerView) view;
        this.O00000o0.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class com.donkingliang.groupedadapter.widget.StickyHeaderLayout.AnonymousClass1 */

            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                if (StickyHeaderLayout.this.f3577O000000o) {
                    StickyHeaderLayout.this.O000000o(false);
                }
            }
        });
        this.O00000o = new FrameLayout(this.O00000Oo);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        this.O00000o.setLayoutParams(layoutParams2);
        super.addView(this.O00000o, 1, layoutParams2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d1, code lost:
        if (r0 < 0.0f) goto L_0x00d5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008a  */
    public final void O000000o(boolean z) {
        float f;
        int i;
        we weVar;
        RecyclerView.O000000o adapter = this.O00000o0.getAdapter();
        if (adapter instanceof GroupedRecyclerViewAdapter) {
            GroupedRecyclerViewAdapter groupedRecyclerViewAdapter = (GroupedRecyclerViewAdapter) adapter;
            if (!this.O0000Oo0) {
                this.O0000Oo0 = true;
                groupedRecyclerViewAdapter.registerAdapterDataObserver(new RecyclerView.O00000o0() {
                    /* class com.donkingliang.groupedadapter.widget.StickyHeaderLayout.AnonymousClass2 */

                    public final void onChanged() {
                        StickyHeaderLayout.this.O000000o();
                    }

                    public final void onItemRangeChanged(int i, int i2) {
                        StickyHeaderLayout.this.O000000o();
                    }

                    public final void onItemRangeInserted(int i, int i2) {
                        StickyHeaderLayout.this.O000000o();
                    }

                    public final void onItemRangeRemoved(int i, int i2) {
                        StickyHeaderLayout.this.O000000o();
                    }
                });
            }
            int firstVisibleItem = getFirstVisibleItem();
            int groupPositionForPosition = groupedRecyclerViewAdapter.getGroupPositionForPosition(firstVisibleItem);
            if (z || this.O0000OOo != groupPositionForPosition) {
                this.O0000OOo = groupPositionForPosition;
                int positionForGroupHeader = groupedRecyclerViewAdapter.getPositionForGroupHeader(groupPositionForPosition);
                if (positionForGroupHeader != -1) {
                    int itemViewType = groupedRecyclerViewAdapter.getItemViewType(positionForGroupHeader);
                    boolean z2 = false;
                    if (this.O00000o.getChildCount() > 0) {
                        View childAt = this.O00000o.getChildAt(0);
                        if (((Integer) childAt.getTag(-101)).intValue() == itemViewType) {
                            weVar = (we) childAt.getTag(-102);
                            if (weVar != null) {
                                z2 = true;
                            }
                            if (weVar == null) {
                                weVar = this.O00000oO.get(itemViewType);
                            }
                            if (weVar == null) {
                                weVar = (we) groupedRecyclerViewAdapter.onCreateViewHolder(this.O00000o, itemViewType);
                                weVar.itemView.setTag(-101, Integer.valueOf(itemViewType));
                                weVar.itemView.setTag(-102, weVar);
                            }
                            groupedRecyclerViewAdapter.onBindViewHolder(weVar, positionForGroupHeader);
                            if (!z2) {
                                this.O00000o.addView(weVar.itemView);
                            }
                        } else {
                            O00000Oo();
                        }
                    }
                    weVar = null;
                    if (weVar != null) {
                    }
                    if (weVar == null) {
                    }
                    if (weVar == null) {
                    }
                    groupedRecyclerViewAdapter.onBindViewHolder(weVar, positionForGroupHeader);
                    if (!z2) {
                    }
                } else {
                    O00000Oo();
                }
            }
            if (this.O00000o.getChildCount() > 0 && this.O00000o.getHeight() == 0) {
                this.O00000o.requestLayout();
            }
            FrameLayout frameLayout = this.O00000o;
            int positionForGroupHeader2 = groupedRecyclerViewAdapter.getPositionForGroupHeader(groupPositionForPosition + 1);
            if (positionForGroupHeader2 != -1 && this.O00000o0.getChildCount() > (i = positionForGroupHeader2 - firstVisibleItem)) {
                f = this.O00000o0.getChildAt(i).getY() - ((float) this.O00000o.getHeight());
            }
            f = 0.0f;
            frameLayout.setTranslationY(f);
        }
    }

    public final void O000000o() {
        postDelayed(new Runnable() {
            /* class com.donkingliang.groupedadapter.widget.StickyHeaderLayout.AnonymousClass3 */

            public final void run() {
                StickyHeaderLayout.this.O000000o(true);
            }
        }, 100);
    }

    private void O00000Oo() {
        if (this.O00000o.getChildCount() > 0) {
            View childAt = this.O00000o.getChildAt(0);
            this.O00000oO.put(((Integer) childAt.getTag(-101)).intValue(), (we) childAt.getTag(-102));
            this.O00000o.removeAllViews();
        }
    }

    private int getFirstVisibleItem() {
        int i;
        RecyclerView.LayoutManager layoutManager = this.O00000o0.getLayoutManager();
        if (layoutManager == null) {
            return -1;
        }
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return -1;
        }
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
        int[] iArr = new int[staggeredGridLayoutManager.f2954O000000o];
        if (iArr.length >= staggeredGridLayoutManager.f2954O000000o) {
            for (int i2 = 0; i2 < staggeredGridLayoutManager.f2954O000000o; i2++) {
                StaggeredGridLayoutManager.O00000Oo o00000Oo = staggeredGridLayoutManager.O00000Oo[i2];
                if (StaggeredGridLayoutManager.this.O00000oo) {
                    i = o00000Oo.O000000o(o00000Oo.f2960O000000o.size() - 1, -1, false);
                } else {
                    i = o00000Oo.O000000o(0, o00000Oo.f2960O000000o.size(), false);
                }
                iArr[i2] = i;
            }
            return O000000o(iArr);
        }
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + staggeredGridLayoutManager.f2954O000000o + ", array size:" + iArr.length);
    }

    private static int O000000o(int[] iArr) {
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public void setSticky(boolean z) {
        if (this.f3577O000000o != z) {
            this.f3577O000000o = z;
            FrameLayout frameLayout = this.O00000o;
            if (frameLayout == null) {
                return;
            }
            if (this.f3577O000000o) {
                frameLayout.setVisibility(0);
                O000000o(false);
                return;
            }
            O00000Oo();
            this.O00000o.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollOffset() {
        if (this.O00000o0 != null) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollOffset", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(this.O00000o0, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.computeVerticalScrollOffset();
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollRange() {
        if (this.O00000o0 != null) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollRange", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(this.O00000o0, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.computeVerticalScrollRange();
    }

    /* access modifiers changed from: protected */
    public int computeVerticalScrollExtent() {
        if (this.O00000o0 != null) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeVerticalScrollExtent", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(this.O00000o0, new Object[0])).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.computeVerticalScrollExtent();
    }

    public void scrollBy(int i, int i2) {
        RecyclerView recyclerView = this.O00000o0;
        if (recyclerView != null) {
            recyclerView.scrollBy(i, i2);
        } else {
            super.scrollBy(i, i2);
        }
    }

    public void scrollTo(int i, int i2) {
        RecyclerView recyclerView = this.O00000o0;
        if (recyclerView != null) {
            recyclerView.scrollTo(i, i2);
        } else {
            super.scrollTo(i, i2);
        }
    }
}
