package _m_j;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import java.util.Map;

public class hvi implements hvo {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile hvi f700O000000o;

    private hvi() {
    }

    static hvi O000000o() {
        if (f700O000000o == null) {
            synchronized (hvi.class) {
                if (f700O000000o == null) {
                    f700O000000o = new hvi();
                }
            }
        }
        return f700O000000o;
    }

    public final void O000000o(String str) {
        String O000000o2 = hvm.O00000Oo().O000000o();
        PluginDeviceInfo O000000o3 = hvm.O00000Oo().O000000o(str);
        int O00000o = O000000o3 != null ? hvl.O00000o(O000000o3.O00000o()) : 0;
        if (O00000o != 0) {
            O000000o(O000000o2, O00000o);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        O000000o("1", sb.toString());
        O000000o("0", str);
    }

    public final void O000000o(String str, int i) {
        hvm.O00000Oo().O000000o(str, i);
    }

    public final String O000000o(int i) {
        return hvm.O00000Oo().O000000o(i);
    }

    public final void O000000o(String str, String str2) {
        hvm.O00000Oo().O000000o(str, str2);
    }

    public final int O00000Oo(int i) {
        return hvm.O00000Oo().O00000Oo(i);
    }

    public final void O00000Oo(String str, String str2) {
        hvm.O00000Oo().O00000Oo(str, str2);
    }

    public final void O00000o0(String str, String str2) {
        hvm.O00000Oo().O00000o0(str, str2);
    }

    public final void O000000o(int i, String str, String str2) {
        hvm.O00000Oo().O000000o(i, str, str2);
    }

    public final void O00000Oo(int i, String str, String str2) {
        hvm.O00000Oo().O00000Oo(i, str, str2);
    }

    public final void O00000o0(int i) {
        hvm.O00000Oo().O00000o0(i);
    }

    public final void O000000o(int i, Map<String, String> map) {
        hvm.O00000Oo().O000000o(i, map);
    }

    public final void O000000o(int i, int i2) {
        hvm.O00000Oo().O000000o(i, i2);
    }

    public final void O00000Oo(int i, int i2) {
        hvm.O00000Oo().O00000Oo(i, i2);
    }
}
