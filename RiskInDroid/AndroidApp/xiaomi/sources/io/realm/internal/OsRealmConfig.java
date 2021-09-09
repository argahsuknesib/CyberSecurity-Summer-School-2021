package io.realm.internal;

import _m_j.irp;
import _m_j.isb;
import _m_j.isc;
import _m_j.isd;
import io.realm.CompactOnLaunchCallback;
import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.net.URI;
import java.net.URISyntaxException;

public class OsRealmConfig implements isc {
    private static final long O00000o0 = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    final irp f15347O000000o;
    final isb O00000Oo;
    private final URI O00000o;
    private final long O00000oO;
    private final CompactOnLaunchCallback O00000oo;
    private final OsSharedRealm.MigrationCallback O0000O0o;
    private final OsSharedRealm.InitializationCallback O0000OOo;

    private static native long nativeCreate(String str, boolean z, boolean z2);

    private static native String nativeCreateAndSetSyncConfig(long j, String str, String str2, String str3, String str4, boolean z, byte b);

    private static native void nativeEnableChangeNotification(long j, boolean z);

    private static native long nativeGetFinalizerPtr();

    private static native void nativeSetCompactOnLaunchCallback(long j, CompactOnLaunchCallback compactOnLaunchCallback);

    private static native void nativeSetEncryptionKey(long j, byte[] bArr);

    private static native void nativeSetInMemory(long j, boolean z);

    private native void nativeSetInitializationCallback(long j, OsSharedRealm.InitializationCallback initializationCallback);

    private native void nativeSetSchemaConfig(long j, byte b, long j2, long j3, OsSharedRealm.MigrationCallback migrationCallback);

    private static native void nativeSetSyncConfigSslSettings(long j, boolean z, String str);

    /* synthetic */ OsRealmConfig(irp irp, boolean z, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback, OsSharedRealm.InitializationCallback initializationCallback, byte b) {
        this(irp, z, osSchemaInfo, migrationCallback, initializationCallback);
    }

    public enum Durability {
        FULL(0),
        MEM_ONLY(1);
        
        final int value;

        private Durability(int i) {
            this.value = i;
        }
    }

    public enum SchemaMode {
        SCHEMA_MODE_AUTOMATIC((byte) 0),
        SCHEMA_MODE_IMMUTABLE((byte) 1),
        SCHEMA_MODE_READONLY((byte) 2),
        SCHEMA_MODE_RESET_FILE((byte) 3),
        SCHEMA_MODE_ADDITIVE((byte) 4),
        SCHEMA_MODE_MANUAL((byte) 5);
        
        final byte value;

        private SchemaMode(byte b) {
            this.value = b;
        }

        public final byte getNativeValue() {
            return this.value;
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        irp f15348O000000o;
        public OsSchemaInfo O00000Oo = null;
        public OsSharedRealm.InitializationCallback O00000o = null;
        public OsSharedRealm.MigrationCallback O00000o0 = null;
        public boolean O00000oO = false;

        public O000000o(irp irp) {
            this.f15348O000000o = irp;
        }
    }

    private OsRealmConfig(irp irp, boolean z, OsSchemaInfo osSchemaInfo, OsSharedRealm.MigrationCallback migrationCallback, OsSharedRealm.InitializationCallback initializationCallback) {
        irp irp2 = irp;
        OsSharedRealm.InitializationCallback initializationCallback2 = initializationCallback;
        this.O00000Oo = new isb();
        this.f15347O000000o = irp2;
        boolean z2 = true;
        this.O00000oO = nativeCreate(irp2.O00000oO, false, true);
        isb.f1598O000000o.O000000o(this);
        isd.O00000Oo();
        Object[] O000000o2 = isd.O000000o();
        String str = (String) O000000o2[0];
        String str2 = (String) O000000o2[1];
        String str3 = (String) O000000o2[2];
        String str4 = (String) O000000o2[3];
        boolean equals = Boolean.TRUE.equals(O000000o2[4]);
        String str5 = (String) O000000o2[5];
        Byte b = (Byte) O000000o2[6];
        boolean equals2 = Boolean.TRUE.equals(O000000o2[7]);
        byte[] O000000o3 = irp.O000000o();
        if (O000000o3 != null) {
            nativeSetEncryptionKey(this.O00000oO, O000000o3);
        }
        nativeSetInMemory(this.O00000oO, irp2.O0000Oo != Durability.MEM_ONLY ? false : z2);
        nativeEnableChangeNotification(this.O00000oO, z);
        SchemaMode schemaMode = SchemaMode.SCHEMA_MODE_MANUAL;
        if (irp2.O0000o0O) {
            schemaMode = SchemaMode.SCHEMA_MODE_IMMUTABLE;
        } else if (irp2.O0000o00) {
            schemaMode = SchemaMode.SCHEMA_MODE_READONLY;
        } else if (str2 != null) {
            schemaMode = SchemaMode.SCHEMA_MODE_ADDITIVE;
        } else if (irp2.O0000Oo0) {
            schemaMode = SchemaMode.SCHEMA_MODE_RESET_FILE;
        }
        long j = irp2.O0000O0o;
        long nativePtr = osSchemaInfo == null ? 0 : osSchemaInfo.getNativePtr();
        this.O0000O0o = migrationCallback;
        nativeSetSchemaConfig(this.O00000oO, schemaMode.getNativeValue(), j, nativePtr, migrationCallback);
        this.O00000oo = irp2.O0000o0;
        CompactOnLaunchCallback compactOnLaunchCallback = this.O00000oo;
        if (compactOnLaunchCallback != null) {
            nativeSetCompactOnLaunchCallback(this.O00000oO, compactOnLaunchCallback);
        }
        this.O0000OOo = initializationCallback2;
        if (initializationCallback2 != null) {
            nativeSetInitializationCallback(this.O00000oO, initializationCallback2);
        }
        URI uri = null;
        if (str2 != null) {
            boolean z3 = equals;
            String str6 = str5;
            try {
                uri = new URI(nativeCreateAndSetSyncConfig(this.O00000oO, str2, str3, str, str4, equals2, b.byteValue()));
            } catch (URISyntaxException e) {
                RealmLog.O000000o(e, "Cannot create a URI from the Realm URL address", new Object[0]);
            }
            nativeSetSyncConfigSslSettings(this.O00000oO, z3, str6);
        }
        this.O00000o = uri;
    }

    public long getNativePtr() {
        return this.O00000oO;
    }

    public long getNativeFinalizerPtr() {
        return O00000o0;
    }
}
