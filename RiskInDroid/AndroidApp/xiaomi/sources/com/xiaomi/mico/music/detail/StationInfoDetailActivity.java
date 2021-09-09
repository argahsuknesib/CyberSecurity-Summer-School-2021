package com.xiaomi.mico.music.detail;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.transformation.CropSquareTransformation;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.widget.ShadeImageView;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.smarthome.R;

public class StationInfoDetailActivity extends MicoBaseActivity {
    ImageView mCover;
    private Music.Station mStation;
    TextView mStationIntro;
    TextView mStationName;
    TitleBar mTitleBar;
    ShadeImageView mask;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int
     arg types: [com.xiaomi.mico.music.detail.StationInfoDetailActivity, int]
     candidates:
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.content.Context, float):int
      com.xiaomi.mico.common.util.DisplayUtils.dip2px(android.app.Activity, float):int */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_detail_station_info);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mCover = (ImageView) findViewById(R.id.img_cover);
        this.mStationName = (TextView) findViewById(R.id.station_name);
        this.mStationIntro = (TextView) findViewById(R.id.station_intro);
        this.mask = (ShadeImageView) findViewById(R.id.back_mask);
        this.mStation = (Music.Station) getIntent().getSerializableExtra("music");
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.detail.$$Lambda$F3vzXkxMxZztrjlcCHmqBwIekag */

            public final void onLeftIconClick() {
                StationInfoDetailActivity.this.finish();
            }
        });
        Music.Station station = this.mStation;
        if (station != null) {
            MusicHelper.loadCenterCover(station.cover, R.drawable.img_cover_error_corner, R.drawable.cover_patchwall_default_rectangle, this.mCover, new CropSquareTransformation(20), DisplayUtils.dip2px((Activity) this, 170.0f));
            this.mStationName.setText(this.mStation.title);
            this.mStationIntro.setText(this.mStation.albumAbstract);
            MusicHelper.loadCoverBackground(this.mStation.cover, this.mask, false);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
