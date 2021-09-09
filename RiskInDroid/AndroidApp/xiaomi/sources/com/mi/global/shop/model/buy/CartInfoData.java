package com.mi.global.shop.model.buy;

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

public final class CartInfoData extends Message<CartInfoData, Builder> {
    public static final ProtoAdapter<CartInfoData> ADAPTER = new ProtoAdapter_CartInfoData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String activityDiscountMoney;
    @WireField(adapter = "com.mi.global.shop.model.buy.ItemsData#ADAPTER", label = WireField.Label.REPEATED, tag = 1)
    public final List<ItemsData> items;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String productMoney;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String productMoney_txt;

    public CartInfoData(List<ItemsData> list, String str, String str2, String str3) {
        this(list, str, str2, str3, ByteString.O00000Oo);
    }

    public CartInfoData(List<ItemsData> list, String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.items = Internal.immutableCopyOf("items", list);
        this.productMoney = str;
        this.activityDiscountMoney = str2;
        this.productMoney_txt = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.items = Internal.copyOf("items", this.items);
        builder.productMoney = this.productMoney;
        builder.activityDiscountMoney = this.activityDiscountMoney;
        builder.productMoney_txt = this.productMoney_txt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CartInfoData)) {
            return false;
        }
        CartInfoData cartInfoData = (CartInfoData) obj;
        return Internal.equals(unknownFields(), cartInfoData.unknownFields()) && Internal.equals(this.items, cartInfoData.items) && Internal.equals(this.productMoney, cartInfoData.productMoney) && Internal.equals(this.activityDiscountMoney, cartInfoData.activityDiscountMoney) && Internal.equals(this.productMoney_txt, cartInfoData.productMoney_txt);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        List<ItemsData> list = this.items;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 1)) * 37;
        String str = this.productMoney;
        int i2 = 0;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.activityDiscountMoney;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.productMoney_txt;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.items != null) {
            sb.append(", items=");
            sb.append(this.items);
        }
        if (this.productMoney != null) {
            sb.append(", productMoney=");
            sb.append(this.productMoney);
        }
        if (this.activityDiscountMoney != null) {
            sb.append(", activityDiscountMoney=");
            sb.append(this.activityDiscountMoney);
        }
        if (this.productMoney_txt != null) {
            sb.append(", productMoney_txt=");
            sb.append(this.productMoney_txt);
        }
        StringBuilder replace = sb.replace(0, 2, "CartInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<CartInfoData, Builder> {
        public String activityDiscountMoney;
        public List<ItemsData> items = Internal.newMutableList();
        public String productMoney;
        public String productMoney_txt;

        public final Builder items(List<ItemsData> list) {
            Internal.checkElementsNotNull(list);
            this.items = list;
            return this;
        }

        public final Builder productMoney(String str) {
            this.productMoney = str;
            return this;
        }

        public final Builder activityDiscountMoney(String str) {
            this.activityDiscountMoney = str;
            return this;
        }

        public final Builder productMoney_txt(String str) {
            this.productMoney_txt = str;
            return this;
        }

        public final CartInfoData build() {
            return new CartInfoData(this.items, this.productMoney, this.activityDiscountMoney, this.productMoney_txt, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_CartInfoData extends ProtoAdapter<CartInfoData> {
        ProtoAdapter_CartInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, CartInfoData.class);
        }

        public final int encodedSize(CartInfoData cartInfoData) {
            int i = 0;
            int encodedSizeWithTag = ItemsData.ADAPTER.asRepeated().encodedSizeWithTag(1, cartInfoData.items) + (cartInfoData.productMoney != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, cartInfoData.productMoney) : 0) + (cartInfoData.activityDiscountMoney != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, cartInfoData.activityDiscountMoney) : 0);
            if (cartInfoData.productMoney_txt != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, cartInfoData.productMoney_txt);
            }
            return encodedSizeWithTag + i + cartInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, CartInfoData cartInfoData) throws IOException {
            if (cartInfoData.items != null) {
                ItemsData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 1, cartInfoData.items);
            }
            if (cartInfoData.productMoney != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, cartInfoData.productMoney);
            }
            if (cartInfoData.activityDiscountMoney != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, cartInfoData.activityDiscountMoney);
            }
            if (cartInfoData.productMoney_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, cartInfoData.productMoney_txt);
            }
            protoWriter.writeBytes(cartInfoData.unknownFields());
        }

        public final CartInfoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.items.add(ItemsData.ADAPTER.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.productMoney(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.activityDiscountMoney(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.productMoney_txt(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final CartInfoData redact(CartInfoData cartInfoData) {
            Builder newBuilder = cartInfoData.newBuilder();
            Internal.redactElements(newBuilder.items, ItemsData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
