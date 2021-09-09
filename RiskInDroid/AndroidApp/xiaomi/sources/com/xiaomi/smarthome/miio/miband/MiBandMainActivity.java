package com.xiaomi.smarthome.miio.miband;

import _m_j.ezk;
import _m_j.fno;
import _m_j.frj;
import _m_j.ftt;
import _m_j.ftu;
import _m_j.gky;
import _m_j.gof;
import _m_j.goq;
import _m_j.gsg;
import _m_j.gsk;
import _m_j.gso;
import _m_j.gsy;
import _m_j.gxd;
import _m_j.gxe;
import _m_j.gxg;
import _m_j.gxj;
import _m_j.gxk;
import _m_j.gxl;
import _m_j.gxm;
import _m_j.gxo;
import _m_j.gxp;
import _m_j.izb;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RouterService
public class MiBandMainActivity extends BaseWhiteActivity {
    private List<Fragment> fragmentList;
    gxp.O000000o listener = new gxp.O000000o() {
        /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass3 */

        public final void O000000o() {
            if (MiBandMainActivity.this.mDeviceAdapter != null) {
                MiBandMainActivity.this.mHandler.post(new Runnable() {
                    /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        MiBandMainActivity.this.mDeviceAdapter.notifyDataSetChanged();
                    }
                });
            }
        }
    };
    private gxg mDataManager;
    public BleDevice mDevice;
    public gxd mDeviceAdapter;
    private ListView mDeviceListView;
    private frj mDownloadManager;
    private ImageView mSleepIndicator;
    private ImageView mStepIndicator;
    private TextView mTvDeviceTitle;
    private gxj mUserData;
    private View mViewContainer;
    private ViewPager mViewPager;
    private gxe miBandAdapter;
    private ViewPager.O0000O0o onPageChangeListener = new ViewPager.O0000O0o() {
        /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass8 */

        public final void onPageScrollStateChanged(int i) {
        }

        public final void onPageScrolled(int i, float f, int i2) {
        }

        public final void onPageSelected(int i) {
            MiBandMainActivity.this.updateIndicatorIcon(i);
        }
    };
    private gxk sleepFragment;
    private gxl stepFragment;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("mac");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.mDevice = (BleDevice) fno.O000000o().O000000o(stringExtra);
        }
        if (this.mDevice == null) {
            finish();
            return;
        }
        this.mDataManager = gxg.O000000o();
        gxg gxg = this.mDataManager;
        BleDevice bleDevice = this.mDevice;
        if (!bleDevice.equals(gxg.O00000o0)) {
            synchronized (gxg.f18455O000000o) {
                gxg.O00000o0 = bleDevice;
                gxg.O00000o.clear();
                gxg.O00000oO.clear();
                gxg.O00000oo.clear();
            }
            goq.O000000o(new Runnable() {
                /* class _m_j.gxg.AnonymousClass1 */

                public final void run() {
                    gxg gxg = gxg.this;
                    Context appContext = CommonApplication.getAppContext();
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    if (O0000o0 != null && !O0000o0.isEmpty() && !O0000o0.equalsIgnoreCase("0")) {
                        SharedPreferences sharedPreferences = appContext.getSharedPreferences("mi.band.data.cache".concat(String.valueOf(O0000o0)), 0);
                        if (sharedPreferences != null) {
                            String string = sharedPreferences.getString("mi.band.user.data", null);
                            if (string != null) {
                                try {
                                    JSONObject jSONObject = new JSONObject(string);
                                    synchronized (gxg.f18455O000000o) {
                                        gxg.O0000O0o = gxj.O000000o(jSONObject);
                                    }
                                    gxg.O00000o0();
                                } catch (JSONException unused) {
                                }
                            }
                            String string2 = sharedPreferences.getString("mi.band.sleep.data", null);
                            if (string2 != null) {
                                try {
                                    JSONArray jSONArray = new JSONArray(string2);
                                    ArrayList arrayList = new ArrayList();
                                    int length = jSONArray.length();
                                    for (int i = 0; i < length; i++) {
                                        arrayList.add(gxh.O000000o(jSONArray.optJSONObject(i)));
                                    }
                                    gxg.O000000o(arrayList);
                                } catch (JSONException unused2) {
                                }
                            }
                            String string3 = sharedPreferences.getString("mi.band.step.data", null);
                            if (string3 != null) {
                                try {
                                    JSONArray jSONArray2 = new JSONArray(string3);
                                    ArrayList arrayList2 = new ArrayList();
                                    int length2 = jSONArray2.length();
                                    for (int i2 = 0; i2 < length2; i2++) {
                                        arrayList2.add(gxi.O000000o(jSONArray2.optJSONObject(i2)));
                                    }
                                    gxg.O00000Oo(arrayList2);
                                } catch (JSONException unused3) {
                                }
                            }
                            gxg.O00000Oo();
                        }
                    }
                }
            });
        }
        getAccessInfo();
        setContentView((int) R.layout.miband_main_activity);
        bindView();
        initTitle();
        initView();
        initBandAdapter();
        this.mDownloadManager = new frj(getContentResolver(), getPackageName());
    }

    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 4096) {
            gxg gxg = this.mDataManager;
            String O00000Oo = gxm.O00000o0().O00000Oo();
            String O000000o2 = gxm.O00000o0().O000000o();
            if (O00000Oo != null && O000000o2 != null && !O00000Oo.isEmpty() && !O000000o2.isEmpty()) {
                ftu O000000o3 = ftu.O000000o();
                gxg.AnonymousClass5 r5 = new ftt<JSONObject>() {
                    /* class _m_j.gxg.AnonymousClass5 */

                    public final void O000000o(int i) {
                    }

                    public final void O000000o(int i, Object obj) {
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null) {
                            gxg.this.O0000O0o = gxj.O000000o(jSONObject.optJSONObject("data"));
                            goq.O000000o(new Runnable() {
                                /* class _m_j.gxg.AnonymousClass5.AnonymousClass1 */

                                /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
                                    if (r0 == null) goto L_?;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0051, code lost:
                                    r1 = r1.edit();
                                    r1.remove("mi.band.user.data");
                                    r1.putString("mi.band.user.data", r0.toString());
                                    r1.apply();
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
                                    return;
                                 */
                                /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                                    return;
                                 */
                                public final void run() {
                                    gxg gxg = gxg.this;
                                    Context appContext = CommonApplication.getAppContext();
                                    String O0000o0 = CoreApi.O000000o().O0000o0();
                                    if (O0000o0 != null && !O0000o0.isEmpty() && !O0000o0.equalsIgnoreCase("0") && (r1 = appContext.getSharedPreferences("mi.band.data.cache".concat(String.valueOf(O0000o0)), 0)) != null) {
                                        synchronized (gxg.f18455O000000o) {
                                            if (gxg.O0000O0o != null) {
                                                if (O0000o0.equalsIgnoreCase(String.valueOf(gxg.O0000O0o.f18466O000000o))) {
                                                    JSONObject O000000o2 = gxg.O0000O0o.O000000o();
                                                }
                                            }
                                        }
                                    }
                                }
                            });
                            gxg.this.O00000o0();
                        }
                    }
                };
                if (!gof.O000000o()) {
                    r5.O000000o(ErrorCode.ERROR_NETWORK_ERROR.getCode());
                } else {
                    ArrayList arrayList = new ArrayList(15);
                    arrayList.add(new gky("appid", "2882303761517233197"));
                    arrayList.add(new gky("third_appid", "1435821822"));
                    arrayList.add(new gky("third_appsecret", "NWZkYjMwMDFjNGRiMjhjOWRmMTkzNGMxYjRhODcyZWI"));
                    arrayList.add(new gky("l", "english"));
                    arrayList.add(new gky("v", "1.0"));
                    arrayList.add(new gky("call_id", Long.toString(System.currentTimeMillis() / 1000)));
                    arrayList.add(new gky("mac_key", O000000o2));
                    arrayList.add(new gky("access_token", O00000Oo));
                    gsg.O000000o(O000000o3.f17125O000000o, new gsk.O000000o().O000000o("POST").O00000Oo("https://hmservice.mi-ae.com.cn/user/info/getData").O000000o(arrayList).O000000o(), new gso(r5) {
                        /* class _m_j.ftu.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ ftt f17126O000000o;

                        {
                            this.f17126O000000o = r2;
                        }

                        public final /* synthetic */ void onSuccess(Object obj, Response response) {
                            O000000o((String) obj);
                        }

                        public final void O000000o(String str) {
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                int optInt = jSONObject.optInt("code");
                                ErrorCode valueof = ErrorCode.valueof(optInt);
                                if (optInt != 1) {
                                    if (optInt != 0) {
                                        if (this.f17126O000000o != null) {
                                            this.f17126O000000o.O000000o(valueof.getCode());
                                            return;
                                        }
                                        return;
                                    }
                                }
                                if (this.f17126O000000o != null) {
                                    this.f17126O000000o.O000000o(jSONObject);
                                }
                            } catch (JSONException unused) {
                                ftt ftt = this.f17126O000000o;
                                if (ftt != null) {
                                    ftt.O000000o(ErrorCode.INVALID.getCode());
                                }
                            }
                        }

                        public final void onFailure(gsf gsf, Exception exc, Response response) {
                            ftt ftt = this.f17126O000000o;
                            if (ftt != null) {
                                ftt.O000000o(ErrorCode.INVALID.getCode());
                            }
                        }
                    });
                }
            }
            gxg gxg2 = this.mDataManager;
            Calendar instance = Calendar.getInstance();
            Date time = instance.getTime();
            instance.add(6, -6);
            gxg2.O000000o(instance.getTime(), time);
            instance.add(6, -1);
            Date time2 = instance.getTime();
            instance.add(6, -6);
            gxg.O00000Oo.postDelayed(new Runnable(instance.getTime(), time2) {
                /* class _m_j.gxg.AnonymousClass6 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Date f18463O000000o;
                final /* synthetic */ Date O00000Oo;

                {
                    this.f18463O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final void run() {
                    gxg.this.O000000o(this.f18463O000000o, this.O00000Oo);
                }
            }, 1000);
        } else if (i == 4097) {
            int i2 = message.getData().getInt("code");
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O00000Oo(false);
            builder.O000000o((int) R.string.get_access_failed_title);
            if (i2 == 24578) {
                builder.O00000Oo((int) R.string.check_account_retry);
            } else if (i2 == 37121) {
                finish();
                return;
            } else {
                builder.O00000Oo((int) R.string.check_network_retry);
            }
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MiBandMainActivity.this.finish();
                }
            }).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    MiBandMainActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            MiBandMainActivity.this.getAccessInfo();
                        }
                    });
                }
            }).O00000o().show();
        }
    }

    public void getAccessInfo() {
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass4 */

            public final void run() {
                gxm O00000o0 = gxm.O00000o0();
                MiBandMainActivity miBandMainActivity = MiBandMainActivity.this;
                AnonymousClass1 r2 = new ftt<gxm.O000000o>() {
                    /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass4.AnonymousClass1 */

                    public final void O000000o(int i) {
                        gsy.O000000o(3, "OAuth:", String.valueOf(i));
                        Message obtainMessage = MiBandMainActivity.this.mHandler.obtainMessage(4097);
                        Bundle bundle = new Bundle();
                        bundle.putInt("code", i);
                        obtainMessage.setData(bundle);
                        MiBandMainActivity.this.mHandler.sendMessage(obtainMessage);
                    }

                    public final void O000000o(int i, Object obj) {
                        gsy.O000000o(3, "OAuth:", String.format("error code: %d, error info:%s", Integer.valueOf(i), obj));
                        Message obtainMessage = MiBandMainActivity.this.mHandler.obtainMessage(4097);
                        Bundle bundle = new Bundle();
                        bundle.putInt("code", i);
                        obtainMessage.setData(bundle);
                        MiBandMainActivity.this.mHandler.sendMessage(obtainMessage);
                    }

                    public final /* synthetic */ void O000000o(Object obj) {
                        MiBandMainActivity.this.mHandler.sendMessage(MiBandMainActivity.this.mHandler.obtainMessage(4096));
                    }
                };
                if (!O00000o0.O00000o0) {
                    O00000o0.O00000o0 = true;
                    String O0000o0 = CoreApi.O000000o().O0000o0();
                    if (O0000o0 == null || O0000o0.isEmpty()) {
                        r2.O000000o(24577);
                        O00000o0.O00000o0 = false;
                    } else if (!gxm.O000000o(O00000o0.f18471O000000o) || !O00000o0.f18471O000000o.O00000o0.equalsIgnoreCase(O0000o0)) {
                        gxo.O000000o(miBandMainActivity, new ftt<XiaomiOAuthResults>(r2, miBandMainActivity, O0000o0) {
                            /* class _m_j.gxm.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ ftt f18472O000000o;
                            final /* synthetic */ Activity O00000Oo;
                            final /* synthetic */ String O00000o0;

                            {
                                this.f18472O000000o = r2;
                                this.O00000Oo = r3;
                                this.O00000o0 = r4;
                            }

                            public final /* synthetic */ void O000000o(Object obj) {
                                XiaomiOAuthResults xiaomiOAuthResults = (XiaomiOAuthResults) obj;
                                int errorCode = xiaomiOAuthResults.getErrorCode();
                                if (errorCode != 0) {
                                    ftt ftt = this.f18472O000000o;
                                    if (ftt != null) {
                                        ftt.O000000o(errorCode);
                                    }
                                    gxm.this.O00000o0 = false;
                                    return;
                                }
                                if (gxm.this.f18471O000000o == null) {
                                    gxm gxm = gxm.this;
                                    gxm.f18471O000000o = new O000000o();
                                }
                                gxm.this.f18471O000000o.f18474O000000o = System.currentTimeMillis() / 1000;
                                String expiresIn = xiaomiOAuthResults.getExpiresIn();
                                gxm.this.f18471O000000o.O00000Oo = Long.parseLong(expiresIn);
                                gxm.this.f18471O000000o.O00000oO = xiaomiOAuthResults.getAccessToken();
                                gxm.this.f18471O000000o.O00000oo = xiaomiOAuthResults.getMacKey();
                                gxm.this.f18471O000000o.O00000o = xiaomiOAuthResults.getMacAlgorithm();
                                final O000000o o000000o = (O000000o) gxm.this.f18471O000000o.clone();
                                gxo.O000000o(this.O00000Oo, gxm.this.f18471O000000o.O00000oO, gxm.this.f18471O000000o.O00000oo, gxm.this.f18471O000000o.O00000o, new ftt<String>() {
                                    /* class _m_j.gxm.AnonymousClass1.AnonymousClass1 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        SharedPreferences sharedPreferences;
                                        try {
                                            JSONObject optJSONObject = new JSONObject((String) obj).optJSONObject("data");
                                            if (optJSONObject != null) {
                                                gxm.this.f18471O000000o.O00000o0 = optJSONObject.optString("userId", null);
                                                o000000o.O00000o0 = gxm.this.f18471O000000o.O00000o0;
                                                gsy.O000000o(3, "access user info id:", gxm.this.f18471O000000o.O00000o0);
                                                gsy.O000000o(3, "app user info id:", AnonymousClass1.this.O00000o0);
                                                if (o000000o.O00000o0.equalsIgnoreCase(AnonymousClass1.this.O00000o0)) {
                                                    gxm gxm = gxm.this;
                                                    Activity activity = AnonymousClass1.this.O00000Oo;
                                                    O000000o o000000o = o000000o;
                                                    if (gxm.O000000o(o000000o) && (sharedPreferences = activity.getSharedPreferences("oauth.2.0.access.info", 0)) != null) {
                                                        SharedPreferences.Editor edit = sharedPreferences.edit();
                                                        String O00000o = gxm.O00000o();
                                                        if (O00000o != null) {
                                                            edit.remove("access.token" + o000000o.O00000o0);
                                                            edit.putString("access.token" + o000000o.O00000o0, O00000o);
                                                            edit.apply();
                                                        }
                                                    }
                                                    if (AnonymousClass1.this.f18472O000000o != null) {
                                                        gxm.this.O00000Oo = true;
                                                        AnonymousClass1.this.f18472O000000o.O000000o(o000000o);
                                                    }
                                                    gxm.this.O00000o0 = false;
                                                    return;
                                                }
                                                if (AnonymousClass1.this.f18472O000000o != null) {
                                                    AnonymousClass1.this.f18472O000000o.O000000o(24578);
                                                }
                                                gxm.this.O00000o0 = false;
                                                return;
                                            }
                                            if (AnonymousClass1.this.f18472O000000o != null) {
                                                AnonymousClass1.this.f18472O000000o.O000000o(-1);
                                            }
                                            gxm.this.O00000o0 = false;
                                        } catch (JSONException unused) {
                                            if (AnonymousClass1.this.f18472O000000o != null) {
                                                AnonymousClass1.this.f18472O000000o.O000000o(-1);
                                            }
                                        }
                                    }

                                    public final void O000000o(int i) {
                                        gxm.this.f18471O000000o.O00000o0 = null;
                                        if (AnonymousClass1.this.f18472O000000o != null) {
                                            AnonymousClass1.this.f18472O000000o.O000000o(i);
                                        }
                                        gxm.this.O00000o0 = false;
                                    }

                                    public final void O000000o(int i, Object obj) {
                                        gxm.this.f18471O000000o.O00000o0 = null;
                                        if (AnonymousClass1.this.f18472O000000o != null) {
                                            AnonymousClass1.this.f18472O000000o.O000000o(i);
                                        }
                                        gxm.this.O00000o0 = false;
                                    }
                                });
                            }

                            public final void O000000o(int i) {
                                ftt ftt = this.f18472O000000o;
                                if (ftt != null) {
                                    ftt.O000000o(i);
                                }
                                gxm.this.O00000o0 = false;
                            }

                            public final void O000000o(int i, Object obj) {
                                ftt ftt = this.f18472O000000o;
                                if (ftt != null) {
                                    ftt.O000000o(i, obj);
                                }
                                gxm.this.O00000o0 = false;
                            }
                        });
                    } else {
                        O00000o0.O00000Oo = true;
                        r2.O000000o(O00000o0.f18471O000000o);
                        O00000o0.O00000o0 = false;
                    }
                }
            }
        }, 200);
    }

    public void onResume() {
        super.onResume();
        gxp O000000o2 = gxp.O000000o();
        gxp.O000000o o000000o = this.listener;
        for (gxp.O000000o equals : O000000o2.O00000Oo) {
            if (equals.equals(o000000o)) {
                return;
            }
        }
        O000000o2.O00000Oo.add(o000000o);
    }

    public void onPause() {
        super.onPause();
        gxp O000000o2 = gxp.O000000o();
        O000000o2.O00000Oo.remove(this.listener);
    }

    private void initBandAdapter() {
        this.fragmentList = new ArrayList();
        this.stepFragment = new gxl();
        this.sleepFragment = new gxk();
        this.fragmentList.add(this.stepFragment);
        this.fragmentList.add(this.sleepFragment);
        this.miBandAdapter = new gxe(getSupportFragmentManager(), this.fragmentList);
        this.mViewPager.setAdapter(this.miBandAdapter);
        this.mViewPager.setOnPageChangeListener(this.onPageChangeListener);
        this.mViewPager.setCurrentItem(0);
    }

    private void initTitle() {
        ((TextView) findViewById(R.id.module_a_3_return_transparent_title)).setText((int) R.string.miband_title);
        View findViewById = findViewById(R.id.module_a_3_return_more_more_transparent_btn);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R.id.module_a_3_return_transparent_btn);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass5 */

                public final void onClick(View view) {
                    MiBandMainActivity.this.finish();
                }
            });
        }
    }

    private void bindView() {
        this.mViewPager = (ViewPager) findViewById(R.id.pager);
        this.mStepIndicator = (ImageView) findViewById(R.id.iv_steps_indicator);
        this.mSleepIndicator = (ImageView) findViewById(R.id.iv_sleep_indicator);
        this.mViewContainer = findViewById(R.id.view_container);
        this.mDeviceListView = (ListView) findViewById(R.id.lv_band_devices);
        this.mTvDeviceTitle = (TextView) findViewById(R.id.device_list_title);
    }

    private void testNewFeature() {
        frj.O00000o0 o00000o0 = new frj.O00000o0(Uri.parse("http://www.baidu.com"));
        o00000o0.O000000o(this, "/mishare/", "test.html");
        this.mDownloadManager.O000000o(o00000o0);
    }

    private void initView() {
        Map<String, Device> O0000O0o = fno.O000000o().O0000O0o();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Device> value : O0000O0o.entrySet()) {
            Device device = (Device) value.getValue();
            if ((device.model.equalsIgnoreCase("midea.aircondition.v1") || device.model.equalsIgnoreCase("yeelink.light.ble1")) && device.isBinded() && !device.isShared()) {
                arrayList.add(device);
            }
        }
        View findViewById = findViewById(R.id.rl_device_list_empty);
        View findViewById2 = findViewById(R.id.btn_go_shop);
        findViewById(R.id.interactive_device_container);
        findViewById2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass6 */

            public final void onClick(final View view) {
                if (view.isEnabled()) {
                    view.setEnabled(false);
                    MiBandMainActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            view.setEnabled(true);
                        }
                    }, 500);
                    ezk.O000000o().shopLauncherResolve(MiBandMainActivity.this, String.format("https://home.mi.com/shop/search?keyword=%s&package_name=%s&action=detail", MiBandMainActivity.this.getString(R.string.yeelight_device_name), MiBandMainActivity.this.getPackageName()), false);
                }
            }
        });
        if (arrayList.size() > 0) {
            this.mTvDeviceTitle.setText((int) R.string.device_connect_with_band);
            findViewById.setVisibility(8);
            this.mDeviceListView.setVisibility(0);
        } else {
            this.mTvDeviceTitle.setText((int) R.string.device_with_band);
            findViewById.setVisibility(0);
            this.mDeviceListView.setVisibility(8);
        }
        this.mDeviceAdapter = new gxd(this, arrayList);
        ListView listView = this.mDeviceListView;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.mDeviceAdapter);
        }
        this.mDeviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass7 */

            public final void onItemClick(AdapterView<?> adapterView, final View view, int i, long j) {
                Device device = (Device) MiBandMainActivity.this.mDeviceAdapter.getItem(i);
                if (!gxm.O00000o0().O00000Oo) {
                    izb.O000000o(MiBandMainActivity.this, (int) R.string.not_oauth, 0).show();
                } else if (device != null && view.isEnabled()) {
                    view.setEnabled(false);
                    MiBandMainActivity.this.mHandler.postDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.miband.MiBandMainActivity.AnonymousClass7.AnonymousClass1 */

                        public final void run() {
                            view.setEnabled(true);
                        }
                    }, 500);
                    if (!device.isOnline) {
                        izb.O000000o(MiBandMainActivity.this, (int) R.string.other_device_offline, 0).show();
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("did", device.did);
                    intent.putExtra("miband_did", MiBandMainActivity.this.mDevice.did);
                    intent.putExtra("mihome_page_navigate_path", "/navigate_page_to_band");
                    gxp O000000o2 = gxp.O000000o();
                    MiBandMainActivity miBandMainActivity = MiBandMainActivity.this;
                    String str = device.model;
                    if (str != null && !str.isEmpty() && CoreApi.O000000o().O00000o(str)) {
                        PluginApi.getInstance().sendMessage(miBandMainActivity, str, 4, intent, null, null, true, new gxp.O00000Oo(str));
                    }
                }
            }
        });
    }

    public void updateIndicatorIcon(int i) {
        if (i == 0) {
            this.mStepIndicator.setImageResource(R.drawable.dot_indicator_selected);
            this.mSleepIndicator.setImageResource(R.drawable.dot_indicator_unselected);
            this.mViewContainer.setBackgroundColor(getResources().getColor(R.color.mj_color_step_background_color));
            return;
        }
        this.mStepIndicator.setImageResource(R.drawable.dot_indicator_unselected);
        this.mSleepIndicator.setImageResource(R.drawable.dot_indicator_selected);
        this.mViewContainer.setBackgroundColor(getResources().getColor(R.color.mj_color_sleep_background_color));
    }
}
