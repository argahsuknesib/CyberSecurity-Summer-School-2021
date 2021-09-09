package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.gsy;

public class Hls2Mp4 {
    private static final String TAG = "Hls2Mp4";
    private boolean mIsRunning;
    private OnInfoListener mListener;
    private long mNativeContext = 0;

    public interface OnInfoListener {
        void onCancelled();

        void onComplete();

        void onError(int i);

        void onInfo(int i);

        void onProgress(int i);

        void onSize(int i);

        void onStart();
    }

    private native int cancelConvertNative();

    private native int startConvertNative(String str, String str2);

    private native int startConvertNativeWithCookie(String str, String str2, String str3);

    public void setInfoListener(OnInfoListener onInfoListener) {
        this.mListener = onInfoListener;
    }

    public void removeInfoListener() {
        this.mListener = null;
    }

    public void start(String str, String str2) {
        this.mIsRunning = true;
        startConvertNative(str, str2);
    }

    public void start(String str, String str2, String str3) {
        this.mIsRunning = true;
        startConvertNativeWithCookie(str, str2, str3);
    }

    public int cancel() {
        return cancelConvertNative();
    }

    public boolean isRunning() {
        return this.mIsRunning;
    }

    private void notifyFromNative(int i, int i2) {
        if (i != 202) {
            String str = TAG;
            gsy.O00000Oo(str, "callback from native:" + i + "-" + i2);
        }
        if (i == 201) {
            OnInfoListener onInfoListener = this.mListener;
            if (onInfoListener != null && i2 <= 100) {
                onInfoListener.onProgress(i2);
            }
        } else if (i != 202) {
            switch (i) {
                case 100:
                    this.mIsRunning = true;
                    OnInfoListener onInfoListener2 = this.mListener;
                    if (onInfoListener2 != null) {
                        onInfoListener2.onStart();
                        return;
                    }
                    return;
                case 101:
                    this.mIsRunning = false;
                    OnInfoListener onInfoListener3 = this.mListener;
                    if (onInfoListener3 != null) {
                        onInfoListener3.onCancelled();
                        return;
                    }
                    return;
                case 102:
                    this.mIsRunning = false;
                    OnInfoListener onInfoListener4 = this.mListener;
                    if (onInfoListener4 != null) {
                        onInfoListener4.onComplete();
                        return;
                    }
                    return;
                default:
                    if (i < 0 || i == 103) {
                        this.mIsRunning = false;
                        OnInfoListener onInfoListener5 = this.mListener;
                        if (onInfoListener5 != null && i2 <= 100) {
                            onInfoListener5.onError(i);
                            return;
                        }
                        return;
                    }
                    OnInfoListener onInfoListener6 = this.mListener;
                    if (onInfoListener6 != null && i2 <= 100) {
                        onInfoListener6.onInfo(i);
                        return;
                    }
                    return;
            }
        } else {
            OnInfoListener onInfoListener7 = this.mListener;
            if (onInfoListener7 != null) {
                onInfoListener7.onSize(i2);
            }
        }
    }

    static {
        System.loadLibrary("mjmp4mux");
    }
}
