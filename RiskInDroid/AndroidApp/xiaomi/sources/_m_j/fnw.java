package _m_j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class fnw {

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16727O000000o;
    public String O00000Oo;
    public List<O000000o> O00000o = new ArrayList();
    public List<O000000o> O00000o0 = new ArrayList();

    public final void O000000o() {
        int i;
        String str;
        this.O00000o.clear();
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        SparseArray sparseArray = new SparseArray();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < list.size()) {
            ggb.O00000Oo();
            sparseArray.append(i2, ggb.O000000o(list.get(i2)));
            if (list.get(i2).getRoomList() != null) {
                SparseArray sparseArray2 = new SparseArray();
                for (int i3 = 0; i3 < list.get(i2).getRoomList().size(); i3++) {
                    sparseArray2.append(i3, list.get(i2).getRoomList().get(i3).getName());
                }
                ggb.O00000Oo();
                hashMap.put(ggb.O000000o(list.get(i2)), sparseArray2);
                i2++;
            } else {
                return;
            }
        }
        Home O0000o0 = ggb.O00000Oo().O0000o0(this.f16727O000000o);
        if (O0000o0 != null) {
            ggb.O00000Oo();
            int indexOfValue = sparseArray.indexOfValue(ggb.O000000o(O0000o0));
            if (indexOfValue > 0) {
                sparseArray.remove(indexOfValue);
                ggb.O00000Oo();
                sparseArray.put(0, ggb.O000000o(O0000o0));
            }
        }
        String str2 = null;
        for (int i4 = 0; i4 < this.O00000o0.size(); i4++) {
            if (this.O00000o0.get(i4) != null && !TextUtils.isEmpty(this.O00000o0.get(i4).f16728O000000o)) {
                JSONObject thirdAccountDeviceById = gty.O000000o().getThirdAccountDeviceById(this.O00000o0.get(i4).f16728O000000o);
                if (thirdAccountDeviceById != null) {
                    this.O00000o0.get(i4).O0000OOo = 1;
                    try {
                        str = thirdAccountDeviceById.getString("third_cloud_device_group_id");
                        str2 = thirdAccountDeviceById.getString("third_cloud_device_icon");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str = null;
                    }
                    if (!TextUtils.isEmpty(str) && gty.O000000o().atThirdAccountName(str) != null) {
                        this.O00000o0.get(i4).O00000oo = gty.O000000o().atThirdAccountName(str);
                        try {
                            this.O00000o0.get(i4).O0000Oo = gty.O000000o().getThirdAccountIndex(str);
                        } catch (Exception unused) {
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        this.O00000o0.get(i4).O00000oO = str2;
                    }
                    this.O00000o.add(this.O00000o0.get(i4));
                } else {
                    Device O000000o2 = fno.O000000o().O000000o(this.O00000o0.get(i4).f16728O000000o);
                    if (O000000o2 != null) {
                        this.O00000o0.get(i4).O0000OOo = 0;
                        if (!O000000o2.isHomeShared()) {
                            Home O0000o02 = ggb.O00000Oo().O0000o0(O000000o2.did);
                            String O0000o0O = ggb.O00000Oo().O0000o0O(O000000o2.did);
                            if (O0000o02 != null) {
                                ggb.O00000Oo();
                                this.O00000o0.get(i4).O00000oo = ggb.O000000o(O0000o02);
                                this.O00000o0.get(i4).O0000Oo = sparseArray.indexOfValue(this.O00000o0.get(i4).O00000oo);
                            }
                            if (!TextUtils.isEmpty(O0000o0O)) {
                                this.O00000o0.get(i4).O0000O0o = O0000o0O;
                                if (O0000o02 != null) {
                                    ggb.O00000Oo();
                                    if (!TextUtils.isEmpty(ggb.O000000o(O0000o02))) {
                                        O000000o o000000o = this.O00000o0.get(i4);
                                        ggb.O00000Oo();
                                        if (hashMap.get(ggb.O000000o(O0000o02)) != null) {
                                            ggb.O00000Oo();
                                            i = ((SparseArray) hashMap.get(ggb.O000000o(O0000o02))).indexOfValue(this.O00000o0.get(i4).O0000O0o);
                                        } else {
                                            i = -1;
                                        }
                                        o000000o.O0000OoO = i;
                                    }
                                }
                            }
                        } else {
                            this.O00000o0.get(i4).O0000O0o = ServiceApplication.getAppContext().getResources().getString(R.string.tag_share);
                        }
                        this.O00000o.add(this.O00000o0.get(i4));
                    } else {
                        this.O00000o0.get(i4).O0000OOo = 0;
                        this.O00000o0.get(i4).O0000O0o = ServiceApplication.getAppContext().getResources().getString(R.string.tag_share);
                        this.O00000o.add(this.O00000o0.get(i4));
                    }
                }
            }
        }
        Collections.sort(this.O00000o);
    }

    public static class O000000o implements Cloneable, Comparable<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16728O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;
        public String O00000oo;
        public String O0000O0o;
        public int O0000OOo = -1;
        public int O0000Oo = -1;
        public int O0000Oo0;
        public int O0000OoO = -1;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            O000000o o000000o = (O000000o) obj;
            int i = this.O0000OOo;
            int i2 = o000000o.O0000OOo;
            if (i != i2) {
                return i - i2;
            }
            int i3 = this.O0000Oo;
            int i4 = o000000o.O0000Oo;
            if (i3 == i4) {
                int i5 = this.O0000OoO;
                int i6 = o000000o.O0000OoO;
                if (i5 == i6) {
                    return this.O0000Oo0 - o000000o.O0000Oo0;
                }
                if (i5 < 0) {
                    return 1;
                }
                if (i6 < 0) {
                    return -1;
                }
                return i5 - i6;
            } else if (i3 < 0) {
                return 1;
            } else {
                if (i4 < 0) {
                    return -1;
                }
                return i3 - i4;
            }
        }

        public O000000o() {
        }

        public O000000o(String str, String str2, int i) {
            this.f16728O000000o = str;
            this.O00000Oo = str2;
            this.O0000Oo0 = i;
        }

        private O000000o O000000o() {
            try {
                return (O000000o) clone();
            } catch (Exception unused) {
                return new O000000o();
            }
        }

        public static List<O000000o> O000000o(List<O000000o> list) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i).O000000o());
            }
            return arrayList;
        }
    }
}
