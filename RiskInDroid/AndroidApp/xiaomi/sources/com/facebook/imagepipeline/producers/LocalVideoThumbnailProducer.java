package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalVideoThumbnailProducer implements Producer<CloseableReference<CloseableImage>> {
    private final ContentResolver mContentResolver;
    private final Executor mExecutor;

    public LocalVideoThumbnailProducer(Executor executor, ContentResolver contentResolver) {
        this.mExecutor = executor;
        this.mContentResolver = contentResolver;
    }

    public void produceResults(Consumer<CloseableReference<CloseableImage>> consumer, ProducerContext producerContext) {
        final ProducerListener listener = producerContext.getListener();
        final String id = producerContext.getId();
        final ImageRequest imageRequest = producerContext.getImageRequest();
        final AnonymousClass1 r0 = new StatefulProducerRunnable<CloseableReference<CloseableImage>>(consumer, listener, "VideoThumbnailProducer", id) {
            /* class com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.AnonymousClass1 */

            public /* bridge */ /* synthetic */ void disposeResult(Object obj) {
                disposeResult((CloseableReference<CloseableImage>) ((CloseableReference) obj));
            }

            /* access modifiers changed from: protected */
            public /* bridge */ /* synthetic */ Map getExtraMapOnSuccess(Object obj) {
                return getExtraMapOnSuccess((CloseableReference<CloseableImage>) ((CloseableReference) obj));
            }

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((CloseableReference<CloseableImage>) ((CloseableReference) obj));
            }

            /* access modifiers changed from: protected */
            public void onSuccess(CloseableReference<CloseableImage> closeableReference) {
                super.onSuccess((Object) closeableReference);
                listener.onUltimateProducerReached(id, "VideoThumbnailProducer", closeableReference != null);
            }

            public void onFailure(Exception exc) {
                super.onFailure(exc);
                listener.onUltimateProducerReached(id, "VideoThumbnailProducer", false);
            }

            /* access modifiers changed from: protected */
            public CloseableReference<CloseableImage> getResult() throws Exception {
                Bitmap createVideoThumbnail;
                String localFilePath = LocalVideoThumbnailProducer.this.getLocalFilePath(imageRequest);
                if (localFilePath == null || (createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(localFilePath, LocalVideoThumbnailProducer.calculateKind(imageRequest))) == null) {
                    return null;
                }
                return CloseableReference.of(new CloseableStaticBitmap(createVideoThumbnail, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, 0));
            }

            /* access modifiers changed from: protected */
            public Map<String, String> getExtraMapOnSuccess(CloseableReference<CloseableImage> closeableReference) {
                return ImmutableMap.of("createdThumbnail", String.valueOf(closeableReference != null));
            }

            /* access modifiers changed from: protected */
            public void disposeResult(CloseableReference<CloseableImage> closeableReference) {
                CloseableReference.closeSafely(closeableReference);
            }
        };
        producerContext.addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer.AnonymousClass2 */

            public void onCancellationRequested() {
                r0.cancel();
            }
        });
        this.mExecutor.execute(r0);
    }

    public static int calculateKind(ImageRequest imageRequest) {
        return (imageRequest.getPreferredWidth() > 96 || imageRequest.getPreferredHeight() > 96) ? 1 : 3;
    }

    public String getLocalFilePath(ImageRequest imageRequest) {
        String[] strArr;
        String str;
        Uri uri;
        Uri sourceUri = imageRequest.getSourceUri();
        if (UriUtil.isLocalFileUri(sourceUri)) {
            return imageRequest.getSourceFile().getPath();
        }
        if (UriUtil.isLocalContentUri(sourceUri)) {
            if (Build.VERSION.SDK_INT < 19 || !"com.android.providers.media.documents".equals(sourceUri.getAuthority())) {
                uri = sourceUri;
                str = null;
                strArr = null;
            } else {
                String documentId = DocumentsContract.getDocumentId(sourceUri);
                str = "_id=?";
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                strArr = new String[]{documentId.split(":")[1]};
            }
            Cursor query = this.mContentResolver.query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        return query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        }
        return null;
    }
}
