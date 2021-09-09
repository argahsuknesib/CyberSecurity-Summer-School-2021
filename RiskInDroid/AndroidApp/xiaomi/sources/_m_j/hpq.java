package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.activity.CommonSceneOnline;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.bean.LAUNCH_TYPE;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class hpq {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f480O000000o = 30;
    private static hpq O0000o0O;
    public SceneApi.O000OOOo O00000Oo;
    public hnm O00000o;
    public hos O00000o0;
    public SceneApi.O000000o O00000oO;
    public SceneApi.Action O00000oo;
    public boolean O0000O0o = true;
    public List<Integer> O0000OOo;
    public Room O0000Oo;
    public int O0000Oo0;
    public hpc O0000OoO;
    public Map<String, Set<Integer>> O0000Ooo = new HashMap();
    private boolean O0000o = true;
    public String O0000o0 = null;
    public Map<String, Set<Integer>> O0000o00 = new HashMap();
    private List<Integer> O0000o0o;

    public static hpq O000000o() {
        if (O0000o0O == null) {
            O0000o0O = new hpq();
        }
        return O0000o0O;
    }

    public final void O000000o(SceneApi.O000OOOo o000OOOo) {
        this.O00000Oo = null;
        this.O00000Oo = o000OOOo;
        this.O0000Ooo.clear();
        this.O0000o00.clear();
        if (o000OOOo != null) {
            O00000Oo(o000OOOo);
            O00000o0(o000OOOo);
        }
    }

    public final boolean O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.O0000Ooo.containsKey(str);
    }

    public final boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.O0000o00.containsKey(str);
    }

    public final void O00000Oo(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo == null) {
            this.O0000Ooo.clear();
        } else if (o000OOOo.O0000O0o.isEmpty()) {
            this.O0000Ooo.clear();
        } else {
            for (int i = 0; i < o000OOOo.O0000O0o.size(); i++) {
                SceneApi.O000000o o000000o = o000OOOo.O0000O0o.get(i);
                if (o000000o.O00000o0 != null && !TextUtils.isEmpty(o000000o.O00000o0.f11122O000000o) && o000000o.O00000o0.O0000OoO > 0) {
                    if (!this.O0000Ooo.containsKey(o000000o.O00000o0.f11122O000000o)) {
                        this.O0000Ooo.put(o000000o.O00000o0.f11122O000000o, new HashSet());
                    }
                    Object obj = this.O0000Ooo.get(o000000o.O00000o0.f11122O000000o);
                    if (obj == null) {
                        obj = new HashSet();
                    }
                    obj.add(Integer.valueOf(o000000o.O00000o0.O0000OoO));
                }
            }
        }
    }

    public final void O000000o(SceneApi.O000000o o000000o) {
        if (o000000o != null && o000000o.O00000o0 != null && !TextUtils.isEmpty(o000000o.O00000o0.f11122O000000o) && o000000o.O00000o0.O0000OoO > 0) {
            if (!this.O0000Ooo.containsKey(o000000o.O00000o0.f11122O000000o)) {
                this.O0000Ooo.put(o000000o.O00000o0.f11122O000000o, new HashSet());
            }
            Object obj = this.O0000o00.get(o000000o.O00000o0.f11122O000000o);
            if (obj == null) {
                obj = new HashSet();
            }
            obj.add(Integer.valueOf(o000000o.O00000o0.O0000OoO));
        }
    }

    public final void O00000o0(SceneApi.O000OOOo o000OOOo) {
        if (o000OOOo == null) {
            this.O0000o00.clear();
        } else if (o000OOOo.O00000oo.isEmpty()) {
            this.O0000o00.clear();
        } else {
            for (int i = 0; i < o000OOOo.O00000oo.size(); i++) {
                SceneApi.Action action = o000OOOo.O00000oo.get(i);
                if (action.O0000O0o != null && !TextUtils.isEmpty(action.O0000O0o.O00000o) && action.O00000oo > 0) {
                    if (!this.O0000o00.containsKey(action.O0000O0o.O00000o)) {
                        this.O0000o00.put(action.O0000O0o.O00000o, new HashSet());
                    }
                    Object obj = this.O0000o00.get(action.O0000O0o.O00000o);
                    if (obj == null) {
                        obj = new HashSet();
                    }
                    obj.add(Integer.valueOf(action.O00000oo));
                }
            }
        }
    }

    public final void O000000o(SceneApi.Action action) {
        if (action != null && action.O0000O0o != null && !TextUtils.isEmpty(action.O0000O0o.O00000o) && action.O00000oo > 0) {
            if (!this.O0000o00.containsKey(action.O0000O0o.O00000o)) {
                this.O0000o00.put(action.O0000O0o.O00000o, new HashSet());
            }
            this.O0000o00.get(action.O0000O0o.O00000o).add(Integer.valueOf(action.O00000oo));
        }
    }

    public final void O00000o(SceneApi.O000OOOo o000OOOo) {
        CommonSceneOnline O00000Oo2;
        CommonSceneOnline O00000Oo3;
        gsy.O00000o0(LogType.SCENE, "scene", "--------------resetRules------------------");
        this.O0000o0o = null;
        this.O0000OOo = null;
        this.O00000Oo = o000OOOo;
        this.O0000O0o = true;
        for (int i = 0; i < this.O00000Oo.O0000O0o.size(); i++) {
            SceneApi.O000000o o000000o = this.O00000Oo.O0000O0o.get(i);
            if (o000000o.O0000Ooo != 0) {
                if (O000000o(Integer.valueOf(o000000o.O0000Ooo))) {
                    O000000o(hod.O0000OoO().O000000o(o000000o.O0000Ooo));
                    O00000Oo(hod.O0000OoO().O00000Oo(o000000o.O0000Ooo));
                } else {
                    this.O0000o0o.clear();
                    this.O0000O0o = false;
                }
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.CLICK || o000000o.f11121O000000o == LAUNCH_TYPE.TIMER || o000000o.f11121O000000o == LAUNCH_TYPE.MIKEY || o000000o.f11121O000000o == LAUNCH_TYPE.MIBAND) {
                O000000o(hod.O0000OoO().O000000o(101));
                O00000Oo(hod.O0000OoO().O00000Oo(101));
            } else if (o000000o.f11121O000000o == LAUNCH_TYPE.DEVICE && (O00000Oo3 = hod.O0000OoO().O00000Oo(o000000o.O00000o0.O00000o, o000000o.O00000o0.f11122O000000o)) != null) {
                Iterator<CommonSceneOnline.O00000Oo> it = O00000Oo3.O00000o.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CommonSceneOnline.O00000Oo next = it.next();
                    if (next.O00000oo.equalsIgnoreCase(o000000o.O00000o0.O0000Oo)) {
                        if (O000000o(Integer.valueOf(next.O00000o))) {
                            O000000o(hod.O0000OoO().O000000o(next.O00000o));
                            O00000Oo(hod.O0000OoO().O00000Oo(next.O00000o));
                        } else {
                            this.O0000o0o.clear();
                            this.O0000O0o = false;
                        }
                    }
                }
            }
        }
        this.O0000o = true;
        for (int i2 = 0; i2 < this.O00000Oo.O00000oo.size(); i2++) {
            SceneApi.Action action = this.O00000Oo.O00000oo.get(i2);
            if (!(action.O0000O0o instanceof SceneApi.O000OO) && !(action.O0000O0o instanceof SceneApi.O000O0o0)) {
                if (action.O00000o == 0) {
                    SceneApi.O000OO00 o000oo00 = action.O0000O0o;
                    if (o000oo00 != null && (O00000Oo2 = hod.O0000OoO().O00000Oo(action.O00000oO, o000oo00.O00000o)) != null) {
                        Iterator<CommonSceneOnline.O00000Oo> it2 = O00000Oo2.O00000o.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            CommonSceneOnline.O00000Oo next2 = it2.next();
                            if (next2.O00000oo.equalsIgnoreCase(o000oo00.O00000o0)) {
                                if (O00000Oo(Integer.valueOf(next2.O00000o))) {
                                    O00000Oo(hod.O0000OoO().O00000Oo(next2.O00000o));
                                    O000000o(hod.O0000OoO().O000000o(next2.O00000o));
                                } else {
                                    this.O0000OOo.clear();
                                    this.O0000o = false;
                                }
                            }
                        }
                    }
                } else if (O00000Oo(Integer.valueOf(action.O00000o))) {
                    O00000Oo(hod.O0000OoO().O00000Oo(action.O00000o));
                    O000000o(hod.O0000OoO().O000000o(action.O00000o));
                } else {
                    this.O0000OOo.clear();
                    this.O0000o = false;
                }
            }
        }
    }

    public final void O00000Oo() {
        this.O0000o0o = new ArrayList();
    }

    public final void O000000o(List<Integer> list) {
        if (this.O0000o0o != null || list != null) {
            if (this.O0000o0o == null) {
                this.O0000o0o = new ArrayList();
                this.O0000o0o.addAll(list);
            } else if (list != null) {
                int i = 0;
                int i2 = 0;
                while (i < this.O0000o0o.size() && i2 < list.size()) {
                    if (this.O0000o0o.get(i).intValue() <= list.get(i2).intValue()) {
                        if (this.O0000o0o.get(i).intValue() < list.get(i2).intValue()) {
                            this.O0000o0o.remove(i);
                        } else {
                            i++;
                        }
                    }
                    i2++;
                }
                if (i < this.O0000o0o.size()) {
                    while (i < this.O0000o0o.size()) {
                        this.O0000o0o.remove(i);
                    }
                }
            }
        }
    }

    public final boolean O000000o(Integer num) {
        List<Integer> list = this.O0000o0o;
        if (list == null) {
            return true;
        }
        return list.contains(num);
    }

    public final void O00000Oo(List<Integer> list) {
        if (this.O0000OOo != null || list != null) {
            if (this.O0000OOo == null) {
                this.O0000OOo = new ArrayList();
                this.O0000OOo.addAll(list);
            } else if (list != null) {
                int i = 0;
                int i2 = 0;
                while (i < this.O0000OOo.size() && i2 < list.size()) {
                    if (this.O0000OOo.get(i).intValue() <= list.get(i2).intValue()) {
                        if (this.O0000OOo.get(i).intValue() < list.get(i2).intValue()) {
                            this.O0000OOo.remove(i);
                        } else {
                            i++;
                        }
                    }
                    i2++;
                }
                if (i < this.O0000OOo.size()) {
                    while (i < this.O0000OOo.size()) {
                        this.O0000OOo.remove(i);
                    }
                }
            }
        }
    }

    public final boolean O00000Oo(Integer num) {
        List<Integer> list = this.O0000OOo;
        if (list == null) {
            return true;
        }
        return list.contains(num);
    }

    public final void O000000o(hos hos) {
        O00000o0();
        this.O00000o0 = hos;
    }

    public final void O00000Oo(SceneApi.O000000o o000000o) {
        O00000o0();
        this.O00000oO = o000000o;
        if (o000000o != null) {
            O000000o(o000000o);
        }
    }

    public final void O000000o(hnm hnm) {
        O00000o0();
        this.O00000o = hnm;
    }

    public final void O00000Oo(SceneApi.Action action) {
        O00000o0();
        this.O00000oo = action;
        SceneApi.Action action2 = this.O00000oo;
        if (action2 != null) {
            O000000o(action2);
        }
    }

    public final void O00000o0() {
        this.O00000o0 = null;
        this.O00000o = null;
        this.O00000oo = null;
        this.O00000oO = null;
    }

    public static boolean O00000o0(List<SceneApi.O000000o> list) {
        return list != null && list.size() == 1 && list.get(0).f11121O000000o == LAUNCH_TYPE.CLICK;
    }
}
