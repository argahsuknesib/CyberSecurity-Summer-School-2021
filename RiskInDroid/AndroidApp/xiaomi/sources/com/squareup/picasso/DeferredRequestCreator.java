package com.squareup.picasso;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

class DeferredRequestCreator implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
    Callback callback;
    private final RequestCreator creator;
    final WeakReference<ImageView> target;

    DeferredRequestCreator(RequestCreator requestCreator, ImageView imageView, Callback callback2) {
        this.creator = requestCreator;
        this.target = new WeakReference<>(imageView);
        this.callback = callback2;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            onViewAttachedToWindow(imageView);
        }
    }

    public void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }

    public boolean onPreDraw() {
        ImageView imageView = this.target.get();
        if (imageView == null) {
            return true;
        }
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        int width = imageView.getWidth();
        int height = imageView.getHeight();
        if (width > 0 && height > 0) {
            imageView.removeOnAttachStateChangeListener(this);
            viewTreeObserver.removeOnPreDrawListener(this);
            this.target.clear();
            this.creator.unfit().resize(width, height).into(imageView, this.callback);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void cancel() {
        this.callback = null;
        ImageView imageView = this.target.get();
        if (imageView != null) {
            this.target.clear();
            imageView.removeOnAttachStateChangeListener(this);
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this);
            }
        }
    }
}
