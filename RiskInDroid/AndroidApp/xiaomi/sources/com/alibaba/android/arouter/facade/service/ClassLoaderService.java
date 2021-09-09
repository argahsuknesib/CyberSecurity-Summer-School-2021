package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface ClassLoaderService extends IProvider {
    Class<?> forName();
}
