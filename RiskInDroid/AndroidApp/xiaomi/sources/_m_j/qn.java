package _m_j;

import android.location.Location;
import android.os.Bundle;
import java.util.List;

public final class qn {
    public static void O000000o(ud udVar, Location location, long j, long j2) {
        udVar.O00000Oo = j;
        udVar.f2527O000000o = j2;
        udVar.O00000o0 = (int) (location.getLongitude() * 1000000.0d);
        udVar.O00000o = (int) (location.getLatitude() * 1000000.0d);
        udVar.O00000oO = (int) location.getAltitude();
        udVar.O00000oo = (int) location.getAccuracy();
        udVar.O0000O0o = (int) location.getSpeed();
        udVar.O0000OOo = (short) ((int) location.getBearing());
        Bundle extras = location.getExtras();
        udVar.O0000Oo0 = 0;
        if (extras != null) {
            try {
                udVar.O0000Oo0 = (byte) extras.getInt("satellites", 0);
            } catch (Exception unused) {
            }
        }
    }

    public static short O000000o(List<ug> list, boolean z, List<sg> list2) {
        list.clear();
        short s = Short.MAX_VALUE;
        if (list2 != null) {
            double d = 0.0d;
            int i = 0;
            for (sg next : list2) {
                int i2 = next.O00000Oo;
                float f = next.O00000o;
                boolean z2 = next.f2453O000000o;
                if (i2 > 1 && i2 <= 32) {
                    if (z2 && ((double) f) > 10.0d) {
                        double d2 = (double) next.O00000o0;
                        Double.isNaN(d2);
                        d += d2;
                        i++;
                    }
                    if (z) {
                        ug ugVar = new ug();
                        ugVar.f2530O000000o = (byte) i2;
                        ugVar.O00000Oo = (byte) Math.round(next.O00000o0);
                        ugVar.O00000o0 = (byte) Math.round(f);
                        ugVar.O00000o = (short) Math.round(next.O00000oO);
                        ugVar.O00000oO = z2 ? (byte) 1 : 0;
                        list.add(ugVar);
                    }
                }
                if (i > 0) {
                    double d3 = (double) i;
                    Double.isNaN(d3);
                    s = (short) Math.round(((float) (d / d3)) * 100.0f);
                }
            }
        }
        return s;
    }
}
