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

public final class PayInfoBody extends Message<PayInfoBody, Builder> {
    public static final ProtoAdapter<PayInfoBody> ADAPTER = new ProtoAdapter_PayInfoBody();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.buy.PayInfoData#ADAPTER", tag = 3)
    public final PayInfoData Data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String Errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer Errno;

    public PayInfoBody(Integer num, String str, PayInfoData payInfoData) {
        this(num, str, payInfoData, ByteString.O00000Oo);
    }

    public PayInfoBody(Integer num, String str, PayInfoData payInfoData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.Errno = num;
        this.Errmsg = str;
        this.Data = payInfoData;
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
        if (!(obj instanceof PayInfoBody)) {
            return false;
        }
        PayInfoBody payInfoBody = (PayInfoBody) obj;
        return Internal.equals(unknownFields(), payInfoBody.unknownFields()) && Internal.equals(this.Errno, payInfoBody.Errno) && Internal.equals(this.Errmsg, payInfoBody.Errmsg) && Internal.equals(this.Data, payInfoBody.Data);
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
        PayInfoData payInfoData = this.Data;
        if (payInfoData != null) {
            i2 = payInfoData.hashCode();
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
        StringBuilder replace = sb.replace(0, 2, "PayInfoBody{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PayInfoBody, Builder> {
        public PayInfoData Data;
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

        public final Builder Data(PayInfoData payInfoData) {
            this.Data = payInfoData;
            return this;
        }

        public final PayInfoBody build() {
            return new PayInfoBody(this.Errno, this.Errmsg, this.Data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PayInfoBody extends ProtoAdapter<PayInfoBody> {
        ProtoAdapter_PayInfoBody() {
            super(FieldEncoding.LENGTH_DELIMITED, PayInfoBody.class);
        }

        public final int encodedSize(PayInfoBody payInfoBody) {
            int i = 0;
            int encodedSizeWithTag = (payInfoBody.Errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, payInfoBody.Errno) : 0) + (payInfoBody.Errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, payInfoBody.Errmsg) : 0);
            if (payInfoBody.Data != null) {
                i = PayInfoData.ADAPTER.encodedSizeWithTag(3, payInfoBody.Data);
            }
            return encodedSizeWithTag + i + payInfoBody.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PayInfoBody payInfoBody) throws IOException {
            if (payInfoBody.Errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, payInfoBody.Errno);
            }
            if (payInfoBody.Errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, payInfoBody.Errmsg);
            }
            if (payInfoBody.Data != null) {
                PayInfoData.ADAPTER.encodeWithTag(protoWriter, 3, payInfoBody.Data);
            }
            protoWriter.writeBytes(payInfoBody.unknownFields());
        }

        public final PayInfoBody decode(ProtoReader protoReader) throws IOException {
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
                    builder.Data(PayInfoData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final PayInfoBody redact(PayInfoBody payInfoBody) {
            Builder newBuilder = payInfoBody.newBuilder();
            if (newBuilder.Data != null) {
                newBuilder.Data = PayInfoData.ADAPTER.redact(newBuilder.Data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
