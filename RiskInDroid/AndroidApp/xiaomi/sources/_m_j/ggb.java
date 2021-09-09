package _m_j;

import _m_j.fno;
import _m_j.fso;
import _m_j.fuy;
import _m_j.ggb;
import _m_j.gsy;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.smarthome.newui.roomenv.model.RoomEnvData;
import com.xiaomi.smarthome.service.CardActive;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Triple;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ggb implements exv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f17672O000000o = "ggb";
    public static final Set<String> O0000o = new HashSet();
    public static Device O0000o00;
    public static volatile long O0000oOO;
    private static volatile ggb O00oOooo;
    public boolean O00000Oo = false;
    public Room O00000o;
    public String O00000o0 = null;
    public String O00000oO;
    public String O00000oo;
    public int O0000O0o = -1;
    public List<Object> O0000OOo = new ArrayList();
    public Handler O0000Oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.ggb.AnonymousClass6 */

        public final void handleMessage(Message message) {
        }
    };
    public frt O0000Oo0 = new frt();
    public O00000Oo O0000OoO;
    public AtomicBoolean O0000Ooo = new AtomicBoolean(false);
    public Room O0000o0;
    public List<Device> O0000o0O;
    public List<Object> O0000o0o = new ArrayList();
    public boolean O0000oO = true;
    public PublishSubject<Boolean> O0000oO0 = PublishSubject.create();
    public AtomicBoolean O0000oOo = new AtomicBoolean(false);
    public AtomicBoolean O0000oo = new AtomicBoolean(false);
    public AtomicBoolean O0000oo0 = new AtomicBoolean(false);
    public AtomicBoolean O0000ooO = new AtomicBoolean(false);
    public AtomicBoolean O0000ooo = new AtomicBoolean(false);
    private List<Object> O000O00o = new ArrayList();
    private BroadcastReceiver O000O0OO = new BroadcastReceiver() {
        /* class _m_j.ggb.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            gsy.O00000Oo(ggb.f17672O000000o, intent.getAction());
            if (!"action_on_login_success".equals(intent.getAction()) && "action_on_logout".equals(intent.getAction())) {
                ggb.this.O0000Ooo();
            }
        }
    };
    private O0000O0o O000O0Oo;
    private fno.O000000o O00oOoOo = new fno.O000000o() {
        /* class _m_j.ggb.AnonymousClass4 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                ggb.O0000oOO = System.currentTimeMillis();
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("device_updated"));
            }
        }
    };
    public BroadcastReceiver O00oOooO = new O000000o(this, (byte) 0);

    public interface O00000o {
        void O000000o();

        void O000000o(int i, fso fso);
    }

    public interface O0000OOo {
        void O000000o();
    }

    public final String O000000o() {
        return "HomeManager";
    }

    public static ggb O00000Oo() {
        if (O00oOooo == null) {
            synchronized (ggb.class) {
                if (O00oOooo == null) {
                    ggb ggb = new ggb();
                    eyg eyg = eyg.f15944O000000o;
                    eyg.O000000o(ggb);
                    O00oOooo = ggb;
                }
            }
        }
        return O00oOooo;
    }

    private ggb() {
        gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "HomeManager <init>");
        this.O0000OoO = new O00000Oo();
        O0000oo0();
        gge.O000000o();
        IntentFilter intentFilter = new IntentFilter("action_on_login_success");
        intentFilter.addAction("action_on_logout");
        fno.O000000o().O000000o(this.O00oOoOo);
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O000O0OO, intentFilter);
        faw.O000000o().isReady(new Runnable() {
            /* class _m_j.$$Lambda$ggb$yzsC01D_6qxMtI9NnDYp1Wb6Og */

            public final void run() {
                ggb.this.O0000ooO();
            }
        });
        if (!TextUtils.isEmpty(this.O00000o0)) {
            O00000Oo o00000Oo = this.O0000OoO;
            gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "startSyncIfNeeded: load local: ");
            gor.O000000o(new AsyncTask<Object, Object, Object>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public final Object doInBackground(Object... objArr) {
                    try {
                        String O00000o0 = gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", "{}");
                        if (gfr.O0000Ooo) {
                            gsy.O00000Oo(LogType.HOME_ROOM, "zxtzxt", "loadLocalHomeCache: ".concat(String.valueOf(O00000o0)));
                        }
                        O00000Oo.this.O000000o(new JSONObject(O00000o0), !O00000Oo.this.O00000o.get());
                        ggb.this.O00000oO(ggb.this.O00000o0);
                        return null;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }, new Object[0]);
            LogType logType = LogType.HOME_ROOM;
            String str = f17672O000000o;
            gsy.O00000Oo(logType, str, "startSyncIfNeeded: load start: mSynchronized: " + o00000Oo.O00000o.get() + " ;mSynchronizing: " + o00000Oo.O00000o0.get());
            if (!o00000Oo.O00000o.get() && !o00000Oo.O00000o0.get()) {
                gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "startSyncIfNeeded: load net: ");
                o00000Oo.O00000Oo();
            }
        }
        O0000oOO();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O0000ooO() {
        this.O0000ooO.set(true);
        gsy.O00000o0(LogType.HOME_ROOM, "forceUpdateAllData", "send ACTION_CARD_INIT_UPDATED");
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("card_init_updated"));
    }

    private O0000O0o O0000oOO() {
        if (this.O000O0Oo == null) {
            this.O000O0Oo = new O0000O0o();
        }
        return this.O000O0Oo;
    }

    public final void O00000o0() {
        this.O0000OoO.O00000Oo();
    }

    public final void O000000o(PrintWriter printWriter, String[] strArr) {
        printWriter.println("HomeId: " + this.O00000o0);
        StringBuilder sb = new StringBuilder("mCurrentRoom: ");
        Room room = this.O0000o0;
        sb.append(room == null ? "null" : room.getName());
        printWriter.println(sb.toString());
        printWriter.println("homeCache: ".concat(String.valueOf(gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", "{}"))));
    }

    public final void O000000o(final O0000OOo o0000OOo) {
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            o0000OOo.O000000o();
            return;
        }
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new BroadcastReceiver() {
            /* class _m_j.ggb.AnonymousClass7 */

            public final void onReceive(Context context, Intent intent) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.O000000o();
                }
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
            }
        }, new IntentFilter("home_room_updated"));
        this.O0000OoO.O00000Oo();
    }

    public final List<Room> O000000o(String str) {
        return this.O0000OoO.O00000oO(str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void
     arg types: [java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.gyl.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView, com.facebook.imagepipeline.request.BasePostprocessor):void
      _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void */
    public final void O000000o(final O00000o o00000o) {
        O0000oo0();
        if (!this.O00000Oo || TextUtils.isEmpty(this.O00000o0) || this.O0000OoO.f17692O000000o.size() <= 0) {
            if (!this.O0000Ooo.getAndSet(true)) {
                gyl.O000000o().O000000o(CoreApi.O000000o().O0000o0(), (ftt<ShareUserRecord>) null, false);
                Observable.create(new ObservableOnSubscribe<Boolean>() {
                    /* class _m_j.ggb.AnonymousClass10 */

                    public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                        fru O000000o2 = fru.O000000o();
                        ServiceApplication.getAppContext();
                        O000000o2.O000000o(new fsm<JSONObject, fso>() {
                            /* class _m_j.ggb.AnonymousClass10.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                if (observableEmitter.isDisposed()) {
                                    return;
                                }
                                if (jSONObject == null) {
                                    observableEmitter.onComplete();
                                    return;
                                }
                                String optString = jSONObject.optString("homeid");
                                if (TextUtils.isEmpty(optString)) {
                                    observableEmitter.onNext(Boolean.FALSE);
                                    observableEmitter.onComplete();
                                    return;
                                }
                                if (ggb.this.O0000OoO.O00000Oo.size() > 0 && ggb.this.O0000OoO.O00000o(ggb.this.O00000o0) == null) {
                                    ggb.this.O00000o0 = optString;
                                    ggb.this.O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), ggb.this.O00000o0);
                                }
                                ggb.this.O00000Oo = true;
                                observableEmitter.onNext(Boolean.TRUE);
                                observableEmitter.onComplete();
                            }

                            public final void onFailure(fso fso) {
                                observableEmitter.onComplete();
                            }
                        });
                    }
                }).flatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    /* class _m_j.ggb.AnonymousClass9 */

                    public final /* synthetic */ Object apply(Object obj) throws Exception {
                        final Boolean bool = (Boolean) obj;
                        return Observable.create(new ObservableOnSubscribe<Boolean>() {
                            /* class _m_j.ggb.AnonymousClass9.AnonymousClass1 */

                            public final void subscribe(final ObservableEmitter<Boolean> observableEmitter) throws Exception {
                                if (bool.booleanValue()) {
                                    observableEmitter.onNext(Boolean.TRUE);
                                    observableEmitter.onComplete();
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                Map<String, Set<String>> O000000o2 = fnn.O000000o().O00000Oo().O000000o(4);
                                if (!O000000o2.isEmpty()) {
                                    arrayList.clear();
                                    arrayList.addAll(O000000o2.keySet());
                                }
                                fru.O000000o().O000000o(ServiceApplication.getAppContext(), arrayList, new fsm<JSONObject, fso>() {
                                    /* class _m_j.ggb.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (!observableEmitter.isDisposed()) {
                                            if (jSONObject != null) {
                                                ggb.this.O00000o0 = jSONObject.optString("homeid");
                                                if (!TextUtils.isEmpty(ggb.this.O00000o0)) {
                                                    ggb.this.O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), ggb.this.O00000o0);
                                                    ggb.this.O00000Oo = true;
                                                    observableEmitter.onNext(Boolean.TRUE);
                                                }
                                            }
                                            observableEmitter.onComplete();
                                        }
                                    }

                                    public final void onFailure(fso fso) {
                                        observableEmitter.onComplete();
                                    }
                                });
                            }
                        });
                    }
                }).subscribeOn(Schedulers.io()).subscribe(new Observer<Boolean>() {
                    /* class _m_j.ggb.AnonymousClass8 */

                    public final void onError(Throwable th) {
                    }

                    public final void onSubscribe(Disposable disposable) {
                    }

                    public final /* synthetic */ void onNext(Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            O00000o o00000o = o00000o;
                            if (o00000o != null) {
                                o00000o.O000000o();
                            }
                            ggb.this.O0000OoO.O00000Oo();
                        }
                    }

                    public final void onComplete() {
                        ggb.this.O0000Ooo.set(false);
                    }
                });
            }
        } else if (o00000o != null) {
            o00000o.O000000o();
        }
    }

    public final List<Room> O00000o() {
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            return new ArrayList();
        }
        Map<String, List<Room>> map = this.O0000OoO.f17692O000000o;
        if (map != null && map.size() == 1) {
            Iterator<String> it = map.keySet().iterator();
            if (it.hasNext()) {
                return map.get(it.next());
            }
        }
        return O000000o(this.O00000o0);
    }

    public final Room O00000Oo(String str) {
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4 || TextUtils.isEmpty(str)) {
            return null;
        }
        List list = O00000o0.O00000Oo.get(this.O00000o0);
        if (list == null) {
            list = new ArrayList();
            O00000o0.O00000Oo.put(this.O00000o0, list);
        }
        for (int i = 0; i < list.size(); i++) {
            Room room = (Room) list.get(i);
            if (room.getId().equals(str)) {
                return room;
            }
        }
        Room room2 = new Room();
        room2.setId(str);
        room2.setDids(new ArrayList());
        list.add(room2);
        return room2;
    }

    public final Room O00000o0(String str) {
        return this.O0000OoO.O00000o0(str);
    }

    public final Home O00000o(String str) {
        return this.O0000OoO.O00000o(str);
    }

    public final List<String> O000000o(String str, boolean... zArr) {
        List<Device> O0000O0o2;
        ArrayList arrayList = new ArrayList();
        Home O00000o2 = O00000o(str);
        if (O00000o2 == null) {
            return arrayList;
        }
        if (!O00000o2.isOwner()) {
            ggw O000000o2 = ggw.O000000o();
            ArrayList arrayList2 = new ArrayList();
            HomeDeviceInfo O000000o3 = O000000o2.O000000o(str);
            if (O000000o3 == null) {
                return arrayList2;
            }
            return O000000o3.O00000oO();
        }
        List<Room> O000000o4 = O000000o(str);
        if (O000000o4 == null) {
            return arrayList;
        }
        int i = 0;
        while (i < O000000o4.size()) {
            try {
                Room room = O000000o4.get(i);
                if (room != null) {
                    List<String> dids = room.getDids();
                    for (int i2 = 0; i2 < dids.size(); i2++) {
                        String str2 = dids.get(i2);
                        Device O000000o5 = fno.O000000o().O000000o(str2);
                        if (O000000o5 != null && !arrayList.contains(O000000o5.did) && !O000000o5.isHideMainList()) {
                            arrayList.add(str2);
                        }
                    }
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if ((zArr.length == 0 || zArr[0]) && (O0000O0o2 = O0000O0o(str)) != null) {
            for (int i3 = 0; i3 < O0000O0o2.size(); i3++) {
                Device device = O0000O0o2.get(i3);
                if (device != null && !arrayList.contains(device.did) && !device.isHideMainList()) {
                    arrayList.add(device.did);
                }
            }
        }
        return arrayList;
    }

    public final void O000000o(String str, final fsm fsm) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, this.O00000o0) || this.O0000OoO.O00000o(str) == null) {
            if (fsm != null) {
                fsm.onSuccess(null);
            }
        } else if (O00000o(str).isOwner()) {
            this.O00000o0 = str;
            O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), str);
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("home_room_home_changed"));
            if (fsm != null) {
                fsm.onSuccess(null);
            }
        } else {
            gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "changeHome shared home in");
            this.O00000o0 = str;
            O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), str);
            fno.O000000o().O000000o(new fno.O000000o() {
                /* class _m_j.ggb.AnonymousClass11 */

                public final void onRefreshClientDeviceChanged(int i, Device device) {
                }

                public final void onRefreshClientDeviceSuccess(int i) {
                    gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "changeHome onRefreshClientDeviceSuccess in");
                    fno.O000000o().O00000Oo(this);
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("home_room_home_changed"));
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.onSuccess(null);
                    }
                }
            });
            gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "changeHome updateDeviceRemote start");
            fno.O000000o().O0000Oo0();
        }
    }

    private static String O0000oOo() {
        Context appContext = ServiceApplication.getAppContext();
        if (appContext == null) {
            return "";
        }
        String O000000o2 = O000000o(appContext);
        if (!TextUtils.isEmpty(O000000o2)) {
            return O000000o2;
        }
        SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0);
        String string = sharedPreferences.getString("homeid_server", "");
        ServerBean O000000o3 = ftn.O000000o(ServiceApplication.getAppContext());
        if (!TextUtils.isEmpty(string)) {
            if (O000000o3 != null && !TextUtils.equals(O000000o3.f7546O000000o, string)) {
                return "";
            }
        } else if (O000000o3 != null) {
            sharedPreferences.edit().putString("homeid_server", O000000o3.f7546O000000o).apply();
        }
        String string2 = sharedPreferences.getString("homeid", "");
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o(appContext, string, O000000o2);
        }
        return string2;
    }

    private static String O000000o(Context context) {
        try {
            String O0000O0o2 = gsc.O0000O0o(context.getFilesDir() + File.separator + "sh_home_id");
            if (TextUtils.isEmpty(O0000O0o2)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(O0000O0o2);
            String optString = jSONObject.optString("homeid_server");
            ServerBean O000000o2 = ftn.O000000o(ServiceApplication.getAppContext());
            if (!TextUtils.isEmpty(optString)) {
                if (O000000o2 == null || TextUtils.equals(O000000o2.f7546O000000o, optString)) {
                    return jSONObject.optString("homeid");
                }
                return "";
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void O000000o(Context context, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("homeid_server", str);
            jSONObject.put("homeid", str2);
            String jSONObject2 = jSONObject.toString();
            gsc.O00000Oo(jSONObject2, context.getFilesDir() + File.separator + "sh_home_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void O000000o(SharedPreferences sharedPreferences, String str) {
        sharedPreferences.edit().putString("homeid", str).apply();
        if (TextUtils.isEmpty(str)) {
            sharedPreferences.edit().putString("homeid_server", "").apply();
        } else {
            ServerBean O000000o2 = ftn.O000000o(ServiceApplication.getAppContext());
            if (O000000o2 != null) {
                sharedPreferences.edit().putString("homeid_server", O000000o2.f7546O000000o).apply();
                O000000o(ServiceApplication.getAppContext(), O000000o2.f7546O000000o, str);
                gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "syncHomeToCore from saveHomeIdToSP ".concat(String.valueOf(str)));
                O00000oO(str);
            }
        }
        O000000o(ServiceApplication.getAppContext(), "", "");
        gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "syncHomeToCore from saveHomeIdToSP ".concat(String.valueOf(str)));
        O00000oO(str);
    }

    public final void O00000oO(final String str) {
        gsy.O00000Oo(LogType.HOME_ROOM, f17672O000000o, "syncHomeToCore ".concat(String.valueOf(str)));
        CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
            /* class _m_j.ggb.AnonymousClass12 */

            public final void onCoreReady() {
                gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "syncHomeToCore onCoreReady in");
                goq.O000000o(new Runnable() {
                    /* class _m_j.ggb.AnonymousClass12.AnonymousClass1 */

                    public final void run() {
                        HomeDeviceInfo homeDeviceInfo = null;
                        try {
                            if (!TextUtils.isEmpty(str)) {
                                Home O00000o = ggb.this.O00000o(str);
                                HomeDeviceInfo homeDeviceInfo2 = new HomeDeviceInfo();
                                homeDeviceInfo2.O000000o(O00000o);
                                homeDeviceInfo2.O000000o(CoreApi.O000000o().O0000o0());
                                homeDeviceInfo = homeDeviceInfo2;
                            }
                            try {
                                CoreApi.O000000o().O00000Oo().setCurrentHome(homeDeviceInfo);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            } catch (CoreApi.CoreNotReadyException e2) {
                                e2.printStackTrace();
                            }
                            gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "syncHomeToCore setCurrentHome sent");
                        } catch (Exception e3) {
                            e3.printStackTrace();
                            LogType logType = LogType.HOME_ROOM;
                            String str = ggb.f17672O000000o;
                            gsy.O00000Oo(logType, str, "syncHomeToCore setCurrentHome exception:" + e3.getMessage());
                        }
                    }
                });
            }
        });
    }

    public final boolean O00000oO() {
        return this.O00000Oo || !TextUtils.isEmpty(this.O00000o0);
    }

    public final int O00000oo() {
        return this.O0000OoO.O00000Oo.size();
    }

    public static JSONObject O00000oo(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", str);
        ArrayList arrayList = new ArrayList();
        Set<String> O0000O0o2 = fnn.O000000o().O00000Oo().O0000O0o(str);
        if (O0000O0o2 != null) {
            for (String next : O0000O0o2) {
                Device O000000o2 = fno.O000000o().O000000o(next);
                if (O000000o2 != null && O000000o(O000000o2)) {
                    arrayList.add(next);
                }
            }
        }
        jSONObject.put("dids", new JSONArray((Collection<?>) arrayList));
        return jSONObject;
    }

    public final List<Device> O0000O0o() {
        return O0000OOo(O0000OOo());
    }

    public final List<Device> O0000O0o(String str) {
        return O0000OOo(str);
    }

    public final List<Device> O0000OOo(String str) {
        Home O00000o2;
        ghb ghb = new ghb(new CopyOnWriteArrayList());
        if (!(TextUtils.isEmpty(str) || (O00000o2 = this.O0000OoO.O00000o(str)) == null || O00000o2.getDids() == null)) {
            ArrayList arrayList = new ArrayList(O00000o2.getDids());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                Device O000000o2 = fno.O000000o().O000000o((String) arrayList.get(i));
                if (O000000o2 != null && !O000000o2.isHideMainList()) {
                    if (O000000o2.isNew) {
                        arrayList2.add(O000000o2);
                    } else {
                        ghb.add(O000000o2);
                    }
                }
            }
            ghb.addAll(arrayList2);
        }
        return ghb;
    }

    private void O0000oo0() {
        if (TextUtils.isEmpty(this.O00000o0)) {
            this.O00000o0 = O0000oOo();
            LogType logType = LogType.HOME_ROOM;
            String str = f17672O000000o;
            gsy.O00000Oo(logType, str, "syncHomeToCore from initCurrentHomeIdIfEmpty " + this.O00000o0);
            O00000oO(this.O00000o0);
        }
    }

    public final String O0000OOo() {
        Home home;
        O0000oo0();
        if ((TextUtils.isEmpty(this.O00000o0) || O00000o(this.O00000o0) == null) && this.O0000OoO.O00000Oo.size() > 0 && (home = this.O0000OoO.O00000Oo.get(0)) != null) {
            this.O00000o0 = home.getId();
            O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), this.O00000o0);
        }
        return this.O00000o0;
    }

    public final Home O0000Oo0() {
        O0000oo0();
        return O00000o(this.O00000o0);
    }

    public final void O000000o(String str, String str2, List<String> list) {
        Home O0000Oo02;
        if (!TextUtils.isEmpty(str2)) {
            Pair pair = null;
            if (TextUtils.isEmpty(null)) {
                str = this.O00000o0;
            }
            O00000Oo o00000Oo = this.O0000OoO;
            if (TextUtils.isEmpty(str)) {
                gsy.O000000o(6, f17672O000000o, "saveOrders: homeID==null mCurrentHomeId==" + O00000Oo().O00000o0 + " mHomeMapSize==" + o00000Oo.f17692O000000o.size());
            } else if (!TextUtils.isEmpty(str2) && (O0000Oo02 = ggb.this.O0000Oo0()) != null && O0000Oo02.isOwner()) {
                String str3 = "";
                if (fqv.f16910O000000o) {
                    DeviceTagInterface.Category O0000Oo03 = fnn.O000000o().O00000Oo().O0000Oo0(str2);
                    if (O0000Oo03 != null) {
                        str3 = O0000Oo03.parentId;
                    }
                    str2 = str2 + "_";
                }
                try {
                    List list2 = O00000o0.O00000o0.get(str);
                    if (list2 == null) {
                        list2 = new ArrayList();
                        O00000o0.O00000o0.put(str, list2);
                    }
                    int i = 0;
                    while (true) {
                        if (i < list2.size()) {
                            Pair pair2 = (Pair) list2.get(i);
                            if (pair2 != null && TextUtils.equals((CharSequence) pair2.first, str2)) {
                                pair = pair2;
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    if (pair == null) {
                        list2.add(new Pair(str2, list));
                    } else {
                        ((List) pair.second).clear();
                        ((List) pair.second).addAll(list);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ggr ggr = ggr.f17748O000000o;
                ggr.O000000o(str, str2, str3, list);
                O00000Oo.O000000o("home_room_room_sort", ErrorCode.SUCCESS.getCode());
            }
        }
    }

    public final void O000000o(String str, List<Room> list) {
        if (TextUtils.isEmpty(str)) {
            str = this.O00000o0;
        }
        O00000Oo o00000Oo = this.O0000OoO;
        Home O0000Oo02 = O00000Oo().O0000Oo0();
        if (O0000Oo02 != null && O0000Oo02.isOwner()) {
            if (TextUtils.isEmpty(str)) {
                if (!o00000Oo.f17692O000000o.isEmpty() || TextUtils.isEmpty(O00000Oo().O00000o0)) {
                    Iterator<String> it = o00000Oo.f17692O000000o.keySet().iterator();
                    if (it.hasNext()) {
                        str = it.next();
                    }
                } else {
                    o00000Oo.f17692O000000o.put(O00000Oo().O00000o0, list);
                    return;
                }
            }
            if (TextUtils.isEmpty(str) || list == null) {
                String str2 = f17672O000000o;
                gsy.O000000o(6, str2, "saveOrders: homeID==null mCurrentHomeId==" + O00000Oo().O00000o0 + " mHomeMapSize==" + o00000Oo.f17692O000000o.size());
                return;
            }
            try {
                ArrayList arrayList = new ArrayList(list);
                o00000Oo.f17692O000000o.put(str, list);
                Home O00000o2 = o00000Oo.O00000o(str);
                List roomList = O00000o2.getRoomList();
                if (roomList == null) {
                    roomList = new ArrayList();
                    O00000o2.setRoomList(roomList);
                }
                roomList.clear();
                roomList.addAll(arrayList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            ArrayList arrayList2 = new ArrayList(list);
            O00000o0.O000000o(o00000Oo.O00000o(str), arrayList2);
            ggr ggr = ggr.f17748O000000o;
            ggr.O000000o(str, arrayList2);
            O00000Oo.O000000o("home_room_room_sort", ErrorCode.SUCCESS.getCode());
        }
    }

    public final void O000000o(String str, List<String> list, String str2, O00000o o00000o) {
        O000000o(O0000OOo(), str, list, str2, o00000o);
    }

    public final void O000000o(String str, String str2, List<String> list, String str3, O00000o o00000o) {
        if (!ggh.O000000o().O000000o(str3)) {
            str3 = "";
        }
        String str4 = str3;
        if (TextUtils.isEmpty(str)) {
            str = O0000OOo();
        }
        this.O0000OoO.O000000o(str, str2, list, str4, o00000o);
    }

    public static boolean O0000Oo0(String str) {
        return !TextUtils.isEmpty(str);
    }

    public final int O000000o(Room room) {
        if (room == null) {
            List<Device> O0000Oo2 = O0000Oo();
            if (O0000Oo2 == null) {
                return 0;
            }
            return O0000Oo2.size();
        }
        List<String> dids = room.getDids();
        if (dids == null || dids.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < dids.size(); i2++) {
            Device O000000o2 = fno.O000000o().O000000o(dids.get(i2));
            if (O000000o2 != null && O000000o(O000000o2)) {
                i++;
            }
        }
        return i;
    }

    public final List<Device> O0000Oo() {
        List<Device> list = this.O0000o0O;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        int i = this.O0000O0o;
        if (i == -1) {
            List<Room> O00000o2 = O00000o();
            if (O00000o2 == null || O00000o2.isEmpty()) {
                return arrayList;
            }
            for (int i2 = 0; i2 < O00000o2.size(); i2++) {
                Room room = O00000o2.get(i2);
                if (room != null) {
                    List<String> dids = room.getDids();
                    for (int i3 = 0; i3 < dids.size(); i3++) {
                        Device O000000o2 = fno.O000000o().O000000o(dids.get(i3));
                        if (O000000o2 != null) {
                            arrayList.add(O000000o2);
                        }
                    }
                }
            }
        } else if (i == 6) {
            return O0000O0o();
        } else {
            if (i == 7) {
                List<Room> O00000o3 = O00000o();
                if (O00000o3 == null || O00000o3.isEmpty()) {
                    return arrayList;
                }
                for (int i4 = 0; i4 < O00000o3.size(); i4++) {
                    Room room2 = O00000o3.get(i4);
                    if (room2 != null) {
                        List<String> dids2 = room2.getDids();
                        for (int i5 = 0; i5 < dids2.size(); i5++) {
                            Device O000000o3 = fno.O000000o().O000000o(dids2.get(i5));
                            if (O000000o3 != null && O000000o3.isOwner()) {
                                arrayList.add(O000000o3);
                            }
                        }
                    }
                }
            } else {
                Room room3 = this.O00000o;
                if (room3 != null) {
                    return O00000Oo(room3);
                }
                List<Room> O00000o4 = O00000o();
                if (O00000o4 != null && !O00000o4.isEmpty()) {
                    for (int i6 = 0; i6 < O00000o4.size(); i6++) {
                        Room room4 = O00000o4.get(i6);
                        if (room4 != null) {
                            List<String> dids3 = room4.getDids();
                            for (int i7 = 0; i7 < dids3.size(); i7++) {
                                Device O000000o4 = fno.O000000o().O000000o(dids3.get(i7));
                                if (O000000o4 != null) {
                                    arrayList.add(O000000o4);
                                }
                            }
                        }
                    }
                }
                return arrayList;
            }
        }
        this.O0000o0O = arrayList;
        return arrayList;
    }

    public final List<Device> O00000Oo(Room room) {
        ArrayList arrayList = new ArrayList();
        if (room == null) {
            return O0000Oo();
        }
        List<String> dids = room.getDids();
        if (dids != null && !dids.isEmpty()) {
            for (int i = 0; i < dids.size(); i++) {
                Device O000000o2 = fno.O000000o().O000000o(dids.get(i));
                if (O000000o(O000000o2)) {
                    arrayList.add(O000000o2);
                }
            }
        }
        return arrayList;
    }

    public final List<Device> O0000Oo(String str) {
        Home O00000o2;
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str) || (O00000o2 = O00000o(str)) == null) {
            return arrayList;
        }
        if (!O00000o2.isOwner()) {
            return ggw.O000000o().O00000o0(str);
        }
        List<Room> O000000o2 = O000000o(str);
        if (O000000o2 == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(O000000o2);
        for (int i = 0; i < arrayList2.size(); i++) {
            Room room = (Room) arrayList2.get(i);
            if (room != null) {
                ArrayList arrayList3 = new ArrayList(room.getDids());
                for (int i2 = 0; i2 < arrayList3.size(); i2++) {
                    Device O000000o3 = fno.O000000o().O000000o((String) arrayList3.get(i2));
                    if (O000000o3 != null) {
                        arrayList.add(O000000o3);
                    }
                }
            }
        }
        List<Device> O0000O0o2 = O0000O0o(str);
        if (O0000O0o2 != null) {
            arrayList.addAll(O0000O0o2);
        }
        return arrayList;
    }

    public static List<String> O0000OoO(String str) {
        List list = O00000o0.O00000o.get(str);
        return list == null ? Collections.emptyList() : new ArrayList(list);
    }

    public static boolean O0000Ooo(String str) {
        Boolean bool = O00000o0.O00000oO.get(str);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final Room O0000o00(String str) {
        return this.O0000OoO.O000000o(str);
    }

    public final Home O0000o0(String str) {
        return this.O0000OoO.O00000Oo(str);
    }

    public final String O0000o0O(String str) {
        Device O000000o2 = fno.O000000o().O000000o(str);
        if (O000000o2 == null) {
            O000000o2 = fno.O000000o().O00000oo(str);
        }
        if (O000000o2 == null) {
            return "";
        }
        ftn.O00000o0(ServiceApplication.getAppContext());
        if (fno.O000000o().O00000o(O000000o2) && !O000000o2.isHomeShared()) {
            return ServiceApplication.getAppContext().getResources().getString(R.string.tag_share);
        }
        if (fno.O000000o().O00000oO(O000000o2) && !O000000o2.isHomeShared()) {
            return ServiceApplication.getAppContext().getResources().getString(R.string.nearby_device);
        }
        if (ggd.O000000o(O000000o2.model)) {
            return ServiceApplication.getAppContext().getResources().getString(R.string.virtual_device_room_name);
        }
        Room O000000o3 = this.O0000OoO.O000000o(str);
        if (O000000o3 != null) {
            return O000000o3.getName();
        }
        return ServiceApplication.getAppContext().getResources().getString(R.string.tag_unassign);
    }

    public final boolean O000000o(Room room, String str) {
        return O000000o(room, str, (String) null);
    }

    public final boolean O000000o(Room room, String str, String str2) {
        List<Room> list;
        if (str2 != null) {
            list = O000000o(str2);
        } else if (room == null) {
            list = O00000o();
        } else {
            list = O000000o(room.getParentid());
        }
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                Room room2 = (Room) list.get(i);
                if ((room == null || (!TextUtils.equals(room2.getId(), room.getId()) && !TextUtils.equals(room2.getName(), room.getName()))) && TextUtils.equals(room2.getName(), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public static List<String> f17714O000000o = new ArrayList();
        public static Map<String, List<Room>> O00000Oo = new ConcurrentHashMap();
        public static Map<String, List<String>> O00000o = new ConcurrentHashMap();
        public static Map<String, List<Pair<String, List<String>>>> O00000o0 = new ConcurrentHashMap();
        public static Map<String, Boolean> O00000oO = new ConcurrentHashMap();

        public static void O000000o(Home home, List<Room> list) {
            if (home != null) {
                try {
                    boolean z = true;
                    boolean z2 = true;
                    for (Room next : list) {
                        if (next != null) {
                            if (TextUtils.equals(next.getId(), "mijia.roomid.default")) {
                                z = false;
                            } else if (TextUtils.equals(next.getId(), "mijia.roomid.share")) {
                                z2 = false;
                            }
                        }
                    }
                    if (z && home.getDids().size() > 0) {
                        Room room = new Room();
                        room.setId("mijia.roomid.default");
                        room.setDids(home.getDids());
                        list.add(room);
                    }
                    Room O00000Oo2 = ggb.O00000Oo().O00000Oo("mijia.roomid.share");
                    if (z2 && O00000Oo2.getDids().size() > 0) {
                        Room room2 = new Room();
                        room2.setId("mijia.roomid.share");
                        room2.setDids(new ArrayList(O00000Oo2.getDids()));
                        list.add(room2);
                    }
                } catch (Exception e) {
                    String str = ggb.f17672O000000o;
                    gsy.O000000o(6, str, "appendSpecialRoomOrderIfNeeded: " + e.getLocalizedMessage());
                }
            }
        }

        public static List<Device> O000000o(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                str = ggb.O00000Oo().O0000OOo();
            }
            ArrayList arrayList = new ArrayList();
            List list = O00000Oo.get(str);
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Room room = (Room) list.get(i);
                    if (room.getId().equals(str2)) {
                        List<String> dids = room.getDids();
                        for (int i2 = 0; i2 < dids.size(); i2++) {
                            Device O000000o2 = fno.O000000o().O000000o(dids.get(i2));
                            if (O000000o2 != null) {
                                arrayList.add(O000000o2);
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        public static <T> void O000000o(List<T> list, final List<T> list2) {
            Collections.sort(list, new Comparator<T>() {
                /* class _m_j.ggb.O00000o0.AnonymousClass1 */

                public final int compare(T t, T t2) {
                    int indexOf = list2.indexOf(t);
                    int indexOf2 = list2.indexOf(t2);
                    if (indexOf < 0 && indexOf2 > 0) {
                        return -1;
                    }
                    if (indexOf > 0 && indexOf2 < 0) {
                        return 1;
                    }
                    if (indexOf >= 0 || indexOf2 >= 0) {
                        return indexOf - indexOf2;
                    }
                    return 0;
                }
            });
        }

        public static LinkedHashMap<String, LinkedHashMap<String, List<String>>> O000000o(List<String> list) {
            String str;
            LinkedHashMap<String, LinkedHashMap<String, List<String>>> linkedHashMap = new LinkedHashMap<>();
            if (list.isEmpty()) {
                return linkedHashMap;
            }
            for (int i = 0; i < list.size(); i++) {
                String str2 = list.get(i);
                if (fno.O000000o().O000000o(str2) != null) {
                    Home O0000o0 = ggb.O00000Oo().O0000o0(str2);
                    Room O0000o00 = ggb.O00000Oo().O0000o00(str2);
                    if (O0000o0 != null) {
                        LinkedHashMap linkedHashMap2 = linkedHashMap.get(O0000o0.getId());
                        if (linkedHashMap2 == null) {
                            linkedHashMap2 = new LinkedHashMap();
                            linkedHashMap.put(O0000o0.getId(), linkedHashMap2);
                        }
                        if (O0000o00 == null) {
                            str = "";
                        } else {
                            str = O0000o00.getId();
                        }
                        Object obj = (List) linkedHashMap2.get(str);
                        if (obj == null) {
                            obj = new ArrayList();
                            linkedHashMap2.put(str, obj);
                        }
                        obj.add(str2);
                    }
                }
            }
            return linkedHashMap;
        }
    }

    public final void O000000o(Room room, List<String> list, List<String> list2, O00000o o00000o) {
        this.O0000OoO.O000000o(room, list, list2, o00000o);
    }

    public final void O000000o(Room room, O00000o o00000o) {
        this.O0000OoO.O000000o(room, o00000o);
    }

    public final void O000000o(List<String> list, O00000o o00000o) {
        this.O0000OoO.O000000o(list, o00000o);
    }

    public final void O000000o(Home home, O00000o o00000o) {
        this.O0000OoO.O000000o(home, "set", o00000o);
    }

    public final void O000000o(Home home, Room room, Device device, O00000o o00000o) {
        this.O0000OoO.O000000o(home, room, device, o00000o);
    }

    public final void O000000o(Home home, List<String> list, O00000o o00000o) {
        O00000Oo o00000Oo = this.O0000OoO;
        if (home != null && list != null && !list.isEmpty()) {
            fru.O000000o().O000000o(home, (Room) null, list, new fsm<JSONObject, fso>(null, list, home, o00000o) {
                /* class _m_j.ggb.O00000Oo.AnonymousClass11 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Room f17695O000000o = null;
                final /* synthetic */ List O00000Oo;
                final /* synthetic */ O00000o O00000o;
                final /* synthetic */ Home O00000o0;

                {
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                    this.O00000o = r5;
                }

                public final void onFailure(fso fso) {
                    O00000o o00000o = this.O00000o;
                    if (o00000o != null) {
                        o00000o.O000000o(2, fso);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    try {
                        if (this.f17695O000000o != null) {
                            List dids = this.f17695O000000o.getDids();
                            if (dids == null) {
                                dids = new ArrayList();
                                this.f17695O000000o.setDids(dids);
                            }
                            dids.addAll(0, this.O00000Oo);
                        } else {
                            List dids2 = this.O00000o0.getDids();
                            if (dids2 == null) {
                                dids2 = new ArrayList();
                                this.O00000o0.setDids(dids2);
                            }
                            dids2.addAll(0, this.O00000Oo);
                        }
                        O00000Oo.this.O000000o();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    O00000o o00000o = this.O00000o;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                }
            });
        }
    }

    public final void O000000o(Room room, List<String> list) {
        this.O0000OoO.O000000o(room, (List<String>) null, list);
    }

    public final Map<String, Set<String>> O0000OoO() {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList(O00000o());
        if (!arrayList.isEmpty()) {
            for (int i = 0; i < arrayList.size(); i++) {
                Room room = (Room) arrayList.get(i);
                HashSet hashSet = new HashSet();
                List<String> dids = room.getDids();
                if (dids != null && !dids.isEmpty()) {
                    hashSet.addAll(dids);
                }
                hashMap.put(room.getName(), hashSet);
            }
        }
        return hashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008a, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[SYNTHETIC, Splitter:B:30:0x0064] */
    public final synchronized void O000000o(Set<String> set, String str, O00000o o00000o) {
        Room room;
        ArrayList arrayList;
        if (set != null) {
            if (!set.isEmpty()) {
                String next = set.iterator().next();
                if (!TextUtils.isEmpty(next)) {
                    Home O0000Oo02 = ggb.this.O0000Oo0();
                    if (O0000Oo02 != null) {
                        ArrayList arrayList2 = new ArrayList(O0000Oo02.getRoomList());
                        int i = 0;
                        while (true) {
                            if (i >= arrayList2.size()) {
                                break;
                            }
                            room = (Room) arrayList2.get(i);
                            if (room != null && TextUtils.equals(next, room.getName())) {
                                break;
                            }
                            i++;
                        }
                        if (room != null) {
                            ArrayList arrayList3 = new ArrayList();
                            if (!TextUtils.isEmpty(str)) {
                                arrayList3.add(str);
                            }
                            O000000o(next, arrayList3, (String) null, o00000o);
                            return;
                        }
                        List<String> dids = room.getDids();
                        if (dids == null) {
                            arrayList = new ArrayList();
                        } else {
                            arrayList = new ArrayList(dids);
                        }
                        if (!arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                        this.O0000OoO.O000000o(room, arrayList, (List<String>) null, o00000o);
                        return;
                    }
                    room = null;
                    if (room != null) {
                    }
                }
            }
        }
    }

    public final synchronized List<String> O0000oO0(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Room O0000o002 = O0000o00(str);
        if (O0000o002 != null) {
            arrayList.add(O0000o002.getName());
        }
        return arrayList;
    }

    public final synchronized void O0000Ooo() {
        O00000Oo o00000Oo = this.O0000OoO;
        o00000Oo.f17692O000000o = new HashMap();
        o00000Oo.O00000Oo = new ArrayList();
        o00000Oo.O00000o0.set(false);
        o00000Oo.O00000o.set(false);
        o00000Oo.O00000oo = false;
        o00000Oo.O00000oO.set(true);
        this.O00000o0 = "";
        this.O00000o = null;
        this.O0000O0o = -1;
        O00000o0.f17714O000000o = new ArrayList();
        O00000o0.O00000Oo = new ConcurrentHashMap();
        O00000o0.O00000o0 = new ConcurrentHashMap();
        this.O00000Oo = false;
        O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), "");
        gpy.O000000o(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", new String("{}"));
        gfx.O000000o();
        gfx.O00000o0();
    }

    public class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public Map<String, List<Room>> f17692O000000o = new ConcurrentHashMap();
        public List<Home> O00000Oo = new ArrayList();
        public AtomicBoolean O00000o = new AtomicBoolean(false);
        public AtomicBoolean O00000o0 = new AtomicBoolean(false);
        AtomicBoolean O00000oO = new AtomicBoolean(true);
        public volatile boolean O00000oo = false;
        public long O0000O0o = 0;
        public AtomicBoolean O0000OOo = new AtomicBoolean(true);
        public boolean O0000Oo0 = true;
        private final Consumer<Triple<List<Home>, List<ggo>, Boolean>> O0000OoO = new Consumer<Triple<List<Home>, List<ggo>, Boolean>>() {
            /* class _m_j.ggb.O00000Oo.AnonymousClass4 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ggr.O000000o(java.util.List<? extends com.xiaomi.smarthome.homeroom.model.Home>, boolean):io.reactivex.Observable<java.util.List<_m_j.ggo>>
             arg types: [java.util.List<com.xiaomi.smarthome.homeroom.model.Home>, int]
             candidates:
              _m_j.ggr.O000000o(java.lang.String, java.util.List<? extends com.xiaomi.smarthome.homeroom.model.Room>):void
              _m_j.ggr.O000000o(java.util.List<java.lang.String>, java.lang.String):void
              _m_j.ggr.O000000o(java.util.List<? extends com.xiaomi.smarthome.homeroom.model.Home>, boolean):io.reactivex.Observable<java.util.List<_m_j.ggo>> */
            @SuppressLint({"CheckResult"})
            public final /* synthetic */ void accept(Object obj) throws Exception {
                Triple triple = (Triple) obj;
                List<ggo> list = (List) triple.second;
                Boolean bool = (Boolean) triple.third;
                if (!O00000Oo.this.O00000Oo.isEmpty() && O00000Oo.this.O00000o(ggb.O00000Oo().O00000o0) == null) {
                    ggb.O00000Oo().O00000o0 = O00000Oo.this.O00000Oo.get(0).getId();
                    ggb.this.O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), ggb.this.O00000o0);
                }
                for (ggo ggo : list) {
                    ggn ggn = ggo.O00000o0;
                    String str = ggo.f17746O000000o;
                    if (!TextUtils.isEmpty(str)) {
                        gfx.O000000o().f17665O000000o.put(str, new ArrayList(ggn.f17745O000000o));
                        Intent intent = new Intent("common_used_device_updated");
                        intent.putExtra("common_used_device_updated_result_code", ErrorCode.SUCCESS);
                        intent.putExtra("common_use_device_operation", "operation_sync");
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
                    }
                }
                ArrayList arrayList = new ArrayList();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
                ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
                for (ggo ggo2 : list) {
                    String str2 = ggo2.f17746O000000o;
                    if (!TextUtils.isEmpty(str2)) {
                        arrayList.add(str2);
                        ArrayList arrayList2 = new ArrayList();
                        Iterator<ggs> it = ggo2.O00000o.iterator();
                        while (it.hasNext()) {
                            ggs next = it.next();
                            Room room = new Room();
                            room.setId(next.O000000o());
                            room.setDids(new ArrayList(next.f17750O000000o));
                            arrayList2.add(room);
                        }
                        concurrentHashMap.put(str2, arrayList2);
                        ArrayList arrayList3 = new ArrayList();
                        concurrentHashMap2.put(str2, arrayList3);
                        Iterator<ggj> it2 = ggo2.O00000oO.iterator();
                        while (it2.hasNext()) {
                            ggj next2 = it2.next();
                            arrayList3.add(Pair.create(next2.f17741O000000o, new ArrayList(next2.O00000Oo)));
                        }
                        concurrentHashMap3.put(str2, new ArrayList(ggo2.O00000oo.f17744O000000o));
                        concurrentHashMap4.put(str2, Boolean.valueOf(ggo2.O00000oo.O00000Oo));
                    }
                }
                O00000o0.f17714O000000o = arrayList;
                O00000o0.O00000Oo = concurrentHashMap;
                O00000o0.O00000o0 = concurrentHashMap2;
                O00000o0.O00000o = concurrentHashMap3;
                O00000o0.O00000oO = concurrentHashMap4;
                Iterator<Object> it3 = ggb.this.O0000o0o.iterator();
                while (it3.hasNext()) {
                    it3.next();
                }
                O00000Oo.this.O00000o0.set(false);
                O00000Oo.this.O00000o.set(true);
                O00000Oo.this.O000000o();
                O00000Oo.O000000o("home_room_sync", ErrorCode.SUCCESS.getCode());
                O00000Oo.this.O0000O0o = System.currentTimeMillis();
                if (bool.booleanValue()) {
                    Observable just = Observable.just(O00000Oo.this.O00000Oo);
                    ggr ggr = ggr.f17748O000000o;
                    Observable.combineLatest(just, ggr.O000000o((List<? extends Home>) O00000Oo.this.O00000Oo, false), new BiFunction<List<Home>, List<ggo>, Triple<List<Home>, List<ggo>, Boolean>>() {
                        /* class _m_j.ggb.O00000Oo.AnonymousClass4.AnonymousClass1 */

                        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
                            List list = (List) obj2;
                            return new Triple(O00000Oo.O000000o((List) obj, list), list, Boolean.FALSE);
                        }
                    }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this, $$Lambda$Jxp4LOjD5wh7hYvpBAWXzgH0LNY.INSTANCE);
                }
            }
        };
        private boolean O0000Ooo = true;

        /* access modifiers changed from: private */
        public static /* synthetic */ String O00000oo(String str) {
            return str;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String O0000O0o(String str) {
            return str;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String O0000OOo(String str) {
            return str;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ String O0000Oo0(String str) {
            return str;
        }

        public O00000Oo() {
        }

        private List<List<Room>> O00000o0() {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f17692O000000o.values());
            return arrayList;
        }

        public final Room O000000o(String str) {
            List<String> dids;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (String str2 : this.f17692O000000o.keySet()) {
                List list = this.f17692O000000o.get(str2);
                if (list != null && !list.isEmpty()) {
                    ArrayList arrayList = new ArrayList(list);
                    for (int i = 0; i < arrayList.size(); i++) {
                        Room room = (Room) arrayList.get(i);
                        if (!(room == null || (dids = room.getDids()) == null || dids.size() == 0)) {
                            if (gfr.O0000OOo) {
                                String str3 = ggb.f17672O000000o;
                                gsy.O00000Oo(str3, "getRoomByDid:" + room.toJSON().toString());
                            }
                            if (dids.contains(str)) {
                                return room;
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }

        public final Home O00000Oo(String str) {
            List<String> dids;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (Map.Entry next : this.f17692O000000o.entrySet()) {
                List list = (List) next.getValue();
                Home O00000o2 = O00000o((String) next.getKey());
                if (!(list == null || O00000o2 == null)) {
                    List<String> dids2 = O00000o2.getDids();
                    if (dids2 != null && dids2.contains(str)) {
                        return O00000o2;
                    }
                    for (int i = 0; i < list.size(); i++) {
                        Room room = (Room) list.get(i);
                        if (!(room == null || (dids = room.getDids()) == null || dids.size() == 0)) {
                            if (gfr.O0000OOo) {
                                String str2 = ggb.f17672O000000o;
                                gsy.O00000Oo(str2, "getRoomByDid:" + room.toJSON().toString());
                            }
                            if (dids.contains(str)) {
                                return O00000o2;
                            }
                        }
                    }
                    continue;
                }
            }
            return null;
        }

        public final void O000000o(Room room, List<String> list, List<String> list2) {
            Room O00000o02;
            List<String> dids;
            if (room != null && (O00000o02 = O00000o0(room.getId())) != null) {
                Home O00000o2 = O00000o(room.getParentid());
                if (O00000o2 != null) {
                    if (list != null) {
                        List<Home> list3 = this.O00000Oo;
                        for (int i = 0; i < list3.size(); i++) {
                            list3.get(i).getDidsExcludeStatus().removeAll(list);
                            if (list3.get(i).getDefDids() != null) {
                                list3.get(i).getDefDids().removeAll(list);
                            }
                        }
                    }
                    if (list2 != null) {
                        O00000o2.getDidsExcludeStatus().addAll(list2);
                    }
                }
                O00000o02.copyFrom(room);
                List dids2 = O00000o02.getDids();
                if (dids2 == null) {
                    dids2 = new ArrayList();
                }
                if (list != null && !list.isEmpty()) {
                    for (String next : list) {
                        if (!dids2.contains(next)) {
                            dids2.add(0, next);
                        }
                    }
                }
                if (list2 != null) {
                    dids2.removeAll(list2);
                }
                O00000o02.setDids(dids2);
                if (list != null && !list.isEmpty()) {
                    for (List next2 : O00000o0()) {
                        for (int i2 = 0; i2 < next2.size(); i2++) {
                            Room room2 = (Room) next2.get(i2);
                            if (!(room2 == null || O00000o02 == room2 || TextUtils.equals(O00000o02.getId(), room2.getId()) || (dids = room2.getDids()) == null || dids.isEmpty())) {
                                dids.removeAll(list);
                            }
                        }
                    }
                }
                if (gfr.O0000OOo) {
                    String str = ggb.f17672O000000o;
                    gsy.O000000o(3, str, "addAndDeleteRoomDevice:" + O00000o02.toJSON().toString());
                }
            }
        }

        public final void O000000o(Home home, Room room, Device device, O00000o o00000o) {
            try {
                Room O000000o2 = O000000o(device.did);
                if (O000000o2 != null) {
                    O000000o2.getDids().remove(device.did);
                }
                Home O00000Oo2 = O00000Oo(device.did);
                if (O00000Oo2 != null) {
                    O00000Oo2.getDids().remove(device.did);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            final Room room2 = room;
            final Device device2 = device;
            final Home home2 = home;
            final O00000o o00000o2 = o00000o;
            fru.O000000o().O000000o(home, room, device, new fsm<JSONObject, fso>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass10 */

                public final void onFailure(fso fso) {
                    O00000o o00000o = o00000o2;
                    if (o00000o != null) {
                        o00000o.O000000o(2, fso);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    try {
                        if (room2 != null) {
                            List dids = room2.getDids();
                            if (dids == null) {
                                dids = new ArrayList();
                                room2.setDids(dids);
                            }
                            dids.add(0, device2.did);
                        } else if (home2 != null) {
                            List dids2 = home2.getDids();
                            if (dids2 == null) {
                                dids2 = new ArrayList();
                                home2.setDids(dids2);
                            }
                            dids2.add(0, device2.did);
                        }
                        O00000Oo.this.O000000o();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    O00000o o00000o = o00000o2;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                }
            });
        }

        public final void O000000o(final Home home, final String str, final O00000o o00000o) {
            fru.O000000o().O000000o(home, str, new fsm<JSONObject, fso>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass12 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        if (TextUtils.equals(str, "delete") && jSONObject.getInt("affect") == 1) {
                            O00000Oo.this.f17692O000000o.remove(home.getId());
                            O00000Oo.this.O00000Oo.remove(home);
                            if (TextUtils.equals(home.getId(), ggb.this.O00000o0)) {
                                ggb.this.O000000o(O00000Oo.this.O00000Oo.get(0).getId(), (fsm) null);
                            }
                        }
                        O00000Oo.this.O000000o();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                }

                public final void onFailure(fso fso) {
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o(2, fso);
                    }
                }
            });
        }

        public final void O000000o(Room room, List<String> list, List<String> list2, final O00000o o00000o) {
            O000000o(room, list, list2);
            fru O000000o2 = fru.O000000o();
            ServiceApplication.getAppContext();
            O000000o2.O000000o(room, list, list2, new fsm<JSONObject, fso>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass13 */

                public final void onFailure(fso fso) {
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o(2, fso);
                    } else if (fso == null || fso.f17063O000000o != -35) {
                        gqg.O00000Oo((int) R.string.add_failed);
                    } else {
                        gqg.O00000Oo((int) R.string.name_repeat);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                    O00000Oo.this.O000000o();
                    O00000Oo.O000000o("home_room_room_edit", ErrorCode.SUCCESS.getCode());
                }
            });
        }

        public final void O000000o(final Room room, final O00000o o00000o) {
            fru O000000o2 = fru.O000000o();
            ServiceApplication.getAppContext();
            O000000o2.O000000o(room, new fsm<JSONObject, fso>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass14 */

                public final void onFailure(fso fso) {
                    int i = 0;
                    if (fso.f17063O000000o != -1 || !gof.O00000o0()) {
                        O00000o o00000o = o00000o;
                        if (o00000o != null) {
                            o00000o.O000000o(0, fso);
                            return;
                        }
                        return;
                    }
                    List<Room> O00000oO = O00000Oo.this.O00000oO(room.getParentid());
                    if (O00000oO != null) {
                        while (true) {
                            if (i >= O00000oO.size()) {
                                break;
                            } else if (TextUtils.equals(O00000oO.get(i).getId(), room.getId())) {
                                O00000oO.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    O00000Oo.this.O000000o();
                    O00000Oo.O000000o("home_room_room_deleted", ErrorCode.SUCCESS.getCode());
                    O00000o o00000o2 = o00000o;
                    if (o00000o2 != null) {
                        o00000o2.O000000o();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    O00000Oo.this.O00000oO(room.getParentid()).remove(room);
                    try {
                        Home O00000o = O00000Oo.this.O00000o(room.getParentid());
                        O00000o.getDids().addAll(room.getDids());
                        O00000o.getRoomList().remove(room);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    O00000Oo.this.O000000o();
                    O00000Oo.O000000o("home_room_room_deleted", ErrorCode.SUCCESS.getCode());
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                }
            });
        }

        public final void O000000o(final List<String> list, final O00000o o00000o) {
            fru.O000000o().O000000o(list, new fsm<JSONObject, fso>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass15 */

                public final void onFailure(fso fso) {
                    if (fso.f17063O000000o != -1 || !gof.O00000o0()) {
                        O00000o o00000o = o00000o;
                        if (o00000o != null) {
                            o00000o.O000000o(0, fso);
                            return;
                        }
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        Room O00000o02 = O00000Oo.this.O00000o0((String) list.get(i));
                        if (O00000o02 != null) {
                            arrayList.add(O00000o02);
                        }
                    }
                    List<Room> O00000o = ggb.O00000Oo().O00000o();
                    if (O00000o != null) {
                        O00000o.removeAll(arrayList);
                    }
                    O00000Oo.this.O000000o();
                    O00000Oo.O000000o("home_room_room_deleted", ErrorCode.SUCCESS.getCode());
                    O00000o o00000o2 = o00000o;
                    if (o00000o2 != null) {
                        o00000o2.O000000o();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<Room> O00000oO;
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < list.size(); i++) {
                        Room O00000o02 = O00000Oo.this.O00000o0((String) list.get(i));
                        if (O00000o02 != null) {
                            arrayList.add(O00000o02);
                            try {
                                Home O00000o = O00000Oo.this.O00000o(O00000o02.getParentid());
                                O00000o.getDids().addAll(O00000o02.getDids());
                                O00000o.getRoomList().remove(O00000o02);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (arrayList.size() > 0 && (O00000oO = O00000Oo.this.O00000oO(((Room) arrayList.get(0)).getParentid())) != null) {
                        O00000oO.removeAll(arrayList);
                    }
                    O00000Oo.this.O000000o();
                    O00000Oo.O000000o("home_room_room_deleted", ErrorCode.SUCCESS.getCode());
                    O00000o o00000o = o00000o;
                    if (o00000o != null) {
                        o00000o.O000000o();
                    }
                }
            });
        }

        public final void O000000o(String str, String str2, List<String> list, String str3, O00000o o00000o) {
            if (ggb.O0000Oo0(str2)) {
                fru O000000o2 = fru.O000000o();
                ServiceApplication.getAppContext();
                final String str4 = str2;
                final List<String> list2 = list;
                final String str5 = str;
                final String str6 = str3;
                final O00000o o00000o2 = o00000o;
                O000000o2.O000000o(str2, str, list, str3, new fsm<JSONObject, fso>() {
                    /* class _m_j.ggb.O00000Oo.AnonymousClass17 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            Room room = new Room(str4);
                            room.setId(jSONObject.optString("roomid"));
                            room.setDids(list2);
                            room.setParentid(str5);
                            room.setBackground(str6);
                            List list = O00000Oo.this.f17692O000000o.get(str5);
                            if (list == null) {
                                list = new ArrayList();
                            }
                            list.add(room);
                            O00000Oo.this.f17692O000000o.put(str5, list);
                            try {
                                O00000Oo.this.O00000o(room.getParentid()).setRoomList(list);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            O00000Oo.this.O000000o();
                            O00000Oo.this.O000000o(room, list2, (List<String>) null);
                        }
                        O00000Oo.O000000o("home_room_room_added", ErrorCode.SUCCESS.getCode());
                        O00000o o00000o = o00000o2;
                        if (o00000o != null) {
                            o00000o.O000000o();
                        }
                    }

                    public final void onFailure(fso fso) {
                        O00000o o00000o = o00000o2;
                        if (o00000o != null) {
                            o00000o.O000000o(2, fso);
                        } else if (fso == null || fso.f17063O000000o != -35) {
                            gqg.O00000Oo((int) R.string.add_failed);
                        } else {
                            gqg.O00000Oo((int) R.string.name_repeat);
                        }
                    }
                });
            } else if (o00000o != null) {
                o00000o.O000000o(1, null);
            }
        }

        public final Room O00000o0(String str) {
            Map<String, List<Room>> map = this.f17692O000000o;
            Room room = null;
            if (map != null && !map.isEmpty()) {
                for (List next : map.values()) {
                    if (next != null && !next.isEmpty()) {
                        ArrayList arrayList = new ArrayList(next);
                        int i = 0;
                        while (true) {
                            if (i < arrayList.size()) {
                                Room room2 = (Room) arrayList.get(i);
                                if (room2 != null && TextUtils.equals(room2.getId(), str)) {
                                    room = room2;
                                    break;
                                }
                                i++;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return room;
        }

        public final Home O00000o(String str) {
            List<Home> list = this.O00000Oo;
            if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
                for (int i = 0; i < list.size(); i++) {
                    Home home = list.get(i);
                    if (home != null && TextUtils.equals(home.getId(), str)) {
                        return home;
                    }
                }
            }
            return null;
        }

        public final void O000000o() {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (Home next : this.O00000Oo) {
                if (next != null && !TextUtils.isEmpty(next.getId())) {
                    jSONArray.put(next.toJSON());
                }
            }
            try {
                jSONObject.put("homelist", jSONArray);
                if (gfr.O0000Ooo) {
                    gsy.O00000Oo(LogType.HOME_ROOM, "zxtzxt", "dumpHomeRoomToLocal: ".concat(String.valueOf(jSONArray)));
                    LogType logType = LogType.HOME_ROOM;
                    gsy.O00000Oo(logType, "zxtzxt", "dumpHomeRoomToLocal: " + Log.getStackTraceString(new Exception()));
                }
                gpy.O00000Oo(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", jSONObject.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public final List<Room> O00000oO(String str) {
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                return new ArrayList();
            }
            if (!this.O00000o.get()) {
                this.O00000o0.get();
            }
            if (str == null) {
                return null;
            }
            return this.f17692O000000o.get(str) == null ? new ArrayList() : this.f17692O000000o.get(str);
        }

        public final synchronized void O000000o(JSONObject jSONObject, boolean z) {
            boolean z2 = false;
            if (!jSONObject.isNull("homelist")) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("homelist");
                for (int i = 0; i < optJSONArray.length(); i++) {
                    Home O000000o2 = ggb.O000000o(optJSONArray.optJSONObject(i));
                    if (!this.O00000Oo.contains(O000000o2)) {
                        arrayList.add(O000000o2);
                    }
                }
                this.O00000Oo.addAll(arrayList);
            }
            for (int i2 = 0; i2 < this.O00000Oo.size(); i2++) {
                Home home = this.O00000Oo.get(i2);
                if (!(home == null || TextUtils.isEmpty(home.getId()) || home.getRoomList() == null)) {
                    this.f17692O000000o.put(home.getId(), home.getRoomList());
                }
            }
            if (gfr.O0000Ooo || gfr.O0000OOo) {
                LogType logType = LogType.HOME_ROOM;
                String str = ggb.f17672O000000o;
                gsy.O00000Oo(logType, str, "processHomeRoomContent result=" + Integer.valueOf(jSONObject.length()));
                LogType logType2 = LogType.HOME_ROOM;
                String str2 = ggb.f17672O000000o;
                StringBuilder sb = new StringBuilder("mHomeMap result=");
                sb.append(this.f17692O000000o == null ? null : Integer.valueOf(this.f17692O000000o.size()));
                gsy.O00000Oo(logType2, str2, sb.toString());
            }
            if (!this.O00000Oo.isEmpty() && O00000o(ggb.O00000Oo().O00000o0) == null) {
                ggb.O00000Oo().O00000o0 = this.O00000Oo.get(0).getId();
                ggb.this.O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), ggb.this.O00000o0);
            }
            if (!this.O00000Oo.isEmpty()) {
                z2 = true;
            }
            this.O00000oo = z2;
            LogType logType3 = LogType.HOME_ROOM;
            String str3 = ggb.f17672O000000o;
            gsy.O00000Oo(logType3, str3, "loadLocalDeviceData: mIsInited: " + this.O00000oo);
            gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "loadLocalDeviceData: ".concat(String.valueOf(z)));
            if (z) {
                O000000o("home_room_sync", ErrorCode.SUCCESS.getCode());
            }
        }

        private Observable<List<Home>> O00000o() {
            return Observable.create(new ObservableOnSubscribe<List<Home>>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass3 */

                public final void subscribe(final ObservableEmitter<List<Home>> observableEmitter) throws Exception {
                    ggb.this.O0000Oo0.O000000o(new fsm<JSONObject, fso>() {
                        /* class _m_j.ggb.O00000Oo.AnonymousClass3.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            JSONObject jSONObject = (JSONObject) obj;
                            LogType logType = LogType.HOME_ROOM;
                            String str = ggb.f17672O000000o;
                            StringBuilder sb = new StringBuilder("getHomeFromServer onSuccess result=");
                            sb.append(jSONObject == null ? null : Integer.valueOf(jSONObject.length()));
                            gsy.O00000o0(logType, str, sb.toString());
                            if (!observableEmitter.isDisposed()) {
                                ArrayList arrayList = new ArrayList();
                                if (jSONObject != null && !jSONObject.isNull("homelist")) {
                                    JSONArray optJSONArray = jSONObject.optJSONArray("homelist");
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        Home O000000o2 = ggb.O000000o(optJSONArray.optJSONObject(i));
                                        if (!arrayList.contains(O000000o2)) {
                                            arrayList.add(O000000o2);
                                        }
                                    }
                                    if (optJSONArray.length() == 0 && !TextUtils.isEmpty(ggb.this.O00000o0)) {
                                        ggb.this.O00000o0 = "";
                                        ggb.this.O000000o(ServiceApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0), ggb.this.O00000o0);
                                        if (O00000Oo.this.O0000OOo.getAndSet(false)) {
                                            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("force_update_data"));
                                        }
                                    }
                                }
                                if (jSONObject != null && !jSONObject.isNull("share_home_list")) {
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("share_home_list");
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        Home O000000o3 = ggb.O000000o(optJSONArray2.optJSONObject(i2));
                                        if (!arrayList.contains(O000000o3)) {
                                            arrayList.add(O000000o3);
                                        }
                                    }
                                }
                                observableEmitter.onNext(arrayList);
                                observableEmitter.onComplete();
                                if (gfr.O0000Ooo && arrayList.isEmpty()) {
                                    gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "getHomeFromServer onSuccess homes is empty".concat(String.valueOf(jSONObject)) == null ? "null" : jSONObject.toString());
                                }
                            }
                        }

                        public final void onFailure(fso fso) {
                            gsy.O00000o0(LogType.HOME_ROOM, ggb.f17672O000000o, "getHomeFromServer onFailure");
                            if (!observableEmitter.isDisposed()) {
                                try {
                                    observableEmitter.onError(new Exception(fso.O00000Oo));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends List<Home>>>() {
                /* class _m_j.ggb.O00000Oo.AnonymousClass2 */

                public final /* synthetic */ Object apply(Object obj) throws Exception {
                    final Throwable th = (Throwable) obj;
                    return new Observable<List<Home>>() {
                        /* class _m_j.ggb.O00000Oo.AnonymousClass2.AnonymousClass1 */

                        public final void subscribeActual(Observer<? super List<Home>> observer) {
                            try {
                                JSONObject jSONObject = new JSONObject(gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_", "home_room_content", "{}"));
                                ArrayList arrayList = new ArrayList();
                                if (!jSONObject.isNull("homelist")) {
                                    JSONArray optJSONArray = jSONObject.optJSONArray("homelist");
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        Home O000000o2 = ggb.O000000o(optJSONArray.optJSONObject(i));
                                        if (!arrayList.contains(O000000o2)) {
                                            arrayList.add(O000000o2);
                                        }
                                    }
                                }
                                if (!jSONObject.isNull("share_home_list")) {
                                    JSONArray optJSONArray2 = jSONObject.optJSONArray("share_home_list");
                                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                        Home O000000o3 = ggb.O000000o(optJSONArray2.optJSONObject(i2));
                                        if (!arrayList.contains(O000000o3)) {
                                            arrayList.add(O000000o3);
                                        }
                                    }
                                }
                                observer.onNext(arrayList);
                                observer.onComplete();
                            } catch (Exception e) {
                                e.printStackTrace();
                                observer.onError(th);
                            }
                        }
                    };
                }
            });
        }

        public static void O000000o(String str, int i) {
            Intent intent = new Intent("home_room_updated");
            intent.putExtra("operation", str);
            intent.putExtra("result_code", i);
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
        }

        @SuppressLint({"CheckResult"})
        public final boolean O00000Oo() {
            Observable<R> observable;
            LogType logType = LogType.HOME_ROOM;
            gsy.O00000Oo(logType, "forceUpdateAllData", "startSyncFromServer loginstate=" + ServiceApplication.getStateNotifier().f15923O000000o + ",update interval=" + Math.abs(System.currentTimeMillis() - this.O0000O0o) + ",mSynchronizing=" + this.O00000o0.get());
            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                return false;
            }
            if (Math.abs(System.currentTimeMillis() - this.O0000O0o) < 3000) {
                O000000o("home_room_sync", ErrorCode.SUCCESS.getCode());
                return false;
            } else if (this.O00000o0.getAndSet(true)) {
                return false;
            } else {
                final boolean z = this.O0000Ooo;
                if (z) {
                    this.O0000Ooo = false;
                }
                if (ggb.this.O0000Oo0() != null) {
                    Observable<List<Home>> O00000o2 = O00000o();
                    ggr ggr = ggr.f17748O000000o;
                    observable = Observable.combineLatest(O00000o2, ggr.O000000o(Collections.singletonList(ggb.this.O0000Oo0()), z), new BiFunction<List<Home>, List<ggo>, Triple<List<Home>, List<ggo>, Boolean>>() {
                        /* class _m_j.ggb.O00000Oo.AnonymousClass5 */

                        public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
                            List list = (List) obj;
                            List list2 = (List) obj2;
                            boolean z = O00000Oo.this.O0000Oo0;
                            List<Home> O000000o2 = O00000Oo.O000000o(list, list2);
                            boolean z2 = true;
                            if (list.size() == 1 || !z) {
                                z2 = false;
                            }
                            return new Triple(O000000o2, list2, Boolean.valueOf(z2));
                        }
                    });
                } else {
                    observable = O00000o().flatMap(new Function<List<Home>, ObservableSource<Triple<List<Home>, List<ggo>, Boolean>>>() {
                        /* class _m_j.ggb.O00000Oo.AnonymousClass6 */

                        public final /* synthetic */ Object apply(Object obj) throws Exception {
                            List list = (List) obj;
                            new ArrayList();
                            Observable just = Observable.just(list);
                            ggr ggr = ggr.f17748O000000o;
                            return Observable.combineLatest(just, ggr.O000000o(list, z), new BiFunction<List<Home>, List<ggo>, Triple<List<Home>, List<ggo>, Boolean>>() {
                                /* class _m_j.ggb.O00000Oo.AnonymousClass6.AnonymousClass1 */

                                public final /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
                                    List list = (List) obj2;
                                    return new Triple(O00000Oo.O000000o((List) obj, list), list, Boolean.FALSE);
                                }
                            });
                        }
                    });
                }
                observable.doOnNext(new Consumer<Triple<List<Home>, List<ggo>, Boolean>>() {
                    /* class _m_j.ggb.O00000Oo.AnonymousClass9 */

                    public final /* synthetic */ void accept(Object obj) throws Exception {
                        O00000Oo.this.O00000Oo = (List) ((Triple) obj).first;
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (int i = 0; i < O00000Oo.this.O00000Oo.size(); i++) {
                            Home home = O00000Oo.this.O00000Oo.get(i);
                            if (!TextUtils.isEmpty(home.getId()) && home.getRoomList() != null) {
                                concurrentHashMap.put(home.getId(), home.getRoomList());
                            }
                        }
                        O00000Oo o00000Oo = O00000Oo.this;
                        o00000Oo.f17692O000000o = concurrentHashMap;
                        o00000Oo.O00000oo = !o00000Oo.O00000Oo.isEmpty();
                        LogType logType = LogType.HOME_ROOM;
                        String str = ggb.f17672O000000o;
                        gsy.O00000Oo(logType, str, "accept: mIsInited: " + O00000Oo.this.O00000oo);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(this.O0000OoO, new Consumer<Throwable>() {
                    /* class _m_j.ggb.O00000Oo.AnonymousClass7 */

                    public final /* synthetic */ void accept(Object obj) throws Exception {
                        gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "accept: ");
                        O00000Oo.this.O00000o0.set(false);
                        O00000Oo.this.O00000o.set(true);
                        O00000Oo.O000000o("home_room_sync", ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                        gfx.O000000o();
                        gfx.O00000o();
                        O00000Oo.this.O0000O0o = System.currentTimeMillis();
                    }
                }, new Action() {
                    /* class _m_j.ggb.O00000Oo.AnonymousClass8 */

                    public final void run() throws Exception {
                        gsy.O00000Oo(LogType.HOME_ROOM, ggb.f17672O000000o, "startSyncFromServer: onComplete");
                        O00000Oo.this.O00000o0.set(false);
                        O00000Oo.this.O00000o.set(true);
                    }
                });
                return true;
            }
        }

        public static List<Home> O000000o(List<Home> list, List<ggo> list2) {
            for (Home next : list) {
                Iterator<ggo> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ggo next2 = it.next();
                    if (next2.f17746O000000o.equals(next.getId())) {
                        for (Room next3 : next.getRoomList()) {
                            ggs ggs = null;
                            Iterator<ggs> it2 = next2.O00000o.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                ggs next4 = it2.next();
                                if (next3.getId().equals(next4.O000000o())) {
                                    ggs = next4;
                                    break;
                                }
                            }
                            if (ggs != null) {
                                ArrayList<String> arrayList = ggs.f17750O000000o;
                                List<String> dids = next3.getDids();
                                $$Lambda$ggb$O00000Oo$Z6cZRhfdt9lJqnhJRdmKqMqb80 r8 = $$Lambda$ggb$O00000Oo$Z6cZRhfdt9lJqnhJRdmKqMqb80.INSTANCE;
                                $$Lambda$_zELlIIKFVwjqTKWzImv0Vn4I r9 = $$Lambda$_zELlIIKFVwjqTKWzImv0Vn4I.INSTANCE;
                                $$Lambda$ggb$O00000Oo$9XjcgYEpsJQOX_LQavheEPoNknw r10 = $$Lambda$ggb$O00000Oo$9XjcgYEpsJQOX_LQavheEPoNknw.INSTANCE;
                                ggv.O000000o(arrayList, dids, r8, r9, r10, next.getId() + "; device in room");
                            }
                        }
                        ArrayList<ggs> arrayList2 = next2.O00000o;
                        List<Room> roomList = next.getRoomList();
                        $$Lambda$2gDob3afLuwbvisSNtp_2Nb7NQ r14 = $$Lambda$2gDob3afLuwbvisSNtp_2Nb7NQ.INSTANCE;
                        $$Lambda$ggb$O00000Oo$fuI81AvHePFx_HoKok_edKmkLac r15 = $$Lambda$ggb$O00000Oo$fuI81AvHePFx_HoKok_edKmkLac.INSTANCE;
                        $$Lambda$_RPQ2Apfgv4zRysaoEK0OX61N0 r16 = $$Lambda$_RPQ2Apfgv4zRysaoEK0OX61N0.INSTANCE;
                        ggv.O000000o(arrayList2, roomList, r14, r15, r16, next.getId() + " ; roomOrder self");
                        List<String> dids2 = next.getDids();
                        if (dids2 != null && dids2.size() > 0) {
                            Iterator<ggs> it3 = next2.O00000o.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                ggs next5 = it3.next();
                                if (TextUtils.equals("mijia.roomid.default", next5.O000000o())) {
                                    ArrayList<String> arrayList3 = next5.f17750O000000o;
                                    $$Lambda$ggb$O00000Oo$E1AotsPARFOpv7lP91eR0AzNSdU r6 = $$Lambda$ggb$O00000Oo$E1AotsPARFOpv7lP91eR0AzNSdU.INSTANCE;
                                    $$Lambda$_zELlIIKFVwjqTKWzImv0Vn4I r7 = $$Lambda$_zELlIIKFVwjqTKWzImv0Vn4I.INSTANCE;
                                    $$Lambda$ggb$O00000Oo$MHp5wEatddfRvjnDtahp8FT2gA r82 = $$Lambda$ggb$O00000Oo$MHp5wEatddfRvjnDtahp8FT2gA.INSTANCE;
                                    next.setDids(ggv.O000000o(arrayList3, dids2, r6, r7, r82, next.getId() + " ; device in default home"));
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return list;
        }
    }

    public static class O0000O0o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static PublishSubject<Boolean> f17716O000000o = PublishSubject.create();
        private static String O00000oO = "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip".substring("http://cdn.cnbj0.fds.api.mi-img.com/miio.files/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip".lastIndexOf("/") + 1);
        private static File O00000oo = ServiceApplication.getAppContext().getDir("images", 0);
        private static File O0000O0o = new File(O00000oo + "/" + O00000oO);
        private static File O0000OOo;
        private static PublishSubject<String> O0000Oo0 = PublishSubject.create();
        public CompositeDisposable O00000Oo = new CompositeDisposable();
        private String O00000o = "";
        public BroadcastReceiver O00000o0 = new BroadcastReceiver() {
            /* class _m_j.ggb.O0000O0o.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                if (TextUtils.equals(intent.getAction(), "force_update_data_completed")) {
                    gsy.O00000o0(LogType.HOME_ROOM, "zzzDownloadAndUnZipWallPaperRes: ", "Retry");
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(O0000O0o.this.O00000o0);
                    O0000O0o.f17716O000000o.onNext(Boolean.TRUE);
                }
            }
        };

        static {
            StringBuilder sb = new StringBuilder();
            sb.append(O00000oo);
            sb.append("/wallPapers");
            O0000OOo = new File(sb.toString());
        }

        public static PublishSubject<String> O000000o() {
            return O0000Oo0;
        }

        public static String O000000o(String str, boolean... zArr) {
            if (!ggh.O000000o().O000000o(str)) {
                str = "style_1_favorites";
            }
            String str2 = gku.O000000o(ServiceApplication.getAppContext()) ? "dark" : "normal";
            String str3 = (zArr.length <= 0 || !zArr[0]) ? ".webp" : ".png";
            return O0000OOo.getAbsolutePath() + "/" + str + "_" + str2 + str3;
        }

        public O0000O0o() {
            ServerBean O000000o2 = fdc.O000000o().O000000o(ServiceApplication.getAppContext());
            if (O000000o2 == null) {
                gsy.O00000o0(LogType.HOME_ROOM, "zzzRoomIconManager ", "currentServer == null");
                return;
            }
            if (TextUtils.equals(O000000o2.f7546O000000o, fdc.O000000o().O00000Oo().f7546O000000o) || ftn.O0000Oo0(O000000o2)) {
                this.O00000o = "http://cdn.cnbj0.fds.api.mi-img.com/miio.files/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            } else if (TextUtils.equals(O000000o2.f7546O000000o, fdc.O000000o().O0000O0o().f7546O000000o)) {
                this.O00000o = "http://cdn.awsusor0.fds.api.mi-img.com/default/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            } else if (TextUtils.equals(O000000o2.f7546O000000o, fdc.O000000o().O00000oo().f7546O000000o)) {
                this.O00000o = "http://cdn.awsind0-eco.fds.api.mi-img.com/default/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            } else if (TextUtils.equals(O000000o2.f7546O000000o, fdc.O000000o().O0000OOo().f7546O000000o)) {
                this.O00000o = "http://cdn.awsde0.fds.api.mi-img.com/default/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            } else if (TextUtils.equals(O000000o2.f7546O000000o, fdc.O000000o().O0000Oo().f7546O000000o)) {
                this.O00000o = "http://cdn.ksyru0-eco.fds.api.mi-img.com/default/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            } else {
                this.O00000o = "http://cdn.awssgp0.fds.api.mi-img.com/default/resource_package/20201211153022_home_wallpaper_android_wallPapers.zip";
            }
            if (!O0000O0o.exists() || !O0000OOo.exists()) {
                f17716O000000o.observeOn(Schedulers.io()).filter($$Lambda$ggb$O0000O0o$B7UzI1r1hpBN0w1IlxQocXm838.INSTANCE).map(new Function() {
                    /* class _m_j.$$Lambda$ggb$O0000O0o$dnXsDwqahMupM_66O06g1mA1Pfo */

                    public final Object apply(Object obj) {
                        return ggb.O0000O0o.this.O000000o((Boolean) obj);
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Boolean>() {
                    /* class _m_j.ggb.O0000O0o.AnonymousClass2 */

                    public final void onComplete() {
                    }

                    public final /* synthetic */ void onNext(Object obj) {
                        if (!((Boolean) obj).booleanValue()) {
                            gsy.O00000o0(LogType.HOME_ROOM, "zzzDownloadAndUnZipWallpaperRes ", "onNext false");
                            ft.O000000o(ServiceApplication.getAppContext()).O000000o(O0000O0o.this.O00000o0, new IntentFilter("force_update_data_completed"));
                            return;
                        }
                        O0000O0o.this.O00000Oo.clear();
                    }

                    public final void onSubscribe(Disposable disposable) {
                        O0000O0o.this.O00000Oo.add(disposable);
                    }

                    public final void onError(Throwable th) {
                        LogType logType = LogType.HOME_ROOM;
                        gsy.O00000o0(logType, "zzzDownloadAndUnZipWallpaperRes ", "onError " + th.toString());
                    }
                });
                f17716O000000o.onNext(Boolean.TRUE);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Boolean O000000o(Boolean bool) throws Exception {
            if (gof.O000000o(ServiceApplication.getAppContext(), this.O00000o, O0000O0o, null).O00000Oo == 3) {
                gsy.O00000o0(LogType.HOME_ROOM, "zzzDownloadAndUnZipWallpaperRes ", "Load Success");
                fkw.O00000o0(O0000OOo.getAbsolutePath());
                boolean O000000o2 = fla.O000000o(O0000O0o.getAbsolutePath(), O00000oo.getAbsolutePath(), null);
                gsy.O00000o0(LogType.HOME_ROOM, "zzzDownloadAndUnZipWallpaperRes ", "UnZip ".concat(String.valueOf(O000000o2)));
                return Boolean.valueOf(O000000o2);
            }
            gsy.O00000o0(LogType.HOME_ROOM, "zzzDownloadAndUnZipWallpaperRes ", "Load Failed");
            O0000O0o.delete();
            return Boolean.FALSE;
        }

        public static void O000000o(SimpleDraweeView simpleDraweeView, String str, boolean... zArr) {
            if (simpleDraweeView != null) {
                simpleDraweeView.setImageURI(Uri.parse("file://".concat(String.valueOf(O000000o(str, zArr)))));
            }
        }
    }

    public static boolean O0000o00() {
        if (CoreApi.O000000o().O0000O0o()) {
            return ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
        }
        return ftn.O00000oO(ServiceApplication.getAppContext());
    }

    static {
        for (String add : fjb.f16441O000000o) {
            O0000o.add(add);
        }
    }

    public static boolean O000000o(Device device) {
        if (device == null || device.isHideMainList()) {
            return false;
        }
        if ((device.isOwner() || device.isHomeShared()) && !fqw.O000000o(device.did) && !device.isVirtualDevice() && ffs.O000000o(device.model) == 2 && !O0000o.contains(device.model)) {
            return true;
        }
        return false;
    }

    public final List<GridViewData> O0000o0() {
        gfx.O000000o();
        return gfx.O000000o(O0000OOo());
    }

    public final List<GridViewData> O0000o0O() {
        gfx.O000000o();
        return gfx.O00000Oo(O0000OOo());
    }

    public final List<GridViewData> O0000o0o() {
        gfx.O000000o();
        return gfx.O00000o0(O0000OOo());
    }

    public final void O0000o() {
        O00000Oo o00000Oo = this.O0000OoO;
        if (o00000Oo != null) {
            o00000Oo.O000000o();
        }
    }

    private void O0000oo() {
        if (ServiceApplication.getAppContext() != null && !CardActive.instance.isActive()) {
            if (O00oOooo != null) {
                eyg eyg = eyg.f15944O000000o;
                eyg.O00000Oo(O00oOooo);
            }
            O00oOooo = null;
            fno.O000000o().O00000Oo(this.O00oOoOo);
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O00oOooO);
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(this.O000O0OO);
            this.O0000ooo.set(false);
            this.O0000Oo.removeCallbacksAndMessages(null);
            gfx.O000000o();
            gfx.O00000o0();
            O0000oOO().O00000Oo.clear();
        }
    }

    public static void O0000oO0() {
        if (O00oOooo != null) {
            try {
                O00000Oo().O0000oo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void O000000o(final boolean z) {
        String str = f17672O000000o;
        gsy.O00000Oo(str, "forceUpdateAllData " + this.O0000ooo.get() + " isCoreready " + CoreApi.O000OO00());
        LogType logType = LogType.HOME_ROOM;
        StringBuilder sb = new StringBuilder("mIsForcingRefreshing=");
        sb.append(this.O0000ooo.get());
        gsy.O00000Oo(logType, "forceUpdateAllData", sb.toString());
        if (!this.O0000ooo.getAndSet(true)) {
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.ggb.AnonymousClass2 */

                public final void onCoreReady() {
                    ggb.this.O0000oO0.onNext(Boolean.TRUE);
                    ggb.this.O0000Oo.postDelayed(new Runnable() {
                        /* class _m_j.ggb.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            ggb.this.O0000ooo.set(false);
                        }
                    }, 5000);
                    IntentFilter intentFilter = new IntentFilter("device_updated");
                    intentFilter.addAction("card_init_updated");
                    ggb.this.O0000oOo.set(true);
                    gsy.O00000Oo("forceUpdateAllData", "add ACTION_DEVICE_UPDATED");
                    if (ggb.this.O0000OoO.O00000Oo()) {
                        intentFilter.addAction("home_room_updated");
                        ggb.this.O0000oo0.set(true);
                        gsy.O00000Oo("forceUpdateAllData", "add ACTION_HOME_ROOM_UPDATED");
                    }
                    fno.O000000o().O0000Oo0();
                    LogType logType = LogType.HOME_ROOM;
                    gsy.O00000o0(logType, "forceUpdateAllData", "mHomeUpdating=" + ggb.this.O0000oo0.get() + ",mCommonDeviceUpdating=" + ggb.this.O0000oo.get() + ",device count=" + fno.O000000o().O0000O0o().size() + ",pluginrecord size=" + PluginDeviceManager.instance.getPluginInfoMap().size() + ",SmartHomeDeviceManager isRefreshing=" + fno.O000000o().O0000o0());
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(ggb.this.O00oOooO, intentFilter);
                    goq.O000000o(new Runnable() {
                        /* class _m_j.ggb.AnonymousClass2.AnonymousClass2 */

                        public final void run() {
                            fnn.O000000o().O00000Oo().O00000o0();
                        }
                    });
                    hgq O000000o2 = hgq.O000000o();
                    String O0000OOo = TextUtils.isEmpty(null) ? ggb.O00000Oo().O0000OOo() : null;
                    if (!TextUtils.isEmpty(O0000OOo)) {
                        fru.O000000o().O0000O0o(O0000OOo, new fsm<JSONObject, fso>(null, O0000OOo) {
                            /* class _m_j.hgq.AnonymousClass2 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ fsm f18914O000000o = null;
                            final /* synthetic */ String O00000Oo;

                            public final void onFailure(fso fso) {
                            }

                            {
                                this.O00000Oo = r3;
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                JSONObject jSONObject = (JSONObject) obj;
                                if (jSONObject == null) {
                                    fsm fsm = this.f18914O000000o;
                                    if (fsm != null) {
                                        fsm.onFailure(new fso(ErrorCode.ERROR_UNKNOWN_ERROR.getCode(), "null result"));
                                        return;
                                    }
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                JSONArray optJSONArray = jSONObject.optJSONArray("room_desc_list");
                                if (optJSONArray != null) {
                                    for (int i = 0; i < optJSONArray.length(); i++) {
                                        RoomEnvData O000000o2 = RoomEnvData.O000000o(optJSONArray.optJSONObject(i));
                                        if (O000000o2 != null) {
                                            O000000o2.O00000o0 = this.O00000Oo;
                                            Map map = hgq.this.O00000Oo.get(this.O00000Oo);
                                            if (map == null) {
                                                map = new ConcurrentHashMap();
                                                hgq.this.O00000Oo.put(this.O00000Oo, map);
                                            }
                                            map.put(O000000o2.O00000Oo, O000000o2);
                                            arrayList.add(O000000o2);
                                        }
                                    }
                                }
                                fsm fsm2 = this.f18914O000000o;
                                if (fsm2 != null) {
                                    fsm2.onSuccess(arrayList);
                                }
                                hgq.this.O00000Oo();
                                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("room_env_data_updated"));
                            }
                        });
                    }
                    fru.O000000o().O00000oo(new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.homeroom.homedevicelist.DeviceCountManager.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str;
                            JSONObject jSONObject = (JSONObject) obj;
                            LogType logType = LogType.HOME_ROOM;
                            String str2 = DeviceCountManager.f8984O000000o;
                            if (jSONObject == null) {
                                str = "fetchDeviceCountFromServer null";
                            } else {
                                str = "fetchDeviceCountFromServer: " + jSONObject.toString();
                            }
                            gsy.O00000Oo(logType, str2, str);
                            DeviceCountManager.this.O00000Oo = DeviceCountModel.O000000o(jSONObject);
                            DeviceCountManager.this.O00000Oo();
                        }

                        public final void onFailure(fso fso) {
                            gsy.O00000Oo(DeviceCountManager.f8984O000000o, fso == null ? null : fso.toString());
                            DeviceCountManager.this.O00000Oo();
                        }
                    });
                    if (z) {
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("device_updated"));
                    }
                    if (ggb.this.O0000oO) {
                        ggb.this.O0000oO = false;
                        hzg O000000o3 = hzj.O000000o();
                        if (O000000o3 != null) {
                            O000000o3.refreshUwbData();
                        }
                    }
                }
            });
        }
    }

    public final void O0000oO() {
        String str = f17672O000000o;
        gsy.O00000Oo(str, "forceUpdateAllDataLite " + this.O0000ooo.get());
        if (!this.O0000ooo.getAndSet(true)) {
            this.O0000Oo.postDelayed(new Runnable() {
                /* class _m_j.ggb.AnonymousClass3 */

                public final void run() {
                    ggb.this.O0000ooo.set(false);
                }
            }, 5000);
            IntentFilter intentFilter = new IntentFilter("device_updated");
            intentFilter.addAction("card_init_updated");
            this.O0000oOo.set(true);
            gsy.O00000Oo("forceUpdateAllDataLite", "add ACTION_DEVICE_UPDATED");
            if (this.O0000OoO.O00000Oo()) {
                intentFilter.addAction("home_room_updated");
                this.O0000oo0.set(true);
                gsy.O00000Oo("forceUpdateAllDataLite", "add ACTION_HOME_ROOM_UPDATED");
            }
            fno.O000000o().O0000Oo0();
            LogType logType = LogType.HOME_ROOM;
            gsy.O00000o0(logType, "forceUpdateAllDataLite", "mHomeUpdating=" + this.O0000oo0.get() + ",mCommonDeviceUpdating=" + this.O0000oo.get() + ",device count=" + fno.O000000o().O0000O0o().size() + ",getHomeSize size=" + O00000oo() + ",pluginrecord size=" + PluginDeviceManager.instance.getPluginInfoMap().size() + ",SmartHomeDeviceManager isRefreshing=" + fno.O000000o().O0000o0());
            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new O000000o(this, (byte) 0), intentFilter);
        }
    }

    class O000000o extends BroadcastReceiver {
        private O000000o() {
        }

        /* synthetic */ O000000o(ggb ggb, byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (TextUtils.equals(action, "device_updated")) {
                gsy.O00000o0(LogType.HOME_ROOM, "forceUpdateAllData", "ACTION_DEVICE_UPDATED received");
                ggb.this.O0000oOo.set(false);
            } else if (TextUtils.equals(action, "home_room_updated")) {
                gsy.O00000o0(LogType.HOME_ROOM, "forceUpdateAllData", "ACTION_HOME_ROOM_UPDATED received");
                ggb.this.O0000oo0.set(false);
            } else if (TextUtils.equals(action, "common_used_device_updated")) {
                gsy.O00000o0(LogType.HOME_ROOM, "forceUpdateAllData", "ACTION_DATA_UPDATED received");
                ggb.this.O0000oo.set(false);
            }
            gsy.O00000Oo("forceUpdateAllData", "received:" + action + " mHomeUpdating=" + ggb.this.O0000oo0.get() + " ,mCommonDeviceUpdating=" + ggb.this.O0000oo.get() + " ,mDeviceUpdating=" + ggb.this.O0000oOo.get() + " ,mCardInited=" + ggb.this.O0000ooO);
            if (!ggb.this.O0000oOo.get() && !ggb.this.O0000oo0.get() && !ggb.this.O0000oo.get() && ggb.this.O0000ooO.get()) {
                gpy.O000000o(ServiceApplication.getAppContext(), "cache_data_timerequest", "force_update_data_completed", System.currentTimeMillis());
                ggw.O000000o().O00000Oo();
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(this);
                ggb.this.O0000ooo.set(false);
                ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("force_update_data_completed"));
                String str = "";
                Integer num = null;
                if (gfr.O0000Ooo || gfr.O0000OOo) {
                    LogType logType = LogType.HOME_ROOM;
                    gsy.O00000Oo(logType, "forceUpdateAllData", "ACTION_FORCE_UPDATE_COMPLETED sent,device count=" + fno.O000000o().O0000O0o().size() + ",currentHomeId=" + ggb.this.O00000o0 + ",pluginrecord size=" + PluginDeviceManager.instance.getPluginInfoMap().size());
                    Home O0000Oo0 = ggb.this.O0000Oo0();
                    List<Room> O00000o = ggb.this.O00000o();
                    ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                    LogType logType2 = LogType.HOME_ROOM;
                    StringBuilder sb = new StringBuilder("currentHome is =");
                    sb.append(O0000Oo0 == null ? null : O0000Oo0.toJSON().toString());
                    sb.append(",current server=");
                    if (O0000ooO != null) {
                        str = O0000ooO.f7546O000000o;
                    }
                    sb.append(str);
                    sb.append(",getDefaultRoomList=");
                    if (O00000o != null) {
                        num = Integer.valueOf(O00000o.size());
                    }
                    sb.append(num);
                    gsy.O00000Oo(logType2, "forceUpdateAllData", sb.toString());
                    return;
                }
                LogType logType3 = LogType.HOME_ROOM;
                gsy.O00000o0(logType3, "forceUpdateAllData", "ACTION_FORCE_UPDATE_COMPLETED sent,device count=" + fno.O000000o().O0000O0o().size() + ",currentHomeId=" + ggb.this.O00000o0 + ",pluginrecord size=" + PluginDeviceManager.instance.getPluginInfoMap().size());
                Home O0000Oo02 = ggb.this.O0000Oo0();
                List<Room> O00000o2 = ggb.this.O00000o();
                ServerBean O0000ooO2 = CoreApi.O000000o().O0000ooO();
                LogType logType4 = LogType.HOME_ROOM;
                StringBuilder sb2 = new StringBuilder("currentHome=");
                sb2.append(O0000Oo02);
                sb2.append(",current server=");
                if (O0000ooO2 != null) {
                    str = O0000ooO2.f7546O000000o;
                }
                sb2.append(str);
                sb2.append(",getDefaultRoomList=");
                if (O00000o2 != null) {
                    num = Integer.valueOf(O00000o2.size());
                }
                sb2.append(num);
                gsy.O00000o0(logType4, "forceUpdateAllData", sb2.toString());
            }
        }
    }

    public static boolean O0000oO(String str) {
        return hah.O000000o(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01b9, code lost:
        if (java.lang.Math.abs(r1 - java.lang.Double.parseDouble(r4.getLongitude())) < 0.001d) goto L_0x00e8;
     */
    public final String O000000o(fuy.O000000o o000000o, boolean z, Home home) {
        boolean z2;
        final Home O0000Oo02 = home == null ? O0000Oo0() : home;
        String str = "";
        if (O0000Oo02 == null) {
            return str;
        }
        if (!TextUtils.isEmpty(O0000Oo02.getAddr())) {
            return O0000Oo02.getAddr();
        }
        if (O0000Oo02 != null) {
            String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "home_location" + O0000Oo02.getId(), str);
            if (O00000o02.isEmpty()) {
                O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "home_room_manager_sp_" + CoreApi.O000000o().O0000o0(), "home_location" + O0000Oo02.getId(), str);
            }
            if (!TextUtils.isEmpty(O00000o02)) {
                try {
                    JSONObject jSONObject = new JSONObject(O00000o02);
                    String optString = jSONObject.optString("latitude", "0");
                    String optString2 = jSONObject.optString("longitude", "0");
                    String optString3 = jSONObject.optString("city_id");
                    if (TextUtils.isEmpty(optString3)) {
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.equals("0", optString)) {
                            if (TextUtils.equals("0", optString2)) {
                            }
                        }
                    }
                    String latitude = O0000Oo02.getLatitude();
                    String longitude = O0000Oo02.getLongitude();
                    String optString4 = jSONObject.optString("loc");
                    if (TextUtils.isEmpty(optString3) || TextUtils.equals(optString3, "0") || !TextUtils.equals(optString3, O0000Oo02.getLocationId())) {
                        if (TextUtils.isEmpty(O0000Oo02.getLocationId()) || TextUtils.equals(O0000Oo02.getLocationId(), "0")) {
                            double d = 0.0d;
                            double parseDouble = TextUtils.isEmpty(optString) ? 0.0d : Double.parseDouble(optString);
                            if (!TextUtils.isEmpty(optString2)) {
                                d = Double.parseDouble(optString2);
                            }
                            if (!TextUtils.isEmpty(latitude)) {
                                if (!TextUtils.isEmpty(longitude)) {
                                    if (!TextUtils.equals(latitude, "0")) {
                                        if (!TextUtils.equals(longitude, "0")) {
                                            if (Math.abs(parseDouble - Double.parseDouble(O0000Oo02.getLatitude())) < 0.005d) {
                                            }
                                            z2 = true;
                                            if (z && z2 && O0000Oo02.getLatitude() != null && O0000Oo02.getLongitude() != null) {
                                                final fuy.O000000o o000000o2 = o000000o;
                                                fuy.O000000o().O000000o(Double.parseDouble(O0000Oo02.getLatitude()), Double.parseDouble(O0000Oo02.getLongitude()), new fuy.O000000o() {
                                                    /* class _m_j.ggb.AnonymousClass5 */

                                                    public final void O000000o(String str, Location location) {
                                                        gwr O000000o2;
                                                        try {
                                                            Bundle extras = location.getExtras();
                                                            if (!(extras == null || (O000000o2 = gwu.O000000o(ServiceApplication.getAppContext(), (Address) extras.getParcelable("address"))) == null)) {
                                                                JSONObject jSONObject = new JSONObject();
                                                                jSONObject.put("latitude", location.getLatitude());
                                                                jSONObject.put("longitude", location.getLongitude());
                                                                jSONObject.put("loc", O000000o2.O00000Oo);
                                                                gpy.O000000o(ServiceApplication.getAppContext(), "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "home_location" + O0000Oo02.getId(), jSONObject.toString());
                                                            }
                                                            if (o000000o2 != null) {
                                                                o000000o2.O000000o(str, location);
                                                            }
                                                        } catch (Exception e) {
                                                            e.printStackTrace();
                                                            fuy.O000000o o000000o = o000000o2;
                                                            if (o000000o != null) {
                                                                o000000o.O000000o(str);
                                                            }
                                                        }
                                                    }

                                                    public final void O000000o(String str) {
                                                        super.O000000o(str);
                                                        fuy.O000000o o000000o = o000000o2;
                                                        if (o000000o != null) {
                                                            o000000o.O000000o(str);
                                                        }
                                                    }
                                                });
                                                return str;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            str = gws.O000000o(ServiceApplication.getAppContext(), O0000Oo02.getLocationId());
                            jSONObject.put("latitude", "0");
                            jSONObject.put("longitude", "0");
                            jSONObject.put("city_id", O0000Oo02.getLocationId());
                            jSONObject.put("address", O0000Oo02.getAddr());
                            jSONObject.put("loc", str);
                            gpy.O00000Oo(ServiceApplication.getAppContext(), "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "home_location" + O0000Oo02.getId(), jSONObject.toString());
                        }
                    }
                    str = optString4;
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                if (!TextUtils.isEmpty(O0000Oo02.getLocationId()) && !TextUtils.equals(O0000Oo02.getLocationId(), "0")) {
                    str = gws.O000000o(ServiceApplication.getAppContext(), O0000Oo02.getLocationId());
                }
                z2 = true;
                final fuy.O000000o o000000o22 = o000000o;
                fuy.O000000o().O000000o(Double.parseDouble(O0000Oo02.getLatitude()), Double.parseDouble(O0000Oo02.getLongitude()), new fuy.O000000o() {
                    /* class _m_j.ggb.AnonymousClass5 */

                    public final void O000000o(String str, Location location) {
                        gwr O000000o2;
                        try {
                            Bundle extras = location.getExtras();
                            if (!(extras == null || (O000000o2 = gwu.O000000o(ServiceApplication.getAppContext(), (Address) extras.getParcelable("address"))) == null)) {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("latitude", location.getLatitude());
                                jSONObject.put("longitude", location.getLongitude());
                                jSONObject.put("loc", O000000o2.O00000Oo);
                                gpy.O000000o(ServiceApplication.getAppContext(), "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "home_location" + O0000Oo02.getId(), jSONObject.toString());
                            }
                            if (o000000o22 != null) {
                                o000000o22.O000000o(str, location);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            fuy.O000000o o000000o = o000000o22;
                            if (o000000o != null) {
                                o000000o.O000000o(str);
                            }
                        }
                    }

                    public final void O000000o(String str) {
                        super.O000000o(str);
                        fuy.O000000o o000000o = o000000o22;
                        if (o000000o != null) {
                            o000000o.O000000o(str);
                        }
                    }
                });
                return str;
            }
            z2 = false;
            final fuy.O000000o o000000o222 = o000000o;
            fuy.O000000o().O000000o(Double.parseDouble(O0000Oo02.getLatitude()), Double.parseDouble(O0000Oo02.getLongitude()), new fuy.O000000o() {
                /* class _m_j.ggb.AnonymousClass5 */

                public final void O000000o(String str, Location location) {
                    gwr O000000o2;
                    try {
                        Bundle extras = location.getExtras();
                        if (!(extras == null || (O000000o2 = gwu.O000000o(ServiceApplication.getAppContext(), (Address) extras.getParcelable("address"))) == null)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("latitude", location.getLatitude());
                            jSONObject.put("longitude", location.getLongitude());
                            jSONObject.put("loc", O000000o2.O00000Oo);
                            gpy.O000000o(ServiceApplication.getAppContext(), "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "home_location" + O0000Oo02.getId(), jSONObject.toString());
                        }
                        if (o000000o222 != null) {
                            o000000o222.O000000o(str, location);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        fuy.O000000o o000000o = o000000o222;
                        if (o000000o != null) {
                            o000000o.O000000o(str);
                        }
                    }
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    fuy.O000000o o000000o = o000000o222;
                    if (o000000o != null) {
                        o000000o.O000000o(str);
                    }
                }
            });
            return str;
        }
        return str;
    }

    public final List<Device> O0000oOO(String str) {
        ArrayList arrayList = new ArrayList();
        List<Device> O0000Oo2 = O0000Oo(str);
        gge.O000000o();
        gge.O00000oO();
        if (O0000Oo2 != null) {
            gge.O000000o();
            O0000Oo2.addAll(gge.O00000oO());
        }
        if (O0000Oo2 != null && !O0000Oo2.isEmpty()) {
            for (int i = 0; i < O0000Oo2.size(); i++) {
                Device device = O0000Oo2.get(i);
                if (gge.O00000Oo(device)) {
                    arrayList.add(device);
                }
            }
        }
        return arrayList;
    }

    public static Home O000000o(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray optJSONArray2;
        JSONObject jSONObject2 = jSONObject;
        Home.O000000o o000000o = new Home.O000000o();
        if (jSONObject2 != null) {
            try {
                if (!jSONObject2.isNull("bssid")) {
                    o000000o.f8989O000000o = jSONObject2.optString("bssid");
                }
                if (!jSONObject2.isNull("desc")) {
                    o000000o.O00000Oo = jSONObject2.optString("desc");
                }
                if (!jSONObject2.isNull("id")) {
                    o000000o.O00000oo = jSONObject2.optString("id");
                }
                if (!jSONObject2.isNull("name")) {
                    o000000o.O0000O0o = jSONObject2.optString("name");
                }
                if (!jSONObject2.isNull("shareflag")) {
                    o000000o.O0000OOo = jSONObject2.optInt("shareflag");
                }
                if (!jSONObject2.isNull("uid")) {
                    o000000o.O0000o0O = jSONObject2.optLong("uid");
                }
                if (!jSONObject2.isNull("icon")) {
                    o000000o.O00000o0 = jSONObject2.optString("icon");
                }
                if (!jSONObject2.isNull("status")) {
                    o000000o.O00000o = jSONObject2.optString("status");
                }
                if (!jSONObject2.isNull("background")) {
                    String optString = jSONObject2.optString("background");
                    if (ggh.O000000o().f17740O000000o.contains(optString)) {
                        o000000o.O00000oO = optString;
                    }
                }
                if (!jSONObject2.isNull("latitude")) {
                    o000000o.O0000OoO = jSONObject2.optString("latitude");
                }
                if (!jSONObject2.isNull("longitude")) {
                    o000000o.O0000Ooo = jSONObject2.optString("longitude");
                }
                if (!jSONObject2.isNull("city_id")) {
                    o000000o.O0000o00 = jSONObject2.optString("city_id");
                }
                if (!jSONObject2.isNull("address")) {
                    o000000o.O0000o0 = jSONObject2.optString("address");
                }
                if (!jSONObject2.isNull("status")) {
                    o000000o.O00000o = jSONObject2.optString("status");
                }
                if (!jSONObject2.isNull("dids") && (optJSONArray2 = jSONObject2.optJSONArray("dids")) != null) {
                    ghb ghb = new ghb(new CopyOnWriteArrayList());
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        if (!TextUtils.isEmpty(optJSONArray2.optString(i))) {
                            ghb.add(optJSONArray2.optString(i));
                        }
                    }
                    o000000o.O000000o(ghb);
                }
                if (!jSONObject2.isNull("roomlist")) {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("roomlist");
                    for (int i2 = 0; i2 < optJSONArray3.length(); i2++) {
                        arrayList.add(Room.parse(optJSONArray3.optJSONObject(i2)));
                    }
                    o000000o.O0000Oo = arrayList;
                    arrayList.trimToSize();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Home O000000o2 = o000000o.O000000o();
        try {
            if (!jSONObject2.isNull("status_list") && (optJSONArray = jSONObject2.optJSONArray("status_list")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    String optString2 = optJSONArray.optString(i3);
                    if (!TextUtils.isEmpty(optString2)) {
                        arrayList2.add(optString2);
                    }
                }
                O000000o2.setStatus(arrayList2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        O000000o2.setName(O000000o(O000000o2));
        return O000000o2;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void
     arg types: [java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      _m_j.gyl.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView, com.facebook.imagepipeline.request.BasePostprocessor):void
      _m_j.gyl.O000000o(java.lang.String, _m_j.ftt<com.xiaomi.smarthome.miio.db.record.ShareUserRecord>, boolean):void */
    public static String O000000o(Home home) {
        if (home == null) {
            return "";
        }
        if (!TextUtils.isEmpty(home.getRawName()) && !TextUtils.isEmpty(home.getRawName().trim()) && !home.getRawName().equalsIgnoreCase(ServiceApplication.getAppContext().getResources().getString(R.string.default_home_name)) && !home.getRawName().equalsIgnoreCase("默认家庭") && !home.getRawName().equalsIgnoreCase("預設家庭") && !home.getRawName().equalsIgnoreCase("기본 가정") && !home.getRawName().equalsIgnoreCase("Default family group")) {
            return home.getRawName();
        }
        String O0000o02 = home.getOwnerUid() == 0 ? CoreApi.O000000o().O0000o0() : String.valueOf(home.getOwnerUid());
        UserInfo O000000o2 = ggg.O000000o().O000000o(Long.parseLong(O0000o02));
        if (O000000o2 == null || TextUtils.isEmpty(O000000o2.O00000oO)) {
            gyl.O000000o().O000000o(O0000o02, (ftt<ShareUserRecord>) null, true);
            return ServiceApplication.getAppContext().getResources().getString(R.string.my_home_1);
        }
        return ServiceApplication.getAppContext().getResources().getString(R.string.user_name_home_suffix, O000000o2.O00000oO);
    }

    public final boolean O0000o0o(String str) {
        List<Home> list = this.O0000OoO.O00000Oo;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (TextUtils.equals(O000000o(list.get(i)), str)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    public final synchronized void O0000o(String str) {
        Room room;
        ArrayList arrayList = new ArrayList(this.O0000OoO.f17692O000000o.values());
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            loop0:
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                List list = (List) it.next();
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        room = (Room) list.get(i);
                        if (room != null && TextUtils.equals(str, room.getName())) {
                            break loop0;
                        }
                    }
                    continue;
                }
            }
            if (room != null) {
                this.O0000OoO.O000000o(room, (O00000o) null);
            }
        }
        room = null;
        if (room != null) {
        }
    }
}
