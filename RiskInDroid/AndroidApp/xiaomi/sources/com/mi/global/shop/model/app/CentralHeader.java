package com.mi.global.shop.model.app;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class CentralHeader extends Message<CentralHeader, Builder> {
    public static final ProtoAdapter<CentralHeader> ADAPTER = new ProtoAdapter_CentralHeader();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String userCentralHeaderBg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String userCentralHeaderTitleColor;

    public CentralHeader(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public CentralHeader(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.userCentralHeaderBg = str;
        this.userCentralHeaderTitleColor = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.userCentralHeaderBg = this.userCentralHeaderBg;
        builder.userCentralHeaderTitleColor = this.userCentralHeaderTitleColor;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CentralHeader)) {
            return false;
        }
        CentralHeader centralHeader = (CentralHeader) obj;
        return Internal.equals(unknownFields(), centralHeader.unknownFields()) && Internal.equals(this.userCentralHeaderBg, centralHeader.userCentralHeaderBg) && Internal.equals(this.userCentralHeaderTitleColor, centralHeader.userCentralHeaderTitleColor);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.userCentralHeaderBg;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.userCentralHeaderTitleColor;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.userCentralHeaderBg != null) {
            sb.append(", userCentralHeaderBg=");
            sb.append(this.userCentralHeaderBg);
        }
        if (this.userCentralHeaderTitleColor != null) {
            sb.append(", userCentralHeaderTitleColor=");
            sb.append(this.userCentralHeaderTitleColor);
        }
        StringBuilder replace = sb.replace(0, 2, "CentralHeader{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CentralHeader, Builder> {
        public String userCentralHeaderBg;
        public String userCentralHeaderTitleColor;

        public final Builder userCentralHeaderBg(String str) {
            this.userCentralHeaderBg = str;
            return this;
        }

        public final Builder userCentralHeaderTitleColor(String str) {
            this.userCentralHeaderTitleColor = str;
            return this;
        }

        public final CentralHeader build() {
            return new CentralHeader(this.userCentralHeaderBg, this.userCentralHeaderTitleColor, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CentralHeader extends ProtoAdapter<CentralHeader> {
        ProtoAdapter_CentralHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, CentralHeader.class);
        }

        public final int encodedSize(CentralHeader centralHeader) {
            int i = 0;
            int encodedSizeWithTag = centralHeader.userCentralHeaderBg != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, centralHeader.userCentralHeaderBg) : 0;
            if (centralHeader.userCentralHeaderTitleColor != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, centralHeader.userCentralHeaderTitleColor);
            }
            return encodedSizeWithTag + i + centralHeader.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CentralHeader centralHeader) throws IOException {
            if (centralHeader.userCentralHeaderBg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, centralHeader.userCentralHeaderBg);
            }
            if (centralHeader.userCentralHeaderTitleColor != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, centralHeader.userCentralHeaderTitleColor);
            }
            protoWriter.writeBytes(centralHeader.unknownFields());
        }

        public final CentralHeader decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.userCentralHeaderBg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.userCentralHeaderTitleColor(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final CentralHeader redact(CentralHeader centralHeader) {
            Builder newBuilder = centralHeader.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
