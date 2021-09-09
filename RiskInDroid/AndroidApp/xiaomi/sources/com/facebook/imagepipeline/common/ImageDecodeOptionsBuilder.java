package com.facebook.imagepipeline.common;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.decoder.ImageDecoder;

public class ImageDecodeOptionsBuilder {
    private Bitmap.Config mBitmapConfig = Bitmap.Config.ARGB_8888;
    private ImageDecoder mCustomImageDecoder;
    private boolean mDecodeAllFrames;
    private boolean mDecodePreviewFrame;
    private boolean mForceStaticImage;
    private int mMinDecodeIntervalMs = 100;
    private boolean mUseLastFrameForPreview;

    public ImageDecodeOptionsBuilder setFrom(ImageDecodeOptions imageDecodeOptions) {
        this.mDecodePreviewFrame = imageDecodeOptions.decodePreviewFrame;
        this.mUseLastFrameForPreview = imageDecodeOptions.useLastFrameForPreview;
        this.mDecodeAllFrames = imageDecodeOptions.decodeAllFrames;
        this.mForceStaticImage = imageDecodeOptions.forceStaticImage;
        this.mBitmapConfig = imageDecodeOptions.bitmapConfig;
        this.mCustomImageDecoder = imageDecodeOptions.customImageDecoder;
        return this;
    }

    public ImageDecodeOptionsBuilder setMinDecodeIntervalMs(int i) {
        this.mMinDecodeIntervalMs = i;
        return this;
    }

    public int getMinDecodeIntervalMs() {
        return this.mMinDecodeIntervalMs;
    }

    public ImageDecodeOptionsBuilder setDecodePreviewFrame(boolean z) {
        this.mDecodePreviewFrame = z;
        return this;
    }

    public boolean getDecodePreviewFrame() {
        return this.mDecodePreviewFrame;
    }

    public boolean getUseLastFrameForPreview() {
        return this.mUseLastFrameForPreview;
    }

    public ImageDecodeOptionsBuilder setUseLastFrameForPreview(boolean z) {
        this.mUseLastFrameForPreview = z;
        return this;
    }

    public boolean getDecodeAllFrames() {
        return this.mDecodeAllFrames;
    }

    public ImageDecodeOptionsBuilder setDecodeAllFrames(boolean z) {
        this.mDecodeAllFrames = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setForceStaticImage(boolean z) {
        this.mForceStaticImage = z;
        return this;
    }

    public ImageDecodeOptionsBuilder setCustomImageDecoder(ImageDecoder imageDecoder) {
        this.mCustomImageDecoder = imageDecoder;
        return this;
    }

    public ImageDecoder getCustomImageDecoder() {
        return this.mCustomImageDecoder;
    }

    public boolean getForceStaticImage() {
        return this.mForceStaticImage;
    }

    public Bitmap.Config getBitmapConfig() {
        return this.mBitmapConfig;
    }

    public ImageDecodeOptionsBuilder setBitmapConfig(Bitmap.Config config) {
        this.mBitmapConfig = config;
        return this;
    }

    public ImageDecodeOptions build() {
        return new ImageDecodeOptions(this);
    }
}
