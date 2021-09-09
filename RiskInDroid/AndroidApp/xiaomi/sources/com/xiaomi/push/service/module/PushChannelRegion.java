package com.xiaomi.push.service.module;

/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
@Deprecated
public final class PushChannelRegion extends Enum<PushChannelRegion> {
    private static final /* synthetic */ PushChannelRegion[] $VALUES = $values();
    public static final PushChannelRegion China = new PushChannelRegion("China", 0);
    public static final PushChannelRegion Europe = new PushChannelRegion("Europe", 2);
    public static final PushChannelRegion Global = new PushChannelRegion("Global", 1);
    public static final PushChannelRegion India = new PushChannelRegion("India", 4);
    public static final PushChannelRegion Russia = new PushChannelRegion("Russia", 3);

    private static /* synthetic */ PushChannelRegion[] $values() {
        return new PushChannelRegion[]{China, Global, Europe, Russia, India};
    }

    private PushChannelRegion(String str, int i) {
    }

    public static PushChannelRegion valueOf(String str) {
        return (PushChannelRegion) Enum.valueOf(PushChannelRegion.class, str);
    }

    public static PushChannelRegion[] values() {
        return (PushChannelRegion[]) $VALUES.clone();
    }
}
