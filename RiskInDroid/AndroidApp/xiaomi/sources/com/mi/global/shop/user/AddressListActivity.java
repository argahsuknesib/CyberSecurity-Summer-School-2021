package com.mi.global.shop.user;

import _m_j.byl;
import _m_j.cak;
import _m_j.cam;
import _m_j.cav;
import _m_j.cbm;
import _m_j.ccr;
import _m_j.cec;
import _m_j.ced;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mi.global.shop.activity.BaseActivity;
import com.mi.global.shop.adapter.user.AddressListAdapter;
import com.mi.global.shop.newmodel.BaseResult;
import com.mi.global.shop.newmodel.NewSimpleResult;
import com.mi.global.shop.newmodel.user.address.NewAddressItem;
import com.mi.global.shop.newmodel.user.address.NewAddressResult;
import com.mi.global.shop.newmodel.user.address.NewRegionItem;
import com.mi.global.shop.newmodel.user.address.NewSetDefaultAddressResult;
import com.mi.global.shop.widget.CustomButtonView;
import com.mi.global.shop.widget.dialog.CustomCancelDialog;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddressListActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f4905O000000o = "AddressListActivity";
    private String O00000Oo;
    private NewAddressItem O00000o;
    private String O00000o0;
    private ListView O00000oO;
    private AddressListAdapter O00000oo;
    private View O0000O0o;
    private CustomButtonView O0000OOo;
    public ArrayList<NewAddressItem> addressList;
    public String defaultAddressId;
    public ProgressDialog mProgressDialog;
    public ArrayList<NewRegionItem> regionList;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        O000000o((int) R.layout.shop_activity_address_list);
        setTitle((int) R.string.user_address_title);
        this.mCartView.setVisibility(8);
        this.mBackView.setVisibility(0);
        this.mBackView.setOnClickListener(this);
        Intent intent = getIntent();
        this.O00000Oo = intent.getStringExtra("com.mi.global.shop.extra_user_address_type");
        if (TextUtils.isEmpty(this.O00000Oo)) {
            ccr.O00000Oo(f4905O000000o, "addressType is null");
            finish();
        }
        String str = f4905O000000o;
        ccr.O00000Oo(str, "get addressType:" + this.O00000Oo);
        this.O0000O0o = findViewById(R.id.empty_view);
        this.O00000oO = (ListView) findViewById(R.id.address_list);
        this.O00000oO.setOnItemClickListener(this);
        this.O00000oo = new AddressListAdapter(this, this.O00000Oo);
        this.O00000oO.setAdapter((ListAdapter) this.O00000oo);
        this.O0000OOo = (CustomButtonView) findViewById(R.id.add_address_btn);
        this.O0000OOo.setOnClickListener(this);
        cbm.O00000o0.O000000o(byl.O00000oO(), "pref_address", "");
        if (this.O00000Oo.equalsIgnoreCase("address_manage")) {
            cam cam = new cam(cav.O00oOooo(), NewAddressResult.class, new cak<NewAddressResult>() {
                /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass4 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewAddressResult newAddressResult = (NewAddressResult) baseResult;
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                    AddressListActivity.this.addressList = newAddressResult.data.list;
                    AddressListActivity.this.regionList = newAddressResult.data.region;
                    AddressListActivity.this.updateView();
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                    AddressListActivity.this.finish();
                }
            });
            cam.setTag(f4905O000000o);
            ced.f13683O000000o.add(cam);
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage(getString(R.string.please_wait));
                this.mProgressDialog.setIndeterminate(true);
                this.mProgressDialog.setCancelable(false);
            }
            this.mProgressDialog.show();
        }
        if (this.O00000Oo.equalsIgnoreCase("address_choose")) {
            this.O00000o0 = intent.getStringExtra("address_id");
            String stringExtra = intent.getStringExtra("address_list");
            String stringExtra2 = intent.getStringExtra("region_list");
            Gson gson = new Gson();
            this.addressList = (ArrayList) gson.fromJson(stringExtra, new TypeToken<ArrayList<NewAddressItem>>() {
                /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass2 */
            }.getType());
            this.regionList = (ArrayList) gson.fromJson(stringExtra2, new TypeToken<ArrayList<NewRegionItem>>() {
                /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass3 */
            }.getType());
            updateView();
            ArrayList<NewAddressItem> arrayList = this.addressList;
            if (arrayList != null && arrayList.size() == 0) {
                onNewAddress();
            }
        }
    }

    public void updateView() {
        if (this.addressList != null && (!TextUtils.isEmpty(this.O00000o0) || !TextUtils.isEmpty(this.defaultAddressId))) {
            Iterator<NewAddressItem> it = this.addressList.iterator();
            while (it.hasNext()) {
                NewAddressItem next = it.next();
                if (!TextUtils.isEmpty(this.O00000o0)) {
                    if (next.address_id.equalsIgnoreCase(this.O00000o0)) {
                        next.selected = true;
                    } else {
                        next.selected = false;
                    }
                }
                if (!TextUtils.isEmpty(this.defaultAddressId)) {
                    if (next.address_id.equalsIgnoreCase(this.defaultAddressId)) {
                        next.is_default = NewAddressItem.DEFAULT_ADDRESS;
                    } else {
                        next.is_default = NewAddressItem.OTHER_ADDRESS;
                    }
                }
            }
        }
        this.O00000oo.O00000o0();
        this.O00000oo.O000000o((ArrayList) this.addressList);
        ArrayList<NewAddressItem> arrayList = this.addressList;
        if (arrayList == null || arrayList.size() == 0) {
            this.O0000O0o.setVisibility(0);
        } else {
            this.O0000O0o.setVisibility(8);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ccr.O00000Oo(f4905O000000o, "onItemClick, position:".concat(String.valueOf(i)));
        if (adapterView == this.O00000oO) {
            Object itemAtPosition = adapterView.getItemAtPosition(i);
            if (itemAtPosition instanceof NewAddressItem) {
                NewAddressItem newAddressItem = (NewAddressItem) itemAtPosition;
                String str = f4905O000000o;
                ccr.O00000Oo(str, "click add id:" + newAddressItem.address_id);
                if (this.O00000Oo.equalsIgnoreCase("address_manage")) {
                    gotoEditAddress(newAddressItem);
                }
                if (this.O00000Oo.equalsIgnoreCase("address_choose")) {
                    for (int i2 = 0; i2 < this.addressList.size(); i2++) {
                        if (this.addressList.get(i2).address_id.equalsIgnoreCase(newAddressItem.address_id)) {
                            this.addressList.get(i2).selected = true;
                        } else {
                            this.addressList.get(i2).selected = false;
                        }
                    }
                    this.O00000oo.O000000o((List) this.addressList);
                    this.O00000oo.notifyDataSetChanged();
                    returnOK(newAddressItem);
                }
            }
        }
    }

    public void gotoEditAddress(NewAddressItem newAddressItem) {
        if (newAddressItem != null || !TextUtils.isEmpty(newAddressItem.address_id)) {
            Intent intent = new Intent(this, AddressEditActivity.class);
            intent.putExtra("address_item", newAddressItem);
            intent.putExtra("com.mi.global.shop.extra_user_address_type", this.O00000Oo);
            intent.putParcelableArrayListExtra("region_list", this.regionList);
            startActivityForResult(intent, 100);
        }
    }

    public void setDefaultAddress(final String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri.Builder buildUpon = Uri.parse(cav.O000O0Oo()).buildUpon();
            buildUpon.appendQueryParameter("address_id", str);
            cam cam = new cam(buildUpon.toString(), NewSetDefaultAddressResult.class, new cak<NewSetDefaultAddressResult>() {
                /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass1 */

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    NewSetDefaultAddressResult newSetDefaultAddressResult = (NewSetDefaultAddressResult) baseResult;
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                    if (newSetDefaultAddressResult.data != null && newSetDefaultAddressResult.data.data) {
                        cec.O000000o(AddressListActivity.this, (int) R.string.user_address_default_success, 0);
                        AddressListActivity addressListActivity = AddressListActivity.this;
                        addressListActivity.defaultAddressId = str;
                        addressListActivity.updateView();
                    }
                }

                public final void O000000o(String str) {
                    super.O000000o(str);
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                }
            });
            cam.setTag(f4905O000000o);
            ced.f13683O000000o.add(cam);
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage(getString(R.string.please_wait));
                this.mProgressDialog.setIndeterminate(true);
                this.mProgressDialog.setCancelable(false);
            }
            this.mProgressDialog.show();
        }
    }

    public void returnOK(NewAddressItem newAddressItem) {
        Intent intent = new Intent();
        intent.putExtra("address_id", newAddressItem.address_id);
        intent.putExtra("name", newAddressItem.consignee);
        intent.putExtra("zipcode", newAddressItem.zipcode);
        intent.putExtra("tel", newAddressItem.tel);
        StringBuilder sb = new StringBuilder();
        sb.append(newAddressItem.can_cod);
        intent.putExtra("can_cod", sb.toString());
        intent.putExtra("limit", newAddressItem.limit);
        intent.putExtra("limit_cod", newAddressItem.limit_cod);
        intent.putExtra("address", newAddressItem.addr_india.addr);
        intent.putExtra("city", newAddressItem.addr_india.city);
        intent.putExtra("state", newAddressItem.city.name);
        intent.putExtra("city_id", newAddressItem.city.id);
        intent.putExtra("landmark", newAddressItem.addr_india.landmark);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(newAddressItem.is_invalid);
        intent.putExtra("is_invalid", sb2.toString());
        setResult(-1, intent);
        finish();
    }

    public void onResume() {
        super.onResume();
    }

    public void removeAddressList(String str) {
        if (!TextUtils.isEmpty(str) && this.addressList != null) {
            if (str.equals(this.defaultAddressId)) {
                this.defaultAddressId = "";
            }
            for (int i = 0; i < this.addressList.size(); i++) {
                if (str.equalsIgnoreCase(this.addressList.get(i).address_id)) {
                    this.addressList.remove(i);
                    updateView();
                    O00000Oo();
                    return;
                }
            }
        }
    }

    public void updateAddressItem(NewAddressItem newAddressItem) {
        if (this.addressList != null && newAddressItem != null) {
            if (newAddressItem.is_default == NewAddressItem.DEFAULT_ADDRESS) {
                this.defaultAddressId = newAddressItem.address_id;
            }
            if (!TextUtils.isEmpty(this.O00000o0) && this.O00000o0.equalsIgnoreCase(newAddressItem.address_id)) {
                this.O00000o = newAddressItem;
            }
            for (int i = 0; i < this.addressList.size(); i++) {
                if (newAddressItem.address_id.equalsIgnoreCase(this.addressList.get(i).address_id)) {
                    this.addressList.remove(i);
                    this.addressList.add(i, newAddressItem);
                    updateView();
                    O00000Oo();
                    return;
                }
            }
        }
    }

    public void delAddressRequest(final String str) {
        if (!TextUtils.isEmpty(str)) {
            Uri.Builder buildUpon = Uri.parse(cav.O000O0OO()).buildUpon();
            buildUpon.appendQueryParameter("addressId", str);
            cam cam = new cam(buildUpon.toString(), NewSimpleResult.class, new cak<NewSimpleResult>() {
                /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass5 */

                public final void O000000o(String str) {
                    super.O000000o(str);
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                }

                public final /* synthetic */ void O000000o(BaseResult baseResult) {
                    if (AddressListActivity.this.mProgressDialog != null) {
                        AddressListActivity.this.mProgressDialog.dismiss();
                    }
                    AddressListActivity.this.removeAddressList(str);
                }
            });
            cam.setTag(f4905O000000o);
            ced.f13683O000000o.add(cam);
            if (this.mProgressDialog == null) {
                this.mProgressDialog = new ProgressDialog(this);
                this.mProgressDialog.setMessage(getString(R.string.please_wait));
                this.mProgressDialog.setIndeterminate(true);
                this.mProgressDialog.setCancelable(false);
            }
            this.mProgressDialog.show();
        }
    }

    public void delAddressDialog(final String str) {
        CustomCancelDialog.Builder builder = new CustomCancelDialog.Builder(this);
        builder.f4982O000000o = getString(R.string.user_address_delpromote);
        builder.O000000o(Boolean.TRUE).O000000o(getString(R.string.user_address_confirm), new DialogInterface.OnClickListener() {
            /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                AddressListActivity.this.delAddressRequest(str);
            }
        }).O000000o(getString(R.string.user_address_cancel));
        builder.O000000o().show();
    }

    public void addAddressItem(final NewAddressItem newAddressItem) {
        if (this.addressList != null && newAddressItem != null) {
            if (newAddressItem.is_default == NewAddressItem.DEFAULT_ADDRESS) {
                this.defaultAddressId = newAddressItem.address_id;
            }
            this.addressList.add(0, newAddressItem);
            updateView();
            O00000Oo();
            if (this.O00000Oo.equalsIgnoreCase("address_choose")) {
                runOnUiThread(new Runnable() {
                    /* class com.mi.global.shop.user.AddressListActivity.AnonymousClass7 */

                    public final void run() {
                        AddressListActivity.this.returnOK(newAddressItem);
                    }
                });
            }
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.add_address_btn) {
            ccr.O00000Oo(f4905O000000o, "clicked new item");
            onNewAddress();
        }
        if (view.getId() == R.id.title_bar_back) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        NewAddressItem newAddressItem = this.O00000o;
        if (newAddressItem == null) {
            setResult(0);
            finish();
            return;
        }
        returnOK(newAddressItem);
    }

    private void O00000Oo() {
        if (this.addressList != null) {
            cbm.O00000o0.O000000o(byl.O00000oO(), "pref_address", new Gson().toJson(this.addressList));
        }
    }

    public void onNewAddress() {
        ccr.O00000Oo(f4905O000000o, "onCreateAddress:");
        Intent intent = new Intent(this, AddressEditActivity.class);
        intent.putExtra("com.mi.global.shop.extra_user_address_type", this.O00000Oo);
        intent.putParcelableArrayListExtra("region_list", this.regionList);
        startActivityForResult(intent, 100);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && intent != null && i2 == -1) {
            updateAddressItem((NewAddressItem) intent.getParcelableExtra("update_item"));
            addAddressItem((NewAddressItem) intent.getParcelableExtra("add_item"));
            removeAddressList(intent.getStringExtra("delete_item_id"));
        }
    }

    public void onDestroy() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        super.onDestroy();
    }
}
