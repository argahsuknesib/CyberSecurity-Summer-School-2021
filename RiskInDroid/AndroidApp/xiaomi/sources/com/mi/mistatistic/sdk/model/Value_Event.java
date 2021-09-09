package com.mi.mistatistic.sdk.model;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

public final class Value_Event extends Message<Value_Event, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_Event> f5070O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "appstat.EventExtraData#ADAPTER", label = WireField.Label.REPEATED, tag = 6)
    public final List<EventExtraData> data;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String event_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String label;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String page_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long timestamp;

    public Value_Event(String str, Long l, String str2, String str3, List<EventExtraData> list, String str4, ByteString byteString) {
        super(f5070O000000o, byteString);
        this.session_id = str;
        this.timestamp = l;
        this.event_id = str2;
        this.label = str3;
        this.data = Internal.immutableCopyOf("data", list);
        this.page_id = str4;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5071O000000o = this.session_id;
        o000000o.O00000Oo = this.timestamp;
        o000000o.O00000o0 = this.event_id;
        o000000o.O00000o = this.label;
        o000000o.O00000oO = Internal.copyOf("data", this.data);
        o000000o.O00000oo = this.page_id;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_Event)) {
            return false;
        }
        Value_Event value_Event = (Value_Event) obj;
        return Internal.equals(unknownFields(), value_Event.unknownFields()) && Internal.equals(this.session_id, value_Event.session_id) && Internal.equals(this.timestamp, value_Event.timestamp) && Internal.equals(this.event_id, value_Event.event_id) && Internal.equals(this.label, value_Event.label) && Internal.equals(this.data, value_Event.data) && Internal.equals(this.page_id, value_Event.page_id);
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
        String str2 = this.event_id;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.label;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        List<EventExtraData> list = this.data;
        int hashCode6 = (hashCode5 + (list != null ? list.hashCode() : 1)) * 37;
        String str4 = this.page_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode6 + i2;
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
        if (this.event_id != null) {
            sb.append(", event_id=");
            sb.append(this.event_id);
        }
        if (this.label != null) {
            sb.append(", label=");
            sb.append(this.label);
        }
        if (this.data != null) {
            sb.append(", data=");
            sb.append(this.data);
        }
        if (this.page_id != null) {
            sb.append(", page_id=");
            sb.append(this.page_id);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_Event{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_Event, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5071O000000o;
        public Long O00000Oo;
        public String O00000o;
        public String O00000o0;
        public List<EventExtraData> O00000oO = Internal.newMutableList();
        public String O00000oo;

        public final O000000o O000000o(List<EventExtraData> list) {
            Internal.checkElementsNotNull(list);
            this.O00000oO = list;
            return this;
        }

        /* renamed from: O000000o */
        public final Value_Event build() {
            return new Value_Event(this.f5071O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_Event> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_Event value_Event = (Value_Event) obj;
            if (value_Event.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_Event.session_id);
            }
            if (value_Event.timestamp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, value_Event.timestamp);
            }
            if (value_Event.event_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, value_Event.event_id);
            }
            if (value_Event.label != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, value_Event.label);
            }
            if (value_Event.data != null) {
                EventExtraData.f5064O000000o.asRepeated().encodeWithTag(protoWriter, 6, value_Event.data);
            }
            if (value_Event.page_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, value_Event.page_id);
            }
            protoWriter.writeBytes(value_Event.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_Event value_Event = (Value_Event) obj;
            int i = 0;
            int encodedSizeWithTag = (value_Event.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_Event.session_id) : 0) + (value_Event.timestamp != null ? ProtoAdapter.INT64.encodedSizeWithTag(3, value_Event.timestamp) : 0) + (value_Event.event_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value_Event.event_id) : 0) + (value_Event.label != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, value_Event.label) : 0) + EventExtraData.f5064O000000o.asRepeated().encodedSizeWithTag(6, value_Event.data);
            if (value_Event.page_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(7, value_Event.page_id);
            }
            return encodedSizeWithTag + i + value_Event.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_Event) obj).newBuilder();
            Internal.redactElements(O000000o2.O00000oO, EventExtraData.f5064O000000o);
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_Event.class);
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
                    o000000o.f5071O000000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 3) {
                    o000000o.O00000Oo = ProtoAdapter.INT64.decode(protoReader);
                } else if (nextTag == 4) {
                    o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 5) {
                    o000000o.O00000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 6) {
                    o000000o.O00000oO.add(EventExtraData.f5064O000000o.decode(protoReader));
                } else if (nextTag != 7) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    o000000o.O00000oo = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
