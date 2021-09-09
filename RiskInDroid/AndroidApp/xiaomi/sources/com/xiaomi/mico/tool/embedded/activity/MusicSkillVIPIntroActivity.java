package com.xiaomi.mico.tool.embedded.activity;

import android.os.Bundle;
import android.view.View;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class MusicSkillVIPIntroActivity extends MicoBaseActivity {
    View payButton;
    TitleBar titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_music_skill_vip_intro);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.payButton = findViewById(R.id.title_bar);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.MusicSkillVIPIntroActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                MusicSkillVIPIntroActivity.this.onBackPressed();
            }
        });
        this.payButton.setAlpha(0.3f);
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
