package com.xiaomi.smarthome.framework.plugin.rn.nativemodule;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.fwz;
import _m_j.fyf;
import _m_j.gbu;
import _m_j.hol;
import _m_j.hor;
import _m_j.hrb;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.PixelUtil;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ConstraintValue;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueDefinition;
import com.xiaomi.smarthome.device.api.spec.definitions.data.ValueList;
import com.xiaomi.smarthome.device.api.spec.instance.SpecAction;
import com.xiaomi.smarthome.device.api.spec.instance.SpecDevice;
import com.xiaomi.smarthome.device.api.spec.instance.SpecEvent;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MIOTSceneModule extends MIOTBaseJavaModule {
    @ReactMethod
    public void debugLog(String str) {
    }

    @ReactMethod
    public void filterSpecExcludeSource(List<String> list, String str, Callback callback) {
    }

    public String getName() {
        return "MIOTScene";
    }

    public MIOTSceneModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        DeviceStat deviceStat = fwz.O000000o().O00000Oo().O0000o00;
        if (!TextUtils.isEmpty(deviceStat.extrainfo)) {
            try {
                JSONObject jSONObject = new JSONObject(deviceStat.extrainfo);
                if (jSONObject.has("real_did")) {
                    hashMap.put("did", jSONObject.optString("real_did"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        int identifier = reactApplicationContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        hashMap.put("real_status_height", Float.valueOf(identifier > 0 ? PixelUtil.toDIPFromPixel((float) reactApplicationContext.getResources().getDimensionPixelSize(identifier)) : 0.0f));
        return hashMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDeviceHomeInfo(String str) {
        WritableMap createMap = Arguments.createMap();
        Pair<String, String> homeByDevice = hor.O000000o().getHomeByDevice(str);
        if (homeByDevice != null) {
            createMap.putString("home_id", (String) homeByDevice.first);
            createMap.putString("home_name", (String) homeByDevice.second);
        }
        Pair<String, String> roomByDevice = hor.O000000o().getRoomByDevice(str);
        if (roomByDevice != null) {
            createMap.putString("room_id", (String) roomByDevice.first);
            createMap.putString("room_name", (String) roomByDevice.second);
        }
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDeletedDeviceInfo(String str, String str2) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("did", str);
        createMap.putString("model", str2);
        createMap.putString("iconURL", DeviceFactory.O0000oOO(str2));
        createMap.putString("name", DeviceFactory.O0000OoO(str2));
        return createMap;
    }

    @ReactMethod
    public void filterSpecIncludeServiceDevice(List<String> list, String str, String str2, Callback callback) {
        if (list == null) {
            callback.invoke(Boolean.FALSE, "dids is null");
            return;
        }
        WritableMap createMap = Arguments.createMap();
        for (int size = list.size() - 1; size >= 0; size--) {
            String str3 = list.get(size);
            Pair<SpecDevice, Integer> matchSpecInstanceBy = hor.O000000o().matchSpecInstanceBy(str3, str, str2);
            if (matchSpecInstanceBy != null) {
                createMap.putInt(str3, ((Integer) matchSpecInstanceBy.second).intValue());
            }
        }
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("specinstace", createMap);
        callback.invoke(Boolean.TRUE, createMap2);
    }

    @ReactMethod
    public void filterSpecIncludeServiceDevices(ReadableArray readableArray, ReadableArray readableArray2, Callback callback) {
        Pair<SpecDevice, Integer> matchSpecInstanceBy;
        if (readableArray == null) {
            callback.invoke(Boolean.FALSE, "dids is null");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray2.size(); i++) {
            ReadableMap map = readableArray2.getMap(i);
            String string = map.getString("device");
            String string2 = map.getString("service");
            arrayList.add(string + "_" + string2);
        }
        WritableArray createArray = Arguments.createArray();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            String string3 = readableArray.getString(i2);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String[] split = ((String) arrayList.get(i3)).split("_");
                if (split.length == 2 && (matchSpecInstanceBy = hor.O000000o().matchSpecInstanceBy(string3, split[1], split[0])) != null) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putInt("instance", ((Integer) matchSpecInstanceBy.second).intValue());
                    createMap.putString("did", string3);
                    createArray.pushMap(createMap);
                }
            }
        }
        callback.invoke(Boolean.TRUE, createArray);
    }

    @ReactMethod
    public void filterSpecExcludeServiceDevice(List<String> list, String str, String str2, Callback callback) {
        if (list == null) {
            callback.invoke(Boolean.FALSE, "dids is null");
            return;
        }
        WritableMap createMap = Arguments.createMap();
        for (int size = list.size() - 1; size >= 0; size--) {
            String str3 = list.get(size);
            String filterSpecInstanceBy = hor.O000000o().filterSpecInstanceBy(str3, str, str2);
            if (filterSpecInstanceBy != null) {
                createMap.putString(str3, filterSpecInstanceBy);
            }
        }
        Arguments.createMap().putMap("specinstace", createMap);
    }

    @ReactMethod
    public void filterSpecIncludeSource(ReadableArray readableArray, String str, Callback callback) {
        if (readableArray == null) {
            callback.invoke(Boolean.FALSE, "dids is null");
        }
    }

    @ReactMethod
    public void filterDevicesByHome(String str, Callback callback) {
        List<Device> devicesByHomeId = hor.O000000o().getDevicesByHomeId(str);
        if (devicesByHomeId == null) {
            callback.invoke(Boolean.FALSE, "home is null");
            return;
        }
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < devicesByHomeId.size(); i++) {
            WritableMap createMap = Arguments.createMap();
            convertDeviceStat2Map(createMap, devicesByHomeId.get(i));
            createArray.pushMap(createMap);
        }
        callback.invoke(Boolean.TRUE, createArray);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isSupportGeo() {
        return hor.O000000o().isSupportGeo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:194:0x00e3 A[EDGE_INSN: B:194:0x00e3->B:42:0x00e3 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0116 A[EDGE_INSN: B:195:0x0116->B:48:0x0116 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b9 A[LOOP:2: B:36:0x00a9->B:41:0x00b9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ee A[LOOP:3: B:43:0x00e4->B:47:0x00ee, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0121  */
    @ReactMethod
    public void filterConditionTriggerByTemplate(ReadableArray readableArray, String str, ReadableArray readableArray2, ReadableArray readableArray3, String str2, int i, ReadableMap readableMap, Promise promise) {
        JSONObject jSONObject;
        int i2;
        JSONArray jSONArray;
        HashSet hashSet;
        HashSet hashSet2;
        int i3;
        int i4;
        String str3;
        int i5;
        int i6;
        int i7;
        List<Device> list;
        MIOTSceneModule mIOTSceneModule;
        List<Device> list2;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        HashSet hashSet3;
        HashSet hashSet4;
        String str4;
        String str5;
        Object obj;
        int i8;
        MIOTSceneModule mIOTSceneModule2;
        WritableArray writableArray;
        int i9;
        int indexOf;
        String str6;
        JSONArray jSONArray4;
        String str7;
        String str8;
        int i10;
        MIOTSceneModule mIOTSceneModule3;
        List<Device> list3;
        WritableArray writableArray2;
        int i11;
        WritableArray writableArray3;
        JSONArray jSONArray5;
        int i12;
        List<Device> list4;
        String str9;
        MIOTSceneModule mIOTSceneModule4;
        List<Device> list5;
        int i13;
        String str10;
        List<Device> list6;
        String str11;
        int i14;
        int i15;
        JSONArray jSONArray6;
        HashSet hashSet5;
        HashSet hashSet6;
        String str12;
        Object obj2;
        WritableArray writableArray4;
        String str13;
        int i16;
        MIOTSceneModule mIOTSceneModule5 = this;
        ReadableArray readableArray4 = readableArray;
        ReadableArray readableArray5 = readableArray2;
        ReadableArray readableArray6 = readableArray3;
        String str14 = str2;
        int i17 = i;
        Promise promise2 = promise;
        List<Device> devicesByHomeId = hor.O000000o().getDevicesByHomeId(str);
        if (devicesByHomeId == null) {
            promise2.reject("-1", "home is null");
            return;
        }
        Object opt = readableMapToJson(readableMap).opt("value_json");
        if (readableArray4 != null && readableArray.size() > 0) {
            for (int size = devicesByHomeId.size() - 1; size >= 0; size--) {
                boolean z = false;
                for (int i18 = 0; i18 < readableArray.size(); i18++) {
                    if (TextUtils.equals(devicesByHomeId.get(size).did, readableArray4.getString(i18))) {
                        z = true;
                    }
                }
                if (!z) {
                    devicesByHomeId.remove(size);
                }
            }
        }
        JSONArray jSONArray7 = null;
        if (i17 == 6 && (opt instanceof JSONObject)) {
            JSONObject jSONObject2 = (JSONObject) opt;
            if (jSONObject2.has("sub_props")) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("sub_props");
                if (optJSONObject.has("attr")) {
                    jSONArray7 = optJSONObject.optJSONArray("attr");
                }
                if (optJSONObject.has("express")) {
                    jSONArray = jSONArray7;
                    jSONObject = optJSONObject;
                    i2 = optJSONObject.optInt("express");
                    hashSet = new HashSet();
                    hashSet2 = new HashSet();
                    i3 = 0;
                    while (true) {
                        if (readableArray5 == null) {
                            i4 = 0;
                        } else {
                            i4 = readableArray2.size();
                        }
                        str3 = "&";
                        if (i3 >= i4) {
                            break;
                        }
                        ReadableMap map = readableArray5.getMap(i3);
                        hashSet.add(map.getString("device") + str3 + map.getString("service"));
                        i3++;
                        readableArray5 = readableArray2;
                    }
                    i5 = 0;
                    while (true) {
                        if (readableArray6 == null) {
                            i6 = 0;
                        } else {
                            i6 = readableArray3.size();
                        }
                        if (i5 >= i6) {
                            break;
                        }
                        ReadableMap map2 = readableArray6.getMap(i5);
                        hashSet2.add(map2.getString("device") + str3 + map2.getString("service"));
                        i5++;
                        readableArray6 = readableArray3;
                    }
                    WritableArray createArray = Arguments.createArray();
                    i7 = 0;
                    while (i7 < list.size()) {
                        SpecDevice specDeviceBy = hor.O000000o().getSpecDeviceBy(list.get(i7));
                        if (specDeviceBy != null) {
                            String typeName = specDeviceBy.getTypeName();
                            Map<Integer, SpecService> services = specDeviceBy.getServices();
                            if (services != null) {
                                for (Map.Entry next : services.entrySet()) {
                                    String typeName2 = ((SpecService) next.getValue()).getTypeName();
                                    JSONArray jSONArray8 = jSONArray;
                                    if (hashSet.contains(typeName + str3 + typeName2)) {
                                        if (!hashSet2.contains(typeName + str3 + typeName2)) {
                                            String str15 = typeName;
                                            if (!TextUtils.equals(typeName.toLowerCase(), "lock") || !TextUtils.equals(typeName2.toLowerCase(), "lock") || hor.O000000o().lockCanVisible(list.get(i7))) {
                                                if (!TextUtils.isEmpty(str2)) {
                                                    Map<Integer, SpecProperty> properties = ((SpecService) next.getValue()).getProperties();
                                                    String str16 = "prop";
                                                    String str17 = "type";
                                                    str5 = str3;
                                                    String str18 = ":";
                                                    if (str14.startsWith(str16)) {
                                                        int indexOf2 = str14.indexOf(str18);
                                                        if (indexOf2 < str2.length()) {
                                                            String substring = str14.substring(indexOf2 + 1);
                                                            for (Map.Entry<Integer, SpecProperty> value : properties.entrySet()) {
                                                                if (TextUtils.equals(((SpecProperty) value.getValue()).getTypeName(), substring)) {
                                                                    str12 = str15;
                                                                    str13 = str17;
                                                                    i16 = i7;
                                                                    hashSet6 = hashSet2;
                                                                    hashSet5 = hashSet;
                                                                    jSONArray6 = jSONArray8;
                                                                    Object obj3 = opt;
                                                                    i15 = i2;
                                                                    obj2 = opt;
                                                                    writableArray4 = createArray;
                                                                    hrb filterSpecInstanceBy = hor.O000000o().filterSpecInstanceBy(specDeviceBy, ((SpecService) next.getValue()).getIid(), str2, i, obj3, i2, jSONArray6);
                                                                    if (filterSpecInstanceBy != null) {
                                                                        WritableMap createMap = Arguments.createMap();
                                                                        createMap.putString(str13, "device");
                                                                        mIOTSceneModule.createSpecSceneParam(createMap, list.get(i16), filterSpecInstanceBy);
                                                                        writableArray4.pushMap(createMap);
                                                                    }
                                                                } else {
                                                                    str12 = str15;
                                                                    str13 = str17;
                                                                    i16 = i7;
                                                                    hashSet6 = hashSet2;
                                                                    hashSet5 = hashSet;
                                                                    i15 = i2;
                                                                    jSONArray6 = jSONArray8;
                                                                    obj2 = opt;
                                                                    writableArray4 = createArray;
                                                                }
                                                                i2 = i15;
                                                                i7 = i16;
                                                                str17 = str13;
                                                                createArray = writableArray4;
                                                                opt = obj2;
                                                                hashSet2 = hashSet6;
                                                                hashSet = hashSet5;
                                                                jSONArray8 = jSONArray6;
                                                                str15 = str12;
                                                            }
                                                        }
                                                        jSONArray2 = jSONArray8;
                                                        i2 = i2;
                                                        i7 = i7;
                                                        createArray = createArray;
                                                        opt = opt;
                                                        str3 = str5;
                                                        typeName = str15;
                                                        hashSet2 = hashSet2;
                                                        hashSet = hashSet;
                                                    } else {
                                                        str4 = str15;
                                                        String str19 = str17;
                                                        int i19 = i7;
                                                        hashSet4 = hashSet2;
                                                        hashSet3 = hashSet;
                                                        int i20 = i2;
                                                        JSONArray jSONArray9 = jSONArray8;
                                                        obj = opt;
                                                        WritableArray writableArray5 = createArray;
                                                        if (str14.startsWith("event") && (indexOf = str14.indexOf(str18)) < str2.length()) {
                                                            String substring2 = str14.substring(indexOf + 1);
                                                            for (Map.Entry<Integer, SpecEvent> value2 : ((SpecService) next.getValue()).getEvents().entrySet()) {
                                                                SpecEvent specEvent = (SpecEvent) value2.getValue();
                                                                if (TextUtils.equals(specEvent.getTypeName(), substring2)) {
                                                                    int i21 = i19;
                                                                    int i22 = i;
                                                                    if (i22 != 6 || obj == null || jSONObject == null || jSONArray9.length() <= 0) {
                                                                        String str20 = substring2;
                                                                        list3 = list;
                                                                        JSONArray jSONArray10 = jSONArray9;
                                                                        mIOTSceneModule3 = mIOTSceneModule;
                                                                        str6 = str18;
                                                                        i10 = i20;
                                                                        i11 = i21;
                                                                        str8 = str16;
                                                                        WritableArray writableArray6 = writableArray5;
                                                                        String str21 = "value_type";
                                                                        str7 = str20;
                                                                        jSONArray4 = jSONArray10;
                                                                        hrb filterSpecInstanceBy2 = hor.O000000o().filterSpecInstanceBy(specDeviceBy, ((SpecService) next.getValue()).getIid(), str2, i, obj, i10, jSONArray10);
                                                                        if (filterSpecInstanceBy2 != null) {
                                                                            WritableMap createMap2 = Arguments.createMap();
                                                                            createMap2.putString(str19, "device");
                                                                            createMap2.putInt(str21, i22);
                                                                            mIOTSceneModule3.createSpecSceneParam(createMap2, list3.get(i11), filterSpecInstanceBy2);
                                                                            writableArray2 = writableArray6;
                                                                            writableArray2.pushMap(createMap2);
                                                                        } else {
                                                                            writableArray2 = writableArray6;
                                                                        }
                                                                    } else {
                                                                        int i23 = i20;
                                                                        boolean z2 = i23 == 0;
                                                                        SparseArray sparseArray = new SparseArray();
                                                                        boolean z3 = z2;
                                                                        String str22 = substring2;
                                                                        int i24 = 0;
                                                                        while (true) {
                                                                            writableArray3 = writableArray5;
                                                                            if (i24 >= jSONArray9.length()) {
                                                                                jSONArray5 = jSONArray9;
                                                                                i12 = i21;
                                                                                list4 = list;
                                                                                str9 = str18;
                                                                                break;
                                                                            }
                                                                            jSONArray5 = jSONArray9;
                                                                            if (jSONArray5.optJSONObject(i24) != null) {
                                                                                i12 = i21;
                                                                                String optString = jSONArray5.optJSONObject(i24).optString("key");
                                                                                if (TextUtils.isEmpty(optString) || !optString.startsWith("property:")) {
                                                                                    list4 = list;
                                                                                    str9 = str18;
                                                                                    if (i23 == 0) {
                                                                                        break;
                                                                                    }
                                                                                    i24++;
                                                                                    str18 = str9;
                                                                                    writableArray5 = writableArray3;
                                                                                    jSONArray9 = jSONArray5;
                                                                                    i21 = i12;
                                                                                    list = list4;
                                                                                } else {
                                                                                    int indexOf3 = optString.indexOf(str18);
                                                                                    str9 = str18;
                                                                                    if (indexOf3 < optString.length()) {
                                                                                        String substring3 = optString.substring(indexOf3 + 1);
                                                                                        String optString2 = jSONArray5.optJSONObject(i24).optString("description");
                                                                                        Iterator<Map.Entry<Integer, SpecProperty>> it = properties.entrySet().iterator();
                                                                                        while (it.hasNext()) {
                                                                                            Map.Entry next2 = it.next();
                                                                                            Iterator<Map.Entry<Integer, SpecProperty>> it2 = it;
                                                                                            if (TextUtils.equals(((SpecProperty) next2.getValue()).getTypeName(), substring3)) {
                                                                                                if (!TextUtils.isEmpty(optString2)) {
                                                                                                    ConstraintValue constraintValue = ((SpecProperty) next2.getValue()).getConstraintValue();
                                                                                                    if (constraintValue != null) {
                                                                                                        str11 = substring3;
                                                                                                        if (constraintValue instanceof ValueList) {
                                                                                                            List<ValueDefinition> values = ((ValueList) constraintValue).values();
                                                                                                            int i25 = 0;
                                                                                                            while (true) {
                                                                                                                if (values == null) {
                                                                                                                    list6 = list;
                                                                                                                    i14 = 0;
                                                                                                                } else {
                                                                                                                    list6 = list;
                                                                                                                    i14 = values.size();
                                                                                                                }
                                                                                                                if (i25 >= i14) {
                                                                                                                    str10 = optString2;
                                                                                                                    break;
                                                                                                                } else if (TextUtils.equals(values.get(i25).description(), optString2)) {
                                                                                                                    hrb hrb = new hrb();
                                                                                                                    hrb.f542O000000o = str16;
                                                                                                                    str10 = optString2;
                                                                                                                    hrb.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                                                                                    hrb.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                                                                                    hrb.O00000o = ((SpecProperty) next2.getValue()).getIid();
                                                                                                                    hrb.O0000Oo0 = values.get(i25).valueObject().toString();
                                                                                                                    hrb.O0000OOo = jSONArray5.optJSONObject(i24).optInt("value_type");
                                                                                                                    sparseArray.put(i24, hrb);
                                                                                                                    break;
                                                                                                                } else {
                                                                                                                    i25++;
                                                                                                                    list = list6;
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    } else {
                                                                                                        str11 = substring3;
                                                                                                    }
                                                                                                } else {
                                                                                                    str11 = substring3;
                                                                                                    str10 = optString2;
                                                                                                    list6 = list;
                                                                                                    hrb hrb2 = new hrb();
                                                                                                    hrb2.f542O000000o = str16;
                                                                                                    hrb2.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                                                                    hrb2.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                                                                    hrb2.O00000o = ((SpecProperty) next2.getValue()).getIid();
                                                                                                    hrb2.O0000Oo0 = jSONArray5.optJSONObject(i24).optString("value");
                                                                                                    hrb2.O0000OOo = jSONArray5.optJSONObject(i24).optInt("value_type");
                                                                                                    sparseArray.put(i24, hrb2);
                                                                                                }
                                                                                                substring3 = str11;
                                                                                                it = it2;
                                                                                                list = list6;
                                                                                                optString2 = str10;
                                                                                            } else {
                                                                                                str11 = substring3;
                                                                                            }
                                                                                            str10 = optString2;
                                                                                            list6 = list;
                                                                                            substring3 = str11;
                                                                                            it = it2;
                                                                                            list = list6;
                                                                                            optString2 = str10;
                                                                                        }
                                                                                        list4 = list;
                                                                                        if (sparseArray.get(i24) == null) {
                                                                                            if (i23 == 0) {
                                                                                                break;
                                                                                            }
                                                                                        } else {
                                                                                            if (i23 == 1) {
                                                                                                z3 = true;
                                                                                            }
                                                                                            i24++;
                                                                                            str18 = str9;
                                                                                            writableArray5 = writableArray3;
                                                                                            jSONArray9 = jSONArray5;
                                                                                            i21 = i12;
                                                                                            list = list4;
                                                                                        }
                                                                                    } else if (i23 == 0) {
                                                                                        list4 = list;
                                                                                        break;
                                                                                    } else {
                                                                                        list4 = list;
                                                                                    }
                                                                                }
                                                                            } else {
                                                                                i12 = i21;
                                                                                list4 = list;
                                                                                str9 = str18;
                                                                            }
                                                                            i24++;
                                                                            str18 = str9;
                                                                            writableArray5 = writableArray3;
                                                                            jSONArray9 = jSONArray5;
                                                                            i21 = i12;
                                                                            list = list4;
                                                                        }
                                                                        z3 = false;
                                                                        if (z3) {
                                                                            hrb hrb3 = new hrb();
                                                                            hrb3.f542O000000o = "event";
                                                                            hrb3.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                                            hrb3.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                                            hrb3.O00000oo = specEvent.getIid();
                                                                            hrb3.O0000OOo = i22;
                                                                            ArrayList arrayList = new ArrayList();
                                                                            for (int i26 = 0; i26 < jSONArray5.length(); i26++) {
                                                                                if (sparseArray.get(i26) != null) {
                                                                                    arrayList.add(sparseArray.get(i26));
                                                                                }
                                                                            }
                                                                            if (arrayList.size() > 0) {
                                                                                hrb3.O0000O0o = i23;
                                                                                hrb3.O0000Oo = arrayList;
                                                                            }
                                                                            WritableMap createMap3 = Arguments.createMap();
                                                                            createMap3.putString(str19, "device");
                                                                            i13 = i12;
                                                                            list5 = list4;
                                                                            mIOTSceneModule4 = this;
                                                                            mIOTSceneModule4.createSpecSceneParam(createMap3, list5.get(i13), hrb3);
                                                                            writableArray5 = writableArray3;
                                                                            writableArray5.pushMap(createMap3);
                                                                        } else {
                                                                            mIOTSceneModule4 = this;
                                                                            writableArray5 = writableArray3;
                                                                            i13 = i12;
                                                                            list5 = list4;
                                                                        }
                                                                        str18 = str9;
                                                                        i20 = i23;
                                                                        i19 = i13;
                                                                        jSONArray9 = jSONArray5;
                                                                        mIOTSceneModule = mIOTSceneModule4;
                                                                        substring2 = str22;
                                                                        list = list5;
                                                                    }
                                                                } else {
                                                                    jSONArray4 = jSONArray9;
                                                                    str8 = str16;
                                                                    str7 = substring2;
                                                                    list3 = list;
                                                                    writableArray2 = writableArray5;
                                                                    str6 = str18;
                                                                    i10 = i20;
                                                                    mIOTSceneModule3 = mIOTSceneModule;
                                                                    i11 = i19;
                                                                }
                                                                i19 = i11;
                                                                writableArray5 = writableArray2;
                                                                mIOTSceneModule = mIOTSceneModule3;
                                                                i20 = i10;
                                                                str16 = str8;
                                                                substring2 = str7;
                                                                str18 = str6;
                                                                list = list3;
                                                                jSONArray9 = jSONArray4;
                                                            }
                                                        }
                                                        jSONArray3 = jSONArray9;
                                                        i8 = i20;
                                                        list2 = list;
                                                        writableArray = writableArray5;
                                                        mIOTSceneModule2 = mIOTSceneModule;
                                                        i9 = i19;
                                                    }
                                                } else {
                                                    str4 = str15;
                                                    hashSet4 = hashSet2;
                                                    hashSet3 = hashSet;
                                                    writableArray = createArray;
                                                    list2 = list;
                                                    str5 = str3;
                                                    jSONArray3 = jSONArray8;
                                                    mIOTSceneModule2 = mIOTSceneModule;
                                                    i9 = i7;
                                                    i8 = i2;
                                                    obj = opt;
                                                }
                                                i7 = i9;
                                                createArray = writableArray;
                                                mIOTSceneModule = mIOTSceneModule2;
                                                i2 = i8;
                                                opt = obj;
                                                str3 = str5;
                                                typeName = str4;
                                                hashSet2 = hashSet4;
                                                hashSet = hashSet3;
                                                jSONArray2 = jSONArray3;
                                                list = list2;
                                                str14 = str2;
                                            } else {
                                                typeName = str15;
                                                jSONArray2 = jSONArray8;
                                            }
                                        }
                                    }
                                    list2 = list;
                                    jSONArray2 = jSONArray8;
                                    list = list2;
                                    str14 = str2;
                                }
                            }
                        }
                        i7++;
                        promise2 = promise;
                        createArray = createArray;
                        mIOTSceneModule5 = mIOTSceneModule;
                        i2 = i2;
                        opt = opt;
                        str3 = str3;
                        hashSet2 = hashSet2;
                        hashSet = hashSet;
                        jSONArray = jSONArray;
                        devicesByHomeId = list;
                        str14 = str2;
                    }
                    promise2.resolve(createArray);
                }
                jSONArray = jSONArray7;
                jSONObject = optJSONObject;
                i2 = 0;
                hashSet = new HashSet();
                hashSet2 = new HashSet();
                i3 = 0;
                while (true) {
                    if (readableArray5 == null) {
                    }
                    str3 = "&";
                    if (i3 >= i4) {
                    }
                    ReadableMap map3 = readableArray5.getMap(i3);
                    hashSet.add(map3.getString("device") + str3 + map3.getString("service"));
                    i3++;
                    readableArray5 = readableArray2;
                }
                i5 = 0;
                while (true) {
                    if (readableArray6 == null) {
                    }
                    if (i5 >= i6) {
                    }
                    ReadableMap map22 = readableArray6.getMap(i5);
                    hashSet2.add(map22.getString("device") + str3 + map22.getString("service"));
                    i5++;
                    readableArray6 = readableArray3;
                }
                WritableArray createArray2 = Arguments.createArray();
                i7 = 0;
                while (i7 < list.size()) {
                }
                promise2.resolve(createArray2);
            }
        }
        jSONArray = null;
        jSONObject = null;
        i2 = 0;
        hashSet = new HashSet();
        hashSet2 = new HashSet();
        i3 = 0;
        while (true) {
            if (readableArray5 == null) {
            }
            str3 = "&";
            if (i3 >= i4) {
            }
            ReadableMap map32 = readableArray5.getMap(i3);
            hashSet.add(map32.getString("device") + str3 + map32.getString("service"));
            i3++;
            readableArray5 = readableArray2;
        }
        i5 = 0;
        while (true) {
            if (readableArray6 == null) {
            }
            if (i5 >= i6) {
            }
            ReadableMap map222 = readableArray6.getMap(i5);
            hashSet2.add(map222.getString("device") + str3 + map222.getString("service"));
            i5++;
            readableArray6 = readableArray3;
        }
        WritableArray createArray22 = Arguments.createArray();
        i7 = 0;
        while (i7 < list.size()) {
        }
        promise2.resolve(createArray22);
    }

    @ReactMethod
    public void filterActionByTemplate(ReadableArray readableArray, String str, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5, Promise promise) {
        int i;
        String str2;
        int i2;
        String str3;
        ReadableArray readableArray6;
        HashMap hashMap;
        WritableArray writableArray;
        Iterator<Map.Entry<Integer, SpecAction>> it;
        HashMap hashMap2;
        String str4;
        String str5;
        WritableArray writableArray2;
        String str6;
        HashMap hashMap3;
        String str7;
        String str8;
        HashSet hashSet;
        int i3;
        ReadableArray readableArray7 = readableArray;
        ReadableArray readableArray8 = readableArray2;
        ReadableArray readableArray9 = readableArray3;
        ReadableArray readableArray10 = readableArray4;
        ReadableArray readableArray11 = readableArray5;
        Promise promise2 = promise;
        List<Device> devicesByHomeId = hor.O000000o().getDevicesByHomeId(str);
        if (devicesByHomeId == null) {
            promise2.reject("-1", "home is null");
            return;
        }
        if (readableArray7 != null && readableArray.size() > 0) {
            for (int size = devicesByHomeId.size() - 1; size >= 0; size--) {
                boolean z = false;
                for (int i4 = 0; i4 < readableArray.size(); i4++) {
                    if (TextUtils.equals(devicesByHomeId.get(size).did, readableArray7.getString(i4))) {
                        z = true;
                    }
                }
                if (!z) {
                    devicesByHomeId.remove(size);
                }
            }
        }
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        int i5 = 0;
        while (true) {
            if (readableArray8 == null) {
                i = 0;
            } else {
                i = readableArray2.size();
            }
            str2 = "&";
            if (i5 >= i) {
                break;
            }
            ReadableMap map = readableArray8.getMap(i5);
            hashSet2.add(map.getString("device") + str2 + map.getString("service"));
            i5++;
        }
        int i6 = 0;
        while (true) {
            if (readableArray9 == null) {
                i2 = 0;
            } else {
                i2 = readableArray3.size();
            }
            if (i6 >= i2) {
                break;
            }
            ReadableMap map2 = readableArray9.getMap(i6);
            hashSet3.add(map2.getString("device") + str2 + map2.getString("service"));
            i6++;
        }
        HashMap hashMap4 = new HashMap();
        String str9 = "property";
        if (readableArray11 != null) {
            for (int i7 = 0; i7 < readableArray5.size(); i7++) {
                hashMap4.put(readableArray11.getMap(i7).getString(str9), readableArray11.getMap(i7));
            }
        }
        HashMap hashMap5 = new HashMap();
        String str10 = "action";
        if (readableArray10 != null) {
            for (int i8 = 0; i8 < readableArray4.size(); i8++) {
                hashMap5.put(readableArray10.getMap(i8).getString(str10), readableArray10.getMap(i8));
            }
        }
        WritableArray createArray = Arguments.createArray();
        int i9 = 0;
        while (i9 < devicesByHomeId.size()) {
            SpecDevice specDeviceBy = hor.O000000o().getSpecDeviceBy(devicesByHomeId.get(i9));
            if (specDeviceBy != null) {
                String typeName = specDeviceBy.getTypeName();
                Map<Integer, SpecService> services = specDeviceBy.getServices();
                if (services != null) {
                    Iterator<Map.Entry<Integer, SpecService>> it2 = services.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        Iterator<Map.Entry<Integer, SpecService>> it3 = it2;
                        String typeName2 = ((SpecService) next.getValue()).getTypeName();
                        String str11 = str3;
                        if (hashSet2.contains(typeName + str2 + typeName2)) {
                            if (!hashSet3.contains(typeName + str2 + typeName2)) {
                                HashSet hashSet4 = hashSet2;
                                if (!TextUtils.equals(typeName.toLowerCase(), "lock") || !TextUtils.equals(typeName2.toLowerCase(), "lock") || hor.O000000o().lockCanVisible(devicesByHomeId.get(i9))) {
                                    if (readableArray6 != null && readableArray5.size() > 0) {
                                        for (Map.Entry next2 : ((SpecService) next.getValue()).getProperties().entrySet()) {
                                            SpecProperty specProperty = (SpecProperty) next2.getValue();
                                            if (hashMap4.containsKey(specProperty.getTypeName())) {
                                                ReadableMap readableMap = (ReadableMap) hashMap4.get(specProperty.getTypeName());
                                                hashSet = hashSet3;
                                                String string = readableMap.getString("desc");
                                                str8 = str2;
                                                ConstraintValue constraintValue = specProperty.getConstraintValue();
                                                str6 = typeName;
                                                str7 = str9;
                                                if (readableMap == null || TextUtils.isEmpty(string) || constraintValue == null) {
                                                    hashMap3 = hashMap5;
                                                } else {
                                                    hashMap3 = hashMap5;
                                                    if (constraintValue instanceof ValueList) {
                                                        List<ValueDefinition> values = ((ValueList) constraintValue).values();
                                                        int i10 = 0;
                                                        while (true) {
                                                            if (values == null) {
                                                                i3 = 0;
                                                            } else {
                                                                i3 = values.size();
                                                            }
                                                            if (i10 >= i3) {
                                                                break;
                                                            } else if (TextUtils.equals(values.get(i10).description(), string)) {
                                                                hrb hrb = new hrb();
                                                                hrb.f542O000000o = "prop";
                                                                hrb.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                                hrb.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                                hrb.O00000o = ((SpecProperty) next2.getValue()).getIid();
                                                                hrb.O0000OOo = readableMap.getInt("valueType");
                                                                hrb.O0000Oo0 = values.get(i10).valueObject();
                                                                WritableMap createMap = Arguments.createMap();
                                                                createMap.putString("type", "device");
                                                                createSpecSceneParam(createMap, devicesByHomeId.get(i9), hrb);
                                                                createArray.pushMap(createMap);
                                                                break;
                                                            } else {
                                                                i10++;
                                                            }
                                                        }
                                                    }
                                                }
                                                hrb hrb2 = new hrb();
                                                hrb2.f542O000000o = "prop";
                                                hrb2.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                hrb2.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                hrb2.O00000o = ((SpecProperty) next2.getValue()).getIid();
                                                hrb2.O0000OOo = ((ReadableMap) hashMap4.get(specProperty.getTypeName())).getInt("valueType");
                                                hrb2.O0000Oo0 = getRealValueByType((ReadableMap) hashMap4.get(specProperty.getTypeName()), hrb2.O0000OOo);
                                                WritableMap createMap2 = Arguments.createMap();
                                                createMap2.putString("type", "device");
                                                createSpecSceneParam(createMap2, devicesByHomeId.get(i9), hrb2);
                                                createArray.pushMap(createMap2);
                                            } else {
                                                str7 = str9;
                                                hashSet = hashSet3;
                                                hashMap3 = hashMap5;
                                                str8 = str2;
                                                str6 = typeName;
                                            }
                                            typeName = str6;
                                            hashSet3 = hashSet;
                                            str2 = str8;
                                            str9 = str7;
                                            hashMap5 = hashMap3;
                                        }
                                    }
                                    String str12 = str9;
                                    HashSet hashSet5 = hashSet3;
                                    HashMap hashMap6 = hashMap5;
                                    String str13 = str2;
                                    String str14 = typeName;
                                    if (readableArray4 != null && readableArray4.size() > 0) {
                                        Map<Integer, SpecAction> actions = ((SpecService) next.getValue()).getActions();
                                        Map<Integer, SpecProperty> properties = ((SpecService) next.getValue()).getProperties();
                                        Iterator<Map.Entry<Integer, SpecAction>> it4 = actions.entrySet().iterator();
                                        while (it4.hasNext()) {
                                            SpecAction specAction = (SpecAction) it4.next().getValue();
                                            HashMap hashMap7 = hashMap6;
                                            if (hashMap7.containsKey(specAction.getTypeName())) {
                                                ReadableArray array = ((ReadableMap) hashMap7.get(specAction.getTypeName())).getArray("in");
                                                List<Object> in2 = specAction.getIn();
                                                if ((array == null || array.size() == 0) && (in2 == null || in2.size() == 0)) {
                                                    hashMap2 = hashMap4;
                                                    it = it4;
                                                    writableArray2 = createArray;
                                                    hashMap6 = hashMap7;
                                                    str4 = str12;
                                                    str5 = str11;
                                                    hrb hrb3 = new hrb();
                                                    hrb3.f542O000000o = str5;
                                                    hrb3.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                    hrb3.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                    hrb3.O00000oO = specAction.getIid();
                                                    hrb3.O0000Oo = getActionSubProps(array, hrb3.O00000Oo, properties);
                                                    WritableMap createMap3 = Arguments.createMap();
                                                    createMap3.putString("type", "device");
                                                    createSpecSceneParam(createMap3, devicesByHomeId.get(i9), hrb3);
                                                    writableArray2.pushMap(createMap3);
                                                    str11 = str5;
                                                    str12 = str4;
                                                    it4 = it;
                                                    createArray = writableArray2;
                                                    hashMap4 = hashMap2;
                                                } else if (!(array == null || in2 == null || array.size() <= 0)) {
                                                    hashMap2 = hashMap4;
                                                    if (in2.size() >= array.size()) {
                                                        ArrayList arrayList = new ArrayList();
                                                        ArrayList arrayList2 = new ArrayList();
                                                        it = it4;
                                                        hashMap6 = hashMap7;
                                                        int i11 = 0;
                                                        while (i11 < array.size()) {
                                                            arrayList.add(array.getMap(i11).getString(str12));
                                                            i11++;
                                                            createArray = createArray;
                                                        }
                                                        WritableArray writableArray3 = createArray;
                                                        str4 = str12;
                                                        for (int i12 = 0; i12 < in2.size(); i12++) {
                                                            if (properties.containsKey(in2.get(i12))) {
                                                                arrayList2.add(properties.get(in2.get(i12)).getTypeName());
                                                            }
                                                        }
                                                        if (arrayList2.containsAll(arrayList)) {
                                                            hrb hrb4 = new hrb();
                                                            str5 = str11;
                                                            hrb4.f542O000000o = str5;
                                                            hrb4.O00000Oo = ((SpecService) next.getValue()).getIid();
                                                            hrb4.O00000o0 = ((SpecService) next.getValue()).getDescription().toLowerCase().replaceAll("\\s", "").toLowerCase();
                                                            hrb4.O00000oO = specAction.getIid();
                                                            hrb4.O0000Oo = getActionSubProps(array, hrb4.O00000Oo, properties);
                                                            WritableMap createMap4 = Arguments.createMap();
                                                            createMap4.putString("type", "device");
                                                            createSpecSceneParam(createMap4, devicesByHomeId.get(i9), hrb4);
                                                            writableArray2 = writableArray3;
                                                            writableArray2.pushMap(createMap4);
                                                        } else {
                                                            str5 = str11;
                                                            writableArray2 = writableArray3;
                                                        }
                                                        str11 = str5;
                                                        str12 = str4;
                                                        it4 = it;
                                                        createArray = writableArray2;
                                                        hashMap4 = hashMap2;
                                                    }
                                                    it = it4;
                                                    writableArray2 = createArray;
                                                    hashMap6 = hashMap7;
                                                    str4 = str12;
                                                    str5 = str11;
                                                    str11 = str5;
                                                    str12 = str4;
                                                    it4 = it;
                                                    createArray = writableArray2;
                                                    hashMap4 = hashMap2;
                                                }
                                            }
                                            hashMap2 = hashMap4;
                                            it = it4;
                                            writableArray2 = createArray;
                                            hashMap6 = hashMap7;
                                            str4 = str12;
                                            str5 = str11;
                                            str11 = str5;
                                            str12 = str4;
                                            it4 = it;
                                            createArray = writableArray2;
                                            hashMap4 = hashMap2;
                                        }
                                    }
                                    hashMap = hashMap4;
                                    writableArray = createArray;
                                    it2 = it3;
                                    typeName = str14;
                                    readableArray6 = readableArray5;
                                    str3 = str11;
                                    str9 = str12;
                                    hashSet2 = hashSet4;
                                    hashSet3 = hashSet5;
                                    str2 = str13;
                                    hashMap5 = hashMap6;
                                    createArray = writableArray;
                                    hashMap4 = hashMap;
                                } else {
                                    it2 = it3;
                                    str3 = str11;
                                    hashSet2 = hashSet4;
                                }
                            }
                        }
                        hashMap = hashMap4;
                        writableArray = createArray;
                        it2 = it3;
                        str3 = str11;
                        readableArray6 = readableArray5;
                        createArray = writableArray;
                        hashMap4 = hashMap;
                    }
                }
            }
            HashMap hashMap8 = hashMap4;
            i9++;
            readableArray11 = readableArray5;
            promise2 = promise;
            str10 = str3;
            str9 = str9;
            hashSet2 = hashSet2;
            hashSet3 = hashSet3;
            str2 = str2;
            hashMap5 = hashMap5;
            createArray = createArray;
            hashMap4 = hashMap8;
        }
        promise2.resolve(createArray);
    }

    private Object getRealValueByType(ReadableMap readableMap, int i) {
        if (!readableMap.hasKey("value_json")) {
            return null;
        }
        switch (i) {
            case 1:
                return Integer.valueOf(readableMap.getInt("value_json"));
            case 2:
                return Double.valueOf(readableMap.getDouble("value_json"));
            case 3:
            case 6:
                return readableMap.getMap("value_json");
            case 4:
                return Boolean.valueOf(readableMap.getBoolean("value_json"));
            case 5:
                return readableMap.getString("value_json");
            default:
                return null;
        }
    }

    private void putRealValue2Map(WritableMap writableMap, Object obj) {
        if (obj != null) {
            if (obj instanceof Integer) {
                writableMap.putInt("value_json", ((Integer) obj).intValue());
            } else if (obj instanceof Double) {
                writableMap.putDouble("value_json", ((Double) obj).doubleValue());
            } else if (obj instanceof Boolean) {
                writableMap.putBoolean("value_json", ((Boolean) obj).booleanValue());
            } else if (obj instanceof JSONObject) {
                WritableMap createMap = Arguments.createMap();
                fyf.O000000o((JSONObject) obj, createMap);
                writableMap.putMap("value_json", createMap);
            } else if (obj instanceof String) {
                writableMap.putString("value_json", (String) obj);
            }
        }
    }

    private List<hrb> getActionSubProps(ReadableArray readableArray, int i, Map<Integer, SpecProperty> map) {
        ArrayList arrayList = new ArrayList();
        if (!(readableArray == null || readableArray.size() == 0)) {
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                for (Map.Entry next : map.entrySet()) {
                    if (TextUtils.equals(readableArray.getMap(i2).getString("property"), ((SpecProperty) next.getValue()).getTypeName())) {
                        hrb hrb = new hrb();
                        hrb.f542O000000o = "prop";
                        hrb.O00000Oo = i;
                        hrb.O00000o = ((SpecProperty) next.getValue()).getIid();
                        hrb.O0000OOo = readableArray.getMap(i2).getInt("value_type");
                        hrb.O0000Oo0 = getRealValueByType(readableArray.getMap(i2), hrb.O0000OOo);
                        arrayList.add(hrb);
                    }
                }
            }
        }
        return arrayList;
    }

    @ReactMethod
    public void saveHome(ReadableMap readableMap, final Promise promise) {
        hol O000000o2 = hor.O000000o();
        String string = readableMap.getString("home_id");
        String string2 = readableMap.getString("city_id");
        String string3 = readableMap.getString("home_addr");
        StringBuilder sb = new StringBuilder();
        sb.append(readableMap.getDouble("longitude"));
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(readableMap.getDouble("latitude"));
        O000000o2.saveHome(string, string2, string3, sb2, sb3.toString(), new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass1 */

            public final void onFailure(int i, String str) {
                promise.reject(String.valueOf(i), str);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                promise.resolve("");
            }
        });
    }

    @ReactMethod
    public void saveScenes(ReadableArray readableArray, final Promise promise) {
        if (promise != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(readableArray.getString(i));
            }
            hor.O000000o().editScenes(arrayList, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass2 */

                public final void onFailure(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    promise.resolve("");
                }
            });
        }
    }

    @ReactMethod
    public void delScenes(ReadableArray readableArray, final Promise promise) {
        if (promise != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < readableArray.size(); i++) {
                arrayList.add(readableArray.getString(i));
            }
            hor.O000000o().delScenes(arrayList, new com.xiaomi.smarthome.device.api.Callback<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass3 */

                public final void onFailure(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    promise.resolve("");
                }
            });
        }
    }

    private void createSpecSceneParam(WritableMap writableMap, Device device, hrb hrb) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        WritableMap createMap3 = Arguments.createMap();
        if (device != null) {
            convertDeviceStat2Map(createMap, device);
            if (TextUtils.equals(hrb.f542O000000o, "prop")) {
                String deviceDisplayName = hor.O000000o().getDeviceDisplayName(device.did, hrb.O00000Oo, hrb.O00000o);
                if (!TextUtils.isEmpty(deviceDisplayName)) {
                    createMap.putString("display_name", device.name + " | " + deviceDisplayName);
                }
            }
            writableMap.putMap("device", createMap);
            Pair<String, String> homeByDevice = hor.O000000o().getHomeByDevice(device.did);
            if (homeByDevice != null) {
                createMap2.putString("home_id", (String) homeByDevice.first);
                createMap2.putString("home_name", (String) homeByDevice.second);
            }
            Pair<String, String> roomByDevice = hor.O000000o().getRoomByDevice(device.did);
            if (roomByDevice != null) {
                createMap2.putString("room_id", (String) roomByDevice.first);
                createMap2.putString("room_name", (String) roomByDevice.second);
            }
            writableMap.putMap("home", createMap2);
        }
        if (hrb != null) {
            convertSpecSceneParam2Map(createMap3, hrb);
            writableMap.putMap("instance_param", createMap3);
        }
    }

    private void convertSpecSceneParam2Map(WritableMap writableMap, hrb hrb) {
        if (hrb != null) {
            writableMap.putString("type", hrb.f542O000000o);
            writableMap.putInt("siid", hrb.O00000Oo);
            writableMap.putInt("piid", hrb.O00000o);
            writableMap.putInt("eiid", hrb.O00000oo);
            writableMap.putInt("aiid", hrb.O00000oO);
            writableMap.putInt("value_type", hrb.O0000OOo);
            putRealValue2Map(writableMap, hrb.O0000Oo0);
            writableMap.putInt("express", hrb.O0000O0o);
            WritableArray createArray = Arguments.createArray();
            push2SubParamArray(createArray, hrb.O0000Oo);
            if (createArray.size() > 0) {
                writableMap.putArray("sub_props", createArray);
            }
        }
    }

    private void push2SubParamArray(WritableArray writableArray, List<hrb> list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("type", list.get(i).f542O000000o);
                createMap.putInt("siid", list.get(i).O00000Oo);
                createMap.putInt("piid", list.get(i).O00000o);
                createMap.putInt("value_type", list.get(i).O0000OOo);
                putRealValue2Map(createMap, list.get(i).O0000Oo0);
                writableArray.pushMap(createMap);
            }
        }
    }

    @ReactMethod
    public void getScenes(String str, String str2, final Promise promise) {
        JSONObject home;
        if (promise == null) {
            promise.reject("-1", "promise is null..");
        } else if (TextUtils.isEmpty(str2)) {
            promise.reject("-1", "template id is empty...");
        } else {
            if (TextUtils.isEmpty(str) && (home = hor.O000000o().getHome(str)) != null && home.has("home_id")) {
                str = home.optString("home_id");
            }
            if (TextUtils.isEmpty(str)) {
                promise.reject("-1", "home not found");
                return;
            }
            String[] split = str2.split("\\.");
            if (split.length == 2) {
                str2 = split[1];
            }
            hor.O000000o().getRecSceneDetailBy(str, str2, new com.xiaomi.smarthome.device.api.Callback() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass4 */

                public final void onSuccess(Object obj) {
                    promise.resolve(obj.toString());
                }

                public final void onFailure(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
        }
    }

    @ReactMethod
    public void openMapDialog(String str, String str2) {
        hor.O000000o().openMapDialog(getCurrentActivity(), str, str2);
    }

    @ReactMethod
    public void getSceneTemplate(String str, final Promise promise) {
        String[] split = str.split("\\.");
        if (split.length == 2) {
            str = split[1];
        }
        if (promise == null) {
            promise.reject("-1", "promise is null..");
        } else {
            hor.O000000o().getRecTplBy("", str, new com.xiaomi.smarthome.device.api.Callback() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass5 */

                public final void onSuccess(Object obj) {
                    promise.resolve(obj.toString());
                }

                public final void onFailure(int i, String str) {
                    promise.reject(String.valueOf(i), str);
                }
            });
        }
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getHomeDetail(String str) {
        JSONObject home = hor.O000000o().getHome(str);
        WritableMap createMap = Arguments.createMap();
        if (home != null) {
            Iterator<String> keys = home.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                createMap.putString(next, home.optString(next));
            }
        }
        return createMap;
    }

    private static void convertDeviceStat2Map(WritableMap writableMap, Device device) {
        boolean z;
        if (device != null && writableMap != null) {
            writableMap.putString("model", NVL(device.model));
            writableMap.putString("did", NVL(device.did));
            writableMap.putString("name", NVL(device.name));
            writableMap.putBoolean("isOwner", device.isOwner());
            writableMap.putString("deviceIconReal", NVL(DeviceFactory.O0000o0o(device.model)));
            writableMap.putString("iconURL", NVL(DeviceFactory.O0000o0o(device.model)));
            writableMap.putString("ip", NVL(device.ip));
            if (device instanceof BleDevice) {
                z = ((BleDevice) device).isNetGateConnected;
            } else {
                z = device.isOnline;
            }
            writableMap.putBoolean("isOnline", z);
            writableMap.putString("parentId", NVL(device.parentId));
            writableMap.putString("parentModel", NVL(device.parentModel));
            writableMap.putString("latitude", Double.toString(device.latitude));
            writableMap.putString("longitude", Double.toString(device.longitude));
            writableMap.putString("version", NVL(device.version));
        }
    }

    @ReactMethod
    public void callSmartHomeSceneAPI(String str, ReadableMap readableMap, final Promise promise) {
        if (promise != null) {
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(RnApiErrorInfo.PARAMS_ERROR);
                promise.reject(sb.toString(), "url is empty...");
            } else if (getDevice() == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(RnApiErrorInfo.DEVICE_ERROR);
                promise.reject(sb2.toString(), "current device is null...");
            } else {
                String O000000o2 = fyf.O000000o(readableMap);
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KeyValuePair("data", O000000o2));
                CoreApi.O000000o().O000000o((Context) null, new NetRequest.O000000o().O000000o("POST").O00000Oo(str).O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass6 */

                    public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                        return jSONObject;
                    }
                }, Crypto.RC4, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.rn.nativemodule.MIOTSceneModule.AnonymousClass7 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        promise.resolve(((JSONObject) obj).toString());
                    }

                    public final void onFailure(fso fso) {
                        Promise promise = promise;
                        StringBuilder sb = new StringBuilder();
                        sb.append(fso.f17063O000000o);
                        promise.reject(sb.toString(), fso.O00000Oo);
                    }
                });
            }
        }
    }

    private static final String NVL(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        String obj2 = obj.toString();
        if (obj2 == null) {
            return "";
        }
        return obj2;
    }

    public static JSONObject readableMapToJson(ReadableMap readableMap) {
        if (readableMap == null) {
            return new JSONObject();
        }
        try {
            JSONObject jSONObject = new JSONObject(readableMap.toString());
            return jSONObject.has("NativeMap") ? jSONObject.optJSONObject("NativeMap") : jSONObject;
        } catch (JSONException e) {
            gbu.O00000Oo(e.toString());
            return new JSONObject();
        }
    }
}
