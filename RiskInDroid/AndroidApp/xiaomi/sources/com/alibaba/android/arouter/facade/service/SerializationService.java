package com.alibaba.android.arouter.facade.service;

import com.alibaba.android.arouter.facade.template.IProvider;
import java.lang.reflect.Type;

public interface SerializationService extends IProvider {
    @Deprecated
    <T> T json2Object(String str, Class<T> cls);

    String object2Json(Object obj);

    <T> T parseObject(String str, Type type);
}
