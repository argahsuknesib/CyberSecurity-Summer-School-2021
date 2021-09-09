package com.xiaomi.smarthome.device.api.spec.operation;

import java.util.List;

public interface ActionListener {
    void onFail(int i);

    void onSuccess(List<Object> list);
}
