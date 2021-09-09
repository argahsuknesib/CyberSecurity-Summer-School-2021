package com.xiaomi.mico.music.patchwall;

import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ObservableApiHelper;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.banner.TabBannerHelper;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.adapter.PatchWallAdapter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RadioPatchWallFragment extends BasePatchWallFragment {
    private boolean loadPatchWallFail;
    private int mCurrentPage = 0;
    private List<Music.HomeButton> mHomeButtons;
    private LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.RadioPatchWallFragment.AnonymousClass1 */

        public void onLoadMore() {
            RadioPatchWallFragment.this.getPatchWallFlow();
        }
    };
    public PatchWallAdapter mPatchWallAdapter;
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
        this.mCurrentPage = 0;
        this.mPatchWallAdapter = new PatchWallAdapter(getContext(), "block_type_audio_boox");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        loadDidiInfo();
        getRadioTopBanner();
        getPatchWallFlow();
        if (!jgc.O000000o().O00000Oo(this)) {
            jgc.O000000o().O000000o(this);
        }
    }

    private void loadDidiInfo() {
        if (ApiConstants.isAreaCodeInTaiWan()) {
        }
    }

    public void getPatchWallFlow() {
        this.mSubscription = ObservableApiHelper.getPatchWallFlow(this.mCurrentPage, 1).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$RadioPatchWallFragment$byLl70ru33a_IBAaNbqQCO8se7I */

            public final void call(Object obj) {
                RadioPatchWallFragment.this.lambda$getPatchWallFlow$0$RadioPatchWallFragment((PatchWall) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$RadioPatchWallFragment$PzV7aygnInKGwARP63AOGdXBV_o */

            public final void call(Object obj) {
                RadioPatchWallFragment.this.lambda$getPatchWallFlow$1$RadioPatchWallFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getPatchWallFlow$0$RadioPatchWallFragment(PatchWall patchWall) {
        this.mLoadMoreListener.finishLoading();
        boolean z = false;
        if (patchWall == null) {
            this.mLoadMoreListener.setCanLoadMore(false);
        } else if (ContainerUtil.hasData(patchWall.blocks)) {
            this.mLoadMoreListener.setCanLoadMore(true);
            PatchWallAdapter patchWallAdapter = this.mPatchWallAdapter;
            List<PatchWall.Block> list = patchWall.blocks;
            if (this.mCurrentPage > 0) {
                z = true;
            }
            patchWallAdapter.updateBlocks(list, z);
            this.mCurrentPage++;
        } else if (this.mCurrentPage == 0) {
            PatchWallAdapter patchWallAdapter2 = this.mPatchWallAdapter;
            List<PatchWall.Block> list2 = patchWall.blocks;
            if (this.mCurrentPage > 0) {
                z = true;
            }
            patchWallAdapter2.updateBlocks(list2, z);
            this.loadPatchWallFail = true;
        }
    }

    public /* synthetic */ void lambda$getPatchWallFlow$1$RadioPatchWallFragment(Throwable th) {
        gsy.O00000Oo(12000, "12000.2.6", "");
        this.mLoadMoreListener.finishLoading();
        this.loadPatchWallFail = true;
    }

    private void getRadioTopBanner() {
        if (!ApiConstants.isAreaCodeInTaiWan()) {
            TabBannerHelper.getInstance().getBanner().observeOn(io.reactivex.schedulers.Schedulers.io()).subscribeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribe(new Observer<Map<Integer, Banner>>() {
                /* class com.xiaomi.mico.music.patchwall.RadioPatchWallFragment.AnonymousClass2 */

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
                    RadioPatchWallFragment.this.mPatchWallAdapter.addMihomeBanner(map.get(5));
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
        jgc.O000000o().O00000o0(this);
    }

    public void onActivate() {
        super.onActivate();
        this.mPatchWallAdapter.onActivate();
        if (this.mCurrentPage == 0 && this.loadPatchWallFail) {
            getPatchWallFlow();
            loadDidiInfo();
        }
        this.startTime = System.currentTimeMillis();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_sound_time", "s", Integer.valueOf(currentTimeMillis));
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onKKBoxAccountBindStatusChanged(MusicEvent.CPAccountBindStatusChanged cPAccountBindStatusChanged) {
        if (cPAccountBindStatusChanged.unbind && ApiConstants.isAreaCodeInTaiWan()) {
            this.mCurrentPage = 0;
            getPatchWallFlow();
        }
    }
}
