package _m_j;

import _m_j.dg;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class df extends bh {
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final dg.O000000o<cl> NODE_ADAPTER = new dg.O000000o<cl>() {
        /* class _m_j.df.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ void O000000o(Object obj, Rect rect) {
            ((cl) obj).O000000o(rect);
        }
    };
    private static final dg.O00000Oo<o0OO00o0<cl>, cl> SPARSE_VALUES_ADAPTER = new dg.O00000Oo<o0OO00o0<cl>, cl>() {
        /* class _m_j.df.AnonymousClass2 */

        public final /* synthetic */ int O000000o(Object obj) {
            return ((o0OO00o0) obj).O00000Oo();
        }

        public final /* synthetic */ Object O000000o(Object obj, int i) {
            return (cl) ((o0OO00o0) obj).O00000o0(i);
        }
    };
    int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    private final View mHost;
    public int mHoveredVirtualViewId = Integer.MIN_VALUE;
    int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private final AccessibilityManager mManager;
    private O000000o mNodeProvider;
    private final int[] mTempGlobalRect = new int[2];
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();

    private static int keyToDirection(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    /* access modifiers changed from: protected */
    public abstract int getVirtualViewAt(float f, float f2);

    /* access modifiers changed from: protected */
    public abstract void getVisibleVirtualViews(List<Integer> list);

    /* access modifiers changed from: protected */
    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    /* access modifiers changed from: protected */
    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public void onPopulateNodeForHost(cl clVar) {
    }

    /* access modifiers changed from: protected */
    public abstract void onPopulateNodeForVirtualView(int i, cl clVar);

    /* access modifiers changed from: protected */
    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public df(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (cb.O0000O0o(view) == 0) {
                cb.O00000oO(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    public cm getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new O000000o();
        }
        return this.mNodeProvider;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
                updateHoveredVirtualView(virtualViewAt);
                if (virtualViewAt != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || this.mHoveredVirtualViewId == Integer.MIN_VALUE) {
                return false;
            } else {
                updateHoveredVirtualView(Integer.MIN_VALUE);
                return true;
            }
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int keyToDirection = keyToDirection(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z = false;
                        while (i < repeatCount && moveFocus(keyToDirection, null)) {
                            i++;
                            z = true;
                        }
                        return z;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            clickKeyboardFocusedVirtualView();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return moveFocus(2, null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return moveFocus(1, null);
            }
            return false;
        }
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).O000000o(rect);
    }

    private boolean moveFocus(int i, Rect rect) {
        cl clVar;
        int i2;
        o0OO00o0<cl> allNodes = getAllNodes();
        int i3 = this.mKeyboardFocusedVirtualViewId;
        int i4 = Integer.MIN_VALUE;
        Object obj = null;
        cl O000000o2 = i3 == Integer.MIN_VALUE ? null : allNodes.O000000o(i3, null);
        if (i == 1 || i == 2) {
            boolean z = cb.O0000Oo0(this.mHost) == 1;
            dg.O00000Oo<o0OO00o0<cl>, cl> o00000Oo = SPARSE_VALUES_ADAPTER;
            dg.O000000o<cl> o000000o = NODE_ADAPTER;
            int O000000o3 = o00000Oo.O000000o(allNodes);
            ArrayList arrayList = new ArrayList(O000000o3);
            for (int i5 = 0; i5 < O000000o3; i5++) {
                arrayList.add(o00000Oo.O000000o(allNodes, i5));
            }
            Collections.sort(arrayList, new dg.O00000o0(z, o000000o));
            if (i == 1) {
                int size = arrayList.size();
                if (O000000o2 != null) {
                    size = arrayList.indexOf(O000000o2);
                }
                int i6 = size - 1;
                if (i6 >= 0) {
                    obj = arrayList.get(i6);
                }
            } else if (i == 2) {
                int size2 = arrayList.size();
                if (O000000o2 == null) {
                    i2 = -1;
                } else {
                    i2 = arrayList.lastIndexOf(O000000o2);
                }
                int i7 = i2 + 1;
                if (i7 < size2) {
                    obj = arrayList.get(i7);
                }
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            clVar = (cl) obj;
        } else if (i == 17 || i == 33 || i == 66 || i == 130) {
            Rect rect2 = new Rect();
            int i8 = this.mKeyboardFocusedVirtualViewId;
            if (i8 != Integer.MIN_VALUE) {
                getBoundsInParent(i8, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                guessPreviouslyFocusedRect(this.mHost, i, rect2);
            }
            clVar = (cl) dg.O000000o(allNodes, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, O000000o2, rect2, i);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (clVar != null) {
            i4 = allNodes.O00000Oo(allNodes.O000000o((String) clVar));
        }
        return requestKeyboardFocusForVirtualView(i4);
    }

    private o0OO00o0<cl> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        o0OO00o0<cl> o0oo00o0 = new o0OO00o0<>();
        for (int i = 0; i < arrayList.size(); i++) {
            o0oo00o0.O00000Oo(i, createNodeForChild(i));
        }
        return o0oo00o0;
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return cd.O000000o(parent, this.mHost, createEvent(i, i2));
    }

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i != Integer.MIN_VALUE && this.mManager.isEnabled() && (parent = this.mHost.getParent()) != null) {
            AccessibilityEvent createEvent = createEvent(i, 2048);
            ck.O000000o(createEvent, i2);
            cd.O000000o(parent, this.mHost, createEvent);
        }
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 != i) {
            this.mHoveredVirtualViewId = i;
            sendEventForVirtualView(i, NotificationCompat.FLAG_HIGH_PRIORITY);
            sendEventForVirtualView(i2, 256);
        }
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            return createEventForChild(i, i2);
        }
        return createEventForHost(i2);
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        cl obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.O00000o());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.f13980O000000o.getContentDescription());
        obtain.setScrollable(obtainAccessibilityNodeInfo.f13980O000000o.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.f13980O000000o.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.f13980O000000o.isEnabled());
        obtain.setChecked(obtainAccessibilityNodeInfo.f13980O000000o.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(obtainAccessibilityNodeInfo.f13980O000000o.getClassName());
            View view = this.mHost;
            if (Build.VERSION.SDK_INT >= 16) {
                obtain.setSource(view, i);
            }
            obtain.setPackageName(this.mHost.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    /* access modifiers changed from: package-private */
    public cl obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    private cl createNodeForHost() {
        cl O000000o2 = cl.O000000o(this.mHost);
        cb.O000000o(this.mHost, O000000o2);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (O000000o2.f13980O000000o.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = this.mHost;
                int intValue = ((Integer) arrayList.get(i)).intValue();
                if (Build.VERSION.SDK_INT >= 16) {
                    O000000o2.f13980O000000o.addChild(view, intValue);
                }
            }
            return O000000o2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public void onInitializeAccessibilityNodeInfo(View view, cl clVar) {
        super.onInitializeAccessibilityNodeInfo(view, clVar);
        onPopulateNodeForHost(clVar);
    }

    private cl createNodeForChild(int i) {
        cl O000000o2 = cl.O000000o();
        O000000o2.O0000Oo(true);
        O000000o2.O00000o0(true);
        O000000o2.O00000Oo((CharSequence) "android.view.View");
        O000000o2.O00000Oo(INVALID_PARENT_BOUNDS);
        O000000o2.O00000o(INVALID_PARENT_BOUNDS);
        O000000o2.O00000o(this.mHost);
        onPopulateNodeForVirtualView(i, O000000o2);
        if (O000000o2.O00000o() == null && O000000o2.f13980O000000o.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        O000000o2.O000000o(this.mTempParentRect);
        if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS)) {
            int actions = O000000o2.f13980O000000o.getActions();
            if ((actions & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((actions & NotificationCompat.FLAG_HIGH_PRIORITY) == 0) {
                O000000o2.O000000o((CharSequence) this.mHost.getContext().getPackageName());
                View view = this.mHost;
                O000000o2.O00000o0 = i;
                if (Build.VERSION.SDK_INT >= 16) {
                    O000000o2.f13980O000000o.setSource(view, i);
                }
                if (this.mAccessibilityFocusedVirtualViewId == i) {
                    O000000o2.O00000oo(true);
                    O000000o2.O000000o((int) NotificationCompat.FLAG_HIGH_PRIORITY);
                } else {
                    O000000o2.O00000oo(false);
                    O000000o2.O000000o(64);
                }
                boolean z = this.mKeyboardFocusedVirtualViewId == i;
                if (z) {
                    O000000o2.O000000o(2);
                } else if (O000000o2.f13980O000000o.isFocusable()) {
                    O000000o2.O000000o(1);
                }
                O000000o2.O00000o(z);
                this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                O000000o2.O00000o0(this.mTempScreenRect);
                if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS)) {
                    O000000o2.O000000o(this.mTempScreenRect);
                    if (O000000o2.O00000Oo != -1) {
                        cl O000000o3 = cl.O000000o();
                        for (int i2 = O000000o2.O00000Oo; i2 != -1; i2 = O000000o3.O00000Oo) {
                            View view2 = this.mHost;
                            O000000o3.O00000Oo = -1;
                            if (Build.VERSION.SDK_INT >= 16) {
                                O000000o3.f13980O000000o.setParent(view2, -1);
                            }
                            O000000o3.O00000Oo(INVALID_PARENT_BOUNDS);
                            onPopulateNodeForVirtualView(i2, O000000o3);
                            O000000o3.O000000o(this.mTempParentRect);
                            this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
                        }
                        O000000o3.f13980O000000o.recycle();
                    }
                    this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                }
                if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                    this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                        O000000o2.O00000o(this.mTempScreenRect);
                        if (isVisibleToUser(this.mTempScreenRect)) {
                            O000000o2.O00000oO(true);
                        }
                    }
                }
                return O000000o2;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return performActionForChild(i, i2, bundle);
        }
        return performActionForHost(i2, bundle);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        return cb.O000000o(this.mHost, i, bundle);
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 == 1) {
            return requestKeyboardFocusForVirtualView(i);
        }
        if (i2 == 2) {
            return clearKeyboardFocusForVirtualView(i);
        }
        if (i2 == 64) {
            return requestAccessibilityFocus(i);
        }
        if (i2 != 128) {
            return onPerformActionForVirtualView(i, i2, bundle);
        }
        return clearAccessibilityFocus(i);
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        if (parent != null) {
            return true;
        }
        return false;
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (!this.mManager.isEnabled() || !this.mManager.isTouchExplorationEnabled() || (i2 = this.mAccessibilityFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearAccessibilityFocus(i2);
        }
        this.mAccessibilityFocusedVirtualViewId = i;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 32768);
        return true;
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId != i) {
            return false;
        }
        this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
        this.mHost.invalidate();
        sendEventForVirtualView(i, 65536);
        return true;
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((!this.mHost.isFocused() && !this.mHost.requestFocus()) || (i2 = this.mKeyboardFocusedVirtualViewId) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        this.mKeyboardFocusedVirtualViewId = i;
        onVirtualViewKeyboardFocusChanged(i, true);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    class O000000o extends cm {
        O000000o() {
        }

        public final cl O000000o(int i) {
            return cl.O000000o(df.this.obtainAccessibilityNodeInfo(i));
        }

        public final boolean O000000o(int i, int i2, Bundle bundle) {
            return df.this.performAction(i, i2, bundle);
        }

        public final cl O00000Oo(int i) {
            int i2 = i == 2 ? df.this.mAccessibilityFocusedVirtualViewId : df.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return O000000o(i2);
        }
    }
}
