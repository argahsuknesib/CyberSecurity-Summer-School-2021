package com.mi.mistatistic.sdk.model;

import com.google.android.exoplayer2.C;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

public final class Value_View_Show extends Message<Value_View_Show, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_View_Show> f5086O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    public static final Long O00000o = 0L;
    public static final Long O00000o0 = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String label;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String page_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long page_show_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String view_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long view_leave_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long view_show_time;

    public Value_View_Show(String str, Long l, Long l2, Long l3, String str2, String str3, String str4, ByteString byteString) {
        super(f5086O000000o, byteString);
        this.session_id = str;
        this.view_leave_time = l;
        this.view_show_time = l2;
        this.page_show_time = l3;
        this.view_id = str2;
        this.label = str3;
        this.page_id = str4;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5087O000000o = this.session_id;
        o000000o.O00000Oo = this.view_leave_time;
        o000000o.O00000o0 = this.view_show_time;
        o000000o.O00000o = this.page_show_time;
        o000000o.O00000oO = this.view_id;
        o000000o.O00000oo = this.label;
        o000000o.O0000O0o = this.page_id;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_View_Show)) {
            return false;
        }
        Value_View_Show value_View_Show = (Value_View_Show) obj;
        return Internal.equals(unknownFields(), value_View_Show.unknownFields()) && Internal.equals(this.session_id, value_View_Show.session_id) && Internal.equals(this.view_leave_time, value_View_Show.view_leave_time) && Internal.equals(this.view_show_time, value_View_Show.view_show_time) && Internal.equals(this.page_show_time, value_View_Show.page_show_time) && Internal.equals(this.view_id, value_View_Show.view_id) && Internal.equals(this.label, value_View_Show.label) && Internal.equals(this.page_id, value_View_Show.page_id);
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
        Long l = this.view_leave_time;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.view_show_time;
        int hashCode4 = (hashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.page_show_time;
        int hashCode5 = (hashCode4 + (l3 != null ? l3.hashCode() : 0)) * 37;
        String str2 = this.view_id;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.label;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.page_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        int i3 = hashCode7 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.view_leave_time != null) {
            sb.append(", view_leave_time=");
            sb.append(this.view_leave_time);
        }
        if (this.view_show_time != null) {
            sb.append(", view_show_time=");
            sb.append(this.view_show_time);
        }
        if (this.page_show_time != null) {
            sb.append(", page_show_time=");
            sb.append(this.page_show_time);
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
        StringBuilder replace = sb.replace(0, 2, "Value_View_Show{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_View_Show, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5087O000000o;
        public Long O00000Oo;
        public Long O00000o;
        public Long O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;

        /* renamed from: O000000o */
        public final Value_View_Show build() {
            return new Value_View_Show(this.f5087O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_View_Show> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_View_Show value_View_Show = (Value_View_Show) obj;
            if (value_View_Show.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_View_Show.session_id);
            }
            if (value_View_Show.view_leave_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 3, value_View_Show.view_leave_time);
            }
            if (value_View_Show.view_show_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, value_View_Show.view_show_time);
            }
            if (value_View_Show.page_show_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, value_View_Show.page_show_time);
            }
            if (value_View_Show.view_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, value_View_Show.view_id);
            }
            if (value_View_Show.label != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, value_View_Show.label);
            }
            if (value_View_Show.page_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, value_View_Show.page_id);
            }
            protoWriter.writeBytes(value_View_Show.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_View_Show value_View_Show = (Value_View_Show) obj;
            int i = 0;
            int encodedSizeWithTag = (value_View_Show.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_View_Show.session_id) : 0) + (value_View_Show.view_leave_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(3, value_View_Show.view_leave_time) : 0) + (value_View_Show.view_show_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(4, value_View_Show.view_show_time) : 0) + (value_View_Show.page_show_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(5, value_View_Show.page_show_time) : 0) + (value_View_Show.view_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, value_View_Show.view_id) : 0) + (value_View_Show.label != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, value_View_Show.label) : 0);
            if (value_View_Show.page_id != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(8, value_View_Show.page_id);
            }
            return encodedSizeWithTag + i + value_View_Show.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_View_Show) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_View_Show.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.f5087O000000o = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 2:
                        default:
                            FieldEncoding peekFieldEncoding = protoReader.peekFieldEncoding();
                            o000000o.addUnknownField(nextTag, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(protoReader));
                            break;
                        case 3:
                            o000000o.O00000Oo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 4:
                            o000000o.O00000o0 = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 5:
                            o000000o.O00000o = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 6:
                            o000000o.O00000oO = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 7:
                            o000000o.O00000oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            o000000o.O0000O0o = ProtoAdapter.STRING.decode(protoReader);
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
