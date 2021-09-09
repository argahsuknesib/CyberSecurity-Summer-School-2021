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

public final class ExpressInfo extends Message<ExpressInfo, Builder> {
    public static final ProtoAdapter<ExpressInfo> ADAPTER = new ProtoAdapter_ExpressInfo();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.ExpressInfoData#ADAPTER", tag = 5)
    public final ExpressInfoData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public ExpressInfo(Integer num, String str, ExpressInfoData expressInfoData) {
        this(num, str, expressInfoData, ByteString.O00000Oo);
    }

    public ExpressInfo(Integer num, String str, ExpressInfoData expressInfoData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = expressInfoData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExpressInfo)) {
            return false;
        }
        ExpressInfo expressInfo = (ExpressInfo) obj;
        return Internal.equals(unknownFields(), expressInfo.unknownFields()) && Internal.equals(this.errno, expressInfo.errno) && Internal.equals(this.errmsg, expressInfo.errmsg) && Internal.equals(this.data, expressInfo.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        ExpressInfoData expressInfoData = this.data;
        if (expressInfoData != null) {
            i2 = expressInfoData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "ExpressInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ExpressInfo, Builder> {
        public ExpressInfoData data;
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(ExpressInfoData expressInfoData) {
            this.data = expressInfoData;
            return this;
        }

        public final ExpressInfo build() {
            return new ExpressInfo(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ExpressInfo extends ProtoAdapter<ExpressInfo> {
        ProtoAdapter_ExpressInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, ExpressInfo.class);
        }

        public final int encodedSize(ExpressInfo expressInfo) {
            int i = 0;
            int encodedSizeWithTag = (expressInfo.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, expressInfo.errno) : 0) + (expressInfo.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, expressInfo.errmsg) : 0);
            if (expressInfo.data != null) {
                i = ExpressInfoData.ADAPTER.encodedSizeWithTag(5, expressInfo.data);
            }
            return encodedSizeWithTag + i + expressInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ExpressInfo expressInfo) throws IOException {
            if (expressInfo.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, expressInfo.errno);
            }
            if (expressInfo.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, expressInfo.errmsg);
            }
            if (expressInfo.data != null) {
                ExpressInfoData.ADAPTER.encodeWithTag(protoWriter, 5, expressInfo.data);
            }
            protoWriter.writeBytes(expressInfo.unknownFields());
        }

        public final ExpressInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(ExpressInfoData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final ExpressInfo redact(ExpressInfo expressInfo) {
            Builder newBuilder = expressInfo.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = ExpressInfoData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
