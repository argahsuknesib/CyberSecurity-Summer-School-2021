package com.mobikwik.sdk.ui.frag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.mobikwik.sdk.lib.payinstrument.PaymentInstrumentType;
import com.mobikwik.sdk.lib.utils.CardUtils;
import com.mobikwik.sdk.lib.utils.UIFunctions;
import com.mobikwik.sdk.lib.utils.Utils;
import com.mobikwik.sdk.ui.data.b;
import com.mobikwik.sdk.ui.util.l;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Calendar;

public class a extends aj implements View.OnClickListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private Spinner f5301a;
    private Spinner s;
    /* access modifiers changed from: private */
    public EditText t;
    private String u;
    /* access modifiers changed from: private */
    public EditText v;
    private EditText w;
    private EditText x;

    /* access modifiers changed from: private */
    public boolean a(boolean z) {
        String str;
        boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(this.q);
        EditText editText = (EditText) getView().findViewById(R.id.editText_cvv);
        String obj = editText.getText().toString();
        editText.setBackgroundResource(R.drawable.mk_edit_text_bg);
        if (obj.length() == 0) {
            if (!equalsIgnoreCase) {
                if (!z) {
                    str = "Enter CVV";
                }
                editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
                this.h++;
                return false;
            }
            this.g = obj;
            return true;
        }
        if (obj.length() < 3 || ("amex".equalsIgnoreCase(this.q) && obj.length() != 4)) {
            if (!z) {
                str = "Please enter valid CVV";
            }
            editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
            this.h++;
            return false;
        }
        this.g = obj;
        return true;
        editText.setError(str);
        editText.requestFocus();
        editText.setBackgroundResource(R.drawable.mk_cvv_text_bg);
        this.h++;
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (r7 == false) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0054, code lost:
        if (r7 == false) goto L_0x0049;
     */
    public boolean b(boolean z) {
        this.h = 0;
        String obj = this.v.getText().toString();
        if (!Utils.isNull(obj) && obj.trim().length() != 0) {
            if (obj.length() >= 13 && obj.length() <= 19) {
                this.q = CardUtils.detectType(obj);
                this.f = obj;
                boolean validateCardNumber = CardUtils.validateCardNumber(this.f);
                if (this.h == 0 && validateCardNumber) {
                    return true;
                }
            }
            this.v.setError("Invalid card number");
        } else if (!z) {
            this.v.setError("Enter card number");
            this.v.requestFocus();
        }
        this.h++;
        return false;
    }

    private void c() {
        if (b(false)) {
            boolean equalsIgnoreCase = "maestro".equalsIgnoreCase(this.q);
            Spinner spinner = (Spinner) getView().findViewById(R.id.spinner_month);
            String obj = spinner.getSelectedItem().toString();
            String obj2 = ((Spinner) getView().findViewById(R.id.spinner_year)).getSelectedItem().toString();
            if (equalsIgnoreCase) {
                if (obj.compareTo("Month") == 0 && obj2.compareTo("Year") != 0) {
                    this.w.setError("Select month");
                    this.w.requestFocus();
                    this.h++;
                    return;
                } else if (obj.compareTo("Month") == 0 || obj2.compareTo("Year") != 0) {
                    int i = Calendar.getInstance().get(2) + 1;
                    int i2 = Calendar.getInstance().get(1) - 2000;
                    if (spinner.getSelectedItemPosition() < i && obj2.compareTo("20".concat(String.valueOf(i2))) == 0) {
                        this.w.setError("Select month");
                        this.w.requestFocus();
                        this.h++;
                        return;
                    } else if (obj.compareTo("Month") == 0 && obj2.compareTo("Year") == 0) {
                        obj = "";
                        obj2 = obj;
                    }
                } else {
                    this.x.setError("Select year");
                    this.x.requestFocus();
                    this.h++;
                    return;
                }
            } else if (obj.compareTo("Month") == 0) {
                this.w.setError("Select month");
                this.w.requestFocus();
                this.h++;
                return;
            } else if (obj2.compareTo("Year") == 0) {
                this.x.setError("Select year");
                this.x.requestFocus();
                this.h++;
                return;
            } else {
                int i3 = Calendar.getInstance().get(2) + 1;
                int i4 = Calendar.getInstance().get(1) - 2000;
                if (spinner.getSelectedItemPosition() < i3 && obj2.compareTo("20".concat(String.valueOf(i4))) == 0) {
                    this.w.setError("Select month");
                    this.w.requestFocus();
                    this.h++;
                    return;
                }
            }
            if (this.h != 0) {
                UIFunctions.showToast(this.k, "Invalid card details. Please correct the errors.");
                return;
            }
            this.b = obj;
            if (obj2 != null && obj2.length() == 4) {
                obj2 = obj2.substring(2);
            }
            this.c = obj2;
            if (a(false)) {
                this.j = ((CheckBox) getView().findViewById(R.id.cbSaveCardDetails)).isChecked();
            }
        }
    }

    /* access modifiers changed from: protected */
    public String a() {
        return this.u;
    }

    public void a(View view) {
        c();
        if (this.h == 0) {
            b();
        }
    }

    public void onClick(View view) {
        Utils.hideKeyBoard(view);
        if (view.getId() == R.id.cvvHelp) {
            return;
        }
        if (view.getId() == R.id.cardPay) {
            a(view);
        } else {
            view.getId();
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate((int) R.layout.mk_card_layout, viewGroup, false);
        this.w = (EditText) inflate.findViewById(R.id.errorVMonth);
        this.x = (EditText) inflate.findViewById(R.id.errorVYear);
        inflate.findViewById(R.id.cvvHelp).setOnClickListener(this);
        inflate.findViewById(R.id.cardPay).setOnClickListener(this);
        inflate.findViewById(R.id.cbSaveCardDetails).setOnClickListener(this);
        l.a((TextView) inflate.findViewById(R.id.amount), this.l.getAmount(), this.p);
        this.s = (Spinner) inflate.findViewById(R.id.spinner_month);
        ArrayAdapter<CharSequence> createFromResource = ArrayAdapter.createFromResource(this.k, R.array.months, 17367043);
        createFromResource.setDropDownViewResource(17367049);
        this.s.setAdapter((SpinnerAdapter) createFromResource);
        int i = Calendar.getInstance().get(1) - 2000;
        ArrayList arrayList = new ArrayList();
        arrayList.add("Year");
        for (int i2 = i; i2 < i + 30; i2++) {
            arrayList.add("20".concat(String.valueOf(i2)));
        }
        this.f5301a = (Spinner) inflate.findViewById(R.id.spinner_year);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.k, 17367043, arrayList);
        arrayAdapter.setDropDownViewResource(17367049);
        this.f5301a.setAdapter((SpinnerAdapter) arrayAdapter);
        this.t = (EditText) inflate.findViewById(R.id.editText_cvv);
        this.v = (EditText) inflate.findViewById(R.id.card_number);
        this.v.setBackgroundResource(R.drawable.mk_cvv_text_bg);
        this.v.addTextChangedListener(new b(this));
        this.f5301a.setFocusableInTouchMode(true);
        this.s.setFocusableInTouchMode(true);
        this.f5301a.setOnTouchListener(this);
        this.s.setOnTouchListener(this);
        inflate.findViewById(R.id.card_number).setOnTouchListener(this);
        this.t.setOnTouchListener(this);
        inflate.findViewById(R.id.name_on_card).setOnTouchListener(this);
        inflate.findViewById(R.id.cbSaveCardDetails).setOnTouchListener(this);
        this.t.addTextChangedListener(new c(this));
        if (!this.r && !b.b(this.k).b().contains(PaymentInstrumentType.SAVED_CARD)) {
            inflate.findViewById(R.id.cbSaveCardDetails).setVisibility(8);
        }
        if (this.r || (b.b(this.k).b().contains(PaymentInstrumentType.SAVED_CARD) && this.m.isSaveCardByDefault())) {
            ((CheckBox) inflate.findViewById(R.id.cbSaveCardDetails)).setChecked(true);
        }
        return inflate;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f5301a.setSelected(false);
        this.s.setSelected(false);
        EditText editText = this.w;
        if (editText != null) {
            editText.setError(null);
        }
        EditText editText2 = this.x;
        if (editText2 != null) {
            editText2.setError(null);
        }
        if (view.getId() == R.id.spinner_month) {
            Utils.hideKeyBoard(view);
            this.s.setSelected(true);
            this.s.requestFocusFromTouch();
        } else if (view.getId() == R.id.spinner_year) {
            Utils.hideKeyBoard(view);
            this.f5301a.requestFocusFromTouch();
            this.f5301a.setSelected(true);
        }
        return false;
    }
}
