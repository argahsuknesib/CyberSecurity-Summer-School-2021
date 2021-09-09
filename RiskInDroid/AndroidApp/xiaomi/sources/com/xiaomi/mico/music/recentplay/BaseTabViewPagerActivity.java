package com.xiaomi.mico.music.recentplay;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.mico.base.EditorBarActivity;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.mico.common.editorbar.ActionCallback;
import com.xiaomi.mico.common.widget.PagingViewPager;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.music.favourite.BasePersonalFragment;
import com.xiaomi.smarthome.R;
import java.util.List;

public abstract class BaseTabViewPagerActivity extends EditorBarActivity {
    TabLayout tabLayout;
    TitleBar titleBar;
    PagingViewPager viewPager;

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.activity_favourite;
    }

    /* access modifiers changed from: protected */
    public abstract List<TabPagerAdapter.TabPage> getTabPages();

    public boolean isDarkMode() {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract void recordCountEvent(TabLayout.Tab tab);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(getLayoutId());
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.tabLayout = (TabLayout) findViewById(R.id.favourite_tab_layout);
        this.viewPager = (PagingViewPager) findViewById(R.id.favourite_view_pager);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.recentplay.$$Lambda$u6knCcHEGI53VEQB4OwQbCrAhBA */

            public final void onLeftIconClick() {
                BaseTabViewPagerActivity.this.onBackPressed();
            }
        });
        final TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), getTabPages());
        this.viewPager.setAdapter(tabPagerAdapter);
        this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            /* class com.xiaomi.mico.music.recentplay.BaseTabViewPagerActivity.AnonymousClass1 */

            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabUnselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                ((BasePersonalFragment) tabPagerAdapter.getItem(tab.getPosition())).updateEditorBarSelector();
                BaseTabViewPagerActivity.this.recordCountEvent(tab);
            }
        });
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.editorBar.addActionCallback(new ActionCallback() {
            /* class com.xiaomi.mico.music.recentplay.BaseTabViewPagerActivity.AnonymousClass2 */

            public void onActionStarted() {
                onAction(true);
            }

            public void onActionFinished() {
                onAction(false);
            }

            private void onAction(boolean z) {
                int i = 0;
                BaseTabViewPagerActivity.this.tabLayout.setVisibility(z ? 8 : 0);
                if (z) {
                    i = BaseTabViewPagerActivity.this.getResources().getDimensionPixelSize(R.dimen.common_bottom_bar_height);
                }
                ((LinearLayout.LayoutParams) BaseTabViewPagerActivity.this.viewPager.getLayoutParams()).bottomMargin = i;
                BaseTabViewPagerActivity.this.viewPager.setPagingEnabled(!z);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
