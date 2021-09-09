package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.cih;
import _m_j.clr;
import _m_j.cls;
import _m_j.clu;
import _m_j.ft;
import _m_j.gqg;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.view.HourOfDayView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.List;

public class SDCardActivity extends BaseSelectActivity implements HourOfDayView.HourOfDayViewListener {
    private SDCardAdapter mAdapter;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (SDCardActivity.this.mCameraDevice == null) {
                return;
            }
            if (SDCardActivity.this.mCameraDevice.O00000o()) {
                SDCardActivity.this.mCameraDevice.O0000Oo0();
                if ("com.mijia.camera.SdcardManagerEx".equals(intent.getAction()) && SDCardActivity.this.mCameraSdcardFileManagerEx != null) {
                    SDCardActivity sDCardActivity = SDCardActivity.this;
                    sDCardActivity.setData(sDCardActivity.mCameraSdcardFileManagerEx.O0000OOo());
                    return;
                }
                return;
            }
            SDCardActivity.this.mCameraDevice.O0000OOo();
            if ("com.mijia.camera.SdcardManager".equals(intent.getAction()) && SDCardActivity.this.mCameraSdcardFileManager != null) {
                SDCardActivity sDCardActivity2 = SDCardActivity.this;
                sDCardActivity2.setData(sDCardActivity2.mCameraSdcardFileManager.O0000OOo());
            }
        }
    };
    public clr mCameraSdcardFileManager;
    public cls mCameraSdcardFileManagerEx;
    private View mEmptyLayout;
    private ListView mListView;
    private ft mLocalBroadcastManager;
    XQProgressDialog mProgressDialog;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_sdcard_file);
        this.mLocalBroadcastManager = ft.O000000o(activity());
        if (this.mCameraDevice != null) {
            if (this.mCameraDevice.O00000o()) {
                this.mCameraSdcardFileManagerEx = this.mCameraDevice.O0000Oo0();
            } else {
                this.mCameraSdcardFileManager = this.mCameraDevice.O0000OOo();
            }
        }
        initView();
    }

    public void onResume() {
        super.onResume();
        if (this.mCameraDevice.O00000o()) {
            cls cls = this.mCameraSdcardFileManagerEx;
            if (cls != null) {
                cls.O0000O0o();
                this.mCameraSdcardFileManagerEx.O000000o();
            }
        } else {
            clr clr = this.mCameraSdcardFileManager;
            if (clr != null) {
                clr.O0000O0o();
                this.mCameraSdcardFileManager.O000000o();
            }
        }
        IntentFilter intentFilter = new IntentFilter();
        if (this.mCameraDevice.O00000o()) {
            if (this.mCameraSdcardFileManagerEx != null) {
                intentFilter.addAction("com.mijia.camera.SdcardManagerEx");
            }
        } else if (this.mCameraSdcardFileManager != null) {
            intentFilter.addAction("com.mijia.camera.SdcardManager");
        }
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        if (this.mCameraDevice == null) {
            return;
        }
        if (this.mCameraDevice.O00000o()) {
            cls cls2 = this.mCameraSdcardFileManagerEx;
            if (cls2 != null) {
                setData(cls2.O0000OOo());
                return;
            }
            return;
        }
        clr clr2 = this.mCameraSdcardFileManager;
        if (clr2 != null) {
            setData(clr2.O0000OOo());
        }
    }

    private void initView() {
        initSelectView();
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.record_files_sdcard);
        this.mEmptyLayout = findViewById(R.id.empty_layout);
        this.mEmptyLayout.setVisibility(0);
        this.mListView = (ListView) findViewById(R.id.list_view);
        this.mAdapter = new SDCardAdapter(activity());
        this.mAdapter.setDayViewListener(this);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        findViewById(R.id.select_save).setOnClickListener(this);
        findViewById(R.id.select_delete).setOnClickListener(this);
    }

    public void setData(List<clu> list) {
        if (!this.mIsMultiSelectMode) {
            if (list.isEmpty()) {
                this.mListView.setVisibility(8);
                this.mEditBtn.setVisibility(8);
                this.mEmptyLayout.setVisibility(0);
                return;
            }
            this.mAdapter.setData(list);
            if (!this.mCameraDevice.isReadOnlyShared()) {
                this.mEditBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(8);
            }
            this.mListView.setVisibility(0);
            this.mEmptyLayout.setVisibility(8);
        }
    }

    public int getSelectCount() {
        return this.mAdapter.getSelectCount();
    }

    public int getDataCount() {
        return this.mAdapter.getDataCount();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.title_bar_return) {
            onBackPressed();
        } else if (id == R.id.title_bar_more) {
            if (this.mCameraDevice.isReadOnlyShared()) {
                activity();
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            setMultiSelectMode(true);
        } else if (id == R.id.ivSelectAll) {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_deselect_all_black);
                this.mAdapter.selectAll();
            } else {
                this.mSelectAllShowed = true;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_select_all_black);
                this.mAdapter.unSelectAll();
            }
            refreshSelectTitle();
        } else if (id == R.id.ivSelectAllCancel) {
            setMultiSelectMode(false);
        } else if (id == R.id.select_save) {
            List<TimeItem> selectItems = this.mAdapter.getSelectItems();
            initProgressDlg();
            cih.O00000Oo(activity(), this.mCameraDevice, selectItems, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass2 */

                public void onSuccess(Void voidR) {
                    if (!SDCardActivity.this.isFinishing()) {
                        SDCardActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass2.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCardActivity.this.activity(), (int) R.string.save_sucess, 0).show();
                                SDCardActivity.this.disProgressDlg();
                                SDCardActivity.this.setMultiSelectMode(false);
                                if (SDCardActivity.this.mCameraDevice == null) {
                                    return;
                                }
                                if (SDCardActivity.this.mCameraDevice.O00000o()) {
                                    if (SDCardActivity.this.mCameraSdcardFileManagerEx != null) {
                                        SDCardActivity.this.setData(SDCardActivity.this.mCameraSdcardFileManagerEx.O0000OOo());
                                    }
                                } else if (SDCardActivity.this.mCameraSdcardFileManager != null) {
                                    SDCardActivity.this.setData(SDCardActivity.this.mCameraSdcardFileManager.O0000OOo());
                                }
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCardActivity.this.isFinishing()) {
                        SDCardActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass2.AnonymousClass2 */

                            public void run() {
                                SDCardActivity.this.disProgressDlg();
                                izb.O000000o(SDCardActivity.this.activity(), (int) R.string.save_failed, 0).show();
                            }
                        });
                    }
                }
            });
        } else if (id == R.id.select_delete) {
            List<TimeItem> selectItems2 = this.mAdapter.getSelectItems();
            initProgressDlg();
            cih.O000000o(activity(), this.mCameraDevice, selectItems2, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass3 */

                public void onSuccess(Void voidR) {
                    if (!SDCardActivity.this.isFinishing()) {
                        SDCardActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass3.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCardActivity.this.activity(), (int) R.string.delete_sucess, 0).show();
                                SDCardActivity.this.disProgressDlg();
                                SDCardActivity.this.setMultiSelectMode(false);
                                if (SDCardActivity.this.mCameraDevice == null) {
                                    return;
                                }
                                if (SDCardActivity.this.mCameraDevice.O00000o()) {
                                    if (SDCardActivity.this.mCameraSdcardFileManagerEx != null) {
                                        SDCardActivity.this.setData(SDCardActivity.this.mCameraSdcardFileManagerEx.O0000OOo());
                                    }
                                } else if (SDCardActivity.this.mCameraSdcardFileManager != null) {
                                    SDCardActivity.this.setData(SDCardActivity.this.mCameraSdcardFileManager.O0000OOo());
                                }
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCardActivity.this.isFinishing()) {
                        SDCardActivity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCardActivity.AnonymousClass3.AnonymousClass2 */

                            public void run() {
                                SDCardActivity.this.disProgressDlg();
                                izb.O000000o(SDCardActivity.this.activity(), (int) R.string.delete_failed, 0).show();
                            }
                        });
                    }
                }
            });
        }
    }

    public void onClick(int i, int i2) {
        Intent intent = new Intent(this, SDCardHourActivity.class);
        intent.putExtra("TimeItemsDays", i);
        intent.putExtra("TimeItemsHour", i2);
        startActivity(intent);
    }

    public void onLongClick() {
        if (this.mCameraDevice.isReadOnlyShared()) {
            activity();
            gqg.O000000o((int) R.string.auth_fail_read_only);
        } else if (!this.mIsMultiSelectMode) {
            this.mAdapter.setMultiSelectMode(true);
            setMultiSelectMode(true, true);
        }
    }

    public void onSelectChanged() {
        refreshSelectTitle();
    }

    public void initProgressDlg() {
        if (this.mProgressDialog == null) {
            this.mProgressDialog = new XQProgressDialog(activity());
        }
    }

    public void disProgressDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDialog;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDialog.dismiss();
        }
    }

    public void setMultiSelectMode(boolean z) {
        super.setMultiSelectMode(z);
        this.mAdapter.setMultiSelectMode(z);
    }

    public void onPause() {
        if (this.mCameraDevice != null) {
            if (this.mCameraDevice.O00000o()) {
                cls cls = this.mCameraSdcardFileManagerEx;
                if (cls != null) {
                    cls.O00000Oo();
                    this.mCameraSdcardFileManagerEx.O0000O0o();
                }
            } else {
                clr clr = this.mCameraSdcardFileManager;
                if (clr != null) {
                    clr.O00000Oo();
                    this.mCameraSdcardFileManager.O0000O0o();
                }
            }
        }
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver);
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            this.mAdapter.setMultiSelectMode(false);
            setMultiSelectMode(false);
            return;
        }
        super.onBackPressed();
    }
}
