package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM INSTANCE = new $$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM();

    private /* synthetic */ $$Lambda$xRTACJ_W0N2wW_qcPf4oUEy47wM() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableSortedMap.Builder) obj).combine((ImmutableMap.Builder) ((ImmutableSortedMap.Builder) obj2));
    }
}
