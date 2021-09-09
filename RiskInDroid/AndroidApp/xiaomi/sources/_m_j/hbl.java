package _m_j;

import _m_j.gzq;
import _m_j.hbl;
import android.content.Intent;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.homeroom.AddFavCameraActivity;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.adapter.MainCameraButtonAdapter$ViewHolder$bind$1$1;
import com.xiaomi.smarthome.newui.adapter.MainCameraButtonAdapter$ViewHolder$bind$1$2;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainCameraButtonAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "()V", "addGroup", "Lcom/xiaomi/smarthome/newui/adapter/GroupDelegate;", "value", "", "cameraCount", "setCameraCount", "(I)V", "normalGroup", "getItemCount", "onAnyEditModeChanged", "", "current", "", "onAttachedToRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "payloads", "", "", "onConfigurationChanged", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "p1", "Companion", "ViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbl extends haw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18744O000000o = new O000000o((byte) 0);
    public int O00000Oo = hfz.O00000o();
    public final hbh O0000Oo = new hbh(new int[]{R.id.add_image, R.id.add_common_desc});
    public final hbh O0000Oo0 = new hbh(new int[]{R.id.all_camera_desc, R.id.camera_count, R.id.arrow});

    public hbl() {
        hfz hfz = hfz.f18889O000000o;
    }

    private final void O000000o(int i) {
        hfz hfz = hfz.f18889O000000o;
        hfz.O000000o(i);
        this.O00000Oo = i;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_page_camera_entry_layout, viewGroup, false);
        ixe.O00000Oo(inflate, "item");
        return new O00000Oo(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        ((O00000Oo) o000OOo0).O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.Object, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List<Object> list) {
        ixe.O00000o(o000OOo0, "holder");
        ixe.O00000o(list, "payloads");
        if (list.isEmpty()) {
            super.onBindViewHolder(o000OOo0, i, list);
        } else if (ixe.O000000o(list.get(0), (Object) "flex")) {
            ((O00000Oo) o000OOo0).itemView.requestLayout();
        } else {
            Object obj = list.get(0);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            if (num == null) {
                super.onBindViewHolder(o000OOo0, i, list);
            } else {
                ((O00000Oo) o000OOo0).f18745O000000o.setText(String.valueOf(num));
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainCameraButtonAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/MainCameraButtonAdapter;Landroid/view/View;)V", "cameraCntTv", "Landroid/widget/TextView;", "getCameraCntTv", "()Landroid/widget/TextView;", "editMask", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "getEditMask", "()Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final TextView f18745O000000o;
        final /* synthetic */ hbl O00000Oo;
        private final EditMaskView O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(hbl hbl, View view) {
            super(view);
            ixe.O00000o(hbl, "this$0");
            ixe.O00000o(view, "itemView");
            this.O00000Oo = hbl;
            View findViewById = view.findViewById(R.id.camera_count);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.camera_count)");
            this.f18745O000000o = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.edit_mask);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.edit_mask)");
            this.O00000o0 = (EditMaskView) findViewById2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.transition.Transition.excludeTarget(android.view.View, boolean):android.transition.Transition}
         arg types: [android.view.View, int]
         candidates:
          ClspMth{android.transition.Transition.excludeTarget(int, boolean):android.transition.Transition}
          ClspMth{android.transition.Transition.excludeTarget(java.lang.Class, boolean):android.transition.Transition}
          ClspMth{android.transition.Transition.excludeTarget(java.lang.String, boolean):android.transition.Transition}
          ClspMth{android.transition.Transition.excludeTarget(android.view.View, boolean):android.transition.Transition} */
        public final void O000000o() {
            this.f18745O000000o.setText(String.valueOf(this.O00000Oo.O00000Oo));
            boolean z = true;
            if (Build.VERSION.SDK_INT >= 19) {
                ChangeBounds changeBounds = new ChangeBounds();
                changeBounds.excludeTarget(this.itemView, true);
                TransitionManager.beginDelayedTransition((ViewGroup) this.itemView, changeBounds);
            }
            hbh hbh = this.O00000Oo.O0000Oo0;
            View view = this.itemView;
            ixe.O00000Oo(view, "itemView");
            int i = 8;
            hbh.O000000o(view, !this.O00000Oo.O00000oo ? 0 : 8);
            hbh hbh2 = this.O00000Oo.O0000Oo;
            View view2 = this.itemView;
            ixe.O00000Oo(view2, "itemView");
            if (this.O00000Oo.O00000oo) {
                i = 0;
            }
            hbh2.O000000o(view2, i);
            LogType logType = LogType.CARD;
            StringBuilder sb = new StringBuilder("camera card,isCameraEditMode: ");
            sb.append(this.O00000Oo.O00000oo);
            sb.append(", isNormalVisible: ");
            hbh hbh3 = this.O00000Oo.O0000Oo0;
            View view3 = this.itemView;
            ixe.O00000Oo(view3, "itemView");
            sb.append(hbh3.O000000o(view3) == 0);
            sb.append(" ,isAddVisible ");
            hbh hbh4 = this.O00000Oo.O0000Oo;
            View view4 = this.itemView;
            ixe.O00000Oo(view4, "itemView");
            sb.append(hbh4.O000000o(view4) == 0);
            gsy.O00000Oo(logType, "MainCameraButtonAdapter", sb.toString());
            EditMaskView editMaskView = this.O00000o0;
            if (!this.O00000Oo.O00000oO && !this.O00000Oo.O00000o) {
                z = false;
            }
            editMaskView.setShouldMask(z);
            if (this.O00000Oo.O00000oo) {
                hxi.O00000o0.f957O000000o.O000000o("camera_add_show", new Object[0]);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$hbl$O00000Oo$vq4yBiUSzqfj2oyYyKI_wJeRfEY */

                public final void onClick(View view) {
                    hbl.O00000Oo.O000000o(hbl.this, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(hbl hbl, View view) {
            ixe.O00000o(hbl, "this$0");
            ixe.O00000Oo(view, "it");
            hak.O000000o(view, MainCameraButtonAdapter$ViewHolder$bind$1$1.f10173O000000o);
            if (!hbl.O00000oO && !hbl.O00000o && !hbl.O00000oo) {
                fbs.O000000o(new fbt(view.getContext(), "AllCameraActivity"));
                hxi.O00000o.f952O000000o.O000000o("home_camera_entry", new Object[0]);
                hxk hxk = hxi.O00000o;
                hfx hfx = hfx.f18878O000000o;
                int size = hfx.O000000o(ggb.O00000Oo().O0000Oo0()).size();
                int i = hbl.O00000Oo;
                int size2 = hfy.f18887O000000o.O000000o(ggb.O00000Oo().O0000Oo0()).size();
                hxk.f952O000000o.O000000o("allcamera_click", "added_sence_total_number", Integer.valueOf(size), "camera_total_order", Integer.valueOf(i), "added_favorite_camera", Integer.valueOf(size2));
            } else if (hbl.O00000oo) {
                hxi.O00000o.f952O000000o.O000000o("camera_add_click", new Object[0]);
                view.getContext().startActivity(new Intent(view.getContext(), AddFavCameraActivity.class));
                gzq.O000000o o000000o = gzq.f18638O000000o;
                gzw.O000000o(gzq.O00000oo, MainCameraButtonAdapter$ViewHolder$bind$1$2.f10174O000000o);
            }
        }
    }

    public final int getItemCount() {
        return this.O00000Oo > 1 ? 1 : 0;
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CompositeDisposable compositeDisposable = this.O00000o0;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        compositeDisposable.addAll(Observable.merge(gzq.O00000Oo, new hne("com.smarthome.refresh_list_view", application)).filter($$Lambda$hbl$AvQ3kb_xBjEVTe9283AcnnTI9E.INSTANCE).map($$Lambda$hbl$bgS51rAkApX3B2s26x0PloqGgI.INSTANCE).filter(new Predicate() {
            /* class _m_j.$$Lambda$hbl$j6sdSFysrYS30yVWuVOJi6bEsNY */

            public final boolean test(Object obj) {
                return hbl.O000000o(hbl.this, (Integer) obj);
            }
        }).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(recyclerView) {
            /* class _m_j.$$Lambda$hbl$5Wimz3PGjGKEeFjzcUyVI_0wvHU */
            private final /* synthetic */ RecyclerView f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                hbl.O000000o(hbl.this, this.f$1, (Integer) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return ggb.O00000Oo().O0000OoO.O00000oo && fno.O000000o().O0000o00();
    }

    /* access modifiers changed from: private */
    public static final Integer O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Integer.valueOf(ggb.O00000Oo().O0000oOO(ggb.O00000Oo().O0000OOo()).size());
    }

    /* access modifiers changed from: private */
    public static final boolean O000000o(hbl hbl, Integer num) {
        ixe.O00000o(hbl, "this$0");
        ixe.O00000o(num, "it");
        return num.intValue() != hbl.O00000Oo;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(hbl hbl, RecyclerView recyclerView, Integer num) {
        ixe.O00000o(hbl, "this$0");
        ixe.O00000o(recyclerView, "$recyclerView");
        gsy.O00000Oo(LogType.CARD, "MainCameraButtonAdapter", ixe.O000000o("onAttachedToRecyclerView: count: ", (Object) num));
        ixe.O00000Oo(num, "count");
        if (num.intValue() > 1) {
            if (hbl.O00000Oo <= 1) {
                hbl.O000000o(num.intValue());
                hbl.notifyItemInserted(0);
                hbe.O000000o(recyclerView, gpc.O000000o(recyclerView.getContext(), 20.0f));
                return;
            }
            hbl.O000000o(num.intValue());
            hbl.notifyItemChanged(0, num);
        } else if (hbl.O00000Oo > 1) {
            hbl.O000000o(num.intValue());
            hbl.notifyItemRemoved(0);
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        super.O00000Oo(z);
        notifyItemChanged(0);
    }

    public final void O000000o(RecyclerView recyclerView) {
        notifyItemChanged(0, "flex");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainCameraButtonAdapter$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }
}
