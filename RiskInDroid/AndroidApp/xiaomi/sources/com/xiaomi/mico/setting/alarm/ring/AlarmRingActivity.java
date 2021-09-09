package com.xiaomi.mico.setting.alarm.ring;

import _m_j.dka;
import _m_j.jgc;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.Remote;
import com.xiaomi.mico.application.MicoEvent;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.adapter.TabPagerAdapter;
import com.xiaomi.mico.common.application.MicoCapabilityUtil;
import com.xiaomi.mico.common.event.QQAuthUiListener;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Locale;

public class AlarmRingActivity extends MicoBaseActivity {
    private String mLanguage;
    public ViewPager mViewPager;
    private OnTakeVideoResultListener onTakeVideoResultListener;
    private Remote.Response.AlarmRing selectedAlarmRing;
    private boolean showVideoTab = true;
    SmartTabLayout smartTabLayout;
    TitleBar titleBar;

    interface OnTakeVideoResultListener {
        void onActivityResult(int i, int i2, Intent intent);

        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    public boolean isDarkMode() {
        return true;
    }

    public static Intent buildIntent(Context context, Remote.Response.AlarmRing alarmRing) {
        return buildIntent(context, alarmRing, false, true, "zh");
    }

    public static Intent buildIntent(Context context, Remote.Response.AlarmRing alarmRing, boolean z, boolean z2, String str) {
        Intent intent = new Intent(context, AlarmRingActivity.class);
        intent.putExtra("CURRENT_RING", alarmRing);
        intent.putExtra("need_load_ring_config", z);
        intent.putExtra("show_video_tab", z2);
        if (TextUtils.isEmpty(str)) {
            str = "zh";
        }
        intent.putExtra("language", str);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        fixLocalIfNeeded();
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_alarm_ring);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.smartTabLayout = (SmartTabLayout) findViewById(R.id.tablayout);
        this.mViewPager = (ViewPager) findViewById(R.id.viewpager);
        this.titleBar.setTitleBold();
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.alarm.ring.$$Lambda$_snUWxYVsJ_tAWHQABav4VZRptw */

            public final void onLeftIconClick() {
                AlarmRingActivity.this.onBackPressed();
            }
        });
        this.showVideoTab = getIntent().getBooleanExtra("show_video_tab", true);
        Remote.Response.AlarmRing alarmRing = (Remote.Response.AlarmRing) getIntent().getSerializableExtra("CURRENT_RING");
        ArrayList arrayList = new ArrayList();
        arrayList.add(TabPagerAdapter.TabPage.newPage(new MusicRingFragment().setCurrentAlarmRing(alarmRing), getString(R.string.alarm_ring_music)));
        if (this.showVideoTab && MicoCapabilityUtil.hasCapabilityVideoAlarm()) {
            arrayList.add(TabPagerAdapter.TabPage.newPage(new VidoRingFragment().setCurrentAlarmRing(alarmRing), getString(R.string.alarm_ring_video)));
        }
        arrayList.add(TabPagerAdapter.TabPage.newPage(new NatureRingFragment().setCurrentAlarmRing(alarmRing), getString(R.string.alarm_ring_nature)));
        arrayList.add(TabPagerAdapter.TabPage.newPage(new FunRingFragment().setCurrentAlarmRing(alarmRing), getString(R.string.alarm_ring_fun)));
        this.mViewPager.setAdapter(new TabPagerAdapter(getSupportFragmentManager(), arrayList));
        this.mViewPager.setOffscreenPageLimit(2);
        this.smartTabLayout.setViewPager(this.mViewPager);
        this.mViewPager.setCurrentItem(0, false);
        setSelectedTab(alarmRing);
        this.mLanguage = getIntent().getStringExtra("language");
        if (getIntent().getBooleanExtra("need_load_ring_config", false)) {
            AlarmHelper.loadConfig(this.mLanguage);
        }
    }

    private void fixLocalIfNeeded() {
        if (shouldFixLocale() && Build.VERSION.SDK_INT >= 24) {
            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
            if (O00oOooo == null) {
                if (Build.VERSION.SDK_INT >= 24) {
                    O00oOooo = Resources.getSystem().getConfiguration().getLocales().get(0);
                } else {
                    O00oOooo = Locale.getDefault();
                }
            }
            Configuration configuration = new Configuration(getResources().getConfiguration());
            configuration.setLocale(O00oOooo);
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        }
    }

    private void setSelectedTab(Remote.Response.AlarmRing alarmRing) {
        if (alarmRing == null) {
            this.mViewPager.setCurrentItem(0, false);
        } else if ("音乐".equals(alarmRing.tab)) {
            this.mViewPager.setCurrentItem(0, false);
        } else if ("视频".equals(alarmRing.tab)) {
            this.mViewPager.setCurrentItem(1, false);
        } else if ("自然".equals(alarmRing.tab)) {
            if (this.mViewPager.getAdapter().getCount() == 3) {
                this.mViewPager.setCurrentItem(1, false);
            }
            if (this.mViewPager.getAdapter().getCount() == 4) {
                this.mViewPager.setCurrentItem(2, false);
            }
        } else if ("趣味".equals(alarmRing.tab)) {
            if (this.mViewPager.getAdapter().getCount() == 3) {
                this.mViewPager.setCurrentItem(2, false);
            }
            if (this.mViewPager.getAdapter().getCount() == 4) {
                this.mViewPager.setCurrentItem(3, false);
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        OnTakeVideoResultListener onTakeVideoResultListener2 = this.onTakeVideoResultListener;
        if (onTakeVideoResultListener2 != null) {
            onTakeVideoResultListener2.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.onTakeVideoResultListener = null;
    }

    public void onAlarmRingChange(Remote.Response.AlarmRing alarmRing) {
        this.selectedAlarmRing = alarmRing;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 11101) {
            dka.O000000o(i, i2, intent, new QQAuthUiListener());
        }
        if (i == 101 && i2 == -1) {
            Music.Song song = (Music.Song) intent.getSerializableExtra("SONG");
            if (song != null) {
                jgc.O000000o().O00000o(new MicoEvent.AlarmRingChange(AlarmHelper.getSongAlarmRing(song)));
                return;
            }
            return;
        }
        OnTakeVideoResultListener onTakeVideoResultListener2 = this.onTakeVideoResultListener;
        if (onTakeVideoResultListener2 != null) {
            onTakeVideoResultListener2.onActivityResult(i, i2, intent);
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof VidoRingFragment) {
            this.onTakeVideoResultListener = (OnTakeVideoResultListener) fragment;
        }
    }

    public void onBackPressed() {
        setAlarmResult();
        super.onBackPressed();
    }

    private void setAlarmResult() {
        Remote.Response.AlarmRing alarmRing = this.selectedAlarmRing;
        if (alarmRing != null) {
            Object[] objArr = {"selectedAlarmRing=%s", alarmRing.toString()};
            Intent intent = new Intent();
            intent.putExtra("CURRENT_RING", this.selectedAlarmRing);
            setResult(-1, intent);
        }
    }
}
