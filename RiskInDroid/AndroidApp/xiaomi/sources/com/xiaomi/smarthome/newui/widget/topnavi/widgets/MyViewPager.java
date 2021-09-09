package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import _m_j.ayq;
import _m_j.ggb;
import _m_j.gri;
import _m_j.gsy;
import _m_j.gzl;
import _m_j.gzq;
import _m_j.gzs;
import _m_j.gzw;
import _m_j.haa;
import _m_j.haj;
import _m_j.hft;
import _m_j.hfx;
import _m_j.hfz;
import _m_j.hia;
import _m_j.hib;
import _m_j.hid;
import _m_j.iuo;
import _m_j.ixc;
import _m_j.ixe;
import _m_j.iye;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Looper;
import android.os.SystemClock;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.RoomDeviceRecycler;
import com.xiaomi.smarthome.newui.RoomPagerAdapter$render$$inlined$filterIsInstance$1;
import com.xiaomi.smarthome.newui.widget.topnavi.widgets.DeviceRoomRenderState;
import com.xiaomi.smarthome.scene.bean.CommonUsedScene;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u001a\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0002:\u0002=>B\u001b\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010%\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\b\u0010'\u001a\u00020\u0003H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0)H\u0016J\b\u0010*\u001a\u00020&H\u0016J\u0006\u0010+\u001a\u00020&J\u0006\u0010,\u001a\u00020&J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.H\u0002J\u0006\u00100\u001a\u00020&J\u0012\u00101\u001a\u00020&2\b\u00102\u001a\u0004\u0018\u000103H\u0014J\b\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020&2\u0006\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020&2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020&H\u0002J\b\u0010<\u001a\u00020&H\u0002R\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0004\n\u0002\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010!0!0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MviViewPager;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomPageView;", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DevicePageRoomPresenter;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "currentPage", "Landroidx/recyclerview/widget/RecyclerView;", "getCurrentPage", "()Landroidx/recyclerview/widget/RecyclerView;", "dataChangedPs", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "deviceMainPageRef", "Ljava/lang/ref/WeakReference;", "Lcom/xiaomi/smarthome/newui/DeviceMainPage;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "indicator", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyIndicator;", "needSnap", "pageChangeListener", "com/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager$pageChangeListener$1", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager$pageChangeListener$1;", "roomAdapter", "Lcom/xiaomi/smarthome/newui/RoomPagerAdapter;", "getRoomAdapter", "()Lcom/xiaomi/smarthome/newui/RoomPagerAdapter;", "sampleRequsetSubject", "", "screenWidthDp", "snapRunnable", "Ljava/lang/Runnable;", "attach", "", "createPresenter", "dataChanged", "Lio/reactivex/Observable;", "dispose", "enterEditMode", "exitEditMode", "getFakeScrollEvent", "", "Landroid/view/MotionEvent;", "notifyDataSetChanged", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "playChangeHomeAnim", "render", "state", "Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/DeviceRoomRenderState;", "snapDevicePosition", "did", "", "snapViewPager", "updateCommonPageCardInfo", "Companion", "SnapRunnable", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class MyViewPager extends MviViewPager<hib, hia> implements hib {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10371O000000o = new O000000o((byte) 0);
    public MyIndicator O00000Oo;
    public final CompositeDisposable O00000o;
    public WeakReference<gzs> O00000o0;
    public boolean O00000oO;
    public Runnable O00000oo;
    public final O00000o0 O0000O0o;
    private int O0000OOo;
    private final PublishSubject<Boolean> O0000Oo;
    private final PublishSubject<Integer> O0000Oo0;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MyViewPager(Context context) {
        this(context, null, 2, null);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MyViewPager(Context context, AttributeSet attributeSet, int i, ixc ixc) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ixe.O00000o(context, "context");
        this.O0000OOo = getResources().getConfiguration().screenWidthDp;
        this.O00000o = new CompositeDisposable();
        PublishSubject<Integer> create = PublishSubject.create();
        ixe.O00000Oo(create, "create<Int>()");
        this.O0000Oo0 = create;
        this.O0000O0o = new O00000o0(this);
        setPageMargin(gri.O000000o(8.0f));
        setOffscreenPageLimit(1);
        CompositeDisposable compositeDisposable = this.O00000o;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzq.O000000o o000000o2 = gzq.f18638O000000o;
        gzq.O000000o o000000o3 = gzq.f18638O000000o;
        gzq.O000000o o000000o4 = gzq.f18638O000000o;
        gzq.O000000o o000000o5 = gzq.f18638O000000o;
        compositeDisposable.addAll(gzq.O00000Oo.observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$gwb1EyN3RmaduB9gSZF1dhsemD0 */

            public final void accept(Object obj) {
                MyViewPager.O000000o(MyViewPager.this, (Intent) obj);
            }
        }), gzq.O00000o0.observeOn(AndroidSchedulers.mainThread()).map($$Lambda$MyViewPager$4j45TeY1ka6HNEXPSAGFvE1XVK0.INSTANCE).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$euSnfkpAA4E4hJu1TotjpO3ItU */

            public final void accept(Object obj) {
                MyViewPager.O000000o(MyViewPager.this, (String) obj);
            }
        }), Observable.merge(gzq.O00000o.map($$Lambda$MyViewPager$bVG4wSDljyttc13iKqt0San8Y.INSTANCE), gzq.O00000oO.map($$Lambda$MyViewPager$vZGim74xSGTYiciXNnGokrmSGHw.INSTANCE), gzq.O00000oo.map($$Lambda$MyViewPager$NLXyYhdS6C08NldYP_9yisro5N8.INSTANCE)).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$5ZbMytJyoXt_rUOcYwySffYy3I */

            public final void accept(Object obj) {
                MyViewPager.O000000o(MyViewPager.this, (Boolean) obj);
            }
        }), this.O0000Oo0.sample(500, TimeUnit.MILLISECONDS).doOnNext(new Consumer() {
            /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$5x8cVGHRnEo5VLxtEbMVhFauynU */

            public final void accept(Object obj) {
                MyViewPager.O000000o(MyViewPager.this, (Integer) obj);
            }
        }).subscribe());
        PublishSubject<Boolean> create2 = PublishSubject.create();
        ixe.O00000Oo(create2, "create<Boolean>()");
        this.O0000Oo = create2;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager$Companion;", "", "()V", "MAIN_ACTION_CAMERA_EDIT_MODE_CHANGED", "", "MAIN_ACTION_CARD_EDIT_MODE_CHANGED", "MAIN_ACTION_ROOM_SELECTED", "MAIN_ACTION_SCENE_EDIT_MODE_CHANGED", "MAIN_EXTRA_CAMERA_EDIT_MODE_IS_EDIT_MODE", "MAIN_EXTRA_CARD_EDIT_MODE_IS_EDIT_MODE", "MAIN_EXTRA_ROOM_SELECTED_ID", "MAIN_EXTRA_SCENE_EDIT_MODE_IS_EDIT_MODE", "MAIN_EXTRA_SCENE_EDIT_MODE_SCENE_COUNT", "TAG", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public final RecyclerView getCurrentPage() {
        RoomDeviceRecycler roomDeviceRecycler;
        haj roomAdapter = getRoomAdapter();
        if (roomAdapter == null) {
            roomDeviceRecycler = null;
        } else {
            roomDeviceRecycler = (RoomDeviceRecycler) roomAdapter.O0000OOo;
        }
        return roomDeviceRecycler;
    }

    public final haj getRoomAdapter() {
        return (haj) getAdapter();
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager$pageChangeListener$1", "Lcom/xiaomi/smarthome/newui/IOnPrimaryItemChanged;", "onChanged", "", "old", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "current", "pos", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o0 implements haa {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ MyViewPager f10374O000000o;

        O00000o0(MyViewPager myViewPager) {
            this.f10374O000000o = myViewPager;
        }

        public final void O000000o(RoomDeviceRecycler roomDeviceRecycler, RoomDeviceRecycler roomDeviceRecycler2, int i) {
            ixe.O00000o(roomDeviceRecycler2, "current");
            if (i == 0 && this.f10374O000000o.O00000oO) {
                MyViewPager myViewPager = this.f10374O000000o;
                myViewPager.O00000oO = false;
                Runnable runnable = myViewPager.O00000oo;
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, Intent intent) {
        ixe.O00000o(myViewPager, "this$0");
        myViewPager.setCurrentItem(0);
        MyIndicator myIndicator = myViewPager.O00000Oo;
        if (myIndicator != null) {
            TransitionManager.beginDelayedTransition(myIndicator);
            O00000oO();
            return;
        }
        ixe.O000000o("indicator");
        throw null;
    }

    /* access modifiers changed from: private */
    public static final String O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        String stringExtra = intent.getStringExtra("main_extra_room_selected_id");
        return stringExtra == null ? "" : stringExtra;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, String str) {
        int i;
        ixe.O00000o(myViewPager, "this$0");
        haj roomAdapter = myViewPager.getRoomAdapter();
        if (roomAdapter != null) {
            List<hid> list = roomAdapter.O00000oo;
            if (list != null) {
                i = 0;
                Iterator<hid> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (ixe.O000000o((Object) it.next().f18959O000000o.O00000Oo, (Object) str)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            if (i != -1) {
                myViewPager.setCurrentItem(i);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_card_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o0(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_camera_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, Boolean bool) {
        ixe.O00000o(myViewPager, "this$0");
        ixe.O00000Oo(bool, "it");
        myViewPager.setInterceptScroll(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, Integer num) {
        ixe.O00000o(myViewPager, "this$0");
        O00000oO();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.Object]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void O000000o(DeviceRoomRenderState deviceRoomRenderState) {
        List list;
        Object obj;
        ixe.O00000o(deviceRoomRenderState, "state");
        gsy.O00000Oo(LogType.MAIN_PAGE, "MyViewPager", ixe.O000000o("render: ", (Object) deviceRoomRenderState.getClass().getSimpleName()));
        if (!(deviceRoomRenderState instanceof DeviceRoomRenderState.ErrorState)) {
            if (!ixe.O000000o(Looper.myLooper(), Looper.getMainLooper())) {
                post(new Runnable(deviceRoomRenderState) {
                    /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$zIaT8e60jTZc1Jx0GWmbTQ_Ee8 */
                    private final /* synthetic */ DeviceRoomRenderState f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        MyViewPager.O000000o(MyViewPager.this, this.f$1);
                    }
                });
                return;
            }
            haj roomAdapter = getRoomAdapter();
            if (roomAdapter != null) {
                ixe.O00000o(deviceRoomRenderState, "state");
                gsy.O00000Oo(LogType.DEVICE_LIST, "RoomPagerAdapter", ixe.O000000o("render: ", (Object) deviceRoomRenderState.getClass().getSimpleName()));
                if (deviceRoomRenderState instanceof DeviceRoomRenderState.DeviceRoomState) {
                    if (!(roomAdapter.O00000oO instanceof DeviceRoomRenderState.DeviceRoomState)) {
                        roomAdapter.O00000oO = deviceRoomRenderState;
                        DeviceRoomRenderState.DeviceRoomState deviceRoomState = (DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState;
                        roomAdapter.O00000oo = deviceRoomState.O00000Oo;
                        roomAdapter.O00000o = deviceRoomState.f10362O000000o;
                        roomAdapter.notifyDataSetChanged();
                    } else {
                        DeviceRoomRenderState.DeviceRoomState deviceRoomState2 = (DeviceRoomRenderState.DeviceRoomState) deviceRoomRenderState;
                        if (ixe.O000000o(roomAdapter.O00000o, deviceRoomState2.f10362O000000o)) {
                            Iterable<hid> iterable = deviceRoomState2.O00000Oo;
                            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
                            for (hid hid : iterable) {
                                arrayList.add(hid.f18959O000000o);
                            }
                            List list2 = (List) arrayList;
                            List<hid> list3 = roomAdapter.O00000oo;
                            if (list3 == null) {
                                list = null;
                            } else {
                                Iterable<hid> iterable2 = list3;
                                Collection arrayList2 = new ArrayList(iuo.O000000o(iterable2, 10));
                                for (hid hid2 : iterable2) {
                                    arrayList2.add(hid2.f18959O000000o);
                                }
                                list = (List) arrayList2;
                            }
                            if (ixe.O000000o(list2, list)) {
                                roomAdapter.O00000oo = deviceRoomState2.O00000Oo;
                                roomAdapter.O00000oO = deviceRoomRenderState;
                                Iterator O000000o2 = iye.O000000o(gzw.O000000o(roomAdapter.O00000Oo), RoomPagerAdapter$render$$inlined$filterIsInstance$1.f10122O000000o).O000000o();
                                while (O000000o2.hasNext()) {
                                    RoomDeviceRecycler roomDeviceRecycler = (RoomDeviceRecycler) O000000o2.next();
                                    List<CommonUsedScene> list4 = deviceRoomState2.O00000o0;
                                    Iterator it = deviceRoomState2.O00000Oo.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            obj = null;
                                            break;
                                        }
                                        obj = it.next();
                                        if (ixe.O000000o((Object) ((hid) obj).f18959O000000o.O00000Oo, roomDeviceRecycler.getTag())) {
                                            break;
                                        }
                                    }
                                    hid hid3 = (hid) obj;
                                    if (hid3 != null) {
                                        roomAdapter.O000000o(roomDeviceRecycler, hid3.f18959O000000o, hid3.O00000Oo.invoke(), list4, deviceRoomState2.O00000o);
                                    }
                                }
                            }
                        }
                        roomAdapter.O00000oO = deviceRoomRenderState;
                        roomAdapter.O00000oo = deviceRoomState2.O00000Oo;
                        roomAdapter.O00000o = deviceRoomState2.f10362O000000o;
                        roomAdapter.notifyDataSetChanged();
                    }
                    if (roomAdapter.O0000O0o >= 0) {
                        String O000000o3 = ggb.O0000O0o.O000000o(roomAdapter.O000000o(roomAdapter.O0000O0o), new boolean[0]);
                        ggb.O0000O0o.O000000o().onNext(O000000o3);
                        LogType logType = LogType.HOME_ROOM;
                        StringBuilder sb = new StringBuilder("path = ");
                        sb.append((Object) O000000o3);
                        sb.append(", tag ");
                        RoomDeviceRecycler roomDeviceRecycler2 = (RoomDeviceRecycler) roomAdapter.O0000OOo;
                        Object tag = roomDeviceRecycler2 == null ? null : roomDeviceRecycler2.getTag();
                        if (tag != null) {
                            sb.append((String) tag);
                            gsy.O00000o0(logType, "zzzRender ", sb.toString());
                            hfz hfz = hfz.f18889O000000o;
                            String O00000oO2 = hfz.O00000oO();
                            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
                            if (!ixe.O000000o((Object) O00000oO2, (Object) (O0000Oo02 == null ? null : O0000Oo02.getIcon()))) {
                                hfz hfz2 = hfz.f18889O000000o;
                                Home O0000Oo03 = ggb.O00000Oo().O0000Oo0();
                                hfz.O000000o(O0000Oo03 == null ? null : O0000Oo03.getIcon());
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                    }
                } else {
                    roomAdapter.O00000oO = deviceRoomRenderState;
                    roomAdapter.O00000oo = null;
                    roomAdapter.O00000o = null;
                    roomAdapter.notifyDataSetChanged();
                }
            }
            MyIndicator myIndicator = this.O00000Oo;
            if (myIndicator != null) {
                myIndicator.O000000o(deviceRoomRenderState);
            } else {
                ixe.O000000o("indicator");
                throw null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, DeviceRoomRenderState deviceRoomRenderState) {
        ixe.O00000o(myViewPager, "this$0");
        ixe.O00000o(deviceRoomRenderState, "$state");
        myViewPager.O000000o(deviceRoomRenderState);
    }

    public final Observable<Boolean> O000000o() {
        return this.O0000Oo;
    }

    public final void O00000Oo() {
        this.O0000Oo.onNext(Boolean.TRUE);
        this.O0000Oo0.onNext(1);
    }

    private static void O00000oO() {
        hfx hfx = hfx.f18878O000000o;
        hfx.O00000Oo(ggb.O00000Oo().O0000Oo0()).onErrorReturnItem(EmptyList.f15376O000000o).subscribe();
    }

    public static void O00000o0() {
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000o, MyViewPager$enterEditMode$1.f10375O000000o);
    }

    public static void O00000o() {
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000o, MyViewPager$exitEditMode$1.f10376O000000o);
    }

    public final void O000000o(String str) {
        hft hft;
        int O00000Oo2;
        int O000000o2;
        ixe.O00000o(str, "did");
        RecyclerView currentPage = getCurrentPage();
        gzl gzl = null;
        RecyclerView.O000000o adapter = currentPage == null ? null : currentPage.getAdapter();
        if (adapter instanceof gzl) {
            gzl = (gzl) adapter;
        }
        if (gzl != null && (hft = (hft) gzl.O000000o(hft.class)) != null && (O00000Oo2 = hft.O00000Oo(str)) != -1 && (O000000o2 = gzl.O000000o(hft, O00000Oo2)) != -1) {
            if (getCurrentItem() == 0) {
                new O00000Oo(this, O000000o2).run();
                return;
            }
            this.O00000oO = true;
            this.O00000oo = new O00000Oo(this, O000000o2);
            setCurrentItem(0);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager$SnapRunnable;", "Ljava/lang/Runnable;", "position", "", "(Lcom/xiaomi/smarthome/newui/widget/topnavi/widgets/MyViewPager;I)V", "getPosition", "()I", "run", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000Oo implements Runnable {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ MyViewPager f10373O000000o;
        private final int O00000Oo;

        public O00000Oo(MyViewPager myViewPager, int i) {
            ixe.O00000o(myViewPager, "this$0");
            this.f10373O000000o = myViewPager;
            this.O00000Oo = i;
        }

        public final void run() {
            RecyclerView currentPage;
            if (this.f10373O000000o.getCurrentItem() == 0 && (currentPage = this.f10373O000000o.getCurrentPage()) != null) {
                currentPage.stopScroll();
                RecyclerView.LayoutManager layoutManager = currentPage.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(this.O00000Oo, 0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = getResources().getConfiguration().screenWidthDp;
        if (this.O0000OOo != i) {
            this.O0000OOo = i;
            post(new Runnable(getCurrentItem()) {
                /* class com.xiaomi.smarthome.newui.widget.topnavi.widgets.$$Lambda$MyViewPager$FqhgcDAalW21I4VMuLNvxEOfnCg */
                private final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    MyViewPager.O000000o(MyViewPager.this, this.f$1);
                }
            });
        }
    }

    private final List<MotionEvent> getFakeScrollEvent() {
        long uptimeMillis = SystemClock.uptimeMillis();
        float x = getX() + 200.0f;
        float y = getY() + 10.0f;
        List<MotionEvent> arrayList = new ArrayList<>();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, x, y, 0);
        ixe.O00000Oo(obtain, "obtain(downTime, downTime, MotionEvent.ACTION_DOWN, downX, downY, 0)");
        arrayList.add(obtain);
        int i = 1;
        while (true) {
            int i2 = i + 1;
            MotionEvent obtain2 = MotionEvent.obtain(uptimeMillis, uptimeMillis + ((long) (i * 10)), 2, getX() - ((float) i), getY(), 0);
            ixe.O00000Oo(obtain2, "obtain(downTime, downTime + step * 10, MotionEvent.ACTION_MOVE, x - step, y, 0)");
            arrayList.add(obtain2);
            if (i2 >= 10) {
                MotionEvent obtain3 = MotionEvent.obtain(uptimeMillis, uptimeMillis + 100, 1, getX() - 10.0f, getY(), 0);
                ixe.O00000Oo(obtain3, "obtain(downTime, downTime + steps * 10, MotionEvent.ACTION_UP, x - steps, y, 0)");
                arrayList.add(obtain3);
                return arrayList;
            }
            i = i2;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(MyViewPager myViewPager, int i) {
        ixe.O00000o(myViewPager, "this$0");
        for (MotionEvent motionEvent : myViewPager.getFakeScrollEvent()) {
            myViewPager.dispatchTouchEvent(motionEvent);
            motionEvent.recycle();
        }
        if (i != myViewPager.getCurrentItem()) {
            myViewPager.setCurrentItem(i);
        }
    }

    public final /* synthetic */ ayq createPresenter() {
        return new hia();
    }
}
