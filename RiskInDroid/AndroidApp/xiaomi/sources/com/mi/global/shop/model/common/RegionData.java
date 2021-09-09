package com.mi.global.shop.model.common;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class RegionData extends Message<RegionData, Builder> {
    public static final ProtoAdapter<RegionData> ADAPTER = new ProtoAdapter_RegionData();
    public static final Integer DEFAULT_CAN_COD = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer can_cod;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String region_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String region_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String zipcode;

    public RegionData(String str, String str2, String str3, Integer num) {
        this(str, str2, str3, num, ByteString.O00000Oo);
    }

    public RegionData(String str, String str2, String str3, Integer num, ByteString byteString) {
        super(ADAPTER, byteString);
        this.region_id = str;
        this.region_name = str2;
        this.zipcode = str3;
        this.can_cod = num;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.region_id = this.region_id;
        builder.region_name = this.region_name;
        builder.zipcode = this.zipcode;
        builder.can_cod = this.can_cod;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RegionData)) {
            return false;
        }
        RegionData regionData = (RegionData) obj;
        return Internal.equals(unknownFields(), regionData.unknownFields()) && Internal.equals(this.region_id, regionData.region_id) && Internal.equals(this.region_name, regionData.region_name) && Internal.equals(this.zipcode, regionData.zipcode) && Internal.equals(this.can_cod, regionData.can_cod);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.region_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.region_name;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.zipcode;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Integer num = this.can_cod;
        if (num != null) {
            i2 = num.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.region_id != null) {
            sb.append(", region_id=");
            sb.append(this.region_id);
        }
        if (this.region_name != null) {
            sb.append(", region_name=");
            sb.append(this.region_name);
        }
        if (this.zipcode != null) {
            sb.append(", zipcode=");
            sb.append(this.zipcode);
        }
        if (this.can_cod != null) {
            sb.append(", can_cod=");
            sb.append(this.can_cod);
        }
        StringBuilder replace = sb.replace(0, 2, "RegionData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<RegionData, Builder> {
        public Integer can_cod;
        public String region_id;
        public String region_name;
        public String zipcode;

        public final Builder region_id(String str) {
            this.region_id = str;
            return this;
        }

        public final Builder region_name(String str) {
            this.region_name = str;
            return this;
        }

        public final Builder zipcode(String str) {
            this.zipcode = str;
            return this;
        }

        public final Builder can_cod(Integer num) {
            this.can_cod = num;
            return this;
        }

        public final RegionData build() {
            return new RegionData(this.region_id, this.region_name, this.zipcode, this.can_cod, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_RegionData extends ProtoAdapter<RegionData> {
        ProtoAdapter_RegionData() {
            super(FieldEncoding.LENGTH_DELIMITED, RegionData.class);
        }

        public final int encodedSize(RegionData regionData) {
            int i = 0;
            int encodedSizeWithTag = (regionData.region_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, regionData.region_id) : 0) + (regionData.region_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, regionData.region_name) : 0) + (regionData.zipcode != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, regionData.zipcode) : 0);
            if (regionData.can_cod != null) {
                i = ProtoAdapter.INT32.encodedSizeWithTag(4, regionData.can_cod);
            }
            return encodedSizeWithTag + i + regionData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, RegionData regionData) throws IOException {
            if (regionData.region_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, regionData.region_id);
            }
            if (regionData.region_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, regionData.region_name);
            }
            if (regionData.zipcode != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, regionData.zipcode);
            }
            if (regionData.can_cod != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 4, regionData.can_cod);
            }
            protoWriter.writeBytes(regionData.unknownFields());
        }

        public final RegionData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.region_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.region_name(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.zipcode(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.can_cod(ProtoAdapter.INT32.decode(protoReader));
                }
            }
        }

        public final RegionData redact(RegionData regionData) {
            Builder newBuilder = regionData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
