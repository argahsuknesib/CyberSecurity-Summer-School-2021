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

public final class PaygoData extends Message<PaygoData, Builder> {
    public static final ProtoAdapter<PaygoData> ADAPTER = new ProtoAdapter_PaygoData();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String html;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String params;

    public PaygoData(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public PaygoData(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.html = str;
        this.params = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.html = this.html;
        builder.params = this.params;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PaygoData)) {
            return false;
        }
        PaygoData paygoData = (PaygoData) obj;
        return Internal.equals(unknownFields(), paygoData.unknownFields()) && Internal.equals(this.html, paygoData.html) && Internal.equals(this.params, paygoData.params);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.html;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.params;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.html != null) {
            sb.append(", html=");
            sb.append(this.html);
        }
        if (this.params != null) {
            sb.append(", params=");
            sb.append(this.params);
        }
        StringBuilder replace = sb.replace(0, 2, "PaygoData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<PaygoData, Builder> {
        public String html;
        public String params;

        public final Builder html(String str) {
            this.html = str;
            return this;
        }

        public final Builder params(String str) {
            this.params = str;
            return this;
        }

        public final PaygoData build() {
            return new PaygoData(this.html, this.params, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_PaygoData extends ProtoAdapter<PaygoData> {
        ProtoAdapter_PaygoData() {
            super(FieldEncoding.LENGTH_DELIMITED, PaygoData.class);
        }

        public final int encodedSize(PaygoData paygoData) {
            int i = 0;
            int encodedSizeWithTag = paygoData.html != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, paygoData.html) : 0;
            if (paygoData.params != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, paygoData.params);
            }
            return encodedSizeWithTag + i + paygoData.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, PaygoData paygoData) throws IOException {
            if (paygoData.html != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, paygoData.html);
            }
            if (paygoData.params != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, paygoData.params);
            }
            protoWriter.writeBytes(paygoData.unknownFields());
        }

        public final PaygoData decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.html(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.params(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final PaygoData redact(PaygoData paygoData) {
            Builder newBuilder = paygoData.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
