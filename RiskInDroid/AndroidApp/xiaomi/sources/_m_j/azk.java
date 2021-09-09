package _m_j;

import android.content.Context;
import android.content.Intent;

public final class azk {
    public static void O000000o(Context context, Intent intent, azu azu) {
        String str;
        if (context == null) {
            str = "context is null , please check param of parseIntent()";
        } else if (intent == null) {
            str = "intent is null , please check param of parseIntent()";
        } else {
            for (azz next : azn.O000000o(context, intent)) {
                if (next != null) {
                    for (azs next2 : azj.O000000o().O00000Oo) {
                        if (next2 != null) {
                            next2.O000000o(context, next, azu);
                        }
                    }
                }
            }
            return;
        }
        bae.O00000Oo(str);
    }

    public static void O000000o(Context context, azy azy, azj azj) {
        if (context == null) {
            bae.O00000Oo("context is null , please check param of parseCommandMessage(2)");
        } else if (azy == null) {
            bae.O00000Oo("message is null , please check param of parseCommandMessage(2)");
        } else if (azj == null) {
            bae.O00000Oo("pushManager is null , please check param of parseCommandMessage(2)");
        } else if (azj.O0000O0o == null) {
            bae.O00000Oo("pushManager.getPushCallback() is null , please check param of parseCommandMessage(2)");
        } else {
            switch (azy.O00000o) {
                case 12289:
                    if (azy.O00000oo == 0) {
                        azj.O00000oo = azy.O00000oO;
                    }
                    azj.O0000O0o.O000000o(azy.O00000oo, azy.O00000oO);
                    return;
                case 12290:
                    azj.O0000O0o.O000000o(azy.O00000oo);
                    return;
                case 12291:
                case 12299:
                case 12300:
                case 12304:
                case 12305:
                case 12307:
                case 12308:
                default:
                    return;
                case 12292:
                    azy.O000000o(azy.O00000oO, "alias", "aliasId", "aliasName");
                    return;
                case 12293:
                    azy.O000000o(azy.O00000oO, "alias", "aliasId", "aliasName");
                    return;
                case 12294:
                    azy.O000000o(azy.O00000oO, "alias", "aliasId", "aliasName");
                    return;
                case 12295:
                    azy.O000000o(azy.O00000oO, "tags", "tagId", "tagName");
                    return;
                case 12296:
                    azy.O000000o(azy.O00000oO, "tags", "tagId", "tagName");
                    return;
                case 12297:
                    azy.O000000o(azy.O00000oO, "tags", "tagId", "tagName");
                    return;
                case 12298:
                    return;
                case 12301:
                    azy.O000000o(azy.O00000oO, "tags", "accountId", "accountName");
                    return;
                case 12302:
                    azy.O000000o(azy.O00000oO, "tags", "accountId", "accountName");
                    return;
                case 12303:
                    azy.O000000o(azy.O00000oO, "tags", "accountId", "accountName");
                    return;
                case 12306:
                    bag.O000000o(azy.O00000oO);
                    return;
                case 12309:
                    bag.O000000o(azy.O00000oO);
                    return;
            }
        }
    }
}
