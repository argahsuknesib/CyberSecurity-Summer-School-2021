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
import no.nordicsemi.android.dfu.DfuSettingsConstants;
import okio.ByteString;

public final class Value_RN_Download extends Message<Value_RN_Download, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Value_RN_Download> f5076O000000o = new O00000Oo();
    public static final Long O00000Oo = 0L;
    public static final Long O00000o = 0L;
    public static final Long O00000o0 = 0L;
    public static final Long O00000oO = 0L;
    public static final Long O00000oo = 0L;
    public static final Integer O0000O0o = 0;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String bundle_download_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String bundle_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String bundle_using_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 11)
    public final Integer code;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long download_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String err_message;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final Long md5_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 7)
    public final Long patch_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String rn_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String session_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 10)
    public final Long timestamp;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 6)
    public final Long unzip_time;

    public Value_RN_Download(String str, String str2, String str3, String str4, Long l, Long l2, Long l3, Long l4, String str5, Long l5, Integer num, String str6, ByteString byteString) {
        super(f5076O000000o, byteString);
        this.bundle_name = str;
        this.bundle_download_version = str2;
        this.bundle_using_version = str3;
        this.rn_version = str4;
        this.download_time = l;
        this.unzip_time = l2;
        this.patch_time = l3;
        this.md5_time = l4;
        this.session_id = str5;
        this.timestamp = l5;
        this.code = num;
        this.err_message = str6;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5077O000000o = this.bundle_name;
        o000000o.O00000Oo = this.bundle_download_version;
        o000000o.O00000o0 = this.bundle_using_version;
        o000000o.O00000o = this.rn_version;
        o000000o.O00000oO = this.download_time;
        o000000o.O00000oo = this.unzip_time;
        o000000o.O0000O0o = this.patch_time;
        o000000o.O0000OOo = this.md5_time;
        o000000o.O0000Oo0 = this.session_id;
        o000000o.O0000Oo = this.timestamp;
        o000000o.O0000OoO = this.code;
        o000000o.O0000Ooo = this.err_message;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value_RN_Download)) {
            return false;
        }
        Value_RN_Download value_RN_Download = (Value_RN_Download) obj;
        return Internal.equals(unknownFields(), value_RN_Download.unknownFields()) && Internal.equals(this.bundle_name, value_RN_Download.bundle_name) && Internal.equals(this.bundle_download_version, value_RN_Download.bundle_download_version) && Internal.equals(this.bundle_using_version, value_RN_Download.bundle_using_version) && Internal.equals(this.rn_version, value_RN_Download.rn_version) && Internal.equals(this.download_time, value_RN_Download.download_time) && Internal.equals(this.unzip_time, value_RN_Download.unzip_time) && Internal.equals(this.patch_time, value_RN_Download.patch_time) && Internal.equals(this.md5_time, value_RN_Download.md5_time) && Internal.equals(this.session_id, value_RN_Download.session_id) && Internal.equals(this.timestamp, value_RN_Download.timestamp) && Internal.equals(this.code, value_RN_Download.code) && Internal.equals(this.err_message, value_RN_Download.err_message);
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
        String str2 = this.bundle_download_version;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.bundle_using_version;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.rn_version;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l = this.download_time;
        int hashCode6 = (hashCode5 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.unzip_time;
        int hashCode7 = (hashCode6 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Long l3 = this.patch_time;
        int hashCode8 = (hashCode7 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Long l4 = this.md5_time;
        int hashCode9 = (hashCode8 + (l4 != null ? l4.hashCode() : 0)) * 37;
        String str5 = this.session_id;
        int hashCode10 = (hashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Long l5 = this.timestamp;
        int hashCode11 = (hashCode10 + (l5 != null ? l5.hashCode() : 0)) * 37;
        Integer num = this.code;
        int hashCode12 = (hashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        String str6 = this.err_message;
        if (str6 != null) {
            i2 = str6.hashCode();
        }
        int i3 = hashCode12 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.bundle_name != null) {
            sb.append(", bundle_name=");
            sb.append(this.bundle_name);
        }
        if (this.bundle_download_version != null) {
            sb.append(", bundle_download_version=");
            sb.append(this.bundle_download_version);
        }
        if (this.bundle_using_version != null) {
            sb.append(", bundle_using_version=");
            sb.append(this.bundle_using_version);
        }
        if (this.rn_version != null) {
            sb.append(", rn_version=");
            sb.append(this.rn_version);
        }
        if (this.download_time != null) {
            sb.append(", download_time=");
            sb.append(this.download_time);
        }
        if (this.unzip_time != null) {
            sb.append(", unzip_time=");
            sb.append(this.unzip_time);
        }
        if (this.patch_time != null) {
            sb.append(", patch_time=");
            sb.append(this.patch_time);
        }
        if (this.md5_time != null) {
            sb.append(", md5_time=");
            sb.append(this.md5_time);
        }
        if (this.session_id != null) {
            sb.append(", session_id=");
            sb.append(this.session_id);
        }
        if (this.timestamp != null) {
            sb.append(", timestamp=");
            sb.append(this.timestamp);
        }
        if (this.code != null) {
            sb.append(", code=");
            sb.append(this.code);
        }
        if (this.err_message != null) {
            sb.append(", err_message=");
            sb.append(this.err_message);
        }
        StringBuilder replace = sb.replace(0, 2, "Value_RN_Download{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Value_RN_Download, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5077O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public Long O00000oO;
        public Long O00000oo;
        public Long O0000O0o;
        public Long O0000OOo;
        public Long O0000Oo;
        public String O0000Oo0;
        public Integer O0000OoO;
        public String O0000Ooo;

        /* renamed from: O000000o */
        public final Value_RN_Download build() {
            return new Value_RN_Download(this.f5077O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000Ooo, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Value_RN_Download> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Value_RN_Download value_RN_Download = (Value_RN_Download) obj;
            if (value_RN_Download.bundle_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, value_RN_Download.bundle_name);
            }
            if (value_RN_Download.bundle_download_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, value_RN_Download.bundle_download_version);
            }
            if (value_RN_Download.bundle_using_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, value_RN_Download.bundle_using_version);
            }
            if (value_RN_Download.rn_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, value_RN_Download.rn_version);
            }
            if (value_RN_Download.download_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 5, value_RN_Download.download_time);
            }
            if (value_RN_Download.unzip_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 6, value_RN_Download.unzip_time);
            }
            if (value_RN_Download.patch_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 7, value_RN_Download.patch_time);
            }
            if (value_RN_Download.md5_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 8, value_RN_Download.md5_time);
            }
            if (value_RN_Download.session_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, value_RN_Download.session_id);
            }
            if (value_RN_Download.timestamp != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 10, value_RN_Download.timestamp);
            }
            if (value_RN_Download.code != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 11, value_RN_Download.code);
            }
            if (value_RN_Download.err_message != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, value_RN_Download.err_message);
            }
            protoWriter.writeBytes(value_RN_Download.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Value_RN_Download value_RN_Download = (Value_RN_Download) obj;
            int i = 0;
            int encodedSizeWithTag = (value_RN_Download.bundle_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, value_RN_Download.bundle_name) : 0) + (value_RN_Download.bundle_download_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, value_RN_Download.bundle_download_version) : 0) + (value_RN_Download.bundle_using_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, value_RN_Download.bundle_using_version) : 0) + (value_RN_Download.rn_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, value_RN_Download.rn_version) : 0) + (value_RN_Download.download_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(5, value_RN_Download.download_time) : 0) + (value_RN_Download.unzip_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(6, value_RN_Download.unzip_time) : 0) + (value_RN_Download.patch_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(7, value_RN_Download.patch_time) : 0) + (value_RN_Download.md5_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(8, value_RN_Download.md5_time) : 0) + (value_RN_Download.session_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, value_RN_Download.session_id) : 0) + (value_RN_Download.timestamp != null ? ProtoAdapter.INT64.encodedSizeWithTag(10, value_RN_Download.timestamp) : 0) + (value_RN_Download.code != null ? ProtoAdapter.INT32.encodedSizeWithTag(11, value_RN_Download.code) : 0);
            if (value_RN_Download.err_message != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(12, value_RN_Download.err_message);
            }
            return encodedSizeWithTag + i + value_RN_Download.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Value_RN_Download) obj).newBuilder();
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Value_RN_Download.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.f5077O000000o = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 2:
                            o000000o.O00000Oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 3:
                            o000000o.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 4:
                            o000000o.O00000o = ProtoAdapter.STRING.decode(protoReader);
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
                            o000000o.O0000Oo0 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 10:
                            o000000o.O0000Oo = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 11:
                            o000000o.O0000OoO = ProtoAdapter.INT32.decode(protoReader);
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            o000000o.O0000Ooo = ProtoAdapter.STRING.decode(protoReader);
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
