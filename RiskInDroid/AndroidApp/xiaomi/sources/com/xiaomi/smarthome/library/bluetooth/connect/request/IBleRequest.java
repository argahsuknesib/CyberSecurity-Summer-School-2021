package com.xiaomi.smarthome.library.bluetooth.connect.request;

import com.xiaomi.smarthome.library.bluetooth.connect.IBleConnectDispatcher;

public interface IBleRequest {
    void cancel();

    void process(IBleConnectDispatcher iBleConnectDispatcher);
}
