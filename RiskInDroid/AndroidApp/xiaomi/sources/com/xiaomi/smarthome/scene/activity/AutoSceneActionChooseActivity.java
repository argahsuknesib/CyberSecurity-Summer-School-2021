package com.xiaomi.smarthome.scene.activity;

import _m_j.gsy;
import _m_j.hnw;
import _m_j.hny;
import _m_j.hod;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.scene.api.SceneApi;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.List;

public class AutoSceneActionChooseActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    RecyclerView.LayoutManager f10639O000000o;
    private String O00000Oo = null;
    private LayoutInflater O00000o;
    private int O00000o0 = -1;
    public O000000o mAdapter;
    public List<SceneApi.O000OOOo> mCustomScenes = new ArrayList();
    public hny mListener = new hny() {
        /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionChooseActivity.AnonymousClass1 */

        public final void onRefreshScenceSuccess(int i) {
            if (i == 5) {
                hod.O0000OoO().O00000o0(this);
                AutoSceneActionChooseActivity.this.mPullRefreshLL.refreshComplete();
                AutoSceneActionChooseActivity.this.mCustomScenes = hod.O0000OoO().O00000o0;
                AutoSceneActionChooseActivity autoSceneActionChooseActivity = AutoSceneActionChooseActivity.this;
                autoSceneActionChooseActivity.isShowEmptyView(autoSceneActionChooseActivity.mCustomScenes == null || AutoSceneActionChooseActivity.this.mCustomScenes.size() == 0);
                AutoSceneActionChooseActivity.this.mAdapter.notifyDataSetChanged();
            }
        }

        public final void onRefreshScenceFailed(int i) {
            hod.O0000OoO().O00000o0(this);
            AutoSceneActionChooseActivity.this.mPullRefreshLL.refreshComplete();
            AutoSceneActionChooseActivity.this.mCustomScenes = hod.O0000OoO().O00000o0;
            AutoSceneActionChooseActivity.this.mAdapter.notifyDataSetChanged();
        }
    };
    @BindView(5902)
    View mNoSceneView;
    @BindView(6025)
    PtrFrameLayout mPullRefreshLL;
    @BindView(6149)
    RecyclerView mRecyclerView;
    @BindView(5822)
    ImageView mReturnBtn;
    public int mSelectPos = -1;
    @BindView(5826)
    TextView mTitle;

    public class ViewHolder_ViewBinding implements Unbinder {

        /* renamed from: O000000o  reason: collision with root package name */
        private ViewHolder f10646O000000o;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.f10646O000000o = viewHolder;
            viewHolder.actionLL = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.action_ll, "field 'actionLL'", LinearLayout.class);
            viewHolder.mIconCondition = (SimpleDraweeView) Utils.findRequiredViewAsType(view, R.id.icon_condition, "field 'mIconCondition'", SimpleDraweeView.class);
            viewHolder.mIconConditionMore = (ImageView) Utils.findRequiredViewAsType(view, R.id.icon_condition_more, "field 'mIconConditionMore'", ImageView.class);
            viewHolder.tvSceneName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_scene_name, "field 'tvSceneName'", TextView.class);
            viewHolder.mRightView = (ImageView) Utils.findRequiredViewAsType(view, R.id.right_view, "field 'mRightView'", ImageView.class);
            viewHolder.mSceneNewMoreIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.scene_new_more_icon, "field 'mSceneNewMoreIcon'", ImageView.class);
        }

        public void unbind() {
            ViewHolder viewHolder = this.f10646O000000o;
            if (viewHolder != null) {
                this.f10646O000000o = null;
                viewHolder.actionLL = null;
                viewHolder.mIconCondition = null;
                viewHolder.mIconConditionMore = null;
                viewHolder.tvSceneName = null;
                viewHolder.mRightView = null;
                viewHolder.mSceneNewMoreIcon = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.auto_scene_choose_action_activity_layout);
        ButterKnife.bind(this);
        this.O00000o = LayoutInflater.from(this);
        this.O00000o0 = getIntent().getIntExtra("extra_enable", -1);
        this.O00000Oo = getIntent().getStringExtra("select_scene_id");
        this.mTitle.setText((int) R.string.control_scene_action);
        this.mReturnBtn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionChooseActivity.AnonymousClass2 */

            public final void onClick(View view) {
                AutoSceneActionChooseActivity.this.setResult(0);
                AutoSceneActionChooseActivity.this.finish();
            }
        });
        this.mAdapter = new O000000o();
        this.f10639O000000o = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(this.f10639O000000o);
        this.mRecyclerView.setAdapter(this.mAdapter);
        this.mPullRefreshLL.setPtrHandler(new PtrHandler() {
            /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionChooseActivity.AnonymousClass3 */

            public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                if (Build.VERSION.SDK_INT < 14) {
                    if (view instanceof AbsListView) {
                        AbsListView absListView = (AbsListView) view;
                        return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
                    } else if (!(view instanceof RecyclerView)) {
                        return view.getScrollY() > 0;
                    } else {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) AutoSceneActionChooseActivity.this.f10639O000000o;
                        return linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() - 1 < 0;
                    }
                } else if (!(view instanceof RecyclerView)) {
                    return view.canScrollVertically(-1);
                } else {
                    LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) AutoSceneActionChooseActivity.this.f10639O000000o;
                    if (linearLayoutManager2 == null) {
                        return false;
                    }
                    gsy.O00000Oo("ptrf", linearLayoutManager2.findFirstCompletelyVisibleItemPosition() + "____" + linearLayoutManager2.findFirstVisibleItemPosition());
                    return linearLayoutManager2.findFirstCompletelyVisibleItemPosition() - 1 < 0 && linearLayoutManager2.findFirstVisibleItemPosition() - 1 < 0;
                }
            }

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                hod.O0000OoO().O000000o(AutoSceneActionChooseActivity.this.mListener);
                hod.O0000OoO().O00000o0();
            }
        });
        if (!hod.O0000OoO().O00000oo) {
            this.mPullRefreshLL.autoRefresh();
        } else {
            this.mCustomScenes.addAll(hod.O0000OoO().f416O000000o);
            List<SceneApi.O000OOOo> list = this.mCustomScenes;
            isShowEmptyView(list == null || list.size() == 0);
            this.mAdapter.notifyDataSetChanged();
        }
        this.mPullRefreshLL.autoRefresh();
        if (!TextUtils.isEmpty(this.O00000Oo)) {
            this.mSelectPos = getSelectPos(this.O00000Oo);
            if (this.mSelectPos != -1) {
                Intent intent = new Intent(this, AutoSceneActionDetailChooseActivity.class);
                intent.putExtra("extra_enable", this.O00000o0);
                intent.putExtra("extra_id", this.O00000Oo);
                startActivityForResult(intent, 101);
            }
        }
    }

    public void isShowEmptyView(boolean z) {
        if (z) {
            this.mPullRefreshLL.setVisibility(8);
            this.mRecyclerView.setVisibility(8);
            this.mNoSceneView.setVisibility(0);
            return;
        }
        this.mPullRefreshLL.setVisibility(0);
        this.mRecyclerView.setVisibility(0);
        this.mNoSceneView.setVisibility(8);
    }

    public int getSelectPos(String str) {
        List<SceneApi.O000OOOo> list = hod.O0000OoO().f416O000000o;
        for (int i = 0; i < list.size(); i++) {
            if (TextUtils.equals(list.get(i).f11131O000000o, str)) {
                return i;
            }
        }
        return -1;
    }

    public void onResume() {
        super.onResume();
    }

    class O000000o extends RecyclerView.O000000o {
        public final long getItemId(int i) {
            return 0;
        }

        O000000o() {
        }

        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(AutoSceneActionChooseActivity.this).inflate((int) R.layout.auto_scene_choose_action_item, (ViewGroup) null));
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ViewHolder viewHolder = (ViewHolder) o000OOo0;
            final SceneApi.O000OOOo o000OOOo = AutoSceneActionChooseActivity.this.mCustomScenes.get(i);
            viewHolder.tvSceneName.setText(o000OOOo.O00000Oo);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.scene.activity.AutoSceneActionChooseActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(AutoSceneActionChooseActivity.this, AutoSceneActionDetailChooseActivity.class);
                    intent.putExtra("extra_id", o000OOOo.f11131O000000o);
                    AutoSceneActionChooseActivity.this.startActivityForResult(intent, 101);
                    AutoSceneActionChooseActivity.this.mSelectPos = AutoSceneActionChooseActivity.this.getSelectPos(o000OOOo.f11131O000000o);
                }
            });
            viewHolder.tvSceneName.setTextColor(AutoSceneActionChooseActivity.this.getResources().getColor(R.color.mj_color_black_80_transparent));
            if (o000OOOo.O0000O0o.size() > 0) {
                viewHolder.mIconCondition.setVisibility(0);
                viewHolder.mIconCondition.setHierarchy(new GenericDraweeHierarchyBuilder(viewHolder.mIconCondition.getResources()).setFadeDuration(200).setPlaceholderImage(viewHolder.mIconCondition.getResources().getDrawable(R.drawable.device_list_phone_no)).setActualImageScaleType(ScalingUtils.ScaleType.FIT_START).setPlaceholderImageScaleType(ScalingUtils.ScaleType.FIT_START).build());
                hnw.O000000o(viewHolder.mIconCondition, o000OOOo.O0000O0o.get(0));
                if (o000OOOo.O0000O0o.size() > 1) {
                    viewHolder.mIconConditionMore.setVisibility(0);
                } else {
                    viewHolder.mIconConditionMore.setVisibility(8);
                }
                viewHolder.mIconConditionMore.setImageResource(hnw.O00000o0(o000OOOo.O0000Ooo));
            } else {
                viewHolder.mIconCondition.setVisibility(8);
                viewHolder.mIconConditionMore.setVisibility(8);
            }
            hnw.O000000o(o000OOOo, viewHolder.actionLL);
            viewHolder.mSceneNewMoreIcon.setVisibility(8);
        }

        public final int getItemCount() {
            if (AutoSceneActionChooseActivity.this.mCustomScenes == null) {
                return 0;
            }
            return AutoSceneActionChooseActivity.this.mCustomScenes.size();
        }
    }

    class ViewHolder extends RecyclerView.O000OOo0 {
        @BindView(5051)
        LinearLayout actionLL;
        @BindView(5588)
        SimpleDraweeView mIconCondition;
        @BindView(5589)
        ImageView mIconConditionMore;
        @BindView(6098)
        ImageView mRightView;
        @BindView(6152)
        ImageView mSceneNewMoreIcon;
        @BindView(6485)
        TextView tvSceneName;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 101) {
            int intExtra = intent.getIntExtra("extra_enable", -1);
            Intent intent2 = new Intent();
            intent2.putExtra("extra_index", this.mSelectPos);
            intent2.putExtra("extra_enable", intExtra);
            setResult(-1, intent2);
            finish();
        }
    }
}
