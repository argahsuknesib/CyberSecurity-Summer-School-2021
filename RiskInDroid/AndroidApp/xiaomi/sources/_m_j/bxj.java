package _m_j;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class bxj {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, String> f13379O000000o;
    private static Map<String, String> O00000Oo;
    private static Map<String, String> O00000o = new HashMap();
    private static Map<String, String> O00000o0 = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        f13379O000000o = hashMap;
        hashMap.put("header", "a");
        f13379O000000o.put("ack", "b");
        f13379O000000o.put("tvKey", "c");
        f13379O000000o.put("ca", "d");
        f13379O000000o.put("data", "e");
        f13379O000000o.put("action", "f");
        f13379O000000o.put("params", "g");
        f13379O000000o.put("code", "h");
        f13379O000000o.put("msg", "i");
        f13379O000000o.put("respData", "j");
        f13379O000000o.put("type", "k");
        HashMap hashMap2 = new HashMap();
        O00000Oo = hashMap2;
        hashMap2.put("h", "code");
        O00000Oo.put("i", "msg");
        O00000Oo.put("c", "tvKey");
        f13379O000000o.put("uwbVersion", "p1");
        O00000Oo.put("p1", "uwbVersion");
        f13379O000000o.put("tvName", "p2");
        O00000Oo.put("p2", "tvName");
        f13379O000000o.put("bleMac", "p3");
        O00000Oo.put("p3", "bleMac");
        f13379O000000o.put("ehMac", "p4");
        O00000Oo.put("p4", "ehMac");
        f13379O000000o.put("wifiMac", "p5");
        O00000Oo.put("p5", "wifiMac");
        f13379O000000o.put("miplayFlag", "p6");
        O00000Oo.put("p6", "miplayFlag");
        f13379O000000o.put("miAccountId", "pd");
        O00000Oo.put("pd", "miAccountId");
        f13379O000000o.put("partnerId", "ph");
        O00000Oo.put("ph", "partnerId");
        f13379O000000o.put("isPlaying", "p7");
        O00000Oo.put("p7", "isPlaying");
        f13379O000000o.put("mediaId", "p8");
        O00000Oo.put("p8", "mediaId");
        f13379O000000o.put("mediaName", "p9");
        O00000Oo.put("p9", "mediaName");
        f13379O000000o.put("ci", "pa");
        O00000Oo.put("pa", "ci");
        f13379O000000o.put("duration", "pb");
        O00000Oo.put("pb", "duration");
        f13379O000000o.put("position", "pc");
        O00000Oo.put("pc", "position");
        f13379O000000o.put("source", "pe");
        O00000Oo.put("pe", "source");
        f13379O000000o.put("mediaUrl", "pf");
        O00000Oo.put("pf", "mediaUrl");
        f13379O000000o.put("eventCode", "pg");
        O00000Oo.put("pg", "eventCode");
        f13379O000000o.put("albumQiPuId", "pj");
        O00000Oo.put("pj", "albumQiPuId");
        f13379O000000o.put("qiPuId", "pk");
        O00000Oo.put("pk", "qiPuId");
        f13379O000000o.put("plazaMode", "pl");
        O00000Oo.put("pl", "plazaMode");
        f13379O000000o.put("authLevel", "pm");
        O00000Oo.put("pm", "authLevel");
        f13379O000000o.put("authorized", "pn");
        O00000Oo.put("pn", "authorized");
        f13379O000000o.put("tagLatestVer", "po");
        O00000Oo.put("po", "tagLatestVer");
        f13379O000000o.put("screenOn", "pp");
        O00000Oo.put("pp", "screenOn");
        f13379O000000o.put("supportXiaoai", "pq");
        O00000Oo.put("pq", "supportXiaoai");
        f13379O000000o.put("powerShortPress", "pr");
        O00000Oo.put("pr", "powerShortPress");
        O00000o.put("a0", "reqTvKey");
        O00000o0.put("reqTvKey", "a0");
        O00000o.put("a1", "reqTvInfo");
        O00000o0.put("reqTvInfo", "a1");
        O00000o.put("a2", "reqPlayerInfo");
        O00000o0.put("reqPlayerInfo", "a2");
        O00000o.put("a3", "notifyPlayerInfo");
        O00000o0.put("notifyPlayerInfo", "a3");
        O00000o.put("a4", "notifyVideoPosition");
        O00000o0.put("notifyVideoPosition", "a4");
        O00000o.put("a5", "doLogin");
        O00000o0.put("doLogin", "a5");
        O00000o.put("a6", "notifyLoginEvent");
        O00000o0.put("notifyLoginEvent", "a6");
        O00000o.put("a8", "doVideoPlay");
        O00000o0.put("doVideoPlay", "a8");
        O00000o.put("a9", "doVideoPosition");
        O00000o0.put("doVideoPosition", "a9");
        O00000o.put("aa", "doAiStart");
        O00000o0.put("doAiStart", "aa");
        O00000o.put("ab", "doAiFinish");
        O00000o0.put("doAiFinish", "ab");
        O00000o.put("ac", "doSourcePage");
        O00000o0.put("doSourcePage", "ac");
        O00000o.put("ad", "doKeyEvent");
        O00000o0.put("doKeyEvent", "ad");
        O00000o.put("af", "onError");
        O00000o0.put("onError", "af");
        O00000o.put("ag", "notifyTvNameChanged");
        O00000o0.put("notifyTvNameChanged", "ag");
        O00000o.put("ah", "notifyPlazaMode");
        O00000o0.put("notifyPlazaMode", "ah");
        O00000o.put("ai", "notifyAccountChanged");
        O00000o0.put("notifyAccountChanged", "ai");
        O00000o.put("aj", "notifyAuthLevelChanged");
        O00000o0.put("notifyAuthLevelChaned", "aj");
        O00000o.put("ak", "reqOtaResult");
        O00000o0.put("reqOtaResult", "ak");
        O00000o.put("al", "notifyTagOtaUpgradeInfo");
        O00000o0.put("notifyTagOtaUpgradeInfo", "al");
        O00000o.put("am", "notifyScreenState");
        O00000o0.put("notifyScreenState", "am");
        O00000o.put("an", "notifyPowerShortPressChanged");
        O00000o0.put("notifyPowerShortPressChanged", "an");
    }

    public static String O000000o(String str) {
        String str2 = f13379O000000o.get(str);
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String O00000Oo(String str) {
        String str2 = O00000Oo.get(str);
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String O00000o0(String str) {
        String str2 = O00000o0.get(str);
        return TextUtils.isEmpty(str2) ? str : str2;
    }

    public static String O00000o(String str) {
        String str2 = O00000o.get(str);
        return TextUtils.isEmpty(str2) ? str : str2;
    }
}
