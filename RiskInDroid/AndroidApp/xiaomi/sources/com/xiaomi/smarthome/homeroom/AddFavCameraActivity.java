package com.xiaomi.smarthome.homeroom;

import _m_j.ggb;
import _m_j.go;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hao;
import _m_j.hfy;
import _m_j.hte;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.ixe;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.operation.js_sdk.share.LoadingDialogHelper;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "checkedModeAdapter", "Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity$CheckedModeAdapter;", "confirmBtn", "Landroid/view/View;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "loadingDialogHelper", "Lcom/xiaomi/smarthome/operation/js_sdk/share/LoadingDialogHelper;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "titleTv", "Landroid/widget/TextView;", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "CheckedModeAdapter", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AddFavCameraActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f8811O000000o;
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
        this.f8811O000000o = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.f8811O000000o;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new AddFavCameraActivity$initView$1$1(recyclerView.getContext()));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavCameraActivity$doCKzY4jBeQ_LwG6gUt_JsbTW3k */

                public final void onClick(View view) {
                    AddFavCameraActivity.O000000o(AddFavCameraActivity.this, view);
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
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavCameraActivity$yD9LdtCLEAz3CUEcBynDmBxc6xQ */

                    public final void onClick(View view) {
                        AddFavCameraActivity.O00000Oo(AddFavCameraActivity.this, view);
                    }
                });
                View view2 = this.confirmBtn;
                if (view2 != null) {
                    view2.setEnabled(false);
                    TextView textView = this.titleTv;
                    if (textView != null) {
                        textView.setText((int) R.string.title_edit_choose_freq_camera);
                        gzl gzl = new gzl();
                        this.O00000Oo = new O000000o(this);
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            gzl.O000000o(o000000o);
                            gzl.O00000Oo(new hao());
                            RecyclerView recyclerView2 = this.f8811O000000o;
                            if (recyclerView2 != null) {
                                recyclerView2.setAdapter(gzl);
                                hfy hfy = hfy.f18887O000000o;
                                String O0000OOo = ggb.O00000Oo().O0000OOo();
                                ixe.O00000Oo(O0000OOo, "getInstance().currentHomeId");
                                List<Device> O000000o2 = hfy.O000000o(O0000OOo);
                                O000000o o000000o2 = this.O00000Oo;
                                if (o000000o2 != null) {
                                    ixe.O00000o(O000000o2, "cards");
                                    o000000o2.f8812O000000o.clear();
                                    o000000o2.f8812O000000o.addAll(O000000o2);
                                    o000000o2.notifyDataSetChanged();
                                    return;
                                }
                                ixe.O000000o("checkedModeAdapter");
                                throw null;
                            }
                            ixe.O000000o("recycler");
                            throw null;
                        }
                        ixe.O000000o("checkedModeAdapter");
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
    public static final void O000000o(AddFavCameraActivity addFavCameraActivity, View view) {
        ixe.O00000o(addFavCameraActivity, "this$0");
        addFavCameraActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AddFavCameraActivity addFavCameraActivity, View view) {
        List list;
        ixe.O00000o(addFavCameraActivity, "this$0");
        O000000o o000000o = addFavCameraActivity.O00000Oo;
        if (o000000o != null) {
            if (o000000o.O00000Oo.isEmpty()) {
                list = EmptyList.f15376O000000o;
            } else {
                Collection arrayList = new ArrayList();
                for (Object next : o000000o.f8812O000000o) {
                    if (o000000o.O00000Oo.contains(((Device) next).did)) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
            }
            LoadingDialogHelper loadingDialogHelper = addFavCameraActivity.O00000o;
            if (loadingDialogHelper != null) {
                loadingDialogHelper.O000000o();
            }
            hfy hfy = hfy.f18887O000000o;
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            Iterable<Device> iterable = list;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (Device device : iterable) {
                arrayList2.add(device.did);
            }
            addFavCameraActivity.O00000o0.add(hfy.O000000o(O0000Oo0, (List<String>) ((List) arrayList2), false).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavCameraActivity$hqkCehjcPKAXv0UuzcWbNU0Gnqk */

                public final void accept(Object obj) {
                    AddFavCameraActivity.O000000o(AddFavCameraActivity.this, (Boolean) obj);
                }
            }, new Consumer() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavCameraActivity$zqo_iI7oRd8ksteAsI_exKGQarg */

                public final void accept(Object obj) {
                    AddFavCameraActivity.O000000o(AddFavCameraActivity.this, (Throwable) obj);
                }
            }));
            return;
        }
        ixe.O000000o("checkedModeAdapter");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavCameraActivity addFavCameraActivity, Boolean bool) {
        ixe.O00000o(addFavCameraActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper = addFavCameraActivity.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        hte.O000000o(addFavCameraActivity.getContext(), (int) R.string.action_success);
        addFavCameraActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavCameraActivity addFavCameraActivity, Throwable th) {
        ixe.O00000o(addFavCameraActivity, "this$0");
        LoadingDialogHelper loadingDialogHelper = addFavCameraActivity.O00000o;
        if (loadingDialogHelper != null) {
            loadingDialogHelper.O00000Oo();
        }
        hte.O000000o(addFavCameraActivity.getContext(), (int) R.string.action_fail);
        addFavCameraActivity.finish();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH\u0016J\u0014\u0010\u0019\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity$CheckedModeAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity;)V", "checkedItems", "", "", "renderData", "", "Lcom/xiaomi/smarthome/device/Device;", "selectItems", "", "getSelectItems", "()Ljava/util/List;", "getColumn", "", "getItemCount", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "conatiner", "Landroid/view/ViewGroup;", "p1", "render", "cards", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        List<Device> f8812O000000o = new ArrayList();
        public final Set<String> O00000Oo = new LinkedHashSet();
        final /* synthetic */ AddFavCameraActivity O00000o0;

        public final int O000000o() {
            return 1;
        }

        public O000000o(AddFavCameraActivity addFavCameraActivity) {
            ixe.O00000o(addFavCameraActivity, "this$0");
            this.O00000o0 = addFavCameraActivity;
        }

        public final int getItemCount() {
            return this.f8812O000000o.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "conatiner");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.main_freq_camera_select_item, viewGroup, false);
            ixe.O00000Oo(inflate, "from(conatiner.context).inflate(R.layout.main_freq_camera_select_item, conatiner, false)");
            return new C0072O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            ((C0072O000000o) o000OOo0).O000000o(this.f8812O000000o.get(i));
        }

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity$CheckedModeAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/AddFavCameraActivity$CheckedModeAdapter;Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "nameTv", "Landroid/widget/TextView;", "roomNameTv", "bind", "", "device", "Lcom/xiaomi/smarthome/device/Device;", "refreshTitle", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o  reason: collision with other inner class name */
        public final class C0072O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O000000o f8813O000000o;
            private final TextView O00000Oo;
            private final SimpleDraweeView O00000o;
            private final TextView O00000o0;
            private final CheckBox O00000oO;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0072O000000o(O000000o o000000o, View view) {
                super(view);
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(view, "itemView");
                this.f8813O000000o = o000000o;
                View findViewById = view.findViewById(R.id.name);
                ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.name)");
                this.O00000Oo = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.room_name);
                ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.room_name)");
                this.O00000o0 = (TextView) findViewById2;
                View findViewById3 = view.findViewById(R.id.icon);
                ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.icon)");
                this.O00000o = (SimpleDraweeView) findViewById3;
                View findViewById4 = view.findViewById(R.id.check_box);
                ixe.O00000Oo(findViewById4, "itemView.findViewById(R.id.check_box)");
                this.O00000oO = (CheckBox) findViewById4;
            }

            public final void O000000o(Device device) {
                CharSequence charSequence;
                ixe.O00000o(device, "device");
                String O0000oOO = DeviceFactory.O0000oOO(device.model);
                if (O0000oOO == null) {
                    O0000oOO = "";
                }
                if (O0000oOO.length() == 0) {
                    DeviceFactory.O00000Oo(device.model, this.O00000o);
                } else {
                    DeviceFactory.O000000o(O0000oOO, this.O00000o);
                }
                this.O00000Oo.setText(device.name);
                TextView textView = this.O00000o0;
                String O0000o0O = ggb.O00000Oo().O0000o0O(device.did);
                if (O0000o0O != null) {
                    charSequence = O0000o0O;
                }
                textView.setText(charSequence);
                this.O00000oO.setChecked(this.f8813O000000o.O00000Oo.contains(device.did));
                this.itemView.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0063: INVOKE  
                      (wrap: android.view.View : 0x005a: IGET  (r0v7 android.view.View) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.O000000o.itemView android.view.View)
                      (wrap: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8 : 0x0060: CONSTRUCTOR  (r2v9 com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8) = 
                      (wrap: com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o : 0x005c: IGET  (r1v5 com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.O000000o.O000000o com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o)
                      (r5v0 'device' com.xiaomi.smarthome.device.Device)
                      (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o A[THIS])
                     call: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8.<init>(com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o, com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.O000000o.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0060: CONSTRUCTOR  (r2v9 com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8) = 
                      (wrap: com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o : 0x005c: IGET  (r1v5 com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o) = (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o A[THIS]) com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.O000000o.O000000o com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o)
                      (r5v0 'device' com.xiaomi.smarthome.device.Device)
                      (r4v0 'this' com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o A[THIS])
                     call: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8.<init>(com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o, com.xiaomi.smarthome.device.Device, com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o$O000000o):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.O000000o.O000000o(com.xiaomi.smarthome.device.Device):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "device"
                    _m_j.ixe.O00000o(r5, r0)
                    java.lang.String r0 = r5.model
                    java.lang.String r0 = com.xiaomi.smarthome.device.DeviceFactory.O0000oOO(r0)
                    java.lang.String r1 = ""
                    if (r0 != 0) goto L_0x0010
                    r0 = r1
                L_0x0010:
                    r2 = r0
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    int r2 = r2.length()
                    if (r2 != 0) goto L_0x001b
                    r2 = 1
                    goto L_0x001c
                L_0x001b:
                    r2 = 0
                L_0x001c:
                    if (r2 == 0) goto L_0x0026
                    java.lang.String r0 = r5.model
                    com.facebook.drawee.view.SimpleDraweeView r2 = r4.O00000o
                    com.xiaomi.smarthome.device.DeviceFactory.O00000Oo(r0, r2)
                    goto L_0x002b
                L_0x0026:
                    com.facebook.drawee.view.SimpleDraweeView r2 = r4.O00000o
                    com.xiaomi.smarthome.device.DeviceFactory.O000000o(r0, r2)
                L_0x002b:
                    android.widget.TextView r0 = r4.O00000Oo
                    java.lang.String r2 = r5.name
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    r0.setText(r2)
                    android.widget.TextView r0 = r4.O00000o0
                    _m_j.ggb r2 = _m_j.ggb.O00000Oo()
                    java.lang.String r3 = r5.did
                    java.lang.String r2 = r2.O0000o0O(r3)
                    if (r2 != 0) goto L_0x0045
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    goto L_0x0048
                L_0x0045:
                    r1 = r2
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                L_0x0048:
                    r0.setText(r1)
                    android.widget.CheckBox r0 = r4.O00000oO
                    com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o r1 = r4.f8813O000000o
                    java.util.Set<java.lang.String> r1 = r1.O00000Oo
                    java.lang.String r2 = r5.did
                    boolean r1 = r1.contains(r2)
                    r0.setChecked(r1)
                    android.view.View r0 = r4.itemView
                    com.xiaomi.smarthome.homeroom.AddFavCameraActivity$O000000o r1 = r4.f8813O000000o
                    com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8 r2 = new com.xiaomi.smarthome.homeroom.-$$Lambda$AddFavCameraActivity$O000000o$O000000o$_x8nUgeWM1NSidq49hI40xM3lN8
                    r2.<init>(r1, r5, r4)
                    r0.setOnClickListener(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.homeroom.AddFavCameraActivity.O000000o.C0072O000000o.O000000o(com.xiaomi.smarthome.device.Device):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(O000000o o000000o, Device device, C0072O000000o o000000o2, View view) {
                String str;
                ixe.O00000o(o000000o, "this$0");
                ixe.O00000o(device, "$device");
                ixe.O00000o(o000000o2, "this$1");
                if (o000000o.O00000Oo.contains(device.did)) {
                    o000000o.O00000Oo.remove(device.did);
                } else {
                    Set<String> set = o000000o.O00000Oo;
                    String str2 = device.did;
                    ixe.O00000Oo(str2, "device.did");
                    set.add(str2);
                }
                CheckBox checkBox = o000000o2.O00000oO;
                checkBox.setChecked(!checkBox.isChecked());
                int size = o000000o2.f8813O000000o.O00000Oo.size();
                boolean z = false;
                if (size == 0) {
                    str = o000000o2.f8813O000000o.O00000o0.getResources().getString(R.string.title_edit_choose_freq_camera);
                } else {
                    str = o000000o2.f8813O000000o.O00000o0.getResources().getQuantityString(R.plurals.edit_choosed_freq_camera, size, Integer.valueOf(size));
                }
                ixe.O00000Oo(str, "if (checkedSize == 0) {\n                    resources.getString(R.string.title_edit_choose_freq_camera)\n                } else {\n                    resources.getQuantityString(R.plurals.edit_choosed_freq_camera, checkedSize, checkedSize)\n                }");
                TextView textView = o000000o2.f8813O000000o.O00000o0.titleTv;
                if (textView != null) {
                    textView.setText(str);
                    View view2 = o000000o2.f8813O000000o.O00000o0.confirmBtn;
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
