package com.xiaomi.smarthome.newui.adapter;

import _m_j.ee;
import _m_j.ei;
import _m_j.ext;
import _m_j.eyc;
import _m_j.ez;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fi;
import _m_j.fno;
import _m_j.ggb;
import _m_j.ggr;
import _m_j.gof;
import _m_j.gp;
import _m_j.gqg;
import _m_j.gs;
import _m_j.gsy;
import _m_j.gth;
import _m_j.gzl;
import _m_j.gzn;
import _m_j.gzq;
import _m_j.gzw;
import _m_j.gzx;
import _m_j.hak;
import _m_j.haz;
import _m_j.hba;
import _m_j.hbb;
import _m_j.hbh;
import _m_j.hbk;
import _m_j.hbr;
import _m_j.hfy;
import _m_j.hha;
import _m_j.htr;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxs;
import _m_j.itz;
import _m_j.iua;
import _m_j.iuh;
import _m_j.iuo;
import _m_j.ivg;
import _m_j.ixe;
import _m_j.ixh;
import _m_j.ixi;
import _m_j.iyo;
import _m_j.oOO0OOo0;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.api.CameraRouterFactory;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.fastvideo.VideoView;
import com.xiaomi.smarthome.flexible_layout.FlexSize;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.newui.NetworkConnectionObserver;
import com.xiaomi.smarthome.newui.ViewHolderVideoPlayer;
import com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter;
import com.xiaomi.smarthome.newui.mainpage.EditMaskView;
import com.xiaomi.smarthome.newui.page.CameraEditPage;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b$*\u0001\u000f\u0018\u0000 \u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\n\u0001\u0001\u0001\u0001\u0001B\u000f\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\u0012H\u0016J$\u0010C\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u0010H\u001a\u00020%H\u0016J\u0010\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020KH\u0002J\"\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\r2\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020RH\u0002J\b\u0010S\u001a\u00020\tH\u0002J\u0006\u0010T\u001a\u00020%J\b\u0010U\u001a\u00020%H\u0016J\b\u0010V\u001a\u00020%H\u0016J4\u0010W\u001a\u00020>2\u0006\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020R2\u0006\u0010H\u001a\u00020%2\b\u0010[\u001a\u0004\u0018\u00010E2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u001c\u0010^\u001a\u00020%2\b\u0010D\u001a\u0004\u0018\u00010E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u0010\u0010_\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0002J\"\u0010b\u001a\u00020>2\u0006\u0010c\u001a\u00020%2\u0006\u0010d\u001a\u00020%2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J\b\u0010g\u001a\u00020>H\u0007J\b\u0010h\u001a\u00020>H\u0016J\b\u0010i\u001a\u00020>H\u0016J\u0010\u0010j\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\u0018\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u00020G2\u0006\u0010H\u001a\u00020%H\u0016J(\u0010k\u001a\u00020>2\u0006\u0010l\u001a\u00020G2\u0006\u0010H\u001a\u00020%2\u000e\u0010m\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010n07H\u0016J\"\u0010o\u001a\u00020>2\u0006\u0010M\u001a\u00020\r2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020\tH\u0016J\u0010\u0010s\u001a\u00020>2\u0006\u0010t\u001a\u00020\tH\u0014J\u0012\u0010u\u001a\u00020>2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\b\u0010v\u001a\u00020>H\u0016J\u001c\u0010w\u001a\u00060xR\u00020\u00002\u0006\u0010[\u001a\u00020y2\u0006\u0010z\u001a\u00020%H\u0016J\u0010\u0010{\u001a\u00020>2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010|\u001a\u00020>H\u0016J\b\u0010}\u001a\u00020>H\u0016J\u0019\u0010~\u001a\u00020>2\u0006\u0010\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u001a\u0010\u0001\u001a\u00020\t2\u0006\u0010Q\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020%H\u0016J\u0012\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020RH\u0002J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010M\u001a\u00020\rH\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010M\u001a\u00020\rH\u0016J\t\u0010\u0001\u001a\u00020>H\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010Z\u001a\u00020RH\u0002J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010t\u001a\u00020\tH\u0014J\u001a\u0010\u0001\u001a\u00020>2\u0006\u0010Z\u001a\u00020R2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u001a\u0010\u0001\u001a\u00020>2\u0006\u0010\u001a\u00020%2\u0007\u0010\u0001\u001a\u00020nH\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010l\u001a\u00020GH\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010l\u001a\u00020GH\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010l\u001a\u00020GH\u0016J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0002J\u0011\u0010\u0001\u001a\u00020>2\u0006\u0010`\u001a\u00020aH\u0002J\u0017\u0010\u0001\u001a\u00020>2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002080\u0014H\u0002J\u0015\u0010\u0001\u001a\u00020>2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002080\u0014J\u0017\u0010\u0001\u001a\u00020>2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002080\u0014H\u0002J\t\u0010\u0001\u001a\u00020>H\u0002J\u0018\u0010\u0001\u001a\u00020>2\u0007\u0010\u0001\u001a\u00020%2\u0006\u0010D\u001a\u00020ER\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R!\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0019\u001a\u0004\b\u001e\u0010\u001fR\u001b\u0010!\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0019\u001a\u0004\b\"\u0010\u001fR\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u00020%8BX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020.X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\r00j\b\u0012\u0004\u0012\u00020\r`1X\u0004¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\r00j\b\u0012\u0004\u0012\u00020\r`1X\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\r04X\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0004¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\b\u0012\u0004\u0012\u0002080\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010\u0017R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/EditObservableAdapter;", "Lcom/xiaomi/smarthome/newui/adapter/LifeCycleObserverFragment$OnLifeChangeChangeListener;", "Lcom/xiaomi/smarthome/newui/page/CameraEditPage$IExitCallBack;", "Lcom/xiaomi/smarthome/newui/adapter/TabChangeWatcher$OnVisibleChangeListener;", "Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer$PlayStateChangeCallback;", "Lcom/xiaomi/smarthome/newui/NetworkConnectionObserver$OnNetworkChange;", "Landroidx/lifecycle/LifecycleObserver;", "isAllCameraPage", "", "(Z)V", "checkedItems", "", "", "controlViewHandler", "com/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$controlViewHandler$1", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$controlViewHandler$1;", "dragHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "editMenus", "", "Lcom/xiaomi/smarthome/newui/page/AbstractEditPage$EditMenu;", "getEditMenus", "()Ljava/util/List;", "editMenus$delegate", "Lkotlin/Lazy;", "editPage", "Lcom/xiaomi/smarthome/newui/page/CameraEditPage;", "editRemoveMenuRunOnce", "Lcom/xiaomi/smarthome/newui/adapter/RunOnceOn;", "getEditRemoveMenuRunOnce", "()Lcom/xiaomi/smarthome/newui/adapter/RunOnceOn;", "editRemoveMenuRunOnce$delegate", "editTopMenuRunOnce", "getEditTopMenuRunOnce", "editTopMenuRunOnce$delegate", "flexSize", "", "isEnterPinCode", "isOrderDirty", "lastIsEditMode", "lifeObserverObserverTag", "maxPlayCount", "getMaxPlayCount", "()I", "networkConnectionObserver", "Lcom/xiaomi/smarthome/newui/NetworkConnectionObserver;", "oldPinCodeVerifyPassedDevices", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "playErrorDevices", "playQueue", "Ljava/util/Queue;", "powerOnRequestSuccessDevices", "renderData", "", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "selectItems", "getSelectItems", "videoPlayer", "Lcom/xiaomi/smarthome/newui/ViewHolderVideoPlayer;", "adjustLayoutHeightWidthRatioIfNeeded", "", "item", "Landroidx/constraintlayout/widget/ConstraintLayout;", "attachDragHelper", "touchHelper", "clearView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "emit", "event", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "emitTo", "did", "delayed", "", "enterEditMode", "from", "Landroid/view/View;", "exitEditMode", "getAdapterColumn", "getColumn", "getItemCount", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "parent", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "getMovementFlags", "injectLifeCycleObserverIfNeededIn", "context", "Landroid/content/Context;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAppDestroy", "onAppPause", "onAppResume", "onAttachedToRecyclerView", "onBindViewHolder", "holder", "payloads", "", "onCaptureNew", "bitmap", "Landroid/graphics/Bitmap;", "isBlur", "onCardEditModeChanged", "current", "onConfigurationChanged", "onConnected", "onCreateViewHolder", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$VH;", "Landroid/view/ViewGroup;", "viewType", "onDetachedFromRecyclerView", "onDisconnected", "onExit", "onIndicatorChanged", "last", "cur", "onItemMove", "to", "onPinTop", "it", "onPlayError", "onPlayStart", "onReleaseDrag", "onRemove", "onSceneEditModeChanged", "onSelectButtonClick", "isSelectAll", "onTabChanged", "onViewAttachedToWindow", "onViewDetachedFromWindow", "onViewRecycled", "refreshEditPage", "removeLifeChangeObserverIfNeeded", "removeTempPowerOnState", "render", "renderInvoked", "saveOrder", "setAdapterColumn", "column", "Companion", "ControlEvent", "SimpleDiffCallback", "Token", "VH", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FavoriteCameraCardAdapter extends haz implements ez, hbk.O000000o, hbr.O00000Oo, NetworkConnectionObserver.O000000o, ViewHolderVideoPlayer.O00000o0, CameraEditPage.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f10134O000000o = new O000000o((byte) 0);
    public static final HashSet<String> O0000oo0 = new HashSet<>();
    public final boolean O00000Oo;
    public final List<MainCameraCardModel> O0000Oo;
    public gs O0000Oo0;
    public final Set<String> O0000OoO;
    public final ViewHolderVideoPlayer O0000Ooo;
    int O0000o;
    public final HashSet<String> O0000o0;
    public final Queue<String> O0000o00;
    public boolean O0000o0O;
    public final Set<String> O0000o0o;
    public final String O0000oO;
    public final O0000OOo O0000oO0;
    final itz O0000oOO;
    final itz O0000oOo;
    private final HashSet<String> O0000oo;
    private final NetworkConnectionObserver O0000ooO;
    private boolean O0000ooo;
    private CameraEditPage O000O00o;
    private boolean O00oOooO;
    private final itz O00oOooo;

    public final void onViewRecycled(RecyclerView.O000OOo0 o000OOo0) {
        ixe.O00000o(o000OOo0, "holder");
    }

    public /* synthetic */ FavoriteCameraCardAdapter() {
        this(false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        ixe.O00000o(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.device_main_favorite_camera_item, viewGroup, false);
        if (inflate != null) {
            return new O0000O0o(this, inflate);
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.lang.Integer]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public FavoriteCameraCardAdapter(boolean z) {
        this.O00000Oo = z;
        this.O0000oo = new HashSet<>();
        this.O0000Oo = new ArrayList();
        this.O0000OoO = new LinkedHashSet();
        this.O0000ooO = new NetworkConnectionObserver();
        this.O0000Ooo = new ViewHolderVideoPlayer(this, this.O00000Oo);
        this.O0000o00 = new ConcurrentLinkedQueue();
        this.O0000o0 = new HashSet<>();
        this.O0000o0o = new LinkedHashSet();
        hha.O000000o o000000o = hha.f18928O000000o;
        this.O0000o = hha.O000000o.O000000o().O00000o0;
        this.O0000oO0 = new O0000OOo(this, Looper.getMainLooper());
        this.O0000oO = ixe.O000000o("com.xiaomi.smarthome.newui.adapter.LifeCycleObserverFragment : ", (Object) Integer.valueOf(hashCode()));
        this.O0000oOO = iua.O000000o(FavoriteCameraCardAdapter$editTopMenuRunOnce$2.f10167O000000o);
        this.O0000oOo = iua.O000000o(FavoriteCameraCardAdapter$editRemoveMenuRunOnce$2.f10166O000000o);
        this.O00oOooo = iua.O000000o(new FavoriteCameraCardAdapter$editMenus$2(this));
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Companion;", "", "()V", "ENTER_FULL_SCREEN_REQUEST_CODE", "", "KEEP_CONNECTION_TIMEOUT", "TAG", "", "pinCodeVerifyPassedDevices", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    public static int O00000o0() {
        FlexSize.O000000o o000000o = FlexSize.Companion;
        Context appContext = CommonApplication.getAppContext();
        ixe.O00000Oo(appContext, "getAppContext()");
        return FlexSize.O000000o.O00000Oo(appContext) ? 3 : 4;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$controlViewHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000OOo extends Handler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ FavoriteCameraCardAdapter f10160O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O0000OOo(FavoriteCameraCardAdapter favoriteCameraCardAdapter, Looper looper) {
            super(looper);
            this.f10160O000000o = favoriteCameraCardAdapter;
        }

        public final void handleMessage(Message message) {
            ixe.O00000o(message, "msg");
            FavoriteCameraCardAdapter favoriteCameraCardAdapter = this.f10160O000000o;
            int itemCount = favoriteCameraCardAdapter.getItemCount();
            int i = message.what;
            Object obj = message.obj;
            ixe.O00000Oo(obj, "msg.obj");
            favoriteCameraCardAdapter.notifyItemRangeChanged(0, itemCount, new O00000Oo.O00000o(new O00000o(i, obj)));
        }
    }

    private final List<MainCameraCardModel> O0000Ooo() {
        if (this.O0000OoO.isEmpty()) {
            return EmptyList.f15376O000000o;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.O0000Oo) {
            if (this.O0000OoO.contains(((MainCameraCardModel) next).f10175O000000o)) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public final void O000000o(List<MainCameraCardModel> list) {
        ixe.O00000o(list, "data");
        if (!this.O00000oo) {
            O00000Oo(list);
        }
    }

    private final void O00000Oo(List<MainCameraCardModel> list) {
        if (!ixe.O000000o(list, this.O0000Oo)) {
            O00000o0(list);
            gp.O00000Oo O000000o2 = gp.O000000o(new O00000o0(this.O0000Oo, list));
            ixe.O00000Oo(O000000o2, "calculateDiff(SimpleDiffCallback(renderData, data))");
            this.O0000Oo.clear();
            this.O0000Oo.addAll(list);
            O000000o2.O000000o(this);
        }
    }

    private final void O00000o0(List<MainCameraCardModel> list) {
        for (MainCameraCardModel next : list) {
            if (this.O0000o0o.contains(next.f10175O000000o) && next.O0000O0o) {
                this.O0000o0o.remove(next.f10175O000000o);
            }
        }
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
    public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, O00000Oo o00000Oo, String str) {
        ixe.O00000o(favoriteCameraCardAdapter, "this$0");
        ixe.O00000o(o00000Oo, "$event");
        ixe.O00000o(str, "$did");
        Iterator<MainCameraCardModel> it = favoriteCameraCardAdapter.O0000Oo.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (ixe.O000000o((Object) it.next().f10175O000000o, (Object) str)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            favoriteCameraCardAdapter.notifyItemChanged(i, o00000Oo);
        }
    }

    public final void O000000o(O00000Oo o00000Oo) {
        if (getItemCount() != 0) {
            CommonApplication.getGlobalHandler().post(new Runnable(o00000Oo) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$q9RY9Moc8tGX5DWOjiKNvCB5TSo */
                private final /* synthetic */ FavoriteCameraCardAdapter.O00000Oo f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    FavoriteCameraCardAdapter.O000000o(FavoriteCameraCardAdapter.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, O00000Oo o00000Oo) {
        ixe.O00000o(favoriteCameraCardAdapter, "this$0");
        ixe.O00000o(o00000Oo, "$event");
        favoriteCameraCardAdapter.notifyItemRangeChanged(0, favoriteCameraCardAdapter.getItemCount(), o00000Oo);
    }

    public final boolean O000000o(View view) {
        if (this.O00000oo) {
            return false;
        }
        if (this.O000O00o == null) {
            Context context = view.getContext();
            if (context != null) {
                String string = view.getResources().getString(R.string.title_edit_choose_freq_camera);
                ixe.O00000Oo(string, "from.resources.getString(R.string.title_edit_choose_freq_camera)");
                this.O000O00o = new CameraEditPage((FragmentActivity) context, string, this, (List) this.O00oOooo.O000000o());
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            }
        }
        CameraEditPage cameraEditPage = this.O000O00o;
        if (cameraEditPage != null) {
            cameraEditPage.e_();
        }
        this.O00000oo = true;
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000oo, FavoriteCameraCardAdapter$enterEditMode$1.f10168O000000o);
        return true;
    }

    private final boolean O0000o00() {
        if (!this.O00000oo) {
            return false;
        }
        this.O00000oo = false;
        this.O0000ooo = false;
        CameraEditPage cameraEditPage = this.O000O00o;
        if (cameraEditPage != null) {
            cameraEditPage.O00000Oo();
        }
        this.O000O00o = null;
        this.O0000OoO.clear();
        if (this.O00oOooO) {
            this.O00oOooO = false;
            hfy hfy = hfy.f18887O000000o;
            String O0000OOo2 = ggb.O00000Oo().O0000OOo();
            Iterable<MainCameraCardModel> iterable = this.O0000Oo;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (MainCameraCardModel mainCameraCardModel : iterable) {
                arrayList.add(mainCameraCardModel.f10175O000000o);
            }
            List list = (List) arrayList;
            ixe.O00000o(list, "dids");
            ggb O00000Oo2 = ggb.O00000Oo();
            if (TextUtils.isEmpty(O0000OOo2)) {
                O0000OOo2 = O00000Oo2.O00000o0;
            }
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (O0000Oo02 != null && O0000Oo02.isOwner()) {
                List list2 = ggb.O00000o0.O00000o.get(O0000OOo2);
                if (list2 == null) {
                    list2 = new ArrayList(list);
                    ggb.O00000o0.O00000o.put(O0000OOo2, list2);
                } else {
                    list2.clear();
                    list2.addAll(list);
                }
                ggr ggr = ggr.f17748O000000o;
                ggr.O00000Oo(O0000OOo2, list2);
            }
            hfy.O000000o();
        }
        notifyDataSetChanged();
        gzq.O000000o o000000o = gzq.f18638O000000o;
        gzw.O000000o(gzq.O00000oo, FavoriteCameraCardAdapter$exitEditMode$1.f10169O000000o);
        return true;
    }

    public final void O000000o(Context context) {
        String str;
        int size = this.O0000OoO.size();
        boolean z = false;
        if (size == 0) {
            str = context.getResources().getString(R.string.title_edit_choose_freq_camera);
        } else {
            str = context.getResources().getQuantityString(R.plurals.edit_choosed_freq_camera, size, Integer.valueOf(size));
        }
        ixe.O00000Oo(str, "if (checkedSize == 0) {\n            context.resources.getString(R.string.title_edit_choose_freq_camera)\n        } else {\n            context.resources.getQuantityString(\n                R.plurals.edit_choosed_freq_camera,\n                checkedSize,\n                checkedSize\n            )\n        }");
        CameraEditPage cameraEditPage = this.O000O00o;
        if (cameraEditPage != null) {
            if (size == getItemCount()) {
                z = true;
            }
            cameraEditPage.O000000o(str, z);
        }
    }

    public final void O00000Oo(View view) {
        String str;
        boolean z = O0000Ooo().size() == getItemCount();
        if (z) {
            str = view.getResources().getString(R.string.dialog_message_confirm_delete_freq_cameras_all);
        } else {
            str = view.getResources().getQuantityString(R.plurals.dialog_title_confirm_delete_freq_cameras, O0000Ooo().size(), Integer.valueOf(O0000Ooo().size()));
        }
        ixe.O00000Oo(str, "if (isDeleteAll)\n            view.resources.getString(R.string.dialog_message_confirm_delete_freq_cameras_all)\n        else view.resources.getQuantityString(\n            R.plurals.dialog_title_confirm_delete_freq_cameras,\n            selectItems.size,\n            selectItems.size\n        )");
        long currentTimeMillis = System.currentTimeMillis();
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(view.getContext());
        builder.O00000o0();
        if (z) {
            builder.O000000o((int) R.string.dialog_title_confirm_delete_freq_cameras_all);
        }
        builder.O000000o(MLAlertDialog.ButtonStyle.Alert);
        builder.O00000Oo(str);
        builder.O000000o((int) R.string.confirm, new DialogInterface.OnClickListener(z, currentTimeMillis, view) {
            /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$2pPJr5McJvmppsTEVf2Rhognps */
            private final /* synthetic */ boolean f$1;
            private final /* synthetic */ long f$2;
            private final /* synthetic */ View f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r5;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                FavoriteCameraCardAdapter.O000000o(FavoriteCameraCardAdapter.this, this.f$1, this.f$2, this.f$3, dialogInterface, i);
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener(z, currentTimeMillis) {
            /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$EFd3Nop1DJlWeAP_Rp1euHQRg5A */
            private final /* synthetic */ boolean f$0;
            private final /* synthetic */ long f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                FavoriteCameraCardAdapter.O000000o(this.f$0, this.f$1, dialogInterface, i);
            }
        });
        builder.O000000o(true);
        builder.O00000oo();
        hxi.O00000o.f952O000000o.O000000o("camera_remove_click", new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, boolean z, long j, View view, DialogInterface dialogInterface, int i) {
        ixe.O00000o(favoriteCameraCardAdapter, "this$0");
        ixe.O00000o(view, "$view");
        List O000000o2 = iuo.O000000o((Collection) favoriteCameraCardAdapter.O0000Oo);
        List<MainCameraCardModel> O0000Ooo2 = favoriteCameraCardAdapter.O0000Ooo();
        O000000o2.removeAll(O0000Ooo2);
        favoriteCameraCardAdapter.O00000Oo(O000000o2);
        favoriteCameraCardAdapter.O0000o00();
        hfy hfy = hfy.f18887O000000o;
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        Iterable<MainCameraCardModel> iterable = O0000Ooo2;
        Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
        for (MainCameraCardModel mainCameraCardModel : iterable) {
            arrayList.add(mainCameraCardModel.f10175O000000o);
        }
        favoriteCameraCardAdapter.O00000o0.add(hfy.O000000o(O0000Oo02, (List) arrayList).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(view) {
            /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$OKRrnp6VjlAMKSCpsPhoJORyMhI */
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                FavoriteCameraCardAdapter.O000000o(this.f$0, (Boolean) obj);
            }
        }, new Consumer(view) {
            /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$Ed9I8E4fhiOiwtG_Dy7QTup9G8k */
            private final /* synthetic */ View f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj) {
                FavoriteCameraCardAdapter.O000000o(this.f$0, (Throwable) obj);
            }
        }));
        dialogInterface.dismiss();
        if (z) {
            hxi.O00000o0.O000000o(2, System.currentTimeMillis() - j);
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, Boolean bool) {
        ixe.O00000o(view, "$view");
        view.getContext();
        gqg.O000000o((int) R.string.action_success);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(View view, Throwable th) {
        ixe.O00000o(view, "$view");
        view.getContext();
        gqg.O000000o((int) R.string.action_fail);
    }

    /* access modifiers changed from: private */
    public static final void O000000o(boolean z, long j, DialogInterface dialogInterface, int i) {
        if (z) {
            hxi.O00000o0.O000000o(1, System.currentTimeMillis() - j);
        }
        dialogInterface.cancel();
    }

    public final void O00000o() {
        List<MainCameraCardModel> O0000Ooo2 = O0000Ooo();
        List O000000o2 = iuo.O000000o((Collection) this.O0000Oo);
        Collection collection = O0000Ooo2;
        O000000o2.removeAll(collection);
        O000000o2.addAll(0, collection);
        O00000Oo(O000000o2);
        this.O00oOooO = true;
        O0000o00();
        hxi.O00000o.f952O000000o.O000000o("camera_totop_click", new Object[0]);
    }

    public final void O00000oO() {
        O000000o((O00000Oo) O00000Oo.C0086O00000Oo.f10136O000000o);
        NetworkConnectionObserver networkConnectionObserver = this.O0000ooO;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        CommonApplication.getApplication().registerReceiver(networkConnectionObserver, intentFilter);
        networkConnectionObserver.f10115O000000o = this;
        Set<String> O000000o2 = ivg.O000000o(O0000oo0, this.O0000oo);
        if (!O000000o2.isEmpty()) {
            for (String str : O000000o2) {
                O000000o(this, str, new O00000Oo.O000OO00(str));
            }
            this.O0000oo.clear();
        }
    }

    public final void O0000Oo() {
        if (this.O0000o0O) {
            this.O0000o0O = false;
            return;
        }
        ViewHolderVideoPlayer viewHolderVideoPlayer = this.O0000Ooo;
        List O00000o02 = iuo.O00000o0(this.O0000o00);
        ixe.O00000o(O00000o02, "connectionsMayAlive");
        viewHolderVideoPlayer.O000000o(O00000o02);
        O000000o((O00000Oo) O00000Oo.O000000o.f10135O000000o);
        NetworkConnectionObserver networkConnectionObserver = this.O0000ooO;
        CommonApplication.getApplication().unregisterReceiver(networkConnectionObserver);
        networkConnectionObserver.f10115O000000o = null;
        this.O0000oo.clear();
        this.O0000oo.addAll(O0000oo0);
    }

    @fi(O000000o = Lifecycle.Event.ON_DESTROY)
    public final void onAppDestroy() {
        if (!this.O00000Oo) {
            O0000oo0.clear();
        }
    }

    public final void O00000Oo(String str) {
        ixe.O00000o(str, "did");
        gqg.O00000Oo((int) R.string.loading_failed);
        O000000o(this, str, new O00000Oo.O0000o(str));
    }

    public final void O000000o(String str) {
        ixe.O00000o(str, "did");
        O000000o(this, str, new O00000Oo.O00oOooO(str));
    }

    public final void O000000o(String str, Bitmap bitmap, boolean z) {
        ixe.O00000o(str, "did");
        O000000o(this, str, new O00000Oo.O0000o00(str, bitmap, z));
    }

    public final void O00000Oo() {
        if (!this.O0000o00.isEmpty()) {
            if (!htr.f689O000000o) {
                gqg.O00000Oo((int) R.string.network_disable);
            }
            O000000o((O00000Oo) O00000Oo.O0000o0.f10144O000000o);
        }
    }

    public final void O000000o(int i) {
        O000000o(i == 0 ? O00000Oo.O000OO.f10150O000000o : O00000Oo.O000OOOo.f10153O000000o);
    }

    public final void O000000o(Object obj) {
        ixe.O00000o(obj, "cur");
        O000000o(ixe.O000000o(obj, 0) ? O00000Oo.O000O00o.f10146O000000o : O00000Oo.O000O0OO.f10147O000000o);
    }

    public final void O0000OoO() {
        O0000o00();
    }

    public final void O000000o(View view, boolean z) {
        ixe.O00000o(view, "view");
        if (z) {
            Set<String> set = this.O0000OoO;
            Iterable<MainCameraCardModel> iterable = this.O0000Oo;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (MainCameraCardModel mainCameraCardModel : iterable) {
                arrayList.add(mainCameraCardModel.f10175O000000o);
            }
            set.addAll((List) arrayList);
        } else {
            this.O0000OoO.clear();
        }
        notifyDataSetChanged();
        Context context = view.getContext();
        ixe.O00000Oo(context, "view.context");
        O000000o(context);
    }

    public final void O000000o(boolean z) {
        super.O000000o(z);
        this.O0000o00.clear();
        notifyDataSetChanged();
    }

    public final void O00000o(boolean z) {
        super.O00000o(z);
        this.O0000o00.clear();
        notifyDataSetChanged();
    }

    public final void O0000OOo() {
        boolean z = this.O00000oo && !this.O0000ooo;
        this.O0000ooo = this.O00000oo;
        if (z) {
            O000000o((O00000Oo) O00000Oo.O0000O0o.f10139O000000o);
            this.O0000oO0.removeCallbacksAndMessages(null);
        }
    }

    public final void O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0, int i) {
        View view;
        super.O000000o(recyclerView, o000OOo0, i);
        if (o000OOo0 == null) {
            view = null;
        } else {
            view = o000OOo0.itemView;
        }
        if (view != null) {
            view.setBackground(null);
        }
        notifyItemChanged(i);
    }

    public final boolean O000000o(int i, int i2) {
        this.O00oOooO = true;
        if (i >= i2) {
            int i3 = i2 + 1;
            if (i3 <= i) {
                int i4 = i;
                while (true) {
                    int i5 = i4 - 1;
                    Collections.swap(this.O0000Oo, i4, i4 - 1);
                    if (i4 == i3) {
                        break;
                    }
                    i4 = i5;
                }
            }
        } else if (i < i2) {
            int i6 = i;
            while (true) {
                int i7 = i6 + 1;
                Collections.swap(this.O0000Oo, i6, i7);
                if (i7 >= i2) {
                    break;
                }
                i6 = i7;
            }
        }
        notifyItemMoved(i, i2);
        return true;
    }

    public final int O000000o(RecyclerView recyclerView, RecyclerView.O000OOo0 o000OOo0) {
        if (this.O00000Oo || this.O00000oO || this.O00000o) {
            return 0;
        }
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (ixe.O000000o(O0000Oo02 == null ? null : Boolean.valueOf(O0000Oo02.isOwner()), Boolean.FALSE)) {
            return 0;
        }
        return gs.O000000o.O000000o(15);
    }

    public final void O000000o(gs gsVar) {
        ixe.O00000o(gsVar, "touchHelper");
        this.O0000Oo0 = gsVar;
    }

    public final int O000000o() {
        return this.O0000o;
    }

    public final int getItemCount() {
        return this.O0000Oo.size();
    }

    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        ixe.O00000o(o000OOo0, "holder");
        O0000O0o o0000O0o = (O0000O0o) o000OOo0;
        o0000O0o.O00000o();
        MainCameraCardModel mainCameraCardModel = this.O0000Oo.get(i);
        ixe.O00000o(mainCameraCardModel, "cameraModel");
        gsy.O00000Oo("FavoriteCameraCard", "bind: ");
        Device O000000o2 = fno.O000000o().O000000o(mainCameraCardModel.f10175O000000o);
        if (O000000o2 != null) {
            o0000O0o.O0000O0o = mainCameraCardModel;
            String str = mainCameraCardModel.O00000o0;
            String str2 = mainCameraCardModel.O00000o;
            o0000O0o.O00000o0.setText(str);
            o0000O0o.O00000o.setText(str2);
            if (mainCameraCardModel.O00000oO) {
                o0000O0o.O000000o(mainCameraCardModel);
            } else {
                o0000O0o.O00000Oo.setVisibility(4);
                o0000O0o.f10157O000000o.setTag(null);
                o0000O0o.f10157O000000o.setImageBitmap(null);
                o0000O0o.f10157O000000o.setBackgroundResource(R.drawable.camera_default_gradient);
            }
            Object tag = o0000O0o.O00000oo.getTag();
            hba hba = tag instanceof hba ? (hba) tag : null;
            if (hba != null) {
                hba.O00000Oo();
            }
            o0000O0o.O00000oo.setTag(null);
            o0000O0o.O00000Oo(mainCameraCardModel);
            o0000O0o.O000000o(mainCameraCardModel, O000000o2);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
     arg types: [java.lang.String, java.util.List]
     candidates:
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
    public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i, List<Object> list) {
        Class<?> cls;
        ixe.O00000o(o000OOo0, "holder");
        ixe.O00000o(list, "payloads");
        O0000O0o o0000O0o = (O0000O0o) o000OOo0;
        if (!list.isEmpty()) {
            Iterable iterable = list;
            Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
            for (Object next : iterable) {
                String str = null;
                if (!(next == null || (cls = next.getClass()) == null)) {
                    str = cls.getSimpleName();
                }
                arrayList.add(str);
            }
            gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("onBindViewHolder: ", (Object) ((List) arrayList)));
            for (Object next2 : list) {
                if (next2 instanceof O00000Oo) {
                    o0000O0o.O000000o((O00000Oo) next2);
                }
            }
            return;
        }
        super.onBindViewHolder(o000OOo0, i, list);
    }

    @Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010+\u001a\u00020*H\u0002J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010/\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0002J\u0010\u00105\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u00106\u001a\u00020-2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020-H\u0002J\b\u0010:\u001a\u00020-H\u0002J\b\u0010;\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u000208H\u0002J\b\u0010?\u001a\u00020-H\u0002J\u0006\u0010@\u001a\u00020-J\u000e\u0010A\u001a\u00020-2\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020-J\u0010\u0010E\u001a\u00020-2\u0006\u0010F\u001a\u000208H\u0002J\b\u0010G\u001a\u00020-H\u0002J\u0010\u0010H\u001a\u00020-2\u0006\u0010I\u001a\u00020<H\u0002J\u0006\u0010J\u001a\u00020-J\u0010\u0010K\u001a\u00020-2\u0006\u0010F\u001a\u000208H\u0002J\u0010\u0010L\u001a\u00020-2\u0006\u00103\u001a\u000204H\u0002J\u0018\u0010M\u001a\u00020-2\u0006\u00103\u001a\u0002042\u0006\u0010F\u001a\u000208H\u0002J\u0012\u0010N\u001a\u00020<2\b\b\u0002\u0010I\u001a\u00020<H\u0002J\b\u0010O\u001a\u00020-H\u0002J\b\u0010P\u001a\u00020-H\u0002J\u001c\u0010Q\u001a\u00020<2\b\b\u0002\u0010R\u001a\u00020\u001e2\b\b\u0002\u0010I\u001a\u00020<H\u0002J\b\u0010S\u001a\u00020TH\u0002J\u0015\u0010U\u001a\u00020V*\u00020V2\u0006\u0010W\u001a\u00020VH\u0004R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$VH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter;Landroid/view/View;)V", "cameraModel", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "cameraVideoLayout", "Landroid/widget/FrameLayout;", "centralPlayIv", "Landroid/widget/ImageView;", "checkBox", "Landroid/widget/CheckBox;", "container", "Landroidx/constraintlayout/widget/ConstraintLayout;", "controlGroup", "Lcom/xiaomi/smarthome/newui/adapter/GroupDelegate;", "controlMuteIv", "controlPlayFullScreenIv", "controlPlayIv", "coverContainer", "coverIv", "Lcom/facebook/drawee/view/SimpleDraweeView;", "coverMask", "deviceNameTv", "Landroid/widget/TextView;", "editMask", "Lcom/xiaomi/smarthome/newui/mainpage/EditMaskView;", "enterPluginIv", "from", "", "getFrom", "()I", "infoGroup", "loadingProgress", "Landroid/widget/ProgressBar;", "loadingProgressTv", "roomNameTv", "stateGroup", "stateIv", "stateTv", "videoView", "Lcom/xiaomi/smarthome/fastvideo/VideoView;", "addVideoView", "adjustItemLayoutIfNeeded", "", "bind", "bindEvents", "device", "Lcom/xiaomi/smarthome/device/Device;", "bindOnError", "context", "Landroid/content/Context;", "bindOnline", "bindState", "deviceBinded", "", "hideControlViewDelayed", "hideControlViewNow", "isStartPlay", "", "muteOthers", "excludeDid", "muteSelf", "onAttach", "onControlEvent", "event", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "onDetach", "onPinCodePass", "did", "onStartPlay", "onStopPlay", "silent", "onViewRecycled", "requestPowerOnAndPlay", "showConnectHelperDialog", "showPinCodeVerifyPage", "startPlay", "startPlayWithSimulateClick", "stopOther", "stopPlay", "keepConnectionWithTimeout", "token", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Token;", "or", "", "num", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O0000O0o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final SimpleDraweeView f10157O000000o;
        public final View O00000Oo;
        final TextView O00000o;
        final TextView O00000o0;
        public final ImageView O00000oO;
        final ProgressBar O00000oo;
        public MainCameraCardModel O0000O0o;
        final /* synthetic */ FavoriteCameraCardAdapter O0000OOo;
        private final hbh O0000Oo = new hbh(new int[]{R.id.device_name, R.id.room_name});
        private final hbh O0000Oo0 = new hbh(new int[]{R.id.camera_control_mute_iv, R.id.camera_control_play_iv, R.id.camera_control_full_screen_iv, R.id.top_shadow, R.id.bottom_shadow});
        private final hbh O0000OoO = new hbh(new int[]{R.id.camera_state_desc, R.id.camera_state_iv});
        private final ConstraintLayout O0000Ooo;
        private final TextView O0000o;
        private final View O0000o0;
        private final FrameLayout O0000o00;
        private final ImageView O0000o0O;
        private final ImageView O0000o0o;
        private final ImageView O0000oO;
        private final ImageView O0000oO0;
        private final ImageView O0000oOO;
        private final EditMaskView O0000oOo;
        private final TextView O0000oo;
        private final CheckBox O0000oo0;
        private VideoView O0000ooO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O0000O0o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, View view) {
            super(view);
            ixe.O00000o(favoriteCameraCardAdapter, "this$0");
            ixe.O00000o(view, "itemView");
            this.O0000OOo = favoriteCameraCardAdapter;
            View findViewById = view.findViewById(R.id.container);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.container)");
            this.O0000Ooo = (ConstraintLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.camera_frame_layout);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.camera_frame_layout)");
            this.O0000o00 = (FrameLayout) findViewById2;
            View findViewById3 = view.findViewById(R.id.cover);
            ixe.O00000Oo(findViewById3, "itemView.findViewById(R.id.cover)");
            this.f10157O000000o = (SimpleDraweeView) findViewById3;
            View findViewById4 = view.findViewById(R.id.cover_mask);
            ixe.O00000Oo(findViewById4, "itemView.findViewById(R.id.cover_mask)");
            this.O00000Oo = findViewById4;
            View findViewById5 = view.findViewById(R.id.cover_container);
            ixe.O00000Oo(findViewById5, "itemView.findViewById(R.id.cover_container)");
            this.O0000o0 = findViewById5;
            View findViewById6 = view.findViewById(R.id.device_name);
            ixe.O00000Oo(findViewById6, "itemView.findViewById(R.id.device_name)");
            this.O00000o0 = (TextView) findViewById6;
            View findViewById7 = view.findViewById(R.id.room_name);
            ixe.O00000Oo(findViewById7, "itemView.findViewById(R.id.room_name)");
            this.O00000o = (TextView) findViewById7;
            View findViewById8 = view.findViewById(R.id.enter_plugin);
            ixe.O00000Oo(findViewById8, "itemView.findViewById(R.id.enter_plugin)");
            this.O0000o0O = (ImageView) findViewById8;
            View findViewById9 = view.findViewById(R.id.player_icon_center);
            ixe.O00000Oo(findViewById9, "itemView.findViewById(R.id.player_icon_center)");
            this.O0000o0o = (ImageView) findViewById9;
            View findViewById10 = view.findViewById(R.id.camera_state_iv);
            ixe.O00000Oo(findViewById10, "itemView.findViewById(R.id.camera_state_iv)");
            this.O00000oO = (ImageView) findViewById10;
            View findViewById11 = view.findViewById(R.id.camera_state_desc);
            ixe.O00000Oo(findViewById11, "itemView.findViewById(R.id.camera_state_desc)");
            this.O0000o = (TextView) findViewById11;
            View findViewById12 = view.findViewById(R.id.camera_control_mute_iv);
            ixe.O00000Oo(findViewById12, "itemView.findViewById(R.id.camera_control_mute_iv)");
            this.O0000oO0 = (ImageView) findViewById12;
            View findViewById13 = view.findViewById(R.id.camera_control_play_iv);
            ixe.O00000Oo(findViewById13, "itemView.findViewById(R.id.camera_control_play_iv)");
            this.O0000oO = (ImageView) findViewById13;
            View findViewById14 = view.findViewById(R.id.camera_control_full_screen_iv);
            ixe.O00000Oo(findViewById14, "itemView.findViewById(R.id.camera_control_full_screen_iv)");
            this.O0000oOO = (ImageView) findViewById14;
            View findViewById15 = view.findViewById(R.id.edit_mask);
            ixe.O00000Oo(findViewById15, "itemView.findViewById(R.id.edit_mask)");
            this.O0000oOo = (EditMaskView) findViewById15;
            View findViewById16 = view.findViewById(R.id.check_box);
            ixe.O00000Oo(findViewById16, "itemView.findViewById(R.id.check_box)");
            this.O0000oo0 = (CheckBox) findViewById16;
            View findViewById17 = view.findViewById(R.id.loading_progress);
            ixe.O00000Oo(findViewById17, "itemView.findViewById(R.id.loading_progress)");
            this.O00000oo = (ProgressBar) findViewById17;
            View findViewById18 = view.findViewById(R.id.loading_progress_tv);
            ixe.O00000Oo(findViewById18, "itemView.findViewById(R.id.loading_progress_tv)");
            this.O0000oo = (TextView) findViewById18;
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$VH$bindOnline$1", "Lcom/xiaomi/smarthome/newui/FrescoBitmapCache$Callback;", "onFail", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000Oo implements gzx.O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O0000O0o f10159O000000o;

            O00000Oo(O0000O0o o0000O0o) {
                this.f10159O000000o = o0000O0o;
            }

            public final void O000000o() {
                this.f10159O000000o.O00000Oo.setVisibility(4);
            }
        }

        private final int O00000oO() {
            if (!this.O0000OOo.O00000Oo) {
                return 1;
            }
            return this.O0000OOo.O0000o == 1 ? 2 : 3;
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O0000O0o o0000O0o, String str, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(str, "$did");
            hxi.O00000o.f952O000000o.O000000o("camera_lock_click", "from", Integer.valueOf(o0000O0o.O00000oO()));
            Context context = view.getContext();
            ixe.O00000Oo(context, "it.context");
            o0000O0o.O0000OOo.O0000o0O = true;
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
                Fragment O000000o2 = supportFragmentManager.O000000o(o0000O0o.O0000OOo.O0000oO);
                if (O000000o2 != null) {
                    CameraRouterFactory.getCameraManagerApi().openDevicePinVerifyDialog(O000000o2, context, str, 9999);
                }
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int
         arg types: [java.lang.String, java.lang.String, int, int, int]
         candidates:
          _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean):boolean
          _m_j.iyw.O000000o(java.lang.String, java.lang.String, int, int, boolean):boolean
          _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.String, int, boolean, int):int */
        private final void O00000Oo(Context context) {
            hbh hbh = this.O0000OoO;
            View view = this.itemView;
            ixe.O00000Oo(view, "itemView");
            hbh.O000000o(view, 0);
            SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf("");
            String string = context.getString(R.string.mj_camera_card_error_main);
            ixe.O00000Oo(string, "context.getString(R.string.mj_camera_card_error_main)");
            String string2 = context.getString(R.string.mj_camera_card_error_sub);
            ixe.O00000Oo(string2, "context.getString(R.string.mj_camera_card_error_sub)");
            ixh ixh = ixh.f1644O000000o;
            String format = String.format(string, Arrays.copyOf(new Object[]{string2}, 1));
            ixe.O00000Oo(format, "java.lang.String.format(format, *args)");
            valueOf.append((CharSequence) format);
            String spannableStringBuilder = valueOf.toString();
            ixe.O00000Oo(spannableStringBuilder, "spannable.toString()");
            int O000000o2 = iyo.O000000o((CharSequence) spannableStringBuilder, string2, 0, false, 6);
            valueOf.setSpan(new O000000o(this), O000000o2, string2.length() + O000000o2, 33);
            this.O0000OOo.O0000oO0.removeMessages(O000000o().f10155O000000o);
            hbh hbh2 = this.O0000Oo0;
            View view2 = this.itemView;
            ixe.O00000Oo(view2, "itemView");
            hbh2.O000000o(view2, 4);
            this.O0000o0o.setVisibility(4);
            this.O0000o.setVisibility(0);
            this.O00000oO.setVisibility(0);
            this.O0000o.setHighlightColor(0);
            this.O0000o.setMovementMethod(LinkMovementMethod.getInstance());
            this.O0000o.setText(valueOf);
            this.O00000oO.setImageResource(R.drawable.icon_camera_reconnect_bg);
            this.O00000oo.clearAnimation();
            this.O00000oo.setVisibility(4);
            Object tag = this.O00000oo.getTag();
            hba hba = tag instanceof hba ? (hba) tag : null;
            if (hba != null) {
                hba.O00000Oo();
            }
            this.O00000oo.setTag(null);
            this.O0000oo.setVisibility(4);
            this.O0000oo.setTag(null);
            this.O00000oO.setOnClickListener(new View.OnClickListener(this.O0000OOo, context) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$pWnlxhf92Nj2mqkDMvrlgfgrrr4 */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ Context f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, view);
                }
            });
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$VH$bindOnError$clickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "view", "Landroid/view/View;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o extends ClickableSpan {

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ O0000O0o f10158O000000o;

            O000000o(O0000O0o o0000O0o) {
                this.f10158O000000o = o0000O0o;
            }

            public final void onClick(View view) {
                ixe.O00000o(view, "view");
                O0000O0o o0000O0o = this.f10158O000000o;
                Context context = view.getContext();
                ixe.O00000Oo(context, "view.context");
                o0000O0o.O000000o(context);
            }
        }

        public final void O000000o(Context context) {
            MLAlertDialog O00000o2 = new MLAlertDialog.Builder(context).O00000o0().O000000o((int) R.string.qr_help_title).O000000o(true).O000000o((int) R.string.confirm, $$Lambda$FavoriteCameraCardAdapter$O0000O0o$gMuqpIX6OHHU5A9NKgARbpmbPY0.INSTANCE).O00000o();
            ixe.O00000Oo(O00000o2, "dialog");
            O00000o2.setView((View) new FavoriteCameraCardAdapter$VH$showConnectHelperDialog$getContentView$1(context, this, this.O0000OOo).invoke(O00000o2));
            O00000o2.show();
        }

        /* access modifiers changed from: private */
        public static final void O000000o(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }

        /* access modifiers changed from: private */
        public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, String str, Boolean bool) {
            ixe.O00000o(favoriteCameraCardAdapter, "this$0");
            ixe.O00000o(str, "$did");
            ixe.O00000Oo(bool, "result");
            FavoriteCameraCardAdapter.O000000o(favoriteCameraCardAdapter, str, new O00000Oo.O000O0o(str, bool.booleanValue()));
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(MainCameraCardModel mainCameraCardModel, Device device) {
            this.itemView.setOnClickListener(new View.OnClickListener(mainCameraCardModel, this, device) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$gLDzhwmXBUwHgVt3nwzEU83x23E */
                private final /* synthetic */ MainCameraCardModel f$1;
                private final /* synthetic */ FavoriteCameraCardAdapter.O0000O0o f$2;
                private final /* synthetic */ Device f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.this, this.f$1, this.f$2, this.f$3, view);
                }
            });
            this.O0000o0o.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000o0o.setClickable(!this.O0000OOo.O00000oo);
            this.O0000o0o.setOnClickListener(new View.OnClickListener(this.O0000OOo, mainCameraCardModel) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$IwhNtCytCtXD5gTPBmiu3WrOFzY */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ MainCameraCardModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, view);
                }
            });
            this.O0000oO.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000oO.setClickable(!this.O0000OOo.O00000oo);
            this.O0000oO.setOnClickListener(new View.OnClickListener(this.O0000OOo, mainCameraCardModel) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$QuDc3lyb_gJLi4_bE6eUyGj8Dhg */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ MainCameraCardModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O00000Oo(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, view);
                }
            });
            this.O0000oO0.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000oO0.setClickable(!this.O0000OOo.O00000oo);
            this.O0000oO0.setOnClickListener(new View.OnClickListener(this.O0000OOo, device, mainCameraCardModel) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$1dELN2tWCjh8S5mPmXyb5g66FfI */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ Device f$2;
                private final /* synthetic */ MainCameraCardModel f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, this.f$3, view);
                }
            });
            this.O0000oOO.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000oOO.setClickable(!this.O0000OOo.O00000oo);
            this.O0000oOO.setOnClickListener(new View.OnClickListener(this.O0000OOo, mainCameraCardModel) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$VuTy2K_1ux7yAVwFOQZUu_xOg */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ MainCameraCardModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O00000o0(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, view);
                }
            });
            this.O0000o0O.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000o0O.setClickable(!this.O0000OOo.O00000oo);
            this.O0000o0O.setOnClickListener(new View.OnClickListener(this.O0000OOo, device) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$yv4JzJgjQnul6_D2kU45c9wom4 */
                private final /* synthetic */ FavoriteCameraCardAdapter f$1;
                private final /* synthetic */ Device f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, this.f$2, view);
                }
            });
            this.itemView.setOnLongClickListener(new View.OnLongClickListener(this, mainCameraCardModel) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$Dlvi1NKtC4jdVyV_tNaJ7REQWp0 */
                private final /* synthetic */ FavoriteCameraCardAdapter.O0000O0o f$1;
                private final /* synthetic */ MainCameraCardModel f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final boolean onLongClick(View view) {
                    return FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.this, this.f$1, this.f$2, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, MainCameraCardModel mainCameraCardModel, O0000O0o o0000O0o, Device device, View view) {
            ixe.O00000o(favoriteCameraCardAdapter, "this$0");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            ixe.O00000o(o0000O0o, "this$1");
            ixe.O00000o(device, "$device");
            int i = 0;
            if (favoriteCameraCardAdapter.O00000oo) {
                if (favoriteCameraCardAdapter.O0000OoO.contains(mainCameraCardModel.f10175O000000o)) {
                    favoriteCameraCardAdapter.O0000OoO.remove(mainCameraCardModel.f10175O000000o);
                } else {
                    favoriteCameraCardAdapter.O0000OoO.add(mainCameraCardModel.f10175O000000o);
                }
                CheckBox checkBox = o0000O0o.O0000oo0;
                if (!favoriteCameraCardAdapter.O0000OoO.contains(mainCameraCardModel.f10175O000000o)) {
                    i = 4;
                }
                checkBox.setVisibility(i);
                CheckBox checkBox2 = o0000O0o.O0000oo0;
                checkBox2.setChecked(!checkBox2.isChecked());
                Context context = view.getContext();
                ixe.O00000Oo(context, "it.context");
                favoriteCameraCardAdapter.O000000o(context);
            } else if (!mainCameraCardModel.O00000oO) {
                hxi.O00000o.O0000oO0(o0000O0o.O00000oO());
                favoriteCameraCardAdapter.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
                ixe.O00000Oo(view, "it");
                hak.O000000o(view, FavoriteCameraCardAdapter$VH$bindEvents$1$1.f10161O000000o);
                ext.O000000o o000000o = ext.f15931O000000o;
                eyc O000000o2 = ext.O000000o.O000000o(device);
                Handler handler = new Handler(Looper.getMainLooper());
                Context context2 = view.getContext();
                Context context3 = view.getContext();
                if (context3 != null) {
                    O000000o2.onItemClick(view, handler, device, context2, (BaseActivity) context3);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.framework.page.BaseActivity");
            } else if (o0000O0o.O0000Oo0() && !favoriteCameraCardAdapter.O0000o0.contains(mainCameraCardModel.f10175O000000o)) {
                favoriteCameraCardAdapter.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
                if (mainCameraCardModel.O00000oO) {
                    hbh hbh = o0000O0o.O0000Oo0;
                    View view2 = o0000O0o.itemView;
                    ixe.O00000Oo(view2, "itemView");
                    if (!(hbh.O000000o(view2) == 0 || o0000O0o.O0000o0o.getVisibility() == 0)) {
                        hbh hbh2 = o0000O0o.O0000Oo0;
                        View view3 = o0000O0o.itemView;
                        ixe.O00000Oo(view3, "itemView");
                        hbh2.O000000o(view3, 0);
                        hbh hbh3 = o0000O0o.O0000Oo;
                        View view4 = o0000O0o.itemView;
                        ixe.O00000Oo(view4, "itemView");
                        hbh3.O000000o(view4, 0);
                        o0000O0o.O0000o0O.setVisibility(0);
                        o0000O0o.O00000oo();
                        return;
                    }
                }
                hbh hbh4 = o0000O0o.O0000Oo0;
                View view5 = o0000O0o.itemView;
                ixe.O00000Oo(view5, "itemView");
                hbh4.O000000o(view5, 4);
                hbh hbh5 = o0000O0o.O0000Oo;
                View view6 = o0000O0o.itemView;
                ixe.O00000Oo(view6, "itemView");
                hbh5.O000000o(view6, 4);
                o0000O0o.O0000o0O.setVisibility(4);
                if (o0000O0o.O0000Oo0()) {
                    o0000O0o.O0000oO.setImageResource(R.drawable.all_camera_item_pause_selector);
                } else {
                    o0000O0o.O0000oO.setImageResource(R.drawable.all_camera_item_play_selector);
                }
                ViewHolderVideoPlayer viewHolderVideoPlayer = favoriteCameraCardAdapter.O0000Ooo;
                String str = device.did;
                ixe.O00000Oo(str, "device.did");
                if (viewHolderVideoPlayer.O00000Oo(str)) {
                    o0000O0o.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_on);
                } else {
                    o0000O0o.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_off);
                }
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, MainCameraCardModel mainCameraCardModel, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            o0000O0o.O00000oo();
            if (o0000O0o.O000000o(false)) {
                hxi.O00000o.O0000o(o0000O0o.O00000oO());
                view.setVisibility(4);
                if (!favoriteCameraCardAdapter.O0000o00.contains(mainCameraCardModel.f10175O000000o)) {
                    favoriteCameraCardAdapter.O0000o00.offer(mainCameraCardModel.f10175O000000o);
                }
                o0000O0o.O0000oO.setImageResource(R.drawable.all_camera_item_pause_selector);
                hbh hbh = o0000O0o.O0000Oo0;
                View view2 = o0000O0o.itemView;
                ixe.O00000Oo(view2, "itemView");
                hbh.O000000o(view2, 0);
                hbh hbh2 = o0000O0o.O0000Oo;
                View view3 = o0000O0o.itemView;
                ixe.O00000Oo(view3, "itemView");
                hbh2.O000000o(view3, 0);
                o0000O0o.O0000o0O.setVisibility(0);
            }
        }

        /* access modifiers changed from: private */
        public static final void O00000Oo(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, MainCameraCardModel mainCameraCardModel, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            if (o0000O0o.O0000Oo0()) {
                hxk hxk = hxi.O00000o;
                int O00000oO2 = o0000O0o.O00000oO();
                hxk.f952O000000o.O000000o("camera_pause_click", "from", Integer.valueOf(O00000oO2));
                favoriteCameraCardAdapter.O0000o00.remove(mainCameraCardModel.f10175O000000o);
                O000000o(o0000O0o, 0, 3);
                favoriteCameraCardAdapter.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
                o0000O0o.O0000oO.setImageResource(R.drawable.all_camera_item_play_selector);
                return;
            }
            o0000O0o.O00000oo();
            if (!favoriteCameraCardAdapter.O0000o00.contains(mainCameraCardModel.f10175O000000o) && o0000O0o.O000000o(false)) {
                hxi.O00000o.O0000o(o0000O0o.O00000oO());
                favoriteCameraCardAdapter.O0000o00.offer(mainCameraCardModel.f10175O000000o);
                o0000O0o.O0000oO.setImageResource(R.drawable.all_camera_item_pause_selector);
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, Device device, MainCameraCardModel mainCameraCardModel, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(device, "$device");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            o0000O0o.O00000oo();
            ViewHolderVideoPlayer viewHolderVideoPlayer = favoriteCameraCardAdapter.O0000Ooo;
            String str = device.did;
            ixe.O00000Oo(str, "device.did");
            if (viewHolderVideoPlayer.O00000Oo(str)) {
                hxi.O00000o.O00000Oo(2, o0000O0o.O00000oO());
                ViewHolderVideoPlayer viewHolderVideoPlayer2 = favoriteCameraCardAdapter.O0000Ooo;
                Context context = o0000O0o.itemView.getContext();
                ixe.O00000Oo(context, "itemView.context");
                String str2 = device.did;
                ixe.O00000Oo(str2, "device.did");
                ixe.O00000o(context, "context");
                ixe.O00000o(str2, "did");
                viewHolderVideoPlayer2.O00000o0.put(str2, Boolean.FALSE);
                viewHolderVideoPlayer2.O00000Oo(context, str2);
                o0000O0o.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_off);
                o0000O0o.O0000OOo.O000000o((O00000Oo) new O00000Oo.O0000Oo(mainCameraCardModel.f10175O000000o));
                return;
            }
            hxi.O00000o.O00000Oo(1, o0000O0o.O00000oO());
            ViewHolderVideoPlayer viewHolderVideoPlayer3 = favoriteCameraCardAdapter.O0000Ooo;
            Context context2 = o0000O0o.itemView.getContext();
            ixe.O00000Oo(context2, "itemView.context");
            String str3 = device.did;
            ixe.O00000Oo(str3, "device.did");
            viewHolderVideoPlayer3.O000000o(context2, str3);
            o0000O0o.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_on);
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
        public static final void O00000o0(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, MainCameraCardModel mainCameraCardModel, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            O000000o(o0000O0o, Integer.MAX_VALUE, 2);
            favoriteCameraCardAdapter.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
            hxi.O00000o.f952O000000o.O000000o("camera_fullscreen_click", "from", Integer.valueOf(o0000O0o.O00000oO()));
            Context context = view.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                fbt fbt = new fbt(fragmentActivity, "CameraHorizontalActivity");
                Iterable<MainCameraCardModel> iterable = favoriteCameraCardAdapter.O0000Oo;
                Collection arrayList = new ArrayList(iuo.O000000o(iterable, 10));
                for (MainCameraCardModel mainCameraCardModel2 : iterable) {
                    arrayList.add(mainCameraCardModel2.f10175O000000o);
                }
                Object[] array = ((List) arrayList).toArray(new String[0]);
                if (array != null) {
                    fbt.O000000o("did", mainCameraCardModel.f10175O000000o);
                    fbt.O000000o("play_list", (String[]) array);
                    fbt.O000000o("isMute", favoriteCameraCardAdapter.O0000Ooo.O00000Oo(mainCameraCardModel.f10175O000000o));
                    fbt.O000000o("isAutoPlay", true);
                    fbt.O000000o("isQuickPass", FavoriteCameraCardAdapter.O0000oo0.contains(mainCameraCardModel.f10175O000000o));
                    ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                    ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
                    Fragment O000000o2 = supportFragmentManager.O000000o(favoriteCameraCardAdapter.O0000oO);
                    if (O000000o2 != null) {
                        fbt.O000000o(6050);
                        fbs.O000000o(O000000o2, fbt);
                        return;
                    }
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, Device device, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(device, "$device");
            hxi.O00000o.O0000oO0(o0000O0o.O00000oO());
            favoriteCameraCardAdapter.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
            ext.O000000o o000000o = ext.f15931O000000o;
            eyc O000000o2 = ext.O000000o.O000000o(device);
            Handler handler = new Handler(Looper.getMainLooper());
            Context context = view.getContext();
            Context context2 = view.getContext();
            if (context2 != null) {
                O000000o2.onItemClick(view, handler, device, context, (BaseActivity) context2);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.xiaomi.smarthome.framework.page.BaseActivity");
        }

        /* access modifiers changed from: private */
        public static final boolean O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, O0000O0o o0000O0o, MainCameraCardModel mainCameraCardModel, View view) {
            ixe.O00000o(favoriteCameraCardAdapter, "this$0");
            ixe.O00000o(o0000O0o, "this$1");
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            if (favoriteCameraCardAdapter.O00000Oo) {
                return false;
            }
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            if (ixe.O000000o(O0000Oo02 == null ? null : Boolean.valueOf(O0000Oo02.isOwner()), Boolean.FALSE)) {
                gqg.O00000Oo((int) R.string.share_family_none_editable);
                return false;
            }
            gs gsVar = favoriteCameraCardAdapter.O0000Oo0;
            if (gsVar == null) {
                return false;
            }
            if (!favoriteCameraCardAdapter.O00000oo && o0000O0o.O0000Oo0()) {
                O000000o(o0000O0o, 0, 3);
            }
            gsVar.O00000Oo(o0000O0o);
            View view2 = o0000O0o.itemView;
            ixe.O00000Oo(view2, "itemView");
            if (favoriteCameraCardAdapter.O000000o(view2)) {
                favoriteCameraCardAdapter.O0000oO0.removeCallbacksAndMessages(null);
                favoriteCameraCardAdapter.O0000OoO.add(mainCameraCardModel.f10175O000000o);
                o0000O0o.O0000oo0.setVisibility(0);
                o0000O0o.O0000oo0.setChecked(true);
                Context context = view.getContext();
                ixe.O00000Oo(context, "it.context");
                favoriteCameraCardAdapter.O000000o(context);
                favoriteCameraCardAdapter.O0000o00.clear();
            }
            return true;
        }

        private final void O00000oo() {
            O00000o O000000o2 = O000000o();
            int i = O000000o2.f10155O000000o;
            Object obj = O000000o2.O00000Oo;
            this.O0000OOo.O0000oO0.removeMessages(i);
            O0000OOo o0000OOo = this.O0000OOo.O0000oO0;
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            iuh iuh = iuh.f1631O000000o;
            o0000OOo.sendMessageDelayed(obtain, 3000);
        }

        private final void O0000O0o() {
            this.O0000OOo.O0000oO0.removeMessages(O000000o().f10155O000000o);
            hbh hbh = this.O0000Oo0;
            View view = this.itemView;
            ixe.O00000Oo(view, "itemView");
            int i = 4;
            hbh.O000000o(view, 4);
            hbh hbh2 = this.O0000Oo;
            View view2 = this.itemView;
            ixe.O00000Oo(view2, "itemView");
            hbh2.O000000o(view2, O0000Oo0() ? 4 : 0);
            ImageView imageView = this.O0000o0O;
            if (!O0000Oo0()) {
                i = 0;
            }
            imageView.setVisibility(i);
        }

        /* access modifiers changed from: package-private */
        public final O00000o O000000o() {
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            return new O00000o((mainCameraCardModel == null ? "" : mainCameraCardModel.f10175O000000o).hashCode(), this);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.util.List]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void O00000Oo() {
            gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("onAttach: ", (Object) iuo.O00000o0(this.O0000OOo.O0000o00)));
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            if (mainCameraCardModel != null) {
                String str = mainCameraCardModel.f10175O000000o;
                boolean z = mainCameraCardModel.O00000oO;
                boolean z2 = mainCameraCardModel.O00000oo;
                if (!(z && !this.O0000OOo.O00000oo && this.O0000OOo.O0000o00.contains(str) && !O0000Oo0() && !mainCameraCardModel.O0000O0o && (!z2 || (z2 && FavoriteCameraCardAdapter.O0000oo0.contains(str))) && !this.O0000OOo.O0000o0.contains(str))) {
                    if (O0000Oo0() && !this.O0000OOo.O0000Ooo.O00000o(str)) {
                        O000000o(this, 0, 3);
                    }
                    hbh hbh = this.O0000Oo0;
                    View view = this.itemView;
                    ixe.O00000Oo(view, "itemView");
                    hbh.O000000o(view, 4);
                    hbh hbh2 = this.O0000Oo;
                    View view2 = this.itemView;
                    ixe.O00000Oo(view2, "itemView");
                    hbh2.O000000o(view2, 0);
                } else if (!this.O0000OOo.O0000Ooo.O00000o(str)) {
                    O000000o(true);
                    O0000O0o();
                }
            }
        }

        /* access modifiers changed from: private */
        public final boolean O000000o(boolean z) {
            int i;
            gsy.O00000Oo("FavoriteCameraCard", "startPlay: silent " + z + ' ');
            boolean z2 = false;
            if (!gof.O000000o()) {
                if (!htr.f689O000000o) {
                    gqg.O00000Oo((int) R.string.network_disable);
                }
                return false;
            }
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            if (mainCameraCardModel == null) {
                return false;
            }
            String str = mainCameraCardModel.f10175O000000o;
            ViewHolderVideoPlayer viewHolderVideoPlayer = this.O0000OOo.O0000Ooo;
            Context context = this.itemView.getContext();
            ixe.O00000Oo(context, "itemView.context");
            if (viewHolderVideoPlayer.O000000o(context, str, O0000OOo())) {
                O00000oo();
                hbh hbh = this.O0000Oo0;
                View view = this.itemView;
                ixe.O00000Oo(view, "itemView");
                hbh.O000000o(view, 0);
                hbh hbh2 = this.O0000Oo;
                View view2 = this.itemView;
                ixe.O00000Oo(view2, "itemView");
                hbh2.O000000o(view2, 0);
                this.O0000o0O.setVisibility(0);
                this.O0000oO.setImageResource(R.drawable.all_camera_item_pause_selector);
                this.O0000o0o.setVisibility(4);
                if (this.O0000OOo.O0000Ooo.O00000Oo(str)) {
                    this.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_on);
                } else {
                    this.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_off);
                }
                this.O00000oO.setVisibility(4);
                this.O0000o.setVisibility(4);
                if (!z) {
                    hba hba = new hba(str, this.O0000oo);
                    hba.O000000o();
                    this.O00000oo.setTag(hba);
                    this.O00000oo.setVisibility(0);
                    this.O0000oo.setVisibility(0);
                    this.O0000oo.setTag(str);
                    this.O00000oo.startAnimation(AnimationUtils.loadAnimation(this.itemView.getContext(), R.anim.rotate_loading));
                } else {
                    ViewHolderVideoPlayer.O000000o(str, this.f10157O000000o, (gzx.O000000o) null, z);
                    this.O00000Oo.setVisibility(4);
                }
                if (!this.O0000OOo.O0000o00.contains(str)) {
                    O0000OoO();
                }
                hxs hxs = hxi.O00000oo;
                z2 = true;
                if (!this.O0000OOo.O00000Oo) {
                    i = 1;
                } else {
                    i = this.O0000OOo.O0000o == 1 ? 2 : 3;
                }
                hxs.O000000o(i);
            }
            return z2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, boolean):void
         arg types: [android.content.Context, int]
         candidates:
          com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, android.util.AttributeSet):void
          com.xiaomi.smarthome.fastvideo.VideoView.<init>(android.content.Context, boolean):void */
        private final VideoView O0000OOo() {
            this.O0000o00.removeAllViews();
            VideoView videoView = new VideoView(this.itemView.getContext(), false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            videoView.O000000o(this.itemView.getMeasuredWidth(), (this.itemView.getMeasuredWidth() * 10) / 16, false);
            videoView.O0000OOo = true;
            this.O0000o00.addView(videoView, layoutParams);
            this.O0000ooO = videoView;
            return videoView;
        }

        /* access modifiers changed from: private */
        public static final void O00000Oo(O0000O0o o0000O0o) {
            ixe.O00000o(o0000O0o, "this$0");
            o0000O0o.O0000o0.setVisibility(4);
            o0000O0o.O0000o0.setAlpha(1.0f);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(android.content.DialogInterface, int):void
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(com.xiaomi.smarthome.newui.adapter.MainCameraCardModel, com.xiaomi.smarthome.device.Device):void
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean */
        static /* synthetic */ boolean O000000o(O0000O0o o0000O0o, int i, int i2) {
            if ((i2 & 1) != 0) {
                i = 0;
            }
            return o0000O0o.O000000o(i, false);
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(int i, boolean z) {
            gsy.O00000Oo("FavoriteCameraCard", "stopPlay:");
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            if (mainCameraCardModel == null) {
                return false;
            }
            String str = mainCameraCardModel.f10175O000000o;
            ViewHolderVideoPlayer viewHolderVideoPlayer = this.O0000OOo.O0000Ooo;
            Context context = this.itemView.getContext();
            ixe.O00000Oo(context, "itemView.context");
            viewHolderVideoPlayer.O000000o(context, str, i, !z);
            O00000Oo(z);
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Boolean]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0085  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x008b  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0097  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00a6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00b5  */
        private final void O00000Oo(boolean z) {
            int i;
            hba hba;
            VideoView videoView;
            MainCameraCardModel mainCameraCardModel;
            Boolean bool;
            gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("onStopPlay: silent: ", (Object) Boolean.valueOf(z)));
            this.O0000OOo.O0000oO0.removeMessages(O000000o().f10155O000000o);
            ImageView imageView = this.O0000o0o;
            if (!z) {
                MainCameraCardModel mainCameraCardModel2 = this.O0000O0o;
                if (mainCameraCardModel2 == null) {
                    bool = null;
                } else {
                    bool = Boolean.valueOf(mainCameraCardModel2.O0000O0o);
                }
                if (!ixe.O000000o(bool, Boolean.TRUE) && !this.O0000OOo.O0000o0.contains(O00000o0())) {
                    i = 0;
                    imageView.setVisibility(i);
                    hbh hbh = this.O0000Oo0;
                    View view = this.itemView;
                    ixe.O00000Oo(view, "itemView");
                    hbh.O000000o(view, 4);
                    hbh hbh2 = this.O0000Oo;
                    View view2 = this.itemView;
                    ixe.O00000Oo(view2, "itemView");
                    hbh2.O000000o(view2, 0);
                    this.O0000o0O.setVisibility(0);
                    this.O0000o.setVisibility(4);
                    this.O00000oO.setVisibility(4);
                    this.O00000oo.clearAnimation();
                    this.O00000oo.setVisibility(4);
                    Object tag = this.O00000oo.getTag();
                    hba = !(tag instanceof hba) ? (hba) tag : null;
                    if (hba != null) {
                        hba.O00000Oo();
                    }
                    this.O0000oo.setTag(null);
                    this.O00000Oo.setVisibility(!z ? 4 : 0);
                    this.O0000o0.setVisibility(0);
                    videoView = this.O0000ooO;
                    if (videoView != null) {
                        videoView.setVisibility(4);
                    }
                    this.O0000ooO = null;
                    this.O0000o00.removeAllViews();
                    mainCameraCardModel = this.O0000O0o;
                    if (mainCameraCardModel == null) {
                        O00000Oo(mainCameraCardModel);
                        return;
                    }
                    return;
                }
            }
            i = 4;
            imageView.setVisibility(i);
            hbh hbh3 = this.O0000Oo0;
            View view3 = this.itemView;
            ixe.O00000Oo(view3, "itemView");
            hbh3.O000000o(view3, 4);
            hbh hbh22 = this.O0000Oo;
            View view22 = this.itemView;
            ixe.O00000Oo(view22, "itemView");
            hbh22.O000000o(view22, 0);
            this.O0000o0O.setVisibility(0);
            this.O0000o.setVisibility(4);
            this.O00000oO.setVisibility(4);
            this.O00000oo.clearAnimation();
            this.O00000oo.setVisibility(4);
            Object tag2 = this.O00000oo.getTag();
            if (!(tag2 instanceof hba)) {
            }
            if (hba != null) {
            }
            this.O0000oo.setTag(null);
            this.O00000Oo.setVisibility(!z ? 4 : 0);
            this.O0000o0.setVisibility(0);
            videoView = this.O0000ooO;
            if (videoView != null) {
            }
            this.O0000ooO = null;
            this.O0000o00.removeAllViews();
            mainCameraCardModel = this.O0000O0o;
            if (mainCameraCardModel == null) {
            }
        }

        private final boolean O0000Oo0() {
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            if (mainCameraCardModel == null) {
                return false;
            }
            return this.O0000OOo.O0000Ooo.O00000o0(mainCameraCardModel.f10175O000000o);
        }

        private final void O000000o(String str) {
            Boolean bool;
            FavoriteCameraCardAdapter.O0000oo0.add(str);
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            Boolean bool2 = null;
            if (mainCameraCardModel == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(mainCameraCardModel.O00000oO);
            }
            if (!ixe.O000000o(bool, Boolean.FALSE)) {
                MainCameraCardModel mainCameraCardModel2 = this.O0000O0o;
                if (mainCameraCardModel2 != null) {
                    bool2 = Boolean.valueOf(mainCameraCardModel2.O0000O0o);
                }
                if (!ixe.O000000o(bool2, Boolean.TRUE)) {
                    O0000Oo();
                    return;
                }
            }
            MainCameraCardModel mainCameraCardModel3 = this.O0000O0o;
            if (mainCameraCardModel3 != null) {
                O00000Oo(mainCameraCardModel3);
            }
        }

        private final void O0000Oo() {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, this.O0000o0o.getX(), this.O0000o0o.getY(), 0);
            long j = uptimeMillis;
            MotionEvent obtain2 = MotionEvent.obtain(j, uptimeMillis + 1000, 1, this.O0000o0o.getX(), this.O0000o0o.getY(), 0);
            this.O0000o0o.dispatchTouchEvent(obtain);
            this.O0000o0o.dispatchTouchEvent(obtain2);
            obtain.recycle();
            obtain2.recycle();
        }

        public final String O00000o0() {
            MainCameraCardModel mainCameraCardModel = this.O0000O0o;
            return mainCameraCardModel == null ? "" : mainCameraCardModel.f10175O000000o;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        private final void O0000OoO() {
            String poll;
            if (this.O0000OOo.O0000o00.size() >= FavoriteCameraCardAdapter.O00000o0() && (poll = this.O0000OOo.O0000o00.poll()) != null) {
                gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("stopOther: ", (Object) poll));
                FavoriteCameraCardAdapter.O000000o(this.O0000OOo, poll, new O00000Oo.O000OO0o(poll));
            }
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
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$O00000Oo]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean
         arg types: [int, int]
         candidates:
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(android.content.DialogInterface, int):void
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(com.xiaomi.smarthome.newui.adapter.MainCameraCardModel, com.xiaomi.smarthome.device.Device):void
          com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean */
        public final void O000000o(O00000Oo o00000Oo) {
            Boolean bool;
            MainCameraCardModel mainCameraCardModel;
            ixe.O00000o(o00000Oo, "event");
            gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("onControlEvent: ", (Object) o00000Oo.getClass().getSimpleName()));
            boolean z = o00000Oo instanceof O00000Oo.O0000O0o;
            int i = 4;
            if (z ? true : ixe.O000000o(o00000Oo, O00000Oo.O0000OOo.f10140O000000o)) {
                this.O0000OOo.O0000o00.remove(O00000o0());
                if (!this.O0000OOo.O0000o0.contains(O00000o0()) && O0000Oo0()) {
                    O000000o(this, 0, 3);
                }
                this.O0000oo0.setVisibility(z ? 0 : 4);
                ImageView imageView = this.O0000o0O;
                if (o00000Oo instanceof O00000Oo.O0000OOo) {
                    i = 0;
                }
                imageView.setVisibility(i);
                this.O00000oO.setEnabled(!this.O0000OOo.O00000oo);
                this.O0000o.setClickable(!this.O0000OOo.O00000oo);
                this.O0000o0o.setEnabled(!this.O0000OOo.O00000oo);
                this.O0000o0o.setClickable(!this.O0000OOo.O00000oo);
            } else if (o00000Oo instanceof O00000Oo.O0000Oo) {
                if (O0000Oo0() && !ixe.O000000o((Object) ((O00000Oo.O0000Oo) o00000Oo).f10141O000000o, (Object) O00000o0()) && (mainCameraCardModel = this.O0000O0o) != null) {
                    String str = mainCameraCardModel.f10175O000000o;
                    if (O0000Oo0()) {
                        this.O0000oO0.setImageResource(R.drawable.all_camera_item_mute_on);
                        ViewHolderVideoPlayer viewHolderVideoPlayer = this.O0000OOo.O0000Ooo;
                        Context context = this.itemView.getContext();
                        ixe.O00000Oo(context, "itemView.context");
                        viewHolderVideoPlayer.O000000o(context, str);
                    }
                }
            } else if (o00000Oo instanceof O00000Oo.C0086O00000Oo) {
            } else {
                if (o00000Oo instanceof O00000Oo.O000000o) {
                    if (this.O0000OOo.O0000o00.contains(O00000o0()) && !this.O0000OOo.O0000o0.contains(O00000o0())) {
                        O000000o(this, 0, 3);
                        this.O0000OOo.O0000o00.remove(O00000o0());
                    }
                } else if (o00000Oo instanceof O00000Oo.O00000o) {
                    O00000o o00000o = ((O00000Oo.O00000o) o00000Oo).f10137O000000o;
                    int i2 = o00000o.f10155O000000o;
                    Object obj = o00000o.O00000Oo;
                    if (i2 == O00000o0().hashCode() && ixe.O000000o(obj, this)) {
                        this.O0000OOo.O0000oO0.removeMessages(i2);
                        hbh hbh = this.O0000Oo0;
                        View view = this.itemView;
                        ixe.O00000Oo(view, "itemView");
                        hbh.O000000o(view, 4);
                        hbh hbh2 = this.O0000Oo;
                        View view2 = this.itemView;
                        ixe.O00000Oo(view2, "itemView");
                        hbh2.O000000o(view2, O0000Oo0() ? 4 : 0);
                        ImageView imageView2 = this.O0000o0O;
                        if (!O0000Oo0()) {
                            i = 0;
                        }
                        imageView2.setVisibility(i);
                    }
                } else if (o00000Oo instanceof O00000Oo.O000OO00) {
                    MainCameraCardModel mainCameraCardModel2 = this.O0000O0o;
                    if (mainCameraCardModel2 != null) {
                        O00000Oo(mainCameraCardModel2);
                    }
                } else if (o00000Oo instanceof O00000Oo.O000O00o) {
                } else {
                    if (o00000Oo instanceof O00000Oo.O000O0OO) {
                        if (this.O0000OOo.O0000o00.contains(O00000o0()) && !this.O0000OOo.O0000o0.contains(O00000o0())) {
                            O000000o(this, 60000, 2);
                        }
                    } else if (o00000Oo instanceof O00000Oo.O000O0o0) {
                        O00000Oo.O000O0o0 o000O0o0 = (O00000Oo.O000O0o0) o00000Oo;
                        if (ixe.O000000o((Object) o000O0o0.f10149O000000o, (Object) O00000o0())) {
                            O000000o(o000O0o0.f10149O000000o);
                        }
                    } else if (o00000Oo instanceof O00000Oo.O00000o0) {
                        O00000Oo.O00000o0 o00000o0 = (O00000Oo.O00000o0) o00000Oo;
                        if (ixe.O000000o((Object) o00000o0.f10138O000000o, (Object) O00000o0())) {
                            O000000o(true);
                            if (!this.O0000OOo.O0000o00.contains(o00000o0.f10138O000000o)) {
                                this.O0000OOo.O0000o00.offer(o00000o0.f10138O000000o);
                            }
                            O0000O0o();
                        }
                    } else {
                        Object obj2 = null;
                        if (o00000Oo instanceof O00000Oo.O000O0o) {
                            O00000Oo.O000O0o o000O0o = (O00000Oo.O000O0o) o00000Oo;
                            if (ixe.O000000o((Object) o000O0o.f10148O000000o, (Object) O00000o0())) {
                                MainCameraCardModel mainCameraCardModel3 = this.O0000O0o;
                                if (mainCameraCardModel3 != null) {
                                    obj2 = Boolean.valueOf(mainCameraCardModel3.O00000oo);
                                }
                                if (ixe.O000000o(obj2, Boolean.TRUE) && !FavoriteCameraCardAdapter.O0000oo0.contains(o000O0o.f10148O000000o)) {
                                    return;
                                }
                                if (!o000O0o.O00000Oo) {
                                    gqg.O00000Oo((int) R.string.action_fail);
                                    return;
                                }
                                this.O0000OOo.O0000o0o.add(o000O0o.f10148O000000o);
                                O0000Oo();
                            }
                        } else if (o00000Oo instanceof O00000Oo.O00oOooO) {
                            if (ixe.O000000o((Object) ((O00000Oo.O00oOooO) o00000Oo).f10154O000000o, (Object) O00000o0())) {
                                gsy.O00000Oo("FavoriteCameraCard", "onStartPlay: ");
                                this.O0000o0.animate().alpha(0.0f).withEndAction(new Runnable() {
                                    /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$lAtuehfbohKO5BKLT47fWmcsaQ */

                                    public final void run() {
                                        FavoriteCameraCardAdapter.O0000O0o.O00000Oo(FavoriteCameraCardAdapter.O0000O0o.this);
                                    }
                                });
                                this.O00000oo.clearAnimation();
                                this.O00000oo.setVisibility(4);
                                Object tag = this.O00000oo.getTag();
                                hba hba = tag instanceof hba ? (hba) tag : null;
                                if (hba != null) {
                                    hba.O00000Oo();
                                }
                                this.O00000oo.setTag(null);
                                this.O0000oo.setVisibility(4);
                                this.O0000oo.setTag(null);
                                Collection collection = this.O0000OOo.O0000o0;
                                MainCameraCardModel mainCameraCardModel4 = this.O0000O0o;
                                if (mainCameraCardModel4 != null) {
                                    obj2 = mainCameraCardModel4.f10175O000000o;
                                }
                                if (collection != null) {
                                    ixi.O00000Oo(collection).remove(obj2);
                                    return;
                                }
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
                            }
                        } else if (o00000Oo instanceof O00000Oo.O000OO0o) {
                            if (ixe.O000000o((Object) ((O00000Oo.O000OO0o) o00000Oo).f10152O000000o, (Object) O00000o0())) {
                                O000000o(this, 0, 3);
                            }
                        } else if (o00000Oo instanceof O00000Oo.O0000o00) {
                            O00000Oo.O0000o00 o0000o00 = (O00000Oo.O0000o00) o00000Oo;
                            if (ixe.O000000o((Object) o0000o00.f10145O000000o, (Object) O00000o0())) {
                                gsy.O000000o(3, "FavoriteCameraCard", ixe.O000000o("onControlEvent: OnCaptureNew ", (Object) o00000Oo));
                                MainCameraCardModel mainCameraCardModel5 = this.O0000O0o;
                                if (mainCameraCardModel5 == null) {
                                    bool = null;
                                } else {
                                    bool = Boolean.valueOf(mainCameraCardModel5.O00000oO);
                                }
                                if (ixe.O000000o(bool, Boolean.TRUE)) {
                                    Bitmap bitmap = o0000o00.O00000Oo;
                                    if (bitmap != null) {
                                        obj2 = Boolean.valueOf(bitmap.isRecycled());
                                    }
                                    gsy.O000000o(3, "FavoriteCameraCard", ixe.O000000o("onControlEvent: OnCaptureNew enter: ", obj2));
                                    Bitmap bitmap2 = o0000o00.O00000Oo;
                                    if (bitmap2 != null) {
                                        this.f10157O000000o.setImageBitmap(bitmap2);
                                        if (o0000o00.O00000o0) {
                                            this.O00000Oo.setVisibility(0);
                                            this.O00000Oo.setAlpha(0.0f);
                                            this.O00000Oo.animate().alpha(0.4f);
                                            return;
                                        }
                                        this.O00000Oo.setVisibility(4);
                                        this.O00000Oo.setAlpha(0.4f);
                                        return;
                                    }
                                    this.O00000Oo.setVisibility(0);
                                    this.f10157O000000o.setBackgroundResource(R.drawable.camera_default_gradient);
                                }
                            }
                        } else if (o00000Oo instanceof O00000Oo.O0000o0) {
                            if (O0000Oo0()) {
                                O000000o(this, 0, 3);
                            }
                        } else if (o00000Oo instanceof O00000Oo.O0000o) {
                            O000000o(this, 0, 3);
                            this.O0000OOo.O0000o0.add(O00000o0());
                            Context context2 = this.itemView.getContext();
                            ixe.O00000Oo(context2, "itemView.context");
                            O00000Oo(context2);
                            this.O0000o0o.setVisibility(4);
                            this.O00000Oo.setVisibility(0);
                        } else if (o00000Oo instanceof O00000Oo.O0000Oo0) {
                            if (this.O0000OOo.O00000Oo) {
                                O00000o();
                            } else {
                                this.itemView.requestLayout();
                            }
                        } else if (ixe.O000000o(o00000Oo, O00000Oo.O000OO.f10150O000000o)) {
                            if (this.O0000OOo.O0000o00.contains(O00000o0()) && !this.O0000OOo.O0000o0.contains(O00000o0())) {
                                O000000o(true);
                                O0000O0o();
                            }
                        } else if (ixe.O000000o(o00000Oo, O00000Oo.O000OOOo.f10153O000000o) && this.O0000OOo.O0000o00.contains(O00000o0()) && !this.O0000OOo.O0000o0.contains(O00000o0())) {
                            O000000o(60000, true);
                        }
                    }
                }
            }
        }

        private float O0000Ooo() {
            return this.O0000OOo.O0000o == 1 ? 12.0f : 10.0f;
        }

        public final void O00000o() {
            if (this.O0000OOo.O00000Oo) {
                int i = 0;
                boolean z = this.O0000OOo.O0000o == 1;
                this.O00000o0.setTextSize(1, O0000Ooo());
                this.O00000o.setTextSize(1, O0000Ooo());
                this.O0000o.setTextSize(1, O0000Ooo());
                this.O0000oo.setTextSize(1, O0000Ooo());
                oOO0OOo0 ooo0ooo0 = new oOO0OOo0();
                ooo0ooo0.O00000Oo(this.O0000Ooo);
                ooo0ooo0.O00000Oo(this.O0000o0o.getId(), z ? hbb.O000000o(42.0f) : hbb.O000000o(30.0f));
                ooo0ooo0.O000000o(this.O0000o0o.getId(), z ? hbb.O000000o(42.0f) : hbb.O000000o(30.0f));
                ooo0ooo0.O00000Oo(this.O00000oO.getId(), z ? hbb.O000000o(56.0f) : hbb.O000000o(40.0f));
                ooo0ooo0.O000000o(this.O00000oO.getId(), z ? hbb.O000000o(56.0f) : hbb.O000000o(40.0f));
                ooo0ooo0.O00000Oo(this.O0000oO0.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O000000o(this.O0000oO0.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O00000Oo(this.O0000oO.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O000000o(this.O0000oO.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O00000Oo(this.O0000oOO.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O000000o(this.O0000oOO.getId(), z ? hbb.O000000o(50.0f) : hbb.O000000o(36.0f));
                ooo0ooo0.O000000o(this.O00000oO.getId(), 3, z ? 0 : hbb.O000000o(12.0f));
                ooo0ooo0.O000000o(this.O0000o.getId(), 3, z ? hbb.O000000o(5.0f) : 0);
                ooo0ooo0.O000000o(this.O0000oo.getId(), 3, z ? hbb.O000000o(3.0f) : 0);
                ooo0ooo0.O000000o(this.O0000o0O.getId(), 3, z ? hbb.O000000o(15.0f) : hbb.O000000o(8.0f));
                ooo0ooo0.O000000o(this.O0000o0O.getId(), 7, z ? hbb.O000000o(15.0f) : hbb.O000000o(8.0f));
                ooo0ooo0.O000000o(this.O0000oO0.getId(), 6, z ? hbb.O000000o(15.0f) : hbb.O000000o(10.0f));
                ooo0ooo0.O000000o(this.O0000oO0.getId(), 4, z ? hbb.O000000o(10.0f) : 0);
                ooo0ooo0.O000000o(this.O0000oO.getId(), 4, z ? hbb.O000000o(10.0f) : 0);
                int id = this.O0000oOO.getId();
                if (z) {
                    i = hbb.O000000o(10.0f);
                }
                ooo0ooo0.O000000o(id, 4, i);
                ooo0ooo0.O000000o(this.O0000oOO.getId(), 7, z ? hbb.O000000o(15.0f) : hbb.O000000o(10.0f));
                ooo0ooo0.O000000o(this.O00000o0.getId(), 3, z ? hbb.O000000o(10.0f) : hbb.O000000o(6.0f));
                ooo0ooo0.O00000o0(this.O0000Ooo);
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(MainCameraCardModel mainCameraCardModel) {
            String str = mainCameraCardModel.f10175O000000o;
            boolean z = mainCameraCardModel.O00000oO;
            boolean z2 = mainCameraCardModel.O00000oo;
            boolean z3 = mainCameraCardModel.O0000O0o;
            this.f10157O000000o.setTag(null);
            boolean z4 = z && !this.O0000OOo.O00000oo && this.O0000OOo.O0000o00.contains(str) && !O0000Oo0() && !z3 && (!z2 || (z2 && FavoriteCameraCardAdapter.O0000oo0.contains(str))) && !this.O0000OOo.O0000o0.contains(str);
            if (!z4) {
                this.O00000Oo.setVisibility(0);
                this.f10157O000000o.setBackgroundResource(R.drawable.camera_default_gradient);
            }
            ViewHolderVideoPlayer.O000000o(str, this.f10157O000000o, new O00000Oo(this), !z4);
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(MainCameraCardModel mainCameraCardModel) {
            String str = mainCameraCardModel.f10175O000000o;
            boolean z = mainCameraCardModel.O00000oO;
            boolean z2 = mainCameraCardModel.O00000oo;
            boolean z3 = !this.O0000OOo.O0000o0o.contains(str) && mainCameraCardModel.O0000O0o;
            this.O0000o0o.setVisibility((O0000Oo0() || !z || z3 || (z2 && (!z2 || !FavoriteCameraCardAdapter.O0000oo0.contains(str)))) ? 4 : 0);
            this.O0000oOo.setShouldMask(this.O0000OOo.O00000o || this.O0000OOo.O00000oO);
            this.O0000oo0.setChecked(this.O0000OOo.O00000oo && this.O0000OOo.O0000OoO.contains(mainCameraCardModel.f10175O000000o));
            this.O0000oo0.setVisibility(this.O0000OOo.O00000oo ? 0 : 4);
            this.O0000o0O.setVisibility(this.O0000OOo.O00000oo ? 4 : 0);
            if ((this.O0000OOo.O00000o || this.O0000OOo.O00000oO) && O0000Oo0()) {
                O000000o(this, 0, 3);
            }
            this.O0000o.setTag(str);
            if (!this.O0000OOo.O0000o00.contains(str) && z2 && !FavoriteCameraCardAdapter.O0000oo0.contains(str)) {
                if (O0000Oo0()) {
                    O000000o(this, 0, 3);
                }
                hbh hbh = this.O0000OoO;
                View view = this.itemView;
                ixe.O00000Oo(view, "itemView");
                hbh.O000000o(view, 0);
                this.O00000oO.setImageResource(R.drawable.icon_camera_unlock_bg);
                this.O0000o.setText((int) R.string.click_to_unlock);
                this.O00000oO.setOnClickListener(new View.OnClickListener(str) {
                    /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$QyI_368lJL7arwNtDUZ35MNoU */
                    private final /* synthetic */ String f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.O0000O0o.this, this.f$1, view);
                    }
                });
            } else if (!z) {
                if (O0000Oo0()) {
                    O000000o(this, 0, 3);
                }
                hbh hbh2 = this.O0000OoO;
                View view2 = this.itemView;
                ixe.O00000Oo(view2, "itemView");
                hbh2.O000000o(view2, 0);
                this.O00000oO.setImageResource(R.drawable.icon_camera_offline_bg);
                this.O0000o.setText((int) R.string.device_offline);
                this.O00000oO.setOnClickListener(null);
                this.O00000oO.setClickable(false);
            } else if (z3 && !this.O0000OOo.O0000Ooo.O00000o(str)) {
                if (O0000Oo0()) {
                    O000000o(this, 0, 3);
                }
                hbh hbh3 = this.O0000OoO;
                View view3 = this.itemView;
                ixe.O00000Oo(view3, "itemView");
                hbh3.O000000o(view3, 0);
                this.O0000o0o.setVisibility(4);
                this.O00000oO.setImageResource(R.drawable.icon_camera_power_off_bg);
                this.O0000o.setText((int) R.string.click_to_power_on);
                this.O00000oO.setOnClickListener(new View.OnClickListener(this, str) {
                    /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$rW1tFUGb5SW85zZEJ00RxeRgMs0 */
                    private final /* synthetic */ FavoriteCameraCardAdapter.O0000O0o f$1;
                    private final /* synthetic */ String f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        FavoriteCameraCardAdapter.O0000O0o.O000000o(MainCameraCardModel.this, this.f$1, this.f$2, view);
                    }
                });
            } else if (this.O0000OOo.O0000o0.contains(str)) {
                Context context = this.itemView.getContext();
                ixe.O00000Oo(context, "itemView.context");
                O00000Oo(context);
            } else {
                hbh hbh4 = this.O0000OoO;
                View view4 = this.itemView;
                ixe.O00000Oo(view4, "itemView");
                hbh4.O000000o(view4, 4);
                this.O00000oO.setOnClickListener(null);
                this.O00000oO.setClickable(false);
            }
            this.O00000oO.setEnabled(!this.O0000OOo.O00000oo);
            this.O0000o.setClickable(!this.O0000OOo.O00000oo);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(MainCameraCardModel mainCameraCardModel, O0000O0o o0000O0o, String str, View view) {
            ixe.O00000o(mainCameraCardModel, "$cameraModel");
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(str, "$did");
            if (mainCameraCardModel.O0000OOo) {
                gqg.O00000Oo((int) R.string.device_control_no_permit);
                return;
            }
            hxk hxk = hxi.O00000o;
            int O00000oO2 = o0000O0o.O00000oO();
            hxk.f952O000000o.O000000o("camera_wake_up_click", "from", Integer.valueOf(O00000oO2));
            hfy hfy = hfy.f18887O000000o;
            o0000O0o.O0000OOo.O00000o0.add(hfy.O00000Oo(str).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(str) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$O0000O0o$aZReqV6hYf4e1AsVhFaLfXziroM */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    FavoriteCameraCardAdapter.O0000O0o.O000000o(FavoriteCameraCardAdapter.this, this.f$1, (Boolean) obj);
                }
            }));
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O0000O0o o0000O0o, FavoriteCameraCardAdapter favoriteCameraCardAdapter, Context context, View view) {
            ixe.O00000o(o0000O0o, "this$0");
            ixe.O00000o(favoriteCameraCardAdapter, "this$1");
            ixe.O00000o(context, "$context");
            if (o0000O0o.O000000o(false)) {
                favoriteCameraCardAdapter.O0000o0.remove(o0000O0o.O00000o0());
            } else {
                o0000O0o.O00000Oo(context);
            }
        }
    }

    public final void onViewAttachedToWindow(RecyclerView.O000OOo0 o000OOo0) {
        ixe.O00000o(o000OOo0, "holder");
        O0000O0o o0000O0o = o000OOo0 instanceof O0000O0o ? (O0000O0o) o000OOo0 : null;
        if (o0000O0o != null) {
            o0000O0o.O00000Oo();
        }
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
     method: com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(android.content.DialogInterface, int):void
      com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(com.xiaomi.smarthome.newui.adapter.MainCameraCardModel, com.xiaomi.smarthome.device.Device):void
      com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter.O0000O0o.O000000o(int, boolean):boolean */
    public final void onViewDetachedFromWindow(RecyclerView.O000OOo0 o000OOo0) {
        ixe.O00000o(o000OOo0, "holder");
        String str = null;
        O0000O0o o0000O0o = o000OOo0 instanceof O0000O0o ? (O0000O0o) o000OOo0 : null;
        if (o0000O0o != null) {
            gsy.O00000Oo("FavoriteCameraCard", ixe.O000000o("onDetach: ", (Object) o0000O0o.O00000o0()));
            Queue<String> queue = o0000O0o.O0000OOo.O0000o00;
            MainCameraCardModel mainCameraCardModel = o0000O0o.O0000O0o;
            if (mainCameraCardModel != null) {
                str = mainCameraCardModel.f10175O000000o;
            }
            if (queue.contains(str)) {
                o0000O0o.O000000o(60000, true);
            } else {
                o0000O0o.f10157O000000o.setBackgroundResource(R.drawable.camera_default_gradient);
            }
            o0000O0o.O0000OOo.O0000oO0.removeMessages(o0000O0o.O000000o().f10155O000000o);
            o0000O0o.O00000o();
        }
    }

    public final void O000000o(Rect rect, View view, int i, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
        ixe.O00000o(rect, "outRect");
        ixe.O00000o(view, "view");
        super.O000000o(rect, view, i, recyclerView, o000OO0o);
        int dimension = (int) view.getResources().getDimension(R.dimen.main_page_flex_padding);
        if (!(i / this.O0000o == 0) || !j_()) {
            rect.top = hbb.O000000o(3.0f);
        } else {
            rect.top = hbb.O000000o(10.0f);
        }
        rect.bottom = hbb.O000000o(7.0f);
        int i2 = this.O0000o;
        if (i2 == 1) {
            rect.left = hbb.O000000o(10.0f) + dimension;
            rect.right = hbb.O000000o(10.0f) + dimension;
            return;
        }
        int i3 = i % i2;
        if (i3 == 0) {
            rect.left = hbb.O000000o(10.0f) + dimension;
            rect.right = hbb.O000000o(5.0f);
        } else if (i3 == i2 - 1) {
            rect.left = hbb.O000000o(5.0f);
            rect.right = hbb.O000000o(10.0f) + dimension;
        } else {
            rect.left = hbb.O000000o(10.0f);
            rect.right = hbb.O000000o(10.0f);
        }
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        ixe.O00000Oo(context, "recyclerView.context");
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
            if (supportFragmentManager.O000000o(this.O0000oO) == null) {
                hbk hbk = new hbk();
                hbk.setRetainInstance(true);
                hbk.f18743O000000o = this;
                ei O000000o2 = supportFragmentManager.O000000o();
                O000000o2.O000000o(hbk, this.O0000oO);
                O000000o2.O00000o0();
            }
        }
        Context context2 = recyclerView.getContext();
        if (context2 != null) {
            FragmentActivity fragmentActivity2 = (FragmentActivity) context2;
            if (!this.O00000Oo) {
                hbr.O000000o o000000o = hbr.f18756O000000o;
                hbr O000000o3 = hbr.O000000o.O000000o(fragmentActivity2);
                hbr.O00000Oo o00000Oo = this;
                ixe.O00000o(o00000Oo, "li");
                if (!O000000o3.O00000Oo.contains(o00000Oo)) {
                    O000000o3.O00000Oo.add(o00000Oo);
                }
            }
            fragmentActivity2.getLifecycle().O000000o(this);
            CompositeDisposable compositeDisposable = this.O00000o0;
            gzq.O000000o o000000o2 = gzq.f18638O000000o;
            compositeDisposable.addAll(gzq.O00000oo.map($$Lambda$FavoriteCameraCardAdapter$J4svOEg48qoDW_zcwSeYHMhs24.INSTANCE).distinctUntilChanged().observeOn(AndroidSchedulers.mainThread()).filter($$Lambda$FavoriteCameraCardAdapter$PQqQtZX_WTG4K9LnLibJRT52c4U.INSTANCE).subscribe(new Consumer() {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$FERyRzatmAgT5U3zsXo2UzmvjU */

                public final void accept(Object obj) {
                    FavoriteCameraCardAdapter.O000000o(FavoriteCameraCardAdapter.this, (Boolean) obj);
                }
            }));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    /* access modifiers changed from: private */
    public static final Boolean O000000o(Intent intent) {
        ixe.O00000o(intent, "it");
        return Boolean.valueOf(intent.getBooleanExtra("main_extra_camera_edit_mode_is_edit_mode", false));
    }

    /* access modifiers changed from: private */
    public static final boolean O000000o(Boolean bool) {
        ixe.O00000o(bool, "it");
        return !bool.booleanValue();
    }

    /* access modifiers changed from: private */
    public static final void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, Boolean bool) {
        ixe.O00000o(favoriteCameraCardAdapter, "this$0");
        CameraEditPage cameraEditPage = favoriteCameraCardAdapter.O000O00o;
        if (cameraEditPage != null) {
            cameraEditPage.O00000Oo();
        }
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        Context context = recyclerView.getContext();
        ixe.O00000Oo(context, "recyclerView.context");
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            ee supportFragmentManager = fragmentActivity.getSupportFragmentManager();
            ixe.O00000Oo(supportFragmentManager, "base.supportFragmentManager");
            Fragment O000000o2 = supportFragmentManager.O000000o(this.O0000oO);
            if (O000000o2 != null) {
                ei O000000o3 = fragmentActivity.getSupportFragmentManager().O000000o();
                O000000o3.O000000o(O000000o2);
                O000000o3.O00000o0();
            }
        }
        Context context2 = recyclerView.getContext();
        if (context2 != null) {
            FragmentActivity fragmentActivity2 = (FragmentActivity) context2;
            if (!this.O00000Oo) {
                hbr.O000000o o000000o = hbr.f18756O000000o;
                hbr O000000o4 = hbr.O000000o.O000000o(fragmentActivity2);
                hbr.O00000Oo o00000Oo = this;
                ixe.O00000o(o00000Oo, "li");
                O000000o4.O00000Oo.remove(o00000Oo);
            }
            fragmentActivity2.getLifecycle().O00000Oo(this);
            this.O0000Ooo.O000000o(iuo.O00000o0(this.O0000o00));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }

    public final void O000000o(RecyclerView recyclerView) {
        gsy.O000000o(3, "FavoriteCameraCard", "onConfigurationChanged: ");
        super.O000000o(recyclerView);
        if (!this.O00000Oo) {
            hha.O000000o o000000o = hha.f18928O000000o;
            this.O0000o = hha.O000000o.O000000o().O00000o0;
            O000000o((O00000Oo) O00000Oo.O0000Oo0.f10142O000000o);
        }
    }

    public final void O000000o(int i, int i2, Intent intent) {
        String stringExtra;
        gsy.O00000Oo("FavoriteCameraCard", "onActivityResult: requestCode: " + i + " , resultCode: " + i2 + " ,data:" + intent);
        if (i == 9999 && i2 == -1 && intent != null) {
            String stringExtra2 = intent.getStringExtra("extra_device_did");
            if (stringExtra2 != null) {
                gsy.O00000Oo("FavoriteCameraCard", "onActivityResult: emit Verify pinCode");
                O000000o(this, stringExtra2, new O00000Oo.O000O0o0(stringExtra2));
            }
        } else if (i == 6050 && i2 == -1 && intent != null && (stringExtra = intent.getStringExtra("play_did")) != null) {
            gsy.O00000Oo("FavoriteCameraCard", "onActivityResult: emit BackFromFull");
            ViewHolderVideoPlayer viewHolderVideoPlayer = this.O0000Ooo;
            ixe.O00000o(stringExtra, "did");
            Device O000000o2 = fno.O000000o().O000000o(stringExtra);
            if (!(O000000o2 == null || viewHolderVideoPlayer.O00000o0.get(stringExtra) == null)) {
                viewHolderVideoPlayer.O00000o0.put(stringExtra, Boolean.valueOf(gth.O000000o().O00000o0(O000000o2)));
            }
            O000000o(this, stringExtra, new O00000Oo.O00000o0(stringExtra));
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0001HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Token;", "", "what", "", "obj", "(ILjava/lang/Object;)V", "getObj", "()Ljava/lang/Object;", "getWhat", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f10155O000000o;
        final Object O00000Oo;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof O00000o)) {
                return false;
            }
            O00000o o00000o = (O00000o) obj;
            return this.f10155O000000o == o00000o.f10155O000000o && ixe.O000000o(this.O00000Oo, o00000o.O00000Oo);
        }

        public final int hashCode() {
            return (Integer.valueOf(this.f10155O000000o).hashCode() * 31) + this.O00000Oo.hashCode();
        }

        public final String toString() {
            return "Token(what=" + this.f10155O000000o + ", obj=" + this.O00000Oo + ')';
        }

        public O00000o(int i, Object obj) {
            ixe.O00000o(obj, "obj");
            this.f10155O000000o = i;
            this.O00000Oo = obj;
        }
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0014\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0014\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*¨\u0006+"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "", "()V", "AppPause", "AppResume", "BackFromFull", "ControlViewHide", "EditModeIn", "EditModeOut", "FlexSize", "Mute", "OnCaptureNew", "OnDisconnect", "OnPlayError", "OnStartPlay", "PageSwitchIn", "PageSwitchOut", "PinCodePass", "PowerOn", "RefreshState", "Stop", "TabSwitchIn", "TabSwitchOut", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$FlexSize;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$AppPause;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$AppResume;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PageSwitchIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PageSwitchOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$TabSwitchIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$TabSwitchOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$EditModeIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$EditModeOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnDisconnect;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnStartPlay;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$Mute;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$Stop;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$ControlViewHide;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PinCodePass;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$RefreshState;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PowerOn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnCaptureNew;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnPlayError;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$BackFromFull;", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static abstract class O00000Oo {
        public /* synthetic */ O00000Oo(byte b) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$FlexSize;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000Oo0 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O0000Oo0 f10142O000000o = new O0000Oo0();

            private O0000Oo0() {
                super((byte) 0);
            }
        }

        private O00000Oo() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$AppPause;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000000o f10135O000000o = new O000000o();

            private O000000o() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$AppResume;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* renamed from: com.xiaomi.smarthome.newui.adapter.FavoriteCameraCardAdapter$O00000Oo$O00000Oo  reason: collision with other inner class name */
        public static final class C0086O00000Oo extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final C0086O00000Oo f10136O000000o = new C0086O00000Oo();

            private C0086O00000Oo() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PageSwitchIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000O00o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000O00o f10146O000000o = new O000O00o();

            private O000O00o() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PageSwitchOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000O0OO extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000O0OO f10147O000000o = new O000O0OO();

            private O000O0OO() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$TabSwitchIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000OO extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000OO f10150O000000o = new O000OO();

            private O000OO() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$TabSwitchOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000OOOo extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O000OOOo f10153O000000o = new O000OOOo();

            private O000OOOo() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$EditModeIn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000O0o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O0000O0o f10139O000000o = new O0000O0o();

            private O0000O0o() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$EditModeOut;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000OOo extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O0000OOo f10140O000000o = new O0000OOo();

            private O0000OOo() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnDisconnect;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "()V", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000o0 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            public static final O0000o0 f10144O000000o = new O0000o0();

            private O0000o0() {
                super((byte) 0);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnStartPlay;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00oOooO extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10154O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O00oOooO) && ixe.O000000o(this.f10154O000000o, ((O00oOooO) obj).f10154O000000o);
            }

            public final int hashCode() {
                return this.f10154O000000o.hashCode();
            }

            public final String toString() {
                return "OnStartPlay(did=" + this.f10154O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00oOooO(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10154O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$Mute;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "excludeDid", "", "(Ljava/lang/String;)V", "getExcludeDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000Oo extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10141O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O0000Oo) && ixe.O000000o(this.f10141O000000o, ((O0000Oo) obj).f10141O000000o);
            }

            public final int hashCode() {
                return this.f10141O000000o.hashCode();
            }

            public final String toString() {
                return "Mute(excludeDid=" + this.f10141O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O0000Oo(String str) {
                super((byte) 0);
                ixe.O00000o(str, "excludeDid");
                this.f10141O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$Stop;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000OO0o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10152O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O000OO0o) && ixe.O000000o(this.f10152O000000o, ((O000OO0o) obj).f10152O000000o);
            }

            public final int hashCode() {
                return this.f10152O000000o.hashCode();
            }

            public final String toString() {
                return "Stop(did=" + this.f10152O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000OO0o(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10152O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$ControlViewHide;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "token", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Token;", "(Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Token;)V", "getToken", "()Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$Token;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final O00000o f10137O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O00000o) && ixe.O000000o(this.f10137O000000o, ((O00000o) obj).f10137O000000o);
            }

            public final int hashCode() {
                return this.f10137O000000o.hashCode();
            }

            public final String toString() {
                return "ControlViewHide(token=" + this.f10137O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00000o(O00000o o00000o) {
                super((byte) 0);
                ixe.O00000o(o00000o, "token");
                this.f10137O000000o = o00000o;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PinCodePass;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000O0o0 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10149O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O000O0o0) && ixe.O000000o(this.f10149O000000o, ((O000O0o0) obj).f10149O000000o);
            }

            public final int hashCode() {
                return this.f10149O000000o.hashCode();
            }

            public final String toString() {
                return "PinCodePass(did=" + this.f10149O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000O0o0(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10149O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$RefreshState;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000OO00 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            private final String f10151O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O000OO00) && ixe.O000000o(this.f10151O000000o, ((O000OO00) obj).f10151O000000o);
            }

            public final int hashCode() {
                return this.f10151O000000o.hashCode();
            }

            public final String toString() {
                return "RefreshState(did=" + this.f10151O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000OO00(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10151O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$PowerOn;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "result", "", "(Ljava/lang/String;Z)V", "getDid", "()Ljava/lang/String;", "getResult", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000O0o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10148O000000o;
            final boolean O00000Oo;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O000O0o)) {
                    return false;
                }
                O000O0o o000O0o = (O000O0o) obj;
                return ixe.O000000o(this.f10148O000000o, o000O0o.f10148O000000o) && this.O00000Oo == o000O0o.O00000Oo;
            }

            public final int hashCode() {
                int hashCode = this.f10148O000000o.hashCode() * 31;
                boolean z = this.O00000Oo;
                if (z) {
                    z = true;
                }
                return hashCode + (z ? 1 : 0);
            }

            public final String toString() {
                return "PowerOn(did=" + this.f10148O000000o + ", result=" + this.O00000Oo + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O000O0o(String str, boolean z) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10148O000000o = str;
                this.O00000Oo = z;
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnCaptureNew;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "cover", "Landroid/graphics/Bitmap;", "isBlur", "", "(Ljava/lang/String;Landroid/graphics/Bitmap;Z)V", "getCover", "()Landroid/graphics/Bitmap;", "getDid", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000o00 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10145O000000o;
            final Bitmap O00000Oo;
            final boolean O00000o0;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof O0000o00)) {
                    return false;
                }
                O0000o00 o0000o00 = (O0000o00) obj;
                return ixe.O000000o(this.f10145O000000o, o0000o00.f10145O000000o) && ixe.O000000o(this.O00000Oo, o0000o00.O00000Oo) && this.O00000o0 == o0000o00.O00000o0;
            }

            public final int hashCode() {
                int hashCode = this.f10145O000000o.hashCode() * 31;
                Bitmap bitmap = this.O00000Oo;
                int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
                boolean z = this.O00000o0;
                if (z) {
                    z = true;
                }
                return hashCode2 + (z ? 1 : 0);
            }

            public final String toString() {
                return "OnCaptureNew(did=" + this.f10145O000000o + ", cover=" + this.O00000Oo + ", isBlur=" + this.O00000o0 + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O0000o00(String str, Bitmap bitmap, boolean z) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10145O000000o = str;
                this.O00000Oo = bitmap;
                this.O00000o0 = z;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$OnPlayError;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O0000o extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            private final String f10143O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O0000o) && ixe.O000000o(this.f10143O000000o, ((O0000o) obj).f10143O000000o);
            }

            public final int hashCode() {
                return this.f10143O000000o.hashCode();
            }

            public final String toString() {
                return "OnPlayError(did=" + this.f10143O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O0000o(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10143O000000o = str;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent$BackFromFull;", "Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$ControlEvent;", "did", "", "(Ljava/lang/String;)V", "getDid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O00000o0 extends O00000Oo {

            /* renamed from: O000000o  reason: collision with root package name */
            final String f10138O000000o;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof O00000o0) && ixe.O000000o(this.f10138O000000o, ((O00000o0) obj).f10138O000000o);
            }

            public final int hashCode() {
                return this.f10138O000000o.hashCode();
            }

            public final String toString() {
                return "BackFromFull(did=" + this.f10138O000000o + ')';
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public O00000o0(String str) {
                super((byte) 0);
                ixe.O00000o(str, "did");
                this.f10138O000000o = str;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/xiaomi/smarthome/newui/adapter/FavoriteCameraCardAdapter$SimpleDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "from", "", "Lcom/xiaomi/smarthome/newui/adapter/MainCameraCardModel;", "to", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "p0", "", "p1", "areItemsTheSame", "getNewListSize", "getOldListSize", "smarthome-mainpage_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    static final class O00000o0 extends gp.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private final List<MainCameraCardModel> f10156O000000o;
        private final List<MainCameraCardModel> O00000Oo;

        public O00000o0(List<MainCameraCardModel> list, List<MainCameraCardModel> list2) {
            ixe.O00000o(list, "from");
            ixe.O00000o(list2, "to");
            this.f10156O000000o = list;
            this.O00000Oo = list2;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final boolean O000000o(int i, int i2) {
            return ixe.O000000o((Object) this.f10156O000000o.get(i).f10175O000000o, (Object) this.O00000Oo.get(i2).f10175O000000o);
        }

        public final int O000000o() {
            return this.f10156O000000o.size();
        }

        public final int O00000Oo() {
            return this.O00000Oo.size();
        }

        public final boolean O00000Oo(int i, int i2) {
            return ixe.O000000o(this.f10156O000000o.get(i), this.O00000Oo.get(i2));
        }
    }

    static /* synthetic */ void O000000o(FavoriteCameraCardAdapter favoriteCameraCardAdapter, String str, O00000Oo o00000Oo) {
        if (favoriteCameraCardAdapter.getItemCount() != 0) {
            CommonApplication.getGlobalHandler().postDelayed(new Runnable(o00000Oo, str) {
                /* class com.xiaomi.smarthome.newui.adapter.$$Lambda$FavoriteCameraCardAdapter$BAVhhpijI1WmcCnuivKDqDhFfDo */
                private final /* synthetic */ FavoriteCameraCardAdapter.O00000Oo f$1;
                private final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    FavoriteCameraCardAdapter.O000000o(FavoriteCameraCardAdapter.this, this.f$1, this.f$2);
                }
            }, 0);
        }
    }

    public final void O000000o(int i, RecyclerView recyclerView) {
        ixe.O00000o(recyclerView, "recyclerView");
        gzn gzn = this.O0000O0o;
        gzl gzl = gzn instanceof gzl ? (gzl) gzn : null;
        if (gzl != null) {
            this.O0000o = i;
            gzl.O000000o(recyclerView);
            O000000o((O00000Oo) O00000Oo.O0000Oo0.f10142O000000o);
        }
    }
}
