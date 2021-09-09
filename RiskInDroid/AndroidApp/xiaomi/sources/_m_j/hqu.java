package _m_j;

import _m_j.hpt;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDetailSelectActivity;

public final class hqu extends hqt {
    public final boolean O000000o(PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition) {
        return true;
    }

    public hqu(Context context, PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        super(context, recommendSceneItem);
    }

    /* access modifiers changed from: package-private */
    public final String O000000o(SceneApi.O000000o o000000o) {
        return (o000000o == null || o000000o.O00000o0 == null || !(o000000o.O00000o0 instanceof SceneApi.O00000o0) || TextUtils.isEmpty(this.f539O000000o.selectValueHint)) ? "Hint" : this.f539O000000o.selectValueHint;
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo(SceneApi.O000000o o000000o) {
        return (o000000o == null || o000000o.O00000o0 == null || TextUtils.isEmpty(o000000o.O00000o0.O00000Oo)) ? "" : o000000o.O00000o0.O00000Oo;
    }

    public final void O000000o(BaseActivity baseActivity, SceneApi.O000000o o000000o, hpt.O000000o o000000o2) {
        Intent intent = new Intent(baseActivity, ActionConditionDetailSelectActivity.class);
        if (o000000o.O00000o0 != null) {
            intent.putExtra("did", o000000o.O00000o0.f11122O000000o);
        }
        intent.putExtra("need_condition", this.f539O000000o.isActionDevice);
        intent.putExtra("need_action", this.f539O000000o.isConditionDevice);
        baseActivity.startActivityForResult(intent, 1004);
    }
}
