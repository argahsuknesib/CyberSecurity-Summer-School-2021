package com.mi.global.shop.model.discover;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class UpBody extends Message<UpBody, Builder> {
    public static final ProtoAdapter<UpBody> ADAPTER = new ProtoAdapter_UpBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.UpData#ADAPTER", tag = 5)
    public final UpData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public UpBody(Integer num, String str, UpData upData) {
        this(num, str, upData, ByteString.O00000Oo);
    }

    public UpBody(Integer num, String str, UpData upData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = upData;
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
        if (!(obj instanceof UpBody)) {
            return false;
        }
        UpBody upBody = (UpBody) obj;
        return Internal.equals(unknownFields(), upBody.unknownFields()) && Internal.equals(this.errno, upBody.errno) && Internal.equals(this.errmsg, upBody.errmsg) && Internal.equals(this.data, upBody.data);
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
        UpData upData = this.data;
        if (upData != null) {
            i2 = upData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "UpBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<UpBody, Builder> {
        public UpData data;
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

        public final Builder data(UpData upData) {
            this.data = upData;
            return this;
        }

        public final UpBody build() {
            return new UpBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_UpBody extends ProtoAdapter<UpBody> {
        ProtoAdapter_UpBody() {
            super(FieldEncoding.LENGTH_DELIMITED, UpBody.class);
        }

        public final int encodedSize(UpBody upBody) {
            int i = 0;
            int encodedSizeWithTag = (upBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, upBody.errno) : 0) + (upBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, upBody.errmsg) : 0);
            if (upBody.data != null) {
                i = UpData.ADAPTER.encodedSizeWithTag(5, upBody.data);
            }
            return encodedSizeWithTag + i + upBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, UpBody upBody) throws IOException {
            if (upBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, upBody.errno);
            }
            if (upBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, upBody.errmsg);
            }
            if (upBody.data != null) {
                UpData.ADAPTER.encodeWithTag(protoWriter, 5, upBody.data);
            }
            protoWriter.writeBytes(upBody.unknownFields());
        }

        public final UpBody decode(ProtoReader protoReader) throws IOException {
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
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(UpData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final UpBody redact(UpBody upBody) {
            Builder newBuilder = upBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = UpData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
