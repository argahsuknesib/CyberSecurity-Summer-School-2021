package _m_j;

import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ou {

    /* renamed from: O000000o  reason: collision with root package name */
    public long f2375O000000o;
    public ot O00000Oo;
    public List<ot> O00000o0 = Collections.emptyList();

    public ou() {
    }

    private ou(long j) {
        this.f2375O000000o = j;
    }

    public static List<ot> O00000Oo(List<ScanResult> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<ScanResult> it = list.iterator();
        if (Build.VERSION.SDK_INT >= 17) {
            while (it.hasNext()) {
                ScanResult next = it.next();
                if (next != null) {
                    arrayList.add(new ot(pe.O000000o(next.BSSID), next.SSID, next.level, next.frequency, next.timestamp / 1000));
                }
            }
        } else {
            while (it.hasNext()) {
                ScanResult next2 = it.next();
                if (next2 != null) {
                    arrayList.add(new ot(pe.O000000o(next2.BSSID), next2.SSID, next2.level, next2.frequency, SystemClock.elapsedRealtime()));
                }
            }
        }
        return arrayList;
    }

    public final int O000000o() {
        return this.O00000o0.size();
    }

    public final void O000000o(List<ot> list) {
        this.O00000o0 = list;
    }

    /* renamed from: O00000Oo */
    public final ou clone() {
        ou ouVar = new ou(this.f2375O000000o);
        ot otVar = this.O00000Oo;
        if (otVar != null) {
            ouVar.O00000Oo = otVar.clone();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.O00000o0);
        ouVar.O00000o0 = arrayList;
        return ouVar;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("wifiStatus:[");
        sb2.append("updateTime=" + this.f2375O000000o + ",");
        if (this.O00000Oo != null) {
            str = "mainWifi:[" + this.O00000Oo.toString() + "],";
        } else {
            str = "mainWifi:[null],";
        }
        sb2.append(str);
        if (this.O00000o0 != null) {
            ArrayList arrayList = new ArrayList();
            if (this.O00000o0.size() > 5) {
                arrayList.addAll(this.O00000o0);
                sb = new StringBuilder("wifiList=");
            } else {
                arrayList.addAll(this.O00000o0);
                sb = new StringBuilder("wifiList=");
            }
            sb.append(this.O00000o0.toString());
            str2 = sb.toString();
        } else {
            str2 = "wifiList=0";
        }
        sb2.append(str2);
        sb2.append("]");
        return sb2.toString();
    }
}
