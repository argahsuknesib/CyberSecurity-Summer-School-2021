package _m_j;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class br {

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f13211O000000o;
    private ViewParent O00000Oo;
    private final View O00000o;
    private ViewParent O00000o0;
    private int[] O00000oO;

    public br(View view) {
        this.O00000o = view;
    }

    public final void O000000o(boolean z) {
        if (this.f13211O000000o) {
            cb.O000O0o0(this.O00000o);
        }
        this.f13211O000000o = z;
    }

    public final boolean O000000o(int i) {
        return O00000o0(i) != null;
    }

    public final boolean O000000o(int i, int i2) {
        if (O000000o(i2)) {
            return true;
        }
        if (!this.f13211O000000o) {
            return false;
        }
        View view = this.O00000o;
        for (ViewParent parent = this.O00000o.getParent(); parent != null; parent = parent.getParent()) {
            if (cd.O000000o(parent, view, this.O00000o, i, i2)) {
                O000000o(i2, parent);
                View view2 = this.O00000o;
                if (parent instanceof bt) {
                    ((bt) parent).onNestedScrollAccepted(view, view2, i, i2);
                } else if (i2 == 0) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            parent.onNestedScrollAccepted(view, view2, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e);
                        }
                    } else if (parent instanceof bs) {
                        ((bs) parent).onNestedScrollAccepted(view, view2, i);
                    }
                }
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public final void O00000Oo(int i) {
        ViewParent O00000o02 = O00000o0(i);
        if (O00000o02 != null) {
            View view = this.O00000o;
            if (O00000o02 instanceof bt) {
                ((bt) O00000o02).onStopNestedScroll(view, i);
            } else if (i == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        O00000o02.onStopNestedScroll(view);
                    } catch (AbstractMethodError e) {
                        Log.e("ViewParentCompat", "ViewParent " + O00000o02 + " does not implement interface method onStopNestedScroll", e);
                    }
                } else if (O00000o02 instanceof bs) {
                    ((bs) O00000o02).onStopNestedScroll(view);
                }
            }
            O000000o(i, (ViewParent) null);
        }
    }

    public final boolean O000000o(int i, int i2, int i3, int i4, int[] iArr) {
        return O00000Oo(i, i2, i3, i4, iArr, 0, null);
    }

    public final void O000000o(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        O00000Oo(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public final boolean O000000o(int i, int i2, int[] iArr, int[] iArr2) {
        return O000000o(i, i2, iArr, iArr2, 0);
    }

    private ViewParent O00000o0(int i) {
        if (i == 0) {
            return this.O00000Oo;
        }
        if (i != 1) {
            return null;
        }
        return this.O00000o0;
    }

    private void O000000o(int i, ViewParent viewParent) {
        if (i == 0) {
            this.O00000Oo = viewParent;
        } else if (i == 1) {
            this.O00000o0 = viewParent;
        }
    }

    private int[] O000000o() {
        if (this.O00000oO == null) {
            this.O00000oO = new int[2];
        }
        return this.O00000oO;
    }

    public final boolean O00000Oo(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent O00000o02;
        int i6;
        int i7;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!this.f13211O000000o || (O00000o02 = O00000o0(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.O00000o.getLocationInWindow(iArr4);
            i7 = iArr4[0];
            i6 = iArr4[1];
        } else {
            i7 = 0;
            i6 = 0;
        }
        if (iArr2 == null) {
            int[] O000000o2 = O000000o();
            O000000o2[0] = 0;
            O000000o2[1] = 0;
            iArr3 = O000000o2;
        } else {
            iArr3 = iArr2;
        }
        cd.O000000o(O00000o02, this.O00000o, i, i2, i3, i4, i5, iArr3);
        if (iArr4 != null) {
            this.O00000o.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i7;
            iArr4[1] = iArr4[1] - i6;
        }
        return true;
    }

    public final boolean O000000o(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent O00000o02;
        int i4;
        int i5;
        if (!this.f13211O000000o || (O00000o02 = O00000o0(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.O00000o.getLocationInWindow(iArr2);
            i5 = iArr2[0];
            i4 = iArr2[1];
        } else {
            i5 = 0;
            i4 = 0;
        }
        if (iArr == null) {
            iArr = O000000o();
        }
        iArr[0] = 0;
        iArr[1] = 0;
        cd.O000000o(O00000o02, this.O00000o, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.O00000o.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i5;
            iArr2[1] = iArr2[1] - i4;
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return false;
        }
        return true;
    }

    public final boolean O000000o(float f, float f2, boolean z) {
        ViewParent O00000o02;
        if (!this.f13211O000000o || (O00000o02 = O00000o0(0)) == null) {
            return false;
        }
        return cd.O000000o(O00000o02, this.O00000o, f, f2, z);
    }

    public final boolean O000000o(float f, float f2) {
        ViewParent O00000o02;
        if (!this.f13211O000000o || (O00000o02 = O00000o0(0)) == null) {
            return false;
        }
        return cd.O000000o(O00000o02, this.O00000o, f, f2);
    }
}
