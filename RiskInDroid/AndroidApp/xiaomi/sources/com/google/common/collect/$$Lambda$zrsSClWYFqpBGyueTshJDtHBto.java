package com.google.common.collect;

import java.util.LinkedHashMap;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$zrsSClWYFqpBGyueTshJD-tHBto  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$zrsSClWYFqpBGyueTshJDtHBto implements Function {
    public static final /* synthetic */ $$Lambda$zrsSClWYFqpBGyueTshJDtHBto INSTANCE = new $$Lambda$zrsSClWYFqpBGyueTshJDtHBto();

    private /* synthetic */ $$Lambda$zrsSClWYFqpBGyueTshJDtHBto() {
    }

    public final Object apply(Object obj) {
        return ImmutableMap.copyOf((LinkedHashMap) obj);
    }
}
