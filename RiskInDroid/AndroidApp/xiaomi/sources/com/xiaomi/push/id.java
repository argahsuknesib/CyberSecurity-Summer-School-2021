package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class id extends Enum<id> {

    /* renamed from: a  reason: collision with root package name */
    public static final id f6410a = new id("RegIdExpired", 0, 0);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ id[] f92a = a();
    public static final id b = new id("PackageUnregistered", 1, 1);
    public static final id c = new id("Init", 2, 2);

    /* renamed from: a  reason: collision with other field name */
    private final int f93a;

    private id(String str, int i, int i2) {
        this.f93a = i2;
    }

    public static id a(int i) {
        if (i == 0) {
            return f6410a;
        }
        if (i == 1) {
            return b;
        }
        if (i != 2) {
            return null;
        }
        return c;
    }

    public static id valueOf(String str) {
        return (id) Enum.valueOf(id.class, str);
    }

    public static id[] values() {
        return (id[]) f92a.clone();
    }

    public final int a() {
        return this.f93a;
    }
}
