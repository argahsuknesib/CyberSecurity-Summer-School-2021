package _m_j;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

public final class gqq implements PtrUIHandler {

    /* renamed from: O000000o  reason: collision with root package name */
    private boolean f18155O000000o;

    public final void onUIReset(PtrFrameLayout ptrFrameLayout) {
        gsy.O000000o(4, "HapticPtrUIHandler", "onUIReset");
    }

    public final void onUIRefreshPrepare(PtrFrameLayout ptrFrameLayout) {
        gsy.O000000o(4, "HapticPtrUIHandler", "onUIRefreshPrepare");
    }

    public final void onUIRefreshBegin(PtrFrameLayout ptrFrameLayout) {
        gsy.O000000o(4, "HapticPtrUIHandler", "onUIRefreshBegin");
    }

    public final void onUIRefreshComplete(PtrFrameLayout ptrFrameLayout) {
        gsy.O000000o(4, "HapticPtrUIHandler", "onUIRefreshBegin");
    }

    public final void onUIPositionChange(PtrFrameLayout ptrFrameLayout, boolean z, byte b, PtrIndicator ptrIndicator) {
        gsy.O000000o(4, "HapticPtrUIHandler", "onUIPositionChange isUnderTouch:" + z + " status:" + ((int) b));
        int offsetToRefresh = ptrFrameLayout.getOffsetToRefresh();
        int currentPosY = ptrIndicator.getCurrentPosY();
        int lastPosY = ptrIndicator.getLastPosY();
        if ((b == 3 || (currentPosY > offsetToRefresh && lastPosY <= offsetToRefresh)) && z) {
            if (!this.f18155O000000o) {
                hzf.O000000o(ptrFrameLayout);
                this.f18155O000000o = true;
            }
        } else if (b == 4 || b == 1) {
            this.f18155O000000o = false;
        }
    }
}
