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

public final class Value_View_Click extends Message<Value_View_Click, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_View_Click> f5084O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String label;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String page_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long timestamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String view_id;

    public Value_View_Click(String str, Long l, String str2, String str3, String str4, ByteString byteString) {
        super(f5084O000000o, byteString);
        this.session_id = str;
        this.timestamp = l;
        this.view_id = str2;
        this.label = str3;
        this.page_id = str4;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5085O000000o = this.session_id;
        o000000o.O00000Oo = this.timestamp;
        o000000o.O00000o0 = this.view_id;
        o000000o.O00000o = this.label;
        o000000o.O00000oO = this.page_id;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_View_Click)) {
            return false;
        }
        Value_View_Click value_View_Click = (Value_View_Click) obj;
        return Internal.equals(unknownFields(), value_View_Click.unknownFields()) && Internal.equals(this.session_id, value_View_Click.session_id) && Internal.equals(this.timestamp, value_View_Click.timestamp) && Internal.equals(this.view_id, value_View_Click.view_id) && Internal.equals(this.label, value_View_Click.label) && Internal.equals(this.page_id, value_View_Click.page_id);
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
        Long l = this.timestamp;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        String str2 = this.view_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.label;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.page_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode5 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        if (this.view_id != null) {
            sb.append(", view_id=");
            sb.append(this.view_id);
        }
        if (this.label != null) {
            sb.append(", label=");
            sb.append(this.label);
        }
        if (this.page_id != null) {
            sb.append(", page_id=");
            sb.append(this.page_id);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_View_Click{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_View_Click, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5085O000000o;
        public Long O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;

        /* renamed from: O000000o */
        public final Value_View_Click build() {
            return new Value_View_Click(this.f5085O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_View_Click> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_View_Click value_View_Click = (Value_View_Click) obj;
            if (value_View_Click.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_View_Click.session_id);
            }
            if (value_View_Click.timestamp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, value_View_Click.timestamp);
            }
            if (value_View_Click.view_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, value_View_Click.view_id);
            }
            if (value_View_Click.label != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, value_View_Click.label);
            }
            if (value_View_Click.page_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, value_View_Click.page_id);
            }
            protoWriter.writeBytes(value_View_Click.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_View_Click value_View_Click = (Value_View_Click) obj;
            int i = 0;
            int encodedSizeWithTag = (value_View_Click.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_View_Click.session_id) : 0) + (value_View_Click.timestamp != null ? ProtoAdapter.INT64.encodedSizeWithTag(3, value_View_Click.timestamp) : 0) + (value_View_Click.view_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value_View_Click.view_id) : 0) + (value_View_Click.label != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, value_View_Click.label) : 0);
            if (value_View_Click.page_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(6, value_View_Click.page_id);
            }
            return encodedSizeWithTag + i + value_View_Click.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_View_Click) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_View_Click.class);
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
                    o000000o.f5085O000000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    o000000o.O00000Oo = ProtoAdapter.INT64.decode(protoReader);
                } else if (nextTag == 4) {
                    o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 5) {
                    o000000o.O00000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 6) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    o000000o.O00000oO = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
