package com.xiaomi.smarthome.scene.pluginrecommend;

import _m_j.hpt;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import com.xiaomi.smarthome.scene.pluginrecommend.ActionConditionDetailSelectActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActionConditionDetailSelectActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private TextView f11165O000000o;
    private O000000o O00000Oo;
    private String O00000o;
    private RecyclerView O00000o0;
    public boolean showAction = false;
    public boolean showCondition = false;

    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        setContentView((int) R.layout.rec_scene_condition_action_detail_activity);
        this.showCondition = getIntent().getBooleanExtra("need_condition", false);
        this.showAction = getIntent().getBooleanExtra("need_action", false);
        this.O00000o = getIntent().getStringExtra("did");
        if (TextUtils.isEmpty(this.O00000o)) {
            finish();
            return;
        }
        this.f11165O000000o = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.mj_loading).setVisibility(8);
        findViewById(R.id.tv_not_connect_ble).setVisibility(8);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        this.O00000o0 = (RecyclerView) findViewById(R.id.recycler_view);
        this.O00000o0.setLayoutManager(new LinearLayoutManager(this));
        this.O00000Oo = new O000000o();
        this.O00000o0.setAdapter(this.O00000Oo);
        if (this.showCondition) {
            ArrayList arrayList = new ArrayList();
            if (hpt.O000000o().O00000oO == null || hpt.O000000o().O00000oO.size() <= 0) {
                Intent intent = new Intent();
                intent.putExtra("msg", "no data");
                setResult(0, intent);
                finish();
                return;
            }
            for (Map.Entry<String, List<SceneApi.O000000o>> value : hpt.O000000o().O00000oO.entrySet()) {
                List list = (List) value.getValue();
                int i2 = 0;
                while (true) {
                    if (list == null) {
                        i = 0;
                    } else {
                        i = list.size();
                    }
                    if (i2 < i) {
                        if (((SceneApi.O000000o) list.get(i2)).O00000o0 != null && TextUtils.equals(((SceneApi.O000000o) list.get(i2)).O00000o0.f11122O000000o, this.O00000o)) {
                            arrayList.add(list.get(i2));
                        }
                        i2++;
                    }
                }
            }
            this.O00000Oo.f11166O000000o = arrayList;
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    public class O000000o extends RecyclerView.O000000o<O00000Oo> {

        /* renamed from: O000000o  reason: collision with root package name */
        List<SceneApi.O000000o> f11166O000000o = new ArrayList();
        private List<SceneApi.Action> O00000o0 = new ArrayList();

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getItemViewType(int i) {
            return 0;
        }

        public O000000o() {
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O00000Oo o00000Oo = (O00000Oo) o000OOo0;
            boolean z = true;
            if (ActionConditionDetailSelectActivity.this.showCondition && this.f11166O000000o.get(i).O00000o0 != null) {
                o00000Oo.f11167O000000o.setText(this.f11166O000000o.get(i).O00000o0.O00000Oo);
                SceneApi.O000000o o000000o = hpt.O000000o().O0000OOo.O0000O0o.get(0);
                SceneApi.O000000o o000000o2 = this.f11166O000000o.get(i);
                if (o000000o == null || o000000o2 == null || o000000o.f11121O000000o != o000000o2.f11121O000000o || o000000o.O00000o0 == null || o000000o2.O00000o0 == null || !TextUtils.equals(o000000o.O00000o0.f11122O000000o, o000000o2.O00000o0.f11122O000000o) || o000000o.O00000o0.O0000OoO != o000000o2.O00000o0.O0000OoO) {
                    z = false;
                }
                if (z) {
                    o00000Oo.O00000Oo.setVisibility(0);
                    o00000Oo.f11167O000000o.setTextColor(ActionConditionDetailSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                } else {
                    o00000Oo.O00000Oo.setVisibility(8);
                    o00000Oo.f11167O000000o.setTextColor(ActionConditionDetailSelectActivity.this.getResources().getColor(R.color.black));
                }
                o00000Oo.itemView.setOnClickListener(new View.OnClickListener(i) {
                    /* class com.xiaomi.smarthome.scene.pluginrecommend.$$Lambda$ActionConditionDetailSelectActivity$O000000o$gB3hLOZDNbpd21qtEn2VIBZWDo */
                    private final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        ActionConditionDetailSelectActivity.O000000o.this.O000000o(this.f$1, view);
                    }
                });
            } else if (ActionConditionDetailSelectActivity.this.showAction && this.O00000o0.get(i) != null) {
                o00000Oo.f11167O000000o.setText(this.O00000o0.get(i).O00000Oo);
                SceneApi.Action action = hpt.O000000o().O0000OOo.O00000oo.get(0);
                SceneApi.Action action2 = this.O00000o0.get(i);
                if (action == null || action2 == null || action.f11120O000000o != action2.f11120O000000o || action.O00000oo != action2.O00000oo || action.O0000O0o == null || action2.O0000O0o == null || !TextUtils.equals(action.O0000O0o.O00000o, action2.O0000O0o.O00000o)) {
                    z = false;
                }
                if (z) {
                    o00000Oo.O00000Oo.setVisibility(0);
                    o00000Oo.f11167O000000o.setTextColor(ActionConditionDetailSelectActivity.this.getResources().getColor(R.color.mj_color_green_normal));
                    return;
                }
                o00000Oo.O00000Oo.setVisibility(8);
                o00000Oo.f11167O000000o.setTextColor(ActionConditionDetailSelectActivity.this.getResources().getColor(R.color.black));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void O000000o(int i, View view) {
            hpt.O000000o().O0000OOo.O0000O0o.clear();
            hpt.O000000o().O0000OOo.O0000O0o.add(this.f11166O000000o.get(i));
            notifyDataSetChanged();
            ActionConditionDetailSelectActivity.this.setResult(-1);
            ActionConditionDetailSelectActivity.this.finish();
        }

        public final int getItemCount() {
            List<SceneApi.O000000o> list;
            if (ActionConditionDetailSelectActivity.this.showAction) {
                List<SceneApi.Action> list2 = this.O00000o0;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
            } else if (!ActionConditionDetailSelectActivity.this.showCondition || (list = this.f11166O000000o) == null) {
                return 0;
            } else {
                return list.size();
            }
        }

        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ActionConditionDetailSelectActivity actionConditionDetailSelectActivity = ActionConditionDetailSelectActivity.this;
            return new O00000Oo(LayoutInflater.from(actionConditionDetailSelectActivity).inflate((int) R.layout.light_rec_scene_condition_item_detail, (ViewGroup) null));
        }
    }

    public class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        public TextView f11167O000000o;
        public View O00000Oo;

        public O00000Oo(View view) {
            super(view);
            this.f11167O000000o = (TextView) view.findViewById(R.id.device_name);
            this.O00000Oo = view.findViewById(R.id.icon_selected);
        }
    }
}
