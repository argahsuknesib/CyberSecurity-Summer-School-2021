package com.xiaomi.smarthome.family;

import _m_j.chu;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.frr;
import _m_j.fru;
import _m_j.frw;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.ftt;
import _m_j.fuh;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.gyl;
import _m_j.gyr;
import _m_j.gys;
import _m_j.gyt;
import _m_j.hsx;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hys;
import _m_j.hyv;
import _m_j.hzf;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.miio.db.record.ShareUserRecord;
import com.xiaomi.smarthome.miio.page.ShareDeviceDetail;
import com.xiaomi.smarthome.share.ShareActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class ShareDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    String f7326O000000o = "";
    LayoutInflater O00000Oo;
    BaseAdapter O00000o;
    LinearLayout O00000o0;
    List<UserInfo> O00000oO = new ArrayList();
    String O00000oo = "";
    View O0000O0o;
    View O0000OOo;
    private int O0000Oo = 0;
    private ArrayList<String> O0000Oo0;
    public XQProgressDialog dialog;
    public boolean isLogEnterEvent = false;
    @BindView(4925)
    View mBottomDeleteBar;
    public SparseBooleanArray mCheckedItems = new SparseBooleanArray();
    @BindView(5057)
    View mDeleteConfirm;
    public Device mDevice;
    public String mDid;
    public boolean mEditMode = false;
    public boolean mFromShareDeviceDetail;
    public AtomicBoolean mIsUpdating = new AtomicBoolean(false);
    @BindView(4964)
    ImageView mIvCancel;
    @BindView(5672)
    ImageView mIvSelectAll;
    public boolean mNeedActivityResult = false;
    public BroadcastReceiver mReceiver;
    @BindView(5678)
    TextView mSelectedCntTv;
    public gys mShareDevice = null;
    public boolean mSupportPermissionCtrl = false;
    public boolean mSupportWxShare = false;
    @BindView(5844)
    View mTopDeleteBar;
    @BindView(5407)
    ImageView manageTxt;
    public MLAlertDialog singleChoicedialog;

    public void initShareReceiver() {
        this.mReceiver = new BroadcastReceiver() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass1 */

            public final void onReceive(Context context, Intent intent) {
                if (intent != null && TextUtils.equals(intent.getAction(), "com.xiaomi.smarthome.action.SHARE_RESULT")) {
                    int intExtra = intent.getIntExtra("result_code", -2);
                    intent.getStringExtra("message");
                    if (intExtra != 0) {
                        gqg.O00000Oo((int) R.string.share_canceled);
                    } else if (ShareDeviceActivity.this.mNeedActivityResult) {
                        ShareDeviceActivity.this.finish();
                    }
                }
            }
        };
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O00000Oo = LayoutInflater.from(this);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("user_id");
        gsy.O00000o0(LogType.PLUGIN, "ShareDeviceActivity", "ShareDeviceActivity onCreate(), getMiId():" + CoreApi.O000000o().O0000o0() + " Activity Param userId:" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !stringExtra.equalsIgnoreCase(CoreApi.O000000o().O0000o0())) {
            fbt fbt = new fbt(ServiceApplication.getAppContext(), "AccountConflictActivity");
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
            finish();
            return;
        }
        this.mFromShareDeviceDetail = intent.getBooleanExtra("key_from_sharedevicedetail", false);
        if (Build.VERSION.SDK_INT >= 12) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                this.mDid = extras.getString("did", "");
            }
        } else {
            this.mDid = intent.getStringExtra("did");
        }
        String str = this.mDid;
        if (str == null || TextUtils.isEmpty(str)) {
            this.O0000Oo0 = intent.getStringArrayListExtra("batch_dids");
        } else {
            this.mDevice = fno.O000000o().O000000o(this.mDid);
        }
        if (this.mDevice == null && this.O0000Oo0 == null) {
            finish();
            return;
        }
        if (intent != null && intent.hasExtra("need_result")) {
            this.mNeedActivityResult = intent.getBooleanExtra("need_result", false);
        }
        setContentView((int) R.layout.share_device_activity);
        ButterKnife.bind(this);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass15 */

            public final void onClick(View view) {
                ShareDeviceActivity.this.finish();
                if (ShareDeviceActivity.this.mDevice != null) {
                    hxi.O00000o.f952O000000o.O000000o("plugin_deviceshare_back", new Object[0]);
                }
            }
        });
        this.manageTxt.setVisibility(this.mDevice == null ? 8 : 0);
        this.manageTxt.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass16 */

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
                hxk hxk = hxi.O00000o;
                String str = ShareDeviceActivity.this.mDevice.model;
                hxk.f952O000000o.O000000o("share_admin_entry", "model", str);
                if (ShareDeviceActivity.this.mFromShareDeviceDetail) {
                    ShareDeviceActivity.this.finish();
                } else {
                    Intent intent = new Intent();
                    intent.setClass(ShareDeviceActivity.this, ShareDeviceDetail.class);
                    intent.putExtra("did", ShareDeviceActivity.this.mDid);
                    intent.putExtra("pid", ShareDeviceActivity.this.mDevice.pid);
                    intent.putExtra("key_from_sharedeviceactivity", true);
                    ShareDeviceActivity.this.startActivity(intent);
                }
                if (ShareDeviceActivity.this.mDevice != null) {
                    hxk hxk2 = hxi.O00000o;
                    String str2 = ShareDeviceActivity.this.mDevice.model;
                    hxk2.f952O000000o.O000000o("plugin_deviceshare_edit", "model", str2);
                }
            }
        });
        this.mIvCancel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass17 */

            public final void onClick(View view) {
                ShareDeviceActivity.this.exitEditMode();
            }
        });
        this.mIvSelectAll.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass18 */

            public final void onClick(View view) {
                if (ShareDeviceActivity.this.mCheckedItems.size() == ShareDeviceActivity.this.O00000oO.size()) {
                    ShareDeviceActivity.this.unSelectAll();
                } else {
                    ShareDeviceActivity.this.selectAll();
                }
            }
        });
        this.mDeleteConfirm.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass19 */

            public final void onClick(View view) {
                ShareDeviceActivity.this.deleteSelectedUser();
            }
        });
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        Device device = this.mDevice;
        if (device != null) {
            textView.setText(getString(R.string.share_device_content_line1, new Object[]{device.name}));
        } else {
            textView.setText((int) R.string.smarthome_share_multiple_devices);
        }
        findViewById(R.id.share_friend).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ShareDeviceActivity.this.statClick("share_MI_entry");
                if (ShareDeviceActivity.this.mSupportPermissionCtrl) {
                    ShareDeviceActivity.this.O000000o((UserInfo) null);
                    return;
                }
                ShareDeviceActivity.this.shareFriend(null);
                if (ShareDeviceActivity.this.mDevice != null) {
                    hxk hxk = hxi.O00000o;
                    String str = ShareDeviceActivity.this.mDevice.model;
                    hxk.f952O000000o.O000000o("plugin_deviceshare_mi", "model", str);
                }
            }
        });
        View findViewById = findViewById(R.id.share_wx);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ShareDeviceActivity.this.statClick("share_wechat_entry");
                if (ServiceApplication.getIWXAPI().isWXAppInstalled()) {
                    ShareDeviceActivity.this.shareWX();
                    if (ShareDeviceActivity.this.mDevice != null) {
                        hxk hxk = hxi.O00000o;
                        String str = ShareDeviceActivity.this.mDevice.model;
                        hxk.f952O000000o.O000000o("plugin_deviceshare_wx", "model", str);
                        return;
                    }
                    return;
                }
                ShareDeviceActivity.this.getContext();
                gqg.O000000o(ShareDeviceActivity.this.getString(R.string.mj_wx_not_installed));
            }
        });
        if (ggb.O0000o00()) {
            findViewById.setVisibility(8);
        }
        this.O0000OOo = findViewById(R.id.share_wx);
        this.O0000OOo.setVisibility(8);
        this.O0000O0o = findViewById(R.id.last_title);
        this.O00000o0 = (LinearLayout) findViewById(R.id.last_list);
        this.O00000o = new O000000o(this, (byte) 0);
        O000000o();
        if (gwg.O000000o((Activity) this)) {
            this.mTopDeleteBar.getLayoutParams();
            int O000000o2 = hzf.O000000o(CommonApplication.getAppContext());
            this.mTopDeleteBar.getLayoutParams().height += O000000o2;
            View view = this.mTopDeleteBar;
            view.setPadding(0, view.getPaddingTop() + O000000o2, 0, 0);
            View view2 = this.mTopDeleteBar;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        this.dialog = new XQProgressDialog(this);
        this.dialog.setMessage(getString(R.string.common_device_loading));
        this.dialog.setCancelable(false);
        O00000o0();
        if (!ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            O00000Oo();
        }
        gyl.O000000o().O000000o(new ftt<ShareUserRecord>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass12 */

            public final void O000000o(int i) {
            }

            public final void O000000o(int i, Object obj) {
            }

            public final /* bridge */ /* synthetic */ void O000000o(Object obj) {
                ShareDeviceActivity.this.f7326O000000o = ((ShareUserRecord) obj).nickName;
            }
        });
        fuh.O000000o().O000000o(this, new fsm<HashMap<String, List<hsx>>, fso>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass13 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                HashMap hashMap = (HashMap) obj;
                if (ShareDeviceActivity.this.isValid()) {
                    Set<String> keySet = hashMap.keySet();
                    final ArrayList arrayList = new ArrayList();
                    for (String str : keySet) {
                        arrayList.addAll((List) hashMap.get(str));
                    }
                    ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                        /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass13.AnonymousClass1 */

                        public final void run() {
                            ShareUserRecord.batchInsert(arrayList);
                        }
                    });
                    ShareDeviceActivity.this.O000000o(false);
                }
            }
        });
    }

    public void onPause() {
        super.onPause();
        hxi.O00000o0.O0000O0o(this.mEnterTime);
        this.isLogEnterEvent = false;
    }

    public void onDestroy() {
        super.onDestroy();
        hyv.O000000o().clear();
        if (this.mReceiver != null) {
            ft.O000000o(this).O000000o(this.mReceiver);
        }
    }

    public void onBackPressed() {
        if (this.mEditMode) {
            exitEditMode();
        } else {
            super.onBackPressed();
        }
    }

    private void O00000Oo() {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Device device = this.mDevice;
        if (device != null) {
            arrayList.add(device.did);
            hashSet.add(this.mDevice.model);
            this.mShareDevice = new gys(this.mDevice);
        } else {
            ArrayList<String> arrayList2 = this.O0000Oo0;
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator<String> it = this.O0000Oo0.iterator();
                while (it.hasNext()) {
                    Device O000000o2 = fno.O000000o().O000000o(it.next());
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2.did);
                    }
                }
                if (arrayList.size() <= 1 && arrayList.size() > 0) {
                    Device O000000o3 = fno.O000000o().O000000o((String) arrayList.get(0));
                    this.mShareDevice = new gys(O000000o3);
                    hashSet.add(O000000o3.model);
                } else {
                    return;
                }
            }
        }
        hyv.O000000o().getUserInfo();
        XQProgressDialog xQProgressDialog = this.dialog;
        if (xQProgressDialog != null && !xQProgressDialog.isShowing() && isValid()) {
            this.dialog.show();
        }
        hyv.O000000o().getSupportWechatAppInfosByModel(hashSet, new fsm<gyt, fso>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass14 */

            public final /* synthetic */ void onSuccess(Object obj) {
                gyt gyt = (gyt) obj;
                if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.dialog.isShowing() && ShareDeviceActivity.this.isValid()) {
                    ShareDeviceActivity.this.dialog.dismiss();
                }
                if (gyt != null) {
                    ShareDeviceActivity.this.mSupportWxShare = gyt.f18586O000000o.get(0).O00000o0;
                }
                ShareDeviceActivity.this.O0000OOo.setVisibility(0);
                if (ShareDeviceActivity.this.mReceiver != null) {
                    ft.O000000o(ShareDeviceActivity.this).O000000o(ShareDeviceActivity.this.mReceiver);
                }
                ShareDeviceActivity.this.initShareReceiver();
                ft.O000000o(ShareDeviceActivity.this).O000000o(ShareDeviceActivity.this.mReceiver, new IntentFilter("com.xiaomi.smarthome.action.SHARE_RESULT"));
            }

            public final void onFailure(fso fso) {
                ShareDeviceActivity.this.O0000OOo.setVisibility(0);
                if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.dialog.isShowing() && ShareDeviceActivity.this.isValid()) {
                    ShareDeviceActivity.this.dialog.dismiss();
                }
            }
        });
        hyv.O000000o().getMiniProgram(this.mShareDevice);
    }

    private void O00000o0() {
        PluginDeviceInfo O00000oO2;
        boolean z = false;
        if (this.mDevice != null) {
            PluginDeviceInfo O00000oO3 = CoreApi.O000000o().O00000oO(this.mDevice.model);
            if (O00000oO3 == null) {
                chu chu = chu.O000000o.f13841O000000o;
                if (chu.O000000o(this.mDevice.model)) {
                    this.mSupportPermissionCtrl = true;
                    return;
                }
                return;
            }
            if (O00000oO3.O00oOooo() == 1) {
                z = true;
            }
            this.mSupportPermissionCtrl = z;
            return;
        }
        ArrayList<String> arrayList = this.O0000Oo0;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<String> it = this.O0000Oo0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Device O000000o2 = fno.O000000o().O000000o(it.next());
                if (O000000o2 != null && (O00000oO2 = CoreApi.O000000o().O00000oO(O000000o2.model)) != null && O00000oO2.O00oOooo() != 1) {
                    break;
                }
            }
            if (z) {
                this.mSupportPermissionCtrl = true;
            }
        }
    }

    public void statClick(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mDid)) {
            Device O000000o2 = fno.O000000o().O000000o(this.mDid);
            if (O000000o2 != null) {
                sb.append(O000000o2.model);
            }
        } else {
            ArrayList<String> arrayList = this.O0000Oo0;
            if (arrayList != null) {
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    Device O000000o3 = fno.O000000o().O000000o(it.next());
                    if (O000000o3 != null) {
                        sb.append(O000000o3.model);
                        sb.append(",");
                    }
                }
                if (sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        if (TextUtils.equals("share_MI_entry", str)) {
            hxk hxk = hxi.O00000o;
            String sb2 = sb.toString();
            hxk.f952O000000o.O000000o("share_MI_entry", "model", sb2);
        } else if (TextUtils.equals("share_wechat_entry", str)) {
            hxk hxk2 = hxi.O00000o;
            String sb3 = sb.toString();
            hxk2.f952O000000o.O000000o("share_wechat_entry", "model", sb3);
        }
    }

    public void deleteSelectedUser() {
        if (this.mCheckedItems.size() == 0) {
            gqg.O000000o((int) R.string.not_select_deleted_msg);
            return;
        }
        new MLAlertDialog.Builder(this).O000000o((int) R.string.delete_record_title).O00000Oo(getResources().getQuantityString(R.plurals.delete_record, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size()))).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                final ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < ShareDeviceActivity.this.mCheckedItems.size(); i2++) {
                    int keyAt = ShareDeviceActivity.this.mCheckedItems.keyAt(i2);
                    if (ShareDeviceActivity.this.mCheckedItems.get(keyAt) && ShareDeviceActivity.this.O00000oO.size() > keyAt) {
                        try {
                            arrayList.add(ShareDeviceActivity.this.O00000oO.get(keyAt).f7549O000000o);
                        } catch (Exception unused) {
                        }
                    }
                }
                fru.O000000o().O00000o0(arrayList, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass4.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (!jSONObject.has("code")) {
                            gqg.O00000Oo((int) R.string.smarthome_device_delete_fail);
                        } else if (jSONObject.optInt("code", -999) == 0) {
                            ShareDeviceActivity.this.mCheckedItems.clear();
                            ShareUserRecord.batchDelete(arrayList);
                            ShareDeviceActivity.this.O000000o(false);
                            ShareDeviceActivity.this.mSelectedCntTv.setVisibility(8);
                            ShareDeviceActivity.this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
                            ShareDeviceActivity.this.mIvSelectAll.setContentDescription(ShareDeviceActivity.this.getString(R.string.select_all));
                        }
                        ShareDeviceActivity.this.exitEditMode();
                    }

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo((int) R.string.smarthome_device_delete_fail);
                        ShareDeviceActivity.this.exitEditMode();
                    }
                });
            }
        }).O00000o().show();
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        if (this.O00000o != null) {
            this.O00000o0.removeAllViews();
            for (int i = 0; i < this.O00000o.getCount(); i++) {
                this.O00000o0.addView(this.O00000o.getView(i, null, this.O00000o0));
            }
            if (this.O00000o.getCount() == 0) {
                this.O0000O0o.setVisibility(8);
            } else {
                this.O0000O0o.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(boolean z) {
        if (!this.mIsDestroyed || !this.mIsUpdating.getAndSet(true)) {
            this.O00000oO.clear();
            if (z) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_user_info_list_" + CoreApi.O000000o().O0000o0(), 0);
                String str = null;
                if (sharedPreferences != null) {
                    str = sharedPreferences.getString("content", "");
                }
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        if (!jSONObject.isNull("list")) {
                            JSONArray optJSONArray = jSONObject.optJSONArray("list");
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                UserInfo O000000o2 = UserInfo.O000000o(optJSONArray.optJSONObject(i));
                                if (!TextUtils.isEmpty(O000000o2.f7549O000000o) && !TextUtils.equals(O000000o2.f7549O000000o, "-1")) {
                                    this.O00000oO.add(O000000o2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (!this.mIsDestroyed && isValid()) {
                        this.mIsUpdating.set(false);
                        return;
                    }
                    return;
                }
            }
            fru.O000000o().O00000oO(new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                        if (jSONObject.isNull("list")) {
                            ShareDeviceActivity.this.mIsUpdating.set(false);
                            return;
                        }
                        ShareDeviceActivity.this.getShareHistoryUsers(frr.O00000Oo(jSONObject));
                    }
                }

                public final void onFailure(fso fso) {
                    if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                        ShareDeviceActivity.this.mIsUpdating.set(false);
                    }
                }
            });
            O000000o();
        }
    }

    public void getShareHistoryUsers(final List<frr> list) {
        fru.O000000o().O00000Oo(this, CoreApi.O000000o().O0000o0(), new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass6 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                    if (jSONObject.isNull("result")) {
                        ShareDeviceActivity.this.mIsUpdating.set(false);
                        return;
                    }
                    List<frr> O000000o2 = frr.O000000o(jSONObject);
                    if (O000000o2.size() == 0) {
                        ShareDeviceActivity.this.mIsUpdating.set(false);
                    } else {
                        ShareDeviceActivity.this.filterRecentDelete(O000000o2, list);
                    }
                }
            }
        });
    }

    public void filterRecentDelete(List<frr> list, List<frr> list2) {
        final ArrayList arrayList = new ArrayList();
        int i = 20;
        if (list.size() <= 20) {
            i = list.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(list.get(i2).f16981O000000o);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            int size2 = list2.size() - 1;
            while (true) {
                if (size2 < 0) {
                    break;
                } else if (list.get(size).f16981O000000o.equals(list2.get(size2).f16981O000000o)) {
                    if (list.get(size).O00000Oo >= list2.get(size2).O00000Oo) {
                        arrayList2.add(list.get(size).f16981O000000o);
                    } else {
                        arrayList.remove(list.get(size).f16981O000000o);
                    }
                    list2.remove(size2);
                } else {
                    size2--;
                }
            }
        }
        if (arrayList2.size() > 0) {
            fru.O000000o().O00000o(arrayList2, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass7 */

                public final void onFailure(fso fso) {
                    if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                        ShareDeviceActivity.this.mIsUpdating.set(false);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                        ShareDeviceActivity.this.getUserInfo(arrayList);
                    }
                }
            });
        } else {
            getUserInfo(arrayList);
        }
    }

    public void getUserInfo(final List<Long> list) {
        hys.O000000o().O000000o(this, list, new fsm<List<UserInfo>, fso>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass8 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List<UserInfo> list = (List) obj;
                if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                    ShareDeviceActivity.this.mIsUpdating.set(false);
                    ShareDeviceActivity shareDeviceActivity = ShareDeviceActivity.this;
                    shareDeviceActivity.O00000oO = list;
                    shareDeviceActivity.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            ShareDeviceActivity.this.O000000o();
                        }
                    });
                    if (!ShareDeviceActivity.this.isLogEnterEvent) {
                        ShareDeviceActivity shareDeviceActivity2 = ShareDeviceActivity.this;
                        shareDeviceActivity2.isLogEnterEvent = true;
                        if (shareDeviceActivity2.mDevice != null) {
                            hxp hxp = hxi.O00000o0;
                            String str = ShareDeviceActivity.this.mDevice.model;
                            int size = list.size();
                            hxp.f957O000000o.O000000o("plugin_deviceshare_show", "model", str, "contacts_number", Integer.valueOf(size));
                        }
                    }
                }
            }

            public final void onFailure(fso fso) {
                if (!ShareDeviceActivity.this.mIsDestroyed && ShareDeviceActivity.this.isValid()) {
                    ShareDeviceActivity.this.mIsUpdating.set(false);
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        hxi.O00000o0.O0000O0o(0L);
        O000000o(true);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(UserInfo userInfo) {
        AnonymousClass9 r0 = new BaseAdapter() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass9 */

            public final int getCount() {
                return 2;
            }

            public final Object getItem(int i) {
                return null;
            }

            public final long getItemId(int i) {
                return 0;
            }

            public final View getView(int i, View view, ViewGroup viewGroup) {
                if (view == null) {
                    view = ShareDeviceActivity.this.O00000Oo.inflate((int) R.layout.share_device_permission_dialog, (ViewGroup) null);
                }
                if (i == 0) {
                    ((TextView) view.findViewById(R.id.text1)).setText((int) R.string.share_permission_can_control);
                    ((TextView) view.findViewById(R.id.text2)).setText((int) R.string.share_permission_can_control_info);
                } else {
                    ((TextView) view.findViewById(R.id.text1)).setText((int) R.string.share_permission_cannot_control);
                    ((TextView) view.findViewById(R.id.text2)).setText((int) R.string.share_permission_cannot_control_info);
                }
                return view;
            }
        };
        MLAlertDialog mLAlertDialog = this.singleChoicedialog;
        if (mLAlertDialog != null && mLAlertDialog.isShowing()) {
            this.singleChoicedialog.dismiss();
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.share_select_permission);
        builder.O000000o(r0, this.O0000Oo, new DialogInterface.OnClickListener(0, userInfo) {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass10 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ int f7328O000000o = 0;
            final /* synthetic */ UserInfo O00000Oo;

            {
                this.O00000Oo = r3;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                ShareDeviceActivity.this.selectPermission(i);
                if (ShareDeviceActivity.this.singleChoicedialog != null && ShareDeviceActivity.this.singleChoicedialog.isShowing()) {
                    dialogInterface.dismiss();
                }
                if (this.f7328O000000o == 0) {
                    ShareDeviceActivity.this.shareFriend(this.O00000Oo);
                } else {
                    ShareDeviceActivity.this.shareWX();
                }
            }
        });
        this.singleChoicedialog = builder.O00000o();
        this.singleChoicedialog.show();
    }

    public void selectPermission(int i) {
        this.O0000Oo = i;
        if (this.O0000Oo == 0) {
            this.O00000oo = "";
        } else {
            this.O00000oo = "readonly";
        }
    }

    public void shareWX() {
        gys gys = this.mShareDevice;
        if (gys == null || gys.O00000o0 == null || TextUtils.isEmpty(this.mShareDevice.O00000o0.did)) {
            gqg.O00000Oo((int) R.string.share_failed);
            return;
        }
        XQProgressDialog xQProgressDialog = this.dialog;
        if (xQProgressDialog != null && !xQProgressDialog.isShowing() && isValid()) {
            this.dialog.show();
        }
        hyv.O000000o().getShareKey(this.mShareDevice.O00000o0.did, new fsm<frw, fso>() {
            /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass11 */

            public final /* synthetic */ void onSuccess(Object obj) {
                frw frw = (frw) obj;
                if (frw == null) {
                    return;
                }
                if (frw.O00000Oo != 0 || TextUtils.isEmpty(frw.f17037O000000o)) {
                    if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.isValid() && ShareDeviceActivity.this.dialog.isShowing()) {
                        ShareDeviceActivity.this.dialog.dismiss();
                    }
                    if (!TextUtils.isEmpty(frw.O00000o0)) {
                        gqg.O00000Oo(frw.O00000o0);
                    } else {
                        gqg.O00000Oo((int) R.string.share_failed);
                    }
                } else {
                    hyv.O000000o().shareProgram(ShareDeviceActivity.this.mShareDevice, frw.f17037O000000o, ShareDeviceActivity.this.mSupportWxShare, ShareDeviceActivity.this.O00000oo == "", new gyr(ShareDeviceActivity.this.mShareDevice.O00000o0.did) {
                        /* class com.xiaomi.smarthome.family.ShareDeviceActivity.AnonymousClass11.AnonymousClass1 */

                        public final void O000000o() {
                            if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.dialog.isShowing() && ShareDeviceActivity.this.isValid()) {
                                ShareDeviceActivity.this.dialog.dismiss();
                            }
                        }

                        public final void O00000Oo() {
                            if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.dialog.isShowing() && ShareDeviceActivity.this.isValid()) {
                                ShareDeviceActivity.this.dialog.dismiss();
                            }
                            gqg.O00000Oo((int) R.string.share_failed);
                        }
                    });
                }
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.share_failed);
                if (ShareDeviceActivity.this.dialog != null && ShareDeviceActivity.this.isValid() && ShareDeviceActivity.this.dialog.isShowing()) {
                    ShareDeviceActivity.this.dialog.dismiss();
                }
            }
        });
    }

    public void shareFriend(UserInfo userInfo) {
        Intent intent = new Intent();
        intent.setClass(getContext(), ShareActivity.class);
        Bundle bundle = new Bundle();
        String str = this.mDid;
        if (str == null || TextUtils.isEmpty(str)) {
            bundle.putStringArrayList("batch_dids", this.O0000Oo0);
        } else {
            bundle.putString("did", this.mDid);
        }
        if (userInfo != null) {
            bundle.putParcelable("user_INFO", userInfo);
        }
        bundle.putString("share_type", this.O00000oo);
        bundle.putInt(ShareActivity.ARG_KEYS_FROM, ShareActivity.FROM_XIAOMI_ACCOUNT);
        bundle.putBoolean("need_result", this.mNeedActivityResult);
        intent.putExtras(bundle);
        if (this.mNeedActivityResult) {
            startActivityForResult(intent, 10001);
        } else {
            getContext().startActivity(intent);
        }
    }

    public static void openShareDeviceActivity(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setClass(activity, ShareDeviceActivity.class);
        intent.putExtra("user_id", CoreApi.O000000o().O0000o0());
        intent.putExtra("did", str);
        activity.startActivity(intent);
    }

    public static void openShareDeviceActivityForResult(Activity activity, String str, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(activity, ShareDeviceActivity.class);
        intent.putExtra("user_id", CoreApi.O000000o().O0000o0());
        intent.putExtra("did", str);
        intent.putExtra("need_result", z);
        activity.startActivityForResult(intent, i);
    }

    public static void openShareDeviceActivityForResult(Activity activity, ArrayList<String> arrayList, int i, boolean z) {
        Intent intent = new Intent();
        intent.setClass(activity, ShareDeviceActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("user_id", CoreApi.O000000o().O0000o0());
        bundle.putStringArrayList("batch_dids", arrayList);
        bundle.putBoolean("need_result", z);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, i);
    }

    class O000000o extends BaseAdapter {
        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(ShareDeviceActivity shareDeviceActivity, byte b) {
            this();
        }

        public final int getCount() {
            return ShareDeviceActivity.this.O00000oO.size();
        }

        public final Object getItem(int i) {
            return ShareDeviceActivity.this.O00000oO.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(final int i, View view, ViewGroup viewGroup) {
            final C0070O000000o o000000o;
            if (view == null) {
                view = ShareDeviceActivity.this.O00000Oo.inflate((int) R.layout.share_device_user_item, viewGroup, false);
                o000000o = new C0070O000000o(this, (byte) 0);
                o000000o.f7353O000000o = (TextView) view.findViewById(R.id.name);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.id);
                o000000o.O00000o0 = (SimpleDraweeView) view.findViewById(R.id.icon);
                o000000o.O00000o = view.findViewById(R.id.right_arrow);
                o000000o.O00000oO = (CheckBox) view.findViewById(R.id.ckb_edit_selected);
                view.setTag(o000000o);
            } else {
                o000000o = (C0070O000000o) view.getTag();
            }
            final UserInfo userInfo = ShareDeviceActivity.this.O00000oO.get(i);
            gyl.O000000o();
            gyl.O00000Oo(userInfo.O00000o0, o000000o.O00000o0, null);
            o000000o.f7353O000000o.setText(userInfo.O00000oO);
            o000000o.O00000Oo.setText(userInfo.f7549O000000o);
            if (ShareDeviceActivity.this.mEditMode) {
                o000000o.O00000o.setVisibility(8);
                o000000o.O00000oO.setVisibility(0);
                if (ShareDeviceActivity.this.mCheckedItems.get(i)) {
                    o000000o.O00000oO.setChecked(true);
                } else {
                    o000000o.O00000oO.setChecked(false);
                }
            } else {
                o000000o.O00000o.setVisibility(0);
                o000000o.O00000oO.setVisibility(8);
            }
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.family.ShareDeviceActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    int i;
                    ShareDeviceActivity shareDeviceActivity;
                    if (ShareDeviceActivity.this.mEditMode) {
                        if (ShareDeviceActivity.this.mCheckedItems.get(i)) {
                            o000000o.O00000oO.setChecked(false);
                            ShareDeviceActivity.this.mCheckedItems.delete(i);
                        } else {
                            o000000o.O00000oO.setChecked(true);
                            ShareDeviceActivity.this.mCheckedItems.put(i, true);
                        }
                        ShareDeviceActivity.this.O000000o();
                        ShareDeviceActivity.this.mSelectedCntTv.setText(ShareDeviceActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, ShareDeviceActivity.this.mCheckedItems.size(), Integer.valueOf(ShareDeviceActivity.this.mCheckedItems.size())));
                        ShareDeviceActivity.this.mIvSelectAll.setImageResource(ShareDeviceActivity.this.mCheckedItems.size() == ShareDeviceActivity.this.O00000oO.size() ? R.drawable.un_select_selector : R.drawable.all_select_selector);
                        ImageView imageView = ShareDeviceActivity.this.mIvSelectAll;
                        if (ShareDeviceActivity.this.mCheckedItems.size() == ShareDeviceActivity.this.O00000oO.size()) {
                            shareDeviceActivity = ShareDeviceActivity.this;
                            i = R.string.unselect_all;
                        } else {
                            shareDeviceActivity = ShareDeviceActivity.this;
                            i = R.string.select_all;
                        }
                        imageView.setContentDescription(shareDeviceActivity.getString(i));
                    } else if (ShareDeviceActivity.this.mSupportPermissionCtrl) {
                        ShareDeviceActivity.this.O000000o(userInfo);
                    } else {
                        ShareDeviceActivity.this.shareFriend(userInfo);
                    }
                }
            });
            view.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.xiaomi.smarthome.family.ShareDeviceActivity.O000000o.AnonymousClass2 */

                public final boolean onLongClick(View view) {
                    int i;
                    ShareDeviceActivity shareDeviceActivity;
                    ShareDeviceActivity.this.mCheckedItems.put(i, true);
                    ShareDeviceActivity.this.enterEditMode();
                    ShareDeviceActivity.this.O000000o();
                    ShareDeviceActivity.this.mSelectedCntTv.setText(ShareDeviceActivity.this.getResources().getQuantityString(R.plurals.selected_cnt_tips, ShareDeviceActivity.this.mCheckedItems.size(), Integer.valueOf(ShareDeviceActivity.this.mCheckedItems.size())));
                    ShareDeviceActivity.this.mIvSelectAll.setImageResource(ShareDeviceActivity.this.mCheckedItems.size() == ShareDeviceActivity.this.O00000oO.size() ? R.drawable.un_select_selector : R.drawable.all_select_selector);
                    ImageView imageView = ShareDeviceActivity.this.mIvSelectAll;
                    if (ShareDeviceActivity.this.mCheckedItems.size() == ShareDeviceActivity.this.O00000oO.size()) {
                        shareDeviceActivity = ShareDeviceActivity.this;
                        i = R.string.unselect_all;
                    } else {
                        shareDeviceActivity = ShareDeviceActivity.this;
                        i = R.string.select_all;
                    }
                    imageView.setContentDescription(shareDeviceActivity.getString(i));
                    return true;
                }
            });
            if (i != getCount() - 1) {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding);
            } else {
                view.setBackgroundResource(R.drawable.mj_rs_common_white_list_padding_no_left_margin);
            }
            return view;
        }

        /* renamed from: com.xiaomi.smarthome.family.ShareDeviceActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0070O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            TextView f7353O000000o;
            TextView O00000Oo;
            View O00000o;
            SimpleDraweeView O00000o0;
            CheckBox O00000oO;

            private C0070O000000o() {
            }

            /* synthetic */ C0070O000000o(O000000o o000000o, byte b) {
                this();
            }
        }
    }

    public void enterEditMode() {
        this.mEditMode = true;
        this.mSelectedCntTv.setText("");
        this.mSelectedCntTv.setVisibility(0);
        O000000o();
        this.mTopDeleteBar.setVisibility(0);
        this.mBottomDeleteBar.setVisibility(0);
        this.mTopDeleteBar.measure(0, 0);
        this.mBottomDeleteBar.measure(0, 0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTopDeleteBar, View.Y, (float) (-this.mTopDeleteBar.getMeasuredHeight()), 0.0f);
        ViewGroup viewGroup = (ViewGroup) this.mBottomDeleteBar.getParent();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBottomDeleteBar, View.Y, (float) viewGroup.getHeight(), (float) (viewGroup.getHeight() - this.mBottomDeleteBar.getMeasuredHeight()));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200L);
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.start();
    }

    public void exitEditMode() {
        this.mEditMode = false;
        O000000o();
        this.mTopDeleteBar.setVisibility(8);
        this.mBottomDeleteBar.setVisibility(8);
        this.mCheckedItems.clear();
    }

    public void selectAll() {
        int size = this.O00000oO.size();
        for (int i = 0; i < size; i++) {
            this.mCheckedItems.put(i, true);
        }
        this.mIvSelectAll.setImageResource(R.drawable.un_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.unselect_all));
        O000000o();
        this.mSelectedCntTv.setText(getResources().getQuantityString(R.plurals.selected_cnt_tips, this.mCheckedItems.size(), Integer.valueOf(this.mCheckedItems.size())));
    }

    public void unSelectAll() {
        this.mCheckedItems.clear();
        this.mIvSelectAll.setImageResource(R.drawable.all_select_selector);
        this.mIvSelectAll.setContentDescription(getString(R.string.select_all));
        O000000o();
        this.mSelectedCntTv.setText((int) R.string.selected_0_cnt_tips);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 10001 && this.mNeedActivityResult) {
            setResult(-1);
            finish();
        }
    }
}
