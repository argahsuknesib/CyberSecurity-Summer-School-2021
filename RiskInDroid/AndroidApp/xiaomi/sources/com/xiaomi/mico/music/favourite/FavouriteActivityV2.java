package com.xiaomi.mico.music.favourite;

import android.os.Bundle;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.base.EditorBarActivity;
import com.xiaomi.mico.common.adapter.SimplePagerAdapter;
import com.xiaomi.mico.common.editorbar.ActionCallback;
import com.xiaomi.mico.common.widget.PagingViewPager;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class FavouriteActivityV2 extends EditorBarActivity {
    protected ApiRequest mApiRequest;
    TabLayout mTabLayout;
    TitleBar mTitleBar;
    PagingViewPager mViewPager;
    private String pageType;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_favourite);
        this.mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        this.mTabLayout = (TabLayout) findViewById(R.id.favourite_tab_layout);
        this.mViewPager = (PagingViewPager) findViewById(R.id.favourite_view_pager);
        this.mTabLayout.setVisibility(8);
        this.pageType = getIntent().getStringExtra("PAGE_TYPE");
        this.mTitleBar.setTitle((int) R.string.music_my_collection);
        this.mTitleBar.showDivider();
        this.mTitleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$FavouriteActivityV2$Rl4iPZtUL5NKcV3p0B_bsGw6oI */

            public final void onLeftIconClick() {
                FavouriteActivityV2.this.lambda$onCreate$0$FavouriteActivityV2();
            }
        });
        FavStationFragmentV2 favStationFragmentV2 = new FavStationFragmentV2();
        Bundle bundle2 = new Bundle();
        bundle2.putString("PAGE_TYPE", this.pageType);
        favStationFragmentV2.setArguments(bundle2);
        this.mViewPager.setAdapter(new SimplePagerAdapter(getSupportFragmentManager(), favStationFragmentV2));
        favStationFragmentV2.updateEditorBarSelector();
        this.editorBar.addActionCallback(new ActionCallback() {
            /* class com.xiaomi.mico.music.favourite.FavouriteActivityV2.AnonymousClass1 */

            public void onActionStarted() {
                onAction(true);
            }

            public void onActionFinished() {
                onAction(false);
            }

            private void onAction(boolean z) {
                ((LinearLayout.LayoutParams) FavouriteActivityV2.this.mViewPager.getLayoutParams()).bottomMargin = z ? FavouriteActivityV2.this.getResources().getDimensionPixelSize(R.dimen.common_bottom_bar_height) : 0;
                FavouriteActivityV2.this.mViewPager.setPagingEnabled(!z);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$FavouriteActivityV2() {
        finish();
    }
}
