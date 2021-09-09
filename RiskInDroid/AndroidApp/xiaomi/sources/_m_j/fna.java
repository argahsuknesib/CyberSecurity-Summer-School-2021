package _m_j;

import _m_j.dxx;
import _m_j.ftt;
import _m_j.gsk;
import android.app.Dialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ToggleButton;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.MiTVDevice;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public final class fna {

    /* renamed from: O000000o  reason: collision with root package name */
    Dialog f16683O000000o = null;
    public Context O00000Oo;
    public View O00000o;
    public View O00000o0;
    public View O00000oO;
    public EditText O00000oo;
    public EditText O0000O0o;
    public MiTVDevice O0000OOo;
    public MLAlertDialog O0000Oo = null;
    public ftt<Void> O0000Oo0;
    String O0000OoO = "";
    public EditText O0000Ooo;
    public View O0000o0;
    public ToggleButton O0000o00;
    boolean O0000o0O = false;

    public final void O000000o() {
        Dialog dialog = this.f16683O000000o;
        if (dialog != null) {
            dialog.dismiss();
            this.f16683O000000o = null;
        }
    }

    public final void O000000o(boolean z) {
        this.O0000o0O = z;
        Context context = this.O00000Oo;
        O000000o();
        this.f16683O000000o = XQProgressDialog.O000000o(context, "", context.getString(R.string.camera_waiting));
        MiTVDevice miTVDevice = this.O0000OOo;
        String O0000o02 = CoreApi.O000000o().O0000o0();
        String obj = this.O0000Ooo.getText().toString();
        String str = this.O0000OoO;
        String obj2 = this.O00000oo.getText().toString();
        String obj3 = this.O0000O0o.getText().toString();
        AnonymousClass5 r5 = new ftt<JSONObject>() {
            /* class _m_j.fna.AnonymousClass5 */

            public final /* synthetic */ void O000000o(Object obj) {
                int i;
                JSONObject jSONObject = (JSONObject) obj;
                fna.this.O000000o();
                if (jSONObject != null) {
                    String str = null;
                    if ("success".equals(jSONObject.optString("result"))) {
                        fna.this.O0000OOo.setOwner(true);
                        fna.this.O0000OOo.userId = CoreApi.O000000o().O0000o0();
                        fno.O000000o().O000000o(fna.this.O0000OOo);
                        gwe.O000000o().O000000o(fna.this.O0000OOo);
                        if (fna.this.O0000Oo != null) {
                            fna.this.O0000Oo.dismiss();
                        }
                        fna fna = fna.this;
                        fna.O0000Oo = null;
                        if (fna.O0000Oo0 != null) {
                            fna.this.O0000Oo0.O000000o((Object) null);
                            return;
                        }
                        return;
                    }
                    int optInt = jSONObject.optInt("message");
                    if (optInt == 1) {
                        i = R.string.mitv_login_account_error_passwd;
                    } else if (optInt == 3 || optInt == 4 || optInt == 6 || optInt == 7 || optInt == 8) {
                        i = R.string.mitv_login_account_error_server;
                    } else {
                        if (optInt == 22 || optInt == 23) {
                            int optInt2 = jSONObject.optInt("version");
                            JSONObject optJSONObject = jSONObject.optJSONObject("userData");
                            if (optJSONObject != null) {
                                str = optJSONObject.optString("captchaurl");
                            }
                            if (optInt2 == 1 && !TextUtils.isEmpty(str)) {
                                fna fna2 = fna.this;
                                fna2.O0000OoO = "";
                                new Thread(str, new ftt<MiTVDevice.O000000o>() {
                                    /* class _m_j.fna.AnonymousClass5.AnonymousClass1 */

                                    public final /* synthetic */ void O000000o(Object obj) {
                                        MiTVDevice.O000000o o000000o = (MiTVDevice.O000000o) obj;
                                        fna.this.O00000o.setVisibility(0);
                                        ImageView imageView = (ImageView) fna.this.O00000o.findViewById(R.id.login_captchacode_image);
                                        imageView.setImageBitmap(o000000o.f6978O000000o);
                                        fna.this.O0000OoO = o000000o.O00000Oo;
                                        imageView.setOnClickListener(new View.OnClickListener() {
                                            /* class _m_j.fna.AnonymousClass5.AnonymousClass1.AnonymousClass1 */

                                            public final void onClick(View view) {
                                                fna.this.O000000o(true);
                                            }
                                        });
                                    }

                                    public final void O000000o(int i) {
                                        izb.O000000o(fna.this.O00000Oo, (int) R.string.mitv_login_account_captchacode_error_get, 0).show();
                                    }

                                    public final void O000000o(int i, Object obj) {
                                        izb.O000000o(fna.this.O00000Oo, (int) R.string.mitv_login_account_captchacode_error_get, 0).show();
                                    }
                                }) {
                                    /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass3 */

                                    /* renamed from: O000000o */
                                    final /* synthetic */ String f6974O000000o;
                                    final /* synthetic */ ftt O00000Oo;

                                    {
                                        this.f6974O000000o = r2;
                                        this.O00000Oo = r3;
                                    }

                                    public final void run() {
                                        try {
                                            final O000000o o000000o = new O000000o();
                                            URL url = new URL("https://account.xiaomi.com" + this.f6974O000000o);
                                            dxx.O000000o();
                                            HttpURLConnection httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
                                            o000000o.f6978O000000o = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
                                            Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                                            Iterator<String> it = headerFields.keySet().iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                String next = it.next();
                                                if ("Set-Cookie".equals(next)) {
                                                    List list = headerFields.get(next);
                                                    if (list != null) {
                                                        Iterator it2 = list.iterator();
                                                        while (true) {
                                                            if (!it2.hasNext()) {
                                                                break;
                                                            }
                                                            String str = (String) it2.next();
                                                            if (str.startsWith("ick=")) {
                                                                o000000o.O00000Oo = str.substring(4);
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            MiTVDevice.this.mMainHandler.post(new Runnable() {
                                                /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass3.AnonymousClass1 */

                                                public final void run() {
                                                    if (AnonymousClass3.this.O00000Oo != null) {
                                                        AnonymousClass3.this.O00000Oo.O000000o(o000000o);
                                                    }
                                                }
                                            });
                                        } catch (Exception unused) {
                                            MiTVDevice.this.mMainHandler.post(new Runnable() {
                                                /* class com.xiaomi.smarthome.device.MiTVDevice.AnonymousClass3.AnonymousClass2 */

                                                public final void run() {
                                                    if (AnonymousClass3.this.O00000Oo != null) {
                                                        AnonymousClass3.this.O00000Oo.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }.start();
                            }
                        } else if (optInt == 30) {
                            i = R.string.mitv_login_account_error_decode;
                        } else if (optInt != 31) {
                            switch (optInt) {
                                case 18:
                                    i = R.string.mitv_login_account_error_invalid_user;
                                    break;
                                case 19:
                                    i = R.string.mitv_login_account_error_already_login;
                                    break;
                                case 20:
                                    int optInt3 = jSONObject.optInt("version");
                                    jSONObject.optJSONObject("userData");
                                    if (optInt3 == 1) {
                                        fna.this.O00000oO.setVisibility(0);
                                    }
                                default:
                                    i = 0;
                                    break;
                            }
                        } else {
                            i = R.string.mitv_login_account_error_format;
                        }
                        i = 0;
                    }
                    if (i > 0 && !fna.this.O0000o0O) {
                        izb.O000000o(fna.this.O00000Oo, i, 0).show();
                    }
                    if (fna.this.O0000Oo0 != null) {
                        fna.this.O0000Oo0.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                    }
                }
            }

            public final void O000000o(int i) {
                fna fna = fna.this;
                fna.O0000Oo = null;
                fna.O000000o();
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "", "binding network onFailure" + fna.this.O0000OOo.did);
                fna.this.O0000OOo.setOwner(false);
                if (i == ErrorCode.ERROR_NO_METHOD.getCode()) {
                    izb.O000000o(fna.this.O00000Oo, (int) R.string.button_bind_failed_old_version, 0).show();
                } else {
                    izb.O000000o(fna.this.O00000Oo, (int) R.string.button_bind_failed, 0).show();
                }
                if (fna.this.O0000Oo0 != null) {
                    fna.this.O0000Oo0.O000000o(i);
                }
            }

            public final void O000000o(int i, Object obj) {
                fna fna = fna.this;
                fna.O0000Oo = null;
                fna.O000000o();
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "", "binding network onFailure" + fna.this.O0000OOo.did);
                fna.this.O0000OOo.setOwner(false);
                if (i == ErrorCode.ERROR_NO_METHOD.getCode()) {
                    izb.O000000o(fna.this.O00000Oo, (int) R.string.button_bind_failed_old_version, 0).show();
                } else {
                    izb.O000000o(fna.this.O00000Oo, (int) R.string.button_bind_failed, 0).show();
                }
                if (fna.this.O0000Oo0 != null) {
                    fna.this.O0000Oo0.O000000o(i);
                }
            }
        };
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("logintype", 2);
                jSONObject.put("vericode", obj3);
            } else if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("logintype", 1);
                jSONObject.put("ick", str);
                jSONObject.put("captchacode", obj2);
            } else {
                jSONObject.put("logintype", 0);
            }
            jSONObject.put("name", O0000o02);
            jSONObject.put("password", obj);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        fuc O000000o2 = fuc.O000000o();
        CommonApplication.getAppContext();
        String str2 = miTVDevice.did;
        String str3 = miTVDevice.ip;
        String substring = str2.startsWith("mitv.") ? str2.substring(5) : str2;
        int indexOf = substring.indexOf(58);
        if (indexOf > 0) {
            substring = substring.substring(0, indexOf);
        }
        gsg.O000000o(O000000o2.O00000o, new gsk.O000000o().O000000o("GET").O00000Oo(String.format("http://%s:6095/account?action=addNew&data=%s", str3, Uri.encode(fnc.O000000o(substring, jSONObject2)))).O000000o(), new gso(str2, r5) {
            /* class _m_j.fuc.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ String f17156O000000o;
            final /* synthetic */ ftt O00000Oo;

            {
                this.f17156O000000o = r2;
                this.O00000Oo = r3;
            }

            public final /* synthetic */ void onSuccess(Object obj, Response response) {
                O000000o((String) obj);
            }

            public final void O000000o(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (jSONObject.optInt("status") == 0) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        fnh.O000000o().O00000Oo(this.f17156O000000o);
                        if (this.O00000Oo != null) {
                            this.O00000Oo.O000000o(optJSONObject);
                            return;
                        }
                        return;
                    }
                } catch (JSONException unused) {
                }
                ftt ftt = this.O00000Oo;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                }
            }

            public final void onFailure(gsf gsf, Exception exc, Response response) {
                ftt ftt = this.O00000Oo;
                if (ftt != null) {
                    ftt.O000000o(ErrorCode.ERROR_UNKNOWN_ERROR.getCode());
                }
            }
        });
    }
}
