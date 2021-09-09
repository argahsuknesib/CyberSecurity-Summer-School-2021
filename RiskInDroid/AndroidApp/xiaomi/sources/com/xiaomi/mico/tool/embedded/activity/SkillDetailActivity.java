package com.xiaomi.mico.tool.embedded.activity;

import _m_j.ahh;
import _m_j.ee;
import _m_j.eh;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.application.MicoManager;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.base.MicoBaseFragment;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.common.schema.SchemaManager;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.alarm.AlarmHelper;
import com.xiaomi.mico.tool.embedded.activity.CommonAuthActivity;
import com.xiaomi.smarthome.R;
import java.net.URLDecoder;
import java.util.ArrayList;

public class SkillDetailActivity extends MicoBaseActivity {
    TextView alarmHint;
    TextView alarmMove;
    View expHint;
    private boolean hasPrivacyButton;
    FrameLayout headerLayout;
    TextView hint;
    ImageView icon;
    private String mAuthProvider;
    private SkillStore.SkillDetailV2 mSkillDetail;
    private String mSkillId;
    private ViewPagerAdapter mViewPagerAdapter;
    TextView name;
    private boolean stated;
    TabLayout tablayout;
    TitleBar titleBar;
    ViewPager viewpager;

    interface OnSkillDataLoaded {
        void onSkillDataLoaded(SkillStore.SkillDetailV2 skillDetailV2);
    }

    public TitleBar getTitleBar() {
        return this.titleBar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_common_skill);
        this.headerLayout = (FrameLayout) findViewById(R.id.skill_header_bg);
        this.icon = (ImageView) findViewById(R.id.icon);
        this.name = (TextView) findViewById(R.id.name);
        this.hint = (TextView) findViewById(R.id.hint);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.tablayout = (TabLayout) findViewById(R.id.tablayout);
        this.viewpager = (ViewPager) findViewById(R.id.viewpager);
        this.expHint = findViewById(R.id.exp_hint);
        this.alarmHint = (TextView) findViewById(R.id.alarm_hint);
        this.alarmMove = (TextView) findViewById(R.id.alarm_move);
        this.mSkillId = getIntent().getStringExtra("skill_id");
        this.mAuthProvider = getIntent().getStringExtra("auth_provider");
        if (TextUtils.isEmpty(this.mSkillId)) {
            finish();
            return;
        }
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillDetailActivity$yX9ZifzfZqiuEsEuXEjAVsp0 */

            public final void onLeftIconClick() {
                SkillDetailActivity.this.lambda$onCreate$0$SkillDetailActivity();
            }
        });
        this.tablayout.setupWithViewPager(this.viewpager);
        this.mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        addCustomFragment(this.mViewPagerAdapter);
        if (this.mViewPagerAdapter.getCount() <= 1) {
            this.tablayout.setVisibility(8);
        }
        this.viewpager.setAdapter(this.mViewPagerAdapter);
        if (this.mViewPagerAdapter.getCount() >= 2) {
            this.viewpager.setCurrentItem(1, false);
        }
        if (!AppCapability.hasCapabilityClassifiedAlarm() || !this.mSkillId.equals("cfdfc500-9fcb-400f-91c3-f3629757005e")) {
            this.headerLayout.setBackgroundResource(R.drawable.bg_app_style_hg);
            this.icon.setVisibility(0);
            this.name.setVisibility(0);
            this.hint.setVisibility(0);
            this.alarmHint.setVisibility(8);
            this.alarmMove.setVisibility(8);
            return;
        }
        this.headerLayout.setBackgroundResource(R.drawable.mico_alarm_moved);
        this.icon.setVisibility(8);
        this.name.setVisibility(8);
        this.hint.setVisibility(8);
        this.alarmHint.setVisibility(0);
        this.alarmMove.setVisibility(0);
    }

    public /* synthetic */ void lambda$onCreate$0$SkillDetailActivity() {
        onBackPressed();
    }

    private void initPrivacyButton() {
        TextView rightButton = this.titleBar.getRightButton();
        rightButton.setText((int) R.string.skill_privacy_auth);
        rightButton.setTextColor(-1);
        rightButton.setVisibility(0);
        rightButton.setBackgroundColor(0);
        this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillDetailActivity$A1So8C0iQakS2wEiRlDjYf5ghw */

            public final void onRightButtonClick() {
                SkillDetailActivity.this.lambda$initPrivacyButton$1$SkillDetailActivity();
            }
        });
        this.hasPrivacyButton = true;
    }

    public /* synthetic */ void lambda$initPrivacyButton$1$SkillDetailActivity() {
        SkillStore.SkillDetailV2 skillDetailV2 = this.mSkillDetail;
        if (skillDetailV2 != null) {
            startActivity(PrivacyAuthActivity.shareIntent(this, skillDetailV2.skillId, this.mSkillDetail.displayName));
        }
    }

    public void initTopRightLabel(boolean z) {
        if (!this.hasPrivacyButton && !TextUtils.isEmpty(this.mSkillDetail.topRightLabel) && !TextUtils.isEmpty(this.mSkillDetail.topRightAction)) {
            TextView rightButton = this.titleBar.getRightButton();
            rightButton.setText(this.mSkillDetail.topRightLabel);
            rightButton.setTextColor(-1);
            int i = 0;
            rightButton.setVisibility(0);
            rightButton.setBackgroundColor(0);
            this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillDetailActivity$Pu3z2ZQ7VbvCFJ2kNe4IrBtseCc */

                public final void onRightButtonClick() {
                    SkillDetailActivity.this.lambda$initTopRightLabel$2$SkillDetailActivity();
                }
            });
            if (!z) {
                i = 8;
            }
            rightButton.setVisibility(i);
        }
    }

    public /* synthetic */ void lambda$initTopRightLabel$2$SkillDetailActivity() {
        SkillStore.SkillDetailV2 skillDetailV2 = this.mSkillDetail;
        if (skillDetailV2 != null) {
            SchemaManager.handleSchema(this, Uri.parse(URLDecoder.decode(skillDetailV2.topRightAction)).buildUpon().appendQueryParameter("title", "").appendQueryParameter("fullscreen", "false").build().toString());
        }
    }

    /* access modifiers changed from: protected */
    public void addCustomFragment(ViewPagerAdapter viewPagerAdapter) {
        viewPagerAdapter.addFragment(getString(R.string.skill_intro_title), new IntroFragment());
        if (!TextUtils.isEmpty(this.mAuthProvider)) {
            if (!"357551201933336576".equals(this.mSkillId) || !"369523151148679168".equals(this.mAuthProvider)) {
                CommonAuthActivity.CommonWebOauthFragment commonWebOauthFragment = new CommonAuthActivity.CommonWebOauthFragment();
                this.mViewPagerAdapter.addFragment(getString(R.string.skill_function_title), commonWebOauthFragment);
                commonWebOauthFragment.setAuthProvider(this.mAuthProvider);
            } else {
                CommonAuthActivity.MeituanWebOauthFragment meituanWebOauthFragment = new CommonAuthActivity.MeituanWebOauthFragment();
                this.mViewPagerAdapter.addFragment(getString(R.string.skill_function_title), meituanWebOauthFragment);
                meituanWebOauthFragment.setAuthProvider(this.mAuthProvider);
            }
        }
        if (getIntent().getStringExtra("feature_fragment") != null) {
            try {
                viewPagerAdapter.addFragment(getString(R.string.skill_function_title), (MicoBaseFragment) Class.forName(getIntent().getStringExtra("feature_fragment")).newInstance());
            } catch (Exception e) {
                ahh.O000000o(e);
            }
        }
    }

    public void onResume() {
        super.onResume();
        ApiHelper.skillDetail(MicoManager.getInstance().getCurrentMicoType(), this.mSkillId, new ApiRequest.Listener<SkillStore.SkillDetailV2>() {
            /* class com.xiaomi.mico.tool.embedded.activity.SkillDetailActivity.AnonymousClass1 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(SkillStore.SkillDetailV2 skillDetailV2) {
                SkillDetailActivity.this.refreshUI(skillDetailV2);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void refreshUI(SkillStore.SkillDetailV2 skillDetailV2) {
        this.mSkillDetail = skillDetailV2;
        this.name.setText(this.mSkillDetail.displayName);
        int i = 0;
        this.hint.setText(String.format(getResources().getString(R.string.skill_author_desc), this.mSkillDetail.developerName));
        String largeIcon = this.mSkillDetail.getLargeIcon();
        if (!TextUtils.isEmpty(largeIcon)) {
            Picasso.get().load(largeIcon).into(this.icon);
        }
        for (int i2 = 0; i2 < this.mViewPagerAdapter.getCount(); i2++) {
            Fragment item = this.mViewPagerAdapter.getItem(i2);
            if (item instanceof OnSkillDataLoaded) {
                ((OnSkillDataLoaded) item).onSkillDataLoaded(this.mSkillDetail);
            }
        }
        View view = this.expHint;
        if (!skillDetailV2.isLab()) {
            i = 8;
        }
        view.setVisibility(i);
        if (!(this.mSkillDetail.privacy == null || this.mSkillDetail.privacy.privacyList == null || this.mSkillDetail.privacy.privacyList.size() <= 0)) {
            initPrivacyButton();
        }
        if (!this.stated) {
            this.stated = true;
        }
    }

    public static class IntroFragment extends MicoBaseFragment implements OnSkillDataLoaded {
        RecyclerView descView;
        private SkillDescAdapter mAdapter;

        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            View inflate = layoutInflater.inflate((int) R.layout.fragment_skill_detail_intro, (ViewGroup) null);
            this.descView = (RecyclerView) inflate.findViewById(R.id.desc_view);
            return inflate;
        }

        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.mAdapter = new SkillDescAdapter(getContext());
            this.descView.setAdapter(this.mAdapter);
            this.descView.setLayoutManager(new LinearLayoutManager(getContext()));
        }

        public void refreshUI(Object obj) {
            SkillStore.SkillDetail skillDetail;
            SkillStore.Skill skill;
            if (obj instanceof SkillStore.SkillDetail) {
                skillDetail = (SkillStore.SkillDetail) obj;
                skill = null;
            } else if (obj instanceof SkillStore.Skill) {
                SkillStore.Skill skill2 = (SkillStore.Skill) obj;
                skill = skill2;
                skillDetail = skill2.detail;
            } else {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(skillDetail.sections);
            if (skill != null) {
                arrayList.add(new SkillStore.SkillDetailSectionRating(skill.skillID, skillDetail.userAvgRating, skillDetail.userRatingCount));
            }
            this.mAdapter.refreshData(arrayList);
            this.descView.forceLayout();
            if (skill == null || !"227104325158047771".equals(skill.skillID) || !ApiConstants.isAreaCodeInCN()) {
                this.mAdapter.setSkillID(null);
            } else {
                this.mAdapter.setSkillID(skill.skillID);
            }
        }

        public void refreshUIV2(SkillStore.SkillDetailV2 skillDetailV2) {
            ArrayList arrayList = new ArrayList();
            if (skillDetailV2.instructions != null) {
                SkillStore.SkillDetailSectionTips skillDetailSectionTips = new SkillStore.SkillDetailSectionTips();
                skillDetailSectionTips.name = getString(R.string.skill_detail_intro);
                skillDetailSectionTips.type = "tips";
                if (!AppCapability.hasCapabilityClassifiedAlarm() || !skillDetailV2.skillId.equals("cfdfc500-9fcb-400f-91c3-f3629757005e")) {
                    skillDetailSectionTips.tipsList = skillDetailV2.instructions;
                } else {
                    skillDetailSectionTips.tipsList = AlarmHelper.getAlarmTips(getContext());
                }
                arrayList.add(skillDetailSectionTips);
            }
            if ((skillDetailV2.summary != null && !AppCapability.hasCapabilityClassifiedAlarm()) || !skillDetailV2.skillId.equals("cfdfc500-9fcb-400f-91c3-f3629757005e")) {
                SkillStore.SkillDetailSectionIntro skillDetailSectionIntro = new SkillStore.SkillDetailSectionIntro();
                skillDetailSectionIntro.name = getString(R.string.skill_detail_func_desc);
                skillDetailSectionIntro.type = "intro";
                skillDetailSectionIntro.intro = skillDetailV2.summary;
                arrayList.add(skillDetailSectionIntro);
            }
            if (!AppCapability.hasCapabilityClassifiedAlarm() || !skillDetailV2.skillId.equals("cfdfc500-9fcb-400f-91c3-f3629757005e")) {
                SkillStore.SkillDetailSectionRating skillDetailSectionRating = new SkillStore.SkillDetailSectionRating();
                skillDetailSectionRating.name = getString(R.string.skill_detail_func_desc);
                skillDetailSectionRating.type = "rating";
                skillDetailSectionRating.userAvgRating = skillDetailV2.rating;
                skillDetailSectionRating.userRatingCount = (long) skillDetailV2.ratingCount;
                skillDetailSectionRating.skillId = skillDetailV2.skillId;
                arrayList.add(skillDetailSectionRating);
            }
            if (skillDetailV2 == null || !"227104325158047771".equals(skillDetailV2.skillId) || !ApiConstants.isAreaCodeInCN()) {
                this.mAdapter.setSkillID(null);
            } else {
                this.mAdapter.setSkillID(skillDetailV2.skillId);
            }
            this.mAdapter.refreshData(arrayList);
            this.descView.forceLayout();
        }

        public void onSkillDataLoaded(SkillStore.SkillDetailV2 skillDetailV2) {
            refreshUIV2(skillDetailV2);
        }
    }

    public static class ViewPagerAdapter extends eh {
        ArrayList<Pair<String, Fragment>> mFragments = new ArrayList<>();

        public ViewPagerAdapter(ee eeVar) {
            super(eeVar);
        }

        public Fragment getItem(int i) {
            return (Fragment) this.mFragments.get(i).second;
        }

        public int getCount() {
            return this.mFragments.size();
        }

        public CharSequence getPageTitle(int i) {
            return (CharSequence) this.mFragments.get(i).first;
        }

        public void addFragment(String str, Fragment fragment) {
            this.mFragments.add(new Pair(str, fragment));
        }
    }
}
