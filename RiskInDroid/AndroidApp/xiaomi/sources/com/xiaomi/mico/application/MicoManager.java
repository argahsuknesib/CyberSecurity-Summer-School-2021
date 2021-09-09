package com.xiaomi.mico.application;

import _m_j.fno;
import _m_j.gsy;
import _m_j.jgc;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.gson.reflect.TypeToken;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.IncompleteApiListener;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.api.WrappedIncompleteApiListener;
import com.xiaomi.mico.api.model.Admin;
import com.xiaomi.mico.api.model.MultiRoomData;
import com.xiaomi.mico.api.model.StereoData;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.common.application.Hardware;
import com.xiaomi.mico.common.application.MicoCapability;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.GsonUtil;
import com.xiaomi.mico.common.util.ObjectStoreHelper;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.player.PlayerListManager;
import com.xiaomi.mico.music.player.PlayerManager;
import com.xiaomi.mico.setting.mijia.MijiaCacheManager;
import com.xiaomi.mico.setting.mijia.event.MijiaEvent;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public class MicoManager {
    private static final Admin.Mico FAKED_MICO;
    private static volatile MicoManager sInstance;
    public boolean firstGetDeviceList = true;
    private Subscription mCheckSubscription;
    public long mCheckTimestamp = 0;
    public Admin.Mico mCurrentMico;
    public List<Admin.Mico> mMicoList;
    private volatile MultiRoomData.MultiRoomGroup multiRoomGroup;
    private List<StereoData.StereoGroup> stereoGroupList;

    public static MicoManager getInstance() {
        if (sInstance == null) {
            synchronized (MicoManager.class) {
                if (sInstance == null) {
                    sInstance = new MicoManager();
                }
            }
        }
        return sInstance;
    }

    private MicoManager() {
    }

    static {
        Admin.Mico mico = new Admin.Mico();
        FAKED_MICO = mico;
        mico.deviceID = "";
        Admin.Mico mico2 = FAKED_MICO;
        mico2.serialNumber = "";
        mico2.hardware = "S12";
    }

    public void loadPersistentData() {
        String string = getSP().getString("mico_list", null);
        if (!TextUtils.isEmpty(string)) {
            this.mMicoList = handleMicoSyncWithMijia((List) ObjectStoreHelper.decode(string));
            String string2 = getSP().getString("last_mico_id", null);
            if (!TextUtils.isEmpty(string2)) {
                for (Admin.Mico next : this.mMicoList) {
                    if (string2.equals(next.serialNumber)) {
                        this.mCurrentMico = next;
                        return;
                    }
                }
            }
        }
    }

    public List<Admin.Mico> getMicoList() {
        return this.mMicoList;
    }

    public List<Admin.Mico> getMicoOnlineList() {
        ArrayList arrayList = new ArrayList();
        for (Admin.Mico next : this.mMicoList) {
            if (next.isOnline()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public Admin.Mico getMicoByDeviceId(String str) {
        List<Admin.Mico> list = this.mMicoList;
        if (list == null) {
            return null;
        }
        for (Admin.Mico next : list) {
            if (next.deviceID.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public StereoData.StereoGroup getStereoGroup(String str) {
        String stereoGroupJson = getStereoGroupJson();
        if (!TextUtils.isEmpty(stereoGroupJson)) {
            List<StereoData.StereoGroup> list = (List) GsonUtil.getGsonInstance().fromJson(stereoGroupJson, new TypeToken<List<StereoData.StereoGroup>>() {
                /* class com.xiaomi.mico.application.MicoManager.AnonymousClass1 */
            }.getType());
            if (ContainerUtil.hasData(list)) {
                for (StereoData.StereoGroup stereoGroup : list) {
                    if (stereoGroup.groupId.equals(str)) {
                        return stereoGroup;
                    }
                }
            }
        }
        return null;
    }

    public void setStereoGroup(List<StereoData.StereoGroup> list) {
        this.stereoGroupList = list;
        if (list != null) {
            for (StereoData.StereoGroup next : list) {
                saveStereoServerDeviceId(next.groupId, !TextUtils.isEmpty(next.server) ? next.server : next.leftDeviceId);
            }
        }
    }

    public void clearStereoService(String str) {
        clearStereoServerDeviceId(str);
    }

    public MultiRoomData.MultiRoomGroup getMultiRoomGroup() {
        return this.multiRoomGroup;
    }

    public void setMultiRoomGroup(MultiRoomData.MultiRoomGroup multiRoomGroup2) {
        this.multiRoomGroup = multiRoomGroup2;
    }

    public Admin.Mico getCurrentMico() {
        Admin.Mico mico = this.mCurrentMico;
        return mico != null ? mico : FAKED_MICO;
    }

    public String getCurrentMicoType() {
        Admin.Mico mico = this.mCurrentMico;
        return mico != null ? mico.getHardwareType().getName().toLowerCase() : "unknown";
    }

    public boolean isCurrentMicoSupportAvout() {
        return "LX01".equalsIgnoreCase(getInstance().getCurrentMicoType());
    }

    public boolean isCurrentMicoSupportIR() {
        return Hardware.LX05A.getName().equalsIgnoreCase(getInstance().getCurrentMicoType()) || Hardware.LX06.getName().equalsIgnoreCase(getInstance().getCurrentMicoType());
    }

    public boolean limitingPlayMusicSize() {
        return Hardware.LX05.getName().equalsIgnoreCase(getInstance().getCurrentMicoType()) || Hardware.L07A.getName().equalsIgnoreCase(getInstance().getCurrentMicoType());
    }

    public boolean hasValidMico() {
        return getCurrentMico().isValid();
    }

    public String getCurrentMicoID() {
        return getCurrentMico().deviceID;
    }

    public String getCurrentMicoSN() {
        return getCurrentMico().serialNumber;
    }

    public String getCurrentMicoName() {
        return getCurrentMico().getDisplayName();
    }

    public boolean currentMicoIsAiProtocolV3() {
        return getInstance().getCurrentMico().hasCapability(MicoCapability.AI_PROTOCOL_3_0);
    }

    public boolean currentPlayingMicoIsAiProtocolV3() {
        Admin.Mico micoByDeviceId;
        String queryDeviceId = PlayerManager.getInstance().getQueryDeviceId();
        if (queryDeviceId == null || (micoByDeviceId = getInstance().getMicoByDeviceId(queryDeviceId)) == null) {
            return false;
        }
        return micoByDeviceId.hasCapability(MicoCapability.AI_PROTOCOL_3_0);
    }

    public boolean currentMicoHasCapabilityMeshConflictCheck() {
        return getInstance().getCurrentMico().hasCapability(MicoCapability.MESH_CONFLICT_CHECK);
    }

    public void reset() {
        List<Admin.Mico> list = this.mMicoList;
        if (list != null && !list.isEmpty()) {
            this.mMicoList.clear();
            persistMicoList();
            updateCurrentMico(null);
        }
        this.mCheckTimestamp = 0;
    }

    public boolean selectMico(String str) {
        List<Admin.Mico> list = this.mMicoList;
        if (list == null) {
            return false;
        }
        for (Admin.Mico next : list) {
            if (next.deviceID.equals(str)) {
                Admin.Mico mico = this.mCurrentMico;
                if (mico == null) {
                    updateCurrentMico(next);
                    return true;
                } else if (mico.deviceID.equals(next.deviceID)) {
                    return true;
                } else {
                    updateCurrentMico(next);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean selectMico(int i) {
        List<Admin.Mico> list = this.mMicoList;
        if (list == null || i >= list.size()) {
            return false;
        }
        Admin.Mico mico = this.mCurrentMico;
        if (mico != null && mico.deviceID.equals(this.mMicoList.get(i).deviceID)) {
            return false;
        }
        updateCurrentMico(this.mMicoList.get(i));
        return true;
    }

    public boolean selectMicoById(String str) {
        for (Admin.Mico next : this.mMicoList) {
            if (next.deviceID.equals(str)) {
                Object[] objArr = {"cselectMicoById  = %s", str};
                updateCurrentMico(next);
                return true;
            }
        }
        return false;
    }

    public boolean selectMicoByMiotDID(String str) {
        for (Admin.Mico next : this.mMicoList) {
            if (str.equals(next.miotDID)) {
                updateCurrentMico(next);
                return true;
            }
        }
        return false;
    }

    public Admin.Mico getMicoByMiotDID(String str) {
        List<Admin.Mico> list = this.mMicoList;
        if (list == null) {
            return null;
        }
        for (Admin.Mico next : list) {
            if (str.equals(next.miotDID)) {
                return next;
            }
        }
        return null;
    }

    public void startCheck() {
        this.mCheckSubscription = checkObservable().observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    public void stopCheck() {
        Subscription subscription = this.mCheckSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mCheckSubscription.unsubscribe();
            this.mCheckSubscription = null;
        }
    }

    private Observable<Void> checkObservable() {
        return Observable.create(new Observable.OnSubscribe<Void>() {
            /* class com.xiaomi.mico.application.MicoManager.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super Void>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super Void> subscriber) {
                if (System.currentTimeMillis() - MicoManager.this.mCheckTimestamp >= DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS) {
                    MicoManager.this.getMicoList(new IncompleteApiListener() {
                        /* class com.xiaomi.mico.application.MicoManager.AnonymousClass2.AnonymousClass1 */

                        public void onSuccess() {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onNext(null);
                                subscriber.onCompleted();
                            }
                        }

                        public void onFailure(ApiError apiError) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onError(apiError.toThrowable());
                            }
                        }
                    }, false);
                } else if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(null);
                    subscriber.onCompleted();
                }
            }
        }).retryWhen(new RxUtil.RetryWithDelay(30000)).repeatWhen(new RxUtil.RepeatWithDelay(30000));
    }

    public ApiRequest getMicoList(IncompleteApiListener incompleteApiListener, final boolean z) {
        return ApiHelper.getDeviceList(new WrappedIncompleteApiListener<List<Admin.Mico>>(incompleteApiListener) {
            /* class com.xiaomi.mico.application.MicoManager.AnonymousClass3 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Admin.Mico>) ((List) obj));
            }

            public void onSuccess(List<Admin.Mico> list) {
                MicoManager.this.mCheckTimestamp = System.currentTimeMillis();
                if (list != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "Mico-Api", "original_micoList" + list.toString());
                }
                MicoManager micoManager = MicoManager.this;
                micoManager.mMicoList = micoManager.handleMicoSyncWithMijia(list);
                if (MicoManager.this.mMicoList != null) {
                    LogType logType2 = LogType.GENERAL;
                    gsy.O00000Oo(logType2, "Mico-Api", "syncWithMijia_micoList" + MicoManager.this.mMicoList.toString());
                }
                MicoManager.this.persistMicoList();
                MicoManager.this.getCurrentMico();
                Admin.Mico mico = MicoManager.this.mCurrentMico;
                if (MicoManager.this.mMicoList.isEmpty()) {
                    MicoManager.this.updateCurrentMico(null);
                    if (mico != null) {
                        jgc.O000000o().O00000o(new MicoEvent.MicoAutoSwitched(MicoEvent.MicoAutoSwitched.Reason.LACK_OF_PERMISSION, mico, null));
                    }
                } else if (MicoManager.this.mCurrentMico == null || !MicoManager.this.mMicoList.contains(MicoManager.this.mCurrentMico)) {
                    MicoManager micoManager2 = MicoManager.this;
                    micoManager2.updateCurrentMico(micoManager2.autoSelectMico());
                    if (mico != null) {
                        jgc.O000000o().O00000o(new MicoEvent.MicoAutoSwitched(MicoEvent.MicoAutoSwitched.Reason.LACK_OF_PERMISSION, mico, MicoManager.this.mCurrentMico));
                    }
                } else {
                    Admin.Mico autoSelectMico = MicoManager.this.autoSelectMico();
                    if (!z || MicoManager.this.mCurrentMico.isOnline() || MicoManager.this.mCurrentMico.equals(autoSelectMico) || !autoSelectMico.isOnline()) {
                        int indexOf = MicoManager.this.mMicoList.indexOf(MicoManager.this.mCurrentMico);
                        MicoManager micoManager3 = MicoManager.this;
                        micoManager3.mCurrentMico = MicoManager.this.mMicoList.get(indexOf);
                        micoManager3.updateQueryDeviceId(micoManager3.mCurrentMico);
                        jgc.O000000o().O00000o(new MicoEvent.CurrentMicoInfoUpdate());
                    } else {
                        MicoManager.this.updateCurrentMico(autoSelectMico);
                    }
                }
                super.onSuccess((Object) list);
                if (MicoManager.this.firstGetDeviceList) {
                    jgc.O000000o().O00000o(new PlayerListManager.ForceFreshPlayingDataEvent());
                    LoginManager.getInstance().changeDeviceIdCookie();
                    MicoManager.this.firstGetDeviceList = false;
                }
            }

            public void onFailure(ApiError apiError) {
                super.onFailure(apiError);
                gsy.O00000Oo(12000, "12000.1.1", "remote fail");
            }
        });
    }

    public List<Admin.Mico> handleMicoSyncWithMijia(List<Admin.Mico> list) {
        Device O000000o2;
        PluginDeviceInfo pluginInfo;
        ArrayList arrayList = new ArrayList();
        for (Admin.Mico next : list) {
            if (!(TextUtils.isEmpty(next.miotDID) || (O000000o2 = fno.O000000o().O000000o(next.miotDID)) == null || (pluginInfo = PluginDeviceManager.instance.getPluginInfo(O000000o2.model)) == null || pluginInfo.O0000oo0 == 15)) {
                if (!TextUtils.equals(next.name, O000000o2.getName())) {
                    next.name = O000000o2.getName();
                }
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ApiRequest bindMico(String str, String str2, String str3, IncompleteApiListener incompleteApiListener) {
        return ApiHelper.bindDevice(str, str2, str3, new WrappedIncompleteApiListener<List<Admin.Mico>>(incompleteApiListener) {
            /* class com.xiaomi.mico.application.MicoManager.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<Admin.Mico>) ((List) obj));
            }

            public void onSuccess(List<Admin.Mico> list) {
                MicoManager.this.mCheckTimestamp = System.currentTimeMillis();
                MicoManager micoManager = MicoManager.this;
                micoManager.mMicoList = micoManager.handleMicoSyncWithMijia(list);
                MicoManager.this.persistMicoList();
                Admin.Mico mico = null;
                if (MicoManager.this.mMicoList.isEmpty()) {
                    MicoManager.this.updateCurrentMico(null);
                } else {
                    Iterator<Admin.Mico> it = MicoManager.this.mMicoList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Admin.Mico next = it.next();
                        if (next.current) {
                            next.expectOnlineAfterBind();
                            mico = next;
                            break;
                        }
                    }
                    if (mico != null) {
                        MicoManager.this.updateCurrentMico(mico);
                    } else if (MicoManager.this.mCurrentMico == null) {
                        MicoManager micoManager2 = MicoManager.this;
                        micoManager2.updateCurrentMico(micoManager2.mMicoList.get(0));
                    }
                }
                super.onSuccess((Object) list);
            }
        });
    }

    public ApiRequest unbindCurrentMico(IncompleteApiListener incompleteApiListener) {
        Admin.Mico mico = this.mCurrentMico;
        if (mico == null || !mico.isValid()) {
            new Object[1][0] = "Current Mico is null or invalid...";
            return null;
        }
        final String str = this.mCurrentMico.deviceID;
        return ApiHelper.unbindDevice(str, new WrappedIncompleteApiListener<List<String>>(incompleteApiListener) {
            /* class com.xiaomi.mico.application.MicoManager.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<String>) ((List) obj));
            }

            public void onSuccess(List<String> list) {
                boolean z;
                boolean z2;
                Iterator<Admin.Mico> it = MicoManager.this.mMicoList.iterator();
                while (true) {
                    z = true;
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    }
                    Admin.Mico next = it.next();
                    if (next.deviceID.equals(str)) {
                        MicoManager.this.mMicoList.remove(next);
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    MicoManager.this.persistMicoList();
                }
                if (MicoManager.this.mMicoList.isEmpty()) {
                    MicoManager.this.updateCurrentMico(null);
                } else if (MicoManager.this.mCurrentMico == null || !MicoManager.this.mCurrentMico.deviceID.equals(str)) {
                    z = false;
                } else {
                    MicoManager micoManager = MicoManager.this;
                    micoManager.updateCurrentMico(micoManager.mMicoList.get(0));
                }
                if (z) {
                    jgc.O000000o().O00000o(new MicoEvent.MicoAutoSwitched(MicoEvent.MicoAutoSwitched.Reason.UNBIND, MicoManager.this.mCurrentMico));
                }
                super.onSuccess((Object) list);
            }
        });
    }

    public ApiRequest renameCurrentMico(final String str, IncompleteApiListener incompleteApiListener) {
        Admin.Mico mico = this.mCurrentMico;
        if (mico == null || !mico.isValid()) {
            new Object[1][0] = "Current Mico is null or invalid...";
            return null;
        }
        final String str2 = this.mCurrentMico.deviceID;
        return ApiHelper.renameDevice(str2, str, new WrappedIncompleteApiListener<String>(incompleteApiListener) {
            /* class com.xiaomi.mico.application.MicoManager.AnonymousClass6 */

            public void onSuccess(String str) {
                boolean z;
                Iterator<Admin.Mico> it = MicoManager.this.mMicoList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    Admin.Mico next = it.next();
                    if (next.deviceID.equals(str2)) {
                        next.name = str;
                        z = true;
                        break;
                    }
                }
                if (z) {
                    MicoManager.this.persistMicoList();
                }
                if (MicoManager.this.mCurrentMico != null && MicoManager.this.mCurrentMico.deviceID.equals(str2)) {
                    jgc.O000000o().O00000o(new MicoEvent.CurrentMicoInfoUpdate());
                }
                super.onSuccess((Object) str);
            }
        });
    }

    private SharedPreferences getSP() {
        return CommonApplication.getAppContext().getSharedPreferences("Mico", 0);
    }

    public void persistMicoList() {
        getSP().edit().putString("mico_list", ObjectStoreHelper.encode(this.mMicoList)).apply();
    }

    public void clearStereoData(boolean z) {
        SharedPreferences.Editor edit = getSP().edit();
        edit.remove("stereo_group");
        edit.remove("stereo_server_id");
        if (z) {
            edit.remove("multi_room");
        }
        edit.commit();
    }

    public void saveMultiRoomJson(String str) {
        getSP().edit().putString("multi_room", str).apply();
    }

    public String getMultiRoomJson() {
        return getSP().getString("multi_room", "");
    }

    public void clearMultiRoomJson() {
        getSP().edit().remove("multi_room").apply();
    }

    public void saveStereoGroupJson(String str) {
        getSP().edit().putString("stereo_group", str).apply();
    }

    public String getStereoGroupJson() {
        return getSP().getString("stereo_group", "");
    }

    private void saveStereoServerDeviceId(String str, String str2) {
        getSP().edit().putString("stereo_server_id_".concat(str), str2).apply();
    }

    public String getStereoServerDeviceId(String str) {
        return getSP().getString("stereo_server_id_".concat(str), "");
    }

    private void clearStereoServerDeviceId(String str) {
        getSP().edit().remove("stereo_server_id_".concat(str)).apply();
    }

    public Admin.Mico autoSelectMico() {
        List<Admin.Mico> list = this.mMicoList;
        if (list == null || list.isEmpty()) {
            return FAKED_MICO;
        }
        for (Admin.Mico next : this.mMicoList) {
            if (next.isOnline()) {
                return next;
            }
        }
        return this.mMicoList.get(0);
    }

    public void updateCurrentMico(Admin.Mico mico) {
        Admin.Mico mico2;
        boolean z = (this.mCurrentMico == null && mico != null) || (this.mCurrentMico != null && mico == null) || ((mico2 = this.mCurrentMico) != null && !mico2.equals(mico));
        this.multiRoomGroup = (MultiRoomData.MultiRoomGroup) GsonUtil.getGsonInstance().fromJson(getMultiRoomJson(), MultiRoomData.MultiRoomGroup.class);
        updateQueryDeviceId(mico);
        if (z) {
            this.mCurrentMico = mico;
            Admin.Mico mico3 = this.mCurrentMico;
            getSP().edit().putString("last_mico_id", mico3 != null ? mico3.serialNumber : "").apply();
            if (this.mCurrentMico != null) {
                MijiaCacheManager.setCurrHome(mico, MijiaEvent.Reason.MICO_MANAGER);
                if (TextUtils.isEmpty("")) {
                    PlayerManager.getInstance().setQueryDeviceId(this.mCurrentMico.deviceID);
                }
                jgc.O000000o().O00000o(new MicoEvent.CurrentMicoChanged(""));
                LoginManager.getInstance().changeDeviceIdCookie();
                Object[] objArr = {"MicoManager updateCurrentMico changed to %s %s %s", this.mCurrentMico.name, this.mCurrentMico.hardware, this.mCurrentMico.deviceID};
                return;
            }
            PlayerManager.getInstance().setQueryDeviceId("");
        }
    }

    public void clearMicoList() {
        List<Admin.Mico> list = this.mMicoList;
        if (list != null) {
            list.clear();
            persistMicoList();
        }
    }

    public void setMicoDeviceName(String str, String str2) {
        boolean z;
        Iterator<Admin.Mico> it = this.mMicoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Admin.Mico next = it.next();
            if (next.deviceID.equals(str)) {
                next.name = str2;
                z = true;
                break;
            }
        }
        if (z) {
            persistMicoList();
        }
        Admin.Mico mico = this.mCurrentMico;
        if (mico != null && mico.deviceID.equals(str)) {
            jgc.O000000o().O00000o(new MicoEvent.CurrentMicoInfoUpdate());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        if (r1 == null) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0085, code lost:
        if (r1.isOffline() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008d, code lost:
        if (r2.leftDeviceId.equalsIgnoreCase(r3) == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008f, code lost:
        r0 = r2.rightDeviceId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0097, code lost:
        if (r2.rightDeviceId.equalsIgnoreCase(r3) == false) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0099, code lost:
        r0 = r2.leftDeviceId;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        r0 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009d, code lost:
        com.xiaomi.mico.music.player.PlayerManager.getInstance().setQueryDeviceId(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a4 A[EDGE_INSN: B:41:0x00a4->B:34:0x00a4 ?: BREAK  , SYNTHETIC] */
    public void updateQueryDeviceId(Admin.Mico mico) {
        if (mico != null) {
            String str = null;
            if (this.multiRoomGroup != null) {
                String str2 = this.multiRoomGroup.server;
                Iterator<MultiRoomData.MultiRoomMember> it = this.multiRoomGroup.members.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().deviceId.equalsIgnoreCase(mico.deviceID)) {
                            PlayerManager.getInstance().setQueryDeviceId(str2);
                            str = str2;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            List<StereoData.StereoGroup> list = this.stereoGroupList;
            if (list != null) {
                Iterator<StereoData.StereoGroup> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        StereoData.StereoGroup next = it2.next();
                        String str3 = next.server;
                        if (TextUtils.isEmpty(str3)) {
                            str3 = getInstance().getStereoServerDeviceId(next.groupId);
                        }
                        if (next.leftDeviceId.equalsIgnoreCase(mico.deviceID) || next.rightDeviceId.equalsIgnoreCase(mico.deviceID)) {
                            Object[] objArr = {"MicoManager getMicoList 匹配到serverId %s", str3};
                            Admin.Mico micoByDeviceId = getInstance().getMicoByDeviceId(str3);
                        }
                        if (!it2.hasNext()) {
                            break;
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str)) {
                PlayerManager.getInstance().setQueryDeviceId(mico.deviceID);
            }
        }
    }
}
