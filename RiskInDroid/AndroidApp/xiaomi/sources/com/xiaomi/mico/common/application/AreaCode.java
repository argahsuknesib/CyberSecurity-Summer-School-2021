package com.xiaomi.mico.common.application;

import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiManager;
import com.xiaomi.mico.api.service.BabySchedulerService;
import com.xiaomi.mico.api.service.DisplayService;
import com.xiaomi.mico.api.service.IAreaCodeService;
import com.xiaomi.mico.api.service.MiHomeService;
import com.xiaomi.mico.api.service.MinaService;
import com.xiaomi.mico.api.service.PaymentService;
import com.xiaomi.mico.api.service.SkillstoreService;
import com.xiaomi.mico.api.service.UserProfile;
import com.xiaomi.mico.common.util.PreferenceUtils;
import com.xiaomi.smarthome.application.CommonApplication;

public enum AreaCode implements IAreaCodeService {
    CN("CN") {
        public final int getCountryCode() {
            return 0;
        }

        public final String getHostApiMiwifi() {
            return "https://api.miwifi.com";
        }

        public final String getHostFileService() {
            return "https://file.ai.xiaomi.com";
        }

        public final String getHostIAiMi() {
            return "https://i.ai.mi.com";
        }

        public final String getHostLogMiwifi() {
            return "https://log.miwifi.com";
        }

        public final String getMicoBaseUrl() {
            return null;
        }

        public final String getMicoSid() {
            return "micoapi";
        }

        public final ApiConstants.ServiceConfig[] getOfficeServices() {
            return new ApiConstants.ServiceConfig[]{new ApiConstants.ServiceConfig(MinaService.class, "https://api2.mina.mi.com/", "https://preview-api.mina.mi.com/"), new ApiConstants.ServiceConfig(UserProfile.class, "https://userprofile.mina.mi.com/", "https://preview-userprofile.mina.mi.com/"), new ApiConstants.ServiceConfig(SkillstoreService.class, "https://skillstore.mina.mi.com/", "https://preview-skillstore.mina.mi.com/"), new ApiConstants.ServiceConfig(PaymentService.class, "https://payment.api.mina.mi.com", "https://preview-payment.mina.mi.com"), new ApiConstants.ServiceConfig(DisplayService.class, "https://display.api.mina.mi.com/", "https://preview-display.mina.mi.com/"), new ApiConstants.ServiceConfig(BabySchedulerService.class, "https://api.mina.mi.com/", "https://preview-api.mina.mi.com/"), new ApiConstants.ServiceConfig(MiHomeService.class, "https://home.mi.com", "https://home.mi.com")};
        }
    },
    TW("TW") {
        public final int getCountryCode() {
            return 1;
        }

        public final String getHostApiMiwifi() {
            return "https://tw.api.miwifi.com";
        }

        public final String getHostFileService() {
            return "https://tw.file.ai.xiaomi.com";
        }

        public final String getHostIAiMi() {
            return "https://tw.i.ai.mi.com";
        }

        public final String getHostLogMiwifi() {
            return "https://tw.log.miwifi.com";
        }

        public final String getMicoBaseUrl() {
            return null;
        }

        public final ApiConstants.ServiceConfig[] getOfficeServices() {
            return new ApiConstants.ServiceConfig[]{new ApiConstants.ServiceConfig(MinaService.class, "https://tw.api2.mina.mi.com/", "https://tw.api2.mina.mi.com/"), new ApiConstants.ServiceConfig(UserProfile.class, "https://tw.userprofile.mina.mi.com/", "https://tw.userprofile.mina.mi.com/"), new ApiConstants.ServiceConfig(SkillstoreService.class, "https://tw.skillstore.mina.mi.com/", "https://tw.skillstore.mina.mi.com/")};
        }

        public final String getMicoSid() {
            new Object[1][0] = "MICO_TW_SID";
            return "micoapi_sgp";
        }
    },
    NONE("") {
        public final int getCountryCode() {
            return 0;
        }

        public final String getHostApiMiwifi() {
            return "https://api.miwifi.com";
        }

        public final String getHostFileService() {
            return "https://file.ai.xiaomi.com";
        }

        public final String getHostIAiMi() {
            return "https://i.ai.mi.com";
        }

        public final String getHostLogMiwifi() {
            return "https://log.miwifi.com";
        }

        public final String getMicoBaseUrl() {
            return null;
        }

        public final String getMicoSid() {
            return null;
        }

        public final ApiConstants.ServiceConfig[] getOfficeServices() {
            return new ApiConstants.ServiceConfig[0];
        }
    };
    
    private String code;

    private AreaCode(String str) {
        this.code = str;
    }

    public String getCode() {
        return this.code;
    }

    public static AreaCode value(String str) {
        for (AreaCode areaCode : values()) {
            if (areaCode.code.equalsIgnoreCase(str)) {
                return areaCode;
            }
        }
        return NONE;
    }

    public static void setLocation(String str) {
        PreferenceUtils.setSettingString(CommonApplication.getAppContext(), "area_code", str);
        AreaCode value = value(str);
        ApiConstants.MICO_SID = value.getMicoSid();
        ApiConstants.areaCode = value;
        ApiManager.getInstance().clearService();
        AccountProfile.current().logout();
    }

    public static AreaCode getLocation() {
        if (!ApplicationConstants.isTaiWanEnabled()) {
            return CN;
        }
        return value(PreferenceUtils.getSettingString(CommonApplication.getAppContext(), "area_code", CN.getCode()));
    }
}
