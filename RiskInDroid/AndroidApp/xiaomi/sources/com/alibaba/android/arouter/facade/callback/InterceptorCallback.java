package com.alibaba.android.arouter.facade.callback;

import com.alibaba.android.arouter.facade.Postcard;

public interface InterceptorCallback {
    void onContinue(Postcard postcard);

    void onInterrupt(Throwable th);
}
