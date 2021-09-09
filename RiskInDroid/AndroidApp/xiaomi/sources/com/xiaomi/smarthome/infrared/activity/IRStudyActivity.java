package com.xiaomi.smarthome.infrared.activity;

import _m_j.ezb;
import _m_j.fag;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fss;
import _m_j.giq;
import _m_j.giy;
import _m_j.gjc;
import _m_j.gjd;
import _m_j.gje;
import _m_j.gjf;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.hlz;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRFunctionType;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import com.xiaomi.smarthome.infrared.bean.IRType;
import com.xiaomi.smarthome.infrared.bean.InfraredControllerInfo;
import com.xiaomi.smarthome.infrared.widget.ImiGridLayoutManager;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IRStudyActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    protected Map<String, IRKeyValue> f9020O000000o = new LinkedHashMap();
    private IRType O00000Oo;
    private ImiGridLayoutManager O00000o;
    private RecyclerView O00000o0;
    private View O00000oO;
    private DeviceStat O00000oo;
    private XQProgressDialog O0000O0o;
    public ImageView ivProgress;
    public gjc mApi = new gjc();
    public View mDefaultEmpty;
    public giq mIRStudyListAdapter;
    public String mResult;
    public List<IRKeyValue> mStudyList = new ArrayList();

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.module_a_3_right_text_btn_more) {
            final InfraredControllerInfo infraredControllerInfo = new InfraredControllerInfo();
            infraredControllerInfo.O0000O0o = IRFunctionType.STUDY;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis() / 1000);
            infraredControllerInfo.O0000OOo = sb.toString();
            infraredControllerInfo.O00000o = this.O00000Oo;
            infraredControllerInfo.O0000Oo = new ArrayList(this.f9020O000000o.values());
            String string = getResources().getString(gje.O000000o(this.O00000Oo.value()).O00000Oo);
            infraredControllerInfo.f9040O000000o = string;
            infraredControllerInfo.O00000Oo = string;
            List<IRKeyValue> list = infraredControllerInfo.O0000Oo;
            if (list == null || list.size() == 0) {
                fag.O000000o(this, (int) R.string.edit_save_failed_no_keys, 1);
                return;
            }
            String string2 = getResources().getString(R.string.setting_progress_dialog_tips);
            XQProgressDialog xQProgressDialog = this.O0000O0o;
            if (xQProgressDialog != null) {
                xQProgressDialog.cancel();
                this.O0000O0o = null;
            }
            this.O0000O0o = new XQProgressDialog(this);
            this.O0000O0o.setCancelable(false);
            this.O0000O0o.setMessage(string2);
            this.O0000O0o.show();
            HashMap hashMap = new HashMap();
            hashMap.put(infraredControllerInfo.O00000oO, infraredControllerInfo);
            this.mApi.O000000o(this.O00000oo, hashMap, new fsm<giy, fso>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass6 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    final giy giy = (giy) obj;
                    gjc gjc = IRStudyActivity.this.mApi;
                    List<IRKeyValue> list = infraredControllerInfo.O0000Oo;
                    String str = giy.f17821O000000o;
                    AnonymousClass1 r3 = new fsm<String, fso>() {
                        /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass6.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            if (fso == null || fso.f17063O000000o != -6) {
                                fag.O000000o(IRStudyActivity.this.getContext(), (int) R.string.edit_save_failed, 1);
                            } else {
                                fag.O000000o(IRStudyActivity.this.getContext(), (int) R.string.mj_createir_save_failed, 1);
                            }
                            IRStudyActivity.this.cancelXqProgressDialog();
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            final AnonymousClass1 r8 = new Runnable() {
                                /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass6.AnonymousClass1.AnonymousClass1 */

                                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                                 method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                                 arg types: [java.lang.String, int]
                                 candidates:
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                                  ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                                public final void run() {
                                    IRStudyActivity.this.cancelXqProgressDialog();
                                    Intent intent = new Intent();
                                    intent.putExtra("infrared_finish", true);
                                    intent.putExtra("infrared_did", giy.f17821O000000o);
                                    intent.putExtra("infrared_parentid", giy.O00000o);
                                    intent.putExtra("infrared_name", giy.O00000Oo);
                                    intent.putExtra("infrared_model", giy.O00000o0);
                                    IRStudyActivity.this.setResult(-1, intent);
                                    IRStudyActivity.this.finish();
                                }
                            };
                            if (IRStudyActivity.this.getIntent().getBooleanExtra("create_device", true)) {
                                fsp.O000000o().O0000Oo.onDeviceReady(IRStudyActivity.this, giy.O00000o0, giy.f17821O000000o, IRStudyActivity.this.getIntent().getBooleanExtra("open_room_select", false), new IXmPluginHostActivity.AsyncCallback<Void>() {
                                    /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass6.AnonymousClass1.AnonymousClass2 */

                                    public final void onFailure(int i, Object obj) {
                                        IRStudyActivity.this.ivProgress.postDelayed(r8, 1000);
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        IRStudyActivity.this.ivProgress.postDelayed(r8, 1000);
                                    }
                                });
                            } else {
                                IRStudyActivity.this.ivProgress.postDelayed(r8, 0);
                            }
                        }
                    };
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("did", str);
                        for (IRKeyValue next : list) {
                            JSONObject jSONObject2 = new JSONObject();
                            if (!TextUtils.isEmpty(next.O00000Oo)) {
                                if (!"0".equals(next.O00000Oo)) {
                                    jSONObject2.put("key_id", Integer.parseInt(next.O00000Oo));
                                    jSONObject2.put("code", next.O00000oo);
                                    jSONArray.put(jSONObject2);
                                }
                            }
                            jSONObject2.put("name", gjd.O000000o(next));
                            jSONObject2.put("code", next.O00000oo);
                            jSONArray.put(jSONObject2);
                        }
                        jSONObject.put("keys", jSONArray);
                    } catch (Throwable th) {
                        Log.e("InifraredRequestApi", "requestCache", th);
                    }
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                    NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/irdevice/controller/keys/set").O000000o(arrayList).O000000o();
                    gjc.O000000o o000000o = new gjc.O000000o(r3);
                    gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o2, new fss<String>() {
                        /* class _m_j.gjc.AnonymousClass1 */

                        public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            return jSONObject == null ? "" : jSONObject.toString();
                        }
                    }, Crypto.RC4, o000000o), o000000o);
                }

                public final void onFailure(fso fso) {
                    fag.O000000o(IRStudyActivity.this, (int) R.string.edit_save_failed, 1);
                    IRStudyActivity.this.cancelXqProgressDialog();
                }
            });
        } else if (id == R.id.ir_study_add_other) {
            final String string3 = getString(R.string.ir_controller_edit_key_name_title);
            View inflate = View.inflate(this, R.layout.activity_ir_edit_name, null);
            inflate.findViewById(R.id.ir_edit_board).setOnClickListener(this);
            final EditText editText = (EditText) inflate.findViewById(R.id.ir_edit_view);
            if (!TextUtils.isEmpty("")) {
                editText.setText("");
                editText.setSelection(0, 0);
            }
            editText.setHint(getString(R.string.ir_controller_edit_hint) + string3);
            new MLAlertDialog.Builder(this).O000000o(inflate).O000000o(string3).O00000Oo((int) R.string.ir_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).O000000o((int) R.string.ir_confirm, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    String obj = editText.getText().toString();
                    if (obj.isEmpty()) {
                        izb.O000000o(IRStudyActivity.this, string3 + IRStudyActivity.this.getString(R.string.ir_controller_edit_empty_toast), 0).show();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("key_value_type", 3);
                    bundle.putString("key_device_image", IRStudyActivity.this.mResult);
                    IRStudyTipActivity.showStudyTipActivity(IRStudyActivity.this, obj, bundle, 101);
                    dialogInterface.dismiss();
                }
            }).O00000oo();
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("intent_device_type_key", 0);
        this.O00000oo = (DeviceStat) intent.getParcelableExtra("extra_device");
        this.O00000Oo = IRType.valueOf(intExtra);
        setContentView((int) R.layout.activity_ir_study_controllerv2);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        TextView textView = (TextView) findViewById(R.id.module_a_3_return_title);
        int i = gje.O000000o(this.O00000Oo.value()).O00000Oo;
        String string = getResources().getString(R.string.ir_device_type_unknown);
        String string2 = getResources().getString(i);
        String string3 = getResources().getString(R.string.ir_select_controller_title);
        if (this.O00000Oo == IRType.Unknown) {
            str = string2 + string3;
        } else {
            str = string + string2 + string3;
        }
        textView.setText(str);
        TextView textView2 = (TextView) findViewById(R.id.module_a_3_right_text_btn_more);
        this.mApi.f17826O000000o = this;
        textView2.setVisibility(0);
        textView2.setBackground(null);
        textView2.setText((int) R.string.ir_finish);
        textView2.setTextColor(getResources().getColor(R.color.mj_color_green_normal));
        textView2.setTextSize(16.0f);
        this.O00000o0 = (RecyclerView) findViewById(R.id.ir_study_recycler_view);
        this.O00000oO = findViewById(R.id.ir_imi_progress);
        this.ivProgress = (ImageView) findViewById(R.id.ivProgress);
        View findViewById2 = findViewById(R.id.ir_study_add_other);
        this.mDefaultEmpty = findViewById(R.id.ir_study_default_empty);
        View findViewById3 = findViewById(R.id.ir_study_controller_tip_root);
        this.mIRStudyListAdapter = new giq(this, this.mStudyList, this.f9020O000000o, this.O00000Oo);
        this.O00000o = new ImiGridLayoutManager(this);
        this.O00000o0.setLayoutManager(this.O00000o);
        this.O00000o0.setAdapter(this.mIRStudyListAdapter);
        this.O00000o0.addItemDecoration(new gjf());
        this.mIRStudyListAdapter.O00000o0 = new ezb.O000000o() {
            /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass1 */

            public final void onItemClick(RecyclerView recyclerView, View view, int i) {
                IRKeyValue iRKeyValue = IRStudyActivity.this.mStudyList.get(i);
                int i2 = TextUtils.isEmpty(iRKeyValue.O00000oo) ? 2 : 1;
                Bundle bundle = new Bundle();
                bundle.putInt("key_value_type", i2);
                bundle.putInt("key_alert_study_position", i);
                bundle.putString("key_device_image", IRStudyActivity.this.mResult);
                IRStudyTipActivity.showStudyTipActivity(IRStudyActivity.this, iRKeyValue, bundle, 101);
            }
        };
        if (this.O00000Oo == IRType.Unknown) {
            this.mDefaultEmpty.setVisibility(0);
        } else {
            this.O00000oO.setVisibility(0);
            Drawable drawable = this.ivProgress.getDrawable();
            if (drawable instanceof AnimationDrawable) {
                ((AnimationDrawable) drawable).start();
            }
            gjc gjc = this.mApi;
            int value = this.O00000Oo.value();
            AnonymousClass3 r6 = new fsm<ArrayList<IRKeyValue>, fso>() {
                /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    ArrayList arrayList = (ArrayList) obj;
                    IRStudyActivity.this.mStudyList.clear();
                    if (arrayList == null || arrayList.size() == 0) {
                        IRStudyActivity.this.mDefaultEmpty.setVisibility(0);
                    } else {
                        IRStudyActivity.this.mStudyList.addAll(arrayList);
                        IRStudyActivity.this.mDefaultEmpty.setVisibility(8);
                    }
                    IRStudyActivity.this.mIRStudyListAdapter.notifyDataSetChanged();
                    IRStudyActivity.this.closeMissProgressBar();
                }

                public final void onFailure(fso fso) {
                    IRStudyActivity.this.closeMissProgressBar();
                    fag.O000000o(IRStudyActivity.this, (int) R.string.ir_toast_get_data_failed, 0);
                }
            };
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsg.O00000Oo(o000000o.O00000Oo(MessageFormat.format("http://cdn.cnbj1.fds.api.mi-img.com/irservice/ircode/v1/keys/category/{0}", String.valueOf(value))).O000000o(), new gsl<ArrayList<IRKeyValue>, gsf>(r6) {
                    /* class _m_j.gjc.AnonymousClass5 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f17835O000000o;

                    {
                        this.f17835O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        ArrayList arrayList = (ArrayList) obj;
                        try {
                            response.close();
                        } catch (Throwable unused) {
                        }
                        fsm fsm = this.f17835O000000o;
                        if (fsm != null) {
                            fsm.onSuccess(arrayList);
                        }
                    }

                    public final void processResponse(Response response) {
                        try {
                            ResponseBody body = response.body();
                            if (!response.isSuccessful() || body == null) {
                                sendFailureMessage(new gsf(response.code(), "resbody null"), new Exception(), response);
                            } else {
                                sendSuccessMessage(IRKeyValue.O000000o(new JSONObject(body.string()).optJSONArray("keys")), response);
                            }
                        } catch (Exception e) {
                            sendFailureMessage(new gsf(-1, e.getMessage()), e, response);
                        }
                    }

                    public final void processFailure(Call call, IOException iOException) {
                        sendFailureMessage(new gsf(-1, iOException.getMessage()), iOException, null);
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        try {
                            response.close();
                        } catch (Throwable unused) {
                        }
                        fsm fsm = this.f17835O000000o;
                        if (fsm != null) {
                            fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                        }
                    }
                });
            } catch (Throwable th) {
                Log.e("InifraredRequestApi", "requestSbtMatchList", th);
            }
            findViewById3.setVisibility(0);
        }
        findViewById.setOnClickListener(this);
        textView2.setOnClickListener(this);
        findViewById2.setOnClickListener(this);
        hlz.O000000o(this.O00000oo.model, new fsm<hlz.O000000o, fso>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRStudyActivity.AnonymousClass2 */

            public final void onFailure(fso fso) {
            }

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                IRStudyActivity.this.mResult = ((hlz.O000000o) obj).f19057O000000o;
            }
        });
    }

    public void moveToPosition(LinearLayoutManager linearLayoutManager, int i) {
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (i <= findFirstVisibleItemPosition || i > findLastVisibleItemPosition) {
            this.O00000o0.scrollToPosition(i);
            return;
        }
        this.O00000o0.scrollBy(0, this.O00000o0.getChildAt(i - findFirstVisibleItemPosition).getTop());
    }

    public void closeMissProgressBar() {
        this.O00000oO.setVisibility(8);
        Drawable drawable = this.ivProgress.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    public void cancelXqProgressDialog() {
        XQProgressDialog xQProgressDialog = this.O0000O0o;
        if (xQProgressDialog != null) {
            xQProgressDialog.cancel();
            this.O0000O0o = null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mApi.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        }
        if (i2 == -1 && i == 101) {
            Bundle bundleExtra = intent.getBundleExtra("request_bundle_key");
            IRKeyValue iRKeyValue = (IRKeyValue) intent.getParcelableExtra("com.imi.action_study_key_value");
            this.f9020O000000o.put(iRKeyValue.O00000o, iRKeyValue);
            int i3 = bundleExtra.getInt("key_value_type");
            int i4 = bundleExtra.getInt("key_alert_study_position", 0);
            if (i3 == 1) {
                fag.O000000o(this, String.format(getResources().getString(R.string.ir_study_alert_reset_add), gjd.O000000o(iRKeyValue)));
                this.mStudyList.get(i4).O00000oo = iRKeyValue.O00000oo;
            } else if (i3 == 2) {
                this.mStudyList.get(i4).O00000oo = iRKeyValue.O00000oo;
            } else {
                this.mStudyList.add(iRKeyValue);
                moveToPosition(this.O00000o, this.mStudyList.size() - 1);
                this.mDefaultEmpty.setVisibility(8);
            }
            this.mIRStudyListAdapter.notifyDataSetChanged();
        }
    }
}
