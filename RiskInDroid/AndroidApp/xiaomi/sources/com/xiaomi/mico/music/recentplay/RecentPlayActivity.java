package com.xiaomi.mico.music.recentplay;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class RecentPlayActivity extends BaseTabViewPagerActivity {
    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.mico_recent_play_activity;
    }

    /* access modifiers changed from: protected */
    public void recordCountEvent(TabLayout.Tab tab) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.titleBar.setTitle((int) R.string.music_recent);
    }

    /* access modifiers changed from: protected */
    public List<TabPagerAdapter.TabPage> getTabPages() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(TabPagerAdapter.TabPage.newPage(new RecentPlaySongFragment(), getString(R.string.recent_play_song)));
        arrayList.add(TabPagerAdapter.TabPage.newPage(new RecentPlayAudioBooksFragment(), getString(R.string.music_radio)));
        return arrayList;
    }
}
