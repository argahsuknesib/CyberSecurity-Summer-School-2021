package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

public interface NavigationCallback {
    void onArrival(Postcard postcard);

    void onFound(Postcard postcard);

    void onInterrupt(Postcard postcard);

    void onLost(Postcard postcard);
}
