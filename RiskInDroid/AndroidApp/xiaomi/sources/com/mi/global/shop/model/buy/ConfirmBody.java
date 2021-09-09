package com.mi.global.shop.model.buy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ConfirmBody extends Message<ConfirmBody, Builder> {
    public static final ProtoAdapter<ConfirmBody> ADAPTER = new ProtoAdapter_ConfirmBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.buy.ConfirmData#ADAPTER", tag = 5)
    public final ConfirmData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public ConfirmBody(Integer num, String str, ConfirmData confirmData) {
        this(num, str, confirmData, ByteString.O00000Oo);
    }

    public ConfirmBody(Integer num, String str, ConfirmData confirmData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = confirmData;
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
        if (!(obj instanceof ConfirmBody)) {
            return false;
        }
        ConfirmBody confirmBody = (ConfirmBody) obj;
        return Internal.equals(unknownFields(), confirmBody.unknownFields()) && Internal.equals(this.errno, confirmBody.errno) && Internal.equals(this.errmsg, confirmBody.errmsg) && Internal.equals(this.data, confirmBody.data);
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
        ConfirmData confirmData = this.data;
        if (confirmData != null) {
            i2 = confirmData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "ConfirmBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ConfirmBody, Builder> {
        public ConfirmData data;
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

        public final Builder data(ConfirmData confirmData) {
            this.data = confirmData;
            return this;
        }

        public final ConfirmBody build() {
            return new ConfirmBody(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ConfirmBody extends ProtoAdapter<ConfirmBody> {
        ProtoAdapter_ConfirmBody() {
            super(FieldEncoding.LENGTH_DELIMITED, ConfirmBody.class);
        }

        public final int encodedSize(ConfirmBody confirmBody) {
            int i = 0;
            int encodedSizeWithTag = (confirmBody.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, confirmBody.errno) : 0) + (confirmBody.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, confirmBody.errmsg) : 0);
            if (confirmBody.data != null) {
                i = ConfirmData.ADAPTER.encodedSizeWithTag(5, confirmBody.data);
            }
            return encodedSizeWithTag + i + confirmBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ConfirmBody confirmBody) throws IOException {
            if (confirmBody.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, confirmBody.errno);
            }
            if (confirmBody.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, confirmBody.errmsg);
            }
            if (confirmBody.data != null) {
                ConfirmData.ADAPTER.encodeWithTag(protoWriter, 5, confirmBody.data);
            }
            protoWriter.writeBytes(confirmBody.unknownFields());
        }

        public final ConfirmBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.data(ConfirmData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ConfirmBody redact(ConfirmBody confirmBody) {
            Builder newBuilder = confirmBody.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = ConfirmData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
