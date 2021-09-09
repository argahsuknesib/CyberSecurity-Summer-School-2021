package com.amap.openapi;

import _m_j.qv;
import java.util.concurrent.ThreadFactory;

public class bj$2 implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ qv f3557a;

    public bj$2(qv qvVar) {
        this.f3557a = qvVar;
    }

    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, "UploadController");
    }
}
