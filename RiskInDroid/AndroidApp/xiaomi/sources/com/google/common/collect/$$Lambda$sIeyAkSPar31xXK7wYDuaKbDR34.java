package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34 implements Function {
    public static final /* synthetic */ $$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34 INSTANCE = new $$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34();

    private /* synthetic */ $$Lambda$sIeyAkSPar31xXK7wYDuaKbDR34() {
    }

    public final Object apply(Object obj) {
        return ((Sets.Accumulator) obj).toImmutableSet();
    }
}
