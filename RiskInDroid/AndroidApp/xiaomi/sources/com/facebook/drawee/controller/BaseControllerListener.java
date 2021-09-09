package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

public class BaseControllerListener<INFO> implements ControllerListener<INFO> {
    private static final ControllerListener<Object> NO_OP_LISTENER = new BaseControllerListener();

    public void onFailure(String str, Throwable th) {
    }

    public void onFinalImageSet(String str, INFO info, Animatable animatable) {
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
    }

    public void onIntermediateImageSet(String str, INFO info) {
    }

    public void onRelease(String str) {
    }

    public void onSubmit(String str, Object obj) {
    }

    public static <INFO> ControllerListener<INFO> getNoOpListener() {
        return NO_OP_LISTENER;
    }
}
