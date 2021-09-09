package com.xiaomi.mico.setting;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.ThirdPartyResponse;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.List;

public class ChildrenProfileActivity extends MicoBaseActivity {
    TextView addProfile;
    public List<ThirdPartyResponse.ChildProfile> childProfiles = new ArrayList();
    private ChildrenProfileAdapter childrenProfileAdapter;
    TextView emptyView;
    ListView listview;
    TitleBar titleBar;

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, ChildrenProfileActivity.class));
    }

    public static void startForResult(Activity activity) {
        activity.startActivityForResult(new Intent(activity, ChildrenProfileActivity.class), 400);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_children_profile);
        this.listview = (ListView) findViewById(R.id.listview);
        this.emptyView = (TextView) findViewById(R.id.empty_view);
        this.addProfile = (TextView) findViewById(R.id.add_profile);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        findViewById(R.id.add_profile).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$ChildrenProfileActivity$oRlskeBPAzcT68R5qnrl9l5C7KA */

            public final void onClick(View view) {
                ChildrenProfileActivity.this.lambda$onCreate$0$ChildrenProfileActivity(view);
            }
        });
        this.childrenProfileAdapter = new ChildrenProfileAdapter();
        this.listview.setAdapter((ListAdapter) this.childrenProfileAdapter);
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.setting.$$Lambda$2FXCIeQpsw6QK16_SOqasbTcGzI */

            public final void onLeftIconClick() {
                ChildrenProfileActivity.this.onBackPressed();
            }
        });
        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.xiaomi.mico.setting.ChildrenProfileActivity.AnonymousClass1 */

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ChildrenProfileEditActivity.startActivityForResult(ChildrenProfileActivity.this, ChildrenProfileActivity.this.childProfiles.get(i), i);
            }
        });
        this.listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /* class com.xiaomi.mico.setting.ChildrenProfileActivity.AnonymousClass2 */

            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                ChildrenProfileActivity.this.deleteChildProfile(i);
                return true;
            }
        });
        loadData();
    }

    public /* synthetic */ void lambda$onCreate$0$ChildrenProfileActivity(View view) {
        onViewClicked();
    }

    public void onBackPressed() {
        setIntentResult();
        finish();
    }

    private void setIntentResult() {
        Intent intent = new Intent();
        intent.putExtra("INTENT_KEY_BABY_INFO", this.childrenProfileAdapter.getFirstChildInfo());
        setResult(-1, intent);
    }

    public void deleteChildProfile(final int i) {
        new MLAlertDialog.Builder(getContext()).O000000o((int) R.string.mico_common_hint).O00000Oo((int) R.string.child_profile_delete_title).O00000Oo((int) R.string.common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.common_confirm, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.mico.setting.ChildrenProfileActivity.AnonymousClass3 */

            public void onClick(DialogInterface dialogInterface, int i) {
                ChildrenProfileActivity.this.childProfiles.remove(i);
                ChildrenProfileActivity childrenProfileActivity = ChildrenProfileActivity.this;
                childrenProfileActivity.saveData(childrenProfileActivity.childProfiles, true);
                ChildrenProfileActivity.this.refreshUI();
            }
        }).O00000oo();
    }

    private void loadData() {
        ApiHelper.getChildrenProfile(new ApiRequest.Listener<List<ThirdPartyResponse.ChildProfile>>() {
            /* class com.xiaomi.mico.setting.ChildrenProfileActivity.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ThirdPartyResponse.ChildProfile>) ((List) obj));
            }

            public void onSuccess(List<ThirdPartyResponse.ChildProfile> list) {
                if (list == null) {
                    ChildrenProfileActivity.this.childProfiles = new ArrayList();
                } else {
                    ChildrenProfileActivity.this.childProfiles = list;
                }
                ChildrenProfileActivity.this.refreshUI();
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast((int) R.string.common_load_failed);
                ChildrenProfileActivity.this.finish();
            }
        });
    }

    public void refreshUI() {
        List<ThirdPartyResponse.ChildProfile> list = this.childProfiles;
        if (list == null || list.size() <= 0) {
            this.listview.setVisibility(8);
            this.emptyView.setVisibility(0);
            return;
        }
        this.listview.setVisibility(0);
        this.emptyView.setVisibility(8);
        this.childrenProfileAdapter.notifyDataSetChanged();
    }

    public void saveData(List<ThirdPartyResponse.ChildProfile> list, final boolean z) {
        ApiHelper.setChildrenProfile(list, new ApiRequest.Listener<String>() {
            /* class com.xiaomi.mico.setting.ChildrenProfileActivity.AnonymousClass5 */

            public void onSuccess(String str) {
                ToastUtil.showToast(z ? R.string.common_delete_success : R.string.mico_common_save_success);
            }

            public void onFailure(ApiError apiError) {
                ToastUtil.showToast(z ? R.string.common_delete_fail : R.string.common_save_fail);
            }
        });
    }

    public void onViewClicked() {
        ChildrenProfileEditActivity.startActivityForResult(this, (ThirdPartyResponse.ChildProfile) null, -1);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            ThirdPartyResponse.ChildProfile childProfile = (ThirdPartyResponse.ChildProfile) intent.getSerializableExtra(ChildrenProfileEditActivity.DATA);
            int intExtra = intent.getIntExtra("id", -1);
            if (intExtra >= 0) {
                this.childProfiles.set(intExtra, childProfile);
            } else {
                this.childProfiles.add(childProfile);
            }
            saveData(this.childProfiles, false);
            refreshUI();
        }
    }

    class ChildrenProfileAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        ChildrenProfileAdapter() {
        }

        public int getCount() {
            return ContainerUtil.getSize(ChildrenProfileActivity.this.childProfiles);
        }

        public Object getItem(int i) {
            return ChildrenProfileActivity.this.childProfiles.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ChildrenProfileActivity.this.getContext()).inflate((int) R.layout.child_profile_item, (ViewGroup) null);
                view.setTag(new ProfileViewHolder(view));
            }
            ((ProfileViewHolder) view.getTag()).refresh((ThirdPartyResponse.ChildProfile) getItem(i));
            return view;
        }

        /* access modifiers changed from: package-private */
        public ThirdPartyResponse.ChildProfile getFirstChildInfo() {
            if (ContainerUtil.hasData(ChildrenProfileActivity.this.childProfiles)) {
                return ChildrenProfileActivity.this.childProfiles.get(0);
            }
            return new ThirdPartyResponse.ChildProfile();
        }
    }

    public class ProfileViewHolder {
        TextView birthday;
        ImageView gender;
        TextView name;

        public ProfileViewHolder(View view) {
            this.name = (TextView) view.findViewById(R.id.name);
            this.gender = (ImageView) view.findViewById(R.id.gender);
            this.birthday = (TextView) view.findViewById(R.id.birthday);
        }

        public void refresh(ThirdPartyResponse.ChildProfile childProfile) {
            this.name.setText(childProfile.nickName);
            this.gender.setImageResource(childProfile.isBoy() ? R.drawable.child_profile_gender_male : R.drawable.child_profile_gender_female);
            this.birthday.setText(childProfile.getBirthText());
        }
    }
}
