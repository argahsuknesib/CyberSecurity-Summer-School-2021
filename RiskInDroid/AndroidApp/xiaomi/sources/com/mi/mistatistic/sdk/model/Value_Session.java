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

public final class Value_Session extends Message<Value_Session, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_Session> f5080O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    public static final Long O00000o0 = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long end_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String network;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long start_time;

    public Value_Session(String str, Long l, Long l2, String str2, ByteString byteString) {
        super(f5080O000000o, byteString);
        this.session_id = str;
        this.start_time = l;
        this.end_time = l2;
        this.network = str2;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5081O000000o = this.session_id;
        o000000o.O00000Oo = this.start_time;
        o000000o.O00000o0 = this.end_time;
        o000000o.O00000o = this.network;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_Session)) {
            return false;
        }
        Value_Session value_Session = (Value_Session) obj;
        return Internal.equals(unknownFields(), value_Session.unknownFields()) && Internal.equals(this.session_id, value_Session.session_id) && Internal.equals(this.start_time, value_Session.start_time) && Internal.equals(this.end_time, value_Session.end_time) && Internal.equals(this.network, value_Session.network);
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
        Long l = this.start_time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.end_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str2 = this.network;
        if (str2 != null) {
            i2 = str2.hashCode();
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
        if (this.start_time != null) {
            sb.append(", start_time=");
            sb.append(this.start_time);
        }
        if (this.end_time != null) {
            sb.append(", end_time=");
            sb.append(this.end_time);
        }
        if (this.network != null) {
            sb.append(", network=");
            sb.append(this.network);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_Session{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_Session, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5081O000000o;
        public Long O00000Oo;
        public String O00000o;
        public Long O00000o0;

        /* renamed from: O000000o */
        public final Value_Session build() {
            return new Value_Session(this.f5081O000000o, this.O00000Oo, this.O00000o0, this.O00000o, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_Session> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_Session value_Session = (Value_Session) obj;
            if (value_Session.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_Session.session_id);
            }
            if (value_Session.start_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, value_Session.start_time);
            }
            if (value_Session.end_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, value_Session.end_time);
            }
            if (value_Session.network != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, value_Session.network);
            }
            protoWriter.writeBytes(value_Session.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_Session value_Session = (Value_Session) obj;
            int i = 0;
            int encodedSizeWithTag = (value_Session.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_Session.session_id) : 0) + (value_Session.start_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(3, value_Session.start_time) : 0) + (value_Session.end_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(4, value_Session.end_time) : 0);
            if (value_Session.network != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(5, value_Session.network);
            }
            return encodedSizeWithTag + i + value_Session.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_Session) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_Session.class);
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
                    o000000o.f5081O000000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    o000000o.O00000Oo = ProtoAdapter.INT64.decode(protoReader);
                } else if (nextTag == 4) {
                    o000000o.O00000o0 = ProtoAdapter.INT64.decode(protoReader);
                } else if (nextTag != 5) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    o000000o.O00000o = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
