package com.mi.global.shop.model.user;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class ExpressTrace extends Message<ExpressTrace, Builder> {
    public static final ProtoAdapter<ExpressTrace> ADAPTER = new ProtoAdapter_ExpressTrace();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String city;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String track;

    public ExpressTrace(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.O00000Oo);
    }

    public ExpressTrace(String str, String str2, String str3, ByteString byteString) {
        super(ADAPTER, byteString);
        this.time = str;
        this.city = str2;
        this.track = str3;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.time = this.time;
        builder.city = this.city;
        builder.track = this.track;
        builder.addUnknownFields(unknownFields());
        return builder;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ExpressTrace)) {
            return false;
        }
        ExpressTrace expressTrace = (ExpressTrace) obj;
        return Internal.equals(unknownFields(), expressTrace.unknownFields()) && Internal.equals(this.time, expressTrace.time) && Internal.equals(this.city, expressTrace.city) && Internal.equals(this.track, expressTrace.track);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.time;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.city;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.track;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.time != null) {
            sb.append(", time=");
            sb.append(this.time);
        }
        if (this.city != null) {
            sb.append(", city=");
            sb.append(this.city);
        }
        if (this.track != null) {
            sb.append(", track=");
            sb.append(this.track);
        }
        StringBuilder replace = sb.replace(0, 2, "ExpressTrace{");
        replace.append('}');
        return replace.toString();
    }

    public static final class Builder extends Message.Builder<ExpressTrace, Builder> {
        public String city;
        public String time;
        public String track;

        public final Builder time(String str) {
            this.time = str;
            return this;
        }

        public final Builder city(String str) {
            this.city = str;
            return this;
        }

        public final Builder track(String str) {
            this.track = str;
            return this;
        }

        public final ExpressTrace build() {
            return new ExpressTrace(this.time, this.city, this.track, buildUnknownFields());
        }
    }

    static final class ProtoAdapter_ExpressTrace extends ProtoAdapter<ExpressTrace> {
        ProtoAdapter_ExpressTrace() {
            super(FieldEncoding.LENGTH_DELIMITED, ExpressTrace.class);
        }

        public final int encodedSize(ExpressTrace expressTrace) {
            int i = 0;
            int encodedSizeWithTag = (expressTrace.time != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, expressTrace.time) : 0) + (expressTrace.city != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, expressTrace.city) : 0);
            if (expressTrace.track != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, expressTrace.track);
            }
            return encodedSizeWithTag + i + expressTrace.unknownFields().O0000OOo();
        }

        public final void encode(ProtoWriter protoWriter, ExpressTrace expressTrace) throws IOException {
            if (expressTrace.time != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, expressTrace.time);
            }
            if (expressTrace.city != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, expressTrace.city);
            }
            if (expressTrace.track != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, expressTrace.track);
            }
            protoWriter.writeBytes(expressTrace.unknownFields());
        }

        public final ExpressTrace decode(ProtoReader protoReader) throws IOException {
            Builder builder = new Builder();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return builder.build();
                } else if (nextTag == 1) {
                    builder.time(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag == 2) {
                    builder.city(ProtoAdapter.STRING.decode(protoReader));
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    builder.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    builder.track(ProtoAdapter.STRING.decode(protoReader));
                }
            }
        }

        public final ExpressTrace redact(ExpressTrace expressTrace) {
            Builder newBuilder = expressTrace.newBuilder();
            newBuilder.clearUnknownFields();
            return newBuilder.build();
        }
    }
}
