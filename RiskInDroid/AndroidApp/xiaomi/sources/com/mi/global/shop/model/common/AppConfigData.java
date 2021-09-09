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

public final class AppConfigData extends Message<AppConfigData, Builder> {
    public static final ProtoAdapter<AppConfigData> ADAPTER = new ProtoAdapter_AppConfigData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String discountMin;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String discountMin_txt;

    public AppConfigData(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public AppConfigData(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.discountMin = str;
        this.discountMin_txt = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.discountMin = this.discountMin;
        builder.discountMin_txt = this.discountMin_txt;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppConfigData)) {
            return false;
        }
        AppConfigData appConfigData = (AppConfigData) obj;
        return Internal.equals(unknownFields(), appConfigData.unknownFields()) && Internal.equals(this.discountMin, appConfigData.discountMin) && Internal.equals(this.discountMin_txt, appConfigData.discountMin_txt);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.discountMin;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.discountMin_txt;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.discountMin != null) {
            sb.append(", discountMin=");
            sb.append(this.discountMin);
        }
        if (this.discountMin_txt != null) {
            sb.append(", discountMin_txt=");
            sb.append(this.discountMin_txt);
        }
        StringBuilder replace = sb.replace(0, 2, "AppConfigData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<AppConfigData, Builder> {
        public String discountMin;
        public String discountMin_txt;

        public final Builder discountMin(String str) {
            this.discountMin = str;
            return this;
        }

        public final Builder discountMin_txt(String str) {
            this.discountMin_txt = str;
            return this;
        }

        public final AppConfigData build() {
            return new AppConfigData(this.discountMin, this.discountMin_txt, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_AppConfigData extends ProtoAdapter<AppConfigData> {
        ProtoAdapter_AppConfigData() {
            super(FieldEncoding.LENGTH_DELIMITED, AppConfigData.class);
        }

        public final int encodedSize(AppConfigData appConfigData) {
            int i = 0;
            int encodedSizeWithTag = appConfigData.discountMin != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, appConfigData.discountMin) : 0;
            if (appConfigData.discountMin_txt != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(5, appConfigData.discountMin_txt);
            }
            return encodedSizeWithTag + i + appConfigData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, AppConfigData appConfigData) throws IOException {
            if (appConfigData.discountMin != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, appConfigData.discountMin);
            }
            if (appConfigData.discountMin_txt != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, appConfigData.discountMin_txt);
            }
            protoWriter.writeBytes(appConfigData.unknownFields());
        }

        public final AppConfigData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.discountMin(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.discountMin_txt(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final AppConfigData redact(AppConfigData appConfigData) {
            Builder newBuilder = appConfigData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
