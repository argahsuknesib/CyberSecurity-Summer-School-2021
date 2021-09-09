package io.realm;

import _m_j.irf;
import _m_j.irg;
import _m_j.irn;
import _m_j.irp;
import _m_j.irq;
import _m_j.isd;
import com.tencent.mmkv.MMKVRecoverStrategic;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import io.realm.internal.Util;
import io.realm.log.RealmLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RealmCache {
    public static final Collection<RealmCache> O00000o0 = new ConcurrentLinkedQueue();
    private static final List<WeakReference<RealmCache>> O00000oo = new ArrayList();

    /* renamed from: O000000o  reason: collision with root package name */
    public irp f15334O000000o;
    public final AtomicBoolean O00000Oo = new AtomicBoolean(false);
    private final EnumMap<RealmCacheType, O00000Oo> O00000o;
    private final String O00000oO;

    public interface O000000o {
        void O000000o(int i);
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final ThreadLocal<irf> f15336O000000o;
        public final ThreadLocal<Integer> O00000Oo;
        public int O00000o0;

        private O00000Oo() {
            this.f15336O000000o = new ThreadLocal<>();
            this.O00000Oo = new ThreadLocal<>();
            this.O00000o0 = 0;
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }

    enum RealmCacheType {
        TYPED_REALM,
        DYNAMIC_REALM;

        static RealmCacheType valueOf(Class<? extends irf> cls) {
            if (cls == irn.class) {
                return TYPED_REALM;
            }
            if (cls == irg.class) {
                return DYNAMIC_REALM;
            }
            throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
     arg types: [io.realm.RealmCache$RealmCacheType, io.realm.RealmCache$O00000Oo]
     candidates:
      ClspMth{java.util.EnumMap.put(java.lang.Object, java.lang.Object):java.lang.Object}
      ClspMth{java.util.AbstractMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.Map.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V}
      ClspMth{java.util.EnumMap.put(com.tencent.mmkv.MMKVRecoverStrategic, java.lang.Integer):V} */
    private RealmCache(String str) {
        this.O00000oO = str;
        this.O00000o = new EnumMap<>(RealmCacheType.class);
        for (RealmCacheType realmCacheType : RealmCacheType.values()) {
            this.O00000o.put((MMKVRecoverStrategic) realmCacheType, (Integer) new O00000Oo((byte) 0));
        }
    }

    private static RealmCache O000000o(String str, boolean z) {
        RealmCache realmCache;
        synchronized (O00000oo) {
            Iterator<WeakReference<RealmCache>> it = O00000oo.iterator();
            realmCache = null;
            while (it.hasNext()) {
                RealmCache realmCache2 = (RealmCache) it.next().get();
                if (realmCache2 == null) {
                    it.remove();
                } else if (realmCache2.O00000oO.equals(str)) {
                    realmCache = realmCache2;
                }
            }
            if (realmCache == null && z) {
                realmCache = new RealmCache(str);
                O00000oo.add(new WeakReference(realmCache));
            }
        }
        return realmCache;
    }

    private synchronized <E extends irf> E O00000Oo(irp irp, Class<E> cls) {
        O00000Oo o00000Oo;
        Object obj;
        o00000Oo = this.O00000o.get(RealmCacheType.valueOf(cls));
        if (O000000o() == 0) {
            OsSharedRealm osSharedRealm = null;
            File file = Util.O000000o(irp.O00000oo) ^ true ? new File(irp.O00000o0, irp.O00000o) : null;
            isd.O000000o(false);
            boolean z = !Util.O000000o((String) null);
            if (file != null || z) {
                OsObjectStore.O000000o(irp, new Runnable(file, irp, z, null) {
                    /* class io.realm.RealmCache.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ File f15335O000000o;
                    final /* synthetic */ irp O00000Oo;
                    final /* synthetic */ String O00000o = null;
                    final /* synthetic */ boolean O00000o0;

                    {
                        this.f15335O000000o = r1;
                        this.O00000Oo = r2;
                        this.O00000o0 = r3;
                    }

                    public final void run() {
                        if (this.f15335O000000o != null) {
                            RealmCache.O000000o(this.O00000Oo.O00000oo, this.f15335O000000o);
                        }
                        if (this.O00000o0) {
                            isd.O000000o(false);
                            RealmCache.O000000o(this.O00000o, new File((String) null));
                        }
                    }
                });
            }
            if (new File(irp.O00000oO).exists()) {
                try {
                    osSharedRealm = OsSharedRealm.getInstance(irp);
                    Table.O000000o(osSharedRealm);
                } catch (Throwable th) {
                    if (osSharedRealm != null) {
                        osSharedRealm.close();
                    }
                    throw th;
                }
            }
            if (osSharedRealm != null) {
                osSharedRealm.close();
            }
            this.f15334O000000o = irp;
        } else if (!this.f15334O000000o.equals(irp)) {
            if (Arrays.equals(this.f15334O000000o.O000000o(), irp.O000000o())) {
                irq irq = irp.O0000OOo;
                irq irq2 = this.f15334O000000o.O0000OOo;
                if (irq2 == null || irq == null || !irq2.getClass().equals(irq.getClass()) || irq.equals(irq2)) {
                    throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. \nCached configuration: \n" + this.f15334O000000o + "\n\nNew configuration: \n" + irp);
                }
                throw new IllegalArgumentException("Configurations cannot be different if used to open the same file. The most likely cause is that equals() and hashCode() are not overridden in the migration class: " + irp.O0000OOo.getClass().getCanonicalName());
            }
            throw new IllegalArgumentException("Wrong key used to decrypt Realm.");
        }
        if (o00000Oo.f15336O000000o.get() == null) {
            if (cls == irn.class) {
                obj = irn.O000000o(this);
            } else if (cls == irg.class) {
                obj = irg.O000000o(this);
            } else {
                throw new IllegalArgumentException("The type of Realm class must be Realm or DynamicRealm.");
            }
            o00000Oo.f15336O000000o.set(obj);
            o00000Oo.O00000Oo.set(0);
            o00000Oo.O00000o0++;
        }
        o00000Oo.O00000Oo.set(Integer.valueOf(o00000Oo.O00000Oo.get().intValue() + 1));
        return (irf) o00000Oo.f15336O000000o.get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        return;
     */
    public final synchronized void O000000o(irf irf) {
        String O00000oO2 = irf.O00000oO();
        O00000Oo o00000Oo = this.O00000o.get(RealmCacheType.valueOf((Class<? extends irf>) irf.getClass()));
        Integer num = o00000Oo.O00000Oo.get();
        if (num == null) {
            num = 0;
        }
        if (num.intValue() <= 0) {
            RealmLog.O000000o("%s has been closed already. refCount is %s", O00000oO2, num);
            return;
        }
        Integer valueOf = Integer.valueOf(num.intValue() - 1);
        if (valueOf.intValue() == 0) {
            o00000Oo.O00000Oo.set(null);
            o00000Oo.f15336O000000o.set(null);
            o00000Oo.O00000o0--;
            if (o00000Oo.O00000o0 >= 0) {
                irf.O00000oo();
                if (O000000o() == 0) {
                    this.f15334O000000o = null;
                    isd.O000000o(false);
                }
            } else {
                throw new IllegalStateException("Global reference counter of Realm" + O00000oO2 + " got corrupted.");
            }
        } else {
            o00000Oo.O00000Oo.set(valueOf);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: io.realm.RealmCache.O000000o(java.lang.String, boolean):io.realm.RealmCache
     arg types: [java.lang.String, int]
     candidates:
      io.realm.RealmCache.O000000o(_m_j.irp, java.lang.Class):E
      io.realm.RealmCache.O000000o(_m_j.irp, io.realm.RealmCache$O000000o):void
      io.realm.RealmCache.O000000o(java.lang.String, java.io.File):void
      io.realm.RealmCache.O000000o(java.lang.String, boolean):io.realm.RealmCache */
    public static void O000000o(irp irp, O000000o o000000o) {
        synchronized (O00000oo) {
            RealmCache O000000o2 = O000000o(irp.O00000oO, false);
            if (O000000o2 == null) {
                o000000o.O000000o(0);
            } else {
                O000000o2.O000000o(o000000o);
            }
        }
    }

    private synchronized void O000000o(O000000o o000000o) {
        o000000o.O000000o(O000000o());
    }

    /* JADX INFO: additional move instructions added (2) to help type inference */
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007a A[SYNTHETIC, Splitter:B:48:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0081 A[SYNTHETIC, Splitter:B:52:0x0081] */
    public static void O000000o(java.lang.String r5, java.io.File r6) {
        /*
            boolean r0 = r6.exists()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            android.content.Context r1 = _m_j.irf.f1580O000000o     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            java.io.InputStream r1 = r1.open(r5)     // Catch:{ IOException -> 0x0061, all -> 0x005e }
            if (r1 == 0) goto L_0x004c
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r6 = 4096(0x1000, float:5.74E-42)
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
        L_0x001d:
            int r3 = r1.read(r6)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            if (r3 < 0) goto L_0x0028
            r4 = 0
            r2.write(r6, r4, r3)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
            goto L_0x001d
        L_0x0028:
            if (r1 == 0) goto L_0x002f
            r1.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x002f
        L_0x002e:
            r0 = move-exception
        L_0x002f:
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r5 = move-exception
            if (r0 != 0) goto L_0x0037
            r0 = r5
        L_0x0037:
            if (r0 != 0) goto L_0x003a
            return
        L_0x003a:
            io.realm.exceptions.RealmFileException r5 = new io.realm.exceptions.RealmFileException
            io.realm.exceptions.RealmFileException$Kind r6 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR
            r5.<init>(r6, r0)
            throw r5
        L_0x0042:
            r5 = move-exception
            goto L_0x0077
        L_0x0044:
            r6 = move-exception
            goto L_0x004a
        L_0x0046:
            r5 = move-exception
            goto L_0x0078
        L_0x0048:
            r6 = move-exception
            r2 = r0
        L_0x004a:
            r0 = r1
            goto L_0x0063
        L_0x004c:
            io.realm.exceptions.RealmFileException r6 = new io.realm.exceptions.RealmFileException     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            io.realm.exceptions.RealmFileException$Kind r2 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.lang.String r3 = "Invalid input stream to the asset file: "
            java.lang.String r4 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r6.<init>(r2, r3)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            throw r6     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
        L_0x005e:
            r5 = move-exception
            r1 = r0
            goto L_0x0078
        L_0x0061:
            r6 = move-exception
            r2 = r0
        L_0x0063:
            io.realm.exceptions.RealmFileException r1 = new io.realm.exceptions.RealmFileException     // Catch:{ all -> 0x0075 }
            io.realm.exceptions.RealmFileException$Kind r3 = io.realm.exceptions.RealmFileException.Kind.ACCESS_ERROR     // Catch:{ all -> 0x0075 }
            java.lang.String r4 = "Could not resolve the path to the asset file: "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = r4.concat(r5)     // Catch:{ all -> 0x0075 }
            r1.<init>(r3, r5, r6)     // Catch:{ all -> 0x0075 }
            throw r1     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r5 = move-exception
            r1 = r0
        L_0x0077:
            r0 = r2
        L_0x0078:
            if (r1 == 0) goto L_0x007f
            r1.close()     // Catch:{ IOException -> 0x007e }
            goto L_0x007f
        L_0x007e:
        L_0x007f:
            if (r0 == 0) goto L_0x0084
            r0.close()     // Catch:{ IOException -> 0x0084 }
        L_0x0084:
            goto L_0x0086
        L_0x0085:
            throw r5
        L_0x0086:
            goto L_0x0085
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.RealmCache.O000000o(java.lang.String, java.io.File):void");
    }

    private int O000000o() {
        int i = 0;
        for (O00000Oo o00000Oo : this.O00000o.values()) {
            i += o00000Oo.O00000o0;
        }
        return i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: io.realm.RealmCache.O000000o(java.lang.String, boolean):io.realm.RealmCache
     arg types: [java.lang.String, int]
     candidates:
      io.realm.RealmCache.O000000o(_m_j.irp, java.lang.Class):E
      io.realm.RealmCache.O000000o(_m_j.irp, io.realm.RealmCache$O000000o):void
      io.realm.RealmCache.O000000o(java.lang.String, java.io.File):void
      io.realm.RealmCache.O000000o(java.lang.String, boolean):io.realm.RealmCache */
    public static <E extends irf> E O000000o(irp irp, Class cls) {
        return O000000o(irp.O00000oO, true).O00000Oo(irp, cls);
    }
}
