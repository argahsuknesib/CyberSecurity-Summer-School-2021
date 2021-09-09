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

public final class PayInfo extends Message<PayInfo, Builder> {
    public static final ProtoAdapter<PayInfo> ADAPTER = new ProtoAdapter_PayInfo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.common.PayList#ADAPTER", tag = 1)
    public final PayList payList;
    @WireField(adapter = "com.mi.global.shop.model.common.PayParam#ADAPTER", tag = 2)
    public final PayParam payParam;

    public PayInfo(PayList payList2, PayParam payParam2) {
        this(payList2, payParam2, ByteString.O00000Oo);
    }

    public PayInfo(PayList payList2, PayParam payParam2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.payList = payList2;
        this.payParam = payParam2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.payList = this.payList;
        builder.payParam = this.payParam;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayInfo)) {
            return false;
        }
        PayInfo payInfo = (PayInfo) obj;
        return Internal.equals(unknownFields(), payInfo.unknownFields()) && Internal.equals(this.payList, payInfo.payList) && Internal.equals(this.payParam, payInfo.payParam);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        PayList payList2 = this.payList;
        int i2 = 0;
        int hashCode2 = (hashCode + (payList2 != null ? payList2.hashCode() : 0)) * 37;
        PayParam payParam2 = this.payParam;
        if (payParam2 != null) {
            i2 = payParam2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.payList != null) {
            sb.append(", payList=");
            sb.append(this.payList);
        }
        if (this.payParam != null) {
            sb.append(", payParam=");
            sb.append(this.payParam);
        }
        StringBuilder replace = sb.replace(0, 2, "PayInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PayInfo, Builder> {
        public PayList payList;
        public PayParam payParam;

        public final Builder payList(PayList payList2) {
            this.payList = payList2;
            return this;
        }

        public final Builder payParam(PayParam payParam2) {
            this.payParam = payParam2;
            return this;
        }

        public final PayInfo build() {
            return new PayInfo(this.payList, this.payParam, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PayInfo extends ProtoAdapter<PayInfo> {
        ProtoAdapter_PayInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, PayInfo.class);
        }

        public final int encodedSize(PayInfo payInfo) {
            int i = 0;
            int encodedSizeWithTag = payInfo.payList != null ? PayList.ADAPTER.encodedSizeWithTag(1, payInfo.payList) : 0;
            if (payInfo.payParam != null) {
                i = PayParam.ADAPTER.encodedSizeWithTag(2, payInfo.payParam);
            }
            return encodedSizeWithTag + i + payInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PayInfo payInfo) throws IOException {
            if (payInfo.payList != null) {
                PayList.ADAPTER.encodeWithTag(protoWriter, 1, payInfo.payList);
            }
            if (payInfo.payParam != null) {
                PayParam.ADAPTER.encodeWithTag(protoWriter, 2, payInfo.payParam);
            }
            protoWriter.writeBytes(payInfo.unknownFields());
        }

        public final PayInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.payList(PayList.ADAPTER.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.payParam(PayParam.ADAPTER.decode(protoReader));
                }
            }
        }

        public final PayInfo redact(PayInfo payInfo) {
            Builder newBuilder = payInfo.newBuilder();
            if (newBuilder.payList != null) {
                newBuilder.payList = PayList.ADAPTER.redact(newBuilder.payList);
            }
            if (newBuilder.payParam != null) {
                newBuilder.payParam = PayParam.ADAPTER.redact(newBuilder.payParam);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
