package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.gqg;
import _m_j.hxi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.LocalLicenseUtil;
import com.xiaomi.smarthome.camera.view.widget.XmLoadingDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoWebActivity;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.ClusteringInfos;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.util.ArrayList;

public class FaceManagerGuideActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public static final String TAG = "FaceManagerGuideActivity";
    public boolean alreadyHasFaceInfo = false;
    public String buy_cloud_title;
    public String buy_cloud_url;
    private LinearLayout camera_privacy_container;
    private CheckBox cb_agreement;
    public String cloudUrl;
    public boolean from_lowpower = false;
    private boolean isFromCamera = false;
    public boolean isUsingFreeFaceService;
    private boolean is_vip_user = false;
    private LinearLayout ll_need_buy_cloud;
    private TextView lowpower_privacy;
    private String[] permitArray = {"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private boolean privacy_agreement = true;
    private FrameLayout privacy_container;
    private XmLoadingDialog progressDialog;
    private boolean try_face_use;
    private LinearLayout try_vip_container;
    private TextView tv_face_tips_info;
    private TextView tv_privacy_agreement;
    private TextView tv_to_buy_cloud;
    public TextView tv_to_use;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_manager_first);
        Bundle extras = getIntent().getExtras();
        String str = null;
        if (extras != null) {
            this.from_lowpower = extras.getBoolean("KEY_EXTRA_face_from_lowpower", false);
            this.is_vip_user = extras.getBoolean("KEY_EXTRA_face_is_vip_user", false);
            String string = extras.getString("KEY_EXTRA_face_tips_info", null);
            this.buy_cloud_url = extras.getString("KEY_EXTRA_face_buy_cloud_url", null);
            this.buy_cloud_title = extras.getString("KEY_EXTRA_face_buy_cloud_title", null);
            this.try_face_use = extras.getBoolean("key_extra_try_face", false);
            this.isFromCamera = extras.getBoolean("KEY_EXTRA_face_from_camera", false);
            this.isUsingFreeFaceService = extras.getBoolean("key_extra_is_using_free_service", false);
            this.cloudUrl = extras.getString("key_extra_cloud_url", null);
            str = string;
        }
        initViews();
        initFaceDatas();
        if (!TextUtils.isEmpty(str)) {
            this.tv_face_tips_info.setText(str);
        }
    }

    private void initFaceDatas() {
        mFaceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass1 */

            public void onSuccess(Object obj, Object obj2) {
                FigureInfos figureInfos = (FigureInfos) obj2;
                if (figureInfos == null || figureInfos.figureInfos == null || figureInfos.figureInfos.size() <= 0) {
                    FaceManagerGuideActivity.this.alreadyHasFaceInfo = false;
                    if (FaceManagerBaseActivity.mFaceManager != null) {
                        if (FaceManagerBaseActivity.mFaceManager.getDevice().getModel().equals("chuangmi.camera.ipc022")) {
                            FaceManagerBaseActivity.mFaceManager.getFacesCluster(new FaceManager.IFaceCallback() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass1.AnonymousClass1 */

                                public void onFailure(int i, String str) {
                                }

                                public void onSuccess(Object obj, Object obj2) {
                                    ClusteringInfos clusteringInfos = (ClusteringInfos) obj2;
                                    if (clusteringInfos.clusteringInfos != null && clusteringInfos.clusteringInfos.size() > 0) {
                                        FaceManagerGuideActivity.this.alreadyHasFaceInfo = true;
                                    }
                                }
                            });
                        } else {
                            FaceManagerBaseActivity.mFaceManager.getUnmarkFaces(50, false, new FaceManager.IFaceCallback() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass1.AnonymousClass2 */

                                public void onFailure(int i, String str) {
                                }

                                public void onSuccess(Object obj, Object obj2) {
                                    if (((ArrayList) obj2).size() > 0) {
                                        FaceManagerGuideActivity.this.alreadyHasFaceInfo = true;
                                    }
                                }
                            });
                        }
                    }
                } else {
                    FaceManagerGuideActivity.this.alreadyHasFaceInfo = true;
                }
            }

            public void onFailure(int i, String str) {
                FaceManagerGuideActivity.this.alreadyHasFaceInfo = false;
            }
        });
    }

    private void initViews() {
        this.tv_privacy_agreement = (TextView) findViewById(R.id.tv_privacy_agreement);
        this.tv_face_tips_info = (TextView) findViewById(R.id.tv_face_tips_info);
        this.cb_agreement = (CheckBox) findViewById(R.id.cb_privacy_agreement);
        this.tv_to_use = (TextView) findViewById(R.id.tv_to_use);
        this.tv_to_use.setOnClickListener(this);
        this.tv_to_buy_cloud = (TextView) findViewById(R.id.tv_to_buy_cloud);
        this.ll_need_buy_cloud = (LinearLayout) findViewById(R.id.ll_need_buy_cloud);
        this.try_vip_container = (LinearLayout) findViewById(R.id.try_vip_container);
        this.privacy_container = (FrameLayout) findViewById(R.id.privacy_container);
        this.camera_privacy_container = (LinearLayout) findViewById(R.id.camera_privacy_container);
        this.lowpower_privacy = (TextView) findViewById(R.id.low_power_privacy_agreement);
        this.camera_privacy_container.setVisibility(8);
        this.lowpower_privacy.setVisibility(0);
        if (this.from_lowpower && this.try_face_use && !this.is_vip_user) {
            this.try_vip_container.setVisibility(0);
            this.try_vip_container.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass2 */

                public void onClick(View view) {
                    FaceManagerGuideActivity.this.markUserFreeFaceService();
                }
            });
            this.tv_to_use.setVisibility(8);
            this.ll_need_buy_cloud.setVisibility(8);
        } else if ((this.isFromCamera || this.from_lowpower) && !this.is_vip_user && !this.isUsingFreeFaceService) {
            this.tv_to_use.setVisibility(4);
            this.privacy_container.setVisibility(4);
            this.try_vip_container.setVisibility(8);
            this.ll_need_buy_cloud.setVisibility(0);
            Intent intent = new Intent();
            intent.putExtra("showed_cloud_url", "1");
            setResult(-1, intent);
            this.tv_to_buy_cloud.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass3 */

                public void onClick(View view) {
                    if (!TextUtils.isEmpty(FaceManagerGuideActivity.this.cloudUrl)) {
                        Intent intent = new Intent(FaceManagerGuideActivity.this, CloudVideoWebActivity.class);
                        intent.putExtra("title", FaceManagerGuideActivity.this.getString(R.string.buy_cloud_service));
                        intent.putExtra("url", FaceManagerGuideActivity.this.cloudUrl);
                        intent.putExtra("did", FaceManagerBaseActivity.mFaceManager.getDeviceId());
                        FaceManagerGuideActivity.this.startActivity(intent);
                        FaceManagerGuideActivity.this.finish();
                    } else if (FaceManagerGuideActivity.this.from_lowpower) {
                        Intent intent2 = new Intent(FaceManagerGuideActivity.this, CloudVideoWebActivity.class);
                        intent2.putExtra("title", FaceManagerGuideActivity.this.buy_cloud_title);
                        intent2.putExtra("url", FaceManagerGuideActivity.this.buy_cloud_url);
                        intent2.putExtra("did", FaceManagerBaseActivity.mFaceManager.getDeviceId());
                        FaceManagerGuideActivity.this.startActivity(intent2);
                        FaceManagerGuideActivity.this.finish();
                    } else {
                        hxi.O00000o.f952O000000o.O000000o("Face_NewBuyVip_ClickNum", new Object[0]);
                        CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(FaceManagerGuideActivity.this, FaceManagerBaseActivity.mFaceManager.getDeviceId());
                    }
                }
            });
        } else {
            this.tv_to_use.setVisibility(0);
            this.try_vip_container.setVisibility(8);
            this.ll_need_buy_cloud.setVisibility(8);
        }
        this.cb_agreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass4 */

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (!z) {
                    FaceManagerGuideActivity.this.tv_to_use.setBackground(FaceManagerGuideActivity.this.getResources().getDrawable(R.drawable.bg_wide_button_press_shape));
                    FaceManagerGuideActivity.this.tv_to_use.setEnabled(false);
                    return;
                }
                FaceManagerGuideActivity.this.tv_to_use.setBackground(FaceManagerGuideActivity.this.getResources().getDrawable(R.drawable.bg_wide_button_normal_shape));
                FaceManagerGuideActivity.this.tv_to_use.setEnabled(true);
            }
        });
        this.cb_agreement.setChecked(true);
        AnonymousClass5 r0 = new ClickableSpan() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass5 */

            public void onClick(View view) {
                if ("isa.camera.hlc6".equalsIgnoreCase(FaceManagerBaseActivity.mFaceManager.getModel())) {
                    LocalLicenseUtil.jumpToV3UpgradePrivacyPage(FaceManagerGuideActivity.this);
                    return;
                }
                LocalLicenseUtil.jumpToV3PrivacyPage(FaceManagerGuideActivity.this, !"mijia.camera.v3".equals(FaceManagerBaseActivity.mFaceManager.getModel()));
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(Color.parseColor("#32BAC0"));
            }
        };
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) getString(R.string.privacy_agreement));
        spannableStringBuilder.setSpan(r0, 0, getString(R.string.privacy_agreement).length(), 33);
        this.tv_privacy_agreement.setText(spannableStringBuilder);
        this.tv_privacy_agreement.setMovementMethod(LinkMovementMethod.getInstance());
        this.tv_privacy_agreement.setLineSpacing(0.0f, 1.5f);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
    }

    public void markUserFreeFaceService() {
        showLoadingDialog();
        mFaceManager.markUseFreeFaceService(this, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerGuideActivity.AnonymousClass6 */

            public void onSuccess(Object obj, Object obj2) {
                FaceManagerGuideActivity.this.hideLoadingDialog();
                FaceManagerGuideActivity faceManagerGuideActivity = FaceManagerGuideActivity.this;
                faceManagerGuideActivity.isUsingFreeFaceService = true;
                faceManagerGuideActivity.gotoUseFaceService();
            }

            public void onFailure(int i, String str) {
                FaceManagerGuideActivity.this.hideLoadingDialog();
                gqg.O00000Oo((int) R.string.ble_combo_network_title_error);
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_to_use) {
            gotoUseFaceService();
        } else if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() != R.id.tv_privacy_agreement) {
        } else {
            if (this.privacy_agreement) {
                this.privacy_agreement = false;
                this.tv_privacy_agreement.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.icon_unselected, 0, 0, 0);
                this.tv_to_use.setBackgroundColor(Color.parseColor("#6632BAC0"));
                this.tv_to_use.setEnabled(false);
                return;
            }
            this.privacy_agreement = true;
            this.tv_privacy_agreement.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.icon_selected, 0, 0, 0);
            this.tv_to_use.setBackgroundColor(getResources().getColor(R.color.mj_color_green_normal));
            this.tv_to_use.setEnabled(true);
        }
    }

    public void gotoUseFaceService() {
        Intent intent = new Intent(this, FaceEmptyActivity.class);
        if (this.alreadyHasFaceInfo) {
            if (mFaceManager == null || !mFaceManager.getDevice().getModel().equals("chuangmi.camera.ipc022")) {
                intent.setClass(this, FaceManagerActivity.class);
            } else {
                intent.setClass(this, FaceManager2Activity.class);
            }
        }
        intent.putExtra("isFromRn", getIntent().getBooleanExtra("isFromRn", false));
        startActivity(intent);
        if (this.isUsingFreeFaceService) {
            FaceUtils.setNeedFaceGuideForUsingFreeFaceService(mFaceManager.getDeviceId() + mFaceManager.getDevice().deviceStat().userId, false);
            if (this.is_vip_user) {
                FaceUtils.setNeedFaceGuide(mFaceManager.getDeviceId() + mFaceManager.getDevice().deviceStat().userId, false);
            }
        } else {
            FaceUtils.setNeedFaceGuide(mFaceManager.getDeviceId() + mFaceManager.getDevice().deviceStat().userId, false);
        }
        finish();
    }

    public void showLoadingDialog() {
        XmLoadingDialog xmLoadingDialog = this.progressDialog;
        if (xmLoadingDialog != null && xmLoadingDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
        this.progressDialog = XmLoadingDialog.show(this, getString(R.string.plugin_loading));
        this.progressDialog.show();
    }

    public void hideLoadingDialog() {
        XmLoadingDialog xmLoadingDialog = this.progressDialog;
        if (xmLoadingDialog != null && xmLoadingDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }
}
