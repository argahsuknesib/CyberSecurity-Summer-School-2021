package com.squareup.okhttp.internal.framed;

import okio.ByteString;

public final class Header {
    public static final ByteString RESPONSE_STATUS = ByteString.O000000o(":status");
    public static final ByteString TARGET_AUTHORITY = ByteString.O000000o(":authority");
    public static final ByteString TARGET_HOST = ByteString.O000000o(":host");
    public static final ByteString TARGET_METHOD = ByteString.O000000o(":method");
    public static final ByteString TARGET_PATH = ByteString.O000000o(":path");
    public static final ByteString TARGET_SCHEME = ByteString.O000000o(":scheme");
    public static final ByteString VERSION = ByteString.O000000o(":version");
    final int hpackSize;
    public final ByteString name;
    public final ByteString value;

    public Header(String str, String str2) {
        this(ByteString.O000000o(str), ByteString.O000000o(str2));
    }

    public Header(ByteString byteString, String str) {
        this(byteString, ByteString.O000000o(str));
    }

    public Header(ByteString byteString, ByteString byteString2) {
        this.name = byteString;
        this.value = byteString2;
        this.hpackSize = byteString.O0000OOo() + 32 + byteString2.O0000OOo();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Header) {
            Header header = (Header) obj;
            if (!this.name.equals(header.name) || !this.value.equals(header.value)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.name.hashCode() + 527) * 31) + this.value.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", this.name.O000000o(), this.value.O000000o());
    }
}
