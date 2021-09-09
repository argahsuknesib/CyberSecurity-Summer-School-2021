package _m_j;

import _m_j.bxs;
import _m_j.caw;
import _m_j.cbi;
import _m_j.cbm;
import _m_j.ccn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.Request;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.account.activity.AccountActivity;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.OrderListAcitvity;
import com.mi.global.shop.activity.ProductActivity;
import com.mi.global.shop.activity.ShoppingCartActivity;
import com.mi.global.shop.activity.WebActivity;
import com.mi.global.shop.adapter.home.HomeListAdapter;
import com.mi.global.shop.loader.BaseResult;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.domain.DomainModel;
import com.mi.global.shop.newmodel.domain.DomainResult;
import com.mi.global.shop.newmodel.home.NewHomeBlockData;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfo;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.mi.global.shop.newmodel.home.NewHomeBlockResult;
import com.mi.global.shop.newmodel.notice.NewNoticeData;
import com.mi.global.shop.newmodel.notice.NewNoticeResult;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoData;
import com.mi.global.shop.newmodel.usercenter.NewUserInfoResult;
import com.mi.global.shop.widget.BadgeView;
import com.mi.global.shop.widget.BaseListView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.EmptyLoadingViewPlus;
import com.mi.global.shop.widget.pulltorefresh.SimplePullToRefreshLayout;
import com.mi.util.Device;
import com.xiaomi.smarthome.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class car extends can implements ccn.O000000o, View.OnClickListener, SimplePullToRefreshLayout.O00000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f13556O000000o = "car";
    public SimplePullToRefreshLayout O00000Oo;
    HomeListAdapter O00000o;
    public EmptyLoadingViewPlus O00000o0;
    public NewNoticeData O00000oO;
    public View O00000oo;
    public View O0000O0o;
    public BadgeView O0000OOo;
    SimpleDraweeView O0000Oo;
    public BadgeView O0000Oo0;
    NewHomeBlockInfoItem O0000OoO;
    private BaseListView O0000Ooo;
    private ImageView O0000o;
    private LinearLayout O0000o0;
    private ImageView O0000o0O;
    private CustomTextView O0000o0o;
    private boolean O0000oO = true;
    private View O0000oO0;
    private AccountActivity O0000oOO;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate((int) R.layout.shop_home_fragment_singleton, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        Request request;
        super.onActivityCreated(bundle);
        O00000o0();
        caz.O000000o(getContext().getApplicationContext(), new cbi.O00000o0() {
            /* class _m_j.car.AnonymousClass1 */

            public final void O000000o(NewNoticeData newNoticeData) {
                car.this.O000000o(newNoticeData);
            }
        });
        if (byl.O0000Oo0) {
            FragmentActivity activity = getActivity();
            final Context applicationContext = activity.getApplication().getApplicationContext();
            cem.O000000o(activity, new cen() {
                /* class _m_j.car.AnonymousClass5 */

                public final void O00000Oo() {
                }

                public final void O00000o0() {
                    car.O000000o(applicationContext);
                }
            }, "android.permission.READ_PHONE_STATE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
        }
        cbc.O000000o(getActivity());
        if (!TextUtils.isEmpty(cbc.O00000Oo())) {
            cbe.O000000o("locationEvent", f13556O000000o, "location", "location", cbc.O00000Oo());
        }
        ccn.O0000o00().O000000o(this);
        Uri.Builder buildUpon = Uri.parse(cav.O000Oo0()).buildUpon();
        AnonymousClass6 r0 = new cak<DomainResult>() {
            /* class _m_j.car.AnonymousClass6 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                DomainResult domainResult = (DomainResult) baseResult;
                if (domainResult.domainModels.size() > 0) {
                    cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, new Gson().toJson(domainResult.domainModels));
                    car.this.O000000o();
                    cav.O00000Oo();
                    return;
                }
                cbm.O00000o0.O000000o(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
            }

            public final void O000000o(String str) {
                ccr.O00000Oo(car.f13556O000000o, "getDomain Exception:".concat(String.valueOf(str)));
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), DomainResult.class, r0);
        } else {
            request = new cal(buildUpon.toString(), DomainResult.class, r0);
        }
        request.setTag(f13556O000000o);
        ced.f13683O000000o.add(request);
        O000000o();
    }

    public final void O000000o() {
        ArrayList arrayList;
        String O00000Oo2 = cbm.O00000o0.O00000Oo(byl.O00000oO(), caw.O00000o0.f13573O000000o, "[\n{\nlocal: \"in\",\nsid: \"i18n_in_mo_pro\",\ndns: [\n{\nhostname: \"//in-push.buy.mi.com\",\noldHostname: \"//push.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.store.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//store.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//in-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"ru\",\nsid: \"i18n_ru_mo_pro\",\ndns: [\n{\nhostname: \"//ru.mbuy.mi.com\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.buy.mi.com\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.event.mi.com\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-hd.c.mi.com\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru-go.buy.mi.com\",\noldHostname: \"//go.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//ru.stat.appmifile.com\",\noldHostname: \"//sg.stat.appmifile.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.com\",\nlaunchTime: 1531548915\n},\n{\nlocal: \"id\",\nsid: \"mi_mo_overseaid_new\",\ndns: [\n{\nhostname: \"//mobile.mi.co.id\",\noldHostname: \"//mobile.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//api.buy.mi.co.id\",\noldHostname: \"//sgp-api.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//m.buy.mi.co.id\",\noldHostname: \"//m.buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//www.mi.co.id\",\noldHostname: \"//www.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//buy.mi.co.id\",\noldHostname: \"//buy.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//event.mi.co.id\",\noldHostname: \"//event.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//staging.api.id.mipay.com\",\noldHostname: \"//staging.api.idp.intl.xiaomi.com\",\nips: [ ],\nttl: 0,\nenable: true\n},\n{\nhostname: \"//hd.mi.co.id\",\noldHostname: \"//hd.c.mi.com\",\nips: [ ],\nttl: 0,\nenable: true\n}\n],\ncookieDomain: \"mi.co.id\",\nlaunchTime: 1531548915\n}\n]");
        if (!TextUtils.isEmpty(O00000Oo2)) {
            ArrayList arrayList2 = new ArrayList();
            try {
                arrayList = (ArrayList) new Gson().fromJson(O00000Oo2, new TypeToken<ArrayList<DomainModel>>() {
                    /* class _m_j.car.AnonymousClass7 */
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

    public void onDestroyView() {
        super.onDestroyView();
        ccn.O0000o00().O00000Oo(this);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cdy.O000000o(android.app.Activity, float):int
     arg types: [androidx.fragment.app.FragmentActivity, int]
     candidates:
      _m_j.cdy.O000000o(android.content.Context, float):int
      _m_j.cdy.O000000o(android.app.Activity, float):int */
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.O00000Oo = (SimplePullToRefreshLayout) view.findViewById(R.id.home_fragment_ptr);
        this.O00000Oo.setOnRefreshListener(new SimplePullToRefreshLayout.O00000o() {
            /* class _m_j.car.AnonymousClass8 */

            public final void onRefresh() {
                car.this.onRefresh();
                car.this.O00000Oo.O000000o();
            }
        });
        this.O0000Oo = (SimpleDraweeView) view.findViewById(R.id.activity_entrance);
        this.O0000Oo.setOnClickListener(this);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.O0000Oo.getLayoutParams();
        layoutParams.leftMargin = (Device.f5099O000000o * 4) / 5;
        layoutParams.topMargin = (Device.O00000Oo * 2) / 5;
        this.O0000Oo.setLayoutParams(layoutParams);
        this.O0000oO0 = view.findViewById(R.id.toolbar_agent);
        this.O00000o0 = (EmptyLoadingViewPlus) view.findViewById(R.id.loading);
        this.O00000o0.setPullToRefreshLayout(this.O00000Oo);
        this.O0000o0 = (LinearLayout) view.findViewById(R.id.noticeboard);
        this.O0000o0o = (CustomTextView) view.findViewById(R.id.notice_text);
        this.O0000o0O = (ImageView) view.findViewById(R.id.notice_close);
        this.O0000o0O.setOnClickListener(this);
        this.O0000o = (ImageView) view.findViewById(R.id.iv_store_title);
        this.O0000o.setVisibility(0);
        this.O0000Ooo = (BaseListView) view.findViewById(16908298);
        this.O00000o = new HomeListAdapter(getContext());
        this.O0000Ooo.setAdapter((ListAdapter) this.O00000o);
        NewNoticeData newNoticeData = this.O00000oO;
        if (newNoticeData != null) {
            O000000o(newNoticeData);
        }
        this.O00000oo = view.findViewById(R.id.iv_order_list);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.car.AnonymousClass9 */

            public final void onClick(View view) {
                car car = car.this;
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    if (cad.O00000o()) {
                        if (ccn.O0000o00().O0000o0O()) {
                            Intent intent = new Intent(car.getContext(), OrderListAcitvity.class);
                            intent.putExtra("type", 0);
                            car.startActivityForResult(intent, 1);
                            return;
                        } else if (car.getActivity() != null) {
                            ((AccountActivity) car.getActivity()).gotoAccount();
                        }
                    }
                    if (!cad.O0000OoO() && !cad.O00000oo() && !cad.O00000oO() && !cad.O0000Oo0() && !cad.O0000OOo() && !cad.O0000O0o() && !cad.O0000Oo() && !cad.O0000Ooo()) {
                        return;
                    }
                    if (ccn.O0000o00().O0000o0O()) {
                        String O0000oO = cav.O0000oO();
                        Intent intent2 = new Intent(car.getContext(), WebActivity.class);
                        intent2.putExtra("url", O0000oO);
                        car.startActivity(intent2);
                    } else if (car.getActivity() != null) {
                        ((AccountActivity) car.getActivity()).gotoAccount();
                    }
                } else {
                    if (cad.O00000o()) {
                        if (ccn.O0000o00().O0000o0O()) {
                            Intent intent3 = new Intent(car.getContext(), OrderListAcitvity.class);
                            intent3.putExtra("type", 0);
                            car.startActivityForResult(intent3, 1);
                            return;
                        }
                        byl.O00000o0();
                    }
                    if (!cad.O0000OoO() && !cad.O00000oo() && !cad.O00000oO() && !cad.O0000Oo0() && !cad.O0000OOo() && !cad.O0000O0o() && !cad.O0000Oo() && !cad.O0000Ooo()) {
                        return;
                    }
                    if (ccn.O0000o00().O0000o0O()) {
                        String O0000oO2 = cav.O0000oO();
                        Intent intent4 = new Intent(car.getContext(), WebActivity.class);
                        intent4.putExtra("url", O0000oO2);
                        car.startActivity(intent4);
                        return;
                    }
                    byl.O00000o0();
                }
            }
        });
        this.O00000oo.setVisibility(0);
        this.O0000O0o = view.findViewById(R.id.title_bar_cart_view);
        this.O0000O0o.setOnClickListener(new View.OnClickListener() {
            /* class _m_j.car.AnonymousClass10 */

            public final void onClick(View view) {
                car car = car.this;
                if (cad.O00000o()) {
                    car.startActivityForResult(new Intent(car.getContext(), ShoppingCartActivity.class), 22);
                    return;
                }
                Intent intent = new Intent(car.getContext(), WebActivity.class);
                intent.putExtra("url", cav.O000OOo());
                car.startActivity(intent);
            }
        });
        View view2 = this.O0000oO0;
        int O00000oo2 = super.O00000oo();
        if (O00000oo2 > 0) {
            view2.getLayoutParams().height = O00000oo2;
            view2.requestLayout();
        }
        this.O0000OOo = new BadgeView(getContext(), this.O0000O0o);
        this.O0000OOo.setTextColor(getResources().getColor(17170443));
        this.O0000OOo.setTextSize(2, 10.0f);
        this.O0000OOo.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.O0000OOo.setmBadgePosition(2);
        this.O0000OOo.setBadgeMargin(0, cdy.O000000o((Activity) getActivity(), 5.0f));
        this.O0000Oo0 = new BadgeView(getContext(), this.O00000oo);
        this.O0000Oo0.setTextColor(getResources().getColor(17170443));
        this.O0000Oo0.setTextSize(2, 10.0f);
        this.O0000Oo0.setBadgeBackgroundDrawable(getResources().getDrawable(R.drawable.shop_orangle_inner_solid_circle));
        this.O0000Oo0.setmBadgePosition(2);
        this.O0000Oo0.setBadgeMargin(0, cdy.O000000o((Activity) getActivity(), 5.0f));
        view.findViewById(R.id.fab_product).setOnClickListener(new View.OnClickListener() {
            /* class _m_j.car.AnonymousClass11 */

            public final void onClick(View view) {
                car car = car.this;
                car.startActivity(new Intent(car.getContext(), ProductActivity.class));
            }
        });
    }

    public void onResume() {
        Request request;
        super.onResume();
        if (this.O0000oO) {
            this.O0000oO = false;
        } else if (O00000o()) {
            String O000O0oO = cav.O000O0oO();
            AnonymousClass13 r2 = new cak<NewNoticeResult>() {
                /* class _m_j.car.AnonymousClass13 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    car.this.O00000oO = ((NewNoticeResult) baseResult).data;
                    car car = car.this;
                    car.O00000Oo(car.O00000oO);
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(car.f13556O000000o, "load notice error".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(O000O0oO, NewNoticeResult.class, r2);
            } else {
                request = new cal(O000O0oO, NewNoticeResult.class, r2);
            }
            request.setTag(f13556O000000o);
            ced.f13683O000000o.add(request);
        }
        ccr.O00000Oo(f13556O000000o, "update cart as pref value");
        if (ccn.O0000o00().O0000o0O()) {
            if (BaseActivity.unpaidNum == -1) {
                BaseActivity.unpaidNum = cbm.O00000o0.O000000o(getContext(), "pref_key_unpaid_number", 0);
            }
            O00000o0(BaseActivity.unpaidNum);
        }
        ccr.O00000Oo(f13556O000000o, "update cart as pref value");
        if (BaseActivity.shoppingCartNum == -1) {
            BaseActivity.shoppingCartNum = cbm.O00000o0.O000000o(getContext(), "pref_key_shoppingcart_number", 0);
        }
        O00000Oo(BaseActivity.shoppingCartNum);
        O00000oO();
        getContext();
        cbe.O00000Oo(f13556O000000o);
    }

    public void onPause() {
        super.onPause();
        cbe.O000000o();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onRefresh() {
        ccr.O00000Oo(f13556O000000o, "onRefresh");
        O00000o0();
    }

    private void O00000o0() {
        Request request;
        Uri.Builder buildUpon = Uri.parse(cav.O000Oo0o()).buildUpon();
        buildUpon.appendQueryParameter("phone_model", Device.O00000oO);
        buildUpon.appendQueryParameter("phone_device", Device.O00000oo);
        if (bzw.O000000o()) {
            buildUpon.appendQueryParameter("_network_type", cbf.O000000o());
        }
        buildUpon.appendQueryParameter("name", "pages_index");
        AnonymousClass12 r1 = new cak<NewHomeBlockResult>() {
            /* class _m_j.car.AnonymousClass12 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                NewHomeBlockResult newHomeBlockResult = (NewHomeBlockResult) baseResult;
                if (car.this.O00000o0 != null) {
                    car.this.O00000o0.setVisibility(8);
                }
                car car = car.this;
                NewHomeBlockData newHomeBlockData = newHomeBlockResult.data;
                if (newHomeBlockData != null) {
                    car.O00000o.O000000o(newHomeBlockData);
                }
                car car2 = car.this;
                NewHomeBlockData newHomeBlockData2 = newHomeBlockResult.data;
                if (newHomeBlockData2 != null) {
                    if (newHomeBlockData2.mHEntrance != null && newHomeBlockData2.mHEntrance.size() > 0) {
                        NewHomeBlockInfo newHomeBlockInfo = newHomeBlockData2.mHEntrance.get(0);
                        if (newHomeBlockInfo.mItems != null && newHomeBlockInfo.mItems.size() > 0) {
                            car2.O0000OoO = newHomeBlockInfo.mItems.get(0);
                            if (car2.O0000OoO != null) {
                                if (!"4".equals(car2.O0000OoO.mIconType) || !cbm.O00000o0.O00000Oo(car2.getContext(), "pref_key_home_entrance_viewid", "").equals(car2.O0000OoO.mViewId)) {
                                    car2.O0000Oo.setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setUri(Uri.parse(car2.O0000OoO.getImageUrl())).setAutoPlayAnimations(true)).build());
                                    if (car2.O0000Oo.getVisibility() != 0) {
                                        car2.O0000Oo.setVisibility(0);
                                    }
                                }
                            }
                        }
                    }
                    if (car2.O0000Oo.getVisibility() == 0) {
                        car2.O0000Oo.setVisibility(8);
                    }
                }
                ccr.O00000Oo(car.f13556O000000o, "准备加载首页数据成功");
            }

            public final void O000000o(String str) {
                car car = car.this;
                if (car.O00000o != null && car.O00000o.f4789O000000o.size() != 0) {
                    cec.O000000o(car.getContext(), str, 0);
                } else if (car.O00000o0 != null) {
                    car.O00000o0.O000000o(BaseResult.ResultStatus.NETWROK_ERROR);
                }
                ccr.O00000Oo(car.f13556O000000o, "准备加载首页数据失败 + ".concat(String.valueOf(str)));
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewHomeBlockResult.class, r1);
        } else {
            request = new cal(buildUpon.toString(), NewHomeBlockResult.class, r1);
        }
        String str = f13556O000000o;
        ccr.O00000Oo(str, "准备加载首页数据，url == " + buildUpon.toString());
        request.setTag(f13556O000000o);
        ced.f13683O000000o.add(request);
    }

    private boolean O00000o() {
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
            this.O00000oO = newNoticeData;
            if (O00000o()) {
                O00000Oo(newNoticeData);
            }
        }
    }

    public final void O00000Oo(NewNoticeData newNoticeData) {
        if (this.O0000o0 != null) {
            if (newNoticeData == null || TextUtils.isEmpty(newNoticeData.content)) {
                this.O0000o0.setVisibility(8);
            } else if ("0".equalsIgnoreCase(newNoticeData.type)) {
                this.O0000o0.setVisibility(8);
            } else if ("2".equals(newNoticeData.type)) {
                this.O0000o0.setVisibility(8);
            } else {
                ccr.O00000Oo(f13556O000000o, "noticeShow:".concat(String.valueOf(newNoticeData)));
                this.O0000o0o.setText(newNoticeData.content);
                this.O0000o0.setOnClickListener(this);
                this.O0000o0.setVisibility(0);
            }
        }
    }

    public void onClick(View view) {
        NewNoticeData newNoticeData;
        int id = view.getId();
        if (id == R.id.activity_entrance) {
            if (this.O0000OoO != null) {
                ccd.O000000o(getContext(), this.O0000OoO);
                if ("4".equals(this.O0000OoO.mIconType)) {
                    this.O0000Oo.setVisibility(8);
                    cbm.O00000o0.O000000o(getContext(), "pref_key_home_entrance_viewid", this.O0000OoO.mViewId);
                }
            }
        } else if (id == R.id.notice_close) {
            this.O0000o0.setVisibility(8);
            NewNoticeData newNoticeData2 = this.O00000oO;
            if (newNoticeData2 != null && !TextUtils.isEmpty(newNoticeData2.type)) {
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_type", this.O00000oO.type);
                cbm.O00000o0.O000000o(getContext(), "pref_key_home_notice_closed_time", Long.valueOf(System.currentTimeMillis()));
            }
        } else if (id == R.id.noticeboard && (newNoticeData = this.O00000oO) != null && !TextUtils.isEmpty(newNoticeData.content)) {
            if ("2".equalsIgnoreCase(this.O00000oO.type) && ccn.O0000o00().O0000o0O()) {
                if (cad.O00000o()) {
                    Intent intent = new Intent(getContext(), OrderListAcitvity.class);
                    intent.putExtra("type", 1);
                    startActivity(intent);
                    return;
                }
                String O0000oO02 = cav.O0000oO0();
                Intent intent2 = new Intent(getContext(), WebActivity.class);
                intent2.putExtra("url", O0000oO02);
                startActivity(intent2);
            }
            if ("1".equalsIgnoreCase(this.O00000oO.type) && !TextUtils.isEmpty(this.O00000oO.url)) {
                String str = this.O00000oO.url;
                Intent intent3 = new Intent(getContext(), WebActivity.class);
                intent3.putExtra("url", str);
                startActivity(intent3);
            }
        }
    }

    private void O00000oO() {
        Request request;
        if (ccn.O0000o00().O0000o0O() && !TextUtils.isEmpty(ccn.O0000o00().O00000Oo())) {
            Uri.Builder buildUpon = Uri.parse(cav.O000OoOO()).buildUpon();
            buildUpon.appendQueryParameter("mUserId", cei.O000000o(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("cUserId", cei.O00000Oo(ccn.O0000o00().O00000Oo()));
            buildUpon.appendQueryParameter("security", "true");
            AnonymousClass2 r1 = new cak<NewUserInfoResult>() {
                /* class _m_j.car.AnonymousClass2 */

                public final /* bridge */ /* synthetic */ void O000000o(com.mi.global.shop.newmodel.BaseResult baseResult) {
                    NewUserInfoData newUserInfoData;
                    NewUserInfoResult newUserInfoResult = (NewUserInfoResult) baseResult;
                    if (newUserInfoResult.data != null) {
                        if (newUserInfoResult.data.jsonUserInfoData == null) {
                            newUserInfoData = newUserInfoResult.data;
                        } else {
                            newUserInfoData = newUserInfoResult.data.jsonUserInfoData;
                        }
                        car.this.O000000o(newUserInfoData.not_pay_order_count);
                    }
                }

                public final void O000000o(String str) {
                    ccr.O00000Oo(car.f13556O000000o, "RefreshUserInfo Exception:".concat(String.valueOf(str)));
                }
            };
            if (byl.O0000OoO()) {
                request = new cam(buildUpon.toString(), NewUserInfoResult.class, r1);
            } else {
                request = new cal(buildUpon.toString(), NewUserInfoResult.class, r1);
            }
            request.setTag(f13556O000000o);
            ced.f13683O000000o.add(request);
        }
    }

    public final void O000000o(int i) {
        if (BaseActivity.unpaidNum != i) {
            BaseActivity.unpaidNum = i;
            cbm.O00000o0.O00000Oo(getContext(), "pref_key_unpaid_number", i);
        }
        O00000o0(i);
    }

    private void O00000Oo(final int i) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                /* class _m_j.car.AnonymousClass3 */

                public final void run() {
                    if (i <= 0 || car.this.O0000O0o.getVisibility() != 0) {
                        car.this.O0000OOo.hide();
                        return;
                    }
                    car.this.O0000OOo.show();
                    car.this.O0000OOo.setCount(i);
                    car.this.O0000OOo.invalidate();
                }
            });
        }
    }

    private void O00000o0(final int i) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                /* class _m_j.car.AnonymousClass4 */

                public final void run() {
                    if (i <= 0 || car.this.O00000oo.getVisibility() != 0) {
                        car.this.O0000Oo0.hide();
                        return;
                    }
                    car.this.O0000Oo0.show();
                    car.this.O0000Oo0.setCount(i);
                    car.this.O0000Oo0.invalidate();
                }
            });
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 0) {
            if (!ccn.O0000o00().O0000o0O()) {
                if (byl.O0000O0o.O00000oo.equals("community_sdk")) {
                    this.O0000oOO.gotoAccount();
                } else {
                    byl.O00000o0();
                }
            } else {
                return;
            }
        }
        byl.O0000Oo().onActivityResult(i, i2, intent);
    }

    private void O00000o(int i) {
        ccr.O00000Oo(f13556O000000o, "update cart:".concat(String.valueOf(i)));
        if (BaseActivity.shoppingCartNum != i) {
            BaseActivity.shoppingCartNum = i;
            cbm.O00000o0.O00000Oo(getContext(), "pref_key_shoppingcart_number", i);
        }
        O00000Oo(i);
    }

    public static void O000000o(Context context) {
        boolean O000000o2 = cem.O000000o(context, "android.permission.READ_PHONE_STATE");
        if (O000000o2) {
            Device.O000000o(byl.O00000oO(), O000000o2);
        }
    }

    public void onUserInfoUpdate(String str, String str2, String str3, int i, String str4) {
        O00000o(i);
    }

    public void onLogin(String str, String str2, String str3) {
        O00000oO();
    }

    public void onLogout() {
        O00000o(0);
        O000000o(0);
        cbw.O000000o(getContext());
        cbw.O00000Oo(getContext());
    }

    public static String O00000Oo() {
        return f13556O000000o;
    }
}
