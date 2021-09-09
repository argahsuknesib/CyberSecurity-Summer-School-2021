package _m_j;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

public final class kh extends RecyclerView.O00oOooO {

    /* renamed from: O000000o  reason: collision with root package name */
    public ViewPager2.O0000O0o f2135O000000o;
    public int O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    private final ViewPager2 O00000oO;
    private final RecyclerView O00000oo = this.O00000oO.O00000oO;
    private final LinearLayoutManager O0000O0o = ((LinearLayoutManager) this.O00000oo.getLayoutManager());
    private int O0000OOo;
    private int O0000Oo;
    private O000000o O0000Oo0 = new O000000o();
    private int O0000OoO;
    private boolean O0000Ooo;
    private boolean O0000o00;

    public kh(ViewPager2 viewPager2) {
        this.O00000oO = viewPager2;
        O00000o0();
    }

    private void O00000o0() {
        this.O0000OOo = 0;
        this.O00000Oo = 0;
        this.O0000Oo0.O000000o();
        this.O0000Oo = -1;
        this.O0000OoO = -1;
        this.O0000Ooo = false;
        this.O0000o00 = false;
        this.O00000o = false;
        this.O00000o0 = false;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.O0000OOo == 1 && this.O00000Oo == 1) && i == 1) {
            this.O00000o = false;
            this.O0000OOo = 1;
            int i2 = this.O0000OoO;
            if (i2 != -1) {
                this.O0000Oo = i2;
                this.O0000OoO = -1;
            } else if (this.O0000Oo == -1) {
                this.O0000Oo = this.O0000O0o.findFirstVisibleItemPosition();
            }
            O000000o(1);
        } else if (!O00000oO() || i != 2) {
            if (O00000oO() && i == 0) {
                O00000o();
                if (!this.O0000o00) {
                    if (this.O0000Oo0.f2136O000000o != -1) {
                        O000000o(this.O0000Oo0.f2136O000000o, 0.0f, 0);
                    }
                } else if (this.O0000Oo0.O00000o0 != 0) {
                    z = false;
                } else if (this.O0000Oo != this.O0000Oo0.f2136O000000o) {
                    O00000Oo(this.O0000Oo0.f2136O000000o);
                }
                if (z) {
                    O000000o(0);
                    O00000o0();
                }
            }
            if (this.O0000OOo == 2 && i == 0 && this.O00000o0) {
                O00000o();
                if (this.O0000Oo0.O00000o0 == 0) {
                    if (this.O0000OoO != this.O0000Oo0.f2136O000000o) {
                        O00000Oo(this.O0000Oo0.f2136O000000o == -1 ? 0 : this.O0000Oo0.f2136O000000o);
                    }
                    O000000o(0);
                    O00000o0();
                }
            }
        } else if (this.O0000o00) {
            O000000o(2);
            this.O0000Ooo = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.O00000oO.O00000Oo()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        this.O0000o00 = true;
        O00000o();
        if (this.O0000Ooo) {
            this.O0000Ooo = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                }
                z = false;
                this.O0000OoO = (z || this.O0000Oo0.O00000o0 == 0) ? this.O0000Oo0.f2136O000000o : this.O0000Oo0.f2136O000000o + 1;
                i3 = this.O0000Oo;
                i4 = this.O0000OoO;
                if (i3 != i4) {
                    O00000Oo(i4);
                }
            }
            z = true;
            this.O0000OoO = (z || this.O0000Oo0.O00000o0 == 0) ? this.O0000Oo0.f2136O000000o : this.O0000Oo0.f2136O000000o + 1;
            i3 = this.O0000Oo;
            i4 = this.O0000OoO;
            if (i3 != i4) {
            }
        } else if (this.O0000OOo == 0) {
            int i5 = this.O0000Oo0.f2136O000000o;
            if (i5 == -1) {
                i5 = 0;
            }
            O00000Oo(i5);
        }
        O000000o(this.O0000Oo0.f2136O000000o == -1 ? 0 : this.O0000Oo0.f2136O000000o, this.O0000Oo0.O00000Oo, this.O0000Oo0.O00000o0);
        int i6 = this.O0000Oo0.f2136O000000o;
        int i7 = this.O0000OoO;
        if ((i6 == i7 || i7 == -1) && this.O0000Oo0.O00000o0 == 0 && this.O00000Oo != 1) {
            O000000o(0);
            O00000o0();
        }
    }

    private void O00000o() {
        int i;
        float f;
        O000000o o000000o = this.O0000Oo0;
        o000000o.f2136O000000o = this.O0000O0o.findFirstVisibleItemPosition();
        if (o000000o.f2136O000000o == -1) {
            o000000o.O000000o();
            return;
        }
        View findViewByPosition = this.O0000O0o.findViewByPosition(o000000o.f2136O000000o);
        if (findViewByPosition == null) {
            o000000o.O000000o();
            return;
        }
        int leftDecorationWidth = this.O0000O0o.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.O0000O0o.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.O0000O0o.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.O0000O0o.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + findViewByPosition.getWidth() + leftDecorationWidth;
        if (this.O0000O0o.getOrientation() == 0) {
            i = (findViewByPosition.getLeft() - leftDecorationWidth) - this.O00000oo.getPaddingLeft();
            if (this.O00000oO.O00000Oo()) {
                i = -i;
            }
        } else {
            i = (findViewByPosition.getTop() - topDecorationHeight) - this.O00000oo.getPaddingTop();
            width = height;
        }
        o000000o.O00000o0 = -i;
        if (o000000o.O00000o0 >= 0) {
            if (width == 0) {
                f = 0.0f;
            } else {
                f = ((float) o000000o.O00000o0) / ((float) width);
            }
            o000000o.O00000Oo = f;
        } else if (new kd(this.O0000O0o).O000000o()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(o000000o.O00000o0)));
        }
    }

    public final void O000000o(int i, boolean z) {
        this.O0000OOo = z ? 2 : 3;
        boolean z2 = false;
        this.O00000o = false;
        if (this.O0000OoO != i) {
            z2 = true;
        }
        this.O0000OoO = i;
        O000000o(2);
        if (z2) {
            O00000Oo(i);
        }
    }

    public final boolean O000000o() {
        return this.O00000Oo == 0;
    }

    private boolean O00000oO() {
        int i = this.O0000OOo;
        return i == 1 || i == 4;
    }

    public final double O00000Oo() {
        O00000o();
        double d = (double) this.O0000Oo0.f2136O000000o;
        double d2 = (double) this.O0000Oo0.O00000Oo;
        Double.isNaN(d);
        Double.isNaN(d2);
        return d + d2;
    }

    private void O000000o(int i) {
        if ((this.O0000OOo != 3 || this.O00000Oo != 0) && this.O00000Oo != i) {
            this.O00000Oo = i;
            ViewPager2.O0000O0o o0000O0o = this.f2135O000000o;
            if (o0000O0o != null) {
                o0000O0o.onPageScrollStateChanged(i);
            }
        }
    }

    private void O00000Oo(int i) {
        ViewPager2.O0000O0o o0000O0o = this.f2135O000000o;
        if (o0000O0o != null) {
            o0000O0o.onPageSelected(i);
        }
    }

    private void O000000o(int i, float f, int i2) {
        ViewPager2.O0000O0o o0000O0o = this.f2135O000000o;
        if (o0000O0o != null) {
            o0000O0o.onPageScrolled(i, f, i2);
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f2136O000000o;
        float O00000Oo;
        int O00000o0;

        O000000o() {
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.f2136O000000o = -1;
            this.O00000Oo = 0.0f;
            this.O00000o0 = 0;
        }
    }
}
