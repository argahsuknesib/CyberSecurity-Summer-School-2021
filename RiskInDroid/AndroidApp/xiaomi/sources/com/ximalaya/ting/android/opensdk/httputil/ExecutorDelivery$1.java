package com.ximalaya.ting.android.opensdk.httputil;

import _m_j.ijb;
import android.os.Handler;
import java.util.concurrent.Executor;

public class ExecutorDelivery$1 implements Executor {
    final /* synthetic */ ijb this$0;
    final /* synthetic */ Handler val$handler;

    public ExecutorDelivery$1(ijb ijb, Handler handler) {
        this.this$0 = ijb;
        this.val$handler = handler;
    }

    public void execute(Runnable runnable) {
        this.val$handler.post(runnable);
    }
}
