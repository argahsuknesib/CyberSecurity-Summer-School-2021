package com.facebook.imagepipeline.memory;

public interface PoolStatsTracker {
    void onAlloc(int i);

    void onFree(int i);

    void onHardCapReached();

    void onSoftCapReached();

    void onValueRelease(int i);

    void onValueReuse(int i);

    void setBasePool(BasePool basePool);
}
