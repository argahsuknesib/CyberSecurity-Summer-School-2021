package com.xiaomi.smarthome.framework.page.develop;

import _m_j.cly;
import _m_j.cmc;
import _m_j.cmd;
import _m_j.eyd;
import _m_j.eyo;
import _m_j.ezo;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fko;
import _m_j.ft;
import _m_j.fta;
import _m_j.fvo;
import _m_j.gfr;
import _m_j.glc;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.gsd;
import _m_j.gsy;
import _m_j.gty;
import _m_j.hjp;
import _m_j.hka;
import _m_j.hta;
import _m_j.izb;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.audiorecord.AudioRecordActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.DeveloperSettingAVActivity;
import com.xiaomi.smarthome.framework.page.DeveloperSettingMiscActivity;
import com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.ListItemView;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.operation.js_sdk.OperationCommonWebViewActivity;
import java.io.File;

public class DeveloperSettingActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f7801O000000o;
    CheckBox O00000Oo;
    CheckBox O00000o;
    CheckBox O00000o0;
    CheckBox O00000oO;
    CheckBox O00000oo;
    CheckBox O0000O0o;
    CheckBox O0000OOo;
    View O0000Oo;
    CheckBox O0000Oo0;
    TextView O0000OoO;
    View O0000Ooo;
    ListItemView O0000o;
    View O0000o0;
    TextView O0000o00;
    SwitchButton O0000o0O;
    SwitchButton O0000o0o;
    CheckBox O0000oO;
    TextView O0000oO0;
    View O0000oOO;
    public String[] pageMode = {"标准模式", "本地模式", "rn模式"};

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        this.f7801O000000o = this;
        setContentView((int) R.layout.developer_setting_activity);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.finish();
            }
        });
        findViewById(R.id.yp_shop_token_remove).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass12 */

            public final void onClick(View view) {
                CookieManager.getInstance().setCookie("shopapi.io.mi.com", "serviceToken=123;domain=shopapi.io.mi.com");
                CookieManager.getInstance().setCookie(".xiaomiyoupin.com", "serviceToken=123;domain=.xiaomiyoupin.com");
                CookieManager.getInstance().setCookie("ypsupport2.kefu.mi.com", "serviceToken=123;domain=ypsupport2.kefu.mi.com");
                fta fta = fta.O000000o.f17086O000000o;
                fta.O000000o("清除ServiceToken 成功");
            }
        });
        findViewById(R.id.account_env).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass23 */

            public final void onClick(View view) {
                XMPassportSettings.setLocalStaging(DeveloperSettingActivity.this.getContext(), !XMPassportSettings.isLocalStaging(DeveloperSettingActivity.this.getContext()));
                gqg.O00000Oo("killed");
                ServiceApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$23$lkFlU00ilQK6YwCiht4FSQkPsyc */

                    public final void run() {
                        DeveloperSettingActivity.AnonymousClass23.this.O000000o();
                    }
                }, 1000);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                DeveloperSettingActivity.this.finishAffinity();
                Process.killProcess(Process.myPid());
            }
        });
        TextView textView = (TextView) findViewById(R.id.account_env_sub);
        StringBuilder sb = new StringBuilder("当前账号环境: ");
        sb.append(XMPassportSettings.isLocalStaging(this) ? "stage" : "正式环境");
        textView.setText(sb.toString());
        findViewById(R.id.module_manager_list).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$zSAIJ5uz3bbTxHeMFllaOu9Ids */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.O00000oO(view);
            }
        });
        findViewById(R.id.sip).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass33 */

            public final void onClick(View view) {
                if (!CoreApi.O000000o().O0000Ooo()) {
                    izb.O000000o(ServiceApplication.getAppContext(), (int) R.string.loggin_first, 0).show();
                }
            }
        });
        findViewById(R.id.rn_package_setting).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass34 */

            public final void onClick(View view) {
                fbs.O000000o(new fbt(DeveloperSettingActivity.this.f7801O000000o, "DevelopSettingRNActivity"));
            }
        });
        findViewById(R.id.scan_code_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass35 */

            public final void onClick(View view) {
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.about_developer);
        this.O00000Oo = (CheckBox) findViewById(R.id.remote_debug);
        this.O00000o0 = (CheckBox) findViewById(R.id.remote_debug_shop);
        this.O00000o = (CheckBox) findViewById(R.id.app_config);
        this.O00000oO = (CheckBox) findViewById(R.id.app_spec_config);
        this.O00000oo = (CheckBox) findViewById(R.id.fail_401_refresh_token);
        this.O0000OOo = (CheckBox) findViewById(R.id.operation_config);
        this.O0000O0o = (CheckBox) findViewById(R.id.use_old_plugin_only);
        this.O0000Oo0 = (CheckBox) findViewById(R.id.cbx_disable_log);
        int i2 = 0;
        if (gfr.O0000Oo || gfr.O0000OOo) {
            this.O0000O0o.setChecked(fko.O000000o(getContext()));
            this.O0000O0o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass36 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    fko.O000000o(DeveloperSettingActivity.this.getContext(), z);
                }
            });
        } else {
            this.O0000O0o.setEnabled(false);
        }
        if (gfr.O0000oOO) {
            this.O00000Oo.setChecked(true);
        } else {
            this.O00000Oo.setChecked(false);
        }
        if (gfr.O0000oo0) {
            this.O00000o.setChecked(true);
        } else {
            this.O00000o.setChecked(false);
        }
        if (gfr.O0000oo) {
            this.O00000oO.setChecked(true);
        } else {
            this.O00000oO.setChecked(false);
        }
        if (gfr.O0000ooo) {
            this.O00000oo.setChecked(true);
        } else {
            this.O00000oo.setChecked(false);
        }
        boolean O00000Oo2 = hka.O00000Oo();
        gfr.O0000ooO = O00000Oo2;
        if (O00000Oo2) {
            this.O0000OOo.setChecked(true);
        } else {
            this.O0000OOo.setChecked(false);
        }
        if (hta.O000000o()) {
            this.O00000o0.setChecked(true);
        } else {
            this.O00000o0.setChecked(false);
        }
        this.O00000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass37 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    gfr.O0000oOO = true;
                } else {
                    gfr.O0000oOO = false;
                }
                gpy.O000000o(DeveloperSettingActivity.this.getContext(), "dev_pref", "use_test_url", gfr.O0000oOO);
            }
        });
        this.O0000Oo0.setChecked(gfr.O0000oOo);
        this.O0000Oo0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass38 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gfr.O0000oOo = z;
                glc.O000000o(DeveloperSettingActivity.this.getContext(), z);
            }
        });
        this.O00000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass2 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gpy.O000000o(CommonApplication.getAppContext(), "appconfig_cache", "debug_use_preview_appconfig", z);
                gfr.O0000oo0 = z;
            }
        });
        this.O00000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass3 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gpy.O000000o(CommonApplication.getAppContext(), "appconfig_cache", "debug_spec_preview_appconfig", z);
                gfr.O0000oo = z;
            }
        });
        this.O00000oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass4 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gfr.O0000ooo = z;
            }
        });
        this.O0000OOo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass5 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    gfr.O0000ooO = true;
                } else {
                    gfr.O0000ooO = false;
                }
                gpy.O000000o(CommonApplication.getAppContext(), "dev_pref", "use_stg_operation", z);
            }
        });
        this.O00000o0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass6 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                hta.O000000o(z);
            }
        });
        this.O0000Oo = findViewById(R.id.push_id);
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass7 */

            public final void onClick(View view) {
                gsy.O000000o(3, "push_id", "pushid:" + ezo.O000000o().getPushId());
            }
        });
        this.O0000OoO = (TextView) findViewById(R.id.push_id_tv);
        this.O0000OoO.setText(ezo.O000000o().getPushId());
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass8 */

            public final void onClick(View view) {
                ((ClipboardManager) DeveloperSettingActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(DeveloperSettingActivity.this.O0000OoO.getText(), DeveloperSettingActivity.this.O0000OoO.getText()));
                gqg.O00000Oo("已经复制:" + ((Object) DeveloperSettingActivity.this.O0000OoO.getText()));
            }
        });
        String str = null;
        eyd O000000o2 = eyo.O000000o();
        if (O000000o2 != null) {
            str = O000000o2.getToken();
        }
        this.O0000o00 = (TextView) findViewById(R.id.fcm_token_tv);
        this.O0000o00.setText(str);
        this.O0000Ooo = findViewById(R.id.fcm_token);
        this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass9 */

            public final void onClick(View view) {
                gsy.O000000o(3, "fcm_token", "token: " + ((Object) DeveloperSettingActivity.this.O0000o00.getText()));
                ((ClipboardManager) DeveloperSettingActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(DeveloperSettingActivity.this.O0000o00.getText(), DeveloperSettingActivity.this.O0000o00.getText()));
                gqg.O00000Oo("已经复制:" + ((Object) DeveloperSettingActivity.this.O0000o00.getText()));
            }
        });
        findViewById(R.id.plugin_device).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass10 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeveloperSettingActivity.this.f7801O000000o, "PlugininfoActivity");
                fbt.O000000o("type", 1);
                fbs.O000000o(fbt);
            }
        });
        findViewById(R.id.plugin_dns_hook_test).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$XBh3od9ioyEQqwdJRx90PCbFqtA */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.O00000o(view);
            }
        });
        findViewById(R.id.plugin_package_installed).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass11 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeveloperSettingActivity.this.f7801O000000o, "PlugininfoActivity");
                fbt.O000000o("type", 2);
                fbs.O000000o(fbt);
            }
        });
        findViewById(R.id.plugin_package_downloaded).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass13 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeveloperSettingActivity.this.f7801O000000o, "PlugininfoActivity");
                fbt.O000000o("type", 3);
                fbs.O000000o(fbt);
            }
        });
        findViewById(R.id.shop_api_test).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass14 */

            public final void onClick(View view) {
                hjp.O000000o("https://home.mi.com/shop/apitest");
            }
        });
        findViewById(R.id.url_test).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass15 */

            public final void onClick(View view) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(DeveloperSettingActivity.this);
                View inflate = LayoutInflater.from(DeveloperSettingActivity.this).inflate((int) R.layout.developer_setting_input_dialog, (ViewGroup) null);
                builder.O000000o(inflate).O000000o("输入URL");
                final EditText editText = (EditText) inflate.findViewById(R.id.url_input);
                builder.O000000o("打开", new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass15.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String obj = editText.getText().toString();
                        if (!TextUtils.isEmpty(obj)) {
                            fbs.O000000o(new fbt(ServiceApplication.getAppContext(), "CommonWebViewActivity").O000000o("url", obj).O000000o("title", "测试界面").O00000Oo(268435456));
                        }
                    }
                });
                builder.O00000Oo("取消", new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass15.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.O00000oo();
            }
        });
        findViewById(R.id.operation_jump).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass16 */

            public final void onClick(View view) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(DeveloperSettingActivity.this);
                View inflate = LayoutInflater.from(DeveloperSettingActivity.this).inflate((int) R.layout.developer_setting_input_dialog, (ViewGroup) null);
                builder.O000000o(inflate).O000000o("输入URL");
                final EditText editText = (EditText) inflate.findViewById(R.id.url_input);
                builder.O000000o("打开", new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass16.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String obj = editText.getText().toString();
                        if (!TextUtils.isEmpty(obj)) {
                            Intent intent = new Intent(ServiceApplication.getAppContext(), OperationCommonWebViewActivity.class);
                            intent.putExtra("url", obj);
                            DeveloperSettingActivity.this.startActivity(intent);
                        }
                    }
                });
                builder.O00000Oo("取消", new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass16.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.O00000oo();
            }
        });
        findViewById(R.id.oauth_login).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass17 */

            public final void onClick(View view) {
                gty.O000000o().startLoginMiByOAuth(DeveloperSettingActivity.this, null);
            }
        });
        findViewById(R.id.record_audio).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass18 */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.startActivity(new Intent(DeveloperSettingActivity.this.f7801O000000o, AudioRecordActivity.class));
            }
        });
        this.O0000o0O = (SwitchButton) findViewById(R.id.update_check);
        SwitchButton switchButton = this.O0000o0O;
        fvo.O000000o();
        switchButton.setChecked(fvo.O00000Oo());
        this.O0000o0O.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass19 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                gsy.O000000o(LogType.GENERAL, "DeveloperSettingActivity", "---".concat(String.valueOf(z)));
                fvo.O000000o();
                fvo.O00000Oo(z);
            }
        });
        this.O0000o0 = findViewById(R.id.layout_hide_device_entrance);
        if (gfr.O0000Oo || gfr.O0000OOo) {
            this.O0000o0.setVisibility(0);
            this.O0000o0o = (SwitchButton) findViewById(R.id.hide_device_entrance);
            SwitchButton switchButton2 = this.O0000o0o;
            fvo.O000000o();
            switchButton2.setChecked(fvo.O00000o0());
            this.O0000o0o.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass20 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    gsy.O000000o(LogType.GENERAL, "DeveloperSettingActivity", "---".concat(String.valueOf(z)));
                    fvo.O000000o();
                    fvo.O000000o(z);
                    if (z) {
                        izb.O000000o(DeveloperSettingActivity.this.f7801O000000o, "进入手动添加设备页面，长按设备即可进入插件", 1).show();
                    }
                }
            });
        }
        this.O0000o = (ListItemView) findViewById(R.id.mi_sip_server_env_liv);
        this.O0000oO0 = (TextView) findViewById(R.id.mi_sip_selected_server_env);
        this.O0000o.setVisibility(8);
        this.O0000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass21 */

            public final void onClick(View view) {
            }
        });
        findViewById(R.id.developer_page_mode).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass22 */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.createPageModeDialog();
            }
        });
        String str2 = "fail";
        if (!cmc.O000000o()) {
            gqg.O00000Oo("XmPluginHostApi is null!");
        } else {
            try {
                String[] strArr = this.pageMode;
                cly O000000o3 = cmd.O000000o();
                if (O000000o3 != null) {
                    gsy.O00000Oo("YoupinApiHelper", "getPageModel");
                    i = O000000o3.O00000o0();
                } else {
                    i = -1;
                }
                str2 = strArr[i];
            } catch (Exception unused) {
            }
        }
        ((TextView) findViewById(R.id.developer_page_mode_info)).setText(str2);
        findViewById(R.id.developer_rn_branch).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass24 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
             arg types: [java.lang.String, int]
             candidates:
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, int):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder */
            public final void onClick(View view) {
                DeveloperSettingActivity developerSettingActivity = DeveloperSettingActivity.this;
                Object O0000Oo0 = cmc.O0000Oo0();
                String str = O0000Oo0 instanceof String ? (String) O0000Oo0 : "";
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(developerSettingActivity);
                builder.O000000o((int) R.string.developer_rn_branch);
                builder.O000000o(str, false);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass31 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).getInputView().getEditableText();
                        cmc.O0000Oo();
                        ft.O000000o(DeveloperSettingActivity.this).O000000o(new Intent("rnbranch_changed"));
                        DeveloperSettingActivity.this.O000000o();
                    }
                });
                builder.O00000Oo("取消", (DialogInterface.OnClickListener) null);
                builder.O00000oo();
            }
        });
        O000000o();
        this.O0000oO = (CheckBox) findViewById(R.id.cbx_trace_rn_plugin_launch_perf);
        this.O0000oOO = findViewById(R.id.export_rn_plugin_launch_perf_record);
        View view = this.O0000oOO;
        if (!gsd.O000000o(this)) {
            i2 = 8;
        }
        view.setVisibility(i2);
        this.O0000oO.setChecked(gsd.O000000o(this));
        this.O0000oO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass25 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int i = 0;
                SharedPreferences.Editor edit = DeveloperSettingActivity.this.getSharedPreferences("rn-plugin-perf-trace-config", 0).edit();
                edit.putBoolean("enable-launch-perf-trace", z);
                if (Build.VERSION.SDK_INT >= 9) {
                    edit.apply();
                } else {
                    edit.commit();
                }
                View view = DeveloperSettingActivity.this.O0000oOO;
                if (!z) {
                    i = 8;
                }
                view.setVisibility(i);
            }
        });
        this.O0000oOO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass26 */

            public final void onClick(View view) {
                Uri uri;
                File file = new File(DeveloperSettingActivity.this.getExternalFilesDir("launchRecord"), "rn-plugin-launch-perf-tracer.json");
                DeveloperSettingActivity developerSettingActivity = DeveloperSettingActivity.this;
                try {
                    if (!file.exists()) {
                        gsy.O00000Oo("DeveloperSettingActivity", "export rn launch perf record error: file not exist");
                        return;
                    }
                    uri = FileProvider.getUriForFile(developerSettingActivity, gfr.O0000O0o + ".fileprovider", file);
                    if (uri != null) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.putExtra("android.intent.extra.STREAM", uri);
                        intent.addFlags(1);
                        intent.addFlags(268435456);
                        intent.setType("text/plain");
                        developerSettingActivity.startActivity(Intent.createChooser(intent, null));
                    }
                } catch (IllegalArgumentException e) {
                    gsy.O00000Oo("DeveloperSettingActivity", "export rn launch perf record error:" + Log.getStackTraceString(e));
                    uri = null;
                }
            }
        });
        findViewById(R.id.developer_weex_branch).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass27 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
             arg types: [java.lang.String, int]
             candidates:
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, int):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder */
            public final void onClick(View view) {
                if (!cmc.O000000o()) {
                    gqg.O00000Oo("youpin not valid!");
                    return;
                }
                Object O0000Oo0 = cmc.O0000Oo0();
                String str = O0000Oo0 instanceof String ? (String) O0000Oo0 : "";
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(DeveloperSettingActivity.this);
                builder.O000000o((int) R.string.developer_weex_branch);
                builder.O000000o(str, false);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass27.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).getInputView().getEditableText();
                        cmc.O0000Oo();
                        DeveloperSettingActivity.this.O00000Oo();
                    }
                });
                builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                builder.O00000oo();
            }
        });
        O00000Oo();
        findViewById(R.id.developer_weex_time).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass28 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
             arg types: [java.lang.String, int]
             candidates:
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, int):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(int, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder
              com.xiaomi.smarthome.library.common.dialog.MLAlertDialog.Builder.O000000o(java.lang.String, boolean):com.xiaomi.smarthome.library.common.dialog.MLAlertDialog$Builder */
            public final void onClick(View view) {
                if (!cmc.O000000o()) {
                    gqg.O00000Oo("youpin not valid!");
                    return;
                }
                Object O0000Oo0 = cmc.O0000Oo0();
                String str = O0000Oo0 instanceof String ? (String) O0000Oo0 : "";
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(DeveloperSettingActivity.this);
                builder.O000000o((int) R.string.developer_weex_detect_time);
                builder.O000000o(str, false);
                builder.O000000o().setInputType(2);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass28.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).getInputView().getEditableText();
                        cmc.O0000Oo();
                        DeveloperSettingActivity.this.O00000o0();
                    }
                });
                builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                builder.O00000oo();
            }
        });
        findViewById(R.id.misc_setting).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass29 */

            public final void onClick(View view) {
                Intent intent = new Intent(DeveloperSettingActivity.this, DeveloperSettingMiscActivity.class);
                intent.addFlags(268435456);
                DeveloperSettingActivity.this.startActivity(intent);
            }
        });
        findViewById(R.id.av_setting).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass30 */

            public final void onClick(View view) {
                Intent intent = new Intent(DeveloperSettingActivity.this, DeveloperSettingAVActivity.class);
                intent.addFlags(268435456);
                DeveloperSettingActivity.this.startActivity(intent);
            }
        });
        O00000o0();
        findViewById(R.id.test_recommend_scene).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$eRB0kidhDXWiYYuHgGGp3YwXDp4 */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.O00000o0(view);
            }
        });
        findViewById(R.id.test_miui_geofence).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$hYumkGpGbQkntXqAFTRqzPJG8A */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.O00000Oo(view);
            }
        });
        findViewById(R.id.test_miui_geofence_zat).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.$$Lambda$DeveloperSettingActivity$9JXYGkU4s4Irrfoy8_qzgynNXv8 */

            public final void onClick(View view) {
                DeveloperSettingActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000oO(View view) {
        startActivity(new Intent(this, DevModuleManagerActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        fbs.O000000o(new fbt(this.f7801O000000o, "DevPluginHookTestActivity"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        fbs.O000000o(new fbt(this, "MiUiGeoLogActivity"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        fbs.O000000o(new fbt(this, "TestMiUiGFActivity"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        fbs.O000000o(new fbt(this, "SmartFence"));
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        Object O0000Oo02 = cmc.O0000Oo0();
        if (O0000Oo02 != null && (O0000Oo02 instanceof String)) {
            ((TextView) findViewById(R.id.developer_rn_branch_info)).setText((String) O0000Oo02);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        Object O0000Oo02 = cmc.O0000Oo0();
        if (O0000Oo02 != null && (O0000Oo02 instanceof String)) {
            ((TextView) findViewById(R.id.developer_weex_branch_info)).setText((String) O0000Oo02);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        Object O0000Oo02 = cmc.O0000Oo0();
        if (O0000Oo02 instanceof String) {
            ((TextView) findViewById(R.id.developer_weex_time_info)).setText((String) O0000Oo02);
        }
    }

    public MLAlertDialog createPageModeDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this.f7801O000000o);
        builder.O000000o((int) R.string.developer_page_mode).O000000o(this.pageMode, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.develop.DeveloperSettingActivity.AnonymousClass32 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (cmd.O000000o() != null) {
                    gsy.O00000Oo("YoupinApiHelper", "setPageModel");
                }
                ((TextView) DeveloperSettingActivity.this.findViewById(R.id.developer_page_mode_info)).setText(DeveloperSettingActivity.this.pageMode[i]);
                dialogInterface.dismiss();
            }
        });
        return builder.O00000oo();
    }
}
