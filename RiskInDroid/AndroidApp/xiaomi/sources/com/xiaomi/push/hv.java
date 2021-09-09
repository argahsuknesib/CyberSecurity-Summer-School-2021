package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hv extends Enum<hv> {

    /* renamed from: a  reason: collision with root package name */
    public static final hv f6397a = new hv("MISC_CONFIG", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hv[] f59a = a();
    public static final hv b = new hv("PLUGIN_CONFIG", 1, 2);

    /* renamed from: a  reason: collision with other field name */
    private final int f60a;

    private hv(String str, int i, int i2) {
        this.f60a = i2;
    }

    public static hv a(int i) {
        if (i == 1) {
            return f6397a;
        }
        if (i != 2) {
            return null;
        }
        return b;
    }

    public static hv valueOf(String str) {
        return (hv) Enum.valueOf(hv.class, str);
    }

    public static hv[] values() {
        return (hv[]) f59a.clone();
    }

    public final int a() {
        return this.f60a;
    }
}
