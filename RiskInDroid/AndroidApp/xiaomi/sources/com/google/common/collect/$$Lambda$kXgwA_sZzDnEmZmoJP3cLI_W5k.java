package com.google.common.collect;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultimap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$kX-gwA_sZzDnEmZmoJP3cLI_W5k  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$kXgwA_sZzDnEmZmoJP3cLI_W5k implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$kXgwA_sZzDnEmZmoJP3cLI_W5k INSTANCE = new $$Lambda$kXgwA_sZzDnEmZmoJP3cLI_W5k();

    private /* synthetic */ $$Lambda$kXgwA_sZzDnEmZmoJP3cLI_W5k() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableListMultimap.Builder) obj).combine((ImmutableMultimap.Builder) ((ImmutableListMultimap.Builder) obj2));
    }
}
