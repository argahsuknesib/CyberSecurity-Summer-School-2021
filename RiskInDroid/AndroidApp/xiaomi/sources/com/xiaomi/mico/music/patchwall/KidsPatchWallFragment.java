package com.xiaomi.mico.music.patchwall;

import _m_j.gsy;
import _m_j.hxi;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.banner.TabBannerHelper;
import com.xiaomi.mico.music.patchwall.adapter.KidsPatchWallAdapter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class KidsPatchWallFragment extends BasePatchWallFragment {
    private final long CACHE_EXPIRE_TIME = 3600000;
    private long lastUpdateTime;
    private boolean loadPatchWallFail;
    private int mCurrentPage = 0;
    private LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.KidsPatchWallFragment.AnonymousClass1 */

        public void onLoadMore() {
            KidsPatchWallFragment.this.getPatchWallFlow();
        }
    };
    public KidsPatchWallAdapter mPatchWallAdapter;
    private Subscription mSubscription;
    private long startTime;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.mPatchWallAdapter = new KidsPatchWallAdapter(getContext(), "block_type_music_kids");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        getKidsTopBanner();
        this.mCurrentPage = 0;
        getPatchWallFlow();
    }

    public void getPatchWallFlow() {
        this.mSubscription = ObservableApiHelper.getKidsPatchWallFlow(this.mCurrentPage, 1).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$KidsPatchWallFragment$KQppHfyZVpGVCIgCVYB2dWE3f3w */

            public final void call(Object obj) {
                KidsPatchWallFragment.this.lambda$getPatchWallFlow$0$KidsPatchWallFragment((PatchWall) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$KidsPatchWallFragment$nw79C1kEtnEpqvKtPmP_YtugFvw */

            public final void call(Object obj) {
                KidsPatchWallFragment.this.lambda$getPatchWallFlow$1$KidsPatchWallFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getPatchWallFlow$0$KidsPatchWallFragment(PatchWall patchWall) {
        this.mLoadMoreListener.finishLoading();
        boolean z = false;
        if (patchWall == null || !ContainerUtil.hasData(patchWall.blocks)) {
            this.mLoadMoreListener.setCanLoadMore(false);
        } else {
            this.mLoadMoreListener.setCanLoadMore(true);
            KidsPatchWallAdapter kidsPatchWallAdapter = this.mPatchWallAdapter;
            List<PatchWall.Block> list = patchWall.blocks;
            if (this.mCurrentPage > 0) {
                z = true;
            }
            kidsPatchWallAdapter.updateKidsBlocks(list, z);
            this.mCurrentPage++;
        }
        updatedDate();
    }

    public /* synthetic */ void lambda$getPatchWallFlow$1$KidsPatchWallFragment(Throwable th) {
        gsy.O00000Oo(12000, "12000.2.4", "");
        this.mLoadMoreListener.finishLoading();
        this.loadPatchWallFail = true;
    }

    private void getKidsTopBanner() {
        TabBannerHelper.getInstance().getBanner().observeOn(io.reactivex.schedulers.Schedulers.io()).subscribeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribe(new Observer<Map<Integer, Banner>>() {
            /* class com.xiaomi.mico.music.patchwall.KidsPatchWallFragment.AnonymousClass2 */

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }

            public void onSubscribe(Disposable disposable) {
            }

            public /* bridge */ /* synthetic */ void onNext(Object obj) {
                onNext((Map<Integer, Banner>) ((Map) obj));
            }

            public void onNext(Map<Integer, Banner> map) {
                KidsPatchWallFragment.this.mPatchWallAdapter.updateKidsBanner(map.get(4));
            }
        });
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
            this.mCurrentPage = 0;
            this.loadPatchWallFail = true;
        }
        if (this.mCurrentPage == 0 && this.loadPatchWallFail) {
            getPatchWallFlow();
        }
        this.startTime = System.currentTimeMillis();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_children_time", "s", Integer.valueOf(currentTimeMillis));
    }

    private boolean isNeedUpdateData() {
        return (((System.currentTimeMillis() - this.lastUpdateTime) > 3600000 ? 1 : ((System.currentTimeMillis() - this.lastUpdateTime) == 3600000 ? 0 : -1)) > 0) & ((this.lastUpdateTime > 0 ? 1 : (this.lastUpdateTime == 0 ? 0 : -1)) > 0);
    }

    private void updatedDate() {
        this.lastUpdateTime = System.currentTimeMillis();
    }
}
