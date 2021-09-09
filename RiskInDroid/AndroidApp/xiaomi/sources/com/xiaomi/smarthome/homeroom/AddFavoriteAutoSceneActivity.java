package com.xiaomi.smarthome.homeroom;

import _m_j.ggb;
import _m_j.go;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.har;
import _m_j.hfx;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iwc;
import _m_j.ixe;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "checkedModeAdapter", "Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity$CheckedModeAdapter;", "confirmBtn", "Landroid/view/View;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadingDialogHelper", "Lcom/xiaomi/smarthome/operation/js_sdk/share/LoadingDialogHelper;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "titleTv", "Landroid/widget/TextView;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "CheckedModeAdapter", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AddFavoriteAutoSceneActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f8814O000000o;
    private O000000o O00000Oo;
    private LoadingDialogHelper O00000o = new LoadingDialogHelper(this);
    private final CompositeDisposable O00000o0 = new CompositeDisposable();
    public View confirmBtn;
    public TextView titleTv;

    public final void _$_clearFindViewByIdCache() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_favorite_device);
        View findViewById = findViewById(R.id.recycler);
        ixe.O00000Oo(findViewById, "findViewById(R.id.recycler)");
        this.f8814O000000o = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.f8814O000000o;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(5);
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new AddFavoriteAutoSceneActivity$initView$1$1(recyclerView.getContext()));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$Cy8cLLqxeCsXjF6jqX2TdFkWXA */

                public final void onClick(View view) {
                    AddFavoriteAutoSceneActivity.O000000o(AddFavoriteAutoSceneActivity.this, view);
                }
            });
            View findViewById2 = findViewById(R.id.title);
            ixe.O00000Oo(findViewById2, "findViewById(R.id.title)");
            this.titleTv = (TextView) findViewById2;
            View findViewById3 = findViewById(R.id.confirm);
            ixe.O00000Oo(findViewById3, "findViewById<View>(R.id.confirm)");
            this.confirmBtn = findViewById3;
            View view = this.confirmBtn;
            if (view != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$2QMOJIieOf42cSR5oSlGZO0Pk4Q */

                    public final void onClick(View view) {
                        AddFavoriteAutoSceneActivity.O00000Oo(AddFavoriteAutoSceneActivity.this, view);
                    }
                });
                View view2 = this.confirmBtn;
                if (view2 != null) {
                    view2.setEnabled(false);
                    TextView textView = this.titleTv;
                    if (textView != null) {
                        textView.setText((int) R.string.title_edit_choose_scene);
                        View view3 = this.confirmBtn;
                        if (view3 != null) {
                            view3.setContentDescription(getString(R.string.ok_button));
                            gzl gzl = new gzl();
                            this.O00000Oo = new O000000o(this);
                            O000000o o000000o = this.O00000Oo;
                            if (o000000o != null) {
                                gzl.O000000o(o000000o);
                                gzl.O00000Oo(new har());
                                RecyclerView recyclerView2 = this.f8814O000000o;
                                if (recyclerView2 != null) {
                                    recyclerView2.setAdapter(gzl);
                                    LoadingDialogHelper loadingDialogHelper = this.O00000o;
                                    if (loadingDialogHelper != null) {
                                        loadingDialogHelper.O000000o();
                                    }
                                    hfx hfx = hfx.f18878O000000o;
                                    String O0000OOo = ggb.O00000Oo().O0000OOo();
                                    ixe.O00000Oo(O0000OOo, "getInstance().currentHomeId");
                                    this.O00000o0.add(hfx.O000000o(O0000OOo).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                                        /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$Sd22OVv1z_IRfCcXcPsruKCkN1c */

                                        public final void accept(Object obj) {
                                            AddFavoriteAutoSceneActivity.O000000o(AddFavoriteAutoSceneActivity.this, (List) obj);
                                        }
                                    }, new Consumer() {
                                        /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$eWhGHylMhyqWNcz5JKyLMh8JIAA */

                                        public final void accept(Object obj) {
                                            AddFavoriteAutoSceneActivity.O000000o(AddFavoriteAutoSceneActivity.this, (Throwable) obj);
                                        }
                                    }));
                                    return;
                                }
                                ixe.O000000o("recycler");
                                throw null;
                            }
                            ixe.O000000o("checkedModeAdapter");
                            throw null;
                        }
                        ixe.O000000o("confirmBtn");
                        throw null;
                    }
                    ixe.O000000o("titleTv");
                    throw null;
                }
                ixe.O000000o("confirmBtn");
                throw null;
            }
            ixe.O000000o("confirmBtn");
            throw null;
        }
        ixe.O000000o("recycler");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, List list) {
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        O000000o o000000o = addFavoriteAutoSceneActivity.O00000Oo;
        if (o000000o != null) {
            ixe.O00000Oo(list, "it");
            ixe.O00000o(list, "cards");
            o000000o.f8815O000000o.clear();
            o000000o.f8815O000000o.addAll(list);
            o000000o.notifyDataSetChanged();
            hxk hxk = hxi.O00000o;
            hfx hfx = hfx.f18878O000000o;
            int size = hfx.O000000o(ggb.O00000Oo().O0000Oo0()).size();
            int size2 = o000000o.f8815O000000o.size();
            hxk.f952O000000o.O000000o("add_sence_click", "added_sence_total_number", Integer.valueOf(size), "notadded_sence_total_number", Integer.valueOf(size2));
            LoadingDialogHelper loadingDialogHelper = addFavoriteAutoSceneActivity.O00000o;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O00000Oo();
                return;
            }
            return;
        }
        ixe.O000000o("checkedModeAdapter");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, Throwable th) {
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper = addFavoriteAutoSceneActivity.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        th.printStackTrace();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, View view) {
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        addFavoriteAutoSceneActivity.finish();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v7, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    public static final void O00000Oo(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, View view) {
        List list;
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        O000000o o000000o = addFavoriteAutoSceneActivity.O00000Oo;
        if (o000000o != null) {
            if (o000000o.O00000Oo.isEmpty()) {
                list = EmptyList.f15376O000000o;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : o000000o.f8815O000000o) {
                    if (o000000o.O00000Oo.contains(Long.valueOf(((CommonUsedScene) next).f11134O000000o))) {
                        arrayList.add(next);
                    }
                }
                list = arrayList;
            }
            hxk hxk = hxi.O00000o;
            Iterable<CommonUsedScene> iterable = list;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (CommonUsedScene commonUsedScene : iterable) {
                arrayList2.add(Long.valueOf(commonUsedScene.f11134O000000o));
            }
            Object O000000o2 = iuo.O000000o((List) arrayList2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 63);
            int size = list.size();
            hfx hfx = hfx.f18878O000000o;
            int size2 = hfx.O000000o(ggb.O00000Oo().O0000Oo0()).size();
            O000000o o000000o2 = addFavoriteAutoSceneActivity.O00000Oo;
            if (o000000o2 != null) {
                int itemCount = o000000o2.getItemCount() - list.size();
                hxk.f952O000000o.O000000o("save_sence_click", "choose_scenes_us_id", O000000o2, "choose_scenes_total_number", Integer.valueOf(size), "added_sence_total_number", Integer.valueOf(size2), "notadded_sence_total_number", Integer.valueOf(itemCount));
                LoadingDialogHelper loadingDialogHelper = addFavoriteAutoSceneActivity.O00000o;
                if (loadingDialogHelper != null) {
                    loadingDialogHelper.O000000o();
                }
                hfx hfx2 = hfx.f18878O000000o;
                addFavoriteAutoSceneActivity.O00000o0.add(hfx.O00000Oo(list).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$9U393iNHoUTMVm94Fgi3e4I3KE8 */

                    public final void accept(Object obj) {
                        AddFavoriteAutoSceneActivity.O000000o(AddFavoriteAutoSceneActivity.this, (Boolean) obj);
                    }
                }, new Consumer() {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteAutoSceneActivity$J02phbCs2xr_dwUSer0eC5cC50 */

                    public final void accept(Object obj) {
                        AddFavoriteAutoSceneActivity.O00000Oo(AddFavoriteAutoSceneActivity.this, (Throwable) obj);
                    }
                }));
                return;
            }
            ixe.O000000o("checkedModeAdapter");
            throw null;
        }
        ixe.O000000o("checkedModeAdapter");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, Boolean bool) {
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper = addFavoriteAutoSceneActivity.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        hte.O000000o(addFavoriteAutoSceneActivity.getContext(), (int) R.string.action_success);
        addFavoriteAutoSceneActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity, Throwable th) {
        ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper = addFavoriteAutoSceneActivity.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        hte.O000000o(addFavoriteAutoSceneActivity.getContext(), (int) R.string.action_fail);
        addFavoriteAutoSceneActivity.finish();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0014\u0010\u0019\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity$CheckedModeAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity;)V", "checkedItems", "", "", "renderData", "", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "selectItems", "", "getSelectItems", "()Ljava/util/List;", "getColumn", "", "getItemCount", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "conatiner", "Landroid/view/ViewGroup;", "p1", "render", "cards", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        List<CommonUsedScene> f8815O000000o = new ArrayList();
        public final Set<Long> O00000Oo = new LinkedHashSet();
        final /* synthetic */ AddFavoriteAutoSceneActivity O00000o0;

        public final int O000000o() {
            return 1;
        }

        public O000000o(AddFavoriteAutoSceneActivity addFavoriteAutoSceneActivity) {
            ixe.O00000o(addFavoriteAutoSceneActivity, "this$0");
            this.O00000o0 = addFavoriteAutoSceneActivity;
        }

        public final int getItemCount() {
            return this.f8815O000000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "conatiner");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_auto_scene_select_item, viewGroup, false);
            ixe.O00000Oo(inflate, "from(conatiner.context).inflate(R.layout.main_auto_scene_select_item, conatiner, false)");
            return new C0073O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            ((C0073O000000o) o000OOo0).O000000o(this.f8815O000000o.get(i));
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity$CheckedModeAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/AddFavoriteAutoSceneActivity$CheckedModeAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "nameTv", "Landroid/widget/TextView;", "bind", "", "scene", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "refreshTitle", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0073O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f8816O000000o;
            private final TextView O00000Oo;
            private final CheckBox O00000o;
            private final SimpleDraweeView O00000o0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0073O000000o(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "itemView");
                this.f8816O000000o = o000000o;
                View findViewById = view.findViewById(R.id.name);
                ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.name)");
                this.O00000Oo = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.icon);
                ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.icon)");
                this.O00000o0 = (SimpleDraweeView) findViewById2;
                View findViewById3 = view.findViewById(R.id.check_box);
                ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.check_box)");
                this.O00000o = (CheckBox) findViewById3;
            }

            public final void O000000o(CommonUsedScene commonUsedScene) {
                ixe.O00000o(commonUsedScene, "scene");
                if (!TextUtils.isEmpty(commonUsedScene.O00000o)) {
                    this.O00000o0.setImageURI(commonUsedScene.O00000o);
                } else {
                    this.O00000o0.setActualImageResource(R.drawable.favorite_scene_placeholder_icon);
                }
                this.O00000Oo.setText(commonUsedScene.O00000Oo);
                this.O00000o.setChecked(this.f8816O000000o.O00000Oo.contains(Long.valueOf(commonUsedScene.f11134O000000o)));
                this.itemView.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: INVOKE  
                      (wrap: android.view.View : 0x003b: IGET  (r0v6 android.view.View) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.O000000o.itemView android.view.View)
                      (wrap: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE : 0x0041: CONSTRUCTOR  (r2v2 com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE) = 
                      (wrap: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o : 0x003d: IGET  (r1v5 com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.O000000o.O000000o com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o)
                      (r5v0 'commonUsedScene' com.xiaomi.smarthome.scene.bean.CommonUsedScene)
                      (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o A[THIS])
                     call: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE.<init>(com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o, com.xiaomi.smarthome.scene.bean.CommonUsedScene, com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.O000000o.O000000o(com.xiaomi.smarthome.scene.bean.CommonUsedScene):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:268)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:257)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: CONSTRUCTOR  (r2v2 com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE) = 
                      (wrap: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o : 0x003d: IGET  (r1v5 com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.O000000o.O000000o com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o)
                      (r5v0 'commonUsedScene' com.xiaomi.smarthome.scene.bean.CommonUsedScene)
                      (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o A[THIS])
                     call: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE.<init>(com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o, com.xiaomi.smarthome.scene.bean.CommonUsedScene, com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.O000000o.O000000o(com.xiaomi.smarthome.scene.bean.CommonUsedScene):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "scene"
                    _m_j.ixe.O00000o(r5, r0)
                    java.lang.String r0 = r5.O00000o
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    boolean r0 = android.text.TextUtils.isEmpty(r0)
                    if (r0 != 0) goto L_0x0017
                    com.facebook.drawee.view.SimpleDraweeView r0 = r4.O00000o0
                    java.lang.String r1 = r5.O00000o
                    r0.setImageURI(r1)
                    goto L_0x001f
                L_0x0017:
                    com.facebook.drawee.view.SimpleDraweeView r0 = r4.O00000o0
                    r1 = 2132084406(0x7f1506b6, float:1.9808982E38)
                    r0.setActualImageResource(r1)
                L_0x001f:
                    android.widget.TextView r0 = r4.O00000Oo
                    java.lang.String r1 = r5.O00000Oo
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    r0.setText(r1)
                    android.widget.CheckBox r0 = r4.O00000o
                    com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o r1 = r4.f8816O000000o
                    java.util.Set<java.lang.Long> r1 = r1.O00000Oo
                    long r2 = r5.f11134O000000o
                    java.lang.Long r2 = java.lang.Long.valueOf(r2)
                    boolean r1 = r1.contains(r2)
                    r0.setChecked(r1)
                    android.view.View r0 = r4.itemView
                    com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity$O000000o r1 = r4.f8816O000000o
                    com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE r2 = new com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavoriteAutoSceneActivity$O000000o$O000000o$7MVUPDyqOwRiNKXuq27PFj80nuE
                    r2.<init>(r1, r5, r4)
                    r0.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.homeroom.AddFavoriteAutoSceneActivity.O000000o.C0073O000000o.O000000o(com.xiaomi.smarthome.scene.bean.CommonUsedScene):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(O000000o o000000o, CommonUsedScene commonUsedScene, C0073O000000o o000000o2, View view) {
                String str;
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(commonUsedScene, "$scene");
                ixe.O00000o(o000000o2, "this$1");
                if (o000000o.O00000Oo.contains(Long.valueOf(commonUsedScene.f11134O000000o))) {
                    o000000o.O00000Oo.remove(Long.valueOf(commonUsedScene.f11134O000000o));
                } else {
                    o000000o.O00000Oo.add(Long.valueOf(commonUsedScene.f11134O000000o));
                }
                CheckBox checkBox = o000000o2.O00000o;
                checkBox.setChecked(!checkBox.isChecked());
                int size = o000000o2.f8816O000000o.O00000Oo.size();
                boolean z = false;
                if (size == 0) {
                    str = o000000o2.f8816O000000o.O00000o0.getResources().getString(R.string.title_edit_choose_scene);
                } else {
                    str = o000000o2.f8816O000000o.O00000o0.getResources().getQuantityString(R.plurals.edit_choosed_scene, size, Integer.valueOf(size));
                }
                ixe.O00000Oo(str, "if (checkedSize == 0) {\n                    resources.getString(R.string.title_edit_choose_scene)\n                } else {\n                    resources.getQuantityString(R.plurals.edit_choosed_scene, checkedSize, checkedSize)\n                }");
                TextView textView = o000000o2.f8816O000000o.O00000o0.titleTv;
                if (textView != null) {
                    textView.setText(str);
                    View view2 = o000000o2.f8816O000000o.O00000o0.confirmBtn;
                    if (view2 != null) {
                        if (size != 0) {
                            z = true;
                        }
                        view2.setEnabled(z);
                        return;
                    }
                    ixe.O000000o("confirmBtn");
                    throw null;
                }
                ixe.O000000o("titleTv");
                throw null;
            }
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.O00000o0.clear();
        LoadingDialogHelper loadingDialogHelper = this.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        this.O00000o = null;
    }
}
