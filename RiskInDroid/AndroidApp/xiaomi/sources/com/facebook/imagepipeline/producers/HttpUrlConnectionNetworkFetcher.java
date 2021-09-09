package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class HttpUrlConnectionNetworkFetcher extends BaseNetworkFetcher<FetchState> {
    private final ExecutorService mExecutorService;
    private int mHttpConnectionTimeout;

    private static boolean isHttpRedirect(int i) {
        if (i == 307 || i == 308) {
            return true;
        }
        switch (i) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    private static boolean isHttpSuccess(int i) {
        return i >= 200 && i < 300;
    }

    public HttpUrlConnectionNetworkFetcher() {
        this(Executors.newFixedThreadPool(3));
    }

    public HttpUrlConnectionNetworkFetcher(int i) {
        this(Executors.newFixedThreadPool(3));
        this.mHttpConnectionTimeout = i;
    }

    @VisibleForTesting
    HttpUrlConnectionNetworkFetcher(ExecutorService executorService) {
        this.mExecutorService = executorService;
    }

    public FetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new FetchState(consumer, producerContext);
    }

    public void fetch(final FetchState fetchState, final NetworkFetcher.Callback callback) {
        final Future<?> submit = this.mExecutorService.submit(new Runnable() {
            /* class com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.AnonymousClass1 */

            public void run() {
                HttpUrlConnectionNetworkFetcher.this.fetchSync(fetchState, callback);
            }
        });
        fetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher.AnonymousClass2 */

            public void onCancellationRequested() {
                if (submit.cancel(false)) {
                    callback.onCancellation();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003c A[SYNTHETIC, Splitter:B:28:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0043  */
    @VisibleForTesting
    public void fetchSync(FetchState fetchState, NetworkFetcher.Callback callback) {
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        try {
            httpURLConnection = downloadFrom(fetchState.getUri(), 5);
            if (httpURLConnection != null) {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    callback.onResponse(inputStream, -1);
                } catch (IOException e) {
                    e = e;
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
            try {
                callback.onFailure(e);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                th = th;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
            if (inputStream != null) {
            }
            if (httpURLConnection != null) {
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    private HttpURLConnection downloadFrom(Uri uri, int i) throws IOException {
        Uri uri2;
        String str;
        while (true) {
            HttpURLConnection openConnectionTo = openConnectionTo(uri);
            openConnectionTo.setConnectTimeout(this.mHttpConnectionTimeout);
            int responseCode = openConnectionTo.getResponseCode();
            if (isHttpSuccess(responseCode)) {
                return openConnectionTo;
            }
            if (isHttpRedirect(responseCode)) {
                String headerField = openConnectionTo.getHeaderField("Location");
                openConnectionTo.disconnect();
                if (headerField == null) {
                    uri2 = null;
                } else {
                    uri2 = Uri.parse(headerField);
                }
                String scheme = uri.getScheme();
                if (i > 0 && uri2 != null && !uri2.getScheme().equals(scheme)) {
                    i--;
                    uri = uri2;
                } else if (i != 0) {
                    str = error("URL %s follows too many redirects", uri.toString());
                } else {
                    str = error("URL %s returned %d without a valid redirect", uri.toString(), Integer.valueOf(responseCode));
                }
            } else {
                openConnectionTo.disconnect();
                throw new IOException(String.format("Image URL %s returned HTTP code %d", uri.toString(), Integer.valueOf(responseCode)));
            }
        }
        if (i != 0) {
        }
        throw new IOException(str);
    }

    @VisibleForTesting
    static HttpURLConnection openConnectionTo(Uri uri) throws IOException {
        return (HttpURLConnection) UriUtil.uriToUrl(uri).openConnection();
    }

    private static String error(String str, Object... objArr) {
        return String.format(Locale.getDefault(), str, objArr);
    }
}
