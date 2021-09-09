package com.xiaomi.smarthome.device;

import _m_j.ext;
import _m_j.fni;
import _m_j.fnn;
import _m_j.fno;
import _m_j.fnq;
import _m_j.fsm;
import _m_j.fso;
import _m_j.hjp;
import _m_j.htv;
import _m_j.htw;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ModifyGroupActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ListView f6985O000000o;
    TextView O00000Oo;
    ViewSwitcher O00000o;
    Button O00000o0;
    View O00000oO;
    String[] O00000oo = null;
    String[] O0000O0o = null;
    String O0000OOo = null;
    String O0000Oo = null;
    String O0000Oo0 = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.modify_group_activity);
        Intent intent = getIntent();
        this.O00000oo = intent.getStringArrayExtra("group_device_ids");
        this.O0000OOo = intent.getStringExtra("masterDid");
        this.O0000Oo0 = intent.getStringExtra("group_name");
        this.O0000Oo = intent.getStringExtra("group_model");
        if (TextUtils.isEmpty(this.O0000Oo)) {
            this.O0000Oo = "yeelink.light.virtual";
        }
        findViewById(R.id.module_a_4_return_more_btn).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass1 */

            public final void onClick(View view) {
                ModifyGroupActivity.this.finish();
            }
        });
        this.O00000o = (ViewSwitcher) findViewById(R.id.vs_root);
        this.O00000oO = findViewById(R.id.ll_loading);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_4_return_more_title);
        if ("plugin_device_group".equals(getIntent().getStringExtra("from"))) {
            checkDeviceCount();
        }
        if (TextUtils.isEmpty(this.O0000OOo)) {
            this.O00000Oo.setText((int) R.string.activity_title_create_group);
        } else {
            this.O00000Oo.setText((int) R.string.activity_title_modify_group);
        }
        this.O00000o0 = (Button) findViewById(R.id.module_a_4_return_finish_btn);
        this.O00000o0.setEnabled(false);
        this.f6985O000000o = (ListView) findViewById(R.id.list_group);
        String[] strArr = this.O00000oo;
        if (strArr == null || strArr.length <= 0) {
            if (this.O00000o.getCurrentView() != this.O00000oO) {
                this.O00000o.showNext();
            }
            List<fni> O00000o02 = fnn.O000000o().O00000o0();
            fnn O000000o2 = fnn.O000000o();
            fni findVirtualGroupByModel = O000000o2.f16706O000000o.findVirtualGroupByModel(O00000o02, this.O0000Oo);
            if (findVirtualGroupByModel != null) {
                this.O00000oo = fnn.O000000o().O000000o(findVirtualGroupByModel);
            } else {
                this.O00000oo = null;
            }
            String[] strArr2 = this.O00000oo;
            if (strArr2 == null || strArr2.length <= 0) {
                runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass5 */

                    public final void run() {
                        izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_no_editable_group_info, 1).show();
                    }
                });
                finish();
                return;
            }
            O00000o0();
            return;
        }
        O00000o0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0048, code lost:
        r0 = _m_j.fno.O000000o().O000000o(r0[0]);
     */
    public void checkDeviceCount() {
        final Device O000000o2;
        if (this.O0000Oo == null) {
            finish();
        }
        List<fni> O00000o02 = fnn.O000000o().O00000o0();
        if (O00000o02 == null || O00000o02.size() == 0) {
            finish();
            return;
        }
        fni fni = null;
        Iterator<fni> it = O00000o02.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            fni next = it.next();
            if (next.O00000o.equalsIgnoreCase(this.O0000Oo)) {
                fni = next;
                break;
            }
        }
        if (fni == null) {
            finish();
        }
        String[] O000000o3 = fnn.O000000o().O000000o(fni);
        if (O000000o3 != null && O000000o3.length == 1 && O000000o2 != null && CoreApi.O000000o().O00000o(O000000o2.model)) {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O000000o((int) R.string.dialog_title_one_device_tip);
            builder.O000000o((int) R.string.dialog_option_one_more, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    hjp.O000000o("https://home.mi.com/shop/search?keyword=" + O000000o2.name);
                    ModifyGroupActivity.this.setResult(-1);
                    ModifyGroupActivity.this.finish();
                }
            });
            builder.O00000Oo((int) R.string.dialog_option_okay, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    ModifyGroupActivity.this.finish();
                }
            }).O000000o(false);
            builder.O00000o().show();
        }
    }

    public void updateTitleBtn() {
        O000000o o000000o;
        int i;
        ListView listView = this.f6985O000000o;
        if (listView != null && (o000000o = (O000000o) listView.getAdapter()) != null && o000000o.getCount() > 0) {
            if (o000000o.O00000Oo == null || o000000o.O00000Oo.length <= 0) {
                i = 0;
            } else {
                i = 0;
                for (boolean z : o000000o.O00000Oo) {
                    if (z) {
                        i++;
                    }
                }
            }
            if (i <= 1) {
                this.O00000o0.setEnabled(false);
            } else {
                this.O00000o0.setEnabled(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass4 */

            public final void run() {
                izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_get_group_failed, 1).show();
            }
        });
        finish();
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        runOnUiThread(new Runnable() {
            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass7 */

            public final void run() {
                izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_modify_group_failed_duplicate, 1).show();
            }
        });
        finish();
    }

    private void O00000o0() {
        if (TextUtils.isEmpty(this.O0000OOo)) {
            runOnUiThread(new Runnable() {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass8 */

                public final void run() {
                    ListView listView = ModifyGroupActivity.this.f6985O000000o;
                    ModifyGroupActivity modifyGroupActivity = ModifyGroupActivity.this;
                    listView.setAdapter((ListAdapter) new O000000o(modifyGroupActivity.O00000oo, null));
                    if (ModifyGroupActivity.this.O00000o.getCurrentView() == ModifyGroupActivity.this.O00000oO) {
                        ModifyGroupActivity.this.O00000o.showNext();
                    }
                }
            });
            return;
        }
        if (this.O00000o.getCurrentView() != this.O00000oO) {
            this.O00000o.showNext();
        }
        DeviceApi.getInstance().getVirtualDeviceInfoById(this, this.O0000OOo, new fsm<fnq, fso>() {
            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass9 */

            public final /* synthetic */ void onSuccess(Object obj) {
                fnq fnq = (fnq) obj;
                if (fnq == null) {
                    ModifyGroupActivity.this.O000000o();
                    return;
                }
                if (fnq.O00000oO == null || fnq.O00000oO.length <= 0) {
                    ModifyGroupActivity.this.O0000O0o = null;
                } else {
                    ModifyGroupActivity.this.O0000O0o = new String[fnq.O00000oO.length];
                    for (int i = 0; i < fnq.O00000oO.length; i++) {
                        try {
                            ModifyGroupActivity.this.O0000O0o[i] = new JSONObject(fnq.O00000oO[i]).optString("did");
                        } catch (JSONException unused) {
                        }
                    }
                }
                ModifyGroupActivity.this.runOnUiThread(new Runnable() {
                    /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        ModifyGroupActivity.this.f6985O000000o.setAdapter((ListAdapter) new O000000o(ModifyGroupActivity.this.O00000oo, ModifyGroupActivity.this.O0000O0o));
                        if (ModifyGroupActivity.this.O00000o.getCurrentView() == ModifyGroupActivity.this.O00000oO) {
                            ModifyGroupActivity.this.O00000o.showNext();
                        }
                    }
                });
            }

            public final void onFailure(fso fso) {
                ModifyGroupActivity.this.O000000o();
            }
        });
    }

    class O000000o extends BaseAdapter {

        /* renamed from: O000000o  reason: collision with root package name */
        Device[] f6996O000000o;
        boolean[] O00000Oo;
        final boolean[] O00000o0;

        public final long getItemId(int i) {
            return (long) i;
        }

        public O000000o(String[] strArr, String[] strArr2) {
            this.f6996O000000o = new Device[strArr.length];
            this.O00000Oo = new boolean[strArr.length];
            this.O00000o0 = new boolean[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.f6996O000000o[i] = fno.O000000o().O000000o(strArr[i]);
                this.O00000Oo[i] = O000000o(strArr2, strArr[i]);
                this.O00000o0[i] = this.O00000Oo[i];
            }
            ModifyGroupActivity.this.updateTitleBtn();
            ModifyGroupActivity.this.O00000o0.setOnClickListener(new View.OnClickListener(ModifyGroupActivity.this) {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.O000000o.AnonymousClass1 */

                public final void onClick(View view) {
                    boolean z;
                    ModifyGroupActivity.this.O00000o0.setEnabled(false);
                    int length = O000000o.this.O00000Oo.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            z = false;
                            break;
                        } else if (O000000o.this.O00000o0[i] != O000000o.this.O00000Oo[i]) {
                            z = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (!z) {
                        ModifyGroupActivity.this.finish();
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < O000000o.this.O00000Oo.length; i2++) {
                        if (O000000o.this.O00000Oo[i2]) {
                            arrayList.add(O000000o.this.f6996O000000o[i2].did);
                        }
                    }
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    if (TextUtils.isEmpty(ModifyGroupActivity.this.O0000OOo)) {
                        DeviceApi.getInstance().createModelGroup(ModifyGroupActivity.this, strArr, "", new fsm<Device, fso>() {
                            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.O000000o.AnonymousClass1.AnonymousClass1 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                Device device = (Device) obj;
                                izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_create_group_success, 0).show();
                                device.isNew = true;
                                device.scrollTo = true;
                                htw O000000o2 = htv.O000000o();
                                if (O000000o2 != null) {
                                    O000000o2.setCurrentScrollToDid(device.did);
                                }
                                fno.O000000o().O000000o(device);
                                ModifyGroupActivity.this.finish();
                            }

                            public final void onFailure(fso fso) {
                                String str = fso.O00000Oo;
                                if (fso.f17063O000000o != -8 || !str.contains("duplicate")) {
                                    izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_create_group_failed, 0).show();
                                } else {
                                    ModifyGroupActivity.this.O00000Oo();
                                }
                                ModifyGroupActivity.this.updateTitleBtn();
                            }
                        });
                    } else {
                        DeviceApi.getInstance().modifyModelGroup(ModifyGroupActivity.this, strArr, ModifyGroupActivity.this.O0000OOo, ModifyGroupActivity.this.O0000Oo0, new fsm<String, fso>() {
                            /* class com.xiaomi.smarthome.device.ModifyGroupActivity.O000000o.AnonymousClass1.AnonymousClass2 */

                            public final /* synthetic */ void onSuccess(Object obj) {
                                Intent intent = new Intent();
                                intent.putExtra("result", (String) obj);
                                ModifyGroupActivity.this.setResult(-1, intent);
                                ModifyGroupActivity.this.finish();
                            }

                            public final void onFailure(fso fso) {
                                ModifyGroupActivity.this.setResult(0);
                                String str = fso.O00000Oo;
                                if (fso.f17063O000000o != -8 || !str.contains("duplicate")) {
                                    ModifyGroupActivity modifyGroupActivity = ModifyGroupActivity.this;
                                    modifyGroupActivity.runOnUiThread(new Runnable() {
                                        /* class com.xiaomi.smarthome.device.ModifyGroupActivity.AnonymousClass6 */

                                        public final void run() {
                                            izb.O000000o(ModifyGroupActivity.this, (int) R.string.toast_modify_group_failed, 1).show();
                                        }
                                    });
                                    modifyGroupActivity.finish();
                                    return;
                                }
                                ModifyGroupActivity.this.O00000Oo();
                            }
                        });
                    }
                }
            });
        }

        private static boolean O000000o(String[] strArr, String str) {
            if (strArr == null || strArr.length <= 0 || TextUtils.isEmpty(str)) {
                return false;
            }
            for (String equals : strArr) {
                if (str.equals(equals)) {
                    return true;
                }
            }
            return false;
        }

        public final int getCount() {
            return this.f6996O000000o.length;
        }

        public final Object getItem(int i) {
            return this.f6996O000000o[i];
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.widget.ListView, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            C0064O000000o o000000o;
            if (view == null) {
                view = LayoutInflater.from(ModifyGroupActivity.this).inflate((int) R.layout.list_item_group, (ViewGroup) ModifyGroupActivity.this.f6985O000000o, false);
                o000000o = new C0064O000000o();
                o000000o.f7002O000000o = (SimpleDraweeView) view.findViewById(R.id.image);
                o000000o.O00000Oo = (TextView) view.findViewById(R.id.name);
                o000000o.O00000o0 = (TextView) view.findViewById(R.id.name_status);
                o000000o.O00000o = (CheckBox) view.findViewById(R.id.ckb_group);
                view.setTag(o000000o);
            } else {
                o000000o = (C0064O000000o) view.getTag();
            }
            final CheckBox checkBox = o000000o.O00000o;
            view.findViewById(R.id.layout_root).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.O000000o.AnonymousClass2 */

                public final void onClick(View view) {
                    CheckBox checkBox = checkBox;
                    checkBox.setChecked(!checkBox.isChecked());
                }
            });
            Device device = this.f6996O000000o[i];
            o000000o.O00000Oo.setText(device.name);
            ext.O000000o(device).setNameStatus(ModifyGroupActivity.this, o000000o.O00000o0, device, false);
            DeviceFactory.O00000Oo(device.model, o000000o.f7002O000000o);
            o000000o.O00000o.setOnCheckedChangeListener(null);
            o000000o.O00000o.setTag(Integer.valueOf(i));
            o000000o.O00000o.setChecked(this.O00000Oo[i]);
            o000000o.O00000o.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                /* class com.xiaomi.smarthome.device.ModifyGroupActivity.O000000o.AnonymousClass3 */

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    O000000o.this.O00000Oo[((Integer) compoundButton.getTag()).intValue()] = z;
                    ModifyGroupActivity.this.updateTitleBtn();
                }
            });
            return view;
        }

        /* renamed from: com.xiaomi.smarthome.device.ModifyGroupActivity$O000000o$O000000o  reason: collision with other inner class name */
        class C0064O000000o {

            /* renamed from: O000000o  reason: collision with root package name */
            SimpleDraweeView f7002O000000o;
            TextView O00000Oo;
            CheckBox O00000o;
            TextView O00000o0;

            C0064O000000o() {
            }
        }
    }
}
