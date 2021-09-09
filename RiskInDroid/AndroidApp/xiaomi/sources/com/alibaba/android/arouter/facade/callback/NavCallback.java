package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

public abstract class NavCallback implements NavigationCallback {
    public abstract void onArrival(Postcard postcard);

    public void onFound(Postcard postcard) {
    }

    public void onInterrupt(Postcard postcard) {
    }

    public void onLost(Postcard postcard) {
    }
}
