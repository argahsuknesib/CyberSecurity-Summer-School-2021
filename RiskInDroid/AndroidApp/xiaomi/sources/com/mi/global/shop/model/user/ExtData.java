package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ExtData extends Message<ExtData, Builder> {
    public static final ProtoAdapter<ExtData> ADAPTER = new ProtoAdapter_ExtData();
    public static final Integer DEFAULT_SEND = 0;
    public static final Integer DEFAULT_UNPAID = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer send;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer unpaid;

    public ExtData(Integer num, Integer num2) {
        this(num, num2, ByteString.O00000Oo);
    }

    public ExtData(Integer num, Integer num2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.unpaid = num;
        this.send = num2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.unpaid = this.unpaid;
        builder.send = this.send;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExtData)) {
            return false;
        }
        ExtData extData = (ExtData) obj;
        return Internal.equals(unknownFields(), extData.unknownFields()) && Internal.equals(this.unpaid, extData.unpaid) && Internal.equals(this.send, extData.send);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.unpaid;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.send;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.unpaid != null) {
            sb.append(", unpaid=");
            sb.append(this.unpaid);
        }
        if (this.send != null) {
            sb.append(", send=");
            sb.append(this.send);
        }
        StringBuilder replace = sb.replace(0, 2, "ExtData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ExtData, Builder> {
        public Integer send;
        public Integer unpaid;

        public final Builder unpaid(Integer num) {
            this.unpaid = num;
            return this;
        }

        public final Builder send(Integer num) {
            this.send = num;
            return this;
        }

        public final ExtData build() {
            return new ExtData(this.unpaid, this.send, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ExtData extends ProtoAdapter<ExtData> {
        ProtoAdapter_ExtData() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtData.class);
        }

        public final int encodedSize(ExtData extData) {
            int i = 0;
            int encodedSizeWithTag = extData.unpaid != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, extData.unpaid) : 0;
            if (extData.send != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(2, extData.send);
            }
            return encodedSizeWithTag + i + extData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ExtData extData) throws IOException {
            if (extData.unpaid != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, extData.unpaid);
            }
            if (extData.send != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, extData.send);
            }
            protoWriter.writeBytes(extData.unknownFields());
        }

        public final ExtData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.unpaid(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.send(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public final ExtData redact(ExtData extData) {
            Builder newBuilder = extData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
