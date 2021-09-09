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

public final class SubmitData extends Message<SubmitData, Builder> {
    public static final ProtoAdapter<SubmitData> ADAPTER = new ProtoAdapter_SubmitData();
    public static final Boolean DEFAULT_IS_ZERO_ORDER = Boolean.FALSE;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String errors;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BOOL", tag = 2)
    public final Boolean is_zero_order;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String link;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String order_id;

    public SubmitData(String str, Boolean bool, String str2, String str3) {
        this(str, bool, str2, str3, ByteString.O00000Oo);
    }

    public SubmitData(String str, Boolean bool, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.order_id = str;
        this.is_zero_order = bool;
        this.link = str2;
        this.errors = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.order_id = this.order_id;
        builder.is_zero_order = this.is_zero_order;
        builder.link = this.link;
        builder.errors = this.errors;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubmitData)) {
            return false;
        }
        SubmitData submitData = (SubmitData) obj;
        return Internal.equals(unknownFields(), submitData.unknownFields()) && Internal.equals(this.order_id, submitData.order_id) && Internal.equals(this.is_zero_order, submitData.is_zero_order) && Internal.equals(this.link, submitData.link) && Internal.equals(this.errors, submitData.errors);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.order_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        Boolean bool = this.is_zero_order;
        int hashCode3 = (hashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str2 = this.link;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.errors;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.order_id != null) {
            sb.append(", order_id=");
            sb.append(this.order_id);
        }
        if (this.is_zero_order != null) {
            sb.append(", is_zero_order=");
            sb.append(this.is_zero_order);
        }
        if (this.link != null) {
            sb.append(", link=");
            sb.append(this.link);
        }
        if (this.errors != null) {
            sb.append(", errors=");
            sb.append(this.errors);
        }
        StringBuilder replace = sb.replace(0, 2, "SubmitData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<SubmitData, Builder> {
        public String errors;
        public Boolean is_zero_order;
        public String link;
        public String order_id;

        public final Builder order_id(String str) {
            this.order_id = str;
            return this;
        }

        public final Builder is_zero_order(Boolean bool) {
            this.is_zero_order = bool;
            return this;
        }

        public final Builder link(String str) {
            this.link = str;
            return this;
        }

        public final Builder errors(String str) {
            this.errors = str;
            return this;
        }

        public final SubmitData build() {
            return new SubmitData(this.order_id, this.is_zero_order, this.link, this.errors, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_SubmitData extends ProtoAdapter<SubmitData> {
        ProtoAdapter_SubmitData() {
            super(FieldEncoding.LENGTH_DELIMITED, SubmitData.class);
        }

        public final int encodedSize(SubmitData submitData) {
            int i = 0;
            int encodedSizeWithTag = (submitData.order_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, submitData.order_id) : 0) + (submitData.is_zero_order != null ? ProtoAdapter.BOOL.encodedSizeWithTag(2, submitData.is_zero_order) : 0) + (submitData.link != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, submitData.link) : 0);
            if (submitData.errors != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(4, submitData.errors);
            }
            return encodedSizeWithTag + i + submitData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, SubmitData submitData) throws IOException {
            if (submitData.order_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, submitData.order_id);
            }
            if (submitData.is_zero_order != null) {
                ProtoAdapter.BOOL.encodeWithTag(protoWriter, 2, submitData.is_zero_order);
            }
            if (submitData.link != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, submitData.link);
            }
            if (submitData.errors != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, submitData.errors);
            }
            protoWriter.writeBytes(submitData.unknownFields());
        }

        public final SubmitData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.order_id(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.is_zero_order(ProtoAdapter.BOOL.decode(protoReader));
                } else if (nextTag == 3) {
                    builder.link(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 4) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.errors(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final SubmitData redact(SubmitData submitData) {
            Builder newBuilder = submitData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
