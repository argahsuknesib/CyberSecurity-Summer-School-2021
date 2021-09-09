package _m_j;

import io.realm.exceptions.RealmException;
import java.lang.reflect.InvocationTargetException;

public final class isd {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final isd f1599O000000o = new isd();
    private static isd O00000Oo;

    static {
        O00000Oo = null;
        try {
            O00000Oo = (isd) Class.forName("io.realm.internal.SyncObjectServerFacade").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
        } catch (InstantiationException e) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e);
        } catch (IllegalAccessException e2) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e2);
        } catch (NoSuchMethodException e3) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e3);
        } catch (InvocationTargetException e4) {
            throw new RealmException("Failed to init SyncObjectServerFacade", e4.getTargetException());
        }
    }

    public static Object[] O000000o() {
        return new Object[8];
    }

    public static isd O000000o(boolean z) {
        return f1599O000000o;
    }

    public static isd O00000Oo() {
        isd isd = O00000Oo;
        if (isd != null) {
            return isd;
        }
        return f1599O000000o;
    }
}
