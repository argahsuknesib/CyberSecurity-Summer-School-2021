package com.smarthome.uwb.ui.manager;

import _m_j.ddt;
import _m_j.ddw;
import _m_j.ez;
import _m_j.fa;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fi;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.ggb;
import _m_j.gqb;
import _m_j.gqg;
import _m_j.gwe;
import _m_j.hah;
import _m_j.hxi;
import _m_j.hzp;
import _m_j.hzq;
import _m_j.iuf;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.iuv;
import _m_j.ivk;
import _m_j.iwc;
import _m_j.ixe;
import _m_j.ixh;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceFactory;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.uwb.lib.utils.UwbLogUtil;
import com.xiaomi.smarthome.uwb.ui.widget.SHLoadingDialog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u001c\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u001c\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J\u0014\u0010\u0018\u001a\u00020\n2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0014J\b\u0010\u001b\u001a\u00020\nH\u0007J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001aJ\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020 J(\u0010!\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010'\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/smarthome/uwb/ui/manager/ManagerUwbTagController;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "disposes", "Lio/reactivex/disposables/CompositeDisposable;", "isDestroyed", "", "state", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel;", "init", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRemove", "context", "Landroid/content/Context;", "selected", "", "Lcom/smarthome/uwb/ui/manager/ManagerUwbViewModel$TagBindInfo;", "onRename", "selectItems", "refreshTagInfo", "homes", "", "refreshWithUpdateDevices", "showAssociateUwbWithDeviceFailedDialog", "deviceName", "showDeviceOfflineDialog", "device", "Lcom/xiaomi/smarthome/device/Device;", "showOfflineDialog", "name", "model", "detail", "", "showUnsupportChangeAssociatedDialog", "showUwbDeviceOfflineDialog", "showUwbPermissionDialog", "Landroid/app/Activity;", "Companion", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ManagerUwbTagController implements ez {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f5736O000000o = new O000000o((byte) 0);
    public ddw O00000Oo;
    private final CompositeDisposable O00000o = new CompositeDisposable();
    boolean O00000o0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/smarthome/uwb/ui/manager/ManagerUwbTagController$Companion;", "", "()V", "TAG", "", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(fa faVar) {
        ixe.O00000o(faVar, "owner");
        this.O00000o.clear();
        this.O00000o0 = true;
    }

    @SuppressLint({"CheckResult"})
    public final void O000000o() {
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
        ddt ddt = ddt.f14518O000000o;
        ddt.O000000o().onErrorReturnItem(new Intent()).subscribe(new Consumer(list2) {
            /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$AOnTS9xLgvQtjlMGXweZexYJTJk */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ManagerUwbTagController.O000000o(ManagerUwbTagController.this, this.f$1, (Intent) obj);
            }
        }, new Consumer(list2) {
            /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$rjokJ0_XfeDiSMGqxJ0yTl2k */
            private final /* synthetic */ List f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                ManagerUwbTagController.O000000o(ManagerUwbTagController.this, this.f$1, (Throwable) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ManagerUwbTagController managerUwbTagController, List list, Intent intent) {
        ixe.O00000o(managerUwbTagController, "this$0");
        ixe.O00000o(list, "$homes");
        UwbLogUtil.d("ManagerUwbTagController", "refreshWithUpdateDevices : onRefreshClientDeviceSuccess");
        managerUwbTagController.O000000o(list);
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
    public static final void O000000o(ManagerUwbTagController managerUwbTagController, List list, Throwable th) {
        ixe.O00000o(managerUwbTagController, "this$0");
        ixe.O00000o(list, "$homes");
        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshWithUpdateDevices : onRefreshClientDeviceFail ", (Object) th.getLocalizedMessage()));
        managerUwbTagController.O000000o(list);
    }

    public final void O000000o(List<String> list) {
        ixe.O00000o(list, "homes");
        if (!this.O00000o0) {
            if (list.isEmpty()) {
                UwbLogUtil.d("ManagerUwbTagController", "refreshTagInfo : request params is empty.");
                ddw ddw = this.O00000Oo;
                if (ddw != null) {
                    ddw.O00000Oo.postValue(null);
                } else {
                    ixe.O000000o("state");
                    throw null;
                }
            }
            UwbLogUtil.d("ManagerUwbTagController", "refreshTagInfotestUpdate : refresh with homeId : " + list + '.');
            Set<String> O00000o02 = hzq.O00000o0();
            if (O00000o02.isEmpty()) {
                UwbLogUtil.d("ManagerUwbTagController", "refreshTagInfoUpdate : tag is empty.");
                ddw ddw2 = this.O00000Oo;
                if (ddw2 != null) {
                    ddw2.O00000Oo.postValue(null);
                } else {
                    ixe.O000000o("state");
                    throw null;
                }
            } else {
                ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
                ixe.O00000Oo(O00000o02, "tags");
                this.O00000o.add(ddt.O0000O0o.O000000o(O00000o02).distinctUntilChanged().map(new Function(O00000o02) {
                    /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$DyvpnMM5JkKD28rl7VboaL8C5U */
                    private final /* synthetic */ Set f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final Object apply(Object obj) {
                        return ManagerUwbTagController.O000000o(this.f$0, (ArrayList) obj);
                    }
                }).subscribe(new Consumer() {
                    /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$6LgLFOCnInzdxYzEMrg4uRKb6k */

                    public final void accept(Object obj) {
                        ManagerUwbTagController.O000000o(ManagerUwbTagController.this, (List) obj);
                    }
                }, new Consumer() {
                    /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$he_NgGf9LAgd0pDR0ISFJM_lbM */

                    public final void accept(Object obj) {
                        ManagerUwbTagController.O000000o(ManagerUwbTagController.this, (Throwable) obj);
                    }
                }));
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.Set]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.ArrayList]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.Map]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List, com.smarthome.uwb.ui.manager.ManagerUwbTagController$O0000O0o]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.List]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
     arg types: [java.util.List, com.smarthome.uwb.ui.manager.ManagerUwbTagController$O00000o]
     candidates:
      _m_j.iuy.O000000o(java.util.List, int):T
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void */
    /* access modifiers changed from: private */
    public static final List O000000o(Set set, ArrayList arrayList) {
        String str;
        Iterator it;
        Object obj;
        String str2;
        String str3;
        boolean z;
        String id;
        ArrayList arrayList2 = arrayList;
        ixe.O00000o(arrayList2, "queryResults");
        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfoUpdate : tagId: ", (Object) set));
        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfoUpdate success: queryResults: ", (Object) arrayList2));
        Map linkedHashMap = new LinkedHashMap();
        Iterator it2 = arrayList2.iterator();
        while (true) {
            str = "";
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            Home O0000o0 = ggb.O00000Oo().O0000o0(((ddt.O00000o0) next).f14521O000000o);
            if (!(O0000o0 == null || (id = O0000o0.getId()) == null)) {
                str = id;
            }
            Object obj2 = linkedHashMap.get(str);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(str, obj2);
            }
            ((List) obj2).add(next);
        }
        Map linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Home O00000o2 = ggb.O00000Oo().O00000o((String) entry.getKey());
            if (ixe.O000000o(O00000o2 == null ? null : Boolean.valueOf(O00000o2.isOwner()), Boolean.TRUE)) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfoUpdate success: groupedQueryResultsMap: ", (Object) linkedHashMap2));
        List arrayList3 = new ArrayList();
        Iterator it3 = linkedHashMap2.entrySet().iterator();
        while (true) {
            int i = 1;
            if (!it3.hasNext()) {
                break;
            }
            Map.Entry entry2 = (Map.Entry) it3.next();
            String str4 = (String) entry2.getKey();
            List<ddt.O00000o0> list = (List) entry2.getValue();
            if (list.isEmpty() || ixe.O000000o((Object) str4, (Object) str)) {
                it = it3;
                UwbLogUtil.d("ManagerUwbTagController", "refreshTagInfoUpdate success: ignore: homeId: " + str4 + ",info size: " + list.size());
            } else {
                List arrayList4 = new ArrayList();
                for (ddt.O00000o0 o00000o0 : list) {
                    List<Device> O00000oo = fno.O000000o().O00000oo();
                    ixe.O00000Oo(O00000oo, "getInstance().extraDevices");
                    Iterator it4 = O00000oo.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it4.next();
                        if (ixe.O000000o((Object) ((Device) obj).did, (Object) o00000o0.f14521O000000o)) {
                            break;
                        }
                    }
                    Device device = (Device) obj;
                    Device O000000o2 = fno.O000000o().O000000o(o00000o0.O00000Oo);
                    if (device == null) {
                        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfoUpdate not find tag devices: : ", (Object) o00000o0.f14521O000000o));
                    } else {
                        String str5 = o00000o0.f14521O000000o;
                        String str6 = device.name;
                        String str7 = o00000o0.O00000Oo;
                        boolean z2 = o00000o0.O00000o == i;
                        boolean z3 = O000000o2 == null;
                        String str8 = O000000o2 == null ? null : O000000o2.name;
                        if (O000000o2 == null) {
                            str2 = null;
                        } else {
                            str2 = ggb.O00000Oo().O0000o0O(O000000o2.did);
                        }
                        String str9 = device.model;
                        if (O000000o2 == null) {
                            str3 = null;
                        } else {
                            str3 = O000000o2.model;
                        }
                        boolean z4 = device.isOnline;
                        if (O000000o2 == null) {
                            z = false;
                        } else {
                            z = O000000o2.isOnline;
                        }
                        ixe.O00000Oo(str6, "name");
                        ixe.O00000Oo(str9, "model");
                        Iterator it5 = it3;
                        List list2 = arrayList4;
                        list2.add(new ddw.O000000o(str5, str6, str7, z2, z3, str8, str2, str3, str9, z4, z, str4));
                        arrayList4 = list2;
                        it3 = it5;
                        i = 1;
                    }
                }
                it = it3;
                List list3 = arrayList4;
                if (!list3.isEmpty()) {
                    if (list3.size() > 1) {
                        iuo.O000000o(list3, (Comparator) new O0000O0o());
                    }
                    iuh iuh = iuh.f1631O000000o;
                    arrayList3.add(iuf.O000000o(str4, list3));
                }
            }
            it3 = it;
        }
        UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfotestUpdate result: : ", (Object) arrayList3));
        if (arrayList3.size() > 1) {
            iuo.O000000o(arrayList3, (Comparator) new O00000o());
        }
        return arrayList3;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O00000o<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o((String) ((Pair) t).first, (String) ((Pair) t2).first);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class O0000O0o<T> implements Comparator<T> {
        public final int compare(T t, T t2) {
            return ivk.O000000o(((ddw.O000000o) t).f14528O000000o, ((ddw.O000000o) t2).f14528O000000o);
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(ManagerUwbTagController managerUwbTagController, List list) {
        ixe.O00000o(managerUwbTagController, "this$0");
        ddw ddw = managerUwbTagController.O00000Oo;
        if (ddw != null) {
            ddw.O00000Oo.postValue(list);
        } else {
            ixe.O000000o("state");
            throw null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Throwable]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* access modifiers changed from: private */
    public static final void O000000o(ManagerUwbTagController managerUwbTagController, Throwable th) {
        ixe.O00000o(managerUwbTagController, "this$0");
        ddw ddw = managerUwbTagController.O00000Oo;
        if (ddw != null) {
            List value = ddw.O00000Oo.getValue();
            if (!ixe.O000000o(value == null ? null : Boolean.valueOf(!value.isEmpty()), Boolean.TRUE)) {
                ddw ddw2 = managerUwbTagController.O00000Oo;
                if (ddw2 != null) {
                    ddw2.O00000Oo.postValue(null);
                } else {
                    ixe.O000000o("state");
                    throw null;
                }
            }
            UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("refreshTagInfotestUpdate error : ", (Object) th));
            th.printStackTrace();
            return;
        }
        ixe.O000000o("state");
        throw null;
    }

    public final void O000000o(Context context, List<ddw.O000000o> list) {
        ixe.O00000o(context, "context");
        ixe.O00000o(list, "selected");
        if (!this.O00000o0) {
            String O000000o2 = iuo.O000000o(list, ixe.O000000o(ftn.O00000o0(context).getLanguage(), "zh") ? "、" : ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ManagerUwbTagController$onRemove$deleteDevices$1.f5740O000000o, 30);
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
            builder.O000000o(context.getString(R.string.uwb_delete_dialog_title));
            ixh ixh = ixh.f1644O000000o;
            String string = context.getString(R.string.uwb_delete_dialog_message);
            ixe.O00000Oo(string, "context.getString(R.string.uwb_delete_dialog_message)");
            String format = String.format(string, Arrays.copyOf(new Object[]{O000000o2}, 1));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            builder.O00000Oo(format);
            builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(context, list, this) {
                /* class com.smarthome.uwb.ui.manager.$$Lambda$ManagerUwbTagController$M1zfzf399HwoSMTwbrBlIZG2t8 */
                private final /* synthetic */ Context f$0;
                private final /* synthetic */ List f$1;
                private final /* synthetic */ ManagerUwbTagController f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ManagerUwbTagController.O000000o(this.f$0, this.f$1, this.f$2, dialogInterface, i);
                }
            });
            builder.O00000Oo((int) R.string.sh_common_cancel, $$Lambda$ManagerUwbTagController$k14a34TYJTiARtCh3HIjsdeSI2I.INSTANCE);
            builder.O000000o(true);
            builder.O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(Context context, List list, ManagerUwbTagController managerUwbTagController, DialogInterface dialogInterface, int i) {
        ixe.O00000o(context, "$context");
        ixe.O00000o(list, "$selected");
        ixe.O00000o(managerUwbTagController, "this$0");
        String string = context.getString(R.string.mj_loading);
        ixe.O00000Oo(string, "context.getString(R.string.mj_loading)");
        SHLoadingDialog sHLoadingDialog = new SHLoadingDialog(context, string, false, null, null, 24, null);
        sHLoadingDialog.show();
        fno O000000o2 = fno.O000000o();
        Iterable<ddw.O000000o> iterable = list;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (ddw.O000000o o000000o : iterable) {
            arrayList.add(o000000o.f14528O000000o);
        }
        O000000o2.O000000o((List) arrayList, context, new O00000Oo(list, sHLoadingDialog, managerUwbTagController, context));
        dialogInterface.dismiss();
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"com/smarthome/uwb/ui/manager/ManagerUwbTagController$onRemove$1$1$2", "Lcom/xiaomi/smarthome/device/SmartHomeDeviceManager$IDelDeviceBatchCallback;", "onFailure", "", "error", "Lcom/xiaomi/smarthome/frame/Error;", "onSuccess", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo implements fno.O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ List<ddw.O000000o> f5737O000000o;
        final /* synthetic */ SHLoadingDialog O00000Oo;
        final /* synthetic */ Context O00000o;
        final /* synthetic */ ManagerUwbTagController O00000o0;

        O00000Oo(List<ddw.O000000o> list, SHLoadingDialog sHLoadingDialog, ManagerUwbTagController managerUwbTagController, Context context) {
            this.f5737O000000o = list;
            this.O00000Oo = sHLoadingDialog;
            this.O00000o0 = managerUwbTagController;
            this.O00000o = context;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.util.List]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void O000000o() {
            Iterable<ddw.O000000o> iterable = this.f5737O000000o;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (ddw.O000000o o000000o : iterable) {
                arrayList.add(o000000o.f14528O000000o);
            }
            UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("onRemove success : ", (Object) ((List) arrayList)));
            this.O00000Oo.dismiss();
            ddw ddw = this.O00000o0.O00000Oo;
            if (ddw != null) {
                ddw.f14527O000000o.postValue(Boolean.FALSE);
                gqg.O00000Oo(this.O00000o.getResources().getQuantityString(R.plurals.uwb_bind_info_remove_success, this.f5737O000000o.size(), Integer.valueOf(this.f5737O000000o.size())));
                Iterable<ddw.O000000o> iterable2 = this.f5737O000000o;
                Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
                for (ddw.O000000o o000000o2 : iterable2) {
                    arrayList2.add(o000000o2.f14528O000000o);
                }
                List<String> list = (List) arrayList2;
                StringBuilder sb = new StringBuilder("onRemove success extras begin : ");
                List<Device> O00000oo = fno.O000000o().O00000oo();
                ixe.O00000Oo(O00000oo, "getInstance().extraDevices");
                Iterable<Device> iterable3 = O00000oo;
                Collection arrayList3 = new ArrayList(iuo.O000000o(iterable3, 10));
                for (Device device : iterable3) {
                    arrayList3.add(device.did);
                }
                sb.append((List) arrayList3);
                sb.append('}');
                UwbLogUtil.d("ManagerUwbTagController", sb.toString());
                List<Device> O00000oo2 = fno.O000000o().O00000oo();
                ixe.O00000Oo(O00000oo2, "getInstance().extraDevices");
                iwc managerUwbTagController$onRemove$1$1$2$onSuccess$3 = new ManagerUwbTagController$onRemove$1$1$2$onSuccess$3(list);
                ixe.O00000o0(O00000oo2, "receiver$0");
                ixe.O00000o0(managerUwbTagController$onRemove$1$1$2$onSuccess$3, "predicate");
                iuv.O000000o(O00000oo2, managerUwbTagController$onRemove$1$1$2$onSuccess$3);
                StringBuilder sb2 = new StringBuilder("onRemove success extras  end : ");
                List<Device> O00000oo3 = fno.O000000o().O00000oo();
                ixe.O00000Oo(O00000oo3, "getInstance().extraDevices");
                Iterable<Device> iterable4 = O00000oo3;
                Collection arrayList4 = new ArrayList(iuo.O000000o(iterable4, 10));
                for (Device device2 : iterable4) {
                    arrayList4.add(device2.did);
                }
                sb2.append((List) arrayList4);
                sb2.append('}');
                UwbLogUtil.d("ManagerUwbTagController", sb2.toString());
                for (String O00000Oo2 : list) {
                    ddt.O0000O0o o0000O0o = ddt.O0000O0o.f14522O000000o;
                    ddt.O0000O0o.O00000Oo(O00000Oo2);
                }
                this.O00000o0.O000000o();
                return;
            }
            ixe.O000000o("state");
            throw null;
        }

        public final void O000000o(fso fso) {
            this.O00000Oo.dismiss();
            ddw ddw = this.O00000o0.O00000Oo;
            if (ddw != null) {
                ddw.f14527O000000o.postValue(Boolean.FALSE);
                StringBuilder sb = new StringBuilder("onRemove onFailure: ");
                Iterable<ddw.O000000o> iterable = this.f5737O000000o;
                Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
                for (ddw.O000000o o000000o : iterable) {
                    arrayList.add(o000000o.f14528O000000o);
                }
                sb.append((List) arrayList);
                sb.append(", ");
                sb.append(fso);
                UwbLogUtil.e("ManagerUwbTagController", sb.toString());
                gqg.O00000Oo((int) R.string.action_fail);
                return;
            }
            ixe.O000000o("state");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void O00000Oo(Context context, List<ddw.O000000o> list) {
        Object obj;
        ixe.O00000o(context, "context");
        ixe.O00000o(list, "selectItems");
        if (!this.O00000o0) {
            ddw.O000000o o000000o = list.get(0);
            List<Device> O00000oo = fno.O000000o().O00000oo();
            ixe.O00000Oo(O00000oo, "getInstance().extraDevices");
            Iterator it = O00000oo.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (ixe.O000000o((Object) ((Device) obj).did, (Object) o000000o.f14528O000000o)) {
                    break;
                }
            }
            Device device = (Device) obj;
            if (device == null) {
                gqg.O00000Oo((int) R.string.action_fail);
                O000000o();
                return;
            }
            hxi.O0000o00.f954O000000o.O000000o("uwb_rename_dialog_show", new Object[0]);
            hah.O000000o(context, o000000o.O00000Oo, context.getResources().getString(R.string.menu_edit_rename), "", new O00000o0(this, device, context));
        }
    }

    public static final String O00000Oo(Context context, String str) {
        if (!(str.length() > 0)) {
            return null;
        }
        if (gqb.O00000o0(str)) {
            return context.getString(R.string.tag_save_data_description);
        }
        if (!ggb.O0000oO(str)) {
            return context.getString(R.string.room_name_too_long);
        }
        return null;
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/smarthome/uwb/ui/manager/ManagerUwbTagController$onRename$1", "Lcom/xiaomi/smarthome/newui/NameEditDialogHelper$NameEditListener;", "onConfirm", "", "name", "", "onTextChanged", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 implements hah.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ManagerUwbTagController f5738O000000o;
        final /* synthetic */ Device O00000Oo;
        final /* synthetic */ Context O00000o0;

        O00000o0(ManagerUwbTagController managerUwbTagController, Device device, Context context) {
            this.f5738O000000o = managerUwbTagController;
            this.O00000Oo = device;
            this.O00000o0 = context;
        }

        public final void O000000o(String str) {
            ixe.O00000o(str, "name");
            ddw ddw = this.f5738O000000o.O00000Oo;
            if (ddw != null) {
                ddw.f14527O000000o.postValue(Boolean.FALSE);
                gwe.O000000o();
                Device device = this.O00000Oo;
                gwe.O000000o(device, str, new O000000o(device, str, this.f5738O000000o));
                return;
            }
            ixe.O000000o("state");
            throw null;
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/smarthome/uwb/ui/manager/ManagerUwbTagController$onRename$1$onConfirm$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Ljava/lang/Void;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "uwb-mijia_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o extends fsm<Void, fso> {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Device f5739O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ ManagerUwbTagController O00000o0;

            O000000o(Device device, String str, ManagerUwbTagController managerUwbTagController) {
                this.f5739O000000o = device;
                this.O00000Oo = str;
                this.O00000o0 = managerUwbTagController;
            }

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
             arg types: [java.lang.String, _m_j.fso]
             candidates:
              _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
              _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
              _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
              _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
            public final void onFailure(fso fso) {
                ddw ddw = this.O00000o0.O00000Oo;
                if (ddw != null) {
                    ddw.f14527O000000o.postValue(Boolean.FALSE);
                    gqg.O00000Oo((int) R.string.action_fail);
                    UwbLogUtil.d("ManagerUwbTagController", ixe.O000000o("onEdit onFailure: ", (Object) fso));
                    return;
                }
                ixe.O000000o("state");
                throw null;
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                this.f5739O000000o.name = this.O00000Oo;
                ddw ddw = this.O00000o0.O00000Oo;
                if (ddw != null) {
                    ddw.f14527O000000o.postValue(Boolean.FALSE);
                    gqg.O00000Oo((int) R.string.action_success);
                    this.O00000o0.O000000o();
                    return;
                }
                ixe.O000000o("state");
                throw null;
            }
        }

        public final String O00000Oo(String str) {
            ixe.O00000o(str, "name");
            return ManagerUwbTagController.O00000Oo(this.O00000o0, str);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(Context context, String str, String str2) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "name");
        ixe.O00000o(str2, "model");
        if (!this.O00000o0) {
            String string = context.getString(R.string.uwb_offline_dialog_message);
            ixe.O00000Oo(string, "context.getString(R.string.uwb_offline_dialog_message)");
            CharSequence charSequence = string;
            if (!this.O00000o0) {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
                builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
                View inflate = LayoutInflater.from(context).inflate((int) R.layout.uwb_offline_dialog, (ViewGroup) null, false);
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) inflate.findViewById(R.id.icon);
                TextView textView = (TextView) inflate.findViewById(R.id.device_name);
                TextView textView2 = (TextView) inflate.findViewById(R.id.desc);
                String O0000oOO = DeviceFactory.O0000oOO(str2);
                if (O0000oOO == null) {
                    O0000oOO = "";
                }
                if (O0000oOO.length() == 0) {
                    DeviceFactory.O00000Oo(str2, simpleDraweeView);
                } else {
                    DeviceFactory.O000000o(O0000oOO, simpleDraweeView);
                }
                ixh ixh = ixh.f1644O000000o;
                String string2 = context.getString(R.string.uwb_device_offline);
                ixe.O00000Oo(string2, "context.getString(R.string.uwb_device_offline)");
                String format = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
                ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
                textView.setText(format);
                textView2.setText(charSequence);
                if (charSequence instanceof SpannableString) {
                    textView2.setHighlightColor(0);
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                }
                builder.O000000o(inflate);
                builder.O00000o0((int) R.string.mj_i_know, $$Lambda$ManagerUwbTagController$SAB9WMGlt6qOdc2tvb8KVzgsuAI.INSTANCE);
                builder.O000000o(true);
                builder.O00000oo();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, ?[OBJECT, ARRAY], int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final void O000000o(Context context, String str) {
        ixe.O00000o(context, "context");
        ixe.O00000o(str, "deviceName");
        if (!this.O00000o0) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
            builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
            builder.O000000o((int) R.string.mj_uwb_change_uwb_associate_device_failed);
            View inflate = LayoutInflater.from(context).inflate((int) R.layout.uwb_associate_failed, (ViewGroup) null, false);
            ixh ixh = ixh.f1644O000000o;
            String string = context.getString(R.string.uwb_associate_message);
            ixe.O00000Oo(string, "context.getString(R.string.uwb_associate_message)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            ((TextView) inflate.findViewById(R.id.desc)).setText(format);
            builder.O000000o(inflate);
            builder.O00000o0((int) R.string.mj_i_know, $$Lambda$ManagerUwbTagController$m1ou91cLaNAnPsxjTUyK2GjmCM.INSTANCE);
            builder.O000000o(true);
            builder.O00000oo();
        }
    }

    /* access modifiers changed from: private */
    public static final void O00000o0(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public static void O000000o(Context context) {
        ixe.O00000o(context, "context");
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(context);
        builder.O000000o(context.getString(R.string.uwb_bind_unsupport_title));
        builder.O00000Oo(context.getString(R.string.uwb_bind_unsupport_msg));
        builder.O000000o((int) R.string.mj_uwb_see_help, $$Lambda$ManagerUwbTagController$riEJpXkW_O6dnnzYDMobwyKmqn0.INSTANCE);
        builder.O00000Oo((int) R.string.mj_i_know, $$Lambda$ManagerUwbTagController$0zEVXqowhvEVOpv2zd2XWAxZYc.INSTANCE);
        builder.O000000o(true);
        builder.O00000oo();
    }

    /* access modifiers changed from: private */
    public static final void O00000o(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        fbt fbt = new fbt(CommonApplication.getAppContext(), "OperationCommonWebViewActivity");
        hzp hzp = hzp.f1018O000000o;
        fbt.O000000o("url", hzp.O000000o("https://home.mi.com/views/article.html?articleId=561479692000000001"));
        fbt.O00000Oo(268435456);
        fbs.O000000o(fbt);
    }

    /* access modifiers changed from: private */
    public static final void O00000oO(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
