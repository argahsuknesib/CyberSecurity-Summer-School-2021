package com.miui.tsmclient.seitsm.a;

public class a extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private int f5262a;

    public a(int i) {
        this(i, "");
    }

    public a(int i, String str) {
        super(str);
        this.f5262a = i;
    }

    public int a() {
        return this.f5262a;
    }

    public String toString() {
        return super.toString() + ", errorCode: " + this.f5262a;
    }
}
