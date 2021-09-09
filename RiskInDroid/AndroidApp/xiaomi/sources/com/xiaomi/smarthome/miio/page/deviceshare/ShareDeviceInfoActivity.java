package com.xiaomi.smarthome.miio.page.deviceshare;

import _m_j.ee;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fvm;
import _m_j.gqp;
import _m_j.gwg;
import _m_j.gxw;
import _m_j.gxx;
import _m_j.hxi;
import _m_j.hzf;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.TabPageIndicator;
import com.xiaomi.smarthome.library.common.widget.ViewPager;
import com.xiaomi.smarthome.library.common.widget.ViewPagerWithSwipeEnable;
import java.util.ArrayList;
import java.util.List;

public class ShareDeviceInfoActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private TabPageIndicator f9905O000000o;
    private int O00000Oo = 0;
    private TextView O00000o;
    private TextView O00000o0;
    private TextView O00000oO;
    public O000000o mAdapter;
    public Intent mIntent;
    public ViewPagerWithSwipeEnable mViewPager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mIntent = getIntent();
        String stringExtra = this.mIntent.getStringExtra("user_id");
        if (TextUtils.isEmpty(stringExtra) || !stringExtra.equalsIgnoreCase(CoreApi.O000000o().O0000o0())) {
            fbt fbt = new fbt(ServiceApplication.getAppContext(), "AccountConflictActivity");
            fbt.O00000Oo(268435456);
            fbs.O000000o(fbt);
            finish();
            return;
        }
        setContentView((int) R.layout.activity_share_device_layout);
        this.mAdapter = new O000000o(getSupportFragmentManager());
        this.mViewPager = (ViewPagerWithSwipeEnable) findViewById(R.id.pager);
        this.mViewPager.setAdapter(this.mAdapter);
        this.mViewPager.setOffscreenPageLimit(2);
        this.f9905O000000o = (TabPageIndicator) findViewById(R.id.indicator);
        this.f9905O000000o.setViewPager(this.mViewPager);
        this.f9905O000000o.setVisibility(8);
        this.f9905O000000o.setOnPageChangeListener(new ViewPager.O00000o0() {
            /* class com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity.AnonymousClass1 */

            public final void b_(int i) {
                if (i != 0) {
                }
            }

            public final void c_(int i) {
                if (i == 0) {
                    ShareDeviceInfoActivity.this.setLeftTitleTvSelected();
                } else {
                    ShareDeviceInfoActivity.this.setRightTitleTvSelected();
                }
                fvm fvm = (fvm) ShareDeviceInfoActivity.this.mAdapter.O000000o(i);
                if (fvm != null) {
                    fvm.onPageSelected();
                }
                if (i == 1) {
                    hxi.O00000o.f952O000000o.O000000o("mine_deviceshare_accept", new Object[0]);
                }
            }
        });
        this.O00000o0 = (TextView) findViewById(R.id.module_a_3_return_title);
        this.O00000o0.setText((int) R.string.miio_setting_share);
        this.O00000o = (TextView) findViewById(R.id.module_a_3_return_title_left);
        this.O00000o.setText((int) R.string.sh_share_2);
        this.O00000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity.AnonymousClass2 */

            public final void onClick(View view) {
                ShareDeviceInfoActivity.this.mViewPager.setCurrentItem(0);
            }
        });
        this.O00000oO = (TextView) findViewById(R.id.module_a_3_return_title_right);
        this.O00000oO.setText((int) R.string.accept);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity.AnonymousClass3 */

            public final void onClick(View view) {
                ShareDeviceInfoActivity.this.mViewPager.setCurrentItem(1);
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.page.deviceshare.ShareDeviceInfoActivity.AnonymousClass4 */

            public final void onClick(View view) {
                ShareDeviceInfoActivity.this.finish();
                hxi.O00000o.f952O000000o.O000000o("mine_deviceshare_back", new Object[0]);
            }
        });
        setLeftTitleTvSelected();
        if (gwg.O000000o((Activity) this)) {
            View findViewById = findViewById(R.id.top_delete_bar);
            int O000000o2 = hzf.O000000o(CommonApplication.getAppContext());
            findViewById.getLayoutParams().height += O000000o2;
            findViewById.setPadding(0, findViewById.getPaddingTop() + O000000o2, 0, 0);
            findViewById.setLayoutParams(findViewById.getLayoutParams());
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void setViewPagerSwipe(boolean z) {
        this.mViewPager.setSwipeEnabled(z);
    }

    public void setLeftTitleTvSelected() {
        this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
        this.O00000oO.setTextColor(getResources().getColor(R.color.mj_color_gray_lighter));
    }

    public void setRightTitleTvSelected() {
        this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_gray_lighter));
        this.O00000oO.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, int):void
      com.xiaomi.smarthome.library.common.widget.ViewPager.O000000o(int, boolean):void */
    public void setCurrentPage(int i) {
        this.mViewPager.O000000o(i, true);
    }

    public class O000000o extends gqp {
        private List<fvm> O00000o = new ArrayList();

        public O000000o(ee eeVar) {
            super(eeVar);
            gxx gxx = new gxx();
            gxx.setArguments(ShareDeviceInfoActivity.this.mIntent.getExtras());
            this.O00000o.add(gxx);
            gxw gxw = new gxw();
            gxw.setArguments(ShareDeviceInfoActivity.this.mIntent.getExtras());
            this.O00000o.add(gxw);
        }

        public final Fragment O000000o(int i) {
            if (i < 0 || i >= this.O00000o.size()) {
                return null;
            }
            return this.O00000o.get(i);
        }

        public final int O000000o() {
            return this.O00000o.size();
        }
    }

    public void onBackPressed() {
        this.mViewPager.setSwipeEnabled(true);
        fvm fvm = (fvm) this.mAdapter.O000000o(this.mViewPager.getCurrentItem());
        if (fvm == null || !fvm.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
