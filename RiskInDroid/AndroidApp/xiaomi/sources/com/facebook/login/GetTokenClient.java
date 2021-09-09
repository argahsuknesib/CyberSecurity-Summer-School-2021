package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient;

final class GetTokenClient extends PlatformServiceClient {
    public final void populateRequestBundle(Bundle bundle) {
    }

    GetTokenClient(Context context, String str) {
        super(context, 65536, 65537, 20121101, str);
    }
}
