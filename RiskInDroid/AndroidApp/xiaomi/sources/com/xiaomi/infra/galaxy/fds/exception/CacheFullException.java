package com.xiaomi.infra.galaxy.fds.exception;

public class CacheFullException extends Exception {
    private int bucketIndex;
    private int requestedSize;

    public CacheFullException(int i, int i2) {
        this.requestedSize = i;
        this.bucketIndex = i2;
    }

    public int bucketIndex() {
        return this.bucketIndex;
    }

    public int requestedSize() {
        return this.requestedSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("Allocator requested size ");
        sb.append(this.requestedSize);
        sb.append(" for bucket ");
        sb.append(this.bucketIndex);
        return sb.toString();
    }
}
