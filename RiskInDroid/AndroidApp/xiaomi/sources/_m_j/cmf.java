package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.miot.spec.SpecManager;
import com.miot.spec.exception.NotSupportValueException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class cmf {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5, types: [_m_j.cmg] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    public static void O000000o(String str, int i, String str2, final cmi<Bundle> cmi) {
        ? r3 = 0;
        int i2 = -1007;
        if (i == 0) {
            try {
                r3 = cmh.O000000o(str2);
            } catch (NotSupportValueException e) {
                if (cmi != null) {
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(e.getErrorCode() == 0 ? -1007 : e.getErrorCode());
                    objArr[1] = e.getMessage();
                    cnd.O000000o("SpecManager", "parseSetProperty error: code=%s,msg=%s", objArr);
                    if (e.getErrorCode() != 0) {
                        i2 = e.getErrorCode();
                    }
                    cmi.O000000o(i2, e.getMessage());
                }
                e.printStackTrace();
            }
            SpecManager specManager = SpecManager.O000000o.f5247O000000o;
            AnonymousClass3 r11 = new cmm() {
                /* class _m_j.cmf.AnonymousClass3 */

                public final void O000000o(List<cmh> list) {
                    if (cmi != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("objects", cmh.O000000o(list));
                            Bundle bundle = new Bundle();
                            bundle.putString("key_spec_json_resp", jSONObject.toString());
                            cmi.O000000o(bundle);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void O000000o(int i, String str) {
                    cmi cmi = cmi;
                    if (cmi != null) {
                        cmi.O000000o(i, str);
                    }
                }
            };
            if (TextUtils.isEmpty(str)) {
                cnd.O00000Oo("SpecManager", "setProperties error: mac is null,return", new Object[0]);
                r11.O000000o(-1001, "mac address cannot null");
            } else if (r3 == 0 || r3.isEmpty()) {
                cnd.O00000Oo("SpecManager", "setProperty, list is empty", new Object[0]);
                r11.O000000o(-1002, "set properties list is null or empty");
            } else {
                specManager.O000000o(str, new cmz(str, r3, r11));
            }
        } else if (i == 2) {
            try {
                r3 = cmh.O00000Oo(str2);
            } catch (NotSupportValueException e2) {
                if (cmi != null) {
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(e2.getErrorCode() == 0 ? -1007 : e2.getErrorCode());
                    objArr2[1] = e2.getMessage();
                    cnd.O000000o("SpecManager", "parseGetProperty error: code=%s,msg=%s", objArr2);
                    if (e2.getErrorCode() != 0) {
                        i2 = e2.getErrorCode();
                    }
                    cmi.O000000o(i2, e2.getMessage());
                }
                e2.printStackTrace();
            }
            SpecManager specManager2 = SpecManager.O000000o.f5247O000000o;
            AnonymousClass4 r112 = new cmk() {
                /* class _m_j.cmf.AnonymousClass4 */

                public final void O000000o(List<cmh> list) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("objects", cmh.O000000o(list));
                        Bundle bundle = new Bundle();
                        bundle.putString("key_spec_json_resp", jSONObject.toString());
                        cmi.O000000o(bundle);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                public final void O000000o(int i, String str) {
                    cmi cmi = cmi;
                    if (cmi != null) {
                        cmi.O000000o(i, str);
                    }
                }
            };
            if (TextUtils.isEmpty(str)) {
                cnd.O00000Oo("SpecManager", "getProperties error: mac is null,return", new Object[0]);
                r112.O000000o(-1001, "mac address cannot null");
            } else if (r3 == 0 || r3.isEmpty()) {
                cnd.O00000Oo("SpecManager", "getProperty,list is emtpy", new Object[0]);
                r112.O000000o(-1003, "get Properties list is null or empty");
            } else {
                specManager2.O000000o(str, new cmq(str, r3, r112));
            }
        } else if (i == 5) {
            try {
                r3 = cmg.O000000o(str2);
            } catch (NotSupportValueException e3) {
                if (cmi != null) {
                    Object[] objArr3 = new Object[2];
                    objArr3[0] = Integer.valueOf(e3.getErrorCode() == 0 ? -1007 : e3.getErrorCode());
                    objArr3[1] = e3.getMessage();
                    cnd.O000000o("SpecManager", "parseDoAction error: code=%s,msg=%s", objArr3);
                    if (e3.getErrorCode() != 0) {
                        i2 = e3.getErrorCode();
                    }
                    cmi.O000000o(i2, e3.getMessage());
                }
                e3.printStackTrace();
            }
            SpecManager specManager3 = SpecManager.O000000o.f5247O000000o;
            AnonymousClass2 r113 = new cmj() {
                /* class _m_j.cmf.AnonymousClass2 */

                public final void O000000o() {
                    cmi cmi = cmi;
                    if (cmi != null) {
                        cmi.O000000o(null);
                    }
                }

                public final void O000000o(int i, String str) {
                    cmi cmi = cmi;
                    if (cmi != null) {
                        cmi.O000000o(i, str);
                    }
                }
            };
            if (TextUtils.isEmpty(str)) {
                cnd.O00000Oo("SpecManager", "sendAction error: mac is null,return", new Object[0]);
                r113.O000000o(-1001, "mac address cannot null");
            } else if (r3 == 0) {
                cnd.O00000Oo("SpecManager", "sendAction ,specAction is null ,return", new Object[0]);
                r113.O000000o(-1005, "send action,but action entity is null");
            } else {
                specManager3.O000000o(str, new cmn(str, r3, r113));
            }
        }
    }
}
