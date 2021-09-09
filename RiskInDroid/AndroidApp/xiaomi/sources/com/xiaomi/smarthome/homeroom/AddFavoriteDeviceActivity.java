package com.xiaomi.smarthome.homeroom;

import _m_j.fsm;
import _m_j.gfx;
import _m_j.gfz;
import _m_j.go;
import _m_j.gzl;
import _m_j.haq;
import _m_j.hft;
import _m_j.hxi;
import _m_j.iuh;
import _m_j.ixe;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.newui.adapter.DviceEditInterface;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavoriteDeviceActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "checkedModeAdapter", "Lcom/xiaomi/smarthome/homeroom/AddFavoriteDeviceActivity$CheckedModeAdapter;", "confirmBtn", "Landroid/view/View;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "titleTv", "Landroid/widget/TextView;", "uncommonDevices", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "CheckedModeAdapter", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AddFavoriteDeviceActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private RecyclerView f8817O000000o;
    private List<MainPageDeviceModel> O00000Oo;
    private O000000o O00000o0;
    public View confirmBtn;
    public TextView titleTv;

    public final void _$_clearFindViewByIdCache() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_add_favorite_device);
        gfz gfz = gfz.f17670O000000o;
        PageBean.O000000o o000000o = PageBean.CREATOR;
        Collection arrayList = new ArrayList();
        for (Device O000000o2 : gfz.O000000o(PageBean.O000000o.O00000Oo())) {
            MainPageDeviceModel O000000o3 = MainPageDeviceModel.CREATOR.O000000o(O000000o2);
            if (O000000o3 != null) {
                arrayList.add(O000000o3);
            }
        }
        this.O00000Oo = (List) arrayList;
        findViewById(R.id.content).setBackgroundColor(getResources().getColor(R.color.mj_color_background));
        View findViewById = findViewById(R.id.recycler);
        ixe.O00000Oo(findViewById, "findViewById(R.id.recycler)");
        this.f8817O000000o = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.f8817O000000o;
        if (recyclerView != null) {
            recyclerView.setItemViewCacheSize(5);
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(new AddFavoriteDeviceActivity$initView$1$1(recyclerView.getContext()));
            go goVar = new go();
            goVar.O0000o00 = false;
            iuh iuh = iuh.f1631O000000o;
            recyclerView.setItemAnimator(goVar);
            findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteDeviceActivity$92liw5pXEZjaqbeWUSsAxEOOKWw */

                public final void onClick(View view) {
                    AddFavoriteDeviceActivity.O000000o(AddFavoriteDeviceActivity.this, view);
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
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$AddFavoriteDeviceActivity$M_3xqGSIL9htUoKQ6PehTsXLhn4 */

                    public final void onClick(View view) {
                        AddFavoriteDeviceActivity.O00000Oo(AddFavoriteDeviceActivity.this, view);
                    }
                });
                View view2 = this.confirmBtn;
                if (view2 != null) {
                    view2.setEnabled(false);
                    TextView textView = this.titleTv;
                    if (textView != null) {
                        textView.setText((int) R.string.title_choose_device);
                        gzl gzl = new gzl();
                        this.O00000o0 = new O000000o(this);
                        O000000o o000000o2 = this.O00000o0;
                        if (o000000o2 != null) {
                            gzl.O000000o(o000000o2);
                            gzl.O00000Oo(new haq());
                            RecyclerView recyclerView2 = this.f8817O000000o;
                            if (recyclerView2 != null) {
                                recyclerView2.setAdapter(gzl);
                                O000000o o000000o3 = this.O00000o0;
                                if (o000000o3 != null) {
                                    PageBean.O000000o o000000o4 = PageBean.CREATOR;
                                    PageBean O00000Oo2 = PageBean.O000000o.O00000Oo();
                                    List<MainPageDeviceModel> list = this.O00000Oo;
                                    if (list != null) {
                                        o000000o3.O000000o(O00000Oo2, list);
                                    } else {
                                        ixe.O000000o("uncommonDevices");
                                        throw null;
                                    }
                                } else {
                                    ixe.O000000o("checkedModeAdapter");
                                    throw null;
                                }
                            } else {
                                ixe.O000000o("recycler");
                                throw null;
                            }
                        } else {
                            ixe.O000000o("checkedModeAdapter");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("titleTv");
                        throw null;
                    }
                } else {
                    ixe.O000000o("confirmBtn");
                    throw null;
                }
            } else {
                ixe.O000000o("confirmBtn");
                throw null;
            }
        } else {
            ixe.O000000o("recycler");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(AddFavoriteDeviceActivity addFavoriteDeviceActivity, View view) {
        ixe.O00000o(addFavoriteDeviceActivity, "this$0");
        addFavoriteDeviceActivity.finish();
        hxi.O00000o.O0000Ooo(2);
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(AddFavoriteDeviceActivity addFavoriteDeviceActivity, View view) {
        ixe.O00000o(addFavoriteDeviceActivity, "this$0");
        gfx O000000o2 = gfx.O000000o();
        O000000o o000000o = addFavoriteDeviceActivity.O00000o0;
        if (o000000o != null) {
            O000000o2.O000000o(o000000o.O0000Oo0(), new fsm[0]);
            addFavoriteDeviceActivity.finish();
            hxi.O00000o.O0000Ooo(1);
            return;
        }
        ixe.O000000o("checkedModeAdapter");
        throw null;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0002¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/AddFavoriteDeviceActivity$CheckedModeAdapter;", "Lcom/xiaomi/smarthome/newui/mainpage/DeviceMainGridAdapterV3;", "(Lcom/xiaomi/smarthome/homeroom/AddFavoriteDeviceActivity;)V", "getHostPage", "Lcom/xiaomi/smarthome/newui/adapter/DviceEditInterface$HostPage;", "getMovementFlags", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isDragable", "", "isInCameraEditMode", "isInCardEditMode", "setChecked", "", "did", "", "checked", "updateConfirmButtonDesc", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O000000o extends hft {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ AddFavoriteDeviceActivity f8818O000000o;

        public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
            ixe.O00000o(recyclerView, "recyclerView");
            ixe.O00000o(o000OOo0, "viewHolder");
            return 0;
        }

        public final boolean O00000Oo() {
            return true;
        }

        public final boolean O00000o() {
            return false;
        }

        public final boolean O00000o0() {
            return false;
        }

        public O000000o(AddFavoriteDeviceActivity addFavoriteDeviceActivity) {
            ixe.O00000o(addFavoriteDeviceActivity, "this$0");
            this.f8818O000000o = addFavoriteDeviceActivity;
        }

        public final void O000000o(String str, boolean z) {
            ixe.O00000o(str, "did");
            super.O000000o(str, z);
            View view = this.f8818O000000o.confirmBtn;
            if (view != null) {
                view.setEnabled(O0000Ooo() != 0);
                if (O0000Ooo() > 0) {
                    TextView textView = this.f8818O000000o.titleTv;
                    if (textView != null) {
                        textView.setText(this.f8818O000000o.getResources().getQuantityString(R.plurals.edit_choosed_device, O0000Ooo(), Integer.valueOf(O0000Ooo())));
                    } else {
                        ixe.O000000o("titleTv");
                        throw null;
                    }
                } else {
                    TextView textView2 = this.f8818O000000o.titleTv;
                    if (textView2 != null) {
                        textView2.setText((int) R.string.tag_add_common_device);
                    } else {
                        ixe.O000000o("titleTv");
                        throw null;
                    }
                }
            } else {
                ixe.O000000o("confirmBtn");
                throw null;
            }
        }

        public final DviceEditInterface.HostPage O00000oO() {
            return DviceEditInterface.HostPage.ROOM_PAGE;
        }
    }
}
