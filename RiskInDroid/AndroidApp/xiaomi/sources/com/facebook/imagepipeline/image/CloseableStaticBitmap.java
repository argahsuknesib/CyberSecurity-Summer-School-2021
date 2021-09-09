package com.facebook.imagepipeline.image;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

public class CloseableStaticBitmap extends CloseableBitmap {
    private volatile Bitmap mBitmap;
    private CloseableReference<Bitmap> mBitmapReference;
    private final int mExifOrientation;
    private final QualityInfo mQualityInfo;
    private final int mRotationAngle;

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i) {
        this(bitmap, resourceReleaser, qualityInfo, i, 0);
    }

    public CloseableStaticBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2) {
        this.mBitmap = (Bitmap) Preconditions.checkNotNull(bitmap);
        this.mBitmapReference = CloseableReference.of(this.mBitmap, (ResourceReleaser) Preconditions.checkNotNull(resourceReleaser));
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
        this(closeableReference, qualityInfo, i, 0);
    }

    public CloseableStaticBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i, int i2) {
        this.mBitmapReference = (CloseableReference) Preconditions.checkNotNull(closeableReference.cloneOrNull());
        this.mBitmap = this.mBitmapReference.get();
        this.mQualityInfo = qualityInfo;
        this.mRotationAngle = i;
        this.mExifOrientation = i2;
    }

    public void close() {
        CloseableReference<Bitmap> detachBitmapReference = detachBitmapReference();
        if (detachBitmapReference != null) {
            detachBitmapReference.close();
        }
    }

    private synchronized CloseableReference<Bitmap> detachBitmapReference() {
        CloseableReference<Bitmap> closeableReference;
        closeableReference = this.mBitmapReference;
        this.mBitmapReference = null;
        this.mBitmap = null;
        return closeableReference;
    }

    public synchronized CloseableReference<Bitmap> convertToBitmapReference() {
        Preconditions.checkNotNull(this.mBitmapReference, "Cannot convert a closed static bitmap");
        return detachBitmapReference();
    }

    public synchronized CloseableReference<Bitmap> cloneUnderlyingBitmapReference() {
        return CloseableReference.cloneOrNull(this.mBitmapReference);
    }

    public synchronized boolean isClosed() {
        return this.mBitmapReference == null;
    }

    public Bitmap getUnderlyingBitmap() {
        return this.mBitmap;
    }

    public int getSizeInBytes() {
        return BitmapUtil.getSizeInBytes(this.mBitmap);
    }

    public int getWidth() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapHeight(this.mBitmap);
        }
        return getBitmapWidth(this.mBitmap);
    }

    public int getHeight() {
        int i;
        if (this.mRotationAngle % 180 != 0 || (i = this.mExifOrientation) == 5 || i == 7) {
            return getBitmapWidth(this.mBitmap);
        }
        return getBitmapHeight(this.mBitmap);
    }

    private static int getBitmapWidth(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getWidth();
    }

    private static int getBitmapHeight(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getHeight();
    }

    public int getRotationAngle() {
        return this.mRotationAngle;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public QualityInfo getQualityInfo() {
        return this.mQualityInfo;
    }
}
