package com.xiaomi.smarthome.scene.activity;

import _m_j.hod;
import _m_j.hpq;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;

public class AutoSceneActionDetailChooseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private String f10648O000000o = null;
    @BindView(5256)
    TextView mCloseTV;
    public int mEnable = -1;
    @BindView(5926)
    TextView mOpenTV;
    @BindView(5822)
    ImageView mReturnBtn;
    @BindView(5826)
    TextView mTitle;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.auto_scene_choose_action_detail_activity_layout);
        ButterKnife.bind(this);
        if (getIntent() != null) {
            this.mEnable = getIntent().getIntExtra("extra_enable", -1);
            this.f10648O000000o = getIntent().getStringExtra("extra_id");
        }
        SceneApi.O000OOOo O00000Oo = hod.O0000OoO().O00000Oo(this.f10648O000000o);
        if (O00000Oo != null && !TextUtils.isEmpty(O00000Oo.O00000Oo)) {
            this.mTitle.setText(O00000Oo.O00000Oo);
        }
        initView();
        this.mCloseTV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionDetailChooseActivity.AnonymousClass1 */

            public final void onClick(View view) {
                AutoSceneActionDetailChooseActivity autoSceneActionDetailChooseActivity = AutoSceneActionDetailChooseActivity.this;
                autoSceneActionDetailChooseActivity.mEnable = 0;
                autoSceneActionDetailChooseActivity.initView();
                Intent intent = new Intent();
                intent.putExtra("extra_enable", AutoSceneActionDetailChooseActivity.this.mEnable);
                AutoSceneActionDetailChooseActivity.this.setResult(-1, intent);
                AutoSceneActionDetailChooseActivity.this.finish();
                hpq.O000000o().O00000o0();
            }
        });
        this.mOpenTV.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionDetailChooseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                Intent intent = new Intent();
                AutoSceneActionDetailChooseActivity autoSceneActionDetailChooseActivity = AutoSceneActionDetailChooseActivity.this;
                autoSceneActionDetailChooseActivity.mEnable = 1;
                autoSceneActionDetailChooseActivity.initView();
                intent.putExtra("extra_enable", AutoSceneActionDetailChooseActivity.this.mEnable);
                AutoSceneActionDetailChooseActivity.this.setResult(-1, intent);
                AutoSceneActionDetailChooseActivity.this.finish();
                hpq.O000000o().O00000o0();
            }
        });
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionDetailChooseActivity.AnonymousClass3 */

            public final void onClick(View view) {
                if (AutoSceneActionDetailChooseActivity.this.mEnable == -1) {
                    AutoSceneActionDetailChooseActivity.this.setResult(0);
                    AutoSceneActionDetailChooseActivity.this.finish();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("extra_enable", AutoSceneActionDetailChooseActivity.this.mEnable);
                AutoSceneActionDetailChooseActivity.this.setResult(-1, intent);
                AutoSceneActionDetailChooseActivity.this.finish();
                hpq.O000000o().O00000o0();
            }
        });
    }

    public void initView() {
        int i = this.mEnable;
        if (i == -1) {
            this.mOpenTV.setSelected(false);
            this.mCloseTV.setSelected(false);
        } else if (i == 1) {
            this.mOpenTV.setSelected(true);
            this.mCloseTV.setSelected(false);
        } else if (i == 0) {
            this.mOpenTV.setSelected(false);
            this.mCloseTV.setSelected(true);
        }
    }

    public void onBackPressed() {
        if (this.mEnable == -1) {
            setResult(0);
            finish();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("extra_enable", this.mEnable);
        setResult(-1, intent);
        finish();
        hpq.O000000o().O00000o0();
    }
}
