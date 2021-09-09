package com.google.common.collect;

import java.util.function.BinaryOperator;

/* renamed from: com.google.common.collect.-$$Lambda$Multisets$nSg8KnV2rWlaLPt0DUhOLaV0hIY  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Multisets$nSg8KnV2rWlaLPt0DUhOLaV0hIY implements BinaryOperator {
    public static final /* synthetic */ $$Lambda$Multisets$nSg8KnV2rWlaLPt0DUhOLaV0hIY INSTANCE = new $$Lambda$Multisets$nSg8KnV2rWlaLPt0DUhOLaV0hIY();

    private /* synthetic */ $$Lambda$Multisets$nSg8KnV2rWlaLPt0DUhOLaV0hIY() {
    }

    public final Object apply(Object obj, Object obj2) {
        return ((Multiset) obj).addAll((Multiset) obj2);
    }
}
