package com.xiaomi.smarthome.smartconfig.initdevice;

import _m_j.cub;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fbv;
import _m_j.fcg;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.gkv;
import _m_j.gof;
import _m_j.gpy;
import _m_j.gqg;
import _m_j.grv;
import _m_j.gve;
import _m_j.gvl;
import _m_j.gvm;
import _m_j.gvn;
import _m_j.gvp;
import _m_j.gyl;
import _m_j.gzb;
import _m_j.hhl;
import _m_j.hoj;
import _m_j.hsv;
import _m_j.hsw;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hxr;
import _m_j.izb;
import _m_j.jdn;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.device.MiioDeviceV2;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.frame.plugin.runtime.activity.PluginHostActivity;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.HomeMember;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class InitShareAndMibrainActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    SwitchButton f11517O000000o;
    List<UserInfo> O00000Oo = new ArrayList();
    private int O00000o = 0;
    Map<UserInfo, Boolean> O00000o0 = new HashMap();
    private int O00000oO = 0;
    private boolean O00000oo;
    private gzb O0000O0o = new gzb(this);
    private boolean O0000OOo = false;
    private boolean O0000Oo = false;
    private boolean O0000Oo0 = false;
    private int O0000OoO = 1;
    private RecyclerView.O000000o O0000Ooo = new RecyclerView.O000000o() {
        /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass9 */

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O000000o(LayoutInflater.from(InitShareAndMibrainActivity.this.getContext()).inflate((int) R.layout.item_init_device_share, viewGroup, false));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            if (i == 0) {
                O000000o o000000o = (O000000o) o000OOo0;
                o000000o.f11530O000000o.setText(InitShareAndMibrainActivity.this.getString(R.string.init_device_add_more));
                o000000o.O00000Oo.setImageResource(R.drawable.share_add);
                o000000o.O00000o0.setBackground(null);
                o000000o.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitShareAndMibrainActivity$9$0uY50B76VN22kzy2fZ7M8qmVxHk */

                    public final void onClick(View view) {
                        InitShareAndMibrainActivity.AnonymousClass9.this.O000000o(view);
                    }
                });
                return;
            }
            UserInfo userInfo = InitShareAndMibrainActivity.this.O00000Oo.get(i);
            O000000o o000000o2 = (O000000o) o000OOo0;
            o000000o2.f11530O000000o.setText(userInfo.O00000oO);
            DeviceFactory.O000000o(o000000o2.O00000Oo, userInfo.O00000o0, (int) R.drawable.user_default);
            gyl.O000000o();
            gyl.O00000Oo(userInfo.O00000o0, o000000o2.O00000Oo, null);
            if (InitShareAndMibrainActivity.this.O00000o0.get(userInfo) == null) {
                o000000o2.O00000o0.setBackground(null);
            } else {
                o000000o2.O00000o0.setBackground(InitShareAndMibrainActivity.this.getResources().getDrawable(R.drawable.init_device_share_item_bg));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(View view) {
            if (!TextUtils.isEmpty(InitShareAndMibrainActivity.this.mCurrentHomeId)) {
                InitShareAndMibrainActivity.this.mShareType = 1;
                hsv O000000o2 = hsw.O000000o();
                InitShareAndMibrainActivity initShareAndMibrainActivity = InitShareAndMibrainActivity.this;
                O000000o2.startShareHomeActivityForResult(initShareAndMibrainActivity, initShareAndMibrainActivity.mCurrentHomeId, 101, true);
            }
            if (InitShareAndMibrainActivity.this.mDevice != null) {
                hxk hxk = hxi.O00000o;
                String str = InitShareAndMibrainActivity.this.mDevice.model;
                hxk.f952O000000o.O000000o("addplugin_deviceshare_addfamilymember", "model", str);
            }
        }

        public final int getItemCount() {
            return InitShareAndMibrainActivity.this.O00000Oo.size();
        }
    };
    public String mCurrentHomeId;
    public Device mDevice;
    public List<String> mDidList = new ArrayList();
    @BindView(6449)
    public View mDivider;
    @BindView(6425)
    public SimpleDraweeView mImgDevice;
    public XQProgressDialog mProcessDialog;
    public int mShareType = 1;
    @BindView(7416)
    public TextView mTvStep;
    @BindView(6432)
    public TextView mTxtDeviceName;
    @BindView(6586)
    public TextView mTxtNext;
    @BindView(7425)
    ViewStub vsMiSoundGatewaySwitcher;
    @BindView(7426)
    ViewStub vsShareDevice;
    @BindView(7427)
    ViewStub vsShareFamily;
    @BindView(7428)
    ViewStub vsVoiceControl;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, float):float
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, int):int
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, long):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
      _m_j.gpy.O000000o(android.content.Context, java.lang.String, java.lang.String, boolean):void */
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_init_device_share_v2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("device_id");
        if (TextUtils.isEmpty(stringExtra)) {
            this.mDidList = intent.getStringArrayListExtra("device_did_list");
            if (isMultiDeviceInit()) {
                stringExtra = this.mDidList.get(0);
            }
        }
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mDevice = fno.O000000o().O000000o(stringExtra);
        }
        if (this.mDevice == null) {
            String stringExtra2 = intent.getStringExtra("device_mac");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.mDevice = fno.O000000o().O00000o(stringExtra2);
            }
        }
        if (this.mDevice == null) {
            finish();
            return;
        }
        this.O00000o = getIntent().getIntExtra("step_count", 0);
        this.O00000oO = getIntent().getIntExtra("current_step", 3) + 1;
        this.O0000OOo = getIntent().getBooleanExtra("can_jump_mibrain", false);
        this.O0000Oo0 = getIntent().getBooleanExtra("can_show_misound_gateway_switch", false);
        this.O0000Oo = getIntent().getBooleanExtra("can_jump_share", false);
        this.O00000oo = intent.getBooleanExtra("lightGroupNeedInit", false);
        DeviceFactory.O00000Oo(this.mDevice.model, this.mImgDevice);
        gpy.O000000o(gkv.f17949O000000o, grv.O000000o(this.mDevice.model + this.mDevice.did), hoj.O000000o.f447O000000o, true);
        if (!TextUtils.isEmpty(this.mDevice.name)) {
            this.mTxtDeviceName.setText(this.mDevice.name);
        } else {
            this.mTxtDeviceName.setText("");
        }
        this.mTxtNext.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitShareAndMibrainActivity$LGzKRp8rOoDH78L942Rizs1Hfc */

            public final void onClick(View view) {
                InitShareAndMibrainActivity.this.O000000o(view);
            }
        });
        if (this.O00000o > 0) {
            this.mTvStep.setText(this.O00000oO + "/" + this.O00000o);
        } else {
            this.mTvStep.setText("");
        }
        if (this.O00000oO != this.O00000o) {
            this.mTxtNext.setBackgroundResource(R.drawable.common_button_grey_bg);
            this.mTxtNext.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
            this.mTxtNext.setText((int) R.string.next);
        } else {
            this.mTxtNext.setText((int) R.string.init_device_start_use);
            this.mTxtNext.setTextColor(getResources().getColor(R.color.mj_color_white));
            this.mTxtNext.setBackgroundResource(R.drawable.common_button_green_bg);
        }
        if (!this.O0000Oo) {
            this.mDivider.setVisibility(8);
        } else {
            this.mDivider.setVisibility(0);
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 != null) {
                this.mCurrentHomeId = O0000Oo02.getId();
                ggc.O000000o().O000000o(O0000Oo02, new fsm<LongSparseArray<HomeMember>, fso>() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass5 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        LongSparseArray longSparseArray = (LongSparseArray) obj;
                        if (longSparseArray == null || longSparseArray.size() == 0) {
                            InitShareAndMibrainActivity.this.initNoShareFamily();
                            return;
                        }
                        InitShareAndMibrainActivity.this.O00000Oo.clear();
                        for (int i = 0; i < longSparseArray.size(); i++) {
                            HomeMember homeMember = (HomeMember) longSparseArray.valueAt(i);
                            if (!(homeMember == null || homeMember.O00000o0 == null || homeMember.f8990O000000o == -1 || homeMember.f8990O000000o == 0 || homeMember.f8990O000000o == 10)) {
                                InitShareAndMibrainActivity.this.O00000Oo.add(homeMember.O00000o0);
                            }
                        }
                        if (InitShareAndMibrainActivity.this.O00000Oo.size() > 0) {
                            InitShareAndMibrainActivity.this.initHasShareFamily();
                        } else {
                            InitShareAndMibrainActivity.this.initNoShareFamily();
                        }
                    }

                    public final void onFailure(fso fso) {
                        InitShareAndMibrainActivity.this.initNoShareFamily();
                    }
                });
            }
        }
        O000000o();
        if (this.O0000Oo0 && hasXiaoaiBleGatewayDevice()) {
            View inflate = this.vsMiSoundGatewaySwitcher.inflate();
            this.f11517O000000o = (SwitchButton) inflate.findViewById(R.id.sound_gateway_swicth);
            this.f11517O000000o.setChecked(true);
            this.f11517O000000o.setOnTouchListener(new View.OnTouchListener() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1 && InitShareAndMibrainActivity.this.f11517O000000o.isChecked()) {
                        InitShareAndMibrainActivity.this.showDoubleCheckXiaoaiGatewayTipsDialog();
                    }
                    return false;
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tips);
            if (isMultiDeviceInit()) {
                if (O00000o0()) {
                    str = getString(R.string.auto_switch_misound_ble_mesh_gateway) + "  " + "icon";
                } else {
                    str = getString(R.string.auto_switch_misound_ble_gateway) + "  " + "icon";
                }
            } else if (this.mDevice.pid == Device.PID_BLE_MESH) {
                str = getString(R.string.auto_switch_misound_ble_mesh_gateway) + "  " + "icon";
            } else {
                str = getString(R.string.auto_switch_misound_ble_gateway) + "  " + "icon";
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ClickableSpan() {
                /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    InitShareAndMibrainActivity.this.showXiaoaiGatewayTipsDialog();
                }
            }, str.indexOf("icon"), str.length(), 33);
            Drawable drawable = getResources().getDrawable(R.drawable.icon_help_auto_open_ble_gateway);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            spannableString.setSpan(new hhl(drawable), str.indexOf("icon"), str.length(), 33);
            textView.setText(spannableString);
            textView.setHighlightColor(0);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void onResume() {
        super.onResume();
        if (this.O00000oO == this.O00000o) {
            this.O0000O0o.f18610O000000o = true;
        }
    }

    public void onPause() {
        super.onPause();
        if (this.O00000oO == this.O00000o) {
            this.O0000O0o.O00000Oo();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            O00000Oo();
            finish();
        } else if (i == 101) {
            hxp hxp = hxi.O00000o0;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mShareType);
            String sb2 = sb.toString();
            hxp.f957O000000o.O000000o("addplugin_deviceshare_sharesuccess", "type", sb2);
            gqg.O00000Oo((int) R.string.init_device_share_result_content);
        }
    }

    private void O000000o() {
        List<gvl> miBrainAiDevices;
        String str;
        String str2;
        List<gvp> list;
        List<gvn> list2;
        if (this.O0000OOo && (miBrainAiDevices = gve.getInstance().getMiBrainAiDevices(this.mDevice.did)) != null && miBrainAiDevices.size() != 0) {
            int i = 0;
            while (true) {
                str = null;
                if (i >= miBrainAiDevices.size()) {
                    str2 = null;
                    break;
                }
                gvm gvm = miBrainAiDevices.get(i).O00000o0;
                if (gvm != null && TextUtils.equals(this.mDevice.did, gvm.f18381O000000o) && (list = gvm.O00000Oo) != null && list.size() > 0 && (list2 = list.get(0).f18384O000000o) != null && list2.size() > 0) {
                    str2 = list2.get(0).f18382O000000o;
                    break;
                }
                i++;
            }
            if (!TextUtils.isEmpty(str2)) {
                ((TextView) this.vsVoiceControl.inflate().findViewById(R.id.mibrain_tip2)).setText(jdn.f1779O000000o + str2 + jdn.f1779O000000o);
                DeviceTagInterface.Category O00000o02 = fnn.O000000o().O00000Oo().O00000o0(this.mDevice.model);
                if (O00000o02 != null) {
                    str = O00000o02.name;
                }
                hxr hxr = hxi.O00000oO;
                String str3 = this.mDevice.model;
                if (str == null) {
                    str = "";
                }
                hxr.f958O000000o.O000000o("page_voice_end", "model", str3, "category", str);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (this.mDevice != null) {
            if (this.O0000OoO == 1) {
                hxk hxk = hxi.O00000o;
                String str = this.mDevice.model;
                hxk.f952O000000o.O000000o("addplugin_deviceshare_next", "model", str);
            } else {
                hxk hxk2 = hxi.O00000o;
                String str2 = this.mDevice.model;
                hxk2.f952O000000o.O000000o("addplugin_deviceshare_start", "model", str2);
            }
        }
        SwitchButton switchButton = this.f11517O000000o;
        if (switchButton == null || !switchButton.isChecked()) {
            doNext();
        } else if (!gof.O00000o0()) {
            gqg.O00000Oo((int) R.string.popup_select_loc_no_network);
        } else {
            Home O0000o0 = ggb.O00000Oo().O0000o0(this.mDevice.did);
            if (O0000o0 != null) {
                XQProgressDialog xQProgressDialog = this.mProcessDialog;
                if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
                    this.mProcessDialog = new XQProgressDialog(this);
                    this.mProcessDialog.setCancelable(true);
                    this.mProcessDialog.setMessage(getResources().getString(R.string.loading_open_xiaoai_ble_gateway));
                    this.mProcessDialog.show();
                }
                gve.getInstance().enableXiaoAiBleSwitch(O0000o0.getId(), "", new fsm() {
                    /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass10 */

                    public final void onSuccess(Object obj) {
                        if (InitShareAndMibrainActivity.this.mProcessDialog != null && InitShareAndMibrainActivity.this.mProcessDialog.isShowing()) {
                            InitShareAndMibrainActivity.this.mProcessDialog.dismiss();
                        }
                        InitShareAndMibrainActivity.this.doNext();
                    }

                    public final void onFailure(fso fso) {
                        if (InitShareAndMibrainActivity.this.mProcessDialog != null && InitShareAndMibrainActivity.this.mProcessDialog.isShowing()) {
                            InitShareAndMibrainActivity.this.mProcessDialog.dismiss();
                        }
                        gqg.O00000Oo((int) R.string.switch_misound_ble_gateway_fail);
                    }
                });
            }
        }
    }

    private void O00000Oo() {
        final boolean z;
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mDevice.model);
        final XQProgressHorizontalDialog O000000o2 = XQProgressHorizontalDialog.O000000o(this, getResources().getString(R.string.plugin_downloading) + O00000oO2.O0000Oo0());
        final PluginDownloadTask pluginDownloadTask = new PluginDownloadTask();
        final XQProgressDialog xQProgressDialog = new XQProgressDialog(this);
        xQProgressDialog.setCancelable(true);
        xQProgressDialog.setMessage(getResources().getString(R.string.loading_share_info));
        if (CoreApi.O000000o().O0000Oo(this.mDevice.model) == null && CoreApi.O000000o().O0000OoO(this.mDevice.model) == null) {
            z = true;
        } else {
            xQProgressDialog.show();
            z = false;
        }
        sendBroadcast(new Intent("bind_finish_openplugin"));
        PluginApi.getInstance().sendMessage(this, this.mDevice.model, 1, new Intent(), DeviceRouterFactory.getDeviceWrapper().newDeviceStat(this.mDevice), null, false, new SendMessageCallback() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass6 */
            private long O00000oo;
            private final Interpolator O0000O0o = new DecelerateInterpolator();
            private volatile ValueAnimator O0000OOo;

            public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                if (InitShareAndMibrainActivity.this.isValid()) {
                    pluginDownloadTask.O000000o(pluginDownloadTask);
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.O000000o(true);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                        xQProgressHorizontalDialog2.f9117O000000o = false;
                        xQProgressHorizontalDialog2.setCancelable(true);
                        O000000o2.show();
                        O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                            /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitShareAndMibrainActivity$6$gEQFPt71akjUm4I3nwp6dxVwxg */
                            private final /* synthetic */ PluginDownloadTask f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                InitShareAndMibrainActivity.AnonymousClass6.this.O000000o(this.f$1, dialogInterface);
                            }
                        });
                    }
                }
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(PluginDownloadTask pluginDownloadTask, DialogInterface dialogInterface) {
                CoreApi.O000000o().O000000o(InitShareAndMibrainActivity.this.mDevice.model, pluginDownloadTask);
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{java.lang.Math.min(float, float):float}
             arg types: [int, float]
             candidates:
              ClspMth{java.lang.Math.min(double, double):double}
              ClspMth{java.lang.Math.min(long, long):long}
              ClspMth{java.lang.Math.min(int, int):int}
              ClspMth{java.lang.Math.min(float, float):float} */
            private float O000000o() {
                if (this.O0000OOo == null) {
                    synchronized (this) {
                        if (this.O0000OOo == null) {
                            double min = (double) Math.min(1.0f, ((float) (System.currentTimeMillis() - this.O00000oo)) / 4000.0f);
                            Double.isNaN(min);
                            this.O0000OOo = ValueAnimator.ofFloat((float) ((min * 0.14d) + 0.85d), 0.99f);
                            this.O0000OOo.setDuration(4000L);
                            this.O0000OOo.setInterpolator(this.O0000O0o);
                            this.O0000OOo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.smartconfig.initdevice.$$Lambda$InitShareAndMibrainActivity$6$VNkG9a2jvOHgcD7HsWtWZ8K6lJs */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    InitShareAndMibrainActivity.AnonymousClass6.O000000o(XQProgressHorizontalDialog.this, valueAnimator);
                                }
                            });
                            this.O0000OOo.start();
                        }
                    }
                }
                return ((Float) this.O0000OOo.getAnimatedValue()).floatValue();
            }

            /* access modifiers changed from: private */
            public static /* synthetic */ void O000000o(XQProgressHorizontalDialog xQProgressHorizontalDialog, ValueAnimator valueAnimator) {
                if (xQProgressHorizontalDialog != null) {
                    xQProgressHorizontalDialog.O000000o(100, (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 100.0f));
                }
            }

            public final void onDownloadProgress(String str, float f) {
                if (InitShareAndMibrainActivity.this.isValid()) {
                    if (z) {
                        int i = (int) (f * 100.0f);
                        if (i >= 99) {
                            if (this.O00000oo == 0) {
                                this.O00000oo = System.currentTimeMillis();
                            }
                            i = 99;
                        }
                        if (i == 99) {
                            O000000o();
                            return;
                        }
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            double d = (double) i;
                            Double.isNaN(d);
                            xQProgressHorizontalDialog.O000000o(100, (int) (d * 0.85d));
                            return;
                        }
                        return;
                    }
                    XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                    if (xQProgressHorizontalDialog2 != null) {
                        xQProgressHorizontalDialog2.O000000o(100, (int) (f * 100.0f));
                    }
                }
            }

            public final void onDownloadSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitShareAndMibrainActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onDownloadFailure(PluginError pluginError) {
                if (InitShareAndMibrainActivity.this.isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(pluginError.O000000o(InitShareAndMibrainActivity.this.getContext()));
                }
            }

            public final void onDownloadCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitShareAndMibrainActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallSuccess(String str) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                super.onInstallSuccess(str);
                if (InitShareAndMibrainActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }

            public final void onInstallFailure(PluginError pluginError) {
                super.onInstallFailure(pluginError);
                if (InitShareAndMibrainActivity.this.isValid()) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                    if (xQProgressHorizontalDialog != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    izb.O000000o(InitShareAndMibrainActivity.this, (int) R.string.device_enter_failed, 0).show();
                }
            }

            public final void onSendSuccess(Bundle bundle) {
                if (InitShareAndMibrainActivity.this.isValid()) {
                    CommonApplication.getGlobalHandler().postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            xQProgressDialog.dismiss();
                            if (O000000o2 != null) {
                                O000000o2.dismiss();
                            }
                            InitShareAndMibrainActivity.this.finish();
                        }
                    }, 100);
                }
            }

            public final void onSendFailure(fso fso) {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitShareAndMibrainActivity.this.isValid()) {
                    if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                    gqg.O00000Oo(fso.O00000Oo);
                }
            }

            public final void onSendCancel() {
                XQProgressHorizontalDialog xQProgressHorizontalDialog;
                if (InitShareAndMibrainActivity.this.isValid() && z && (xQProgressHorizontalDialog = O000000o2) != null) {
                    xQProgressHorizontalDialog.dismiss();
                }
            }
        });
    }

    public void initHasShareFamily() {
        this.O0000OoO = 2;
        RecyclerView recyclerView = (RecyclerView) this.vsShareDevice.inflate().findViewById(R.id.family_member);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.O00000Oo.add(0, new UserInfo());
        recyclerView.setAdapter(this.O0000Ooo);
        hxp hxp = hxi.O00000o0;
        String str = this.mDevice.model;
        StringBuilder sb = new StringBuilder();
        sb.append(this.O00000Oo.size());
        String sb2 = sb.toString();
        hxp.f957O000000o.O000000o("addplugin_deviceshare_homelistshow", "model", str, "number", sb2);
    }

    public void initNoShareFamily() {
        this.O0000OoO = 1;
        View inflate = this.vsShareFamily.inflate();
        inflate.findViewById(R.id.share_family).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass7 */

            public final void onClick(View view) {
                if (!TextUtils.isEmpty(InitShareAndMibrainActivity.this.mCurrentHomeId)) {
                    InitShareAndMibrainActivity.this.mShareType = 1;
                    hsv O000000o2 = hsw.O000000o();
                    InitShareAndMibrainActivity initShareAndMibrainActivity = InitShareAndMibrainActivity.this;
                    O000000o2.startShareHomeActivityForResult(initShareAndMibrainActivity, initShareAndMibrainActivity.mCurrentHomeId, 101, true);
                }
                if (InitShareAndMibrainActivity.this.mDevice != null) {
                    hxk hxk = hxi.O00000o;
                    String str = InitShareAndMibrainActivity.this.mDevice.model;
                    hxk.f952O000000o.O000000o("addplugin_deviceshare_family", "model", str);
                }
            }
        });
        inflate.findViewById(R.id.share_device).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass8 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
             arg types: [java.lang.String, java.util.ArrayList]
             candidates:
              _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
              _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
              _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt */
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
                if (InitShareAndMibrainActivity.this.isMultiDeviceInit()) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < InitShareAndMibrainActivity.this.mDidList.size(); i++) {
                        Device O000000o2 = fno.O000000o().O000000o(InitShareAndMibrainActivity.this.mDidList.get(i));
                        if (O000000o2 != null && DeviceRouterFactory.getDeviceWrapper().canBeShared(O000000o2)) {
                            arrayList.add(InitShareAndMibrainActivity.this.mDidList.get(i));
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        InitShareAndMibrainActivity initShareAndMibrainActivity = InitShareAndMibrainActivity.this;
                        initShareAndMibrainActivity.mShareType = 2;
                        fbt fbt = new fbt(initShareAndMibrainActivity, "/share/ShareDeviceActivity");
                        fbt.O000000o("user_id", CoreApi.O000000o().O0000o0());
                        fbt.O000000o("batch_dids", (Serializable) arrayList);
                        fbt.O000000o("need_result", true);
                        fbt.O000000o(101);
                        fbs.O000000o(fbt);
                        return;
                    }
                    return;
                }
                if (InitShareAndMibrainActivity.this.mDevice != null && !TextUtils.isEmpty(InitShareAndMibrainActivity.this.mDevice.did)) {
                    InitShareAndMibrainActivity initShareAndMibrainActivity2 = InitShareAndMibrainActivity.this;
                    initShareAndMibrainActivity2.mShareType = 2;
                    fbt fbt2 = new fbt(initShareAndMibrainActivity2, "/share/ShareDeviceActivity");
                    fbt2.O000000o("user_id", CoreApi.O000000o().O0000o0());
                    fbt2.O000000o("did", InitShareAndMibrainActivity.this.mDevice.did);
                    fbt2.O000000o("need_result", true);
                    fbt2.O000000o(101);
                    fbs.O000000o(fbt2);
                }
                if (InitShareAndMibrainActivity.this.mDevice != null) {
                    hxk hxk = hxi.O00000o;
                    String str = InitShareAndMibrainActivity.this.mDevice.model;
                    hxk.f952O000000o.O000000o("addplugin_deviceshare_device", "model", str);
                }
            }
        });
        hxp hxp = hxi.O00000o0;
        String str = this.mDevice.model;
        hxp.f957O000000o.O000000o("addplugin_deviceshare_show", "model", str);
    }

    static class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        TextView f11530O000000o;
        SimpleDraweeView O00000Oo;
        View O00000o0;

        O000000o(View view) {
            super(view);
            this.f11530O000000o = (TextView) view.findViewById(R.id.name);
            this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.device_image);
            this.O00000o0 = view.findViewById(R.id.image_wrapper);
        }
    }

    public void doNext() {
        if (this.O00000oo) {
            fbt fbt = new fbt(this, "LightGroupinitActivity");
            fbt.O000000o(100);
            fbt.O000000o("did", this.mDevice.did);
            fbs.O000000o(fbt);
        } else if (isMultiDeviceInit()) {
            O000000o(this);
        } else {
            O00000Oo();
        }
    }

    public void showDoubleCheckXiaoaiGatewayTipsDialog() {
        String str;
        if (isMultiDeviceInit()) {
            if (O00000o0()) {
                str = getString(R.string.double_check_dont_open_misound_mesh_ble_gateway, new Object[]{this.mDevice.name});
            } else {
                str = getString(R.string.double_check_dont_open_misound_ble_gateway, new Object[]{this.mDevice.name});
            }
        } else if (this.mDevice.pid == Device.PID_BLE_MESH) {
            str = getString(R.string.double_check_dont_open_misound_mesh_ble_gateway, new Object[]{this.mDevice.name});
        } else {
            str = getString(R.string.double_check_dont_open_misound_ble_gateway, new Object[]{this.mDevice.name});
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(str).O00000Oo((int) R.string.dialog_ble_gateway_not_open, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (InitShareAndMibrainActivity.this.f11517O000000o != null) {
                    InitShareAndMibrainActivity.this.f11517O000000o.setChecked(false);
                }
                dialogInterface.dismiss();
            }
        }).O000000o((int) R.string.dialog_ble_gateway_open, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (InitShareAndMibrainActivity.this.f11517O000000o != null) {
                    InitShareAndMibrainActivity.this.f11517O000000o.setChecked(true);
                }
                dialogInterface.dismiss();
            }
        }).O000000o(false).O00000o();
        builder.O00000oo();
    }

    public void showXiaoaiGatewayTipsDialog() {
        String str;
        if (isMultiDeviceInit()) {
            if (O00000o0()) {
                str = getString(R.string.auto_switch_misound_ble_mesh_gateway_tips, new Object[]{this.mDevice.name});
            } else {
                str = getString(R.string.auto_switch_misound_ble_gateway_tips, new Object[]{this.mDevice.name});
            }
        } else if (this.mDevice.pid == Device.PID_BLE_MESH) {
            str = getString(R.string.auto_switch_misound_ble_mesh_gateway_tips, new Object[]{this.mDevice.name});
        } else {
            str = getString(R.string.auto_switch_misound_ble_gateway_tips, new Object[]{this.mDevice.name});
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(str).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.smartconfig.initdevice.InitShareAndMibrainActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).O00000o();
        builder.O00000oo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009f, code lost:
        if (_m_j.fpo.O000000o(r6, r8.O00000Oo) < 0) goto L_0x00a3;
     */
    public boolean hasXiaoaiBleGatewayDevice() {
        ArrayList arrayList = new ArrayList();
        Home O0000o0 = ggb.O00000Oo().O0000o0(this.mDevice.did);
        List<Device> O0000Oo2 = O0000o0 != null ? ggb.O00000Oo().O0000Oo(O0000o0.getId()) : null;
        Iterator<Map.Entry<String, Device>> it = fno.O000000o().O0000O0o().entrySet().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Device device = (Device) it.next().getValue();
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
            if (device.isOwner() && O00000oO2 != null && O00000oO2.O000O0OO() == 1 && device.voiceCtrl == 2) {
                if (device instanceof MiioDeviceV2) {
                    String str = ((MiioDeviceV2) device).mFwVersion;
                    List<fcg> list = fbv.O000000o().O00000o0;
                    if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
                        Iterator<fcg> it2 = list.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            fcg next = it2.next();
                            if (TextUtils.equals(next.f16080O000000o, device.model)) {
                            }
                        }
                    }
                }
                z = true;
                if (O0000Oo2 != null) {
                    for (Device device2 : O0000Oo2) {
                        if (device2 != null && TextUtils.equals(device2.did, device.did) && z) {
                            arrayList.add(device.did);
                        }
                    }
                }
            }
        }
        return arrayList.size() > 0;
    }

    public boolean isMultiDeviceInit() {
        List<String> list = this.mDidList;
        return list != null && list.size() > 0;
    }

    private boolean O00000o0() {
        for (int i = 0; i < this.mDidList.size(); i++) {
            Device O000000o2 = fno.O000000o().O000000o(this.mDidList.get(i));
            if (O000000o2 != null && O000000o2.pid != Device.PID_BLE_MESH) {
                return false;
            }
        }
        return true;
    }

    static void O000000o(CommonActivity commonActivity) {
        WeakReference weakReference;
        Activity activity;
        ArrayList<Activity> arrayList = new ArrayList<>();
        Activity activity2 = null;
        try {
            for (Map.Entry next : CommonApplication.getActivityStack().entrySet()) {
                if (!(next == null || (weakReference = (WeakReference) next.getValue()) == null || (activity = (Activity) weakReference.get()) == null)) {
                    arrayList.add(activity);
                    if (activity2 == null) {
                        activity2 = activity;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activity2 != null) {
            Class<?> O00000Oo2 = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
            if (O00000Oo2 != null && activity2.getClass() == O00000Oo2) {
                for (Activity activity3 : arrayList) {
                    if (activity3.getClass() != O00000Oo2 && !(activity3 instanceof PluginHostActivity)) {
                        activity3.finish();
                    }
                }
            } else if (commonActivity.isValid()) {
                commonActivity.finish();
            }
        } else if (commonActivity.isValid()) {
            commonActivity.finish();
        }
    }

    public void onBackPressed() {
        if (getIntent().getBooleanExtra("extra_backable", true)) {
            super.onBackPressed();
        }
    }
}
