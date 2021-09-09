package com.xiaomi.smarthome.nfctag.ui;

import _m_j.dws;
import _m_j.dwu;
import _m_j.dww;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gpc;
import _m_j.gpq;
import _m_j.hig;
import _m_j.hih;
import _m_j.hii;
import _m_j.hik;
import _m_j.hil;
import _m_j.him;
import _m_j.hin;
import _m_j.hio;
import _m_j.hip;
import _m_j.hiq;
import _m_j.hir;
import _m_j.his;
import _m_j.hit;
import _m_j.hor;
import _m_j.hte;
import _m_j.hxi;
import _m_j.hxr;
import android.animation.ObjectAnimator;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.C;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity;
import com.xiaomi.smarthome.nfctag.widget.NFCProgress;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class NFCWriteActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    NfcAdapter f10468O000000o;
    PendingIntent O00000Oo;
    Intent O00000o;
    IntentFilter[] O00000o0;
    ObjectAnimator O00000oO;
    private hil O00000oo = new hil();
    private int O0000O0o = -1;
    private HandlerThread O0000OOo = new gpq("nfcwriter");
    private String O0000Oo = null;
    private Handler O0000Oo0;
    private String O0000OoO = null;
    private String O0000Ooo = null;
    private String O0000o00 = null;
    public int currentStep = 0;
    public AtomicBoolean isWriting = new AtomicBoolean(false);
    public Handler mMainHandler;
    @BindView(5746)
    View mScanView;
    @BindView(6093)
    View mWriteFailView;
    @BindView(5217)
    View mWriteSuccessFinish;
    @BindView(6094)
    View mWriteSuccessView;
    @BindView(5218)
    NFCProgress mWritingLine1;
    @BindView(5776)
    NFCProgress mWritingLine2;
    @BindView(6097)
    View mWritingView;
    public String params;
    @BindView(6027)
    TextView txtHint;
    @BindView(6030)
    TextView txtRetry;
    @BindView(6031)
    TextView txtSubHint;
    @BindView(5744)
    View vNoTag;
    @BindView(5743)
    View vScanBg;
    @BindView(5745)
    View vScanPhone;

    private static String O000000o(int i) {
        if (i == 1) {
            return "aispeaker";
        }
        if (i == 2) {
            return "tv";
        }
        if (i == 5) {
            return "router";
        }
        if (i == 6) {
            return "mihome";
        }
        if (i != 7) {
            return null;
        }
        return "plugin";
    }

    public void onCreate(Bundle bundle) {
        Intent intent;
        super.onCreate(bundle);
        hih.O000000o("smarthome-nfc", "onCreate " + toString());
        setContentView((int) R.layout.activity_nfc_write);
        ButterKnife.bind(this);
        if (!(getIntent() == null || (intent = getIntent()) == null || intent.getExtras() == null || !intent.getExtras().containsKey("write_type") || !intent.getExtras().containsKey("write_param"))) {
            hig.f18961O000000o = intent.getExtras().getInt("write_type");
            hig.O00000o0 = intent.getExtras().getString("write_param");
            hig.O00000o = intent.getExtras().getString("write_from");
        }
        this.O0000O0o = hig.f18961O000000o;
        this.O0000OoO = hig.O00000Oo;
        if (this.O0000O0o < 0) {
            finish();
            return;
        }
        this.params = hig.O00000o0;
        if (TextUtils.isEmpty(this.params)) {
            finish();
            return;
        }
        if (this.f10468O000000o == null) {
            this.f10468O000000o = NfcAdapter.getDefaultAdapter(this);
        }
        NfcAdapter nfcAdapter = this.f10468O000000o;
        if (nfcAdapter == null) {
            finish();
        } else if (!nfcAdapter.isEnabled()) {
            hte.O000000o(this, "nfc not enable");
            finish();
        } else {
            ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.write_nfc_tag);
            findViewById(R.id.module_a_3_return_btn).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$jpw5kiN9auYJFOyXyvpWY09Iu8 */

                public final void onClick(View view) {
                    NFCWriteActivity.this.O00000o(view);
                }
            });
            this.mMainHandler = new Handler(Looper.getMainLooper()) {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity.AnonymousClass1 */

                public final void handleMessage(Message message) {
                    int i = message.what;
                    if (i != 5) {
                        NFCWriteActivity.this.mHandler.removeCallbacksAndMessages(null);
                    }
                    if (i != 0) {
                        NFCWriteActivity.this.isWriting.set(true);
                    } else {
                        NFCWriteActivity.this.isWriting.set(false);
                    }
                    NFCWriteActivity.this.updateUIBy(i);
                }
            };
            this.O0000OOo.start();
            this.O0000Oo0 = new Handler(this.O0000OOo.getLooper()) {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity.AnonymousClass2 */

                public final void handleMessage(Message message) {
                    if (message.what == 0) {
                        NFCWriteActivity nFCWriteActivity = NFCWriteActivity.this;
                        nFCWriteActivity.doSomethingWithIntent(nFCWriteActivity.O00000o);
                    }
                }
            };
            this.O00000oO = ObjectAnimator.ofFloat(this.vScanPhone, "translationY", (float) gpc.O000000o(40.0f), (float) gpc.O000000o(40.0f), 0.0f);
            this.O00000oO.setFloatValues(new float[0]);
            this.O00000oO.setDuration(1200L);
            this.mWritingLine1.O000000o();
            this.mMainHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$Dc5QYPHalyddG6zONrPeX6WzixI */

                public final void run() {
                    NFCWriteActivity.this.O00000o();
                }
            }, 750);
            IntentFilter intentFilter = new IntentFilter("android.nfc.action.TAG_DISCOVERED");
            intentFilter.addCategory("android.intent.category.DEFAULT");
            this.O00000o0 = new IntentFilter[]{intentFilter};
            this.O00000Oo = PendingIntent.getActivity(this, 0, new Intent(this, NFCWriteActivity.class), 0);
            this.currentStep = 0;
            updateUIBy(this.currentStep);
            hxi.O00000oO.f958O000000o.O000000o("NFC_write_page", "value", O000000o(this.O0000O0o));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o(View view) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o() {
        this.mWritingLine2.O000000o();
    }

    public void onResume() {
        super.onResume();
        hih.O000000o("smarthome-nfc", "onResume");
        NfcAdapter nfcAdapter = this.f10468O000000o;
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            this.f10468O000000o.enableForegroundDispatch(this, this.O00000Oo, this.O00000o0, null);
        }
    }

    public void onPause() {
        super.onPause();
        NfcAdapter nfcAdapter = this.f10468O000000o;
        if (nfcAdapter != null && nfcAdapter.isEnabled()) {
            this.f10468O000000o.disableForegroundDispatch(this);
        }
        hih.O000000o("smarthome-nfc", "onPause");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        hih.O000000o("smarthome-nfc", "onNewIntent");
        if ("android.nfc.action.TAG_DISCOVERED".equals(intent.getAction())) {
            this.mMainHandler.removeMessages(5);
            this.O00000o = intent;
            this.O0000Oo0.sendEmptyMessage(0);
            return;
        }
        this.mMainHandler.removeMessages(5);
        this.isWriting.set(false);
        this.currentStep = 0;
        updateUIBy(this.currentStep);
    }

    public void onDestroy() {
        super.onDestroy();
        hih.O000000o("smarthome-nfc", "onDestroy");
        hig.f18961O000000o = -1;
        hig.O00000o0 = null;
        hig.O00000o = null;
    }

    public void onBackPressed() {
        O000000o();
    }

    public void doSomethingWithIntent(Intent intent) {
        hik hik;
        if (this.isWriting.get()) {
            hih.O000000o("smarthome-nfc", "is writing...");
        } else if (intent == null) {
            hih.O000000o("smarthome-nfc", "doSomethingWithIntent intent is null");
            this.mMainHandler.sendEmptyMessage(3);
        } else {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            if (tag == null) {
                hih.O000000o("smarthome-nfc", "doSomethingWithIntent tag is null");
                this.mMainHandler.sendEmptyMessage(3);
                return;
            }
            try {
                new dwu();
                Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
                if (parcelableArrayExtra != null) {
                    for (Parcelable parcelable : parcelableArrayExtra) {
                        List<dws> O000000o2 = dwu.O000000o(((NdefMessage) parcelable).getRecords()[0].getPayload()).O000000o((byte) 1);
                        if (O000000o2 != null && O000000o2.size() > 0) {
                            hih.O000000o("smarthome-nfc", "find pre record");
                            dws dws = O000000o2.get(0);
                            if (dws instanceof dww) {
                                dww dww = (dww) dws;
                                if (dww.f15011O000000o == 7) {
                                    this.O0000Oo = new String(dww.O000000o(1), "UTF-8");
                                    this.O0000Ooo = new String(dww.O000000o(3), "UTF-8");
                                    this.O0000o00 = new String(dww.O000000o(2), "UTF-8");
                                    hih.O000000o("smarthome-nfc", "pre usId: " + this.O0000Oo);
                                }
                            }
                        }
                    }
                }
            } catch (NfcTagDataCorruptException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            int i = this.O0000O0o;
            String str = this.params;
            AnonymousClass3 r1 = new hig.O000000o() {
                /* class com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity.AnonymousClass3 */

                public final void O000000o() {
                    NFCWriteActivity.this.mMainHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$3$qJ7fkgv2jTrYmJM9MoL2UXBVx5Q */

                        public final void run() {
                            NFCWriteActivity.AnonymousClass3.this.O00000Oo();
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo() {
                    hih.O000000o("smarthome-nfc", "write success " + NFCWriteActivity.this.params.toString());
                    NFCWriteActivity nFCWriteActivity = NFCWriteActivity.this;
                    nFCWriteActivity.currentStep = 2;
                    nFCWriteActivity.mMainHandler.sendEmptyMessage(NFCWriteActivity.this.currentStep);
                    System.currentTimeMillis();
                }

                public final void O000000o(int i, String str) {
                    NFCWriteActivity.this.mMainHandler.post(new Runnable(i, str) {
                        /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$3$jOBkusBmGC1uaa7tZSQkkZC311E */
                        private final /* synthetic */ int f$1;
                        private final /* synthetic */ String f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void run() {
                            NFCWriteActivity.AnonymousClass3.this.O00000Oo(this.f$1, this.f$2);
                        }
                    });
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void O00000Oo(int i, String str) {
                    StringBuilder sb = new StringBuilder("errorCode:");
                    sb.append(i);
                    sb.append(":");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    sb.append(str);
                    hih.O000000o("smarthome-nfc", sb.toString());
                    NFCWriteActivity nFCWriteActivity = NFCWriteActivity.this;
                    nFCWriteActivity.currentStep = 3;
                    nFCWriteActivity.mMainHandler.sendEmptyMessage(NFCWriteActivity.this.currentStep);
                }
            };
            switch (i) {
                case 0:
                    hik = new hit(str, r1);
                    break;
                case 1:
                case 4:
                    hik = new hir(str, r1);
                    break;
                case 2:
                    hik = new his(str, r1);
                    break;
                case 3:
                    hik = new hip(str, r1);
                    break;
                case 5:
                    hik = new hio(str, r1);
                    break;
                case 6:
                    hik = new hiq(str, r1);
                    break;
                case 7:
                    hik = new hin(str, r1);
                    break;
                case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                    hik = new him(str, r1);
                    break;
                default:
                    hik = null;
                    break;
            }
            if (hik != null) {
                this.currentStep = 1;
                this.mMainHandler.sendEmptyMessage(this.currentStep);
                hik.O000000o(tag);
                return;
            }
            hih.O000000o("smarthome-nfc", "doSomethingWithIntent creator is null");
            this.mMainHandler.sendEmptyMessage(2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0(View view) {
        hxi.O00000o.f952O000000o.O000000o("NFC_detect_retry", new Object[0]);
        this.currentStep = 0;
        this.mMainHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        hxi.O00000o.f952O000000o.O000000o("NFC_fail_retry", new Object[0]);
        this.currentStep = 0;
        this.mMainHandler.sendEmptyMessage(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000o0() {
        this.mMainHandler.sendEmptyMessage(5);
    }

    private void O000000o() {
        O00000Oo();
        finish();
    }

    private void O00000Oo() {
        if (this.O0000O0o == 6 && this.currentStep != 2) {
            hih.O000000o("smarthome-nfc", "delete this record:not write or write fail");
            try {
                hii.O000000o(this, new JSONObject(this.params));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(this.O0000Oo) && this.currentStep == 2) {
            hih.O000000o("smarthome-nfc", "try to delete pre-record: " + this.O0000Oo);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("us_id", this.O0000Oo);
                jSONObject.put("region", this.O0000Ooo);
                try {
                    jSONObject.put("owner_id", Long.valueOf(this.O0000o00));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                hii.O000000o(this, jSONObject);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
    }

    public void updateUIBy(int i) {
        String str;
        if (i == 0) {
            this.O00000oO.start();
            this.mScanView.setVisibility(0);
            this.mWritingView.setVisibility(8);
            this.mWriteSuccessView.setVisibility(8);
            this.mWriteFailView.setVisibility(8);
            if (this.txtHint != null) {
                if (this.O0000O0o != 7 || !TextUtils.equals(hig.O00000o, "device_plugin")) {
                    this.txtHint.setText((int) R.string.close_to_tag);
                } else {
                    this.txtHint.setText((int) R.string.close_to_tag_open_device);
                }
            }
            TextView textView = this.txtSubHint;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.txtRetry;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            View view = this.vNoTag;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.vScanBg;
            if (view2 != null) {
                view2.setVisibility(0);
            }
            View view3 = this.vScanPhone;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            View view4 = this.mWriteSuccessFinish;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$KkMXP3XHeTptqQOoXAx9DCB9hYA */

                public final void run() {
                    NFCWriteActivity.this.O00000o0();
                }
            }, 10000);
        } else if (i == 1) {
            hxr hxr = hxi.O00000oO;
            String O000000o2 = O000000o(this.O0000O0o);
            hxr.f958O000000o.O000000o("NFC_write_ing", "value", O000000o2);
            this.mScanView.setVisibility(8);
            this.mWritingView.setVisibility(0);
            this.mWriteSuccessView.setVisibility(8);
            this.mWriteFailView.setVisibility(8);
            TextView textView3 = this.txtHint;
            if (textView3 != null) {
                textView3.setText((int) R.string.nfc_writing_tag);
            }
            TextView textView4 = this.txtSubHint;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.txtRetry;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            View view5 = this.mWriteSuccessFinish;
            if (view5 != null) {
                view5.setVisibility(8);
            }
        } else if (i == 2) {
            hxr hxr2 = hxi.O00000oO;
            String O000000o3 = O000000o(this.O0000O0o);
            hxr2.f958O000000o.O000000o("NFC_write_suc", "value", O000000o3);
            this.mScanView.setVisibility(8);
            this.mWritingView.setVisibility(8);
            this.mWriteSuccessView.setVisibility(0);
            this.mWriteFailView.setVisibility(8);
            TextView textView6 = this.txtHint;
            if (textView6 != null) {
                textView6.setText((int) R.string.nfc_write_success);
            }
            TextView textView7 = this.txtSubHint;
            if (textView7 != null) {
                textView7.setVisibility(0);
                TextView textView8 = this.txtSubHint;
                int i2 = this.O0000O0o;
                if (i2 == 6 || i2 == 7 || i2 == 5) {
                    str = getString(R.string.nfc_write_success_hint_all_support);
                } else {
                    str = getString(R.string.nfc_write_success_hint_mi_support);
                }
                textView8.setText(str);
            }
            TextView textView9 = this.txtRetry;
            if (textView9 != null) {
                textView9.setVisibility(8);
            }
            View view6 = this.mWriteSuccessFinish;
            if (view6 != null) {
                view6.setVisibility(0);
                this.mWriteSuccessFinish.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$2187q3PzFNK2FESS6tm5whjCwVk */

                    public final void onClick(View view) {
                        NFCWriteActivity.this.O000000o(view);
                    }
                });
            }
            if (!TextUtils.isEmpty(this.O0000OoO)) {
                hor.O000000o().delScene(this, this.O0000OoO, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.nfctag.ui.NFCWriteActivity.AnonymousClass4 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        hor.O000000o().updateScene15(null);
                    }
                });
            }
        } else if (i == 3) {
            hxr hxr3 = hxi.O00000oO;
            String O000000o4 = O000000o(this.O0000O0o);
            hxr3.f958O000000o.O000000o("NFC_write_fail", "value", O000000o4);
            this.mScanView.setVisibility(8);
            this.mWritingView.setVisibility(8);
            this.mWriteSuccessView.setVisibility(8);
            this.mWriteFailView.setVisibility(0);
            TextView textView10 = this.txtHint;
            if (textView10 != null) {
                textView10.setText((int) R.string.nfc_write_fail);
            }
            TextView textView11 = this.txtSubHint;
            if (textView11 != null) {
                textView11.setVisibility(8);
            }
            TextView textView12 = this.txtRetry;
            if (textView12 != null) {
                textView12.setVisibility(0);
                this.txtRetry.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$Wxr3oIUBDhsueQfiEInTQacQYw */

                    public final void onClick(View view) {
                        NFCWriteActivity.this.O00000Oo(view);
                    }
                });
            }
        } else if (i == 5) {
            hxr hxr4 = hxi.O00000oO;
            String O000000o5 = O000000o(this.O0000O0o);
            hxr4.f958O000000o.O000000o("NFC_write_retry", "value", O000000o5);
            TextView textView13 = this.txtHint;
            if (textView13 != null) {
                textView13.setText((int) R.string.nfc_write_not_found);
            }
            TextView textView14 = this.txtSubHint;
            if (textView14 != null) {
                textView14.setVisibility(8);
            }
            TextView textView15 = this.txtRetry;
            if (textView15 != null) {
                textView15.setVisibility(0);
                this.txtRetry.setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCWriteActivity$4QD5czF7QCUyKwoPD8318BV1tQ */

                    public final void onClick(View view) {
                        NFCWriteActivity.this.O00000o0(view);
                    }
                });
            }
            View view7 = this.vNoTag;
            if (view7 != null) {
                view7.setVisibility(0);
            }
            View view8 = this.vScanBg;
            if (view8 != null) {
                view8.setVisibility(8);
            }
            View view9 = this.vScanPhone;
            if (view9 != null) {
                view9.setVisibility(8);
            }
            View view10 = this.mWriteSuccessFinish;
            if (view10 != null) {
                view10.setVisibility(8);
            }
        }
    }
}
