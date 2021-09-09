package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;

public interface ControllerListener<INFO> {
    void onFailure(String str, Throwable th);

    void onFinalImageSet(String str, INFO info, Animatable animatable);

    void onIntermediateImageFailed(String str, Throwable th);

    void onIntermediateImageSet(String str, INFO info);

    void onRelease(String str);

    void onSubmit(String str, Object obj);
}
