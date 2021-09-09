package com.xiaomi.mico.setting.babyschedule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.ChildrenProfileActivity;
import com.xiaomi.mico.setting.babyschedule.BabySchedulerAdapter;
import com.xiaomi.mico.setting.babyschedule.bean.BabySchedule;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleItem;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleRecommendation;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;

public class BabyScheduleActivity extends MicoBaseActivity {
    public BabySchedulerAdapter babySchedulerAdapter;
    public ArrayList<BabyScheduleItem> data = new ArrayList<>();
    RecyclerView list;
    public int positionOfCourseToEdit;
    View rootView;
    public boolean showRecommendation;
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, BabyScheduleActivity.class));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_baby_schedule);
        this.rootView = findViewById(R.id.rootView);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.list = (RecyclerView) findViewById(R.id.linear_recycle_view);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$n_jUPTi5bRLD_1KMUG6aX9qbWJk */

            public final void onLeftIconClick() {
                BabyScheduleActivity.this.onBackPressed();
            }
        });
        this.list.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.babySchedulerAdapter = new BabySchedulerAdapter();
        this.babySchedulerAdapter.setOnStartBabyScheduleEditActivityListener(new BabySchedulerAdapter.OnStartBabyScheduleEditActivityListener() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleActivity.AnonymousClass1 */

            public void onDialogEditItemClick(int i, BabySchedule babySchedule) {
                BabyScheduleActivity babyScheduleActivity = BabyScheduleActivity.this;
                babyScheduleActivity.positionOfCourseToEdit = i;
                BabyScheduleEditActivity.startForResult(babyScheduleActivity, babySchedule, 100);
            }

            public void onAddMoreClick() {
                BabyScheduleEditActivity.startForResult(BabyScheduleActivity.this, 200);
            }

            public void onRecommendationClick(ScheduleRecommendation scheduleRecommendation) {
                BabyScheduleEditActivity.startForResult(BabyScheduleActivity.this, scheduleRecommendation, 300);
            }
        });
        this.babySchedulerAdapter.setOnCustomScheduleClearListener(new BabySchedulerAdapter.OnCustomScheduleClearListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$GeBn4wFQPvRJllPIJdSWHD2K4Bc */

            public final void onCustomScheduleClear() {
                BabyScheduleActivity.this.loadRecommendations();
            }
        });
        this.babySchedulerAdapter.setOnBabyInfoItemClickListener(new BabySchedulerAdapter.OnBabyInfoItemClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleActivity$he_wo7qWynan0LfsdAslE7xEVv8 */

            public final void onBabyInfoItemClick() {
                BabyScheduleActivity.this.lambda$onCreate$0$BabyScheduleActivity();
            }
        });
        this.list.setAdapter(this.babySchedulerAdapter);
        loadDataFromServer();
    }

    public /* synthetic */ void lambda$onCreate$0$BabyScheduleActivity() {
        ChildrenProfileActivity.startForResult(this);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent != null) {
            if (i == 100) {
                this.babySchedulerAdapter.replaceItem(this.positionOfCourseToEdit, (BabySchedule) intent.getParcelableExtra("INTENT_KEY_COURSE_TO_EDIT"));
            } else if (i == 200) {
                loadDataFromServer();
            } else if (i == 300) {
                loadDataFromServer();
            } else if (i == 400) {
                this.babySchedulerAdapter.updateBabyInfo((ThirdPartyResponse.ChildProfile) intent.getSerializableExtra("INTENT_KEY_BABY_INFO"));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void loadDataFromServer() {
        showProgressDialog(null);
        BabySchedulerApiHelper.loadDeviceCourses(new ApiRequest.Listener<ArrayList<BabySchedule>>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleActivity.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((ArrayList<BabySchedule>) ((ArrayList) obj));
            }

            public void onSuccess(ArrayList<BabySchedule> arrayList) {
                if (ContainerUtil.isEmpty(arrayList)) {
                    BabyScheduleActivity.this.loadRecommendations();
                    return;
                }
                BabyScheduleActivity babyScheduleActivity = BabyScheduleActivity.this;
                babyScheduleActivity.showRecommendation = false;
                babyScheduleActivity.updateBg();
                BabyScheduleActivity.this.dismissProgressDialog();
                BabyScheduleActivity.this.data = new ArrayList<>(arrayList);
                BabyScheduleActivity.this.babySchedulerAdapter.updateData(BabyScheduleActivity.this.data, BabyScheduleActivity.this.showRecommendation);
            }

            public void onFailure(ApiError apiError) {
                BabyScheduleActivity.this.dismissProgressDialog();
                ToastUtil.showToast((int) R.string.failed_of_load_retry);
            }
        });
    }

    public void updateBg() {
        this.rootView.setBackgroundColor(getResources().getColor(R.color.mj_color_white));
        this.titleBar.setBackgroundResource(R.color.mj_color_white);
    }

    public void loadRecommendations() {
        this.showRecommendation = true;
        updateBg();
        dismissProgressDialog();
        this.data = new ArrayList<>(Arrays.asList(ScheduleRecommendation.values()));
        this.babySchedulerAdapter.updateData(this.data, this.showRecommendation);
    }
}
