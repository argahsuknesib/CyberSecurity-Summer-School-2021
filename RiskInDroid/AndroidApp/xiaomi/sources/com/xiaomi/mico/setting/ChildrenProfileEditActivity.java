package com.xiaomi.mico.setting;

import _m_j.ahh;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import butterknife.ButterKnife;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.common.widget.TitleDesAndMore;
import com.xiaomi.mico.common.widget.dialog.InputViewDialog;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ChildrenProfileEditActivity extends MicoBaseActivity {
    public static String DATA = "data";
    TitleDesAndMore birthday;
    TitleDesAndMore gender;
    private int mDataId = -1;
    TitleDesAndMore name;
    TitleBar titleBar;

    public static void startActivityForResult(Activity activity, ThirdPartyResponse.ChildProfile childProfile, int i) {
        Intent intent = new Intent(activity, ChildrenProfileEditActivity.class);
        intent.putExtra(DATA, childProfile);
        intent.putExtra("id", i);
        activity.startActivityForResult(intent, 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_children_profile_edit);
        ButterKnife.bind(this);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.name = (TitleDesAndMore) findViewById(R.id.name);
        this.gender = (TitleDesAndMore) findViewById(R.id.gender);
        this.birthday = (TitleDesAndMore) findViewById(R.id.birthday);
        findViewById(R.id.name).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileEditActivity$JcNggw8Grp992ICnIMUSMCcOxrQ */

            public final void onClick(View view) {
                ChildrenProfileEditActivity.this.lambda$onCreate$0$ChildrenProfileEditActivity(view);
            }
        });
        findViewById(R.id.gender).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileEditActivity$kq1KeCsghIir_uuyNHDEv9RGd1g */

            public final void onClick(View view) {
                ChildrenProfileEditActivity.this.lambda$onCreate$1$ChildrenProfileEditActivity(view);
            }
        });
        findViewById(R.id.birthday).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileEditActivity$dhYUP4R66nowL2llAUAla3US3AA */

            public final void onClick(View view) {
                ChildrenProfileEditActivity.this.lambda$onCreate$2$ChildrenProfileEditActivity(view);
            }
        });
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileEditActivity$jGTC2CxTfjz7UnshHYPt4x2UpxE */

            public final void onLeftIconClick() {
                ChildrenProfileEditActivity.this.lambda$onCreate$3$ChildrenProfileEditActivity();
            }
        });
        this.titleBar.setOnRightButtonClickListener(new TitleBar.OnRightButtonClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileEditActivity$Fs04yhUgllAndwDnZyGaV1Sbvc */

            public final void onRightButtonClick() {
                ChildrenProfileEditActivity.this.lambda$onCreate$4$ChildrenProfileEditActivity();
            }
        });
        if (getIntent().hasExtra(DATA)) {
            refreshUI((ThirdPartyResponse.ChildProfile) getIntent().getSerializableExtra(DATA));
        }
        this.mDataId = getIntent().getIntExtra("id", -1);
    }

    public /* synthetic */ void lambda$onCreate$3$ChildrenProfileEditActivity() {
        setResult(0);
        finish();
    }

    private void refreshUI(ThirdPartyResponse.ChildProfile childProfile) {
        if (childProfile != null) {
            this.name.setDescription(childProfile.nickName);
            this.gender.setDescription(getString(childProfile.isBoy() ? R.string.common_male : R.string.common_female));
            this.birthday.setDescription(childProfile.getBirthText());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: saveProfile */
    public void lambda$onCreate$4$ChildrenProfileEditActivity() {
        if (TextUtils.isEmpty(this.name.getDescription()) || getString(R.string.setting_not_set).equals(this.name.getDescription())) {
            ToastUtil.showToast((int) R.string.child_profile_edit_error_name);
        } else if (TextUtils.isEmpty(this.birthday.getDescription()) || getString(R.string.setting_not_set).equals(this.birthday.getDescription())) {
            ToastUtil.showToast((int) R.string.child_profile_edit_error_birthday);
        } else {
            ThirdPartyResponse.ChildProfile childProfile = new ThirdPartyResponse.ChildProfile();
            childProfile.nickName = this.name.getDescription();
            childProfile.sex = this.gender.getDescription().equals(getString(R.string.common_male)) ? 1 : 2;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                childProfile.birthday = simpleDateFormat.parse(this.birthday.getDescription()).getTime();
            } catch (Exception e) {
                ahh.O000000o(e);
            }
            Intent intent = new Intent();
            intent.putExtra(DATA, childProfile);
            intent.putExtra("id", this.mDataId);
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: onViewClicked */
    public void lambda$onCreate$2$ChildrenProfileEditActivity(View view) {
        Calendar calendar;
        int id = view.getId();
        if (id == R.id.name) {
            new InputViewDialog(getContext()).setTitle((int) R.string.child_profile_nickname).setInitText(!this.name.getDescription().equals(getString(R.string.setting_not_set)) ? this.name.getDescription() : "").setMaxInputLength(20).setListener(new InputViewDialog.Listener() {
                /* class com.xiaomi.mico.setting.ChildrenProfileEditActivity.AnonymousClass1 */

                public void onFinish(String str) {
                    ChildrenProfileEditActivity.this.name.setDescription(str);
                }
            }).show();
        } else if (id == R.id.gender) {
            final String[] strArr = {getString(R.string.common_male), getString(R.string.common_female)};
            new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.child_profile_gender).O000000o(strArr, this.gender.getDescription().equals(getString(R.string.common_male)) ^ true ? 1 : 0, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.mico.setting.ChildrenProfileEditActivity.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    ChildrenProfileEditActivity.this.gender.setDescription(strArr[i]);
                    dialogInterface.dismiss();
                }
            }).O00000oo();
        } else if (id == R.id.birthday) {
            if (!this.birthday.getDescription().equals(getString(R.string.setting_not_set))) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                try {
                    simpleDateFormat.parse(this.birthday.getDescription());
                    calendar = simpleDateFormat.getCalendar();
                } catch (Exception unused) {
                }
                DatePickerDialog datePickerDialog = new DatePickerDialog(this, 3, new DatePickerDialog.OnDateSetListener() {
                    /* class com.xiaomi.mico.setting.ChildrenProfileEditActivity.AnonymousClass3 */

                    public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                        ChildrenProfileEditActivity.this.birthday.setDescription(String.format("%d-%d-%d", Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)));
                    }
                }, calendar.get(1), calendar.get(2), calendar.get(5));
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
            calendar = Calendar.getInstance();
            DatePickerDialog datePickerDialog2 = new DatePickerDialog(this, 3, new DatePickerDialog.OnDateSetListener() {
                /* class com.xiaomi.mico.setting.ChildrenProfileEditActivity.AnonymousClass3 */

                public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                    ChildrenProfileEditActivity.this.birthday.setDescription(String.format("%d-%d-%d", Integer.valueOf(i), Integer.valueOf(i2 + 1), Integer.valueOf(i3)));
                }
            }, calendar.get(1), calendar.get(2), calendar.get(5));
            datePickerDialog2.getDatePicker().setMaxDate(new Date().getTime());
            datePickerDialog2.show();
        }
    }
}
