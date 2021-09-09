package com.yqritc.scalablevideoview;

import _m_j.iqb;
import _m_j.iqc;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.xiaomi.smarthome.R;
import java.io.FileDescriptor;
import java.io.IOException;

public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected MediaPlayer f12249O000000o;
    protected ScalableType O00000Oo;

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.O00000Oo = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.scalableType}, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.O00000Oo = ScalableType.values()[i2];
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f12249O000000o;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MediaPlayer mediaPlayer = this.f12249O000000o;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.f12249O000000o.stop();
            }
            this.f12249O000000o.reset();
            this.f12249O000000o.release();
            this.f12249O000000o = null;
        }
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        O000000o(i, i2);
    }

    private void O000000o(int i, int i2) {
        Matrix O000000o2;
        if (i != 0 && i2 != 0 && (O000000o2 = new iqb(new iqc(getWidth(), getHeight()), new iqc(i, i2)).O000000o(this.O00000Oo)) != null) {
            setTransform(O000000o2);
        }
    }

    private void O000000o() {
        MediaPlayer mediaPlayer = this.f12249O000000o;
        if (mediaPlayer == null) {
            this.f12249O000000o = new MediaPlayer();
            this.f12249O000000o.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        mediaPlayer.reset();
    }

    public void setRawData(int i) throws IOException {
        setDataSource(getResources().openRawResourceFd(i));
    }

    public void setAssetData(String str) throws IOException {
        setDataSource(getContext().getAssets().openFd(str));
    }

    private void setDataSource(AssetFileDescriptor assetFileDescriptor) throws IOException {
        FileDescriptor fileDescriptor = assetFileDescriptor.getFileDescriptor();
        long startOffset = assetFileDescriptor.getStartOffset();
        long length = assetFileDescriptor.getLength();
        O000000o();
        this.f12249O000000o.setDataSource(fileDescriptor, startOffset, length);
        assetFileDescriptor.close();
    }

    public void setDataSource(String str) throws IOException {
        O000000o();
        this.f12249O000000o.setDataSource(str);
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        O000000o();
        this.f12249O000000o.setDataSource(fileDescriptor);
    }

    public void setScalableType(ScalableType scalableType) {
        this.O00000Oo = scalableType;
        O000000o(getVideoWidth(), getVideoHeight());
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f12249O000000o.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f12249O000000o.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f12249O000000o.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.f12249O000000o.getCurrentPosition();
    }

    public int getDuration() {
        return this.f12249O000000o.getDuration();
    }

    public int getVideoHeight() {
        return this.f12249O000000o.getVideoHeight();
    }

    public int getVideoWidth() {
        return this.f12249O000000o.getVideoWidth();
    }

    public void setLooping(boolean z) {
        this.f12249O000000o.setLooping(z);
    }
}
