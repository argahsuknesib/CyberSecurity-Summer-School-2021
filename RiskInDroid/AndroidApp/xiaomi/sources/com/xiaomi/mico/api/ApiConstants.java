package com.xiaomi.mico.api;

import android.os.Build;
import android.os.LocaleList;
import com.xiaomi.mico.common.application.AreaCode;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.Locale;

public class ApiConstants {
    public static String MICO_SID = getMicoSid();
    public static AreaCode areaCode;
    private static volatile int sServerEnv = PreferenceUtils.getSettingInt(CommonApplication.getAppContext(), "mico_server_env", 3);

    static synchronized boolean switchServerEnv(int i) {
        synchronized (ApiConstants.class) {
            if (i == 1) {
                i = 2;
            }
            if (sServerEnv == i) {
                return false;
            }
            sServerEnv = i;
            PreferenceUtils.setSettingInt(CommonApplication.getAppContext(), "mico_server_env", i);
            return true;
        }
    }

    public static int getServerEnv() {
        return sServerEnv;
    }

    public static synchronized boolean isProductionEnv() {
        boolean z;
        synchronized (ApiConstants.class) {
            z = sServerEnv == 3;
        }
        return z;
    }

    public static synchronized boolean isPrevEnv() {
        boolean z;
        synchronized (ApiConstants.class) {
            z = sServerEnv == 2;
        }
        return z;
    }

    public static synchronized String getMicoBaseUrl() {
        synchronized (ApiConstants.class) {
            if (sServerEnv == 1) {
                return "https://staging.api.mina.mi.com/";
            }
            if (sServerEnv == 2) {
                return "https://preview-api.mina.mi.com/";
            }
            return "https://api2.mina.mi.com/";
        }
    }

    public static synchronized String getMicoSid() {
        String micoSid;
        synchronized (ApiConstants.class) {
            micoSid = getAreaCode().getMicoSid();
        }
        return micoSid;
    }

    public static AreaCode getAreaCode() {
        if (areaCode == null) {
            areaCode = AreaCode.getLocation();
        }
        return areaCode;
    }

    public static ServiceConfig[] getOfficeServices() {
        return getAreaCode().getOfficeServices();
    }

    public static ServiceConfig getServiceConfigByCls(Class<?> cls) {
        ServiceConfig[] officeServices = getOfficeServices();
        for (int i = 0; i < officeServices.length; i++) {
            if (officeServices[i].getServiceClass().equals(cls)) {
                return officeServices[i];
            }
        }
        return null;
    }

    public static class ServiceConfig {
        private final String baseUrl;
        private final String previewUrl;
        private final Class<?> serviceClass;

        public ServiceConfig(Class<?> cls, String str, String str2) {
            this.serviceClass = cls;
            this.baseUrl = str;
            this.previewUrl = str2;
        }

        public Class<?> getServiceClass() {
            return this.serviceClass;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public String getPreviewUrl() {
            return this.previewUrl;
        }
    }

    public static String getRomUpdateUrl() {
        return getAreaCode().getHostApiMiwifi() + "/rs/grayupgrade/v2/s12";
    }

    public static String getAppUpdateUrl() {
        return getAreaCode().getHostApiMiwifi() + "/rs/grayupgrade/v2/micoApp";
    }

    public static String getUpdateUrl() {
        return getAreaCode().getHostApiMiwifi() + "/upgrade/mico";
    }

    public static String getAPP_DAILY_UPDATE_URL() {
        return getAreaCode().getHostApiMiwifi() + "/upgrade/mico";
    }

    public static String getLogReportUrl() {
        return getAreaCode().getHostLogMiwifi() + "/log/common/micoApp";
    }

    public static String getFeedbackTagsUrl() {
        return getAreaCode().getHostLogMiwifi() + "/get/usertags";
    }

    public static String getMiUIFeedbackUrl() {
        return getAreaCode().getHostLogMiwifi() + "/report/feedback";
    }

    public static String getLogImageReportUrl() {
        return getAreaCode().getHostLogMiwifi() + "/log/image/batch/micoApp";
    }

    public static String getFileServiceUrl() {
        return getAreaCode().getHostFileService() + "/file/audio/mpeg";
    }

    public static String getImageServiceUrl() {
        return getAreaCode().getHostFileService() + "/file/image";
    }

    public static String getVideoServiceUrl() {
        return getAreaCode().getHostFileService() + "/file/video/mpeg";
    }

    public static String getSkillUrl() {
        return getAreaCode().getHostIAiMi() + "/v2/mico/api/skills";
    }

    public static String getEditSkillUrl() {
        return getAreaCode().getHostIAiMi() + "/v2/mico/api/skills/";
    }

    public static String getSkillGroupListUrl() {
        return getAreaCode().getHostIAiMi() + "/v2/mico/api/skills/group";
    }

    public static String getSkillListUrl() {
        return getAreaCode().getHostIAiMi() + "/v2/mico/api/skillsList";
    }

    public static String getAccountLinkUrl() {
        return getAreaCode().getHostIAiMi() + "/skills/account_link";
    }

    public static String getAiTrainUrl() {
        return getAreaCode().getHostIAiMi() + "/mico";
    }

    public static boolean isAreaCodeInTaiWan() {
        return getAreaCode() == AreaCode.TW;
    }

    public static boolean isAreaCodeInCN() {
        return getAreaCode() == AreaCode.CN;
    }

    public static String systemLanguage() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static String localeLanguage() {
        return "zh-TW".equalsIgnoreCase(systemLanguage()) ? "zh_tw" : "zh_cn";
    }

    public static String llocaleIdentifierLowercase() {
        AreaCode areaCode2 = getAreaCode();
        if (areaCode2 == AreaCode.TW) {
            return "zh_tw";
        }
        if (areaCode2 == AreaCode.CN) {
        }
        return "zh_ch";
    }

    public static String localeIdentifierUppercase() {
        AreaCode areaCode2 = getAreaCode();
        if (areaCode2 == AreaCode.TW) {
            return "zh_TW";
        }
        if (areaCode2 == AreaCode.CN) {
        }
        return "zh_CN";
    }

    public static String getSchoolTimeTableUrl() {
        return sServerEnv == 2 ? "https://preview.i.ai.mi.com/h5/precache/ai-schedule/#/" : "https://i.ai.mi.com/h5/precache/ai-schedule/#/";
    }

    public static String getFamilyBankUrl() {
        return sServerEnv == 2 ? "http://staging.m.familybank.mipay.com/home" : "https://m.familybank.mipay.com/home";
    }
}
