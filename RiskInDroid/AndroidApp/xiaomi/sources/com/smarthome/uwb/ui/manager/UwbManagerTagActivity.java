package com.smarthome.uwb.ui.manager;

import _m_j.ddw;
import _m_j.ddx;
import _m_j.fa;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fh;
import _m_j.fm;
import _m_j.fno;
import _m_j.fo;
import _m_j.ggb;
import _m_j.go;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gty;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hxi;
import _m_j.hzp;
import _m_j.hzr;
import _m_j.itz;
import _m_j.iua;
import _m_j.iue;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.ixe;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.smarthome.uwb.ui.manager.UwbManagerEditPage;
import com.smarthome.uwb.ui.widget.CustomPopWindow;
import com.smarthome.uwb.ui.widget.NameAndStateTextView;
import com.smarthome.uwb.ui.widget.OfflinePage;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.UwbBaseActivity;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0004=>?@B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020(H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020\u0005H\u0002J\"\u0010,\u001a\u00020(2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u001f2\b\u0010/\u001a\u0004\u0018\u000100H\u0014J\u0012\u00101\u001a\u00020(2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020(H\u0016J\b\u00105\u001a\u00020(H\u0014J\u0018\u00106\u001a\u00020(2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u0005H\u0016J\u0010\u0010:\u001a\u00020(2\u0006\u0010;\u001a\u00020<H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity;", "Lcom/xiaomi/smarthome/uwb/ui/UwbBaseActivity;", "Lcom/smarthome/uwb/ui/manager/UwbManagerEditPage$IExitCallBack;", "()V", "canEnterEditMode", "", "getCanEnterEditMode", "()Z", "checkedItems", "", "", "controller", "Lcom/smarthome/uwb/ui/manager/ManagerUwbTagController;", "editMenus", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "getEditMenus", "()Ljava/util/List;", "editMenus$delegate", "Lkotlin/Lazy;", "editPage", "Lcom/smarthome/uwb/ui/manager/UwbManagerEditPage;", "isFirstEnter", "leftBtn", "Landroid/widget/ImageView;", "moreBtn", "ptrFrameLayout", "Lcom/xiaomi/smarthome/library/common/widget/DevicePtrFrameLayout;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "refreshCount", "", "selectItems", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "getSelectItems", "state", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel;", "titleTv", "Landroid/widget/TextView;", "enterEditPage", "", "initEventListener", "initView", "loginIfNeeded", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onExit", "onResume", "onSelectButtonClick", "view", "Landroid/view/View;", "isSelectAll", "refreshEditPage", "context", "Landroid/content/Context;", "Companion", "ItemAdapter", "PlaceHolderAdapter", "TitleAdapter", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class UwbManagerTagActivity extends UwbBaseActivity implements UwbManagerEditPage.O000000o {
    public static final O000000o Companion = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f5741O000000o;
    private TextView O00000Oo;
    private ImageView O00000o;
    private ImageView O00000o0;
    private DevicePtrFrameLayout O00000oO;
    private UwbManagerEditPage O00000oo;
    private boolean O0000O0o = true;
    private int O0000OOo;
    private final itz O0000Oo0 = iua.O000000o(new UwbManagerTagActivity$editMenus$2(this));
    public final Set<String> checkedItems = new LinkedHashSet();
    public ManagerUwbTagController controller;
    public ddw state;

    public final void _$_clearFindViewByIdCache() {
    }

    public final boolean getCanEnterEditMode() {
        return true;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$Companion;", "", "()V", "ARGS_CHANGE_ASSOCIATE_DID", "", "ARGS_FROM_UWB_MANAGER", "REQUEST_CODE", "", "TAG", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.List<_m_j.ddw$O000000o>} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final List<ddw.O000000o> getSelectItems() {
        if (this.checkedItems.isEmpty()) {
            return EmptyList.f15376O000000o;
        }
        ddw ddw = this.state;
        List<ddw.O000000o> list = null;
        if (ddw != null) {
            Iterable<Pair> iterable = (List) ddw.O00000Oo.getValue();
            if (iterable != null) {
                Collection arrayList = new ArrayList();
                for (Pair pair : iterable) {
                    iuo.O000000o(arrayList, (List) pair.second);
                }
                Collection arrayList2 = new ArrayList();
                for (Object next : (List) arrayList) {
                    if (this.checkedItems.contains(((ddw.O000000o) next).f14528O000000o)) {
                        arrayList2.add(next);
                    }
                }
                list = arrayList2;
            }
            if (list == null) {
                return EmptyList.f15376O000000o;
            }
            return list;
        }
        ixe.O000000o("state");
        throw null;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.uwb_manager_layout);
        FragmentActivity fragmentActivity = this;
        fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(ddw.class);
        ixe.O00000Oo(O000000o2, "of(this).get(ManagerUwbViewModel::class.java)");
        this.state = (ddw) O000000o2;
        this.controller = new ManagerUwbTagController();
        ManagerUwbTagController managerUwbTagController = this.controller;
        if (managerUwbTagController != null) {
            ixe.O00000o(fragmentActivity, "activity");
            fragmentActivity.getLifecycle().O000000o(managerUwbTagController);
            fm O000000o3 = fo.O000000o(fragmentActivity).O000000o(ddw.class);
            ixe.O00000Oo(O000000o3, "of(activity).get(ManagerUwbViewModel::class.java)");
            managerUwbTagController.O00000Oo = (ddw) O000000o3;
            View findViewById = findViewById(R.id.module_a_3_return_title);
            ixe.O00000Oo(findViewById, "findViewById(R.id.module_a_3_return_title)");
            this.O00000Oo = (TextView) findViewById;
            TextView textView = this.O00000Oo;
            if (textView != null) {
                textView.setText(getString(R.string.mj_ubw_title_uwb));
                View findViewById2 = findViewById(R.id.module_a_3_return_btn);
                ixe.O00000Oo(findViewById2, "findViewById(R.id.module_a_3_return_btn)");
                this.O00000o0 = (ImageView) findViewById2;
                ImageView imageView = this.O00000o0;
                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.smarthome.uwb.ui.manager.$$Lambda$UwbManagerTagActivity$cCoqa7Gr_79zpU0pR558F1SUNKg */

                        public final void onClick(View view) {
                            UwbManagerTagActivity.O000000o(UwbManagerTagActivity.this, view);
                        }
                    });
                    ((TextView) findViewById(R.id.start_uwb_bind)).setOnClickListener(new View.OnClickListener() {
                        /* class com.smarthome.uwb.ui.manager.$$Lambda$UwbManagerTagActivity$tICEdtef5ollLxqGr56qNmg9mh4 */

                        public final void onClick(View view) {
                            UwbManagerTagActivity.O00000Oo(UwbManagerTagActivity.this, view);
                        }
                    });
                    View findViewById3 = findViewById(R.id.module_a_3_right_iv_setting_btn);
                    ixe.O00000Oo(findViewById3, "findViewById(R.id.module_a_3_right_iv_setting_btn)");
                    this.O00000o = (ImageView) findViewById3;
                    ImageView imageView2 = this.O00000o;
                    if (imageView2 != null) {
                        imageView2.setImageResource(R.drawable.std_tittlebar_main_device_more);
                        ImageView imageView3 = this.O00000o;
                        if (imageView3 != null) {
                            imageView3.setOnClickListener(new View.OnClickListener() {
                                /* class com.smarthome.uwb.ui.manager.$$Lambda$UwbManagerTagActivity$njF1aUoXANLla_gXbq_OFbIJQU */

                                public final void onClick(View view) {
                                    UwbManagerTagActivity.O00000o0(UwbManagerTagActivity.this, view);
                                }
                            });
                            View findViewById4 = findViewById(R.id.recycler);
                            ixe.O00000Oo(findViewById4, "findViewById(R.id.recycler)");
                            this.f5741O000000o = (RecyclerView) findViewById4;
                            RecyclerView recyclerView = this.f5741O000000o;
                            if (recyclerView != null) {
                                recyclerView.setNestedScrollingEnabled(true);
                                RecyclerView recyclerView2 = this.f5741O000000o;
                                if (recyclerView2 != null) {
                                    recyclerView2.setLayoutManager(new UwbManagerTagActivity$initView$4(getContext()));
                                    RecyclerView recyclerView3 = this.f5741O000000o;
                                    if (recyclerView3 != null) {
                                        go goVar = new go();
                                        goVar.O0000o00 = false;
                                        iuh iuh = iuh.f1631O000000o;
                                        recyclerView3.setItemAnimator(goVar);
                                        gzl gzl = new gzl();
                                        gzl.O00000Oo(new O00000o0(this));
                                        RecyclerView recyclerView4 = this.f5741O000000o;
                                        if (recyclerView4 != null) {
                                            recyclerView4.setAdapter(gzl);
                                            View findViewById5 = findViewById(R.id.pull_down_refresh);
                                            ixe.O00000Oo(findViewById5, "findViewById<DevicePtrFrameLayout>(R.id.pull_down_refresh)");
                                            this.O00000oO = (DevicePtrFrameLayout) findViewById5;
                                            DevicePtrFrameLayout devicePtrFrameLayout = this.O00000oO;
                                            if (devicePtrFrameLayout != null) {
                                                devicePtrFrameLayout.setPtrHandler(new O0000OOo(this));
                                                ddw ddw = this.state;
                                                if (ddw != null) {
                                                    fa faVar = this;
                                                    ddw.f14527O000000o.observe(faVar, new fh() {
                                                        /* class com.smarthome.uwb.ui.manager.$$Lambda$UwbManagerTagActivity$JBUJuOjVZSdGiu_xa3wVyXImYq4 */

                                                        public final void onChanged(Object obj) {
                                                            UwbManagerTagActivity.O000000o(UwbManagerTagActivity.this, (Boolean) obj);
                                                        }
                                                    });
                                                    ddw ddw2 = this.state;
                                                    if (ddw2 != null) {
                                                        ddw2.O00000Oo.observe(faVar, new fh() {
                                                            /* class com.smarthome.uwb.ui.manager.$$Lambda$UwbManagerTagActivity$EfQTsfklopBvZJnVLv5xYKIhiFo */

                                                            public final void onChanged(Object obj) {
                                                                UwbManagerTagActivity.O000000o(UwbManagerTagActivity.this, (List) obj);
                                                            }
                                                        });
                                                        if (!O000000o()) {
                                                            List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
                                                            ixe.O00000Oo(list, "getInstance().allHome");
                                                            Collection arrayList = new ArrayList();
                                                            for (Object next : list) {
                                                                if (((Home) next).isOwner()) {
                                                                    arrayList.add(next);
                                                                }
                                                            }
                                                            Iterable<Home> iterable = (List) arrayList;
                                                            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
                                                            for (Home id : iterable) {
                                                                arrayList2.add(id.getId());
                                                            }
                                                            List list2 = (List) arrayList2;
                                                            ManagerUwbTagController managerUwbTagController2 = this.controller;
                                                            if (managerUwbTagController2 != null) {
                                                                managerUwbTagController2.O000000o(list2);
                                                            } else {
                                                                ixe.O000000o("controller");
                                                                throw null;
                                                            }
                                                        }
                                                        new hzr().O000000o("9876", new O0000Oo0());
                                                        UwbSdk.setBindDeviceListener(null);
                                                        return;
                                                    }
                                                    ixe.O000000o("state");
                                                    throw null;
                                                }
                                                ixe.O000000o("state");
                                                throw null;
                                            }
                                            ixe.O000000o("ptrFrameLayout");
                                            throw null;
                                        }
                                        ixe.O000000o("recycler");
                                        throw null;
                                    }
                                    ixe.O000000o("recycler");
                                    throw null;
                                }
                                ixe.O000000o("recycler");
                                throw null;
                            }
                            ixe.O000000o("recycler");
                            throw null;
                        }
                        ixe.O000000o("moreBtn");
                        throw null;
                    }
                    ixe.O000000o("moreBtn");
                    throw null;
                }
                ixe.O000000o("leftBtn");
                throw null;
            }
            ixe.O000000o("titleTv");
            throw null;
        }
        ixe.O000000o("controller");
        throw null;
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/smarthome/uwb/ui/manager/UwbManagerTagActivity$onCreate$1", "Lcom/xiaomi/smarthome/uwb_mijia/bind/UwbBleDeviceFinder$BleDeviceFinderCallback;", "onFound", "", "bleDevice", "Lcom/xiaomi/smarthome/device/BleDevice;", "onTimeout", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo0 implements hzr.O000000o {
        public final void O000000o() {
        }

        public final void O000000o(BleDevice bleDevice) {
        }

        O0000Oo0() {
        }
    }

    public final void enterEditPage() {
        ddw ddw = this.state;
        if (ddw != null) {
            ddw.f14527O000000o.postValue(Boolean.TRUE);
            if (this.O00000oo == null) {
                String string = getString(R.string.mj_uwb_title_edit_choose_uwb_devices);
                ixe.O00000Oo(string, "getString(R.string.mj_uwb_title_edit_choose_uwb_devices)");
                this.O00000oo = new UwbManagerEditPage(this, string, this, (List) this.O0000Oo0.O000000o());
            }
            hxi.O0000o00.f954O000000o.O000000o("uwb_edit_page_show", new Object[0]);
            UwbManagerEditPage uwbManagerEditPage = this.O00000oo;
            if (uwbManagerEditPage != null) {
                uwbManagerEditPage.e_();
                return;
            }
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(UwbManagerTagActivity uwbManagerTagActivity, View view) {
        ixe.O00000o(uwbManagerTagActivity, "this$0");
        uwbManagerTagActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(UwbManagerTagActivity uwbManagerTagActivity, View view) {
        ixe.O00000o(uwbManagerTagActivity, "this$0");
        try {
            Result.O000000o o000000o = Result.f15374O000000o;
            Intent intent = new Intent("com.miui.smarthomeplus.uwb_entry_activity");
            intent.addCategory("android.intent.category.DEFAULT");
            uwbManagerTagActivity.startActivity(intent);
            hxi.O00000o.f952O000000o.O000000o("uwb_manager_tag_btn_add", new Object[0]);
            Result.O00000o0(iuh.f1631O000000o);
        } catch (Throwable th) {
            Result.O000000o o000000o2 = Result.f15374O000000o;
            Result.O00000o0(iue.O000000o(th));
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(UwbManagerTagActivity uwbManagerTagActivity, View view) {
        ixe.O00000o(uwbManagerTagActivity, "this$0");
        hxi.O00000o.f952O000000o.O000000o("uwb_manager_tag_btn_more", new Object[0]);
        String string = uwbManagerTagActivity.getString(R.string.edit);
        ixe.O00000Oo(string, "getString(R.string.edit)");
        String string2 = uwbManagerTagActivity.getString(R.string.uwb_permission_group);
        ixe.O00000Oo(string2, "getString(R.string.uwb_permission_group)");
        List O000000o2 = iuo.O000000o((Object[]) new CustomPopWindow.O00000o0[]{new CustomPopWindow.O00000o0("0", string, new UwbManagerTagActivity$initView$3$menus$1(uwbManagerTagActivity)), new CustomPopWindow.O00000o0("1", string2, new UwbManagerTagActivity$initView$3$menus$2(uwbManagerTagActivity))});
        ixe.O00000Oo(view, "it");
        new CustomPopWindow(uwbManagerTagActivity, view, O000000o2, new O0000O0o(uwbManagerTagActivity)).e_();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/smarthome/uwb/ui/manager/UwbManagerTagActivity$initView$3$1", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$ClickProxy;", "onClick", "", "item", "Lcom/smarthome/uwb/ui/widget/CustomPopWindow$Item;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o implements CustomPopWindow.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ UwbManagerTagActivity f5748O000000o;

        O0000O0o(UwbManagerTagActivity uwbManagerTagActivity) {
            this.f5748O000000o = uwbManagerTagActivity;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final void O000000o(CustomPopWindow.O00000o0 o00000o0) {
            ixe.O00000o(o00000o0, "item");
            if (ixe.O000000o((Object) o00000o0.f5755O000000o, (Object) "0")) {
                hxi.O00000o.f952O000000o.O000000o("uwb_manager_edit_btn_click", new Object[0]);
                this.f5748O000000o.enterEditPage();
                return;
            }
            hxi.O00000o.f952O000000o.O000000o("uwb_manager_permit_btn_click", new Object[0]);
            ManagerUwbTagController managerUwbTagController = this.f5748O000000o.controller;
            if (managerUwbTagController != null) {
                Activity activity = this.f5748O000000o;
                ixe.O00000o(activity, "context");
                if (!managerUwbTagController.O00000o0) {
                    ddx ddx = ddx.f14529O000000o;
                    ddx.O000000o(activity);
                    return;
                }
                return;
            }
            ixe.O000000o("controller");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/smarthome/uwb/ui/manager/UwbManagerTagActivity$initView$6", "Lin/srain/cube/views/ptr/PtrHandler;", "checkCanDoRefresh", "", "p0", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "p1", "Landroid/view/View;", "p2", "onRefreshBegin", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo implements PtrHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ UwbManagerTagActivity f5749O000000o;

        O0000OOo(UwbManagerTagActivity uwbManagerTagActivity) {
            this.f5749O000000o = uwbManagerTagActivity;
        }

        public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
            ddw ddw = this.f5749O000000o.state;
            if (ddw != null) {
                return !ixe.O000000o(ddw.f14527O000000o.getValue(), Boolean.TRUE);
            }
            ixe.O000000o("state");
            throw null;
        }

        public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            ManagerUwbTagController managerUwbTagController = this.f5749O000000o.controller;
            if (managerUwbTagController != null) {
                managerUwbTagController.O000000o();
            } else {
                ixe.O000000o("controller");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(UwbManagerTagActivity uwbManagerTagActivity, Boolean bool) {
        ixe.O00000o(uwbManagerTagActivity, "this$0");
        if (bool != null) {
            if (!bool.booleanValue()) {
                UwbManagerEditPage uwbManagerEditPage = uwbManagerTagActivity.O00000oo;
                if (uwbManagerEditPage != null) {
                    uwbManagerEditPage.O00000Oo();
                }
                uwbManagerTagActivity.O00000oo = null;
                uwbManagerTagActivity.checkedItems.clear();
            }
            RecyclerView recyclerView = uwbManagerTagActivity.f5741O000000o;
            if (recyclerView != null) {
                RecyclerView.O000000o adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            ixe.O000000o("recycler");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(UwbManagerTagActivity uwbManagerTagActivity, List list) {
        String rawName;
        ixe.O00000o(uwbManagerTagActivity, "this$0");
        uwbManagerTagActivity.O0000OOo++;
        StringBuilder sb = new StringBuilder("initEventListener observe : refresh ");
        sb.append(uwbManagerTagActivity.O0000OOo);
        sb.append(" times, result == null: ");
        sb.append(list == null);
        sb.append('}');
        UwbLogUtil.d("UwbManagerTagActivity", sb.toString());
        DevicePtrFrameLayout devicePtrFrameLayout = uwbManagerTagActivity.O00000oO;
        if (devicePtrFrameLayout != null) {
            devicePtrFrameLayout.refreshComplete();
            if (list != null && !list.isEmpty()) {
                gzl gzl = new gzl();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    List list2 = (List) pair.second;
                    Home O00000o2 = ggb.O00000Oo().O00000o((String) pair.first);
                    String str = "";
                    if (!(O00000o2 == null || (rawName = O00000o2.getRawName()) == null)) {
                        str = rawName;
                    }
                    gzl.O000000o(new O00000o(str));
                    gzl.O000000o(new O00000Oo(uwbManagerTagActivity, list2));
                    gzl.O00000Oo(new O00000o0(uwbManagerTagActivity));
                }
                RecyclerView recyclerView = uwbManagerTagActivity.f5741O000000o;
                if (recyclerView != null) {
                    recyclerView.setAdapter(gzl);
                    ImageView imageView = uwbManagerTagActivity.O00000o;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    } else {
                        ixe.O000000o("moreBtn");
                        throw null;
                    }
                } else {
                    ixe.O000000o("recycler");
                    throw null;
                }
            } else if (uwbManagerTagActivity.O0000OOo == 1) {
                ManagerUwbTagController managerUwbTagController = uwbManagerTagActivity.controller;
                if (managerUwbTagController != null) {
                    managerUwbTagController.O000000o();
                } else {
                    ixe.O000000o("controller");
                    throw null;
                }
            } else {
                gzl gzl2 = new gzl();
                gzl2.O00000Oo(new O00000o0(uwbManagerTagActivity));
                RecyclerView recyclerView2 = uwbManagerTagActivity.f5741O000000o;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(gzl2);
                    ImageView imageView2 = uwbManagerTagActivity.O00000o;
                    if (imageView2 != null) {
                        imageView2.setVisibility(4);
                    } else {
                        ixe.O000000o("moreBtn");
                        throw null;
                    }
                } else {
                    ixe.O000000o("recycler");
                    throw null;
                }
            }
        } else {
            ixe.O000000o("ptrFrameLayout");
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$TitleAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "homeName", "", "(Ljava/lang/String;)V", "getHomeName", "()Ljava/lang/String;", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000o extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final String f5744O000000o;

        public final int getItemCount() {
            return 1;
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
        }

        public O00000o(String str) {
            ixe.O00000o(str, "homeName");
            this.f5744O000000o = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.bind_uwb_home_list_title, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$TitleAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$TitleAdapter;Landroid/view/View;)V", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000o f5745O000000o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000o o00000o, View view) {
                super(view);
                ixe.O00000o(o00000o, "this$0");
                ixe.O00000o(view, "itemView");
                this.f5745O000000o = o00000o;
                ((TextView) view).setText(this.f5745O000000o.f5744O000000o);
            }
        }

        public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            rect.left = gpc.O000000o(view.getContext(), 27.0f);
            rect.top = gpc.O000000o(view.getContext(), 24.0f);
            rect.bottom = gpc.O000000o(view.getContext(), 4.0f);
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u001bB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J4\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0018\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\tH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$ItemAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "infos", "", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "(Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity;Ljava/util/List;)V", "getInfos", "()Ljava/util/List;", "getItemCount", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onBindViewHolder", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "Landroid/view/ViewGroup;", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo extends gzm {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ UwbManagerTagActivity f5742O000000o;
        private final List<ddw.O000000o> O00000Oo;

        public O00000Oo(UwbManagerTagActivity uwbManagerTagActivity, List<ddw.O000000o> list) {
            ixe.O00000o(uwbManagerTagActivity, "this$0");
            ixe.O00000o(list, "infos");
            this.f5742O000000o = uwbManagerTagActivity;
            this.O00000Oo = list;
        }

        public final int getItemCount() {
            return this.O00000Oo.size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.uwb_manager_item, viewGroup, false);
            ixe.O00000Oo(inflate, "item");
            return new O000000o(this, inflate);
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "vh");
            ((O000000o) o000OOo0).O000000o(this.O00000Oo.get(i));
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u000e0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$ItemAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$ItemAdapter;Landroid/view/View;)V", "changeAssTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "checkBox", "Landroid/widget/CheckBox;", "devNameTv", "iconIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "roomNameTv", "Lcom/smarthome/uwb/ui/widget/NameAndStateTextView;", "tagNameTv", "bind", "", "info", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public final class O000000o extends RecyclerView.O000OOo0 {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O00000Oo f5743O000000o;
            private final SimpleDraweeView O00000Oo;
            private final TextView O00000o;
            private final NameAndStateTextView O00000o0;
            private final NameAndStateTextView O00000oO;
            private final TextView O00000oo;
            private final CheckBox O0000O0o;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000000o(O00000Oo o00000Oo, View view) {
                super(view);
                ixe.O00000o(o00000Oo, "this$0");
                ixe.O00000o(view, "itemView");
                this.f5743O000000o = o00000Oo;
                this.O00000Oo = (SimpleDraweeView) view.findViewById(R.id.icon);
                this.O00000o0 = (NameAndStateTextView) view.findViewById(R.id.tag_name);
                this.O00000o = (TextView) view.findViewById(R.id.device_name);
                this.O00000oO = (NameAndStateTextView) view.findViewById(R.id.room_name);
                this.O00000oo = (TextView) view.findViewById(R.id.change_bind_device);
                this.O0000O0o = (CheckBox) view.findViewById(R.id.check_box);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:56:0x016a, code lost:
                if (_m_j.ixe.O000000o(r6.f14527O000000o.getValue(), java.lang.Boolean.TRUE) == false) goto L_0x0172;
             */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f7  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x00fa  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0140  */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01eb  */
            public final void O000000o(ddw.O000000o o000000o) {
                CharSequence charSequence;
                String str;
                String str2;
                NameAndStateTextView nameAndStateTextView;
                ddw ddw;
                ixe.O00000o(o000000o, "info");
                ddw ddw2 = this.f5743O000000o.f5742O000000o.state;
                if (ddw2 != null) {
                    boolean O000000o2 = ixe.O000000o(ddw2.f14527O000000o.getValue(), Boolean.TRUE);
                    boolean z = true;
                    int i = 0;
                    if (o000000o.O00000o) {
                        this.O00000Oo.setActualImageResource(R.drawable.uwb_hid_device);
                    } else {
                        String O0000oOO = DeviceFactory.O0000oOO(o000000o.O0000OOo);
                        if (O0000oOO == null) {
                            O0000oOO = "";
                        }
                        if (O0000oOO.length() == 0) {
                            DeviceFactory.O00000Oo(o000000o.O0000OOo, this.O00000Oo);
                        } else {
                            DeviceFactory.O000000o(O0000oOO, this.O00000Oo);
                        }
                    }
                    this.O00000o0.setNameAndState(o000000o.O00000Oo, !o000000o.O0000Oo ? this.itemView.getResources().getString(R.string.offline_device) : null);
                    TextView textView = this.O00000o;
                    if (o000000o.O00000o) {
                        charSequence = this.f5743O000000o.f5742O000000o.getString(R.string.device_group_title_others);
                    } else {
                        charSequence = o000000o.O00000oO ? this.f5743O000000o.f5742O000000o.getString(R.string.uwb_tmp_no_device) : o000000o.O00000oo;
                    }
                    textView.setText(charSequence);
                    if (o000000o.O00000o) {
                        hxi.O0000o00.f954O000000o.O000000o("uwb_bind_view_tv", new Object[0]);
                    }
                    if (o000000o.O00000o) {
                        nameAndStateTextView = this.O00000oO;
                        str2 = this.f5743O000000o.f5742O000000o.getString(R.string.room_default);
                    } else {
                        if (o000000o.O00000oO) {
                            nameAndStateTextView = this.O00000oO;
                            str2 = this.f5743O000000o.f5742O000000o.getString(R.string.tmp_removed);
                            str = this.f5743O000000o.f5742O000000o.getString(R.string.uwb_bind_device_removed);
                        } else {
                            nameAndStateTextView = this.O00000oO;
                            str2 = o000000o.O0000O0o;
                            if (!o000000o.O0000OoO) {
                                str = this.itemView.getResources().getString(R.string.offline_device);
                            }
                        }
                        nameAndStateTextView.setNameAndState(str2, str);
                        this.O00000oo.setAlpha(!o000000o.O0000Oo ? 1.0f : 0.4f);
                        if (!o000000o.O00000o || o000000o.O0000OoO) {
                            this.O00000Oo.setAlpha(1.0f);
                            this.O00000o.setAlpha(1.0f);
                            this.O00000oO.setAlpha(1.0f);
                        } else {
                            this.O00000Oo.setAlpha(0.4f);
                            this.O00000o.setAlpha(0.4f);
                            this.O00000oO.setAlpha(0.4f);
                        }
                        this.O00000oo.setOnClickListener(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0133: INVOKE  
                              (wrap: android.widget.TextView : 0x0128: IGET  (r3v9 android.widget.TextView) = (r9v0 'this' com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo$O000000o A[THIS]) com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O00000oo android.widget.TextView)
                              (wrap: com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI : 0x0130: CONSTRUCTOR  (r7v4 com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI) = 
                              (r10v0 'o000000o' _m_j.ddw$O000000o)
                              (wrap: com.smarthome.uwb.ui.manager.UwbManagerTagActivity : 0x012c: IGET  (r6v7 com.smarthome.uwb.ui.manager.UwbManagerTagActivity) = 
                              (wrap: com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo : 0x012a: IGET  (r6v6 com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo) = (r9v0 'this' com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo$O000000o A[THIS]) com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O000000o com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo)
                             com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o com.smarthome.uwb.ui.manager.UwbManagerTagActivity)
                             call: com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI.<init>(_m_j.ddw$O000000o, com.smarthome.uwb.ui.manager.UwbManagerTagActivity):void type: CONSTRUCTOR)
                             type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O000000o(_m_j.ddw$O000000o):void, dex: classes4.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0130: CONSTRUCTOR  (r7v4 com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI) = 
                              (r10v0 'o000000o' _m_j.ddw$O000000o)
                              (wrap: com.smarthome.uwb.ui.manager.UwbManagerTagActivity : 0x012c: IGET  (r6v7 com.smarthome.uwb.ui.manager.UwbManagerTagActivity) = 
                              (wrap: com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo : 0x012a: IGET  (r6v6 com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo) = (r9v0 'this' com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo$O000000o A[THIS]) com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O000000o com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo)
                             com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o com.smarthome.uwb.ui.manager.UwbManagerTagActivity)
                             call: com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI.<init>(_m_j.ddw$O000000o, com.smarthome.uwb.ui.manager.UwbManagerTagActivity):void type: CONSTRUCTOR in method: com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O000000o(_m_j.ddw$O000000o):void, dex: classes4.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 73 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 79 more
                            */
                        /* JADX WARNING: Code restructure failed: missing block: B:56:0x016a, code lost:
                            if (_m_j.ixe.O000000o(r6.f14527O000000o.getValue(), java.lang.Boolean.TRUE) == false) goto L_0x0172;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:41:0x00f7  */
                        /* JADX WARNING: Removed duplicated region for block: B:42:0x00fa  */
                        /* JADX WARNING: Removed duplicated region for block: B:51:0x0140  */
                        /* JADX WARNING: Removed duplicated region for block: B:79:0x01eb  */
                        /*
                            this = this;
                            java.lang.String r0 = "info"
                            _m_j.ixe.O00000o(r10, r0)
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r0 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r0 = r0.f5742O000000o
                            _m_j.ddw r0 = r0.state
                            java.lang.String r1 = "state"
                            r2 = 0
                            if (r0 == 0) goto L_0x01ef
                            _m_j.fg<java.lang.Boolean> r0 = r0.f14527O000000o
                            java.lang.Object r0 = r0.getValue()
                            java.lang.Boolean r3 = java.lang.Boolean.TRUE
                            boolean r0 = _m_j.ixe.O000000o(r0, r3)
                            boolean r3 = r10.O00000o
                            r4 = 1
                            r5 = 0
                            if (r3 == 0) goto L_0x002b
                            com.facebook.drawee.view.SimpleDraweeView r3 = r9.O00000Oo
                            r6 = 2132087741(0x7f1513bd, float:1.9815746E38)
                            r3.setActualImageResource(r6)
                            goto L_0x0050
                        L_0x002b:
                            java.lang.String r3 = r10.O0000OOo
                            java.lang.String r3 = com.xiaomi.smarthome.device.DeviceFactory.O0000oOO(r3)
                            if (r3 != 0) goto L_0x0035
                            java.lang.String r3 = ""
                        L_0x0035:
                            r6 = r3
                            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                            int r6 = r6.length()
                            if (r6 != 0) goto L_0x0040
                            r6 = 1
                            goto L_0x0041
                        L_0x0040:
                            r6 = 0
                        L_0x0041:
                            if (r6 == 0) goto L_0x004b
                            java.lang.String r3 = r10.O0000OOo
                            com.facebook.drawee.view.SimpleDraweeView r6 = r9.O00000Oo
                            com.xiaomi.smarthome.device.DeviceFactory.O00000Oo(r3, r6)
                            goto L_0x0050
                        L_0x004b:
                            com.facebook.drawee.view.SimpleDraweeView r6 = r9.O00000Oo
                            com.xiaomi.smarthome.device.DeviceFactory.O000000o(r3, r6)
                        L_0x0050:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000o0
                            java.lang.String r6 = r10.O00000Oo
                            boolean r7 = r10.O0000Oo
                            r8 = 2132676512(0x7f1e0fa0, float:2.1009915E38)
                            if (r7 != 0) goto L_0x0066
                            android.view.View r7 = r9.itemView
                            android.content.res.Resources r7 = r7.getResources()
                            java.lang.String r7 = r7.getString(r8)
                            goto L_0x0067
                        L_0x0066:
                            r7 = r2
                        L_0x0067:
                            r3.setNameAndState(r6, r7)
                            android.widget.TextView r3 = r9.O00000o
                            boolean r6 = r10.O00000o
                            if (r6 == 0) goto L_0x007e
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            r7 = 2132674100(0x7f1e0634, float:2.1005023E38)
                            java.lang.String r6 = r6.getString(r7)
                            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                            goto L_0x0094
                        L_0x007e:
                            boolean r6 = r10.O00000oO
                            if (r6 == 0) goto L_0x0090
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            r7 = 2132678886(0x7f1e18e6, float:2.101473E38)
                            java.lang.String r6 = r6.getString(r7)
                            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                            goto L_0x0094
                        L_0x0090:
                            java.lang.String r6 = r10.O00000oo
                            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                        L_0x0094:
                            r3.setText(r6)
                            boolean r3 = r10.O00000o
                            if (r3 == 0) goto L_0x00a6
                            _m_j.hxm r3 = _m_j.hxi.O0000o00
                            _m_j.hyg r3 = r3.f954O000000o
                            java.lang.Object[] r6 = new java.lang.Object[r5]
                            java.lang.String r7 = "uwb_bind_view_tv"
                            r3.O000000o(r7, r6)
                        L_0x00a6:
                            boolean r3 = r10.O00000o
                            if (r3 == 0) goto L_0x00b8
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000oO
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            r7 = 2132677231(0x7f1e126f, float:2.1011374E38)
                            java.lang.String r6 = r6.getString(r7)
                            goto L_0x00e8
                        L_0x00b8:
                            boolean r3 = r10.O00000oO
                            if (r3 == 0) goto L_0x00d5
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000oO
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            r7 = 2132678550(0x7f1e1796, float:2.1014049E38)
                            java.lang.String r6 = r6.getString(r7)
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r7 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r7 = r7.f5742O000000o
                            r8 = 2132678858(0x7f1e18ca, float:2.1014674E38)
                            java.lang.String r7 = r7.getString(r8)
                            goto L_0x00e9
                        L_0x00d5:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000oO
                            java.lang.String r6 = r10.O0000O0o
                            boolean r7 = r10.O0000OoO
                            if (r7 != 0) goto L_0x00e8
                            android.view.View r7 = r9.itemView
                            android.content.res.Resources r7 = r7.getResources()
                            java.lang.String r7 = r7.getString(r8)
                            goto L_0x00e9
                        L_0x00e8:
                            r7 = r2
                        L_0x00e9:
                            r3.setNameAndState(r6, r7)
                            android.widget.TextView r3 = r9.O00000oo
                            boolean r6 = r10.O0000Oo
                            r7 = 1065353216(0x3f800000, float:1.0)
                            r8 = 1053609165(0x3ecccccd, float:0.4)
                            if (r6 == 0) goto L_0x00fa
                            r6 = 1065353216(0x3f800000, float:1.0)
                            goto L_0x00fd
                        L_0x00fa:
                            r6 = 1053609165(0x3ecccccd, float:0.4)
                        L_0x00fd:
                            r3.setAlpha(r6)
                            boolean r3 = r10.O00000o
                            if (r3 != 0) goto L_0x0119
                            boolean r3 = r10.O0000OoO
                            if (r3 == 0) goto L_0x0109
                            goto L_0x0119
                        L_0x0109:
                            com.facebook.drawee.view.SimpleDraweeView r3 = r9.O00000Oo
                            r3.setAlpha(r8)
                            android.widget.TextView r3 = r9.O00000o
                            r3.setAlpha(r8)
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000oO
                            r3.setAlpha(r8)
                            goto L_0x0128
                        L_0x0119:
                            com.facebook.drawee.view.SimpleDraweeView r3 = r9.O00000Oo
                            r3.setAlpha(r7)
                            android.widget.TextView r3 = r9.O00000o
                            r3.setAlpha(r7)
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r3 = r9.O00000oO
                            r3.setAlpha(r7)
                        L_0x0128:
                            android.widget.TextView r3 = r9.O00000oo
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI r7 = new com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$BcMufOTLq1UZsFey4b9Z4UsYIeI
                            r7.<init>(r10, r6)
                            r3.setOnClickListener(r7)
                            android.widget.TextView r3 = r9.O00000oo
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            _m_j.ddw r6 = r6.state
                            if (r6 == 0) goto L_0x01eb
                            _m_j.fg<java.lang.Boolean> r6 = r6.f14527O000000o
                            java.lang.Object r6 = r6.getValue()
                            java.lang.Boolean r7 = java.lang.Boolean.TRUE
                            boolean r6 = _m_j.ixe.O000000o(r6, r7)
                            r6 = r6 ^ r4
                            r3.setEnabled(r6)
                            android.widget.TextView r3 = r9.O00000oo
                            boolean r6 = r10.O0000Oo
                            if (r6 == 0) goto L_0x0171
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r6 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r6 = r6.f5742O000000o
                            _m_j.ddw r6 = r6.state
                            if (r6 == 0) goto L_0x016d
                            _m_j.fg<java.lang.Boolean> r1 = r6.f14527O000000o
                            java.lang.Object r1 = r1.getValue()
                            java.lang.Boolean r6 = java.lang.Boolean.TRUE
                            boolean r1 = _m_j.ixe.O000000o(r1, r6)
                            if (r1 != 0) goto L_0x0171
                            goto L_0x0172
                        L_0x016d:
                            _m_j.ixe.O000000o(r1)
                            throw r2
                        L_0x0171:
                            r4 = 0
                        L_0x0172:
                            r3.setClickable(r4)
                            android.widget.CheckBox r1 = r9.O0000O0o
                            if (r0 == 0) goto L_0x017a
                            goto L_0x017c
                        L_0x017a:
                            r5 = 8
                        L_0x017c:
                            r1.setVisibility(r5)
                            android.widget.CheckBox r1 = r9.O0000O0o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r3 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r3 = r3.f5742O000000o
                            java.util.Set<java.lang.String> r3 = r3.checkedItems
                            java.lang.String r4 = r10.f14528O000000o
                            boolean r3 = r3.contains(r4)
                            r1.setChecked(r3)
                            boolean r1 = r10.O0000Oo
                            if (r1 != 0) goto L_0x01a6
                            if (r0 == 0) goto L_0x0197
                            goto L_0x01a6
                        L_0x0197:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r1 = r9.O00000o0
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r3 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r3 = r3.f5742O000000o
                            com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$GGMTl5-p5JFnuoL57ITxatK1g7Q r4 = new com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$GGMTl5-p5JFnuoL57ITxatK1g7Q
                            r4.<init>(r3, r10)
                            r1.setOnClickListener(r4)
                            goto L_0x01ab
                        L_0x01a6:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r1 = r9.O00000o0
                            r1.setOnClickListener(r2)
                        L_0x01ab:
                            boolean r1 = r10.O00000o
                            if (r1 != 0) goto L_0x01c9
                            boolean r1 = r10.O0000OoO
                            if (r1 != 0) goto L_0x01c9
                            if (r0 != 0) goto L_0x01c9
                            boolean r1 = r10.O00000oO
                            if (r1 == 0) goto L_0x01ba
                            goto L_0x01c9
                        L_0x01ba:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r1 = r9.O00000oO
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r2 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r2 = r2.f5742O000000o
                            com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$Viv57pmN3KeYQfM4XXOYiA9DOrA r3 = new com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$Viv57pmN3KeYQfM4XXOYiA9DOrA
                            r3.<init>(r10, r2)
                            r1.setOnClickListener(r3)
                            goto L_0x01ce
                        L_0x01c9:
                            com.smarthome.uwb.ui.widget.NameAndStateTextView r1 = r9.O00000oO
                            r1.setOnClickListener(r2)
                        L_0x01ce:
                            android.view.View r1 = r9.itemView
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r2 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r2 = r2.f5742O000000o
                            com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$aaMbov5CSqvy8ZrLrVhF_IcGRC8 r3 = new com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$aaMbov5CSqvy8ZrLrVhF_IcGRC8
                            r3.<init>(r0, r2, r10, r9)
                            r1.setOnClickListener(r3)
                            android.view.View r0 = r9.itemView
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity$O00000Oo r1 = r9.f5743O000000o
                            com.smarthome.uwb.ui.manager.UwbManagerTagActivity r1 = r1.f5742O000000o
                            com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$3L7Jt2XowjTOleOjlsz26ub8OG4 r2 = new com.smarthome.uwb.ui.manager.-$$Lambda$UwbManagerTagActivity$O00000Oo$O000000o$3L7Jt2XowjTOleOjlsz26ub8OG4
                            r2.<init>(r1, r10)
                            r0.setOnLongClickListener(r2)
                            return
                        L_0x01eb:
                            _m_j.ixe.O000000o(r1)
                            throw r2
                        L_0x01ef:
                            _m_j.ixe.O000000o(r1)
                            throw r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.smarthome.uwb.ui.manager.UwbManagerTagActivity.O00000Oo.O000000o.O000000o(_m_j.ddw$O000000o):void");
                    }

                    /* access modifiers changed from: private */
                    public static final void O000000o(UwbManagerTagActivity uwbManagerTagActivity, ddw.O000000o o000000o, View view) {
                        ixe.O00000o(uwbManagerTagActivity, "this$0");
                        ixe.O00000o(o000000o, "$info");
                        ManagerUwbTagController managerUwbTagController = uwbManagerTagActivity.controller;
                        if (managerUwbTagController != null) {
                            Context context = uwbManagerTagActivity.getContext();
                            ixe.O00000Oo(context, "context");
                            managerUwbTagController.O000000o(context, o000000o.O00000Oo, o000000o.O0000Oo0);
                            return;
                        }
                        ixe.O000000o("controller");
                        throw null;
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
                     arg types: [java.lang.String, java.lang.String]
                     candidates:
                      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
                      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
                      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
                      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
                    /* access modifiers changed from: private */
                    public static final void O00000Oo(ddw.O000000o o000000o, UwbManagerTagActivity uwbManagerTagActivity, View view) {
                        ixe.O00000o(o000000o, "$info");
                        ixe.O00000o(uwbManagerTagActivity, "this$0");
                        Device O000000o2 = fno.O000000o().O000000o(o000000o.O00000o0);
                        if (O000000o2 == null) {
                            UwbLogUtil.d("UwbManagerTagActivity", ixe.O000000o("failed show device offline page with ", (Object) o000000o.O00000o0));
                            return;
                        }
                        ManagerUwbTagController managerUwbTagController = uwbManagerTagActivity.controller;
                        if (managerUwbTagController != null) {
                            FragmentActivity fragmentActivity = uwbManagerTagActivity;
                            ixe.O00000o(fragmentActivity, "activity");
                            ixe.O00000o(O000000o2, "device");
                            if (!managerUwbTagController.O00000o0) {
                                new OfflinePage(fragmentActivity, O000000o2).e_();
                                return;
                            }
                            return;
                        }
                        ixe.O000000o("controller");
                        throw null;
                    }

                    /* access modifiers changed from: private */
                    public static final void O000000o(boolean z, UwbManagerTagActivity uwbManagerTagActivity, ddw.O000000o o000000o, O000000o o000000o2, View view) {
                        ixe.O00000o(uwbManagerTagActivity, "this$0");
                        ixe.O00000o(o000000o, "$info");
                        ixe.O00000o(o000000o2, "this$1");
                        if (z) {
                            if (uwbManagerTagActivity.checkedItems.contains(o000000o.f14528O000000o)) {
                                uwbManagerTagActivity.checkedItems.remove(o000000o.f14528O000000o);
                            } else {
                                uwbManagerTagActivity.checkedItems.add(o000000o.f14528O000000o);
                            }
                            o000000o2.O0000O0o.setChecked(uwbManagerTagActivity.checkedItems.contains(o000000o.f14528O000000o));
                            Context context = o000000o2.itemView.getContext();
                            ixe.O00000Oo(context, "itemView.context");
                            uwbManagerTagActivity.refreshEditPage(context);
                        }
                    }

                    /* access modifiers changed from: private */
                    public static final boolean O00000Oo(UwbManagerTagActivity uwbManagerTagActivity, ddw.O000000o o000000o, View view) {
                        ixe.O00000o(uwbManagerTagActivity, "this$0");
                        ixe.O00000o(o000000o, "$info");
                        if (!uwbManagerTagActivity.getCanEnterEditMode()) {
                            return true;
                        }
                        ddw ddw = uwbManagerTagActivity.state;
                        if (ddw == null) {
                            ixe.O000000o("state");
                            throw null;
                        } else if (ixe.O000000o(ddw.f14527O000000o.getValue(), Boolean.TRUE)) {
                            return true;
                        } else {
                            uwbManagerTagActivity.checkedItems.add(o000000o.f14528O000000o);
                            uwbManagerTagActivity.enterEditPage();
                            Context context = view.getContext();
                            ixe.O00000Oo(context, "it.context");
                            uwbManagerTagActivity.refreshEditPage(context);
                            return true;
                        }
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt
                     arg types: [java.lang.String, int]
                     candidates:
                      _m_j.fbt.O000000o(java.lang.String, java.lang.Object):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.Class, java.lang.String):T
                      _m_j.fbt.O000000o(java.lang.String, int):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Bundle):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, android.os.Parcelable):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.io.Serializable):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.CharSequence):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.util.ArrayList<? extends android.os.Parcelable>):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, java.lang.String[]):_m_j.fbt
                      _m_j.fbt.O000000o(java.lang.String, boolean):_m_j.fbt */
                    /* access modifiers changed from: private */
                    public static final void O000000o(ddw.O000000o o000000o, UwbManagerTagActivity uwbManagerTagActivity, View view) {
                        ixe.O00000o(o000000o, "$info");
                        ixe.O00000o(uwbManagerTagActivity, "this$0");
                        if (!o000000o.O00000o) {
                            fbs.O000000o(new fbt(uwbManagerTagActivity.getContext(), "BindUwbTagDeviceActivity").O000000o("args_tag_id", o000000o.f14528O000000o).O000000o("args_home_id", o000000o.O0000Ooo).O000000o("args_associate_id", o000000o.O00000o0).O000000o("args_from_uwb_manager", true).O000000o(1001));
                        } else if (uwbManagerTagActivity.controller != null) {
                            ManagerUwbTagController.O000000o(uwbManagerTagActivity);
                        } else {
                            ixe.O000000o("controller");
                            throw null;
                        }
                    }
                }

                public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                    ixe.O00000o(rect, "outRect");
                    ixe.O00000o(view, "view");
                    rect.left = gpc.O000000o(view.getContext(), 12.0f);
                    rect.right = gpc.O000000o(view.getContext(), 12.0f);
                    rect.top = gpc.O000000o(view.getContext(), 12.0f);
                }
            }

            @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0016¨\u0006\u000f"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$PlaceHolderAdapter;", "Lcom/xiaomi/smarthome/multi_item/IAdapter;", "(Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity;)V", "getItemCount", "", "onBindViewHolder", "", "vh", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "pos", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "position", "VH", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            final class O00000o0 extends gzm {

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ UwbManagerTagActivity f5746O000000o;

                public final int getItemCount() {
                    return 1;
                }

                public O00000o0(UwbManagerTagActivity uwbManagerTagActivity) {
                    ixe.O00000o(uwbManagerTagActivity, "this$0");
                    this.f5746O000000o = uwbManagerTagActivity;
                }

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
                 arg types: [?, android.view.ViewGroup, int]
                 candidates:
                  ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
                  ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
                public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
                    ixe.O00000o(viewGroup, "parent");
                    View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.uwb_bind_manager_no_item, viewGroup, false);
                    ixe.O00000Oo(inflate, "item");
                    return new O000000o(this, inflate);
                }

                public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
                    ixe.O00000o(o000OOo0, "vh");
                    ((O000000o) o000OOo0).O000000o();
                }

                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$PlaceHolderAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/smarthome/uwb/ui/manager/UwbManagerTagActivity$PlaceHolderAdapter;Landroid/view/View;)V", "tvBindIntro", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "bind", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
                public final class O000000o extends RecyclerView.O000OOo0 {

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ O00000o0 f5747O000000o;
                    private final TextView O00000Oo;

                    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                    public O000000o(O00000o0 o00000o0, View view) {
                        super(view);
                        ixe.O00000o(o00000o0, "this$0");
                        ixe.O00000o(view, "itemView");
                        this.f5747O000000o = o00000o0;
                        this.O00000Oo = (TextView) view.findViewById(R.id.tv_intro_desc);
                    }

                    public final void O000000o() {
                        UnderlineSpan underlineSpan = new UnderlineSpan();
                        SpannableString spannableString = new SpannableString(this.f5747O000000o.f5746O000000o.getString(R.string.uwb_user_guide));
                        spannableString.setSpan(underlineSpan, 0, spannableString.length(), 18);
                        this.O00000Oo.setText(spannableString);
                        this.O00000Oo.setHighlightColor(0);
                        this.O00000Oo.setTextColor(this.f5747O000000o.f5746O000000o.getResources().getColor(R.color.mj_color_green_normal));
                        this.O00000Oo.setOnClickListener($$Lambda$UwbManagerTagActivity$O00000o0$O000000o$jrkTBBMyWXVnSjWRxXcI_EIRM.INSTANCE);
                    }

                    /* access modifiers changed from: private */
                    public static final void O000000o(View view) {
                        hxi.O0000o00.f954O000000o.O000000o("uwb_user_guide_page_all", new Object[0]);
                        fbt fbt = new fbt(CommonApplication.getAppContext(), "OperationCommonWebViewActivity");
                        hzp hzp = hzp.f1018O000000o;
                        fbt.O000000o("url", hzp.O000000o("https://home.mi.com/views/article.html?articleId=905022182000000001"));
                        fbt.O00000Oo(268435456);
                        fbs.O000000o(fbt);
                    }
                }
            }

            public final void onActivityResult(int i, int i2, Intent intent) {
                String str;
                super.onActivityResult(i, i2, intent);
                if (i != 1001) {
                    return;
                }
                if (i2 == -1) {
                    ManagerUwbTagController managerUwbTagController = this.controller;
                    if (managerUwbTagController != null) {
                        managerUwbTagController.O000000o();
                    } else {
                        ixe.O000000o("controller");
                        throw null;
                    }
                } else {
                    if (intent == null) {
                        str = null;
                    } else {
                        str = intent.getStringExtra("args_change_associate_did");
                    }
                    Device O000000o2 = fno.O000000o().O000000o(str);
                    if (O000000o2 != null) {
                        ManagerUwbTagController managerUwbTagController2 = this.controller;
                        if (managerUwbTagController2 != null) {
                            Context context = getContext();
                            ixe.O00000Oo(context, "context");
                            String str2 = O000000o2.name;
                            ixe.O00000Oo(str2, "device.name");
                            managerUwbTagController2.O000000o(context, str2);
                            gqg.O00000Oo((int) R.string.uwb_associcate_failed_toast);
                            return;
                        }
                        ixe.O000000o("controller");
                        throw null;
                    }
                }
            }

            public final void onResume() {
                if (!O000000o() && !this.O0000O0o) {
                    ManagerUwbTagController managerUwbTagController = this.controller;
                    if (managerUwbTagController != null) {
                        managerUwbTagController.O000000o();
                    } else {
                        ixe.O000000o("controller");
                        throw null;
                    }
                }
                this.O0000O0o = false;
                super.onResume();
            }

            private static boolean O000000o() {
                if (ServiceApplication.getStateNotifier().f15923O000000o == 4 || ServiceApplication.getStateNotifier().f15923O000000o == 2) {
                    return false;
                }
                gty.O000000o().startLogin(UwbSdk.getApplication(), 7, null);
                return true;
            }

            public final void onExit() {
                ddw ddw = this.state;
                if (ddw != null) {
                    ddw.f14527O000000o.postValue(Boolean.FALSE);
                } else {
                    ixe.O000000o("state");
                    throw null;
                }
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.util.List} */
            /* JADX WARNING: Multi-variable type inference failed */
            public final void onSelectButtonClick(View view, boolean z) {
                List list;
                ixe.O00000o(view, "view");
                ddw ddw = this.state;
                if (ddw != null) {
                    Iterable<Pair> iterable = (List) ddw.O00000Oo.getValue();
                    if (iterable == null) {
                        list = null;
                    } else {
                        Collection arrayList = new ArrayList();
                        for (Pair pair : iterable) {
                            iuo.O000000o(arrayList, (List) pair.second);
                        }
                        list = (List) arrayList;
                    }
                    if (list == null) {
                        list = EmptyList.f15376O000000o;
                    }
                    if (z) {
                        Set<String> set = this.checkedItems;
                        Iterable<ddw.O000000o> iterable2 = list;
                        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
                        for (ddw.O000000o o000000o : iterable2) {
                            arrayList2.add(o000000o.f14528O000000o);
                        }
                        set.addAll((List) arrayList2);
                    } else {
                        this.checkedItems.clear();
                    }
                    RecyclerView recyclerView = this.f5741O000000o;
                    if (recyclerView != null) {
                        RecyclerView.O000000o adapter = recyclerView.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
                        }
                        Context context = view.getContext();
                        ixe.O00000Oo(context, "view.context");
                        refreshEditPage(context);
                        return;
                    }
                    ixe.O000000o("recycler");
                    throw null;
                }
                ixe.O000000o("state");
                throw null;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
             arg types: [java.util.Collection, java.util.List]
             candidates:
              _m_j.iuy.O000000o(java.util.List, int):T
              _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
              _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
              _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
              _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
              _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
              _m_j.iur.O000000o(java.lang.Iterable, int):int
              _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean */
            public final void refreshEditPage(Context context) {
                String str;
                int size = this.checkedItems.size();
                boolean z = false;
                if (size == 0) {
                    str = context.getResources().getString(R.string.mj_uwb_title_edit_choose_uwb_devices);
                } else {
                    str = context.getResources().getQuantityString(R.plurals.edit_choosed_select_tags, size, Integer.valueOf(size));
                }
                ixe.O00000Oo(str, "if (checkedSize == 0) {\n            context.resources.getString(R.string.mj_uwb_title_edit_choose_uwb_devices)\n        } else {\n            context.resources.getQuantityString(R.plurals.edit_choosed_select_tags, checkedSize, checkedSize)\n        }");
                ddw ddw = this.state;
                List list = null;
                if (ddw != null) {
                    List<Pair> value = ddw.O00000Oo.getValue();
                    if (value != null) {
                        Collection arrayList = new ArrayList();
                        for (Pair pair : value) {
                            iuo.O000000o(arrayList, (Iterable) ((List) pair.second));
                        }
                        list = (List) arrayList;
                    }
                    if (list == null) {
                        list = EmptyList.f15376O000000o;
                    }
                    UwbManagerEditPage uwbManagerEditPage = this.O00000oo;
                    if (uwbManagerEditPage != null) {
                        if (size == list.size()) {
                            z = true;
                        }
                        uwbManagerEditPage.O000000o(str, z);
                        return;
                    }
                    return;
                }
                ixe.O000000o("state");
                throw null;
            }
        }
