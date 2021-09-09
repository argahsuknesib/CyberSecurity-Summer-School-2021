package com.xiaomi.smarthome.miui;

import _m_j.dcp;
import _m_j.dct;
import _m_j.ddp;
import _m_j.exo;
import _m_j.ezb;
import _m_j.ezc;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.feb;
import _m_j.ffr;
import _m_j.fmd;
import _m_j.fml;
import _m_j.fmy;
import _m_j.fno;
import _m_j.foc;
import _m_j.fod;
import _m_j.fqy;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gnl;
import _m_j.gpc;
import _m_j.gpv;
import _m_j.gqd;
import _m_j.gsy;
import _m_j.gtx;
import _m_j.gty;
import _m_j.gyx;
import _m_j.hab;
import _m_j.hlz;
import _m_j.hna;
import _m_j.htt;
import _m_j.htx;
import _m_j.hty;
import _m_j.hxc;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import _m_j.hyy;
import _m_j.izb;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.xiaomi.miot.BinderParcel;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.ChooseConnectDeviceAdapter;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.bluetooth.BleDeviceGroup;
import com.xiaomi.smarthome.device.choosedevice.ChooseDeviceActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miui.FindDeviceDialogActivity;
import com.xiaomi.smarthome.service.DeviceObserveService;
import com.xiaomi.smarthome.smartconfig.PushBindEntity;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class FindDeviceDialogActivity extends BaseActivity {
    private static final int O00000oo = gpc.O000000o(20.0f);
    private static final int O0000O0o = gpc.O000000o(160.0f);
    public static boolean sResumed = false;

    /* renamed from: O000000o  reason: collision with root package name */
    private String f9997O000000o;
    private boolean O00000Oo;
    private MLAlertDialog O00000o;
    private BinderParcel O00000o0;
    private LinearLayout O00000oO;
    private RecyclerView O0000OOo;
    private Runnable O0000Oo = new Runnable() {
        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass1 */

        public final void run() {
            DeviceObserveService.O000000o().O000000o(FindDeviceDialogActivity.this.scanResult == null ? null : FindDeviceDialogActivity.this.scanResult.SSID, false);
            FindDeviceDialogActivity.this.finish();
        }
    };
    private gyx O0000Oo0;
    private boolean O0000OoO = false;
    public BleDevice bleDevice;
    public long bleMainConnectStartTime = 0;
    public boolean mPlayVideo = false;
    public boolean mShowTips = true;
    public int mStrategyId;
    public VideoView mVideoIcon;
    public ScanResult scanResult;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O000000o(java.lang.String, boolean):boolean
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O000000o(android.content.Context, java.lang.String):int
      _m_j.gpv.O000000o(java.lang.String, java.lang.String):java.lang.String
      _m_j.gpv.O000000o(android.content.SharedPreferences, java.lang.String):boolean
      _m_j.gpv.O000000o(java.lang.String, boolean):boolean */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0197, code lost:
        if (r7 == 17) goto L_0x019c;
     */
    public void onCreate(Bundle bundle) {
        Button button;
        Button button2;
        int i;
        char c;
        int i2;
        ScanResult scanResult2;
        requestWindowFeature(1);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("strategy_id", -1);
            this.mStrategyId = intExtra;
            if (!(intExtra <= 0 && intent.getParcelableExtra("find_device") == null && fmy.O00000o == null)) {
                this.scanResult = (ScanResult) intent.getParcelableExtra("find_device");
                this.bleDevice = fmy.O00000o;
                String stringExtra = intent.getStringExtra("device_name");
                final String stringExtra2 = intent.getStringExtra("model");
                this.f9997O000000o = stringExtra2;
                final String stringExtra3 = intent.getStringExtra("image_url");
                final String stringExtra4 = intent.getStringExtra("video_url");
                final boolean booleanExtra = intent.getBooleanExtra("from_miui", false);
                this.O00000Oo = intent.getBooleanExtra("is_uwb_device", false);
                if (this.O00000Oo) {
                    this.O00000o0 = (BinderParcel) intent.getParcelableExtra("handler");
                }
                final ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("bind_aiot_wifi");
                if (this.bleDevice == null && parcelableArrayListExtra == null && !DeviceObserveService.O000000o().O00000Oo(this.scanResult)) {
                    dct.O00000o0("DeviceObserverService finish");
                    finish();
                    return;
                }
                this.mShowTips = gpv.O000000o("find_device_tips", true);
                if (!booleanExtra) {
                    this.mShowTips = false;
                }
                setContentView((int) R.layout.activity_find_device_dialog);
                this.O00000oO = (LinearLayout) findViewById(R.id.dialog);
                ViewGroup.LayoutParams layoutParams = this.O00000oO.getLayoutParams();
                if (hyy.O000000o() && (layoutParams instanceof FrameLayout.LayoutParams)) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.gravity = 17;
                    layoutParams2.width = (int) (((float) hyy.O00000Oo(getIntent()).widthPixels) * 0.8f);
                    this.O00000oO.setBackgroundResource(R.drawable.std_dialog_bg);
                }
                this.O00000oO.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass20 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        return true;
                    }
                });
                TextView textView = (TextView) findViewById(R.id.title);
                TextView textView2 = (TextView) findViewById(R.id.tv_device_name);
                textView2.setText(stringExtra);
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.icon_static);
                this.mVideoIcon = (VideoView) findViewById(R.id.icon_video);
                this.O0000OOo = (RecyclerView) findViewById(R.id.recycler_view);
                View findViewById = findViewById(R.id.icon_container);
                NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
                if (!(notificationManager == null || (scanResult2 = this.scanResult) == null || scanResult2.SSID == null)) {
                    gsy.O000000o(6, "DeviceObserverService", "cancel notify - " + this.scanResult.SSID.hashCode());
                    notificationManager.cancel(this.scanResult.SSID.hashCode());
                }
                dct.O00000o0("DeviceObserverService show device dialog -".concat(String.valueOf(stringExtra)));
                if (simpleDraweeView.getHierarchy() == null) {
                    simpleDraweeView.setHierarchy(new GenericDraweeHierarchyBuilder(simpleDraweeView.getResources()).setFadeDuration(200).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                }
                int i3 = this.mStrategyId;
                int i4 = i3 != 16 ? 17 : 17;
                if (parcelableArrayListExtra != null) {
                    if (parcelableArrayListExtra.size() == 1) {
                        PushBindEntity pushBindEntity = (PushBindEntity) parcelableArrayListExtra.get(0);
                        if (this.mStrategyId == i4) {
                            textView.setText((int) R.string.push_confirmbind_find_hide_device_title);
                            i2 = 0;
                        } else {
                            i2 = 0;
                            textView.setText(String.format(getString(R.string.push_confirmbind_find_device_title), pushBindEntity.f11457O000000o.O0000Oo0()));
                        }
                        if (!TextUtils.isEmpty(pushBindEntity.f11457O000000o.O0000Oo0())) {
                            textView2.setVisibility(i2);
                            textView2.setText(pushBindEntity.f11457O000000o.O0000Oo0());
                        }
                        final SimpleDraweeView simpleDraweeView2 = simpleDraweeView;
                        final View view = findViewById;
                        hlz.O000000o(pushBindEntity.f11457O000000o.O00000Oo(), new fsm<hlz.O000000o, fso>() {
                            /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass21 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                hlz.O000000o o000000o = (hlz.O000000o) obj;
                                FindDeviceDialogActivity.this.setImage(o000000o.f19057O000000o, o000000o.O00000Oo, simpleDraweeView2, view);
                            }

                            public final void onFailure(fso fso) {
                                FindDeviceDialogActivity.this.setImage(stringExtra3, stringExtra4, simpleDraweeView2, view);
                            }
                        });
                    } else {
                        findViewById.setAlpha(1.0f);
                        this.O0000OOo.setVisibility(0);
                        this.mVideoIcon.setVisibility(8);
                        simpleDraweeView.setVisibility(8);
                        this.O0000OOo.setLayoutManager(new LinearLayoutManager(this));
                        if (parcelableArrayListExtra.size() > 4) {
                            this.O0000OOo.getLayoutParams().height = gpc.O000000o(280.0f);
                        }
                        this.O0000OOo.setAdapter(new ezb<PushBindEntity>(this, parcelableArrayListExtra) {
                            /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass22 */

                            public final int O00000o0(int i) {
                                return R.layout.choose_device_nearby_item;
                            }

                            public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
                                PushBindEntity pushBindEntity = (PushBindEntity) obj;
                                ezc.O000000o((int) R.id.arrow).setVisibility(8);
                                ezc.O000000o((int) R.id.divider).setVisibility(8);
                                ezc.O000000o((int) R.id.name_status).setVisibility(8);
                                TextView textView = (TextView) ezc.O000000o((int) R.id.name);
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ezc.O000000o((int) R.id.image);
                                if (!TextUtils.isEmpty(pushBindEntity.O0000Ooo)) {
                                    textView.setText(pushBindEntity.f11457O000000o.O0000Oo0() + pushBindEntity.O0000Ooo);
                                } else {
                                    String str = pushBindEntity.O00000o;
                                    String str2 = "";
                                    if (str != null && str.length() > 2) {
                                        str2 = str.substring(str.length() - 2, str.length()).replace(":", str2);
                                    }
                                    textView.setText(pushBindEntity.f11457O000000o.O0000Oo0() + str2);
                                }
                                DeviceFactory.O00000Oo(pushBindEntity.f11457O000000o.O00000Oo(), simpleDraweeView);
                            }
                        });
                        if (this.mStrategyId == 17) {
                            textView.setText(getResources().getQuantityString(R.plurals.push_confirmbind_find_hide_devices_title, parcelableArrayListExtra.size(), Integer.valueOf(parcelableArrayListExtra.size())));
                        } else {
                            textView.setText(getResources().getQuantityString(R.plurals.push_confirmbind_find_devices_title, parcelableArrayListExtra.size(), Integer.valueOf(parcelableArrayListExtra.size())));
                        }
                    }
                    findViewById(R.id.dialog_container).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass23 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                         arg types: [java.lang.String, int]
                         candidates:
                          _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                          _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                          _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                        public final void onClick(View view) {
                            if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                                FindDeviceDialogActivity.this.mVideoIcon.pause();
                            }
                            if (FindDeviceDialogActivity.this.scanResult != null) {
                                if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                    fmy.O00000o0().O000000o(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID));
                                }
                                if (FindDeviceDialogActivity.this.mShowTips) {
                                    gpv.O00000Oo("find_device_tips", false);
                                    fbs.O000000o(new fbt(FindDeviceDialogActivity.this.getContext(), "DialogTipsActivity"));
                                }
                                if (booleanExtra) {
                                    hxk hxk = hxi.O00000o;
                                    String str = stringExtra2;
                                    hxk.f952O000000o.O000000o("miui_popup_close", "model", str);
                                } else {
                                    hxk hxk2 = hxi.O00000o;
                                    String str2 = stringExtra2;
                                    hxk2.f952O000000o.O000000o("app_popup_close", "model", str2);
                                }
                            }
                            if (FindDeviceDialogActivity.this.bleDevice != null) {
                                fmy.O00000o0().O000000o(FindDeviceDialogActivity.this.bleDevice);
                                hxk hxk3 = hxi.O00000o;
                                String str3 = FindDeviceDialogActivity.this.bleDevice.model;
                                hxk3.f952O000000o.O000000o("find_device_cancel", "model", str3);
                            }
                            FindDeviceDialogActivity.this.finish();
                            FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                        }
                    });
                    button = (Button) findViewById(R.id.button1);
                    if (this.mStrategyId > 0 || parcelableArrayListExtra == null) {
                        button.setText((int) R.string.begin_connection);
                    } else if (parcelableArrayListExtra.size() != 1) {
                        button.setText((int) R.string.look_up);
                    } else if (fml.O00000Oo(((PushBindEntity) parcelableArrayListExtra.get(0)).f11457O000000o.O00000Oo())) {
                        button.setText((int) R.string.pushbind_auth);
                    } else {
                        button.setText((int) R.string.begin_connection);
                    }
                    button.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass2 */

                        public final void onClick(View view) {
                            if (FindDeviceDialogActivity.this.mStrategyId > 0) {
                                hxc.O000000o().O000000o(stringExtra2, FindDeviceDialogActivity.this.mStrategyId == 17 ? 10 : 8);
                                FindDeviceDialogActivity.this.changeHomeAndStartConnection(new Runnable(parcelableArrayListExtra, stringExtra2) {
                                    /* class com.xiaomi.smarthome.miui.$$Lambda$FindDeviceDialogActivity$2$1kPFSZr0woLi57QP7Q0_KgHJJ0o */
                                    private final /* synthetic */ ArrayList f$1;
                                    private final /* synthetic */ String f$2;

                                    {
                                        this.f$1 = r2;
                                        this.f$2 = r3;
                                    }

                                    public final void run() {
                                        FindDeviceDialogActivity.AnonymousClass2.this.O000000o(this.f$1, this.f$2);
                                    }
                                });
                            } else if (FindDeviceDialogActivity.this.scanResult != null) {
                                if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                    fmy.O00000o0().O000000o(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID));
                                }
                                htx O000000o2 = hty.O000000o();
                                if (O000000o2 != null) {
                                    if (htt.O000000o(stringExtra2)) {
                                        FindDeviceDialogActivity findDeviceDialogActivity = FindDeviceDialogActivity.this;
                                        ChooseConnectDeviceAdapter.O000000o(findDeviceDialogActivity, stringExtra2, findDeviceDialogActivity.scanResult);
                                    } else if (htt.O00000Oo(stringExtra2)) {
                                        FindDeviceDialogActivity findDeviceDialogActivity2 = FindDeviceDialogActivity.this;
                                        ChooseConnectDeviceAdapter.O00000Oo(findDeviceDialogActivity2, stringExtra2, findDeviceDialogActivity2.scanResult);
                                    } else {
                                        fbt smartConfigRequest = O000000o2.getSmartConfigRequest(CommonApplication.getAppContext(), FindDeviceDialogActivity.this.scanResult, stringExtra2, null, null);
                                        if (smartConfigRequest != null) {
                                            smartConfigRequest.O000000o("connect_source", 5);
                                            String uuid = UUID.randomUUID().toString();
                                            smartConfigRequest.O000000o("connect_unique", uuid);
                                            hxi.O00000o.O000000o(stringExtra2, 5, uuid);
                                            smartConfigRequest.O00000Oo(268435456);
                                            if (booleanExtra) {
                                                smartConfigRequest.O000000o("category", 2);
                                            } else {
                                                smartConfigRequest.O000000o("category", 5);
                                            }
                                            smartConfigRequest.O000000o("from_miui", booleanExtra);
                                            fbs.O000000o(smartConfigRequest);
                                        }
                                    }
                                    if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                                        FindDeviceDialogActivity.this.mVideoIcon.pause();
                                    }
                                }
                                if (booleanExtra) {
                                    hxi.O00000o.f952O000000o.O000000o("miui_popup_add", "model", stringExtra2);
                                } else {
                                    hxi.O00000o.f952O000000o.O000000o("app_popup_add", "model", stringExtra2);
                                }
                            } else if (FindDeviceDialogActivity.this.bleDevice != null) {
                                if (0 != FindDeviceDialogActivity.this.bleMainConnectStartTime) {
                                    hxi.O0000Oo0.f962O000000o.O000000o("find_device_stay", "model", FindDeviceDialogActivity.this.bleDevice.model, "stay_time", Long.valueOf(System.currentTimeMillis() - FindDeviceDialogActivity.this.bleMainConnectStartTime));
                                }
                                hxi.O00000o.f952O000000o.O000000o("find_device_add", "model", FindDeviceDialogActivity.this.bleDevice.model);
                                FindDeviceDialogActivity.this.checkLoginAndConnect();
                                return;
                            }
                            FindDeviceDialogActivity.this.finish();
                            FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                         arg types: [java.lang.String, com.xiaomi.smarthome.smartconfig.PushBindEntity]
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
                        /* access modifiers changed from: private */
                        public /* synthetic */ void O000000o(ArrayList arrayList, String str) {
                            if (arrayList == null || arrayList.size() != 1) {
                                Intent intent = new Intent(FindDeviceDialogActivity.this.getContext(), ChooseDeviceActivity.class);
                                intent.addFlags(67108864);
                                intent.addFlags(536870912);
                                intent.putExtra("extra_show", 1);
                                FindDeviceDialogActivity.this.startActivity(intent);
                                return;
                            }
                            PushBindEntity pushBindEntity = (PushBindEntity) arrayList.get(0);
                            fbt fbt = new fbt(FindDeviceDialogActivity.this.getContext(), "PushBindConfigActivity");
                            int i = FindDeviceDialogActivity.this.mStrategyId == 17 ? 10 : 8;
                            fbt.O000000o("connect_source", i);
                            String uuid = UUID.randomUUID().toString();
                            fbt.O000000o("connect_unique", uuid);
                            hxi.O00000o.O000000o(str, i, uuid);
                            fbt.O000000o("bind_aiot_wifi", (Parcelable) pushBindEntity);
                            fbs.O000000o(fbt);
                        }
                    });
                    button2 = (Button) findViewById(R.id.button2);
                    if (parcelableArrayListExtra != null || parcelableArrayListExtra.size() <= 1) {
                        button2.setText((int) R.string.ignore);
                    } else {
                        button2.setText((int) R.string.ignoreall);
                    }
                    button2.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3 */

                        public final void onClick(View view) {
                            if (FindDeviceDialogActivity.this.bleDevice != null) {
                                hxk hxk = hxi.O00000o;
                                String str = FindDeviceDialogActivity.this.bleDevice.model;
                                hxk.f952O000000o.O000000o("ignore_device_ignore", "model", str);
                            }
                            if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                                FindDeviceDialogActivity.this.mVideoIcon.pause();
                            }
                            if (FindDeviceDialogActivity.this.bleDevice != null || parcelableArrayListExtra != null || FindDeviceDialogActivity.this.scanResult != null) {
                                final hab hab = new hab();
                                hab.f18684O000000o = new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        if (FindDeviceDialogActivity.this.bleDevice != null) {
                                            hxk hxk = hxi.O00000o;
                                            String str = FindDeviceDialogActivity.this.bleDevice.model;
                                            hxk.f952O000000o.O000000o("ignore_device_cancel", "model", str);
                                        }
                                        FindDeviceDialogActivity.this.showDialog();
                                        hab.dismiss();
                                    }
                                };
                                hab.O00000Oo = new View.OnClickListener() {
                                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3.AnonymousClass2 */

                                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                                     arg types: [java.lang.String, int]
                                     candidates:
                                      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                                      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                                      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                                    public final void onClick(View view) {
                                        Handler handler;
                                        if (FindDeviceDialogActivity.this.bleDevice != null) {
                                            fmy O00000o0 = fmy.O00000o0();
                                            BleDevice bleDevice = FindDeviceDialogActivity.this.bleDevice;
                                            dct.O00000o0("addIgnoreBleDevice");
                                            if (bleDevice == null) {
                                                dct.O00000o0("bleDevice is null");
                                            } else if (TextUtils.isEmpty(bleDevice.mac)) {
                                                dct.O00000o0("mac is empty");
                                            } else {
                                                O00000o0.O00000oo.add(bleDevice.mac);
                                                CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0).edit().putStringSet("ignore_mac_set", O00000o0.O00000oo).apply();
                                                if (DeviceFactory.O00000Oo(bleDevice)) {
                                                    String str = bleDevice.O00000Oo().O00000oo;
                                                    O00000o0.O0000O0o.add(str.toUpperCase(Locale.ENGLISH));
                                                    CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0).edit().putStringSet("ignore_combo_key_set", O00000o0.O0000O0o).apply();
                                                    dcp O000000o2 = dcp.O000000o();
                                                    String str2 = bleDevice.mac;
                                                    dct.O00000oO("setMiuiIgnoreTotal");
                                                    if (O000000o2.O00000oO != null) {
                                                        O000000o2.O00000oO.O00000Oo(str2, str);
                                                    } else {
                                                        dct.O00000o0("miuiService is null!");
                                                    }
                                                } else {
                                                    dcp O000000o3 = dcp.O000000o();
                                                    String str3 = bleDevice.mac;
                                                    if (O000000o3.O00000oO != null) {
                                                        O000000o3.O00000oO.O00000oO(str3);
                                                    } else {
                                                        dct.O00000o0("miuiService is null!");
                                                    }
                                                }
                                            }
                                            hxi.O00000o.f952O000000o.O000000o("ignore_device_confirm", "model", FindDeviceDialogActivity.this.bleDevice.model);
                                        } else if (parcelableArrayListExtra != null) {
                                            Iterator it = parcelableArrayListExtra.iterator();
                                            while (it.hasNext()) {
                                                PushBindEntity pushBindEntity = (PushBindEntity) it.next();
                                                fmy.O00000o0().O00000o0(DeviceFactory.O00000o0(pushBindEntity.O00000o, pushBindEntity.O00000o0));
                                            }
                                        } else if (FindDeviceDialogActivity.this.scanResult != null) {
                                            DeviceObserveService O000000o4 = DeviceObserveService.O000000o();
                                            String str4 = FindDeviceDialogActivity.this.scanResult.SSID;
                                            if (O000000o4.O00000o0() && (handler = O000000o4.O00000oO) != null) {
                                                handler.sendMessage(O000000o4.O00000oO.obtainMessage(2, str4));
                                            }
                                            if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                                fmy.O00000o0().O00000o0(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID).toUpperCase(Locale.ENGLISH));
                                            }
                                            if (FindDeviceDialogActivity.this.mShowTips) {
                                                gpv.O00000Oo("find_device_tips", false);
                                                fbs.O000000o(new fbt(FindDeviceDialogActivity.this.getContext(), "DialogTipsActivity"));
                                            }
                                            if (booleanExtra) {
                                                hxi.O00000o.f952O000000o.O000000o("miui_popup_ignore", "model", stringExtra2);
                                            } else {
                                                hxi.O00000o.f952O000000o.O000000o("app_popup_ignore", "model", stringExtra2);
                                            }
                                        }
                                        FindDeviceDialogActivity.this.finish();
                                        FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                                    }
                                };
                                FindDeviceDialogActivity.this.hideDialog();
                                if (FindDeviceDialogActivity.this.bleDevice != null) {
                                    hxr hxr = hxi.O00000oO;
                                    String str2 = FindDeviceDialogActivity.this.bleDevice.model;
                                    hxr.f958O000000o.O000000o("ignore_device_pop", "model", str2);
                                }
                                hab.show(FindDeviceDialogActivity.this.getSupportFragmentManager(), "ignore dialog show");
                            }
                        }
                    });
                    return;
                }
                if (this.bleDevice != null) {
                    textView2.setVisibility(0);
                    this.bleMainConnectStartTime = System.currentTimeMillis();
                    gsy.O00000Oo("mainconnect", "set BleDevice Image");
                    setImage(stringExtra3, stringExtra4, simpleDraweeView, findViewById);
                    textView.setText((int) R.string.wifi_scan_new_device_title);
                } else {
                    if (booleanExtra) {
                        c = 0;
                        i = 1;
                        hxi.O00000oO.f958O000000o.O000000o("miui_bottom_find", "model", stringExtra2);
                    } else {
                        c = 0;
                        i = 1;
                        hxi.O00000oO.f958O000000o.O000000o("app_bottom_popup", "model", stringExtra2);
                    }
                    setImage(stringExtra3, stringExtra4, simpleDraweeView, findViewById);
                    String string = getString(R.string.miui_find_device_title);
                    Object[] objArr = new Object[i];
                    objArr[c] = stringExtra;
                    textView.setText(String.format(string, objArr));
                }
                findViewById(R.id.dialog_container).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass23 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                    public final void onClick(View view) {
                        if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                            FindDeviceDialogActivity.this.mVideoIcon.pause();
                        }
                        if (FindDeviceDialogActivity.this.scanResult != null) {
                            if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                fmy.O00000o0().O000000o(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID));
                            }
                            if (FindDeviceDialogActivity.this.mShowTips) {
                                gpv.O00000Oo("find_device_tips", false);
                                fbs.O000000o(new fbt(FindDeviceDialogActivity.this.getContext(), "DialogTipsActivity"));
                            }
                            if (booleanExtra) {
                                hxk hxk = hxi.O00000o;
                                String str = stringExtra2;
                                hxk.f952O000000o.O000000o("miui_popup_close", "model", str);
                            } else {
                                hxk hxk2 = hxi.O00000o;
                                String str2 = stringExtra2;
                                hxk2.f952O000000o.O000000o("app_popup_close", "model", str2);
                            }
                        }
                        if (FindDeviceDialogActivity.this.bleDevice != null) {
                            fmy.O00000o0().O000000o(FindDeviceDialogActivity.this.bleDevice);
                            hxk hxk3 = hxi.O00000o;
                            String str3 = FindDeviceDialogActivity.this.bleDevice.model;
                            hxk3.f952O000000o.O000000o("find_device_cancel", "model", str3);
                        }
                        FindDeviceDialogActivity.this.finish();
                        FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                    }
                });
                button = (Button) findViewById(R.id.button1);
                if (this.mStrategyId > 0) {
                }
                button.setText((int) R.string.begin_connection);
                button.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass2 */

                    public final void onClick(View view) {
                        if (FindDeviceDialogActivity.this.mStrategyId > 0) {
                            hxc.O000000o().O000000o(stringExtra2, FindDeviceDialogActivity.this.mStrategyId == 17 ? 10 : 8);
                            FindDeviceDialogActivity.this.changeHomeAndStartConnection(new Runnable(parcelableArrayListExtra, stringExtra2) {
                                /* class com.xiaomi.smarthome.miui.$$Lambda$FindDeviceDialogActivity$2$1kPFSZr0woLi57QP7Q0_KgHJJ0o */
                                private final /* synthetic */ ArrayList f$1;
                                private final /* synthetic */ String f$2;

                                {
                                    this.f$1 = r2;
                                    this.f$2 = r3;
                                }

                                public final void run() {
                                    FindDeviceDialogActivity.AnonymousClass2.this.O000000o(this.f$1, this.f$2);
                                }
                            });
                        } else if (FindDeviceDialogActivity.this.scanResult != null) {
                            if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                fmy.O00000o0().O000000o(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID));
                            }
                            htx O000000o2 = hty.O000000o();
                            if (O000000o2 != null) {
                                if (htt.O000000o(stringExtra2)) {
                                    FindDeviceDialogActivity findDeviceDialogActivity = FindDeviceDialogActivity.this;
                                    ChooseConnectDeviceAdapter.O000000o(findDeviceDialogActivity, stringExtra2, findDeviceDialogActivity.scanResult);
                                } else if (htt.O00000Oo(stringExtra2)) {
                                    FindDeviceDialogActivity findDeviceDialogActivity2 = FindDeviceDialogActivity.this;
                                    ChooseConnectDeviceAdapter.O00000Oo(findDeviceDialogActivity2, stringExtra2, findDeviceDialogActivity2.scanResult);
                                } else {
                                    fbt smartConfigRequest = O000000o2.getSmartConfigRequest(CommonApplication.getAppContext(), FindDeviceDialogActivity.this.scanResult, stringExtra2, null, null);
                                    if (smartConfigRequest != null) {
                                        smartConfigRequest.O000000o("connect_source", 5);
                                        String uuid = UUID.randomUUID().toString();
                                        smartConfigRequest.O000000o("connect_unique", uuid);
                                        hxi.O00000o.O000000o(stringExtra2, 5, uuid);
                                        smartConfigRequest.O00000Oo(268435456);
                                        if (booleanExtra) {
                                            smartConfigRequest.O000000o("category", 2);
                                        } else {
                                            smartConfigRequest.O000000o("category", 5);
                                        }
                                        smartConfigRequest.O000000o("from_miui", booleanExtra);
                                        fbs.O000000o(smartConfigRequest);
                                    }
                                }
                                if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                                    FindDeviceDialogActivity.this.mVideoIcon.pause();
                                }
                            }
                            if (booleanExtra) {
                                hxi.O00000o.f952O000000o.O000000o("miui_popup_add", "model", stringExtra2);
                            } else {
                                hxi.O00000o.f952O000000o.O000000o("app_popup_add", "model", stringExtra2);
                            }
                        } else if (FindDeviceDialogActivity.this.bleDevice != null) {
                            if (0 != FindDeviceDialogActivity.this.bleMainConnectStartTime) {
                                hxi.O0000Oo0.f962O000000o.O000000o("find_device_stay", "model", FindDeviceDialogActivity.this.bleDevice.model, "stay_time", Long.valueOf(System.currentTimeMillis() - FindDeviceDialogActivity.this.bleMainConnectStartTime));
                            }
                            hxi.O00000o.f952O000000o.O000000o("find_device_add", "model", FindDeviceDialogActivity.this.bleDevice.model);
                            FindDeviceDialogActivity.this.checkLoginAndConnect();
                            return;
                        }
                        FindDeviceDialogActivity.this.finish();
                        FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                     arg types: [java.lang.String, com.xiaomi.smarthome.smartconfig.PushBindEntity]
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
                    /* access modifiers changed from: private */
                    public /* synthetic */ void O000000o(ArrayList arrayList, String str) {
                        if (arrayList == null || arrayList.size() != 1) {
                            Intent intent = new Intent(FindDeviceDialogActivity.this.getContext(), ChooseDeviceActivity.class);
                            intent.addFlags(67108864);
                            intent.addFlags(536870912);
                            intent.putExtra("extra_show", 1);
                            FindDeviceDialogActivity.this.startActivity(intent);
                            return;
                        }
                        PushBindEntity pushBindEntity = (PushBindEntity) arrayList.get(0);
                        fbt fbt = new fbt(FindDeviceDialogActivity.this.getContext(), "PushBindConfigActivity");
                        int i = FindDeviceDialogActivity.this.mStrategyId == 17 ? 10 : 8;
                        fbt.O000000o("connect_source", i);
                        String uuid = UUID.randomUUID().toString();
                        fbt.O000000o("connect_unique", uuid);
                        hxi.O00000o.O000000o(str, i, uuid);
                        fbt.O000000o("bind_aiot_wifi", (Parcelable) pushBindEntity);
                        fbs.O000000o(fbt);
                    }
                });
                button2 = (Button) findViewById(R.id.button2);
                if (parcelableArrayListExtra != null) {
                }
                button2.setText((int) R.string.ignore);
                button2.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3 */

                    public final void onClick(View view) {
                        if (FindDeviceDialogActivity.this.bleDevice != null) {
                            hxk hxk = hxi.O00000o;
                            String str = FindDeviceDialogActivity.this.bleDevice.model;
                            hxk.f952O000000o.O000000o("ignore_device_ignore", "model", str);
                        }
                        if (FindDeviceDialogActivity.this.mVideoIcon.getVisibility() == 0) {
                            FindDeviceDialogActivity.this.mVideoIcon.pause();
                        }
                        if (FindDeviceDialogActivity.this.bleDevice != null || parcelableArrayListExtra != null || FindDeviceDialogActivity.this.scanResult != null) {
                            final hab hab = new hab();
                            hab.f18684O000000o = new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3.AnonymousClass1 */

                                public final void onClick(View view) {
                                    if (FindDeviceDialogActivity.this.bleDevice != null) {
                                        hxk hxk = hxi.O00000o;
                                        String str = FindDeviceDialogActivity.this.bleDevice.model;
                                        hxk.f952O000000o.O000000o("ignore_device_cancel", "model", str);
                                    }
                                    FindDeviceDialogActivity.this.showDialog();
                                    hab.dismiss();
                                }
                            };
                            hab.O00000Oo = new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass3.AnonymousClass2 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
                                 arg types: [java.lang.String, int]
                                 candidates:
                                  _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
                                  _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
                                  _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
                                public final void onClick(View view) {
                                    Handler handler;
                                    if (FindDeviceDialogActivity.this.bleDevice != null) {
                                        fmy O00000o0 = fmy.O00000o0();
                                        BleDevice bleDevice = FindDeviceDialogActivity.this.bleDevice;
                                        dct.O00000o0("addIgnoreBleDevice");
                                        if (bleDevice == null) {
                                            dct.O00000o0("bleDevice is null");
                                        } else if (TextUtils.isEmpty(bleDevice.mac)) {
                                            dct.O00000o0("mac is empty");
                                        } else {
                                            O00000o0.O00000oo.add(bleDevice.mac);
                                            CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0).edit().putStringSet("ignore_mac_set", O00000o0.O00000oo).apply();
                                            if (DeviceFactory.O00000Oo(bleDevice)) {
                                                String str = bleDevice.O00000Oo().O00000oo;
                                                O00000o0.O0000O0o.add(str.toUpperCase(Locale.ENGLISH));
                                                CommonApplication.getAppContext().getSharedPreferences("mainconnect_sp", 0).edit().putStringSet("ignore_combo_key_set", O00000o0.O0000O0o).apply();
                                                dcp O000000o2 = dcp.O000000o();
                                                String str2 = bleDevice.mac;
                                                dct.O00000oO("setMiuiIgnoreTotal");
                                                if (O000000o2.O00000oO != null) {
                                                    O000000o2.O00000oO.O00000Oo(str2, str);
                                                } else {
                                                    dct.O00000o0("miuiService is null!");
                                                }
                                            } else {
                                                dcp O000000o3 = dcp.O000000o();
                                                String str3 = bleDevice.mac;
                                                if (O000000o3.O00000oO != null) {
                                                    O000000o3.O00000oO.O00000oO(str3);
                                                } else {
                                                    dct.O00000o0("miuiService is null!");
                                                }
                                            }
                                        }
                                        hxi.O00000o.f952O000000o.O000000o("ignore_device_confirm", "model", FindDeviceDialogActivity.this.bleDevice.model);
                                    } else if (parcelableArrayListExtra != null) {
                                        Iterator it = parcelableArrayListExtra.iterator();
                                        while (it.hasNext()) {
                                            PushBindEntity pushBindEntity = (PushBindEntity) it.next();
                                            fmy.O00000o0().O00000o0(DeviceFactory.O00000o0(pushBindEntity.O00000o, pushBindEntity.O00000o0));
                                        }
                                    } else if (FindDeviceDialogActivity.this.scanResult != null) {
                                        DeviceObserveService O000000o4 = DeviceObserveService.O000000o();
                                        String str4 = FindDeviceDialogActivity.this.scanResult.SSID;
                                        if (O000000o4.O00000o0() && (handler = O000000o4.O00000oO) != null) {
                                            handler.sendMessage(O000000o4.O00000oO.obtainMessage(2, str4));
                                        }
                                        if (DeviceFactory.O0000Oo0(FindDeviceDialogActivity.this.scanResult)) {
                                            fmy.O00000o0().O00000o0(DeviceFactory.O00000o0(FindDeviceDialogActivity.this.scanResult.BSSID, FindDeviceDialogActivity.this.scanResult.SSID).toUpperCase(Locale.ENGLISH));
                                        }
                                        if (FindDeviceDialogActivity.this.mShowTips) {
                                            gpv.O00000Oo("find_device_tips", false);
                                            fbs.O000000o(new fbt(FindDeviceDialogActivity.this.getContext(), "DialogTipsActivity"));
                                        }
                                        if (booleanExtra) {
                                            hxi.O00000o.f952O000000o.O000000o("miui_popup_ignore", "model", stringExtra2);
                                        } else {
                                            hxi.O00000o.f952O000000o.O000000o("app_popup_ignore", "model", stringExtra2);
                                        }
                                    }
                                    FindDeviceDialogActivity.this.finish();
                                    FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                                }
                            };
                            FindDeviceDialogActivity.this.hideDialog();
                            if (FindDeviceDialogActivity.this.bleDevice != null) {
                                hxr hxr = hxi.O00000oO;
                                String str2 = FindDeviceDialogActivity.this.bleDevice.model;
                                hxr.f958O000000o.O000000o("ignore_device_pop", "model", str2);
                            }
                            hab.show(FindDeviceDialogActivity.this.getSupportFragmentManager(), "ignore dialog show");
                        }
                    }
                });
                return;
            }
        }
        DeviceObserveService.O000000o().O00000Oo();
        finish();
    }

    private void O000000o(final ImageView imageView, final View view, Uri uri) {
        ImagePipelineFactory.getInstance().getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(uri).build(), null).subscribe(new BaseBitmapDataSubscriber() {
            /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass19 */

            public final void onNewResultImpl(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    final Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                    view.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass19.AnonymousClass1 */

                        public final void run() {
                            imageView.setImageBitmap(createBitmap);
                            FindDeviceDialogActivity findDeviceDialogActivity = FindDeviceDialogActivity.this;
                            View view = view;
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f);
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
                            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass12 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                }
                            });
                            ofFloat.setDuration(300L);
                            ofFloat2.setDuration(300L);
                            ofFloat2.addListener(new AnimatorListenerAdapter() {
                                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass17 */

                                public final void onAnimationEnd(Animator animator) {
                                    if (FindDeviceDialogActivity.this.mPlayVideo) {
                                        FindDeviceDialogActivity.this.mVideoIcon.setVisibility(0);
                                        FindDeviceDialogActivity.this.mVideoIcon.start();
                                    }
                                }
                            });
                            ofFloat.addListener(new AnimatorListenerAdapter(ofFloat2) {
                                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass18 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ ObjectAnimator f10009O000000o;

                                {
                                    this.f10009O000000o = r2;
                                }

                                public final void onAnimationEnd(Animator animator) {
                                    this.f10009O000000o.start();
                                }
                            });
                            ofFloat.start();
                            gsy.O000000o(6, "FindDeviceDialogAct", "start animation");
                        }
                    });
                }
            }

            public final void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
                super.onCancellation(dataSource);
                gsy.O000000o(6, "FindDeviceDialogAct", "cancel download");
            }

            public final void onFailureImpl(DataSource dataSource) {
                gsy.O000000o(6, "FindDeviceDialogAct", "download failed");
            }
        }, CallerThreadExecutor.getInstance());
    }

    public void hideDialog() {
        LinearLayout linearLayout = this.O00000oO;
        if (linearLayout != null && linearLayout.getVisibility() != 8) {
            if (this.mVideoIcon.getVisibility() == 0) {
                this.O0000OoO = true;
                this.mVideoIcon.setVisibility(8);
            }
            this.O00000oO.setVisibility(8);
        }
    }

    public void showDialog() {
        LinearLayout linearLayout = this.O00000oO;
        if (linearLayout != null && linearLayout.getVisibility() != 0) {
            if (this.O0000OoO) {
                findViewById(R.id.icon_static).setVisibility(0);
                this.mHandler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass4 */

                    public final void run() {
                        FindDeviceDialogActivity.this.mVideoIcon.setVisibility(0);
                        FindDeviceDialogActivity.this.mVideoIcon.start();
                    }
                }, 500);
            }
            this.O00000oO.setVisibility(0);
        }
    }

    public void goUpdate() {
        dct.O00000Oo("goUpdate");
        if ("GooglePlay".equals(gfr.O00000o)) {
            dct.O00000Oo("update in GooglePlay");
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            intent.setPackage("com.android.vending");
            if (intent.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto google play");
                startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(268435456);
            intent2.setData(Uri.parse("market://details?id=" + getPackageName()));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto other store");
                startActivity(intent2);
                return;
            }
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName()));
            if (intent2.resolveActivity(getPackageManager()) != null) {
                dct.O00000Oo("goto browser");
                startActivity(intent2);
                return;
            }
            return;
        }
        fbt fbt = new fbt(this, "UpdateActivity");
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    public void checkLoginAndConnect() {
        exo stateNotifier = hna.O00000Oo().getStateNotifier();
        if (stateNotifier == null) {
            gsy.O00000o0(LogType.KUAILIAN, "FindDeviceDialogAct", "appStateNotifier is null");
        } else if (stateNotifier.f15923O000000o == 3) {
            hideDialog();
            this.O0000Oo0 = new gyx();
            this.O0000Oo0.f18604O000000o = new Runnable() {
                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass6 */

                public final void run() {
                    FindDeviceDialogActivity.this.gotoLoginPage();
                }
            };
            dct.O00000o0("show login dialog");
            this.O0000Oo0.show(getSupportFragmentManager(), "show login dialog");
        } else {
            if (DeviceFactory.O00000Oo(this.bleDevice)) {
                fmy.O00000o0();
                if (!fmy.O000000o(this.bleDevice.O00000Oo())) {
                    hideDialog();
                    dct.O00000Oo("showUpdateDialog");
                    ddp ddp = new ddp();
                    ddp.f14510O000000o = new Runnable() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass5 */

                        public final void run() {
                            FindDeviceDialogActivity.this.goUpdate();
                            FindDeviceDialogActivity.this.finish();
                        }
                    };
                    ddp.show(getSupportFragmentManager(), "need update mijia");
                    return;
                }
            }
            changeHomeAndStartConnection(new Runnable() {
                /* class com.xiaomi.smarthome.miui.$$Lambda$FindDeviceDialogActivity$igsWapOi_y9M4Pyx5NwbarTvpqw */

                public final void run() {
                    FindDeviceDialogActivity.this.O000000o();
                }
            });
        }
    }

    public void gotoLoginPage() {
        dct.O00000oO("gotoLoginPage");
        gty.O000000o().startLogin(getContext(), 5, new gtx.O000000o() {
            /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass7 */

            public final void O000000o() {
                dct.O00000o0("onComplete");
                fmy O00000o0 = fmy.O00000o0();
                if (!(O00000o0.O0000OOo == null || fmy.O00000o == null)) {
                    O00000o0.O0000OOo.remove(fmy.O00000o.mac);
                }
                FindDeviceDialogActivity.this.finish();
            }
        });
    }

    public void changeHomeAndStartConnection(final Runnable runnable) {
        gsy.O00000Oo("mainconnect", "changeHomeAndStartConnection()");
        if (ggb.O00000Oo().O0000Oo0() == null) {
            gsy.O00000Oo("mainconnect", "cur home is null, do not change");
            runnable.run();
        } else if (ggb.O00000Oo().O0000Oo0().isOwner()) {
            gsy.O00000Oo("mainconnect", "is owner, do not change");
            runnable.run();
        } else {
            Home home = null;
            Iterator<Home> it = ggb.O00000Oo().O0000OoO.O00000Oo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Home next = it.next();
                if (next.isOwner()) {
                    home = next;
                    break;
                }
            }
            if (home == null) {
                gsy.O00000Oo("mainconnect", "default is null");
                runnable.run();
                return;
            }
            StringBuilder sb = new StringBuilder("cur home is ");
            ggb.O00000Oo();
            sb.append(ggb.O000000o(home));
            gsy.O00000Oo("mainconnect", sb.toString());
            ggb.O00000Oo().O000000o(home.getId(), new fsm() {
                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass8 */

                public final void onSuccess(Object obj) {
                    gsy.O00000Oo("mainconnect", "change home success");
                    runnable.run();
                }

                public final void onFailure(fso fso) {
                    gsy.O00000Oo("mainconnect", "change home failure");
                    runnable.run();
                }
            });
        }
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.miot.BinderParcel]
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
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
     arg types: [java.lang.String, com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult]
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
    /* access modifiers changed from: private */
    public void O000000o() {
        List<Device> O0000Ooo;
        gsy.O00000Oo("mainconnect", "doBleConnect");
        BleDevice bleDevice2 = this.bleDevice;
        if (bleDevice2 == null) {
            return;
        }
        if (this.O00000Oo) {
            fbt fbt = new fbt(this, "MiConnectConfigActivity");
            fbt.O000000o("is_uwb", true);
            fbt.O000000o("handler", (Parcelable) this.O00000o0);
            fbt.O000000o("model", this.f9997O000000o);
            fbt.O000000o("mac", this.bleDevice.mac);
            fbt.O000000o("combo_ble_key", this.bleDevice.O00000Oo() != null ? this.bleDevice.O00000Oo().O00000oo : "");
            fbt.O000000o("ble_result", (Parcelable) new BluetoothSearchResult(gnl.O00000Oo(this.bleDevice.mac), this.bleDevice.rssi, this.bleDevice.scanRecord));
            PluginDeviceInfo pluginInfo = SmartConfigRouterFactory.getCoreApiManager().getPluginInfo(this.f9997O000000o);
            htx O000000o2 = hty.O000000o();
            if (O000000o2 != null) {
                fbt = O000000o2.setQrStep(fbt, pluginInfo.O00000o());
            }
            fbs.O000000o(fbt);
            finish();
            return;
        }
        if (feb.O00000o0(bleDevice2.mac) <= 0) {
            dct.O00000o("product id is invalid! reset");
            if (this.bleDevice.O00000Oo() != null) {
                int i = this.bleDevice.O00000Oo().O00000Oo;
                String str = this.bleDevice.O00000Oo().O00000o;
                dct.O00000o("set product id = ".concat(String.valueOf(i)));
                if (i > 0) {
                    ffr.O00000Oo(this.bleDevice.mac, i);
                }
                if (!TextUtils.isEmpty(str)) {
                    ffr.O0000OOo(this.bleDevice.mac, str);
                }
            }
        }
        if (!"ryeex.bracelet.sake".equals(this.bleDevice.model) || (O0000Ooo = fno.O000000o().O0000Ooo("ryeex.bracelet.sake")) == null || O0000Ooo.size() <= 0) {
            final BleDevice bleDevice3 = this.bleDevice;
            gsy.O00000Oo("mainconnect", "distinguishBleDevice");
            if (foc.O00000Oo(bleDevice3.mac) == 1 || !(bleDevice3.O00000Oo() == null || bleDevice3.O00000Oo().O00000oo == null)) {
                if (!gnl.O000000o() || gnl.O00000Oo()) {
                    configComDeviceConnection(bleDevice3);
                } else {
                    fmd.O000000o(new BleResponse() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass9 */

                        public final void onResponse(int i, Object obj) {
                            FindDeviceDialogActivity.this.configComDeviceConnection(bleDevice3);
                        }
                    });
                }
            } else if (!ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                configBleDeviceConnection(bleDevice3);
            } else if (!sResumed) {
                finish();
            } else {
                MLAlertDialog mLAlertDialog = this.O00000o;
                if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
                    this.O00000o.dismiss();
                }
                this.O00000o = new MLAlertDialog.Builder(getContext()).O000000o(getContext().getString(R.string.license_title)).O000000o(O000000o(bleDevice3)).O00000Oo(getContext().getString(R.string.license_negative_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass11 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        fmy.O00000o0().O000000o(FindDeviceDialogActivity.this.bleDevice);
                        FindDeviceDialogActivity.this.finish();
                        FindDeviceDialogActivity.this.overridePendingTransition(0, 0);
                    }
                }).O000000o(getContext().getString(R.string.license_positive_btn), new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        FindDeviceDialogActivity.this.configBleDeviceConnection(bleDevice3);
                    }
                }).O00000oo();
            }
        } else {
            gsy.O000000o(6, "mainconnect", "this ble device is already bound, cancel connect");
            izb.O000000o(getContext(), getContext().getResources().getText(R.string.already_bind_one_device), 0).show();
            finish();
            overridePendingTransition(0, 0);
        }
    }

    private SpannableStringBuilder O000000o(final BleDevice bleDevice2) {
        String string = getString(R.string.license_content);
        int indexOf = string.indexOf("#start#");
        int indexOf2 = string.indexOf("#end#") - 7;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string.replace("#start#", "").replace("#end#", ""));
        AnonymousClass13 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass13 */

            public final void onClick(View view) {
                fbt fbt = new fbt(FindDeviceDialogActivity.this.getContext(), "GDPRLicenseActivity");
                fbt.O00000Oo(268435456).O000000o("key_model", bleDevice2.model);
                fbs.O000000o(fbt);
            }

            public final void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#0099ff"));
                textPaint.setUnderlineText(false);
            }
        };
        if (indexOf >= 0 && indexOf2 > 0) {
            try {
                spannableStringBuilder.setSpan(r0, indexOf, indexOf2, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }

    public void configComDeviceConnection(BleDevice bleDevice2) {
        gsy.O000000o(4, "mainconnect", "Config Comb device BEGIN.");
        fbt fbt = new fbt(getContext(), "SmartConfigMainActivity");
        fbt.O000000o("connect_source", 7);
        String uuid = UUID.randomUUID().toString();
        fbt.O000000o("connect_unique", uuid);
        hxi.O00000o.O000000o(bleDevice2.model, 7, uuid);
        fbt.O000000o("strategy_id", 13);
        fbt.O000000o("model", bleDevice2.model);
        fbt.O000000o("combo_ble_mac", bleDevice2.mac);
        if (bleDevice2.O00000Oo() != null) {
            fbt.O000000o("combo_ble_key", bleDevice2.O00000Oo().O00000oo);
        }
        fbt.O000000o(600);
        fbs.O000000o(fbt);
        fmy.O00000o0().O000000o(this.bleDevice);
        finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0055  */
    public void configBleDeviceConnection(BleDevice bleDevice2) {
        ArrayList<String> arrayList;
        gsy.O00000Oo("mainconnect", "configBleDeviceConnection");
        if (bleDevice2 instanceof BleDeviceGroup) {
            BleDeviceGroup bleDeviceGroup = (BleDeviceGroup) bleDevice2;
            if (bleDeviceGroup.O0000o00().size() > 0) {
                arrayList = bleDeviceGroup.O0000o00();
                if (!CoreApi.O000000o().O00000o(bleDevice2.model)) {
                    gsy.O00000Oo("mainconnect", "isPluginDevice dispatchFromDeviceChoser");
                    Intent intent = new Intent();
                    fqy.O000000o(intent, 7);
                    hxi.O00000o.O000000o(bleDevice2.model, intent.getIntExtra("connect_source", 0), intent.getStringExtra("connect_unique"));
                    fod.O000000o(getContext(), bleDevice2, intent, arrayList);
                } else {
                    Intent actionByDeviceRenderer = hna.O00000Oo().getActionByDeviceRenderer(bleDevice2, getContext(), null);
                    if (actionByDeviceRenderer != null) {
                        fqy.O000000o(actionByDeviceRenderer, 7);
                        hxi.O00000o.O000000o(bleDevice2.model, actionByDeviceRenderer.getIntExtra("connect_source", 0), actionByDeviceRenderer.getStringExtra("connect_unique"));
                        getContext().startActivity(actionByDeviceRenderer);
                        gsy.O00000Oo("mainconnect", "openIntent is not null");
                    }
                }
                fmy.O00000o0().O000000o(this.bleDevice);
                finish();
                overridePendingTransition(0, 0);
            }
        }
        arrayList = null;
        if (!CoreApi.O000000o().O00000o(bleDevice2.model)) {
        }
        fmy.O00000o0().O000000o(this.bleDevice);
        finish();
        overridePendingTransition(0, 0);
    }

    public void setImage(String str, String str2, final SimpleDraweeView simpleDraweeView, View view) {
        LogType logType = LogType.KUAILIAN;
        gsy.O00000Oo(logType, "FindDeviceDialogAct", "setImage iconStaticUrl:" + str + " videoStaticUrl:" + str2);
        this.mVideoIcon.setZOrderOnTop(true);
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        if (!TextUtils.isEmpty(str2) && audioManager != null && !audioManager.isMusicActive()) {
            simpleDraweeView.setVisibility(0);
            this.mVideoIcon.setVisibility(8);
            this.mPlayVideo = true;
            O000000o(simpleDraweeView, view, Uri.parse(str));
            this.mVideoIcon.setVideoURI(Uri.parse(str2));
            this.mVideoIcon.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass14 */

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return true;
                }
            });
            this.mVideoIcon.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass15 */

                public final void onPrepared(MediaPlayer mediaPlayer) {
                    gsy.O000000o(6, "FindDeviceDialog", "on video prepared");
                    mediaPlayer.setOnInfoListener(new MediaPlayer.OnInfoListener() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass15.AnonymousClass1 */

                        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                            gsy.O000000o(6, "FindDeviceDialog", "on video ".concat(String.valueOf(i)));
                            if (i != 3) {
                                return true;
                            }
                            simpleDraweeView.setVisibility(8);
                            return true;
                        }
                    });
                }
            });
            this.mVideoIcon.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass16 */

                public final void onCompletion(final MediaPlayer mediaPlayer) {
                    FindDeviceDialogActivity.this.mVideoIcon.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.miui.FindDeviceDialogActivity.AnonymousClass16.AnonymousClass1 */

                        public final void run() {
                            try {
                                if (!FindDeviceDialogActivity.this.isFinishing() && !FindDeviceDialogActivity.this.isDestroyed()) {
                                    mediaPlayer.start();
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }, 2000);
                }
            });
        } else if (!TextUtils.isEmpty(str)) {
            this.mVideoIcon.setVisibility(8);
            O000000o(simpleDraweeView, view, Uri.parse(str));
        } else {
            this.mVideoIcon.setVisibility(8);
            simpleDraweeView.setImageURI(gqd.O000000o((int) R.drawable.defaule_icon_default_nor));
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpv.O00000Oo(java.lang.String, boolean):void
     arg types: [java.lang.String, int]
     candidates:
      _m_j.gpv.O00000Oo(android.content.Context, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, java.lang.String):void
      _m_j.gpv.O00000Oo(java.lang.String, boolean):void */
    public void onBackPressed() {
        if (this.mShowTips) {
            gpv.O00000Oo("find_device_tips", false);
            fbs.O000000o(new fbt(getContext(), "DialogTipsActivity"));
        }
        if (this.bleDevice != null) {
            fmy.O00000o0().O000000o(this.bleDevice);
        }
        ScanResult scanResult2 = this.scanResult;
        if (scanResult2 != null && DeviceFactory.O0000Oo0(scanResult2)) {
            fmy.O00000o0().O000000o(DeviceFactory.O00000o0(this.scanResult.BSSID, this.scanResult.SSID));
        }
        finish();
        overridePendingTransition(0, 0);
    }

    public void onPause() {
        super.onPause();
        sResumed = false;
        gsy.O000000o(6, "FindDeviceDialog", "onPause");
        if (this.bleDevice != null) {
            fmy.O00000o0().O000000o(this.bleDevice);
        }
        CommonApplication.getGlobalHandler().postDelayed(this.O0000Oo, 1000);
    }

    public void onResume() {
        super.onResume();
        sResumed = true;
        gsy.O000000o(6, "FindDeviceDialog", "onResume");
        CommonApplication.getGlobalHandler().removeCallbacks(this.O0000Oo);
    }
}
