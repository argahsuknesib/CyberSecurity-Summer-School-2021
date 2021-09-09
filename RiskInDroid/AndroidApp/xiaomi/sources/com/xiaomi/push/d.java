package com.xiaomi.push;

import java.io.IOException;

public class d extends IOException {
    public d(String str) {
        super(str);
    }

    public static d O000000o() {
        return new d("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    public static d O00000Oo() {
        return new d("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static d O00000o() {
        return new d("Protocol message contained an invalid tag (zero).");
    }

    public static d O00000o0() {
        return new d("CodedInputStream encountered a malformed varint.");
    }

    public static d O00000oO() {
        return new d("Protocol message end-group tag did not match expected tag.");
    }

    public static d O00000oo() {
        return new d("Protocol message tag had invalid wire type.");
    }

    public static d O0000O0o() {
        return new d("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    public static d O0000OOo() {
        return new d("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }
}
