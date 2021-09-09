package com.xiaomi.mico.music.patchwall;

import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaomi.mico.api.ApiConstants;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiHelper;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.MiBrain;
import com.xiaomi.mico.api.model.PatchWall;
import com.xiaomi.mico.common.application.UserPreference;
import com.xiaomi.mico.common.event.DeDaoAuthEvent;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.music.patchwall.adapter.DeDaoPatchWallAdapter;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;

public class DeDaoPatchWallFragment extends BasePatchWallFragment {
    public boolean bindedDedao;
    public MiBrain.OAuthInfo dedaoAuthInfo;
    public boolean loadPatchWallFail;
    public DeDaoPatchWallAdapter mPatchWallAdapter;
    private Subscription mSubscription;
    public boolean needShowAuth;
    private long startTime;

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.mPatchWallAdapter = new DeDaoPatchWallAdapter(getContext());
        this.mPatchWallAdapter.setBlockType("block_type_dedao");
        this.mRecyclerView.setAdapter(this.mPatchWallAdapter);
        jgc.O000000o().O000000o(this);
        getAuthInfo();
    }

    public void getAuthInfo() {
        ApiHelper.getOAuthInfo("269135865337350144", new ApiRequest.Listener<MiBrain.OAuthInfo>() {
            /* class com.xiaomi.mico.music.patchwall.DeDaoPatchWallFragment.AnonymousClass1 */

            public void onSuccess(MiBrain.OAuthInfo oAuthInfo) {
                DeDaoPatchWallFragment deDaoPatchWallFragment = DeDaoPatchWallFragment.this;
                deDaoPatchWallFragment.dedaoAuthInfo = oAuthInfo;
                deDaoPatchWallFragment.bindedDedao = oAuthInfo.binded();
                DeDaoPatchWallFragment deDaoPatchWallFragment2 = DeDaoPatchWallFragment.this;
                deDaoPatchWallFragment2.needShowAuth = !deDaoPatchWallFragment2.bindedDedao && !UserPreference.isDedaoAuthClosed();
                DeDaoPatchWallFragment.this.getPatchWallFlow();
            }

            public void onFailure(ApiError apiError) {
                DeDaoPatchWallFragment.this.getPatchWallFlow();
            }
        }).bindToLifecycle(this);
    }

    public void getPatchWallFlow() {
        boolean z = this.bindedDedao;
        boolean isPrevEnv = ApiConstants.isPrevEnv();
        ApiHelper.getDeDaoPathWallFlow(z ? 1 : 0, isPrevEnv ? 1 : 0, new ApiRequest.Listener<PatchWall>() {
            /* class com.xiaomi.mico.music.patchwall.DeDaoPatchWallFragment.AnonymousClass2 */

            public void onSuccess(PatchWall patchWall) {
                if (patchWall != null && ContainerUtil.hasData(patchWall.blocks)) {
                    DeDaoPatchWallFragment.this.mPatchWallAdapter.setNeedShowAuth(DeDaoPatchWallFragment.this.needShowAuth);
                    DeDaoPatchWallFragment.this.mPatchWallAdapter.updateBlocks(patchWall.blocks, false);
                }
            }

            public void onFailure(ApiError apiError) {
                gsy.O00000Oo(12000, "12000.2.7", "");
                new Object[1][0] = apiError;
                DeDaoPatchWallFragment.this.loadPatchWallFail = true;
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
    }

    public void onActivate() {
        super.onActivate();
        this.mPatchWallAdapter.onActivate();
        if (this.loadPatchWallFail || this.dedaoAuthInfo == null) {
            getAuthInfo();
        }
        this.startTime = System.currentTimeMillis();
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onDedaoAuthStatusChanged(DeDaoAuthEvent deDaoAuthEvent) {
        getAuthInfo();
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mPatchWallAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_obtain_time", "s", Integer.valueOf(currentTimeMillis));
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
    }
}
