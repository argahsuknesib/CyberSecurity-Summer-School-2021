package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

class DropDownListView extends ListViewCompat {
    private ViewPropertyAnimatorCompat mClickAnimation;
    private boolean mDrawsInPressedState;
    private boolean mHijackFocus;
    private boolean mListSelectionHidden;
    private ListViewAutoScrollHelper mScrollHelper;

    public DropDownListView(Context context, boolean z) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.mHijackFocus = z;
        setCacheColorHint(0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r0 != 3) goto L_0x000e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065  */
    public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int findPointerIndex;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 1) {
            z2 = false;
            findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex >= 0) {
            }
            z = false;
            z2 = false;
            clearPressedItem();
            if (!z2) {
            }
            return z2;
        } else if (actionMasked == 2) {
            z2 = true;
            findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex >= 0) {
                int x = (int) motionEvent.getX(findPointerIndex);
                int y = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, y);
                if (pointToPosition == -1) {
                    z = true;
                    if (!z2 || z) {
                        clearPressedItem();
                    }
                    if (!z2) {
                        if (this.mScrollHelper == null) {
                            this.mScrollHelper = new ListViewAutoScrollHelper(this);
                        }
                        this.mScrollHelper.setEnabled(true);
                        this.mScrollHelper.onTouch(this, motionEvent);
                    } else {
                        ListViewAutoScrollHelper listViewAutoScrollHelper = this.mScrollHelper;
                        if (listViewAutoScrollHelper != null) {
                            listViewAutoScrollHelper.setEnabled(false);
                        }
                    }
                    return z2;
                }
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                setPressedItem(childAt, pointToPosition, (float) x, (float) y);
                if (actionMasked == 1) {
                    clickPressedItem(childAt, pointToPosition);
                }
            }
            z = false;
            z2 = false;
            clearPressedItem();
            if (!z2) {
            }
            return z2;
        }
        z = false;
        z2 = true;
        clearPressedItem();
        if (!z2) {
        }
        return z2;
    }

    private void clickPressedItem(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.mListSelectionHidden = z;
    }

    private void clearPressedItem() {
        this.mDrawsInPressedState = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mClickAnimation;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
            this.mClickAnimation = null;
        }
    }

    private void setPressedItem(View view, int i, float f, float f2) {
        View childAt;
        this.mDrawsInPressedState = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (!(this.mMotionPosition == -1 || (childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.mMotionPosition = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        positionSelectorLikeTouchCompat(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* access modifiers changed from: protected */
    public boolean touchModeDrawsInPressedStateCompat() {
        return this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat();
    }

    public boolean isInTouchMode() {
        return (this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode();
    }

    public boolean hasWindowFocus() {
        return this.mHijackFocus || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.mHijackFocus || super.isFocused();
    }

    public boolean hasFocus() {
        return this.mHijackFocus || super.hasFocus();
    }
}
