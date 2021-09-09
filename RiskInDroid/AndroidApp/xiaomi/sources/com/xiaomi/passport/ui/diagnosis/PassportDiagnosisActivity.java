package com.xiaomi.passport.ui.diagnosis;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.xiaomi.account.diagnosis.AccountDiagnosisLogger;
import com.xiaomi.account.diagnosis.DiagnosisController;
import com.xiaomi.account.diagnosis.DiagnosisLaunchCallback;
import com.xiaomi.account.diagnosis.task.CollectAndUploadDiagnosisTask;
import com.xiaomi.account.diagnosis.task.ReadLogcatTask;
import com.xiaomi.account.diagnosis.util.DiagnosisPreference;
import com.xiaomi.accountsdk.account.XMPassportSettings;
import com.xiaomi.accountsdk.utils.DiagnosisLog;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.smarthome.R;

public class PassportDiagnosisActivity extends AppCompatActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private View f6216O000000o;
    private View O00000Oo;
    private View.OnClickListener O00000o = new View.OnClickListener() {
        /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass2 */

        public final void onClick(View view) {
            if (!PassportDiagnosisActivity.this.mUploading) {
                PassportDiagnosisActivity passportDiagnosisActivity = PassportDiagnosisActivity.this;
                passportDiagnosisActivity.mLoadingDialog = new ProgressDialog(passportDiagnosisActivity);
                PassportDiagnosisActivity.this.mLoadingDialog.setMessage(PassportDiagnosisActivity.this.getString(R.string.sending));
                PassportDiagnosisActivity.this.mLoadingDialog.setCancelable(false);
                PassportDiagnosisActivity.this.mLoadingDialog.getWindow().setGravity(80);
                PassportDiagnosisActivity.this.mLoadingDialog.show();
                PassportDiagnosisActivity.this.mUploading = true;
                new CollectAndUploadDiagnosisTask(new CollectAndUploadDiagnosisTask.Callback() {
                    /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onFinished(boolean z, String str) {
                        PassportDiagnosisActivity.this.mUploading = false;
                        if (PassportDiagnosisActivity.this.mLoadingDialog != null) {
                            PassportDiagnosisActivity.this.mLoadingDialog.dismiss();
                        }
                        AlertDialog.Builder builder = new AlertDialog.Builder(PassportDiagnosisActivity.this);
                        if (!z || TextUtils.isEmpty(str)) {
                            builder.setMessage(PassportDiagnosisActivity.this.getString(R.string.diagnosis_log_send_failed));
                        } else {
                            builder.setMessage(PassportDiagnosisActivity.this.getString(R.string.diagnosis_log_sent_format, new Object[]{str}));
                        }
                        builder.setNeutralButton((int) R.string.ok, (DialogInterface.OnClickListener) null);
                        builder.setCancelable(false);
                        builder.show();
                    }
                }, false).execute(new Void[0]);
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener O00000o0 = new CompoundButton.OnCheckedChangeListener() {
        /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass1 */

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DiagnosisPreference.setDiagnosisEnabled(XMPassportSettings.getApplicationContext(), z);
            PassportDiagnosisActivity.this.setContentVisibility(z);
        }
    };
    public ProgressDialog mLoadingDialog;
    public ScrollView mLogScroller;
    public volatile boolean mUploading = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.passport_diagnosis);
        DiagnosisLog.set(new AccountDiagnosisLogger(getApplicationContext()));
        this.mLogScroller = (ScrollView) findViewById(R$id.log_scroller);
        this.O00000Oo = findViewById(R$id.upload_diagnosis);
        this.f6216O000000o = findViewById(R$id.footer);
        CompoundButton compoundButton = (CompoundButton) findViewById(R$id.switch_diagnosis);
        compoundButton.setChecked(DiagnosisPreference.isDiagnosisEnabled(XMPassportSettings.getApplicationContext()));
        compoundButton.setOnCheckedChangeListener(this.O00000o0);
        this.O00000Oo.setOnClickListener(this.O00000o);
        new ReadLogcatTask(this, new ReadLogcatTask.Callback() {
            /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass3 */

            public final void onReadLog(String str) {
                ((TextView) PassportDiagnosisActivity.this.findViewById(R$id.tv_log)).setText(str);
                PassportDiagnosisActivity.this.mLogScroller.post(new Runnable() {
                    /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        PassportDiagnosisActivity.this.mLogScroller.fullScroll(130);
                    }
                });
            }
        }, 512).execute(new Void[0]);
        setContentVisibility(DiagnosisPreference.isDiagnosisEnabled(XMPassportSettings.getApplicationContext()));
    }

    public void onResume() {
        super.onResume();
    }

    public void setContentVisibility(boolean z) {
        int i = z ? 0 : 8;
        this.mLogScroller.setVisibility(i);
        this.f6216O000000o.setVisibility(i);
        this.O00000Oo.setVisibility(i);
    }

    public static void start(final Context context) {
        DiagnosisController.get().checkStart(new DiagnosisLaunchCallback() {
            /* class com.xiaomi.passport.ui.diagnosis.PassportDiagnosisActivity.AnonymousClass4 */

            public final void onLaunch() {
                context.startActivity(new Intent(context, PassportDiagnosisActivity.class));
            }

            public final void onError() {
                Toast.makeText(context, (int) R.string.temporary_not_available, 0).show();
            }
        });
    }
}
