package _m_j;

import _m_j.blr;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class bmi {
    private static volatile bmi O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f13096O000000o;
    public int O00000Oo;
    private Object O00000o;
    private Context O00000o0;

    bmi() {
        this.f13096O000000o = 0;
        this.O00000Oo = 0;
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000o0 = blw.f13081O000000o;
        Context context = this.O00000o0;
        if (context != null) {
            try {
                this.O00000o = bna.O000000o(context, bnd.O00000o0("989a8baf9e9c949e989ab29e919e989a8d"));
            } catch (Exception unused) {
            }
        }
    }

    public static bmi O000000o() {
        if (O00000oO == null) {
            synchronized (bmi.class) {
                if (O00000oO == null) {
                    O00000oO = new bmi();
                }
            }
        }
        return O00000oO;
    }

    public static String O000000o(Object obj) {
        try {
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream((byte[]) bna.O000000o(obj, bnd.O00000o0("8b90bd868b9abe8d8d9e86"))))).getSubjectDN().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static int O00000oo() {
        return (blw.f13081O000000o.getApplicationInfo().flags & 2) > 0 ? 1 : 0;
    }

    public final String O00000Oo() {
        Context context = this.O00000o0;
        if (context == null) {
            return "";
        }
        try {
            String str = context.getPackageManager().getPackageInfo(O00000o0(), 0).versionName;
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000o() {
        try {
            if (this.O00000o0 == null) {
                return "";
            }
            if (this.O00000o != null) {
                String str = (String) bna.O000000o(bna.O00000Oo(bna.O000000o(this.O00000o, "getPackageInfo", new Class[]{String.class, Integer.TYPE}, new Object[]{blw.f13081O000000o.getPackageName(), 0}), bnd.O00000o0("9e8f8f93969c9e8b969091b6919990")), bnd.O00000o0("93909e9bb39e9d9a93"), new Class[]{PackageManager.class}, new Object[]{this.O00000o});
                return str == null ? "" : str;
            }
            throw new Exception();
        } catch (Exception unused) {
            return "";
        }
    }

    public final String O00000o0() {
        String str;
        Context context = this.O00000o0;
        if (context == null) {
            return "";
        }
        try {
            str = (String) bna.O000000o(context, bnd.O00000o0("989a8baf9e9c949e989ab19e929a"));
        } catch (Exception unused) {
            str = "";
        }
        return str == null ? "" : str;
    }

    public final Object O00000oO() {
        Object[] objArr;
        Object obj = this.O00000o;
        if (!(obj == null || this.O00000o0 == null)) {
            try {
                Object O000000o2 = bna.O000000o(obj, bnd.O00000o0("989a8baf9e9c949e989ab6919990"), new Class[]{String.class, Integer.TYPE}, new Object[]{this.O00000o0.getPackageName(), 64});
                if (!(O000000o2 == null || (objArr = (Object[]) bna.O00000Oo(O000000o2, bnd.O00000o0("8c9698919e8b8a8d9a8c"))) == null || objArr.length <= 0)) {
                    return objArr[0];
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009a A[Catch:{ Exception -> 0x015b }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8 A[Catch:{ Exception -> 0x015b }] */
    public final synchronized Map<String, Object> O000000o(Map<String, blr.O00000o> map, int i, int i2) {
        HashMap hashMap;
        int i3;
        Object obj;
        List list;
        HashMap hashMap2;
        this.f13096O000000o = 0;
        this.O00000Oo = 0;
        hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        if (this.O00000o0 == null) {
            return hashMap;
        }
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                hashMap4.put(((blr.O00000o) next.getValue()).O00000Oo, (String) next.getKey());
            }
        }
        try {
            if (this.O00000o != null) {
                Object obj2 = this.O00000o;
                int i4 = 1;
                List list2 = (List) bna.O000000o(obj2, bnd.O00000o0("989a8bb6918c8b9e93939a9baf9e9c949e989a8c"), new Class[]{Integer.TYPE}, new Object[]{0});
                Collections.sort(list2, new Comparator<PackageInfo>() {
                    /* class _m_j.bmi.AnonymousClass1 */

                    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028 A[Catch:{ Exception -> 0x0040 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0040 }] */
                    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037 A[ADDED_TO_REGION, Catch:{ Exception -> 0x0040 }] */
                    private static int O000000o(PackageInfo packageInfo, PackageInfo packageInfo2) {
                        boolean z;
                        boolean z2;
                        try {
                            int i = packageInfo.applicationInfo.flags;
                            int i2 = packageInfo2.applicationInfo.flags;
                            Long valueOf = Long.valueOf(-packageInfo.firstInstallTime);
                            Long valueOf2 = Long.valueOf(-packageInfo2.firstInstallTime);
                            if ((i & 1) <= 0) {
                                if ((i & NotificationCompat.FLAG_HIGH_PRIORITY) <= 0) {
                                    z = false;
                                    if ((i2 & 1) <= 0) {
                                        if ((i2 & NotificationCompat.FLAG_HIGH_PRIORITY) <= 0) {
                                            z2 = false;
                                            if (!z && !z2) {
                                                return 1;
                                            }
                                            if (!z || !z2) {
                                                return valueOf.compareTo(valueOf2);
                                            }
                                            return -1;
                                        }
                                    }
                                    z2 = true;
                                    if (!z) {
                                    }
                                    if (!z) {
                                    }
                                    return valueOf.compareTo(valueOf2);
                                }
                            }
                            z = true;
                            if ((i2 & 1) <= 0) {
                            }
                            z2 = true;
                            if (!z) {
                            }
                            if (!z) {
                            }
                            return valueOf.compareTo(valueOf2);
                        } catch (Exception e) {
                            bmz.O000000o(e);
                            return 0;
                        }
                    }

                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                        return O000000o((PackageInfo) obj, (PackageInfo) obj2);
                    }
                });
                int i5 = 0;
                while (i5 < list2.size()) {
                    PackageInfo packageInfo = (PackageInfo) list2.get(i5);
                    String str = packageInfo.packageName;
                    ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    int i6 = applicationInfo.flags;
                    if ((i6 & 1) <= 0) {
                        int i7 = i6 & NotificationCompat.FLAG_HIGH_PRIORITY;
                        if (i7 <= 0) {
                            if (i7 == 0) {
                                i3 = 1;
                                if (!hashMap4.containsKey(str)) {
                                    hashMap3.put((String) hashMap4.get(str), Integer.valueOf(i4));
                                } else {
                                    if (i3 != 0) {
                                        int i8 = i;
                                    } else if (this.f13096O000000o < i) {
                                    }
                                    if (i3 != i4) {
                                        int i9 = i2;
                                    } else if (this.O00000Oo < i2) {
                                    }
                                    String charSequence = Build.VERSION.SDK_INT >= 29 ? "" : applicationInfo.loadLabel((PackageManager) obj2).toString();
                                    hashMap2 = hashMap4;
                                    Object obj3 = obj2;
                                    long j = packageInfo.firstInstallTime;
                                    String str2 = packageInfo.versionName;
                                    list = list2;
                                    obj = obj3;
                                    arrayList.add(j + "," + str + "," + charSequence + "," + i3 + "," + packageInfo.versionCode + "," + str2 + "," + packageInfo.lastUpdateTime);
                                    if (i3 == 1) {
                                        this.O00000Oo++;
                                        i5++;
                                        hashMap4 = hashMap2;
                                        list2 = list;
                                        obj2 = obj;
                                        i4 = 1;
                                    } else {
                                        this.f13096O000000o++;
                                        i5++;
                                        hashMap4 = hashMap2;
                                        list2 = list;
                                        obj2 = obj;
                                        i4 = 1;
                                    }
                                }
                                hashMap2 = hashMap4;
                                obj = obj2;
                                list = list2;
                                i5++;
                                hashMap4 = hashMap2;
                                list2 = list;
                                obj2 = obj;
                                i4 = 1;
                            }
                        }
                    }
                    i3 = 0;
                    if (!hashMap4.containsKey(str)) {
                    }
                    hashMap2 = hashMap4;
                    obj = obj2;
                    list = list2;
                    i5++;
                    hashMap4 = hashMap2;
                    list2 = list;
                    obj2 = obj;
                    i4 = 1;
                }
                hashMap.put(bnd.O00000o0("9e8f8f8c"), arrayList);
                hashMap.put(bnd.O00000o0("8897968b9a9e8f8f"), hashMap3);
            } else {
                throw new Exception();
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }
}
