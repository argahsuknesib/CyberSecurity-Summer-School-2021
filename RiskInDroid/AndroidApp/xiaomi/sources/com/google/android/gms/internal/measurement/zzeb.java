package com.google.android.gms.internal.measurement;

import _m_j.o0O0OOO0;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzeb extends zzjq {
    zzeb(zzjr zzjr) {
        super(zzjr);
    }

    private final Boolean zza(double d, zzkg zzkg) {
        try {
            return zza(new BigDecimal(d), zzkg, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(long j, zzkg zzkg) {
        try {
            return zza(new BigDecimal(j), zzkg, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        boolean startsWith;
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzge().zzip().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                startsWith = str.startsWith(str2);
                break;
            case 3:
                startsWith = str.endsWith(str2);
                break;
            case 4:
                startsWith = str.contains(str2);
                break;
            case 5:
                startsWith = str.equals(str2);
                break;
            case 6:
                startsWith = list.contains(str);
                break;
            default:
                return null;
        }
        return Boolean.valueOf(startsWith);
    }

    private final Boolean zza(String str, zzkg zzkg) {
        if (!zzka.zzck(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzkg, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzki zzki) {
        ArrayList arrayList;
        Preconditions.checkNotNull(zzki);
        if (str == null || zzki.zzash == null || zzki.zzash.intValue() == 0) {
            return null;
        }
        if (zzki.zzash.intValue() == 6) {
            if (zzki.zzask == null || zzki.zzask.length == 0) {
                return null;
            }
        } else if (zzki.zzasi == null) {
            return null;
        }
        int intValue = zzki.zzash.intValue();
        boolean z = zzki.zzasj != null && zzki.zzasj.booleanValue();
        String upperCase = (z || intValue == 1 || intValue == 6) ? zzki.zzasi : zzki.zzasi.toUpperCase(Locale.ENGLISH);
        if (zzki.zzask == null) {
            arrayList = null;
        } else {
            String[] strArr = zzki.zzask;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                ArrayList arrayList2 = new ArrayList();
                for (String upperCase2 : strArr) {
                    arrayList2.add(upperCase2.toUpperCase(Locale.ENGLISH));
                }
                arrayList = arrayList2;
            }
        }
        return zza(str, intValue, z, upperCase, arrayList, intValue == 1 ? upperCase : null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0071, code lost:
        if (r3 != null) goto L_0x0073;
     */
    @VisibleForTesting
    private static Boolean zza(BigDecimal bigDecimal, zzkg zzkg, double d) {
        BigDecimal bigDecimal2;
        BigDecimal bigDecimal3;
        BigDecimal bigDecimal4;
        Preconditions.checkNotNull(zzkg);
        if (!(zzkg.zzarz == null || zzkg.zzarz.intValue() == 0)) {
            if (zzkg.zzarz.intValue() == 4) {
                if (zzkg.zzasc == null || zzkg.zzasd == null) {
                    return null;
                }
            } else if (zzkg.zzasb == null) {
                return null;
            }
            int intValue = zzkg.zzarz.intValue();
            if (zzkg.zzarz.intValue() == 4) {
                if (zzka.zzck(zzkg.zzasc) && zzka.zzck(zzkg.zzasd)) {
                    try {
                        BigDecimal bigDecimal5 = new BigDecimal(zzkg.zzasc);
                        bigDecimal3 = new BigDecimal(zzkg.zzasd);
                        bigDecimal2 = bigDecimal5;
                        bigDecimal4 = null;
                    } catch (NumberFormatException unused) {
                    }
                }
                return null;
            } else if (!zzka.zzck(zzkg.zzasb)) {
                return null;
            } else {
                try {
                    bigDecimal4 = new BigDecimal(zzkg.zzasb);
                    bigDecimal2 = null;
                    bigDecimal3 = null;
                } catch (NumberFormatException unused2) {
                }
            }
            if (intValue == 4) {
                if (bigDecimal2 == null) {
                    return null;
                }
            }
            boolean z = false;
            if (intValue == 1) {
                if (bigDecimal.compareTo(bigDecimal4) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (intValue == 2) {
                if (bigDecimal.compareTo(bigDecimal4) == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else if (intValue != 3) {
                if (intValue == 4) {
                    if (!(bigDecimal.compareTo(bigDecimal2) == -1 || bigDecimal.compareTo(bigDecimal3) == 1)) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            } else if (d != 0.0d) {
                if (bigDecimal.compareTo(bigDecimal4.subtract(new BigDecimal(d).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(bigDecimal4.add(new BigDecimal(d).multiply(new BigDecimal(2)))) == -1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            } else {
                if (bigDecimal.compareTo(bigDecimal4) == 0) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r29v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v39, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v103, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v110, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: java.lang.Long} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x06f6, code lost:
        r2 = java.lang.Boolean.FALSE;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x037c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0504  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0727  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x072a  */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x0732  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x073a  */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0a26  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0a29  */
    /* JADX WARNING: Removed duplicated region for block: B:298:0x0a31  */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0a48  */
    /* JADX WARNING: Removed duplicated region for block: B:366:0x0595 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x029e  */
    public final zzkm[] zza(String str, zzkn[] zzknArr, zzks[] zzksArr) {
        String str2;
        Object obj;
        zzfi zzfi;
        ContentValues contentValues;
        int i;
        zzkh zzkh;
        Map map;
        Iterator it;
        Iterator it2;
        String str3;
        int i2;
        Boolean bool;
        Map map2;
        String str4;
        String str5;
        zzfi zzfi2;
        Boolean zza;
        zzfi zzip;
        String zzbl;
        String str6;
        o0O0OOO0 o0o0ooo0;
        o0O0OOO0 o0o0ooo02;
        o0O0OOO0 o0o0ooo03;
        String str7;
        String str8;
        o0O0OOO0 o0o0ooo04;
        int i3;
        int i4;
        HashSet hashSet;
        zzeb zzeb;
        o0O0OOO0 o0o0ooo05;
        HashSet hashSet2;
        zzkn zzkn;
        String str9;
        zzeq zzf;
        zzko[] zzkoArr;
        HashSet hashSet3;
        zzeq zzeq;
        String str10;
        Map map3;
        Iterator it3;
        HashSet hashSet4;
        o0O0OOO0 o0o0ooo06;
        Iterator it4;
        Iterator it5;
        String str11;
        o0O0OOO0 o0o0ooo07;
        o0O0OOO0 o0o0ooo08;
        String str12;
        String str13;
        long j;
        String str14;
        String str15;
        Map map4;
        Boolean bool2;
        zzeb zzeb2;
        int length;
        int i5;
        zzko[] zzkoArr2;
        int length2;
        int i6;
        zzfi zzip2;
        String zzbj;
        String zzbk;
        String str16;
        Boolean bool3;
        String str17;
        Object obj2;
        boolean z;
        Long l;
        HashSet hashSet5;
        zzkn zzkn2;
        int i7;
        String str18;
        zzkn zzkn3;
        int i8;
        o0O0OOO0 o0o0ooo09;
        Iterator<Integer> it6;
        Map<Integer, zzkr> map5;
        zzeb zzeb3 = this;
        String str19 = str;
        zzkn[] zzknArr2 = zzknArr;
        Preconditions.checkNotEmpty(str);
        HashSet hashSet6 = new HashSet();
        o0O0OOO0 o0o0ooo010 = new o0O0OOO0();
        o0O0OOO0 o0o0ooo011 = new o0O0OOO0();
        o0O0OOO0 o0o0ooo012 = new o0O0OOO0();
        Map<Integer, zzkr> zzbf = zzix().zzbf(str19);
        if (zzbf != null) {
            Iterator<Integer> it7 = zzbf.keySet().iterator();
            while (it7.hasNext()) {
                int intValue = it7.next().intValue();
                zzkr zzkr = zzbf.get(Integer.valueOf(intValue));
                BitSet bitSet = (BitSet) o0o0ooo011.get(Integer.valueOf(intValue));
                BitSet bitSet2 = (BitSet) o0o0ooo012.get(Integer.valueOf(intValue));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    o0o0ooo011.put(Integer.valueOf(intValue), bitSet);
                    bitSet2 = new BitSet();
                    o0o0ooo012.put(Integer.valueOf(intValue), bitSet2);
                }
                int i9 = 0;
                while (i9 < (zzkr.zzauk.length << 6)) {
                    if (zzka.zza(zzkr.zzauk, i9)) {
                        map5 = zzbf;
                        it6 = it7;
                        o0o0ooo09 = o0o0ooo011;
                        zzge().zzit().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue), Integer.valueOf(i9));
                        bitSet2.set(i9);
                        if (zzka.zza(zzkr.zzaul, i9)) {
                            bitSet.set(i9);
                        }
                    } else {
                        map5 = zzbf;
                        it6 = it7;
                        o0o0ooo09 = o0o0ooo011;
                    }
                    i9++;
                    zzbf = map5;
                    it7 = it6;
                    o0o0ooo011 = o0o0ooo09;
                }
                Map<Integer, zzkr> map6 = zzbf;
                zzkm zzkm = new zzkm();
                o0o0ooo010.put(Integer.valueOf(intValue), zzkm);
                zzkm.zzasy = Boolean.FALSE;
                zzkm.zzasx = zzkr;
                zzkm.zzasw = new zzkr();
                zzkm.zzasw.zzaul = zzka.zza(bitSet);
                zzkm.zzasw.zzauk = zzka.zza(bitSet2);
                zzbf = map6;
                it7 = it7;
            }
        }
        o0O0OOO0 o0o0ooo013 = o0o0ooo011;
        String str20 = "Filter definition";
        String str21 = "Skipping failed audience ID";
        if (zzknArr2 != null) {
            o0O0OOO0 o0o0ooo014 = new o0O0OOO0();
            int length3 = zzknArr2.length;
            long j2 = 0;
            zzkn zzkn4 = null;
            int i10 = 0;
            Long l2 = null;
            while (i10 < length3) {
                zzkn zzkn5 = zzknArr2[i10];
                String str22 = str20;
                String str23 = zzkn5.name;
                o0O0OOO0 o0o0ooo015 = o0o0ooo012;
                zzko[] zzkoArr3 = zzkn5.zzata;
                if (zzgg().zzd(str19, zzew.zzahv)) {
                    zzgb();
                    Long zzb = zzka.zzb(zzkn5, "_eid");
                    boolean z2 = zzb != null;
                    if (z2) {
                        i3 = i10;
                        if (str23.equals("_ep")) {
                            z = true;
                            if (!z) {
                                zzgb();
                                String zzb2 = zzka.zzb(zzkn5, "_en");
                                if (TextUtils.isEmpty(zzb2)) {
                                    zzge().zzim().zzg("Extra parameter without an event name. eventId", zzb);
                                    zzkn2 = zzkn4;
                                    i7 = length3;
                                    o0o0ooo04 = o0o0ooo014;
                                    str18 = str21;
                                    hashSet5 = hashSet6;
                                } else {
                                    if (zzkn4 == null || l2 == null || zzb.longValue() != l2.longValue()) {
                                        Pair<zzkn, Long> zza2 = zzix().zza(str19, zzb);
                                        if (zza2 != null) {
                                            zzkn2 = zzkn4;
                                            if (zza2.first != null) {
                                                zzkn4 = (zzkn) zza2.first;
                                                j2 = ((Long) zza2.second).longValue();
                                                zzgb();
                                                l2 = zzka.zzb(zzkn4, "_eid");
                                            }
                                        } else {
                                            zzkn2 = zzkn4;
                                        }
                                        i7 = length3;
                                        o0o0ooo04 = o0o0ooo014;
                                        str18 = str21;
                                        hashSet5 = hashSet6;
                                        zzge().zzim().zze("Extra parameter without existing main event. eventName, eventId", zzb2, zzb);
                                    }
                                    zzkn zzkn6 = zzkn4;
                                    j2--;
                                    if (j2 <= 0) {
                                        zzei zzix = zzix();
                                        zzix.zzab();
                                        zzix.zzge().zzit().zzg("Clearing complex main event info. appId", str19);
                                        try {
                                            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
                                            i4 = length3;
                                            hashSet2 = hashSet6;
                                            try {
                                                String[] strArr = new String[1];
                                                try {
                                                    strArr[0] = str19;
                                                    writableDatabase.execSQL("delete from main_event_params where app_id=?", strArr);
                                                } catch (SQLiteException e) {
                                                    e = e;
                                                }
                                            } catch (SQLiteException e2) {
                                                e = e2;
                                                zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                                o0o0ooo05 = o0o0ooo014;
                                                str8 = str21;
                                                zzkn3 = zzkn6;
                                                zzko[] zzkoArr4 = new zzko[(zzkn3.zzata.length + zzkoArr3.length)];
                                                i8 = 0;
                                                while (r4 < r3) {
                                                }
                                                if (i8 > 0) {
                                                }
                                                str9 = zzb2;
                                                zzkn = zzkn3;
                                                zzko[] zzkoArr5 = zzkoArr3;
                                                zzf = zzix().zzf(str19, zzkn5.name);
                                                if (zzf == null) {
                                                }
                                                zzix().zza(zzeq);
                                                long j3 = zzeq.zzafr;
                                                o0O0OOO0 o0o0ooo016 = o0o0ooo05;
                                                map3 = (Map) o0o0ooo016.get(str9);
                                                if (map3 == null) {
                                                }
                                                it3 = map3.keySet().iterator();
                                                while (it3.hasNext()) {
                                                }
                                                zzeb = this;
                                                str19 = str10;
                                                o0o0ooo04 = o0o0ooo016;
                                                hashSet = hashSet3;
                                                zzkn4 = zzkn;
                                                i10 = i3 + 1;
                                                zzknArr2 = zzknArr;
                                                zzeb3 = zzeb;
                                                hashSet6 = hashSet;
                                                length3 = i4;
                                                o0o0ooo014 = o0o0ooo04;
                                                str21 = str8;
                                                str20 = str7;
                                                o0o0ooo013 = o0o0ooo03;
                                                o0o0ooo012 = o0o0ooo02;
                                                o0o0ooo010 = o0o0ooo0;
                                            }
                                        } catch (SQLiteException e3) {
                                            e = e3;
                                            i4 = length3;
                                            hashSet2 = hashSet6;
                                            zzix.zzge().zzim().zzg("Error clearing complex main event", e);
                                            o0o0ooo05 = o0o0ooo014;
                                            str8 = str21;
                                            zzkn3 = zzkn6;
                                            zzko[] zzkoArr42 = new zzko[(zzkn3.zzata.length + zzkoArr3.length)];
                                            i8 = 0;
                                            while (r4 < r3) {
                                            }
                                            if (i8 > 0) {
                                            }
                                            str9 = zzb2;
                                            zzkn = zzkn3;
                                            zzko[] zzkoArr52 = zzkoArr3;
                                            zzf = zzix().zzf(str19, zzkn5.name);
                                            if (zzf == null) {
                                            }
                                            zzix().zza(zzeq);
                                            long j32 = zzeq.zzafr;
                                            o0O0OOO0 o0o0ooo0162 = o0o0ooo05;
                                            map3 = (Map) o0o0ooo0162.get(str9);
                                            if (map3 == null) {
                                            }
                                            it3 = map3.keySet().iterator();
                                            while (it3.hasNext()) {
                                            }
                                            zzeb = this;
                                            str19 = str10;
                                            o0o0ooo04 = o0o0ooo0162;
                                            hashSet = hashSet3;
                                            zzkn4 = zzkn;
                                            i10 = i3 + 1;
                                            zzknArr2 = zzknArr;
                                            zzeb3 = zzeb;
                                            hashSet6 = hashSet;
                                            length3 = i4;
                                            o0o0ooo014 = o0o0ooo04;
                                            str21 = str8;
                                            str20 = str7;
                                            o0o0ooo013 = o0o0ooo03;
                                            o0o0ooo012 = o0o0ooo02;
                                            o0o0ooo010 = o0o0ooo0;
                                        }
                                        o0o0ooo05 = o0o0ooo014;
                                        str8 = str21;
                                        zzkn3 = zzkn6;
                                    } else {
                                        i4 = length3;
                                        hashSet2 = hashSet6;
                                        o0o0ooo05 = o0o0ooo014;
                                        Long l3 = zzb;
                                        str8 = str21;
                                        zzkn zzkn7 = zzkn6;
                                        zzkn3 = zzkn7;
                                        zzix().zza(str, l3, j2, zzkn7);
                                    }
                                    zzko[] zzkoArr422 = new zzko[(zzkn3.zzata.length + zzkoArr3.length)];
                                    i8 = 0;
                                    for (zzko zzko : zzkn3.zzata) {
                                        zzgb();
                                        if (zzka.zza(zzkn5, zzko.name) == null) {
                                            zzkoArr422[i8] = zzko;
                                            i8++;
                                        }
                                    }
                                    if (i8 > 0) {
                                        int length4 = zzkoArr3.length;
                                        int i11 = 0;
                                        while (i11 < length4) {
                                            zzkoArr422[i8] = zzkoArr3[i11];
                                            i11++;
                                            i8++;
                                        }
                                        if (i8 != zzkoArr422.length) {
                                            zzkoArr422 = (zzko[]) Arrays.copyOf(zzkoArr422, i8);
                                        }
                                        zzkoArr3 = zzkoArr422;
                                    } else {
                                        zzge().zzip().zzg("No unique parameters in main event. eventName", zzb2);
                                    }
                                    str9 = zzb2;
                                    zzkn = zzkn3;
                                }
                                zzeb = zzeb3;
                                o0o0ooo0 = o0o0ooo010;
                                o0o0ooo03 = o0o0ooo013;
                                str7 = str22;
                                o0o0ooo02 = o0o0ooo015;
                                zzkn4 = zzkn2;
                                hashSet = hashSet5;
                                i10 = i3 + 1;
                                zzknArr2 = zzknArr;
                                zzeb3 = zzeb;
                                hashSet6 = hashSet;
                                length3 = i4;
                                o0o0ooo014 = o0o0ooo04;
                                str21 = str8;
                                str20 = str7;
                                o0o0ooo013 = o0o0ooo03;
                                o0o0ooo012 = o0o0ooo02;
                                o0o0ooo010 = o0o0ooo0;
                            } else {
                                zzkn = zzkn4;
                                i4 = length3;
                                o0o0ooo05 = o0o0ooo014;
                                str8 = str21;
                                hashSet2 = hashSet6;
                                if (z2) {
                                    zzgb();
                                    long j4 = 0L;
                                    Object zzb3 = zzka.zzb(zzkn5, "_epc");
                                    if (zzb3 != null) {
                                        j4 = zzb3;
                                    }
                                    j2 = ((Long) j4).longValue();
                                    if (j2 <= 0) {
                                        zzge().zzip().zzg("Complex event with zero extra param count. eventName", str23);
                                        l = zzb;
                                    } else {
                                        l = zzb;
                                        zzix().zza(str, zzb, j2, zzkn5);
                                    }
                                    l2 = l;
                                    str9 = str23;
                                    zzkn = zzkn5;
                                }
                            }
                            zzko[] zzkoArr522 = zzkoArr3;
                            zzf = zzix().zzf(str19, zzkn5.name);
                            if (zzf == null) {
                                zzge().zzip().zze("Event aggregate wasn't created during raw event logging. appId, event", zzfg.zzbm(str), zzga().zzbj(str9));
                                str7 = str22;
                                o0o0ooo03 = o0o0ooo013;
                                o0o0ooo02 = o0o0ooo015;
                                zzkoArr = zzkoArr522;
                                o0o0ooo0 = o0o0ooo010;
                                hashSet3 = hashSet2;
                                str10 = str19;
                                zzeq = new zzeq(str, zzkn5.name, 1, 1, zzkn5.zzatb.longValue(), 0, null, null, null);
                            } else {
                                zzkoArr = zzkoArr522;
                                o0o0ooo0 = o0o0ooo010;
                                str10 = str19;
                                o0o0ooo03 = o0o0ooo013;
                                str7 = str22;
                                o0o0ooo02 = o0o0ooo015;
                                hashSet3 = hashSet2;
                                zzeq = zzf.zzie();
                            }
                            zzix().zza(zzeq);
                            long j322 = zzeq.zzafr;
                            o0O0OOO0 o0o0ooo01622 = o0o0ooo05;
                            map3 = (Map) o0o0ooo01622.get(str9);
                            if (map3 == null) {
                                map3 = zzix().zzk(str10, str9);
                                if (map3 == null) {
                                    map3 = new o0O0OOO0();
                                }
                                o0o0ooo01622.put(str9, map3);
                            }
                            it3 = map3.keySet().iterator();
                            while (it3.hasNext()) {
                                int intValue2 = ((Integer) it3.next()).intValue();
                                HashSet hashSet7 = hashSet3;
                                if (hashSet7.contains(Integer.valueOf(intValue2))) {
                                    zzge().zzit().zzg(str8, Integer.valueOf(intValue2));
                                    hashSet4 = hashSet7;
                                } else {
                                    String str24 = str8;
                                    o0O0OOO0 o0o0ooo017 = o0o0ooo0;
                                    zzkm zzkm2 = (zzkm) o0o0ooo017.get(Integer.valueOf(intValue2));
                                    o0O0OOO0 o0o0ooo018 = o0o0ooo03;
                                    BitSet bitSet3 = (BitSet) o0o0ooo018.get(Integer.valueOf(intValue2));
                                    o0O0OOO0 o0o0ooo019 = o0o0ooo02;
                                    BitSet bitSet4 = (BitSet) o0o0ooo019.get(Integer.valueOf(intValue2));
                                    if (zzkm2 == null) {
                                        zzkm zzkm3 = new zzkm();
                                        o0o0ooo017.put(Integer.valueOf(intValue2), zzkm3);
                                        zzkm3.zzasy = Boolean.TRUE;
                                        bitSet3 = new BitSet();
                                        o0o0ooo018.put(Integer.valueOf(intValue2), bitSet3);
                                        bitSet4 = new BitSet();
                                        o0o0ooo019.put(Integer.valueOf(intValue2), bitSet4);
                                    }
                                    Iterator it8 = ((List) map3.get(Integer.valueOf(intValue2))).iterator();
                                    while (it8.hasNext()) {
                                        zzke zzke = (zzke) it8.next();
                                        o0O0OOO0 o0o0ooo020 = o0o0ooo01622;
                                        Map map7 = map3;
                                        if (zzge().isLoggable(2)) {
                                            it5 = it3;
                                            it4 = it8;
                                            o0o0ooo06 = o0o0ooo019;
                                            zzge().zzit().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue2), zzke.zzarp, zzga().zzbj(zzke.zzarq));
                                            str11 = str7;
                                            zzge().zzit().zzg(str11, zzga().zza(zzke));
                                        } else {
                                            it5 = it3;
                                            it4 = it8;
                                            o0o0ooo06 = o0o0ooo019;
                                            str11 = str7;
                                        }
                                        if (zzke.zzarp == null || zzke.zzarp.intValue() > 256) {
                                            str14 = str;
                                            j = j322;
                                            str12 = str11;
                                            str13 = str24;
                                            o0o0ooo07 = o0o0ooo017;
                                            o0o0ooo08 = o0o0ooo018;
                                            zzge().zzip().zze("Invalid event filter ID. appId, id", zzfg.zzbm(str), String.valueOf(zzke.zzarp));
                                        } else if (bitSet3.get(zzke.zzarp.intValue())) {
                                            zzge().zzit().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue2), zzke.zzarp);
                                            str15 = str;
                                            str12 = str11;
                                            map4 = map7;
                                            it3 = it5;
                                            it8 = it4;
                                            o0o0ooo01622 = o0o0ooo020;
                                            o0o0ooo019 = o0o0ooo06;
                                        } else {
                                            if (zzke.zzart != null) {
                                                zzeb2 = this;
                                                str14 = str;
                                                Boolean zza3 = zzeb2.zza(j322, zzke.zzart);
                                                if (zza3 == null) {
                                                    j = j322;
                                                } else {
                                                    if (!zza3.booleanValue()) {
                                                        j = j322;
                                                        bool2 = Boolean.FALSE;
                                                        str12 = str11;
                                                        str13 = str24;
                                                        o0o0ooo07 = o0o0ooo017;
                                                        o0o0ooo08 = o0o0ooo018;
                                                        zzge().zzit().zzg("Event filter result", bool2 != null ? "null" : bool2);
                                                        if (bool2 != null) {
                                                            hashSet7.add(Integer.valueOf(intValue2));
                                                        } else {
                                                            bitSet4.set(zzke.zzarp.intValue());
                                                            if (bool2.booleanValue()) {
                                                                bitSet3.set(zzke.zzarp.intValue());
                                                            }
                                                        }
                                                    }
                                                    HashSet hashSet8 = new HashSet();
                                                    zzkf[] zzkfArr = zzke.zzarr;
                                                    j = j322;
                                                    length = zzkfArr.length;
                                                    i5 = 0;
                                                    while (i5 < length) {
                                                        int i12 = length;
                                                        zzkf zzkf = zzkfArr[i5];
                                                        zzkf[] zzkfArr2 = zzkfArr;
                                                        if (TextUtils.isEmpty(zzkf.zzary)) {
                                                            zzge().zzip().zzg("null or empty param name in filter. event", zzga().zzbj(str9));
                                                        } else {
                                                            hashSet8.add(zzkf.zzary);
                                                            i5++;
                                                            length = i12;
                                                            zzkfArr = zzkfArr2;
                                                        }
                                                    }
                                                    o0O0OOO0 o0o0ooo021 = new o0O0OOO0();
                                                    zzkoArr2 = zzkoArr;
                                                    length2 = zzkoArr2.length;
                                                    str12 = str11;
                                                    i6 = 0;
                                                    while (true) {
                                                        if (i6 >= length2) {
                                                            int i13 = length2;
                                                            zzko zzko2 = zzkoArr2[i6];
                                                            zzkoArr = zzkoArr2;
                                                            if (hashSet8.contains(zzko2.name)) {
                                                                if (zzko2.zzate == null) {
                                                                    if (zzko2.zzarc == null) {
                                                                        if (zzko2.zzajf == null) {
                                                                            zzge().zzip().zze("Unknown value for param. event, param", zzga().zzbj(str9), zzga().zzbk(zzko2.name));
                                                                            break;
                                                                        }
                                                                        str17 = zzko2.name;
                                                                        obj2 = zzko2.zzajf;
                                                                    } else {
                                                                        str17 = zzko2.name;
                                                                        obj2 = zzko2.zzarc;
                                                                    }
                                                                } else {
                                                                    str17 = zzko2.name;
                                                                    obj2 = zzko2.zzate;
                                                                }
                                                                o0o0ooo021.put(str17, obj2);
                                                            }
                                                            i6++;
                                                            length2 = i13;
                                                            zzkoArr2 = zzkoArr;
                                                        } else {
                                                            zzkoArr = zzkoArr2;
                                                            zzkf[] zzkfArr3 = zzke.zzarr;
                                                            int length5 = zzkfArr3.length;
                                                            int i14 = 0;
                                                            while (true) {
                                                                if (i14 >= length5) {
                                                                    str13 = str24;
                                                                    o0o0ooo07 = o0o0ooo017;
                                                                    o0o0ooo08 = o0o0ooo018;
                                                                    bool2 = Boolean.TRUE;
                                                                    break;
                                                                }
                                                                zzkf zzkf2 = zzkfArr3[i14];
                                                                zzkf[] zzkfArr4 = zzkfArr3;
                                                                int i15 = length5;
                                                                boolean equals = Boolean.TRUE.equals(zzkf2.zzarx);
                                                                String str25 = zzkf2.zzary;
                                                                if (TextUtils.isEmpty(str25)) {
                                                                    zzge().zzip().zzg("Event has empty param name. event", zzga().zzbj(str9));
                                                                    break;
                                                                }
                                                                o0o0ooo08 = o0o0ooo018;
                                                                Object obj3 = o0o0ooo021.get(str25);
                                                                o0O0OOO0 o0o0ooo022 = o0o0ooo021;
                                                                if (!(obj3 instanceof Long)) {
                                                                    str13 = str24;
                                                                    o0o0ooo07 = o0o0ooo017;
                                                                    if (obj3 instanceof Double) {
                                                                        if (zzkf2.zzarw == null) {
                                                                            zzip2 = zzge().zzip();
                                                                            zzbj = zzga().zzbj(str9);
                                                                            zzbk = zzga().zzbk(str25);
                                                                            str16 = "No number filter for double param. event, param";
                                                                            break;
                                                                        }
                                                                        Boolean zza4 = zzeb2.zza(((Double) obj3).doubleValue(), zzkf2.zzarw);
                                                                        if (zza4 == null) {
                                                                            break;
                                                                        } else if ((!zza4.booleanValue()) ^ equals) {
                                                                            break;
                                                                        }
                                                                    } else if (obj3 instanceof String) {
                                                                        if (zzkf2.zzarv == null) {
                                                                            if (zzkf2.zzarw == null) {
                                                                                zzip2 = zzge().zzip();
                                                                                zzbj = zzga().zzbj(str9);
                                                                                zzbk = zzga().zzbk(str25);
                                                                                str16 = "No filter for String param. event, param";
                                                                                break;
                                                                            }
                                                                            String str26 = (String) obj3;
                                                                            if (!zzka.zzck(str26)) {
                                                                                zzip2 = zzge().zzip();
                                                                                zzbj = zzga().zzbj(str9);
                                                                                zzbk = zzga().zzbk(str25);
                                                                                str16 = "Invalid param value for number filter. event, param";
                                                                                break;
                                                                            }
                                                                            bool3 = zzeb2.zza(str26, zzkf2.zzarw);
                                                                        } else {
                                                                            bool3 = zzeb2.zza((String) obj3, zzkf2.zzarv);
                                                                        }
                                                                        if (bool3 == null) {
                                                                            break;
                                                                        } else if ((!bool3.booleanValue()) ^ equals) {
                                                                            break;
                                                                        }
                                                                    } else if (obj3 == null) {
                                                                        zzge().zzit().zze("Missing param for filter. event, param", zzga().zzbj(str9), zzga().zzbk(str25));
                                                                    } else {
                                                                        zzip2 = zzge().zzip();
                                                                        zzbj = zzga().zzbj(str9);
                                                                        zzbk = zzga().zzbk(str25);
                                                                        str16 = "Unknown param type. event, param";
                                                                    }
                                                                } else if (zzkf2.zzarw == null) {
                                                                    zzge().zzip().zze("No number filter for long param. event, param", zzga().zzbj(str9), zzga().zzbk(str25));
                                                                    str13 = str24;
                                                                    o0o0ooo07 = o0o0ooo017;
                                                                    break;
                                                                } else {
                                                                    str13 = str24;
                                                                    o0o0ooo07 = o0o0ooo017;
                                                                    Boolean zza5 = zzeb2.zza(((Long) obj3).longValue(), zzkf2.zzarw);
                                                                    if (zza5 == null) {
                                                                        break;
                                                                    } else if ((!zza5.booleanValue()) ^ equals) {
                                                                        break;
                                                                    }
                                                                }
                                                                i14++;
                                                                zzkfArr3 = zzkfArr4;
                                                                length5 = i15;
                                                                o0o0ooo021 = o0o0ooo022;
                                                                str24 = str13;
                                                                o0o0ooo018 = o0o0ooo08;
                                                                o0o0ooo017 = o0o0ooo07;
                                                            }
                                                            zzip2.zze(str16, zzbj, zzbk);
                                                        }
                                                    }
                                                    zzge().zzit().zzg("Event filter result", bool2 != null ? "null" : bool2);
                                                    if (bool2 != null) {
                                                    }
                                                }
                                            } else {
                                                zzeb2 = this;
                                                str14 = str;
                                                HashSet hashSet82 = new HashSet();
                                                zzkf[] zzkfArr5 = zzke.zzarr;
                                                j = j322;
                                                length = zzkfArr5.length;
                                                i5 = 0;
                                                while (i5 < length) {
                                                }
                                                o0O0OOO0 o0o0ooo0212 = new o0O0OOO0();
                                                zzkoArr2 = zzkoArr;
                                                length2 = zzkoArr2.length;
                                                str12 = str11;
                                                i6 = 0;
                                                while (true) {
                                                    if (i6 >= length2) {
                                                    }
                                                    i6++;
                                                    length2 = i13;
                                                    zzkoArr2 = zzkoArr;
                                                }
                                                zzge().zzit().zzg("Event filter result", bool2 != null ? "null" : bool2);
                                                if (bool2 != null) {
                                                }
                                            }
                                            str12 = str11;
                                            str13 = str24;
                                            o0o0ooo07 = o0o0ooo017;
                                            o0o0ooo08 = o0o0ooo018;
                                            bool2 = null;
                                            zzge().zzit().zzg("Event filter result", bool2 != null ? "null" : bool2);
                                            if (bool2 != null) {
                                            }
                                        }
                                        str15 = str14;
                                        map4 = map7;
                                        it3 = it5;
                                        it8 = it4;
                                        j322 = j;
                                        o0o0ooo01622 = o0o0ooo020;
                                        str24 = str13;
                                        o0o0ooo018 = o0o0ooo08;
                                        o0o0ooo019 = o0o0ooo06;
                                        o0o0ooo017 = o0o0ooo07;
                                    }
                                    hashSet4 = hashSet7;
                                    str8 = str24;
                                    o0o0ooo0 = o0o0ooo017;
                                    o0o0ooo03 = o0o0ooo018;
                                    o0o0ooo02 = o0o0ooo019;
                                }
                            }
                            zzeb = this;
                            str19 = str10;
                            o0o0ooo04 = o0o0ooo01622;
                            hashSet = hashSet3;
                            zzkn4 = zzkn;
                            i10 = i3 + 1;
                            zzknArr2 = zzknArr;
                            zzeb3 = zzeb;
                            hashSet6 = hashSet;
                            length3 = i4;
                            o0o0ooo014 = o0o0ooo04;
                            str21 = str8;
                            str20 = str7;
                            o0o0ooo013 = o0o0ooo03;
                            o0o0ooo012 = o0o0ooo02;
                            o0o0ooo010 = o0o0ooo0;
                        }
                    } else {
                        i3 = i10;
                    }
                    z = false;
                    if (!z) {
                    }
                    zzko[] zzkoArr5222 = zzkoArr3;
                    zzf = zzix().zzf(str19, zzkn5.name);
                    if (zzf == null) {
                    }
                    zzix().zza(zzeq);
                    long j3222 = zzeq.zzafr;
                    o0O0OOO0 o0o0ooo016222 = o0o0ooo05;
                    map3 = (Map) o0o0ooo016222.get(str9);
                    if (map3 == null) {
                    }
                    it3 = map3.keySet().iterator();
                    while (it3.hasNext()) {
                    }
                    zzeb = this;
                    str19 = str10;
                    o0o0ooo04 = o0o0ooo016222;
                    hashSet = hashSet3;
                    zzkn4 = zzkn;
                    i10 = i3 + 1;
                    zzknArr2 = zzknArr;
                    zzeb3 = zzeb;
                    hashSet6 = hashSet;
                    length3 = i4;
                    o0o0ooo014 = o0o0ooo04;
                    str21 = str8;
                    str20 = str7;
                    o0o0ooo013 = o0o0ooo03;
                    o0o0ooo012 = o0o0ooo02;
                    o0o0ooo010 = o0o0ooo0;
                } else {
                    zzkn = zzkn4;
                    i3 = i10;
                    i4 = length3;
                    o0o0ooo05 = o0o0ooo014;
                    str8 = str21;
                    hashSet2 = hashSet6;
                }
                str9 = str23;
                zzko[] zzkoArr52222 = zzkoArr3;
                zzf = zzix().zzf(str19, zzkn5.name);
                if (zzf == null) {
                }
                zzix().zza(zzeq);
                long j32222 = zzeq.zzafr;
                o0O0OOO0 o0o0ooo0162222 = o0o0ooo05;
                map3 = (Map) o0o0ooo0162222.get(str9);
                if (map3 == null) {
                }
                it3 = map3.keySet().iterator();
                while (it3.hasNext()) {
                }
                zzeb = this;
                str19 = str10;
                o0o0ooo04 = o0o0ooo0162222;
                hashSet = hashSet3;
                zzkn4 = zzkn;
                i10 = i3 + 1;
                zzknArr2 = zzknArr;
                zzeb3 = zzeb;
                hashSet6 = hashSet;
                length3 = i4;
                o0o0ooo014 = o0o0ooo04;
                str21 = str8;
                str20 = str7;
                o0o0ooo013 = o0o0ooo03;
                o0o0ooo012 = o0o0ooo02;
                o0o0ooo010 = o0o0ooo0;
            }
        }
        String str27 = str21;
        String str28 = str20;
        o0O0OOO0 o0o0ooo023 = o0o0ooo012;
        HashSet hashSet9 = hashSet6;
        o0O0OOO0 o0o0ooo024 = o0o0ooo010;
        o0O0OOO0 o0o0ooo025 = o0o0ooo013;
        zzeb zzeb4 = zzeb3;
        zzks[] zzksArr2 = zzksArr;
        if (zzksArr2 != null) {
            o0O0OOO0 o0o0ooo026 = new o0O0OOO0();
            int length6 = zzksArr2.length;
            int i16 = 0;
            while (i16 < length6) {
                zzks zzks = zzksArr2[i16];
                Map map8 = (Map) o0o0ooo026.get(zzks.name);
                if (map8 == null) {
                    map8 = zzix().zzl(str19, zzks.name);
                    if (map8 == null) {
                        map8 = new o0O0OOO0();
                    }
                    o0o0ooo026.put(zzks.name, map8);
                }
                Iterator it9 = map8.keySet().iterator();
                while (it9.hasNext()) {
                    int intValue3 = ((Integer) it9.next()).intValue();
                    if (hashSet9.contains(Integer.valueOf(intValue3))) {
                        zzge().zzit().zzg(str27, Integer.valueOf(intValue3));
                    } else {
                        String str29 = str27;
                        o0O0OOO0 o0o0ooo027 = o0o0ooo024;
                        zzkm zzkm4 = (zzkm) o0o0ooo027.get(Integer.valueOf(intValue3));
                        o0O0OOO0 o0o0ooo028 = o0o0ooo025;
                        BitSet bitSet5 = (BitSet) o0o0ooo028.get(Integer.valueOf(intValue3));
                        o0O0OOO0 o0o0ooo029 = o0o0ooo026;
                        o0O0OOO0 o0o0ooo030 = o0o0ooo023;
                        BitSet bitSet6 = (BitSet) o0o0ooo030.get(Integer.valueOf(intValue3));
                        if (zzkm4 == null) {
                            zzkm zzkm5 = new zzkm();
                            o0o0ooo027.put(Integer.valueOf(intValue3), zzkm5);
                            zzkm5.zzasy = Boolean.TRUE;
                            bitSet5 = new BitSet();
                            o0o0ooo028.put(Integer.valueOf(intValue3), bitSet5);
                            bitSet6 = new BitSet();
                            o0o0ooo030.put(Integer.valueOf(intValue3), bitSet6);
                        }
                        Iterator it10 = ((List) map8.get(Integer.valueOf(intValue3))).iterator();
                        while (true) {
                            if (!it10.hasNext()) {
                                o0o0ooo026 = o0o0ooo029;
                                o0o0ooo023 = o0o0ooo030;
                                str27 = str29;
                                o0o0ooo024 = o0o0ooo027;
                                o0o0ooo025 = o0o0ooo028;
                                break;
                            }
                            i = length6;
                            zzkh = (zzkh) it10.next();
                            map = map8;
                            it = it9;
                            if (zzge().isLoggable(2)) {
                                it2 = it10;
                                str27 = str29;
                                zzge().zzit().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue3), zzkh.zzarp, zzga().zzbl(zzkh.zzasf));
                                str3 = str28;
                                zzge().zzit().zzg(str3, zzga().zza(zzkh));
                            } else {
                                it2 = it10;
                                str27 = str29;
                                str3 = str28;
                            }
                            if (zzkh.zzarp == null || zzkh.zzarp.intValue() > 256) {
                                zzge().zzip().zze("Invalid property filter ID. appId, id", zzfg.zzbm(str), String.valueOf(zzkh.zzarp));
                                hashSet9.add(Integer.valueOf(intValue3));
                                o0o0ooo026 = o0o0ooo029;
                                o0o0ooo023 = o0o0ooo030;
                                str28 = str3;
                                o0o0ooo024 = o0o0ooo027;
                                o0o0ooo025 = o0o0ooo028;
                                map8 = map;
                                length6 = i;
                                it9 = it;
                            } else {
                                if (bitSet5.get(zzkh.zzarp.intValue())) {
                                    zzge().zzit().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue3), zzkh.zzarp);
                                    str28 = str3;
                                    map2 = map;
                                    length6 = i;
                                    it9 = it;
                                    it10 = it2;
                                } else {
                                    zzkf zzkf3 = zzkh.zzasg;
                                    if (zzkf3 == null) {
                                        zzip = zzge().zzip();
                                        zzbl = zzga().zzbl(zzks.name);
                                        str6 = "Missing property filter. property";
                                    } else {
                                        boolean equals2 = Boolean.TRUE.equals(zzkf3.zzarx);
                                        if (zzks.zzate == null) {
                                            i2 = intValue3;
                                            if (zzks.zzarc != null) {
                                                if (zzkf3.zzarw == null) {
                                                    zzfi2 = zzge().zzip();
                                                    str5 = zzga().zzbl(zzks.name);
                                                    str4 = "No number filter for double property. property";
                                                } else {
                                                    zza = zzeb4.zza(zzks.zzarc.doubleValue(), zzkf3.zzarw);
                                                }
                                            } else if (zzks.zzajf == null) {
                                                zzfi2 = zzge().zzip();
                                                str5 = zzga().zzbl(zzks.name);
                                                str4 = "User property has no value, property";
                                            } else if (zzkf3.zzarv != null) {
                                                zza = zzeb4.zza(zzks.zzajf, zzkf3.zzarv);
                                            } else if (zzkf3.zzarw == null) {
                                                zzfi2 = zzge().zzip();
                                                str5 = zzga().zzbl(zzks.name);
                                                str4 = "No string or number filter defined. property";
                                            } else if (zzka.zzck(zzks.zzajf)) {
                                                zza = zzeb4.zza(zzks.zzajf, zzkf3.zzarw);
                                            } else {
                                                zzge().zzip().zze("Invalid user property value for Numeric number filter. property, value", zzga().zzbl(zzks.name), zzks.zzajf);
                                                bool = null;
                                                zzge().zzit().zzg("Property filter result", bool != null ? "null" : bool);
                                                if (bool != null) {
                                                    hashSet9.add(Integer.valueOf(i2));
                                                } else {
                                                    bitSet6.set(zzkh.zzarp.intValue());
                                                    if (bool.booleanValue()) {
                                                        bitSet5.set(zzkh.zzarp.intValue());
                                                    }
                                                }
                                                str28 = str3;
                                                map2 = map;
                                                length6 = i;
                                                it9 = it;
                                                it10 = it2;
                                                intValue3 = i2;
                                            }
                                            zzfi2.zzg(str4, str5);
                                            bool = null;
                                            zzge().zzit().zzg("Property filter result", bool != null ? "null" : bool);
                                            if (bool != null) {
                                            }
                                            str28 = str3;
                                            map2 = map;
                                            length6 = i;
                                            it9 = it;
                                            it10 = it2;
                                            intValue3 = i2;
                                        } else if (zzkf3.zzarw == null) {
                                            zzip = zzge().zzip();
                                            zzbl = zzga().zzbl(zzks.name);
                                            str6 = "No number filter for long property. property";
                                        } else {
                                            i2 = intValue3;
                                            zza = zzeb4.zza(zzks.zzate.longValue(), zzkf3.zzarw);
                                        }
                                        bool = zza(zza, equals2);
                                        zzge().zzit().zzg("Property filter result", bool != null ? "null" : bool);
                                        if (bool != null) {
                                        }
                                        str28 = str3;
                                        map2 = map;
                                        length6 = i;
                                        it9 = it;
                                        it10 = it2;
                                        intValue3 = i2;
                                    }
                                    zzip.zzg(str6, zzbl);
                                    i2 = intValue3;
                                    bool = null;
                                    zzge().zzit().zzg("Property filter result", bool != null ? "null" : bool);
                                    if (bool != null) {
                                    }
                                    str28 = str3;
                                    map2 = map;
                                    length6 = i;
                                    it9 = it;
                                    it10 = it2;
                                    intValue3 = i2;
                                }
                                str29 = str27;
                            }
                        }
                        zzge().zzip().zze("Invalid property filter ID. appId, id", zzfg.zzbm(str), String.valueOf(zzkh.zzarp));
                        hashSet9.add(Integer.valueOf(intValue3));
                        o0o0ooo026 = o0o0ooo029;
                        o0o0ooo023 = o0o0ooo030;
                        str28 = str3;
                        o0o0ooo024 = o0o0ooo027;
                        o0o0ooo025 = o0o0ooo028;
                        map8 = map;
                        length6 = i;
                        it9 = it;
                    }
                }
                i16++;
                str19 = str;
                zzksArr2 = zzksArr;
            }
        }
        o0O0OOO0 o0o0ooo031 = o0o0ooo025;
        o0O0OOO0 o0o0ooo032 = o0o0ooo023;
        o0O0OOO0 o0o0ooo033 = o0o0ooo024;
        zzkm[] zzkmArr = new zzkm[o0o0ooo031.size()];
        int i17 = 0;
        for (Integer intValue4 : o0o0ooo031.keySet()) {
            int intValue5 = intValue4.intValue();
            if (!hashSet9.contains(Integer.valueOf(intValue5))) {
                zzkm zzkm6 = (zzkm) o0o0ooo033.get(Integer.valueOf(intValue5));
                if (zzkm6 == null) {
                    zzkm6 = new zzkm();
                }
                int i18 = i17 + 1;
                zzkmArr[i17] = zzkm6;
                zzkm6.zzarl = Integer.valueOf(intValue5);
                zzkm6.zzasw = new zzkr();
                zzkm6.zzasw.zzaul = zzka.zza((BitSet) o0o0ooo031.get(Integer.valueOf(intValue5)));
                zzkm6.zzasw.zzauk = zzka.zza((BitSet) o0o0ooo032.get(Integer.valueOf(intValue5)));
                zzei zzix2 = zzix();
                zzkr zzkr2 = zzkm6.zzasw;
                zzix2.zzch();
                zzix2.zzab();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzkr2);
                try {
                    byte[] bArr = new byte[zzkr2.zzvm()];
                    try {
                        zzabw zzb4 = zzabw.zzb(bArr, 0, bArr.length);
                        zzkr2.zza(zzb4);
                        zzb4.zzve();
                        contentValues = new ContentValues();
                        contentValues.put("app_id", str);
                        contentValues.put("audience_id", Integer.valueOf(intValue5));
                        contentValues.put("current_results", bArr);
                        try {
                        } catch (SQLiteException e4) {
                            e = e4;
                            zzfi = zzix2.zzge().zzim();
                            obj = zzfg.zzbm(str);
                            str2 = "Error storing filter results. appId";
                            zzfi.zze(str2, obj, e);
                            i17 = i18;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        zzfi = zzix2.zzge().zzim();
                        obj = zzfg.zzbm(str);
                        str2 = "Configuration loss. Failed to serialize filter results. appId";
                        zzfi.zze(str2, obj, e);
                        i17 = i18;
                    }
                    try {
                        if (zzix2.getWritableDatabase().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                            zzix2.zzge().zzim().zzg("Failed to insert filter results (got -1). appId", zzfg.zzbm(str));
                        }
                    } catch (SQLiteException e6) {
                        e = e6;
                        zzfi = zzix2.zzge().zzim();
                        obj = zzfg.zzbm(str);
                        str2 = "Error storing filter results. appId";
                        zzfi.zze(str2, obj, e);
                        i17 = i18;
                    }
                } catch (IOException e7) {
                    e = e7;
                    zzfi = zzix2.zzge().zzim();
                    obj = zzfg.zzbm(str);
                    str2 = "Configuration loss. Failed to serialize filter results. appId";
                    zzfi.zze(str2, obj, e);
                    i17 = i18;
                }
                i17 = i18;
            }
        }
        return (zzkm[]) Arrays.copyOf(zzkmArr, i17);
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }
}
