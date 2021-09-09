package com.google.android.gms.common.server.response;

import com.google.android.gms.common.server.response.FastJsonResponse;

public interface PostProcessor<T extends FastJsonResponse> {
    T postProcess(T t);
}
