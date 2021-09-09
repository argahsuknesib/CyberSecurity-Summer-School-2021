package com.google.common.collect;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c INSTANCE = new $$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c();

    private /* synthetic */ $$Lambda$Iilf_x3Yim75FBgBCib4qGxg29c() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((TopKSelector) obj).combine((TopKSelector) obj2);
    }
}
