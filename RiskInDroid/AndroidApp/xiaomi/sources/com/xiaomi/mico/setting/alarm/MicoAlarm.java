package com.xiaomi.mico.setting.alarm;

import com.xiaomi.smarthome.R;

public enum MicoAlarm {
    SYSTEM("系统铃声", R.string.alarm_tone_music, R.drawable.alarm_icon_music, R.drawable.alarm_music_banner, R.drawable.alarm_edit_bg_music),
    MUSIC("音乐", R.string.alarm_tone_music, R.drawable.alarm_icon_music, R.drawable.alarm_music_banner, R.drawable.alarm_edit_bg_music),
    VIDEO("视频", R.string.alarm_tone_video, R.drawable.alarm_icon_video, R.drawable.alarm_video_banner, R.drawable.alarm_edit_bg_video),
    NATURE("自然", R.string.alarm_tone_nature, R.drawable.alarm_icon_nature, R.drawable.alarm_nature_banner, R.drawable.alarm_edit_bg_nature),
    FUN("趣味", R.string.alarm_tone_fun, R.drawable.alarm_icon_fun, R.drawable.alarm_fun_banner, R.drawable.alarm_edit_bg_fun);
    
    public int bannerDrawId;
    public int editDrawId;
    public int iconDrawId;
    public int nameId;
    public String type;

    private MicoAlarm(String str, int i, int i2, int i3, int i4) {
        this.type = str;
        this.nameId = i;
        this.iconDrawId = i2;
        this.bannerDrawId = i3;
        this.editDrawId = i4;
    }

    public static MicoAlarm valueOfType(String str) {
        for (MicoAlarm micoAlarm : values()) {
            if (micoAlarm.type.equals(str)) {
                return micoAlarm;
            }
        }
        return SYSTEM;
    }
}
