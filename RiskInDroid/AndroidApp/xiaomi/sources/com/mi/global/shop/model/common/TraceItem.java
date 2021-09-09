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

public final class TraceItem extends Message<TraceItem, Builder> {
    public static final ProtoAdapter<TraceItem> ADAPTER = new ProtoAdapter_TraceItem();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String text;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String time;

    public TraceItem(String str, String str2) {
        this(str, str2, ByteString.O00000Oo);
    }

    public TraceItem(String str, String str2, ByteString byteString) {
        super(ADAPTER, byteString);
        this.text = str;
        this.time = str2;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.text = this.text;
        builder.time = this.time;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TraceItem)) {
            return false;
        }
        TraceItem traceItem = (TraceItem) obj;
        return Internal.equals(unknownFields(), traceItem.unknownFields()) && Internal.equals(this.text, traceItem.text) && Internal.equals(this.time, traceItem.time);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.text;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.time;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        int i3 = hashCode2 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.text != null) {
            sb.append(", text=");
            sb.append(this.text);
        }
        if (this.time != null) {
            sb.append(", time=");
            sb.append(this.time);
        }
        StringBuilder replace = sb.replace(0, 2, "TraceItem{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<TraceItem, Builder> {
        public String text;
        public String time;

        public final Builder text(String str) {
            this.text = str;
            return this;
        }

        public final Builder time(String str) {
            this.time = str;
            return this;
        }

        public final TraceItem build() {
            return new TraceItem(this.text, this.time, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_TraceItem extends ProtoAdapter<TraceItem> {
        ProtoAdapter_TraceItem() {
            super(FieldEncoding.LENGTH_DELIMITED, TraceItem.class);
        }

        public final int encodedSize(TraceItem traceItem) {
            int i = 0;
            int encodedSizeWithTag = traceItem.text != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, traceItem.text) : 0;
            if (traceItem.time != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(2, traceItem.time);
            }
            return encodedSizeWithTag + i + traceItem.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, TraceItem traceItem) throws IOException {
            if (traceItem.text != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, traceItem.text);
            }
            if (traceItem.time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, traceItem.time);
            }
            protoWriter.writeBytes(traceItem.unknownFields());
        }

        public final TraceItem decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.text(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 2) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.time(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final TraceItem redact(TraceItem traceItem) {
            Builder newBuilder = traceItem.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
