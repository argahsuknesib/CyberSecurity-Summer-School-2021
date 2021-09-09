package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageLoader {
    private int mBatchResponseDelayMs = 100;
    public final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap<>();
    private final ImageCache mCache;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    public final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap<>();
    private final RequestQueue mRequestQueue;
    public Runnable mRunnable;

    public interface ImageCache {
        Bitmap getBitmap(String str);

        void putBitmap(String str, Bitmap bitmap);
    }

    public interface ImageListener extends Response.ErrorListener {
        void onResponse(ImageContainer imageContainer, boolean z);
    }

    public ImageLoader(RequestQueue requestQueue, ImageCache imageCache) {
        this.mRequestQueue = requestQueue;
        this.mCache = imageCache;
    }

    public static ImageListener getImageListener(final ImageView imageView, final int i, final int i2) {
        return new ImageListener() {
            /* class com.android.volley.toolbox.ImageLoader.AnonymousClass1 */

            public final void onErrorResponse(VolleyError volleyError) {
                int i = i2;
                if (i != 0) {
                    imageView.setImageResource(i);
                }
            }

            public final void onResponse(ImageContainer imageContainer, boolean z) {
                if (imageContainer.getBitmap() != null) {
                    imageView.setImageBitmap(imageContainer.getBitmap());
                    return;
                }
                int i = i;
                if (i != 0) {
                    imageView.setImageResource(i);
                }
            }
        };
    }

    public boolean isCached(String str, int i, int i2) {
        throwIfNotOnMainThread();
        return this.mCache.getBitmap(getCacheKey(str, i, i2)) != null;
    }

    public ImageContainer get(String str, ImageListener imageListener) {
        return get(str, imageListener, 0, 0);
    }

    public ImageContainer get(String str, ImageListener imageListener, int i, int i2) {
        ImageListener imageListener2 = imageListener;
        throwIfNotOnMainThread();
        final String cacheKey = getCacheKey(str, i, i2);
        Bitmap bitmap = this.mCache.getBitmap(cacheKey);
        if (bitmap != null) {
            ImageContainer imageContainer = new ImageContainer(bitmap, str, null, null);
            imageListener2.onResponse(imageContainer, true);
            return imageContainer;
        }
        ImageContainer imageContainer2 = new ImageContainer(null, str, cacheKey, imageListener);
        imageListener2.onResponse(imageContainer2, true);
        BatchedImageRequest batchedImageRequest = this.mInFlightRequests.get(cacheKey);
        if (batchedImageRequest != null) {
            batchedImageRequest.addContainer(imageContainer2);
            return imageContainer2;
        }
        ImageRequest imageRequest = new ImageRequest(str, new Response.Listener<Bitmap>() {
            /* class com.android.volley.toolbox.ImageLoader.AnonymousClass2 */

            public void onResponse(Bitmap bitmap) {
                ImageLoader.this.onGetImageSuccess(cacheKey, bitmap);
            }
        }, i, i2, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            /* class com.android.volley.toolbox.ImageLoader.AnonymousClass3 */

            public void onErrorResponse(VolleyError volleyError) {
                ImageLoader.this.onGetImageError(cacheKey, volleyError);
            }
        });
        this.mRequestQueue.add(imageRequest);
        this.mInFlightRequests.put(cacheKey, new BatchedImageRequest(imageRequest, imageContainer2));
        return imageContainer2;
    }

    public void setBatchedResponseDelay(int i) {
        this.mBatchResponseDelayMs = i;
    }

    public void onGetImageSuccess(String str, Bitmap bitmap) {
        this.mCache.putBitmap(str, bitmap);
        BatchedImageRequest remove = this.mInFlightRequests.remove(str);
        if (remove != null) {
            remove.mResponseBitmap = bitmap;
            batchResponse(str, remove);
        }
    }

    public void onGetImageError(String str, VolleyError volleyError) {
        BatchedImageRequest remove = this.mInFlightRequests.remove(str);
        if (remove != null) {
            remove.setError(volleyError);
            batchResponse(str, remove);
        }
    }

    public class ImageContainer {
        public Bitmap mBitmap;
        private final String mCacheKey;
        public final ImageListener mListener;
        private final String mRequestUrl;

        public ImageContainer(Bitmap bitmap, String str, String str2, ImageListener imageListener) {
            this.mBitmap = bitmap;
            this.mRequestUrl = str;
            this.mCacheKey = str2;
            this.mListener = imageListener;
        }

        public void cancelRequest() {
            if (this.mListener != null) {
                BatchedImageRequest batchedImageRequest = ImageLoader.this.mInFlightRequests.get(this.mCacheKey);
                if (batchedImageRequest == null) {
                    BatchedImageRequest batchedImageRequest2 = ImageLoader.this.mBatchedResponses.get(this.mCacheKey);
                    if (batchedImageRequest2 != null) {
                        batchedImageRequest2.removeContainerAndCancelIfNecessary(this);
                        if (batchedImageRequest2.mContainers.size() == 0) {
                            ImageLoader.this.mBatchedResponses.remove(this.mCacheKey);
                        }
                    }
                } else if (batchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
                    ImageLoader.this.mInFlightRequests.remove(this.mCacheKey);
                }
            }
        }

        public Bitmap getBitmap() {
            return this.mBitmap;
        }

        public String getRequestUrl() {
            return this.mRequestUrl;
        }
    }

    class BatchedImageRequest {
        public final LinkedList<ImageContainer> mContainers = new LinkedList<>();
        private VolleyError mError;
        private final Request<?> mRequest;
        public Bitmap mResponseBitmap;

        public BatchedImageRequest(Request<?> request, ImageContainer imageContainer) {
            this.mRequest = request;
            this.mContainers.add(imageContainer);
        }

        public void setError(VolleyError volleyError) {
            this.mError = volleyError;
        }

        public VolleyError getError() {
            return this.mError;
        }

        public void addContainer(ImageContainer imageContainer) {
            this.mContainers.add(imageContainer);
        }

        public boolean removeContainerAndCancelIfNecessary(ImageContainer imageContainer) {
            this.mContainers.remove(imageContainer);
            if (this.mContainers.size() != 0) {
                return false;
            }
            this.mRequest.cancel();
            return true;
        }
    }

    private void batchResponse(String str, BatchedImageRequest batchedImageRequest) {
        this.mBatchedResponses.put(str, batchedImageRequest);
        if (this.mRunnable == null) {
            this.mRunnable = new Runnable() {
                /* class com.android.volley.toolbox.ImageLoader.AnonymousClass4 */

                public void run() {
                    for (BatchedImageRequest next : ImageLoader.this.mBatchedResponses.values()) {
                        Iterator<ImageContainer> it = next.mContainers.iterator();
                        while (it.hasNext()) {
                            ImageContainer next2 = it.next();
                            if (next2.mListener != null) {
                                if (next.getError() == null) {
                                    next2.mBitmap = next.mResponseBitmap;
                                    next2.mListener.onResponse(next2, false);
                                } else {
                                    next2.mListener.onErrorResponse(next.getError());
                                }
                            }
                        }
                    }
                    ImageLoader.this.mBatchedResponses.clear();
                    ImageLoader.this.mRunnable = null;
                }
            };
            this.mHandler.postDelayed(this.mRunnable, (long) this.mBatchResponseDelayMs);
        }
    }

    private void throwIfNotOnMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
        }
    }

    private static String getCacheKey(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder(str.length() + 12);
        sb.append("#W");
        sb.append(i);
        sb.append("#H");
        sb.append(i2);
        sb.append(str);
        return sb.toString();
    }
}
