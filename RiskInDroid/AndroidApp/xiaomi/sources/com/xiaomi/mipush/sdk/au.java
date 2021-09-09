package com.xiaomi.mipush.sdk;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class au extends Enum<au> {

    /* renamed from: a  reason: collision with root package name */
    public static final au f6052a = new au("DISABLE_PUSH", 0);

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ au[] f24a = a();
    public static final au b = new au("ENABLE_PUSH", 1);
    public static final au c = new au("UPLOAD_HUAWEI_TOKEN", 2);
    public static final au d = new au("UPLOAD_FCM_TOKEN", 3);
    public static final au e = new au("UPLOAD_COS_TOKEN", 4);
    public static final au f = new au("UPLOAD_FTOS_TOKEN", 5);

    private au(String str, int i) {
    }

    private static /* synthetic */ au[] a() {
        return new au[]{f6052a, b, c, d, e, f};
    }

    public static au valueOf(String str) {
        return (au) Enum.valueOf(au.class, str);
    }

    public static au[] values() {
        return (au[]) f24a.clone();
    }
}
