package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ConfigInfo extends CommonResponseInfo {
    @SerializedName("data")
    private Map<String, ConfigItem> mConfigData;

    public static class BannerInfo {
        @SerializedName("img")
        public String mBannerImg;
        @SerializedName("link")
        public String mBannerLink;
    }

    public static class ConfigItem {
        @SerializedName("cardName")
        public String mCardName;
        @SerializedName("content")
        public String mContent;
        @SerializedName("key")
        public String mKey;
        @SerializedName("name")
        public String mName;
        @SerializedName("type")
        public String mType;
    }

    public static class MiPayBankDiscountInfo {
        @SerializedName("name")
        public String mDiscountName;
        @SerializedName("url")
        public String mDiscountUrl;
    }

    public static class MiPayBankGuideInfo {
        @SerializedName("name")
        public String mGuideName;
        @SerializedName("url")
        public String mGuideUrl;
    }

    public static class MiPayBankOptionInfo {
        @SerializedName("name")
        public String mOptionName;
        @SerializedName("intent")
        public String mUri;
        @SerializedName("url")
        public String mUrl;
    }

    public static class TrafficCardProblemInfo {
        @SerializedName("content")
        public String mContent;
        @SerializedName("link")
        public String mLink;
        @SerializedName("type")
        public int mLinkType;
    }

    public Map<String, ConfigItem> getConfigMap() {
        return this.mConfigData;
    }

    public boolean getSupportFeature(String str, String str2) {
        Map<String, ConfigItem> map = this.mConfigData;
        if (!(map == null || map.get(str) == null)) {
            String str3 = this.mConfigData.get(str).mContent;
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.replace(" ", "").toLowerCase().split("\\s*,\\s*");
                String lowerCase = str2.toLowerCase();
                for (String equals : split) {
                    if (TextUtils.equals(equals, lowerCase)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public List<BannerInfo> getBannerList(String str) {
        BannerInfo[] bannerInfoArr = (BannerInfo[]) getInfo(str, BannerInfo[].class);
        if (bannerInfoArr != null) {
            return Arrays.asList(bannerInfoArr);
        }
        return Collections.emptyList();
    }

    public CardAppInfo getCardAppInfo(String str) {
        return (CardAppInfo) getInfo(str, CardAppInfo.class);
    }

    public MaintainInfo getMaintainInfo() {
        return (MaintainInfo) getInfo("MAINTAIN_INFO", MaintainInfo.class);
    }

    public List<TrafficCardProblemInfo> getProblemList(String str) {
        TrafficCardProblemInfo[] trafficCardProblemInfoArr = (TrafficCardProblemInfo[]) getInfo(str, TrafficCardProblemInfo[].class);
        if (trafficCardProblemInfoArr != null) {
            return Arrays.asList(trafficCardProblemInfoArr);
        }
        return Collections.emptyList();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T
     arg types: [java.lang.String, java.lang.Class<T>]
     candidates:
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.Class):T
      com.google.gson.Gson.fromJson(com.google.gson.JsonElement, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(com.google.gson.stream.JsonReader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.Class):T
      com.google.gson.Gson.fromJson(java.io.Reader, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.reflect.Type):T
      com.google.gson.Gson.fromJson(java.lang.String, java.lang.Class):T */
    public <T> T getInfo(String str, Class<T> cls) {
        ConfigItem configItem = getConfigMap().get(str);
        if (configItem == null) {
            return null;
        }
        String str2 = configItem.mContent;
        if (!TextUtils.isEmpty(str2)) {
            return new Gson().fromJson(str2, (Class) cls);
        }
        return null;
    }

    public String getContentByConfigKey(String str) {
        Map<String, ConfigItem> map = this.mConfigData;
        if (map == null || map.get(str) == null) {
            return null;
        }
        return this.mConfigData.get(str).mContent;
    }

    public static class CardAppInfo implements Parcelable {
        public static final Parcelable.Creator<CardAppInfo> CREATOR = new Parcelable.Creator<CardAppInfo>() {
            /* class com.miui.tsmclient.entity.ConfigInfo.CardAppInfo.AnonymousClass1 */

            public final CardAppInfo createFromParcel(Parcel parcel) {
                return new CardAppInfo(parcel);
            }

            public final CardAppInfo[] newArray(int i) {
                return new CardAppInfo[i];
            }
        };
        @SerializedName("logoUrl")
        public String mCardAppLogoUrl;
        @SerializedName("subTitle")
        public String mCardAppSubTitle;
        @SerializedName("title")
        public String mCardAppTitle;
        @SerializedName("content")
        public String mFooterContent;
        @SerializedName("keyword")
        public String mFooterKeyword;
        @SerializedName("link")
        public String mFooterLink;

        public int describeContents() {
            return 0;
        }

        protected CardAppInfo(Parcel parcel) {
            this.mFooterContent = parcel.readString();
            this.mFooterLink = parcel.readString();
            this.mFooterKeyword = parcel.readString();
            this.mCardAppLogoUrl = parcel.readString();
            this.mCardAppTitle = parcel.readString();
            this.mCardAppSubTitle = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mFooterContent);
            parcel.writeString(this.mFooterLink);
            parcel.writeString(this.mFooterKeyword);
            parcel.writeString(this.mCardAppLogoUrl);
            parcel.writeString(this.mCardAppTitle);
            parcel.writeString(this.mCardAppSubTitle);
        }
    }

    public static class MaintainInfo implements Parcelable {
        public static final Parcelable.Creator<MaintainInfo> CREATOR = new Parcelable.Creator<MaintainInfo>() {
            /* class com.miui.tsmclient.entity.ConfigInfo.MaintainInfo.AnonymousClass1 */

            public final MaintainInfo createFromParcel(Parcel parcel) {
                return new MaintainInfo(parcel);
            }

            public final MaintainInfo[] newArray(int i) {
                return new MaintainInfo[i];
            }
        };
        @SerializedName("content")
        public String mContent;
        @SerializedName("iconUrl")
        public String mIconUrl;
        @SerializedName("id")
        public String mId;
        @SerializedName("tips")
        public String mTips;
        @SerializedName("title")
        public String mTitle;

        public int describeContents() {
            return 0;
        }

        protected MaintainInfo(Parcel parcel) {
            this.mId = parcel.readString();
            this.mIconUrl = parcel.readString();
            this.mTitle = parcel.readString();
            this.mContent = parcel.readString();
            this.mTips = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.mId);
            parcel.writeString(this.mIconUrl);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mContent);
            parcel.writeString(this.mTips);
        }
    }
}
