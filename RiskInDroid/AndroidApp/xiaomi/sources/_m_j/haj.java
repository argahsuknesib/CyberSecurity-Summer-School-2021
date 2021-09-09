package _m_j;

import _m_j.gzq;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.GridViewData;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.OnPageChangeListenerWithIdleType;
import com.xiaomi.smarthome.newui.RoomDeviceRecycler;
import com.xiaomi.smarthome.newui.RoomPagerAdapter$dump$1$3;
import com.xiaomi.smarthome.newui.RoomPagerAdapter$renderPage$shouldChangeToMainAdPage$1;
import com.xiaomi.smarthome.newui.RoomPagerAdapter$resetAllView$$inlined$filterIsInstance$1;
import com.xiaomi.smarthome.newui.adapter.DeviceMainLoadingAdapter;
import com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter;
import com.xiaomi.smarthome.newui.adapter.MainCameraCardModel;
import com.xiaomi.smarthome.newui.mainpage.devicepage.model.MainPageDeviceModel;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DeviceRoomRenderState;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 S2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001SB#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020#J\u0006\u0010)\u001a\u00020'J%\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020,2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0011H\u0016J\b\u00102\u001a\u00020/H\u0016J\u0010\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0011J\u000e\u00106\u001a\u00020/2\u0006\u00105\u001a\u00020\u0011J\u0010\u00107\u001a\u00020\u00112\b\u00108\u001a\u0004\u0018\u00010/J \u00109\u001a\u00020'2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0014J\u0010\u0010>\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J\"\u0010?\u001a\u00020'2\b\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010A\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u0011H\u0014J\u000e\u0010C\u001a\u00020'2\u0006\u0010(\u001a\u00020#J\u000e\u0010D\u001a\u00020'2\u0006\u0010E\u001a\u00020\u001aJB\u0010F\u001a\u00020'2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010H\u001a\u0002042\f\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\u00172\f\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u00172\f\u0010M\u001a\b\u0012\u0004\u0012\u00020N0\u0017H\u0002J\b\u0010O\u001a\u00020'H\u0002J \u0010P\u001a\u00020'2\u0006\u0010:\u001a\u00020;2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010Q\u001a\u00020RH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006T"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomPagerAdapter;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/SimplePageAdapter;", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "Lcom/xiaomi/smarthome/Dumpable;", "context", "Landroid/content/Context;", "viewPager", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;", "editActionRef", "Ljava/lang/ref/WeakReference;", "Lcom/xiaomi/smarthome/newui/DeviceListPageActionInterface;", "(Landroid/content/Context;Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;Ljava/lang/ref/WeakReference;)V", "getContext", "()Landroid/content/Context;", "currentHome", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "currentPosition", "", "getCurrentPosition", "()I", "setCurrentPosition", "(I)V", "currentRooms", "", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/RoomRenderData;", "currentState", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "offsetHelper", "Lcom/xiaomi/smarthome/newui/RecyclerViewOffsetHelper;", "getOffsetHelper", "()Lcom/xiaomi/smarthome/newui/RecyclerViewOffsetHelper;", "primaryItemChangeListeners", "", "Lcom/xiaomi/smarthome/newui/IOnPrimaryItemChanged;", "getViewPager", "()Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;", "addOnPrimaryChangedListener", "", "listener", "dispose", "dump", "pw", "Ljava/io/PrintWriter;", "args", "", "", "(Ljava/io/PrintWriter;[Ljava/lang/String;)V", "getCount", "getDumpTag", "getPageBeanOfIndex", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "index", "getRoomBgNameOfIndex", "indexOfRoomId", "roomId", "onBindView", "container", "Landroid/view/ViewGroup;", "view", "position", "onCreateNewInstance", "onPrimaryItemChanged", "old", "current", "pos", "removeOnPrimaryChangedListener", "render", "state", "renderPage", "recycler", "page", "devices", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "commonScenes", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "freqCameras", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "resetAllView", "setPrimaryItem", "obj", "", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class haj extends hie<RoomDeviceRecycler> implements exv {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18704O000000o = new O000000o((byte) 0);
    public final MyViewPager O00000Oo;
    public Home O00000o;
    final hai O00000o0 = new hai();
    public DeviceRoomRenderState O00000oO;
    public List<hid> O00000oo;
    public int O0000O0o;
    private final Context O0000Oo;
    private final WeakReference<gzr> O0000OoO;
    private final CompositeDisposable O0000Ooo = new CompositeDisposable();
    private final List<haa> O0000o00 = new ArrayList();

    public final String O000000o() {
        return "RoomPagerAdapter";
    }

    public final /* synthetic */ View O000000o(Context context) {
        ixe.O00000o(context, "context");
        return new RoomDeviceRecycler(context, null, 6, (byte) 0);
    }

    public final /* synthetic */ void O000000o(View view, View view2, int i) {
        String str;
        hid hid;
        RoomDeviceRecycler roomDeviceRecycler = (RoomDeviceRecycler) view;
        RoomDeviceRecycler roomDeviceRecycler2 = (RoomDeviceRecycler) view2;
        ixe.O00000o(roomDeviceRecycler2, "current");
        for (haa O000000o2 : this.O0000o00) {
            O000000o2.O000000o(roomDeviceRecycler, roomDeviceRecycler2, i);
        }
        if (roomDeviceRecycler != null) {
            hai hai = this.O00000o0;
            RecyclerView recyclerView = roomDeviceRecycler;
            String obj = roomDeviceRecycler.getTag().toString();
            ixe.O00000o(recyclerView, "recycler");
            CharSequence charSequence = obj;
            if (!(charSequence == null || charSequence.length() == 0)) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    View childAt = linearLayoutManager.getChildAt(0);
                    if (childAt != null) {
                        hai.f18703O000000o.put(obj, new Pair(Integer.valueOf(linearLayoutManager.getPosition(childAt)), Integer.valueOf(childAt.getTop())));
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                }
            }
        }
        ggb O00000Oo2 = ggb.O00000Oo();
        ggb O00000Oo3 = ggb.O00000Oo();
        List<hid> list = this.O00000oo;
        PageBean pageBean = null;
        if (!(list == null || (hid = list.get(i)) == null)) {
            pageBean = hid.f18959O000000o;
        }
        String str2 = "";
        if (!(pageBean == null || (str = pageBean.O00000Oo) == null)) {
            str2 = str;
        }
        O00000Oo2.O0000o0 = O00000Oo3.O00000o0(str2);
    }

    public final /* synthetic */ void O000000o(ViewGroup viewGroup, View view, int i) {
        Pair pair;
        RoomDeviceRecycler roomDeviceRecycler = (RoomDeviceRecycler) view;
        ixe.O00000o(viewGroup, "container");
        ixe.O00000o(roomDeviceRecycler, "view");
        DeviceRoomRenderState deviceRoomRenderState = this.O00000oO;
        if (!ixe.O000000o(deviceRoomRenderState, DeviceRoomRenderState.LoadingState.f10364O000000o)) {
            if (ixe.O000000o(deviceRoomRenderState, DeviceRoomRenderState.LogoutState.f10365O000000o)) {
                roomDeviceRecycler.O000000o();
                O00000o0();
                return;
            } else if (deviceRoomRenderState instanceof DeviceRoomRenderState.DeviceRoomState) {
                List<hid> list = this.O00000oo;
                hid hid = list == null ? null : list.get(i);
                if (hid != null) {
                    DeviceRoomRenderState.DeviceRoomState deviceRoomState = (DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState;
                    O000000o(roomDeviceRecycler, hid.f18959O000000o, hid.O00000Oo.invoke(), deviceRoomState.O00000o0, deviceRoomState.O00000o);
                    hai hai = this.O00000o0;
                    RecyclerView recyclerView = roomDeviceRecycler;
                    String obj = roomDeviceRecycler.getTag().toString();
                    ixe.O00000o(recyclerView, "recycler");
                    CharSequence charSequence = obj;
                    if (!(charSequence == null || charSequence.length() == 0) && (pair = hai.f18703O000000o.get(obj)) != null) {
                        int intValue = ((Number) pair.first).intValue();
                        int intValue2 = ((Number) pair.second).intValue();
                        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                        if (layoutManager != null) {
                            ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(intValue, intValue2);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                    return;
                }
                return;
            } else if (ServiceApplication.getStateNotifier().f15923O000000o == 3) {
                roomDeviceRecycler.O000000o();
                return;
            }
        }
        gsy.O00000Oo(LogType.MAIN_PAGE, "RoomDeviceRecycler", "changeToLoading");
        if (roomDeviceRecycler.O00000Oo != RoomDeviceRecycler.DisplayMode.LOADING) {
            roomDeviceRecycler.O00000Oo = RoomDeviceRecycler.DisplayMode.LOADING;
            gzl gzl = new gzl();
            gzl.O000000o(new DeviceMainLoadingAdapter(roomDeviceRecycler.getContext()));
            roomDeviceRecycler.setAdapter(gzl);
            PageBean.O000000o o000000o = PageBean.CREATOR;
            roomDeviceRecycler.setTag(PageBean.O000000o.O000000o().O00000Oo);
        }
    }

    public haj(Context context, MyViewPager myViewPager, WeakReference<gzr> weakReference) {
        ixe.O00000o(context, "context");
        ixe.O00000o(myViewPager, "viewPager");
        ixe.O00000o(weakReference, "editActionRef");
        this.O0000Oo = context;
        this.O00000Oo = myViewPager;
        this.O0000OoO = weakReference;
        this.O00000Oo.addOnPageChangeListener(new OnPageChangeListenerWithIdleType(this) {
            /* class _m_j.haj.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ haj f18705O000000o;

            {
                this.f18705O000000o = r1;
            }

            public final void O000000o(OnPageChangeListenerWithIdleType.Reason reason) {
                hid hid;
                OnPageChangeListenerWithIdleType.Reason reason2 = reason;
                ixe.O00000o(reason2, "reason");
                if (reason2 == OnPageChangeListenerWithIdleType.Reason.Click) {
                    List<hid> list = this.f18705O000000o.O00000oo;
                    if (list == null) {
                        hid = null;
                    } else {
                        hid = list.get(this.f18705O000000o.O00000Oo.getCurrentItem());
                    }
                    if (hid != null) {
                        PageBean pageBean = hid.f18959O000000o;
                        hxk hxk = hxi.O00000o;
                        long currentTimeMillis = System.currentTimeMillis();
                        String O0000o0 = CoreApi.O000000o().O0000o0();
                        String str = pageBean.f10340O000000o;
                        int currentItem = this.f18705O000000o.O00000Oo.getCurrentItem();
                        List<hid> list2 = this.f18705O000000o.O00000oo;
                        hxk.f952O000000o.O000000o("home.tab.room.clk", "time", Long.valueOf(currentTimeMillis), "uid", O0000o0, "name", str, "number", Integer.valueOf(currentItem), "total number", Integer.valueOf(list2 == null ? 0 : list2.size()));
                        return;
                    }
                    return;
                }
                hxu hxu = hxi.O0000OoO;
                long currentTimeMillis2 = System.currentTimeMillis();
                String O0000o02 = CoreApi.O000000o().O0000o0();
                List<hid> list3 = this.f18705O000000o.O00000oo;
                hxu.f961O000000o.O000000o("home.tab.room.slide", "time", Long.valueOf(currentTimeMillis2), "uid", O0000o02, "total number", Integer.valueOf(list3 == null ? 0 : list3.size()));
            }
        });
        CompositeDisposable compositeDisposable = this.O0000Ooo;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        compositeDisposable.add(gzq.O00000Oo.subscribe(new Consumer() {
            /* class _m_j.$$Lambda$haj$5DzRChTavg7braSUWhuXNOvoTM */

            public final void accept(Object obj) {
                haj.O000000o(haj.this, (Intent) obj);
            }
        }));
        eyg eyg = eyg.f15944O000000o;
        eyg.O000000o(this);
        this.O0000O0o = -1;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomPagerAdapter$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(haj haj, Intent intent) {
        ixe.O00000o(haj, "this$0");
        haj.O00000o0();
    }

    public final int getCount() {
        DeviceRoomRenderState deviceRoomRenderState = this.O00000oO;
        if (deviceRoomRenderState instanceof DeviceRoomRenderState.DeviceRoomState) {
            return ((DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState).O00000Oo.size();
        }
        return 1;
    }

    public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        ixe.O00000o(viewGroup, "container");
        ixe.O00000o(obj, "obj");
        super.setPrimaryItem(viewGroup, i, obj);
        if (this.O0000O0o != i) {
            this.O0000O0o = i;
        }
    }

    private final void O00000o0() {
        this.O00000o0.O000000o(null);
        Iterator O000000o2 = iye.O000000o(gzw.O000000o(this.O00000Oo), RoomPagerAdapter$resetAllView$$inlined$filterIsInstance$1.f10123O000000o).O000000o();
        while (O000000o2.hasNext()) {
            RecyclerView.LayoutManager layoutManager = ((RecyclerView) O000000o2.next()).getLayoutManager();
            if (layoutManager != null) {
                layoutManager.scrollToPosition(0);
            }
        }
    }

    public final String O000000o(int i) {
        String str;
        hid hid;
        List<hid> list = this.O00000oo;
        PageBean pageBean = null;
        if (!(list == null || (hid = list.get(i)) == null)) {
            pageBean = hid.f18959O000000o;
        }
        return (pageBean == null || (str = pageBean.O00000o) == null) ? "style_1_favorites" : str;
    }

    public final void O000000o(haa haa) {
        ixe.O00000o(haa, "listener");
        if (!this.O0000o00.contains(haa)) {
            this.O0000o00.add(haa);
        }
    }

    public final void O00000Oo(haa haa) {
        ixe.O00000o(haa, "listener");
        this.O0000o00.remove(haa);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O000000o(java.util.List, int):T
     arg types: [java.util.List<_m_j.hid>, int]
     candidates:
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O000000o(java.lang.Iterable, java.util.Comparator):java.util.List<T>
      _m_j.iuy.O000000o(java.lang.Iterable, java.lang.Object):boolean
      _m_j.iuv.O000000o(java.util.Collection, java.lang.Iterable):boolean
      _m_j.iuv.O000000o(java.util.List, _m_j.iwc):boolean
      _m_j.iuu.O000000o(java.util.List, java.util.Comparator):void
      _m_j.iur.O000000o(java.lang.Iterable, int):int
      _m_j.iuy.O000000o(java.util.List, int):T */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Boolean]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void O000000o(PrintWriter printWriter, String[] strArr) {
        String str;
        PageBean pageBean;
        Class<?> cls;
        ixe.O00000o(printWriter, "pw");
        ixe.O00000o(strArr, "args");
        printWriter.println(ixe.O000000o("AppStateNotifier state: ", (Object) Integer.valueOf(ServiceApplication.getStateNotifier().f15923O000000o)));
        StringBuilder sb = new StringBuilder("currentHome: id:  ");
        Home home = this.O00000o;
        Integer num = null;
        sb.append((Object) (home == null ? null : home.getId()));
        sb.append(" , name : ");
        ggb.O00000Oo();
        sb.append((Object) ggb.O000000o(this.O00000o));
        printWriter.println(sb.toString());
        DeviceRoomRenderState deviceRoomRenderState = this.O00000oO;
        printWriter.println(ixe.O000000o("currentState: ", (Object) ((deviceRoomRenderState == null || (cls = deviceRoomRenderState.getClass()) == null) ? null : cls.getSimpleName())));
        List<GridViewData> O0000o0 = ggb.O00000Oo().O0000o0();
        ixe.O00000Oo(O0000o0, "getInstance().commonUseDevices");
        Iterable<GridViewData> iterable = O0000o0;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (GridViewData gridViewData : iterable) {
            arrayList.add(gridViewData.O00000Oo.did);
        }
        printWriter.println(ixe.O000000o("commonUseDevices: ", (Object) iuo.O000000o((List) arrayList, " , ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (iwc) null, 62)));
        List<GridViewData> O0000o0O = ggb.O00000Oo().O0000o0O();
        ixe.O00000Oo(O0000o0O, "getInstance().unCommonUseDevices");
        Iterable<GridViewData> iterable2 = O0000o0O;
        Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
        for (GridViewData gridViewData2 : iterable2) {
            arrayList2.add(gridViewData2.O00000Oo.did);
        }
        printWriter.println(ixe.O000000o("unCommonUseDevices: ", (Object) iuo.O000000o((List) arrayList2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, RoomPagerAdapter$dump$1$3.f10124O000000o, 31)));
        DeviceRoomRenderState deviceRoomRenderState2 = this.O00000oO;
        if (deviceRoomRenderState2 instanceof DeviceRoomRenderState.DeviceRoomState) {
            printWriter.println("all render room begin >");
            DeviceRoomRenderState.DeviceRoomState deviceRoomState = (DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState2;
            for (hid next : deviceRoomState.O00000Oo) {
                printWriter.println("all render room name: " + next.f18959O000000o.f10340O000000o + " size: " + next.O00000Oo.invoke().size() + ' ');
            }
            printWriter.println("all render room end <");
            hid hid = (hid) iuo.O000000o((List) deviceRoomState.O00000Oo, this.O00000Oo.getCurrentItem());
            if (hid == null || (pageBean = hid.f18959O000000o) == null) {
                str = null;
            } else {
                str = pageBean.f10340O000000o;
            }
            printWriter.println(ixe.O000000o("current render room name: ", (Object) str));
        }
        printWriter.println(ixe.O000000o("isHomeManagerInit: ", (Object) Boolean.valueOf(ggb.O00000Oo().O0000OoO.O00000oo)));
        printWriter.println(ixe.O000000o("isDeviceManagerInit: ", (Object) Boolean.valueOf(fno.O000000o().O0000o00())));
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        printWriter.println(ixe.O000000o("device count : ", (Object) (O0000O0o2 == null ? null : Integer.valueOf(O0000O0o2.size()))));
        Map<String, PluginDeviceInfo> pluginInfoMap = PluginDeviceManager.instance.getPluginInfoMap();
        if (pluginInfoMap != null) {
            num = Integer.valueOf(pluginInfoMap.size());
        }
        printWriter.println(ixe.O000000o("pluginRecord size: ", (Object) num));
    }

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
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void O000000o(RoomDeviceRecycler roomDeviceRecycler, PageBean pageBean, List<MainPageDeviceModel> list, List<? extends CommonUsedScene> list2, List<MainCameraCardModel> list3) {
        boolean z = false;
        if (ixe.O000000o((Object) pageBean.O00000Oo, (Object) "mijia.roomid.common")) {
            if (((Boolean) new RoomPagerAdapter$renderPage$shouldChangeToMainAdPage$1(list).invoke()).booleanValue()) {
                ixe.O00000o(list2, "commonScenes");
                gsy.O00000Oo(LogType.MAIN_PAGE, "RoomDeviceRecycler", ixe.O000000o("changeToAdOnLogin ：", (Object) Integer.valueOf(list2.size())));
                if (roomDeviceRecycler.O00000Oo != RoomDeviceRecycler.DisplayMode.LOGIN_AD) {
                    roomDeviceRecycler.O00000Oo = RoomDeviceRecycler.DisplayMode.LOGIN_AD;
                    gzl gzl = new gzl();
                    gzl.O000000o(new hbf());
                    gzl.O000000o(new hay());
                    gzl.O000000o(new hbj());
                    gzl.O000000o(new hat());
                    roomDeviceRecycler.setAdapter(gzl);
                    PageBean.O000000o o000000o = PageBean.CREATOR;
                    roomDeviceRecycler.setTag(PageBean.O000000o.O000000o().O00000Oo);
                }
                RecyclerView.O000000o adapter = roomDeviceRecycler.getAdapter();
                if (adapter != null) {
                    hbf hbf = (hbf) ((gzl) adapter).O000000o(hbf.class);
                    if (hbf != null) {
                        hbf.O000000o(list2);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
            }
            WeakReference<gzr> weakReference = this.O0000OoO;
            ixe.O00000o(pageBean, "page");
            ixe.O00000o(list, "deviceCardData");
            ixe.O00000o(list2, "commonScenes");
            ixe.O00000o(list3, "freqCameras");
            ixe.O00000o(weakReference, "pageAction");
            LogType logType = LogType.MAIN_PAGE;
            gsy.O00000Oo(logType, "RoomDeviceRecycler", "changeAndUpdateGridCommonPage page: " + pageBean + " , devices: " + list.size() + " ,scenes: " + list2.size() + ' ');
            if (roomDeviceRecycler.O00000Oo != RoomDeviceRecycler.DisplayMode.GRID_COMMON) {
                roomDeviceRecycler.O00000Oo = RoomDeviceRecycler.DisplayMode.GRID_COMMON;
                hbs hbs = new hbs(new hap());
                hbs.O0000OOo = "common_no_device";
                hbs hbs2 = new hbs(new hbg(gpc.O000000o(10.0f)));
                hbs2.O0000OOo = "fix_place_holder";
                gzl gzl2 = new gzl();
                gzl2.O000000o(new hbn());
                gzl2.O000000o(new RoomDeviceRecycler.O00000Oo());
                gzl2.O000000o(new hbf());
                gzl2.O000000o(new FavoriteCameraCardAdapter());
                gzl2.O000000o(new RoomDeviceRecycler.O00000Oo());
                gzl2.O000000o(new hbl());
                gzl2.O000000o(new hft());
                gzl2.O000000o(new hbc());
                gzl2.O000000o(hbs);
                gzl2.O000000o(hbs2);
                gzl2.O000000o(new hat());
                roomDeviceRecycler.swapAdapter(gzl2, false);
            }
            roomDeviceRecycler.setTag(pageBean.O00000Oo);
            RecyclerView.O000000o adapter2 = roomDeviceRecycler.getAdapter();
            if (adapter2 != null) {
                gzl gzl3 = (gzl) adapter2;
                hft hft = (hft) gzl3.O000000o(hft.class);
                if (hft != null) {
                    hft.O000000o(pageBean, list);
                }
                if (hft != null) {
                    hft.O00000Oo = weakReference;
                }
                RecyclerView.O000000o adapter3 = roomDeviceRecycler.getAdapter();
                if (adapter3 != null) {
                    hbs hbs3 = (hbs) ((gzl) adapter3).O000000o("common_no_device");
                    if (hbs3 != null) {
                        hbs3.O000000o(list.isEmpty());
                    }
                    RecyclerView.O000000o adapter4 = roomDeviceRecycler.getAdapter();
                    if (adapter4 != null) {
                        hbs hbs4 = (hbs) ((gzl) adapter4).O000000o("fix_place_holder");
                        if (hbs4 != null) {
                            hbs4.O000000o(!list.isEmpty());
                        }
                        hbc hbc = (hbc) gzl3.O000000o(hbc.class);
                        if (hbc != null) {
                            hbc.f18733O000000o = list.size();
                        }
                        hbf hbf2 = (hbf) gzl3.O000000o(hbf.class);
                        if (hbf2 != null) {
                            hbf2.O000000o(list2);
                        }
                        FavoriteCameraCardAdapter favoriteCameraCardAdapter = (FavoriteCameraCardAdapter) gzl3.O000000o(FavoriteCameraCardAdapter.class);
                        if (favoriteCameraCardAdapter != null) {
                            favoriteCameraCardAdapter.O000000o(list3);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
        } else if (ixe.O000000o((Object) pageBean.O00000Oo, (Object) "mijia.roomid.default")) {
            WeakReference<gzr> weakReference2 = this.O0000OoO;
            ixe.O00000o(pageBean, "page");
            ixe.O00000o(list, "data");
            ixe.O00000o(weakReference2, "pageAction");
            LogType logType2 = LogType.MAIN_PAGE;
            gsy.O00000Oo(logType2, "RoomDeviceRecycler", "changeAndUpdateGridAssignPage page: " + pageBean + " , data: " + list.size());
            if (roomDeviceRecycler.O00000Oo != RoomDeviceRecycler.DisplayMode.GRID_ASSIGN) {
                roomDeviceRecycler.O00000Oo = RoomDeviceRecycler.DisplayMode.GRID_ASSIGN;
                hbs hbs5 = new hbs(new hbg(gpc.O000000o(8.0f)));
                hbs5.O0000OOo = "fix_place_holder";
                gzl gzl4 = new gzl();
                gzl4.O000000o(new hft());
                hbs hbs6 = new hbs(new has());
                hbs6.O0000OOo = "assign_button";
                gzl4.O000000o(hbs6);
                gzl4.O000000o(new hat());
                gzl4.O000000o(hbs5);
                gzl4.O00000Oo(new hbo());
                roomDeviceRecycler.swapAdapter(gzl4, false);
            }
            roomDeviceRecycler.setTag(pageBean.O00000Oo);
            RecyclerView.O000000o adapter5 = roomDeviceRecycler.getAdapter();
            if (adapter5 != null) {
                hbs hbs7 = (hbs) ((gzl) adapter5).O000000o("assign_button");
                if (hbs7 != null) {
                    Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                    if (O0000Oo0 != null) {
                        z = O0000Oo0.isOwner();
                    }
                    hbs7.O000000o(z);
                }
                RecyclerView.O000000o adapter6 = roomDeviceRecycler.getAdapter();
                if (adapter6 != null) {
                    hft hft2 = (hft) ((gzl) adapter6).O000000o(hft.class);
                    if (hft2 != null) {
                        hft2.O000000o(pageBean, list);
                    }
                    if (hft2 != null) {
                        hft2.O00000Oo = weakReference2;
                    }
                    RecyclerView.O000000o adapter7 = roomDeviceRecycler.getAdapter();
                    if (adapter7 != null) {
                        hbs hbs8 = (hbs) ((gzl) adapter7).O000000o("fix_place_holder");
                        if (hbs8 != null) {
                            hbs8.O000000o(!list.isEmpty());
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
                }
                throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
        } else {
            WeakReference<gzr> weakReference3 = this.O0000OoO;
            ixe.O00000o(pageBean, "page");
            ixe.O00000o(list, "data");
            ixe.O00000o(weakReference3, "pageAction");
            LogType logType3 = LogType.MAIN_PAGE;
            gsy.O00000Oo(logType3, "RoomDeviceRecycler", "changeAndUpdateGridNormalPage page: " + pageBean + " , devices: " + list.size());
            if (roomDeviceRecycler.O00000Oo != RoomDeviceRecycler.DisplayMode.GRID_NORMAL) {
                roomDeviceRecycler.O00000Oo = RoomDeviceRecycler.DisplayMode.GRID_NORMAL;
                hbs hbs9 = new hbs(new hbg(gpc.O000000o(10.0f)));
                hbs9.O0000OOo = "fix_place_holder";
                gzl gzl5 = new gzl();
                gzl5.O000000o(new hft());
                gzl5.O000000o(new hat());
                gzl5.O000000o(hbs9);
                gzl5.O00000Oo(new hbo());
                roomDeviceRecycler.swapAdapter(gzl5, false);
            }
            roomDeviceRecycler.setTag(pageBean.O00000Oo);
            RecyclerView.O000000o adapter8 = roomDeviceRecycler.getAdapter();
            if (adapter8 != null) {
                hft hft3 = (hft) ((gzl) adapter8).O000000o(hft.class);
                if (hft3 != null) {
                    hft3.O000000o(pageBean, list);
                }
                if (hft3 != null) {
                    hft3.O00000Oo = weakReference3;
                }
                RecyclerView.O000000o adapter9 = roomDeviceRecycler.getAdapter();
                if (adapter9 != null) {
                    hbs hbs10 = (hbs) ((gzl) adapter9).O000000o("fix_place_holder");
                    if (hbs10 != null) {
                        hbs10.O000000o(!list.isEmpty());
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.multi_item.DelegateAdapter");
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T>
     arg types: [java.util.List, java.util.List]
     candidates:
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.lang.Object):int
      _m_j.iuy.O00000Oo(java.lang.Iterable, java.util.Collection):C
      _m_j.iuy.O00000Oo(java.util.Collection, java.lang.Iterable):java.util.List<T> */
    public final void O00000Oo() {
        List<RoomDeviceRecycler> list;
        if (this.O0000OOo != null) {
            T t = this.O0000OOo;
            ixe.O000000o((Object) t);
            list = iuo.O00000Oo((Collection) iuo.O000000o((Object) t), (Iterable) iuo.O00000o0((Iterable) this.O0000Oo0));
        } else {
            list = this.O0000Oo0;
        }
        for (RoomDeviceRecycler adapter : list) {
            adapter.setAdapter(null);
        }
        this.O0000OOo = null;
        this.O0000Oo0.clear();
        this.O0000Ooo.clear();
        this.O0000o00.clear();
        eyg eyg = eyg.f15944O000000o;
        eyg.O00000Oo(this);
    }
}
