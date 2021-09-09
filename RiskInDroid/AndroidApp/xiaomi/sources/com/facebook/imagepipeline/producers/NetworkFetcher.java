package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.FetchState;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface NetworkFetcher<FETCH_STATE extends FetchState> {

    public interface Callback {
        void onCancellation();

        void onFailure(Throwable th);

        void onResponse(InputStream inputStream, int i) throws IOException;
    }

    FETCH_STATE createFetchState(Consumer<EncodedImage> consumer, ProducerContext producerContext);

    void fetch(FetchState fetchState, Callback callback);

    Map<String, String> getExtraMap(FetchState fetchState, int i);

    void onFetchCompletion(FetchState fetchState, int i);

    boolean shouldPropagate(FETCH_STATE fetch_state);
}
