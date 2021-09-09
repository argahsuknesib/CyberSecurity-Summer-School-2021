package com.xiaomi.smarthome.homeroom;

import _m_j.fso;
import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.hxi;
import _m_j.iuf;
import _m_j.ivb;
import _m_j.ixe;
import android.content.Intent;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.HomeStyleActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003/01B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"J\u0006\u0010%\u001a\u00020 J\b\u0010&\u001a\u00020 H\u0016J\u0012\u0010'\u001a\u00020 2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020 H\u0014J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020 2\b\u0010.\u001a\u0004\u0018\u00010\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity;", "Lcom/xiaomi/smarthome/framework/page/BaseActivity;", "()V", "confirmDialog", "Lcom/xiaomi/smarthome/library/common/dialog/MLAlertDialog;", "home", "Lcom/xiaomi/smarthome/homeroom/model/Home;", "keys", "", "", "getKeys", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "mHomeStyle", "Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "getMHomeStyle", "()Lcom/xiaomi/smarthome/homeroom/HomeStyle;", "setMHomeStyle", "(Lcom/xiaomi/smarthome/homeroom/HomeStyle;)V", "mNameMap", "", "", "getMNameMap", "()Ljava/util/Map;", "setMNameMap", "(Ljava/util/Map;)V", "mProcessDialog", "Lcom/xiaomi/smarthome/library/common/dialog/XQProgressDialog;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "contrlProgreassDialog", "", "isShow", "", "isRequestSuccess", "finishActivity", "initViews", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "popConfirmView", "style", "showProgressDialog", "msg", "BgViewHolder", "GridSpaceItemDecoration", "SimpleAdapter", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class HomeStyleActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private Map<String, Integer> f8924O000000o;
    private HomeStyle O00000Oo;
    private RecyclerView O00000o;
    private List<String> O00000o0 = new ArrayList();
    private MLAlertDialog O00000oO;
    private Home O00000oo;
    private XQProgressDialog O0000O0o;

    public final void _$_clearFindViewByIdCache() {
    }

    public HomeStyleActivity() {
        Pair[] pairArr = {iuf.O000000o("allroom", Integer.valueOf((int) R.string.wallpaper_allroom)), iuf.O000000o("favorites", Integer.valueOf((int) R.string.wallpaper_favorites)), iuf.O000000o("livingroom", Integer.valueOf((int) R.string.wallpaper_livingroom)), iuf.O000000o("diningroom", Integer.valueOf((int) R.string.wallpaper_diningroom)), iuf.O000000o("bedroom", Integer.valueOf((int) R.string.wallpaper_bedroom)), iuf.O000000o("secondbedroom", Integer.valueOf((int) R.string.wallpaper_secondbedroom)), iuf.O000000o("kitchen", Integer.valueOf((int) R.string.wallpaper_kitchen)), iuf.O000000o("bathroom", Integer.valueOf((int) R.string.wallpaper_bathroom)), iuf.O000000o("babyroom", Integer.valueOf((int) R.string.wallpaper_babyroom)), iuf.O000000o("default", Integer.valueOf((int) R.string.wallpaper_default))};
        ixe.O00000o0(pairArr, "pairs");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(ivb.O000000o(10));
        ivb.O000000o(linkedHashMap, pairArr);
        this.f8924O000000o = linkedHashMap;
    }

    public final Map<String, Integer> getMNameMap() {
        return this.f8924O000000o;
    }

    public final void setMNameMap(Map<String, Integer> map) {
        ixe.O00000o(map, "<set-?>");
        this.f8924O000000o = map;
    }

    public final HomeStyle getMHomeStyle() {
        return this.O00000Oo;
    }

    public final void setMHomeStyle(HomeStyle homeStyle) {
        this.O00000Oo = homeStyle;
    }

    public final List<String> getKeys() {
        return this.O00000o0;
    }

    public final void setKeys(List<String> list) {
        ixe.O00000o(list, "<set-?>");
        this.O00000o0 = list;
    }

    public final void onCreate(Bundle bundle) {
        Map<String, String> map;
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_background);
        this.O00000Oo = (HomeStyle) getIntent().getParcelableExtra("style");
        this.O00000oo = ggb.O00000Oo().O00000o(getIntent().getStringExtra("homeid"));
        HomeStyle homeStyle = this.O00000Oo;
        Set<String> set = null;
        if (!(homeStyle == null || (map = homeStyle.O00000o) == null)) {
            set = map.keySet();
        }
        if (set != null) {
            for (String add : set) {
                getKeys().add(add);
            }
        }
        initViews();
    }

    public final void onDestroy() {
        MLAlertDialog mLAlertDialog;
        super.onDestroy();
        MLAlertDialog mLAlertDialog2 = this.O00000oO;
        Boolean valueOf = mLAlertDialog2 == null ? null : Boolean.valueOf(mLAlertDialog2.isShowing());
        if (valueOf != null && valueOf.booleanValue() && (mLAlertDialog = this.O00000oO) != null) {
            mLAlertDialog.dismiss();
        }
    }

    public final void initViews() {
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$7tv5xqQntXSvaQXj5ic_aRD8Gk0 */

            public final void onClick(View view) {
                HomeStyleActivity.O000000o(HomeStyleActivity.this, view);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.btn_confirm);
        textView2.setVisibility(0);
        textView2.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$vSeP3n9bVVtHYjhw7xj78O9mykQ */

            public final void onClick(View view) {
                HomeStyleActivity.O00000Oo(HomeStyleActivity.this, view);
            }
        });
        HomeStyle homeStyle = this.O00000Oo;
        textView.setText(homeStyle == null ? null : homeStyle.O00000Oo);
        View findViewById = findViewById(R.id.rl_room_background);
        ixe.O00000Oo(findViewById, "findViewById(R.id.rl_room_background)");
        this.O00000o = (RecyclerView) findViewById;
        RecyclerView recyclerView = this.O00000o;
        if (recyclerView != null) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.leftMargin = gpc.O000000o(22.0f);
                marginLayoutParams.rightMargin = gpc.O000000o(22.0f);
                RecyclerView recyclerView2 = this.O00000o;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutParams(marginLayoutParams);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
                    RecyclerView recyclerView3 = this.O00000o;
                    if (recyclerView3 != null) {
                        recyclerView3.setLayoutManager(gridLayoutManager);
                        RecyclerView recyclerView4 = this.O00000o;
                        if (recyclerView4 != null) {
                            recyclerView4.setAdapter(new O00000o0(this));
                            RecyclerView recyclerView5 = this.O00000o;
                            if (recyclerView5 != null) {
                                recyclerView5.addItemDecoration(new O00000Oo(this, gpc.O000000o(20.0f), gpc.O000000o(8.0f)));
                            } else {
                                ixe.O000000o("recyclerView");
                                throw null;
                            }
                        } else {
                            ixe.O000000o("recyclerView");
                            throw null;
                        }
                    } else {
                        ixe.O000000o("recyclerView");
                        throw null;
                    }
                } else {
                    ixe.O000000o("recyclerView");
                    throw null;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
        } else {
            ixe.O000000o("recyclerView");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(HomeStyleActivity homeStyleActivity, View view) {
        ixe.O00000o(homeStyleActivity, "this$0");
        homeStyleActivity.onBackPressed();
        hxi.O00000o.O0000oOO("2");
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
    public static final void O00000Oo(HomeStyleActivity homeStyleActivity, View view) {
        ixe.O00000o(homeStyleActivity, "this$0");
        HomeStyle mHomeStyle = homeStyleActivity.getMHomeStyle();
        Window window = null;
        String str = mHomeStyle == null ? null : mHomeStyle.f8923O000000o;
        if (str != null) {
            View inflate = LayoutInflater.from(homeStyleActivity.getContext()).inflate((int) R.layout.home_room_wallpaper_style_confirm, (ViewGroup) null);
            if (homeStyleActivity.O00000oO == null) {
                homeStyleActivity.O00000oO = new MLAlertDialog.Builder(homeStyleActivity.getContext()).O00000o0().O00000o();
            }
            inflate.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener(str) {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$R7vov47YARVGQDnQCqwk9iHN5Zg */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeStyleActivity.O000000o(HomeStyleActivity.this, this.f$1, view);
                }
            });
            inflate.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener(str) {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$58lgi02854Naze3CTUnz1_wfjNA */
                private final /* synthetic */ String f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    HomeStyleActivity.O00000Oo(HomeStyleActivity.this, this.f$1, view);
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.f3590tv);
            if (ixe.O000000o((Object) str, (Object) "style_1")) {
                textView.setText(homeStyleActivity.getString(R.string.home_wallpaper_set_tips_1));
                textView.setGravity(17);
            } else {
                textView.setText(homeStyleActivity.getString(R.string.home_wallpaper_set_tips_2));
            }
            MLAlertDialog mLAlertDialog = homeStyleActivity.O00000oO;
            if (mLAlertDialog != null) {
                mLAlertDialog.setView(inflate, 0, 0, 0, 0);
            }
            MLAlertDialog mLAlertDialog2 = homeStyleActivity.O00000oO;
            if (mLAlertDialog2 != null) {
                mLAlertDialog2.show();
            }
            MLAlertDialog mLAlertDialog3 = homeStyleActivity.O00000oO;
            if (mLAlertDialog3 != null) {
                window = mLAlertDialog3.getWindow();
            }
            if (window != null) {
                ViewGroup.LayoutParams layoutParams = window.findViewById(R.id.parentPanel).getLayoutParams();
                if (layoutParams != null) {
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
            }
            hxi.O00000o.O0000oOO("1");
        }
    }

    public final void showProgressDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.loading_share_info);
        }
        this.O0000O0o = new XQProgressDialog(this);
        XQProgressDialog xQProgressDialog = this.O0000O0o;
        ixe.O000000o(xQProgressDialog);
        xQProgressDialog.setCancelable(true);
        XQProgressDialog xQProgressDialog2 = this.O0000O0o;
        ixe.O000000o(xQProgressDialog2);
        xQProgressDialog2.setMessage(str);
        XQProgressDialog xQProgressDialog3 = this.O0000O0o;
        ixe.O000000o(xQProgressDialog3);
        xQProgressDialog3.show();
    }

    public final void contrlProgreassDialog(boolean z, boolean z2, boolean z3) {
        if (isValid() && !z) {
            if (this.O0000O0o != null) {
                getWindow().getDecorView().postDelayed(new Runnable(z3) {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$J9h3JV2vLn6MGcFmsrrV2XXv_s */
                    private final /* synthetic */ boolean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        HomeStyleActivity.O000000o(HomeStyleActivity.this, this.f$1);
                    }
                }, 2000);
            }
            if (!z2) {
                gqg.O00000Oo((int) R.string.home_set_failed);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O000000o(HomeStyleActivity homeStyleActivity, boolean z) {
        ixe.O00000o(homeStyleActivity, "this$0");
        XQProgressDialog xQProgressDialog = homeStyleActivity.O0000O0o;
        if (xQProgressDialog != null) {
            ixe.O000000o(xQProgressDialog);
            xQProgressDialog.dismiss();
        }
        if (z) {
            Intent intent = new Intent();
            HomeStyle mHomeStyle = homeStyleActivity.getMHomeStyle();
            intent.putExtra("wallpaperNamePrefix", mHomeStyle == null ? null : mHomeStyle.O00000o0);
            homeStyleActivity.setResult(-1, intent);
            homeStyleActivity.finish();
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
    public static final void O000000o(HomeStyleActivity homeStyleActivity, String str, View view) {
        ixe.O00000o(homeStyleActivity, "this$0");
        ixe.O00000o(str, "$style");
        MLAlertDialog mLAlertDialog = homeStyleActivity.O00000oO;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
        }
        hxi.O00000o.O0000oOo(ixe.O000000o("2", (Object) str));
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
    public static final void O00000Oo(HomeStyleActivity homeStyleActivity, String str, View view) {
        ixe.O00000o(homeStyleActivity, "this$0");
        ixe.O00000o(str, "$style");
        MLAlertDialog mLAlertDialog = homeStyleActivity.O00000oO;
        if (mLAlertDialog != null) {
            mLAlertDialog.dismiss();
        }
        Home home = homeStyleActivity.O00000oo;
        if (home != null) {
            home.setBackground(str);
        }
        homeStyleActivity.showProgressDialog("");
        hxi.O00000o.O0000oOo(ixe.O000000o("1", (Object) str));
        ggb.O00000Oo().O0000OoO.O000000o(homeStyleActivity.O00000oo, "generalize", new O00000o(homeStyleActivity));
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"com/xiaomi/smarthome/homeroom/HomeStyleActivity$popConfirmView$2$1", "Lcom/xiaomi/smarthome/homeroom/HomeManager$IHomeOperationCallback;", "onFail", "", "errCode", "", "error", "Lcom/xiaomi/smarthome/frame/Error;", "onSuccess", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O00000o implements ggb.O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ HomeStyleActivity f8927O000000o;

        O00000o(HomeStyleActivity homeStyleActivity) {
            this.f8927O000000o = homeStyleActivity;
        }

        public final void O000000o() {
            this.f8927O000000o.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeStyleActivity$O00000o$UM3O8xompOFVRP91GGfLv1E1zvA */

                public final void run() {
                    HomeStyleActivity.O00000o.O000000o(HomeStyleActivity.this);
                }
            }, 1000);
        }

        /* access modifiers changed from: private */
        public static final void O000000o(HomeStyleActivity homeStyleActivity) {
            ixe.O00000o(homeStyleActivity, "this$0");
            ggb.O00000Oo().O00000o0();
            homeStyleActivity.contrlProgreassDialog(false, true, true);
        }

        public final void O000000o(int i, fso fso) {
            ixe.O00000o(fso, "error");
            this.f8927O000000o.contrlProgreassDialog(false, false, false);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity$SimpleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity$BgViewHolder;", "Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity;", "Landroid/view/View$OnClickListener;", "(Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity;)V", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "i", "onClick", "v", "Landroid/view/View;", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000o0 extends RecyclerView.O000000o<O000000o> implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ HomeStyleActivity f8928O000000o;

        public O00000o0(HomeStyleActivity homeStyleActivity) {
            ixe.O00000o(homeStyleActivity, "this$0");
            this.f8928O000000o = homeStyleActivity;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
            String str;
            Map<String, String> map;
            O000000o o000000o = (O000000o) o000OOo0;
            ixe.O00000o(o000000o, "viewHolder");
            String str2 = this.f8928O000000o.getKeys().get(i);
            HomeStyle mHomeStyle = this.f8928O000000o.getMHomeStyle();
            String str3 = null;
            if (mHomeStyle == null || (map = mHomeStyle.O00000o) == null) {
                str = null;
            } else {
                str = map.get(str2);
            }
            ggb.O0000O0o.O000000o(o000000o.f8925O000000o, str, new boolean[0]);
            HomeStyleActivity homeStyleActivity = this.f8928O000000o;
            TextView textView = o000000o.O00000Oo;
            Integer num = homeStyleActivity.getMNameMap().get(str2);
            if (num != null) {
                str3 = homeStyleActivity.getContext().getResources().getString(num.intValue());
            }
            textView.setText(str3);
            o000000o.f8925O000000o.setTag(str);
            o000000o.f8925O000000o.setContentDescription(o000000o.O00000Oo.getText());
            o000000o.f8925O000000o.setOnClickListener(this);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
            ixe.O00000o(viewGroup, "viewGroup");
            View inflate = LayoutInflater.from(this.f8928O000000o.getContext()).inflate((int) R.layout.item_home_background_content, viewGroup, false);
            HomeStyleActivity homeStyleActivity = this.f8928O000000o;
            ixe.O00000Oo(inflate, "item");
            return new O000000o(homeStyleActivity, inflate);
        }

        public final int getItemCount() {
            return this.f8928O000000o.getKeys().size();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
         arg types: [java.lang.String, int]
         candidates:
          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
         arg types: [java.lang.String, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String */
        public final void onClick(View view) {
            Object tag = view == null ? null : view.getTag();
            if (tag != null) {
                String str = (String) tag;
                Intent intent = new Intent(this.f8928O000000o.getContext(), HomeRoomBackgroundPreviewActivity.class);
                intent.putExtra("wallpaperNamePrefix", str);
                intent.putExtra("showConfirmBtn", false);
                this.f8928O000000o.startActivityForResult(intent, 0);
                hxi.O00000o.O0000oOO(ixe.O000000o("3", (Object) str));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        finish();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity$BgViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity;Landroid/view/View;)V", "bg", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBg", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "tv", "Landroid/widget/TextView;", "getTv", "()Landroid/widget/TextView;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O000000o extends RecyclerView.O000OOo0 {

        /* renamed from: O000000o  reason: collision with root package name */
        final SimpleDraweeView f8925O000000o;
        final TextView O00000Oo;
        final /* synthetic */ HomeStyleActivity O00000o0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public O000000o(HomeStyleActivity homeStyleActivity, View view) {
            super(view);
            ixe.O00000o(homeStyleActivity, "this$0");
            ixe.O00000o(view, "view");
            this.O00000o0 = homeStyleActivity;
            View findViewById = view.findViewById(R.id.sd_room_bg);
            ixe.O00000Oo(findViewById, "view.findViewById(R.id.sd_room_bg)");
            this.f8925O000000o = (SimpleDraweeView) findViewById;
            View findViewById2 = view.findViewById(R.id.tv_room_name);
            ixe.O00000Oo(findViewById2, "view.findViewById(R.id.tv_room_name)");
            this.O00000Oo = (TextView) findViewById2;
            PointF pointF = new PointF(0.0f, 0.0f);
            ((GenericDraweeHierarchy) this.f8925O000000o.getHierarchy()).setActualImageFocusPoint(pointF);
            ((GenericDraweeHierarchy) this.f8925O000000o.getHierarchy()).setPlaceholderImageFocusPoint(pointF);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity$GridSpaceItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "mSpanCount", "", "mRowSpacing", "mColumnSpacing", "(Lcom/xiaomi/smarthome/homeroom/HomeStyleActivity;III)V", "getMColumnSpacing", "()I", "setMColumnSpacing", "(I)V", "getMRowSpacing", "setMRowSpacing", "getMSpanCount", "setMSpanCount", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "smarthome-home_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class O00000Oo extends RecyclerView.O0000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ HomeStyleActivity f8926O000000o;
        private int O00000Oo = 3;
        private int O00000o;
        private int O00000o0;

        public O00000Oo(HomeStyleActivity homeStyleActivity, int i, int i2) {
            ixe.O00000o(homeStyleActivity, "this$0");
            this.f8926O000000o = homeStyleActivity;
            this.O00000o0 = i;
            this.O00000o = i2;
        }

        public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
            ixe.O00000o(rect, "outRect");
            ixe.O00000o(view, "view");
            ixe.O00000o(recyclerView, "parent");
            ixe.O00000o(o000OO0o, "state");
            super.getItemOffsets(rect, view, recyclerView, o000OO0o);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int i = this.O00000Oo;
            int i2 = childAdapterPosition % i;
            int i3 = this.O00000o;
            rect.left = (i2 * i3) / i;
            rect.right = i3 - (((i2 + 1) * i3) / i);
            rect.top = childAdapterPosition >= i ? this.O00000o0 : gpc.O000000o(14.0f);
            RecyclerView.O000000o adapter = recyclerView.getAdapter();
            Integer valueOf = adapter == null ? null : Integer.valueOf(adapter.getItemCount());
            rect.bottom = (valueOf != null && valueOf.intValue() == childAdapterPosition + 1) ? gpc.O000000o(50.0f) : 0;
        }
    }
}
