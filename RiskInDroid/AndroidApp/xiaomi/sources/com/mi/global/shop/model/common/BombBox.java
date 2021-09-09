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

public final class BombBox extends Message<BombBox, Builder> {
    public static final ProtoAdapter<BombBox> ADAPTER = new ProtoAdapter_BombBox();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String url;

    public BombBox(String str) {
        this(str, ByteString.O00000Oo);
    }

    public BombBox(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.url = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.url = this.url;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BombBox)) {
            return false;
        }
        BombBox bombBox = (BombBox) obj;
        return Internal.equals(unknownFields(), bombBox.unknownFields()) && Internal.equals(this.url, bombBox.url);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.url;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        StringBuilder replace = sb.replace(0, 2, "BombBox{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<BombBox, Builder> {
        public String url;

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final BombBox build() {
            return new BombBox(this.url, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_BombBox extends ProtoAdapter<BombBox> {
        ProtoAdapter_BombBox() {
            super(FieldEncoding.LENGTH_DELIMITED, BombBox.class);
        }

        public final int encodedSize(BombBox bombBox) {
            return (bombBox.url != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, bombBox.url) : 0) + bombBox.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, BombBox bombBox) throws IOException {
            if (bombBox.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, bombBox.url);
            }
            protoWriter.writeBytes(bombBox.unknownFields());
        }

        public final BombBox decode(ProtoReader protoReader) throws IOException {
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
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final BombBox redact(BombBox bombBox) {
            Builder newBuilder = bombBox.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
