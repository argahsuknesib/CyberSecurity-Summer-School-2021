package _m_j;

import _m_j.fuc;
import _m_j.gsk;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.miio.device.GeneralAPDevice;
import com.xiaomi.smarthome.miio.device.TemporaryDevice;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONObject;

@RouterService
public class fqj implements fmq {
    private static final fqj INSTANCE = new fqj();
    private fmi mDeviceHelperInternal = fmi.O000000o();

    @cug
    public static fqj provideInstance() {
        return INSTANCE;
    }

    private fqj() {
    }

    public DeviceTagInterface<Device> getDeviceTagManager() {
        return this.mDeviceHelperInternal.f16629O000000o;
    }

    public List<Device> preprocessDeviceList(Map<String, Device> map) {
        return fmi.O000000o(map);
    }

    public void updateUsableGroupInfo(List<fni> list) {
        Map<String, Device> O0000O0o;
        fmi fmi = this.mDeviceHelperInternal;
        fmi.O00000o0 = list;
        ArrayList arrayList = null;
        if (list != null && list.size() > 0 && (O0000O0o = fno.O000000o().O0000O0o()) != null && O0000O0o.size() > 0) {
            arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                fni fni = list.get(i);
                if (fni.O00000o0 != null && fni.O00000o0.length > 0 && fmi.O00000Oo(fni) >= 2) {
                    arrayList.add(fni);
                }
            }
        }
        fmi.O00000Oo = arrayList;
    }

    public String[] findDeviceIdsByGroupInfo(fni fni) {
        return fmi.O000000o(fni);
    }

    public boolean isInFilterMode() {
        return this.mDeviceHelperInternal.f16629O000000o.O000000o();
    }

    public List<Device> getLockShowDevice() {
        return fmi.O00000o0();
    }

    public void addChangeNetWorkId(int i) {
        this.mDeviceHelperInternal.O00000o = i;
    }

    public List<fni> getUsableGroups() {
        return this.mDeviceHelperInternal.O00000Oo;
    }

    public List<fni> getAllModelGroups() {
        return this.mDeviceHelperInternal.O00000o0;
    }

    public fni findVirtualGroupByModel(List<fni> list, String str) {
        return fmi.O000000o(list, str);
    }

    public int getChangeNetworkId() {
        fmi fmi = this.mDeviceHelperInternal;
        int i = fmi.O00000o;
        fmi.O00000o = -1;
        return i;
    }

    public TemporaryDevice getTemporaryDevice(String str) {
        fnp O00000oo = fnp.O00000oo();
        TemporaryDevice temporaryDevice = O00000oo.f16708O000000o.get(str);
        if (temporaryDevice != null) {
            return temporaryDevice;
        }
        TemporaryDevice temporaryDevice2 = new TemporaryDevice(str);
        O00000oo.f16708O000000o.put(str, temporaryDevice2);
        return temporaryDevice2;
    }

    public void setTemporaryDeviceShow(String str, boolean z) {
        fnp.O00000oo().O000000o(str, z);
    }

    public boolean shouldTemporaryDeviceShow(String str) {
        return fnp.O00000oo().O000000o(str);
    }

    public GeneralAPDevice newGeneralAPDevice(String str) {
        fmm.O00000oo();
        return fmm.O000000o(str);
    }

    public void addGeneralAPDevice(Device device) {
        fmm.O00000oo().O000000o(device);
    }

    public void setGeneralAPDeviceEnable(boolean z, String str) {
        fmm.O00000oo().O000000o(z, str);
    }

    public void bindMiTVDevice(Context context, MiTVDevice miTVDevice, ftt<Void> ftt) {
        String str;
        fna fna = new fna();
        fna.O00000Oo = context;
        fna.O0000OOo = miTVDevice;
        fna.O0000Oo0 = ftt;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        fna.O00000o0 = LayoutInflater.from(context).inflate((int) R.layout.mitv_login_account_view, (ViewGroup) null);
        fna.O00000o = fna.O00000o0.findViewById(R.id.login_captchacode);
        fna.O00000oO = fna.O00000o0.findViewById(R.id.login_vericode);
        fna.O00000oo = (EditText) fna.O00000o.findViewById(R.id.login_captchacode_edit);
        fna.O0000O0o = (EditText) fna.O00000oO.findViewById(R.id.login_vericode_edit);
        TextView textView = (TextView) fna.O00000o0.findViewById(R.id.account_name);
        if (miTVDevice.model.contains("tv")) {
            str = context.getString(R.string.mitv_login_account_tv_info);
        } else {
            str = context.getString(R.string.mitv_login_account_box_info);
        }
        ((TextView) fna.O00000o0.findViewById(R.id.title)).setText(context.getString(R.string.mitv_login_account_title, CoreApi.O000000o().O0000o0()));
        textView.setText(str);
        fna.O0000Ooo = (EditText) fna.O00000o0.findViewById(R.id.login_other_account_password_editor);
        fna.O0000o00 = (ToggleButton) fna.O00000o0.findViewById(R.id.login_other_account_password_toggle);
        fna.O0000o0 = fna.O00000o0.findViewById(R.id.login_other_account_login_button);
        fna.O0000o0.setEnabled(false);
        fna.O0000o00.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class _m_j.fna.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int selectionStart = fna.this.O0000Ooo.getSelectionStart();
                if (z) {
                    fna.this.O0000Ooo.setInputType(144);
                    fna.this.O0000o00.setContentDescription(fna.this.O00000o0.getContext().getString(R.string.hide_passwd));
                } else {
                    fna.this.O0000Ooo.setInputType(129);
                    fna.this.O0000o00.setContentDescription(fna.this.O00000o0.getContext().getString(R.string.show_passwd));
                }
                fna.this.O0000Ooo.setSelection(selectionStart);
            }
        });
        fna.O0000Ooo.addTextChangedListener(new TextWatcher() {
            /* class _m_j.fna.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(fna.this.O0000Ooo.getText().toString())) {
                    fna.this.O0000o0.setEnabled(false);
                } else {
                    fna.this.O0000o0.setEnabled(true);
                }
            }
        });
        fna.O0000o0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fna.AnonymousClass3 */

            public final void onClick(View view) {
                fna.this.O000000o(false);
            }
        });
        builder.O000000o(new DialogInterface.OnCancelListener(miTVDevice, ftt) {
            /* class _m_j.fna.AnonymousClass4 */

            /* renamed from: O000000o */
            final /* synthetic */ MiTVDevice f16687O000000o;
            final /* synthetic */ ftt O00000Oo;

            {
                this.f16687O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                fna.this.O000000o();
                this.f16687O000000o.setOwner(false);
                fna.this.O0000Oo = null;
                ftt ftt = this.O00000Oo;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_PERMISSION_DENIED.getCode());
                }
            }
        });
        builder.O000000o(fna.O00000o0);
        fna.O0000Oo = builder.O00000oo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0014, code lost:
        r5 = com.xiaomi.smarthome.frame.core.CoreApi.O000000o().O00000oO(r1.model);
     */
    public void startIRPlugin(Context context, Intent intent) {
        final PluginDeviceInfo O00000oO;
        Context context2 = context;
        Intent intent2 = intent;
        Device O00000Oo = fqw.O00000Oo();
        if (O00000Oo != null && !TextUtils.isEmpty(O00000Oo.model) && O00000oO != null) {
            Intent intent3 = new Intent();
            if (intent2 != null) {
                intent3.putExtras(intent2);
            }
            final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(context2, context2.getString(R.string.plugin_downloading) + O00000oO.O0000Oo0() + context2.getString(R.string.plugin));
            final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
            final Context context3 = context;
            PluginApi.getInstance().sendMessage(context, O00000Oo.model, 1, intent3, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000Oo), null, false, new SendMessageCallback() {
                /* class _m_j.fqj.AnonymousClass1 */

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    if (O000000o2 != null) {
                        Context context = context3;
                        if (context instanceof Activity) {
                            Activity activity = (Activity) context;
                            if (!activity.isFinishing()) {
                                if (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        try {
                            O000000o2.O000000o(true);
                            O000000o2.f9117O000000o = false;
                            O000000o2.setCancelable(true);
                            O000000o2.show();
                            O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                /* class _m_j.fqj.AnonymousClass1.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    CoreApi.O000000o().O000000o(O00000oO.O00000Oo(), pluginDownloadTask);
                                }
                            });
                        } catch (Exception unused) {
                        }
                    }
                }

                public final void onDownloadProgress(String str, float f) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(100, (int) (f * 100.0f));
                    }
                }

                public final void onDownloadSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    Context appContext = CommonApplication.getAppContext();
                    izb.O000000o(appContext, pluginError.O000000o(appContext), 1).show();
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }
            });
        }
    }

    public void addIrController(Activity activity, int i) {
        if (activity != null && i >= 0) {
            Intent intent = new Intent("com.xiaomi.mitv.phone.remotecontroller.main");
            intent.putExtra("call_from", "mihome");
            intent.putExtra("device_type", i);
            if (fqw.O00000Oo(CommonApplication.getAppContext(), intent)) {
                activity.startActivity(intent);
            } else {
                new MLAlertDialog.Builder(activity).O00000Oo((int) R.string.ir_hint_download_remote_controller).O000000o((int) R.string.update_install, new DialogInterface.OnClickListener(activity) {
                    /* class _m_j.$$Lambda$fqj$6XPV4a_VrMmULKhIl7P6FBJiRFs */
                    private final /* synthetic */ Activity f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        fqj.lambda$addIrController$0(this.f$0, dialogInterface, i);
                    }
                }).O00000Oo((int) R.string.sh_common_lib_cancel, $$Lambda$fqj$jjEm9RtARHByaJk1OCP1Uob8aDE.INSTANCE).O00000o().show();
            }
        }
    }

    static /* synthetic */ void lambda$addIrController$0(Activity activity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("market://details?id=com.duokan.phone.remotecontroller"));
        if (fqw.O00000Oo(CommonApplication.getAppContext(), intent)) {
            activity.startActivity(intent);
        }
        dialogInterface.dismiss();
    }

    public void bindRouterDevice(Context context, RouterDevice routerDevice, ftt<Void> ftt) {
        fnm fnm = new fnm();
        fnm.O00000o0 = context;
        fnm.O00000o = routerDevice;
        fnm.O00000oO = ftt;
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        fnm.O0000OOo = LayoutInflater.from(context).inflate((int) R.layout.router_login_account_view, (ViewGroup) null);
        fnm.O0000Oo0 = (EditText) fnm.O0000OOo.findViewById(R.id.login_other_account_password_editor);
        fnm.O0000Oo = (ToggleButton) fnm.O0000OOo.findViewById(R.id.login_other_account_password_toggle);
        fnm.O0000OoO = fnm.O0000OOo.findViewById(R.id.login_other_account_login_button);
        fnm.O0000OoO.setEnabled(false);
        fnm.O0000Oo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class _m_j.fnm.AnonymousClass1 */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                int selectionStart = fnm.this.O0000Oo0.getSelectionStart();
                if (z) {
                    fnm.this.O0000Oo0.setInputType(144);
                } else {
                    fnm.this.O0000Oo0.setInputType(129);
                }
                fnm.this.O0000Oo0.setSelection(selectionStart);
            }
        });
        fnm.O0000Oo0.addTextChangedListener(new TextWatcher() {
            /* class _m_j.fnm.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(fnm.this.O0000Oo0.getText().toString())) {
                    fnm.this.O0000OoO.setEnabled(false);
                } else {
                    fnm.this.O0000OoO.setEnabled(true);
                }
            }
        });
        fnm.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.fnm.AnonymousClass3 */

            public final void onClick(View view) {
                fnm fnm = fnm.this;
                Context context = fnm.O00000o0;
                fnm.O000000o();
                fnm.O00000Oo = XQProgressDialog.O000000o(context, "", context.getString(R.string.camera_waiting));
                String obj = fnm.O0000Oo0.getEditableText().toString();
                AnonymousClass5 r1 = new ftt<fuc.O00000Oo>() {
                    /* class _m_j.fnm.AnonymousClass5 */

                    public final /* synthetic */ void O000000o(Object obj) {
                        final fuc.O00000Oo o00000Oo = (fuc.O00000Oo) obj;
                        fnm.O000000o(o00000Oo.f17162O000000o, new ftt<String>() {
                            /* class _m_j.fnm.AnonymousClass5.AnonymousClass1 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                fuf.O000000o();
                                fuf.O000000o(CommonApplication.getAppContext(), fnm.this.O00000o.did, o00000Oo.O00000Oo, (String) obj, new fsm<Void, fso>() {
                                    /* class _m_j.fnm.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                    public final void onFailure(fso fso) {
                                        fnm.this.O000000o();
                                        izb.O000000o(fnm.this.O00000o0, (int) R.string.router_login_account_bind_error, 0).show();
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        fnm.this.O000000o();
                                        fno.O000000o().O0000o0O();
                                        Intent intent = new Intent("com.xiaomi.router");
                                        intent.putExtra("operation", "bind");
                                        intent.putExtra("userId", CoreApi.O000000o().O0000o0());
                                        intent.putExtra("sn", fnm.this.O00000o.token);
                                        intent.putExtra("id", fnm.this.O00000o.did);
                                        CommonApplication.getAppContext().sendBroadcast(intent);
                                        fnm.this.O00000o.setOwner(true);
                                        fnm.this.O00000o.userId = CoreApi.O000000o().O0000o0();
                                        RouterDevice routerDevice = fnm.this.O00000o;
                                        routerDevice.did = "miwifi." + fnm.this.O00000o.did;
                                        gwe.O000000o().O000000o(fnm.this.O00000o);
                                        if (fnm.this.O00000oo != null) {
                                            fnm.this.O00000oo.dismiss();
                                        }
                                        fnm.this.O00000oo = null;
                                        if (fnm.this.O00000oO != null) {
                                            fnm.this.O00000oO.O000000o((Object) null);
                                        }
                                    }
                                });
                            }

                            public final void O000000o(int i) {
                                fnm.this.O000000o();
                                izb.O000000o(fnm.this.O00000o0, (int) R.string.router_login_account_get_secret_error, 0).show();
                            }

                            public final void O000000o(int i, Object obj) {
                                fnm.this.O000000o();
                                izb.O000000o(fnm.this.O00000o0, (int) R.string.router_login_account_get_secret_error, 0).show();
                            }
                        });
                    }

                    public final void O000000o(int i) {
                        fnm.this.O000000o();
                        izb.O000000o(fnm.this.O00000o0, (int) R.string.router_login_account_passwd_error, 0).show();
                    }

                    public final void O000000o(int i, Object obj) {
                        fnm.this.O000000o();
                        izb.O000000o(fnm.this.O00000o0, (int) R.string.router_login_account_passwd_error, 0).show();
                    }
                };
                fuc O000000o2 = fuc.O000000o();
                CommonApplication.getAppContext();
                gsy.O000000o(3, "RemoteCameraApi", "getRouterToken");
                if (fuc.O00000Oo == null) {
                    fuc.O00000Oo = new SecureRandom();
                }
                String str = "1_" + gpk.O000000o(CommonApplication.getAppContext()) + "_" + System.currentTimeMillis() + "_" + fuc.O00000Oo.nextLong();
                String O000000o3 = fuc.O000000o(str + fuc.O000000o(obj + fuc.O00000o0));
                ArrayList arrayList = new ArrayList();
                arrayList.add(new gky("username", "admin"));
                arrayList.add(new gky("nonce", str));
                arrayList.add(new gky("password", O000000o3));
                String O00000Oo = fuc.O00000Oo();
                fuc.f17154O000000o = O00000Oo;
                if (TextUtils.isEmpty(O00000Oo)) {
                    r1.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                }
                gsg.O000000o(O000000o2.O00000o, new gsk.O000000o().O000000o("GET").O00000Oo(String.format("http://%s/cgi-bin/luci/api/xqsystem/token", fuc.f17154O000000o)).O000000o(arrayList).O000000o(), new gso(r1) {
                    /* class _m_j.fuc.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ ftt f17158O000000o;

                    {
                        this.f17158O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        O000000o((String) obj);
                    }

                    public final void O000000o(String str) {
                        gsy.O000000o(3, "RemoteCameraApi", "getRouterToken onSuccess:".concat(String.valueOf(str)));
                        try {
                            O00000Oo o00000Oo = new O00000Oo();
                            JSONObject jSONObject = new JSONObject(str);
                            o00000Oo.f17162O000000o = jSONObject.optString("token");
                            o00000Oo.O00000Oo = jSONObject.optString("name");
                            if (!TextUtils.isEmpty(o00000Oo.f17162O000000o)) {
                                if (this.f17158O000000o != null) {
                                    this.f17158O000000o.O000000o(o00000Oo);
                                }
                            } else if (this.f17158O000000o != null) {
                                this.f17158O000000o.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                            }
                        } catch (Exception unused) {
                            ftt ftt = this.f17158O000000o;
                            if (ftt != null) {
                                ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                            }
                        }
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        ftt ftt = this.f17158O000000o;
                        if (ftt != null) {
                            ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                        }
                    }
                });
            }
        });
        builder.O000000o(new DialogInterface.OnCancelListener(routerDevice, ftt) {
            /* class _m_j.fnm.AnonymousClass4 */

            /* renamed from: O000000o */
            final /* synthetic */ RouterDevice f16702O000000o;
            final /* synthetic */ ftt O00000Oo;

            {
                this.f16702O000000o = r2;
                this.O00000Oo = r3;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                fnm.this.O000000o();
                this.f16702O000000o.setOwner(false);
                fnm.this.O00000oo = null;
                ftt ftt = this.O00000Oo;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_PERMISSION_DENIED.getCode());
                }
            }
        });
        builder.O000000o(fnm.O0000OOo);
        fnm.O00000oo = builder.O00000oo();
    }
}
