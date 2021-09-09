package com.xiaomi.mico.music.favourite;

import com.google.android.material.tabs.TabLayout;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.mico.music.recentplay.BaseTabViewPagerActivity;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends BaseTabViewPagerActivity {
    public void recordCountEvent(TabLayout.Tab tab) {
    }

    public List<TabPagerAdapter.TabPage> getTabPages() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(TabPagerAdapter.TabPage.newPage(new FavAudioBookFragment(), getString(R.string.music_radio)));
        arrayList.add(TabPagerAdapter.TabPage.newPage(new FavArtistFragment(), getString(R.string.music_type_artist)));
        arrayList.add(TabPagerAdapter.TabPage.newPage(new FavAlbumFragment(), getString(R.string.music_type_album)));
        return arrayList;
    }
}
