package com.xiaomi.smarthome.messagecenter;

import _m_j.gpv;
import _m_j.guf;
import _m_j.gul;
import _m_j.gum;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.db.record.MessageRecordTypeList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TypeListMsgCacheManager {
    public static long O00000oO;
    private static volatile TypeListMsgCacheManager O0000O0o;

    /* renamed from: O000000o  reason: collision with root package name */
    public List<MessageRecordTypeList> f9421O000000o = new ArrayList();
    public List<Pair<O000000o, List<gul>>> O00000Oo = new ArrayList();
    volatile boolean O00000o = false;
    public List<gul> O00000o0 = new ArrayList();
    private O00000Oo O00000oo = null;
    private volatile AtomicBoolean O0000OOo = new AtomicBoolean(false);

    public interface O00000Oo {
    }

    private TypeListMsgCacheManager() {
    }

    public static TypeListMsgCacheManager O000000o() {
        if (O0000O0o == null) {
            synchronized (TypeListMsgCacheManager.class) {
                if (O0000O0o == null) {
                    O0000O0o = new TypeListMsgCacheManager();
                }
            }
        }
        return O0000O0o;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f9424O000000o;
        public String O00000Oo;

        public final int hashCode() {
            return TextUtils.isEmpty(this.f9424O000000o) ? super.hashCode() : this.f9424O000000o.hashCode();
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof O000000o)) {
                return false;
            }
            if (TextUtils.equals(this.f9424O000000o, ((O000000o) obj).f9424O000000o)) {
                return true;
            }
            return super.equals(obj);
        }
    }

    static class RxJavaExceptionError extends Exception {
        private Object object;

        public RxJavaExceptionError(Object obj) {
            this.object = obj;
        }

        public Object get() {
            return this.object;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<MessageRecordTypeList> list, List<Pair<O000000o, List<gul>>> list2, List<gul> list3) {
        List list4;
        if (Looper.getMainLooper() != Looper.myLooper()) {
            for (int i = 0; i < list.size(); i++) {
                MessageRecordTypeList messageRecordTypeList = list.get(i);
                if (messageRecordTypeList != null) {
                    gum gum = guf.O000000o().O00000o0.get(messageRecordTypeList.messageType);
                    if (!TextUtils.equals(messageRecordTypeList.messageType, "6")) {
                        list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                    } else if (TextUtils.isEmpty(messageRecordTypeList.params)) {
                        list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject(messageRecordTypeList.params);
                            if (jSONObject.isNull("body")) {
                                list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                            } else {
                                JSONObject optJSONObject = jSONObject.optJSONObject("body");
                                if (optJSONObject.isNull("did")) {
                                    list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                                } else {
                                    String optString = optJSONObject.optString("did");
                                    String optString2 = optJSONObject.optString("model");
                                    if (!TextUtils.isEmpty(optString)) {
                                        if (!TextUtils.isEmpty(optString2)) {
                                            if (CoreApi.O000000o().O00000oO(optString2) != null) {
                                                Pair<O000000o, List<gul>> O000000o2 = O000000o(optString);
                                                if (O000000o2 == null) {
                                                    list4 = null;
                                                } else {
                                                    list4 = (List) O000000o2.second;
                                                }
                                                if (O000000o2 == null || list4 == null) {
                                                    list4 = new ArrayList();
                                                    O000000o o000000o = new O000000o();
                                                    o000000o.f9424O000000o = optString;
                                                    o000000o.O00000Oo = optString2;
                                                    list2.add(new Pair(o000000o, list4));
                                                }
                                                list4.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                                                Collections.sort(list4, new Comparator<gul>() {
                                                    /* class com.xiaomi.smarthome.messagecenter.TypeListMsgCacheManager.AnonymousClass1 */

                                                    public final /* synthetic */ int compare(Object obj, Object obj2) {
                                                        return (int) (((gul) obj2).O000000o() - ((gul) obj).O000000o());
                                                    }
                                                });
                                            }
                                        }
                                    }
                                    list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                                }
                            }
                        } catch (JSONException e) {
                            list3.add(gum.O000000o(messageRecordTypeList.toMsgRecord()));
                            e.printStackTrace();
                        }
                    }
                }
            }
            O000000o(list2);
            return;
        }
        throw new RuntimeException();
    }

    private static void O000000o(List<Pair<O000000o, List<gul>>> list) {
        boolean z;
        if (!list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                Pair pair = list.get(i);
                if (pair != null) {
                    List list2 = (List) pair.second;
                    if (list2 == null || list2.size() == 0) {
                        list.remove(i);
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list2.size()) {
                                z = true;
                                break;
                            }
                            long j = ((gul) list2.get(i2)).O00000oo.receiveTime;
                            if (O00000oO == 0) {
                                O00000oO = gpv.O00000Oo(ServiceApplication.getAppContext(), "installTime", 0) / 1000;
                            }
                            if (j >= O00000oO) {
                                z = false;
                                break;
                            }
                            i2++;
                        }
                        if (z) {
                            list.remove(i);
                        }
                    }
                    i--;
                }
                i++;
            }
        }
    }

    private Pair<O000000o, List<gul>> O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (int i = 0; i < this.O00000Oo.size(); i++) {
            Pair<O000000o, List<gul>> pair = this.O00000Oo.get(i);
            if (pair != null && pair.first != null && TextUtils.equals(str, ((O000000o) pair.first).f9424O000000o)) {
                return pair;
            }
        }
        return null;
    }
}
