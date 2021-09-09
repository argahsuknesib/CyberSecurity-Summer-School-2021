package net.sqlcipher;

public class DefaultCursorWindowAllocation implements CursorWindowAllocation {
    private long WindowAllocationUnbounded = 0;
    private long initialAllocationSize = 1048576;

    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    public long getGrowthPaddingSize() {
        return this.initialAllocationSize;
    }

    public long getMaxAllocationSize() {
        return this.WindowAllocationUnbounded;
    }
}
