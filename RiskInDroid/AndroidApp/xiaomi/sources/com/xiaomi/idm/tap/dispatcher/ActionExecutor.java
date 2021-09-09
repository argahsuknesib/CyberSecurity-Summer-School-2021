package com.xiaomi.idm.tap.dispatcher;

public interface ActionExecutor {
    void close();

    boolean execute();
}
