package com.xiaomi.mico.music.patchwall;

import _m_j.jgc;
import _m_j.jgi;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.application.AccountProfile;
import com.xiaomi.mico.common.event.KKBoxAuthEvent;
import com.xiaomi.mico.common.recyclerview.LoadMoreListener;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.adapter.PatchWallAdapter;
import com.xiaomi.mico.tool.embedded.activity.CommonWebActivity;
import com.xiaomi.mico.tool.embedded.activity.oauth.KKBoxApi;
import com.xiaomi.smarthome.R;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;

public class KKBoxPatchWallFragment extends BasePatchWallFragment {
    FrameLayout bindView;
    public boolean loadPatchWallFail;
    public int mCurrentPage = 0;
    public LoadMoreListener mLoadMoreListener = new LoadMoreListener() {
        /* class com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment.AnonymousClass1 */

        public void onLoadMore() {
            KKBoxPatchWallFragment.this.getPatchWallFlow();
        }
    };
    public PatchWallAdapter mPatchWallAdapter;
    private Subscription mSubscription;
    ViewGroup notBindView;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.mico_fragment_kkbox_music;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.notBindView = (ViewGroup) view.findViewById(R.id.not_bind_view);
        this.bindView = (FrameLayout) view.findViewById(R.id.bind_view);
        view.findViewById(R.id.kkbox_bind).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.mico.music.patchwall.$$Lambda$KKBoxPatchWallFragment$N8cPi7t7AjjxMZsGp1SL5sZ4oXw */

            public final void onClick(View view) {
                KKBoxPatchWallFragment.this.lambda$onViewCreated$0$KKBoxPatchWallFragment(view);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$KKBoxPatchWallFragment(View view) {
        showOauthView();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.mRecyclerView.addOnScrollListener(this.mLoadMoreListener);
        this.mPatchWallAdapter = new PatchWallAdapter(getActivity());
        this.mPatchWallAdapter.setBlockType("block_type_music_kkbox");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        checkKKBoxOAuthStatus();
        if (!jgc.O000000o().O00000Oo(this)) {
            jgc.O000000o().O000000o(this);
        }
    }

    public void initViewState() {
        if (AccountProfile.current().isKKBoxAuthValid()) {
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
        ApiHelper.getKkboxPathWallFlow(this.mCurrentPage, 1, new ApiRequest.Listener<PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment.AnonymousClass2 */

            public void onSuccess(PatchWall patchWall) {
                KKBoxPatchWallFragment.this.mLoadMoreListener.finishLoading();
                boolean z = false;
                if (patchWall == null || !ContainerUtil.hasData(patchWall.blocks)) {
                    KKBoxPatchWallFragment.this.mLoadMoreListener.setCanLoadMore(false);
                    return;
                }
                KKBoxPatchWallFragment.this.mLoadMoreListener.setCanLoadMore(true);
                PatchWallAdapter patchWallAdapter = KKBoxPatchWallFragment.this.mPatchWallAdapter;
                List<PatchWall.Block> list = patchWall.blocks;
                if (KKBoxPatchWallFragment.this.mCurrentPage > 0) {
                    z = true;
                }
                patchWallAdapter.updateQQBlocks(list, z);
                KKBoxPatchWallFragment.this.mCurrentPage++;
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
                KKBoxPatchWallFragment kKBoxPatchWallFragment = KKBoxPatchWallFragment.this;
                kKBoxPatchWallFragment.loadPatchWallFail = true;
                kKBoxPatchWallFragment.mLoadMoreListener.finishLoading();
            }
        }).bindToLifecycle(this);
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
        }
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onKKBoxAccountBindStatusChanged(MusicEvent.CPAccountBindStatusChanged cPAccountBindStatusChanged) {
        if (cPAccountBindStatusChanged.unbind) {
            initViewState();
        }
        if (AccountProfile.current().isKKBoxAuthValid()) {
            initViewState();
        }
    }

    @jgi(O000000o = ThreadMode.MAIN)
    public void onKKBoxAuthEvent(KKBoxAuthEvent kKBoxAuthEvent) {
        if (kKBoxAuthEvent.success) {
            ToastUtil.showToast((int) R.string.skill_auth_done);
            getAuthInfo(KKBoxApi.instance().getProviderId());
            return;
        }
        ToastUtil.showToast((int) R.string.error_oauth_error);
    }

    private void showOauthView() {
        ((Activity) getContext()).startActivityForResult(CommonWebActivity.buildIntent(getContext(), getContext().getString(R.string.setting_oauth), Uri.parse("https://i.ai.mi.com/skills/account_link").buildUpon().appendQueryParameter("provider_id", "347442676548767744").appendQueryParameter("callback_url", "mico://oauth/oauth2/common").build().toString(), false), 1102);
    }

    public void getAuthInfo(String str) {
        ApiHelper.getOAuthInfo(str, new ApiRequest.Listener<MiBrain.OAuthInfo>() {
            /* class com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment.AnonymousClass3 */

            public void onFailure(ApiError apiError) {
            }

            public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                MiBrain.CPBindStatus cPBindStatus = new MiBrain.CPBindStatus();
                cPBindStatus.expireStatus = oAuthInfo.state;
                cPBindStatus.providerName = oAuthInfo.providerName;
                long time = (oAuthInfo.expireAt - new Date().getTime()) / 1000;
                if (time > 0) {
                    cPBindStatus.expiresIn = (int) time;
                }
                if (cPBindStatus.isBinded()) {
                    AccountProfile.current().setKkboxBindStatus(cPBindStatus);
                }
                KKBoxPatchWallFragment.this.initViewState();
            }
        });
    }

    public void checkKKBoxOAuthStatus() {
        AccountProfile.current().syncQQBindStatus(new ApiRequest.Listener<MiBrain.CPBindStatus>() {
            /* class com.xiaomi.mico.music.patchwall.KKBoxPatchWallFragment.AnonymousClass4 */

            public void onSuccess(MiBrain.CPBindStatus cPBindStatus) {
                KKBoxPatchWallFragment.this.initViewState();
            }

            public void onFailure(ApiError apiError) {
                new Object[1][0] = apiError;
            }
        });
    }
}
