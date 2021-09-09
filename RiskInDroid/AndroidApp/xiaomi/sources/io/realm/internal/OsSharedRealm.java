package io.realm.internal;

import _m_j.irp;
import _m_j.irw;
import _m_j.isb;
import _m_j.isc;
import _m_j.isd;
import _m_j.isf;
import _m_j.isk;
import io.realm.internal.OsRealmConfig;
import io.realm.internal.OsResults;
import io.realm.internal.android.AndroidRealmNotifier;
import java.io.Closeable;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
public final class OsSharedRealm implements isc, Closeable {
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private static final List<OsSharedRealm> sharedRealmsUnderConstruction = new CopyOnWriteArrayList();
    private static volatile File temporaryDirectory;
    public final irw capabilities;
    final isb context;
    final List<WeakReference<OsResults.O000000o>> iterators = new ArrayList();
    private final long nativePtr;
    private final OsRealmConfig osRealmConfig;
    private final List<WeakReference<isf>> pendingRows = new CopyOnWriteArrayList();
    public final RealmNotifier realmNotifier;
    private final OsSchemaInfo schemaInfo;
    private final List<OsSharedRealm> tempSharedRealmsForCallback = new ArrayList();

    @Keep
    public interface InitializationCallback {
        void onInit(OsSharedRealm osSharedRealm);
    }

    @Keep
    public interface MigrationCallback {
        void onMigrationNeeded(OsSharedRealm osSharedRealm, long j, long j2);
    }

    @Keep
    public interface SchemaChangedCallback {
        void onSchemaChanged();
    }

    private static native void nativeBeginTransaction(long j);

    private static native void nativeCancelTransaction(long j);

    private static native void nativeCloseSharedRealm(long j);

    private static native void nativeCommitTransaction(long j);

    private static native boolean nativeCompact(long j);

    private static native long nativeCreateTable(long j, String str);

    private static native long nativeCreateTableWithPrimaryKeyField(long j, String str, String str2, boolean z, boolean z2);

    private static native int nativeGetClassPrivileges(long j, String str);

    private static native long nativeGetFinalizerPtr();

    private static native int nativeGetObjectPrivileges(long j, long j2);

    private static native int nativeGetRealmPrivileges(long j);

    private static native long nativeGetSchemaInfo(long j);

    private static native long nativeGetSharedRealm(long j, RealmNotifier realmNotifier2);

    private static native long nativeGetTable(long j, String str);

    private static native String nativeGetTableName(long j, int i);

    private static native long[] nativeGetVersionID(long j);

    private static native boolean nativeHasTable(long j, String str);

    private static native void nativeInit(String str);

    private static native boolean nativeIsAutoRefresh(long j);

    private static native boolean nativeIsClosed(long j);

    private static native boolean nativeIsEmpty(long j);

    private static native boolean nativeIsInTransaction(long j);

    private static native boolean nativeIsPartial(long j);

    private static native void nativeRefresh(long j);

    private static native void nativeRegisterSchemaChangedCallback(long j, SchemaChangedCallback schemaChangedCallback);

    private static native void nativeRenameTable(long j, String str, String str2);

    private static native void nativeSetAutoRefresh(long j, boolean z);

    private static native long nativeSize(long j);

    private static native void nativeStopWaitForChange(long j);

    private static native boolean nativeWaitForChange(long j);

    private static native void nativeWriteCopy(long j, String str, byte[] bArr);

    public static class O000000o implements Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final long f15351O000000o;
        public final long O00000Oo;

        public final /* synthetic */ int compareTo(Object obj) {
            O000000o o000000o = (O000000o) obj;
            if (o000000o != null) {
                long j = this.f15351O000000o;
                long j2 = o000000o.f15351O000000o;
                if (j > j2) {
                    return 1;
                }
                return j < j2 ? -1 : 0;
            }
            throw new IllegalArgumentException("Version cannot be compared to a null value.");
        }

        O000000o(long j, long j2) {
            this.f15351O000000o = j;
            this.O00000Oo = j2;
        }

        public final String toString() {
            return "VersionID{version=" + this.f15351O000000o + ", index=" + this.O00000Oo + '}';
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                O000000o o000000o = (O000000o) obj;
                return this.f15351O000000o == o000000o.f15351O000000o && this.O00000Oo == o000000o.O00000Oo;
            }
        }

        public final int hashCode() {
            long j = this.f15351O000000o;
            long j2 = this.O00000Oo;
            return (((super.hashCode() * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)));
        }
    }

    private OsSharedRealm(OsRealmConfig osRealmConfig2) {
        isk isk = new isk();
        AndroidRealmNotifier androidRealmNotifier = new AndroidRealmNotifier(this, isk);
        this.context = osRealmConfig2.O00000Oo;
        sharedRealmsUnderConstruction.add(this);
        try {
            this.nativePtr = nativeGetSharedRealm(osRealmConfig2.getNativePtr(), androidRealmNotifier);
            this.tempSharedRealmsForCallback.clear();
            sharedRealmsUnderConstruction.remove(this);
            this.osRealmConfig = osRealmConfig2;
            this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
            this.context.O000000o(this);
            this.capabilities = isk;
            this.realmNotifier = androidRealmNotifier;
            nativeSetAutoRefresh(this.nativePtr, isk.O000000o());
        } catch (Throwable th) {
            this.tempSharedRealmsForCallback.clear();
            sharedRealmsUnderConstruction.remove(this);
            throw th;
        }
    }

    private OsSharedRealm(long j, OsRealmConfig osRealmConfig2) {
        this.nativePtr = j;
        this.osRealmConfig = osRealmConfig2;
        this.schemaInfo = new OsSchemaInfo(nativeGetSchemaInfo(this.nativePtr), this);
        this.context = osRealmConfig2.O00000Oo;
        this.context.O000000o(this);
        this.capabilities = new isk();
        this.realmNotifier = null;
        boolean z = false;
        nativeSetAutoRefresh(this.nativePtr, false);
        Iterator<OsSharedRealm> it = sharedRealmsUnderConstruction.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            OsSharedRealm next = it.next();
            if (next.context == osRealmConfig2.O00000Oo) {
                z = true;
                next.tempSharedRealmsForCallback.add(this);
                break;
            }
        }
        if (!z) {
            throw new IllegalStateException("Cannot find the parent 'OsSharedRealm' which is under construction.");
        }
    }

    public static OsSharedRealm getInstance(irp irp) {
        return getInstance(new OsRealmConfig.O000000o(irp));
    }

    public static void initialize(File file) {
        if (temporaryDirectory == null) {
            String absolutePath = file.getAbsolutePath();
            if (file.isDirectory() || file.mkdirs() || file.isDirectory()) {
                if (!absolutePath.endsWith("/")) {
                    absolutePath = absolutePath + "/";
                }
                nativeInit(absolutePath);
                temporaryDirectory = file;
                return;
            }
            throw new IOException("failed to create temporary directory: ".concat(String.valueOf(absolutePath)));
        }
    }

    public static File getTemporaryDirectory() {
        return temporaryDirectory;
    }

    public final void beginTransaction() {
        detachIterators();
        executePendingRowQueries();
        nativeBeginTransaction(this.nativePtr);
    }

    public final void commitTransaction() {
        nativeCommitTransaction(this.nativePtr);
    }

    public final void cancelTransaction() {
        nativeCancelTransaction(this.nativePtr);
    }

    public final boolean isInTransaction() {
        return nativeIsInTransaction(this.nativePtr);
    }

    public final boolean hasTable(String str) {
        return nativeHasTable(this.nativePtr, str);
    }

    public final Table getTable(String str) {
        return new Table(this, nativeGetTable(this.nativePtr, str));
    }

    public final Table createTable(String str) {
        return new Table(this, nativeCreateTable(this.nativePtr, str));
    }

    public final Table createTableWithPrimaryKey(String str, String str2, boolean z, boolean z2) {
        return new Table(this, nativeCreateTableWithPrimaryKeyField(this.nativePtr, str, str2, z, z2));
    }

    public final void renameTable(String str, String str2) {
        nativeRenameTable(this.nativePtr, str, str2);
    }

    public final String getTableName(int i) {
        return nativeGetTableName(this.nativePtr, i);
    }

    public final long size() {
        return nativeSize(this.nativePtr);
    }

    public final String getPath() {
        return this.osRealmConfig.f15347O000000o.O00000oO;
    }

    public final boolean isEmpty() {
        return nativeIsEmpty(this.nativePtr);
    }

    public final void refresh() {
        nativeRefresh(this.nativePtr);
    }

    public final O000000o getVersionID() {
        long[] nativeGetVersionID = nativeGetVersionID(this.nativePtr);
        return new O000000o(nativeGetVersionID[0], nativeGetVersionID[1]);
    }

    public final int getPrivileges() {
        return nativeGetRealmPrivileges(this.nativePtr);
    }

    public final int getClassPrivileges(String str) {
        return nativeGetClassPrivileges(this.nativePtr, str);
    }

    public final int getObjectPrivileges(UncheckedRow uncheckedRow) {
        return nativeGetObjectPrivileges(this.nativePtr, uncheckedRow.getNativePtr());
    }

    public final boolean isClosed() {
        return nativeIsClosed(this.nativePtr);
    }

    public final void writeCopy(File file, byte[] bArr) {
        if (!file.isFile() || !file.exists()) {
            nativeWriteCopy(this.nativePtr, file.getAbsolutePath(), bArr);
            return;
        }
        throw new IllegalArgumentException("The destination file must not exist");
    }

    public final boolean waitForChange() {
        return nativeWaitForChange(this.nativePtr);
    }

    public final void stopWaitForChange() {
        nativeStopWaitForChange(this.nativePtr);
    }

    public final boolean compact() {
        return nativeCompact(this.nativePtr);
    }

    public final void setAutoRefresh(boolean z) {
        this.capabilities.O00000Oo();
        nativeSetAutoRefresh(this.nativePtr, z);
    }

    public final boolean isAutoRefresh() {
        return nativeIsAutoRefresh(this.nativePtr);
    }

    public final irp getConfiguration() {
        return this.osRealmConfig.f15347O000000o;
    }

    public final void close() {
        RealmNotifier realmNotifier2 = this.realmNotifier;
        if (realmNotifier2 != null) {
            realmNotifier2.close();
        }
        synchronized (this.context) {
            nativeCloseSharedRealm(this.nativePtr);
        }
    }

    public final long getNativePtr() {
        return this.nativePtr;
    }

    public final long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public final OsSchemaInfo getSchemaInfo() {
        return this.schemaInfo;
    }

    public final void registerSchemaChangedCallback(SchemaChangedCallback schemaChangedCallback) {
        nativeRegisterSchemaChangedCallback(this.nativePtr, schemaChangedCallback);
    }

    public final boolean isPartial() {
        return nativeIsPartial(this.nativePtr);
    }

    /* access modifiers changed from: package-private */
    public final void addIterator(OsResults.O000000o o000000o) {
        this.iterators.add(new WeakReference(o000000o));
    }

    private void detachIterators() {
        for (WeakReference<OsResults.O000000o> weakReference : this.iterators) {
            OsResults.O000000o o000000o = (OsResults.O000000o) weakReference.get();
            if (o000000o != null) {
                o000000o.O000000o();
            }
        }
        this.iterators.clear();
    }

    /* access modifiers changed from: package-private */
    public final void invalidateIterators() {
        for (WeakReference<OsResults.O000000o> weakReference : this.iterators) {
            OsResults.O000000o o000000o = (OsResults.O000000o) weakReference.get();
            if (o000000o != null) {
                o000000o.O00000Oo = null;
            }
        }
        this.iterators.clear();
    }

    /* access modifiers changed from: package-private */
    public final void addPendingRow(isf isf) {
        this.pendingRows.add(new WeakReference(isf));
    }

    public final void removePendingRow(isf isf) {
        for (WeakReference next : this.pendingRows) {
            isf isf2 = (isf) next.get();
            if (isf2 == null || isf2 == isf) {
                this.pendingRows.remove(next);
            }
        }
    }

    private void executePendingRowQueries() {
        for (WeakReference<isf> weakReference : this.pendingRows) {
            isf isf = (isf) weakReference.get();
            if (isf != null) {
                if (isf.f1602O000000o == null) {
                    throw new IllegalStateException("The query has been executed. This 'PendingRow' is not valid anymore.");
                } else if (isf.O00000Oo != null) {
                    isf.O000000o o000000o = isf.O00000Oo.get();
                    if (o000000o == null || !OsResults.nativeIsValid(isf.f1602O000000o.f15349O000000o)) {
                        isf.O000000o();
                    } else {
                        OsResults osResults = isf.f1602O000000o;
                        long nativeFirstRow = OsResults.nativeFirstRow(osResults.f15349O000000o);
                        UncheckedRow O00000o = nativeFirstRow != 0 ? osResults.O00000o0.O00000o(nativeFirstRow) : null;
                        isf.O000000o();
                        if (O00000o != null) {
                            if (isf.O00000o0) {
                                O00000o = CheckedRow.O000000o(O00000o);
                            }
                            o000000o.O000000o(O00000o);
                        } else {
                            o000000o.O000000o(InvalidRow.INSTANCE);
                        }
                    }
                } else {
                    throw new IllegalStateException("The 'frontEnd' has not been set.");
                }
            }
        }
        this.pendingRows.clear();
    }

    private static void runMigrationCallback(long j, OsRealmConfig osRealmConfig2, MigrationCallback migrationCallback, long j2) {
        migrationCallback.onMigrationNeeded(new OsSharedRealm(j, osRealmConfig2), j2, osRealmConfig2.f15347O000000o.O0000O0o);
    }

    private static void runInitializationCallback(long j, OsRealmConfig osRealmConfig2, InitializationCallback initializationCallback) {
        initializationCallback.onInit(new OsSharedRealm(j, osRealmConfig2));
    }

    public static OsSharedRealm getInstance(OsRealmConfig.O000000o o000000o) {
        OsRealmConfig osRealmConfig2 = new OsRealmConfig(o000000o.f15348O000000o, o000000o.O00000oO, o000000o.O00000Oo, o000000o.O00000o0, o000000o.O00000o, (byte) 0);
        isd.O00000Oo();
        return new OsSharedRealm(osRealmConfig2);
    }
}
