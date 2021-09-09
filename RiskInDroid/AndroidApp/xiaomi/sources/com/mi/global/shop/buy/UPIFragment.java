package com.mi.global.shop.buy;

import _m_j.bze;
import _m_j.bzi;
import _m_j.bzt;
import _m_j.can;
import _m_j.cbe;
import _m_j.cck;
import _m_j.cec;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.mi.global.shop.adapter.checkout.UPIListAdapter;
import com.mi.global.shop.adapter.checkout.UPISelectListAdapter;
import com.mi.global.shop.buy.payu.PayU;
import com.mi.global.shop.model.SyncModel;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.NoScrollListView;
import com.payu.sdk.Params;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONException;

public class UPIFragment extends can implements TextWatcher, View.OnClickListener {
    private static final Pattern O0000OOo = Pattern.compile("[^A-Za-z0-9\\-\\.]");
    private static final Pattern O0000Oo0 = Pattern.compile("[^A-Za-z0-9@\\-_\\.]");

    /* renamed from: O000000o  reason: collision with root package name */
    public List<bzi.O00000Oo> f4853O000000o;
    public UPIListAdapter O00000Oo;
    public List<String> O00000o;
    public PopupWindow O00000o0;
    private View O00000oO;
    private String O00000oo;
    private UPISelectListAdapter O0000O0o;
    @BindView(2131494179)
    CustomTextView mBankView;
    @BindView(2131493011)
    CustomButtonView mPayNowBtn;
    @BindView(2131493606)
    LinearLayout mSelectGroup;
    @BindView(2131493611)
    LinearLayout mUPIEnterGroup;
    @BindView(2131494240)
    CustomEditTextView mUPIOtherView;
    @BindView(2131494281)
    CustomTextView mUPITip;
    @BindView(2131494280)
    CustomEditTextView mUPIView;
    @BindView(2131493703)
    NoScrollListView mUpiListView;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view = this.O00000oO;
        if (view == null) {
            this.O00000oO = layoutInflater.inflate((int) R.layout.shop_activity_tez, viewGroup, false);
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.O00000oO);
            }
        }
        return this.O00000oO;
    }

    public void onViewCreated(View view, Bundle bundle) {
        if (getActivity() != null) {
            ButterKnife.bind(this, this.O00000oO);
            cck.O000000o(getActivity());
            this.O00000oO.setLayoutParams(new LinearLayout.LayoutParams(-1, cck.O00000Oo - cck.O000000o(65.0f)));
            this.O00000Oo = new UPIListAdapter(getActivity());
            this.mUpiListView.setAdapter((ListAdapter) this.O00000Oo);
            this.mPayNowBtn.setOnClickListener(this);
            this.mSelectGroup.setOnClickListener(this);
            this.mUPIView.addTextChangedListener(this);
            this.mUPIView.setOnClickListener(this);
            this.mBankView.addTextChangedListener(this);
            this.mUPIOtherView.addTextChangedListener(this);
            final View inflate = LayoutInflater.from(getActivity()).inflate((int) R.layout.shop_layout_tez_popupwindow, (ViewGroup) null);
            NoScrollListView noScrollListView = (NoScrollListView) inflate.findViewById(R.id.lv_select_list);
            this.O0000O0o = new UPISelectListAdapter(getActivity());
            noScrollListView.setAdapter((ListAdapter) this.O0000O0o);
            noScrollListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.mi.global.shop.buy.UPIFragment.AnonymousClass3 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    UPIFragment.this.mBankView.setText(UPIFragment.this.O00000o.get(i));
                    UPIFragment uPIFragment = UPIFragment.this;
                    if (uPIFragment.O00000o0 != null) {
                        uPIFragment.O00000o0.dismiss();
                    }
                }
            });
            this.mSelectGroup.post(new Runnable() {
                /* class com.mi.global.shop.buy.UPIFragment.AnonymousClass4 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void}
                 arg types: [android.view.View, int, int, int]
                 candidates:
                  ClspMth{android.widget.PopupWindow.<init>(android.content.Context, android.util.AttributeSet, int, int):void}
                  ClspMth{android.widget.PopupWindow.<init>(android.view.View, int, int, boolean):void} */
                public final void run() {
                    UPIFragment uPIFragment = UPIFragment.this;
                    uPIFragment.O00000o0 = new PopupWindow(inflate, uPIFragment.mSelectGroup.getMeasuredWidth(), -2, true);
                    UPIFragment.this.O00000o0.setTouchable(true);
                    UPIFragment.this.O00000o0.setFocusable(true);
                    UPIFragment.this.O00000o0.setOutsideTouchable(true);
                }
            });
            O000000o();
            if (O0000O0o()) {
                getActivity().setTitle(getString(R.string.tez_title));
            }
            this.mUpiListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                /* class com.mi.global.shop.buy.UPIFragment.AnonymousClass1 */

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    UPIFragment uPIFragment = UPIFragment.this;
                    uPIFragment.O000000o(uPIFragment.f4853O000000o.get(i));
                    UPIFragment.this.O000000o();
                    UPIFragment uPIFragment2 = UPIFragment.this;
                    if (uPIFragment2.f4853O000000o != null) {
                        for (bzi.O00000Oo o00000Oo : uPIFragment2.f4853O000000o) {
                            o00000Oo.O0000OOo = false;
                        }
                    }
                    UPIFragment.this.f4853O000000o.get(i).O0000OOo = true;
                    UPIFragment.this.O00000Oo.notifyDataSetChanged();
                    cbe.O000000o(String.format("upi%s_click", Integer.valueOf(i + 1)), "UPI");
                }
            });
            O00000Oo();
        }
        super.onViewCreated(view, bundle);
    }

    public final void O000000o(bzi.O00000Oo o00000Oo) {
        if (o00000Oo.O0000OoO == 1) {
            this.mUPIEnterGroup.setVisibility(0);
            this.mUPIOtherView.setVisibility(8);
            this.mUPIView.setText("");
            this.mBankView.setText("");
            this.mUPITip.setText(getString(R.string.tez_upi_id));
            return;
        }
        this.mUPIEnterGroup.setVisibility(8);
        this.mUPIOtherView.setVisibility(0);
        this.mUPIOtherView.setText("");
        this.mUPITip.setText(getString(R.string.tez_upi_other_id));
    }

    private void O00000Oo() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.O00000oo = arguments.getString("order_id_extra");
        }
        if (PayU.O0000O0o != null && PayU.O0000O0o.size() > 0) {
            Iterator<bzi.O00000Oo> it = PayU.O0000O0o.iterator();
            while (it.hasNext()) {
                bzi.O00000Oo next = it.next();
                if (next.O00000oo.equals(getString(R.string.buy_confirm_PaymentKey_UPI))) {
                    this.f4853O000000o = next.O0000Oo;
                    if (this.f4853O000000o == null && O0000O0o()) {
                        getActivity().getSupportFragmentManager().O00000o0();
                    }
                    List<bzi.O00000Oo> list = this.f4853O000000o;
                    if (list != null) {
                        Iterator<bzi.O00000Oo> it2 = list.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                bzi.O00000Oo next2 = it2.next();
                                if (next2.O0000OOo) {
                                    O000000o(next2);
                                    break;
                                }
                            } else {
                                List<bzi.O00000Oo> list2 = this.f4853O000000o;
                                if (list2 != null && list2.size() > 0) {
                                    this.f4853O000000o.get(0).O0000OOo = true;
                                }
                            }
                        }
                    }
                    this.O00000Oo.O000000o(this.f4853O000000o);
                    return;
                }
            }
        }
    }

    public final void O000000o(String str, Params params, String str2, String str3) {
        bzt.O000000o(this.O00000oo, "payu_india", str, (ConfirmActivity) getActivity(), PayU.PaymentMode.UPI, params, "", "", "", str2, str3);
    }

    public final void O000000o() {
        if (O0000O0o()) {
            this.mPayNowBtn.setClickable(false);
            this.mPayNowBtn.setBackgroundColor(getResources().getColor(R.color.delivery_tv_gray));
        }
    }

    public void onClick(View view) {
        bzi.O00000Oo O00000o02;
        String[] split;
        final String str;
        int id = view.getId();
        if (id == R.id.bt_pay) {
            if (O00000o0() != null) {
                if (O00000o0().O0000OoO == 1) {
                    str = this.mUPIView.getText().toString().replace(" ", "") + "@" + this.mBankView.getText().toString().replace(" ", "");
                } else {
                    str = this.mUPIOtherView.getText().toString().replace(" ", "");
                }
                final Params params = new Params();
                params.put("bankcode", O00000o0().O00000oo);
                params.put("vpa", str);
                if ("tez".equalsIgnoreCase(O00000o0().O00000oo)) {
                    bze bze = new bze();
                    String str2 = null;
                    try {
                        str2 = bze.O000000o("", "", "", "", "", "");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    FragmentActivity activity = getActivity();
                    AnonymousClass2 r5 = new bze.O000000o() {
                        /* class com.mi.global.shop.buy.UPIFragment.AnonymousClass2 */

                        public final void O000000o() {
                            params.put("bankcode", "UPI");
                            UPIFragment.this.O000000o("upi", params, "upi", str);
                        }

                        public final void O00000Oo() {
                            UPIFragment.this.O000000o("tezapp", params, "upi", str);
                        }
                    };
                    bze.O00000o0 = activity;
                    if (SyncModel.data == null || SyncModel.data.switchInfo == null || SyncModel.data.switchInfo.assembleTEZ) {
                        try {
                            if (!bze.O000000o()) {
                                r5.O000000o();
                            } else {
                                bze.f13456O000000o.isReadyToPay(bze.O00000o0, str2).addOnCompleteListener(new OnCompleteListener<Boolean>(r5) {
                                    /* class _m_j.bze.AnonymousClass1 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O000000o f13457O000000o;

                                    {
                                        this.f13457O000000o = r2;
                                    }

                                    public final void onComplete(Task<Boolean> task) {
                                        try {
                                            if (task.getResult(ApiException.class).booleanValue()) {
                                                this.f13457O000000o.O00000Oo();
                                                Log.d(bze.O00000Oo, "TezIsReadyToPay Successful");
                                                return;
                                            }
                                            Log.d(bze.O00000Oo, "TezIsReadyToPay Failed");
                                            this.f13457O000000o.O000000o();
                                        } catch (ApiException unused) {
                                            this.f13457O000000o.O000000o();
                                        }
                                    }
                                });
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            r5.O000000o();
                        }
                    } else {
                        r5.O000000o();
                    }
                } else {
                    O000000o("upi", params, "upi", str);
                }
                cbe.O000000o("pay_click", "UPI", "channl", O00000o0().f13475O000000o);
            }
        } else if (id == R.id.layout_select_group) {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (!(!inputMethodManager.isActive() || getActivity().getCurrentFocus() == null || getActivity().getCurrentFocus().getWindowToken() == null)) {
                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
            }
            CustomTextView customTextView = this.mBankView;
            if (!(this.O00000o0 == null || O00000o0() == null || (O00000o02 = O00000o0()) == null || TextUtils.isEmpty(O00000o02.O0000Oo0) || (split = O00000o02.O0000Oo0.split(",")) == null)) {
                this.O00000o = Arrays.asList(split);
                this.O0000O0o.O000000o(this.O00000o);
                this.O00000o0.showAsDropDown(customTextView);
            }
            cbe.O000000o("select_click", "UPI");
        } else if (id == R.id.tv_upi_id) {
            cbe.O000000o("id_click", "UPI");
        }
    }

    private bzi.O00000Oo O00000o0() {
        List<bzi.O00000Oo> list = this.f4853O000000o;
        if (list == null) {
            return null;
        }
        for (bzi.O00000Oo next : list) {
            if (next.O0000OOo) {
                return next;
            }
        }
        return null;
    }

    public void onDestroyView() {
        if (getActivity() != null) {
            getActivity().setTitle((int) R.string.buy_confirm_title);
        }
        super.onDestroyView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005f, code lost:
        if (android.text.TextUtils.isEmpty(r3.mBankView.getText().toString()) == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00ab, code lost:
        if (r4.contains("@") != false) goto L_0x0062;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b4  */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        if (O00000o0() != null) {
            if (O00000o0().O0000OoO == 1) {
                String obj = this.mUPIView.getText().toString();
                z = O0000OOo.matcher(obj).find();
                if (z) {
                    cec.O000000o(getContext(), (int) R.string.tez_upi_error_tip, 0);
                    String replaceAll = obj.replaceAll(O0000OOo.toString(), "");
                    this.mUPIView.setText(replaceAll);
                    this.mUPIView.setSelection(replaceAll.length());
                    if (z) {
                        O000000o();
                        return;
                    } else if (O0000O0o()) {
                        this.mPayNowBtn.setClickable(true);
                        this.mPayNowBtn.setBackgroundColor(getResources().getColor(R.color.orange_red));
                        return;
                    } else {
                        return;
                    }
                } else {
                    if (!TextUtils.isEmpty(obj)) {
                    }
                    z = true;
                    if (z) {
                    }
                }
            } else {
                String obj2 = this.mUPIOtherView.getText().toString();
                z = O0000Oo0.matcher(obj2).find();
                if (z) {
                    cec.O000000o(getContext(), (int) R.string.tez_upi_other_error_tip, 0);
                    String replaceAll2 = obj2.replaceAll(O0000OOo.toString(), "");
                    this.mUPIOtherView.setText(replaceAll2);
                    this.mUPIOtherView.setSelection(replaceAll2.length());
                    if (z) {
                    }
                } else {
                    if (!TextUtils.isEmpty(obj2)) {
                    }
                    z = true;
                    if (z) {
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
    }
}
