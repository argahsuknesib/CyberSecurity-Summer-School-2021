package com.miui.tsmclient.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miui.tsmclient.database.JSONSerializable;
import com.miui.tsmclient.util.LogUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CardUIInfo implements Parcelable, JSONSerializable, ObjectParser<CardUIInfo> {
    public static final Parcelable.Creator<CardUIInfo> CREATOR = new Parcelable.Creator<CardUIInfo>() {
        /* class com.miui.tsmclient.entity.CardUIInfo.AnonymousClass1 */

        public final CardUIInfo createFromParcel(Parcel parcel) {
            return new CardUIInfo(parcel);
        }

        public final CardUIInfo[] newArray(int i) {
            return new CardUIInfo[i];
        }
    };
    public String mCardDesc;
    public String mCardDetailDesc;
    public String mCardDiscountDesc;
    public String mCardGifBgHdUrl;
    public String mCardIssuedListBgHdUrl;
    public String mCardIssuedListBgUrl;
    public String mCardLogoUrl;
    public String mCardPreIssuedListBgUrl;
    public String mFamilyDesc1;
    public String mFamilyDesc2;
    public String mIssuedDetailBgUrl;
    public String mNewCardDetailDesc;
    public String mPersonalCardFace;
    public String mPreIssuedDetailBgUrl;
    public String mSimpleRideDiscountDesc;
    public String mSimpleSupportAreasDesc;
    public String mSupportedCityDesc;
    private Map<String, String> mThemeFgRules;

    public int describeContents() {
        return 0;
    }

    private CardUIInfo(Parcel parcel) {
        readFromParcel(parcel);
    }

    public CardUIInfo() {
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardDesc);
        parcel.writeString(this.mCardPreIssuedListBgUrl);
        parcel.writeString(this.mCardIssuedListBgUrl);
        parcel.writeString(this.mCardLogoUrl);
        parcel.writeString(this.mPreIssuedDetailBgUrl);
        parcel.writeString(this.mCardDetailDesc);
        parcel.writeString(this.mIssuedDetailBgUrl);
        parcel.writeString(this.mCardIssuedListBgHdUrl);
        parcel.writeValue(this.mThemeFgRules);
        parcel.writeString(this.mCardGifBgHdUrl);
        parcel.writeString(this.mPersonalCardFace);
        parcel.writeString(this.mSupportedCityDesc);
        parcel.writeString(this.mSimpleSupportAreasDesc);
        parcel.writeString(this.mCardDiscountDesc);
        parcel.writeString(this.mSimpleRideDiscountDesc);
        parcel.writeString(this.mNewCardDetailDesc);
        parcel.writeString(this.mFamilyDesc1);
        parcel.writeString(this.mFamilyDesc2);
    }

    public void readFromParcel(Parcel parcel) {
        this.mCardDesc = parcel.readString();
        this.mCardPreIssuedListBgUrl = parcel.readString();
        this.mCardIssuedListBgUrl = parcel.readString();
        this.mCardLogoUrl = parcel.readString();
        this.mPreIssuedDetailBgUrl = parcel.readString();
        this.mCardDetailDesc = parcel.readString();
        this.mIssuedDetailBgUrl = parcel.readString();
        this.mCardIssuedListBgHdUrl = parcel.readString();
        this.mThemeFgRules = (Map) parcel.readValue(Map.class.getClassLoader());
        this.mCardGifBgHdUrl = parcel.readString();
        this.mPersonalCardFace = parcel.readString();
        this.mSupportedCityDesc = parcel.readString();
        this.mSimpleSupportAreasDesc = parcel.readString();
        this.mCardDiscountDesc = parcel.readString();
        this.mSimpleRideDiscountDesc = parcel.readString();
        this.mNewCardDetailDesc = parcel.readString();
        this.mFamilyDesc1 = parcel.readString();
        this.mFamilyDesc2 = parcel.readString();
    }

    public CardUIInfo parse(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (jSONObject.has("card_ui_info")) {
                doParse(jSONObject.optJSONObject("card_ui_info"));
            } else {
                doParse(jSONObject);
            }
        }
        return this;
    }

    private void doParse(JSONObject jSONObject) {
        this.mCardDesc = jSONObject.optString("subTitle");
        this.mCardPreIssuedListBgUrl = jSONObject.optString("preIssuedListBg");
        this.mCardIssuedListBgUrl = jSONObject.optString("issuedListBg");
        this.mCardLogoUrl = jSONObject.optString("logo");
        this.mPreIssuedDetailBgUrl = jSONObject.optString("preIssuedDetailBg");
        this.mCardDetailDesc = jSONObject.optString("detailDesc");
        this.mIssuedDetailBgUrl = jSONObject.optString("issuedDetailBg");
        this.mCardIssuedListBgHdUrl = jSONObject.optString("issuedListBgHd");
        this.mThemeFgRules = (Map) new Gson().fromJson(jSONObject.optString("themeFgRules"), new TypeToken<Map<String, String>>() {
            /* class com.miui.tsmclient.entity.CardUIInfo.AnonymousClass2 */
        }.getType());
        this.mCardGifBgHdUrl = jSONObject.optString("gifUrl");
        if (jSONObject.has("personalCardFace")) {
            this.mPersonalCardFace = jSONObject.optString("personalCardFace");
        }
        if (jSONObject.has("supportAreas")) {
            this.mSupportedCityDesc = jSONObject.optString("supportAreas");
        }
        if (jSONObject.has("simpleSupportAreas")) {
            this.mSimpleSupportAreasDesc = jSONObject.optString("simpleSupportAreas");
        }
        if (jSONObject.has("rideDiscount")) {
            this.mCardDiscountDesc = jSONObject.optString("rideDiscount");
        }
        if (jSONObject.has("simpleRideDiscount")) {
            this.mSimpleRideDiscountDesc = jSONObject.optString("simpleRideDiscount");
        }
        if (jSONObject.has("newCardDetailDesc")) {
            this.mNewCardDetailDesc = jSONObject.optString("newCardDetailDesc");
        }
        if (jSONObject.has("familyDesc1")) {
            this.mFamilyDesc1 = jSONObject.optString("familyDesc1");
        }
        if (jSONObject.has("familyDesc2")) {
            this.mFamilyDesc2 = jSONObject.optString("familyDesc2");
        }
    }

    public JSONObject serialize() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subTitle", this.mCardDesc);
            jSONObject.put("preIssuedListBg", this.mCardPreIssuedListBgUrl);
            jSONObject.put("issuedListBg", this.mCardIssuedListBgUrl);
            jSONObject.put("logo", this.mCardLogoUrl);
            jSONObject.put("preIssuedDetailBg", this.mPreIssuedDetailBgUrl);
            jSONObject.put("detailDesc", this.mCardDetailDesc);
            jSONObject.put("issuedDetailBg", this.mIssuedDetailBgUrl);
            jSONObject.put("issuedListBgHd", this.mCardIssuedListBgHdUrl);
            jSONObject.put("themeFgRules", new Gson().toJson(this.mThemeFgRules));
            jSONObject.put("gifUrl", this.mCardGifBgHdUrl);
            jSONObject.put("personalCardFace", this.mPersonalCardFace);
            jSONObject.put("supportAreas", this.mSupportedCityDesc);
            jSONObject.put("simpleSupportAreas", this.mSimpleSupportAreasDesc);
            jSONObject.put("rideDiscount", this.mCardDiscountDesc);
            jSONObject.put("simpleRideDiscount", this.mSimpleRideDiscountDesc);
            jSONObject.put("newCardDetailDesc", this.mNewCardDetailDesc);
            jSONObject.put("familyDesc1", this.mFamilyDesc1);
            jSONObject.put("familyDesc2", this.mFamilyDesc2);
        } catch (JSONException e) {
            LogUtils.e("serialize card ui info to json object failed!", e);
        }
        return jSONObject;
    }

    public String getThemeFgArt(String str) {
        Map<String, String> map = this.mThemeFgRules;
        return map == null ? "" : map.get(str);
    }

    public String getBackground() {
        if (TextUtils.isEmpty(this.mPersonalCardFace)) {
            return this.mCardIssuedListBgHdUrl;
        }
        return this.mPersonalCardFace;
    }
}
