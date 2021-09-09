package com.mi.global.shop.model.cod;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class CodType extends Message<CodType, Builder> {
    public static final ProtoAdapter<CodType> ADAPTER = new ProtoAdapter_CodType();
    public static final Integer DEFAULT_STATUS = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String block;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String field;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer status;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String status_str;

    public CodType(Integer num, String str, String str2, String str3) {
        this(num, str, str2, str3, ByteString.O00000Oo);
    }

    public CodType(Integer num, String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.status = num;
        this.field = str;
        this.block = str2;
        this.status_str = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.status = this.status;
        builder.field = this.field;
        builder.block = this.block;
        builder.status_str = this.status_str;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CodType)) {
            return false;
        }
        CodType codType = (CodType) obj;
        return Internal.equals(unknownFields(), codType.unknownFields()) && Internal.equals(this.status, codType.status) && Internal.equals(this.field, codType.field) && Internal.equals(this.block, codType.block) && Internal.equals(this.status_str, codType.status_str);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.status;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.field;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.block;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.status_str;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.status != null) {
            sb.append(", status=");
            sb.append(this.status);
        }
        if (this.field != null) {
            sb.append(", field=");
            sb.append(this.field);
        }
        if (this.block != null) {
            sb.append(", block=");
            sb.append(this.block);
        }
        if (this.status_str != null) {
            sb.append(", status_str=");
            sb.append(this.status_str);
        }
        StringBuilder replace = sb.replace(0, 2, "CodType{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CodType, Builder> {
        public String block;
        public String field;
        public Integer status;
        public String status_str;

        public final Builder status(Integer num) {
            this.status = num;
            return this;
        }

        public final Builder field(String str) {
            this.field = str;
            return this;
        }

        public final Builder block(String str) {
            this.block = str;
            return this;
        }

        public final Builder status_str(String str) {
            this.status_str = str;
            return this;
        }

        public final CodType build() {
            return new CodType(this.status, this.field, this.block, this.status_str, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CodType extends ProtoAdapter<CodType> {
        ProtoAdapter_CodType() {
            super(FieldEncoding.LENGTH_DELIMITED, CodType.class);
        }

        public final int encodedSize(CodType codType) {
            int i = 0;
            int encodedSizeWithTag = (codType.status != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, codType.status) : 0) + (codType.field != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, codType.field) : 0) + (codType.block != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, codType.block) : 0);
            if (codType.status_str != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, codType.status_str);
            }
            return encodedSizeWithTag + i + codType.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CodType codType) throws IOException {
            if (codType.status != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, codType.status);
            }
            if (codType.field != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, codType.field);
            }
            if (codType.block != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, codType.block);
            }
            if (codType.status_str != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, codType.status_str);
            }
            protoWriter.writeBytes(codType.unknownFields());
        }

        public final CodType decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.status(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.field(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.block(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.status_str(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final CodType redact(CodType codType) {
            Builder newBuilder = codType.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
