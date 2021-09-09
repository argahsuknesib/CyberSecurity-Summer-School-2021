package com.google.common.collect;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w INSTANCE = new $$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w();

    private /* synthetic */ $$Lambda$SIBU91s2V_lsg9WNIhV53gu2h_w() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSetMultimap.Builder) obj).combine((ImmutableMultimap.Builder) ((ImmutableSetMultimap.Builder) obj2));
    }
}
