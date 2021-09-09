package com.h6ah4i.android.widget.advrecyclerview.expandable;

import _m_j.axp;
import _m_j.axs;
import _m_j.axt;
import _m_j.axu;
import _m_j.ayd;
import _m_j.cb;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

public final class RecyclerViewExpandableItemManager {

    /* renamed from: O000000o  reason: collision with root package name */
    public SavedState f4329O000000o;
    public RecyclerView O00000Oo;
    public RecyclerView.O0000o O00000o = new RecyclerView.O0000o() {
        /* class com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.AnonymousClass1 */

        public final void O000000o(boolean z) {
        }

        public final void O00000Oo(RecyclerView recyclerView, MotionEvent motionEvent) {
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.axu.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          _m_j.axu.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):_m_j.axj
          _m_j.axu.O000000o(int, int):void
          _m_j.ayc.O000000o(int, int):void
          _m_j.axe.O000000o(androidx.recyclerview.widget.RecyclerView$O000OOo0, int):_m_j.axj
          _m_j.axu.O000000o(int, boolean):boolean */
        public final boolean O000000o(RecyclerView recyclerView, MotionEvent motionEvent) {
            RecyclerView.O000OOo0 O00000Oo;
            int O000000o2;
            RecyclerView recyclerView2 = recyclerView;
            RecyclerViewExpandableItemManager recyclerViewExpandableItemManager = RecyclerViewExpandableItemManager.this;
            if (recyclerViewExpandableItemManager.O00000o0 != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 0) {
                    RecyclerView.O000OOo0 O00000Oo2 = ayd.O00000Oo(recyclerView2, motionEvent.getX(), motionEvent.getY());
                    recyclerViewExpandableItemManager.O0000Oo0 = (int) (motionEvent.getX() + 0.5f);
                    recyclerViewExpandableItemManager.O0000Oo = (int) (motionEvent.getY() + 0.5f);
                    if (O00000Oo2 instanceof axs) {
                        recyclerViewExpandableItemManager.O0000O0o = O00000Oo2.getItemId();
                    } else {
                        recyclerViewExpandableItemManager.O0000O0o = -1;
                    }
                } else if (actionMasked == 1 || actionMasked == 3) {
                    long j = recyclerViewExpandableItemManager.O0000O0o;
                    int i = recyclerViewExpandableItemManager.O0000Oo0;
                    int i2 = recyclerViewExpandableItemManager.O0000Oo;
                    recyclerViewExpandableItemManager.O0000O0o = -1;
                    recyclerViewExpandableItemManager.O0000Oo0 = 0;
                    recyclerViewExpandableItemManager.O0000Oo = 0;
                    if (j != -1 && motionEvent.getActionMasked() == 1) {
                        int x = (int) (motionEvent.getX() + 0.5f);
                        int y = (int) (motionEvent.getY() + 0.5f);
                        int i3 = y - i2;
                        if (Math.abs(x - i) < recyclerViewExpandableItemManager.O0000OOo && Math.abs(i3) < recyclerViewExpandableItemManager.O0000OOo && (O00000Oo = ayd.O00000Oo(recyclerView2, motionEvent.getX(), motionEvent.getY())) != null && O00000Oo.getItemId() == j && (O000000o2 = ayd.O000000o(O00000Oo)) != -1) {
                            View view = O00000Oo.itemView;
                            int O0000o0 = (int) (cb.O0000o0(view) + 0.5f);
                            int left = x - (view.getLeft() + ((int) (cb.O0000o00(view) + 0.5f)));
                            int top = y - (view.getTop() + O0000o0);
                            axu axu = recyclerViewExpandableItemManager.O00000o0;
                            if (axu.f12690O000000o != null) {
                                long O00000oo = axu.O00000Oo.O00000oo(O000000o2);
                                int i4 = (int) (4294967295L & O00000oo);
                                if (((int) (O00000oo >>> 32)) == -1) {
                                    boolean z = !axu.O00000Oo.O000000o(i4);
                                    if (axu.f12690O000000o.onCheckCanExpandOrCollapseGroup(O00000Oo, i4, left, top, z)) {
                                        if (z) {
                                            axu.O000000o(i4, true);
                                        } else if (axu.O00000Oo.O000000o(i4) && axu.f12690O000000o.onHookGroupCollapse(i4, true)) {
                                            if (axu.O00000Oo.O00000o(i4)) {
                                                axu.notifyItemRangeRemoved(axu.O00000Oo.O000000o(axp.O000000o(i4)) + 1, axu.O00000Oo.O00000Oo(i4));
                                            }
                                            axu.notifyItemChanged(axu.O00000Oo.O000000o(axp.O000000o(i4)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    };
    public axu O00000o0;
    public O00000Oo O00000oO;
    public O000000o O00000oo;
    long O0000O0o = -1;
    int O0000OOo;
    int O0000Oo;
    int O0000Oo0;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public final RecyclerView.O000000o O000000o(RecyclerView.O000000o o000000o) {
        if (!o000000o.hasStableIds()) {
            throw new IllegalArgumentException("The passed adapter does not support stable IDs");
        } else if (this.O00000o0 == null) {
            SavedState savedState = this.f4329O000000o;
            int[] iArr = savedState != null ? savedState.f4331O000000o : null;
            this.f4329O000000o = null;
            this.O00000o0 = new axu(this, o000000o, iArr);
            axu axu = this.O00000o0;
            axu.O00000o0 = this.O00000oO;
            this.O00000oO = null;
            axu.O00000o = this.O00000oo;
            this.O00000oo = null;
            return axu;
        } else {
            throw new IllegalStateException("already have a wrapped adapter");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axt.O000000o(_m_j.axr, boolean):void
     arg types: [_m_j.axr, int]
     candidates:
      _m_j.axt.O000000o(int, int):void
      _m_j.axt.O000000o(int, boolean):void
      _m_j.axt.O000000o(_m_j.axr, boolean):void */
    public final void O000000o() {
        axu axu = this.O00000o0;
        if (axu != null && !axu.O00000Oo.O00000Oo()) {
            axt axt = axu.O00000Oo;
            if (!(!axt.O00000Oo() && axt.O00000o == axt.O00000o0)) {
                axu.O00000Oo.O000000o(axu.f12690O000000o, true);
                axu.notifyDataSetChanged();
            }
        }
    }

    public final boolean O000000o(int i) {
        axu axu = this.O00000o0;
        return axu != null && axu.O000000o(i, false);
    }

    public final boolean O00000Oo(int i) {
        axu axu = this.O00000o0;
        return axu != null && axu.O00000Oo.O000000o(i);
    }

    public final void O000000o(O00000Oo o00000Oo) {
        axu axu = this.O00000o0;
        if (axu != null) {
            axu.O00000o0 = o00000Oo;
        } else {
            this.O00000oO = o00000Oo;
        }
    }

    public final void O000000o(O000000o o000000o) {
        axu axu = this.O00000o0;
        if (axu != null) {
            axu.O00000o = o000000o;
        } else {
            this.O00000oo = o000000o;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager.SavedState.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        final int[] f4331O000000o;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeIntArray(this.f4331O000000o);
        }

        SavedState(Parcel parcel) {
            this.f4331O000000o = parcel.createIntArray();
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        if (this.O00000o == null) {
            throw new IllegalStateException("Accessing released object");
        } else if (this.O00000Oo == null) {
            this.O00000Oo = recyclerView;
            this.O00000Oo.addOnItemTouchListener(this.O00000o);
            this.O0000OOo = ViewConfiguration.get(this.O00000Oo.getContext()).getScaledTouchSlop();
        } else {
            throw new IllegalStateException("RecyclerView instance has already been set");
        }
    }
}
