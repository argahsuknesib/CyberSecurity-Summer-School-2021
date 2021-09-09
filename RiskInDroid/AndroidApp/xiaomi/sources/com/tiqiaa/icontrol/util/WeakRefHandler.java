package com.tiqiaa.icontrol.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class WeakRefHandler {
    public static List<WeakReference<Object>> bitmapWeakRefList;
    private static Thread cleanThread;
    public static boolean stop;

    static {
        init();
    }

    private static void init() {
        stop = false;
        if (bitmapWeakRefList == null) {
            bitmapWeakRefList = new ArrayList();
        }
        if (cleanThread == null) {
            Thread thread = new Thread(new Runnable() {
                /* class com.tiqiaa.icontrol.util.WeakRefHandler.AnonymousClass1 */

                public void run() {
                    while (!WeakRefHandler.stop) {
                        if (WeakRefHandler.bitmapWeakRefList.size() > 5) {
                            WeakRefHandler.clear();
                        }
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            cleanThread = thread;
            thread.start();
        }
    }

    public static void add(Object obj) {
        if (bitmapWeakRefList == null || cleanThread == null) {
            init();
        }
        bitmapWeakRefList.add(new WeakReference(obj));
    }

    public static synchronized void clear() {
        synchronized (WeakRefHandler.class) {
            int i = 0;
            for (int size = bitmapWeakRefList.size() - 1; size >= 0; size--) {
                WeakReference weakReference = bitmapWeakRefList.get(size);
                if (weakReference == null || weakReference.get() == null) {
                    bitmapWeakRefList.remove(size);
                } else {
                    i++;
                }
            }
            LogUtil.e("WeakRefHandler", "notRecycled count = ".concat(String.valueOf(i)));
            System.gc();
        }
    }

    public static void stop() {
        stop = true;
    }
}
