package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class ExtentionsData extends Message<ExtentionsData, Builder> {
    public static final ProtoAdapter<ExtentionsData> ADAPTER = new ProtoAdapter_ExtentionsData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 1)
    public final List<String> adapt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String adapt_desc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String bigtap_switch;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String cartTTL;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String crowdfunding_endtime;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String dealer;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String goods_dealer;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String goods_limit_buy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String has_battery;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String is_alone_buy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String is_checkout_bargain;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String is_promotion;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String orderTTL;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String push_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String self_get;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String url_product;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String url_specific;

    public ExtentionsData(List<String> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16) {
        this(list, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, ByteString.O00000Oo);
    }

    public ExtentionsData(List<String> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, ByteString byteString) {
        super(ADAPTER, byteString);
        this.adapt = Internal.immutableCopyOf("adapt", list);
        this.self_get = str;
        this.orderTTL = str2;
        this.is_checkout_bargain = str3;
        this.goods_limit_buy = str4;
        this.has_battery = str5;
        this.bigtap_switch = str6;
        this.cartTTL = str7;
        this.is_alone_buy = str8;
        this.url_specific = str9;
        this.url_product = str10;
        this.push_time = str11;
        this.adapt_desc = str12;
        this.is_promotion = str13;
        this.goods_dealer = str14;
        this.crowdfunding_endtime = str15;
        this.dealer = str16;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.adapt = Internal.copyOf("adapt", this.adapt);
        builder.self_get = this.self_get;
        builder.orderTTL = this.orderTTL;
        builder.is_checkout_bargain = this.is_checkout_bargain;
        builder.goods_limit_buy = this.goods_limit_buy;
        builder.has_battery = this.has_battery;
        builder.bigtap_switch = this.bigtap_switch;
        builder.cartTTL = this.cartTTL;
        builder.is_alone_buy = this.is_alone_buy;
        builder.url_specific = this.url_specific;
        builder.url_product = this.url_product;
        builder.push_time = this.push_time;
        builder.adapt_desc = this.adapt_desc;
        builder.is_promotion = this.is_promotion;
        builder.goods_dealer = this.goods_dealer;
        builder.crowdfunding_endtime = this.crowdfunding_endtime;
        builder.dealer = this.dealer;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExtentionsData)) {
            return false;
        }
        ExtentionsData extentionsData = (ExtentionsData) obj;
        return Internal.equals(unknownFields(), extentionsData.unknownFields()) && Internal.equals(this.adapt, extentionsData.adapt) && Internal.equals(this.self_get, extentionsData.self_get) && Internal.equals(this.orderTTL, extentionsData.orderTTL) && Internal.equals(this.is_checkout_bargain, extentionsData.is_checkout_bargain) && Internal.equals(this.goods_limit_buy, extentionsData.goods_limit_buy) && Internal.equals(this.has_battery, extentionsData.has_battery) && Internal.equals(this.bigtap_switch, extentionsData.bigtap_switch) && Internal.equals(this.cartTTL, extentionsData.cartTTL) && Internal.equals(this.is_alone_buy, extentionsData.is_alone_buy) && Internal.equals(this.url_specific, extentionsData.url_specific) && Internal.equals(this.url_product, extentionsData.url_product) && Internal.equals(this.push_time, extentionsData.push_time) && Internal.equals(this.adapt_desc, extentionsData.adapt_desc) && Internal.equals(this.is_promotion, extentionsData.is_promotion) && Internal.equals(this.goods_dealer, extentionsData.goods_dealer) && Internal.equals(this.crowdfunding_endtime, extentionsData.crowdfunding_endtime) && Internal.equals(this.dealer, extentionsData.dealer);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<String> list = this.adapt;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.self_get;
        int i2 = 0;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.orderTTL;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.is_checkout_bargain;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.goods_limit_buy;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.has_battery;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.bigtap_switch;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.cartTTL;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.is_alone_buy;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.url_specific;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.url_product;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.push_time;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.adapt_desc;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.is_promotion;
        int hashCode15 = (hashCode14 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.goods_dealer;
        int hashCode16 = (hashCode15 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.crowdfunding_endtime;
        int hashCode17 = (hashCode16 + (str15 != null ? str15.hashCode() : 0)) * 37;
        String str16 = this.dealer;
        if (str16 != null) {
            i2 = str16.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.adapt != null) {
            sb.append(", adapt=");
            sb.append(this.adapt);
        }
        if (this.self_get != null) {
            sb.append(", self_get=");
            sb.append(this.self_get);
        }
        if (this.orderTTL != null) {
            sb.append(", orderTTL=");
            sb.append(this.orderTTL);
        }
        if (this.is_checkout_bargain != null) {
            sb.append(", is_checkout_bargain=");
            sb.append(this.is_checkout_bargain);
        }
        if (this.goods_limit_buy != null) {
            sb.append(", goods_limit_buy=");
            sb.append(this.goods_limit_buy);
        }
        if (this.has_battery != null) {
            sb.append(", has_battery=");
            sb.append(this.has_battery);
        }
        if (this.bigtap_switch != null) {
            sb.append(", bigtap_switch=");
            sb.append(this.bigtap_switch);
        }
        if (this.cartTTL != null) {
            sb.append(", cartTTL=");
            sb.append(this.cartTTL);
        }
        if (this.is_alone_buy != null) {
            sb.append(", is_alone_buy=");
            sb.append(this.is_alone_buy);
        }
        if (this.url_specific != null) {
            sb.append(", url_specific=");
            sb.append(this.url_specific);
        }
        if (this.url_product != null) {
            sb.append(", url_product=");
            sb.append(this.url_product);
        }
        if (this.push_time != null) {
            sb.append(", push_time=");
            sb.append(this.push_time);
        }
        if (this.adapt_desc != null) {
            sb.append(", adapt_desc=");
            sb.append(this.adapt_desc);
        }
        if (this.is_promotion != null) {
            sb.append(", is_promotion=");
            sb.append(this.is_promotion);
        }
        if (this.goods_dealer != null) {
            sb.append(", goods_dealer=");
            sb.append(this.goods_dealer);
        }
        if (this.crowdfunding_endtime != null) {
            sb.append(", crowdfunding_endtime=");
            sb.append(this.crowdfunding_endtime);
        }
        if (this.dealer != null) {
            sb.append(", dealer=");
            sb.append(this.dealer);
        }
        StringBuilder replace = sb.replace(0, 2, "ExtentionsData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ExtentionsData, Builder> {
        public List<String> adapt = Internal.newMutableList();
        public String adapt_desc;
        public String bigtap_switch;
        public String cartTTL;
        public String crowdfunding_endtime;
        public String dealer;
        public String goods_dealer;
        public String goods_limit_buy;
        public String has_battery;
        public String is_alone_buy;
        public String is_checkout_bargain;
        public String is_promotion;
        public String orderTTL;
        public String push_time;
        public String self_get;
        public String url_product;
        public String url_specific;

        public final Builder adapt(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.adapt = list;
            return this;
        }

        public final Builder self_get(String str) {
            this.self_get = str;
            return this;
        }

        public final Builder orderTTL(String str) {
            this.orderTTL = str;
            return this;
        }

        public final Builder is_checkout_bargain(String str) {
            this.is_checkout_bargain = str;
            return this;
        }

        public final Builder goods_limit_buy(String str) {
            this.goods_limit_buy = str;
            return this;
        }

        public final Builder has_battery(String str) {
            this.has_battery = str;
            return this;
        }

        public final Builder bigtap_switch(String str) {
            this.bigtap_switch = str;
            return this;
        }

        public final Builder cartTTL(String str) {
            this.cartTTL = str;
            return this;
        }

        public final Builder is_alone_buy(String str) {
            this.is_alone_buy = str;
            return this;
        }

        public final Builder url_specific(String str) {
            this.url_specific = str;
            return this;
        }

        public final Builder url_product(String str) {
            this.url_product = str;
            return this;
        }

        public final Builder push_time(String str) {
            this.push_time = str;
            return this;
        }

        public final Builder adapt_desc(String str) {
            this.adapt_desc = str;
            return this;
        }

        public final Builder is_promotion(String str) {
            this.is_promotion = str;
            return this;
        }

        public final Builder goods_dealer(String str) {
            this.goods_dealer = str;
            return this;
        }

        public final Builder crowdfunding_endtime(String str) {
            this.crowdfunding_endtime = str;
            return this;
        }

        public final Builder dealer(String str) {
            this.dealer = str;
            return this;
        }

        public final ExtentionsData build() {
            return new ExtentionsData(this.adapt, this.self_get, this.orderTTL, this.is_checkout_bargain, this.goods_limit_buy, this.has_battery, this.bigtap_switch, this.cartTTL, this.is_alone_buy, this.url_specific, this.url_product, this.push_time, this.adapt_desc, this.is_promotion, this.goods_dealer, this.crowdfunding_endtime, this.dealer, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ExtentionsData extends ProtoAdapter<ExtentionsData> {
        ProtoAdapter_ExtentionsData() {
            super(FieldEncoding.LENGTH_DELIMITED, ExtentionsData.class);
        }

        public final int encodedSize(ExtentionsData extentionsData) {
            int i = 0;
            int encodedSizeWithTag = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, extentionsData.adapt) + (extentionsData.self_get != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, extentionsData.self_get) : 0) + (extentionsData.orderTTL != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, extentionsData.orderTTL) : 0) + (extentionsData.is_checkout_bargain != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, extentionsData.is_checkout_bargain) : 0) + (extentionsData.goods_limit_buy != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, extentionsData.goods_limit_buy) : 0) + (extentionsData.has_battery != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, extentionsData.has_battery) : 0) + (extentionsData.bigtap_switch != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, extentionsData.bigtap_switch) : 0) + (extentionsData.cartTTL != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, extentionsData.cartTTL) : 0) + (extentionsData.is_alone_buy != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, extentionsData.is_alone_buy) : 0) + (extentionsData.url_specific != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, extentionsData.url_specific) : 0) + (extentionsData.url_product != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, extentionsData.url_product) : 0) + (extentionsData.push_time != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, extentionsData.push_time) : 0) + (extentionsData.adapt_desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, extentionsData.adapt_desc) : 0) + (extentionsData.is_promotion != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, extentionsData.is_promotion) : 0) + (extentionsData.goods_dealer != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, extentionsData.goods_dealer) : 0) + (extentionsData.crowdfunding_endtime != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, extentionsData.crowdfunding_endtime) : 0);
            if (extentionsData.dealer != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(17, extentionsData.dealer);
            }
            return encodedSizeWithTag + i + extentionsData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ExtentionsData extentionsData) throws IOException {
            if (extentionsData.adapt != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 1, extentionsData.adapt);
            }
            if (extentionsData.self_get != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, extentionsData.self_get);
            }
            if (extentionsData.orderTTL != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, extentionsData.orderTTL);
            }
            if (extentionsData.is_checkout_bargain != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, extentionsData.is_checkout_bargain);
            }
            if (extentionsData.goods_limit_buy != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, extentionsData.goods_limit_buy);
            }
            if (extentionsData.has_battery != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, extentionsData.has_battery);
            }
            if (extentionsData.bigtap_switch != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, extentionsData.bigtap_switch);
            }
            if (extentionsData.cartTTL != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, extentionsData.cartTTL);
            }
            if (extentionsData.is_alone_buy != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, extentionsData.is_alone_buy);
            }
            if (extentionsData.url_specific != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, extentionsData.url_specific);
            }
            if (extentionsData.url_product != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, extentionsData.url_product);
            }
            if (extentionsData.push_time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, extentionsData.push_time);
            }
            if (extentionsData.adapt_desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, extentionsData.adapt_desc);
            }
            if (extentionsData.is_promotion != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, extentionsData.is_promotion);
            }
            if (extentionsData.goods_dealer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, extentionsData.goods_dealer);
            }
            if (extentionsData.crowdfunding_endtime != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, extentionsData.crowdfunding_endtime);
            }
            if (extentionsData.dealer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, extentionsData.dealer);
            }
            protoWriter.writeBytes(extentionsData.unknownFields());
        }

        public final ExtentionsData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.adapt.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.self_get(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.orderTTL(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.is_checkout_bargain(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.goods_limit_buy(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.has_battery(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.bigtap_switch(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.cartTTL(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.is_alone_buy(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.url_specific(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.url_product(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.push_time(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.adapt_desc(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.is_promotion(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.goods_dealer(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.crowdfunding_endtime(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.dealer(ProtoAdapter.STRING.decode(protoReader));
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

        public final ExtentionsData redact(ExtentionsData extentionsData) {
            Builder newBuilder = extentionsData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
