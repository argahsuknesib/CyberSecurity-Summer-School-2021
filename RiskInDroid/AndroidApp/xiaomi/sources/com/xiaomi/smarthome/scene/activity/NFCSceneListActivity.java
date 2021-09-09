package com.xiaomi.smarthome.scene.activity;

import _m_j.ee;
import _m_j.eh;
import _m_j.gwg;
import _m_j.hih;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.material.tabs.TabLayout;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.NFCSceneListFragment;
import com.xiaomi.smarthome.scene.SceneLogFragment;
import java.util.ArrayList;
import java.util.List;

public class NFCSceneListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10786O000000o;
    private View O00000Oo;
    private View O00000o0;
    public int mCurrentIndex;
    public List<Fragment> mFragmentList = new ArrayList();
    @BindView(5817)
    View mLoadingView;
    public NFCSceneListFragment mMyDeviceScene;
    @BindView(5822)
    ImageView mReturnIV;
    public SceneLogFragment mSceneLog;
    @BindView(6310)
    TabLayout mTabLayout;
    public String[] mTitleItems;
    @BindView(5826)
    TextView mTitleTV;
    @BindView(6575)
    ViewPager mViewPager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_nfc_scene_list);
        ButterKnife.bind(this);
        this.mTitleTV.setText((int) R.string.nfc_scene_list_title);
        this.mReturnIV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$NFCSceneListActivity$B34EC_Jzod3rdGXqfZx_Bx2SxyU */

            public final void onClick(View view) {
                NFCSceneListActivity.this.O000000o(view);
            }
        });
        this.mTitleItems = new String[]{getResources().getString(R.string.scene_plugin_title), getResources().getString(R.string.smarthome_new_scene_log)};
        Bundle bundle2 = new Bundle();
        bundle2.putString("from", "nfc_list");
        bundle2.putString("device_id", "nfctag");
        if (this.mMyDeviceScene == null) {
            this.mMyDeviceScene = new NFCSceneListFragment();
            this.mMyDeviceScene.setArguments(bundle2);
        }
        if (this.mSceneLog == null) {
            this.mSceneLog = new SceneLogFragment();
            this.mSceneLog.setArguments(bundle2);
        }
        if (this.f10786O000000o == null) {
            this.f10786O000000o = new O000000o(getSupportFragmentManager());
            this.mViewPager.setAdapter(this.f10786O000000o);
            this.mTabLayout.setTabMode(1);
            this.mTabLayout.setupWithViewPager(this.mViewPager);
            this.mTabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
                /* class com.xiaomi.smarthome.scene.activity.NFCSceneListActivity.AnonymousClass1 */

                public final void onTabReselected(TabLayout.Tab tab) {
                }

                public final void onTabUnselected(TabLayout.Tab tab) {
                }

                public final void onTabSelected(TabLayout.Tab tab) {
                    NFCSceneListActivity.this.mCurrentIndex = tab.getPosition();
                    if (NFCSceneListActivity.this.mCurrentIndex == NFCSceneListActivity.this.mFragmentList.size() - 1 && (NFCSceneListActivity.this.f10786O000000o.getItem(NFCSceneListActivity.this.f10786O000000o.getCount() - 1) instanceof SceneLogFragment)) {
                        ((SceneLogFragment) NFCSceneListActivity.this.f10786O000000o.getItem(NFCSceneListActivity.this.f10786O000000o.getCount() - 1)).onPageSelected();
                    }
                    hih.O000000o("smarthome-nfc", "onTabSelected" + tab.getPosition());
                }
            });
        }
        O000000o o000000o = this.f10786O000000o;
        NFCSceneListActivity.this.mFragmentList.clear();
        NFCSceneListActivity.this.mFragmentList.add(NFCSceneListActivity.this.mMyDeviceScene);
        NFCSceneListActivity.this.mFragmentList.add(NFCSceneListActivity.this.mSceneLog);
        o000000o.notifyDataSetChanged();
        this.mTabLayout.getTabAt(0).select();
        this.mLoadingView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }

    public void onBackPressed() {
        int i;
        if (this.mFragmentList.size() != 2 || (i = this.mCurrentIndex) != 0) {
            super.onBackPressed();
        } else if (this.mFragmentList.get(i) instanceof NFCSceneListFragment) {
            ((NFCSceneListFragment) this.mFragmentList.get(this.mCurrentIndex)).O000000o(this);
        }
    }

    public View getChooseSceneTitleBar() {
        if (this.O00000Oo == null) {
            this.O00000Oo = ((ViewStub) findViewById(R.id.title_bar_choose_scene_stub)).inflate();
            gwg.O000000o(getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding), findViewById(R.id.title_bar_choose_scene));
        }
        return this.O00000Oo;
    }

    public View getChooseSceneMenuBar() {
        if (this.O00000o0 == null) {
            this.O00000o0 = ((ViewStub) findViewById(R.id.menu_choose_scene_stub)).inflate();
        }
        return this.O00000o0;
    }

    class O000000o extends eh {
        public final int getItemPosition(Object obj) {
            return -2;
        }

        public O000000o(ee eeVar) {
            super(eeVar);
        }

        public final CharSequence getPageTitle(int i) {
            return NFCSceneListActivity.this.mTitleItems[i];
        }

        public final Fragment getItem(int i) {
            if (i < NFCSceneListActivity.this.mFragmentList.size()) {
                return NFCSceneListActivity.this.mFragmentList.get(i);
            }
            return null;
        }

        public final int getCount() {
            return NFCSceneListActivity.this.mFragmentList.size();
        }

        public final long getItemId(int i) {
            if (!(NFCSceneListActivity.this.mFragmentList.get(i) instanceof NFCSceneListFragment) && (NFCSceneListActivity.this.mFragmentList.get(i) instanceof SceneLogFragment)) {
                return 1;
            }
            return 0;
        }
    }
}
