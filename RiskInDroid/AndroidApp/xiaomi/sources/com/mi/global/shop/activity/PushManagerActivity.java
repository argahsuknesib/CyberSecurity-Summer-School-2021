package com.mi.global.shop.activity;

import _m_j.byl;
import _m_j.cak;
import _m_j.cal;
import _m_j.cam;
import _m_j.cav;
import _m_j.cbm;
import _m_j.cbx;
import _m_j.ccr;
import _m_j.cdy;
import _m_j.cec;
import _m_j.ced;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.android.volley.Request;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.model.push.PushClassifyModel;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.NewSimpleResult;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.SlidingButton;
import com.mi.multimonitor.CrashReport;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class PushManagerActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private PushManagerAdapter f4663O000000o;
    private ArrayList<PushClassifyModel.PushClassifyItem> O00000Oo = new ArrayList<>();
    private ArrayList<PushClassifyModel.PushClassifyItem> O00000o0 = new ArrayList<>();
    @BindView(2131493921)
    RecyclerView pushRecycleView;

    public static class PushManagerAdapter extends RecyclerView.O000000o<PushManagerViewHolder> {

        /* renamed from: O000000o  reason: collision with root package name */
        public Context f4668O000000o;
        ArrayList<PushClassifyModel.PushClassifyItem> O00000Oo = new ArrayList<>();
        public ArrayList<PushClassifyModel.PushClassifyItem> O00000o0 = new ArrayList<>();

        public class PushManagerViewHolder_ViewBinding implements Unbinder {

            /* renamed from: O000000o  reason: collision with root package name */
            private PushManagerViewHolder f4670O000000o;

            public PushManagerViewHolder_ViewBinding(PushManagerViewHolder pushManagerViewHolder, View view) {
                this.f4670O000000o = pushManagerViewHolder;
                pushManagerViewHolder.itemTitle = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_title, "field 'itemTitle'", CustomTextView.class);
                pushManagerViewHolder.itemDesc = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.item_desc, "field 'itemDesc'", CustomTextView.class);
                pushManagerViewHolder.btnSwitch = (SlidingButton) Utils.findRequiredViewAsType(view, R.id.btn_switch, "field 'btnSwitch'", SlidingButton.class);
            }

            public void unbind() {
                PushManagerViewHolder pushManagerViewHolder = this.f4670O000000o;
                if (pushManagerViewHolder != null) {
                    this.f4670O000000o = null;
                    pushManagerViewHolder.itemTitle = null;
                    pushManagerViewHolder.itemDesc = null;
                    pushManagerViewHolder.btnSwitch = null;
                    return;
                }
                throw new IllegalStateException("Bindings already cleared.");
            }
        }

        public /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            PushManagerViewHolder pushManagerViewHolder = (PushManagerViewHolder) o000OOo0;
            final PushClassifyModel.PushClassifyItem pushClassifyItem = this.O00000Oo.get(i);
            pushManagerViewHolder.itemTitle.setText(pushClassifyItem.title);
            pushManagerViewHolder.itemDesc.setText(pushClassifyItem.desc);
            pushManagerViewHolder.btnSwitch.setChecked(pushClassifyItem.defaultStatus);
            pushManagerViewHolder.btnSwitch.setOnCheckedChangedListener(new SlidingButton.O000000o() {
                /* class com.mi.global.shop.activity.PushManagerActivity.PushManagerAdapter.AnonymousClass1 */

                public final void O000000o(SlidingButton slidingButton, boolean z) {
                    if (z || (!z && pushClassifyItem.enableclose)) {
                        pushClassifyItem.defaultStatus = z;
                        PushClassifyModel.changeKeyChecked(PushManagerAdapter.this.f4668O000000o, pushClassifyItem.key, z);
                        return;
                    }
                    slidingButton.setChecked(!z);
                    cec.O000000o(PushManagerAdapter.this.f4668O000000o, PushManagerAdapter.this.f4668O000000o.getResources().getString(R.string.push_type_cannot_closed), 3000);
                }
            });
        }

        public PushManagerAdapter(Context context) {
            this.f4668O000000o = context;
        }

        public final String O000000o() {
            String str = "";
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                if (i < this.O00000o0.size()) {
                    if (this.O00000o0.get(i).defaultStatus && !this.O00000Oo.get(i).defaultStatus) {
                        str = str + this.O00000Oo.get(i).key + ",";
                    }
                } else if (!this.O00000Oo.get(i).defaultStatus) {
                    str = str + this.O00000Oo.get(i).key + ",";
                }
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            Log.d("watchTypes", " 2".concat(String.valueOf(str)));
            return str;
        }

        public final String O00000Oo() {
            String str = "";
            for (int i = 0; i < this.O00000Oo.size(); i++) {
                if (!this.O00000Oo.get(i).defaultStatus) {
                    str = str + this.O00000Oo.get(i).key + ",";
                }
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            Log.d("watchTypes", " 3 ".concat(String.valueOf(str)));
            return str;
        }

        public int getItemCount() {
            return this.O00000Oo.size();
        }

        static class PushManagerViewHolder extends RecyclerView.O000OOo0 {
            @BindView(2131493039)
            SlidingButton btnSwitch;
            @BindView(2131493511)
            CustomTextView itemDesc;
            @BindView(2131493523)
            CustomTextView itemTitle;

            PushManagerViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new PushManagerViewHolder(LayoutInflater.from(this.f4668O000000o).inflate((int) R.layout.shop_push_manager_item, viewGroup, false));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_push_manager_activity);
        ButterKnife.bind(this);
        setTitle(getString(R.string.account_my_push_manager));
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            /* class com.mi.global.shop.activity.PushManagerActivity.AnonymousClass1 */

            public final void onClick(View view) {
                PushManagerActivity.this.onBackPressed();
            }
        });
        findViewById(R.id.title_bar_cart_view).setVisibility(4);
        initView();
    }

    public void initView() {
        ArrayList<PushClassifyModel.PushClassifyItem> arrayList;
        this.pushRecycleView.setLayoutManager(new LinearLayoutManager(this));
        this.f4663O000000o = new PushManagerAdapter(this);
        this.pushRecycleView.addItemDecoration(new cbx(this, cdy.O000000o(0.5f), getResources().getColor(R.color.divider_color)));
        this.pushRecycleView.setAdapter(this.f4663O000000o);
        Gson gson = new Gson();
        try {
            this.O00000Oo = (ArrayList) gson.fromJson(cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_push_classify_data", ""), new TypeToken<ArrayList<PushClassifyModel.PushClassifyItem>>() {
                /* class com.mi.global.shop.activity.PushManagerActivity.AnonymousClass2 */
            }.getType());
            this.O00000o0 = (ArrayList) gson.fromJson(cbm.O00000o0.O00000Oo(byl.O00000oO(), "pref_key_push_classify_key", ""), new TypeToken<ArrayList<PushClassifyModel.PushClassifyItem>>() {
                /* class com.mi.global.shop.activity.PushManagerActivity.AnonymousClass3 */
            }.getType());
        } catch (Exception e) {
            cec.O000000o(this, getString(R.string.shop_error_network), 3000);
            CrashReport.postCrash(Thread.currentThread(), e);
            finish();
        }
        ArrayList<PushClassifyModel.PushClassifyItem> arrayList2 = this.O00000Oo;
        if (arrayList2 != null && arrayList2.size() > 0 && (arrayList = this.O00000o0) != null && arrayList.size() > 0) {
            Iterator<PushClassifyModel.PushClassifyItem> it = this.O00000Oo.iterator();
            while (it.hasNext()) {
                PushClassifyModel.PushClassifyItem next = it.next();
                Iterator<PushClassifyModel.PushClassifyItem> it2 = this.O00000o0.iterator();
                while (it2.hasNext()) {
                    PushClassifyModel.PushClassifyItem next2 = it2.next();
                    if (next.key.equals(next2.key)) {
                        next.defaultStatus = next2.defaultStatus;
                    }
                }
            }
        }
        PushManagerAdapter pushManagerAdapter = this.f4663O000000o;
        ArrayList<PushClassifyModel.PushClassifyItem> arrayList3 = this.O00000Oo;
        if (arrayList3 != null) {
            pushManagerAdapter.O00000Oo.addAll(arrayList3);
            pushManagerAdapter.notifyDataSetChanged();
        }
        PushManagerAdapter pushManagerAdapter2 = this.f4663O000000o;
        Iterator<PushClassifyModel.PushClassifyItem> it3 = this.O00000Oo.iterator();
        while (it3.hasNext()) {
            PushClassifyModel.PushClassifyItem next3 = it3.next();
            PushClassifyModel.PushClassifyItem pushClassifyItem = new PushClassifyModel.PushClassifyItem();
            pushClassifyItem.key = next3.key;
            pushClassifyItem.defaultStatus = next3.defaultStatus;
            pushManagerAdapter2.O00000o0.add(pushClassifyItem);
        }
    }

    public void onBackPressed() {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O0000oOO()).buildUpon();
        PushManagerAdapter pushManagerAdapter = this.f4663O000000o;
        String str = "";
        for (int i = 0; i < pushManagerAdapter.O00000Oo.size(); i++) {
            if (i < pushManagerAdapter.O00000o0.size()) {
                if (!pushManagerAdapter.O00000o0.get(i).defaultStatus && pushManagerAdapter.O00000Oo.get(i).defaultStatus) {
                    str = str + pushManagerAdapter.O00000Oo.get(i).key + ",";
                }
            } else if (pushManagerAdapter.O00000Oo.get(i).defaultStatus) {
                str = str + pushManagerAdapter.O00000Oo.get(i).key + ",";
            }
        }
        if (str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        Log.d("watchTypes", " 1 ".concat(String.valueOf(str)));
        buildUpon.appendQueryParameter("watchTypes", str);
        buildUpon.appendQueryParameter("unwatchTypes", this.f4663O000000o.O000000o());
        buildUpon.appendQueryParameter("syncUnwatchTypes", this.f4663O000000o.O00000Oo());
        AnonymousClass4 r1 = new cak<NewSimpleResult>() {
            /* class com.mi.global.shop.activity.PushManagerActivity.AnonymousClass4 */

            public final void O000000o(String str) {
                super.O000000o(str);
                ccr.O00000Oo("PushManagerActivity", "PushManagerActivity Exception:".concat(String.valueOf(str)));
            }

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                PushManagerActivity.this.hideLoading();
                PushManagerActivity.this.doSuperBack();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewSimpleResult.class, r1);
        } else {
            request = new cal(buildUpon.toString(), NewSimpleResult.class, r1);
        }
        request.setTag("PushManagerActivity");
        ced.f13683O000000o.add(request);
        showLoading();
    }

    public void doSuperBack() {
        super.onBackPressed();
    }
}
