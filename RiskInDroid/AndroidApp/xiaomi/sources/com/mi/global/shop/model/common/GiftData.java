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
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class GiftData extends Message<GiftData, Builder> {
    public static final ProtoAdapter<GiftData> ADAPTER = new ProtoAdapter_GiftData();
    public static final Integer DEFAULT_NUM = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 53)
    public final String actId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 56)
    public final String activity_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String commodity_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 27)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String itemId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer num;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 23)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 18)
    public final String salePrice;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 57)
    public final String salePrice_txt;
    @WireField(adapter = "com.mi.global.shop.model.common.SelecInfoData#ADAPTER", label = WireField.Label.REPEATED, tag = 52)
    public final List<SelecInfoData> selecInfo;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String subtotal;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 58)
    public final String subtotal_txt;

    public GiftData(String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List<SelecInfoData> list, String str7, String str8, String str9, String str10) {
        this(str, num2, str2, str3, str4, str5, str6, list, str7, str8, str9, str10, ByteString.O00000Oo);
    }

    public GiftData(String str, Integer num2, String str2, String str3, String str4, String str5, String str6, List<SelecInfoData> list, String str7, String str8, String str9, String str10, ByteString byteString) {
        super(ADAPTER, byteString);
        this.itemId = str;
        this.num = num2;
        this.commodity_id = str2;
        this.salePrice = str3;
        this.subtotal = str4;
        this.product_name = str5;
        this.image_url = str6;
        this.selecInfo = Internal.immutableCopyOf("selecInfo", list);
        this.actId = str7;
        this.activity_name = str8;
        this.salePrice_txt = str9;
        this.subtotal_txt = str10;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.itemId = this.itemId;
        builder.num = this.num;
        builder.commodity_id = this.commodity_id;
        builder.salePrice = this.salePrice;
        builder.subtotal = this.subtotal;
        builder.product_name = this.product_name;
        builder.image_url = this.image_url;
        builder.selecInfo = Internal.copyOf("selecInfo", this.selecInfo);
        builder.actId = this.actId;
        builder.activity_name = this.activity_name;
        builder.salePrice_txt = this.salePrice_txt;
        builder.subtotal_txt = this.subtotal_txt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GiftData)) {
            return false;
        }
        GiftData giftData = (GiftData) obj;
        return Internal.equals(unknownFields(), giftData.unknownFields()) && Internal.equals(this.itemId, giftData.itemId) && Internal.equals(this.num, giftData.num) && Internal.equals(this.commodity_id, giftData.commodity_id) && Internal.equals(this.salePrice, giftData.salePrice) && Internal.equals(this.subtotal, giftData.subtotal) && Internal.equals(this.product_name, giftData.product_name) && Internal.equals(this.image_url, giftData.image_url) && Internal.equals(this.selecInfo, giftData.selecInfo) && Internal.equals(this.actId, giftData.actId) && Internal.equals(this.activity_name, giftData.activity_name) && Internal.equals(this.salePrice_txt, giftData.salePrice_txt) && Internal.equals(this.subtotal_txt, giftData.subtotal_txt);
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
        Integer num2 = this.num;
        int hashCode3 = (hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str2 = this.commodity_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.salePrice;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.subtotal;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.product_name;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.image_url;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 37;
        List<SelecInfoData> list = this.selecInfo;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 1)) * 37;
        String str7 = this.actId;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.activity_name;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.salePrice_txt;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.subtotal_txt;
        if (str10 != null) {
            i2 = str10.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.itemId != null) {
            sb.append(", itemId=");
            sb.append(this.itemId);
        }
        if (this.num != null) {
            sb.append(", num=");
            sb.append(this.num);
        }
        if (this.commodity_id != null) {
            sb.append(", commodity_id=");
            sb.append(this.commodity_id);
        }
        if (this.salePrice != null) {
            sb.append(", salePrice=");
            sb.append(this.salePrice);
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
        if (this.selecInfo != null) {
            sb.append(", selecInfo=");
            sb.append(this.selecInfo);
        }
        if (this.actId != null) {
            sb.append(", actId=");
            sb.append(this.actId);
        }
        if (this.activity_name != null) {
            sb.append(", activity_name=");
            sb.append(this.activity_name);
        }
        if (this.salePrice_txt != null) {
            sb.append(", salePrice_txt=");
            sb.append(this.salePrice_txt);
        }
        if (this.subtotal_txt != null) {
            sb.append(", subtotal_txt=");
            sb.append(this.subtotal_txt);
        }
        StringBuilder replace = sb.replace(0, 2, "GiftData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<GiftData, Builder> {
        public String actId;
        public String activity_name;
        public String commodity_id;
        public String image_url;
        public String itemId;
        public Integer num;
        public String product_name;
        public String salePrice;
        public String salePrice_txt;
        public List<SelecInfoData> selecInfo = Internal.newMutableList();
        public String subtotal;
        public String subtotal_txt;

        public final Builder itemId(String str) {
            this.itemId = str;
            return this;
        }

        public final Builder num(Integer num2) {
            this.num = num2;
            return this;
        }

        public final Builder commodity_id(String str) {
            this.commodity_id = str;
            return this;
        }

        public final Builder salePrice(String str) {
            this.salePrice = str;
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

        public final Builder selecInfo(List<SelecInfoData> list) {
            Internal.checkElementsNotNull(list);
            this.selecInfo = list;
            return this;
        }

        public final Builder actId(String str) {
            this.actId = str;
            return this;
        }

        public final Builder activity_name(String str) {
            this.activity_name = str;
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

        public final GiftData build() {
            return new GiftData(this.itemId, this.num, this.commodity_id, this.salePrice, this.subtotal, this.product_name, this.image_url, this.selecInfo, this.actId, this.activity_name, this.salePrice_txt, this.subtotal_txt, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_GiftData extends ProtoAdapter<GiftData> {
        ProtoAdapter_GiftData() {
            super(FieldEncoding.LENGTH_DELIMITED, GiftData.class);
        }

        public final int encodedSize(GiftData giftData) {
            int i = 0;
            int encodedSizeWithTag = (giftData.itemId != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, giftData.itemId) : 0) + (giftData.num != null ? ProtoAdapter.INT32.encodedSizeWithTag(5, giftData.num) : 0) + (giftData.commodity_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, giftData.commodity_id) : 0) + (giftData.salePrice != null ? ProtoAdapter.STRING.encodedSizeWithTag(18, giftData.salePrice) : 0) + (giftData.subtotal != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, giftData.subtotal) : 0) + (giftData.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(23, giftData.product_name) : 0) + (giftData.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(27, giftData.image_url) : 0) + SelecInfoData.ADAPTER.asRepeated().encodedSizeWithTag(52, giftData.selecInfo) + (giftData.actId != null ? ProtoAdapter.STRING.encodedSizeWithTag(53, giftData.actId) : 0) + (giftData.activity_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(56, giftData.activity_name) : 0) + (giftData.salePrice_txt != null ? ProtoAdapter.STRING.encodedSizeWithTag(57, giftData.salePrice_txt) : 0);
            if (giftData.subtotal_txt != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(58, giftData.subtotal_txt);
            }
            return encodedSizeWithTag + i + giftData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, GiftData giftData) throws IOException {
            if (giftData.itemId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, giftData.itemId);
            }
            if (giftData.num != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 5, giftData.num);
            }
            if (giftData.commodity_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, giftData.commodity_id);
            }
            if (giftData.salePrice != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 18, giftData.salePrice);
            }
            if (giftData.subtotal != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, giftData.subtotal);
            }
            if (giftData.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 23, giftData.product_name);
            }
            if (giftData.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 27, giftData.image_url);
            }
            if (giftData.selecInfo != null) {
                SelecInfoData.ADAPTER.asRepeated().encodeWithTag(protoWriter, 52, giftData.selecInfo);
            }
            if (giftData.actId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 53, giftData.actId);
            }
            if (giftData.activity_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 56, giftData.activity_name);
            }
            if (giftData.salePrice_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 57, giftData.salePrice_txt);
            }
            if (giftData.subtotal_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 58, giftData.subtotal_txt);
            }
            protoWriter.writeBytes(giftData.unknownFields());
        }

        public final GiftData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.itemId(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 5) {
                    builder.num(ProtoAdapter.INT32.decode(protoReader));
                } else if (nextTag == 12) {
                    builder.commodity_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 23) {
                    builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 27) {
                    builder.image_url(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 18) {
                    builder.salePrice(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 19) {
                    builder.subtotal(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 52) {
                    builder.selecInfo.add(SelecInfoData.ADAPTER.decode(protoReader));
                } else if (nextTag != 53) {
                    switch (nextTag) {
                        case 56:
                            builder.activity_name(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 57:
                            builder.salePrice_txt(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 58:
                            builder.subtotal_txt(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            continue;
                    }
                } else {
                    builder.actId(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final GiftData redact(GiftData giftData) {
            Builder newBuilder = giftData.newBuilder();
            Internal.redactElements(newBuilder.selecInfo, SelecInfoData.ADAPTER);
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
