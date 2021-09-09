package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class PayWalletData extends Message<PayWalletData, Builder> {
    public static final ProtoAdapter<PayWalletData> ADAPTER = new ProtoAdapter_PayWalletData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String amount;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String checksum_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String merchant_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String mid;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String order_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String payment_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String pg_response_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String response_code;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String response_message;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String sign;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String total_fee;

    public PayWalletData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, ByteString.O00000Oo);
    }

    public PayWalletData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, ByteString byteString) {
        super(ADAPTER, byteString);
        this.order_id = str;
        this.amount = str2;
        this.total_fee = str3;
        this.payment_type = str4;
        this.mid = str5;
        this.checksum_url = str6;
        this.pg_response_url = str7;
        this.response_code = str8;
        this.response_message = str9;
        this.sign = str10;
        this.merchant_name = str11;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.amount = this.amount;
        builder.total_fee = this.total_fee;
        builder.payment_type = this.payment_type;
        builder.mid = this.mid;
        builder.checksum_url = this.checksum_url;
        builder.pg_response_url = this.pg_response_url;
        builder.response_code = this.response_code;
        builder.response_message = this.response_message;
        builder.sign = this.sign;
        builder.merchant_name = this.merchant_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayWalletData)) {
            return false;
        }
        PayWalletData payWalletData = (PayWalletData) obj;
        return Internal.equals(unknownFields(), payWalletData.unknownFields()) && Internal.equals(this.order_id, payWalletData.order_id) && Internal.equals(this.amount, payWalletData.amount) && Internal.equals(this.total_fee, payWalletData.total_fee) && Internal.equals(this.payment_type, payWalletData.payment_type) && Internal.equals(this.mid, payWalletData.mid) && Internal.equals(this.checksum_url, payWalletData.checksum_url) && Internal.equals(this.pg_response_url, payWalletData.pg_response_url) && Internal.equals(this.response_code, payWalletData.response_code) && Internal.equals(this.response_message, payWalletData.response_message) && Internal.equals(this.sign, payWalletData.sign) && Internal.equals(this.merchant_name, payWalletData.merchant_name);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.order_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.amount;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.total_fee;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.payment_type;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.mid;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.checksum_url;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.pg_response_url;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.response_code;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.response_message;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.sign;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.merchant_name;
        if (str11 != null) {
            i2 = str11.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.amount != null) {
            sb.append(", amount=");
            sb.append(this.amount);
        }
        if (this.total_fee != null) {
            sb.append(", total_fee=");
            sb.append(this.total_fee);
        }
        if (this.payment_type != null) {
            sb.append(", payment_type=");
            sb.append(this.payment_type);
        }
        if (this.mid != null) {
            sb.append(", mid=");
            sb.append(this.mid);
        }
        if (this.checksum_url != null) {
            sb.append(", checksum_url=");
            sb.append(this.checksum_url);
        }
        if (this.pg_response_url != null) {
            sb.append(", pg_response_url=");
            sb.append(this.pg_response_url);
        }
        if (this.response_code != null) {
            sb.append(", response_code=");
            sb.append(this.response_code);
        }
        if (this.response_message != null) {
            sb.append(", response_message=");
            sb.append(this.response_message);
        }
        if (this.sign != null) {
            sb.append(", sign=");
            sb.append(this.sign);
        }
        if (this.merchant_name != null) {
            sb.append(", merchant_name=");
            sb.append(this.merchant_name);
        }
        StringBuilder replace = sb.replace(0, 2, "PayWalletData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PayWalletData, Builder> {
        public String amount;
        public String checksum_url;
        public String merchant_name;
        public String mid;
        public String order_id;
        public String payment_type;
        public String pg_response_url;
        public String response_code;
        public String response_message;
        public String sign;
        public String total_fee;

        public final Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public final Builder amount(String str) {
            this.amount = str;
            return this;
        }

        public final Builder total_fee(String str) {
            this.total_fee = str;
            return this;
        }

        public final Builder payment_type(String str) {
            this.payment_type = str;
            return this;
        }

        public final Builder mid(String str) {
            this.mid = str;
            return this;
        }

        public final Builder checksum_url(String str) {
            this.checksum_url = str;
            return this;
        }

        public final Builder pg_response_url(String str) {
            this.pg_response_url = str;
            return this;
        }

        public final Builder response_code(String str) {
            this.response_code = str;
            return this;
        }

        public final Builder response_message(String str) {
            this.response_message = str;
            return this;
        }

        public final Builder sign(String str) {
            this.sign = str;
            return this;
        }

        public final Builder merchant_name(String str) {
            this.merchant_name = str;
            return this;
        }

        public final PayWalletData build() {
            return new PayWalletData(this.order_id, this.amount, this.total_fee, this.payment_type, this.mid, this.checksum_url, this.pg_response_url, this.response_code, this.response_message, this.sign, this.merchant_name, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PayWalletData extends ProtoAdapter<PayWalletData> {
        ProtoAdapter_PayWalletData() {
            super(FieldEncoding.LENGTH_DELIMITED, PayWalletData.class);
        }

        public final int encodedSize(PayWalletData payWalletData) {
            int i = 0;
            int encodedSizeWithTag = (payWalletData.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, payWalletData.order_id) : 0) + (payWalletData.amount != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, payWalletData.amount) : 0) + (payWalletData.total_fee != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, payWalletData.total_fee) : 0) + (payWalletData.payment_type != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, payWalletData.payment_type) : 0) + (payWalletData.mid != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, payWalletData.mid) : 0) + (payWalletData.checksum_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, payWalletData.checksum_url) : 0) + (payWalletData.pg_response_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, payWalletData.pg_response_url) : 0) + (payWalletData.response_code != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, payWalletData.response_code) : 0) + (payWalletData.response_message != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, payWalletData.response_message) : 0) + (payWalletData.sign != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, payWalletData.sign) : 0);
            if (payWalletData.merchant_name != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(11, payWalletData.merchant_name);
            }
            return encodedSizeWithTag + i + payWalletData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PayWalletData payWalletData) throws IOException {
            if (payWalletData.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, payWalletData.order_id);
            }
            if (payWalletData.amount != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, payWalletData.amount);
            }
            if (payWalletData.total_fee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, payWalletData.total_fee);
            }
            if (payWalletData.payment_type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, payWalletData.payment_type);
            }
            if (payWalletData.mid != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, payWalletData.mid);
            }
            if (payWalletData.checksum_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, payWalletData.checksum_url);
            }
            if (payWalletData.pg_response_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, payWalletData.pg_response_url);
            }
            if (payWalletData.response_code != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, payWalletData.response_code);
            }
            if (payWalletData.response_message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, payWalletData.response_message);
            }
            if (payWalletData.sign != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, payWalletData.sign);
            }
            if (payWalletData.merchant_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, payWalletData.merchant_name);
            }
            protoWriter.writeBytes(payWalletData.unknownFields());
        }

        public final PayWalletData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.order_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.amount(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.total_fee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.payment_type(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.mid(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.checksum_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.pg_response_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.response_code(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.response_message(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.sign(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.merchant_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final PayWalletData redact(PayWalletData payWalletData) {
            Builder newBuilder = payWalletData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
