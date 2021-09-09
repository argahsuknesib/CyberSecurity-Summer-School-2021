package com.xiaomi.smarthome.framework.plugin;

import _m_j.cmf;
import _m_j.cmi;
import _m_j.cml;
import _m_j.cmy;
import _m_j.cnd;
import _m_j.eyv;
import _m_j.eyw;
import _m_j.ezm;
import _m_j.ezo;
import _m_j.faw;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fbv;
import _m_j.fbx;
import _m_j.fcg;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fob;
import _m_j.fpo;
import _m_j.fqu;
import _m_j.fqv;
import _m_j.fqw;
import _m_j.frd;
import _m_j.fre;
import _m_j.frg;
import _m_j.frh;
import _m_j.fsl;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.fte;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.ftz;
import _m_j.fua;
import _m_j.fue;
import _m_j.fuh;
import _m_j.fuo;
import _m_j.fuy;
import _m_j.fwk;
import _m_j.fxk;
import _m_j.fyc;
import _m_j.gbu;
import _m_j.gfr;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.gnk;
import _m_j.gog;
import _m_j.goq;
import _m_j.gor;
import _m_j.gph;
import _m_j.gpp;
import _m_j.gpv;
import _m_j.gqb;
import _m_j.grr;
import _m_j.grv;
import _m_j.grw;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import _m_j.gtf;
import _m_j.gty;
import _m_j.gwe;
import _m_j.gyl;
import _m_j.hdi;
import _m_j.hjp;
import _m_j.hmq;
import _m_j.hny;
import _m_j.hor;
import _m_j.hsk;
import _m_j.hsl;
import _m_j.htv;
import _m_j.htw;
import _m_j.hxi;
import _m_j.hys;
import _m_j.hyv;
import _m_j.ibh;
import _m_j.ibm;
import _m_j.inc;
import _m_j.ind;
import _m_j.inh;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.WritableArray;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.miot.spec.SpecManager;
import com.xiaomi.router.miio.miioplugin.DeviceStatus;
import com.xiaomi.router.miio.miioplugin.DeviceTagInfo;
import com.xiaomi.router.miio.miioplugin.ILocationCallback;
import com.xiaomi.router.miio.miioplugin.IPluginCallback;
import com.xiaomi.router.miio.miioplugin.IPluginCallback2;
import com.xiaomi.router.miio.miioplugin.IPluginCallback3;
import com.xiaomi.router.miio.miioplugin.IPluginCallbackDeviceList;
import com.xiaomi.router.miio.miioplugin.IPluginCallbackRoomStatus;
import com.xiaomi.router.miio.miioplugin.IPluginCallbackUserInfo;
import com.xiaomi.router.miio.miioplugin.IPluginRequest;
import com.xiaomi.router.miio.miioplugin.RoomStatus;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.ad.api.IAdCallback;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.BleMeshDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.device.api.IBleCallback;
import com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback;
import com.xiaomi.smarthome.device.api.ISceneCallback;
import com.xiaomi.smarthome.device.api.ISceneInfoCallback;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.UserInfo;
import com.xiaomi.smarthome.device.bluetooth.BleGatewayManager;
import com.xiaomi.smarthome.device.bluetooth.MediaButtonReceiver;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.PluginRuntimeManager;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.navigate.UrlResolver;
import com.xiaomi.smarthome.framework.plugin.PluginService;
import com.xiaomi.smarthome.framework.plugin.mpk.MpkPluginApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.smarthome.plugin.DeviceModelManager;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import okhttp3.Call;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f8054O000000o = new Handler();
    private final IPluginRequest.Stub O00000Oo = new IPluginRequest.Stub() {
        /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1 */
        private String mMediaButtonModel;
        private ComponentName mMediaComponent;

        public int getApiLevel() throws RemoteException {
            return 111;
        }

        public boolean isNotificationBarOpBtnEnabled(String str, String str2) throws RemoteException {
            return false;
        }

        public void recordCalculateEvent(String str, String str2, long j) throws RemoteException {
        }

        public void recordCountEvent(String str, String str2) throws RemoteException {
        }

        public void recordNumericPropertyEvent(String str, String str2, long j) throws RemoteException {
        }

        public void recordStringPropertyEvent(String str, String str2, String str3) throws RemoteException {
        }

        public void updateDeviceStatus(final DeviceStatus deviceStatus, final IPluginCallback iPluginCallback) throws RemoteException {
            for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                final Device device = (Device) value.getValue();
                if (device.did != null && device.did.equalsIgnoreCase(deviceStatus.f6611O000000o)) {
                    CommonApplication.getGlobalHandler().post(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            gwe.O000000o();
                            gwe.O000000o(device, deviceStatus.O00000Oo, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    PluginService.O000000o(iPluginCallback, fso.f17063O000000o, fso.O00000Oo);
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    PluginService.O000000o(iPluginCallback, null);
                                }
                            });
                        }
                    });
                }
            }
        }

        public void getDeviceStatus(String str, DeviceStatus deviceStatus) throws RemoteException {
            Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 != null) {
                copyDevicsStatus(deviceStatus, O00000o0);
            }
        }

        public void copyDevicsStatus(DeviceStatus deviceStatus, Device device) {
            deviceStatus.f6611O000000o = device.did;
            deviceStatus.O00000Oo = device.name;
            deviceStatus.O00000o0 = device.mac;
            deviceStatus.O00000o = device.model;
            deviceStatus.O00000oo = device.ip;
            String str = "";
            deviceStatus.O0000O0o = device.parentId != null ? device.parentId : str;
            if (device.parentModel != null) {
                str = device.parentModel;
            }
            deviceStatus.O0000OOo = str;
            deviceStatus.O0000Oo = device.isShared() ? 1 : 0;
            deviceStatus.O0000Oo0 = device.isOwner() ? 1 : 0;
            deviceStatus.O00000oO = device.extra;
            deviceStatus.O0000OoO = device.token;
            deviceStatus.O0000Ooo = device.userId;
            deviceStatus.O0000o00 = device.location != null ? device.location.ordinal() : 0;
            deviceStatus.O0000o0 = device.latitude;
            deviceStatus.O0000o0O = device.longitude;
            deviceStatus.O0000o0o = device.bssid;
            deviceStatus.O0000o = device.lastModified;
            deviceStatus.O0000oO0 = device.pid;
            deviceStatus.O0000oO = device.rssi;
            deviceStatus.O0000oOO = device.isOnline;
            deviceStatus.O0000oOo = device.resetFlag;
            deviceStatus.O0000oo0 = device.ssid;
            deviceStatus.O0000oo = device.ownerName;
            deviceStatus.O0000ooO = device.ownerId;
            deviceStatus.O0000ooo = device.propInfo;
            deviceStatus.O00oOooO = device.version;
            deviceStatus.O00oOooo.clear();
            deviceStatus.O00oOooo.putAll(device.property);
            deviceStatus.O00000oO = device.extra;
            deviceStatus.O000O00o = device.showMode;
            deviceStatus.O000O0Oo = device.event;
            deviceStatus.O00oOoOo = device.permitLevel;
            deviceStatus.O000O0o0 = device.isSetPinCode;
            deviceStatus.O000OO00 = device.freqFlag;
            deviceStatus.O000OO0o = device.comFlag;
            deviceStatus.O000O0oO = device.orderTimeJString;
        }

        public List<DeviceStatus> getDeviceList() throws RemoteException {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Device> value : fno.O000000o().O00000oO().entrySet()) {
                DeviceStatus deviceStatus = new DeviceStatus();
                copyDevicsStatus(deviceStatus, (Device) value.getValue());
                arrayList.add(deviceStatus);
            }
            return arrayList;
        }

        public List<DeviceStatus> getDeviceListV2(List<String> list) throws RemoteException {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (Map.Entry<String, Device> value : fno.O000000o().O00000oO().entrySet()) {
                    Device device = (Device) value.getValue();
                    if (!TextUtils.isEmpty(device.model)) {
                        Iterator<String> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (!TextUtils.isEmpty(next) && device.model.equalsIgnoreCase(next)) {
                                DeviceStatus deviceStatus = new DeviceStatus();
                                copyDevicsStatus(deviceStatus, device);
                                arrayList.add(deviceStatus);
                                break;
                            }
                        }
                    }
                }
            }
            return arrayList;
        }

        public List<RoomStatus> getRoomAll() throws RemoteException {
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 == null) {
                return Collections.emptyList();
            }
            List<Room> roomList = O0000Oo0.getRoomList();
            if (roomList == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Room next : roomList) {
                if (next != null) {
                    RoomStatus roomStatus = new RoomStatus();
                    roomStatus.f6613O000000o = next.getBssid();
                    roomStatus.O00000Oo = next.getDesc();
                    roomStatus.O0000O0o = next.getDids();
                    roomStatus.O00000o0 = next.getId();
                    roomStatus.O00000o = next.getName();
                    roomStatus.O0000OOo = next.getIcon();
                    roomStatus.O00000oO = next.getParentid();
                    roomStatus.O00000oo = next.getShareflag();
                    arrayList.add(roomStatus);
                }
            }
            return arrayList;
        }

        public void deleteRooms(List<String> list, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            ggb.O00000Oo().O000000o(list, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass12 */

                public final void O000000o() {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestSuccess(new Intent());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void O000000o(int i, fso fso) {
                    String str;
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        if (fso != null) {
                            try {
                                str = fso.O00000Oo;
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                return;
                            }
                        } else {
                            str = "";
                        }
                        iPluginCallback2.onRequestFailed(i, str);
                    }
                }
            });
        }

        public void roomRename(String str, String str2, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            if (!ggb.O0000oO(str2)) {
                if (iPluginCallback2 != null) {
                    try {
                        iPluginCallback2.onRequestFailed(-1, "name too long");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else if (!gqb.O00000Oo(str2)) {
                Room O00000o0 = ggb.O00000Oo().O00000o0(str);
                if (O00000o0 != null) {
                    if (!ggb.O00000Oo().O000000o(O00000o0, str2, (String) null)) {
                        O00000o0.setName(str2);
                        ggb O00000Oo = ggb.O00000Oo();
                        List list = Collections.EMPTY_LIST;
                        O00000Oo.O000000o(O00000o0, list, list, new ggb.O00000o() {
                            /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass23 */

                            public final void O000000o() {
                                IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                                if (iPluginCallback2 != null) {
                                    try {
                                        iPluginCallback2.onRequestSuccess(new Intent());
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            public final void O000000o(int i, fso fso) {
                                String str;
                                IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                                if (iPluginCallback2 != null) {
                                    if (fso != null) {
                                        try {
                                            str = fso.O00000Oo;
                                        } catch (RemoteException e) {
                                            e.printStackTrace();
                                            return;
                                        }
                                    } else {
                                        str = "";
                                    }
                                    iPluginCallback2.onRequestFailed(i, str);
                                }
                            }
                        });
                    } else if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(-1, "duplicate names");
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                } else if (iPluginCallback2 != null) {
                    try {
                        iPluginCallback2.onRequestFailed(-1, "no such room");
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                    }
                }
            } else if (iPluginCallback2 != null) {
                try {
                    iPluginCallback2.onRequestFailed(-1, "not support emoji");
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        }

        public void addRoom(RoomStatus roomStatus, final IPluginCallbackRoomStatus iPluginCallbackRoomStatus) throws RemoteException {
            if (roomStatus == null) {
                iPluginCallbackRoomStatus.onRequestFailed(-1, "room is null");
                return;
            }
            final String str = roomStatus.O00000o;
            if (TextUtils.isEmpty(str)) {
                iPluginCallbackRoomStatus.onRequestFailed(-1, "room name is empty");
            } else if (!ggb.O0000oO(str)) {
                iPluginCallbackRoomStatus.onRequestFailed(-1, "room name too long");
            } else {
                List<Room> O00000o = ggb.O00000Oo().O00000o();
                if (O00000o != null && O00000o.size() >= 50) {
                    iPluginCallbackRoomStatus.onRequestFailed(-1, "exceed room max count");
                } else if (gqb.O00000Oo(str)) {
                    iPluginCallbackRoomStatus.onRequestFailed(-1, "room name contains emoji...");
                } else if (ggb.O00000Oo().O000000o((Room) null, str, (String) null)) {
                    iPluginCallbackRoomStatus.onRequestFailed(-1, "exist same room name");
                } else {
                    ggb.O00000Oo().O000000o(str, new ArrayList(), "", new ggb.O00000o() {
                        /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass34 */

                        public final void O000000o() {
                            try {
                                List<RoomStatus> roomAll = AnonymousClass1.this.getRoomAll();
                                RoomStatus roomStatus = null;
                                int size = roomAll.size();
                                int i = 0;
                                while (true) {
                                    if (i >= size) {
                                        break;
                                    } else if (str.equals(roomAll.get(i).O00000o)) {
                                        roomStatus = roomAll.get(i);
                                        break;
                                    } else {
                                        i++;
                                    }
                                }
                                iPluginCallbackRoomStatus.onRequestSuccess(roomStatus);
                            } catch (RemoteException e) {
                                gsy.O000000o(6, "PluginService", "addRoom:  " + e.toString());
                            }
                        }

                        public final void O000000o(int i, fso fso) {
                            try {
                                iPluginCallbackRoomStatus.onRequestFailed(i, fso.toString());
                            } catch (RemoteException e) {
                                gsy.O000000o(6, "PluginService", "addRoom:  " + e.toString());
                            }
                        }
                    });
                }
            }
        }

        public Room getRoomByDid(String str) {
            Home O0000o0;
            List<String> dids;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Room O0000o00 = ggb.O00000Oo().O0000o00(str);
            if (O0000o00 == null && (O0000o0 = ggb.O00000Oo().O0000o0(str)) != null && (dids = O0000o0.getDids()) != null) {
                Iterator<String> it = dids.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (TextUtils.equals(str, it.next())) {
                            O0000o00 = new Room();
                            O0000o00.setId("mijia.roomid.default");
                            O0000o00.setDids(O0000o0.getDids());
                            O0000o00.setParentid(O0000o0.getId());
                            O0000o00.setName(ServiceApplication.getAppContext().getResources().getString(R.string.tag_recommend_defaultroom));
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (O0000o00 == null) {
                return null;
            }
            return Room.parse(O0000o00.toJSON());
        }

        public Home getHomeByDid(String str) {
            Home O0000o0 = ggb.O00000Oo().O0000o0(str);
            if (O0000o0 == null) {
                return null;
            }
            if (TextUtils.isEmpty(O0000o0.getRawName())) {
                ggb.O00000Oo();
                O0000o0.setName(ggb.O000000o(O0000o0));
            }
            return O0000o0;
        }

        public List<DeviceStatus> getSubDeviceByParentDid(String str) throws RemoteException {
            ArrayList arrayList = new ArrayList();
            for (Device copyDevicsStatus : fno.O000000o().O00000oO(str)) {
                DeviceStatus deviceStatus = new DeviceStatus();
                copyDevicsStatus(deviceStatus, copyDevicsStatus);
                arrayList.add(deviceStatus);
            }
            return arrayList;
        }

        public List<SceneInfo> getSceneByDid(String str) throws RemoteException {
            return hor.O000000o().getSceneInfosByDid(str);
        }

        public void refreshScene(String str, ISceneCallback iSceneCallback) throws RemoteException {
            if (iSceneCallback != null) {
                iSceneCallback.onSceneLoadFinished(new ArrayList());
            }
        }

        public void subscribeDevice(final String str, int i, List<String> list, int i2, final IPluginCallback iPluginCallback) throws RemoteException {
            final Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 == null) {
                PluginService.O000000o(iPluginCallback, -1, "device is null");
            } else if (i2 <= 0 || i2 > 3) {
                PluginService.O000000o(iPluginCallback, -1, "expire time mast not more than 3");
            } else {
                final AnonymousClass45 r0 = new ezm() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass45 */

                    public final void O000000o(JSONArray jSONArray) {
                        MpkPluginApi.onReceiveDevicePush(O00000o0.model, str, jSONArray);
                    }
                };
                ezo.O000000o().registerDevicePushListener(O00000o0, r0);
                PluginService.this.f8054O000000o.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass54 */

                    public final void run() {
                        ezo.O000000o().unregisterDevicePushListener(O00000o0, r0);
                    }
                }, ((long) i2) * 60000);
                DevicelibApi.subscribeDevice(CommonApplication.getAppContext(), O00000o0.did, O00000o0.pid, list, i2, new fsm<Boolean, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass55 */

                    public final void onFailure(fso fso) {
                        PluginService.O000000o(iPluginCallback, fso.f17063O000000o, fso.O00000Oo);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        PluginService.O000000o(iPluginCallback, null);
                    }
                });
            }
        }

        public void unsubscribeDevice(String str, int i, List<String> list, final IPluginCallback iPluginCallback) throws RemoteException {
            final Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 == null) {
                PluginService.O000000o(iPluginCallback, -1, "device is null");
            } else {
                DevicelibApi.unsubscribeDevice(CommonApplication.getAppContext(), O00000o0.did, O00000o0.pid, list, new fsm<Boolean, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass56 */

                    public final void onFailure(fso fso) {
                        PluginService.O000000o(iPluginCallback, fso.f17063O000000o, fso.O00000Oo);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        PluginService.O000000o(iPluginCallback, null);
                        ezo.O000000o().unregisterDevicePushListener(O00000o0);
                    }
                });
            }
        }

        public void subscribeDeviceV2(String str, int i, List<String> list, int i2, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            String str2;
            fre O000000o2 = fre.O000000o();
            AnonymousClass57 r1 = new frg() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass57 */

                public final void O000000o(String str) {
                    if (iPluginCallback2 != null) {
                        Intent intent = new Intent();
                        intent.putExtra("subscribeDeviceV2_flag", "onSuccess");
                        intent.putExtra("subscribeDeviceV2_subid", str);
                        try {
                            iPluginCallback2.onRequestSuccess(intent);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(fso fso) {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(fso.f17063O000000o, fso.O00000Oo);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(String str, String str2, JSONArray jSONArray) {
                    if (iPluginCallback2 != null) {
                        Intent intent = new Intent();
                        intent.putExtra("subscribeDeviceV2_flag", "onReceive");
                        intent.putExtra("subscribeDeviceV2_did", str);
                        intent.putExtra("subscribeDeviceV2_model", str2);
                        intent.putExtra("subscribeDeviceV2_entry", jSONArray.toString());
                        try {
                            iPluginCallback2.onRequestSuccess(intent);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            };
            if (!CoreApi.O000000o().O0000Ooo()) {
                r1.O000000o(new fso(-1, "not logged in"));
            } else if (i2 <= 0) {
                r1.O000000o(new fso(-1, "expire <=0"));
            } else {
                int i3 = i2 > 10 ? 10 : i2;
                boolean O0000O0o = ftn.O0000O0o(CommonApplication.getAppContext());
                StringBuilder sb = new StringBuilder();
                grr.O000000o();
                sb.append(grr.O000000o(CommonApplication.getAppContext(), O0000O0o));
                sb.append(CoreApi.O000000o().O0000o0());
                sb.append(O000000o2.O00000Oo.nextInt());
                sb.append(System.currentTimeMillis());
                String sb2 = sb.toString();
                if (O0000O0o) {
                    str2 = grw.O00000Oo(sb2);
                } else {
                    str2 = grv.O000000o(sb2);
                }
                String str3 = str2;
                Runnable runnable = O000000o2.O00000oO.get(str3);
                if (runnable == null) {
                    synchronized (fre.f16961O000000o) {
                        runnable = O000000o2.O00000oO.get(str3);
                        if (runnable == null) {
                            runnable = new Runnable(str3) {
                                /* class _m_j.fre.AnonymousClass1 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ String f16962O000000o;

                                {
                                    this.f16962O000000o = r2;
                                }

                                public final void run() {
                                    fre.this.O000000o(this.f16962O000000o);
                                    fre.this.O00000oO.remove(this.f16962O000000o);
                                }
                            };
                            O000000o2.O00000oO.put(str3, runnable);
                        }
                    }
                }
                CommonApplication.getGlobalWorkerHandler().removeCallbacks(runnable);
                CommonApplication.getGlobalWorkerHandler().postDelayed(runnable, ((long) i3) * 60000);
                O000000o2.O00000o0.put(str3, r1);
                DevicelibApi.subscribeDeviceV2(CommonApplication.getAppContext(), str, i, list, str3, i3, new fsm<Boolean, fso>(r1, str3) {
                    /* class _m_j.fre.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ frg f16963O000000o;
                    final /* synthetic */ String O00000Oo;

                    {
                        this.f16963O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (((Boolean) obj).booleanValue()) {
                            this.f16963O000000o.O000000o(this.O00000Oo);
                        } else {
                            this.f16963O000000o.O000000o(new fso(-1, ""));
                        }
                    }

                    public final void onFailure(fso fso) {
                        this.f16963O000000o.O000000o(fso);
                    }
                });
            }
        }

        public void unsubscribeDeviceV2(String str, int i, List<String> list, String str2, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            String str3 = str;
            int i2 = i;
            List<String> list2 = list;
            String str4 = str2;
            DevicelibApi.unsubscribeDeviceV2(CommonApplication.getAppContext(), str3, i2, list2, str4, new fsm<Boolean, fso>(str2, new frh() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass2 */

                public final void O000000o() {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestSuccess(null);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(fso fso) {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(fso.f17063O000000o, fso.O00000Oo);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }) {
                /* class _m_j.fre.AnonymousClass3 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f16964O000000o;
                final /* synthetic */ frh O00000Oo;

                {
                    this.f16964O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        fre.this.O000000o(this.f16964O000000o);
                        frh frh = this.O00000Oo;
                        if (frh != null) {
                            frh.O000000o();
                            return;
                        }
                        return;
                    }
                    frh frh2 = this.O00000Oo;
                    if (frh2 != null) {
                        frh2.O000000o(new fso(-1, ""));
                    }
                }

                public final void onFailure(fso fso) {
                    frh frh = this.O00000Oo;
                    if (frh != null) {
                        frh.O000000o(new fso(-1, ""));
                    }
                }
            });
        }

        public String getAccountId() throws RemoteException {
            return CoreApi.O000000o().O0000o0();
        }

        public Location getLastLocation() throws RemoteException {
            return fuy.O000000o().O00000o0;
        }

        public boolean isGPSLocationEnable() throws RemoteException {
            return fuy.O000000o().O00000o0();
        }

        public boolean isNetworkLocationEnabled() throws RemoteException {
            return fuy.O000000o().O00000Oo();
        }

        public void requestLocation(final ILocationCallback iLocationCallback) throws RemoteException {
            fuy.O000000o().O000000o(new fuy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass3 */

                public final void O000000o(String str, Location location) {
                    super.O000000o(str, location);
                    if (location != null) {
                        location.setProvider(str);
                    }
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        try {
                            iLocationCallback.onSuccess();
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    ILocationCallback iLocationCallback = iLocationCallback;
                    if (iLocationCallback != null) {
                        try {
                            iLocationCallback.onFailure();
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public List<DeviceStat> getIrDevList() throws RemoteException {
            Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, PluginDeviceInfo> value : pluginInfoMap.entrySet()) {
                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) value.getValue();
                if (fqw.O000000o(pluginDeviceInfo)) {
                    DeviceStat deviceStat = new DeviceStat();
                    deviceStat.model = pluginDeviceInfo.O00000Oo();
                    deviceStat.name = pluginDeviceInfo.O0000Oo0();
                    deviceStat.deviceIconReal = pluginDeviceInfo.O0000o0();
                    deviceStat.pid = pluginDeviceInfo.O0000o();
                    arrayList.add(deviceStat);
                }
            }
            return arrayList;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
         arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, ?[OBJECT, ARRAY], java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
         candidates:
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
          com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void */
        public void addRecord(String str, String str2) throws RemoteException {
            CoreApi.O000000o().O000000o(StatType.EVENT, (String) null, str, str2, (String) null, false);
        }

        public void modDeviceName(String str, final String str2, final IPluginCallback iPluginCallback) throws RemoteException {
            final Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 != null) {
                gwe.O000000o();
                gwe.O000000o(O00000o0, str2, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass4 */

                    public final void onFailure(fso fso) {
                        PluginService.O000000o(iPluginCallback, -9, "");
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        O00000o0.name = str2;
                        PluginService.O000000o(iPluginCallback, null);
                    }
                });
            } else if (iPluginCallback != null) {
                iPluginCallback.onRequestFailed(-9, "device is null");
            }
        }

        public void unBindDevice(String str, int i, final IPluginCallback iPluginCallback) throws RemoteException {
            gwe O000000o2 = gwe.O000000o();
            AnonymousClass5 r1 = new ftt<Void>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass5 */

                public final void O000000o(int i) {
                    PluginService.O000000o(iPluginCallback, i, "");
                }

                public final void O000000o(int i, Object obj) {
                    PluginService.O000000o(iPluginCallback, i, obj != null ? obj.toString() : "");
                }

                public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    PluginService.O000000o(iPluginCallback, null);
                }
            };
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str);
                jSONObject.put("pid", i);
                DevicelibApi.delDevice(CommonApplication.getAppContext(), jSONObject, new ftt<Void>(r1, str) {
                    /* class _m_j.gwe.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ftt f18403O000000o;
                    final /* synthetic */ String O00000Oo;

                    {
                        this.f18403O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        Void voidR = (Void) obj;
                        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Device device = (Device) it.next().getValue();
                            if (device.did.equalsIgnoreCase(this.O00000Oo)) {
                                String O000000o2 = gog.O000000o(CommonApplication.getAppContext());
                                if (device.location == Device.Location.REMOTE || TextUtils.isEmpty(O000000o2)) {
                                    fno.O000000o().O00000Oo(device);
                                } else {
                                    device.setOwner(false);
                                    device.userId = O000000o2;
                                    fno.O000000o().O000000o(device);
                                }
                            }
                        }
                        this.f18403O000000o.O000000o(voidR);
                    }

                    public final void O000000o(int i) {
                        this.f18403O000000o.O000000o(i);
                    }

                    public final void O000000o(int i, Object obj) {
                        this.f18403O000000o.O000000o(i);
                    }
                });
            } catch (JSONException unused) {
                r1.O000000o(ErrorCode.INVALID.getCode());
            }
        }

        public void updateDeviceList(IPluginCallback iPluginCallback) throws RemoteException {
            if (iPluginCallback != null) {
                final WeakReference weakReference = new WeakReference(iPluginCallback);
                fno.O000000o().O000000o(new fno.O000000o() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass6 */

                    public final void onRefreshClientDeviceChanged(int i, Device device) {
                    }

                    public final void onRefreshClientDeviceSuccess(int i) {
                        if (i == 3 && weakReference.get() != null) {
                            PluginService.O000000o((IPluginCallback) weakReference.get(), null);
                        }
                    }
                });
            }
            fno.O000000o().O0000Oo0();
        }

        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        public void updateDeviceProperties(String str, String str2) throws RemoteException {
            Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (O00000o0.propInfo == null) {
                        O00000o0.propInfo = jSONObject;
                        return;
                    }
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (O00000o0.propInfo.has(next)) {
                            O00000o0.propInfo.put(next, jSONObject.get(next));
                        } else {
                            O00000o0.propInfo.put(next, jSONObject.get(next));
                        }
                    }
                } catch (JSONException unused) {
                }
            }
        }

        public void log(String str, String str2) throws RemoteException {
            gsy.O00000o0(LogType.PLUGIN, str, str2);
        }

        public void logByModel(String str, String str2) throws RemoteException {
            gsy.O00000o0(LogType.PLUGIN, str, "", str2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void
         arg types: [?[OBJECT, ARRAY], int, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, com.xiaomi.smarthome.framework.plugin.PluginService$1$7]
         candidates:
          _m_j.fqu.O000000o(android.app.Activity, com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean):void
          _m_j.fqu.O000000o(com.xiaomi.smarthome.device.Device, android.content.Intent, android.graphics.Bitmap, java.lang.String, boolean, java.util.List):void
          _m_j.fqu.O000000o(android.app.Activity, boolean, com.xiaomi.smarthome.device.Device, android.content.Intent, java.lang.String, _m_j.ftt<java.lang.Void>):void */
        public void addToLauncher(String str, Intent intent) throws RemoteException {
            Device O00000o0 = fno.O000000o().O00000o0(str);
            gsy.O00000Oo("PluginService", "addToLauncher device:".concat(String.valueOf(O00000o0)));
            if (O00000o0 != null) {
                fqu.O000000o((Activity) null, false, O00000o0, intent, "plugin", (ftt<Void>) new ftt<Void>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass7 */

                    public final void O000000o(int i, Object obj) {
                    }

                    public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                    }

                    public final void O000000o(int i) {
                        try {
                            AnonymousClass1.this.requestPermission(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, null);
                        } catch (RemoteException e) {
                            Log.e("PluginService", "INSTALL_SHORTCUT", e);
                        }
                    }
                });
            }
        }

        public String getRouterFileDownloadUrl(String str) throws RemoteException {
            fue O000000o2 = fue.O000000o();
            StringBuilder sb = new StringBuilder();
            sb.append(O000000o2.O000000o("/api/xqdatacenter/download"));
            sb.append("?path=");
            sb.append(URLEncoder.encode(str));
            sb.append("&secret=");
            String O00000o = gog.O00000o(CommonApplication.getAppContext());
            sb.append(!TextUtils.isEmpty(O00000o) ? gpp.O000000o(O00000o.toLowerCase()) : "");
            return sb.toString();
        }

        public void checkLocalRouterInfo(final String str, final IPluginCallback iPluginCallback) throws RemoteException {
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass8 */

                public final void run() {
                    fue.O000000o().O000000o(str, new fsm<Void, fso>() {
                        /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass8.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            PluginService.O000000o(iPluginCallback, fso.f17063O000000o, fso.O00000Oo);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            PluginService.O000000o(iPluginCallback, null);
                        }
                    });
                }
            });
        }

        public boolean isLocalMiRouter() throws RemoteException {
            return fue.O000000o().O00000oo != null;
        }

        public void gotoPage(Uri uri) throws RemoteException {
            UrlResolver.O000000o(CommonApplication.getAppContext(), uri, true, false);
        }

        public void sendMessage(String str, int i, Intent intent, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 == null) {
                O00000o0 = fxk.O000000o().f17374O000000o.get(str);
            }
            if (O00000o0 == null) {
                if (iPluginCallback2 != null) {
                    iPluginCallback2.onRequestFailed(-1, "not found device");
                }
            } else if (CoreApi.O000000o().O00000o(O00000o0.model)) {
                Intent intent2 = new Intent();
                if (intent != null) {
                    intent2.putExtras(intent);
                }
                if (iPluginCallback2 == null) {
                    PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), O00000o0.model, i, intent2, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o0), null, false, null);
                    return;
                }
                PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), O00000o0.model, i, intent2, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o0), null, true, new SendMessageCallback() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass9 */

                    public final void onMessageFailure(int i, String str) {
                        super.onMessageFailure(i, str);
                        IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                        if (iPluginCallback2 != null) {
                            try {
                                iPluginCallback2.onRequestFailed(i, str);
                            } catch (RemoteException unused) {
                            }
                        }
                    }

                    public final void onMessageSuccess(Intent intent) {
                        super.onMessageSuccess(intent);
                        IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                        if (iPluginCallback2 != null) {
                            try {
                                iPluginCallback2.onRequestSuccess(intent);
                            } catch (RemoteException unused) {
                            }
                        }
                    }
                });
            } else if (iPluginCallback2 != null) {
                iPluginCallback2.onRequestFailed(-1, "plugin found device");
            }
        }

        public void getUserInfo(String str, final IPluginCallbackUserInfo iPluginCallbackUserInfo) throws RemoteException {
            AnonymousClass10 r0 = new ftt<ShareUserRecord>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass10 */

                public final /* synthetic */ void O000000o(Object obj) {
                    ShareUserRecord shareUserRecord = (ShareUserRecord) obj;
                    if (iPluginCallbackUserInfo != null) {
                        UserInfo userInfo = new UserInfo();
                        userInfo.userId = shareUserRecord.userId;
                        userInfo.nickName = shareUserRecord.nickName;
                        userInfo.url = shareUserRecord.url;
                        userInfo.localPath = shareUserRecord.localPath;
                        userInfo.shareTime = shareUserRecord.shareTime;
                        userInfo.phone = shareUserRecord.phone;
                        userInfo.email = shareUserRecord.email;
                        userInfo.sex = shareUserRecord.sex;
                        userInfo.birth = shareUserRecord.birth;
                        try {
                            iPluginCallbackUserInfo.onRequestSuccess(userInfo);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(int i, Object obj) {
                    IPluginCallbackUserInfo iPluginCallbackUserInfo = iPluginCallbackUserInfo;
                    if (iPluginCallbackUserInfo != null) {
                        try {
                            iPluginCallbackUserInfo.onRequestFailed(i, "");
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void O000000o(int i) {
                    IPluginCallbackUserInfo iPluginCallbackUserInfo = iPluginCallbackUserInfo;
                    if (iPluginCallbackUserInfo != null) {
                        try {
                            iPluginCallbackUserInfo.onRequestFailed(i, "");
                        } catch (RemoteException unused) {
                        }
                    }
                }
            };
            if (getAccountId().equals(str)) {
                gyl.O000000o().O000000o(r0);
            } else {
                getUserInfoFromRemoteFamilyApi(str, r0);
            }
        }

        private void getUserInfoFromRemoteFamilyApi(String str, final ftt<ShareUserRecord> ftt) {
            hys.O000000o().O000000o(CommonApplication.getAppContext(), str, new fsm<com.xiaomi.smarthome.framework.api.model.UserInfo, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass11 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    com.xiaomi.smarthome.framework.api.model.UserInfo userInfo = (com.xiaomi.smarthome.framework.api.model.UserInfo) obj;
                    final ShareUserRecord shareUserRecord = new ShareUserRecord();
                    shareUserRecord.userId = userInfo.f7549O000000o;
                    shareUserRecord.url = userInfo.O00000o0;
                    shareUserRecord.nickName = userInfo.O00000oO;
                    if (ftt != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass11.AnonymousClass1 */

                            public final void run() {
                                ftt.O000000o(shareUserRecord);
                            }
                        });
                    }
                }

                public final void onFailure(fso fso) {
                    if (ftt != null) {
                        CommonApplication.getGlobalHandler().post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass11.AnonymousClass2 */

                            public final void run() {
                                ftt.O000000o(ErrorCode.ERROR_INVALID_REQUEST.getCode());
                            }
                        });
                    }
                }
            });
        }

        public void updateSubDevice(String[] strArr, final IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
            DeviceApi.getInstance().getSubDevice(CommonApplication.getAppContext(), strArr, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass13 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<Device> list = (List) obj;
                    fno.O000000o().O000000o(list);
                    if (iPluginCallbackDeviceList != null) {
                        ArrayList arrayList = new ArrayList();
                        for (Device copyDevicsStatus : list) {
                            DeviceStatus deviceStatus = new DeviceStatus();
                            AnonymousClass1.this.copyDevicsStatus(deviceStatus, copyDevicsStatus);
                            arrayList.add(deviceStatus);
                        }
                        try {
                            iPluginCallbackDeviceList.onRequestSuccess(arrayList);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    IPluginCallbackDeviceList iPluginCallbackDeviceList = iPluginCallbackDeviceList;
                    if (iPluginCallbackDeviceList != null) {
                        try {
                            iPluginCallbackDeviceList.onRequestFailed(fso.f17063O000000o, fso.O00000Oo);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public void callRemoteAsync(String[] strArr, int i, String str, final IPluginCallback iPluginCallback, final IPluginCallback iPluginCallback2) throws RemoteException {
            try {
                JSONObject jSONObject = new JSONObject(str);
                fua O000000o2 = fua.O000000o();
                Context appContext = CommonApplication.getAppContext();
                AnonymousClass14 r0 = new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass14 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        PluginService.O000000o(iPluginCallback, jSONObject == null ? null : jSONObject.toString());
                    }

                    public final void onFailure(int i, String str) {
                        PluginService.O000000o(iPluginCallback, i, str);
                    }
                };
                fua.AnonymousClass1 r6 = new fua.O00000o(i, new ftt<JSONObject>(r0) {
                    /* class _m_j.fua.AnonymousClass2 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ Callback f17143O000000o;

                    {
                        this.f17143O000000o = r2;
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        this.f17143O000000o.onSuccess((JSONObject) obj);
                    }

                    public final void O000000o(int i) {
                        this.f17143O000000o.onFailure(i, "");
                    }

                    public final void O000000o(int i, Object obj) {
                        this.f17143O000000o.onFailure(i, obj != null ? obj.toString() : "");
                    }
                }, new Callback<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass15 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        PluginService.O000000o(iPluginCallback2, jSONObject == null ? null : jSONObject.toString());
                    }

                    public final void onFailure(int i, String str) {
                        PluginService.O000000o(iPluginCallback2, i, str);
                    }
                }) {
                    /* class _m_j.fua.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ int f17141O000000o;
                    final /* synthetic */ ftt O00000Oo;
                    final /* synthetic */ Callback O00000o0;

                    {
                        this.f17141O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        final O00000o0 o00000o0 = (O00000o0) obj;
                        if (this.O00000oo == null || this.O00000oo.f17146O000000o) {
                            gsy.O000000o(3, fua.f17140O000000o, "callRemoteAsync onSuccess request canceled");
                        } else if (o00000o0 == null) {
                            onFailure(new fso(0, "result is null"));
                        } else {
                            O000000o o000000o = new O000000o();
                            o000000o.f17145O000000o = o00000o0;
                            o000000o.O00000o0 = this.f17141O000000o;
                            o000000o.O00000o = new WeakReference<>(this.O00000Oo);
                            synchronized (fua.this.O00000o0) {
                                this.O00000oO = o00000o0.f17147O000000o;
                                fua.this.O00000Oo.put(Long.valueOf(o00000o0.f17147O000000o), o000000o);
                                O0000OOo o0000OOo = fua.this.O00000o;
                                AnonymousClass1 r4 = new O0000OOo.O00000Oo() {
                                    /* class _m_j.fua.AnonymousClass1.AnonymousClass1 */

                                    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
                                        return;
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
                                        return;
                                     */
                                    public final void O000000o() {
                                        if (AnonymousClass1.this.O00000oo != null && !AnonymousClass1.this.O00000oo.f17146O000000o) {
                                            synchronized (fua.this.O00000o0) {
                                                O000000o remove = fua.this.O00000Oo.remove(Long.valueOf(o00000o0.f17147O000000o));
                                                if (remove != null) {
                                                    if (remove.O00000o != null) {
                                                        ftt ftt = remove.O00000o == null ? null : remove.O00000o.get();
                                                        if (ftt != null) {
                                                            ftt.O000000o(remove.O00000Oo.f17148O000000o);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
                                        if (r1.O00000o != null) goto L_0x0035;
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
                                        r0 = null;
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
                                        r0 = r1.O00000o.get();
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
                                        if (r0 == null) goto L_?;
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
                                        r0.O000000o(r5, r6);
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
                                        return;
                                     */
                                    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
                                        return;
                                     */
                                    public final void O000000o(int i, Object obj) {
                                        if (AnonymousClass1.this.O00000oo != null && !AnonymousClass1.this.O00000oo.f17146O000000o) {
                                            synchronized (fua.this.O00000o0) {
                                                O000000o remove = fua.this.O00000Oo.remove(Long.valueOf(o00000o0.f17147O000000o));
                                                if (remove == null) {
                                                }
                                            }
                                        }
                                    }
                                };
                                if (o000000o.f17145O000000o == null) {
                                    r4.O000000o(0, "data is null or data.response is null");
                                } else {
                                    if (o000000o.f17145O000000o.O00000o0 > 0) {
                                        if (o000000o.f17145O000000o.f17147O000000o >= 0) {
                                            O0000OOo.O00000o0 o00000o02 = new O0000OOo.O00000o0(o0000OOo, (byte) 0);
                                            o00000o02.f17153O000000o = o000000o;
                                            o00000o02.O00000o = o000000o.f17145O000000o.O00000o0;
                                            o00000o02.O00000o0 = r4;
                                            o00000o02.O00000Oo = o000000o.f17145O000000o.f17147O000000o;
                                            Message obtainMessage = o0000OOo.f17149O000000o.obtainMessage();
                                            obtainMessage.obj = o00000o02;
                                            obtainMessage.what = fua.O00000o0(o00000o02.O00000Oo);
                                            o0000OOo.f17149O000000o.sendMessageDelayed(obtainMessage, (long) (o000000o.f17145O000000o.O00000Oo * 1000));
                                        }
                                    }
                                    r4.O000000o(0, "invalid sid or maxRetry");
                                }
                            }
                            if (this.O00000o0 != null) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("sid", o00000o0.f17147O000000o);
                                    jSONObject.put("interval", o00000o0.O00000Oo);
                                    jSONObject.put("max_retry", o00000o0.O00000o0);
                                    this.O00000o0.onSuccess(jSONObject);
                                } catch (JSONException unused) {
                                }
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        String str;
                        gsy.O000000o(3, fua.f17140O000000o, "callRemoteAsync failed ".concat(String.valueOf(fso)));
                        ftt ftt = this.O00000Oo;
                        if (ftt != null) {
                            int i = fso.f17063O000000o;
                            if (fso.O00000Oo != null) {
                                str = fso.O00000Oo;
                            } else {
                                str = "";
                            }
                            ftt.O000000o(i, str);
                        }
                    }
                };
                fua.O00000Oo o00000Oo = new fua.O00000Oo(ftz.O000000o().O000000o(appContext, strArr, i, jSONObject, r6));
                o00000Oo.O00000o0 = r6;
                o00000Oo.O00000o0.O00000oo = o00000Oo;
            } catch (Exception e) {
                PluginService.O000000o(iPluginCallback, -1, e.getMessage());
            }
        }

        public void startSearchNewDevice(String str, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            final List<Device> O00000oO = fno.O000000o().O00000oO(str);
            DeviceApi.getInstance().getSubDevice(CommonApplication.getAppContext(), new String[]{str}, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass16 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList<Device> arrayList = new ArrayList<>();
                    for (Device device : (List) obj) {
                        boolean z = false;
                        for (Device device2 : O00000oO) {
                            if (device2.did.equalsIgnoreCase(device.did)) {
                                z = true;
                            }
                        }
                        if (!z) {
                            arrayList.add(device);
                        }
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Device device3 : arrayList) {
                        fno.O000000o().O000000o(device3);
                        arrayList2.add(DeviceRouterFactory.getDeviceWrapper().newDeviceStat(device3));
                    }
                    if (iPluginCallback2 != null) {
                        Intent intent = new Intent();
                        intent.putParcelableArrayListExtra("data", arrayList2);
                        try {
                            iPluginCallback2.onRequestSuccess(intent);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(-1, "");
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public void notifyBluetoothBinded(String str, String str2) throws RemoteException {
            fpo.O00000oO(str, str2);
        }

        public void loadWebView(String str, String str2) throws RemoteException {
            hjp.O000000o(str, str2, new boolean[0]);
        }

        public void loadUrl(String str, String str2) throws RemoteException {
            loadUrlPro(str, str2, false);
        }

        public void loadUrlPro(String str, String str2, boolean z) throws RemoteException {
            if (z) {
                hjp.O000000o(str, str2);
            } else {
                hjp.O000000o(str, str2, new boolean[0]);
            }
        }

        public void loadRecommendScenes(String str, final IRecommendSceneItemCallback iRecommendSceneItemCallback) throws RemoteException {
            hor.O000000o().miioGetRecommendScene(CommonApplication.getAppContext(), str, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass17 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONArray jSONArray;
                    JSONObject jSONObject = (JSONObject) obj;
                    LogType logType = LogType.SCENE;
                    gsy.O000000o(logType, "scene", "miioGetRecommendScene--------------" + jSONObject.toString());
                    if (jSONObject.has("result")) {
                        jSONArray = jSONObject.optJSONArray("result");
                    } else {
                        jSONArray = jSONObject.optJSONArray("value");
                    }
                    List<RecommendSceneItem> recommendFromJSON = AnonymousClass1.this.getRecommendFromJSON(jSONArray);
                    IRecommendSceneItemCallback iRecommendSceneItemCallback = iRecommendSceneItemCallback;
                    if (iRecommendSceneItemCallback != null) {
                        try {
                            iRecommendSceneItemCallback.onRequestSuccess(recommendFromJSON);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    int i;
                    IRecommendSceneItemCallback iRecommendSceneItemCallback = iRecommendSceneItemCallback;
                    if (iRecommendSceneItemCallback != null) {
                        if (fso != null) {
                            try {
                                i = fso.f17063O000000o;
                            } catch (RemoteException unused) {
                                return;
                            }
                        } else {
                            i = -1;
                        }
                        iRecommendSceneItemCallback.onRequestFailed(i, fso != null ? fso.toString() : "");
                    }
                }
            });
        }

        public List<RecommendSceneItem> getRecommendFromJSON(JSONArray jSONArray) {
            JSONArray jSONArray2;
            ArrayList arrayList;
            JSONArray jSONArray3;
            ArrayList arrayList2 = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                RecommendSceneItem recommendSceneItem = new RecommendSceneItem();
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                recommendSceneItem.mRecommId = optJSONObject.optInt("sr_id");
                recommendSceneItem.mStatus = optJSONObject.optInt("status");
                if (optJSONObject.has("info")) {
                    optJSONObject = optJSONObject.optJSONObject("info");
                }
                recommendSceneItem.mName = optJSONObject.optString("name");
                recommendSceneItem.mRecommLevel = optJSONObject.optDouble("level");
                recommendSceneItem.mEnablePush = optJSONObject.optInt("enable_push") == 1;
                recommendSceneItem.mShowInMainPage = optJSONObject.optInt("show_mode") == 1;
                recommendSceneItem.mIcon = optJSONObject.optString("icon");
                JSONArray optJSONArray = optJSONObject.optJSONArray("launch");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    recommendSceneItem.mRecommendConditionList = new RecommendSceneItem.RemommendSceneCondition[optJSONArray.length()];
                    int i2 = 0;
                    while (i2 < optJSONArray.length()) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        RecommendSceneItem.RemommendSceneCondition remommendSceneCondition = new RecommendSceneItem.RemommendSceneCondition();
                        remommendSceneCondition.mConditionName = optJSONObject2.optString("name");
                        RecommendSceneItem.Key key = new RecommendSceneItem.Key();
                        key.mKey = optJSONObject2.optString("key");
                        key.mValues = optJSONObject2.opt("value");
                        key.mName = remommendSceneCondition.mConditionName;
                        if ((key.mValues instanceof JSONObject) || (key.mValues instanceof JSONArray)) {
                            key.mValues = key.mValues.toString();
                        }
                        if (optJSONObject2.has("key_ex")) {
                            JSONArray optJSONArray2 = optJSONObject2.optJSONArray("key_ex");
                            jSONArray3 = optJSONArray;
                            remommendSceneCondition.mKeys = new RecommendSceneItem.Key[(optJSONArray2.length() + 1)];
                            remommendSceneCondition.mKeys[0] = key;
                            int i3 = 0;
                            while (i3 < optJSONArray2.length()) {
                                JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i3);
                                JSONArray jSONArray4 = optJSONArray2;
                                RecommendSceneItem.Key key2 = new RecommendSceneItem.Key();
                                ArrayList arrayList3 = arrayList2;
                                key2.mKey = optJSONObject3.optString("key");
                                key2.mValues = optJSONObject3.opt("value");
                                key2.mName = remommendSceneCondition.mConditionName;
                                if ((key2.mValues instanceof JSONObject) || (key2.mValues instanceof JSONArray)) {
                                    key2.mValues = key2.mValues.toString();
                                }
                                i3++;
                                remommendSceneCondition.mKeys[i3] = key2;
                                optJSONArray2 = jSONArray4;
                                arrayList2 = arrayList3;
                            }
                            arrayList = arrayList2;
                        } else {
                            arrayList = arrayList2;
                            jSONArray3 = optJSONArray;
                            remommendSceneCondition.mKeys = new RecommendSceneItem.Key[1];
                            remommendSceneCondition.mKeys[0] = key;
                        }
                        if (optJSONObject2.has("model_list")) {
                            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("model_list");
                            remommendSceneCondition.mDeviceModels = new String[optJSONArray3.length()];
                            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                                remommendSceneCondition.mDeviceModels[i4] = optJSONArray3.optString(i4);
                            }
                        } else {
                            remommendSceneCondition.mDeviceModels = new String[1];
                            remommendSceneCondition.mDeviceModels[0] = optJSONObject2.optString("model");
                        }
                        remommendSceneCondition.mAddAllDevice = Boolean.valueOf(optJSONObject2.optBoolean("pd_ex"));
                        remommendSceneCondition.mProductId = optJSONObject2.optString("gid");
                        remommendSceneCondition.mSrc = optJSONObject2.optString("src");
                        recommendSceneItem.mRecommendConditionList[i2] = remommendSceneCondition;
                        i2++;
                        optJSONArray = jSONArray3;
                        arrayList2 = arrayList;
                    }
                }
                ArrayList arrayList4 = arrayList2;
                JSONArray optJSONArray4 = optJSONObject.optJSONArray("action_list");
                recommendSceneItem.mRecommendActionList = new RecommendSceneItem.RemommendSceneAction[optJSONArray4.length()];
                int i5 = 0;
                while (i5 < optJSONArray4.length()) {
                    JSONObject optJSONObject4 = optJSONArray4.optJSONObject(i5);
                    RecommendSceneItem.RemommendSceneAction remommendSceneAction = new RecommendSceneItem.RemommendSceneAction();
                    remommendSceneAction.mActionName = optJSONObject4.optString("name");
                    JSONObject optJSONObject5 = optJSONObject4.optJSONObject("payload");
                    RecommendSceneItem.Key key3 = new RecommendSceneItem.Key();
                    key3.mKey = optJSONObject5.optString("command");
                    key3.mValues = optJSONObject5.opt("value");
                    if ((key3.mValues instanceof JSONObject) || (key3.mValues instanceof JSONArray)) {
                        key3.mValues = key3.mValues.toString();
                    }
                    key3.mName = remommendSceneAction.mActionName;
                    if (optJSONObject5.has("command_ex")) {
                        JSONArray optJSONArray5 = optJSONObject5.optJSONArray("command_ex");
                        remommendSceneAction.mKeys = new RecommendSceneItem.Key[(optJSONArray5.length() + 1)];
                        remommendSceneAction.mKeys[0] = key3;
                        int i6 = 0;
                        while (i6 < optJSONArray5.length()) {
                            JSONObject optJSONObject6 = optJSONArray5.optJSONObject(i6);
                            RecommendSceneItem.Key key4 = new RecommendSceneItem.Key();
                            JSONArray jSONArray5 = optJSONArray4;
                            key4.mKey = optJSONObject6.optString("command");
                            key4.mValues = optJSONObject6.opt("value");
                            if ((key4.mValues instanceof JSONObject) || (key4.mValues instanceof JSONArray)) {
                                key4.mValues = key4.mValues.toString();
                            }
                            key4.mName = remommendSceneAction.mActionName;
                            remommendSceneAction.mKeys[i + 1] = key4;
                            i6++;
                            optJSONArray4 = jSONArray5;
                        }
                        jSONArray2 = optJSONArray4;
                    } else {
                        jSONArray2 = optJSONArray4;
                        remommendSceneAction.mKeys = new RecommendSceneItem.Key[1];
                        remommendSceneAction.mKeys[0] = key3;
                    }
                    if (optJSONObject4.has("model_list")) {
                        JSONArray optJSONArray6 = optJSONObject4.optJSONArray("model_list");
                        remommendSceneAction.mDeviceModels = new String[optJSONArray6.length()];
                        for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                            remommendSceneAction.mDeviceModels[i7] = optJSONArray6.optString(i7);
                        }
                    } else {
                        remommendSceneAction.mDeviceModels = new String[1];
                        remommendSceneAction.mDeviceModels[0] = optJSONObject4.optString("model");
                    }
                    remommendSceneAction.mProductId = optJSONObject4.optString("gid");
                    recommendSceneItem.mRecommendActionList[i5] = remommendSceneAction;
                    i5++;
                    optJSONArray4 = jSONArray2;
                }
                ArrayList arrayList5 = arrayList4;
                arrayList5.add(recommendSceneItem);
                i++;
                arrayList2 = arrayList5;
            }
            return arrayList2;
        }

        public void updateSceneItem(final SceneInfo sceneInfo, final ISceneInfoCallback iSceneInfoCallback) throws RemoteException {
            hor.O000000o().miioSceneUpdate(CommonApplication.getAppContext(), sceneInfo.mSceneIdV2, sceneInfo.mName, sceneInfo.mEnable, new fsm<Void, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass18 */

                public final void onFailure(fso fso) {
                    try {
                        if (iSceneInfoCallback != null) {
                            iSceneInfoCallback.onFailure(-1, null);
                        }
                    } catch (RemoteException unused) {
                    }
                }

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                    ISceneInfoCallback iSceneInfoCallback = iSceneInfoCallback;
                    if (iSceneInfoCallback != null) {
                        try {
                            iSceneInfoCallback.onSuccess(sceneInfo);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public void updateScene(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            hor.O000000o().updateCustomScene(str, new hny() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass19 */

                public final void onRefreshScenceSuccess(int i) {
                    gsy.O000000o(6, "1", "2 ".concat(String.valueOf(i)));
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null && i == 5) {
                        try {
                            iPluginCallback.onRequestSuccess(null);
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final void onRefreshScenceFailed(int i) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null && i == 5) {
                        try {
                            iPluginCallback.onRequestFailed(-1, "");
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public boolean hasSceneOnline(String str, String str2) throws RemoteException {
            return hor.O000000o().getSceneOnline(str, str2);
        }

        public void setSubDeviceShownMode(String str, boolean z, final IPluginCallback iPluginCallback) throws RemoteException {
            fno O000000o2 = fno.O000000o();
            O000000o2.f16707O000000o.setSubDeviceShownMode(z, str, CommonApplication.getAppContext(), new ftt<Void>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass20 */

                public final void O000000o(int i, Object obj) {
                    String str;
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        if (obj == null) {
                            str = "";
                        } else {
                            try {
                                str = obj.toString();
                            } catch (RemoteException unused) {
                                return;
                            }
                        }
                        iPluginCallback.onRequestFailed(i, str);
                    }
                }

                public final void O000000o(int i) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestFailed(i, "");
                        } catch (RemoteException unused) {
                        }
                    }
                }

                public final /* synthetic */ void O000000o(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess(null);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public DeviceStatus getDevice(String str) throws RemoteException {
            Device O000000o2;
            Device O00000o0 = fno.O000000o().O00000o0(str);
            JSONObject jSONObject = null;
            if (O00000o0 == null) {
                return null;
            }
            if (TextUtils.isEmpty(O00000o0.parentModel) && !TextUtils.isEmpty(O00000o0.parentId) && (O000000o2 = fno.O000000o().O000000o(O00000o0.parentId)) != null) {
                O00000o0.parentModel = O000000o2.model;
            }
            if ((O00000o0.propInfo == null || O00000o0.propInfo.length() == 0) && TextUtils.isEmpty(O00000o0.event)) {
                Map<String, hdi> propsMap = faw.O000000o().getPropsMap(O00000o0.did);
                Map<String, hdi> propsMap2 = faw.O00000Oo().getPropsMap(O00000o0.did);
                if (propsMap != null) {
                    try {
                        if (O00000o0.propInfo == null) {
                            O00000o0.propInfo = new JSONObject();
                        }
                        jSONObject = new JSONObject();
                        for (Map.Entry next : propsMap.entrySet()) {
                            String str2 = (String) next.getKey();
                            Object obj = ((hdi) next.getValue()).f18812O000000o;
                            if (str2 != null) {
                                if (str2.startsWith("event.")) {
                                    jSONObject.put(str2, obj);
                                } else if (str2.startsWith("prop.")) {
                                    jSONObject.put(str2, obj);
                                    O00000o0.propInfo.put(str2.substring(5), obj);
                                } else {
                                    O00000o0.propInfo.put(str2, obj);
                                }
                            }
                        }
                    } catch (JSONException e) {
                        e = e;
                        gsy.O000000o(6, "PluginService", Log.getStackTraceString(e));
                        DeviceStatus deviceStatus = new DeviceStatus();
                        copyDevicsStatus(deviceStatus, O00000o0);
                        return deviceStatus;
                    } catch (NullPointerException e2) {
                        e = e2;
                        gsy.O000000o(6, "PluginService", Log.getStackTraceString(e));
                        DeviceStatus deviceStatus2 = new DeviceStatus();
                        copyDevicsStatus(deviceStatus2, O00000o0);
                        return deviceStatus2;
                    }
                }
                if (propsMap2 != null) {
                    if (jSONObject == null) {
                        jSONObject = new JSONObject();
                    }
                    if (O00000o0.propInfo == null) {
                        O00000o0.propInfo = new JSONObject();
                    }
                    for (Map.Entry next2 : propsMap2.entrySet()) {
                        String str3 = (String) next2.getKey();
                        Object obj2 = ((hdi) next2.getValue()).f18812O000000o;
                        if (str3 != null) {
                            if (str3.startsWith("event.")) {
                                jSONObject.put(str3, obj2);
                            } else if (str3.startsWith("prop.")) {
                                jSONObject.put(str3, obj2);
                                O00000o0.propInfo.put(str3.substring(5), obj2);
                            } else {
                                O00000o0.propInfo.put(str3, obj2);
                            }
                        }
                    }
                }
                if (jSONObject != null) {
                    O00000o0.event = jSONObject.toString();
                }
            }
            DeviceStatus deviceStatus22 = new DeviceStatus();
            copyDevicsStatus(deviceStatus22, O00000o0);
            return deviceStatus22;
        }

        public DeviceTagInfo getDeviceTagInfo(String str) throws RemoteException {
            DeviceTagInterface<Device> O00000Oo = fnn.O000000o().O00000Oo();
            JSONObject jSONObject = new JSONObject();
            for (Integer intValue : O00000Oo.O0000O0o()) {
                int intValue2 = intValue.intValue();
                List<String> O000000o2 = O00000Oo.O000000o(intValue2, str);
                if (O000000o2 != null && O000000o2.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (String put : O000000o2) {
                        jSONArray.put(put);
                    }
                    try {
                        jSONObject.put(String.valueOf(intValue2), jSONArray);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (jSONObject.length() <= 0) {
                return null;
            }
            DeviceTagInfo deviceTagInfo = new DeviceTagInfo();
            deviceTagInfo.f6612O000000o = jSONObject.toString();
            return deviceTagInfo;
        }

        public String getLightDeviceGroupModel(String str) throws RemoteException {
            if (!TextUtils.isEmpty(str)) {
                return gtf.O000000o().O000000o(str);
            }
            gsy.O00000Oo("PluginService", "getLightDeviceGroupModel error: model is empty");
            return "";
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.fqv.O000000o(java.util.Set<java.lang.String>, java.lang.String, boolean, _m_j.ggb$O00000o):void
         arg types: [java.util.HashSet, java.lang.String, int, ?[OBJECT, ARRAY]]
         candidates:
          _m_j.fqv.O000000o(java.lang.String, java.lang.String, java.lang.String, java.lang.String):_m_j.fqv$O00000o0
          _m_j.fqv.O000000o(java.util.Set<java.lang.String>, java.lang.String, boolean, _m_j.ggb$O00000o):void */
        public void addTag(String str, String str2) throws RemoteException {
            if (!TextUtils.isEmpty(str)) {
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                ((fqv) fnn.O000000o().O00000Oo()).O000000o((Set<String>) hashSet, str2, false, (ggb.O00000o) null);
            }
        }

        public void removeTag(String str) throws RemoteException {
            fnn.O000000o().O00000Oo().O000000o(str);
        }

        public List<String> getRecommendTags(String str) throws RemoteException {
            fno O000000o2 = fno.O000000o();
            Device O000000o3 = O000000o2.O000000o(str);
            if (O000000o3 == null) {
                O000000o3 = O000000o2.O00000Oo(str);
            }
            return fnn.O000000o().O00000Oo().O000000o(O000000o3);
        }

        public int getMainProcessId() throws RemoteException {
            return Process.myPid();
        }

        public void renameBluetoothDevice(String str, String str2) throws RemoteException {
            fpo.O00000o0(str, str2);
        }

        public void setBleDeviceSubtitle(String str, String str2) throws RemoteException {
            fpo.O00000o(str, str2);
        }

        public void registerMediaButtonReceiver(String str) throws RemoteException {
            gnk.O00000o0("registerMediaButtonReceiver model = ".concat(String.valueOf(str)));
            if (this.mMediaComponent == null) {
                this.mMediaButtonModel = str;
                Context appContext = CommonApplication.getAppContext();
                this.mMediaComponent = new ComponentName(appContext.getPackageName(), MediaButtonReceiver.class.getName());
                ((AudioManager) appContext.getSystemService("audio")).registerMediaButtonEventReceiver(this.mMediaComponent);
                return;
            }
            gnk.O00000o0(">>> MediaComponent not null");
        }

        public void unRegisterMediaButtonReceiver(String str) throws RemoteException {
            gnk.O00000o0("unRegisterMediaButtonReceiver model = ".concat(String.valueOf(str)));
            if (!TextUtils.isEmpty(str) && str.equals(this.mMediaButtonModel) && this.mMediaComponent != null) {
                this.mMediaButtonModel = null;
                ((AudioManager) CommonApplication.getAppContext().getSystemService("audio")).unregisterMediaButtonEventReceiver(this.mMediaComponent);
                this.mMediaComponent = null;
            }
        }

        public String getMediaButtonModel() throws RemoteException {
            return this.mMediaButtonModel;
        }

        public void visualSecureBind(String str) throws RemoteException {
            Device O000000o2 = fno.O000000o().O000000o(str);
            if (O000000o2 == null) {
                O000000o2 = fob.O00000Oo(str);
            }
            if (O000000o2 == null) {
                return;
            }
            if (O000000o2 == null) {
                gnk.O00000oO("device null, return");
                return;
            }
            fbt fbt = new fbt(CommonApplication.getAppContext(), "BleConnectActivity");
            fbt.O00000Oo(268435456);
            fbt.O000000o("model", O000000o2.model);
            fbt.O000000o("extra_from", "from_plus");
            fbt.O000000o("extra_did", O000000o2.did);
            fbt.O000000o("extra_mac", O000000o2.mac);
            fbs.O000000o(fbt);
        }

        public void secureConnect(String str, final IBleCallback iBleCallback) throws RemoteException {
            Device O00000o = fno.O000000o().O00000o(str);
            if (O00000o == null || !O00000o.isBinded()) {
                fte.O00000Oo(String.format("secureConnect: %s has unbind", fte.O000000o(str)));
                if (iBleCallback != null) {
                    try {
                        iBleCallback.onResponse(-1, null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                fpo.O000000o(str, new Response.BleConnectResponse() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass21 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        Bundle bundle = (Bundle) obj;
                        IBleCallback iBleCallback = iBleCallback;
                        if (iBleCallback != null) {
                            try {
                                iBleCallback.onResponse(i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void securityChipConnect(String str, final IBleCallback iBleCallback) throws RemoteException {
            Device O00000o = fno.O000000o().O00000o(str);
            if (O00000o == null || !O00000o.isBinded()) {
                fte.O00000Oo(String.format("securityChipConnect: %s has unbind", fte.O000000o(str)));
                if (iBleCallback != null) {
                    try {
                        iBleCallback.onResponse(-1, null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                fpo.O00000o0(str, new Response.BleConnectResponse() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass22 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        Bundle bundle = (Bundle) obj;
                        IBleCallback iBleCallback = iBleCallback;
                        if (iBleCallback != null) {
                            try {
                                iBleCallback.onResponse(i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void securityChipSharedDeviceConnect(String str, final IBleCallback iBleCallback) throws RemoteException {
            Device O00000o = fno.O000000o().O00000o(str);
            if (O00000o == null || !O00000o.isBinded()) {
                fte.O00000Oo(String.format("securityChipSharedDeviceConnect: %s has unbind", fte.O000000o(str)));
                if (iBleCallback != null) {
                    try {
                        iBleCallback.onResponse(-1, null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                fpo.O00000Oo(str, new Response.BleConnectResponse() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass24 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        Bundle bundle = (Bundle) obj;
                        IBleCallback iBleCallback = iBleCallback;
                        if (iBleCallback != null) {
                            try {
                                iBleCallback.onResponse(i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void reverseGeo(double d, double d2, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            fuy.O000000o().O000000o(d, d2, new fuy.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass25 */

                public final void O000000o(String str, Location location) {
                    Bundle extras = location.getExtras();
                    if (extras == null) {
                        try {
                            iPluginCallback2.onRequestFailed(-1, "location not contains bundle extras");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Address address = (Address) extras.getParcelable("address");
                        if (address == null) {
                            try {
                                iPluginCallback2.onRequestFailed(-1, "location bundle not contains address");
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            Intent intent = new Intent();
                            intent.putExtra("address", address);
                            try {
                                iPluginCallback2.onRequestSuccess(intent);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                }

                public final void O000000o(String str) {
                    try {
                        iPluginCallback2.onRequestFailed(-1, "reverseGeo failed");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void requestPermission(String[] strArr, final IPluginCallback iPluginCallback) throws RemoteException {
            ind.O000000o(CommonApplication.getAppContext()).O000000o(strArr).O000000o((inh) null).O000000o(new inc() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass27 */

                public final void onAction(List<String> list) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("onGranted");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).O00000Oo(new inc() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass26 */

                public final void onAction(List<String> list) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("onDenied");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).O000000o();
        }

        public void addDeviceToMain(final String str, String str2, final IPluginCallback iPluginCallback) throws RemoteException {
            gnk.O00000o0(String.format("getDeviceInfo did = %s", str));
            DeviceApi.getInstance().getDeviceDetail(CommonApplication.getAppContext(), new String[]{str}, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass28 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List list = (List) obj;
                    gnk.O00000o0(String.format("onSuccess size = %d", Integer.valueOf(list.size())));
                    String str = "";
                    if (list.size() > 0) {
                        Device O000000o2 = fno.O000000o().O000000o(str);
                        if (O000000o2 != null) {
                            fno.O000000o().O00000Oo(O000000o2);
                        }
                        Device device = (Device) list.get(0);
                        fno.O000000o().O000000o(new O000000o(device, iPluginCallback));
                        fno.O000000o().O000000o(device);
                        htw O000000o3 = htv.O000000o();
                        if (O000000o3 != null) {
                            O000000o3.setCurrentScrollToDid(str);
                        }
                        Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                        if (device != null && O0000Oo0 != null) {
                            ggb.O00000Oo().O000000o(O0000Oo0, (Room) null, device, new ggb.O00000o() {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass28.AnonymousClass1 */

                                public final void O000000o() {
                                }

                                public final void O000000o(int i, fso fso) {
                                }
                            });
                            DeviceApi.getInstance().reportNewBind(CommonApplication.getAppContext(), device.did, "mijia", new fsm<JSONObject, fso>() {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass28.AnonymousClass2 */

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject != null && jSONObject.optInt("code", -1) == 0) {
                                        gsy.O000000o(3, "wangyh", "onSuccess: " + jSONObject.toString());
                                    }
                                }

                                public final void onFailure(fso fso) {
                                    gsy.O000000o(3, "wangyh", "onFailure: " + fso.toString());
                                }
                            });
                        } else if (iPluginCallback != null) {
                            if (device == null) {
                                try {
                                    str = str + "[device:null]";
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            if (O0000Oo0 == null) {
                                str = str + "[home:null]";
                            }
                            iPluginCallback.onRequestFailed(0, str);
                        }
                    } else {
                        IPluginCallback iPluginCallback = iPluginCallback;
                        if (iPluginCallback != null) {
                            try {
                                iPluginCallback.onRequestFailed(0, str);
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    gnk.O00000o0(String.format("onFailure %s", fso));
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestFailed(0, "getDeviceDetail fail");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void bleMeshConnect(String str, String str2, final IBleCallback iBleCallback) throws RemoteException {
            Device O00000o = fno.O000000o().O00000o(str);
            if (O00000o == null) {
                O00000o = fno.O000000o().O00000oo(str2);
            }
            if (O00000o == null || !O00000o.isBinded()) {
                fte.O00000Oo(String.format("bleMeshConnect: %s has unbind", fte.O000000o(str)));
                if (iBleCallback != null) {
                    try {
                        iBleCallback.onResponse(-1, null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                if (TextUtils.isEmpty(str2)) {
                    str2 = O00000o.did;
                }
                fpo.O000000o(str, str2, O00000o.token, new Response.BleConnectResponse() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass29 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        Bundle bundle = (Bundle) obj;
                        IBleCallback iBleCallback = iBleCallback;
                        if (iBleCallback != null) {
                            try {
                                iBleCallback.onResponse(i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void bleStandardAuthConnect(String str, final IBleCallback iBleCallback) throws RemoteException {
            Device O00000o = fno.O000000o().O00000o(str);
            if (O00000o == null || !O00000o.isBinded()) {
                fte.O00000Oo(String.format("bleStandardAuthConnect: %s has unbind", fte.O000000o(str)));
                if (iBleCallback != null) {
                    try {
                        iBleCallback.onResponse(-1, null);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                fpo.O00000o(str, new Response.BleConnectResponse() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass30 */

                    public final /* synthetic */ void onResponse(int i, Object obj) {
                        Bundle bundle = (Bundle) obj;
                        IBleCallback iBleCallback = iBleCallback;
                        if (iBleCallback != null) {
                            try {
                                iBleCallback.onResponse(i, bundle);
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void downloadRnExtModules() {
            gsy.O00000Oo("PluginService", "start request downloadRnExtModules");
            hmq.O000000o().downloadRnExtModules();
        }

        public void refreshDeviceListUi() throws RemoteException {
            gbu.O000000o("send broadcast refreshDeviceListUi...");
            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("force_update_data"));
        }

        public void refreshServiceTokenBySystemAccountNew(String str, MiServiceTokenInfo miServiceTokenInfo, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            ibm.O000000o(str, miServiceTokenInfo, new ibh<MiServiceTokenInfo, ExceptionError>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass31 */

                public final /* synthetic */ void onFailure(Error error) {
                    ExceptionError exceptionError = (ExceptionError) error;
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(exceptionError.f12083O000000o, exceptionError.toString());
                        } catch (RemoteException e) {
                            gsy.O000000o(5, "PluginService", "refreshServiceTokenBySystemAccountNew:" + Log.getStackTraceString(e));
                        }
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                    if (iPluginCallback2 != null) {
                        Intent intent = new Intent();
                        if (miServiceTokenInfo != null) {
                            intent.putExtra("serviceToken", miServiceTokenInfo.O00000o0);
                            intent.putExtra("cUserId", miServiceTokenInfo.O00000Oo);
                            intent.putExtra("ssecurity", miServiceTokenInfo.O00000o);
                        }
                        try {
                            iPluginCallback2.onRequestSuccess(intent);
                        } catch (RemoteException e) {
                            gsy.O000000o(5, "PluginService", "refreshServiceTokenBySystemAccountNew:" + Log.getStackTraceString(e));
                        }
                    }
                }
            });
        }

        public void bleSpecOperation(String str, int i, String str2, final IPluginCallback2 iPluginCallback2) throws RemoteException {
            int i2;
            AnonymousClass32 r0 = new cmi<Bundle>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass32 */

                public final /* synthetic */ void O000000o(Object obj) {
                    Bundle bundle = (Bundle) obj;
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 == null) {
                        return;
                    }
                    if (bundle == null) {
                        try {
                            iPluginCallback2.onRequestSuccess(null);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Intent intent = new Intent();
                        intent.putExtra("key_spec_json_resp", bundle.getString("key_spec_json_resp"));
                        try {
                            iPluginCallback2.onRequestSuccess(intent);
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }

                public final void O000000o(int i, String str) {
                    IPluginCallback2 iPluginCallback2 = iPluginCallback2;
                    if (iPluginCallback2 != null) {
                        try {
                            iPluginCallback2.onRequestFailed(i, str);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            cnd.O000000o("SpecManager", "ble spec operation, opcode:%d,jsonParams:%s", Integer.valueOf(i), str2);
            if (!SpecManager.O000000o.f5247O000000o.O00000o.contains(str)) {
                cnd.O000000o("SpecManager", "the device not support ble spec protocol", new Object[0]);
                r0.O000000o(-1008, "the device not support ble spec protocol!");
                return;
            }
            Integer num = SpecManager.O000000o.f5247O000000o.O00000o0.get(str);
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = -1;
            }
            cnd.O000000o("SpecManager", " bleSpecOperation check deviceProtocol(%d) & app ble protocol version(%d)", Integer.valueOf(i2), 2);
            if (i2 < 0) {
                SpecManager.O000000o.f5247O000000o.O000000o(str, new cmy(str, new cml(r0, str, i, str2) {
                    /* class _m_j.cmf.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ cmi f14120O000000o;
                    final /* synthetic */ String O00000Oo;
                    final /* synthetic */ String O00000o;
                    final /* synthetic */ int O00000o0;

                    {
                        this.f14120O000000o = r1;
                        this.O00000Oo = r2;
                        this.O00000o0 = r3;
                        this.O00000o = r4;
                    }

                    public final void O000000o(int i) {
                        cnd.O000000o("SpecManager", "bleSpecOperation =>sendProtocolExchangePacket onResp =>protocol version ".concat(String.valueOf(i)), new Object[0]);
                        if (i > 2) {
                            SpecManager.O000000o.f5247O000000o.O000000o();
                            cmi cmi = this.f14120O000000o;
                            if (cmi != null) {
                                cmi.O000000o(-1015, "app spec protocol version less than device spec protocol version, you must upgrade your mijia app!");
                                return;
                            }
                            return;
                        }
                        cmf.O000000o(this.O00000Oo, this.O00000o0, this.O00000o, this.f14120O000000o);
                    }

                    public final void O000000o(int i, String str) {
                        cnd.O000000o("SpecManager", "bleSpecOperation =>sendProtocolExchangePacket onFail =>(%d,%s)", Integer.valueOf(i), str);
                        cmi cmi = this.f14120O000000o;
                        if (cmi != null) {
                            cmi.O000000o(i, str);
                        }
                    }
                }));
            } else if (i2 > 2) {
                SpecManager.O000000o.f5247O000000o.O000000o();
                r0.O000000o(-1015, "app spec protocol version less than device spec protocol version, you must upgrade your mijia app!");
            } else {
                cmf.O000000o(str, i, str2, r0);
            }
        }

        public String getVirtualGroupStatus(String str) throws RemoteException {
            return fno.O000000o().f16707O000000o.getVirtualGroupStatus(str);
        }

        public void callBleApi(String str, int i, Bundle bundle, final IBleCallback iBleCallback) throws RemoteException {
            new Response.BleCallResponse() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass33 */

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    try {
                        iBleCallback.onResponse(i, (Bundle) obj);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            };
            fpo.O000000o(str, i);
        }

        public void updateDevice(List<String> list, final IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
            fno.O000000o().O000000o(list, new fsm<List<Device>, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass35 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    List<Device> list = (List) obj;
                    if (iPluginCallbackDeviceList != null) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            if (list != null) {
                                for (Device newDeviceStatus : list) {
                                    arrayList.add(DeviceRouterFactory.getDeviceWrapper().newDeviceStatus(newDeviceStatus));
                                }
                            }
                            iPluginCallbackDeviceList.onRequestSuccess(arrayList);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void onFailure(fso fso) {
                    IPluginCallbackDeviceList iPluginCallbackDeviceList = iPluginCallbackDeviceList;
                    if (iPluginCallbackDeviceList != null) {
                        try {
                            iPluginCallbackDeviceList.onRequestFailed(fso.f17063O000000o, fso.O00000Oo);
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void revokePrivacyLicense(String str, final IPluginCallback iPluginCallback) {
            final Device O00000o0 = fno.O000000o().O00000o0(str);
            if (O00000o0 == null) {
                fyc.O00000o0("PluginService", "revokeLicense: device is null,did:".concat(String.valueOf(str)));
            } else {
                DeviceApi.getInstance().setUserLicenseConfig(CommonApplication.getAppContext(), O00000o0.did, "remove", new fsm<String, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass36 */

                    /* JADX WARNING: Removed duplicated region for block: B:20:0x004c A[SYNTHETIC, Splitter:B:20:0x004c] */
                    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        String str = (String) obj;
                        boolean z = false;
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                int optInt = jSONObject.optInt("code");
                                String optString = jSONObject.optString("result");
                                if (optInt == 0 && "ok".equals(optString)) {
                                    try {
                                        AnonymousClass1.this.doAfterRemoveLicenseSuccess(O00000o0);
                                        iPluginCallback.onRequestSuccess(jSONObject.toString());
                                        z = true;
                                    } catch (JSONException e) {
                                        e = e;
                                        z = true;
                                        fyc.O000000o("PluginService", "revokeLicense error:", e);
                                        if (!z) {
                                        }
                                    } catch (RemoteException e2) {
                                        e = e2;
                                        z = true;
                                        fyc.O000000o("PluginService", "revokeLicense error:", e);
                                        if (!z) {
                                        }
                                    }
                                }
                            } catch (JSONException e3) {
                                e = e3;
                                fyc.O000000o("PluginService", "revokeLicense error:", e);
                                if (!z) {
                                }
                            } catch (RemoteException e4) {
                                e = e4;
                                fyc.O000000o("PluginService", "revokeLicense error:", e);
                                if (!z) {
                                }
                            }
                        }
                        if (!z) {
                            try {
                                iPluginCallback.onRequestFailed(-1, "setUserLicenseConfig failed");
                            } catch (RemoteException e5) {
                                e5.printStackTrace();
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        if (fso.f17063O000000o == -7) {
                            AnonymousClass1.this.doAfterRemoveLicenseSuccess(O00000o0);
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("code", -7);
                                jSONObject.put("message", "success");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            try {
                                iPluginCallback.onRequestSuccess(jSONObject.toString());
                            } catch (RemoteException e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            try {
                                iPluginCallback.onRequestFailed(-2, fso.toString());
                            } catch (RemoteException e3) {
                                e3.printStackTrace();
                            }
                        }
                    }
                });
            }
        }

        public void doAfterRemoveLicenseSuccess(Device device) {
            if (device instanceof BleDevice) {
                fob.O000000o((BleDevice) device);
            } else if (device instanceof BleMeshDevice) {
                fob.O000000o(device);
            }
            fno.O000000o().O00000Oo(device);
        }

        public String getPluginProcessName(int i, String str) throws RemoteException {
            return PluginRuntimeManager.getInstance().getPluginProcess(i, str).getValue();
        }

        public String getDevicePincode(String str) throws RemoteException {
            fwk.O000000o(CommonApplication.getAppContext());
            return fwk.O000000o(str, 0);
        }

        public void loadBitmap(String str, final IPluginCallback3 iPluginCallback3) throws RemoteException {
            boolean z;
            try {
                if (Fresco.getImagePipelineFactory() != null) {
                    if (Fresco.getImagePipeline() != null) {
                        z = false;
                        if (z) {
                            gph O000000o2 = gph.O000000o();
                            AnonymousClass37 r3 = new gph.O00000Oo() {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass37 */

                                public final void O000000o(Bitmap bitmap) {
                                    try {
                                        iPluginCallback3.onSuccess(bitmap);
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }

                                public final void O000000o() {
                                    try {
                                        iPluginCallback3.onFailed();
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            };
                            gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "load(): url = ".concat(String.valueOf(str)));
                            if (str == null) {
                                r3.O000000o();
                                return;
                            }
                            int O00000o0 = O000000o2.O00000o0(str);
                            if (O00000o0 < 0) {
                                O000000o2.O000000o(str, r3);
                                return;
                            } else if (O00000o0 == 0) {
                                r3.O000000o();
                                return;
                            } else if (O00000o0 == 1) {
                                String str2 = gph.f18118O000000o + "/" + gph.O00000oO(str);
                                gsy.O000000o(LogType.GENERAL, "ImageDownloadManager", "load(): diskFile = ".concat(String.valueOf(str2)));
                                gor.O000000o(new AsyncTask<Void, Void, Bitmap>(str2, r3) {
                                    /* class _m_j.gph.AnonymousClass2 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ String f18120O000000o;
                                    final /* synthetic */ O00000Oo O00000Oo;

                                    {
                                        this.f18120O000000o = r2;
                                        this.O00000Oo = r3;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final /* synthetic */ Object doInBackground(Object[] objArr) {
                                        return O000000o();
                                    }

                                    /* access modifiers changed from: protected */
                                    public final /* synthetic */ void onPostExecute(Object obj) {
                                        Bitmap bitmap = (Bitmap) obj;
                                        if (bitmap == null) {
                                            this.O00000Oo.O000000o();
                                        } else {
                                            this.O00000Oo.O000000o(bitmap);
                                        }
                                    }

                                    private Bitmap O000000o() {
                                        try {
                                            Bitmap decodeFile = BitmapFactory.decodeFile(this.f18120O000000o);
                                            if (decodeFile != null) {
                                                return decodeFile;
                                            }
                                            try {
                                                LogType logType = LogType.GENERAL;
                                                gsy.O000000o(logType, "ImageDownloadManager", "load(): decode file failed: " + this.f18120O000000o);
                                                if (new File(this.f18120O000000o).delete()) {
                                                    LogType logType2 = LogType.GENERAL;
                                                    gsy.O000000o(logType2, "ImageDownloadManager", "load(): clean success, " + this.f18120O000000o);
                                                    return decodeFile;
                                                }
                                                LogType logType3 = LogType.GENERAL;
                                                gsy.O000000o(logType3, "ImageDownloadManager", "load(): clean failed, " + this.f18120O000000o);
                                                return decodeFile;
                                            } catch (OutOfMemoryError unused) {
                                                return decodeFile;
                                            }
                                        } catch (OutOfMemoryError unused2) {
                                            return null;
                                        }
                                    }
                                }, new Void[0]);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).build(), null).subscribe(new BaseBitmapDataSubscriber() {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass38 */

                                public final void onNewResultImpl(Bitmap bitmap) {
                                    try {
                                        iPluginCallback3.onSuccess(bitmap);
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }

                                public final void onFailureImpl(DataSource dataSource) {
                                    try {
                                        iPluginCallback3.onFailed();
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }, goq.O000000o());
                            return;
                        }
                    }
                }
                iPluginCallback3.onFailed();
            } catch (Exception e) {
                e.printStackTrace();
                z = true;
            }
        }

        public void sendPluginAdRequest(String str, String str2) throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            O000000o2.f15956O000000o = str;
            O000000o2.O000000o(str);
            O000000o2.O0000O0o.post(new Runnable(CoreApi.O000000o().O0000Oo(str)) {
                /* class _m_j.eyv.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ PluginPackageInfo f15957O000000o;

                {
                    this.f15957O000000o = r2;
                }

                public final void run() {
                    eyw.O000000o().O000000o(CommonApplication.getAppContext(), new fsm<List<AdPosition>, fso>() {
                        /* class _m_j.eyv.AnonymousClass1.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            List<AdPosition> list = (List) obj;
                            try {
                                eyv eyv = eyv.this;
                                if (!list.isEmpty()) {
                                    eyv.O00000oO.addAll(list);
                                    if (eyv.O00000o0 != null) {
                                        if (eyv.O00000o != null) {
                                            AdPosition adPosition = null;
                                            AdPosition adPosition2 = null;
                                            for (AdPosition next : eyv.O00000oO) {
                                                if (next.O00000Oo.size() > 0 && "bottomPop".equals(next.O00000Oo.get(0).O00000o0)) {
                                                    adPosition2 = next;
                                                } else if (next.O00000Oo.size() > 0 && "pop".equals(next.O00000Oo.get(0).O00000o0)) {
                                                    adPosition = next;
                                                }
                                            }
                                            if (adPosition != null && eyv.O000000o(adPosition) && adPosition2 != null && eyv.O000000o(adPosition2)) {
                                                if (eyy.O000000o(adPosition).O0000Oo0 >= eyy.O000000o(adPosition2).O0000Oo0) {
                                                    eyv.O00000o0.onQueryAdSuccess(adPosition);
                                                } else {
                                                    eyv.O00000o.onQueryAdSuccess(adPosition2);
                                                }
                                            } else if (adPosition != null && eyv.O000000o(adPosition)) {
                                                eyv.O00000o0.onQueryAdSuccess(adPosition);
                                            } else if (adPosition2 != null && eyv.O000000o(adPosition2)) {
                                                eyv.O00000o.onQueryAdSuccess(adPosition2);
                                            }
                                            eyv.O00000o0 = null;
                                            eyv.O00000o = null;
                                        }
                                    }
                                    for (AdPosition adPosition3 : list) {
                                        if (eyv.O00000Oo.containsKey(adPosition3.f4148O000000o)) {
                                            eyv.O00000Oo.get(adPosition3.f4148O000000o).onQueryAdSuccess(adPosition3);
                                            eyv.O00000Oo.remove(adPosition3.f4148O000000o);
                                        }
                                    }
                                }
                            } catch (RemoteException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
        }

        public void stopPluginAd(String str) throws RemoteException {
            eyv.O000000o(CommonApplication.getAppContext()).O000000o(str);
        }

        public void queryAd(String str, String str2, IAdCallback iAdCallback) throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            if ("com.xiaomi.popAd".equals(str2)) {
                O000000o2.O00000o0 = iAdCallback;
            } else if ("com.xiaomi.bottomFlowAd".equals(str2)) {
                O000000o2.O00000o = iAdCallback;
            } else if (!str.equals(O000000o2.f15956O000000o)) {
            } else {
                if (O000000o2.O00000oO.isEmpty()) {
                    O000000o2.O00000Oo.put(str2, iAdCallback);
                    return;
                }
                for (AdPosition next : O000000o2.O00000oO) {
                    if (str2.equals(next.f4148O000000o) && O000000o2.O000000o(next)) {
                        iAdCallback.onQueryAdSuccess(next);
                        return;
                    }
                }
                iAdCallback.onQueryAdFail();
            }
        }

        public void reportAdShow(Advertisement advertisement) throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            SharedPreferences.Editor edit = O000000o2.O00000oo.f4146O000000o.edit();
            edit.putBoolean("show_" + String.valueOf(advertisement.f4149O000000o), true);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
            edit.putString("show_" + advertisement.f4149O000000o + "date_", simpleDateFormat.format(new Date()));
            edit.apply();
            eyw.O000000o();
            eyw.O000000o(O000000o2.f15956O000000o);
        }

        public void reportAdClick() throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            eyw.O000000o();
            eyw.O000000o("Operation", O000000o2.f15956O000000o, "PluginOperateClick");
        }

        public void reportAdClose(Advertisement advertisement) throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            SharedPreferences.Editor edit = O000000o2.O00000oo.f4146O000000o.edit();
            edit.putBoolean("close_" + String.valueOf(advertisement.f4149O000000o), true);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd", Locale.getDefault());
            edit.putString("close_" + advertisement.f4149O000000o + "date_", simpleDateFormat.format(new Date()));
            edit.apply();
            eyw.O000000o();
            eyw.O000000o("Operation", O000000o2.f15956O000000o, "PluginOperateClose");
        }

        public void reportHotSpotShow() throws RemoteException {
            eyv O000000o2 = eyv.O000000o(CommonApplication.getAppContext());
            eyw.O000000o();
            eyw.O000000o(O000000o2.f15956O000000o);
        }

        public void getDeviceRealIconByModel(String str, IPluginCallback3 iPluginCallback3) throws RemoteException {
            PluginDeviceInfo O00000oO;
            if (str != null && (O00000oO = CoreApi.O000000o().O00000oO(str)) != null && O00000oO.O0000o0() != null) {
                loadBitmap(O00000oO.O0000o0(), iPluginCallback3);
            }
        }

        public void delDeviceBatch(List<String> list, final IPluginCallback iPluginCallback) throws RemoteException {
            final List<String> delFolderPathBatch = hmq.O000000o().getDelFolderPathBatch(list);
            fno.O000000o().O000000o(list, CommonApplication.getAppContext(), new fno.O00000Oo() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass39 */

                public final void O000000o() {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException unused) {
                        }
                        hmq.O000000o().delDataAfterDelDevice(delFolderPathBatch);
                    }
                }

                public final void O000000o(fso fso) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestFailed(fso.f17063O000000o, fso.O00000Oo);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            });
        }

        public void openCameraFloatingWindow(String str) throws RemoteException {
            Intent intent = new Intent("miui.action_open_floating_window");
            intent.setPackage("com.xiaomi.smarthome");
            CommonApplication.getAppContext().sendBroadcast(intent);
            CommonApplication.getGlobalHandler().postDelayed(new Runnable(str) {
                /* class com.xiaomi.smarthome.framework.plugin.$$Lambda$PluginService$1$JcaJlnjenn1rWBPYaGqnGHbpNVc */
                private final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final void run() {
                    PluginService.AnonymousClass1.lambda$openCameraFloatingWindow$0(this.f$0);
                }
            }, 800);
        }

        static /* synthetic */ void lambda$openCameraFloatingWindow$0(String str) {
            String childDid;
            Device O00000o0 = fno.O000000o().O00000o0(str);
            CameraRouterFactory.getCameraManagerApi().removeFloatWindow(true);
            if (O00000o0 == null && (childDid = DeviceModelManager.getChildDid(str)) != null) {
                O00000o0 = fno.O000000o().O00000o0(childDid);
            }
            if (O00000o0 != null) {
                CameraRouterFactory.getCameraManagerApi().addFloatWindow(O00000o0);
            }
        }

        public void closeCameraFloatingWindow(String str) throws RemoteException {
            CommonApplication.getGlobalHandler().post($$Lambda$PluginService$1$UXbremoINQHfufBjNSarDzfW30E.INSTANCE);
        }

        public String getDevicePropByDid(String str) throws RemoteException {
            JSONArray O000000o2 = frd.O000000o(str);
            if (O000000o2 == null) {
                return null;
            }
            return O000000o2.toString();
        }

        public boolean checkVoiceCtrlAuthorized(String str) throws RemoteException {
            return hsl.O00000Oo().checkVoiceCtrlAuthorized(str);
        }

        public boolean checkIfVoiceCtrlAuthorizedExpired(String str) throws RemoteException {
            return hsl.O00000Oo().checkVoiceCtrlAuthorized(str);
        }

        public boolean isUsrExpPlanEnabled(String str) {
            return fsl.O000000o(PluginService.this.getApplicationContext(), str);
        }

        public void setUsrExpPlanEnabled(String str, boolean z) {
            fsl.O000000o(PluginService.this.getApplicationContext(), str, z);
        }

        public void getWatchControllableDevices(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            gnk.O00000o0(String.format("getWatchControllableDevices for %s", str));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", CommonApplication.getAppContext().getResources().getConfiguration().locale.getLanguage().equals("zh") ? "zh_CN" : "en");
                jSONObject.put("name", "watchconfig");
                jSONObject.put("version", "1");
            } catch (JSONException unused) {
                if (iPluginCallback != null) {
                    iPluginCallback.onRequestFailed(-1, "params invalid");
                }
            }
            gsj gsj = null;
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj = o000000o.O00000Oo(PluginService.this.buildUrl(jSONObject)).O000000o();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (gsj != null) {
                gsg.O00000Oo(gsj, new gsl() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass40 */

                    public final void onFailure(gsf gsf, Exception exc, okhttp3.Response response) {
                    }

                    public final void onSuccess(Object obj, okhttp3.Response response) {
                    }

                    public final void processFailure(Call call, IOException iOException) {
                    }

                    public final void processResponse(okhttp3.Response response) {
                        try {
                            JSONObject jSONObject = new JSONObject(response.body().string());
                            if (!jSONObject.isNull("result")) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("content");
                                    if (!TextUtils.isEmpty(optString)) {
                                        iPluginCallback.onRequestSuccess(optString);
                                        return;
                                    }
                                }
                                iPluginCallback.onRequestFailed(-1, null);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            }
        }

        public boolean checkIfSupportVoiceCtrl(String str) throws RemoteException {
            return hsl.O00000Oo().checkIfSupportVoiceCtrl(str);
        }

        public void isBleGatewayExistInDeviceList(IBleCallback iBleCallback) throws RemoteException {
            boolean z;
            int i;
            boolean z2;
            Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
            while (true) {
                z = true;
                i = 0;
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                Device device = (Device) it.next().getValue();
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
                if (device.isOwner() && O00000oO != null && O00000oO.O000O0OO() == 1) {
                    if (device instanceof MiioDeviceV2) {
                        String str = ((MiioDeviceV2) device).mFwVersion;
                        List<fcg> list = fbv.O000000o().O00000o0;
                        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                            Iterator<fcg> it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                fcg next = it2.next();
                                if (TextUtils.equals(next.f16080O000000o, device.model)) {
                                    if (fpo.O000000o(str, next.O00000Oo) < 0) {
                                        z2 = false;
                                    }
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        break;
                    }
                }
            }
            if (iBleCallback != null) {
                if (!z) {
                    i = -1;
                }
                iBleCallback.onResponse(i, null);
            }
        }

        public List<DeviceStatus> getFilterBluetoothDeviceList(String str) throws RemoteException {
            List<DeviceStatus> arrayList = new ArrayList<>();
            if (!TextUtils.isEmpty(str)) {
                Iterator<Map.Entry<String, List<String>>> it = fbx.O000000o().f16054O000000o.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    List list = (List) next.getValue();
                    if (TextUtils.equals(str, (String) next.getKey())) {
                        arrayList = getDeviceListV2(list);
                        break;
                    }
                }
            }
            for (DeviceStatus next2 : arrayList) {
                next2.O0000OoO = "";
                next2.O00000oo = "";
                next2.O0000o0 = 0.0d;
                next2.O0000o0O = 0.0d;
            }
            return arrayList;
        }

        public List<DeviceStatus> getBleGatewayDeviceList() {
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
                Device device = (Device) value.getValue();
                PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(device.model);
                if (device.isOwner() && O00000oO != null) {
                    boolean z = true;
                    if (O00000oO.O000O0OO() == 1) {
                        if (device instanceof MiioDeviceV2) {
                            String str = ((MiioDeviceV2) device).mFwVersion;
                            List<fcg> list = fbv.O000000o().O00000o0;
                            if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                                Iterator<fcg> it = list.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    fcg next = it.next();
                                    if (TextUtils.equals(next.f16080O000000o, device.model)) {
                                        if (fpo.O000000o(str, next.O00000Oo) < 0) {
                                            z = false;
                                        }
                                    }
                                }
                            }
                        }
                        if (z) {
                            DeviceStatus deviceStatus = new DeviceStatus();
                            copyDevicsStatus(deviceStatus, device);
                            arrayList.add(deviceStatus);
                        }
                    }
                }
            }
            return arrayList;
        }

        public String getSpecInstanceStr(String str) {
            return faw.O000000o().getSpecInstanceStr(str);
        }

        public String getSpecProptyValueFromSpecCard(String str) {
            return faw.O000000o().getSpecProptyValueStr(str);
        }

        public void onRNRuntimeReuseDisable(int i) {
            PluginRuntimeManager.getInstance().setRNProcessReuseDisable(i);
        }

        public void getBleGatewaySubDevices(List<String> list, final IPluginCallbackDeviceList iPluginCallbackDeviceList) throws RemoteException {
            BleGatewayManager.O000000o(list, new BleGatewayManager.O00000Oo() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass41 */

                public final void O000000o(List<BleGatewayManager.O000000o> list) {
                    List<BleGatewayManager.O000000o> list2 = list;
                    if (list2 == null || list.size() == 0) {
                        try {
                            iPluginCallbackDeviceList.onRequestSuccess(new ArrayList());
                        } catch (RemoteException e) {
                            gsy.O000000o(6, "PluginService", "getBleGatewaySubDevices..." + e.toString());
                        }
                    } else {
                        int size = list.size();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < size; i++) {
                            if (list2.get(i) != null) {
                                ArrayList<BleGatewayManager.BleGatewayItem> arrayList2 = list2.get(i).O00000Oo;
                                String str = list2.get(i).f7099O000000o;
                                if (arrayList2 != null && arrayList2.size() > 0) {
                                    int size2 = arrayList2.size();
                                    for (int i2 = 0; i2 < size2; i2++) {
                                        Device O000000o2 = fno.O000000o().O000000o(arrayList2.get(i2).f7098O000000o);
                                        if (O000000o2 != null) {
                                            O000000o2.rssi = arrayList2.get(i2).O00000Oo;
                                            if (!BleGatewayManager.O000000o(list2.get(i).f7099O000000o) || !(O000000o2.pid == Device.PID_BLE_MESH || O000000o2.pid == Device.PID_VIRTUAL_GROUP)) {
                                                if (O000000o2.property == null) {
                                                    O000000o2.property = new Bundle();
                                                }
                                                O000000o2.property.putString("deviceGatewayType", "normal");
                                            } else {
                                                if (O000000o2.property == null) {
                                                    O000000o2.property = new Bundle();
                                                }
                                                O000000o2.property.putString("deviceGatewayType", "mesh");
                                            }
                                            DeviceStatus newDeviceStatus = DeviceRouterFactory.getDeviceWrapper().newDeviceStatus(O000000o2);
                                            newDeviceStatus.O0000O0o = str;
                                            arrayList.add(newDeviceStatus);
                                        }
                                    }
                                }
                            }
                        }
                        try {
                            iPluginCallbackDeviceList.onRequestSuccess(arrayList);
                        } catch (RemoteException e2) {
                            gsy.O000000o(6, "PluginService", "getBleGatewaySubDevices..." + e2.toString());
                        }
                    }
                }
            });
        }

        public void initBandManager(String str, String str2, final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().initBandManager(PluginService.this.getApplicationContext(), str, str2, new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass42 */

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void deInitBandManager() throws RemoteException {
            hmq.O00000Oo().deInitBandManager();
        }

        public void connectBand(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().connectBand(str, new Callback<Integer>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass43 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    try {
                        iPluginCallback.onRequestSuccess(String.valueOf((Integer) obj));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void getAllCards(final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().getAllNfcCards(new Callback<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass44 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    try {
                        iPluginCallback.onRequestSuccess((String) obj);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public void issueDoorCard(final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().issueDoorCard(new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass46 */

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void deleteCard(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().deleteCard(str, new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass47 */

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void setDefaultCard(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().setDefaultCard(str, new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass48 */

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void updateCard(String str, final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().updateCard(str, new Callback<Boolean>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass49 */

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess("");
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }

        public void getDefaultCardAndActivateInfo(final IPluginCallback iPluginCallback) throws RemoteException {
            hmq.O00000Oo().getDefaultCardAndActivateInfo(new Callback<WritableArray>() {
                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass50 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    WritableArray writableArray = (WritableArray) obj;
                    IPluginCallback iPluginCallback = iPluginCallback;
                    if (iPluginCallback != null) {
                        try {
                            iPluginCallback.onRequestSuccess(writableArray.toString());
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }

                public final void onFailure(int i, String str) {
                    try {
                        iPluginCallback.onRequestFailed(i, str);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        public int getUsePreviewConfig() throws RemoteException {
            return gfr.O0000oo0 ? 1 : 0;
        }

        public void statReport(String str, String str2, String str3) throws RemoteException {
            try {
                hxi.O0000Ooo.O000000o(str, str2, (Map) new Gson().fromJson(str3, new TypeToken<HashMap<String, Object>>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass51 */
                }.getType()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String getQrDebugModePackageName() throws RemoteException {
            return hmq.O000000o().getQrDebugModePackageName();
        }

        public List<DeviceStatus> getCurrentHomeDevicesWithPid(int i) throws RemoteException {
            List<Device> O0000Oo = ggb.O00000Oo().O0000Oo(ggb.O00000Oo().O0000OOo());
            if (O0000Oo.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(O0000Oo.size());
            for (Device next : O0000Oo) {
                if (next != null && next.pid == i) {
                    DeviceStatus deviceStatus = new DeviceStatus();
                    copyDevicsStatus(deviceStatus, next);
                    arrayList.add(deviceStatus);
                }
            }
            return arrayList;
        }

        public List<DeviceStatus> getCurrentHomeDevicesWithModel(String str) throws RemoteException {
            List<Device> O0000Oo = ggb.O00000Oo().O0000Oo(ggb.O00000Oo().O0000OOo());
            if (O0000Oo.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(O0000Oo.size());
            for (Device next : O0000Oo) {
                if (next != null && !TextUtils.isEmpty(str) && next.model.equalsIgnoreCase(str)) {
                    DeviceStatus deviceStatus = new DeviceStatus();
                    copyDevicsStatus(deviceStatus, next);
                    arrayList.add(deviceStatus);
                }
            }
            return arrayList;
        }

        public boolean getFreqCameraRedDotVisible() {
            if (!gfx.O000000o().O00000Oo()) {
                return false;
            }
            List<Device> O0000oOO = ggb.O00000Oo().O0000oOO(ggb.O00000Oo().O0000OOo());
            if (O0000oOO.size() > 0) {
                for (int i = 0; i < O0000oOO.size(); i++) {
                    if ((O0000oOO.get(i).comFlag & 2) == 2) {
                        return false;
                    }
                }
            }
            return true;
        }

        public void setFreqCameraRedDotVisible(boolean z) {
            gfx.O000000o().O000000o(z);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean
         arg types: [android.content.Context, java.lang.String, int]
         candidates:
          _m_j.gpv.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
          _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, java.lang.String):java.lang.String
          _m_j.gpv.O000000o(android.content.Context, java.lang.String, int):void
          _m_j.gpv.O000000o(android.content.Context, java.lang.String, long):void
          _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String, boolean):void
          _m_j.gpv.O000000o(android.content.Context, java.lang.String, boolean):boolean */
        public boolean isRNPluginDarkMode() throws RemoteException {
            return gpv.O000000o(CommonApplication.getAppContext(), "lab_rn_plugin_darkmode", false);
        }

        public String getOauthUserId() {
            return gty.O000000o().getOauthUserId();
        }

        public String getOauthServiceToken() {
            return gty.O000000o().getOauthServiceToken();
        }

        public void invalideOauthServiceToken() {
            gty.O000000o().invalideOauthServiceToken();
        }

        public void sendFeedbackLog(final String str, final String str2) {
            if (!TextUtils.isEmpty(str2)) {
                fuh.O000000o().O000000o(CommonApplication.getAppContext(), "feedback", "zip", new fsm<fuo, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass52 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
                     arg types: [java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int, com.xiaomi.smarthome.framework.plugin.PluginService$1$56$1]
                     candidates:
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        fuo fuo = (fuo) obj;
                        if (fuo != null) {
                            Device device = null;
                            String str = "";
                            if (!TextUtils.isEmpty(str) && (device = fno.O000000o().O000000o(str)) != null) {
                                str = device.model;
                            }
                            String str2 = str;
                            CoreApi.O000000o().O000000o(fuo.f17193O000000o, str2, (String[]) null, true, (IClientCallback) new IClientCallback.Stub(device, str2, fuo) {
                                /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass56.AnonymousClass1 */
                                final /* synthetic */ Device val$finalDevice;
                                final /* synthetic */ String val$finalModel;
                                final /* synthetic */ fuo val$uploadUserData;

                                {
                                    this.val$finalDevice = r2;
                                    this.val$finalModel = r3;
                                    this.val$uploadUserData = r4;
                                }

                                public void onSuccess(Bundle bundle) throws RemoteException {
                                    AnonymousClass1.this.sendFeedBack(this.val$finalDevice, this.val$finalModel, str2, this.val$uploadUserData.O00000Oo);
                                }

                                public void onFailure(Bundle bundle) throws RemoteException {
                                    gsy.O000000o(6, "PluginService", "sendFeedbackLog: error=".concat(String.valueOf(bundle)));
                                }
                            });
                        }
                    }

                    public final void onFailure(fso fso) {
                        gsy.O000000o(6, "PluginService", "getUploadUserfileUrl: error=".concat(String.valueOf(fso)));
                    }
                });
            }
        }

        /* access modifiers changed from: package-private */
        public void sendFeedBack(Device device, String str, String str2, String str3) {
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                hyv.O000000o().sendFeedBack2(device, str, str3, "", str2, "", null, null, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.PluginService.AnonymousClass1.AnonymousClass53 */

                    public final void onFailure(fso fso) {
                        gsy.O000000o(6, "PluginService", "sendFeedBack: error=".concat(String.valueOf(fso)));
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        gsy.O000000o(3, "PluginService", "sendFeedBack: success");
                    }
                });
            }
        }
    };

    public String buildUrl(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    static void O000000o(IPluginCallback iPluginCallback, String str) {
        if (iPluginCallback != null) {
            try {
                iPluginCallback.onRequestSuccess(str);
            } catch (RemoteException unused) {
            }
        }
    }

    static void O000000o(IPluginCallback iPluginCallback, int i, String str) {
        if (iPluginCallback != null) {
            try {
                iPluginCallback.onRequestFailed(i, str);
            } catch (RemoteException unused) {
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.O00000Oo;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    static class O000000o implements fno.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Device f8118O000000o;
        IPluginCallback O00000Oo;

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        O000000o(Device device, IPluginCallback iPluginCallback) {
            this.f8118O000000o = device;
            this.O00000Oo = iPluginCallback;
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (3 == i && this.f8118O000000o != null && fno.O000000o().O000000o(this.f8118O000000o.did) != null) {
                fno.O000000o().O00000Oo(this);
                IPluginCallback iPluginCallback = this.O00000Oo;
                if (iPluginCallback != null) {
                    try {
                        iPluginCallback.onRequestSuccess("");
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
