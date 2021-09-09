package _m_j;

import java.util.Map;
import java.util.Set;

public final class hmg implements hmh {
    private static void O000000o(String str, Object... objArr) {
        if (objArr.length > 0) {
            gsy.O000000o(3, "DefaultReportProvider", String.format(str, objArr));
        } else {
            gsy.O000000o(3, "DefaultReportProvider", str);
        }
    }

    public final int O000000o(int i) {
        O000000o("start actionCode =%d", Integer.valueOf(i));
        return 0;
    }

    public final void O000000o(int i, int i2) {
        O000000o("finishAction, actionCode=%d, resultCode=%d", Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void O00000Oo(int i) {
        O000000o("finishAction actionCode=%d", Integer.valueOf(i));
    }

    public final void O000000o() {
        O000000o("finishCurrentActionWithResult,resultCode=%d", 8);
    }

    public final void O000000o(int i, String str, String str2) {
        O000000o("addContextToActionById, actionCode=%d, key=%s, value=%s", Integer.valueOf(i), str, str2);
    }

    public final void O000000o(Map<String, String> map) {
        Object[] objArr = new Object[2];
        objArr[0] = 10;
        Set<String> keySet = map.keySet();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String next : keySet) {
            sb.append(next);
            sb.append(":");
            sb.append(map.get(next));
            sb.append(",");
        }
        sb.append("}");
        objArr[1] = sb.toString();
        O000000o("finishCurrentActionWithContext, resultCode=%d, map=%s", objArr);
    }
}
