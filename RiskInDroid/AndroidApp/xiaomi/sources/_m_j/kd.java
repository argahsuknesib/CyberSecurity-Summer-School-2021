package _m_j;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

final class kd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f2130O000000o;
    private LinearLayoutManager O00000Oo;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f2130O000000o = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    kd(LinearLayoutManager linearLayoutManager) {
        this.O00000Oo = linearLayoutManager;
    }

    private boolean O00000Oo() {
        int childCount = this.O00000Oo.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (O000000o(this.O00000Oo.getChildAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean O000000o(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (O000000o(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
        if (r4[r0 - 1][1] >= r3) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
        r0 = false;
     */
    public final boolean O000000o() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i;
        int i2;
        int i3;
        int i4;
        int childCount = this.O00000Oo.getChildCount();
        if (childCount != 0) {
            boolean z = this.O00000Oo.getOrientation() == 0;
            int[][] iArr = (int[][]) Array.newInstance(int.class, childCount, 2);
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = this.O00000Oo.getChildAt(i5);
                if (childAt != null) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    } else {
                        marginLayoutParams = f2130O000000o;
                    }
                    int[] iArr2 = iArr[i5];
                    if (z) {
                        i2 = childAt.getLeft();
                        i = marginLayoutParams.leftMargin;
                    } else {
                        i2 = childAt.getTop();
                        i = marginLayoutParams.topMargin;
                    }
                    iArr2[0] = i2 - i;
                    int[] iArr3 = iArr[i5];
                    if (z) {
                        i4 = childAt.getRight();
                        i3 = marginLayoutParams.rightMargin;
                    } else {
                        i4 = childAt.getBottom();
                        i3 = marginLayoutParams.bottomMargin;
                    }
                    iArr3[1] = i4 + i3;
                    i5++;
                } else {
                    throw new IllegalStateException("null view contained in the view hierarchy");
                }
            }
            Arrays.sort(iArr, new Comparator<int[]>() {
                /* class _m_j.kd.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((int[]) obj)[0] - ((int[]) obj2)[0];
                }
            });
            int i6 = 1;
            while (true) {
                if (i6 >= childCount) {
                    int i7 = iArr[0][1] - iArr[0][0];
                    if (iArr[0][0] <= 0) {
                    }
                } else if (iArr[i6 - 1][1] != iArr[i6][0]) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        boolean z2 = true;
        return (!z2 || this.O00000Oo.getChildCount() <= 1) && O00000Oo();
    }
}
