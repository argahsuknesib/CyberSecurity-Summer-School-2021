package android.support.design.widget;

import _m_j.ixe;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u001b\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J \u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroid/support/design/widget/EditModeMaskBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "()V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "layoutMask", "anchor", "onDependentViewChanged", "onLayoutChild", "layoutDirection", "", "ViewGroupUtils", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class EditModeMaskBehavior extends CoordinatorLayout.Behavior<View> {
    private final String TAG = "EditModeMaskBehavior";

    public final boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        ixe.O00000o(coordinatorLayout, "parent");
        ixe.O00000o(view, "child");
        return true;
    }

    public EditModeMaskBehavior() {
    }

    public EditModeMaskBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ixe.O00000o(coordinatorLayout, "parent");
        ixe.O00000o(view, "child");
        ixe.O00000o(view2, "dependency");
        return view2 instanceof MyViewPager;
    }

    public final boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ixe.O00000o(coordinatorLayout, "parent");
        ixe.O00000o(view, "child");
        ixe.O00000o(view2, "dependency");
        return layoutMask(coordinatorLayout, view, view2);
    }

    private final boolean layoutMask(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Rect rect = new Rect();
        ViewGroupUtils.INSTANCE.getDescendantRect(coordinatorLayout, view2, rect);
        view.layout(rect.left, rect.top - view.getMeasuredHeight(), rect.right, rect.top);
        return true;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J \u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroid/support/design/widget/EditModeMaskBehavior$ViewGroupUtils;", "", "()V", "matrix", "Landroid/graphics/Matrix;", "rectF", "Landroid/graphics/RectF;", "getDescendantRect", "", "parent", "Landroid/view/ViewGroup;", "descendant", "Landroid/view/View;", "out", "Landroid/graphics/Rect;", "offsetDescendantMatrix", "target", "Landroid/view/ViewParent;", "view", "m", "offsetDescendantRect", "rect", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ViewGroupUtils {
        public static final ViewGroupUtils INSTANCE = new ViewGroupUtils();
        private static final Matrix matrix = new Matrix();
        private static final RectF rectF = new RectF();

        private ViewGroupUtils() {
        }

        private final void offsetDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
            matrix.reset();
            offsetDescendantMatrix(viewGroup, view, matrix);
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
        }

        public final void getDescendantRect(ViewGroup viewGroup, View view, Rect rect) {
            ixe.O00000o(viewGroup, "parent");
            ixe.O00000o(view, "descendant");
            ixe.O00000o(rect, "out");
            rect.set(0, 0, view.getWidth(), view.getHeight());
            offsetDescendantRect(viewGroup, view, rect);
        }

        private final void offsetDescendantMatrix(ViewParent viewParent, View view, Matrix matrix2) {
            ViewParent parent = view.getParent();
            if ((parent instanceof View) && parent != viewParent) {
                View view2 = (View) parent;
                offsetDescendantMatrix(viewParent, view2, matrix2);
                matrix2.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
            }
            matrix2.preTranslate((float) view.getLeft(), (float) view.getTop());
            if (!view.getMatrix().isIdentity()) {
                matrix2.preConcat(view.getMatrix());
            }
        }
    }
}
