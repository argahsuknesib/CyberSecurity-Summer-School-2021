package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Collections;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$Multisets$cvAUryqBQ5ACjGtci4h38iRqYCM  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$Multisets$cvAUryqBQ5ACjGtci4h38iRqYCM implements Function {
    public static final /* synthetic */ $$Lambda$Multisets$cvAUryqBQ5ACjGtci4h38iRqYCM INSTANCE = new $$Lambda$Multisets$cvAUryqBQ5ACjGtci4h38iRqYCM();

    private /* synthetic */ $$Lambda$Multisets$cvAUryqBQ5ACjGtci4h38iRqYCM() {
    }

    public final Object apply(Object obj) {
        return Collections.nCopies(((Multiset.Entry) obj).getCount(), ((Multiset.Entry) obj).getElement()).spliterator();
    }
}
