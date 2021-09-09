package com.xiaomi.mico.common.event;

import _m_j.ahg;
import _m_j.ahh;
import _m_j.djz;
import _m_j.dkb;
import _m_j.jgc;
import org.json.JSONObject;

public class QQAuthUiListener implements djz {
    ahg loggerNew = new ahg();

    public QQAuthUiListener() {
        new ahh();
    }

    public void onComplete(Object obj) {
        jgc.O000000o().O00000o(QQAuthEvent.completeEvent(obj));
        try {
            ahg.O00000Oo(((JSONObject) obj).toString(2));
        } catch (Exception e) {
            ahg.O000000o(e);
        }
    }

    public void onError(dkb dkb) {
        ahg.O00000Oo("%d %s %s", Integer.valueOf(dkb.f14735O000000o), dkb.O00000o0, dkb.O00000Oo);
        jgc.O000000o().O00000o(QQAuthEvent.errorEvent(dkb));
    }

    public void onCancel() {
        ahg.O00000Oo("cancel");
        jgc.O000000o().O00000o(QQAuthEvent.cancelEvent());
    }

    public void onWarning(int i) {
        ahg.O00000Oo("Warning");
        jgc.O000000o().O00000o(QQAuthEvent.warningEvent(i));
    }
}
