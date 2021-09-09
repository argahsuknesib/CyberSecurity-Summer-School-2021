package com.xiaomi.mico.tool.embedded.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import com.github.ornolfr.ratingview.RatingView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class SkillRatingActivity extends MicoBaseActivity {
    EditText comment;
    public boolean mIsInitRating;
    public boolean mRatingChanged = false;
    private String mSkillId;
    RatingView ratingView;
    TextView scoreHint;
    TitleBar titleBar;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_skill_rating);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.ratingView = (RatingView) findViewById(R.id.rating_view);
        this.scoreHint = (TextView) findViewById(R.id.score_hint);
        this.comment = (EditText) findViewById(R.id.comment);
        this.mSkillId = getIntent().getStringExtra("skill_id");
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillRatingActivity$If3pbqQo55MigNoQztRqclxmkHM */

            public final void onLeftIconClick() {
                SkillRatingActivity.this.lambda$onCreate$0$SkillRatingActivity();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillRatingActivity$pI4FsGMTTBI2odqFHYRObBTrOPE */

            public final void onRightButtonClick() {
                SkillRatingActivity.this.lambda$onCreate$1$SkillRatingActivity();
            }
        });
        this.ratingView.setOnRatingChangedListener(new RatingView.O000000o() {
            /* class com.xiaomi.mico.tool.embedded.activity.SkillRatingActivity.AnonymousClass1 */

            public void onRatingChange(float f, float f2) {
                if (!SkillRatingActivity.this.mIsInitRating) {
                    SkillRatingActivity.this.scoreHint.setText(SkillRatingActivity.this.getResources().getStringArray(R.array.skill_rating_score)[(int) f2]);
                    SkillRatingActivity.this.scoreHint.setTextColor(SkillRatingActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    SkillRatingActivity.this.mRatingChanged = true;
                }
            }
        });
        ApiHelper.getUserRating(this.mSkillId, new ApiRequest.Listener<Integer>() {
            /* class com.xiaomi.mico.tool.embedded.activity.SkillRatingActivity.AnonymousClass2 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(Integer num) {
                SkillRatingActivity skillRatingActivity = SkillRatingActivity.this;
                skillRatingActivity.mIsInitRating = true;
                skillRatingActivity.ratingView.setRating((float) num.intValue());
                SkillRatingActivity.this.mIsInitRating = false;
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$SkillRatingActivity() {
        finish();
    }

    public /* synthetic */ void lambda$onCreate$1$SkillRatingActivity() {
        if (this.mRatingChanged || !TextUtils.isEmpty(this.comment.getText().toString())) {
            setRatingInfo();
        } else {
            ToastUtil.showToast((int) R.string.skill_rating_no_operation_hint);
        }
    }

    private void setRatingInfo() {
        ApiHelper.setUserRating(this.mSkillId, (int) this.ratingView.getRating(), this.comment.getText().toString(), new ApiRequest.Listener<Boolean>() {
            /* class com.xiaomi.mico.tool.embedded.activity.SkillRatingActivity.AnonymousClass3 */

            public void onSuccess(Boolean bool) {
                ToastUtil.showToast((int) R.string.skill_rating_success);
                SkillRatingActivity.this.finish();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.skill_rating_fail);
            }
        });
    }
}
