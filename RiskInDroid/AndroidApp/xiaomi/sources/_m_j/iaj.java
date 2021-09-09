package _m_j;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.modelbiz.JumpToBizProfile;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.Parser;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class iaj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f1092O000000o = false;
    public static final File O00000oo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), "Xiaomi");
    public static final File O0000O0o = new File(O00000oo, "local");
    private static volatile iaj O0000Oo;
    private static IWXAPI O0000OoO;
    Bitmap O00000Oo = null;
    Dialog O00000o;
    public Dialog O00000o0 = null;
    public boolean O00000oO;
    public boolean O0000OOo = false;
    public AsyncTask<String, Void, Integer> O0000Oo0;

    private iaj() {
    }

    public static iaj O000000o() {
        if (O0000Oo == null) {
            synchronized (iaj.class) {
                if (O0000Oo == null) {
                    O0000Oo = new iaj();
                }
            }
        }
        return O0000Oo;
    }

    public final void O000000o(Activity activity, String str, String str2, boolean z, int i, Callback<Boolean> callback) {
        final Activity activity2 = activity;
        final Callback<Boolean> callback2 = callback;
        final int i2 = i;
        final String str3 = str;
        final String str4 = str2;
        final boolean z2 = z;
        O000000o().O00000Oo(str, str2, new Callback<JSONObject>() {
            /* class _m_j.iaj.AnonymousClass1 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
             arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
             candidates:
              ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
              ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject != null) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (jSONObject2 != null) {
                            boolean optBoolean = jSONObject2.optBoolean("binding");
                            boolean optBoolean2 = jSONObject2.optBoolean("isfollow");
                            if (!optBoolean) {
                                iaj.O000000o();
                                if (!iaj.O000000o(activity2.getApplicationContext()).isWXAppInstalled()) {
                                    izb.O000000o(activity2, activity2.getApplicationContext().getText(R.string.mj_wx_not_installed), 0).show();
                                    if (callback2 != null) {
                                        callback2.onFailure(-9999, "WeiXin is not installed!");
                                        return;
                                    }
                                    return;
                                }
                                final Dialog dialog = new Dialog(activity2);
                                View inflate = LayoutInflater.from(activity2.getApplicationContext()).inflate((int) R.layout.mjwx_bind_alert_dialog, (ViewGroup) null);
                                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
                                layoutParams.setMargins(gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f));
                                inflate.setLayoutParams(layoutParams);
                                ((TextView) inflate.findViewById(R.id.message)).setText((int) R.string.wx_push_tip);
                                Button button = (Button) inflate.findViewById(R.id.btnPositive);
                                button.setText(activity2.getApplicationContext().getString(R.string.wx_push_bind));
                                button.setOnClickListener(new View.OnClickListener() {
                                    /* class _m_j.iaj.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(View view) {
                                        fsp.O000000o().O0000Oo.openWxBindActivity(activity2, i2);
                                        iaj.f1092O000000o = true;
                                        dialog.dismiss();
                                    }
                                });
                                Button button2 = (Button) inflate.findViewById(R.id.btnNegative);
                                button2.setText(activity2.getApplicationContext().getString(R.string.sh_common_cancel));
                                button2.setOnClickListener(new View.OnClickListener() {
                                    /* class _m_j.iaj.AnonymousClass1.AnonymousClass2 */

                                    public final void onClick(View view) {
                                        dialog.dismiss();
                                    }
                                });
                                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                    /* class _m_j.iaj.AnonymousClass1.AnonymousClass3 */

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        if (!iaj.f1092O000000o && callback2 != null) {
                                            callback2.onFailure(-9999, "wx mj bind cancelled by user!");
                                        }
                                        iaj.f1092O000000o = false;
                                    }
                                });
                                dialog.setContentView(inflate);
                                Window window = dialog.getWindow();
                                if (window != null) {
                                    window.setGravity(80);
                                    window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), 0, 0, 0, 0));
                                    WindowManager.LayoutParams attributes = window.getAttributes();
                                    attributes.width = -1;
                                    attributes.height = -2;
                                    window.setAttributes(attributes);
                                }
                                dialog.show();
                            } else if (!optBoolean2) {
                                iaj.O000000o().O000000o(activity2, str3, str4, callback2);
                            } else {
                                iaj.O000000o().O000000o(str3, str4, z2, callback2);
                            }
                        } else if (callback2 != null) {
                            callback2.onFailure(-1, "Get wx status data is NULL!");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }

            public final void onFailure(int i, String str) {
                Callback callback = callback2;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        });
    }

    private void O00000Oo(String str, String str2, final Callback<JSONObject> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("region", "DEFAULT");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginHostApi.instance().callSmartHomeApi(str, "connect.camera.", "/wx/app/v1/status", "GET", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.iaj.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(jSONObject);
                }
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "WxPushHelper", "Get wx status failed! Error: " + i + ", Info: " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(final Activity activity, String str, final String str2, final Callback<Boolean> callback) {
        if (!O000000o(activity.getApplicationContext()).isWXAppInstalled()) {
            izb.O000000o(activity, activity.getApplicationContext().getText(R.string.mj_wx_not_installed), 0).show();
            if (callback != null) {
                callback.onFailure(-9999, "WeiXin is not installed!");
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("region", "DEFAULT");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginHostApi.instance().callSmartHomeApi(str, "connect.camera.", "/wx/app/v1/getTicket", "GET", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.iaj.AnonymousClass4 */

            public final /* synthetic */ void onSuccess(Object obj) {
                String str;
                try {
                    str = ((JSONObject) obj).getJSONObject("data").optString("ticket");
                } catch (JSONException e) {
                    e.printStackTrace();
                    str = "";
                }
                iaj iaj = iaj.this;
                iaj.O0000Oo0 = new AsyncTask<String, Void, Integer>(str2, activity, callback) {
                    /* class _m_j.iaj.AnonymousClass7 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f1103O000000o;
                    final /* synthetic */ Activity O00000Oo;
                    final /* synthetic */ Callback O00000o0;

                    {
                        this.f1103O000000o = r2;
                        this.O00000Oo = r3;
                        this.O00000o0 = r4;
                    }

                    /* access modifiers changed from: protected */
                    public final /* synthetic */ void onPostExecute(Object obj) {
                        Integer num = (Integer) obj;
                        super.onPostExecute(num);
                        iaj iaj = iaj.this;
                        iaj.O00000oO = true;
                        iaj.O00000Oo();
                        this.O00000Oo.isFinishing();
                        if (num.intValue() == 0) {
                            iaj iaj2 = iaj.this;
                            Activity activity = this.O00000Oo;
                            String str = this.f1103O000000o;
                            Callback callback = this.O00000o0;
                            if (iaj2.O00000o0 != null && iaj2.O00000o0.isShowing()) {
                                iaj2.O00000o0.dismiss();
                            }
                            String O000000o2 = iaj.O000000o(str);
                            View inflate = LayoutInflater.from(activity.getApplicationContext()).inflate((int) R.layout.wx_guid_tip, (ViewGroup) null);
                            iaj2.O00000o0 = new Dialog(activity);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(iaj.O000000o(activity, 288.0f), iaj.O000000o(activity, 369.0f));
                            iaj2.O00000o0.requestWindowFeature(1);
                            iaj2.O00000o0.setContentView(inflate, layoutParams);
                            Window window = iaj2.O00000o0.getWindow();
                            if (window != null) {
                                window.setGravity(17);
                                WindowManager.LayoutParams attributes = window.getAttributes();
                                attributes.width = -2;
                                attributes.height = -2;
                                window.setAttributes(attributes);
                            }
                            ImageView imageView = (ImageView) inflate.findViewById(R.id.wx_guid_album);
                            Locale locale = activity.getApplicationContext().getResources().getConfiguration().locale;
                            if (!(locale == null || locale.getLanguage() == null || locale.getLanguage().equals("zh"))) {
                                imageView.setImageResource(R.drawable.wx_push_4);
                            }
                            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.guid_wx_qcord);
                            if (iaj2.O00000Oo != null && !iaj2.O00000Oo.isRecycled()) {
                                iaj2.O00000Oo.recycle();
                            }
                            iaj2.O00000Oo = BitmapFactory.decodeFile(O000000o2);
                            imageView2.setImageBitmap(iaj2.O00000Oo);
                            inflate.findViewById(R.id.wx_push_ok).setOnClickListener(new View.OnClickListener(activity) {
                                /* class _m_j.iaj.AnonymousClass8 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ Activity f1104O000000o;

                                {
                                    this.f1104O000000o = r2;
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
                                public final void onClick(View view) {
                                    try {
                                        Intent intent = new Intent();
                                        intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
                                        intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
                                        intent.setFlags(335544320);
                                        intent.setAction("android.intent.action.VIEW");
                                        this.f1104O000000o.startActivity(intent);
                                        iaj.this.O0000OOo = true;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    if (!iaj.this.O0000OOo) {
                                        IWXAPI createWXAPI = XmPluginHostApi.instance().createWXAPI(this.f1104O000000o.getApplicationContext(), true);
                                        JumpToBizProfile.Req req = new JumpToBizProfile.Req();
                                        req.toUserName = "gh_81a506b5df46";
                                        req.profileType = 1;
                                        req.extMsg = "";
                                        createWXAPI.sendReq(req);
                                        iaj.this.O0000OOo = true;
                                    }
                                    if (iaj.this.O00000o0 != null && iaj.this.O00000o0.isShowing()) {
                                        iaj.this.O00000o0.dismiss();
                                    }
                                }
                            });
                            iaj2.O00000o0.setCancelable(true);
                            iaj2.O00000o0.setOnDismissListener(new DialogInterface.OnDismissListener(callback) {
                                /* class _m_j.iaj.AnonymousClass9 */

                                /* renamed from: O000000o  reason: collision with root package name */
                                final /* synthetic */ Callback f1105O000000o;

                                {
                                    this.f1105O000000o = r2;
                                }

                                public final void onDismiss(DialogInterface dialogInterface) {
                                    Callback callback;
                                    if (!iaj.this.O0000OOo && (callback = this.f1105O000000o) != null) {
                                        callback.onFailure(-9999, "wx bind cancelled!");
                                    }
                                    iaj.this.O0000OOo = false;
                                }
                            });
                            iaj2.O00000o0.show();
                        }
                    }

                    /* access modifiers changed from: private */
                    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d9 A[SYNTHETIC, Splitter:B:40:0x00d9] */
                    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f3 A[SYNTHETIC, Splitter:B:49:0x00f3] */
                    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe A[SYNTHETIC, Splitter:B:55:0x00fe] */
                    /* JADX WARNING: Unknown top exception splitter block from list: {B:46:0x00e3=Splitter:B:46:0x00e3, B:37:0x00c9=Splitter:B:37:0x00c9} */
                    /* renamed from: O000000o */
                    public Integer doInBackground(String... strArr) {
                        String str = strArr[0];
                        String str2 = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=" + URLEncoder.encode(str);
                        String O000000o2 = iaj.O000000o(this.f1103O000000o);
                        if (TextUtils.isEmpty(O000000o2)) {
                            return -1;
                        }
                        gsy.O000000o(6, "WxPushHelper", "WxQrcode pic file path: ".concat(String.valueOf(O000000o2)));
                        FileOutputStream fileOutputStream = null;
                        try {
                            byte[] bArr = new byte[1024];
                            FileOutputStream fileOutputStream2 = new FileOutputStream(O000000o2);
                            try {
                                URL url = new URL(str2);
                                dxx.O000000o();
                                HttpURLConnection httpURLConnection = (HttpURLConnection) dxx.O000000o(url);
                                httpURLConnection.setConnectTimeout(5000);
                                httpURLConnection.setReadTimeout(5000);
                                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                                httpURLConnection.connect();
                                int responseCode = httpURLConnection.getResponseCode();
                                if (responseCode != 200) {
                                    Integer valueOf = Integer.valueOf(responseCode);
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    return valueOf;
                                }
                                gsy.O000000o(6, "WxPushHelper", "qr code: ".concat(String.valueOf(responseCode)));
                                InputStream inputStream = httpURLConnection.getInputStream();
                                while (true) {
                                    int read = inputStream.read(bArr, 0, 1024);
                                    if (read < 0) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.flush();
                                PluginHostApi.instance().context().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(O000000o2))));
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                                return 0;
                            } catch (MalformedURLException e3) {
                                e = e3;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                gsy.O000000o(6, "WxPushHelper", e.toString());
                                if (fileOutputStream != null) {
                                }
                                return -2;
                            } catch (IOException e4) {
                                e = e4;
                                fileOutputStream = fileOutputStream2;
                                try {
                                    e.printStackTrace();
                                    gsy.O000000o(6, "WxPushHelper", e.toString());
                                    if (fileOutputStream != null) {
                                    }
                                    return -2;
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (fileOutputStream2 != null) {
                                }
                                throw th;
                            }
                        } catch (MalformedURLException e6) {
                            e = e6;
                            e.printStackTrace();
                            gsy.O000000o(6, "WxPushHelper", e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                }
                            }
                            return -2;
                        } catch (IOException e8) {
                            e = e8;
                            e.printStackTrace();
                            gsy.O000000o(6, "WxPushHelper", e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                }
                            }
                            return -2;
                        }
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void}
                     arg types: [android.graphics.drawable.ColorDrawable, int, int, int, int]
                     candidates:
                      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, float, float, float, float):void}
                      ClspMth{android.graphics.drawable.InsetDrawable.<init>(android.graphics.drawable.Drawable, int, int, int, int):void} */
                    /* access modifiers changed from: protected */
                    public final void onPreExecute() {
                        super.onPreExecute();
                        iaj iaj = iaj.this;
                        Activity activity = this.O00000Oo;
                        Callback callback = this.O00000o0;
                        iaj.O00000Oo();
                        iaj.O00000o = new Dialog(activity);
                        View inflate = LayoutInflater.from(activity.getApplicationContext()).inflate((int) R.layout.wx_progress_dialog, (ViewGroup) null);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
                        layoutParams.setMargins(gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f));
                        inflate.setLayoutParams(layoutParams);
                        ((TextView) inflate.findViewById(R.id.progress_message)).setText(activity.getApplicationContext().getString(R.string.smb_waiting));
                        iaj.O00000o.setOnDismissListener(new DialogInterface.OnDismissListener(callback) {
                            /* class _m_j.iaj.AnonymousClass10 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Callback f1097O000000o;

                            {
                                this.f1097O000000o = r2;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                Callback callback;
                                if (!iaj.this.O00000oO && (callback = this.f1097O000000o) != null) {
                                    callback.onFailure(-9999, "wx bind cancelled by user!");
                                }
                                iaj.this.O00000oO = false;
                            }
                        });
                        ((TextView) inflate.findViewById(R.id.cancel_btn)).setOnClickListener(new View.OnClickListener() {
                            /* class _m_j.iaj.AnonymousClass2 */

                            public final void onClick(View view) {
                                iaj.this.O00000Oo();
                                if (iaj.this.O0000Oo0 != null && !iaj.this.O0000Oo0.isCancelled()) {
                                    iaj.this.O0000Oo0.cancel(true);
                                }
                            }
                        });
                        iaj.O00000o.setContentView(inflate);
                        Window window = iaj.O00000o.getWindow();
                        if (window != null) {
                            window.setGravity(80);
                            window.setBackgroundDrawable(new InsetDrawable((Drawable) new ColorDrawable(0), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f), gri.O000000o(8.0f)));
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.width = -1;
                            attributes.height = -2;
                            window.setAttributes(attributes);
                        }
                        iaj.O00000o.show();
                    }
                };
                iaj.O0000Oo0.execute(str);
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "WxPushHelper", "Get wx ticket failed! Error: " + i + ", Info: " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(String str, String str2, boolean z, final Callback<Boolean> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("open", z);
            jSONObject.put("region", "DEFAULT");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginHostApi.instance().callSmartHomeApi(str, "connect.camera.", "/wx/app/v1/put/pushSwitch", "POST", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.iaj.AnonymousClass5 */

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "WxPushHelper", " set WX push error " + i + " info " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(Boolean.TRUE);
                }
                gsy.O000000o(6, "WxPushHelper", " set WX push onSuccess ");
            }
        }, Parser.DEFAULT_PARSER);
    }

    public final void O000000o(String str, String str2, final Callback<Boolean> callback) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str2);
            jSONObject.put("region", "DEFAULT");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PluginHostApi.instance().callSmartHomeApi(str, "connect.camera.", "/wx/app/v1/get/pushSwitch", "GET", jSONObject, new Callback<JSONObject>() {
            /* class _m_j.iaj.AnonymousClass6 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (callback != null) {
                    boolean z = false;
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        if (jSONObject2 != null) {
                            z = jSONObject2.optBoolean("pushSwitch", false);
                            gsy.O000000o(6, "WxPushHelper", "Get wx push status = ".concat(String.valueOf(z)));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    callback.onSuccess(Boolean.valueOf(z));
                }
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(6, "WxPushHelper", "Get wx push error " + i + " info " + str);
                Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(i, str);
                }
            }
        }, Parser.DEFAULT_PARSER);
    }

    public static IWXAPI O000000o(Context context) {
        if (O0000OoO == null) {
            IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, "wx54b959a68fb6f580", true);
            O0000OoO = createWXAPI;
            createWXAPI.registerApp("wx54b959a68fb6f580");
        }
        return O0000OoO;
    }

    public final void O00000Oo() {
        Dialog dialog = this.O00000o;
        if (dialog != null && dialog.isShowing()) {
            this.O00000o.dismiss();
        }
        this.O00000o = null;
    }

    static int O000000o(Activity activity, float f) {
        return (int) ((f * activity.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String O000000o(String str) {
        String str2 = O0000O0o + File.separator + str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        } else {
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        File file2 = new File(str2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, "wxQcord.jpg").getAbsolutePath();
    }
}
