package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.util.SortedSet;

@GwtIncompatible
interface SortedMultisetBridge<E> extends Multiset<E> {

    /* renamed from: com.google.common.collect.SortedMultisetBridge$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    SortedSet<E> elementSet();
}
