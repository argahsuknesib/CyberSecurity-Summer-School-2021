package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.MessageRecordShop;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gui {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Map<String, Long> f18287O000000o = new ConcurrentHashMap();

    public static boolean O000000o(String str, long j) {
        Map<String, Long> O000000o2 = O000000o();
        if (O000000o2.containsKey(str) && j <= O000000o2.get(str).longValue()) {
            return false;
        }
        return true;
    }

    public static void O00000Oo(String str, long j) {
        if (O000000o(str, j)) {
            O000000o().put(str, Long.valueOf(j));
            JSONObject jSONObject = new JSONObject();
            Map<String, Long> O000000o2 = O000000o();
            for (String next : O000000o2.keySet()) {
                try {
                    jSONObject.put(next, O000000o2.get(next));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("map", jSONObject);
                Context appContext = ServiceApplication.getAppContext();
                appContext.getSharedPreferences("msg_center_sp_" + CoreApi.O000000o().O0000o0(), 0).edit().putString("device_push_red_point", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private static Map<String, Long> O000000o() {
        if (f18287O000000o.isEmpty()) {
            Context appContext = ServiceApplication.getAppContext();
            String string = appContext.getSharedPreferences("msg_center_sp_" + CoreApi.O000000o().O0000o0(), 0).getString("device_push_red_point", "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    if (!jSONObject.isNull("map")) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("map");
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            f18287O000000o.put(next, Long.valueOf(optJSONObject.optLong(next)));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return f18287O000000o;
    }

    public static void O000000o(final long j, final int i) {
        Observable.zip(Observable.create(new ObservableOnSubscribe<JSONArray>() {
            /* class _m_j.gui.AnonymousClass1 */

            public final void subscribe(final ObservableEmitter<JSONArray> observableEmitter) throws Exception {
                fru.O000000o().O000000o(ServiceApplication.getAppContext(), gvb.O000000o(), j, new fsm<JSONArray, fso>() {
                    /* class _m_j.gui.AnonymousClass1.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(jSONArray);
                            observableEmitter.onComplete();
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(new JSONArray());
                            observableEmitter.onComplete();
                        }
                    }
                });
            }
        }), Observable.create(new ObservableOnSubscribe<Object>() {
            /* class _m_j.gui.AnonymousClass3 */

            public final void subscribe(final ObservableEmitter observableEmitter) {
                Iterator<MessageRecordShop> it = MessageRecordShop.queryAll().iterator();
                while (it.hasNext()) {
                    it.next();
                }
                frv.O000000o();
                ServiceApplication.getAppContext();
                frv.O000000o(new fsm<Integer, fso>() {
                    /* class _m_j.gui.AnonymousClass3.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Integer num = (Integer) obj;
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(num);
                            observableEmitter.onComplete();
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(0);
                            observableEmitter.onComplete();
                        }
                    }
                });
            }
        }).onErrorReturn(new Function<Throwable, Object>() {
            /* class _m_j.gui.AnonymousClass2 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                return 0;
            }
        }), new BiFunction() {
            /* class _m_j.gui.AnonymousClass4 */

            public final Object apply(Object obj, Object obj2) throws Exception {
                try {
                    JSONArray jSONArray = (JSONArray) obj;
                    int intValue = ((Integer) obj2).intValue();
                    int i = 0;
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null && !optJSONObject.isNull("count")) {
                            i += optJSONObject.optInt("count");
                        }
                    }
                    guo O000000o2 = guo.O000000o();
                    int i3 = i + intValue;
                    int i4 = i;
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "MessageCenter", "msgCount" + i3 + "    type:" + i4);
                    if (O000000o2.O00000o0 == null) {
                        gsy.O00000Oo("MessageCenter", "initNewMessageController");
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("red_point_message_center");
                        O000000o2.O00000o0 = new ger(arrayList, false);
                    }
                    if (i4 == 1) {
                        if (i3 > 0) {
                            O000000o2.O00000o0.O000000o("red_point_message_center", true);
                        } else {
                            O000000o2.O00000o0.O000000o("red_point_message_center", false);
                        }
                    } else if (i4 == 2) {
                        if (i3 > 0) {
                            O000000o2.O00000o0.O000000o("red_point_setting_page", true);
                        } else {
                            O000000o2.O00000o0.O000000o("red_point_setting_page", false);
                        }
                    }
                } catch (Exception unused) {
                }
                return new Object();
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }
}
