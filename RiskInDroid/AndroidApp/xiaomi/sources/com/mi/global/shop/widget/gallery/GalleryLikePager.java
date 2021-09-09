package com.mi.global.shop.widget.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class GalleryLikePager extends ViewPager {
    public GalleryLikePager(Context context) {
        super(context);
    }

    public GalleryLikePager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent);
    }
}
