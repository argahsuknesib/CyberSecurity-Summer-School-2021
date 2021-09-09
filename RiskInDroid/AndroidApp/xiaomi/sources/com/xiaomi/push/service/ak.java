package com.xiaomi.push.service;

import _m_j.ero;
import java.util.Iterator;
import java.util.List;

class ak implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f6497a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f249a;

    ak(List list, boolean z) {
        this.f6497a = list;
        this.f249a = z;
    }

    public void run() {
        int i;
        boolean a2 = aj.a("www.baidu.com:80");
        Iterator it = this.f6497a.iterator();
        while (true) {
            i = 1;
            if (!it.hasNext()) {
                break;
            }
            a2 = a2 || aj.a((String) it.next());
            if (a2 && !this.f249a) {
                break;
            }
        }
        if (!a2) {
            i = 2;
        }
        ero.O00000Oo(i);
    }
}
