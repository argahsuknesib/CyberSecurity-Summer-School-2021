package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class hw extends Enum<hw> {

    /* renamed from: a  reason: collision with root package name */
    public static final hw f6398a = new hw("INT", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ hw[] f61a = a();
    public static final hw b = new hw("LONG", 1, 2);
    public static final hw c = new hw("STRING", 2, 3);
    public static final hw d = new hw("BOOLEAN", 3, 4);

    /* renamed from: a  reason: collision with other field name */
    private final int f62a;

    private hw(String str, int i, int i2) {
        this.f62a = i2;
    }

    public static hw a(int i) {
        if (i == 1) {
            return f6398a;
        }
        if (i == 2) {
            return b;
        }
        if (i == 3) {
            return c;
        }
        if (i != 4) {
            return null;
        }
        return d;
    }

    private static /* synthetic */ hw[] a() {
        return new hw[]{f6398a, b, c, d};
    }

    public static hw valueOf(String str) {
        return (hw) Enum.valueOf(hw.class, str);
    }

    public static hw[] values() {
        return (hw[]) f61a.clone();
    }
}
