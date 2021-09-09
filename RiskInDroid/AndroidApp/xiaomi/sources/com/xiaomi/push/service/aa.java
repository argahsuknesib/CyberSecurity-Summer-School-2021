package com.xiaomi.push.service;

import _m_j.duv;
import android.content.Context;
import com.xiaomi.push.il;
import java.util.Map;

public class aa {

    /* renamed from: a  reason: collision with root package name */
    private static a f6485a;

    /* renamed from: a  reason: collision with other field name */
    private static b f230a;

    public interface a {
        Map<String, String> a(Context context, il ilVar);

        boolean a(Context context, il ilVar, boolean z);
    }

    public interface b {
        void a(il ilVar);

        void a(String str);

        /* renamed from: a  reason: collision with other method in class */
        boolean m144a(il ilVar);
    }

    public static Map<String, String> a(Context context, il ilVar) {
        a aVar = f6485a;
        if (aVar != null && ilVar != null) {
            return aVar.a(context, ilVar);
        }
        duv.O000000o("pepa listener or container is null");
        return null;
    }

    public static void a(il ilVar) {
        b bVar = f230a;
        if (bVar == null || ilVar == null) {
            duv.O000000o("pepa clearMessage is null");
        } else {
            bVar.a(ilVar);
        }
    }

    public static void a(String str) {
        b bVar = f230a;
        if (bVar == null || str == null) {
            duv.O000000o("pepa clearMessage is null");
        } else {
            bVar.a(str);
        }
    }

    public static boolean a(Context context, il ilVar, boolean z) {
        a aVar = f6485a;
        if (aVar != null && ilVar != null) {
            return aVar.a(context, ilVar, z);
        }
        duv.O000000o("pepa judement listener or container is null");
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m143a(il ilVar) {
        b bVar = f230a;
        if (bVar != null && ilVar != null) {
            return bVar.m144a(ilVar);
        }
        duv.O000000o("pepa handleReceiveMessage is null");
        return false;
    }
}
