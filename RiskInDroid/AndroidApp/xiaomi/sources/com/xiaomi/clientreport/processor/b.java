package com.xiaomi.clientreport.processor;

import _m_j.duv;
import _m_j.duy;
import _m_j.duz;
import _m_j.dvl;
import _m_j.dvo;
import _m_j.emn;
import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class b implements dvl {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f5977O000000o;
    private HashMap<String, HashMap<String, duz>> O00000Oo;

    public b(Context context) {
        this.f5977O000000o = context;
    }

    public final void O000000o() {
        emn.O000000o(this.f5977O000000o, "perf", "perfUploading");
        File[] O00000Oo2 = emn.O00000Oo(this.f5977O000000o, "perfUploading");
        if (O00000Oo2 != null && O00000Oo2.length > 0) {
            for (File file : O00000Oo2) {
                if (file != null) {
                    List<String> O000000o2 = dvo.O000000o(file.getAbsolutePath());
                    file.delete();
                    O000000o(O000000o2);
                }
            }
        }
    }

    public final void O000000o(HashMap<String, HashMap<String, duz>> hashMap) {
        this.O00000Oo = hashMap;
    }

    public void O000000o(List<String> list) {
        emn.O000000o(this.f5977O000000o, list);
    }

    public final void O00000Oo() {
        String str;
        String str2;
        HashMap<String, HashMap<String, duz>> hashMap = this.O00000Oo;
        if (hashMap != null) {
            if (hashMap.size() > 0) {
                for (String str3 : this.O00000Oo.keySet()) {
                    HashMap hashMap2 = this.O00000Oo.get(str3);
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        duz[] duzArr = new duz[hashMap2.size()];
                        hashMap2.values().toArray(duzArr);
                        int i = 0;
                        duz duz = duzArr[0];
                        int i2 = duz.O00000oO;
                        String str4 = duz.O00000oo;
                        if (i2 <= 0 || TextUtils.isEmpty(str4)) {
                            str = "";
                        } else {
                            str = String.valueOf(i2) + "#" + str4;
                        }
                        File externalFilesDir = this.f5977O000000o.getExternalFilesDir("perf");
                        String str5 = null;
                        if (externalFilesDir == null) {
                            duv.O00000o("cannot get folder when to write perf");
                            str2 = null;
                        } else {
                            if (!externalFilesDir.exists()) {
                                externalFilesDir.mkdirs();
                            }
                            str2 = new File(externalFilesDir, str).getAbsolutePath();
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            while (true) {
                                if (i >= 20) {
                                    break;
                                }
                                String str6 = str2 + i;
                                if (emn.O000000o(this.f5977O000000o, str6)) {
                                    str5 = str6;
                                    break;
                                }
                                i++;
                            }
                        }
                        if (!TextUtils.isEmpty(str5)) {
                            dvo.O000000o(str5, duzArr);
                        }
                    }
                }
            }
            this.O00000Oo.clear();
        }
    }

    public final void O000000o(duz duz) {
        if ((duz instanceof duy) && this.O00000Oo != null) {
            duy duy = (duy) duz;
            String str = String.valueOf(duy.O00000oO) + "#" + duy.O00000oo;
            String O000000o2 = dvo.O000000o(duy);
            HashMap hashMap = this.O00000Oo.get(str);
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            duy duy2 = (duy) hashMap.get(O000000o2);
            if (duy2 != null) {
                duy.O00000Oo += duy2.O00000Oo;
                duy.O00000o0 += duy2.O00000o0;
            }
            hashMap.put(O000000o2, duy);
            this.O00000Oo.put(str, hashMap);
        }
    }
}
