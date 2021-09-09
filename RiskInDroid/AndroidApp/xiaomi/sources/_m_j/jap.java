package _m_j;

import android.bluetooth.BluetoothAdapter;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

final class jap {
    static String O000000o(SparseArray<byte[]> sparseArray) {
        if (sparseArray == null) {
            return "null";
        }
        if (sparseArray.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < sparseArray.size(); i++) {
            sb.append(sparseArray.keyAt(i));
            sb.append("=");
            sb.append(Arrays.toString(sparseArray.valueAt(i)));
        }
        sb.append('}');
        return sb.toString();
    }

    static <T> String O000000o(Map map) {
        if (map == null) {
            return "null";
        }
        if (map.isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object key = ((Map.Entry) it.next()).getKey();
            sb.append(key);
            sb.append("=");
            sb.append(Arrays.toString((byte[]) map.get(key)));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    static void O000000o(BluetoothAdapter bluetoothAdapter) {
        if (bluetoothAdapter == null || bluetoothAdapter.getState() != 12) {
            throw new IllegalStateException("BT Adapter is not turned ON");
        }
    }
}
