package com.xiaomi.smarthome.homeroom;

import _m_j.fbs;
import _m_j.fbt;
import _m_j.fkv;
import _m_j.fru;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ftn;
import _m_j.fux;
import _m_j.gfr;
import _m_j.ggb;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.hah;
import _m_j.hjk;
import _m_j.hpv;
import _m_j.hxi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONObject;

public class HomeRoomCreatHomeActivity extends BaseActivity implements TextWatcher, View.OnClickListener {
    private static final String O00000Oo = "HomeRoomCreatHomeActivity";

    /* renamed from: O000000o  reason: collision with root package name */
    hah.O000000o f8873O000000o = new hah.O000000o() {
        /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass4 */

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(str)) {
                HomeRoomCreatHomeActivity.this.mNameTv.setText(str);
            }
        }

        public final String O00000Oo(String str) {
            if (ggb.O00000Oo().O0000o0o(str)) {
                return HomeRoomCreatHomeActivity.this.getString(R.string.home_name_duplicate);
            }
            return null;
        }
    };
    private View O00000o;
    private View O00000o0;
    private TextView O00000oO;
    private View O00000oo;
    private Home.O000000o O0000O0o;
    private View O0000OOo;
    public double latitude;
    public double longitude;
    public TextView mNameTv;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_home_room_creat_home);
        this.O0000O0o = new Home.O000000o();
        this.O00000oO = (TextView) findViewById(R.id.home_loc_tv);
        this.O00000oO.addTextChangedListener(this);
        this.mNameTv = (TextView) findViewById(R.id.name_tv);
        this.mNameTv.addTextChangedListener(this);
        this.O0000OOo = findViewById(R.id.home_name_container);
        this.O0000OOo.setOnClickListener(this);
        this.O00000o0 = findViewById(R.id.btn_return);
        this.O00000o0.setOnClickListener(this);
        this.O00000o = findViewById(R.id.confirm);
        this.O00000o.setEnabled(false);
        this.O00000o.setOnClickListener(this);
        this.O00000oo = findViewById(R.id.home_loc_container);
        this.O00000oo.setOnClickListener(this);
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || isGoogleplayChannel()) {
            this.O00000oo.setVisibility(8);
            findViewById(R.id.add_home_addr_hint).setVisibility(8);
        }
    }

    public static boolean isGoogleplayChannel() {
        return "GooglePlay".toLowerCase().equals(gfr.O00000o.toLowerCase());
    }

    public void createHome() {
        if (TextUtils.isEmpty(this.mNameTv.getText()) || (TextUtils.isEmpty(this.O00000oO.getText()) && this.O00000oo.getVisibility() == 0)) {
            gqg.O00000Oo((int) R.string.add_failed);
            return;
        }
        Home.O000000o o000000o = this.O0000O0o;
        o000000o.O0000O0o = this.mNameTv.getText().toString();
        o000000o.O0000o0O = Long.parseLong(CoreApi.O000000o().O0000o0());
        final Home O000000o2 = o000000o.O000000o();
        if (TextUtils.isEmpty(O000000o2.getLocationId())) {
            gsy.O00000o0(LogType.HOME_ROOM, "location", "get city id failed 1");
            gqg.O00000Oo((int) R.string.add_failed);
            return;
        }
        ggb O00000Oo2 = ggb.O00000Oo();
        AnonymousClass1 r2 = new ggb.O00000o() {
            /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass1 */

            public final void O000000o() {
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(HomeRoomCreatHomeActivity.this);
                builder.O00000o0();
                builder.O000000o((int) R.string.setting_now, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass1.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ggb.O00000Oo().O000000o(O000000o2.getId(), (fsm) null);
                        dialogInterface.dismiss();
                        HomeRoomCreatHomeActivity.this.finish();
                        MultiHomeManagerActivity.finishActivity();
                        HomeEditorActivity.finishActivity();
                        HomeRoomManageListActivity.startActivity(HomeRoomCreatHomeActivity.this.getContext(), O000000o2.getId());
                        HomeRoomCreatHomeActivity.this.mHandler.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                HomeRoomRecommendActivity.startActivity(HomeRoomCreatHomeActivity.this.getContext(), O000000o2.getId());
                            }
                        }, 100);
                    }
                });
                builder.O00000Oo((int) R.string.setting_after, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass1.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (O000000o2 != null) {
                            ggb.O00000Oo().O000000o(O000000o2.getId(), (fsm) null);
                            dialogInterface.dismiss();
                            HomeRoomCreatHomeActivity.this.finish();
                            HomeRoomCreatHomeActivity.this.mHandler.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass1.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    fbt fbt = new fbt(HomeRoomCreatHomeActivity.this, "SmartHomeMainActivity");
                                    fbt.O00000Oo(335544320);
                                    fbs.O000000o(fbt);
                                    HomeRoomCreatHomeActivity.this.overridePendingTransition(0, 0);
                                }
                            }, 100);
                            SharedPreferences.Editor edit = CommonApplication.getAppContext().getSharedPreferences("home_room_transfer_state", 0).edit();
                            edit.putBoolean("multihome_first_guide" + O000000o2.getId(), true).apply();
                        }
                    }
                });
                builder.O000000o(false);
                String string = CommonApplication.getAppContext().getString(R.string.title_add_home_successful);
                ggb.O00000Oo();
                builder.O000000o(String.format(string, ggb.O000000o(O000000o2)));
                builder.O00000Oo((int) R.string.message_add_home_successful);
                builder.O00000oo();
            }

            public final void O000000o(int i, fso fso) {
                gqg.O00000Oo((int) R.string.add_failed);
            }
        };
        ggb.O00000Oo o00000Oo = O00000Oo2.O0000OoO;
        if (!ggb.O0000Oo0(ggb.O000000o(O000000o2))) {
            r2.O000000o(1, null);
        } else {
            fru.O000000o().O000000o(O000000o2, new fsm<JSONObject, fso>(O000000o2, r2) {
                /* class _m_j.ggb.O00000Oo.AnonymousClass16 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Home f17700O000000o;
                final /* synthetic */ O00000o O00000Oo;

                {
                    this.f17700O000000o = r2;
                    this.O00000Oo = r3;
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject != null && !jSONObject.isNull("result")) {
                        this.f17700O000000o.setId(jSONObject.optString("result"));
                        for (int i = 0; i < this.f17700O000000o.getRoomList().size(); i++) {
                            Room room = this.f17700O000000o.getRoomList().get(i);
                            String parentid = room.getParentid();
                            O00000Oo.this.f17692O000000o.get(parentid).remove(room);
                            for (int i2 = 0; i2 < O00000Oo.this.O00000Oo.size(); i2++) {
                                if (TextUtils.equals(O00000Oo.this.O00000Oo.get(i2).getId(), parentid)) {
                                    O00000Oo.this.O00000Oo.get(i2).getRoomList().remove(room);
                                }
                            }
                            room.setParentid(this.f17700O000000o.getId());
                        }
                        O00000Oo.this.f17692O000000o.put(this.f17700O000000o.getId(), this.f17700O000000o.getRoomList());
                        if (!O00000Oo.this.O00000Oo.contains(this.f17700O000000o)) {
                            O00000Oo.this.O00000Oo.add(this.f17700O000000o);
                        }
                        O00000Oo.this.O000000o();
                        O00000o o00000o = this.O00000Oo;
                        if (o00000o != null) {
                            o00000o.O000000o();
                        }
                        O00000Oo.O000000o("home_room_home_added", ErrorCode.SUCCESS.getCode());
                    }
                }

                public final void onFailure(fso fso) {
                    O00000o o00000o = this.O00000Oo;
                    if (o00000o != null) {
                        o00000o.O000000o(2, fso);
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        if (!TextUtils.isEmpty(this.O00000oO.getText()) || !TextUtils.isEmpty(this.mNameTv.getText())) {
            new MLAlertDialog.Builder(this).O00000o0().O00000Oo((int) R.string.home_dump_data_prompt_description).O000000o((int) R.string.exit, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    HomeRoomCreatHomeActivity.this.finish();
                }
            }).O00000Oo((int) R.string.keep_on_edit, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeRoomCreatHomeActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O00000oo();
        } else {
            super.onBackPressed();
        }
    }

    public void onClick(View view) {
        if (view == this.O00000o0) {
            onBackPressed();
        } else if (view == this.O00000o) {
            createHome();
        } else if (view == this.O00000oo) {
            if (fux.O000000o(this)) {
                ExternalLoadManager.instance.loadExternal("amap2d", new fkv() {
                    /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeRoomCreatHomeActivity$omy2VlrONnjpeSZ7lo8UNtsRtGE */

                    public final Object call(Object obj) {
                        return HomeRoomCreatHomeActivity.this.O000000o((ExternalLoadManager.O000000o) obj);
                    }
                });
                hxi.O00000o.O0000OoO(1);
                return;
            }
            hxi.O00000o.O0000OoO(0);
        } else if (view == this.O0000OOo) {
            hah.O000000o(this, this.mNameTv.getText().toString(), getString(R.string.home_name_update), getString(R.string.input_home_hint), this.f8873O000000o);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1002 && intent != null) {
            this.longitude = intent.getDoubleExtra("longitude", 0.0d);
            this.latitude = intent.getDoubleExtra("latitude", 0.0d);
            String stringExtra = intent.getStringExtra("city_id");
            hpv O00000o02 = hjk.O00000o0(this.latitude, this.longitude);
            this.longitude = O00000o02.f511O000000o;
            this.latitude = O00000o02.O00000Oo;
            String stringExtra2 = intent.getStringExtra("home_address");
            if (!TextUtils.isEmpty(stringExtra2)) {
                this.O00000oO.setText(stringExtra2);
            } else {
                this.O00000oO.setText("");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.latitude);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.longitude);
            setLocation(stringExtra, sb2, sb3.toString());
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void setLocation(String str, String str2, String str3) {
        Home.O000000o o000000o = this.O0000O0o;
        o000000o.O0000OoO = str2;
        o000000o.O0000Ooo = str3;
        o000000o.O0000o0 = this.O00000oO.getText().toString();
        if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "0")) {
            this.O0000O0o.O0000o00 = str;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = true;
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO())) {
            this.O00000o.setEnabled(true ^ TextUtils.isEmpty(this.mNameTv.getText()));
            return;
        }
        View view = this.O00000o;
        if (TextUtils.isEmpty(this.O00000oO.getText()) || TextUtils.isEmpty(this.mNameTv.getText())) {
            z = false;
        }
        view.setEnabled(z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Integer O000000o(ExternalLoadManager.O000000o o000000o) throws RuntimeException {
        if (o000000o.f4013O000000o == 3) {
            Intent intent = new Intent();
            intent.setClassName(this, "com.xiaomi.smarthome.newui.amappoi.AmapSetHomeAddrActivity");
            startActivityForResult(intent, 1002);
        } else if (o000000o.f4013O000000o == 4) {
            gqg.O00000Oo((int) R.string.mapload_fail);
        }
        return Integer.valueOf(o000000o.f4013O000000o);
    }
}
