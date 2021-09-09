package net.sqlcipher;

public class CustomCursorWindowAllocation implements CursorWindowAllocation {
    private long growthPaddingSize = 0;
    private long initialAllocationSize = 0;
    private long maxAllocationSize = 0;

    public CustomCursorWindowAllocation(long j, long j2, long j3) {
        this.initialAllocationSize = j;
        this.growthPaddingSize = j2;
        this.maxAllocationSize = j3;
    }

    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    public long getGrowthPaddingSize() {
        return this.growthPaddingSize;
    }

    public long getMaxAllocationSize() {
        return this.maxAllocationSize;
    }
}
