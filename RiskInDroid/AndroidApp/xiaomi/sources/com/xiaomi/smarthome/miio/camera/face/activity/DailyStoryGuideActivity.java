package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.ckb;
import _m_j.ckc;
import _m_j.cku;
import _m_j.clf;
import _m_j.clk;
import _m_j.gpc;
import _m_j.hxi;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.miio.camera.cloudstorage.utils.CloudVideoNetUtils;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import org.json.JSONObject;

public class DailyStoryGuideActivity extends CameraBaseActivity implements View.OnClickListener {
    public ImageView iv_play;
    private LinearLayout ll_purchase_vip;
    public ckc mGeneralVideoPlayer;
    private AnimationDrawable mLoadingAnimation;
    private ImageView mToastImg;
    private TextView tv_purchase;
    private TextView tv_title;
    private TextView tv_turn_on_daily_story;
    private String videoUrl;
    private FrameLayout video_container;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_daily_story_guide);
        this.videoUrl = getIntent().getStringExtra("previewVideo");
        initView();
    }

    private void initView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.tv_title = (TextView) findViewById(R.id.title_bar_title);
        this.tv_title.setText((int) R.string.daily_story);
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mToastImg = (ImageView) findViewById(R.id.toast_icon);
        this.mLoadingAnimation = (AnimationDrawable) getResources().getDrawable(R.drawable.camera_anim_loading);
        this.mToastImg.setImageDrawable(this.mLoadingAnimation);
        this.mLoadingAnimation.start();
        this.iv_play = (ImageView) findViewById(R.id.iv_play);
        this.iv_play.setOnClickListener(this);
        this.ll_purchase_vip = (LinearLayout) findViewById(R.id.ll_purchase_vip);
        this.tv_turn_on_daily_story = (TextView) findViewById(R.id.tv_turn_on_daily_story);
        this.tv_turn_on_daily_story.setOnClickListener(this);
        this.tv_purchase = (TextView) findViewById(R.id.tv_purchase);
        this.tv_purchase.setOnClickListener(this);
        this.video_container = (FrameLayout) findViewById(R.id.video_container);
        this.mGeneralVideoPlayer = cku.O000000o(this, true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, (int) (((float) gpc.O00000Oo(getContext())) * 0.5625f));
        this.mGeneralVideoPlayer.O000000o(new ckb.O00000Oo() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryGuideActivity.AnonymousClass1 */

            public void onPlayerStateChanged(int i) {
                if (i == 4) {
                    DailyStoryGuideActivity.this.mGeneralVideoPlayer.O000000o(0L);
                }
            }
        });
        this.mGeneralVideoPlayer.O000000o(new ckb.O000000o() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryGuideActivity.AnonymousClass2 */

            public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            }

            public void onRenderViewClicked(View view) {
                if (DailyStoryGuideActivity.this.iv_play.getVisibility() == 8) {
                    DailyStoryGuideActivity.this.iv_play.setVisibility(0);
                    DailyStoryGuideActivity.this.iv_play.bringToFront();
                    DailyStoryGuideActivity.this.mGeneralVideoPlayer.O0000OOo();
                    return;
                }
                DailyStoryGuideActivity.this.iv_play.setVisibility(8);
                DailyStoryGuideActivity.this.mGeneralVideoPlayer.O0000Oo0();
            }
        });
        this.video_container.addView(this.mGeneralVideoPlayer.O00000Oo(), layoutParams);
        String str = this.videoUrl;
        if (str != null) {
            this.mGeneralVideoPlayer.O000000o(str, null);
            this.mGeneralVideoPlayer.O0000Oo0();
            this.mLoadingAnimation.stop();
            this.mToastImg.setVisibility(8);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        this.mGeneralVideoPlayer.O00000oo();
    }

    public void onRestart() {
        super.onRestart();
        clf.O0000Oo(this.mCameraDevice.getDid(), this.mCameraDevice.getModel(), new Callback<JSONObject>() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryGuideActivity.AnonymousClass3 */

            public void onSuccess(JSONObject jSONObject) {
                if (DailyStoryGuideActivity.this.isFinishing()) {
                }
            }

            public void onFailure(int i, String str) {
                if (DailyStoryGuideActivity.this.isFinishing()) {
                }
            }
        });
    }

    public void onPause() {
        pauseVideo();
        super.onPause();
    }

    private void pauseVideo() {
        if (this.iv_play.getVisibility() == 8) {
            this.iv_play.setVisibility(0);
            this.iv_play.bringToFront();
            this.mGeneralVideoPlayer.O0000OOo();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            this.mGeneralVideoPlayer.O00000oo();
            finish();
        } else if (view.getId() == R.id.tv_turn_on_daily_story) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_NewOpen_ClickNum", new Object[0]);
            this.mGeneralVideoPlayer.O00000oo();
            clk O00000oO = this.mCameraDevice.O00000oO();
            if (O00000oO.O0000OoO) {
                O00000oO.O0000OoO = false;
                O00000oO.O00000Oo.edit().putBoolean("daily_story_guide", false).apply();
            }
            DailyStoryNetUtils.getInstance().switchDailyStory(this.mDid, this.mCameraDevice.getModel(), true);
            startActivity(new Intent(this, DailyStoryActivity.class));
            finish();
        } else if (view.getId() == R.id.tv_purchase) {
            hxi.O00000o.f952O000000o.O000000o("DailyStory_NewBuyVip_ClickNum", new Object[0]);
            pauseVideo();
            CloudVideoNetUtils.getInstance().openCloudVideoBuyPage(this, this.mCameraDevice.getDid());
        } else if (view.getId() == R.id.iv_play) {
            this.mGeneralVideoPlayer.O0000Oo0();
            this.iv_play.setVisibility(8);
        }
    }
}
