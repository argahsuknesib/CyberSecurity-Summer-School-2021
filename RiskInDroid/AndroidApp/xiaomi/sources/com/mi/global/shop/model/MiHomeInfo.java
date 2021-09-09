package com.mi.global.shop.model;

import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class MiHomeInfo {
    private String mAddress;
    private int mCityId;
    private String mCityName;
    private int mHomeId;
    private String mLonLat;
    private String mName;
    private int mProvinceId;
    private String mProvinceName;
    private int mReserve;
    private String mTel;

    public MiHomeInfo(String str, String str2, String str3, String str4, int i, String str5, int i2, int i3, String str6, int i4) {
        this.mName = str;
        this.mAddress = str2;
        this.mTel = str3;
        this.mCityName = str4;
        this.mCityId = i;
        this.mProvinceName = str5;
        this.mProvinceId = i2;
        this.mHomeId = i3;
        this.mLonLat = str6;
        this.mReserve = i4;
    }

    public int getReserve() {
        return this.mReserve;
    }

    public void setReserve(int i) {
        this.mReserve = i;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getTel() {
        return this.mTel;
    }

    public void setTel(String str) {
        this.mTel = str;
    }

    public String getCityName() {
        return this.mCityName;
    }

    public void setCityName(String str) {
        this.mCityName = str;
    }

    public int getCityId() {
        return this.mCityId;
    }

    public void setCityId(int i) {
        this.mCityId = i;
    }

    public String getProvinceName() {
        return this.mProvinceName;
    }

    public void setProvinceName(String str) {
        this.mProvinceName = str;
    }

    public int getProvinceId() {
        return this.mProvinceId;
    }

    public void setProvinceId(int i) {
        this.mProvinceId = i;
    }

    public int getHomeId() {
        return this.mHomeId;
    }

    public void setHomeId(int i) {
        this.mHomeId = i;
    }

    public String getLonLat() {
        return this.mLonLat;
    }

    public void setLonLat(String str) {
        this.mLonLat = str;
    }

    public static ArrayList<MiHomeInfo> fromJSONObject(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2;
        ArrayList<MiHomeInfo> arrayList = new ArrayList<>();
        if (Tags.isJSONResultOK(jSONObject) && (jSONObject2 = jSONObject.getJSONObject("data")) != null) {
            arrayList.add(new MiHomeInfo(jSONObject2.getString("name"), jSONObject2.getString("address"), jSONObject2.getString("tel"), jSONObject2.getString("city_name"), jSONObject2.getInt("city"), jSONObject2.getString("province_name"), jSONObject2.getInt("province"), jSONObject2.getInt("home_id"), jSONObject2.getString("longitude_latitude"), jSONObject2.getInt("reserve")));
        }
        return arrayList;
    }
}
