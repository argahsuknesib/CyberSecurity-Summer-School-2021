package com.alibaba.android.arouter.facade.template;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;

public interface IInterceptor extends IProvider {
    void process(Postcard postcard, InterceptorCallback interceptorCallback);
}
