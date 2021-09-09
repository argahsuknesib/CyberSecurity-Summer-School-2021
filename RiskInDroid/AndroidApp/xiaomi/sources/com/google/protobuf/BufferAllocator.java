package com.google.protobuf;

import java.nio.ByteBuffer;

abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() {
        /* class com.google.protobuf.BufferAllocator.AnonymousClass1 */

        public final AllocatedBuffer allocateHeapBuffer(int i) {
            return AllocatedBuffer.wrap(new byte[i]);
        }

        public final AllocatedBuffer allocateDirectBuffer(int i) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i));
        }
    };

    public abstract AllocatedBuffer allocateDirectBuffer(int i);

    public abstract AllocatedBuffer allocateHeapBuffer(int i);

    BufferAllocator() {
    }

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }
}
