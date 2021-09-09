package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y INSTANCE = new $$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y();

    private /* synthetic */ $$Lambda$iMl639MbEQfK2Uwz4dSjiDOdD0Y() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableMap.Builder) obj).combine((ImmutableMap.Builder) obj2);
    }
}
