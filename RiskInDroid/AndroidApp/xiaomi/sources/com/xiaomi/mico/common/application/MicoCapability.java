package com.xiaomi.mico.common.application;

public enum MicoCapability {
    PLAYER_PAUSE_TIMER("player_pause_timer"),
    MITV_CONTROL_WAKEUP("mitv_control_wakeup"),
    ALARM_REPEAT_OPTION_V2("alarm_repeat_option_v2"),
    BLUETOOTH_OPTION_V2("bluetooth_option_v2"),
    NIGHT_MODE("night_mode"),
    NEARBY_WAKEUP("nearby_wakeup"),
    NEARBY_WAKEUP_CLOUD("nearby_wakeup_cloud"),
    LOCAL_PLAY("local_play"),
    DIDI_AUTH("didi_auth"),
    NIGHT_MODE_DETAIL("night_mode_detail"),
    SCREEN_MODE("screen_mode"),
    STEREO_MODE("stereo_mode"),
    STEREO_MODE_V2("stereo_mode_v2"),
    MULTIROOM_MUSIC("multiroom_music"),
    DTS_SOUND_EFFECT("dts_sound_effect"),
    SKILL_TRY("skill_try"),
    EARTHQUAKE("earthquake"),
    FAMILY_ALBUM("family_album"),
    VOICE_PRINT("voice_print"),
    CLASSIFIED_ALARM("classified_alarm"),
    TONE_SETTING("tone_setting"),
    AI_PROTOCOL_3_0("ai_protocol_3_0"),
    CHILD_MODE("child_mode"),
    VOIP_SIGNAL("voip_signal"),
    XIAOMI_VOIP("xiaomi_voip"),
    MESH("mesh"),
    BLE_GATEWAY("ble_gateway"),
    CHINA_MOBILE_IMS("china_mobile_ims"),
    CHILD_MODE_2("child_mode_2"),
    MESH_CONFLICT_CHECK("mesh_conflict_check"),
    VOIP_USED_TIME("voip_used_time"),
    BABY_SCHEDULE("baby_schedule"),
    CONTINUOUS_DIALOGUE("continuous_dialogue"),
    FORCE_OTA("force_ota"),
    CUSTOM_IR("custom_ir"),
    SYSTEM_TIME_CERTIFY("system_time_certify"),
    FAMILY_BANK("family_bank"),
    DIALOGUE_3_1("dialogue_3.1"),
    SCHOOL_TIMETABLE("school_timetable");
    
    private final String mKey;

    private MicoCapability(String str) {
        this.mKey = str;
    }

    public final String toString() {
        return this.mKey;
    }
}
