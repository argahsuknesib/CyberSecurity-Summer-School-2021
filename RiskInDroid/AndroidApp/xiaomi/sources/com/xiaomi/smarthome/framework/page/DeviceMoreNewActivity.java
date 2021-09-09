package com.xiaomi.smarthome.framework.page;

import _m_j.fno;
import _m_j.fpo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfb;
import _m_j.gnk;
import _m_j.gnn;
import _m_j.gpn;
import _m_j.gwg;
import _m_j.hor;
import _m_j.hsw;
import _m_j.hyv;
import _m_j.hyy;
import _m_j.hzf;
import _m_j.izb;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeController;
import com.xiaomi.smarthome.bluetooth.ISlideBtnViewer;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.BleMeshDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceMoreNewActivity extends BaseActivity {
    public static boolean isStarting = false;

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f7716O000000o;
    View O00000Oo;
    View O00000o = null;
    protected Device O00000o0;
    View O00000oO = null;
    boolean O00000oo;
    ListView O0000O0o;
    BaseAdapter O0000OOo;
    LayoutInflater O0000Oo;
    ArrayList<IXmPluginHostActivity.MenuItemBase> O0000Oo0 = new ArrayList<>();
    boolean O0000OoO;
    boolean O0000Ooo = false;
    Intent O0000o0 = new Intent();
    boolean O0000o00 = false;
    private final ISlideBtnViewer.Stub O0000o0O = new ISlideBtnViewer.Stub() {
        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass10 */

        public void setChecked(final String str, final boolean z) throws RemoteException {
            DeviceMoreNewActivity.this.mHandler.post(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass10.AnonymousClass1 */

                public final void run() {
                    Iterator<IXmPluginHostActivity.MenuItemBase> it = DeviceMoreNewActivity.this.O0000Oo0.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        IXmPluginHostActivity.MenuItemBase next = it.next();
                        if (next instanceof IXmPluginHostActivity.SlideBtnMenuItem) {
                            IXmPluginHostActivity.SlideBtnMenuItem slideBtnMenuItem = (IXmPluginHostActivity.SlideBtnMenuItem) next;
                            gnk.O00000o0(String.format(">>> item %s, name %s", slideBtnMenuItem.name, str));
                            if (slideBtnMenuItem.name.equals(str)) {
                                slideBtnMenuItem.isOn = z;
                                break;
                            }
                        }
                    }
                    DeviceMoreNewActivity.this.O0000OOo.notifyDataSetChanged();
                }
            });
        }
    };

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
    public void onCreate(Bundle bundle) {
        Intent cloudStorageMenuIntent;
        ArrayList parcelableArrayListExtra;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        this.f7716O000000o = this;
        this.O00000oo = false;
        setContentView((int) R.layout.device_more_activity_new);
        this.O0000Oo = LayoutInflater.from(this);
        this.O00000oO = findViewById(R.id.device_more_frame);
        this.O00000o = findViewById(R.id.device_more);
        this.O00000o.setVisibility(4);
        if (!hyy.O000000o(getIntent())) {
            gwg.O000000o(hzf.O000000o(CommonApplication.getAppContext()), this.O00000o);
        }
        final String stringExtra = getIntent().getStringExtra("did");
        this.O00000o0 = fno.O000000o().O000000o(stringExtra);
        if (this.O00000o0 == null) {
            finish();
            return;
        }
        this.O0000OoO = getIntent().getBooleanExtra("auto_dissmiss", true);
        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceMoreNewActivity.this.onBackPressed();
            }
        });
        this.O00000Oo = findViewById(R.id.empty);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass2 */

            public final void onClick(View view) {
                DeviceMoreNewActivity.this.onBackPressed();
            }
        });
        Intent intent = getIntent();
        if (intent.hasExtra("menusItems") && (parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("menusItems")) != null && parcelableArrayListExtra.size() > 0) {
            this.O0000Oo0.addAll(parcelableArrayListExtra);
        }
        if (intent.getBooleanExtra("useDefaultMenus", true)) {
            if (intent.getBooleanExtra("scence_enable", true) && this.O00000o0.isOwner()) {
                IXmPluginHostActivity.IntentMenuItem intentMenuItem = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem.name = getString(R.string.device_more_activity_scence);
                intentMenuItem.intent = new Intent(this, hor.O000000o().getDeviceSceneActivity());
                intentMenuItem.intent.putExtra("device_id", stringExtra);
                this.O0000Oo0.add(intentMenuItem);
            }
            if (intent.getBooleanExtra("share_enable", true) && this.O00000o0.isOwner() && !this.O00000o0.isSubDevice() && DeviceRouterFactory.getDeviceWrapper().canBeShared(this.O00000o0)) {
                IXmPluginHostActivity.IntentMenuItem intentMenuItem2 = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem2.name = getString(R.string.device_more_share);
                intentMenuItem2.intent = new Intent(this, hsw.O000000o().getShareDeviceActivity());
                intentMenuItem2.intent.putExtra("user_id", CoreApi.O000000o().O0000o0());
                intentMenuItem2.intent.putExtra("did", this.O00000o0.did);
                this.O0000Oo0.add(intentMenuItem2);
            }
            if (CameraRouterFactory.getCameraCloudApi().isSupportCloudStorageWithSettingServer() && intent.getBooleanExtra("cloud_storage", false) && !this.O00000o0.isShared() && (cloudStorageMenuIntent = CameraRouterFactory.getCameraCloudApi().getCloudStorageMenuIntent(this, this.O00000o0.did)) != null) {
                IXmPluginHostActivity.IntentMenuItem intentMenuItem3 = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem3.name = getString(R.string.cs_service_setting);
                intentMenuItem3.intent = cloudStorageMenuIntent;
                intentMenuItem3.intent.putExtra("did", stringExtra);
                this.O0000Oo0.add(intentMenuItem3);
            }
            if (intent.getBooleanExtra("common_setting_enable", true)) {
                this.O0000o00 = true;
                IXmPluginHostActivity.IntentMenuItem intentMenuItem4 = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem4.name = getString(R.string.device_more_activity_common_setting);
                intentMenuItem4.intent = new Intent(this, DeviceMoreActivity.class);
                intentMenuItem4.intent.putExtra("did", stringExtra);
                intentMenuItem4.intent.putExtra("title_name", intentMenuItem4.name);
                intentMenuItem4.intent.putExtra("useDefaultMenus", true);
                intentMenuItem4.intent.putExtra("security_setting_enable", intent.getBooleanExtra("security_setting_enable", false));
                Intent intent2 = (Intent) intent.getParcelableExtra("commonSettingParams");
                if (intent2 == null) {
                    intent2 = new Intent();
                }
                intent2.putExtra("share_enable", false);
                intentMenuItem4.intent.putExtras(intent2);
                Iterator<IXmPluginHostActivity.MenuItemBase> it = this.O0000Oo0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    IXmPluginHostActivity.MenuItemBase next = it.next();
                    if (next instanceof IXmPluginHostActivity.BleMenuItem) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(next);
                        intentMenuItem4.intent.putExtra("menusItems", arrayList);
                        break;
                    }
                }
                this.O0000Oo0.add(intentMenuItem4);
            }
            if (intent.getBooleanExtra("help_feedback_enable", true)) {
                IXmPluginHostActivity.IntentMenuItem intentMenuItem5 = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem5.name = getString(R.string.device_more_activity_help_feedback);
                if (hyv.O000000o().createFeedbackCommonProblemActivity(this) != null) {
                    intentMenuItem5.intent = hyv.O000000o().createFeedbackCommonProblemActivity(this);
                    intentMenuItem5.intent.putExtra("did", stringExtra);
                    intentMenuItem5.intent.putExtra("extra_model", this.O00000o0.model);
                }
                this.O0000Oo0.add(intentMenuItem5);
            }
        }
        Iterator<IXmPluginHostActivity.MenuItemBase> it2 = this.O0000Oo0.iterator();
        while (it2.hasNext()) {
            if (it2.next() instanceof IXmPluginHostActivity.BleMenuItem) {
                it2.remove();
            }
        }
        this.O0000O0o = (ListView) findViewById(R.id.select_dialog_listview);
        this.O0000O0o.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass3 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.O0000OOo = new BaseAdapter() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4 */

            public final long getItemId(int i) {
                return (long) i;
            }

            public final int getViewTypeCount() {
                return 2;
            }

            public final int getCount() {
                return DeviceMoreNewActivity.this.O0000Oo0.size();
            }

            public final Object getItem(int i) {
                return DeviceMoreNewActivity.this.O0000Oo0.get(i);
            }

            public final int getItemViewType(int i) {
                return DeviceMoreNewActivity.this.O0000Oo0.get(i) instanceof IXmPluginHostActivity.SlideBtnMenuItem ? 0 : 1;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e2, code lost:
                if (r1.shouldShowBleGatewayRedPoint(r1.O00000o0) != false) goto L_0x00e4;
             */
            public final View getView(int i, View view, ViewGroup viewGroup) {
                IXmPluginHostActivity.MenuItemBase menuItemBase = DeviceMoreNewActivity.this.O0000Oo0.get(i);
                if (menuItemBase instanceof IXmPluginHostActivity.SlideBtnMenuItem) {
                    final IXmPluginHostActivity.SlideBtnMenuItem slideBtnMenuItem = (IXmPluginHostActivity.SlideBtnMenuItem) menuItemBase;
                    if (view == null) {
                        view = DeviceMoreNewActivity.this.O0000Oo.inflate((int) R.layout.menu_dialog_slidebtn_item, (ViewGroup) null);
                    }
                    TextView textView = (TextView) view.findViewById(R.id.text1);
                    textView.setText(slideBtnMenuItem.name);
                    final SwitchButton switchButton = (SwitchButton) view.findViewById(R.id.slide_btn);
                    if (!(DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLUETOOTH || DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLE_MESH || DeviceMoreNewActivity.this.O00000o0.isOnline)) {
                        switchButton.setEnabled(false);
                        textView.setTextColor(DeviceMoreNewActivity.this.getResources().getColor(R.color.mj_color_gray_lighter));
                    }
                    switchButton.setOnTouchListener(new View.OnTouchListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass1 */

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() != 0) {
                                return false;
                            }
                            slideBtnMenuItem.isClicked = true;
                            return false;
                        }
                    });
                    if (DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLUETOOTH || DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLE_MESH) {
                        switchButton.setOnCheckedChangeListener(new O000000o(slideBtnMenuItem));
                    } else {
                        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass2 */

                            public final void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                                if (slideBtnMenuItem.isClicked) {
                                    switchButton.setEnabled(false);
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("id", (int) ((Math.random() * 100000.0d) + 100000.0d));
                                        if (z) {
                                            jSONObject.put("method", slideBtnMenuItem.onMethod);
                                            jSONObject.put("params", new JSONArray(slideBtnMenuItem.onParams));
                                        } else {
                                            jSONObject.put("method", slideBtnMenuItem.offMethod);
                                            jSONObject.put("params", new JSONArray(slideBtnMenuItem.offParams));
                                        }
                                    } catch (JSONException unused) {
                                    }
                                    CoreApi.O000000o().O000000o(DeviceMoreNewActivity.this.O00000o0.did, DeviceMoreNewActivity.this.O00000o0.token, jSONObject.toString(), new fsm<JSONObject, fso>() {
                                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass2.AnonymousClass1 */

                                        public final void onFailure(fso fso) {
                                            switchButton.setEnabled(true);
                                            slideBtnMenuItem.isClicked = false;
                                            switchButton.setChecked(true ^ switchButton.isChecked());
                                            izb.O000000o(DeviceMoreNewActivity.this, (int) R.string.device_more_activity_failed, 0).show();
                                        }

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            switchButton.setEnabled(true);
                                            DeviceMoreNewActivity.this.O0000o0.putExtra(slideBtnMenuItem.name, z);
                                        }
                                    });
                                }
                            }
                        });
                    }
                    switchButton.setChecked(slideBtnMenuItem.isOn);
                } else if (menuItemBase instanceof IXmPluginHostActivity.IntentMenuItem) {
                    final IXmPluginHostActivity.IntentMenuItem intentMenuItem = (IXmPluginHostActivity.IntentMenuItem) menuItemBase;
                    if (view == null) {
                        view = DeviceMoreNewActivity.this.O0000Oo.inflate((int) R.layout.menu_dialog_item, (ViewGroup) null);
                    }
                    ((TextView) view.findViewById(R.id.text1)).setText(intentMenuItem.name);
                    ImageView imageView = (ImageView) view.findViewById(R.id.red_point);
                    imageView.setVisibility(8);
                    if (intentMenuItem.intent != null) {
                        view.setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass3 */

                            public final void onClick(View view) {
                                IXmPluginHostActivity.IntentMenuItem intentMenuItem = intentMenuItem;
                                if (!(intentMenuItem == null || intentMenuItem.intent == null || intentMenuItem.intent.getComponent() == null || intentMenuItem.intent.getComponent().getClassName() == null)) {
                                    CameraRouterFactory.getCameraManagerApi().addDeviceMoreMenuEvent(intentMenuItem.intent.getComponent().getClassName());
                                }
                                if (intentMenuItem.goBuyVip) {
                                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(DeviceMoreNewActivity.this);
                                    builder.O00000Oo((int) R.string.face_need_open_cloud);
                                    builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass3.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                        }
                                    });
                                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass3.AnonymousClass2 */

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.dismiss();
                                            CameraRouterFactory.getCameraCloudApi().openCloudVideoBuyPage(DeviceMoreNewActivity.this, stringExtra);
                                        }
                                    });
                                    builder.O00000oo();
                                    return;
                                }
                                DeviceMoreNewActivity.this.startActivityForResult(intentMenuItem.intent, 100);
                            }
                        });
                        if (!DeviceMoreNewActivity.this.O0000Ooo) {
                            DeviceMoreNewActivity deviceMoreNewActivity = DeviceMoreNewActivity.this;
                        }
                        if (intentMenuItem.intent.getComponent().getClassName().equals(DeviceMoreActivity.class.getName())) {
                            imageView.setVisibility(0);
                        }
                    }
                } else if (menuItemBase instanceof IXmPluginHostActivity.StringMenuItem) {
                    final IXmPluginHostActivity.StringMenuItem stringMenuItem = (IXmPluginHostActivity.StringMenuItem) menuItemBase;
                    if (view == null) {
                        view = DeviceMoreNewActivity.this.O0000Oo.inflate((int) R.layout.menu_dialog_item, (ViewGroup) null);
                    }
                    ((ImageView) view.findViewById(R.id.red_point)).setVisibility(8);
                    ((TextView) view.findViewById(R.id.text1)).setText(stringMenuItem.name);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass4.AnonymousClass4 */

                        public final void onClick(View view) {
                            Intent intent = new Intent();
                            intent.putExtra("menu", stringMenuItem.name);
                            intent.putExtras(DeviceMoreNewActivity.this.O0000o0);
                            DeviceMoreNewActivity.this.setResult(-1, intent);
                            DeviceMoreNewActivity.this.finishPage();
                        }
                    });
                } else if (menuItemBase instanceof IXmPluginHostActivity.InfoMenuItem) {
                    IXmPluginHostActivity.InfoMenuItem infoMenuItem = (IXmPluginHostActivity.InfoMenuItem) menuItemBase;
                    if (view == null) {
                        view = DeviceMoreNewActivity.this.O0000Oo.inflate((int) R.layout.menu_dialog_item, (ViewGroup) null);
                    }
                    ((ImageView) view.findViewById(R.id.red_point)).setVisibility(8);
                    ((TextView) view.findViewById(R.id.text1)).setText(infoMenuItem.name);
                }
                return view;
            }
        };
        this.O0000O0o.setAdapter((ListAdapter) this.O0000OOo);
        O000000o(true);
    }

    public boolean shouldShowBleGatewayRedPoint(Device device) {
        if (device == null) {
            return false;
        }
        Intent intent = (Intent) getIntent().getParcelableExtra("commonSettingParams");
        return (intent == null || intent.getBooleanExtra("bluetooth_gateway", true)) && DeviceMoreActivity.isSupportBleGateway(device) && DeviceMoreActivity.getBleGatewayRedPointStatus(device);
    }

    public void onResume() {
        super.onResume();
        Intent intent = (Intent) getIntent().getParcelableExtra("commonSettingParams");
        boolean z = true;
        if (!(intent != null ? intent.getBooleanExtra("firmware_enable", true) : true) || !this.O00000o0.isOwner() || this.O00000o0.isSubDevice() || this.O00000o0.pid == Device.PID_VIRTUAL_DEVICE) {
            z = false;
        }
        if (z) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass5 */

                public final void run() {
                    if (DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLUETOOTH || DeviceMoreNewActivity.this.O00000o0.pid == Device.PID_BLE_MESH) {
                        DeviceMoreNewActivity.this.checkBleFirmwareVersion();
                    } else if (DeviceMoreNewActivity.this.O00000o0.pid != Device.PID_VIRTUAL_DEVICE) {
                        DeviceMoreNewActivity.this.O000000o();
                    }
                }
            }, 100);
        }
    }

    public void checkBleFirmwareVersion() {
        Intent intent = getIntent();
        IBleUpgradeController iBleUpgradeController = null;
        ArrayList parcelableArrayListExtra = intent.hasExtra("menusItems") ? intent.getParcelableArrayListExtra("menusItems") : null;
        if (!gpn.O000000o(parcelableArrayListExtra)) {
            Iterator it = parcelableArrayListExtra.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IXmPluginHostActivity.MenuItemBase menuItemBase = (IXmPluginHostActivity.MenuItemBase) it.next();
                if (menuItemBase instanceof IXmPluginHostActivity.BleMenuItem) {
                    IXmPluginHostActivity.BleMenuItem bleMenuItem = (IXmPluginHostActivity.BleMenuItem) menuItemBase;
                    if ("key_firmware_click".equals(bleMenuItem.key)) {
                        iBleUpgradeController = bleMenuItem.getBleUpgrader();
                        break;
                    }
                }
            }
            if (iBleUpgradeController != null) {
                try {
                    String currentVersion = iBleUpgradeController.getCurrentVersion();
                    if (TextUtils.isEmpty(currentVersion) && (this.O00000o0 instanceof BleMeshDevice)) {
                        currentVersion = ((BleMeshDevice) this.O00000o0).mFwVersion;
                    }
                    this.O0000Ooo = fpo.O000000o(iBleUpgradeController.getLatestVersion(), currentVersion) > 0;
                } catch (Exception e) {
                    gnk.O00000Oo(gnk.O00000Oo(e));
                }
            }
            this.O0000OOo.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O0000o00 && this.O00000o0.isOwner()) {
            gfb.O000000o().O00000Oo(this, this.O00000o0.did, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass6 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    DeviceMoreNewActivity.this.O0000Ooo = !jSONObject.optBoolean("updating") && !jSONObject.optBoolean("isLatest");
                    DeviceMoreNewActivity.this.O0000OOo.notifyDataSetChanged();
                }
            });
        }
    }

    public void onDestroy() {
        O000000o(false);
        super.onDestroy();
    }

    public void onBackPressed() {
        setResult(0, this.O0000o0);
        finishPage();
    }

    public void finishFinal() {
        this.O00000oo = true;
        finish();
        overridePendingTransition(0, 0);
    }

    public void finishPage() {
        this.O00000oo = true;
        if (gnn.f18048O000000o) {
            ObjectAnimator ofObject = ObjectAnimator.ofObject(this.O00000oO, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)));
            ofObject.setDuration(300L);
            ofObject.start();
        } else {
            this.O00000oO.setBackgroundColor(getResources().getColor(R.color.mj_color_black_00_transparent));
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_out_top);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass7 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                DeviceMoreNewActivity.this.finishFinal();
            }
        });
        this.O00000o.startAnimation(loadAnimation);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.O00000oo && !this.O00000o.isShown()) {
            if (gnn.f18048O000000o) {
                ObjectAnimator ofObject = ObjectAnimator.ofObject(this.O00000oO, "backgroundColor", new ArgbEvaluator(), Integer.valueOf(getResources().getColor(R.color.mj_color_black_00_transparent)), Integer.valueOf(getResources().getColor(R.color.mj_color_black_30_transparent)));
                ofObject.setDuration(300L);
                ofObject.start();
            } else {
                this.O00000oO.setBackgroundColor(getResources().getColor(R.color.mj_color_black_30_transparent));
            }
            this.O00000o.setVisibility(0);
            this.O00000o.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_in_top));
        }
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        if (!isStarting) {
            isStarting = true;
            Intent intent2 = new Intent();
            intent2.setClass(activity, DeviceMoreNewActivity.class);
            intent2.putExtra("did", str);
            if (arrayList != null) {
                intent2.putParcelableArrayListExtra("menusItems", arrayList);
            }
            intent2.putExtra("useDefaultMenus", z);
            if (intent != null) {
                intent2.putExtras(intent);
            }
            activity.startActivityForResult(intent2, i);
            new Handler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass8 */

                public final void run() {
                    DeviceMoreNewActivity.isStarting = false;
                }
            }, 500);
        }
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, Intent intent2) {
        if (!isStarting) {
            isStarting = true;
            Intent intent3 = new Intent();
            intent3.setClass(activity, DeviceMoreNewActivity.class);
            intent3.putExtra("did", str);
            if (arrayList != null) {
                intent3.putParcelableArrayListExtra("menusItems", arrayList);
            }
            intent3.putExtra("useDefaultMenus", z);
            if (intent != null) {
                intent3.putExtras(intent);
            }
            if (intent2 != null) {
                intent3.putExtra("commonSettingParams", intent2);
            }
            activity.startActivityForResult(intent3, i);
            new Handler().postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreNewActivity.AnonymousClass9 */

                public final void run() {
                    DeviceMoreNewActivity.isStarting = false;
                }
            }, 500);
        }
    }

    private void O000000o(boolean z) {
        if (!gpn.O000000o(this.O0000Oo0)) {
            Iterator<IXmPluginHostActivity.MenuItemBase> it = this.O0000Oo0.iterator();
            while (it.hasNext()) {
                IXmPluginHostActivity.MenuItemBase next = it.next();
                if (next instanceof IXmPluginHostActivity.SlideBtnMenuItem) {
                    IXmPluginHostActivity.SlideBtnMenuItem slideBtnMenuItem = (IXmPluginHostActivity.SlideBtnMenuItem) next;
                    if (slideBtnMenuItem.controller != null) {
                        if (z) {
                            try {
                                slideBtnMenuItem.controller.attachSlideBtnViewer(this.O0000o0O);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            slideBtnMenuItem.controller.detachSlideBtnViewer();
                        }
                    }
                }
            }
        }
    }

    class O000000o implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: O000000o  reason: collision with root package name */
        IXmPluginHostActivity.SlideBtnMenuItem f7732O000000o;

        O000000o(IXmPluginHostActivity.SlideBtnMenuItem slideBtnMenuItem) {
            this.f7732O000000o = slideBtnMenuItem;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (this.f7732O000000o.controller != null) {
                try {
                    this.f7732O000000o.isOn = z;
                    this.f7732O000000o.controller.onCheckedChanged(this.f7732O000000o.name, z);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("finish", false)) {
            setResult(-1, intent);
            finish();
        } else if (this.O0000OoO) {
            finish();
        }
    }
}
