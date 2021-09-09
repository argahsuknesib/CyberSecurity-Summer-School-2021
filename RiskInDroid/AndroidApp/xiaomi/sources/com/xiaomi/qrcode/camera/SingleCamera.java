package com.xiaomi.qrcode.camera;

import java.util.concurrent.Semaphore;

public final class SingleCamera extends Semaphore {
    private static volatile SingleCamera instance;

    private SingleCamera(int i) {
        super(i);
    }

    public static SingleCamera getInstance() {
        if (instance == null) {
            synchronized (SingleCamera.class) {
                if (instance == null) {
                    instance = new SingleCamera(1);
                }
            }
        }
        return instance;
    }
}
