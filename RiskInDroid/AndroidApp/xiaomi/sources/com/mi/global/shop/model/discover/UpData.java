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

public final class UpData extends Message<UpData, Builder> {
    public static final ProtoAdapter<UpData> ADAPTER = new ProtoAdapter_UpData();
    public static final Long DEFAULT_NUM = 0L;
    public static final Boolean DEFAULT_RES = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long num;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean res;

    public UpData(Boolean bool, Long l) {
        this(bool, l, ByteString.O00000Oo);
    }

    public UpData(Boolean bool, Long l, ByteString byteString) {
        super(ADAPTER, byteString);
        this.res = bool;
        this.num = l;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.res = this.res;
        builder.num = this.num;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UpData)) {
            return false;
        }
        UpData upData = (UpData) obj;
        return Internal.equals(unknownFields(), upData.unknownFields()) && Internal.equals(this.res, upData.res) && Internal.equals(this.num, upData.num);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.res;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        Long l = this.num;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.res != null) {
            sb.append(", res=");
            sb.append(this.res);
        }
        if (this.num != null) {
            sb.append(", num=");
            sb.append(this.num);
        }
        StringBuilder replace = sb.replace(0, 2, "UpData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<UpData, Builder> {
        public Long num;
        public Boolean res;

        public final Builder res(Boolean bool) {
            this.res = bool;
            return this;
        }

        public final Builder num(Long l) {
            this.num = l;
            return this;
        }

        public final UpData build() {
            return new UpData(this.res, this.num, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_UpData extends ProtoAdapter<UpData> {
        ProtoAdapter_UpData() {
            super(FieldEncoding.LENGTH_DELIMITED, UpData.class);
        }

        public final int encodedSize(UpData upData) {
            int i = 0;
            int encodedSizeWithTag = upData.res != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, upData.res) : 0;
            if (upData.num != null) {
                i = ProtoAdapter.INT64.encodedSizeWithTag(2, upData.num);
            }
            return encodedSizeWithTag + i + upData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, UpData upData) throws IOException {
            if (upData.res != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, upData.res);
            }
            if (upData.num != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 2, upData.num);
            }
            protoWriter.writeBytes(upData.unknownFields());
        }

        public final UpData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.res(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.num(ProtoAdapter.INT64.decode(protoReader));
                }
            }
        }

        public final UpData redact(UpData upData) {
            Builder newBuilder = upData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
