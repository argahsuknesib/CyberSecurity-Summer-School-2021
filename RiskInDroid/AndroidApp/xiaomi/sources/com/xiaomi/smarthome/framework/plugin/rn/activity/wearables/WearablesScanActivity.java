package com.xiaomi.smarthome.framework.plugin.rn.activity.wearables;

import _m_j.fxc;
import _m_j.fxd;
import _m_j.fxe;
import _m_j.fxf;
import _m_j.fxg;
import _m_j.gbu;
import _m_j.gdt;
import _m_j.gdu;
import _m_j.gdv;
import _m_j.gpc;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.plugin.rn.LoadingRNActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WearablesScanActivity extends BaseActivity {
    private static int O0000OoO = 1000;

    /* renamed from: O000000o  reason: collision with root package name */
    private ImageView f8167O000000o;
    private TextView O00000Oo;
    private View O00000o;
    private View O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private Animation O0000O0o;
    private RecyclerView O0000OOo;
    private CompositeDisposable O0000Oo;
    private fxe O0000Oo0;
    private long O0000Ooo = -1;
    public List<fxf> mDevicePluginInfos;
    public fxg mDialog;
    public String mLoginUserId = "";
    public String mUserId;
    public Map<String, fxf> mapDefaultRnPluginPage;
    public Map<String, fxf> mapRnPluginPage;

    public static void startActivity(Context context, Uri uri) {
        Intent intent = new Intent(context, WearablesScanActivity.class);
        intent.setData(uri);
        context.startActivity(intent);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        View view;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_wearables_scan);
        this.O0000Oo = new CompositeDisposable();
        this.mapDefaultRnPluginPage = new HashMap();
        this.mapDefaultRnPluginPage.put("lumi.lock.mcn01", new fxf("lumi.lock.mcn01", "AddNfcGuidePage"));
        this.mapDefaultRnPluginPage.put("lumi.lock.bmcn02", new fxf("lumi.lock.bmcn02", "AddNfcGuidePage"));
        this.mapDefaultRnPluginPage.put("loock.lock.v5", new fxf("loock.lock.v5", "MemberDetail"));
        this.mapDefaultRnPluginPage.put("loock.lock.t1", new fxf("loock.lock.t1", "MemberDetail"));
        Uri data = getIntent().getData();
        if (data != null) {
            this.mUserId = data.getQueryParameter("uid");
        }
        fxc.O000000o().O00000Oo = null;
        this.f8167O000000o = (ImageView) findViewById(R.id.module_a_3_return_btn);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_return_title);
        this.f8167O000000o.setImageResource(R.drawable.ic_wearables_titlebar_left_back);
        this.O00000Oo.setText((int) R.string.rn_wearables_scan_device);
        this.O00000oo = (TextView) findViewById(R.id.tv_scan);
        this.O00000oO = findViewById(R.id.view_scan_ing);
        this.O0000O0o = AnimationUtils.loadAnimation(this, R.anim.anim_rotate_wearables_scanning);
        this.O0000O0o.setInterpolator(new LinearInterpolator());
        this.O00000o0 = findViewById(R.id.layout_scanning);
        this.O00000o0.setVisibility(0);
        this.O00000o = findViewById(R.id.layout_show_scan_devices);
        this.O00000o.setVisibility(8);
        this.O0000OOo = (RecyclerView) findViewById(R.id.rv_scan_device_info);
        this.O0000Oo0 = new fxe(this, this.mDevicePluginInfos);
        this.O0000OOo.setLayoutManager(new GridLayoutManager(this, 2));
        this.O0000OOo.addItemDecoration(new fxd(gpc.O000000o((Activity) this, 5.0f)));
        this.O0000OOo.setAdapter(this.O0000Oo0);
        this.O0000Oo0.O00000Oo = new fxe.O000000o() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass1 */

            public final void O000000o(fxf fxf) {
                gbu.O000000o(fxf.O00000o0);
                WearablesScanActivity.this.openPluginPage(fxf);
            }
        };
        this.f8167O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass9 */

            public final void onClick(View view) {
                WearablesScanActivity.this.finish();
            }
        });
        if (!(this.O0000O0o == null || (view = this.O00000oO) == null)) {
            view.clearAnimation();
            this.O00000oO.startAnimation(this.O0000O0o);
        }
        this.O0000Oo.add(Observable.create(new ObservableOnSubscribe<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass12 */

            public final void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                observableEmitter.onNext(XmPluginHostApi.instance().getAccountId());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass10 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                WearablesScanActivity.this.mLoginUserId = (String) obj;
                if (!((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o0()) {
                    WearablesScanActivity.this.checkUseTimeToShowCommonDialog(1);
                } else {
                    WearablesScanActivity.this.requestDeviceModels();
                }
            }
        }, new Consumer<Throwable>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass11 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                gbu.O00000Oo(((Throwable) obj).toString());
            }
        }));
    }

    public void stopViewScanning() {
        this.O00000oo.setText((int) R.string.rn_wearables_scan_complete);
        View view = this.O00000oO;
        if (view != null) {
            view.clearAnimation();
        }
    }

    public void requestDeviceModels() {
        XmPluginHostApi.instance().getAppConfig("locks_for_nfc_bracelet", "zh_CN", "1", new Callback<String>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass13 */

            public final /* synthetic */ void onSuccess(Object obj) {
                ArrayList arrayList;
                WearablesScanActivity.this.updateMapPluginPages((String) obj);
                if (WearablesScanActivity.this.mapRnPluginPage == null || WearablesScanActivity.this.mapRnPluginPage.size() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Map.Entry<String, fxf> key : WearablesScanActivity.this.mapRnPluginPage.entrySet()) {
                        arrayList.add(key.getKey());
                    }
                }
                WearablesScanActivity.this.requestDeviceInfoByModels(arrayList);
            }

            public final void onFailure(int i, String str) {
                WearablesScanActivity.this.requestDeviceInfoByModels(null);
            }
        });
    }

    public void updateMapPluginPages(String str) {
        if (this.mapRnPluginPage == null) {
            this.mapRnPluginPage = new HashMap();
        }
        this.mapRnPluginPage.clear();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("locks");
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                    String optString = jSONObject.optString("model");
                    this.mapRnPluginPage.put(optString, new fxf(optString, jSONObject.optString("pageName")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void requestDeviceInfoByModels(final List<String> list) {
        this.O0000Oo.add(Observable.create(new ObservableOnSubscribe<List<fxf>>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass16 */

            public final void subscribe(ObservableEmitter<List<fxf>> observableEmitter) throws Exception {
                boolean z;
                List list = list;
                if (list == null || list.size() == 0) {
                    z = true;
                    list = new ArrayList();
                    for (Map.Entry<String, fxf> key : WearablesScanActivity.this.mapDefaultRnPluginPage.entrySet()) {
                        list.add(key.getKey());
                    }
                } else {
                    z = false;
                }
                List<DeviceStat> deviceListV2 = XmPluginHostApi.instance().getDeviceListV2(list);
                ArrayList arrayList = new ArrayList();
                if (deviceListV2 != null && deviceListV2.size() > 0) {
                    for (DeviceStat next : deviceListV2) {
                        Room O00000oO = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000oO(next.did);
                        Home O00000o = ((gdt) gdv.f17570O000000o.getServiceInterface()).O00000o(next.did);
                        String str = "";
                        String name = O00000oO != null ? O00000oO.getName() : str;
                        if (O00000o != null) {
                            str = O00000o.getRawName();
                        }
                        String str2 = str;
                        fxf fxf = (fxf) (z ? WearablesScanActivity.this.mapDefaultRnPluginPage : WearablesScanActivity.this.mapRnPluginPage).get(next.model);
                        fxf fxf2 = new fxf(fxf.f17367O000000o, fxf.O00000Oo, next.name, str2, name);
                        fxf2.O00000oo = next;
                        arrayList.add(fxf2);
                    }
                }
                observableEmitter.onNext(arrayList);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<List<fxf>>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass14 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                WearablesScanActivity.this.mDevicePluginInfos = (List) obj;
                gbu.O000000o("mijia.wearables.app", "mijia.wearables.app", "米家登录的账号： " + WearablesScanActivity.this.mLoginUserId + "    穿戴传递过来的账号：" + WearablesScanActivity.this.mUserId);
                if (!WearablesScanActivity.this.mLoginUserId.equals(WearablesScanActivity.this.mUserId)) {
                    if (WearablesScanActivity.this.mDevicePluginInfos == null || WearablesScanActivity.this.mDevicePluginInfos.size() == 0) {
                        WearablesScanActivity.this.checkUseTimeToShowCommonDialog(2);
                    } else {
                        WearablesScanActivity.this.checkUseTimeToShowCommonDialog(3);
                    }
                } else if (WearablesScanActivity.this.mDevicePluginInfos == null || WearablesScanActivity.this.mDevicePluginInfos.size() == 0) {
                    WearablesScanActivity.this.checkUseTimeToShowCommonDialog(4);
                } else {
                    WearablesScanActivity.this.checkUseTimeToShowDeviceInfoOrOpenPlugin();
                }
            }
        }, new Consumer<Throwable>() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass15 */

            public final /* bridge */ /* synthetic */ void accept(Object obj) throws Exception {
            }
        }));
    }

    public void checkUseTimeToShowDeviceInfoOrOpenPlugin() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.O0000Ooo;
        long j2 = currentTimeMillis - j;
        if (j < 0 || j2 < ((long) O0000OoO)) {
            final int i = this.O0000Ooo < 0 ? O0000OoO : (int) (((long) O0000OoO) - j2);
            gbu.O000000o("sleep time is ".concat(String.valueOf(i)));
            this.O0000Oo.add(Observable.create(new ObservableOnSubscribe<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass4 */

                public final void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    Thread.sleep((long) i);
                    observableEmitter.onNext("");
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass2 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    if (WearablesScanActivity.this.mDevicePluginInfos == null || WearablesScanActivity.this.mDevicePluginInfos.size() != 1) {
                        WearablesScanActivity.this.showDeviceInfo();
                        return;
                    }
                    WearablesScanActivity wearablesScanActivity = WearablesScanActivity.this;
                    wearablesScanActivity.openPluginPage(wearablesScanActivity.mDevicePluginInfos.get(0));
                }
            }, new Consumer<Throwable>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass3 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    WearablesScanActivity.this.showDeviceInfo();
                }
            }));
            return;
        }
        List<fxf> list = this.mDevicePluginInfos;
        if (list == null || list.size() != 1) {
            showDeviceInfo();
        } else {
            openPluginPage(this.mDevicePluginInfos.get(0));
        }
    }

    public void showDeviceInfo() {
        stopViewScanning();
        this.O00000o0.setVisibility(8);
        this.O00000o.setVisibility(0);
        fxe fxe = this.O0000Oo0;
        fxe.f17364O000000o = this.mDevicePluginInfos;
        fxe.notifyDataSetChanged();
    }

    public void checkUseTimeToShowCommonDialog(final int i) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.O0000Ooo;
        long j2 = currentTimeMillis - j;
        if (j < 0 || j2 < ((long) O0000OoO)) {
            final int i2 = this.O0000Ooo < 0 ? O0000OoO : (int) (((long) O0000OoO) - j2);
            this.O0000Oo.add(Observable.create(new ObservableOnSubscribe<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass7 */

                public final void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
                    Thread.sleep((long) i2);
                    observableEmitter.onNext("");
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass5 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    WearablesScanActivity.this.stopViewScanning();
                    WearablesScanActivity.this.showCommonDialog(i);
                }
            }, new Consumer<Throwable>() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass6 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    WearablesScanActivity.this.stopViewScanning();
                    WearablesScanActivity.this.showCommonDialog(i);
                }
            }));
            return;
        }
        stopViewScanning();
        showCommonDialog(i);
    }

    public void showCommonDialog(int i) {
        int i2;
        if (this.mDialog == null) {
            this.mDialog = new fxg();
            this.mDialog.O00000o0 = new fxg.O000000o() {
                /* class com.xiaomi.smarthome.framework.plugin.rn.activity.wearables.WearablesScanActivity.AnonymousClass8 */

                public final void O000000o() {
                    WearablesScanActivity.this.mDialog.dismiss();
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O00000Oo(WearablesScanActivity.this);
                    WearablesScanActivity.this.finish();
                }

                public final void O000000o(int i) {
                    WearablesScanActivity.this.mDialog.dismiss();
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                WearablesScanActivity.this.showDeviceInfo();
                                return;
                            } else if (i != 4) {
                                return;
                            }
                        }
                        Intent launchIntentForPackage = WearablesScanActivity.this.getPackageManager().getLaunchIntentForPackage("com.xiaomi.wearable");
                        if (launchIntentForPackage != null) {
                            launchIntentForPackage.setFlags(268435456);
                            WearablesScanActivity.this.startActivity(launchIntentForPackage);
                        }
                        WearablesScanActivity.this.finish();
                        return;
                    }
                    fxc.O000000o().O00000Oo = WearablesScanActivity.this.getIntent().getData();
                    ((gdu) gdv.f17570O000000o.getUiInterface()).O000000o(WearablesScanActivity.this);
                    WearablesScanActivity.this.finish();
                }
            };
        }
        fxg fxg = this.mDialog;
        fxg.f17368O000000o = i;
        List<fxf> list = this.mDevicePluginInfos;
        if (list == null) {
            i2 = 0;
        } else {
            i2 = list.size();
        }
        fxg.O00000Oo = i2;
        fxg.show(getSupportFragmentManager(), "WearablesCommonDialog");
    }

    public void openPluginPage(fxf fxf) {
        Intent intent = new Intent(this, LoadingRNActivity.class);
        intent.putExtra("pageName", fxf.O00000Oo);
        intent.putExtra("did", fxf.O00000oo.did);
        intent.putExtra("activity_start_from", 1001);
        startActivity(intent);
        finish();
    }

    public void onResume() {
        super.onResume();
        if (this.O0000Ooo < 0) {
            this.O0000Ooo = System.currentTimeMillis();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.O0000Oo.clear();
    }
}
