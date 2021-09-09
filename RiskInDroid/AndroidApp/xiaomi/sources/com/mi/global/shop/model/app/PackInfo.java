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

public final class PackInfo extends Message<PackInfo, Builder> {
    public static final ProtoAdapter<PackInfo> ADAPTER = new ProtoAdapter_PackInfo();
    public static final Integer DEFAULT_VERSION = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer version;

    public PackInfo(Integer num, String str) {
        this(num, str, ByteString.O00000Oo);
    }

    public PackInfo(Integer num, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.version = num;
        this.url = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.version = this.version;
        builder.url = this.url;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PackInfo)) {
            return false;
        }
        PackInfo packInfo = (PackInfo) obj;
        return Internal.equals(unknownFields(), packInfo.unknownFields()) && Internal.equals(this.version, packInfo.version) && Internal.equals(this.url, packInfo.url);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.version;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.url;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.version != null) {
            sb.append(", version=");
            sb.append(this.version);
        }
        if (this.url != null) {
            sb.append(", url=");
            sb.append(this.url);
        }
        StringBuilder replace = sb.replace(0, 2, "PackInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PackInfo, Builder> {
        public String url;
        public Integer version;

        public final Builder version(Integer num) {
            this.version = num;
            return this;
        }

        public final Builder url(String str) {
            this.url = str;
            return this;
        }

        public final PackInfo build() {
            return new PackInfo(this.version, this.url, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PackInfo extends ProtoAdapter<PackInfo> {
        ProtoAdapter_PackInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PackInfo.class);
        }

        public final int encodedSize(PackInfo packInfo) {
            int i = 0;
            int encodedSizeWithTag = packInfo.version != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, packInfo.version) : 0;
            if (packInfo.url != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, packInfo.url);
            }
            return encodedSizeWithTag + i + packInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PackInfo packInfo) throws IOException {
            if (packInfo.version != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, packInfo.version);
            }
            if (packInfo.url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, packInfo.url);
            }
            protoWriter.writeBytes(packInfo.unknownFields());
        }

        public final PackInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.version(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.url(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PackInfo redact(PackInfo packInfo) {
            Builder newBuilder = packInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
