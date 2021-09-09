package com.xiaomi.smarthome.miio.activity.face_privacy;

import _m_j.fm;
import _m_j.fo;
import _m_j.gsy;
import _m_j.gwl;
import _m_j.gwm;
import _m_j.gwn;
import _m_j.gwo;
import _m_j.hzf;
import _m_j.ixe;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.common.widget.SwitchButton;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0002\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\b\u0010\u0016\u001a\u00020\u000fH\u0002R\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent$RenderView;", "()V", "mAdapter", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$InnerAdapter;", "mFacePresent", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePresent;", "mLoadingDialog", "Lcom/xiaomi/smarthome/library/common/dialog/XQProgressDialog;", "mNoDevicesDefault", "Landroid/view/View;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dismissLoadingDialog", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "render", "state", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyState;", "showLoadingDialog", "Companion", "InnerAdapter", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacePrivacyManagerActivity extends BaseActivity implements gwl.O00000Oo {
    public static final O000000o Companion = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f9709O000000o;
    private View O00000Oo;
    private XQProgressDialog O00000o;
    private O00000Oo O00000o0;
    public gwl mFacePresent;

    public final void _$_clearFindViewByIdCache() {
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$Companion;", "", "()V", "TAG", "", "start", "", "context", "Landroid/content/Context;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_privacy_manager);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.activity.face_privacy.$$Lambda$FacePrivacyManagerActivity$86XcuK6hDDHPlEtIv115z6AxKo */

            public final void onClick(View view) {
                FacePrivacyManagerActivity.O000000o(FacePrivacyManagerActivity.this, view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.face_recognition_manager);
        View findViewById = findViewById(R.id.no_item_default);
        ixe.O00000Oo(findViewById, "findViewById(R.id.no_item_default)");
        this.O00000Oo = findViewById;
        View findViewById2 = findViewById(R.id.recycler);
        ixe.O00000Oo(findViewById2, "findViewById(R.id.recycler)");
        this.f9709O000000o = (RecyclerView) findViewById2;
        RecyclerView recyclerView = this.f9709O000000o;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            this.O00000o0 = new O00000Oo(this);
            RecyclerView recyclerView2 = this.f9709O000000o;
            if (recyclerView2 != null) {
                O00000Oo o00000Oo = this.O00000o0;
                if (o00000Oo != null) {
                    recyclerView2.setAdapter(o00000Oo);
                    fm O000000o2 = fo.O000000o(this).O000000o(gwl.class);
                    ixe.O00000Oo(O000000o2, "of(this).get(FacePresent::class.java)");
                    this.mFacePresent = (gwl) O000000o2;
                    gwl gwl = this.mFacePresent;
                    if (gwl != null) {
                        gwl.O000000o(this);
                        gwl gwl2 = this.mFacePresent;
                        if (gwl2 != null) {
                            gwl2.O000000o(gwn.O000000o.f18419O000000o);
                        } else {
                            ixe.O000000o("mFacePresent");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("mFacePresent");
                        throw null;
                    }
                } else {
                    ixe.O000000o("mAdapter");
                    throw null;
                }
            } else {
                ixe.O000000o("mRecyclerView");
                throw null;
            }
        } else {
            ixe.O000000o("mRecyclerView");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FacePrivacyManagerActivity facePrivacyManagerActivity, View view) {
        ixe.O00000o(facePrivacyManagerActivity, "this$0");
        facePrivacyManagerActivity.finish();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, _m_j.gwo]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void render(gwo gwo) {
        String str;
        ixe.O00000o(gwo, "state");
        gsy.O000000o(3, "FacePrivacyManagerActiv", ixe.O000000o("render: ", (Object) gwo));
        int i = 0;
        if (gwo instanceof gwo.O00000o) {
            Context context = this;
            gwo.O00000o o00000o = (gwo.O00000o) gwo;
            ixe.O00000o(context, "context");
            if (o00000o.f18423O000000o != -1) {
                str = context.getString(o00000o.f18423O000000o);
                ixe.O00000Oo(str, "context.getString(msgRes)");
            } else {
                str = o00000o.O00000Oo;
            }
            Toast.makeText(context, str, 0).show();
        } else if (gwo instanceof gwo.O00000o0) {
            if (this.O00000o == null) {
                this.O00000o = new XQProgressDialog(this);
                XQProgressDialog xQProgressDialog = this.O00000o;
                if (xQProgressDialog != null) {
                    xQProgressDialog.setMessage(getString(R.string.mj_loading));
                }
                XQProgressDialog xQProgressDialog2 = this.O00000o;
                if (xQProgressDialog2 != null) {
                    xQProgressDialog2.setCancelable(true);
                }
            }
            XQProgressDialog xQProgressDialog3 = this.O00000o;
            if (xQProgressDialog3 != null) {
                xQProgressDialog3.show();
            }
        } else if (gwo instanceof gwo.O000000o) {
            O000000o();
            gsy.O000000o(6, "FacePrivacyManagerActiv", ((gwo.O000000o) gwo).f18421O000000o.getMessage());
        } else if (gwo instanceof gwo.O00000Oo) {
            O000000o();
            RecyclerView recyclerView = this.f9709O000000o;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
                View view = this.O00000Oo;
                if (view != null) {
                    gwo.O00000Oo o00000Oo = (gwo.O00000Oo) gwo;
                    if (!o00000Oo.f18422O000000o.isEmpty()) {
                        i = 8;
                    }
                    view.setVisibility(i);
                    O00000Oo o00000Oo2 = this.O00000o0;
                    if (o00000Oo2 != null) {
                        List<gwm.O000000o> list = o00000Oo.f18422O000000o;
                        ixe.O00000o(list, "data");
                        o00000Oo2.f9710O000000o.clear();
                        o00000Oo2.f9710O000000o.addAll(list);
                        o00000Oo2.notifyDataSetChanged();
                        return;
                    }
                    ixe.O000000o("mAdapter");
                    throw null;
                }
                ixe.O000000o("mNoDevicesDefault");
                throw null;
            }
            ixe.O000000o("mRecyclerView");
            throw null;
        }
    }

    private final void O000000o() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.miio.activity.face_privacy.$$Lambda$FacePrivacyManagerActivity$jd284wTakzb_NKhsVSnc3T6s0qc */

            public final void run() {
                FacePrivacyManagerActivity.O000000o(FacePrivacyManagerActivity.this);
            }
        }, 200);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FacePrivacyManagerActivity facePrivacyManagerActivity) {
        ixe.O00000o(facePrivacyManagerActivity, "this$0");
        XQProgressDialog xQProgressDialog = facePrivacyManagerActivity.O00000o;
        if (xQProgressDialog != null) {
            xQProgressDialog.dismiss();
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\r\u001a\u00020\tH\u0016J \u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\tH\u0016J\u0014\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$InnerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$InnerAdapter$VH;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity;", "(Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity;)V", "mStatus", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyApi$FaceStatus;", "getItemCount", "", "onBindViewHolder", "", "vh", "pos", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "updateData", "data", "", "VH", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends RecyclerView.O000000o<O000000o> {

        /* renamed from: O000000o  reason: collision with root package name */
        final ArrayList<gwm.O000000o> f9710O000000o = new ArrayList<>();
        final /* synthetic */ FacePrivacyManagerActivity O00000Oo;

        public O00000Oo(FacePrivacyManagerActivity facePrivacyManagerActivity) {
            ixe.O00000o(facePrivacyManagerActivity, "this$0");
            this.O00000Oo = facePrivacyManagerActivity;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            O000000o o000000o = (O000000o) o000OOo0;
            ixe.O00000o(o000000o, "vh");
            gwm.O000000o o000000o2 = this.f9710O000000o.get(i);
            ixe.O00000Oo(o000000o2, "mStatus[pos]");
            o000000o.O000000o(o000000o2);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "viewGroup");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.face_privacy_item, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        public final int getItemCount() {
            return this.f9710O000000o.size();
        }

        @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$InnerAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyManagerActivity$InnerAdapter;Landroid/view/View;)V", "bind", "", "status", "Lcom/xiaomi/smarthome/miio/activity/face_privacy/FacePrivacyApi$FaceStatus;", "smarthome-setting_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f9711O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000Oo o00000Oo, View view) {
                super(view);
                ixe.O00000o(o00000Oo, "this$0");
                ixe.O00000o(view, "itemView");
                this.f9711O000000o = o00000Oo;
            }

            public final void O000000o(gwm.O000000o o000000o) {
                ixe.O00000o(o000000o, "status");
                Device device = o000000o.f18418O000000o;
                Boolean bool = o000000o.O00000Oo;
                ((TextView) this.itemView.findViewById(R.id.title)).setText(device.name);
                SwitchButton switchButton = (SwitchButton) this.itemView.findViewById(R.id.switcher);
                switchButton.setOnTouchEnable(false);
                this.itemView.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: INVOKE  
                      (wrap: android.view.View : 0x002a: IGET  (r2v5 android.view.View) = (r5v0 'this' com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo$O000000o A[THIS]) com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.itemView android.view.View)
                      (wrap: com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo : 0x0032: CONSTRUCTOR  (r4v0 com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo) = 
                      (wrap: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity : 0x002e: IGET  (r3v1 com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity) = 
                      (wrap: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo : 0x002c: IGET  (r3v0 com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo) = (r5v0 'this' com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo$O000000o A[THIS]) com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.O000000o com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo)
                     com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O00000Oo com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity)
                      (r0v1 'device' com.xiaomi.smarthome.device.Device)
                      (r6v1 'bool' java.lang.Boolean)
                      (r1v5 'switchButton' com.xiaomi.smarthome.library.common.widget.SwitchButton)
                     call: com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo.<init>(com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity, com.xiaomi.smarthome.device.Device, java.lang.Boolean, com.xiaomi.smarthome.library.common.widget.SwitchButton):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.view.View.setOnClickListener(android.view.View$OnClickListener):void in method: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.O000000o(_m_j.gwm$O000000o):void, dex: classes5.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: CONSTRUCTOR  (r4v0 com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo) = 
                      (wrap: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity : 0x002e: IGET  (r3v1 com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity) = 
                      (wrap: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo : 0x002c: IGET  (r3v0 com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo) = (r5v0 'this' com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo$O000000o A[THIS]) com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.O000000o com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo)
                     com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O00000Oo com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity)
                      (r0v1 'device' com.xiaomi.smarthome.device.Device)
                      (r6v1 'bool' java.lang.Boolean)
                      (r1v5 'switchButton' com.xiaomi.smarthome.library.common.widget.SwitchButton)
                     call: com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo.<init>(com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity, com.xiaomi.smarthome.device.Device, java.lang.Boolean, com.xiaomi.smarthome.library.common.widget.SwitchButton):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.O000000o(_m_j.gwm$O000000o):void, dex: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 63 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 69 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "status"
                    _m_j.ixe.O00000o(r6, r0)
                    com.xiaomi.smarthome.device.Device r0 = r6.f18418O000000o
                    java.lang.Boolean r6 = r6.O00000Oo
                    android.view.View r1 = r5.itemView
                    r2 = 2132153438(0x7f16145e, float:1.9948995E38)
                    android.view.View r1 = r1.findViewById(r2)
                    android.widget.TextView r1 = (android.widget.TextView) r1
                    java.lang.String r2 = r0.name
                    java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                    r1.setText(r2)
                    android.view.View r1 = r5.itemView
                    r2 = 2132153242(0x7f16139a, float:1.9948598E38)
                    android.view.View r1 = r1.findViewById(r2)
                    com.xiaomi.smarthome.library.common.widget.SwitchButton r1 = (com.xiaomi.smarthome.library.common.widget.SwitchButton) r1
                    r2 = 0
                    r1.setOnTouchEnable(r2)
                    android.view.View r2 = r5.itemView
                    com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity$O00000Oo r3 = r5.f9711O000000o
                    com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity r3 = r3.O00000Oo
                    com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo r4 = new com.xiaomi.smarthome.miio.activity.face_privacy.-$$Lambda$FacePrivacyManagerActivity$O00000Oo$O000000o$TcTas2TGqOEdN9uQkbyr7AszuYo
                    r4.<init>(r3, r0, r6, r1)
                    r2.setOnClickListener(r4)
                    java.lang.String r0 = "isOpen"
                    _m_j.ixe.O00000Oo(r6, r0)
                    boolean r6 = r6.booleanValue()
                    r1.setChecked(r6)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.activity.face_privacy.FacePrivacyManagerActivity.O00000Oo.O000000o.O000000o(_m_j.gwm$O000000o):void");
            }

            /* access modifiers changed from: private */
            public static final void O000000o(FacePrivacyManagerActivity facePrivacyManagerActivity, Device device, Boolean bool, SwitchButton switchButton, View view) {
                ixe.O00000o(facePrivacyManagerActivity, "this$0");
                gwl gwl = facePrivacyManagerActivity.mFacePresent;
                if (gwl != null) {
                    String str = device.did;
                    ixe.O00000Oo(str, "device.did");
                    gwl.O000000o(new gwn.O00000Oo(str, !bool.booleanValue()));
                    switchButton.toggle();
                    hzf.O000000o((CompoundButton) switchButton);
                    return;
                }
                ixe.O000000o("mFacePresent");
                throw null;
            }
        }
    }
}
