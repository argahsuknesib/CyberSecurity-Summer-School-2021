package com.xiaomi.mico.music.patchwall;

import _m_j.axp;
import _m_j.axt;
import _m_j.axu;
import _m_j.czx;
import _m_j.dai;
import _m_j.gsy;
import _m_j.hd;
import _m_j.hxi;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.music.patchwall.adapter.IntelligentFlowAdapter;
import com.xiaomi.smarthome.R;
import java.util.List;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class IntelligentPatchWallFragment extends BasePatchWallFragment {
    public static String TAG = "IntelligentPatchWallFragment";
    private final long CACHE_EXPIRE_TIME = 3600000;
    private RecyclerViewExpandableItemManager expMgr;
    public long infoStreamLastChangeTime = 0;
    public String infoStreamLastId = "";
    private long lastUpdateTime;
    private boolean loadPatchWallFail = false;
    TextView mFooter;
    private dai mLoadMoreListener = new dai() {
        /* class com.xiaomi.mico.music.patchwall.IntelligentPatchWallFragment.AnonymousClass1 */

        public void onLoadMore(czx czx) {
            IntelligentPatchWallFragment.this.mFooter.setText((int) R.string.mico_loading);
            IntelligentPatchWallFragment.this.getPatchWallFlow();
        }
    };
    private IntelligentFlowAdapter mPatchWallAdapter;
    private Subscription mSubscription;
    SmartRefreshLayout refreshLayout;
    private long startTime;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.mico_fragment_intelligent_patchwall;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        this.mFooter = (TextView) view.findViewById(R.id.tv_intelligent_footer);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.expMgr = new RecyclerViewExpandableItemManager();
        this.mPatchWallAdapter = new IntelligentFlowAdapter();
        this.mRecyclerView.setAdapter(this.expMgr.O000000o(this.mPatchWallAdapter));
        ((hd) this.mRecyclerView.getItemAnimator()).O0000o00 = false;
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        this.expMgr.O000000o(this.mRecyclerView);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(false);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(this.mLoadMoreListener);
        this.infoStreamLastId = "";
        this.infoStreamLastChangeTime = 0;
        getPatchWallFlow();
    }

    public void getPatchWallFlow() {
        this.mSubscription = Observable.unsafeCreate(new Observable.OnSubscribe<IntelligentModel>() {
            /* class com.xiaomi.mico.music.patchwall.IntelligentPatchWallFragment.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super IntelligentModel>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super IntelligentModel> subscriber) {
                ApiHelper.getIntelligentFlow(IntelligentPatchWallFragment.this.infoStreamLastId, IntelligentPatchWallFragment.this.infoStreamLastChangeTime, new ApiRequest.Listener<IntelligentModel>() {
                    /* class com.xiaomi.mico.music.patchwall.IntelligentPatchWallFragment.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(IntelligentModel intelligentModel) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(intelligentModel);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(ApiError apiError) {
                        gsy.O00000Oo(12000, "12000.2.2", "");
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(apiError.toThrowable());
                        }
                        gsy.O000000o(6, IntelligentPatchWallFragment.TAG, apiError.toString());
                    }
                });
            }
        }).retryWhen(new RxUtil.RetryWithDelay(200, 2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$IntelligentPatchWallFragment$4HAZx9W9F7g1T1uAdxUn40Oc7RA */

            public final void call(Object obj) {
                IntelligentPatchWallFragment.this.lambda$getPatchWallFlow$0$IntelligentPatchWallFragment((IntelligentModel) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$IntelligentPatchWallFragment$ml1iGvJL6C1shSR8_UVhekRkQwQ */

            public final void call(Object obj) {
                IntelligentPatchWallFragment.this.lambda$getPatchWallFlow$1$IntelligentPatchWallFragment((Throwable) obj);
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.axu.O00000Oo(int, boolean):void
     arg types: [int, int]
     candidates:
      _m_j.axu.O00000Oo(int, int):boolean
      _m_j.axe.O00000Oo(int, int):boolean
      _m_j.axu.O00000Oo(int, boolean):void */
    public /* synthetic */ void lambda$getPatchWallFlow$0$IntelligentPatchWallFragment(IntelligentModel intelligentModel) {
        if (intelligentModel == null || intelligentModel.getList() == null) {
            this.mFooter.setText((int) R.string.loadmore_result_nothing);
            this.refreshLayout.O0000O0o(false);
        } else {
            this.refreshLayout.O0000O0o(true);
            List<IntelligentModel.ListBean> list = intelligentModel.getList();
            int size = list.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                IntelligentModel.ListBean listBean = list.get(size);
                if (TextUtils.equals("STRATEGY", listBean.getType()) && listBean.getCards() != null && listBean.getCards().size() > 0) {
                    this.infoStreamLastId = listBean.getCards().get(listBean.getCards().size() - 1).getInfoStreamId();
                    this.infoStreamLastChangeTime = listBean.getCards().get(listBean.getCards().size() - 1).getChangeTime();
                    break;
                }
                size--;
            }
            if (TextUtils.isEmpty(this.infoStreamLastId)) {
                this.infoStreamLastId = "0";
            }
            if (list.size() != 1 || !TextUtils.equals(list.get(0).getType(), "STRATEGY")) {
                if (list.size() <= 0) {
                    this.mFooter.setText((int) R.string.loadmore_result_nothing);
                    this.refreshLayout.O0000O0o(false);
                } else {
                    this.mPatchWallAdapter.setGroups(intelligentModel);
                    this.mPatchWallAdapter.notifyDataSetChanged();
                    this.expMgr.O000000o();
                }
            } else if (TextUtils.equals(this.mPatchWallAdapter.getGroups().get(this.mPatchWallAdapter.getGroupCount() - 1).getType(), "STRATEGY")) {
                int groupCount = this.mPatchWallAdapter.getGroupCount() - 1;
                int childCount = this.mPatchWallAdapter.getChildCount(groupCount);
                int size2 = list.get(0).getCards().size();
                this.mPatchWallAdapter.appendGroupsChild(list.get(0).getCards());
                axu axu = this.expMgr.O00000o0;
                axt axt = axu.O00000Oo;
                long j = axt.f12689O000000o[groupCount];
                int i = (int) (2147483647L & j);
                if (childCount < 0 || childCount > i) {
                    throw new IllegalStateException("Invalid child position insertChildItems(groupPosition = " + groupCount + ", childPositionStart = " + childCount + ", count = " + size2 + ")");
                }
                if ((2147483648L & j) != 0) {
                    axt.O00000oO += size2;
                }
                axt.f12689O000000o[groupCount] = (j & -2147483648L) | ((long) (i + size2));
                axt.O00000oo = Math.min(axt.O00000oo, groupCount);
                int O000000o2 = axu.O00000Oo.O000000o(axp.O000000o(groupCount, childCount));
                if (O000000o2 != -1) {
                    axu.notifyItemRangeInserted(O000000o2, size2);
                }
            } else {
                this.mPatchWallAdapter.appendGroup(list.get(0));
                this.expMgr.O00000o0.O00000Oo(this.mPatchWallAdapter.getGroupCount() - 1, true);
            }
        }
        this.refreshLayout.O00000Oo(500);
        updatedDate();
    }

    public /* synthetic */ void lambda$getPatchWallFlow$1$IntelligentPatchWallFragment(Throwable th) {
        this.loadPatchWallFail = true;
        this.refreshLayout.O0000O0o();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            hxi.O00000o0.f957O000000o.O000000o("content_intelligence_page", new Object[0]);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
    }

    public void onActivate() {
        super.onActivate();
        this.mPatchWallAdapter.onActivate();
        if (isNeedUpdateData()) {
            this.infoStreamLastId = "";
            this.infoStreamLastChangeTime = 0;
            this.loadPatchWallFail = true;
        }
        if (this.loadPatchWallFail) {
            getPatchWallFlow();
        }
        this.startTime = System.currentTimeMillis();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_intelligence_time", "s", Integer.valueOf(currentTimeMillis));
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    private boolean isNeedUpdateData() {
        return (((System.currentTimeMillis() - this.lastUpdateTime) > 3600000 ? 1 : ((System.currentTimeMillis() - this.lastUpdateTime) == 3600000 ? 0 : -1)) > 0) & ((this.lastUpdateTime > 0 ? 1 : (this.lastUpdateTime == 0 ? 0 : -1)) > 0);
    }

    private void updatedDate() {
        this.lastUpdateTime = System.currentTimeMillis();
    }
}
