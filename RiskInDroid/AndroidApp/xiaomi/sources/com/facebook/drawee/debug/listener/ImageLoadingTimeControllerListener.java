package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;

public class ImageLoadingTimeControllerListener extends BaseControllerListener {
    private long mFinalImageSetTimeMs = -1;
    private ImageLoadingTimeListener mImageLoadingTimeListener;
    private long mRequestSubmitTimeMs = -1;

    public ImageLoadingTimeControllerListener(ImageLoadingTimeListener imageLoadingTimeListener) {
        this.mImageLoadingTimeListener = imageLoadingTimeListener;
    }

    public void onSubmit(String str, Object obj) {
        this.mRequestSubmitTimeMs = System.currentTimeMillis();
    }

    public void onFinalImageSet(String str, Object obj, Animatable animatable) {
        this.mFinalImageSetTimeMs = System.currentTimeMillis();
        ImageLoadingTimeListener imageLoadingTimeListener = this.mImageLoadingTimeListener;
        if (imageLoadingTimeListener != null) {
            imageLoadingTimeListener.onFinalImageSet(this.mFinalImageSetTimeMs - this.mRequestSubmitTimeMs);
        }
    }
}
