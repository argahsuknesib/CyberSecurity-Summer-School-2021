package com.xiaomi.smarthome.miio.activity;

import _m_j.ee;
import _m_j.fbs;
import _m_j.fbt;
import _m_j.fvm;
import _m_j.gqp;
import _m_j.gwg;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;

public class BleGatewayGuideActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private O00000Oo f9613O000000o;
    public O000000o mFirstFragment;
    @BindView(5157)
    View mFirstIndicator;
    public O00000o0 mSecondFragment;
    @BindView(5677)
    View mSecondIndicator;
    public O00000o mThirdFragment;
    @BindView(5951)
    ViewPager mViewPager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(R.anim.activity_slide_in_bottom, R.anim.activity_slide_out_bottom);
        gwg.O000000o(getWindow());
        setContentView((int) R.layout.activity_bluetooth_gateway_guide_layout);
        ButterKnife.bind(this);
        this.f9613O000000o = new O00000Oo(getSupportFragmentManager());
        this.mViewPager.setAdapter(this.f9613O000000o);
        this.mViewPager.setOffscreenPageLimit(1);
        this.mViewPager.setOnPageChangeListener(new ViewPager.O00000o0() {
            /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.AnonymousClass1 */

            public final void c_(int i) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                AccessibilityManager accessibilityManager = (AccessibilityManager) BleGatewayGuideActivity.this.getSystemService("accessibility");
                if (i == 0) {
                    BleGatewayGuideActivity.this.mFirstIndicator.setVisibility(0);
                    BleGatewayGuideActivity.this.mSecondIndicator.setVisibility(8);
                    obtain.setEventType(16384);
                    obtain.getText().add(BleGatewayGuideActivity.this.getResources().getStringArray(R.array.ble_guide_content_description)[0]);
                    if (BleGatewayGuideActivity.this.mFirstFragment.f9615O000000o != null) {
                        BleGatewayGuideActivity.this.mFirstFragment.f9615O000000o.requestFocus();
                    }
                } else if (i == 1) {
                    BleGatewayGuideActivity.this.mFirstIndicator.setVisibility(8);
                    BleGatewayGuideActivity.this.mSecondIndicator.setVisibility(0);
                    obtain.setEventType(16384);
                    obtain.getText().add(BleGatewayGuideActivity.this.getResources().getStringArray(R.array.ble_guide_content_description)[1]);
                    if (BleGatewayGuideActivity.this.mSecondFragment.f9624O000000o != null) {
                        BleGatewayGuideActivity.this.mSecondFragment.f9624O000000o.requestFocus();
                    }
                } else {
                    BleGatewayGuideActivity.this.mFirstIndicator.setVisibility(8);
                    BleGatewayGuideActivity.this.mSecondIndicator.setVisibility(8);
                    obtain.setEventType(16384);
                    obtain.getText().add(BleGatewayGuideActivity.this.getResources().getStringArray(R.array.ble_guide_content_description)[2]);
                    if (BleGatewayGuideActivity.this.mThirdFragment.f9619O000000o != null) {
                        BleGatewayGuideActivity.this.mThirdFragment.f9619O000000o.requestFocus();
                    }
                }
                try {
                    accessibilityManager.sendAccessibilityEvent(obtain);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public final void b_(int i) {
                if (i != 0) {
                    if (i == 1) {
                        O000000o o000000o = BleGatewayGuideActivity.this.mFirstFragment;
                        if (!(o000000o.O00000Oo == null || o000000o.O00000o0 == null)) {
                            o000000o.O00000Oo.cancelAnimation();
                            o000000o.O00000o0.cancel();
                        }
                        O00000o0 o00000o0 = BleGatewayGuideActivity.this.mSecondFragment;
                        if (!(o00000o0.O00000Oo == null || o00000o0.O00000o0 == null)) {
                            o00000o0.O00000Oo.cancelAnimation();
                            o00000o0.O00000o0.cancel();
                        }
                        O00000o o00000o = BleGatewayGuideActivity.this.mThirdFragment;
                        if (o00000o.O00000o0 != null && o00000o.O00000o != null) {
                            o00000o.O00000o0.cancelAnimation();
                            o00000o.O00000o.cancel();
                        }
                    }
                } else if (BleGatewayGuideActivity.this.mViewPager.getCurrentItem() == 0) {
                    O000000o o000000o2 = BleGatewayGuideActivity.this.mFirstFragment;
                    if (o000000o2.O00000Oo != null && o000000o2.O00000o0 != null) {
                        o000000o2.O00000o0.start();
                    }
                } else if (BleGatewayGuideActivity.this.mViewPager.getCurrentItem() == 1) {
                    O00000o0 o00000o02 = BleGatewayGuideActivity.this.mSecondFragment;
                    if (o00000o02.O00000Oo != null && o00000o02.O00000o0 != null) {
                        o00000o02.O00000o0.start();
                    }
                } else {
                    O00000o o00000o2 = BleGatewayGuideActivity.this.mThirdFragment;
                    if (o00000o2.O00000o0 != null && o00000o2.O00000o != null) {
                        o00000o2.O00000o.start();
                    }
                }
            }
        });
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_slide_in_bottom, R.anim.activity_slide_out_bottom);
    }

    class O00000Oo extends gqp {
        private List<fvm> O00000o = new ArrayList();

        public O00000Oo(ee eeVar) {
            super(eeVar);
            BleGatewayGuideActivity.this.mFirstFragment = new O000000o();
            BleGatewayGuideActivity.this.mSecondFragment = new O00000o0();
            BleGatewayGuideActivity.this.mThirdFragment = new O00000o();
            this.O00000o.add(BleGatewayGuideActivity.this.mFirstFragment);
            this.O00000o.add(BleGatewayGuideActivity.this.mSecondFragment);
            this.O00000o.add(BleGatewayGuideActivity.this.mThirdFragment);
        }

        public final int O000000o() {
            return this.O00000o.size();
        }

        public final Fragment O000000o(int i) {
            if (i < 0 || i >= this.O00000o.size()) {
                return null;
            }
            return this.O00000o.get(i);
        }
    }

    public static class O000000o extends fvm {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f9615O000000o;
        public LottieAnimationView O00000Oo;
        public ValueAnimator O00000o0;

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (this.f9615O000000o == null) {
                this.f9615O000000o = layoutInflater.inflate((int) R.layout.ble_gateway_guide_first_fragment_layout, (ViewGroup) null);
                this.O00000Oo = (LottieAnimationView) this.f9615O000000o.findViewById(R.id.lottie_view_1);
                LottieComposition.Factory.fromAssetFileName(getContext(), "ble_gateway_guide/first_lottie/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O000000o.AnonymousClass1 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        O000000o.this.O00000Oo.setComposition(lottieComposition);
                        O000000o.this.O00000Oo.setImageAssetsFolder("ble_gateway_guide/first_lottie/images");
                        O000000o.this.O00000o0 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(3500L);
                        O000000o.this.O00000o0.setRepeatCount(-1);
                        O000000o.this.O00000o0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O000000o.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (O000000o.this.O00000Oo != null) {
                                    O000000o.this.O00000Oo.setProgress(((Float) O000000o.this.O00000o0.getAnimatedValue()).floatValue());
                                }
                            }
                        });
                        O000000o.this.O00000o0.start();
                    }
                });
            }
            return this.f9615O000000o;
        }

        public final void onDestroyView() {
            LottieAnimationView lottieAnimationView = this.O00000Oo;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
                this.O00000Oo = null;
            }
            ValueAnimator valueAnimator = this.O00000o0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.O00000o0 = null;
            }
            super.onDestroyView();
        }
    }

    public static class O00000o0 extends fvm {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f9624O000000o;
        public LottieAnimationView O00000Oo;
        public ValueAnimator O00000o0;

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (this.f9624O000000o == null) {
                this.f9624O000000o = layoutInflater.inflate((int) R.layout.ble_gateway_guide_second_fragment_layout, (ViewGroup) null);
                this.O00000Oo = (LottieAnimationView) this.f9624O000000o.findViewById(R.id.lottie_view_2);
                LottieComposition.Factory.fromAssetFileName(getContext(), "ble_gateway_guide/second_lottie/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o0.AnonymousClass1 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        O00000o0.this.O00000Oo.setComposition(lottieComposition);
                        O00000o0.this.O00000Oo.setImageAssetsFolder("ble_gateway_guide/second_lottie/images");
                        O00000o0.this.O00000o0 = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(3450L);
                        O00000o0.this.O00000o0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o0.AnonymousClass1.AnonymousClass1 */

                            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (O00000o0.this.O00000Oo != null) {
                                    O00000o0.this.O00000Oo.setProgress(((Float) O00000o0.this.O00000o0.getAnimatedValue()).floatValue());
                                }
                            }
                        });
                    }
                });
            }
            return this.f9624O000000o;
        }

        public final void onDestroyView() {
            LottieAnimationView lottieAnimationView = this.O00000Oo;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
                this.O00000Oo = null;
            }
            ValueAnimator valueAnimator = this.O00000o0;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.O00000o0 = null;
            }
            super.onDestroyView();
        }
    }

    public static class O00000o extends fvm {

        /* renamed from: O000000o  reason: collision with root package name */
        public View f9619O000000o;
        public View O00000Oo;
        public ValueAnimator O00000o;
        public LottieAnimationView O00000o0;

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            if (this.f9619O000000o == null) {
                this.f9619O000000o = layoutInflater.inflate((int) R.layout.ble_gateway_guide_third_fragment_layout, (ViewGroup) null);
                this.O00000Oo = this.f9619O000000o.findViewById(R.id.about_ble_gateway);
                this.O00000Oo.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o.AnonymousClass1 */

                    public final void onClick(View view) {
                        O00000o.this.O00000Oo.setEnabled(false);
                        fbt fbt = new fbt(view.getContext(), "/userCenter/FeedbackCommonProblemActivity");
                        fbt.O000000o("extra_model", "blegateway");
                        fbs.O000000o(fbt);
                    }
                });
                this.f9619O000000o.findViewById(R.id.immediate_experience).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o.AnonymousClass2 */

                    public final void onClick(View view) {
                        FragmentActivity activity = O00000o.this.getActivity();
                        if (activity != null && !activity.isFinishing()) {
                            activity.finish();
                        }
                    }
                });
                this.O00000o0 = (LottieAnimationView) this.f9619O000000o.findViewById(R.id.lottie_view_3);
                LottieComposition.Factory.fromAssetFileName(getContext(), "ble_gateway_guide/third_lottie/data.json", new OnCompositionLoadedListener() {
                    /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o.AnonymousClass3 */

                    public final void onCompositionLoaded(LottieComposition lottieComposition) {
                        if (O00000o.this.O00000o0 != null) {
                            O00000o.this.O00000o0.setComposition(lottieComposition);
                            O00000o.this.O00000o0.setImageAssetsFolder("ble_gateway_guide/third_lottie/images");
                            O00000o.this.O00000o = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(3450L);
                            O00000o.this.O00000o.setRepeatCount(-1);
                            O00000o.this.O00000o.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                /* class com.xiaomi.smarthome.miio.activity.BleGatewayGuideActivity.O00000o.AnonymousClass3.AnonymousClass1 */

                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    if (O00000o.this.O00000o0 != null) {
                                        O00000o.this.O00000o0.setProgress(((Float) O00000o.this.O00000o.getAnimatedValue()).floatValue());
                                    }
                                }
                            });
                        }
                    }
                });
            }
            return this.f9619O000000o;
        }

        public final void onResume() {
            super.onResume();
            this.O00000Oo.setEnabled(true);
        }

        public final void onDestroyView() {
            LottieAnimationView lottieAnimationView = this.O00000o0;
            if (lottieAnimationView != null) {
                lottieAnimationView.cancelAnimation();
                this.O00000o0 = null;
            }
            ValueAnimator valueAnimator = this.O00000o;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.O00000o = null;
            }
            super.onDestroyView();
        }
    }
}
