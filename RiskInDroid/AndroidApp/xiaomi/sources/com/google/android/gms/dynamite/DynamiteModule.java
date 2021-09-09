package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.IDynamiteLoader;
import com.google.android.gms.dynamite.IDynamiteLoaderV2;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzc();
    public static final VersionPolicy PREFER_REMOTE = new zzb();
    private static Boolean zzabr;
    private static IDynamiteLoader zzabs;
    private static IDynamiteLoaderV2 zzabt;
    private static String zzabu;
    private static final ThreadLocal<zza> zzabv = new ThreadLocal<>();
    private static final VersionPolicy.IVersions zzabw = new zza();
    private final Context zzabx;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, zza zza) {
            this(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int getLocalVersion(Context context, String str);

            int getRemoteVersion(Context context, String str, boolean z) throws LoadingException;
        }

        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    static class zza {
        public Cursor zzaby;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    static class zzb implements VersionPolicy.IVersions {
        private final int zzabz;
        private final int zzaca = 0;

        public zzb(int i, int i2) {
            this.zzabz = i;
        }

        public final int getLocalVersion(Context context, String str) {
            return this.zzabz;
        }

        public final int getRemoteVersion(Context context, String str, boolean z) {
            return 0;
        }
    }

    private DynamiteModule(Context context) {
        this.zzabx = (Context) Preconditions.checkNotNull(context);
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get(null).equals(str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            String valueOf2 = String.valueOf(e.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static Uri getQueryUri(String str, boolean z) {
        String str2 = z ? "api_force_staging" : "api";
        StringBuilder sb = new StringBuilder(str2.length() + 42 + String.valueOf(str).length());
        sb.append("content://com.google.android.gms.chimera/");
        sb.append(str2);
        sb.append("/");
        sb.append(str);
        return Uri.parse(sb.toString());
    }

    public static int getRemoteVersion(Context context, String str) {
        return getRemoteVersion(context, str, false);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:39|40) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:15|16|17|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        r2.set(null, java.lang.ClassLoader.getSystemClassLoader());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0085, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0035 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x007c */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00be A[SYNTHETIC, Splitter:B:55:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00e5  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0050=Splitter:B:22:0x0050, B:17:0x0035=Splitter:B:17:0x0035, B:34:0x0079=Splitter:B:34:0x0079} */
    public static int getRemoteVersion(Context context, String str, boolean z) {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            Boolean bool2 = zzabr;
            if (bool2 == null) {
                try {
                    Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                    Field declaredField = loadClass.getDeclaredField("sClassLoader");
                    synchronized (loadClass) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader != null) {
                            if (classLoader != ClassLoader.getSystemClassLoader()) {
                                zza(classLoader);
                                bool = Boolean.TRUE;
                            }
                        } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                        } else {
                            int zzb2 = zzb(context, str, z);
                            if (zzabu != null) {
                                if (!zzabu.isEmpty()) {
                                    zzh zzh = new zzh(zzabu, ClassLoader.getSystemClassLoader());
                                    zza(zzh);
                                    declaredField.set(null, zzh);
                                    zzabr = Boolean.TRUE;
                                    return zzb2;
                                }
                            }
                            return zzb2;
                        }
                        bool = Boolean.FALSE;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                    sb.append("Failed to load module via V2: ");
                    sb.append(valueOf);
                    Log.w("DynamiteModule", sb.toString());
                    bool2 = Boolean.FALSE;
                    zzabr = bool2;
                    if (bool2.booleanValue()) {
                        return zza(context, str, z);
                    }
                    try {
                        return zzb(context, str, z);
                    } catch (LoadingException e2) {
                        String valueOf2 = String.valueOf(e2.getMessage());
                        Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                        return 0;
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public static synchronized Boolean getUseV2ForTesting() {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzabr;
        }
        return bool;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        if (r3.zzaby != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        if (r3.zzaby != null) goto L_0x007e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d1, code lost:
        if (r3.zzaby != null) goto L_0x007e;
     */
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        VersionPolicy.SelectionResult selectModule;
        DynamiteModule zzd;
        zza zza2 = zzabv.get();
        zza zza3 = new zza(null);
        zzabv.set(zza3);
        try {
            selectModule = versionPolicy.selectModule(context, str, zzabw);
            int i = selectModule.localVersion;
            int i2 = selectModule.remoteVersion;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            Log.i("DynamiteModule", sb.toString());
            if (selectModule.selection == 0 || ((selectModule.selection == -1 && selectModule.localVersion == 0) || (selectModule.selection == 1 && selectModule.remoteVersion == 0))) {
                int i3 = selectModule.localVersion;
                int i4 = selectModule.remoteVersion;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i3);
                sb2.append(" and remote version is ");
                sb2.append(i4);
                sb2.append(".");
                throw new LoadingException(sb2.toString(), (zza) null);
            }
            if (selectModule.selection == -1) {
                zzd = zzd(context, str);
            } else if (selectModule.selection == 1) {
                zzd = zza(context, str, selectModule.remoteVersion);
            } else {
                int i5 = selectModule.selection;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i5);
                throw new LoadingException(sb3.toString(), (zza) null);
            }
            zza3.zzaby.close();
            zzabv.set(zza2);
            return zzd;
        } catch (LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
            if (selectModule.localVersion == 0 || versionPolicy.selectModule(context, str, new zzb(selectModule.localVersion, 0)).selection != -1) {
                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
            }
            zzd = zzd(context, str);
        } catch (Throwable th) {
            if (zza3.zzaby != null) {
                zza3.zzaby.close();
            }
            zzabv.set(zza2);
            throw th;
        }
    }

    public static Cursor queryForDynamiteModule(Context context, String str, boolean z) {
        return context.getContentResolver().query(getQueryUri(str, z), null, null, null, null);
    }

    @VisibleForTesting
    public static synchronized void resetInternalStateForTesting() {
        synchronized (DynamiteModule.class) {
            zzabs = null;
            zzabt = null;
            zzabu = null;
            zzabr = null;
            synchronized (DynamiteLoaderClassLoader.class) {
                DynamiteLoaderClassLoader.sClassLoader = null;
            }
        }
    }

    @VisibleForTesting
    public static synchronized void setUseV2ForTesting(Boolean bool) {
        synchronized (DynamiteModule.class) {
            zzabr = bool;
        }
    }

    private static int zza(Context context, String str, boolean z) {
        IDynamiteLoader zzg = zzg(context);
        if (zzg == null) {
            return 0;
        }
        try {
            return zzg.getModuleVersion2(ObjectWrapper.wrap(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    private static Context zza(Context context, String str, int i, Cursor cursor, IDynamiteLoaderV2 iDynamiteLoaderV2) {
        try {
            return (Context) ObjectWrapper.unwrap(iDynamiteLoaderV2.loadModule2(ObjectWrapper.wrap(context), str, i, ObjectWrapper.wrap(cursor)));
        } catch (Exception e) {
            String valueOf = String.valueOf(e.toString());
            Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load DynamiteLoader: ".concat(valueOf) : new String("Failed to load DynamiteLoader: "));
            return null;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i) throws LoadingException {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzabr;
        }
        if (bool != null) {
            return bool.booleanValue() ? zzc(context, str, i) : zzb(context, str, i);
        }
        throw new LoadingException("Failed to determine which loading route to use.", (zza) null);
    }

    private static void zza(ClassLoader classLoader) throws LoadingException {
        try {
            zzabt = IDynamiteLoaderV2.Stub.asInterface((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0060  */
    private static int zzb(Context context, String str, boolean z) throws LoadingException {
        Cursor cursor;
        try {
            cursor = queryForDynamiteModule(context, str, z);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        int i = cursor.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                zzabu = cursor.getString(2);
                            }
                            zza zza2 = zzabv.get();
                            if (zza2 != null && zza2.zzaby == null) {
                                zza2.zzaby = cursor;
                                cursor = null;
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                        return i;
                    }
                } catch (Exception e) {
                    e = e;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", (zza) null);
        } catch (Exception e2) {
            e = e2;
            cursor = null;
            try {
                if (e instanceof LoadingException) {
                    throw e;
                }
                throw new LoadingException("V2 version check failed", e, null);
            } catch (Throwable th) {
                th = th;
                if (cursor != null) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private static DynamiteModule zzb(Context context, String str, int i) throws LoadingException {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        IDynamiteLoader zzg = zzg(context);
        if (zzg != null) {
            try {
                IObjectWrapper createModuleContext = zzg.createModuleContext(ObjectWrapper.wrap(context), str, i);
                if (ObjectWrapper.unwrap(createModuleContext) != null) {
                    return new DynamiteModule((Context) ObjectWrapper.unwrap(createModuleContext));
                }
                throw new LoadingException("Failed to load remote module.", (zza) null);
            } catch (RemoteException e) {
                throw new LoadingException("Failed to load remote module.", e, null);
            }
        } else {
            throw new LoadingException("Failed to create IDynamiteLoader.", (zza) null);
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i) throws LoadingException {
        IDynamiteLoaderV2 iDynamiteLoaderV2;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            iDynamiteLoaderV2 = zzabt;
        }
        if (iDynamiteLoaderV2 != null) {
            zza zza2 = zzabv.get();
            if (zza2 == null || zza2.zzaby == null) {
                throw new LoadingException("No result cursor", (zza) null);
            }
            Context zza3 = zza(context.getApplicationContext(), str, i, zza2.zzaby, iDynamiteLoaderV2);
            if (zza3 != null) {
                return new DynamiteModule(zza3);
            }
            throw new LoadingException("Failed to get module context", (zza) null);
        }
        throw new LoadingException("DynamiteLoaderV2 was not cached.", (zza) null);
    }

    private static DynamiteModule zzd(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new DynamiteModule(context.getApplicationContext());
    }

    private static IDynamiteLoader zzg(Context context) {
        synchronized (DynamiteModule.class) {
            if (zzabs != null) {
                IDynamiteLoader iDynamiteLoader = zzabs;
                return iDynamiteLoader;
            } else if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                return null;
            } else {
                try {
                    IDynamiteLoader asInterface = IDynamiteLoader.Stub.asInterface((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                    if (asInterface != null) {
                        zzabs = asInterface;
                        return asInterface;
                    }
                } catch (Exception e) {
                    String valueOf = String.valueOf(e.getMessage());
                    Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
                }
            }
        }
        return null;
    }

    public final Context getModuleContext() {
        return this.zzabx;
    }

    public final IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzabx.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e, null);
        }
    }
}
