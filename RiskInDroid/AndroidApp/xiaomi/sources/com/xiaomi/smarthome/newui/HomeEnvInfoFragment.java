package com.xiaomi.smarthome.newui;

import _m_j.awq;
import _m_j.axx;
import _m_j.ei;
import _m_j.fh;
import _m_j.fju;
import _m_j.fjv;
import _m_j.fo;
import _m_j.ft;
import _m_j.fvm;
import _m_j.ggb;
import _m_j.gwg;
import _m_j.gzs;
import _m_j.gzy;
import _m_j.gzz;
import _m_j.hag;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.library.common.widget.DevicePtrFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HomeEnvInfoFragment extends fvm {

    /* renamed from: O000000o  reason: collision with root package name */
    protected RecyclerViewExpandableItemManager f10093O000000o;
    protected axx O00000Oo;
    protected LinearLayoutManager O00000o;
    protected RecyclerView.O000000o O00000o0;
    private View O00000oO;
    private gzy O00000oo;
    private String O0000O0o;
    private boolean O0000OOo = false;
    private Unbinder O0000Oo;
    private gzz O0000Oo0;
    private final fjv O0000OoO = new fjv() {
        /* class com.xiaomi.smarthome.newui.HomeEnvInfoFragment.AnonymousClass1 */

        public final void onUnitChange(String str, String str2, String str3) {
            if (HomeEnvInfoFragment.this.O00000o0 != null) {
                HomeEnvInfoFragment.this.O00000o0.notifyDataSetChanged();
            }
        }
    };
    @BindView(5368)
    TextView mEmpty;
    @BindView(5649)
    View mMaskView;
    @BindView(5900)
    DevicePtrFrameLayout mPullRefresh;
    @BindView(5924)
    RecyclerView mRecyclerView;
    @BindView(5706)
    ImageView mReturnImageView;
    @BindView(5710)
    TextView mTitleTv;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        TextView textView;
        super.onResume();
        this.O0000O0o = ggb.O00000Oo().O0000OOo();
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        ggb.O00000Oo();
        String O000000o2 = ggb.O000000o(O0000Oo02);
        if (!(O0000Oo02 == null || TextUtils.isEmpty(O000000o2) || (textView = this.mTitleTv) == null)) {
            textView.setText(O000000o2);
        }
        this.O0000Oo0.O000000o(this.O0000O0o);
    }

    public void onPause() {
        super.onPause();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, androidx.recyclerview.widget.RecyclerView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        fju.O000000o().O000000o(this.O0000OoO);
        if (this.O00000oO == null) {
            this.O00000oO = layoutInflater.inflate((int) R.layout.fragment_home_env_info, (ViewGroup) null);
            this.O0000Oo = ButterKnife.bind(this, this.O00000oO);
            this.mPullRefresh.setPtrHandler(new PtrDefaultHandler() {
                /* class com.xiaomi.smarthome.newui.HomeEnvInfoFragment.AnonymousClass3 */

                public final void onRefreshBegin(PtrFrameLayout ptrFrameLayout) {
                    HomeEnvInfoFragment.this.mPullRefresh.refreshComplete();
                }

                public final boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                    if (HomeEnvInfoFragment.this.mRecyclerView.canScrollVertically(-1)) {
                        return false;
                    }
                    return super.checkCanDoRefresh(ptrFrameLayout, view, view2);
                }
            });
            this.mReturnImageView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoFragment$kYSOqIhn5XyVTE27mE1PKr290 */

                public final void onClick(View view) {
                    HomeEnvInfoFragment.this.O00000Oo(view);
                }
            });
            this.mRecyclerView.setOnScrollListener(new RecyclerView.O00oOooO() {
                /* class com.xiaomi.smarthome.newui.HomeEnvInfoFragment.AnonymousClass2 */

                public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
                    View currentFocus;
                    super.onScrollStateChanged(recyclerView, i);
                    if (i != 0 && HomeEnvInfoFragment.this.isValid() && (currentFocus = HomeEnvInfoFragment.this.getActivity().getCurrentFocus()) != null) {
                        currentFocus.clearFocus();
                    }
                }
            });
            this.f10093O000000o = new RecyclerViewExpandableItemManager();
            this.O00000oo = new gzy(getActivity(), false);
            this.O00000o0 = this.f10093O000000o.O000000o(this.O00000oo);
            this.O00000o = new LinearLayoutManager(getActivity());
            this.O00000o.setAutoMeasureEnabled(true);
            this.O00000o.setSmoothScrollbarEnabled(true);
            awq awq = new awq();
            awq.O0000o00 = false;
            this.mRecyclerView.setLayoutManager(this.O00000o);
            this.mRecyclerView.setAdapter(this.O00000o0);
            this.mRecyclerView.setItemAnimator(awq);
            this.mRecyclerView.setHasFixedSize(true);
            this.O00000Oo = new axx();
            axx axx = this.O00000Oo;
            axx.O0000OOo = true;
            axx.O00000Oo();
            this.O00000Oo.O000000o(this.mRecyclerView);
            this.f10093O000000o.O000000o(this.mRecyclerView);
            this.f10093O000000o.O000000o();
            View inflate = LayoutInflater.from(getActivity()).inflate((int) R.layout.home_env_info_footer, (ViewGroup) this.mRecyclerView, false);
            inflate.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoFragment$vYVmOzBOFC5I8d4IzxyYsugVZxs */

                public final void onClick(View view) {
                    HomeEnvInfoFragment.this.O000000o(view);
                }
            });
            this.O00000oo.O00000o = inflate;
            Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
            ggb.O00000Oo();
            String O000000o2 = ggb.O000000o(O0000Oo02);
            if (O0000Oo02 != null && !TextUtils.isEmpty(O000000o2)) {
                this.mTitleTv.setText(O000000o2);
            }
            this.mEmpty.setVisibility(8);
            gwg.O00000Oo(getActivity().getWindow());
            this.O0000O0o = ggb.O00000Oo().O0000OOo();
            if (getActivity() != null) {
                this.O0000Oo0 = (gzz) fo.O000000o(getActivity()).O000000o(gzz.class);
                this.O0000Oo0.O000000o().observe(this, new fh() {
                    /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoFragment$FYEkarsSbDre8MGAdyphafca6BM */

                    public final void onChanged(Object obj) {
                        HomeEnvInfoFragment.this.O000000o((Map) obj);
                    }
                });
            }
            O00000Oo();
        }
        return this.O00000oO;
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (!this.O0000OOo) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRecyclerView, "translationY", 300.0f, 0.0f);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setDuration(200L);
            ofFloat.start();
            super.onViewCreated(view, bundle);
        }
        this.O0000OOo = true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.O0000OOo = false;
        Unbinder unbinder = this.O0000Oo;
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        final $$Lambda$HomeEnvInfoFragment$CJwu20m5Lgb3nWoK5e3QcZaWGD8 r0 = new Runnable() {
            /* class com.xiaomi.smarthome.newui.$$Lambda$HomeEnvInfoFragment$CJwu20m5Lgb3nWoK5e3QcZaWGD8 */

            public final void run() {
                HomeEnvInfoFragment.this.O000000o();
            }
        };
        hag hag = new hag(0.9f);
        hag.setDuration(360);
        hag.setInterpolator(new LinearInterpolator());
        hag.setAnimationListener(new Animation.AnimationListener() {
            /* class com.xiaomi.smarthome.newui.HomeEnvInfoFragment.AnonymousClass4 */

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                r0.run();
            }
        });
        view.startAnimation(hag);
    }

    /* access modifiers changed from: private */
    public void O000000o() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ei O000000o2 = activity.getSupportFragmentManager().O000000o();
            Fragment O000000o3 = activity.getSupportFragmentManager().O000000o(HomeEnvInfoSettingFragment.class.getSimpleName());
            if (O000000o3 == null) {
                O000000o3 = new HomeEnvInfoSettingFragment();
            }
            if (O000000o3.isAdded()) {
                O000000o2.O00000o0(O000000o3).O00000Oo();
                return;
            }
            O000000o2.O000000o((int) R.anim.fragment_right_in, (int) R.anim.fragment_left_out, (int) R.anim.fragment_left_in, (int) R.anim.fragment_right_out);
            O000000o2.O000000o(R.id.main_activity_view_pager, O000000o3, HomeEnvInfoSettingFragment.class.getSimpleName());
            O000000o2.O000000o((String) null);
            O000000o2.O00000o0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Map map) {
        O00000Oo();
    }

    private void O00000Oo() {
        List<gzz.O000000o> O00000o02 = this.O0000Oo0.O00000o0(this.O0000O0o);
        if (O00000o02 == null || O00000o02.isEmpty()) {
            this.mEmpty.setVisibility(0);
            this.mRecyclerView.setVisibility(8);
            return;
        }
        this.mRecyclerView.setVisibility(0);
        this.mEmpty.setVisibility(8);
        gzy gzy = this.O00000oo;
        gzy.O00000oO = O00000o02;
        gzy.notifyDataSetChanged();
        this.f10093O000000o.O000000o();
    }

    public void onDestroyView() {
        super.onDestroyView();
        fju.O000000o().O00000Oo(this.O0000OoO);
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
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[Catch:{ Exception -> 0x007c }] */
    public boolean onBackPressed() {
        gzs gzs;
        try {
            getActivity().getSupportFragmentManager().O00000o();
            List<Fragment> O00000oo2 = getActivity().getSupportFragmentManager().O00000oo();
            if (O00000oo2 != null) {
                Iterator<Fragment> it = O00000oo2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Fragment next = it.next();
                    if (next instanceof gzs) {
                        gzs = (gzs) next;
                        break;
                    }
                }
                if (gzs != null) {
                    if (gzs.O0000oOO != null && gzs.O0000oOO.getVisibility() == 0) {
                        gzs.O0000oOO.setVisibility(8);
                        ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                            /* class _m_j.gzs.AnonymousClass10 */

                            public final void run() {
                                Home O0000Oo0 = ggb.O00000Oo().O0000Oo0();
                                if (gzs.this.O0000oOO != null && O0000Oo0 != null && O0000Oo0.isOwner()) {
                                    gzs.this.O0000oOO.setVisibility(0);
                                }
                            }
                        }, 300);
                    }
                    View view = this.O00000oO;
                    gzs.getClass();
                    view.postOnAnimationDelayed(new Runnable() {
                        /* class com.xiaomi.smarthome.newui.$$Lambda$s39AO0j9H22usiRdL1IFbShRSNU */

                        public final void run() {
                            gzs.this.O00000oO();
                        }
                    }, 100);
                }
                Intent intent = new Intent("action_env_info_active_receiver");
                intent.putExtra("arg_env_info_active_receiver", false);
                ft.O000000o(getActivity()).O000000o(intent);
                return true;
            }
            gzs = null;
            if (gzs != null) {
            }
            Intent intent2 = new Intent("action_env_info_active_receiver");
            intent2.putExtra("arg_env_info_active_receiver", false);
            ft.O000000o(getActivity()).O000000o(intent2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
