package com.xiaomi.mico.setting.babyschedule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.DisplayUtils;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.setting.babyschedule.BabySchedulerApiHelper;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleCategory;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleCategoryAge;
import com.xiaomi.mico.setting.babyschedule.bean.BabyScheduleCategoryContent;
import com.xiaomi.mico.setting.babyschedule.bean.CategoryInterface;
import com.xiaomi.mico.setting.babyschedule.bean.ScheduleItem;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BabyScheduleAddActivity extends MicoBaseActivity {
    private AddBabyScheduleAdapter addBabyScheduleAdapter;
    private List<BabyScheduleCategoryAge> categoryAges;
    public long currentAgeId;
    public long currentContentId;
    public boolean finishAccessLoadChildAgeInterface;
    HorizontalScrollView hsAge;
    RadioGroup rgCategoryAge;
    RadioGroup rgCategoryContent;
    RecyclerView rlSchedule;
    private ArrayList<ScheduleItem> schedulerItemsFromEditPage = new ArrayList<>();
    TitleBar titleBar;

    public boolean isDarkMode() {
        return true;
    }

    public static void startForResult(Activity activity, ArrayList arrayList) {
        Intent intent = new Intent(activity, BabyScheduleAddActivity.class);
        intent.putExtra("INTENT_KEY_ADD_SCHEDULE", arrayList);
        activity.startActivityForResult(intent, 400);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_baby_schedule);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.rgCategoryAge = (RadioGroup) findViewById(R.id.rgCategoryAge);
        this.rgCategoryContent = (RadioGroup) findViewById(R.id.rgCategoryContent);
        this.rlSchedule = (RecyclerView) findViewById(R.id.rlSchedule);
        this.hsAge = (HorizontalScrollView) findViewById(R.id.hsAge);
        this.titleBar.setTitleBold();
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$8WtHfkN9knq0f_1Rv1e_hqzbf_M */

            public final void onLeftIconClick() {
                BabyScheduleAddActivity.this.onBackPressed();
            }
        });
        this.addBabyScheduleAdapter = new AddBabyScheduleAdapter();
        ArrayList<ScheduleItem> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("INTENT_KEY_ADD_SCHEDULE");
        if (parcelableArrayListExtra == null) {
            parcelableArrayListExtra = new ArrayList<>();
        }
        this.schedulerItemsFromEditPage = parcelableArrayListExtra;
        this.rlSchedule.setAdapter(this.addBabyScheduleAdapter);
        loadSchedulerCategories();
        this.rgCategoryAge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleAddActivity$DznCGRtBDVDudXLJXsbBd0GNIU */

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BabyScheduleAddActivity.this.lambda$onCreate$0$BabyScheduleAddActivity(radioGroup, i);
            }
        });
        this.rgCategoryContent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.setting.babyschedule.$$Lambda$BabyScheduleAddActivity$HmQPbpK80PE8tMhvxtA7_KAZrCk */

            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                BabyScheduleAddActivity.this.lambda$onCreate$1$BabyScheduleAddActivity(radioGroup, i);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$BabyScheduleAddActivity(RadioGroup radioGroup, int i) {
        if (this.finishAccessLoadChildAgeInterface) {
            long longValue = ((Long) this.rgCategoryAge.findViewById(i).getTag()).longValue();
            if (this.currentAgeId != longValue) {
                this.currentAgeId = longValue;
                loadSchedule(this.currentAgeId, this.currentContentId);
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$1$BabyScheduleAddActivity(RadioGroup radioGroup, int i) {
        if (this.finishAccessLoadChildAgeInterface) {
            long longValue = ((Long) this.rgCategoryContent.findViewById(i).getTag()).longValue();
            if (this.currentContentId != longValue) {
                this.currentContentId = longValue;
                loadSchedule(this.currentAgeId, this.currentContentId);
            }
        }
    }

    public void onBackPressed() {
        setIntentResult();
        super.onBackPressed();
    }

    private void setIntentResult() {
        Intent intent = new Intent();
        intent.putExtra("INTENT_KEY_ADD_SCHEDULE", this.schedulerItemsFromEditPage);
        setResult(-1, intent);
    }

    private void loadSchedulerCategories() {
        showProgressDialog(null);
        BabySchedulerApiHelper.loadSchedulerCategories(new ApiRequest.Listener<BabyScheduleCategory>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleAddActivity.AnonymousClass1 */

            public void onSuccess(BabyScheduleCategory babyScheduleCategory) {
                BabyScheduleAddActivity.this.handleLoadResult(babyScheduleCategory);
            }

            public void onFailure(ApiError apiError) {
                BabyScheduleAddActivity.this.showLoadFailedUI();
            }
        });
    }

    public void showLoadFailedUI() {
        dismissProgressDialog();
        ToastUtil.showToast((int) R.string.failed_of_load_retry);
    }

    public void handleLoadResult(BabyScheduleCategory babyScheduleCategory) {
        this.categoryAges = babyScheduleCategory.age;
        List<BabyScheduleCategoryContent> list = babyScheduleCategory.content;
        if (ContainerUtil.isEmpty(this.categoryAges) || ContainerUtil.isEmpty(list)) {
            showLoadFailedUI();
            return;
        }
        list.add(0, new BabyScheduleCategoryContent(0, getString(R.string.music_my_collection)));
        adaptListData(this.rgCategoryAge, this.categoryAges, R.layout.layout_radio_button_add_baby_schedule_category_age);
        adaptListData(this.rgCategoryContent, list, R.layout.layout_radio_button_add_baby_schedule_category_content);
        this.currentAgeId = this.categoryAges.get(0).getId();
        this.currentContentId = list.get(1).getId();
        loadChildAge();
    }

    private void loadChildAge() {
        ApiHelper.getChildrenProfile(new ApiRequest.Listener<List<ThirdPartyResponse.ChildProfile>>() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleAddActivity.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ThirdPartyResponse.ChildProfile>) ((List) obj));
            }

            public void onSuccess(List<ThirdPartyResponse.ChildProfile> list) {
                BabyScheduleAddActivity.this.handChildAgeLoadResult(list);
                BabyScheduleAddActivity babyScheduleAddActivity = BabyScheduleAddActivity.this;
                babyScheduleAddActivity.loadSchedule(babyScheduleAddActivity.currentAgeId, BabyScheduleAddActivity.this.currentContentId);
                BabyScheduleAddActivity.this.finishAccessLoadChildAgeInterface = true;
            }

            public void onFailure(ApiError apiError) {
                BabyScheduleAddActivity babyScheduleAddActivity = BabyScheduleAddActivity.this;
                babyScheduleAddActivity.loadSchedule(babyScheduleAddActivity.currentAgeId, BabyScheduleAddActivity.this.currentContentId);
                BabyScheduleAddActivity.this.finishAccessLoadChildAgeInterface = true;
            }
        });
    }

    public void handChildAgeLoadResult(List<ThirdPartyResponse.ChildProfile> list) {
        if (!ContainerUtil.isEmpty(list) && !ContainerUtil.isEmpty(this.categoryAges)) {
            int age = list.get(0).getAge();
            int i = 1;
            while (i < this.categoryAges.size()) {
                BabyScheduleCategoryAge babyScheduleCategoryAge = this.categoryAges.get(i);
                String[] split = babyScheduleCategoryAge.name.split("-");
                if (split.length < 2) {
                    updateCurrentAgeId(i, babyScheduleCategoryAge);
                    return;
                }
                int intNum = getIntNum(split[0]);
                int intNum2 = getIntNum(split[1]);
                if (age < intNum || age >= intNum2) {
                    i++;
                } else {
                    updateCurrentAgeId(i, babyScheduleCategoryAge);
                    return;
                }
            }
        }
    }

    private void updateCurrentAgeId(int i, BabyScheduleCategoryAge babyScheduleCategoryAge) {
        this.currentAgeId = babyScheduleCategoryAge.getId();
        View childAt = this.rgCategoryAge.getChildAt(i);
        this.rgCategoryAge.check(childAt.getId());
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (iArr[0] > DisplayUtils.getScreenWidthPixels(this)) {
            this.hsAge.scrollBy(i * 60, 0);
        }
    }

    private int getIntNum(String str) {
        return Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim());
    }

    public void loadSchedule(long j, long j2) {
        BabySchedulerApiHelper.loadScheduler(j, j2, new BabySchedulerApiHelper.BabyScheduleCollectionCallback() {
            /* class com.xiaomi.mico.setting.babyschedule.BabyScheduleAddActivity.AnonymousClass3 */

            public void onSuccess(List<ScheduleItem> list) {
                BabyScheduleAddActivity.this.dismissProgressDialog();
                BabyScheduleAddActivity.this.handleLoadSchedule((ArrayList) list);
            }

            public void onFailed(ApiError apiError) {
                BabyScheduleAddActivity.this.showLoadFailedUI();
            }
        });
    }

    public void handleLoadSchedule(ArrayList<ScheduleItem> arrayList) {
        this.addBabyScheduleAdapter.updateData(arrayList, this.schedulerItemsFromEditPage);
    }

    private void adaptListData(RadioGroup radioGroup, List<? extends CategoryInterface> list, int i) {
        if (!ContainerUtil.isEmpty(list)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                CategoryInterface categoryInterface = (CategoryInterface) list.get(i2);
                RadioButton radioButton = (RadioButton) LayoutInflater.from(this).inflate(i, (ViewGroup) null);
                radioButton.setText(categoryInterface.getName());
                radioButton.setTag(Long.valueOf(categoryInterface.getId()));
                radioGroup.addView(radioButton);
                RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) radioButton.getLayoutParams();
                if (i2 == 0) {
                    layoutParams.leftMargin = (int) getResources().getDimension(R.dimen.size_16dp);
                }
                boolean z = categoryInterface instanceof BabyScheduleCategoryContent;
                if (z) {
                    layoutParams.rightMargin = (int) getResources().getDimension(R.dimen.size_20dp);
                } else if (categoryInterface instanceof BabyScheduleCategoryAge) {
                    layoutParams.height = -1;
                }
                if (i2 == 0 && (categoryInterface instanceof BabyScheduleCategoryAge)) {
                    radioButton.setChecked(true);
                } else if (i2 == 1 && z) {
                    radioButton.setChecked(true);
                }
                radioButton.setLayoutParams(layoutParams);
            }
            radioGroup.invalidate();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }
}
