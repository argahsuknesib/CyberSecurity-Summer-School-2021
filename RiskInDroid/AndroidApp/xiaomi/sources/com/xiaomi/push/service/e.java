package com.xiaomi.push.service;

import _m_j.duv;
import _m_j.esl;
import _m_j.esu;
import com.xiaomi.push.io;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static a f6558a;

    /* renamed from: a  reason: collision with other field name */
    private static b f318a;

    public interface a {
        boolean a(io ioVar);
    }

    public interface b {
    }

    public static void a(b bVar) {
        f318a = bVar;
    }

    public static boolean a(io ioVar) {
        String str;
        if (f6558a == null || ioVar == null) {
            str = "rc params is null, not cpra";
        } else if (esl.O000000o(esu.O000000o())) {
            return f6558a.a(ioVar);
        } else {
            str = "rc app not permission to cpra";
        }
        duv.O000000o(str);
        return false;
    }
}
