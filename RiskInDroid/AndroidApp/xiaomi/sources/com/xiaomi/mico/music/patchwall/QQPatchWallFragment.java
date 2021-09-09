package com.xiaomi.mico.music.patchwall;

import _m_j.czx;
import _m_j.dai;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Banner;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.RxUtil;
import com.xiaomi.mico.common.widget.QQMusicAuthPopupView;
import com.xiaomi.mico.music.banner.TabBannerHelper;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.adapter.PatchWallAdapter;
import com.xiaomi.smarthome.R;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class QQPatchWallFragment extends BasePatchWallFragment {
    private final long CACHE_EXPIRE_TIME = 3600000;
    FrameLayout bindView;
    private long lastUpdateTime;
    private boolean loadPatchWallFail;
    public int mCurrentPage = 0;
    public PatchWallAdapter mPatchWallAdapter;
    private Subscription mSubscription;
    ViewGroup notBindView;
    SmartRefreshLayout refreshLayout;
    private long startTime;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.fragment_qq_music;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.notBindView = (ViewGroup) view.findViewById(R.id.not_bind_view);
        this.bindView = (FrameLayout) view.findViewById(R.id.bind_view);
        this.refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        view.findViewById(R.id.qq_bind).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$QQPatchWallFragment$i2oY9xpt8uOeU3tSyXI633p_Q */

            public final void onClick(View view) {
                QQPatchWallFragment.this.lambda$onViewCreated$0$QQPatchWallFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$QQPatchWallFragment(View view) {
        onViewClicked();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.mPatchWallAdapter = new PatchWallAdapter(getContext());
        this.mPatchWallAdapter.setBlockType("block_type_music_qq");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(false);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.patchwall.QQPatchWallFragment.AnonymousClass1 */

            public void onLoadMore(czx czx) {
                QQPatchWallFragment.this.getPatchWallFlow();
            }
        });
        initViewState();
        getQQtopBanner();
        jgc.O000000o().O000000o(this);
    }

    private void initViewState() {
        AccountProfile.current().syncQQBindStatus();
        if (AccountProfile.current().isQQAccountAuthValid()) {
            this.bindView.setVisibility(0);
            this.notBindView.setVisibility(8);
            this.mCurrentPage = 0;
            getPatchWallFlow();
            return;
        }
        this.bindView.setVisibility(8);
        this.notBindView.setVisibility(0);
    }

    public void getPatchWallFlow() {
        Observable.unsafeCreate(new Observable.OnSubscribe<PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.QQPatchWallFragment.AnonymousClass2 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((Subscriber<? super PatchWall>) ((Subscriber) obj));
            }

            public void call(final Subscriber<? super PatchWall> subscriber) {
                ApiHelper.getQQPathWallFlowV2(QQPatchWallFragment.this.mCurrentPage, 1, new ApiRequest.Listener<PatchWall>() {
                    /* class com.xiaomi.mico.music.patchwall.QQPatchWallFragment.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(PatchWall patchWall) {
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(patchWall);
                            subscriber.onCompleted();
                        }
                    }

                    public void onFailure(ApiError apiError) {
                        gsy.O00000Oo(12000, "12000.2.3", "qqmusic");
                        if (!subscriber.isUnsubscribed()) {
                            subscriber.onError(apiError.toThrowable());
                        }
                        new Object[1][0] = apiError;
                    }
                });
            }
        }).retryWhen(new RxUtil.RetryWithDelay(200, 2)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$QQPatchWallFragment$AWwdpblts4kvZCuv46neg1WrmOg */

            public final void call(Object obj) {
                QQPatchWallFragment.this.lambda$getPatchWallFlow$1$QQPatchWallFragment((PatchWall) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$QQPatchWallFragment$sAGf_4GjMjaSVeCqNAqx9vMb0Fg */

            public final void call(Object obj) {
                QQPatchWallFragment.this.lambda$getPatchWallFlow$2$QQPatchWallFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$getPatchWallFlow$1$QQPatchWallFragment(PatchWall patchWall) {
        this.refreshLayout.O0000O0o();
        boolean z = false;
        if (patchWall == null || !ContainerUtil.hasData(patchWall.blocks)) {
            this.refreshLayout.O0000O0o(false);
        } else {
            this.refreshLayout.O0000O0o(true);
            PatchWallAdapter patchWallAdapter = this.mPatchWallAdapter;
            List<PatchWall.Block> list = patchWall.blocks;
            if (this.mCurrentPage > 0) {
                z = true;
            }
            patchWallAdapter.updateQQBlocks(list, z);
            this.mCurrentPage++;
        }
        updatedDate();
    }

    public /* synthetic */ void lambda$getPatchWallFlow$2$QQPatchWallFragment(Throwable th) {
        this.loadPatchWallFail = true;
        this.refreshLayout.O0000O0o();
    }

    private void getQQtopBanner() {
        TabBannerHelper.getInstance().getBanner().observeOn(Schedulers.io()).subscribeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread()).subscribe(new Observer<Map<Integer, Banner>>() {
            /* class com.xiaomi.mico.music.patchwall.QQPatchWallFragment.AnonymousClass3 */

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
                QQPatchWallFragment.this.mPatchWallAdapter.addMihomeBanner(map.get(3));
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

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onCPAccountBindStatusChanged(MusicEvent.CPAccountBindStatusChanged cPAccountBindStatusChanged) {
        initViewState();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_music_time", "s", Integer.valueOf(currentTimeMillis));
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
    }

    public void onViewClicked() {
        QQMusicAuthPopupView.showAuthAlert(getContext(), AccountProfile.current().getQQBindStatus());
    }

    private boolean isNeedUpdateData() {
        return (((System.currentTimeMillis() - this.lastUpdateTime) > 3600000 ? 1 : ((System.currentTimeMillis() - this.lastUpdateTime) == 3600000 ? 0 : -1)) > 0) & ((this.lastUpdateTime > 0 ? 1 : (this.lastUpdateTime == 0 ? 0 : -1)) > 0);
    }

    private void updatedDate() {
        this.lastUpdateTime = System.currentTimeMillis();
    }
}
