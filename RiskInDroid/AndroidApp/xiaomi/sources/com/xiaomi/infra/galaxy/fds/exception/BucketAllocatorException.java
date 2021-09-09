package com.xiaomi.infra.galaxy.fds.exception;

public class BucketAllocatorException extends RuntimeException {
    public BucketAllocatorException(String str) {
        super(str);
    }

    public BucketAllocatorException() {
    }
}
