package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fqx;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fvx;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gjh;
import _m_j.gjk;
import _m_j.goy;
import _m_j.gpy;
import _m_j.grr;
import _m_j.gsy;
import _m_j.gty;
import _m_j.gus;
import _m_j.gva;
import _m_j.gwc;
import _m_j.gwh;
import _m_j.gyh;
import _m_j.hsq;
import _m_j.hxi;
import _m_j.hzf;
import _m_j.hzg;
import _m_j.hzj;
import _m_j.hzk;
import _m_j.ixe;
import _m_j.izb;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.auth.AuthManagerListActivity;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthMasterListActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.SelectServerEnvActivity;
import com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity;
import com.xiaomi.smarthome.framework.page.serverenv.ServerEnvHelper$1;
import com.xiaomi.smarthome.framework.webview.SmartHomeWebActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.miio.page.AutoDiscoverySettingActivity;
import com.xiaomi.smarthome.miio.page.deviceophistory.DeviceOpHistoryListActivity;
import com.xiaomi.smarthome.notificationquickop.QuickOpDeviceSettingActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AboutActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f9556O000000o;
    View O00000Oo;
    O00000Oo O00000o;
    View O00000o0;
    TextView O00000oO;
    private View O00000oo;
    private TextView O0000O0o;
    private Disposable O0000OOo;
    public Dialog mDialog;
    public PopupWindow upgradeWindow;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o() throws Exception {
    }

    static class O000000o implements hsq {

        /* renamed from: O000000o  reason: collision with root package name */
        private final WeakReference<AboutActivity> f9589O000000o;

        public final void O00000Oo() {
        }

        /* synthetic */ O000000o(AboutActivity aboutActivity, byte b) {
            this(aboutActivity);
        }

        private O000000o(AboutActivity aboutActivity) {
            this.f9589O000000o = new WeakReference<>(aboutActivity);
        }

        public final void O000000o() {
            AboutActivity aboutActivity;
            WeakReference<AboutActivity> weakReference = this.f9589O000000o;
            if (weakReference != null && (aboutActivity = weakReference.get()) != null && aboutActivity.isValid()) {
                aboutActivity.refreshRegion();
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0479  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x04ac  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x04e4  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x04fa  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0536  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0554  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x05b4  */
    public void onCreate(Bundle bundle) {
        Locale locale;
        String str;
        ArrayList arrayList;
        Map<String, Device> O0000O0o2;
        Map<String, Device> O00000Oo2;
        boolean z;
        ListItemView listItemView;
        PluginDeviceInfo O00000oO2;
        super.onCreate(bundle);
        setContentView((int) R.layout.about_layout);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AboutActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.device_more_activity_setting);
        View findViewById = findViewById(R.id.region);
        int i = 0;
        findViewById.setVisibility(0);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass12 */

            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("set_server_entry", new Object[0]);
                gjk.O000000o(ServiceApplication.getAppContext(), 2, new O000000o(AboutActivity.this, (byte) 0), AboutActivity.class.getSimpleName());
            }
        });
        refreshRegion();
        findViewById(R.id.check_update_new).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass23 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(AboutActivity.this, "UpdateActivity"));
                new Thread(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass23.AnonymousClass1 */

                    public final void run() {
                        gyh.O000000o().setAllModelUpdateIgnore();
                        gyh.O00000Oo().ignoreThisNewVersion();
                    }
                }).start();
            }
        });
        View findViewById2 = findViewById(R.id.click_sound);
        findViewById2.setVisibility(0);
        final SwitchButton switchButton = (SwitchButton) findViewById(R.id.lite_click_sound_btn);
        switchButton.setOnTouchEnable(false);
        boolean z2 = true;
        switchButton.setChecked(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_click_sound", true));
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass25 */

            public final void onClick(View view) {
                SwitchButton switchButton = switchButton;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) switchButton);
                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_click_sound", switchButton.isChecked());
            }
        });
        View findViewById3 = findViewById(R.id.click_miui_auto_discovery_item);
        findViewById3.setVisibility(0);
        findViewById3.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass26 */

            public final void onClick(View view) {
                AboutActivity.this.startActivity(new Intent(AboutActivity.this.getContext(), AutoDiscoverySettingActivity.class));
            }
        });
        View findViewById4 = findViewById(R.id.auto_connect_setting);
        findViewById4.setVisibility(0);
        final SwitchButton switchButton2 = (SwitchButton) findViewById(R.id.auto_connect_toggle);
        switchButton2.setOnTouchEnable(false);
        switchButton2.setChecked(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "auto_connect_new", false));
        findViewById4.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass27 */

            public final void onClick(View view) {
                SwitchButton switchButton = switchButton2;
                switchButton.setChecked(!switchButton.isChecked());
                hzf.O000000o((CompoundButton) switchButton2);
                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_lite_config", "auto_connect_new", switchButton2.isChecked());
            }
        });
        if (!goy.O00000Oo()) {
            findViewById4.setVisibility(8);
        }
        this.O0000O0o = (TextView) findViewById(R.id.device_card_shortcut_info);
        this.O0000O0o.setText(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", false) ? R.string.mj_open : R.string.mj_close);
        this.O00000oo = findViewById(R.id.device_card_shortcut);
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            this.O00000oo.setVisibility(0);
            this.O00000oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass28 */

                public final void onClick(View view) {
                    AboutActivity.this.startActivityForResult(new Intent(AboutActivity.this, DeviceCardSettingActivity.class), 200);
                    hxi.O00000o.f952O000000o.O000000o("set_card_entry", new Object[0]);
                }
            });
        } else {
            this.O00000oo.setVisibility(8);
        }
        View findViewById5 = findViewById(R.id.developer);
        if (gfr.O0000OOo || gfr.O0000Oo || gfr.O0000o0o) {
            findViewById5.setVisibility(0);
            findViewById5.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass29 */

                public final void onClick(View view) {
                    AboutActivity.this.startActivity(new Intent(AboutActivity.this, DeveloperSettingActivity.class));
                }
            });
        } else {
            findViewById5.setVisibility(8);
        }
        View findViewById6 = findViewById(R.id.server_env);
        if (gfr.O0000OOo || gfr.O0000Oo) {
            findViewById6.setVisibility(0);
            findViewById6.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.$$Lambda$AboutActivity$vAC5a6RV5aoawOObtD4OB1Hbho0 */

                public final void onClick(View view) {
                    AboutActivity.this.O000000o(view);
                }
            });
        } else {
            findViewById6.setVisibility(8);
        }
        refreshServerEnv();
        findViewById(R.id.user_liscense_text).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass2 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(AboutActivity.this, "/userCenter/LicenseChooseActivity"));
            }
        });
        findViewById(R.id.user_liscense_text).setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass3 */

            public final boolean onLongClick(View view) {
                if (!gfr.O0000o0o) {
                    return false;
                }
                AboutActivity aboutActivity = AboutActivity.this;
                grr.O000000o();
                izb.O000000o(aboutActivity, grr.O000000o(ServiceApplication.getAppContext(), ftn.O0000O0o(ServiceApplication.getAppContext())), 1).show();
                return true;
            }
        });
        if (ggb.O00000Oo().O00000oO()) {
            findViewById(R.id.device_tag).setVisibility(8);
            findViewById(R.id.manage_home_container).setVisibility(0);
            findViewById(R.id.manage_home_container).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    if (CoreApi.O000000o().O0000Ooo()) {
                        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                        if (list == null || list.size() <= 1) {
                            fbs.O000000o(new fbt(AboutActivity.this, "HomeEditorActivity"));
                            return;
                        }
                        fbt fbt = new fbt(AboutActivity.this, "MultiHomeManagerActivity");
                        fbt.O000000o("from", 2);
                        fbs.O000000o(fbt);
                        return;
                    }
                    if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                        AboutActivity.this.mDialog.dismiss();
                    }
                    AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
                }
            });
        } else {
            findViewById(R.id.device_tag).setVisibility(0);
            findViewById(R.id.room_manage_container).setVisibility(8);
            findViewById(R.id.manage_home_container).setVisibility(8);
            findViewById(R.id.device_tag).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    if (CoreApi.O000000o().O0000Ooo()) {
                        fbs.O000000o(new fbt(AboutActivity.this, "DeviceTagManagerActivity"));
                        return;
                    }
                    if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                        AboutActivity.this.mDialog.dismiss();
                    }
                    AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
                }
            });
        }
        ftn.O00000Oo(CoreApi.O000000o().O0000ooO());
        findViewById(R.id.client_all_columns).setVisibility(8);
        View findViewById7 = findViewById(R.id.face_privacy);
        findViewById7.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass6 */

            public final void onClick(View view) {
                FacePrivacyManagerActivity.O000000o o000000o = FacePrivacyManagerActivity.Companion;
                Context context = AboutActivity.this.getContext();
                ixe.O00000o(context, "context");
                Intent intent = new Intent(context, FacePrivacyManagerActivity.class);
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        });
        findViewById7.setVisibility(ftn.O00000oO(this) ? 8 : 0);
        findViewById(R.id.message_setting_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass7 */

            public final void onClick(View view) {
                if (CoreApi.O000000o().O0000Ooo()) {
                    fbs.O000000o(new fbt(AboutActivity.this, "MessageCenterSettingActivity"));
                    return;
                }
                if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                    AboutActivity.this.mDialog.dismiss();
                }
                AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
            }
        });
        findViewById(R.id.unit_setting_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass8 */

            public final void onClick(View view) {
                if (CoreApi.O000000o().O0000Ooo()) {
                    fbs.O000000o(new fbt(AboutActivity.this, "UnitSettingActivity"));
                    return;
                }
                if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                    AboutActivity.this.mDialog.dismiss();
                }
                AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
            }
        });
        this.O00000Oo = findViewById(R.id.security_setting_dot);
        gva.O000000o().setRedPointView("loc_pincode_new", new gus() {
            /* class com.xiaomi.smarthome.miio.activity.$$Lambda$AboutActivity$9eAhAT7jxHi88B4ch7ytMJPCtA */

            public final void showRedPoint(boolean z) {
                AboutActivity.this.O000000o(z);
            }
        });
        findViewById(R.id.security_setting_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass9 */

            public final void onClick(View view) {
                if (CoreApi.O000000o().O0000Ooo()) {
                    for (Map.Entry<String, Device> value : fno.O000000o().O00000oO().entrySet()) {
                        Device device = (Device) value.getValue();
                        if (device.isOwner() && ggb.O00000Oo().O0000o0(device.did) != null && !fqx.O000000o(device.model, device.version) && !(device instanceof CameraDevice) && (device.pinCodeType & 1) == 1) {
                            LogType logType = LogType.GENERAL;
                            gsy.O00000o0(logType, "pincodeType", device.name + ":   " + device.pinCodeType);
                            hxi.O00000o.O000000o((Integer) null);
                            new MLAlertDialog.Builder(AboutActivity.this).O00000Oo((int) R.string.device_more_security_new_feature_hint).O000000o((int) R.string.dialog_btn_allow, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass9.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    fbs.O000000o(new fbt(AboutActivity.this, "DevicePinVerifyClearActivity"));
                                    hxi.O00000o.O000000o((Integer) 1);
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, $$Lambda$AboutActivity$9$igy_ZrmePAPqSqL0jHhLz8z5M.INSTANCE).O00000o0().O00000oo();
                            return;
                        }
                    }
                    hxi.O00000o.f952O000000o.O000000o("safe.setting.entry.click", new Object[0]);
                    fbs.O000000o(new fbt(AboutActivity.this, "SecuritySettingActivityV2"));
                    return;
                }
                if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                    AboutActivity.this.mDialog.dismiss();
                }
                AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
            }
        });
        findViewById(R.id.setting_auth_manager).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass10 */

            public final void onClick(View view) {
                AboutActivity.this.startActivity(new Intent(AboutActivity.this, AuthManagerListActivity.class));
            }
        });
        this.f9556O000000o = (ImageView) findViewById(R.id.img_about_dot_new);
        gva.O000000o().setRedPointView("loc_setting_btn_check_update", new gus() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass11 */

            public final void showRedPoint(boolean z) {
                gsy.O000000o(LogType.GENERAL, "MessageCenter", "AboutActivity mImgDotNew isShow  ".concat(String.valueOf(z)));
                AboutActivity.this.f9556O000000o.setVisibility(z ? 0 : 8);
            }
        });
        try {
            ((TextView) findViewById(R.id.app_info)).setText(gwh.O000000o(this));
            if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                findViewById(R.id.international_icon).setVisibility(0);
            }
        } catch (Exception unused) {
        }
        this.O00000o0 = findViewById(R.id.product_stat);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass13 */

            public final void onClick(View view) {
                if (AboutActivity.this.O00000o != null) {
                    Intent intent = new Intent(AboutActivity.this, SmartHomeWebActivity.class);
                    intent.putExtra("title", AboutActivity.this.O00000o.O00000Oo);
                    intent.putExtra("url", AboutActivity.this.O00000o.f9590O000000o);
                    AboutActivity.this.startActivity(intent);
                }
            }
        });
        CoreApi.O000000o().O000000o(this, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/extra_config").O000000o(), new fss<JSONArray>() {
            /* class _m_j.fuh.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optJSONArray("result");
            }
        }, Crypto.RC4, new fsm<JSONArray, fso>() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass14 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                if (jSONArray != null && jSONArray.length() > 0) {
                    try {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(0);
                        String optString = jSONObject.optString("url");
                        String optString2 = jSONObject.optString("title");
                        String optString3 = jSONObject.optString("type");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                            O00000Oo o00000Oo = new O00000Oo();
                            o00000Oo.f9590O000000o = optString;
                            o00000Oo.O00000Oo = optString2;
                            o00000Oo.O00000o0 = optString3;
                            AboutActivity.this.O00000o = o00000Oo;
                            AboutActivity.this.refreshProductStat();
                        }
                    } catch (JSONException unused) {
                    }
                }
            }
        });
        refreshProductStat();
        findViewById(R.id.language).setVisibility(0);
        this.O00000oO = (TextView) findViewById(R.id.language_title_info);
        TextView textView = this.O00000oO;
        Resources resources = CommonApplication.getAppContext().getResources();
        Locale O00000o2 = ftn.O00000o(CommonApplication.getAppContext());
        if (Build.VERSION.SDK_INT >= 24) {
            locale = Resources.getSystem().getConfiguration().getLocales().get(0);
        } else {
            locale = Locale.getDefault();
        }
        if (!gwc.O000000o((Context) this)) {
            if (gwc.O000000o(gwc.O0000Oo, O00000o2) && gwc.O0000o0.contains(locale)) {
                str = resources.getString(R.string.settings_language_us);
                textView.setText(str);
                findViewById(R.id.language).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass15 */

                    public final void onClick(View view) {
                        hxi.O00000o.f952O000000o.O000000o("set_language_entry", new Object[0]);
                        AboutActivity.this.startActivityForResult(new Intent(AboutActivity.this, LanguageSettingActivity.class), 100);
                    }
                });
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                }
                findViewById(R.id.notification_operation).setVisibility(8);
                ServerBean O0000ooO = CoreApi.O000000o().O0000ooO();
                if (CoreApi.O000000o().O0000Ooo()) {
                }
                findViewById(R.id.device_auth).setVisibility(8);
                arrayList = new ArrayList();
                O0000O0o2 = fno.O000000o().O0000O0o();
                O00000Oo2 = fno.O000000o().O00000Oo();
                if (O0000O0o2 != null) {
                }
                if (O00000Oo2 != null) {
                }
                if (!arrayList.isEmpty()) {
                }
                z = false;
                if (z) {
                }
                listItemView = (ListItemView) findViewById(R.id.laboratory_setting);
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
                }
                listItemView.setVisibility(8);
                findViewById(R.id.privacy_container).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass20 */

                    public final void onClick(View view) {
                        fbs.O000000o(new fbt(AboutActivity.this, "/userCenter/PrivacySettingActivity"));
                    }
                });
                View findViewById8 = findViewById(R.id.uwb_permission_setting_container);
                final hzg O000000o2 = hzj.O000000o();
                hzk cacheConfig = hzj.O00000Oo().getCacheConfig();
                Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                z2 = false;
                if (!z2) {
                }
                findViewById8.setVisibility(i);
                findViewById8.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass21 */

                    public final void onClick(View view) {
                        O000000o2.showUwbPermissionSettingDialog(AboutActivity.this);
                    }
                });
                View findViewById9 = findViewById(R.id.uwb_manager_container);
                findViewById9.setVisibility(8);
                findViewById9.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass22 */

                    public final void onClick(View view) {
                        fbs.O000000o(new fbt(AboutActivity.this.getContext(), "UwbManagerTagActivity"));
                    }
                });
            } else if (O00000o2 != null) {
                if (gwc.O000000o(O00000o2, Locale.CHINA)) {
                    str = resources.getString(R.string.settings_language_zh);
                } else if (gwc.O000000o(O00000o2, Locale.TRADITIONAL_CHINESE)) {
                    str = resources.getString(R.string.settings_language_zh_rtw);
                } else if (gwc.O000000o(O00000o2, gwc.f18401O000000o)) {
                    str = resources.getString(R.string.settings_language_zh_hk);
                } else if (gwc.O000000o(O00000o2, gwc.O00000Oo)) {
                    str = resources.getString(R.string.settings_language_ko);
                } else if (gwc.O000000o(O00000o2, gwc.O00000o0)) {
                    str = resources.getString(R.string.settings_language_es);
                } else if (gwc.O000000o(O00000o2, gwc.O00000o)) {
                    str = resources.getString(R.string.settings_language_ru);
                } else if (gwc.O000000o(O00000o2, Locale.US)) {
                    str = resources.getString(R.string.settings_language_us);
                } else if (gwc.O000000o(O00000o2, Locale.FRANCE)) {
                    str = resources.getString(R.string.settings_language_fr);
                } else if (gwc.O000000o(O00000o2, Locale.ITALY)) {
                    str = resources.getString(R.string.settings_language_it);
                } else if (gwc.O000000o(O00000o2, Locale.GERMANY)) {
                    str = resources.getString(R.string.settings_language_de);
                } else if (gwc.O000000o(O00000o2, gwc.O0000Oo0)) {
                    str = resources.getString(R.string.settings_language_id);
                } else if (gwc.O000000o(O00000o2, Locale.JAPAN)) {
                    str = resources.getString(R.string.settings_language_ja);
                } else if (gwc.O000000o(O00000o2, gwc.O00000oO)) {
                    str = resources.getString(R.string.settings_language_pl);
                } else if (gwc.O000000o(O00000o2, gwc.O0000O0o)) {
                    str = resources.getString(R.string.settings_language_th);
                } else if (gwc.O000000o(O00000o2, gwc.O00000oo)) {
                    str = resources.getString(R.string.settings_language_vi);
                } else if (gwc.O000000o(O00000o2, gwc.O0000o00)) {
                    str = resources.getString(R.string.settings_language_nl);
                } else if (gwc.O000000o(O00000o2, gwc.O0000OoO)) {
                    str = resources.getString(R.string.settings_language_pt);
                } else if (gwc.O000000o(O00000o2, gwc.O0000Ooo)) {
                    str = resources.getString(R.string.settings_language_tr);
                }
                textView.setText(str);
                findViewById(R.id.language).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass15 */

                    public final void onClick(View view) {
                        hxi.O00000o.f952O000000o.O000000o("set_language_entry", new Object[0]);
                        AboutActivity.this.startActivityForResult(new Intent(AboutActivity.this, LanguageSettingActivity.class), 100);
                    }
                });
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || !CoreApi.O000000o().O0000Ooo()) {
                    findViewById(R.id.notification_operation).setVisibility(8);
                } else {
                    findViewById(R.id.notification_operation).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass16 */

                        public final void onClick(View view) {
                            hxi.O00000o.f952O000000o.O000000o("notification_entry", new Object[0]);
                            AboutActivity.this.startActivity(new Intent(AboutActivity.this, QuickOpDeviceSettingActivity.class));
                        }
                    });
                }
                ServerBean O0000ooO2 = CoreApi.O000000o().O0000ooO();
                if (CoreApi.O000000o().O0000Ooo() || !ftn.O00000oo(O0000ooO2)) {
                    findViewById(R.id.device_auth).setVisibility(8);
                } else {
                    findViewById(R.id.device_auth).setVisibility(0);
                    findViewById(R.id.device_auth).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass17 */

                        public final void onClick(View view) {
                            AboutActivity.this.startActivity(new Intent(AboutActivity.this, DeviceAuthMasterListActivity.class));
                        }
                    });
                }
                arrayList = new ArrayList();
                O0000O0o2 = fno.O000000o().O0000O0o();
                O00000Oo2 = fno.O000000o().O00000Oo();
                if (O0000O0o2 != null) {
                    arrayList.addAll(O0000O0o2.values());
                }
                if (O00000Oo2 != null) {
                    arrayList.addAll(O00000Oo2.values());
                }
                if (!arrayList.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        Device device = (Device) arrayList.get(i2);
                        if (device != null && (O00000oO2 = CoreApi.O000000o().O00000oO(device.model)) != null && O00000oO2.O00oOooO() == 1) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                z = false;
                if (z) {
                    View findViewById10 = findViewById(R.id.op_history_layout);
                    findViewById10.setVisibility(0);
                    findViewById10.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass18 */

                        public final void onClick(View view) {
                            if (CoreApi.O000000o().O0000Ooo()) {
                                AboutActivity.this.startActivity(new Intent(AboutActivity.this, DeviceOpHistoryListActivity.class));
                                return;
                            }
                            if (AboutActivity.this.mDialog != null && AboutActivity.this.mDialog.isShowing()) {
                                AboutActivity.this.mDialog.dismiss();
                            }
                            AboutActivity.this.mDialog = gty.O000000o().showLoginDialog(AboutActivity.this, false);
                        }
                    });
                } else {
                    findViewById(R.id.op_history_layout).setVisibility(8);
                }
                listItemView = (ListItemView) findViewById(R.id.laboratory_setting);
                if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || !CoreApi.O000000o().O0000Ooo()) {
                    listItemView.setVisibility(8);
                } else {
                    listItemView.setVisibility(8);
                    listItemView.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass19 */

                        public final void onClick(View view) {
                            fbs.O000000o(new fbt(AboutActivity.this, "/userCenter/LaboratoryActivity"));
                        }
                    });
                }
                findViewById(R.id.privacy_container).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass20 */

                    public final void onClick(View view) {
                        fbs.O000000o(new fbt(AboutActivity.this, "/userCenter/PrivacySettingActivity"));
                    }
                });
                View findViewById82 = findViewById(R.id.uwb_permission_setting_container);
                final hzg O000000o22 = hzj.O000000o();
                hzk cacheConfig2 = hzj.O00000Oo().getCacheConfig();
                Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                if (cacheConfig2 == null || !hzk.O000000o(getContext()) || !CoreApi.O000000o().O0000Ooo() || O0000Oo02 == null) {
                    z2 = false;
                }
                if (!z2) {
                    i = 8;
                }
                findViewById82.setVisibility(i);
                findViewById82.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass21 */

                    public final void onClick(View view) {
                        O000000o22.showUwbPermissionSettingDialog(AboutActivity.this);
                    }
                });
                View findViewById92 = findViewById(R.id.uwb_manager_container);
                findViewById92.setVisibility(8);
                findViewById92.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass22 */

                    public final void onClick(View view) {
                        fbs.O000000o(new fbt(AboutActivity.this.getContext(), "UwbManagerTagActivity"));
                    }
                });
            }
        }
        str = resources.getString(R.string.settings_language_default);
        textView.setText(str);
        findViewById(R.id.language).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass15 */

            public final void onClick(View view) {
                hxi.O00000o.f952O000000o.O000000o("set_language_entry", new Object[0]);
                AboutActivity.this.startActivityForResult(new Intent(AboutActivity.this, LanguageSettingActivity.class), 100);
            }
        });
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
        }
        findViewById(R.id.notification_operation).setVisibility(8);
        ServerBean O0000ooO22 = CoreApi.O000000o().O0000ooO();
        if (CoreApi.O000000o().O0000Ooo()) {
        }
        findViewById(R.id.device_auth).setVisibility(8);
        arrayList = new ArrayList();
        O0000O0o2 = fno.O000000o().O0000O0o();
        O00000Oo2 = fno.O000000o().O00000Oo();
        if (O0000O0o2 != null) {
        }
        if (O00000Oo2 != null) {
        }
        if (!arrayList.isEmpty()) {
        }
        z = false;
        if (z) {
        }
        listItemView = (ListItemView) findViewById(R.id.laboratory_setting);
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
        }
        listItemView.setVisibility(8);
        findViewById(R.id.privacy_container).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass20 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(AboutActivity.this, "/userCenter/PrivacySettingActivity"));
            }
        });
        View findViewById822 = findViewById(R.id.uwb_permission_setting_container);
        final hzg O000000o222 = hzj.O000000o();
        hzk cacheConfig22 = hzj.O00000Oo().getCacheConfig();
        Home O0000Oo022 = ggb.O00000Oo().O0000Oo0();
        z2 = false;
        if (!z2) {
        }
        findViewById822.setVisibility(i);
        findViewById822.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass21 */

            public final void onClick(View view) {
                O000000o222.showUwbPermissionSettingDialog(AboutActivity.this);
            }
        });
        View findViewById922 = findViewById(R.id.uwb_manager_container);
        findViewById922.setVisibility(8);
        findViewById922.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass22 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(AboutActivity.this.getContext(), "UwbManagerTagActivity"));
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        Context appContext = ServiceApplication.getAppContext();
        AnonymousClass30 r0 = new fvx.O000000o() {
            /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass30 */

            public final void O000000o() {
                AboutActivity.this.refreshServerEnv();
            }
        };
        ft O000000o2 = ft.O000000o(appContext);
        O000000o2.O000000o(new ServerEnvHelper$1(O000000o2, r0), new IntentFilter("action_select_server_env_local_broadcast_complete"));
        Intent intent = new Intent(appContext, SelectServerEnvActivity.class);
        intent.addFlags(268435456);
        appContext.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(boolean z) {
        gsy.O000000o(LogType.GENERAL, "MessageCenter", "AboutActivity mImgDotSecurity isShow  ".concat(String.valueOf(z)));
        this.O00000Oo.setVisibility(z ? 0 : 8);
    }

    public static boolean isTagType(Device device) {
        hzg O000000o2 = hzj.O000000o();
        if (O000000o2 == null) {
            return false;
        }
        return O000000o2.isTagType(device.model);
    }

    public static List<Device> getTagDevices() {
        ArrayList arrayList = new ArrayList();
        List<Device> O00000oo2 = fno.O000000o().O00000oo();
        O00000oo2.addAll(fno.O000000o().O00000oO().values());
        for (int i = 0; i < O00000oo2.size(); i++) {
            Device device = O00000oo2.get(i);
            if (isTagType(device)) {
                arrayList.add(device);
            }
        }
        return arrayList;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public static Point getAppUsableScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static Point getRealScreenSize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (Build.VERSION.SDK_INT >= 14) {
            try {
                point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                point.y = ((Integer) Display.class.getMethod("getRawHeight", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        return point;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && i2 == -1) {
            finish();
        } else if (i == 200 && i2 == -1) {
            this.O00000oo.setVisibility(0);
            this.O0000O0o.setText(gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_lite_config", "lite_config_device_card_shortcut", false) ? R.string.mj_open : R.string.mj_close);
        }
    }

    public void refreshRegion() {
        ServerBean O0000ooO;
        final TextView textView = (TextView) findViewById(R.id.selected_region);
        if (textView != null && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null) {
            this.O0000OOo = gjh.O000000o().O000000o(O0000ooO).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<String>() {
                /* class com.xiaomi.smarthome.miio.activity.AboutActivity.AnonymousClass24 */

                public final /* synthetic */ void accept(Object obj) throws Exception {
                    textView.setVisibility(0);
                    textView.setText((String) obj);
                }
            }, new Consumer(textView) {
                /* class com.xiaomi.smarthome.miio.activity.$$Lambda$AboutActivity$YKnIrXGmORwmtfhQzyq9r78LzmE */
                private final /* synthetic */ TextView f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    AboutActivity.O000000o(this.f$0, (Throwable) obj);
                }
            }, $$Lambda$AboutActivity$p7c8nj8fMU3tuZCmkIyiBstX7S0.INSTANCE);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(TextView textView, Throwable th) throws Exception {
        th.printStackTrace();
        textView.setVisibility(4);
    }

    public void refreshServerEnv() {
        TextView textView = (TextView) findViewById(R.id.selected_server_env);
        if (textView != null) {
            String O00oOooO = CoreApi.O000000o().O00oOooO();
            if (!TextUtils.isEmpty(O00oOooO)) {
                textView.setText(O00oOooO);
            }
        }
    }

    public void refreshProductStat() {
        if (this.O00000o != null) {
            this.O00000o0.setVisibility(0);
            TextView textView = (TextView) this.O00000o0.findViewById(R.id.product_stat_title);
            if (textView != null) {
                textView.setText(this.O00000o.O00000Oo);
                return;
            }
            return;
        }
        this.O00000o0.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        gva.O000000o().checkModelUpdate(this);
        gva.O000000o().checkAppUpdate(this);
        gva.O000000o().checkPluginUpdate();
    }

    public void onDestroy() {
        super.onDestroy();
        Dialog dialog = this.mDialog;
        if (dialog != null && dialog.isShowing()) {
            this.mDialog.dismiss();
        }
        gva.O000000o().removeRedPointView("loc_pincode_new");
        gva.O000000o().removeRedPointView("loc_setting_btn_check_update");
        Disposable disposable = this.O0000OOo;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        String f9590O000000o;
        String O00000Oo;
        String O00000o0;

        O00000Oo() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
        if (r1 == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0035, code lost:
        if (r3.y == r1.y) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    public static Point getNavigationBarSize(Activity activity) {
        boolean z;
        if (Build.VERSION.SDK_INT < 17 || Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
            if (Build.VERSION.SDK_INT >= 17) {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                Point point = new Point();
                Point point2 = new Point();
                defaultDisplay.getSize(point);
                defaultDisplay.getRealSize(point2);
            } else {
                boolean hasPermanentMenuKey = ViewConfiguration.get(activity).hasPermanentMenuKey();
                boolean deviceHasKey = KeyCharacterMap.deviceHasKey(4);
                if (!hasPermanentMenuKey) {
                }
            }
            z = true;
            if (z) {
                return new Point(0, 0);
            }
            Point appUsableScreenSize = getAppUsableScreenSize(activity);
            Point realScreenSize = getRealScreenSize(activity);
            if (appUsableScreenSize.x < realScreenSize.x) {
                return new Point(realScreenSize.x - appUsableScreenSize.x, appUsableScreenSize.y);
            }
            if (appUsableScreenSize.y < realScreenSize.y) {
                return new Point(appUsableScreenSize.x, realScreenSize.y - appUsableScreenSize.y);
            }
            return new Point();
        }
        z = false;
        if (z) {
        }
    }
}
