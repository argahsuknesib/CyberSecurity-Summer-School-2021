package com.xiaomi.smarthome.newui.widget;

import com.google.android.material.appbar.AppBarLayout;

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private State f10272O000000o = State.IDLE;

    public enum State {
        EXPANDED,
        COLLAPSED,
        IDLE
    }

    public abstract void O000000o(State state);

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (i == 0) {
            if (this.f10272O000000o != State.EXPANDED) {
                O000000o(State.EXPANDED);
                this.f10272O000000o = State.EXPANDED;
            }
        } else if (Math.abs(i) >= appBarLayout.getTotalScrollRange()) {
            if (this.f10272O000000o != State.COLLAPSED) {
                O000000o(State.COLLAPSED);
                this.f10272O000000o = State.COLLAPSED;
            }
        } else if (this.f10272O000000o != State.IDLE) {
            O000000o(State.IDLE);
            this.f10272O000000o = State.IDLE;
        }
    }
}
