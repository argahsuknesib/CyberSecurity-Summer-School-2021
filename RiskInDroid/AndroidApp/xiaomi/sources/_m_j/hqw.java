package _m_j;

import _m_j.hpt;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class hqw extends hqv {
    public hqw(Context context, PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        super(context, recommendSceneItem);
    }

    public final void O000000o(BaseActivity baseActivity, SceneApi.O000OOOo o000OOOo, hpt.O000000o o000000o) {
        O000000o(baseActivity, o000OOOo.O00000oo.get(0), o000000o);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.xiaomi.smarthome.scene.api.SceneApi$Action} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo) {
        Iterator<Map.Entry<String, List<SceneApi.Action>>> it = hpt.O000000o().O00000oo.entrySet().iterator();
        SceneApi.Action action = null;
        List list = it.hasNext() ? (List) it.next().getValue() : null;
        if (list != null && !list.isEmpty()) {
            action = list.get(0);
        }
        if (action != null && ((Boolean) this.O00000oo.get(action.O00000oo)).booleanValue()) {
            o000OOOo.O00000oo.add(action);
        }
        return o000OOOo;
    }

    public final SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo, Device device) {
        List list;
        if (hpt.O000000o().O00000oO != null && hpt.O000000o().O00000oO.size() > 0) {
            int i = 0;
            String[] strArr = (String[]) hpt.O000000o().O00000oO.keySet().toArray(new String[0]);
            if (strArr.length > 0 && (list = hpt.O000000o().O00000oO.get(strArr[0])) != null && list.size() > 0) {
                while (true) {
                    if (i < list.size()) {
                        if (((SceneApi.O000000o) list.get(i)).O00000o0 != null && TextUtils.equals(((SceneApi.O000000o) list.get(i)).O00000o0.f11122O000000o, device.did)) {
                            o000OOOo.O0000O0o.add(list.get(i));
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        return o000OOOo;
    }

    public final String O00000Oo(SceneApi.O000OOOo o000OOOo) {
        SceneApi.O000OO00 o000oo00;
        Device O000000o2;
        if (o000OOOo == null || o000OOOo.O00000oo == null || o000OOOo.O00000oo.size() <= 0 || (o000oo00 = o000OOOo.O00000oo.get(0).O0000O0o) == null || (O000000o2 = fno.O000000o().O000000o(o000oo00.O00000o)) == null) {
            return null;
        }
        return TextUtils.isEmpty(O000000o2.name) ? "" : O000000o2.name;
    }
}
