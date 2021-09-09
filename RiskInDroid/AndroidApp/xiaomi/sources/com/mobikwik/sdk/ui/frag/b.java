package com.mobikwik.sdk.ui.frag;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.mobikwik.sdk.lib.utils.CardUtils;
import com.xiaomi.smarthome.R;

class b implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f5312a;

    b(a aVar) {
        this.f5312a = aVar;
    }

    public void afterTextChanged(Editable editable) {
        this.f5312a.q = CardUtils.detectType(editable.toString());
        this.f5312a.t.setFilters(new InputFilter.LengthFilter[]{"amex".equalsIgnoreCase(this.f5312a.q) ? new InputFilter.LengthFilter(4) : new InputFilter.LengthFilter(3)});
        if ("maestro".equalsIgnoreCase(this.f5312a.q)) {
            this.f5312a.getView().findViewById(R.id.text_maestro_note).setVisibility(0);
        } else {
            this.f5312a.getView().findViewById(R.id.text_maestro_note).setVisibility(8);
        }
        if (editable.toString().length() <= 12 || !this.f5312a.b(true)) {
            this.f5312a.v.setBackgroundResource(R.drawable.mk_cvv_text_bg);
        } else {
            this.f5312a.v.setBackgroundResource(R.drawable.mk_edit_text_bg);
        }
        if (this.f5312a.q.compareTo("visa") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.visa, 0);
        } else if (this.f5312a.q.compareTo("mastercard") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_master, 0);
        } else if (this.f5312a.q.compareTo("diners") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_diners, 0);
        } else if (this.f5312a.q.compareTo("discover") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_discover, 0);
        } else if (this.f5312a.q.compareTo("maestro") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_maestro, 0);
        } else if (this.f5312a.q.compareTo("amex") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_amex, 0);
        } else if (this.f5312a.q.compareTo("rupay") == 0) {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, (int) R.drawable.mk_rupay, 0);
        } else {
            this.f5312a.v.setCompoundDrawablesWithIntrinsicBounds((int) R.drawable.mk_ic_card, 0, 0, 0);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
