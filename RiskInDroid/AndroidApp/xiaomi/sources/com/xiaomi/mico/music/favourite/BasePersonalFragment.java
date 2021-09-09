package com.xiaomi.mico.music.favourite;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.ApiError;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.base.EditorBarFragment;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.common.editorbar.MenuBuilder;
import com.xiaomi.mico.common.recyclerview.adapter.ItemClickableAdapter;
import com.xiaomi.mico.common.recyclerview.adapter.LEEAdapter;
import com.xiaomi.mico.common.recyclerview.itemdecoration.Ignore;
import com.xiaomi.mico.common.recyclerview.itemdecoration.ItemDecorationHelper;
import com.xiaomi.mico.common.util.ContainerUtil;
import com.xiaomi.mico.common.util.ToastUtil;
import com.xiaomi.mico.common.util.ViewUtil;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.DefaultAdapter;
import com.xiaomi.smarthome.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public abstract class BasePersonalFragment<T> extends EditorBarFragment implements ItemClickableAdapter.OnItemClickListener {
    protected DefaultAdapter.Editable mAdapter;
    public LEEAdapter mLEEAdapter;
    RecyclerView mRecyclerView;
    private boolean mSelectorUpdatePending;
    private Subscription mSubscription;

    /* access modifiers changed from: protected */
    public abstract int getFavType();

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.view_linear_recycler_view;
    }

    /* access modifiers changed from: protected */
    public abstract Observable<List<T>> getListObservable();

    /* access modifiers changed from: protected */
    public String getStationType() {
        return null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.linear_recycle_view);
        return inflate;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getFavType() != 4) {
            this.mRecyclerView.addItemDecoration(ItemDecorationHelper.listDivider(getContext(), getResources().getDimensionPixelSize(R.dimen.music_item_padding_start), 0, new Ignore() {
                /* class com.xiaomi.mico.music.favourite.$$Lambda$BasePersonalFragment$2Dbbvd90QYsYDjhhyySos8mwieI */

                public final boolean needIgnore(int i, int i2) {
                    return BasePersonalFragment.this.lambda$onActivityCreated$0$BasePersonalFragment(i, i2);
                }
            }));
        }
        this.mRecyclerView.setHasFixedSize(true);
        if (this.mAdapter == null) {
            this.mAdapter = new DefaultAdapter.Editable(getEditorBar(), getMenuCallback());
            this.mAdapter.setOnItemClickListener(this);
        }
        View inflate = LayoutInflater.from(getContext()).inflate((int) R.layout.view_loading, (ViewGroup) this.mRecyclerView, false);
        View inflate2 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.mRecyclerView, false);
        ViewUtil.setupEmptyView(inflate2, null);
        View inflate3 = LayoutInflater.from(getContext()).inflate((int) R.layout.view_empty_error, (ViewGroup) this.mRecyclerView, false);
        ViewUtil.setupErrorView(inflate3, new Action1() {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$BasePersonalFragment$eSsgBexOQ28ghcLfRo9Ie098lps */

            public final void call(Object obj) {
                BasePersonalFragment.this.lambda$onActivityCreated$1$BasePersonalFragment((Void) obj);
            }
        });
        this.mLEEAdapter = new LEEAdapter(this.mAdapter, inflate, inflate2, inflate3);
        this.mRecyclerView.setAdapter(this.mLEEAdapter);
        if (this.mSelectorUpdatePending) {
            getEditorBar().setSelector(this.mAdapter);
            this.mSelectorUpdatePending = false;
        }
    }

    public /* synthetic */ boolean lambda$onActivityCreated$0$BasePersonalFragment(int i, int i2) {
        return this.mLEEAdapter.getCurrentView() != 100;
    }

    public /* synthetic */ void lambda$onActivityCreated$1$BasePersonalFragment(Void voidR) {
        this.mLEEAdapter.setCurrentView(101);
        updateData();
    }

    /* access modifiers changed from: protected */
    public ActionMenu.MenuCallback getMenuCallback() {
        return new ActionMenu.MenuCallback() {
            /* class com.xiaomi.mico.music.favourite.BasePersonalFragment.AnonymousClass1 */

            public void onPrepareMenu(MenuBuilder menuBuilder) {
                menuBuilder.add(1, R.drawable.icon_menu_delete, BasePersonalFragment.this.getString(R.string.common_menu_delete));
            }

            public void onMenuItemClick(MenuBuilder.MenuItem menuItem) {
                if (menuItem.getId() == 1) {
                    BasePersonalFragment basePersonalFragment = BasePersonalFragment.this;
                    basePersonalFragment.bulkUnlike(basePersonalFragment.mAdapter.getSelectedPositions());
                }
            }
        };
    }

    public void onDestroyView() {
        super.onDestroyView();
        Subscription subscription = this.mSubscription;
        if (subscription != null && !subscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
            this.mSubscription = null;
        }
        this.mLEEAdapter = null;
    }

    public void onActivate() {
        super.onActivate();
        if (!getEditorBar().isInEditorMode() && this.mLEEAdapter.getCurrentView() != 103) {
            Subscription subscription = this.mSubscription;
            if (subscription == null || subscription.isUnsubscribed()) {
                if (this.mAdapter.isNullDataList()) {
                    this.mLEEAdapter.setCurrentView(101);
                } else if (this.mAdapter.getDataSize() == 0) {
                    this.mLEEAdapter.setCurrentView(102);
                }
                updateData();
            }
        }
    }

    public void onItemClick(ItemClickableAdapter.ViewHolder viewHolder, int i) {
        MusicHelper.processMusic(getContext(), (Serializable) this.mAdapter.getData(i));
    }

    public void updateEditorBarSelector() {
        if (this.mAdapter != null) {
            getEditorBar().setSelector(this.mAdapter);
        } else {
            this.mSelectorUpdatePending = true;
        }
    }

    private void updateData() {
        if (getStationType() != null) {
            this.mAdapter.setAdapterType(2);
        } else {
            this.mAdapter.setAdapterType(1);
        }
        this.mSubscription = getListObservable().subscribe(new Action1() {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$HUWwdA2YaTBYIEDlBC3eFIiiXQE */

            public final void call(Object obj) {
                BasePersonalFragment.this.handleFetchSuccess((List) obj);
            }
        }, new Action1() {
            /* class com.xiaomi.mico.music.favourite.$$Lambda$BasePersonalFragment$4Q8J33MDtA8Pz46FS3EeTtgE */

            public final void call(Object obj) {
                BasePersonalFragment.this.lambda$updateData$2$BasePersonalFragment((Throwable) obj);
            }
        });
    }

    public /* synthetic */ void lambda$updateData$2$BasePersonalFragment(Throwable th) {
        handleFetchFailed();
    }

    /* access modifiers changed from: protected */
    public void handleFetchFailed() {
        if (this.mAdapter.isNullDataList()) {
            this.mLEEAdapter.setCurrentView(103);
        }
    }

    /* access modifiers changed from: protected */
    public void handleFetchSuccess(List<T> list) {
        this.mAdapter.updateDataList(list);
        if (ContainerUtil.hasData(list)) {
            this.mLEEAdapter.setCurrentView(100);
        } else {
            this.mLEEAdapter.setCurrentView(102);
        }
    }

    public void bulkUnlike(final List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (Integer intValue : list) {
                try {
                    arrayList.add(Long.valueOf(Long.parseLong(MusicHelper.getLikeID((Serializable) this.mAdapter.getData(intValue.intValue())))));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            showProgressDialog(getString(R.string.common_waiting));
            FavouriteManager.getInstance().bulkUnlike(getFavType(), arrayList, new ApiRequest.Listener<String>() {
                /* class com.xiaomi.mico.music.favourite.BasePersonalFragment.AnonymousClass2 */

                public void onSuccess(String str) {
                    BasePersonalFragment.this.dismissProgressDialog();
                    BasePersonalFragment.this.mAdapter.removeSelectedPositions(list);
                    if (BasePersonalFragment.this.mAdapter.getDataSize() == 0) {
                        BasePersonalFragment.this.mLEEAdapter.setCurrentView(102);
                    }
                }

                public void onFailure(ApiError apiError) {
                    BasePersonalFragment.this.dismissProgressDialog();
                    ToastUtil.showToast((int) R.string.common_failed);
                }
            });
        }
    }
}
