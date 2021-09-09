package com.facebook.imagepipeline.cache;

import com.facebook.common.logging.FLog;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.imagepipeline.cache.CountingMemoryCache;

public class NativeMemoryCacheTrimStrategy implements CountingMemoryCache.CacheTrimStrategy {

    /* renamed from: com.facebook.imagepipeline.cache.NativeMemoryCacheTrimStrategy$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$common$memory$MemoryTrimType = new int[MemoryTrimType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnCloseToDalvikHeapLimit.ordinal()] = 1;
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnAppBackgrounded.ordinal()] = 2;
            $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInForeground.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$common$memory$MemoryTrimType[MemoryTrimType.OnSystemLowMemoryWhileAppInBackground.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public double getTrimRatio(MemoryTrimType memoryTrimType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$common$memory$MemoryTrimType[memoryTrimType.ordinal()];
        if (i == 1) {
            return 0.0d;
        }
        if (i == 2 || i == 3 || i == 4) {
            return 1.0d;
        }
        FLog.wtf("NativeMemoryCacheTrimStrategy", "unknown trim type: %s", memoryTrimType);
        return 0.0d;
    }
}
