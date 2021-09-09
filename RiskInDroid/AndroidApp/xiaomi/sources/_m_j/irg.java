package _m_j;

import io.realm.RealmCache;
import io.realm.internal.OsObjectStore;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;

public class irg extends irf {
    private final irv O0000O0o = new irj(this);

    public final /* bridge */ /* synthetic */ void O000000o() {
        super.O000000o();
    }

    public final /* bridge */ /* synthetic */ void O00000Oo() {
        super.O00000Oo();
    }

    public final /* bridge */ /* synthetic */ void O00000o0() {
        super.O00000o0();
    }

    public final /* bridge */ /* synthetic */ String O00000oO() {
        return super.O00000oO();
    }

    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    private irg(final RealmCache realmCache) {
        super(realmCache, (OsSchemaInfo) null);
        RealmCache.O000000o(realmCache.f15334O000000o, new RealmCache.O000000o() {
            /* class _m_j.irg.AnonymousClass1 */

            public final void O000000o(int i) {
                if (i <= 0 && !realmCache.f15334O000000o.O0000o00 && OsObjectStore.O00000Oo(irg.this.O00000oO) == -1) {
                    irg.this.O00000oO.beginTransaction();
                    if (OsObjectStore.O00000Oo(irg.this.O00000oO) == -1) {
                        OsObjectStore.O000000o(irg.this.O00000oO);
                    }
                    irg.this.O00000oO.commitTransaction();
                }
            }
        });
    }

    private irg(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
    }

    public static irg O000000o(RealmCache realmCache) {
        return new irg(realmCache);
    }

    static irg O000000o(OsSharedRealm osSharedRealm) {
        return new irg(osSharedRealm);
    }

    public final irv O0000O0o() {
        return this.O0000O0o;
    }
}
