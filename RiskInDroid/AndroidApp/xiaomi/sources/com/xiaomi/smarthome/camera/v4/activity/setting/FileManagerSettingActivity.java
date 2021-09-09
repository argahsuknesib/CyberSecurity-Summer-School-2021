package com.xiaomi.smarthome.camera.v4.activity.setting;

import _m_j.chr;
import _m_j.chx;
import _m_j.gqg;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASDiscoveryActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASInfoActivity;
import com.xiaomi.smarthome.camera.v4.utils.Util;
import com.xiaomi.smarthome.camera.view.widget.SettingsItemView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;

public class FileManagerSettingActivity extends CameraBaseActivity {
    private final int SD_CARD_STATUS = 1001;
    chx mCameraProperties;
    SettingsItemView mRecordModel;
    public String mRecordStatus = "";
    SettingsItemView mSDCardItem;
    View mSDCardItemCopy;
    SettingsItemView mSmbBackupItem;
    public XQProgressDialog mXQProgressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.file_setting_activity);
        this.mCameraProperties = (chx) this.mCameraDevice.O000000o();
        initView();
        refreshUI();
        chr.O000000o(chr.O000OO);
    }

    private void initView() {
        this.mRecordModel = (SettingsItemView) findViewById(R.id.settings_sdcard_record);
        this.mSDCardItem = (SettingsItemView) findViewById(R.id.settings_sdcard);
        this.mSDCardItemCopy = findViewById(R.id.settings_sdcard_view);
        this.mRecordModel.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1 */

            /* JADX WARNING: Removed duplicated region for block: B:12:0x00ce  */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x00e4  */
            public void onClick(View view) {
                char c;
                chr.O000000o(chr.O000OOOo);
                chr.O000000o("plg.gn9.dr4.dsi");
                MLAlertDialog.Builder builder = new MLAlertDialog.Builder(FileManagerSettingActivity.this);
                builder.O000000o((int) R.string.setting_record_model_setting);
                FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                fileManagerSettingActivity.mRecordStatus = fileManagerSettingActivity.mCameraProperties.O00000o0();
                View inflate = LayoutInflater.from(FileManagerSettingActivity.this).inflate((int) R.layout.file_setting_record_item, (ViewGroup) null);
                builder.O000000o(inflate);
                builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
                builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!TextUtils.isEmpty(FileManagerSettingActivity.this.mRecordStatus)) {
                            if (!FileManagerSettingActivity.this.mRecordStatus.equals(FileManagerSettingActivity.this.mCameraProperties.O00000o0())) {
                                FileManagerSettingActivity.this.mCameraProperties.O000000o("motion_record", FileManagerSettingActivity.this.mRecordStatus, new Callback<Void>() {
                                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public void onSuccess(Void voidR) {
                                        if (!FileManagerSettingActivity.this.isFinishing()) {
                                            chr.O000000o("plg.gn9.i4v.l1t", "type", Integer.valueOf(FileManagerSettingActivity.this.mRecordStatus.equals("off") ? 1 : FileManagerSettingActivity.this.mRecordStatus.equals("on") ? 2 : 3));
                                            izb.O000000o(FileManagerSettingActivity.this, (int) R.string.settings_set_success, 0).show();
                                            FileManagerSettingActivity.this.refreshUI();
                                        }
                                    }

                                    public void onFailure(int i, String str) {
                                        if (!FileManagerSettingActivity.this.isFinishing()) {
                                            izb.O000000o(FileManagerSettingActivity.this, (int) R.string.set_failed, 0).show();
                                        }
                                    }
                                });
                            }
                            dialogInterface.dismiss();
                        }
                    }
                });
                TextView textView = (TextView) inflate.findViewById(R.id.text1);
                TextView textView2 = (TextView) inflate.findViewById(R.id.text2);
                TextView textView3 = (TextView) inflate.findViewById(R.id.text3);
                final TextView textView4 = (TextView) inflate.findViewById(R.id.title1);
                TextView textView5 = (TextView) inflate.findViewById(R.id.title2);
                TextView textView6 = (TextView) inflate.findViewById(R.id.title3);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.select_icon1);
                ImageView imageView2 = (ImageView) inflate.findViewById(R.id.select_icon2);
                ImageView imageView3 = (ImageView) inflate.findViewById(R.id.select_icon3);
                MLAlertDialog O00000o = builder.O00000o();
                String str = FileManagerSettingActivity.this.mRecordStatus;
                int hashCode = str.hashCode();
                if (hashCode != 3551) {
                    if (hashCode == 3540994 && str.equals("stop")) {
                        c = 1;
                        if (c == 0) {
                            imageView2.setVisibility(0);
                            textView2.setSelected(true);
                            textView5.setSelected(true);
                        } else if (c != 1) {
                            imageView.setVisibility(0);
                            textView.setSelected(true);
                            textView4.setSelected(true);
                        } else {
                            imageView3.setVisibility(0);
                            textView3.setSelected(true);
                            textView6.setSelected(true);
                        }
                        final ImageView imageView4 = imageView3;
                        AnonymousClass2 r11 = r0;
                        final TextView textView7 = textView3;
                        TextView textView8 = textView3;
                        View findViewById = inflate.findViewById(R.id.layout2);
                        final TextView textView9 = textView6;
                        ImageView imageView5 = imageView3;
                        final ImageView imageView6 = imageView2;
                        ImageView imageView7 = imageView2;
                        final TextView textView10 = textView2;
                        ImageView imageView8 = imageView;
                        final TextView textView11 = textView5;
                        TextView textView12 = textView6;
                        final ImageView imageView9 = imageView8;
                        TextView textView13 = textView5;
                        final TextView textView14 = textView;
                        AnonymousClass2 r0 = new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass2 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                             arg types: [java.lang.String, java.lang.String, int]
                             candidates:
                              _m_j.chr.O000000o(int, int, long):void
                              _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                            public void onClick(View view) {
                                imageView4.setVisibility(4);
                                textView7.setSelected(false);
                                textView9.setSelected(false);
                                imageView6.setVisibility(0);
                                textView10.setSelected(true);
                                textView11.setSelected(true);
                                imageView9.setVisibility(4);
                                textView14.setSelected(false);
                                textView4.setSelected(false);
                                FileManagerSettingActivity.this.mRecordStatus = "on";
                                chr.O000000o(chr.O000OoO0, "type", (Object) 1);
                            }
                        };
                        findViewById.setOnClickListener(r11);
                        final ImageView imageView10 = imageView5;
                        final TextView textView15 = textView8;
                        final TextView textView16 = textView12;
                        final ImageView imageView11 = imageView8;
                        final TextView textView17 = textView;
                        final TextView textView18 = textView4;
                        final ImageView imageView12 = imageView7;
                        final TextView textView19 = textView2;
                        final TextView textView20 = textView13;
                        inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass3 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                             arg types: [java.lang.String, java.lang.String, int]
                             candidates:
                              _m_j.chr.O000000o(int, int, long):void
                              _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                            public void onClick(View view) {
                                imageView10.setVisibility(4);
                                textView15.setSelected(false);
                                textView16.setSelected(false);
                                imageView11.setVisibility(0);
                                textView17.setSelected(true);
                                textView18.setSelected(true);
                                imageView12.setVisibility(4);
                                textView19.setSelected(false);
                                textView20.setSelected(false);
                                FileManagerSettingActivity.this.mRecordStatus = "off";
                                chr.O000000o(chr.O000OoO0, "type", (Object) 2);
                            }
                        });
                        inflate.findViewById(R.id.layout3).setOnClickListener(new View.OnClickListener() {
                            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass4 */

                            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                             method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                             arg types: [java.lang.String, java.lang.String, int]
                             candidates:
                              _m_j.chr.O000000o(int, int, long):void
                              _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                            public void onClick(View view) {
                                imageView10.setVisibility(0);
                                textView15.setSelected(true);
                                textView16.setSelected(true);
                                imageView11.setVisibility(4);
                                textView17.setSelected(false);
                                textView18.setSelected(false);
                                imageView12.setVisibility(4);
                                textView19.setSelected(false);
                                textView20.setSelected(false);
                                FileManagerSettingActivity.this.mRecordStatus = "stop";
                                chr.O000000o(chr.O000OoO0, "type", (Object) 3);
                            }
                        });
                        O00000o.show();
                    }
                } else if (str.equals("on")) {
                    c = 0;
                    if (c == 0) {
                    }
                    final ImageView imageView42 = imageView3;
                    AnonymousClass2 r112 = r0;
                    final TextView textView72 = textView3;
                    TextView textView82 = textView3;
                    View findViewById2 = inflate.findViewById(R.id.layout2);
                    final TextView textView92 = textView6;
                    ImageView imageView52 = imageView3;
                    final ImageView imageView62 = imageView2;
                    ImageView imageView72 = imageView2;
                    final TextView textView102 = textView2;
                    ImageView imageView82 = imageView;
                    final TextView textView112 = textView5;
                    TextView textView122 = textView6;
                    final ImageView imageView92 = imageView82;
                    TextView textView132 = textView5;
                    final TextView textView142 = textView;
                    AnonymousClass2 r02 = new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass2 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, java.lang.String, int]
                         candidates:
                          _m_j.chr.O000000o(int, int, long):void
                          _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                        public void onClick(View view) {
                            imageView42.setVisibility(4);
                            textView72.setSelected(false);
                            textView92.setSelected(false);
                            imageView62.setVisibility(0);
                            textView102.setSelected(true);
                            textView112.setSelected(true);
                            imageView92.setVisibility(4);
                            textView142.setSelected(false);
                            textView4.setSelected(false);
                            FileManagerSettingActivity.this.mRecordStatus = "on";
                            chr.O000000o(chr.O000OoO0, "type", (Object) 1);
                        }
                    };
                    findViewById2.setOnClickListener(r112);
                    final ImageView imageView102 = imageView52;
                    final TextView textView152 = textView82;
                    final TextView textView162 = textView122;
                    final ImageView imageView112 = imageView82;
                    final TextView textView172 = textView;
                    final TextView textView182 = textView4;
                    final ImageView imageView122 = imageView72;
                    final TextView textView192 = textView2;
                    final TextView textView202 = textView132;
                    inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass3 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, java.lang.String, int]
                         candidates:
                          _m_j.chr.O000000o(int, int, long):void
                          _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                        public void onClick(View view) {
                            imageView102.setVisibility(4);
                            textView152.setSelected(false);
                            textView162.setSelected(false);
                            imageView112.setVisibility(0);
                            textView172.setSelected(true);
                            textView182.setSelected(true);
                            imageView122.setVisibility(4);
                            textView192.setSelected(false);
                            textView202.setSelected(false);
                            FileManagerSettingActivity.this.mRecordStatus = "off";
                            chr.O000000o(chr.O000OoO0, "type", (Object) 2);
                        }
                    });
                    inflate.findViewById(R.id.layout3).setOnClickListener(new View.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass4 */

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                         arg types: [java.lang.String, java.lang.String, int]
                         candidates:
                          _m_j.chr.O000000o(int, int, long):void
                          _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                        public void onClick(View view) {
                            imageView102.setVisibility(0);
                            textView152.setSelected(true);
                            textView162.setSelected(true);
                            imageView112.setVisibility(4);
                            textView172.setSelected(false);
                            textView182.setSelected(false);
                            imageView122.setVisibility(4);
                            textView192.setSelected(false);
                            textView202.setSelected(false);
                            FileManagerSettingActivity.this.mRecordStatus = "stop";
                            chr.O000000o(chr.O000OoO0, "type", (Object) 3);
                        }
                    });
                    O00000o.show();
                }
                c = 65535;
                if (c == 0) {
                }
                final ImageView imageView422 = imageView3;
                AnonymousClass2 r1122 = r02;
                final TextView textView722 = textView3;
                TextView textView822 = textView3;
                View findViewById22 = inflate.findViewById(R.id.layout2);
                final TextView textView922 = textView6;
                ImageView imageView522 = imageView3;
                final ImageView imageView622 = imageView2;
                ImageView imageView722 = imageView2;
                final TextView textView1022 = textView2;
                ImageView imageView822 = imageView;
                final TextView textView1122 = textView5;
                TextView textView1222 = textView6;
                final ImageView imageView922 = imageView822;
                TextView textView1322 = textView5;
                final TextView textView1422 = textView;
                AnonymousClass2 r022 = new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass2 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                     arg types: [java.lang.String, java.lang.String, int]
                     candidates:
                      _m_j.chr.O000000o(int, int, long):void
                      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                    public void onClick(View view) {
                        imageView422.setVisibility(4);
                        textView722.setSelected(false);
                        textView922.setSelected(false);
                        imageView622.setVisibility(0);
                        textView1022.setSelected(true);
                        textView1122.setSelected(true);
                        imageView922.setVisibility(4);
                        textView1422.setSelected(false);
                        textView4.setSelected(false);
                        FileManagerSettingActivity.this.mRecordStatus = "on";
                        chr.O000000o(chr.O000OoO0, "type", (Object) 1);
                    }
                };
                findViewById22.setOnClickListener(r1122);
                final ImageView imageView1022 = imageView522;
                final TextView textView1522 = textView822;
                final TextView textView1622 = textView1222;
                final ImageView imageView1122 = imageView822;
                final TextView textView1722 = textView;
                final TextView textView1822 = textView4;
                final ImageView imageView1222 = imageView722;
                final TextView textView1922 = textView2;
                final TextView textView2022 = textView1322;
                inflate.findViewById(R.id.layout1).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass3 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                     arg types: [java.lang.String, java.lang.String, int]
                     candidates:
                      _m_j.chr.O000000o(int, int, long):void
                      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                    public void onClick(View view) {
                        imageView1022.setVisibility(4);
                        textView1522.setSelected(false);
                        textView1622.setSelected(false);
                        imageView1122.setVisibility(0);
                        textView1722.setSelected(true);
                        textView1822.setSelected(true);
                        imageView1222.setVisibility(4);
                        textView1922.setSelected(false);
                        textView2022.setSelected(false);
                        FileManagerSettingActivity.this.mRecordStatus = "off";
                        chr.O000000o(chr.O000OoO0, "type", (Object) 2);
                    }
                });
                inflate.findViewById(R.id.layout3).setOnClickListener(new View.OnClickListener() {
                    /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass1.AnonymousClass4 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
                     arg types: [java.lang.String, java.lang.String, int]
                     candidates:
                      _m_j.chr.O000000o(int, int, long):void
                      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
                    public void onClick(View view) {
                        imageView1022.setVisibility(0);
                        textView1522.setSelected(true);
                        textView1622.setSelected(true);
                        imageView1122.setVisibility(4);
                        textView1722.setSelected(false);
                        textView1822.setSelected(false);
                        imageView1222.setVisibility(4);
                        textView1922.setSelected(false);
                        textView2022.setSelected(false);
                        FileManagerSettingActivity.this.mRecordStatus = "stop";
                        chr.O000000o(chr.O000OoO0, "type", (Object) 3);
                    }
                });
                O00000o.show();
            }
        });
        this.mSDCardItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass2 */

            public void onClick(View view) {
                chr.O000000o(chr.O000OOo0);
                chr.O000000o("plg.gn9.c4r.h4u");
                FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                fileManagerSettingActivity.startActivityForResult(new Intent(fileManagerSettingActivity, SDCardStatusActivity.class), 1001);
            }
        });
        this.mSDCardItemCopy.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass3 */

            public void onClick(View view) {
                int O000000o2 = FileManagerSettingActivity.this.mCameraProperties.O000000o("sdcard_status");
                if (O000000o2 == 1 || O000000o2 == 5) {
                    FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                    fileManagerSettingActivity.startActivity(new Intent(fileManagerSettingActivity, NoMemoryCardActivity.class));
                }
            }
        });
        this.mSmbBackupItem = (SettingsItemView) findViewById(R.id.settings_smb_backup);
        this.mSmbBackupItem.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass4 */

            public void onClick(View view) {
                if (FileManagerSettingActivity.this.mCameraProperties.O000000o("sdcard_status") == 1) {
                    MLAlertDialog.Builder builder = new MLAlertDialog.Builder(FileManagerSettingActivity.this);
                    builder.O00000Oo((int) R.string.nas_no_sdcard_hint);
                    builder.O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                        /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass4.AnonymousClass1 */

                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    builder.O00000o().show();
                    return;
                }
                chr.O000000o(chr.O000OOo);
                if (FileManagerSettingActivity.this.mCameraDevice != null) {
                    FileManagerSettingActivity.this.startNAS();
                } else {
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                }
            }
        });
        findViewById(R.id.title_bar_return).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass5 */

            public void onClick(View view) {
                FileManagerSettingActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.more_store_setting);
        this.mCameraProperties.O000000o(new String[]{"sdcard_status", "motion_record"}, new Callback<Void>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass6 */

            public void onSuccess(Void voidR) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.refreshUI();
                }
            }

            public void onFailure(int i, String str) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.refreshUI();
                }
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
     arg types: [java.lang.String, java.lang.String, int]
     candidates:
      _m_j.chr.O000000o(int, int, long):void
      _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088  */
    public void refreshUI() {
        char c;
        int O000000o2 = this.mCameraProperties.O000000o("sdcard_status");
        this.mSDCardItem.setInfo(Util.getSdCardStatus(getResources(), O000000o2));
        String O00000o0 = this.mCameraProperties.O00000o0();
        int hashCode = O00000o0.hashCode();
        if (hashCode != 3551) {
            if (hashCode == 3540994 && O00000o0.equals("stop")) {
                c = 0;
                if (c == 0) {
                    this.mRecordModel.setInfo(getString(R.string.setting_record_model_close));
                } else if (c != 1) {
                    this.mRecordModel.setInfo(getString(R.string.setting_record_model_always));
                } else {
                    this.mRecordModel.setInfo(getString(R.string.setting_record_model_move));
                }
                if (O000000o2 == 1) {
                    this.mSDCardItem.setEnabled(false);
                    this.mSDCardItemCopy.setEnabled(true);
                    chr.O000000o("plg.gn9.m4l.f5v", "type", (Object) 2);
                    this.mRecordModel.setEnabled(false);
                    return;
                } else if (O000000o2 == 5 || O000000o2 == 3) {
                    this.mRecordModel.setEnabled(false);
                    this.mSDCardItem.setEnabled(true);
                    this.mSDCardItemCopy.setEnabled(false);
                    this.mSDCardItemCopy.setVisibility(8);
                    chr.O000000o("plg.gn9.m4l.f5v", "type", (Object) 1);
                    return;
                } else {
                    this.mSDCardItem.setEnabled(true);
                    this.mSmbBackupItem.setEnabled(true);
                    this.mRecordModel.setEnabled(true);
                    this.mSDCardItemCopy.setEnabled(false);
                    this.mSDCardItemCopy.setVisibility(8);
                    chr.O000000o("plg.gn9.m4l.f5v", "type", (Object) 1);
                    return;
                }
            }
        } else if (O00000o0.equals("on")) {
            c = 1;
            if (c == 0) {
            }
            if (O000000o2 == 1) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
        if (O000000o2 == 1) {
        }
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001 && i2 == -1) {
            refreshUI();
            this.mCameraProperties.O000000o(new String[]{"sdcard_status"}, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass7 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Void voidR) {
                    if (!FileManagerSettingActivity.this.isFinishing()) {
                        FileManagerSettingActivity.this.refreshUI();
                    }
                }
            });
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public void startNAS() {
        if (this.mXQProgressDialog == null) {
            initProgressDialog();
        }
        this.mXQProgressDialog.show();
        this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
            /* class com.xiaomi.smarthome.camera.v4.activity.setting.FileManagerSettingActivity.AnonymousClass8 */

            /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
             method: _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void
             arg types: [java.lang.String, java.lang.String, int]
             candidates:
              _m_j.chr.O000000o(int, int, long):void
              _m_j.chr.O000000o(java.lang.String, java.lang.String, java.lang.Object):void */
            public void onSuccess(NASInfo nASInfo) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.mXQProgressDialog.dismiss();
                    if (nASInfo == null || nASInfo.O00000o == 0) {
                        chr.O000000o("plg.gn9.t3o.e0c", "type", (Object) 2);
                        FileManagerSettingActivity fileManagerSettingActivity = FileManagerSettingActivity.this;
                        fileManagerSettingActivity.startActivity(new Intent(fileManagerSettingActivity, NASDiscoveryActivity.class));
                        return;
                    }
                    FileManagerSettingActivity fileManagerSettingActivity2 = FileManagerSettingActivity.this;
                    fileManagerSettingActivity2.startActivity(new Intent(fileManagerSettingActivity2, NASInfoActivity.class));
                    chr.O000000o("plg.gn9.t3o.e0c", "type", (Object) 1);
                }
            }

            public void onFailure(int i, String str) {
                if (!FileManagerSettingActivity.this.isFinishing()) {
                    FileManagerSettingActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                }
            }
        });
    }
}
