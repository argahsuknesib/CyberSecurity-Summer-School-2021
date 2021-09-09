package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE INSTANCE = new $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE();

    private /* synthetic */ $$Lambda$gr3P2nGL7W8VpcERw4klfzrPGXE() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Maps.Accumulator) obj).combine((Maps.Accumulator) obj2);
    }
}
