package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ForwardingControllerListener<INFO> implements ControllerListener<INFO> {
    private final List<ControllerListener<? super INFO>> mListeners = new ArrayList(2);

    public static <INFO> ForwardingControllerListener<INFO> create() {
        return new ForwardingControllerListener<>();
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener) {
        ForwardingControllerListener<INFO> create = create();
        create.addListener(controllerListener);
        return create;
    }

    public static <INFO> ForwardingControllerListener<INFO> of(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
        ForwardingControllerListener<INFO> create = create();
        create.addListener(controllerListener);
        create.addListener(controllerListener2);
        return create;
    }

    public synchronized void addListener(ControllerListener<? super INFO> controllerListener) {
        this.mListeners.add(controllerListener);
    }

    public synchronized void removeListener(ControllerListener<? super INFO> controllerListener) {
        int indexOf = this.mListeners.indexOf(controllerListener);
        if (indexOf != -1) {
            this.mListeners.set(indexOf, null);
        }
    }

    public synchronized void clearListeners() {
        this.mListeners.clear();
    }

    private synchronized void onException(String str, Throwable th) {
        Log.e("FdingControllerListener", str, th);
    }

    public synchronized void onSubmit(String str, Object obj) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onSubmit(str, obj);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onSubmit", e);
            }
        }
    }

    public synchronized void onFinalImageSet(String str, INFO info, Animatable animatable) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFinalImageSet(str, info, animatable);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onFinalImageSet", e);
            }
        }
    }

    public void onIntermediateImageSet(String str, INFO info) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageSet(str, info);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageSet", e);
            }
        }
    }

    public void onIntermediateImageFailed(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onIntermediateImageFailed(str, th);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onIntermediateImageFailed", e);
            }
        }
    }

    public synchronized void onFailure(String str, Throwable th) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onFailure(str, th);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onFailure", e);
            }
        }
    }

    public synchronized void onRelease(String str) {
        int size = this.mListeners.size();
        for (int i = 0; i < size; i++) {
            try {
                ControllerListener controllerListener = this.mListeners.get(i);
                if (controllerListener != null) {
                    controllerListener.onRelease(str);
                }
            } catch (Exception e) {
                onException("InternalListener exception in onRelease", e);
            }
        }
    }
}
