package _m_j;

import _m_j.exo;
import _m_j.fvd;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.SmartHomeMainActivity;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.SHApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.login.ui.LoginMiuiActivity;
import com.xiaomi.smarthome.framework.navigate.UrlResolver;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import java.net.URLDecoder;

public final class fvg extends fvf {
    public fvg(Activity activity) {
        super(activity);
    }

    public final void O000000o(Intent intent) {
        Uri data = intent.getData();
        hld.O000000o();
        if (hld.O000000o(data)) {
            this.f17254O000000o.finish();
            return;
        }
        String uri = data.toString();
        if (!TextUtils.isEmpty(uri) && uri.startsWith("mihome://home.mi.com/miloan?url=")) {
            URLDecoder.decode(uri.substring(32));
            this.f17254O000000o.overridePendingTransition(0, 0);
            this.f17254O000000o.finish();
        } else if (uri.startsWith("mijia://plugin")) {
            CommonApplication.getApplication().sendBroadcast(new Intent("mijia://plugin").putExtra("url", uri));
        } else {
            final Uri O00000Oo = fvd.O00000Oo(data);
            fvd.O00000o0 O00000o0 = fvd.O00000o0(O00000Oo);
            if (O00000o0 == null) {
                if (!fvd.O000000o(O00000Oo)) {
                    this.f17254O000000o.finish();
                } else if (!O00000Oo.toString().equalsIgnoreCase("https://home.mi.com/download/")) {
                    try {
                        UrlResolver.O000000o(this.f17254O000000o, O00000Oo, false, false);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.f17254O000000o.finish();
                }
            } else if (O00000o0.O00000Oo) {
                if (!fvc.O000000o()) {
                    fno.O000000o().O0000Oo0();
                    Intent intent2 = new Intent(this.f17254O000000o, SmartHomeMainActivity.class);
                    intent2.putExtras(intent);
                    intent2.putExtra("source", 7);
                    intent2.putExtra("smarthome_launcher_intent", intent);
                    intent2.setFlags(268468224);
                    this.f17254O000000o.startActivity(intent2);
                    this.f17254O000000o.finish();
                } else if (!O00000o0.O00000o0) {
                    UrlResolver.O000000o(this.f17254O000000o, O00000Oo, false, false);
                    this.f17254O000000o.finish();
                } else if (CoreApi.O000000o().O0000Ooo()) {
                    UrlResolver.O000000o(this.f17254O000000o, O00000Oo, false, false);
                    this.f17254O000000o.finish();
                } else {
                    new MLAlertDialog.Builder(this.f17254O000000o).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class _m_j.fvg.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            fvg.this.O00000o0();
                            dialogInterface.dismiss();
                            fvg.this.f17254O000000o.finish();
                        }
                    }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                        /* class _m_j.fvg.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            fvg.this.f17254O000000o.finish();
                        }
                    }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                        /* class _m_j.fvg.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            fvg.this.f17254O000000o.finish();
                        }
                    }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
                }
            } else if (!O00000o0.O00000o0) {
                UrlResolver.O000000o(this.f17254O000000o, O00000Oo, false, false);
                this.f17254O000000o.finish();
            } else if (SHApplication.getStateNotifier().f15923O000000o != 3) {
                SHApplication.getStateNotifier().O000000o(new exo.O000000o() {
                    /* class _m_j.fvg.AnonymousClass4 */

                    public final void onLoginSuccess() {
                        if (UrlResolver.O000000o(fvg.this.f17254O000000o, O00000Oo, false, false)) {
                            fvg.this.f17254O000000o.finish();
                        }
                    }

                    public final void onLoginFailed() {
                        new MLAlertDialog.Builder(fvg.this.f17254O000000o).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class _m_j.fvg.AnonymousClass4.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                fvg.this.O00000o0();
                                dialogInterface.dismiss();
                                fvg.this.f17254O000000o.finish();
                            }
                        }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                            /* class _m_j.fvg.AnonymousClass4.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                fvg.this.f17254O000000o.finish();
                            }
                        }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                            /* class _m_j.fvg.AnonymousClass4.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                fvg.this.f17254O000000o.finish();
                            }
                        }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
                    }
                });
            } else {
                new MLAlertDialog.Builder(this.f17254O000000o).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class _m_j.fvg.AnonymousClass7 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        fvg.this.O00000o0();
                        dialogInterface.dismiss();
                        fvg.this.f17254O000000o.finish();
                    }
                }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                    /* class _m_j.fvg.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        fvg.this.f17254O000000o.finish();
                    }
                }).O000000o(true).O000000o(new DialogInterface.OnCancelListener() {
                    /* class _m_j.fvg.AnonymousClass5 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        fvg.this.f17254O000000o.finish();
                    }
                }).O00000Oo((int) R.string.loing_helper_title).O00000oo();
            }
        }
    }

    public final void O00000o0() {
        gge.O000000o().O00000Oo();
        fno.O000000o().O0000Oo();
        hor.O000000o().destroySceneManager();
        fno.O000000o().O0000Oo0();
        Intent intent = new Intent(this.f17254O000000o, LoginMiuiActivity.class);
        intent.setFlags(268435456);
        this.f17254O000000o.startActivity(intent);
        this.f17254O000000o.finish();
    }
}
