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

public final class EventExtraData extends Message<EventExtraData, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<EventExtraData> f5064O000000o = new O00000Oo();
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String key;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String type;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String value;

    public EventExtraData(String str, String str2, String str3, ByteString byteString) {
        super(f5064O000000o, byteString);
        this.key = str;
        this.value = str2;
        this.type = str3;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5065O000000o = this.key;
        o000000o.O00000Oo = this.value;
        o000000o.O00000o0 = this.type;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventExtraData)) {
            return false;
        }
        EventExtraData eventExtraData = (EventExtraData) obj;
        return Internal.equals(unknownFields(), eventExtraData.unknownFields()) && Internal.equals(this.key, eventExtraData.key) && Internal.equals(this.value, eventExtraData.value) && Internal.equals(this.type, eventExtraData.type);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.key;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.value;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.type;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        int i3 = hashCode3 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.key != null) {
            sb.append(", key=");
            sb.append(this.key);
        }
        if (this.value != null) {
            sb.append(", value=");
            sb.append(this.value);
        }
        if (this.type != null) {
            sb.append(", type=");
            sb.append(this.type);
        }
        StringBuilder replace = sb.replace(0, 2, "EventExtraData{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<EventExtraData, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5065O000000o;
        public String O00000Oo;
        public String O00000o0;

        /* renamed from: O000000o */
        public final EventExtraData build() {
            return new EventExtraData(this.f5065O000000o, this.O00000Oo, this.O00000o0, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<EventExtraData> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            EventExtraData eventExtraData = (EventExtraData) obj;
            if (eventExtraData.key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, eventExtraData.key);
            }
            if (eventExtraData.value != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, eventExtraData.value);
            }
            if (eventExtraData.type != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, eventExtraData.type);
            }
            protoWriter.writeBytes(eventExtraData.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            EventExtraData eventExtraData = (EventExtraData) obj;
            int i = 0;
            int encodedSizeWithTag = (eventExtraData.key != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, eventExtraData.key) : 0) + (eventExtraData.value != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, eventExtraData.value) : 0);
            if (eventExtraData.type != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(3, eventExtraData.type);
            }
            return encodedSizeWithTag + i + eventExtraData.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((EventExtraData) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, EventExtraData.class);
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
                    o000000o.f5065O000000o = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag == 2) {
                    o000000o.O00000Oo = ProtoAdapter.STRING.decode(protoReader);
                } else if (nextTag != 3) {
                    FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                    o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                } else {
                    o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                }
            }
        }
    }
}
