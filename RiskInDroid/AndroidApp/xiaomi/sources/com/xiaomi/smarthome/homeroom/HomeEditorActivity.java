package com.xiaomi.smarthome.homeroom;

import _m_j.eza;
import _m_j.ezc;
import _m_j.fkv;
import _m_j.fsm;
import _m_j.fso;
import _m_j.ft;
import _m_j.ftn;
import _m_j.fux;
import _m_j.fuy;
import _m_j.ggb;
import _m_j.ggc;
import _m_j.ggh;
import _m_j.gqg;
import _m_j.gwc;
import _m_j.gwq;
import _m_j.gwr;
import _m_j.gwu;
import _m_j.gyl;
import _m_j.hah;
import _m_j.hjk;
import _m_j.hpv;
import _m_j.hxi;
import _m_j.hxk;
import _m_j.hxp;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.PointF;
import android.location.Address;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.ExternalLoadManager;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.family.HomeMemberDetailsActivity;
import com.xiaomi.smarthome.family.ShareHomeActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.homeroom.HomeEditorActivity;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.HomeMember;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public class HomeEditorActivity extends BaseActivity {
    public static WeakReference<HomeEditorActivity> sActivityRef;

    /* renamed from: O000000o  reason: collision with root package name */
    boolean f8844O000000o = false;
    hah.O000000o O00000Oo = new hah.O000000o() {
        /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass8 */

        public final void O000000o(String str) {
            if (!TextUtils.isEmpty(str)) {
                HomeEditorActivity.this.saveHomeName(str);
            }
        }

        public final String O00000Oo(String str) {
            if (ggb.O00000Oo().O0000o0o(str)) {
                return HomeEditorActivity.this.getString(R.string.home_name_duplicate);
            }
            return null;
        }
    };
    private TextView O00000o;
    private View O00000o0;
    private View O00000oO;
    private ListView O00000oo;
    private List<String> O0000O0o = new ArrayList();
    private BroadcastReceiver O0000OOo = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass1 */

        public final void onReceive(Context context, Intent intent) {
            if (TextUtils.equals(intent.getAction(), "update_area_info_action")) {
                if (HomeEditorActivity.this.mUpdateHomeLoc) {
                    HomeEditorActivity.this.updateHomeLocation();
                }
                HomeEditorActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.ggb.O000000o(_m_j.fuy$O000000o, boolean, com.xiaomi.smarthome.homeroom.model.Home):java.lang.String
                     arg types: [com.xiaomi.smarthome.homeroom.HomeEditorActivity$1$1$1, int, com.xiaomi.smarthome.homeroom.model.Home]
                     candidates:
                      _m_j.ggb.O000000o(android.content.Context, java.lang.String, java.lang.String):void
                      _m_j.ggb.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, _m_j.ggb$O00000o):void
                      _m_j.ggb.O000000o(java.lang.String, java.lang.String, java.util.List<java.lang.String>):void
                      _m_j.ggb.O000000o(java.util.Set<java.lang.String>, java.lang.String, _m_j.ggb$O00000o):void
                      _m_j.ggb.O000000o(com.xiaomi.smarthome.homeroom.model.Room, java.lang.String, java.lang.String):boolean
                      _m_j.ggb.O000000o(_m_j.fuy$O000000o, boolean, com.xiaomi.smarthome.homeroom.model.Home):java.lang.String */
                    public final void run() {
                        if (HomeEditorActivity.this.isValid()) {
                            String O000000o2 = ggb.O00000Oo().O000000o((fuy.O000000o) new fuy.O000000o() {
                                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void O000000o(String str, Location location) {
                                    Bundle extras;
                                    gwr O000000o2;
                                    if (HomeEditorActivity.this.isValid() && (extras = location.getExtras()) != null && (O000000o2 = gwu.O000000o(CommonApplication.getAppContext(), (Address) extras.getParcelable("address"))) != null) {
                                        HomeEditorActivity.this.mLocTv.setText(O000000o2.O00000Oo);
                                    }
                                }
                            }, false, HomeEditorActivity.this.mHome);
                            if (!TextUtils.isEmpty(O000000o2)) {
                                HomeEditorActivity.this.mLocTv.setText(O000000o2);
                            }
                        }
                    }
                });
            }
        }
    };
    private SimpleDraweeView O0000Oo0;
    public boolean deletable = false;
    public O000000o homeMemberAdapter;
    public Dialog mDialog;
    public Home mHome;
    public String mHomeId;
    public TextView mHomeNameTv;
    public TextView mLocTv;
    public XQProgressDialog mProcessDialog;
    public boolean mUpdateHomeLoc = false;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.widget.ListView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ggb.O000000o(_m_j.fuy$O000000o, boolean, com.xiaomi.smarthome.homeroom.model.Home):java.lang.String
     arg types: [com.xiaomi.smarthome.homeroom.HomeEditorActivity$13, int, com.xiaomi.smarthome.homeroom.model.Home]
     candidates:
      _m_j.ggb.O000000o(android.content.Context, java.lang.String, java.lang.String):void
      _m_j.ggb.O000000o(com.xiaomi.smarthome.homeroom.model.Home, java.util.List<java.lang.String>, _m_j.ggb$O00000o):void
      _m_j.ggb.O000000o(java.lang.String, java.lang.String, java.util.List<java.lang.String>):void
      _m_j.ggb.O000000o(java.util.Set<java.lang.String>, java.lang.String, _m_j.ggb$O00000o):void
      _m_j.ggb.O000000o(com.xiaomi.smarthome.homeroom.model.Room, java.lang.String, java.lang.String):boolean
      _m_j.ggb.O000000o(_m_j.fuy$O000000o, boolean, com.xiaomi.smarthome.homeroom.model.Home):java.lang.String */
    public void onCreate(Bundle bundle) {
        Locale locale;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        ggb O00000Oo2 = ggb.O00000Oo();
        this.mHomeId = intent.getStringExtra("home_id");
        if (TextUtils.isEmpty(this.mHomeId)) {
            this.mHomeId = O00000Oo2.O0000OOo();
        }
        this.mHome = O00000Oo2.O00000o(this.mHomeId);
        List<Device> O0000Oo = O00000Oo2.O0000Oo(this.mHomeId);
        if (O00000Oo2.O0000OoO.O00000Oo.size() > 1 && O0000Oo.size() <= 0) {
            this.deletable = true;
        }
        ft.O000000o(this).O000000o(this.O0000OOo, new IntentFilter("update_area_info_action"));
        setContentView((int) R.layout.activity_home_editor_layout);
        findViewById(R.id.module_a_3_right_img_btn).setVisibility(8);
        findViewById(R.id.top_divider).setVisibility(8);
        findViewById(R.id.bottom_divider).setVisibility(8);
        ((TextView) findViewById(R.id.title_left)).setText((int) R.string.home_member);
        this.O00000oO = findViewById(R.id.home_name_container);
        final Home O00000o2 = ggb.O00000Oo().O00000o(this.mHomeId);
        this.O00000oO.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass9 */

            public final void onClick(View view) {
                String str;
                Home home = O00000o2;
                if (home == null || home.isOwner()) {
                    hxi.O00000o.f952O000000o.O000000o("home_management_editname", new Object[0]);
                    if (O00000o2 != null) {
                        ggb.O00000Oo();
                        str = ggb.O000000o(O00000o2);
                    } else {
                        str = "";
                    }
                    if (HomeEditorActivity.this.mDialog != null && HomeEditorActivity.this.mDialog.isShowing()) {
                        HomeEditorActivity.this.mDialog.dismiss();
                    }
                    HomeEditorActivity homeEditorActivity = HomeEditorActivity.this;
                    homeEditorActivity.mDialog = hah.O000000o(homeEditorActivity.getContext(), str, HomeEditorActivity.this.getString(R.string.home_name_update), HomeEditorActivity.this.getString(R.string.input_home_hint), HomeEditorActivity.this.O00000Oo);
                }
            }
        });
        this.mHomeNameTv = (TextView) this.O00000oO.findViewById(R.id.name_tv);
        if (O00000o2 != null) {
            TextView textView = this.mHomeNameTv;
            ggb.O00000Oo();
            textView.setText(ggb.O000000o(O00000o2));
        }
        this.O00000o0 = findViewById(R.id.home_room_manager_container);
        this.O00000o0.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass10 */

            public final void onClick(View view) {
                Home home = O00000o2;
                if (home != null) {
                    HomeRoomManageListActivity.startActivity(HomeEditorActivity.this, home.getId());
                    hxi.O00000o.f952O000000o.O000000o("home_management_editroom", new Object[0]);
                }
            }
        });
        this.O0000Oo0 = (SimpleDraweeView) findViewById(R.id.sd_room_bg);
        ((GenericDraweeHierarchy) this.O0000Oo0.getHierarchy()).setPlaceholderImageFocusPoint(new PointF(0.5f, 0.19f));
        if (this.mHome != null) {
            ggh O000000o2 = ggh.O000000o();
            if (O000000o2.O000000o(this.mHome.getBackground() + "_favorites")) {
                O000000o(this.mHome.getBackground() + "_favorites");
            }
        }
        View findViewById = findViewById(R.id.bg_container);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass11 */

            public final void onClick(View view) {
                Home home = O00000o2;
                if (home != null && home.isOwner()) {
                    Intent intent = new Intent(HomeEditorActivity.this.getContext(), HomeAllStyleListActivity.class);
                    intent.putExtra("homeid", O00000o2.getId());
                    HomeEditorActivity.this.startActivityForResult(intent, 1001);
                    hxi.O00000o.f952O000000o.O000000o("h2m_background_setting", new Object[0]);
                }
            }
        });
        if (Build.VERSION.SDK_INT >= 24) {
            locale = CommonApplication.getApplication().getResources().getConfiguration().getLocales().get(0);
        } else {
            locale = CommonApplication.getApplication().getResources().getConfiguration().locale;
        }
        if (gwc.O000000o(locale, Locale.SIMPLIFIED_CHINESE) || TextUtils.equals(locale.getLanguage(), Locale.ENGLISH.getLanguage())) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        this.O00000o = (TextView) findViewById(R.id.home_device_size_tv);
        this.mLocTv = (TextView) findViewById(R.id.home_loc_tv);
        this.O00000oo = (ListView) findViewById(R.id.lv_memeber);
        this.homeMemberAdapter = new O000000o(this, new ArrayList());
        Home home = this.mHome;
        if (home != null && home.isOwner()) {
            this.O00000oo.addFooterView(LayoutInflater.from(this).inflate((int) R.layout.home_member_list_add_member_item, (ViewGroup) this.O00000oo, false));
        }
        this.O00000oo.setAdapter((ListAdapter) this.homeMemberAdapter);
        this.O00000oo.setOnItemClickListener(new AdapterView.OnItemClickListener(O00000o2) {
            /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeEditorActivity$eWX66C5Vbxb8J6jLpBUWQQNZbE */
            private final /* synthetic */ Home f$1;

            {
                this.f$1 = r2;
            }

            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                HomeEditorActivity.this.O000000o(this.f$1, adapterView, view, i, j);
            }
        });
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass12 */

            public final void onClick(View view) {
                HomeEditorActivity.this.finish();
            }
        });
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(getString(R.string.home_manage_tite));
        O00000Oo();
        String O000000o3 = ggb.O00000Oo().O000000o((fuy.O000000o) new fuy.O000000o() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass13 */

            public final void O000000o(String str, Location location) {
                Bundle extras;
                gwr O000000o2;
                if (HomeEditorActivity.this.isValid() && (extras = location.getExtras()) != null && (O000000o2 = gwu.O000000o(CommonApplication.getAppContext(), (Address) extras.getParcelable("address"))) != null) {
                    HomeEditorActivity.this.mLocTv.setText(O000000o2.O00000Oo);
                }
            }

            public final void O000000o(String str) {
                if (!HomeEditorActivity.this.isValid()) {
                }
            }
        }, true, this.mHome);
        if (!TextUtils.isEmpty(O000000o3)) {
            this.mLocTv.setText(O000000o3);
        }
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || HomeRoomCreatHomeActivity.isGoogleplayChannel()) {
            findViewById(R.id.home_loc_container).setVisibility(8);
        } else {
            findViewById(R.id.home_loc_container).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass14 */

                public final void onClick(View view) {
                    Home home = O00000o2;
                    if (home == null || home.isOwner()) {
                        if (fux.O000000o(HomeEditorActivity.this)) {
                            ExternalLoadManager.instance.loadExternal("amap2d", new fkv() {
                                /* class com.xiaomi.smarthome.homeroom.$$Lambda$HomeEditorActivity$14$IJ42ZI5ABZX4cQRDhN36pktNM */

                                public final Object call(Object obj) {
                                    return HomeEditorActivity.AnonymousClass14.this.O000000o((ExternalLoadManager.O000000o) obj);
                                }
                            });
                        }
                        int i = !TextUtils.isEmpty(HomeEditorActivity.this.mLocTv.getText()) ? TextUtils.isEmpty(O00000o2.getAddr()) ? 1 : 2 : 0;
                        hxk hxk = hxi.O00000o;
                        ggb.O00000Oo();
                        hxk.f952O000000o.O000000o("changehomeaddress_click", "homename", ggb.O000000o(O00000o2), "type", Integer.valueOf(i));
                        HomeEditorActivity.this.mUpdateHomeLoc = true;
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ Integer O000000o(ExternalLoadManager.O000000o o000000o) throws RuntimeException {
                    if (o000000o.f4013O000000o == 3) {
                        Intent intent = new Intent();
                        intent.setClassName(HomeEditorActivity.this, "com.xiaomi.smarthome.newui.amappoi.AmapSetHomeAddrActivity");
                        HomeEditorActivity.this.startActivityForResult(intent, 1002);
                    } else if (o000000o.f4013O000000o == 4) {
                        gqg.O00000Oo((int) R.string.mapload_fail);
                    }
                    return Integer.valueOf(o000000o.f4013O000000o);
                }
            });
        }
        if (O00000o2 != null && !O00000o2.isOwner()) {
            this.O00000o0.setVisibility(8);
            findViewById(R.id.home_device_size_container).setVisibility(8);
        }
        O000000o();
    }

    private void O000000o() {
        if (this.mHome != null) {
            ggc.O000000o().O000000o(this.mHome, new fsm<LongSparseArray<HomeMember>, fso>() {
                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass7 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    LongSparseArray longSparseArray = (LongSparseArray) obj;
                    if (longSparseArray != null && longSparseArray.size() > 0) {
                        ArrayList arrayList = new ArrayList();
                        ggc O000000o2 = ggc.O000000o();
                        String str = HomeEditorActivity.this.mHomeId;
                        List list = O000000o2.O00000o0.get(str);
                        if (list == null) {
                            list = new ArrayList();
                            O000000o2.O00000o0.put(str, list);
                        }
                        for (int i = 0; i < list.size(); i++) {
                            HomeMember homeMember = (HomeMember) longSparseArray.get(((Long) list.get(i)).longValue());
                            if (homeMember != null) {
                                if (HomeEditorActivity.this.mHome.isOwner()) {
                                    arrayList.add(homeMember);
                                } else if (homeMember.f8990O000000o == 2 || homeMember.f8990O000000o == 10) {
                                    arrayList.add(homeMember);
                                }
                            }
                        }
                        HomeEditorActivity.this.homeMemberAdapter.O000000o(arrayList);
                        if (HomeEditorActivity.this.mHome != null) {
                            hxp hxp = hxi.O00000o0;
                            int size = arrayList.size();
                            hxp.f957O000000o.O000000o("home_management_show", "from", Integer.valueOf(HomeEditorActivity.this.mHome.isOwner() ^ true ? 1 : 0), "homenumber", Integer.valueOf(size));
                        }
                    }
                }
            });
        }
    }

    public void onResume() {
        super.onResume();
        if (this.mHome != null) {
            int size = ggb.O00000Oo().O000000o(this.mHome.getId(), new boolean[0]).size();
            this.O00000o.setText(getResources().getQuantityString(R.plurals.home_device_size, size, Integer.valueOf(size)));
        }
        if (this.f8844O000000o) {
            O000000o();
            this.f8844O000000o = false;
        }
    }

    public void onPause() {
        super.onPause();
        this.f8844O000000o = true;
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            ft.O000000o(this).O000000o(this.O0000OOo);
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Home home;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 1001) {
            O000000o(intent.getStringExtra("wallpaperNamePrefix"));
        } else if (i == 1002 && intent != null) {
            hpv O00000o02 = hjk.O00000o0(intent.getDoubleExtra("latitude", 0.0d), intent.getDoubleExtra("longitude", 0.0d));
            double d = O00000o02.f511O000000o;
            double d2 = O00000o02.O00000Oo;
            String stringExtra = intent.getStringExtra("home_address");
            String stringExtra2 = intent.getStringExtra("city_id");
            if (d != 0.0d && d2 != 0.0d && !TextUtils.isEmpty(stringExtra) && !TextUtils.equals(stringExtra2, "0") && (home = this.mHome) != null) {
                home.setLatitude(String.valueOf(d2));
                this.mHome.setLongitude(String.valueOf(d));
                this.mHome.setLocationId(stringExtra2);
                this.mHome.setAddr(stringExtra);
                this.mLocTv.setText(stringExtra);
                ggb.O00000Oo().O000000o(this.mHome, (ggb.O00000o) null);
                ggb.O00000Oo().O0000o();
            }
        }
    }

    public static void finishActivity() {
        WeakReference<HomeEditorActivity> weakReference = sActivityRef;
        if (weakReference != null && weakReference.get() != null) {
            sActivityRef.get().finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Home home, AdapterView adapterView, View view, int i, long j) {
        if (j == -1) {
            ShareHomeActivity.startActivity(this, this.mHomeId);
            hxi.O00000o.f952O000000o.O000000o("home_management_addnumber", new Object[0]);
        } else if (home != null) {
            HomeMember homeMember = (HomeMember) adapterView.getItemAtPosition(i);
            HomeMemberDetailsActivity.startActivity(this, homeMember, home.getId());
            int i2 = homeMember.f8990O000000o;
            int i3 = -1;
            if (i2 == -1) {
                i3 = 4;
            } else if (i2 == 0) {
                i3 = 3;
            } else if (i2 == 2) {
                i3 = 2;
            } else if (i2 == 10) {
                i3 = 1;
            }
            hxi.O00000o.f952O000000o.O000000o("home_management_clicknumber", "type", Integer.valueOf(i3), "from", Integer.valueOf(home.isOwner() ^ true ? 1 : 0));
        }
    }

    private void O000000o(String str) {
        ((GenericDraweeHierarchy) this.O0000Oo0.getHierarchy()).setActualImageFocusPoint(new PointF(0.5f, 0.19f));
        ggb.O0000O0o.O000000o(this.O0000Oo0, str, new boolean[0]);
    }

    public void showProgressDialog(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getResources().getString(R.string.loading_share_info);
        }
        this.mProcessDialog = new XQProgressDialog(this);
        this.mProcessDialog.setCancelable(true);
        this.mProcessDialog.setMessage(str);
        this.mProcessDialog.show();
    }

    public void contrlProgreassDialog(boolean z, boolean z2, final boolean z3) {
        if (isValid() && !z) {
            if (this.mProcessDialog != null) {
                getWindow().getDecorView().postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass2 */

                    public final void run() {
                        if (HomeEditorActivity.this.mProcessDialog != null) {
                            HomeEditorActivity.this.mProcessDialog.dismiss();
                        }
                        if (z3) {
                            HomeEditorActivity.this.finish();
                        }
                    }
                }, 2000);
            }
            if (!z2) {
                gqg.O00000Oo((int) R.string.home_set_failed);
            }
        }
    }

    private void O00000Oo() {
        TextView textView = (TextView) findViewById(R.id.delhome);
        View findViewById = findViewById(R.id.addhome);
        List<Home> list = ggb.O00000Oo().O0000OoO.O00000Oo;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (list.get(i2).isOwner()) {
                i++;
            }
        }
        Home home = this.mHome;
        if (home != null && !home.isOwner()) {
            findViewById.setVisibility(4);
            textView.setVisibility(0);
            textView.setText((int) R.string.family_quit);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (HomeEditorActivity.this.mDialog != null && HomeEditorActivity.this.mDialog.isShowing()) {
                        HomeEditorActivity.this.mDialog.dismiss();
                    }
                    hxi.O00000o.O00000oo(1);
                    HomeEditorActivity homeEditorActivity = HomeEditorActivity.this;
                    homeEditorActivity.mDialog = new MLAlertDialog.Builder(homeEditorActivity).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.exit, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            long parseLong = Long.parseLong(CoreApi.O000000o().O0000o0());
                            HomeEditorActivity.this.showProgressDialog((String) null);
                            ggc.O000000o().O000000o(parseLong, HomeEditorActivity.this.mHome, new fsm<JSONObject, fso>() {
                                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                    HomeEditorActivity.this.contrlProgreassDialog(false, false, false);
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    HomeEditorActivity.this.contrlProgreassDialog(false, true, true);
                                }
                            });
                        }
                    }).O00000Oo((int) R.string.home_member_exit_home).O00000oo();
                }
            });
        } else if (i > 1) {
            findViewById.setVisibility(4);
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    if (HomeEditorActivity.this.mDialog != null && HomeEditorActivity.this.mDialog.isShowing()) {
                        HomeEditorActivity.this.mDialog.dismiss();
                    }
                    hxi.O00000o.O00000oo(0);
                    if (HomeEditorActivity.this.deletable) {
                        HomeEditorActivity homeEditorActivity = HomeEditorActivity.this;
                        homeEditorActivity.mDialog = new MLAlertDialog.Builder(homeEditorActivity).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.confirm, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass4.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ggb O00000Oo = ggb.O00000Oo();
                                O00000Oo.O0000OoO.O000000o(HomeEditorActivity.this.mHome, "delete", new ggb.O00000o() {
                                    /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                    public final void O000000o() {
                                        HomeEditorActivity.this.finish();
                                    }

                                    public final void O000000o(int i, fso fso) {
                                        HomeEditorActivity.this.finish();
                                        gqg.O00000Oo((int) R.string.room_delete_failed);
                                    }
                                });
                            }
                        }).O00000Oo((int) R.string.message_delete_home_enable).O00000oo();
                        return;
                    }
                    HomeEditorActivity homeEditorActivity2 = HomeEditorActivity.this;
                    homeEditorActivity2.mDialog = new MLAlertDialog.Builder(homeEditorActivity2).O000000o((int) R.string.action_back, (DialogInterface.OnClickListener) null).O00000Oo((int) R.string.message_delete_home_unable).O00000oo();
                }
            });
        } else {
            textView.setVisibility(4);
            findViewById.setVisibility(0);
        }
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass5 */

            public final void onClick(View view) {
                hxi.O00000o.O0000OOo();
                HomeEditorActivity.this.startActivity(new Intent(HomeEditorActivity.this.getContext(), HomeRoomCreatHomeActivity.class));
                HomeEditorActivity.sActivityRef = new WeakReference<>(HomeEditorActivity.this);
            }
        });
    }

    public void updateHomeLocation() {
        Home O0000Oo02 = ggb.O00000Oo().O0000Oo0();
        if (O0000Oo02 != null) {
            O0000Oo02.setLocationId(gwq.O000000o().O00000o().O000000o());
            O0000Oo02.setLatitude(gwq.O000000o().O00000o().O00000Oo());
            O0000Oo02.setLongitude(gwq.O000000o().O00000o().O00000o0());
            ggb.O00000Oo().O0000o();
        }
    }

    public void saveHomeName(final String str) {
        Home home = this.mHome;
        if (home != null) {
            home.setName(str);
            ggb.O00000Oo().O000000o(this.mHome, new ggb.O00000o() {
                /* class com.xiaomi.smarthome.homeroom.HomeEditorActivity.AnonymousClass6 */

                public final void O000000o() {
                    HomeEditorActivity.this.mHomeNameTv.setText(str);
                }

                public final void O000000o(int i, fso fso) {
                    gqg.O00000Oo((int) R.string.tip_home_name_save_failed);
                }
            });
        }
    }

    class O000000o extends eza<HomeMember> {
        public final int O000000o() {
            return R.layout.home_member_list_item;
        }

        public final /* synthetic */ void O000000o(ezc ezc, Object obj, int i) {
            int i2;
            String str;
            HomeMember homeMember = (HomeMember) obj;
            if (homeMember != null) {
                TextView textView = (TextView) ezc.O000000o((int) R.id.tv_member_name);
                TextView textView2 = (TextView) ezc.O000000o((int) R.id.tv_member_identity);
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) ezc.O000000o((int) R.id.icon);
                UserInfo userInfo = homeMember.O00000o0;
                if (userInfo != null) {
                    gyl.O000000o();
                    gyl.O00000Oo(userInfo.O00000o0, simpleDraweeView, null);
                    textView.setText(userInfo.O00000oO);
                }
                Resources resources = HomeEditorActivity.this.getResources();
                if (homeMember.f8990O000000o == 0) {
                    i2 = resources.getColor(R.color.mj_color_class_text_36);
                } else {
                    i2 = resources.getColor(R.color.mj_color_gray_light);
                }
                textView2.setTextColor(i2);
                Resources resources2 = HomeEditorActivity.this.getResources();
                if (homeMember.f8990O000000o == -1) {
                    str = resources2.getString(R.string.smarthome_share_expired);
                } else if (homeMember.f8990O000000o == 0) {
                    str = resources2.getString(R.string.smarthome_to_user_status_waiting);
                } else if (homeMember.f8990O000000o == 2) {
                    str = resources2.getString(R.string.family_member);
                } else if (homeMember.f8990O000000o == 10) {
                    str = resources2.getString(R.string.home_administrator);
                } else {
                    str = "";
                }
                textView2.setText(str);
            }
        }

        O000000o(Context context, List<HomeMember> list) {
            super(context, list);
        }
    }
}
