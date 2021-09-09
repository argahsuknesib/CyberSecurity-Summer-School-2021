package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.cih;
import _m_j.cjm;
import _m_j.fno;
import _m_j.ftn;
import _m_j.gsy;
import _m_j.hzf;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoUserStatus;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.ICloudVideoCallback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudVideoSettingActivity extends CloudVideoBaseActivity implements View.OnClickListener {
    private String did;
    private ImageView ivHeaderLeftBack;
    private ImageView ivHeaderRightSetting;
    private String model;
    private RelativeLayout rlCloudServiceEULA;
    private RelativeLayout rlDownloadVideo;
    private RelativeLayout rlTitleBar;
    public SwitchButton sbCloudVideoService;
    private String title;
    public TextView tvBuy;
    public TextView tvDurationHint;
    public TextView tvStatus;
    public TextView tvStorageDesc;
    private TextView tvSubTitle;
    public TextView tvTitle;
    private TextView tvTitleBarTitle;
    public TextView tvUsageDesc;

    public void onCreate(Bundle bundle) {
        Device O000000o2;
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_setting);
        this.did = getIntent().getStringExtra("did");
        this.title = getIntent().getStringExtra("title");
        if (!TextUtils.isEmpty(this.did) && (O000000o2 = fno.O000000o().O000000o(this.did)) != null) {
            this.model = O000000o2.model;
        }
        initViews();
        cjm.O000000o(CloudVideoUtils.getDeviceModel(this.did), "plg.cld.m3m.xbb");
    }

    private void initViews() {
        this.rlTitleBar = (RelativeLayout) findViewById(R.id.rlTitleBar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.rlTitleBar.getLayoutParams());
        layoutParams.setMargins(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        this.rlTitleBar.setLayoutParams(layoutParams);
        this.rlTitleBar.bringToFront();
        this.ivHeaderLeftBack = (ImageView) findViewById(R.id.ivHeaderLeftBack);
        this.ivHeaderLeftBack.setOnClickListener(this);
        this.rlCloudServiceEULA = (RelativeLayout) findViewById(R.id.rlCloudServiceEULA);
        this.rlCloudServiceEULA.setOnClickListener(this);
        this.ivHeaderRightSetting = (ImageView) findViewById(R.id.ivHeaderRightSetting);
        this.ivHeaderRightSetting.setVisibility(8);
        this.tvBuy = (TextView) findViewById(R.id.tvBuy);
        this.tvBuy.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.tvTitle);
        this.tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        if (!TextUtils.isEmpty(this.title)) {
            this.tvSubTitle.setText(this.title);
        }
        this.tvStatus = (TextView) findViewById(R.id.tvStatus);
        this.tvUsageDesc = (TextView) findViewById(R.id.tvUsageDesc);
        this.tvStorageDesc = (TextView) findViewById(R.id.tvStorageDesc);
        this.tvDurationHint = (TextView) findViewById(R.id.tvDurationHint);
        this.tvTitleBarTitle = (TextView) findViewById(R.id.tvTitleBarTitle);
        this.tvTitleBarTitle.setVisibility(0);
        this.tvTitleBarTitle.setText((int) R.string.cs_my_service);
        this.tvTitleBarTitle.setTextSize(16.0f);
        this.tvTitleBarTitle.setTextColor(-16777216);
        this.rlDownloadVideo = (RelativeLayout) findViewById(R.id.rlDownloadVideo);
        this.rlDownloadVideo.setVisibility(0);
        this.rlDownloadVideo.setOnClickListener(this);
        this.sbCloudVideoService = (SwitchButton) findViewById(R.id.sbCloudVideoService);
        this.sbCloudVideoService.setOnPerformCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoSettingActivity$kNOy68eAZZd20EUVpTU7Fy9zjVA */

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CloudVideoSettingActivity.this.lambda$initViews$0$CloudVideoSettingActivity(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$initViews$0$CloudVideoSettingActivity(CompoundButton compoundButton, boolean z) {
        gsy.O00000Oo("CloudVideoSettingActivity", "isChecked:".concat(String.valueOf(z)));
        setUsage(z);
    }

    public void onResume() {
        super.onResume();
        getStatus();
        getCapacity();
        getUsage();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tvBuy) {
            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.did);
        } else if (id == R.id.rlDownloadVideo) {
            cjm.O000000o(CloudVideoUtils.getDeviceModel(this.did), "plg.cld.061.6i6");
            Intent intent = new Intent(getContext(), CloudVideoDownloadActivity.class);
            intent.putExtra("did", this.did);
            Device O000000o2 = fno.O000000o().O000000o(this.did);
            if (O000000o2 != null) {
                intent.putExtra("uid", O000000o2.userId);
                startActivity(intent);
            }
        } else if (id == R.id.ivHeaderLeftBack) {
            onBackPressed();
        } else if (id == R.id.rlCloudServiceEULA) {
            cjm.O000000o(CloudVideoUtils.getDeviceModel(this.did), "plg.cld.qbe.pwt");
            String O000000o3 = cih.O000000o("home.mi.com/app_page/new_cloud_service.html");
            Locale O00000o = ftn.O00000o(getContext());
            if (O00000o != null) {
                O000000o3 = O000000o3 + "?locale=" + O00000o.getLanguage();
            } else {
                Locale locale = Locale.getDefault();
                if (locale != null) {
                    O000000o3 = O000000o3 + "?locale=" + locale.getLanguage();
                }
            }
            gsy.O00000Oo("CloudVideoSettingActivity", "url:".concat(String.valueOf(O000000o3)));
            Intent intent2 = new Intent(getContext(), CloudVideoWebActivity.class);
            intent2.putExtra("url", O000000o3);
            intent2.putExtra("title", getString(R.string.cs_service));
            intent2.putExtra("did", this.did);
            startActivity(intent2);
        }
    }

    private void getStatus() {
        ServerBean O0000ooO;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            if (CoreApi.O000000o().O0000O0o() && CoreApi.O000000o().O0000ooO() != null && (O0000ooO = CoreApi.O000000o().O0000ooO()) != null && !TextUtils.isEmpty(O0000ooO.O00000Oo)) {
                jSONObject.put("region", O0000ooO.O00000Oo);
            }
            gsy.O00000Oo("CloudVideoSettingActivity", "jsonObject:" + jSONObject.toString());
            CloudVideoNetUtils.getInstance().getSettingStatus(this, jSONObject.toString(), new ICloudVideoCallback<CloudVideoUserStatus>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity.AnonymousClass1 */

                public void onCloudVideoSuccess(final CloudVideoUserStatus cloudVideoUserStatus, Object obj) {
                    if (!CloudVideoSettingActivity.this.isFinishing() && cloudVideoUserStatus != null) {
                        gsy.O00000Oo("CloudVideoSettingActivity", "onCloudVideoSuccess" + cloudVideoUserStatus.toString());
                        CloudVideoSettingActivity.this.runOnUiThread(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity.AnonymousClass1.AnonymousClass1 */

                            public void run() {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                if (cloudVideoUserStatus.vip) {
                                    CloudVideoSettingActivity.this.sbCloudVideoService.setEnabled(true);
                                    CloudVideoSettingActivity.this.tvTitle.setVisibility(0);
                                    TextView textView = CloudVideoSettingActivity.this.tvTitle;
                                    textView.setText(cloudVideoUserStatus.packageType);
                                    TextView textView2 = CloudVideoSettingActivity.this.tvStatus;
                                    textView2.setText(CloudVideoSettingActivity.this.getString(R.string.cs_service_in_use));
                                    TextView textView3 = CloudVideoSettingActivity.this.tvBuy;
                                    textView3.setText(CloudVideoSettingActivity.this.getString(R.string.cs_renew_service));
                                    CloudVideoSettingActivity.this.tvDurationHint.setVisibility(0);
                                    TextView textView4 = CloudVideoSettingActivity.this.tvDurationHint;
                                    textView4.setText(String.format(CloudVideoSettingActivity.this.getString(R.string.cs_service_duration), simpleDateFormat.format(Long.valueOf(cloudVideoUserStatus.startTime)), simpleDateFormat.format(Long.valueOf(cloudVideoUserStatus.endTime))));
                                    SpannableString spannableString = new SpannableString(CloudVideoSettingActivity.this.millisToDay(System.currentTimeMillis() - cloudVideoUserStatus.startTime) + CloudVideoSettingActivity.this.getString(R.string.cs_day));
                                    if (!TextUtils.isEmpty(spannableString.toString())) {
                                        spannableString.setSpan(new RelativeSizeSpan(2.5f), 0, spannableString.length() - (!TextUtils.isEmpty(CloudVideoSettingActivity.this.getString(R.string.cs_day)) ? CloudVideoSettingActivity.this.getString(R.string.cs_day).length() : 0), 0);
                                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D8A24F")), 0, spannableString.length(), 0);
                                        CloudVideoSettingActivity.this.tvUsageDesc.setText(spannableString);
                                        return;
                                    }
                                    return;
                                }
                                CloudVideoSettingActivity.this.sbCloudVideoService.setChecked(false);
                                CloudVideoSettingActivity.this.sbCloudVideoService.setEnabled(false);
                                CloudVideoSettingActivity.this.tvTitle.setVisibility(8);
                                if (cloudVideoUserStatus.status == 1) {
                                    CloudVideoSettingActivity.this.tvDurationHint.setVisibility(0);
                                    TextView textView5 = CloudVideoSettingActivity.this.tvStatus;
                                    textView5.setText(CloudVideoSettingActivity.this.getString(R.string.cs_service_expired));
                                } else if (cloudVideoUserStatus.status == 2) {
                                    CloudVideoSettingActivity.this.tvDurationHint.setVisibility(0);
                                    TextView textView6 = CloudVideoSettingActivity.this.tvStatus;
                                    textView6.setText(CloudVideoSettingActivity.this.getString(R.string.cs_service_in_use));
                                } else {
                                    CloudVideoSettingActivity.this.tvDurationHint.setVisibility(8);
                                    TextView textView7 = CloudVideoSettingActivity.this.tvStatus;
                                    textView7.setText(CloudVideoSettingActivity.this.getString(R.string.cs_service_not_use));
                                }
                                TextView textView8 = CloudVideoSettingActivity.this.tvDurationHint;
                                textView8.setText(String.format(CloudVideoSettingActivity.this.getString(R.string.cs_service_duration), simpleDateFormat.format(Long.valueOf(cloudVideoUserStatus.startTime)), simpleDateFormat.format(Long.valueOf(cloudVideoUserStatus.endTime))));
                                TextView textView9 = CloudVideoSettingActivity.this.tvBuy;
                                textView9.setText(CloudVideoSettingActivity.this.getString(R.string.cs_buy_service));
                                SpannableString spannableString2 = new SpannableString(CloudVideoSettingActivity.this.getString(R.string.cs_day_0));
                                if (!TextUtils.isEmpty(spannableString2.toString())) {
                                    spannableString2.setSpan(new RelativeSizeSpan(2.5f), 0, spannableString2.length() - 1, 0);
                                    spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#D8A24F")), 0, spannableString2.length(), 0);
                                    CloudVideoSettingActivity.this.tvUsageDesc.setText(spannableString2);
                                }
                            }
                        });
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        gsy.O000000o(6, "CloudVideoSettingActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private void getCapacity() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            jSONObject.put("region", Locale.getDefault().getCountry());
            CloudVideoNetUtils.getInstance().getSettingCapacity(this, jSONObject.toString(), new ICloudVideoCallback<Long>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity.AnonymousClass2 */

                public void onCloudVideoSuccess(Long l, Object obj) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        CloudVideoSettingActivity.this.runOnUiThread(new Runnable(l) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoSettingActivity$2$sgzgPdCjio4_Bb6EuJmNc7lXrYs */
                            private final /* synthetic */ Long f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoSettingActivity.AnonymousClass2.this.lambda$onCloudVideoSuccess$0$CloudVideoSettingActivity$2(this.f$1);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoSuccess$0$CloudVideoSettingActivity$2(Long l) {
                    String capacityTranslation = CloudVideoSettingActivity.this.capacityTranslation(l.longValue());
                    if (!TextUtils.isEmpty(capacityTranslation)) {
                        SpannableString spannableString = new SpannableString(capacityTranslation);
                        if (capacityTranslation.toLowerCase().equals("max")) {
                            spannableString.setSpan(new RelativeSizeSpan(2.5f), 0, spannableString.length(), 0);
                        } else {
                            spannableString.setSpan(new RelativeSizeSpan(2.5f), 0, spannableString.length() - 2, 0);
                        }
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#D8A24F")), 0, spannableString.length(), 0);
                        CloudVideoSettingActivity.this.tvStorageDesc.setText(spannableString);
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        gsy.O000000o(6, "CloudVideoSettingActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private void getUsage() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo != null) {
                jSONObject.put("region", O00oOooo.getCountry());
            } else {
                jSONObject.put("region", Locale.getDefault().getCountry());
            }
            CloudVideoNetUtils.getInstance().getSettingUsage(this, jSONObject.toString(), new ICloudVideoCallback<Boolean>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity.AnonymousClass3 */

                public void onCloudVideoSuccess(Boolean bool, Object obj) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        gsy.O00000Oo("CloudVideoSettingActivity", "isOpen:".concat(String.valueOf(bool)));
                        CloudVideoSettingActivity.this.runOnUiThread(new Runnable(bool) {
                            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoSettingActivity$3$iAlxdJzKllrPecw7wfub6ve1kq4 */
                            private final /* synthetic */ Boolean f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                CloudVideoSettingActivity.AnonymousClass3.this.lambda$onCloudVideoSuccess$0$CloudVideoSettingActivity$3(this.f$1);
                            }
                        });
                    }
                }

                public /* synthetic */ void lambda$onCloudVideoSuccess$0$CloudVideoSettingActivity$3(Boolean bool) {
                    CloudVideoSettingActivity.this.sbCloudVideoService.setChecked(bool.booleanValue());
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        gsy.O000000o(6, "CloudVideoSettingActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private void setUsage(final boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("did", this.did);
            jSONObject.put("region", Locale.getDefault().getCountry());
            jSONObject.put("open", z);
            CloudVideoNetUtils.getInstance().setSettingUsage(this, jSONObject.toString(), new ICloudVideoCallback<Boolean>() {
                /* class com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoSettingActivity.AnonymousClass4 */

                public void onCloudVideoSuccess(Boolean bool, Object obj) {
                    if (CloudVideoSettingActivity.this.isFinishing()) {
                    }
                }

                public void onCloudVideoFailed(int i, String str) {
                    if (!CloudVideoSettingActivity.this.isFinishing()) {
                        CloudVideoSettingActivity.this.sbCloudVideoService.setChecked(!z);
                        gsy.O000000o(6, "CloudVideoSettingActivity", "errorCode:" + i + " errorInfo:" + str);
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    public String capacityTranslation(long j) {
        if (j < 1024) {
            try {
                return String.valueOf(j) + "MB";
            } catch (Exception unused) {
            }
        } else if (j < 1048576) {
            return String.valueOf(j / 1024) + "GB";
        } else {
            if (j < 1073741824) {
                return String.valueOf(j / 1048576) + "TB";
            }
            return "MAX";
        }
    }

    public int millisToDay(long j) {
        if (j > 0) {
            return ((int) (j / 86400000)) + 1;
        }
        return 0;
    }
}
