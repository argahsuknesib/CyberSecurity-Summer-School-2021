package io.realm;

public enum Sort {
    ASCENDING(true),
    DESCENDING(false);
    
    private final boolean value;

    private Sort(boolean z) {
        this.value = z;
    }

    public final boolean getValue() {
        return this.value;
    }
}
