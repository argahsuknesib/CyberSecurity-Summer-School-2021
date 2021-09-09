package com.miui.tsmclient.model;

import com.miui.tsmclient.util.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f3877a;
    private int b;
    private final Map<String, i> c = new ConcurrentHashMap();
    private final Map<String, List<i>> d = new HashMap();
    private final Map<String, List<Future>> e = new HashMap();
    private ExecutorService f = Executors.newFixedThreadPool(2);

    private e() {
    }

    public static synchronized e a() {
        e eVar;
        synchronized (e.class) {
            if (f3877a == null) {
                f3877a = new e();
            }
            eVar = f3877a;
        }
        return eVar;
    }

    private static synchronized void b() {
        synchronized (e.class) {
            f3877a = null;
        }
    }

    public i a(String str, String str2) {
        i iVar;
        synchronized (this.c) {
            if (this.c.containsKey(str2)) {
                iVar = this.c.get(str2);
            } else {
                i a2 = g.a(str2);
                this.c.put(str2, a2);
                iVar = a2;
            }
        }
        synchronized (this.d) {
            List list = this.d.get(str);
            if (list == null) {
                list = new ArrayList();
                this.d.put(str, list);
                this.b++;
            }
            list.add(iVar);
        }
        return iVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        return;
     */
    public void a(String str) {
        synchronized (this.e) {
            if (this.e.containsKey(str)) {
                List<Future> list = this.e.get(str);
                if (list != null) {
                    for (Future cancel : list) {
                        cancel.cancel(true);
                    }
                }
                this.e.remove(str);
            }
        }
        synchronized (this.d) {
            if (!this.d.containsKey(str)) {
                LogUtils.d("tag:" + str + " never used, so return.");
                return;
            }
            List<i> list2 = this.d.get(str);
            if (list2 != null && !list2.isEmpty()) {
                for (i a2 : list2) {
                    a2.a();
                }
            }
            this.d.remove(str);
            this.b--;
            if (this.b == 0) {
                LogUtils.d("card executor has no reference, so shutdown");
                this.f.shutdownNow();
                this.c.clear();
                this.d.clear();
                b();
            }
        }
    }
}
