package com.xiaomi.push;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
public final class em extends Enum<em> {

    /* renamed from: a  reason: collision with root package name */
    public static final em f6375a = new em("ACTIVITY", 0, "activity");

    /* renamed from: a  reason: collision with other field name */
    private static final /* synthetic */ em[] f27a = a();
    public static final em b = new em("SERVICE_ACTION", 1, "service_action");
    public static final em c = new em("SERVICE_COMPONENT", 2, "service_component");
    public static final em d = new em("PROVIDER", 3, "provider");

    /* renamed from: a  reason: collision with other field name */
    public String f28a;

    private em(String str, int i, String str2) {
        this.f28a = str2;
    }

    private static /* synthetic */ em[] a() {
        return new em[]{f6375a, b, c, d};
    }

    public static em valueOf(String str) {
        return (em) Enum.valueOf(em.class, str);
    }

    public static em[] values() {
        return (em[]) f27a.clone();
    }
}
