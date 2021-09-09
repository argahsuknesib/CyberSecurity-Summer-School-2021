package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay viewGroupOverlay;

    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.viewGroupOverlay = viewGroup.getOverlay();
    }

    public void add(Drawable drawable) {
        this.viewGroupOverlay.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.viewGroupOverlay.remove(drawable);
    }

    public void add(View view) {
        this.viewGroupOverlay.add(view);
    }

    public void remove(View view) {
        this.viewGroupOverlay.remove(view);
    }
}
