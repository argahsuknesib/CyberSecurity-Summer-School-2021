package com.xiaomi.smarthome.newui.amappoi;

import _m_j.gqg;
import _m_j.gwu;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.xiaomi.smarthome.R;

public class AmapSetHomeAddrActivity extends AmapGeofencingActivity {
    private boolean O0000O0o = true;
    private LocationBean O0000OOo = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public final void setView(Bundle bundle) {
        setContentView((int) R.layout.activity_amap_home_addr);
        this.O00000oO = findViewById(R.id.btn_confirm);
        O000000o(bundle);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.select_home_loc);
        O000000o();
        activate(null);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.newui.amappoi.$$Lambda$AmapSetHomeAddrActivity$ZSnKqQLT6wd6dX1I7oGEApexg */

            public final void onClick(View view) {
                AmapSetHomeAddrActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        if (TextUtils.isEmpty(this.O00000o.getText())) {
            gqg.O00000Oo((int) R.string.mj_map_out_china);
            return;
        }
        String O000000o2 = gwu.O000000o(this, this.O00000Oo.getProvince(), this.O00000Oo.getCity(), this.O00000Oo.getDistrict());
        String str = "";
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = gwu.O000000o(this, this.O00000Oo.getProvince(), this.O00000Oo.getCity(), str);
        }
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = gwu.O000000o(this, this.O00000Oo.getProvince(), str, str);
        }
        Intent intent = new Intent();
        intent.putExtra("longitude", this.O00000Oo.getLongitude());
        intent.putExtra("latitude", this.O00000Oo.getLatitude());
        if (O000000o2 != null) {
            intent.putExtra("city_id", O000000o2);
        }
        if (!TextUtils.isEmpty(this.O00000o.getText())) {
            str = this.O00000o.getText().toString();
        }
        intent.putExtra("home_address", str);
        setResult(-1, intent);
        finish();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && intent != null) {
            this.O0000OOo = (LocationBean) intent.getParcelableExtra("map_location");
            if (this.O0000OOo != null) {
                this.O00000Oo.setLongitude(this.O0000OOo.f10197O000000o);
                this.O00000Oo.setLatitude(this.O0000OOo.O00000Oo);
                this.O00000Oo.setProvince(this.O0000OOo.O00000oO);
                this.O00000Oo.setCity(this.O0000OOo.O00000oo);
                this.O00000Oo.setDistrict(this.O0000OOo.O0000O0o);
                this.O0000O0o = false;
                O000000o(this.O0000OOo);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void updateSearchTv(RegeocodeAddress regeocodeAddress) {
        if (isValid()) {
            if (this.O0000O0o) {
                this.O00000o.setText(regeocodeAddress.getFormatAddress());
                this.O00000Oo.setProvince(regeocodeAddress.getProvince());
                this.O00000Oo.setCity(regeocodeAddress.getCity());
                this.O00000Oo.setDistrict(regeocodeAddress.getDistrict());
                return;
            }
            if (this.O0000OOo != null) {
                this.O00000o.setText(this.O0000OOo.O00000o0);
            }
            this.O0000O0o = true;
            this.O0000OOo = null;
        }
    }
}
