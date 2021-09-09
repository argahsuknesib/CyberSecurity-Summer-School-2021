package _m_j;

import _m_j.dds;
import _m_j.ddt;
import _m_j.gsj;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.sankuai.waimai.router.annotation.RouterService;
import com.smarthome.uwb.ui.UwbBindHelper$Permit$intStore$2;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$longStore$2;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$parseConfig$blackModels$1;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$parseConfig$categories$1;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$parseConfig$models$1;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$parseConfig$speakPlatformConfig$1;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$parseConfig$speakPlatformConfig$2;
import com.smarthome.uwb.ui.UwbBindHelper$UwbSupportConfigManager$stringStore$2;
import com.smarthome.uwb.ui.UwbBindHelper$UwbTagApi$getTagDetailCache$1;
import com.smarthome.uwb.ui.UwbBindHelper$UwbTagApi$tagDetailStore$2;
import com.smarthome.uwb.ui.UwbBindHelper$getHomeUnBindDevices$1$result$1$querySupport$1;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001b\u001c\u001d\u001e\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0005\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\b0\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007J\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006J\u001e\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u0006H\u0007J\u0014\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\n\u0010\u001a\u001a\u00020\u0004*\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper;", "", "()V", "TAG", "", "getHomeUnBindDevices", "Lio/reactivex/Observable;", "", "Lkotlin/Pair;", "Lcom/xiaomi/smarthome/device/Device;", "queryHomes", "getSupportDeviceModels", "homeAndDeviceUpdateAware", "Landroid/content/Intent;", "updateBindInfoPrue", "Ljava/util/ArrayList;", "Lcom/smarthome/uwb/ui/UwbBindHelper$UwbQueryResult;", "Lkotlin/collections/ArrayList;", "updateBindInfoWithDeviceUpdate", "", "runnable", "Ljava/lang/Runnable;", "isSupport", "", "Lcom/xiaomi/smarthome/uwb_external/UwbSupportConfig;", "model", "toJson", "Permit", "UwbAssResult", "UwbQueryResult", "UwbSupportConfigManager", "UwbTagApi", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ddt {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ddt f14518O000000o = new ddt();

    private ddt() {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper$UwbAssResult;", "", "tag_id", "", "dev_did", "code", "", "msg", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()I", "getDev_did", "()Ljava/lang/String;", "getMsg", "getTag_id", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f14520O000000o;
        private final String O00000Oo;
        private final String O00000o;
        private final int O00000o0;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000Oo)) {
                return false;
            }
            O00000Oo o00000Oo = (O00000Oo) obj;
            return ixe.O000000o(this.f14520O000000o, o00000Oo.f14520O000000o) && ixe.O000000o(this.O00000Oo, o00000Oo.O00000Oo) && this.O00000o0 == o00000Oo.O00000o0 && ixe.O000000o(this.O00000o, o00000Oo.O00000o);
        }

        public final int hashCode() {
            return (((((this.f14520O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + Integer.valueOf(this.O00000o0).hashCode()) * 31) + this.O00000o.hashCode();
        }

        public final String toString() {
            return "UwbAssResult(tag_id=" + this.f14520O000000o + ", dev_did=" + this.O00000Oo + ", code=" + this.O00000o0 + ", msg=" + this.O00000o + ')';
        }

        public O00000Oo(String str, String str2, int i, String str3) {
            ixe.O00000o(str, "tag_id");
            ixe.O00000o(str2, "dev_did");
            ixe.O00000o(str3, "msg");
            this.f14520O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = i;
            this.O00000o = str3;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper$UwbQueryResult;", "", "tag_id", "", "dev_did", "member_specific_key", "hid_mode", "", "code", "msg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getDev_did", "()Ljava/lang/String;", "getHid_mode", "getMember_specific_key", "getMsg", "getTag_id", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final String f14521O000000o;
        public final String O00000Oo;
        public final int O00000o;
        public final String O00000o0;
        final int O00000oO;
        final String O00000oo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o0)) {
                return false;
            }
            O00000o0 o00000o0 = (O00000o0) obj;
            return ixe.O000000o(this.f14521O000000o, o00000o0.f14521O000000o) && ixe.O000000o(this.O00000Oo, o00000o0.O00000Oo) && ixe.O000000o(this.O00000o0, o00000o0.O00000o0) && this.O00000o == o00000o0.O00000o && this.O00000oO == o00000o0.O00000oO && ixe.O000000o(this.O00000oo, o00000o0.O00000oo);
        }

        public final int hashCode() {
            return (((((((((this.f14521O000000o.hashCode() * 31) + this.O00000Oo.hashCode()) * 31) + this.O00000o0.hashCode()) * 31) + Integer.valueOf(this.O00000o).hashCode()) * 31) + Integer.valueOf(this.O00000oO).hashCode()) * 31) + this.O00000oo.hashCode();
        }

        public final String toString() {
            return "UwbQueryResult(tag_id=" + this.f14521O000000o + ", dev_did=" + this.O00000Oo + ", member_specific_key=" + this.O00000o0 + ", hid_mode=" + this.O00000o + ", code=" + this.O00000oO + ", msg=" + this.O00000oo + ')';
        }

        public O00000o0(String str, String str2, String str3, int i, int i2, String str4) {
            ixe.O00000o(str, "tag_id");
            ixe.O00000o(str2, "dev_did");
            ixe.O00000o(str3, "member_specific_key");
            ixe.O00000o(str4, "msg");
            this.f14521O000000o = str;
            this.O00000Oo = str2;
            this.O00000o0 = str3;
            this.O00000o = i;
            this.O00000oO = i2;
            this.O00000oo = str4;
        }
    }

    public static String O000000o(O00000o0 o00000o0) {
        ixe.O00000o(o00000o0, "<this>");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("tag_id", o00000o0.f14521O000000o);
        jSONObject.put("dev_did", o00000o0.O00000Oo);
        jSONObject.put("member_specific_key", o00000o0.O00000o0);
        jSONObject.put("hid_mode", o00000o0.O00000o);
        jSONObject.put("code", o00000o0.O00000oO);
        jSONObject.put("msg", o00000o0.O00000oo);
        String jSONObject2 = jSONObject.toString();
        ixe.O00000Oo(jSONObject2, "JSONObject().apply {\n            put(\"tag_id\", tag_id)\n            put(\"dev_did\", dev_did)\n            put(\"member_specific_key\", member_specific_key)\n            put(\"hid_mode\", hid_mode)\n            put(\"code\", code)\n            put(\"msg\", msg)\n        }.toString()");
        return jSONObject2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.List<java.lang.String>]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static Observable<List<Pair<String, List<Device>>>> O000000o(List<String> list) {
        ixe.O00000o(list, "queryHomes");
        UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getHomeUnBindDevices queryHomes: ", (Object) list));
        Observable<R> map = O00000o.INSTANCE.getSupportConfig().map(new Function(list) {
            /* class _m_j.$$Lambda$ddt$SK4HrAKO91lNaCANU0NtdkuHJZI */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return ddt.O000000o(this.f$0, (hzk) obj);
            }
        });
        ixe.O00000Oo(map, "supportConfig.map { config->\n            UwbLogUtil.d(TAG,\"getHomeUnBindDevices: config : ${config}\")\n            val result = queryHomes.map { homeId ->\n                val querySupport: () -> List<Device> = {\n                    val currentHomeDevices =\n                        HomeManager.getInstance().getDeviceByHomeId(homeId).filterNotNull()\n                    UwbLogUtil.d(\n                        TAG, \"getHomeUnBindDevices supportConfig: $config, \" +\n                                \" ,currentHomeDevices ${currentHomeDevices.size} , isHomeInit: ${HomeManager.getInstance().isInited}\"\n                    )\n                    currentHomeDevices.filter {\n                        var isSupport =\n                            it.isOnline && config.isSupport(it.model) && it.comFlag.and(8) != 8/*filter build-in */\n                        UwbLogUtil.d(\n                            TAG,\n                            \"getHomeUnBindDevices supportConfig:isOnline ${it.isOnline} model:  ${it.model}, flag ${\n                                it.comFlag.and(\n                                    8\n                                ) != 8\n                            } isSupport: $isSupport\"\n                        )\n                        if(LightGroupManager.getInstance().isLightGroupDevice(it)\n                            || UwbTagUtils.shouldBlock(it.model)) {\n                            // 屏蔽灯组\n                            isSupport = false\n                        }\n                        if(it.model.startsWith(\"miir.\")) {\n                            // 屏蔽红外\n                            isSupport = false\n                        }\n                        isSupport\n                    }\n                }\n\n                homeId to querySupport().sortedBy { it.did }\n            }\n            result\n        }");
        return map;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, _m_j.hzk]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
     arg types: [java.lang.Iterable, _m_j.ddt$O0000OOo]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T> */
    /* access modifiers changed from: private */
    public static final List O000000o(List list, hzk hzk) {
        ixe.O00000o(list, "$queryHomes");
        ixe.O00000o(hzk, "config");
        UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getHomeUnBindDevices: config : ", (Object) hzk));
        Iterable<String> iterable = list;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (String str : iterable) {
            arrayList.add(iuf.O000000o(str, iuo.O000000o((Iterable) new UwbBindHelper$getHomeUnBindDevices$1$result$1$querySupport$1(str, hzk).invoke(), (Comparator) new O0000OOo())));
        }
        return (List) arrayList;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O0000OOo<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((Device) t).did, ((Device) t2).did);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hne.<init>(java.lang.String, android.app.Application, boolean):void
     arg types: [java.lang.String, com.xiaomi.smarthome.application.CommonApplication, int]
     candidates:
      _m_j.hne.<init>(java.lang.String, android.app.Application, byte):void
      _m_j.hne.<init>(java.lang.String, android.app.Application, boolean):void */
    public static Observable<Intent> O000000o() {
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        Observable<Intent> doOnComplete = new hne("device_updated", (Application) application, true).timeout(8, TimeUnit.SECONDS).doOnSubscribe($$Lambda$ddt$xEE5GwHM9_qVAaw8pEEUI1zj06E.INSTANCE).doOnNext($$Lambda$ddt$L8vh0N0w7PBs3_OefMkjXqgKAFY.INSTANCE).doOnError($$Lambda$ddt$5pDKOhfcqSaliwmGM6vpLqG2j7c.INSTANCE).doOnComplete($$Lambda$ddt$HFGwCNpyvEqiUWmn0G9MeaBr3Sk.INSTANCE);
        ixe.O00000Oo(doOnComplete, "BroadcastReceiverObservable(\n            HomeManager.ACTION_DEVICE_UPDATED,\n            CommonApplication.getApplication(),\n            true\n        ).timeout(8, TimeUnit.SECONDS).doOnSubscribe {\n                HomeManager.getInstance().forceUpdateAllData(false)\n            }.doOnNext {UwbLogUtil.d(TAG,\"homeAndDeviceUpdateAware onNext\")}\n            .doOnError { UwbLogUtil.d(TAG,\"homeAndDeviceUpdateAware onError $it\") }\n            .doOnComplete { UwbLogUtil.d(TAG,\"homeAndDeviceUpdateAware onComplete\") }");
        return doOnComplete;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Disposable disposable) {
        ggb.O00000Oo().O000000o(false);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Intent intent) {
        UwbLogUtil.d("UwbBindHelper", "homeAndDeviceUpdateAware onNext");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Throwable]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(Throwable th) {
        UwbLogUtil.d("UwbBindHelper", ixe.O000000o("homeAndDeviceUpdateAware onError ", (Object) th));
    }

    /* access modifiers changed from: private */
    public static final void O00000o0() {
        UwbLogUtil.d("UwbBindHelper", "homeAndDeviceUpdateAware onComplete");
    }

    @SuppressLint({"CheckResult"})
    public static void O000000o(Runnable runnable) {
        O000000o().onErrorReturnItem(new Intent()).flatMap($$Lambda$ddt$n2djAKg7i85rgDZaukG_g0UdfBM.INSTANCE).subscribe(new Consumer(runnable) {
            /* class _m_j.$$Lambda$ddt$QYBx4Db8f7_Nwm1EzZ5TTmMIzO0 */
            private final /* synthetic */ Runnable f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                ddt.O000000o(this.f$0, (ArrayList) obj);
            }
        }, new Consumer(runnable) {
            /* class _m_j.$$Lambda$ddt$q1X6eIT3y_5h1PYlvaj1dCtZo */
            private final /* synthetic */ Runnable f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                ddt.O000000o(this.f$0, (Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final ObservableSource O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        Set<String> O00000o02 = hzq.O00000o0();
        O0000O0o o0000O0o = O0000O0o.f14522O000000o;
        ixe.O00000Oo(O00000o02, "tags");
        return O0000O0o.O00000o0(O00000o02);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Runnable runnable, ArrayList arrayList) {
        if (runnable != null) {
            runnable.run();
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
    /* access modifiers changed from: private */
    public static final void O000000o(Runnable runnable, Throwable th) {
        UwbLogUtil.d("UwbBindHelper", ixe.O000000o("refreshWithUpdateDevices : onRefreshClientDeviceFail ", (Object) th.getLocalizedMessage()));
        if (runnable != null) {
            runnable.run();
        }
    }

    @SuppressLint({"CheckResult"})
    public static Observable<ArrayList<O00000o0>> O00000Oo() {
        Set<String> O00000o02 = hzq.O00000o0();
        O0000O0o o0000O0o = O0000O0o.f14522O000000o;
        ixe.O00000Oo(O00000o02, "tags");
        return O0000O0o.O00000o0(O00000o02);
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u000b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0018\u00010\f2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0007J4\u0010\u0018\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f\u0018\u00010\f2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0011J,\u0010\u001a\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\rj\b\u0012\u0004\u0012\u00020\u001b`\u000f0\f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001dH\u0007J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001fH\u0007J6\u0010 \u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001b0\rj\b\u0012\u0004\u0012\u00020\u001b`\u000f0\f2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\b\b\u0002\u0010\"\u001a\u00020\u0013H\u0007J\u001c\u0010#\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007J\u0016\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010$\u001a\u00020\u0004H\u0007J \u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u001b0\rj\b\u0012\u0004\u0012\u00020\u001b`\u000f2\u0006\u0010(\u001a\u00020)H\u0002J\u0016\u0010*\u001a\u00020\u00152\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\rH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006."}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper$UwbTagApi;", "", "()V", "KEY_PREF_TAG_DETAIL_CACHE_KEY_PREFIX", "", "tagDetailStore", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "getTagDetailStore", "()Lcom/smarthome/uwb/ui/Store$SimpleStore;", "tagDetailStore$delegate", "Lkotlin/Lazy;", "associateUwbDevices", "Lio/reactivex/Observable;", "Ljava/util/ArrayList;", "Lcom/smarthome/uwb/ui/UwbBindHelper$UwbAssResult;", "Lkotlin/collections/ArrayList;", "assPair", "", "setHid", "", "clearAllTagDetailCache", "", "clearSpecialDetailCache", "tagDid", "dissociateUwbDevices", "dissPair", "getTagDetail", "Lcom/smarthome/uwb/ui/UwbBindHelper$UwbQueryResult;", "tag_ids", "", "getTagDetailCache", "", "getTagDetailRemote", "tag_id", "cache", "getTagMemberKeyCache", "tagId", "dev_did", "getTagMemberKeyRemote", "parseTagDetail", "response", "Lorg/json/JSONObject;", "saveToCache", "results", "uwbQueryResultParser", "json", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O0000O0o f14522O000000o = new O0000O0o();
        private static final itz O00000Oo = iua.O000000o(UwbBindHelper$UwbTagApi$tagDetailStore$2.f5670O000000o);

        private O0000O0o() {
        }

        private static dds.O000000o<String> O00000o0() {
            return (dds.O000000o) O00000Oo.O000000o();
        }

        public static Observable<ArrayList<O00000Oo>> O000000o(Map<String, String> map, boolean z) {
            ixe.O00000o(map, "assPair");
            UwbLogUtil.d("UwbBindHelper", "associateUwbDevices assPair " + map + ": ,setHid: " + z);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("hid_mode", z ? 1 : 0);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry next : map.entrySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("tag_id", (String) next.getKey());
                    jSONObject2.put("dev_did", (String) next.getValue());
                    iuh iuh = iuh.f1631O000000o;
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("associate_list", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/uwb/associate").O000000o(iuo.O000000o(new KeyValuePair("data", jSONObject.toString()))).O000000o(), $$Lambda$ddt$O0000O0o$btlWziZshNJtjz6_gOsKwVgiRw.INSTANCE).doOnError($$Lambda$ddt$O0000O0o$a1Un0joI2bSkeqT15vCutjCf2Ls.INSTANCE).onErrorReturn($$Lambda$ddt$O0000O0o$BJxrShcxj4K6wAWEg1TlP3OhsY.INSTANCE);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, org.json.JSONObject]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final ArrayList O00000Oo(JSONObject jSONObject) {
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("associateUwbDevices response ", (Object) jSONObject));
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("result");
            if (optJSONArray == null) {
                return arrayList;
            }
            int i = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i2 = i + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        int optInt = optJSONObject.optInt("code");
                        String optString = optJSONObject.optString("msg");
                        String optString2 = optJSONObject.optString("tag_id");
                        if (optString2 == null) {
                            optString2 = "";
                        }
                        String optString3 = optJSONObject.optString("dev_did");
                        if (optString3 == null) {
                            optString3 = "";
                        }
                        ixe.O00000Oo(optString, "msg");
                        arrayList.add(new O00000Oo(optString2, optString3, optInt, optString));
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final void O000000o(Throwable th) {
            UwbLogUtil.e("UwbBindHelper", ixe.O000000o("associateUwbDevices error: ", (Object) th.getMessage()));
        }

        /* access modifiers changed from: private */
        public static final ArrayList O00000Oo(Throwable th) {
            ixe.O00000o(th, "it");
            th.printStackTrace();
            return new ArrayList();
        }

        public static final Observable<String> O000000o(String str) {
            ixe.O00000o(str, "tagId");
            Observable<R> map = O00000o0(iuo.O000000o(str)).map($$Lambda$ddt$O0000O0o$N287MusL3KH9UaNK3VxFcVgOhR8.INSTANCE);
            ixe.O00000Oo(map, "getTagDetailRemote(listOf(tagId),false).map {\n                it.getOrNull(0)?.member_specific_key ?: \"\"\n            }");
            return map;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.iuy.O000000o(java.util.List, int):T
         arg types: [java.util.ArrayList, int]
         candidates:
          _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
          _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
          _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
          _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
          _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
          _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
          _m_j.iur.O000000o(java.lang.Iterable, int):int
          _m_j.iuy.O000000o(java.util.List, int):T */
        /* access modifiers changed from: private */
        public static final String O000000o(ArrayList arrayList) {
            ixe.O00000o(arrayList, "it");
            O00000o0 o00000o0 = (O00000o0) iuo.O000000o((List) arrayList, 0);
            return o00000o0 == null ? "" : o00000o0.O00000o0;
        }

        public static final String O000000o(String str, String str2) {
            Object obj;
            boolean z;
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            Iterator it = O00000Oo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                O00000o0 o00000o0 = (O00000o0) obj;
                if (!TextUtils.equals(o00000o0.f14521O000000o, str) || !TextUtils.equals(o00000o0.O00000Oo, str2)) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            O00000o0 o00000o02 = (O00000o0) obj;
            if (o00000o02 == null) {
                return "";
            }
            return o00000o02.O00000o0;
        }

        public static final void O000000o() {
            O00000o0().O00000Oo();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public static final void O00000Oo(String str) {
            ixe.O00000o(str, "tagDid");
            O00000o0().O000000o(ixe.O000000o("key_pref_tag_detail_cache_key_prefix", (Object) str), "");
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public static final List<O00000o0> O00000Oo() {
            Iterable<Pair> O000000o2 = O00000o0().O000000o(UwbBindHelper$UwbTagApi$getTagDetailCache$1.f5669O000000o);
            Collection arrayList = new ArrayList(iuo.O000000o(O000000o2, 10));
            for (Pair pair : O000000o2) {
                arrayList.add((O00000o0) pair.second);
            }
            List<O00000o0> list = (List) arrayList;
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getTagDetailCache: ", (Object) iuo.O000000o(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
            return list;
        }

        public static final Observable<ArrayList<O00000o0>> O000000o(Collection<String> collection) {
            ixe.O00000o(collection, "tag_ids");
            if (collection.isEmpty()) {
                UwbLogUtil.d("UwbBindHelper", "getTagDetail all devices size: " + fno.O000000o().O00000oO().size() + ", trace empty: " + Log.getStackTraceString(new Exception()));
            }
            Collection arrayList = new ArrayList();
            for (Object next : O00000Oo()) {
                if (collection.contains(((O00000o0) next).f14521O000000o)) {
                    arrayList.add(next);
                }
            }
            Observable<ArrayList<O00000o0>> concat = Observable.concat(Observable.just(arrayList), O00000o0(collection));
            ixe.O00000Oo(concat, "concat(\n                Observable.just(getTagDetailCache().filterTo(arrayListOf()) { it.tag_id in tag_ids }),\n                getTagDetailRemote(tag_ids)\n            )");
            return concat;
        }

        /* access modifiers changed from: private */
        public static Observable<ArrayList<O00000o0>> O00000o0(Collection<String> collection) {
            ixe.O00000o(collection, "tag_id");
            if (collection.isEmpty()) {
                UwbLogUtil.d("UwbBindHelper", "tagDetail parma all devices size: " + fno.O000000o().O00000oO().size() + ",trace empty: " + Log.getStackTraceString(new Exception()));
                Observable<ArrayList<O00000o0>> just = Observable.just(new ArrayList());
                ixe.O00000Oo(just, "just(arrayListOf())");
                return just;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tag_ids", new JSONArray((Collection<?>) iuo.O00000oo(collection)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Observable<ArrayList<O00000o0>> onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/uwb/detail").O000000o(iuo.O000000o(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss(collection) {
                /* class _m_j.$$Lambda$ddt$O0000O0o$1la0i6VzyZ9lF29sfekhxenMqeI */
                private final /* synthetic */ Collection f$0;

                {
                    this.f$0 = r1;
                }

                public final Object parse(JSONObject jSONObject) {
                    return ddt.O0000O0o.O000000o(this.f$0, jSONObject);
                }
            }).doOnError(new Consumer(collection) {
                /* class _m_j.$$Lambda$ddt$O0000O0o$HpOAFEq9a0eQ30p10xrS_H0rJFg */
                private final /* synthetic */ Collection f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    ddt.O0000O0o.O000000o(this.f$0, (Throwable) obj);
                }
            }).onErrorReturn($$Lambda$ddt$O0000O0o$Ju60xX43Jc81gPFwv2V7mVWPxY.INSTANCE);
            ixe.O00000Oo(onErrorReturn, "fetch(request) { response ->\n                UwbLogUtil.d(TAG, \"tagDetail parma: ${tag_id.joinToString()}\")\n                UwbLogUtil.d(TAG, \"tagDetail response: ${response}\")\n                val results = parseTagDetail(response)\n                saveToCache(results)\n                results\n\n            }.doOnError {\n                UwbLogUtil.d(TAG, \"tagDetail parma: ${tag_id.joinToString()}\")\n                UwbLogUtil.e(TAG, \"tagDetail error: ${it.message}\")\n            }.onErrorReturn {\n                it.printStackTrace()\n                kotlin.collections.ArrayList<UwbQueryResult>()\n            }");
            return onErrorReturn;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, org.json.JSONObject]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final ArrayList O000000o(Collection collection, JSONObject jSONObject) {
            ixe.O00000o(collection, "$tag_id");
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("tagDetail parma: ", (Object) iuo.O000000o(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("tagDetail response: ", (Object) jSONObject));
            ixe.O00000Oo(jSONObject, "response");
            ArrayList<O00000o0> O000000o2 = O000000o(jSONObject);
            Iterator<O00000o0> it = O000000o2.iterator();
            while (it.hasNext()) {
                O00000o0 next = it.next();
                dds.O000000o<String> O00000o0 = O00000o0();
                String O000000o3 = ixe.O000000o("key_pref_tag_detail_cache_key_prefix", (Object) next.f14521O000000o);
                ddt ddt = ddt.f14518O000000o;
                ixe.O00000Oo(next, "item");
                O00000o0.O000000o(O000000o3, ddt.O000000o(next));
            }
            return O000000o2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final void O000000o(Collection collection, Throwable th) {
            ixe.O00000o(collection, "$tag_id");
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("tagDetail parma: ", (Object) iuo.O000000o(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
            UwbLogUtil.e("UwbBindHelper", ixe.O000000o("tagDetail error: ", (Object) th.getMessage()));
        }

        /* access modifiers changed from: private */
        public static final ArrayList O00000o0(Throwable th) {
            ixe.O00000o(th, "it");
            th.printStackTrace();
            return new ArrayList();
        }

        public static O00000o0 O00000o0(String str) throws JSONException {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("tag_id");
            ixe.O00000Oo(string, "job.getString(\"tag_id\")");
            String string2 = jSONObject.getString("dev_did");
            ixe.O00000Oo(string2, "job.getString(\"dev_did\")");
            String string3 = jSONObject.getString("member_specific_key");
            ixe.O00000Oo(string3, "job.getString(\"member_specific_key\")");
            int optInt = jSONObject.optInt("hid_mode");
            int optInt2 = jSONObject.optInt("code", 0);
            String optString = jSONObject.optString("msg", "");
            ixe.O00000Oo(optString, "job.optString(\"msg\",\"\")");
            return new O00000o0(string, string2, string3, optInt, optInt2, optString);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        private static ArrayList<O00000o0> O000000o(JSONObject jSONObject) {
            String str;
            String str2;
            try {
                ArrayList<O00000o0> arrayList = new ArrayList<>();
                JSONArray optJSONArray = jSONObject.optJSONArray("uwb_details");
                if (optJSONArray == null) {
                    return arrayList;
                }
                int i = 0;
                int length = optJSONArray.length();
                if (length > 0) {
                    while (true) {
                        int i2 = i + 1;
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            int optInt = optJSONObject.optInt("code");
                            String optString = optJSONObject.optString("msg");
                            String optString2 = optJSONObject.optString("tag_id");
                            String str3 = optString2 == null ? "" : optString2;
                            String optString3 = optJSONObject.optString("dev_did");
                            if (optString3 == null) {
                                str = "";
                            } else {
                                str = optString3;
                            }
                            int optInt2 = optJSONObject.optInt("hid_mode");
                            String optString4 = optJSONObject.optString("member_specific_key");
                            if (optString4 == null) {
                                str2 = "";
                            } else {
                                str2 = optString4;
                            }
                            ixe.O00000Oo(optString, "msg");
                            arrayList.add(new O00000o0(str3, str, str2, optInt2, optInt, optString));
                        }
                        if (i2 >= length) {
                            break;
                        }
                        i = i2;
                    }
                }
                return arrayList;
            } catch (Exception e) {
                UwbLogUtil.e("UwbBindHelper", ixe.O000000o("parseTagDetail: ", (Object) e.getMessage()));
                return new ArrayList<>();
            }
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u001e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0007J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0007J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00102\u0006\u0010\u0014\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper$Permit;", "", "()V", "KEY_PREF_UWB_PERMIT", "", "PERMIT_ALL", "", "PERMIT_HOME", "intStore", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "getIntStore", "()Lcom/smarthome/uwb/ui/Store$SimpleStore;", "intStore$delegate", "Lkotlin/Lazy;", "getCachePermit", "getPermit", "Lio/reactivex/Observable;", "getUwbPermitRemote", "setPermitToCache", "", "permit", "setUwbPermitRemote", "", "tag_ids", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O000000o f14519O000000o = new O000000o();
        private static final itz O00000Oo = iua.O000000o(UwbBindHelper$Permit$intStore$2.f5661O000000o);

        private O000000o() {
        }

        private static dds.O000000o<Integer> O00000o0() {
            return (dds.O000000o) O00000Oo.O000000o();
        }

        public static final int O000000o() {
            Integer O000000o2 = O00000o0().O000000o("key_pref_uwb_permit");
            if (O000000o2 == null) {
                return -1;
            }
            return O000000o2.intValue();
        }

        private static void O000000o(int i) {
            O00000o0().O000000o("key_pref_uwb_permit", Integer.valueOf(i));
        }

        public static final Observable<Boolean> O000000o(int i, Collection<String> collection) {
            ixe.O00000o(collection, "tag_ids");
            UwbLogUtil.d("UwbBindHelper", "setUwbPermit begin parmas: permit : " + i + ", tag_id : " + collection);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tag_ids", new JSONArray((Collection<?>) iuo.O00000oo(collection)));
                jSONObject.put("permit_level", i);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Observable<Boolean> onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/uwb/set_permit").O000000o(iuo.O000000o(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss(i) {
                /* class _m_j.$$Lambda$ddt$O000000o$5hit39vakkiYUh_tnhFTiN3ozrw */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final Object parse(JSONObject jSONObject) {
                    return ddt.O000000o.O000000o(this.f$0, jSONObject);
                }
            }).doOnError($$Lambda$ddt$O000000o$Jt5KGrU4LV8ZS96Cev6fAJx2c0.INSTANCE).onErrorReturn($$Lambda$ddt$O000000o$972lUFtYNTtbd724gGavGJLU4_w.INSTANCE);
            ixe.O00000Oo(onErrorReturn, "fetch(request) { response ->\n                UwbLogUtil.d(TAG, \"setUwbPermit response: ${response}\")\n                val isSuccess = response.getInt(\"set_permit_result\") == 1\n                if (isSuccess) {\n                    setPermitToCache(permit)\n                }\n                isSuccess\n            }.doOnError {\n                UwbLogUtil.e(TAG, \"setUwbPermit error: ${it.message}\")\n            }.onErrorReturn {\n                it.printStackTrace()\n                false\n            }");
            return onErrorReturn;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, org.json.JSONObject]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final Boolean O000000o(int i, JSONObject jSONObject) {
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("setUwbPermit response: ", (Object) jSONObject));
            boolean z = true;
            if (jSONObject.getInt("set_permit_result") != 1) {
                z = false;
            }
            if (z) {
                O000000o(i);
            }
            return Boolean.valueOf(z);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final void O000000o(Throwable th) {
            UwbLogUtil.e("UwbBindHelper", ixe.O000000o("setUwbPermit error: ", (Object) th.getMessage()));
        }

        /* access modifiers changed from: private */
        public static final Boolean O00000Oo(Throwable th) {
            ixe.O00000o(th, "it");
            th.printStackTrace();
            return Boolean.FALSE;
        }

        public static final Observable<Integer> O00000Oo() {
            UwbLogUtil.d("UwbBindHelper", "getUwbPermit begin parmas:");
            Observable<Integer> onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/uwb/get_permit").O000000o(iuo.O000000o(new KeyValuePair("data", new JSONObject().toString()))).O000000o(), $$Lambda$ddt$O000000o$B3bWOQIoqLGGz0wssCs37wyvJ7Q.INSTANCE).doOnNext($$Lambda$ddt$O000000o$59YysOCtqzw4EhOYYgscGXT9EAU.INSTANCE).doOnError($$Lambda$ddt$O000000o$MdM48EYBcc74JWU3QFT4DP1Vtc8.INSTANCE).onErrorReturn($$Lambda$ddt$O000000o$eqBrA5koV2fCAbX6abGMPv_tGls.INSTANCE);
            ixe.O00000Oo(onErrorReturn, "fetch(request) { response ->\n                UwbLogUtil.d(TAG, \"getUwbPermit response: ${response}\")\n                response.getInt(\"permit_level\")\n            }.doOnNext {\n                setPermitToCache(it)\n            }.doOnError {\n                UwbLogUtil.e(TAG, \"getUwbPermit error: ${it.message}\")\n            }.onErrorReturn { 0 }");
            return onErrorReturn;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, org.json.JSONObject]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final Integer O000000o(JSONObject jSONObject) {
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getUwbPermit response: ", (Object) jSONObject));
            return Integer.valueOf(jSONObject.getInt("permit_level"));
        }

        /* access modifiers changed from: private */
        public static final void O000000o(Integer num) {
            ixe.O00000Oo(num, "it");
            O000000o(num.intValue());
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final void O00000o0(Throwable th) {
            UwbLogUtil.e("UwbBindHelper", ixe.O000000o("getUwbPermit error: ", (Object) th.getMessage()));
        }

        /* access modifiers changed from: private */
        public static final Integer O00000o(Throwable th) {
            ixe.O00000o(th, "it");
            return 0;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016H\u0007J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0016J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0000H\u0007J]\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u0002H\u001f0\u001ej\b\u0012\u0004\u0012\u0002H\u001f` \"\u0004\b\u0000\u0010\u001f*\u00020!2\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u0002H\u001f0\u001ej\b\u0012\u0004\u0012\u0002H\u001f` 2!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110%¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0004\u0012\u0002H\u001f0$H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\t8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/smarthome/uwb/ui/UwbBindHelper$UwbSupportConfigManager;", "Lcom/xiaomi/smarthome/uwb_external/IUwbSupportConfigApi;", "()V", "KEY_PREF_UWB_CONFIG", "", "KEY_PREF_UWB_CONFIG_UPDATE_TIME", "TIME_OUT_TIME", "", "longStore", "Lcom/smarthome/uwb/ui/Store$SimpleStore;", "", "getLongStore", "()Lcom/smarthome/uwb/ui/Store$SimpleStore;", "longStore$delegate", "Lkotlin/Lazy;", "stringStore", "getStringStore", "stringStore$delegate", "testData", "getCacheConfig", "Lcom/xiaomi/smarthome/uwb_external/UwbSupportConfig;", "getRemoteConfig", "Lio/reactivex/Observable;", "getSupportConfig", "getUpdateTime", "parseConfig", "job", "Lorg/json/JSONObject;", "provideInstance", "mapToList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "Lorg/json/JSONArray;", "dest", "mapper", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "el", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @RouterService
    public static final class O00000o implements hzh {
        public static final O00000o INSTANCE = new O00000o();
        private static final itz longStore$delegate = iua.O000000o(UwbBindHelper$UwbSupportConfigManager$longStore$2.f5662O000000o);
        private static final itz stringStore$delegate = iua.O000000o(UwbBindHelper$UwbSupportConfigManager$stringStore$2.f5668O000000o);
        private static final String testData = "{\n    \"code\": 0,\n    \"msg\": \"\",\n    \"result\": {\n        \"content\": {\n            \"isUwbEnable\": 1,\n            \"startVersionCode:\":-1,\n            \"speak_platform_config\": {\n                \"android\": [\n                    \"xiaomi.wifispeaker.x08a\",\n                    \"xiaomi.wifispeaker.x08c\",\n                    \"xiaomi.wifispeaker.l04m\",\n                    \"xiaomi.wifispeaker.lx04\",\n                    \"xiaomi.wifispeaker.x08e\"\n                ],\n                \"linux\": [\n                    \"xiaomi.wifispeaker.l09b\",\n                    \"xiaomi.wifispeaker.l15a\",\n                    \"xiaomi.wifispeaker.lx01\",\n                    \"xiaomi.wifispeaker.lx05\",\n                    \"xiaomi.wifispeaker.l05c\",\n                    \"xiaomi.wifispeaker.lx0b\",\n                    \"xiaomi.wifispeaker.lx5a\",\n                    \"xiaomi.wifispeaker.lx06\",\n                    \"xiaomi.wifispeaker.l06a\",\n                    \"xiaomi.wifispeaker.l07a\",\n                    \"xiaomi.wifispeaker.l09a\",\n                    \"xiaomi.wifispeaker.l16a\"\n                ]\n            },\n            \"uwb_support\": {\n                \"models\": [],\n                \"cates\": [],\n                \"black_models\":[\n                    \"midea.aircondition.xa2\",\n                    \"midea.aircondition.xa1\",\n                    \"yeelink.light.nl1\",\n                    \"roidmi.vacuum.v1\",\n                    \"yeelink.light.color7\",\n                    \"idelan.aircondition.v2\",\n                    \"aux.aircondition.v1\",\n                    \"midea.aircondition.v1\",\n                    \"zhimi.airpurifier.mc2\",\n                    \"zhimi.airpurifier.mc1\",\n                    \"viomi.vacuum.v8\"\n                ]\n            }\n        }\n    }\n}";

        private O00000o() {
        }

        private final dds.O000000o<Long> getLongStore() {
            return (dds.O000000o) longStore$delegate.O000000o();
        }

        private final dds.O000000o<String> getStringStore() {
            return (dds.O000000o) stringStore$delegate.O000000o();
        }

        @cug
        public static final O00000o provideInstance() {
            return INSTANCE;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, _m_j.hzk]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final Observable<hzk> getSupportConfig() {
            if (System.currentTimeMillis() - getUpdateTime() < 14400000) {
                hzk cacheConfig = getCacheConfig();
                UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getSupportConfig use cache cacheConfig: ", (Object) cacheConfig));
                if (cacheConfig != null) {
                    Observable<hzk> just = Observable.just(cacheConfig);
                    ixe.O00000Oo(just, "just(cacheConfig)");
                    return just;
                }
            }
            return getRemoteConfig();
        }

        private final long getUpdateTime() {
            Long O000000o2 = getLongStore().O000000o("key_pref_uwb_config_update_time");
            if (O000000o2 == null) {
                return 0;
            }
            return O000000o2.longValue();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final hzk getCacheConfig() {
            Object obj;
            String O000000o2 = getStringStore().O000000o("key_pref_uwb_config");
            if (O000000o2 == null) {
                O000000o2 = testData;
            }
            if (ixe.O000000o((Object) O000000o2, (Object) "")) {
                return null;
            }
            try {
                Result.O000000o o000000o = Result.f15374O000000o;
                obj = Result.O00000o0(INSTANCE.parseConfig(new JSONObject(O000000o2)));
            } catch (Throwable th) {
                Result.O000000o o000000o2 = Result.f15374O000000o;
                obj = Result.O00000o0(iue.O000000o(th));
            }
            if (Result.O000000o(obj)) {
                obj = null;
            }
            return (hzk) obj;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public static final Observable<hzk> getRemoteConfig() {
            UwbLogUtil.d("UwbBindHelper", "getRemoteConfig begin");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", "zh_CN");
                jSONObject.put("name", ixe.O000000o("android_uwb_support_config", (Object) (gfr.O0000oo0 ? "_preview" : "")));
                jSONObject.put("version", "1");
            } catch (Exception unused) {
            }
            String str = hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + ((Object) URLEncoder.encode(jSONObject.toString(), "UTF-8"));
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getRemoteConfig response from url: ", (Object) str));
            gsj.O000000o o000000o = new gsj.O000000o();
            o000000o.f18212O000000o = "GET";
            Observable<hzk> onErrorReturn = fsv.O000000o(o000000o.O00000Oo(str).O000000o(), $$Lambda$ddt$O00000o$idOqtxjHV26Odgml_3ugsDGdOXo.INSTANCE).doOnError($$Lambda$ddt$O00000o$CKRQ7z1CJ1Aby4_Jr46hrT3OKTQ.INSTANCE).onErrorReturn($$Lambda$ddt$O00000o$LbWIi2B0giAtuAhMaxqjBiXMaU8.INSTANCE);
            ixe.O00000Oo(onErrorReturn, "fetch(request) { job ->\n                UwbLogUtil.d(TAG, \"getRemoteConfig response ${job}\")\n                stringStore[KEY_PREF_UWB_CONFIG] = job.toString()\n                longStore[KEY_PREF_UWB_CONFIG_UPDATE_TIME] = System.currentTimeMillis()\n                parseConfig(job)\n            }.doOnError {\n                UwbLogUtil.e(TAG, \"getRemoteConfig error ${it.message}\")\n            }.onErrorReturn { UwbSupportConfig() }");
            return onErrorReturn;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, org.json.JSONObject]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        /* renamed from: getRemoteConfig$lambda-1  reason: not valid java name */
        public static final hzk m579getRemoteConfig$lambda1(JSONObject jSONObject) {
            UwbLogUtil.d("UwbBindHelper", ixe.O000000o("getRemoteConfig response ", (Object) jSONObject));
            dds.O000000o<String> stringStore = INSTANCE.getStringStore();
            String jSONObject2 = jSONObject.toString();
            ixe.O00000Oo(jSONObject2, "job.toString()");
            stringStore.O000000o("key_pref_uwb_config", jSONObject2);
            INSTANCE.getLongStore().O000000o("key_pref_uwb_config_update_time", Long.valueOf(System.currentTimeMillis()));
            O00000o o00000o = INSTANCE;
            ixe.O00000Oo(jSONObject, "job");
            return o00000o.parseConfig(jSONObject);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        /* renamed from: getRemoteConfig$lambda-2  reason: not valid java name */
        public static final void m580getRemoteConfig$lambda2(Throwable th) {
            UwbLogUtil.e("UwbBindHelper", ixe.O000000o("getRemoteConfig error ", (Object) th.getMessage()));
        }

        /* access modifiers changed from: private */
        /* renamed from: getRemoteConfig$lambda-3  reason: not valid java name */
        public static final hzk m581getRemoteConfig$lambda3(Throwable th) {
            ixe.O00000o(th, "it");
            return new hzk();
        }

        private final hzk parseConfig(JSONObject jSONObject) {
            List list;
            List list2;
            List list3;
            JSONArray jSONArray;
            List list4;
            List list5;
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            JSONArray jSONArray2 = null;
            String optString = optJSONObject == null ? null : optJSONObject.optString("content");
            if (optString == null) {
                return new hzk();
            }
            JSONObject jSONObject2 = new JSONObject(optString);
            boolean z = jSONObject2.optInt("isUwbEnable") == 1;
            int optInt = jSONObject2.optInt("startVersionCode", -1);
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("uwb_support");
            JSONArray optJSONArray = optJSONObject2 == null ? null : optJSONObject2.optJSONArray("models");
            if (optJSONArray == null) {
                list = EmptyList.f15376O000000o;
            } else {
                list = mapToList(optJSONArray, new ArrayList(), UwbBindHelper$UwbSupportConfigManager$parseConfig$models$1.f5665O000000o);
            }
            List list6 = list;
            JSONObject optJSONObject3 = jSONObject2.optJSONObject("uwb_support");
            JSONArray optJSONArray2 = optJSONObject3 == null ? null : optJSONObject3.optJSONArray("cates");
            if (optJSONArray2 == null) {
                list2 = EmptyList.f15376O000000o;
            } else {
                list2 = mapToList(optJSONArray2, new ArrayList(), UwbBindHelper$UwbSupportConfigManager$parseConfig$categories$1.f5664O000000o);
            }
            List list7 = list2;
            JSONObject optJSONObject4 = jSONObject2.optJSONObject("uwb_support");
            JSONArray optJSONArray3 = optJSONObject4 == null ? null : optJSONObject4.optJSONArray("black_models");
            if (optJSONArray3 == null) {
                list3 = EmptyList.f15376O000000o;
            } else {
                list3 = mapToList(optJSONArray3, new ArrayList(), UwbBindHelper$UwbSupportConfigManager$parseConfig$blackModels$1.f5663O000000o);
            }
            List list8 = list3;
            JSONObject optJSONObject5 = jSONObject2.optJSONObject("speak_platform_config");
            if (optJSONObject5 == null) {
                jSONArray = null;
            } else {
                jSONArray = optJSONObject5.optJSONArray("android");
            }
            if (jSONArray == null) {
                list4 = EmptyList.f15376O000000o;
            } else {
                list4 = mapToList(jSONArray, new ArrayList(), UwbBindHelper$UwbSupportConfigManager$parseConfig$speakPlatformConfig$1.f5666O000000o);
            }
            if (optJSONObject5 != null) {
                jSONArray2 = optJSONObject5.optJSONArray("linux");
            }
            if (jSONArray2 == null) {
                list5 = EmptyList.f15376O000000o;
            } else {
                list5 = mapToList(jSONArray2, new ArrayList(), UwbBindHelper$UwbSupportConfigManager$parseConfig$speakPlatformConfig$2.f5667O000000o);
            }
            return new hzk(z, optInt, new hzi(list4, list5), list6, list7, list8);
        }

        private final <T> ArrayList<T> mapToList(JSONArray jSONArray, ArrayList<T> arrayList, iwc<Object, ? extends T> iwc) {
            int length = jSONArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    Object obj = jSONArray.get(i);
                    ixe.O00000Oo(obj, "get(index)");
                    arrayList.add(iwc.invoke(obj));
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.Collection] */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean):int
     arg types: [java.lang.CharSequence, java.lang.String, int, int]
     candidates:
      _m_j.iyx.O000000o(java.lang.CharSequence, char, int, boolean):int
      _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean):int */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: ?
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    public static boolean O000000o(_m_j.hzk r8, java.lang.String r9) {
        /*
            java.util.List<java.lang.String> r0 = r8.O00000o
            boolean r0 = r0.contains(r9)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager r0 = com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager.instance
            com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo r0 = r0.getPluginInfo(r9)
            r2 = 6
            java.lang.Integer[] r2 = new java.lang.Integer[r2]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r1)
            r2[r1] = r3
            r3 = 3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r5 = 1
            r2[r5] = r4
            r4 = 2
            r6 = 8
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r2[r4] = r6
            r4 = 15
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r3 = 4
            r4 = 16
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            r3 = 5
            r4 = 17
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2[r3] = r4
            int r0 = r0.O0000o()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r0 = _m_j.iuj.O000000o(r2, r0)
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x0054
            return r1
        L_0x0054:
            java.util.List<java.lang.String> r0 = r8.O00000Oo
            boolean r0 = r0.contains(r9)
            if (r0 == 0) goto L_0x005d
            return r5
        L_0x005d:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r0 = "."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            java.lang.String r2 = "receiver$0"
            _m_j.ixe.O00000o0(r9, r2)
            java.lang.String r3 = "delimiters"
            _m_j.ixe.O00000o0(r0, r3)
            r3 = r0[r1]
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x007c
            r4 = 1
            goto L_0x007d
        L_0x007c:
            r4 = 0
        L_0x007d:
            r6 = 10
            if (r4 != 0) goto L_0x00c2
            int r0 = _m_j.iyo.O000000o(r9, r3, r1, r1)
            r4 = -1
            if (r0 != r4) goto L_0x0092
            java.lang.String r9 = r9.toString()
            java.util.List r9 = _m_j.iuo.O000000o(r9)
            goto L_0x0115
        L_0x0092:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r6)
            r2 = r0
            r0 = 0
        L_0x0099:
            java.lang.CharSequence r0 = r9.subSequence(r0, r2)
            java.lang.String r0 = r0.toString()
            r7.add(r0)
            int r0 = r3.length()
            int r0 = r0 + r2
            int r2 = _m_j.iyo.O000000o(r9, r3, r0, r1)
            if (r2 != r4) goto L_0x0099
            int r1 = r9.length()
            java.lang.CharSequence r9 = r9.subSequence(r0, r1)
            java.lang.String r9 = r9.toString()
            r7.add(r9)
            r9 = r7
            java.util.List r9 = (java.util.List) r9
            goto L_0x0115
        L_0x00c2:
            java.util.List r0 = _m_j.iuj.O000000o(r0)
            _m_j.iyn r3 = new _m_j.iyn
            kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4 r4 = new kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
            r4.<init>(r0, r1)
            _m_j.iwn r4 = (_m_j.iwn) r4
            r3.<init>(r9, r1, r1, r4)
            _m_j.iyb r3 = (_m_j.iyb) r3
            _m_j.ixe.O00000o0(r3, r2)
            _m_j.iyj$O000000o r0 = new _m_j.iyj$O000000o
            r0.<init>(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = _m_j.iuo.O000000o(r0, r6)
            r1.<init>(r3)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00ed:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0112
            java.lang.Object r3 = r0.next()
            _m_j.ixr r3 = (_m_j.ixr) r3
            _m_j.ixe.O00000o0(r9, r2)
            java.lang.String r4 = "range"
            _m_j.ixe.O00000o0(r3, r4)
            int r4 = r3.f1645O000000o
            int r3 = r3.O00000Oo
            int r3 = r3 + r5
            java.lang.CharSequence r3 = r9.subSequence(r4, r3)
            java.lang.String r3 = r3.toString()
            r1.add(r3)
            goto L_0x00ed
        L_0x0112:
            r9 = r1
            java.util.List r9 = (java.util.List) r9
        L_0x0115:
            java.lang.Object r9 = _m_j.iuo.O000000o(r9, r5)
            java.lang.String r9 = (java.lang.String) r9
            java.util.List<java.lang.String> r8 = r8.O00000o0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            boolean r8 = _m_j.iuo.O000000o(r8, r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "UwbSupportConfig.isSupport categoryId : "
            r0.<init>(r1)
            r0.append(r9)
            java.lang.String r9 = " in supportModels =  "
            r0.append(r9)
            r0.append(r8)
            java.lang.String r9 = r0.toString()
            java.lang.String r0 = "UwbBindHelper"
            com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil.d(r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: _m_j.ddt.O000000o(_m_j.hzk, java.lang.String):boolean");
    }
}
