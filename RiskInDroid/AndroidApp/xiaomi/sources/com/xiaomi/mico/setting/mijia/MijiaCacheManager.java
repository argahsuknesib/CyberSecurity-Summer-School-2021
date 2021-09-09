package com.xiaomi.mico.setting.mijia;

import _m_j.jgc;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.xiaomi.mico.api.SmartHomeRc4Manager;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.BaseResponse;
import com.xiaomi.mico.api.model.Miot;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.common.util.Cache;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.mico.setting.mijia.event.MijiaEvent;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MijiaCacheManager {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Miot.Home currHome;
    private static String currHomeId;
    private static Miot.Room currRoom;
    private static String currRoomName;
    private static Miot.Room defaultRoomForUnknown;
    private static HashMap<Miot.Home, List<Miot.Room>> homeRooms;
    private static List<Miot.Home> homes;
    private static boolean isLoading;
    private static HashMap<Admin.Mico, Location> micoLocationMap;
    private static long sLastShowTime;

    public static class Location implements Serializable {
        private static final long serialVersionUID = -6637718120722744378L;
        public Miot.Home home;
        public Miot.Room room;

        Location(Miot.Home home2, Miot.Room room2) {
            this.home = home2;
            this.room = room2;
        }
    }

    public static List<Miot.Home> getHomes() {
        return homes;
    }

    public static HashMap<Admin.Mico, Location> getMicoLocationMap() {
        return micoLocationMap;
    }

    private static void cacheCurrHomeId() {
        Cache.put("mijia_current_home_id_cache", currHomeId);
    }

    public static String getCurrHomeIdCache() {
        return (String) Cache.get("mijia_current_home_id_cache", String.class);
    }

    public static Miot.Home getCurrHome() {
        return currHome;
    }

    public static void setCurrHome(Admin.Mico mico, MijiaEvent.Reason reason) {
        HashMap<Admin.Mico, Location> hashMap;
        Location location;
        if (mico != null && (hashMap = micoLocationMap) != null && (location = hashMap.get(mico)) != null) {
            setCurrHome(location.home, reason);
            setCurrRoom(location.room, reason);
        }
    }

    public static void setCurrHome(Miot.Home home, MijiaEvent.Reason reason) {
        currHome = home;
        Object[] objArr = {"MijiaCacheManager setCurrHome home id %s currHomeId %s", home.id, currHomeId};
        if (!home.id.equals(currHomeId)) {
            currHomeId = home.id;
            cacheCurrHomeId();
        }
        jgc.O000000o().O00000o(new MijiaEvent.MijiaCurrHomeChanged(home.id, reason));
    }

    public static List<Miot.Room> getRooms(Miot.Home home) {
        HashMap<Miot.Home, List<Miot.Room>> hashMap = homeRooms;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(home);
    }

    public static String getCurrRoomNameCache() {
        String str = (String) Cache.get("mijia_current_room_name_cache", String.class);
        currRoomName = str;
        return str;
    }

    public static Miot.Room getCurrRoom() {
        return currRoom;
    }

    private static void cacheCurrRoomName() {
        Cache.put("mijia_current_room_name_cache", currRoomName);
    }

    public static void setCurrRoom(Miot.Room room, MijiaEvent.Reason reason) {
        if (room == null) {
            new Object[1][0] = "setCurrRoom room is null.";
            return;
        }
        if (currRoom != room) {
            currRoom = room;
        }
        Object[] objArr = {"MijiaCacheManager setCurrRoom room %s, currRoomName %s", room, currRoomName};
        if (!room.name.equals(currRoomName)) {
            currRoomName = room.name;
            cacheCurrRoomName();
        }
        jgc.O000000o().O00000o(new MijiaEvent.MijiaCurrRoomChanged(currRoomName, reason));
    }

    public static void clear() {
        homes = null;
        currHomeId = null;
        currHome = null;
        currRoomName = null;
        currRoom = null;
        homeRooms = null;
        micoLocationMap = null;
    }

    private static void clearCache() {
        Cache.delete("mijia_home_ids_cache");
        Cache.delete("mijia_current_home_id_cache");
        Cache.delete("mijia_current_room_name_cache");
    }

    public static void loadHomeData(Admin.Mico mico, Context context, MijiaEvent.Reason reason) {
        if (context != null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = sLastShowTime;
            sLastShowTime = currentTimeMillis;
            if (isLoading && currentTimeMillis - j >= 5000) {
                isLoading = false;
            }
            Object[] objArr = {"loadHomeData isLoading %s reason %s", Boolean.valueOf(isLoading), reason};
            if (!isLoading) {
                isLoading = true;
                SmartHomeRc4Manager.getInstance().getHomeInfo().observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(reason, context) {
                    /* class com.xiaomi.mico.setting.mijia.$$Lambda$MijiaCacheManager$lShws0rbaNFthIWy76WJN8FG84 */
                    private final /* synthetic */ MijiaEvent.Reason f$1;
                    private final /* synthetic */ Context f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void call(Object obj) {
                        MijiaCacheManager.lambda$loadHomeData$0(Admin.Mico.this, this.f$1, this.f$2, (String) obj);
                    }
                }, $$Lambda$MijiaCacheManager$hpdDe1sOLy7N70kwDF7cQFwttXw.INSTANCE);
            }
        }
    }

    static /* synthetic */ void lambda$loadHomeData$0(Admin.Mico mico, MijiaEvent.Reason reason, Context context, String str) {
        Location location;
        Miot.Home home;
        MijiaEvent.Reason reason2 = reason;
        String str2 = str;
        isLoading = false;
        Object[] objArr = {"loadHomeData isLoading %s", Boolean.valueOf(isLoading)};
        if (str2 == null) {
            Object[] objArr2 = {"MijiaCacheManager s null %s", str2};
            return;
        }
        Object[] objArr3 = {"MijiaCacheManager loadHomeData=%s", str2};
        Admin.Mico currentMico = mico == null ? MicoManager.getInstance().getCurrentMico() : mico;
        int i = 4;
        Object[] objArr4 = {"currentMico deviceId %s, miotDid %s, name %s, reason %s", currentMico.deviceID, currentMico.miotDID, currentMico.name, reason2};
        List<Admin.Mico> micoList = MicoManager.getInstance().getMicoList();
        Miot.HomeResult homeResult = (Miot.HomeResult) GsonUtil.getGsonInstance().fromJson(str2, Miot.HomeResult.class);
        if (homeResult.result != null && homeResult.result.homelist != null && homeResult.result.homelist.size() > 0) {
            clear();
            clearCache();
            HashMap<Admin.Mico, Location> hashMap = micoLocationMap;
            if (hashMap == null) {
                micoLocationMap = new HashMap<>();
            } else {
                hashMap.clear();
            }
            if (defaultRoomForUnknown == null) {
                Miot.Room room = new Miot.Room();
                defaultRoomForUnknown = room;
                room.name = ((Context) Objects.requireNonNull(context)).getResources().getString(R.string.mico_miot_default_room_name);
            }
            HashMap<Miot.Home, List<Miot.Room>> hashMap2 = homeRooms;
            if (hashMap2 == null) {
                homeRooms = new HashMap<>();
            } else {
                hashMap2.clear();
            }
            List<Miot.Home> list = homeResult.result.homelist;
            homes = list;
            for (Miot.Home next : list) {
                ArrayList arrayList = new ArrayList();
                if (next.dids != null) {
                    Miot.Room room2 = new Miot.Room();
                    room2.name = ((Context) Objects.requireNonNull(context)).getResources().getString(R.string.mico_miot_default_room_name);
                    arrayList.add(room2);
                }
                arrayList.addAll(next.roomlist);
                homeRooms.put(next, arrayList);
            }
            for (Admin.Mico next2 : micoList) {
                Object[] objArr5 = new Object[i];
                objArr5[0] = "miotDid %s, micoList deviceId %s, name %s ";
                objArr5[1] = next2.miotDID;
                objArr5[2] = next2.deviceID;
                objArr5[3] = next2.name;
                boolean z = false;
                for (Miot.Home next3 : homes) {
                    if (next3.dids != null) {
                        Iterator<String> it = next3.dids.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            if (next2.miotDID.equals(it.next())) {
                                Location location2 = new Location(next3, (Miot.Room) homeRooms.get(next3).get(0));
                                Object[] objArr6 = {"MijiaCacheManager mi %s home name %s", next2.name, next3.name};
                                micoLocationMap.put(next2, location2);
                                z = true;
                                break;
                            }
                        }
                    }
                    if (z) {
                        break;
                    }
                    if (next3.roomlist != null) {
                        for (Miot.Room next4 : next3.roomlist) {
                            if (next4.dids != null) {
                                Iterator<String> it2 = next4.dids.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    if (next2.miotDID.equals(it2.next())) {
                                        Location location3 = new Location(next3, next4);
                                        Object[] objArr7 = {"MijiaCacheManager mi %s room name %s", next2.name, next4.name};
                                        micoLocationMap.put(next2, location3);
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            if (z) {
                                break;
                            }
                        }
                    }
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    micoLocationMap.put(next2, null);
                }
                i = 4;
            }
            HashMap hashMap3 = new HashMap();
            for (Map.Entry next5 : micoLocationMap.entrySet()) {
                Admin.Mico mico2 = (Admin.Mico) next5.getKey();
                if (((Location) next5.getValue()) == null) {
                    if (!reason2.equals(MijiaEvent.Reason.INIT) || !mico2.equals(currentMico)) {
                        Iterator<Miot.Home> it3 = homes.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                home = null;
                                break;
                            }
                            home = it3.next();
                            if (home.id.equals("unknown")) {
                                break;
                            }
                        }
                        if (home == null) {
                            home = new Miot.Home();
                            home.id = "unknown";
                            home.name = context.getResources().getString(R.string.mico_unknown_home);
                            homes.add(home);
                        }
                        location = new Location(home, defaultRoomForUnknown);
                    } else {
                        location = new Location(homes.get(0), (Miot.Room) homeRooms.get(homes.get(0)).get(0));
                    }
                    hashMap3.put(mico2, location);
                    Object[] objArr8 = {"mico deviceId %s miotId %s name %s reason %s", mico2.deviceID, mico2.miotDID, mico2.name, reason2};
                }
            }
            for (Map.Entry entry : hashMap3.entrySet()) {
                Admin.Mico mico3 = (Admin.Mico) entry.getKey();
                micoLocationMap.remove(mico3);
                micoLocationMap.put(mico3, (Location) entry.getValue());
            }
            hashMap3.clear();
            Location location4 = micoLocationMap.get(currentMico);
            currHome = location4.home;
            currRoom = location4.room;
            setCurrHome(currHome, reason2);
            setCurrRoom(currRoom, reason2);
            Object[] objArr9 = {"currentMico deviceId %s, miotDid %s, name %s, home %s room %s reason %s", currentMico.deviceID, currentMico.miotDID, currentMico.name, currHome.name, currRoom.name, reason2};
        }
    }

    static /* synthetic */ void lambda$loadHomeData$1(Throwable th) {
        Object[] objArr = {"loadHomeData failed %s, message %s", th, th.getMessage()};
    }

    public static void setDeviceRoom(Admin.Mico mico, String str, String str2, boolean z, MijiaEvent.Reason reason) {
        if (mico != null && mico.deviceID.equalsIgnoreCase(mico.deviceID)) {
            String str3 = mico.miotDID;
            String str4 = TextUtils.isEmpty(str2) ? str : str2;
            Object[] objArr = {"MijiaCacheManager setDeviceRoom mico name %s, miotDid=%s roomid=%s", mico.name, str3, str4};
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                SmartHomeRc4Manager.getInstance().bindDeviceToRome(str4, str3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(z, str2, str, reason) {
                    /* class com.xiaomi.mico.setting.mijia.$$Lambda$MijiaCacheManager$o4lr9AhWtOLK6G45yjn8cW3HYT0 */
                    private final /* synthetic */ boolean f$0;
                    private final /* synthetic */ String f$1;
                    private final /* synthetic */ String f$2;
                    private final /* synthetic */ MijiaEvent.Reason f$3;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void call(Object obj) {
                        MijiaCacheManager.lambda$setDeviceRoom$2(this.f$0, this.f$1, this.f$2, this.f$3, (String) obj);
                    }
                }, $$Lambda$VwEsfx9iAZ1xxqB42DOjLprjGzg.INSTANCE);
            }
        }
    }

    static /* synthetic */ void lambda$setDeviceRoom$2(boolean z, String str, String str2, MijiaEvent.Reason reason, String str3) {
        if (str3 != null) {
            Object[] objArr = {"MijiaCacheManager setDeviceRoom setHomeInfo=%s", str3};
            if (((BaseResponse) new Gson().fromJson(str3, BaseResponse.class)).code == 0) {
                if (z) {
                    ToastUtil.showToast((int) R.string.mico_common_save_success);
                }
                if (TextUtils.isEmpty(str)) {
                    jgc.O000000o().O00000o(new MijiaEvent.MijiaHomeInfoChanged(str2, currRoomName, reason));
                } else {
                    jgc.O000000o().O00000o(new MijiaEvent.MijiaHomeInfoChanged(currHomeId, str2, reason));
                }
            } else if (z) {
                ToastUtil.showToast((int) R.string.common_failed);
            }
        }
    }

    public static Observable<String> setDeviceRoom(String str, String str2, String str3) {
        Admin.Mico micoByDeviceId = MicoManager.getInstance().getMicoByDeviceId(str);
        if (micoByDeviceId == null || !str.equalsIgnoreCase(micoByDeviceId.deviceID)) {
            return Observable.just(null);
        }
        if (!TextUtils.isEmpty(str3)) {
            str2 = str3;
        }
        Object[] objArr = {"MijiaCacheManager observable setDeviceRoom miotDid=%s roomid=%s", micoByDeviceId.miotDID, str2};
        if (TextUtils.isEmpty(micoByDeviceId.miotDID) || TextUtils.isEmpty(str2)) {
            return Observable.just(null);
        }
        return SmartHomeRc4Manager.getInstance().bindDeviceToRome(str2, micoByDeviceId.miotDID);
    }

    public static void addRoom(Admin.Mico mico, Context context, MijiaEvent.Reason reason) {
        if (mico == null || getCurrHome().id.equals("unknown")) {
            ToastUtil.showToast((int) R.string.common_failed);
            return;
        }
        List<Miot.Room> rooms = getRooms(getCurrHome());
        ArrayList arrayList = new ArrayList();
        for (Miot.Room room : rooms) {
            arrayList.add(room.name);
        }
        new InputViewDialog(context).setTitle((int) R.string.mico_add_room).setLengthUnit(0).setMinInputLength(0).setMaxInputLength(40).setShowBelowHint(true).setSpecialCharIllegal(true).setBelowHintHeader(context.getResources().getString(R.string.mico_room_name)).setTextToCompare(arrayList).setListener(new InputViewDialog.Listener(reason) {
            /* class com.xiaomi.mico.setting.mijia.$$Lambda$MijiaCacheManager$FWYGx7EPxeZIS8w6oQg7nNbN36o */
            private final /* synthetic */ MijiaEvent.Reason f$1;

            {
                this.f$1 = r2;
            }

            public final void onFinish(String str) {
                MijiaCacheManager.doAddRoom(Admin.Mico.this, str, this.f$1);
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public static void doAddRoom(Admin.Mico mico, String str, MijiaEvent.Reason reason) {
        Object[] objArr = {"mico name %s, did %s", mico.name, mico.miotDID};
        SmartHomeRc4Manager.getInstance().addRoom(str, getCurrHomeIdCache(), new String[]{mico.miotDID}).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1(str, reason) {
            /* class com.xiaomi.mico.setting.mijia.$$Lambda$MijiaCacheManager$hUMO86vYVkvkQ9GlimjTKsSSErY */
            private final /* synthetic */ String f$0;
            private final /* synthetic */ MijiaEvent.Reason f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                MijiaCacheManager.lambda$doAddRoom$4(this.f$0, this.f$1, (String) obj);
            }
        }, $$Lambda$VwEsfx9iAZ1xxqB42DOjLprjGzg.INSTANCE);
    }

    static /* synthetic */ void lambda$doAddRoom$4(String str, MijiaEvent.Reason reason, String str2) {
        if (str2 != null) {
            BaseResponse baseResponse = (BaseResponse) new Gson().fromJson(str2, BaseResponse.class);
            if (baseResponse.code == 0) {
                ToastUtil.showToast((int) R.string.mico_common_save_success);
                jgc.O000000o().O00000o(new MijiaEvent.MijiaHomeInfoChanged(currHomeId, str, reason));
                return;
            }
            Object[] objArr = {"MijiaCacheManager response failed %s", baseResponse.message};
            ToastUtil.showToast((int) R.string.common_failed);
        }
    }
}
