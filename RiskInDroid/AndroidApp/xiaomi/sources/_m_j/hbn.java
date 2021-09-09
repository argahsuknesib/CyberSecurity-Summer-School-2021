package _m_j;

import _m_j.hbn;
import _m_j.hjm;
import _m_j.hlr;
import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.flexible_layout.FlexSize;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.operation.OperationAdManager$Companion$getProviderForDeviceList$1;
import com.xiaomi.smarthome.operation.OperationAdManager$Companion$getProviderForDeviceList$2;
import com.xiaomi.smarthome.operation.view.OperationImageView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 +2\u00020\u0001:\u0002+,B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J0\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bH\u0014J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J(\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00062\u000e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#H\u0016J\u0012\u0010%\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016J\u0018\u0010&\u001a\u00020!2\u0006\u0010\u0016\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0006H\u0016J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u0017H\u0016J\u0006\u0010*\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainTopOperationAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "()V", "TAG", "", "column", "", "isCacheValid", "", "mOperationProvider", "Lcom/xiaomi/smarthome/operation/provider/IOperationProvider;", "", "Lcom/xiaomi/smarthome/operation/beans/common/CommonAdOperation;", "getColumn", "getItemCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "isVisibleToUser", "onAnyEditModeChanged", "current", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "payloads", "", "", "onConfigurationChanged", "onCreateViewHolder", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "refresh", "Companion", "SimpleViewHolder", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hbn extends haz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18750O000000o = new O000000o((byte) 0);
    private static boolean O0000Ooo;
    public final hlr<List<hjr>> O00000Oo;
    private final String O0000Oo = "MainTopOperationAdapter";
    public boolean O0000Oo0;
    private int O0000OoO;

    public hbn() {
        hlr<List<hjr>> hlr;
        FlexSize.O000000o o000000o = FlexSize.Companion;
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        this.O0000OoO = FlexSize.O000000o.O00000Oo(appContext) ? 1 : 2;
        hjm.O000000o o000000o2 = hjm.f18999O000000o;
        hfz hfz = hfz.f18889O000000o;
        ArrayList<MainPageDeviceModel> O000000o2 = hfz.O000000o();
        String valueOf = String.valueOf(O000000o2 == null ? null : Integer.valueOf(O000000o2.size()));
        ixe.O00000o(valueOf, "size");
        boolean z = false;
        if (!ftn.O00000oo(ServiceApplication.getAppContext())) {
            hlr = new hls<>();
        } else {
            hlr = new hlu("22", ivb.O000000o(iuf.O000000o("type", OperationAdManager$Companion$getProviderForDeviceList$1.f10504O000000o), iuf.O000000o("deviceNum", new OperationAdManager$Companion$getProviderForDeviceList$2(valueOf))));
        }
        this.O00000Oo = hlr;
        if (O0000Ooo && this.O00000Oo.O000000o() && this.O00000Oo.O00000o0()) {
            z = true;
        }
        this.O0000Oo0 = z;
        if (!O0000Ooo) {
            O0000Ooo = true;
            CommonApplication.getGlobalHandler().post(new Runnable() {
                /* class _m_j.$$Lambda$hbn$pZjAfCF9VmA09RCNR8Gq385RU */

                public final void run() {
                    hbn.O000000o(hbn.this);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainTopOperationAdapter$Companion;", "", "()V", "isWarm", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(hbn hbn) {
        ixe.O00000o(hbn, "this$0");
        if (hbn.O00000Oo.O000000o() && hbn.O00000Oo.O00000o0()) {
            hbn.O0000Oo0 = true;
            hbn.notifyItemInserted(0);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_operation_banner, viewGroup, false);
        ixe.O00000Oo(inflate, "from(parent.context).inflate(R.layout.main_operation_banner, parent, false)");
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
        if (!(!list.isEmpty()) || !ixe.O000000o(list.get(0), (Object) "flex")) {
            super.onBindViewHolder(o000OOo0, i, list);
        } else {
            ((O00000Oo) o000OOo0).itemView.requestLayout();
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(hbn hbn) {
        ixe.O00000o(hbn, "this$0");
        hlr.O000000o.O000000o(hbn.O00000Oo, null, 3);
    }

    public final int O000000o() {
        return this.O0000OoO;
    }

    public final int getItemCount() {
        return this.O0000Oo0 ? 1 : 0;
    }

    public final boolean l_() {
        if (!this.O0000Oo0) {
            return false;
        }
        List O00000Oo2 = this.O00000Oo.O00000Oo();
        return ixe.O000000o(O00000Oo2 == null ? null : Boolean.valueOf(O00000Oo2.isEmpty() ^ true), Boolean.TRUE);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/MainTopOperationAdapter$SimpleViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/MainTopOperationAdapter;Landroid/view/View;)V", "editMaskView", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "kotlin.jvm.PlatformType", "bind", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ hbn f18751O000000o;
        private final EditMaskView O00000Oo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(hbn hbn, View view) {
            super(view);
            ixe.O00000o(hbn, "this$0");
            ixe.O00000o(view, "itemView");
            this.f18751O000000o = hbn;
            this.O00000Oo = (EditMaskView) view.findViewById(R.id.edit_mask);
        }

        public final void O000000o() {
            List O00000Oo2 = this.f18751O000000o.O00000Oo.O00000Oo();
            int i = 0;
            hjr hjr = O00000Oo2 == null ? null : (hjr) iuo.O000000o(O00000Oo2, 0);
            if (hjr == null) {
                this.itemView.setVisibility(8);
                return;
            }
            this.O00000Oo.setShouldMask(this.f18751O000000o.O00000o || this.f18751O000000o.O00000oO || this.f18751O000000o.O00000oo);
            View findViewById = this.itemView.findViewById(R.id.edit_mask);
            if (!this.f18751O000000o.O00000o && !this.f18751O000000o.O00000oO) {
                i = 8;
            }
            findViewById.setVisibility(i);
            View findViewById2 = this.itemView.findViewById(R.id.banner_img);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.banner_img)");
            OperationImageView operationImageView = (OperationImageView) findViewById2;
            hlr<List<hjr>> hlr = this.f18751O000000o.O00000Oo;
            String str = hjr.O00000Oo;
            ixe.O00000Oo(str, "operation.imgUrl");
            hlr.O000000o(str, operationImageView);
            operationImageView.registerOnVisibleToUser(new O000000o(hjr));
            this.itemView.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$hbn$O00000Oo$6JJSB2TXd721sDfWrlPiGGc4q4 */

                public final void onClick(View view) {
                    hbn.O00000Oo.O000000o(hbn.this, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.$$Lambda$hbn$O00000Oo$f6C0amKDZnVawtO04oMMPzKKHaU */

                public final void onClick(View view) {
                    hbn.O00000Oo.O000000o(hjr.this, view);
                }
            });
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/adapter/MainTopOperationAdapter$SimpleViewHolder$bind$1", "Lcom/xiaomi/smarthome/operation/view/OperationImageView$IOnVisible;", "onVisible", "", "view", "Landroid/view/View;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o implements OperationImageView.O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ hjr f18752O000000o;

            O000000o(hjr hjr) {
                this.f18752O000000o = hjr;
            }

            public final void onVisible(View view) {
                ixe.O00000o(view, "view");
                hxr hxr = hxi.O00000oO;
                String str = this.f18752O000000o.O00000o;
                hxr.f958O000000o.O000000o("home_ad_popup", "url", str);
                hxm hxm = hxi.O0000o00;
                String str2 = this.f18752O000000o.O00000o;
                String str3 = this.f18752O000000o.O0000o0;
                String str4 = this.f18752O000000o.O00000o0;
                String str5 = this.f18752O000000o.O0000o0o;
                hxm.f954O000000o.O000000o("home_ad_expose", "link", str2, "asset_id", str3, "asset_name", str4, "exp_id", str5);
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(hbn hbn, View view) {
            ixe.O00000o(hbn, "this$0");
            hbn.O0000Oo0 = false;
            hbn.O00000Oo.O00000o();
            hxi.O00000o.f952O000000o.O000000o("home_add_close_click", new Object[0]);
            hbn.notifyItemRemoved(0);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(hjr hjr, View view) {
            hjo.O000000o(hjr);
            hxk hxk = hxi.O00000o;
            String str = hjr.O00000o;
            String str2 = hjr.O0000o0;
            String str3 = hjr.O00000o0;
            String str4 = hjr.O0000o0o;
            hxk.f952O000000o.O000000o("home_ad_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4);
        }
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        ixe.O00000o(recyclerView, "parent");
        ixe.O00000o(o000OO0o, "state");
        if (j_()) {
            rect.top = gpc.O000000o(10.0f);
        }
        rect.right = gpc.O000000o(10.0f) + ((int) view.getResources().getDimension(R.dimen.main_page_flex_padding));
        rect.left = rect.right;
        rect.bottom = gpc.O000000o(7.0f);
    }

    public final void O000000o(RecyclerView recyclerView) {
        super.O000000o(recyclerView);
        FlexSize.O000000o o000000o = FlexSize.Companion;
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        this.O0000OoO = FlexSize.O000000o.O00000Oo(appContext) ? 1 : 2;
        notifyItemChanged(0, "flex");
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        CommonApplication.getGlobalWorkerHandler().postDelayed(new Runnable() {
            /* class _m_j.$$Lambda$hbn$FXSxNO6vyIReFclqgE0e9VaHk */

            public final void run() {
                hbn.O00000Oo(hbn.this);
            }
        }, 500);
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.O00000Oo.O00000oO();
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(boolean z) {
        super.O00000Oo(z);
        notifyItemChanged(0);
    }
}
