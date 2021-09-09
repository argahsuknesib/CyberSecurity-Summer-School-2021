package _m_j;

import _m_j.gsj;
import com.xiaomi.smarthome.application.ServiceApplication;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0003J2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u00032\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f\u0018\u00010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/OperationRequestAndCacheHelper;", "", "cacheKey", "", "(Ljava/lang/String;)V", "getRawCache", "getUserSpecPrefs", "setRawCache", "", "json", "sync", "Lio/reactivex/Observable;", "path", "extra", "", "Lkotlin/Function0;", "Companion", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hkc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f19008O000000o = new O000000o((byte) 0);
    public final String O00000Oo;

    public static String O00000Oo() {
        return "prefs_lite_config";
    }

    public hkc(String str) {
        ixe.O00000o(str, "cacheKey");
        this.O00000Oo = str;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/xiaomi/smarthome/operation/helper/OperationRequestAndCacheHelper$Companion;", "", "()V", "CACHED_DATA_SUFFIX", "", "TAG", "smarthome-operation_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static Observable<String> O000000o(String str, Map<String, ? extends iwb<String>> map) {
        ixe.O00000o(str, "path");
        List<gsi> arrayList = new ArrayList<>();
        arrayList.add(new gsi("platform", "2"));
        if (map == null) {
            map = ivb.O000000o();
        }
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(new gsi((String) next.getKey(), (String) ((iwb) next.getValue()).invoke()));
        }
        arrayList.add(new gsi("appTabType", "1"));
        arrayList.add(new gsi("appVersion", "64706"));
        arrayList.add(new gsi("locale", flk.O000000o(ftn.O00000o0(ServiceApplication.getAppContext()))));
        gsj.O000000o o000000o = new gsj.O000000o();
        o000000o.f18212O000000o = "GET";
        gsj.O000000o O00000Oo2 = o000000o.O00000Oo(ixe.O000000o(hka.O000000o(), (Object) str));
        O00000Oo2.O00000oO = arrayList;
        Observable<String> onErrorReturnItem = hjn.O000000o(O00000Oo2.O000000o(), $$Lambda$hkc$jf2qOD2cYXMQgMpCFCDc_9JluFg.INSTANCE).onErrorReturnItem("");
        ixe.O00000Oo(onErrorReturnItem, "fetch<String>(request) { response -> response.toString() }.onErrorReturnItem(\"\")");
        return onErrorReturnItem;
    }

    /* access modifiers changed from: private */
    public static final String O000000o(JSONObject jSONObject) {
        return jSONObject.toString();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final String O000000o() {
        String O00000o0 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", ixe.O000000o(this.O00000Oo, (Object) "_cached_data"), "");
        ixe.O00000Oo(O00000o0, "getSettingString(ServiceApplication.getAppContext(),\n                getUserSpecPrefs(), cacheKey + CACHED_DATA_SUFFIX, \"\")");
        return O00000o0;
    }
}
