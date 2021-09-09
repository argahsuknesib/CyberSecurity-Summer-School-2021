package _m_j;

import io.realm.RealmCache;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.Table;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class irn extends irf {
    private static final Object O0000O0o = new Object();
    private static irp O0000OOo;
    private final irv O0000Oo0;

    public interface O000000o {
    }

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

    private irn(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.O0000Oo0 = new iri(this, new irx(this.O00000o.O0000OoO, osSharedRealm.getSchemaInfo()));
    }

    public final irv O0000O0o() {
        return this.O0000Oo0;
    }

    public static irn O0000OOo() {
        irp O0000Oo = O0000Oo();
        if (O0000Oo != null) {
            return (irn) RealmCache.O000000o(O0000Oo, irn.class);
        }
        if (irf.f1580O000000o == null) {
            throw new IllegalStateException("Call `Realm.init(Context)` before calling this method.");
        }
        throw new IllegalStateException("Set default configuration by using `Realm.setDefaultConfiguration(RealmConfiguration)`.");
    }

    private static irp O0000Oo() {
        irp irp;
        synchronized (O0000O0o) {
            irp = O0000OOo;
        }
        return irp;
    }

    public static irn O000000o(RealmCache realmCache) {
        return new irn(realmCache);
    }

    static irn O000000o(OsSharedRealm osSharedRealm) {
        return new irn(osSharedRealm);
    }

    public static Object O0000Oo0() {
        try {
            Constructor<?> constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RealmException("Could not create an instance of ".concat("io.realm.DefaultRealmModule"), e);
        } catch (InstantiationException e2) {
            throw new RealmException("Could not create an instance of ".concat("io.realm.DefaultRealmModule"), e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException("Could not create an instance of ".concat("io.realm.DefaultRealmModule"), e3);
        }
    }

    private irn(RealmCache realmCache) {
        super(realmCache, new OsSchemaInfo(realmCache.f15334O000000o.O0000OoO.O000000o().values()));
        this.O0000Oo0 = new iri(this, new irx(this.O00000o.O0000OoO, this.O00000oO.getSchemaInfo()));
        if (this.O00000o.O0000o00) {
            ish ish = this.O00000o.O0000OoO;
            for (Class<? extends irr> O000000o2 : ish.O00000oO()) {
                String O00000o0 = Table.O00000o0(ish.O000000o(O000000o2));
                if (!this.O00000oO.hasTable(O00000o0)) {
                    this.O00000oO.close();
                    throw new RealmMigrationNeededException(this.O00000o.O00000oO, String.format(Locale.US, "Cannot open the read only Realm. '%s' is missing.", Table.O00000Oo(O00000o0)));
                }
            }
        }
    }
}
