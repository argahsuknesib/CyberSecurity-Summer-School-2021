package com.google.common.collect;

import com.google.common.collect.ImmutableRangeSet;
import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g INSTANCE = new $$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g();

    private /* synthetic */ $$Lambda$7Mxhy81NAiwcDk9tE05wrS15B5g() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((ImmutableRangeSet.Builder) obj).combine((ImmutableRangeSet.Builder) obj2);
    }
}
