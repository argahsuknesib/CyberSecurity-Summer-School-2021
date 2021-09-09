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

public final class OrderStatusInfo extends Message<OrderStatusInfo, Builder> {
    public static final ProtoAdapter<OrderStatusInfo> ADAPTER = new ProtoAdapter_OrderStatusInfo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String apply_refund_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String apply_refund_status;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String delivery_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 5)
    public final List<String> next;
    @WireField(adapter = "com.mi.global.shop.model.common.TraceItem#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<TraceItem> trace;

    public OrderStatusInfo(String str, String str2, String str3, String str4, List<String> list, List<TraceItem> list2) {
        this(str, str2, str3, str4, list, list2, ByteString.O00000Oo);
    }

    public OrderStatusInfo(String str, String str2, String str3, String str4, List<String> list, List<TraceItem> list2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.apply_refund_info = str;
        this.apply_refund_status = str2;
        this.delivery_info = str3;
        this.info = str4;
        this.next = Internal.immutableCopyOf("next", list);
        this.trace = Internal.immutableCopyOf("trace", list2);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.apply_refund_info = this.apply_refund_info;
        builder.apply_refund_status = this.apply_refund_status;
        builder.delivery_info = this.delivery_info;
        builder.info = this.info;
        builder.next = Internal.copyOf("next", this.next);
        builder.trace = Internal.copyOf("trace", this.trace);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderStatusInfo)) {
            return false;
        }
        OrderStatusInfo orderStatusInfo = (OrderStatusInfo) obj;
        return Internal.equals(unknownFields(), orderStatusInfo.unknownFields()) && Internal.equals(this.apply_refund_info, orderStatusInfo.apply_refund_info) && Internal.equals(this.apply_refund_status, orderStatusInfo.apply_refund_status) && Internal.equals(this.delivery_info, orderStatusInfo.delivery_info) && Internal.equals(this.info, orderStatusInfo.info) && Internal.equals(this.next, orderStatusInfo.next) && Internal.equals(this.trace, orderStatusInfo.trace);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.apply_refund_info;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.apply_refund_status;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.delivery_info;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.info;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = (hashCode4 + i2) * 37;
        List<String> list = this.next;
        int i4 = 1;
        int hashCode5 = (i3 + (list != null ? list.hashCode() : 1)) * 37;
        List<TraceItem> list2 = this.trace;
        if (list2 != null) {
            i4 = list2.hashCode();
        }
        int i5 = hashCode5 + i4;
        this.hashCode = i5;
        return i5;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.apply_refund_info != null) {
            sb.append(", apply_refund_info=");
            sb.append(this.apply_refund_info);
        }
        if (this.apply_refund_status != null) {
            sb.append(", apply_refund_status=");
            sb.append(this.apply_refund_status);
        }
        if (this.delivery_info != null) {
            sb.append(", delivery_info=");
            sb.append(this.delivery_info);
        }
        if (this.info != null) {
            sb.append(", info=");
            sb.append(this.info);
        }
        if (this.next != null) {
            sb.append(", next=");
            sb.append(this.next);
        }
        if (this.trace != null) {
            sb.append(", trace=");
            sb.append(this.trace);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderStatusInfo{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderStatusInfo, Builder> {
        public String apply_refund_info;
        public String apply_refund_status;
        public String delivery_info;
        public String info;
        public List<String> next = Internal.newMutableList();
        public List<TraceItem> trace = Internal.newMutableList();

        public final Builder apply_refund_info(String str) {
            this.apply_refund_info = str;
            return this;
        }

        public final Builder apply_refund_status(String str) {
            this.apply_refund_status = str;
            return this;
        }

        public final Builder delivery_info(String str) {
            this.delivery_info = str;
            return this;
        }

        public final Builder info(String str) {
            this.info = str;
            return this;
        }

        public final Builder next(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.next = list;
            return this;
        }

        public final Builder trace(List<TraceItem> list) {
            Internal.checkElementsNotNull(list);
            this.trace = list;
            return this;
        }

        public final OrderStatusInfo build() {
            return new OrderStatusInfo(this.apply_refund_info, this.apply_refund_status, this.delivery_info, this.info, this.next, this.trace, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_OrderStatusInfo extends ProtoAdapter<OrderStatusInfo> {
        ProtoAdapter_OrderStatusInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderStatusInfo.class);
        }

        public final int encodedSize(OrderStatusInfo orderStatusInfo) {
            int i = 0;
            int encodedSizeWithTag = (orderStatusInfo.apply_refund_info != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, orderStatusInfo.apply_refund_info) : 0) + (orderStatusInfo.apply_refund_status != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, orderStatusInfo.apply_refund_status) : 0) + (orderStatusInfo.delivery_info != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, orderStatusInfo.delivery_info) : 0);
            if (orderStatusInfo.info != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, orderStatusInfo.info);
            }
            return encodedSizeWithTag + i + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(5, orderStatusInfo.next) + TraceItem.ADAPTER.asRepeated().encodedSizeWithTag(6, orderStatusInfo.trace) + orderStatusInfo.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, OrderStatusInfo orderStatusInfo) throws IOException {
            if (orderStatusInfo.apply_refund_info != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, orderStatusInfo.apply_refund_info);
            }
            if (orderStatusInfo.apply_refund_status != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, orderStatusInfo.apply_refund_status);
            }
            if (orderStatusInfo.delivery_info != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, orderStatusInfo.delivery_info);
            }
            if (orderStatusInfo.info != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderStatusInfo.info);
            }
            if (orderStatusInfo.next != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 5, orderStatusInfo.next);
            }
            if (orderStatusInfo.trace != null) {
                TraceItem.ADAPTER.asRepeated().encodeWithTag(protoWriter, 6, orderStatusInfo.trace);
            }
            protoWriter.writeBytes(orderStatusInfo.unknownFields());
        }

        public final OrderStatusInfo decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.apply_refund_info(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.apply_refund_status(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.delivery_info(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.info(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.next.add(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.trace.add(TraceItem.ADAPTER.decode(protoReader));
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

        public final OrderStatusInfo redact(OrderStatusInfo orderStatusInfo) {
            Builder newBuilder = orderStatusInfo.newBuilder();
            Internal.redactElements(newBuilder.trace, TraceItem.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
