package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Order extends Message<Order, Builder> {
    public static final ProtoAdapter<Order> ADAPTER = new ProtoAdapter_Order();
    public static final Integer DEFAULT_ERRNO = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.mi.global.shop.model.user.OrderListData#ADAPTER", tag = 5)
    public final OrderListData data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String errmsg;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer errno;

    public Order(Integer num, String str, OrderListData orderListData) {
        this(num, str, orderListData, ByteString.O00000Oo);
    }

    public Order(Integer num, String str, OrderListData orderListData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.errno = num;
        this.errmsg = str;
        this.data = orderListData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.errno = this.errno;
        builder.errmsg = this.errmsg;
        builder.data = this.data;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order order = (Order) obj;
        return Internal.equals(unknownFields(), order.unknownFields()) && Internal.equals(this.errno, order.errno) && Internal.equals(this.errmsg, order.errmsg) && Internal.equals(this.data, order.data);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Integer num = this.errno;
        int i2 = 0;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.errmsg;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        OrderListData orderListData = this.data;
        if (orderListData != null) {
            i2 = orderListData.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.errno != null) {
            sb.append(", errno=");
            sb.append(this.errno);
        }
        if (this.errmsg != null) {
            sb.append(", errmsg=");
            sb.append(this.errmsg);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        StringBuilder replace = sb.replace(0, 2, "Order{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<Order, Builder> {
        public OrderListData data;
        public String errmsg;
        public Integer errno;

        public final Builder errno(Integer num) {
            this.errno = num;
            return this;
        }

        public final Builder errmsg(String str) {
            this.errmsg = str;
            return this;
        }

        public final Builder data(OrderListData orderListData) {
            this.data = orderListData;
            return this;
        }

        public final Order build() {
            return new Order(this.errno, this.errmsg, this.data, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_Order extends ProtoAdapter<Order> {
        ProtoAdapter_Order() {
            super(FieldEncoding.LENGTH_DELIMITED, Order.class);
        }

        public final int encodedSize(Order order) {
            int i = 0;
            int encodedSizeWithTag = (order.errno != null ? ProtoAdapter.INT32.encodedSizeWithTag(1, order.errno) : 0) + (order.errmsg != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, order.errmsg) : 0);
            if (order.data != null) {
                i = OrderListData.ADAPTER.encodedSizeWithTag(5, order.data);
            }
            return encodedSizeWithTag + i + order.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, Order order) throws IOException {
            if (order.errno != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 1, order.errno);
            }
            if (order.errmsg != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, order.errmsg);
            }
            if (order.data != null) {
                OrderListData.ADAPTER.encodeWithTag(protoWriter, 5, order.data);
            }
            protoWriter.writeBytes(order.unknownFields());
        }

        public final Order decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.errno(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.errmsg(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.data(OrderListData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final Order redact(Order order) {
            Builder newBuilder = order.newBuilder();
            if (newBuilder.data != null) {
                newBuilder.data = OrderListData.ADAPTER.redact(newBuilder.data);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
