package com.mi.global.shop.model.user;

import com.google.android.exoplayer2.C;
import com.mi.global.shop.model.common.DeliversData;
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

public final class OrderViewData extends Message<OrderViewData, Builder> {
    public static final ProtoAdapter<OrderViewData> ADAPTER = new ProtoAdapter_OrderViewData();
    public static final Boolean DEFAULT_ISGETSELF = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String currentTime;
    @WireField(adapter = "com.mi.global.shop.model.common.DeliversData#ADAPTER", label = WireField.Label.REPEATED, tag = 2)
    public final List<DeliversData> delivers;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String differenceAmount;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String goodsAmt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 5)
    public final Boolean isGetSelf;
    @WireField(adapter = "com.mi.global.shop.model.user.OrderInfo#ADAPTER", tag = 3)
    public final OrderInfo orderInfo;
    @WireField(adapter = "com.mi.global.shop.model.user.PickupAddr#ADAPTER", tag = 6)
    public final PickupAddr pickupAddr;

    public OrderViewData(String str, List<DeliversData> list, OrderInfo orderInfo2, String str2, Boolean bool, PickupAddr pickupAddr2, String str3, String str4) {
        this(str, list, orderInfo2, str2, bool, pickupAddr2, str3, str4, ByteString.O00000Oo);
    }

    public OrderViewData(String str, List<DeliversData> list, OrderInfo orderInfo2, String str2, Boolean bool, PickupAddr pickupAddr2, String str3, String str4, ByteString byteString) {
        super(ADAPTER, byteString);
        this.id = str;
        this.delivers = Internal.immutableCopyOf("delivers", list);
        this.orderInfo = orderInfo2;
        this.differenceAmount = str2;
        this.isGetSelf = bool;
        this.pickupAddr = pickupAddr2;
        this.goodsAmt = str3;
        this.currentTime = str4;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.id = this.id;
        builder.delivers = Internal.copyOf("delivers", this.delivers);
        builder.orderInfo = this.orderInfo;
        builder.differenceAmount = this.differenceAmount;
        builder.isGetSelf = this.isGetSelf;
        builder.pickupAddr = this.pickupAddr;
        builder.goodsAmt = this.goodsAmt;
        builder.currentTime = this.currentTime;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderViewData)) {
            return false;
        }
        OrderViewData orderViewData = (OrderViewData) obj;
        return Internal.equals(unknownFields(), orderViewData.unknownFields()) && Internal.equals(this.id, orderViewData.id) && Internal.equals(this.delivers, orderViewData.delivers) && Internal.equals(this.orderInfo, orderViewData.orderInfo) && Internal.equals(this.differenceAmount, orderViewData.differenceAmount) && Internal.equals(this.isGetSelf, orderViewData.isGetSelf) && Internal.equals(this.pickupAddr, orderViewData.pickupAddr) && Internal.equals(this.goodsAmt, orderViewData.goodsAmt) && Internal.equals(this.currentTime, orderViewData.currentTime);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        List<DeliversData> list = this.delivers;
        int hashCode3 = (hashCode2 + (list != null ? list.hashCode() : 1)) * 37;
        OrderInfo orderInfo2 = this.orderInfo;
        int hashCode4 = (hashCode3 + (orderInfo2 != null ? orderInfo2.hashCode() : 0)) * 37;
        String str2 = this.differenceAmount;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.isGetSelf;
        int hashCode6 = (hashCode5 + (bool != null ? bool.hashCode() : 0)) * 37;
        PickupAddr pickupAddr2 = this.pickupAddr;
        int hashCode7 = (hashCode6 + (pickupAddr2 != null ? pickupAddr2.hashCode() : 0)) * 37;
        String str3 = this.goodsAmt;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.currentTime;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.id != null) {
            sb.append(", id=");
            sb.append(this.id);
        }
        if (this.delivers != null) {
            sb.append(", delivers=");
            sb.append(this.delivers);
        }
        if (this.orderInfo != null) {
            sb.append(", orderInfo=");
            sb.append(this.orderInfo);
        }
        if (this.differenceAmount != null) {
            sb.append(", differenceAmount=");
            sb.append(this.differenceAmount);
        }
        if (this.isGetSelf != null) {
            sb.append(", isGetSelf=");
            sb.append(this.isGetSelf);
        }
        if (this.pickupAddr != null) {
            sb.append(", pickupAddr=");
            sb.append(this.pickupAddr);
        }
        if (this.goodsAmt != null) {
            sb.append(", goodsAmt=");
            sb.append(this.goodsAmt);
        }
        if (this.currentTime != null) {
            sb.append(", currentTime=");
            sb.append(this.currentTime);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderViewData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderViewData, Builder> {
        public String currentTime;
        public List<DeliversData> delivers = Internal.newMutableList();
        public String differenceAmount;
        public String goodsAmt;
        public String id;
        public Boolean isGetSelf;
        public OrderInfo orderInfo;
        public PickupAddr pickupAddr;

        public final Builder id(String str) {
            this.id = str;
            return this;
        }

        public final Builder delivers(List<DeliversData> list) {
            Internal.checkElementsNotNull(list);
            this.delivers = list;
            return this;
        }

        public final Builder orderInfo(OrderInfo orderInfo2) {
            this.orderInfo = orderInfo2;
            return this;
        }

        public final Builder differenceAmount(String str) {
            this.differenceAmount = str;
            return this;
        }

        public final Builder isGetSelf(Boolean bool) {
            this.isGetSelf = bool;
            return this;
        }

        public final Builder pickupAddr(PickupAddr pickupAddr2) {
            this.pickupAddr = pickupAddr2;
            return this;
        }

        public final Builder goodsAmt(String str) {
            this.goodsAmt = str;
            return this;
        }

        public final Builder currentTime(String str) {
            this.currentTime = str;
            return this;
        }

        public final OrderViewData build() {
            return new OrderViewData(this.id, this.delivers, this.orderInfo, this.differenceAmount, this.isGetSelf, this.pickupAddr, this.goodsAmt, this.currentTime, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_OrderViewData extends ProtoAdapter<OrderViewData> {
        ProtoAdapter_OrderViewData() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderViewData.class);
        }

        public final int encodedSize(OrderViewData orderViewData) {
            int i = 0;
            int encodedSizeWithTag = (orderViewData.id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, orderViewData.id) : 0) + DeliversData.ADAPTER.asRepeated().encodedSizeWithTag(2, orderViewData.delivers) + (orderViewData.orderInfo != null ? OrderInfo.ADAPTER.encodedSizeWithTag(3, orderViewData.orderInfo) : 0) + (orderViewData.differenceAmount != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderViewData.differenceAmount) : 0) + (orderViewData.isGetSelf != null ? ProtoAdapter.BOOL.encodedSizeWithTag(5, orderViewData.isGetSelf) : 0) + (orderViewData.pickupAddr != null ? PickupAddr.ADAPTER.encodedSizeWithTag(6, orderViewData.pickupAddr) : 0) + (orderViewData.goodsAmt != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, orderViewData.goodsAmt) : 0);
            if (orderViewData.currentTime != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(8, orderViewData.currentTime);
            }
            return encodedSizeWithTag + i + orderViewData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, OrderViewData orderViewData) throws IOException {
            if (orderViewData.id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, orderViewData.id);
            }
            if (orderViewData.delivers != null) {
                DeliversData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 2, orderViewData.delivers);
            }
            if (orderViewData.orderInfo != null) {
                OrderInfo.ADAPTER.encodeWithTag(protoWriter, 3, orderViewData.orderInfo);
            }
            if (orderViewData.differenceAmount != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderViewData.differenceAmount);
            }
            if (orderViewData.isGetSelf != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 5, orderViewData.isGetSelf);
            }
            if (orderViewData.pickupAddr != null) {
                PickupAddr.ADAPTER.encodeWithTag(protoWriter, 6, orderViewData.pickupAddr);
            }
            if (orderViewData.goodsAmt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, orderViewData.goodsAmt);
            }
            if (orderViewData.currentTime != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, orderViewData.currentTime);
            }
            protoWriter.writeBytes(orderViewData.unknownFields());
        }

        public final OrderViewData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.delivers.add(DeliversData.ADAPTER.decode(protoReader));
                            break;
                        case 3:
                            builder.orderInfo(OrderInfo.ADAPTER.decode(protoReader));
                            break;
                        case 4:
                            builder.differenceAmount(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.isGetSelf(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 6:
                            builder.pickupAddr(PickupAddr.ADAPTER.decode(protoReader));
                            break;
                        case 7:
                            builder.goodsAmt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.currentTime(ProtoAdapter.STRING.decode(protoReader));
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

        public final OrderViewData redact(OrderViewData orderViewData) {
            Builder newBuilder = orderViewData.newBuilder();
            Internal.redactElements(newBuilder.delivers, DeliversData.ADAPTER);
            if (newBuilder.orderInfo != null) {
                newBuilder.orderInfo = OrderInfo.ADAPTER.redact(newBuilder.orderInfo);
            }
            if (newBuilder.pickupAddr != null) {
                newBuilder.pickupAddr = PickupAddr.ADAPTER.redact(newBuilder.pickupAddr);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
