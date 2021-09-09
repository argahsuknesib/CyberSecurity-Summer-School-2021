package _m_j;

import _m_j.hof;
import _m_j.hqs;
import _m_j.hrc;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.scene.ConstantType;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneDetailPage;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hri {
    public static RecommendSceneDetailPage.O0000Oo O000000o(hof.O0000O0o.O00000Oo o00000Oo, hqs.O0000Oo0 o0000Oo0) {
        if (TextUtils.equals("user", o0000Oo0.O00000Oo) && TextUtils.equals(ConstantType.TriggerConditionType.CLICK.key, o0000Oo0.O00000oo)) {
            hqi hqi = new hqi(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue());
            hqi.O00000oo = true;
            return hqi;
        } else if (TextUtils.equals("cloud", o0000Oo0.O00000Oo)) {
            if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, o0000Oo0.O00000oo) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, o0000Oo0.O00000oo)) {
                String str = o0000Oo0.O00000oo;
                hqs.O00000Oo o00000Oo2 = (hqs.O00000Oo) o0000Oo0.O0000O0o;
                hpx hpx = new hpx(str);
                if (TextUtils.isEmpty(o00000Oo2.O00000Oo) || TextUtils.isEmpty(o00000Oo2.f534O000000o)) {
                    hpx.O00000o = o00000Oo2.O00000o0;
                }
                hqk hqk = new hqk(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue(), hpx);
                hqk.O00000oo = true;
                return hqk;
            }
            String str2 = o0000Oo0.O00000oo;
            Object obj = o0000Oo0.O00000o;
            hpx hpx2 = new hpx(str2);
            hpx2.O000000o(obj);
            hqk hqk2 = new hqk(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue(), hpx2);
            hqk2.O00000oo = true;
            return hqk2;
        } else if (TextUtils.equals("device", o0000Oo0.O00000Oo)) {
            return O000000o(o00000Oo, o0000Oo0.O00000oo, (hqs.O00000o) o0000Oo0.O0000O0o, o0000Oo0.O00000o, o0000Oo0.O00000oO);
        } else {
            if (!TextUtils.equals("location", o0000Oo0.O00000Oo)) {
                return null;
            }
            String str3 = o0000Oo0.O00000oo;
            hqs.O0000OOo o0000OOo = (hqs.O0000OOo) o0000Oo0.O0000O0o;
            hqp hqp = new hqp(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue(), str3);
            hqp.O0000Oo = o0000OOo.O00000oO;
            String str4 = o0000OOo.O00000Oo;
            hqp.O0000Oo0 = str4;
            Home O00000o = ggb.O00000Oo().O00000o(str4);
            if (O00000o == null || TextUtils.isEmpty(O00000o.getAddr())) {
                hqp.O00000oo = false;
            } else {
                hqp.O00000oo = true;
            }
            hqp.O0000OOo = o0000OOo.f537O000000o;
            hqp.O00000oo = true;
            return hqp;
        }
    }

    private static RecommendSceneDetailPage.O0000Oo O000000o(hof.O0000O0o.O00000Oo o00000Oo, String str, hqs.O00000o o00000o, Object obj, int i) {
        String[] split;
        if (o00000o != null && !TextUtils.isEmpty(str) && (split = str.split("\\.")) != null && split.length == 3) {
            try {
                hqo hqo = new hqo(o00000Oo, new hrc(o00000o.f535O000000o, split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), i, obj), o00000o.f535O000000o, o00000o.O00000Oo, o00000o.O00000o0);
                hqo.O00000oo = true;
                return hqo;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static RecommendSceneDetailPage.O0000Oo O000000o(hof.O00000o.O00000Oo o00000Oo, String str, hqs.O00000o o00000o, Object obj, int i) {
        String[] split;
        if (o00000o != null && !TextUtils.isEmpty(str) && (split = str.split("\\.")) != null && split.length == 3) {
            try {
                hqn hqn = new hqn(o00000Oo, new hrc(o00000o.f535O000000o, split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), i, obj), o00000o.f535O000000o, o00000o.O00000Oo, o00000o.O00000o0);
                hqn.O00000oo = true;
                return hqn;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX WARN: Type inference failed for: r3v13, types: [_m_j.hqz] */
    /* JADX WARNING: Multi-variable type inference failed */
    public static hqc O000000o(hof.O00000o0.O00000Oo o00000Oo, hqs.O000000o o000000o) {
        hrc hrc;
        int i;
        hof.O00000o0.O00000Oo o00000Oo2 = o00000Oo;
        hqs.O000000o o000000o2 = o000000o;
        if (o000000o2.O00000o0 == ConstantType.PayloadType.RPC) {
            int i2 = o000000o2.O00000Oo;
            hqs.O000000o.O00000o0 o00000o0 = (hqs.O000000o.O00000o0) o000000o2.O00000oO;
            Object obj = "";
            if (o00000o0.O00000o0 == ConstantType.RpcMethod.ACION && o00000o0.O0000OOo != null) {
                ArrayList<hqs.O000000o.O00000o0.O00000Oo> arrayList = o00000o0.O0000OOo.O00000o;
                ArrayList arrayList2 = new ArrayList();
                int i3 = 0;
                while (true) {
                    if (arrayList == null) {
                        i = 0;
                    } else {
                        i = arrayList.size();
                    }
                    if (i3 >= i) {
                        break;
                    }
                    arrayList2.add(new hrc(o00000o0.O00000Oo, "prop", o00000o0.O0000OOo.O00000Oo, arrayList.get(i3).O00000o0, O000000o(arrayList.get(i3).O00000o), arrayList.get(i3).O00000o == null ? obj : arrayList.get(i3).O00000o));
                    i3++;
                }
                hrc = new hqz(o00000o0.O00000Oo, o00000o0.O0000OOo.O00000Oo, o00000o0.O0000OOo.O00000o0, arrayList2);
            } else if (o00000o0.O00000o0 != ConstantType.RpcMethod.PROPERTY || o00000o0.O0000O0o == null || o00000o0.O0000O0o.size() <= 0) {
                hrc = null;
            } else {
                String str = o00000o0.O00000Oo;
                int i4 = o00000o0.O0000O0o.get(0).O00000Oo;
                int i5 = o00000o0.O0000O0o.get(0).O00000o0;
                int O000000o2 = O000000o(o00000o0.O0000O0o.get(0).O00000o);
                if (o00000o0.O0000O0o.get(0).O00000o != null) {
                    obj = o00000o0.O0000O0o.get(0).O00000o;
                }
                hrc = new hrc(str, "prop", i4, i5, O000000o2, obj);
            }
            hqm hqm = new hqm(i2, o00000Oo, hrc, o00000o0.O00000Oo, o00000o0.O00000oO, o00000o0.O00000oo);
            hqm.O00000oo = true;
            return hqm;
        }
        if (o000000o2.O00000o0 == ConstantType.PayloadType.PUSH) {
            int i6 = o000000o2.O00000Oo;
            hqs.O000000o.O00000Oo o00000Oo3 = (hqs.O000000o.O00000Oo) o000000o2.O00000oO;
            if (o00000Oo3 != null) {
                hqq hqq = new hqq(i6, o00000Oo2.O00000Oo, o00000Oo2.O0000OoO, o00000Oo2.O00000o0, o00000Oo2.O00000o.intValue(), o00000Oo3.O00000o0, o00000Oo3.O00000Oo);
                hqq.O00000oo = true;
                return hqq;
            }
        }
        return null;
    }

    public static int O000000o(Object obj) {
        if (obj == null) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (!(obj instanceof JSONObject)) {
            return 5;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            return (jSONObject.has("min") || jSONObject.has("max") || jSONObject.has("equal")) ? 3 : 6;
        }
        return 6;
    }

    public static List<hra> O000000o(Map<String, SpecDevice> map, String str, List<hof.O00000Oo> list, List<hof.O00000Oo> list2, List<String> list3, int i, Object obj, ArrayList<hof.O0000OOo> arrayList, int i2) {
        String str2;
        HashSet hashSet;
        HashSet hashSet2;
        HashSet hashSet3;
        String str3;
        int indexOf;
        String str4;
        Iterator<Map.Entry<Integer, SpecEvent>> it;
        String str5;
        String str6;
        HashSet hashSet4;
        HashSet hashSet5;
        String str7;
        HashSet hashSet6;
        String str8;
        HashSet hashSet7;
        HashSet hashSet8;
        String str9;
        String str10;
        int i3;
        String str11 = str;
        List<hof.O00000Oo> list4 = list;
        List<hof.O00000Oo> list5 = list2;
        List<String> list6 = list3;
        Object obj2 = obj;
        ArrayList<hof.O0000OOo> arrayList2 = arrayList;
        int i4 = i2;
        ArrayList arrayList3 = new ArrayList();
        if (!(map == null || map.size() == 0)) {
            HashSet hashSet9 = new HashSet();
            HashSet hashSet10 = new HashSet();
            HashSet hashSet11 = new HashSet();
            String str12 = "&";
            if (list4 != null) {
                for (int i5 = 0; i5 < list.size(); i5++) {
                    hof.O00000Oo o00000Oo = list4.get(i5);
                    if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                        hashSet9.add(o00000Oo.O00000Oo + str12 + o00000Oo.O00000o0);
                    }
                }
            }
            if (list5 != null) {
                for (int i6 = 0; i6 < list2.size(); i6++) {
                    hof.O00000Oo o00000Oo2 = list5.get(i6);
                    if (!TextUtils.isEmpty(o00000Oo2.O00000o0)) {
                        hashSet10.add(o00000Oo2.O00000Oo + str12 + o00000Oo2.O00000o0);
                    }
                }
            }
            if (list6 != null) {
                hashSet11.addAll(list6);
            }
            for (Map.Entry next : map.entrySet()) {
                SpecDevice specDevice = (SpecDevice) next.getValue();
                String typeName = specDevice.getTypeName();
                for (Map.Entry<Integer, SpecService> value : specDevice.getServices().entrySet()) {
                    SpecService specService = (SpecService) value.getValue();
                    String typeName2 = specService.getTypeName();
                    if (hashSet9.size() > 0) {
                        if (!hashSet9.contains(typeName + str12 + typeName2)) {
                        }
                    }
                    if (hashSet9.size() > 0) {
                        if (hashSet10.contains(typeName + str12 + typeName2)) {
                        }
                    }
                    Device O000000o2 = fno.O000000o().O000000o((String) next.getKey());
                    if ((O000000o2 == null || TextUtils.isEmpty(O000000o2.model) || !hashSet11.contains(O000000o2.model)) && (!TextUtils.equals(typeName.toLowerCase(), "lock") || !TextUtils.equals(typeName2.toLowerCase(), "lock") || O000000o(O000000o2, "2.1.7"))) {
                        if (!TextUtils.isEmpty(str)) {
                            Map<Integer, SpecProperty> properties = specService.getProperties();
                            if (str11.startsWith("event")) {
                                int indexOf2 = str11.indexOf(":");
                                if (indexOf2 < str.length()) {
                                    String substring = str11.substring(indexOf2 + 1);
                                    Iterator<Map.Entry<Integer, SpecEvent>> it2 = specService.getEvents().entrySet().iterator();
                                    while (it2.hasNext()) {
                                        SpecEvent specEvent = (SpecEvent) it2.next().getValue();
                                        if (TextUtils.equals(specEvent.getTypeName(), substring)) {
                                            hashSet6 = hashSet9;
                                            if (i != 6 || obj2 == null || !(obj2 instanceof JSONObject) || arrayList2 == null || arrayList.size() <= 0) {
                                                str5 = substring;
                                                it = it2;
                                                str7 = typeName;
                                                hashSet5 = hashSet10;
                                                hashSet4 = hashSet11;
                                                str6 = str12;
                                                arrayList3.add(new hrc((String) next.getKey(), "event", specService.getIid(), specEvent.getIid(), i, O000000o(obj2, specService.getIid(), properties)));
                                            } else {
                                                boolean z = i4 == 0;
                                                SparseArray sparseArray = new SparseArray();
                                                str5 = substring;
                                                it = it2;
                                                int i7 = 0;
                                                while (true) {
                                                    if (i7 >= arrayList.size()) {
                                                        str7 = typeName;
                                                        hashSet5 = hashSet10;
                                                        hashSet4 = hashSet11;
                                                        str6 = str12;
                                                        break;
                                                    }
                                                    String str13 = arrayList2.get(i7).O00000Oo;
                                                    if (!TextUtils.isEmpty(str13)) {
                                                        str7 = typeName;
                                                        if (str13.startsWith("property:")) {
                                                            int indexOf3 = str13.indexOf(":");
                                                            if (indexOf3 < str13.length()) {
                                                                String substring2 = str13.substring(indexOf3 + 1);
                                                                String str14 = arrayList2.get(i7).O00000o;
                                                                Iterator<Map.Entry<Integer, SpecProperty>> it3 = properties.entrySet().iterator();
                                                                while (it3.hasNext()) {
                                                                    Map.Entry next2 = it3.next();
                                                                    Iterator<Map.Entry<Integer, SpecProperty>> it4 = it3;
                                                                    if (TextUtils.equals(((SpecProperty) next2.getValue()).getTypeName(), substring2)) {
                                                                        if (!TextUtils.isEmpty(str14)) {
                                                                            ConstraintValue constraintValue = ((SpecProperty) next2.getValue()).getConstraintValue();
                                                                            if (constraintValue != null) {
                                                                                str10 = substring2;
                                                                                if (constraintValue instanceof ValueList) {
                                                                                    List<ValueDefinition> values = ((ValueList) constraintValue).values();
                                                                                    int i8 = 0;
                                                                                    while (true) {
                                                                                        if (values == null) {
                                                                                            hashSet8 = hashSet10;
                                                                                            i3 = 0;
                                                                                        } else {
                                                                                            hashSet8 = hashSet10;
                                                                                            i3 = values.size();
                                                                                        }
                                                                                        if (i8 >= i3) {
                                                                                            str9 = str14;
                                                                                            break;
                                                                                        } else if (TextUtils.equals(values.get(i8).description(), str14)) {
                                                                                            str9 = str14;
                                                                                            hashSet7 = hashSet11;
                                                                                            str8 = str12;
                                                                                            sparseArray.put(i7, new hrc.O000000o(arrayList2.get(i7).O00000oO.intValue(), specService.getIid(), ((SpecProperty) next2.getValue()).getIid(), values.get(i8).valueObject()));
                                                                                            break;
                                                                                        } else {
                                                                                            i8++;
                                                                                            hashSet10 = hashSet8;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                str10 = substring2;
                                                                            }
                                                                            str9 = str14;
                                                                            hashSet8 = hashSet10;
                                                                        } else {
                                                                            str10 = substring2;
                                                                            str9 = str14;
                                                                            hashSet8 = hashSet10;
                                                                            hashSet7 = hashSet11;
                                                                            str8 = str12;
                                                                            sparseArray.put(i7, new hrc.O000000o(arrayList2.get(i7).O00000o0, arrayList2.get(i7).O00000oO.intValue(), specService.getIid(), ((SpecProperty) next2.getValue()).getIid()));
                                                                        }
                                                                        substring2 = str10;
                                                                        it3 = it4;
                                                                        str14 = str9;
                                                                        hashSet10 = hashSet8;
                                                                        hashSet11 = hashSet7;
                                                                        str12 = str8;
                                                                    } else {
                                                                        str10 = substring2;
                                                                        str9 = str14;
                                                                        hashSet8 = hashSet10;
                                                                    }
                                                                    hashSet7 = hashSet11;
                                                                    str8 = str12;
                                                                    substring2 = str10;
                                                                    it3 = it4;
                                                                    str14 = str9;
                                                                    hashSet10 = hashSet8;
                                                                    hashSet11 = hashSet7;
                                                                    str12 = str8;
                                                                }
                                                                hashSet5 = hashSet10;
                                                                hashSet4 = hashSet11;
                                                                str6 = str12;
                                                                if (sparseArray.get(i7) == null) {
                                                                    if (i4 == 0) {
                                                                        break;
                                                                    }
                                                                } else {
                                                                    if (i4 == 1) {
                                                                        z = true;
                                                                    }
                                                                    i7++;
                                                                    typeName = str7;
                                                                    hashSet10 = hashSet5;
                                                                    hashSet11 = hashSet4;
                                                                    str12 = str6;
                                                                }
                                                            } else if (i4 == 0) {
                                                                hashSet5 = hashSet10;
                                                                hashSet4 = hashSet11;
                                                                str6 = str12;
                                                                break;
                                                            } else {
                                                                hashSet5 = hashSet10;
                                                                hashSet4 = hashSet11;
                                                                str6 = str12;
                                                            }
                                                            i7++;
                                                            typeName = str7;
                                                            hashSet10 = hashSet5;
                                                            hashSet11 = hashSet4;
                                                            str12 = str6;
                                                        }
                                                    } else {
                                                        str7 = typeName;
                                                    }
                                                    hashSet5 = hashSet10;
                                                    hashSet4 = hashSet11;
                                                    str6 = str12;
                                                    if (i4 == 0) {
                                                        break;
                                                    }
                                                    i7++;
                                                    typeName = str7;
                                                    hashSet10 = hashSet5;
                                                    hashSet11 = hashSet4;
                                                    str12 = str6;
                                                }
                                                z = false;
                                                if (z) {
                                                    hrc hrc = new hrc((String) next.getKey(), "event", specService.getIid(), specEvent.getIid(), i, O000000o(obj2, specService.getIid(), properties));
                                                    ArrayList arrayList4 = new ArrayList();
                                                    for (int i9 = 0; i9 < arrayList.size(); i9++) {
                                                        if (sparseArray.get(i9) != null) {
                                                            arrayList4.add(sparseArray.get(i9));
                                                        }
                                                    }
                                                    if (arrayList4.size() > 0) {
                                                        hrc.O000000o(i4, arrayList4);
                                                        arrayList3.add(hrc);
                                                    }
                                                }
                                            }
                                        } else {
                                            str5 = substring;
                                            it = it2;
                                            str7 = typeName;
                                            hashSet6 = hashSet9;
                                            hashSet5 = hashSet10;
                                            hashSet4 = hashSet11;
                                            str6 = str12;
                                        }
                                        substring = str5;
                                        it2 = it;
                                        hashSet9 = hashSet6;
                                        typeName = str7;
                                        hashSet10 = hashSet5;
                                        hashSet11 = hashSet4;
                                        str12 = str6;
                                    }
                                }
                                hashSet2 = hashSet10;
                                hashSet = hashSet11;
                                str2 = str12;
                                hashSet9 = hashSet9;
                                typeName = typeName;
                                hashSet10 = hashSet2;
                                hashSet11 = hashSet;
                                str12 = str2;
                            } else {
                                String str15 = typeName;
                                hashSet3 = hashSet9;
                                hashSet2 = hashSet10;
                                hashSet = hashSet11;
                                str2 = str12;
                                if (str11.startsWith("prop") && (indexOf = str11.indexOf(":")) < str.length()) {
                                    String substring3 = str11.substring(indexOf + 1);
                                    for (Map.Entry<Integer, SpecProperty> value2 : properties.entrySet()) {
                                        SpecProperty specProperty = (SpecProperty) value2.getValue();
                                        if (TextUtils.equals(specProperty.getTypeName(), substring3)) {
                                            str4 = str15;
                                            arrayList3.add(new hrc((String) next.getKey(), "prop", specService.getIid(), specProperty.getIid(), i, obj));
                                        } else {
                                            str4 = str15;
                                        }
                                        str15 = str4;
                                    }
                                }
                                str3 = str15;
                            }
                        } else {
                            hashSet3 = hashSet9;
                            hashSet2 = hashSet10;
                            hashSet = hashSet11;
                            str2 = str12;
                            str3 = typeName;
                        }
                        typeName = str3;
                        hashSet9 = hashSet3;
                        hashSet10 = hashSet2;
                        hashSet11 = hashSet;
                        str12 = str2;
                    }
                }
            }
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "filterRecScene", "CONDITON |TRIGGER deviceinHome: " + map.size() + " , source: " + str11 + " , result size: " + arrayList3.size());
        }
        return arrayList3;
    }

    public static Object O000000o(Object obj, int i, Map<Integer, SpecProperty> map) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        if (!(obj == null || !(obj instanceof JSONObject) || (optJSONObject = (jSONObject = (JSONObject) obj).optJSONObject("sub_props")) == null || map == null)) {
            JSONArray optJSONArray = optJSONObject.optJSONArray("attr");
            int i2 = 0;
            while (i2 < optJSONArray.length()) {
                try {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                    if (optJSONObject2 != null) {
                        String optString = optJSONObject2.optString("key");
                        if (!TextUtils.isEmpty(optString) && optString.startsWith("prop")) {
                            for (Map.Entry<Integer, SpecProperty> value : map.entrySet()) {
                                SpecProperty specProperty = (SpecProperty) value.getValue();
                                if (specProperty != null) {
                                    if (TextUtils.equals(optString, "prop." + specProperty.getTypeName())) {
                                        optJSONObject2.put("key", "prop.." + i + "." + specProperty.getIid());
                                        optJSONArray.put(i2, optJSONObject2);
                                    }
                                }
                            }
                        }
                    }
                    i2++;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            optJSONObject.put("attr", optJSONArray);
            jSONObject.put("sub_props", optJSONObject);
            return jSONObject;
        }
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0133, code lost:
        if (r6.contains(r13 + "&" + r10) != false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0157, code lost:
        if (r7.contains(r13 + "&" + r10) == false) goto L_0x0159;
     */
    private static ArrayList<hra> O000000o(Map<String, SpecDevice> map, List<hof.O00000o0.C0001O00000o0> list, List<hof.O00000o0.O000000o> list2, List<hof.O00000Oo> list3, List<hof.O00000Oo> list4, List<String> list5) {
        Iterator<Map.Entry<String, SpecDevice>> it;
        HashMap hashMap;
        Iterator<Map.Entry<Integer, SpecAction>> it2;
        Iterator<Map.Entry<Integer, SpecProperty>> it3;
        HashSet hashSet;
        int i;
        List<hof.O00000o0.C0001O00000o0> list6 = list;
        List<hof.O00000o0.O000000o> list7 = list2;
        List<hof.O00000Oo> list8 = list3;
        List<hof.O00000Oo> list9 = list4;
        List<String> list10 = list5;
        ArrayList<hra> arrayList = new ArrayList<>();
        if (!(map == null || map.size() == 0)) {
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            if (list8 != null) {
                for (int i2 = 0; i2 < list3.size(); i2++) {
                    hof.O00000Oo o00000Oo = list8.get(i2);
                    if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                        hashSet2.add(o00000Oo.O00000Oo + "&" + o00000Oo.O00000o0);
                    }
                }
            }
            if (list9 != null) {
                for (int i3 = 0; i3 < list4.size(); i3++) {
                    hof.O00000Oo o00000Oo2 = list9.get(i3);
                    if (!TextUtils.isEmpty(o00000Oo2.O00000o0)) {
                        hashSet3.add(o00000Oo2.O00000Oo + "&" + o00000Oo2.O00000o0);
                    }
                }
            }
            if (list10 != null) {
                hashSet4.addAll(list10);
            }
            HashMap hashMap2 = new HashMap();
            if (list6 != null) {
                for (int i4 = 0; i4 < list.size(); i4++) {
                    hashMap2.put(list6.get(i4).O00000Oo, list6.get(i4));
                }
            }
            HashMap hashMap3 = new HashMap();
            if (list7 != null) {
                for (int i5 = 0; i5 < list2.size(); i5++) {
                    hashMap3.put(list7.get(i5).O00000Oo, list7.get(i5));
                }
            }
            Iterator<Map.Entry<String, SpecDevice>> it4 = map.entrySet().iterator();
            while (it4.hasNext()) {
                Map.Entry next = it4.next();
                SpecDevice specDevice = (SpecDevice) next.getValue();
                String typeName = specDevice.getTypeName();
                for (Map.Entry<Integer, SpecService> value : specDevice.getServices().entrySet()) {
                    SpecService specService = (SpecService) value.getValue();
                    String typeName2 = specService.getTypeName();
                    if (hashSet2.size() > 0) {
                        it = it4;
                    } else {
                        it = it4;
                        if (hashSet2.size() > 0) {
                        }
                        HashSet hashSet5 = hashSet2;
                        Device O000000o2 = fno.O000000o().O000000o((String) next.getKey());
                        if (O000000o2 == null || TextUtils.isEmpty(O000000o2.model) || !hashSet4.contains(O000000o2.model)) {
                            HashSet hashSet6 = hashSet3;
                            if (!TextUtils.equals(typeName.toLowerCase(), "lock") || !TextUtils.equals(typeName2.toLowerCase(), "lock") || O000000o(O000000o2, "2.1.7")) {
                                gsy.O00000Oo("RecScene", "spec" + specDevice.getTypeName() + "----" + typeName2 + "----" + fno.O000000o().O000000o((String) next.getKey()).getName());
                                if (list6 != null && list.size() > 0) {
                                    Iterator<Map.Entry<Integer, SpecProperty>> it5 = specService.getProperties().entrySet().iterator();
                                    while (it5.hasNext()) {
                                        SpecProperty specProperty = (SpecProperty) it5.next().getValue();
                                        if (hashMap2.containsKey(specProperty.getTypeName())) {
                                            hof.O00000o0.C0001O00000o0 o00000o0 = (hof.O00000o0.C0001O00000o0) hashMap2.get(specProperty.getTypeName());
                                            String str = o00000o0.O00000oO;
                                            ConstraintValue constraintValue = specProperty.getConstraintValue();
                                            if (o00000o0 == null || TextUtils.isEmpty(str) || constraintValue == null) {
                                                it3 = it5;
                                            } else {
                                                it3 = it5;
                                                if (constraintValue instanceof ValueList) {
                                                    List<ValueDefinition> values = ((ValueList) constraintValue).values();
                                                    int i6 = 0;
                                                    while (true) {
                                                        if (values == null) {
                                                            hashSet = hashSet4;
                                                            i = 0;
                                                        } else {
                                                            hashSet = hashSet4;
                                                            i = values.size();
                                                        }
                                                        if (i6 >= i) {
                                                            break;
                                                        } else if (TextUtils.equals(values.get(i6).description(), str)) {
                                                            arrayList.add(new hrc((String) next.getKey(), "prop", specService.getIid(), specProperty.getIid(), o00000o0.O00000o.intValue(), values.get(i6).valueObject()));
                                                            break;
                                                        } else {
                                                            i6++;
                                                            hashSet4 = hashSet;
                                                        }
                                                    }
                                                }
                                            }
                                            hashSet = hashSet4;
                                            arrayList.add(new hrc((String) next.getKey(), "prop", specService.getIid(), specProperty.getIid(), ((hof.O00000o0.C0001O00000o0) hashMap2.get(specProperty.getTypeName())).O00000o.intValue(), ((hof.O00000o0.C0001O00000o0) hashMap2.get(specProperty.getTypeName())).O00000o0));
                                        } else {
                                            it3 = it5;
                                            hashSet = hashSet4;
                                        }
                                        it5 = it3;
                                        hashSet4 = hashSet;
                                    }
                                }
                                HashSet hashSet7 = hashSet4;
                                if (list7 != null && list2.size() > 0) {
                                    Map<Integer, SpecAction> actions = specService.getActions();
                                    Map<Integer, SpecProperty> properties = specService.getProperties();
                                    Iterator<Map.Entry<Integer, SpecAction>> it6 = actions.entrySet().iterator();
                                    while (it6.hasNext()) {
                                        SpecAction specAction = (SpecAction) it6.next().getValue();
                                        if (hashMap3.containsKey(specAction.getTypeName())) {
                                            ArrayList<hof.O00000o0.C0001O00000o0> arrayList2 = ((hof.O00000o0.O000000o) hashMap3.get(specAction.getTypeName())).O00000o0;
                                            List<Object> in2 = specAction.getIn();
                                            if ((arrayList2 == null || arrayList2.size() == 0) && (in2 == null || in2.size() == 0)) {
                                                it2 = it6;
                                                hashMap = hashMap2;
                                                arrayList.add(new hqz((String) next.getKey(), specService.getIid(), specAction.getIid(), O000000o((String) next.getKey(), arrayList2, specService.getIid(), properties)));
                                                it6 = it2;
                                                hashMap2 = hashMap;
                                            } else if (!(arrayList2 == null || in2 == null || arrayList2.size() <= 0)) {
                                                it2 = it6;
                                                if (in2.size() >= arrayList2.size()) {
                                                    ArrayList arrayList3 = new ArrayList();
                                                    ArrayList arrayList4 = new ArrayList();
                                                    hashMap = hashMap2;
                                                    for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                                        arrayList3.add(arrayList2.get(i7).O00000Oo);
                                                    }
                                                    for (int i8 = 0; i8 < in2.size(); i8++) {
                                                        if (properties.containsKey(in2.get(i8))) {
                                                            arrayList4.add(properties.get(in2.get(i8)).getTypeName());
                                                        }
                                                    }
                                                    if (arrayList4.containsAll(arrayList3)) {
                                                        arrayList.add(new hqz((String) next.getKey(), specService.getIid(), specAction.getIid(), O000000o((String) next.getKey(), arrayList2, specService.getIid(), properties)));
                                                    }
                                                    it6 = it2;
                                                    hashMap2 = hashMap;
                                                }
                                                hashMap = hashMap2;
                                                it6 = it2;
                                                hashMap2 = hashMap;
                                            }
                                        }
                                        it2 = it6;
                                        hashMap = hashMap2;
                                        it6 = it2;
                                        hashMap2 = hashMap;
                                    }
                                }
                                list6 = list;
                                list7 = list2;
                                it4 = it;
                                hashMap2 = hashMap2;
                                hashSet3 = hashSet6;
                                hashSet2 = hashSet5;
                                hashSet4 = hashSet7;
                            } else {
                                it4 = it;
                                hashSet3 = hashSet6;
                            }
                        } else {
                            it4 = it;
                        }
                        hashSet2 = hashSet5;
                    }
                    it4 = it;
                }
                list6 = list;
                list7 = list2;
            }
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "filterRecScene", "ACTION deviceinHome: " + map.size() + " ,  result size: " + arrayList.size());
        }
        return arrayList;
    }

    private static List<hrc> O000000o(String str, List<hof.O00000o0.C0001O00000o0> list, int i, Map<Integer, SpecProperty> map) {
        ArrayList arrayList = new ArrayList();
        if (!(list == null || list.size() == 0)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (Map.Entry next : map.entrySet()) {
                    if (TextUtils.equals(list.get(i2).O00000Oo, ((SpecProperty) next.getValue()).getTypeName())) {
                        arrayList.add(new hrc(str, "prop", i, ((SpecProperty) next.getValue()).getIid(), list.get(i2).O00000o.intValue(), list.get(i2).O00000o0));
                    }
                }
            }
        }
        return arrayList;
    }

    public static SparseArray O000000o(hof.O00000o o00000o, hof.O0000O0o o0000O0o, hof.O00000o0 o00000o0) {
        ArrayList<hof.O00000o0.O00000Oo> arrayList;
        SparseArray sparseArray = new SparseArray();
        if (!(o00000o == null || o00000o.O00000o0 == null || o00000o.O00000o0.size() <= 0)) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            ArrayList<hof.O00000o.O00000Oo> arrayList2 = o00000o.O00000o0;
            for (int i = 0; i < arrayList2.size(); i++) {
                ArrayList<hof.O00000Oo> arrayList3 = arrayList2.get(i).O0000O0o;
                if (arrayList3 != null) {
                    for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                        hashSet.add(arrayList3.get(i2).O00000Oo);
                    }
                }
                ArrayList<hof.O00000Oo> arrayList4 = arrayList2.get(i).O0000OOo;
                if (arrayList4 != null) {
                    for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                        hashSet2.add(arrayList4.get(i3).O00000Oo);
                    }
                }
            }
            sparseArray.put(0, hashSet);
            sparseArray.put(1, hashSet2);
        }
        if (!(o0000O0o == null || o0000O0o.O00000o0 == null || o0000O0o.O00000o0.size() <= 0)) {
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            ArrayList<hof.O0000O0o.O00000Oo> arrayList5 = o0000O0o.O00000o0;
            for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                ArrayList<hof.O00000Oo> arrayList6 = arrayList5.get(i4).O0000O0o;
                if (arrayList6 != null) {
                    for (int i5 = 0; i5 < arrayList6.size(); i5++) {
                        hashSet3.add(arrayList6.get(i5).O00000Oo);
                    }
                }
                ArrayList<hof.O00000Oo> arrayList7 = arrayList5.get(i4).O0000OOo;
                if (arrayList7 != null) {
                    for (int i6 = 0; i6 < arrayList7.size(); i6++) {
                        hashSet4.add(arrayList7.get(i6).O00000Oo);
                    }
                }
            }
            sparseArray.put(2, hashSet3);
            sparseArray.put(3, hashSet4);
        }
        if (!(o00000o0 == null || o00000o0.O00000oO == null || o00000o0.O00000oO.size() <= 0)) {
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            ArrayList<hof.O00000o0.O0000O0o> arrayList8 = o00000o0.O00000oO;
            for (int i7 = 0; i7 < arrayList8.size(); i7++) {
                hof.O00000o0.O0000O0o o0000O0o2 = arrayList8.get(i7);
                if (!(o0000O0o2 == null || (arrayList = o0000O0o2.O00000oO) == null)) {
                    for (int i8 = 0; i8 < arrayList.size(); i8++) {
                        ArrayList<hof.O00000Oo> arrayList9 = arrayList.get(i8).O00000oo;
                        if (arrayList9 != null) {
                            for (int i9 = 0; i9 < arrayList9.size(); i9++) {
                                hashSet5.add(arrayList9.get(i9).O00000Oo);
                            }
                        }
                        ArrayList<hof.O00000Oo> arrayList10 = arrayList.get(i8).O0000O0o;
                        if (arrayList10 != null) {
                            for (int i10 = 0; i10 < arrayList10.size(); i10++) {
                                hashSet6.add(arrayList10.get(i10).O00000Oo);
                            }
                        }
                    }
                }
            }
            sparseArray.put(4, hashSet5);
            sparseArray.put(5, hashSet6);
        }
        return sparseArray;
    }

    public static SparseArray<Map<String, SpecDevice>> O000000o(Map<String, SpecDevice> map, SparseArray<Set<String>> sparseArray) {
        SparseArray<Set<String>> sparseArray2 = sparseArray;
        SparseArray<Map<String, SpecDevice>> sparseArray3 = new SparseArray<>();
        if (map == null) {
            return sparseArray3;
        }
        int i = 0;
        try {
            Set set = sparseArray2.get(0);
            Set set2 = sparseArray2.get(1);
            Set set3 = sparseArray2.get(2);
            Set set4 = sparseArray2.get(3);
            Set set5 = sparseArray2.get(4);
            Set set6 = sparseArray2.get(5);
            for (Map.Entry next : map.entrySet()) {
                SpecDevice specDevice = (SpecDevice) next.getValue();
                String typeName = specDevice.getTypeName();
                if (set2 != null && !set2.contains(typeName) && (set == null || set.size() == 0 || set.contains(typeName))) {
                    if (sparseArray3.get(i) == null) {
                        sparseArray3.put(i, new TreeMap());
                    }
                    sparseArray3.get(i).put(next.getKey(), specDevice);
                }
                if (set4 != null && !set4.contains(typeName) && (set3 == null || set3.size() == 0 || set3.contains(typeName))) {
                    if (sparseArray3.get(1) == null) {
                        sparseArray3.put(1, new TreeMap());
                    }
                    sparseArray3.get(1).put(next.getKey(), specDevice);
                }
                if (set6 != null && !set6.contains(typeName) && (set5 == null || set5.size() == 0 || set5.contains(typeName))) {
                    if (sparseArray3.get(2) == null) {
                        sparseArray3.put(2, new TreeMap());
                    }
                    sparseArray3.get(2).put(next.getKey(), specDevice);
                }
                i = 0;
            }
            LogType logType = LogType.SCENE;
            StringBuilder sb = new StringBuilder("all deviceinHome: ");
            sb.append(map.size());
            sb.append(" , related device in home visible: ");
            int i2 = 0;
            sb.append(sparseArray3.get(0) == null ? 0 : sparseArray3.get(0).size());
            sb.append(" , invisible: ");
            if (sparseArray3.get(1) != null) {
                i2 = sparseArray3.get(1).size();
            }
            sb.append(i2);
            gsy.O00000o0(logType, "filterRecScene", sb.toString());
        } catch (Exception e) {
            LogType logType2 = LogType.SCENE;
            gsy.O00000o0(logType2, "filterRecScene", "filterDevice exception:\n" + e.getMessage());
        }
        return sparseArray3;
    }

    public static Map<String, SpecDevice> O000000o(List<Device> list) {
        TreeMap treeMap = new TreeMap();
        for (int i = 0; i < list.size(); i++) {
            SpecDevice specInstance = faw.O000000o().getSpecInstance(list.get(i));
            if (specInstance != null) {
                treeMap.put(list.get(i).did, specInstance);
            }
        }
        return treeMap;
    }

    public static Observable O000000o(List<Device> list, hof hof) {
        return Observable.create(new ObservableOnSubscribe(list, hof) {
            /* class _m_j.$$Lambda$hri$1Zrq9pGJZQfqZ4LUH6DsRZLG1UI */
            private final /* synthetic */ List f$0;
            private final /* synthetic */ hof f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hri.O000000o(this.f$0, this.f$1, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(List list, hof hof, ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(O000000o(O000000o((List<Device>) list), O000000o(hof.O0000oo0, hof.O0000oOo, hof.O0000oo)));
        observableEmitter.onComplete();
    }

    public static Observable O000000o(Context context, long j) {
        return Observable.create(new ObservableOnSubscribe(j, context) {
            /* class _m_j.$$Lambda$hri$C7w2g4XXLjtW5R56MT9IRKpDxkc */
            private final /* synthetic */ long f$0;
            private final /* synthetic */ Context f$1;

            {
                this.f$0 = r1;
                this.f$1 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hri.O000000o(this.f$0, this.f$1, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(long j, Context context, final ObservableEmitter observableEmitter) throws Exception {
        if (j <= 0) {
            try {
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onNext(new JSONObject());
                }
            } catch (Exception e) {
                gsy.O000000o(6, "RecScene", e.getMessage());
                if (!observableEmitter.isDisposed()) {
                    observableEmitter.onError(e);
                }
            }
        } else {
            hnz.O000000o(context, j, 1, new fsy<JSONObject, fso>() {
                /* class _m_j.hri.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    gsy.O00000Oo("RecScene", jSONObject == null ? "" : jSONObject.toString());
                    if (observableEmitter.isDisposed()) {
                        return;
                    }
                    if (jSONObject != null) {
                        observableEmitter.onNext(jSONObject);
                    } else {
                        observableEmitter.onNext(new JSONObject());
                    }
                }

                public final void onFailure(fso fso) {
                    if (!observableEmitter.isDisposed()) {
                        ObservableEmitter observableEmitter = observableEmitter;
                        StringBuilder sb = new StringBuilder();
                        sb.append(fso.f17063O000000o);
                        observableEmitter.onError(new Exception(sb.toString()));
                    }
                }
            });
        }
    }

    public static Observable<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> O000000o(final String str, final hof hof, final Map<String, SpecDevice> map, final boolean z) {
        return Observable.create(new ObservableOnSubscribe<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>>() {
            /* class _m_j.hri.AnonymousClass2 */

            public final void subscribe(ObservableEmitter<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> observableEmitter) {
                hof.O00000o o00000o;
                ArrayList<hof.O00000o.O00000Oo> arrayList;
                ArrayList<hof.O00000o.O00000Oo> arrayList2;
                int i;
                int i2;
                ObservableEmitter<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> observableEmitter2 = observableEmitter;
                try {
                    SparseArray sparseArray = new SparseArray();
                    if (!(hof == null || (o00000o = hof.O0000oo0) == null || (arrayList = o00000o.O00000o0) == null)) {
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        int i3 = 0;
                        while (i3 < arrayList.size()) {
                            hof.O00000o.O00000Oo o00000Oo = arrayList.get(i3);
                            if (TextUtils.equals(ConstantType.TriggerConditionType.ANY_TIME.key, o00000Oo.O00000oO)) {
                                hqh hqh = new hqh(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue());
                                if (o00000Oo.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                    arrayList4.add(hqh);
                                } else {
                                    arrayList3.add(hqh);
                                }
                                arrayList2 = arrayList;
                                i2 = i3;
                            } else if (TextUtils.equals(ConstantType.TriggerConditionType.DEVICE.key, o00000Oo.O00000oo)) {
                                arrayList2 = arrayList;
                                i2 = i3;
                                List<hra> O000000o2 = hri.O000000o(map, o00000Oo.O00000oO, o00000Oo.O0000O0o, o00000Oo.O0000OOo, o00000Oo.O0000Oo0, o00000Oo.O0000o00.intValue(), o00000Oo.O0000Oo, o00000Oo.O0000OoO, o00000Oo.O0000Ooo.intValue());
                                if (O000000o2.size() > 0) {
                                    i = i2;
                                    while (O000000o2.size() > 0) {
                                        hqn hqn = new hqn(o00000Oo, O000000o2.get(0));
                                        if (o00000Oo.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                            arrayList4.add(hqn);
                                        } else {
                                            arrayList3.add(hqn);
                                        }
                                        i++;
                                    }
                                    i3 = i + 1;
                                    arrayList = arrayList2;
                                }
                            } else {
                                arrayList2 = arrayList;
                                i2 = i3;
                                if (TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, o00000Oo.O00000oO) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, o00000Oo.O00000oO) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key, o00000Oo.O00000oO) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key, o00000Oo.O00000oO) || TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_AQI.key, o00000Oo.O00000oO)) {
                                    hpx hpx = new hpx(o00000Oo.O00000oO);
                                    hpx.O00000o = str;
                                    hqj hqj = new hqj(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue(), hpx, o00000Oo.O00000oO);
                                    if (o00000Oo.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                        arrayList4.add(hqj);
                                    } else {
                                        arrayList3.add(hqj);
                                    }
                                }
                            }
                            i = i2;
                            i3 = i + 1;
                            arrayList = arrayList2;
                        }
                        if (arrayList3.size() > 0) {
                            if (z) {
                                arrayList3.add(0, new RecommendSceneDetailPage.O00000o0(o00000o.O0000OOo, 0));
                            }
                            sparseArray.put(0, arrayList3);
                        }
                        if (arrayList4.size() > 0) {
                            sparseArray.put(1, arrayList4);
                        }
                    }
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter2.onNext(sparseArray);
                    }
                    LogType logType = LogType.SCENE;
                    gsy.O00000o0(logType, "recScene", "make condition " + sparseArray.size());
                } catch (Exception e) {
                    LogType logType2 = LogType.SCENE;
                    gsy.O00000o0(logType2, "recScene", "getConditionObservable exception:\n " + e.getMessage());
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter2.onError(e);
                    }
                }
            }
        });
    }

    public static Observable<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> O00000Oo(final String str, final hof hof, final Map<String, SpecDevice> map, final boolean z) {
        return Observable.create(new ObservableOnSubscribe<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>>() {
            /* class _m_j.hri.AnonymousClass3 */

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v9, resolved type: _m_j.hqk} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: _m_j.hqi} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: _m_j.hqi} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0220  */
            public final void subscribe(ObservableEmitter<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> observableEmitter) {
                String str;
                String str2;
                hof.O0000O0o o0000O0o;
                ArrayList<hof.O0000O0o.O00000Oo> arrayList;
                hqi hqi;
                String str3;
                ArrayList<hof.O0000O0o.O00000Oo> arrayList2;
                ObservableEmitter<SparseArray<ArrayList<RecommendSceneDetailPage.O0000Oo>>> observableEmitter2 = observableEmitter;
                String str4 = "recScene";
                try {
                    SparseArray sparseArray = new SparseArray();
                    if (hof == null || (o0000O0o = hof.O0000oOo) == null || (arrayList = o0000O0o.O00000o0) == null) {
                        str2 = str4;
                    } else {
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        int i = 0;
                        while (true) {
                            hqi = null;
                            if (i >= arrayList.size()) {
                                break;
                            }
                            hof.O0000O0o.O00000Oo o00000Oo = arrayList.get(i);
                            if (!TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_ENTER.key, o00000Oo.O00000oO)) {
                                if (!TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_LEAVE.key, o00000Oo.O00000oO)) {
                                    if (TextUtils.equals(ConstantType.TriggerConditionType.DEVICE.key, o00000Oo.O00000oo)) {
                                        arrayList2 = arrayList;
                                        str3 = str4;
                                        try {
                                            List<hra> O000000o2 = hri.O000000o(map, o00000Oo.O00000oO, o00000Oo.O0000O0o, o00000Oo.O0000OOo, o00000Oo.O0000Oo0, o00000Oo.O0000o00.intValue(), o00000Oo.O0000Oo, o00000Oo.O0000OoO, o00000Oo.O0000Ooo.intValue());
                                            if (O000000o2.size() > 0) {
                                                for (int i2 = 0; i2 < O000000o2.size(); i2++) {
                                                    hqo hqo = new hqo(o00000Oo, O000000o2.get(i2));
                                                    if (o00000Oo.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                                        arrayList4.add(hqo);
                                                    } else {
                                                        arrayList3.add(hqo);
                                                    }
                                                }
                                            }
                                        } catch (Exception e) {
                                            e = e;
                                            str = str3;
                                            gsy.O00000o0(LogType.SCENE, str, "getTriggerObservable exception:\n " + e.getMessage());
                                            if (!observableEmitter.isDisposed()) {
                                            }
                                        }
                                    } else {
                                        str3 = str4;
                                        arrayList2 = arrayList;
                                        if (!TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_ENTER.key, o00000Oo.O00000oO)) {
                                            if (!TextUtils.equals(ConstantType.TriggerConditionType.LOCATION_LEAVE.key, o00000Oo.O00000oO)) {
                                                if (TextUtils.equals(ConstantType.TriggerConditionType.CLICK.key, o00000Oo.O00000oO)) {
                                                    hqi = new hqi(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue());
                                                } else {
                                                    if (!TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_AQI.key, o00000Oo.O00000oO) && !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_HUMIDITY.key, o00000Oo.O00000oO) && !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_TEMPERATURE.key, o00000Oo.O00000oO) && !TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNRISE.key, o00000Oo.O00000oO)) {
                                                        if (!TextUtils.equals(ConstantType.TriggerConditionType.CLOUD_SUNSET.key, o00000Oo.O00000oO)) {
                                                            TextUtils.equals(ConstantType.TriggerConditionType.TIMER.key, o00000Oo.O00000oO);
                                                        }
                                                    }
                                                    hqi = new hqk(o00000Oo.O00000Oo.intValue(), o00000Oo.O0000o0.intValue(), o00000Oo.O00000o.intValue(), o00000Oo.O00000o0.intValue(), new hpx(o00000Oo.O00000oO));
                                                }
                                            }
                                        }
                                        if (hqi != null) {
                                            if (o00000Oo.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                                arrayList4.add(hqi);
                                            } else {
                                                arrayList3.add(hqi);
                                            }
                                        }
                                    }
                                    i++;
                                    arrayList = arrayList2;
                                    str4 = str3;
                                }
                            }
                            str3 = str4;
                            arrayList2 = arrayList;
                            i++;
                            arrayList = arrayList2;
                            str4 = str3;
                        }
                        str2 = str4;
                        if (arrayList3.size() > 0) {
                            int size = arrayList3.size() - 1;
                            while (true) {
                                if (size < 0) {
                                    break;
                                } else if (arrayList3.get(size) instanceof hqi) {
                                    hqi = arrayList3.get(size);
                                    arrayList3.remove(size);
                                    break;
                                } else {
                                    size--;
                                }
                            }
                            if (hqi != null) {
                                arrayList3.add(hqi);
                            }
                            if (z) {
                                String str5 = o0000O0o.O0000OOo;
                                o0000O0o.O00000Oo.intValue();
                                arrayList3.add(0, new RecommendSceneDetailPage.O00000o0(str5, 0));
                            }
                            sparseArray.put(0, arrayList3);
                        }
                        if (arrayList4.size() > 0) {
                            sparseArray.put(1, arrayList4);
                        }
                    }
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter2.onNext(sparseArray);
                    }
                    str = str2;
                    try {
                        gsy.O00000o0(LogType.SCENE, str, "make trigger " + sparseArray.size());
                    } catch (Exception e2) {
                        e = e2;
                        gsy.O00000o0(LogType.SCENE, str, "getTriggerObservable exception:\n " + e.getMessage());
                        if (!observableEmitter.isDisposed()) {
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = str4;
                    gsy.O00000o0(LogType.SCENE, str, "getTriggerObservable exception:\n " + e.getMessage());
                    if (!observableEmitter.isDisposed()) {
                        observableEmitter2.onError(e);
                    }
                }
            }
        });
    }

    public static Observable<SparseArray<ArrayList<ArrayList<RecommendSceneDetailPage.O0000Oo>>>> O000000o(hof hof, Map<String, SpecDevice> map, boolean z) {
        return Observable.create(new ObservableOnSubscribe(map, z) {
            /* class _m_j.$$Lambda$hri$AniN26tvDWfFGFP83XovdsvcXaY */
            private final /* synthetic */ Map f$1;
            private final /* synthetic */ boolean f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                hri.O000000o(hof.this, this.f$1, this.f$2, observableEmitter);
            }
        });
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(hof hof, Map map, boolean z, ObservableEmitter observableEmitter) throws Exception {
        hof.O00000o0 o00000o0;
        ArrayList<hof.O00000o0.O0000O0o> arrayList;
        ArrayList<hof.O00000o0.O0000O0o> arrayList2;
        ArrayList<hof.O00000o0.O00000Oo> arrayList3;
        ArrayList<hof.O00000o0.O0000O0o> arrayList4;
        hof hof2 = hof;
        ObservableEmitter observableEmitter2 = observableEmitter;
        try {
            SparseArray sparseArray = new SparseArray();
            if (!(hof2 == null || (o00000o0 = hof2.O0000oo) == null || (arrayList = o00000o0.O00000oO) == null)) {
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                int i = 0;
                while (i < arrayList.size()) {
                    hof.O00000o0.O0000O0o o0000O0o = arrayList.get(i);
                    ArrayList<hof.O00000o0.O00000Oo> arrayList7 = o0000O0o.O00000oO;
                    if (arrayList7 != null) {
                        ArrayList arrayList8 = new ArrayList();
                        ArrayList arrayList9 = new ArrayList();
                        int i2 = 0;
                        while (i2 < arrayList7.size()) {
                            hof.O00000o0.O00000Oo o00000Oo = arrayList7.get(i2);
                            if (ConstantType.PayloadType.RPC.type == o00000Oo.O00000oO) {
                                arrayList4 = arrayList;
                                arrayList3 = arrayList7;
                                ArrayList<hra> O000000o2 = O000000o(map, o00000Oo.O0000Oo0, o00000Oo.O0000Oo, o00000Oo.O00000oo, o00000Oo.O0000O0o, o00000Oo.O0000OOo);
                                if (O000000o2.size() > 0) {
                                    for (int i3 = 0; i3 < O000000o2.size(); i3++) {
                                        hqm hqm = new hqm(o0000O0o.O00000Oo.intValue(), o00000Oo, O000000o2.get(i3));
                                        if (o0000O0o.O00000o0.intValue() == ConstantType.StyleType.HIDE.styleId) {
                                            arrayList9.add(hqm);
                                        } else {
                                            arrayList8.add(hqm);
                                        }
                                    }
                                }
                            } else {
                                arrayList4 = arrayList;
                                arrayList3 = arrayList7;
                                ConstantType.PayloadType payloadType = ConstantType.PayloadType.PUSH;
                            }
                            i2++;
                            arrayList = arrayList4;
                            arrayList7 = arrayList3;
                        }
                        arrayList2 = arrayList;
                        if (arrayList8.size() > 0) {
                            if (z) {
                                arrayList8.add(0, new RecommendSceneDetailPage.O00000o0(o0000O0o.O00000o, o0000O0o.O00000Oo.intValue()));
                            }
                            arrayList5.add(arrayList8);
                        }
                        if (arrayList9.size() > 0) {
                            arrayList6.add(arrayList9);
                        }
                    } else {
                        arrayList2 = arrayList;
                    }
                    i++;
                    arrayList = arrayList2;
                }
                if (arrayList5.size() > 0) {
                    sparseArray.put(0, arrayList5);
                }
                if (arrayList6.size() > 0) {
                    sparseArray.put(1, arrayList6);
                }
            }
            if (!observableEmitter.isDisposed()) {
                observableEmitter2.onNext(sparseArray);
            }
            LogType logType = LogType.SCENE;
            gsy.O00000o0(logType, "recScene", "make action " + sparseArray.size());
        } catch (Exception e) {
            LogType logType2 = LogType.SCENE;
            gsy.O00000o0(logType2, "recScene", "getActionObservable exception:\n " + e.getMessage());
            if (!observableEmitter.isDisposed()) {
                observableEmitter2.onError(e);
            }
        }
    }

    public static boolean O000000o(Device device, String str) {
        if (device == null || !ConstantType.f10552O000000o.contains(device.model)) {
            return true;
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(device.extra);
        } catch (Exception unused) {
        }
        if (jSONObject == null || !jSONObject.has("fw_version") || fml.O000000o(jSONObject.optString("fw_version"), str) < 0) {
            return false;
        }
        return true;
    }

    public static hrb O000000o(String str, SpecService specService, int i, Object obj, int i2, ArrayList<hof.O0000OOo> arrayList) {
        Iterator<Map.Entry<Integer, SpecEvent>> it;
        Map<Integer, SpecProperty> map;
        hrb hrb;
        Map<Integer, SpecProperty> map2;
        Map<Integer, SpecProperty> map3;
        String str2;
        int i3;
        int i4 = i;
        Object obj2 = obj;
        int i5 = i2;
        ArrayList<hof.O0000OOo> arrayList2 = arrayList;
        if (specService == null) {
            return null;
        }
        Map<Integer, SpecEvent> events = specService.getEvents();
        Map<Integer, SpecProperty> properties = specService.getProperties();
        Iterator<Map.Entry<Integer, SpecEvent>> it2 = events.entrySet().iterator();
        hrb hrb2 = null;
        while (it2.hasNext()) {
            SpecEvent specEvent = (SpecEvent) it2.next().getValue();
            if (TextUtils.equals(specEvent.getTypeName(), str)) {
                if (i4 != 6 || obj2 == null || arrayList2 == null || arrayList.size() <= 0) {
                    hrb hrb3 = new hrb();
                    hrb3.O00000o0 = specService.getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                    hrb3.f542O000000o = "event";
                    hrb3.O00000Oo = specService.getIid();
                    hrb3.O00000oo = specEvent.getIid();
                    hrb3.O0000OOo = i4;
                    hrb3.O0000Oo0 = O000000o(obj2, specService.getIid(), properties);
                    return hrb3;
                }
                boolean z = i5 == 0;
                SparseArray sparseArray = new SparseArray();
                boolean z2 = z;
                int i6 = 0;
                while (true) {
                    if (i6 >= arrayList.size()) {
                        it = it2;
                        map = properties;
                        hrb = hrb2;
                        break;
                    }
                    String str3 = arrayList2.get(i6).O00000Oo;
                    if (TextUtils.isEmpty(str3) || !str3.startsWith("property:")) {
                        it = it2;
                        map = properties;
                        hrb = hrb2;
                        if (i5 == 0) {
                            break;
                        }
                        i6++;
                        it2 = it;
                        hrb2 = hrb;
                        properties = map;
                    } else {
                        int indexOf = str3.indexOf(":");
                        it = it2;
                        if (indexOf < str3.length()) {
                            String substring = str3.substring(indexOf + 1);
                            String str4 = arrayList2.get(i6).O00000o;
                            for (Map.Entry next : properties.entrySet()) {
                                hrb hrb4 = hrb2;
                                if (TextUtils.equals(((SpecProperty) next.getValue()).getTypeName(), substring)) {
                                    str2 = substring;
                                    if (!TextUtils.isEmpty(str4)) {
                                        ConstraintValue constraintValue = ((SpecProperty) next.getValue()).getConstraintValue();
                                        if (constraintValue != null && (constraintValue instanceof ValueList)) {
                                            List<ValueDefinition> values = ((ValueList) constraintValue).values();
                                            int i7 = 0;
                                            while (true) {
                                                if (values == null) {
                                                    map3 = properties;
                                                    i3 = 0;
                                                } else {
                                                    map3 = properties;
                                                    i3 = values.size();
                                                }
                                                if (i7 >= i3) {
                                                    break;
                                                } else if (TextUtils.equals(values.get(i7).description(), str4)) {
                                                    hrb hrb5 = new hrb();
                                                    hrb5.f542O000000o = "prop";
                                                    hrb5.O00000o0 = specService.getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                    hrb5.O0000OOo = arrayList2.get(i6).O00000oO.intValue();
                                                    hrb5.O00000Oo = specService.getIid();
                                                    hrb5.O00000o = ((SpecProperty) next.getValue()).getIid();
                                                    if (values.get(i7).valueObject() != null) {
                                                        try {
                                                            hrb5.O0000Oo0 = values.get(i7).valueObject();
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                        }
                                                        hrb5.O0000Oo0 = obj2;
                                                    }
                                                    sparseArray.put(i6, hrb5);
                                                } else {
                                                    i7++;
                                                    properties = map3;
                                                }
                                            }
                                        }
                                    } else {
                                        map3 = properties;
                                        hrb hrb6 = new hrb();
                                        hrb6.f542O000000o = "prop";
                                        hrb6.O0000OOo = arrayList2.get(i6).O00000oO.intValue();
                                        hrb6.O00000o0 = specService.getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                        hrb6.O00000Oo = specService.getIid();
                                        hrb6.O00000o = ((SpecProperty) next.getValue()).getIid();
                                        hrb6.O0000Oo0 = arrayList2.get(i6).O00000o0;
                                        sparseArray.put(i6, hrb6);
                                    }
                                    substring = str2;
                                    hrb2 = hrb4;
                                    properties = map3;
                                } else {
                                    str2 = substring;
                                }
                                map3 = properties;
                                substring = str2;
                                hrb2 = hrb4;
                                properties = map3;
                            }
                            map = properties;
                            hrb = hrb2;
                            if (sparseArray.get(i6) == null) {
                                if (i5 == 0) {
                                    break;
                                }
                            } else {
                                if (i5 == 1) {
                                    z2 = true;
                                }
                                i6++;
                                it2 = it;
                                hrb2 = hrb;
                                properties = map;
                            }
                        } else if (i5 == 0) {
                            map = properties;
                            hrb = hrb2;
                            break;
                        } else {
                            map = properties;
                            hrb = hrb2;
                        }
                        i6++;
                        it2 = it;
                        hrb2 = hrb;
                        properties = map;
                    }
                }
                z2 = false;
                if (z2) {
                    hrb2 = new hrb();
                    hrb2.f542O000000o = "event";
                    hrb2.O00000Oo = specService.getIid();
                    hrb2.O00000o0 = specService.getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                    hrb2.O00000oo = specEvent.getIid();
                    hrb2.O0000OOo = i4;
                    map2 = map;
                    hrb2.O0000Oo0 = O000000o(obj2, hrb2.O00000Oo, map2);
                    hrb2.O0000O0o = i5;
                    ArrayList arrayList3 = new ArrayList();
                    for (int i8 = 0; i8 < arrayList.size(); i8++) {
                        if (sparseArray.get(i8) != null) {
                            arrayList3.add(sparseArray.get(i8));
                        }
                    }
                    if (arrayList3.size() > 0) {
                        hrb2.O0000Oo = arrayList3;
                    }
                } else {
                    map2 = map;
                    hrb2 = hrb;
                }
                properties = map2;
                it2 = it;
            }
        }
        return hrb2;
    }
}
