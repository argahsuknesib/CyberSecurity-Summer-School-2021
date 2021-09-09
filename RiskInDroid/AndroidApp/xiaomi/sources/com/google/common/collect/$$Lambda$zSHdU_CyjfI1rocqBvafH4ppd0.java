package com.google.common.collect;

import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$zSHdU_CyjfI1-rocqBvafH4ppd0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$zSHdU_CyjfI1rocqBvafH4ppd0 implements Function {
    public static final /* synthetic */ $$Lambda$zSHdU_CyjfI1rocqBvafH4ppd0 INSTANCE = new $$Lambda$zSHdU_CyjfI1rocqBvafH4ppd0();

    private /* synthetic */ $$Lambda$zSHdU_CyjfI1rocqBvafH4ppd0() {
    }

    public final Object apply(Object obj) {
        return ImmutableSetMultimap.copyOf((Multimap) ((SetMultimap) obj));
    }
}
