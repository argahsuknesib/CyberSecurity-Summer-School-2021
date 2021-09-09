package com.xiaomi.mico.api.model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class ThirdPartyResponse {

    public static class AiFileToken {
        public String token;
    }

    public static class AiFileUploadResult {
        public String commitToken;
        public String fileId;
        public String fileLocalPath;
        public String filename;
    }

    public static class AppVersionInfo extends VersionInfo implements Serializable {
        private static final long serialVersionUID = 244831732543473368L;
        public UpgradeInfo upgradeInfo;
    }

    public static class CityData {
        @SerializedName("City")
        public List<HashMap<String, List<CityDetail>>> city;
    }

    public static class CityDetail {
        public String key;
        public String name;
    }

    public static class DidiPOIResponse implements Serializable {
        private static final long serialVersionUID = -5584075369517440451L;
        public String address;
        public String city;
        @SerializedName("lat")
        public double latitude;
        @SerializedName("lng")
        public double longitude;
        @SerializedName("displayname")
        public String name;
    }

    public static class FeedbackTags {
        public int code;
        public TagData data;
    }

    public static class GrayUpdateData {
        @SerializedName("upgradeInfo")
        public GrayUpdateInfo updateInfo;
    }

    public static class GrayUpdateInfo {
        public String changelogUrl;
        public String description;
        public String hash;
        public String link;
        public int size;
        public String upgradeId;
        @SerializedName("toVersion")
        public String version = "";
        public int weight;
    }

    public static class GrayUpgradeResponse {
        public int code;
        public GrayUpdateData data;
    }

    public static class ImageUploadData {
        public List<String> list;
    }

    public static class ImageUploadResponse {
        public ImageUploadData data;
    }

    public static class POIResponse implements Serializable {
        private static final long serialVersionUID = -6434066585657187461L;
        public String city;
        public String district;
        public double latitude;
        public double longitude;
        public String name;
    }

    public static class PlateInfo implements Serializable {
        private static final long serialVersionUID = 6010549617031797376L;
        public int index = -1;
        public String name;
        public boolean newEnergy;
        public String number;
    }

    public static class Tag {
        public int sort;
        public String tagContent;
        public long tagId;
    }

    public static class TagData {
        public List<WideTag> list;
    }

    public static class UpdateResponse {
        public int code;
        public UpdateData data;
    }

    public static class UpgradeInfo implements Serializable {
        private static final long serialVersionUID = -4619172415803890838L;
        public String changelogUrl;
        public String channel;
        public String hash;
        public String link;
        public String otherParam;
        public long size;
        public String version;
    }

    public static class UploadLog {
        public int code;
        public String msg;
    }

    public static class VoiceInfo implements Serializable {
        public boolean isDelete;
        public String nickName;
        public boolean status;
        public long updateTime;
        public String voiceId;
    }

    public static class VoipConfig {
        @SerializedName("free_seconds_normal")
        public long freeSeconds;
        @SerializedName("free_seconds_carrier")
        public long freeSecondsCarrier;
    }

    public static class WXTokenResponse {
        public String accessToken;
        public int expiresIn;
        public String openID;
        public String refreshToken;
    }

    public static class UpdateData {
        public AppVersionInfo appInfo;
        public boolean conflict;
        public List<RomVersionInfo> deviceInfo;

        public boolean hasUpgrade() {
            Admin.Mico micoByDeviceId;
            AppVersionInfo appVersionInfo = this.appInfo;
            if (appVersionInfo != null && appVersionInfo.needUpgrade) {
                return true;
            }
            List<RomVersionInfo> list = this.deviceInfo;
            if (list == null) {
                return false;
            }
            for (RomVersionInfo next : list) {
                if (next.needUpgrade && (micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(next.deviceId)) != null && micoByDeviceId.isOnline()) {
                    return true;
                }
            }
            return false;
        }

        public boolean needForceUpgrade() {
            Admin.Mico micoByDeviceId;
            if (ContainerUtil.isEmpty(this.deviceInfo)) {
                return false;
            }
            for (RomVersionInfo next : this.deviceInfo) {
                if (next.needUpgrade && (micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(next.deviceId)) != null && micoByDeviceId.isOnline() && micoByDeviceId.hasCapability(MicoCapability.FORCE_OTA)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class VersionInfo {
        public String changelogUrl;
        public String channel;
        public String deviceId;
        public String deviceName;
        public boolean forceOta;
        @SerializedName("hardwareVersion")
        public String model;
        public boolean needUpgrade;
        @SerializedName("romVersion")
        public String version;

        public boolean isAndroidRom() {
            if (ContainerUtil.isEmpty(this.model)) {
                return false;
            }
            return Hardware.safeValueOf(this.model).isAndroidRom();
        }
    }

    public static class RomVersionInfo extends VersionInfo implements Serializable {
        private static final long serialVersionUID = -5392236825848492395L;
        public List<UpgradeInfo> upgradeSteps;

        public UpgradeInfo getUpgradeInfo(int i) {
            List<UpgradeInfo> list = this.upgradeSteps;
            if (list == null || list.size() <= i) {
                return null;
            }
            return this.upgradeSteps.get(i);
        }
    }

    public class TrafficInfo {
        public Integer alarmModel = 1;
        public Integer alermCycle = 0;
        public String arriveTime;
        public String destination;
        public Integer estimateDuration;
        public Integer navigationMode;
        public String origination;
        public List<PlateInfo> plateInfoList;
        public List<String> plateNumberList;
        public String speakerLocation;

        public TrafficInfo() {
        }
    }

    public static class TrafficAddress {
        @SerializedName(alternate = {"ct"}, value = "city")
        public String city;
        @SerializedName(alternate = {"dist"}, value = "district")
        public String district;
        @SerializedName("lat")
        public double lat;
        @SerializedName(alternate = {"lon"}, value = "lng")
        public double lng;
        @SerializedName(alternate = {"n"}, value = "name")
        public String name;

        public TrafficAddress(POIResponse pOIResponse) {
            if (pOIResponse != null) {
                this.name = pOIResponse.name;
                this.lat = pOIResponse.latitude;
                this.lng = pOIResponse.longitude;
                this.city = pOIResponse.city;
                this.district = pOIResponse.district;
            }
        }

        public POIResponse toPOIResponse() {
            POIResponse pOIResponse = new POIResponse();
            pOIResponse.name = this.name;
            pOIResponse.latitude = this.lat;
            pOIResponse.longitude = this.lng;
            pOIResponse.city = this.city;
            pOIResponse.district = this.district;
            return pOIResponse;
        }

        public String toString() {
            return GsonUtil.getGsonInstance().toJson(this);
        }

        public static TrafficAddress from(String str) {
            return (TrafficAddress) GsonUtil.getGsonInstance().fromJson(str, TrafficAddress.class);
        }
    }

    public class FeedbackResponse {
        public String id;

        public FeedbackResponse() {
        }
    }

    public class FeedbackHistoryResponse {
        public List<FeedbackHistory> feedbackList;

        public FeedbackHistoryResponse() {
        }
    }

    public class FeedbackHistory {
        public long createTime;
        public String id;
        public String memo;
        public String query;
        public String response;
        public int status;
        public long updateTime;

        public FeedbackHistory() {
        }
    }

    public static class ChildProfile implements Serializable {
        private static final long serialVersionUID = 2599176925493927197L;
        public long birthday;
        public String nickName;
        public int sex;

        public boolean isBoy() {
            return this.sex == 1;
        }

        public String getBirthText() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            return simpleDateFormat.format(new Date(this.birthday));
        }

        public int getAge() {
            Date date = new Date(this.birthday);
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance.setTime(new Date());
            instance2.setTime(date);
            if (!instance2.after(instance)) {
                int i = instance.get(1) - instance2.get(1);
                return instance.get(6) < instance2.get(6) ? i - 1 : i;
            }
            throw new IllegalArgumentException("Can't be born in the future");
        }
    }

    public class BabySleepMode {
        public String end;
        public boolean isOpen;
        public String start;

        public BabySleepMode() {
        }
    }

    public class LanguageMap {
        @SerializedName("newsCategoryToLocale")
        public List<Map<String, String>> news;
        @SerializedName("sexToLocale")
        public List<Map<String, String>> sex;
        @SerializedName("zodiacSignToLocale")
        public List<Map<String, String>> xingzuo;

        public LanguageMap() {
        }
    }

    public static class WideTag {
        public String customInfo;
        private CustomInfo customInfoDic;
        public List<Tag> tags;
        public String wideTag;
        public long wideTagId;

        public CustomInfo customInfo() {
            CustomInfo customInfo2 = this.customInfoDic;
            if (customInfo2 != null) {
                return customInfo2;
            }
            String str = this.customInfo;
            if (str == null || str.length() < 2) {
                return null;
            }
            this.customInfoDic = (CustomInfo) GsonUtil.getGsonInstance().fromJson(this.customInfo, new TypeToken<CustomInfo>() {
                /* class com.xiaomi.mico.api.model.ThirdPartyResponse.WideTag.AnonymousClass1 */
            }.getType());
            CustomInfo customInfo3 = this.customInfoDic;
            if (customInfo3 != null) {
                customInfo3.convert();
            }
            return this.customInfoDic;
        }

        public static class CustomInfo {
            public List<String> supportedHardwares;

            public void convert() {
                convertSupportedHardwares();
            }

            private void convertSupportedHardwares() {
                ArrayList arrayList = new ArrayList();
                for (String lowerCase : this.supportedHardwares) {
                    arrayList.add(lowerCase.toLowerCase());
                }
                this.supportedHardwares = arrayList;
            }
        }
    }

    public static class ImsToken {
        @SerializedName("access_token")
        public String accessToken;
        @SerializedName("expires_in")
        public String expiresIn;
        @SerializedName("refresh_token")
        public String refreshToken;
        public String scope;
        @SerializedName("token_type")
        public String tokenType;

        public String toString() {
            return "ImsToken{accessToken='" + this.accessToken + '\'' + ", tokenType='" + this.tokenType + '\'' + ", refreshToken='" + this.refreshToken + '\'' + ", expiresIn='" + this.expiresIn + '\'' + ", scope='" + this.scope + '\'' + '}';
        }
    }

    public static class CmccDevice {
        public String cmccID;
        public String hardware;
        public String miotDID;

        public String toString() {
            return "CmccDevice{miotDID='" + this.miotDID + '\'' + ", cmccID='" + this.cmccID + '\'' + ", hardware='" + this.hardware + '\'' + '}';
        }
    }

    public static class UserPrivacy {
        public boolean musicPersonalization;
        public boolean wakeWordUpload;

        public String toJSON() {
            return GsonUtil.getGsonInstance().toJson(this);
        }
    }
}
