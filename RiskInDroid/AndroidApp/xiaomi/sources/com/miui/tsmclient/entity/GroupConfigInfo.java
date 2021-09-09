package com.miui.tsmclient.entity;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import com.miui.tsmclient.entity.ConfigInfo;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupConfigInfo extends CommonResponseInfo {
    @SerializedName("data")
    private Map<String, List<ConfigInfo.ConfigItem>> mGroupConfigData;

    public Map<String, List<ConfigInfo.ConfigItem>> getGroupConfigMap() {
        return this.mGroupConfigData;
    }

    public <T> List<T> getInfoList(String str, String str2, Type type) {
        return getInfoList(str, str2, type, new Gson());
    }

    public <T> List<T> getInfoList(String str, Type type, Gson gson) {
        return getInfoList(null, str, type, gson);
    }

    public <T> List<T> getInfoList(String str, String str2, Type type, Gson gson) {
        List<String> contentList = getContentList(str, str2);
        ArrayList arrayList = new ArrayList();
        for (String next : contentList) {
            if (!TextUtils.isEmpty(next)) {
                arrayList.add(gson.fromJson(next, type));
            }
        }
        return arrayList;
    }

    public List<String> getContentList(String str, String str2) {
        List<ConfigInfo.ConfigItem> list;
        ArrayList arrayList = new ArrayList();
        if (getGroupConfigMap() == null || (list = getGroupConfigMap().get(str2)) == null) {
            return arrayList;
        }
        for (ConfigInfo.ConfigItem configItem : list) {
            if (TextUtils.isEmpty(str) || str.equals(configItem.mCardName)) {
                arrayList.add(configItem.mContent);
            }
        }
        return arrayList;
    }
}
