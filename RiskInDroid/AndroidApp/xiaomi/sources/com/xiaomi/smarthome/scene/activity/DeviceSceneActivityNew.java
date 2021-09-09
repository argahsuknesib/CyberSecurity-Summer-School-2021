package com.xiaomi.smarthome.scene.activity;

import _m_j.ee;
import _m_j.eh;
import _m_j.fno;
import _m_j.ftn;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hng;
import _m_j.hnw;
import _m_j.hpq;
import _m_j.hxi;
import _m_j.hxk;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseWhiteActivity;
import com.xiaomi.smarthome.scene.SceneLogFragment;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneTab;
import com.xiaomi.smarthome.scene.widget.SceneTabIndicator;
import java.util.ArrayList;
import java.util.List;

public class DeviceSceneActivityNew extends BaseWhiteActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f10661O000000o;
    String O00000Oo;
    private Context O00000o;
    private LayoutInflater O00000o0;
    private View O00000oO;
    private View O00000oo;
    private Device O0000O0o;
    public fvm mCurrentFragment = null;
    public List<fvm> mFragmentList = new ArrayList();
    @BindView(6410)
    SceneTabIndicator mIndicator;
    @BindView(5817)
    View mLoadingView;
    public MyDeviceSceneFragmentNew mMyDeviceScene;
    public RecommendSceneTab mPluginRecommend;
    @BindView(5822)
    ImageView mReturnIV;
    @BindView(5832)
    ImageView mRightTitleIV;
    public SceneLogFragment mSceneLog;
    public String[] mTitleItems;
    @BindView(5826)
    TextView mTitleTV;
    @BindView(6575)
    ViewPager mViewPager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_scene_tab_layout);
        ButterKnife.bind(this);
        this.O00000o = this;
        this.O00000o0 = LayoutInflater.from(this.O00000o);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.O00000Oo = getIntent().getStringExtra("device_id");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            finish();
            return;
        }
        this.O0000O0o = fno.O000000o().O00000o0(this.O00000Oo);
        Device device = this.O0000O0o;
        if (device == null) {
            finish();
        } else if (device == null || device.isOwner()) {
            if (getIntent().getBooleanExtra("is_from_home", false)) {
                hxi.O00000oO.O0000Oo(this.O0000O0o.model, "plugin");
            } else {
                hxi.O00000oO.O0000Oo(this.O0000O0o.model, "gt");
            }
            this.mTitleTV.setText((int) R.string.device_more_setting_scence);
            if (!ftn.O00000oO(ServiceApplication.getAppContext())) {
                this.mTitleItems = new String[]{getResources().getString(R.string.smarthome_new_scene_recommend), getResources().getString(R.string.smarthome_new_scene_custom), getResources().getString(R.string.smarthome_new_scene_log)};
                O000000o();
            } else {
                this.mTitleItems = new String[]{getResources().getString(R.string.scene_plugin_title), getResources().getString(R.string.smarthome_new_scene_log)};
                O000000o();
            }
            this.mReturnIV.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.DeviceSceneActivityNew.AnonymousClass1 */

                public final void onClick(View view) {
                    DeviceSceneActivityNew.this.finish();
                }
            });
            this.mRightTitleIV.setVisibility(0);
            this.mRightTitleIV.setContentDescription(getString(R.string.add_scene));
            this.mRightTitleIV.setImageResource(R.drawable.home_icon_add_2);
            this.mRightTitleIV.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.DeviceSceneActivityNew.AnonymousClass2 */

                public final void onClick(View view) {
                    if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                        hnw.O000000o(DeviceSceneActivityNew.this);
                        return;
                    }
                    hxk hxk = hxi.O00000o;
                    String O0000OOo = ggb.O00000Oo().O0000OOo();
                    String str = DeviceSceneActivityNew.this.O00000Oo;
                    hxk.f952O000000o.O000000o("scene_plus_click", "homeid", O0000OOo, "did", str);
                    hpq.O000000o().O000000o((SceneApi.O000OOOo) null);
                    Intent intent = new Intent(DeviceSceneActivityNew.this, SmarthomeCreateAutoSceneActivity.class);
                    intent.putExtra("extra_device_id", DeviceSceneActivityNew.this.O00000Oo);
                    intent.putExtra("from", 1);
                    DeviceSceneActivityNew.this.startActivity(intent);
                }
            });
        } else {
            gqg.O00000Oo((int) R.string.device_no_owner_not_support_automation);
            finish();
        }
    }

    private void O000000o() {
        Bundle bundle = new Bundle();
        bundle.putString("device_id", this.O00000Oo);
        if (this.mPluginRecommend == null) {
            this.mPluginRecommend = new RecommendSceneTab();
            this.mPluginRecommend.setArguments(bundle);
        }
        if (this.mMyDeviceScene == null) {
            this.mMyDeviceScene = new MyDeviceSceneFragmentNew();
            this.mMyDeviceScene.setArguments(bundle);
        }
        if (this.mSceneLog == null) {
            this.mSceneLog = new SceneLogFragment();
            this.mSceneLog.setArguments(bundle);
        }
        if (this.f10661O000000o == null) {
            this.f10661O000000o = new O000000o(getSupportFragmentManager());
            this.mViewPager.setAdapter(this.f10661O000000o);
            this.mViewPager.addOnPageChangeListener(new ViewPager.O0000O0o() {
                /* class com.xiaomi.smarthome.scene.activity.DeviceSceneActivityNew.AnonymousClass3 */

                public final void onPageScrolled(int i, float f, int i2) {
                    DeviceSceneActivityNew.this.mIndicator.O000000o(i, f, i2);
                }

                public final void onPageSelected(int i) {
                    DeviceSceneActivityNew.this.mIndicator.O000000o(i);
                    fvm fvm = DeviceSceneActivityNew.this.mCurrentFragment;
                    fvm fvm2 = (fvm) DeviceSceneActivityNew.this.f10661O000000o.getItem(i);
                    if (!(fvm == null || fvm == fvm2)) {
                        fvm.onPageDeselected();
                    }
                    DeviceSceneActivityNew deviceSceneActivityNew = DeviceSceneActivityNew.this;
                    deviceSceneActivityNew.mCurrentFragment = fvm2;
                    if (deviceSceneActivityNew.mCurrentFragment != null) {
                        DeviceSceneActivityNew.this.mCurrentFragment.onPageSelected();
                    }
                }

                public final void onPageScrollStateChanged(int i) {
                    DeviceSceneActivityNew.this.mIndicator.O00000Oo(i);
                }
            });
            this.mIndicator.f11333O000000o = this.mViewPager;
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                String[] strArr = this.mTitleItems;
                if (i >= strArr.length) {
                    break;
                }
                arrayList.add(strArr[i]);
                i++;
            }
            this.mIndicator.O000000o(arrayList);
        }
        this.f10661O000000o.O000000o();
        this.mIndicator.setCurrentItem(0);
        this.mCurrentFragment = this.mFragmentList.get(0);
        this.mCurrentFragment.onPageSelected();
        this.mLoadingView.setVisibility(8);
    }

    class O000000o extends eh {
        public final int getItemPosition(Object obj) {
            return -2;
        }

        public O000000o(ee eeVar) {
            super(eeVar);
        }

        public final void O000000o() {
            DeviceSceneActivityNew.this.mFragmentList.clear();
            if (DeviceSceneActivityNew.this.mTitleItems.length == 3) {
                DeviceSceneActivityNew.this.mFragmentList.add(DeviceSceneActivityNew.this.mPluginRecommend);
            }
            DeviceSceneActivityNew.this.mFragmentList.add(DeviceSceneActivityNew.this.mMyDeviceScene);
            DeviceSceneActivityNew.this.mFragmentList.add(DeviceSceneActivityNew.this.mSceneLog);
            notifyDataSetChanged();
        }

        public final CharSequence getPageTitle(int i) {
            return DeviceSceneActivityNew.this.mTitleItems[i];
        }

        public final Fragment getItem(int i) {
            if (i < DeviceSceneActivityNew.this.mFragmentList.size()) {
                return DeviceSceneActivityNew.this.mFragmentList.get(i);
            }
            return null;
        }

        public final int getCount() {
            return DeviceSceneActivityNew.this.mFragmentList.size();
        }

        public final long getItemId(int i) {
            if (DeviceSceneActivityNew.this.mFragmentList.get(i) instanceof hng) {
                return 0;
            }
            if (DeviceSceneActivityNew.this.mFragmentList.get(i) instanceof MyDeviceSceneFragmentNew) {
                return 1;
            }
            if (DeviceSceneActivityNew.this.mFragmentList.get(i) instanceof SceneLogFragment) {
                return 2;
            }
            return 0;
        }
    }

    public View getChooseSceneTitleBar() {
        if (this.O00000oO == null) {
            this.O00000oO = ((ViewStub) findViewById(R.id.title_bar_choose_scene_stub)).inflate();
            gwg.O000000o(getResources().getDimensionPixelSize(R.dimen.title_bar_top_padding), findViewById(R.id.title_bar_choose_scene));
        }
        return this.O00000oO;
    }

    public void onResume() {
        super.onResume();
        gwg.O00000Oo(getWindow());
        fvm fvm = this.mCurrentFragment;
        if (fvm != null) {
            if (fvm instanceof RecommendSceneTab) {
                ((RecommendSceneTab) fvm).O0000O0o();
            }
            this.mCurrentFragment.refreshTitleBar();
            gsy.O000000o(3, "DeviceSceneActivityNew", "onPageResume:" + this.mCurrentFragment.getClass().getName());
        }
    }

    public View getChooseSceneMenuBar() {
        if (this.O00000oo == null) {
            this.O00000oo = ((ViewStub) findViewById(R.id.menu_choose_scene_stub)).inflate();
        }
        return this.O00000oo;
    }

    public void onBackPressed() {
        fvm fvm = this.mCurrentFragment;
        if (fvm instanceof MyDeviceSceneFragmentNew) {
            MyDeviceSceneFragmentNew myDeviceSceneFragmentNew = (MyDeviceSceneFragmentNew) fvm;
            if (myDeviceSceneFragmentNew.O00000oO == 1) {
                myDeviceSceneFragmentNew.O00000o0();
            } else {
                finish();
            }
        } else {
            super.onBackPressed();
        }
    }
}
