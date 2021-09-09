package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw INSTANCE = new $$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw();

    private /* synthetic */ $$Lambda$QPuM9iKoW1PCf2mQzuKDfsTjICw() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableBiMap.Builder) obj).combine((ImmutableMap.Builder) ((ImmutableBiMap.Builder) obj2));
    }
}
