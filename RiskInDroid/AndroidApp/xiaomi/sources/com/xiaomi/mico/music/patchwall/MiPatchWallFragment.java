package com.xiaomi.mico.music.patchwall;

import _m_j.ahh;
import _m_j.gsy;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.banner.TabBannerHelper;
import com.xiaomi.mico.music.patchwall.adapter.PatchWallAdapter;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import rx.Subscription;
import rx.functions.Action1;

public class MiPatchWallFragment extends BasePatchWallFragment {
    private boolean loadPatchWallFail;
    private int mCurrentPage = 0;
    private LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.MiPatchWallFragment.AnonymousClass1 */

        public void onLoadMore() {
            MiPatchWallFragment.this.getPatchWallFlow();
        }
    };
    public PatchWallAdapter mPatchWallAdapter;
    private Subscription mSubscription;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.mPatchWallAdapter = new PatchWallAdapter(getActivity(), "");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        getMiPatChWallTopBanner();
        this.mCurrentPage = 0;
        getPatchWallFlow();
    }

    public void getPatchWallFlow() {
        this.mSubscription = ObservableApiHelper.getMiPatchWallFlow(this.mCurrentPage, 1).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$MiPatchWallFragment$DGLcE111gxPL4VZZudF7mETR6H8 */

            public final void call(Object obj) {
                MiPatchWallFragment.this.lambda$getPatchWallFlow$0$MiPatchWallFragment((PatchWall) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$MiPatchWallFragment$DNZXBEamwaAh54M0EYPHylGoZxg */

            public final void call(Object obj) {
                MiPatchWallFragment.this.lambda$getPatchWallFlow$1$MiPatchWallFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getPatchWallFlow$0$MiPatchWallFragment(PatchWall patchWall) {
        this.mLoadMoreListener.finishLoading();
        boolean z = false;
        if (patchWall == null || !ContainerUtil.hasData(patchWall.blocks)) {
            this.mLoadMoreListener.setCanLoadMore(false);
            return;
        }
        this.mLoadMoreListener.setCanLoadMore(true);
        PatchWallAdapter patchWallAdapter = this.mPatchWallAdapter;
        List<PatchWall.Block> list = patchWall.blocks;
        if (this.mCurrentPage > 0) {
            z = true;
        }
        patchWallAdapter.updateBlocks(list, z);
        this.mCurrentPage++;
    }

    public /* synthetic */ void lambda$getPatchWallFlow$1$MiPatchWallFragment(Throwable th) {
        gsy.O00000Oo(12000, "12000.2.3", "mimusic");
        ahh.O000000o(th);
        this.mLoadMoreListener.finishLoading();
        this.loadPatchWallFail = true;
    }

    private void getMiPatChWallTopBanner() {
        TabBannerHelper.getInstance().getBanner().observeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Map<Integer, Banner>>() {
            /* class com.xiaomi.mico.music.patchwall.MiPatchWallFragment.AnonymousClass2 */

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
                MiPatchWallFragment.this.mPatchWallAdapter.addMihomeBanner(map.get(3));
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
        if (this.mCurrentPage == 0 && this.loadPatchWallFail) {
            getPatchWallFlow();
        }
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
    }
}
