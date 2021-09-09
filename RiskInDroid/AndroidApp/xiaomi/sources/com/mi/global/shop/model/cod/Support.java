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

public final class Support extends Message<Support, Builder> {
    public static final ProtoAdapter<Support> ADAPTER = new ProtoAdapter_Support();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String codstatus;

    public Support(String str) {
        this(str, ByteString.O00000Oo);
    }

    public Support(String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.codstatus = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.codstatus = this.codstatus;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Support)) {
            return false;
        }
        Support support = (Support) obj;
        return Internal.equals(unknownFields(), support.unknownFields()) && Internal.equals(this.codstatus, support.codstatus);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.codstatus;
        int hashCode2 = hashCode + (str != null ? str.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.codstatus != null) {
            sb.append(", codstatus=");
            sb.append(this.codstatus);
        }
        StringBuilder replace = sb.replace(0, 2, "Support{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Support, Builder> {
        public String codstatus;

        public final Builder codstatus(String str) {
            this.codstatus = str;
            return this;
        }

        public final Support build() {
            return new Support(this.codstatus, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Support extends ProtoAdapter<Support> {
        ProtoAdapter_Support() {
            super(FieldEncoding.LENGTH_DELIMITED, Support.class);
        }

        public final int encodedSize(Support support) {
            return (support.codstatus != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, support.codstatus) : 0) + support.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Support support) throws IOException {
            if (support.codstatus != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, support.codstatus);
            }
            protoWriter.writeBytes(support.unknownFields());
        }

        public final Support decode(ProtoReader protoReader) throws IOException {
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
                    builder.codstatus(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final Support redact(Support support) {
            Builder newBuilder = support.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
