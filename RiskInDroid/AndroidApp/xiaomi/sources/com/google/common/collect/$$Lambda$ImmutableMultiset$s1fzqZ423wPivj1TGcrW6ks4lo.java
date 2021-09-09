package com.google.common.collect;

import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcr-W6ks4lo  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcrW6ks4lo implements Function {
    public static final /* synthetic */ $$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcrW6ks4lo INSTANCE = new $$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcrW6ks4lo();

    private /* synthetic */ $$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcrW6ks4lo() {
    }

    public final Object apply(Object obj) {
        return ImmutableMultiset.copyFromEntries(((Multiset) obj).entrySet());
    }
}
