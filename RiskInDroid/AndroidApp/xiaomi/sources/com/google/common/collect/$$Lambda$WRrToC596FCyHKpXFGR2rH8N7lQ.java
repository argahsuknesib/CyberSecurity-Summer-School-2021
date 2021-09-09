package com.google.common.collect;

import java.util.TreeMap;
import java.util.function.Function;

/* renamed from: com.google.common.collect.-$$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ implements Function {
    public static final /* synthetic */ $$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ INSTANCE = new $$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ();

    private /* synthetic */ $$Lambda$WRrToC596FCyHKpXFGR2rH8N7lQ() {
    }

    public final Object apply(Object obj) {
        return ImmutableSortedMap.copyOfSorted((TreeMap) obj);
    }
}
