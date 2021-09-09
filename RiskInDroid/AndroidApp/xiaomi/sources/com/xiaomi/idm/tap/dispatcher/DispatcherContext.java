package com.xiaomi.idm.tap.dispatcher;

public interface DispatcherContext {
    <T> T getParamValue(String str);
}
