package _m_j;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.newui.MainDeviceTabAnimManager$Companion$notifyDoubleClick$1;
import com.xiaomi.smarthome.newui.MainDeviceTabAnimManager$Companion$notifySingleClick$1;
import com.xiaomi.smarthome.newui.RoomDeviceRecycler;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.MyViewPager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002\r\u0010\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0017J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\u000e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001fH\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0014\u0010!\u001a\u00020\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060#R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainDeviceTabAnimManager;", "", "()V", "dispatcher", "Lio/reactivex/subjects/Subject;", "Ljava/util/concurrent/Callable;", "", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "mainPage", "Lcom/xiaomi/smarthome/newui/DeviceMainPage;", "needSnap", "pageChangeListener", "com/xiaomi/smarthome/newui/MainDeviceTabAnimManager$pageChangeListener$1", "Lcom/xiaomi/smarthome/newui/MainDeviceTabAnimManager$pageChangeListener$1;", "scrollChangeListener", "com/xiaomi/smarthome/newui/MainDeviceTabAnimManager$scrollChangeListener$1", "Lcom/xiaomi/smarthome/newui/MainDeviceTabAnimManager$scrollChangeListener$1;", "snapRunnable", "Ljava/lang/Runnable;", "viewPager", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;", "attach", "", "page", "destroy", "dispatchAuto", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dispatchHide", "observer", "Lio/reactivex/Observable;", "setupStateListener", "subscribe", "consumer", "Lio/reactivex/functions/Consumer;", "Companion", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class had {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f18687O000000o = new O000000o((byte) 0);
    public static final hne O0000Oo;
    public static had O0000Oo0;
    MyViewPager O00000Oo;
    public final CompositeDisposable O00000o = new CompositeDisposable();
    gzs O00000o0;
    public boolean O00000oO;
    public final Runnable O00000oo = new Runnable() {
        /* class _m_j.$$Lambda$had$i8MI2U5C2zTmULp12KtWzEDnYo */

        public final void run() {
            had.O000000o(had.this);
        }
    };
    public final O00000o0 O0000O0o = new O00000o0(this);
    final O00000Oo O0000OOo = new O00000Oo(this);
    private final Subject<Callable<Boolean>> O0000OoO;

    /* access modifiers changed from: private */
    public static final boolean O000000o(int i) {
        return i == 3;
    }

    public had() {
        PublishSubject create = PublishSubject.create();
        ixe.O00000Oo(create, "create()");
        this.O0000OoO = create;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\bH\u0007J\b\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/MainDeviceTabAnimManager$Companion;", "", "()V", "ACTION_MAIN_TAB_CLICK", "", "ARG_MAIN_TAB_IS_SINGLE_CLICK", "TAG", "ins", "Lcom/xiaomi/smarthome/newui/MainDeviceTabAnimManager;", "tabClickObservable", "Lcom/xiaomi/smarthome/rx_receiver/BroadcastReceiverObservable;", "instance", "notifyDoubleClick", "", "notifySingleClick", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    static {
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        O0000Oo = new hne("action_main_tab_click", application);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(had had) {
        ixe.O00000o(had, "this$0");
        MyViewPager myViewPager = had.O00000Oo;
        RecyclerView currentPage = myViewPager == null ? null : myViewPager.getCurrentPage();
        if (currentPage != null) {
            currentPage.stopScroll();
            RecyclerView.LayoutManager layoutManager = currentPage.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
                currentPage.postDelayed(new Runnable(currentPage) {
                    /* class _m_j.$$Lambda$had$z9vWeq8SV0MAt0ekDRbCHcyf8 */
                    private final /* synthetic */ RecyclerView f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        had.O000000o(had.this, this.f$1);
                    }
                }, 10);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(had had, RecyclerView recyclerView) {
        ixe.O00000o(had, "this$0");
        ixe.O00000o(recyclerView, "$curr");
        had.O000000o(recyclerView);
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/newui/MainDeviceTabAnimManager$scrollChangeListener$1", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$ScrollChangeListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 implements RoomDeviceRecycler.O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ had f18689O000000o;

        O00000o0(had had) {
            this.f18689O000000o = had;
        }

        public final void O000000o(RecyclerView recyclerView) {
            ixe.O00000o(recyclerView, "recyclerView");
            this.f18689O000000o.O000000o(recyclerView);
        }

        public final void O00000Oo(RecyclerView recyclerView) {
            ixe.O00000o(recyclerView, "recyclerView");
            this.f18689O000000o.O000000o(recyclerView);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/MainDeviceTabAnimManager$pageChangeListener$1", "Lcom/xiaomi/smarthome/newui/IOnPrimaryItemChanged;", "onChanged", "", "old", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "current", "pos", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo implements haa {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ had f18688O000000o;

        O00000Oo(had had) {
            this.f18688O000000o = had;
        }

        public final void O000000o(RoomDeviceRecycler roomDeviceRecycler, RoomDeviceRecycler roomDeviceRecycler2, int i) {
            ixe.O00000o(roomDeviceRecycler2, "current");
            if (this.f18688O000000o.O00000oO) {
                had had = this.f18688O000000o;
                had.O00000oO = false;
                had.O00000oo.run();
            } else {
                this.f18688O000000o.O000000o(roomDeviceRecycler2);
            }
            if (roomDeviceRecycler != null) {
                roomDeviceRecycler.O00000o0 = null;
            }
            roomDeviceRecycler2.setOnScrollChangeListener(this.f18688O000000o.O0000O0o);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        haj roomAdapter;
        MyViewPager myViewPager = this.O00000Oo;
        if (!(myViewPager == null || (roomAdapter = myViewPager.getRoomAdapter()) == null)) {
            roomAdapter.O000000o(this.O0000OOo);
        }
        CompositeDisposable compositeDisposable = this.O00000o;
        CommonApplication application = CommonApplication.getApplication();
        ixe.O00000Oo(application, "getApplication()");
        compositeDisposable.addAll(new hne("app_state_changed", application).map($$Lambda$had$fgsTwMXNEo4C0sQrJFxn2h2vvk.INSTANCE).filter($$Lambda$had$TP7im4qOyKMNPIgeVQ0jNvhz4.INSTANCE).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$had$kOqLfsjO73rIDihhN1xf0pUR80w */

            public final void accept(Object obj) {
                had.O000000o(had.this, (Integer) obj);
            }
        }), O0000Oo.map($$Lambda$had$cPdCL22hiWgNgEunQ66tLGu9yO4.INSTANCE).subscribe(new Consumer() {
            /* class _m_j.$$Lambda$had$vA1gimYnBNb1akhdm7REYnt06k */

            public final void accept(Object obj) {
                had.O000000o(had.this, (Boolean) obj);
            }
        }));
    }

    /* access modifiers changed from: private */
    public static final Integer O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Integer.valueOf(intent.getIntExtra("current_state", 2));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("arg_main_tab_is_single_click", false));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(had had, Boolean bool) {
        hai hai;
        RoomDeviceRecycler roomDeviceRecycler;
        hai hai2;
        haj roomAdapter;
        ixe.O00000o(had, "this$0");
        ixe.O00000Oo(bool, "isSingleClick");
        haj haj = null;
        if (bool.booleanValue()) {
            MyViewPager myViewPager = had.O00000Oo;
            if (myViewPager == null || (roomAdapter = myViewPager.getRoomAdapter()) == null) {
                roomDeviceRecycler = null;
            } else {
                roomDeviceRecycler = (RoomDeviceRecycler) roomAdapter.O0000OOo;
            }
            if (hae.O000000o(roomDeviceRecycler)) {
                gzs gzs = had.O00000o0;
                if (gzs != null) {
                    gzs.O00000o();
                }
                had.O00000oO = true;
                MyViewPager myViewPager2 = had.O00000Oo;
                if (myViewPager2 != null) {
                    haj = myViewPager2.getRoomAdapter();
                }
                if (!(haj == null || (hai2 = haj.O00000o0) == null)) {
                    PageBean.O000000o o000000o = PageBean.CREATOR;
                    hai2.O000000o(PageBean.O000000o.O000000o().O00000Oo);
                }
                MyViewPager myViewPager3 = had.O00000Oo;
                if (myViewPager3 != null) {
                    myViewPager3.setCurrentItem(0);
                    return;
                }
                return;
            }
            gzs gzs2 = had.O00000o0;
            if (gzs2 != null) {
                gzs2.O00000o();
            }
            had.O00000oo.run();
            return;
        }
        gzs gzs3 = had.O00000o0;
        if (gzs3 != null) {
            gzs3.O00000o();
        }
        had.O00000oO = true;
        MyViewPager myViewPager4 = had.O00000Oo;
        if (myViewPager4 != null) {
            haj = myViewPager4.getRoomAdapter();
        }
        if (!(haj == null || (hai = haj.O00000o0) == null)) {
            PageBean.O000000o o000000o2 = PageBean.CREATOR;
            hai.O000000o(PageBean.O000000o.O000000o().O00000Oo);
        }
        MyViewPager myViewPager5 = had.O00000Oo;
        if (myViewPager5 != null) {
            myViewPager5.setCurrentItem(0);
        }
    }

    public final Observable<Boolean> O00000Oo() {
        Observable<R> hide = this.O0000OoO.sample(50, TimeUnit.MILLISECONDS).map($$Lambda$had$cRYQwKNU6ANHreGdvkttZovR5ck.INSTANCE).distinctUntilChanged().onErrorReturnItem(Boolean.FALSE).hide();
        ixe.O00000Oo(hide, "dispatcher.sample(50, TimeUnit.MILLISECONDS)\n                .map { state: Callable<Boolean> ->\n                    val isLogin = ServiceApplication.getStateNotifier().currentState == AppStateNotifier.STATE_LOGIN_SUCCESS\n                    isLogin && state.call()\n                }\n                .distinctUntilChanged()\n                .onErrorReturnItem(false)\n                .hide()");
        return hide;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0024, code lost:
        if (((java.lang.Boolean) r4).booleanValue() != false) goto L_0x0028;
     */
    public static final Boolean O000000o(Callable callable) {
        ixe.O00000o(callable, "state");
        boolean z = true;
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            Object call = callable.call();
            ixe.O00000Oo(call, "state.call()");
        }
        z = false;
        return Boolean.valueOf(z);
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000oo() {
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(RecyclerView recyclerView) {
        return Boolean.valueOf(!hae.O000000o(recyclerView));
    }

    public final void O000000o(RecyclerView recyclerView) {
        if (recyclerView != null) {
            this.O0000OoO.onNext(new Callable() {
                /* class _m_j.$$Lambda$had$bgCEVt0Oelw4Haf7_2RDJl2GI */

                public final Object call() {
                    return had.O00000Oo(RecyclerView.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(had had, Integer num) {
        ixe.O00000o(had, "this$0");
        had.O0000OoO.onNext($$Lambda$had$A8574HkflcVG3Rbri2y0oe5Nm4Y.INSTANCE);
    }

    public static final void O00000o0() {
        gzw.O000000o(O0000Oo, MainDeviceTabAnimManager$Companion$notifySingleClick$1.f10108O000000o);
    }

    public static final void O00000o() {
        gzw.O000000o(O0000Oo, MainDeviceTabAnimManager$Companion$notifyDoubleClick$1.f10107O000000o);
    }

    public static final had O00000oO() {
        had had = O0000Oo0;
        if (had != null) {
            return had;
        }
        had had2 = new had();
        O0000Oo0 = had2;
        return had2;
    }
}
