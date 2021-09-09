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

public final class Share extends Message<Share, Builder> {
    public static final ProtoAdapter<Share> ADAPTER = new ProtoAdapter_Share();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String text;

    public Share(String str) {
        this(str, ByteString.O00000Oo);
    }

    public Share(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.text = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.text = this.text;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Share)) {
            return false;
        }
        Share share = (Share) obj;
        return Internal.equals(unknownFields(), share.unknownFields()) && Internal.equals(this.text, share.text);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.text;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.text != null) {
            sb.append(", text=");
            sb.append(this.text);
        }
        StringBuilder replace = sb.replace(0, 2, "Share{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Share, Builder> {
        public String text;

        public final Builder text(String str) {
            this.text = str;
            return this;
        }

        public final Share build() {
            return new Share(this.text, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Share extends ProtoAdapter<Share> {
        ProtoAdapter_Share() {
            super(FieldEncoding.LENGTH_DELIMITED, Share.class);
        }

        public final int encodedSize(Share share) {
            return (share.text != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, share.text) : 0) + share.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Share share) throws IOException {
            if (share.text != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, share.text);
            }
            protoWriter.writeBytes(share.unknownFields());
        }

        public final Share decode(ProtoReader protoReader) throws IOException {
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
                    builder.text(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final Share redact(Share share) {
            Builder newBuilder = share.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
