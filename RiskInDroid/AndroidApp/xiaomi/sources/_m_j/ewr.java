package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class ewr {
    @SerializedName("COUNTSTATUSSTART")
    @Expose
    public static int O0000oO = 1;
    @SerializedName("COUNTSTATUSPRE")
    @Expose
    public static int O0000oO0 = 0;
    @SerializedName("COUNTSTATUSEND")
    @Expose
    public static int O0000oOO = 2;
    @SerializedName("assembly_id")
    @Expose

    /* renamed from: O000000o  reason: collision with root package name */
    public String f15901O000000o;
    @SerializedName("assembly_key")
    @Expose
    public String O00000Oo;
    @SerializedName("title")
    @Expose
    public String O00000o;
    @SerializedName("background_color")
    @Expose
    public String O00000o0;
    @SerializedName("count_down")
    @Expose
    public String O00000oO;
    @SerializedName("extended")
    @Expose
    public String O00000oo;
    @SerializedName("background_img")
    @Expose
    public String O0000O0o;
    @SerializedName("more_url")
    @Expose
    public String O0000OOo;
    @SerializedName("count_down_color")
    @Expose
    public String O0000Oo;
    @SerializedName("title_color")
    @Expose
    public String O0000Oo0;
    @SerializedName("copy_color")
    @Expose
    public String O0000OoO;
    @SerializedName("number_color")
    @Expose
    public String O0000Ooo;
    @SerializedName("auto_play_interval")
    @Expose
    public int O0000o;
    @SerializedName("timestamp")
    @Expose
    public long O0000o0;
    @SerializedName("number_background_colr")
    @Expose
    public String O0000o00;
    @SerializedName("virtual_name")
    @Expose
    public String O0000o0O;
    @SerializedName("virtual_item_name")
    @Expose
    public String O0000o0o;
    @SerializedName("countStatus")
    @Expose
    public int O0000oOo = O0000oO0;
    @SerializedName("hasShowMore")
    @Expose
    public boolean O0000oo = false;
    @SerializedName("assembly_info")
    @Expose
    public List<O000000o> O0000oo0 = new ArrayList();
    @SerializedName("itemHeight")
    @Expose
    public int O0000ooO = 0;
    @SerializedName("end_time")
    @Expose
    public long O0000ooo;
    @SerializedName("has_remind")
    @Expose
    public boolean O00oOooO;
    @SerializedName("primaryid")
    @Expose
    public long O00oOooo;

    public static class O000000o {
        @SerializedName("view_id")
        @Expose

        /* renamed from: O000000o  reason: collision with root package name */
        public String f15902O000000o;
        @SerializedName("image_url")
        @Expose
        public String O00000Oo;
        @SerializedName("title")
        @Expose
        public String O00000o;
        @SerializedName("go_to_url")
        @Expose
        public String O00000o0;
        @SerializedName("price")
        @Expose
        public String O00000oO;
        @SerializedName("origin_prince")
        @Expose
        public String O00000oo;
        @SerializedName("icon")
        @Expose
        public String O0000O0o;
        @SerializedName("name")
        @Expose
        public String O0000OOo;
        @SerializedName("video_url")
        @Expose
        public String O0000Oo;
        @SerializedName("description")
        @Expose
        public String O0000Oo0;
        @SerializedName("star")
        @Expose
        public String O0000OoO;
        @SerializedName("funded")
        @Expose
        public String O0000Ooo;
        @SerializedName("days_value")
        @Expose
        public String O0000o;
        @SerializedName("supporters_btn_text")
        @Expose
        public String O0000o0;
        @SerializedName("funded_ratio")
        @Expose
        public String O0000o00;
        @SerializedName("supporters_number")
        @Expose
        public String O0000o0O;
        @SerializedName("days")
        @Expose
        public String O0000o0o;
        @SerializedName("discount")
        @Expose
        public String O0000oO;
        @SerializedName("extended")
        @Expose
        public String O0000oO0;
        @SerializedName("background_color")
        @Expose
        public String O0000oOO;
        @SerializedName("background_img")
        @Expose
        public String O0000oOo;
        @SerializedName("discovery_number")
        @Expose
        public String O0000oo;
        @SerializedName("title_color")
        @Expose
        public String O0000oo0;
        @SerializedName("button_title")
        @Expose
        public String O0000ooO;
        @SerializedName("button_color")
        @Expose
        public String O0000ooo;
        @SerializedName("icon_head")
        @Expose
        public String O000O00o;
        @SerializedName("type")
        @Expose
        public String O000O0OO;
        @SerializedName("page_id")
        @Expose
        public String O000O0Oo;
        @SerializedName("isLight")
        @Expose
        public int O000O0o0 = -1;
        @SerializedName("hide_currency_label")
        @Expose
        public boolean O00oOoOo;
        @SerializedName("description_color")
        @Expose
        public String O00oOooO;
        @SerializedName("icon_text")
        @Expose
        public String O00oOooo;
    }

    public static ewr O000000o(ProtoReader protoReader) throws IOException {
        ewr ewr = new ewr();
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag != -1) {
                switch (nextTag) {
                    case 1:
                        ewr.f15901O000000o = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 2:
                        ewr.O00000Oo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 3:
                        ewr.O00000o0 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 4:
                        ewr.O00000o = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 5:
                        ewr.O00000oO = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 6:
                        ewr.O00000oo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 7:
                        ewr.O0000O0o = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        ewr.O0000OOo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 9:
                        ewr.O0000Oo0 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 10:
                        ewr.O0000Oo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 11:
                        ewr.O0000OoO = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                        ewr.O0000Ooo = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 13:
                        ewr.O0000o00 = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 14:
                        List<O000000o> list = ewr.O0000oo0;
                        O000000o o000000o = new O000000o();
                        long beginMessage2 = protoReader.beginMessage();
                        while (true) {
                            int nextTag2 = protoReader.nextTag();
                            if (nextTag2 == -1) {
                                protoReader.endMessage(beginMessage2);
                                list.add(o000000o);
                                break;
                            } else {
                                switch (nextTag2) {
                                    case 1:
                                        o000000o.f15902O000000o = ProtoAdapter.STRING.decode(protoReader);
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
                                    case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                                        o000000o.O0000Ooo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 13:
                                        o000000o.O0000o00 = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 14:
                                        o000000o.O0000o0 = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case GmsLogger.MAX_PII_TAG_LENGTH:
                                        o000000o.O0000o0O = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 16:
                                        o000000o.O0000o0o = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 17:
                                        o000000o.O0000o = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 18:
                                        o000000o.O0000oO0 = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 19:
                                        o000000o.O0000oO = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 20:
                                        o000000o.O0000oOO = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 21:
                                        o000000o.O0000oOo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 22:
                                        o000000o.O0000oo0 = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 23:
                                        o000000o.O0000oo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 24:
                                        o000000o.O0000ooO = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 25:
                                        o000000o.O0000ooo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 26:
                                        o000000o.O00oOooO = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 27:
                                        o000000o.O00oOooo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 28:
                                        o000000o.O000O00o = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 29:
                                        o000000o.O000O0OO = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 30:
                                        o000000o.O000O0Oo = ProtoAdapter.STRING.decode(protoReader);
                                        break;
                                    case 31:
                                        o000000o.O00oOoOo = ProtoAdapter.BOOL.decode(protoReader).booleanValue();
                                        break;
                                    default:
                                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                                        break;
                                }
                            }
                        }
                    case GmsLogger.MAX_PII_TAG_LENGTH:
                        ewr.O0000o0 = ProtoAdapter.INT64.decode(protoReader).longValue();
                        break;
                    case 16:
                        ewr.O0000o0O = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 17:
                        ewr.O0000o0o = ProtoAdapter.STRING.decode(protoReader);
                        break;
                    case 18:
                        ewr.O0000o = ProtoAdapter.INT32.decode(protoReader).intValue();
                        break;
                    case 19:
                        ewr.O0000ooo = ProtoAdapter.INT64.decode(protoReader).longValue();
                        break;
                    case 20:
                        ewr.O00oOooo = ProtoAdapter.INT64.decode(protoReader).longValue();
                        break;
                    default:
                        protoReader.peekFieldEncoding().rawProtoAdapter().decode(protoReader);
                        break;
                }
            } else {
                protoReader.endMessage(beginMessage);
                return ewr;
            }
        }
    }
}
