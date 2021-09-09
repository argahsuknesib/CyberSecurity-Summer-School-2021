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

public final class ChangeAddressData extends Message<ChangeAddressData, Builder> {
    public static final ProtoAdapter<ChangeAddressData> ADAPTER = new ProtoAdapter_ChangeAddressData();
    public static final Boolean DEFAULT_ISCOS = Boolean.FALSE;
    public static final Boolean DEFAULT_VALID = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String codtext;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean isCos;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String producttext;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean valid;

    public ChangeAddressData(Boolean bool, String str, String str2, Boolean bool2) {
        this(bool, str, str2, bool2, ByteString.O00000Oo);
    }

    public ChangeAddressData(Boolean bool, String str, String str2, Boolean bool2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.valid = bool;
        this.codtext = str;
        this.producttext = str2;
        this.isCos = bool2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.valid = this.valid;
        builder.codtext = this.codtext;
        builder.producttext = this.producttext;
        builder.isCos = this.isCos;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ChangeAddressData)) {
            return false;
        }
        ChangeAddressData changeAddressData = (ChangeAddressData) obj;
        return Internal.equals(unknownFields(), changeAddressData.unknownFields()) && Internal.equals(this.valid, changeAddressData.valid) && Internal.equals(this.codtext, changeAddressData.codtext) && Internal.equals(this.producttext, changeAddressData.producttext) && Internal.equals(this.isCos, changeAddressData.isCos);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        Boolean bool = this.valid;
        int i2 = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.codtext;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.producttext;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool2 = this.isCos;
        if (bool2 != null) {
            i2 = bool2.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.valid != null) {
            sb.append(", valid=");
            sb.append(this.valid);
        }
        if (this.codtext != null) {
            sb.append(", codtext=");
            sb.append(this.codtext);
        }
        if (this.producttext != null) {
            sb.append(", producttext=");
            sb.append(this.producttext);
        }
        if (this.isCos != null) {
            sb.append(", isCos=");
            sb.append(this.isCos);
        }
        StringBuilder replace = sb.replace(0, 2, "ChangeAddressData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ChangeAddressData, Builder> {
        public String codtext;
        public Boolean isCos;
        public String producttext;
        public Boolean valid;

        public final Builder valid(Boolean bool) {
            this.valid = bool;
            return this;
        }

        public final Builder codtext(String str) {
            this.codtext = str;
            return this;
        }

        public final Builder producttext(String str) {
            this.producttext = str;
            return this;
        }

        public final Builder isCos(Boolean bool) {
            this.isCos = bool;
            return this;
        }

        public final ChangeAddressData build() {
            return new ChangeAddressData(this.valid, this.codtext, this.producttext, this.isCos, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ChangeAddressData extends ProtoAdapter<ChangeAddressData> {
        ProtoAdapter_ChangeAddressData() {
            super(FieldEncoding.LENGTH_DELIMITED, ChangeAddressData.class);
        }

        public final int encodedSize(ChangeAddressData changeAddressData) {
            int i = 0;
            int encodedSizeWithTag = (changeAddressData.valid != null ? ProtoAdapter.BOOL.encodedSizeWithTag(1, changeAddressData.valid) : 0) + (changeAddressData.codtext != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, changeAddressData.codtext) : 0) + (changeAddressData.producttext != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, changeAddressData.producttext) : 0);
            if (changeAddressData.isCos != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(4, changeAddressData.isCos);
            }
            return encodedSizeWithTag + i + changeAddressData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ChangeAddressData changeAddressData) throws IOException {
            if (changeAddressData.valid != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 1, changeAddressData.valid);
            }
            if (changeAddressData.codtext != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, changeAddressData.codtext);
            }
            if (changeAddressData.producttext != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, changeAddressData.producttext);
            }
            if (changeAddressData.isCos != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, changeAddressData.isCos);
            }
            protoWriter.writeBytes(changeAddressData.unknownFields());
        }

        public final ChangeAddressData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.valid(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.codtext(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.producttext(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.isCos(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public final ChangeAddressData redact(ChangeAddressData changeAddressData) {
            Builder newBuilder = changeAddressData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
