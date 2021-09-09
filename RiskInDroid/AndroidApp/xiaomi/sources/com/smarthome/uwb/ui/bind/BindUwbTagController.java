package com.smarthome.uwb.ui.bind;

import _m_j.dcp;
import _m_j.ddt;
import _m_j.ddv;
import _m_j.ddy;
import _m_j.ez;
import _m_j.fa;
import _m_j.fg;
import _m_j.fh;
import _m_j.fi;
import _m_j.fm;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fo;
import _m_j.fso;
import _m_j.fux;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gzl;
import _m_j.gzm;
import _m_j.hxi;
import _m_j.hzq;
import _m_j.hzs;
import _m_j.iuf;
import _m_j.iuo;
import _m_j.ivk;
import _m_j.ixe;
import _m_j.ixh;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.smarthome.uwb.ui.bind.BindUwbTagController;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.smartconfig.step.SmartConfigStep;
import com.xiaomi.smarthome.uwb.lib.UwbSdk;
import com.xiaomi.smarthome.uwb.lib.data.DidInfo;
import com.xiaomi.smarthome.uwb.lib.data.UwbScanDevice;
import com.xiaomi.smarthome.uwb.lib.processor.engine.DeviceBindHelper;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 D2\u00020\u0001:\u0002DEB\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\bH\u0002J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0013J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00030\bJ\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u001cJ\"\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'0\b2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010!\u001a\u00020)J\u0010\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,H\u0007J\u001e\u0010-\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\bH\u0002J\u0010\u00100\u001a\u00020\u00132\b\b\u0002\u00101\u001a\u00020\fJ\b\u00102\u001a\u00020\u0013H\u0007J\u000e\u00103\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u00104\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ$\u00105\u001a\u0004\u0018\u0001062\u0006\u0010!\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00032\u0006\u00109\u001a\u00020:H\u0002J4\u0010;\u001a\u00020\u00132\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020?2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BH\u0002J:\u0010C\u001a\u00020\u00132\u0006\u0010!\u001a\u0002072\u0006\u0010@\u001a\u00020?2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010A\u001a\u00020BR \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006F"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagController;", "Landroidx/lifecycle/LifecycleObserver;", "tagId", "", "tagOwnHomeId", "(Ljava/lang/String;Ljava/lang/String;)V", "compactIds", "", "", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "isDestroyed", "", "state", "Lcom/smarthome/uwb/ui/bind/BindUwbViewModel;", "getTagId", "()Ljava/lang/String;", "getTagOwnHomeId", "addToCompactIdIfNeeded", "", "cates", "Lcom/xiaomi/smarthome/device/utils/DeviceTagInterface$Category;", "buildFilterMenu", "", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FlexFilterMenu;", "context", "Landroid/content/Context;", "changeDeviceHomeTo", "Lio/reactivex/Observable;", "", "did", "homeId", "checkPermission", "activity", "Landroid/app/Activity;", "defaultRenderData", "getAssociatedDevDid", "getAssociatedDevDidRemote", "getCategoryItems", "Lkotlin/Pair;", "init", "Landroidx/fragment/app/FragmentActivity;", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onFilterWith", "predict", "Lcom/smarthome/uwb/ui/widget/StaticMultiFilterMenu$FilterResult;", "requestDefault", "concatCache", "requestWithHomeAndDeviceUpdate", "showBindUwbTagFailedDialog", "showFilterDialog", "showPopUpChooseStepDialog", "Landroid/app/Dialog;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "model", "listener", "Lcom/xiaomi/smarthome/smartconfig/step/SmartConfigStep$StepListener;", "startAssociate", "uwbScanDevice", "Lcom/xiaomi/smarthome/uwb/lib/data/UwbScanDevice;", "tagDevice", "Lcom/xiaomi/smarthome/device/Device;", "device", "callback", "Lcom/smarthome/uwb/ui/bind/BindUwbTagController$UwbAssociateCallback;", "startUwbBinder", "Companion", "UwbAssociateCallback", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BindUwbTagController implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f5718O000000o = new O000000o((byte) 0);
    final String O00000Oo;
    private final String O00000o;
    ddv O00000o0;
    private final CompositeDisposable O00000oO;
    private boolean O00000oo;
    private final Map<String, List<String>> O0000O0o;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\u001a\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagController$UwbAssociateCallback;", "", "onAssocaiteBegin", "", "onAssociateAndRefreshSuccess", "onAssociateFail", "code", "", "msg", "", "onCancel", "onProcess", "progress", "onRefreshDeviceFail", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000Oo {
        void O000000o();

        void O000000o(int i, String str);

        void O00000Oo();

        void O00000o();

        void O00000o0();

        void O00000oO();
    }

    private /* synthetic */ BindUwbTagController() {
        this(null, null);
    }

    public BindUwbTagController(String str, String str2) {
        this.O00000Oo = str;
        this.O00000o = str2;
        this.O00000oO = new CompositeDisposable();
        this.O0000O0o = new LinkedHashMap();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/bind/BindUwbTagController$Companion;", "", "()V", "TAG", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public final void O000000o(FragmentActivity fragmentActivity) {
        ixe.O00000o(fragmentActivity, "activity");
        fragmentActivity.getLifecycle().O000000o(this);
        dcp.O000000o().O000000o(fragmentActivity.getApplicationContext());
        fm O000000o2 = fo.O000000o(fragmentActivity).O000000o(ddv.class);
        ixe.O00000Oo(O000000o2, "of(activity).get(BindUwbViewModel::class.java)");
        this.O00000o0 = (ddv) O000000o2;
        ddv ddv = this.O00000o0;
        if (ddv != null) {
            ddv.O00000Oo.observe(fragmentActivity, new fh(fragmentActivity) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$HttkbDlx1FSWo2BZABGU6LXpSD0 */
                private final /* synthetic */ FragmentActivity f$1;

                {
                    this.f$1 = r2;
                }

                public final void onChanged(Object obj) {
                    BindUwbTagController.O000000o(BindUwbTagController.this, this.f$1, (List) obj);
                }
            });
        } else {
            ixe.O000000o("state");
            throw null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v24, resolved type: java.util.List} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0048  */
    public static final void O000000o(BindUwbTagController bindUwbTagController, FragmentActivity fragmentActivity, List list) {
        boolean z;
        List<Home> list2;
        List list3;
        List list4;
        Iterable iterable;
        Iterable iterable2;
        Iterable iterable3;
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(fragmentActivity, "$activity");
        if (list != null && (!list.isEmpty())) {
            Iterable iterable4 = list;
            boolean z2 = false;
            if (!(iterable4 instanceof Collection) || !((Collection) iterable4).isEmpty()) {
                Iterator it = iterable4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (!((ddy.O000000o) it.next()).f14531O000000o.isEmpty()) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (z) {
                    if (!bindUwbTagController.O00000oo) {
                        CharSequence charSequence = bindUwbTagController.O00000o;
                        if (charSequence == null || charSequence.length() == 0) {
                            Iterable iterable5 = ggb.O00000Oo().O0000OoO.O00000Oo;
                            ixe.O00000Oo(iterable5, "getInstance().allHome");
                            Collection arrayList = new ArrayList();
                            for (Object next : iterable5) {
                                if (((Home) next).isOwner()) {
                                    arrayList.add(next);
                                }
                            }
                            list2 = (List) arrayList;
                        } else {
                            Home O00000o2 = ggb.O00000Oo().O00000o(bindUwbTagController.O00000o);
                            if (O00000o2 == null) {
                                list2 = EmptyList.f15376O000000o;
                            } else {
                                list2 = iuo.O000000o(O00000o2);
                            }
                        }
                        ddy.O000000o o000000o = (ddy.O000000o) iuo.O000000o(list, 0);
                        List list5 = null;
                        if (o000000o == null || (iterable3 = o000000o.f14531O000000o) == null) {
                            list3 = null;
                        } else {
                            Iterable<ddy.O00000o0> iterable6 = iterable3;
                            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable6, 10));
                            for (ddy.O00000o0 o00000o0 : iterable6) {
                                arrayList2.add(o00000o0.f14535O000000o);
                            }
                            list3 = (List) arrayList2;
                        }
                        Collection collection = list3;
                        if (!(!(collection == null || collection.isEmpty()))) {
                            list3 = null;
                        }
                        if (list3 == null) {
                            Iterable<Home> iterable7 = list2;
                            Collection arrayList3 = new ArrayList(iuo.O000000o(iterable7, 10));
                            for (Home id : iterable7) {
                                arrayList3.add(id.getId());
                            }
                            list3 = arrayList3;
                        }
                        ddy.O000000o o000000o2 = (ddy.O000000o) iuo.O000000o(list, 1);
                        if (o000000o2 == null || (iterable2 = o000000o2.f14531O000000o) == null) {
                            list4 = null;
                        } else {
                            Iterable<ddy.O00000o0> iterable8 = iterable2;
                            Collection arrayList4 = new ArrayList(iuo.O000000o(iterable8, 10));
                            for (ddy.O00000o0 o00000o02 : iterable8) {
                                arrayList4.add(o00000o02.f14535O000000o);
                            }
                            list4 = (List) arrayList4;
                        }
                        Collection collection2 = list4;
                        if (collection2 == null || collection2.isEmpty()) {
                            z2 = true;
                        }
                        if (!(true ^ z2)) {
                            list4 = null;
                        }
                        if (list4 == null) {
                            Collection arrayList5 = new ArrayList();
                            for (Home roomList : list2) {
                                Iterable roomList2 = roomList.getRoomList();
                                ixe.O00000Oo(roomList2, "it.roomList");
                                Iterable<Room> iterable9 = roomList2;
                                Collection arrayList6 = new ArrayList(iuo.O000000o(iterable9, 10));
                                for (Room id2 : iterable9) {
                                    arrayList6.add(id2.getId());
                                }
                                iuo.O000000o(arrayList5, (List) arrayList6);
                            }
                            list4 = arrayList5;
                        }
                        ddy.O000000o o000000o3 = (ddy.O000000o) iuo.O000000o(list, 2);
                        if (!(o000000o3 == null || (iterable = o000000o3.f14531O000000o) == null)) {
                            Iterable<ddy.O00000o0> iterable10 = iterable;
                            Collection arrayList7 = new ArrayList(iuo.O000000o(iterable10, 10));
                            for (ddy.O00000o0 o00000o03 : iterable10) {
                                arrayList7.add(o00000o03.f14535O000000o);
                            }
                            list5 = arrayList7;
                        }
                        if (list5 == null) {
                            list5 = EmptyList.f15376O000000o;
                        }
                        ddt ddt = ddt.f14518O000000o;
                        bindUwbTagController.O00000oO.add(ddt.O000000o(list3).map(new Function(list4, list5, bindUwbTagController) {
                            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$gm3vhXrqgq2omTeEMZSUmdpKZo */
                            private final /* synthetic */ List f$0;
                            private final /* synthetic */ List f$1;
                            private final /* synthetic */ BindUwbTagController f$2;

                            {
                                this.f$0 = r1;
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final Object apply(Object obj) {
                                return BindUwbTagController.O000000o(this.f$0, this.f$1, this.f$2, (List) obj);
                            }
                        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$fjCFkYy5BkiueFqM83EdbZ0hqE */

                            public final void accept(Object obj) {
                                BindUwbTagController.O000000o(BindUwbTagController.this, (List) obj);
                            }
                        }, new Consumer() {
                            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$_bR5yFpcNY1NwskR16lBl0z7Onk */

                            public final void accept(Object obj) {
                                BindUwbTagController.O000000o(BindUwbTagController.this, (Throwable) obj);
                            }
                        }));
                        return;
                    }
                    return;
                }
            }
            z = false;
            if (z) {
            }
        }
        bindUwbTagController.O000000o(true);
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(fa faVar) {
        ixe.O00000o(faVar, "owner");
        this.O00000oO.clear();
        this.O00000oo = true;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000o<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((ddy.O00000o0) t).f14535O000000o, ((ddy.O00000o0) t2).f14535O000000o);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000o0<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((ddy.O00000o0) t).f14535O000000o, ((ddy.O00000o0) t2).f14535O000000o);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O0000O0o<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((ddy.O00000o0) t).f14535O000000o, ((ddy.O00000o0) t2).f14535O000000o);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0049 A[SYNTHETIC] */
    public static final List O000000o(List list, List list2, BindUwbTagController bindUwbTagController, List list3) {
        boolean z;
        boolean z2;
        boolean z3;
        List<String> dids;
        ixe.O00000o(list, "$selectedRooms");
        ixe.O00000o(list2, "$selectedCategories");
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(list3, "homeUnbindDevices");
        Collection arrayList = new ArrayList();
        Iterator it = list3.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = (String) pair.first;
            List list4 = (List) pair.second;
            ddv.O00000Oo o00000Oo = null;
            if (!list4.isEmpty()) {
                List arrayList2 = new ArrayList();
                Iterator it2 = list4.iterator();
                while (true) {
                    boolean z4 = true;
                    if (!it2.hasNext()) {
                        break;
                    }
                    Device device = (Device) it2.next();
                    if (list.contains("mijia.roomid.default")) {
                        Home O00000o2 = ggb.O00000Oo().O00000o(str);
                        if (ixe.O000000o((O00000o2 == null || (dids = O00000o2.getDids()) == null) ? null : Boolean.valueOf(dids.contains(device.did)), Boolean.TRUE)) {
                            z = true;
                            if (!z) {
                                Iterable iterable = list;
                                Room O0000o00 = ggb.O00000Oo().O0000o00(device.did);
                                if (!iuo.O000000o(iterable, O0000o00 == null ? null : O0000o00.getId())) {
                                    z2 = false;
                                    if (z2) {
                                        if (!list2.isEmpty()) {
                                            DeviceTagInterface.Category O00000o02 = fnn.O000000o().O00000Oo().O00000o0(device.model);
                                            String str2 = O00000o02.id;
                                            String str3 = O00000o02.name;
                                            if (!list2.contains(str2)) {
                                                List list5 = bindUwbTagController.O0000O0o.get(str3);
                                                if (list5 != null) {
                                                    Iterable iterable2 = list5;
                                                    if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                                                        Iterator it3 = iterable2.iterator();
                                                        while (true) {
                                                            if (it3.hasNext()) {
                                                                if (list2.contains((String) it3.next())) {
                                                                    z3 = true;
                                                                    break;
                                                                }
                                                            } else {
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                z3 = false;
                                                if (!z3) {
                                                    z4 = false;
                                                }
                                            }
                                        }
                                        if (z4) {
                                            arrayList2.add(device);
                                        }
                                    }
                                }
                            }
                            z2 = true;
                            if (z2) {
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                if (!arrayList2.isEmpty()) {
                    o00000Oo = new ddv.O00000Oo(true, str, arrayList2);
                }
            }
            if (o00000Oo != null) {
                arrayList.add(o00000Oo);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagController bindUwbTagController, List list) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            ddv.O00000o0.postValue(list);
        } else {
            ixe.O000000o("state");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagController bindUwbTagController, Throwable th) {
        ixe.O00000o(bindUwbTagController, "this$0");
        th.printStackTrace();
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            fg<List<ddv.O00000Oo>> fgVar = ddv.O00000o0;
            ddv.O000000o o000000o = ddv.f14525O000000o;
            fgVar.postValue(ddv.O00000oO);
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    private final List<Pair<String, String>> O000000o(String str) {
        DeviceTagInterface<Device> O00000Oo2 = fnn.O000000o().O00000Oo();
        ixe.O00000Oo(O00000Oo2, "getInstance().deviceTagManager");
        Set<Map.Entry<String, List<String>>> entrySet = O00000Oo2.O0000Oo(str).entrySet();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : entrySet) {
            List list = (List) next.getValue();
            List<DeviceTagInterface.Category> O00000oO2 = O00000Oo2.O00000oO((String) next.getKey());
            Collection collection = O00000oO2;
            if (!(collection == null || collection.isEmpty()) && !TextUtils.isEmpty(O00000oO2.get(0).id) && !TextUtils.isEmpty(O00000oO2.get(0).name) && list != null && (!list.isEmpty())) {
                ixe.O00000Oo(O00000oO2, "cates");
                O000000o(O00000oO2);
                arrayList.add(iuf.O000000o(O00000oO2.get(0).id, O00000oO2.get(0).name));
            }
        }
        return arrayList;
    }

    private final void O000000o(List<? extends DeviceTagInterface.Category> list) {
        Collection collection = list;
        if (!(collection == null || collection.isEmpty()) && list.size() != 1) {
            Iterable<DeviceTagInterface.Category> iterable = list;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (DeviceTagInterface.Category category : iterable) {
                arrayList.add(category.id);
            }
            Map<String, List<String>> map = this.O0000O0o;
            String str = ((DeviceTagInterface.Category) list.get(0)).name;
            ixe.O00000Oo(str, "cates[0].name");
            map.put(str, (List) arrayList);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v19, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v13, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v19, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v34, resolved type: java.util.List} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
     arg types: [java.util.List, java.util.Comparator]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T> */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03c8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013c A[LOOP:2: B:39:0x0136->B:41:0x013c, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x017f A[LOOP:3: B:46:0x0179->B:48:0x017f, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02c3 A[LOOP:7: B:83:0x02bd->B:85:0x02c3, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02d4  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02f1  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x034c  */
    public final void O000000o(Context context) {
        List list;
        Pair pair;
        ddy.O000000o o000000o;
        List list2;
        ddy.O000000o o000000o2;
        List list3;
        List O00000oo2;
        ddy.O000000o o000000o3;
        List list4;
        Iterable iterable;
        Iterable iterable2;
        Iterable iterable3;
        Context context2 = context;
        ixe.O00000o(context2, "context");
        if (!this.O00000oo) {
            hxi.O0000o00.f954O000000o.O000000o("uwb_bind_page_filter", new Object[0]);
            ddv ddv = this.O00000o0;
            if (ddv != null) {
                List value = ddv.O00000Oo.getValue();
                List arrayList = new ArrayList();
                CharSequence charSequence = this.O00000o;
                if (charSequence == null || charSequence.length() == 0) {
                    Iterable iterable4 = ggb.O00000Oo().O0000OoO.O00000Oo;
                    ixe.O00000Oo(iterable4, "getInstance().allHome");
                    Collection arrayList2 = new ArrayList();
                    for (Object next : iterable4) {
                        if (((Home) next).isOwner()) {
                            arrayList2.add(next);
                        }
                    }
                    Iterable iterable5 = (List) arrayList2;
                    if (!((Collection) iterable5).isEmpty()) {
                        Iterable<Home> iterable6 = iterable5;
                        Collection arrayList3 = new ArrayList(iuo.O000000o(iterable6, 10));
                        for (Home home : iterable6) {
                            String id = home.getId();
                            ixe.O00000Oo(id, "it.id");
                            String rawName = home.getRawName();
                            ixe.O00000Oo(rawName, "it.rawName");
                            arrayList3.add(new ddy.O00000o0(id, rawName));
                        }
                        pair = iuf.O000000o(iterable5, (List) arrayList3);
                        Iterable iterable7 = (List) pair.first;
                        String string = context2.getString(R.string.home);
                        ixe.O00000Oo(string, "context.getString(R.string.home)");
                        List O000000o2 = iuo.O000000o((List) pair.second, new O00000o0());
                        if (value != null) {
                            o000000o = null;
                        } else {
                            o000000o = (ddy.O000000o) iuo.O000000o(value, 0);
                        }
                        if (o000000o == null || (iterable3 = o000000o.f14531O000000o) == null) {
                            list2 = null;
                        } else {
                            Iterable<ddy.O00000o0> iterable8 = iterable3;
                            Collection arrayList4 = new ArrayList(iuo.O000000o(iterable8, 10));
                            for (ddy.O00000o0 o00000o0 : iterable8) {
                                arrayList4.add(o00000o0.f14535O000000o);
                            }
                            list2 = arrayList4;
                        }
                        if (list2 == null) {
                            list2 = EmptyList.f15376O000000o;
                        }
                        arrayList.add(new ddy.O00000Oo(string, O000000o2, list2));
                        String string2 = context2.getString(R.string.default_room);
                        ixe.O00000Oo(string2, "context.getString(R.string.default_room)");
                        ddy.O00000o0 o00000o02 = new ddy.O00000o0("mijia.roomid.default", string2);
                        Iterable<Home> iterable9 = iterable7;
                        Collection arrayList5 = new ArrayList();
                        for (Home roomList : iterable9) {
                            Iterable roomList2 = roomList.getRoomList();
                            ixe.O00000Oo(roomList2, "it.roomList");
                            iuo.O000000o(arrayList5, roomList2);
                        }
                        List list5 = (List) arrayList5;
                        List O00000Oo2 = iuo.O00000Oo(o00000o02);
                        Map linkedHashMap = new LinkedHashMap();
                        for (Object next2 : list5) {
                            String name = ((Room) next2).getName();
                            Object obj = linkedHashMap.get(name);
                            if (obj == null) {
                                Object obj2 = (List) new ArrayList();
                                linkedHashMap.put(name, obj2);
                                obj = obj2;
                            }
                            ((List) obj).add(next2);
                        }
                        for (Map.Entry entry : linkedHashMap.entrySet()) {
                            String str = (String) entry.getKey();
                            List<Room> list6 = (List) entry.getValue();
                            if (list6.size() > 1) {
                                for (Room room : list6) {
                                    Home O00000o2 = ggb.O00000Oo().O00000o(room.getParentid());
                                    String rawName2 = O00000o2 == null ? null : O00000o2.getRawName();
                                    if (rawName2 != null) {
                                        String id2 = room.getId();
                                        ixe.O00000Oo(id2, "room.id");
                                        O00000Oo2.add(new ddy.O00000o0(id2, ((Object) room.getName()) + " | " + rawName2));
                                    }
                                }
                            } else if (!list6.isEmpty()) {
                                String id3 = ((Room) list6.get(0)).getId();
                                ixe.O00000Oo(id3, "rooms[0].id");
                                ixe.O00000Oo(str, "title");
                                O00000Oo2.add(new ddy.O00000o0(id3, str));
                            }
                        }
                        String string3 = context2.getString(R.string.room_name);
                        ixe.O00000Oo(string3, "context.getString(R.string.room_name)");
                        List O000000o3 = iuo.O000000o((Iterable) O00000Oo2, new O00000o());
                        if (value == null) {
                            o000000o2 = null;
                        } else {
                            o000000o2 = (ddy.O000000o) iuo.O000000o(value, 1);
                        }
                        if (o000000o2 == null || (iterable2 = o000000o2.f14531O000000o) == null) {
                            list3 = null;
                        } else {
                            Iterable<ddy.O00000o0> iterable10 = iterable2;
                            Collection arrayList6 = new ArrayList(iuo.O000000o(iterable10, 10));
                            for (ddy.O00000o0 o00000o03 : iterable10) {
                                arrayList6.add(o00000o03.f14535O000000o);
                            }
                            list3 = arrayList6;
                        }
                        if (list3 == null) {
                            list3 = EmptyList.f15376O000000o;
                        }
                        arrayList.add(new ddy.O00000Oo(string3, O000000o3, list3));
                        Collection arrayList7 = new ArrayList();
                        for (Home id4 : iterable9) {
                            String id5 = id4.getId();
                            ixe.O00000Oo(id5, "it.id");
                            Iterable<Pair> O000000o4 = O000000o(id5);
                            Collection arrayList8 = new ArrayList(iuo.O000000o(O000000o4, 10));
                            for (Pair pair2 : O000000o4) {
                                arrayList8.add(new ddy.O00000o0(pair2.first, pair2.second));
                            }
                            iuo.O000000o(arrayList7, (List) arrayList8);
                        }
                        O00000oo2 = iuo.O00000oo((List) arrayList7);
                        if (!O00000oo2.isEmpty()) {
                            String string4 = context2.getString(R.string.mj_category);
                            ixe.O00000Oo(string4, "context.getString(R.string.mj_category)");
                            List O000000o5 = iuo.O000000o((Iterable) O00000oo2, new O0000O0o());
                            if (value == null) {
                                o000000o3 = null;
                            } else {
                                o000000o3 = (ddy.O000000o) iuo.O000000o(value, 2);
                            }
                            if (o000000o3 == null || (iterable = o000000o3.f14531O000000o) == null) {
                                list4 = null;
                            } else {
                                Iterable<ddy.O00000o0> iterable11 = iterable;
                                Collection arrayList9 = new ArrayList(iuo.O000000o(iterable11, 10));
                                for (ddy.O00000o0 o00000o04 : iterable11) {
                                    arrayList9.add(o00000o04.f14535O000000o);
                                }
                                list4 = arrayList9;
                            }
                            if (list4 == null) {
                                list4 = EmptyList.f15376O000000o;
                            }
                            arrayList.add(new ddy.O00000Oo(string4, O000000o5, list4));
                        }
                        if (!list5.isEmpty() || !O00000oo2.isEmpty()) {
                            list = arrayList;
                            if (list == null) {
                                gqg.O00000Oo((int) R.string.action_fail);
                                return;
                            }
                            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context2);
                            builder.O000000o((int) R.string.uwb_filter);
                            Pair<ddy.O0000O0o, View> O000000o6 = new ddy(list).O000000o(context2);
                            builder.O000000o(O000000o6.second);
                            builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(O000000o6.first) {
                                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$ikgH_PKVhi_WiLmtYdTy6EBj3s */
                                private final /* synthetic */ ddy.O0000O0o f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    BindUwbTagController.O000000o(BindUwbTagController.this, this.f$1, dialogInterface, i);
                                }
                            });
                            builder.O00000Oo(context2.getString(R.string.uwb_reset), new DialogInterface.OnClickListener() {
                                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$mIsF0s5qtibZ0glEbyAJg8YE5sY */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    BindUwbTagController.O000000o(BindUwbTagController.this, dialogInterface, i);
                                }
                            });
                            builder.O000000o(true);
                            builder.O00000oo();
                            return;
                        }
                    }
                } else {
                    Home O00000o3 = ggb.O00000Oo().O00000o(this.O00000o);
                    if (O00000o3 != null) {
                        List O000000o7 = iuo.O000000o(O00000o3);
                        String id6 = O00000o3.getId();
                        ixe.O00000Oo(id6, "targetHome.id");
                        String rawName3 = O00000o3.getRawName();
                        ixe.O00000Oo(rawName3, "targetHome.rawName");
                        pair = iuf.O000000o(O000000o7, iuo.O000000o(new ddy.O00000o0(id6, rawName3)));
                        Iterable iterable72 = (List) pair.first;
                        String string5 = context2.getString(R.string.home);
                        ixe.O00000Oo(string5, "context.getString(R.string.home)");
                        List O000000o22 = iuo.O000000o((List) pair.second, new O00000o0());
                        if (value != null) {
                        }
                        if (o000000o == null) {
                            Iterable<ddy.O00000o0> iterable82 = iterable3;
                            Collection arrayList42 = new ArrayList(iuo.O000000o(iterable82, 10));
                            while (r12.hasNext()) {
                            }
                            list2 = arrayList42;
                            if (list2 == null) {
                            }
                            arrayList.add(new ddy.O00000Oo(string5, O000000o22, list2));
                            String string22 = context2.getString(R.string.default_room);
                            ixe.O00000Oo(string22, "context.getString(R.string.default_room)");
                            ddy.O00000o0 o00000o022 = new ddy.O00000o0("mijia.roomid.default", string22);
                            Iterable<Home> iterable92 = iterable72;
                            Collection arrayList52 = new ArrayList();
                            while (r12.hasNext()) {
                            }
                            List list52 = (List) arrayList52;
                            List O00000Oo22 = iuo.O00000Oo(o00000o022);
                            Map linkedHashMap2 = new LinkedHashMap();
                            while (r12.hasNext()) {
                            }
                            while (r4.hasNext()) {
                            }
                            String string32 = context2.getString(R.string.room_name);
                            ixe.O00000Oo(string32, "context.getString(R.string.room_name)");
                            List O000000o32 = iuo.O000000o((Iterable) O00000Oo22, new O00000o());
                            if (value == null) {
                            }
                            if (o000000o2 == null) {
                                Iterable<ddy.O00000o0> iterable102 = iterable2;
                                Collection arrayList62 = new ArrayList(iuo.O000000o(iterable102, 10));
                                while (r6.hasNext()) {
                                }
                                list3 = arrayList62;
                                if (list3 == null) {
                                }
                                arrayList.add(new ddy.O00000Oo(string32, O000000o32, list3));
                                Collection arrayList72 = new ArrayList();
                                while (r4.hasNext()) {
                                }
                                O00000oo2 = iuo.O00000oo((List) arrayList72);
                                if (!O00000oo2.isEmpty()) {
                                }
                                list = arrayList;
                                if (list == null) {
                                }
                            }
                            list3 = null;
                            if (list3 == null) {
                            }
                            arrayList.add(new ddy.O00000Oo(string32, O000000o32, list3));
                            Collection arrayList722 = new ArrayList();
                            while (r4.hasNext()) {
                            }
                            O00000oo2 = iuo.O00000oo((List) arrayList722);
                            if (!O00000oo2.isEmpty()) {
                            }
                            list = arrayList;
                            if (list == null) {
                            }
                        }
                        list2 = null;
                        if (list2 == null) {
                        }
                        arrayList.add(new ddy.O00000Oo(string5, O000000o22, list2));
                        String string222 = context2.getString(R.string.default_room);
                        ixe.O00000Oo(string222, "context.getString(R.string.default_room)");
                        ddy.O00000o0 o00000o0222 = new ddy.O00000o0("mijia.roomid.default", string222);
                        Iterable<Home> iterable922 = iterable72;
                        Collection arrayList522 = new ArrayList();
                        while (r12.hasNext()) {
                        }
                        List list522 = (List) arrayList522;
                        List O00000Oo222 = iuo.O00000Oo(o00000o0222);
                        Map linkedHashMap22 = new LinkedHashMap();
                        while (r12.hasNext()) {
                        }
                        while (r4.hasNext()) {
                        }
                        String string322 = context2.getString(R.string.room_name);
                        ixe.O00000Oo(string322, "context.getString(R.string.room_name)");
                        List O000000o322 = iuo.O000000o((Iterable) O00000Oo222, new O00000o());
                        if (value == null) {
                        }
                        if (o000000o2 == null) {
                        }
                        list3 = null;
                        if (list3 == null) {
                        }
                        arrayList.add(new ddy.O00000Oo(string322, O000000o322, list3));
                        Collection arrayList7222 = new ArrayList();
                        while (r4.hasNext()) {
                        }
                        O00000oo2 = iuo.O00000oo((List) arrayList7222);
                        if (!O00000oo2.isEmpty()) {
                        }
                        list = arrayList;
                        if (list == null) {
                        }
                    }
                }
                list = null;
                if (list == null) {
                }
            } else {
                ixe.O000000o("state");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagController bindUwbTagController, ddy.O0000O0o o0000O0o, DialogInterface dialogInterface, int i) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(o0000O0o, "$result");
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            fg<List<ddy.O000000o>> fgVar = ddv.O00000Oo;
            gzl gzl = o0000O0o.f14536O000000o;
            Class<ddy.O00000o> cls = ddy.O00000o.class;
            ArrayList arrayList = new ArrayList();
            for (gzm next : gzl.f18620O000000o) {
                if (cls.isInstance(next)) {
                    arrayList.add(next);
                }
            }
            Iterable<ddy.O00000o> iterable = arrayList;
            Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
            for (ddy.O00000o f_ : iterable) {
                arrayList2.add(f_.f_());
            }
            fgVar.postValue((List) arrayList2);
            dialogInterface.dismiss();
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(BindUwbTagController bindUwbTagController, DialogInterface dialogInterface, int i) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            ddv.O00000Oo.postValue(null);
            dialogInterface.cancel();
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    @SuppressLint({"CheckResult"})
    public final void O000000o() {
        if (!this.O00000oo) {
            ddt ddt = ddt.f14518O000000o;
            ddt.O000000o().onErrorReturnItem(new Intent()).flatMap(new Function() {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$XK_g6fj4rZ5302o5kMYEdt4BqEk */

                public final Object apply(Object obj) {
                    return BindUwbTagController.O000000o(BindUwbTagController.this, (Intent) obj);
                }
            }).subscribe(new Consumer() {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$lUFzVti3peM9pj8YEMkvzlsBjR0 */

                public final void accept(Object obj) {
                    BindUwbTagController.O00000Oo(BindUwbTagController.this, (List) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(BindUwbTagController bindUwbTagController, List list) {
        ixe.O00000o(bindUwbTagController, "this$0");
        bindUwbTagController.O000000o(false);
    }

    /* access modifiers changed from: private */
    public void O000000o(boolean z) {
        List list;
        if (!this.O00000oo) {
            CharSequence charSequence = this.O00000o;
            if (charSequence == null || charSequence.length() == 0) {
                List<Home> list2 = ggb.O00000Oo().O0000OoO.O00000Oo;
                ixe.O00000Oo(list2, "getInstance().allHome");
                Collection arrayList = new ArrayList();
                for (Object next : list2) {
                    if (((Home) next).isOwner()) {
                        arrayList.add(next);
                    }
                }
                Iterable<Home> iterable = (List) arrayList;
                Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
                for (Home id : iterable) {
                    arrayList2.add(id.getId());
                }
                list = (List) arrayList2;
            } else {
                list = iuo.O000000o(this.O00000o);
            }
            UwbLogUtil.d("BindUwbTagController", "requestDefault: " + list + ",concatCache= " + z);
            ddt ddt = ddt.f14518O000000o;
            this.O00000oO.add(ddt.O000000o(list).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$z0S4ZUKqvW3kjkdhNS8e8s_Qb9c */

                public final void accept(Object obj) {
                    BindUwbTagController.O00000o0(BindUwbTagController.this, (List) obj);
                }
            }, new Consumer() {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$npLiP_9UWmSZy7HKnB3rTPoUe_Q */

                public final void accept(Object obj) {
                    BindUwbTagController.O00000Oo(BindUwbTagController.this, (Throwable) obj);
                }
            }));
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(BindUwbTagController bindUwbTagController, List list) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(list, "supported");
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!((Collection) ((Pair) next).second).isEmpty()) {
                arrayList.add(next);
            }
        }
        Iterable<Pair> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
        for (Pair pair : iterable) {
            arrayList2.add(new ddv.O00000Oo(false, (String) pair.first, (List) pair.second));
        }
        List<ddv.O00000Oo> list2 = (List) arrayList2;
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            fg<List<ddv.O00000Oo>> fgVar = ddv.O00000o0;
            if (list2.isEmpty()) {
                ddv.O000000o o000000o = ddv.f14525O000000o;
                list2 = ddv.O00000oo;
            }
            fgVar.postValue(list2);
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(BindUwbTagController bindUwbTagController, Throwable th) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ddv ddv = bindUwbTagController.O00000o0;
        if (ddv != null) {
            fg<List<ddv.O00000Oo>> fgVar = ddv.O00000o0;
            ddv.O000000o o000000o = ddv.f14525O000000o;
            fgVar.postValue(ddv.O00000oo);
            gqg.O00000Oo((int) R.string.failed);
            th.printStackTrace();
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean
     arg types: [android.app.Activity, int, ?]
     candidates:
      _m_j.fux.O000000o(android.app.Activity, int, _m_j.fux$O000000o):boolean
      _m_j.fux.O000000o(android.app.Activity, boolean, int):boolean */
    public static void O000000o(Activity activity) {
        ixe.O00000o(activity, "activity");
        if (!fux.O000000o(activity, false, (int) R.string.location_disable_hint)) {
            fux.O000000o(activity, true, (int) R.string.permission_location_rational_desc_new);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O00000Oo(Context context) {
        ixe.O00000o(context, "context");
        if (!this.O00000oo) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
            builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
            builder.O000000o((int) R.string.mj_uwb_bind_uwb_failed);
            builder.O000000o(LayoutInflater.from(context).inflate((int) R.layout.uwb_bind_tag_failed, (ViewGroup) null, false));
            builder.O00000o0((int) R.string.mj_i_know, $$Lambda$BindUwbTagController$gRwZL4fcv8An09Wenpw2c_cUcFE.INSTANCE);
            builder.O000000o(true);
            builder.O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public final void O000000o(BaseActivity baseActivity, Device device, Device device2, UwbScanDevice uwbScanDevice, String str, O00000Oo o00000Oo) {
        BaseActivity baseActivity2 = baseActivity;
        Device device3 = device;
        O00000Oo o00000Oo2 = o00000Oo;
        ixe.O00000o(baseActivity, "activity");
        ixe.O00000o(device3, "device");
        ixe.O00000o(str, "homeId");
        ixe.O00000o(o00000Oo2, "callback");
        if (!this.O00000oo) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(baseActivity2);
            ixh ixh = ixh.f1644O000000o;
            String string = baseActivity.getString(R.string.uwb_bind_begin_title);
            ixe.O00000Oo(string, "activity.getString(R.string.uwb_bind_begin_title)");
            String format = String.format(string, Arrays.copyOf(new Object[]{device3.name}, 1));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            builder.O000000o(format);
            ixh ixh2 = ixh.f1644O000000o;
            String string2 = baseActivity.getString(R.string.uwb_bind_cost_time_tip, new Object[]{device3.name});
            ixe.O00000Oo(string2, "activity.getString(R.string.uwb_bind_cost_time_tip,device.name)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[0], 0));
            ixe.O00000Oo(format2, "java.lang.String.format(format, *args)");
            builder.O00000Oo(format2);
            builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(this, baseActivity, uwbScanDevice, o00000Oo, device, str) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$i0IZ_6KqCoD29SlsrqnJuvhpI4 */
                private final /* synthetic */ BindUwbTagController f$1;
                private final /* synthetic */ BaseActivity f$2;
                private final /* synthetic */ UwbScanDevice f$3;
                private final /* synthetic */ BindUwbTagController.O00000Oo f$4;
                private final /* synthetic */ Device f$5;
                private final /* synthetic */ String f$6;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                    this.f$5 = r6;
                    this.f$6 = r7;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BindUwbTagController.O000000o(Device.this, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, dialogInterface, i);
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$_QlS3I9JeXVVPOwX7UHQeKQsPjQ */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BindUwbTagController.O000000o(BindUwbTagController.O00000Oo.this, dialogInterface, i);
                }
            });
            builder.O000000o(true);
            builder.O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Device device, BindUwbTagController bindUwbTagController, BaseActivity baseActivity, UwbScanDevice uwbScanDevice, O00000Oo o00000Oo, Device device2, String str, DialogInterface dialogInterface, int i) {
        BaseActivity baseActivity2 = baseActivity;
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(baseActivity2, "$activity");
        ixe.O00000o(o00000Oo, "$callback");
        ixe.O00000o(device2, "$device");
        ixe.O00000o(str, "$homeId");
        dialogInterface.dismiss();
        int i2 = 0;
        boolean z = device != null;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        T t = null;
        if (!z) {
            PluginDeviceManager pluginDeviceManager = PluginDeviceManager.instance;
            if (uwbScanDevice != null) {
                t = Long.valueOf(uwbScanDevice.getPid());
            }
            if (t != null) {
                i2 = (int) t.longValue();
            }
            t = hzq.O000000o(baseActivity2, pluginDeviceManager.getModelByProductId(i2), new O0000Oo(o00000Oo, objectRef, bindUwbTagController, uwbScanDevice, device, device2, str, baseActivity));
        }
        objectRef.element = t;
        if (objectRef.element == null) {
            o00000Oo.O000000o();
            bindUwbTagController.O000000o(uwbScanDevice, device, device2, str, o00000Oo);
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagController$startUwbBinder$1$1$1", "Lcom/xiaomi/smarthome/smartconfig/step/SmartConfigStep$StepListener;", "getHandler", "Landroid/os/Handler;", "onCurrentStepFinish", "", "currentStep", "Lcom/xiaomi/smarthome/smartconfig/step/SmartConfigStep$Step;", "nextStep", "onCurrentStepPause", "onFinishSmartConfig", "finishChoose", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo implements SmartConfigStep.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ O00000Oo f5720O000000o;
        final /* synthetic */ Ref.ObjectRef<Dialog> O00000Oo;
        final /* synthetic */ UwbScanDevice O00000o;
        final /* synthetic */ BindUwbTagController O00000o0;
        final /* synthetic */ Device O00000oO;
        final /* synthetic */ Device O00000oo;
        final /* synthetic */ String O0000O0o;
        final /* synthetic */ BaseActivity O0000OOo;

        public final void O000000o(SmartConfigStep.Step step) {
        }

        public final void O000000o(boolean z) {
        }

        public final void O00000Oo(SmartConfigStep.Step step) {
        }

        O0000Oo(O00000Oo o00000Oo, Ref.ObjectRef<Dialog> objectRef, BindUwbTagController bindUwbTagController, UwbScanDevice uwbScanDevice, Device device, Device device2, String str, BaseActivity baseActivity) {
            this.f5720O000000o = o00000Oo;
            this.O00000Oo = objectRef;
            this.O00000o0 = bindUwbTagController;
            this.O00000o = uwbScanDevice;
            this.O00000oO = device;
            this.O00000oo = device2;
            this.O0000O0o = str;
            this.O0000OOo = baseActivity;
        }

        public final void O000000o() {
            UwbLogUtil.d("BindUwbTagController", "showPopUpChooseStepDialog onCurrentStepFinish");
            this.f5720O000000o.O000000o();
            Dialog dialog = (Dialog) this.O00000Oo.element;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.O00000o0.O000000o(this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, this.f5720O000000o);
        }

        public final Handler O00000Oo() {
            Handler handler = this.O0000OOo.mHandler;
            ixe.O00000Oo(handler, "activity.mHandler");
            return handler;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(O00000Oo o00000Oo, DialogInterface dialogInterface, int i) {
        ixe.O00000o(o00000Oo, "$callback");
        dialogInterface.cancel();
        o00000Oo.O00000oO();
    }

    public static Observable<Integer> O000000o(String str, String str2) {
        UwbLogUtil.d("BindUwbTagController", "changeDeviceHomeTo: did " + str + ",homeId：" + str2);
        Home O00000o2 = ggb.O00000Oo().O00000o(str2);
        Device O0000OOo2 = fno.O000000o().O0000OOo(str);
        if (O00000o2 == null || O0000OOo2 == null) {
            StringBuilder sb = new StringBuilder("changeDeviceHomeTo: invalid params: home: ");
            sb.append(O00000o2);
            sb.append(",tag:");
            sb.append((Object) (O0000OOo2 == null ? null : O0000OOo2.did));
            UwbLogUtil.d("BindUwbTagController", sb.toString());
            Observable<Integer> just = Observable.just(1);
            ixe.O00000Oo(just, "just(1)");
            return just;
        }
        UwbLogUtil.d("BindUwbTagController", "changeDeviceHomeTo: home: " + O00000o2 + ",tag:" + ((Object) O0000OOo2.did));
        Observable<Integer> create = Observable.create(new ObservableOnSubscribe(O0000OOo2) {
            /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$1Yf_b2oXFuz12zLAzs1GffCWEDk */
            private final /* synthetic */ Device f$1;

            {
                this.f$1 = r2;
            }

            public final void subscribe(ObservableEmitter observableEmitter) {
                BindUwbTagController.O000000o(Home.this, this.f$1, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create<Int>{  emitter->\n            HomeManager.getInstance()\n                .bindDeviceToRoom(home, null, tagDevice, object : HomeManager.IHomeOperationCallback {\n                    override fun onSuccess() {\n                        UwbLogUtil.d(TAG,\"changeDeviceHomeTo success\")\n                        if(emitter.isDisposed){\n                            return\n                        }\n                        emitter.onNext(1)\n                        emitter.onComplete()\n                    }\n\n                    override fun onFail(errCode: Int, error: Error?) {\n                        UwbLogUtil.d(TAG,\"changeDeviceHomeTo fail : ${error}\")\n                        if(emitter.isDisposed){\n                            return\n                        }\n                        emitter.onError(ApiErrorWrapper(error))\n                    }\n            })\n        }");
        return create;
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagController$changeDeviceHomeTo$1$1", "Lcom/xiaomi/smarthome/homeroom/HomeManager$IHomeOperationCallback;", "onFail", "", "errCode", "", "error", "Lcom/xiaomi/smarthome/frame/Error;", "onSuccess", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo implements ggb.O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<Integer> f5719O000000o;

        O0000OOo(ObservableEmitter<Integer> observableEmitter) {
            this.f5719O000000o = observableEmitter;
        }

        public final void O000000o() {
            UwbLogUtil.d("BindUwbTagController", "changeDeviceHomeTo success");
            if (!this.f5719O000000o.isDisposed()) {
                this.f5719O000000o.onNext(1);
                this.f5719O000000o.onComplete();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, _m_j.fso]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void O000000o(int i, fso fso) {
            UwbLogUtil.d("BindUwbTagController", ixe.O000000o("changeDeviceHomeTo fail : ", (Object) fso));
            if (!this.f5719O000000o.isDisposed()) {
                this.f5719O000000o.onError(new ApiErrorWrapper(fso));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Home home, Device device, ObservableEmitter observableEmitter) {
        ixe.O00000o(observableEmitter, "emitter");
        ggb.O00000Oo().O000000o(home, (Room) null, device, new O0000OOo(observableEmitter));
    }

    public final void O000000o(UwbScanDevice uwbScanDevice, Device device, Device device2, String str, O00000Oo o00000Oo) {
        if (!this.O00000oo) {
            String O0000OOo2 = ggb.O00000Oo().O0000OOo();
            StringBuilder sb = new StringBuilder("start associate scanDevice: ");
            sb.append(uwbScanDevice);
            sb.append(", tagDevice:");
            sb.append((Object) (device == null ? null : device.did));
            sb.append(",device: ");
            sb.append((Object) device2.did);
            sb.append(",targetHomeId: ");
            sb.append(str);
            sb.append(",currentHomeId: ");
            sb.append((Object) O0000OOo2);
            UwbLogUtil.d("BindUwbTagController", sb.toString());
            hzs.O000000o(uwbScanDevice, device, device2, new O0000Oo0(o00000Oo, uwbScanDevice, str, O0000OOo2, this, device2));
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0017¨\u0006\r"}, d2 = {"com/smarthome/uwb/ui/bind/BindUwbTagController$startAssociate$1", "Lcom/xiaomi/smarthome/uwb_mijia/bind/UwbDeviceBinder$TagBinderCallback;", "onError", "", "code", "", "msg", "", "onProgress", "progress", "onSuccess", "o", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo0 implements hzs.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ O00000Oo f5721O000000o;
        final /* synthetic */ UwbScanDevice O00000Oo;
        final /* synthetic */ String O00000o;
        final /* synthetic */ String O00000o0;
        final /* synthetic */ BindUwbTagController O00000oO;
        final /* synthetic */ Device O00000oo;

        O0000Oo0(O00000Oo o00000Oo, UwbScanDevice uwbScanDevice, String str, String str2, BindUwbTagController bindUwbTagController, Device device) {
            this.f5721O000000o = o00000Oo;
            this.O00000Oo = uwbScanDevice;
            this.O00000o0 = str;
            this.O00000o = str2;
            this.O00000oO = bindUwbTagController;
            this.O00000oo = device;
        }

        public final void O000000o(int i, String str) {
            this.f5721O000000o.O000000o(i, str);
        }

        @SuppressLint({"CheckResult"})
        public final void O000000o(Object obj) {
            UwbLogUtil.d("BindUwbTagController", ixe.O000000o("startConfigBindTag onSuccess: ", obj));
            ddt ddt = ddt.f14518O000000o;
            Observable<R> flatMap = ddt.O000000o().onErrorReturnItem(new Intent()).delay(7, TimeUnit.SECONDS).flatMap($$Lambda$BindUwbTagController$O0000Oo0$SGhK30yk_PR6VF9_OO5VS5YuOh8.INSTANCE).flatMap(new Function(this.O00000o0, this.O00000o, obj, this.O00000oO) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$O0000Oo0$wqYniVBGiwvlsD0pID5SUbRypg */
                private final /* synthetic */ String f$1;
                private final /* synthetic */ String f$2;
                private final /* synthetic */ Object f$3;
                private final /* synthetic */ BindUwbTagController f$4;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final Object apply(Object obj) {
                    return BindUwbTagController.O0000Oo0.O000000o(UwbScanDevice.this, this.f$1, this.f$2, this.f$3, this.f$4, (ArrayList) obj);
                }
            });
            UwbScanDevice uwbScanDevice = this.O00000Oo;
            BindUwbTagController bindUwbTagController = this.O00000oO;
            O00000Oo o00000Oo = this.f5721O000000o;
            Device device = this.O00000oo;
            flatMap.subscribe(new Consumer(bindUwbTagController, o00000Oo, device) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$O0000Oo0$42QGkqJ85uptfWDABGxSztFAA4c */
                private final /* synthetic */ BindUwbTagController f$1;
                private final /* synthetic */ BindUwbTagController.O00000Oo f$2;
                private final /* synthetic */ Device f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void accept(Object obj) {
                    BindUwbTagController.O0000Oo0.O000000o(UwbScanDevice.this, this.f$1, this.f$2, this.f$3, (Serializable) obj);
                }
            }, new Consumer(obj, device) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$O0000Oo0$EdEWOXHAFofBvDEyFJ179SBgGw */
                private final /* synthetic */ Object f$1;
                private final /* synthetic */ Device f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void accept(Object obj) {
                    BindUwbTagController.O0000Oo0.O000000o(BindUwbTagController.O00000Oo.this, this.f$1, this.f$2, (Throwable) obj);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final ObservableSource O000000o(Intent intent) {
            ixe.O00000o(intent, "it");
            Set<String> O00000o02 = hzq.O00000o0();
            ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
            ixe.O00000Oo(O00000o02, "tags");
            return ddt.O0000O0o.O00000o0(O00000o02);
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
        public static final ObservableSource O000000o(UwbScanDevice uwbScanDevice, String str, String str2, Object obj, BindUwbTagController bindUwbTagController, ArrayList arrayList) {
            Observable<Integer> observable;
            String str3;
            ixe.O00000o(str, "$homeId");
            ixe.O00000o(bindUwbTagController, "this$0");
            ixe.O00000o(arrayList, "it");
            UwbLogUtil.d("BindUwbTagController", "startConfigBindTag uwbScanDevice " + uwbScanDevice + " ,homeId: " + str + " , currentHomeId " + ((Object) str2));
            if (uwbScanDevice != null) {
                if (obj instanceof ddt.O00000Oo) {
                    str3 = ((ddt.O00000Oo) obj).f14520O000000o;
                } else {
                    str3 = hzq.O00000oo(uwbScanDevice);
                }
                UwbLogUtil.d("BindUwbTagController", ixe.O000000o("startConfigBindTag tagDid ", (Object) str3));
                if (str3 != null) {
                    observable = BindUwbTagController.O000000o(str3, str).onErrorReturn($$Lambda$BindUwbTagController$O0000Oo0$o4_pr1gqsuq60xvJxXEGN1_yt6c.INSTANCE);
                    return observable;
                }
            }
            observable = Observable.just(arrayList);
            return observable;
        }

        /* access modifiers changed from: private */
        public static final Integer O000000o(Throwable th) {
            ixe.O00000o(th, "it");
            return 1;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Boolean]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* access modifiers changed from: private */
        public static final void O000000o(UwbScanDevice uwbScanDevice, BindUwbTagController bindUwbTagController, O00000Oo o00000Oo, Device device, Serializable serializable) {
            DidInfo didInfo;
            ixe.O00000o(bindUwbTagController, "this$0");
            ixe.O00000o(o00000Oo, "$callback");
            ixe.O00000o(device, "$device");
            JSONObject jSONObject = null;
            String O00000o02 = hzq.O00000o0((uwbScanDevice == null || (didInfo = uwbScanDevice.getDidInfo()) == null) ? null : didInfo.getDid());
            StringBuilder sb = new StringBuilder("onRefreshClientDeviceSuccess: get realDid: ");
            sb.append((Object) O00000o02);
            sb.append(" in deviceManager: ");
            sb.append(fno.O000000o().O000000o(O00000o02));
            sb.append(" , home ");
            Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo0 != null) {
                jSONObject = O0000Oo0.toJSON();
            }
            sb.append(jSONObject);
            sb.append(",size: ");
            sb.append(fno.O000000o().O00000oO().size());
            sb.append(",associate done, key retry will start:3s delay");
            UwbLogUtil.d("BindUwbTagController", sb.toString());
            ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
            boolean z = false;
            Iterator<ddt.O00000o0> it = ddt.O0000O0o.O00000Oo().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ddt.O00000o0 next = it.next();
                if (TextUtils.equals(next.f14521O000000o, bindUwbTagController.O00000Oo)) {
                    if (TextUtils.isEmpty(next.O00000o0)) {
                        z = true;
                    }
                }
            }
            UwbLogUtil.d("BindUwbTagController", ixe.O000000o("associate done, key retry=", (Object) Boolean.valueOf(z)));
            if (z) {
                ServiceApplication.getGlobalHandler().postDelayed(new Runnable(device) {
                    /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$O0000Oo0$FrccinjvBatOvpoDYhrB3KqO0OU */
                    private final /* synthetic */ Device f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        BindUwbTagController.O0000Oo0.O00000Oo(BindUwbTagController.O00000Oo.this, this.f$1);
                    }
                }, 3000);
                return;
            }
            o00000Oo.O00000Oo();
            PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(device.model);
            DeviceBindHelper.BindDeviceListener bindDeviceListener = UwbSdk.getBindDeviceListener();
            if (bindDeviceListener != null) {
                bindDeviceListener.onSuccess(CoreApi.O000000o().O0000o0(), device.did, pluginInfo.O00000o0());
            }
        }

        /* access modifiers changed from: private */
        public static final void O00000Oo(O00000Oo o00000Oo, Device device) {
            ixe.O00000o(o00000Oo, "$callback");
            ixe.O00000o(device, "$device");
            UwbLogUtil.d("BindUwbTagController", "associate done, key retry will start: 7s delay");
            ddt ddt = ddt.f14518O000000o;
            ddt.O000000o(new Runnable(device) {
                /* class com.smarthome.uwb.ui.bind.$$Lambda$BindUwbTagController$O0000Oo0$ltbD7EJk1rPmKsPTYrIiJJu6QzI */
                private final /* synthetic */ Device f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    BindUwbTagController.O0000Oo0.O000000o(BindUwbTagController.O00000Oo.this, this.f$1);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000Oo o00000Oo, Device device) {
            ixe.O00000o(o00000Oo, "$callback");
            ixe.O00000o(device, "$device");
            o00000Oo.O00000Oo();
            PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(device.model);
            DeviceBindHelper.BindDeviceListener bindDeviceListener = UwbSdk.getBindDeviceListener();
            if (bindDeviceListener != null) {
                bindDeviceListener.onSuccess(CoreApi.O000000o().O0000o0(), device.did, pluginInfo.O00000o0());
            }
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
        public static final void O000000o(O00000Oo o00000Oo, Object obj, Device device, Throwable th) {
            ixe.O00000o(o00000Oo, "$callback");
            ixe.O00000o(device, "$device");
            o00000Oo.O00000o();
            UwbLogUtil.d("BindUwbTagController", "onRefreshClientDeviceFailed: " + obj + ' ');
            UwbLogUtil.d("BindUwbTagController", ixe.O000000o("startAssociate onRefreshClientDeviceFailed size:", (Object) Integer.valueOf(fno.O000000o().O00000oO().size())));
            PluginDeviceInfo pluginInfo = PluginDeviceManager.instance.getPluginInfo(device.model);
            DeviceBindHelper.BindDeviceListener bindDeviceListener = UwbSdk.getBindDeviceListener();
            if (bindDeviceListener != null) {
                bindDeviceListener.onSuccess(CoreApi.O000000o().O0000o0(), device.did, pluginInfo.O00000o0());
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Integer]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void O00000Oo(int i, String str) {
            this.f5721O000000o.O00000o0();
            UwbLogUtil.e("BindUwbTagController", ixe.O000000o("startAssociate onError:", (Object) Integer.valueOf(i)));
            DeviceBindHelper.BindDeviceListener bindDeviceListener = UwbSdk.getBindDeviceListener();
            if (bindDeviceListener != null) {
                bindDeviceListener.onFail(i, str);
            }
        }
    }

    public static List<String> O00000Oo() {
        ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
        Iterable<ddt.O00000o0> O00000Oo2 = ddt.O0000O0o.O00000Oo();
        Collection arrayList = new ArrayList(iuo.O000000o(O00000Oo2, 10));
        for (ddt.O00000o0 o00000o0 : O00000Oo2) {
            arrayList.add(o00000o0.O00000Oo);
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static final List O000000o(ArrayList arrayList) {
        ixe.O00000o(arrayList, "it");
        Iterable<ddt.O00000o0> iterable = arrayList;
        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable, 10));
        for (ddt.O00000o0 o00000o0 : iterable) {
            arrayList2.add(o00000o0.O00000Oo);
        }
        return (List) arrayList2;
    }

    /* access modifiers changed from: private */
    public static final ObservableSource O000000o(BindUwbTagController bindUwbTagController, Intent intent) {
        ixe.O00000o(bindUwbTagController, "this$0");
        ixe.O00000o(intent, "it");
        Set<String> O00000o02 = hzq.O00000o0();
        ixe.O00000Oo(O00000o02, "getAllDidForUwbPermit()");
        List O00000oo2 = iuo.O00000oo(O00000o02);
        ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
        Observable map = ddt.O0000O0o.O00000o0(O00000oo2).map($$Lambda$BindUwbTagController$BILHrenixxICS00XH6FRy5jqTm0.INSTANCE);
        ixe.O00000Oo(map, "UwbTagApi.getTagDetailRemote(tags).map { it ->\n            it.map { it.dev_did }\n        }");
        return map;
    }
}
