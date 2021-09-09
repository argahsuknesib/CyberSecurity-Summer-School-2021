package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.google.android.exoplayer2.source.ExtractorMediaSource;

public class DefaultByteArrayPoolParams {
    public static PoolParams get() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(16384, 5);
        return new PoolParams(81920, ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, sparseIntArray);
    }
}
