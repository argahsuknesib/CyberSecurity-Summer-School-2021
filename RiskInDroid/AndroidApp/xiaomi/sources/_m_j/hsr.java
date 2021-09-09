package _m_j;

import _m_j.hsr;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import com.xiaomi.smarthome.share.ShareMsgAlertActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hsr {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile int f599O000000o;
    public static volatile List<gul> O00000Oo;

    public static void O000000o(final BaseActivity baseActivity, final int i) {
        if (baseActivity != null && baseActivity.isValid()) {
            final WeakReference weakReference = new WeakReference(baseActivity);
            Observable.create(new ObservableOnSubscribe(i) {
                /* class _m_j.$$Lambda$hsr$PUwC3vWsCt46uT6wtjCcGFbLJ0 */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void subscribe(ObservableEmitter observableEmitter) {
                    fru.O000000o().O000000o(this.f$0, new fsm<JSONObject, fso>(observableEmitter, this.f$0) {
                        /* class _m_j.hsr.AnonymousClass3 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            if (!r3.isDisposed()) {
                                if (r2 == 11) {
                                    LogType logType = LogType.KUAILIAN;
                                    gsy.O00000o0(logType, "wugan", " getMsgAlert onSuccess,detail=" + jSONObject.toString());
                                }
                                r3.onNext(O000000o.O000000o(jSONObject));
                                r3.onComplete();
                            }
                        }

                        public final void onFailure(fso fso) {
                            if (r2 == 11) {
                                LogType logType = LogType.KUAILIAN;
                                StringBuilder sb = new StringBuilder(" getMsgAlert onFail,detail=");
                                sb.append(fso != null ? fso.toString() : "error is null");
                                gsy.O00000o0(logType, "wugan", sb.toString());
                            }
                            if (!r3.isDisposed()) {
                                r3.onComplete();
                            }
                        }
                    });
                }
            }).flatMap($$Lambda$hsr$Wcv16kPIdH5kOIYJFYMri_sZFKY.INSTANCE, $$Lambda$hsr$5J2YhtFVzjYB1tUQTqperGlYV8o.INSTANCE).flatMap(new Function(i) {
                /* class _m_j.$$Lambda$hsr$na_PqFZcCNgJ6mS1VP0UjZFams */
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final Object apply(Object obj) {
                    return hsr.O000000o(this.f$0, (hsr.O000000o) obj);
                }
            }, $$Lambda$hsr$q8nTqJT38teVXZANvXIx1yXMqRY.INSTANCE).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<O000000o>() {
                /* class _m_j.hsr.AnonymousClass1 */

                public final void onComplete() {
                }

                public final void onError(Throwable th) {
                }

                public final void onSubscribe(Disposable disposable) {
                }

                public final /* synthetic */ void onNext(Object obj) {
                    BaseActivity baseActivity;
                    O000000o o000000o = (O000000o) obj;
                    if (o000000o != null && o000000o.f604O000000o > 0 && (baseActivity = (BaseActivity) weakReference.get()) != null && baseActivity.isValid()) {
                        if (i != 11) {
                            hsr.O000000o(baseActivity, o000000o.f604O000000o, o000000o.O00000Oo);
                            return;
                        }
                        List<?> list = o000000o.O00000Oo;
                        if (list != null && list.size() > 0) {
                            gva.O000000o().alertFastConnectSuccessDialog(baseActivity, (gul) list.get(0));
                        }
                    }
                }
            });
        }
    }

    public static void O000000o(BaseActivity baseActivity, int i, List<gul> list) {
        f599O000000o = 0;
        O00000Oo = list;
        if (baseActivity != null && baseActivity.isValid() && i > 0 && list != null && !list.isEmpty()) {
            f599O000000o = i;
            O00000Oo = list;
            baseActivity.startActivity(new Intent(baseActivity, ShareMsgAlertActivity.class));
            baseActivity.overridePendingTransition(0, 0);
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public int f604O000000o;
        /* access modifiers changed from: package-private */
        public List<?> O00000Oo;

        public static O000000o O000000o(JSONObject jSONObject) {
            O000000o o000000o = new O000000o();
            try {
                o000000o.f604O000000o = jSONObject.optInt("msgCount", 0);
                JSONArray optJSONArray = jSONObject.optJSONArray("msgIds");
                if (optJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    o000000o.O00000Oo = arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return o000000o;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ObservableSource O000000o(final int i, O000000o o000000o) throws Exception {
        List<?> list = o000000o.O00000Oo;
        if (list == null || list.isEmpty()) {
            return Observable.empty();
        }
        return Observable.fromIterable(list).map(new Function<MessageRecord, gul>() {
            /* class _m_j.hsr.AnonymousClass2 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                MessageRecord messageRecord = (MessageRecord) obj;
                int i = i;
                if (i == 8) {
                    return gva.O000000o().getHomeShareMessageByRecord(messageRecord);
                }
                if (i == 11) {
                    return gva.O000000o().getHomeFastConnectMessageByRecord(messageRecord);
                }
                return gva.O000000o().getShareMessageByRecord(messageRecord);
            }
        }).toList().toObservable();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ObservableSource O000000o(O000000o o000000o) throws Exception {
        return (o000000o.f604O000000o <= 0 || o000000o.O00000Oo == null || o000000o.O00000Oo.size() <= 0) ? Observable.empty() : Observable.create(new ObservableOnSubscribe(o000000o.O00000Oo) {
            /* class _m_j.$$Lambda$hsr$vyMBlfH6kbMDD7APTrNXOwrRCDU */
            private final /* synthetic */ List f$0;

            {
                this.f$0 = r1;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                fru.O000000o().O00000oo(this.f$0, new fsm<JSONObject, fso>(observableEmitter) {
                    /* class _m_j.hsr.AnonymousClass4 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (!r3.isDisposed()) {
                            ArrayList arrayList = new ArrayList();
                            JSONArray optJSONArray = jSONObject.optJSONArray("messages");
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                MessageRecord messageRecord = new MessageRecord();
                                if (MessageRecord.parse(optJSONObject, messageRecord)) {
                                    arrayList.add(messageRecord);
                                }
                            }
                            r3.onNext(arrayList);
                            r3.onComplete();
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (!r3.isDisposed()) {
                            r3.onComplete();
                        }
                    }
                });
            }
        });
    }
}
