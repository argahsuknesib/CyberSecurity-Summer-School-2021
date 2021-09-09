package _m_j;

import android.net.wifi.ScanResult;
import java.util.Comparator;

final class dmc implements Comparator<ScanResult> {
    dmc() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        int abs = Math.abs(((ScanResult) obj).level);
        int abs2 = Math.abs(((ScanResult) obj2).level);
        if (abs > abs2) {
            return 1;
        }
        return abs == abs2 ? 0 : -1;
    }
}
