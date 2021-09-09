package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.IGoogleCertificatesApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class GoogleCertificates {
    private static volatile IGoogleCertificatesApi zzax;
    private static final Object zzay = new Object();
    private static Context zzaz;
    private static Set<ICertData> zzba;
    private static Set<ICertData> zzbb;

    static abstract class CertData extends ICertData.Stub {
        private int zzbc;

        protected CertData(byte[] bArr) {
            Preconditions.checkArgument(bArr.length == 25);
            this.zzbc = Arrays.hashCode(bArr);
        }

        protected static byte[] zzd(String str) {
            try {
                return str.getBytes("ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            IObjectWrapper bytesWrapped;
            if (obj != null && (obj instanceof ICertData)) {
                try {
                    ICertData iCertData = (ICertData) obj;
                    if (iCertData.getHashCode() == hashCode() && (bytesWrapped = iCertData.getBytesWrapped()) != null) {
                        return Arrays.equals(getBytes(), (byte[]) ObjectWrapper.unwrap(bytesWrapped));
                    }
                    return false;
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract byte[] getBytes();

        public IObjectWrapper getBytesWrapped() {
            return ObjectWrapper.wrap(getBytes());
        }

        public int getHashCode() {
            return hashCode();
        }

        public int hashCode() {
            return this.zzbc;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return;
     */
    static synchronized void init(Context context) {
        synchronized (GoogleCertificates.class) {
            if (zzaz != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                zzaz = context.getApplicationContext();
            }
        }
    }

    static zzg zza(String str, CertData certData, boolean z) {
        String str2;
        try {
            zzc();
            Preconditions.checkNotNull(zzaz);
            try {
                if (zzax.isGoogleOrPlatformSigned(new GoogleCertificatesQuery(str, certData, z), ObjectWrapper.wrap(zzaz.getPackageManager()))) {
                    return zzg.zzg();
                }
                boolean z2 = true;
                if (z || !zza(str, certData, true).zzbl) {
                    z2 = false;
                }
                return zzg.zza(str, certData, z, z2);
            } catch (RemoteException e) {
                e = e;
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                str2 = "module call";
                return zzg.zza(str2, e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            e = e2;
            str2 = "module init";
            return zzg.zza(str2, e);
        }
    }

    private static Set<ICertData> zza(IBinder[] iBinderArr) throws RemoteException {
        HashSet hashSet = new HashSet(r0);
        for (IBinder asInterface : iBinderArr) {
            ICertData asInterface2 = ICertData.Stub.asInterface(asInterface);
            if (asInterface2 != null) {
                hashSet.add(asInterface2);
            }
        }
        return hashSet;
    }

    private static void zzc() throws DynamiteModule.LoadingException {
        if (zzax == null) {
            Preconditions.checkNotNull(zzaz);
            synchronized (zzay) {
                if (zzax == null) {
                    zzax = IGoogleCertificatesApi.Stub.asInterface(DynamiteModule.load(zzaz, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            }
        }
    }

    static synchronized Set<ICertData> zzd() {
        synchronized (GoogleCertificates.class) {
            if (zzba != null) {
                Set<ICertData> set = zzba;
                return set;
            }
            try {
                zzc();
                try {
                    IObjectWrapper googleCertificates = zzax.getGoogleCertificates();
                    if (googleCertificates == null) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote");
                        Set<ICertData> emptySet = Collections.emptySet();
                        return emptySet;
                    }
                    zzba = zza((IBinder[]) ObjectWrapper.unwrap(googleCertificates));
                    Set<ICertData> set2 = zzba;
                    return set2;
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    return Collections.emptySet();
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e2);
                return Collections.emptySet();
            }
        }
    }

    static synchronized Set<ICertData> zze() {
        synchronized (GoogleCertificates.class) {
            if (zzbb != null) {
                Set<ICertData> set = zzbb;
                return set;
            }
            try {
                zzc();
                try {
                    IObjectWrapper googleReleaseCertificates = zzax.getGoogleReleaseCertificates();
                    if (googleReleaseCertificates == null) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote");
                        Set<ICertData> emptySet = Collections.emptySet();
                        return emptySet;
                    }
                    zzbb = zza((IBinder[]) ObjectWrapper.unwrap(googleReleaseCertificates));
                    Set<ICertData> set2 = zzbb;
                    return set2;
                } catch (RemoteException e) {
                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                    return Collections.emptySet();
                }
            } catch (DynamiteModule.LoadingException e2) {
                Log.e("GoogleCertificates", "Failed to load com.google.android.gms.googlecertificates", e2);
                return Collections.emptySet();
            }
        }
    }
}
