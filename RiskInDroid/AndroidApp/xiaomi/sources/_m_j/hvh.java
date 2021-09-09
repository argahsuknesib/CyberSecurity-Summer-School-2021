package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

public class hvh implements hvo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hvh f699O000000o;
    private hvl O00000Oo;

    private hvh() {
    }

    public static hvo O000000o() {
        if (f699O000000o == null) {
            synchronized (hvh.class) {
                if (f699O000000o == null) {
                    f699O000000o = new hvh();
                }
            }
        }
        return f699O000000o;
    }

    public final void O000000o(String str) {
        String O000000o2 = hvm.O00000Oo().O000000o();
        PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(str);
        int O00000o = pluginInfo != null ? hvl.O00000o(pluginInfo.O00000o()) : 0;
        if (O00000o != 0) {
            O000000o(O000000o2, O00000o);
        }
        O000000o(O000000o2, O00000o);
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        O000000o("1", sb.toString());
        O000000o("0", str);
    }

    public final void O000000o(String str, int i) {
        hvl hvl = this.O00000Oo;
        if (hvl != null) {
            hvl.O000000o(0);
        }
        this.O00000Oo = new hvl(str, i);
    }

    public final String O000000o(int i) {
        if (this.O00000Oo == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Finish process called, but nothing is  processing");
            return null;
        }
        gsy.O000000o(3, "SmartConfigProcessManager", "Finish process with code ".concat(String.valueOf(i)));
        String O000000o2 = this.O00000Oo.O000000o(i);
        this.O00000Oo = null;
        return O000000o2;
    }

    public final void O000000o(String str, String str2) {
        if (this.O00000Oo == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Add process context, but nothing is  processing");
            return;
        }
        gsy.O000000o(3, "SmartConfigProcessManager", "");
        this.O00000Oo.O000000o(str, str2);
    }

    public final int O00000Oo(int i) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before start action (" + i + ")");
            return -1;
        }
        hvl.O000000o();
        hvj hvj = new hvj();
        hvj.f701O000000o = hvl.f703O000000o.size() + 1;
        hvj.O00000Oo = i;
        hvj.O00000o0 = System.currentTimeMillis();
        hvl.O00000Oo = hvj;
        return hvl.O00000Oo.f701O000000o;
    }

    public final void O00000Oo(String str, String str2) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before add current action context (" + str + ":" + str2 + ")");
        } else if (hvl.O00000Oo != null) {
            hvl.O00000Oo.O000000o(str, str2);
        }
    }

    public final void O00000o0(String str, String str2) {
        JSONArray jSONArray;
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before add current action context (" + str + ":" + str2 + ")");
        } else if (hvl.O00000Oo != null) {
            hvj hvj = hvl.O00000Oo;
            hvj.O000000o();
            String str3 = hvj.O00000o.get(str);
            if (!TextUtils.isEmpty(str3)) {
                try {
                    jSONArray = new JSONArray(str3);
                    jSONArray.put(str2);
                } catch (JSONException unused) {
                    jSONArray = new JSONArray();
                    jSONArray.put(str3);
                    jSONArray.put(str2);
                }
                str2 = jSONArray.toString();
            }
            hvl.O00000Oo.O000000o(str, str2);
        }
    }

    public final void O000000o(int i, String str, String str2) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before add current action context (" + str + ":" + str2 + ")");
            return;
        }
        hvj O00000Oo2 = hvl.O00000Oo(i);
        if (O00000Oo2 == null) {
            gsy.O000000o(6, "SmartConfigProcess", "Can not find action by id (" + i + ")");
            return;
        }
        O00000Oo2.O000000o(str, str2);
    }

    public final void O00000Oo(int i, String str, String str2) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before add context(by code)  to + " + i + " : value (" + str + ":" + str2 + ")");
            return;
        }
        hvj O00000o0 = hvl.O00000o0(i);
        if (O00000o0 != null) {
            O00000o0.O000000o(str, str2);
        }
    }

    public final void O00000o0(int i) {
        O000000o(i, (Map<String, String>) null);
    }

    public final void O000000o(int i, Map<String, String> map) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before finish current action (" + i + ")");
            return;
        }
        hvl.O000000o(i, map);
    }

    public final void O000000o(int i, int i2) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before finish current action (" + i2 + ")");
            return;
        }
        hvj O00000Oo2 = hvl.O00000Oo(i);
        if (O00000Oo2 == null) {
            gsy.O000000o(6, "SmartConfigProcess", "Can not find action by id (" + i + ")");
            return;
        }
        O00000Oo2.O000000o(i2);
    }

    public final void O00000Oo(int i, int i2) {
        hvl hvl = this.O00000Oo;
        if (hvl == null) {
            gsy.O000000o(6, "SmartConfigProcessManager", "Please start Process before finish current action (" + i2 + ")");
            return;
        }
        hvj O00000o0 = hvl.O00000o0(i);
        if (O00000o0 == null) {
            gsy.O000000o(6, "SmartConfigProcess", "Can not find action by code (" + i + ")");
        } else if (O00000o0 == hvl.O00000Oo) {
            hvl.O000000o(i2, (Map<String, String>) null);
        } else {
            O00000o0.O000000o(i2);
        }
    }
}
