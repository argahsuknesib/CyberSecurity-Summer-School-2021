package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IProvider;

public interface InterceptorService extends IProvider {
    void doInterceptions(Postcard postcard, InterceptorCallback interceptorCallback);
}
