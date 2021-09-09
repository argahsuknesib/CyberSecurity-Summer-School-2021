package com.xiaomi.smarthome.miio.activity;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gfb;
import _m_j.gqg;
import _m_j.gyf;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.TitleBarUtil;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.PieProgressBar;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiioUpgradeActivity extends BaseActivity {
    public static String MIIO_UPGRADE_DID = "miio_upgrade_did";
    public static int MIIO_UPGRADE_MAX = 120;
    public static String MIIO_UPGRADE_NAME = "miio_upgrade_name";
    public static String MIIO_UPGRADE_PID = "miio_upgrade_pid";
    public static int MIIO_UPGRADE_TIME = 2000;
    static String[] O0000oOO = {"chuangmi.camera.xiaobai", "rockrobo.vacuum.v1"};
    private static int O0000oo0;

    /* renamed from: O000000o  reason: collision with root package name */
    ViewSwitcher f9693O000000o;
    View O00000Oo;
    TextView O00000o;
    PieProgressBar O00000o0;
    TextView O00000oO;
    TextView O00000oo;
    TextView O0000O0o;
    Button O0000OOo;
    gyf O0000Oo;
    ProgressBar O0000Oo0;
    boolean O0000OoO = false;
    boolean O0000Ooo = false;
    int O0000o = 0;
    boolean O0000o0 = false;
    boolean O0000o00 = false;
    boolean O0000o0O = false;
    boolean O0000o0o = false;
    Device O0000oO;
    String O0000oO0 = null;
    Runnable O0000oOo = new Runnable() {
        /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass8 */

        public final void run() {
            MiioUpgradeActivity.this.O000000o(true);
        }
    };

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        setContentView((int) R.layout.miio_setting_update);
        Intent intent = getIntent();
        this.O0000Oo = new gyf();
        this.O0000Oo.O00000Oo = intent.getStringExtra(MIIO_UPGRADE_DID);
        this.O0000Oo.O00000o0 = intent.getIntExtra(MIIO_UPGRADE_PID, 0);
        this.O0000Oo.O00000o = intent.getStringExtra(MIIO_UPGRADE_NAME);
        this.O0000oO = fno.O000000o().O000000o(this.O0000Oo.O00000Oo);
        Device device = this.O0000oO;
        if (device == null) {
            gqg.O00000Oo((int) R.string.failed);
            finish();
            return;
        }
        if (device != null) {
            String str = device.model;
            int i = 0;
            while (true) {
                String[] strArr = O0000oOO;
                if (i >= strArr.length) {
                    z = false;
                    break;
                } else if (strArr[i].equals(str)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                MIIO_UPGRADE_MAX = 600;
                findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass1 */

                    public final void onClick(View view) {
                        MiioUpgradeActivity.this.finish();
                    }
                });
                ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000Oo.O00000o);
                this.f9693O000000o = (ViewSwitcher) findViewById(R.id.vs_root);
                this.O00000Oo = findViewById(R.id.ll_loading);
                this.O00000o0 = (PieProgressBar) findViewById(R.id.pb_progress);
                this.O00000o = (TextView) findViewById(R.id.txt_progress);
                this.O00000oO = (TextView) findViewById(R.id.txt_update_title);
                this.O00000oo = (TextView) findViewById(R.id.txt_update_desc);
                this.O0000O0o = (TextView) findViewById(R.id.txt_updating_tip);
                this.O0000OOo = (Button) findViewById(R.id.btn_bottom);
                this.O00000o0.setPercentView(this.O00000o);
                this.O0000Oo0 = (ProgressBar) findViewById(R.id.installing_progress_bar);
                resetState();
                showLoading();
                O000000o(false);
                if (this.O0000oO.isOnline) {
                    getWindow().getDecorView().post(new Runnable() {
                        /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass5 */

                        public final void run() {
                            MiioUpgradeActivity.this.addOfflineFloatingView();
                        }
                    });
                    return;
                }
                return;
            }
        }
        MIIO_UPGRADE_MAX = 120;
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass1 */

            public final void onClick(View view) {
                MiioUpgradeActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(this.O0000Oo.O00000o);
        this.f9693O000000o = (ViewSwitcher) findViewById(R.id.vs_root);
        this.O00000Oo = findViewById(R.id.ll_loading);
        this.O00000o0 = (PieProgressBar) findViewById(R.id.pb_progress);
        this.O00000o = (TextView) findViewById(R.id.txt_progress);
        this.O00000oO = (TextView) findViewById(R.id.txt_update_title);
        this.O00000oo = (TextView) findViewById(R.id.txt_update_desc);
        this.O0000O0o = (TextView) findViewById(R.id.txt_updating_tip);
        this.O0000OOo = (Button) findViewById(R.id.btn_bottom);
        this.O00000o0.setPercentView(this.O00000o);
        this.O0000Oo0 = (ProgressBar) findViewById(R.id.installing_progress_bar);
        resetState();
        showLoading();
        O000000o(false);
        if (this.O0000oO.isOnline) {
        }
    }

    public void onResume() {
        super.onResume();
        this.O0000o = 0;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        this.O0000o = 0;
        this.O0000OoO = true;
        this.O0000oO0 = this.O0000Oo.O0000O0o;
        gyf gyf = this.O0000Oo;
        gyf.O0000Oo = 0;
        if ("downloaded".equals(gyf.O0000OoO) || "wait_install".equals(this.O0000Oo.O0000OoO)) {
            this.O0000Ooo = true;
        }
        this.O0000o00 = false;
        this.O0000o0O = false;
        refreshUI();
        this.mHandler.removeCallbacks(this.O0000oOo);
        gfb.O000000o().O00000o0(this, this.O0000Oo.O00000Oo, this.O0000Oo.O00000o0, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass7 */

            public final void onFailure(fso fso) {
                MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                miioUpgradeActivity.O0000OoO = false;
                miioUpgradeActivity.O0000o00 = true;
                miioUpgradeActivity.O0000o0O = false;
                if ("downloaded".equals(miioUpgradeActivity.O0000Oo.O0000OoO) || "wait_install".equals(MiioUpgradeActivity.this.O0000Oo.O0000OoO)) {
                    MiioUpgradeActivity.this.O0000Ooo = false;
                }
                MiioUpgradeActivity.this.refreshUI();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                miioUpgradeActivity.O0000OoO = true;
                miioUpgradeActivity.O0000o00 = false;
                miioUpgradeActivity.O0000o0O = false;
                miioUpgradeActivity.refreshUI();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final boolean z) {
        if (!this.O0000o00 && !this.O0000o0O && !this.O0000o0o) {
            this.O0000o0o = true;
            gfb.O000000o().O00000Oo(this, this.O0000Oo.O00000Oo, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass9 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    MiioUpgradeActivity.this.processUpdateInfo((JSONObject) obj);
                }

                public final void onFailure(fso fso) {
                    MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                    miioUpgradeActivity.O0000o0o = false;
                    if (z) {
                        miioUpgradeActivity.mHandler.postDelayed(MiioUpgradeActivity.this.O0000oOo, (long) MiioUpgradeActivity.MIIO_UPGRADE_TIME);
                        return;
                    }
                    miioUpgradeActivity.O0000o00 = true;
                    miioUpgradeActivity.O0000o0O = false;
                    miioUpgradeActivity.O0000OoO = false;
                    miioUpgradeActivity.O0000Ooo = false;
                    miioUpgradeActivity.refreshUI();
                }
            });
        }
    }

    public void processUpdateInfo(JSONObject jSONObject) {
        this.O0000o0o = false;
        this.O0000o00 = false;
        this.O0000o0O = false;
        gyf gyf = this.O0000Oo;
        if (jSONObject != null) {
            gyf.O00000oO = jSONObject.optBoolean("updating");
            gyf.O00000oo = jSONObject.optString("curr");
            gyf.O0000O0o = jSONObject.optString("latest");
            gyf.O0000Oo0 = jSONObject.optString("description");
            gyf.O0000OOo = jSONObject.optBoolean("isLatest");
            gyf.O0000Oo = jSONObject.optInt("ota_progress");
            gyf.O0000OoO = jSONObject.optString("ota_status");
            gyf.O0000o00 = jSONObject.optInt("ota_failed_code");
            gyf.O0000o0 = jSONObject.optString("ota_failed_reason");
            gyf.O0000o0O = jSONObject.optInt("timeout_time");
            gyf.O0000o0o = jSONObject.optInt("force");
        }
        if (TextUtils.equals("idle", this.O0000Oo.O0000OoO)) {
            this.O0000Oo.O0000Oo = 0;
        }
        this.O0000OoO = this.O0000Oo.O00000oO;
        if ("failed".equals(this.O0000Oo.O0000OoO)) {
            this.O0000o00 = true;
        }
        if (!"installing".equals(this.O0000Oo.O0000OoO) || this.O0000Oo.O0000OOo || !this.O0000Oo.O00000oO) {
            this.O0000Ooo = false;
        } else {
            this.O0000Ooo = true;
        }
        if (O00000Oo()) {
            this.O0000OoO = false;
            this.O0000o0 = true;
            this.O0000Ooo = false;
        }
        if (this.O0000Oo.O0000o0O > 0) {
            MIIO_UPGRADE_MAX = this.O0000Oo.O0000o0O / 2;
        }
        refreshUI();
    }

    private boolean O00000Oo() {
        gyf gyf = this.O0000Oo;
        if (gyf == null) {
            return false;
        }
        String str = gyf.O00000oo;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String str2 = this.O0000oO0;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.startsWith("_")) {
            str = str.substring(1);
        }
        if (str2.startsWith("_")) {
            str2 = str2.substring(1);
        }
        return str.equals(str2);
    }

    public void resetState() {
        this.O0000o0o = false;
        this.O0000o = 0;
        this.O0000Ooo = false;
        this.O0000o00 = false;
        this.O0000o0O = false;
    }

    public void showLoading() {
        if (this.f9693O000000o.getCurrentView() != this.O00000Oo) {
            this.f9693O000000o.showNext();
        }
    }

    public void addOfflineFloatingView() {
        FrameLayout frameLayout = (FrameLayout) getWindow().getDecorView();
        final ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this).inflate((int) R.layout.device_offline_floating_view, (ViewGroup) null);
        viewGroup.setClickable(false);
        viewGroup.findViewById(R.id.read_detail_tv).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass3 */

            public final void onClick(View view) {
                fbt fbt = new fbt(MiioUpgradeActivity.this.getContext(), "DeviceOfflineDetailActivity");
                if (MiioUpgradeActivity.this.O0000oO != null) {
                    fbt.O000000o("extra_model", MiioUpgradeActivity.this.O0000oO.model);
                }
                Intent intent = MiioUpgradeActivity.this.getIntent();
                if (intent != null) {
                    fbt.O000000o(intent.getExtras());
                }
                fbt.O00000Oo(268435456);
                fbs.O000000o(fbt);
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Resources resources = getResources();
        if (TitleBarUtil.TRANSLUCENT_STATUS_ENABLED) {
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.mj_titlebar_height);
        } else {
            layoutParams.topMargin = resources.getDimensionPixelSize(R.dimen.mj_titlebar_height) + resources.getDimensionPixelOffset(R.dimen.title_bar_top_padding);
        }
        frameLayout.addView(viewGroup, layoutParams);
        viewGroup.findViewById(R.id.delete_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass4 */

            public final void onClick(View view) {
                MiioUpgradeActivity.this.disappearBtmBar(viewGroup.findViewById(R.id.bottom_rl));
            }
        });
    }

    public void disappearBtmBar(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.Y, (float) (viewGroup.getHeight() - view.getHeight()), (float) viewGroup.getHeight());
        ofFloat.setDuration(500L);
        ofFloat.start();
    }

    public void refreshUI() {
        if (this.f9693O000000o.getCurrentView() == this.O00000Oo) {
            this.f9693O000000o.showNext();
        }
        this.O0000Oo0.setVisibility(this.O0000Ooo ? 0 : 8);
        this.O00000oO.setVisibility(0);
        this.O0000OOo.setEnabled(true);
        if (this.O0000o00 || this.O0000o0O) {
            this.O00000oo.setVisibility(8);
            this.O0000O0o.setVisibility(8);
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setText((int) R.string.mj_retry);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass10 */

                public final void onClick(View view) {
                    MiioUpgradeActivity.this.resetState();
                    MiioUpgradeActivity.this.showLoading();
                    MiioUpgradeActivity.this.O000000o(false);
                }
            });
            this.O00000o0.setBackgroundResource(R.drawable.update_img_failed);
            this.O00000o0.setPercent(0.0f);
            this.O00000o.setVisibility(8);
            if (!CoreApi.O000000o().O0000Ooo()) {
                this.O00000oO.setText((int) R.string.update_failed_not_login);
                this.O00000o0.setOnClickListener(null);
            } else if (this.O0000o0O) {
                this.O00000oO.setText((int) R.string.update_failed_timeout);
            } else if (!TextUtils.isEmpty(this.O0000Oo.O0000o0)) {
                this.O00000oO.setText(this.O0000Oo.O0000o0);
            } else {
                this.O00000oO.setText((int) R.string.update_failed_retry);
            }
        } else if (this.O0000OoO || "downloading".equals(this.O0000Oo.O0000OoO) || this.O0000Ooo) {
            if (this.O0000Ooo) {
                this.O00000oO.setText((int) R.string.update_installing);
                this.O00000oo.setVisibility(8);
                this.O0000O0o.setVisibility(0);
                this.O0000OOo.setVisibility(4);
                this.O00000o0.setVisibility(8);
                this.O00000o0.setOnClickListener(null);
                this.O00000o0.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                this.O00000o.setVisibility(8);
                this.O0000O0o.setText((int) R.string.update_installing_info);
            } else {
                this.O00000oO.setText((int) R.string.model_updating);
                this.O00000oo.setVisibility(8);
                this.O0000O0o.setVisibility(0);
                this.O0000O0o.setText((int) R.string.miio_update_tips);
                this.O0000OOo.setVisibility(4);
                this.O00000o0.setVisibility(0);
                this.O00000o0.setOnClickListener(null);
                this.O00000o0.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                this.O00000o.setVisibility(0);
                if (this.O0000Oo.O0000Oo >= 0 && this.O0000Oo.O0000Oo < 100) {
                    this.O00000o0.setPercent((float) this.O0000Oo.O0000Oo);
                } else if (this.O0000Oo.O0000Oo >= 100) {
                    this.O00000o0.setPercent(99.0f);
                }
            }
            if (!O00000Oo()) {
                this.O0000o++;
                this.mHandler.removeCallbacks(this.O0000oOo);
                if (this.O0000o > MIIO_UPGRADE_MAX) {
                    this.O0000o = 0;
                    this.O0000o0O = true;
                    this.O0000OoO = false;
                    this.O0000Ooo = false;
                    refreshUI();
                    return;
                }
                this.mHandler.postDelayed(this.O0000oOo, (long) MIIO_UPGRADE_TIME);
            }
        } else if ("downloaded".equals(this.O0000Oo.O0000OoO) || "wait_install".equals(this.O0000Oo.O0000OoO)) {
            this.O00000o.setVisibility(8);
            this.O00000o0.setBackgroundResource(R.drawable.update_img_update);
            this.O00000o0.setPercent(0.0f);
            this.O00000o0.setOnClickListener(null);
            this.O00000oO.setText(getResources().getString(R.string.list_item_curr_version) + " " + this.O0000Oo.O00000oo + "\n\n" + getResources().getString(R.string.list_item_latest_version) + " " + this.O0000Oo.O0000O0o);
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText(this.O0000Oo.O0000Oo0);
            this.O0000O0o.setVisibility(8);
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setText((int) R.string.update_now);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass11 */

                public final void onClick(View view) {
                    if ("downloaded".equals(MiioUpgradeActivity.this.O0000Oo.O0000OoO)) {
                        MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                        miioUpgradeActivity.O0000o = 0;
                        miioUpgradeActivity.O0000Ooo = true;
                        miioUpgradeActivity.O0000oO0 = miioUpgradeActivity.O0000Oo.O0000O0o;
                        miioUpgradeActivity.refreshUI();
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("method", "miIO.ota_install");
                            jSONObject.put("params", new JSONArray());
                        } catch (Exception unused) {
                        }
                        miioUpgradeActivity.mHandler.removeCallbacks(miioUpgradeActivity.O0000oOo);
                        DeviceApi.getInstance().rpcAsyncRemote(miioUpgradeActivity, miioUpgradeActivity.O0000Oo.O00000Oo, jSONObject.toString(), new fsm<JSONObject, fso>() {
                            /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass6 */

                            public final void onFailure(fso fso) {
                                MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                miioUpgradeActivity.O0000Ooo = false;
                                miioUpgradeActivity.O0000o00 = true;
                                miioUpgradeActivity.O0000o0O = false;
                                miioUpgradeActivity.refreshUI();
                            }

                            public final /* synthetic */ void onSuccess(Object obj) {
                                MiioUpgradeActivity miioUpgradeActivity = MiioUpgradeActivity.this;
                                miioUpgradeActivity.O0000Ooo = true;
                                miioUpgradeActivity.O0000o00 = false;
                                miioUpgradeActivity.O0000o0O = false;
                                miioUpgradeActivity.refreshUI();
                            }
                        });
                        return;
                    }
                    MiioUpgradeActivity.this.O000000o();
                }
            });
        } else if (!this.O0000Oo.O0000OOo) {
            this.O00000o.setVisibility(8);
            this.O00000o0.setBackgroundResource(R.drawable.update_img_update);
            this.O00000o0.setPercent(0.0f);
            this.O00000o0.setOnClickListener(null);
            this.O00000oO.setText(getResources().getString(R.string.list_item_curr_version) + " " + this.O0000Oo.O00000oo + "\n\n" + getResources().getString(R.string.list_item_latest_version) + " " + this.O0000Oo.O0000O0o);
            this.O00000oo.setVisibility(0);
            this.O00000oo.setText(this.O0000Oo.O0000Oo0);
            this.O0000O0o.setVisibility(8);
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setText((int) R.string.update_now);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass12 */

                public final void onClick(View view) {
                    MiioUpgradeActivity.this.O000000o();
                }
            });
            if (!this.O0000oO.isOnline) {
                this.O0000OOo.setEnabled(false);
            }
        } else {
            if (this.O0000o0) {
                this.O00000o0.setBackgroundResource(R.drawable.update_img_success);
                this.O00000oO.setText(getResources().getString(R.string.model_update_success) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + this.O0000Oo.O00000oo);
            } else {
                this.O00000o0.setBackgroundResource(R.drawable.update_img_latest);
                this.O00000oO.setText(getResources().getString(R.string.model_latest) + "\n\n" + getResources().getString(R.string.app_curr_version) + " " + this.O0000Oo.O00000oo);
            }
            this.O00000o.setVisibility(8);
            this.O00000o0.setPercent(0.0f);
            this.O00000o0.setOnClickListener(null);
            this.O00000oo.setVisibility(8);
            this.O0000O0o.setVisibility(8);
            this.O0000OOo.setVisibility(0);
            this.O0000OOo.setText((int) R.string.ok_button);
            this.O0000OOo.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.activity.MiioUpgradeActivity.AnonymousClass2 */

                public final void onClick(View view) {
                    MiioUpgradeActivity.this.finish();
                }
            });
        }
    }
}
