package _m_j;

import _m_j.cls;
import android.text.TextUtils;
import com.mijia.model.sdcard.SDCardInfo;
import com.mijia.model.sdcard.TimeItem;
import com.tutk.IOTC.Packet;
import com.xiaomi.mistream.XmStreamClient;
import com.xiaomi.smarthome.camera.IMISSListener;
import com.xiaomi.smarthome.camera.IRDTTimelineEventListener;
import com.xiaomi.smarthome.camera.IRDTTimelineListener;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class cls extends cln {
    public SDCardInfo O0000OOo;
    public HashMap<String, Integer> O0000Oo = new HashMap<>();
    public cid O0000Oo0;

    public final String O00000oO() {
        return "com.mijia.camera.SdcardManagerEx";
    }

    public cls(cid cid) {
        super(cid);
        this.O0000Oo0 = cid;
        XmStreamClient O00oOooO = this.O0000Oo0.O00oOooO();
        if (O00oOooO != null) {
            O00oOooO.setRDTTimelineListener(new IRDTTimelineListener() {
                /* class _m_j.$$Lambda$cls$ZqfdTtyd4wxsPpUAMUSiTCdje4I */

                public final void onTimelineDataReceived(byte[] bArr) {
                    cls.this.O000000o(bArr);
                }
            });
        }
        gsy.O00000Oo("SdCard", "SdcardManagerEx init");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        O000000o(this.O0000Oo0.getModel(), arrayList, bArr);
        gsy.O00000Oo("SdCard", "timeItems size:" + arrayList.size());
        this.O0000O0o = arrayList;
        clq O0000Oo2 = this.O0000Oo0.O0000Oo();
        AnonymousClass1 r0 = new Callback<Object>() {
            /* class _m_j.cls.AnonymousClass1 */

            public final void onSuccess(Object obj) {
                cls.this.O00000o();
            }

            public final void onFailure(int i, String str) {
                cls.this.O00000o();
            }
        };
        if (System.currentTimeMillis() - O0000Oo2.O0000O0o >= 50000) {
            O0000Oo2.O0000O0o = System.currentTimeMillis();
            O0000Oo2.O00000o0.O00oOooO().setRDTTimelineEventListener(new IRDTTimelineEventListener(this, r0) {
                /* class _m_j.clq.AnonymousClass1 */

                /* renamed from: O000000o */
                final /* synthetic */ cls f14093O000000o;
                final /* synthetic */ Callback O00000Oo;

                {
                    this.f14093O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void onTimelineEventDataReceived(final byte[] bArr) {
                    clq.this.O00000Oo.execute(new Runnable() {
                        /* class _m_j.clq.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            String str = clq.f14092O000000o;
                            StringBuilder sb = new StringBuilder("received event data=");
                            byte[] bArr = bArr;
                            sb.append(bArr != null ? Integer.valueOf(bArr.length) : "null");
                            gsy.O00000Oo(str, sb.toString());
                            byte[] bArr2 = new byte[4];
                            System.arraycopy(bArr, 4, bArr2, 0, 4);
                            clq.this.O00000o = Packet.byteArrayToInt(bArr2, 0, false);
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(bArr, 8, bArr3, 0, 4);
                            int byteArrayToInt = Packet.byteArrayToInt(bArr3, 0, false);
                            String str2 = clq.f14092O000000o;
                            gsy.O00000Oo(str2, "index = " + byteArrayToInt + "/" + clq.this.O00000o);
                            int i = 44;
                            while (true) {
                                byte[] bArr4 = bArr;
                                if (i > bArr4.length - 32) {
                                    break;
                                }
                                byte[] bArr5 = new byte[8];
                                System.arraycopy(bArr4, i, bArr5, 0, 8);
                                long byteArrayToLong = Packet.byteArrayToLong(bArr5, 0, false);
                                byte[] bArr6 = new byte[4];
                                System.arraycopy(bArr, i + 8, bArr6, 0, 4);
                                int byteArrayToInt2 = Packet.byteArrayToInt(bArr6, 0, false);
                                String str3 = clq.f14092O000000o;
                                gsy.O00000Oo(str3, "timeStamp = " + byteArrayToLong + " eventType = " + byteArrayToInt2);
                                if (clq.this.O00000oO.get() >= AnonymousClass1.this.f14093O000000o.O00000oo().size()) {
                                    break;
                                }
                                TimeItem timeItem = AnonymousClass1.this.f14093O000000o.O00000oo().get(clq.this.O00000oO.get());
                                if (byteArrayToLong > timeItem.O00000o0 / 1000) {
                                    clq.this.O00000oO.addAndGet(1);
                                    String str4 = clq.f14092O000000o;
                                    gsy.O00000Oo(str4, "timeItem step 1 = " + clq.this.O00000oO.get());
                                } else if (byteArrayToLong < timeItem.f5243O000000o / 1000) {
                                    i += 32;
                                    gsy.O00000Oo(clq.f14092O000000o, "evenItem step 1");
                                } else {
                                    if (clq.O00000oo.get(Long.valueOf(timeItem.f5243O000000o)) == null || byteArrayToInt2 > clq.O00000oo.get(Long.valueOf(timeItem.f5243O000000o)).intValue()) {
                                        clq.O00000oo.put(Long.valueOf(timeItem.f5243O000000o), Integer.valueOf(byteArrayToInt2));
                                        timeItem.O00000o = byteArrayToInt2;
                                    }
                                    i += 32;
                                    String str5 = clq.f14092O000000o;
                                    gsy.O00000Oo(str5, "evenItem step 1 matched " + timeItem.f5243O000000o + " eventType=" + byteArrayToInt2);
                                }
                            }
                            if (byteArrayToInt >= clq.this.O00000o) {
                                clq.this.O00000oO.set(0);
                                AnonymousClass1.this.O00000Oo.onSuccess(null);
                                String str6 = clq.f14092O000000o;
                                gsy.O00000Oo(str6, "eventsAllMap.size=" + clq.O00000oo.size());
                            }
                        }
                    });
                }
            });
            if (O0000Oo2.O00000o0.O00oOooO() == null) {
                r0.onSuccess(null);
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("mac", "F1F2F3F4F5F6");
                    jSONObject.put("time", "");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                String str = clq.f14092O000000o;
                gsy.O00000Oo(str, "matchEvent params=" + jSONObject.toString());
                O0000Oo2.O00000o0.O00oOooO().streamSendMessage(11, 11, jSONObject.toString().getBytes(), null, new IMISSListener() {
                    /* class _m_j.clq.AnonymousClass2 */

                    public final void onProgress(int i) {
                    }

                    public final void onSuccess(String str, Object obj) {
                        String str2 = clq.f14092O000000o;
                        gsy.O00000Oo(str2, "onSuccess = " + str + " " + obj);
                    }

                    public final void onFailed(int i, String str) {
                        String str2 = clq.f14092O000000o;
                        gsy.O00000Oo(str2, "onFailed = " + i + " " + str);
                    }
                });
            }
        }
        O00000o();
    }

    public final void O000000o() {
        this.O00000oO.removeMessages(1);
        this.O00000oO.removeMessages(2);
        this.O00000o0 = 40000;
        this.O00000Oo = false;
        this.O00000oO.sendEmptyMessageDelayed(1, 0);
    }

    public final void O00000Oo() {
        super.O00000Oo();
    }

    public final void O000000o(final Callback<Void> callback) {
        cki.O00000o0("SdcardManagerEx", "SdcardManagerEx doSyncData");
        if (this.O0000Oo0.O00oOooO() == null) {
            O000000o(-3, "SdcardManagerEx updateTime");
            if (callback != null) {
                callback.onFailure(-3, "");
                return;
            }
            return;
        }
        XmStreamClient O00oOooO = this.O0000Oo0.O00oOooO();
        if (O00oOooO == null || !O00oOooO.isConnected()) {
            O000000o(-3, "SdcardManagerEx updateTime");
            if (callback != null) {
                callback.onFailure(-3, "");
                return;
            }
            return;
        }
        O00oOooO.streamSendMessage(6, 6, null, null, new IMISSListener() {
            /* class _m_j.cls.AnonymousClass2 */

            public final void onProgress(int i) {
            }

            public final void onSuccess(String str, Object obj) {
                cki.O00000o0("SdcardManagerEx", "TYPE_GET_RECORD_MSG onSuccess:" + str + ":" + obj);
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(null);
                }
            }

            public final void onFailed(int i, String str) {
                cls.this.O000000o(i, "SdcardManagerEx IMISSListener onError:".concat(String.valueOf(str)));
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, "");
                }
            }
        });
    }

    public final synchronized List<clu> O0000OOo() {
        List<clu> O000000o2;
        O000000o2 = clu.O000000o(this.O0000O0o, this.O0000Oo0.getModel());
        this.O0000Oo.clear();
        if (O000000o2.size() > 0) {
            for (int i = 0; i < O000000o2.size(); i++) {
                this.O0000Oo.put(O000000o2.get(i).O00000oO, Integer.valueOf(i));
            }
        }
        return O000000o2;
    }

    public final synchronized int O000000o(String str) {
        Integer num = this.O0000Oo.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public final synchronized void O0000Oo0() {
        this.O0000O0o.clear();
        this.O00000oO.post(new Runnable() {
            /* class _m_j.$$Lambda$cls$kPzmubWeJnHHqxa0fRlnLdQ3BFM */

            public final void run() {
                cls.this.O0000Ooo();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Ooo() {
        O00000o();
    }

    public final synchronized void O000000o(List<TimeItem> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                TimeItem timeItem = list.get(size);
                ListIterator listIterator = this.O0000O0o.listIterator();
                while (true) {
                    if (listIterator.hasNext()) {
                        if (timeItem.equals(listIterator.next())) {
                            listIterator.remove();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            this.O00000oO.post(new Runnable() {
                /* class _m_j.$$Lambda$cls$Wj_q4Y0SWh12lEIFeBWvLvkYzBI */

                public final void run() {
                    cls.this.O0000OoO();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000OoO() {
        O00000o0();
    }

    public final synchronized void O00000Oo(List<TimeItem> list) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                list.get(size).O00000oO = 1;
            }
            this.O00000oO.post(new Runnable() {
                /* class _m_j.$$Lambda$cls$XnmatrFKImoH6Q_VwlGUnyOcjPs */

                public final void run() {
                    cls.this.O0000Oo();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000Oo() {
        O00000o0();
    }

    public final synchronized List<TimeItem> O00000oo() {
        return this.O0000O0o;
    }

    private static void O000000o(String str, List<TimeItem> list, byte[] bArr) {
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i += TimeItem.O000000o()) {
                TimeItem O000000o2 = TimeItem.O000000o(str, bArr, i, chp.O000000o());
                if (O000000o2.f5243O000000o != 0 && O000000o2.f5243O000000o <= O000000o2.O00000o0) {
                    list.add(O000000o2);
                }
            }
        }
    }

    public final void O000000o(final Callback<SDCardInfo> callback, boolean z) {
        SDCardInfo sDCardInfo = this.O0000OOo;
        if (sDCardInfo != null && !z) {
            callback.onSuccess(sDCardInfo);
        }
        this.O00000o.callMethod("sd_storge", new JSONArray(), new Callback<String>() {
            /* class _m_j.cls.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str = (String) obj;
                cki.O00000o0("SdcardManagerEx", "onSuccess sd_storge:".concat(String.valueOf(str)));
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.isEmpty(jSONObject.optString("error"))) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                        callback.onFailure(jSONObject2.optInt("code"), jSONObject2.optString("message"));
                        return;
                    }
                    JSONArray jSONArray = jSONObject.getJSONArray("result");
                    long j = 0;
                    long j2 = !jSONArray.isNull(0) ? jSONArray.getLong(0) : 0;
                    long j3 = !jSONArray.isNull(1) ? jSONArray.getLong(1) : 0;
                    if (!jSONArray.isNull(2)) {
                        j = jSONArray.getLong(2);
                    }
                    SDCardInfo sDCardInfo = new SDCardInfo(j2, j3, j, !jSONArray.isNull(3) ? jSONArray.getInt(3) : -1);
                    cls.this.O0000OOo = sDCardInfo;
                    callback.onSuccess(sDCardInfo);
                } catch (JSONException e) {
                    callback.onFailure(-1, e.toString());
                }
            }

            public final void onFailure(int i, String str) {
                cki.O00000o0("SdcardManagerEx", "onFailure sd_storge:" + i + ":" + str);
                if (i == -2003) {
                    cls.this.O0000OOo = null;
                }
                callback.onFailure(i, str);
            }
        }, new Parser<String>() {
            /* class _m_j.cls.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(String str) throws JSONException {
                return str;
            }
        });
    }

    public final void O000000o(List<TimeItem> list, Callback<JSONObject> callback) {
        if (list == null || list.size() == 0) {
            callback.onFailure(-1, "");
        } else {
            goq.O000000o(new Runnable(list, new ArrayList(), callback) {
                /* class _m_j.$$Lambda$cls$odhcH7WrWtWerKVgwIZYGtjxyQ0 */
                private final /* synthetic */ List f$1;
                private final /* synthetic */ List f$2;
                private final /* synthetic */ Callback f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    cls.this.O000000o(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, final List list2, Callback callback) {
        int i;
        int i2;
        int size = list.size();
        if (size < 50) {
            i = size;
            i2 = 0;
        } else {
            i2 = 0;
            i = 50;
        }
        while (i2 < size) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final List subList = list.subList(i2, i);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < subList.size(); i3++) {
                jSONArray.put((int) (((TimeItem) subList.get(i3)).f5243O000000o / 1000));
            }
            this.O00000o.callMethod(((TimeItem) subList.get(0)).O00000oO != 0 ? "deleteSaveVideo" : "deleteVideo", jSONArray, new Callback<JSONObject>() {
                /* class _m_j.cls.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    cki.O00000o0("SdcardManagerEx", "deleteSdCardFile onSuccess:".concat(String.valueOf((JSONObject) obj)));
                    goq.O000000o(new Runnable(subList, list2, countDownLatch) {
                        /* class _m_j.$$Lambda$cls$5$VHx2Y0xTXVm_z05oRwoBUvs4vIs */
                        private final /* synthetic */ List f$1;
                        private final /* synthetic */ List f$2;
                        private final /* synthetic */ CountDownLatch f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            cls.AnonymousClass5.this.O000000o(this.f$1, this.f$2, this.f$3);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(List list, List list2, CountDownLatch countDownLatch) {
                    cls.this.O000000o(list);
                    cls.this.O0000Oo0.O0000o00().O000000o(list);
                    list2.add(Boolean.TRUE);
                    countDownLatch.countDown();
                }

                public final void onFailure(int i, String str) {
                    cki.O00000o0("SdcardManagerEx", "delete video fail ".concat(String.valueOf(str)));
                    goq.O000000o(new Runnable(list2, countDownLatch) {
                        /* class _m_j.$$Lambda$cls$5$zCsDbCTD56EEazaQhgjUtL6rlM */
                        private final /* synthetic */ List f$0;
                        private final /* synthetic */ CountDownLatch f$1;

                        {
                            this.f$0 = r1;
                            this.f$1 = r2;
                        }

                        public final void run() {
                            cls.AnonymousClass5.O000000o(this.f$0, this.f$1);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void O000000o(List list, CountDownLatch countDownLatch) {
                    list.add(Boolean.FALSE);
                    countDownLatch.countDown();
                }
            }, Parser.DEFAULT_PARSER);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i4 = i + 50;
            if (i4 >= size) {
                i4 = size;
            }
            if (list2.isEmpty() || ((Boolean) list2.remove(0)).booleanValue()) {
                int i5 = i;
                i = i4;
                i2 = i5;
            } else if (callback != null) {
                callback.onFailure(-1, "");
                return;
            } else {
                return;
            }
        }
        if (callback != null) {
            callback.onSuccess(new JSONObject());
        }
    }

    public final void O00000o0(Callback<Object> callback) {
        this.O00000o.O000000o("sd_format", null, callback);
    }

    public final void O00000o(final Callback<Object> callback) {
        this.O00000o.callMethod("sd_umount", new JSONArray(), new Callback<JSONObject>() {
            /* class _m_j.cls.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str;
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    callback.onSuccess(null);
                } else if (TextUtils.isEmpty(jSONObject.optString("error"))) {
                    callback.onSuccess(jSONObject);
                } else {
                    int i = -1;
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("error");
                        i = jSONObject2.optInt("code");
                        str = jSONObject2.optString("message");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        str = "";
                    }
                    callback.onFailure(i, str);
                }
            }

            public final void onFailure(int i, String str) {
                callback.onFailure(i, str);
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O00000Oo(List<TimeItem> list, Callback<JSONObject> callback) {
        if (list == null || list.size() == 0) {
            callback.onFailure(-1, "");
        } else {
            goq.O000000o(new Runnable(list, callback, new ArrayList()) {
                /* class _m_j.$$Lambda$cls$pGJ5EL8pImPz1oBWC7nTV6_aX8 */
                private final /* synthetic */ List f$1;
                private final /* synthetic */ Callback f$2;
                private final /* synthetic */ List f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    cls.this.O000000o(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, Callback callback, final List list2) {
        int i;
        int i2;
        int size = list.size();
        if (size < 50) {
            i = size;
            i2 = 0;
        } else {
            i2 = 0;
            i = 50;
        }
        while (i2 < size) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final List subList = list.subList(i2, i);
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < subList.size(); i3++) {
                if (((TimeItem) subList.get(i3)).O00000oO == 0) {
                    jSONArray.put((int) (((TimeItem) subList.get(i3)).f5243O000000o / 1000));
                }
            }
            if (jSONArray.length() != 0) {
                this.O00000o.callMethod("saveVideo", jSONArray, new Callback<JSONObject>() {
                    /* class _m_j.cls.AnonymousClass7 */

                    public final void onFailure(int i, String str) {
                        list2.add(Boolean.FALSE);
                        countDownLatch.countDown();
                        gsy.O000000o(6, "SdcardManagerEx", "save video fail ".concat(String.valueOf(str)));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        cls.this.O00000Oo(subList);
                        list2.add(Boolean.TRUE);
                        countDownLatch.countDown();
                    }
                }, Parser.DEFAULT_PARSER);
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int i4 = i + 50;
                if (i4 >= size) {
                    i4 = size;
                }
                if (list2.isEmpty() || ((Boolean) list2.remove(0)).booleanValue()) {
                    int i5 = i;
                    i = i4;
                    i2 = i5;
                } else if (callback != null) {
                    callback.onFailure(-1, "");
                    return;
                } else {
                    return;
                }
            } else if (callback != null) {
                callback.onFailure(-1, "");
                return;
            } else {
                return;
            }
        }
        if (callback != null) {
            callback.onSuccess(new JSONObject());
        }
    }
}
