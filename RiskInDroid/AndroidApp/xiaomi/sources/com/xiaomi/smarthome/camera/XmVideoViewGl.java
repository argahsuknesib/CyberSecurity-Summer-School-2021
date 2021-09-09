package com.xiaomi.smarthome.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.view.View;

public interface XmVideoViewGl {

    public interface IDrawBitmapCallback {
        void onBitmapCreated(int i);
    }

    public interface IVideoViewListener {
        void onVideoViewClick();
    }

    public interface IVideoViewScaleListener {
        void reportVideoViewScaleEvent(int i);
    }

    public interface OnDirectionCtrlListener {
        void onClickPTZDirection(int i);
    }

    public static abstract class OnScaleListener {
        public void onFirstVideoShow() {
        }

        public void onScaleChage(float f) {
        }
    }

    public interface PhotoSnapCallback {
        void onSnap(Bitmap bitmap);
    }

    void addMp4Player(XmMp4Player xmMp4Player);

    void clearQueue();

    int drawBitmap(IDrawBitmapCallback iDrawBitmapCallback, Bitmap bitmap, RectF rectF);

    void drawVideoFrame(VideoFrame videoFrame);

    Context getContext();

    String getDid();

    float getMiniScale();

    XmMp4Player getMp4Player();

    float getScale();

    View getSurfaceView();

    void initial();

    boolean isBufferFull();

    boolean isGPUDecoder();

    void onPause();

    void onResume();

    void release();

    void releaseOnlySelf();

    void removeBitmap(int i);

    void setAlpha(float f);

    void setAutoRelease(boolean z);

    void setBg(float f, float f2, float f3);

    void setDid(String str);

    void setDirectionCtrlListener(OnDirectionCtrlListener onDirectionCtrlListener);

    void setDistort(float f, float f2);

    void setDistort(float f, float f2, float f3);

    void setDistort(int i, int i2);

    void setFirstBitmap(Bitmap bitmap);

    void setFps(int i);

    void setHeight(int i);

    void setIsFull(boolean z);

    void setIsFullForRN(boolean z);

    void setMaxScale(float f, float f2);

    void setMiniScale(boolean z);

    void setNeedIFrame();

    void setOnRNScaleListener(OnScaleListener onScaleListener);

    void setOnScaleListener(OnScaleListener onScaleListener);

    void setRNScale(float f, boolean z);

    void setRotation(int i);

    void setScale(float f, boolean z);

    void setTouch(boolean z);

    void setVideoFrameSize(int i, int i2, boolean z);

    void setVideoViewListener(IVideoViewListener iVideoViewListener);

    void setVideoViewScaleListener(IVideoViewScaleListener iVideoViewScaleListener);

    void setVisible(boolean z);

    void setWidth(int i);

    void snap(PhotoSnapCallback photoSnapCallback);

    void updateBitmap(int i, Bitmap bitmap, RectF rectF);
}
