package _m_j;

import android.text.TextUtils;
import org.json.JSONException;

public final class bxe {
    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: _m_j.bxo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: _m_j.bxo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: _m_j.bxn} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: _m_j.bxo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: _m_j.bxo} */
    /* JADX WARNING: Multi-variable type inference failed */
    public static void O000000o(String str, bxa bxa) {
        int i;
        if (TextUtils.isEmpty(str)) {
            O000000o(-701, "Error: json string is null", bxa);
            return;
        }
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !str.startsWith("{\"a\":")) {
            str = bxk.O00000Oo("2", str);
        }
        try {
            bxh bxh = new bxh(str);
            bxc bxc = new bxc();
            bxh O00000Oo = bxh.O00000Oo("header");
            bxm bxm = new bxm();
            bxm.f13380O000000o = O00000Oo.O000000o("tvKey");
            bxm.O00000Oo = O00000Oo.O000000o("ack");
            bxm.O00000o0 = O00000Oo.O000000o("type");
            bxc.f13375O000000o = bxm;
            if (bxc.f13375O000000o == null) {
                i = 610;
            } else {
                i = bxc.f13375O000000o.O000000o();
            }
            if (i != 600) {
                O000000o(i, "Error: header incorrect!", bxa);
                z = true;
            }
            if (!z) {
                bxh O00000Oo2 = bxh.O00000Oo("data");
                bxo bxo = null;
                if (1 == Integer.parseInt(bxc.f13375O000000o.O00000o0)) {
                    bxn bxn = new bxn();
                    bxn.f13381O000000o = bxj.O00000o(O00000Oo2.O000000o("action"));
                    bxn.O00000Oo = O00000Oo2.O00000o0("params");
                    bxo = bxn;
                } else if (2 == Integer.parseInt(bxc.f13375O000000o.O00000o0)) {
                    bxo = bxo.O000000o(O00000Oo2);
                }
                bxc.O00000Oo = bxo;
                bxb.O000000o("parse uwb data: ".concat(String.valueOf(bxc)));
                bxa.onSuccess(bxc);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            bxb.O00000Oo("Error: build json request error; " + e.getMessage());
            bxa.onFailed(-702, "Error: json error!");
        }
    }

    private static void O000000o(int i, String str, bxa bxa) {
        bxb.O00000Oo(str);
        bxa.onFailed(i, str);
    }
}
