package com.xiaomi.smarthome.auth.bindaccount;

import _m_j.chl;
import _m_j.chm;
import _m_j.cho;
import _m_j.fal;
import _m_j.fam;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gqg;
import _m_j.hjm;
import _m_j.hjo;
import _m_j.hju;
import _m_j.hjv;
import _m_j.hlr;
import _m_j.hxg;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxr;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.mibigkoo.convenientbanner.ConvenientBanner;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity;
import com.xiaomi.smarthome.auth.bindaccount.model.ThirdAccount;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import com.xiaomi.smarthome.operation.view.OperationImageView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.indicator.PtrIndicator;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.List;

public class ThirdAccountGroupListActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f4310O000000o;
    private TextView O00000Oo;
    private O00000Oo O00000o;
    private ListView O00000o0;
    private fam O00000oO;
    private TextView O00000oo;
    public DevicePtrFrameLayout mPullRefresh;
    public final hlr<List<hjv>> operationProvider = hjm.O00000o0();

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_third_account_list_layout);
        this.f4310O000000o = findViewById(R.id.container);
        this.mPullRefresh = (DevicePtrFrameLayout) findViewById(R.id.pull_down_refresh);
        this.mPullRefresh.disableWhenHorizontalMove(true);
        this.mPullRefresh.setPullToRefresh(false);
        this.mPullRefresh.setPtrIndicator(new PtrIndicator());
        this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity.AnonymousClass1 */

            public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                ThirdAccountGroupListActivity.this.startRefresh();
            }
        });
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_right_text_btn);
        this.O00000Oo.setText((int) R.string.add_btn_text);
        this.O00000Oo.setVisibility(8);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$neJUC4YRsct6HGb2Nsn6RfQJh8 */

            public final void onClick(View view) {
                ThirdAccountGroupListActivity.this.O00000o0(view);
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.other_platform_device);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$_el1aTrjZz_5Aql7uurgNaEus9g */

            public final void onClick(View view) {
                ThirdAccountGroupListActivity.this.O00000Oo(view);
            }
        });
        this.O00000oo = (TextView) findViewById(R.id.add_btn);
        this.O00000oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$b2QMw1OzxR3Sl1PnUgyD9GVIe0w */

            public final void onClick(View view) {
                ThirdAccountGroupListActivity.this.O000000o(view);
            }
        });
        this.O00000oO = new fam(new int[]{R.id.empty_icon, R.id.no_devices_is_added_yet, R.id.control_by_xiaoai_after_binding, R.id.add_btn});
        this.O00000oO.O000000o(this.f4310O000000o, 0);
        this.O00000o0 = (ListView) findViewById(R.id.recycler_view);
        this.O00000o = new O00000Oo(this, (byte) 0);
        this.O00000o0.setAdapter((ListAdapter) this.O00000o);
        if (this.O00000o0.findViewById(R.id.footer) == null) {
            this.O00000o0.addFooterView(getLayoutInflater().inflate((int) R.layout.activity_third_account_list_layout_banner_footer, (ViewGroup) this.O00000o0, false));
        }
        updateView();
        if (this.operationProvider.O000000o()) {
            O000000o(this.operationProvider.O00000Oo());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        startActivity(new Intent(getContext(), ThirdGroupAccountsListActivity.class));
        hxi.O00000o.O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        startActivity(new Intent(getContext(), ThirdGroupAccountsListActivity.class));
        hxi.O00000o.O000000o();
    }

    public void onResume() {
        super.onResume();
        startRefresh();
    }

    public void onPause() {
        super.onPause();
    }

    public void startRefresh() {
        fal.getInstance().O00000Oo(new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
                if (ThirdAccountGroupListActivity.this.isValid()) {
                    gqg.O00000Oo((int) R.string.loading_failed);
                    ThirdAccountGroupListActivity.this.mPullRefresh.refreshComplete();
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                if (ThirdAccountGroupListActivity.this.isValid()) {
                    ThirdAccountGroupListActivity.this.updateView();
                    ThirdAccountGroupListActivity.this.mPullRefresh.refreshComplete();
                }
            }
        });
    }

    public void updateView() {
        ArrayList arrayList;
        fal instance = fal.getInstance();
        if (instance.O00000Oo == null || instance.O00000Oo.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (int i = 0; i < instance.O00000Oo.size(); i++) {
                ThirdAccount thirdAccount = instance.O00000Oo.get(i);
                if (!(thirdAccount == null || thirdAccount.O00000oo == -1)) {
                    arrayList.add(thirdAccount);
                }
            }
        }
        if (arrayList == null || arrayList.size() <= 0) {
            this.O00000oO.O000000o(this.f4310O000000o, 0);
            this.O00000o0.setVisibility(8);
            this.O00000Oo.setVisibility(8);
            this.O00000oo.setVisibility(0);
        } else {
            this.O00000oO.O000000o(this.f4310O000000o, 8);
            this.O00000o0.setVisibility(0);
            this.O00000Oo.setVisibility(0);
            this.O00000oo.setVisibility(4);
            O00000Oo o00000Oo = this.O00000o;
            o00000Oo.f4315O000000o.clear();
            if (arrayList != null) {
                o00000Oo.f4315O000000o.addAll(arrayList);
            }
            o00000Oo.notifyDataSetChanged();
        }
        this.mPullRefresh.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$krODzbUCTOzJkkk3TVRrAG5vkXQ */

            public final void run() {
                ThirdAccountGroupListActivity.this.O00000Oo();
            }
        }, 500);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void
     arg types: [com.xiaomi.smarthome.auth.bindaccount.-$$Lambda$ThirdAccountGroupListActivity$HzH4CNZ8TmKedq-DXAG7-J7VKyo, int]
     candidates:
      _m_j.hlr.O000000o(java.lang.String, com.facebook.drawee.view.SimpleDraweeView):void
      _m_j.hlr.O000000o(io.reactivex.functions.Consumer<java.util.List<_m_j.hju>>, boolean):void */
    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo() {
        if (isValid()) {
            this.operationProvider.O000000o((Consumer<List<hju>>) new Consumer() {
                /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$HzH4CNZ8TmKedqDXAG7J7VKyo */

                public final void accept(Object obj) {
                    ThirdAccountGroupListActivity.this.O000000o((List) obj);
                }
            }, false);
        }
    }

    /* access modifiers changed from: private */
    public void O000000o(final List<hjv> list) {
        ConvenientBanner convenientBanner;
        if (list != null && !list.isEmpty() && (convenientBanner = (ConvenientBanner) findViewById(R.id.op_banner)) != null) {
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition((ViewGroup) getWindow().getDecorView());
            }
            convenientBanner.setVisibility(0);
            if (convenientBanner.getViewPager() == null || convenientBanner.getViewPager().getAdapter() == null) {
                convenientBanner.O000000o(new chl() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$1m7eJh8p8mRL1KLo_tDZNV6Iduw */

                    public final Object createHolder() {
                        return ThirdAccountGroupListActivity.this.O000000o();
                    }
                }, list).O000000o(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL).O000000o(new int[]{R.drawable.dot_indicator_unselected, R.drawable.dot_indicator_selected}).O000000o(new cho(list) {
                    /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$iyqXrV3sKCmwrS3WCSxMa1Yx4 */
                    private final /* synthetic */ List f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onItemClick(int i) {
                        ThirdAccountGroupListActivity.O000000o(this.f$0, i);
                    }
                }).O000000o(2500);
                convenientBanner.O000000o(new ViewPager.O0000O0o() {
                    /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity.AnonymousClass3 */

                    public final void onPageScrollStateChanged(int i) {
                    }

                    public final void onPageScrolled(int i, float f, int i2) {
                    }

                    public final void onPageSelected(int i) {
                        try {
                            if (!ThirdAccountGroupListActivity.this.mIsPaused) {
                                hjv hjv = (hjv) list.get(i);
                                hxi.O0000o00.O00000Oo(hjv.O00000o0, hjv.O00000oo, hjv.O00000Oo, hjv.O0000O0o, i);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } else {
                convenientBanner.O000000o();
            }
            if (list.size() == 1) {
                convenientBanner.setCanLoop(false);
                convenientBanner.O000000o(new int[]{R.drawable.dot_indicator_transparent, R.drawable.dot_indicator_transparent});
            } else {
                convenientBanner.setCanLoop(true);
                convenientBanner.O000000o(new int[]{R.drawable.dot_indicator_unselected, R.drawable.dot_indicator_selected});
            }
            try {
                int currentItem = convenientBanner.getCurrentItem();
                if (currentItem >= 0) {
                    hjv hjv = list.get(currentItem);
                    hxi.O0000o00.O00000Oo(hjv.O00000o0, hjv.O00000oo, hjv.O00000Oo, hjv.O0000O0o, currentItem);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object O000000o() {
        return new O000000o(this, (byte) 0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void O000000o(List list, int i) {
        hjv hjv = (hjv) list.get(i);
        hjo.O000000o(4, hjv.O00000o0, hjv.O00000Oo);
        hjv hjv2 = (hjv) list.get(i);
        hxk hxk = hxi.O00000o;
        String str = hjv2.O00000o0;
        String str2 = hjv2.O00000oo;
        String str3 = hjv2.O00000Oo;
        String str4 = hjv2.O0000O0o;
        hxk.f952O000000o.O000000o("profile_opd_ad_click", "link", str, "asset_id", str2, "asset_name", str3, "exp_id", str4, hxg.f948O000000o, Integer.valueOf(i));
    }

    class O000000o implements chm<hjv> {
        private OperationImageView O00000Oo;

        private O000000o() {
        }

        /* synthetic */ O000000o(ThirdAccountGroupListActivity thirdAccountGroupListActivity, byte b) {
            this();
        }

        public final /* synthetic */ void O000000o(Context context, int i, Object obj) {
            hjv hjv = (hjv) obj;
            ThirdAccountGroupListActivity.this.operationProvider.O000000o(hjv.f19004O000000o, this.O00000Oo);
            this.O00000Oo.registerOnVisibleToUser(new OperationImageView.O000000o() {
                /* class com.xiaomi.smarthome.auth.bindaccount.$$Lambda$ThirdAccountGroupListActivity$O000000o$kjkAHfYzFQQvKk7p9jHFL70Xzl0 */

                public final void onVisible(View view) {
                    ThirdAccountGroupListActivity.O000000o.O000000o(hjv.this, view);
                }
            });
        }

        public final View O000000o(Context context, ViewGroup viewGroup) {
            this.O00000Oo = new OperationImageView(context);
            this.O00000Oo.setScaleType(ImageView.ScaleType.FIT_XY);
            return this.O00000Oo;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void O000000o(hjv hjv, View view) {
            hxr hxr = hxi.O00000oO;
            String str = hjv.O00000o0;
            hxr.f958O000000o.O000000o("profile_opd_ad_popup", "url", str);
        }
    }

    class O00000Oo extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        final List<ThirdAccount> f4315O000000o;

        public final long getItemId(int i) {
            return (long) i;
        }

        private O00000Oo() {
            this.f4315O000000o = new ArrayList();
        }

        /* synthetic */ O00000Oo(ThirdAccountGroupListActivity thirdAccountGroupListActivity, byte b) {
            this();
        }

        public final Object getItem(int i) {
            return this.f4315O000000o.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(ThirdAccountGroupListActivity.this.getContext()).inflate((int) R.layout.third_account_item_layout, viewGroup, false);
            }
            final ThirdAccount thirdAccount = this.f4315O000000o.get(i);
            ((TextView) view.findViewById(R.id.title)).setText(thirdAccount.f4322O000000o);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.auth.bindaccount.ThirdAccountGroupListActivity.O00000Oo.AnonymousClass1 */

                public final void onClick(View view) {
                    Intent intent = new Intent(ThirdAccountGroupListActivity.this.getContext(), ThirdAccountDeviceListActivity.class);
                    intent.putExtra("account_id", thirdAccount.O00000Oo);
                    ThirdAccountGroupListActivity.this.startActivity(intent);
                }
            });
            view.findViewById(R.id.next_btn).setVisibility(0);
            ((TextView) view.findViewById(R.id.state_tv)).setVisibility(8);
            fal.O000000o((SimpleDraweeView) view.findViewById(R.id.icon), thirdAccount.O00000o0);
            return view;
        }

        public final int getCount() {
            return this.f4315O000000o.size();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.operationProvider.O00000oO();
    }
}
