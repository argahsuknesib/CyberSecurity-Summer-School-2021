package com.xiaomi.smarthome.framework.page;

import _m_j.fno;
import _m_j.fum;
import _m_j.fup;
import _m_j.gnq;
import _m_j.gpc;
import _m_j.gpj;
import _m_j.gsy;
import _m_j.hyy;
import _m_j.izb;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.bluetooth.Response;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.widget.TimePicker;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONArray;

public class GeneralOneTimePasswordActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static Map<String, Map<Long, O000000o>> f7739O000000o = new HashMap();
    private static Handler O00000o0;
    private long O00000Oo;
    private boolean O00000o;
    private Bitmap O00000oO;
    private Bitmap O00000oo;
    @BindView(5357)
    ImageView mBackBt;
    @BindView(5003)
    LinearLayout mContainerView;
    @BindView(5009)
    TextView mCopyPasswordBtn;
    @BindView(5010)
    TextView mCopySuccessHint;
    public Device mDevice;
    @BindView(5128)
    TextView mFinishBtn;
    @BindView(4974)
    TextView mGenerateBtn;
    @BindView(5163)
    TextView mGenerateTipsView;
    @BindView(5164)
    TextView mGenerateTitleView;
    public int mInterval;
    public String mOneTimePassword;
    public fum mOneTimePasswordInfo;
    public int mPasswordNum;
    @BindView(5463)
    TextView mPasswordText1;
    @BindView(5464)
    TextView mPasswordText2;
    @BindView(5465)
    TextView mPasswordText3;
    @BindView(5466)
    TextView mPasswordText4;
    @BindView(5467)
    TextView mPasswordText5;
    @BindView(5468)
    TextView mPasswordText6;
    @BindView(5469)
    TextView mPasswordText7;
    @BindView(5470)
    TextView mPasswordText8;
    @BindView(5645)
    TextView mShareBtn;
    public Dialog mShareDialog;
    public SharedPreferences mSpDialogNeedShow;

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008e  */
    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("did");
        this.mInterval = getIntent().getIntExtra("interval", 0);
        this.mPasswordNum = getIntent().getIntExtra("digits", 0);
        this.mDevice = fno.O000000o().O000000o(stringExtra);
        if (this.mDevice == null) {
            gsy.O00000o0(LogType.GENERAL, "", "GeneralOneTimePasswordActivity failed, device don't exist, ".concat(String.valueOf(stringExtra)));
        } else {
            int i = this.mInterval;
            if (i <= 0 || i > 60) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "", "GeneralOneTimePasswordActivity failed, mInterval is invalid, " + this.mInterval);
            } else {
                int i2 = this.mPasswordNum;
                if (i2 < 6 || i2 > 8) {
                    LogType logType2 = LogType.GENERAL;
                    gsy.O00000o0(logType2, "", "GeneralOneTimePasswordActivity failed, mPasswordNum is invalid, " + this.mPasswordNum);
                } else {
                    z = true;
                    if (z) {
                        finish();
                        return;
                    }
                    setContentView((int) R.layout.activity_general_one_time_password);
                    ButterKnife.bind(this);
                    this.mSpDialogNeedShow = getSharedPreferences("show_copy_share_dialog", 0);
                    O00000o0 = new Handler(Looper.getMainLooper());
                    this.O00000o = false;
                    this.mBackBt.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass1 */

                        public final void onClick(View view) {
                            GeneralOneTimePasswordActivity.this.showCopyShareAlertDialog();
                        }
                    });
                    this.mFinishBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass4 */

                        public final void onClick(View view) {
                            GeneralOneTimePasswordActivity.this.showCopyShareAlertDialog();
                        }
                    });
                    this.mGenerateTitleView.setText((int) R.string.one_time_password_ready_generate_title);
                    this.mGenerateTipsView.setText((int) R.string.one_time_password_ready_generate_tips);
                    this.mCopyPasswordBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass5 */

                        public final void onClick(View view) {
                            ((ClipboardManager) GeneralOneTimePasswordActivity.this.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", GeneralOneTimePasswordActivity.this.mOneTimePassword));
                            GeneralOneTimePasswordActivity.this.showCopySuccessHint();
                        }
                    });
                    this.mShareBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass6 */

                        public final void onClick(View view) {
                            if (GeneralOneTimePasswordActivity.this.mShareDialog != null && GeneralOneTimePasswordActivity.this.mShareDialog.isShowing()) {
                                GeneralOneTimePasswordActivity.this.mShareDialog.dismiss();
                            }
                            View inflate = GeneralOneTimePasswordActivity.this.getLayoutInflater().inflate((int) R.layout.dialog_one_time_password_share, (ViewGroup) null);
                            GeneralOneTimePasswordActivity generalOneTimePasswordActivity = GeneralOneTimePasswordActivity.this;
                            generalOneTimePasswordActivity.mShareDialog = new MLAlertDialog.Builder(generalOneTimePasswordActivity).O000000o(inflate).O00000oo();
                            if (!hyy.O000000o()) {
                                GeneralOneTimePasswordActivity.this.mShareDialog.getWindow().setLayout((gpc.O00000Oo(GeneralOneTimePasswordActivity.this) * 8) / 9, -2);
                            }
                            GeneralOneTimePasswordActivity.this.mShareDialog.getWindow().setGravity(17);
                            final View findViewById = inflate.findViewById(R.id.share_content);
                            TextView textView = (TextView) inflate.findViewById(R.id.product_name);
                            TextView textView2 = (TextView) inflate.findViewById(R.id.password);
                            TextView textView3 = (TextView) inflate.findViewById(R.id.deadline_time);
                            PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(GeneralOneTimePasswordActivity.this.mDevice.model);
                            if (O00000oO != null) {
                                textView.setText(O00000oO.O0000Oo0());
                            }
                            StringBuilder sb = new StringBuilder();
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(0));
                            sb.append(" ");
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(1));
                            sb.append(" ");
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(2));
                            sb.append(" ");
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(3));
                            sb.append(" ");
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(4));
                            sb.append(" ");
                            sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(5));
                            if (GeneralOneTimePasswordActivity.this.mPasswordNum == 7) {
                                sb.append(" ");
                                sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(6));
                            } else if (GeneralOneTimePasswordActivity.this.mPasswordNum == 8) {
                                sb.append(" ");
                                sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(6));
                                sb.append(" ");
                                sb.append(GeneralOneTimePasswordActivity.this.mOneTimePassword.charAt(7));
                            }
                            textView2.setText(sb.toString());
                            textView3.setText(GeneralOneTimePasswordActivity.this.getResources().getString(R.string.one_time_password_valid_period) + ": " + fum.O000000o(GeneralOneTimePasswordActivity.this.mOneTimePasswordInfo.O00000Oo) + "~" + fum.O000000o(GeneralOneTimePasswordActivity.this.mOneTimePasswordInfo.O00000o0) + ",");
                            File externalCacheDir = GeneralOneTimePasswordActivity.this.getExternalCacheDir();
                            externalCacheDir.mkdirs();
                            File file = new File(externalCacheDir, "weixin_share.jpg");
                            if (file.exists() && file.isFile()) {
                                if (file.delete()) {
                                    gsy.O000000o(3, "OneTimePwdActivity", "delete last pwd pic Success.");
                                } else {
                                    gsy.O000000o(6, "OneTimePwdActivity", "delete last pwd pic failed.");
                                }
                            }
                            inflate.findViewById(R.id.close_btn).setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass6.AnonymousClass1 */

                                public final void onClick(View view) {
                                    if (GeneralOneTimePasswordActivity.this.mShareDialog != null && GeneralOneTimePasswordActivity.this.mShareDialog.isShowing()) {
                                        GeneralOneTimePasswordActivity.this.mShareDialog.dismiss();
                                    }
                                }
                            });
                            inflate.findViewById(R.id.confirm_share).setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass6.AnonymousClass2 */

                                public final void onClick(View view) {
                                    GeneralOneTimePasswordActivity.this.shareWeixin(findViewById);
                                }
                            });
                        }
                    });
                    this.mGenerateBtn.setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7 */

                        public final void onClick(View view) {
                            String[] strArr = {GeneralOneTimePasswordActivity.this.getString(R.string.one_time_password_valid_now), GeneralOneTimePasswordActivity.this.getString(R.string.one_time_password_valid_timer)};
                            MLAlertDialog.Builder O000000o2 = new MLAlertDialog.Builder(GeneralOneTimePasswordActivity.this).O000000o((int) R.string.one_time_password_choose_valid_time);
                            O000000o2.f9096O000000o.O000O0oO = false;
                            O000000o2.O000000o(strArr, 0, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (i == 0) {
                                        GeneralOneTimePasswordActivity.this.generateOnetimePassword();
                                    } else {
                                        final gnq gnq = new gnq(GeneralOneTimePasswordActivity.this, GeneralOneTimePasswordActivity.this.mInterval);
                                        gnq.setTitle((int) R.string.one_time_password_set_valid_time);
                                        gnq.setCancelable(true);
                                        gnq.setButton(-1, gnq.getContext().getString(R.string.ok_button), new DialogInterface.OnClickListener() {
                                            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7.AnonymousClass2.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                TimePicker timePicker = gnq.O00000Oo;
                                                if (timePicker == null) {
                                                    gsy.O000000o(6, "OneTimePwdActivity", "TimePicker is null.");
                                                    return;
                                                }
                                                final int intValue = timePicker.getCurrentHour().intValue();
                                                final int intValue2 = timePicker.getCurrentMinute().intValue() * GeneralOneTimePasswordActivity.this.mInterval;
                                                XmPluginHostApi.instance().getUTCFromServer("", new Callback<Long>() {
                                                    /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                                    public final /* synthetic */ void onSuccess(Object obj) {
                                                        Long l = (Long) obj;
                                                        GeneralOneTimePasswordActivity.this.generateOnetimePasswordwithDelay(GeneralOneTimePasswordActivity.this.getDelayUTCTime(l.longValue(), intValue, intValue2), l.longValue());
                                                    }

                                                    public final void onFailure(int i, String str) {
                                                        izb.O000000o(GeneralOneTimePasswordActivity.this, (int) R.string.one_time_password_generate_failed, 0).show();
                                                    }
                                                });
                                            }
                                        });
                                        gnq.setButton(-2, gnq.getContext().getString(R.string.sh_common_cancel), new DialogInterface.OnClickListener() {
                                            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7.AnonymousClass2.AnonymousClass2 */

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        });
                                        gnq.show();
                                    }
                                    dialogInterface.dismiss();
                                }
                            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                                /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }).O00000oo();
                        }
                    });
                    this.mContainerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass8 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.gpc.O000000o(android.content.Context, float):int
                         arg types: [com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity, float]
                         candidates:
                          _m_j.gpc.O000000o(android.app.Activity, float):int
                          _m_j.gpc.O000000o(android.view.View, int):void
                          _m_j.gpc.O000000o(android.content.Context, float):int */
                        public final void onGlobalLayout() {
                            GeneralOneTimePasswordActivity generalOneTimePasswordActivity = GeneralOneTimePasswordActivity.this;
                            int width = ((GeneralOneTimePasswordActivity.this.mContainerView.getWidth() - 10) - gpc.O000000o((Context) generalOneTimePasswordActivity, (float) ((generalOneTimePasswordActivity.mPasswordNum - 1) * 6))) / GeneralOneTimePasswordActivity.this.mPasswordNum;
                            GeneralOneTimePasswordActivity.this.setPwdItemSize(width, gpc.O00000o(GeneralOneTimePasswordActivity.this.getContext(), (float) width) - 12);
                        }
                    });
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    public void setPwdItemSize(int i, int i2) {
        O000000o(this.mPasswordText1, i, i2);
        O000000o(this.mPasswordText2, i, i2);
        O000000o(this.mPasswordText3, i, i2);
        O000000o(this.mPasswordText4, i, i2);
        O000000o(this.mPasswordText5, i, i2);
        O000000o(this.mPasswordText6, i, i2);
        int i3 = this.mPasswordNum;
        if (i3 == 7) {
            this.mPasswordText7.setVisibility(0);
            O000000o(this.mPasswordText7, i, i2);
        } else if (i3 == 8) {
            this.mPasswordText7.setVisibility(0);
            O000000o(this.mPasswordText7, i, i2);
            this.mPasswordText8.setVisibility(0);
            O000000o(this.mPasswordText8, i, i2);
        }
    }

    public long getDelayUTCTime(long j, int i, int i2) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(1000 * j);
        int i3 = instance.get(11);
        int i4 = instance.get(12);
        int i5 = ((i3 * 60) + i4) * 60;
        int i6 = ((i * 60) + i2) * 60;
        gsy.O000000o(4, "OneTimePwdActivity", "Current hour = " + i3 + ", minute = " + i4 + ", delay hour = " + i + ", minute = " + i2);
        return i6 >= i5 ? (j + ((long) i6)) - ((long) i5) : ((j + ((long) i6)) - ((long) i5)) + 86400;
    }

    public void generateOnetimePassword() {
        XmBluetoothManager.getInstance().getOneTimePassword(this.mDevice.mac, this.mInterval, this.mPasswordNum, new Response.BleResponseV2<int[]>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass9 */

            public final /* synthetic */ void onResponse(int i, String str, Object obj) {
                final int[] iArr = (int[]) obj;
                if (i != 0 || iArr == null || iArr.length <= 0) {
                    izb.O000000o(GeneralOneTimePasswordActivity.this, (int) R.string.one_time_password_generate_failed, 0).show();
                } else {
                    XmPluginHostApi.instance().getUTCFromServer("", new Callback<Long>() {
                        /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass9.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            Long l = (Long) obj;
                            GeneralOneTimePasswordActivity.this.processOnetimePwdResponse(l.longValue(), l.longValue(), iArr, false);
                        }

                        public final void onFailure(int i, String str) {
                            izb.O000000o(GeneralOneTimePasswordActivity.this, (int) R.string.one_time_password_generate_failed, 0).show();
                        }
                    });
                }
            }
        });
    }

    public void generateOnetimePasswordwithDelay(long j, long j2) {
        final long j3 = j;
        final long j4 = j2;
        XmBluetoothManager.getInstance().getOneTimePasswordWithDelayTime(this.mDevice.mac, this.mInterval, this.mPasswordNum, j, new Response.BleResponseV2<int[]>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass10 */

            public final /* synthetic */ void onResponse(int i, String str, Object obj) {
                int[] iArr = (int[]) obj;
                if (i != 0 || iArr == null || iArr.length <= 0) {
                    izb.O000000o(GeneralOneTimePasswordActivity.this, (int) R.string.one_time_password_generate_failed, 0).show();
                } else {
                    GeneralOneTimePasswordActivity.this.processOnetimePwdResponse(j3, j4, iArr, true);
                }
            }
        });
    }

    public void processOnetimePwdResponse(long j, long j2, int[] iArr, boolean z) {
        int i;
        int[] iArr2 = iArr;
        int i2 = this.mInterval;
        this.O00000Oo = ((j / ((long) (i2 * 60))) + 2) * ((long) i2) * 60;
        Map map = f7739O000000o.get(this.mDevice.did);
        O000000o o000000o = map != null ? (O000000o) map.get(Long.valueOf(this.O00000Oo)) : null;
        long j3 = this.O00000Oo;
        int i3 = -1;
        ArrayList arrayList = new ArrayList(fup.f17194O000000o.values());
        TreeSet treeSet = new TreeSet();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            if (((fum) arrayList.get(i4)).O00000o0 == j3) {
                treeSet.add(((fum) arrayList.get(i4)).O00000o);
            }
        }
        if (treeSet.size() > 0) {
            i3 = treeSet.size();
        }
        if (i3 >= iArr2.length) {
            gsy.O000000o(6, "TAG", "existNumOfOldPwdList >= " + iArr2.length);
            O000000o(j);
            return;
        }
        if (o000000o == null || !O000000o(iArr2, o000000o.O00000Oo)) {
            HashMap hashMap = new HashMap();
            O000000o o000000o2 = new O000000o(iArr2);
            if (i3 > 0) {
                o000000o2.f7759O000000o = i3;
            }
            hashMap.put(Long.valueOf(this.O00000Oo), o000000o2);
            f7739O000000o.put(this.mDevice.did, hashMap);
            o000000o = o000000o2;
        } else if (o000000o.f7759O000000o < iArr2.length - 1) {
            if (i3 > 0 && o000000o.f7759O000000o < (i = i3 - 1)) {
                o000000o.f7759O000000o = i;
            }
            o000000o.f7759O000000o++;
        } else {
            O000000o(j);
            return;
        }
        this.mOneTimePassword = O000000o((o000000o.O00000Oo == null || o000000o.f7759O000000o >= o000000o.O00000Oo.length) ? 0 : o000000o.O00000Oo[o000000o.f7759O000000o]);
        this.mOneTimePasswordInfo = new fum(j2, j, this.O00000Oo, fup.O000000o(this.mOneTimePassword, String.valueOf(this.O00000Oo), this.mDevice.mac, this.mDevice.userId));
        XmPluginHostApi.instance().getUserDeviceData(this.mDevice.model, this.mDevice.did, "prop", "device_lock", 0, j2, new Callback<JSONArray>() {
            /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass11 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONArray jSONArray = (JSONArray) obj;
                gsy.O000000o(4, "OneTimePwdActivity", " get result =".concat(String.valueOf(jSONArray)));
                fup.O000000o(GeneralOneTimePasswordActivity.this.mDevice, jSONArray, GeneralOneTimePasswordActivity.this.mOneTimePasswordInfo);
            }

            public final void onFailure(int i, String str) {
                gsy.O000000o(4, "OneTimePwdActivity", "getUserDeviceData failed, error = " + i + ", msg = " + str);
            }
        });
        this.mGenerateTitleView.setText((int) R.string.one_time_password_has_generate_title);
        TextView textView = this.mGenerateTipsView;
        String string = getResources().getString(R.string.one_time_password_has_generate_tips);
        Object[] objArr = new Object[1];
        StringBuilder sb = new StringBuilder("<font color='#32BAC0'>");
        Calendar instance = Calendar.getInstance();
        int i5 = instance.get(11);
        int i6 = instance.get(12);
        instance.setTimeInMillis(this.O00000Oo * 1000);
        int i7 = instance.get(11);
        int i8 = instance.get(12);
        String format = String.format("%1$02d:%2$02d", Integer.valueOf(i7), Integer.valueOf(i8));
        if ((i5 * 60) + i6 > (i7 * 60) + i8) {
            Locale locale = Locale.getDefault();
            if (locale.equals(Locale.CHINA) || locale.equals(Locale.TAIWAN)) {
                format = getResources().getString(R.string.plug_timer_tomorrow) + format;
            } else {
                format = getResources().getString(R.string.plug_timer_tomorrow).toLowerCase(locale) + " " + format;
            }
        }
        sb.append(format);
        sb.append("</font>");
        objArr[0] = sb.toString();
        textView.setText(Html.fromHtml(String.format(string, objArr)));
        this.mPasswordText1.setText(String.valueOf(this.mOneTimePassword.charAt(0)));
        this.mPasswordText2.setText(String.valueOf(this.mOneTimePassword.charAt(1)));
        this.mPasswordText3.setText(String.valueOf(this.mOneTimePassword.charAt(2)));
        this.mPasswordText4.setText(String.valueOf(this.mOneTimePassword.charAt(3)));
        this.mPasswordText5.setText(String.valueOf(this.mOneTimePassword.charAt(4)));
        this.mPasswordText6.setText(String.valueOf(this.mOneTimePassword.charAt(5)));
        int i9 = this.mPasswordNum;
        if (i9 == 7) {
            this.mPasswordText7.setText(String.valueOf(this.mOneTimePassword.charAt(6)));
        } else if (i9 == 8) {
            this.mPasswordText7.setText(String.valueOf(this.mOneTimePassword.charAt(6)));
            this.mPasswordText8.setText(String.valueOf(this.mOneTimePassword.charAt(7)));
        }
        this.mGenerateBtn.setVisibility(8);
        this.mCopyPasswordBtn.setVisibility(0);
        this.mShareBtn.setVisibility(0);
        this.mFinishBtn.setVisibility(0);
        this.O00000o = true;
    }

    private void O000000o(long j) {
        if (isValid()) {
            new MLAlertDialog.Builder(this).O00000Oo(String.format(getResources().getString(R.string.one_time_password_max_time), O00000Oo(j))).O000000o((int) R.string.ok_button, (DialogInterface.OnClickListener) null).O00000o().show();
        }
    }

    private static void O000000o(TextView textView, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        textView.setLayoutParams(layoutParams);
        textView.setTextSize((float) i2);
    }

    public void showCopySuccessHint() {
        if (this.mCopySuccessHint != null) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(400);
            alphaAnimation.setFillAfter(true);
            this.mCopySuccessHint.setVisibility(0);
            this.mCopySuccessHint.startAnimation(alphaAnimation);
            Handler handler = O00000o0;
            if (handler != null) {
                handler.postDelayed(new Runnable() {
                    /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass2 */

                    public final void run() {
                        GeneralOneTimePasswordActivity.this.hideCopySuccessHint();
                    }
                }, 2000);
            }
        }
    }

    public void hideCopySuccessHint() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400);
        alphaAnimation.setFillAfter(true);
        TextView textView = this.mCopySuccessHint;
        if (textView != null) {
            textView.startAnimation(alphaAnimation);
        }
    }

    private String O00000Oo(long j) {
        int i = this.mInterval;
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(((j / ((long) (i * 60))) + 1) * ((long) i) * 60 * 1000);
        return String.format("%1$02d:%2$02d", Integer.valueOf(instance.get(11)), Integer.valueOf(instance.get(12)));
    }

    private String O000000o(int i) {
        String valueOf = String.valueOf(i);
        int length = valueOf.length();
        int i2 = this.mPasswordNum;
        if (length >= i2) {
            return valueOf;
        }
        int length2 = i2 - valueOf.length();
        byte[] bArr = new byte[this.mPasswordNum];
        for (int i3 = 0; i3 < length2; i3++) {
            bArr[i3] = 48;
        }
        System.arraycopy(valueOf.getBytes(), 0, bArr, length2, valueOf.getBytes().length);
        return new String(bArr);
    }

    public void shareWeixin(View view) {
        if (!O000000o("com.tencent.mm")) {
            izb.O000000o(this, (int) R.string.device_shop_share_no_weixin, 1).show();
            return;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(createBitmap));
        this.O00000oO = changeColor(createBitmap);
        this.O00000oo = gpj.O000000o(this.O00000oO);
        IWXAPI shiwxapi = CommonApplication.getSHIWXAPI();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        Bitmap bitmap = this.O00000oo;
        if (bitmap != null) {
            wXMediaMessage.setThumbImage(bitmap);
        }
        Bitmap bitmap2 = this.O00000oO;
        if (bitmap2 != null) {
            wXMediaMessage.mediaObject = new WXImageObject(bitmap2);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = 0;
        gsy.O000000o(LogType.GENERAL, "OneTimePwdActivity", "sendReq return ".concat(String.valueOf(shiwxapi.sendReq(req))));
        createBitmap.recycle();
    }

    private boolean O000000o(String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static Bitmap changeColor(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[(width * height)];
        int i = 0;
        int i2 = 0;
        while (i < height) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < width) {
                int pixel = bitmap.getPixel(i4, i);
                int alpha = Color.alpha(pixel);
                iArr[i3] = Color.rgb(O000000o(Color.red(pixel), alpha), O000000o(Color.green(pixel), alpha), O000000o(Color.blue(pixel), alpha));
                i4++;
                i3++;
            }
            i++;
            i2 = i3;
        }
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    private static int O000000o(int i, int i2) {
        int i3 = (((i * i2) / 255) + 255) - i2;
        if (i3 > 255) {
            return 255;
        }
        return i3;
    }

    private static boolean O000000o(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        int f7759O000000o = 0;
        int[] O00000Oo;

        public O000000o(int[] iArr) {
            this.O00000Oo = iArr;
        }
    }

    public void onBackPressed() {
        showCopyShareAlertDialog();
    }

    public void showCopyShareAlertDialog() {
        if (!this.O00000o) {
            finish();
            return;
        }
        SharedPreferences sharedPreferences = this.mSpDialogNeedShow;
        if (sharedPreferences == null || sharedPreferences.getBoolean("show_copy_share_dialog", true)) {
            View inflate = LayoutInflater.from(this).inflate((int) R.layout.one_time_copy_share_dialog, (ViewGroup) null);
            Button button = (Button) inflate.findViewById(R.id.ok);
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.remember);
            TextView textView = (TextView) inflate.findViewById(R.id.remember_textview);
            if (textView.getText() != null && textView.getText().toString().contains("show again")) {
                textView.setText("Do not remind me again");
            }
            button.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.framework.page.GeneralOneTimePasswordActivity.AnonymousClass3 */

                public final void onClick(View view) {
                    if (checkBox.isChecked() && GeneralOneTimePasswordActivity.this.mSpDialogNeedShow != null) {
                        GeneralOneTimePasswordActivity.this.mSpDialogNeedShow.edit().putBoolean("show_copy_share_dialog", false).apply();
                    }
                    GeneralOneTimePasswordActivity.this.finish();
                }
            });
            MLAlertDialog O00000o2 = new MLAlertDialog.Builder(this).O000000o(inflate).O00000o();
            O00000o2.setCancelable(true);
            O00000o2.show();
            return;
        }
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.O00000oO;
        if (bitmap != null) {
            bitmap.recycle();
            this.O00000oO = null;
        }
        Bitmap bitmap2 = this.O00000oo;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.O00000oo = null;
        }
    }
}
