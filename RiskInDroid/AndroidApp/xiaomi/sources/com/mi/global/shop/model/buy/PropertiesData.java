package com.mi.global.shop.model.buy;

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
    @WireField(adapter = "com.mi.global.shop.model.buy.InsuranceData#ADAPTER", tag = 1)
    public final InsuranceData insurance;

    public PropertiesData(InsuranceData insuranceData) {
        this(insuranceData, ByteString.O00000Oo);
    }

    public PropertiesData(InsuranceData insuranceData, ByteString byteString) {
        super(ADAPTER, byteString);
        this.insurance = insuranceData;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
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
        return Internal.equals(unknownFields(), propertiesData.unknownFields()) && Internal.equals(this.insurance, propertiesData.insurance);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        InsuranceData insuranceData = this.insurance;
        int hashCode2 = hashCode + (insuranceData != null ? insuranceData.hashCode() : 0);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.insurance != null) {
            sb.append(", insurance=");
            sb.append(this.insurance);
        }
        StringBuilder replace = sb.replace(0, 2, "PropertiesData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PropertiesData, Builder> {
        public InsuranceData insurance;

        public final Builder insurance(InsuranceData insuranceData) {
            this.insurance = insuranceData;
            return this;
        }

        public final PropertiesData build() {
            return new PropertiesData(this.insurance, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PropertiesData extends ProtoAdapter<PropertiesData> {
        ProtoAdapter_PropertiesData() {
            super(FieldEncoding.LENGTH_DELIMITED, PropertiesData.class);
        }

        public final int encodedSize(PropertiesData propertiesData) {
            return (propertiesData.insurance != null ? InsuranceData.ADAPTER.encodedSizeWithTag(1, propertiesData.insurance) : 0) + propertiesData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PropertiesData propertiesData) throws IOException {
            if (propertiesData.insurance != null) {
                InsuranceData.ADAPTER.encodeWithTag(protoWriter, 1, propertiesData.insurance);
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
                } else if (nextTag != 1) {
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
