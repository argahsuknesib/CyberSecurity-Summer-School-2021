package com.mi.global.shop.model.user;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.mi.global.shop.model.common.ListProduct;
import com.mi.global.shop.model.common.OrderStatusInfo;
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

public final class OrderInfo extends Message<OrderInfo, Builder> {
    public static final ProtoAdapter<OrderInfo> ADAPTER = new ProtoAdapter_OrderInfo();
    public static final Boolean DEFAULT_ISGETSELF = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 24)
    public final String add_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 20)
    public final String add_time_fm;
    @WireField(adapter = "com.mi.global.shop.model.user.AddrIndia#ADAPTER", tag = 22)
    public final AddrIndia addr_india;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 16)
    public final String best_time;
    @WireField(adapter = "com.mi.global.shop.model.user.AddrSimple#ADAPTER", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final AddrSimple city;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String consignee;
    @WireField(adapter = "com.mi.global.shop.model.user.DeliverInfo#ADAPTER", tag = 21)
    public final DeliverInfo deliver_info;
    @WireField(adapter = "com.mi.global.shop.model.user.AddrSimple#ADAPTER", tag = 13)
    public final AddrSimple distinct;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String email;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String goods_amount_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String invoice_title;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String invoice_type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 26)
    public final Boolean isGetSelf;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String order_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 25)
    public final String order_status;
    @WireField(adapter = "com.mi.global.shop.model.common.OrderStatusInfo#ADAPTER", tag = 2)
    public final OrderStatusInfo order_status_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 23)
    public final String pay_id;
    @WireField(adapter = "com.mi.global.shop.model.common.ListProduct#ADAPTER", label = WireField.Label.REPEATED, tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final List<ListProduct> product;
    @WireField(adapter = "com.mi.global.shop.model.user.AddrSimple#ADAPTER", tag = 11)
    public final AddrSimple province;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String reduce_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String reduce_price_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String remaining_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String shipment_expense_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String tel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String ttl;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String zipcode;

    public OrderInfo(String str, OrderStatusInfo orderStatusInfo, String str2, String str3, String str4, String str5, String str6, List<ListProduct> list, String str7, String str8, AddrSimple addrSimple, AddrSimple addrSimple2, AddrSimple addrSimple3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, DeliverInfo deliverInfo, AddrIndia addrIndia, String str16, String str17, String str18, Boolean bool, String str19) {
        this(str, orderStatusInfo, str2, str3, str4, str5, str6, list, str7, str8, addrSimple, addrSimple2, addrSimple3, str9, str10, str11, str12, str13, str14, str15, deliverInfo, addrIndia, str16, str17, str18, bool, str19, ByteString.O00000Oo);
    }

    public OrderInfo(String str, OrderStatusInfo orderStatusInfo, String str2, String str3, String str4, String str5, String str6, List<ListProduct> list, String str7, String str8, AddrSimple addrSimple, AddrSimple addrSimple2, AddrSimple addrSimple3, String str9, String str10, String str11, String str12, String str13, String str14, String str15, DeliverInfo deliverInfo, AddrIndia addrIndia, String str16, String str17, String str18, Boolean bool, String str19, ByteString byteString) {
        super(ADAPTER, byteString);
        this.order_id = str;
        this.order_status_info = orderStatusInfo;
        this.reduce_price = str2;
        this.reduce_price_txt = str3;
        this.shipment_expense_txt = str4;
        this.goods_amount_txt = str5;
        this.ttl = str6;
        this.product = Internal.immutableCopyOf("product", list);
        this.consignee = str7;
        this.tel = str8;
        this.province = addrSimple;
        this.city = addrSimple2;
        this.distinct = addrSimple3;
        this.address = str9;
        this.zipcode = str10;
        this.best_time = str11;
        this.email = str12;
        this.invoice_type = str13;
        this.invoice_title = str14;
        this.add_time_fm = str15;
        this.deliver_info = deliverInfo;
        this.addr_india = addrIndia;
        this.pay_id = str16;
        this.add_time = str17;
        this.order_status = str18;
        this.isGetSelf = bool;
        this.remaining_time = str19;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.order_status_info = this.order_status_info;
        builder.reduce_price = this.reduce_price;
        builder.reduce_price_txt = this.reduce_price_txt;
        builder.shipment_expense_txt = this.shipment_expense_txt;
        builder.goods_amount_txt = this.goods_amount_txt;
        builder.ttl = this.ttl;
        builder.product = Internal.copyOf("product", this.product);
        builder.consignee = this.consignee;
        builder.tel = this.tel;
        builder.province = this.province;
        builder.city = this.city;
        builder.distinct = this.distinct;
        builder.address = this.address;
        builder.zipcode = this.zipcode;
        builder.best_time = this.best_time;
        builder.email = this.email;
        builder.invoice_type = this.invoice_type;
        builder.invoice_title = this.invoice_title;
        builder.add_time_fm = this.add_time_fm;
        builder.deliver_info = this.deliver_info;
        builder.addr_india = this.addr_india;
        builder.pay_id = this.pay_id;
        builder.add_time = this.add_time;
        builder.order_status = this.order_status;
        builder.isGetSelf = this.isGetSelf;
        builder.remaining_time = this.remaining_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderInfo)) {
            return false;
        }
        OrderInfo orderInfo = (OrderInfo) obj;
        return Internal.equals(unknownFields(), orderInfo.unknownFields()) && Internal.equals(this.order_id, orderInfo.order_id) && Internal.equals(this.order_status_info, orderInfo.order_status_info) && Internal.equals(this.reduce_price, orderInfo.reduce_price) && Internal.equals(this.reduce_price_txt, orderInfo.reduce_price_txt) && Internal.equals(this.shipment_expense_txt, orderInfo.shipment_expense_txt) && Internal.equals(this.goods_amount_txt, orderInfo.goods_amount_txt) && Internal.equals(this.ttl, orderInfo.ttl) && Internal.equals(this.product, orderInfo.product) && Internal.equals(this.consignee, orderInfo.consignee) && Internal.equals(this.tel, orderInfo.tel) && Internal.equals(this.province, orderInfo.province) && Internal.equals(this.city, orderInfo.city) && Internal.equals(this.distinct, orderInfo.distinct) && Internal.equals(this.address, orderInfo.address) && Internal.equals(this.zipcode, orderInfo.zipcode) && Internal.equals(this.best_time, orderInfo.best_time) && Internal.equals(this.email, orderInfo.email) && Internal.equals(this.invoice_type, orderInfo.invoice_type) && Internal.equals(this.invoice_title, orderInfo.invoice_title) && Internal.equals(this.add_time_fm, orderInfo.add_time_fm) && Internal.equals(this.deliver_info, orderInfo.deliver_info) && Internal.equals(this.addr_india, orderInfo.addr_india) && Internal.equals(this.pay_id, orderInfo.pay_id) && Internal.equals(this.add_time, orderInfo.add_time) && Internal.equals(this.order_status, orderInfo.order_status) && Internal.equals(this.isGetSelf, orderInfo.isGetSelf) && Internal.equals(this.remaining_time, orderInfo.remaining_time);
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
        OrderStatusInfo orderStatusInfo = this.order_status_info;
        int hashCode3 = (hashCode2 + (orderStatusInfo != null ? orderStatusInfo.hashCode() : 0)) * 37;
        String str2 = this.reduce_price;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.reduce_price_txt;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.shipment_expense_txt;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.goods_amount_txt;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.ttl;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<ListProduct> list = this.product;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        String str7 = this.consignee;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.tel;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        AddrSimple addrSimple = this.province;
        int hashCode12 = (hashCode11 + (addrSimple != null ? addrSimple.hashCode() : 0)) * 37;
        AddrSimple addrSimple2 = this.city;
        int hashCode13 = (hashCode12 + (addrSimple2 != null ? addrSimple2.hashCode() : 0)) * 37;
        AddrSimple addrSimple3 = this.distinct;
        int hashCode14 = (hashCode13 + (addrSimple3 != null ? addrSimple3.hashCode() : 0)) * 37;
        String str9 = this.address;
        int hashCode15 = (hashCode14 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.zipcode;
        int hashCode16 = (hashCode15 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.best_time;
        int hashCode17 = (hashCode16 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.email;
        int hashCode18 = (hashCode17 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.invoice_type;
        int hashCode19 = (hashCode18 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.invoice_title;
        int hashCode20 = (hashCode19 + (str14 != null ? str14.hashCode() : 0)) * 37;
        String str15 = this.add_time_fm;
        int hashCode21 = (hashCode20 + (str15 != null ? str15.hashCode() : 0)) * 37;
        DeliverInfo deliverInfo = this.deliver_info;
        int hashCode22 = (hashCode21 + (deliverInfo != null ? deliverInfo.hashCode() : 0)) * 37;
        AddrIndia addrIndia = this.addr_india;
        int hashCode23 = (hashCode22 + (addrIndia != null ? addrIndia.hashCode() : 0)) * 37;
        String str16 = this.pay_id;
        int hashCode24 = (hashCode23 + (str16 != null ? str16.hashCode() : 0)) * 37;
        String str17 = this.add_time;
        int hashCode25 = (hashCode24 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.order_status;
        int hashCode26 = (hashCode25 + (str18 != null ? str18.hashCode() : 0)) * 37;
        Boolean bool = this.isGetSelf;
        int hashCode27 = (hashCode26 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str19 = this.remaining_time;
        if (str19 != null) {
            i2 = str19.hashCode();
        }
        int i3 = hashCode27 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.order_status_info != null) {
            sb.append(", order_status_info=");
            sb.append(this.order_status_info);
        }
        if (this.reduce_price != null) {
            sb.append(", reduce_price=");
            sb.append(this.reduce_price);
        }
        if (this.reduce_price_txt != null) {
            sb.append(", reduce_price_txt=");
            sb.append(this.reduce_price_txt);
        }
        if (this.shipment_expense_txt != null) {
            sb.append(", shipment_expense_txt=");
            sb.append(this.shipment_expense_txt);
        }
        if (this.goods_amount_txt != null) {
            sb.append(", goods_amount_txt=");
            sb.append(this.goods_amount_txt);
        }
        if (this.ttl != null) {
            sb.append(", ttl=");
            sb.append(this.ttl);
        }
        if (this.product != null) {
            sb.append(", product=");
            sb.append(this.product);
        }
        if (this.consignee != null) {
            sb.append(", consignee=");
            sb.append(this.consignee);
        }
        if (this.tel != null) {
            sb.append(", tel=");
            sb.append(this.tel);
        }
        if (this.province != null) {
            sb.append(", province=");
            sb.append(this.province);
        }
        if (this.city != null) {
            sb.append(", city=");
            sb.append(this.city);
        }
        if (this.distinct != null) {
            sb.append(", distinct=");
            sb.append(this.distinct);
        }
        if (this.address != null) {
            sb.append(", address=");
            sb.append(this.address);
        }
        if (this.zipcode != null) {
            sb.append(", zipcode=");
            sb.append(this.zipcode);
        }
        if (this.best_time != null) {
            sb.append(", best_time=");
            sb.append(this.best_time);
        }
        if (this.email != null) {
            sb.append(", email=");
            sb.append(this.email);
        }
        if (this.invoice_type != null) {
            sb.append(", invoice_type=");
            sb.append(this.invoice_type);
        }
        if (this.invoice_title != null) {
            sb.append(", invoice_title=");
            sb.append(this.invoice_title);
        }
        if (this.add_time_fm != null) {
            sb.append(", add_time_fm=");
            sb.append(this.add_time_fm);
        }
        if (this.deliver_info != null) {
            sb.append(", deliver_info=");
            sb.append(this.deliver_info);
        }
        if (this.addr_india != null) {
            sb.append(", addr_india=");
            sb.append(this.addr_india);
        }
        if (this.pay_id != null) {
            sb.append(", pay_id=");
            sb.append(this.pay_id);
        }
        if (this.add_time != null) {
            sb.append(", add_time=");
            sb.append(this.add_time);
        }
        if (this.order_status != null) {
            sb.append(", order_status=");
            sb.append(this.order_status);
        }
        if (this.isGetSelf != null) {
            sb.append(", isGetSelf=");
            sb.append(this.isGetSelf);
        }
        if (this.remaining_time != null) {
            sb.append(", remaining_time=");
            sb.append(this.remaining_time);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderInfo, Builder> {
        public String add_time;
        public String add_time_fm;
        public AddrIndia addr_india;
        public String address;
        public String best_time;
        public AddrSimple city;
        public String consignee;
        public DeliverInfo deliver_info;
        public AddrSimple distinct;
        public String email;
        public String goods_amount_txt;
        public String invoice_title;
        public String invoice_type;
        public Boolean isGetSelf;
        public String order_id;
        public String order_status;
        public OrderStatusInfo order_status_info;
        public String pay_id;
        public List<ListProduct> product = Internal.newMutableList();
        public AddrSimple province;
        public String reduce_price;
        public String reduce_price_txt;
        public String remaining_time;
        public String shipment_expense_txt;
        public String tel;
        public String ttl;
        public String zipcode;

        public final Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public final Builder order_status_info(OrderStatusInfo orderStatusInfo) {
            this.order_status_info = orderStatusInfo;
            return this;
        }

        public final Builder reduce_price(String str) {
            this.reduce_price = str;
            return this;
        }

        public final Builder reduce_price_txt(String str) {
            this.reduce_price_txt = str;
            return this;
        }

        public final Builder shipment_expense_txt(String str) {
            this.shipment_expense_txt = str;
            return this;
        }

        public final Builder goods_amount_txt(String str) {
            this.goods_amount_txt = str;
            return this;
        }

        public final Builder ttl(String str) {
            this.ttl = str;
            return this;
        }

        public final Builder product(List<ListProduct> list) {
            Internal.checkElementsNotNull(list);
            this.product = list;
            return this;
        }

        public final Builder consignee(String str) {
            this.consignee = str;
            return this;
        }

        public final Builder tel(String str) {
            this.tel = str;
            return this;
        }

        public final Builder province(AddrSimple addrSimple) {
            this.province = addrSimple;
            return this;
        }

        public final Builder city(AddrSimple addrSimple) {
            this.city = addrSimple;
            return this;
        }

        public final Builder distinct(AddrSimple addrSimple) {
            this.distinct = addrSimple;
            return this;
        }

        public final Builder address(String str) {
            this.address = str;
            return this;
        }

        public final Builder zipcode(String str) {
            this.zipcode = str;
            return this;
        }

        public final Builder best_time(String str) {
            this.best_time = str;
            return this;
        }

        public final Builder email(String str) {
            this.email = str;
            return this;
        }

        public final Builder invoice_type(String str) {
            this.invoice_type = str;
            return this;
        }

        public final Builder invoice_title(String str) {
            this.invoice_title = str;
            return this;
        }

        public final Builder add_time_fm(String str) {
            this.add_time_fm = str;
            return this;
        }

        public final Builder deliver_info(DeliverInfo deliverInfo) {
            this.deliver_info = deliverInfo;
            return this;
        }

        public final Builder addr_india(AddrIndia addrIndia) {
            this.addr_india = addrIndia;
            return this;
        }

        public final Builder pay_id(String str) {
            this.pay_id = str;
            return this;
        }

        public final Builder add_time(String str) {
            this.add_time = str;
            return this;
        }

        public final Builder order_status(String str) {
            this.order_status = str;
            return this;
        }

        public final Builder isGetSelf(Boolean bool) {
            this.isGetSelf = bool;
            return this;
        }

        public final Builder remaining_time(String str) {
            this.remaining_time = str;
            return this;
        }

        public final OrderInfo build() {
            return new OrderInfo(this.order_id, this.order_status_info, this.reduce_price, this.reduce_price_txt, this.shipment_expense_txt, this.goods_amount_txt, this.ttl, this.product, this.consignee, this.tel, this.province, this.city, this.distinct, this.address, this.zipcode, this.best_time, this.email, this.invoice_type, this.invoice_title, this.add_time_fm, this.deliver_info, this.addr_india, this.pay_id, this.add_time, this.order_status, this.isGetSelf, this.remaining_time, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_OrderInfo extends ProtoAdapter<OrderInfo> {
        ProtoAdapter_OrderInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderInfo.class);
        }

        public final int encodedSize(OrderInfo orderInfo) {
            int i = 0;
            int encodedSizeWithTag = (orderInfo.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, orderInfo.order_id) : 0) + (orderInfo.order_status_info != null ? OrderStatusInfo.ADAPTER.encodedSizeWithTag(2, orderInfo.order_status_info) : 0) + (orderInfo.reduce_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, orderInfo.reduce_price) : 0) + (orderInfo.reduce_price_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderInfo.reduce_price_txt) : 0) + (orderInfo.shipment_expense_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, orderInfo.shipment_expense_txt) : 0) + (orderInfo.goods_amount_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, orderInfo.goods_amount_txt) : 0) + (orderInfo.ttl != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, orderInfo.ttl) : 0) + ListProduct.ADAPTER.asRepeated().encodedSizeWithTag(8, orderInfo.product) + (orderInfo.consignee != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, orderInfo.consignee) : 0) + (orderInfo.tel != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, orderInfo.tel) : 0) + (orderInfo.province != null ? AddrSimple.ADAPTER.encodedSizeWithTag(11, orderInfo.province) : 0) + (orderInfo.city != null ? AddrSimple.ADAPTER.encodedSizeWithTag(12, orderInfo.city) : 0) + (orderInfo.distinct != null ? AddrSimple.ADAPTER.encodedSizeWithTag(13, orderInfo.distinct) : 0) + (orderInfo.address != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, orderInfo.address) : 0) + (orderInfo.zipcode != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, orderInfo.zipcode) : 0) + (orderInfo.best_time != null ? ProtoAdapter.STRING.encodedSizeWithTag(16, orderInfo.best_time) : 0) + (orderInfo.email != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, orderInfo.email) : 0) + (orderInfo.invoice_type != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, orderInfo.invoice_type) : 0) + (orderInfo.invoice_title != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, orderInfo.invoice_title) : 0) + (orderInfo.add_time_fm != null ? ProtoAdapter.STRING.encodedSizeWithTag(20, orderInfo.add_time_fm) : 0) + (orderInfo.deliver_info != null ? DeliverInfo.ADAPTER.encodedSizeWithTag(21, orderInfo.deliver_info) : 0) + (orderInfo.addr_india != null ? AddrIndia.ADAPTER.encodedSizeWithTag(22, orderInfo.addr_india) : 0) + (orderInfo.pay_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(23, orderInfo.pay_id) : 0) + (orderInfo.add_time != null ? ProtoAdapter.STRING.encodedSizeWithTag(24, orderInfo.add_time) : 0) + (orderInfo.order_status != null ? ProtoAdapter.STRING.encodedSizeWithTag(25, orderInfo.order_status) : 0) + (orderInfo.isGetSelf != null ? ProtoAdapter.BOOL.encodedSizeWithTag(26, orderInfo.isGetSelf) : 0);
            if (orderInfo.remaining_time != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(27, orderInfo.remaining_time);
            }
            return encodedSizeWithTag + i + orderInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, OrderInfo orderInfo) throws IOException {
            if (orderInfo.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, orderInfo.order_id);
            }
            if (orderInfo.order_status_info != null) {
                OrderStatusInfo.ADAPTER.encodeWithTag(protoWriter, 2, orderInfo.order_status_info);
            }
            if (orderInfo.reduce_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, orderInfo.reduce_price);
            }
            if (orderInfo.reduce_price_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderInfo.reduce_price_txt);
            }
            if (orderInfo.shipment_expense_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, orderInfo.shipment_expense_txt);
            }
            if (orderInfo.goods_amount_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, orderInfo.goods_amount_txt);
            }
            if (orderInfo.ttl != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, orderInfo.ttl);
            }
            if (orderInfo.product != null) {
                ListProduct.ADAPTER.asRepeated().encodeWithTag(protoWriter, 8, orderInfo.product);
            }
            if (orderInfo.consignee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, orderInfo.consignee);
            }
            if (orderInfo.tel != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, orderInfo.tel);
            }
            if (orderInfo.province != null) {
                AddrSimple.ADAPTER.encodeWithTag(protoWriter, 11, orderInfo.province);
            }
            if (orderInfo.city != null) {
                AddrSimple.ADAPTER.encodeWithTag(protoWriter, 12, orderInfo.city);
            }
            if (orderInfo.distinct != null) {
                AddrSimple.ADAPTER.encodeWithTag(protoWriter, 13, orderInfo.distinct);
            }
            if (orderInfo.address != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, orderInfo.address);
            }
            if (orderInfo.zipcode != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, orderInfo.zipcode);
            }
            if (orderInfo.best_time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 16, orderInfo.best_time);
            }
            if (orderInfo.email != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, orderInfo.email);
            }
            if (orderInfo.invoice_type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, orderInfo.invoice_type);
            }
            if (orderInfo.invoice_title != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, orderInfo.invoice_title);
            }
            if (orderInfo.add_time_fm != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 20, orderInfo.add_time_fm);
            }
            if (orderInfo.deliver_info != null) {
                DeliverInfo.ADAPTER.encodeWithTag(protoWriter, 21, orderInfo.deliver_info);
            }
            if (orderInfo.addr_india != null) {
                AddrIndia.ADAPTER.encodeWithTag(protoWriter, 22, orderInfo.addr_india);
            }
            if (orderInfo.pay_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 23, orderInfo.pay_id);
            }
            if (orderInfo.add_time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 24, orderInfo.add_time);
            }
            if (orderInfo.order_status != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 25, orderInfo.order_status);
            }
            if (orderInfo.isGetSelf != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 26, orderInfo.isGetSelf);
            }
            if (orderInfo.remaining_time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 27, orderInfo.remaining_time);
            }
            protoWriter.writeBytes(orderInfo.unknownFields());
        }

        public final OrderInfo decode(ProtoReader protoReader) throws IOException {
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
                            builder.order_status_info(OrderStatusInfo.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.reduce_price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.reduce_price_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.shipment_expense_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.goods_amount_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.ttl(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.product.add(ListProduct.ADAPTER.decode(protoReader));
                            break;
                        case 9:
                            builder.consignee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.tel(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.province(AddrSimple.ADAPTER.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.city(AddrSimple.ADAPTER.decode(protoReader));
                            break;
                        case 13:
                            builder.distinct(AddrSimple.ADAPTER.decode(protoReader));
                            break;
                        case 14:
                            builder.address(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.zipcode(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.best_time(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 17:
                            builder.email(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 18:
                            builder.invoice_type(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 19:
                            builder.invoice_title(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 20:
                            builder.add_time_fm(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 21:
                            builder.deliver_info(DeliverInfo.ADAPTER.decode(protoReader));
                            break;
                        case 22:
                            builder.addr_india(AddrIndia.ADAPTER.decode(protoReader));
                            break;
                        case 23:
                            builder.pay_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 24:
                            builder.add_time(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 25:
                            builder.order_status(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 26:
                            builder.isGetSelf(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 27:
                            builder.remaining_time(ProtoAdapter.STRING.decode(protoReader));
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

        public final OrderInfo redact(OrderInfo orderInfo) {
            Builder newBuilder = orderInfo.newBuilder();
            if (newBuilder.order_status_info != null) {
                newBuilder.order_status_info = OrderStatusInfo.ADAPTER.redact(newBuilder.order_status_info);
            }
            Internal.redactElements(newBuilder.product, ListProduct.ADAPTER);
            if (newBuilder.province != null) {
                newBuilder.province = AddrSimple.ADAPTER.redact(newBuilder.province);
            }
            if (newBuilder.city != null) {
                newBuilder.city = AddrSimple.ADAPTER.redact(newBuilder.city);
            }
            if (newBuilder.distinct != null) {
                newBuilder.distinct = AddrSimple.ADAPTER.redact(newBuilder.distinct);
            }
            if (newBuilder.deliver_info != null) {
                newBuilder.deliver_info = DeliverInfo.ADAPTER.redact(newBuilder.deliver_info);
            }
            if (newBuilder.addr_india != null) {
                newBuilder.addr_india = AddrIndia.ADAPTER.redact(newBuilder.addr_india);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
