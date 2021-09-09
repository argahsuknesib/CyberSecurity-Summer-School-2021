package com.xiaomi.mipush.sdk;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class e extends Enum<e> {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6055a = new e("ASSEMBLE_PUSH_HUAWEI", 0, 1);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ e[] f25a = a();
    public static final e b = new e("ASSEMBLE_PUSH_FCM", 1, 2);
    public static final e c = new e("ASSEMBLE_PUSH_COS", 2, 3);
    public static final e d = new e("ASSEMBLE_PUSH_FTOS", 3, 4);

    /* renamed from: a  reason: collision with other field name */
    private int f26a;

    private e(String str, int i, int i2) {
        this.f26a = i2;
    }

    private static /* synthetic */ e[] a() {
        return new e[]{f6055a, b, c, d};
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) f25a.clone();
    }
}
