package _m_j;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.scene.activity.SmartHomeSceneActionChooseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.List;

public abstract class hnm {

    /* renamed from: O000000o  reason: collision with root package name */
    public String[] f19096O000000o = null;
    public int[] O00000Oo = null;
    protected List<Integer> O00000o = new ArrayList();
    protected int[] O00000o0;

    public abstract int O000000o(int i);

    public int O000000o(SmartHomeSceneActionChooseActivity.O0000OOo o0000OOo, Context context, int i, Object obj, Object obj2) {
        return -1;
    }

    public abstract int O000000o(SceneApi.Action action, Object obj);

    public abstract int O000000o(String str, Object obj);

    public abstract SceneApi.Action O000000o(String str, int i, Object obj, Intent intent);

    public abstract String O000000o(Object obj);

    public final List<Integer> O00000Oo() {
        return this.O00000o;
    }

    public final void O00000o0() {
        int i = 0;
        while (i < this.O00000o.size()) {
            if (this.O00000o.get(i).intValue() != -1) {
                i++;
            } else {
                return;
            }
        }
        this.O00000o.add(-1);
    }

    public final boolean O00000o() {
        return this.O00000o.size() == this.O00000Oo.length;
    }
}
