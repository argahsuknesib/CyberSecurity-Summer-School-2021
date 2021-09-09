package com.xiaomi.smarthome.auth.bindaccount;

import _m_j.fal;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import java.util.ArrayList;
import java.util.List;

public class ThirdGroupAccountsListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private ListView f4317O000000o;
    private O000000o O00000Oo;
    private View O00000o0;
    public DevicePtrFrameLayout mPullRefresh;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_third_group_accounts_list);
        this.O00000o0 = findViewById(R.id.empty_all_page);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.third_account_bind);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdGroupAccountsListActivity$opk46h3utRG42HSSuZAYhqorJ8Q */

            public final void onClick(View view) {
                ThirdGroupAccountsListActivity.this.O000000o(view);
            }
        });
        this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.mPullRefresh.disableWhenHorizontalMove(true);
        this.mPullRefresh.setPullToRefresh(false);
        this.mPullRefresh.setPtrIndicator(new PtrIndicator());
        this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdGroupAccountsListActivity.AnonymousClass1 */

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                ThirdGroupAccountsListActivity.this.startRefresh();
            }
        });
        this.f4317O000000o = (ListView) findViewById(R.id.recycler_view);
        this.O00000Oo = new O000000o(this, (byte) 0);
        this.f4317O000000o.setAdapter((ListAdapter) this.O00000Oo);
        updateView();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        onBackPressed();
    }

    public void startRefresh() {
        fal.getInstance().O00000Oo(new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdGroupAccountsListActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                if (ThirdGroupAccountsListActivity.this.isValid()) {
                    gqg.O00000Oo((int) R.string.loading_failed);
                    ThirdGroupAccountsListActivity.this.mPullRefresh.refreshComplete();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (ThirdGroupAccountsListActivity.this.isValid()) {
                    ThirdGroupAccountsListActivity.this.updateView();
                    ThirdGroupAccountsListActivity.this.mPullRefresh.refreshComplete();
                }
            }
        });
    }

    public void updateView() {
        List<ThirdAccount> list = fal.getInstance().O00000Oo;
        if (list == null || list.isEmpty()) {
            this.O00000o0.setVisibility(0);
            this.f4317O000000o.setVisibility(8);
            return;
        }
        this.O00000o0.setVisibility(8);
        this.f4317O000000o.setVisibility(0);
        O000000o o000000o = this.O00000Oo;
        o000000o.f4320O000000o.clear();
        if (list != null) {
            o000000o.f4320O000000o.addAll(list);
        }
        o000000o.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        this.mPullRefresh.autoRefresh();
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<ThirdAccount> f4320O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O000000o() {
            this.f4320O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(ThirdGroupAccountsListActivity thirdGroupAccountsListActivity, byte b) {
            this();
        }

        public final Object getItem(int i) {
            return this.f4320O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ThirdGroupAccountsListActivity.this.getContext()).inflate((int) R.layout.third_account_item_layout, viewGroup, false);
            }
            final ThirdAccount thirdAccount = this.f4320O000000o.get(i);
            ((TextView) view.findViewById(R.id.title)).setText(thirdAccount.f4322O000000o);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.bindaccount.ThirdGroupAccountsListActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    if (thirdAccount.O00000oo != 0) {
                        Intent intent = new Intent(ThirdGroupAccountsListActivity.this.getContext(), ThirdAccountDetailActivity.class);
                        intent.putExtra("account_id", thirdAccount.O00000Oo);
                        ThirdGroupAccountsListActivity.this.startActivity(intent);
                        hxi.O00000o.O000000o(thirdAccount.f4322O000000o);
                    }
                }
            });
            View findViewById = view.findViewById(R.id.next_btn);
            findViewById.setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.id.state_tv);
            view.findViewById(R.id.next_btn).setVisibility(0);
            view.findViewById(R.id.state_tv).setVisibility(8);
            fal.O000000o((SimpleDraweeView) view.findViewById(R.id.icon), thirdAccount.O00000o0);
            if (thirdAccount.O00000oo == 0) {
                textView.setText((int) R.string.third_account_state_binded);
                textView.setBackgroundResource(0);
                textView.setVisibility(0);
                findViewById.setVisibility(8);
            }
            return view;
        }

        public final int getCount() {
            return this.f4320O000000o.size();
        }
    }
}
