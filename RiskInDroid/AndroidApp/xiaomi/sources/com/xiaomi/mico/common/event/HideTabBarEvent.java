package com.xiaomi.mico.common.event;

public class HideTabBarEvent {
    private boolean hide;

    public HideTabBarEvent(boolean z) {
        this.hide = z;
    }

    public boolean isHide() {
        return this.hide;
    }
}
