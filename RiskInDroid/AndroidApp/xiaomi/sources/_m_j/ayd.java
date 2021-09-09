package _m_j;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public final class ayd {
    public static boolean O00000Oo(int i) {
        return i == 1 || i == 0;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ayd.O000000o(android.view.ViewGroup, float, float):android.view.View
     arg types: [androidx.recyclerview.widget.RecyclerView, float, float]
     candidates:
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView$LayoutManager, android.view.View, android.graphics.Rect):android.graphics.Rect
      _m_j.ayd.O000000o(androidx.recyclerview.widget.LinearLayoutManager, int, int):android.view.View
      _m_j.ayd.O000000o(androidx.recyclerview.widget.RecyclerView, float, float):androidx.recyclerview.widget.RecyclerView$O000OOo0
      _m_j.ayd.O000000o(android.view.ViewGroup, float, float):android.view.View */
    public static RecyclerView.O000OOo0 O000000o(RecyclerView recyclerView, float f, float f2) {
        View O000000o2 = O000000o((ViewGroup) recyclerView, f, f2);
        if (O000000o2 != null) {
            return recyclerView.getChildViewHolder(O000000o2);
        }
        return null;
    }

    public static int O000000o(int i) {
        switch (i) {
            case -1:
                return -1;
            case 0:
            case 2:
            case 4:
                return 0;
            case 1:
            case 3:
            case 5:
                return 1;
            default:
                throw new IllegalArgumentException("Unknown layout type (= " + i + ")");
        }
    }

    public static int O000000o(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getOrientation() == 0 ? 2 : 3;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation() == 0 ? 0 : 1;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).O00000oO == 0 ? 4 : 5;
        }
        return -1;
    }

    private static View O000000o(ViewGroup viewGroup, float f, float f2) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (f >= ((float) childAt.getLeft()) && f <= ((float) childAt.getRight()) && f2 >= ((float) childAt.getTop()) && f2 <= ((float) childAt.getBottom())) {
                return childAt;
            }
        }
        return null;
    }

    public static RecyclerView.O000OOo0 O00000Oo(RecyclerView recyclerView, float f, float f2) {
        View findChildViewUnder = recyclerView.findChildViewUnder(f, f2);
        if (findChildViewUnder != null) {
            return recyclerView.getChildViewHolder(findChildViewUnder);
        }
        return null;
    }

    public static Rect O000000o(View view, Rect rect) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            rect.left = marginLayoutParams.leftMargin;
            rect.right = marginLayoutParams.rightMargin;
            rect.top = marginLayoutParams.topMargin;
            rect.bottom = marginLayoutParams.bottomMargin;
        } else {
            rect.bottom = 0;
            rect.top = 0;
            rect.right = 0;
            rect.left = 0;
        }
        return rect;
    }

    public static Rect O000000o(RecyclerView.LayoutManager layoutManager, View view, Rect rect) {
        rect.left = layoutManager.getLeftDecorationWidth(view);
        rect.right = layoutManager.getRightDecorationWidth(view);
        rect.top = layoutManager.getTopDecorationHeight(view);
        rect.bottom = layoutManager.getBottomDecorationHeight(view);
        return rect;
    }

    public static int O000000o(RecyclerView recyclerView, boolean z) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return -1;
        }
        if (z) {
            return O000000o((LinearLayoutManager) layoutManager);
        }
        return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }

    public static int O000000o(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return O00000Oo((LinearLayoutManager) layoutManager);
        }
        return -1;
    }

    public static int O000000o(RecyclerView.O000OOo0 o000OOo0) {
        int layoutPosition = o000OOo0.getLayoutPosition();
        if (layoutPosition == o000OOo0.getAdapterPosition()) {
            return layoutPosition;
        }
        return -1;
    }

    public static int O00000Oo(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getSpanCount();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).f2954O000000o;
        }
        return 1;
    }

    public static int O00000Oo(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof GridLayoutManager) {
            return ((GridLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).O00000oO;
        }
        return -1;
    }

    private static int O000000o(LinearLayoutManager linearLayoutManager) {
        View O000000o2 = O000000o(linearLayoutManager, 0, linearLayoutManager.getChildCount());
        if (O000000o2 == null) {
            return -1;
        }
        return linearLayoutManager.getPosition(O000000o2);
    }

    private static int O00000Oo(LinearLayoutManager linearLayoutManager) {
        View O000000o2 = O000000o(linearLayoutManager, linearLayoutManager.getChildCount() - 1, -1);
        if (O000000o2 == null) {
            return -1;
        }
        return linearLayoutManager.getPosition(O000000o2);
    }

    private static View O000000o(LinearLayoutManager linearLayoutManager, int i, int i2) {
        int i3 = 1;
        boolean z = linearLayoutManager.getOrientation() == 1;
        int height = z ? linearLayoutManager.getHeight() : linearLayoutManager.getWidth();
        if (i2 <= i) {
            i3 = -1;
        }
        while (i != i2) {
            View childAt = linearLayoutManager.getChildAt(i);
            int top = z ? childAt.getTop() : childAt.getLeft();
            int bottom = z ? childAt.getBottom() : childAt.getRight();
            if (top < height && bottom > 0) {
                return childAt;
            }
            i += i3;
        }
        return null;
    }

    public static int O00000Oo(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 != null) {
            return o000OOo0.getAdapterPosition();
        }
        return -1;
    }

    public static View O000000o(RecyclerView.LayoutManager layoutManager, int i) {
        if (i != -1) {
            return layoutManager.findViewByPosition(i);
        }
        return null;
    }

    public static int O00000o0(RecyclerView.O000OOo0 o000OOo0) {
        View O00000o = O00000o(o000OOo0);
        if (O00000o == null) {
            return -1;
        }
        ViewGroup.LayoutParams layoutParams = O00000o.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return ((StaggeredGridLayoutManager.LayoutParams) layoutParams).O000000o();
        }
        if (layoutParams instanceof GridLayoutManager.LayoutParams) {
            return ((GridLayoutManager.LayoutParams) layoutParams).f2931O000000o;
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return 0;
        }
        return -1;
    }

    public static View O00000o(RecyclerView.O000OOo0 o000OOo0) {
        if (o000OOo0 == null) {
            return null;
        }
        View view = o000OOo0.itemView;
        if (!cb.O000O0oO(view)) {
            return null;
        }
        return view;
    }
}
