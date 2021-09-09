package com.xiaomi.utils.conf;

import _m_j.iap;
import java.util.concurrent.Callable;

public class ConfigFactory$1 implements Callable<Object> {
    final /* synthetic */ Class val$clazz;

    ConfigFactory$1(Class cls) {
        this.val$clazz = cls;
    }

    public final Object call() throws Exception {
        return iap.O000000o(this.val$clazz);
    }
}
