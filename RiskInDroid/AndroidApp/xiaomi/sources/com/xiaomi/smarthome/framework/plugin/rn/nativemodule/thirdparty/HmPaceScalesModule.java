package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty;

import _m_j.bah;
import _m_j.wa;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.holtek.libHTBodyfat.HTBodyfat;
import java.util.Hashtable;

public class HmPaceScalesModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "HmPaceScalesModule";
    }

    public HmPaceScalesModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void computeBodyParam(double d, double d2, int i, int i2, int i3, Callback callback) {
        float f;
        float f2;
        float f3;
        float f4;
        Callback callback2 = callback;
        bah bah = new bah(d, d2, i, i2, i3);
        int NN = HTBodyfat.NN(bah.f12744O000000o, bah.O00000Oo, bah.O00000o0, bah.O00000o, bah.O00000oO);
        if (NN == 0) {
            bah.O0000Ooo = HTBodyfat.CC();
            bah.O0000o00 = HTBodyfat.HH();
            bah.O0000OoO = HTBodyfat.DD();
            bah.O0000o0 = HTBodyfat.FF();
            bah.O0000Oo = (int) HTBodyfat.GG();
            bah.O0000Oo0 = (int) HTBodyfat.BB();
            bah.O0000OOo = HTBodyfat.EE();
            bah.O0000O0o = HTBodyfat.QQ();
            double[] II = HTBodyfat.II();
            bah.O0000o0O.put("瘦－普通", String.valueOf(II[0]));
            bah.O0000o0O.put("普通－偏胖", String.valueOf(II[1]));
            bah.O0000o0O.put("偏胖－肥胖", String.valueOf(II[2]));
            double[] JJ = HTBodyfat.JJ();
            bah.O0000o0o = new Hashtable<>();
            bah.O0000o0o.put("偏低－达标", String.valueOf(JJ[0]));
            double[] KK = HTBodyfat.KK();
            bah.O0000oO.put("瘦－标准－", String.valueOf(KK[0]));
            bah.O0000oO.put("标准－－标准＋", String.valueOf(KK[1]));
            bah.O0000oO.put("标准＋－偏胖", String.valueOf(KK[2]));
            bah.O0000oO.put("偏胖－肥胖", String.valueOf(KK[3]));
            double[] LL = HTBodyfat.LL();
            bah.O0000oO0.put("不足－标准", String.valueOf(LL[0]));
            bah.O0000oO0.put("标准－优秀", String.valueOf(LL[1]));
            double[] MM = HTBodyfat.MM();
            bah.O0000oOo.put("不足－标准", String.valueOf(MM[0]));
            bah.O0000oOo.put("标准－优秀", String.valueOf(MM[1]));
            double[] OO = HTBodyfat.OO();
            bah.O0000o.put("标准-警惕", String.valueOf(OO[0]));
            bah.O0000o.put("警惕-危险", String.valueOf(OO[1]));
            double[] PP = HTBodyfat.PP();
            bah.O0000oOO.put("不足－标准", String.valueOf(PP[0]));
            bah.O0000oOO.put("标准－优秀", String.valueOf(PP[1]));
        } else {
            if (NN == 4 || NN == 3) {
                bah.O0000OOo = 0.0d;
            } else {
                bah.O0000OOo = HTBodyfat.EE();
                bah.O0000O0o = HTBodyfat.QQ();
            }
            bah.O0000Oo = 0;
            bah.O0000Ooo = 0.0d;
            bah.O0000o00 = 0.0d;
            bah.O0000o0 = 0.0d;
            bah.O0000OoO = 0.0d;
            bah.O0000Oo0 = 0;
        }
        bah.O00000oo = HTBodyfat.AA();
        try {
            wa waVar = new wa();
            waVar.f2568O000000o = (int) d2;
            waVar.O00000Oo = (byte) i;
            waVar.O00000o0 = i2;
            waVar.O00000o = (float) d;
            waVar.O00000oO = (float) i3;
            waVar.O00000oo = (float) bah.O0000o0;
            waVar.O0000O0o = (float) bah.O0000o00;
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("code", NN);
            createMap.putDouble("resistance", bah.O00000oo);
            createMap.putDouble("BMI", bah.O0000OOo);
            createMap.putInt("basic_metabolism", bah.O0000Oo0);
            createMap.putInt("visceral_fat", bah.O0000Oo);
            createMap.putDouble("bone_weight", bah.O0000OoO);
            createMap.putDouble("fat_percentage", bah.O0000Ooo);
            createMap.putDouble("water_percentage", bah.O0000o00);
            createMap.putDouble("muscle_weight", bah.O0000o0);
            if (waVar.O00000Oo > 0) {
                f = (((float) waVar.f2568O000000o) * -0.7471f) + (waVar.O00000o * 0.9161f) + (((float) waVar.O00000o0) * 0.4184f) + (waVar.O00000oO * 0.0517f);
                f2 = 54.2267f;
            } else {
                f = (((float) waVar.f2568O000000o) * -1.1165f) + (waVar.O00000o * 1.5784f) + (((float) waVar.O00000o0) * 0.4615f) + (waVar.O00000oO * 0.0415f);
                f2 = 83.2548f;
            }
            float f5 = f + f2;
            if (f5 < 15.0f) {
                f5 = 15.0f;
            } else if (f5 > 80.0f) {
                f5 = 80.0f;
            }
            createMap.putInt("body_age", (int) f5);
            float f6 = ((waVar.O00000oo / waVar.O00000o) * 100.0f) - waVar.O0000O0o;
            float f7 = 5.0f;
            if (f6 > 32.0f) {
                f7 = 32.0f;
            } else if (f6 >= 5.0f) {
                f7 = f6;
            }
            createMap.putDouble("protein_percentage", (double) f7);
            if (waVar.O00000Oo > 0) {
                f3 = ((float) waVar.f2568O000000o) - 80.0f;
                f4 = 0.7f;
            } else {
                f3 = ((float) waVar.f2568O000000o) - 70.0f;
                f4 = 0.6f;
            }
            createMap.putDouble("standard_body_weight", (double) (f3 * f4));
            callback2.invoke(Boolean.TRUE, createMap);
        } catch (Exception e) {
            callback2.invoke(Boolean.FALSE, e.toString());
        }
    }
}
