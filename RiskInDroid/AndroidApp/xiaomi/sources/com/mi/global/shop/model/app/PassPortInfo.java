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

public final class PassPortInfo extends Message<PassPortInfo, Builder> {
    public static final ProtoAdapter<PassPortInfo> ADAPTER = new ProtoAdapter_PassPortInfo();
    public static final Boolean DEFAULT_TOKENINVALID = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errInfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean tokenInvalid;

    public PassPortInfo(Boolean bool, String str) {
        this(bool, str, ByteString.O00000Oo);
    }

    public PassPortInfo(Boolean bool, String str, ByteString byteString) {
        super(ADAPTER, byteString);
        this.tokenInvalid = bool;
        this.errInfo = str;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.tokenInvalid = this.tokenInvalid;
        builder.errInfo = this.errInfo;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PassPortInfo)) {
            return false;
        }
        PassPortInfo passPortInfo = (PassPortInfo) obj;
        return Internal.equals(unknownFields(), passPortInfo.unknownFields()) && Internal.equals(this.tokenInvalid, passPortInfo.tokenInvalid) && Internal.equals(this.errInfo, passPortInfo.errInfo);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.tokenInvalid;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.errInfo;
        if (str != null) {
            i2 = str.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.tokenInvalid != null) {
            sb.append(", tokenInvalid=");
            sb.append(this.tokenInvalid);
        }
        if (this.errInfo != null) {
            sb.append(", errInfo=");
            sb.append(this.errInfo);
        }
        StringBuilder replace = sb.replace(0, 2, "PassPortInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PassPortInfo, Builder> {
        public String errInfo;
        public Boolean tokenInvalid;

        public final Builder tokenInvalid(Boolean bool) {
            this.tokenInvalid = bool;
            return this;
        }

        public final Builder errInfo(String str) {
            this.errInfo = str;
            return this;
        }

        public final PassPortInfo build() {
            return new PassPortInfo(this.tokenInvalid, this.errInfo, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PassPortInfo extends ProtoAdapter<PassPortInfo> {
        ProtoAdapter_PassPortInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PassPortInfo.class);
        }

        public final int encodedSize(PassPortInfo passPortInfo) {
            int i = 0;
            int encodedSizeWithTag = passPortInfo.tokenInvalid != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, passPortInfo.tokenInvalid) : 0;
            if (passPortInfo.errInfo != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, passPortInfo.errInfo);
            }
            return encodedSizeWithTag + i + passPortInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PassPortInfo passPortInfo) throws IOException {
            if (passPortInfo.tokenInvalid != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, passPortInfo.tokenInvalid);
            }
            if (passPortInfo.errInfo != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, passPortInfo.errInfo);
            }
            protoWriter.writeBytes(passPortInfo.unknownFields());
        }

        public final PassPortInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.tokenInvalid(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.errInfo(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PassPortInfo redact(PassPortInfo passPortInfo) {
            Builder newBuilder = passPortInfo.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
