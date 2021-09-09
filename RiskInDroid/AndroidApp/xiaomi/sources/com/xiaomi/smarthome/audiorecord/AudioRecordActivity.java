package com.xiaomi.smarthome.audiorecord;

import _m_j.fag;
import _m_j.fkb;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.goq;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.audiorecord.RecordButton;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.TlsVersion;
import org.json.JSONException;
import org.json.JSONObject;

public class AudioRecordActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    XQProgressDialog f4218O000000o;
    public Handler mHandler = new Handler() {
        /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass1 */

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                String str = (String) message.obj;
                if (!TextUtils.isEmpty(str)) {
                    TextView textView = AudioRecordActivity.this.mLogTv;
                    textView.setText(((Object) AudioRecordActivity.this.mLogTv.getText()) + str + "\n\n");
                }
            } else if (i == 2) {
                AudioRecordActivity.this.queryVoiceCtrlReply();
            }
        }
    };
    public TextView mLogTv;
    public OkHttpClient mOkHttpClient;
    public RecordButton mRecordBtn;
    public TextView mTipsCancelTv;
    public TextView mTipsSendTv;
    public String sid = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_audio_record);
        this.mRecordBtn = (RecordButton) findViewById(R.id.record_btn);
        this.mTipsSendTv = (TextView) findViewById(R.id.send_tv);
        this.mTipsCancelTv = (TextView) findViewById(R.id.cancel_tv);
        this.mLogTv = (TextView) findViewById(R.id.log_tv);
        this.mLogTv.setMovementMethod(new ScrollingMovementMethod());
        this.mRecordBtn.setRecordListener(new RecordButton.O00000o0() {
            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass2 */

            public final void O000000o(String str) {
                AudioRecordActivity.this.mRecordBtn.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                AudioRecordActivity.this.mRecordBtn.invalidate();
                AudioRecordActivity.this.uploadFile(str);
            }

            public final void O000000o() {
                AudioRecordActivity.this.mTipsSendTv.setVisibility(8);
                AudioRecordActivity.this.mTipsCancelTv.setVisibility(8);
                AudioRecordActivity.this.mRecordBtn.setBackgroundResource(R.drawable.kuailian_progress_filled_not);
                AudioRecordActivity.this.mRecordBtn.invalidate();
            }

            public final void O00000Oo() {
                AudioRecordActivity.this.mTipsSendTv.setVisibility(0);
                AudioRecordActivity.this.mTipsCancelTv.setVisibility(8);
                AudioRecordActivity.this.mRecordBtn.setBackgroundResource(R.drawable.kuailian_progress_filled);
                AudioRecordActivity.this.mRecordBtn.invalidate();
            }

            public final void O000000o(boolean z) {
                if (z) {
                    AudioRecordActivity.this.mTipsSendTv.setVisibility(0);
                    AudioRecordActivity.this.mTipsCancelTv.setVisibility(8);
                    return;
                }
                AudioRecordActivity.this.mTipsSendTv.setVisibility(8);
                AudioRecordActivity.this.mTipsCancelTv.setVisibility(0);
            }
        });
        ConnectionSpec build = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).cipherSuites(CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA).supportsTlsExtensions(true).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(build);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        fkb.O000000o(builder);
        this.mOkHttpClient = builder.dispatcher(new Dispatcher(goq.O000000o())).connectTimeout(60, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).connectionSpecs(arrayList).build();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        String f4229O000000o;
        String O00000Oo;

        O000000o() {
        }
    }

    public void setLogTvText(String str) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, str));
    }

    public void uploadFile(final String str) {
        try {
            this.mLogTv.setText("");
            this.sid = null;
            this.f4218O000000o = new XQProgressDialog(this);
            this.f4218O000000o.setCancelable(true);
            this.f4218O000000o.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass3 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AudioRecordActivity.this.mHandler.removeCallbacksAndMessages(null);
                }
            });
            this.f4218O000000o.setMessage("Pls wait, uploading");
            this.f4218O000000o.show();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("suffix", "1");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            CoreApi.O000000o().O000000o(this, new NetRequest.O000000o().O000000o("POST").O00000Oo("/voicectrl/gen_voice_upload_url").O000000o(arrayList).O000000o(), new fss<O000000o>() {
                /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass4 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    O000000o o000000o = new O000000o();
                    if (jSONObject.isNull("1")) {
                        return null;
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("1");
                    if (optJSONObject.isNull("url")) {
                        return null;
                    }
                    if (!optJSONObject.isNull("obj_name")) {
                        o000000o.O00000Oo = optJSONObject.optString("obj_name");
                    }
                    o000000o.f4229O000000o = optJSONObject.optString("url");
                    return o000000o;
                }
            }, Crypto.RC4, new fsm<O000000o, fso>() {
                /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    final O000000o o000000o = (O000000o) obj;
                    if (AudioRecordActivity.this.isValid()) {
                        AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                        audioRecordActivity.setLogTvText("gen_voice_upload_url 调用成功 url=" + o000000o.f4229O000000o + ",object_name=" + o000000o.O00000Oo);
                        Request build = new Request.Builder().url(o000000o.f4229O000000o).put(RequestBody.create(MediaType.parse(""), new File(str))).build();
                        if (o000000o.f4229O000000o.startsWith("https")) {
                            new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).tlsVersions(TlsVersion.TLS_1_0).cipherSuites(CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA).supportsTlsExtensions(true).build();
                        }
                        AudioRecordActivity.this.mOkHttpClient.newCall(build).enqueue(new Callback() {
                            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass5.AnonymousClass1 */

                            public final void onFailure(Call call, IOException iOException) {
                                if (AudioRecordActivity.this.isValid()) {
                                    AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                                    fag.O000000o(audioRecordActivity, "upload fail " + iOException.getMessage());
                                    AudioRecordActivity audioRecordActivity2 = AudioRecordActivity.this;
                                    audioRecordActivity2.setLogTvText("上传文件失败 " + iOException.getMessage());
                                    AudioRecordActivity.this.f4218O000000o.dismiss();
                                    if (iOException != null) {
                                        iOException.printStackTrace();
                                    }
                                }
                            }

                            public final void onResponse(Call call, Response response) throws IOException {
                                if (AudioRecordActivity.this.isValid()) {
                                    if (!response.isSuccessful()) {
                                        AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                                        audioRecordActivity.setLogTvText("上传文件失败 " + response.code() + " " + response.message());
                                        AudioRecordActivity audioRecordActivity2 = AudioRecordActivity.this;
                                        fag.O000000o(audioRecordActivity2, "upload fail " + response.code() + " " + response.message());
                                        return;
                                    }
                                    AudioRecordActivity audioRecordActivity3 = AudioRecordActivity.this;
                                    audioRecordActivity3.setLogTvText("上传文件成功 " + response.code() + " " + response.message());
                                    fag.O000000o(AudioRecordActivity.this, "upload success");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("voice_src", "2");
                                        jSONObject.put("voice_url", o000000o.O00000Oo);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                                        CoreApi.O000000o().O000000o(AudioRecordActivity.this, new NetRequest.O000000o().O000000o("POST").O00000Oo("/voicectrl/query").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                                            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                                                return jSONObject;
                                            }
                                        }, Crypto.RC4, new fsm<JSONObject, fso>() {
                                            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass5.AnonymousClass1.AnonymousClass2 */

                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                JSONObject jSONObject = (JSONObject) obj;
                                                AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                                                audioRecordActivity.setLogTvText("发起语⾳音控制成功 " + jSONObject.toString());
                                                try {
                                                    if (jSONObject.isNull("sid")) {
                                                        AudioRecordActivity.this.f4218O000000o.dismiss();
                                                        return;
                                                    }
                                                    AudioRecordActivity.this.sid = jSONObject.optString("sid");
                                                    AudioRecordActivity.this.mHandler.sendEmptyMessage(2);
                                                } catch (Exception e) {
                                                    AudioRecordActivity.this.f4218O000000o.dismiss();
                                                    e.printStackTrace();
                                                }
                                            }

                                            public final void onFailure(fso fso) {
                                                String str;
                                                AudioRecordActivity.this.f4218O000000o.dismiss();
                                                AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                                                StringBuilder sb = new StringBuilder("发起语⾳音控制失败 ");
                                                if (fso == null) {
                                                    str = "null";
                                                } else {
                                                    str = fso.f17063O000000o + " " + fso.O00000Oo;
                                                }
                                                sb.append(str);
                                                audioRecordActivity.setLogTvText(sb.toString());
                                            }
                                        });
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }

                public final void onFailure(fso fso) {
                    String str;
                    if (AudioRecordActivity.this.isValid()) {
                        AudioRecordActivity.this.f4218O000000o.dismiss();
                        AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                        StringBuilder sb = new StringBuilder("上传文件失败 ");
                        String str2 = "null";
                        if (fso == null) {
                            str = str2;
                        } else {
                            str = fso.f17063O000000o + " " + fso.O00000Oo;
                        }
                        sb.append(str);
                        audioRecordActivity.setLogTvText(sb.toString());
                        AudioRecordActivity audioRecordActivity2 = AudioRecordActivity.this;
                        StringBuilder sb2 = new StringBuilder("upload onFail ");
                        if (fso != null) {
                            str2 = fso.f17063O000000o + " " + fso.O00000Oo;
                        }
                        sb2.append(str2);
                        fag.O000000o(audioRecordActivity2, sb2.toString());
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            this.f4218O000000o.dismiss();
            setLogTvText("上传文件失败 Exception　" + e.getMessage());
            fag.O000000o(this, "Exception " + e.getMessage());
        }
    }

    public void queryVoiceCtrlReply() {
        if (TextUtils.isEmpty(this.sid)) {
            setLogTvText("queryVoiceCtrlReply sid is empty");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sid", "sid");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        CoreApi.O000000o().O000000o(this, new NetRequest.O000000o().O000000o("POST").O00000Oo("/voicectrl/reply").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.audiorecord.AudioRecordActivity.AnonymousClass7 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (AudioRecordActivity.this.isValid()) {
                    AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                    StringBuilder sb = new StringBuilder("获取语⾳音控制结果成功 ");
                    sb.append(jSONObject == null ? "" : jSONObject.toString());
                    audioRecordActivity.setLogTvText(sb.toString());
                    if (jSONObject.isNull("status") || jSONObject.optInt("status") != 1) {
                        AudioRecordActivity.this.f4218O000000o.dismiss();
                    } else {
                        AudioRecordActivity.this.mHandler.sendEmptyMessageDelayed(2, 3000);
                    }
                }
            }

            public final void onFailure(fso fso) {
                String str;
                if (AudioRecordActivity.this.isValid()) {
                    AudioRecordActivity audioRecordActivity = AudioRecordActivity.this;
                    StringBuilder sb = new StringBuilder("获取语⾳音控制结果失败 ");
                    if (fso == null) {
                        str = "null";
                    } else {
                        str = fso.f17063O000000o + " " + fso.O00000Oo;
                    }
                    sb.append(str);
                    audioRecordActivity.setLogTvText(sb.toString());
                    AudioRecordActivity.this.f4218O000000o.dismiss();
                }
            }
        });
    }
}
