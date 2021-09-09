package com.xiaomi.smarthome.framework.page;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fbv;
import _m_j.fcg;
import _m_j.fno;
import _m_j.foc;
import _m_j.fpo;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.ftn;
import _m_j.gfb;
import _m_j.gfx;
import _m_j.ggb;
import _m_j.ggd;
import _m_j.gge;
import _m_j.gnk;
import _m_j.gpn;
import _m_j.gpy;
import _m_j.gqb;
import _m_j.gtf;
import _m_j.gwe;
import _m_j.gwg;
import _m_j.hor;
import _m_j.hsl;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hys;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.IBleUpgradeController;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.BleMeshDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginActivityHostApi;
import com.xiaomi.smarthome.homeroom.DeviceRoomAddActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.miio.activity.BleGatewayActivity;
import com.xiaomi.smarthome.miio.camera.match.CameraDevice;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import com.xiaomi.smarthome.wificonfig.ChangeNewWifiActivity;
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

public class DeviceMoreActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Context f7669O000000o;
    View O00000Oo;
    View O00000o;
    View O00000o0;
    TextView O00000oO;
    View O00000oo;
    View O0000O0o;
    View O0000OOo;
    View O0000Oo;
    View O0000Oo0;
    View O0000OoO;
    View O0000Ooo;
    protected Device O0000o;
    View O0000o0;
    View O0000o00;
    View O0000o0O;
    View O0000o0o;
    String O0000oO = "";
    boolean O0000oO0 = false;
    boolean O0000oOO;
    View O0000oOo;
    ArrayList<String> O0000oo;
    LinearLayout O0000oo0;
    boolean O0000ooO = true;
    ArrayList<Intent> O0000ooo;
    String O000O00o;
    private Map<String, Set<String>> O000O0OO = new HashMap();
    private TextView O000O0Oo;
    private View O000O0o0;
    private TextView O00oOoOo;
    ArrayList<IXmPluginHostActivity.MenuItemBase> O00oOooO = new ArrayList<>();
    RelativeLayout O00oOooo;

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0655  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0665  */
    public void onCreate(Bundle bundle) {
        Object obj;
        int i;
        DeviceMoreActivity deviceMoreActivity;
        Object obj2;
        int i2;
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_slide_in_right, R.anim.activity_slide_out_left);
        this.f7669O000000o = this;
        this.O0000oOO = false;
        gwg.O00000Oo(getWindow());
        setContentView((int) R.layout.device_more_activity);
        final Intent intent = getIntent();
        this.O000O00o = intent.getStringExtra("did");
        final Intent intent2 = (Intent) intent.getParcelableExtra("setting_click");
        final Intent intent3 = (Intent) intent.getParcelableExtra("about_click");
        final Intent intent4 = (Intent) intent.getParcelableExtra("help_click");
        this.O0000o = fno.O000000o().O000000o(this.O000O00o);
        if (this.O0000o == null) {
            this.O0000o = fno.O000000o().O00000Oo(this.O000O00o);
            if (this.O0000o == null) {
                finishPage();
                return;
            }
        }
        HashSet hashSet = new HashSet();
        hashSet.add("chuangmi.radio.v1");
        hashSet.add("chuangmi.radio.v2");
        this.O000O0OO.put("voice_control", hashSet);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass1 */

            public final void onClick(View view) {
                DeviceMoreActivity.this.finishPage();
            }
        });
        this.O0000oo0 = (LinearLayout) findViewById(R.id.menu_container);
        this.O0000oo0.setVisibility(8);
        LayoutInflater from = LayoutInflater.from(this);
        if (intent2 != null) {
            this.O0000oo0.setVisibility(0);
            this.O0000Oo0 = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
            ((TextView) this.O0000Oo0.findViewById(R.id.menu_item)).setText((int) R.string.device_more_activity_setting);
            this.O0000oo0.addView(this.O0000Oo0, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.menu_item_height)));
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass12 */

                public final void onClick(View view) {
                    DeviceMoreActivity.this.startActivity(intent2);
                }
            });
        }
        if (intent4 != null) {
            this.O0000oo0.setVisibility(0);
            this.O0000Ooo = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
            if (!new SharedConfig(this.f7669O000000o).O00000Oo.getBoolean("is_watch_movie", false)) {
                this.O0000Ooo.findViewById(R.id.module_a_3_return_more_new_btn).setVisibility(0);
            } else {
                this.O0000Ooo.findViewById(R.id.module_a_3_return_more_new_btn).setVisibility(8);
            }
            ((TextView) this.O0000Ooo.findViewById(R.id.menu_item)).setText((int) R.string.device_more_activity_help);
            this.O0000oo0.addView(this.O0000Ooo, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.setting_item_single_line_without_icon_height)));
            this.O0000Ooo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass18 */

                public final void onClick(View view) {
                    SharedPreferences sharedPreferences = new SharedConfig(DeviceMoreActivity.this.f7669O000000o).O00000Oo;
                    if (!sharedPreferences.getBoolean("is_watch_movie", false)) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean("is_watch_movie", true);
                        edit.apply();
                    }
                    DeviceMoreActivity.this.startActivity(intent4);
                }
            });
        }
        if (intent3 != null) {
            this.O0000oo0.setVisibility(0);
            this.O0000OoO = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
            ((TextView) this.O0000OoO.findViewById(R.id.menu_item)).setText((int) R.string.device_more_activity_about);
            this.O0000oo0.addView(this.O0000OoO, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.setting_item_single_line_without_icon_height)));
            this.O0000OoO.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass19 */

                public final void onClick(View view) {
                    DeviceMoreActivity.this.startActivity(intent3);
                }
            });
        }
        this.O0000ooO = intent.getBooleanExtra("useDefaultMenus", true);
        this.O0000oOo = findViewById(R.id.menu_default);
        int i3 = 2;
        gnk.O00000o0(String.format("%s device.permit = %d", getClass().getSimpleName(), Integer.valueOf(this.O0000o.permitLevel)));
        if (!this.O0000ooO) {
            this.O0000oOo.setVisibility(8);
        }
        this.O00000Oo = findViewById(R.id.freq_camera_group);
        this.O000O0o0 = findViewById(R.id.freq_camera_red_dot);
        this.O00oOoOo = (TextView) findViewById(R.id.freq_camera_status);
        if (!gge.O00000Oo(this.O0000o)) {
            this.O00000Oo.setVisibility(8);
        } else {
            List<Device> O0000oOO2 = ggb.O00000Oo().O0000oOO(ggb.O00000Oo().O0000OOo());
            if (gfx.O000000o().O00000Oo()) {
                int i4 = 0;
                while (true) {
                    if (i4 < O0000oOO2.size()) {
                        if ((O0000oOO2.get(i4).comFlag & 2) == 2) {
                            break;
                        }
                        i4++;
                    } else {
                        break;
                    }
                }
                hxi.O00000o0.O00000Oo();
            }
            this.O000O0o0.setVisibility(8);
            hxi.O00000o0.O00000Oo();
        }
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeviceMoreActivity$vf71zTe7jmIePIkPQz5HcjmMpQU */

            public final void onClick(View view) {
                DeviceMoreActivity.this.O00000o(view);
            }
        });
        this.O00000o0 = findViewById(R.id.freq_device_group);
        this.O000O0Oo = (TextView) findViewById(R.id.freq_device_status);
        if (this.O0000o.isHideMainList() || fno.O000000o().O00000oO(this.O0000o)) {
            this.O00000o0.setVisibility(8);
        } else {
            hxp hxp = hxi.O00000o0;
            if (this.O00000Oo.getVisibility() == 0) {
                i3 = 1;
            }
            hxp.O00000o(i3);
        }
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeviceMoreActivity$qZ4yhFJ2l36chzZwbz0EFzd7NI */

            public final void onClick(View view) {
                DeviceMoreActivity.this.O00000o0(view);
            }
        });
        this.O00000o = findViewById(R.id.rename);
        if (!this.O0000o.isOwner()) {
            this.O00000o.setVisibility(8);
        }
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20 */

            public final void onClick(View view) {
                final ClientRemarkInputView clientRemarkInputView = (ClientRemarkInputView) LayoutInflater.from(DeviceMoreActivity.this.f7669O000000o).inflate((int) R.layout.client_remark_input_view, (ViewGroup) null);
                final EditText editText = clientRemarkInputView.getEditText();
                editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(41)});
                MLAlertDialog O00000oo = new MLAlertDialog.Builder(DeviceMoreActivity.this.f7669O000000o).O000000o((int) R.string.smarthome_device_rename).O000000o(clientRemarkInputView).O00000Oo(false).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        clientRemarkInputView.O000000o(dialogInterface);
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                    }
                }).O00000oo();
                clientRemarkInputView.O000000o(new ClientRemarkInputView.O000000o() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20.AnonymousClass3 */

                    public final void modifyBackName(final String str) {
                        if (!TextUtils.equals(str, DeviceMoreActivity.this.O0000o.name)) {
                            final XQProgressDialog xQProgressDialog = new XQProgressDialog(DeviceMoreActivity.this.f7669O000000o);
                            xQProgressDialog.setMessage(DeviceMoreActivity.this.f7669O000000o.getString(R.string.changeing_back_name));
                            xQProgressDialog.setCancelable(false);
                            xQProgressDialog.show();
                            gwe.O000000o();
                            gwe.O000000o(DeviceMoreActivity.this.O0000o, str, new fsm<Void, fso>() {
                                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20.AnonymousClass3.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    DeviceMoreActivity.this.notifyRename(str, 0);
                                    xQProgressDialog.dismiss();
                                    izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.change_back_name_fail, 0).show();
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    DeviceMoreActivity.this.notifyRename(str, 1);
                                    xQProgressDialog.dismiss();
                                    DeviceMoreActivity.this.O0000o.name = str;
                                    if (DeviceMoreActivity.this.O0000o.pid == Device.PID_BLUETOOTH) {
                                        foc.O000000o(DeviceMoreActivity.this.O0000o.mac, str);
                                    }
                                    DeviceMoreActivity.this.O000000o();
                                }
                            });
                        }
                    }
                }, O00000oo, DeviceMoreActivity.this.O0000o.name, DeviceMoreActivity.this.O0000o.name);
                final Button button = O00000oo.getButton(-1);
                button.setEnabled(true);
                button.setTextColor(DeviceMoreActivity.this.getResources().getColor(R.color.mj_color_dialog_button1_bg_nor));
                clientRemarkInputView.getEditText().addTextChangedListener(new TextWatcher() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass20.AnonymousClass4 */

                    public final void afterTextChanged(Editable editable) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        clientRemarkInputView.setAlertText("");
                        button.setEnabled(true);
                    }

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                        String obj = editText.getText().toString();
                        if (obj.length() > 0) {
                            if (gqb.O00000o0(obj)) {
                                clientRemarkInputView.setAlertText(DeviceMoreActivity.this.getString(R.string.tag_save_data_description));
                            } else if (!ggb.O0000oO(obj)) {
                                clientRemarkInputView.setAlertText(DeviceMoreActivity.this.getString(R.string.room_name_too_long));
                            } else {
                                clientRemarkInputView.setAlertText("");
                                button.setEnabled(true);
                                return;
                            }
                        }
                        button.setEnabled(false);
                    }
                });
            }
        });
        this.O00000oO = (TextView) findViewById(R.id.name);
        View findViewById = findViewById(R.id.more_setting);
        if (DeviceMoreInnterActivity.visableFeedback(this.O0000o) || DeviceMoreInnterActivity.visableNetwork(this.O0000o) || DeviceMoreInnterActivity.visableSecurity(intent) || DeviceMoreInnterActivity.visableTimezone(intent) || DeviceMoreInnterActivity.visableShortcut(intent)) {
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass21 */

                public final void onClick(View view) {
                    DeviceMoreActivity deviceMoreActivity = DeviceMoreActivity.this;
                    deviceMoreActivity.startActivityForResult(new Intent(deviceMoreActivity, DeviceMoreInnterActivity.class).putExtras(intent), 1);
                }
            });
        } else {
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R.id.scence_setting);
        if (!intent.getBooleanExtra("scence_enable", false) || !this.O0000o.isOwner() || this.O0000o.isSubDevice()) {
            findViewById2.setVisibility(8);
        } else {
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass22 */

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("device_id", DeviceMoreActivity.this.O000O00o);
                    intent.putExtras(intent);
                    hor.O000000o().startDeviceSceneNewActivity(DeviceMoreActivity.this, intent);
                }
            });
        }
        View findViewById3 = findViewById(R.id.multikey_setting);
        if (!intent.getBooleanExtra("multikey_setting_enable", false) || !this.O0000o.isOwner() || (!ftn.O00000oo(this) && !ftn.O0000o0O(this))) {
            findViewById3.setVisibility(8);
        } else {
            findViewById3.setVisibility(0);
            findViewById3.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass23 */

                public final void onClick(View view) {
                    DeviceMoreActivity deviceMoreActivity = DeviceMoreActivity.this;
                    PowerMultikeyActivity.startActivity(deviceMoreActivity, deviceMoreActivity.O0000o.did, DeviceMoreActivity.this.O0000o.mac);
                }
            });
        }
        View findViewById4 = findViewById(R.id.device_op_history);
        findViewById4.setVisibility(8);
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.O0000o.model);
        if (O00000oO2 != null && O00000oO2.O00oOooO() == 1) {
            findViewById4.setVisibility(0);
            findViewById4.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass24 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(DeviceMoreActivity.this, "DeviceOpHistoryActivity");
                    fbt.O000000o("did", DeviceMoreActivity.this.O0000o.did);
                    fbs.O000000o(fbt);
                }
            });
        }
        View findViewById5 = findViewById(R.id.share);
        boolean booleanExtra = intent.getBooleanExtra("share_enable", true);
        boolean canBeShared = DeviceRouterFactory.getDeviceWrapper().canBeShared(this.O0000o);
        if (!this.O0000o.isOwner() || this.O0000o.isSubDevice() || !booleanExtra || !canBeShared) {
            findViewById5.setVisibility(8);
        } else {
            findViewById5.setVisibility(0);
        }
        findViewById5.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass2 */

            public final void onClick(View view) {
                fbt fbt = new fbt(DeviceMoreActivity.this, "/share/ShareDeviceActivity");
                fbt.O000000o("user_id", CoreApi.O000000o().O0000o0());
                fbt.O000000o("did", DeviceMoreActivity.this.O0000o.did);
                fbs.O000000o(fbt);
            }
        });
        View findViewById6 = findViewById(R.id.device_tag);
        if (!this.O0000o.isOwner() || ggd.O000000o(this.O0000o.model)) {
            findViewById6.setVisibility(8);
        } else {
            ((TextView) findViewById6.findViewById(R.id.home_manager_tv)).setText((int) R.string.room_loc_title);
            findViewById6.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    Intent intent = new Intent(DeviceMoreActivity.this, DeviceRoomAddActivity.class);
                    intent.putExtra("did", DeviceMoreActivity.this.O0000o.did);
                    DeviceMoreActivity.this.startActivity(intent);
                }
            });
        }
        this.O00000oo = findViewById(R.id.firmware);
        this.O00000oo.setVisibility(8);
        if (O00000o0()) {
            this.O00000oo.setVisibility(0);
            this.O00000oo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(DeviceMoreActivity.this.getContext(), "MiioUpgradeActivity");
                    fbt.O000000o("miio_upgrade_did", DeviceMoreActivity.this.O0000o.did);
                    fbt.O000000o("miio_upgrade_pid", DeviceMoreActivity.this.O0000o.pid);
                    fbt.O000000o("miio_upgrade_name", DeviceMoreActivity.this.O0000o.name);
                    fbs.O000000o(fbt);
                }
            });
        }
        this.O0000O0o = findViewById(R.id.version_info);
        Device device = this.O0000o;
        if ((device instanceof MiTVDevice) || (device instanceof CameraDevice)) {
            this.O00000oo.setVisibility(8);
        }
        this.O0000OOo = findViewById(R.id.tvDeleteDevice);
        this.O0000OOo.setVisibility(8);
        if (this.O0000o.isOwner() && intent.getBooleanExtra("unbind_enable", true) && !this.O0000o.isSubDevice()) {
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    String str;
                    if (TextUtils.isEmpty(intent.getStringExtra("device_unbind_message_detail"))) {
                        str = "";
                    } else {
                        str = intent.getStringExtra("device_unbind_message_detail");
                    }
                    new MLAlertDialog.Builder(DeviceMoreActivity.this.f7669O000000o).O000000o((int) R.string.smarthome_unbind_tips).O00000Oo(str).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass5.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            final XQProgressDialog xQProgressDialog = new XQProgressDialog(DeviceMoreActivity.this.f7669O000000o);
                            xQProgressDialog.setMessage(DeviceMoreActivity.this.f7669O000000o.getString(R.string.smarthome_unbinding));
                            xQProgressDialog.setCancelable(false);
                            xQProgressDialog.show();
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(DeviceMoreActivity.this.O0000o.did);
                            fno.O000000o().O000000o(arrayList, DeviceMoreActivity.this.f7669O000000o, new fno.O00000Oo() {
                                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass5.AnonymousClass2.AnonymousClass1 */

                                public final void O000000o() {
                                    izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.remove_device_success, 0).show();
                                    xQProgressDialog.dismiss();
                                    Intent intent = new Intent();
                                    intent.putExtra("result_data", 1);
                                    DeviceMoreActivity.this.setResult(-1, intent);
                                    DeviceMoreActivity.this.finishFinal();
                                    fbt fbt = new fbt(DeviceMoreActivity.this, "SmartHomeMainActivity");
                                    fbt.O00000Oo(67108864);
                                    fbs.O000000o(fbt);
                                }

                                public final void O000000o(fso fso) {
                                    izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.bind_error, 0).show();
                                    xQProgressDialog.dismiss();
                                }
                            });
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass5.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000oo();
                }
            });
        } else if ((this.O0000o.isFamily() || this.O0000o.isShared()) && intent.getBooleanExtra("delete_enable", true) && this.O0000o.pid != Device.PID_VIRTUAL_DEVICE) {
            this.O0000OOo.setVisibility(0);
            findViewById(R.id.tvDeleteDevice).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass6 */

                public final void onClick(View view) {
                    new MLAlertDialog.Builder(DeviceMoreActivity.this.f7669O000000o).O000000o((int) R.string.smarthome_delete_tips).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass6.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (!TextUtils.equals(CoreApi.O000000o().O0000o0(), "923522198") || !TextUtils.equals(DeviceMoreActivity.this.O0000o.did, "658906")) {
                                final XQProgressDialog xQProgressDialog = new XQProgressDialog(DeviceMoreActivity.this.f7669O000000o);
                                xQProgressDialog.setMessage(DeviceMoreActivity.this.f7669O000000o.getString(R.string.smarthome_deleting));
                                xQProgressDialog.setCancelable(false);
                                xQProgressDialog.show();
                                hys.O000000o().O000000o(DeviceMoreActivity.this, DeviceMoreActivity.this.O0000o.did, DeviceMoreActivity.this.O0000o.pid, new fsm<JSONObject, fso>() {
                                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass6.AnonymousClass2.AnonymousClass1 */

                                    public final void onFailure(fso fso) {
                                        izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.smarthome_device_delete_fail, 0).show();
                                        xQProgressDialog.dismiss();
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.smarthome_device_delete_success, 0).show();
                                        xQProgressDialog.dismiss();
                                        fno.O000000o().O00000Oo(DeviceMoreActivity.this.O0000o);
                                        Intent intent = new Intent();
                                        intent.putExtra("result_data", 1);
                                        DeviceMoreActivity.this.setResult(-1, intent);
                                        DeviceMoreActivity.this.finishFinal();
                                        fbt fbt = new fbt(DeviceMoreActivity.this.getApplicationContext(), "SmartHomeMainActivity");
                                        fbt.O00000Oo(335544320);
                                        fbs.O000000o(fbt);
                                    }
                                });
                                return;
                            }
                            izb.O000000o(DeviceMoreActivity.this.f7669O000000o, (int) R.string.smarthome_device_delete_fail, 0).show();
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((MLAlertDialog) dialogInterface).setAudoDismiss(true);
                        }
                    }).O00000oo();
                }
            });
        }
        if (this.O0000o.isHomeShared()) {
            this.O0000OOo.setVisibility(8);
        }
        this.O0000Oo = findViewById(R.id.reset_router);
        Device device2 = this.O0000o;
        if ((device2 instanceof MiioDeviceV2) && ((MiioDeviceV2) device2).mIsFactory) {
            this.O0000Oo.setVisibility(0);
        }
        this.O0000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass7 */

            public final void onClick(View view) {
                Intent intent = new Intent(DeviceMoreActivity.this, ChangeNewWifiActivity.class);
                intent.putExtra("did", DeviceMoreActivity.this.O0000o.did);
                DeviceMoreActivity.this.startActivity(intent);
            }
        });
        this.O0000o00 = findViewById(R.id.using_help);
        this.O0000o00.setVisibility(8);
        if (intent.getBooleanExtra("help_enable", false)) {
            this.O0000o00.setVisibility(0);
            this.O0000o00.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass8 */

                public final void onClick(View view) {
                    fbt fbt = new fbt(DeviceMoreActivity.this.f7669O000000o, "/userCenter/FeedbackCommonProblemActivity");
                    fbt.O000000o("did", DeviceMoreActivity.this.O0000o.did);
                    fbt.O000000o("extra_model", DeviceMoreActivity.this.O0000o.model);
                    fbs.O000000o(fbt);
                }
            });
        }
        this.O0000o0O = findViewById(R.id.bluetooth_gateway);
        this.O0000o0O.setVisibility(8);
        if (isSupportBleGateway(this.O0000o) && intent.getBooleanExtra("bluetooth_gateway", true)) {
            final ImageView imageView = (ImageView) findViewById(R.id.ble_gateway_red_point);
            if (getBleGatewayRedPointStatus(this.O0000o)) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            this.O0000o0O.setVisibility(0);
            this.O0000o0O.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass9 */

                public final void onClick(View view) {
                    imageView.setVisibility(8);
                    DeviceMoreActivity.setBleGatewayRedPointStatus(DeviceMoreActivity.this.O0000o);
                    Intent intent = new Intent(DeviceMoreActivity.this, BleGatewayActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("key_gateway_did", DeviceMoreActivity.this.O0000o.did);
                    intent.putExtras(bundle);
                    DeviceMoreActivity.this.startActivity(intent);
                }
            });
        }
        final boolean booleanExtra2 = intent.getBooleanExtra("enable_privacy_setting", false);
        this.O0000o0 = findViewById(R.id.license_and_private);
        boolean booleanExtra3 = intent.getBooleanExtra("enableRemoveLicense", false);
        final boolean booleanExtra4 = intent.getBooleanExtra("useDefaultLicense", false);
        final boolean booleanExtra5 = intent.getBooleanExtra("need_delete_server_data", true);
        Spanned spanned = (Spanned) intent.getCharSequenceExtra("licenseContent");
        Spanned spanned2 = (Spanned) intent.getCharSequenceExtra("privacyContent");
        final Spanned spanned3 = (Spanned) intent.getCharSequenceExtra("usrExpPlanContent");
        final String stringExtra = intent.getStringExtra("licenseContentUri");
        final String stringExtra2 = intent.getStringExtra("privacyContentUri");
        String stringExtra3 = intent.getStringExtra("usrExpPlanContentRnUri");
        String stringExtra4 = intent.getStringExtra("usrExpPlanContentUri");
        String stringExtra5 = intent.getStringExtra("licenseContentHtml");
        String stringExtra6 = intent.getStringExtra("privacyContentHtml");
        int intExtra = intent.getIntExtra("licenseContentHtmlRes", -1);
        int intExtra2 = intent.getIntExtra("privacyContentHtmlRes", -1);
        if (!booleanExtra3 || ((stringExtra == null || stringExtra2 == null) && ((stringExtra5 == null || stringExtra6 == null) && ((spanned == null || spanned2 == null) && ((intExtra <= 0 || intExtra2 <= 0) && !booleanExtra4))))) {
            obj = "voice_control";
            deviceMoreActivity = this;
        } else if (this.O0000o.isOwner() || fno.O000000o().O00000oO(this.O0000o)) {
            if (booleanExtra4) {
                ((TextView) findViewById(R.id.privacy_and_license)).setText((int) R.string.device_more_activity_privacy);
            }
            this.O0000o0.setVisibility(0);
            AnonymousClass10 r22 = r0;
            final String str = stringExtra3;
            final String str2 = stringExtra4;
            final String str3 = stringExtra5;
            View view = this.O0000o0;
            final String str4 = stringExtra6;
            final Spanned spanned4 = spanned;
            obj = "voice_control";
            final Spanned spanned5 = spanned2;
            final int i5 = intExtra;
            final int i6 = intExtra2;
            AnonymousClass10 r0 = new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass10 */

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
                 method: _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                 arg types: [java.lang.String, android.text.Spanned]
                 candidates:
                  _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                  _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                  _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt */
                public final void onClick(View view) {
                    fbt fbt = new fbt(DeviceMoreActivity.this, "/userCenter/LicenseAndPrivacyActivity");
                    if (booleanExtra2) {
                        fbt.O000000o("enable_privacy_setting", true);
                        String str = str;
                        if (str != null) {
                            fbt.O000000o("usrExpPlanContentRnUri", str);
                        }
                        String str2 = str2;
                        if (str2 != null) {
                            fbt.O000000o("usrExpPlanContentUri", str2);
                        }
                        Spanned spanned = spanned3;
                        if (spanned != null) {
                            fbt.O000000o("usrExpPlanContent", (CharSequence) spanned);
                        }
                    } else {
                        fbt.O000000o("enable_privacy_setting", false);
                    }
                    fbt.O000000o("need_delete_server_data", booleanExtra5);
                    if (booleanExtra4) {
                        fbt.O000000o("useDefaultLicense", true);
                    } else {
                        String str3 = str3;
                        if (str3 != null) {
                            fbt.O000000o("licenseContentHtml", str3);
                            fbt.O000000o("privacyContentHtml", str4);
                        } else {
                            String str4 = stringExtra;
                            if (str4 != null) {
                                fbt.O000000o("licenseContentUri", str4);
                                fbt.O000000o("privacyContentUri", stringExtra2);
                            } else {
                                Spanned spanned2 = spanned4;
                                if (spanned2 != null) {
                                    fbt.O000000o("licenseContent", (CharSequence) spanned2);
                                    fbt.O000000o("privacyContent", (CharSequence) spanned5);
                                } else {
                                    int i = i5;
                                    if (i > 0) {
                                        fbt.O000000o("licenseContentHtmlRes", i);
                                        fbt.O000000o("privacyContentHtmlRes", i6);
                                    }
                                }
                            }
                        }
                    }
                    fbt.O000000o("did", DeviceMoreActivity.this.O0000o.did);
                    fbt.O000000o(100);
                    fbs.O000000o(fbt);
                }
            };
            view.setOnClickListener(r22);
            i = 8;
            deviceMoreActivity = this;
            O00000Oo();
            deviceMoreActivity.O00oOooo = (RelativeLayout) deviceMoreActivity.findViewById(R.id.device_auth_manager);
            obj2 = obj;
            if ((deviceMoreActivity.O000O0OO.get(obj2) != null || !deviceMoreActivity.O000O0OO.get(obj2).contains(deviceMoreActivity.O0000o.model)) && hsl.O00000Oo().checkIfSupportVoiceCtrl(deviceMoreActivity.O000O00o)) {
                i2 = 0;
                deviceMoreActivity.O00oOooo.setVisibility(0);
                deviceMoreActivity.O00oOooo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass11 */

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
                    public final void onClick(View view) {
                        fbt fbt = new fbt(DeviceMoreActivity.this, "/setting/DeviceAuthSlaveListActivity");
                        fbt.O000000o("device_id", DeviceMoreActivity.this.O000O00o);
                        fbt.O000000o("bottom_bar", false);
                        fbs.O000000o(fbt);
                    }
                });
            } else {
                i2 = 0;
                deviceMoreActivity.O00oOooo.setVisibility(i);
            }
            deviceMoreActivity.O0000o0o = deviceMoreActivity.findViewById(R.id.light_group);
            if (!gtf.O000000o().O000000o(deviceMoreActivity.O0000o)) {
                deviceMoreActivity.O0000o0o.setVisibility(i2);
                deviceMoreActivity.O0000o0o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeviceMoreActivity$MaXkygZHX5ad9fwdseFnCUq7F8 */

                    public final void onClick(View view) {
                        DeviceMoreActivity.this.O00000Oo(view);
                    }
                });
                return;
            }
            gtf.O000000o();
            if (gtf.O00000Oo(deviceMoreActivity.O0000o)) {
                deviceMoreActivity.O0000o0o.setVisibility(i2);
                ((TextView) deviceMoreActivity.findViewById(R.id.tv_light_group)).setText((int) R.string.light_group_manager);
                deviceMoreActivity.O0000o0o.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.$$Lambda$DeviceMoreActivity$22K6mGLYyID7YqCVE74a7tRpZ0 */

                    public final void onClick(View view) {
                        DeviceMoreActivity.this.O000000o(view);
                    }
                });
                return;
            }
            return;
        } else {
            obj = "voice_control";
            deviceMoreActivity = this;
        }
        i = 8;
        deviceMoreActivity.O0000o0.setVisibility(8);
        O00000Oo();
        deviceMoreActivity.O00oOooo = (RelativeLayout) deviceMoreActivity.findViewById(R.id.device_auth_manager);
        obj2 = obj;
        if (deviceMoreActivity.O000O0OO.get(obj2) != null) {
        }
        i2 = 0;
        deviceMoreActivity.O00oOooo.setVisibility(0);
        deviceMoreActivity.O00oOooo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass11 */

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
            public final void onClick(View view) {
                fbt fbt = new fbt(DeviceMoreActivity.this, "/setting/DeviceAuthSlaveListActivity");
                fbt.O000000o("device_id", DeviceMoreActivity.this.O000O00o);
                fbt.O000000o("bottom_bar", false);
                fbs.O000000o(fbt);
            }
        });
        deviceMoreActivity.O0000o0o = deviceMoreActivity.findViewById(R.id.light_group);
        if (!gtf.O000000o().O000000o(deviceMoreActivity.O0000o)) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        fbt fbt = new fbt(this, "FreqDeviceSetActivity");
        fbt.O000000o("did", this.O0000o.did);
        fbt.O000000o("pagetype", 2);
        fbs.O000000o(fbt);
        this.O000O0o0.setVisibility(8);
        gfx.O000000o().O000000o(false);
        hxi.O00000o.O0000o0o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        fbt fbt = new fbt(this, "FreqDeviceSetActivity");
        fbt.O000000o("did", this.O0000o.did);
        int i = 1;
        fbt.O000000o("pagetype", 1);
        fbs.O000000o(fbt);
        hxk hxk = hxi.O00000o;
        if (this.O00000Oo.getVisibility() != 0) {
            i = 2;
        }
        hxk.O0000oO(i);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        fbt fbt = new fbt(this, "LightGroupSettingActivity");
        fbt.O000000o("key_group_model", gtf.O000000o().O000000o(this.O0000o.model));
        fbt.O000000o("did", this.O000O00o);
        fbs.O000000o(fbt);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        fbt fbt = new fbt(this, "LightGroupManageActivity");
        fbt.O000000o("did", this.O000O00o);
        fbs.O000000o(fbt);
    }

    public static boolean isSupportBleGateway(Device device) {
        if (device == null) {
            return false;
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
        if (!device.isOwner() || O00000oO2 == null || O00000oO2.O000O0OO() != 1) {
            return false;
        }
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
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private static String O000000o(String str, String str2) {
        return "ble_gateway_" + str + "_" + str2;
    }

    public static void setBleGatewayRedPointStatus(Device device) {
        if (device != null) {
            String O0000o02 = CoreApi.O000000o().O0000o0();
            if (!TextUtils.isEmpty(O0000o02) && !TextUtils.equals(O0000o02, "0") && !TextUtils.isEmpty(device.did)) {
                gpy.O000000o(CommonApplication.getAppContext(), "device_more_activity_red_point").edit().putBoolean(O000000o(O0000o02, device.did), false).apply();
            }
        }
    }

    public static boolean getBleGatewayRedPointStatus(Device device) {
        if (device == null) {
            return false;
        }
        String O0000o02 = CoreApi.O000000o().O0000o0();
        if (TextUtils.isEmpty(O0000o02) || TextUtils.equals(O0000o02, "0") || TextUtils.isEmpty(device.did)) {
            return false;
        }
        return gpy.O000000o(CommonApplication.getAppContext(), "device_more_activity_red_point").getBoolean(O000000o(O0000o02, device.did), true);
    }

    public void notifyRename(String str, int i) {
        Intent intent = new Intent("action.more.rename.notify");
        intent.putExtra("did", this.O000O00o);
        intent.putExtra("extra.name", str);
        intent.putExtra("extra.result", i);
        sendBroadcast(intent);
    }

    private void O00000Oo() {
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("menusItems");
        if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
            this.O00oOooO.addAll(parcelableArrayListExtra);
        }
        this.O0000oo = getIntent().getStringArrayListExtra("menus");
        this.O0000ooo = getIntent().getParcelableArrayListExtra("intents");
        ArrayList<String> arrayList = this.O0000oo;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = this.O0000oo.iterator();
            while (it.hasNext()) {
                IXmPluginHostActivity.StringMenuItem stringMenuItem = new IXmPluginHostActivity.StringMenuItem();
                stringMenuItem.name = it.next();
                this.O00oOooO.add(stringMenuItem);
            }
        }
        ArrayList<Intent> arrayList2 = this.O0000ooo;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<Intent> it2 = this.O0000ooo.iterator();
            while (it2.hasNext()) {
                Intent next = it2.next();
                IXmPluginHostActivity.IntentMenuItem intentMenuItem = new IXmPluginHostActivity.IntentMenuItem();
                intentMenuItem.name = next.getStringExtra("menu");
                intentMenuItem.intent = next;
                this.O00oOooO.add(intentMenuItem);
            }
        }
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        String stringExtra = getIntent().getStringExtra("title_name");
        if (TextUtils.isEmpty(stringExtra)) {
            textView.setText((int) R.string.setting);
        } else {
            textView.setText(stringExtra);
        }
        LayoutInflater from = LayoutInflater.from(this);
        ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList3 = this.O00oOooO;
        if (arrayList3 == null || arrayList3.size() <= 0) {
            findViewById(R.id.menu_default_title).setVisibility(8);
            findViewById(R.id.list_space).setVisibility(8);
            return;
        }
        this.O0000oo0.setVisibility(0);
        for (int i = 0; i < this.O00oOooO.size(); i++) {
            final IXmPluginHostActivity.MenuItemBase menuItemBase = this.O00oOooO.get(i);
            View view = null;
            if (menuItemBase instanceof IXmPluginHostActivity.StringMenuItem) {
                view = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
                view.findViewById(R.id.menu_arrorw).setVisibility(0);
                ((TextView) view.findViewById(R.id.menu_item)).setText(((IXmPluginHostActivity.StringMenuItem) menuItemBase).name);
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass13 */

                    public final void onClick(View view) {
                        DeviceMoreActivity deviceMoreActivity = DeviceMoreActivity.this;
                        String str = ((IXmPluginHostActivity.StringMenuItem) menuItemBase).name;
                        Intent intent = new Intent();
                        intent.putExtra("menu", str);
                        deviceMoreActivity.setResult(-1, intent);
                        deviceMoreActivity.finishPage();
                    }
                });
            } else if (menuItemBase instanceof IXmPluginHostActivity.IntentMenuItem) {
                view = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
                IXmPluginHostActivity.IntentMenuItem intentMenuItem2 = (IXmPluginHostActivity.IntentMenuItem) menuItemBase;
                ((TextView) view.findViewById(R.id.menu_item)).setText(intentMenuItem2.name);
                if (intentMenuItem2.intent == null) {
                    view.findViewById(R.id.menu_arrorw).setVisibility(4);
                } else {
                    view.findViewById(R.id.menu_arrorw).setVisibility(0);
                    view.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass14 */

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
                        public final void onClick(View view) {
                            Intent intent = ((IXmPluginHostActivity.IntentMenuItem) menuItemBase).intent;
                            int intExtra = intent.getIntExtra("target_activity", -1);
                            if (intExtra == 1) {
                                Intent intent2 = new Intent();
                                intent2.putExtras(intent);
                                hor.O000000o().startDeviceSceneNewActivity(DeviceMoreActivity.this, intent2);
                            } else if (intExtra != 2) {
                                intent.putExtra("jump_form_plugin_host", true);
                                DeviceMoreActivity.this.startActivity(intent);
                            } else {
                                PluginActivityHostApi pluginActivityHostApi = fsp.O000000o().O0000Oo;
                                DeviceMoreActivity deviceMoreActivity = DeviceMoreActivity.this;
                                pluginActivityHostApi.openOpHistoryActivity(deviceMoreActivity, deviceMoreActivity.O0000o.did);
                            }
                        }
                    });
                }
            } else if (menuItemBase instanceof IXmPluginHostActivity.SlideBtnMenuItem) {
                final IXmPluginHostActivity.SlideBtnMenuItem slideBtnMenuItem = (IXmPluginHostActivity.SlideBtnMenuItem) menuItemBase;
                view = from.inflate((int) R.layout.common_device_more_menu_slidebtn_item, (ViewGroup) null);
                TextView textView2 = (TextView) view.findViewById(R.id.menu_item);
                if (!TextUtils.isEmpty(slideBtnMenuItem.subName)) {
                    TextView textView3 = (TextView) view.findViewById(R.id.menu_subname);
                    textView3.setVisibility(0);
                    textView3.setText(slideBtnMenuItem.subName);
                }
                textView2.setText(slideBtnMenuItem.name);
                final SwitchButton switchButton = (SwitchButton) view.findViewById(R.id.menu_slide_btn);
                switchButton.setChecked(slideBtnMenuItem.isOn);
                switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass15 */

                    public final void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                        String str;
                        String str2;
                        JSONArray jSONArray;
                        if (!z || !slideBtnMenuItem.isOn) {
                            if (z) {
                                str = slideBtnMenuItem.onParams;
                                str2 = slideBtnMenuItem.onMethod;
                            } else {
                                str = slideBtnMenuItem.offParams;
                                str2 = slideBtnMenuItem.offMethod;
                            }
                            String str3 = str2;
                            try {
                                jSONArray = new JSONArray(str);
                            } catch (JSONException unused) {
                                jSONArray = new JSONArray();
                                jSONArray.put(str);
                            }
                            final XQProgressDialog xQProgressDialog = new XQProgressDialog(DeviceMoreActivity.this);
                            xQProgressDialog.setMessage(DeviceMoreActivity.this.getString(R.string.camera_waiting));
                            xQProgressDialog.show();
                            XmPluginHostApi.instance().callMethod(DeviceMoreActivity.this.O0000o.did, str3, jSONArray, new Callback<Void>() {
                                /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass15.AnonymousClass1 */

                                public final void onFailure(int i, String str) {
                                    xQProgressDialog.dismiss();
                                    switchButton.setChecked(slideBtnMenuItem.isOn);
                                    izb.O000000o(DeviceMoreActivity.this, (int) R.string.handle_error, 0).show();
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    xQProgressDialog.dismiss();
                                    slideBtnMenuItem.isOn = z;
                                }
                            }, (Parser) null);
                        }
                    }
                });
            } else if (menuItemBase instanceof IXmPluginHostActivity.BleMenuItem) {
                if (this.O00oOooO.size() == 1) {
                    this.O0000oo0.setVisibility(8);
                    findViewById(R.id.menu_default_title).setVisibility(8);
                }
                final IXmPluginHostActivity.BleMenuItem bleMenuItem = (IXmPluginHostActivity.BleMenuItem) menuItemBase;
                if ("key_firmware_click".equals(bleMenuItem.key)) {
                    this.O00000oo.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass16 */

                        public final void onClick(View view) {
                            IBleUpgradeController bleUpgrader = bleMenuItem.getBleUpgrader();
                            Intent intent = bleMenuItem.intent;
                            intent.putExtra("miio_upgrade_did", DeviceMoreActivity.this.O0000o.did);
                            intent.putExtra("miio_upgrade_pid", DeviceMoreActivity.this.O0000o.pid);
                            intent.putExtra("miio_upgrade_name", DeviceMoreActivity.this.O0000o.name);
                            try {
                                if (bleUpgrader.onPreEnterActivity(intent.getExtras())) {
                                    return;
                                }
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                            fbt fbt = new fbt(DeviceMoreActivity.this.getContext(), "BleUpgradeActivity");
                            fbt.O000000o(intent.getExtras());
                            fbs.O000000o(fbt);
                        }
                    });
                }
            } else if (menuItemBase instanceof IXmPluginHostActivity.InfoMenuItem) {
                view = from.inflate((int) R.layout.common_device_more_menu_item, (ViewGroup) null);
                ((TextView) view.findViewById(R.id.menu_item)).setText(((IXmPluginHostActivity.InfoMenuItem) menuItemBase).name);
                view.findViewById(R.id.menu_arrorw).setVisibility(4);
            }
            if (view != null) {
                this.O0000oo0.addView(view, new LinearLayout.LayoutParams(-1, getResources().getDimensionPixelOffset(R.dimen.menu_item_height)));
            }
        }
    }

    private boolean O00000o0() {
        if (!getIntent().getBooleanExtra("firmware_enable", true) || !this.O0000o.isOwner() || this.O0000o.isSubDevice() || this.O0000o.pid == Device.PID_VIRTUAL_DEVICE) {
            return false;
        }
        gtf.O000000o();
        if (!gtf.O00000Oo(this.O0000o)) {
            return true;
        }
        return false;
    }

    public void onResume() {
        super.onResume();
        if (O00000o0()) {
            if (this.O0000o.pid == Device.PID_BLUETOOTH || this.O0000o.pid == Device.PID_BLE_MESH) {
                if (!gpn.O000000o(this.O00oOooO)) {
                    IBleUpgradeController iBleUpgradeController = null;
                    Iterator<IXmPluginHostActivity.MenuItemBase> it = this.O00oOooO.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        IXmPluginHostActivity.MenuItemBase next = it.next();
                        if (next instanceof IXmPluginHostActivity.BleMenuItem) {
                            IXmPluginHostActivity.BleMenuItem bleMenuItem = (IXmPluginHostActivity.BleMenuItem) next;
                            if ("key_firmware_click".equals(bleMenuItem.key)) {
                                iBleUpgradeController = bleMenuItem.getBleUpgrader();
                                break;
                            }
                        }
                    }
                    if (iBleUpgradeController != null) {
                        try {
                            String currentVersion = iBleUpgradeController.getCurrentVersion();
                            if (TextUtils.isEmpty(currentVersion) && (this.O0000o instanceof BleMeshDevice)) {
                                currentVersion = ((BleMeshDevice) this.O0000o).mFwVersion;
                            }
                            this.O0000oO0 = fpo.O000000o(iBleUpgradeController.getLatestVersion(), currentVersion) > 0;
                        } catch (Exception e) {
                            gnk.O00000Oo(gnk.O00000Oo(e));
                        }
                    }
                }
            } else if (this.O0000o.pid != Device.PID_VIRTUAL_DEVICE && this.O0000ooO) {
                gfb.O000000o().O00000Oo(this, this.O0000o.did, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.framework.page.DeviceMoreActivity.AnonymousClass17 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        DeviceMoreActivity.this.O0000oO0 = !jSONObject.optBoolean("updating") && !jSONObject.optBoolean("isLatest");
                        jSONObject.optString("curr");
                        String optString = jSONObject.optString("latest");
                        jSONObject.optString("description");
                        DeviceMoreActivity deviceMoreActivity = DeviceMoreActivity.this;
                        deviceMoreActivity.O0000oO = optString;
                        deviceMoreActivity.O000000o();
                    }
                });
            }
        }
        O000000o();
    }

    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        finishPage();
    }

    public void finishFinal() {
        this.O0000oOO = true;
        finish();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
    }

    public void finishPage() {
        this.O0000oOO = true;
        finishFinal();
    }

    /* access modifiers changed from: protected */
    public final void O000000o() {
        this.O00000oO.setText(this.O0000o.name);
        if (this.O0000Ooo != null) {
            if (!new SharedConfig(this.f7669O000000o).O00000Oo.getBoolean("is_watch_movie", false)) {
                this.O0000Ooo.findViewById(R.id.module_a_3_return_more_new_btn).setVisibility(0);
            } else {
                this.O0000Ooo.findViewById(R.id.module_a_3_return_more_new_btn).setVisibility(8);
            }
        }
        if (this.O0000ooO) {
            View view = this.O0000O0o;
            if (view != null) {
                if (this.O0000oO0) {
                    view.setVisibility(0);
                } else {
                    view.setVisibility(8);
                }
            }
            this.O000O0Oo.setText(this.O0000o.freqFlag ? R.string.mj_open : R.string.mj_close);
            this.O00oOoOo.setText((this.O0000o.comFlag & 2) == 2 ? getString(R.string.mj_open) : getString(R.string.mj_close));
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<String> arrayList, ArrayList<Intent> arrayList2, boolean z, int i) {
        Intent intent = new Intent();
        intent.setClass(activity, DeviceMoreActivity.class);
        intent.putExtra("did", str);
        if (arrayList != null) {
            intent.putStringArrayListExtra("menus", arrayList);
        }
        intent.putExtra("useDefaultMenus", z);
        if (arrayList2 != null) {
            intent.putParcelableArrayListExtra("intents", arrayList2);
        }
        activity.startActivityForResult(intent, i);
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i) {
        Intent intent = new Intent();
        intent.setClass(activity, DeviceMoreActivity.class);
        intent.putExtra("did", str);
        if (arrayList != null) {
            intent.putParcelableArrayListExtra("menusItems", arrayList);
        }
        intent.putExtra("useDefaultMenus", z);
        activity.startActivityForResult(intent, i);
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent) {
        Intent intent2 = new Intent();
        intent2.setClass(activity, DeviceMoreActivity.class);
        intent2.putExtra("did", str);
        if (arrayList != null) {
            intent2.putParcelableArrayListExtra("menusItems", arrayList);
        }
        intent2.putExtra("useDefaultMenus", z);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        activity.startActivityForResult(intent2, i);
    }

    public static void openMoreMenu(Activity activity, String str, ArrayList<IXmPluginHostActivity.MenuItemBase> arrayList, boolean z, int i, Intent intent, String str2) {
        Intent intent2 = new Intent();
        intent2.setClass(activity, DeviceMoreActivity.class);
        intent2.putExtra("did", str);
        if (arrayList != null) {
            intent2.putParcelableArrayListExtra("menusItems", arrayList);
        }
        intent2.putExtra("useDefaultMenus", z);
        if (intent != null) {
            intent2.putExtras(intent);
        }
        intent2.putExtra("device_unbind_message_detail", str2);
        activity.startActivityForResult(intent2, i);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("finish", false)) {
            setResult(-1, intent);
            finishPage();
        }
    }
}
