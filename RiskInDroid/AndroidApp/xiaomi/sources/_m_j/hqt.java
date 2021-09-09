package _m_j;

import _m_j.hpt;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class hqt extends hqv {
    public hqt(Context context, PluginRecommendSceneInfo.RecommendSceneItem recommendSceneItem) {
        super(context, recommendSceneItem);
    }

    public final void O000000o(BaseActivity baseActivity, SceneApi.O000OOOo o000OOOo, hpt.O000000o o000000o) {
        O000000o(baseActivity, o000OOOo.O0000O0o.get(0), o000000o);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.xiaomi.smarthome.scene.api.SceneApi$O000000o} */
    /* JADX WARNING: Multi-variable type inference failed */
    public SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo) {
        Iterator<Map.Entry<String, List<SceneApi.O000000o>>> it = hpt.O000000o().O00000oO.entrySet().iterator();
        SceneApi.O000000o o000000o = null;
        List list = it.hasNext() ? (List) it.next().getValue() : null;
        if (list != null && !list.isEmpty()) {
            o000000o = list.get(0);
        }
        if (o000000o != null && ((Boolean) this.O00000oO.get(o000000o.O00000o0.O0000OoO)).booleanValue()) {
            o000OOOo.O0000O0o.add(o000000o);
        }
        return o000OOOo;
    }

    public final SceneApi.O000OOOo O000000o(SceneApi.O000OOOo o000OOOo, Device device) {
        if (hpt.O000000o().O00000oo != null && hpt.O000000o().O00000oo.size() > 0) {
            int i = 0;
            String[] strArr = (String[]) hpt.O000000o().O00000oo.keySet().toArray(new String[0]);
            if (strArr.length > 0) {
                ArrayList arrayList = new ArrayList();
                for (String str : strArr) {
                    arrayList.addAll(hpt.O000000o().O00000oo.get(str));
                }
                if (arrayList.size() > 0) {
                    while (true) {
                        if (i < arrayList.size()) {
                            if (((SceneApi.Action) arrayList.get(i)).O0000O0o != null && TextUtils.equals(((SceneApi.Action) arrayList.get(i)).O0000O0o.O00000o, device.did)) {
                                o000OOOo.O00000oo.add(arrayList.get(i));
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return o000OOOo;
    }

    public String O00000Oo(SceneApi.O000OOOo o000OOOo) {
        SceneApi.O00000Oo o00000Oo;
        Device O000000o2;
        if (o000OOOo == null || o000OOOo.O0000O0o == null || o000OOOo.O0000O0o.size() <= 0 || (o00000Oo = o000OOOo.O0000O0o.get(0).O00000o0) == null || (O000000o2 = fno.O000000o().O000000o(o00000Oo.f11122O000000o)) == null) {
            return null;
        }
        return TextUtils.isEmpty(O000000o2.name) ? "" : O000000o2.name;
    }
}
