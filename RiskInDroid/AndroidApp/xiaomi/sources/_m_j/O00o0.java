package _m_j;

import java.util.Comparator;

public final class O00o0 implements Comparator<O00O00o0> {
    public final int compare(Object obj, Object obj2) {
        O00O00o0 o00O00o0 = (O00O00o0) obj;
        O00O00o0 o00O00o02 = (O00O00o0) obj2;
        if (o00O00o0.O00000Oo.equals("Camera") || o00O00o0.O00000Oo.equals("WeiXin") || o00O00o02.O00000Oo.equals("Camera") || o00O00o02.O00000Oo.equals("WeiXin") || o00O00o0.O00000o.get(1).mLastModifyTimeStampt == o00O00o02.O00000o.get(1).mLastModifyTimeStampt) {
            return 0;
        }
        if (o00O00o0.O00000o.get(1).mLastModifyTimeStampt < o00O00o02.O00000o.get(1).mLastModifyTimeStampt) {
            return 1;
        }
        return -1;
    }
}
