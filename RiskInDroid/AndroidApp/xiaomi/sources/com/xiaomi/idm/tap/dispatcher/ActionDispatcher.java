package com.xiaomi.idm.tap.dispatcher;

import java.util.List;

public interface ActionDispatcher {

    public interface ActionFilter {
        List<Short> filterActions(List<Short> list);
    }

    void dispatchRawAppData(byte[] bArr, DispatcherContext dispatcherContext);

    void dispatchRawData(byte[] bArr, DispatcherContext dispatcherContext);

    void filterActions(ActionFilter actionFilter);
}
