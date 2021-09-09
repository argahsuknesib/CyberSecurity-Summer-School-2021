package com.xiaomi.mico.api;

import com.xiaomi.mico.api.model.MinaResponse;
import retrofit2.Response;
import rx.Observable;

public interface ApiProviderV2<T, S> {
    Observable<Response<MinaResponse<T>>> observable(Object obj);
}
