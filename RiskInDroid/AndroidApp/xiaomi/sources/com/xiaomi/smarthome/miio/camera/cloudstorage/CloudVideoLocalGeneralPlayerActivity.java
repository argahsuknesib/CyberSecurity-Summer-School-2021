package com.xiaomi.smarthome.miio.camera.cloudstorage;

import _m_j.ckv;
import _m_j.hzf;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mijia.generalplayer.videoview.BasicVideoView;
import com.mijia.generalplayer.videoview.GeneralVideoView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.util.Map;

public class CloudVideoLocalGeneralPlayerActivity extends CloudVideoBaseActivity implements View.OnClickListener {
    private GeneralVideoView generalVideoView;
    private ImageView ivHeaderLeftBack;
    private ImageView ivHeaderRightSetting;
    private RelativeLayout rlTitleBar;
    private TextView tvTitleBarTitle;
    private String videoM3U8LocalPath = null;
    private ViewGroup videoViewParent;

    public boolean supportOrientationListen() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_local_general_player);
        initViews();
    }

    private void initViews() {
        this.videoM3U8LocalPath = getIntent().getStringExtra("m3u8LocalPath");
        if (!TextUtils.isEmpty(this.videoM3U8LocalPath) && this.videoM3U8LocalPath.toLowerCase().equals("null")) {
            this.videoM3U8LocalPath = null;
        }
        this.rlTitleBar = (RelativeLayout) findViewById(R.id.rlTitleBar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.rlTitleBar.getLayoutParams());
        layoutParams.setMargins(0, hzf.O000000o(CommonApplication.getAppContext()), 0, 0);
        this.rlTitleBar.setLayoutParams(layoutParams);
        this.rlTitleBar.bringToFront();
        this.videoViewParent = (ViewGroup) findViewById(R.id.videoViewParent);
        this.generalVideoView = new GeneralVideoView(this);
        this.videoViewParent.addView(this.generalVideoView);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        generalVideoView2.O000000o((String) null, "local:" + this.videoM3U8LocalPath);
        this.generalVideoView.setOnConfigurationChangedListener(new BasicVideoView.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.cloudstorage.$$Lambda$CloudVideoLocalGeneralPlayerActivity$ddEjyRfcFX5I5R4_wZs4RbWcIFQ */

            public final void onChangeOrientation(boolean z) {
                CloudVideoLocalGeneralPlayerActivity.this.lambda$initViews$0$CloudVideoLocalGeneralPlayerActivity(z);
            }
        });
        this.generalVideoView.O000000o((int[]) null, (ckv.O000000o) null);
        this.ivHeaderLeftBack = (ImageView) findViewById(R.id.ivHeaderLeftBack);
        this.ivHeaderLeftBack.setImageResource(R.drawable.std_tittlebar_main_device_back_white);
        this.ivHeaderLeftBack.setOnClickListener(this);
        this.tvTitleBarTitle = (TextView) findViewById(R.id.tvTitleBarTitle);
        this.tvTitleBarTitle.setVisibility(0);
        this.tvTitleBarTitle.setTextColor(getResources().getColor(R.color.mj_color_black));
        this.ivHeaderRightSetting = (ImageView) findViewById(R.id.ivHeaderRightSetting);
        this.ivHeaderRightSetting.setVisibility(8);
        parseM3U8Folder();
        parseFileName();
        if (!TextUtils.isEmpty(this.videoM3U8LocalPath)) {
            this.generalVideoView.O000000o(this.videoM3U8LocalPath, (Map<String, String>) null);
        }
    }

    public /* synthetic */ void lambda$initViews$0$CloudVideoLocalGeneralPlayerActivity(boolean z) {
        this.rlTitleBar.setVisibility(z ? 0 : 8);
        ViewGroup.LayoutParams layoutParams = this.videoViewParent.getLayoutParams();
        int i = -1;
        layoutParams.width = -1;
        if (z) {
            i = -2;
        }
        layoutParams.height = i;
        this.videoViewParent.setLayoutParams(layoutParams);
    }

    private void parseM3U8Folder() {
        if (!TextUtils.isEmpty(this.videoM3U8LocalPath)) {
            File file = new File(this.videoM3U8LocalPath);
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (file2.getAbsolutePath().endsWith("plain.m3u8")) {
                        this.videoM3U8LocalPath = file2.getAbsolutePath();
                        return;
                    }
                }
            }
        }
    }

    private void parseFileName() {
        String str;
        if (!TextUtils.isEmpty(this.videoM3U8LocalPath)) {
            String str2 = this.videoM3U8LocalPath;
            str = str2.substring(str2.lastIndexOf("/") + 1);
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            this.tvTitleBarTitle.setText(str);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        GeneralVideoView generalVideoView2 = this.generalVideoView;
        if (generalVideoView2 != null) {
            generalVideoView2.O000000o(configuration);
        }
        boolean z = true;
        if (configuration.orientation != 1) {
            z = false;
        }
        if (!z) {
            hideStatusBar();
        }
    }

    /* access modifiers changed from: protected */
    public void hideStatusBar() {
        getWindow().clearFlags(2048);
        getWindow().clearFlags(1024);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(1024);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.ivHeaderLeftBack) {
            onBackPressed();
        }
    }
}
