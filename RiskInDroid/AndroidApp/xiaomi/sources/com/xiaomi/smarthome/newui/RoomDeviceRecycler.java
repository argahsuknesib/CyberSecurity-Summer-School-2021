package com.xiaomi.smarthome.newui;

import _m_j.go;
import _m_j.gpc;
import _m_j.gsy;
import _m_j.gzl;
import _m_j.gzq;
import _m_j.hay;
import _m_j.hbg;
import _m_j.hbq;
import _m_j.hha;
import _m_j.hhb;
import _m_j.iuh;
import _m_j.ixe;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.newui.widget.topnavi.PageBean;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0012\u0018\u0000 22\u00020\u0001:\u00042345B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ*\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJF\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00192\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ*\u0010$\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cJ\u0014\u0010%\u001a\u00020\u00152\f\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0019J\u0006\u0010&\u001a\u00020\u0015J\u0006\u0010'\u001a\u00020\u0015J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u0015H\u0014J\u0012\u0010,\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010.H\u0014J\b\u0010/\u001a\u00020\u0015H\u0014J\u0006\u00100\u001a\u00020\u0015J\u000e\u00101\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0004\n\u0002\u0010\u0013¨\u00066"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "displayMode", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$DisplayMode;", "disposables", "Lio/reactivex/disposables/CompositeDisposable;", "flexDimen", "Lcom/xiaomi/smarthome/newui/utils/MainListFlexSize;", "listener", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$ScrollChangeListener;", "singleScrollChangeListener", "com/xiaomi/smarthome/newui/RoomDeviceRecycler$singleScrollChangeListener$1", "Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$singleScrollChangeListener$1;", "changeAndUpdateGridAssignPage", "", "page", "Lcom/xiaomi/smarthome/newui/widget/topnavi/PageBean;", "data", "", "Lcom/xiaomi/smarthome/newui/mainpage/devicepage/model/MainPageDeviceModel;", "pageAction", "Ljava/lang/ref/WeakReference;", "Lcom/xiaomi/smarthome/newui/DeviceListPageActionInterface;", "changeAndUpdateGridCommonPage", "deviceCardData", "commonScenes", "Lcom/xiaomi/smarthome/scene/bean/CommonUsedScene;", "freqCameras", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "changeAndUpdateGridNormalPage", "changeToAdOnLogin", "changeToLoading", "changeToLogout", "dispatchOnConfigurationChange", "isVisible", "", "onAttachedToWindow", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDetachedFromWindow", "removeScrollChangeListener", "setOnScrollChangeListener", "Companion", "DisplayMode", "InvisibleSeparatorAdapter", "ScrollChangeListener", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RoomDeviceRecycler extends RecyclerView {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10117O000000o = new O000000o((byte) 0);
    public DisplayMode O00000Oo;
    private final CompositeDisposable O00000o;
    public O00000o0 O00000o0;
    private hhb O00000oO;
    private final O0000O0o O00000oo;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$ScrollChangeListener;", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface O00000o0 {
        void O000000o(RecyclerView recyclerView);

        void O00000Oo(RecyclerView recyclerView);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomDeviceRecycler(Context context) {
        this(context, null, 6, (byte) 0);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomDeviceRecycler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
        ixe.O00000o(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RoomDeviceRecycler(Context context, AttributeSet attributeSet, int i, byte b) {
        this(context, (i & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomDeviceRecycler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ixe.O00000o(context, "context");
        this.O00000o = new CompositeDisposable();
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O00000oO = hha.O000000o.O000000o();
        this.O00000oo = new O0000O0o(this);
        setItemViewCacheSize(5);
        setNestedScrollingEnabled(true);
        setLayoutManager(new GridLayoutManager(context) {
            /* class com.xiaomi.smarthome.newui.RoomDeviceRecycler.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Context f10118O000000o;

            public final boolean supportsPredictiveItemAnimations() {
                return false;
            }

            {
                this.f10118O000000o = r2;
            }
        });
        go goVar = new go();
        goVar.O0000o00 = false;
        iuh iuh = iuh.f1631O000000o;
        setItemAnimator(goVar);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$Companion;", "", "()V", "TAG", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"com/xiaomi/smarthome/newui/RoomDeviceRecycler$singleScrollChangeListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000O0o extends RecyclerView.O00oOooO {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RoomDeviceRecycler f10119O000000o;

        O0000O0o(RoomDeviceRecycler roomDeviceRecycler) {
            this.f10119O000000o = roomDeviceRecycler;
        }

        public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
            ixe.O00000o(recyclerView, "recyclerView");
            O00000o0 o00000o0 = this.f10119O000000o.O00000o0;
            if (o00000o0 != null) {
                o00000o0.O000000o(recyclerView);
            }
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
            ixe.O00000o(recyclerView, "recyclerView");
            O00000o0 o00000o0 = this.f10119O000000o.O00000o0;
            if (o00000o0 != null) {
                o00000o0.O00000Oo(recyclerView);
            }
        }
    }

    public final void setOnScrollChangeListener(O00000o0 o00000o0) {
        ixe.O00000o(o00000o0, "listener");
        this.O00000o0 = o00000o0;
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$DisplayMode;", "", "(Ljava/lang/String;I)V", "GRID_COMMON", "GRID_NORMAL", "GRID_ASSIGN", "LOADING", "LOGOUT", "LOGIN_AD", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DisplayMode extends Enum<DisplayMode> {
        private static final /* synthetic */ DisplayMode[] $VALUES = $values();
        public static final DisplayMode GRID_ASSIGN = new DisplayMode("GRID_ASSIGN", 2);
        public static final DisplayMode GRID_COMMON = new DisplayMode("GRID_COMMON", 0);
        public static final DisplayMode GRID_NORMAL = new DisplayMode("GRID_NORMAL", 1);
        public static final DisplayMode LOADING = new DisplayMode("LOADING", 3);
        public static final DisplayMode LOGIN_AD = new DisplayMode("LOGIN_AD", 5);
        public static final DisplayMode LOGOUT = new DisplayMode("LOGOUT", 4);

        private static final /* synthetic */ DisplayMode[] $values() {
            return new DisplayMode[]{GRID_COMMON, GRID_NORMAL, GRID_ASSIGN, LOADING, LOGOUT, LOGIN_AD};
        }

        private DisplayMode(String str, int i) {
        }

        public static DisplayMode valueOf(String str) {
            ixe.O00000o(str, "value");
            return (DisplayMode) Enum.valueOf(DisplayMode.class, str);
        }

        public static DisplayMode[] values() {
            DisplayMode[] displayModeArr = $VALUES;
            return (DisplayMode[]) Arrays.copyOf(displayModeArr, displayModeArr.length);
        }
    }

    public final void O000000o() {
        gsy.O00000Oo(LogType.MAIN_PAGE, "RoomDeviceRecycler", "changeToLogout");
        if (this.O00000Oo != DisplayMode.LOGOUT) {
            this.O00000Oo = DisplayMode.LOGOUT;
            O00000o o00000o = new O00000o(RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2.f10120O000000o);
            gzl gzl = new gzl();
            gzl.O000000o(o00000o);
            gzl.O000000o(new hay());
            setAdapter(gzl);
            PageBean.O000000o o000000o = PageBean.CREATOR;
            setTag(PageBean.O000000o.O000000o().O00000Oo);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$1", "Lcom/xiaomi/smarthome/newui/adapter/SimpleCardLayoutAdapter;", "onConfigurationChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends hbq {
        O00000o(RoomDeviceRecycler$changeToLogout$logoutButtonAdapter$2 roomDeviceRecycler$changeToLogout$logoutButtonAdapter$2) {
            super(R.layout.device_main_logout_layout, roomDeviceRecycler$changeToLogout$logoutButtonAdapter$2);
        }

        public final void O000000o(RecyclerView recyclerView) {
            notifyItemChanged(0);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/RoomDeviceRecycler$InvisibleSeparatorAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/FixHeightPlaceHolderAdapter;", "()V", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "position", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends hbg {
        public O00000Oo() {
            super(0);
        }

        public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            if (j_()) {
                rect.top = gpc.O000000o(7.0f);
            }
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        addOnScrollListener(this.O00000oo);
        CompositeDisposable compositeDisposable = this.O00000o;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzq.O000000o o000000o2 = gzq.f18638O000000o;
        gzq.O000000o o000000o3 = gzq.f18638O000000o;
        compositeDisposable.addAll(Observable.merge(gzq.O00000o.map($$Lambda$RoomDeviceRecycler$cpbi99RRIkDfxTB3MF7tFWW4HHU.INSTANCE), gzq.O00000oO.map($$Lambda$RoomDeviceRecycler$ZZy8q1FnOje3uUxrO48nFKt_ASc.INSTANCE), gzq.O00000oo.map($$Lambda$RoomDeviceRecycler$ekca4IxvkupKnZzBlgkIDetdug.INSTANCE)).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$RoomDeviceRecycler$71ztPghSx3JA35YAZP_JRkmpN4 */

            public final void accept(Object obj) {
                RoomDeviceRecycler.O000000o(RoomDeviceRecycler.this, (Boolean) obj);
            }
        }));
        post(new Runnable() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$RoomDeviceRecycler$tyZ83vEObiJKEFy8EvYZkU7Nwo */

            public final void run() {
                RoomDeviceRecycler.O000000o(RoomDeviceRecycler.this);
            }
        });
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_card_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000Oo(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_scene_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final Boolean O00000o0(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_camera_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final void O000000o(RoomDeviceRecycler roomDeviceRecycler, Boolean bool) {
        ixe.O00000o(roomDeviceRecycler, "this$0");
        ixe.O00000Oo(bool, "isEditModeAny");
        if (bool.booleanValue() && roomDeviceRecycler.getLocalVisibleRect(new Rect())) {
            roomDeviceRecycler.setBackgroundColor(roomDeviceRecycler.getResources().getColor(R.color.mj_color_black_10_transparent));
        } else if (roomDeviceRecycler.getBackground() != null) {
            roomDeviceRecycler.setBackground(null);
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(RoomDeviceRecycler roomDeviceRecycler) {
        ixe.O00000o(roomDeviceRecycler, "this$0");
        hha.O000000o o000000o = hha.f18928O000000o;
        hhb O000000o2 = hha.O000000o.O000000o();
        if (!ixe.O000000o(roomDeviceRecycler.O00000oO, O000000o2)) {
            roomDeviceRecycler.O00000oO = O000000o2;
            roomDeviceRecycler.O00000Oo();
        }
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnScrollListener(this.O00000oo);
        this.O00000o.clear();
    }

    /* access modifiers changed from: protected */
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        O00000Oo();
    }

    private final void O00000Oo() {
        RecyclerView.O000000o adapter = getAdapter();
        gzl gzl = adapter instanceof gzl ? (gzl) adapter : null;
        if (gzl != null) {
            gzl.O000000o(this);
        }
    }
}
