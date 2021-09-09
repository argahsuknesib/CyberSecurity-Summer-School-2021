package com.mi.global.shop.model.buy;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
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

public final class ItemsData extends Message<ItemsData, Builder> {
    public static final ProtoAdapter<ItemsData> ADAPTER = new ProtoAdapter_ItemsData();
    public static final Boolean DEFAULT_ISINSURANCE = Boolean.FALSE;
    public static final Boolean DEFAULT_ITEM_TIMEOUT = Boolean.FALSE;
    public static final Integer DEFAULT_NUM = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String commodity_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String getType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String goodsId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String goods_dealer;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 17)
    public final Boolean isInsurance;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String itemId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final Boolean item_timeout;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String item_type_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer num;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String product_name;
    @WireField(adapter = "com.mi.global.shop.model.buy.PropertiesData#ADAPTER", tag = 16)
    public final PropertiesData properties;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String salePrice;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String salePrice_txt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String showType;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String subtotal;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String subtotal_txt;

    public ItemsData(String str, String str2, String str3, Integer num2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, PropertiesData propertiesData, Boolean bool2) {
        this(str, str2, str3, num2, str4, str5, str6, str7, str8, str9, str10, bool, str11, str12, str13, propertiesData, bool2, ByteString.O00000Oo);
    }

    public ItemsData(String str, String str2, String str3, Integer num2, String str4, String str5, String str6, String str7, String str8, String str9, String str10, Boolean bool, String str11, String str12, String str13, PropertiesData propertiesData, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.itemId = str;
        this.goodsId = str2;
        this.getType = str3;
        this.num = num2;
        this.salePrice = str4;
        this.commodity_id = str5;
        this.goods_dealer = str6;
        this.subtotal = str7;
        this.product_name = str8;
        this.image_url = str9;
        this.showType = str10;
        this.item_timeout = bool;
        this.item_type_name = str11;
        this.salePrice_txt = str12;
        this.subtotal_txt = str13;
        this.properties = propertiesData;
        this.isInsurance = bool2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.itemId = this.itemId;
        builder.goodsId = this.goodsId;
        builder.getType = this.getType;
        builder.num = this.num;
        builder.salePrice = this.salePrice;
        builder.commodity_id = this.commodity_id;
        builder.goods_dealer = this.goods_dealer;
        builder.subtotal = this.subtotal;
        builder.product_name = this.product_name;
        builder.image_url = this.image_url;
        builder.showType = this.showType;
        builder.item_timeout = this.item_timeout;
        builder.item_type_name = this.item_type_name;
        builder.salePrice_txt = this.salePrice_txt;
        builder.subtotal_txt = this.subtotal_txt;
        builder.properties = this.properties;
        builder.isInsurance = this.isInsurance;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ItemsData)) {
            return false;
        }
        ItemsData itemsData = (ItemsData) obj;
        return Internal.equals(unknownFields(), itemsData.unknownFields()) && Internal.equals(this.itemId, itemsData.itemId) && Internal.equals(this.goodsId, itemsData.goodsId) && Internal.equals(this.getType, itemsData.getType) && Internal.equals(this.num, itemsData.num) && Internal.equals(this.salePrice, itemsData.salePrice) && Internal.equals(this.commodity_id, itemsData.commodity_id) && Internal.equals(this.goods_dealer, itemsData.goods_dealer) && Internal.equals(this.subtotal, itemsData.subtotal) && Internal.equals(this.product_name, itemsData.product_name) && Internal.equals(this.image_url, itemsData.image_url) && Internal.equals(this.showType, itemsData.showType) && Internal.equals(this.item_timeout, itemsData.item_timeout) && Internal.equals(this.item_type_name, itemsData.item_type_name) && Internal.equals(this.salePrice_txt, itemsData.salePrice_txt) && Internal.equals(this.subtotal_txt, itemsData.subtotal_txt) && Internal.equals(this.properties, itemsData.properties) && Internal.equals(this.isInsurance, itemsData.isInsurance);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.itemId;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.goodsId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.getType;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num2 = this.num;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str4 = this.salePrice;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.commodity_id;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.goods_dealer;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.subtotal;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.product_name;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.image_url;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.showType;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 37;
        Boolean bool = this.item_timeout;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str11 = this.item_type_name;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.salePrice_txt;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.subtotal_txt;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 37;
        PropertiesData propertiesData = this.properties;
        int hashCode17 = (hashCode16 + (propertiesData != null ? propertiesData.hashCode() : 0)) * 37;
        Boolean bool2 = this.isInsurance;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode17 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.itemId != null) {
            sb.append(", itemId=");
            sb.append(this.itemId);
        }
        if (this.goodsId != null) {
            sb.append(", goodsId=");
            sb.append(this.goodsId);
        }
        if (this.getType != null) {
            sb.append(", getType=");
            sb.append(this.getType);
        }
        if (this.num != null) {
            sb.append(", num=");
            sb.append(this.num);
        }
        if (this.salePrice != null) {
            sb.append(", salePrice=");
            sb.append(this.salePrice);
        }
        if (this.commodity_id != null) {
            sb.append(", commodity_id=");
            sb.append(this.commodity_id);
        }
        if (this.goods_dealer != null) {
            sb.append(", goods_dealer=");
            sb.append(this.goods_dealer);
        }
        if (this.subtotal != null) {
            sb.append(", subtotal=");
            sb.append(this.subtotal);
        }
        if (this.product_name != null) {
            sb.append(", product_name=");
            sb.append(this.product_name);
        }
        if (this.image_url != null) {
            sb.append(", image_url=");
            sb.append(this.image_url);
        }
        if (this.showType != null) {
            sb.append(", showType=");
            sb.append(this.showType);
        }
        if (this.item_timeout != null) {
            sb.append(", item_timeout=");
            sb.append(this.item_timeout);
        }
        if (this.item_type_name != null) {
            sb.append(", item_type_name=");
            sb.append(this.item_type_name);
        }
        if (this.salePrice_txt != null) {
            sb.append(", salePrice_txt=");
            sb.append(this.salePrice_txt);
        }
        if (this.subtotal_txt != null) {
            sb.append(", subtotal_txt=");
            sb.append(this.subtotal_txt);
        }
        if (this.properties != null) {
            sb.append(", properties=");
            sb.append(this.properties);
        }
        if (this.isInsurance != null) {
            sb.append(", isInsurance=");
            sb.append(this.isInsurance);
        }
        StringBuilder replace = sb.replace(0, 2, "ItemsData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ItemsData, Builder> {
        public String commodity_id;
        public String getType;
        public String goodsId;
        public String goods_dealer;
        public String image_url;
        public Boolean isInsurance;
        public String itemId;
        public Boolean item_timeout;
        public String item_type_name;
        public Integer num;
        public String product_name;
        public PropertiesData properties;
        public String salePrice;
        public String salePrice_txt;
        public String showType;
        public String subtotal;
        public String subtotal_txt;

        public final Builder itemId(String str) {
            this.itemId = str;
            return this;
        }

        public final Builder goodsId(String str) {
            this.goodsId = str;
            return this;
        }

        public final Builder getType(String str) {
            this.getType = str;
            return this;
        }

        public final Builder num(Integer num2) {
            this.num = num2;
            return this;
        }

        public final Builder salePrice(String str) {
            this.salePrice = str;
            return this;
        }

        public final Builder commodity_id(String str) {
            this.commodity_id = str;
            return this;
        }

        public final Builder goods_dealer(String str) {
            this.goods_dealer = str;
            return this;
        }

        public final Builder subtotal(String str) {
            this.subtotal = str;
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

        public final Builder showType(String str) {
            this.showType = str;
            return this;
        }

        public final Builder item_timeout(Boolean bool) {
            this.item_timeout = bool;
            return this;
        }

        public final Builder item_type_name(String str) {
            this.item_type_name = str;
            return this;
        }

        public final Builder salePrice_txt(String str) {
            this.salePrice_txt = str;
            return this;
        }

        public final Builder subtotal_txt(String str) {
            this.subtotal_txt = str;
            return this;
        }

        public final Builder properties(PropertiesData propertiesData) {
            this.properties = propertiesData;
            return this;
        }

        public final Builder isInsurance(Boolean bool) {
            this.isInsurance = bool;
            return this;
        }

        public final ItemsData build() {
            return new ItemsData(this.itemId, this.goodsId, this.getType, this.num, this.salePrice, this.commodity_id, this.goods_dealer, this.subtotal, this.product_name, this.image_url, this.showType, this.item_timeout, this.item_type_name, this.salePrice_txt, this.subtotal_txt, this.properties, this.isInsurance, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ItemsData extends ProtoAdapter<ItemsData> {
        ProtoAdapter_ItemsData() {
            super(FieldEncoding.LENGTH_DELIMITED, ItemsData.class);
        }

        public final int encodedSize(ItemsData itemsData) {
            int i = 0;
            int encodedSizeWithTag = (itemsData.itemId != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, itemsData.itemId) : 0) + (itemsData.goodsId != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, itemsData.goodsId) : 0) + (itemsData.getType != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, itemsData.getType) : 0) + (itemsData.num != null ? ProtoAdapter.INT32.encodedSizeWithTag(4, itemsData.num) : 0) + (itemsData.salePrice != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, itemsData.salePrice) : 0) + (itemsData.commodity_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, itemsData.commodity_id) : 0) + (itemsData.goods_dealer != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, itemsData.goods_dealer) : 0) + (itemsData.subtotal != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, itemsData.subtotal) : 0) + (itemsData.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, itemsData.product_name) : 0) + (itemsData.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, itemsData.image_url) : 0) + (itemsData.showType != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, itemsData.showType) : 0) + (itemsData.item_timeout != null ? ProtoAdapter.BOOL.encodedSizeWithTag(12, itemsData.item_timeout) : 0) + (itemsData.item_type_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, itemsData.item_type_name) : 0) + (itemsData.salePrice_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, itemsData.salePrice_txt) : 0) + (itemsData.subtotal_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(15, itemsData.subtotal_txt) : 0) + (itemsData.properties != null ? PropertiesData.ADAPTER.encodedSizeWithTag(16, itemsData.properties) : 0);
            if (itemsData.isInsurance != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(17, itemsData.isInsurance);
            }
            return encodedSizeWithTag + i + itemsData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ItemsData itemsData) throws IOException {
            if (itemsData.itemId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, itemsData.itemId);
            }
            if (itemsData.goodsId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, itemsData.goodsId);
            }
            if (itemsData.getType != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, itemsData.getType);
            }
            if (itemsData.num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, itemsData.num);
            }
            if (itemsData.salePrice != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, itemsData.salePrice);
            }
            if (itemsData.commodity_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, itemsData.commodity_id);
            }
            if (itemsData.goods_dealer != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, itemsData.goods_dealer);
            }
            if (itemsData.subtotal != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, itemsData.subtotal);
            }
            if (itemsData.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, itemsData.product_name);
            }
            if (itemsData.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, itemsData.image_url);
            }
            if (itemsData.showType != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, itemsData.showType);
            }
            if (itemsData.item_timeout != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 12, itemsData.item_timeout);
            }
            if (itemsData.item_type_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, itemsData.item_type_name);
            }
            if (itemsData.salePrice_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, itemsData.salePrice_txt);
            }
            if (itemsData.subtotal_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, itemsData.subtotal_txt);
            }
            if (itemsData.properties != null) {
                PropertiesData.ADAPTER.encodeWithTag(protoWriter, 16, itemsData.properties);
            }
            if (itemsData.isInsurance != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 17, itemsData.isInsurance);
            }
            protoWriter.writeBytes(itemsData.unknownFields());
        }

        public final ItemsData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            builder.itemId(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 2:
                            builder.goodsId(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 3:
                            builder.getType(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 4:
                            builder.num(ProtoAdapter.INT32.decode(protoReader));
                            break;
                        case 5:
                            builder.salePrice(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 6:
                            builder.commodity_id(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 7:
                            builder.goods_dealer(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            builder.subtotal(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 9:
                            builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 10:
                            builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 11:
                            builder.showType(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            builder.item_timeout(ProtoAdapter.BOOL.decode(protoReader));
                            break;
                        case 13:
                            builder.item_type_name(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 14:
                            builder.salePrice_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            builder.subtotal_txt(ProtoAdapter.STRING.decode(protoReader));
                            break;
                        case 16:
                            builder.properties(PropertiesData.ADAPTER.decode(protoReader));
                            break;
                        case 17:
                            builder.isInsurance(ProtoAdapter.BOOL.decode(protoReader));
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

        public final ItemsData redact(ItemsData itemsData) {
            Builder newBuilder = itemsData.newBuilder();
            if (newBuilder.properties != null) {
                newBuilder.properties = PropertiesData.ADAPTER.redact(newBuilder.properties);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
