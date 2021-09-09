package _m_j;

import _m_j.hpt;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity;
import com.xiaomi.smarthome.scene.activity.SceneNumberPicker;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class hqv {

    /* renamed from: O000000o  reason: collision with root package name */
    public PluginRecommendSceneInfo.RecommendSceneItem f539O000000o;
    Context O00000Oo;
    public boolean O00000o;
    public boolean O00000o0;
    public SparseArray<Boolean> O00000oO = new SparseArray<>();
    public SparseArray<Boolean> O00000oo = new SparseArray<>();

    public abstract SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo);

    public abstract SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo, Device device);

    public abstract void O000000o(BaseActivity baseActivity, SceneApi.O000OOOo o000OOOo, hpt.O000000o o000000o);

    public abstract String O00000Oo(SceneApi.O000OOOo o000OOOo);

    public void O00000oO(SceneApi.O000OOOo o000OOOo) {
    }

    public hqv(Context context, PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        this.O00000Oo = context;
        this.f539O000000o = recommendSceneItem;
        O00000Oo(recommendSceneItem);
        O00000o0(recommendSceneItem);
    }

    private void O00000Oo(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        if (recommendSceneItem.mCommonConditions != null) {
            for (Map.Entry next : recommendSceneItem.mCommonConditions.entrySet()) {
                if (!this.O00000o) {
                    this.O00000o = O000000o((PluginRecommendSceneInfo.CommonSceneCondition) next.getValue());
                }
                this.O00000oO.append(((Integer) next.getKey()).intValue(), Boolean.valueOf(O00000Oo((PluginRecommendSceneInfo.CommonSceneCondition) next.getValue())));
            }
        }
    }

    private void O00000o0(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        if (recommendSceneItem.mCommonActions != null) {
            for (Map.Entry next : recommendSceneItem.mCommonActions.entrySet()) {
                if (!this.O00000o0) {
                    this.O00000o0 = O000000o((PluginRecommendSceneInfo.CommonSceneAction) next.getValue(), hpt.O000000o().O0000OOo);
                }
                SparseArray<Boolean> sparseArray = this.O00000oo;
                int intValue = ((Integer) next.getKey()).intValue();
                PluginRecommendSceneInfo.CommonSceneAction commonSceneAction = (PluginRecommendSceneInfo.CommonSceneAction) next.getValue();
                boolean z = true;
                if (commonSceneAction == null || ((commonSceneAction.mAttr == null || (!(commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) && !(commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker))) && !TextUtils.isEmpty(commonSceneAction.mParamAction))) {
                    z = false;
                }
                sparseArray.append(intValue, Boolean.valueOf(z));
            }
        }
    }

    public static boolean O000000o(PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        if (!(recommendSceneItem == null || recommendSceneItem.mConditionList == null)) {
            for (int i = 0; i < recommendSceneItem.mConditionList.size(); i++) {
                Iterator<String> keys = recommendSceneItem.mConditionList.get(i).modelListJobj.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (recommendSceneItem.mConditionList.get(i).modelListJobj.optJSONArray(next) != null && recommendSceneItem.mConditionList.get(i).modelListJobj.optJSONArray(next).length() > 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean O000000o(PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition) {
        if (commonSceneCondition == null) {
            return false;
        }
        return (commonSceneCondition.mAttr != null && ((commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) || (commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker))) || !TextUtils.isEmpty(commonSceneCondition.mParamAction);
    }

    public boolean O00000Oo(PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition) {
        if (commonSceneCondition == null) {
            return false;
        }
        return (commonSceneCondition.mAttr != null && ((commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) || (commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker))) || TextUtils.isEmpty(commonSceneCondition.mParamAction);
    }

    public final boolean O00000o0(SceneApi.O000OOOo o000OOOo) {
        SceneApi.Action action;
        if (o000OOOo == null || o000OOOo.O00000oo == null || o000OOOo.O00000oo.size() < 0 || (action = o000OOOo.O00000oo.get(0)) == null || this.f539O000000o.mCommonActions == null) {
            return false;
        }
        return O000000o(this.f539O000000o.mCommonActions.get(Integer.valueOf(action.O00000oo)), o000OOOo);
    }

    public final boolean O00000o(SceneApi.O000OOOo o000OOOo) {
        SceneApi.O000000o o000000o;
        if (o000OOOo == null || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() < 0 || (o000000o = o000OOOo.O0000O0o.get(0)) == null || o000000o.O00000o0 == null || !(o000000o.O00000o0 instanceof SceneApi.O00000o0) || this.f539O000000o.mCommonConditions == null) {
            return false;
        }
        return O000000o(this.f539O000000o.mCommonConditions.get(Integer.valueOf(o000000o.O00000o0.O0000OoO)));
    }

    public static boolean O000000o(PluginRecommendSceneInfo.CommonSceneAction commonSceneAction, SceneApi.O000OOOo o000OOOo) {
        Device O000000o2;
        String str;
        if (commonSceneAction == null) {
            return false;
        }
        if (commonSceneAction.mAttr != null && ((commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) || (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker))) {
            return true;
        }
        if (!(o000OOOo == null || o000OOOo.O00000oo == null || o000OOOo.O00000oo.size() <= 0 || o000OOOo.O00000oo.get(0).O0000O0o == null)) {
            String str2 = o000OOOo.O00000oo.get(0).O0000O0o.O00000o;
            if (!TextUtils.isEmpty(str2) && (O000000o2 = fno.O000000o().O000000o(str2)) != null) {
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(O000000o2.model);
                if (O0000Oo == null) {
                    str = "";
                } else {
                    str = O0000Oo.O00000o();
                }
                List<String> O00000o02 = hsi.O00000o0(str);
                StringBuilder sb = new StringBuilder();
                sb.append(commonSceneAction.id);
                if (O00000o02.contains(sb.toString())) {
                    return true;
                }
            }
        }
        return !TextUtils.isEmpty(commonSceneAction.mParamAction);
    }

    public static SceneApi.Action O000000o(SceneApi.Action action) {
        if (action == null) {
            return null;
        }
        PluginRecommendSceneInfo.CommonSceneAction commonSceneAction = hpt.O000000o().f492O000000o.mCommonActions.get(Integer.valueOf(action.O00000oo));
        if (commonSceneAction.mAttr != null && (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
            float f = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr).defaultValue;
            String str = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr).jsonTag;
            String str2 = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr).subTitle;
            Object valueOf = Float.valueOf(f);
            int i = (int) f;
            if (((double) Math.abs(((float) i) - f)) < 1.0E-4d) {
                valueOf = Integer.valueOf(i);
            }
            if (TextUtils.isEmpty(str)) {
                action.O0000O0o.O00000oO = valueOf;
            } else if (str.equals("equal")) {
                action.O0000O0o.O00000oO = valueOf;
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (str.equals("max")) {
                        jSONObject.put("min", valueOf);
                        jSONObject.put("max", (double) ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr).maxValue);
                    } else {
                        jSONObject.put("min", (double) ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr).minValue);
                        jSONObject.put("max", valueOf);
                    }
                    action.O0000O0o.O00000oO = jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    action.O00000Oo = String.format(str2, valueOf);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    action.O00000Oo = String.valueOf(valueOf);
                }
            }
        }
        return action;
    }

    public static SceneApi.O000000o O00000o0(SceneApi.O000000o o000000o) {
        if (o000000o == null) {
            return null;
        }
        PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition = hpt.O000000o().f492O000000o.mCommonConditions.get(Integer.valueOf(o000000o.O00000o0.O0000OoO));
        if (commonSceneCondition.mAttr != null && (commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
            float f = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr).defaultValue;
            String str = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr).jsonTag;
            String str2 = ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr).subTitle;
            Object valueOf = Float.valueOf(f);
            int i = (int) f;
            if (((double) Math.abs(((float) i) - f)) < 1.0E-4d) {
                valueOf = Integer.valueOf(i);
            }
            if (TextUtils.isEmpty(str)) {
                ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo = valueOf;
            } else if (str.equals("equal")) {
                ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo = valueOf;
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    if (str.equals("max")) {
                        jSONObject.put("min", valueOf);
                        jSONObject.put("max", (double) ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr).maxValue);
                    } else {
                        jSONObject.put("min", (double) ((PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr).minValue);
                        jSONObject.put("max", valueOf);
                    }
                    ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo = jSONObject;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    o000000o.O00000o0.O00000Oo = String.format(str2, valueOf);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    o000000o.O00000o0.O00000Oo = String.valueOf(valueOf);
                }
            }
        }
        return o000000o;
    }

    public String O00000Oo(SceneApi.O000000o o000000o) {
        if (o000000o == null || this.f539O000000o.mCommonConditions == null || o000000o.O00000o0 == null || !(o000000o.O00000o0 instanceof SceneApi.O00000o0)) {
            return null;
        }
        SceneApi.O00000o0 o00000o0 = (SceneApi.O00000o0) o000000o.O00000o0;
        PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition = this.f539O000000o.mCommonConditions.get(Integer.valueOf(o00000o0.O0000OoO));
        if (commonSceneCondition == null || !O000000o(commonSceneCondition) || o00000o0.O0000Ooo == null) {
            return null;
        }
        Object obj = o00000o0.O0000Ooo;
        if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            if (commonSceneCondition.mAttr != null && (commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
                PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr;
                if ("min".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                    String optString = jSONObject.optString("max");
                    if (TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                        return optString;
                    }
                    return optString + sceneAttrNumberPicker.degree;
                } else if ("max".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                    String optString2 = jSONObject.optString("min");
                    if (TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                        return optString2;
                    }
                    return optString2 + sceneAttrNumberPicker.degree;
                } else if (!"equals".equalsIgnoreCase(sceneAttrNumberPicker.jsonTag)) {
                    return null;
                } else {
                    String optString3 = jSONObject.optString("equals");
                    if (TextUtils.isEmpty(sceneAttrNumberPicker.degree)) {
                        return optString3;
                    }
                    return optString3 + sceneAttrNumberPicker.degree;
                }
            } else if (!jSONObject.has("text") || TextUtils.isEmpty(jSONObject.optString("text"))) {
                return null;
            } else {
                return jSONObject.optString("text");
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            if (jSONArray == null || jSONArray.length() <= 0) {
                return null;
            }
            return jSONArray.optString(0);
        } else if (!(obj instanceof String)) {
            return null;
        } else {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (commonSceneCondition.mAttr == null || !(commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
                return str;
            }
            PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker2 = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition.mAttr;
            if (TextUtils.isEmpty(sceneAttrNumberPicker2.degree)) {
                return str;
            }
            return str + sceneAttrNumberPicker2.degree;
        }
    }

    public String O000000o(SceneApi.O000000o o000000o) {
        SceneApi.O00000o0 o00000o0;
        PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition;
        if (o000000o == null || o000000o.O00000o0 == null || !(o000000o.O00000o0 instanceof SceneApi.O00000o0) || (o00000o0 = (SceneApi.O00000o0) o000000o.O00000o0) == null || this.f539O000000o.mCommonConditions == null || (commonSceneCondition = this.f539O000000o.mCommonConditions.get(Integer.valueOf(o00000o0.O0000OoO))) == null || !O000000o(commonSceneCondition)) {
            return null;
        }
        if (commonSceneCondition.mAttr == null || !(commonSceneCondition.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker)) {
            if (!TextUtils.isEmpty(commonSceneCondition.mParamAction)) {
                return o000000o.O00000o0.O00000Oo;
            }
            return null;
        } else if (!TextUtils.isEmpty(this.f539O000000o.selectValueHint)) {
            return this.f539O000000o.selectValueHint;
        } else {
            if (!TextUtils.isEmpty(commonSceneCondition.mName)) {
                return commonSceneCondition.mName;
            }
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0126, code lost:
        if (android.text.TextUtils.equals("action_tts", r1.optString("text")) != false) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x013b, code lost:
        if (android.text.TextUtils.equals("action_tts", (java.lang.String) r8.O0000O0o.O00000oO) != false) goto L_0x013d;
     */
    public final void O000000o(BaseActivity baseActivity, SceneApi.Action action, hpt.O000000o o000000o) {
        String str;
        PluginRecommendSceneInfo.CommonSceneAction commonSceneAction = this.f539O000000o.mCommonActions.get(Integer.valueOf(action.O00000oo));
        if (commonSceneAction != null) {
            if (commonSceneAction.mAttr == null) {
                if (action != null && !TextUtils.isEmpty(action.O00000oO)) {
                    PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(action.O00000oO);
                    if (O0000Oo == null) {
                        str = "";
                    } else {
                        str = O0000Oo.O00000o();
                    }
                    List<String> O00000o02 = hsi.O00000o0(str);
                    StringBuilder sb = new StringBuilder();
                    sb.append(action.O00000oo);
                    if (O00000o02.contains(sb.toString()) && action.O0000O0o != null && !TextUtils.isEmpty(action.O0000O0o.O00000o)) {
                        hpt.O000000o().O000000o(baseActivity, action, ((SceneApi.O000OO0o) action.O0000O0o).O00000oO, o000000o);
                        return;
                    }
                }
                if (!TextUtils.isEmpty(commonSceneAction.mParamAction)) {
                    Object obj = action.O0000O0o.O00000oO;
                    if (action.O0000O0o.O00000oO instanceof JSONObject) {
                        JSONObject jSONObject = (JSONObject) action.O0000O0o.O00000oO;
                        if (jSONObject.has("text")) {
                            if (!TextUtils.isEmpty(jSONObject.optString("text"))) {
                            }
                        }
                        hpt.O000000o().O000000o(baseActivity, action, obj, o000000o);
                    }
                    if (action.O0000O0o.O00000oO instanceof String) {
                    }
                    hpt.O000000o().O000000o(baseActivity, action, obj, o000000o);
                    obj = null;
                    hpt.O000000o().O000000o(baseActivity, action, obj, o000000o);
                }
            } else if (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker) {
                PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneAction.mAttr;
                Intent intent = new Intent(baseActivity, SceneNumberPicker.class);
                intent.putExtra("max_value", sceneAttrNumberPicker.maxValue);
                intent.putExtra("min_value", sceneAttrNumberPicker.minValue);
                intent.putExtra("interval", sceneAttrNumberPicker.interval);
                intent.putExtra("degree", sceneAttrNumberPicker.degree);
                intent.putExtra("json_tag", sceneAttrNumberPicker.jsonTag);
                intent.putExtra("show_tags", sceneAttrNumberPicker.showTags);
                intent.putExtra("default_value", sceneAttrNumberPicker.defaultValue);
                if (TextUtils.isEmpty(this.f539O000000o.selectValueHint)) {
                    intent.putExtra("title", commonSceneAction.mName);
                } else {
                    intent.putExtra("title", this.f539O000000o.selectValueHint);
                }
                intent.putExtra("formatter", sceneAttrNumberPicker.subTitle);
                if (action != null) {
                    intent.putExtra("last_value", String.valueOf(((SceneApi.O000OO0o) action.O0000O0o).O00000oO));
                }
                baseActivity.startActivityForResult(intent, 103);
            } else if (commonSceneAction.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) {
                O000000o(baseActivity, (PluginRecommendSceneInfo.SceneAttrFencing) commonSceneAction.mAttr);
            }
        }
    }

    private static void O000000o(BaseActivity baseActivity, PluginRecommendSceneInfo.SceneAttrFencing sceneAttrFencing) {
        ExternalLoadManager.instance.loadExternal("amap2d", new fkv(sceneAttrFencing) {
            /* class _m_j.$$Lambda$hqv$zeEMgi9l2MELntjCcRJNjRUR46I */
            private final /* synthetic */ PluginRecommendSceneInfo.SceneAttrFencing f$1;

            {
                this.f$1 = r2;
            }

            public final Object call(Object obj) {
                return hqv.O000000o(BaseActivity.this, this.f$1, (ExternalLoadManager.O000000o) obj);
            }
        });
    }

    public void O000000o(BaseActivity baseActivity, SceneApi.O000000o o000000o, hpt.O000000o o000000o2) {
        PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition;
        PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition2 = this.f539O000000o.mCommonConditions.get(Integer.valueOf(o000000o.O00000o0.O0000OoO));
        if (commonSceneCondition2 != null) {
            if (commonSceneCondition2.mAttr != null) {
                if (commonSceneCondition2.mAttr instanceof PluginRecommendSceneInfo.SceneAttrNumberPicker) {
                    PluginRecommendSceneInfo.SceneAttrNumberPicker sceneAttrNumberPicker = (PluginRecommendSceneInfo.SceneAttrNumberPicker) commonSceneCondition2.mAttr;
                    Intent intent = new Intent(baseActivity, SceneNumberPicker.class);
                    intent.putExtra("max_value", sceneAttrNumberPicker.maxValue);
                    intent.putExtra("min_value", sceneAttrNumberPicker.minValue);
                    intent.putExtra("interval", sceneAttrNumberPicker.interval);
                    intent.putExtra("degree", sceneAttrNumberPicker.degree);
                    intent.putExtra("json_tag", sceneAttrNumberPicker.jsonTag);
                    intent.putExtra("show_tags", sceneAttrNumberPicker.showTags);
                    intent.putExtra("default_value", sceneAttrNumberPicker.defaultValue);
                    if (TextUtils.isEmpty(this.f539O000000o.selectValueHint)) {
                        intent.putExtra("title", commonSceneCondition2.mName);
                    } else {
                        intent.putExtra("title", this.f539O000000o.selectValueHint);
                    }
                    intent.putExtra("formatter", sceneAttrNumberPicker.subTitle);
                    if (o000000o != null) {
                        intent.putExtra("last_value", String.valueOf(((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo));
                    }
                    baseActivity.startActivityForResult(intent, 103);
                } else if (commonSceneCondition2.mAttr instanceof PluginRecommendSceneInfo.SceneAttrFencing) {
                    O000000o(baseActivity, (PluginRecommendSceneInfo.SceneAttrFencing) commonSceneCondition2.mAttr);
                }
            } else if (!TextUtils.isEmpty(commonSceneCondition2.mParamAction)) {
                hpt O000000o2 = hpt.O000000o();
                if (O000000o2.f492O000000o.mCommonConditions != null && (commonSceneCondition = O000000o2.f492O000000o.mCommonConditions.get(Integer.valueOf(o000000o.O00000o0.O0000OoO))) != null) {
                    Intent intent2 = new Intent(commonSceneCondition.mParamAction);
                    intent2.putExtra("action", commonSceneCondition.mKey);
                    intent2.putExtra("value", String.valueOf(commonSceneCondition.mValue));
                    intent2.putExtra("actionId", commonSceneCondition.id);
                    intent2.putExtra("name", commonSceneCondition.mName);
                    intent2.putExtra("plug_id", commonSceneCondition.mParamAction);
                    StringBuilder sb = new StringBuilder();
                    sb.append(commonSceneCondition.mCompatibleId);
                    intent2.putExtra("tr_id", sb.toString());
                    intent2.putExtra("scene_type", 1);
                    ServiceApplication.getGlobalHandler().post(new Runnable(baseActivity, o000000o, intent2, o000000o2) {
                        /* class _m_j.hpt.AnonymousClass7 */

                        /* renamed from: O000000o */
                        final /* synthetic */ BaseActivity f500O000000o;
                        final /* synthetic */ SceneApi.O000000o O00000Oo;
                        final /* synthetic */ O000000o O00000o;
                        final /* synthetic */ Intent O00000o0;

                        {
                            this.f500O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                            this.O00000o = r5;
                        }

                        public final void run() {
                            hpt.this.O000000o(this.f500O000000o, fno.O000000o().O000000o(this.O00000Oo.O00000o0.f11122O000000o), this.O00000o0, this.O00000o);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Integer O000000o(BaseActivity baseActivity, PluginRecommendSceneInfo.SceneAttrFencing sceneAttrFencing, ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            Intent intent = new Intent(baseActivity, AmapGeofencingActivity.class);
            intent.putExtra("extra_data_latitude", (double) sceneAttrFencing.latitude);
            intent.putExtra("extra_data_longitude", (double) sceneAttrFencing.longitude);
            intent.putExtra("extra_data_radius", sceneAttrFencing.radius);
            intent.putExtra("extra_data_sub_title", sceneAttrFencing.subTitle);
            intent.putExtra("extra_data_act_name", sceneAttrFencing.actName);
            intent.putExtra("extra_data_radius_degree", sceneAttrFencing.radiusDegree);
            baseActivity.startActivityForResult(intent, 104);
        } else if (o000000o.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
