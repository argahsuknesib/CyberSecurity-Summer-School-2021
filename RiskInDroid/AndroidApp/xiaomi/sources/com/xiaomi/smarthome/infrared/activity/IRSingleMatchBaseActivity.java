package com.xiaomi.smarthome.infrared.activity;

import _m_j.fag;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fss;
import _m_j.gix;
import _m_j.giy;
import _m_j.giz;
import _m_j.gja;
import _m_j.gjb;
import _m_j.gjc;
import _m_j.gjd;
import _m_j.gje;
import _m_j.gsf;
import _m_j.gsg;
import _m_j.gsj;
import _m_j.gsl;
import _m_j.gsy;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.device.api.IXmPluginHostActivity;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity;
import com.xiaomi.smarthome.infrared.bean.IRBrandType;
import com.xiaomi.smarthome.infrared.bean.IRFunctionType;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import com.xiaomi.smarthome.infrared.bean.IRSTBData;
import com.xiaomi.smarthome.infrared.bean.IRType;
import com.xiaomi.smarthome.infrared.bean.InfraredControllerInfo;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

public class IRSingleMatchBaseActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private IRSTBData f9013O000000o;
    private TextView O00000Oo;
    private giz O00000o;
    private ImageView O00000o0;
    private View O00000oO;
    private View O00000oo;
    private TextView O0000O0o;
    private View O0000OOo;
    private View O0000Oo;
    private LinearLayout O0000Oo0;
    private View O0000OoO;
    private View O0000Ooo;
    private DeviceStat O0000o0;
    private gjc O0000o00 = new gjc();
    private String O0000o0O;
    public ImageView ivProgress;
    public IRBrandType mBranchTypeData;
    public int mDeviceType;
    public gjb mSingleMatchManger;
    public int[] mTvRes = {R.string.ir_text_tv_tips_no, R.string.ir_text_tv_tips_yes, R.string.ir_text_tv_msg};

    public static void showSingleMatchActivity(Activity activity, int i, String str, IRBrandType iRBrandType) {
        Intent intent = new Intent(activity, IRSingleMatchBaseActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_brandid", str);
        intent.putExtra("intent_IRBrandType_key", iRBrandType);
        intent.putExtra("intent_device_type_key", i);
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public static void showStbSingleMatchActivity(Activity activity, int i, IRSTBData iRSTBData) {
        Intent intent = new Intent(activity, IRSingleMatchBaseActivity.class);
        Bundle extras = activity.getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        intent.putExtra("intent_stb_data_key", iRSTBData);
        intent.putExtra("intent_device_type_key", i);
        activity.startActivityForResult(intent, C.MSG_CUSTOM_BASE);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.mDeviceType = intent.getIntExtra("intent_device_type_key", 0);
        this.O0000o0 = (DeviceStat) intent.getParcelableExtra("extra_device");
        this.O0000o0O = intent.getStringExtra("intent_brandid");
        if (this.mDeviceType == IRType.STB.value()) {
            this.f9013O000000o = (IRSTBData) intent.getParcelableExtra("intent_stb_data_key");
        } else {
            this.mBranchTypeData = (IRBrandType) intent.getParcelableExtra("intent_IRBrandType_key");
        }
        setContentView((int) R.layout.activity_ir_single_match);
        findViewById(R.id.module_a_3_return_more_more_btn).setVisibility(8);
        View findViewById = findViewById(R.id.module_a_3_return_btn);
        this.O0000o00.f17826O000000o = this;
        this.O00000o0 = (ImageView) findViewById(R.id.ir_image_btn_icon);
        this.O00000Oo = (TextView) findViewById(R.id.ir_image_btn_text);
        this.O0000Oo = findViewById(R.id.ir_single_match_tip_view);
        TextView textView = (TextView) findViewById(R.id.irv_match_no);
        TextView textView2 = (TextView) findViewById(R.id.irv_match_yes);
        findViewById(R.id.irv3_match_tip_text);
        this.O0000OoO = findViewById(R.id.ir_rl_test);
        this.O00000oO = findViewById(R.id.ir_test_button_next);
        this.O00000oo = findViewById(R.id.ir_test_button_last);
        this.O0000O0o = (TextView) findViewById(R.id.ir_text_test_btn_num);
        this.O0000OOo = findViewById(R.id.ir_ic_text_operation_ll);
        this.O0000Oo0 = (LinearLayout) findViewById(R.id.irv_match_other_ll);
        this.O0000Oo0.setVisibility(8);
        this.O0000Ooo = findViewById(R.id.ir_imi_progress);
        this.ivProgress = (ImageView) findViewById(R.id.ivProgress);
        O00000Oo();
        String string = getResources().getString(gje.O000000o(this.mDeviceType).O00000Oo);
        String string2 = getResources().getString(R.string.ir_add_ic_operation_description, string);
        String string3 = getResources().getString(R.string.ir_add_ic_title_name, string);
        ((TextView) findViewById(R.id.ir_ic_text_operation_description)).setText(string2);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText(string3);
        if (this.mDeviceType == IRType.TV.value()) {
            selectTipsView(true);
            View inflate = getLayoutInflater().inflate((int) R.layout.include_ir_tv_tip, (ViewGroup) null);
            this.O0000Oo0.addView(inflate, -1, -1);
            TextView textView3 = (TextView) inflate.findViewById(R.id.irv_match_no);
            TextView textView4 = (TextView) inflate.findViewById(R.id.irv_match_yes);
            textView3.setText(this.mTvRes[0]);
            textView4.setText(this.mTvRes[1]);
            ((TextView) inflate.findViewById(R.id.irv3_match_tip_text)).setText(this.mTvRes[2]);
            textView3.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    IRSingleMatchBaseActivity.this.selectTipsView(false);
                    IRSingleMatchBaseActivity.this.mBranchTypeData.O00000oo = false;
                    IRSingleMatchBaseActivity.this.requestData();
                }
            });
            textView4.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass4 */

                public final void onClick(View view) {
                    IRSingleMatchBaseActivity.this.selectTipsView(false);
                    IRSingleMatchBaseActivity.this.mBranchTypeData.O00000oo = true;
                    IRSingleMatchBaseActivity.this.requestData();
                }
            });
        } else {
            selectTipsView(false);
            requestData();
        }
        findViewById.setOnClickListener(this);
        this.O00000o0.setOnClickListener(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        this.O00000oO.setOnClickListener(this);
        this.O00000oo.setOnClickListener(this);
    }

    private void O000000o() {
        this.O0000Ooo.setVisibility(0);
        Drawable drawable = this.ivProgress.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).start();
        }
    }

    public void disMissProgressBar() {
        this.O0000Ooo.setVisibility(8);
        Drawable drawable = this.ivProgress.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
    }

    public void requestData() {
        String str;
        AnonymousClass1 r0 = new fsm<gja, fso>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                IRSingleMatchBaseActivity.this.disMissProgressBar();
                IRSingleMatchBaseActivity.this.mSingleMatchManger = new gjb(((gja) obj).f17824O000000o, IRType.valueOf(IRSingleMatchBaseActivity.this.mDeviceType), new gjb.O000000o() {
                    /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass1.AnonymousClass1 */

                    public final void O000000o(String str) {
                        IRSingleMatchBaseActivity.this.onMatchDeviceSuccess(str);
                    }

                    public final void O000000o(IRKeyValue iRKeyValue, int i, int i2, int i3) {
                        IRSingleMatchBaseActivity.this.createButton(iRKeyValue, i, i2, i3);
                    }

                    public final void O000000o() {
                        IRSingleMatchBaseActivity.this.disMissProgressBar();
                        IRSingleMatchBaseActivity.this.onMatchingDeviceFailed();
                    }
                });
            }

            public final void onFailure(fso fso) {
                IRSingleMatchBaseActivity.this.disMissProgressBar();
                IRSingleMatchBaseActivity iRSingleMatchBaseActivity = IRSingleMatchBaseActivity.this;
                fag.O000000o(iRSingleMatchBaseActivity, iRSingleMatchBaseActivity.getString(R.string.ir_toast_get_data_failed));
            }
        };
        if (this.mDeviceType == IRType.STB.value()) {
            gjc gjc = this.O0000o00;
            IRSTBData iRSTBData = this.f9013O000000o;
            try {
                if (iRSTBData.f9038O000000o != 1) {
                    str = MessageFormat.format("https://cdn.cnbj1.fds.api.mi-img.com/irservice/match/v2/city/{0}/sp/{1}", iRSTBData.O00000o, iRSTBData.O00000o0);
                } else {
                    str = MessageFormat.format("https://cdn.cnbj1.fds.api.mi-img.com/irservice/match/v2/iptv/{0}", iRSTBData.O00000o0);
                }
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsg.O00000Oo(o000000o.O00000Oo(str).O000000o(), new gsl<gja, gsf>(r0) {
                    /* class _m_j.gjc.AnonymousClass3 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f17833O000000o;

                    {
                        this.f17833O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        gja gja = (gja) obj;
                        try {
                            response.close();
                        } catch (Throwable unused) {
                        }
                        fsm fsm = this.f17833O000000o;
                        if (fsm != null) {
                            fsm.onSuccess(gja);
                        }
                    }

                    public final void processResponse(Response response) {
                        try {
                            ResponseBody body = response.body();
                            if (!response.isSuccessful() || body == null) {
                                sendFailureMessage(new gsf(response.code(), "resbody null"), new Exception(), response);
                            } else {
                                sendSuccessMessage(gja.O000000o(new JSONObject(body.string())), response);
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
                        fsm fsm = this.f17833O000000o;
                        if (fsm != null) {
                            fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                        }
                    }
                });
            } catch (Throwable th) {
                Log.e("InifraredRequestApi", "requestSbtMatchList", th);
            }
        } else {
            gjc gjc2 = this.O0000o00;
            int i = this.mDeviceType;
            String str2 = this.mBranchTypeData.O00000Oo;
            try {
                gsj.O000000o o000000o2 = new gsj.O000000o();
                o000000o2.f18212O000000o = "GET";
                gsg.O00000Oo(o000000o2.O00000Oo(MessageFormat.format("https://cdn.cnbj1.fds.api.mi-img.com/irservice/match/v2/category/{0}/brand/{1}", String.valueOf(i), str2)).O000000o(), new gsl<gja, gsf>(r0) {
                    /* class _m_j.gjc.AnonymousClass4 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ fsm f17834O000000o;

                    {
                        this.f17834O000000o = r2;
                    }

                    public final /* synthetic */ void onSuccess(Object obj, Response response) {
                        gja gja = (gja) obj;
                        try {
                            response.close();
                        } catch (Throwable unused) {
                        }
                        fsm fsm = this.f17834O000000o;
                        if (fsm != null) {
                            fsm.onSuccess(gja);
                        }
                    }

                    public final void processResponse(Response response) {
                        try {
                            ResponseBody body = response.body();
                            if (!response.isSuccessful() || body == null) {
                                sendFailureMessage(new gsf(response.code(), "resbody null"), new Exception(), response);
                            } else {
                                sendSuccessMessage(gja.O000000o(new JSONObject(body.string())), response);
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
                        fsm fsm = this.f17834O000000o;
                        if (fsm != null) {
                            fsm.onFailure(new fso(gsf.f18205O000000o, gsf.O00000Oo));
                        }
                    }
                });
            } catch (Throwable th2) {
                Log.e("InifraredRequestApi", "requestSbtMatchList", th2);
            }
        }
    }

    public void onMatchingDeviceFailed() {
        fag.O000000o(this, getString(R.string.ir_toast_key_has_no_infra));
        if (IRType.valueOf(this.mDeviceType) != IRType.AC) {
            fag.O000000o(this, getString(R.string.ir_single_match_failed));
            Intent intent = getIntent().setClass(this, IRStudyActivity.class);
            intent.putExtra("intent_device_type_key", this.mDeviceType);
            startActivityForResult(intent, 2);
        }
    }

    public void onMatchDeviceSuccess(String str) {
        InfraredControllerInfo infraredControllerInfo = new InfraredControllerInfo();
        infraredControllerInfo.O00000oo = String.valueOf(str);
        infraredControllerInfo.O00000o = IRType.valueOf(this.mDeviceType);
        IRSTBData iRSTBData = this.f9013O000000o;
        infraredControllerInfo.O00000o0 = iRSTBData == null ? this.O0000o0O : iRSTBData.O00000o0;
        if (this.mDeviceType == IRType.STB.value()) {
            infraredControllerInfo.O0000Oo0 = this.f9013O000000o.O00000Oo;
        }
        infraredControllerInfo.O0000O0o = IRFunctionType.MATCH;
        HashMap hashMap = new HashMap();
        hashMap.put(infraredControllerInfo.O00000oo, infraredControllerInfo);
        O000000o();
        this.O0000o00.O000000o(this.O0000o0, hashMap, new fsm<giy, fso>() {
            /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                giy giy = (giy) obj;
                final $$Lambda$IRSingleMatchBaseActivity$2$_MjqzP28Y4oWfMapS1VQ9gMpC9c r0 = new Runnable(giy) {
                    /* class com.xiaomi.smarthome.infrared.activity.$$Lambda$IRSingleMatchBaseActivity$2$_MjqzP28Y4oWfMapS1VQ9gMpC9c */
                    private final /* synthetic */ giy f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        IRSingleMatchBaseActivity.AnonymousClass2.this.O000000o(this.f$1);
                    }
                };
                if (IRSingleMatchBaseActivity.this.getIntent().getBooleanExtra("create_device", true)) {
                    fsp.O000000o().O0000Oo.onDeviceReady(IRSingleMatchBaseActivity.this, giy.O00000o0, giy.f17821O000000o, IRSingleMatchBaseActivity.this.getIntent().getBooleanExtra("open_room_select", false), new IXmPluginHostActivity.AsyncCallback<Void>() {
                        /* class com.xiaomi.smarthome.infrared.activity.IRSingleMatchBaseActivity.AnonymousClass2.AnonymousClass1 */

                        public final void onFailure(int i, Object obj) {
                            IRSingleMatchBaseActivity.this.ivProgress.postDelayed(r0, 1000);
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            IRSingleMatchBaseActivity.this.ivProgress.postDelayed(r0, 1000);
                        }
                    });
                } else {
                    IRSingleMatchBaseActivity.this.ivProgress.postDelayed(r0, 0);
                }
            }

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
            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o(giy giy) {
                Intent intent = new Intent();
                intent.putExtra("infrared_finish", true);
                intent.putExtra("infrared_did", giy.f17821O000000o);
                intent.putExtra("infrared_parentid", giy.O00000o);
                intent.putExtra("infrared_name", giy.O00000Oo);
                intent.putExtra("infrared_model", giy.O00000o0);
                IRSingleMatchBaseActivity.this.setResult(-1, intent);
                IRSingleMatchBaseActivity.this.finish();
            }

            public final void onFailure(fso fso) {
                if (fso == null || fso.f17063O000000o != -6) {
                    fag.O000000o(IRSingleMatchBaseActivity.this.getContext(), (int) R.string.edit_save_failed, 1);
                } else {
                    fag.O000000o(IRSingleMatchBaseActivity.this.getContext(), (int) R.string.mj_createir_save_failed, 1);
                }
                IRSingleMatchBaseActivity.this.disMissProgressBar();
            }
        });
    }

    public void selectTipsView(boolean z) {
        if (z) {
            this.O0000OOo.setVisibility(4);
            this.O0000OoO.setVisibility(8);
            this.O0000Oo0.setVisibility(0);
            return;
        }
        this.O0000OOo.setVisibility(0);
        this.O0000OoO.setVisibility(0);
        this.O0000Oo0.setVisibility(8);
        O000000o();
    }

    public void onClick(View view) {
        gjb gjb;
        int id = view.getId();
        if (id == R.id.module_a_3_return_btn) {
            finish();
        } else if (id == R.id.ir_image_btn_icon) {
            giz giz = this.O00000o;
            if (giz != null) {
                gjc gjc = this.O0000o00;
                JSONObject jSONObject = new JSONObject();
                try {
                    if (giz.f17822O000000o == IRType.AC) {
                        jSONObject.put("ac_key", giz.O00000Oo);
                    } else {
                        jSONObject.put("key_id", Integer.parseInt(giz.O00000Oo));
                    }
                    jSONObject.put("did", giz.O00000o0);
                    jSONObject.put("controller_id", Integer.parseInt(giz.O00000o));
                } catch (Throwable th) {
                    Log.e("InifraredRequestApi", "requestClick", th);
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/irdevice/send_key").O000000o(arrayList).O000000o();
                gjc.O000000o o000000o = new gjc.O000000o(null);
                gjc.O000000o(CoreApi.O000000o().O000000o(gjc.f17826O000000o, O000000o2, new fss<String>() {
                    /* class _m_j.gjc.AnonymousClass2 */

                    public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                        return jSONObject == null ? "" : jSONObject.toString();
                    }
                }, Crypto.RC4, o000000o), o000000o);
            } else {
                fag.O000000o(this, (int) R.string.ir_toast_key_not_matched, 1);
            }
            this.O0000Oo.setVisibility(0);
        } else if (id == R.id.irv_match_no) {
            gjb gjb2 = this.mSingleMatchManger;
            if (gjb2 != null) {
                gjb2.O000000o();
            }
            O00000Oo();
        } else if (id == R.id.irv_match_yes) {
            gjb gjb3 = this.mSingleMatchManger;
            if (gjb3 != null) {
                String str = gjb3.O00000Oo.getLast().O00000o;
                if ("0".equals(str) || TextUtils.isEmpty(str)) {
                    String valueOf = String.valueOf(gjb3.O00000Oo.getLast().O00000o0);
                    if (gjb3.f17825O000000o != null) {
                        gjb3.f17825O000000o.O000000o(valueOf);
                    }
                } else {
                    gjb3.O000000o(str);
                }
            }
            O00000Oo();
        } else if (id == R.id.ir_test_button_next) {
            gjb gjb4 = this.mSingleMatchManger;
            if (gjb4 != null) {
                gjb4.O000000o();
            }
        } else if (id == R.id.ir_test_button_last && (gjb = this.mSingleMatchManger) != null && gjb.O00000Oo.size() > 1) {
            gjb.O00000Oo.removeLast();
            gix last = gjb.O00000Oo.getLast();
            gsy.O000000o(3, "ImiSingleMatchManager", "lastKeyValue: mismatched " + last.f17820O000000o);
            gjb.O000000o(gjb.O000000o(last), last.O00000oo, last.O0000O0o, gjb.O00000Oo.size());
        }
    }

    private void O00000Oo() {
        this.O0000Oo.setVisibility(4);
    }

    public void createButton(IRKeyValue iRKeyValue, int i, int i2, int i3) {
        String str;
        int indexOf;
        new ArrayList().add(iRKeyValue);
        InfraredControllerInfo infraredControllerInfo = new InfraredControllerInfo();
        infraredControllerInfo.O00000o = iRKeyValue.O00000o0;
        String str2 = iRKeyValue.O00000oo;
        if (infraredControllerInfo.O00000o != IRType.AC) {
            str = gjd.O000000o(iRKeyValue);
        } else if ("power_on".equals(str2)) {
            str = getResources().getString(R.string.match_ac_power_on);
            iRKeyValue.O0000OOo = "电源-开";
        } else if ("power_off".equals(str2)) {
            str = getResources().getString(R.string.match_ac_power_off);
            iRKeyValue.O0000OOo = "电源-关";
        } else if (str2 == null || !str2.startsWith("M") || (indexOf = str2.indexOf("_")) <= 0) {
            str = getResources().getString(R.string.match_ac_power_auto);
        } else {
            try {
                int parseInt = Integer.parseInt(str2.substring(1, indexOf));
                str = parseInt != 0 ? parseInt != 1 ? parseInt != 2 ? parseInt != 3 ? parseInt != 4 ? getResources().getString(R.string.match_ac_power_auto) : getResources().getString(R.string.match_ac_power_dir) : getResources().getString(R.string.match_ac_power_wind) : getResources().getString(R.string.match_ac_power_auto) : getResources().getString(R.string.match_ac_power_hot) : getResources().getString(R.string.match_ac_power_cool);
            } catch (Throwable unused) {
                str = getResources().getString(R.string.match_ac_power_auto);
            }
        }
        this.O00000o = new giz(str, iRKeyValue.O0000OOo, str2, this.O0000o0.did, infraredControllerInfo.O00000o, iRKeyValue.f9037O000000o);
        this.O00000o0.setImageResource(this.O00000o.O00000oO);
        this.O00000Oo.setText(this.O00000o.O00000oo);
        if (i3 == 1) {
            this.O00000oo.setVisibility(8);
        } else {
            this.O00000oo.setVisibility(0);
        }
        if (i == i2) {
            this.O00000oO.setVisibility(8);
        } else {
            this.O00000oO.setVisibility(0);
        }
        this.O0000O0o.setText(String.format(String.format(getString(R.string.ir_add_ic_test_btn_num), Integer.valueOf(i), Integer.valueOf(i2)), new Object[0]));
    }

    public void onDestroy() {
        super.onDestroy();
        this.O0000o00.O000000o();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && intent.getBooleanExtra("infrared_finish", false)) {
            setResult(-1, intent);
            finish();
        } else if (i == 2) {
            finish();
        }
    }
}
