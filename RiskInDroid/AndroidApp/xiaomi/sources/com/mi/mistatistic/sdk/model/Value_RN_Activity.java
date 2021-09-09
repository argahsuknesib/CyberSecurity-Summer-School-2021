package com.mi.mistatistic.sdk.model;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class Value_RN_Activity extends Message<Value_RN_Activity, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_RN_Activity> f5074O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    public static final Long O00000o = 0L;
    public static final Long O00000o0 = 0L;
    public static final Long O00000oO = 0L;
    public static final Long O00000oo = 0L;
    public static final Long O0000O0o = 0L;
    public static final Long O0000OOo = 0L;
    public static final Long O0000Oo = 0L;
    public static final Long O0000Oo0 = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String bundle_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String bundle_using_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 10)
    public final Long componentDidMount_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final Long componentWillMount_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long constructor_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 13)
    public final Long init_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long onCreate_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    public final Long onResume_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long onStart_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REPEATED, tag = 9)
    public final List<Long> render_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final String rn_info;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String rn_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final Long timestamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 14)
    public final Long total_load_time;

    public Value_RN_Activity(String str, String str2, String str3, Long l, Long l2, Long l3, Long l4, Long l5, List<Long> list, Long l6, String str4, Long l7, Long l8, Long l9, String str5, ByteString byteString) {
        super(f5074O000000o, byteString);
        this.bundle_name = str;
        this.bundle_using_version = str2;
        this.rn_version = str3;
        this.onCreate_time = l;
        this.onStart_time = l2;
        this.onResume_time = l3;
        this.constructor_time = l4;
        this.componentWillMount_time = l5;
        this.render_time = Internal.immutableCopyOf("render_time", list);
        this.componentDidMount_time = l6;
        this.session_id = str4;
        this.timestamp = l7;
        this.init_time = l8;
        this.total_load_time = l9;
        this.rn_info = str5;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5075O000000o = this.bundle_name;
        o000000o.O00000Oo = this.bundle_using_version;
        o000000o.O00000o0 = this.rn_version;
        o000000o.O00000o = this.onCreate_time;
        o000000o.O00000oO = this.onStart_time;
        o000000o.O00000oo = this.onResume_time;
        o000000o.O0000O0o = this.constructor_time;
        o000000o.O0000OOo = this.componentWillMount_time;
        o000000o.O0000Oo0 = Internal.copyOf("render_time", this.render_time);
        o000000o.O0000Oo = this.componentDidMount_time;
        o000000o.O0000OoO = this.session_id;
        o000000o.O0000Ooo = this.timestamp;
        o000000o.O0000o00 = this.init_time;
        o000000o.O0000o0 = this.total_load_time;
        o000000o.O0000o0O = this.rn_info;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_RN_Activity)) {
            return false;
        }
        Value_RN_Activity value_RN_Activity = (Value_RN_Activity) obj;
        return Internal.equals(unknownFields(), value_RN_Activity.unknownFields()) && Internal.equals(this.bundle_name, value_RN_Activity.bundle_name) && Internal.equals(this.bundle_using_version, value_RN_Activity.bundle_using_version) && Internal.equals(this.rn_version, value_RN_Activity.rn_version) && Internal.equals(this.onCreate_time, value_RN_Activity.onCreate_time) && Internal.equals(this.onStart_time, value_RN_Activity.onStart_time) && Internal.equals(this.onResume_time, value_RN_Activity.onResume_time) && Internal.equals(this.constructor_time, value_RN_Activity.constructor_time) && Internal.equals(this.componentWillMount_time, value_RN_Activity.componentWillMount_time) && Internal.equals(this.render_time, value_RN_Activity.render_time) && Internal.equals(this.componentDidMount_time, value_RN_Activity.componentDidMount_time) && Internal.equals(this.session_id, value_RN_Activity.session_id) && Internal.equals(this.timestamp, value_RN_Activity.timestamp) && Internal.equals(this.init_time, value_RN_Activity.init_time) && Internal.equals(this.total_load_time, value_RN_Activity.total_load_time) && Internal.equals(this.rn_info, value_RN_Activity.rn_info);
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
        Long l = this.onCreate_time;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.onStart_time;
        int hashCode6 = (hashCode5 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.onResume_time;
        int hashCode7 = (hashCode6 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.constructor_time;
        int hashCode8 = (hashCode7 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Long l5 = this.componentWillMount_time;
        int hashCode9 = (hashCode8 + (l5 != null ? l5.hashCode() : 0)) * 37;
        List<Long> list = this.render_time;
        int hashCode10 = (hashCode9 + (list != null ? list.hashCode() : 1)) * 37;
        Long l6 = this.componentDidMount_time;
        int hashCode11 = (hashCode10 + (l6 != null ? l6.hashCode() : 0)) * 37;
        String str4 = this.session_id;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l7 = this.timestamp;
        int hashCode13 = (hashCode12 + (l7 != null ? l7.hashCode() : 0)) * 37;
        Long l8 = this.init_time;
        int hashCode14 = (hashCode13 + (l8 != null ? l8.hashCode() : 0)) * 37;
        Long l9 = this.total_load_time;
        int hashCode15 = (hashCode14 + (l9 != null ? l9.hashCode() : 0)) * 37;
        String str5 = this.rn_info;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        int i3 = hashCode15 + i2;
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
        if (this.onCreate_time != null) {
            sb.append(", onCreate_time=");
            sb.append(this.onCreate_time);
        }
        if (this.onStart_time != null) {
            sb.append(", onStart_time=");
            sb.append(this.onStart_time);
        }
        if (this.onResume_time != null) {
            sb.append(", onResume_time=");
            sb.append(this.onResume_time);
        }
        if (this.constructor_time != null) {
            sb.append(", constructor_time=");
            sb.append(this.constructor_time);
        }
        if (this.componentWillMount_time != null) {
            sb.append(", componentWillMount_time=");
            sb.append(this.componentWillMount_time);
        }
        if (this.render_time != null) {
            sb.append(", render_time=");
            sb.append(this.render_time);
        }
        if (this.componentDidMount_time != null) {
            sb.append(", componentDidMount_time=");
            sb.append(this.componentDidMount_time);
        }
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        if (this.init_time != null) {
            sb.append(", init_time=");
            sb.append(this.init_time);
        }
        if (this.total_load_time != null) {
            sb.append(", total_load_time=");
            sb.append(this.total_load_time);
        }
        if (this.rn_info != null) {
            sb.append(", rn_info=");
            sb.append(this.rn_info);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_RN_Activity{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_RN_Activity, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5075O000000o;
        public String O00000Oo;
        public Long O00000o;
        public String O00000o0;
        public Long O00000oO;
        public Long O00000oo;
        public Long O0000O0o;
        public Long O0000OOo;
        public Long O0000Oo;
        public List<Long> O0000Oo0 = Internal.newMutableList();
        public String O0000OoO;
        public Long O0000Ooo;
        public Long O0000o0;
        public Long O0000o00;
        public String O0000o0O;

        /* renamed from: O000000o */
        public final Value_RN_Activity build() {
            return new Value_RN_Activity(this.f5075O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000Ooo, this.O0000o00, this.O0000o0, this.O0000o0O, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_RN_Activity> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_RN_Activity value_RN_Activity = (Value_RN_Activity) obj;
            if (value_RN_Activity.bundle_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_RN_Activity.bundle_name);
            }
            if (value_RN_Activity.bundle_using_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, value_RN_Activity.bundle_using_version);
            }
            if (value_RN_Activity.rn_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, value_RN_Activity.rn_version);
            }
            if (value_RN_Activity.onCreate_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 4, value_RN_Activity.onCreate_time);
            }
            if (value_RN_Activity.onStart_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, value_RN_Activity.onStart_time);
            }
            if (value_RN_Activity.onResume_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 6, value_RN_Activity.onResume_time);
            }
            if (value_RN_Activity.constructor_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, value_RN_Activity.constructor_time);
            }
            if (value_RN_Activity.componentWillMount_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, value_RN_Activity.componentWillMount_time);
            }
            if (value_RN_Activity.render_time != null) {
                ProtoAdapter.INT64.asRepeated().encodeWithTag(protoWriter, 9, value_RN_Activity.render_time);
            }
            if (value_RN_Activity.componentDidMount_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 10, value_RN_Activity.componentDidMount_time);
            }
            if (value_RN_Activity.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, value_RN_Activity.session_id);
            }
            if (value_RN_Activity.timestamp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 12, value_RN_Activity.timestamp);
            }
            if (value_RN_Activity.init_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 13, value_RN_Activity.init_time);
            }
            if (value_RN_Activity.total_load_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 14, value_RN_Activity.total_load_time);
            }
            if (value_RN_Activity.rn_info != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 15, value_RN_Activity.rn_info);
            }
            protoWriter.writeBytes(value_RN_Activity.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_RN_Activity value_RN_Activity = (Value_RN_Activity) obj;
            int i = 0;
            int encodedSizeWithTag = (value_RN_Activity.bundle_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_RN_Activity.bundle_name) : 0) + (value_RN_Activity.bundle_using_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value_RN_Activity.bundle_using_version) : 0) + (value_RN_Activity.rn_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value_RN_Activity.rn_version) : 0) + (value_RN_Activity.onCreate_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(4, value_RN_Activity.onCreate_time) : 0) + (value_RN_Activity.onStart_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(5, value_RN_Activity.onStart_time) : 0) + (value_RN_Activity.onResume_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(6, value_RN_Activity.onResume_time) : 0) + (value_RN_Activity.constructor_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(7, value_RN_Activity.constructor_time) : 0) + (value_RN_Activity.componentWillMount_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(8, value_RN_Activity.componentWillMount_time) : 0) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(9, value_RN_Activity.render_time) + (value_RN_Activity.componentDidMount_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(10, value_RN_Activity.componentDidMount_time) : 0) + (value_RN_Activity.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, value_RN_Activity.session_id) : 0) + (value_RN_Activity.timestamp != null ? ProtoAdapter.INT64.encodedSizeWithTag(12, value_RN_Activity.timestamp) : 0) + (value_RN_Activity.init_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(13, value_RN_Activity.init_time) : 0) + (value_RN_Activity.total_load_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(14, value_RN_Activity.total_load_time) : 0);
            if (value_RN_Activity.rn_info != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(15, value_RN_Activity.rn_info);
            }
            return encodedSizeWithTag + i + value_RN_Activity.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_RN_Activity) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_RN_Activity.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.f5075O000000o = ProtoAdapter.STRING.decode(protoReader);
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
                            o000000o.O00000oo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 7:
                            o000000o.O0000O0o = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            o000000o.O0000OOo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 9:
                            o000000o.O0000Oo0.add(ProtoAdapter.INT64.decode(protoReader));
                            break;
                        case 10:
                            o000000o.O0000Oo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 11:
                            o000000o.O0000OoO = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            o000000o.O0000Ooo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 13:
                            o000000o.O0000o00 = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 14:
                            o000000o.O0000o0 = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            o000000o.O0000o0O = ProtoAdapter.STRING.decode(protoReader);
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
