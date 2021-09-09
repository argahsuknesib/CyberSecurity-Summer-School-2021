package _m_j;

import _m_j.gti;
import _m_j.hcc;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.instance.Spec;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.newui.card.State;
import com.xiaomi.smarthome.newui.mainpage.cache.FreqCameraManager$userFreqCameras$2;
import com.xiaomi.smarthome.newui.mainpage.cache.FreqCameraManager$userFreqCameras$3;
import com.xiaomi.smarthome.newui.mainpage.cache.FreqCameraManager$userFreqCameras$4;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J(\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u0018\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003J\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\f2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\u001fJ0\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0%2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\b\b\u0002\u0010'\u001a\u00020\u000eH\u0007J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000e0%2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0006\u0010*\u001a\u00020\u0014J\u001e\u0010+\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00042\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\u0016\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010J\u0018\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u000eH\u0002J\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0%\"\u0004\b\u0000\u001002\u0006\u0010.\u001a\u00020\u0004J\u0016\u00101\u001a\b\u0012\u0004\u0012\u00020\u001a0\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u00102\u001a\b\u0012\u0004\u0012\u00020\u001a0\f*\b\u0012\u0004\u0012\u00020\u001f0\fH\u0007J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0\f*\b\u0012\u0004\u0012\u00020\u00040\fH\u0007J\f\u00104\u001a\u00020\u000e*\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/xiaomi/smarthome/newui/mainpage/cache/FreqCameraManager;", "", "()V", "ACTION_FREQ_CAMERA_UPDATE", "", "PATH_ADD", "PATH_REMOVE", "TAG", "blockModel", "", "[Ljava/lang/String;", "cacheOrder", "", "setFirstCameraGuideDone", "", "clrbit", "", "x", "y", "comCameraResultHandle", "", "result", "Lorg/json/JSONObject;", "srcDids", "comFlag", "getFreqCameraOnFirstUpdate", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "home", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "getLatestFreqCameras", "getUnFreqCameras", "Lcom/xiaomi/smarthome/device/Device;", "homeId", "isDevicePowerOn", "device", "isFreqCamera", "markAsFreq", "Lio/reactivex/Observable;", "dids", "force", "markAsUnFreq", "freqCameras", "notifyDataChanged", "saveFreqCameraOrder", "setBit", "setCameraComFlag", "did", "setPowerProp", "T", "userFreqCameras", "mapCameraDevicesToCameraModel", "mapCameraDidsToCameraModel", "parsePowerPropIsOn", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hfy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final hfy f18887O000000o = new hfy();
    private static final List<String> O00000Oo;
    private static final String[] O00000o = {"chuangmi.gateway.ipc011"};
    private static boolean O00000o0;

    private hfy() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.util.List<java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        List<String> list;
        hfz hfz = hfz.f18889O000000o;
        Iterable O00000oo = hfz.O00000oo();
        if (O00000oo == null) {
            list = null;
        } else {
            Iterable<MainCameraCardModel> iterable = O00000oo;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (MainCameraCardModel mainCameraCardModel : iterable) {
                arrayList.add(mainCameraCardModel.f10175O000000o);
            }
            list = arrayList;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        O00000Oo = list;
    }

    public static boolean O000000o(Device device) {
        Integer num = null;
        if (!iuj.O000000o(O00000o, device == null ? null : device.model) && gge.O00000Oo(device)) {
            if (device != null) {
                num = Integer.valueOf(device.comFlag);
            }
            if (num != null && (num.intValue() & 2) == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List<com.xiaomi.smarthome.device.Device>, _m_j.hfy$O000000o]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.util.List, int):T
     arg types: [java.util.List<com.xiaomi.smarthome.device.Device>, int]
     candidates:
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.util.List, int):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>):io.reactivex.Observable<java.lang.Boolean>
      _m_j.hfy.O000000o(java.util.List, org.json.JSONObject):java.lang.Boolean
      _m_j.hfy.O000000o(kotlin.jvm.internal.Ref$ObjectRef, java.lang.Boolean):void
      _m_j.hfy.O000000o(java.lang.String, boolean):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean>
     arg types: [com.xiaomi.smarthome.homeroom.model.Home, java.util.List, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hcc$O000000o, io.reactivex.ObservableEmitter):void
      _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean> */
    @SuppressLint({"CheckResult"})
    private final List<MainCameraCardModel> O00000Oo(Home home) {
        Object obj;
        boolean z;
        ggb.O00000Oo();
        if (!ggb.O0000Ooo(home.getId()) || O00000o0) {
            return null;
        }
        List<gti.O000000o> O00000o02 = gti.O000000o().O00000o0();
        ixe.O00000Oo(O00000o02, "getInstance()\n                        .sortedGroupInfo");
        Iterator it = O00000o02.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            gti.O000000o o000000o = (gti.O000000o) obj;
            if (o000000o == null || fno.O000000o().O000000o(o000000o.f18248O000000o) == null) {
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
        gti.O000000o o000000o2 = (gti.O000000o) obj;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = fno.O000000o().O000000o(o000000o2 == null ? null : o000000o2.f18248O000000o);
        if (objectRef.element == null) {
            gsy.O00000Oo(LogType.CARD, "FreqCameraManager", "getFreqCameraOnFirstUpdate: from all page is null");
            List<Device> O0000oOO = ggb.O00000Oo().O0000oOO(home.getId());
            ixe.O00000Oo(O0000oOO, "");
            if (O0000oOO.size() > 1) {
                iuo.O000000o((List) O0000oOO, (Comparator) new O000000o());
            }
            ixe.O00000Oo(O0000oOO, "allCamera");
            objectRef.element = iuo.O000000o((List) O0000oOO, 0);
            LogType logType = LogType.CARD;
            Device device = (Device) objectRef.element;
            gsy.O00000Oo(logType, "FreqCameraManager", ixe.O000000o("getFreqCameraOnFirstUpdate: from current home is ", (Object) (device == null ? null : device.did)));
            if (objectRef.element == null) {
                return null;
            }
        }
        O00000o0 = true;
        List<MainCameraCardModel> O00000Oo2 = O00000Oo(iuo.O000000o((Object) objectRef.element));
        String str = ((Device) objectRef.element).did;
        ixe.O00000Oo(str, "firstCamera.did");
        O000000o(str, true);
        O000000o(home, (List<String>) iuo.O000000o(((Device) objectRef.element).did), true).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$hfy$Tc8YE943OtgBbLHSXLK5V09NRyI */

            public final void accept(Object obj) {
                hfy.O000000o(Ref.ObjectRef.this, (Boolean) obj);
            }
        });
        return O00000Oo2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>):io.reactivex.Observable<java.lang.Boolean>
      _m_j.hfy.O000000o(java.util.List, org.json.JSONObject):java.lang.Boolean
      _m_j.hfy.O000000o(kotlin.jvm.internal.Ref$ObjectRef, java.lang.Boolean):void
      _m_j.hfy.O000000o(java.lang.String, boolean):void */
    /* access modifiers changed from: private */
    public static final void O000000o(Ref.ObjectRef objectRef, Boolean bool) {
        ixe.O00000o(objectRef, "$firstCamera");
        if (!bool.booleanValue()) {
            String str = ((Device) objectRef.element).did;
            ixe.O00000Oo(str, "firstCamera.did");
            O000000o(str, false);
        }
    }

    private static List<MainCameraCardModel> O00000o0(Home home) {
        ggb.O00000Oo();
        List<String> O0000OoO = ggb.O0000OoO(home.getId());
        ixe.O00000Oo(O0000OoO, "getInstance().getFreqOrderByHomeId(home.id)");
        if (O0000OoO.isEmpty()) {
            O0000OoO = O00000Oo;
        }
        List<String> list = O0000OoO;
        List<Device> O0000oOO = ggb.O00000Oo().O0000oOO(home.getId());
        ixe.O00000Oo(O0000oOO, "getInstance().getAllCamerasByHomeId(home.id)");
        Collection arrayList = new ArrayList();
        for (Object next : O0000oOO) {
            if (O000000o((Device) next)) {
                arrayList.add(next);
            }
        }
        List<MainCameraCardModel> O000000o2 = iuo.O000000o((Collection) O00000Oo((List) arrayList));
        StringBuilder sb = new StringBuilder("userFreqCameras: order: ");
        sb.append(iuo.O000000o(list, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63));
        sb.append(" ,cameras : ");
        Iterable<MainCameraCardModel> iterable = O000000o2;
        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
        for (MainCameraCardModel mainCameraCardModel : iterable) {
            arrayList2.add(mainCameraCardModel.f10175O000000o);
        }
        sb.append((List) arrayList2);
        gsy.O000000o(3, "FreqCameraManager", sb.toString());
        ggv.O000000o(list, O000000o2, FreqCameraManager$userFreqCameras$2.f10246O000000o, FreqCameraManager$userFreqCameras$3.f10247O000000o, FreqCameraManager$userFreqCameras$4.f10248O000000o, "");
        return O000000o2;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O000000o<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((Device) t).did, ((Device) t2).did);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000Oo<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((Device) t).orderTimeJString, ((Device) t2).orderTimeJString);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List<com.xiaomi.smarthome.device.Device>, _m_j.hfy$O00000Oo]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    public static List<Device> O000000o(String str) {
        ixe.O00000o(str, "homeId");
        List<Device> O0000oOO = ggb.O00000Oo().O0000oOO(str);
        ixe.O00000Oo(O0000oOO, "latest");
        if (O0000oOO.size() > 1) {
            iuo.O000000o((List) O0000oOO, (Comparator) new O00000Oo());
        }
        Collection arrayList = new ArrayList();
        for (Object next : O0000oOO) {
            if (!O000000o((Device) next)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public static Observable<Boolean> O000000o(Home home, List<String> list) {
        ixe.O00000o(list, "freqCameras");
        Iterable iterable = list;
        gsy.O000000o(3, "FreqCameraManager", ixe.O000000o("markAsUnFreq: ", (Object) iuo.O000000o(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
        if (home == null || !home.isOwner()) {
            Observable<Boolean> just = Observable.just(Boolean.FALSE);
            ixe.O00000Oo(just, "just(false)");
            return just;
        }
        Collection arrayList = new ArrayList();
        for (Object next : iterable) {
            if (O000000o(fno.O000000o().O000000o((String) next))) {
                arrayList.add(next);
            }
        }
        List list2 = (List) arrayList;
        JSONObject jSONObject = new JSONObject();
        List arrayList2 = new ArrayList();
        try {
            String id = home.getId();
            ixe.O00000Oo(id, "home.id");
            jSONObject.put("homeId", Long.parseLong(id));
            jSONObject.put("dids", new JSONArray((Collection<?>) list2));
            arrayList2.add(new KeyValuePair("data", jSONObject.toString()));
        } catch (JSONException unused) {
        }
        Observable<Boolean> onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/home/freq_camera_del").O000000o(arrayList2).O000000o(), new fss(list) {
            /* class _m_j.$$Lambda$hfy$YdVvjZpiBGVqXtf3BTonkgmGBD4 */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Object parse(JSONObject jSONObject) {
                return hfy.O000000o(this.f$0, jSONObject);
            }
        }).doOnComplete($$Lambda$hfy$T4nxuogBr3CrYhJCh_bkFop7tic.INSTANCE).onErrorReturn($$Lambda$hfy$Q8kN0DPk0tTI1QSn57KZ9NSZXRk.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "fetch(request) { response ->\n            comCameraResultHandle(response, freqCameras, false)\n            true\n        }.doOnComplete {\n            notifyDataChanged()\n        }.onErrorReturn {\n            false\n        }");
        return onErrorReturn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void
     arg types: [org.json.JSONObject, java.util.List, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean>
      _m_j.hfy.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hcc$O000000o, io.reactivex.ObservableEmitter):void
      _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void */
    /* access modifiers changed from: private */
    public static final Boolean O000000o(List list, JSONObject jSONObject) {
        ixe.O00000o(list, "$freqCameras");
        f18887O000000o.O000000o(jSONObject, (List<String>) list, false);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo() {
        O000000o();
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.util.List<java.lang.String>} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    public static Observable<Boolean> O000000o(Home home, List<String> list, boolean z) {
        List<String> list2;
        ixe.O00000o(list, "dids");
        Iterable iterable = list;
        gsy.O000000o(3, "FreqCameraManager", ixe.O000000o("markAsFreq: ", (Object) iuo.O000000o(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63)));
        if (home == null || !home.isOwner()) {
            Observable<Boolean> just = Observable.just(Boolean.FALSE);
            ixe.O00000Oo(just, "just(false)");
            return just;
        }
        if (z) {
            list2 = list;
        } else {
            Collection arrayList = new ArrayList();
            for (Object next : iterable) {
                if (gge.O00000Oo(fno.O000000o().O000000o((String) next))) {
                    arrayList.add(next);
                }
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : (List) arrayList) {
                if (!O000000o(fno.O000000o().O000000o((String) next2))) {
                    arrayList2.add(next2);
                }
            }
            list2 = (List) arrayList2;
        }
        JSONObject jSONObject = new JSONObject();
        List arrayList3 = new ArrayList();
        try {
            String id = home.getId();
            ixe.O00000Oo(id, "home.id");
            jSONObject.put("homeId", Long.parseLong(id));
            jSONObject.put("dids", new JSONArray((Collection<?>) list2));
            arrayList3.add(new KeyValuePair("data", jSONObject.toString()));
        } catch (JSONException unused) {
        }
        Observable<Boolean> onErrorReturn = fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/home/freq_camera_set").O000000o(arrayList3).O000000o(), new fss(list) {
            /* class _m_j.$$Lambda$hfy$yHi9IGU5tU4aOllsc1mtMdWhDzU */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final Object parse(JSONObject jSONObject) {
                return hfy.O00000Oo(this.f$0, jSONObject);
            }
        }).doOnComplete($$Lambda$hfy$2uP1rhBkFeMn9ylRSQ3jr9kKZgc.INSTANCE).onErrorReturn($$Lambda$hfy$6OLjxyKyPjF9P4cSrymRSXjspw.INSTANCE);
        ixe.O00000Oo(onErrorReturn, "fetch(request) { response ->\n            comCameraResultHandle(response, dids, true)\n            true\n        }.doOnComplete {\n            notifyDataChanged()\n        }.onErrorReturn {\n            false\n        }");
        return onErrorReturn;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void
     arg types: [org.json.JSONObject, java.util.List, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean>
      _m_j.hfy.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hcc$O000000o, io.reactivex.ObservableEmitter):void
      _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void */
    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(List list, JSONObject jSONObject) {
        ixe.O00000o(list, "$dids");
        f18887O000000o.O000000o(jSONObject, (List<String>) list, true);
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static final void O00000o0() {
        O000000o();
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Throwable th) {
        ixe.O00000o(th, "it");
        return Boolean.FALSE;
    }

    public static void O000000o() {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("action_freq_camera_update"));
    }

    private final void O000000o(JSONObject jSONObject, List<String> list, boolean z) {
        int length;
        if (jSONObject != null && jSONObject.optInt("succ_count") > 0) {
            JSONArray optJSONArray = jSONObject.optJSONArray("fail_list");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    String optString = optJSONArray.optString(i2);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            iuo.O000000o((Collection) list).removeAll(arrayList);
            int size = list.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i4 = i + 1;
                    O000000o(list.get(i), z);
                    if (i4 <= size) {
                        i = i4;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private static void O000000o(String str, boolean z) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 != null) {
            O000000o2.comFlag = z ? O000000o2.comFlag | 2 : O000000o2.comFlag & -3;
        }
    }

    public static List<MainCameraCardModel> O000000o(List<String> list) {
        ixe.O00000o(list, "<this>");
        Collection arrayList = new ArrayList();
        for (String O000000o2 : list) {
            Device O000000o3 = fno.O000000o().O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        return O00000Oo((List) arrayList);
    }

    private static List<MainCameraCardModel> O00000Oo(List<? extends Device> list) {
        ixe.O00000o(list, "<this>");
        Iterable<Device> iterable = list;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (Device device : iterable) {
            String str = device.did;
            ixe.O00000Oo(str, "it.did");
            String str2 = device.model;
            ixe.O00000Oo(str2, "it.model");
            String str3 = device.name;
            ixe.O00000Oo(str3, "it.name");
            String O0000o0O = ggb.O00000Oo().O0000o0O(device.did);
            ixe.O00000Oo(O0000o0O, "getInstance().getRoomNameByDid(it.did)");
            arrayList.add(new MainCameraCardModel(str, str2, str3, O0000o0O, device.isOnline, device.isSetPinCode == 1, !O00000Oo(device), !device.isOwner() && device.isSharedReadOnly()));
        }
        return (List) arrayList;
    }

    private static boolean O00000Oo(Device device) {
        State state;
        hcc gridCard = faw.O00000o0().getGridCard(device);
        if (gridCard == null) {
            return true;
        }
        ArrayList<Pair> deviceRenderData = faw.O00000o0().getDeviceRenderData(device, gridCard);
        if (!(deviceRenderData instanceof ArrayList)) {
            deviceRenderData = null;
        }
        if (deviceRenderData != null) {
            Pair O000000o2 = gzt.O000000o(deviceRenderData);
            if (!(O000000o2 instanceof Pair)) {
                O000000o2 = null;
            }
            if (!device.isOnline || O000000o2 == null || (state = (State) O000000o2.first) == null || state != State.SELECTED) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static <T> Observable<Boolean> O00000Oo(String str) {
        ixe.O00000o(str, "did");
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            Observable<Boolean> just = Observable.just(Boolean.FALSE);
            ixe.O00000Oo(just, "just(false)");
            return just;
        }
        hcc gridCard = faw.O00000o0().getGridCard(O000000o2);
        if (gridCard == null) {
            Observable<Boolean> just2 = Observable.just(Boolean.FALSE);
            ixe.O00000Oo(just2, "just(false)");
            return just2;
        }
        List O000000o3 = gridCard.O000000o();
        ixe.O00000Oo(O000000o3, "card.getGridItems()");
        Object O00000o02 = iuo.O00000o0(O000000o3);
        hcc.O000000o o000000o = O00000o02 instanceof hcc.O000000o ? (hcc.O000000o) O00000o02 : null;
        if (o000000o == null) {
            Observable<Boolean> just3 = Observable.just(Boolean.FALSE);
            ixe.O00000Oo(just3, "just(false)");
            return just3;
        }
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe(o000000o) {
            /* class _m_j.$$Lambda$hfy$zihl5JAWIbuOLTgaRrNNcuGVbbw */
            private final /* synthetic */ hcc.O000000o f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hfy.O000000o(Device.this, this.f$1, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create { emitter ->\n            val prop = CardRouterFactory.getSpecCardManager().getGridCardProperty(device, 0).firstOrNull() as? T\n            if (prop == null){\n                emitter.onNext(false)\n                return@create\n            }\n\n            cardType.sendRequest(null, device, prop, true, object : AsyncCallback<JSONObject, Error>() {\n                override fun onSuccess(result: JSONObject?) {\n                    if (emitter.isDisposed) return\n                    emitter.onNext(true)\n                    emitter.onComplete()\n                }\n\n                override fun onFailure(error: Error?) {\n                    if (emitter.isDisposed) return\n                    emitter.onNext(false)\n                }\n            })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Device device, hcc.O000000o o000000o, ObservableEmitter observableEmitter) {
        ixe.O00000o(device, "$device");
        ixe.O00000o(o000000o, "$cardType");
        ixe.O00000o(observableEmitter, "emitter");
        Spec.SpecItem[] gridCardProperty = faw.O000000o().getGridCardProperty(device, 0);
        ixe.O00000Oo(gridCardProperty, "getSpecCardManager().getGridCardProperty(device, 0)");
        Object[] objArr = (Object[]) gridCardProperty;
        ixe.O00000o0(objArr, "receiver$0");
        Object obj = objArr.length == 0 ? null : objArr[0];
        if (obj == null) {
            observableEmitter.onNext(Boolean.FALSE);
        } else {
            o000000o.O000000o(null, device, obj, Boolean.TRUE, new O00000o0(observableEmitter));
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/mainpage/cache/FreqCameraManager$setPowerProp$1$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 extends fsm<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Boolean> f18888O000000o;

        O00000o0(ObservableEmitter<Boolean> observableEmitter) {
            this.f18888O000000o = observableEmitter;
        }

        public final void onFailure(fso fso) {
            if (!this.f18888O000000o.isDisposed()) {
                this.f18888O000000o.onNext(Boolean.FALSE);
            }
        }

        public final /* synthetic */ void onSuccess(Object obj) {
            if (!this.f18888O000000o.isDisposed()) {
                this.f18888O000000o.onNext(Boolean.TRUE);
                this.f18888O000000o.onComplete();
            }
        }
    }

    public final List<MainCameraCardModel> O000000o(Home home) {
        if (home == null) {
            return EmptyList.f15376O000000o;
        }
        List<MainCameraCardModel> O00000Oo2 = O00000Oo(home);
        return O00000Oo2 == null ? O00000o0(home) : O00000Oo2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean>
     arg types: [com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, int]
     candidates:
      _m_j.hfy.O000000o(com.xiaomi.smarthome.device.Device, _m_j.hcc$O000000o, io.reactivex.ObservableEmitter):void
      _m_j.hfy.O000000o(org.json.JSONObject, java.util.List<java.lang.String>, boolean):void
      _m_j.hfy.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, boolean):io.reactivex.Observable<java.lang.Boolean> */
    public final Observable<Boolean> O00000o0(Home home, List<String> list) {
        ixe.O00000o(list, "dids");
        return O000000o(home, list, false);
    }
}
