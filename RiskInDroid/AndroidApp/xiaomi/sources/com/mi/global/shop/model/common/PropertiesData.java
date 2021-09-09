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

public final class PropertiesData extends Message<PropertiesData, Builder> {
    public static final ProtoAdapter<PropertiesData> ADAPTER = new ProtoAdapter_PropertiesData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String actDate;
    @WireField(adapter = "com.mi.global.shop.model.common.InsuranceData#ADAPTER", tag = 4)
    public final InsuranceData insurance;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String parent_itemId;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String source;

    public PropertiesData(String str, String str2, String str3, InsuranceData insuranceData) {
        this(str, str2, str3, insuranceData, ByteString.O00000Oo);
    }

    public PropertiesData(String str, String str2, String str3, InsuranceData insuranceData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.parent_itemId = str;
        this.source = str2;
        this.actDate = str3;
        this.insurance = insuranceData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.parent_itemId = this.parent_itemId;
        builder.source = this.source;
        builder.actDate = this.actDate;
        builder.insurance = this.insurance;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PropertiesData)) {
            return false;
        }
        PropertiesData propertiesData = (PropertiesData) obj;
        return Internal.equals(unknownFields(), propertiesData.unknownFields()) && Internal.equals(this.parent_itemId, propertiesData.parent_itemId) && Internal.equals(this.source, propertiesData.source) && Internal.equals(this.actDate, propertiesData.actDate) && Internal.equals(this.insurance, propertiesData.insurance);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.parent_itemId;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.source;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.actDate;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        InsuranceData insuranceData = this.insurance;
        if (insuranceData != null) {
            i2 = insuranceData.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.parent_itemId != null) {
            sb.append(", parent_itemId=");
            sb.append(this.parent_itemId);
        }
        if (this.source != null) {
            sb.append(", source=");
            sb.append(this.source);
        }
        if (this.actDate != null) {
            sb.append(", actDate=");
            sb.append(this.actDate);
        }
        if (this.insurance != null) {
            sb.append(", insurance=");
            sb.append(this.insurance);
        }
        StringBuilder replace = sb.replace(0, 2, "PropertiesData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PropertiesData, Builder> {
        public String actDate;
        public InsuranceData insurance;
        public String parent_itemId;
        public String source;

        public final Builder parent_itemId(String str) {
            this.parent_itemId = str;
            return this;
        }

        public final Builder source(String str) {
            this.source = str;
            return this;
        }

        public final Builder actDate(String str) {
            this.actDate = str;
            return this;
        }

        public final Builder insurance(InsuranceData insuranceData) {
            this.insurance = insuranceData;
            return this;
        }

        public final PropertiesData build() {
            return new PropertiesData(this.parent_itemId, this.source, this.actDate, this.insurance, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PropertiesData extends ProtoAdapter<PropertiesData> {
        ProtoAdapter_PropertiesData() {
            super(FieldEncoding.LENGTH_DELIMITED, PropertiesData.class);
        }

        public final int encodedSize(PropertiesData propertiesData) {
            int i = 0;
            int encodedSizeWithTag = (propertiesData.parent_itemId != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, propertiesData.parent_itemId) : 0) + (propertiesData.source != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, propertiesData.source) : 0) + (propertiesData.actDate != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, propertiesData.actDate) : 0);
            if (propertiesData.insurance != null) {
                i = InsuranceData.ADAPTER.encodedSizeWithTag(4, propertiesData.insurance);
            }
            return encodedSizeWithTag + i + propertiesData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PropertiesData propertiesData) throws IOException {
            if (propertiesData.parent_itemId != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, propertiesData.parent_itemId);
            }
            if (propertiesData.source != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, propertiesData.source);
            }
            if (propertiesData.actDate != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, propertiesData.actDate);
            }
            if (propertiesData.insurance != null) {
                InsuranceData.ADAPTER.encodeWithTag(protoWriter, 4, propertiesData.insurance);
            }
            protoWriter.writeBytes(propertiesData.unknownFields());
        }

        public final PropertiesData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.parent_itemId(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.source(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.actDate(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.insurance(InsuranceData.ADAPTER.decode(protoReader));
                }
            }
        }

        public final PropertiesData redact(PropertiesData propertiesData) {
            Builder newBuilder = propertiesData.newBuilder();
            if (newBuilder.insurance != null) {
                newBuilder.insurance = InsuranceData.ADAPTER.redact(newBuilder.insurance);
            }
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
