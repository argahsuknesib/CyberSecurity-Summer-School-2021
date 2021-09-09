package com.xiaomi.smarthome.miio.page;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.gty;
import _m_j.hte;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.miniprogram.MyMiniProgramActivity;

public class SharePolymerizationActivity extends BaseActivity {
    @BindView(5122)
    FrameLayout crShareDevice;
    @BindView(5123)
    FrameLayout crShareHome;
    @BindView(5124)
    FrameLayout crShareWx;
    @BindView(5535)
    ImageView moduleA3ReturnBtn;
    @BindView(5539)
    TextView moduleA3ReturnTitle;
    @BindView(5544)
    ImageView moduleA3RightIvSettingBtn;
    @BindView(5770)
    RelativeLayout rlShareWx;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_share_polymerization);
        ButterKnife.bind(this);
        this.moduleA3ReturnTitle.setText((int) R.string.share_title);
        this.moduleA3RightIvSettingBtn.setVisibility(8);
        this.rlShareWx.setVisibility(8);
        this.crShareHome.setVisibility(0);
    }

    public void onResume() {
        super.onResume();
        hxi.O00000o0.f957O000000o.O000000o("my_share_show", new Object[0]);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
     arg types: [java.lang.String, int]
     candidates:
      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
    @OnClick({5535, 5123, 5122, 5124})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            onBackPressed();
        } else if (id == R.id.cr_share_home) {
            hxi.O00000o.f952O000000o.O000000o("my_share_home", new Object[0]);
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                fbs.O000000o(new fbt(this, "MultiHomeManagerActivity").O000000o("from", 2));
            } else {
                gty.O000000o().showLoginDialog(this, false);
            }
        } else if (id == R.id.cr_share_device) {
            hxi.O00000o.f952O000000o.O000000o("my_share_device", new Object[0]);
            if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                fbs.O000000o(new fbt(this, "/share/ShareDeviceinfoActivity").O000000o("user_id", CoreApi.O000000o().O0000o0()).O000000o("param_key_ref_from_app", true));
            } else {
                gty.O000000o().showLoginDialog(this, false);
            }
        } else if (id == R.id.cr_share_wx) {
            hxi.O00000o.f952O000000o.O000000o("my_share_wxapp", new Object[0]);
            if (!ServiceApplication.getSHIWXAPI().isWXAppInstalled()) {
                hte.O000000o(getContext(), getString(R.string.mj_wx_not_installed));
            } else if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
                Intent intent = new Intent(this, MyMiniProgramActivity.class);
                intent.putExtra("nick_name", "");
                startActivity(intent);
            } else {
                gty.O000000o().showLoginDialog(this, false);
            }
        }
    }
}
