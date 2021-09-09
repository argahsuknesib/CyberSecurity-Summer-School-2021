package _m_j;

import _m_j.gp;
import _m_j.gs;
import _m_j.gzq;
import _m_j.hah;
import _m_j.hbm;
import _m_j.hha;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$editMenus$2;
import com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$enterEditMode$1;
import com.xiaomi.smarthome.newui.adapter.MainFavoriteSceneAdapter$exitEditMode$1;
import com.xiaomi.smarthome.newui.page.SceneEditPage;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0003Z[\\B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\nH\u0016J\"\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020\bH\u0016J\u0010\u0010(\u001a\u00020\u00152\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0015H\u0002J\b\u0010,\u001a\u00020\bH\u0016J\b\u0010-\u001a\u00020\bH\u0016J0\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020*2\u0006\u0010'\u001a\u00020\b2\u0006\u00102\u001a\u00020$2\u0006\u00103\u001a\u000204H\u0016J\u001c\u00105\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0010\u00106\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u00107\u001a\u00020 2\u0006\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\bH\u0016J\u0010\u0010:\u001a\u00020 2\u0006\u0010;\u001a\u00020\u0015H\u0014J\u0010\u0010<\u001a\u00020 2\u0006\u0010;\u001a\u00020\u0015H\u0014J\u0010\u0010=\u001a\u00020 2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010>\u001a\u00020&2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\bH\u0016J\b\u0010B\u001a\u00020 H\u0016J\u0018\u0010C\u001a\u00020\u00152\u0006\u0010)\u001a\u00020\b2\u0006\u0010D\u001a\u00020\bH\u0016J\u0010\u0010E\u001a\u00020 2\u0006\u00101\u001a\u00020*H\u0002J\b\u0010F\u001a\u00020 H\u0016J\u0010\u0010G\u001a\u00020 2\u0006\u00101\u001a\u00020*H\u0002J\u0010\u0010H\u001a\u00020 2\u0006\u00101\u001a\u00020*H\u0002J\u0018\u0010I\u001a\u00020 2\u0006\u00101\u001a\u00020*2\u0006\u0010J\u001a\u00020\u0015H\u0016J\u0018\u0010K\u001a\u00020 2\u0006\u0010L\u001a\u00020\u001c2\u0006\u0010M\u001a\u00020NH\u0002J\u0010\u0010O\u001a\u00020 2\u0006\u0010P\u001a\u00020QH\u0002J\u0014\u0010R\u001a\u00020 2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0\fJ\u0016\u0010T\u001a\u00020 2\f\u0010S\u001a\b\u0012\u0004\u0012\u00020\u001c0\fH\u0002J\b\u0010U\u001a\u00020 H\u0002J\"\u0010V\u001a\u0004\u0018\u00010W2\u0006\u0010P\u001a\u00020Q2\u0006\u0010X\u001a\u00020\u00062\u0006\u0010Y\u001a\u00020WH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u000f¨\u0006]"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "Lcom/xiaomi/smarthome/newui/page/SceneEditPage$IExitCallBack;", "()V", "checkedItems", "", "", "columnFlex", "", "dragHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "editMenus", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "getEditMenus", "()Ljava/util/List;", "editMenus$delegate", "Lkotlin/Lazy;", "editPage", "Lcom/xiaomi/smarthome/newui/page/SceneEditPage;", "isOrderDirty", "", "lastSceneEditMode", "offsetVertical", "getOffsetVertical", "()I", "renderData", "", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "selectItems", "getSelectItems", "attachDragHelper", "", "touchHelper", "clearView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "enterEditMode", "from", "Landroid/view/View;", "exitEditMode", "getColumn", "getItemCount", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getMovementFlags", "onAttachedToRecyclerView", "onBindViewHolder", "vh", "pos", "onCameraEditModeChanged", "current", "onCardEditModeChanged", "onConfigurationChanged", "onCreateViewHolder", "conatiner", "Landroid/view/ViewGroup;", "p1", "onExit", "onItemMove", "to", "onPinTop", "onReleaseDrag", "onRemove", "onRename", "onSelectButtonClick", "isSelectAll", "playSceneClickAnim", "scene", "imageView", "Landroid/widget/ImageView;", "refreshEditPage", "context", "Landroid/content/Context;", "render", "scenes", "renderInvoked", "saveOrder", "validMsgForSceneName", "", "sceneId", "name", "Companion", "SimpleDiffCallback", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbm extends haz implements SceneEditPage.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18746O000000o = new O000000o((byte) 0);
    public gs O00000Oo;
    public final Set<Long> O0000Oo = new LinkedHashSet();
    public List<CommonUsedScene> O0000Oo0 = new ArrayList();
    private int O0000OoO = hha.O000000o.O000000o().f18929O000000o;
    private boolean O0000Ooo;
    private final itz O0000o0 = iua.O000000o(new MainFavoriteSceneAdapter$editMenus$2(this));
    private SceneEditPage O0000o00;
    private boolean O0000o0O;

    /* access modifiers changed from: private */
    public static final void O000000o(Boolean bool) {
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Throwable th) {
    }

    public hbm() {
        hha.O000000o o000000o = hha.f18928O000000o;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public final List<CommonUsedScene> O00000Oo() {
        if (this.O0000Oo.isEmpty()) {
            return EmptyList.f15376O000000o;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.O0000Oo0) {
            if (this.O0000Oo.contains(Long.valueOf(((CommonUsedScene) next).f11134O000000o))) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void O000000o(List<? extends CommonUsedScene> list) {
        ixe.O00000o(list, "scenes");
        if (!this.O00000oO && !this.O00000o) {
            O00000Oo(list);
        }
    }

    private final void O00000Oo(List<? extends CommonUsedScene> list) {
        if (!ixe.O000000o(list, this.O0000Oo0)) {
            if (list.size() != this.O0000Oo0.size()) {
                this.O0000Oo0.clear();
                this.O0000Oo0.addAll(list);
                notifyDataSetChanged();
                return;
            }
            gp.O00000Oo O000000o2 = gp.O000000o(new O00000Oo(this.O0000Oo0, list));
            ixe.O00000Oo(O000000o2, "calculateDiff(SimpleDiffCallback(renderData, scenes))");
            this.O0000Oo0.clear();
            this.O0000Oo0.addAll(list);
            O000000o2.O000000o(this);
        }
    }

    public final int O000000o() {
        return this.O0000OoO;
    }

    public final int getItemCount() {
        return this.O0000Oo0.size();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "conatiner");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_auto_scene_item, viewGroup, false);
        ixe.O00000Oo(inflate, "from(conatiner.context).inflate(R.layout.main_auto_scene_item, conatiner, false)");
        return new O00000o0(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "vh");
        ((O00000o0) o000OOo0).O000000o(this.O0000Oo0.get(i));
    }

    public final boolean O000000o(View view) {
        if (this.O00000o) {
            return false;
        }
        if (this.O0000o00 == null) {
            Context context = view.getContext();
            if (context != null) {
                String string = view.getResources().getString(R.string.title_edit_choose_scene);
                ixe.O00000Oo(string, "from.resources.getString(R.string.title_edit_choose_scene)");
                this.O0000o00 = new SceneEditPage((FragmentActivity) context, string, this, (List) this.O0000o0.O000000o());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
        SceneEditPage sceneEditPage = this.O0000o00;
        if (sceneEditPage != null) {
            sceneEditPage.e_();
        }
        this.O00000o = true;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000oO, new MainFavoriteSceneAdapter$enterEditMode$1(this));
        return true;
    }

    public final boolean O00000o0() {
        if (!this.O00000o) {
            return false;
        }
        this.O00000o = false;
        this.O0000o0O = false;
        SceneEditPage sceneEditPage = this.O0000o00;
        if (sceneEditPage != null) {
            sceneEditPage.O00000Oo();
        }
        this.O0000o00 = null;
        this.O0000Oo.clear();
        if (this.O0000Ooo) {
            this.O0000Ooo = false;
            hfx hfx = hfx.f18878O000000o;
            String O0000OOo = ggb.O00000Oo().O0000OOo();
            ixe.O00000Oo(O0000OOo, "getInstance().currentHomeId");
            this.O00000o0.add(hfx.O000000o(O0000OOo, this.O0000Oo0).observeOn(AndroidSchedulers.mainThread()).subscribe($$Lambda$hbm$rruIeFxSeR8BUT4H1ykoE2L2Qvk.INSTANCE, $$Lambda$hbm$Qt5UU0O6cB1PrhaTV683mvuxZc4.INSTANCE));
        }
        notifyDataSetChanged();
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000oO, new MainFavoriteSceneAdapter$exitEditMode$1(this));
        return true;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "nameTv", "Landroid/widget/TextView;", "bind", "", "scene", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hbm f18749O000000o;
        private final TextView O00000Oo;
        private final CheckBox O00000o;
        private final SimpleDraweeView O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000o0(hbm hbm, View view) {
            super(view);
            ixe.O00000o(hbm, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18749O000000o = hbm;
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
            this.O00000Oo.setText(commonUsedScene.O00000Oo);
            if (!TextUtils.isEmpty(commonUsedScene.O00000o)) {
                this.O00000o0.setImageURI(commonUsedScene.O00000o);
            } else {
                this.O00000o0.setActualImageResource(R.drawable.favorite_scene_placeholder_icon);
            }
            int i = 0;
            this.O00000o.setChecked(this.f18749O000000o.O00000o && this.f18749O000000o.O0000Oo.contains(Long.valueOf(commonUsedScene.f11134O000000o)));
            CheckBox checkBox = this.O00000o;
            if (!this.f18749O000000o.O00000o) {
                i = 8;
            }
            checkBox.setVisibility(i);
            this.itemView.setOnClickListener(new View.OnClickListener(commonUsedScene, this) {
                /* class _m_j.$$Lambda$hbm$O00000o0$Bhn0ye32nmtbltsTHqm3RBaVAeU */
                private final /* synthetic */ CommonUsedScene f$1;
                private final /* synthetic */ hbm.O00000o0 f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    hbm.O00000o0.O000000o(hbm.this, this.f$1, this.f$2, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener(this, commonUsedScene) {
                /* class _m_j.$$Lambda$hbm$O00000o0$neR22nyCxnHLnEhMl83ycgTK76Y */
                private final /* synthetic */ hbm.O00000o0 f$1;
                private final /* synthetic */ CommonUsedScene f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final boolean onLongClick(View view) {
                    return hbm.O00000o0.O000000o(hbm.this, this.f$1, this.f$2, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(hbm hbm, CommonUsedScene commonUsedScene, O00000o0 o00000o0, View view) {
            ixe.O00000o(hbm, "this$0");
            ixe.O00000o(commonUsedScene, "$scene");
            ixe.O00000o(o00000o0, "this$1");
            if (hbm.O00000o) {
                if (hbm.O0000Oo.contains(Long.valueOf(commonUsedScene.f11134O000000o))) {
                    hbm.O0000Oo.remove(Long.valueOf(commonUsedScene.f11134O000000o));
                } else {
                    hbm.O0000Oo.add(Long.valueOf(commonUsedScene.f11134O000000o));
                }
                CheckBox checkBox = o00000o0.O00000o;
                checkBox.setChecked(!checkBox.isChecked());
                Context context = view.getContext();
                ixe.O00000Oo(context, "it.context");
                hbm.O000000o(context);
                return;
            }
            hbm.O000000o(commonUsedScene, o00000o0.O00000o0);
            hxk hxk = hxi.O00000o;
            int size = hbm.O0000Oo0.size();
            int indexOf = hbm.O0000Oo0.indexOf(commonUsedScene);
            String valueOf = String.valueOf(commonUsedScene.f11134O000000o);
            hxk.f952O000000o.O000000o("added_sence_click", "added_sence_total_number", Integer.valueOf(size), "added_sence_order", Integer.valueOf(indexOf), "us_id", valueOf);
            hfx hfx = hfx.f18878O000000o;
            hfx.O000000o(commonUsedScene).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class _m_j.$$Lambda$hbm$O00000o0$hzDvR1xzr8souDLvyV6q1ohDUhI */

                public final void accept(Object obj) {
                    hbm.O00000o0.O000000o(hbm.O00000o0.this, (Boolean) obj);
                }
            }, new Consumer() {
                /* class _m_j.$$Lambda$hbm$O00000o0$8icoftbtlpoSWpyvrVmcbWS5sr8 */

                public final void accept(Object obj) {
                    hbm.O00000o0.O000000o(hbm.O00000o0.this, (Throwable) obj);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000o0 o00000o0, Boolean bool) {
            ixe.O00000o(o00000o0, "this$0");
            hte.O000000o(o00000o0.itemView.getContext(), (int) R.string.execute_success);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000o0 o00000o0, Throwable th) {
            ixe.O00000o(o00000o0, "this$0");
            hte.O000000o(o00000o0.itemView.getContext(), (int) R.string.action_fail);
        }

        /* access modifiers changed from: private */
        public static final boolean O000000o(hbm hbm, O00000o0 o00000o0, CommonUsedScene commonUsedScene, View view) {
            ixe.O00000o(hbm, "this$0");
            ixe.O00000o(o00000o0, "this$1");
            ixe.O00000o(commonUsedScene, "$scene");
            gs gsVar = hbm.O00000Oo;
            if (gsVar == null) {
                return false;
            }
            gsVar.O00000Oo(o00000o0);
            View view2 = o00000o0.itemView;
            ixe.O00000Oo(view2, "itemView");
            if (hbm.O000000o(view2)) {
                hbm.O0000Oo.add(Long.valueOf(commonUsedScene.f11134O000000o));
                o00000o0.O00000o.setChecked(true);
                Context context = view.getContext();
                ixe.O00000Oo(context, "it.context");
                hbm.O000000o(context);
            }
            return true;
        }
    }

    public static void O000000o(CommonUsedScene commonUsedScene, ImageView imageView) {
        imageView.setTag(Long.valueOf(commonUsedScene.f11134O000000o));
        imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.mj_color_green_normal));
        imageView.postDelayed(new Runnable(imageView, commonUsedScene) {
            /* class _m_j.$$Lambda$hbm$H9G90YIgNJQtrSoXNMVNQv26eRU */
            private final /* synthetic */ ImageView f$0;
            private final /* synthetic */ CommonUsedScene f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                hbm.O000000o(this.f$0, this.f$1);
            }
        }, 1000);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ImageView imageView, CommonUsedScene commonUsedScene) {
        ixe.O00000o(imageView, "$imageView");
        ixe.O00000o(commonUsedScene, "$scene");
        if (ixe.O000000o(imageView.getTag(), Long.valueOf(commonUsedScene.f11134O000000o))) {
            imageView.setColorFilter(imageView.getContext().getResources().getColor(R.color.mj_color_black));
        }
    }

    public final void O0000OOo() {
        boolean z = this.O00000o && !this.O0000o0O;
        this.O0000o0O = this.O00000o;
        if (z) {
            ServiceApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.$$Lambda$hbm$vg1ryDaxZnWlSTBPklCwh2tAXoA */

                public final void run() {
                    hbm.O000000o(hbm.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hbm hbm) {
        ixe.O00000o(hbm, "this$0");
        hbm.notifyDataSetChanged();
    }

    public final void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i) {
        View view;
        ixe.O00000o(recyclerView, "recyclerView");
        super.O000000o(recyclerView, o000OOo0, i);
        if (o000OOo0 == null) {
            view = null;
        } else {
            view = o000OOo0.itemView;
        }
        if (view != null) {
            view.setBackground(null);
        }
        notifyItemChanged(i);
    }

    public final boolean O000000o(int i, int i2) {
        this.O0000Ooo = true;
        if (i >= i2) {
            int i3 = i2 + 1;
            if (i3 <= i) {
                int i4 = i;
                while (true) {
                    int i5 = i4 - 1;
                    Collections.swap(this.O0000Oo0, i4, i4 - 1);
                    if (i4 == i3) {
                        break;
                    }
                    i4 = i5;
                }
            }
        } else if (i < i2) {
            int i6 = i;
            while (true) {
                int i7 = i6 + 1;
                Collections.swap(this.O0000Oo0, i6, i7);
                if (i7 >= i2) {
                    break;
                }
                i6 = i7;
            }
        }
        notifyItemMoved(i, i2);
        return true;
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CompositeDisposable compositeDisposable = this.O00000o0;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        compositeDisposable.addAll(gzq.O00000oO.map($$Lambda$hbm$4EH1u29G7X912pg7afwo9YUvWNc.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).filter($$Lambda$hbm$FD9wEKAM4TqzZWhlRPh6jZOGStI.INSTANCE).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$hbm$fLWFgIBqxclW9AIYJmFXBrzu2oY */

            public final void accept(Object obj) {
                hbm.O000000o(hbm.this, (Boolean) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final boolean O00000Oo(Boolean bool) {
        ixe.O00000o(bool, "it");
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hbm hbm, Boolean bool) {
        ixe.O00000o(hbm, "this$0");
        SceneEditPage sceneEditPage = hbm.O0000o00;
        if (sceneEditPage != null) {
            sceneEditPage.O00000Oo();
        }
    }

    public final void O000000o(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O0000OoO = hha.O000000o.O000000o().f18929O000000o;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(boolean z) {
        super.O000000o(z);
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(boolean z) {
        super.O00000o0(z);
        notifyDataSetChanged();
    }

    public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000oO) {
            return 0;
        }
        return gs.O000000o.O000000o(15);
    }

    public final void O000000o(gs gsVar) {
        ixe.O00000o(gsVar, "touchHelper");
        this.O00000Oo = gsVar;
    }

    private static int O0000Oo() {
        return gpc.O000000o(CommonApplication.getAppContext(), 26.0f);
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        rect.top = O0000Oo();
        boolean z = false;
        if (getItemCount() % this.O0000OoO != 0 ? !(i < getItemCount() - (getItemCount() % this.O0000OoO) || i > (getItemCount() + (this.O0000OoO - (getItemCount() % this.O0000OoO))) - 1) : !(i < getItemCount() - this.O0000OoO || i > getItemCount() - 1)) {
            z = true;
        }
        if (z) {
            rect.bottom = O0000Oo();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter$onRename$1", "Lcom/xiaomi/smarthome/newui/NameEditDialogHelper$NameEditListener;", "onConfirm", "", "name", "", "onTextChanged", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o implements hah.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ CommonUsedScene f18748O000000o;
        final /* synthetic */ hbm O00000Oo;
        final /* synthetic */ View O00000o0;

        public O00000o(CommonUsedScene commonUsedScene, hbm hbm, View view) {
            this.f18748O000000o = commonUsedScene;
            this.O00000Oo = hbm;
            this.O00000o0 = view;
        }

        public final void O000000o(String str) {
            ixe.O00000o(str, "name");
            this.f18748O000000o.O00000Oo = str;
            this.O00000Oo.O00000o0();
            hfx hfx = hfx.f18878O000000o;
            Observable<Boolean> observeOn = hfx.O00000Oo(this.f18748O000000o).observeOn(AndroidSchedulers.mainThread());
            View view = this.O00000o0;
            this.O00000Oo.O00000o0.add(observeOn.subscribe(new Consumer(view) {
                /* class _m_j.$$Lambda$hbm$O00000o$c1SQC4ZRfeXHc3hmYigfih9aOk */
                private final /* synthetic */ View f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    hbm.O00000o.O000000o(this.f$0, (Boolean) obj);
                }
            }, new Consumer(view) {
                /* class _m_j.$$Lambda$hbm$O00000o$C9yGbMQyXXPJOx5jpEX75R2I4so */
                private final /* synthetic */ View f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    hbm.O00000o.O000000o(this.f$0, (Throwable) obj);
                }
            }));
        }

        /* access modifiers changed from: private */
        public static final void O000000o(View view, Boolean bool) {
            ixe.O00000o(view, "$view");
            hte.O000000o(view.getContext(), (int) R.string.action_success);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(View view, Throwable th) {
            ixe.O00000o(view, "$view");
            hte.O000000o(view.getContext(), (int) R.string.action_fail);
        }

        public final String O00000Oo(String str) {
            ixe.O00000o(str, "name");
            Context context = this.O00000o0.getContext();
            ixe.O00000Oo(context, "view.context");
            return hbm.O000000o(context, this.f18748O000000o.f11134O000000o, str);
        }
    }

    public final void O00000o() {
        List<CommonUsedScene> O00000Oo2 = O00000Oo();
        List O000000o2 = iuo.O000000o((Collection) this.O0000Oo0);
        Collection collection = O00000Oo2;
        O000000o2.removeAll(collection);
        O000000o2.addAll(0, collection);
        O00000Oo(O000000o2);
        this.O0000Ooo = true;
        O00000o0();
    }

    public final void O00000Oo(View view) {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(view.getContext());
        builder.O00000o0();
        builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
        builder.O00000Oo(view.getResources().getQuantityString(R.plurals.dialog_title_confirm_delete_scene, O00000Oo().size(), Integer.valueOf(O00000Oo().size())));
        builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(view) {
            /* class _m_j.$$Lambda$hbm$IN6RRGgZ252E0Y5EoNTncAqxNLw */
            private final /* synthetic */ View f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                hbm.O000000o(hbm.this, this.f$1, dialogInterface, i);
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, $$Lambda$hbm$MVTlPjMIP7ihEvgnqeyhcsxJHQk.INSTANCE);
        builder.O000000o(true);
        builder.O00000oo();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hbm hbm, View view, DialogInterface dialogInterface, int i) {
        ixe.O00000o(hbm, "this$0");
        ixe.O00000o(view, "$view");
        List O000000o2 = iuo.O000000o((Collection) hbm.O0000Oo0);
        List<CommonUsedScene> O00000Oo2 = hbm.O00000Oo();
        O000000o2.removeAll(O00000Oo2);
        hbm.O00000Oo(O000000o2);
        hbm.O00000o0();
        hfx hfx = hfx.f18878O000000o;
        hbm.O00000o0.add(hfx.O000000o(O00000Oo2).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(view) {
            /* class _m_j.$$Lambda$hbm$lpAORGjhpGlI5Y2ixw9InumhPTw */
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                hbm.O000000o(this.f$0, (Boolean) obj);
            }
        }, new Consumer(view) {
            /* class _m_j.$$Lambda$hbm$WEZx9NO8hJWEoj7pXhmpWuZQ0Y */
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                hbm.O000000o(this.f$0, (Throwable) obj);
            }
        }));
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, Boolean bool) {
        ixe.O00000o(view, "$view");
        hte.O000000o(view.getContext(), (int) R.string.action_success);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, Throwable th) {
        ixe.O00000o(view, "$view");
        hte.O000000o(view.getContext(), (int) R.string.action_fail);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }

    public final void O00000oO() {
        O00000o0();
    }

    public final void O000000o(View view, boolean z) {
        ixe.O00000o(view, "view");
        if (z) {
            Set<Long> set = this.O0000Oo;
            Iterable<CommonUsedScene> iterable = this.O0000Oo0;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (CommonUsedScene commonUsedScene : iterable) {
                arrayList.add(Long.valueOf(commonUsedScene.f11134O000000o));
            }
            set.addAll((List) arrayList);
        } else {
            this.O0000Oo.clear();
        }
        notifyDataSetChanged();
        Context context = view.getContext();
        ixe.O00000Oo(context, "view.context");
        O000000o(context);
    }

    public final void O000000o(Context context) {
        String str;
        int size = this.O0000Oo.size();
        boolean z = false;
        if (size == 0) {
            str = context.getResources().getString(R.string.title_edit_choose_scene);
        } else {
            str = context.getResources().getQuantityString(R.plurals.edit_choosed_scene, size, Integer.valueOf(size));
        }
        ixe.O00000Oo(str, "if (checkedSize == 0) {\n            context.resources.getString(R.string.title_edit_choose_scene)\n        } else {\n            context.resources.getQuantityString(R.plurals.edit_choosed_scene, checkedSize, checkedSize)\n        }");
        SceneEditPage sceneEditPage = this.O0000o00;
        if (sceneEditPage != null) {
            if (size == getItemCount()) {
                z = true;
            }
            sceneEditPage.O000000o(str, z);
        }
    }

    public static String O000000o(Context context, long j, String str) {
        if (iyo.O000000o((CharSequence) str)) {
            return null;
        }
        try {
            Result.O000000o o000000o = Result.f15374O000000o;
            return hor.O000000o().validMsgForScene(context, j, str);
        } catch (Throwable th) {
            Result.O000000o o000000o2 = Result.f15374O000000o;
            Object O00000o02 = Result.O00000o0(iue.O000000o(th));
            if (Result.O000000o(O00000o02)) {
                O00000o02 = null;
            }
            return (String) O00000o02;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainFavoriteSceneAdapter$SimpleDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "from", "", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "to", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "p0", "", "p1", "areItemsTheSame", "getNewListSize", "getOldListSize", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000Oo extends gp.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final List<CommonUsedScene> f18747O000000o;
        private final List<CommonUsedScene> O00000Oo;

        /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Object, java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, java.util.List<com.xiaomi.smarthome.scene.bean.CommonUsedScene>, java.util.List<? extends com.xiaomi.smarthome.scene.bean.CommonUsedScene>] */
        /* JADX WARNING: Unknown variable types count: 2 */
        public O00000Oo(List<? extends CommonUsedScene> r2, List<? extends CommonUsedScene> r3) {
            ixe.O00000o(r2, "from");
            ixe.O00000o(r3, "to");
            this.f18747O000000o = r2;
            this.O00000Oo = r3;
        }

        public final boolean O000000o(int i, int i2) {
            return this.f18747O000000o.get(i).f11134O000000o == this.O00000Oo.get(i2).f11134O000000o;
        }

        public final int O000000o() {
            return this.f18747O000000o.size();
        }

        public final int O00000Oo() {
            return this.O00000Oo.size();
        }

        public final boolean O00000Oo(int i, int i2) {
            return ixe.O000000o(this.f18747O000000o.get(i), this.O00000Oo.get(i2));
        }
    }
}
