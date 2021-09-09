package com.mi.global.shop.model.common;

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
import okio.ByteString;

public final class ListProduct extends Message<ListProduct, Builder> {
    public static final ProtoAdapter<ListProduct> ADAPTER = new ProtoAdapter_ListProduct();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String cart_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String commodity_id;
    @WireField(adapter = "com.mi.global.shop.model.common.Extentions#ADAPTER", tag = 9)
    public final Extentions extentions;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String goods_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String image_url;
    @WireField(adapter = "com.mi.global.shop.model.common.ListItem#ADAPTER", label = WireField.Label.REPEATED, tag = 10)
    public final List<ListItem> list;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String price_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String product_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String product_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String subtotal_txt;

    public ListProduct(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Extentions extentions2, List<ListItem> list2, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, extentions2, list2, str9, ByteString.O00000Oo);
    }

    public ListProduct(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, Extentions extentions2, List<ListItem> list2, String str9, ByteString byteString) {
        super(ADAPTER, byteString);
        this.goods_id = str;
        this.product_id = str2;
        this.image_url = str3;
        this.product_name = str4;
        this.cart_price = str5;
        this.product_count = str6;
        this.price_txt = str7;
        this.subtotal_txt = str8;
        this.extentions = extentions2;
        this.list = Internal.immutableCopyOf("list", list2);
        this.commodity_id = str9;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.goods_id = this.goods_id;
        builder.product_id = this.product_id;
        builder.image_url = this.image_url;
        builder.product_name = this.product_name;
        builder.cart_price = this.cart_price;
        builder.product_count = this.product_count;
        builder.price_txt = this.price_txt;
        builder.subtotal_txt = this.subtotal_txt;
        builder.extentions = this.extentions;
        builder.list = Internal.copyOf("list", this.list);
        builder.commodity_id = this.commodity_id;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListProduct)) {
            return false;
        }
        ListProduct listProduct = (ListProduct) obj;
        return Internal.equals(unknownFields(), listProduct.unknownFields()) && Internal.equals(this.goods_id, listProduct.goods_id) && Internal.equals(this.product_id, listProduct.product_id) && Internal.equals(this.image_url, listProduct.image_url) && Internal.equals(this.product_name, listProduct.product_name) && Internal.equals(this.cart_price, listProduct.cart_price) && Internal.equals(this.product_count, listProduct.product_count) && Internal.equals(this.price_txt, listProduct.price_txt) && Internal.equals(this.subtotal_txt, listProduct.subtotal_txt) && Internal.equals(this.extentions, listProduct.extentions) && Internal.equals(this.list, listProduct.list) && Internal.equals(this.commodity_id, listProduct.commodity_id);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.goods_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.product_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.image_url;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.product_name;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.cart_price;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.product_count;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.price_txt;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.subtotal_txt;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Extentions extentions2 = this.extentions;
        int hashCode10 = (hashCode9 + (extentions2 != null ? extentions2.hashCode() : 0)) * 37;
        List<ListItem> list2 = this.list;
        int hashCode11 = (hashCode10 + (list2 != null ? list2.hashCode() : 1)) * 37;
        String str9 = this.commodity_id;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode11 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.goods_id != null) {
            sb.append(", goods_id=");
            sb.append(this.goods_id);
        }
        if (this.product_id != null) {
            sb.append(", product_id=");
            sb.append(this.product_id);
        }
        if (this.image_url != null) {
            sb.append(", image_url=");
            sb.append(this.image_url);
        }
        if (this.product_name != null) {
            sb.append(", product_name=");
            sb.append(this.product_name);
        }
        if (this.cart_price != null) {
            sb.append(", cart_price=");
            sb.append(this.cart_price);
        }
        if (this.product_count != null) {
            sb.append(", product_count=");
            sb.append(this.product_count);
        }
        if (this.price_txt != null) {
            sb.append(", price_txt=");
            sb.append(this.price_txt);
        }
        if (this.subtotal_txt != null) {
            sb.append(", subtotal_txt=");
            sb.append(this.subtotal_txt);
        }
        if (this.extentions != null) {
            sb.append(", extentions=");
            sb.append(this.extentions);
        }
        if (this.list != null) {
            sb.append(", list=");
            sb.append(this.list);
        }
        if (this.commodity_id != null) {
            sb.append(", commodity_id=");
            sb.append(this.commodity_id);
        }
        StringBuilder replace = sb.replace(0, 2, "ListProduct{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ListProduct, Builder> {
        public String cart_price;
        public String commodity_id;
        public Extentions extentions;
        public String goods_id;
        public String image_url;
        public List<ListItem> list = Internal.newMutableList();
        public String price_txt;
        public String product_count;
        public String product_id;
        public String product_name;
        public String subtotal_txt;

        public final Builder goods_id(String str) {
            this.goods_id = str;
            return this;
        }

        public final Builder product_id(String str) {
            this.product_id = str;
            return this;
        }

        public final Builder image_url(String str) {
            this.image_url = str;
            return this;
        }

        public final Builder product_name(String str) {
            this.product_name = str;
            return this;
        }

        public final Builder cart_price(String str) {
            this.cart_price = str;
            return this;
        }

        public final Builder product_count(String str) {
            this.product_count = str;
            return this;
        }

        public final Builder price_txt(String str) {
            this.price_txt = str;
            return this;
        }

        public final Builder subtotal_txt(String str) {
            this.subtotal_txt = str;
            return this;
        }

        public final Builder extentions(Extentions extentions2) {
            this.extentions = extentions2;
            return this;
        }

        public final Builder list(List<ListItem> list2) {
            Internal.checkElementsNotNull(list2);
            this.list = list2;
            return this;
        }

        public final Builder commodity_id(String str) {
            this.commodity_id = str;
            return this;
        }

        public final ListProduct build() {
            return new ListProduct(this.goods_id, this.product_id, this.image_url, this.product_name, this.cart_price, this.product_count, this.price_txt, this.subtotal_txt, this.extentions, this.list, this.commodity_id, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ListProduct extends ProtoAdapter<ListProduct> {
        ProtoAdapter_ListProduct() {
            super(FieldEncoding.LENGTH_DELIMITED, ListProduct.class);
        }

        public final int encodedSize(ListProduct listProduct) {
            int i = 0;
            int encodedSizeWithTag = (listProduct.goods_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, listProduct.goods_id) : 0) + (listProduct.product_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, listProduct.product_id) : 0) + (listProduct.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, listProduct.image_url) : 0) + (listProduct.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, listProduct.product_name) : 0) + (listProduct.cart_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, listProduct.cart_price) : 0) + (listProduct.product_count != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, listProduct.product_count) : 0) + (listProduct.price_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, listProduct.price_txt) : 0) + (listProduct.subtotal_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, listProduct.subtotal_txt) : 0) + (listProduct.extentions != null ? Extentions.ADAPTER.encodedSizeWithTag(9, listProduct.extentions) : 0) + ListItem.ADAPTER.asRepeated().encodedSizeWithTag(10, listProduct.list);
            if (listProduct.commodity_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(11, listProduct.commodity_id);
            }
            return encodedSizeWithTag + i + listProduct.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ListProduct listProduct) throws IOException {
            if (listProduct.goods_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, listProduct.goods_id);
            }
            if (listProduct.product_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, listProduct.product_id);
            }
            if (listProduct.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, listProduct.image_url);
            }
            if (listProduct.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, listProduct.product_name);
            }
            if (listProduct.cart_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, listProduct.cart_price);
            }
            if (listProduct.product_count != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, listProduct.product_count);
            }
            if (listProduct.price_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, listProduct.price_txt);
            }
            if (listProduct.subtotal_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, listProduct.subtotal_txt);
            }
            if (listProduct.extentions != null) {
                Extentions.ADAPTER.encodeWithTag(protoWriter, 9, listProduct.extentions);
            }
            if (listProduct.list != null) {
                ListItem.ADAPTER.asRepeated().encodeWithTag(protoWriter, 10, listProduct.list);
            }
            if (listProduct.commodity_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, listProduct.commodity_id);
            }
            protoWriter.writeBytes(listProduct.unknownFields());
        }

        public final ListProduct decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.goods_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.product_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.cart_price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.product_count(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.price_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.subtotal_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.extentions(Extentions.ADAPTER.decode(protoReader));
                            break;
                        case 10:
                            builder.list.add(ListItem.ADAPTER.decode(protoReader));
                            break;
                        case 11:
                            builder.commodity_id(ProtoAdapter.STRING.decode(protoReader));
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

        public final ListProduct redact(ListProduct listProduct) {
            Builder newBuilder = listProduct.newBuilder();
            if (newBuilder.extentions != null) {
                newBuilder.extentions = Extentions.ADAPTER.redact(newBuilder.extentions);
            }
            Internal.redactElements(newBuilder.list, ListItem.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
