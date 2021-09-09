package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import com.facebook.FacebookException;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.WorkQueue;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader {
    private static WorkQueue cacheReadQueue = new WorkQueue(2);
    private static WorkQueue downloadQueue = new WorkQueue(8);
    private static Handler handler;
    private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();

    public static void downloadAsync(ImageRequest imageRequest) {
        if (imageRequest != null) {
            RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
            synchronized (pendingRequests) {
                DownloaderContext downloaderContext = pendingRequests.get(requestKey);
                if (downloaderContext != null) {
                    downloaderContext.request = imageRequest;
                    downloaderContext.isCancelled = false;
                    downloaderContext.workItem.moveToFront();
                } else {
                    enqueueCacheRead(imageRequest, requestKey, imageRequest.isCachedRedirectAllowed());
                }
            }
        }
    }

    public static boolean cancelRequest(ImageRequest imageRequest) {
        boolean z;
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            z = true;
            if (downloaderContext == null) {
                z = false;
            } else if (downloaderContext.workItem.cancel()) {
                pendingRequests.remove(requestKey);
            } else {
                downloaderContext.isCancelled = true;
            }
        }
        return z;
    }

    public static void prioritizeRequest(ImageRequest imageRequest) {
        RequestKey requestKey = new RequestKey(imageRequest.getImageUri(), imageRequest.getCallerTag());
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = pendingRequests.get(requestKey);
            if (downloaderContext != null) {
                downloaderContext.workItem.moveToFront();
            }
        }
    }

    public static void clearCache(Context context) {
        ImageResponseCache.clearCache(context);
        UrlRedirectCache.clearCache();
    }

    private static void enqueueCacheRead(ImageRequest imageRequest, RequestKey requestKey, boolean z) {
        enqueueRequest(imageRequest, requestKey, cacheReadQueue, new CacheReadWorkItem(imageRequest.getContext(), requestKey, z));
    }

    private static void enqueueDownload(ImageRequest imageRequest, RequestKey requestKey) {
        enqueueRequest(imageRequest, requestKey, downloadQueue, new DownloadImageWorkItem(imageRequest.getContext(), requestKey));
    }

    private static void enqueueRequest(ImageRequest imageRequest, RequestKey requestKey, WorkQueue workQueue, Runnable runnable) {
        synchronized (pendingRequests) {
            DownloaderContext downloaderContext = new DownloaderContext();
            downloaderContext.request = imageRequest;
            pendingRequests.put(requestKey, downloaderContext);
            downloaderContext.workItem = workQueue.addActiveWorkItem(runnable);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r2 = r7.request;
        r6 = r2.getCallback();
     */
    private static void issueResponse(RequestKey requestKey, Exception exc, Bitmap bitmap, boolean z) {
        final ImageRequest imageRequest;
        final ImageRequest.Callback callback;
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled && callback != null) {
            final Exception exc2 = exc;
            final boolean z2 = z;
            final Bitmap bitmap2 = bitmap;
            getHandler().post(new Runnable() {
                /* class com.facebook.internal.ImageDownloader.AnonymousClass1 */

                public final void run() {
                    callback.onCompleted(new ImageResponse(imageRequest, exc2, z2, bitmap2));
                }
            });
        }
    }

    public static void readFromCache(RequestKey requestKey, Context context, boolean z) {
        InputStream inputStream;
        Uri redirectedUri;
        boolean z2 = false;
        if (!z || (redirectedUri = UrlRedirectCache.getRedirectedUri(requestKey.uri)) == null) {
            inputStream = null;
        } else {
            inputStream = ImageResponseCache.getCachedImageStream(redirectedUri, context);
            if (inputStream != null) {
                z2 = true;
            }
        }
        if (!z2) {
            inputStream = ImageResponseCache.getCachedImageStream(requestKey.uri, context);
        }
        if (inputStream != null) {
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            Utility.closeQuietly(inputStream);
            issueResponse(requestKey, null, decodeStream, z2);
            return;
        }
        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
        if (removePendingRequest != null && !removePendingRequest.isCancelled) {
            enqueueDownload(removePendingRequest.request, requestKey);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Exception] */
    /* JADX WARN: Type inference failed for: r5v2, types: [com.facebook.FacebookException] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008e, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
        r11 = null;
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a1, code lost:
        r10 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a1 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void download(RequestKey requestKey, Context context) {
        Bitmap bitmap;
        IOException iOException;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2 = null;
        boolean z = true;
        try {
            httpURLConnection = (HttpURLConnection) new URL(requestKey.uri.toString()).openConnection();
            try {
                httpURLConnection.setInstanceFollowRedirects(false);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode == 200) {
                    inputStream = ImageResponseCache.interceptAndCacheImageStream(context, httpURLConnection);
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } else if (responseCode == 301 || responseCode == 302) {
                    String headerField = httpURLConnection.getHeaderField("location");
                    if (!Utility.isNullOrEmpty(headerField)) {
                        Uri parse = Uri.parse(headerField);
                        UrlRedirectCache.cacheUriRedirect(requestKey.uri, parse);
                        DownloaderContext removePendingRequest = removePendingRequest(requestKey);
                        if (removePendingRequest != null && !removePendingRequest.isCancelled) {
                            enqueueCacheRead(removePendingRequest.request, new RequestKey(parse, requestKey.tag), false);
                        }
                    }
                    inputStream = null;
                    bitmap = null;
                    z = false;
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                    try {
                        StringBuilder sb = new StringBuilder();
                        if (inputStream != null) {
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            char[] cArr = new char[NotificationCompat.FLAG_HIGH_PRIORITY];
                            while (true) {
                                int read = inputStreamReader.read(cArr, 0, NotificationCompat.FLAG_HIGH_PRIORITY);
                                if (read <= 0) {
                                    break;
                                }
                                sb.append(cArr, 0, read);
                            }
                            Utility.closeQuietly(inputStreamReader);
                        } else {
                            sb.append("Unexpected error while downloading an image.");
                        }
                        ? facebookException = new FacebookException(sb.toString());
                        bitmap = null;
                        inputStream2 = facebookException;
                    } catch (IOException e) {
                        e = e;
                        Utility.closeQuietly(inputStream);
                        Utility.disconnectQuietly(httpURLConnection);
                        IOException iOException2 = e;
                        bitmap = null;
                        iOException = iOException2;
                        if (z) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                        Utility.closeQuietly(inputStream2);
                        Utility.disconnectQuietly(httpURLConnection);
                        throw th;
                    }
                }
                Utility.closeQuietly(inputStream);
                Utility.disconnectQuietly(httpURLConnection);
                iOException = inputStream2;
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                Utility.closeQuietly(inputStream);
                Utility.disconnectQuietly(httpURLConnection);
                IOException iOException22 = e;
                bitmap = null;
                iOException = iOException22;
                if (z) {
                }
            } catch (Throwable th2) {
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            httpURLConnection = null;
            Utility.closeQuietly(inputStream);
            Utility.disconnectQuietly(httpURLConnection);
            IOException iOException222 = e;
            bitmap = null;
            iOException = iOException222;
            if (z) {
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            Utility.closeQuietly(inputStream2);
            Utility.disconnectQuietly(httpURLConnection);
            throw th;
        }
        if (z) {
            issueResponse(requestKey, iOException, bitmap, false);
        }
    }

    private static synchronized Handler getHandler() {
        Handler handler2;
        synchronized (ImageDownloader.class) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler2 = handler;
        }
        return handler2;
    }

    private static DownloaderContext removePendingRequest(RequestKey requestKey) {
        DownloaderContext remove;
        synchronized (pendingRequests) {
            remove = pendingRequests.remove(requestKey);
        }
        return remove;
    }

    static class RequestKey {
        Object tag;
        Uri uri;

        RequestKey(Uri uri2, Object obj) {
            this.uri = uri2;
            this.tag = obj;
        }

        public int hashCode() {
            return ((this.uri.hashCode() + 1073) * 37) + this.tag.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RequestKey)) {
                return false;
            }
            RequestKey requestKey = (RequestKey) obj;
            if (requestKey.uri == this.uri && requestKey.tag == this.tag) {
                return true;
            }
            return false;
        }
    }

    static class DownloaderContext {
        boolean isCancelled;
        ImageRequest request;
        WorkQueue.WorkItem workItem;

        private DownloaderContext() {
        }
    }

    static class CacheReadWorkItem implements Runnable {
        private boolean allowCachedRedirects;
        private Context context;
        private RequestKey key;

        CacheReadWorkItem(Context context2, RequestKey requestKey, boolean z) {
            this.context = context2;
            this.key = requestKey;
            this.allowCachedRedirects = z;
        }

        public void run() {
            ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
        }
    }

    static class DownloadImageWorkItem implements Runnable {
        private Context context;
        private RequestKey key;

        DownloadImageWorkItem(Context context2, RequestKey requestKey) {
            this.context = context2;
            this.key = requestKey;
        }

        public void run() {
            ImageDownloader.download(this.key, this.context);
        }
    }
}
