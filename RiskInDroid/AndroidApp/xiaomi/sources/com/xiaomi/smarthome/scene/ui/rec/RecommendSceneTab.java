package com.xiaomi.smarthome.scene.ui.rec;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsy;
import _m_j.ft;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gof;
import _m_j.gqg;
import _m_j.gsf;
import _m_j.gsy;
import _m_j.hnz;
import _m_j.hoa;
import _m_j.hoe;
import _m_j.hof;
import _m_j.hoh;
import _m_j.hol;
import _m_j.hor;
import _m_j.hpq;
import _m_j.hrh;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import _m_j.hxr;
import _m_j.ixe;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.nfctag.ui.NFCActionListActivity;
import com.xiaomi.smarthome.scene.ui.rec.RecommendSceneTab;
import com.xiaomi.smarthome.scene.ui.sleep.SleepModeActivity;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 w2\u00020\u0001:\twxyz{|}~B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\u000e\u0010C\u001a\b\u0012\u0004\u0012\u00020\f0DH\u0002J\u0016\u0010E\u001a\b\u0012\u0004\u0012\u00020G0F2\u0006\u0010H\u001a\u00020IH\u0002J \u0010J\u001a\u001a\u0012\u0016\b\u0001\u0012\u0012\u0012\u0004\u0012\u00020K0\u0004j\b\u0012\u0004\u0012\u00020K`\u00060DH\u0002J\b\u0010L\u001a\u00020AH\u0002J\u0016\u0010M\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020O0N0DH\u0002J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010OH\u0002J*\u0010S\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00060F2\u0006\u0010H\u001a\u00020IH\u0002J\b\u0010T\u001a\u00020\fH\u0002J\b\u0010U\u001a\u00020\fH\u0002J\b\u0010V\u001a\u00020\fH\u0002J\u0006\u0010W\u001a\u00020AJ\"\u0010X\u001a\u00020A2\u0006\u0010Y\u001a\u00020Q2\u0006\u0010Z\u001a\u00020Q2\b\u0010[\u001a\u0004\u0018\u00010\\H\u0016J&\u0010]\u001a\u0004\u0018\u00010\u00102\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\b\u0010d\u001a\u00020AH\u0016J\b\u0010e\u001a\u00020AH\u0016J\b\u0010f\u001a\u00020AH\u0016J\u001a\u0010g\u001a\u00020A2\u0006\u0010h\u001a\u00020\u00102\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J \u0010i\u001a\u00020\f2\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\f0k2\b\u0010l\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010m\u001a\u00020AH\u0002J\b\u0010n\u001a\u00020AH\u0002J\b\u0010o\u001a\u00020AH\u0002J\b\u0010p\u001a\u00020AH\u0002J \u0010q\u001a\u00020A2\u0016\u0010l\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006H\u0002J\b\u0010r\u001a\u00020AH\u0002J\u0006\u0010s\u001a\u00020AJ\u0014\u0010t\u001a\u00020A*\u00020u2\u0006\u0010v\u001a\u00020IH\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00060\u000eR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u0014R\u000e\u0010\u001a\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u000e\u0010'\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0012\u0010.\u001a\u00060/R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R*\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\b\"\u0004\b<\u0010\nR\u001a\u0010=\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106¨\u0006\u0001"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;", "Lcom/xiaomi/smarthome/framework/page/BaseFragment;", "()V", "hideUiData", "Ljava/util/ArrayList;", "Lcom/xiaomi/smarthome/scene/bean/RecUIData;", "Lkotlin/collections/ArrayList;", "getHideUiData", "()Ljava/util/ArrayList;", "setHideUiData", "(Ljava/util/ArrayList;)V", "isEditable", "", "mAdapter", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyAdapter;", "mDecorView", "Landroid/view/View;", "getMDecorView", "()Landroid/view/View;", "setMDecorView", "(Landroid/view/View;)V", "mDid", "", "mEmptyView", "getMEmptyView", "setMEmptyView", "mIsPageSelected", "mOtherHomeView", "getMOtherHomeView", "setMOtherHomeView", "mPullRefreshLL", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "getMPullRefreshLL", "()Lin/srain/cube/views/ptr/PtrFrameLayout;", "setMPullRefreshLL", "(Lin/srain/cube/views/ptr/PtrFrameLayout;)V", "mRootView", "getMRootView", "setMRootView", "mShowSleepMode", "moreScene", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupRecUIData;", "getMoreScene", "()Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupRecUIData;", "setMoreScene", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupRecUIData;)V", "myReceiver", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyReceiver;", "needExpand", "nfcScene", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData;", "getNfcScene", "()Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData;", "setNfcScene", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData;)V", "sleepScene", "getSleepScene", "setSleepScene", "uiData", "getUiData", "setUiData", "uwbScene", "getUwbScene", "setUwbScene", "beginRefresh", "", "foldUI", "getConfigObservable", "Lio/reactivex/Observable;", "getErrorDataConsumer", "Lio/reactivex/functions/Consumer;", "", "co", "Lio/reactivex/disposables/CompositeDisposable;", "getRecTplObservable", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "getRemoteData", "getSceneObservable", "", "Lcom/xiaomi/smarthome/scene/bean/SimpleRecScene;", "getState", "", "s", "getUIDataConsumer", "isLogin", "isSupportRecommend", "isUwbEnable", "loginStateUpdate", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPageDeselected", "onPageSelected", "onResume", "onViewCreated", "view", "parseConfig", "emitter", "Lio/reactivex/ObservableEmitter;", "t", "refreshComplete", "refreshUI", "refreshUINologin", "showShareHomeUI", "stat", "unFoldUI", "update", "addTo", "Lio/reactivex/disposables/Disposable;", "c", "Companion", "FoldRecUIData", "FoldViewHolder", "GroupRecUIData", "GroupViewHolder", "MyAdapter", "MyReceiver", "MyViewHolder", "SceneRecUIData", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecommendSceneTab extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f11287O000000o = new O000000o((byte) 0);
    public boolean O00000Oo;
    public O0000OOo O00000o;
    public volatile boolean O00000o0;
    public PtrFrameLayout O00000oO;
    View O00000oo;
    ArrayList<hoe> O0000O0o = new ArrayList<>();
    public O00000o O0000OOo;
    private boolean O0000Oo;
    public String O0000Oo0;
    private MyReceiver O0000OoO;
    private View O0000Ooo;
    private View O0000o;
    private O0000Oo O0000o0 = new O0000Oo(1, 3);
    private O0000Oo O0000o00 = new O0000Oo(1, 1);
    private O0000Oo O0000o0O = new O0000Oo(1, 2);
    private ArrayList<hoe> O0000o0o = new ArrayList<>();
    private boolean O0000oO;
    private View O0000oO0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$Companion;", "", "()V", "REQUEST_EDIT_REC_SCENE", "", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class MyReceiver extends BroadcastReceiver {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11288O000000o;

        public MyReceiver(RecommendSceneTab recommendSceneTab) {
            ixe.O00000o(recommendSceneTab, "this$0");
            this.f11288O000000o = recommendSceneTab;
        }

        public final void onReceive(Context context, Intent intent) {
            String action;
            if (this.f11288O000000o.isAdded()) {
                String str = "";
                if (!(intent == null || (action = intent.getAction()) == null)) {
                    str = action;
                }
                switch (str.hashCode()) {
                    case -1984077386:
                        if (str.equals("action_on_login_success")) {
                            gsy.O00000Oo("RecScene", "ACTION_ON_LOGIN_SUCCESS");
                            return;
                        }
                        return;
                    case -1470224095:
                        if (str.equals("action_on_logout")) {
                            gsy.O00000Oo("RecScene", "ACTION_ON_LOGOUT");
                            this.f11288O000000o.O00000oo();
                            return;
                        }
                        return;
                    case -899467304:
                        if (str.equals("force_update_data_completed")) {
                            gsy.O00000Oo("RecScene", "ACTION_FORCE_UPDATE_COMPLETED");
                            return;
                        }
                        return;
                    case -56322889:
                        if (str.equals("home_room_updated")) {
                            gsy.O00000Oo("RecScene", "ACTION_HOME_ROOM_UPDATED");
                            gsy.O00000Oo("RecScene", "ACTION_HOME_CHANGED");
                            if (!ggb.O00000Oo().O0000OoO.O00000oo || !ggb.O00000Oo().O0000Oo0().isOwner()) {
                                this.f11288O000000o.O0000O0o.clear();
                                O0000OOo o0000OOo = this.f11288O000000o.O00000o;
                                if (o0000OOo != null) {
                                    o0000OOo.notifyDataSetChanged();
                                    this.f11288O000000o.O00000Oo();
                                    return;
                                }
                                ixe.O000000o("mAdapter");
                                throw null;
                            }
                            View view = this.f11288O000000o.O00000oo;
                            if (view != null) {
                                view.setVisibility(8);
                            }
                            this.f11288O000000o.O000000o();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public final void onPageSelected() {
        super.onPageSelected();
        this.O0000oO = true;
        hxk hxk = hxi.O00000o;
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hxk.f952O000000o.O000000o("scene_recommend_click", "homeid", O0000OOo2);
        PtrFrameLayout ptrFrameLayout = this.O00000oO;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.setEnabled(true);
        }
        PtrFrameLayout ptrFrameLayout2 = this.O00000oO;
        if (ptrFrameLayout2 != null) {
            ptrFrameLayout2.requestDisallowInterceptTouchEvent(false);
        }
        PtrFrameLayout ptrFrameLayout3 = this.O00000oO;
        if (ptrFrameLayout3 != null) {
            ptrFrameLayout3.setPtrHandler(new O00oOooO(this));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$onPageSelected$1", "Lin/srain/cube/views/ptr/PtrDefaultHandler;", "onRefreshBegin", "", "frame", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00oOooO extends PtrDefaultHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11296O000000o;

        O00oOooO(RecommendSceneTab recommendSceneTab) {
            this.f11296O000000o = recommendSceneTab;
        }

        public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            this.f11296O000000o.O000000o();
        }
    }

    public final void onPageDeselected() {
        super.onPageDeselected();
        this.O0000oO = false;
    }

    private final void O0000OOo() {
        PtrFrameLayout ptrFrameLayout;
        if (this.O0000oO && (ptrFrameLayout = this.O00000oO) != null) {
            ptrFrameLayout.refreshComplete();
        }
    }

    public final void O000000o() {
        if (!O00000o0()) {
            O0000OOo();
            O00000oo();
        } else if (ggb.O00000Oo().O0000Oo0() == null) {
            O0000OOo();
        } else if (ggb.O00000Oo().O0000Oo0().isOwner()) {
            O0000o00();
            O0000Oo();
        } else {
            O00000Oo();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H\u0016¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;)V", "getItemCount", "", "getItemId", "", "position", "getItemViewType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "type", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O0000OOo extends RecyclerView.O000000o<RecyclerView.O000OOo0> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11291O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O0000OOo(RecommendSceneTab recommendSceneTab) {
            ixe.O00000o(recommendSceneTab, "this$0");
            this.f11291O000000o = recommendSceneTab;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "p0");
            if (i == 0) {
                RecommendSceneTab recommendSceneTab = this.f11291O000000o;
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rec_scene_title, viewGroup, false);
                ixe.O00000Oo(inflate, "from(p0.context)\n                        .inflate(R.layout.item_rec_scene_title, p0, false)");
                return new O0000O0o(recommendSceneTab, inflate);
            } else if (i == 2) {
                RecommendSceneTab recommendSceneTab2 = this.f11291O000000o;
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rec_scene_fold, viewGroup, false);
                ixe.O00000Oo(inflate2, "from(p0.context).inflate(R.layout.item_rec_scene_fold, p0, false)");
                return new O00000o0(recommendSceneTab2, inflate2);
            } else {
                RecommendSceneTab recommendSceneTab3 = this.f11291O000000o;
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate((int) R.layout.item_rec_scene, viewGroup, false);
                ixe.O00000Oo(inflate3, "from(p0.context).inflate(R.layout.item_rec_scene, p0, false)");
                return new O0000Oo0(recommendSceneTab3, inflate3);
            }
        }

        public final int getItemCount() {
            return this.f11291O000000o.O0000O0o.size();
        }

        public final void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            ixe.O00000o(o000OOo0, "holder");
            int itemViewType = getItemViewType(i);
            if (itemViewType == 0) {
                if (o000OOo0 instanceof O0000O0o) {
                    O0000O0o o0000O0o = (O0000O0o) o000OOo0;
                    O00000o o00000o = (O00000o) this.f11291O000000o.O0000O0o.get(i);
                    ixe.O00000o(o00000o, "uiData");
                    if (!TextUtils.isEmpty(o00000o.O00000o0)) {
                        o0000O0o.f11290O000000o.setText(o00000o.O00000o0);
                    } else {
                        o0000O0o.f11290O000000o.setText("");
                    }
                }
            } else if (itemViewType == 2) {
                if (o000OOo0 instanceof O00000o0) {
                    ((O00000o0) o000OOo0).O000000o((O00000Oo) this.f11291O000000o.O0000O0o.get(i));
                }
            } else if (o000OOo0 instanceof O0000Oo0) {
                ((O0000Oo0) o000OOo0).O000000o((O0000Oo) this.f11291O000000o.O0000O0o.get(i));
            }
        }

        public final int getItemViewType(int i) {
            return this.f11291O000000o.O0000O0o.get(i).O00000Oo;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;Landroid/view/View;)V", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "bind", "", "uiData", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupRecUIData;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O0000O0o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final TextView f11290O000000o;
        final /* synthetic */ RecommendSceneTab O00000Oo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O0000O0o(RecommendSceneTab recommendSceneTab, View view) {
            super(view);
            ixe.O00000o(recommendSceneTab, "this$0");
            ixe.O00000o(view, "view");
            this.O00000Oo = recommendSceneTab;
            View findViewById = this.itemView.findViewById(R.id.txt_title);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.txt_title)");
            this.f11290O000000o = (TextView) findViewById;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$FoldViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;Landroid/view/View;)V", "arrowImg", "Landroid/widget/ImageButton;", "getArrowImg", "()Landroid/widget/ImageButton;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "bind", "", "uiData", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$FoldRecUIData;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O00000o0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11289O000000o;
        private final TextView O00000Oo;
        private final ImageButton O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000o0(RecommendSceneTab recommendSceneTab, View view) {
            super(view);
            ixe.O00000o(recommendSceneTab, "this$0");
            ixe.O00000o(view, "view");
            this.f11289O000000o = recommendSceneTab;
            View findViewById = this.itemView.findViewById(R.id.txt_title);
            ixe.O00000Oo(findViewById, "itemView.findViewById(R.id.txt_title)");
            this.O00000Oo = (TextView) findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.arrow_down_img);
            ixe.O00000Oo(findViewById2, "itemView.findViewById(R.id.arrow_down_img)");
            this.O00000o0 = (ImageButton) findViewById2;
        }

        public final void O000000o(O00000Oo o00000Oo) {
            ixe.O00000o(o00000Oo, "uiData");
            if (o00000Oo.O00000oO == 1) {
                if (!TextUtils.isEmpty(o00000Oo.O00000o0)) {
                    this.O00000Oo.setText(o00000Oo.O00000o0);
                } else {
                    this.O00000Oo.setText("");
                }
                this.O00000o0.setImageResource(R.drawable.mj_drop_down_arrow);
                this.O00000o0.setContentDescription(this.f11289O000000o.getString(R.string.scen_log_open_detail));
            } else {
                this.O00000Oo.setText(this.f11289O000000o.getString(R.string.mj_scene_fold_tip));
                this.O00000o0.setImageResource(R.drawable.mj_arrow_up);
                this.O00000o0.setContentDescription(this.f11289O000000o.getString(R.string.scen_log_close_detail));
            }
            this.itemView.setOnClickListener(new View.OnClickListener(this.f11289O000000o) {
                /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$O00000o0$KtjqlHVYFpKf4sfo4Wa1II94qVY */
                private final /* synthetic */ RecommendSceneTab f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    RecommendSceneTab.O00000o0.O000000o(RecommendSceneTab.O00000Oo.this, this.f$1, view);
                }
            });
        }

        /* access modifiers changed from: private */
        public static final void O000000o(O00000Oo o00000Oo, RecommendSceneTab recommendSceneTab, View view) {
            ixe.O00000o(o00000Oo, "$uiData");
            ixe.O00000o(recommendSceneTab, "this$0");
            if (o00000Oo.O00000oO == 1) {
                recommendSceneTab.O00000oO();
                recommendSceneTab.O00000o0 = true;
                return;
            }
            recommendSceneTab.O00000o();
            recommendSceneTab.O00000o0 = false;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000b¨\u0006!"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab;Landroid/view/View;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "imgGoSetting", "getImgGoSetting", "()Landroid/view/View;", "imgLogo", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImgLogo", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "name", "getName", "runSceneParent", "getRunSceneParent", "txtGoEdit", "getTxtGoEdit", "txtGoSetting", "getTxtGoSetting", "txtRun", "getTxtRun", "bind", "", "uiData", "Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData;", "showEdit", "showRun", "showSetting", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    final class O0000Oo0 extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11292O000000o;
        private final View O00000Oo;
        private final View O00000o;
        private final View O00000o0;
        private final View O00000oO;
        private final View O00000oo;
        private final SimpleDraweeView O0000O0o;
        private final TextView O0000OOo;
        private final TextView O0000Oo0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O0000Oo0(RecommendSceneTab recommendSceneTab, View view) {
            super(view);
            ixe.O00000o(recommendSceneTab, "this$0");
            ixe.O00000o(view, "view");
            this.f11292O000000o = recommendSceneTab;
            View findViewById = this.itemView.findViewById(R.id.run_scene_parent);
            ixe.O00000Oo(findViewById, "itemView.findViewById<TextView>(R.id.run_scene_parent)");
            this.O00000o0 = findViewById;
            View findViewById2 = this.itemView.findViewById(R.id.go_setting);
            ixe.O00000Oo(findViewById2, "itemView.findViewById<TextView>(R.id.go_setting)");
            this.O00000Oo = findViewById2;
            View findViewById3 = this.itemView.findViewById(R.id.expand_hint);
            ixe.O00000Oo(findViewById3, "itemView.findViewById<TextView>(R.id.expand_hint)");
            this.O00000o = findViewById3;
            View findViewById4 = this.itemView.findViewById(R.id.go_edit);
            ixe.O00000Oo(findViewById4, "itemView.findViewById<TextView>(R.id.go_edit)");
            this.O00000oO = findViewById4;
            View findViewById5 = this.itemView.findViewById(R.id.run_scene);
            ixe.O00000Oo(findViewById5, "itemView.findViewById<TextView>(R.id.run_scene)");
            this.O00000oo = findViewById5;
            View findViewById6 = this.itemView.findViewById(R.id.logo);
            ixe.O00000Oo(findViewById6, "itemView.findViewById(R.id.logo)");
            this.O0000O0o = (SimpleDraweeView) findViewById6;
            View findViewById7 = this.itemView.findViewById(R.id.name);
            ixe.O00000Oo(findViewById7, "itemView.findViewById(R.id.name)");
            this.O0000OOo = (TextView) findViewById7;
            View findViewById8 = this.itemView.findViewById(R.id.desc);
            ixe.O00000Oo(findViewById8, "itemView.findViewById(R.id.desc)");
            this.O0000Oo0 = (TextView) findViewById8;
        }

        /* access modifiers changed from: private */
        public static final void O000000o(RecommendSceneTab recommendSceneTab, View view) {
            ixe.O00000o(recommendSceneTab, "this$0");
            hxi.O00000o.O0000o0O();
            recommendSceneTab.startActivity(new Intent(recommendSceneTab.mContext, NFCActionListActivity.class));
            hpq.O000000o().O00000o0();
        }

        /* access modifiers changed from: private */
        public static final void O00000Oo(RecommendSceneTab recommendSceneTab, View view) {
            ixe.O00000o(recommendSceneTab, "this$0");
            hxi.O00000o.f952O000000o.O000000o("sleep_rec_click", new Object[0]);
            recommendSceneTab.startActivity(new Intent(recommendSceneTab.getContext(), SleepModeActivity.class));
        }

        /* access modifiers changed from: private */
        public static final void O000000o(View view) {
            fbs.O000000o(new fbt(view.getContext(), "UwbManagerTagActivity"));
        }

        /* access modifiers changed from: private */
        public static final void O000000o(RecommendSceneTab recommendSceneTab, hoh hoh, View view) {
            ixe.O00000o(recommendSceneTab, "this$0");
            hoa.O000000o(recommendSceneTab.getActivity(), hoh.O00000Oo, new O000000o());
        }

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$MyViewHolder$bind$4$1", "Lcom/xiaomi/smarthome/frame/AsyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o extends fsm<JSONObject, fso> {
            O000000o() {
            }

            public final void onFailure(fso fso) {
                gqg.O00000Oo((int) R.string.execute_fail);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gqg.O00000Oo((int) R.string.execute_success);
            }
        }

        /* access modifiers changed from: private */
        public static final void O000000o(RecommendSceneTab recommendSceneTab, O0000Oo o0000Oo, View view) {
            long j;
            long j2;
            Long l;
            Long l2;
            RecommendSceneTab recommendSceneTab2 = recommendSceneTab;
            O0000Oo o0000Oo2 = o0000Oo;
            ixe.O00000o(recommendSceneTab2, "this$0");
            ixe.O00000o(o0000Oo2, "$uiData");
            if (recommendSceneTab2.O00000Oo) {
                hxk hxk = hxi.O00000o;
                String O0000OOo2 = ggb.O00000Oo().O0000OOo();
                hof hof = o0000Oo2.O00000oO;
                if (hof == null || (l2 = hof.O00000Oo) == null) {
                    j = 0;
                } else {
                    j = l2.longValue();
                }
                int O000000o2 = RecommendSceneTab.O000000o(o0000Oo2.O00000oo);
                hoh hoh = o0000Oo2.O00000oo;
                long j3 = hoh == null ? 0 : hoh.O00000Oo;
                String str = recommendSceneTab2.O0000Oo0;
                if (str == null) {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    hxk.f952O000000o.O000000o("scene_template_click", "homeid", O0000OOo2, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(j3), "templateid", Long.valueOf(j));
                } else {
                    hxk.f952O000000o.O000000o("scene_template_click", "homeid", O0000OOo2, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(j3), "templateid", Long.valueOf(j), "device_did", str);
                }
                hrh.O000000o().O000000o(ggb.O00000Oo().O0000OOo(), o0000Oo2.O00000oO);
                hrh.O000000o().f558O000000o = o0000Oo2.O00000oo;
                hol O000000o3 = hor.O000000o();
                Context activity = recommendSceneTab.getActivity();
                hof hof2 = o0000Oo2.O00000oO;
                if (hof2 == null || (l = hof2.O00000Oo) == null) {
                    j2 = 0;
                } else {
                    j2 = l.longValue();
                }
                hof hof3 = o0000Oo2.O00000oO;
                O000000o3.openRecommendSceneDetail(activity, j2, hof3 == null ? null : hof3.O00000oo, recommendSceneTab2.O0000Oo0);
                return;
            }
            gqg.O00000Oo((int) R.string.main_page_loading_state_initialing);
        }

        private void O000000o() {
            this.O00000oO.setVisibility(8);
            this.O00000Oo.setVisibility(0);
            this.O00000o.setVisibility(0);
            this.O00000oo.setVisibility(8);
        }

        public final void O000000o(O0000Oo o0000Oo) {
            CharSequence charSequence;
            ixe.O00000o(o0000Oo, "uiData");
            hof hof = o0000Oo.O00000oO;
            hoh hoh = o0000Oo.O00000oo;
            if (hof != null || hoh != null) {
                this.O00000o0.setVisibility(0);
                if (hof != null) {
                    this.O0000O0o.setImageURI(hof.O00000oo);
                    TextView textView = this.O0000OOo;
                    String str = hof.O00000oO;
                    textView.setText(str == null ? "" : str);
                    TextView textView2 = this.O0000Oo0;
                    String str2 = hof.O00000o;
                    if (str2 != null) {
                        charSequence = str2;
                    }
                    textView2.setText(charSequence);
                }
                if (hoh == null) {
                    O000000o();
                } else if (!hoh.O00000o0) {
                    O000000o();
                } else if (hoh.O00000o) {
                    this.O00000oO.setVisibility(8);
                    this.O00000Oo.setVisibility(8);
                    this.O00000o.setVisibility(8);
                    this.O00000oo.setVisibility(0);
                    this.O00000oo.setOnClickListener(new View.OnClickListener(hoh) {
                        /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$O0000Oo0$v7iEI66ncv_7aweJcOredDepTOw */
                        private final /* synthetic */ hoh f$1;

                        {
                            this.f$1 = r2;
                        }

                        public final void onClick(View view) {
                            RecommendSceneTab.O0000Oo0.O000000o(RecommendSceneTab.this, this.f$1, view);
                        }
                    });
                } else {
                    this.O00000oO.setVisibility(0);
                    this.O00000Oo.setVisibility(8);
                    this.O00000o.setVisibility(0);
                    this.O00000oo.setVisibility(8);
                }
                this.itemView.setOnClickListener(new View.OnClickListener(o0000Oo) {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$O0000Oo0$whp6PPNkrkL6GLOrbZs38ps5rAg */
                    private final /* synthetic */ RecommendSceneTab.O0000Oo f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        RecommendSceneTab.O0000Oo0.O000000o(RecommendSceneTab.this, this.f$1, view);
                    }
                });
            } else if (o0000Oo.O00000o == 1) {
                this.O0000O0o.setActualImageResource(R.drawable.ic_rcscene_nfc);
                this.O0000OOo.setText((int) R.string.nfc_trigger);
                this.O0000Oo0.setText((int) R.string.nfc_trigger_hint);
                this.O00000o0.setVisibility(8);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$O0000Oo0$S5B9n9OM2jc_2peww5xjZ7gDBCk */

                    public final void onClick(View view) {
                        RecommendSceneTab.O0000Oo0.O000000o(RecommendSceneTab.this, view);
                    }
                });
            } else if (o0000Oo.O00000o == 2) {
                this.O0000O0o.setActualImageResource(R.drawable.mj_sleepmodel_a);
                this.O0000OOo.setText((int) R.string.mj_scene_sleep_mode);
                this.O0000Oo0.setText((int) R.string.mj_scene_sleep_hint);
                this.O00000o0.setVisibility(8);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$O0000Oo0$F_qoPnJPZCIgwXqpWcv3CdomVM */

                    public final void onClick(View view) {
                        RecommendSceneTab.O0000Oo0.O00000Oo(RecommendSceneTab.this, view);
                    }
                });
            } else if (o0000Oo.O00000o == 3) {
                this.O0000O0o.setActualImageResource(R.drawable.icon_uwb_entrance);
                this.O0000OOo.setText((int) R.string.mj_scene_uwb_manager_entrance);
                this.O0000Oo0.setText((int) R.string.mj_scene_uwb_manager_entrance_sub);
                this.O00000o0.setVisibility(8);
                this.itemView.setOnClickListener($$Lambda$RecommendSceneTab$O0000Oo0$L_nd2uPYL8YkzrOV8LNSzxAkC0.INSTANCE);
            }
        }
    }

    private O00000o O0000Oo0() {
        O00000o o00000o = this.O0000OOo;
        if (o00000o != null) {
            return o00000o;
        }
        ixe.O000000o("moreScene");
        throw null;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o(view, "view");
        super.onViewCreated(view, bundle);
        if (!ggb.O00000Oo().O0000OoO.O00000oo) {
            return;
        }
        if (TextUtils.isEmpty(this.O0000Oo0)) {
            O000000o();
            return;
        }
        PtrFrameLayout ptrFrameLayout = this.O00000oO;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.autoRefresh();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        ixe.O00000o(layoutInflater, "inflater");
        if (this.O0000o == null) {
            if (getArguments() != null) {
                Bundle arguments = getArguments();
                if (ixe.O000000o(arguments == null ? null : Boolean.valueOf(arguments.containsKey("device_id")), Boolean.TRUE)) {
                    Bundle arguments2 = getArguments();
                    this.O0000Oo0 = arguments2 == null ? null : arguments2.getString("device_id");
                }
            }
            String string = getString(R.string.nfc_recommend_other);
            ixe.O00000Oo(string, "getString(R.string.nfc_recommend_other)");
            O00000o o00000o = new O00000o(string);
            ixe.O00000o(o00000o, "<set-?>");
            this.O0000OOo = o00000o;
            FragmentActivity activity = getActivity();
            this.O0000oO0 = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
            if (TextUtils.isEmpty(this.O0000Oo0)) {
                this.O0000o = layoutInflater.inflate((int) R.layout.fragment_tab_rec_scene, viewGroup, false);
                View view = this.O0000oO0;
                this.O00000oO = view == null ? null : (PtrFrameLayout) view.findViewById(R.id.pull_down_refresh);
            } else {
                this.O0000o = layoutInflater.inflate((int) R.layout.fragment_plugin_rec_scene, viewGroup, false);
                View view2 = this.O0000o;
                this.O00000oO = view2 == null ? null : (PtrFrameLayout) view2.findViewById(R.id.pull_down_refresh);
                PtrFrameLayout ptrFrameLayout = this.O00000oO;
                if (ptrFrameLayout != null) {
                    ptrFrameLayout.setEnabled(true);
                }
                PtrFrameLayout ptrFrameLayout2 = this.O00000oO;
                if (ptrFrameLayout2 != null) {
                    ptrFrameLayout2.requestDisallowInterceptTouchEvent(false);
                }
                PtrFrameLayout ptrFrameLayout3 = this.O00000oO;
                if (ptrFrameLayout3 != null) {
                    ptrFrameLayout3.setPtrHandler(new O0000o(this));
                }
            }
            View view3 = this.O0000o;
            this.O00000oo = view3 == null ? null : view3.findViewById(R.id.view_other_home);
            View view4 = this.O0000o;
            this.O0000Ooo = view4 == null ? null : view4.findViewById(R.id.common_white_empty_view);
            View view5 = this.O0000o;
            RecyclerView recyclerView = view5 == null ? null : (RecyclerView) view5.findViewById(R.id.scene_rv);
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
            this.O00000o = new O0000OOo(this);
            if (recyclerView != null) {
                O0000OOo o0000OOo = this.O00000o;
                if (o0000OOo != null) {
                    recyclerView.setAdapter(o0000OOo);
                } else {
                    ixe.O000000o("mAdapter");
                    throw null;
                }
            }
            PtrFrameLayout ptrFrameLayout4 = this.O00000oO;
            if (ptrFrameLayout4 != null) {
                ptrFrameLayout4.setPullToRefresh(true);
            }
            if (fno.O000000o().O0000o00()) {
                this.O00000Oo = true;
            } else {
                fno.O000000o().O000000o(new fno.O00000o() {
                    /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$NL_ERLpQ_3XXto6_yutErEI4j10 */

                    public final void onDeviceReady(Map map) {
                        RecommendSceneTab.O000000o(RecommendSceneTab.this, map);
                    }
                });
            }
            this.O0000OoO = new MyReceiver(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("action_on_login_success");
            intentFilter.addAction("action_on_logout");
            intentFilter.addAction("home_room_home_changed");
            intentFilter.addAction("home_room_updated");
            ft O000000o2 = ft.O000000o(this.mContext);
            MyReceiver myReceiver = this.O0000OoO;
            if (myReceiver != null) {
                O000000o2.O000000o(myReceiver, intentFilter);
                if (ggb.O00000Oo().O0000OoO.O00000oo) {
                    O000000o();
                }
            } else {
                ixe.O000000o("myReceiver");
                throw null;
            }
        }
        return this.O0000o;
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$onCreateView$1", "Lin/srain/cube/views/ptr/PtrDefaultHandler;", "onRefreshBegin", "", "frame", "Lin/srain/cube/views/ptr/PtrFrameLayout;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000o extends PtrDefaultHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11293O000000o;

        O0000o(RecommendSceneTab recommendSceneTab) {
            this.f11293O000000o = recommendSceneTab;
        }

        public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
            this.f11293O000000o.O000000o();
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(RecommendSceneTab recommendSceneTab, Map map) {
        ixe.O00000o(recommendSceneTab, "this$0");
        recommendSceneTab.O00000Oo = true;
    }

    public final void O00000Oo() {
        O0000OOo();
        View view = this.O00000oo;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void onResume() {
        super.onResume();
        hxp hxp = hxi.O00000o0;
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hxp.f957O000000o.O000000o("scene_recommend_show", "homeid", O0000OOo2);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        long j;
        long j2;
        Long l;
        super.onActivityResult(i, i2, intent);
        gsy.O00000Oo("RecScene", "onActivityResult");
        if (i2 == -1) {
            if (intent == null) {
                j = 0;
            } else {
                j = intent.getLongExtra("tpl_id", 0);
            }
            if (intent == null) {
                j2 = 0;
            } else {
                j2 = intent.getLongExtra("scene_id", 0);
            }
            if (j > 0) {
                int i3 = 0;
                int size = this.O0000O0o.size();
                if (size > 0) {
                    while (true) {
                        int i4 = i3 + 1;
                        if (this.O0000O0o.get(i3).O00000Oo == 1) {
                            O0000Oo o0000Oo = (O0000Oo) this.O0000O0o.get(i3);
                            hof hof = o0000Oo.O00000oO;
                            if (hof == null) {
                                l = null;
                            } else {
                                l = hof.O00000Oo;
                            }
                            if (l != null && l.longValue() == j) {
                                if (j2 <= 0) {
                                    o0000Oo.O00000oo = null;
                                } else {
                                    o0000Oo.O00000oo = hrh.O000000o().O00000oO();
                                }
                            }
                        }
                        if (i4 >= size) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                O0000OOo o0000OOo = this.O00000o;
                if (o0000OOo != null) {
                    o0000OOo.notifyDataSetChanged();
                } else {
                    ixe.O000000o("mAdapter");
                    throw null;
                }
            }
        }
    }

    public static boolean O00000o0() {
        return ServiceApplication.getStateNotifier().f15923O000000o == 4;
    }

    private final void O0000Oo() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        Disposable subscribe = Observable.zip(O0000OoO(), O0000o0(), O0000Ooo(), new Function3() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$cxOqsdhtMG9YwqvhR4hiCCdtlVw */

            public final Object apply(Object obj, Object obj2, Object obj3) {
                return RecommendSceneTab.O000000o(RecommendSceneTab.this, (ArrayList) obj, (List) obj2, ((Boolean) obj3).booleanValue());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer(compositeDisposable) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$z4RKtzcZptXt8gLu79rQO3RZ7ic */
            private final /* synthetic */ CompositeDisposable f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RecommendSceneTab.O000000o(RecommendSceneTab.this, this.f$1, (ArrayList) obj);
            }
        }, new Consumer(compositeDisposable) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$j_VYVFe8K69QX_CcAnh8KaBH4Mo */
            private final /* synthetic */ CompositeDisposable f$1;

            {
                this.f$1 = r2;
            }

            public final void accept(Object obj) {
                RecommendSceneTab.O000000o(RecommendSceneTab.this, this.f$1, (Throwable) obj);
            }
        });
        ixe.O00000Oo(subscribe, "zip(\n            getRecTplObservable(),\n            getSceneObservable(),\n            getConfigObservable(),\n            Function3 { t1: ArrayList<RecommendTpl>?, t2: List<SimpleRecScene>?, t3: Boolean ->\n                //子线程\n                MiJiaLog.writeLogOnAll(\n                    LogType.SCENE,\n                    \"recScene\",\n                    \"bifunc \" + t1?.size + \"---\" + t2?.size + \" showConfig \" + t3\n                )\n                mShowSleepMode = t3\n                /**\n                 * 排序规则：\n                 * 1.已设置的\n                 * 1.1手动场景在前，自动场景靠后\n                 * 1.2最近编辑靠前。\n                 * 2.未设置(最近新增的模板，靠前展示)\n                 */\n                val tmpClick: ArrayList<RecUIData> = arrayListOf()\n                val tmpAuto: ArrayList<RecUIData> = arrayListOf()\n                //记录已设置。已设置，enable为false,展示在未开启里面。\n                val tmpHasMap: HashMap<String, SimpleRecScene> = hashMapOf()\n                val tplList: ArrayList<RecUIData> = arrayListOf()\n\n                if (t2 != null) {\n\n                    for (i in t2.indices) {\n\n                        var tmpData = SceneRecUIData(TYPE_DATA)\n                        tmpData.sceneData = t2[i]\n                        if (t1 != null) {\n                            for (j in t1.indices) {\n                                if (TextUtils.equals(\n                                        t2[i].templateId.toString(),\n                                        t1[j].tempId.toString()\n                                    )\n                                ) {\n                                    tmpData.tplData = t1[j]\n                                    break\n                                }\n                            }\n                        }\n                        if (tmpData.sceneData != null && tmpData.tplData != null) {\n                            //未开启，记录之前的智能\n                            tmpHasMap[t2[i].templateId.toString()] = t2[i]\n                            if (t2[i].enable) {\n                                if (t2[i].userClickSetted) {\n                                    tmpClick.add(tmpData)\n                                } else {\n                                    tmpAuto.add(tmpData)\n                                }\n                            }\n                        }\n\n\n                    }\n                }\n                if (t1 != null) {\n                    //把未设置的列表筛选出来\n                    for (i in t1.indices) {\n                        var tmpData = SceneRecUIData(TYPE_DATA)\n                        if (tmpHasMap.containsKey(t1[i].tempId.toString())) {\n                            //创建过\n                            tmpData.sceneData = tmpHasMap[t1[i].tempId.toString()]\n                            if (tmpData.sceneData?.enable == true) {\n                                //创建过，且已开启\n                                continue\n                            }\n                            //else{创建过，且已开启}\n                        }\n                        tmpData.tplData = t1[i]\n                        tplList.add(tmpData)\n                    }\n                }\n                if (tplList.size > 0) {\n                    //未设置或者已关闭\n                    tplList.add(\n                        0,\n                        GroupRecUIData(RecUIData.TYPE_GROUP, getString(R.string.mj_scene_not_set))\n                    )\n                }\n                //已开启，收起模式\n                var tmpOpenList: ArrayList<RecUIData> = arrayListOf()\n\n                if (tmpClick.size > 0) {\n                    tmpOpenList.addAll(tmpClick)\n                }\n                if (tmpAuto.size > 0) {\n                    tmpOpenList.addAll(tmpAuto)\n                }\n                if (tmpOpenList.size > 0) {\n                    if (tmpOpenList.size > 2) {\n                        val hideCount: Int = tmpOpenList.size - 2\n                        val titleText = resources.getQuantityString(\n                            R.plurals.mj_scene_unfold_tip,\n                            hideCount,\n                            hideCount\n                        )\n                        tplList.add(0, FoldRecUIData(RecUIData.TYPE_FOLD, titleText, hideCount, 0))\n                    }\n                    tplList.addAll(0, tmpOpenList)\n                    //已开启\n                    tplList.add(\n                        0,\n                        GroupRecUIData(RecUIData.TYPE_GROUP, getString(R.string.go_edit))\n                    )\n                }\n\n                tplList\n            }).subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .subscribe(getUIDataConsumer(co), getErrorDataConsumer(co))");
        compositeDisposable.add(subscribe);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x014a, code lost:
        if (_m_j.ixe.O000000o(r10 == null ? null : java.lang.Boolean.valueOf(r10.O00000o0), java.lang.Boolean.TRUE) == false) goto L_0x014c;
     */
    public static final ArrayList O000000o(RecommendSceneTab recommendSceneTab, ArrayList arrayList, List list, boolean z) {
        boolean z2;
        int size;
        int i;
        int i2;
        int size2;
        RecommendSceneTab recommendSceneTab2 = recommendSceneTab;
        ArrayList arrayList2 = arrayList;
        List list2 = list;
        boolean z3 = z;
        ixe.O00000o(recommendSceneTab2, "this$0");
        LogType logType = LogType.SCENE;
        StringBuilder sb = new StringBuilder("bifunc ");
        sb.append(arrayList2 == null ? null : Integer.valueOf(arrayList.size()));
        sb.append("---");
        sb.append(list2 == null ? null : Integer.valueOf(list.size()));
        sb.append(" showConfig ");
        sb.append(z3);
        gsy.O00000o0(logType, "recScene", sb.toString());
        recommendSceneTab2.O0000Oo = z3;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        HashMap hashMap = new HashMap();
        ArrayList arrayList5 = new ArrayList();
        if (list2 != null && list.size() - 1 >= 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                O0000Oo o0000Oo = new O0000Oo();
                o0000Oo.O00000oo = (hoh) list2.get(i3);
                if (arrayList2 == null || arrayList.size() - 1 < 0) {
                    i2 = i;
                } else {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        i2 = i;
                        if (TextUtils.equals(String.valueOf(((hoh) list2.get(i3)).f444O000000o), String.valueOf(((hof) arrayList2.get(i5)).O00000Oo))) {
                            o0000Oo.O00000oO = (hof) arrayList2.get(i5);
                            break;
                        } else if (i6 > size2) {
                            break;
                        } else {
                            i5 = i6;
                            i = i2;
                        }
                    }
                }
                if (!(o0000Oo.O00000oo == null || o0000Oo.O00000oO == null)) {
                    hashMap.put(String.valueOf(((hoh) list2.get(i3)).f444O000000o), list2.get(i3));
                    if (((hoh) list2.get(i3)).O00000o0) {
                        if (((hoh) list2.get(i3)).O00000o) {
                            arrayList3.add(o0000Oo);
                        } else {
                            arrayList4.add(o0000Oo);
                        }
                    }
                }
                i = i2;
                if (i4 > i) {
                    break;
                }
                i3 = i4;
            }
        }
        if (arrayList2 != null && arrayList.size() - 1 >= 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7 + 1;
                O0000Oo o0000Oo2 = new O0000Oo();
                if (hashMap.containsKey(String.valueOf(((hof) arrayList2.get(i7)).O00000Oo))) {
                    o0000Oo2.O00000oo = (hoh) hashMap.get(String.valueOf(((hof) arrayList2.get(i7)).O00000Oo));
                    hoh hoh = o0000Oo2.O00000oo;
                }
                o0000Oo2.O00000oO = (hof) arrayList2.get(i7);
                arrayList5.add(o0000Oo2);
                if (i8 > size) {
                    break;
                }
                i7 = i8;
            }
        }
        if (arrayList5.size() > 0) {
            String string = recommendSceneTab2.getString(R.string.mj_scene_not_set);
            ixe.O00000Oo(string, "getString(R.string.mj_scene_not_set)");
            arrayList5.add(0, new O00000o(string));
        }
        ArrayList arrayList6 = new ArrayList();
        if (arrayList3.size() > 0) {
            arrayList6.addAll(arrayList3);
        }
        if (arrayList4.size() > 0) {
            arrayList6.addAll(arrayList4);
        }
        if (arrayList6.size() > 0) {
            if (arrayList6.size() > 2) {
                int size3 = arrayList6.size() - 2;
                z2 = false;
                String quantityString = recommendSceneTab.getResources().getQuantityString(R.plurals.mj_scene_unfold_tip, size3, Integer.valueOf(size3));
                ixe.O00000Oo(quantityString, "resources.getQuantityString(\n                            R.plurals.mj_scene_unfold_tip,\n                            hideCount,\n                            hideCount\n                        )");
                arrayList5.add(0, new O00000Oo(quantityString, size3));
            } else {
                z2 = false;
            }
            arrayList5.addAll(z2, arrayList6);
            String string2 = recommendSceneTab2.getString(R.string.go_edit);
            ixe.O00000Oo(string2, "getString(R.string.go_edit)");
            arrayList5.add(z2, new O00000o(string2));
        }
        return arrayList5;
    }

    public final void O00000o() {
        this.O0000o0o.clear();
        int size = this.O0000O0o.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (this.O0000O0o.get(i) instanceof O00000Oo) {
                    if (((O00000Oo) this.O0000O0o.get(i)).O00000oO != 1) {
                        ((O00000Oo) this.O0000O0o.get(i)).O00000oO = 1;
                        int i3 = i - 1;
                        int i4 = i - ((O00000Oo) this.O0000O0o.get(i)).O00000o;
                        if (i4 <= i3) {
                            int i5 = i3;
                            while (true) {
                                int i6 = i5 - 1;
                                this.O0000o0o.add(this.O0000O0o.get(i5));
                                if (i5 == i4) {
                                    break;
                                }
                                i5 = i6;
                            }
                        }
                        int i7 = i - ((O00000Oo) this.O0000O0o.get(i)).O00000o;
                        if (i7 <= i3) {
                            while (true) {
                                int i8 = i3 - 1;
                                this.O0000O0o.remove(i3);
                                if (i3 == i7) {
                                    break;
                                }
                                i3 = i8;
                            }
                        }
                        O0000OOo o0000OOo = this.O00000o;
                        if (o0000OOo == null) {
                            ixe.O000000o("mAdapter");
                            throw null;
                        } else if (o0000OOo != null) {
                            o0000OOo.notifyDataSetChanged();
                            return;
                        } else {
                            ixe.O000000o("mAdapter");
                            throw null;
                        }
                    } else {
                        return;
                    }
                } else if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }

    public final void O00000oO() {
        int size = this.O0000O0o.size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (this.O0000O0o.get(i) instanceof O00000Oo) {
                    if (((O00000Oo) this.O0000O0o.get(i)).O00000oO != 0) {
                        ((O00000Oo) this.O0000O0o.get(i)).O00000oO = 0;
                        this.O0000O0o.addAll(i, this.O0000o0o);
                        O0000OOo o0000OOo = this.O00000o;
                        if (o0000OOo == null) {
                            ixe.O000000o("mAdapter");
                            throw null;
                        } else if (o0000OOo != null) {
                            o0000OOo.notifyDataSetChanged();
                            return;
                        } else {
                            ixe.O000000o("mAdapter");
                            throw null;
                        }
                    } else {
                        return;
                    }
                } else if (i2 <= size) {
                    i = i2;
                } else {
                    return;
                }
            }
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
    /* access modifiers changed from: private */
    public static final void O000000o(RecommendSceneTab recommendSceneTab, CompositeDisposable compositeDisposable, Throwable th) {
        String str;
        ixe.O00000o(recommendSceneTab, "this$0");
        ixe.O00000o(compositeDisposable, "$co");
        try {
            recommendSceneTab.O0000OOo();
            LogType logType = LogType.SCENE;
            if (th == null) {
                str = null;
            } else {
                str = th.getMessage();
            }
            gsy.O00000o0(logType, "recScene", ixe.O000000o("get ui data error: ", (Object) str));
            recommendSceneTab.O0000O0o.clear();
            recommendSceneTab.O0000o00();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    private final Observable<? extends ArrayList<hof>> O0000OoO() {
        ArrayList arrayList = new ArrayList();
        Context activity = getActivity();
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        String str = this.O0000Oo0;
        Observable<R> concatMap = hnz.O000000o(activity, O0000OOo2, str, str != null, 1).concatMap(new Function(arrayList) {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$K9QaZAvFnyEQCbOXFKUnC9q_vXw */
            private final /* synthetic */ ArrayList f$0;

            {
                this.f$0 = r1;
            }

            public final Object apply(Object obj) {
                return RecommendSceneTab.O000000o(this.f$0, (hnz.O000000o) obj);
            }
        });
        ixe.O00000Oo(concatMap, "getTplPageandnext(\n            activity,\n            HomeManager.getInstance().currentHomeId,\n            mDid,\n            mDid != null,\n            1\n        ).concatMap { t ->\n            MiJiaLog.writeLogOnAll(LogType.SCENE, \"recScene\", \"getTplList Success\")\n            tmp.addAll(t.results)\n            Observable.fromArray(tmp)\n        }");
        return concatMap;
    }

    /* access modifiers changed from: private */
    public static final ObservableSource O000000o(ArrayList arrayList, hnz.O000000o o000000o) {
        ixe.O00000o(arrayList, "$tmp");
        ixe.O00000o(o000000o, "t");
        gsy.O00000o0(LogType.SCENE, "recScene", "getTplList Success");
        arrayList.addAll(o000000o.O00000Oo);
        return Observable.fromArray(arrayList);
    }

    private final Observable<Boolean> O0000Ooo() {
        Observable<Boolean> create = Observable.create(new ObservableOnSubscribe() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$OWVTt3uC2LGDIhSaGXRKjYdFHBU */

            public final void subscribe(ObservableEmitter observableEmitter) {
                RecommendSceneTab.O000000o(RecommendSceneTab.this, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create<Boolean> { emitter ->\n            AppConfigHelper(context).requestConfigWitchCache(\n                \"mijia_function_show_config\",\n                \"1\",\n                \"en\",\n                null,\n                object : JsonAsyncHandler() {\n                    override fun onSuccess(t: String?, res: Response) {\n                        MiJiaLog.writeLogOnAll(LogType.SCENE, \"RecommendSceneTab\", \"onSuccess \" + t)\n                        parseConfig(emitter, t)\n                    }\n\n                    override fun onFailure(\n                        error: com.xiaomi.smarthome.library.http.Error?,\n                        e: java.lang.Exception?,\n                        response: Response?\n                    ) {\n                        emitter.onNext(false)\n                        MiJiaLog.writeLogOnAll(LogType.SCENE, \"RecommendSceneTab\", \"onFailure \" + e)\n                    }\n                })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void O000000o(RecommendSceneTab recommendSceneTab, ObservableEmitter observableEmitter) {
        ixe.O00000o(recommendSceneTab, "this$0");
        ixe.O00000o(observableEmitter, "emitter");
        new AppConfigHelper(recommendSceneTab.getContext()).O000000o("mijia_function_show_config", "1", "en", null, new O0000o00(recommendSceneTab, observableEmitter));
    }

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$getConfigObservable$1$1", "Lcom/xiaomi/smarthome/AppConfigHelper$JsonAsyncHandler;", "onFailure", "", "error", "Lcom/xiaomi/smarthome/library/http/Error;", "e", "Ljava/lang/Exception;", "response", "Lokhttp3/Response;", "onSuccess", "t", "", "res", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000o00 extends AppConfigHelper.O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ RecommendSceneTab f11295O000000o;
        final /* synthetic */ ObservableEmitter<Boolean> O00000Oo;

        O0000o00(RecommendSceneTab recommendSceneTab, ObservableEmitter<Boolean> observableEmitter) {
            this.f11295O000000o = recommendSceneTab;
            this.O00000Oo = observableEmitter;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        /* renamed from: O000000o */
        public final void onSuccess(String str, Response response) {
            ixe.O00000o(response, "res");
            gsy.O00000o0(LogType.SCENE, "RecommendSceneTab", ixe.O000000o("onSuccess ", (Object) str));
            ObservableEmitter<Boolean> observableEmitter = this.O00000Oo;
            ixe.O00000Oo(observableEmitter, "emitter");
            RecommendSceneTab.O000000o(observableEmitter, str);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Exception]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void onFailure(gsf gsf, Exception exc, Response response) {
            this.O00000Oo.onNext(Boolean.FALSE);
            gsy.O00000o0(LogType.SCENE, "RecommendSceneTab", ixe.O000000o("onFailure ", (Object) exc));
        }
    }

    public static boolean O000000o(ObservableEmitter<Boolean> observableEmitter, String str) {
        try {
            observableEmitter.onNext(Boolean.valueOf(new JSONObject(str).optInt("sleep_mode") == 1));
            return true;
        } catch (Throwable unused) {
            observableEmitter.onNext(Boolean.FALSE);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    private final void O0000o00() {
        PtrFrameLayout ptrFrameLayout = this.O00000oO;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.setVisibility(0);
        }
        if (this.O0000Oo0 == null) {
            this.O0000O0o.remove(O0000Oo0());
            this.O0000O0o.remove(this.O0000o0);
            this.O0000O0o.remove(this.O0000o00);
            this.O0000O0o.remove(this.O0000o0O);
            this.O0000O0o.add(O0000Oo0());
            this.O0000O0o.add(this.O0000o00);
            if (this.O0000Oo) {
                this.O0000O0o.add(this.O0000o0O);
            }
        }
        O0000OOo o0000OOo = this.O00000o;
        TextView textView = null;
        if (o0000OOo != null) {
            o0000OOo.notifyDataSetChanged();
            if (this.O0000O0o.size() > 0) {
                View view = this.O0000Ooo;
                if (view != null) {
                    view.setVisibility(8);
                }
                PtrFrameLayout ptrFrameLayout2 = this.O00000oO;
                if (ptrFrameLayout2 != null) {
                    ptrFrameLayout2.setVisibility(0);
                    return;
                }
                return;
            }
            View view2 = this.O0000Ooo;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            PtrFrameLayout ptrFrameLayout3 = this.O00000oO;
            if (ptrFrameLayout3 != null) {
                ptrFrameLayout3.setVisibility(8);
            }
            View view3 = this.O0000Ooo;
            if (view3 != null) {
                textView = view3.findViewById(R.id.common_white_empty_text);
            }
            if (textView != null) {
                textView.setText((int) R.string.scene_rec_no_data_tips);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        ixe.O000000o("mAdapter");
        throw null;
    }

    public final void O00000oo() {
        PtrFrameLayout ptrFrameLayout = this.O00000oO;
        if (ptrFrameLayout != null) {
            ptrFrameLayout.setVisibility(0);
        }
        this.O0000O0o.clear();
        if (this.O0000Oo0 == null) {
            this.O0000O0o.add(O0000Oo0());
            this.O0000O0o.add(this.O0000o00);
        }
        O0000OOo o0000OOo = this.O00000o;
        if (o0000OOo != null) {
            o0000OOo.notifyDataSetChanged();
        } else {
            ixe.O000000o("mAdapter");
            throw null;
        }
    }

    public static int O000000o(hoh hoh) {
        if (hoh == null) {
            return 1;
        }
        return hoh.O00000o0 ? 2 : 3;
    }

    private final Observable<? extends List<hoh>> O0000o0() {
        Observable<? extends List<hoh>> create = Observable.create(new ObservableOnSubscribe() {
            /* class com.xiaomi.smarthome.scene.ui.rec.$$Lambda$RecommendSceneTab$jTEOe8oDk23CXTss6gClxNcEHN4 */

            public final void subscribe(ObservableEmitter observableEmitter) {
                RecommendSceneTab.O00000Oo(RecommendSceneTab.this, observableEmitter);
            }
        });
        ixe.O00000Oo(create, "create { emitter: ObservableEmitter<List<SimpleRecScene>> ->\n            val currentHomeId = HomeManager.getInstance().currentHomeId\n            RemoteApi.getTplSceneList(\n                context,\n                currentHomeId,\n                1,\n                object : SyncCallback<JSONObject?, Error>() {\n                    override fun onSuccess(result: JSONObject?) {\n                        MiJiaLog.writeLogOnAll(\n                            LogType.SCENE,\n                            \"recScene\",\n                            \"getSimpleScene result Success\"\n                        )\n                        if (result != null) {\n                            val array = result.optJSONArray(\"scene_list\")\n                            MiJiaLog.writeLogOnAll(\n                                LogType.SCENE,\n                                \"recScene\",\n                                \"getSimpleScene scenelist size \" + array?.length()\n                            )\n                            if (!emitter.isDisposed) {\n                                emitter.onNext(SimpleRecScene.parse2List(array, currentHomeId))\n                            }\n                        }\n\n                    }\n\n                    override fun onFailure(error: Error) {\n                        try {\n                            MiJiaLog.onlyLogcat(\n                                \"RecScene\",\n                                \"recSceneList： error message\" + if (TextUtils.isEmpty(error.detail)) error.code else error.detail\n                            )\n\n                            if (!emitter.isDisposed) {\n                                emitter.onError(Exception(\"error code \" + error.code))\n                            }\n                        } catch (e: Throwable) {\n                            e.printStackTrace()\n                        }\n                    }\n                })\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    public static final void O00000Oo(RecommendSceneTab recommendSceneTab, ObservableEmitter observableEmitter) {
        ixe.O00000o(recommendSceneTab, "this$0");
        ixe.O00000o(observableEmitter, "emitter");
        String O0000OOo2 = ggb.O00000Oo().O0000OOo();
        hnz.O000000o(recommendSceneTab.getContext(), O0000OOo2, 1, (fsm<JSONObject, fso>) new O0000o0(observableEmitter, O0000OOo2));
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$getSceneObservable$1$1", "Lcom/xiaomi/smarthome/frame/SyncCallback;", "Lorg/json/JSONObject;", "Lcom/xiaomi/smarthome/frame/Error;", "onFailure", "", "error", "onSuccess", "result", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000o0 extends fsy<JSONObject, fso> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ ObservableEmitter<List<hoh>> f11294O000000o;
        final /* synthetic */ String O00000Oo;

        O0000o0(ObservableEmitter<List<hoh>> observableEmitter, String str) {
            this.f11294O000000o = observableEmitter;
            this.O00000Oo = str;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.Integer]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final /* synthetic */ void onSuccess(Object obj) {
            Integer num;
            JSONObject jSONObject = (JSONObject) obj;
            gsy.O00000o0(LogType.SCENE, "recScene", "getSimpleScene result Success");
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("scene_list");
                LogType logType = LogType.SCENE;
                if (optJSONArray == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(optJSONArray.length());
                }
                gsy.O00000o0(logType, "recScene", ixe.O000000o("getSimpleScene scenelist size ", (Object) num));
                if (!this.f11294O000000o.isDisposed()) {
                    ObservableEmitter<List<hoh>> observableEmitter = this.f11294O000000o;
                    String str = this.O00000Oo;
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            if (optJSONObject != null && optJSONObject.has("template_id")) {
                                arrayList.add(hoh.O000000o(optJSONObject, str));
                            }
                        }
                    }
                    observableEmitter.onNext(arrayList);
                }
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
        public final void onFailure(fso fso) {
            Object obj;
            ixe.O00000o(fso, "error");
            try {
                if (TextUtils.isEmpty(fso.O00000Oo)) {
                    obj = Integer.valueOf(fso.f17063O000000o);
                } else {
                    obj = fso.O00000Oo;
                }
                gsy.O00000Oo("RecScene", ixe.O000000o("recSceneList： error message", obj));
                if (!this.f11294O000000o.isDisposed()) {
                    this.f11294O000000o.onError(new Exception(ixe.O000000o("error code ", (Object) Integer.valueOf(fso.f17063O000000o))));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void O0000O0o() {
        gsy.O00000Oo("RecScene", "update");
        if (!gof.O00000o0() || this.O0000o == null) {
            return;
        }
        if (!O00000o0()) {
            O00000oo();
        } else if (ggb.O00000Oo().O0000Oo0() != null) {
            if (ggb.O00000Oo().O0000Oo0().isOwner()) {
                O0000o00();
                O0000Oo();
                return;
            }
            O00000Oo();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData;", "Lcom/xiaomi/smarthome/scene/bean/RecUIData;", "type", "", "other", "(II)V", "getOther", "()I", "sceneData", "Lcom/xiaomi/smarthome/scene/bean/SimpleRecScene;", "getSceneData", "()Lcom/xiaomi/smarthome/scene/bean/SimpleRecScene;", "setSceneData", "(Lcom/xiaomi/smarthome/scene/bean/SimpleRecScene;)V", "tplData", "Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "getTplData", "()Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;", "setTplData", "(Lcom/xiaomi/smarthome/scene/bean/RecommendTpl;)V", "Companion", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O0000Oo extends hoe {
        public static final O000000o O00000o0 = new O000000o((byte) 0);
        final int O00000o;
        hof O00000oO;
        hoh O00000oo;

        public /* synthetic */ O0000Oo() {
            this(1, 1);
        }

        public O0000Oo(int i, int i2) {
            super(1);
            this.O00000o = i2;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$SceneRecUIData$Companion;", "", "()V", "NFC_TRIGGER", "", "SLEEP_MODE", "UWB_ENTRANCE", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        public static final class O000000o {
            public /* synthetic */ O000000o(byte b) {
                this();
            }

            private O000000o() {
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$GroupRecUIData;", "Lcom/xiaomi/smarthome/scene/bean/RecUIData;", "type", "", "title", "", "(ILjava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o extends hoe {
        final String O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000o(String str) {
            super(0);
            ixe.O00000o(str, "title");
            this.O00000o0 = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/smarthome/scene/ui/rec/RecommendSceneTab$FoldRecUIData;", "Lcom/xiaomi/smarthome/scene/bean/RecUIData;", "type", "", "title", "", "hideCount", "foldMode", "(ILjava/lang/String;II)V", "getFoldMode", "()I", "setFoldMode", "(I)V", "getHideCount", "getTitle", "()Ljava/lang/String;", "smarthome-scene_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000Oo extends hoe {
        final int O00000o;
        final String O00000o0;
        int O00000oO = 0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O00000Oo(String str, int i) {
            super(2);
            ixe.O00000o(str, "title");
            this.O00000o0 = str;
            this.O00000o = i;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0063 A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069 A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[SYNTHETIC, Splitter:B:34:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00af A[Catch:{ Exception -> 0x0102 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6 A[Catch:{ Exception -> 0x0102 }, LOOP:0: B:9:0x0024->B:40:0x00e6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e5 A[EDGE_INSN: B:52:0x00e5->B:39:0x00e5 ?: BREAK  , SYNTHETIC] */
    public static final void O000000o(RecommendSceneTab recommendSceneTab, CompositeDisposable compositeDisposable, ArrayList arrayList) {
        long j;
        hoh hoh;
        String str;
        RecommendSceneTab recommendSceneTab2 = recommendSceneTab;
        ArrayList arrayList2 = arrayList;
        ixe.O00000o(recommendSceneTab2, "this$0");
        ixe.O00000o(compositeDisposable, "$co");
        try {
            recommendSceneTab2.O0000O0o.clear();
            if (arrayList2 != null && arrayList.size() > 0) {
                int size = arrayList.size();
                if (size > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (arrayList2.get(i) instanceof O0000Oo) {
                            O0000Oo o0000Oo = (O0000Oo) arrayList2.get(i);
                            if (o0000Oo.O00000Oo == 1) {
                                hxr hxr = hxi.O00000oO;
                                ggb O00000Oo2 = ggb.O00000Oo();
                                String O0000OOo2 = O00000Oo2 == null ? null : O00000Oo2.O0000OOo();
                                hof hof = o0000Oo.O00000oO;
                                long j2 = 0;
                                if (hof != null) {
                                    Long l = hof.O00000Oo;
                                    if (l != null) {
                                        j = l.longValue();
                                        int O000000o2 = O000000o(o0000Oo.O00000oo);
                                        hoh = o0000Oo.O00000oo;
                                        if (hoh == null) {
                                            j2 = hoh.O00000Oo;
                                        }
                                        str = recommendSceneTab2.O0000Oo0;
                                        if (str == null) {
                                            str = "";
                                        }
                                        if (!TextUtils.isEmpty(str)) {
                                            hxr.f958O000000o.O000000o("scene_template_show", "homeid", O0000OOo2, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(j2), "templateid", Long.valueOf(j));
                                        } else {
                                            hxr.f958O000000o.O000000o("scene_template_show", "homeid", O0000OOo2, "state", Integer.valueOf(O000000o2), "us_id", Long.valueOf(j2), "templateid", Long.valueOf(j), "device_did", str);
                                            if (i2 < size) {
                                                break;
                                            }
                                            i = i2;
                                        }
                                    }
                                }
                                j = 0;
                                int O000000o22 = O000000o(o0000Oo.O00000oo);
                                hoh = o0000Oo.O00000oo;
                                if (hoh == null) {
                                }
                                str = recommendSceneTab2.O0000Oo0;
                                if (str == null) {
                                }
                                if (!TextUtils.isEmpty(str)) {
                                }
                            }
                        }
                        if (i2 < size) {
                        }
                    }
                }
                recommendSceneTab2.O0000O0o.addAll(arrayList2);
            }
            if (!recommendSceneTab2.O00000o0) {
                recommendSceneTab.O00000o();
            } else {
                recommendSceneTab.O00000oO();
            }
            recommendSceneTab.O0000OOo();
            recommendSceneTab.O0000o00();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }
}
