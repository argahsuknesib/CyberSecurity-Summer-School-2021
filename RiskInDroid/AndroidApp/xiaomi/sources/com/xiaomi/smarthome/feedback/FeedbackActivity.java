package com.xiaomi.smarthome.feedback;

import _m_j.bnj;
import _m_j.eyg;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.fuh;
import _m_j.fuo;
import _m_j.gae;
import _m_j.gos;
import _m_j.gqb;
import _m_j.gsy;
import _m_j.iue;
import _m_j.iuh;
import _m_j.ivz;
import _m_j.ixe;
import _m_j.izb;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.feedback.FeedbackActivity;
import com.xiaomi.smarthome.feedback.view.ImagePickerPreview;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class FeedbackActivity extends BaseActivity implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    Context f7378O000000o;
    TextView O00000Oo;
    TextView O00000o;
    TextView O00000o0;
    EditText O00000oO;
    EditText O00000oo;
    EditText O0000O0o;
    Device O0000OOo;
    fuo O0000Oo;
    String O0000Oo0;
    MLAlertDialog O0000OoO;
    private TextView O0000Ooo;
    private String O0000o0;
    private String O0000o00;
    private int O0000o0O;
    public View llType;
    public ImagePickerPreview mImagePreview;
    public ArrayList<FeedbackLabelEntity> mRequestLabel;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7378O000000o = this;
        String stringExtra = getIntent().getStringExtra("extra_device_did");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.O0000OOo = fno.O000000o().O000000o(stringExtra);
        }
        Device device = this.O0000OOo;
        if (device != null) {
            this.O0000Oo0 = device.model;
        } else {
            this.O0000Oo0 = getIntent().getStringExtra("extra_device_model");
        }
        this.O0000o0O = getIntent().getIntExtra("extra_source", 0);
        setContentView((int) R.layout.feedback_activity);
        ((TextView) findViewById(R.id.module_a_3_return_title)).setText((int) R.string.mj_feedback);
        findViewById(R.id.module_a_3_return_btn).setOnClickListener(this);
        String feedbackDeviceName = FeedbackManager.INSTANCE.getFeedbackDeviceName(getContext(), this.O0000Oo0);
        if (feedbackDeviceName == null || feedbackDeviceName.isEmpty()) {
            feedbackDeviceName = getString(R.string.mj_feedback);
        }
        ((TextView) findViewById(R.id.feedback_device_name)).setText(feedbackDeviceName);
        this.O00000Oo = (TextView) findViewById(R.id.module_a_3_right_tv_text);
        this.O00000Oo.setVisibility(8);
        this.O00000o = (TextView) findViewById(R.id.submit);
        this.O00000o0 = (TextView) findViewById(R.id.submit_with_log);
        this.O0000Ooo = (TextView) findViewById(R.id.tvType);
        this.O0000O0o = (EditText) findViewById(R.id.et_router_model);
        this.O00000oO = (EditText) findViewById(R.id.content);
        this.O00000oo = (EditText) findViewById(R.id.et_contact);
        this.llType = findViewById(R.id.llType);
        this.O00000oO.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass2 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString().trim()) && editable.toString().length() > 500) {
                    izb.O000000o(FeedbackActivity.this.f7378O000000o, FeedbackActivity.this.getResources().getQuantityString(R.plurals.feedback_content_length_tips, 500, 500), 0).show();
                    editable.delete(501, editable.toString().length());
                }
            }
        });
        this.O00000oo.addTextChangedListener(new TextWatcher() {
            /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass3 */

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (!TextUtils.isEmpty(editable.toString().trim()) && editable.toString().length() > 32) {
                    izb.O000000o(FeedbackActivity.this.f7378O000000o, FeedbackActivity.this.getResources().getQuantityString(R.plurals.feedback_contact_length_tips, 32, 32), 0).show();
                    editable.delete(33, editable.toString().length());
                }
            }
        });
        this.mImagePreview = (ImagePickerPreview) findViewById(R.id.image_pick_preview);
        if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
            this.O00000o0.setVisibility(8);
            this.O00000o.setBackgroundResource(R.drawable.normal_confirm_button);
            this.O00000o.setTextColor(getResources().getColor(R.color.mj_color_white));
            this.mImagePreview.setVisibility(8);
            findViewById(R.id.add_new_image).setVisibility(8);
        }
        O000000o((String) null);
        bnj.O000000o(this.O00000o).throttleFirst(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.smarthome.feedback.$$Lambda$FeedbackActivity$uDYA0DDNiVg1upo2jJESyr9SJY */

            public final void call(Object obj) {
                FeedbackActivity.this.O00000Oo((Void) obj);
            }
        });
        bnj.O000000o(this.O00000o0).throttleFirst(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() {
            /* class com.xiaomi.smarthome.feedback.$$Lambda$FeedbackActivity$GJCEpdnGqU7AtQ0bEj9bW29bKCw */

            public final void call(Object obj) {
                FeedbackActivity.this.O000000o((Void) obj);
            }
        });
        this.llType.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.feedback.$$Lambda$FeedbackActivity$ARkOo2VU3cmoZIG6UT2UKol2pD4 */

            public final void onClick(View view) {
                FeedbackActivity.this.O000000o(view);
            }
        });
        FeedbackApi.INSTANCE.requestLabels(this, this.O0000Oo0, new fsm<ArrayList<FeedbackLabelEntity>, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            XQProgressDialog f7379O000000o = new XQProgressDialog(FeedbackActivity.this);
            Runnable O00000Oo = new Runnable() {
                /* class com.xiaomi.smarthome.feedback.$$Lambda$FeedbackActivity$1$QnTPW0LewolKt1YyYyUj2cajeH0 */

                public final void run() {
                    FeedbackActivity.AnonymousClass1.this.O000000o();
                }
            };

            {
                FeedbackActivity.this.mHandler.postDelayed(this.O00000Oo, 500);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                ArrayList<FeedbackLabelEntity> arrayList = (ArrayList) obj;
                FeedbackActivity.this.mRequestLabel = arrayList;
                if (arrayList.size() > 0) {
                    FeedbackActivity.this.llType.setVisibility(0);
                } else {
                    FeedbackActivity.this.llType.setVisibility(8);
                }
                this.f7379O000000o.dismiss();
                this.f7379O000000o = null;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void O000000o() {
                XQProgressDialog xQProgressDialog = this.f7379O000000o;
                if (xQProgressDialog != null) {
                    xQProgressDialog.setMessage(FeedbackActivity.this.getString(R.string.loading_page));
                    this.f7379O000000o.O000000o(true);
                    this.f7379O000000o.setCancelable(false);
                    this.f7379O000000o.show();
                }
            }

            public final void onFailure(fso fso) {
                FeedbackActivity.this.llType.setVisibility(8);
                this.f7379O000000o.dismiss();
                this.f7379O000000o = null;
            }
        });
        gsy.O00000o0(LogType.DEVICE_LIST, "LogDumper", eyg.f15944O000000o.toString());
        gsy.O000000o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(Void voidR) {
        String O000000o2 = O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            O00000Oo(O000000o2);
        } else {
            O000000o(false);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(Void voidR) {
        String O000000o2 = O000000o();
        if (!TextUtils.isEmpty(O000000o2)) {
            O00000Oo(O000000o2);
        } else {
            O000000o(true);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        startActivityForResult(new Intent(getApplicationContext(), FeedbackLabelActivity.class).putParcelableArrayListExtra("data", this.mRequestLabel).putExtra("model", this.O0000Oo0).putExtra("Wid", this.O0000o00).putExtra("tagid", this.O0000o0), 704);
    }

    public void setSubmutBtnEnable(boolean z) {
        this.O00000o.setEnabled(z);
        this.O00000o0.setEnabled(z);
    }

    private void O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            this.O0000Ooo.setText((int) R.string.require);
        } else {
            this.O0000Ooo.setText(str);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Cursor query;
        Closeable closeable;
        super.onActivityResult(i, i2, intent);
        if (i != 704) {
            ImagePickerPreview imagePickerPreview = this.mImagePreview;
            ixe.O00000o(this, "activity");
            if (i == 703 && i2 == -1) {
                Uri data = intent == null ? null : intent.getData();
                if (data != null && !TextUtils.isEmpty(data.getAuthority()) && (query = getContentResolver().query(data, new String[]{"_data"}, null, null, null)) != null) {
                    try {
                        Result.O000000o o000000o = Result.f15374O000000o;
                        closeable = query;
                        query.moveToFirst();
                        String string = query.getString(query.getColumnIndex("_data"));
                        if (!TextUtils.isEmpty(string)) {
                            ixe.O00000Oo(string, "picPath");
                            ixe.O00000o(string, "filePath");
                            if (!imagePickerPreview.O00000Oo.O000000o()) {
                                BitmapFactory.Options options = new BitmapFactory.Options();
                                options.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(string, options);
                                int O000000o2 = gos.O000000o(options.outWidth, options.outHeight, 150, 22500);
                                BitmapFactory.Options options2 = new BitmapFactory.Options();
                                options2.inJustDecodeBounds = false;
                                options2.inSampleSize = O000000o2;
                                imagePickerPreview.O00000Oo.add(new Pair(string, BitmapFactory.decodeFile(string, options2)));
                                imagePickerPreview.O000000o();
                            }
                        }
                        iuh iuh = iuh.f1631O000000o;
                        ivz.O000000o(closeable, null);
                        Result.O00000o0(iuh.f1631O000000o);
                    } catch (Throwable th) {
                        Result.O000000o o000000o2 = Result.f15374O000000o;
                        Result.O00000o0(iue.O000000o(th));
                    }
                }
            }
        } else if (i2 == -1 && intent != null) {
            O000000o(intent.getStringExtra("name"));
            this.O0000o00 = intent.getStringExtra("Wid");
            this.O0000o0 = intent.getStringExtra("tagid");
        }
    }

    private String O000000o() {
        if (this.O00000oo.getText() != null) {
            this.O00000oo.getText().toString().trim();
        }
        String trim = this.O00000oO.getText() == null ? null : this.O00000oO.getText().toString().trim();
        if (this.llType.getVisibility() == 0 && TextUtils.isEmpty(this.O0000o00) && TextUtils.isEmpty(this.O0000o0)) {
            return getString(R.string.feedbacklable_itemtitle);
        }
        if (TextUtils.isEmpty(trim) || gae.O000000o(trim.trim())) {
            return getString(R.string.feedback_describe_ques_specific);
        }
        if (gqb.O000000o((CharSequence) trim) <= 10) {
            return getString(R.string.feedback_describe_unenough);
        }
        return null;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.module_a_3_return_btn) {
            finish();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(final XQProgressDialog xQProgressDialog, String str) {
        String trim = this.O00000oO.getText().toString().trim();
        String trim2 = this.O0000O0o.getText().toString().trim();
        if (ServiceApplication.getStateNotifier().f15923O000000o == 4) {
            FeedbackApi.INSTANCE.sendFeedBack2(this, this.O0000OOo, this.O0000Oo0, str, this.O00000oo.getText().toString(), trim, trim2, this.O0000o00, this.O0000o0, this.O0000o0O, new fsm<Void, fso>() {
                /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass5 */

                public final void onFailure(fso fso) {
                    xQProgressDialog.dismiss();
                    FeedbackActivity.this.setSubmutBtnEnable(true);
                    izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.feedback_error, 0).show();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    xQProgressDialog.dismiss();
                    FeedbackActivity.this.setSubmutBtnEnable(true);
                    izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.feedback_succ, 0).show();
                    FeedbackActivity.this.finishWithResultOK();
                }
            });
            return;
        }
        FeedbackApi.INSTANCE.sendFeedBackWithoutLogin(this, this.O0000OOo, this.O0000Oo0, str, this.O00000oo.getText().toString(), trim, trim2, this.O0000o00, this.O0000o0, this.O0000o0O, new fsm<Void, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass6 */

            public final void onFailure(fso fso) {
                xQProgressDialog.dismiss();
                FeedbackActivity.this.setSubmutBtnEnable(true);
                izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.feedback_error, 0).show();
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                xQProgressDialog.dismiss();
                FeedbackActivity.this.setSubmutBtnEnable(true);
                izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.feedback_succ, 0).show();
                FeedbackActivity.this.finishWithResultOK();
            }
        });
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
    public void finishWithResultOK() {
        Intent intent = new Intent();
        intent.putExtra("finish", true);
        setResult(-1, intent);
        finish();
    }

    private void O00000Oo(String str) {
        MLAlertDialog mLAlertDialog = this.O0000OoO;
        if (mLAlertDialog == null) {
            this.O0000OoO = new MLAlertDialog.Builder(this).O000000o(str).O00000o0().O000000o(getString(R.string.feedback_confirm), $$Lambda$FeedbackActivity$Zwde3aPyfpu40JH5bB8xi5YCz_Q.INSTANCE).O00000oo();
            return;
        }
        mLAlertDialog.setTitle(str);
        this.O0000OoO.show();
    }

    private void O000000o(final boolean z) {
        final XQProgressDialog O000000o2 = XQProgressDialog.O000000o(this.f7378O000000o, null, getString(R.string.feedbacking), true, false);
        setSubmutBtnEnable(false);
        this.O0000Oo = null;
        if (this.mImagePreview.getPickedItems().length > 0 || z) {
            fuh.O000000o().O000000o(this, "feedback", "zip", new fsm<fuo, fso>() {
                /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    FeedbackActivity.this.O0000Oo = (fuo) obj;
                    CoreApi.O000000o().O000000o(FeedbackActivity.this.O0000Oo.f17193O000000o, FeedbackActivity.this.O0000Oo0, FeedbackActivity.this.mImagePreview.getPickedItems(), z, new IClientCallback.Stub() {
                        /* class com.xiaomi.smarthome.feedback.FeedbackActivity.AnonymousClass4.AnonymousClass1 */

                        public void onSuccess(Bundle bundle) throws RemoteException {
                            FeedbackActivity.this.O000000o(O000000o2, FeedbackActivity.this.O0000Oo.O00000Oo);
                        }

                        public void onFailure(Bundle bundle) throws RemoteException {
                            O000000o2.dismiss();
                            FeedbackActivity.this.setSubmutBtnEnable(true);
                            izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.uploading_log_error, 0).show();
                        }
                    });
                }

                public final void onFailure(fso fso) {
                    O000000o2.dismiss();
                    FeedbackActivity.this.setSubmutBtnEnable(true);
                    izb.O000000o(FeedbackActivity.this.f7378O000000o, (int) R.string.uploading_log_error, 0).show();
                }
            });
        } else {
            O000000o(O000000o2, "");
        }
    }
}
