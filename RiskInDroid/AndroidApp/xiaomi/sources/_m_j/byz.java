package _m_j;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.adapter.util.ArrayAdapter;
import com.mi.global.shop.buy.ConfirmActivity;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.pay.payinfo.NewUserCardsType;
import com.mi.global.shop.newmodel.pay.savecard.NewCardsBodyResult;
import com.mi.global.shop.newmodel.pay.savecard.NewCardsListData;
import com.mi.global.shop.widget.CommonButton;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.mi.global.shop.widget.SlidingButton;
import com.payu.sdk.Params;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public final class byz extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    NoScrollListView f13437O000000o;
    O000000o O00000Oo;
    CustomButtonView O00000o;
    ArrayList<NewUserCardsType> O00000o0;
    CustomTextView O00000oO;
    public RelativeLayout O00000oo;
    public LinearLayout O0000O0o;
    private View O0000OOo;
    private ProgressDialog O0000Oo;
    private CustomButtonView O0000Oo0;

    public final void onCreate(Bundle bundle) {
        ccr.O00000Oo("Cardfragment", "onCreate");
        super.onCreate(bundle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Request request;
        ccr.O00000Oo("Cardfragment", "onCreateView");
        View view = this.O0000OOo;
        if (view == null) {
            this.O0000OOo = layoutInflater.inflate((int) R.layout.shop_buy_confirm_payment_credit_newdetail, viewGroup, false);
            new byy(getActivity(), this.O0000OOo);
            View view2 = this.O0000OOo;
            this.f13437O000000o = (NoScrollListView) view2.findViewById(R.id.cardListView);
            this.O0000O0o = (LinearLayout) view2.findViewById(R.id.ll_add_card);
            this.O00000oo = (RelativeLayout) view2.findViewById(R.id.rl_card_list);
            this.O00000o = (CustomButtonView) view2.findViewById(R.id.btn_add);
            this.O00000o.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.byz.AnonymousClass1 */

                public final void onClick(View view) {
                    byz.this.O0000O0o.setVisibility(0);
                    byz.this.O00000oo.setVisibility(8);
                }
            });
            this.O0000Oo0 = (CustomButtonView) view2.findViewById(R.id.btn_back);
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.byz.AnonymousClass2 */

                public final void onClick(View view) {
                    byz.this.O0000O0o.setVisibility(8);
                    byz.this.O00000oo.setVisibility(0);
                }
            });
            this.O00000oO = (CustomTextView) view2.findViewById(R.id.tv_no_card_hint);
            this.O0000Oo = new ProgressDialog(getActivity());
            this.O0000Oo.setMessage(getString(R.string.please_wait));
            this.O0000Oo.setIndeterminate(true);
            this.O0000Oo.setCancelable(false);
            this.O0000Oo.setCanceledOnTouchOutside(false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O0000OOo);
                ccr.O00000Oo("Cardfragment", "onCreateView remove from parent");
            }
        }
        Uri.Builder buildUpon = Uri.parse(cav.O000OooO()).buildUpon();
        buildUpon.appendQueryParameter("ot", "5");
        AnonymousClass3 r4 = new cak<NewCardsBodyResult>() {
            /* class _m_j.byz.AnonymousClass3 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                byz.this.O000000o();
                byz byz = byz.this;
                NewCardsListData newCardsListData = ((NewCardsBodyResult) baseResult).data;
                if (newCardsListData != null && newCardsListData.user_cards != null) {
                    if (newCardsListData.user_cards.size() == 0) {
                        byz.O00000oO.setVisibility(0);
                        byz.O00000o.performClick();
                        return;
                    }
                    byz.O00000oO.setVisibility(8);
                    newCardsListData.user_cards.get(0).expand = true;
                    byz.O00000o0 = newCardsListData.user_cards;
                    byz.O00000Oo = new O000000o(byl.O00000oO());
                    byz.O00000Oo.O000000o((List) byz.O00000o0);
                    byz.f13437O000000o.setAdapter((ListAdapter) byz.O00000Oo);
                    byz.O0000O0o.setVisibility(8);
                    byz.O00000oo.setVisibility(0);
                }
            }

            public final void O000000o(String str) {
                super.O000000o(str);
                byz.this.O000000o();
            }
        };
        if (byl.O0000OoO()) {
            request = new cam(buildUpon.toString(), NewCardsBodyResult.class, r4);
        } else {
            request = new cal(buildUpon.toString(), NewCardsBodyResult.class, r4);
        }
        request.setTag("Cardfragment");
        ced.f13683O000000o.add(request);
        if (BaseActivity.isActivityAlive(getActivity())) {
            ProgressDialog progressDialog = this.O0000Oo;
            if (progressDialog != null) {
                progressDialog.show();
            }
            this.O00000o.setVisibility(8);
        }
        return this.O0000OOo;
    }

    public final void O000000o() {
        if (BaseActivity.isActivityAlive(getActivity()) && isAdded()) {
            ProgressDialog progressDialog = this.O0000Oo;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.O0000Oo.dismiss();
            }
            this.O00000o.setVisibility(0);
        }
    }

    public class O000000o extends ArrayAdapter<NewUserCardsType> implements SlidingButton.O000000o {
        public final void O000000o(SlidingButton slidingButton, boolean z) {
        }

        public final int getItemViewType(int i) {
            return i;
        }

        public final /* synthetic */ void O000000o(View view, int i, Object obj) {
            final NewUserCardsType newUserCardsType = (NewUserCardsType) obj;
            O00000Oo o00000Oo = (O00000Oo) view.getTag();
            String concat = "****".concat(String.valueOf(newUserCardsType.card_no.substring(newUserCardsType.card_no.length() - 4)));
            o00000Oo.f13445O000000o.setImageDrawable(bzs.f13499O000000o.get(O000000o(newUserCardsType.card_brand)));
            o00000Oo.O0000OoO.setText(concat);
            o00000Oo.O0000Ooo.setText(newUserCardsType.name_on_card);
            CustomTextView customTextView = o00000Oo.O0000Oo;
            customTextView.setText(newUserCardsType.expiry_month + "/" + newUserCardsType.expiry_year);
            o00000Oo.O00000Oo.setImageDrawable(bzs.f13499O000000o.get(O000000o(newUserCardsType.card_brand)));
            o00000Oo.O0000O0o.setText(concat);
            o00000Oo.O0000OOo.setText(newUserCardsType.name_on_card);
            CustomTextView customTextView2 = o00000Oo.O0000Oo0;
            customTextView2.setText(newUserCardsType.expiry_month + "/" + newUserCardsType.expiry_year);
            int i2 = newUserCardsType.card_no.matches("^3[47]+[0-9|X]*") ? 4 : 3;
            o00000Oo.O00000o0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i2)});
            if (i2 == 4) {
                o00000Oo.O00000o.setImageResource(R.drawable.shop_cvv1234);
            } else {
                o00000Oo.O00000o.setImageResource(R.drawable.shop_cvv123);
            }
            o00000Oo.O00000oo = newUserCardsType;
            if (newUserCardsType.expand) {
                o00000Oo.O0000o0.setVisibility(8);
                o00000Oo.O0000o00.setVisibility(0);
                return;
            }
            o00000Oo.O0000o0.setVisibility(0);
            o00000Oo.O0000o00.setVisibility(8);
            o00000Oo.O0000o0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.byz.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    ArrayList O00000Oo2 = O000000o.this.O00000Oo();
                    newUserCardsType.expand = true;
                    for (int i = 0; i < O00000Oo2.size(); i++) {
                        if (!((NewUserCardsType) O00000Oo2.get(i)).equals(newUserCardsType)) {
                            ((NewUserCardsType) O00000Oo2.get(i)).expand = false;
                        }
                    }
                    O000000o.this.notifyDataSetChanged();
                }
            });
        }

        public O000000o(Context context) {
            super(context);
        }

        private static String O000000o(String str) {
            if (str == null) {
                return str;
            }
            String upperCase = str.toUpperCase();
            if ("MASTERCARD".equals(upperCase)) {
                return "MAST";
            }
            if ("VISA".equals(upperCase)) {
                return "VISA";
            }
            if ("MAESTRO".equals(upperCase)) {
                return "MAES";
            }
            if ("AMEX".equals(upperCase)) {
                return "AMEX";
            }
            if ("DINERS".equals(upperCase)) {
                return "DINR";
            }
            if ("DISCOVERCARD".equals(upperCase)) {
                return "DISCOVER";
            }
            if ("RUPAY".equals(upperCase)) {
                return "RUPAY";
            }
            return upperCase;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, ?[OBJECT, ARRAY], int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final /* synthetic */ View O000000o(Context context, int i, Object obj, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.O00000o).inflate((int) R.layout.shop_buy_confirm_payment_credit_exits, (ViewGroup) null, false);
            O00000Oo o00000Oo = new O00000Oo();
            o00000Oo.O0000o00 = inflate.findViewById(R.id.detail_contianer);
            o00000Oo.O00000Oo = (ImageView) o00000Oo.O0000o00.findViewById(R.id.card_type_detail);
            o00000Oo.O0000O0o = (CustomTextView) o00000Oo.O0000o00.findViewById(R.id.card_number_detail);
            o00000Oo.O0000OOo = (CustomTextView) o00000Oo.O0000o00.findViewById(R.id.card_name_detail);
            o00000Oo.O0000Oo0 = (CustomTextView) o00000Oo.O0000o00.findViewById(R.id.card_expire_detail);
            o00000Oo.O00000o0 = (CustomEditTextView) o00000Oo.O0000o00.findViewById(R.id.card_cvv);
            o00000Oo.O00000o = (ImageView) o00000Oo.O0000o00.findViewById(R.id.card_cvv_image);
            o00000Oo.O00000oO = (CommonButton) o00000Oo.O0000o00.findViewById(R.id.pay_order);
            o00000Oo.O0000o0 = inflate.findViewById(R.id.simple_contianer);
            o00000Oo.f13445O000000o = (ImageView) o00000Oo.O0000o0.findViewById(R.id.card_type);
            o00000Oo.O0000OoO = (CustomTextView) o00000Oo.O0000o0.findViewById(R.id.card_number);
            o00000Oo.O0000Ooo = (CustomTextView) o00000Oo.O0000o0.findViewById(R.id.card_name);
            o00000Oo.O0000Oo = (CustomTextView) o00000Oo.O0000o0.findViewById(R.id.card_expire);
            inflate.setTag(o00000Oo);
            o00000Oo.O00000oO.setEnabled(false);
            byz byz = byz.this;
            o00000Oo.O00000o0.addTextChangedListener(new TextWatcher(o00000Oo) {
                /* class _m_j.byz.AnonymousClass4 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000Oo f13441O000000o;

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                {
                    this.f13441O000000o = r2;
                }

                public final void afterTextChanged(Editable editable) {
                    if ((!this.f13441O000000o.O00000oo.card_no.matches("^3[47]+[0-9|X]*") || this.f13441O000000o.O00000o0.getText().length() != 4) && (this.f13441O000000o.O00000oo.card_no.matches("^3[47]+[0-9|X]*") || this.f13441O000000o.O00000o0.getText().length() != 3)) {
                        this.f13441O000000o.O00000oO.setEnabled(false);
                    } else {
                        this.f13441O000000o.O00000oO.setEnabled(true);
                    }
                }
            });
            o00000Oo.O00000oO.setOnClickListener(new View.OnClickListener(o00000Oo) {
                /* class _m_j.byz.AnonymousClass5 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ O00000Oo f13442O000000o;

                {
                    this.f13442O000000o = r2;
                }

                public final void onClick(View view) {
                    Params params = new Params();
                    params.put("ccvv", this.f13442O000000o.O00000o0.getText().toString());
                    params.put("store_card_token", this.f13442O000000o.O00000oo.card_token);
                    bzt.O000000o(((ConfirmActivity) byz.this.getActivity()).getconfirmOrder().f4863O000000o, "payu_india", "card", (ConfirmActivity) byz.this.getActivity(), PayU.PaymentMode.valueOf(this.f13442O000000o.O00000oo.card_mode), params, this.f13442O000000o.O0000OoO.toString().replace(" ", ""), "", "", "", "");
                }
            });
            return inflate;
        }
    }

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        ImageView f13445O000000o;
        ImageView O00000Oo;
        ImageView O00000o;
        CustomEditTextView O00000o0;
        CommonButton O00000oO;
        NewUserCardsType O00000oo;
        CustomTextView O0000O0o;
        CustomTextView O0000OOo;
        CustomTextView O0000Oo;
        CustomTextView O0000Oo0;
        CustomTextView O0000OoO;
        CustomTextView O0000Ooo;
        View O0000o0;
        View O0000o00;

        O00000Oo() {
        }
    }
}
