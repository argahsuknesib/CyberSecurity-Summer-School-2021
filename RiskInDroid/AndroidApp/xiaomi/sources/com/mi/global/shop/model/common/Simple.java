package com.mi.global.shop.model.common;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Simple extends Message<Simple, Builder> {
    public static final ProtoAdapter<Simple> ADAPTER = new ProtoAdapter_Simple();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public Simple(Integer num, String str, String str2) {
        this(num, str, str2, ByteString.O00000Oo);
    }

    public Simple(Integer num, String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Simple)) {
            return false;
        }
        Simple simple = (Simple) obj;
        return Internal.equals(unknownFields(), simple.unknownFields()) && Internal.equals(this.errno, simple.errno) && Internal.equals(this.errmsg, simple.errmsg) && Internal.equals(this.data, simple.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.data;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "Simple{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Simple, Builder> {
        public String data;
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(String str) {
            this.data = str;
            return this;
        }

        public final Simple build() {
            return new Simple(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Simple extends ProtoAdapter<Simple> {
        ProtoAdapter_Simple() {
            super(FieldEncoding.LENGTH_DELIMITED, Simple.class);
        }

        public final int encodedSize(Simple simple) {
            int i = 0;
            int encodedSizeWithTag = (simple.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, simple.errno) : 0) + (simple.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, simple.errmsg) : 0);
            if (simple.data != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, simple.data);
            }
            return encodedSizeWithTag + i + simple.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Simple simple) throws IOException {
            if (simple.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, simple.errno);
            }
            if (simple.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, simple.errmsg);
            }
            if (simple.data != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, simple.data);
            }
            protoWriter.writeBytes(simple.unknownFields());
        }

        public final Simple decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final Simple redact(Simple simple) {
            Builder newBuilder = simple.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
