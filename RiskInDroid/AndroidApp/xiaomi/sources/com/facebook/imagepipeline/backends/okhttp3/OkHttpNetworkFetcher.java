package com.facebook.imagepipeline.backends.okhttp3;

import android.os.Looper;
import android.os.SystemClock;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.BaseNetworkFetcher;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.FetchState;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpNetworkFetcher extends BaseNetworkFetcher<OkHttpNetworkFetchState> {
    private final Call.Factory mCallFactory;
    public Executor mCancellationExecutor;

    public static class OkHttpNetworkFetchState extends FetchState {
        public long fetchCompleteTime;
        public long responseTime;
        public long submitTime;

        public OkHttpNetworkFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
            super(consumer, producerContext);
        }
    }

    public OkHttpNetworkFetcher(OkHttpClient okHttpClient) {
        this(okHttpClient, okHttpClient.dispatcher().executorService());
    }

    public OkHttpNetworkFetcher(Call.Factory factory, Executor executor) {
        this.mCallFactory = factory;
        this.mCancellationExecutor = executor;
    }

    public OkHttpNetworkFetchState createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext) {
        return new OkHttpNetworkFetchState(consumer, producerContext);
    }

    public void fetch(OkHttpNetworkFetchState okHttpNetworkFetchState, NetworkFetcher.Callback callback) {
        okHttpNetworkFetchState.submitTime = SystemClock.elapsedRealtime();
        try {
            Request.Builder builder = new Request.Builder().cacheControl(new CacheControl.Builder().noStore().build()).url(okHttpNetworkFetchState.getUri().toString()).get();
            BytesRange bytesRange = okHttpNetworkFetchState.getContext().getImageRequest().getBytesRange();
            if (bytesRange != null) {
                builder.addHeader("Range", bytesRange.toHttpRangeHeaderValue());
            }
            fetchWithRequest(okHttpNetworkFetchState, callback, builder.build());
        } catch (Exception e) {
            callback.onFailure(e);
        }
    }

    public void onFetchCompletion(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        okHttpNetworkFetchState.fetchCompleteTime = SystemClock.elapsedRealtime();
    }

    public Map<String, String> getExtraMap(OkHttpNetworkFetchState okHttpNetworkFetchState, int i) {
        HashMap hashMap = new HashMap(4);
        hashMap.put("queue_time", Long.toString(okHttpNetworkFetchState.responseTime - okHttpNetworkFetchState.submitTime));
        hashMap.put("fetch_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.responseTime));
        hashMap.put("total_time", Long.toString(okHttpNetworkFetchState.fetchCompleteTime - okHttpNetworkFetchState.submitTime));
        hashMap.put("image_size", Integer.toString(i));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void fetchWithRequest(final OkHttpNetworkFetchState okHttpNetworkFetchState, final NetworkFetcher.Callback callback, Request request) {
        final Call newCall = this.mCallFactory.newCall(request);
        okHttpNetworkFetchState.getContext().addCallbacks(new BaseProducerContextCallbacks() {
            /* class com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.AnonymousClass1 */

            public void onCancellationRequested() {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    newCall.cancel();
                } else {
                    OkHttpNetworkFetcher.this.mCancellationExecutor.execute(new Runnable() {
                        /* class com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            newCall.cancel();
                        }
                    });
                }
            }
        });
        newCall.enqueue(new Callback() {
            /* class com.facebook.imagepipeline.backends.okhttp3.OkHttpNetworkFetcher.AnonymousClass2 */

            public void onResponse(Call call, Response response) throws IOException {
                okHttpNetworkFetchState.responseTime = SystemClock.elapsedRealtime();
                ResponseBody body = response.body();
                try {
                    if (!response.isSuccessful()) {
                        OkHttpNetworkFetcher.this.handleException(call, new IOException("Unexpected HTTP code ".concat(String.valueOf(response))), callback);
                        return;
                    }
                    BytesRange fromContentRangeHeader = BytesRange.fromContentRangeHeader(response.header("Content-Range"));
                    if (!(fromContentRangeHeader == null || (fromContentRangeHeader.from == 0 && fromContentRangeHeader.to == Integer.MAX_VALUE))) {
                        okHttpNetworkFetchState.setResponseBytesRange(fromContentRangeHeader);
                        okHttpNetworkFetchState.setOnNewResultStatusFlags(8);
                    }
                    long contentLength = body.contentLength();
                    if (contentLength < 0) {
                        contentLength = 0;
                    }
                    callback.onResponse(body.byteStream(), (int) contentLength);
                    body.close();
                } catch (Exception e) {
                    OkHttpNetworkFetcher.this.handleException(call, e, callback);
                } finally {
                    body.close();
                }
            }

            public void onFailure(Call call, IOException iOException) {
                OkHttpNetworkFetcher.this.handleException(call, iOException, callback);
            }
        });
    }

    public void handleException(Call call, Exception exc, NetworkFetcher.Callback callback) {
        if (call.isCanceled()) {
            callback.onCancellation();
        } else {
            callback.onFailure(exc);
        }
    }
}
