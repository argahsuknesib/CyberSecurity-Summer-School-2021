package com.mi.global.shop.model.user;

import com.google.android.exoplayer2.C;
import com.mi.global.shop.model.common.Express;
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
import okio.ByteString;

public final class DeliverInfo extends Message<DeliverInfo, Builder> {
    public static final ProtoAdapter<DeliverInfo> ADAPTER = new ProtoAdapter_DeliverInfo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String deliver_id;
    @WireField(adapter = "com.mi.global.shop.model.common.Express#ADAPTER", tag = 10)
    public final Express express;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String express_sn;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String goods_amount_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String order_id;
    @WireField(adapter = "com.mi.global.shop.model.common.OrderStatusInfo#ADAPTER", tag = 2)
    public final OrderStatusInfo order_status_info;
    @WireField(adapter = "com.mi.global.shop.model.common.ListProduct#ADAPTER", label = WireField.Label.REPEATED, tag = 7)
    public final List<ListProduct> product;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String reduce_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String reduce_price_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String shipment_expense_txt;

    public DeliverInfo(String str, OrderStatusInfo orderStatusInfo, String str2, String str3, String str4, String str5, List<ListProduct> list, String str6, String str7, Express express2) {
        this(str, orderStatusInfo, str2, str3, str4, str5, list, str6, str7, express2, ByteString.O00000Oo);
    }

    public DeliverInfo(String str, OrderStatusInfo orderStatusInfo, String str2, String str3, String str4, String str5, List<ListProduct> list, String str6, String str7, Express express2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.order_id = str;
        this.order_status_info = orderStatusInfo;
        this.reduce_price = str2;
        this.reduce_price_txt = str3;
        this.shipment_expense_txt = str4;
        this.goods_amount_txt = str5;
        this.product = Internal.immutableCopyOf("product", list);
        this.deliver_id = str6;
        this.express_sn = str7;
        this.express = express2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.order_status_info = this.order_status_info;
        builder.reduce_price = this.reduce_price;
        builder.reduce_price_txt = this.reduce_price_txt;
        builder.shipment_expense_txt = this.shipment_expense_txt;
        builder.goods_amount_txt = this.goods_amount_txt;
        builder.product = Internal.copyOf("product", this.product);
        builder.deliver_id = this.deliver_id;
        builder.express_sn = this.express_sn;
        builder.express = this.express;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeliverInfo)) {
            return false;
        }
        DeliverInfo deliverInfo = (DeliverInfo) obj;
        return Internal.equals(unknownFields(), deliverInfo.unknownFields()) && Internal.equals(this.order_id, deliverInfo.order_id) && Internal.equals(this.order_status_info, deliverInfo.order_status_info) && Internal.equals(this.reduce_price, deliverInfo.reduce_price) && Internal.equals(this.reduce_price_txt, deliverInfo.reduce_price_txt) && Internal.equals(this.shipment_expense_txt, deliverInfo.shipment_expense_txt) && Internal.equals(this.goods_amount_txt, deliverInfo.goods_amount_txt) && Internal.equals(this.product, deliverInfo.product) && Internal.equals(this.deliver_id, deliverInfo.deliver_id) && Internal.equals(this.express_sn, deliverInfo.express_sn) && Internal.equals(this.express, deliverInfo.express);
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
        List<ListProduct> list = this.product;
        int hashCode8 = (hashCode7 + (list != null ? list.hashCode() : 1)) * 37;
        String str6 = this.deliver_id;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.express_sn;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Express express2 = this.express;
        if (express2 != null) {
            i2 = express2.hashCode();
        }
        int i3 = hashCode10 + i2;
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
        if (this.product != null) {
            sb.append(", product=");
            sb.append(this.product);
        }
        if (this.deliver_id != null) {
            sb.append(", deliver_id=");
            sb.append(this.deliver_id);
        }
        if (this.express_sn != null) {
            sb.append(", express_sn=");
            sb.append(this.express_sn);
        }
        if (this.express != null) {
            sb.append(", express=");
            sb.append(this.express);
        }
        StringBuilder replace = sb.replace(0, 2, "DeliverInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<DeliverInfo, Builder> {
        public String deliver_id;
        public Express express;
        public String express_sn;
        public String goods_amount_txt;
        public String order_id;
        public OrderStatusInfo order_status_info;
        public List<ListProduct> product = Internal.newMutableList();
        public String reduce_price;
        public String reduce_price_txt;
        public String shipment_expense_txt;

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

        public final Builder product(List<ListProduct> list) {
            Internal.checkElementsNotNull(list);
            this.product = list;
            return this;
        }

        public final Builder deliver_id(String str) {
            this.deliver_id = str;
            return this;
        }

        public final Builder express_sn(String str) {
            this.express_sn = str;
            return this;
        }

        public final Builder express(Express express2) {
            this.express = express2;
            return this;
        }

        public final DeliverInfo build() {
            return new DeliverInfo(this.order_id, this.order_status_info, this.reduce_price, this.reduce_price_txt, this.shipment_expense_txt, this.goods_amount_txt, this.product, this.deliver_id, this.express_sn, this.express, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_DeliverInfo extends ProtoAdapter<DeliverInfo> {
        ProtoAdapter_DeliverInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DeliverInfo.class);
        }

        public final int encodedSize(DeliverInfo deliverInfo) {
            int i = 0;
            int encodedSizeWithTag = (deliverInfo.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, deliverInfo.order_id) : 0) + (deliverInfo.order_status_info != null ? OrderStatusInfo.ADAPTER.encodedSizeWithTag(2, deliverInfo.order_status_info) : 0) + (deliverInfo.reduce_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, deliverInfo.reduce_price) : 0) + (deliverInfo.reduce_price_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, deliverInfo.reduce_price_txt) : 0) + (deliverInfo.shipment_expense_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, deliverInfo.shipment_expense_txt) : 0) + (deliverInfo.goods_amount_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, deliverInfo.goods_amount_txt) : 0) + ListProduct.ADAPTER.asRepeated().encodedSizeWithTag(7, deliverInfo.product) + (deliverInfo.deliver_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, deliverInfo.deliver_id) : 0) + (deliverInfo.express_sn != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, deliverInfo.express_sn) : 0);
            if (deliverInfo.express != null) {
                i = Express.ADAPTER.encodedSizeWithTag(10, deliverInfo.express);
            }
            return encodedSizeWithTag + i + deliverInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, DeliverInfo deliverInfo) throws IOException {
            if (deliverInfo.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, deliverInfo.order_id);
            }
            if (deliverInfo.order_status_info != null) {
                OrderStatusInfo.ADAPTER.encodeWithTag(protoWriter, 2, deliverInfo.order_status_info);
            }
            if (deliverInfo.reduce_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, deliverInfo.reduce_price);
            }
            if (deliverInfo.reduce_price_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, deliverInfo.reduce_price_txt);
            }
            if (deliverInfo.shipment_expense_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, deliverInfo.shipment_expense_txt);
            }
            if (deliverInfo.goods_amount_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, deliverInfo.goods_amount_txt);
            }
            if (deliverInfo.product != null) {
                ListProduct.ADAPTER.asRepeated().encodeWithTag(protoWriter, 7, deliverInfo.product);
            }
            if (deliverInfo.deliver_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, deliverInfo.deliver_id);
            }
            if (deliverInfo.express_sn != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, deliverInfo.express_sn);
            }
            if (deliverInfo.express != null) {
                Express.ADAPTER.encodeWithTag(protoWriter, 10, deliverInfo.express);
            }
            protoWriter.writeBytes(deliverInfo.unknownFields());
        }

        public final DeliverInfo decode(ProtoReader protoReader) throws IOException {
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
                            builder.product.add(ListProduct.ADAPTER.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.deliver_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.express_sn(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.express(Express.ADAPTER.decode(protoReader));
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

        public final DeliverInfo redact(DeliverInfo deliverInfo) {
            Builder newBuilder = deliverInfo.newBuilder();
            if (newBuilder.order_status_info != null) {
                newBuilder.order_status_info = OrderStatusInfo.ADAPTER.redact(newBuilder.order_status_info);
            }
            Internal.redactElements(newBuilder.product, ListProduct.ADAPTER);
            if (newBuilder.express != null) {
                newBuilder.express = Express.ADAPTER.redact(newBuilder.express);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
