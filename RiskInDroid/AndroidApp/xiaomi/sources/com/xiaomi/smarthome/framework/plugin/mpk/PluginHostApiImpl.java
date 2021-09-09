package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.dgm;
import _m_j.die;
import _m_j.dxx;
import _m_j.etx;
import _m_j.fap;
import _m_j.faw;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.ffr;
import _m_j.fno;
import _m_j.foe;
import _m_j.fqv;
import _m_j.frj;
import _m_j.frk;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.ftd;
import _m_j.ftn;
import _m_j.fuh;
import _m_j.fui;
import _m_j.fwq;
import _m_j.gdt;
import _m_j.gdv;
import _m_j.gku;
import _m_j.gky;
import _m_j.gnk;
import _m_j.gno;
import _m_j.god;
import _m_j.goe;
import _m_j.gof;
import _m_j.gpn;
import _m_j.gpy;
import _m_j.gsc;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gwb;
import _m_j.hfd;
import _m_j.hor;
import _m_j.hsk;
import _m_j.hsl;
import _m_j.iaj;
import _m_j.icy;
import _m_j.idd;
import _m_j.idf;
import _m_j.idm;
import _m_j.idt;
import _m_j.igv;
import _m_j.igw;
import _m_j.ind;
import _m_j.ing;
import _m_j.inj;
import _m_j.jfr;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import com.google.gson.Gson;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.plugin.core.XmPluginPackage;
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
import com.xiaomi.smarthome.aitraining.AiTrainingWebActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothRecord;
import com.xiaomi.smarthome.camera.HLSDownloader;
import com.xiaomi.smarthome.camera.IXmConnectionClient;
import com.xiaomi.smarthome.camera.IXmStreamClient;
import com.xiaomi.smarthome.camera.XmAAcCodec;
import com.xiaomi.smarthome.camera.XmCameraP2p;
import com.xiaomi.smarthome.camera.XmMp4Record;
import com.xiaomi.smarthome.camera.XmP2PInfo;
import com.xiaomi.smarthome.camera.XmVideoViewGl;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.camera.exopackage.MJExoPlayer;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.ModifyGroupActivity;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.BtFirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.BtFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.DeviceTag;
import com.xiaomi.smarthome.device.api.FirmwareUpdateInfo;
import com.xiaomi.smarthome.device.api.ICloudDataCallback;
import com.xiaomi.smarthome.device.api.KeyValuePair;
import com.xiaomi.smarthome.device.api.McuUpdateInfo;
import com.xiaomi.smarthome.device.api.MessageCallback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.ProductInfo;
import com.xiaomi.smarthome.device.api.RoomStat;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.UserInfo;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.api.printer.PrinterControl;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.device.api.spec.operation.controller.DeviceController;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.AlwaysDeniedPermissionDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.plugin.Error;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginSubscribeCallback;
import com.xiaomi.smarthome.plugin.devicesubscribe.PluginUnSubscribeCallback;
import com.xiaomi.smarthome.printer.SmartPrinterRouterFactory;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.zxing.BarcodeFormat;
import com.xiaomi.zxing.EncodeHintType;
import com.xiaomi.zxing.WriterException;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import okhttp3.Call;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginHostApiImpl extends PluginHostApi {
    private static volatile frk mDownloadManager;
    IWXAPI wxapi;

    public class AjcClosure1 extends jfr {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return PluginHostApiImpl.openConnection_aroundBody0((PluginHostApiImpl) objArr2[0], (URL) objArr2[1]);
        }
    }

    public class AjcClosure3 extends jfr {
        public AjcClosure3(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return PluginHostApiImpl.openConnection_aroundBody2((PluginHostApiImpl) objArr2[0], (URL) objArr2[1]);
        }
    }

    public class AjcClosure5 extends jfr {
        public AjcClosure5(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            return PluginHostApiImpl.openConnection_aroundBody4((PluginHostApiImpl) objArr2[0], (URL) objArr2[1]);
        }
    }

    static /* synthetic */ void lambda$getServerName$2() throws Exception {
    }

    public int getDrawableResIdByName(XmPluginPackage xmPluginPackage, String str) {
        return R.drawable.mj_ic_launcher;
    }

    public int getMiHomeNotificationIcon() {
        return R.drawable.mj_ic_launcher;
    }

    public boolean stopService(Intent intent, XmPluginPackage xmPluginPackage, Class cls) {
        return false;
    }

    public PluginHostApiImpl(Context context) {
        super(context);
        initRequest();
    }

    public String getPluginProcess(int i, String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            return etx.O000000o().O00000Oo().getPluginProcessName(i, str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void ensureService(Callback callback) {
        etx.O000000o().O000000o(new etx.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.$$Lambda$PluginHostApiImpl$KAzYTCJYbwofw45jiC6ecdnMQg */

            public final void onBindService(IPluginRequest iPluginRequest) {
                Callback.this.onSuccess(null);
            }
        });
    }

    private void initRequest() {
        try {
            etx.O000000o().O00000Oo();
        } catch (Exception e) {
            e.printStackTrace();
            gsy.O00000o0(LogType.GENERAL, "", e.getMessage());
            if (!ftn.O00000oO(context())) {
                String str = "PluginHostApiImpl.initRequest:" + e.getMessage();
                if (str == null) {
                    str = "null";
                }
                if (dgm.O00000o0) {
                    Log.e("pluginserver", str);
                }
                die.O000000o("E", "pluginserver", str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Application application() {
        return CommonApplication.getApplication();
    }

    public Context context() {
        return CommonApplication.getAppContext();
    }

    public Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper == null ? Looper.getMainLooper() : myLooper;
    }

    public <T> void handlerSuccess(final Callback<T> callback, final T t, Looper looper) {
        gsy.O000000o(3, "XmPluginHostApiImpl", "handlerSuccess");
        if (callback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass1 */

                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(t);
                    }
                }
            });
        }
    }

    public <T> void handlerFailed(final Callback<T> callback, final int i, final String str, Looper looper) {
        gsy.O000000o(3, "XmPluginHostApiImpl", "handlerFailed");
        if (callback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass2 */

                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(i, str);
                    }
                }
            });
        }
    }

    public <T> void callHttpApi(String str, String str2, String str3, List<NameValuePair> list, Callback<T> callback, Parser<T> parser) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (NameValuePair next : list) {
                arrayList.add(new gky(next.getName(), next.getValue()));
            }
        }
        gof.O000000o(str2, str3, arrayList, callback, parser);
    }

    public <T> void callHttpApiV13(String str, String str2, String str3, List<KeyValuePair> list, Callback<T> callback, Parser<T> parser) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (KeyValuePair next : list) {
                arrayList.add(new gky(next.getKey(), next.getValue()));
            }
            gof.O000000o(str2, str3, arrayList, callback, parser);
        }
    }

    public List<DeviceStat> getDeviceList() {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            List<DeviceStatus> deviceList = etx.O000000o().O00000Oo().getDeviceList();
            if (deviceList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : deviceList) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public PrinterControl getPrinterControl() {
        return SmartPrinterRouterFactory.getPrinterControl();
    }

    public List<DeviceStat> getDeviceListV2(List<String> list) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            List<DeviceStatus> deviceListV2 = etx.O000000o().O00000Oo().getDeviceListV2(list);
            if (deviceListV2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : deviceListV2) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public List<RoomStat> getRoomAll() {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                List<RoomStatus> roomAll = O00000Oo.getRoomAll();
                if (roomAll != null) {
                    ArrayList arrayList = new ArrayList();
                    for (RoomStatus O000000o2 : roomAll) {
                        arrayList.add(O000000o2.O000000o());
                    }
                    return arrayList;
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return Collections.emptyList();
    }

    public void deleteRoom(List<String> list, final Callback<Void> callback) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.deleteRooms(list, new IPluginCallback2.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass3 */

                    public void onRequestSuccess(Intent intent) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onSuccess(null);
                        }
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void renameRoom(String str, String str2, final Callback<Void> callback) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.roomRename(str, str2, new IPluginCallback2.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass4 */

                    public void onRequestSuccess(Intent intent) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onSuccess(null);
                        }
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void addRoom(final RoomStat roomStat, final Callback<RoomStat> callback) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            RoomStatus roomStatus = new RoomStatus();
            if (roomStat != null) {
                roomStatus.O00000o = roomStat.name;
                roomStatus.O0000OOo = roomStat.icon;
                roomStatus.f6613O000000o = roomStat.bssid;
                roomStatus.O00000oO = roomStat.parentid;
                roomStatus.O0000O0o = roomStat.dids;
            }
            try {
                O00000Oo.addRoom(roomStatus, new IPluginCallbackRoomStatus.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass5 */

                    public void onRequestSuccess(RoomStatus roomStatus) throws RemoteException {
                        if (roomStatus != null) {
                            callback.onSuccess(roomStatus.O000000o());
                        } else {
                            callback.onSuccess(roomStat);
                        }
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                gsy.O000000o(6, "PluginHostApi", "addRoom  " + e.toString());
            }
        }
    }

    public DeviceStat getDeviceByDid(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                DeviceStatus device = etx.O000000o().O00000Oo().getDevice(str);
                if (device != null) {
                    return device.O000000o();
                }
            } catch (RemoteException e) {
                gsy.O000000o(6, "XmPluginHostApiImpl", "RemoteException:" + e.getLocalizedMessage());
            }
        }
        if (MockRnDevicePluginManager.getInstance().didIsMockDid(str)) {
            return MockRnDevicePluginManager.getInstance().getMockDeviceStat(str);
        }
        return null;
    }

    public DeviceTag getDeviceTagByDid(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            DeviceTagInfo deviceTagInfo = etx.O000000o().O00000Oo().getDeviceTagInfo(str);
            if (deviceTagInfo == null) {
                return null;
            }
            DeviceTag deviceTag = new DeviceTag();
            deviceTag.infoJson = deviceTagInfo.f6612O000000o;
            return deviceTag;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public String getLightDeviceGroupModel(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                return etx.O000000o().O00000Oo().getLightDeviceGroupModel(str);
            } catch (RemoteException e) {
                gsy.O000000o(6, "XmPluginHostApiImpl", "getLightDeviceGroupModel error:" + Log.getStackTraceString(e));
            }
        }
        return "";
    }

    public void addTag(String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().addTag(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeTag(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().removeTag(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public List<DeviceStat> getSubDeviceByParentDid(String str) {
        if (!TextUtils.isEmpty(str) && etx.O000000o().O00000Oo() != null) {
            try {
                List<DeviceStatus> subDeviceByParentDid = etx.O000000o().O00000Oo().getSubDeviceByParentDid(str);
                if (subDeviceByParentDid != null) {
                    ArrayList arrayList = new ArrayList();
                    for (DeviceStatus O000000o2 : subDeviceByParentDid) {
                        arrayList.add(O000000o2.O000000o());
                    }
                    return arrayList;
                }
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.addRecord(java.lang.String, java.lang.String, java.lang.Object, org.json.JSONObject):void
     arg types: [java.lang.String, java.lang.String, int, ?[OBJECT, ARRAY]]
     candidates:
      com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.addRecord(com.xiaomi.plugin.core.XmPluginPackage, java.lang.String, java.lang.Object, org.json.JSONObject):void
      com.xiaomi.smarthome.device.api.XmPluginHostApi.addRecord(com.xiaomi.plugin.core.XmPluginPackage, java.lang.String, java.lang.Object, org.json.JSONObject):void
      com.xiaomi.smarthome.frame.plugin.host.PluginHostApi.addRecord(java.lang.String, java.lang.String, java.lang.Object, org.json.JSONObject):void */
    public void recordCountEvent(String str, String str2) {
        addRecord(str, str2, (Object) 1, (JSONObject) null);
    }

    public void recordCountEvent(String str, String str2, Map<String, String> map) {
        addRecord(str, str2, map, (JSONObject) null);
    }

    public void recordCalculateEvent(String str, String str2, long j) {
        addRecord(str, str2, Long.valueOf(j), (JSONObject) null);
    }

    public void recordCalculateEvent(String str, String str2, long j, Map<String, String> map) {
        addRecord(str, str2, Long.valueOf(j), (JSONObject) null);
    }

    public void recordStringPropertyEvent(String str, String str2, String str3) {
        addRecord(str, str2, str3, (JSONObject) null);
    }

    public void recordNumericPropertyEvent(String str, String str2, long j) {
        addRecord(str, str2, Long.valueOf(j), (JSONObject) null);
    }

    public void subscribeDevice(String str, int i, List<String> list, int i2, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass6 r6 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass6 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().subscribeDevice(str, i, list, i2, r6);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void unsubscribeDevice(String str, int i, List<String> list, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass7 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass7 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().unsubscribeDevice(str, i, list, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public Looper getCallbackLooper(Looper looper) {
        return looper == null ? Looper.getMainLooper() : looper;
    }

    public void subscribeDeviceV2(String str, int i, List<String> list, int i2, final PluginSubscribeCallback pluginSubscribeCallback) {
        final Looper looper = getLooper();
        AnonymousClass8 r6 = new IPluginCallback2.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass8 */

            public void onRequestSuccess(Intent intent) throws RemoteException {
                String stringExtra = intent.getStringExtra("subscribeDeviceV2_flag");
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (stringExtra.equalsIgnoreCase("onSuccess")) {
                        final String stringExtra2 = intent.getStringExtra("subscribeDeviceV2_subid");
                        if (pluginSubscribeCallback != null) {
                            new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass8.AnonymousClass1 */

                                public void run() {
                                    pluginSubscribeCallback.onSuccess(stringExtra2);
                                }
                            });
                        }
                    } else if (stringExtra.equalsIgnoreCase("onReceive")) {
                        final String stringExtra3 = intent.getStringExtra("subscribeDeviceV2_did");
                        final String stringExtra4 = intent.getStringExtra("subscribeDeviceV2_model");
                        final JSONArray jSONArray = null;
                        try {
                            jSONArray = new JSONArray(intent.getStringExtra("subscribeDeviceV2_entry"));
                        } catch (JSONException unused) {
                        }
                        if (pluginSubscribeCallback != null) {
                            new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass8.AnonymousClass2 */

                                public void run() {
                                    pluginSubscribeCallback.onReceive(stringExtra3, stringExtra4, jSONArray);
                                }
                            });
                        }
                    }
                }
            }

            public void onRequestFailed(final int i, final String str) throws RemoteException {
                if (pluginSubscribeCallback != null) {
                    new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass8.AnonymousClass3 */

                        public void run() {
                            pluginSubscribeCallback.onFailure(new Error(i, str));
                        }
                    });
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().subscribeDeviceV2(str, i, list, i2, r6);
            } else if (pluginSubscribeCallback != null) {
                pluginSubscribeCallback.onFailure(new Error(ErrorCode.INVALID.getCode(), "PluginRequest is null"));
            }
        } catch (RemoteException e) {
            if (pluginSubscribeCallback != null) {
                pluginSubscribeCallback.onFailure(new Error(ErrorCode.INVALID.getCode(), e.toString()));
            }
        }
    }

    public void unsubscribeDeviceV2(String str, int i, List<String> list, String str2, final PluginUnSubscribeCallback pluginUnSubscribeCallback) {
        final Looper looper = getLooper();
        AnonymousClass9 r6 = new IPluginCallback2.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass9 */

            public void onRequestSuccess(Intent intent) throws RemoteException {
                if (pluginUnSubscribeCallback != null) {
                    new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass9.AnonymousClass1 */

                        public void run() {
                            pluginUnSubscribeCallback.onSuccess();
                        }
                    });
                }
            }

            public void onRequestFailed(final int i, final String str) throws RemoteException {
                if (pluginUnSubscribeCallback != null) {
                    new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass9.AnonymousClass2 */

                        public void run() {
                            pluginUnSubscribeCallback.onFailure(new Error(i, str));
                        }
                    });
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().unsubscribeDeviceV2(str, i, list, str2, r6);
            } else if (pluginUnSubscribeCallback != null) {
                pluginUnSubscribeCallback.onFailure(new Error(ErrorCode.INVALID.getCode(), "PluginRequest is null"));
            }
        } catch (RemoteException e) {
            if (pluginUnSubscribeCallback != null) {
                pluginUnSubscribeCallback.onFailure(new Error(ErrorCode.INVALID.getCode(), e.toString()));
            }
        }
    }

    public <T> void callMethod(String str, String str2, Callback<T> callback, Parser<T> parser) {
        request(str, str2, false, callback, parser);
    }

    public <T> void callMethodFromLocal(String str, String str2, Callback<T> callback, Parser<T> parser) {
        requestFromLocal(str, str2, callback, parser);
    }

    public <T> void callMethodFromCloud(String str, String str2, Callback<T> callback, Parser<T> parser) {
        request(str, str2, true, callback, parser);
    }

    public <T> void callLocalHttpApi(String str, String str2, String str3, List<NameValuePair> list, Callback<T> callback, Parser<T> parser) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (NameValuePair next : list) {
                arrayList.add(new gky(next.getName(), next.getValue()));
            }
        }
        final String str4 = str2;
        final String str5 = str3;
        final Callback<T> callback2 = callback;
        final Parser<T> parser2 = parser;
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass10 */

            public void run() {
                try {
                    god.O000000o(str4, str5, arrayList, callback2, parser2);
                } catch (Exception unused) {
                }
            }
        });
    }

    public <T> void callLocalHttpApiV13(String str, String str2, String str3, List<KeyValuePair> list, Callback<T> callback, Parser<T> parser) {
        final ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (KeyValuePair next : list) {
                arrayList.add(new gky(next.getKey(), next.getValue()));
            }
        }
        final String str4 = str2;
        final String str5 = str3;
        final Callback<T> callback2 = callback;
        final Parser<T> parser2 = parser;
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass11 */

            public void run() {
                try {
                    god.O000000o(str4, str5, arrayList, callback2, parser2);
                } catch (Exception unused) {
                }
            }
        });
    }

    public void modDeviceName(String str, String str2, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass12 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass12 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().modDeviceName(str, str2, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void unBindDevice(String str, int i, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass13 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass13 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().unBindDevice(str, i, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public Location getLastLocation() {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                return etx.O000000o().O00000Oo().getLastLocation();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public boolean isNetworkLocationEnabled() {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                return etx.O000000o().O00000Oo().isNetworkLocationEnabled();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public boolean isGPSLocationEnable() {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                return etx.O000000o().O00000Oo().isGPSLocationEnable();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public void requestLocation(final Callback<Location> callback) {
        final Looper looper = getLooper();
        AnonymousClass14 r1 = new ILocationCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass14 */

            public void onSuccess() throws RemoteException {
                Location lastLocation = PluginHostApiImpl.this.getLastLocation();
                if (lastLocation == null) {
                    PluginHostApiImpl.this.handlerFailed(callback, -1, "", looper);
                } else {
                    PluginHostApiImpl.this.handlerSuccess(callback, lastLocation, looper);
                }
            }

            public void onFailure() throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, -1, "", looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().requestLocation(r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void openXiaoAiLearnPage(Activity activity, String str, boolean z) {
        Intent intent = new Intent(activity, AiTrainingWebActivity.class);
        intent.putExtra("url", "https://i.ai.mi.com/mico#/skill/training");
        intent.putExtra("showCloseBtn", z);
        intent.putExtra("extra_cookies", str);
        activity.startActivity(intent);
    }

    public void getServiceToken(String str, Callback<JSONObject> callback) {
        callback.onFailure(-1, "Not in the scope of permission");
    }

    public List<DeviceStat> getIrDevList() {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                return etx.O000000o().O00000Oo().getIrDevList();
            } catch (Throwable th) {
                Log.e("XmPluginHostApiImpl", "getIrDevList", th);
            }
        }
        return new ArrayList();
    }

    public String getProperty(String str, String str2) {
        if ("account.xiaoqiang.userId".equals(str2)) {
            return CoreApi.O000000o().O0000o0();
        }
        if ("account.xiaoqiang.serviceToken".equals(str2)) {
            MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o("xiaoqiang");
            if (O000000o2 != null) {
                return O000000o2.O00000o0;
            }
            return "";
        } else if ("account.xiaoqiang.timediff".equals(str2)) {
            MiServiceTokenInfo O000000o3 = CoreApi.O000000o().O000000o("xiaoqiang");
            if (O000000o3 != null) {
                return Long.toString(O000000o3.O00000oO);
            }
            return "";
        } else if ("account.xiaoqiang.ssecurity".equals(str2)) {
            MiServiceTokenInfo O000000o4 = CoreApi.O000000o().O000000o("xiaoqiang");
            if (O000000o4 != null) {
                return O000000o4.O00000o;
            }
            return "";
        } else if ("account.xiaoqiang.passtoken".equals(str2)) {
            return CoreApi.O000000o().O0000oO();
        } else {
            return null;
        }
    }

    public void updateDeviceList(final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass15 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass15 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateDeviceList(r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void updateDeviceProperties(String str, JSONObject jSONObject) {
        try {
            if (etx.O000000o().O00000Oo() != null && jSONObject != null) {
                etx.O000000o().O00000Oo().updateDeviceProperties(str, jSONObject.toString());
            }
        } catch (RemoteException unused) {
        }
    }

    public void log(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().log(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void logByModel(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().logByModel(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void startService(Intent intent, XmPluginPackage xmPluginPackage, Class cls) {
        Intent intent2 = new Intent(CommonApplication.getAppContext(), XmPluginService.class);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("extra_package", xmPluginPackage.packageName);
        intent2.putExtra("extra_class", cls.getName());
        CommonApplication.getAppContext().startActivity(intent2);
    }

    public boolean bindService(Intent intent, XmPluginPackage xmPluginPackage, Class cls, ServiceConnection serviceConnection, int i) {
        Intent intent2 = new Intent(CommonApplication.getAppContext(), XmPluginService.class);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("extra_package", xmPluginPackage.packageName);
        intent2.putExtra("extra_class", cls.getName());
        return CommonApplication.getAppContext().bindService(intent2, serviceConnection, i);
    }

    public void addToLauncher(XmPluginPackage xmPluginPackage, String str, Intent intent) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().addToLauncher(str, intent);
            }
        } catch (RemoteException unused) {
        }
    }

    public void setSubDeviceShownMode(XmPluginPackage xmPluginPackage, boolean z, String str, Context context, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass16 r4 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass16 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().setSubDeviceShownMode(str, z, r4);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public String getRouterFileDownloadUrl(String str) {
        try {
            return etx.O000000o().O00000Oo() != null ? etx.O000000o().O00000Oo().getRouterFileDownloadUrl(str) : "";
        } catch (RemoteException unused) {
            return "";
        }
    }

    public void checkLocalRouterInfo(String str, final Callback<Void> callback) {
        final Looper looper = getLooper();
        AnonymousClass17 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass17 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, null, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().checkLocalRouterInfo(str, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public boolean isLocalMiRouter() {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                return etx.O000000o().O00000Oo().isLocalMiRouter();
            }
            return false;
        } catch (RemoteException unused) {
            return false;
        }
    }

    public void gotoPage(Context context, XmPluginPackage xmPluginPackage, Uri uri, Callback<Void> callback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().gotoPage(uri);
            }
        } catch (RemoteException unused) {
        }
    }

    public void sendMessage(String str, int i, Intent intent, DeviceStat deviceStat, final MessageCallback messageCallback) {
        final Looper looper = getLooper();
        AnonymousClass18 r0 = messageCallback != null ? new IPluginCallback2.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass18 */

            public void onRequestFailed(final int i, final String str) throws RemoteException {
                new Handler(looper).post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass18.AnonymousClass1 */

                    public void run() {
                        if (messageCallback != null) {
                            messageCallback.onFailure(i, str);
                        }
                    }
                });
            }

            public void onRequestSuccess(final Intent intent) throws RemoteException {
                new Handler(looper).post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass18.AnonymousClass2 */

                    public void run() {
                        if (messageCallback != null) {
                            messageCallback.onSuccess(intent);
                        }
                    }
                });
            }
        } : null;
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().sendMessage(str, i, intent, r0);
            } else if (messageCallback != null) {
                messageCallback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (messageCallback != null) {
                messageCallback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void notifyBluetoothBinded(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().notifyBluetoothBinded(str.toUpperCase(), str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void getUserInfo(String str, final Callback<UserInfo> callback) {
        final Looper looper = getLooper();
        AnonymousClass19 r1 = new IPluginCallbackUserInfo.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass19 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(UserInfo userInfo) throws RemoteException {
                PluginHostApiImpl.this.handlerSuccess(callback, userInfo, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().getUserInfo(str, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    @Deprecated
    public long startDownload(Uri uri, String str, String str2, String str3) {
        frj.O00000o0 o00000o0 = new frj.O00000o0(uri, str);
        o00000o0.O000000o(CommonApplication.getAppContext(), str2, str3);
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            return downloadManager.O000000o(o00000o0);
        }
        return 0;
    }

    @Deprecated
    private frk getDownloadManager() {
        if (mDownloadManager == null) {
            synchronized (frj.class) {
                if (mDownloadManager == null) {
                    mDownloadManager = new frk(CommonApplication.getAppContext(), CommonApplication.getAppContext().getContentResolver(), CommonApplication.getAppContext().getPackageName());
                }
            }
        }
        return mDownloadManager;
    }

    @Deprecated
    public void pauseDownload(long... jArr) {
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            downloadManager.O00000Oo(jArr);
        }
    }

    @Deprecated
    public void resumeDownload(long... jArr) {
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            downloadManager.O00000o0(jArr);
        }
    }

    @Deprecated
    public void restartDownload(long... jArr) {
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            downloadManager.O00000o(jArr);
        }
    }

    @Deprecated
    public void removeDownload(long... jArr) {
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            downloadManager.O000000o(jArr);
        }
    }

    @Deprecated
    public Cursor queryDownload(boolean z, long... jArr) {
        frk downloadManager = getDownloadManager();
        if (downloadManager == null) {
            return null;
        }
        frj.O00000Oo o00000Oo = new frj.O00000Oo();
        o00000Oo.f16972O000000o = jArr;
        o00000Oo.O00000Oo = z;
        return downloadManager.O000000o(o00000Oo);
    }

    @Deprecated
    public void notifyLocalWifiConnect(boolean z) {
        frk downloadManager = getDownloadManager();
        if (downloadManager != null) {
            downloadManager.O000000o(z);
        }
    }

    public void updateSubDevice(XmPluginPackage xmPluginPackage, String[] strArr, final Callback<List<DeviceStat>> callback) {
        final Looper looper = getLooper();
        AnonymousClass20 r0 = new IPluginCallbackDeviceList.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass20 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(List<DeviceStatus> list) throws RemoteException {
                if (callback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (DeviceStatus O000000o2 : list) {
                        arrayList.add(O000000o2.O000000o());
                    }
                    PluginHostApiImpl.this.handlerSuccess(callback, arrayList, looper);
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateSubDevice(strArr, r0);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void callRemoteAsync(String[] strArr, int i, Object obj, final Callback<JSONObject> callback) {
        final Looper looper = getLooper();
        if (obj == null || !(obj instanceof JSONObject)) {
            handlerFailed(callback, -1, "params is not jsonobject", looper);
            return;
        }
        AnonymousClass21 r6 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass21 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                if (callback != null) {
                    JSONObject jSONObject = null;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException unused) {
                        }
                    }
                    PluginHostApiImpl.this.handlerSuccess(callback, jSONObject, looper);
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().callRemoteAsync(strArr, i, obj.toString(), r6, null);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public void getBluetoothFirmwareUpdateInfo(String str, Callback<BtFirmwareUpdateInfo> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
            callSmartHomeApi(str, "/home/latest_version", jSONObject, callback, new Parser<BtFirmwareUpdateInfo>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass22 */

                public BtFirmwareUpdateInfo parse(String str) throws JSONException {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    BtFirmwareUpdateInfo btFirmwareUpdateInfo = new BtFirmwareUpdateInfo();
                    btFirmwareUpdateInfo.version = jSONObject.optString("version");
                    btFirmwareUpdateInfo.url = jSONObject.optString("url");
                    btFirmwareUpdateInfo.changeLog = jSONObject.optString("changeLog");
                    btFirmwareUpdateInfo.md5 = jSONObject.optString("md5");
                    return btFirmwareUpdateInfo;
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public IWXAPI createWXAPI(Context context, boolean z) {
        if (this.wxapi == null) {
            this.wxapi = WXAPIFactory.createWXAPI(CommonApplication.getAppContext(), "wx54b959a68fb6f580", true);
            this.wxapi.registerApp("wx54b959a68fb6f580");
        }
        return this.wxapi;
    }

    public void reportBluetoothRecords(String str, String str2, List<XmBluetoothRecord> list, Callback<List<Boolean>> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONArray jSONArray = new JSONArray();
            if (!gpn.O000000o(list)) {
                for (XmBluetoothRecord json : list) {
                    jSONArray.put(json.toJson());
                }
            }
            jSONObject.put("datas", jSONArray);
            callSmartHomeApi(str2, "/device/event", jSONObject, callback, new Parser<List<Boolean>>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass23 */

                public List<Boolean> parse(String str) throws JSONException {
                    gnk.O00000oO("reportBluetoothRecords: ".concat(String.valueOf(str)));
                    ArrayList arrayList = new ArrayList();
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            if ("0".equals(jSONObject.optString("code"))) {
                                JSONArray optJSONArray = jSONObject.optJSONArray("result");
                                int length = optJSONArray != null ? optJSONArray.length() : 0;
                                for (int i = 0; i < length; i++) {
                                    arrayList.add(Boolean.valueOf(optJSONArray.optBoolean(i)));
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                    return arrayList;
                }
            });
        } catch (Exception e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void downloadBleFirmware(String str, Response.BleUpgradeResponse bleUpgradeResponse) {
        if (!TextUtils.isEmpty(str)) {
            foe.O000000o(str, bleUpgradeResponse);
        }
    }

    public void downloadFirmware(String str, Response.FirmwareUpgradeResponse firmwareUpgradeResponse) {
        if (!TextUtils.isEmpty(str)) {
            foe.O000000o(str, firmwareUpgradeResponse);
        }
    }

    public void cancelDownloadBleFirmware(String str) {
        if (!TextUtils.isEmpty(str)) {
            foe.O000000o(str);
        }
    }

    public void setBleDeviceSubtitle(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().setBleDeviceSubtitle(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void deviceRename(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().renameBluetoothDevice(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void callRemoteAsync(String[] strArr, int i, Object obj, final Callback<JSONObject> callback, final Callback<JSONObject> callback2) {
        final Looper looper = getLooper();
        if (obj == null || !(obj instanceof JSONObject)) {
            handlerFailed(callback, -1, "params is not jsonobject", looper);
            return;
        }
        AnonymousClass24 r6 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass24 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                if (callback != null) {
                    JSONObject jSONObject = null;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException unused) {
                        }
                    }
                    PluginHostApiImpl.this.handlerSuccess(callback, jSONObject, looper);
                }
            }
        };
        AnonymousClass25 r7 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass25 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback2, i, str, looper);
            }

            public void onRequestSuccess(String str) throws RemoteException {
                if (callback2 != null) {
                    JSONObject jSONObject = null;
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject = new JSONObject(str);
                        } catch (JSONException unused) {
                        }
                    }
                    PluginHostApiImpl.this.handlerSuccess(callback2, jSONObject, looper);
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().callRemoteAsync(strArr, i, obj.toString(), r6, r7);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    @Deprecated
    public String getGlobalSettingServer() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            return "";
        }
        return O0000ooO.f7546O000000o;
    }

    @Deprecated
    public String getGlobalSettingServer(boolean z) {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        if (O0000ooO == null) {
            return "";
        }
        if (z) {
            return O0000ooO.f7546O000000o;
        }
        String O000000o2 = ftn.O000000o(O0000ooO);
        return TextUtils.isEmpty(O000000o2) ? ftn.O00000o().f7546O000000o : O000000o2;
    }

    public String getCurrentServer() {
        ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
        return O0000ooO != null ? O0000ooO.O000000o() : "";
    }

    @SuppressLint({"CheckResult"})
    public void getServerName(Callback<String> callback) {
        if (callback != null) {
            Observable<String> observeOn = hsl.O00000Oo().getServerName(CoreApi.O000000o().O0000ooO()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            callback.getClass();
            observeOn.subscribe(new Consumer() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.$$Lambda$oiMKIwZSfP9qLetLf4oZnP7TTPs */

                public final void accept(Object obj) {
                    Callback.this.onSuccess((String) obj);
                }
            }, new Consumer() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.$$Lambda$PluginHostApiImpl$dmPxDTJfXHV99DqcpucCo7fkRa4 */

                public final void accept(Object obj) {
                    Callback.this.onFailure(-1, ((Throwable) obj).getMessage());
                }
            }, $$Lambda$PluginHostApiImpl$zRSwWJcbBCJnMmIrm3rrvZfs2R0.INSTANCE);
        }
    }

    public boolean isInternationalServer(Context context) {
        return ftn.O00000oO(context);
    }

    public boolean isChinaMainLand(Context context) {
        return ftn.O00000oo(context);
    }

    public boolean isEurope(Context context) {
        return ftn.O0000O0o(context);
    }

    public boolean isKorea(Context context) {
        return ftn.O0000OOo(context);
    }

    public boolean isTW(Context context) {
        return ftn.O0000Oo0(context);
    }

    public boolean isIndia(Context context) {
        return ftn.O0000Oo(context);
    }

    public boolean isAmerica(Context context) {
        return ftn.O0000Ooo(context);
    }

    public boolean isRussia(Context context) {
        return ftn.O0000o00(context);
    }

    public boolean isSingapore(Context context) {
        return ftn.O0000o0(context);
    }

    public void getRechargeBalances(int i, double d, double d2, final Callback<JSONObject> callback) {
        String str = "";
        try {
            List<Address> fromLocation = new Geocoder(XmPluginHostApi.instance().context(), Locale.CHINA).getFromLocation(d, d2, 1);
            if (fromLocation != null && fromLocation.size() > 0) {
                Address address = fromLocation.get(0);
                if (TextUtils.isEmpty(str)) {
                    str = address.getLocality();
                }
                if (TextUtils.isEmpty(str)) {
                    str = address.getAdminArea();
                }
                if (TextUtils.isEmpty(str)) {
                    str = address.getSubAdminArea();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String format = String.format("/api/utility/v1/utilities/%d/balances?refs=10", Integer.valueOf(i));
        NetRequest.O000000o o000000o = new NetRequest.O000000o();
        o000000o.O000000o("GET");
        o000000o.O00000Oo(format);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("cityName", str));
        o000000o.O000000o(arrayList);
        CoreApi O000000o2 = CoreApi.O000000o();
        context();
        O000000o2.O000000o(o000000o.O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass26 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optJSONObject("data");
            }
        }, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass27 */

            public void onSuccess(JSONObject jSONObject) {
                PluginHostApiImpl.this.handlerSuccess(callback, jSONObject, null);
            }

            public void onFailure(fso fso) {
                PluginHostApiImpl.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, null);
            }
        });
    }

    public Bitmap encodeBarcode(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Hashtable hashtable = new Hashtable();
        hashtable.put(EncodeHintType.CHARACTER_SET, "utf-8");
        try {
            new igw();
            idm O000000o2 = igw.O000000o(str, BarcodeFormat.QR_CODE, i, i2, hashtable);
            int[] iArr = new int[(i * i2)];
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (O000000o2.O000000o(i4, i3)) {
                        iArr[(i3 * i) + i4] = -16777216;
                    } else {
                        iArr[(i3 * i) + i4] = -1;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
            return createBitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String decodeBarcode(Bitmap bitmap) {
        if (bitmap == null || bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            return null;
        }
        igv igv = new igv();
        int[] iArr = new int[(bitmap.getWidth() * bitmap.getHeight())];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        try {
            idf O000000o2 = igv.O000000o(new icy(new idt(new idd(bitmap.getWidth(), bitmap.getHeight(), iArr))), null);
            if (O000000o2 != null) {
                return O000000o2.f1208O000000o;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateDevice(List<String> list, final Callback<List<DeviceStat>> callback) {
        final Looper looper = getLooper();
        AnonymousClass28 r1 = new IPluginCallbackDeviceList.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass28 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginHostApiImpl.this.handlerFailed(callback, i, str, looper);
            }

            public void onRequestSuccess(List<DeviceStatus> list) throws RemoteException {
                if (callback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (DeviceStatus O000000o2 : list) {
                        arrayList.add(O000000o2.O000000o());
                    }
                    PluginHostApiImpl.this.handlerSuccess(callback, arrayList, looper);
                }
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateDevice(list, r1);
            } else if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), "PluginRequest is null");
            }
        } catch (RemoteException e) {
            if (callback != null) {
                callback.onFailure(ErrorCode.INVALID.getCode(), e.toString());
            }
        }
    }

    public String getDevicePincode(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return "";
        }
        try {
            return etx.O000000o().O00000Oo().getDevicePincode(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean checkAndShowVoiceCtrlAuthorizePageIfNeed(Activity activity, String str, int i) {
        try {
            if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) && etx.O000000o().O00000Oo() != null) {
                if (!etx.O000000o().O00000Oo().checkVoiceCtrlAuthorized(str)) {
                    showVoiceCtrlAuthorizePage(activity, str, i);
                    return true;
                } else if (etx.O000000o().O00000Oo().checkIfVoiceCtrlAuthorizedExpired(str)) {
                    showVoiceCtrlAuthorizePage(activity, str, i);
                    return true;
                }
            }
        } catch (RemoteException unused) {
        }
        return false;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public void showVoiceCtrlAuthorizePage(Activity activity, String str, int i) {
        fbt fbt = new fbt(activity, "/setting/DeviceAuthSlaveListActivity");
        fbt.O000000o("device_id", str);
        if (!hsl.O00000Oo().checkVoiceCtrlAuthorized(str)) {
            fbt.O000000o("bottom_bar", false);
        }
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    public void visualSecureBind(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().visualSecureBind(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getFirmwareUpdateInfoCommon(String str, Callback<FirmwareUpdateInfo> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("model", str);
            callSmartHomeApi(str, "/home/latest_version", jSONObject, callback, new Parser<FirmwareUpdateInfo>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass29 */

                public FirmwareUpdateInfo parse(String str) throws JSONException {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    FirmwareUpdateInfo firmwareUpdateInfo = new FirmwareUpdateInfo();
                    firmwareUpdateInfo.version = jSONObject.optString("version");
                    firmwareUpdateInfo.url = jSONObject.optString("url");
                    firmwareUpdateInfo.changeLog = jSONObject.optString("changeLog");
                    if (jSONObject.has("md5")) {
                        firmwareUpdateInfo.md5 = jSONObject.optString("md5");
                    }
                    return firmwareUpdateInfo;
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void loadBitmap(String str, final Callback<Bitmap> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().loadBitmap(str, new IPluginCallback3.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass30 */

                    public void onSuccess(Bitmap bitmap) throws RemoteException {
                        callback.onSuccess(bitmap);
                    }

                    public void onFailed() throws RemoteException {
                        callback.onFailure(0, "");
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDeviceRealIconByModel(String str, final Callback<Bitmap> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().getDeviceRealIconByModel(str, new IPluginCallback3.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass31 */

                    public void onSuccess(Bitmap bitmap) throws RemoteException {
                        callback.onSuccess(bitmap);
                    }

                    public void onFailed() throws RemoteException {
                        callback.onFailure(0, "");
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public List<String> getRecommendTags(String str) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        try {
            return O00000Oo.getRecommendTags(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void initCameraFrameSender(String str) {
        CameraFrameSender.instance().initCameraFrame(str);
    }

    public void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, boolean z, int i2, int i3) {
        CameraFrameSender.instance().sendCameraFrame(str, bArr, j, i, j2, z, i2, i3);
    }

    public void sendCameraFrame(String str, byte[] bArr, long j, int i, long j2, int i2, boolean z, int i3, int i4) {
        CameraFrameSender.instance().sendCameraFrame(str, bArr, j, i, j2, i2, z, i3, i4);
    }

    public void closeCameraFrameSender(String str) {
        CameraFrameSender.instance().closeCameraFrame(str);
    }

    public void setUserConfigV5(XmPluginPackage xmPluginPackage, String str, int i, Map<String, Object> map, final Callback<int[]> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry next : map.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
            fuh O000000o2 = fuh.O000000o();
            JSONArray jSONArray = new JSONArray();
            final int[] O000000o3 = fuh.O000000o(jSONObject, str, i, jSONArray);
            Context appContext = CommonApplication.getAppContext();
            AnonymousClass32 r6 = new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass32 */

                public void onSuccess(JSONObject jSONObject) {
                    if (jSONObject.optInt("result") != 0) {
                        callback.onSuccess(O000000o3);
                    }
                }

                public void onFailure(fso fso) {
                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                }
            };
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONArray.toString()));
            CoreApi.O000000o().O000000o(appContext, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/set_third_user_config").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fuh.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, r6);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void getUserConfigV5(XmPluginPackage xmPluginPackage, final String str, int[] iArr, final Callback<Map<String, Object>> callback) {
        JSONArray jSONArray = new JSONArray();
        for (int put : iArr) {
            jSONArray.put(put);
        }
        fuh.O000000o().O000000o(CommonApplication.getAppContext(), str, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass33 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((Map<Integer, fui.O00000Oo>) ((Map) obj));
            }

            public void onSuccess(Map<Integer, fui.O00000Oo> map) {
                PluginHostApiImpl.this.processConfigInfo(map, callback, str);
            }

            public void onFailure(fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                }
            }
        });
    }

    public void processConfigInfo(Map<Integer, fui.O00000Oo> map, Callback<Map<String, Object>> callback, String str) {
        ArrayList arrayList = new ArrayList();
        for (Integer next : map.keySet()) {
            try {
                JSONObject jSONObject = new JSONObject(map.get(next).O00000o0);
                if (jSONObject.has("ts") && jSONObject.has("tc")) {
                    PackConfigInfo packConfigInfo = new PackConfigInfo();
                    packConfigInfo.sourceKey = next.intValue();
                    packConfigInfo.packStart = jSONObject.getInt("ts");
                    packConfigInfo.packLength = jSONObject.getInt("tc");
                    arrayList.add(packConfigInfo);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (arrayList.size() > 0) {
            repackConfigInfo(map, arrayList, callback, str);
        } else {
            responseResult(map, callback);
        }
    }

    public void responseResult(Map<Integer, fui.O00000Oo> map, Callback<Map<String, Object>> callback) {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            fui.O00000Oo o00000Oo = (fui.O00000Oo) next.getValue();
            try {
                String valueOf = String.valueOf((Integer) next.getKey());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("component_id", o00000Oo.f17183O000000o);
                jSONObject.put("key", o00000Oo.O00000Oo);
                jSONObject.put("data", o00000Oo.O00000o0);
                hashMap.put(valueOf, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        callback.onSuccess(hashMap);
    }

    private void repackConfigInfo(final Map<Integer, fui.O00000Oo> map, final List<PackConfigInfo> list, final Callback<Map<String, Object>> callback, String str) {
        JSONArray jSONArray = new JSONArray();
        for (PackConfigInfo next : list) {
            for (int i = next.packStart; i < next.packStart + next.packLength; i++) {
                jSONArray.put(i);
            }
        }
        fuh.O000000o().O000000o(CommonApplication.getAppContext(), str, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass34 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((Map<Integer, fui.O00000Oo>) ((Map) obj));
            }

            public void onSuccess(Map<Integer, fui.O00000Oo> map) {
                for (PackConfigInfo packConfigInfo : list) {
                    int i = packConfigInfo.sourceKey;
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = packConfigInfo.packStart; i2 < packConfigInfo.packStart + packConfigInfo.packLength; i2++) {
                        sb.append(map.get(Integer.valueOf(i2)).O00000o0);
                    }
                    ((fui.O00000Oo) map.get(Integer.valueOf(i))).O00000o0 = sb.toString();
                }
                PluginHostApiImpl.this.responseResult(map, callback);
            }

            public void onFailure(fso fso) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                }
            }
        });
    }

    static class PackConfigInfo {
        int packLength;
        int packStart;
        int sourceKey;

        private PackConfigInfo() {
        }
    }

    public void openCameraFloatingWindow(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().openCameraFloatingWindow(str);
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setFlags(268435456);
                intent.addCategory("android.intent.category.HOME");
                CommonApplication.getAppContext().startActivity(intent);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeCameraFloatingWindow(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().closeCameraFloatingWindow(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public Typeface getFont(String str) {
        return gno.O000000o(CommonApplication.getAppContext(), str);
    }

    public JSONArray getDeviceProp(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            String devicePropByDid = etx.O000000o().O00000Oo().getDevicePropByDid(str);
            if (TextUtils.isEmpty(devicePropByDid)) {
                devicePropByDid = "[]";
            }
            return new JSONArray(devicePropByDid);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void getControllableDevices(String str, final Callback<JSONObject> callback) {
        if (str.contains("watch") && etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().getWatchControllableDevices(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass35 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        if (callback != null) {
                            try {
                                callback.onSuccess(PluginHostApiImpl.this.getWatchControllableDevices(new JSONObject(str).optJSONArray("result")));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        Callback callback = callback;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void gotoFeedback(Activity activity, String str, String str2, XmPluginPackage xmPluginPackage) {
        fbt fbt = new fbt(activity, "/userCenter/FeedbackActivity");
        fbt.O000000o("extra_device_model", str);
        fbt.O000000o("extra_source", 0);
        fbs.O000000o(fbt);
    }

    public JSONObject getWatchControllableDevices(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        List<DeviceStat> deviceList = getDeviceList();
        HashMap hashMap = new HashMap();
        for (DeviceStat next : deviceList) {
            List list = (List) hashMap.get(next.model);
            if (list == null) {
                list = new LinkedList();
                hashMap.put(next.model, list);
            }
            list.add(next);
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                JSONArray optJSONArray = jSONObject.optJSONArray("adapt_models");
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    List<DeviceStat> list2 = (List) hashMap.get(optJSONArray.optString(i2));
                    if (!gpn.O000000o(list2)) {
                        for (DeviceStat deviceStat : list2) {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
                            jSONObject2.put("did", deviceStat.did);
                            jSONObject2.put("name", deviceStat.name);
                            jSONObject2.put("model", deviceStat.model);
                            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(deviceStat.model);
                            jSONObject2.put("icon", O00000oO != null ? O00000oO.O0000o0() : "");
                            jSONArray2.put(jSONObject2);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("result", jSONArray2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        gnk.O00000oO(String.format("getWatchControllableDevices:\n%s", jSONObject3));
        return jSONObject3;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    public void gotoAuthManagerPage(Activity activity, String str) {
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            try {
                if (etx.O000000o().O00000Oo() != null && etx.O000000o().O00000Oo().checkIfSupportVoiceCtrl(str)) {
                    fbt fbt = new fbt(activity, "/setting/DeviceAuthSlaveListActivity");
                    fbt.O000000o("device_id", str);
                    fbt.O000000o("bottom_bar", false);
                    fbs.O000000o(fbt);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAppConfig(String str, String str2, String str3, final Callback<String> callback) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lang", str2);
            jSONObject.put("name", str);
            jSONObject.put("version", str3);
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        gsj gsj = null;
        try {
            gsj.O000000o o000000o = new gsj.O000000o();
            o000000o.f18212O000000o = "GET";
            gsj = o000000o.O00000Oo(buildUrl(jSONObject)).O000000o();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (gsj != null) {
            gsg.O00000Oo(gsj, new gsl() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass36 */

                public void onSuccess(Object obj, okhttp3.Response response) {
                }

                public void processResponse(okhttp3.Response response) {
                    try {
                        JSONObject jSONObject = new JSONObject(response.body().string());
                        if (!jSONObject.isNull("result")) {
                            JSONObject optJSONObject = jSONObject.optJSONObject("result");
                            if (!optJSONObject.isNull("content")) {
                                callback.onSuccess(optJSONObject.get("content").toString());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }

                public void processFailure(Call call, IOException iOException) {
                    callback.onFailure(-1, null);
                }

                public void onFailure(gsf gsf, Exception exc, okhttp3.Response response) {
                    callback.onFailure(-1, null);
                }
            });
        }
    }

    private String buildUrl(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    public Locale getSettingLocale() {
        return CoreApi.O000000o().O00oOooo();
    }

    public boolean isModelSupport(String str) {
        return CoreApi.O000000o().O00000oO(str) != null;
    }

    public void reverseGeo(double d, double d2, final Callback<Address> callback) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().reverseGeo(d, d2, new IPluginCallback2.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass37 */

                    public void onRequestSuccess(Intent intent) throws RemoteException {
                        Address address = (Address) intent.getParcelableExtra("address");
                        if (address != null) {
                            callback.onSuccess(address);
                        } else {
                            callback.onFailure(-1, "get intent with null address");
                        }
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void logForModel(String str, String str2) {
        gsy.O00000o0(LogType.PLUGIN, str, "", str2);
    }

    public boolean checkAndRequestPermisson(Activity activity, boolean z, Callback<List<String>> callback, String... strArr) {
        if (strArr == null || activity == null || activity.isFinishing()) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            return true;
        }
        boolean O000000o2 = fwq.O000000o(strArr);
        if (activity.getApplicationInfo().targetSdkVersion < 23 || !z || O000000o2 || etx.O000000o().O00000Oo() == null) {
            if (callback != null) {
                if (O000000o2) {
                    callback.onSuccess(Arrays.asList(strArr));
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (String str : strArr) {
                        sb.append((CharSequence) str);
                        sb.append(",");
                    }
                    sb.deleteCharAt(sb.lastIndexOf(","));
                    callback.onFailure(strArr.length, sb.toString());
                }
            }
            return O000000o2;
        }
        try {
            final Looper looper = getLooper();
            final Activity activity2 = activity;
            final String[] strArr2 = strArr;
            final Callback<List<String>> callback2 = callback;
            etx.O000000o().O00000Oo().requestPermission(strArr, new IPluginCallback.Stub() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass38 */

                public void onRequestSuccess(String str) throws RemoteException {
                    Callback callback;
                    if (activity2.isFinishing()) {
                        return;
                    }
                    if (Build.VERSION.SDK_INT >= 17 && activity2.isDestroyed()) {
                        return;
                    }
                    if (TextUtils.equals(str, "onDenied") && ind.O000000o(activity2, strArr2)) {
                        new Handler(PluginHostApiImpl.this.getCallbackLooper(looper)).post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass38.AnonymousClass1 */

                            public void run() {
                                List<String> O000000o2 = ing.O000000o(PluginHostApiImpl.this.application(), Arrays.asList(strArr2));
                                String format = String.format(PluginHostApiImpl.this.application().getText(R.string.permission_tips_denied_msg).toString(), TextUtils.join("\n", O000000o2));
                                final inj O000000o3 = ind.O000000o(activity2);
                                AlwaysDeniedPermissionDialog.Builder builder = new AlwaysDeniedPermissionDialog.Builder(activity2);
                                builder.O00000Oo = format;
                                builder.O00000o = new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass38.AnonymousClass1.AnonymousClass2 */

                                    public void onClick(View view) {
                                        O000000o3.O000000o();
                                    }
                                };
                                builder.O00000oO = new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass38.AnonymousClass1.AnonymousClass1 */

                                    public void onClick(View view) {
                                        PluginHostApiImpl.this.handlerFailed(callback2, -1, "Permisson Denied", looper);
                                    }
                                };
                                AlwaysDeniedPermissionDialog alwaysDeniedPermissionDialog = new AlwaysDeniedPermissionDialog();
                                alwaysDeniedPermissionDialog.O00000o0 = builder.O00000o0;
                                alwaysDeniedPermissionDialog.O00000Oo = builder.O00000Oo;
                                alwaysDeniedPermissionDialog.f9077O000000o = builder.f9080O000000o;
                                alwaysDeniedPermissionDialog.O00000o = builder.O00000o;
                                alwaysDeniedPermissionDialog.O00000oO = builder.O00000oO;
                                if (alwaysDeniedPermissionDialog.O0000O0o == null) {
                                    alwaysDeniedPermissionDialog.O0000O0o = new AlwaysDeniedPermissionDialog.O000000o(alwaysDeniedPermissionDialog, alwaysDeniedPermissionDialog.O00000o0);
                                    alwaysDeniedPermissionDialog.O0000O0o.setCancelable(false);
                                    alwaysDeniedPermissionDialog.O0000O0o.show();
                                }
                            }
                        });
                    } else if (TextUtils.equals(str, "onGranted") && (callback = callback2) != null) {
                        PluginHostApiImpl.this.handlerSuccess(callback, Arrays.asList(strArr2), looper);
                    } else if (TextUtils.equals(str, "onDenied")) {
                        PluginHostApiImpl.this.handlerFailed(callback2, -1, "Permisson Denied", looper);
                    }
                }

                public void onRequestFailed(int i, String str) throws RemoteException {
                    PluginHostApiImpl.this.handlerFailed(callback2, i, str, looper);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public XmVideoViewGl createVideoView(Context context, FrameLayout frameLayout, boolean z, int i) {
        return CameraRouterFactory.getCameraPlayerApi().createVideoView(context, frameLayout, z, i);
    }

    public XmVideoViewGl createVideoViewOnFront(Context context, FrameLayout frameLayout, boolean z, int i) {
        return CameraRouterFactory.getCameraPlayerApi().createVideoViewOnFront(context, frameLayout, z, i);
    }

    public XmVideoViewGl createMp4View(Context context, FrameLayout frameLayout, boolean z) {
        return CameraRouterFactory.getCameraPlayerApi().createMp4View(context, frameLayout, z);
    }

    public XmMp4Record createMp4Record() {
        return CameraRouterFactory.getCameraPlayerApi().createMp4Record();
    }

    public XmCameraP2p createCameraP2p(XmP2PInfo xmP2PInfo, int i) {
        return CameraRouterFactory.getCameraPlayerApi().createCameraP2p(xmP2PInfo, i);
    }

    public void updateP2pPwd(DeviceStat deviceStat, int i, Callback<XmP2PInfo> callback) {
        CameraRouterFactory.getCameraPlayerApi().updateP2pPwd(deviceStat, i, callback);
    }

    public XmAAcCodec createAAcCodec(boolean z, int i, int i2, int i3) {
        return CameraRouterFactory.getCameraPlayerApi().createAAcCodec(z, i, i2, i3);
    }

    public void getBindKey(String str, final Callback<String> callback) {
        JSONObject jSONObject = new JSONObject();
        final Looper looper = getLooper();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o((Context) null, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_bindkey").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass39 */

            public String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optString("bindkey");
            }
        }, Crypto.RC4, new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass40 */

            public void onSuccess(String str) {
                PluginHostApiImpl.this.handlerSuccess(callback, str, looper);
            }

            public void onFailure(fso fso) {
                if (fso != null) {
                    PluginHostApiImpl.this.handlerFailed(callback, fso.f17063O000000o, fso.O00000Oo, looper);
                } else {
                    PluginHostApiImpl.this.handlerFailed(callback, -1, "", looper);
                }
            }
        });
    }

    public void getCloudVideoFile(Context context, String str, ICloudDataCallback iCloudDataCallback) {
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("did");
                String optString2 = jSONObject.optString("fileId");
                String optString3 = jSONObject.optString("stoId");
                String optString4 = jSONObject.optString("filePath");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    CameraRouterFactory.getCameraCloudApi().getCloudFile(context, optString, optString2, optString3, optString4, iCloudDataCallback);
                } else if (iCloudDataCallback != null) {
                    iCloudDataCallback.onCloudDataFailed(-97, "params error");
                }
            } catch (JSONException unused) {
                if (iCloudDataCallback != null) {
                    iCloudDataCallback.onCloudDataFailed(-98, "JSONException");
                }
            }
        } else if (iCloudDataCallback != null) {
            iCloudDataCallback.onCloudDataFailed(-99, "context null");
        }
    }

    public void getCloudVideoFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
        CameraRouterFactory.getCameraCloudApi().getCloudVideoFile(str, str2, str3, iCloudDataCallback);
    }

    public void getCloudVideoFile(String str, String str2, String str3, boolean z, ICloudDataCallback iCloudDataCallback) {
        CameraRouterFactory.getCameraCloudApi().getCloudVideoFile(str, str2, str3, z, iCloudDataCallback);
    }

    public void cancelDownloadFile(String str, String str2, boolean z, String str3, ICloudDataCallback iCloudDataCallback) {
        CameraRouterFactory.getCameraCloudApi().cancelDownloadFile(str, str2, z, str3, iCloudDataCallback);
    }

    public String getCloudImageUrl(String str, String str2, String str3) {
        return CameraRouterFactory.getCameraCloudApi().getCloudImageUrl(str, str2, str3);
    }

    public byte[] sendImageDownloadRequest(Context context, String str) {
        HttpURLConnection httpURLConnection;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (str.startsWith("https")) {
                    URL url = new URL(str);
                    int i = 0;
                    if (goe.O00000o(context)) {
                        HttpURLConnection.setFollowRedirects(false);
                        String O000000o2 = goe.O000000o(url);
                        String host = url.getHost();
                        URL url2 = new URL(O000000o2);
                        dxx.O000000o();
                        httpURLConnection = (HttpURLConnection) dxx.O000000o(url2);
                        httpURLConnection.setRequestProperty("X-Online-Host", host);
                        int responseCode = httpURLConnection.getResponseCode();
                        while (responseCode >= 300 && responseCode < 400) {
                            String headerField = httpURLConnection.getHeaderField("location");
                            if (TextUtils.isEmpty(headerField)) {
                                break;
                            }
                            URL url3 = new URL(headerField);
                            String O000000o3 = goe.O000000o(url3);
                            String host2 = url3.getHost();
                            URL url4 = new URL(O000000o3);
                            dxx.O000000o();
                            HttpURLConnection httpURLConnection2 = (HttpURLConnection) dxx.O000000o(url4);
                            httpURLConnection2.setRequestProperty("X-Online-Host", host2);
                            HttpURLConnection httpURLConnection3 = httpURLConnection2;
                            responseCode = httpURLConnection2.getResponseCode();
                            httpURLConnection = httpURLConnection3;
                        }
                    } else {
                        dxx.O000000o();
                        httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
                        HttpURLConnection.setFollowRedirects(true);
                    }
                    httpURLConnection.setRequestProperty("Cookie", "yetAnotherServiceToken=" + CameraRouterFactory.getCameraCloudApi().getServiceToken());
                    httpURLConnection.setConnectTimeout(C.MSG_CUSTOM_BASE);
                    httpURLConnection.setReadTimeout(15000);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    int contentLength = httpURLConnection.getContentLength();
                    byte[] bArr = new byte[contentLength];
                    while (i < contentLength) {
                        try {
                            int read = inputStream.read(bArr, i, contentLength - i);
                            if (read != -1) {
                                i += read;
                            }
                        } catch (Exception unused) {
                            return null;
                        }
                    }
                    return CameraRouterFactory.getCameraCloudApi().cloudVideoDecrypt(bArr);
                }
            } catch (IOException unused2) {
            }
        }
        return null;
    }

    static final URLConnection openConnection_aroundBody0(PluginHostApiImpl pluginHostApiImpl, URL url) {
        return url.openConnection();
    }

    static final URLConnection openConnection_aroundBody2(PluginHostApiImpl pluginHostApiImpl, URL url) {
        return url.openConnection();
    }

    static final URLConnection openConnection_aroundBody4(PluginHostApiImpl pluginHostApiImpl, URL url) {
        return url.openConnection();
    }

    public void createDeviceGroup(Context context, String str) {
        Intent intent = new Intent(context, ModifyGroupActivity.class);
        intent.putExtra("group_model", str);
        intent.putExtra("from", "plugin_device_group");
        context.startActivity(intent);
    }

    public boolean isUsrExpPlanEnabled(String str) {
        try {
            return etx.O000000o().O00000Oo().isUsrExpPlanEnabled(str);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public void setUsrExpPlanEnabled(String str, boolean z) {
        try {
            etx.O000000o().O00000Oo().setUsrExpPlanEnabled(str, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DeviceStat> getFilterBluetoothDeviceList(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            List<DeviceStatus> filterBluetoothDeviceList = etx.O000000o().O00000Oo().getFilterBluetoothDeviceList(str);
            if (filterBluetoothDeviceList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : filterBluetoothDeviceList) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public ProductInfo getProductInfo(String str) {
        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(str);
        if (O00000oO == null) {
            return null;
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.model = O00000oO.O00000Oo();
        productInfo.name = O00000oO.O0000Oo0();
        productInfo.iconReal = O00000oO.O0000o0();
        productInfo.productId = O00000oO.O00000o0();
        productInfo.desc = O00000oO.O0000o0o();
        return productInfo;
    }

    public MJExoPlayer createExoPlayer(Context context, ViewGroup viewGroup, AttributeSet attributeSet, int i) {
        return CameraRouterFactory.getCameraPlayerApi().createExoPlayer(context, viewGroup, attributeSet, i);
    }

    public String generateRequestUrl(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        return CameraRouterFactory.getCameraCloudApi().generateRequestUrl(str, jSONObject, jSONObject2);
    }

    public String generateRequestUrl2(String str, String str2, String str3, boolean z, String str4) {
        return CameraRouterFactory.getCameraCloudApi().generateRequestUrl2(str, str2, str3, z, str4);
    }

    public HLSDownloader getHLSDownloader(String str) {
        return CameraRouterFactory.getCameraCloudApi().getHLSDownloader(str);
    }

    public List<DeviceStat> getBleGatewayDeviceList() {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            List<DeviceStatus> bleGatewayDeviceList = etx.O000000o().O00000Oo().getBleGatewayDeviceList();
            if (bleGatewayDeviceList == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : bleGatewayDeviceList) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public DeviceController getSpecDeviceController(String str) {
        try {
            String specInstanceStr = etx.O000000o().O00000Oo().getSpecInstanceStr(str);
            if (TextUtils.isEmpty(specInstanceStr)) {
                return null;
            }
            return hfd.O000000o(new JSONObject(specInstanceStr)).createController(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void getBleMeshFirmwareUpdateInfo(String str, final String str2, Callback<BleMeshFirmwareUpdateInfo> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            callSmartHomeApi(str, "/v2/device/latest_ver", jSONObject, callback, new Parser<BleMeshFirmwareUpdateInfo>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass41 */

                public BleMeshFirmwareUpdateInfo parse(String str) throws JSONException {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    Device O000000o2 = fno.O000000o().O000000o(str2);
                    if (O000000o2 != null && !TextUtils.isEmpty(O000000o2.mac)) {
                        ffr.O0000o(O000000o2.mac, str);
                    }
                    return PluginHostApiImpl.this.parseVersionResponse(str, O000000o2);
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public BleMeshFirmwareUpdateInfo parseVersionResponse(String str, Device device) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        BleMeshFirmwareUpdateInfo bleMeshFirmwareUpdateInfo = new BleMeshFirmwareUpdateInfo();
        bleMeshFirmwareUpdateInfo.version = jSONObject.optString("version");
        bleMeshFirmwareUpdateInfo.safeUrl = jSONObject.optString("safe_url");
        bleMeshFirmwareUpdateInfo.timeout = jSONObject.optInt("time_out", 30);
        bleMeshFirmwareUpdateInfo.url = jSONObject.optString("url");
        bleMeshFirmwareUpdateInfo.changeLog = jSONObject.optString("changeLog");
        bleMeshFirmwareUpdateInfo.md5 = jSONObject.optString("md5");
        if (device != null) {
            fap.O000000o.f16027O000000o.O000000o(device.mac).O000000o(bleMeshFirmwareUpdateInfo.version);
        }
        String optString = jSONObject.optString("mcu_version");
        String optString2 = jSONObject.optString("mcu_safe_url");
        String optString3 = jSONObject.optString("mcu_md5");
        if (!TextUtils.isEmpty(optString)) {
            McuUpdateInfo mcuUpdateInfo = new McuUpdateInfo();
            mcuUpdateInfo.version = optString;
            mcuUpdateInfo.url = optString2;
            mcuUpdateInfo.md5 = optString3;
            bleMeshFirmwareUpdateInfo.mcuUpdateInfo = mcuUpdateInfo;
        }
        return bleMeshFirmwareUpdateInfo;
    }

    public String getVirtualGroupStatus(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return "3";
        }
        try {
            return etx.O000000o().O00000Oo().getVirtualGroupStatus(str);
        } catch (Exception e) {
            e.printStackTrace();
            return "3";
        }
    }

    public void getPropertyValues(Context context, List<PropertyParam> list, final Callback<List<PropertyParam>> callback) {
        if (callback != null) {
            if (list == null) {
                callback.onFailure(-9999, null);
            } else {
                faw.O00000o().getDeviceSpecProp(context, list, new fsm<List<PropertyParam>, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass42 */

                    public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                        onSuccess((List<PropertyParam>) ((List) obj));
                    }

                    public void onSuccess(List<PropertyParam> list) {
                        if (list == null || list.size() == 0) {
                            callback.onFailure(-9, null);
                        } else {
                            callback.onSuccess(list);
                        }
                    }

                    public void onFailure(fso fso) {
                        callback.onFailure(fso.f17063O000000o, null);
                    }
                });
            }
        }
    }

    public void setPropertyValue(Context context, PropertyParam propertyParam, final Callback<PropertyParam> callback) {
        if (callback != null) {
            if (propertyParam == null) {
                callback.onFailure(-9999, null);
            } else {
                faw.O00000o().setDeviceSpecProp(context, propertyParam, new fsm<PropertyParam, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass43 */

                    public void onSuccess(PropertyParam propertyParam) {
                        if (propertyParam == null) {
                            callback.onFailure(-9, null);
                        } else {
                            callback.onSuccess(propertyParam);
                        }
                    }

                    public void onFailure(fso fso) {
                        callback.onFailure(fso.f17063O000000o, null);
                    }
                });
            }
        }
    }

    public void doAction(Context context, ActionParam actionParam, final Callback<ActionParam> callback) {
        if (callback != null) {
            if (actionParam == null) {
                callback.onFailure(-9999, null);
            } else {
                faw.O00000o().setDeviceSpecAction(context, actionParam, new fsm<ActionParam, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass44 */

                    public void onSuccess(ActionParam actionParam) {
                        if (actionParam == null) {
                            callback.onFailure(-9, null);
                        } else {
                            callback.onSuccess(actionParam);
                        }
                    }

                    public void onFailure(fso fso) {
                        callback.onFailure(fso.f17063O000000o, null);
                    }
                });
            }
        }
    }

    public int videoConverter(String str, String str2) {
        gsy.O00000Oo("videoConverter", "model:" + str + " cmdLine:" + str2);
        return CameraRouterFactory.getCameraCloudApi().videoConverter(str, str2);
    }

    public void setWxPush(Activity activity, String str, String str2, boolean z, int i, Callback<Boolean> callback) {
        iaj.O000000o().O000000o(activity, str, str2, z, i, callback);
    }

    public void getWxPushSwitchState(String str, String str2, Callback<Boolean> callback) {
        iaj.O000000o().O000000o(str, str2, callback);
    }

    public void getAreaPropInfo(String str, String str2, String str3, String str4, String str5, Callback<String> callback) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str4)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("area_id", str2);
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    jSONObject.put("latitude", str4);
                    jSONObject.put("longitude", str3);
                }
                if (!TextUtils.isEmpty(str5)) {
                    jSONObject.put("cityId", str5);
                }
            } catch (JSONException unused) {
            }
            callSmartHomeApi(str, "/location/area_prop_info", jSONObject, callback, new Parser<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass45 */

                public String parse(String str) throws JSONException {
                    return str;
                }
            });
            return;
        }
        throw new IllegalArgumentException("areaId or latitude-longitude must be passed in !");
    }

    public void getFile(String str, String str2, String str3, ICloudDataCallback iCloudDataCallback) {
        CameraRouterFactory.getCameraCloudApi().downloadCloudFile(str, str2, str3, iCloudDataCallback);
    }

    public void getBluetoothFirmwareUpdateInfoV2(String str, String str2, int i, Callback<BtFirmwareUpdateInfoV2> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("model", str2);
            jSONObject.put("plugin_level", String.valueOf(i));
            jSONObject.put("platform", "android");
            Context context = context();
            if (context != null) {
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                    StringBuilder sb = new StringBuilder();
                    sb.append(packageInfo.versionCode);
                    jSONObject.put("app_level", sb.toString());
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            callSmartHomeApi(str2, "/v2/device/latest_ver", jSONObject, callback, new Parser<BtFirmwareUpdateInfoV2>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass46 */

                public BtFirmwareUpdateInfoV2 parse(String str) throws JSONException {
                    if (TextUtils.isEmpty(str)) {
                        return null;
                    }
                    JSONObject jSONObject = new JSONObject(str);
                    BtFirmwareUpdateInfoV2 btFirmwareUpdateInfoV2 = new BtFirmwareUpdateInfoV2();
                    btFirmwareUpdateInfoV2.version = jSONObject.optString("version");
                    btFirmwareUpdateInfoV2.url = jSONObject.optString("url");
                    btFirmwareUpdateInfoV2.safeUrl = jSONObject.optString("safe_url");
                    btFirmwareUpdateInfoV2.changeLog = jSONObject.optString("changeLog");
                    btFirmwareUpdateInfoV2.md5 = jSONObject.optString("md5");
                    btFirmwareUpdateInfoV2.uploadTime = jSONObject.optLong("upload_time");
                    return btFirmwareUpdateInfoV2;
                }
            });
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public void getBleGatewaySubDevices(List<String> list, final Callback<List<DeviceStat>> callback) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.getBleGatewaySubDevices(list, new IPluginCallbackDeviceList.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass47 */

                    public void onRequestSuccess(List<DeviceStatus> list) throws RemoteException {
                        ArrayList arrayList = new ArrayList();
                        if (list != null && list.size() > 0) {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                arrayList.add(list.get(i).O000000o());
                            }
                        }
                        callback.onSuccess(arrayList);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                callback.onFailure(-1, e.toString());
            }
        }
    }

    public IXmStreamClient createStreamClient(String str, String str2, DeviceStat deviceStat) {
        return CameraRouterFactory.getCameraPlayerApi().createStreamClient(str, str2, deviceStat);
    }

    public final void initBandManager(String str, String str2, final Callback<Boolean> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().initBandManager(str, str2, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass48 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Boolean.TRUE);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void deInitBandManager() {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().deInitBandManager();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void connectBand(String str, final Callback<Integer> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().connectBand(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass49 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Integer.valueOf(Integer.parseInt(str)));
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getAllCards(final Callback<String> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().getAllCards(new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass50 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(str);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void issueDoorCard(final Callback<Boolean> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().issueDoorCard(new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass51 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Boolean.TRUE);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteCard(String str, final Callback<Boolean> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().deleteCard(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass52 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Boolean.TRUE);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void setDefaultCard(String str, final Callback<Boolean> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().setDefaultCard(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass53 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Boolean.TRUE);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateCard(String str, final Callback<Boolean> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().updateCard(str, new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass54 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(Boolean.TRUE);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getDefaultCardAndActivateInfo(final Callback<String> callback) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().getDefaultCardAndActivateInfo(new IPluginCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass55 */

                    public void onRequestSuccess(String str) throws RemoteException {
                        callback.onSuccess(str);
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void getRecommendScenes(String str, String str2, Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(this.did)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("did", str2);
                if (str != null) {
                    jSONObject.put("model", str);
                }
                jSONObject.put("api_version", 5);
            } catch (JSONException e) {
                if (callback != null) {
                    callback.onFailure(-1, e.toString());
                    return;
                }
            }
            callSmartHomeApi(str, "/v2/scene/get_rec_in_plugin", jSONObject, callback, new Parser(str2) {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.$$Lambda$PluginHostApiImpl$mxdYfYzrGNfZebal5i2V3Isceo */
                private final /* synthetic */ String f$0;

                {
                    this.f$0 = r1;
                }

                public final Object parse(String str) {
                    return PluginHostApiImpl.lambda$getRecommendScenes$3(this.f$0, str);
                }
            });
        } else if (callback != null) {
            callback.onFailure(-1, "deviceId is illegal");
        }
    }

    static /* synthetic */ JSONObject lambda$getRecommendScenes$3(String str, String str2) throws JSONException {
        gpy.O000000o(CommonApplication.getAppContext(), "scene_list_cache", "plugin_recommend_scene_".concat(String.valueOf(str)), str2);
        if (!TextUtils.isEmpty(str2)) {
            return new JSONObject(str2);
        }
        return null;
    }

    public void getRecommendScenes2(String str, String str2, Callback<JSONObject> callback) {
        if (!TextUtils.isEmpty(this.did)) {
            Home home = null;
            try {
                home = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o(this.did);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            if (home != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("did", str2);
                    jSONObject.put("max_version", "3.0");
                    jSONObject.put("home_id", home.getId());
                    jSONObject.put("limit", 2);
                    jSONObject.put("page", 1);
                    jSONObject.put("plugin", 1);
                } catch (JSONException e2) {
                    if (callback != null) {
                        callback.onFailure(-1, e2.toString());
                        return;
                    }
                }
                callSmartHomeApi(str, "/appgateway/miot/appsceneservice/AppSceneService/GetTemplateList", jSONObject, callback, $$Lambda$PluginHostApiImpl$xMR3AMHalxniHr1G97l_H3hA.INSTANCE);
            } else if (callback != null) {
                callback.onFailure(-1, "home is illegal");
            }
        } else if (callback != null) {
            callback.onFailure(-1, "deviceId is illegal");
        }
    }

    static /* synthetic */ JSONObject lambda$getRecommendScenes2$4(String str) throws JSONException {
        if (!TextUtils.isEmpty(str)) {
            return new JSONObject(str);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    public void editSceneV2(String str, int i, String str2, String str3, String str4, String str5, JSONObject jSONObject, JSONArray jSONArray, Callback<JSONObject> callback) {
        SceneInfo sceneInfo;
        int i2 = i;
        Callback<JSONObject> callback2 = callback;
        if (!TextUtils.isEmpty(str2)) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("us_id", str2);
                jSONObject2.put("st_id", i2);
                try {
                    jSONObject2.put("name", str5);
                    try {
                        jSONObject2.put("setting", jSONObject);
                    } catch (JSONException e) {
                        e = e;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    e.printStackTrace();
                    sceneInfo = hor.O000000o().getSceneInfo(jSONObject2, i2 == 15);
                    if (sceneInfo == null) {
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                e.printStackTrace();
                sceneInfo = hor.O000000o().getSceneInfo(jSONObject2, i2 == 15);
                if (sceneInfo == null) {
                }
            }
            sceneInfo = hor.O000000o().getSceneInfo(jSONObject2, i2 == 15);
            if (sceneInfo == null) {
                if (callback2 != null) {
                    callback2.onFailure(-1, "scene is null ,jsonexception?");
                }
            } else if (!TextUtils.isEmpty(isFromOneDevice(sceneInfo))) {
                final JSONObject jSONObject3 = jSONObject;
                final String str6 = str;
                final int i3 = i;
                final String str7 = str2;
                final String str8 = str4;
                final String str9 = str5;
                final JSONArray jSONArray2 = jSONArray;
                final Callback<JSONObject> callback3 = callback;
                hor.O000000o().buildExtra(sceneInfo, new Callback<SceneInfo>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass56 */

                    public void onSuccess(SceneInfo sceneInfo) {
                        JSONObject optJSONObject;
                        if (sceneInfo != null) {
                            for (int i = 0; i < sceneInfo.mLaunchList.size(); i++) {
                                JSONObject optJSONObject2 = jSONObject3.optJSONObject("launch");
                                if (optJSONObject2 != null) {
                                    try {
                                        optJSONObject2.optJSONArray("attr").optJSONObject(i).put("extra", sceneInfo.mLaunchList.get(i).mExtra);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            for (int i2 = 0; i2 < sceneInfo.mActions.size(); i2++) {
                                JSONArray optJSONArray = jSONObject3.optJSONArray("action_list");
                                if (!(optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(i2).optJSONObject("payload")) == null)) {
                                    try {
                                        if (optJSONObject.has("extra")) {
                                            optJSONObject.remove("extra");
                                        }
                                        optJSONObject.put("extra", sceneInfo.mActions.get(i2).mExtra);
                                    } catch (JSONException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }
                        PluginHostApiImpl.this.startSaveScene(str6, i3, str7, str8, str9, jSONObject3, jSONArray2, callback3);
                    }

                    public void onFailure(int i, String str) {
                        Callback callback = callback3;
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            } else {
                startSaveScene(str, i, str2, str4, str5, jSONObject, jSONArray, callback);
            }
        } else if (callback2 != null) {
            callback2.onFailure(-1, "us_id is illegal");
        }
    }

    private String isFromOneDevice(SceneInfo sceneInfo) {
        DeviceStatus deviceStatus;
        DeviceStatus deviceStatus2;
        DeviceStatus deviceStatus3;
        DeviceStatus deviceStatus4;
        boolean z = false;
        String str = null;
        for (SceneInfo.ConditionDevice next : sceneInfo.mConditionDevice) {
            if (next.model != null) {
                try {
                    deviceStatus3 = etx.O000000o().O00000Oo().getDevice(next.did);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    deviceStatus3 = null;
                }
                if (deviceStatus3 != null) {
                    String str2 = TextUtils.isEmpty(deviceStatus3.O0000O0o) ? deviceStatus3.f6611O000000o : deviceStatus3.O0000O0o;
                    try {
                        deviceStatus4 = etx.O000000o().O00000Oo().getDevice(str2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        deviceStatus4 = null;
                    }
                    if (deviceStatus4 != null && hor.O000000o().isLvMiModel(deviceStatus4.O00000o)) {
                        str = str2;
                        z = true;
                    }
                }
            }
        }
        if (!z) {
            for (SceneInfo.SceneAction next2 : sceneInfo.mActions) {
                if (!(next2.mDeviceModel == null || next2.mDid == null)) {
                    try {
                        deviceStatus = etx.O000000o().O00000Oo().getDevice(next2.mDid);
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        deviceStatus = null;
                    }
                    if (deviceStatus != null) {
                        String str3 = TextUtils.isEmpty(deviceStatus.O0000O0o) ? deviceStatus.f6611O000000o : deviceStatus.O0000O0o;
                        try {
                            deviceStatus2 = etx.O000000o().O00000Oo().getDevice(str3);
                        } catch (RemoteException e4) {
                            e4.printStackTrace();
                            deviceStatus2 = null;
                        }
                        if (deviceStatus2 != null && hor.O000000o().isLvMiModel(deviceStatus2.O00000o)) {
                            str = str3;
                            z = true;
                        }
                    }
                }
            }
        }
        if (z) {
            return str;
        }
        return null;
    }

    public void startSaveScene(final String str, final int i, String str2, String str3, String str4, JSONObject jSONObject, JSONArray jSONArray, final Callback<JSONObject> callback) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("us_id", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put("identify", str3);
            }
            if (str4 != null) {
                jSONObject2.put("name", str4);
            }
            jSONObject2.put("st_id", i);
            jSONObject2.put("setting", jSONObject);
            jSONObject2.put("authed", jSONArray);
        } catch (JSONException e) {
            if (callback != null) {
                callback.onFailure(-1, e.toString());
                return;
            }
        }
        callSmartHomeApi(str, "/scene/editv2", jSONObject2, new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass57 */

            public void onSuccess(JSONObject jSONObject) {
                final String optString = jSONObject.optString("us_id");
                boolean optBoolean = jSONObject.optBoolean("local");
                String optString2 = jSONObject.optString("local_dev");
                if (TextUtils.isEmpty(optString2) || !optBoolean) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onSuccess(jSONObject);
                        return;
                    }
                    return;
                }
                hor.O000000o().builderLocalScene(PluginHostApiImpl.this.getDeviceByDid(optString2), jSONObject.optJSONObject("data").toString(), new MessageCallback() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass57.AnonymousClass1 */

                    public void onSuccess(Intent intent) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("us_id", optString);
                            jSONObject.put("type", 1);
                            jSONObject.put("status", 0);
                            jSONObject.put("st_id", i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        PluginHostApiImpl.this.callSmartHomeApi(str, "/scene/setuserscene", jSONObject, callback, $$Lambda$PluginHostApiImpl$57$1$bNepd8trpJM2ONf1HqsjguVUK20.INSTANCE);
                    }

                    static /* synthetic */ JSONObject lambda$onSuccess$0(String str) throws JSONException {
                        return new JSONObject(str);
                    }

                    public void onFailure(int i, String str) {
                        if (callback != null) {
                            callback.onFailure(i, str);
                        }
                    }
                });
            }

            public void onFailure(int i, String str) {
                if (i == -23) {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onFailure(-23, "此智能与已有智能会形成死循环，无法创建");
                    }
                } else if (i == -22) {
                    Callback callback2 = callback;
                    if (callback2 != null) {
                        callback2.onFailure(-23, "智能个数已达到最大限制，无法添加");
                    }
                } else if (i == -1) {
                    Callback callback3 = callback;
                    if (callback3 != null) {
                        callback3.onFailure(-1, "操作失败，包含已删除设备");
                    }
                } else if (i == -38) {
                    Callback callback4 = callback;
                    if (callback4 != null) {
                        callback4.onFailure(-1, "暂不支持手动/自动条件的转换");
                    }
                } else {
                    Callback callback5 = callback;
                    if (callback5 != null) {
                        callback5.onFailure(i, "创建失败！");
                    }
                }
            }
        }, $$Lambda$PluginHostApiImpl$5QbDPRVkCHbHVC6B0SbZO6Hy0Mk.INSTANCE);
    }

    static /* synthetic */ JSONObject lambda$startSaveScene$5(String str) throws JSONException {
        return new JSONObject(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        _m_j.gsy.O000000o(6, "byte2File", "byte2File IOException 1:" + r4.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01d1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01d2, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:?, code lost:
        _m_j.gsy.O000000o(6, "byte2File", "byte2File IOException 2:" + r2.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        r1 = r0;
        r20 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0140, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0141, code lost:
        r20 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0161, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0162, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        _m_j.gsy.O000000o(6, "byte2File", "byte2File IOException 1:" + r1.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x017d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x017e, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:?, code lost:
        r0 = "byte2File IOException 2:" + r1.getLocalizedMessage();
        r1 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01b5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b6, code lost:
        r4 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01cd A[SYNTHETIC, Splitter:B:102:0x01cd] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b6 A[LOOP:1: B:140:0x02b0->B:142:0x02b6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0140 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:28:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x015d A[SYNTHETIC, Splitter:B:77:0x015d] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0179 A[SYNTHETIC, Splitter:B:84:0x0179] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b1 A[SYNTHETIC, Splitter:B:95:0x01b1] */
    public void uploadImageFile(String str, String str2, String str3, String str4, JSONObject jSONObject, List<String> list, ICloudDataCallback<JSONObject> iCloudDataCallback) {
        byte[] bArr;
        String str5;
        String str6;
        byte[] bArr2;
        Iterator<String> it;
        String str7;
        String substring;
        BufferedOutputStream bufferedOutputStream;
        FileOutputStream fileOutputStream;
        Throwable th;
        JSONObject jSONObject2 = jSONObject;
        final ICloudDataCallback<JSONObject> iCloudDataCallback2 = iCloudDataCallback;
        String str8 = ".";
        String str9 = "/";
        if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4) && jSONObject2 != null && list != null) {
            byte[] encode = Base64.encode(gwb.O000000o().f18400O000000o.getIV(), 2);
            final ArrayList<String> arrayList = new ArrayList<>();
            Iterator<String> it2 = list.iterator();
            byte[] bArr3 = null;
            while (it2.hasNext()) {
                String next = it2.next();
                try {
                    File file = new File(next);
                    if (file.exists()) {
                        if (file.isFile()) {
                            byte[] O0000OOo = gsc.O0000OOo(next);
                            if (O0000OOo != null) {
                                it = it2;
                                try {
                                    byte[] O000000o2 = gwb.O000000o().O000000o(O0000OOo);
                                    gwb.O000000o();
                                    bArr2 = bArr3;
                                    try {
                                        bArr2 = Base64.encode(gwb.O00000Oo(O000000o2), 2);
                                        substring = next.substring(0, next.lastIndexOf(str9));
                                        str6 = str9;
                                    } catch (Exception e) {
                                        e = e;
                                        str5 = str8;
                                        str6 = str9;
                                        bArr = encode;
                                        bArr3 = bArr2;
                                        gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 1:" + e.getLocalizedMessage());
                                        it2 = it;
                                        str9 = str6;
                                        str8 = str5;
                                        encode = bArr;
                                    }
                                    try {
                                        String substring2 = next.substring(next.lastIndexOf(str9), next.lastIndexOf(str8));
                                        String substring3 = next.substring(next.lastIndexOf(str8));
                                        String str10 = substring2 + "_enc" + substring3;
                                        str5 = str8;
                                        try {
                                            File file2 = new File(substring);
                                            if (!file2.exists()) {
                                                if (file2.isDirectory()) {
                                                    file2.mkdirs();
                                                }
                                            }
                                            StringBuilder sb = new StringBuilder();
                                            sb.append(substring);
                                            bArr = encode;
                                            try {
                                                sb.append(File.separator);
                                                sb.append(str10);
                                                fileOutputStream = new FileOutputStream(new File(sb.toString()));
                                            } catch (Exception e2) {
                                                e = e2;
                                                fileOutputStream = null;
                                                bufferedOutputStream = null;
                                                try {
                                                    gsy.O000000o(6, "byte2File", "byte2File Exception:" + e.getLocalizedMessage());
                                                    if (bufferedOutputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    arrayList.add(substring + substring2 + "_enc" + substring3);
                                                    bArr3 = bArr2;
                                                    it2 = it;
                                                    str9 = str6;
                                                    str8 = str5;
                                                    encode = bArr;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    if (bufferedOutputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                                th = th;
                                                fileOutputStream = null;
                                                bufferedOutputStream = null;
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                throw th;
                                            }
                                            try {
                                                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                                                try {
                                                    bufferedOutputStream.write(O000000o2);
                                                    try {
                                                        bufferedOutputStream.close();
                                                    } catch (IOException e3) {
                                                        IOException iOException = e3;
                                                        try {
                                                            gsy.O000000o(6, "byte2File", "byte2File IOException 1:" + iOException.getLocalizedMessage());
                                                        } catch (Exception e4) {
                                                            e = e4;
                                                            bArr3 = bArr2;
                                                            gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 1:" + e.getLocalizedMessage());
                                                            it2 = it;
                                                            str9 = str6;
                                                            str8 = str5;
                                                            encode = bArr;
                                                        }
                                                    }
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    gsy.O000000o(6, "byte2File", "byte2File Exception:" + e.getLocalizedMessage());
                                                    if (bufferedOutputStream != null) {
                                                    }
                                                    if (fileOutputStream != null) {
                                                    }
                                                    arrayList.add(substring + substring2 + "_enc" + substring3);
                                                    bArr3 = bArr2;
                                                    it2 = it;
                                                    str9 = str6;
                                                    str8 = str5;
                                                    encode = bArr;
                                                }
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException e6) {
                                                    IOException iOException2 = e6;
                                                    String str11 = "byte2File IOException 2:" + iOException2.getLocalizedMessage();
                                                    int i = 6;
                                                    gsy.O000000o(i, "byte2File", str11);
                                                    arrayList.add(substring + substring2 + "_enc" + substring3);
                                                    bArr3 = bArr2;
                                                    it2 = it;
                                                    str9 = str6;
                                                    str8 = str5;
                                                    encode = bArr;
                                                }
                                            } catch (Exception e7) {
                                                e = e7;
                                                bufferedOutputStream = null;
                                                gsy.O000000o(6, "byte2File", "byte2File Exception:" + e.getLocalizedMessage());
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                arrayList.add(substring + substring2 + "_enc" + substring3);
                                                bArr3 = bArr2;
                                                it2 = it;
                                                str9 = str6;
                                                str8 = str5;
                                                encode = bArr;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                bufferedOutputStream = null;
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                                throw th;
                                            }
                                        } catch (Exception e8) {
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bArr = encode;
                                            th = th;
                                            fileOutputStream = null;
                                            bufferedOutputStream = null;
                                            if (bufferedOutputStream != null) {
                                            }
                                            if (fileOutputStream != null) {
                                            }
                                            throw th;
                                        }
                                        arrayList.add(substring + substring2 + "_enc" + substring3);
                                        bArr3 = bArr2;
                                    } catch (Exception e9) {
                                        e = e9;
                                        str5 = str8;
                                        bArr = encode;
                                        bArr3 = bArr2;
                                        gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 1:" + e.getLocalizedMessage());
                                        it2 = it;
                                        str9 = str6;
                                        str8 = str5;
                                        encode = bArr;
                                    }
                                } catch (Exception e10) {
                                    e = e10;
                                    str7 = str8;
                                    str6 = str9;
                                    bArr = encode;
                                    bArr2 = bArr3;
                                    gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 1:" + e.getLocalizedMessage());
                                    it2 = it;
                                    str9 = str6;
                                    str8 = str5;
                                    encode = bArr;
                                }
                            } else {
                                str5 = str8;
                                str6 = str9;
                                bArr = encode;
                                it = it2;
                                bArr2 = bArr3;
                            }
                            it2 = it;
                            str9 = str6;
                            str8 = str5;
                            encode = bArr;
                        }
                    }
                    String str12 = str8;
                    String str13 = str9;
                    byte[] bArr4 = encode;
                    Iterator<String> it3 = it2;
                    byte[] bArr5 = bArr3;
                    if (iCloudDataCallback2 != null) {
                        iCloudDataCallback2.onCloudDataFailed(-445, "file not exist");
                        return;
                    }
                    return;
                } catch (Exception e11) {
                    e = e11;
                    str7 = str8;
                    str6 = str9;
                    bArr = encode;
                    it = it2;
                    bArr2 = bArr3;
                    gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 1:" + e.getLocalizedMessage());
                    it2 = it;
                    str9 = str6;
                    str8 = str5;
                    encode = bArr;
                }
            }
            byte[] bArr6 = bArr3;
            try {
                JSONObject jSONObject3 = jSONObject;
                try {
                    jSONObject3.put("iv", new String(encode, Charset.forName("UTF-8")));
                    if (bArr6 != null) {
                        jSONObject3.put("imgSign", new String(bArr6, Charset.forName("UTF-8")));
                    }
                } catch (Exception e12) {
                    e = e12;
                    gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 2:" + e.getLocalizedMessage());
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject.toString()));
                    ArrayList arrayList3 = new ArrayList();
                    while (r2.hasNext()) {
                    }
                    NetRequest.O000000o O000000o3 = new NetRequest.O000000o().O000000o("POST").O00000o0(str3).O00000Oo(str4).O000000o(arrayList2);
                    O000000o3.O00000oo = arrayList3;
                    CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), O000000o3.O000000o(), new fss<JSONObject>() {
                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass58 */

                        public JSONObject parse(JSONObject jSONObject) throws JSONException {
                            return jSONObject;
                        }
                    }, Crypto.RC4, new fsm<JSONObject, fso>() {
                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass59 */

                        public void onSuccess(JSONObject jSONObject) {
                            for (String O00000o : arrayList) {
                                try {
                                    ftd.O00000o(O00000o);
                                } catch (Exception e) {
                                    gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                                }
                            }
                            ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                            if (iCloudDataCallback != null) {
                                iCloudDataCallback.onCloudDataSuccess(jSONObject, null);
                            }
                        }

                        public void onFailure(fso fso) {
                            for (String O00000o : arrayList) {
                                try {
                                    ftd.O00000o(O00000o);
                                } catch (Exception e) {
                                    gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                                }
                            }
                            ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                            if (iCloudDataCallback == null) {
                                return;
                            }
                            if (fso != null) {
                                iCloudDataCallback.onCloudDataFailed(fso.f17063O000000o, fso.O00000Oo);
                            } else {
                                iCloudDataCallback.onCloudDataFailed(-446, "uploadImageFile failed");
                            }
                        }
                    });
                }
            } catch (Exception e13) {
                e = e13;
                gsy.O000000o(6, "XmPluginHostApiImpl", "uploadImageFile 2:" + e.getLocalizedMessage());
                ArrayList arrayList22 = new ArrayList();
                arrayList22.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject.toString()));
                ArrayList arrayList32 = new ArrayList();
                while (r2.hasNext()) {
                }
                NetRequest.O000000o O000000o32 = new NetRequest.O000000o().O000000o("POST").O00000o0(str3).O00000Oo(str4).O000000o(arrayList22);
                O000000o32.O00000oo = arrayList32;
                CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), O000000o32.O000000o(), new fss<JSONObject>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass58 */

                    public JSONObject parse(JSONObject jSONObject) throws JSONException {
                        return jSONObject;
                    }
                }, Crypto.RC4, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass59 */

                    public void onSuccess(JSONObject jSONObject) {
                        for (String O00000o : arrayList) {
                            try {
                                ftd.O00000o(O00000o);
                            } catch (Exception e) {
                                gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                            }
                        }
                        ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                        if (iCloudDataCallback != null) {
                            iCloudDataCallback.onCloudDataSuccess(jSONObject, null);
                        }
                    }

                    public void onFailure(fso fso) {
                        for (String O00000o : arrayList) {
                            try {
                                ftd.O00000o(O00000o);
                            } catch (Exception e) {
                                gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                            }
                        }
                        ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                        if (iCloudDataCallback == null) {
                            return;
                        }
                        if (fso != null) {
                            iCloudDataCallback.onCloudDataFailed(fso.f17063O000000o, fso.O00000Oo);
                        } else {
                            iCloudDataCallback.onCloudDataFailed(-446, "uploadImageFile failed");
                        }
                    }
                });
            }
            ArrayList arrayList222 = new ArrayList();
            arrayList222.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair("data", jSONObject.toString()));
            ArrayList arrayList322 = new ArrayList();
            for (String str14 : arrayList) {
                arrayList322.add(new com.xiaomi.smarthome.core.entity.net.KeyValuePair(str14, str14));
            }
            NetRequest.O000000o O000000o322 = new NetRequest.O000000o().O000000o("POST").O00000o0(str3).O00000Oo(str4).O000000o(arrayList222);
            O000000o322.O00000oo = arrayList322;
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), O000000o322.O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass58 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass59 */

                public void onSuccess(JSONObject jSONObject) {
                    for (String O00000o : arrayList) {
                        try {
                            ftd.O00000o(O00000o);
                        } catch (Exception e) {
                            gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                        }
                    }
                    ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                    if (iCloudDataCallback != null) {
                        iCloudDataCallback.onCloudDataSuccess(jSONObject, null);
                    }
                }

                public void onFailure(fso fso) {
                    for (String O00000o : arrayList) {
                        try {
                            ftd.O00000o(O00000o);
                        } catch (Exception e) {
                            gsy.O000000o(6, "XmPluginHostApiImpl", "deleteFile:" + e.getLocalizedMessage());
                        }
                    }
                    ICloudDataCallback iCloudDataCallback = iCloudDataCallback2;
                    if (iCloudDataCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        iCloudDataCallback.onCloudDataFailed(fso.f17063O000000o, fso.O00000Oo);
                    } else {
                        iCloudDataCallback.onCloudDataFailed(-446, "uploadImageFile failed");
                    }
                }
            });
        } else if (iCloudDataCallback2 != null) {
            iCloudDataCallback2.onCloudDataFailed(-444, "param(s) invalid");
        }
    }

    public int getUsePreviewConfig() {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                return O00000Oo.getUsePreviewConfig();
            } catch (RemoteException e) {
                gsy.O000000o(6, "XmPluginHostApiImpl", "getUsePreviewConfig:" + e.getLocalizedMessage());
            }
        }
        return 0;
    }

    public void refreshDeviceListUi() {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.refreshDeviceListUi();
            } catch (RemoteException e) {
                gsy.O000000o(6, "XmPluginHostApiImpl", "refreshDeviceListUi:" + e.getLocalizedMessage());
            }
        }
    }

    public DeviceTagInterface getDeviceTagManager() {
        return new fqv();
    }

    public void login(Context context, int i) {
        gty.O000000o().startLogin(CommonApplication.getAppContext(), i, null);
    }

    public boolean isDarkMode(Activity activity) {
        return gku.O000000o(activity.getApplicationContext());
    }

    public boolean isRNPluginDarkMode() {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return false;
        }
        try {
            return O00000Oo.isRNPluginDarkMode();
        } catch (RemoteException e) {
            gsy.O000000o(6, "XmPluginHostApiImpl", "isRNPluginDarkMode:" + e.getLocalizedMessage());
            return false;
        }
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, boolean z) {
        return CameraRouterFactory.getCameraPlayerApi().createConnectionClient(xmP2PInfo, deviceStat, z);
    }

    public IXmConnectionClient createConnectionClient(XmP2PInfo xmP2PInfo, DeviceStat deviceStat, String str, boolean z) {
        return CameraRouterFactory.getCameraPlayerApi().createConnectionClient(xmP2PInfo, deviceStat, str, z);
    }

    public void bleSpecOperation(String str, int i, String str2, final Callback<Bundle> callback) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.bleSpecOperation(str, i, str2, new IPluginCallback2.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass60 */

                    public void onRequestSuccess(Intent intent) throws RemoteException {
                        if (intent == null) {
                            callback.onSuccess(null);
                            return;
                        }
                        callback.onSuccess(intent.getExtras());
                    }

                    public void onRequestFailed(int i, String str) throws RemoteException {
                        callback.onFailure(i, str);
                    }
                });
            } catch (RemoteException e) {
                gsy.O000000o(6, "XmPluginHostApiImpl", "refreshDeviceListUi:" + e.getLocalizedMessage());
            }
        }
    }

    public void statReport(String str, String str2, Map<String, Object> map) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().statReport(str, str2, new Gson().toJson(map));
            } catch (RemoteException e) {
                LogType logType = LogType.PLUGIN;
                gsy.O00000o0(logType, "XmPluginHostApiImpl", "statReport:" + e.getLocalizedMessage());
            } catch (Exception e2) {
                LogType logType2 = LogType.PLUGIN;
                gsy.O00000o0(logType2, "XmPluginHostApiImpl", "statReport:" + e2.getLocalizedMessage());
            }
        }
    }

    public String getQrDebugModePackageName() {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                return O00000Oo.getQrDebugModePackageName();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public void downloadCloudVideoIntoCloudSetting(String str, String str2, boolean z, long j, long j2, Callback<Bundle> callback) {
        CameraRouterFactory.getCameraCloudApi().downloadCloudVideoIntoCloudSetting(str, str2, z, j, j2, callback);
    }

    public boolean shouldStartInCameraProcess(String str) {
        return CameraRouterFactory.getCameraPlayerApi().shouldStartInCameraProcess(str);
    }

    public void preConnectCamera() {
        CoreApi.O000000o().O000000o(context(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass61 */

            public void onCoreReady() {
                CameraRouterFactory.getCameraPlayerApi().cameraPreConnection();
            }
        });
    }

    public void disConnectCamera() {
        CoreApi.O000000o().O000000o(context(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass62 */

            public void onCoreReady() {
                CameraRouterFactory.getCameraPlayerApi().disConnectAll();
            }
        });
    }

    public void disableCameraAutoDisconnect(final DeviceStat deviceStat) {
        CoreApi.O000000o().O000000o(context(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass63 */

            public void onCoreReady() {
                CameraRouterFactory.getCameraPlayerApi().disableCameraAutoDisconnect(deviceStat);
            }
        });
    }

    public void enableCameraAutoDisconnect(final DeviceStat deviceStat) {
        CoreApi.O000000o().O000000o(context(), new CoreApi.O0000o0() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginHostApiImpl.AnonymousClass64 */

            public void onCoreReady() {
                CameraRouterFactory.getCameraPlayerApi().enableCameraAutoDisconnect(deviceStat);
            }
        });
    }

    public void openCameraFloatingView(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().openCameraFloatingWindow(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public List<DeviceStat> getCurrentHomeDevicesWithPid(int i) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        try {
            List<DeviceStatus> currentHomeDevicesWithPid = O00000Oo.getCurrentHomeDevicesWithPid(i);
            if (currentHomeDevicesWithPid == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : currentHomeDevicesWithPid) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DeviceStat> getCurrentHomeDevicesWithModel(String str) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        try {
            List<DeviceStatus> currentHomeDevicesWithModel = O00000Oo.getCurrentHomeDevicesWithModel(str);
            if (currentHomeDevicesWithModel == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (DeviceStatus O000000o2 : currentHomeDevicesWithModel) {
                arrayList.add(O000000o2.O000000o());
            }
            return arrayList;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveStringToNotesAppOnMIUI(String str, Callback<Void> callback) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("snippet", str);
        try {
            CommonApplication.getAppContext().getContentResolver().insert(Uri.parse("content://notes/note").buildUpon().appendQueryParameter("caller_is_blackboard_text", "true").build(), contentValues);
            callback.onSuccess(null);
        } catch (Exception e) {
            callback.onFailure(-1, "insert into notes fail," + e.toString());
        }
    }

    public void closeCameraFloatingView(String str) {
        closeCameraFloatingWindow(str);
    }

    public void onRNRuntimeReuseDisable(int i) {
        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "onRNRuntimeReuseDisable:".concat(String.valueOf(i)));
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.onRNRuntimeReuseDisable(i);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public String getOauthUserId() {
        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "getUserId");
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        try {
            String oauthUserId = O00000Oo.getOauthUserId();
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "getUserId:".concat(String.valueOf(oauthUserId)));
            return oauthUserId;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getOauthServiceToken() {
        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "getServiceToken");
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo == null) {
            return null;
        }
        try {
            String oauthServiceToken = O00000Oo.getOauthServiceToken();
            gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "getServiceToken:".concat(String.valueOf(oauthServiceToken)));
            return oauthServiceToken;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void invalideOauthServiceToken() {
        gsy.O00000o0(LogType.PLUGIN, "rn-plugin-framework", "miot-rn-plugin", "invalideServiceToken");
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.invalideOauthServiceToken();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendFeedbackLog(String str, String str2) {
        IPluginRequest O00000Oo = etx.O000000o().O00000Oo();
        if (O00000Oo != null) {
            try {
                O00000Oo.sendFeedbackLog(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
