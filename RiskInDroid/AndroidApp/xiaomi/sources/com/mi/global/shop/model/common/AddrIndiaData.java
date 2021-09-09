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

public final class AddrIndiaData extends Message<AddrIndiaData, Builder> {
    public static final ProtoAdapter<AddrIndiaData> ADAPTER = new ProtoAdapter_AddrIndiaData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String addr;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String city;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String landmark;

    public AddrIndiaData(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.O00000Oo);
    }

    public AddrIndiaData(String str, String str2, String str3, ByteString byteString) {
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
        if (!(obj instanceof AddrIndiaData)) {
            return false;
        }
        AddrIndiaData addrIndiaData = (AddrIndiaData) obj;
        return Internal.equals(unknownFields(), addrIndiaData.unknownFields()) && Internal.equals(this.addr, addrIndiaData.addr) && Internal.equals(this.landmark, addrIndiaData.landmark) && Internal.equals(this.city, addrIndiaData.city);
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
        StringBuilder replace = sb.replace(0, 2, "AddrIndiaData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AddrIndiaData, Builder> {
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

        public final AddrIndiaData build() {
            return new AddrIndiaData(this.addr, this.landmark, this.city, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AddrIndiaData extends ProtoAdapter<AddrIndiaData> {
        ProtoAdapter_AddrIndiaData() {
            super(FieldEncoding.LENGTH_DELIMITED, AddrIndiaData.class);
        }

        public final int encodedSize(AddrIndiaData addrIndiaData) {
            int i = 0;
            int encodedSizeWithTag = (addrIndiaData.addr != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, addrIndiaData.addr) : 0) + (addrIndiaData.landmark != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, addrIndiaData.landmark) : 0);
            if (addrIndiaData.city != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, addrIndiaData.city);
            }
            return encodedSizeWithTag + i + addrIndiaData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AddrIndiaData addrIndiaData) throws IOException {
            if (addrIndiaData.addr != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, addrIndiaData.addr);
            }
            if (addrIndiaData.landmark != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, addrIndiaData.landmark);
            }
            if (addrIndiaData.city != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, addrIndiaData.city);
            }
            protoWriter.writeBytes(addrIndiaData.unknownFields());
        }

        public final AddrIndiaData decode(ProtoReader protoReader) throws IOException {
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

        public final AddrIndiaData redact(AddrIndiaData addrIndiaData) {
            Builder newBuilder = addrIndiaData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
