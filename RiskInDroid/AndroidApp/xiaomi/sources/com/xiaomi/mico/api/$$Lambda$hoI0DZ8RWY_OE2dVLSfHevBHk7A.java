package com.xiaomi.mico.api;

import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.ObservableApiHelper;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A implements ObservableApiHelper.ApiRequestProvider {
    public static final /* synthetic */ $$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A INSTANCE = new $$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A();

    private /* synthetic */ $$Lambda$hoI0DZ8RWY_OE2dVLSfHevBHk7A() {
    }

    public final ApiRequest getApiRequest(ApiRequest.Listener listener) {
        return RecentPlayApiHelper.getRecentPlay(listener);
    }
}
