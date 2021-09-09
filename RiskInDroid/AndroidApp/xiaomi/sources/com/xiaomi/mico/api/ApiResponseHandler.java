package com.xiaomi.mico.api;

import rx.Scheduler;

interface ApiResponseHandler {
    void cancel(ApiRequest apiRequest);

    Scheduler getScheduler();

    void retry(ApiRequest apiRequest);
}
