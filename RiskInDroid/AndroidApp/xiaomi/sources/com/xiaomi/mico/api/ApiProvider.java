package com.xiaomi.mico.api;

import com.xiaomi.mico.api.model.MinaResponse;
import com.xiaomi.mico.api.service.MinaService;
import retrofit2.Response;
import rx.Observable;

public interface ApiProvider<T> {
    Observable<Response<MinaResponse<T>>> observable(MinaService minaService);
}
