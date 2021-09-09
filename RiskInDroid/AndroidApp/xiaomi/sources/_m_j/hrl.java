package _m_j;

import android.text.TextUtils;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class hrl {
    private static hrl O0000Oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f564O000000o = new O000000o();
    public O00000o O00000Oo = new O00000o();
    public Set<String> O00000o = new HashSet();
    public Set<String> O00000o0 = new HashSet();
    public List<hos> O00000oO = new ArrayList();
    public List<hnm> O00000oo = new ArrayList();
    public List<SceneApi.O000OOOo> O0000O0o;
    public O00000o0 O0000OOo = new O00000o0();
    private DeviceTagInterface O0000Oo = fnn.O000000o().O00000Oo();

    public static hrl O000000o() {
        if (O0000Oo0 == null) {
            O0000Oo0 = new hrl();
        }
        return O0000Oo0;
    }

    public final void O000000o(int i, int i2, String str, int i3) {
        O000000o o000000o = this.f564O000000o;
        o000000o.O00000Oo = i2;
        o000000o.O00000o0 = str;
        o000000o.f565O000000o = i;
        o000000o.O00000o = i3;
    }

    public final void O00000Oo(int i, int i2, String str, int i3) {
        O00000o o00000o = this.O00000Oo;
        o00000o.O00000Oo = i2;
        o00000o.O00000o0 = str;
        o00000o.f567O000000o = i;
        o00000o.O00000o = i3;
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f565O000000o = 2;
        public int O00000Oo = 0;
        public int O00000o;
        public String O00000o0 = ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all);

        public O000000o() {
        }
    }

    public class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f567O000000o = 2;
        public int O00000Oo = 0;
        public int O00000o;
        public String O00000o0 = ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all);

        public O00000o() {
        }
    }

    public class O00000o0 {
        public O00000o0() {
        }
    }

    public final List<O00000Oo> O000000o(Map<String, Set<String>> map, int i) {
        if (map == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (String obj : map.keySet()) {
            O00000Oo o00000Oo = new O00000Oo();
            String obj2 = obj.toString();
            if (i == 1) {
                o00000Oo.f566O000000o = obj2;
                o00000Oo.O00000Oo = O000000o(obj2, map);
                arrayList.add(o00000Oo);
            } else if (i == 2) {
                o00000Oo.f566O000000o = obj2;
                o00000Oo.O00000Oo = O00000Oo(obj2, map);
                arrayList.add(o00000Oo);
            } else if (i == 3) {
                o00000Oo.f566O000000o = obj2;
                o00000Oo.O00000Oo = O00000o0(obj2, map);
                arrayList.add(o00000Oo);
            }
        }
        O00000Oo o00000Oo2 = new O00000Oo();
        o00000Oo2.f566O000000o = ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all);
        if (i == 1) {
            o00000Oo2.O00000Oo = O000000o(o00000Oo2.f566O000000o, map);
        } else if (i == 2) {
            o00000Oo2.O00000Oo = O00000Oo(o00000Oo2.f566O000000o, map);
        } else if (i == 3) {
            o00000Oo2.O00000Oo = O00000o0(o00000Oo2.f566O000000o, map);
        }
        arrayList.add(0, o00000Oo2);
        return arrayList;
    }

    private int O000000o(String str, Map<String, Set<String>> map) {
        if (str.equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all))) {
            return this.O00000oO.size();
        }
        Set set = map.get(str);
        int i = 0;
        for (hos next : this.O00000oO) {
            if (!(next instanceof hox)) {
                i++;
            } else {
                CommonSceneOnline commonSceneOnline = ((hox) next).O00000o;
                if (commonSceneOnline != null) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (commonSceneOnline.O00000Oo.equalsIgnoreCase((String) it.next())) {
                            break;
                        }
                    }
                }
            }
        }
        return i;
    }

    private int O00000Oo(String str, Map<String, Set<String>> map) {
        if (str.equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all))) {
            return this.O00000oo.size();
        }
        Set set = map.get(str);
        int i = 0;
        for (hnm next : this.O00000oo) {
            if (!(next instanceof hnq)) {
                i++;
            } else {
                CommonSceneOnline commonSceneOnline = ((hnq) next).O00000oO;
                if (commonSceneOnline != null) {
                    Iterator it = set.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (commonSceneOnline.O00000Oo.equalsIgnoreCase((String) it.next())) {
                            break;
                        }
                    }
                }
            }
        }
        return i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x004f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f0 A[EDGE_INSN: B:62:0x00f0->B:54:0x00f0 ?: BREAK  , SYNTHETIC] */
    private int O00000o0(String str, Map<String, Set<String>> map) {
        boolean z;
        boolean z2;
        List<SceneApi.O000OOOo> list = this.O0000O0o;
        if (list == null || list.size() == 0) {
            return 0;
        }
        if (str.equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all))) {
            return this.O0000O0o.size();
        }
        if (str.equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.smarthome_scene_all))) {
            return this.O0000O0o.size();
        }
        Set set = map.get(str);
        int i = 0;
        for (SceneApi.O000OOOo next : this.O0000O0o) {
            boolean z3 = true;
            if (next != null) {
                Iterator<SceneApi.O000000o> it = next.O0000O0o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<SceneApi.Action> it2 = next.O00000oo.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            SceneApi.Action next2 = it2.next();
                            if (next2.f11120O000000o != 1 && next2.f11120O000000o != 2 && next2.O0000O0o != null && !TextUtils.isEmpty(next2.O0000O0o.O00000o)) {
                                Iterator it3 = set.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        break;
                                    }
                                    if (next2.O0000O0o.O00000o.equalsIgnoreCase((String) it3.next())) {
                                        z = true;
                                        continue;
                                        break;
                                    }
                                }
                            }
                            z = false;
                            continue;
                            if (z) {
                                break;
                            }
                        }
                    } else {
                        SceneApi.O000000o next3 = it.next();
                        if (next3.f11121O000000o == LAUNCH_TYPE.DEVICE && next3.O00000o0 != null) {
                            Iterator it4 = set.iterator();
                            while (true) {
                                if (!it4.hasNext()) {
                                    break;
                                }
                                String str2 = (String) it4.next();
                                if (!TextUtils.isEmpty(next3.O00000o0.f11122O000000o) && next3.O00000o0.f11122O000000o.equalsIgnoreCase(str2)) {
                                    z2 = true;
                                    continue;
                                    break;
                                }
                            }
                            if (z2) {
                                break;
                            }
                        }
                        z2 = false;
                        continue;
                        if (z2) {
                        }
                    }
                }
                if (!z3) {
                    i++;
                }
            }
            z3 = false;
            if (!z3) {
            }
        }
        return i;
    }

    public final boolean O000000o(int i, int i2, String str) {
        List<O00000Oo> O000000o2 = O000000o().O000000o(this.O0000Oo.O000000o(i), 1);
        if (O000000o2.size() == 0) {
            return false;
        }
        for (O00000Oo o00000Oo : O000000o2) {
            if (o00000Oo.f566O000000o.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public final void O000000o(TextView textView) {
        if (O000000o().f564O000000o.O00000Oo == 0) {
            textView.setText((int) R.string.smarthome_scene_start_condition);
            return;
        }
        O000000o();
        if (!O000000o().O000000o(O000000o().f564O000000o.f565O000000o, 1, O000000o().f564O000000o.O00000o0)) {
            textView.setText((int) R.string.smarthome_scene_start_condition);
            return;
        }
        int O000000o2 = O000000o().O000000o(this.f564O000000o.O00000o0, fnn.O000000o().O00000Oo().O000000o(this.f564O000000o.f565O000000o));
        if (O000000o().f564O000000o.f565O000000o == 2) {
            textView.setText(O000000o(fnn.O000000o().O00000Oo().O0000OoO(this.f564O000000o.O00000o0), O000000o2));
        } else {
            textView.setText(O000000o(this.f564O000000o.O00000o0, O000000o2));
        }
    }

    private static String O000000o(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 12) {
            sb.append(str);
        } else {
            sb.append(str.substring(0, 9));
            sb.append("...");
        }
        sb.append("(");
        sb.append(i);
        sb.append(")");
        return sb.toString();
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f566O000000o;
        public int O00000Oo;

        O00000Oo() {
        }
    }
}
