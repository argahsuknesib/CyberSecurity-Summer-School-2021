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

public final class Extentions extends Message<Extentions, Builder> {
    public static final ProtoAdapter<Extentions> ADAPTER = new ProtoAdapter_Extentions();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String goods_dealer;

    public Extentions(String str) {
        this(str, ByteString.O00000Oo);
    }

    public Extentions(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.goods_dealer = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.goods_dealer = this.goods_dealer;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Extentions)) {
            return false;
        }
        Extentions extentions = (Extentions) obj;
        return Internal.equals(unknownFields(), extentions.unknownFields()) && Internal.equals(this.goods_dealer, extentions.goods_dealer);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.goods_dealer;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.goods_dealer != null) {
            sb.append(", goods_dealer=");
            sb.append(this.goods_dealer);
        }
        StringBuilder replace = sb.replace(0, 2, "Extentions{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Extentions, Builder> {
        public String goods_dealer;

        public final Builder goods_dealer(String str) {
            this.goods_dealer = str;
            return this;
        }

        public final Extentions build() {
            return new Extentions(this.goods_dealer, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Extentions extends ProtoAdapter<Extentions> {
        ProtoAdapter_Extentions() {
            super(FieldEncoding.LENGTH_DELIMITED, Extentions.class);
        }

        public final int encodedSize(Extentions extentions) {
            return (extentions.goods_dealer != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, extentions.goods_dealer) : 0) + extentions.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Extentions extentions) throws IOException {
            if (extentions.goods_dealer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, extentions.goods_dealer);
            }
            protoWriter.writeBytes(extentions.unknownFields());
        }

        public final Extentions decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag != 1) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.goods_dealer(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final Extentions redact(Extentions extentions) {
            Builder newBuilder = extentions.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
