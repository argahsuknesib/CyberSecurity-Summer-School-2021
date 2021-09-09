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

public final class SelecInfoData extends Message<SelecInfoData, Builder> {
    public static final ProtoAdapter<SelecInfoData> ADAPTER = new ProtoAdapter_SelecInfoData();
    public static final Boolean DEFAULT_IS_COS = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 31)
    public final String actId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 9)
    public final List<String> adapt;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String commodity_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 29)
    public final String goodsId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String image_url;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean is_cos;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String product_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String product_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 30)
    public final String salePrice;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 28)
    public final String style_value;

    public SelecInfoData(Boolean bool, String str, String str2, String str3, String str4, List<String> list, String str5, String str6, String str7, String str8) {
        this(bool, str, str2, str3, str4, list, str5, str6, str7, str8, ByteString.O00000Oo);
    }

    public SelecInfoData(Boolean bool, String str, String str2, String str3, String str4, List<String> list, String str5, String str6, String str7, String str8, ByteString byteString) {
        super(ADAPTER, byteString);
        this.is_cos = bool;
        this.product_id = str;
        this.commodity_id = str2;
        this.product_name = str3;
        this.image_url = str4;
        this.adapt = Internal.immutableCopyOf("adapt", list);
        this.style_value = str5;
        this.goodsId = str6;
        this.salePrice = str7;
        this.actId = str8;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.is_cos = this.is_cos;
        builder.product_id = this.product_id;
        builder.commodity_id = this.commodity_id;
        builder.product_name = this.product_name;
        builder.image_url = this.image_url;
        builder.adapt = Internal.copyOf("adapt", this.adapt);
        builder.style_value = this.style_value;
        builder.goodsId = this.goodsId;
        builder.salePrice = this.salePrice;
        builder.actId = this.actId;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SelecInfoData)) {
            return false;
        }
        SelecInfoData selecInfoData = (SelecInfoData) obj;
        return Internal.equals(unknownFields(), selecInfoData.unknownFields()) && Internal.equals(this.is_cos, selecInfoData.is_cos) && Internal.equals(this.product_id, selecInfoData.product_id) && Internal.equals(this.commodity_id, selecInfoData.commodity_id) && Internal.equals(this.product_name, selecInfoData.product_name) && Internal.equals(this.image_url, selecInfoData.image_url) && Internal.equals(this.adapt, selecInfoData.adapt) && Internal.equals(this.style_value, selecInfoData.style_value) && Internal.equals(this.goodsId, selecInfoData.goodsId) && Internal.equals(this.salePrice, selecInfoData.salePrice) && Internal.equals(this.actId, selecInfoData.actId);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.is_cos;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.product_id;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.commodity_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.product_name;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.image_url;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 37;
        List<String> list = this.adapt;
        int hashCode7 = (hashCode6 + (list != null ? list.hashCode() : 1)) * 37;
        String str5 = this.style_value;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.goodsId;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.salePrice;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.actId;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        int i3 = hashCode10 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.is_cos != null) {
            sb.append(", is_cos=");
            sb.append(this.is_cos);
        }
        if (this.product_id != null) {
            sb.append(", product_id=");
            sb.append(this.product_id);
        }
        if (this.commodity_id != null) {
            sb.append(", commodity_id=");
            sb.append(this.commodity_id);
        }
        if (this.product_name != null) {
            sb.append(", product_name=");
            sb.append(this.product_name);
        }
        if (this.image_url != null) {
            sb.append(", image_url=");
            sb.append(this.image_url);
        }
        if (this.adapt != null) {
            sb.append(", adapt=");
            sb.append(this.adapt);
        }
        if (this.style_value != null) {
            sb.append(", style_value=");
            sb.append(this.style_value);
        }
        if (this.goodsId != null) {
            sb.append(", goodsId=");
            sb.append(this.goodsId);
        }
        if (this.salePrice != null) {
            sb.append(", salePrice=");
            sb.append(this.salePrice);
        }
        if (this.actId != null) {
            sb.append(", actId=");
            sb.append(this.actId);
        }
        StringBuilder replace = sb.replace(0, 2, "SelecInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SelecInfoData, Builder> {
        public String actId;
        public List<String> adapt = Internal.newMutableList();
        public String commodity_id;
        public String goodsId;
        public String image_url;
        public Boolean is_cos;
        public String product_id;
        public String product_name;
        public String salePrice;
        public String style_value;

        public final Builder is_cos(Boolean bool) {
            this.is_cos = bool;
            return this;
        }

        public final Builder product_id(String str) {
            this.product_id = str;
            return this;
        }

        public final Builder commodity_id(String str) {
            this.commodity_id = str;
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

        public final Builder adapt(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.adapt = list;
            return this;
        }

        public final Builder style_value(String str) {
            this.style_value = str;
            return this;
        }

        public final Builder goodsId(String str) {
            this.goodsId = str;
            return this;
        }

        public final Builder salePrice(String str) {
            this.salePrice = str;
            return this;
        }

        public final Builder actId(String str) {
            this.actId = str;
            return this;
        }

        public final SelecInfoData build() {
            return new SelecInfoData(this.is_cos, this.product_id, this.commodity_id, this.product_name, this.image_url, this.adapt, this.style_value, this.goodsId, this.salePrice, this.actId, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SelecInfoData extends ProtoAdapter<SelecInfoData> {
        ProtoAdapter_SelecInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, SelecInfoData.class);
        }

        public final int encodedSize(SelecInfoData selecInfoData) {
            int i = 0;
            int encodedSizeWithTag = (selecInfoData.is_cos != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, selecInfoData.is_cos) : 0) + (selecInfoData.product_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, selecInfoData.product_id) : 0) + (selecInfoData.commodity_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, selecInfoData.commodity_id) : 0) + (selecInfoData.product_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, selecInfoData.product_name) : 0) + (selecInfoData.image_url != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, selecInfoData.image_url) : 0) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(9, selecInfoData.adapt) + (selecInfoData.style_value != null ? ProtoAdapter.STRING.encodedSizeWithTag(28, selecInfoData.style_value) : 0) + (selecInfoData.goodsId != null ? ProtoAdapter.STRING.encodedSizeWithTag(29, selecInfoData.goodsId) : 0) + (selecInfoData.salePrice != null ? ProtoAdapter.STRING.encodedSizeWithTag(30, selecInfoData.salePrice) : 0);
            if (selecInfoData.actId != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(31, selecInfoData.actId);
            }
            return encodedSizeWithTag + i + selecInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SelecInfoData selecInfoData) throws IOException {
            if (selecInfoData.is_cos != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, selecInfoData.is_cos);
            }
            if (selecInfoData.product_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, selecInfoData.product_id);
            }
            if (selecInfoData.commodity_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, selecInfoData.commodity_id);
            }
            if (selecInfoData.product_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, selecInfoData.product_name);
            }
            if (selecInfoData.image_url != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, selecInfoData.image_url);
            }
            if (selecInfoData.adapt != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 9, selecInfoData.adapt);
            }
            if (selecInfoData.style_value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 28, selecInfoData.style_value);
            }
            if (selecInfoData.goodsId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 29, selecInfoData.goodsId);
            }
            if (selecInfoData.salePrice != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 30, selecInfoData.salePrice);
            }
            if (selecInfoData.actId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 31, selecInfoData.actId);
            }
            protoWriter.writeBytes(selecInfoData.unknownFields());
        }

        public final SelecInfoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.is_cos(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 9) {
                    builder.adapt.add(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.product_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 4) {
                    builder.commodity_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 5) {
                    builder.product_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 6) {
                    switch (nextTag) {
                        case 28:
                            builder.style_value(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 29:
                            builder.goodsId(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 30:
                            builder.salePrice(ProtoAdapter.STRING.decode(protoReader));
                            continue;
                        case 31:
                            builder.actId(ProtoAdapter.STRING.decode(protoReader));
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

        public final SelecInfoData redact(SelecInfoData selecInfoData) {
            Builder newBuilder = selecInfoData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
