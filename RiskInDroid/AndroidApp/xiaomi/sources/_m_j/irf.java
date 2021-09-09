package _m_j;

import _m_j.irn;
import android.content.Context;
import io.realm.RealmCache;
import io.realm.internal.CheckedRow;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.UncheckedRow;
import io.realm.internal.async.RealmThreadPoolExecutor;
import io.realm.log.RealmLog;
import java.io.Closeable;
import java.util.Collections;
import java.util.Map;

public abstract class irf implements Closeable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile Context f1580O000000o;
    static final RealmThreadPoolExecutor O00000Oo = RealmThreadPoolExecutor.newDefaultExecutor();
    public static final O00000Oo O00000oo = new O00000Oo();
    protected final irp O00000o;
    final long O00000o0;
    public OsSharedRealm O00000oO;
    private RealmCache O0000O0o;
    private boolean O0000OOo;
    private OsSharedRealm.SchemaChangedCallback O0000Oo0;

    public static final class O000000o {
    }

    public abstract irv O0000O0o();

    private irf(irp irp, OsSchemaInfo osSchemaInfo) {
        AnonymousClass3 r2;
        this.O0000Oo0 = new OsSharedRealm.SchemaChangedCallback() {
            /* class _m_j.irf.AnonymousClass1 */

            public final void onSchemaChanged() {
                irv O0000O0o = irf.this.O0000O0o();
                if (O0000O0o != null) {
                    if (O0000O0o.O00000oo != null) {
                        irx irx = O0000O0o.O00000oo;
                        for (Map.Entry next : irx.f1593O000000o.entrySet()) {
                            ish ish = irx.O00000Oo;
                            next.getKey();
                            iry O00000Oo = ish.O00000Oo();
                            iry iry = (iry) next.getValue();
                            if (!iry.O00000o0) {
                                throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
                            } else if (O00000Oo != null) {
                                iry.f1594O000000o.clear();
                                iry.f1594O000000o.putAll(O00000Oo.f1594O000000o);
                                iry.O00000Oo.clear();
                                iry.O00000Oo.putAll(O00000Oo.O00000Oo);
                            } else {
                                throw new NullPointerException("Attempt to copy null ColumnInfo");
                            }
                        }
                    }
                    O0000O0o.f1592O000000o.clear();
                    O0000O0o.O00000Oo.clear();
                    O0000O0o.O00000o0.clear();
                    O0000O0o.O00000o.clear();
                }
            }
        };
        this.O00000o0 = Thread.currentThread().getId();
        this.O00000o = irp;
        AnonymousClass2 r0 = null;
        this.O0000O0o = null;
        if (osSchemaInfo == null || irp.O0000OOo == null) {
            r2 = null;
        } else {
            final irq irq = irp.O0000OOo;
            r2 = new OsSharedRealm.MigrationCallback() {
                /* class _m_j.irf.AnonymousClass3 */

                public final void onMigrationNeeded(OsSharedRealm osSharedRealm, long j, long j2) {
                    irg.O000000o(osSharedRealm);
                }
            };
        }
        final irn.O000000o o000000o = irp.O0000Ooo;
        r0 = o000000o != null ? new OsSharedRealm.InitializationCallback() {
            /* class _m_j.irf.AnonymousClass2 */

            public final void onInit(OsSharedRealm osSharedRealm) {
                irn.O000000o(osSharedRealm);
            }
        } : r0;
        OsRealmConfig.O000000o o000000o2 = new OsRealmConfig.O000000o(irp);
        o000000o2.O00000oO = true;
        o000000o2.O00000o0 = r2;
        o000000o2.O00000Oo = osSchemaInfo;
        o000000o2.O00000o = r0;
        this.O00000oO = OsSharedRealm.getInstance(o000000o2);
        this.O0000OOo = true;
        this.O00000oO.registerSchemaChangedCallback(this.O0000Oo0);
    }

    irf(OsSharedRealm osSharedRealm) {
        this.O0000Oo0 = new OsSharedRealm.SchemaChangedCallback() {
            /* class _m_j.irf.AnonymousClass1 */

            public final void onSchemaChanged() {
                irv O0000O0o = irf.this.O0000O0o();
                if (O0000O0o != null) {
                    if (O0000O0o.O00000oo != null) {
                        irx irx = O0000O0o.O00000oo;
                        for (Map.Entry next : irx.f1593O000000o.entrySet()) {
                            ish ish = irx.O00000Oo;
                            next.getKey();
                            iry O00000Oo = ish.O00000Oo();
                            iry iry = (iry) next.getValue();
                            if (!iry.O00000o0) {
                                throw new UnsupportedOperationException("Attempt to modify an immutable ColumnInfo");
                            } else if (O00000Oo != null) {
                                iry.f1594O000000o.clear();
                                iry.f1594O000000o.putAll(O00000Oo.f1594O000000o);
                                iry.O00000Oo.clear();
                                iry.O00000Oo.putAll(O00000Oo.O00000Oo);
                            } else {
                                throw new NullPointerException("Attempt to copy null ColumnInfo");
                            }
                        }
                    }
                    O0000O0o.f1592O000000o.clear();
                    O0000O0o.O00000Oo.clear();
                    O0000O0o.O00000o0.clear();
                    O0000O0o.O00000o.clear();
                }
            }
        };
        this.O00000o0 = Thread.currentThread().getId();
        this.O00000o = osSharedRealm.getConfiguration();
        this.O0000O0o = null;
        this.O00000oO = osSharedRealm;
        this.O0000OOo = false;
    }

    public void O000000o() {
        O00000o();
        this.O00000oO.beginTransaction();
    }

    public void O00000Oo() {
        O00000o();
        this.O00000oO.commitTransaction();
    }

    public void O00000o0() {
        O00000o();
        this.O00000oO.cancelTransaction();
    }

    /* access modifiers changed from: protected */
    public final void O00000o() {
        OsSharedRealm osSharedRealm = this.O00000oO;
        if (osSharedRealm == null || osSharedRealm.isClosed()) {
            throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
        } else if (this.O00000o0 != Thread.currentThread().getId()) {
            throw new IllegalStateException("Realm access from incorrect thread. Realm objects can only be accessed on the thread they were created.");
        }
    }

    public String O00000oO() {
        return this.O00000o.O00000oO;
    }

    public void close() {
        if (this.O00000o0 == Thread.currentThread().getId()) {
            RealmCache realmCache = this.O0000O0o;
            if (realmCache != null) {
                realmCache.O000000o(this);
            } else {
                O00000oo();
            }
        } else {
            throw new IllegalStateException("Realm access from incorrect thread. Realm instance can only be closed on the thread it was created.");
        }
    }

    public final void O00000oo() {
        this.O0000O0o = null;
        OsSharedRealm osSharedRealm = this.O00000oO;
        if (osSharedRealm != null && this.O0000OOo) {
            osSharedRealm.close();
            this.O00000oO = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final <E extends irr> E O000000o(Class<E> cls, String str, UncheckedRow uncheckedRow) {
        boolean z = true;
        if (str != null) {
            return new irh(this, CheckedRow.O000000o(uncheckedRow));
        }
        ish ish = this.O00000o.O0000OoO;
        irv O0000O0o2 = O0000O0o();
        if (O0000O0o2.O00000oo == null) {
            z = false;
        }
        if (z) {
            irx irx = O0000O0o2.O00000oo;
            if (irx.f1593O000000o.get(cls) == null) {
                irx.f1593O000000o.put(cls, irx.O00000Oo.O00000Oo());
            }
            Collections.emptyList();
            return ish.O00000o();
        }
        throw new IllegalStateException("Attempt to use column index before set.");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        OsSharedRealm osSharedRealm;
        if (this.O0000OOo && (osSharedRealm = this.O00000oO) != null && !osSharedRealm.isClosed()) {
            RealmLog.O000000o("Remember to call close() on all Realm instances. Realm %s is being finalized without being closed, this can lead to running out of native memory.", this.O00000o.O00000oO);
            RealmCache realmCache = this.O0000O0o;
            if (realmCache != null && !realmCache.O00000Oo.getAndSet(true)) {
                RealmCache.O00000o0.add(realmCache);
            }
        }
        super.finalize();
    }

    static final class O00000Oo extends ThreadLocal<O000000o> {
        O00000Oo() {
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object initialValue() {
            return new O000000o();
        }
    }

    irf(RealmCache realmCache, OsSchemaInfo osSchemaInfo) {
        this(realmCache.f15334O000000o, osSchemaInfo);
        this.O0000O0o = realmCache;
    }
}
