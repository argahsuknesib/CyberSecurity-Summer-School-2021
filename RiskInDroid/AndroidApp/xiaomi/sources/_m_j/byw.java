package _m_j;

import _m_j.byv;
import _m_j.cbu;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.DefaultRetryPolicy;
import com.google.gson.Gson;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.activity.PayResultWebActivity;
import com.mi.global.shop.buy.BFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.GetOtpResult;
import com.mi.global.shop.newmodel.pay.payinfo.NewPayGoBFLResult;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u00192\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010+\u001a\u00020\u001dH\u0002J\u0006\u0010,\u001a\u00020\u001dJ\u001c\u0010-\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010\b2\b\u0010/\u001a\u0004\u0018\u00010\bH\u0002J\b\u00100\u001a\u00020\u001dH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/mi/global/shop/buy/BFLVerifyOTPFragment;", "Lcom/mi/global/shop/ui/BaseFragment;", "()V", "loadingDialog", "Landroid/app/ProgressDialog;", "mBFLOtpTips", "Lcom/mi/global/shop/widget/CustomTextView;", "mCardNum", "", "mConfirmPayNow", "Lcom/mi/global/shop/widget/CustomButtonView;", "mConstraintLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "mCountDownTime", "mEmiCode", "mGateWay", "mLastFourNumPhone", "mOtpNum", "Lcom/mi/global/shop/widget/CustomEditTextView;", "mReGetCountDownTimer", "Landroid/os/CountDownTimer;", "mResendOTP", "mTerms", "mTransactionCode", "mView", "Landroid/view/View;", "getHeight", "", "getOtpSend", "", "hideLoading", "initView", "initViewState", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "realRay", "showLoading", "showVerifyFailedDialog", "failedType", "failedMsg", "startCountDown", "Companion", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
public final class byw extends can {
    static final DefaultRetryPolicy O0000OoO = new DefaultRetryPolicy(30000, 0, 1.0f);
    public static final O000000o O0000Ooo = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    public CountDownTimer f13428O000000o;
    public CustomTextView O00000Oo;
    public CustomTextView O00000o;
    public CustomButtonView O00000o0;
    public CustomEditTextView O00000oO;
    public String O00000oo;
    String O0000O0o;
    String O0000OOo;
    String O0000Oo;
    String O0000Oo0;
    private View O0000o;
    private CustomTextView O0000o0;
    private ConstraintLayout O0000o0O;
    private String O0000o0o;
    private HashMap O0000oO;
    private ProgressDialog O0000oO0;

    public static final /* synthetic */ CustomButtonView O000000o(byw byw) {
        CustomButtonView customButtonView = byw.O00000o0;
        if (customButtonView == null) {
            ixe.O000000o("mConfirmPayNow");
        }
        return customButtonView;
    }

    public static final /* synthetic */ CustomTextView O00000Oo(byw byw) {
        CustomTextView customTextView = byw.O00000o;
        if (customTextView == null) {
            ixe.O000000o("mCountDownTime");
        }
        return customTextView;
    }

    public static final /* synthetic */ CustomEditTextView O00000o(byw byw) {
        CustomEditTextView customEditTextView = byw.O00000oO;
        if (customEditTextView == null) {
            ixe.O000000o("mOtpNum");
        }
        return customEditTextView;
    }

    public static final /* synthetic */ CustomTextView O00000o0(byw byw) {
        CustomTextView customTextView = byw.O00000Oo;
        if (customTextView == null) {
            ixe.O000000o("mResendOTP");
        }
        return customTextView;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/mi/global/shop/buy/BFLVerifyOTPFragment$Companion;", "", "()V", "ALL_COUNT_DOWM_TIME", "", "CARD_NUM", "", "EMI_CODE", "GATEWAY", "LAST_FOUR_NUMBER", "PAGE_ID", "TAG", "TERMS", "TRANSACTION_CODE", "defaultRetryPolicy", "Lcom/android/volley/DefaultRetryPolicy;", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        ccr.O000000o("BFLVerifyOTPFragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        ccr.O00000Oo("BFLVerifyOTPFragment", "onCreateView");
        View view = this.O0000o;
        if (view == null) {
            this.O0000o = layoutInflater.inflate((int) R.layout.shop_activity_bfl_otp_verify, viewGroup, false);
        } else {
            ViewParent viewParent = null;
            ViewParent parent = view != null ? view.getParent() : null;
            if (parent instanceof ViewGroup) {
                viewParent = parent;
            }
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O0000o);
            }
        }
        return this.O0000o;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [androidx.fragment.app.FragmentActivity, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void onViewCreated(View view, Bundle bundle) {
        ixe.O00000o0(view, "view");
        if (getActivity() != null) {
            View view2 = this.O0000o;
            if (view2 != null) {
                View findViewById = view2.findViewById(R.id.tv_tips_otp);
                if (findViewById != null) {
                    this.O0000o0 = (CustomTextView) findViewById;
                    View findViewById2 = view2.findViewById(R.id.btn_confirm_pay_now);
                    if (findViewById2 != null) {
                        this.O00000o0 = (CustomButtonView) findViewById2;
                        View findViewById3 = view2.findViewById(R.id.tv_resend_otp);
                        if (findViewById3 != null) {
                            this.O00000Oo = (CustomTextView) findViewById3;
                            View findViewById4 = view2.findViewById(R.id.tv_countdown_otp_second);
                            if (findViewById4 != null) {
                                this.O00000o = (CustomTextView) findViewById4;
                                View findViewById5 = view2.findViewById(R.id.et_otp_num);
                                if (findViewById5 != null) {
                                    this.O00000oO = (CustomEditTextView) findViewById5;
                                    View findViewById6 = view2.findViewById(R.id.cl_tv_otp_xiaomi);
                                    if (findViewById6 != null) {
                                        this.O0000o0O = (ConstraintLayout) findViewById6;
                                        ConstraintLayout constraintLayout = this.O0000o0O;
                                        if (constraintLayout == null) {
                                            ixe.O000000o("mConstraintLayout");
                                        }
                                        ViewGroup.LayoutParams layoutParams = constraintLayout.getLayoutParams();
                                        if (layoutParams != null) {
                                            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                                            Context context = getContext();
                                            String str = null;
                                            Object systemService = context != null ? context.getSystemService("window") : null;
                                            if (systemService != null) {
                                                Point point = new Point();
                                                ((WindowManager) systemService).getDefaultDisplay().getSize(point);
                                                layoutParams2.topMargin = point.y - dao.O000000o(100.0f);
                                                ConstraintLayout constraintLayout2 = this.O0000o0O;
                                                if (constraintLayout2 == null) {
                                                    ixe.O000000o("mConstraintLayout");
                                                }
                                                constraintLayout2.setLayoutParams(layoutParams2);
                                                Bundle arguments = getArguments();
                                                if (arguments != null) {
                                                    this.O0000O0o = arguments.getString("card_num");
                                                    this.O0000OOo = arguments.getString("emi_code");
                                                    this.O0000Oo0 = arguments.getString("terms");
                                                    this.O0000Oo = arguments.getString("gateway");
                                                    this.O0000o0o = arguments.getString("last_four_mobile_num");
                                                    this.O00000oo = arguments.getString("transaction_code");
                                                }
                                                FragmentActivity activity = getActivity();
                                                if (activity != null) {
                                                    ixe.O000000o((Object) activity, "activity");
                                                    Resources resources = activity.getResources();
                                                    if (resources != null) {
                                                        str = resources.getString(R.string.bfl_otp_tips);
                                                    }
                                                }
                                                if (str == null) {
                                                    str = "";
                                                }
                                                CustomTextView customTextView = this.O0000o0;
                                                if (customTextView == null) {
                                                    ixe.O000000o("mBFLOtpTips");
                                                }
                                                ixh ixh = ixh.f1644O000000o;
                                                String format = String.format(str, Arrays.copyOf(new Object[]{this.O0000o0o}, 1));
                                                ixe.O000000o((Object) format, "java.lang.String.format(format, *args)");
                                                customTextView.setText(Html.fromHtml(format));
                                                CustomEditTextView customEditTextView = this.O00000oO;
                                                if (customEditTextView == null) {
                                                    ixe.O000000o("mOtpNum");
                                                }
                                                customEditTextView.addTextChangedListener(new O00000o0(this));
                                                CustomTextView customTextView2 = this.O00000Oo;
                                                if (customTextView2 == null) {
                                                    ixe.O000000o("mResendOTP");
                                                }
                                                customTextView2.setOnClickListener(new O00000o(this));
                                                CustomButtonView customButtonView = this.O00000o0;
                                                if (customButtonView == null) {
                                                    ixe.O000000o("mConfirmPayNow");
                                                }
                                                customButtonView.setOnClickListener(new O0000O0o(this));
                                            } else {
                                                throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
                                            }
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type android.support.constraint.ConstraintLayout");
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.widget.CustomEditTextView");
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.widget.CustomTextView");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.widget.CustomTextView");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.widget.CustomButtonView");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.widget.CustomTextView");
                }
            }
            O00000Oo();
            O000000o();
        }
        super.onViewCreated(view, bundle);
    }

    public final void O000000o() {
        CustomButtonView customButtonView = this.O00000o0;
        if (customButtonView == null) {
            ixe.O000000o("mConfirmPayNow");
        }
        customButtonView.setEnabled(false);
        CustomTextView customTextView = this.O00000Oo;
        if (customTextView == null) {
            ixe.O000000o("mResendOTP");
        }
        customTextView.setEnabled(false);
        CustomTextView customTextView2 = this.O00000o;
        if (customTextView2 == null) {
            ixe.O000000o("mCountDownTime");
        }
        customTextView2.setVisibility(0);
        CustomEditTextView customEditTextView = this.O00000oO;
        if (customEditTextView == null) {
            ixe.O000000o("mOtpNum");
        }
        customEditTextView.setText("");
        CustomTextView customTextView3 = this.O00000Oo;
        if (customTextView3 == null) {
            ixe.O000000o("mResendOTP");
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            customTextView3.setTextColor(ContextCompat.O00000o0(activity, R.color.title_text_color));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.content.Context");
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e¸\u0006\u0000"}, d2 = {"com/mi/global/shop/buy/BFLVerifyOTPFragment$initView$1$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O00000o0 implements TextWatcher {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13431O000000o;

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        O00000o0(byw byw) {
            this.f13431O000000o = byw;
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            byw.O000000o(this.f13431O000000o).setEnabled(charSequence != null && charSequence.length() == 6);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/mi/global/shop/buy/BFLVerifyOTPFragment$initView$1$2"}, k = 3, mv = {1, 1, 15})
    static final class O00000o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13430O000000o;

        O00000o(byw byw) {
            this.f13430O000000o = byw;
        }

        public final void onClick(View view) {
            this.f13430O000000o.O000000o();
            byw byw = this.f13430O000000o;
            cbe.O000000o("resend_otp_click", "OTP_verifcation");
            byw.O00000o0();
            Uri.Builder buildUpon = Uri.parse(cav.O000o0()).buildUpon();
            Context context = byw.getContext();
            if (context != null) {
                buildUpon.appendQueryParameter("id", ((ConfirmActivity) context).getconfirmOrder().f4863O000000o);
                buildUpon.appendQueryParameter("gateway", byw.O0000Oo);
                buildUpon.appendQueryParameter("cardcode", byw.O0000O0o);
                cam cam = new cam(buildUpon.toString(), GetOtpResult.class, null, new O00000Oo(byw));
                cam.setTag("BFLVerifyOTPFragment");
                cam.setRetryPolicy(byw.O0000OoO);
                ced.O000000o().add(cam);
                this.f13430O000000o.O00000Oo();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.buy.ConfirmActivity");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/mi/global/shop/buy/BFLVerifyOTPFragment$initView$1$3"}, k = 3, mv = {1, 1, 15})
    static final class O0000O0o implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13432O000000o;

        O0000O0o(byw byw) {
            this.f13432O000000o = byw;
        }

        public final void onClick(View view) {
            byw byw = this.f13432O000000o;
            byw.O00000o0();
            cbe.O000000o("pay_click", "OTP_verifcation");
            Uri.Builder buildUpon = Uri.parse(cav.O000o0O()).buildUpon();
            Context context = byw.getContext();
            if (context != null) {
                buildUpon.appendQueryParameter("id", ((ConfirmActivity) context).getconfirmOrder().f4863O000000o);
                buildUpon.appendQueryParameter("bank", byw.O0000Oo);
                buildUpon.appendQueryParameter("type", "emi");
                buildUpon.appendQueryParameter("checkcode", byw.O0000O0o);
                buildUpon.appendQueryParameter("emibank", "BFL");
                buildUpon.appendQueryParameter("bankcode", byw.O0000OOo);
                buildUpon.appendQueryParameter("terms", byw.O0000Oo0);
                buildUpon.appendQueryParameter("transactioncode", byw.O00000oo);
                CustomEditTextView customEditTextView = byw.O00000oO;
                if (customEditTextView == null) {
                    ixe.O000000o("mOtpNum");
                }
                buildUpon.appendQueryParameter("phonecode", customEditTextView.getText().toString());
                cam cam = new cam(buildUpon.toString(), NewPayGoBFLResult.class, null, new O0000OOo(byw));
                cam.setTag("BFLVerifyOTPFragment");
                cam.setRetryPolicy(byw.O0000OoO);
                ced.O000000o().add(cam);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.mi.global.shop.buy.ConfirmActivity");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/mi/global/shop/buy/BFLVerifyOTPFragment$realRay$callback$1", "Lcom/mi/global/shop/request/SimpleCallback;", "Lcom/mi/global/shop/newmodel/pay/payinfo/NewPayGoBFLResult;", "error", "", "errmsg", "", "success", "result", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O0000OOo extends cak<NewPayGoBFLResult> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13433O000000o;

        O0000OOo(byw byw) {
            this.f13433O000000o = byw;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [androidx.fragment.app.FragmentActivity, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [_m_j.ee, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final /* synthetic */ void O000000o(BaseResult baseResult) {
            NewPayGoBFLResult newPayGoBFLResult = (NewPayGoBFLResult) baseResult;
            this.f13433O000000o.O00000o();
            NewPayGoBFLResult.NewPayGoResultData newPayGoResultData = newPayGoBFLResult != null ? newPayGoBFLResult.data : null;
            if (newPayGoResultData != null && this.f13433O000000o.getActivity() != null && !TextUtils.isEmpty(newPayGoResultData.params)) {
                NewPayGoBFLResult.Params params = (NewPayGoBFLResult.Params) new Gson().fromJson(newPayGoResultData.params, NewPayGoBFLResult.Params.class);
                if (params != null && !TextUtils.isEmpty(params.url)) {
                    Intent intent = new Intent(this.f13433O000000o.getActivity(), PayResultWebActivity.class);
                    intent.putExtra("url", params.url);
                    FragmentActivity activity = this.f13433O000000o.getActivity();
                    if (activity != null) {
                        activity.startActivityForResult(intent, 101);
                    }
                } else if (params != null && !TextUtils.isEmpty(params.code)) {
                    byw byw = this.f13433O000000o;
                    String str = params.code;
                    String str2 = params.msg;
                    if (byw.getActivity() != null) {
                        byv.O000000o o000000o = byv.O00000Oo;
                        byv byv = new byv();
                        cbt o0000Oo0 = new O0000Oo0(byw, str, str2);
                        ixe.O00000o0(o0000Oo0, "convertListener");
                        byv.f13427O000000o = o0000Oo0;
                        byv O00000Oo = byv.O00000Oo();
                        O00000Oo.O00000o = 30;
                        FragmentActivity activity2 = byw.getActivity();
                        if (activity2 == null) {
                            ixe.O000000o();
                        }
                        ixe.O000000o((Object) activity2, "activity!!");
                        ee supportFragmentManager = activity2.getSupportFragmentManager();
                        ixe.O000000o((Object) supportFragmentManager, "activity!!.supportFragmentManager");
                        O00000Oo.O000000o(supportFragmentManager);
                    }
                }
            }
        }

        public final void O000000o(String str) {
            ixe.O00000o0(str, "errmsg");
            super.O000000o(str);
            this.f13433O000000o.O00000o();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/mi/global/shop/buy/BFLVerifyOTPFragment$getOtpSend$callback$1", "Lcom/mi/global/shop/request/SimpleCallback;", "Lcom/mi/global/shop/newmodel/GetOtpResult;", "error", "", "errmsg", "", "success", "result", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O00000Oo extends cak<GetOtpResult> {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13429O000000o;

        O00000Oo(byw byw) {
            this.f13429O000000o = byw;
        }

        public final /* synthetic */ void O000000o(BaseResult baseResult) {
            GetOtpResult getOtpResult = (GetOtpResult) baseResult;
            this.f13429O000000o.O00000o();
            if (getOtpResult != null && getOtpResult.data != null) {
                this.f13429O000000o.O00000oo = getOtpResult.data.transactionCode;
            }
        }

        public final void O000000o(String str) {
            ixe.O00000o0(str, "errmsg");
            super.O000000o(str);
            this.f13429O000000o.O00000o();
            Log.e("zhangrr", "BFLVerifyOTPFragment.error() called. ".concat(String.valueOf(str)));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/mi/global/shop/buy/BFLVerifyOTPFragment$showVerifyFailedDialog$1", "Lcom/mi/global/shop/voice/dialog/ViewConvertListener;", "convertView", "", "holder", "Lcom/mi/global/shop/voice/dialog/ViewHolder;", "dialogFragment", "Lcom/mi/global/shop/voice/dialog/BaseDialogFragment;", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O0000Oo0 implements cbt {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ byw f13435O000000o;
        public final /* synthetic */ String O00000Oo;
        final /* synthetic */ String O00000o0;

        O0000Oo0(byw byw, String str, String str2) {
            this.f13435O000000o = byw;
            this.O00000Oo = str;
            this.O00000o0 = str2;
        }

        public final void O000000o(cbu cbu, cbs cbs) {
            ixe.O00000o0(cbu, "holder");
            ixe.O00000o0(cbs, "dialogFragment");
            iwb bFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1 = new BFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1(this, cbs);
            ixe.O00000o0(bFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1, "listenerFun");
            View O000000o2 = cbu.O000000o(R.id.tv_failed_go_back);
            if (O000000o2 != null) {
                O000000o2.setOnClickListener(new cbu.O00000Oo(bFLVerifyOTPFragment$showVerifyFailedDialog$1$convertView$1));
            }
            String str = this.O00000o0;
            if (str != null) {
                ixe.O00000o0(str, "text");
                TextView textView = (TextView) cbu.O000000o(R.id.tv_failed_reason);
                if (textView != null) {
                    textView.setText(str);
                }
            }
        }
    }

    public final void O00000Oo() {
        CountDownTimer countDownTimer = this.f13428O000000o;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CustomEditTextView customEditTextView = this.O00000oO;
        if (customEditTextView == null) {
            ixe.O000000o("mOtpNum");
        }
        customEditTextView.setText("");
        if (this.O0000o != null) {
            this.f13428O000000o = new O0000Oo(this).start();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"com/mi/global/shop/buy/BFLVerifyOTPFragment$startCountDown$1$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "shopsdk_release"}, k = 1, mv = {1, 1, 15})
    public static final class O0000Oo extends CountDownTimer {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ byw f13434O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O0000Oo(byw byw) {
            super(60000, 1000);
            this.f13434O000000o = byw;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
         arg types: [androidx.fragment.app.FragmentActivity, java.lang.String]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
        public final void onFinish() {
            byw.O00000Oo(this.f13434O000000o).setVisibility(8);
            byw.O00000o0(this.f13434O000000o).setEnabled(true);
            FragmentActivity activity = this.f13434O000000o.getActivity();
            if (activity != null) {
                ixe.O000000o((Object) activity, "it");
                if (!activity.isFinishing()) {
                    byw.O00000o0(this.f13434O000000o).setTextColor(ContextCompat.O00000o0(activity, R.color.bfl_resend_otp));
                }
            }
            this.f13434O000000o.f13428O000000o = null;
        }

        public final void onTick(long j) {
            CustomTextView O00000Oo = byw.O00000Oo(this.f13434O000000o);
            StringBuilder sb = new StringBuilder();
            sb.append(j / 1000);
            sb.append('S');
            O00000Oo.setText(sb.toString());
        }
    }

    public final void O00000o0() {
        ProgressDialog progressDialog;
        if (BaseActivity.isActivityAlive(getActivity()) && (progressDialog = this.O0000oO0) != null) {
            progressDialog.show();
        }
    }

    public final void O00000o() {
        ProgressDialog progressDialog;
        if (BaseActivity.isActivityAlive(getActivity()) && isAdded() && (progressDialog = this.O0000oO0) != null) {
            if (progressDialog == null) {
                ixe.O000000o();
            }
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = this.O0000oO0;
                if (progressDialog2 == null) {
                    ixe.O000000o();
                }
                progressDialog2.dismiss();
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.O0000oO;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
