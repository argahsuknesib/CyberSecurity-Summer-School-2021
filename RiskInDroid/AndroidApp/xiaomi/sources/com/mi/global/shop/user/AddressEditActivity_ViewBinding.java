package com.mi.global.shop.user;

import android.view.View;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.SlidingButton;
import com.xiaomi.smarthome.R;

public class AddressEditActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private AddressEditActivity f4904O000000o;

    public AddressEditActivity_ViewBinding(AddressEditActivity addressEditActivity, View view) {
        this.f4904O000000o = addressEditActivity;
        addressEditActivity.nameView = Utils.findRequiredView(view, R.id.user_address_name, "field 'nameView'");
        addressEditActivity.pincodeView = Utils.findRequiredView(view, R.id.user_address_pincode, "field 'pincodeView'");
        addressEditActivity.addressView = Utils.findRequiredView(view, R.id.user_address_address, "field 'addressView'");
        addressEditActivity.cityView = Utils.findRequiredView(view, R.id.user_address_city, "field 'cityView'");
        addressEditActivity.landmarkView = Utils.findRequiredView(view, R.id.user_address_landmark, "field 'landmarkView'");
        addressEditActivity.emailView = Utils.findRequiredView(view, R.id.user_address_email, "field 'emailView'");
        addressEditActivity.phoneView = Utils.findRequiredView(view, R.id.user_address_phone, "field 'phoneView'");
        addressEditActivity.nameEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_nameinput, "field 'nameEdit'", CustomEditTextView.class);
        addressEditActivity.addressEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_addressinput, "field 'addressEdit'", CustomEditTextView.class);
        addressEditActivity.cityEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_cityinput, "field 'cityEdit'", CustomEditTextView.class);
        addressEditActivity.landmarkEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_landmarkinput, "field 'landmarkEdit'", CustomEditTextView.class);
        addressEditActivity.emailEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_emailinput, "field 'emailEdit'", CustomEditTextView.class);
        addressEditActivity.phoneEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_phoneinput, "field 'phoneEdit'", CustomEditTextView.class);
        addressEditActivity.pincodeEdit = (CustomEditTextView) Utils.findRequiredViewAsType(view, R.id.user_address_pincodeinput, "field 'pincodeEdit'", CustomEditTextView.class);
        addressEditActivity.pincodeWarningView = (CustomTextView) Utils.findRequiredViewAsType(view, R.id.user_address_pincodewarning, "field 'pincodeWarningView'", CustomTextView.class);
        addressEditActivity.defaultAddressView = Utils.findRequiredView(view, R.id.default_address, "field 'defaultAddressView'");
        addressEditActivity.addressDefaultSwitch = (SlidingButton) Utils.findRequiredViewAsType(view, R.id.user_address_default_switch, "field 'addressDefaultSwitch'", SlidingButton.class);
        addressEditActivity.saveBtn = (CustomButtonView) Utils.findRequiredViewAsType(view, R.id.user_address_save, "field 'saveBtn'", CustomButtonView.class);
        addressEditActivity.stateSpinner = (Spinner) Utils.findRequiredViewAsType(view, R.id.user_address_statespinner, "field 'stateSpinner'", Spinner.class);
    }

    public void unbind() {
        AddressEditActivity addressEditActivity = this.f4904O000000o;
        if (addressEditActivity != null) {
            this.f4904O000000o = null;
            addressEditActivity.nameView = null;
            addressEditActivity.pincodeView = null;
            addressEditActivity.addressView = null;
            addressEditActivity.cityView = null;
            addressEditActivity.landmarkView = null;
            addressEditActivity.emailView = null;
            addressEditActivity.phoneView = null;
            addressEditActivity.nameEdit = null;
            addressEditActivity.addressEdit = null;
            addressEditActivity.cityEdit = null;
            addressEditActivity.landmarkEdit = null;
            addressEditActivity.emailEdit = null;
            addressEditActivity.phoneEdit = null;
            addressEditActivity.pincodeEdit = null;
            addressEditActivity.pincodeWarningView = null;
            addressEditActivity.defaultAddressView = null;
            addressEditActivity.addressDefaultSwitch = null;
            addressEditActivity.saveBtn = null;
            addressEditActivity.stateSpinner = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
