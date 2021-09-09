package com.xiaomi.push.service;

import _m_j.elj;
import android.util.Pair;
import com.xiaomi.push.hv;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ia;
import com.xiaomi.push.im;
import com.xiaomi.push.in;
import java.util.ArrayList;
import java.util.List;

public class au {
    public static int a(at atVar, hv hvVar) {
        int i = 0;
        if (av.f6508a[hvVar.ordinal()] == 1) {
            i = 1;
        }
        return atVar.a(hvVar, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.au.a(java.util.List<com.xiaomi.push.ia>, boolean):java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>
     arg types: [java.util.List<com.xiaomi.push.ia>, int]
     candidates:
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.hv):int
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.im):void
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.in):void
      com.xiaomi.push.service.au.a(java.util.List<com.xiaomi.push.ia>, boolean):java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> */
    public static void a(at atVar, in inVar) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (hy next : inVar.f6430a) {
            arrayList.add(new Pair(next.f66a, Integer.valueOf(next.f6402a)));
            List<Pair<Integer, Object>> a2 = a(next.f68a, false);
            if (!elj.O000000o(a2)) {
                arrayList2.addAll(a2);
            }
        }
        atVar.a(arrayList, arrayList2);
        atVar.b();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.push.service.au.a(java.util.List<com.xiaomi.push.ia>, boolean):java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>>
     arg types: [java.util.List<com.xiaomi.push.ia>, int]
     candidates:
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.hv):int
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.im):void
      com.xiaomi.push.service.au.a(com.xiaomi.push.service.at, com.xiaomi.push.in):void
      com.xiaomi.push.service.au.a(java.util.List<com.xiaomi.push.ia>, boolean):java.util.List<android.util.Pair<java.lang.Integer, java.lang.Object>> */
    public static void a(at atVar, im imVar) {
        atVar.a(a(imVar.f6428a, true));
        atVar.b();
    }

    private static List<Pair<Integer, Object>> a(List<ia> list, boolean z) {
        Pair pair;
        if (elj.O000000o(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ia next : list) {
            int i = next.f6405a;
            hw a2 = hw.a(next.b);
            if (a2 != null) {
                if (!z || !next.f74a) {
                    int i2 = av.b[a2.ordinal()];
                    if (i2 == 1) {
                        pair = new Pair(Integer.valueOf(i), Integer.valueOf(next.c));
                    } else if (i2 == 2) {
                        pair = new Pair(Integer.valueOf(i), Long.valueOf(next.f71a));
                    } else if (i2 == 3) {
                        pair = new Pair(Integer.valueOf(i), next.f72a);
                    } else if (i2 != 4) {
                        pair = null;
                    } else {
                        pair = new Pair(Integer.valueOf(i), Boolean.valueOf(next.f75b));
                    }
                    arrayList.add(pair);
                } else {
                    arrayList.add(new Pair(Integer.valueOf(i), null));
                }
            }
        }
        return arrayList;
    }
}
