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

public final class DelivertimeData extends Message<DelivertimeData, Builder> {
    public static final ProtoAdapter<DelivertimeData> ADAPTER = new ProtoAdapter_DelivertimeData();
    public static final Boolean DEFAULT_CHECKED = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 3)
    public final Boolean checked;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String desc;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String value;

    public DelivertimeData(String str, String str2, Boolean bool) {
        this(str, str2, bool, ByteString.O00000Oo);
    }

    public DelivertimeData(String str, String str2, Boolean bool, ByteString byteString) {
        super(ADAPTER, byteString);
        this.value = str;
        this.desc = str2;
        this.checked = bool;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
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
        if (!(obj instanceof DelivertimeData)) {
            return false;
        }
        DelivertimeData delivertimeData = (DelivertimeData) obj;
        return Internal.equals(unknownFields(), delivertimeData.unknownFields()) && Internal.equals(this.value, delivertimeData.value) && Internal.equals(this.desc, delivertimeData.desc) && Internal.equals(this.checked, delivertimeData.checked);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.value;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.desc;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Boolean bool = this.checked;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
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
        StringBuilder replace = sb.replace(0, 2, "DelivertimeData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<DelivertimeData, Builder> {
        public Boolean checked;
        public String desc;
        public String value;

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

        public final DelivertimeData build() {
            return new DelivertimeData(this.value, this.desc, this.checked, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_DelivertimeData extends ProtoAdapter<DelivertimeData> {
        ProtoAdapter_DelivertimeData() {
            super(FieldEncoding.LENGTH_DELIMITED, DelivertimeData.class);
        }

        public final int encodedSize(DelivertimeData delivertimeData) {
            int i = 0;
            int encodedSizeWithTag = (delivertimeData.value != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, delivertimeData.value) : 0) + (delivertimeData.desc != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, delivertimeData.desc) : 0);
            if (delivertimeData.checked != null) {
                i = ProtoAdapter.BOOL.encodedSizeWithTag(3, delivertimeData.checked);
            }
            return encodedSizeWithTag + i + delivertimeData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, DelivertimeData delivertimeData) throws IOException {
            if (delivertimeData.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, delivertimeData.value);
            }
            if (delivertimeData.desc != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, delivertimeData.desc);
            }
            if (delivertimeData.checked != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 3, delivertimeData.checked);
            }
            protoWriter.writeBytes(delivertimeData.unknownFields());
        }

        public final DelivertimeData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.value(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.desc(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.checked(ProtoAdapter.BOOL.decode(protoReader));
                }
            }
        }

        public final DelivertimeData redact(DelivertimeData delivertimeData) {
            Builder newBuilder = delivertimeData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
