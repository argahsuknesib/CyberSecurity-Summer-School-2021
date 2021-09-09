package com.tiqiaa.icontrol.util;

import android.content.Context;
import android.util.Log;
import com.google.android.exoplayer2.C;
import com.tiqiaa.remote.entity.Infrared;
import com.tiqiaa.remote.entity.Key;
import com.tiqiaa.remote.entity.Remote;
import com.xiaomi.mico.R2;
import java.lang.reflect.Field;
import java.util.Locale;

public class RemoteUtils {
    public static String getKeyName(int i) {
        if (i == 1000) {
            return "冷风";
        }
        if (i == 1800) {
            return "第二电源键";
        }
        switch (i) {
            case -100:
                return "自定义键-圆形";
            case -99:
                return "自定义键-椭圆";
            case -98:
                return "自定义键-方形";
            case -97:
                return "自定义键-红色";
            case -96:
                return "自定义键-橙色";
            case -95:
                return "自定义键-黄色";
            case -94:
                return "自定义键-绿色";
            case -93:
                return "自定义键-蓝色";
            case -92:
                return "自定义键-青色";
            case -91:
                return "自定义键-紫色";
            case -90:
                return "记忆键";
            default:
                switch (i) {
                    case 0:
                        return "数字键 0";
                    case 1:
                        return "数字键 1";
                    case 2:
                        return "数字键 2";
                    case 3:
                        return "数字键 3";
                    case 4:
                        return "数字键 4";
                    case 5:
                        return "数字键 5";
                    case 6:
                        return "数字键 6";
                    case 7:
                        return "数字键 7";
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return "数字键 8";
                    case 9:
                        return "数字键 9";
                    default:
                        switch (i) {
                            case 800:
                                return "电源";
                            case 801:
                                return "信源键";
                            case 802:
                                return "信息显示";
                            case 803:
                                return "回看";
                            case 804:
                                return "静音";
                            case 805:
                                return "数位";
                            case 806:
                                return "返回";
                            case 807:
                                return "频道+";
                            case 808:
                                return "频道-";
                            case 809:
                                return "音量+";
                            case 810:
                                return "音量-";
                            case 811:
                                return "温度加";
                            case 812:
                                return "温度减";
                            case 813:
                                return "放大";
                            case 814:
                                return "缩小";
                            case 815:
                                return "记忆键1";
                            case 816:
                                return "记忆键2";
                            case 817:
                                return "OK键";
                            case 818:
                                return "上翻";
                            case 819:
                                return "下翻";
                            case 820:
                                return "左翻";
                            case 821:
                                return "右翻";
                            case 822:
                                return "菜单键";
                            case 823:
                                return "退出";
                            case 824:
                                return "前进";
                            case 825:
                                return "后退键";
                            case 826:
                                return "暂停/播放";
                            case 827:
                                return "停止";
                            case 828:
                                return "上一个";
                            case 829:
                                return "下一个";
                            case 830:
                                return "到顶";
                            case 831:
                                return "到底";
                            case 832:
                                return "模式";
                            case 833:
                                return "风量";
                            case 834:
                                return "水平风向";
                            case 835:
                                return "垂直风向";
                            case 836:
                                return "摇头";
                            case 837:
                                return "风类";
                            case 838:
                                return "风速";
                            case 839:
                                return "打开";
                            case R2.attr.level /*840*/:
                                return "标题";
                            case 841:
                                return "+10";
                            case 842:
                                return "语言";
                            case 843:
                                return "屏幕";
                            case 844:
                                return "声道";
                            case 845:
                                return "制式";
                            case 846:
                                return "字幕";
                            case 847:
                                return "双画面";
                            case 848:
                                return "画面冻结";
                            case 849:
                                return "重置";
                            case 850:
                                return "视频";
                            case 851:
                                return "慢放";
                            case 852:
                                return "单反主键";
                            case 853:
                                return "单反副键";
                            case 854:
                                return "连续+";
                            case 855:
                                return "连续-";
                            case 856:
                                return "连续右";
                            case 857:
                                return "连续左";
                            default:
                                switch (i) {
                                    case 870:
                                        return "风向";
                                    case 871:
                                        return "灯光";
                                    case 872:
                                        return "超强";
                                    case 873:
                                        return "睡眠";
                                    case 874:
                                        return "换气";
                                    case 875:
                                        return "干燥";
                                    case 876:
                                        return "定时";
                                    case 877:
                                        return "加湿";
                                    case 878:
                                        return "负离子";
                                    case 879:
                                        return "节能";
                                    case 880:
                                        return "舒适";
                                    case 881:
                                        return "温度显示";
                                    case 882:
                                        return "一键冷";
                                    case 883:
                                        return "一键热";
                                    default:
                                        switch (i) {
                                            case 900:
                                                return "自动";
                                            case 901:
                                                return "信号";
                                            case 902:
                                                return "灯光";
                                            case 903:
                                                return "电脑";
                                            default:
                                                switch (i) {
                                                    case 1010:
                                                        return "首页";
                                                    case 1011:
                                                        return "设置";
                                                    case 1012:
                                                        return "弹出菜单";
                                                    case 1013:
                                                        return "顶菜单";
                                                    default:
                                                        switch (i) {
                                                            case 2001:
                                                                return "收藏按钮";
                                                            case 2002:
                                                                return "数字按钮";
                                                            case 2003:
                                                                return "扩展";
                                                            default:
                                                                return "其他";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static String getRemoteName(Remote remote) {
        String str;
        if (remote == null) {
            return "N/A";
        }
        Locale locale = Locale.getDefault();
        Log.w("RemoteUtils", "getRemoteName............local = ".concat(String.valueOf(locale)));
        if (remote.getBrand() == null) {
            str = "" + "Unknown Brand";
        } else if (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE) || locale.equals(Locale.SIMPLIFIED_CHINESE)) {
            if (remote.getBrand().getBrand_cn() != null && !remote.getBrand().getBrand_cn().equals("")) {
                str = "" + remote.getBrand().getBrand_cn();
            } else if (remote.getBrand().getBrand_tw() != null && !remote.getBrand().getBrand_tw().equals("")) {
                str = "" + remote.getBrand().getBrand_tw();
            } else if (remote.getBrand().getBrand_en() != null && !remote.getBrand().getBrand_en().equals("")) {
                str = "" + remote.getBrand().getBrand_en();
            } else if (remote.getBrand().getBrand_other() == null || remote.getBrand().getBrand_other().equals("")) {
                str = "" + "Unknown Brand";
            } else {
                str = "" + remote.getBrand().getBrand_other();
            }
        } else if (remote.getBrand().getBrand_en() != null && !remote.getBrand().getBrand_en().equals("")) {
            str = "" + remote.getBrand().getBrand_en();
        } else if (remote.getBrand().getBrand_cn() != null && !remote.getBrand().getBrand_cn().equals("")) {
            str = "" + remote.getBrand().getBrand_cn();
        } else if (remote.getBrand().getBrand_tw() != null && !remote.getBrand().getBrand_tw().equals("")) {
            str = "" + remote.getBrand().getBrand_tw();
        } else if (remote.getBrand().getBrand_other() == null || remote.getBrand().getBrand_other().equals("")) {
            str = "" + "Unknown Brand";
        } else {
            str = "" + remote.getBrand().getBrand_other();
        }
        switch (remote.getType()) {
            case 1:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " TV";
                    break;
                } else {
                    str = String.valueOf(str) + " 电视";
                    break;
                }
                break;
            case 2:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " AC";
                    break;
                } else {
                    str = String.valueOf(str) + " 空调";
                    break;
                }
                break;
            case 3:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " fan";
                    break;
                } else {
                    str = String.valueOf(str) + " 风扇";
                    break;
                }
                break;
            case 4:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " Projector";
                    break;
                } else {
                    str = String.valueOf(str) + " 投影仪";
                    break;
                }
                break;
            case 5:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " STB";
                    break;
                } else {
                    str = String.valueOf(str) + " 机顶盒";
                    break;
                }
                break;
            case 6:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " DVD";
                    break;
                } else {
                    str = String.valueOf(str) + " DVD";
                    break;
                }
                break;
            case 7:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " Camera";
                    break;
                } else {
                    str = String.valueOf(str) + " 相机";
                    break;
                }
                break;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " Light";
                    break;
                } else {
                    str = String.valueOf(str) + " 遥控灯";
                    break;
                }
                break;
            case 9:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " Amplifier";
                    break;
                } else {
                    str = String.valueOf(str) + " 功放";
                    break;
                }
                break;
            case 10:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " IPTV";
                    break;
                } else {
                    str = String.valueOf(str) + " IPTV";
                    break;
                }
                break;
            case 11:
                if (!locale.equals(Locale.CHINA) && !locale.equals(Locale.CHINESE) && !locale.equals(Locale.SIMPLIFIED_CHINESE)) {
                    str = String.valueOf(str) + " Box";
                    break;
                } else {
                    str = String.valueOf(str) + " 盒子";
                    break;
                }
                break;
        }
        if (remote.getModel() == null) {
            return str;
        }
        return String.valueOf(str) + " " + remote.getModel();
    }

    public static boolean isMultiAirRemote(Remote remote) {
        if (remote == null || remote.getKeys() == null || remote.getKeys().size() == 0 || remote.getType() != 2) {
            return false;
        }
        for (Key next : remote.getKeys()) {
            if (next != null && next.getProtocol() > 0) {
                return true;
            }
        }
        return isDiyMultiAirRemote(remote);
    }

    public static boolean isProtocolAirRemote(Remote remote) {
        if (remote == null || remote.getKeys() == null || remote.getKeys().size() == 0) {
            return false;
        }
        for (Key next : remote.getKeys()) {
            if (next != null && next.getProtocol() > 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDiyMultiAirRemote(Remote remote) {
        if (remote == null || remote.getKeys() == null || remote.getKeys().size() == 0) {
            return false;
        }
        for (Key next : remote.getKeys()) {
            if (!(next == null || next.getInfrareds() == null || next.getInfrareds().size() <= 0)) {
                for (Infrared next2 : next.getInfrareds()) {
                    if (next2 != null && next2.getFunc() > 0) {
                        return true;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static int getItemId(Context context, String str, String str2) {
        try {
            Field field = Class.forName(String.valueOf(context.getPackageName()) + ".R$" + str).getField(str2);
            return Integer.parseInt(field.get(field.getName()).toString());
        } catch (Exception e) {
            Log.e("getIdByReflection error", e.getMessage());
            return 0;
        }
    }

    public static int getStringResIDByName(Context context, String str) {
        return context.getResources().getIdentifier(str, "string", context.getPackageName());
    }

    public static String getLocalKeyName(int i) {
        Context context = TiqiaaService.mContext;
        if (i == 1000) {
            return context.getString(getStringResIDByName(context, "KeyType_cool_wind"));
        }
        if (i == 1800) {
            return context.getString(getStringResIDByName(context, "KeyType_power_second"));
        }
        switch (i) {
            case -100:
                return context.getString(getStringResIDByName(context, "KeyType_base_round"));
            case -99:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval"));
            case -98:
                return context.getString(getStringResIDByName(context, "KeyType_base_square"));
            case -97:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_red"));
            case -96:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_orange"));
            case -95:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_yellow"));
            case -94:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_green"));
            case -93:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_blue"));
            case -92:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_cyan"));
            case -91:
                return context.getString(getStringResIDByName(context, "KeyType_base_oval_purple"));
            case -90:
                return context.getString(getStringResIDByName(context, "KeyType_memorykey"));
            default:
                switch (i) {
                    case 0:
                        return context.getString(getStringResIDByName(context, "KeyType_zero"));
                    case 1:
                        return context.getString(getStringResIDByName(context, "KeyType_one"));
                    case 2:
                        return context.getString(getStringResIDByName(context, "KeyType_two"));
                    case 3:
                        return context.getString(getStringResIDByName(context, "KeyType_three"));
                    case 4:
                        return context.getString(getStringResIDByName(context, "KeyType_four"));
                    case 5:
                        return context.getString(getStringResIDByName(context, "KeyType_five"));
                    case 6:
                        return context.getString(getStringResIDByName(context, "KeyType_six"));
                    case 7:
                        return context.getString(getStringResIDByName(context, "KeyType_seven"));
                    case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                        return context.getString(getStringResIDByName(context, "KeyType_eight"));
                    case 9:
                        return context.getString(getStringResIDByName(context, "KeyType_nine"));
                    default:
                        switch (i) {
                            case 800:
                                return context.getString(getStringResIDByName(context, "KeyType_power"));
                            case 801:
                                return context.getString(getStringResIDByName(context, "KeyType_signal"));
                            case 802:
                                return context.getString(getStringResIDByName(context, "KeyType_information"));
                            case 803:
                                return context.getString(getStringResIDByName(context, "KeyType_look_back"));
                            case 804:
                                return context.getString(getStringResIDByName(context, "KeyType_mute"));
                            case 805:
                                return context.getString(getStringResIDByName(context, "KeyType_digital"));
                            case 806:
                                return context.getString(getStringResIDByName(context, "KeyType_back"));
                            case 807:
                                return context.getString(getStringResIDByName(context, "KeyType_channel_up"));
                            case 808:
                                return context.getString(getStringResIDByName(context, "KeyType_channel_down"));
                            case 809:
                                return context.getString(getStringResIDByName(context, "KeyType_vol_up"));
                            case 810:
                                return context.getString(getStringResIDByName(context, "KeyType_vol_down"));
                            case 811:
                                return context.getString(getStringResIDByName(context, "KeyType_temp_up"));
                            case 812:
                                return context.getString(getStringResIDByName(context, "KeyType_temp_down"));
                            case 813:
                                return context.getString(getStringResIDByName(context, "KeyType_d_zoom_up"));
                            case 814:
                                return context.getString(getStringResIDByName(context, "KeyType_d_zoom_down"));
                            case 815:
                                return context.getString(getStringResIDByName(context, "KeyType_memorykey_one"));
                            case 816:
                                return context.getString(getStringResIDByName(context, "KeyType_memorykey_two"));
                            case 817:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_ok"));
                            case 818:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_up"));
                            case 819:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_down"));
                            case 820:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_left"));
                            case 821:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_right"));
                            case 822:
                                return context.getString(getStringResIDByName(context, "KeyType_menu"));
                            case 823:
                                return context.getString(getStringResIDByName(context, "KeyType_menu_exit"));
                            case 824:
                                return context.getString(getStringResIDByName(context, "KeyType_forward"));
                            case 825:
                                return context.getString(getStringResIDByName(context, "KeyType_rewind"));
                            case 826:
                                return context.getString(getStringResIDByName(context, "KeyType_pause"));
                            case 827:
                                return context.getString(getStringResIDByName(context, "KeyType_stop"));
                            case 828:
                                return context.getString(getStringResIDByName(context, "KeyType_previous"));
                            case 829:
                                return context.getString(getStringResIDByName(context, "KeyType_next"));
                            case 830:
                                return context.getString(getStringResIDByName(context, "KeyType_top"));
                            case 831:
                                return context.getString(getStringResIDByName(context, "KeyType_bottom"));
                            case 832:
                                return context.getString(getStringResIDByName(context, "KeyType_mode"));
                            case 833:
                                return context.getString(getStringResIDByName(context, "KeyType_wind_amount"));
                            case 834:
                                return context.getString(getStringResIDByName(context, "KeyType_wind_horizontal"));
                            case 835:
                                return context.getString(getStringResIDByName(context, "KeyType_wind_vertical"));
                            case 836:
                                return context.getString(getStringResIDByName(context, "KeyType_head_swing"));
                            case 837:
                                return context.getString(getStringResIDByName(context, "KeyType_wind_class"));
                            case 838:
                                return context.getString(getStringResIDByName(context, "KeyType_wind_velocity"));
                            case 839:
                                return context.getString(getStringResIDByName(context, "KeyType_open"));
                            case R2.attr.level /*840*/:
                                return context.getString(getStringResIDByName(context, "KeyType_title"));
                            case 841:
                                return context.getString(getStringResIDByName(context, "KeyType_ten_plus"));
                            case 842:
                                return context.getString(getStringResIDByName(context, "KeyType_language"));
                            case 843:
                                return context.getString(getStringResIDByName(context, "KeyType_screen"));
                            case 844:
                                return context.getString(getStringResIDByName(context, "KeyType_sound_channel"));
                            case 845:
                                return context.getString(getStringResIDByName(context, "KeyType_standard"));
                            case 846:
                                return context.getString(getStringResIDByName(context, "KeyType_subtitles"));
                            case 847:
                                return context.getString(getStringResIDByName(context, "KeyType_dual_screen"));
                            case 848:
                                return context.getString(getStringResIDByName(context, "KeyType_freeze"));
                            case 849:
                                return context.getString(getStringResIDByName(context, "KeyType_reset"));
                            case 850:
                                return context.getString(getStringResIDByName(context, "KeyType_video"));
                            case 851:
                                return context.getString(getStringResIDByName(context, "KeyType_step_slow"));
                            case 852:
                                return context.getString(getStringResIDByName(context, "KeyType_shutter_one"));
                            case 853:
                                return context.getString(getStringResIDByName(context, "KeyType_shutter_two"));
                            case 854:
                                return context.getString(getStringResIDByName(context, "KeyType_continue_up"));
                            case 855:
                                return context.getString(getStringResIDByName(context, "KeyType_continue_down"));
                            case 856:
                                return context.getString(getStringResIDByName(context, "KeyType_continue_right"));
                            case 857:
                                return context.getString(getStringResIDByName(context, "KeyType_continue_left"));
                            default:
                                switch (i) {
                                    case 870:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_wind_direct"));
                                    case 871:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_light"));
                                    case 872:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_super"));
                                    case 873:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_sleep"));
                                    case 874:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_flash_air"));
                                    case 875:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_aid_hot"));
                                    case 876:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_time"));
                                    case 877:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_wet"));
                                    case 878:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_anion"));
                                    case 879:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_power_saving"));
                                    case 880:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_comfort"));
                                    case 881:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_temp_display"));
                                    case 882:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_quick_cool"));
                                    case 883:
                                        return context.getString(getStringResIDByName(context, "KeyType_air_quick_hot"));
                                    default:
                                        switch (i) {
                                            case 900:
                                                return context.getString(getStringResIDByName(context, "KeyType_auto"));
                                            case 901:
                                                return context.getString(getStringResIDByName(context, "KeyType_pjt_signal"));
                                            case 902:
                                                return context.getString(getStringResIDByName(context, "KeyType_brightness"));
                                            case 903:
                                                return context.getString(getStringResIDByName(context, "KeyType_pc"));
                                            default:
                                                switch (i) {
                                                    case 1010:
                                                        return context.getString(getStringResIDByName(context, "KeyType_home"));
                                                    case 1011:
                                                        return context.getString(getStringResIDByName(context, "KeyType_setting"));
                                                    case 1012:
                                                        return context.getString(getStringResIDByName(context, "KeyType_popmenu"));
                                                    default:
                                                        switch (i) {
                                                            case 1020:
                                                                return context.getString(getStringResIDByName(context, "KeyType_keep_middle_warn"));
                                                            case 1021:
                                                                return context.getString(getStringResIDByName(context, "KeyType_order_bath"));
                                                            case 1022:
                                                                return context.getString(getStringResIDByName(context, "KeyType_confirm"));
                                                            default:
                                                                switch (i) {
                                                                    case 2001:
                                                                        return context.getString(getStringResIDByName(context, "KeyType_Favorites"));
                                                                    case 2002:
                                                                        return context.getString(getStringResIDByName(context, "KeyType_Numbers"));
                                                                    case 2003:
                                                                        return context.getString(getStringResIDByName(context, "KeyType_Custom"));
                                                                    default:
                                                                        return context.getString(getStringResIDByName(context, "KeyType_other"));
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
