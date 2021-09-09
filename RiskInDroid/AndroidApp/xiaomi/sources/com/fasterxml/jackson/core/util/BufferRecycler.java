package com.fasterxml.jackson.core.util;

public final class BufferRecycler {

    /* renamed from: O000000o  reason: collision with root package name */
    protected final byte[][] f3598O000000o = new byte[ByteBufferType.values().length][];
    protected final char[][] O00000Oo = new char[CharBufferType.values().length][];

    public enum ByteBufferType {
        READ_IO_BUFFER(4000),
        WRITE_ENCODING_BUFFER(4000),
        WRITE_CONCAT_BUFFER(2000);
        
        public final int size;

        private ByteBufferType(int i) {
            this.size = i;
        }
    }

    public enum CharBufferType {
        TOKEN_BUFFER(2000),
        CONCAT_BUFFER(2000),
        TEXT_BUFFER(200),
        NAME_COPY_BUFFER(200);
        
        public final int size;

        private CharBufferType(int i) {
            this.size = i;
        }
    }

    public final char[] O000000o(CharBufferType charBufferType) {
        return O000000o(charBufferType, 0);
    }

    public final char[] O000000o(CharBufferType charBufferType, int i) {
        if (charBufferType.size > i) {
            i = charBufferType.size;
        }
        int ordinal = charBufferType.ordinal();
        char[][] cArr = this.O00000Oo;
        char[] cArr2 = cArr[ordinal];
        if (cArr2 == null || cArr2.length < i) {
            return new char[i];
        }
        cArr[ordinal] = null;
        return cArr2;
    }

    public final void O000000o(CharBufferType charBufferType, char[] cArr) {
        this.O00000Oo[charBufferType.ordinal()] = cArr;
    }
}
