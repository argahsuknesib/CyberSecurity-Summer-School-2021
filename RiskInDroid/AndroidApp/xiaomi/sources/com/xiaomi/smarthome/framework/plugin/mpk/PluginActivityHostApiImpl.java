package com.xiaomi.smarthome.framework.plugin.mpk;

import _m_j.etx;
import _m_j.exz;
import _m_j.eyx;
import _m_j.eyy;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsp;
import _m_j.fwq;
import _m_j.gii;
import _m_j.goy;
import _m_j.gsy;
import _m_j.hmq;
import _m_j.hor;
import _m_j.hqy;
import _m_j.hty;
import _m_j.hxi;
import _m_j.hyv;
import _m_j.inc;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.qrcode2.ScanBarcodeActivity;
import com.xiaomi.router.miio.miioplugin.IPluginCallback;
import com.xiaomi.router.miio.miioplugin.IPluginCallback2;
import com.xiaomi.router.miio.miioplugin.IPluginCallback3;
import com.xiaomi.smarthome.ad.api.AdPosition;
import com.xiaomi.smarthome.ad.api.Advertisement;
import com.xiaomi.smarthome.ad.api.IAdCallback;
import com.xiaomi.smarthome.ad.view.BannerAdView;
import com.xiaomi.smarthome.ad.view.NoticeAdView;
import com.xiaomi.smarthome.ad.view.PopAdActivity;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.FaceManagerCallback;
import com.xiaomi.smarthome.device.api.IRecommendSceneItemCallback;
import com.xiaomi.smarthome.device.api.ISceneInfoCallback;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.PluginRecommendSceneInfo;
import com.xiaomi.smarthome.device.api.RecommendSceneItem;
import com.xiaomi.smarthome.device.api.SceneInfo;
import com.xiaomi.smarthome.device.api.XmPluginBaseActivity;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.framework.page.DeviceMoreActivity;
import com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity;
import com.xiaomi.smarthome.framework.page.DeviceNetworkInfoActivity;
import com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordHistoryActivity;
import com.xiaomi.smarthome.framework.page.PictureShareActivity;
import com.xiaomi.smarthome.homeroom.HomeRoomRecommendActivity;
import com.xiaomi.smarthome.miio.activity.BleGatewayActivity;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import com.xiaomi.smarthome.scene.bean.DefaultSceneItemSet;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class PluginActivityHostApiImpl extends PluginActivityHostApi {
    public void showBottomDialogAd(Activity activity, String str, String str2) {
    }

    public void showUserLicenseDialog(Activity activity, String str, String str2, String str3, View.OnClickListener onClickListener) {
    }

    /* access modifiers changed from: package-private */
    public Looper getLooper() {
        Looper myLooper = Looper.myLooper();
        return myLooper == null ? Looper.getMainLooper() : myLooper;
    }

    public void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i) {
        if (deviceStat != null) {
            DeviceMoreActivity.openMoreMenu(activity, deviceStat.did, arrayList, z, i);
        }
    }

    public void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i) {
        if (deviceStat != null) {
            DeviceMoreActivity.openMoreMenu(activity, deviceStat.did, arrayList, arrayList2, z, i);
        }
    }

    public void openMoreMenu(Activity activity, String str, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i) {
        DeviceMoreActivity.openMoreMenu(activity, str, arrayList, arrayList2, z, i);
    }

    public void goUpdateActivity(Activity activity, DeviceStat deviceStat, Intent intent) {
        fbt fbt;
        if (deviceStat != null) {
            if (deviceStat.pid == Device.PID_BLUETOOTH || deviceStat.pid == Device.PID_BLE_MESH) {
                fbt = new fbt(activity, "BleUpgradeActivity");
            } else {
                fbt = new fbt(activity, "MiioUpgradeActivity");
            }
            if (intent != null) {
                fbt.O000000o(intent.getExtras());
            }
            fbt.O000000o("miio_upgrade_did", deviceStat.did);
            fbt.O000000o("miio_upgrade_pid", deviceStat.pid);
            fbt.O000000o("miio_upgrade_name", deviceStat.name);
            fbs.O000000o(fbt);
        }
    }

    public void goUpdateActivity(Activity activity, DeviceStat deviceStat) {
        goUpdateActivity(activity, deviceStat, null);
    }

    @Deprecated
    public void startLoadScene(final XmPluginBaseActivity xmPluginBaseActivity) {
        final Handler handler = new Handler(Looper.getMainLooper());
        AnonymousClass1 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass1 */

            public void onRequestSuccess(String str) throws RemoteException {
                handler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        xmPluginBaseActivity.onSceneLoaded(true);
                    }
                });
            }

            public void onRequestFailed(int i, String str) throws RemoteException {
                handler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass1.AnonymousClass2 */

                    public void run() {
                        xmPluginBaseActivity.onSceneLoaded(false);
                    }
                });
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateScene(null, r1);
            } else {
                handler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass2 */

                    public void run() {
                        xmPluginBaseActivity.onSceneLoaded(false);
                    }
                });
            }
        } catch (RemoteException unused) {
            handler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass3 */

                public void run() {
                    xmPluginBaseActivity.onSceneLoaded(false);
                }
            });
        }
    }

    public void startCreateSceneByDid(Activity activity, String str) {
        Intent intent = new Intent();
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            DefaultSceneItemSet defaultSceneItemSet = new DefaultSceneItemSet();
            defaultSceneItemSet.O00000Oo = new String[]{deviceByDid.model};
            defaultSceneItemSet.O00000oO = deviceByDid.did;
            new RecommendSceneItem.Key();
            defaultSceneItemSet.f11135O000000o = Boolean.FALSE;
            new ArrayList().add(defaultSceneItemSet);
        }
        intent.putExtra("from", 1);
        intent.putExtra("scene_stat_from", "scene_create_click_widget");
        intent.putExtra("extra_device_id", str);
        hor.O000000o().startCreateAutoScene(activity, intent);
    }

    public void startEditScene(Activity activity, int i) {
        if (i >= 0) {
            Intent intent = new Intent();
            intent.putExtra("extra_scene_id", String.valueOf(i));
            hor.O000000o().startCreateAutoScene(activity, intent);
        }
    }

    public void startEditScene(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent();
            intent.putExtra("extra_scene_id", String.valueOf(str));
            hor.O000000o().startCreateAutoScene(activity, intent);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void openPluginRecommendScene(Activity activity, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("did", str);
        intent.putExtra("sr_id", i);
        intent.putExtra("is_from_plugin", true);
        hor.O000000o().startPluginRecScene(activity, intent);
    }

    public void startSetTimerList(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        intent.putExtra("timer_manager", str7);
        hor.O000000o().startCommonTimer(activity, intent);
    }

    public void openFeedbackActivity(Activity activity, DeviceStat deviceStat) {
        if (deviceStat != null) {
            fbt fbt = new fbt(activity, "/userCenter/FeedbackActivity");
            fbt.O000000o("extra_device_did", deviceStat.did);
            fbt.O000000o("extra_source", 0);
            fbs.O000000o(fbt);
        }
    }

    public void addToLauncher(DeviceStat deviceStat) {
        if (deviceStat != null) {
            try {
                if (etx.O000000o().O00000Oo() != null) {
                    etx.O000000o().O00000Oo().addToLauncher(deviceStat.did, null);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public void loadWebView(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().loadWebView(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void loadUrl(String str, String str2) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().loadUrl(str, str2);
            }
        } catch (RemoteException unused) {
        }
    }

    public void loadUrl(String str, String str2, boolean z) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().loadUrlPro(str, str2, z);
            }
        } catch (RemoteException unused) {
        }
    }

    public void openShopActivity(String str) {
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().loadWebView("https://home.mi.com/shop/detail?gid=".concat(String.valueOf(str)), "");
            }
        } catch (RemoteException unused) {
        }
    }

    public void share(Activity activity, String str, String str2, String str3, String str4, String str5, Bitmap bitmap) {
        Intent intent = new Intent(activity, SharesActivity.class);
        intent.putExtra("shareTitle", str);
        intent.putExtra("shareContent", str2);
        intent.putExtra("shareUrl", str3);
        intent.putExtra("shareImageUrl", str4);
        intent.putExtra("shareThumbUrl", str5);
        activity.startActivity(intent);
    }

    public void startSearchNewDevice(String str, String str2, final IXmPluginHostActivity.DeviceFindCallback deviceFindCallback) {
        final Looper looper = getLooper();
        AnonymousClass4 r0 = new IPluginCallback2.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass4 */

            public void onRequestFailed(int i, String str) throws RemoteException {
                new Handler(looper).post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass4.AnonymousClass1 */

                    public void run() {
                        if (deviceFindCallback != null) {
                            deviceFindCallback.onDeviceFind(new ArrayList());
                        }
                    }
                });
            }

            public void onRequestSuccess(final Intent intent) throws RemoteException {
                new Handler(looper).post(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass4.AnonymousClass2 */

                    public void run() {
                        if (deviceFindCallback != null) {
                            deviceFindCallback.onDeviceFind(intent.getParcelableArrayListExtra("data"));
                        }
                    }
                });
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().startSearchNewDevice(str2, r0);
            } else if (deviceFindCallback != null) {
                deviceFindCallback.onDeviceFind(new ArrayList());
            }
        } catch (RemoteException unused) {
            if (deviceFindCallback != null) {
                deviceFindCallback.onDeviceFind(new ArrayList());
            }
        }
    }

    public void openSceneActivity(Activity activity, DeviceStat deviceStat, String str) {
        if (deviceStat != null) {
            Intent intent = new Intent();
            intent.putExtra("device_id", deviceStat.did);
            hor.O000000o().startDeviceSceneNewActivity(activity, intent);
        }
    }

    public void getDeviceRecommendScenes(String str, final IXmPluginHostActivity.AsyncCallback<List<RecommendSceneItem>> asyncCallback) {
        final Looper looper = getLooper();
        AnonymousClass5 r1 = new IRecommendSceneItemCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass5 */

            public void onRequestSuccess(List<RecommendSceneItem> list) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerSuccess(asyncCallback, list, looper);
            }

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerFailed(asyncCallback, i, str, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().loadRecommendScenes(str, r1);
            } else if (asyncCallback != null) {
                asyncCallback.onFailure(-1, "getService null");
            }
        } catch (RemoteException e) {
            if (asyncCallback != null) {
                asyncCallback.onFailure(-1, e.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void handlerSuccess(final IXmPluginHostActivity.AsyncCallback<T> asyncCallback, final T t, Looper looper) {
        if (asyncCallback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass6 */

                public void run() {
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback;
                    if (asyncCallback != null) {
                        asyncCallback.onSuccess(t);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void handlerFailed(final IXmPluginHostActivity.AsyncCallback<T> asyncCallback, final int i, final String str, Looper looper) {
        if (asyncCallback != null) {
            if (looper == null) {
                looper = Looper.getMainLooper();
            }
            new Handler(looper).post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass7 */

                public void run() {
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback;
                    if (asyncCallback != null) {
                        asyncCallback.onFailure(i, str);
                    }
                }
            });
        }
    }

    public void startEditRecommendScenes(Activity activity, RecommendSceneItem recommendSceneItem, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        DefaultSceneItemSet defaultSceneItemSet = new DefaultSceneItemSet();
        defaultSceneItemSet.O00000Oo = recommendSceneItem.mRecommendConditionList[0].mDeviceModels;
        defaultSceneItemSet.O00000o0 = recommendSceneItem.mRecommendConditionList[0].mKeys;
        defaultSceneItemSet.O00000o = recommendSceneItem.mRecommendConditionList[0].mProductId;
        if (DeviceFactory.O000000o(str, defaultSceneItemSet.O00000Oo)) {
            defaultSceneItemSet.O00000oO = str2;
        }
        arrayList.add(defaultSceneItemSet);
        ArrayList arrayList2 = new ArrayList();
        for (RecommendSceneItem.RemommendSceneAction remommendSceneAction : recommendSceneItem.mRecommendActionList) {
            DefaultSceneItemSet defaultSceneItemSet2 = new DefaultSceneItemSet();
            defaultSceneItemSet2.O00000Oo = remommendSceneAction.mDeviceModels;
            defaultSceneItemSet2.O00000o0 = remommendSceneAction.mKeys;
            defaultSceneItemSet2.O00000o = remommendSceneAction.mProductId;
            if (DeviceFactory.O000000o(str, defaultSceneItemSet2.O00000Oo)) {
                defaultSceneItemSet2.O00000oO = str2;
            }
            arrayList2.add(defaultSceneItemSet2);
        }
        Intent intent = new Intent();
        intent.putParcelableArrayListExtra("extra_default_condition_items", arrayList);
        intent.putParcelableArrayListExtra("extra_default_action_items", arrayList2);
        intent.putExtra("extra_default_scene_name", recommendSceneItem.mName);
        intent.putExtra("scene_stat_from", "scene_recom_click_widget");
        hor.O000000o().startEditScene(activity, intent);
    }

    public List<SceneInfo> getSceneByDid(String str) {
        if (etx.O000000o().O00000Oo() == null) {
            return null;
        }
        try {
            return etx.O000000o().O00000Oo().getSceneByDid(str);
        } catch (RemoteException unused) {
            return null;
        }
    }

    public void setSceneEnabled(SceneInfo sceneInfo, boolean z, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback) {
        final Looper looper = getLooper();
        sceneInfo.mEnable = z;
        final IXmPluginHostActivity.AsyncCallback<Void> asyncCallback2 = asyncCallback;
        final SceneInfo sceneInfo2 = sceneInfo;
        final boolean z2 = z;
        AnonymousClass8 r0 = new ISceneInfoCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass8 */

            public void onSuccess(SceneInfo sceneInfo) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerSuccess(asyncCallback2, null, looper);
            }

            public void onFailure(int i, String str) throws RemoteException {
                sceneInfo2.mEnable = z2;
                PluginActivityHostApiImpl.this.handlerFailed(asyncCallback2, i, str, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateSceneItem(sceneInfo, r0);
            } else if (asyncCallback != null) {
                asyncCallback.onFailure(-1, "getService null");
            }
        } catch (RemoteException e) {
            if (asyncCallback != null) {
                asyncCallback.onFailure(-1, e.getMessage());
            }
        }
    }

    public void modifySceneName(SceneInfo sceneInfo, final IXmPluginHostActivity.AsyncCallback<Void> asyncCallback) {
        final Looper looper = getLooper();
        AnonymousClass9 r1 = new ISceneInfoCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass9 */

            public void onSuccess(SceneInfo sceneInfo) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerSuccess(asyncCallback, null, looper);
            }

            public void onFailure(int i, String str) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerFailed(asyncCallback, i, str, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateSceneItem(sceneInfo, r1);
            } else if (asyncCallback != null) {
                asyncCallback.onFailure(-1, "getService null");
            }
        } catch (RemoteException e) {
            if (asyncCallback != null) {
                asyncCallback.onFailure(-1, e.getMessage());
            }
        }
    }

    public void startSetTimerList(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        intent.putExtra("common_timer_display_name", str7);
        intent.putExtra("timer_manager", str8);
        if (hmq.O000000o().isPluginRNActivity(activity)) {
            intent.putExtra("timer_identify_rn", str6);
        }
        hor.O000000o().startCommonTimer(activity, intent);
    }

    public void startSetTimerListV3(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        intent.putExtra("common_timer_display_name", str7);
        intent.putExtra("timer_manager", str8);
        intent.putExtra("timer_identify_rn", str6);
        hor.O000000o().startCommonTimer(activity, intent);
    }

    public void startSetTimerListV3(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        intent.putExtra("timer_identify_rn", str6);
        intent.putExtra("common_timer_display_name", str7);
        intent.putExtra("timer_manager", str8);
        intent.putExtra("both_timer_must_be_set", z);
        intent.putExtra("on_timer_tips", str9);
        intent.putExtra("off_timer_tips", str10);
        intent.putExtra("list_timer_tips", str11);
        hor.O000000o().startCommonTimer(activity, intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void startSetTimerListV4(Activity activity, String str, boolean z, String str2, String str3, String str4, String str5, String str6, String str7, String str8, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("shouldIncludeGroup", z);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        intent.putExtra("timer_identify_rn", str6);
        intent.putExtra("common_timer_display_name", str7);
        intent.putExtra("timer_manager", str8);
        if (jSONObject.has("on_timer_tips")) {
            intent.putExtra("on_timer_tips", jSONObject.optString("on_timer_tips"));
        }
        if (jSONObject.has("off_timer_tips")) {
            intent.putExtra("off_timer_tips", jSONObject.optString("off_timer_tips"));
        }
        if (jSONObject.has("list_timer_tips")) {
            intent.putExtra("list_timer_tips", jSONObject.optString("list_timer_tips"));
        }
        if (jSONObject.optBoolean("both_timer_must_be_set", false)) {
            intent.putExtra("on_timer_type", false);
            intent.putExtra("off_timer_type", false);
            intent.putExtra("period_timer_type", true);
        } else {
            boolean optBoolean = jSONObject.optBoolean("on_timer_type", true);
            boolean optBoolean2 = jSONObject.optBoolean("off_timer_type", true);
            boolean optBoolean3 = jSONObject.optBoolean("period_timer_type", true);
            if (optBoolean || optBoolean2 || optBoolean3) {
                intent.putExtra("on_timer_type", optBoolean);
                intent.putExtra("off_timer_type", optBoolean2);
                intent.putExtra("period_timer_type", optBoolean3);
            }
        }
        hor.O000000o().startCommonTimer(activity, intent);
    }

    public void startSetTimerCountDown(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("device_power_on", z);
        hor.O000000o().startCommonTimer(activity, intent);
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            hxi.O00000o.O0000OOo(deviceByDid.model);
        }
    }

    public void startSetTimerCountDownV2(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("device_power_on", z);
        intent.putExtra("timer_identify_rn", str6);
        activity.startActivity(intent);
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            hxi.O00000o.O0000OOo(deviceByDid.model);
        }
    }

    public void startSetTimerCountDownV2(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("device_power_on", z);
        intent.putExtra("timer_identify_rn", str6);
        intent.putExtra("common_timer_display_name", str7);
        hor.O000000o().startCountDownTimer(activity, intent);
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            hxi.O00000o.O0000OOo(deviceByDid.model);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.graphics.Bitmap]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public void openShareMediaActivity(Activity activity, String str, String str2, String str3, Bitmap bitmap, String str4, Bitmap bitmap2, DeviceStat deviceStat) {
        fbt fbt = new fbt(activity, "CommonShareActivity");
        if (!TextUtils.isEmpty(str)) {
            fbt.O000000o("ShareTitle", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            fbt.O000000o("ShareContent", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fbt.O000000o("ShareUrl", str3);
        }
        if (bitmap != null) {
            fbt.O000000o("Image", (Parcelable) bitmap);
        }
        if (!TextUtils.isEmpty(str4)) {
            fbt.O000000o("ThumbUrl", str4);
        }
        if (bitmap2 != null) {
            fbt.O000000o("Thumb", (Parcelable) bitmap2);
        }
        if (deviceStat != null) {
            fbt.O000000o("share_device_model", deviceStat.model);
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            fbt.O000000o(intent.getExtras());
        }
        fbs.O000000o(fbt);
    }

    public void openShareMediaActivity(Activity activity, String str, String str2, String str3, DeviceStat deviceStat) {
        fbt fbt = new fbt(activity, "CommonShareActivity");
        if (!TextUtils.isEmpty(str)) {
            fbt.O000000o("ShareTitle", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            fbt.O000000o("ShareContent", str2);
        }
        if (deviceStat != null) {
            fbt.O000000o("share_device_model", deviceStat.model);
        }
        fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", str3);
        Intent intent = activity.getIntent();
        if (intent != null) {
            fbt.O000000o(intent.getExtras());
        }
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, android.graphics.Bitmap]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt */
    public void openShareMediaActivity(Activity activity, String str, String str2, String str3, Bitmap bitmap, DeviceStat deviceStat) {
        fbt fbt = new fbt(activity, "CommonShareActivity");
        if (!TextUtils.isEmpty(str)) {
            fbt.O000000o("ShareTitle", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            fbt.O000000o("ShareContent", str2);
        }
        if (deviceStat != null) {
            fbt.O000000o("share_device_model", deviceStat.model);
        }
        fbt.O000000o("SHARE_IMAGE_FILE_ZIP_URL", str3);
        if (bitmap != null) {
            fbt.O000000o("Thumb", (Parcelable) bitmap);
        }
        Intent intent = activity.getIntent();
        if (intent != null) {
            fbt.O000000o(intent.getExtras());
        }
        fbs.O000000o(fbt);
    }

    public void openSharePictureActivity(Activity activity, String str, String str2, String str3) {
        fbt fbt = new fbt(activity, PictureShareActivity.TAG);
        fbt.O000000o("ShareTitle", str);
        fbt.O000000o("ShareContent", str2);
        fbt.O000000o("SharePicFile", str3);
        fbs.O000000o(fbt);
    }

    public void startEditCustomScene(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("scene_stat_from", "scene_edit_click_tab");
        intent.putExtra("from", 1);
        hor.O000000o().startCreateAutoScene(activity, intent);
    }

    public void goUpdateActivity(Activity activity, String str) {
        DeviceStat deviceByDid = XmPluginHostApi.instance().getDeviceByDid(str);
        if (deviceByDid != null) {
            fbt fbt = new fbt(activity, "MiioUpgradeActivity");
            fbt.O000000o("miio_upgrade_did", deviceByDid.did);
            fbt.O000000o("miio_upgrade_pid", deviceByDid.pid);
            fbt.O000000o("miio_upgrade_name", deviceByDid.name);
            fbs.O000000o(fbt);
        }
    }

    public void goBleMeshDeviceUpdateActivity(Activity activity, String str) {
        fbt fbt = new fbt(activity, "BleOTAUpgradeActivity");
        fbt.O000000o("arg_auth_type", 5);
        fbt.O000000o("arg_did", str);
        fbs.O000000o(fbt);
    }

    public void goBleOtaDeviceUpdateActivity(Activity activity, int i, String str, String str2, String str3, String str4) {
        gsy.O000000o(3, "OTA", String.format("ble ota test ,auth type = %d, versionName =%s,test file Md5 5s,testUrl =%s", Integer.valueOf(i), str3, str4, str));
        fbt fbt = new fbt(activity, "BleOTAUpgradeActivity");
        fbt.O000000o("arg_auth_type", i);
        fbt.O000000o("arg_did", str2);
        fbt.O000000o("arg_test_dfu_url", str);
        fbt.O000000o("arg_test_version_name", str3);
        fbt.O000000o("arg_test_file_md5", str4);
        fbs.O000000o(fbt);
    }

    public void startLoadScene(final IXmPluginHostActivity.AsyncCallback asyncCallback) {
        final Looper looper = getLooper();
        AnonymousClass10 r1 = new IPluginCallback.Stub() {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass10 */

            public void onRequestSuccess(String str) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerSuccess(asyncCallback, null, looper);
            }

            public void onRequestFailed(int i, String str) throws RemoteException {
                PluginActivityHostApiImpl.this.handlerFailed(asyncCallback, i, str, looper);
            }
        };
        try {
            if (etx.O000000o().O00000Oo() != null) {
                etx.O000000o().O00000Oo().updateScene(null, r1);
            } else if (asyncCallback != null) {
                asyncCallback.onFailure(-1, "getService null");
            }
        } catch (RemoteException e) {
            if (asyncCallback != null) {
                asyncCallback.onFailure(-1, e.getMessage());
            }
        }
    }

    public void openHelpActivity(Activity activity, DeviceStat deviceStat) {
        if (deviceStat != null) {
            fbt fbt = new fbt(activity, "/userCenter/FeedbackCommonProblemActivity");
            fbt.O000000o("did", deviceStat.did);
            fbt.O000000o("extra_model", deviceStat.model);
            fbs.O000000o(fbt);
        }
    }

    public void openScanBarcodePage(Activity activity, Bundle bundle, int i) {
        fwq.O000000o(activity, true, new inc(activity, bundle, i) {
            /* class com.xiaomi.smarthome.framework.plugin.mpk.$$Lambda$PluginActivityHostApiImpl$TGqmtTG8JeK3m5Rs0w_yuNoLUo0 */
            private final /* synthetic */ Activity f$0;
            private final /* synthetic */ Bundle f$1;
            private final /* synthetic */ int f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onAction(List list) {
                PluginActivityHostApiImpl.lambda$openScanBarcodePage$0(this.f$0, this.f$1, this.f$2, list);
            }
        });
    }

    static /* synthetic */ void lambda$openScanBarcodePage$0(Activity activity, Bundle bundle, int i, List list) {
        fbt fbt = new fbt(activity, ScanBarcodeActivity.TAG);
        if (bundle != null) {
            fbt.O000000o(bundle);
        }
        fbt.O000000o(i);
        fbs.O000000o(fbt);
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
    public void openVerfyPincode(Activity activity, Bundle bundle, int i) {
        fbt fbt = new fbt(activity, "DevicePinVerifyEnterActivity");
        fbt.O000000o(bundle);
        fbt.O000000o("verfy_pincode_first", true);
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    public void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        if (deviceStat != null) {
            DeviceMoreActivity.openMoreMenu(activity, deviceStat.did, arrayList, z, i, intent);
        }
    }

    public void openMoreMenu(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, String str) {
        if (deviceStat != null) {
            DeviceMoreActivity.openMoreMenu(activity, deviceStat.did, arrayList, z, i, intent, str);
        }
    }

    public void openMoreMenu2(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        if (deviceStat != null) {
            DeviceMoreNewActivity.openMoreMenu(activity, deviceStat.did, arrayList, z, i, intent);
        }
    }

    public void openAddIRController(Activity activity, DeviceStat deviceStat, int i, String[] strArr, Bundle bundle) {
        gii.O000000o().showMatchingDeviceTypeActivity(activity, deviceStat, i, strArr, bundle);
    }

    public void openGatewaySubDeviceList(Activity activity, String str) {
        fbt fbt = new fbt(activity, "GatewayAddDeviceListActivity");
        fbt.O000000o("gateway_did", str);
        fbs.O000000o(fbt);
    }

    public void openMoreMenu2(Activity activity, DeviceStat deviceStat, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2) {
        if (deviceStat != null) {
            DeviceMoreNewActivity.openMoreMenu(activity, deviceStat.did, arrayList, z, i, intent, intent2);
        }
    }

    public void sendPluginAdRequest(Activity activity, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().sendPluginAdRequest(str, str2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopPluginAd(String str) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().stopPluginAd(str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void showPopAd(final Activity activity, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().queryAd(str, str2, new IAdCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass11 */

                    public void onQueryAdFail() throws RemoteException {
                    }

                    public void onQueryAdSuccess(AdPosition adPosition) throws RemoteException {
                        if (goy.O000000o(activity) && adPosition != null && adPosition.O00000Oo.size() != 0) {
                            final Advertisement O000000o2 = eyy.O000000o(adPosition);
                            if (etx.O000000o().O00000Oo() != null) {
                                try {
                                    etx.O000000o().O00000Oo().loadBitmap(O000000o2.O00000o, new IPluginCallback3.Stub() {
                                        /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass11.AnonymousClass1 */

                                        public void onFailed() throws RemoteException {
                                        }

                                        public void onSuccess(Bitmap bitmap) throws RemoteException {
                                            if (goy.O000000o(activity)) {
                                                PopAdActivity.start(activity, O000000o2);
                                            }
                                        }
                                    });
                                } catch (RemoteException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void showBottomFlowAd(final Activity activity, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().queryAd(str, str2, new IAdCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass12 */

                    public void onQueryAdFail() throws RemoteException {
                    }

                    public void onQueryAdSuccess(final AdPosition adPosition) throws RemoteException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass12.AnonymousClass1 */

                            public void run() {
                                AdPosition adPosition;
                                if (!activity.isFinishing() && (adPosition = adPosition) != null && adPosition.O00000Oo.size() != 0) {
                                    new eyx(activity, adPosition).showAtLocation(activity.getWindow().getDecorView(), 80, 0, 0);
                                }
                            }
                        });
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void showBannerAd(final Activity activity, final ViewGroup viewGroup, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null && viewGroup != null && viewGroup.getChildCount() <= 0) {
            try {
                etx.O000000o().O00000Oo().queryAd(str, str2, new IAdCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass13 */

                    public void onQueryAdFail() throws RemoteException {
                    }

                    public void onQueryAdSuccess(final AdPosition adPosition) throws RemoteException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass13.AnonymousClass1 */

                            public void run() {
                                AdPosition adPosition;
                                if (!activity.isFinishing() && (adPosition = adPosition) != null && adPosition.O00000Oo.size() != 0) {
                                    BannerAdView bannerAdView = new BannerAdView(activity);
                                    bannerAdView.setBannerAd(adPosition);
                                    viewGroup.addView(bannerAdView);
                                    eyy.O000000o(adPosition.O00000Oo.get(0));
                                }
                            }
                        });
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void showNoticeAd(final Activity activity, final ViewGroup viewGroup, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null && viewGroup != null && viewGroup.getChildCount() <= 0) {
            try {
                etx.O000000o().O00000Oo().queryAd(str, str2, new IAdCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass14 */

                    public void onQueryAdFail() throws RemoteException {
                    }

                    public void onQueryAdSuccess(final AdPosition adPosition) throws RemoteException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass14.AnonymousClass1 */

                            public void run() {
                                AdPosition adPosition;
                                if (!activity.isFinishing() && (adPosition = adPosition) != null && adPosition.O00000Oo.size() != 0) {
                                    NoticeAdView noticeAdView = new NoticeAdView(activity);
                                    noticeAdView.setNotice(adPosition);
                                    viewGroup.addView(noticeAdView);
                                }
                            }
                        });
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void clickHotSpotAd(final Activity activity, String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().queryAd(str, str2, new IAdCallback.Stub() {
                    /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass15 */

                    public void onQueryAdFail() throws RemoteException {
                    }

                    public void onQueryAdSuccess(final AdPosition adPosition) throws RemoteException {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass15.AnonymousClass1 */

                            public void run() {
                                AdPosition adPosition;
                                if (!activity.isFinishing() && (adPosition = adPosition) != null && adPosition.O00000Oo.size() != 0) {
                                    Advertisement O000000o2 = eyy.O000000o(adPosition);
                                    eyy.O000000o();
                                    fsp.O000000o().O0000Oo.loadWebView(O000000o2.O00000oO, "");
                                }
                            }
                        });
                    }
                });
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void openOpHistoryActivity(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            fbt fbt = new fbt(activity, "DeviceOpHistoryActivity");
            fbt.O000000o("did", str);
            fbs.O000000o(fbt);
        }
    }

    public void reportHotSpotAdShow(String str, String str2) {
        if (etx.O000000o().O00000Oo() != null) {
            try {
                etx.O000000o().O00000Oo().reportHotSpotShow();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void openShareDeviceActivity(Activity activity, String str) {
        if (!TextUtils.isEmpty(str)) {
            fbt fbt = new fbt(activity, "/share/ShareDeviceActivity");
            fbt.O000000o("user_id", CoreApi.O000000o().O0000o0());
            fbt.O000000o("did", str);
            fbs.O000000o(fbt);
        }
    }

    public void showUserLicenseDialog(Activity activity, String str, String str2, Spanned spanned, String str3, Spanned spanned2, View.OnClickListener onClickListener, String str4, Intent intent) {
        hyv.O000000o().showUserLicenseDialog(activity, str4, str, str2, spanned, str3, spanned2, onClickListener, intent);
    }

    public void showUserLicenseDialog(Activity activity, String str, View.OnClickListener onClickListener, String str2) {
        hyv.O000000o().showUserLicenseDialog(activity, str, onClickListener, str2);
    }

    public void showUserLicenseHtmlDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6) {
        hyv.O000000o().showUserLicenseHtmlDialog(activity, str, str2, str3, str4, str5, onClickListener, str6);
    }

    public void showUserLicenseUriDialog(Activity activity, String str, String str2, String str3, String str4, String str5, View.OnClickListener onClickListener, String str6, Intent intent) {
        hyv.O000000o().showUserLicenseUriDialog(activity, str, str2, str3, str4, str5, onClickListener, str6, intent);
    }

    public void showUserLicenseUriDialogV2(Activity activity, String str, boolean z, String str2, String str3, View.OnClickListener onClickListener, String str4, Intent intent) {
        hyv.O000000o().showUserLicenseUriDialogV2(activity, str, z, str2, str3, onClickListener, str4, intent);
    }

    public void startSetTimerListV2(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, boolean z, String str9, String str10, String str11) {
        Intent intent = new Intent();
        intent.putExtra("common_timer_device_id", str);
        intent.putExtra("on_method", str2);
        intent.putExtra("on_param", str3);
        intent.putExtra("off_method", str4);
        intent.putExtra("off_param", str5);
        intent.putExtra("action_common_timer_name", str6);
        if (hmq.O000000o().isPluginRNActivity(activity)) {
            intent.putExtra("timer_identify_rn", str6);
        }
        intent.putExtra("common_timer_display_name", str7);
        intent.putExtra("timer_manager", str8);
        intent.putExtra("both_timer_must_be_set", z);
        intent.putExtra("on_timer_tips", str9);
        intent.putExtra("off_timer_tips", str10);
        intent.putExtra("list_timer_tips", str11);
        hor.O000000o().startCommonTimer(activity, intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void startAddRoom(Activity activity) {
        Intent intent = new Intent(activity, HomeRoomRecommendActivity.class);
        intent.putExtra("come_from_plug", true);
        activity.startActivity(intent);
    }

    public void openCloudVideoListActivity(Activity activity, String str, String str2) {
        CameraRouterFactory.getCameraCloudApi().openCloudVideoListActivity(activity, str, str2, hmq.O000000o().isPluginRNActivity(activity));
    }

    public void openCloudVideoListActivityForResult(Activity activity, String str, String str2, int i) {
        CameraRouterFactory.getCameraCloudApi().openCloudVideoListActivityForResult(activity, str, str2, i);
    }

    public void openCloudVideoPlayerActivity(Activity activity, String str, String str2, String str3) {
        CameraRouterFactory.getCameraCloudApi().openCloudVideoPlayerActivity(activity, str, str2, str3);
    }

    public void openCloudVideoWebActivity(Activity activity, String str, String str2, String str3) {
        CameraRouterFactory.getCameraCloudApi().openCloudVideoWebActivity(activity, str, str2, str3);
    }

    public void onDeviceReady(Activity activity, String str, String str2, boolean z, IXmPluginHostActivity.AsyncCallback<Void> asyncCallback) {
        try {
            final boolean z2 = z;
            final Activity activity2 = activity;
            final String str3 = str;
            final String str4 = str2;
            final IXmPluginHostActivity.AsyncCallback<Void> asyncCallback2 = asyncCallback;
            etx.O000000o().O00000Oo().addDeviceToMain(str2, str, new IPluginCallback.Stub() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass16 */

                public void onRequestFailed(int i, String str) throws RemoteException {
                }

                public void onRequestSuccess(String str) throws RemoteException {
                    if (z2) {
                        hty.O000000o().openConnectSucceedPage(activity2, str3, str4);
                    }
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback2;
                    if (asyncCallback != null) {
                        asyncCallback.onSuccess(null);
                    }
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void openCloudVideoExoPlayerActivity(Activity activity, String str, String str2, String str3) {
        CameraRouterFactory.getCameraCloudApi().openCloudVideoExoPlayerActivity(activity, str, str2, str3);
    }

    public void openPowerSwitchNameActivity(Activity activity, String str, String str2) {
        PowerMultikeyActivity.startActivity(activity, str, str2);
    }

    public void openWxBindActivity(Activity activity, int i) {
        fbt fbt = new fbt(activity, "/userCenter/BindWxActivity");
        fbt.O000000o(i);
        fbs.O000000o(fbt);
    }

    public void openBtGatewayActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, BleGatewayActivity.class);
        intent.putExtra("key_gateway_did", str);
        activity.startActivity(intent);
    }

    public void openVirtualGroupInitActivity(Activity activity, String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            fbt fbt = new fbt(activity, "LightGroupinitActivity");
            fbt.O000000o(i);
            fbt.O000000o("did", str);
            fbs.O000000o(fbt);
        }
    }

    public void openOneTimePasswordActivity(Activity activity, String str, int i, int i2) {
        Intent intent = new Intent(activity, GeneralOneTimePasswordHistoryActivity.class);
        intent.putExtra("did", str);
        intent.putExtra("interval", i);
        intent.putExtra("digits", i2);
        activity.startActivity(intent);
    }

    public void updatePluginRecommendScenes(Activity activity, String str, IXmPluginHostActivity.AsyncCallback<String> asyncCallback) {
        hor.O000000o().updatePluginRecommendScenes(str, asyncCallback);
    }

    public void createSceneFrom(Activity activity, String str, String str2, final IXmPluginHostActivity.AsyncCallback<String> asyncCallback) {
        PluginRecommendSceneInfo.RecommendSceneItem parseFrom = PluginRecommendSceneInfo.RecommendSceneItem.parseFrom(str);
        if (parseFrom != null) {
            hor.O000000o().createAndSaveSceneFrom(parseFrom, str2, new hqy() {
                /* class com.xiaomi.smarthome.framework.plugin.mpk.PluginActivityHostApiImpl.AnonymousClass17 */

                public void onSaveLocalFail() {
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback;
                    if (asyncCallback != null) {
                        asyncCallback.onFailure(-1, "save localscene fail");
                    }
                }

                public void onSaveCloudSuccess(boolean z) {
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback;
                    if (asyncCallback != null) {
                        asyncCallback.onSuccess("isSynchronizeCloud #".concat(String.valueOf(z)));
                    }
                }

                public void onSaveCloudFail(int i, String str) {
                    IXmPluginHostActivity.AsyncCallback asyncCallback = asyncCallback;
                    if (asyncCallback != null) {
                        asyncCallback.onFailure(i, str);
                    }
                }
            });
        } else if (asyncCallback != null) {
            asyncCallback.onFailure(-9000, "parse recommendSceneItem fail");
        }
    }

    public void openNetworkInfoActivity(Activity activity, String str) {
        Intent intent = new Intent(activity, DeviceNetworkInfoActivity.class);
        intent.putExtra("did", str);
        activity.startActivity(intent);
    }

    public void openFaceManagerActivity(Activity activity, String str) {
        CameraRouterFactory.getFaceManagerApi().openFaceManagerActivity(activity, str, hmq.O000000o().isPluginRNActivity(activity));
    }

    public void openFaceManagerImpl(Activity activity, String str) {
        CameraRouterFactory.getFaceManagerApi().openFaceManagerImpl(activity, str, hmq.O000000o().isPluginRNActivity(activity));
    }

    public void openFaceManagerActivity(int i, Activity activity, String str, String str2) {
        CameraRouterFactory.getFaceManagerApi().openFaceManagerActivity(i, activity, str, str2);
    }

    public void openMarkFaceDialog(Activity activity, String str, String str2, FaceManagerCallback faceManagerCallback) {
        CameraRouterFactory.getFaceManagerApi().openMarkFaceDialog(activity, str, str2, faceManagerCallback);
    }

    public void openReplaceFaceDialog(Activity activity, String str, String str2, String str3, String str4, FaceManagerCallback faceManagerCallback) {
        CameraRouterFactory.getFaceManagerApi().openReplaceFaceDialog(activity, str, str2, str3, str4, faceManagerCallback);
    }

    public void openFaceEmptyActivity(Activity activity, String str) {
        CameraRouterFactory.getFaceManagerApi().openFaceEmptyActivity(activity, str);
    }

    public void startRecommendSceneDetailActivityBy(Activity activity, String str, int i) {
        hor.O000000o().startRecommendSceneDetailActivityBy(activity, str, i);
    }

    public void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z) {
        CameraRouterFactory.getFaceManagerApi().openScreenDeviceLinkageSettingActivity(activity, str, z);
    }

    public void openScreenDeviceLinkageSettingActivity(Activity activity, String str, boolean z, int i, String str2) {
        CameraRouterFactory.getFaceManagerApi().openScreenDeviceLinkageSettingActivity(activity, str, z, i, str2);
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
    public void goToLockWifiConfigStep(Activity activity, String str, String str2) {
        fbt fbt = new fbt(activity, "SmartConfigMainActivity");
        fbt.O000000o("strategy_id", 18);
        fbt.O000000o("key_lock_wifi_device_mac", str);
        fbt.O000000o("key_lock_wifi_from_plugin", true);
        fbt.O000000o("key_lock_wifi_device_token", str2);
        fbs.O000000o(fbt);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public void openRnPlugin(Activity activity, String str, Intent intent) {
        Intent intent2 = new Intent(activity, hmq.O000000o().getLoadingRNActivityClass());
        intent2.addFlags(268435456);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("activity_start_from", 1001);
        intent2.putExtra("did", str);
        intent2.putExtra("optReuseProcessEnable", false);
        Device O000000o2 = fno.O000000o().O000000o(str);
        exz exz = exz.f15941O000000o;
        exz.O000000o(intent2, O000000o2 == null ? "" : O000000o2.getModel());
        activity.startActivity(intent2);
    }
}
