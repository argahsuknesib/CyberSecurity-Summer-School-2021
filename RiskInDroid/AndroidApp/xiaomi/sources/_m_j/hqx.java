package _m_j;

import _m_j.gwu;
import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class hqx extends hqt {
    /* access modifiers changed from: package-private */
    public final String O000000o(SceneApi.O000000o o000000o) {
        return null;
    }

    public final boolean O000000o(PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition) {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final String O00000Oo(SceneApi.O000000o o000000o) {
        return null;
    }

    public final boolean O00000Oo(PluginRecommendSceneInfo.CommonSceneCondition commonSceneCondition) {
        return true;
    }

    public hqx(Context context, PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        super(context, recommendSceneItem);
    }

    public final String O00000Oo(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo == null || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() <= 0 || o000OOOo.O0000O0o.get(0).O0000OoO == null) {
            return "";
        }
        String str = o000OOOo.O0000O0o.get(0).O0000OoO.O00000oo;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.xiaomi.smarthome.scene.api.SceneApi$O000000o} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo) {
        Iterator<Map.Entry<String, List<SceneApi.O000000o>>> it = hpt.O000000o().O00000oO.entrySet().iterator();
        SceneApi.O000000o o000000o = null;
        List list = it.hasNext() ? (List) it.next().getValue() : null;
        if (list != null && !list.isEmpty()) {
            o000000o = list.get(0);
        }
        if (o000000o != null && ((Boolean) this.O00000oO.get(o000000o.O0000OoO.O00000o)).booleanValue()) {
            o000OOOo.O0000O0o.add(o000000o);
        }
        return o000OOOo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void
     arg types: [android.app.Activity, _m_j.hqx$1]
     candidates:
      _m_j.gwu.O000000o(android.content.Context, android.location.Address):_m_j.gwr
      _m_j.gwu.O000000o(java.util.Map<java.lang.String, java.lang.String>, java.lang.String):java.lang.String
      _m_j.gwu.O000000o(android.content.Context, _m_j.gwu$O000000o):void
      _m_j.gwu.O000000o(android.content.Context, java.lang.String):void
      _m_j.gwu.O000000o(android.app.Activity, _m_j.gwu$O000000o):void */
    public final void O00000oO(final SceneApi.O000OOOo o000OOOo) {
        if (this.O00000Oo instanceof Activity) {
            gwu.O000000o((Activity) this.O00000Oo, (gwu.O000000o) new gwu.O000000o() {
                /* class _m_j.hqx.AnonymousClass1 */

                public final void O000000o(String str, String str2) {
                    SceneApi.O000OOOo o000OOOo = o000OOOo;
                    if (o000OOOo != null) {
                        o000OOOo.O0000O0o.get(0).O0000OoO.O00000oo = str;
                        o000OOOo.O0000O0o.get(0).O0000OoO.O00000oO = str2;
                        SceneApi.O0000o00 o0000o00 = o000OOOo.O0000O0o.get(0).O0000OoO;
                        o0000o00.O0000O0o = str + " " + hpt.O000000o().f492O000000o.mConditionList.get(0).name;
                    }
                }

                public final void O000000o(Context context, Address address) {
                    gwr O000000o2 = gwu.O000000o(context, address);
                    SceneApi.O000OOOo o000OOOo = o000OOOo;
                    if (o000OOOo != null) {
                        o000OOOo.O0000O0o.get(0).O0000OoO.O00000oo = O000000o2.O00000oO;
                        o000OOOo.O0000O0o.get(0).O0000OoO.O00000oO = O000000o2.O00000oo;
                        SceneApi.O0000o00 o0000o00 = o000OOOo.O0000O0o.get(0).O0000OoO;
                        o0000o00.O0000O0o = O000000o2.O00000oO + " " + hpt.O000000o().f492O000000o.mConditionList.get(0).name;
                    }
                }
            });
        }
    }
}
