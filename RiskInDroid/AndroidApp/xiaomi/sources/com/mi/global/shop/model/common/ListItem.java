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
import okio.ByteString;

public final class ListItem extends Message<ListItem, Builder> {
    public static final ProtoAdapter<ListItem> ADAPTER = new ProtoAdapter_ListItem();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String cart_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String commodity_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String goods_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String product_count;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String product_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String subtotal;

    public ListItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this(str, str2, str3, str4, str5, str6, str7, str8, str9, ByteString.O00000Oo);
    }

    public ListItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, ByteString byteString) {
        super(ADAPTER, byteString);
        this.product_id = str;
        this.commodity_id = str2;
        this.goods_id = str3;
        this.product_name = str4;
        this.image_url = str5;
        this.product_count = str6;
        this.price = str7;
        this.subtotal = str8;
        this.cart_price = str9;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.product_id = this.product_id;
        builder.commodity_id = this.commodity_id;
        builder.goods_id = this.goods_id;
        builder.product_name = this.product_name;
        builder.image_url = this.image_url;
        builder.product_count = this.product_count;
        builder.price = this.price;
        builder.subtotal = this.subtotal;
        builder.cart_price = this.cart_price;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ListItem)) {
            return false;
        }
        ListItem listItem = (ListItem) obj;
        return Internal.equals(unknownFields(), listItem.unknownFields()) && Internal.equals(this.product_id, listItem.product_id) && Internal.equals(this.commodity_id, listItem.commodity_id) && Internal.equals(this.goods_id, listItem.goods_id) && Internal.equals(this.product_name, listItem.product_name) && Internal.equals(this.image_url, listItem.image_url) && Internal.equals(this.product_count, listItem.product_count) && Internal.equals(this.price, listItem.price) && Internal.equals(this.subtotal, listItem.subtotal) && Internal.equals(this.cart_price, listItem.cart_price);
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
        String str2 = this.commodity_id;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.goods_id;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.product_name;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.image_url;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.product_count;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.price;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.subtotal;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.cart_price;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        int i3 = hashCode9 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.product_id != null) {
            sb.append(", product_id=");
            sb.append(this.product_id);
        }
        if (this.commodity_id != null) {
            sb.append(", commodity_id=");
            sb.append(this.commodity_id);
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
        if (this.price != null) {
            sb.append(", price=");
            sb.append(this.price);
        }
        if (this.subtotal != null) {
            sb.append(", subtotal=");
            sb.append(this.subtotal);
        }
        if (this.cart_price != null) {
            sb.append(", cart_price=");
            sb.append(this.cart_price);
        }
        StringBuilder replace = sb.replace(0, 2, "ListItem{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ListItem, Builder> {
        public String cart_price;
        public String commodity_id;
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

        public final Builder commodity_id(String str) {
            this.commodity_id = str;
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

        public final Builder price(String str) {
            this.price = str;
            return this;
        }

        public final Builder subtotal(String str) {
            this.subtotal = str;
            return this;
        }

        public final Builder cart_price(String str) {
            this.cart_price = str;
            return this;
        }

        public final ListItem build() {
            return new ListItem(this.product_id, this.commodity_id, this.goods_id, this.product_name, this.image_url, this.product_count, this.price, this.subtotal, this.cart_price, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ListItem extends ProtoAdapter<ListItem> {
        ProtoAdapter_ListItem() {
            super(FieldEncoding.LENGTH_DELIMITED, ListItem.class);
        }

        public final int encodedSize(ListItem listItem) {
            int i = 0;
            int encodedSizeWithTag = (listItem.product_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, listItem.product_id) : 0) + (listItem.commodity_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, listItem.commodity_id) : 0) + (listItem.goods_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, listItem.goods_id) : 0) + (listItem.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, listItem.product_name) : 0) + (listItem.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, listItem.image_url) : 0) + (listItem.product_count != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, listItem.product_count) : 0) + (listItem.price != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, listItem.price) : 0) + (listItem.subtotal != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, listItem.subtotal) : 0);
            if (listItem.cart_price != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(9, listItem.cart_price);
            }
            return encodedSizeWithTag + i + listItem.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ListItem listItem) throws IOException {
            if (listItem.product_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, listItem.product_id);
            }
            if (listItem.commodity_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, listItem.commodity_id);
            }
            if (listItem.goods_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, listItem.goods_id);
            }
            if (listItem.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, listItem.product_name);
            }
            if (listItem.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, listItem.image_url);
            }
            if (listItem.product_count != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, listItem.product_count);
            }
            if (listItem.price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, listItem.price);
            }
            if (listItem.subtotal != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, listItem.subtotal);
            }
            if (listItem.cart_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, listItem.cart_price);
            }
            protoWriter.writeBytes(listItem.unknownFields());
        }

        public final ListItem decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.product_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.commodity_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.goods_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 5:
                            builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.product_count(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.price(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.subtotal(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.cart_price(ProtoAdapter.STRING.decode(protoReader));
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

        public final ListItem redact(ListItem listItem) {
            Builder newBuilder = listItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
