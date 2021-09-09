package com.xiaomi.smarthome.newui.widget.banner;

import _m_j.fa;
import _m_j.fcn;
import _m_j.fh;
import _m_j.fju;
import _m_j.fkv;
import _m_j.fo;
import _m_j.ggb;
import _m_j.gzs;
import _m_j.gzz;
import _m_j.hgu;
import _m_j.hhc;
import _m_j.hxi;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.appbar.AppBarLayoutSpringBehavior;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.newui.HomeEnvInfoFragment;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;

public class CustomBannerHeaderView extends FrameLayout implements AppBarLayoutSpringBehavior.PullToRefreshCallback {

    /* renamed from: O000000o  reason: collision with root package name */
    protected static final String f10336O000000o = "CustomBannerHeaderView";
    protected View O00000Oo;
    public WeakReference<gzs> O00000o;
    protected View O00000o0;
    public int O00000oO = 0;
    private gzz O00000oo;
    private CustomBannerHeaderView O0000O0o;
    private TextView O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private String O0000OoO = "";
    private String O0000Ooo = "";
    private String O0000o00 = "";

    public void onComplete() {
    }

    public void onDrag(int i, boolean z) {
    }

    public void onRefresh() {
    }

    public CustomBannerHeaderView(Context context) {
        super(context);
        O00000o();
    }

    public CustomBannerHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O00000o();
    }

    public CustomBannerHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O00000o();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    private void O00000o() {
        LayoutInflater.from(getContext()).inflate((int) R.layout.customized_banner_header_view, this);
        this.O0000O0o = (CustomBannerHeaderView) findViewById(R.id.custom_header_view);
        this.O00000Oo = findViewById(R.id.header_view_offline);
        this.O0000OOo = (TextView) findViewById(R.id.env_info_temp_tv);
        this.O0000Oo0 = (TextView) findViewById(R.id.env_info_hum_tv);
        this.O0000Oo = (TextView) findViewById(R.id.env_info_aqi_tv);
        this.O00000o0 = findViewById(R.id.banner_content_container);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.banner.CustomBannerHeaderView.AnonymousClass1 */

            public final void onClick(View view) {
                gzs gzs;
                if (CustomBannerHeaderView.this.O00000o != null && (gzs = CustomBannerHeaderView.this.O00000o.get()) != null) {
                    if (!(ggb.O00000Oo().O0000OoO.O00000Oo == null || ggb.O00000Oo().O0000OoO.O00000Oo.size() == 0 || gzs.O00000o || gzs.O0000Oo == null)) {
                        AnimatorSet animatorSet = new AnimatorSet();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(gzs.O0000Ooo, "scaleX", 1.0f, 0.9f);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(gzs.O0000Ooo, "scaleY", 1.0f, 0.9f);
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(gzs.f17283O000000o, "alpha", 1.0f, 0.0f);
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(gzs.O0000OoO, "scaleX", 1.0f, 0.9f);
                        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(gzs.O0000OoO, "scaleY", 1.0f, 0.9f);
                        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(gzs.O0000OoO, "translationY", 0.0f, (((float) gzs.O0000Ooo.getHeight()) * 0.100000024f) / 2.0f);
                        animatorSet.setDuration(100L);
                        animatorSet.setInterpolator(new DecelerateInterpolator());
                        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat6).with(ofFloat4).with(ofFloat5);
                        animatorSet.start();
                        animatorSet.addListener(new AnimatorListenerAdapter() {
                            /* class _m_j.gzs.AnonymousClass9 */

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
                            public final void onAnimationEnd(Animator animator) {
                                if (gzs.this.isValid()) {
                                    ei O000000o2 = gzs.this.getActivity().getSupportFragmentManager().O000000o();
                                    Fragment O000000o3 = gzs.this.getActivity().getSupportFragmentManager().O000000o(HomeEnvInfoFragment.class.getSimpleName());
                                    if (O000000o3 == null) {
                                        O000000o3 = new HomeEnvInfoFragment();
                                    }
                                    if (O000000o3.isAdded()) {
                                        O000000o2.O00000o0(O000000o3).O00000Oo();
                                        return;
                                    }
                                    O000000o2.O000000o((int) R.anim.slide_right_in, (int) R.anim.slide_left_out, (int) R.anim.slide_left_in, (int) R.anim.slide_right_out);
                                    O000000o2.O000000o(R.id.main_activity_view_pager, O000000o3, HomeEnvInfoFragment.class.getSimpleName());
                                    O000000o2.O000000o((String) null);
                                    O000000o2.O00000o0();
                                    Intent intent = new Intent("action_env_info_active_receiver");
                                    intent.putExtra("arg_env_info_active_receiver", true);
                                    ft.O000000o(gzs.this.getActivity()).O000000o(intent);
                                }
                            }
                        });
                    }
                    hxi.O00000o.f952O000000o.O000000o("home_device_state", new Object[0]);
                    hxi.O00000o.f952O000000o.O000000o("h2m.background", "time", Long.valueOf(System.currentTimeMillis()), "uid", fcn.O000000o().O00000Oo(), "type", "1");
                }
            }
        });
    }

    public FragmentActivity getActivity() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof FragmentActivity) {
                return (FragmentActivity) context;
            }
        }
        return null;
    }

    public void setDeviceMainPage(gzs gzs) {
        this.O00000o = new WeakReference<>(gzs);
        this.O00000oo = (gzz) fo.O000000o((FragmentActivity) Objects.requireNonNull(gzs.getActivity())).O000000o(gzz.class);
        this.O00000oo.O00000Oo().observe((fa) Objects.requireNonNull(gzs.getActivity()), new fh() {
            /* class com.xiaomi.smarthome.newui.widget.banner.$$Lambda$CustomBannerHeaderView$xt_1LNzdqzFO_FZXjnuea3n7Kg */

            public final void onChanged(Object obj) {
                CustomBannerHeaderView.this.O000000o((Map) obj);
            }
        });
    }

    public final void O000000o() {
        this.O00000Oo.setVisibility(0);
        this.O00000o0.setVisibility(8);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.widget.banner.CustomBannerHeaderView.AnonymousClass2 */

            public final void onClick(View view) {
                try {
                    CustomBannerHeaderView.this.getContext().startActivity(new Intent("android.settings.SETTINGS"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public final void O00000Oo() {
        this.O00000Oo.setVisibility(8);
        this.O00000o0.setVisibility(8);
    }

    public final void O00000o0() {
        this.O00000Oo.setVisibility(8);
        this.O00000o0.setVisibility(0);
    }

    public void onOffsetChanged(int i) {
        this.O0000O0o.setPadding(0, i, 0, 0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.Object, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.hhc.O000000o(java.lang.Object, double):double
     arg types: [java.lang.String, int]
     candidates:
      _m_j.hhc.O000000o(java.lang.Object, int):int
      _m_j.hhc.O000000o(java.lang.Object, double):double */
    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1 A[Catch:{ Exception -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00fb A[Catch:{ Exception -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0151 A[Catch:{ Exception -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0169 A[Catch:{ Exception -> 0x01ee }] */
    public /* synthetic */ void O000000o(Map map) {
        String str;
        String str2;
        String str3 = "";
        TextView textView = this.O0000OOo;
        if (textView != null) {
            try {
                textView.setVisibility(8);
                this.O0000Oo0.setVisibility(8);
                this.O0000Oo.setVisibility(8);
                this.O0000OoO = str3;
                this.O0000Ooo = str3;
                this.O0000o00 = str3;
                hgu hgu = (hgu) this.O00000oo.O00000Oo().getValue().get(ggb.O00000Oo().O0000OOo());
                if (hgu != null) {
                    if (!TextUtils.isEmpty(hgu.O00000o0)) {
                        String[] stringArray = CommonApplication.getAppContext().getResources().getStringArray(R.array.home_env_info_item_title);
                        int indexOf = gzz.O0000O0o.indexOf("temp");
                        if (indexOf < stringArray.length && indexOf >= 0 && stringArray.length > 0) {
                            Pair<String, fkv<Object, Object>> O00000Oo2 = fju.O000000o().O00000Oo("℃");
                            str = stringArray[indexOf] + ((int) (hhc.O000000o(((fkv) O00000Oo2.second).call(hgu.O00000o0), 0.0d) + 0.5d)) + ((String) O00000Oo2.first);
                            this.O0000OoO = str;
                            if (!TextUtils.isEmpty(hgu.O00000Oo)) {
                                String[] stringArray2 = CommonApplication.getAppContext().getResources().getStringArray(R.array.home_env_info_item_title);
                                int indexOf2 = gzz.O0000O0o.indexOf("hum");
                                if (indexOf2 < stringArray2.length && indexOf2 >= 0 && stringArray2.length > 0) {
                                    Pair<String, fkv<Object, Object>> O00000Oo3 = fju.O000000o().O00000Oo("%");
                                    str2 = stringArray2[indexOf2] + ((int) (hhc.O000000o(((fkv) O00000Oo3.second).call(hgu.O00000Oo), 0.0d) + 0.5d)) + ((String) O00000Oo3.first);
                                    this.O0000Ooo = str2;
                                    if (!TextUtils.isEmpty(hgu.f18924O000000o)) {
                                        String[] stringArray3 = CommonApplication.getAppContext().getResources().getStringArray(R.array.home_env_info_item_title);
                                        int indexOf3 = gzz.O0000O0o.indexOf("pm25");
                                        if (indexOf3 < stringArray3.length && indexOf3 >= 0 && stringArray3.length > 0) {
                                            str3 = stringArray3[indexOf3] + ((int) (hhc.O000000o((Object) hgu.f18924O000000o, 0.0d) + 0.5d));
                                        }
                                    }
                                    this.O0000o00 = str3;
                                    if (TextUtils.isEmpty(this.O0000OoO + this.O0000Ooo + this.O0000o00)) {
                                        this.O0000Oo0.setVisibility(8);
                                        this.O0000Oo.setVisibility(8);
                                        this.O0000OOo.setVisibility(0);
                                        this.O0000OOo.setText((int) R.string.home_env_info_top_desc_empty);
                                        return;
                                    }
                                    if (!TextUtils.isEmpty(this.O0000OoO)) {
                                        this.O0000OOo.setVisibility(0);
                                        if (!TextUtils.isEmpty(this.O0000Ooo) || !TextUtils.isEmpty(this.O0000o00)) {
                                            this.O0000OOo.setText(this.O0000OoO + " | ");
                                        } else {
                                            this.O0000OOo.setText(this.O0000OoO);
                                        }
                                    }
                                    if (!TextUtils.isEmpty(this.O0000Ooo)) {
                                        this.O0000Oo0.setVisibility(0);
                                        if (TextUtils.isEmpty(this.O0000o00)) {
                                            this.O0000Oo0.setText(this.O0000Ooo);
                                        } else {
                                            this.O0000Oo0.setText(this.O0000Ooo + " | ");
                                        }
                                    }
                                    if (!TextUtils.isEmpty(this.O0000o00)) {
                                        this.O0000Oo.setVisibility(0);
                                        this.O0000Oo.setText(this.O0000o00);
                                        return;
                                    }
                                    return;
                                }
                            }
                            str2 = str3;
                            this.O0000Ooo = str2;
                            if (!TextUtils.isEmpty(hgu.f18924O000000o)) {
                            }
                            this.O0000o00 = str3;
                            if (TextUtils.isEmpty(this.O0000OoO + this.O0000Ooo + this.O0000o00)) {
                            }
                        }
                    }
                    str = str3;
                    this.O0000OoO = str;
                    if (!TextUtils.isEmpty(hgu.O00000Oo)) {
                    }
                    str2 = str3;
                    this.O0000Ooo = str2;
                    if (!TextUtils.isEmpty(hgu.f18924O000000o)) {
                    }
                    this.O0000o00 = str3;
                    if (TextUtils.isEmpty(this.O0000OoO + this.O0000Ooo + this.O0000o00)) {
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
