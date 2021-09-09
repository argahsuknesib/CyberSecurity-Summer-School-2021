package com.google.common.collect;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE INSTANCE = new $$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE();

    private /* synthetic */ $$Lambda$ImmutableSortedMultiset$iSZBRszHXFXNOPGHgGMuoWQwExE() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Multiset) obj).addAll((Multiset) obj2);
    }
}
