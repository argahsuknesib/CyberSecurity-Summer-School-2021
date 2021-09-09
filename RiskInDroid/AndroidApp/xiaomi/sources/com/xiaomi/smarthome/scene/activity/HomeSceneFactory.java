package com.xiaomi.smarthome.scene.activity;

import _m_j.hod;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import com.xiaomi.smarthome.scene.model.CorntabUtils;
import java.util.ArrayList;

public enum HomeSceneFactory {
    INSTANCE;

    public final SceneApi.O000000o createHomeDeviceCondition(Device device, RecommendSceneItem recommendSceneItem) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.O00000o0 = new SceneApi.O00000o0();
        o000000o.f11121O000000o = LAUNCH_TYPE.DEVICE;
        o000000o.O00000o0.O00000o = device.model;
        o000000o.O00000o0.f11122O000000o = device.did;
        o000000o.O00000o0.O00000o0 = device.name;
        String str = null;
        int i = 0;
        RecommendSceneItem.RemommendSceneCondition remommendSceneCondition = null;
        for (RecommendSceneItem.RemommendSceneCondition remommendSceneCondition2 : recommendSceneItem.mRecommendConditionList) {
            if (remommendSceneCondition2.mDeviceModels != null) {
                String[] strArr = remommendSceneCondition2.mDeviceModels;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    if (DeviceFactory.O0000O0o(device.model, strArr[i2])) {
                        remommendSceneCondition = remommendSceneCondition2;
                        break;
                    }
                    i2++;
                }
                if (remommendSceneCondition != null) {
                    break;
                }
            }
        }
        if (remommendSceneCondition == null) {
            return null;
        }
        o000000o.O00000o0.O00000Oo = remommendSceneCondition.mConditionName;
        o000000o.O0000o00 = true;
        String str2 = remommendSceneCondition.mKeys[0].mKey;
        ((SceneApi.O00000o0) o000000o.O00000o0).O0000Ooo = remommendSceneCondition.mKeys[0].mValues;
        String[] strArr2 = remommendSceneCondition.mDeviceModels;
        int length2 = strArr2.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            String str3 = strArr2[i];
            if (str2.contains(str3)) {
                str = str2.replace(str3, device.model);
                break;
            }
            i++;
        }
        o000000o.O00000o0.O0000Oo = str;
        return o000000o;
    }

    public final SceneApi.O000000o createPhoneCondition(RecommendSceneItem recommendSceneItem) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.O00000o = new SceneApi.O00oOooO();
        o000000o.O0000o00 = true;
        hod.O0000OoO();
        boolean O000000o2 = hod.O000000o(recommendSceneItem);
        if (recommendSceneItem != null) {
            RecommendSceneItem.RemommendSceneCondition[] remommendSceneConditionArr = recommendSceneItem.mRecommendConditionList;
            int length = remommendSceneConditionArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                RecommendSceneItem.RemommendSceneCondition remommendSceneCondition = remommendSceneConditionArr[i];
                if (!O000000o2 || !"come_home".equalsIgnoreCase(remommendSceneCondition.mKeys[0].mKey)) {
                    if (!O000000o2 && "leave_home".equalsIgnoreCase(remommendSceneCondition.mKeys[0].mKey)) {
                        o000000o.f11121O000000o = LAUNCH_TYPE.LEAVE_HOME;
                        o000000o.O00000o.f11133O000000o = "leave_home";
                        break;
                    }
                    i++;
                } else {
                    o000000o.O00000o.f11133O000000o = "come_home";
                    o000000o.f11121O000000o = LAUNCH_TYPE.COME_HOME;
                    break;
                }
            }
        }
        return o000000o;
    }

    public final SceneApi.O000000o createTimerCondition(CorntabUtils.CorntabParam corntabParam) {
        SceneApi.O000000o o000000o = new SceneApi.O000000o();
        o000000o.f11121O000000o = LAUNCH_TYPE.TIMER;
        o000000o.O00000Oo = new SceneApi.O0000o();
        o000000o.O00000Oo.f11124O000000o = corntabParam;
        o000000o.O0000o00 = true;
        return o000000o;
    }

    public final SceneApi.O0000o getDefaultGoHomeTimer() {
        SceneApi.O0000o o0000o = new SceneApi.O0000o();
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        corntabParam.O00000o0 = 18;
        corntabParam.O00000Oo = 0;
        corntabParam.O00000o = -1;
        corntabParam.O00000oO = -1;
        corntabParam.O000000o(127);
        o0000o.f11124O000000o = corntabParam;
        return o0000o;
    }

    public final SceneApi.O0000o getDefaultLeaveHomeTimer() {
        SceneApi.O0000o o0000o = new SceneApi.O0000o();
        CorntabUtils.CorntabParam corntabParam = new CorntabUtils.CorntabParam();
        corntabParam.O00000o0 = 8;
        corntabParam.O00000Oo = 0;
        corntabParam.O00000o = -1;
        corntabParam.O00000oO = -1;
        corntabParam.O000000o(127);
        return o0000o;
    }

    public final SceneApi.O000OOOo createDefaultGoHomeScene(Context context, RecommendSceneItem recommendSceneItem) {
        if (recommendSceneItem == null || recommendSceneItem.mRecommId != 151) {
            return null;
        }
        SceneApi.O000OOOo o000OOOo = new SceneApi.O000OOOo();
        o000OOOo.O00000o = recommendSceneItem.mRecommId;
        o000OOOo.O0000Oo = true;
        o000OOOo.O0000Oo0 = true;
        o000OOOo.O0000Ooo = 1;
        o000OOOo.O00000Oo = recommendSceneItem.mName;
        o000OOOo.O00000o0 = true;
        o000OOOo.O00000oo = new ArrayList();
        o000OOOo.O0000O0o = new ArrayList();
        o000OOOo.O0000oo0 = new SceneApi.O000OOOo.O000000o();
        o000OOOo.O0000oo0.O00000oo = null;
        o000OOOo.O0000oo0.O00000Oo = true;
        o000OOOo.O0000oo0.O00000o = 1;
        o000OOOo.O0000oo0.O00000oO = new ArrayList();
        o000OOOo.O0000oo0.O00000o0 = context.getString(R.string.scene2_device_group_condition_desc);
        o000OOOo.O00000o0 = true;
        o000OOOo.O0000OOo = true;
        return o000OOOo;
    }

    public final SceneApi.O000OOOo createDefaultLeaveHomeScene(Context context, RecommendSceneItem recommendSceneItem) {
        if (recommendSceneItem == null || recommendSceneItem.mRecommId != 152) {
            return null;
        }
        SceneApi.O000OOOo o000OOOo = new SceneApi.O000OOOo();
        o000OOOo.O00000o = recommendSceneItem.mRecommId;
        o000OOOo.O0000Oo = true;
        o000OOOo.O0000Oo0 = true;
        o000OOOo.O0000Ooo = 1;
        o000OOOo.O00000o0 = true;
        o000OOOo.O00000Oo = recommendSceneItem.mName;
        o000OOOo.O00000oo = new ArrayList();
        o000OOOo.O0000O0o = new ArrayList();
        o000OOOo.O0000oo0 = new SceneApi.O000OOOo.O000000o();
        o000OOOo.O0000oo0.O00000oo = null;
        o000OOOo.O0000oo0.O00000Oo = true;
        o000OOOo.O0000oo0.O00000o = 0;
        o000OOOo.O0000oo0.O00000oO = new ArrayList();
        o000OOOo.O0000oo0.O00000o0 = context.getString(R.string.scene2_device_group_condition_desc);
        o000OOOo.O00000o0 = true;
        o000OOOo.O0000OOo = true;
        return o000OOOo;
    }
}
