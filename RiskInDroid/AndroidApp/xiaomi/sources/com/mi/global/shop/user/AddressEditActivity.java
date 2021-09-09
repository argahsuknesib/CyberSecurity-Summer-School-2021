package com.mi.global.shop.user;

import _m_j.byl;
import _m_j.cak;
import _m_j.cam;
import _m_j.cav;
import _m_j.ccr;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.user.address.NewAddressItem;
import com.mi.global.shop.newmodel.user.address.NewRegionItem;
import com.mi.global.shop.newmodel.user.address.NewSaveAddressResult;
import com.mi.global.shop.newmodel.user.address.NewZipCodeData;
import com.mi.global.shop.newmodel.user.address.NewZipCodeResult;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.CustomEditTextView;
import com.mi.global.shop.widget.CustomTextView;
import com.mi.global.shop.widget.SlidingButton;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public class AddressEditActivity extends BaseActivity implements View.OnClickListener {
    public static final String TAG = "AddressEditActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    String f4897O000000o;
    private ArrayAdapter<String> O00000Oo;
    private String O00000o;
    private String[] O00000o0;
    private TextWatcher O00000oO = new TextWatcher() {
        /* class com.mi.global.shop.user.AddressEditActivity.AnonymousClass2 */

        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() >= 6 && i == 5 && i2 == 0 && i3 == 1) {
                ccr.O00000Oo(AddressEditActivity.TAG, "manual input.clear foucs");
                if (AddressEditActivity.this.pincodeEdit != null) {
                    AddressEditActivity.this.pincodeEdit.clearFocus();
                }
                if (AddressEditActivity.this.addressEdit != null) {
                    AddressEditActivity.this.addressEdit.requestFocus();
                }
            }
        }
    };
    @BindView(2131494311)
    SlidingButton addressDefaultSwitch;
    @BindView(2131494308)
    CustomEditTextView addressEdit;
    @BindView(2131494307)
    View addressView;
    @BindView(2131494310)
    CustomEditTextView cityEdit;
    @BindView(2131494309)
    View cityView;
    @BindView(2131493253)
    View defaultAddressView;
    @BindView(2131494313)
    CustomEditTextView emailEdit;
    @BindView(2131494312)
    View emailView;
    @BindView(2131494315)
    CustomEditTextView landmarkEdit;
    @BindView(2131494314)
    View landmarkView;
    public ProgressDialog mProgressDialog;
    @BindView(2131494317)
    CustomEditTextView nameEdit;
    @BindView(2131494316)
    View nameView;
    public String parentId;
    @BindView(2131494319)
    CustomEditTextView phoneEdit;
    @BindView(2131494318)
    View phoneView;
    @BindView(2131494321)
    CustomEditTextView pincodeEdit;
    @BindView(2131494320)
    View pincodeView;
    @BindView(2131494322)
    CustomTextView pincodeWarningView;
    public ArrayList<NewRegionItem> regionList;
    @BindView(2131494323)
    CustomButtonView saveBtn;
    public NewAddressItem selectedAddressItem;
    @BindView(2131494325)
    Spinner stateSpinner;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_address_edit);
        ButterKnife.bind(this);
        this.mCartView.setVisibility(8);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(this);
        this.selectedAddressItem = (NewAddressItem) getIntent().getParcelableExtra("address_item");
        this.regionList = getIntent().getParcelableArrayListExtra("region_list");
        this.f4897O000000o = getIntent().getStringExtra("com.mi.global.shop.extra_user_address_type");
        if (this.selectedAddressItem == null) {
            setTitle((int) R.string.user_address_add);
        } else {
            setTitle((int) R.string.user_address_edit);
        }
        this.nameView.setOnClickListener(this);
        this.pincodeView.setOnClickListener(this);
        this.addressView.setOnClickListener(this);
        this.cityView.setOnClickListener(this);
        this.landmarkView.setOnClickListener(this);
        this.emailView.setOnClickListener(this);
        this.phoneView.setOnClickListener(this);
        this.saveBtn.setOnClickListener(this);
        NewAddressItem newAddressItem = this.selectedAddressItem;
        if (newAddressItem == null || newAddressItem.is_default != 1) {
            this.addressDefaultSwitch.setChecked(false);
            this.defaultAddressView.setVisibility(0);
        } else {
            this.addressDefaultSwitch.setChecked(true);
            this.defaultAddressView.setVisibility(8);
        }
        this.pincodeEdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class com.mi.global.shop.user.AddressEditActivity.AnonymousClass1 */

            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    String obj = AddressEditActivity.this.pincodeEdit.getText().toString();
                    if (!TextUtils.isEmpty(obj) && obj.length() == 6) {
                        AddressEditActivity.this.getZipCodeData(obj);
                    }
                }
            }
        });
        this.pincodeEdit.addTextChangedListener(this.O00000oO);
    }

    public void getZipCodeData(String str) {
        this.pincodeWarningView.setVisibility(8);
        Uri.Builder buildUpon = Uri.parse(cav.O00oOoOo()).buildUpon();
        buildUpon.appendQueryParameter("zipcode", str);
        cam cam = new cam(buildUpon.toString(), NewZipCodeResult.class, new cak<NewZipCodeResult>() {
            /* class com.mi.global.shop.user.AddressEditActivity.AnonymousClass3 */

            public final /* synthetic */ void O000000o(BaseResult baseResult) {
                AddressEditActivity.this.updateZipCodeView(((NewZipCodeResult) baseResult).data);
            }

            public final void O000000o(String str) {
                AddressEditActivity.this.pincodeWarningView.setVisibility(0);
                AddressEditActivity.this.saveBtn.setEnabled(false);
            }
        });
        cam.setTag(TAG);
        ced.f13683O000000o.add(cam);
    }

    public void updateZipCodeView(NewZipCodeData newZipCodeData) {
        if (newZipCodeData != null) {
            this.parentId = newZipCodeData.parent_id;
            this.O00000o = newZipCodeData.region_id;
            String str = newZipCodeData.citys;
            if (!TextUtils.isEmpty(str)) {
                this.cityEdit.setText(str);
            }
            if (!TextUtils.isEmpty(this.parentId)) {
                String str2 = null;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= this.regionList.size()) {
                        break;
                    } else if (this.regionList.get(i2).region_id.equalsIgnoreCase(this.parentId)) {
                        str2 = this.regionList.get(i2).region_name;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    while (true) {
                        String[] strArr = this.O00000o0;
                        if (i >= strArr.length) {
                            break;
                        } else if (strArr[i].equalsIgnoreCase(str2)) {
                            this.stateSpinner.setSelection(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            this.pincodeWarningView.setVisibility(8);
            this.saveBtn.setEnabled(true);
        }
    }

    private void O00000Oo(int i) {
        Toast makeText = Toast.makeText(this, i, 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    public void onClick(View view) {
        boolean z;
        String str;
        int id = view.getId();
        if (id == R.id.user_address_save) {
            ccr.O00000Oo(TAG, "confirm clicked");
            ccr.O00000Oo(TAG, "clearWarning");
            this.pincodeWarningView.setVisibility(8);
            String obj = this.nameEdit.getText().toString();
            if (TextUtils.isEmpty(obj) || obj.length() < 2) {
                this.nameEdit.requestFocus();
                O00000Oo(R.string.user_address_namewarning);
            } else if (!this.pincodeEdit.getText().toString().matches("^[0-9]{6}$")) {
                this.pincodeEdit.requestFocus();
                this.pincodeWarningView.setVisibility(0);
                O00000Oo(R.string.user_address_pincodewarning);
            } else {
                String obj2 = this.addressEdit.getText().toString();
                if (TextUtils.isEmpty(obj2) || obj2.length() < 5) {
                    this.addressEdit.requestFocus();
                    O00000Oo(R.string.user_address_addresswarning);
                } else {
                    String obj3 = this.emailEdit.getText().toString();
                    if (!obj3.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$") && !obj3.contains("*")) {
                        this.emailEdit.requestFocus();
                        O00000Oo(R.string.user_address_emailwarning);
                    } else if (!this.phoneEdit.getText().toString().matches("^[0-9]{10}$")) {
                        this.phoneEdit.requestFocus();
                        O00000Oo(R.string.user_address_phonewarning);
                    } else {
                        z = true;
                        if (!z) {
                            HashMap hashMap = new HashMap();
                            NewAddressItem newAddressItem = this.selectedAddressItem;
                            if (newAddressItem != null) {
                                hashMap.put("addressId", newAddressItem.address_id);
                            } else {
                                hashMap.put("addressId", "0");
                            }
                            String obj4 = this.nameEdit.getText().toString();
                            String obj5 = this.phoneEdit.getText().toString();
                            String obj6 = this.emailEdit.getText().toString();
                            String obj7 = this.pincodeEdit.getText().toString();
                            String obj8 = this.cityEdit.getText().toString();
                            String obj9 = this.addressEdit.getText().toString();
                            String obj10 = this.landmarkEdit.getText().toString();
                            this.stateSpinner.getSelectedItem();
                            String str2 = "";
                            if (!TextUtils.isEmpty(this.O00000o)) {
                                str = this.O00000o;
                            } else {
                                NewAddressItem newAddressItem2 = this.selectedAddressItem;
                                str = (newAddressItem2 == null || newAddressItem2.district == null) ? str2 : this.selectedAddressItem.district.id;
                            }
                            if (!TextUtils.isEmpty(this.parentId)) {
                                str2 = this.parentId;
                            }
                            hashMap.put("address[zipcode]", obj7);
                            hashMap.put("address[consignee]", obj4);
                            hashMap.put("address[address_line1]", obj8);
                            hashMap.put("address[address_line2]", obj9);
                            hashMap.put("address[city]", str2);
                            hashMap.put("address[state]", str2);
                            hashMap.put("address[tel]", obj5);
                            hashMap.put("address[landmark]", obj10);
                            hashMap.put("address[email]", obj6);
                            hashMap.put("address[district]", str);
                            hashMap.put("is_default", String.valueOf(this.addressDefaultSwitch.isChecked() ? NewAddressItem.DEFAULT_ADDRESS : NewAddressItem.OTHER_ADDRESS));
                            cam cam = new cam(cav.O000O00o(), NewSaveAddressResult.class, hashMap, new cak<NewSaveAddressResult>() {
                                /* class com.mi.global.shop.user.AddressEditActivity.AnonymousClass5 */

                                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                                    NewSaveAddressResult newSaveAddressResult = (NewSaveAddressResult) baseResult;
                                    if (AddressEditActivity.this.mProgressDialog != null) {
                                        AddressEditActivity.this.mProgressDialog.dismiss();
                                    }
                                    if (newSaveAddressResult.data != null && newSaveAddressResult.data.addinfo != null) {
                                        Intent intent = new Intent();
                                        if (AddressEditActivity.this.selectedAddressItem == null) {
                                            intent.putExtra("add_item", newSaveAddressResult.data.addinfo);
                                        } else {
                                            intent.putExtra("update_item", newSaveAddressResult.data.addinfo);
                                        }
                                        AddressEditActivity.this.setResult(-1, intent);
                                        AddressEditActivity.this.finish();
                                    }
                                }

                                /* access modifiers changed from: private */
                                /* renamed from: O000000o */
                                public void onResponse(NewSaveAddressResult newSaveAddressResult) {
                                    if (newSaveAddressResult == null) {
                                        O000000o(AddressEditActivity.this.getString(R.string.shop_error_network));
                                        return;
                                    }
                                    if (newSaveAddressResult.data != null && !TextUtils.isEmpty(newSaveAddressResult.data.errors)) {
                                        String parseSaveAddressErrors = AddressEditActivity.this.parseSaveAddressErrors(newSaveAddressResult.data.errors);
                                        if (!TextUtils.isEmpty(parseSaveAddressErrors)) {
                                            O000000o(parseSaveAddressErrors);
                                            return;
                                        }
                                    }
                                    super.onResponse(newSaveAddressResult);
                                }

                                public final void O000000o(String str) {
                                    super.O000000o(str);
                                    if (AddressEditActivity.this.mProgressDialog != null) {
                                        AddressEditActivity.this.mProgressDialog.dismiss();
                                    }
                                }
                            });
                            cam.setTag(TAG);
                            ced.f13683O000000o.add(cam);
                            if (this.mProgressDialog == null) {
                                this.mProgressDialog = new ProgressDialog(this);
                                this.mProgressDialog.setMessage(getString(R.string.please_wait));
                                this.mProgressDialog.setIndeterminate(true);
                                this.mProgressDialog.setCancelable(false);
                            }
                            this.mProgressDialog.show();
                            return;
                        }
                        return;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        } else if (id == R.id.title_bar_back) {
            ProgressDialog progressDialog = this.mProgressDialog;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            onBackPressed();
        } else if (id == R.id.user_address_name) {
            O000000o(this.nameEdit);
        } else if (id == R.id.user_address_pincode) {
            O000000o(this.pincodeEdit);
        } else if (id == R.id.user_address_address) {
            O000000o(this.addressEdit);
        } else if (id == R.id.user_address_city) {
            O000000o(this.cityEdit);
        } else if (id == R.id.user_address_landmark) {
            O000000o(this.landmarkEdit);
        } else if (id == R.id.user_address_email) {
            O000000o(this.emailEdit);
        } else if (id == R.id.user_address_phone) {
            O000000o(this.phoneEdit);
        }
    }

    private void O000000o(View view) {
        if (view != null) {
            view.requestFocus();
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    public void onBackPressed() {
        if (hasEditAddress()) {
            CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
            builder.f4982O000000o = getString(R.string.user_address_discardpromote);
            builder.O000000o(Boolean.TRUE).O000000o(getString(R.string.user_address_discard), new DialogInterface.OnClickListener() {
                /* class com.mi.global.shop.user.AddressEditActivity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AddressEditActivity.this.finish();
                }
            }).O000000o(getString(R.string.user_address_cancel));
            builder.O000000o().show();
            return;
        }
        super.onBackPressed();
    }

    public boolean hasEditAddress() {
        NewAddressItem newAddressItem = this.selectedAddressItem;
        if (newAddressItem == null) {
            return !TextUtils.isEmpty(this.nameEdit.getText().toString()) || !TextUtils.isEmpty(this.pincodeEdit.getText().toString()) || !TextUtils.isEmpty(this.addressEdit.getText().toString()) || !TextUtils.isEmpty(this.landmarkEdit.getText().toString()) || !TextUtils.isEmpty(this.cityEdit.getText().toString()) || !TextUtils.isEmpty(this.stateSpinner.getSelectedItem().toString()) || !TextUtils.isEmpty(this.emailEdit.getText().toString()) || !TextUtils.isEmpty(this.phoneEdit.getText().toString()) || this.addressDefaultSwitch.isChecked();
        }
        if (TextUtils.equals(newAddressItem.consignee, this.nameEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.zipcode, this.pincodeEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.addr_india.addr, this.addressEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.addr_india.landmark, this.landmarkEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.addr_india.city, this.cityEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.email, this.emailEdit.getText().toString()) && TextUtils.equals(this.selectedAddressItem.tel, this.phoneEdit.getText().toString())) {
            return this.selectedAddressItem.is_default != (this.addressDefaultSwitch.isChecked() ? NewAddressItem.DEFAULT_ADDRESS : NewAddressItem.OTHER_ADDRESS);
        }
    }

    public void onResume() {
        String[] strArr;
        ccr.O00000Oo(TAG, "onResume");
        ccr.O00000Oo(TAG, "updateView");
        NewAddressItem newAddressItem = this.selectedAddressItem;
        int i = 0;
        if (this.regionList != null) {
            String str = TAG;
            ccr.O00000Oo(str, "update regionList:" + this.regionList.size());
            this.O00000o0 = new String[(this.regionList.size() + 1)];
            this.O00000o0[0] = "";
            int i2 = 1;
            while (true) {
                strArr = this.O00000o0;
                if (i2 >= strArr.length) {
                    break;
                }
                strArr[i2] = this.regionList.get(i2 - 1).region_name;
                i2++;
            }
            if (strArr.length > 1) {
                Arrays.sort(strArr, 1, strArr.length);
            }
            this.O00000Oo = new ArrayAdapter<>(byl.O00000oO(), (int) R.layout.shop_buy_confirm_payment_spinner_default_item, this.O00000o0);
            this.O00000Oo.setDropDownViewResource(R.layout.shop_buy_confirm_payment_spinneritem);
            this.stateSpinner.setAdapter((SpinnerAdapter) this.O00000Oo);
            this.stateSpinner.setOnItemSelectedListener(new O000000o());
        }
        if (newAddressItem != null) {
            ccr.O00000Oo(TAG, "fill address");
            this.nameEdit.setText(newAddressItem.consignee);
            this.pincodeEdit.setText(newAddressItem.zipcode);
            this.addressEdit.setText(newAddressItem.addr_india.addr);
            this.landmarkEdit.setText(newAddressItem.addr_india.landmark);
            this.cityEdit.setText(newAddressItem.addr_india.city);
            this.emailEdit.setText(newAddressItem.email);
            this.phoneEdit.setText(newAddressItem.tel);
            if (!TextUtils.isEmpty(newAddressItem.city.name)) {
                while (true) {
                    String[] strArr2 = this.O00000o0;
                    if (i >= strArr2.length) {
                        break;
                    } else if (strArr2[i].equalsIgnoreCase(newAddressItem.city.name)) {
                        this.stateSpinner.setSelection(i);
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        ccr.O00000Oo(TAG, "updateView finish");
        super.onResume();
    }

    public String parseSaveAddressErrors(String str) {
        StringBuilder sb = new StringBuilder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                sb.append(jSONObject.optString(keys.next().toString()));
                sb.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    class O000000o implements AdapterView.OnItemSelectedListener {
        public final void onNothingSelected(AdapterView<?> adapterView) {
        }

        O000000o() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            ccr.O00000Oo(AddressEditActivity.TAG, "onItemSelected position:".concat(String.valueOf(i)));
            String obj = AddressEditActivity.this.stateSpinner.getItemAtPosition(i).toString();
            for (int i2 = 0; i2 < AddressEditActivity.this.regionList.size(); i2++) {
                NewRegionItem newRegionItem = AddressEditActivity.this.regionList.get(i2);
                if (obj.equalsIgnoreCase(newRegionItem.region_name)) {
                    AddressEditActivity.this.parentId = newRegionItem.region_id;
                }
            }
        }
    }
}
