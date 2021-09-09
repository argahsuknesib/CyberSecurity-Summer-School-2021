package com.google.common.collect;

import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA implements Function {
    public static final /* synthetic */ $$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA INSTANCE = new $$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA();

    private /* synthetic */ $$Lambda$Xxw32g7ROf3L8FxiPJeloRx_PDA() {
    }

    public final Object apply(Object obj) {
        return ImmutableListMultimap.copyOf((Multimap) ((ListMultimap) obj));
    }
}
