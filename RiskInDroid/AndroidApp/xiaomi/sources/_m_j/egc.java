package _m_j;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.snackbar.Snackbar;
import com.xiaomi.account.diagnosis.task.CollectAndUploadDiagnosisTask;
import com.xiaomi.accountsdk.account.ServerError;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.CommonErrorHandler$showCaptcha$1$1;
import com.xiaomi.passport.ui.internal.CommonErrorHandler$showCaptcha$1$2;
import com.xiaomi.smarthome.R;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002JV\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000b26\u0010\u001e\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u000f0\u001fJ \u0010$\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020%2\u0006\u0010&\u001a\u00020\rH\u0002J \u0010'\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020%H\u0002J\u0018\u0010)\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010+\u001a\u00020%H\u0002J\u0018\u0010,\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u001a\u0010-\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u00061"}, d2 = {"Lcom/xiaomi/passport/ui/internal/CommonErrorHandler;", "", "()V", "passportRepo", "Lcom/xiaomi/passport/ui/internal/PassportRepo;", "getPassportRepo", "()Lcom/xiaomi/passport/ui/internal/PassportRepo;", "setPassportRepo", "(Lcom/xiaomi/passport/ui/internal/PassportRepo;)V", "getCaptcha", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/passport/ui/internal/Captcha;", "url", "", "onIOError", "", "e", "Ljava/io/IOException;", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "onUnknownError", "tr", "", "showBigTh", "showCaptcha", "layoutInflater", "Landroid/view/LayoutInflater;", "captcha", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "ick", "showError", "", "msg", "showErrorWithLog", "msgId", "showLittleTh", "showMidTh", "resId", "showUnknownError", "showUnknownHostException", "showUnknownIOExceptionWithLog", "uploadLog", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egc {
    public static final O000000o O00000Oo = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    egr f15240O000000o = new egs();

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000O0o implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O0000O0o f15244O000000o = new O0000O0o();

        O0000O0o() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public final void O000000o(IOException iOException, Context context, View view) {
        ixe.O00000o0(iOException, "e");
        ixe.O00000o0(context, "context");
        if (iOException instanceof UnknownHostException) {
            O000000o(context, view);
        } else if (iOException instanceof SocketTimeoutException) {
            O000000o(context, iOException, (int) R.string.passport_timeout_network_error);
        } else {
            O000000o(context, iOException);
        }
    }

    public final void O000000o(Throwable th, Context context) {
        ixe.O00000o0(th, "tr");
        ixe.O00000o0(context, "context");
        if (th instanceof RuntimeException) {
            throw th;
        } else if (!(th instanceof Error)) {
            O000000o(context, th);
        } else {
            throw th;
        }
    }

    private final void O000000o(Context context, IOException iOException) {
        O000000o(context, iOException, (int) R.string.passport_unknow_network_error);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    private static void O000000o(Context context, View view) {
        if (view != null) {
            String string = context.getString(R.string.passport_unknow_host_network_error);
            ixe.O000000o((Object) string, "context.getString(R.stri…nknow_host_network_error)");
            O000000o(view, string);
            return;
        }
        O00000Oo(context);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    private final void O000000o(Context context, Throwable th) {
        if (th instanceof InvalidResponseException) {
            InvalidResponseException invalidResponseException = (InvalidResponseException) th;
            if (invalidResponseException.code == 10031) {
                int i = invalidResponseException.code;
                String str = invalidResponseException.codeDesc;
                ixe.O000000o((Object) str, "tr.codeDesc");
                O000000o(context, i, str);
                return;
            }
            ServerError serverError = invalidResponseException.getServerError();
            if (serverError != null) {
                O000000o.O000000o(context, serverError);
                return;
            }
        }
        O000000o(context, th, (int) R.string.passport_unknow_error);
    }

    private final void O000000o(Context context, Throwable th, int i) {
        AlertDialog create = new AlertDialog.Builder(context, 2132738558).setTitle(i).setMessage(th.toString()).setNegativeButton((int) R.string.upload_error_log, new O0000OOo(this, context, th)).setPositiveButton((int) R.string.passport_log_detail, new O0000Oo0(this, context, th)).create();
        boolean z = false;
        create.setCanceledOnTouchOutside(false);
        create.setCancelable(false);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            z = true;
        }
        if (!z) {
            create.show();
            TextView textView = (TextView) create.findViewById(16908299);
            if (textView != null) {
                textView.setTextSize(2, 10.0f);
            }
            if (textView != null) {
                textView.setTextIsSelectable(true);
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000OOo implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egc f15245O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ Throwable O00000o0;

        O0000OOo(egc egc, Context context, Throwable th) {
            this.f15245O000000o = egc;
            this.O00000Oo = context;
            this.O00000o0 = th;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            egc.O000000o(this.O00000Oo);
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O0000Oo0 implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egc f15247O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ Throwable O00000o0;

        O0000Oo0(egc egc, Context context, Throwable th) {
            this.f15247O000000o = egc;
            this.O00000Oo = context;
            this.O00000o0 = th;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            egc egc = this.f15247O000000o;
            Context context = this.O00000Oo;
            Throwable th = this.O00000o0;
            AlertDialog create = new AlertDialog.Builder(context).setMessage(Log.getStackTraceString(th)).setPositiveButton((int) R.string.passport_close, (DialogInterface.OnClickListener) null).setNegativeButton((int) R.string.upload_error_log, new O00000Oo(egc, context, th)).setCancelable(false).create();
            create.setCanceledOnTouchOutside(false);
            create.show();
            TextView textView = (TextView) create.findViewById(16908299);
            if (textView != null) {
                textView.setTextSize(2, 9.0f);
            }
            if (textView != null) {
                textView.setTextIsSelectable(true);
            }
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/xiaomi/passport/ui/internal/CommonErrorHandler$Companion;", "", "()V", "showErrorWithTips", "", "context", "Landroid/content/Context;", "serverError", "Lcom/xiaomi/accountsdk/account/ServerError;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static void O000000o(Context context, ServerError serverError) {
            ixe.O00000o0(context, "context");
            ixe.O00000o0(serverError, "serverError");
            if (serverError.getTips() != null) {
                View inflate = LayoutInflater.from(context).inflate((int) R.layout.server_error_with_tips_dialog, (ViewGroup) null);
                View findViewById = inflate.findViewById(R$id.msg);
                if (findViewById != null) {
                    TextView textView = (TextView) findViewById;
                    textView.setLinksClickable(true);
                    textView.setText(Html.fromHtml(serverError.getTips()));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    new AlertDialog.Builder(context).setTitle(serverError.getTitle()).setView(inflate).setPositiveButton(17039370, (DialogInterface.OnClickListener) null).create().show();
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
        }
    }

    private static void O000000o(Context context, int i, String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(str + " (" + i + ')').setPositiveButton(17039370, O0000O0o.f15244O000000o).create().show();
    }

    private static void O000000o(View view, String str) {
        Snackbar.make(view, str, 0).show();
    }

    private static void O00000Oo(Context context) {
        if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
            new AlertDialog.Builder(context).setMessage((int) R.string.passport_unknow_host_network_error).create().show();
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000Oo implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ egc f15241O000000o;
        final /* synthetic */ Context O00000Oo;
        final /* synthetic */ Throwable O00000o0;

        O00000Oo(egc egc, Context context, Throwable th) {
            this.f15241O000000o = egc;
            this.O00000Oo = context;
            this.O00000o0 = th;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            egc.O000000o(this.O00000Oo);
        }
    }

    public static void O000000o(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.sending));
        progressDialog.setCancelable(false);
        progressDialog.show();
        new CollectAndUploadDiagnosisTask(new O0000Oo(context, progressDialog), false).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "success", "", "traceId", "", "kotlin.jvm.PlatformType", "onFinished"}, k = 3, mv = {1, 1, 10})
    static final class O0000Oo implements CollectAndUploadDiagnosisTask.Callback {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ Context f15246O000000o;
        final /* synthetic */ ProgressDialog O00000Oo;

        O0000Oo(Context context, ProgressDialog progressDialog) {
            this.f15246O000000o = context;
            this.O00000Oo = progressDialog;
        }

        public final void onFinished(boolean z, String str) {
            Context context = this.f15246O000000o;
            if ((context instanceof Activity) && !((Activity) context).isFinishing()) {
                this.O00000Oo.dismiss();
                AlertDialog.Builder builder = new AlertDialog.Builder(this.f15246O000000o);
                if (!z || TextUtils.isEmpty(str)) {
                    builder.setMessage(this.f15246O000000o.getString(R.string.diagnosis_log_send_failed));
                } else {
                    builder.setMessage(this.f15246O000000o.getString(R.string.diagnosis_log_sent_format, str));
                }
                builder.setPositiveButton((int) R.string.ok, (DialogInterface.OnClickListener) null);
                builder.setCancelable(false);
                builder.show();
            }
        }
    }

    public final void O000000o(Context context, LayoutInflater layoutInflater, efz efz, iwn<? super String, ? super String, iuh> iwn) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(layoutInflater, "layoutInflater");
        ixe.O00000o0(efz, "captcha");
        ixe.O00000o0(iwn, "callback");
        View inflate = layoutInflater.inflate((int) R.layout.dg_captcha_layout, (ViewGroup) null);
        View findViewById = inflate.findViewById(R$id.captcha_input);
        if (findViewById != null) {
            EditText editText = (EditText) findViewById;
            View findViewById2 = inflate.findViewById(R$id.captcha_image);
            if (findViewById2 != null) {
                ImageView imageView = (ImageView) findViewById2;
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = efz.O00000Oo;
                imageView.setImageBitmap(efz.f15237O000000o);
                imageView.setOnClickListener(new O00000o0(this, efz, imageView, objectRef, context));
                new AlertDialog.Builder(context).setTitle((int) R.string.passport_captcha_title).setView(inflate).setPositiveButton(17039370, new O00000o(iwn, editText, objectRef)).create().show();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.EditText");
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 10})
    public static final class O00000o0 implements View.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        public final /* synthetic */ egc f15243O000000o;
        final /* synthetic */ efz O00000Oo;
        public final /* synthetic */ Ref.ObjectRef O00000o;
        public final /* synthetic */ ImageView O00000o0;
        public final /* synthetic */ Context O00000oO;

        O00000o0(egc egc, efz efz, ImageView imageView, Ref.ObjectRef objectRef, Context context) {
            this.f15243O000000o = egc;
            this.O00000Oo = efz;
            this.O00000o0 = imageView;
            this.O00000o = objectRef;
            this.O00000oO = context;
        }

        public final void onClick(View view) {
            egc egc = this.f15243O000000o;
            egc.f15240O000000o.O000000o(this.O00000Oo.O00000o0).O000000o(new CommonErrorHandler$showCaptcha$1$1(this), new CommonErrorHandler$showCaptcha$1$2(this));
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "<anonymous parameter 1>", "", "onClick"}, k = 3, mv = {1, 1, 10})
    static final class O00000o implements DialogInterface.OnClickListener {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ iwn f15242O000000o;
        final /* synthetic */ EditText O00000Oo;
        final /* synthetic */ Ref.ObjectRef O00000o0;

        O00000o(iwn iwn, EditText editText, Ref.ObjectRef objectRef) {
            this.f15242O000000o = iwn;
            this.O00000Oo = editText;
            this.O00000o0 = objectRef;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            ixe.O00000o0(dialogInterface, "<anonymous parameter 0>");
            this.f15242O000000o.invoke(this.O00000Oo.getText().toString(), (String) this.O00000o0.element);
        }
    }
}
