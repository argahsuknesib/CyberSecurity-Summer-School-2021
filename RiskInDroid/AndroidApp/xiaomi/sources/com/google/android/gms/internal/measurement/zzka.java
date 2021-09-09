package com.google.android.gms.internal.measurement;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.security.auth.x500.X500Principal;

public final class zzka extends zzhh {
    private static final String[] zzard = {"firebase_", "google_", "ga_"};
    private SecureRandom zzare;
    private final AtomicLong zzarf = new AtomicLong(0);
    private int zzarg;
    private Integer zzarh = null;

    zzka(zzgl zzgl) {
        super(zzgl);
    }

    static MessageDigest getMessageDigest(String str) {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    public static zzko zza(zzkn zzkn, String str) {
        for (zzko zzko : zzkn.zzata) {
            if (zzko.name.equals(str)) {
                return zzko;
            }
        }
        return null;
    }

    private static Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(String str, int i, boolean z) {
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i))).concat("...");
        }
        return null;
    }

    public static String zza(String str, String[] strArr, String[] strArr2) {
        Preconditions.checkNotNull(strArr);
        Preconditions.checkNotNull(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i = 0; i < min; i++) {
            if (zzs(str, strArr[i])) {
                return strArr2[i];
            }
        }
        return null;
    }

    private static void zza(Bundle bundle, Object obj) {
        Preconditions.checkNotNull(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    private static boolean zza(Bundle bundle, int i) {
        if (bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    private final boolean zza(String str, String str2, int i, Object obj, boolean z) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                String valueOf = String.valueOf(obj);
                if (valueOf.codePointCount(0, valueOf.length()) > i) {
                    zzge().zzip().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                    return false;
                }
            } else if ((obj instanceof Bundle) && z) {
                return true;
            } else {
                if ((obj instanceof Parcelable[]) && z) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            zzge().zzip().zze("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof ArrayList) || !z) {
                    return false;
                } else {
                    ArrayList arrayList = (ArrayList) obj;
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        Object obj2 = arrayList.get(i2);
                        i2++;
                        if (!(obj2 instanceof Bundle)) {
                            zzge().zzip().zze("All ArrayList elements must be of type Bundle. Value type, name", obj2.getClass(), str2);
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean zza(long[] jArr, int i) {
        if (i >= (jArr.length << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & jArr[i / 64]) != 0;
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
            }
        }
        return jArr;
    }

    static zzko[] zza(zzko[] zzkoArr, String str, Object obj) {
        for (zzko zzko : zzkoArr) {
            if (str.equals(zzko.name)) {
                zzko.zzate = null;
                zzko.zzajf = null;
                zzko.zzarc = null;
                if (obj instanceof Long) {
                    zzko.zzate = (Long) obj;
                } else if (obj instanceof String) {
                    zzko.zzajf = (String) obj;
                } else if (obj instanceof Double) {
                    zzko.zzarc = (Double) obj;
                }
                return zzkoArr;
            }
        }
        zzko[] zzkoArr2 = new zzko[(zzkoArr.length + 1)];
        System.arraycopy(zzkoArr, 0, zzkoArr2, 0, zzkoArr.length);
        zzko zzko2 = new zzko();
        zzko2.name = str;
        if (obj instanceof Long) {
            zzko2.zzate = (Long) obj;
        } else if (obj instanceof String) {
            zzko2.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            zzko2.zzarc = (Double) obj;
        }
        zzkoArr2[zzkoArr.length] = zzko2;
        return zzkoArr2;
    }

    public static Object zzb(zzkn zzkn, String str) {
        zzko zza = zza(zzkn, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzajf != null) {
            return zza.zzajf;
        }
        if (zza.zzate != null) {
            return zza.zzate;
        }
        if (zza.zzarc != null) {
            return zza.zzarc;
        }
        return null;
    }

    @VisibleForTesting
    static long zzc(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static boolean zzc(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            return (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean zzcc(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    private static int zzch(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        return "_id".equals(str) ? 256 : 36;
    }

    public static boolean zzci(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzck(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[ADDED_TO_REGION] */
    static boolean zzcl(String str) {
        char c;
        Preconditions.checkNotEmpty(str);
        int hashCode = str.hashCode();
        if (hashCode != 94660) {
            if (hashCode != 95025) {
                if (hashCode == 95027 && str.equals("_ui")) {
                    c = 1;
                    return c != 0 || c == 1 || c == 2;
                }
            } else if (str.equals("_ug")) {
                c = 2;
                if (c != 0) {
                }
            }
        } else if (str.equals("_in")) {
            c = 0;
            if (c != 0) {
            }
        }
        c = 65535;
        if (c != 0) {
        }
    }

    public static boolean zzd(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static boolean zzd(zzeu zzeu, zzdz zzdz) {
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotNull(zzdz);
        return !TextUtils.isEmpty(zzdz.zzadm);
    }

    @VisibleForTesting
    private final boolean zze(Context context, String str) {
        zzfi zzfi;
        String str2;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            e = e;
            zzfi = zzge().zzim();
            str2 = "Error obtaining certificate";
            zzfi.zzg(str2, e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            e = e2;
            zzfi = zzge().zzim();
            str2 = "Package name not found";
            zzfi.zzg(str2, e);
            return true;
        }
    }

    public static Bundle[] zze(Object obj) {
        Object[] array;
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            array = Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            array = arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return (Bundle[]) array;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0037 A[Catch:{ IOException | ClassNotFoundException -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003c A[Catch:{ IOException | ClassNotFoundException -> 0x0040 }] */
    public static Object zzf(Object obj) {
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        if (obj == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            } catch (Throwable th) {
                th = th;
                objectInputStream = null;
                if (objectOutputStream != null) {
                }
                if (objectInputStream != null) {
                }
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    objectOutputStream.close();
                    objectInputStream.close();
                    return readObject;
                } catch (IOException | ClassNotFoundException unused) {
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                }
                if (objectInputStream != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            objectInputStream = null;
            objectOutputStream = null;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            throw th;
        }
    }

    private final boolean zzr(String str, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzge().zzim().zze("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    public static boolean zzs(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public final Bundle zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str4 = uri.getQueryParameter("utm_campaign");
                str3 = uri.getQueryParameter("utm_source");
                str2 = uri.getQueryParameter("utm_medium");
                str = uri.getQueryParameter("gclid");
            } else {
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("campaign", str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("source", str3);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("medium", str2);
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("gclid", str);
            }
            String queryParameter = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("term", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("aclid", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("cp1", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzge().zzip().zzg("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String
     arg types: [java.lang.String, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(int, java.lang.Object, boolean):java.lang.Object
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String[]):java.lang.String
      com.google.android.gms.internal.measurement.zzka.zza(com.google.android.gms.internal.measurement.zzko[], java.lang.String, java.lang.Object):com.google.android.gms.internal.measurement.zzko[]
      com.google.android.gms.internal.measurement.zzka.zza(android.os.Bundle, java.lang.String, java.lang.Object):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String[], java.lang.String):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, boolean):java.lang.String */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004d, code lost:
        if (zza("event param", 40, r14) == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (zza("event param", 40, r14) == false) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc  */
    public final Bundle zza(String str, Bundle bundle, List<String> list, boolean z, boolean z2) {
        int i;
        String str2;
        boolean z3;
        int i2;
        Object obj;
        int i3;
        String str3;
        String str4;
        zzka zzka;
        boolean z4;
        int i4;
        int i5;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        String[] strArr = null;
        if (bundle2 == null) {
            return null;
        }
        Bundle bundle3 = new Bundle(bundle2);
        Iterator<String> it = bundle.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (list2 == null || !list2.contains(next)) {
                i = 14;
                if (z) {
                    if (zzq("event param", next)) {
                        if (!zza("event param", strArr, next)) {
                            i5 = 14;
                            if (i5 == 0) {
                                if (zzr("event param", next)) {
                                    if (zza("event param", strArr, next)) {
                                    }
                                }
                                i = 3;
                            } else {
                                i = i5;
                            }
                            if (i == 0) {
                                if (zza(bundle3, i)) {
                                    bundle3.putString("_ev", zza(next, 40, true));
                                    if (i == 3) {
                                        zza(bundle3, next);
                                    }
                                }
                                bundle3.remove(next);
                            } else {
                                Object obj2 = bundle2.get(next);
                                zzab();
                                if (z2) {
                                    if (obj2 instanceof Parcelable[]) {
                                        i4 = ((Parcelable[]) obj2).length;
                                    } else {
                                        if (obj2 instanceof ArrayList) {
                                            i4 = ((ArrayList) obj2).size();
                                        }
                                        z4 = true;
                                        if (!z4) {
                                            i2 = 17;
                                            str2 = "_ev";
                                            z3 = true;
                                            if (i2 == 0 && !str2.equals(next)) {
                                                if (zza(bundle3, i2)) {
                                                    bundle3.putString(str2, zza(next, 40, z3));
                                                    zza(bundle3, bundle2.get(next));
                                                }
                                                bundle3.remove(next);
                                            } else if (!zzcc(next) && (i6 = i6 + 1) > 25) {
                                                StringBuilder sb = new StringBuilder(48);
                                                sb.append("Event can't contain more than 25 params");
                                                zzge().zzim().zze(sb.toString(), zzga().zzbj(str), zzga().zzb(bundle2));
                                                zza(bundle3, 5);
                                                bundle3.remove(next);
                                            }
                                        }
                                    }
                                    if (i4 > 1000) {
                                        zzge().zzip().zzd("Parameter array is too long; discarded. Value kind, name, array length", "param", next, Integer.valueOf(i4));
                                        z4 = false;
                                        if (!z4) {
                                        }
                                    }
                                    z4 = true;
                                    if (!z4) {
                                    }
                                }
                                if ((!zzgg().zzaw(zzfv().zzah()) || !zzci(str)) && !zzci(next)) {
                                    Object obj3 = obj2;
                                    str2 = "_ev";
                                    z3 = true;
                                    i3 = 100;
                                    str4 = "param";
                                    zzka = this;
                                    str3 = next;
                                    obj = obj3;
                                } else {
                                    str4 = "param";
                                    zzka = this;
                                    str3 = next;
                                    Object obj4 = obj2;
                                    i3 = 256;
                                    z3 = true;
                                    obj = obj4;
                                    str2 = "_ev";
                                }
                                i2 = zzka.zza(str4, str3, i3, obj, z2) ? 0 : 4;
                                if (i2 == 0) {
                                }
                                if (!zzcc(next)) {
                                }
                            }
                            strArr = null;
                        }
                    }
                    i5 = 3;
                    if (i5 == 0) {
                    }
                    if (i == 0) {
                    }
                    strArr = null;
                }
                i5 = 0;
                if (i5 == 0) {
                }
                if (i == 0) {
                }
                strArr = null;
            }
            i = 0;
            if (i == 0) {
            }
            strArr = null;
        }
        return bundle3;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzge().zzim().log("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t = (Parcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle
     arg types: [java.lang.String, android.os.Bundle, java.util.List, int, int]
     candidates:
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, java.lang.String, int, java.lang.Object, boolean):boolean
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, int, java.lang.String, java.lang.String, int):void
      com.google.android.gms.internal.measurement.zzka.zza(java.lang.String, android.os.Bundle, java.util.List<java.lang.String>, boolean, boolean):android.os.Bundle */
    /* access modifiers changed from: package-private */
    public final zzeu zza(String str, Bundle bundle, String str2, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (zzcd(str) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str2);
            String str3 = str;
            return new zzeu(str3, new zzer(zzd(zza(str3, bundle2, (List<String>) CollectionUtils.listOf("_o"), false, false))), str2, j);
        }
        zzge().zzim().zzg("Invalid conditional property event name", zzga().zzbl(str));
        throw new IllegalArgumentException();
    }

    public final void zza(int i, String str, String str2, int i2) {
        zza((String) null, i, str, str2, i2);
    }

    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzge().zziq().zze("Not putting event parameter. Invalid value type. name, type", zzga().zzbk(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzko zzko, Object obj) {
        Preconditions.checkNotNull(obj);
        zzko.zzajf = null;
        zzko.zzate = null;
        zzko.zzarc = null;
        if (obj instanceof String) {
            zzko.zzajf = (String) obj;
        } else if (obj instanceof Long) {
            zzko.zzate = (Long) obj;
        } else if (obj instanceof Double) {
            zzko.zzarc = (Double) obj;
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zza(zzks zzks, Object obj) {
        Preconditions.checkNotNull(obj);
        zzks.zzajf = null;
        zzks.zzate = null;
        zzks.zzarc = null;
        if (obj instanceof String) {
            zzks.zzajf = (String) obj;
        } else if (obj instanceof Long) {
            zzks.zzate = (Long) obj;
        } else if (obj instanceof Double) {
            zzks.zzarc = (Double) obj;
        } else {
            zzge().zzim().zzg("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final void zza(String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zza(bundle, i);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.zzacw.zzfu().logEvent("auto", "_err", bundle);
    }

    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzbt().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzge().zzim().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        boolean z;
        boolean z2;
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        int i = 0;
        while (true) {
            String[] strArr2 = zzard;
            if (i >= strArr2.length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr2[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzge().zzim().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr != null) {
            Preconditions.checkNotNull(strArr);
            int i2 = 0;
            while (true) {
                if (i2 >= strArr.length) {
                    z2 = false;
                    break;
                } else if (zzs(str2, strArr[i2])) {
                    z2 = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                zzge().zzim().zze("Name is reserved. Type, name", str, str2);
                return false;
            }
        }
        return true;
    }

    public final byte[] zza(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to gzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final byte[] zzb(zzkp zzkp) {
        try {
            byte[] bArr = new byte[zzkp.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkp.zza(zzb);
            zzb.zzve();
            return bArr;
        } catch (IOException e) {
            zzge().zzim().zzg("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final int zzcd(String str) {
        if (!zzr("event", str)) {
            return 2;
        }
        if (!zza("event", AppMeasurement.Event.zzacx, str)) {
            return 13;
        }
        return !zza("event", 40, str) ? 2 : 0;
    }

    public final int zzce(String str) {
        if (!zzq("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            return 15;
        }
        return !zza("user property", 24, str) ? 6 : 0;
    }

    public final int zzcf(String str) {
        if (!zzr("user property", str)) {
            return 6;
        }
        if (!zza("user property", AppMeasurement.UserProperty.zzadb, str)) {
            return 15;
        }
        return !zza("user property", 24, str) ? 6 : 0;
    }

    public final boolean zzcg(String str) {
        if (TextUtils.isEmpty(str)) {
            zzge().zzim().log("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
            return true;
        }
        zzge().zzim().zzg("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", str);
        return false;
    }

    public final boolean zzcj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zzgg().zzhj().equals(str);
    }

    /* access modifiers changed from: package-private */
    public final long zzd(Context context, String str) {
        zzab();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest messageDigest = getMessageDigest("MD5");
        if (messageDigest == null) {
            zzge().zzim().log("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zze(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(getContext().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zzc(messageDigest.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzge().zzip().log("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzge().zzim().zzg("Package name not found", e);
            }
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object zzh = zzh(next, bundle.get(next));
                if (zzh == null) {
                    zzge().zzip().zzg("Param value can't be null", zzga().zzbk(next));
                } else {
                    zza(bundle2, next, zzh);
                }
            }
        }
        return bundle2;
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    public final Object zzh(String str, Object obj) {
        boolean z;
        int i = 256;
        if ("_ev".equals(str)) {
            z = true;
        } else {
            if (!zzci(str)) {
                i = 100;
            }
            z = false;
        }
        return zza(i, obj, z);
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return true;
    }

    public final int zzi(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzch(str), obj, false) : zza("user property", str, zzch(str), obj, false) ? 0 : 7;
    }

    /* access modifiers changed from: protected */
    public final void zzih() {
        zzab();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzge().zzip().log("Utils falling back to Random for random id");
            }
        }
        this.zzarf.set(nextLong);
    }

    public final Object zzj(String str, Object obj) {
        int zzch;
        boolean z;
        if ("_ldl".equals(str)) {
            zzch = zzch(str);
            z = true;
        } else {
            zzch = zzch(str);
            z = false;
        }
        return zza(zzch, obj, z);
    }

    public final long zzlb() {
        long andIncrement;
        long j;
        if (this.zzarf.get() == 0) {
            synchronized (this.zzarf) {
                long nextLong = new Random(System.nanoTime() ^ zzbt().currentTimeMillis()).nextLong();
                int i = this.zzarg + 1;
                this.zzarg = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzarf) {
            this.zzarf.compareAndSet(-1, 1);
            andIncrement = this.zzarf.getAndIncrement();
        }
        return andIncrement;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom zzlc() {
        zzab();
        if (this.zzare == null) {
            this.zzare = new SecureRandom();
        }
        return this.zzare;
    }

    public final int zzld() {
        if (this.zzarh == null) {
            this.zzarh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(getContext()) / 1000);
        }
        return this.zzarh.intValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzq(String str, String str2) {
        if (str2 == null) {
            zzge().zzim().zzg("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzge().zzim().zzg("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzge().zzim().zze("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzge().zzim().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public final boolean zzx(String str) {
        zzab();
        if (Wrappers.packageManager(getContext()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzge().zzis().zzg("Permission not granted", str);
        return false;
    }
}
