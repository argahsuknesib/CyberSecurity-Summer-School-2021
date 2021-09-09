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
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class InsuranceData extends Message<InsuranceData, Builder> {
    public static final ProtoAdapter<InsuranceData> ADAPTER = new ProtoAdapter_InsuranceData();
    public static final Integer DEFAULT_NUM = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String goods_dealer;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String goods_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String img_insurance;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String itemId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String market_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer num;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String validperiod;

    public InsuranceData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, num2, str9, ByteString.O00000Oo);
    }

    public InsuranceData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Integer num2, String str9, ByteString byteString) {
        super(ADAPTER, byteString);
        this.price = str;
        this.market_price = str2;
        this.goods_id = str3;
        this.image_url = str4;
        this.itemId = str5;
        this.validperiod = str6;
        this.img_insurance = str7;
        this.goods_dealer = str8;
        this.num = num2;
        this.product_name = str9;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.price = this.price;
        builder.market_price = this.market_price;
        builder.goods_id = this.goods_id;
        builder.image_url = this.image_url;
        builder.itemId = this.itemId;
        builder.validperiod = this.validperiod;
        builder.img_insurance = this.img_insurance;
        builder.goods_dealer = this.goods_dealer;
        builder.num = this.num;
        builder.product_name = this.product_name;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InsuranceData)) {
            return false;
        }
        InsuranceData insuranceData = (InsuranceData) obj;
        return Internal.equals(unknownFields(), insuranceData.unknownFields()) && Internal.equals(this.price, insuranceData.price) && Internal.equals(this.market_price, insuranceData.market_price) && Internal.equals(this.goods_id, insuranceData.goods_id) && Internal.equals(this.image_url, insuranceData.image_url) && Internal.equals(this.itemId, insuranceData.itemId) && Internal.equals(this.validperiod, insuranceData.validperiod) && Internal.equals(this.img_insurance, insuranceData.img_insurance) && Internal.equals(this.goods_dealer, insuranceData.goods_dealer) && Internal.equals(this.num, insuranceData.num) && Internal.equals(this.product_name, insuranceData.product_name);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.price;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.market_price;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.goods_id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.image_url;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.itemId;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.validperiod;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.img_insurance;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.goods_dealer;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Integer num2 = this.num;
        int hashCode10 = (hashCode9 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str9 = this.product_name;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.price != null) {
            sb.append(", price=");
            sb.append(this.price);
        }
        if (this.market_price != null) {
            sb.append(", market_price=");
            sb.append(this.market_price);
        }
        if (this.goods_id != null) {
            sb.append(", goods_id=");
            sb.append(this.goods_id);
        }
        if (this.image_url != null) {
            sb.append(", image_url=");
            sb.append(this.image_url);
        }
        if (this.itemId != null) {
            sb.append(", itemId=");
            sb.append(this.itemId);
        }
        if (this.validperiod != null) {
            sb.append(", validperiod=");
            sb.append(this.validperiod);
        }
        if (this.img_insurance != null) {
            sb.append(", img_insurance=");
            sb.append(this.img_insurance);
        }
        if (this.goods_dealer != null) {
            sb.append(", goods_dealer=");
            sb.append(this.goods_dealer);
        }
        if (this.num != null) {
            sb.append(", num=");
            sb.append(this.num);
        }
        if (this.product_name != null) {
            sb.append(", product_name=");
            sb.append(this.product_name);
        }
        StringBuilder replace = sb.replace(0, 2, "InsuranceData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<InsuranceData, Builder> {
        public String goods_dealer;
        public String goods_id;
        public String image_url;
        public String img_insurance;
        public String itemId;
        public String market_price;
        public Integer num;
        public String price;
        public String product_name;
        public String validperiod;

        public final Builder price(String str) {
            this.price = str;
            return this;
        }

        public final Builder market_price(String str) {
            this.market_price = str;
            return this;
        }

        public final Builder goods_id(String str) {
            this.goods_id = str;
            return this;
        }

        public final Builder image_url(String str) {
            this.image_url = str;
            return this;
        }

        public final Builder itemId(String str) {
            this.itemId = str;
            return this;
        }

        public final Builder validperiod(String str) {
            this.validperiod = str;
            return this;
        }

        public final Builder img_insurance(String str) {
            this.img_insurance = str;
            return this;
        }

        public final Builder goods_dealer(String str) {
            this.goods_dealer = str;
            return this;
        }

        public final Builder num(Integer num2) {
            this.num = num2;
            return this;
        }

        public final Builder product_name(String str) {
            this.product_name = str;
            return this;
        }

        public final InsuranceData build() {
            return new InsuranceData(this.price, this.market_price, this.goods_id, this.image_url, this.itemId, this.validperiod, this.img_insurance, this.goods_dealer, this.num, this.product_name, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_InsuranceData extends ProtoAdapter<InsuranceData> {
        ProtoAdapter_InsuranceData() {
            super(FieldEncoding.LENGTH_DELIMITED, InsuranceData.class);
        }

        public final int encodedSize(InsuranceData insuranceData) {
            int i = 0;
            int encodedSizeWithTag = (insuranceData.price != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, insuranceData.price) : 0) + (insuranceData.market_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, insuranceData.market_price) : 0) + (insuranceData.goods_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, insuranceData.goods_id) : 0) + (insuranceData.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, insuranceData.image_url) : 0) + (insuranceData.itemId != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, insuranceData.itemId) : 0) + (insuranceData.validperiod != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, insuranceData.validperiod) : 0) + (insuranceData.img_insurance != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, insuranceData.img_insurance) : 0) + (insuranceData.goods_dealer != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, insuranceData.goods_dealer) : 0) + (insuranceData.num != null ? ProtoAdapter.INT32.encodedSizeWithTag(13, insuranceData.num) : 0);
            if (insuranceData.product_name != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(14, insuranceData.product_name);
            }
            return encodedSizeWithTag + i + insuranceData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, InsuranceData insuranceData) throws IOException {
            if (insuranceData.price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, insuranceData.price);
            }
            if (insuranceData.market_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, insuranceData.market_price);
            }
            if (insuranceData.goods_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, insuranceData.goods_id);
            }
            if (insuranceData.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, insuranceData.image_url);
            }
            if (insuranceData.itemId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, insuranceData.itemId);
            }
            if (insuranceData.validperiod != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, insuranceData.validperiod);
            }
            if (insuranceData.img_insurance != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, insuranceData.img_insurance);
            }
            if (insuranceData.goods_dealer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, insuranceData.goods_dealer);
            }
            if (insuranceData.num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 13, insuranceData.num);
            }
            if (insuranceData.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, insuranceData.product_name);
            }
            protoWriter.writeBytes(insuranceData.unknownFields());
        }

        public final InsuranceData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 3:
                            builder.price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.market_price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                        case 6:
                            builder.goods_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.itemId(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.validperiod(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.img_insurance(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.goods_dealer(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.num(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 14:
                            builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final InsuranceData redact(InsuranceData insuranceData) {
            Builder newBuilder = insuranceData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
