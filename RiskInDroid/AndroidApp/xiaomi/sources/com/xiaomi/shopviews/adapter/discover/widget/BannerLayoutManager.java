package com.xiaomi.shopviews.adapter.discover.widget;

import _m_j.gz;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class BannerLayoutManager extends RecyclerView.LayoutManager {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int f3918O000000o;
    protected int O00000Oo;
    protected int O00000o;
    public int O00000o0;
    protected int O00000oO;
    public float O00000oo;
    protected gz O0000O0o;
    public boolean O0000OOo;
    public O000000o O0000Oo;
    public float O0000Oo0;
    public boolean O0000OoO;
    int O0000Ooo;
    private int O0000o;
    private SparseArray<View> O0000o0;
    float O0000o00;
    private boolean O0000o0O;
    private boolean O0000o0o;
    private boolean O0000oO;
    private SavedState O0000oO0;
    private boolean O0000oOO;
    private int O0000oOo;
    private int O0000oo;
    private int O0000oo0;
    private Interpolator O0000ooO;
    private int O0000ooo;
    private View O00oOooO;
    private float O00oOooo;

    public interface O000000o {
    }

    public View onFocusSearchFailed(View view, int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        return null;
    }

    public final float O000000o() {
        float f = this.O00oOooo;
        if (f == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f;
    }

    public final void O000000o(float f) {
        assertNotInLayoutOrScroll(null);
        if (this.O00oOooo != f) {
            this.O00oOooo = f;
        }
    }

    private void O000000o(View view, float f) {
        float abs = Math.abs((f + ((float) this.O00000o)) - (((float) (this.O0000O0o.O00000oO() - this.f3918O000000o)) / 2.0f));
        int i = this.f3918O000000o;
        float f2 = 0.0f;
        if (((float) i) - abs > 0.0f) {
            f2 = ((float) i) - abs;
        }
        float f3 = (((this.O0000o00 - 1.0f) / ((float) this.f3918O000000o)) * f2) + 1.0f;
        view.setScaleX(f3);
        view.setScaleY(f3);
    }

    public BannerLayoutManager(Context context) {
        this(0, (byte) 0);
    }

    public BannerLayoutManager(int i) {
        this(i, (byte) 0);
    }

    private BannerLayoutManager(int i, byte b) {
        this.O0000o0 = new SparseArray<>();
        this.O0000OOo = false;
        this.O0000o0O = false;
        this.O0000o0o = true;
        this.O0000o = -1;
        this.O0000oO0 = null;
        this.O0000OoO = true;
        this.O0000oo = -1;
        this.O0000ooo = Integer.MAX_VALUE;
        this.O0000Ooo = 20;
        this.O0000o00 = 1.2f;
        this.O00oOooo = 1.0f;
        assertNotInLayoutOrScroll(null);
        if (!this.O0000oOO) {
            this.O0000oOO = true;
            requestLayout();
        }
        assertNotInLayoutOrScroll(null);
        if (this.O0000oo != 3) {
            this.O0000oo = 3;
            removeAllViews();
        }
        O000000o(i);
        assertNotInLayoutOrScroll(null);
        if (this.O0000OOo) {
            this.O0000OOo = false;
            removeAllViews();
        }
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.O000O0OO o000o0oo) {
        super.onDetachedFromWindow(recyclerView, o000o0oo);
        if (this.O0000oO) {
            removeAndRecycleAllViews(o000o0oo);
            o000o0oo.O000000o();
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.O0000oO0;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f3919O000000o = this.O0000o;
        savedState2.O00000Oo = this.O00000oo;
        savedState2.O00000o0 = this.O0000o0O;
        return savedState2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.O0000oO0 = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.O00000o0 == 0;
    }

    public boolean canScrollVertically() {
        return this.O00000o0 == 1;
    }

    public final void O000000o(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.O00000o0) {
                this.O00000o0 = i;
                this.O0000O0o = null;
                this.O0000ooo = Integer.MAX_VALUE;
                removeAllViews();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i)));
    }

    public void scrollToPosition(int i) {
        float f;
        float f2;
        if (this.O0000OoO || (i >= 0 && i < getItemCount())) {
            this.O0000o = i;
            if (this.O0000o0O) {
                f = (float) i;
                f2 = -this.O0000Oo0;
            } else {
                f = (float) i;
                f2 = this.O0000Oo0;
            }
            this.O00000oo = f * f2;
            requestLayout();
        }
    }

    public void onLayoutChildren(RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        float f;
        float f2;
        if (o000OO0o.O000000o() == 0) {
            removeAndRecycleAllViews(o000o0oo);
            this.O00000oo = 0.0f;
            return;
        }
        O0000O0o();
        if (this.O00000o0 == 0 && getLayoutDirection() == 1) {
            this.O0000OOo = !this.O0000OOo;
        }
        View O00000Oo2 = o000o0oo.O00000Oo(0);
        measureChildWithMargins(O00000Oo2, 0, 0);
        this.f3918O000000o = this.O0000O0o.O00000oO(O00000Oo2);
        this.O00000Oo = this.O0000O0o.O00000oo(O00000Oo2);
        this.O00000o = (this.O0000O0o.O00000oO() - this.f3918O000000o) / 2;
        if (this.O0000ooo == Integer.MAX_VALUE) {
            this.O00000oO = (O00000oo() - this.O00000Oo) / 2;
        } else {
            this.O00000oO = (O00000oo() - this.O00000Oo) - this.O0000ooo;
        }
        this.O0000Oo0 = (((float) this.f3918O000000o) * (((this.O0000o00 - 1.0f) / 2.0f) + 1.0f)) + ((float) this.O0000Ooo);
        this.O0000oOo = ((int) Math.abs(O0000o00() / this.O0000Oo0)) + 1;
        this.O0000oo0 = ((int) Math.abs(O0000Ooo() / this.O0000Oo0)) + 1;
        SavedState savedState = this.O0000oO0;
        if (savedState != null) {
            this.O0000o0O = savedState.O00000o0;
            this.O0000o = this.O0000oO0.f3919O000000o;
            this.O00000oo = this.O0000oO0.O00000Oo;
        }
        int i = this.O0000o;
        if (i != -1) {
            if (this.O0000o0O) {
                f = (float) i;
                f2 = -this.O0000Oo0;
            } else {
                f = (float) i;
                f2 = this.O0000Oo0;
            }
            this.O00000oo = f * f2;
        }
        detachAndScrapAttachedViews(o000o0oo);
        O000000o(o000o0oo);
    }

    private int O00000oo() {
        int width;
        int paddingRight;
        if (this.O00000o0 == 0) {
            width = getHeight() - getPaddingTop();
            paddingRight = getPaddingBottom();
        } else {
            width = getWidth() - getPaddingLeft();
            paddingRight = getPaddingRight();
        }
        return width - paddingRight;
    }

    public void onLayoutCompleted(RecyclerView.O000OO0o o000OO0o) {
        super.onLayoutCompleted(o000OO0o);
        this.O0000oO0 = null;
        this.O0000o = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r4.O0000o0O != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        if (r4.O0000o0O != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
        if (r4.O0000o0O != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        if (r4.O0000o0O != false) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0041  */
    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
        int O00000o2 = O00000o();
        View findViewByPosition = findViewByPosition(O00000o2);
        if (findViewByPosition == null) {
            return true;
        }
        if (recyclerView.hasFocus()) {
            char c = 0;
            if (this.O00000o0 == 1) {
                if (i != 33) {
                    if (i == 130) {
                    }
                    c = 65535;
                    if (c != 65535) {
                        recyclerView.smoothScrollToPosition(c == 1 ? O00000o2 - 1 : O00000o2 + 1);
                    }
                }
            } else if (i != 17) {
                if (i == 66) {
                }
                c = 65535;
                if (c != 65535) {
                }
            }
            c = 1;
            if (c != 65535) {
            }
        } else {
            findViewByPosition.addFocusables(arrayList, i, i2);
        }
        return true;
    }

    private void O0000O0o() {
        if (this.O0000O0o == null) {
            this.O0000O0o = gz.O000000o(this, this.O00000o0);
        }
    }

    private float O00000Oo(int i) {
        float f;
        float f2;
        if (this.O0000o0O) {
            f = (float) i;
            f2 = -this.O0000Oo0;
        } else {
            f = (float) i;
            f2 = this.O0000Oo0;
        }
        return f * f2;
    }

    public void onAdapterChanged(RecyclerView.O000000o o000000o, RecyclerView.O000000o o000000o2) {
        removeAllViews();
        this.O00000oo = 0.0f;
    }

    public int computeHorizontalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return O0000OOo();
    }

    public int computeVerticalScrollOffset(RecyclerView.O000OO0o o000OO0o) {
        return O0000OOo();
    }

    public int computeHorizontalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return O0000Oo0();
    }

    public int computeVerticalScrollExtent(RecyclerView.O000OO0o o000OO0o) {
        return O0000Oo0();
    }

    public int computeHorizontalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return O0000Oo();
    }

    public int computeVerticalScrollRange(RecyclerView.O000OO0o o000OO0o) {
        return O0000Oo();
    }

    private int O0000OOo() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.O0000o0o) {
            return !this.O0000o0O ? O00000o() : (getItemCount() - O00000o()) - 1;
        }
        float O0000o0O2 = O0000o0O();
        return !this.O0000o0O ? (int) O0000o0O2 : (int) ((((float) (getItemCount() - 1)) * this.O0000Oo0) + O0000o0O2);
    }

    private int O0000Oo0() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.O0000o0o) {
            return 1;
        }
        return (int) this.O0000Oo0;
    }

    private int O0000Oo() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.O0000o0o) {
            return getItemCount();
        }
        return (int) (((float) getItemCount()) * this.O0000Oo0);
    }

    public int scrollHorizontallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.O00000o0 == 1) {
            return 0;
        }
        return O000000o(i, o000o0oo);
    }

    public int scrollVerticallyBy(int i, RecyclerView.O000O0OO o000o0oo, RecyclerView.O000OO0o o000OO0o) {
        if (this.O00000o0 == 0) {
            return 0;
        }
        return O000000o(i, o000o0oo);
    }

    private int O000000o(int i, RecyclerView.O000O0OO o000o0oo) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        O0000O0o();
        float f = (float) i;
        float O000000o2 = f / O000000o();
        if (Math.abs(O000000o2) < 1.0E-8f) {
            return 0;
        }
        float f2 = this.O00000oo + O000000o2;
        if (!this.O0000OoO && f2 < O00000o0()) {
            i = (int) (f - ((f2 - O00000o0()) * O000000o()));
        } else if (!this.O0000OoO && f2 > O00000Oo()) {
            i = (int) ((O00000Oo() - this.O00000oo) * O000000o());
        }
        this.O00000oo += ((float) i) / O000000o();
        O000000o(o000o0oo);
        return i;
    }

    private void O000000o(RecyclerView.O000O0OO o000o0oo) {
        int i;
        int i2;
        int i3;
        int i4;
        detachAndScrapAttachedViews(o000o0oo);
        this.O0000o0.clear();
        int itemCount = getItemCount();
        if (itemCount != 0) {
            int O0000o02 = this.O0000o0O ? -O0000o0() : O0000o0();
            int i5 = O0000o02 - this.O0000oOo;
            int i6 = this.O0000oo0 + O0000o02;
            if (O0000OoO()) {
                if (this.O0000oo % 2 == 0) {
                    i4 = this.O0000oo / 2;
                    i = (O0000o02 - i4) + 1;
                } else {
                    i4 = (this.O0000oo - 1) / 2;
                    i = O0000o02 - i4;
                }
                i2 = i4 + O0000o02 + 1;
            } else {
                i = i5;
                i2 = i6;
            }
            if (!this.O0000OoO) {
                if (i < 0) {
                    if (O0000OoO()) {
                        i2 = this.O0000oo;
                    }
                    i = 0;
                }
                if (i2 > itemCount) {
                    i2 = itemCount;
                }
            }
            float f = Float.MIN_VALUE;
            while (i < i2) {
                if (O0000OoO() || !O00000Oo(O00000Oo(i) - this.O00000oo)) {
                    if (i >= itemCount) {
                        i3 = i % itemCount;
                    } else if (i < 0) {
                        int i7 = (-i) % itemCount;
                        if (i7 == 0) {
                            i7 = itemCount;
                        }
                        i3 = itemCount - i7;
                    } else {
                        i3 = i;
                    }
                    View O00000Oo2 = o000o0oo.O00000Oo(i3);
                    measureChildWithMargins(O00000Oo2, 0, 0);
                    O000000o(O00000Oo2);
                    O00000Oo(O00000Oo2, O00000Oo(i) - this.O00000oo);
                    float f2 = this.O0000oOO ? 0.0f : (float) i3;
                    if (f2 > f) {
                        addView(O00000Oo2);
                    } else {
                        addView(O00000Oo2, 0);
                    }
                    if (i == O0000o02) {
                        this.O00oOooO = O00000Oo2;
                    }
                    this.O0000o0.put(i, O00000Oo2);
                    f = f2;
                }
                i++;
            }
            this.O00oOooO.requestFocus();
        }
    }

    private boolean O0000OoO() {
        return this.O0000oo != -1;
    }

    private boolean O00000Oo(float f) {
        return f > O0000Ooo() || f < O0000o00();
    }

    private static void O000000o(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    public final float O00000Oo() {
        if (!this.O0000o0O) {
            return ((float) (getItemCount() - 1)) * this.O0000Oo0;
        }
        return 0.0f;
    }

    public final float O00000o0() {
        if (!this.O0000o0O) {
            return 0.0f;
        }
        return ((float) (-(getItemCount() - 1))) * this.O0000Oo0;
    }

    private void O00000Oo(View view, float f) {
        int O00000o02 = O00000o0(f);
        int O00000o2 = O00000o(f);
        if (this.O00000o0 == 1) {
            int i = this.O00000oO;
            int i2 = this.O00000o;
            layoutDecorated(view, i + O00000o02, i2 + O00000o2, i + O00000o02 + this.O00000Oo, i2 + O00000o2 + this.f3918O000000o);
        } else {
            int i3 = this.O00000o;
            int i4 = this.O00000oO;
            layoutDecorated(view, i3 + O00000o02, i4 + O00000o2, i3 + O00000o02 + this.f3918O000000o, i4 + O00000o2 + this.O00000Oo);
        }
        O000000o(view, f);
    }

    private int O00000o0(float f) {
        if (this.O00000o0 == 1) {
            return 0;
        }
        return (int) f;
    }

    private int O00000o(float f) {
        if (this.O00000o0 == 1) {
            return (int) f;
        }
        return 0;
    }

    private float O0000Ooo() {
        return (float) (this.O0000O0o.O00000oO() - this.O00000o);
    }

    private float O0000o00() {
        return (float) (((-this.f3918O000000o) - this.O0000O0o.O00000Oo()) - this.O00000o);
    }

    public final int O00000o() {
        int i;
        if (getItemCount() == 0) {
            return 0;
        }
        int O0000o02 = O0000o0();
        if (!this.O0000OoO) {
            return Math.abs(O0000o02);
        }
        if (!this.O0000o0O) {
            if (O0000o02 >= 0) {
                i = O0000o02 % getItemCount();
            } else {
                i = (O0000o02 % getItemCount()) + getItemCount();
            }
        } else if (O0000o02 > 0) {
            i = getItemCount() - (O0000o02 % getItemCount());
        } else {
            i = (-O0000o02) % getItemCount();
        }
        if (i == getItemCount()) {
            return 0;
        }
        return i;
    }

    public View findViewByPosition(int i) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.O0000o0.size(); i2++) {
            int keyAt = this.O0000o0.keyAt(i2);
            if (keyAt < 0) {
                int i3 = keyAt % itemCount;
                if (i3 == 0) {
                    i3 = -itemCount;
                }
                if (i3 + itemCount == i) {
                    return this.O0000o0.valueAt(i2);
                }
            } else if (i == keyAt % itemCount) {
                return this.O0000o0.valueAt(i2);
            }
        }
        return null;
    }

    private int O0000o0() {
        return Math.round(this.O00000oo / this.O0000Oo0);
    }

    private float O0000o0O() {
        if (this.O0000o0O) {
            if (!this.O0000OoO) {
                return this.O00000oo;
            }
            float f = this.O00000oo;
            if (f <= 0.0f) {
                return f % (this.O0000Oo0 * ((float) getItemCount()));
            }
            float f2 = this.O0000Oo0;
            return (((float) getItemCount()) * (-f2)) + (this.O00000oo % (f2 * ((float) getItemCount())));
        } else if (!this.O0000OoO) {
            return this.O00000oo;
        } else {
            float f3 = this.O00000oo;
            if (f3 >= 0.0f) {
                return f3 % (this.O0000Oo0 * ((float) getItemCount()));
            }
            float f4 = this.O0000Oo0;
            return (((float) getItemCount()) * f4) + (this.O00000oo % (f4 * ((float) getItemCount())));
        }
    }

    public final int O00000oO() {
        float O00000o2;
        float O000000o2;
        if (this.O0000OoO) {
            O00000o2 = (((float) O0000o0()) * this.O0000Oo0) - this.O00000oo;
            O000000o2 = O000000o();
        } else {
            O00000o2 = (((float) O00000o()) * (!this.O0000o0O ? this.O0000Oo0 : -this.O0000Oo0)) - this.O00000oo;
            O000000o2 = O000000o();
        }
        return (int) (O00000o2 * O000000o2);
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.xiaomi.shopviews.adapter.discover.widget.BannerLayoutManager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        int f3919O000000o;
        float O00000Oo;
        boolean O00000o0;

        public int describeContents() {
            return 0;
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3919O000000o = parcel.readInt();
            this.O00000Oo = parcel.readFloat();
            this.O00000o0 = parcel.readInt() != 1 ? false : true;
        }

        public SavedState(SavedState savedState) {
            this.f3919O000000o = savedState.f3919O000000o;
            this.O00000Oo = savedState.O00000Oo;
            this.O00000o0 = savedState.O00000o0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3919O000000o);
            parcel.writeFloat(this.O00000Oo);
            parcel.writeInt(this.O00000o0 ? 1 : 0);
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o, int i) {
        float f;
        float f2;
        if (this.O0000OoO) {
            f2 = (float) (O0000o0() + (!this.O0000o0O ? i - O00000o() : O00000o() - i));
            f = this.O0000Oo0;
        } else {
            f2 = (float) i;
            f = !this.O0000o0O ? this.O0000Oo0 : -this.O0000Oo0;
        }
        int O000000o2 = (int) (((f2 * f) - this.O00000oo) * O000000o());
        if (this.O00000o0 == 1) {
            recyclerView.smoothScrollBy(0, O000000o2, this.O0000ooO);
        } else {
            recyclerView.smoothScrollBy(O000000o2, 0, this.O0000ooO);
        }
    }
}
