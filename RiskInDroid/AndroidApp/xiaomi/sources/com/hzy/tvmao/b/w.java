package com.hzy.tvmao.b;

import com.hzy.tvmao.b.a;

public class w extends a {
    public static w b;

    public static w c() {
        if (b == null) {
            b = new w();
        }
        return b;
    }

    public void a(int i, int i2, String str, String str2, a.c cVar) {
        new x(this, cVar, "task_getprogramguide", i, i2, str, str2).a();
    }

    public void a(String str, short s, int i, String str2, boolean z, a.c cVar) {
        new y(this, cVar, "task_searchchannel", s, str, i, str2, z).a();
    }

    public void a(String str, short s, a.c cVar) {
        new z(this, cVar, "accurateSearchProgram", s, str).a();
    }

    public void a(int i, String str, String str2, a.c cVar) {
        new aa(this, cVar, "task_searchchannel", i, str, str2).a();
    }

    public void a(int i, String str, int i2, a.c cVar) {
        new ab(this, cVar, "task_searchweek_program", i, str, i2).a();
    }

    public void b(String str, short s, a.c cVar) {
        new ac(this, cVar, "task_searchweek_program", str, s).a();
    }

    public void a(int i, String str, a.c cVar) {
        new ad(this, cVar, "task_searchprogram", i, str).a();
    }
}
