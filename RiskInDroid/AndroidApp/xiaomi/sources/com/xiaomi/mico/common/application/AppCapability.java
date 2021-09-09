package com.xiaomi.mico.common.application;

import _m_j.ahg;
import _m_j.ahh;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.AccountProfile;

public class AppCapability {
    private static final ahg LOGGER_NEW = new ahg();

    public static void dumpCapabilities() {
        ahg.O00000Oo("AppCapability of current mico %s", MicoManager.getInstance().getCurrentMico());
    }

    public static boolean hasCapabilitySwitchLocaiton() {
        if (MicoManager.getInstance().getCurrentMico().getHardwareType() == Hardware.T646) {
            return false;
        }
        return ApplicationConstants.isTaiWanEnabled();
    }

    public static boolean hasCapabilitySongCollection() {
        return ApiConstants.getAreaCode() != AreaCode.TW;
    }

    public static boolean hasCapabilitySetTraffic() {
        return ApiConstants.getAreaCode() == AreaCode.CN;
    }

    public static boolean hasCapabilityAlarmRecall() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        if ((currentMico == null || currentMico.getHardwareType() != Hardware.T646) && ApiConstants.getAreaCode() == AreaCode.CN) {
            return true;
        }
        return false;
    }

    public static boolean hasCapabilityChartLog() {
        return ApiConstants.getAreaCode() == AreaCode.CN;
    }

    public static boolean hasCapabilityMijiaAuth() {
        return ApiConstants.getAreaCode() == AreaCode.CN;
    }

    public static boolean hasCapabilityYoupin() {
        return ApiConstants.getAreaCode() == AreaCode.CN;
    }

    public static boolean hasCapabilitySettingBluetooth() {
        return !MicoManager.getInstance().getCurrentMico().getHardwareType().hasScreen();
    }

    public static boolean hasCapabilitySettingAlarm() {
        return MicoManager.getInstance().getCurrentMico().getHardwareType() != Hardware.T646;
    }

    public static boolean hasCapabilitySettingFeedback() {
        return MicoManager.getInstance().getCurrentMico().getHardwareType() != Hardware.T646;
    }

    public static boolean hasCapabilitySettingNightMode() {
        Hardware hardwareType = MicoManager.getInstance().getCurrentMico().getHardwareType();
        return (hardwareType == Hardware.LX04 || hardwareType == Hardware.T646) ? false : true;
    }

    public static boolean hasCapabilitySettingAuxInOrMultiRoom() {
        Hardware hardwareType = MicoManager.getInstance().getCurrentMico().getHardwareType();
        return hardwareType == Hardware.LX06 || hardwareType == Hardware.L06A;
    }

    public static boolean hasCapabilitySettingMultiRoom() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.MULTIROOM_MUSIC);
    }

    public static boolean isAreaCn() {
        return ApiConstants.getAreaCode() == AreaCode.CN;
    }

    public static boolean hasCapabilitySettingWiFi() {
        Hardware hardwareType = MicoManager.getInstance().getCurrentMico().getHardwareType();
        return (hardwareType == Hardware.LX04 || hardwareType == Hardware.X08A || hardwareType == Hardware.X08B || hardwareType == Hardware.T646 || hardwareType == Hardware.X08C) ? false : true;
    }

    public static boolean hasCapabilityQQMusic() {
        if (ApiConstants.getAreaCode() != AreaCode.TW && AccountProfile.MusicSuorce.QQ == AccountProfile.current().getMusicSource()) {
            return true;
        }
        return false;
    }

    public static boolean hasCapabilityMusicSource() {
        return ApiConstants.getAreaCode() != AreaCode.TW;
    }

    public static boolean hasCapabilityChildMode() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CHILD_MODE);
    }

    public static boolean hasCapabilityChildMode2() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CHILD_MODE_2);
    }

    public static boolean hasCapabilityMesh() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.MESH);
    }

    public static boolean hasCapabilityBleGateway() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.BLE_GATEWAY);
    }

    public static boolean hasCapabilityStereo() {
        for (Admin.Mico hasCapability : MicoManager.getInstance().getMicoList()) {
            if (hasCapability.hasCapability(MicoCapability.STEREO_MODE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasCapabilityMultiRoomMusic() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.MULTIROOM_MUSIC);
    }

    public static boolean hasCapabilityDtsEffect() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.DTS_SOUND_EFFECT);
    }

    public static boolean hasCapabilityEarthquakeAlarm() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        return currentMico.hasCapability(MicoCapability.EARTHQUAKE) && ApiConstants.getAreaCode() == AreaCode.CN && Hardware.T646 != currentMico.getHardwareType();
    }

    public static boolean hasCapabilitySkillTry() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.SKILL_TRY);
    }

    public static boolean hasCapabilityAlbum() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.FAMILY_ALBUM);
    }

    public static boolean hasCapabilityVoicePrint() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.VOICE_PRINT);
    }

    public static boolean hasCapabilityTone() {
        Admin.Mico currentMico = MicoManager.getInstance().getCurrentMico();
        Hardware hardware = Hardware.LX05A;
        currentMico.getHardwareType();
        return currentMico.hasCapability(MicoCapability.TONE_SETTING);
    }

    public static boolean hasCapabilityClassifiedAlarm() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CLASSIFIED_ALARM);
    }

    public static boolean hasCapabilityCustomIR() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CUSTOM_IR);
    }

    public static boolean hasCapabilityBabySchedule() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.BABY_SCHEDULE);
    }

    public static boolean hasCapabilityVoipV3() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.VOIP_SIGNAL);
    }

    public static boolean hasCapabilityXiaoMiVoip() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.XIAOMI_VOIP);
    }

    public static boolean hasCapabilityNearbyWakeup() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.NEARBY_WAKEUP) || MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.NEARBY_WAKEUP_CLOUD);
    }

    public static boolean hasCapabilityVideoCall(Admin.Mico mico) {
        return mico.hardware.equals(Hardware.X08A.getName()) || mico.hardware.equals(Hardware.X08C.getName());
    }

    public static boolean hasCapabilityVoipV3(Admin.Mico mico) {
        return mico.hasCapability(MicoCapability.VOIP_SIGNAL);
    }

    public static boolean notHasCapabilityVoip(Admin.Mico mico) {
        return mico.hardware.equals(Hardware.LX05.getName()) || mico.hardware.equals(Hardware.L07A.getName());
    }

    public static boolean hasCapabilityContinuousConversation() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.CONTINUOUS_DIALOGUE);
    }

    public static boolean hasCapabilityFamilyBank() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.FAMILY_BANK);
    }

    public static boolean hasCapabilitySchoolTimetable() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.SCHOOL_TIMETABLE);
    }

    public static boolean hasCapabilityDialog3_1() {
        return MicoManager.getInstance().getCurrentMico().hasCapability(MicoCapability.DIALOGUE_3_1);
    }

    static {
        new ahh();
    }
}
