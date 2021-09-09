package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.SlidingPercentile;
import java.util.Comparator;

/* renamed from: com.google.android.exoplayer2.util.-$$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE implements Comparator {
    public static final /* synthetic */ $$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE INSTANCE = new $$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE();

    private /* synthetic */ $$Lambda$SlidingPercentile$UufTq1Ma5g1qQu0Vqc6f2CE68bE() {
    }

    public final int compare(Object obj, Object obj2) {
        return Float.compare(((SlidingPercentile.Sample) obj).value, ((SlidingPercentile.Sample) obj2).value);
    }
}
