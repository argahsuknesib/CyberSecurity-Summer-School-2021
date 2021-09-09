package com.xiaomi.smarthome.scene.newui.amappoi;

import _m_j.ggb;
import _m_j.gpc;
import _m_j.gqg;
import _m_j.gwu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.newui.amappoi.AmapGeofencingActivity;
import com.xiaomi.smarthome.newui.amappoi.LocationBean;

public class AmapRecSceneSetHomePage extends AmapGeofencingActivity {
    private boolean O0000O0o = true;
    private LocationBean O0000OOo = null;
    private boolean O0000Oo = false;
    private Home O0000Oo0;
    private TextView O0000OoO;

    /* access modifiers changed from: private */
    public static /* synthetic */ void O00000o(View view) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onResume() {
        super.onResume();
        this.f10176O000000o.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f10176O000000o.onPause();
        this.O00000oo.stopLocation();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f10176O000000o.onSaveInstanceState(bundle);
    }

    public void onDestroy() {
        this.f10176O000000o.onDestroy();
        if (this.O00000oo != null) {
            this.O00000oo.stopLocation();
            this.O00000oo.onDestroy();
        }
        super.onDestroy();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpc.O000000o(android.app.Activity, float):int
     arg types: [com.xiaomi.smarthome.scene.newui.amappoi.AmapRecSceneSetHomePage, int]
     candidates:
      _m_j.gpc.O000000o(android.content.Context, float):int
      _m_j.gpc.O000000o(android.view.View, int):void
      _m_j.gpc.O000000o(android.app.Activity, float):int */
    public final void setView(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("home_id");
        this.O0000Oo = getIntent().getBooleanExtra("is_pin_mode", false);
        this.O0000Oo0 = ggb.O00000Oo().O00000o(stringExtra);
        if (this.O0000Oo0 == null) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_amap_recscene_set_addr);
        this.O00000oO = findViewById(R.id.button1);
        findViewById(R.id.dialog_pannel).setOnClickListener($$Lambda$AmapRecSceneSetHomePage$iN2JUJVSvTTc84syWum1RzQlYI.INSTANCE);
        O000000o(bundle);
        this.O0000OoO = (TextView) findViewById(R.id.hint_text);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.newui.amappoi.$$Lambda$AmapRecSceneSetHomePage$__JwNKo791Xx3O8Ev4IR9oquUs0 */

            public final void onClick(View view) {
                AmapRecSceneSetHomePage.this.O00000o0(view);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.newui.amappoi.$$Lambda$AmapRecSceneSetHomePage$df_raPtHM8jwGHtQShhYIlaTppU */

            public final void onClick(View view) {
                AmapRecSceneSetHomePage.this.O00000Oo(view);
            }
        });
        findViewById(R.id.title_bar).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.newui.amappoi.$$Lambda$AmapRecSceneSetHomePage$vSk1etWsRgPpZeP5xFRY6q5xCb4 */

            public final void onClick(View view) {
                AmapRecSceneSetHomePage.this.O000000o(view);
            }
        });
        if (!(this.f10176O000000o == null || this.f10176O000000o.getMap() == null || this.f10176O000000o.getMap().getUiSettings() == null)) {
            this.f10176O000000o.getMap().getUiSettings().setZoomControlsEnabled(false);
        }
        O000000o();
        activate(null);
        if (this.O0000Oo) {
            this.O0000OoO.setText((int) R.string.add_home_addr_hint_coud);
            ImageView imageView = (ImageView) findViewById(R.id.geo_fencing_circle);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.height = gpc.O000000o((Activity) this, 86.0f);
            layoutParams.width = gpc.O000000o((Activity) this, 54.0f);
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.add_home_loc_pin);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
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
        if (!this.O0000Oo) {
            intent.putExtra("radius", this.O00000o0);
        }
        if (!TextUtils.isEmpty(this.O00000o.getText())) {
            str = this.O00000o.getText().toString();
        }
        intent.putExtra("home_address", str);
        intent.putExtra("home_addr", str);
        setResult(-1, intent);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
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

    public final void updateSearchTv(RegeocodeAddress regeocodeAddress) {
        if (isValid()) {
            if (this.O0000O0o) {
                this.O00000Oo.setProvince(regeocodeAddress.getProvince());
                this.O00000Oo.setCity(regeocodeAddress.getCity());
                this.O00000Oo.setDistrict(regeocodeAddress.getDistrict());
                if (regeocodeAddress.getPois() == null || regeocodeAddress.getPois().size() <= 0) {
                    this.O00000o.setText(regeocodeAddress.getFormatAddress());
                } else {
                    this.O00000o.setText(regeocodeAddress.getPois().get(0).getTitle());
                }
            } else {
                if (this.O0000OOo != null) {
                    this.O00000o.setText(this.O0000OOo.O00000o0);
                }
                this.O0000O0o = true;
                this.O0000OOo = null;
            }
        }
    }
}
