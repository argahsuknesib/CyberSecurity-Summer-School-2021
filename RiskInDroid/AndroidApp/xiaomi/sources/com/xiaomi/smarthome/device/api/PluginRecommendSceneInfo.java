package com.xiaomi.smarthome.device.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginRecommendSceneInfo {
    public boolean hasScene = false;
    public JSONObject mActionSaIds = new JSONObject();
    public Map<Integer, CommonSceneAction> mCommonActions = new HashMap();
    public Map<Integer, CommonSceneCondition> mCommonConditions = new HashMap();
    public JSONObject mConditionScIds = new JSONObject();
    public List<RecommendSceneItem> mSceneItems = new ArrayList();

    public static class SceneAttr {
        int attrId;
        public String subTitle;
    }

    public static class SceneAttrFencing extends SceneAttr {
        public String actName;
        public float latitude;
        public float longitude;
        public float radius;
        public String radiusDegree;
    }

    public static class SceneAttrNumberPicker extends SceneAttr {
        public float defaultValue;
        public String degree;
        public float interval;
        public String jsonTag;
        public float maxValue;
        public float minValue;
        public ArrayList<NumberPickerTag> showTags = new ArrayList<>();
    }

    public static boolean isSupportAndroid(int i) {
        return i == 0 || i == 1;
    }

    public static PluginRecommendSceneInfo parse(JSONObject jSONObject) {
        PluginRecommendSceneInfo pluginRecommendSceneInfo = new PluginRecommendSceneInfo();
        JSONArray optJSONArray = jSONObject.optJSONArray("scene_recom");
        pluginRecommendSceneInfo.hasScene = jSONObject.optBoolean("has_scene_already");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            return pluginRecommendSceneInfo;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i).optJSONObject("info");
            if (optJSONObject != null) {
                RecommendSceneItem recommendSceneItem = new RecommendSceneItem();
                recommendSceneItem.entryDesc = optJSONArray.optJSONObject(i).optString("entry_desc");
                recommendSceneItem.cardDesc = optJSONArray.optJSONObject(i).optString("desc");
                recommendSceneItem.needDelay = optJSONArray.optJSONObject(i).optBoolean("need_delay", false);
                recommendSceneItem.cardImgUrl = optJSONArray.optJSONObject(i).optString("img_url");
                recommendSceneItem.ua = optJSONObject.optInt("ua", -1);
                if (isSupportAndroid(recommendSceneItem.ua)) {
                    recommendSceneItem.sr_id = optJSONObject.optString("sr_id");
                    recommendSceneItem.intro = optJSONObject.optString("intro");
                    if (TextUtils.isEmpty(recommendSceneItem.intro)) {
                        recommendSceneItem.intro = optJSONArray.optJSONObject(i).optString("title");
                    }
                    recommendSceneItem.st_id = optJSONObject.optInt("st_id");
                    recommendSceneItem.enable = optJSONObject.optInt("enable");
                    recommendSceneItem.enable_push = optJSONObject.optInt("enable_push");
                    recommendSceneItem.url = optJSONObject.optString("jpg", "");
                    recommendSceneItem.gifUrl = optJSONObject.optString("gif");
                    recommendSceneItem.isConditionDevice = TextUtils.equals("trigger", optJSONObject.optString("trigger_or_action"));
                    recommendSceneItem.isActionDevice = TextUtils.equals("action", optJSONObject.optString("trigger_or_action"));
                    recommendSceneItem.selectActionHint = optJSONArray.optJSONObject(i).optString("action_device_name");
                    recommendSceneItem.selectConditionHint = optJSONArray.optJSONObject(i).optString("trigger_device_name");
                    recommendSceneItem.selectDeviceHint = optJSONArray.optJSONObject(i).optString("select_device");
                    recommendSceneItem.selectValueHint = optJSONArray.optJSONObject(i).optString("select_value");
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("launch");
                    if (optJSONArray2 != null) {
                        recommendSceneItem.mConditionList.addAll(ConditionActionItem.parseList(optJSONArray2));
                    }
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("action");
                    if (optJSONArray3 != null) {
                        recommendSceneItem.mActionList.addAll(ConditionActionItem.parseList(optJSONArray3));
                    }
                    arrayList.add(recommendSceneItem);
                }
            }
        }
        pluginRecommendSceneInfo.mSceneItems.addAll(arrayList);
        pluginRecommendSceneInfo.mConditionScIds = jSONObject.optJSONObject("sc_ids");
        JSONObject jSONObject2 = pluginRecommendSceneInfo.mConditionScIds;
        Iterator<String> it = null;
        Iterator<String> keys = jSONObject2 == null ? null : jSONObject2.keys();
        while (keys != null && keys.hasNext()) {
            String str = (String) keys.next();
            CommonSceneCondition parseFromJSON = CommonSceneCondition.parseFromJSON(pluginRecommendSceneInfo.mConditionScIds.optJSONObject(str));
            if (parseFromJSON != null) {
                try {
                    parseFromJSON.id = Integer.parseInt(str);
                } catch (Exception unused) {
                }
                if (parseFromJSON.id > 0) {
                    pluginRecommendSceneInfo.mCommonConditions.put(Integer.valueOf(parseFromJSON.id), parseFromJSON);
                }
            }
        }
        pluginRecommendSceneInfo.mActionSaIds = jSONObject.optJSONObject("sa_ids");
        JSONObject jSONObject3 = pluginRecommendSceneInfo.mActionSaIds;
        if (jSONObject3 != null) {
            it = jSONObject3.keys();
        }
        while (it != null && it.hasNext()) {
            String next = it.next();
            CommonSceneAction parseFromJSON2 = CommonSceneAction.parseFromJSON(pluginRecommendSceneInfo.mActionSaIds.optJSONObject(next));
            if (parseFromJSON2 != null) {
                try {
                    parseFromJSON2.id = Integer.parseInt(next);
                } catch (Exception unused2) {
                }
                if (parseFromJSON2.id > 0) {
                    pluginRecommendSceneInfo.mCommonActions.put(Integer.valueOf(parseFromJSON2.id), parseFromJSON2);
                }
            }
        }
        return pluginRecommendSceneInfo;
    }

    public static class RecommendSceneItem {
        public String cardDesc;
        public String cardImgUrl;
        public int enable;
        public int enable_push;
        public String entryDesc;
        public String gifUrl;
        public String intro;
        public boolean isActionDevice;
        public boolean isConditionDevice;
        public List<ConditionActionItem> mActionList = new ArrayList();
        public List<RecommendBuy> mBuyLinks = new ArrayList();
        public Map<Integer, CommonSceneAction> mCommonActions = new HashMap();
        public Map<Integer, CommonSceneCondition> mCommonConditions = new HashMap();
        public List<ConditionActionItem> mConditionList = new ArrayList();
        public boolean needDelay = false;
        public String selectActionHint;
        public String selectConditionHint;
        public String selectDeviceHint;
        public String selectValueHint;
        public String smallImgUrl;
        public String sr_id;
        public int st_id;
        public String timeSpan;
        public int ua;
        public String url;

        public static RecommendSceneItem parseFrom(String str) {
            RecommendSceneItem recommendSceneItem = new RecommendSceneItem();
            try {
                JSONObject jSONObject = new JSONObject(str);
                recommendSceneItem.ua = jSONObject.optInt("ua", -1);
                if (!PluginRecommendSceneInfo.isSupportAndroid(recommendSceneItem.ua)) {
                    return null;
                }
                recommendSceneItem.sr_id = jSONObject.optString("sr_id");
                recommendSceneItem.intro = jSONObject.optString("intro");
                recommendSceneItem.entryDesc = jSONObject.optString("entry_desc");
                recommendSceneItem.smallImgUrl = jSONObject.optString("small_img_url");
                recommendSceneItem.st_id = jSONObject.optInt("st_id");
                recommendSceneItem.enable = jSONObject.optInt("enable");
                recommendSceneItem.enable_push = jSONObject.optInt("enable_push");
                recommendSceneItem.url = jSONObject.optString("jpg", "");
                recommendSceneItem.gifUrl = jSONObject.optString("gif");
                JSONArray optJSONArray = jSONObject.optJSONArray("launch");
                if (optJSONArray != null) {
                    recommendSceneItem.mConditionList.addAll(ConditionActionItem.parseList(optJSONArray));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("action");
                if (optJSONArray2 != null) {
                    recommendSceneItem.mActionList.addAll(ConditionActionItem.parseList(optJSONArray2));
                }
                return recommendSceneItem;
            } catch (JSONException unused) {
                return null;
            }
        }
    }

    public static class ConditionActionItem {
        public int actionType;
        public String mConditionKey;
        public String mConditionSrc;
        public JSONArray mGidJArray = new JSONArray();
        public JSONObject modelListJobj = new JSONObject();
        public String name;

        public static List<ConditionActionItem> parseList(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (!(jSONArray == null || jSONArray.length() == 0)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    ConditionActionItem conditionActionItem = new ConditionActionItem();
                    conditionActionItem.name = optJSONObject.optString("name", "");
                    conditionActionItem.modelListJobj = optJSONObject.optJSONObject("model_list");
                    JSONObject jSONObject = conditionActionItem.modelListJobj;
                    if (jSONObject == null || !jSONObject.keys().hasNext()) {
                        conditionActionItem.modelListJobj = optJSONObject.optJSONObject("model_lists");
                    }
                    conditionActionItem.mGidJArray = optJSONObject.optJSONArray("gid");
                    conditionActionItem.actionType = optJSONObject.optInt("type", 0);
                    conditionActionItem.mConditionSrc = optJSONObject.optString("src", "");
                    conditionActionItem.mConditionKey = optJSONObject.optString("key", "");
                    arrayList.add(conditionActionItem);
                }
            }
            return arrayList;
        }
    }

    public static class NumberPickerTag implements Parcelable {
        public static final Parcelable.Creator<NumberPickerTag> CREATOR = new Parcelable.Creator<NumberPickerTag>() {
            /* class com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo.NumberPickerTag.AnonymousClass1 */

            public final NumberPickerTag createFromParcel(Parcel parcel) {
                return new NumberPickerTag(parcel);
            }

            public final NumberPickerTag[] newArray(int i) {
                return new NumberPickerTag[i];
            }
        };
        public float from;
        public String tag;
        public float to;

        public int describeContents() {
            return 0;
        }

        public NumberPickerTag() {
        }

        protected NumberPickerTag(Parcel parcel) {
            this.from = parcel.readFloat();
            this.to = parcel.readFloat();
            this.tag = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.from);
            parcel.writeFloat(this.to);
            parcel.writeString(this.tag);
        }
    }

    public static class CommonSceneCondition {
        public int id;
        public SceneAttr mAttr;
        public int mCompatibleId = -1;
        public int mGroupId = -1;
        public String mGroupName;
        public String mKey;
        public String mName;
        public String mParamAction;
        public String mSrc;
        public Object mValue;

        public static CommonSceneCondition parseFromJSON(JSONObject jSONObject) {
            String str;
            String str2;
            String str3;
            CommonSceneCondition commonSceneCondition;
            JSONObject optJSONObject;
            JSONObject jSONObject2 = jSONObject;
            CommonSceneCondition commonSceneCondition2 = new CommonSceneCondition();
            commonSceneCondition2.mName = jSONObject2.optString("name");
            commonSceneCondition2.mKey = jSONObject2.optString("key");
            commonSceneCondition2.mSrc = jSONObject2.optString("src");
            commonSceneCondition2.mCompatibleId = jSONObject2.optInt("tr_id");
            commonSceneCondition2.id = jSONObject2.optInt("sc_id");
            commonSceneCondition2.mValue = jSONObject2.opt("value");
            commonSceneCondition2.mParamAction = jSONObject2.optString("plug_id");
            if (jSONObject2.has("groupInfo") && (optJSONObject = jSONObject2.optJSONObject("groupInfo")) != null && optJSONObject.has("id")) {
                commonSceneCondition2.mGroupId = optJSONObject.optInt("id", -1);
                commonSceneCondition2.mGroupName = optJSONObject.optString("intro");
            }
            String str4 = "default_val";
            String str5 = "json_val_tag";
            String str6 = "show_tags";
            if (jSONObject2.has("attr")) {
                JSONObject optJSONObject2 = jSONObject2.optJSONObject("attr");
                int optInt = optJSONObject2.optInt("attr_id");
                if (optInt == 1001) {
                    SceneAttrNumberPicker sceneAttrNumberPicker = new SceneAttrNumberPicker();
                    sceneAttrNumberPicker.attrId = optInt;
                    JSONObject optJSONObject3 = optJSONObject2.optJSONObject("params");
                    CommonSceneCondition commonSceneCondition3 = commonSceneCondition2;
                    sceneAttrNumberPicker.maxValue = (float) optJSONObject3.optDouble("max_val");
                    sceneAttrNumberPicker.minValue = (float) optJSONObject3.optDouble("min_val");
                    sceneAttrNumberPicker.interval = (float) optJSONObject3.optDouble("interval");
                    sceneAttrNumberPicker.degree = optJSONObject3.optString("degree");
                    sceneAttrNumberPicker.jsonTag = optJSONObject3.optString(str5);
                    sceneAttrNumberPicker.subTitle = optJSONObject3.optString("display_sub_title");
                    sceneAttrNumberPicker.defaultValue = (float) optJSONObject3.optDouble(str4);
                    if (optJSONObject3.has(str6)) {
                        JSONArray optJSONArray = optJSONObject3.optJSONArray(str6);
                        int i = 0;
                        while (i < optJSONArray.length()) {
                            NumberPickerTag numberPickerTag = new NumberPickerTag();
                            numberPickerTag.from = (float) optJSONArray.optJSONObject(i).optDouble("from");
                            numberPickerTag.to = (float) optJSONArray.optJSONObject(i).optDouble("to");
                            numberPickerTag.tag = optJSONArray.optJSONObject(i).optString("tag");
                            sceneAttrNumberPicker.showTags.add(numberPickerTag);
                            i++;
                            str6 = str6;
                            str4 = str4;
                            str5 = str5;
                        }
                    }
                    str2 = str4;
                    str = str5;
                    str3 = str6;
                    commonSceneCondition = commonSceneCondition3;
                    commonSceneCondition.mAttr = sceneAttrNumberPicker;
                } else {
                    commonSceneCondition = commonSceneCondition2;
                    str2 = str4;
                    str = str5;
                    str3 = str6;
                    if (optInt == 1002) {
                        SceneAttrFencing sceneAttrFencing = new SceneAttrFencing();
                        sceneAttrFencing.attrId = optInt;
                        JSONObject optJSONObject4 = optJSONObject2.optJSONObject("params");
                        sceneAttrFencing.subTitle = optJSONObject4.optString("display_sub_title");
                        sceneAttrFencing.actName = optJSONObject4.optString("act_name");
                        sceneAttrFencing.radiusDegree = optJSONObject4.optString("radius_degree");
                        commonSceneCondition.mAttr = sceneAttrFencing;
                    }
                }
            } else {
                commonSceneCondition = commonSceneCondition2;
                str2 = str4;
                str = str5;
                str3 = str6;
            }
            JSONObject jSONObject3 = jSONObject;
            if (jSONObject3.has("attr_new")) {
                JSONObject optJSONObject5 = jSONObject3.optJSONObject("attr");
                int optInt2 = optJSONObject5.optInt("attr_id");
                if (optInt2 == 1001) {
                    SceneAttrNumberPicker sceneAttrNumberPicker2 = new SceneAttrNumberPicker();
                    sceneAttrNumberPicker2.attrId = optInt2;
                    JSONObject optJSONObject6 = optJSONObject5.optJSONObject("params");
                    sceneAttrNumberPicker2.maxValue = (float) optJSONObject6.optDouble("max_val");
                    sceneAttrNumberPicker2.minValue = (float) optJSONObject6.optDouble("min_val");
                    sceneAttrNumberPicker2.interval = (float) optJSONObject6.optDouble("interval");
                    sceneAttrNumberPicker2.degree = optJSONObject6.optString("degree");
                    sceneAttrNumberPicker2.jsonTag = optJSONObject6.optString(str);
                    sceneAttrNumberPicker2.subTitle = optJSONObject6.optString("display_sub_title");
                    sceneAttrNumberPicker2.defaultValue = (float) optJSONObject6.optDouble(str2);
                    String str7 = str3;
                    if (optJSONObject6.has(str7)) {
                        JSONArray optJSONArray2 = optJSONObject6.optJSONArray(str7);
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            NumberPickerTag numberPickerTag2 = new NumberPickerTag();
                            numberPickerTag2.from = (float) optJSONArray2.optJSONObject(i2).optDouble("from");
                            numberPickerTag2.to = (float) optJSONArray2.optJSONObject(i2).optDouble("to");
                            numberPickerTag2.tag = optJSONArray2.optJSONObject(i2).optString("tag");
                            sceneAttrNumberPicker2.showTags.add(numberPickerTag2);
                        }
                    }
                    commonSceneCondition.mAttr = sceneAttrNumberPicker2;
                } else if (optInt2 == 1002) {
                    SceneAttrFencing sceneAttrFencing2 = new SceneAttrFencing();
                    sceneAttrFencing2.attrId = optInt2;
                    JSONObject optJSONObject7 = optJSONObject5.optJSONObject("params");
                    sceneAttrFencing2.subTitle = optJSONObject7.optString("display_sub_title");
                    sceneAttrFencing2.actName = optJSONObject7.optString("act_name");
                    sceneAttrFencing2.radiusDegree = optJSONObject7.optString("radius_degree");
                    commonSceneCondition.mAttr = sceneAttrFencing2;
                }
            }
            return commonSceneCondition;
        }
    }

    public static class CommonSceneAction {
        public int id;
        public SceneAttr mAttr;
        public String mCommand;
        public int mCompatibleId;
        public int mGroupId = -1;
        public String mGroupName;
        public String mName;
        public String mParamAction;
        public Object mValue;

        public static CommonSceneAction parseFromJSON(JSONObject jSONObject) {
            JSONObject optJSONObject;
            int optInt;
            JSONObject optJSONObject2;
            CommonSceneAction commonSceneAction = new CommonSceneAction();
            commonSceneAction.mName = jSONObject.optString("name");
            commonSceneAction.id = jSONObject.optInt("sa_id");
            JSONObject optJSONObject3 = jSONObject.optJSONObject("payload");
            commonSceneAction.mCommand = optJSONObject3.optString("command");
            commonSceneAction.mValue = optJSONObject3.opt("value");
            commonSceneAction.mParamAction = optJSONObject3.optString("plug_id");
            commonSceneAction.mCompatibleId = jSONObject.optInt("tr_id");
            if (jSONObject.has("groupInfo") && (optJSONObject2 = jSONObject.optJSONObject("groupInfo")) != null && optJSONObject2.has("id")) {
                commonSceneAction.mGroupId = optJSONObject2.optInt("id", -1);
                commonSceneAction.mGroupName = optJSONObject2.optString("intro");
            }
            if (optJSONObject3.has("attr") && (optInt = (optJSONObject = optJSONObject3.optJSONObject("attr")).optInt("attr_id")) == 2001) {
                SceneAttrNumberPicker sceneAttrNumberPicker = new SceneAttrNumberPicker();
                sceneAttrNumberPicker.attrId = optInt;
                JSONObject optJSONObject4 = optJSONObject.optJSONObject("params");
                sceneAttrNumberPicker.maxValue = (float) optJSONObject4.optDouble("max_val");
                sceneAttrNumberPicker.minValue = (float) optJSONObject4.optDouble("min_val");
                sceneAttrNumberPicker.interval = (float) optJSONObject4.optDouble("interval");
                sceneAttrNumberPicker.degree = optJSONObject4.optString("degree");
                sceneAttrNumberPicker.jsonTag = optJSONObject4.optString("json_val_tag");
                sceneAttrNumberPicker.defaultValue = (float) optJSONObject4.optDouble("default_val");
                if (optJSONObject.has("show_tags")) {
                    JSONArray optJSONArray = optJSONObject.optJSONArray("show_tags");
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        NumberPickerTag numberPickerTag = new NumberPickerTag();
                        numberPickerTag.from = (float) optJSONArray.optJSONObject(i).optDouble("from");
                        numberPickerTag.to = (float) optJSONArray.optJSONObject(i).optDouble("to");
                        numberPickerTag.tag = optJSONArray.optJSONObject(i).optString("tag");
                        sceneAttrNumberPicker.showTags.add(numberPickerTag);
                    }
                }
                commonSceneAction.mAttr = sceneAttrNumberPicker;
            }
            return commonSceneAction;
        }
    }

    public static class RecommendBuy {
        public String model;
        public String url;

        public RecommendBuy(String str, String str2) {
            this.model = str;
            this.url = str2;
        }
    }

    public RecommendSceneItem getItemBy(String str) {
        List<RecommendSceneItem> list;
        if (TextUtils.isEmpty(str) || (list = this.mSceneItems) == null || list.size() <= 0) {
            return null;
        }
        for (RecommendSceneItem next : this.mSceneItems) {
            if (TextUtils.equals(str, next.sr_id)) {
                return next;
            }
        }
        return null;
    }
}
