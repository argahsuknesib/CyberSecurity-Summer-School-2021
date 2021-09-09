package com.facebook.share.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

@Deprecated
final class LikeStatusClient extends PlatformServiceClient {
    private String objectId;

    LikeStatusClient(Context context, String str, String str2) {
        super(context, 65542, 65543, 20141001, str);
        this.objectId = str2;
    }

    public final void populateRequestBundle(Bundle bundle) {
        bundle.putString("com.facebook.platform.extra.OBJECT_ID", this.objectId);
    }
}
