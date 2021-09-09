package com.xiaomi.infra.galaxy.fds.android;

import _m_j.dvz;
import java.util.concurrent.ThreadFactory;

public class GalaxyFDSClientImpl$1 implements ThreadFactory {
    final /* synthetic */ dvz this$0;

    public GalaxyFDSClientImpl$1(dvz dvz) {
        this.this$0 = dvz;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "FDS-multipart-upload-thread");
    }
}
