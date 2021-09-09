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

public final class InvoiceData extends Message<InvoiceData, Builder> {
    public static final ProtoAdapter<InvoiceData> ADAPTER = new ProtoAdapter_InvoiceData();
    public static final Boolean DEFAULT_CHECKED = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 4)
    public final Boolean checked;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String desc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String value;

    public InvoiceData(String str, String str2, String str3, Boolean bool) {
        this(str, str2, str3, bool, ByteString.O00000Oo);
    }

    public InvoiceData(String str, String str2, String str3, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.type = str;
        this.value = str2;
        this.desc = str3;
        this.checked = bool;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.type = this.type;
        builder.value = this.value;
        builder.desc = this.desc;
        builder.checked = this.checked;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InvoiceData)) {
            return false;
        }
        InvoiceData invoiceData = (InvoiceData) obj;
        return Internal.equals(unknownFields(), invoiceData.unknownFields()) && Internal.equals(this.type, invoiceData.type) && Internal.equals(this.value, invoiceData.value) && Internal.equals(this.desc, invoiceData.desc) && Internal.equals(this.checked, invoiceData.checked);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.type;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Boolean bool = this.checked;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        if (this.value != null) {
            sb.append(", value=");
            sb.append(this.value);
        }
        if (this.desc != null) {
            sb.append(", desc=");
            sb.append(this.desc);
        }
        if (this.checked != null) {
            sb.append(", checked=");
            sb.append(this.checked);
        }
        StringBuilder replace = sb.replace(0, 2, "InvoiceData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<InvoiceData, Builder> {
        public Boolean checked;
        public String desc;
        public String type;
        public String value;

        public final Builder type(String str) {
            this.type = str;
            return this;
        }

        public final Builder value(String str) {
            this.value = str;
            return this;
        }

        public final Builder desc(String str) {
            this.desc = str;
            return this;
        }

        public final Builder checked(Boolean bool) {
            this.checked = bool;
            return this;
        }

        public final InvoiceData build() {
            return new InvoiceData(this.type, this.value, this.desc, this.checked, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_InvoiceData extends ProtoAdapter<InvoiceData> {
        ProtoAdapter_InvoiceData() {
            super(FieldEncoding.LENGTH_DELIMITED, InvoiceData.class);
        }

        public final int encodedSize(InvoiceData invoiceData) {
            int i = 0;
            int encodedSizeWithTag = (invoiceData.type != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, invoiceData.type) : 0) + (invoiceData.value != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, invoiceData.value) : 0) + (invoiceData.desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, invoiceData.desc) : 0);
            if (invoiceData.checked != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(4, invoiceData.checked);
            }
            return encodedSizeWithTag + i + invoiceData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, InvoiceData invoiceData) throws IOException {
            if (invoiceData.type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, invoiceData.type);
            }
            if (invoiceData.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, invoiceData.value);
            }
            if (invoiceData.desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, invoiceData.desc);
            }
            if (invoiceData.checked != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 4, invoiceData.checked);
            }
            protoWriter.writeBytes(invoiceData.unknownFields());
        }

        public final InvoiceData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.type(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.value(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.desc(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.checked(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public final InvoiceData redact(InvoiceData invoiceData) {
            Builder newBuilder = invoiceData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
