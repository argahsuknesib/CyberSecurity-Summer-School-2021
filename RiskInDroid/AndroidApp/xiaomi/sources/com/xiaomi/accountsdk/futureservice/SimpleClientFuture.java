package com.xiaomi.accountsdk.futureservice;

import java.util.concurrent.ExecutionException;

public class SimpleClientFuture<DataType> extends ClientFuture<DataType, DataType> {
    /* access modifiers changed from: protected */
    public DataType convertServerDataToClientData(DataType datatype) throws Throwable {
        return datatype;
    }

    public SimpleClientFuture() {
        super(null);
    }

    public void interpretExecutionException(ExecutionException executionException) throws Exception {
        throw executionException;
    }
}
