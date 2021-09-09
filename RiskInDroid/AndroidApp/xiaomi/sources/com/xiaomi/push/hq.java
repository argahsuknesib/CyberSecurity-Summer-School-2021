package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hq extends Enum<hq> {

    /* renamed from: a  reason: collision with root package name */
    public static final hq f6390a = new hq("START", 0, 0);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hq[] f48a = a();
    public static final hq b = new hq("BIND", 1, 1);

    /* renamed from: a  reason: collision with other field name */
    private final int f49a;

    private hq(String str, int i, int i2) {
        this.f49a = i2;
    }

    public static hq valueOf(String str) {
        return (hq) Enum.valueOf(hq.class, str);
    }

    public static hq[] values() {
        return (hq[]) f48a.clone();
    }

    public final int a() {
        return this.f49a;
    }
}
