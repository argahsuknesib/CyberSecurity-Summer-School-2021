package com.xiaomi.mico.setting.stereo;

import _m_j.ee;
import _m_j.ei;
import _m_j.fvm;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MicoLanGroup;
import com.xiaomi.mico.api.model.PairedGroupInfo;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.stereo.StereoMainActivity;
import com.xiaomi.smarthome.R;

public class StereoMainActivity extends MicoBaseActivity {
    private Fragment currentFragment;
    private ee fragmentManager;
    FrameLayout frameLayout;
    public StereoGroupListFragment groupListFragment;
    public boolean haveStereo;
    public StereoSettingFragment settingFragment;
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_stereo_main);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$NnmM7yye6VOlyGkFuNBPRaKXz0 */

            public final void onLeftIconClick() {
                StereoMainActivity.this.backPressed();
            }
        });
        this.titleBar.setOnRightIconClickListener(new TitleBar.OnRightIconClickListener() {
            /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoMainActivity$fGHqwXVw5sqrJbbqglo8bHhFiyE */

            public final void onRightIconClick() {
                StereoMainActivity.this.lambda$onCreate$0$StereoMainActivity();
            }
        });
        this.titleBar.showRightIcon(false);
        this.groupListFragment = new StereoGroupListFragment();
        this.settingFragment = new StereoSettingFragment();
        this.fragmentManager = getSupportFragmentManager();
        ei O000000o2 = this.fragmentManager.O000000o();
        O000000o2.O000000o((int) R.id.frame_layout, this.groupListFragment);
        O000000o2.O000000o((int) R.id.frame_layout, this.settingFragment);
        O000000o2.O00000Oo(this.groupListFragment);
        O000000o2.O00000Oo(this.settingFragment);
        O000000o2.O00000o0();
    }

    public /* synthetic */ void lambda$onCreate$0$StereoMainActivity() {
        toFragment(this.settingFragment, this.groupListFragment);
    }

    public void onResume() {
        super.onResume();
        loadStereoGroup(true, "");
    }

    public void toFragment(fvm fvm, fvm fvm2) {
        this.currentFragment = fvm;
        ei O000000o2 = this.fragmentManager.O000000o();
        O000000o2.O00000Oo(fvm2);
        O000000o2.O00000o0(fvm);
        O000000o2.O00000o0();
        if (fvm instanceof StereoGroupListFragment) {
            this.titleBar.showRightIcon(true);
        } else {
            this.titleBar.showRightIcon(false);
        }
    }

    private void loadStereoGroup(boolean z, String str) {
        if (z) {
            showProgressDialog(null);
        }
        ApiHelper.getMicoLanGroup("", "", str, new ApiRequest.Listener<MicoLanGroup>() {
            /* class com.xiaomi.mico.setting.stereo.StereoMainActivity.AnonymousClass1 */

            public void onSuccess(MicoLanGroup micoLanGroup) {
                StereoMainActivity.this.frameLayout.post(new Runnable(micoLanGroup) {
                    /* class com.xiaomi.mico.setting.stereo.$$Lambda$StereoMainActivity$1$0_KhOxaqrQgZtxGDzaUZaiFF4 */
                    private final /* synthetic */ MicoLanGroup f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        StereoMainActivity.AnonymousClass1.this.lambda$onSuccess$0$StereoMainActivity$1(this.f$1);
                    }
                });
            }

            public /* synthetic */ void lambda$onSuccess$0$StereoMainActivity$1(MicoLanGroup micoLanGroup) {
                StereoMainActivity.this.dismissProgressDialog();
                PairedGroupInfo pairedGroupInfo = micoLanGroup.pairedGroupInfo;
                if (pairedGroupInfo == null || pairedGroupInfo.stereoList == null || pairedGroupInfo.stereoList.isEmpty()) {
                    StereoMainActivity stereoMainActivity = StereoMainActivity.this;
                    stereoMainActivity.haveStereo = false;
                    stereoMainActivity.toFragment(stereoMainActivity.settingFragment, StereoMainActivity.this.groupListFragment);
                    return;
                }
                StereoMainActivity stereoMainActivity2 = StereoMainActivity.this;
                stereoMainActivity2.haveStereo = true;
                stereoMainActivity2.groupListFragment.setData(micoLanGroup);
                StereoMainActivity stereoMainActivity3 = StereoMainActivity.this;
                stereoMainActivity3.toFragment(stereoMainActivity3.groupListFragment, StereoMainActivity.this.settingFragment);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = "StereoSettingActivity loadStereoGroup : %s " + apiError.toString();
                StereoMainActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.bind_device_error_write_wifi_resp_timeout);
                StereoMainActivity.this.finish();
            }
        }).bindToLifecycle(this);
    }

    public void onBackPressed() {
        backPressed();
    }

    public void backPressed() {
        if ((this.currentFragment instanceof StereoGroupListFragment) || !this.haveStereo) {
            super.onBackPressed();
        } else {
            toFragment(this.groupListFragment, this.settingFragment);
        }
    }
}
