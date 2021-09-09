package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.producers.FetchState;
import java.util.Map;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState> implements NetworkFetcher<FETCH_STATE> {
    public Map<String, String> getExtraMap(FetchState fetchState, int i) {
        return null;
    }

    public void onFetchCompletion(FetchState fetchState, int i) {
    }

    public boolean shouldPropagate(FETCH_STATE fetch_state) {
        return true;
    }
}
