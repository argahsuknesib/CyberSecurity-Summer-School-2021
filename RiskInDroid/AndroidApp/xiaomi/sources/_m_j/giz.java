package _m_j;

import com.google.android.exoplayer2.C;
import com.google.android.gms.common.internal.GmsLogger;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.infrared.bean.IRType;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public final class giz {

    /* renamed from: O000000o  reason: collision with root package name */
    public final IRType f17822O000000o;
    public final String O00000Oo;
    public final String O00000o;
    public final String O00000o0;
    public int O00000oO;
    public String O00000oo;
    private final String O0000O0o;

    public giz(String str, String str2, String str3, String str4, IRType iRType, String str5) {
        this.f17822O000000o = iRType;
        this.O00000o0 = str4;
        this.O00000Oo = str3;
        this.O00000o = str5;
        this.O0000O0o = str2 == null ? "" : str2;
        this.O00000oo = str;
        String str6 = this.O0000O0o;
        char c = 65535;
        switch (str6.hashCode()) {
            case -902669859:
                if (str6.equals("开机/自动/制冷")) {
                    c = 25;
                    break;
                }
                break;
            case 19979:
                if (str6.equals("下")) {
                    c = 3;
                    break;
                }
                break;
            case 21491:
                if (str6.equals("右")) {
                    c = 9;
                    break;
                }
                break;
            case 24038:
                if (str6.equals("左")) {
                    c = 8;
                    break;
                }
                break;
            case 659866:
                if (str6.equals("主页")) {
                    c = 7;
                    break;
                }
                break;
            case 665222:
                if (str6.equals("停止")) {
                    c = 20;
                    break;
                }
                break;
            case 670745:
                if (str6.equals("出仓")) {
                    c = 4;
                    break;
                }
                break;
            case 778119:
                if (str6.equals("引导")) {
                    c = 6;
                    break;
                }
                break;
            case 798069:
                if (str6.equals("快退")) {
                    c = 17;
                    break;
                }
                break;
            case 813114:
                if (str6.equals("拍照")) {
                    c = 19;
                    break;
                }
                break;
            case 824881:
                if (str6.equals("播放")) {
                    c = 15;
                    break;
                }
                break;
            case 834074:
                if (str6.equals("暂停")) {
                    c = 14;
                    break;
                }
                break;
            case 834888:
                if (str6.equals("摆风")) {
                    c = 18;
                    break;
                }
                break;
            case 958459:
                if (str6.equals("电源")) {
                    c = 26;
                    break;
                }
                break;
            case 991478:
                if (str6.equals("确认")) {
                    c = 13;
                    break;
                }
                break;
            case 1067769:
                if (str6.equals("菜单")) {
                    c = 10;
                    break;
                }
                break;
            case 1163658:
                if (str6.equals("返回")) {
                    c = 0;
                    break;
                }
                break;
            case 1163770:
                if (str6.equals("退出")) {
                    c = 5;
                    break;
                }
                break;
            case 1239994:
                if (str6.equals("静音")) {
                    c = 11;
                    break;
                }
                break;
            case 1249553:
                if (str6.equals("风速")) {
                    c = 24;
                    break;
                }
                break;
            case 19844220:
                if (str6.equals("上一曲")) {
                    c = 16;
                    break;
                }
                break;
            case 19845181:
                if (str6.equals("下一曲")) {
                    c = 12;
                    break;
                }
                break;
            case 20346138:
                if (str6.equals("信号源")) {
                    c = 21;
                    break;
                }
                break;
            case 38539119:
                if (str6.equals("音量+")) {
                    c = 23;
                    break;
                }
                break;
            case 38539121:
                if (str6.equals("音量-")) {
                    c = 22;
                    break;
                }
                break;
            case 38679177:
                if (str6.equals("频道+")) {
                    c = 2;
                    break;
                }
                break;
            case 38679179:
                if (str6.equals("频道-")) {
                    c = 1;
                    break;
                }
                break;
            case 921101345:
                if (str6.equals("电源-关")) {
                    c = 27;
                    break;
                }
                break;
            case 921104814:
                if (str6.equals("电源-开")) {
                    c = 28;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.O00000oO = R.drawable.btn_match_back;
                return;
            case 1:
                this.O00000oO = R.drawable.btn_match_ch_dec;
                return;
            case 2:
                this.O00000oO = R.drawable.btn_match_ch_inc;
                return;
            case 3:
                this.O00000oO = R.drawable.btn_match_down;
                return;
            case 4:
                this.O00000oO = R.drawable.btn_match_eject;
                return;
            case 5:
                this.O00000oO = R.drawable.btn_match_next;
                return;
            case 6:
                this.O00000oO = R.drawable.btn_match_guide;
                return;
            case 7:
                this.O00000oO = R.drawable.btn_match_home;
                return;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                this.O00000oO = R.drawable.btn_match_left;
                return;
            case 9:
                this.O00000oO = R.drawable.btn_match_right;
                return;
            case 10:
                this.O00000oO = R.drawable.btn_match_menu;
                return;
            case 11:
                this.O00000oO = R.drawable.btn_match_mute;
                return;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT:
                this.O00000oO = R.drawable.btn_match_next;
                return;
            case 13:
                this.O00000oO = R.drawable.btn_match_ok;
                return;
            case 14:
                this.O00000oO = R.drawable.btn_match_pause;
                return;
            case GmsLogger.MAX_PII_TAG_LENGTH:
                this.O00000oO = R.drawable.btn_match_play;
                return;
            case 16:
                this.O00000oO = R.drawable.btn_match_previous;
                return;
            case 17:
                this.O00000oO = R.drawable.btn_match_rew;
                return;
            case 18:
                this.O00000oO = R.drawable.btn_match_shake_wind;
                return;
            case 19:
                this.O00000oO = R.drawable.btn_match_shutter;
                return;
            case 20:
                this.O00000oO = R.drawable.btn_match_stop;
                return;
            case 21:
                this.O00000oO = R.drawable.btn_match_tvav;
                return;
            case 22:
                this.O00000oO = R.drawable.btn_match_vol_dec;
                return;
            case 23:
                this.O00000oO = R.drawable.btn_match_vol_inc;
                return;
            case 24:
                this.O00000oO = R.drawable.btn_match_wind_speed;
                return;
            case 25:
            case 26:
                this.O00000oO = R.drawable.btn_match_power;
                return;
            case 27:
            case 28:
                this.O00000oO = R.drawable.btn_match_power;
                return;
            default:
                this.O00000oO = R.drawable.btn_match_default;
                return;
        }
    }
}
