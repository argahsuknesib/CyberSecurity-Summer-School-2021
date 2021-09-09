package com.xiaomi.mico.tool.embedded.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.base.MicoBaseActivity;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.mico.common.widget.TitleDescAndSwitcher;
import com.xiaomi.smarthome.R;
import java.util.List;

public class PrivacyAuthActivity extends MicoBaseActivity {
    private PrivacyInfoAdapter adapter;
    RecyclerView listView;
    public String skillID;
    private String skillName;
    TitleDescAndSwitcher switcher;
    TitleBar titleBar;

    public static Intent shareIntent(Context context, String str, String str2) {
        Intent intent = new Intent(context, PrivacyAuthActivity.class);
        intent.putExtra("SKILL_ID", str);
        intent.putExtra("SKILL_NAME", str2);
        return intent;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_privacy_auth);
        this.listView = (RecyclerView) findViewById(R.id.listview);
        this.titleBar = (TitleBar) findViewById(R.id.title_bar);
        this.switcher = (TitleDescAndSwitcher) findViewById(R.id.state_switch);
        if (getIntent() != null) {
            this.skillID = getIntent().getStringExtra("SKILL_ID");
            this.skillName = getIntent().getStringExtra("SKILL_NAME");
        }
        if (TextUtils.isEmpty(this.skillID) || TextUtils.isEmpty(this.skillName)) {
            finish();
        }
        this.adapter = new PrivacyInfoAdapter(this);
        this.listView.setAdapter(this.adapter);
        this.listView.setLayoutManager(new LinearLayoutManager(this));
        this.titleBar.setOnLeftIconClickListener(new TitleBar.OnLeftIconClickListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.PrivacyAuthActivity.AnonymousClass1 */

            public void onLeftIconClick() {
                PrivacyAuthActivity.this.onBackPressed();
            }
        });
        this.switcher.getSlidingButton().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /* class com.xiaomi.mico.tool.embedded.activity.PrivacyAuthActivity.AnonymousClass2 */

            public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
                ApiHelper.setSkillPrivacy(PrivacyAuthActivity.this.skillID, z, new ApiRequest.Listener<Boolean>() {
                    /* class com.xiaomi.mico.tool.embedded.activity.PrivacyAuthActivity.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(Boolean bool) {
                    }

                    public void onFailure(ApiError apiError) {
                        ToastUtil.showToast((int) R.string.common_failed);
                        PrivacyAuthActivity.this.switcher.getSlidingButton().setChecked(!z, false);
                    }
                });
            }
        });
        this.switcher.setTitle(String.format(getString(R.string.skill_privacy_auth_title), this.skillName));
        getPrivacyDetail();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void getPrivacyDetail() {
        ApiHelper.skillPrivacyDetail(this.skillID, new ApiRequest.Listener<SkillStore.Privacy>() {
            /* class com.xiaomi.mico.tool.embedded.activity.PrivacyAuthActivity.AnonymousClass3 */

            public void onSuccess(SkillStore.Privacy privacy) {
                PrivacyAuthActivity.this.refreshUI(privacy);
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError.getMessage();
            }
        });
    }

    public void refreshUI(SkillStore.Privacy privacy) {
        if (privacy != null) {
            this.switcher.getSlidingButton().setChecked(privacy.privacyEnabled, false);
            this.adapter.setData(privacy.privacyList);
        }
    }

    public class PrivacyInfoAdapter extends RecyclerView.O000000o<PrivacyViewHolder> {
        private Context context;
        private List<SkillStore.PrivacyInfo> list;

        public PrivacyInfoAdapter(Context context2) {
            this.context = context2;
        }

        public void setData(List<SkillStore.PrivacyInfo> list2) {
            this.list = list2;
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public PrivacyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new PrivacyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.view_skill_privacy_item, viewGroup, false));
        }

        public void onBindViewHolder(PrivacyViewHolder privacyViewHolder, int i) {
            privacyViewHolder.refresh(this.list.get(i));
        }

        public int getItemCount() {
            List<SkillStore.PrivacyInfo> list2 = this.list;
            if (list2 == null) {
                return 0;
            }
            return list2.size();
        }
    }

    static class PrivacyViewHolder extends RecyclerView.O000OOo0 {
        TextView name;

        public PrivacyViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.tool_item_title);
        }

        public void refresh(SkillStore.PrivacyInfo privacyInfo) {
            this.name.setText(privacyInfo.displayName);
        }
    }
}
