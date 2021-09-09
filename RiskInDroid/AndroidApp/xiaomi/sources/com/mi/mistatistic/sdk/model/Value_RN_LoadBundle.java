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

public final class Value_RN_LoadBundle extends Message<Value_RN_LoadBundle, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_RN_LoadBundle> f5078O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    public static final Long O00000o = 0L;
    public static final Long O00000o0 = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String bundle_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String bundle_using_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long instance_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String rn_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long timestamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long view_time;

    public Value_RN_LoadBundle(String str, String str2, String str3, Long l, Long l2, String str4, Long l3, ByteString byteString) {
        super(f5078O000000o, byteString);
        this.bundle_name = str;
        this.bundle_using_version = str2;
        this.rn_version = str3;
        this.instance_time = l;
        this.view_time = l2;
        this.session_id = str4;
        this.timestamp = l3;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5079O000000o = this.bundle_name;
        o000000o.O00000Oo = this.bundle_using_version;
        o000000o.O00000o0 = this.rn_version;
        o000000o.O00000o = this.instance_time;
        o000000o.O00000oO = this.view_time;
        o000000o.O00000oo = this.session_id;
        o000000o.O0000O0o = this.timestamp;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_RN_LoadBundle)) {
            return false;
        }
        Value_RN_LoadBundle value_RN_LoadBundle = (Value_RN_LoadBundle) obj;
        return Internal.equals(unknownFields(), value_RN_LoadBundle.unknownFields()) && Internal.equals(this.bundle_name, value_RN_LoadBundle.bundle_name) && Internal.equals(this.bundle_using_version, value_RN_LoadBundle.bundle_using_version) && Internal.equals(this.rn_version, value_RN_LoadBundle.rn_version) && Internal.equals(this.instance_time, value_RN_LoadBundle.instance_time) && Internal.equals(this.view_time, value_RN_LoadBundle.view_time) && Internal.equals(this.session_id, value_RN_LoadBundle.session_id) && Internal.equals(this.timestamp, value_RN_LoadBundle.timestamp);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.bundle_name;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.bundle_using_version;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.rn_version;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.instance_time;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.view_time;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str4 = this.session_id;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l3 = this.timestamp;
        if (l3 != null) {
            i2 = l3.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bundle_name != null) {
            sb.append(", bundle_name=");
            sb.append(this.bundle_name);
        }
        if (this.bundle_using_version != null) {
            sb.append(", bundle_using_version=");
            sb.append(this.bundle_using_version);
        }
        if (this.rn_version != null) {
            sb.append(", rn_version=");
            sb.append(this.rn_version);
        }
        if (this.instance_time != null) {
            sb.append(", instance_time=");
            sb.append(this.instance_time);
        }
        if (this.view_time != null) {
            sb.append(", view_time=");
            sb.append(this.view_time);
        }
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_RN_LoadBundle{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_RN_LoadBundle, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5079O000000o;
        public String O00000Oo;
        public Long O00000o;
        public String O00000o0;
        public Long O00000oO;
        public String O00000oo;
        public Long O0000O0o;

        /* renamed from: O000000o */
        public final Value_RN_LoadBundle build() {
            return new Value_RN_LoadBundle(this.f5079O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_RN_LoadBundle> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_RN_LoadBundle value_RN_LoadBundle = (Value_RN_LoadBundle) obj;
            if (value_RN_LoadBundle.bundle_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_RN_LoadBundle.bundle_name);
            }
            if (value_RN_LoadBundle.bundle_using_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, value_RN_LoadBundle.bundle_using_version);
            }
            if (value_RN_LoadBundle.rn_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, value_RN_LoadBundle.rn_version);
            }
            if (value_RN_LoadBundle.instance_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, value_RN_LoadBundle.instance_time);
            }
            if (value_RN_LoadBundle.view_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, value_RN_LoadBundle.view_time);
            }
            if (value_RN_LoadBundle.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, value_RN_LoadBundle.session_id);
            }
            if (value_RN_LoadBundle.timestamp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, value_RN_LoadBundle.timestamp);
            }
            protoWriter.writeBytes(value_RN_LoadBundle.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_RN_LoadBundle value_RN_LoadBundle = (Value_RN_LoadBundle) obj;
            int i = 0;
            int encodedSizeWithTag = (value_RN_LoadBundle.bundle_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_RN_LoadBundle.bundle_name) : 0) + (value_RN_LoadBundle.bundle_using_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value_RN_LoadBundle.bundle_using_version) : 0) + (value_RN_LoadBundle.rn_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value_RN_LoadBundle.rn_version) : 0) + (value_RN_LoadBundle.instance_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(4, value_RN_LoadBundle.instance_time) : 0) + (value_RN_LoadBundle.view_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(5, value_RN_LoadBundle.view_time) : 0) + (value_RN_LoadBundle.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, value_RN_LoadBundle.session_id) : 0);
            if (value_RN_LoadBundle.timestamp != null) {
                i = ProtoAdapter.INT64.encodedSizeWithTag(7, value_RN_LoadBundle.timestamp);
            }
            return encodedSizeWithTag + i + value_RN_LoadBundle.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_RN_LoadBundle) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_RN_LoadBundle.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.f5079O000000o = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 2:
                            o000000o.O00000Oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 3:
                            o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 4:
                            o000000o.O00000o = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 5:
                            o000000o.O00000oO = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 6:
                            o000000o.O00000oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 7:
                            o000000o.O0000O0o = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                    }
                } else {
                    protoReader.endMessage(beginMessage);
                    return o000000o.build();
                }
            }
        }
    }
}
