package _m_j;

import android.app.Activity;
import android.content.Intent;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.ArrayList;
import java.util.List;

public abstract class hos {

    /* renamed from: O000000o  reason: collision with root package name */
    protected int[] f457O000000o;
    protected String[] O00000Oo;
    private List<Integer> O00000o = new ArrayList();
    protected Device O00000o0;

    public int O000000o(int i, Activity activity, SceneApi.O000000o o000000o) {
        return -1;
    }

    public abstract int O000000o(SceneApi.O000000o o000000o);

    public abstract SceneApi.O000000o O000000o(int i, Intent intent);

    public void O000000o(SimpleDraweeView simpleDraweeView) {
    }

    public abstract int O00000o0(int i);

    public boolean O00000oo() {
        return true;
    }

    public static hos O000000o(Device device) {
        if (hod.O0000OoO().O00000Oo(device.model, device.did) == null || hod.O0000OoO().O00000Oo(device.model, device.did).O00000o.size() <= 0) {
            return null;
        }
        return new hox(device, null);
    }

    public hos(Device device) {
        this.O00000o0 = device;
    }

    public final void O000000o(int i) {
        int i2 = 0;
        while (i2 < this.O00000o.size()) {
            if (this.O00000o.get(i2).intValue() != i) {
                i2++;
            } else {
                return;
            }
        }
        this.O00000o.add(Integer.valueOf(i));
    }

    public final boolean O00000Oo() {
        return this.f457O000000o == null ? this.O00000o.isEmpty() : this.O00000o.size() == this.f457O000000o.length;
    }

    public final Device O00000o0() {
        return this.O00000o0;
    }

    public String O00000o() {
        return this.O00000o0.name;
    }

    public final int[] O00000oO() {
        return this.f457O000000o;
    }

    public String O00000Oo(int i) {
        if (this.f457O000000o == null) {
            return null;
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.f457O000000o;
            if (i2 >= iArr.length) {
                return null;
            }
            if (iArr[i2] == i) {
                return this.O00000Oo[i2];
            }
            i2++;
        }
    }
}
