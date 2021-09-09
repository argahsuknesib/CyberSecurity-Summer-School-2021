package com.squareup.wire;

import _m_j.jaz;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.ByteString;

public final class ProtoReader {
    private long limit = Long.MAX_VALUE;
    private FieldEncoding nextFieldEncoding;
    private long pos = 0;
    private long pushedLimit = -1;
    private int recursionDepth;
    private final jaz source;
    private int state = 2;
    private int tag = -1;

    public ProtoReader(jaz jaz) {
        this.source = jaz;
    }

    public final long beginMessage() throws IOException {
        if (this.state == 2) {
            int i = this.recursionDepth + 1;
            this.recursionDepth = i;
            if (i <= 65) {
                long j = this.pushedLimit;
                this.pushedLimit = -1;
                this.state = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public final void endMessage(long j) throws IOException {
        if (this.state == 6) {
            int i = this.recursionDepth - 1;
            this.recursionDepth = i;
            if (i < 0 || this.pushedLimit != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            } else if (this.pos == this.limit || this.recursionDepth == 0) {
                this.limit = j;
            } else {
                throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()");
        }
    }

    public final int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        } else if (i == 6) {
            while (this.pos < this.limit && !this.source.O00000o()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 != 0) {
                    this.tag = internalReadVarint32 >> 3;
                    int i2 = internalReadVarint32 & 7;
                    if (i2 == 0) {
                        this.nextFieldEncoding = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    } else if (i2 == 1) {
                        this.nextFieldEncoding = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    } else if (i2 == 2) {
                        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        int internalReadVarint322 = internalReadVarint32();
                        if (internalReadVarint322 < 0) {
                            throw new ProtocolException("Negative length: ".concat(String.valueOf(internalReadVarint322)));
                        } else if (this.pushedLimit == -1) {
                            this.pushedLimit = this.limit;
                            this.limit = this.pos + ((long) internalReadVarint322);
                            if (this.limit <= this.pushedLimit) {
                                return this.tag;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i2 == 3) {
                        skipGroup(this.tag);
                    } else if (i2 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i2 == 5) {
                        this.nextFieldEncoding = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    } else {
                        throw new ProtocolException("Unexpected field encoding: ".concat(String.valueOf(i2)));
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final FieldEncoding peekFieldEncoding() throws IOException {
        return this.nextFieldEncoding;
    }

    public final void skip() throws IOException {
        int i = this.state;
        if (i == 0) {
            readVarint64();
        } else if (i == 1) {
            readFixed64();
        } else if (i == 2) {
            this.source.O0000Oo0(beforeLengthDelimitedScalar());
        } else if (i == 5) {
            readFixed32();
        } else {
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private void skipGroup(int i) throws IOException {
        while (this.pos < this.limit && !this.source.O00000o()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 != 0) {
                int i2 = internalReadVarint32 >> 3;
                int i3 = internalReadVarint32 & 7;
                if (i3 == 0) {
                    this.state = 0;
                    readVarint64();
                } else if (i3 == 1) {
                    this.state = 1;
                    readFixed64();
                } else if (i3 == 2) {
                    long internalReadVarint322 = (long) internalReadVarint32();
                    this.pos += internalReadVarint322;
                    this.source.O0000Oo0(internalReadVarint322);
                } else if (i3 == 3) {
                    skipGroup(i2);
                } else if (i3 != 4) {
                    if (i3 == 5) {
                        this.state = 5;
                        readFixed32();
                    } else {
                        throw new ProtocolException("Unexpected field encoding: ".concat(String.valueOf(i3)));
                    }
                } else if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    public final ByteString readBytes() throws IOException {
        return this.source.O00000o(beforeLengthDelimitedScalar());
    }

    public final String readString() throws IOException {
        return this.source.O00000oO(beforeLengthDelimitedScalar());
    }

    public final int readVarint32() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            int internalReadVarint32 = internalReadVarint32();
            afterPackableScalar(0);
            return internalReadVarint32;
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() throws IOException {
        int i;
        this.pos++;
        byte O0000O0o = this.source.O0000O0o();
        if (O0000O0o >= 0) {
            return O0000O0o;
        }
        byte b = O0000O0o & Byte.MAX_VALUE;
        this.pos++;
        byte O0000O0o2 = this.source.O0000O0o();
        if (O0000O0o2 >= 0) {
            i = O0000O0o2 << 7;
        } else {
            b |= (O0000O0o2 & Byte.MAX_VALUE) << 7;
            this.pos++;
            byte O0000O0o3 = this.source.O0000O0o();
            if (O0000O0o3 >= 0) {
                i = O0000O0o3 << 14;
            } else {
                b |= (O0000O0o3 & Byte.MAX_VALUE) << 14;
                this.pos++;
                byte O0000O0o4 = this.source.O0000O0o();
                if (O0000O0o4 >= 0) {
                    i = O0000O0o4 << 21;
                } else {
                    byte b2 = b | ((O0000O0o4 & Byte.MAX_VALUE) << 21);
                    this.pos++;
                    byte O0000O0o5 = this.source.O0000O0o();
                    byte b3 = b2 | (O0000O0o5 << 28);
                    if (O0000O0o5 >= 0) {
                        return b3;
                    }
                    for (int i2 = 0; i2 < 5; i2++) {
                        this.pos++;
                        if (this.source.O0000O0o() >= 0) {
                            return b3;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return b | i;
    }

    public final long readVarint64() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.pos++;
                byte O0000O0o = this.source.O0000O0o();
                j |= ((long) (O0000O0o & Byte.MAX_VALUE)) << i2;
                if ((O0000O0o & 128) == 0) {
                    afterPackableScalar(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
    }

    public final int readFixed32() throws IOException {
        int i = this.state;
        if (i == 5 || i == 2) {
            this.source.O000000o(4);
            this.pos += 4;
            int O0000Ooo = this.source.O0000Ooo();
            afterPackableScalar(5);
            return O0000Ooo;
        }
        throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
    }

    public final long readFixed64() throws IOException {
        int i = this.state;
        if (i == 1 || i == 2) {
            this.source.O000000o(8);
            this.pos += 8;
            long O0000o00 = this.source.O0000o00();
            afterPackableScalar(1);
            return O0000o00;
        }
        throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
    }

    private void afterPackableScalar(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else if (j == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            this.state = 6;
        } else {
            this.state = 7;
        }
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j = this.limit - this.pos;
            this.source.O000000o(j);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            return j;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }
}
