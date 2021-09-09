package com.xiaomi.smarthome.camera.activity.setting;

import _m_j.chr;
import _m_j.cin;
import _m_j.civ;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.me;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mijia.model.sdcard.SDCardInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class SDCardStatusActivity extends CameraBaseActivity implements View.OnClickListener {
    public int CHECK_DURATION = 8000;
    public int SD_FORMAT_CHECK = 2001;
    public boolean isFormating = false;
    private boolean isResume = false;
    TextView mFreeSize;
    View mInfoView;
    View mLoadView;
    TextView mOtherSize;
    public int mStatus = 0;
    View mStatusLayout;
    TextView mStatusView;
    TextView mTotalView;
    TextView mVideoSize;
    MLAlertDialog.Builder mlAlertDialog;
    XQProgressDialog progressDialog;
    View sdcardFree;
    View sdcardOther;
    View sdcardVideo;
    public SettingsItemView sdcard_format;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        gwg.O00000o0(this);
        setContentView((int) R.layout.camera_activity_sdcard_status);
        initView();
    }

    private void initView() {
        this.sdcardVideo = findViewById(R.id.sdcard_video);
        this.sdcardOther = findViewById(R.id.sdcard_other);
        this.sdcardFree = findViewById(R.id.sdcard_free);
        this.mOtherSize = (TextView) findViewById(R.id.sdcard_other_size);
        this.mFreeSize = (TextView) findViewById(R.id.sdcard_free_size);
        this.mVideoSize = (TextView) findViewById(R.id.sdcard_video_size);
        this.mTotalView = (TextView) findViewById(R.id.sdcard_total);
        this.mStatusView = (TextView) findViewById(R.id.sdcard_status);
        this.mInfoView = findViewById(R.id.sdcard_info);
        this.mLoadView = findViewById(R.id.loading_layout);
        this.mStatusLayout = findViewById(R.id.sdcard_status_layout);
        ((AnimationDrawable) ((ImageView) findViewById(R.id.loading_img)).getDrawable()).start();
        this.sdcard_format = (SettingsItemView) findViewById(R.id.sdcard_format);
        this.sdcard_format.setOnClickListener(this);
        findViewById(R.id.sdcard_format).setOnClickListener(this);
        findViewById(R.id.sdcard_out).setOnClickListener(this);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.setttings_sdcard_title);
        this.mStatus = this.mCameraDevice.O000000o().O000000o("sdcard_status");
        this.mStatusView.setText(activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(getResources(), this.mStatus)}));
        int i = this.mStatus;
        if (i == 5 || i == 1 || i == 4) {
            this.sdcard_format.setEnabled(false);
            this.sdcard_format.setTitleColor(-7829368);
        } else {
            this.sdcard_format.setEnabled(true);
            this.sdcard_format.setTitleColor(Color.parseColor("#e94f4f"));
        }
        this.mInfoView.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        if (this.isResume) {
            loadData(false);
        } else {
            loadData(true);
        }
        this.isResume = true;
    }

    public void handleMessage(Message message) {
        if (message.what == this.SD_FORMAT_CHECK) {
            checkFormat();
        }
    }

    public void loadData(boolean z) {
        if (z) {
            this.mLoadView.setVisibility(0);
        }
        this.mCameraDevice.O0000OOo().O000000o(new Callback<SDCardInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass1 */

            public void onSuccess(SDCardInfo sDCardInfo) {
                SDCardStatusActivity.this.mStatusLayout.setVisibility(0);
                if (!SDCardStatusActivity.this.isFinishing()) {
                    SDCardStatusActivity.this.parseInfo(sDCardInfo);
                    if (sDCardInfo.O00000Oo < 100000) {
                        SDCardStatusActivity.this.initAlertDlg();
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.sdcard_title);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_full);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_tip_cancel, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip_ok, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass1.AnonymousClass1 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                SDCardStatusActivity.this.doFormat();
                            }
                        });
                        SDCardStatusActivity.this.mlAlertDialog.O00000oo();
                    }
                    SDCardStatusActivity.this.mInfoView.setVisibility(0);
                    SDCardStatusActivity.this.mLoadView.setVisibility(8);
                }
            }

            public void onFailure(int i, String str) {
                if (!SDCardStatusActivity.this.isFinishing()) {
                    civ.O00000o("SdCard", "sdcarad status fail " + i + " : " + str);
                    SDCardStatusActivity.this.initAlertDlg();
                    SDCardStatusActivity.this.mStatusLayout.setVisibility(8);
                    SDCardStatusActivity.this.mInfoView.setVisibility(0);
                    SDCardStatusActivity.this.mLoadView.setVisibility(8);
                    String string = SDCardStatusActivity.this.getString(R.string.sdcard_error);
                    if (i == -2003) {
                        String string2 = SDCardStatusActivity.this.getString(R.string.sdcard_no);
                        SDCardStatusActivity.this.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{string2}));
                        SDCardStatusActivity.this.activity();
                        gqg.O000000o(string2);
                    } else if (i == -2000) {
                        SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                        SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                        String string3 = SDCardStatusActivity.this.getString(R.string.sdcard_formating);
                        SDCardStatusActivity.this.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{string3}));
                        SDCardStatusActivity.this.activity();
                        gqg.O000000o(string3);
                    } else if (i == -2002) {
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_unkonw);
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass1.AnonymousClass2 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                SDCardStatusActivity.this.doFormat();
                            }
                        });
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivity.this.mlAlertDialog.O00000oo();
                        SDCardStatusActivity sDCardStatusActivity = SDCardStatusActivity.this;
                        sDCardStatusActivity.mStatus = 3;
                        sDCardStatusActivity.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(SDCardStatusActivity.this.getResources(), 3)}));
                    } else if (i == -2005) {
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_out);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.know_button, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivity.this.mlAlertDialog.O00000oo();
                        SDCardStatusActivity sDCardStatusActivity2 = SDCardStatusActivity.this;
                        sDCardStatusActivity2.mStatus = 5;
                        sDCardStatusActivity2.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(SDCardStatusActivity.this.getResources(), 5)}));
                    } else {
                        if (i == -1) {
                            SDCardStatusActivity.this.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{string}));
                        }
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.sdcard_tip);
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sdcard_error_tip);
                        SDCardStatusActivity.this.mlAlertDialog.O000000o((int) R.string.common_retry, new DialogInterface.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass1.AnonymousClass3 */

                            public void onClick(DialogInterface dialogInterface, int i) {
                                SDCardStatusActivity.this.loadData(true);
                            }
                        });
                        SDCardStatusActivity.this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                        SDCardStatusActivity.this.mlAlertDialog.O00000oo();
                    }
                }
            }
        }, z);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sdcard_format) {
            doFormat();
        } else if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.sdcard_out) {
            chr.O000000o("plg.gn9.tnk.omz");
            if (this.mStatus == 5) {
                activity();
                gqg.O000000o((int) R.string.sdcard_out_already);
                return;
            }
            activity().setResult(-1);
            initAlertDlg();
            this.mlAlertDialog.O000000o((int) R.string.sdcard_out);
            this.mlAlertDialog.O00000Oo((int) R.string.sdcard_out_tips);
            this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
            this.mlAlertDialog.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass2 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    SDCardStatusActivity.this.initProgressDlg();
                    SDCardStatusActivity.this.progressDialog.show();
                    if (SDCardStatusActivity.this.mCameraDevice.O00000o()) {
                        SDCardStatusActivity.this.mCameraDevice.O0000Oo0().O00000o(new Callback<Object>() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass2.AnonymousClass1 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                             arg types: [java.lang.String, int]
                             candidates:
                              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                              _m_j.cll.O000000o(java.lang.String, boolean):boolean
                              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void */
                            public void onSuccess(Object obj) {
                                if (!SDCardStatusActivity.this.isFinishing()) {
                                    SDCardStatusActivity.this.disProgressDlg();
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_out_success);
                                    SDCardStatusActivity.this.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(SDCardStatusActivity.this.getResources(), 5)}));
                                    SDCardStatusActivity.this.mStatusLayout.setVisibility(8);
                                    SDCardStatusActivity.this.mVideoSize.setText("");
                                    SDCardStatusActivity.this.mFreeSize.setText("");
                                    SDCardStatusActivity.this.mOtherSize.setText("");
                                    SDCardStatusActivity.this.mCameraDevice.O000000o().O000000o("sdcard_status", (Object) 5);
                                    SDCardStatusActivity.this.sdcard_format.setEnabled(false);
                                    SDCardStatusActivity.this.sdcard_format.setTitleColor(-7829368);
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!SDCardStatusActivity.this.isFinishing()) {
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_out_fail);
                                    SDCardStatusActivity.this.disProgressDlg();
                                }
                            }
                        });
                    } else {
                        SDCardStatusActivity.this.mCameraDevice.O0000OOo().O00000o(new Callback<Object>() {
                            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass2.AnonymousClass2 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.cll.O000000o(java.lang.String, java.lang.Object):void
                             arg types: [java.lang.String, int]
                             candidates:
                              _m_j.cll.O000000o(java.lang.String[], com.xiaomi.smarthome.device.api.Callback<java.lang.Void>):void
                              _m_j.cll.O000000o(java.lang.String, boolean):boolean
                              _m_j.cll.O000000o(java.lang.String, java.lang.Object):void */
                            public void onSuccess(Object obj) {
                                if (!SDCardStatusActivity.this.isFinishing()) {
                                    SDCardStatusActivity.this.disProgressDlg();
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_out_success);
                                    SDCardStatusActivity.this.mStatusView.setText(SDCardStatusActivity.this.activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(SDCardStatusActivity.this.getResources(), 5)}));
                                    SDCardStatusActivity.this.mStatusLayout.setVisibility(8);
                                    SDCardStatusActivity.this.mVideoSize.setText("");
                                    SDCardStatusActivity.this.mFreeSize.setText("");
                                    SDCardStatusActivity.this.mOtherSize.setText("");
                                    SDCardStatusActivity.this.mCameraDevice.O000000o().O000000o("sdcard_status", (Object) 5);
                                    SDCardStatusActivity.this.sdcard_format.setEnabled(false);
                                    SDCardStatusActivity.this.sdcard_format.setTitleColor(-7829368);
                                }
                            }

                            public void onFailure(int i, String str) {
                                if (!SDCardStatusActivity.this.isFinishing()) {
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_out_fail);
                                    SDCardStatusActivity.this.disProgressDlg();
                                }
                            }
                        });
                    }
                }
            });
            this.mlAlertDialog.O00000oo();
        }
    }

    public void parseInfo(SDCardInfo sDCardInfo) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.sdcardVideo.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.sdcardOther.getLayoutParams();
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.sdcardFree.getLayoutParams();
        layoutParams.weight = (float) sDCardInfo.O00000o0;
        layoutParams3.weight = (float) sDCardInfo.O00000Oo;
        layoutParams2.weight = (float) sDCardInfo.O00000o;
        if (!(sDCardInfo.O00000oO == -1 || sDCardInfo.O00000oO == this.mStatus)) {
            this.mStatus = sDCardInfo.O00000oO;
            this.mStatusView.setText(activity().getString(R.string.sdcard_status, new Object[]{cin.O000000o(getResources(), this.mStatus)}));
            this.mCameraDevice.O000000o().O000000o("sdcard_status", Integer.valueOf(this.mStatus));
        }
        this.sdcardVideo.setLayoutParams(layoutParams);
        this.sdcardOther.setLayoutParams(layoutParams2);
        this.sdcardFree.setLayoutParams(layoutParams3);
        this.mFreeSize.setText(me.O000000o(sDCardInfo.O00000Oo));
        this.mVideoSize.setText(me.O000000o(sDCardInfo.O00000o0));
        this.mOtherSize.setText(me.O000000o(sDCardInfo.O00000o));
        this.mTotalView.setText(activity().getString(R.string.sdcard_size, new Object[]{me.O000000o(sDCardInfo.f5242O000000o)}));
        chr.O000000o("plg.gn9.qc4.tdm", chr.O00Oo0oo, me.O000000o(sDCardInfo.f5242O000000o));
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void
     arg types: [com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity$3, int]
     candidates:
      _m_j.ckx.O000000o(int, java.lang.String):void
      _m_j.clr.O000000o(com.xiaomi.smarthome.device.api.Callback<com.mijia.model.sdcard.SDCardInfo>, boolean):void */
    private void checkFormat() {
        this.mHandler.removeMessages(this.SD_FORMAT_CHECK);
        this.mCameraDevice.O0000OOo().O000000o((Callback<SDCardInfo>) new Callback<SDCardInfo>() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass3 */

            public void onSuccess(SDCardInfo sDCardInfo) {
                if (!SDCardStatusActivity.this.isFinishing()) {
                    SDCardStatusActivity.this.disProgressDlg();
                    SDCardStatusActivity sDCardStatusActivity = SDCardStatusActivity.this;
                    sDCardStatusActivity.isFormating = false;
                    sDCardStatusActivity.parseInfo(sDCardInfo);
                    SDCardStatusActivity.this.mStatusLayout.setVisibility(0);
                    SDCardStatusActivity.this.activity();
                    gqg.O000000o((int) R.string.sdcard_format_success);
                }
            }

            public void onFailure(int i, String str) {
                if (!SDCardStatusActivity.this.isFinishing()) {
                    if (i == -2000) {
                        SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                        return;
                    }
                    SDCardStatusActivity sDCardStatusActivity = SDCardStatusActivity.this;
                    sDCardStatusActivity.isFormating = false;
                    sDCardStatusActivity.disProgressDlg();
                    civ.O00000o("SdCard", "check format error ".concat(String.valueOf(i)));
                    SDCardStatusActivity.this.sdcard_format.setEnabled(true);
                    SDCardStatusActivity.this.sdcard_format.setTitleColor(Color.parseColor("#e94f4f"));
                    SDCardStatusActivity.this.activity();
                    gqg.O000000o((int) R.string.sdcard_format_fail);
                }
            }
        }, true);
    }

    public void doFormat() {
        chr.O000000o("plg.gn9.2dn.bbr");
        initAlertDlg();
        this.mlAlertDialog.O000000o((int) R.string.sdcard_format);
        this.mlAlertDialog.O00000Oo((int) R.string.sdcard_format_tip);
        this.mlAlertDialog.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                SDCardStatusActivity.this.initProgressDlg();
                SDCardStatusActivity.this.progressDialog.show();
                if (SDCardStatusActivity.this.mCameraDevice.O00000o()) {
                    SDCardStatusActivity.this.mCameraDevice.O0000Oo0().O00000o0(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass4.AnonymousClass1 */

                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivity.this.isFinishing()) {
                                SDCardStatusActivity.this.isFormating = true;
                                SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                                SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivity.this.isFinishing()) {
                                if (i == -2000) {
                                    SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                                    SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_formating);
                                    return;
                                }
                                if (i == -2003) {
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_no);
                                } else {
                                    civ.O00000o("SdCard", "format error " + i + " info ");
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_format_fail);
                                    SDCardStatusActivity.this.sdcard_format.setEnabled(true);
                                    SDCardStatusActivity.this.sdcard_format.setTitleColor(Color.parseColor("#e94f4f"));
                                }
                                SDCardStatusActivity.this.disProgressDlg();
                            }
                        }
                    });
                } else {
                    SDCardStatusActivity.this.mCameraDevice.O0000OOo().O00000o0(new Callback<Object>() {
                        /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass4.AnonymousClass2 */

                        public void onSuccess(Object obj) {
                            if (!SDCardStatusActivity.this.isFinishing()) {
                                SDCardStatusActivity.this.isFormating = true;
                                SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                                SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (!SDCardStatusActivity.this.isFinishing()) {
                                if (i == -2000) {
                                    SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                                    SDCardStatusActivity.this.mHandler.sendEmptyMessageDelayed(SDCardStatusActivity.this.SD_FORMAT_CHECK, (long) SDCardStatusActivity.this.CHECK_DURATION);
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_formating);
                                    return;
                                }
                                if (i == -2003) {
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_no);
                                } else {
                                    civ.O00000o("SdCard", "format error " + i + " info ");
                                    SDCardStatusActivity.this.activity();
                                    gqg.O000000o((int) R.string.sdcard_format_fail);
                                    SDCardStatusActivity.this.sdcard_format.setEnabled(true);
                                    SDCardStatusActivity.this.sdcard_format.setTitleColor(Color.parseColor("#e94f4f"));
                                }
                                SDCardStatusActivity.this.disProgressDlg();
                            }
                        }
                    });
                }
            }
        });
        this.mlAlertDialog.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        this.mlAlertDialog.O00000oo();
    }

    public void initProgressDlg() {
        if (this.progressDialog == null) {
            this.progressDialog = new XQProgressDialog(activity());
            this.progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                /* class com.xiaomi.smarthome.camera.activity.setting.SDCardStatusActivity.AnonymousClass5 */

                public void onCancel(DialogInterface dialogInterface) {
                    dialogInterface.dismiss();
                    if (!SDCardStatusActivity.this.isFormating) {
                        SDCardStatusActivity.this.activity();
                        gqg.O000000o((int) R.string.sdcard_error);
                        SDCardStatusActivity.this.mHandler.removeMessages(SDCardStatusActivity.this.SD_FORMAT_CHECK);
                    }
                }
            });
        }
    }

    public void initAlertDlg() {
        if (this.mlAlertDialog == null) {
            this.mlAlertDialog = new MLAlertDialog.Builder(this);
        }
    }

    public void disProgressDlg() {
        XQProgressDialog xQProgressDialog = this.progressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.progressDialog.dismiss();
        }
    }
}
