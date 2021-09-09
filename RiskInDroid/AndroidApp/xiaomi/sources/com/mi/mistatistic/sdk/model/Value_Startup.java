package com.mi.mistatistic.sdk.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Value_Startup extends Message<Value_Startup, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_Startup> f5082O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String network;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String resolution;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long start_time;

    public Value_Startup(String str, String str2, String str3, Long l, ByteString byteString) {
        super(f5082O000000o, byteString);
        this.session_id = str;
        this.network = str2;
        this.resolution = str3;
        this.start_time = l;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5083O000000o = this.session_id;
        o000000o.O00000Oo = this.network;
        o000000o.O00000o0 = this.resolution;
        o000000o.O00000o = this.start_time;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_Startup)) {
            return false;
        }
        Value_Startup value_Startup = (Value_Startup) obj;
        return Internal.equals(unknownFields(), value_Startup.unknownFields()) && Internal.equals(this.session_id, value_Startup.session_id) && Internal.equals(this.network, value_Startup.network) && Internal.equals(this.resolution, value_Startup.resolution) && Internal.equals(this.start_time, value_Startup.start_time);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.session_id;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.network;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.resolution;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.start_time;
        if (l != null) {
            i2 = l.hashCode();
        }
        int i3 = hashCode4 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.network != null) {
            sb.append(", network=");
            sb.append(this.network);
        }
        if (this.resolution != null) {
            sb.append(", resolution=");
            sb.append(this.resolution);
        }
        if (this.start_time != null) {
            sb.append(", start_time=");
            sb.append(this.start_time);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_Startup{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_Startup, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5083O000000o;
        public String O00000Oo;
        public Long O00000o;
        public String O00000o0;

        /* renamed from: O000000o */
        public final Value_Startup build() {
            return new Value_Startup(this.f5083O000000o, this.O00000Oo, this.O00000o0, this.O00000o, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_Startup> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_Startup value_Startup = (Value_Startup) obj;
            if (value_Startup.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_Startup.session_id);
            }
            if (value_Startup.network != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, value_Startup.network);
            }
            if (value_Startup.resolution != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, value_Startup.resolution);
            }
            if (value_Startup.start_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, value_Startup.start_time);
            }
            protoWriter.writeBytes(value_Startup.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_Startup value_Startup = (Value_Startup) obj;
            int i = 0;
            int encodedSizeWithTag = (value_Startup.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_Startup.session_id) : 0) + (value_Startup.network != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value_Startup.network) : 0) + (value_Startup.resolution != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value_Startup.resolution) : 0);
            if (value_Startup.start_time != null) {
                i = ProtoAdapter.INT64.encodedSizeWithTag(7, value_Startup.start_time);
            }
            return encodedSizeWithTag + i + value_Startup.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_Startup) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_Startup.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag == -1) {
                    protoReader.endMessage(beginMessage);
                    return o000000o.build();
                } else if (nextTag == 1) {
                    o000000o.f5083O000000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    o000000o.O00000Oo = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 7) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    o000000o.O00000o = ProtoAdapter.INT64.decode(protoReader);
                }
            }
        }
    }
}
