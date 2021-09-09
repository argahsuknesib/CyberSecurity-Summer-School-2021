package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface AutowiredService extends IProvider {
    void autowire(Object obj);
}
