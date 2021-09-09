package _m_j;

import _m_j.bxs;
import _m_j.caw;
import _m_j.cbi;
import _m_j.cbm;
import _m_j.ccn;
import _m_j.cej;
import _m_j.ewr;
import _m_j.ews;
import _m_j.exa;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.account.activity.AccountActivity;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.loader.BaseResult;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.discover.NewDiscoverPageViewsDate;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.mi.global.shop.newmodel.domain.DomainResult;
import com.mi.global.shop.newmodel.home.HomeFlashSaleFollowResult;
import com.mi.global.shop.newmodel.home.HomePageConfigResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.notice.NewNoticeResult;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoResult;
import com.mi.global.shop.newmodel.virtualview.VirtualViewModel;
import com.mi.global.shop.newmodel.virtualview.VirtualViewResult;
import com.mi.global.shop.widget.BadgeView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.MoveImageView;
import com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class caq extends can implements ccn.O000000o, View.OnClickListener, SimplePullToRefreshLayout.O00000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13532O000000o = "caq";
    public SimplePullToRefreshLayout O00000Oo;
    public eul O00000o;
    public EmptyLoadingViewPlus O00000o0;
    RecyclerView O00000oO;
    public SimpleDraweeView O00000oo;
    public SimpleDraweeView O0000O0o;
    public View O0000OOo;
    public SimpleDraweeView O0000Oo;
    public View O0000Oo0;
    public View O0000OoO;
    public boolean O0000Ooo = true;
    public List<ewr> O0000o;
    public NewNoticeData O0000o0;
    public BadgeView O0000o0O;
    public BadgeView O0000o0o;
    public int O0000oO = cdy.O000000o(170.0f);
    public int O0000oO0 = 0;
    public float O0000oOO = 0.0f;
    public int O0000oOo = 0;
    long O0000oo;
    public MoveImageView O0000oo0;
    int O0000ooO;
    private View O0000ooo;
    private CustomTextView O000O00o;
    private boolean O000O0OO = true;
    private String O000O0Oo = (caq.class.getSimpleName() + "_assembly");
    private Dialog O000O0o;
    private AccountActivity O000O0o0;
    private int O00oOoOo = 0;
    private LinearLayout O00oOooO;
    private ImageView O00oOooo;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.caq.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      _m_j.caq.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.caq.O000000o(float, boolean):void */
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            O000000o(this.O0000oOO, true);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [androidx.fragment.app.FragmentActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.shop_home_fragment_new, viewGroup, false);
        this.O0000Oo = (SimpleDraweeView) inflate.findViewById(R.id.search_btn);
        this.O0000OoO = inflate.findViewById(R.id.search_btn_container);
        this.O0000OoO.setVisibility(0);
        this.O0000OoO.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.caq.AnonymousClass12 */

            public final void onClick(View view) {
                ny.O000000o();
                ny.O000000o("/featureGlobalshopSearch/searchActivity").navigation();
            }
        });
        this.O0000OOo = inflate.findViewById(R.id.title_bar_cart_view);
        this.O0000O0o = (SimpleDraweeView) inflate.findViewById(R.id.shopping_cart);
        this.O0000OOo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.caq.AnonymousClass16 */

            public final void onClick(View view) {
                caq caq = caq.this;
                if (cad.O00000o()) {
                    caq.startActivityForResult(new Intent(caq.getContext(), ShoppingCartActivity.class), 22);
                    return;
                }
                Intent intent = new Intent(caq.getContext(), WebActivity.class);
                intent.putExtra("url", cav.O000OOo());
                caq.startActivity(intent);
            }
        });
        this.O0000Oo0 = inflate.findViewById(R.id.iv_order_list_fl);
        this.O00000oo = (SimpleDraweeView) inflate.findViewById(R.id.iv_order_list);
        this.O00000oo.setVisibility(0);
        this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.caq.AnonymousClass17 */

            public final void onClick(View view) {
                caq caq = caq.this;
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    if (cad.O00000o()) {
                        if (ccn.O0000o00().O0000o0O()) {
                            Intent intent = new Intent(caq.getContext(), OrderListAcitvity.class);
                            intent.putExtra("type", 0);
                            caq.startActivityForResult(intent, 1);
                            return;
                        } else if (caq.getActivity() != null) {
                            ((AccountActivity) caq.getActivity()).gotoAccount();
                        }
                    }
                    if (!cad.O0000OoO() && !cad.O00000oo() && !cad.O00000oO() && !cad.O0000Oo0() && !cad.O0000OOo() && !cad.O0000O0o() && !cad.O0000Oo() && !cad.O0000Ooo()) {
                        return;
                    }
                    if (ccn.O0000o00().O0000o0O()) {
                        String O0000oO = cav.O0000oO();
                        Intent intent2 = new Intent(caq.getContext(), WebActivity.class);
                        intent2.putExtra("url", O0000oO);
                        caq.startActivity(intent2);
                    } else if (caq.getActivity() != null) {
                        ((AccountActivity) caq.getActivity()).gotoAccount();
                    }
                } else {
                    if (cad.O00000o()) {
                        if (ccn.O0000o00().O0000o0O()) {
                            Intent intent3 = new Intent(caq.getContext(), OrderListAcitvity.class);
                            intent3.putExtra("type", 0);
                            caq.startActivityForResult(intent3, 1);
                            return;
                        }
                        byl.O00000o0();
                    }
                    if (!cad.O0000OoO() && !cad.O00000oo() && !cad.O00000oO() && !cad.O0000Oo0() && !cad.O0000OOo() && !cad.O0000O0o() && !cad.O0000Oo() && !cad.O0000Ooo()) {
                        return;
                    }
                    if (ccn.O0000o00().O0000o0O()) {
                        String O0000oO2 = cav.O0000oO();
                        Intent intent4 = new Intent(caq.getContext(), WebActivity.class);
                        intent4.putExtra("url", O0000oO2);
                        caq.startActivity(intent4);
                        return;
                    }
                    byl.O00000o0();
                }
            }
        });
        this.O0000ooo = inflate.findViewById(R.id.title_bar_container);
        this.O0000oo0 = (MoveImageView) inflate.findViewById(R.id.iv_screen_bg);
        this.O00000o0 = (EmptyLoadingViewPlus) inflate.findViewById(R.id.loading);
        this.O00oOooO = (LinearLayout) inflate.findViewById(R.id.noticeboard);
        this.O000O00o = (CustomTextView) inflate.findViewById(R.id.notice_text);
        this.O00oOooo = (ImageView) inflate.findViewById(R.id.notice_close);
        this.O00oOooo.setOnClickListener(this);
        this.O00000oO = (RecyclerView) inflate.findViewById(R.id.rv);
        this.O00000oO.setLayoutManager(new LinearLayoutManager(getContext()));
        this.O00000Oo = (SimplePullToRefreshLayout) inflate.findViewById(R.id.home_fragment_ptr);
        this.O00000Oo.setOnRefreshListener(new SimplePullToRefreshLayout.O00000o() {
            /* class _m_j.caq.AnonymousClass18 */

            public final void onRefresh() {
                caq.this.onRefresh();
                caq.this.O00000Oo.O000000o();
            }
        });
        this.O00000Oo.setOnContentOffsetListener(new SimplePullToRefreshLayout.O00000Oo() {
            /* class _m_j.caq.AnonymousClass19 */

            public final void O000000o(int i) {
                caq.this.O0000oo0.setLocation(0, -i);
            }
        });
        this.O00000o0.setPullToRefreshLayout(this.O00000Oo);
        NewNoticeData newNoticeData = this.O0000o0;
        if (newNoticeData != null) {
            O000000o(newNoticeData);
        }
        this.O00000oO.addOnScrollListener(new RecyclerView.O00oOooO() {
            /* class _m_j.caq.AnonymousClass21 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.caq.O000000o(float, boolean):void
             arg types: [float, int]
             candidates:
              _m_j.caq.O000000o(java.lang.String, java.lang.Object):java.lang.String
              _m_j.caq.O000000o(float, boolean):void */
            public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int i3;
                LinearLayoutManager linearLayoutManager;
                int findFirstVisibleItemPosition;
                super.onScrolled(recyclerView, i, i2);
                caq caq = caq.this;
                if (caq.O0000o == null || (findFirstVisibleItemPosition = (linearLayoutManager = (LinearLayoutManager) caq.O00000oO.getLayoutManager()).findFirstVisibleItemPosition()) == -1) {
                    i3 = 0;
                } else {
                    View findViewByPosition = linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    ewr ewr = caq.O0000o.get(findFirstVisibleItemPosition);
                    if (ewr != null && ewr.O0000ooO == 0) {
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) findViewByPosition.getLayoutParams();
                        ewr.O0000ooO = findViewByPosition.getHeight() + layoutParams.bottomMargin + layoutParams.topMargin;
                    }
                    int i4 = 0;
                    for (int i5 = findFirstVisibleItemPosition - 1; i5 >= 0; i5--) {
                        View findViewByPosition2 = linearLayoutManager.findViewByPosition(i5);
                        ewr ewr2 = caq.O0000o.get(i5);
                        if (ewr2 != null) {
                            if (ewr2.O0000ooO == 0 && findViewByPosition2 != null) {
                                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) findViewByPosition2.getLayoutParams();
                                ewr2.O0000ooO = findViewByPosition2.getHeight() + layoutParams2.bottomMargin + layoutParams2.topMargin;
                            }
                            i4 += ewr2.O0000ooO;
                        }
                    }
                    i3 = i4 - findViewByPosition.getTop();
                }
                caq.this.O0000oo0.setLocation(0, i3);
                if (Math.abs(i3 - caq.this.O0000oO0) >= 5) {
                    float f = (((float) i3) * 1.0f) / ((float) caq.this.O0000oO);
                    if (f < caq.this.O0000oOO) {
                        caq.this.O0000oOO = f;
                    }
                    Log.d("onScrolled", "-------" + i3 + "------------" + f + "---");
                    if (f >= 0.0f && caq.this.O0000oOO <= 1.0f) {
                        caq caq2 = caq.this;
                        caq2.O0000oOO = f;
                        caq2.O0000oO0 = i3;
                        caq2.O000000o(f, false);
                    }
                }
            }
        });
        this.O0000o0O = new BadgeView(getContext(), this.O0000OOo);
        this.O0000o0O.setTextColor(getResources().getColor(17170443));
        this.O0000o0O.setTextSize(2, 10.0f);
        this.O0000o0O.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.O0000o0O.setmBadgePosition(2);
        this.O0000o0O.setBadgeMargin(0, cdy.O000000o((Activity) getActivity(), 5.0f));
        this.O0000o0o = new BadgeView(getContext(), this.O0000Oo0);
        this.O0000o0o.setTextColor(getResources().getColor(17170443));
        this.O0000o0o.setTextSize(2, 10.0f);
        this.O0000o0o.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.O0000o0o.setmBadgePosition(2);
        this.O0000o0o.setBadgeMargin(0, cdy.O000000o((Activity) getActivity(), 5.0f));
        O00000oO();
        cbi.O000000o(new O000000o(this, (byte) 0));
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        Request request;
        super.onActivityCreated(bundle);
        getActivity();
        ccr.O00000Oo(f13532O000000o, "不设置 MIUI 深色主题");
        if (cad.O00000o()) {
            Uri.Builder buildUpon = Uri.parse(cav.O000Oo0O()).buildUpon();
            cam cam = new cam(buildUpon.toString(), VirtualViewResult.class, new cak<VirtualViewResult>() {
                /* class _m_j.caq.AnonymousClass9 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    VirtualViewResult virtualViewResult = (VirtualViewResult) baseResult;
                    if (virtualViewResult.data != null && virtualViewResult.data.version_info != null) {
                        VirtualViewModel.VersionInfo versionInfo = virtualViewResult.data.version_info;
                        exa.O000000o(versionInfo.url, versionInfo.version, new exa.O000000o() {
                            /* class _m_j.caq.AnonymousClass9.AnonymousClass1 */

                            public final void O000000o() {
                                caq caq = caq.this;
                                if (caq.O0000o != null && caq.O00000o != null) {
                                    cbr.O000000o(new Runnable() {
                                        /* class _m_j.caq.AnonymousClass10 */

                                        public final void run() {
                                            for (int i = 0; i < caq.this.O0000o.size(); i++) {
                                                if ("virtual_view".equals(caq.this.O0000o.get(i).O00000Oo)) {
                                                    caq.this.O00000o.notifyItemChanged(i);
                                                }
                                            }
                                        }
                                    });
                                }
                            }
                        });
                    }
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(caq.f13532O000000o, "getVirtual Exception:".concat(String.valueOf(str)));
                }
            });
            cam.setTag(f13532O000000o);
            ced.f13683O000000o.add(cam);
        }
        O0000OOo();
        caz.O000000o(getContext().getApplicationContext(), new cbi.O00000o0() {
            /* class _m_j.caq.AnonymousClass1 */

            public final void O000000o(NewNoticeData newNoticeData) {
                caq.this.O000000o(newNoticeData);
            }
        });
        if (byl.O0000Oo0) {
            FragmentActivity activity = getActivity();
            final Context applicationContext = activity.getApplication().getApplicationContext();
            cem.O000000o(activity, new cen() {
                /* class _m_j.caq.AnonymousClass20 */

                public final void O00000Oo() {
                }

                public final void O00000o0() {
                    caq.O000000o(applicationContext);
                }
            }, "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        }
        cbc.O000000o(getActivity());
        if (!TextUtils.isEmpty(cbc.O00000Oo())) {
            cbe.O000000o("locationEvent", f13532O000000o, "location", "location", cbc.O00000Oo());
        }
        ccn.O0000o00().O000000o(this);
        Uri.Builder buildUpon2 = Uri.parse(cav.O000Oo0()).buildUpon();
        AnonymousClass7 r0 = new cak<DomainResult>() {
            /* class _m_j.caq.AnonymousClass7 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                DomainResult domainResult = (DomainResult) baseResult;
                if (domainResult == null || domainResult.domainModels == null || domainResult.domainModels.size() <= 0) {
                    cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
                    return;
                }
                cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, new Gson().toJson(domainResult.domainModels));
                caq.this.O000000o();
                cav.O00000Oo();
            }

            public final void O000000o(String str) {
                ccr.O00000Oo(caq.f13532O000000o, "getDomain Exception:".concat(String.valueOf(str)));
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon2.toString(), DomainResult.class, r0);
        } else {
            request = new cal(buildUpon2.toString(), DomainResult.class, r0);
        }
        request.setTag(f13532O000000o);
        ced.f13683O000000o.add(request);
        O000000o();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.caq.O000000o(float, boolean):void
     arg types: [float, int]
     candidates:
      _m_j.caq.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.caq.O000000o(float, boolean):void */
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        O000000o(this.O0000oOO, true);
    }

    public void onResume() {
        Request request;
        super.onResume();
        ccw.f13642O000000o = System.currentTimeMillis();
        if (this.O000O0OO) {
            this.O000O0OO = false;
        } else if (O0000Oo()) {
            String O000O0oO = cav.O000O0oO();
            AnonymousClass14 r1 = new cak<NewNoticeResult>() {
                /* class _m_j.caq.AnonymousClass14 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    caq.this.O0000o0 = ((NewNoticeResult) baseResult).data;
                    caq caq = caq.this;
                    caq.O00000Oo(caq.O0000o0);
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(caq.f13532O000000o, "load notice error".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(O000O0oO, NewNoticeResult.class, r1);
            } else {
                request = new cal(O000O0oO, NewNoticeResult.class, r1);
            }
            request.setTag(f13532O000000o);
            ced.f13683O000000o.add(request);
        }
        getContext();
        cbe.O00000Oo(f13532O000000o);
    }

    public void onDestroyView() {
        super.onDestroyView();
        ccn.O0000o00().O00000Oo(this);
    }

    class O000000o implements cbi.O000000o {
        private O000000o() {
        }

        /* synthetic */ O000000o(caq caq, byte b) {
            this();
        }

        public final void O000000o(boolean z) {
            if (caq.this.getActivity() == null) {
                return;
            }
            if (!z || !cad.O0000o00()) {
                caq.this.O0000OoO.setVisibility(4);
            } else {
                caq.this.O0000OoO.setVisibility(0);
            }
        }
    }

    public static void O000000o(Context context) {
        boolean O000000o2 = cem.O000000o(context, "android.permission.READ_PHONE_STATE");
        if (O000000o2) {
            Device.O000000o(byl.O00000oO(), O000000o2);
        }
    }

    public final void O000000o(float f, boolean z) {
        if (O0000O0o() && this.O0000Oo != null) {
            if (f < 0.5f || z) {
                this.O0000Ooo = true;
                if (this.O0000oOo == 1) {
                    O00000oO();
                } else {
                    O00000o();
                }
            } else if (f >= 0.5f || z) {
                this.O0000Ooo = false;
                O00000oO();
            }
            if (f > 1.0f) {
                f = 1.0f;
            }
            this.O0000ooo.setBackgroundColor(Color.argb((int) (f * 255.0f), 255, 255, 255));
        }
    }

    private void O00000o() {
        this.O0000Oo.setImageDrawable(getResources().getDrawable(R.drawable.shop_search_white));
        this.O00000oo.setImageDrawable(getResources().getDrawable(R.drawable.shop_ic_order_list_white));
        this.O0000O0o.setImageDrawable(getResources().getDrawable(R.drawable.shop_cart_white));
    }

    private void O00000oO() {
        this.O0000Oo.setImageDrawable(getResources().getDrawable(R.drawable.shop_search_grey));
        this.O00000oo.setImageDrawable(getResources().getDrawable(R.drawable.shop_ic_order_list));
        this.O0000O0o.setImageDrawable(getResources().getDrawable(R.drawable.shop_cart_grey));
    }

    public void onRefresh() {
        O0000OOo();
    }

    public final void O000000o(HomePageConfigResult.DataBean dataBean) {
        if (dataBean != null) {
            this.O0000o = dataBean.page_data;
            if (!TextUtils.isEmpty(dataBean.ext_page_data_str)) {
                try {
                    final String optString = new JSONObject(dataBean.ext_page_data_str).optString("background_img");
                    if (!TextUtils.isEmpty(optString)) {
                        this.O0000oo0.setEnable(true);
                        uo.O000000o(byl.O00000oO()).O00000o0().O000000o(optString).O000000o(new vk<Bitmap>() {
                            /* class _m_j.caq.AnonymousClass4 */

                            public final /* synthetic */ void O000000o(Object obj) {
                                Bitmap bitmap = (Bitmap) obj;
                                if (bitmap != null) {
                                    int width = bitmap.getWidth();
                                    int height = bitmap.getHeight();
                                    if (width != 0) {
                                        caq.this.O0000oo0.setLayoutParams(new FrameLayout.LayoutParams(-1, (int) (((((float) height) * 1.0f) / ((float) width)) * ((float) cef.O000000o().f13684O000000o))));
                                    }
                                }
                                duh.O000000o().O000000o(optString, caq.this.O0000oo0);
                            }
                        });
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            this.O00000o = new eul(this.O0000o, new eum() {
                /* class _m_j.caq.AnonymousClass22 */

                public final void O000000o(String str, String str2, String str3, String str4) {
                    O00000Oo(str, str3);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str4)) {
                        cbe.O00000Oo(str2, str4);
                    }
                }

                public final void O000000o(String str, ewr.O000000o o000000o, String str2) {
                    if (o000000o != null) {
                        O00000Oo(o000000o.O00000o0, str2);
                        if (!TextUtils.isEmpty(o000000o.f15902O000000o) && !TextUtils.isEmpty(o000000o.O000O0Oo)) {
                            cbe.O000000o(o000000o.f15902O000000o, o000000o.O000O0Oo, caq.O000000o(str, o000000o));
                        }
                    }
                }

                public final void O000000o(String str, ews.O000000o o000000o, String str2) {
                    if (o000000o != null) {
                        O00000Oo(o000000o.O00000o0, str2);
                        if (!TextUtils.isEmpty(o000000o.f15904O000000o) && !TextUtils.isEmpty(o000000o.O00000oo)) {
                            cbe.O000000o(o000000o.f15904O000000o, o000000o.O00000oo, caq.O000000o(str, o000000o));
                        }
                    }
                }

                private void O00000Oo(String str, String str2) {
                    if (!TextUtils.isEmpty(str)) {
                        if (!TextUtils.isEmpty(str2)) {
                            caq.this.O000000o(str2);
                        }
                        if (str.contains("youtube")) {
                            caq.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                            return;
                        }
                        Intent intent = new Intent(caq.this.getActivity(), WebActivity.class);
                        intent.putExtra("url", str);
                        caq.this.startActivity(intent);
                    }
                }

                public final void O000000o(String str, ewr.O000000o o000000o) {
                    if (o000000o != null && !TextUtils.isEmpty(o000000o.f15902O000000o) && !TextUtils.isEmpty(o000000o.O000O0Oo)) {
                        cbe.O00000Oo(o000000o.f15902O000000o, o000000o.O000O0Oo, caq.O000000o(str, o000000o));
                    }
                }

                public final void O00000Oo(String str, ews.O000000o o000000o, String str2) {
                    if (o000000o != null && !TextUtils.isEmpty(o000000o.f15904O000000o) && !TextUtils.isEmpty(str2)) {
                        cbe.O00000Oo(o000000o.f15904O000000o, str2, caq.O000000o(str, o000000o));
                    }
                }

                public final void O000000o(String str, String str2) {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        cbe.O000000o(str, str2);
                    }
                }

                public final void O000000o(ewr ewr, String str, Object obj) {
                    if (str.equals("block_discovery_list")) {
                        if (!caq.this.O0000O0o()) {
                        }
                    } else if (!str.equals("slider_flash_sale_cfg")) {
                    } else {
                        if (!ccn.O0000o00().O0000o0O()) {
                            byl.O00000o0();
                        } else if (obj != null) {
                            caq caq = caq.this;
                            if (System.currentTimeMillis() - caq.O0000oo >= 800) {
                                caq.O0000oo = System.currentTimeMillis();
                                JSONObject jSONObject = null;
                                try {
                                    jSONObject = new JSONObject(ewr.O00000oo);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (jSONObject != null) {
                                    String O000oO0O = ewr.O00oOooO ? cav.O000oO0O() : cav.O000oO0();
                                    String optString = jSONObject.optString("follow_success");
                                    HashMap hashMap = new HashMap(4);
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(jSONObject.opt("event_code"));
                                    hashMap.put("event_code", sb.toString());
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append(jSONObject.opt("follow_type"));
                                    hashMap.put("follow_type", sb2.toString());
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append(jSONObject.opt("block_code"));
                                    hashMap.put("block_code", sb3.toString());
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(jSONObject.opt("build_type"));
                                    hashMap.put("build_type", sb4.toString());
                                    cal cal = new cal(O000oO0O, HomeFlashSaleFollowResult.class, hashMap, new cak<HomeFlashSaleFollowResult>(obj, ewr, optString) {
                                        /* class _m_j.caq.AnonymousClass3 */

                                        /* renamed from: O000000o  reason: collision with root package name */
                                        final /* synthetic */ Object f13547O000000o;
                                        final /* synthetic */ ewr O00000Oo;
                                        final /* synthetic */ String O00000o0;

                                        public final void O000000o(String str) {
                                        }

                                        {
                                            this.f13547O000000o = r2;
                                            this.O00000Oo = r3;
                                            this.O00000o0 = r4;
                                        }

                                        public final /* synthetic */ void O000000o(BaseResult baseResult) {
                                            HomeFlashSaleFollowResult homeFlashSaleFollowResult = (HomeFlashSaleFollowResult) baseResult;
                                            if (homeFlashSaleFollowResult != null && homeFlashSaleFollowResult.data != null) {
                                                if (homeFlashSaleFollowResult.data.followed) {
                                                    ((ImageButton) this.f13547O000000o).setBackground(caq.this.getActivity().getResources().getDrawable(R.drawable.remind));
                                                    this.O00000Oo.O00oOooO = true;
                                                    if (!TextUtils.isEmpty(this.O00000o0)) {
                                                        Toast.makeText(caq.this.getActivity(), this.O00000o0, 0).show();
                                                    }
                                                } else if (homeFlashSaleFollowResult.data.removed) {
                                                    ((ImageButton) this.f13547O000000o).setBackground(caq.this.getActivity().getResources().getDrawable(R.drawable.unremind));
                                                    this.O00000Oo.O00oOooO = false;
                                                }
                                            }
                                        }
                                    });
                                    cal.setTag(caq.f13532O000000o);
                                    ced.f13683O000000o.add(cal);
                                }
                            }
                        }
                    }
                }

                public final void O000000o(int i) {
                    caq caq = caq.this;
                    caq.O0000oOo = i;
                    if (caq.O0000O0o()) {
                        caq caq2 = caq.this;
                        if (caq2.O0000Ooo && caq2.O0000ooO != i) {
                            caq2.O0000ooO = i;
                            if (i == 1) {
                                caq2.O0000Oo.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_search_grey));
                                caq2.O00000oo.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_ic_order_list));
                                caq2.O0000O0o.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_cart_grey));
                                return;
                            }
                            caq2.O0000Oo.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_search_white));
                            caq2.O00000oo.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_ic_order_list_white));
                            caq2.O0000O0o.setImageDrawable(caq2.getResources().getDrawable(R.drawable.shop_cart_white));
                        }
                    }
                }
            });
            eul.O000000o(cad.O00000o0());
            this.O00000oO.setAdapter(this.O00000o);
        }
    }

    public static String O000000o(String str, Object obj) {
        try {
            Gson gson = new Gson();
            Map map = (Map) gson.fromJson(gson.toJson(obj), new TypeToken<Map<String, Object>>() {
                /* class _m_j.caq.AnonymousClass2 */
            }.getType());
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object value = ((Map.Entry) it.next()).getValue();
                if (value == null || TextUtils.isEmpty(value.toString())) {
                    it.remove();
                }
            }
            map.put("assembly_key", str);
            return gson.toJson(map);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final void O000000o(String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            AnonymousClass5 r0 = new cak<NewDiscoverPageViewsDate>() {
                /* class _m_j.caq.AnonymousClass5 */

                public final /* bridge */ /* synthetic */ void O000000o(BaseResult baseResult) {
                }
            };
            HashMap hashMap = new HashMap();
            hashMap.put("id", str);
            cam cam = new cam(cav.O000OO0o(), NewDiscoverPageViewsDate.class, hashMap, r0);
            cam.setTag(f13532O000000o);
            ced.f13683O000000o.add(cam);
        }
    }

    private void O0000OOo() {
        Request request;
        O0000Oo0();
        O0000OoO();
        Uri.Builder buildUpon = Uri.parse(cav.O000OoO0()).buildUpon();
        AnonymousClass6 r1 = new cak<HomePageConfigResult>() {
            /* class _m_j.caq.AnonymousClass6 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                HomePageConfigResult homePageConfigResult = (HomePageConfigResult) baseResult;
                caq.this.O00000o0();
                if (caq.this.O00000o0 != null) {
                    caq.this.O00000o0.setVisibility(8);
                }
                caq.this.O000000o(homePageConfigResult.data);
                caq.O00000Oo(homePageConfigResult.data);
            }

            public final void O000000o(String str) {
                caq caq = caq.this;
                if (caq.O00000o != null && caq.O00000o.O000000o().size() != 0) {
                    cec.O000000o(caq.getContext(), str, 0);
                } else if (caq.O00000o0 != null) {
                    caq.O00000o0.O000000o(BaseResult.ResultStatus.NETWROK_ERROR);
                }
                caq.this.O00000o0();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), HomePageConfigResult.class, r1);
        } else {
            request = new cal(buildUpon.toString(), HomePageConfigResult.class, r1);
        }
        request.setTag(f13532O000000o);
        ced.f13683O000000o.add(request);
    }

    public static void O00000Oo(HomePageConfigResult.DataBean dataBean) {
        if (dataBean != null) {
            try {
                cej.O00000Oo.O000000o(byl.O00000oO(), "pref_key_home_new_list", new Gson().toJson(dataBean));
            } catch (Exception unused) {
            }
        }
    }

    private HomePageConfigResult.DataBean O0000Oo0() {
        HomePageConfigResult.DataBean dataBean;
        try {
            String O00000Oo2 = cej.O00000Oo.O00000Oo(byl.O00000oO(), "pref_key_home_new_list", "");
            dataBean = (HomePageConfigResult.DataBean) new Gson().fromJson(O00000Oo2, HomePageConfigResult.DataBean.class);
        } catch (Exception unused) {
            dataBean = null;
        }
        O000000o(dataBean);
        return dataBean;
    }

    public final void O000000o() {
        ArrayList arrayList;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
        if (!TextUtils.isEmpty(O00000Oo2)) {
            ArrayList arrayList2 = new ArrayList();
            try {
                arrayList = (ArrayList) new Gson().fromJson(O00000Oo2, new TypeToken<ArrayList<DomainModel>>() {
                    /* class _m_j.caq.AnonymousClass8 */
                }.getType());
            } catch (Exception unused) {
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    DomainModel domainModel = (DomainModel) it.next();
                    if (cad.f13513O000000o.endsWith(domainModel.local)) {
                        if (System.currentTimeMillis() >= domainModel.launchTime) {
                            if (!TextUtils.isEmpty(domainModel.sid)) {
                                bxs.O000000o.f13388O000000o = domainModel.sid;
                            }
                            if (!TextUtils.isEmpty(domainModel.cookieDomain)) {
                                cav.O0000oO = domainModel.cookieDomain;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public final void O000000o(int i) {
        if (BaseActivity.unpaidNum != i) {
            BaseActivity.unpaidNum = i;
            cbm.O00000o0.O00000Oo(getContext(), "pref_key_unpaid_number", i);
        }
        O00000o0(i);
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo(final int i) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                /* class _m_j.caq.AnonymousClass11 */

                public final void run() {
                    if (i <= 0 || caq.this.O0000O0o.getVisibility() != 0) {
                        caq.this.O0000o0O.hide();
                        return;
                    }
                    caq.this.O0000o0O.show();
                    caq.this.O0000o0O.setCount(i);
                    caq.this.O0000o0O.invalidate();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void O00000o0(final int i) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                /* class _m_j.caq.AnonymousClass13 */

                public final void run() {
                    if (i <= 0 || caq.this.O00000oo.getVisibility() != 0) {
                        caq.this.O0000o0o.hide();
                        return;
                    }
                    caq.this.O0000o0o.show();
                    caq.this.O0000o0o.setCount(i);
                    caq.this.O0000o0o.invalidate();
                }
            });
        }
    }

    private void O00000o(int i) {
        ccr.O00000Oo(f13532O000000o, "update cart:".concat(String.valueOf(i)));
        if (BaseActivity.shoppingCartNum != i) {
            BaseActivity.shoppingCartNum = i;
            cbm.O00000o0.O00000Oo(getContext(), "pref_key_shoppingcart_number", i);
        }
        O00000Oo(i);
    }

    private boolean O0000Oo() {
        boolean z;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(getContext(), "pref_key_home_notice_closed_type", "");
        long O000000o2 = cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_time");
        if (O000000o2 != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            if (simpleDateFormat.format(Long.valueOf(currentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(O000000o2)))) {
                z = true;
                return z || TextUtils.isEmpty(O00000Oo2) || !O00000Oo2.equals("1");
            }
        }
        z = false;
        if (z) {
        }
    }

    public final void O000000o(NewNoticeData newNoticeData) {
        if (newNoticeData != null && !TextUtils.isEmpty(newNoticeData.content)) {
            this.O0000o0 = newNoticeData;
            if (O0000Oo()) {
                O00000Oo(newNoticeData);
            }
        }
    }

    public final void O00000Oo(NewNoticeData newNoticeData) {
        if (this.O00oOooO != null) {
            if (newNoticeData == null || TextUtils.isEmpty(newNoticeData.content)) {
                this.O00oOooO.setVisibility(8);
            } else if ("0".equalsIgnoreCase(newNoticeData.type)) {
                this.O00oOooO.setVisibility(8);
            } else if ("2".equals(newNoticeData.type)) {
                this.O00oOooO.setVisibility(8);
            } else {
                ccr.O00000Oo(f13532O000000o, "noticeShow:".concat(String.valueOf(newNoticeData)));
                this.O000O00o.setText(newNoticeData.content);
                this.O00oOooO.setOnClickListener(this);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O00oOooO.getLayoutParams();
                layoutParams.topMargin = BaseActivity.statusBarHeight + cdy.O000000o(40.0f);
                this.O00oOooO.setLayoutParams(layoutParams);
                this.O00oOooO.setVisibility(0);
            }
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 0) {
            if (!ccn.O0000o00().O0000o0O()) {
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    this.O000O0o0.gotoAccount();
                } else {
                    byl.O00000o0();
                }
            } else {
                return;
            }
        }
        byl.O0000Oo().onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        NewNoticeData newNoticeData;
        int id = view.getId();
        if (id == R.id.notice_close) {
            this.O00oOooO.setVisibility(8);
            NewNoticeData newNoticeData2 = this.O0000o0;
            if (newNoticeData2 != null && !TextUtils.isEmpty(newNoticeData2.type)) {
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_type", this.O0000o0.type);
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_time", Long.valueOf(System.currentTimeMillis()));
            }
        } else if (id == R.id.noticeboard && (newNoticeData = this.O0000o0) != null && !TextUtils.isEmpty(newNoticeData.content)) {
            if ("2".equalsIgnoreCase(this.O0000o0.type) && ccn.O0000o00().O00000oo()) {
                if (cad.O00000o()) {
                    Intent intent = new Intent(getActivity(), OrderListAcitvity.class);
                    intent.putExtra("type", 1);
                    startActivity(intent);
                    return;
                }
                String O0000oO02 = cav.O0000oO0();
                Intent intent2 = new Intent(getActivity(), WebActivity.class);
                intent2.putExtra("url", O0000oO02);
                getActivity().startActivity(intent2);
            }
            if ("1".equalsIgnoreCase(this.O0000o0.type) && !TextUtils.isEmpty(this.O0000o0.url)) {
                String str = this.O0000o0.url;
                Intent intent3 = new Intent(getActivity(), WebActivity.class);
                intent3.putExtra("url", str);
                getActivity().startActivity(intent3);
            }
        }
    }

    public final void O00000Oo() {
        Request request;
        if (ccn.O0000o00().O0000o0O() && !TextUtils.isEmpty(ccn.O0000o00().O00000Oo())) {
            Uri.Builder buildUpon = Uri.parse(cav.O000OoOO()).buildUpon();
            buildUpon.appendQueryParameter("mUserId", cei.O000000o(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("cUserId", cei.O00000Oo(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("security", "true");
            AnonymousClass15 r1 = new cak<NewUserInfoResult>() {
                /* class _m_j.caq.AnonymousClass15 */

                public final /* bridge */ /* synthetic */ void O000000o(com.mi.global.shop.newmodel.BaseResult baseResult) {
                    NewUserInfoData newUserInfoData;
                    NewUserInfoResult newUserInfoResult = (NewUserInfoResult) baseResult;
                    if (newUserInfoResult.data != null) {
                        if (newUserInfoResult.data.jsonUserInfoData == null) {
                            newUserInfoData = newUserInfoResult.data;
                        } else {
                            newUserInfoData = newUserInfoResult.data.jsonUserInfoData;
                        }
                        caq.this.O000000o(newUserInfoData.not_pay_order_count);
                    }
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(caq.f13532O000000o, "RefreshUserInfo Exception:".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(buildUpon.toString(), NewUserInfoResult.class, r1);
            } else {
                request = new cal(buildUpon.toString(), NewUserInfoResult.class, r1);
            }
            request.setTag(f13532O000000o);
            ced.f13683O000000o.add(request);
        }
    }

    private void O0000OoO() {
        if (O0000O0o()) {
            Dialog dialog = this.O000O0o;
            if (dialog != null) {
                dialog.show();
                O000000o(true);
                return;
            }
            O0000Ooo();
            this.O000O0o.show();
            O000000o(true);
        }
    }

    public final void O00000o0() {
        Dialog dialog;
        if (O0000O0o() && (dialog = this.O000O0o) != null && dialog.isShowing()) {
            O000000o(false);
            this.O000O0o.dismiss();
        }
    }

    private void O000000o(boolean z) {
        ImageView imageView;
        Dialog dialog = this.O000O0o;
        if (dialog != null && (imageView = (ImageView) dialog.findViewById(R.id.iv_rabbit)) != null) {
            if (z) {
                ((AnimationDrawable) imageView.getDrawable()).start();
            } else {
                ((AnimationDrawable) imageView.getDrawable()).stop();
            }
        }
    }

    private void O0000Ooo() {
        this.O000O0o = new Dialog(getActivity());
        this.O000O0o.setCanceledOnTouchOutside(true);
        this.O000O0o.getWindow().setDimAmount(0.0f);
        this.O000O0o.getWindow().getDecorView().setBackgroundColor(0);
        this.O000O0o.setContentView(((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate((int) R.layout.shop_common_rabbit_loading_dialog, (ViewGroup) null));
    }

    public final boolean O0000O0o() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                if (activity.isFinishing() || activity.isDestroyed()) {
                    return false;
                }
                return true;
            } else if (!activity.isFinishing()) {
                return true;
            }
        }
        return false;
    }

    public void onUserInfoUpdate(String str, String str2, String str3, int i, String str4) {
        O00000o(i);
    }

    public void onLogin(String str, String str2, String str3) {
        O00000Oo();
        if (cad.O0000O0o()) {
            ccn.O0000o00().O0000o0o();
        }
        if (getActivity() != null) {
            WebActivity.setCookies(byl.O00000oO());
        }
        ccn.O0000o00().O0000oOo();
    }

    public void onLogout() {
        O00000o(0);
        O000000o(0);
        cbw.O000000o(getContext());
        cbw.O00000Oo(getContext());
    }
}
