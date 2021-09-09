package com.xiaomi.smarthome.camera;

import android.content.Context;

public interface HLSDownloader {

    public interface OnInfoListenerP {
        void onCancelled();

        void onComplete();

        void onError(int i);

        void onInfo(int i);

        void onProgress(int i);

        void onSize(int i);

        void onStart();
    }

    void cancel();

    boolean isRunning();

    void removeInfoListener();

    void setInfoListener(OnInfoListenerP onInfoListenerP);

    void start(Context context, String str, String str2);
}
