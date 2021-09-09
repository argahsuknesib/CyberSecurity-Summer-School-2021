package _m_j;

import _m_j.gzu;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.RoomDropMenu;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006H\u0014J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/DropMenuAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/CardPathDrawableDefaultOffsetAdapter;", "()V", "getItemCount", "", "isLastVisibleInParent", "", "onAttachedToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "onCardEditModeChanged", "current", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "Companion", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class gzu extends haw {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18671O000000o = new O000000o((byte) 0);

    public final int getItemCount() {
        return 1;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_drop_menu_layout, viewGroup, false);
        ixe.O00000Oo(inflate, "from(parent.context).inflate(R.layout.main_drop_menu_layout, parent, false)");
        return new O00000Oo(this, inflate);
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        ((O00000Oo) o000OOo0).O000000o();
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CompositeDisposable compositeDisposable = this.O00000o0;
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        compositeDisposable.add(new hne("action_room_selected", application).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$gzu$MxMwV4kfvoBk3PxLicdH5thSlQ */

            public final void accept(Object obj) {
                gzu.O000000o(gzu.this, (Intent) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(gzu gzu, Intent intent) {
        ixe.O00000o(gzu, "this$0");
        gzu.notifyDataSetChanged();
    }

    public final void O000000o(boolean z) {
        notifyDataSetChanged();
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.O00000o0.clear();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/xiaomi/smarthome/newui/DropMenuAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/DropMenuAdapter;Landroid/view/View;)V", "editMask", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "mArrowDown", "mRoomName", "Landroid/widget/TextView;", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ gzu f18672O000000o;
        private final View O00000Oo;
        private final EditMaskView O00000o;
        private final TextView O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(gzu gzu, View view) {
            super(view);
            ixe.O00000o(gzu, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18672O000000o = gzu;
            View findViewById = view.findViewById(R.id.arrow_down_img);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.arrow_down_img)");
            this.O00000Oo = findViewById;
            View findViewById2 = view.findViewById(R.id.room_name);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.room_name)");
            this.O00000o0 = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.edit_mask);
            ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.edit_mask)");
            this.O00000o = (EditMaskView) findViewById3;
            this.O00000Oo.setContentDescription(view.getContext().getString(R.string.navi_close_accessibility_desc));
        }

        public final void O000000o() {
            PageBean O00000Oo2 = gzv.O000000o().O00000Oo();
            gfz gfz = gfz.f17670O000000o;
            ixe.O000000o(O00000Oo2);
            int size = gfz.O000000o(O00000Oo2).size();
            TextView textView = this.O00000o0;
            ixh ixh = ixh.f1644O000000o;
            String format = String.format("%s (%s)", Arrays.copyOf(new Object[]{O00000Oo2.f10340O000000o, Integer.valueOf(size)}, 2));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            textView.setText(format);
            this.O00000o.setShouldMask(this.f18672O000000o.O00000oO);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$gzu$O00000Oo$Bn0P8bNsUkUwt_lhqzfjiCP63fs */

                public final void onClick(View view) {
                    gzu.O00000Oo.O000000o(gzu.O00000Oo.this, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000Oo o00000Oo, View view) {
            ixe.O00000o(o00000Oo, "this$0");
            ixe.O00000o(view, "v");
            gzv O000000o2 = gzv.O000000o();
            PageBean O00000Oo2 = O000000o2.O00000Oo();
            List<PageBean> list = O000000o2.O00000o0;
            List<PageBean.O00000Oo> list2 = O000000o2.O00000Oo;
            if (O00000Oo2 != null) {
                ixe.O00000Oo(list, "currentHomePageBeans");
                if (!list.isEmpty()) {
                    Context context = o00000Oo.itemView.getContext();
                    if (context != null) {
                        new RoomDropMenu((FragmentActivity) context, o00000Oo.itemView, list2, O00000Oo2).e_();
                        hxi.O00000o.f952O000000o.O000000o("home_room_dropdown", new Object[0]);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/newui/DropMenuAdapter$Companion;", "", "()V", "ACTION_ROOM_SELECTED", "", "EXTRA_ROOM_SELECTED_ID", "TAG", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }
}
