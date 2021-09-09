package com.xiaomi.mico.music.patchwall.micoselect;

import _m_j.czx;
import _m_j.dai;
import _m_j.gsy;
import _m_j.hxi;
import _m_j.jgc;
import _m_j.jgi;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.api.LoginManager;
import com.xiaomi.mico.music.event.MusicEvent;
import com.xiaomi.mico.music.patchwall.BasePatchWallFragment;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.BaseItemBinder;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.MultiTypeAdapter;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.TypeProvider;
import com.xiaomi.mico.music.patchwall.micoselect.adapter.ViewSection;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderBanner;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderCommon;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderDedao;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderEmpty;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderImage;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderKids;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderKingKong;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderQQMusic;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderQQMusicRank;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderTitle;
import com.xiaomi.mico.music.patchwall.micoselect.viewitem.ItemBinderintelligent;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class MicoSelectPatchWallFragment extends BasePatchWallFragment {
    public boolean loadPatchWallFail;
    SelectPagerListener mListener;
    public LoginManager.LoginManagerCallback mLoginManagerCallback = new LoginManager.LoginManagerCallback() {
        /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass4 */

        public void onLoginSuccess() {
            MicoSelectPatchWallFragment.this.refreshData();
        }

        public void onLogout() {
            MicoSelectPatchWallFragment.this.refreshData();
        }
    };
    MultiTypeAdapter mMicoSelectAdapter;
    MicoSelectDataHelper mMicoSelectDataHelper;
    Subscription mSubscription;
    Subscription mSubscription2;
    SmartRefreshLayout refreshLayout;
    private long startTime;

    public int getLayoutResId() {
        return R.layout.mico_fragment_select_patchwall;
    }

    public void setSelectPagerListener(SelectPagerListener selectPagerListener) {
        this.mListener = selectPagerListener;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.refreshLayout = (SmartRefreshLayout) view.findViewById(R.id.refresh_layout);
        CoreApi.O000000o().O000000o(getActivity(), new CoreApi.O0000o00() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass1 */

            public void onAccountReady(boolean z, String str) {
                LoginManager.getInstance().addLoginManagerCallback(MicoSelectPatchWallFragment.this.mLoginManagerCallback);
            }
        });
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mMicoSelectDataHelper = new MicoSelectDataHelper();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setItemPrefetchEnabled(false);
        linearLayoutManager.setInitialPrefetchItemCount(0);
        this.mRecyclerView.setLayoutManager(linearLayoutManager);
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setItemViewCacheSize(0);
        this.refreshLayout.O00000o0(false);
        this.refreshLayout.O0000O0o(false);
        this.refreshLayout.O00000o(true);
        this.refreshLayout.O000000o(new dai() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass2 */

            public void onLoadMore(final czx czx) {
                MicoSelectPatchWallFragment micoSelectPatchWallFragment = MicoSelectPatchWallFragment.this;
                micoSelectPatchWallFragment.mSubscription2 = micoSelectPatchWallFragment.mMicoSelectDataHelper.secondMergePatchwallObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<ViewSection>>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass2.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ void call(Object obj) {
                        call((List<ViewSection>) ((List) obj));
                    }

                    public void call(List<ViewSection> list) {
                        czx.O0000O0o();
                        MicoSelectPatchWallFragment.this.mMicoSelectAdapter.updateData(MicoSelectPatchWallFragment.this.addEmptyView(list));
                        czx.O0000O0o(false);
                    }
                }, new Action1<Throwable>() {
                    /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass2.AnonymousClass2 */

                    public void call(Throwable th) {
                        czx.O0000O0o();
                    }
                });
            }
        });
        this.mMicoSelectAdapter = new MultiTypeAdapter(new TypeProvider<ViewSection>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass3 */

            public Object getType(ViewSection viewSection) {
                return viewSection.view_type;
            }
        });
        this.mMicoSelectAdapter.registerAll(generateSupportViewTypeMap());
        this.mRecyclerView.setAdapter(this.mMicoSelectAdapter);
        refreshData();
        jgc.O000000o().O000000o(this);
    }

    public List<ViewSection> addEmptyView(List<ViewSection> list) {
        ViewSection viewSection = new ViewSection();
        viewSection.view_type = "empty";
        list.add(viewSection);
        return list;
    }

    private HashMap<Object, BaseItemBinder> generateSupportViewTypeMap() {
        HashMap<Object, BaseItemBinder> hashMap = new HashMap<>();
        hashMap.put("banner", new ItemBinderBanner(getActivity(), this.mMicoSelectAdapter, null));
        hashMap.put("intelligent", new ItemBinderintelligent(getActivity()));
        hashMap.put("title", new ItemBinderTitle(getActivity(), this.mListener));
        hashMap.put("qqmusic_recommend", new ItemBinderQQMusic(getActivity()));
        hashMap.put("qqmusic_rank", new ItemBinderQQMusicRank(getActivity()));
        hashMap.put("kids", new ItemBinderKids(getActivity(), "kid"));
        hashMap.put("uncleCassie", new ItemBinderKids(getActivity(), "uncleCassie"));
        hashMap.put("audioBook", new ItemBinderCommon(getActivity(), "audioBook"));
        hashMap.put("miMusic", new ItemBinderCommon(getActivity(), "miMusic"));
        hashMap.put("singleImage", new ItemBinderImage(getActivity()));
        hashMap.put("dedao", new ItemBinderDedao(getActivity()));
        hashMap.put("empty", new ItemBinderEmpty(getActivity()));
        hashMap.put("jin_gang_wei", new ItemBinderKingKong(getActivity()));
        return hashMap;
    }

    @jgi(O000000o = ThreadMode.MAIN, O00000Oo = true)
    public void onCPAccountBindStatusChanged(MusicEvent.CPAccountBindStatusChanged cPAccountBindStatusChanged) {
        refreshData();
    }

    public void onDestroyView() {
        super.onDestroyView();
        jgc.O000000o().O00000o0(this);
        LoginManager.getInstance().removeLoginManagerCallbackCallback(this.mLoginManagerCallback);
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
        Subscription subscription2 = this.mSubscription2;
        if (subscription2 != null && !subscription2.isUnsubscribed()) {
            this.mSubscription2.unsubscribe();
            this.mSubscription2 = null;
        }
    }

    public void onActivate() {
        super.onActivate();
        this.startTime = System.currentTimeMillis();
        this.mMicoSelectAdapter.onActivate();
        if (this.loadPatchWallFail) {
            refreshData();
        }
    }

    public void onDeactivate() {
        super.onDeactivate();
        this.mMicoSelectAdapter.onDeactivate();
        int currentTimeMillis = (int) ((System.currentTimeMillis() - this.startTime) / 1000);
        hxi.O00000o0.f957O000000o.O000000o("content_recommend_time", "s", Integer.valueOf(currentTimeMillis));
    }

    public void refreshData() {
        this.refreshLayout.O0000O0o(false);
        loadData();
    }

    private void loadData() {
        this.mMicoSelectDataHelper.resetViewStatus();
        this.mSubscription = this.mMicoSelectDataHelper.selectPatchwallObservable().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<List<ViewSection>>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass5 */

            public /* bridge */ /* synthetic */ void call(Object obj) {
                call((List<ViewSection>) ((List) obj));
            }

            public void call(List<ViewSection> list) {
                MicoSelectPatchWallFragment.this.refreshLayout.O0000O0o();
                if (list == null || (list != null && list.size() == 0)) {
                    MicoSelectPatchWallFragment.this.loadPatchWallFail = true;
                } else {
                    MicoSelectPatchWallFragment.this.loadPatchWallFail = false;
                }
                if (MicoSelectPatchWallFragment.this.mMicoSelectDataHelper.hasDevice()) {
                    MicoSelectPatchWallFragment.this.mMicoSelectAdapter.updateData(list);
                    MicoSelectPatchWallFragment.this.refreshLayout.O0000O0o(true);
                    return;
                }
                MicoSelectPatchWallFragment.this.mMicoSelectAdapter.updateData(MicoSelectPatchWallFragment.this.addEmptyView(list));
                MicoSelectPatchWallFragment.this.refreshLayout.O0000O0o(false);
            }
        }, new Action1<Throwable>() {
            /* class com.xiaomi.mico.music.patchwall.micoselect.MicoSelectPatchWallFragment.AnonymousClass6 */

            public void call(Throwable th) {
                gsy.O00000Oo(12000, "12000.2.1", "");
                gsy.O00000Oo("Mico-Api", "selectPatchwall-->error" + th.toString());
                MicoSelectPatchWallFragment micoSelectPatchWallFragment = MicoSelectPatchWallFragment.this;
                micoSelectPatchWallFragment.loadPatchWallFail = true;
                micoSelectPatchWallFragment.refreshLayout.O0000O0o();
            }
        });
    }
}
