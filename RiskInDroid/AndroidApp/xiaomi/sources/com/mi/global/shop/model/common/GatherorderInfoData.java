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

public final class GatherorderInfoData extends Message<GatherorderInfoData, Builder> {
    public static final ProtoAdapter<GatherorderInfoData> ADAPTER = new ProtoAdapter_GatherorderInfoData();
    public static final Boolean DEFAULT_SHOW_LIST = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String balance_price;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", label = WireField.Label.REPEATED, tag = 3)
    public final List<String> goods_list;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean show_list;

    public GatherorderInfoData(String str, Boolean bool, List<String> list) {
        this(str, bool, list, ByteString.O00000Oo);
    }

    public GatherorderInfoData(String str, Boolean bool, List<String> list, ByteString byteString) {
        super(ADAPTER, byteString);
        this.balance_price = str;
        this.show_list = bool;
        this.goods_list = Internal.immutableCopyOf("goods_list", list);
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.balance_price = this.balance_price;
        builder.show_list = this.show_list;
        builder.goods_list = Internal.copyOf("goods_list", this.goods_list);
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GatherorderInfoData)) {
            return false;
        }
        GatherorderInfoData gatherorderInfoData = (GatherorderInfoData) obj;
        return Internal.equals(unknownFields(), gatherorderInfoData.unknownFields()) && Internal.equals(this.balance_price, gatherorderInfoData.balance_price) && Internal.equals(this.show_list, gatherorderInfoData.show_list) && Internal.equals(this.goods_list, gatherorderInfoData.goods_list);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.balance_price;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.show_list;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = (hashCode2 + i2) * 37;
        List<String> list = this.goods_list;
        int hashCode3 = i3 + (list != null ? list.hashCode() : 1);
        this.hashCode = hashCode3;
        return hashCode3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.balance_price != null) {
            sb.append(", balance_price=");
            sb.append(this.balance_price);
        }
        if (this.show_list != null) {
            sb.append(", show_list=");
            sb.append(this.show_list);
        }
        if (this.goods_list != null) {
            sb.append(", goods_list=");
            sb.append(this.goods_list);
        }
        StringBuilder replace = sb.replace(0, 2, "GatherorderInfoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<GatherorderInfoData, Builder> {
        public String balance_price;
        public List<String> goods_list = Internal.newMutableList();
        public Boolean show_list;

        public final Builder balance_price(String str) {
            this.balance_price = str;
            return this;
        }

        public final Builder show_list(Boolean bool) {
            this.show_list = bool;
            return this;
        }

        public final Builder goods_list(List<String> list) {
            Internal.checkElementsNotNull(list);
            this.goods_list = list;
            return this;
        }

        public final GatherorderInfoData build() {
            return new GatherorderInfoData(this.balance_price, this.show_list, this.goods_list, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_GatherorderInfoData extends ProtoAdapter<GatherorderInfoData> {
        ProtoAdapter_GatherorderInfoData() {
            super(FieldEncoding.LENGTH_DELIMITED, GatherorderInfoData.class);
        }

        public final int encodedSize(GatherorderInfoData gatherorderInfoData) {
            int i = 0;
            int encodedSizeWithTag = gatherorderInfoData.balance_price != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, gatherorderInfoData.balance_price) : 0;
            if (gatherorderInfoData.show_list != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(2, gatherorderInfoData.show_list);
            }
            return encodedSizeWithTag + i + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, gatherorderInfoData.goods_list) + gatherorderInfoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, GatherorderInfoData gatherorderInfoData) throws IOException {
            if (gatherorderInfoData.balance_price != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, gatherorderInfoData.balance_price);
            }
            if (gatherorderInfoData.show_list != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, gatherorderInfoData.show_list);
            }
            if (gatherorderInfoData.goods_list != null) {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(protoWriter, 3, gatherorderInfoData.goods_list);
            }
            protoWriter.writeBytes(gatherorderInfoData.unknownFields());
        }

        public final GatherorderInfoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.balance_price(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.show_list(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.goods_list.add(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final GatherorderInfoData redact(GatherorderInfoData gatherorderInfoData) {
            Builder newBuilder = gatherorderInfoData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
