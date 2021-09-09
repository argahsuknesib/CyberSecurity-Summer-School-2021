package com.sdu.didi.openapi.location;

import android.os.Looper;
import com.sdu.didi.openapi.location.LocationHelper;

public abstract class SdkHub {
    /* access modifiers changed from: protected */
    public abstract Location parseLocation(Object obj);

    public abstract void registListener(Looper looper, LocationHelper.LocationListener locationListener);

    public abstract void unRegistListener();
}
