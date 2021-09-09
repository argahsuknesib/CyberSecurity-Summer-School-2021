package com.xiaomi.miot.localtranslatesrv.database;

public interface DatabaseExecutorBuilder {
    DatabaseExecutor createExecutor() throws Exception;
}
