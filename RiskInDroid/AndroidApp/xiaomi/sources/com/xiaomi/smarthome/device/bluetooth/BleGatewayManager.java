package com.xiaomi.smarthome.device.bluetooth;

import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.gsy;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class BleGatewayManager {

    public interface O00000Oo {
        void O000000o(List<O000000o> list);
    }

    public static boolean O000000o(String str) {
        PluginDeviceInfo O00000oO;
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null || (O00000oO = CoreApi.O000000o().O00000oO(O000000o2.model)) == null || O00000oO.O00oOoOo() != 1) {
            return false;
        }
        return true;
    }

    public static void O000000o(final List<String> list, final O00000Oo o00000Oo) {
        if (o00000Oo != null) {
            final AnonymousClass1 r0 = new O00000Oo() {
                /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass1 */

                public final void O000000o(final List<O000000o> list) {
                    AnonymousClass1 r0 = new O00000Oo() {
                        /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o(List<O000000o> list) {
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            for (String str : list) {
                                O000000o o000000o = new O000000o(str);
                                List list2 = list;
                                if (list2 != null) {
                                    Iterator it = list2.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        O000000o o000000o2 = (O000000o) it.next();
                                        if (TextUtils.equals(str, o000000o2.f7099O000000o)) {
                                            if (o000000o2.O00000Oo.size() > 0) {
                                                o000000o.O000000o(o000000o2.O00000Oo);
                                            }
                                        }
                                    }
                                }
                                if (list != null) {
                                    Iterator<O000000o> it2 = list.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        O000000o next = it2.next();
                                        if (TextUtils.equals(str, next.f7099O000000o)) {
                                            if (next.O00000Oo.size() > 0) {
                                                o000000o.O000000o(next.O00000Oo);
                                            }
                                        }
                                    }
                                }
                                Device O000000o2 = fno.O000000o().O000000o(str);
                                if (O000000o2 == null || !O000000o2.isOnline) {
                                    arrayList2.add(o000000o);
                                } else {
                                    arrayList.add(o000000o);
                                }
                            }
                            arrayList.addAll(arrayList2);
                            o00000Oo.O000000o(arrayList);
                        }
                    };
                    ArrayList arrayList = new ArrayList();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dids", new JSONArray());
                    } catch (JSONException unused) {
                    }
                    arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                    CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/blemesh/dev_belong").O000000o(arrayList).O000000o(), new fss<List<O000000o>>() {
                        /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass4 */

                        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            return O000000o(jSONObject);
                        }

                        private static List<O000000o> O000000o(JSONObject jSONObject) throws JSONException {
                            int i;
                            ArrayList arrayList = new ArrayList();
                            JSONObject optJSONObject = jSONObject.optJSONObject("relation");
                            if (optJSONObject != null) {
                                Iterator<String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    try {
                                        String next = keys.next();
                                        String string = optJSONObject.getString(next);
                                        O000000o o000000o = new O000000o(next);
                                        arrayList.add(o000000o);
                                        JSONArray jSONArray = new JSONArray(string);
                                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                            JSONObject optJSONObject2 = jSONArray.optJSONObject(i2);
                                            if (optJSONObject2 != null) {
                                                String optString = optJSONObject2.optString("did");
                                                String optString2 = optJSONObject2.optString("rssi");
                                                if (fno.O000000o().O000000o(optString) != null) {
                                                    try {
                                                        i = Integer.valueOf(optString2).intValue();
                                                    } catch (NumberFormatException e) {
                                                        e.printStackTrace();
                                                        i = 0;
                                                    }
                                                    o000000o.O000000o(new BleGatewayItem(optString, i));
                                                }
                                            }
                                        }
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            return arrayList;
                        }
                    }, Crypto.RC4, new fsm<List<O000000o>, fso>(r0) {
                        /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass5 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ O00000Oo f7096O000000o;

                        {
                            this.f7096O000000o = r1;
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final List list = (List) obj;
                            CommonApplication.getGlobalHandler().post(new Runnable() {
                                /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AnonymousClass5.this.f7096O000000o.O000000o(list);
                                }
                            });
                        }

                        public final void onFailure(fso fso) {
                            gsy.O000000o(3, "BleGatewayManager", "getBatchMeshGateway error: " + fso.O00000Oo);
                            this.f7096O000000o.O000000o(new ArrayList());
                        }
                    });
                }
            };
            if (list == null || list.size() == 0) {
                r0.O000000o(null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("dids", new JSONArray((Collection<?>) list));
            } catch (JSONException unused) {
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/get_bledevice_by_gateway").O000000o(arrayList).O000000o(), new fss<List<O000000o>>() {
                /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass2 */

                /* access modifiers changed from: private */
                /* renamed from: O000000o */
                public List<O000000o> parse(JSONObject jSONObject) throws JSONException {
                    ArrayList arrayList = new ArrayList();
                    for (String str : list) {
                        O000000o o000000o = new O000000o(str);
                        arrayList.add(o000000o);
                        if (jSONObject != null) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(str));
                                if (jSONObject2.length() > 0) {
                                    Iterator<String> keys = jSONObject2.keys();
                                    while (keys.hasNext()) {
                                        String next = keys.next();
                                        String string = jSONObject2.getString(next);
                                        if (fno.O000000o().O000000o(next) != null) {
                                            int i = 0;
                                            try {
                                                i = Integer.valueOf(string).intValue();
                                            } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                            }
                                            o000000o.O000000o(new BleGatewayItem(next, i));
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    return arrayList;
                }
            }, Crypto.RC4, new fsm<List<O000000o>, fso>() {
                /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    final List list = (List) obj;
                    CommonApplication.getGlobalHandler().post(new Runnable() {
                        /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            r0.O000000o(list);
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    gsy.O000000o(3, "BleGatewayManager", "getBatchBleGateway error: " + fso.O00000Oo);
                    ArrayList arrayList = new ArrayList();
                    for (String o000000o : list) {
                        arrayList.add(new O000000o(o000000o));
                    }
                    r0.O000000o(arrayList);
                }
            });
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7099O000000o;
        public ArrayList<BleGatewayItem> O00000Oo = new ArrayList<>();

        public O000000o(String str) {
            this.f7099O000000o = str;
        }

        public final void O000000o(BleGatewayItem bleGatewayItem) {
            if (!this.O00000Oo.contains(bleGatewayItem)) {
                this.O00000Oo.add(bleGatewayItem);
            }
        }

        public final void O000000o(List<BleGatewayItem> list) {
            if (list != null && list.size() > 0) {
                this.O00000Oo.addAll(list);
            }
        }
    }

    public static class BleGatewayItem implements Parcelable {
        public static final Parcelable.Creator<BleGatewayItem> CREATOR = new Parcelable.Creator<BleGatewayItem>() {
            /* class com.xiaomi.smarthome.device.bluetooth.BleGatewayManager.BleGatewayItem.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new BleGatewayItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new BleGatewayItem(parcel);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        public String f7098O000000o;
        public int O00000Oo;

        public int describeContents() {
            return 0;
        }

        public BleGatewayItem(String str, int i) {
            this.f7098O000000o = str;
            this.O00000Oo = i;
        }

        protected BleGatewayItem(Parcel parcel) {
            this.f7098O000000o = parcel.readString();
            this.O00000Oo = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f7098O000000o);
            parcel.writeInt(this.O00000Oo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return TextUtils.equals(this.f7098O000000o, ((BleGatewayItem) obj).f7098O000000o);
            }
            return false;
        }
    }
}
