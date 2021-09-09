package _m_j;

import _m_j.irn;
import io.realm.CompactOnLaunchCallback;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsRealmConfig;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Locale;

public final class irp {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f1591O000000o;
    protected static final ish O00000Oo = null;
    public final String O00000o;
    public final File O00000o0;
    public final String O00000oO;
    public final String O00000oo;
    public final long O0000O0o;
    public final irq O0000OOo;
    public final OsRealmConfig.Durability O0000Oo;
    public final boolean O0000Oo0;
    final ish O0000OoO;
    final irn.O000000o O0000Ooo;
    private final isp O0000o;
    public final CompactOnLaunchCallback O0000o0;
    public final boolean O0000o00;
    public final boolean O0000o0O;
    private final byte[] O0000o0o;

    static {
        Object O0000Oo02 = irn.O0000Oo0();
        f1591O000000o = O0000Oo02;
        if (O0000Oo02 == null) {
        } else {
            O000000o(f1591O000000o.getClass().getCanonicalName());
            throw new ExceptionInInitializerError("RealmTransformer doesn't seem to be applied. Please update the project configuration to use the Realm Gradle plugin. See https://realm.io/news/android-installation-change/");
        }
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O0000o0o;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            irp irp = (irp) obj;
            if (this.O0000O0o != irp.O0000O0o || this.O0000Oo0 != irp.O0000Oo0 || this.O0000o00 != irp.O0000o00 || this.O0000o0O != irp.O0000o0O) {
                return false;
            }
            File file = this.O00000o0;
            if (file == null ? irp.O00000o0 != null : !file.equals(irp.O00000o0)) {
                return false;
            }
            String str = this.O00000o;
            if (str == null ? irp.O00000o != null : !str.equals(irp.O00000o)) {
                return false;
            }
            if (!this.O00000oO.equals(irp.O00000oO)) {
                return false;
            }
            String str2 = this.O00000oo;
            if (str2 == null ? irp.O00000oo != null : !str2.equals(irp.O00000oo)) {
                return false;
            }
            if (!Arrays.equals(this.O0000o0o, irp.O0000o0o)) {
                return false;
            }
            irq irq = this.O0000OOo;
            if (irq == null ? irp.O0000OOo != null : !irq.equals(irp.O0000OOo)) {
                return false;
            }
            if (this.O0000Oo != irp.O0000Oo || !this.O0000OoO.equals(irp.O0000OoO)) {
                return false;
            }
            isp isp = this.O0000o;
            if (isp == null ? irp.O0000o != null : !isp.equals(irp.O0000o)) {
                return false;
            }
            irn.O000000o o000000o = this.O0000Ooo;
            if (o000000o == null ? irp.O0000Ooo != null : !o000000o.equals(irp.O0000Ooo)) {
                return false;
            }
            CompactOnLaunchCallback compactOnLaunchCallback = this.O0000o0;
            if (compactOnLaunchCallback != null) {
                return compactOnLaunchCallback.equals(irp.O0000o0);
            }
            if (irp.O0000o0 == null) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        File file = this.O00000o0;
        int i = 0;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        String str = this.O00000o;
        int hashCode2 = (((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.O00000oO.hashCode()) * 31;
        String str2 = this.O00000oo;
        int hashCode3 = str2 != null ? str2.hashCode() : 0;
        long j = this.O0000O0o;
        int hashCode4 = (((((hashCode2 + hashCode3) * 31) + Arrays.hashCode(this.O0000o0o)) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        irq irq = this.O0000OOo;
        int hashCode5 = (((((((hashCode4 + (irq != null ? irq.hashCode() : 0)) * 31) + (this.O0000Oo0 ? 1 : 0)) * 31) + this.O0000Oo.hashCode()) * 31) + this.O0000OoO.hashCode()) * 31;
        isp isp = this.O0000o;
        int hashCode6 = (hashCode5 + (isp != null ? isp.hashCode() : 0)) * 31;
        irn.O000000o o000000o = this.O0000Ooo;
        int hashCode7 = (((hashCode6 + (o000000o != null ? o000000o.hashCode() : 0)) * 31) + (this.O0000o00 ? 1 : 0)) * 31;
        CompactOnLaunchCallback compactOnLaunchCallback = this.O0000o0;
        if (compactOnLaunchCallback != null) {
            i = compactOnLaunchCallback.hashCode();
        }
        return ((hashCode7 + i) * 31) + (this.O0000o0O ? 1 : 0);
    }

    private static ish O000000o(String str) {
        String[] split = str.split("\\.");
        String str2 = split[split.length - 1];
        String format = String.format(Locale.US, "io.realm.%s%s", str2, "Mediator");
        try {
            Constructor<?> constructor = Class.forName(format).getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return (ish) constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            throw new RealmException("Could not find ".concat(String.valueOf(format)), e);
        } catch (InvocationTargetException e2) {
            throw new RealmException("Could not create an instance of ".concat(String.valueOf(format)), e2);
        } catch (InstantiationException e3) {
            throw new RealmException("Could not create an instance of ".concat(String.valueOf(format)), e3);
        } catch (IllegalAccessException e4) {
            throw new RealmException("Could not create an instance of ".concat(String.valueOf(format)), e4);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("realmDirectory: ");
        File file = this.O00000o0;
        sb.append(file != null ? file.toString() : "");
        sb.append("\n");
        sb.append("realmFileName : ");
        sb.append(this.O00000o);
        sb.append("\n");
        sb.append("canonicalPath: ");
        sb.append(this.O00000oO);
        sb.append("\n");
        sb.append("key: [length: ");
        sb.append(this.O0000o0o == null ? 0 : 64);
        sb.append("]");
        sb.append("\n");
        sb.append("schemaVersion: ");
        sb.append(Long.toString(this.O0000O0o));
        sb.append("\n");
        sb.append("migration: ");
        sb.append(this.O0000OOo);
        sb.append("\n");
        sb.append("deleteRealmIfMigrationNeeded: ");
        sb.append(this.O0000Oo0);
        sb.append("\n");
        sb.append("durability: ");
        sb.append(this.O0000Oo);
        sb.append("\n");
        sb.append("schemaMediator: ");
        sb.append(this.O0000OoO);
        sb.append("\n");
        sb.append("readOnly: ");
        sb.append(this.O0000o00);
        sb.append("\n");
        sb.append("compactOnLaunch: ");
        sb.append(this.O0000o0);
        return sb.toString();
    }
}
