package _m_j;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class dmv {

    /* renamed from: O000000o  reason: collision with root package name */
    public List<dpf> f14796O000000o = new ArrayList();
    public Map<String, Object> O00000Oo = new o0O0OOO0();
    public bnu O00000o0;

    public final Object O000000o(Object obj, int i) {
        Object obj2 = null;
        if (obj == null || i == 0) {
            Log.e("NObjManager_TMTEST", "getProperty param invalidate");
            return null;
        }
        try {
            String O000000o2 = this.O00000o0.O000000o(i);
            Method method = obj.getClass().getMethod(String.format("get%c%s", Character.valueOf(Character.toUpperCase(O000000o2.charAt(0))), O000000o2.substring(1).toString()), new Class[0]);
            if (method != null) {
                obj2 = method.invoke(obj, new Object[0]);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        if (obj2 != null || !(obj instanceof dpf)) {
            return obj2;
        }
        return ((dpf) obj).O00000Oo(i);
    }

    public final boolean O000000o(Object obj, int i, dmx dmx) {
        boolean z = false;
        if (obj == null || i == 0 || dmx == null) {
            Log.e("NObjManager_TMTEST", "setIntegerPropertyImp param invalidate");
            return false;
        }
        try {
            String O000000o2 = this.O00000o0.O000000o(i);
            String format = String.format("set%c%s", Character.valueOf(Character.toUpperCase(O000000o2.charAt(0))), O000000o2.substring(1).toString());
            Method method = obj.getClass().getMethod(format, dmx.f14798O000000o.O00000Oo());
            if (method != null) {
                method.invoke(obj, dmx.f14798O000000o.O00000o0());
                z = true;
            } else {
                Log.e("NObjManager_TMTEST", "view:" + obj.getClass() + "  setIntegerPropertyImp find method failed:" + format);
            }
        } catch (InvocationTargetException e) {
            Log.e("NObjManager_TMTEST", "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e);
        } catch (IllegalAccessException e2) {
            Log.e("NObjManager_TMTEST", "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e2);
        } catch (NoSuchMethodException e3) {
            Log.e("NObjManager_TMTEST", "view:" + obj.getClass() + "  setIntegerPropertyImp failed:" + e3);
        }
        if (z || !(obj instanceof dpf)) {
            return z;
        }
        return ((dpf) obj).O00000o0(i);
    }

    public final dpf O000000o(int i) {
        String O000000o2 = this.O00000o0.O000000o(i);
        if (!TextUtils.isEmpty(O000000o2)) {
            int size = this.f14796O000000o.size();
            for (int i2 = 0; i2 < size; i2++) {
                dpf dpf = this.f14796O000000o.get(i2);
                if (TextUtils.equals(dpf.O00oOooO(), O000000o2)) {
                    return dpf;
                }
            }
        }
        return null;
    }
}
