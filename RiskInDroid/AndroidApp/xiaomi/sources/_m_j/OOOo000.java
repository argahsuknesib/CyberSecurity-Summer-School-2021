package _m_j;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Field;

public class OOOo000 extends ListView {

    /* renamed from: O000000o  reason: collision with root package name */
    O00000Oo f12335O000000o;
    private final Rect O00000Oo = new Rect();
    private int O00000o = 0;
    private int O00000o0 = 0;
    private int O00000oO = 0;
    private int O00000oo = 0;
    private int O0000O0o;
    private Field O0000OOo;
    private boolean O0000Oo;
    private O000000o O0000Oo0;
    private boolean O0000OoO;
    private boolean O0000Ooo;
    private cv O0000o0;
    private ce O0000o00;

    public OOOo000(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.O0000OoO = z;
        setCacheColorHint(0);
        try {
            this.O0000OOo = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.O0000OOo.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public boolean isInTouchMode() {
        return (this.O0000OoO && this.O0000Oo) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.O0000OoO || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.O0000OoO || super.isFocused();
    }

    public boolean hasFocus() {
        return this.O0000OoO || super.hasFocus();
    }

    public void setSelector(Drawable drawable) {
        this.O0000Oo0 = drawable != null ? new O000000o(drawable) : null;
        super.setSelector(this.O0000Oo0);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.O00000o0 = rect.left;
        this.O00000o = rect.top;
        this.O00000oO = rect.right;
        this.O00000oo = rect.bottom;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f12335O000000o == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            O000000o();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.O0000O0o = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        O00000Oo o00000Oo = this.f12335O000000o;
        if (o00000Oo != null) {
            OOOo000.this.f12335O000000o = null;
            OOOo000.this.removeCallbacks(o00000Oo);
        }
        return super.onTouchEvent(motionEvent);
    }

    public int O000000o(int i, int i2, int i3, int i4, int i5) {
        int i6;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i7 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i8 = i7;
        View view = null;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < count) {
            int itemViewType = adapter.getItemViewType(i9);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = adapter.getView(i9, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            if (layoutParams.height > 0) {
                i6 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
            } else {
                i6 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, i6);
            view.forceLayout();
            if (i9 > 0) {
                i8 += dividerHeight;
            }
            i8 += view.getMeasuredHeight();
            if (i8 >= i4) {
                return (i5 < 0 || i9 <= i5 || i11 <= 0 || i8 == i4) ? i4 : i11;
            }
            if (i5 >= 0 && i9 >= i5) {
                i11 = i8;
            }
            i9++;
        }
        return i8;
    }

    private void setSelectorEnabled(boolean z) {
        O000000o o000000o = this.O0000Oo0;
        if (o000000o != null) {
            o000000o.f12336O000000o = z;
        }
    }

    static class O000000o extends OO000o {

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f12336O000000o = true;

        O000000o(Drawable drawable) {
            super(drawable);
        }

        public final boolean setState(int[] iArr) {
            if (this.f12336O000000o) {
                return super.setState(iArr);
            }
            return false;
        }

        public final void draw(Canvas canvas) {
            if (this.f12336O000000o) {
                super.draw(canvas);
            }
        }

        public final void setHotspot(float f, float f2) {
            if (this.f12336O000000o) {
                super.setHotspot(f, f2);
            }
        }

        public final void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f12336O000000o) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public final boolean setVisible(boolean z, boolean z2) {
            if (this.f12336O000000o) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f12335O000000o == null) {
            this.f12335O000000o = new O00000Oo();
            O00000Oo o00000Oo = this.f12335O000000o;
            OOOo000.this.post(o00000Oo);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                O000000o();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f12335O000000o = null;
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r3 != 3) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x016e  */
    public boolean O000000o(MotionEvent motionEvent, int i) {
        boolean z;
        View childAt;
        ce ceVar;
        int findPointerIndex;
        View childAt2;
        boolean z2;
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = true;
        if (actionMasked == 1) {
            z2 = false;
            findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex >= 0) {
            }
            z = false;
            z3 = false;
            this.O0000Ooo = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(this.O0000O0o - getFirstVisiblePosition());
            if (childAt != null) {
            }
            ceVar = this.O0000o00;
            if (ceVar != null) {
            }
            if (!z) {
            }
            return z;
        } else if (actionMasked == 2) {
            z2 = true;
            findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex >= 0) {
                int x = (int) motionEvent2.getX(findPointerIndex);
                int y = (int) motionEvent2.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, y);
                if (pointToPosition != -1) {
                    View childAt3 = getChildAt(pointToPosition - getFirstVisiblePosition());
                    float f = (float) x;
                    float f2 = (float) y;
                    this.O0000Ooo = true;
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawableHotspotChanged(f, f2);
                    }
                    if (!isPressed()) {
                        setPressed(true);
                    }
                    layoutChildren();
                    int i2 = this.O0000O0o;
                    if (!(i2 == -1 || (childAt2 = getChildAt(i2 - getFirstVisiblePosition())) == null || childAt2 == childAt3 || !childAt2.isPressed())) {
                        childAt2.setPressed(false);
                    }
                    this.O0000O0o = pointToPosition;
                    float left = f - ((float) childAt3.getLeft());
                    float top = f2 - ((float) childAt3.getTop());
                    if (Build.VERSION.SDK_INT >= 21) {
                        childAt3.drawableHotspotChanged(left, top);
                    }
                    if (!childAt3.isPressed()) {
                        childAt3.setPressed(true);
                    }
                    Drawable selector = getSelector();
                    boolean z4 = (selector == null || pointToPosition == -1) ? false : true;
                    if (z4) {
                        selector.setVisible(false, false);
                    }
                    Rect rect = this.O00000Oo;
                    rect.set(childAt3.getLeft(), childAt3.getTop(), childAt3.getRight(), childAt3.getBottom());
                    rect.left -= this.O00000o0;
                    rect.top -= this.O00000o;
                    rect.right += this.O00000oO;
                    rect.bottom += this.O00000oo;
                    try {
                        boolean z5 = this.O0000OOo.getBoolean(this);
                        if (childAt3.isEnabled() != z5) {
                            this.O0000OOo.set(this, Boolean.valueOf(!z5));
                            if (pointToPosition != -1) {
                                refreshDrawableState();
                            }
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (z4) {
                        Rect rect2 = this.O00000Oo;
                        float exactCenterX = rect2.exactCenterX();
                        float exactCenterY = rect2.exactCenterY();
                        selector.setVisible(getVisibility() == 0, false);
                        ab.O000000o(selector, exactCenterX, exactCenterY);
                    }
                    Drawable selector2 = getSelector();
                    if (!(selector2 == null || pointToPosition == -1)) {
                        ab.O000000o(selector2, f, f2);
                    }
                    setSelectorEnabled(false);
                    refreshDrawableState();
                    if (actionMasked == 1) {
                        performItemClick(childAt3, pointToPosition, getItemIdAtPosition(pointToPosition));
                    }
                }
                if (!z || z3) {
                    this.O0000Ooo = false;
                    setPressed(false);
                    drawableStateChanged();
                    childAt = getChildAt(this.O0000O0o - getFirstVisiblePosition());
                    if (childAt != null) {
                        childAt.setPressed(false);
                    }
                    ceVar = this.O0000o00;
                    if (ceVar != null) {
                        ceVar.O00000Oo();
                        this.O0000o00 = null;
                    }
                }
                if (!z) {
                    if (this.O0000o0 == null) {
                        this.O0000o0 = new cv(this);
                    }
                    this.O0000o0.O000000o(true);
                    this.O0000o0.onTouch(this, motionEvent2);
                } else {
                    cv cvVar = this.O0000o0;
                    if (cvVar != null) {
                        cvVar.O000000o(false);
                    }
                }
                return z;
            }
            z = false;
            z3 = false;
            this.O0000Ooo = false;
            setPressed(false);
            drawableStateChanged();
            childAt = getChildAt(this.O0000O0o - getFirstVisiblePosition());
            if (childAt != null) {
            }
            ceVar = this.O0000o00;
            if (ceVar != null) {
            }
            if (!z) {
            }
            return z;
        }
        z = true;
        z3 = false;
        this.O0000Ooo = false;
        setPressed(false);
        drawableStateChanged();
        childAt = getChildAt(this.O0000O0o - getFirstVisiblePosition());
        if (childAt != null) {
        }
        ceVar = this.O0000o00;
        if (ceVar != null) {
        }
        if (!z) {
        }
        return z;
    }

    public void setListSelectionHidden(boolean z) {
        this.O0000Oo = z;
    }

    private void O000000o() {
        Drawable selector = getSelector();
        if (selector != null && this.O0000Ooo && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    class O00000Oo implements Runnable {
        O00000Oo() {
        }

        public final void run() {
            OOOo000 oOOo000 = OOOo000.this;
            oOOo000.f12335O000000o = null;
            oOOo000.drawableStateChanged();
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.O00000Oo.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.O00000Oo);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }
}
