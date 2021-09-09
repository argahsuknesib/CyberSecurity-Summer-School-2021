package com.mi.global.shop.model.buy;

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

public final class OrderItemsData extends Message<OrderItemsData, Builder> {
    public static final ProtoAdapter<OrderItemsData> ADAPTER = new ProtoAdapter_OrderItemsData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String cart_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String goods_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String product_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String product_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String subtotal;

    public OrderItemsData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this(str, str2, str3, str4, str5, str6, str7, str8, ByteString.O00000Oo);
    }

    public OrderItemsData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, ByteString byteString) {
        super(ADAPTER, byteString);
        this.product_id = str;
        this.goods_id = str2;
        this.product_name = str3;
        this.image_url = str4;
        this.product_count = str5;
        this.cart_price = str6;
        this.price = str7;
        this.subtotal = str8;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.product_id = this.product_id;
        builder.goods_id = this.goods_id;
        builder.product_name = this.product_name;
        builder.image_url = this.image_url;
        builder.product_count = this.product_count;
        builder.cart_price = this.cart_price;
        builder.price = this.price;
        builder.subtotal = this.subtotal;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderItemsData)) {
            return false;
        }
        OrderItemsData orderItemsData = (OrderItemsData) obj;
        return Internal.equals(unknownFields(), orderItemsData.unknownFields()) && Internal.equals(this.product_id, orderItemsData.product_id) && Internal.equals(this.goods_id, orderItemsData.goods_id) && Internal.equals(this.product_name, orderItemsData.product_name) && Internal.equals(this.image_url, orderItemsData.image_url) && Internal.equals(this.product_count, orderItemsData.product_count) && Internal.equals(this.cart_price, orderItemsData.cart_price) && Internal.equals(this.price, orderItemsData.price) && Internal.equals(this.subtotal, orderItemsData.subtotal);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.product_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.goods_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.product_name;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.image_url;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.product_count;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.cart_price;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.price;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.subtotal;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode8 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.product_id != null) {
            sb.append(", product_id=");
            sb.append(this.product_id);
        }
        if (this.goods_id != null) {
            sb.append(", goods_id=");
            sb.append(this.goods_id);
        }
        if (this.product_name != null) {
            sb.append(", product_name=");
            sb.append(this.product_name);
        }
        if (this.image_url != null) {
            sb.append(", image_url=");
            sb.append(this.image_url);
        }
        if (this.product_count != null) {
            sb.append(", product_count=");
            sb.append(this.product_count);
        }
        if (this.cart_price != null) {
            sb.append(", cart_price=");
            sb.append(this.cart_price);
        }
        if (this.price != null) {
            sb.append(", price=");
            sb.append(this.price);
        }
        if (this.subtotal != null) {
            sb.append(", subtotal=");
            sb.append(this.subtotal);
        }
        StringBuilder replace = sb.replace(0, 2, "OrderItemsData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<OrderItemsData, Builder> {
        public String cart_price;
        public String goods_id;
        public String image_url;
        public String price;
        public String product_count;
        public String product_id;
        public String product_name;
        public String subtotal;

        public final Builder product_id(String str) {
            this.product_id = str;
            return this;
        }

        public final Builder goods_id(String str) {
            this.goods_id = str;
            return this;
        }

        public final Builder product_name(String str) {
            this.product_name = str;
            return this;
        }

        public final Builder image_url(String str) {
            this.image_url = str;
            return this;
        }

        public final Builder product_count(String str) {
            this.product_count = str;
            return this;
        }

        public final Builder cart_price(String str) {
            this.cart_price = str;
            return this;
        }

        public final Builder price(String str) {
            this.price = str;
            return this;
        }

        public final Builder subtotal(String str) {
            this.subtotal = str;
            return this;
        }

        public final OrderItemsData build() {
            return new OrderItemsData(this.product_id, this.goods_id, this.product_name, this.image_url, this.product_count, this.cart_price, this.price, this.subtotal, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_OrderItemsData extends ProtoAdapter<OrderItemsData> {
        ProtoAdapter_OrderItemsData() {
            super(FieldEncoding.LENGTH_DELIMITED, OrderItemsData.class);
        }

        public final int encodedSize(OrderItemsData orderItemsData) {
            int i = 0;
            int encodedSizeWithTag = (orderItemsData.product_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, orderItemsData.product_id) : 0) + (orderItemsData.goods_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, orderItemsData.goods_id) : 0) + (orderItemsData.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, orderItemsData.product_name) : 0) + (orderItemsData.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, orderItemsData.image_url) : 0) + (orderItemsData.product_count != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, orderItemsData.product_count) : 0) + (orderItemsData.cart_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, orderItemsData.cart_price) : 0) + (orderItemsData.price != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, orderItemsData.price) : 0);
            if (orderItemsData.subtotal != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(12, orderItemsData.subtotal);
            }
            return encodedSizeWithTag + i + orderItemsData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, OrderItemsData orderItemsData) throws IOException {
            if (orderItemsData.product_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, orderItemsData.product_id);
            }
            if (orderItemsData.goods_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, orderItemsData.goods_id);
            }
            if (orderItemsData.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, orderItemsData.product_name);
            }
            if (orderItemsData.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, orderItemsData.image_url);
            }
            if (orderItemsData.product_count != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, orderItemsData.product_count);
            }
            if (orderItemsData.cart_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, orderItemsData.cart_price);
            }
            if (orderItemsData.price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, orderItemsData.price);
            }
            if (orderItemsData.subtotal != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, orderItemsData.subtotal);
            }
            protoWriter.writeBytes(orderItemsData.unknownFields());
        }

        public final OrderItemsData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.product_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.goods_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    switch (nextTag) {
                        case 9:
                            builder.product_count(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 10:
                            builder.cart_price(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 11:
                            builder.price(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.subtotal(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            continue;
                    }
                } else {
                    builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final OrderItemsData redact(OrderItemsData orderItemsData) {
            Builder newBuilder = orderItemsData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
