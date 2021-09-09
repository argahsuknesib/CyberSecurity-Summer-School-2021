package com.xiaomi.smarthome.multikey;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.ggb;
import _m_j.gno;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gqr;
import _m_j.gsy;
import _m_j.gve;
import _m_j.gzb;
import _m_j.gzo;
import _m_j.hlz;
import _m_j.izb;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.frame.plugin.SendMessageCallback;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressHorizontalDialog;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.multikey.PowerMultikeyActivity;
import com.xiaomi.smarthome.multikey.PowerMultikeyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PowerMultikeyActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    ArrayList<PowerMultikeyBean> f10055O000000o = new ArrayList<>();
    private XQProgressDialog O00000Oo;
    private int O00000o;
    private gzo O00000o0 = new gzo();
    private boolean O00000oO = false;
    private boolean O00000oo = false;
    private int O0000O0o = 0;
    private int O0000OOo = 2;
    public SimpleDraweeView deviceImg;
    public O00000Oo mAdapter;
    public gzb mControl = new gzb(this);
    public Device mDevice;
    public HashMap<String, PowerMultikeyBean> mDeviceInfo;
    public ArrayList<PowerMultikeyBean> mFailCache = new ArrayList<>();
    public boolean mNeedInit;
    public byte mRequest;
    @BindView(5407)
    View mReturnBtn;
    @BindView(5416)
    ImageView mRightImage;
    @BindView(5718)
    TextView mSkipTv;
    @BindView(5757)
    TextView mStepTv;
    public ArrayList<PowerMultikeyBean> mTemplate;
    @BindView(5411)
    public TextView mTitleTv;
    public int mUpdateState = 0;
    @BindView(5588)
    RecyclerView recycle_view;
    @BindView(5825)
    View titleBar;

    public interface O000000o {
        void onItemClick(List<PowerMultikeyBean> list, int i);
    }

    public static void startActivity(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, PowerMultikeyActivity.class);
        intent.putExtra("from", 1);
        intent.putExtra("device_id", str);
        intent.putExtra("device_mac", str2);
        activity.startActivityForResult(intent, i);
    }

    public static void startActivity(Activity activity, String str, String str2) {
        startActivity(activity, str, str2, -1);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public void onCreate(Bundle bundle) {
        View view;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_powermultikey);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.O00000o = intent.getIntExtra("from", 0);
        String stringExtra = intent.getStringExtra("device_id");
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
        } else if (!fno.O000000o().O0000o00() || this.mDevice != null) {
            PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mDevice.model);
            gve.getInstance().syncMiBrainDeviceIfNeed(stringExtra, false, null);
            this.mTitleTv.setText((int) R.string.multikey_title);
            if (1 == this.O00000o) {
                this.mStepTv.setVisibility(8);
                this.mSkipTv.setVisibility(8);
                view = View.inflate(this, R.layout.header_powermultikey, null);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, Math.max((int) (((float) gpc.O000000o()) / 2.5f), gpc.O000000o(200.0f))));
                this.deviceImg = (SimpleDraweeView) view.findViewById(R.id.device_img);
                this.mReturnBtn.setVisibility(0);
                this.mReturnBtn.setOnClickListener(this);
            } else {
                this.mReturnBtn.setVisibility(8);
                view = View.inflate(this, R.layout.header_powermultikey_bind, null);
                view.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
                DeviceFactory.O00000Oo(this.mDevice.model, (SimpleDraweeView) view.findViewById(R.id.device_img));
                this.O0000O0o = getIntent().getIntExtra("step_count", 0);
                this.O0000OOo = getIntent().getIntExtra("current_step", 1) + 1;
                this.O00000oO = getIntent().getBooleanExtra("can_jump_share", false);
                this.O00000oo = getIntent().getBooleanExtra("can_jump_mibrain", false);
                if (this.O0000O0o > 0) {
                    TextView textView = this.mStepTv;
                    textView.setText(this.O0000OOo + "/" + this.O0000O0o);
                }
            }
            TextView textView2 = (TextView) view.findViewById(R.id.device_name);
            if (!TextUtils.isEmpty(this.mDevice.name)) {
                textView2.setText(this.mDevice.name);
            } else if (O00000oO2 != null) {
                textView2.setText(O00000oO2.O0000Oo0());
            }
            this.titleBar.setBackground(null);
            this.mRightImage.setVisibility(0);
            this.mRightImage.setImageResource(R.drawable.std_titlebar_icon_help_selector);
            this.mRightImage.setOnClickListener(this);
            this.mSkipTv.setOnClickListener(this);
            this.recycle_view.setLayoutManager(new LinearLayoutManager(this));
            this.mAdapter = new O00000Oo(this, this.f10055O000000o);
            gqr gqr = new gqr(this.mAdapter);
            gqr.O000000o(view);
            this.recycle_view.setAdapter(gqr);
            gzo gzo = this.O00000o0;
            String str = this.mDevice.did;
            AnonymousClass1 r12 = new fsm<HashMap<String, PowerMultikeyBean>, fso>() {
                /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass1 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    HashMap<String, PowerMultikeyBean> hashMap = (HashMap) obj;
                    PowerMultikeyActivity.this.dismissDialog();
                    if (hashMap == null || hashMap.size() == 0) {
                        PowerMultikeyActivity powerMultikeyActivity = PowerMultikeyActivity.this;
                        powerMultikeyActivity.mRequest = (byte) (powerMultikeyActivity.mRequest | 1);
                        PowerMultikeyActivity.this.initWithTemplate();
                        return;
                    }
                    PowerMultikeyActivity powerMultikeyActivity2 = PowerMultikeyActivity.this;
                    powerMultikeyActivity2.mDeviceInfo = hashMap;
                    powerMultikeyActivity2.updateItem();
                    PowerMultikeyActivity powerMultikeyActivity3 = PowerMultikeyActivity.this;
                    powerMultikeyActivity3.mRequest = (byte) (powerMultikeyActivity3.mRequest | 2);
                    PowerMultikeyActivity.this.initWithTemplate();
                }

                public final void onFailure(fso fso) {
                    PowerMultikeyActivity.this.dismissDialog();
                    gqg.O00000Oo((int) R.string.loading_failed);
                    PowerMultikeyActivity.this.finishPage(null);
                }
            };
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("get_sub_relation", true);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(str);
                jSONObject.put("dids", jSONArray);
            } catch (JSONException e) {
                Log.e("PowerMultikeyApi", "requestDeviceinfo", e);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/deviceinfo").O000000o(arrayList).O000000o(), new fss<HashMap<String, PowerMultikeyBean>>() {
                /* class _m_j.gzo.AnonymousClass1 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    JSONObject optJSONObject;
                    HashMap hashMap = new HashMap();
                    JSONArray optJSONArray = jSONObject.optJSONArray("list");
                    if (!(optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0).optJSONObject("member_ship")) == null)) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, PowerMultikeyBean.O000000o(optJSONObject.optJSONObject(next)));
                        }
                    }
                    return hashMap;
                }
            }, Crypto.RC4, r12);
            gzo gzo2 = this.O00000o0;
            Device device = this.mDevice;
            AnonymousClass2 r9 = new fsm<PowerMultikeyBean.O000000o, fso>() {
                /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass2 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    PowerMultikeyBean.O000000o o000000o = (PowerMultikeyBean.O000000o) obj;
                    if (PowerMultikeyActivity.this.deviceImg != null) {
                        if (TextUtils.isEmpty(o000000o.O00000Oo)) {
                            PowerMultikeyActivity.this.requestImage();
                        } else {
                            PowerMultikeyActivity.this.deviceImg.setImageURI(o000000o.O00000Oo);
                        }
                    }
                    PowerMultikeyActivity.this.mTemplate = o000000o.f10067O000000o;
                    PowerMultikeyActivity.this.f10055O000000o.clear();
                    PowerMultikeyActivity.this.f10055O000000o.addAll(PowerMultikeyActivity.this.mTemplate);
                    PowerMultikeyActivity.this.updateItem();
                    PowerMultikeyActivity powerMultikeyActivity = PowerMultikeyActivity.this;
                    powerMultikeyActivity.mRequest = (byte) (powerMultikeyActivity.mRequest | 4);
                    PowerMultikeyActivity.this.initWithTemplate();
                }

                public final void onFailure(fso fso) {
                    PowerMultikeyActivity powerMultikeyActivity = PowerMultikeyActivity.this;
                    powerMultikeyActivity.mRequest = (byte) (powerMultikeyActivity.mRequest | 8);
                    PowerMultikeyActivity.this.initWithTemplate();
                }
            };
            ArrayList arrayList2 = new ArrayList();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("model", device.model);
                jSONObject2.put("did", device.did);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            arrayList2.add(new KeyValuePair("data", jSONObject2.toString()));
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/multi_button_template").O000000o(arrayList2).O000000o(), new fss<PowerMultikeyBean.O000000o>() {
                /* class _m_j.gzo.AnonymousClass4 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return new PowerMultikeyBean.O000000o(PowerMultikeyBean.O000000o(jSONObject.optJSONArray("members")), jSONObject.optString("page_pic"));
                }
            }, Crypto.RC4, r9);
        } else {
            finish();
        }
    }

    public void finishPage(ArrayList<PowerMultikeyBean> arrayList) {
        JSONObject jSONObject = new JSONObject();
        if (arrayList != null) {
            Iterator<PowerMultikeyBean> it = arrayList.iterator();
            while (it.hasNext()) {
                PowerMultikeyBean next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("id", next.f10066O000000o);
                    jSONObject2.put("name", next.O00000o);
                    jSONObject2.put("icon", next.O00000oO);
                    jSONObject2.put("home_id", next.O00000o0);
                    jSONObject2.put("room_id", next.O00000Oo);
                    jSONObject2.put("ai_desc", next.O00000oo);
                    jSONObject.put(next.f10066O000000o, jSONObject2);
                } catch (JSONException e) {
                    gsy.O00000Oo(LogType.GENERAL, "PowerMultikeyActivity", Log.getStackTraceString(e));
                }
            }
        }
        setResult((arrayList == null || arrayList.isEmpty()) ? 0 : -1, new Intent().putExtra("extra_list_entity", jSONObject.toString()));
        super.onBackPressed();
    }

    public void updateItem() {
        if (this.mDeviceInfo != null) {
            Iterator<PowerMultikeyBean> it = this.f10055O000000o.iterator();
            while (it.hasNext()) {
                PowerMultikeyBean next = it.next();
                PowerMultikeyBean powerMultikeyBean = this.mDeviceInfo.get(next.f10066O000000o);
                next.O00000o = powerMultikeyBean.O00000o;
                next.O00000o0 = powerMultikeyBean.O00000o0;
                next.O00000Oo = powerMultikeyBean.O00000Oo;
                next.O00000oO = powerMultikeyBean.O00000oO;
                next.O00000oo = powerMultikeyBean.O00000oo;
            }
        }
        this.mAdapter.notifyDataSetChanged();
    }

    public void initWithTemplate() {
        String str;
        byte b = this.mRequest;
        if (b == 5) {
            try {
                Room O0000o00 = ggb.O00000Oo().O0000o00(this.mDevice.did);
                String O0000OOo2 = ggb.O00000Oo().O0000OOo();
                this.f10055O000000o.clear();
                for (int i = 0; i < this.mTemplate.size(); i++) {
                    PowerMultikeyBean powerMultikeyBean = this.mTemplate.get(i);
                    if (O0000o00 == null) {
                        str = O0000OOo2;
                    } else {
                        str = O0000o00.getId();
                    }
                    powerMultikeyBean.O00000Oo = str;
                    powerMultikeyBean.O00000o0 = O0000OOo2;
                    if (TextUtils.isEmpty(powerMultikeyBean.O00000o)) {
                        powerMultikeyBean.O00000o = gzo.O000000o(this.f10055O000000o, i);
                    }
                    this.f10055O000000o.add(powerMultikeyBean);
                }
            } catch (Exception unused) {
                gqg.O00000Oo((int) R.string.sh_common_no_info);
                finishPage(null);
            }
            if (("lumi.ctrl_neutral2.v1".equals(this.mDevice.model) || "llumi.ctrl_ln2.v1".equals(this.mDevice.model) || "lumi.ctrl_ln2.aq1".equals(this.mDevice.model)) && !TextUtils.isEmpty(this.mDevice.name)) {
                String[] split = this.mDevice.name.split("/");
                if (split.length == 2 && this.f10055O000000o.size() >= 2) {
                    int length = split.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f10055O000000o.get(i2).O00000o = split[i2];
                    }
                }
            }
            this.mAdapter.notifyDataSetChanged();
            this.O00000o0.O000000o(this.mDevice.did, this.f10055O000000o, new fsm<String, fso>() {
                /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass3 */

                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                }

                public final void onFailure(fso fso) {
                    PowerMultikeyActivity.this.mNeedInit = true;
                }
            });
        } else if (b == 9) {
            gqg.O00000Oo((int) R.string.no_data_tips);
            finishPage(null);
        } else if (b == 10) {
            gqg.O00000Oo((int) R.string.no_data_tips);
            finishPage(null);
        }
    }

    public void requestImage() {
        Device device = this.mDevice;
        hlz.O000000o(device.model, new fsm<hlz.O000000o, fso>() {
            /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                PowerMultikeyActivity.this.deviceImg.setImageURI(((hlz.O000000o) obj).f19057O000000o);
            }

            public final void onFailure(fso fso) {
                DeviceFactory.O00000Oo(PowerMultikeyActivity.this.mDevice.model, PowerMultikeyActivity.this.deviceImg);
            }
        });
    }

    public void requestUpdate(final ArrayList<PowerMultikeyBean> arrayList) {
        boolean z;
        if (this.mFailCache.size() != 0) {
            Iterator<PowerMultikeyBean> it = this.mFailCache.iterator();
            while (it.hasNext()) {
                PowerMultikeyBean next = it.next();
                Iterator<PowerMultikeyBean> it2 = arrayList.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next().f10066O000000o.equals(next.f10066O000000o)) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            this.mFailCache.clear();
        }
        AnonymousClass5 r0 = new fsm<String, fso>() {
            /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass5 */

            public final void onFailure(fso fso) {
                PowerMultikeyActivity.this.dismissDialog();
                if (PowerMultikeyActivity.this.mUpdateState == 3) {
                    gqg.O00000Oo((int) R.string.save_fail);
                    PowerMultikeyActivity.this.finishPage(null);
                } else {
                    if (PowerMultikeyActivity.this.mUpdateState == 2) {
                        gqg.O00000Oo((int) R.string.save_fail);
                    }
                    PowerMultikeyActivity.this.mFailCache.addAll(arrayList);
                }
                PowerMultikeyActivity.this.mUpdateState = 0;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                PowerMultikeyActivity.this.dismissDialog();
                PowerMultikeyActivity powerMultikeyActivity = PowerMultikeyActivity.this;
                powerMultikeyActivity.mNeedInit = false;
                if (powerMultikeyActivity.mUpdateState == 2) {
                    PowerMultikeyActivity.this.goNext();
                } else if (PowerMultikeyActivity.this.mUpdateState == 3) {
                    PowerMultikeyActivity powerMultikeyActivity2 = PowerMultikeyActivity.this;
                    powerMultikeyActivity2.finishPage(powerMultikeyActivity2.f10055O000000o);
                }
                PowerMultikeyActivity.this.mUpdateState = 0;
            }
        };
        if (this.mNeedInit) {
            Iterator<PowerMultikeyBean> it3 = this.f10055O000000o.iterator();
            while (it3.hasNext()) {
                PowerMultikeyBean next2 = it3.next();
                Iterator<PowerMultikeyBean> it4 = arrayList.iterator();
                boolean z2 = false;
                while (it4.hasNext()) {
                    if (TextUtils.equals(it4.next().f10066O000000o, next2.f10066O000000o)) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    arrayList.add(next2);
                }
            }
            gsy.O00000Oo("PowerMultikeyActivity", "requestInit" + this.mUpdateState);
            if (this.mUpdateState == 0) {
                this.mUpdateState = 1;
            }
            this.O00000o0.O000000o(this.mDevice.did, arrayList, r0);
            return;
        }
        int i = this.mUpdateState;
        if (i == 2) {
            if (arrayList.size() == 0) {
                goNext();
                gsy.O00000Oo("PowerMultikeyActivity", "goNext" + this.mUpdateState);
                return;
            }
            gsy.O00000Oo("PowerMultikeyActivity", "requestUpdate" + this.mUpdateState);
            O000000o();
            this.O00000o0.O00000Oo(this.mDevice.did, arrayList, r0);
        } else if (i != 3) {
            gsy.O00000Oo("PowerMultikeyActivity", "requestUpdate" + this.mUpdateState);
            this.mUpdateState = 1;
            this.O00000o0.O00000Oo(this.mDevice.did, arrayList, r0);
        } else if (arrayList.size() == 0) {
            finishPage(this.O00000o0.f18628O000000o ? this.f10055O000000o : null);
            gsy.O00000Oo("PowerMultikeyActivity", "onBackPressed" + this.mUpdateState);
        } else {
            gsy.O00000Oo("PowerMultikeyActivity", "requestUpdate" + this.mUpdateState);
            O000000o();
            this.O00000o0.O00000Oo(this.mDevice.did, arrayList, r0);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (id == R.id.module_a_3_right_iv_setting_btn) {
            MLAlertDialog O00000oO2 = new MLAlertDialog.Builder(this).O00000Oo((int) R.string.multikey_device_tip).O000000o((int) R.string.confirm, (DialogInterface.OnClickListener) null).O000000o((int) R.string.multikey_title).O00000oO();
            O00000oO2.show();
            View findViewById = O00000oO2.findViewById(R.id.message);
            if (findViewById instanceof TextView) {
                ((TextView) findViewById).setGravity(3);
            }
        } else if (id == R.id.skip) {
            int i = this.mUpdateState;
            if (i == 0) {
                this.mUpdateState = 2;
                requestUpdate(new ArrayList());
            } else if (i == 1) {
                this.mUpdateState = 2;
                O000000o();
            }
        }
    }

    public void onBackPressed() {
        if (1 == this.O00000o) {
            int i = this.mUpdateState;
            if (i == 0) {
                this.mUpdateState = 3;
                requestUpdate(new ArrayList());
            } else if (i == 1) {
                this.mUpdateState = 3;
                O000000o();
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2 && 11 == i && intent != null) {
            int intExtra = intent.getIntExtra("extra_position", 0);
            PowerMultikeyBean powerMultikeyBean = (PowerMultikeyBean) intent.getParcelableExtra("extra_entity");
            if (intExtra < this.f10055O000000o.size() && powerMultikeyBean != null && !powerMultikeyBean.equals(this.f10055O000000o.get(intExtra))) {
                if (TextUtils.isEmpty(powerMultikeyBean.O00000o)) {
                    powerMultikeyBean.O00000o = gzo.O000000o(this.f10055O000000o, intExtra);
                }
                this.f10055O000000o.set(intExtra, powerMultikeyBean);
                this.mAdapter.notifyItemChanged(intExtra);
                ArrayList arrayList = new ArrayList();
                arrayList.add(powerMultikeyBean);
                requestUpdate(arrayList);
            }
        }
    }

    public void goNext() {
        fbt fbt;
        final boolean z;
        if (this.O00000oO) {
            fbt = new fbt(this, "initShareAndMibrainActivity");
        } else {
            fbt = this.O00000oo ? new fbt(this, "initShareAndMibrainActivity") : null;
        }
        if (fbt != null) {
            fbt.O000000o(getIntent().getExtras());
            fbt.O000000o("current_step", this.O0000OOo);
            fbs.O000000o(fbt);
            finish();
            return;
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(this.mDevice.model);
        if (O00000oO2 != null) {
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
                /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.AnonymousClass6 */
                private long O00000oo;
                private final Interpolator O0000O0o = new DecelerateInterpolator();
                private volatile ValueAnimator O0000OOo;

                public final void onDownloadStart(String str, PluginDownloadTask pluginDownloadTask) {
                    if (PowerMultikeyActivity.this.isValid()) {
                        pluginDownloadTask.O000000o(pluginDownloadTask);
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.O000000o(true);
                            XQProgressHorizontalDialog xQProgressHorizontalDialog2 = O000000o2;
                            xQProgressHorizontalDialog2.f9117O000000o = false;
                            xQProgressHorizontalDialog2.setCancelable(true);
                            O000000o2.show();
                            O000000o2.setOnCancelListener(new DialogInterface.OnCancelListener(pluginDownloadTask) {
                                /* class com.xiaomi.smarthome.multikey.$$Lambda$PowerMultikeyActivity$6$srMvDhNzT3bS6I0DqUhinDTUxAY */
                                private final /* synthetic */ PluginDownloadTask f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    PowerMultikeyActivity.AnonymousClass6.this.O000000o(this.f$1, dialogInterface);
                                }
                            });
                        }
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O000000o(PluginDownloadTask pluginDownloadTask, DialogInterface dialogInterface) {
                    CoreApi.O000000o().O000000o(PowerMultikeyActivity.this.mDevice.model, pluginDownloadTask);
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
                                    /* class com.xiaomi.smarthome.multikey.$$Lambda$PowerMultikeyActivity$6$oyS16jdrBLzEazNo7So0TZ8K_s */

                                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                        PowerMultikeyActivity.AnonymousClass6.O000000o(XQProgressHorizontalDialog.this, valueAnimator);
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
                    if (PowerMultikeyActivity.this.isValid()) {
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
                    if (PowerMultikeyActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onDownloadFailure(PluginError pluginError) {
                    if (PowerMultikeyActivity.this.isValid()) {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                        izb.O000000o(PowerMultikeyActivity.this, (int) R.string.device_enter_failed, 0).show();
                    }
                }

                public final void onDownloadCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (PowerMultikeyActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onInstallSuccess(String str) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    super.onInstallSuccess(str);
                    if (PowerMultikeyActivity.this.isValid() && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }

                public final void onInstallFailure(PluginError pluginError) {
                    super.onInstallFailure(pluginError);
                    if (PowerMultikeyActivity.this.isValid()) {
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                        izb.O000000o(PowerMultikeyActivity.this, (int) R.string.device_enter_failed, 0).show();
                    }
                }

                public final void onSendSuccess(Bundle bundle) {
                    if (PowerMultikeyActivity.this.isValid()) {
                        xQProgressDialog.dismiss();
                        XQProgressHorizontalDialog xQProgressHorizontalDialog = O000000o2;
                        if (xQProgressHorizontalDialog != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                        PowerMultikeyActivity.this.mControl.O000000o();
                    }
                }

                public final void onSendFailure(fso fso) {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (PowerMultikeyActivity.this.isValid()) {
                        if (z && (xQProgressHorizontalDialog = O000000o2) != null) {
                            xQProgressHorizontalDialog.dismiss();
                        }
                        izb.O000000o(PowerMultikeyActivity.this, (int) R.string.device_enter_failed, 0).show();
                    }
                }

                public final void onSendCancel() {
                    XQProgressHorizontalDialog xQProgressHorizontalDialog;
                    if (PowerMultikeyActivity.this.isValid() && z && (xQProgressHorizontalDialog = O000000o2) != null) {
                        xQProgressHorizontalDialog.dismiss();
                    }
                }
            });
        }
    }

    public void dismissDialog() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.O00000Oo.dismiss();
        }
    }

    private void O000000o() {
        XQProgressDialog xQProgressDialog = this.O00000Oo;
        if (xQProgressDialog == null || !xQProgressDialog.isShowing()) {
            this.O00000Oo = new XQProgressDialog(this);
            this.O00000Oo.setCancelable(true);
            this.O00000Oo.setMessage(getResources().getString(R.string.loading_share_info));
            this.O00000Oo.show();
        }
    }

    public static class O00000Oo extends RecyclerView.O000000o<O00000o0> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final PowerMultikeyActivity f10062O000000o;
        public final List<PowerMultikeyBean> O00000Oo;
        private final Typeface O00000o = gno.O000000o(CommonApplication.getAppContext(), "fonts/MI-LANTING--GBK1-Thin.ttf");
        public O000000o O00000o0;

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
            O00000o0 o00000o0 = (O00000o0) o000OOo0;
            final PowerMultikeyBean powerMultikeyBean = this.O00000Oo.get(i);
            final String O000000o2 = gzo.O000000o(this.O00000Oo, i);
            o00000o0.f10064O000000o.setText(O000000o2);
            o00000o0.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.multikey.PowerMultikeyActivity.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    if (O00000Oo.this.O00000o0 != null) {
                        O00000Oo.this.O00000o0.onItemClick(O00000Oo.this.O00000Oo, i);
                        return;
                    }
                    O00000Oo.this.f10062O000000o.startActivityForResult(new Intent(O00000Oo.this.f10062O000000o, PowerItemkeyActivity.class).putExtra("extra_title", O000000o2).putExtra("extra_entity", powerMultikeyBean).putExtra("extra_position", i).putExtras(O00000Oo.this.f10062O000000o.getIntent()), 11);
                }
            });
        }

        public O00000Oo(PowerMultikeyActivity powerMultikeyActivity, List<PowerMultikeyBean> list) {
            this.f10062O000000o = powerMultikeyActivity;
            this.O00000Oo = list;
        }

        public final int getItemCount() {
            List<PowerMultikeyBean> list = this.O00000Oo;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new O00000o0(View.inflate(this.f10062O000000o, R.layout.item_powermultikey, null));
        }
    }

    static class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public final TextView f10064O000000o;

        public O00000o0(View view) {
            super(view);
            this.f10064O000000o = (TextView) view.findViewById(R.id.txt_device_name);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.O0000OOo == this.O0000O0o) {
            this.mControl.f18610O000000o = true;
        }
    }

    public void onPause() {
        super.onPause();
        if (this.O0000OOo == this.O0000O0o) {
            this.mControl.O00000Oo();
        }
    }
}
