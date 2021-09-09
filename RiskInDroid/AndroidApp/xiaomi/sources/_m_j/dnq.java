package _m_j;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public final class dnq extends dnh {
    public final int O000000o(Object obj) {
        int O000000o2 = super.O000000o(obj);
        Set<Object> O00000Oo = O00000Oo();
        if (O00000Oo != null) {
            int O00000Oo2 = this.O0000Oo.O00000Oo();
            int O000000o3 = this.O0000Oo.O000000o();
            dnc[] dncArr = new dnc[O000000o3];
            for (int i = 0; i < O000000o3; i++) {
                byte O000000o4 = this.O0000Oo.O000000o();
                dmx O000000o5 = O000000o(O000000o4);
                if (O000000o5 != null) {
                    dncArr[i] = O000000o5.f14798O000000o;
                } else {
                    Log.e("FunExecutor_TMTEST", "read param failed:".concat(String.valueOf((int) O000000o4)));
                    dncArr = null;
                }
            }
            if (dncArr == null || !O000000o(O00000Oo2, this.O0000Oo.O000000o(), dncArr, O00000Oo)) {
                return O000000o2;
            }
            return 1;
        }
        Log.e("FunExecutor_TMTEST", "execute findObject failed");
        return O000000o2;
    }

    private boolean O000000o(int i, int i2, dnc[] dncArr, Set<Object> set) {
        int length = dncArr.length;
        Class[] clsArr = new Class[length];
        Object[] objArr = new Object[length];
        for (int i3 = 0; i3 < length; i3++) {
            clsArr[i3] = dncArr[i3].O00000Oo();
            objArr[i3] = dncArr[i3].O00000o0();
        }
        String O000000o2 = this.O0000OOo.O000000o(i);
        boolean z = false;
        for (Object next : set) {
            try {
                Method method = next.getClass().getMethod(O000000o2, clsArr);
                if (method != null) {
                    Object invoke = method.invoke(next, objArr);
                    dmx O000000o3 = this.O0000OoO.O000000o(i2);
                    if (invoke != null) {
                        O000000o3.O000000o(invoke);
                    } else {
                        O000000o3.O00000Oo = 0;
                    }
                    z = true;
                } else {
                    Log.e("FunExecutor_TMTEST", "get method failed:" + next.getClass());
                }
            } catch (NoSuchMethodException e) {
                Log.e("FunExecutor_TMTEST", "call get method failed:" + e + next);
            } catch (InvocationTargetException unused) {
            } catch (IllegalAccessException e2) {
                Log.e("FunExecutor_TMTEST", "call get method failed:" + e2 + next);
            }
        }
        return z;
    }
}
