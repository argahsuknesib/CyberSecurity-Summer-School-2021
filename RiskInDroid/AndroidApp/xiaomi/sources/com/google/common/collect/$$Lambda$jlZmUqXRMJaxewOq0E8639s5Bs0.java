package com.google.common.collect;

import com.google.common.collect.Sets;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0 implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0 INSTANCE = new $$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0();

    private /* synthetic */ $$Lambda$jlZmUqXRMJaxewOq0E8639s5Bs0() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Sets.Accumulator) obj).combine((Sets.Accumulator) obj2);
    }
}
