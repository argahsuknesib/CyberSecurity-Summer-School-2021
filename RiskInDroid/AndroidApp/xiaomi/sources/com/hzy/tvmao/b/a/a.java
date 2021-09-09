package com.hzy.tvmao.b.a;

import com.hzy.tvmao.model.legacy.api.n;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4410a;
    private int b;
    private String c;
    private byte[] d = null;
    private Object e = null;
    private List<?> f = null;

    public a(int i) {
        this.b = i;
    }

    public a(n<?> nVar) {
        if (nVar != null) {
            this.b = nVar.f4436a;
            this.c = nVar.b;
            this.e = nVar.e;
            this.d = nVar.d;
            return;
        }
        this.b = 0;
        this.c = "null was responsed";
    }

    public a(int i, String str, Object obj) {
        this.b = i;
        this.c = str;
        this.e = obj;
    }

    public void a(String str) {
        this.f4410a = str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Object c() {
        return this.e;
    }

    public boolean d() {
        return this.b == 1;
    }

    public String toString() {
        return "ModelBean [ taskKey=" + this.f4410a + ", respCode=" + this.b + ", respMsg=" + this.c + ", data=" + this.e + "]";
    }
}
