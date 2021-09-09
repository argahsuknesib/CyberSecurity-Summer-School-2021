package com.xiaomi.smarthome.scene.activity;

import _m_j.gsy;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hpq;
import _m_j.hpr;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.List;

public class LiteAutomationChooseScene extends BaseActivity {
    RecyclerView.LayoutManager O00000o;
    O000000o O00000o0;
    protected List<SceneApi.O000OOOo> O00000oO;
    protected hny O00000oo = new hny() {
        /* class com.xiaomi.smarthome.scene.activity.LiteAutomationChooseScene.AnonymousClass1 */

        public final void onRefreshScenceSuccess(int i) {
            if (LiteAutomationChooseScene.this.isValid()) {
                LiteAutomationChooseScene.this.mPullRefreshLL.refreshComplete();
                hpr.O00000o0().O00000o0(this);
                if (i == 4) {
                    LiteAutomationChooseScene.this.O00000oO = hpr.O00000o0().O0000OOo;
                    LiteAutomationChooseScene.this.O00000o0.notifyDataSetChanged();
                } else if (i == 5) {
                    LiteAutomationChooseScene.this.O00000oO = hpr.O00000o0().O0000O0o;
                    LiteAutomationChooseScene.this.O00000o0.notifyDataSetChanged();
                }
                LiteAutomationChooseScene.this.removeMyself();
                LiteAutomationChooseScene liteAutomationChooseScene = LiteAutomationChooseScene.this;
                liteAutomationChooseScene.showEmptyView(liteAutomationChooseScene.O00000oO == null || LiteAutomationChooseScene.this.O00000oO.size() == 0);
            }
        }

        public final void onRefreshScenceFailed(int i) {
            if (LiteAutomationChooseScene.this.isValid()) {
                LiteAutomationChooseScene.this.mPullRefreshLL.refreshComplete();
                hpr.O00000o0().O00000o0(this);
                LiteAutomationChooseScene.this.O00000o0.notifyDataSetChanged();
            }
        }
    };
    @BindView(5902)
    View mNoSceneView;
    @BindView(6025)
    protected PtrFrameLayout mPullRefreshLL;
    @BindView(6149)
    RecyclerView mRecyclerView;
    @BindView(5822)
    ImageView mReturnBtn;
    public String mSelectLiteSceneId;
    @BindView(5826)
    TextView mTitle;

    public class ItemViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ItemViewHolder f10738O000000o;

        public ItemViewHolder_ViewBinding(ItemViewHolder itemViewHolder, View view) {
            this.f10738O000000o = itemViewHolder;
            itemViewHolder.image = (ImageView) Utils.findRequiredViewAsType(view, R.id.image, "field 'image'", ImageView.class);
            itemViewHolder.name = (TextView) Utils.findRequiredViewAsType(view, R.id.name, "field 'name'", TextView.class);
            itemViewHolder.status = (TextView) Utils.findRequiredViewAsType(view, R.id.name_status, "field 'status'", TextView.class);
            itemViewHolder.rightBtn = Utils.findRequiredView(view, R.id.right_btn_container, "field 'rightBtn'");
            itemViewHolder.mDelItem = Utils.findRequiredView(view, R.id.del_action_item, "field 'mDelItem'");
        }

        public void unbind() {
            ItemViewHolder itemViewHolder = this.f10738O000000o;
            if (itemViewHolder != null) {
                this.f10738O000000o = null;
                itemViewHolder.image = null;
                itemViewHolder.name = null;
                itemViewHolder.status = null;
                itemViewHolder.rightBtn = null;
                itemViewHolder.mDelItem = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    static class ItemViewHolder extends RecyclerView.O000OOo0 {
        @BindView(5609)
        public ImageView image;
        @BindView(5316)
        public View mDelItem;
        @BindView(5883)
        public TextView name;
        @BindView(6089)
        public View rightBtn;
        @BindView(5887)
        public TextView status;

        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            this.rightBtn.setVisibility(8);
            this.mDelItem.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.automation_shoose_scene);
        ButterKnife.bind(this);
        this.O00000o = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(this.O00000o);
        this.mTitle.setText((int) R.string.exectute_one_scene);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.LiteAutomationChooseScene.AnonymousClass2 */

            public final void onClick(View view) {
                LiteAutomationChooseScene.this.cancelChoose();
            }
        });
        boolean z = false;
        this.O00000o0 = new O000000o(this, (byte) 0);
        this.mRecyclerView.setAdapter(this.O00000o0);
        this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
            /* class com.xiaomi.smarthome.scene.activity.LiteAutomationChooseScene.AnonymousClass3 */

            public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                if (Build.VERSION.SDK_INT < 14) {
                    if (view instanceof AbsListView) {
                        AbsListView absListView = (AbsListView) view;
                        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                    } else if (!(view instanceof RecyclerView)) {
                        return view.getScrollY() > 0;
                    } else {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) LiteAutomationChooseScene.this.O00000o;
                        return linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                    }
                } else if (!(view instanceof RecyclerView)) {
                    return view.canScrollVertically(-1);
                } else {
                    LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) LiteAutomationChooseScene.this.O00000o;
                    if (linearLayoutManager2 == null) {
                        return false;
                    }
                    gsy.O00000Oo("ptrf", linearLayoutManager2.findFirstCompletelyVisibleItemPosition() + "____" + linearLayoutManager2.findFirstVisibleItemPosition());
                    return linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 < 0 && linearLayoutManager2.findFirstVisibleItemPosition() - 1 < 0;
                }
            }

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                hpr.O00000o0().O000000o(LiteAutomationChooseScene.this.O00000oo);
            }
        });
        this.mNoSceneView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$LiteAutomationChooseScene$4t3qhaNOndiv8mckOsSdB63E9oM */

            public final void onClick(View view) {
                LiteAutomationChooseScene.this.O000000o(view);
            }
        });
        this.mSelectLiteSceneId = getIntent().getStringExtra("select_us_id");
        this.O00000oO = new ArrayList();
        if (!hpr.O00000o0().O00000oO) {
            this.mPullRefreshLL.autoRefresh();
        } else if (hpr.O00000o0().O0000O0o.size() > 0) {
            this.O00000oO.addAll(hpr.O00000o0().O0000O0o);
        } else {
            this.mRecyclerView.setVisibility(8);
            this.mNoSceneView.setVisibility(0);
        }
        removeMyself();
        List<SceneApi.O000OOOo> list = this.O00000oO;
        if (list == null || list.size() == 0) {
            z = true;
        }
        showEmptyView(z);
    }

    public void onDestroy() {
        super.onDestroy();
        hpr.O00000o0().O00000o0(this.O00000oo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hpr.O00000o0().O000000o(this.O00000oo);
    }

    public void removeMyself() {
        SceneApi.O000OOOo o000OOOo = hpq.O000000o().O00000Oo;
        if (o000OOOo != null) {
            for (int i = 0; i < this.O00000oO.size(); i++) {
                if (TextUtils.equals(this.O00000oO.get(i).f11131O000000o, o000OOOo.f11131O000000o)) {
                    this.O00000oO.remove(i);
                    return;
                }
            }
        }
    }

    class O000000o extends RecyclerView.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(LiteAutomationChooseScene liteAutomationChooseScene, byte b) {
            this();
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ItemViewHolder(LayoutInflater.from(LiteAutomationChooseScene.this).inflate((int) R.layout.lite_auto_choose_scene_item, (ViewGroup) null));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, final int i) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) o000OOo0;
            SceneApi.O000OOOo o000OOOo = LiteAutomationChooseScene.this.O00000oO.get(i);
            itemViewHolder.image.setImageResource(hnw.O000000o(o000OOOo.O00000o));
            if (TextUtils.equals(LiteAutomationChooseScene.this.mSelectLiteSceneId, o000OOOo.f11131O000000o)) {
                itemViewHolder.name.setSelected(true);
            } else {
                itemViewHolder.name.setSelected(false);
            }
            itemViewHolder.name.setText(o000OOOo.O00000Oo);
            itemViewHolder.status.setVisibility(8);
            itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.LiteAutomationChooseScene.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    LiteAutomationChooseScene.this.chooseOne(i);
                }
            });
        }

        public final int getItemCount() {
            return LiteAutomationChooseScene.this.O00000oO.size();
        }
    }

    public void showEmptyView(boolean z) {
        if (z) {
            this.mRecyclerView.setVisibility(8);
            this.mPullRefreshLL.setVisibility(8);
            this.mNoSceneView.setVisibility(0);
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.mPullRefreshLL.setVisibility(0);
        this.mNoSceneView.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void chooseOne(int i) {
        Intent intent = new Intent();
        intent.putExtra("extra_index", i);
        setResult(-1, intent);
        finish();
        hpq.O000000o().O00000o0();
    }

    /* access modifiers changed from: protected */
    public void cancelChoose() {
        setResult(0);
        finish();
    }
}
