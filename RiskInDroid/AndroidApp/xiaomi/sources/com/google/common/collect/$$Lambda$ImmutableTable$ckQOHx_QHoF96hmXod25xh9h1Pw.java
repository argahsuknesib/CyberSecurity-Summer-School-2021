package com.google.common.collect;

import com.google.common.collect.ImmutableTable;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw INSTANCE = new $$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw();

    private /* synthetic */ $$Lambda$ImmutableTable$ckQOHx_QHoF96hmXod25xh9h1Pw() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableTable.Builder) obj).combine((ImmutableTable.Builder) obj2);
    }
}
