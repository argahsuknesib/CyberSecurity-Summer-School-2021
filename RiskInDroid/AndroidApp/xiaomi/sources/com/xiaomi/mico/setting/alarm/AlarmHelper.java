package com.xiaomi.mico.setting.alarm;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.jgc;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.text.format.DateUtils;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.BiMap;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.mico.common.util.TimeUtil;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlarmHelper {
    public static HashMap<String, String> ALARM_NAME_ID_MAP = new HashMap<>();
    private static final Map<String, String> LOCAL_ALARM_NAME_ID_MAP = new HashMap<String, String>() {
        /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass2 */

        {
            put("music.default", "音乐");
            put("nature.default", "自然");
            put("fun.default", "趣味");
            put("video.default", "视频");
            put("songlist.specific", "音乐");
            put("songlist.general", "音乐");
            put("songlist.album", "音乐");
            put("songlist.artist", "音乐");
            put("songlist.combination", "音乐");
            put("music.general", "音乐");
            put("music.song", "音乐");
            put("music.tag", "音乐");
            put("voice.nature", "自然");
            put("voice.white_noise", "自然");
            put("voice.animal", "趣味");
            put("voice.character_voice", "趣味");
            put("voice.simulator", "趣味");
            put("voice.type", "趣味");
            put("voice.action", "趣味");
            put("voice.language", "趣味");
            put("voice.voice_action", "趣味");
            put("voice.foreign_language", "趣味");
            put("voice.other", "趣味");
        }
    };
    public static List<Remote.Response.AlarmRing> RINGS;
    public static HashMap<String, List<Remote.Response.AlarmRing>> TYPE_RINGS = new HashMap<>();
    public static final BiMap<String, Integer> WEEKDAY = new BiMap().put("mon", 0).put("tue", 1).put("wed", 2).put("thu", 3).put("fri", 4).put("sat", 5).put("sun", 6);
    private static List<SkillStore.SkillTip> alarmTips;
    public static ahg loggerNew = new ahg();
    public static String sTypeRingsLanguage;

    public static List<SkillStore.SkillTip> getAlarmTips(final Context context) {
        if (alarmTips == null) {
            alarmTips = new ArrayList<SkillStore.SkillTip>() {
                /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass1 */
                private static final long serialVersionUID = -6601250247790203270L;

                {
                    add(new SkillStore.SkillTip(context.getString(R.string.alarm_tip_title_set_diff_ring), new ArrayList<String>() {
                        /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass1.AnonymousClass1 */
                        private static final long serialVersionUID = 2843663123870795555L;

                        {
                            add(context.getString(R.string.alarm_tip_jay_chou_song));
                            add(context.getString(R.string.alarm_tip_minions));
                        }
                    }));
                    add(new SkillStore.SkillTip(context.getString(R.string.alarm_tip_title_ring_only_once), new ArrayList<String>() {
                        /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass1.AnonymousClass2 */
                        private static final long serialVersionUID = -2274254699499899300L;

                        {
                            add(context.getString(R.string.alarm_tip_buy_mi_phone));
                            add(context.getString(R.string.alarm_tip_eight_in_the_morning));
                        }
                    }));
                    add(new SkillStore.SkillTip(context.getString(R.string.alarm_tip_title_ring_repetition), new ArrayList<String>() {
                        /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass1.AnonymousClass3 */
                        private static final long serialVersionUID = 7249986840883840995L;

                        {
                            add(context.getString(R.string.alarm_tip_weekdays));
                            add(context.getString(R.string.alarm_tip_everyday));
                        }
                    }));
                    add(new SkillStore.SkillTip(context.getString(R.string.alarm_tip_title_hint), new ArrayList<String>() {
                        /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass1.AnonymousClass4 */
                        private static final long serialVersionUID = -3173512807565588975L;

                        {
                            add(context.getString(R.string.alarm_tip_breakfast));
                            add(context.getString(R.string.alarm_tip_airport));
                        }
                    }));
                }
            };
        }
        return alarmTips;
    }

    static {
        new ahh();
    }

    public static void matchRings(List<Remote.Response.AlarmRing> list) {
        for (Remote.Response.AlarmRing next : list) {
            List list2 = TYPE_RINGS.get(next.tab);
            if (list2 == null) {
                list2 = new ArrayList();
                TYPE_RINGS.put(next.tab, list2);
            }
            list2.add(next);
        }
    }

    public static List<Remote.Response.AlarmRing> loadTabRings(String str) {
        return TYPE_RINGS.get(str);
    }

    public static String getCustomRepeatStr(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.toLowerCase().split(" ");
        String[] strArr = new String[split.length];
        String[] stringArray = context.getResources().getStringArray(R.array.weekdays_v2);
        for (int i = 0; i < split.length; i++) {
            strArr[i] = stringArray[WEEKDAY.value(split[i]).intValue()];
        }
        return TextUtils.join("/", strArr);
    }

    public static String formatAlarmDateTime(Context context, long j) {
        Date date = new Date(j);
        if (DateUtils.isToday(date.getTime())) {
            return context.getString(R.string.tool_clock_today);
        }
        if (TimeUtil.isTomorrow(date.getTime())) {
            return context.getString(R.string.tool_clock_tomorrow);
        }
        return new SimpleDateFormat(context.getString(R.string.tool_clock_oneday)).format(date);
    }

    public static void loadConfig() {
        loadConfig("zh");
    }

    public static void loadConfig(final String str) {
        if (TYPE_RINGS.isEmpty() || TextUtils.isEmpty(sTypeRingsLanguage) || !TextUtils.equals(sTypeRingsLanguage, str)) {
            String str2 = "alarm_query_map";
            if (!TextUtils.isEmpty(str)) {
                str2 = str2 + "_" + str;
            }
            ApiHelper.loadConfig(str2, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass3 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        AlarmHelper.sTypeRingsLanguage = str;
                        List<Remote.Response.AlarmRing> list = (List) GsonUtil.getGsonInstance().fromJson(str, new TypeToken<List<Remote.Response.AlarmRing>>() {
                            /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass3.AnonymousClass1 */
                        }.getType());
                        AlarmHelper.RINGS = list;
                        AlarmHelper.TYPE_RINGS.clear();
                        AlarmHelper.matchRings(list);
                        jgc.O000000o().O00000o(new MicoEvent.RingConfigUpdated());
                    }
                }
            });
        }
        if (ALARM_NAME_ID_MAP.isEmpty()) {
            ApiHelper.loadConfig("alarm_name_id_map", new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.setting.alarm.AlarmHelper.AnonymousClass4 */

                public final void onFailure(ApiError apiError) {
                }

                public final void onSuccess(String str) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            AlarmHelper.ALARM_NAME_ID_MAP = (HashMap) GsonUtil.fromJson(str, HashMap.class);
                        } catch (JsonSyntaxException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static Remote.Response.AlarmRing getSystemAlarmRing() {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        alarmRing.name = CommonApplication.getAppContext().getString(R.string.alarm_tone_system);
        alarmRing.query = "";
        alarmRing.tab = "系统铃声";
        alarmRing.id = "";
        return alarmRing;
    }

    public static Remote.Response.AlarmRing getMusicAlarmDefaultRing() {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        alarmRing.name = CommonApplication.getAppContext().getString(R.string.alarm_tone_morning);
        alarmRing.query = CommonApplication.getAppContext().getString(R.string.alarm_ring_query_default);
        alarmRing.tab = "音乐";
        alarmRing.id = "music.default";
        return alarmRing;
    }

    static Remote.Response.AlarmRing getNatureAlarmDefaultRing() {
        List list;
        HashMap<String, List<Remote.Response.AlarmRing>> hashMap = TYPE_RINGS;
        if (hashMap == null || (list = hashMap.get("自然")) == null || list.isEmpty()) {
            return null;
        }
        return (Remote.Response.AlarmRing) list.get(0);
    }

    static Remote.Response.AlarmRing getFunAlarmDefaultRing() {
        List list;
        HashMap<String, List<Remote.Response.AlarmRing>> hashMap = TYPE_RINGS;
        if (hashMap == null || (list = hashMap.get("趣味")) == null || list.isEmpty()) {
            return null;
        }
        return (Remote.Response.AlarmRing) list.get(0);
    }

    public static Remote.Response.AlarmRing getVideoAlarmDefaultRing() {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        alarmRing.tab = "视频";
        alarmRing.id = "video.default";
        alarmRing.video = "http://cdn.cnbj1.fds.api.mi-img.com/ai-open-file-service/video/lx04_default_alarm.mp4?GalaxyAccessKeyId=5151729087601&Expires=9223372036854775807&Signature=918FY9JpUCBwOm9/gmUdZWDicCc=";
        alarmRing.videoImage = "https://cdn.cnbj1.fds.api.mi-img.com/mico/8771bb3c-bd3c-4305-afb6-73840be909b3";
        alarmRing.name = CommonApplication.getAppContext().getString(R.string.alarm_video_ring_default);
        return alarmRing;
    }

    public static Remote.Response.AlarmRing getSongAlarmRing(Music.Song song) {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        String str = song.name;
        String str2 = song.artist.name;
        if (!TextUtils.isEmpty(str2)) {
            str = str + " - " + song.getArtistName();
        }
        if (!TextUtils.isEmpty(song.albumName)) {
            str = str + " | " + song.albumName;
        }
        String format = String.format("%s的歌曲%s", str2, song.name);
        alarmRing.name = str;
        alarmRing.query = format;
        alarmRing.tab = "音乐";
        alarmRing.id = "music.song";
        return alarmRing;
    }

    static String getAlarmRingType(Remote.Response.AlarmRing alarmRing) {
        if (!TextUtils.isEmpty(alarmRing.tab)) {
            return alarmRing.tab;
        }
        return !TextUtils.isEmpty(alarmRing.id) ? alarmRingType(alarmRing.id) : "系统铃声";
    }

    private static String alarmRingType(String str) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            str2 = ALARM_NAME_ID_MAP.get(str);
            if (TextUtils.isEmpty(str2)) {
                str2 = LOCAL_ALARM_NAME_ID_MAP.get(str);
            }
        } else {
            str2 = null;
        }
        return TextUtils.isEmpty(str2) ? "音乐" : str2;
    }

    public static Remote.Response.AlarmRing getAlarmRing(Remote.Response.Alarm alarm) {
        if (isRingToneTypeEmpty(alarm) && isRingToneQueryEmpty(alarm)) {
            return getSystemAlarmRing();
        }
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        String str = "";
        alarmRing.id = isRingToneTypeEmpty(alarm) ? str : alarm.ringToneType;
        if (!isRingToneQueryEmpty(alarm)) {
            str = alarm.ringToneQuery;
        }
        alarmRing.query = str;
        alarmRing.tab = alarmRingType(alarmRing.id);
        if (!TextUtils.isEmpty(alarm.displayTxt)) {
            alarmRing.name = Uri.decode(alarm.displayTxt);
        } else if (!TextUtils.isEmpty(alarmRing.query)) {
            alarmRing.name = loadQueryName(alarmRing.query, alarmRing.id);
        } else {
            alarmRing.name = CommonApplication.getAppContext().getString(R.string.alarm_tone_system);
        }
        alarmRing.video = alarm.ringToneVideo;
        alarmRing.videoImage = alarm.ringToneVideoImage;
        return alarmRing;
    }

    public static boolean isRingToneTypeEmpty(Remote.Response.Alarm alarm) {
        return alarm == null || TextUtils.isEmpty(alarm.ringToneType) || "0".equals(alarm.ringToneType) || "(null)".equalsIgnoreCase(alarm.ringToneType);
    }

    public static boolean isRingToneQueryEmpty(Remote.Response.Alarm alarm) {
        return alarm == null || TextUtils.isEmpty(alarm.ringToneQuery) || "(null)".equalsIgnoreCase(alarm.ringToneQuery);
    }

    static String loadQueryName(String str, String str2) {
        Remote.Response.AlarmRing loadQueryRing = loadQueryRing(str, str2);
        return loadQueryRing != null ? loadQueryRing.name : str;
    }

    static Remote.Response.AlarmRing loadQueryRing(String str, String str2) {
        if (RINGS != null && !TextUtils.isEmpty(str)) {
            for (int i = 0; i < RINGS.size(); i++) {
                Remote.Response.AlarmRing alarmRing = RINGS.get(i);
                if (str.equals(alarmRing.query) && str2.equals(alarmRing.id)) {
                    return alarmRing;
                }
            }
        }
        Remote.Response.AlarmRing musicAlarmDefaultRing = getMusicAlarmDefaultRing();
        if (musicAlarmDefaultRing.query.equals(str)) {
            return musicAlarmDefaultRing;
        }
        return null;
    }

    public static void saveLastUploadVideo(ThirdPartyResponse.AiFileUploadResult aiFileUploadResult) {
        String userId = AccountProfile.current().getUserId();
        if (aiFileUploadResult != null) {
            PreferenceUtils.setSettingString(CommonApplication.getAppContext(), "last_video".concat(String.valueOf(userId)), GsonUtil.getGsonInstance().toJson(aiFileUploadResult));
            return;
        }
        PreferenceUtils.setSettingString(CommonApplication.getAppContext(), "last_video".concat(String.valueOf(userId)), "");
    }

    public static ThirdPartyResponse.AiFileUploadResult loadLastUploadVideo() {
        String settingString = PreferenceUtils.getSettingString(CommonApplication.getAppContext(), "last_video".concat(String.valueOf(AccountProfile.current().getUserId())), "");
        if (!TextUtils.isEmpty(settingString)) {
            return (ThirdPartyResponse.AiFileUploadResult) GsonUtil.getGsonInstance().fromJson(settingString, ThirdPartyResponse.AiFileUploadResult.class);
        }
        return null;
    }

    public static Remote.Response.AlarmRing getVideoAlarmRing(ThirdPartyResponse.AiFileUploadResult aiFileUploadResult, Uri uri) {
        Remote.Response.AlarmRing alarmRing = new Remote.Response.AlarmRing();
        alarmRing.tab = "视频";
        alarmRing.name = CommonApplication.getAppContext().getString(R.string.alarm_video_ring_custom_title);
        alarmRing.id = "video.default";
        alarmRing.video = aiFileUploadResult.fileId;
        if (uri != null) {
            alarmRing.videoLocalPath = uri;
        }
        return alarmRing;
    }

    public static boolean isSystemAlarmRing(Remote.Response.AlarmRing alarmRing) {
        return getSystemAlarmRing().name.equals(alarmRing.name);
    }

    public static boolean isMusicAlarmDefaultRing(Remote.Response.AlarmRing alarmRing) {
        return getMusicAlarmDefaultRing().query.equals(alarmRing.query);
    }
}
