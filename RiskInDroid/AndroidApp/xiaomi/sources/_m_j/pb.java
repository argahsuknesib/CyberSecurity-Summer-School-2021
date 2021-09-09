package _m_j;

import android.location.Location;

public final class pb {
    public static float O000000o(op opVar, op opVar2) {
        double[] dArr = {opVar.O00000Oo, opVar.f2369O000000o, opVar2.O00000Oo, opVar2.f2369O000000o};
        float[] fArr = new float[1];
        Location.distanceBetween(dArr[0], dArr[1], dArr[2], dArr[3], fArr);
        return fArr[0];
    }
}
