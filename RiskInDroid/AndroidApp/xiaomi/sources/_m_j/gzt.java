package _m_j;

import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.newui.card.State;
import java.util.ArrayList;
import java.util.Iterator;

public final class gzt {
    public static Pair O000000o(Device device, ArrayList<Pair> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<Pair> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if ((next.first instanceof State) && !device.isSharedReadOnly()) {
                return next;
            }
        }
        return null;
    }

    public static Pair O000000o(ArrayList<Pair> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator<Pair> it = arrayList.iterator();
        while (it.hasNext()) {
            Pair next = it.next();
            if (next.first instanceof State) {
                return next;
            }
        }
        return null;
    }

    public static String O000000o(String str, ArrayList<Pair> arrayList) {
        if (str == null || arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            Pair pair = arrayList.get(i);
            if ((pair.first instanceof String) && (pair.second instanceof String) && !TextUtils.isEmpty((String) pair.second)) {
                String trim = ((String) pair.first).trim();
                if (TextUtils.isEmpty(trim)) {
                    sb.append(((String) pair.second).trim());
                } else {
                    sb.append(trim);
                    sb.append(" ");
                    sb.append(((String) pair.second).trim());
                }
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }
}
