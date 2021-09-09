package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalContentUriThumbnailFetchProducer extends LocalFetchProducer implements ThumbnailProducer<EncodedImage> {
    private static final Rect MICRO_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 96, 96);
    private static final Rect MINI_THUMBNAIL_DIMENSIONS = new Rect(0, 0, 512, 384);
    private static final String[] PROJECTION = {"_id", "_data"};
    private static final Class<?> TAG = LocalContentUriThumbnailFetchProducer.class;
    private static final String[] THUMBNAIL_PROJECTION = {"_data"};
    private final ContentResolver mContentResolver;

    /* access modifiers changed from: protected */
    public String getProducerName() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    public LocalContentUriThumbnailFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, ContentResolver contentResolver) {
        super(executor, pooledByteBufferFactory);
        this.mContentResolver = contentResolver;
    }

    public boolean canProvideImageForSize(ResizeOptions resizeOptions) {
        return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions);
    }

    /* access modifiers changed from: protected */
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        EncodedImage cameraImage;
        Uri sourceUri = imageRequest.getSourceUri();
        if (!UriUtil.isLocalCameraUri(sourceUri) || (cameraImage = getCameraImage(sourceUri, imageRequest.getResizeOptions())) == null) {
            return null;
        }
        return cameraImage;
    }

    private EncodedImage getCameraImage(Uri uri, ResizeOptions resizeOptions) throws IOException {
        EncodedImage thumbnail;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (resizeOptions == null || (thumbnail = getThumbnail(resizeOptions, query.getInt(query.getColumnIndex("_id")))) == null) {
                query.close();
                return null;
            }
            thumbnail.setRotationAngle(getRotationAngle(string));
            query.close();
            return thumbnail;
        } finally {
            query.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056  */
    private EncodedImage getThumbnail(ResizeOptions resizeOptions, int i) throws IOException {
        Cursor cursor;
        int thumbnailKind = getThumbnailKind(resizeOptions);
        if (thumbnailKind == 0) {
            return null;
        }
        try {
            cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, (long) i, thumbnailKind, THUMBNAIL_PROJECTION);
            if (cursor == null) {
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            }
            try {
                cursor.moveToFirst();
                if (cursor.getCount() > 0) {
                    String string = cursor.getString(cursor.getColumnIndex("_data"));
                    if (new File(string).exists()) {
                        EncodedImage encodedImage = getEncodedImage(new FileInputStream(string), getLength(string));
                        if (cursor != null) {
                            cursor.close();
                        }
                        return encodedImage;
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
            }
            throw th;
        }
    }

    private static int getThumbnailKind(ResizeOptions resizeOptions) {
        if (ThumbnailSizeChecker.isImageBigEnough(MICRO_THUMBNAIL_DIMENSIONS.width(), MICRO_THUMBNAIL_DIMENSIONS.height(), resizeOptions)) {
            return 3;
        }
        return ThumbnailSizeChecker.isImageBigEnough(MINI_THUMBNAIL_DIMENSIONS.width(), MINI_THUMBNAIL_DIMENSIONS.height(), resizeOptions) ? 1 : 0;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    private static int getRotationAngle(String str) {
        if (str != null) {
            try {
                return JfifUtil.getAutoRotateAngleFromOrientation(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                FLog.e(TAG, e, "Unable to retrieve thumbnail rotation for %s", str);
            }
        }
        return 0;
    }
}
