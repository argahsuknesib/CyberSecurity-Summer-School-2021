package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.gqg;
import _m_j.gwg;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.miio.camera.face.adapter.DailyStoryAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStory;
import com.xiaomi.smarthome.miio.camera.face.model.DailyStoryList;
import com.xiaomi.smarthome.miio.camera.face.util.DailyStoryNetUtils;
import java.util.Locale;

public class DailyStoryActivity extends CameraBaseActivity implements View.OnClickListener, DailyStoryAdapter.ClickCallBack {
    private final int REQUEST_VIDEO_PLAY = 1001;
    public DailyStoryAdapter dailyStoryAdapter;
    private ImageView daily_story_family;
    private ImageView daily_story_pet;
    private ImageView iv_family_selected;
    private ImageView iv_pet_selected;
    public LinearLayout ll_daily_story_closed_tip;
    public RelativeLayout ll_empty_content;
    private int mCategory = 1;
    private String region;
    public RecyclerView rv_daily_story_list;
    private ImageView title_bar_more;
    public TextView tv_empty_tip;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.activity_daily_story);
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo != null) {
            this.region = O00oOooo.getCountry();
        } else {
            this.region = Locale.getDefault().getCountry();
        }
        initView();
    }

    private void initView() {
        gwg.O000000o(findViewById(R.id.title_bar_container));
        ((TextView) findViewById(R.id.title_bar_title)).setText(getString(R.string.daily_story));
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.title_bar_more = (ImageView) findViewById(R.id.title_bar_more);
        if (this.mCameraDevice.isReadOnlyShared()) {
            this.title_bar_more.setVisibility(8);
        } else {
            this.title_bar_more.setImageResource(R.drawable.mj_webp_titlebar_setting_nor);
            this.title_bar_more.setOnClickListener(this);
        }
        this.ll_daily_story_closed_tip = (LinearLayout) findViewById(R.id.ll_daily_story_closed_tip);
        this.ll_empty_content = (RelativeLayout) findViewById(R.id.ll_empty_content);
        this.daily_story_family = (ImageView) findViewById(R.id.daily_story_family);
        this.daily_story_family.setOnClickListener(this);
        this.daily_story_pet = (ImageView) findViewById(R.id.daily_story_pet);
        this.daily_story_pet.setOnClickListener(this);
        this.iv_family_selected = (ImageView) findViewById(R.id.iv_family_selected);
        this.iv_pet_selected = (ImageView) findViewById(R.id.iv_pet_selected);
        this.rv_daily_story_list = (RecyclerView) findViewById(R.id.rv_daily_story_list);
        this.rv_daily_story_list.setLayoutManager(new LinearLayoutManager(this));
        this.dailyStoryAdapter = new DailyStoryAdapter(this, this, this.mDid);
        this.rv_daily_story_list.setAdapter(this.dailyStoryAdapter);
        this.tv_empty_tip = (TextView) findViewById(R.id.tv_empty_tip);
        findViewById(R.id.tv_turn_on_daily_story).setOnClickListener(this);
        refreshUI(this.mCategory);
    }

    private void refreshUI(int i) {
        this.mCategory = i;
        if (i == 1) {
            this.iv_family_selected.setVisibility(0);
            this.iv_pet_selected.setVisibility(8);
        } else {
            this.iv_family_selected.setVisibility(8);
            this.iv_pet_selected.setVisibility(0);
        }
        loadData(i);
    }

    private void loadData(int i) {
        DailyStoryNetUtils.getInstance().getDailyStoryList(this.mDid, i, this.mCameraDevice.getModel(), this.region, new DailyStoryNetUtils.ICallback<DailyStoryList>() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.DailyStoryActivity.AnonymousClass1 */

            public void onSuccess(DailyStoryList dailyStoryList) {
                DailyStoryActivity.this.dailyStoryAdapter.setData(dailyStoryList.playUnits);
                DailyStoryActivity.this.dailyStoryAdapter.setRollingSaveInterval(dailyStoryList.rollingSaveInterval);
                if (dailyStoryList.playUnits.size() == 0) {
                    DailyStoryActivity.this.ll_empty_content.setVisibility(0);
                    DailyStoryActivity.this.tv_empty_tip.setText(String.format(DailyStoryActivity.this.getResources().getString(R.string.daily_story_empty_content_tips2), Long.valueOf(dailyStoryList.rollingSaveInterval / 86400000)));
                    DailyStoryActivity.this.rv_daily_story_list.setVisibility(8);
                }
                if (dailyStoryList.switchStatus == 0) {
                    DailyStoryActivity.this.ll_daily_story_closed_tip.setVisibility(0);
                } else {
                    DailyStoryActivity.this.ll_daily_story_closed_tip.setVisibility(8);
                }
            }

            public void onFailure(int i, String str) {
                gqg.O00000Oo((int) R.string.action_fail);
            }
        });
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            finish();
        } else if (view.getId() == R.id.title_bar_more) {
            startActivityForResult(new Intent(this, DailyStorySettingActivity.class), 1001);
        } else if (view.getId() == R.id.tv_turn_on_daily_story) {
            DailyStoryNetUtils.getInstance().switchDailyStory(this.mDid, this.mCameraDevice.getModel(), true);
            loadData(this.mCategory);
        } else if (view.getId() == R.id.daily_story_family) {
            refreshUI(1);
        } else if (view.getId() == R.id.daily_story_pet) {
            refreshUI(2);
        }
    }

    public void onRecyclerClick(int i) {
        hxi.O00000o.f952O000000o.O000000o("DailyStory_VideoPlay_ClickNum", new Object[0]);
        Intent intent = new Intent();
        intent.setClass(this, DailyStoryPlayActivity.class);
        DailyStory dailyStory = this.dailyStoryAdapter.getData().get(i);
        intent.putExtra("fileId", dailyStory.fileId);
        intent.putExtra("region", this.region);
        intent.putExtra("duration", dailyStory.duration);
        intent.putExtra("createTime", dailyStory.createTime);
        intent.putExtra("category", this.mCategory);
        startActivityForResult(intent, 1001);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            loadData(this.mCategory);
        }
    }
}
