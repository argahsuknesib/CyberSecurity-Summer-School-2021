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

public final class Stat extends Message<Stat, O000000o> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ProtoAdapter<Stat> f5066O000000o = new O00000Oo();
    public static final Integer O00000Oo = 0;
    public static final Long O00000o = 0L;
    public static final Long O00000o0 = 0L;
    private static final long serialVersionUID = 0;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 1)
    public final String app_key;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String app_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String channel;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 17)
    public final String client_ip;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 20)
    public final Long collect_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String device_id;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER)
    public final String device_name;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String imei;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 21)
    public final String install_from;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String interval;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 14)
    public final String language;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String mac;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String miui_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String os_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT)
    public final String policy;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 18)
    public final Long report_time;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String sdk_version;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String sign;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT32", tag = GmsLogger.MAX_PII_TAG_LENGTH)
    public final Integer size;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 22)
    public final String start_from;
    @WireField(adapter = "appstat.Value#ADAPTER", label = WireField.Label.REPEATED, tag = 16)
    public final List<Value> stat_values;
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 19)
    public final String user_id;

    public Stat(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Integer num, List<Value> list, String str15, Long l, String str16, Long l2, String str17, String str18, ByteString byteString) {
        super(f5066O000000o, byteString);
        this.app_key = str;
        this.miui_version = str2;
        this.os_version = str3;
        this.sdk_version = str4;
        this.app_version = str5;
        this.channel = str6;
        this.device_id = str7;
        this.device_name = str8;
        this.mac = str9;
        this.imei = str10;
        this.interval = str11;
        this.policy = str12;
        this.sign = str13;
        this.language = str14;
        this.size = num;
        this.stat_values = Internal.immutableCopyOf("stat_values", list);
        this.client_ip = str15;
        this.report_time = l;
        this.user_id = str16;
        this.collect_time = l2;
        this.install_from = str17;
        this.start_from = str18;
    }

    /* renamed from: O000000o */
    public final O000000o newBuilder() {
        O000000o o000000o = new O000000o();
        o000000o.f5067O000000o = this.app_key;
        o000000o.O00000Oo = this.miui_version;
        o000000o.O00000o0 = this.os_version;
        o000000o.O00000o = this.sdk_version;
        o000000o.O00000oO = this.app_version;
        o000000o.O00000oo = this.channel;
        o000000o.O0000O0o = this.device_id;
        o000000o.O0000OOo = this.device_name;
        o000000o.O0000Oo0 = this.mac;
        o000000o.O0000Oo = this.imei;
        o000000o.O0000OoO = this.interval;
        o000000o.O0000Ooo = this.policy;
        o000000o.O0000o00 = this.sign;
        o000000o.O0000o0 = this.language;
        o000000o.O0000o0O = this.size;
        o000000o.O0000o0o = Internal.copyOf("stat_values", this.stat_values);
        o000000o.O0000o = this.client_ip;
        o000000o.O0000oO0 = this.report_time;
        o000000o.O0000oO = this.user_id;
        o000000o.O0000oOO = this.collect_time;
        o000000o.O0000oOo = this.install_from;
        o000000o.O0000oo0 = this.start_from;
        o000000o.addUnknownFields(unknownFields());
        return o000000o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Stat)) {
            return false;
        }
        Stat stat = (Stat) obj;
        return Internal.equals(unknownFields(), stat.unknownFields()) && Internal.equals(this.app_key, stat.app_key) && Internal.equals(this.miui_version, stat.miui_version) && Internal.equals(this.os_version, stat.os_version) && Internal.equals(this.sdk_version, stat.sdk_version) && Internal.equals(this.app_version, stat.app_version) && Internal.equals(this.channel, stat.channel) && Internal.equals(this.device_id, stat.device_id) && Internal.equals(this.device_name, stat.device_name) && Internal.equals(this.mac, stat.mac) && Internal.equals(this.imei, stat.imei) && Internal.equals(this.interval, stat.interval) && Internal.equals(this.policy, stat.policy) && Internal.equals(this.sign, stat.sign) && Internal.equals(this.language, stat.language) && Internal.equals(this.size, stat.size) && Internal.equals(this.stat_values, stat.stat_values) && Internal.equals(this.client_ip, stat.client_ip) && Internal.equals(this.report_time, stat.report_time) && Internal.equals(this.user_id, stat.user_id) && Internal.equals(this.collect_time, stat.collect_time) && Internal.equals(this.install_from, stat.install_from) && Internal.equals(this.start_from, stat.start_from);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = unknownFields().hashCode() * 37;
        String str = this.app_key;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.miui_version;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.os_version;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.sdk_version;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.app_version;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.channel;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.device_id;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 37;
        String str8 = this.device_name;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.mac;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 37;
        String str10 = this.imei;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 37;
        String str11 = this.interval;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 37;
        String str12 = this.policy;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.sign;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 37;
        String str14 = this.language;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 37;
        Integer num = this.size;
        int hashCode16 = (hashCode15 + (num != null ? num.hashCode() : 0)) * 37;
        List<Value> list = this.stat_values;
        int hashCode17 = (hashCode16 + (list != null ? list.hashCode() : 1)) * 37;
        String str15 = this.client_ip;
        int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 37;
        Long l = this.report_time;
        int hashCode19 = (hashCode18 + (l != null ? l.hashCode() : 0)) * 37;
        String str16 = this.user_id;
        int hashCode20 = (hashCode19 + (str16 != null ? str16.hashCode() : 0)) * 37;
        Long l2 = this.collect_time;
        int hashCode21 = (hashCode20 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str17 = this.install_from;
        int hashCode22 = (hashCode21 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.start_from;
        if (str18 != null) {
            i2 = str18.hashCode();
        }
        int i3 = hashCode22 + i2;
        this.hashCode = i3;
        return i3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.app_key != null) {
            sb.append(", app_key=");
            sb.append(this.app_key);
        }
        if (this.miui_version != null) {
            sb.append(", miui_version=");
            sb.append(this.miui_version);
        }
        if (this.os_version != null) {
            sb.append(", os_version=");
            sb.append(this.os_version);
        }
        if (this.sdk_version != null) {
            sb.append(", sdk_version=");
            sb.append(this.sdk_version);
        }
        if (this.app_version != null) {
            sb.append(", app_version=");
            sb.append(this.app_version);
        }
        if (this.channel != null) {
            sb.append(", channel=");
            sb.append(this.channel);
        }
        if (this.device_id != null) {
            sb.append(", device_id=");
            sb.append(this.device_id);
        }
        if (this.device_name != null) {
            sb.append(", device_name=");
            sb.append(this.device_name);
        }
        if (this.mac != null) {
            sb.append(", mac=");
            sb.append(this.mac);
        }
        if (this.imei != null) {
            sb.append(", imei=");
            sb.append(this.imei);
        }
        if (this.interval != null) {
            sb.append(", interval=");
            sb.append(this.interval);
        }
        if (this.policy != null) {
            sb.append(", policy=");
            sb.append(this.policy);
        }
        if (this.sign != null) {
            sb.append(", sign=");
            sb.append(this.sign);
        }
        if (this.language != null) {
            sb.append(", language=");
            sb.append(this.language);
        }
        if (this.size != null) {
            sb.append(", size=");
            sb.append(this.size);
        }
        if (this.stat_values != null) {
            sb.append(", stat_values=");
            sb.append(this.stat_values);
        }
        if (this.client_ip != null) {
            sb.append(", client_ip=");
            sb.append(this.client_ip);
        }
        if (this.report_time != null) {
            sb.append(", report_time=");
            sb.append(this.report_time);
        }
        if (this.user_id != null) {
            sb.append(", user_id=");
            sb.append(this.user_id);
        }
        if (this.collect_time != null) {
            sb.append(", collect_time=");
            sb.append(this.collect_time);
        }
        if (this.install_from != null) {
            sb.append(", install_from=");
            sb.append(this.install_from);
        }
        if (this.start_from != null) {
            sb.append(", start_from=");
            sb.append(this.start_from);
        }
        StringBuilder replace = sb.replace(0, 2, "Stat{");
        replace.append('}');
        return replace.toString();
    }

    public static final class O000000o extends Message.Builder<Stat, O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f5067O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public String O0000OOo;
        public String O0000Oo;
        public String O0000Oo0;
        public String O0000OoO;
        public String O0000Ooo;
        public String O0000o;
        public String O0000o0;
        public String O0000o00;
        public Integer O0000o0O;
        public List<Value> O0000o0o = Internal.newMutableList();
        public String O0000oO;
        public Long O0000oO0;
        public Long O0000oOO;
        public String O0000oOo;
        public String O0000oo0;

        /* renamed from: O000000o */
        public final Stat build() {
            return new Stat(this.f5067O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.O0000OOo, this.O0000Oo0, this.O0000Oo, this.O0000OoO, this.O0000Ooo, this.O0000o00, this.O0000o0, this.O0000o0O, this.O0000o0o, this.O0000o, this.O0000oO0, this.O0000oO, this.O0000oOO, this.O0000oOo, this.O0000oo0, buildUnknownFields());
        }
    }

    static final class O00000Oo extends ProtoAdapter<Stat> {
        public final /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) throws IOException {
            Stat stat = (Stat) obj;
            if (stat.app_key != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, stat.app_key);
            }
            if (stat.miui_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 2, stat.miui_version);
            }
            if (stat.os_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 3, stat.os_version);
            }
            if (stat.sdk_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 4, stat.sdk_version);
            }
            if (stat.app_version != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 5, stat.app_version);
            }
            if (stat.channel != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 6, stat.channel);
            }
            if (stat.device_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 7, stat.device_id);
            }
            if (stat.device_name != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 8, stat.device_name);
            }
            if (stat.mac != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 9, stat.mac);
            }
            if (stat.imei != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 10, stat.imei);
            }
            if (stat.interval != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 11, stat.interval);
            }
            if (stat.policy != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 12, stat.policy);
            }
            if (stat.sign != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 13, stat.sign);
            }
            if (stat.language != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 14, stat.language);
            }
            if (stat.size != null) {
                ProtoAdapter.INT32.encodeWithTag(protoWriter, 15, stat.size);
            }
            if (stat.stat_values != null) {
                Value.f5068O000000o.asRepeated().encodeWithTag(protoWriter, 16, stat.stat_values);
            }
            if (stat.client_ip != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 17, stat.client_ip);
            }
            if (stat.report_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 18, stat.report_time);
            }
            if (stat.user_id != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 19, stat.user_id);
            }
            if (stat.collect_time != null) {
                ProtoAdapter.INT64.encodeWithTag(protoWriter, 20, stat.collect_time);
            }
            if (stat.install_from != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 21, stat.install_from);
            }
            if (stat.start_from != null) {
                ProtoAdapter.STRING.encodeWithTag(protoWriter, 22, stat.start_from);
            }
            protoWriter.writeBytes(stat.unknownFields());
        }

        public final /* synthetic */ int encodedSize(Object obj) {
            Stat stat = (Stat) obj;
            int i = 0;
            int encodedSizeWithTag = (stat.app_key != null ? ProtoAdapter.STRING.encodedSizeWithTag(1, stat.app_key) : 0) + (stat.miui_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(2, stat.miui_version) : 0) + (stat.os_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(3, stat.os_version) : 0) + (stat.sdk_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(4, stat.sdk_version) : 0) + (stat.app_version != null ? ProtoAdapter.STRING.encodedSizeWithTag(5, stat.app_version) : 0) + (stat.channel != null ? ProtoAdapter.STRING.encodedSizeWithTag(6, stat.channel) : 0) + (stat.device_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(7, stat.device_id) : 0) + (stat.device_name != null ? ProtoAdapter.STRING.encodedSizeWithTag(8, stat.device_name) : 0) + (stat.mac != null ? ProtoAdapter.STRING.encodedSizeWithTag(9, stat.mac) : 0) + (stat.imei != null ? ProtoAdapter.STRING.encodedSizeWithTag(10, stat.imei) : 0) + (stat.interval != null ? ProtoAdapter.STRING.encodedSizeWithTag(11, stat.interval) : 0) + (stat.policy != null ? ProtoAdapter.STRING.encodedSizeWithTag(12, stat.policy) : 0) + (stat.sign != null ? ProtoAdapter.STRING.encodedSizeWithTag(13, stat.sign) : 0) + (stat.language != null ? ProtoAdapter.STRING.encodedSizeWithTag(14, stat.language) : 0) + (stat.size != null ? ProtoAdapter.INT32.encodedSizeWithTag(15, stat.size) : 0) + Value.f5068O000000o.asRepeated().encodedSizeWithTag(16, stat.stat_values) + (stat.client_ip != null ? ProtoAdapter.STRING.encodedSizeWithTag(17, stat.client_ip) : 0) + (stat.report_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(18, stat.report_time) : 0) + (stat.user_id != null ? ProtoAdapter.STRING.encodedSizeWithTag(19, stat.user_id) : 0) + (stat.collect_time != null ? ProtoAdapter.INT64.encodedSizeWithTag(20, stat.collect_time) : 0) + (stat.install_from != null ? ProtoAdapter.STRING.encodedSizeWithTag(21, stat.install_from) : 0);
            if (stat.start_from != null) {
                i = ProtoAdapter.STRING.encodedSizeWithTag(22, stat.start_from);
            }
            return encodedSizeWithTag + i + stat.unknownFields().O0000OOo();
        }

        public final /* synthetic */ Object redact(Object obj) {
            O000000o O000000o2 = ((Stat) obj).newBuilder();
            Internal.redactElements(O000000o2.O0000o0o, Value.f5068O000000o);
            O000000o2.clearUnknownFields();
            return O000000o2.build();
        }

        O00000Oo() {
            super(FieldEncoding.LENGTH_DELIMITED, Stat.class);
        }

        public final /* synthetic */ Object decode(ProtoReader protoReader) throws IOException {
            O000000o o000000o = new O000000o();
            long beginMessage = protoReader.beginMessage();
            while (true) {
                int nextTag = protoReader.nextTag();
                if (nextTag != -1) {
                    switch (nextTag) {
                        case 1:
                            o000000o.f5067O000000o = ProtoAdapter.STRING.decode(protoReader);
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
                            o000000o.O00000oO = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 6:
                            o000000o.O00000oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 7:
                            o000000o.O0000O0o = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                            o000000o.O0000OOo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 9:
                            o000000o.O0000Oo0 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 10:
                            o000000o.O0000Oo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 11:
                            o000000o.O0000OoO = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                            o000000o.O0000Ooo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 13:
                            o000000o.O0000o00 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 14:
                            o000000o.O0000o0 = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case GmsLogger.MAX_PII_TAG_LENGTH:
                            o000000o.O0000o0O = ProtoAdapter.INT32.decode(protoReader);
                            break;
                        case 16:
                            o000000o.O0000o0o.add(Value.f5068O000000o.decode(protoReader));
                            break;
                        case 17:
                            o000000o.O0000o = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 18:
                            o000000o.O0000oO0 = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 19:
                            o000000o.O0000oO = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 20:
                            o000000o.O0000oOO = ProtoAdapter.INT64.decode(protoReader);
                            break;
                        case 21:
                            o000000o.O0000oOo = ProtoAdapter.STRING.decode(protoReader);
                            break;
                        case 22:
                            o000000o.O0000oo0 = ProtoAdapter.STRING.decode(protoReader);
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
