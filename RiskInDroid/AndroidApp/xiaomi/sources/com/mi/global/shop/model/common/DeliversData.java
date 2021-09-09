package com.mi.global.shop.model.common;

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

public final class DeliversData extends Message<DeliversData, Builder> {
    public static final ProtoAdapter<DeliversData> ADAPTER = new ProtoAdapter_DeliversData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String deliver_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String deliver_status;
    @WireField(adapter = "com.mi.global.shop.model.common.Express#ADAPTER", tag = 3)
    public final Express express;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String express_sn;
    @WireField(adapter = "com.mi.global.shop.model.common.OrderStatusInfo#ADAPTER", tag = 6)
    public final OrderStatusInfo order_status_info;
    @WireField(adapter = "com.mi.global.shop.model.common.ListProduct#ADAPTER", label = WireField.Label.REPEATED, tag = 5)
    public final List<ListProduct> product;

    public DeliversData(String str, String str2, Express express2, String str3, List<ListProduct> list, OrderStatusInfo orderStatusInfo) {
        this(str, str2, express2, str3, list, orderStatusInfo, ByteString.O00000Oo);
    }

    public DeliversData(String str, String str2, Express express2, String str3, List<ListProduct> list, OrderStatusInfo orderStatusInfo, ByteString byteString) {
        super(ADAPTER, byteString);
        this.deliver_status = str;
        this.deliver_id = str2;
        this.express = express2;
        this.express_sn = str3;
        this.product = Internal.immutableCopyOf("product", list);
        this.order_status_info = orderStatusInfo;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.deliver_status = this.deliver_status;
        builder.deliver_id = this.deliver_id;
        builder.express = this.express;
        builder.express_sn = this.express_sn;
        builder.product = Internal.copyOf("product", this.product);
        builder.order_status_info = this.order_status_info;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DeliversData)) {
            return false;
        }
        DeliversData deliversData = (DeliversData) obj;
        return Internal.equals(unknownFields(), deliversData.unknownFields()) && Internal.equals(this.deliver_status, deliversData.deliver_status) && Internal.equals(this.deliver_id, deliversData.deliver_id) && Internal.equals(this.express, deliversData.express) && Internal.equals(this.express_sn, deliversData.express_sn) && Internal.equals(this.product, deliversData.product) && Internal.equals(this.order_status_info, deliversData.order_status_info);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.deliver_status;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.deliver_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Express express2 = this.express;
        int hashCode4 = (hashCode3 + (express2 != null ? express2.hashCode() : 0)) * 37;
        String str3 = this.express_sn;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<ListProduct> list = this.product;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        OrderStatusInfo orderStatusInfo = this.order_status_info;
        if (orderStatusInfo != null) {
            i2 = orderStatusInfo.hashCode();
        }
        int i3 = hashCode6 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.deliver_status != null) {
            sb.append(", deliver_status=");
            sb.append(this.deliver_status);
        }
        if (this.deliver_id != null) {
            sb.append(", deliver_id=");
            sb.append(this.deliver_id);
        }
        if (this.express != null) {
            sb.append(", express=");
            sb.append(this.express);
        }
        if (this.express_sn != null) {
            sb.append(", express_sn=");
            sb.append(this.express_sn);
        }
        if (this.product != null) {
            sb.append(", product=");
            sb.append(this.product);
        }
        if (this.order_status_info != null) {
            sb.append(", order_status_info=");
            sb.append(this.order_status_info);
        }
        StringBuilder replace = sb.replace(0, 2, "DeliversData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<DeliversData, Builder> {
        public String deliver_id;
        public String deliver_status;
        public Express express;
        public String express_sn;
        public OrderStatusInfo order_status_info;
        public List<ListProduct> product = Internal.newMutableList();

        public final Builder deliver_status(String str) {
            this.deliver_status = str;
            return this;
        }

        public final Builder deliver_id(String str) {
            this.deliver_id = str;
            return this;
        }

        public final Builder express(Express express2) {
            this.express = express2;
            return this;
        }

        public final Builder express_sn(String str) {
            this.express_sn = str;
            return this;
        }

        public final Builder product(List<ListProduct> list) {
            Internal.checkElementsNotNull(list);
            this.product = list;
            return this;
        }

        public final Builder order_status_info(OrderStatusInfo orderStatusInfo) {
            this.order_status_info = orderStatusInfo;
            return this;
        }

        public final DeliversData build() {
            return new DeliversData(this.deliver_status, this.deliver_id, this.express, this.express_sn, this.product, this.order_status_info, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_DeliversData extends ProtoAdapter<DeliversData> {
        ProtoAdapter_DeliversData() {
            super(FieldEncoding.LENGTH_DELIMITED, DeliversData.class);
        }

        public final int encodedSize(DeliversData deliversData) {
            int i = 0;
            int encodedSizeWithTag = (deliversData.deliver_status != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, deliversData.deliver_status) : 0) + (deliversData.deliver_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, deliversData.deliver_id) : 0) + (deliversData.express != null ? Express.ADAPTER.encodedSizeWithTag(3, deliversData.express) : 0) + (deliversData.express_sn != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, deliversData.express_sn) : 0) + ListProduct.ADAPTER.asRepeated().encodedSizeWithTag(5, deliversData.product);
            if (deliversData.order_status_info != null) {
                i = OrderStatusInfo.ADAPTER.encodedSizeWithTag(6, deliversData.order_status_info);
            }
            return encodedSizeWithTag + i + deliversData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, DeliversData deliversData) throws IOException {
            if (deliversData.deliver_status != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, deliversData.deliver_status);
            }
            if (deliversData.deliver_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, deliversData.deliver_id);
            }
            if (deliversData.express != null) {
                Express.ADAPTER.encodeWithTag(protoWriter, 3, deliversData.express);
            }
            if (deliversData.express_sn != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, deliversData.express_sn);
            }
            if (deliversData.product != null) {
                ListProduct.ADAPTER.asRepeated().encodeWithTag(protoWriter, 5, deliversData.product);
            }
            if (deliversData.order_status_info != null) {
                OrderStatusInfo.ADAPTER.encodeWithTag(protoWriter, 6, deliversData.order_status_info);
            }
            protoWriter.writeBytes(deliversData.unknownFields());
        }

        public final DeliversData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.deliver_status(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.deliver_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.express(Express.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.express_sn(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.product.add(ListProduct.ADAPTER.decode(protoReader));
                            break;
                        case 6:
                            builder.order_status_info(OrderStatusInfo.ADAPTER.decode(protoReader));
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

        public final DeliversData redact(DeliversData deliversData) {
            Builder newBuilder = deliversData.newBuilder();
            if (newBuilder.express != null) {
                newBuilder.express = Express.ADAPTER.redact(newBuilder.express);
            }
            Internal.redactElements(newBuilder.product, ListProduct.ADAPTER);
            if (newBuilder.order_status_info != null) {
                newBuilder.order_status_info = OrderStatusInfo.ADAPTER.redact(newBuilder.order_status_info);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
