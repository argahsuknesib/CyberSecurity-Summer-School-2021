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

public final class AddrIndia extends Message<AddrIndia, Builder> {
    public static final ProtoAdapter<AddrIndia> ADAPTER = new ProtoAdapter_AddrIndia();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String addr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String city;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String landmark;

    public AddrIndia(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.O00000Oo);
    }

    public AddrIndia(String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.addr = str;
        this.landmark = str2;
        this.city = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.addr = this.addr;
        builder.landmark = this.landmark;
        builder.city = this.city;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AddrIndia)) {
            return false;
        }
        AddrIndia addrIndia = (AddrIndia) obj;
        return Internal.equals(unknownFields(), addrIndia.unknownFields()) && Internal.equals(this.addr, addrIndia.addr) && Internal.equals(this.landmark, addrIndia.landmark) && Internal.equals(this.city, addrIndia.city);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.addr;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.landmark;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.city;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.addr != null) {
            sb.append(", addr=");
            sb.append(this.addr);
        }
        if (this.landmark != null) {
            sb.append(", landmark=");
            sb.append(this.landmark);
        }
        if (this.city != null) {
            sb.append(", city=");
            sb.append(this.city);
        }
        StringBuilder replace = sb.replace(0, 2, "AddrIndia{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddrIndia, Builder> {
        public String addr;
        public String city;
        public String landmark;

        public final Builder addr(String str) {
            this.addr = str;
            return this;
        }

        public final Builder landmark(String str) {
            this.landmark = str;
            return this;
        }

        public final Builder city(String str) {
            this.city = str;
            return this;
        }

        public final AddrIndia build() {
            return new AddrIndia(this.addr, this.landmark, this.city, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddrIndia extends ProtoAdapter<AddrIndia> {
        ProtoAdapter_AddrIndia() {
            super(FieldEncoding.LENGTH_DELIMITED, AddrIndia.class);
        }

        public final int encodedSize(AddrIndia addrIndia) {
            int i = 0;
            int encodedSizeWithTag = (addrIndia.addr != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, addrIndia.addr) : 0) + (addrIndia.landmark != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, addrIndia.landmark) : 0);
            if (addrIndia.city != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, addrIndia.city);
            }
            return encodedSizeWithTag + i + addrIndia.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddrIndia addrIndia) throws IOException {
            if (addrIndia.addr != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, addrIndia.addr);
            }
            if (addrIndia.landmark != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addrIndia.landmark);
            }
            if (addrIndia.city != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, addrIndia.city);
            }
            protoWriter.writeBytes(addrIndia.unknownFields());
        }

        public final AddrIndia decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.addr(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.landmark(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.city(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final AddrIndia redact(AddrIndia addrIndia) {
            Builder newBuilder = addrIndia.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
