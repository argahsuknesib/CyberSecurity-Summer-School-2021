package _m_j;

import _m_j.fpq;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfoStatus;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.ChooseGatewayDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.ResetDevicePage;
import com.xiaomi.smarthome.device.ScanChooseBluetoothDevice;
import com.xiaomi.smarthome.device.XiaomiRedMiRouter15;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fpq {

    /* renamed from: O000000o  reason: collision with root package name */
    public Dialog f16876O000000o;
    public CommonActivity O00000Oo;
    public SingleEmitter<Boolean> O00000o = null;
    public Disposable O00000o0 = null;
    private List<fni> O00000oO = new ArrayList();

    public interface O000000o {
        void O000000o();

        void O000000o(List<fni> list, List<PluginDeviceInfo> list2);
    }

    public final void O000000o(final CommonActivity commonActivity, final O000000o o000000o) {
        this.O00000Oo = commonActivity;
        CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.fpq.AnonymousClass1 */

            public final void run() {
                CoreApi.O000000o().O000000o(commonActivity, new CoreApi.O0000o0() {
                    /* class _m_j.fpq.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void
                     arg types: [int, _m_j.fpq$1$1$1]
                     candidates:
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.account.OAuthAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.frame.server_compact.ServerBean, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.LoginMiAccount, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.List<com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam>, _m_j.fsm<org.json.JSONObject, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.util.Locale, _m_j.fsm<java.lang.Void, _m_j.fso>):_m_j.fsn
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader):com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(long, long):java.lang.String
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o00):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o0):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O0000o):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.frame.core.CoreApi$O00oOooO):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest, com.xiaomi.smarthome.core.server.bluetooth.SearchResponse):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, boolean):void
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, byte[]):byte[]
                      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(boolean, com.xiaomi.smarthome.frame.core.CoreApi$O000O0o0):void */
                    public final void onCoreReady() {
                        fpq.this.O00000Oo(o000000o);
                        CoreApi.O000000o().O000000o(true, (CoreApi.O000O0o0) new CoreApi.O000O0o0() {
                            /* class _m_j.fpq.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void O000000o(boolean z) {
                                if (z) {
                                    fpq.this.O00000Oo(o000000o);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    /* renamed from: O000000o */
    public final void O00000Oo(O000000o o000000o) {
        O000000o o000000o2 = o000000o;
        if (PluginDeviceManager.instance.getPluginInfoMap().size() == 0) {
            if (o000000o2 != null) {
                o000000o.O000000o();
            }
            CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable(o000000o2) {
                /* class _m_j.$$Lambda$fpq$WLm3FnK2EFrbDeLLYXpR1A70aQ0 */
                private final /* synthetic */ fpq.O000000o f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    fpq.this.O00000Oo(this.f$1);
                }
            }, 1000);
            return;
        }
        ArrayList<PluginDeviceInfo> arrayList = new ArrayList<>();
        Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
        if (pluginInfoMap != null) {
            arrayList.addAll(pluginInfoMap.values());
            List<fni> O00000o02 = fnn.O000000o().O00000o0();
            ArrayList arrayList2 = new ArrayList();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                PluginDeviceInfo pluginDeviceInfo = (PluginDeviceInfo) arrayList.get(size);
                if (pluginDeviceInfo.O0000o() == 5 && O00000o02 != null && O00000o02.size() > 0) {
                    Iterator<fni> it = O00000o02.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        fni next = it.next();
                        if (next.O00000o.equalsIgnoreCase(((PluginDeviceInfo) arrayList.get(size)).O00000Oo()) && hna.O00000Oo().shouldAddEntryShowByHomeVirtualDeviceHelper(next.O00000o)) {
                            arrayList2.add(next);
                            break;
                        }
                    }
                }
                int O00000oO2 = pluginDeviceInfo.O00000oO();
                if (O00000oO2 == 3 || O00000oO2 == 4 || O00000oO2 == 1) {
                    PluginDeviceInfoStatus O0000oO0 = pluginDeviceInfo.O0000oO0();
                    if (!(O0000oO0 == PluginDeviceInfoStatus.RELEASE || O0000oO0 == PluginDeviceInfoStatus.WHITE_LIST)) {
                        arrayList.remove(size);
                        gsy.O00000Oo("ChooseDeviceHelper", "name:" + pluginDeviceInfo.O0000Oo0() + " model:" + pluginDeviceInfo.O00000Oo() + " status:" + O0000oO0);
                    }
                } else {
                    arrayList.remove(size);
                    gsy.O00000Oo("ChooseDeviceHelper", "name:" + pluginDeviceInfo.O0000Oo0() + " model:" + pluginDeviceInfo.O00000Oo() + " scStatus:" + O00000oO2);
                }
            }
            if (CoreApi.O000000o().O00000oO("isa.camera.isc5") != null) {
                PluginDeviceInfo pluginDeviceInfo2 = new PluginDeviceInfo();
                pluginDeviceInfo2.O00000Oo(CommonApplication.getAppContext().getString(R.string.smart_config_xiaofang_name));
                pluginDeviceInfo2.O000000o("isa.camera.isc5");
                pluginDeviceInfo2.O00000Oo(4);
                pluginDeviceInfo2.O0000oo0 = 3;
                arrayList.add(pluginDeviceInfo2);
            }
            HashMap hashMap = new HashMap();
            for (PluginDeviceInfo O00000o03 : arrayList) {
                hashMap.put(Integer.valueOf(O00000o03.O00000o0()), Boolean.TRUE);
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                PluginDeviceInfo pluginDeviceInfo3 = (PluginDeviceInfo) arrayList.get(size2);
                int i = pluginDeviceInfo3.O000O0o0;
                if (!(i == 0 || hashMap.get(Integer.valueOf(i)) == null)) {
                    arrayList.remove(size2);
                    gsy.O00000Oo("ChooseDeviceHelper", "name:" + pluginDeviceInfo3.O0000Oo0() + " model:" + pluginDeviceInfo3.O00000Oo() + "inheritId:" + i);
                }
            }
            this.O00000Oo.mHandler.post(new Runnable(arrayList2, o000000o2, arrayList) {
                /* class _m_j.$$Lambda$fpq$doTz9GuJlPaIEuZgpP9IF_3uvBc */
                private final /* synthetic */ List f$1;
                private final /* synthetic */ fpq.O000000o f$2;
                private final /* synthetic */ List f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void run() {
                    fpq.this.O000000o(this.f$1, this.f$2, this.f$3);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(List list, O000000o o000000o, List list2) {
        this.O00000oO.addAll(list);
        if (o000000o != null) {
            o000000o.O000000o(list, list2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a3, code lost:
        if (r3.contains(1) == false) goto L_0x01a7;
     */
    public final boolean O000000o(PluginDeviceInfo pluginDeviceInfo, Intent intent, boolean z) {
        List<Device> O0000Ooo;
        fni fni;
        boolean z2;
        final PluginDeviceInfo pluginDeviceInfo2 = pluginDeviceInfo;
        Intent intent2 = intent;
        boolean z3 = z;
        boolean z4 = false;
        if (pluginDeviceInfo2 == null) {
            return false;
        }
        int O0000OOo = pluginDeviceInfo.O0000OOo();
        grr.O000000o();
        if (O0000OOo > grr.O00000o0(this.O00000Oo)) {
            CommonActivity commonActivity = this.O00000Oo;
            izb.O000000o(commonActivity, commonActivity.getResources().getString(R.string.device_not_support_now), 0).show();
            return false;
        } else if (!pluginDeviceInfo.O000000o()) {
            CommonActivity commonActivity2 = this.O00000Oo;
            izb.O000000o(commonActivity2, commonActivity2.getResources().getString(R.string.device_not_support_now), 0).show();
            return false;
        } else {
            String O00000Oo2 = pluginDeviceInfo.O00000Oo();
            if (htt.O000000o(O00000Oo2)) {
                fbt fbt = new fbt(this.O00000Oo, "ConfigRouterStationActivity");
                Bundle O000000o2 = fqy.O000000o(intent);
                if (O000000o2 != null) {
                    fbt.O000000o(O000000o2);
                }
                fbt.O000000o("model", O00000Oo2);
                fbt.O000000o("from_miui", z3);
                if (intent2 != null && intent2.hasExtra("mac")) {
                    fbt.O000000o("mac", intent2.getStringExtra("mac"));
                }
                if (intent2 != null && intent2.hasExtra("key_qrcode_oob")) {
                    fbt.O000000o("key_qrcode_oob", intent2.getStringExtra("key_qrcode_oob"));
                }
                fbs.O000000o(fbt);
                return true;
            } else if (htt.O00000Oo(O00000Oo2)) {
                fbt fbt2 = new fbt(this.O00000Oo, "ConfigRouterSubDeviceActivity");
                fbt2.O000000o("device_model", O00000Oo2);
                fbt2.O000000o("key_qrcode_oob", intent2.getStringExtra("key_qrcode_oob"));
                fbt2.O000000o("mac", intent2.getStringExtra("mac"));
                fbs.O000000o(fbt2);
                return true;
            } else {
                int O00000o2 = pluginDeviceInfo.O00000o();
                if (fqw.O000000o(pluginDeviceInfo)) {
                    gih O000000o3 = gii.O000000o();
                    if (O000000o3 == null) {
                        return true;
                    }
                    O000000o3.showIRGateWayChooseActivity(this.O00000Oo, pluginDeviceInfo.O00000Oo());
                    return true;
                } else if (pluginDeviceInfo.O0000o() == Device.PID_SUBDEVICE) {
                    ChooseGatewayDevice.selectActivity(this.O00000Oo, pluginDeviceInfo2, 1001, null);
                    return true;
                } else if (O00000o2 == 15 || O00000o2 == 25) {
                    Intent intent3 = new Intent(this.O00000Oo, ResetDevicePage.class);
                    fqy.O000000o(intent3, intent2);
                    intent3.putExtra("model", pluginDeviceInfo.O00000Oo());
                    this.O00000Oo.startActivityForResult(intent3, 1001);
                    return true;
                } else if (O00000o2 == 2 || O00000o2 == 11 || O00000o2 == 18) {
                    if ("ryeex.bracelet.sake".equals(pluginDeviceInfo.O00000Oo()) && (O0000Ooo = fno.O000000o().O0000Ooo("ryeex.bracelet.sake")) != null && O0000Ooo.size() > 0) {
                        CommonActivity commonActivity3 = this.O00000Oo;
                        izb.O000000o(commonActivity3, commonActivity3.getString(R.string.already_bind_one_device), 0).show();
                        return false;
                    } else if (pluginDeviceInfo.O0000o() == Device.PID_BLE_MESH) {
                        Intent intent4 = new Intent(this.O00000Oo, ResetDevicePage.class);
                        fqy.O000000o(intent4, intent2);
                        intent4.putExtra("model", pluginDeviceInfo.O00000Oo());
                        this.O00000Oo.startActivityForResult(intent4, 100);
                        return true;
                    } else {
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(pluginDeviceInfo.O00000Oo());
                        this.O00000Oo.mHandler.sendEmptyMessageDelayed(3000, 50);
                        this.O00000Oo.mHandler.sendEmptyMessageDelayed(3002, 3000);
                        final long currentTimeMillis = System.currentTimeMillis();
                        final PluginDeviceInfo pluginDeviceInfo3 = pluginDeviceInfo;
                        final Intent intent5 = intent;
                        Single.create(new SingleOnSubscribe<Boolean>() {
                            /* class _m_j.fpq.AnonymousClass3 */

                            public final void subscribe(final SingleEmitter<Boolean> singleEmitter) throws Exception {
                                fpq.this.O00000o = singleEmitter;
                                Context appContext = CommonApplication.getAppContext();
                                List<String> list = arrayList;
                                AnonymousClass1 r6 = new fsm<Set<String>, fso>() {
                                    /* class _m_j.fpq.AnonymousClass3.AnonymousClass1 */

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        if (((Set) obj).contains(pluginDeviceInfo2.O00000Oo())) {
                                            singleEmitter.onSuccess(Boolean.TRUE);
                                        } else {
                                            singleEmitter.onSuccess(Boolean.FALSE);
                                        }
                                    }

                                    public final void onFailure(fso fso) {
                                        singleEmitter.onSuccess(Boolean.FALSE);
                                    }
                                };
                                if (list == null || list.isEmpty()) {
                                    r6.onFailure(new fso(-1, "modelList is null or empty"));
                                    return;
                                }
                                ArrayList arrayList = new ArrayList();
                                JSONObject jSONObject = new JSONObject();
                                JSONArray jSONArray = new JSONArray();
                                for (String put : list) {
                                    jSONArray.put(put);
                                }
                                try {
                                    jSONObject.put("models", jSONArray);
                                    JSONArray jSONArray2 = new JSONArray();
                                    jSONArray2.put("ble_reset");
                                    jSONObject.put("keys", jSONArray2);
                                } catch (JSONException unused) {
                                }
                                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                                CoreApi.O000000o().O000000o(appContext, new NetRequest.O000000o().O000000o("POST").O000000o(arrayList).O00000Oo("/v2/productconfig/single_pull").O000000o(), new fss<Set<String>>() {
                                    /* class _m_j.fmc.AnonymousClass1 */

                                    public final /* synthetic */ Object parse(JSONObject jSONObject) {
                                        HashSet hashSet = new HashSet();
                                        JSONArray jSONArray = jSONObject.getJSONArray("result");
                                        for (int i = 0; i < jSONArray.length(); i++) {
                                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                                            String string = jSONObject2.getString("model");
                                            if (!jSONObject2.isNull("ble_reset")) {
                                                hashSet.add(string);
                                            }
                                        }
                                        return hashSet;
                                    }
                                }, Crypto.RC4, r6);
                            }
                        }).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<Boolean>() {
                            /* class _m_j.fpq.AnonymousClass2 */

                            public final void onError(Throwable th) {
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                gsy.O000000o(4, "guid", " " + (System.currentTimeMillis() - currentTimeMillis));
                                fpq.this.O00000Oo.mHandler.removeMessages(3000);
                                fpq.this.O00000Oo.mHandler.removeMessages(3002);
                                fpq.this.O00000Oo.mHandler.sendEmptyMessage(3001);
                                if (((Boolean) obj).booleanValue()) {
                                    gsy.O000000o(4, "guid", "into ble reset page, model = " + pluginDeviceInfo3.O00000Oo());
                                    Intent intent = new Intent(fpq.this.O00000Oo, ResetDevicePage.class);
                                    fqy.O000000o(intent, intent5);
                                    Intent intent2 = intent5;
                                    if (intent2 != null && intent2.hasExtra("key_qrcode_oob")) {
                                        intent.putExtra("key_qrcode_oob", "test");
                                    }
                                    intent.putExtra("model", pluginDeviceInfo3.O00000Oo());
                                    fpq.this.O00000Oo.startActivityForResult(intent, 100);
                                    return;
                                }
                                gsy.O000000o(4, "guid", "int ble normal process");
                                Intent intent3 = new Intent(fpq.this.O00000Oo, ScanChooseBluetoothDevice.class);
                                fqy.O000000o(intent3, intent5);
                                intent3.putExtra("model", pluginDeviceInfo3.O00000Oo());
                                intent3.putExtra("deviceName", pluginDeviceInfo3.O0000Oo0());
                                Intent intent4 = intent5;
                                if (intent4 != null && intent4.hasExtra("key_qrcode_oob")) {
                                    intent3.putExtra("key_qrcode_oob", intent5.getStringExtra("key_qrcode_oob"));
                                }
                                fpq.this.O00000Oo.startActivity(intent3);
                            }

                            public final void onSubscribe(Disposable disposable) {
                                fpq.this.O00000o0 = disposable;
                            }
                        });
                        return true;
                    }
                } else if (O00000o2 == 7) {
                    fbt fbt3 = new fbt(this.O00000Oo, "ChooseGeneralAPActivity");
                    fbt3.O000000o("sc_type", O00000o2);
                    fbt3.O000000o("model", pluginDeviceInfo.O00000Oo());
                    fbs.O000000o(fbt3);
                    return true;
                } else if (O00000o2 == 4) {
                    if (pluginDeviceInfo.O00000Oo().equals("yunyi.camera.v1")) {
                        fbt fbt4 = new fbt(this.O00000Oo, "SmartConfigMainActivity");
                        if (intent2 != null) {
                            fbt4.O000000o("connect_source", intent2.getIntExtra("connect_source", 0));
                            fbt4.O000000o("connect_unique", intent2.getStringExtra("connect_unique"));
                            hxi.O00000o.O000000o(pluginDeviceInfo.O00000Oo(), intent2.getIntExtra("connect_source", 0), intent2.getStringExtra("connect_unique"));
                        } else {
                            hxi.O00000o.O000000o(pluginDeviceInfo.O00000Oo(), 0, "");
                        }
                        fbt4.O000000o("model", pluginDeviceInfo.O00000Oo());
                        fbt4.O000000o("strategy_id", 3);
                        if (intent2 != null && intent2.hasExtra("key_qrcode_oob")) {
                            fbt4.O000000o("key_qrcode_oob", intent2.getStringExtra("key_qrcode_oob"));
                        }
                        fbt4.O000000o(100);
                        fbs.O000000o(fbt4);
                        return true;
                    }
                    List<Integer> O0000O0o = pluginDeviceInfo.O0000O0o();
                    if (O0000O0o != null) {
                        if (!O0000O0o.contains(0)) {
                            z2 = true;
                        }
                        O000000o(pluginDeviceInfo.O00000Oo(), z3, (Intent) null);
                        return true;
                    }
                    z2 = true;
                    if (!eyr.O000000o(pluginDeviceInfo.O00000Oo(), z2, 100, eyr.O00000Oo().O0000oO0)) {
                        fbt fbt5 = new fbt(this.O00000Oo, "SmartConfigMainActivity");
                        if (intent2 != null) {
                            fbt5.O000000o("connect_source", intent2.getIntExtra("connect_source", 0));
                            fbt5.O000000o("connect_unique", intent2.getStringExtra("connect_unique"));
                            hxi.O00000o.O000000o(pluginDeviceInfo.O00000Oo(), intent2.getIntExtra("connect_source", 0), intent2.getStringExtra("connect_unique"));
                        } else {
                            hxi.O00000o.O000000o(pluginDeviceInfo.O00000Oo(), 0, "");
                        }
                        fbt5.O000000o("model", pluginDeviceInfo.O00000Oo());
                        fbt5.O000000o("strategy_id", 9);
                        fbt5.O000000o("from_miui", z3);
                        fbt5.O000000o(100);
                        fbs.O000000o(fbt5);
                        return true;
                    }
                    O000000o(pluginDeviceInfo.O00000Oo(), z3, (Intent) null);
                    return true;
                } else if (O00000o2 == 5) {
                    Intent intent6 = new Intent(this.O00000Oo, ResetDevicePage.class);
                    fqy.O000000o(intent6, intent2);
                    intent6.putExtra("model", pluginDeviceInfo.O00000Oo());
                    this.O00000Oo.startActivityForResult(intent6, 100);
                    return true;
                } else if (O00000o2 == 12) {
                    List<Integer> O0000O0o2 = pluginDeviceInfo.O0000O0o();
                    if (O0000O0o2 == null || (!O0000O0o2.contains(0) && !O0000O0o2.contains(1))) {
                        fbt fbt6 = new fbt(this.O00000Oo, "SmartConfigMainActivity");
                        if (intent2 != null) {
                            fbt6.O000000o("connect_source", intent2.getIntExtra("connect_source", 0));
                            fbt6.O000000o("connect_unique", intent2.getStringExtra("connect_unique"));
                        }
                        fbt6.O000000o("model", pluginDeviceInfo.O00000Oo());
                        fbt6.O000000o("strategy_id", 11);
                        fbt6.O000000o("from_miui", z3);
                        fbt6.O000000o(100);
                        fbs.O000000o(fbt6);
                        return true;
                    }
                    O000000o(pluginDeviceInfo.O00000Oo(), z3, (Intent) null);
                    return true;
                } else if (hmz.O000000o(pluginDeviceInfo.O00000Oo()) || O00000o2 == 19) {
                    XiaomiRedMiRouter15 xiaomiRedMiRouter15 = new XiaomiRedMiRouter15(null, pluginDeviceInfo.O00000Oo());
                    hna.O00000Oo().getActionByDeviceRenderer(xiaomiRedMiRouter15, this.O00000Oo, xiaomiRedMiRouter15.O00000Oo());
                    return true;
                } else if (O00000o2 == 22) {
                    fbt fbt7 = new fbt(this.O00000Oo, "HualaiRouterConfigActivity");
                    fbt7.O000000o("model", pluginDeviceInfo.O00000Oo());
                    fbs.O000000o(fbt7);
                    this.O00000Oo.finish();
                    return true;
                } else if (pluginDeviceInfo.O0000o() == 5) {
                    Iterator<fni> it = this.O00000oO.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            fni = null;
                            break;
                        }
                        fni = it.next();
                        if (pluginDeviceInfo.O00000Oo().equalsIgnoreCase(fni.O00000o)) {
                            break;
                        }
                    }
                    if (fni == null) {
                        return false;
                    }
                    String[] O000000o4 = fnn.O000000o().O000000o(fni);
                    if (O000000o4 == null || O000000o4.length != 1) {
                        fbt fbt8 = new fbt(this.O00000Oo, "ModifyGroupActivity");
                        fbt8.O000000o("group_device_ids", O000000o4);
                        fbt8.O000000o("group_model", fni.O00000o);
                        fbs.O000000o(fbt8);
                        this.O00000Oo.setResult(-1);
                        return true;
                    }
                    final Device O000000o5 = fno.O000000o().O000000o(O000000o4[0]);
                    if (O000000o5 == null || !CoreApi.O000000o().O00000o(O000000o5.model)) {
                        return true;
                    }
                    Dialog dialog = this.f16876O000000o;
                    if (dialog != null && dialog.isShowing()) {
                        this.f16876O000000o.dismiss();
                    }
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this.O00000Oo);
                    builder.O000000o((int) R.string.dialog_title_one_device_tip);
                    builder.O000000o((int) R.string.dialog_option_one_more, new DialogInterface.OnClickListener() {
                        /* class _m_j.fpq.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            hjp.O000000o("https://home.mi.com/shop/search?keyword=" + O000000o5.name);
                            fpq.this.O00000Oo.setResult(-1);
                        }
                    });
                    builder.O00000Oo((int) R.string.dialog_option_okay, new DialogInterface.OnClickListener() {
                        /* class _m_j.fpq.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    this.f16876O000000o = builder.O00000o();
                    this.f16876O000000o.show();
                    return true;
                } else if (pluginDeviceInfo.O0000o() == Device.PID_VIRTUAL_GROUP) {
                    fbt fbt9 = new fbt(this.O00000Oo, "LightGroupSettingActivity");
                    fbt9.O000000o("key_group_model", pluginDeviceInfo.O00000Oo());
                    fbs.O000000o(fbt9);
                    return true;
                } else {
                    int O0000o = pluginDeviceInfo.O0000o();
                    if (O0000o == 0 || O0000o == 8 || pluginDeviceInfo.O00000Oo().equals("midr.cardvr.v1")) {
                        eyr.O00000Oo();
                        if (eyr.O00000oo(O00000Oo2) && gof.O00000Oo()) {
                            cuh cuh = new cuh(this.O00000Oo, "WifiRepeaterWpsChooseSceneActivity");
                            cuh.O000000o("model", O00000Oo2);
                            cub.O000000o(cuh);
                            z4 = true;
                        }
                        if (z4) {
                            return true;
                        }
                        O000000o(pluginDeviceInfo.O00000Oo(), z3, intent2);
                        return true;
                    }
                    CommonActivity commonActivity4 = this.O00000Oo;
                    izb.O000000o(commonActivity4, commonActivity4.getResources().getString(R.string.device_not_support_now), 0).show();
                    return false;
                }
            }
        }
    }

    private void O000000o(String str, boolean z, Intent intent) {
        Intent intent2 = new Intent(this.O00000Oo, ResetDevicePage.class);
        fqy.O000000o(intent2, intent);
        intent2.putExtra("model", str);
        intent2.putExtra("from_miui", z);
        if (intent != null && intent.hasExtra("key_qrcode_oob")) {
            intent2.putExtra("key_qrcode_oob", intent.getStringExtra("key_qrcode_oob"));
        }
        this.O00000Oo.startActivityForResult(intent2, 100);
    }
}
