package com.google.common.collect;

import com.google.common.collect.MoreCollectors;
import java.util.function.BiConsumer;

/* renamed from: com.google.common.collect.-$$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI implements BiConsumer {
    public static final /* synthetic */ $$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI INSTANCE = new $$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI();

    private /* synthetic */ $$Lambda$OugZ7uzX1ge93a2UFbU199Ga9uI() {
    }

    public final void accept(Object obj, Object obj2) {
        ((MoreCollectors.ToOptionalState) obj).add(obj2);
    }
}
