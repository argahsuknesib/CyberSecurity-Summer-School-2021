package com.xiaomi.mipush.sdk;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class ag extends Enum<ag> {

    /* renamed from: a  reason: collision with root package name */
    public static final ag f6051a = new ag("HUAWEI", 0);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ ag[] f23a = a();
    public static final ag b = new ag("MEIZU", 1);
    public static final ag c = new ag("FCM", 2);
    public static final ag d = new ag("OPPO", 3);
    public static final ag e = new ag("VIVO", 4);
    public static final ag f = new ag("OTHER", 5);

    private ag(String str, int i) {
    }

    private static /* synthetic */ ag[] a() {
        return new ag[]{f6051a, b, c, d, e, f};
    }

    public static ag valueOf(String str) {
        return (ag) Enum.valueOf(ag.class, str);
    }

    public static ag[] values() {
        return (ag[]) f23a.clone();
    }
}
