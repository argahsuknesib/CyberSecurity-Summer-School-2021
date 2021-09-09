package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class r extends Enum<r> {

    /* renamed from: a  reason: collision with root package name */
    public static final r f6460a = new r("China", 0);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ r[] f181a = a();
    public static final r b = new r("Global", 1);
    public static final r c = new r("Europe", 2);
    public static final r d = new r("Russia", 3);
    public static final r e = new r("India", 4);

    private r(String str, int i) {
    }

    private static /* synthetic */ r[] a() {
        return new r[]{f6460a, b, c, d, e};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f181a.clone();
    }
}
