package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashSet;
import java.util.Set;

public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzbv;
    private final Context mContext;

    private GoogleSignatureVerifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zzbv == null) {
                GoogleCertificates.init(context);
                zzbv = new GoogleSignatureVerifier(context);
            }
        }
        return zzbv;
    }

    @VisibleForTesting
    public static synchronized void resetForTests() {
        synchronized (GoogleSignatureVerifier.class) {
            zzbv = null;
        }
    }

    private static GoogleCertificates.CertData zza(PackageInfo packageInfo, GoogleCertificates.CertData... certDataArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < certDataArr.length; i++) {
            if (certDataArr[i].equals(zzb)) {
                return certDataArr[i];
            }
        }
        return null;
    }

    private final zzg zza(PackageInfo packageInfo) {
        String str;
        boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
        if (packageInfo == null) {
            str = "null pkg";
        } else if (packageInfo.signatures.length != 1) {
            str = "single cert required";
        } else {
            zzb zzb = new zzb(packageInfo.signatures[0].toByteArray());
            String str2 = packageInfo.packageName;
            zzg zza = GoogleCertificates.zza(str2, zzb, honorsDebugCertificates);
            if (!zza.zzbl || packageInfo.applicationInfo == null || (packageInfo.applicationInfo.flags & 2) == 0 || (honorsDebugCertificates && !GoogleCertificates.zza(str2, zzb, false).zzbl)) {
                return zza;
            }
            str = "debuggable release cert app rejected";
        }
        return zzg.zze(str);
    }

    private final zzg zzb(int i) {
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i);
        if (packagesForUid == null || packagesForUid.length == 0) {
            return zzg.zze("no pkgs");
        }
        zzg zzg = null;
        for (String zzf : packagesForUid) {
            zzg = zzf(zzf);
            if (zzg.zzbl) {
                return zzg;
            }
        }
        return zzg;
    }

    private final zzg zzf(String str) {
        try {
            return zza(Wrappers.packageManager(this.mContext).getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzg.zze(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    @Deprecated
    public Set<byte[]> getAllGoogleSignatures(boolean z) {
        Set<ICertData> zzd = z ? GoogleCertificates.zzd() : GoogleCertificates.zze();
        HashSet hashSet = new HashSet(zzd.size());
        try {
            for (ICertData bytesWrapped : zzd) {
                hashSet.add((byte[]) ObjectWrapper.unwrap(bytesWrapped.getBytesWrapped()));
            }
        } catch (RemoteException e) {
            Log.e("GoogleSignatureVerifier", "Failed to get Google certificates from remote", e);
        }
        return hashSet;
    }

    public boolean isChimeraSigned(PackageManager packageManager, PackageInfo packageInfo) {
        String str = packageInfo.packageName;
        packageInfo.packageName = "com.google.android.gms.chimera";
        boolean isPackageGoogleSigned = isPackageGoogleSigned(packageInfo);
        packageInfo.packageName = str;
        return isPackageGoogleSigned;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean
     arg types: [android.content.pm.PackageInfo, int]
     candidates:
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageManager, android.content.pm.PackageInfo):boolean
      com.google.android.gms.common.GoogleSignatureVerifier.isGooglePublicSignedPackage(android.content.pm.PackageInfo, boolean):boolean */
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (isGooglePublicSignedPackage(packageInfo, false)) {
            return true;
        }
        if (isGooglePublicSignedPackage(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo, boolean z) {
        GoogleCertificates.CertData certData;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                certData = zza(packageInfo, zzd.zzbg);
            } else {
                certData = zza(packageInfo, zzd.zzbg[0]);
            }
            if (certData != null) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public boolean isGooglePublicSignedPackage(PackageManager packageManager, PackageInfo packageInfo) {
        return isGooglePublicSignedPackage(packageInfo);
    }

    public boolean isPackageGoogleSigned(PackageInfo packageInfo) {
        zzg zza = zza(packageInfo);
        zza.zzi();
        return zza.zzbl;
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, PackageInfo packageInfo) {
        return isPackageGoogleSigned(packageInfo);
    }

    @Deprecated
    public boolean isPackageGoogleSigned(PackageManager packageManager, String str) {
        return isPackageGoogleSigned(str);
    }

    public boolean isPackageGoogleSigned(String str) {
        zzg zzf = zzf(str);
        zzf.zzi();
        return zzf.zzbl;
    }

    public boolean isUidGoogleSigned(int i) {
        zzg zzb = zzb(i);
        zzb.zzi();
        return zzb.zzbl;
    }

    @Deprecated
    public boolean isUidGoogleSigned(PackageManager packageManager, int i) {
        return isUidGoogleSigned(i);
    }

    @Deprecated
    public void verifyPackageIsGoogleSigned(PackageManager packageManager, String str) throws SecurityException {
        verifyPackageIsGoogleSigned(str);
    }

    public void verifyPackageIsGoogleSigned(String str) throws SecurityException {
        zzf(str).zzh();
    }

    public void verifyUidIsGoogleSigned(int i) throws SecurityException {
        zzb(i).zzh();
    }

    @Deprecated
    public void verifyUidIsGoogleSigned(PackageManager packageManager, int i) throws SecurityException {
        verifyUidIsGoogleSigned(i);
    }
}
