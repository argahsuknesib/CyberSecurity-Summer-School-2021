package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.model.basestruct.PageMessage;
import com.mi.global.shop.model.common.RegionData;
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

public final class CheckoutData extends Message<CheckoutData, Builder> {
    public static final ProtoAdapter<CheckoutData> ADAPTER = new ProtoAdapter_CheckoutData();
    public static final Integer DEFAULT_COUPONSCOUNT = 0;
    public static final Boolean DEFAULT_NEEDGOBACK = Boolean.FALSE;
    public static final Boolean DEFAULT_NEEDVCODE = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String address_list;
    @WireField(adapter = "com.mi.global.shop.model.buy.CartInfoData#ADAPTER", tag = 14)
    public final CartInfoData cart_info;
    @WireField(adapter = "com.mi.global.shop.model.buy.CheckoutInfoData#ADAPTER", tag = 1)
    public final CheckoutInfoData checkoutInfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String coupon_list;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer couponsCount;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String currency;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean needGoBack;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean needVcode;
    @WireField(adapter = "com.mi.global.shop.model.basestruct.PageMessage#ADAPTER", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final PageMessage pagemsg;
    @WireField(adapter = "com.mi.global.shop.model.common.RegionData#ADAPTER", label = WireField.Label.REPEATED, tag = 9)
    public final List<RegionData> region;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String shipment_expense;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String shipment_expense_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String totalpay;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String totalpay_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String userInfoUrl;

    public CheckoutData(CheckoutInfoData checkoutInfoData, String str, String str2, String str3, String str4, String str5, Integer num, String str6, List<RegionData> list, String str7, Boolean bool, String str8, Boolean bool2, CartInfoData cartInfoData, PageMessage pageMessage) {
        this(checkoutInfoData, str, str2, str3, str4, str5, num, str6, list, str7, bool, str8, bool2, cartInfoData, pageMessage, ByteString.O00000Oo);
    }

    public CheckoutData(CheckoutInfoData checkoutInfoData, String str, String str2, String str3, String str4, String str5, Integer num, String str6, List<RegionData> list, String str7, Boolean bool, String str8, Boolean bool2, CartInfoData cartInfoData, PageMessage pageMessage, ByteString byteString) {
        super(ADAPTER, byteString);
        this.checkoutInfo = checkoutInfoData;
        this.totalpay = str;
        this.totalpay_txt = str2;
        this.shipment_expense = str3;
        this.shipment_expense_txt = str4;
        this.coupon_list = str5;
        this.couponsCount = num;
        this.userInfoUrl = str6;
        this.region = Internal.immutableCopyOf("region", list);
        this.currency = str7;
        this.needVcode = bool;
        this.address_list = str8;
        this.needGoBack = bool2;
        this.cart_info = cartInfoData;
        this.pagemsg = pageMessage;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.checkoutInfo = this.checkoutInfo;
        builder.totalpay = this.totalpay;
        builder.totalpay_txt = this.totalpay_txt;
        builder.shipment_expense = this.shipment_expense;
        builder.shipment_expense_txt = this.shipment_expense_txt;
        builder.coupon_list = this.coupon_list;
        builder.couponsCount = this.couponsCount;
        builder.userInfoUrl = this.userInfoUrl;
        builder.region = Internal.copyOf("region", this.region);
        builder.currency = this.currency;
        builder.needVcode = this.needVcode;
        builder.address_list = this.address_list;
        builder.needGoBack = this.needGoBack;
        builder.cart_info = this.cart_info;
        builder.pagemsg = this.pagemsg;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckoutData)) {
            return false;
        }
        CheckoutData checkoutData = (CheckoutData) obj;
        return Internal.equals(unknownFields(), checkoutData.unknownFields()) && Internal.equals(this.checkoutInfo, checkoutData.checkoutInfo) && Internal.equals(this.totalpay, checkoutData.totalpay) && Internal.equals(this.totalpay_txt, checkoutData.totalpay_txt) && Internal.equals(this.shipment_expense, checkoutData.shipment_expense) && Internal.equals(this.shipment_expense_txt, checkoutData.shipment_expense_txt) && Internal.equals(this.coupon_list, checkoutData.coupon_list) && Internal.equals(this.couponsCount, checkoutData.couponsCount) && Internal.equals(this.userInfoUrl, checkoutData.userInfoUrl) && Internal.equals(this.region, checkoutData.region) && Internal.equals(this.currency, checkoutData.currency) && Internal.equals(this.needVcode, checkoutData.needVcode) && Internal.equals(this.address_list, checkoutData.address_list) && Internal.equals(this.needGoBack, checkoutData.needGoBack) && Internal.equals(this.cart_info, checkoutData.cart_info) && Internal.equals(this.pagemsg, checkoutData.pagemsg);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        CheckoutInfoData checkoutInfoData = this.checkoutInfo;
        int i2 = 0;
        int hashCode2 = (hashCode + (checkoutInfoData != null ? checkoutInfoData.hashCode() : 0)) * 37;
        String str = this.totalpay;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.totalpay_txt;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.shipment_expense;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.shipment_expense_txt;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.coupon_list;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Integer num = this.couponsCount;
        int hashCode8 = (hashCode7 + (num != null ? num.hashCode() : 0)) * 37;
        String str6 = this.userInfoUrl;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<RegionData> list = this.region;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 1)) * 37;
        String str7 = this.currency;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Boolean bool = this.needVcode;
        int hashCode12 = (hashCode11 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str8 = this.address_list;
        int hashCode13 = (hashCode12 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool2 = this.needGoBack;
        int hashCode14 = (hashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        CartInfoData cartInfoData = this.cart_info;
        int hashCode15 = (hashCode14 + (cartInfoData != null ? cartInfoData.hashCode() : 0)) * 37;
        PageMessage pageMessage = this.pagemsg;
        if (pageMessage != null) {
            i2 = pageMessage.hashCode();
        }
        int i3 = hashCode15 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.checkoutInfo != null) {
            sb.append(", checkoutInfo=");
            sb.append(this.checkoutInfo);
        }
        if (this.totalpay != null) {
            sb.append(", totalpay=");
            sb.append(this.totalpay);
        }
        if (this.totalpay_txt != null) {
            sb.append(", totalpay_txt=");
            sb.append(this.totalpay_txt);
        }
        if (this.shipment_expense != null) {
            sb.append(", shipment_expense=");
            sb.append(this.shipment_expense);
        }
        if (this.shipment_expense_txt != null) {
            sb.append(", shipment_expense_txt=");
            sb.append(this.shipment_expense_txt);
        }
        if (this.coupon_list != null) {
            sb.append(", coupon_list=");
            sb.append(this.coupon_list);
        }
        if (this.couponsCount != null) {
            sb.append(", couponsCount=");
            sb.append(this.couponsCount);
        }
        if (this.userInfoUrl != null) {
            sb.append(", userInfoUrl=");
            sb.append(this.userInfoUrl);
        }
        if (this.region != null) {
            sb.append(", region=");
            sb.append(this.region);
        }
        if (this.currency != null) {
            sb.append(", currency=");
            sb.append(this.currency);
        }
        if (this.needVcode != null) {
            sb.append(", needVcode=");
            sb.append(this.needVcode);
        }
        if (this.address_list != null) {
            sb.append(", address_list=");
            sb.append(this.address_list);
        }
        if (this.needGoBack != null) {
            sb.append(", needGoBack=");
            sb.append(this.needGoBack);
        }
        if (this.cart_info != null) {
            sb.append(", cart_info=");
            sb.append(this.cart_info);
        }
        if (this.pagemsg != null) {
            sb.append(", pagemsg=");
            sb.append(this.pagemsg);
        }
        StringBuilder replace = sb.replace(0, 2, "CheckoutData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CheckoutData, Builder> {
        public String address_list;
        public CartInfoData cart_info;
        public CheckoutInfoData checkoutInfo;
        public String coupon_list;
        public Integer couponsCount;
        public String currency;
        public Boolean needGoBack;
        public Boolean needVcode;
        public PageMessage pagemsg;
        public List<RegionData> region = Internal.newMutableList();
        public String shipment_expense;
        public String shipment_expense_txt;
        public String totalpay;
        public String totalpay_txt;
        public String userInfoUrl;

        public final Builder checkoutInfo(CheckoutInfoData checkoutInfoData) {
            this.checkoutInfo = checkoutInfoData;
            return this;
        }

        public final Builder totalpay(String str) {
            this.totalpay = str;
            return this;
        }

        public final Builder totalpay_txt(String str) {
            this.totalpay_txt = str;
            return this;
        }

        public final Builder shipment_expense(String str) {
            this.shipment_expense = str;
            return this;
        }

        public final Builder shipment_expense_txt(String str) {
            this.shipment_expense_txt = str;
            return this;
        }

        public final Builder coupon_list(String str) {
            this.coupon_list = str;
            return this;
        }

        public final Builder couponsCount(Integer num) {
            this.couponsCount = num;
            return this;
        }

        public final Builder userInfoUrl(String str) {
            this.userInfoUrl = str;
            return this;
        }

        public final Builder region(List<RegionData> list) {
            Internal.checkElementsNotNull(list);
            this.region = list;
            return this;
        }

        public final Builder currency(String str) {
            this.currency = str;
            return this;
        }

        public final Builder needVcode(Boolean bool) {
            this.needVcode = bool;
            return this;
        }

        public final Builder address_list(String str) {
            this.address_list = str;
            return this;
        }

        public final Builder needGoBack(Boolean bool) {
            this.needGoBack = bool;
            return this;
        }

        public final Builder cart_info(CartInfoData cartInfoData) {
            this.cart_info = cartInfoData;
            return this;
        }

        public final Builder pagemsg(PageMessage pageMessage) {
            this.pagemsg = pageMessage;
            return this;
        }

        public final CheckoutData build() {
            return new CheckoutData(this.checkoutInfo, this.totalpay, this.totalpay_txt, this.shipment_expense, this.shipment_expense_txt, this.coupon_list, this.couponsCount, this.userInfoUrl, this.region, this.currency, this.needVcode, this.address_list, this.needGoBack, this.cart_info, this.pagemsg, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CheckoutData extends ProtoAdapter<CheckoutData> {
        ProtoAdapter_CheckoutData() {
            super(FieldEncoding.LENGTH_DELIMITED, CheckoutData.class);
        }

        public final int encodedSize(CheckoutData checkoutData) {
            int i = 0;
            int encodedSizeWithTag = (checkoutData.checkoutInfo != null ? CheckoutInfoData.ADAPTER.encodedSizeWithTag(1, checkoutData.checkoutInfo) : 0) + (checkoutData.totalpay != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, checkoutData.totalpay) : 0) + (checkoutData.totalpay_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, checkoutData.totalpay_txt) : 0) + (checkoutData.shipment_expense != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, checkoutData.shipment_expense) : 0) + (checkoutData.shipment_expense_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, checkoutData.shipment_expense_txt) : 0) + (checkoutData.coupon_list != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, checkoutData.coupon_list) : 0) + (checkoutData.couponsCount != null ? ProtoAdapter.INT32.encodedSizeWithTag(7, checkoutData.couponsCount) : 0) + (checkoutData.userInfoUrl != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, checkoutData.userInfoUrl) : 0) + RegionData.ADAPTER.asRepeated().encodedSizeWithTag(9, checkoutData.region) + (checkoutData.currency != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, checkoutData.currency) : 0) + (checkoutData.needVcode != null ? ProtoAdapter.BOOL.encodedSizeWithTag(11, checkoutData.needVcode) : 0) + (checkoutData.address_list != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, checkoutData.address_list) : 0) + (checkoutData.needGoBack != null ? ProtoAdapter.BOOL.encodedSizeWithTag(13, checkoutData.needGoBack) : 0) + (checkoutData.cart_info != null ? CartInfoData.ADAPTER.encodedSizeWithTag(14, checkoutData.cart_info) : 0);
            if (checkoutData.pagemsg != null) {
                i = PageMessage.ADAPTER.encodedSizeWithTag(15, checkoutData.pagemsg);
            }
            return encodedSizeWithTag + i + checkoutData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CheckoutData checkoutData) throws IOException {
            if (checkoutData.checkoutInfo != null) {
                CheckoutInfoData.ADAPTER.encodeWithTag(protoWriter, 1, checkoutData.checkoutInfo);
            }
            if (checkoutData.totalpay != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, checkoutData.totalpay);
            }
            if (checkoutData.totalpay_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, checkoutData.totalpay_txt);
            }
            if (checkoutData.shipment_expense != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, checkoutData.shipment_expense);
            }
            if (checkoutData.shipment_expense_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, checkoutData.shipment_expense_txt);
            }
            if (checkoutData.coupon_list != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, checkoutData.coupon_list);
            }
            if (checkoutData.couponsCount != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 7, checkoutData.couponsCount);
            }
            if (checkoutData.userInfoUrl != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, checkoutData.userInfoUrl);
            }
            if (checkoutData.region != null) {
                RegionData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 9, checkoutData.region);
            }
            if (checkoutData.currency != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, checkoutData.currency);
            }
            if (checkoutData.needVcode != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 11, checkoutData.needVcode);
            }
            if (checkoutData.address_list != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, checkoutData.address_list);
            }
            if (checkoutData.needGoBack != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 13, checkoutData.needGoBack);
            }
            if (checkoutData.cart_info != null) {
                CartInfoData.ADAPTER.encodeWithTag(protoWriter, 14, checkoutData.cart_info);
            }
            if (checkoutData.pagemsg != null) {
                PageMessage.ADAPTER.encodeWithTag(protoWriter, 15, checkoutData.pagemsg);
            }
            protoWriter.writeBytes(checkoutData.unknownFields());
        }

        public final CheckoutData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.checkoutInfo(CheckoutInfoData.ADAPTER.decode(protoReader));
                            break;
                        case 2:
                            builder.totalpay(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.totalpay_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.shipment_expense(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.shipment_expense_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.coupon_list(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.couponsCount(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.userInfoUrl(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.region.add(RegionData.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            builder.currency(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.needVcode(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.address_list(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 13:
                            builder.needGoBack(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 14:
                            builder.cart_info(CartInfoData.ADAPTER.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.pagemsg(PageMessage.ADAPTER.decode(protoReader));
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

        public final CheckoutData redact(CheckoutData checkoutData) {
            Builder newBuilder = checkoutData.newBuilder();
            if (newBuilder.checkoutInfo != null) {
                newBuilder.checkoutInfo = CheckoutInfoData.ADAPTER.redact(newBuilder.checkoutInfo);
            }
            Internal.redactElements(newBuilder.region, RegionData.ADAPTER);
            if (newBuilder.cart_info != null) {
                newBuilder.cart_info = CartInfoData.ADAPTER.redact(newBuilder.cart_info);
            }
            if (newBuilder.pagemsg != null) {
                newBuilder.pagemsg = PageMessage.ADAPTER.redact(newBuilder.pagemsg);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
