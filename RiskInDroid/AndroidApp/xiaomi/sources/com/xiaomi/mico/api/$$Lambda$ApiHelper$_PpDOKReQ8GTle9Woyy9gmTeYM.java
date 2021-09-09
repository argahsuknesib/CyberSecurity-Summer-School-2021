package com.xiaomi.mico.api;

import com.xiaomi.mico.api.service.UserProfile;
import rx.Observable;

/* renamed from: com.xiaomi.mico.api.-$$Lambda$ApiHelper$_PpDOKReQ8-GTle9Woyy9gmTeYM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ApiHelper$_PpDOKReQ8GTle9Woyy9gmTeYM implements ApiProviderV2 {
    public static final /* synthetic */ $$Lambda$ApiHelper$_PpDOKReQ8GTle9Woyy9gmTeYM INSTANCE = new $$Lambda$ApiHelper$_PpDOKReQ8GTle9Woyy9gmTeYM();

    private /* synthetic */ $$Lambda$ApiHelper$_PpDOKReQ8GTle9Woyy9gmTeYM() {
    }

    public final Observable observable(Object obj) {
        return ((UserProfile) obj).getChildrenProfile();
    }
}
