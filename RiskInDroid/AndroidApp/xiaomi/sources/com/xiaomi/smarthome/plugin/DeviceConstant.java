package com.xiaomi.smarthome.plugin;

import java.util.Arrays;

public class DeviceConstant {
    private static final String[] MODELS_SUPPORT_NATIVE = {"isa.camera.hlc6", "chuangmi.camera.021a04", "chuangmi.camera.026c02", "chuangmi.camera.029a02", "chuangmi.camera.ipc022", "chuangmi.camera.ipc009", "chuangmi.camera.ipc019"};
    private static final String[] MODELS_SUPPORT_NATIVE_ALBUM = {"isa.camera.hlc6", "chuangmi.camera.ipc021", "chuangmi.camera.021a04", "chuangmi.camera.ip026c", "chuangmi.camera.026c02", "chuangmi.camera.ip029a", "chuangmi.camera.029a02"};
    private static final String[] MODELS_SUPPORT_NEW_UI = {"chuangmi.camera.ipc021", "chuangmi.camera.021a04", "chuangmi.camera.ip026c", "chuangmi.camera.026c02", "chuangmi.camera.ip029a", "chuangmi.camera.029a02", "chuangmi.camera.ipc009", "chuangmi.camera.ipc019", "chuangmi.camera.ipc022", "chuangmi.camera.039a01", "chuangmi.camera.049a01"};

    static {
        Arrays.sort(MODELS_SUPPORT_NEW_UI);
        Arrays.sort(MODELS_SUPPORT_NATIVE);
        Arrays.sort(MODELS_SUPPORT_NATIVE_ALBUM);
    }

    public static boolean isSingle(String str) {
        return "chuangmi.camera.ip026c".equals(str);
    }

    public static boolean isSupportCenter(String str) {
        return "chuangmi.camera.ip026c".equals(str) || "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.ip029a".equals(str) || "chuangmi.camera.026c02".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.029a02".equals(str) || "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean is2K(String str) {
        return !"chuangmi.camera.ip026c".equals(str) && !"chuangmi.camera.026c02".equals(str) && isNewChuangmi(str);
    }

    public static boolean isSupportWuliZhebi(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str);
    }

    public static boolean isSupportAiNative(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean isSupportBabyCryNative(String str) {
        return isNewChuangmi(str);
    }

    public static boolean isSupportFaceNative(String str) {
        return "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean isSupportPetNative(String str) {
        return "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean supportDownloadToPhone(String str) {
        return isNewChuangmi(str);
    }

    public static boolean supportNewPlayBack(String str) {
        return isNewChuangmi(str);
    }

    public static boolean toNewFileManagerSettingActivity(String str) {
        return isNewChuangmi(str);
    }

    public static boolean is16K(String str) {
        return isNewChuangmi(str);
    }

    public static boolean isG711(String str) {
        return isNewChuangmi(str);
    }

    public static boolean isNativePlugin(String str) {
        return isNewChuangmi(str);
    }

    public static boolean isNewChuangmi(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ipc022".equals(str) || "chuangmi.camera.ip026c".equals(str) || "chuangmi.camera.026c02".equals(str) || "chuangmi.camera.ip029a".equals(str) || "chuangmi.camera.029a02".equals(str);
    }

    public static boolean isNewPlayback(String str) {
        return "chuangmi.camera.ipc009".equals(str) || "chuangmi.camera.ipc019".equals(str) || "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ipc022".equals(str) || "chuangmi.camera.ip026c".equals(str) || "chuangmi.camera.026c02".equals(str) || "chuangmi.camera.ip029a".equals(str) || "chuangmi.camera.029a02".equals(str);
    }

    public static boolean isSupportPeopleMotion(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean isTFCardItemDeleted(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ip026c".equals(str) || "chuangmi.camera.026c02".equals(str) || "chuangmi.camera.ip029a".equals(str) || "chuangmi.camera.029a02".equals(str) || "chuangmi.camera.ipc009".equals(str) || "chuangmi.camera.ipc019".equals(str);
    }

    public static String[] supportNativePlugin() {
        return MODELS_SUPPORT_NATIVE;
    }

    public static boolean isSupportNewUI(String str) {
        return Arrays.binarySearch(MODELS_SUPPORT_NEW_UI, str) >= 0;
    }

    public static boolean shouldInsertIntoNonDidAlbum(String str) {
        return Arrays.binarySearch(MODELS_SUPPORT_NATIVE_ALBUM, str) >= 0;
    }

    public static boolean isSupportNewAlarm(String str) {
        return "chuangmi.camera.ipc021".equals(str) || "chuangmi.camera.021a04".equals(str) || "chuangmi.camera.ip029a".equals(str) || "chuangmi.camera.029a02".equals(str) || "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean isSupportOperation(String str) {
        return isSupportNewUI(str) || "chuangmi.camera.ipc022".equals(str);
    }

    public static boolean isNotSupportGeneralPlayer(String str) {
        return "chuangmi.camera.021a04".equals(str);
    }

    public static boolean isSupportPartSuperResolution(String str) {
        return "chuangmi.camera.ipc019".equals(str);
    }

    public static boolean isSupportCloudMp4Download(String str) {
        return "chuangmi.camera.ip029a".equals(str);
    }

    public static boolean isYunDingSpecial(String str) {
        return "loock.cateye.v01".equals(str) || "loock.cateye.v02".equals(str);
    }
}
