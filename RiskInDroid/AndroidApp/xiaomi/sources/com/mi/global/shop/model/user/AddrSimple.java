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

public final class AddrSimple extends Message<AddrSimple, Builder> {
    public static final ProtoAdapter<AddrSimple> ADAPTER = new ProtoAdapter_AddrSimple();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String name;

    public AddrSimple(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public AddrSimple(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = str;
        this.name = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.name = this.name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddrSimple)) {
            return false;
        }
        AddrSimple addrSimple = (AddrSimple) obj;
        return Internal.equals(unknownFields(), addrSimple.unknownFields()) && Internal.equals(this.id, addrSimple.id) && Internal.equals(this.name, addrSimple.name);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.name;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.name != null) {
            sb.append(", name=");
            sb.append(this.name);
        }
        StringBuilder replace = sb.replace(0, 2, "AddrSimple{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddrSimple, Builder> {
        public String id;
        public String name;

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder name(String str) {
            this.name = str;
            return this;
        }

        public final AddrSimple build() {
            return new AddrSimple(this.id, this.name, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddrSimple extends ProtoAdapter<AddrSimple> {
        ProtoAdapter_AddrSimple() {
            super(FieldEncoding.LENGTH_DELIMITED, AddrSimple.class);
        }

        public final int encodedSize(AddrSimple addrSimple) {
            int i = 0;
            int encodedSizeWithTag = addrSimple.id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, addrSimple.id) : 0;
            if (addrSimple.name != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, addrSimple.name);
            }
            return encodedSizeWithTag + i + addrSimple.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddrSimple addrSimple) throws IOException {
            if (addrSimple.id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, addrSimple.id);
            }
            if (addrSimple.name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addrSimple.name);
            }
            protoWriter.writeBytes(addrSimple.unknownFields());
        }

        public final AddrSimple decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.name(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final AddrSimple redact(AddrSimple addrSimple) {
            Builder newBuilder = addrSimple.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
