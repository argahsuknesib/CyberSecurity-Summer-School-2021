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
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class OrderInfoData extends Message<OrderInfoData, Builder> {
    public static final ProtoAdapter<OrderInfoData> ADAPTER = new ProtoAdapter_OrderInfoData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String address;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String consignee;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String goods_amount;
    @WireField(adapter = "com.mi.global.shop.model.buy.OrderItemsData#ADAPTER", label = WireField.Label.REPEATED, tag = 11)
    public final List<OrderItemsData> orderItems;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String order_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String original_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String reduce_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String remaining_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String shipment_expense;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String tel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String zipcode;

    public OrderInfoData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<OrderItemsData> list, String str10) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, list, str10, ByteString.O00000Oo);
    }

    public OrderInfoData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List<OrderItemsData> list, String str10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.order_id = str;
        this.consignee = str2;
        this.address = str3;
        this.zipcode = str4;
        this.tel = str5;
        this.goods_amount = str6;
        this.original_price = str7;
        this.shipment_expense = str8;
        this.reduce_price = str9;
        this.orderItems = Internal.immutableCopyOf("orderItems", list);
        this.remaining_time = str10;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.consignee = this.consignee;
        builder.address = this.address;
        builder.zipcode = this.zipcode;
        builder.tel = this.tel;
        builder.goods_amount = this.goods_amount;
        builder.original_price = this.original_price;
        builder.shipment_expense = this.shipment_expense;
        builder.reduce_price = this.reduce_price;
        builder.orderItems = Internal.copyOf("orderItems", this.orderItems);
        builder.remaining_time = this.remaining_time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderInfoData)) {
            return false;
        }
        OrderInfoData orderInfoData = (OrderInfoData) obj;
        return Internal.equals(unknownFields(), orderInfoData.unknownFields()) && Internal.equals(this.order_id, orderInfoData.order_id) && Internal.equals(this.consignee, orderInfoData.consignee) && Internal.equals(this.address, orderInfoData.address) && Internal.equals(this.zipcode, orderInfoData.zipcode) && Internal.equals(this.tel, orderInfoData.tel) && Internal.equals(this.goods_amount, orderInfoData.goods_amount) && Internal.equals(this.original_price, orderInfoData.original_price) && Internal.equals(this.shipment_expense, orderInfoData.shipment_expense) && Internal.equals(this.reduce_price, orderInfoData.reduce_price) && Internal.equals(this.orderItems, orderInfoData.orderItems) && Internal.equals(this.remaining_time, orderInfoData.remaining_time);
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
        String str2 = this.consignee;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.address;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.zipcode;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.tel;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.goods_amount;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.original_price;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.shipment_expense;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.reduce_price;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        List<OrderItemsData> list = this.orderItems;
        int hashCode11 = (hashCode10 + (list != null ? list.hashCode() : 1)) * 37;
        String str10 = this.remaining_time;
        if (str10 != null) {
            i2 = str10.hashCode();
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
        if (this.consignee != null) {
            sb.append(", consignee=");
            sb.append(this.consignee);
        }
        if (this.address != null) {
            sb.append(", address=");
            sb.append(this.address);
        }
        if (this.zipcode != null) {
            sb.append(", zipcode=");
            sb.append(this.zipcode);
        }
        if (this.tel != null) {
            sb.append(", tel=");
            sb.append(this.tel);
        }
        if (this.goods_amount != null) {
            sb.append(", goods_amount=");
            sb.append(this.goods_amount);
        }
        if (this.original_price != null) {
            sb.append(", original_price=");
            sb.append(this.original_price);
        }
        if (this.shipment_expense != null) {
            sb.append(", shipment_expense=");
            sb.append(this.shipment_expense);
        }
        if (this.reduce_price != null) {
            sb.append(", reduce_price=");
            sb.append(this.reduce_price);
        }
        if (this.orderItems != null) {
            sb.append(", orderItems=");
            sb.append(this.orderItems);
        }
        if (this.remaining_time != null) {
            sb.append(", remaining_time=");
            sb.append(this.remaining_time);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderInfoData, Builder> {
        public String address;
        public String consignee;
        public String goods_amount;
        public List<OrderItemsData> orderItems = Internal.newMutableList();
        public String order_id;
        public String original_price;
        public String reduce_price;
        public String remaining_time;
        public String shipment_expense;
        public String tel;
        public String zipcode;

        public final Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public final Builder consignee(String str) {
            this.consignee = str;
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

        public final Builder tel(String str) {
            this.tel = str;
            return this;
        }

        public final Builder goods_amount(String str) {
            this.goods_amount = str;
            return this;
        }

        public final Builder original_price(String str) {
            this.original_price = str;
            return this;
        }

        public final Builder shipment_expense(String str) {
            this.shipment_expense = str;
            return this;
        }

        public final Builder reduce_price(String str) {
            this.reduce_price = str;
            return this;
        }

        public final Builder orderItems(List<OrderItemsData> list) {
            Internal.checkElementsNotNull(list);
            this.orderItems = list;
            return this;
        }

        public final Builder remaining_time(String str) {
            this.remaining_time = str;
            return this;
        }

        public final OrderInfoData build() {
            return new OrderInfoData(this.order_id, this.consignee, this.address, this.zipcode, this.tel, this.goods_amount, this.original_price, this.shipment_expense, this.reduce_price, this.orderItems, this.remaining_time, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_OrderInfoData extends ProtoAdapter<OrderInfoData> {
        ProtoAdapter_OrderInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderInfoData.class);
        }

        public final int encodedSize(OrderInfoData orderInfoData) {
            int i = 0;
            int encodedSizeWithTag = (orderInfoData.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, orderInfoData.order_id) : 0) + (orderInfoData.consignee != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, orderInfoData.consignee) : 0) + (orderInfoData.address != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderInfoData.address) : 0) + (orderInfoData.zipcode != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, orderInfoData.zipcode) : 0) + (orderInfoData.tel != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, orderInfoData.tel) : 0) + (orderInfoData.goods_amount != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, orderInfoData.goods_amount) : 0) + (orderInfoData.original_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, orderInfoData.original_price) : 0) + (orderInfoData.shipment_expense != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, orderInfoData.shipment_expense) : 0) + (orderInfoData.reduce_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, orderInfoData.reduce_price) : 0) + OrderItemsData.ADAPTER.asRepeated().encodedSizeWithTag(11, orderInfoData.orderItems);
            if (orderInfoData.remaining_time != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(12, orderInfoData.remaining_time);
            }
            return encodedSizeWithTag + i + orderInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, OrderInfoData orderInfoData) throws IOException {
            if (orderInfoData.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, orderInfoData.order_id);
            }
            if (orderInfoData.consignee != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, orderInfoData.consignee);
            }
            if (orderInfoData.address != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderInfoData.address);
            }
            if (orderInfoData.zipcode != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, orderInfoData.zipcode);
            }
            if (orderInfoData.tel != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, orderInfoData.tel);
            }
            if (orderInfoData.goods_amount != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, orderInfoData.goods_amount);
            }
            if (orderInfoData.original_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, orderInfoData.original_price);
            }
            if (orderInfoData.shipment_expense != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, orderInfoData.shipment_expense);
            }
            if (orderInfoData.reduce_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, orderInfoData.reduce_price);
            }
            if (orderInfoData.orderItems != null) {
                OrderItemsData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 11, orderInfoData.orderItems);
            }
            if (orderInfoData.remaining_time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, orderInfoData.remaining_time);
            }
            protoWriter.writeBytes(orderInfoData.unknownFields());
        }

        public final OrderInfoData decode(ProtoReader protoReader) throws IOException {
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
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                        case 3:
                            builder.consignee(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.address(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.zipcode(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.tel(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.goods_amount(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.original_price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.shipment_expense(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.reduce_price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.orderItems.add(OrderItemsData.ADAPTER.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.remaining_time(ProtoAdapter.STRING.decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                }
            }
        }

        public final OrderInfoData redact(OrderInfoData orderInfoData) {
            Builder newBuilder = orderInfoData.newBuilder();
            Internal.redactElements(newBuilder.orderItems, OrderItemsData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
