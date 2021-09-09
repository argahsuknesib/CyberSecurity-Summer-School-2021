package com.mi.global.shop.model.buy;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class PayWalletBody extends Message<PayWalletBody, Builder> {
    public static final ProtoAdapter<PayWalletBody> ADAPTER = new ProtoAdapter_PayWalletBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.buy.PayWalletData#ADAPTER", tag = 3)
    public final PayWalletData Data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String Errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer Errno;

    public PayWalletBody(Integer num, String str, PayWalletData payWalletData) {
        this(num, str, payWalletData, ByteString.O00000Oo);
    }

    public PayWalletBody(Integer num, String str, PayWalletData payWalletData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.Errno = num;
        this.Errmsg = str;
        this.Data = payWalletData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.Errno = this.Errno;
        builder.Errmsg = this.Errmsg;
        builder.Data = this.Data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayWalletBody)) {
            return false;
        }
        PayWalletBody payWalletBody = (PayWalletBody) obj;
        return Internal.equals(unknownFields(), payWalletBody.unknownFields()) && Internal.equals(this.Errno, payWalletBody.Errno) && Internal.equals(this.Errmsg, payWalletBody.Errmsg) && Internal.equals(this.Data, payWalletBody.Data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.Errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.Errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        PayWalletData payWalletData = this.Data;
        if (payWalletData != null) {
            i2 = payWalletData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.Errno != null) {
            sb.append(", Errno=");
            sb.append(this.Errno);
        }
        if (this.Errmsg != null) {
            sb.append(", Errmsg=");
            sb.append(this.Errmsg);
        }
        if (this.Data != null) {
            sb.append(", Data=");
            sb.append(this.Data);
        }
        StringBuilder replace = sb.replace(0, 2, "PayWalletBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PayWalletBody, Builder> {
        public PayWalletData Data;
        public String Errmsg;
        public Integer Errno;

        public final Builder Errno(Integer num) {
            this.Errno = num;
            return this;
        }

        public final Builder Errmsg(String str) {
            this.Errmsg = str;
            return this;
        }

        public final Builder Data(PayWalletData payWalletData) {
            this.Data = payWalletData;
            return this;
        }

        public final PayWalletBody build() {
            return new PayWalletBody(this.Errno, this.Errmsg, this.Data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PayWalletBody extends ProtoAdapter<PayWalletBody> {
        ProtoAdapter_PayWalletBody() {
            super(FieldEncoding.LENGTH_DELIMITED, PayWalletBody.class);
        }

        public final int encodedSize(PayWalletBody payWalletBody) {
            int i = 0;
            int encodedSizeWithTag = (payWalletBody.Errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, payWalletBody.Errno) : 0) + (payWalletBody.Errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, payWalletBody.Errmsg) : 0);
            if (payWalletBody.Data != null) {
                i = PayWalletData.ADAPTER.encodedSizeWithTag(3, payWalletBody.Data);
            }
            return encodedSizeWithTag + i + payWalletBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PayWalletBody payWalletBody) throws IOException {
            if (payWalletBody.Errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, payWalletBody.Errno);
            }
            if (payWalletBody.Errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, payWalletBody.Errmsg);
            }
            if (payWalletBody.Data != null) {
                PayWalletData.ADAPTER.encodeWithTag(protoWriter, 3, payWalletBody.Data);
            }
            protoWriter.writeBytes(payWalletBody.unknownFields());
        }

        public final PayWalletBody decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.Errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.Errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.Data(PayWalletData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final PayWalletBody redact(PayWalletBody payWalletBody) {
            Builder newBuilder = payWalletBody.newBuilder();
            if (newBuilder.Data != null) {
                newBuilder.Data = PayWalletData.ADAPTER.redact(newBuilder.Data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
