package com.xiaomi.youpin.common.thread;

import _m_j.ibe;
import java.util.concurrent.Executor;

public class Executors$1 implements Executor {
    public final void execute(Runnable runnable) {
        ibe.O00000Oo.post(runnable);
    }
}
