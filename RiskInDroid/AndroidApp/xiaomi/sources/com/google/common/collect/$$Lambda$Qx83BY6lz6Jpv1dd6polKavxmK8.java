package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8 implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8 INSTANCE = new $$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8();

    private /* synthetic */ $$Lambda$Qx83BY6lz6Jpv1dd6polKavxmK8() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableList.Builder) obj).combine((ImmutableList.Builder) obj2);
    }
}
