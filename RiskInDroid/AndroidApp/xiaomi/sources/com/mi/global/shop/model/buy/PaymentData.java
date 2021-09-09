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

public final class PaymentData extends Message<PaymentData, Builder> {
    public static final ProtoAdapter<PaymentData> ADAPTER = new ProtoAdapter_PaymentData();
    public static final Boolean DEFAULT_CHECKED = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String brief;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean checked;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String pay_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String tpis;

    public PaymentData(String str, String str2, Boolean bool, String str3) {
        this(str, str2, bool, str3, ByteString.O00000Oo);
    }

    public PaymentData(String str, String str2, Boolean bool, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.brief = str;
        this.pay_id = str2;
        this.checked = bool;
        this.tpis = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.brief = this.brief;
        builder.pay_id = this.pay_id;
        builder.checked = this.checked;
        builder.tpis = this.tpis;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaymentData)) {
            return false;
        }
        PaymentData paymentData = (PaymentData) obj;
        return Internal.equals(unknownFields(), paymentData.unknownFields()) && Internal.equals(this.brief, paymentData.brief) && Internal.equals(this.pay_id, paymentData.pay_id) && Internal.equals(this.checked, paymentData.checked) && Internal.equals(this.tpis, paymentData.tpis);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.brief;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.pay_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.checked;
        int hashCode4 = (hashCode3 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str3 = this.tpis;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.brief != null) {
            sb.append(", brief=");
            sb.append(this.brief);
        }
        if (this.pay_id != null) {
            sb.append(", pay_id=");
            sb.append(this.pay_id);
        }
        if (this.checked != null) {
            sb.append(", checked=");
            sb.append(this.checked);
        }
        if (this.tpis != null) {
            sb.append(", tpis=");
            sb.append(this.tpis);
        }
        StringBuilder replace = sb.replace(0, 2, "PaymentData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaymentData, Builder> {
        public String brief;
        public Boolean checked;
        public String pay_id;
        public String tpis;

        public final Builder brief(String str) {
            this.brief = str;
            return this;
        }

        public final Builder pay_id(String str) {
            this.pay_id = str;
            return this;
        }

        public final Builder checked(Boolean bool) {
            this.checked = bool;
            return this;
        }

        public final Builder tpis(String str) {
            this.tpis = str;
            return this;
        }

        public final PaymentData build() {
            return new PaymentData(this.brief, this.pay_id, this.checked, this.tpis, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PaymentData extends ProtoAdapter<PaymentData> {
        ProtoAdapter_PaymentData() {
            super(FieldEncoding.LENGTH_DELIMITED, PaymentData.class);
        }

        public final int encodedSize(PaymentData paymentData) {
            int i = 0;
            int encodedSizeWithTag = (paymentData.brief != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, paymentData.brief) : 0) + (paymentData.pay_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, paymentData.pay_id) : 0) + (paymentData.checked != null ? ProtoAdapter.BOOL.encodedSizeWithTag(3, paymentData.checked) : 0);
            if (paymentData.tpis != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, paymentData.tpis);
            }
            return encodedSizeWithTag + i + paymentData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PaymentData paymentData) throws IOException {
            if (paymentData.brief != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, paymentData.brief);
            }
            if (paymentData.pay_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, paymentData.pay_id);
            }
            if (paymentData.checked != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, paymentData.checked);
            }
            if (paymentData.tpis != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, paymentData.tpis);
            }
            protoWriter.writeBytes(paymentData.unknownFields());
        }

        public final PaymentData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.brief(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.pay_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.checked(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.tpis(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PaymentData redact(PaymentData paymentData) {
            Builder newBuilder = paymentData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
