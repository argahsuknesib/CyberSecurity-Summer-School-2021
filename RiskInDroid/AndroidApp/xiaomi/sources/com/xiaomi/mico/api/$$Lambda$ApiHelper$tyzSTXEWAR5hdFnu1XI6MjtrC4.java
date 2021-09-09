package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.UserProfile;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$tyzSTXE-WAR5hdFnu1XI6MjtrC4  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$tyzSTXEWAR5hdFnu1XI6MjtrC4 implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$ApiHelper$tyzSTXEWAR5hdFnu1XI6MjtrC4 INSTANCE = new $$Lambda$ApiHelper$tyzSTXEWAR5hdFnu1XI6MjtrC4();

    private /* synthetic */ $$Lambda$ApiHelper$tyzSTXEWAR5hdFnu1XI6MjtrC4() {
    }

    public final Observable observable(Object obj) {
        return ((UserProfile) obj).getMusicSource();
    }
}
