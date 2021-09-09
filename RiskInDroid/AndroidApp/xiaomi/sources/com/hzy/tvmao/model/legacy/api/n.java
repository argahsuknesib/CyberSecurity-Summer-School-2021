package com.hzy.tvmao.model.legacy.api;

public class n<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f4436a;
    public String b;
    public String c = "";
    public byte[] d = null;
    public T e = null;

    public boolean a() {
        return this.f4436a == 1;
    }

    public static n a(int i, String str) {
        n nVar = new n();
        nVar.f4436a = i;
        if (str == null) {
            str = "网络错误";
        }
        nVar.b = str;
        return nVar;
    }

    public static n b() {
        return a(0, "网络错误");
    }
}
