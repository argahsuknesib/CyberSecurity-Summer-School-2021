package _m_j;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import java.util.Arrays;
import java.util.List;

public final class axu extends ayc<RecyclerView.O000OOo0> implements axe<RecyclerView.O000OOo0> {

    /* renamed from: O000000o  reason: collision with root package name */
    public axr f12690O000000o;
    public axt O00000Oo;
    public RecyclerViewExpandableItemManager.O000000o O00000o;
    public RecyclerViewExpandableItemManager.O00000Oo O00000o0;
    private RecyclerViewExpandableItemManager O00000oO;
    private int O00000oo = -1;
    private int O0000Oo = -1;
    private int O0000Oo0 = -1;
    private int O0000OoO = -1;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axt.O000000o(_m_j.axr, boolean):void
     arg types: [_m_j.axr, int]
     candidates:
      _m_j.axt.O000000o(int, int):void
      _m_j.axt.O000000o(int, boolean):void
      _m_j.axt.O000000o(_m_j.axr, boolean):void */
    public axu(RecyclerViewExpandableItemManager recyclerViewExpandableItemManager, RecyclerView.O000000o<RecyclerView.O000OOo0> o000000o, int[] iArr) {
        super(o000000o);
        this.f12690O000000o = (axr) aye.O000000o(o000000o, axr.class);
        if (this.f12690O000000o != null) {
            this.O00000oO = recyclerViewExpandableItemManager;
            this.O00000Oo = new axt();
            this.O00000Oo.O000000o(this.f12690O000000o, false);
            if (iArr != null) {
                this.O00000Oo.O000000o(iArr);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("adapter does not implement RecyclerViewExpandableListManager");
    }

    public final void O000000o() {
        super.O000000o();
        this.f12690O000000o = null;
        this.O00000oO = null;
        this.O00000o0 = null;
        this.O00000o = null;
    }

    public final int getItemCount() {
        return this.O00000Oo.O000000o();
    }

    public final long getItemId(int i) {
        if (this.f12690O000000o == null) {
            return -1;
        }
        long O00000oo2 = this.O00000Oo.O00000oo(i);
        int i2 = (int) (O00000oo2 & 4294967295L);
        int i3 = (int) (O00000oo2 >>> 32);
        if (i3 == -1) {
            return ((this.f12690O000000o.getGroupId(i2) & 2147483647L) << 32) | 4294967295L;
        }
        long groupId = this.f12690O000000o.getGroupId(i2);
        return (this.f12690O000000o.getChildId(i2, i3) & 4294967295L) | ((2147483647L & groupId) << 32);
    }

    public final int getItemViewType(int i) {
        int i2;
        if (this.f12690O000000o == null) {
            return 0;
        }
        long O00000oo2 = this.O00000Oo.O00000oo(i);
        int i3 = (int) (4294967295L & O00000oo2);
        int i4 = (int) (O00000oo2 >>> 32);
        if (i4 == -1) {
            i2 = this.f12690O000000o.getGroupItemViewType(i3);
        } else {
            i2 = this.f12690O000000o.getChildItemViewType(i3, i4);
        }
        if ((i2 & Integer.MIN_VALUE) == 0) {
            return i4 == -1 ? i2 | Integer.MIN_VALUE : i2;
        }
        throw new IllegalStateException("Illegal view type (type = " + Integer.toHexString(i2) + ")");
    }

    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        RecyclerView.O000OOo0 o000OOo0;
        axr axr = this.f12690O000000o;
        if (axr == null) {
            return null;
        }
        int i2 = Integer.MAX_VALUE & i;
        if ((i & Integer.MIN_VALUE) != 0) {
            o000OOo0 = axr.onCreateGroupViewHolder(viewGroup, i2);
        } else {
            o000OOo0 = axr.onCreateChildViewHolder(viewGroup, i2);
        }
        if (o000OOo0 instanceof axs) {
            ((axs) o000OOo0).setExpandStateFlags(-1);
        }
        return o000OOo0;
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List<Object> list) {
        if (this.f12690O000000o != null) {
            long O00000oo2 = this.O00000Oo.O00000oo(i);
            int i2 = (int) (4294967295L & O00000oo2);
            int i3 = (int) (O00000oo2 >>> 32);
            int itemViewType = o000OOo0.getItemViewType() & Integer.MAX_VALUE;
            boolean z = true;
            int i4 = i3 == -1 ? 1 : 2;
            if (this.O00000Oo.O000000o(i2)) {
                i4 |= 4;
            }
            if (o000OOo0 instanceof axs) {
                axs axs = (axs) o000OOo0;
                int expandStateFlags = axs.getExpandStateFlags();
                if (!(expandStateFlags == -1 || ((expandStateFlags ^ i4) & 4) == 0)) {
                    i4 |= 8;
                }
                if (expandStateFlags == -1 || (Integer.MAX_VALUE & (expandStateFlags ^ i4)) != 0) {
                    i4 |= Integer.MIN_VALUE;
                }
                axs.setExpandStateFlags(i4);
            }
            if (o000OOo0 instanceof axf) {
                axf axf = (axf) o000OOo0;
                boolean z2 = (this.O00000oo == -1 || this.O0000Oo0 == -1) ? false : true;
                boolean z3 = (this.O0000Oo == -1 || this.O0000OoO == -1) ? false : true;
                boolean z4 = i2 >= this.O00000oo && i2 <= this.O0000Oo0;
                boolean z5 = i2 != -1 && i3 >= this.O0000Oo && i3 <= this.O0000OoO;
                int dragStateFlags = axf.getDragStateFlags();
                if ((dragStateFlags & 1) == 0 || (dragStateFlags & 4) != 0 || ((z2 && !z4) || (z3 && (!z3 || !z5)))) {
                    z = false;
                }
                if (z) {
                    axf.setDragStateFlags(dragStateFlags | 4 | Integer.MIN_VALUE);
                }
            }
            if (i3 == -1) {
                this.f12690O000000o.onBindGroupViewHolder(o000OOo0, i2, itemViewType);
            } else {
                this.f12690O000000o.onBindChildViewHolder(o000OOo0, i2, i3, itemViewType);
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axt.O000000o(_m_j.axr, boolean):void
     arg types: [_m_j.axr, int]
     candidates:
      _m_j.axt.O000000o(int, int):void
      _m_j.axt.O000000o(int, boolean):void
      _m_j.axt.O000000o(_m_j.axr, boolean):void */
    private void O00000oO() {
        axt axt = this.O00000Oo;
        if (axt != null) {
            int[] iArr = new int[axt.O00000o];
            int i = 0;
            for (int i2 = 0; i2 < axt.O00000o0; i2++) {
                if ((axt.f12689O000000o[i2] & 2147483648L) != 0) {
                    iArr[i] = axt.O00000Oo[i2];
                    i++;
                }
            }
            if (i == axt.O00000o) {
                Arrays.sort(iArr);
                this.O00000Oo.O000000o(this.f12690O000000o, false);
                this.O00000Oo.O000000o(iArr);
                return;
            }
            throw new IllegalStateException("may be a bug  (index = " + i + ", mExpandedGroupCount = " + axt.O00000o + ")");
        }
    }

    public final void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 instanceof axs) {
            ((axs) o000OOo0).setExpandStateFlags(-1);
        }
        super.onViewRecycled(o000OOo0);
    }

    public final void O00000Oo() {
        O00000oO();
        super.O00000Oo();
    }

    public final void O000000o(int i, int i2) {
        super.O000000o(i, i2);
    }

    public final void a_(int i, int i2) {
        O00000oO();
        super.a_(i, i2);
    }

    public final void O00000o0(int i, int i2) {
        if (i2 == 1) {
            long O00000oo2 = this.O00000Oo.O00000oo(i);
            int i3 = (int) (4294967295L & O00000oo2);
            int i4 = (int) (O00000oo2 >>> 32);
            long j = 0;
            int i5 = -1;
            if (i4 == -1) {
                axt axt = this.O00000Oo;
                int i6 = 0;
                while (i6 <= 0) {
                    long j2 = axt.f12689O000000o[i3 + 0];
                    if ((j2 & 2147483648L) != j) {
                        axt.O00000oO -= (int) (j2 & 2147483647L);
                        axt.O00000o--;
                    }
                    i6++;
                    j = 0;
                }
                axt.O00000o0--;
                int i7 = i3;
                while (i7 < axt.O00000o0) {
                    long[] jArr = axt.f12689O000000o;
                    int i8 = i7 + 1;
                    jArr[i7] = jArr[i8];
                    int[] iArr = axt.O00000Oo;
                    iArr[i7] = iArr[i8];
                    i7 = i8;
                }
                if (axt.O00000o0 != 0) {
                    i5 = i3 - 1;
                }
                axt.O00000oo = Math.min(axt.O00000oo, i5);
            } else {
                axt axt2 = this.O00000Oo;
                long j3 = axt2.f12689O000000o[i3];
                int i9 = (int) (j3 & 2147483647L);
                if (i4 < 0 || i4 + 1 > i9) {
                    throw new IllegalStateException("Invalid child position removeChildItems(groupPosition = " + i3 + ", childPosition = " + i4 + ", count = 1)");
                }
                if ((j3 & 2147483648L) != 0) {
                    axt2.O00000oO--;
                }
                axt2.f12689O000000o[i3] = ((long) (i9 - 1)) | (-2147483648L & j3);
                axt2.O00000oo = Math.min(axt2.O00000oo, i3 - 1);
            }
        } else {
            O00000oO();
        }
        super.O00000o0(i, i2);
    }

    public final void O000000o(int i, int i2, int i3) {
        O00000oO();
        super.O000000o(i, i2, i3);
    }

    public final boolean O000000o(RecyclerView.O000OOo0 o000OOo0, int i, int i2, int i3) {
        axr axr = this.f12690O000000o;
        boolean z = false;
        if (!(axr instanceof axq)) {
            return false;
        }
        axq axq = (axq) axr;
        if (((int) (this.O00000Oo.O00000oo(i) >>> 32)) != -1) {
            z = axq.O000000o(o000OOo0, i2, i3);
        }
        this.O00000oo = -1;
        this.O0000Oo0 = -1;
        this.O0000Oo = -1;
        this.O0000OoO = -1;
        return z;
    }

    public final axj O000000o(RecyclerView.O000OOo0 o000OOo0, int i) {
        boolean z;
        axr axr = this.f12690O000000o;
        if (!(axr instanceof axq) || axr.getGroupCount() <= 0) {
            return null;
        }
        axq axq = (axq) this.f12690O000000o;
        long O00000oo2 = this.O00000Oo.O00000oo(i);
        int i2 = (int) (4294967295L & O00000oo2);
        if (((int) (O00000oo2 >>> 32)) == -1) {
            return new axj(0, Math.max(0, (this.O00000Oo.O000000o() - this.O00000Oo.O00000o0(Math.max(0, this.f12690O000000o.getGroupCount() - 1))) - 1));
        }
        axj O000000o2 = axq.O000000o(i2);
        if (O000000o2 == null) {
            return new axj(1, Math.max(1, this.O00000Oo.O000000o() - 1));
        }
        if (!O000000o2.getClass().equals(axv.class) && !O000000o2.getClass().equals(axj.class)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            long O000000o3 = axp.O000000o(O000000o2.f12681O000000o);
            int O000000o4 = this.O00000Oo.O000000o(axp.O000000o(O000000o2.O00000Oo)) + this.O00000Oo.O00000o0(O000000o2.O00000Oo);
            int min = Math.min(this.O00000Oo.O000000o(O000000o3) + 1, O000000o4);
            this.O00000oo = O000000o2.f12681O000000o;
            this.O0000Oo0 = O000000o2.O00000Oo;
            return new axj(min, O000000o4);
        } else if (O000000o2.getClass().equals(axo.class)) {
            int max = Math.max(this.O00000Oo.O00000o0(i2) - 1, 0);
            int min2 = Math.min(O000000o2.f12681O000000o, max);
            int min3 = Math.min(O000000o2.O00000Oo, max);
            long O000000o5 = axp.O000000o(i2, min2);
            long O000000o6 = axp.O000000o(i2, min3);
            int O000000o7 = this.O00000Oo.O000000o(O000000o5);
            int O000000o8 = this.O00000Oo.O000000o(O000000o6);
            this.O0000Oo = min2;
            this.O0000OoO = min3;
            return new axj(O000000o7, O000000o8);
        } else {
            throw new IllegalStateException("Invalid range specified: ".concat(String.valueOf(O000000o2)));
        }
    }

    public final boolean O00000Oo(int i, int i2) {
        axr axr = this.f12690O000000o;
        boolean z = true;
        if (!(axr instanceof axq)) {
            return true;
        }
        if (axr.getGroupCount() <= 0) {
            return false;
        }
        axq axq = (axq) this.f12690O000000o;
        long O00000oo2 = this.O00000Oo.O00000oo(i);
        int i3 = (int) (O00000oo2 & 4294967295L);
        int i4 = (int) (O00000oo2 >>> 32);
        long O00000oo3 = this.O00000Oo.O00000oo(i2);
        int i5 = (int) (4294967295L & O00000oo3);
        int i6 = (int) (O00000oo3 >>> 32);
        boolean z2 = i4 == -1;
        boolean z3 = i6 == -1;
        if (z2) {
            if (i3 != i5 && i < i2) {
                z3 = z3 ? !this.O00000Oo.O000000o(i5) : i6 == this.O00000Oo.O00000o0(i5) - 1;
            }
            if (z3) {
            }
            return false;
        }
        boolean O000000o2 = this.O00000Oo.O000000o(i5);
        if (i >= i2 && z3) {
            if (i5 > 0) {
                i5--;
            } else {
                z = false;
            }
        }
        if (z) {
            return axq.O000000o(i3, i5);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a7  */
    public final void b_(int i, int i2) {
        int i3;
        int i4;
        axr axr = this.f12690O000000o;
        if (axr instanceof axq) {
            this.O00000oo = -1;
            this.O0000Oo0 = -1;
            this.O0000Oo = -1;
            this.O0000OoO = -1;
            if (i != i2) {
                axq axq = (axq) axr;
                long O00000oo2 = this.O00000Oo.O00000oo(i);
                int i5 = (int) (O00000oo2 & 4294967295L);
                int i6 = (int) (O00000oo2 >>> 32);
                long O00000oo3 = this.O00000Oo.O00000oo(i2);
                int i7 = (int) (4294967295L & O00000oo3);
                int i8 = (int) (O00000oo3 >>> 32);
                boolean z = i6 == -1;
                boolean z2 = i8 == -1;
                if (z && z2) {
                    this.O00000Oo.O000000o(i5, i7);
                } else if (z || z2) {
                    if (!z) {
                        if (i2 < i) {
                            if (i7 != 0) {
                                i4 = i7 - 1;
                                i3 = this.O00000Oo.O00000Oo(i4);
                                if (i5 == i4) {
                                    i3 = Math.min(i3, Math.max(0, this.O00000Oo.O00000Oo(i4) - 1));
                                }
                                if (!(i5 == i4 && i6 == i3)) {
                                    if (!this.O00000Oo.O000000o(i7)) {
                                        i2 = -1;
                                    }
                                    axq.O000000o(i5, i6, i4, i3);
                                    this.O00000Oo.O000000o(i5, i6, i4, i3);
                                }
                            }
                        } else if (!this.O00000Oo.O000000o(i7)) {
                            i3 = this.O00000Oo.O00000Oo(i7);
                            i4 = i7;
                            if (i5 == i4) {
                            }
                            if (!this.O00000Oo.O000000o(i7)) {
                            }
                            axq.O000000o(i5, i6, i4, i3);
                            this.O00000Oo.O000000o(i5, i6, i4, i3);
                        }
                        i4 = i7;
                        i3 = 0;
                        if (i5 == i4) {
                        }
                        if (!this.O00000Oo.O000000o(i7)) {
                        }
                        axq.O000000o(i5, i6, i4, i3);
                        this.O00000Oo.O000000o(i5, i6, i4, i3);
                    } else if (i5 != i7) {
                        i2 = this.O00000Oo.O000000o(axp.O000000o(i7));
                        this.O00000Oo.O000000o(i5, i7);
                    }
                    i2 = i;
                } else {
                    if (i5 != i7 && i < i2) {
                        i8++;
                    }
                    i2 = this.O00000Oo.O000000o(axp.O000000o(i5, i8));
                    axq.O000000o(i5, i6, i7, i8);
                    this.O00000Oo.O000000o(i5, i6, i7, i8);
                }
                if (i2 == i) {
                    return;
                }
                if (i2 != -1) {
                    notifyItemMoved(i, i2);
                } else {
                    notifyItemRemoved(i);
                }
            }
        }
    }

    public final boolean O000000o(int i, boolean z) {
        if (this.O00000Oo.O000000o(i) || !this.f12690O000000o.onHookGroupExpand(i, z)) {
            return false;
        }
        if (this.O00000Oo.O00000oO(i)) {
            notifyItemRangeInserted(this.O00000Oo.O000000o(axp.O000000o(i)) + 1, this.O00000Oo.O00000Oo(i));
        }
        notifyItemChanged(this.O00000Oo.O000000o(axp.O000000o(i)));
        return true;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axt.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.axt.O000000o(int, int):void
      _m_j.axt.O000000o(_m_j.axr, boolean):void
      _m_j.axt.O000000o(int, boolean):void */
    public final void O00000Oo(int i, boolean z) {
        axt axt = this.O00000Oo;
        axt.O000000o(axt.O00000o0 + 1, true);
        axr axr = axt.O0000O0o;
        long[] jArr = axt.f12689O000000o;
        int[] iArr = axt.O00000Oo;
        int i2 = i - 1;
        int i3 = i2 + 1;
        for (int i4 = (axt.O00000o0 - 1) + 1; i4 > i3; i4--) {
            int i5 = i4 - 1;
            jArr[i4] = jArr[i5];
            iArr[i4] = iArr[i5];
        }
        int i6 = i + 1;
        int i7 = i;
        int i8 = 0;
        while (i7 < i6) {
            long groupId = axr.getGroupId(i7);
            int childCount = axr.getChildCount(i7);
            long[] jArr2 = jArr;
            jArr2[i7] = ((long) childCount) | (((long) i7) << 32) | 2147483648L;
            iArr[i7] = (int) (4294967295L & groupId);
            i8 += childCount;
            i7++;
            jArr = jArr2;
        }
        axt.O00000o0++;
        axt.O00000o++;
        axt.O00000oO += i8;
        if (axt.O00000o0 == 0) {
            i2 = -1;
        }
        axt.O00000oo = Math.min(axt.O00000oo, i2);
        if (i8 + 1 > 0) {
            notifyItemInserted(this.O00000Oo.O000000o(axp.O000000o(i)));
        }
    }
}
