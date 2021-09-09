package com.xiaomi.smarthome.camera.activity.sdcard;

import _m_j.cih;
import _m_j.clo;
import _m_j.clr;
import _m_j.cls;
import _m_j.clu;
import _m_j.ft;
import _m_j.gkv;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mijia.model.sdcard.TimeItem;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.BaseSelectActivity;
import com.xiaomi.smarthome.camera.activity.sdcard.SDCardAdapter2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.XmPluginHostApi;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListView;
import com.xiaomi.smarthome.miio.camera.cloudstorage.CloudVideoDateListViewAdapter;
import com.xiaomi.smarthome.miio.camera.cloudstorage.model.CloudVideoDate;
import com.xiaomi.smarthome.plugin.DeviceConstant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SDCard2Activity extends BaseSelectActivity implements clo.O00000Oo {
    public static final String TAG = "SDCard2Activity";
    CloudVideoDateListView allDays_list;
    CloudVideoDateListViewAdapter allDays_listAdapter;
    private boolean initialedAllDateList = false;
    BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass1 */

        public void onReceive(Context context, Intent intent) {
            if (SDCard2Activity.this.mCameraDevice == null) {
                return;
            }
            if (SDCard2Activity.this.mCameraDevice.O00000o()) {
                SDCard2Activity.this.mCameraDevice.O0000Oo0();
                if ("com.mijia.camera.SdcardManagerEx".equals(intent.getAction()) && SDCard2Activity.this.mCameraSdcardFileManagerEx != null) {
                    SDCard2Activity sDCard2Activity = SDCard2Activity.this;
                    sDCard2Activity.timeItemList = sDCard2Activity.mCameraSdcardFileManagerEx.O0000OOo();
                    SDCard2Activity.this.setData();
                    return;
                }
                return;
            }
            SDCard2Activity.this.mCameraDevice.O0000OOo();
            if ("com.mijia.camera.SdcardManager".equals(intent.getAction()) && SDCard2Activity.this.mCameraSdcardFileManager != null) {
                SDCard2Activity sDCard2Activity2 = SDCard2Activity.this;
                sDCard2Activity2.timeItemList = sDCard2Activity2.mCameraSdcardFileManager.O0000OOo();
                SDCard2Activity.this.setData();
            }
        }
    };
    public clr mCameraSdcardFileManager;
    public cls mCameraSdcardFileManagerEx;
    clo mDownloadSdCardFileManager;
    private View mEmptyLayout;
    private ft mLocalBroadcastManager;
    XQProgressDialog mProgressDialog;
    private String[] monthArray;
    SDCardAdapter2 sdCardAdapter2;
    List<clu> timeItemList;
    FrameLayout title_bar_top_fl;
    RecyclerView today_list_recycler;
    String version;

    public void onDownloading(clo.O000000o o000000o, String str, int i) {
    }

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_sdcard_file2);
        this.version = this.mCameraDevice.O00000o0();
        this.mLocalBroadcastManager = ft.O000000o(activity());
        if (this.mCameraDevice != null) {
            this.mCameraDevice.O00000o0();
            if (this.mCameraDevice.O00000o()) {
                this.mCameraSdcardFileManagerEx = this.mCameraDevice.O0000Oo0();
            } else {
                this.mCameraSdcardFileManager = this.mCameraDevice.O0000OOo();
            }
        }
        initView();
        IntentFilter intentFilter = new IntentFilter();
        if (this.mCameraDevice.O00000o()) {
            if (this.mCameraSdcardFileManagerEx != null) {
                intentFilter.addAction("com.mijia.camera.SdcardManagerEx");
            }
        } else if (this.mCameraSdcardFileManager != null) {
            intentFilter.addAction("com.mijia.camera.SdcardManager");
        }
        this.mLocalBroadcastManager.O000000o(this.mBroadcastReceiver, intentFilter);
        if (this.mCameraDevice.O00000o()) {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o0();
        } else {
            this.mDownloadSdCardFileManager = this.mCameraDevice.O0000o00();
        }
        this.mDownloadSdCardFileManager.O000000o(this);
    }

    public void onResume() {
        super.onResume();
        this.version = this.mCameraDevice.O00000o0();
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
        if (this.mCameraDevice == null) {
            return;
        }
        if (this.mCameraDevice.O00000o()) {
            cls cls2 = this.mCameraSdcardFileManagerEx;
            if (cls2 != null) {
                this.timeItemList = cls2.O0000OOo();
                setData();
                return;
            }
            return;
        }
        clr clr2 = this.mCameraSdcardFileManager;
        if (clr2 != null) {
            this.timeItemList = clr2.O0000OOo();
            setData();
        }
    }

    private void initView() {
        this.today_list_recycler = (RecyclerView) findViewById(R.id.today_list_recycler);
        this.today_list_recycler.setLayoutManager(new GridLayoutManager(this, 3));
        initSelectView();
        this.title_bar_top_fl = (FrameLayout) findViewById(R.id.title_bar_top_fl);
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.see_all_video);
        this.mEmptyLayout = findViewById(R.id.empty_layout);
        this.mEmptyLayout.setVisibility(0);
        if (DeviceConstant.supportDownloadToPhone(this.mCameraDevice.getModel())) {
            findViewById(R.id.select_down).setVisibility(0);
            findViewById(R.id.select_down).setOnClickListener(this);
        } else {
            findViewById(R.id.select_save).setVisibility(0);
            findViewById(R.id.select_save).setOnClickListener(this);
        }
        findViewById(R.id.select_delete).setOnClickListener(this);
    }

    private void initAllDateList() {
        List<clu> list;
        gsy.O00000Oo(TAG, "initAllDateList" + this.initialedAllDateList);
        if (!this.initialedAllDateList && (list = this.timeItemList) != null && list.size() != 0) {
            this.initialedAllDateList = true;
            ArrayList arrayList = new ArrayList();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            this.monthArray = gkv.f17949O000000o.getResources().getStringArray(R.array.cs_month_array);
            if (this.timeItemList.size() < 7) {
                long j = this.timeItemList.get(0).O00000o;
                for (int size = 7 - this.timeItemList.size(); size > 0; size--) {
                    CloudVideoDate cloudVideoDate = new CloudVideoDate();
                    long j2 = j - (((long) size) * 86400000);
                    String format = simpleDateFormat.format(Long.valueOf(j2));
                    cloudVideoDate.day = format.split("-")[2];
                    cloudVideoDate.month = format.split("-")[1];
                    cloudVideoDate.monthChinaPattern = this.monthArray[Integer.valueOf(cloudVideoDate.month).intValue() - 1];
                    cloudVideoDate.year = format.split("-")[0];
                    cloudVideoDate.timeStamp = j2;
                    arrayList.add(cloudVideoDate);
                }
            }
            for (int i = 0; i < this.timeItemList.size(); i++) {
                CloudVideoDate cloudVideoDate2 = new CloudVideoDate();
                long j3 = this.timeItemList.get(i).O00000o;
                String format2 = simpleDateFormat.format(Long.valueOf(j3));
                gsy.O00000Oo(TAG, "date=".concat(String.valueOf(format2)));
                cloudVideoDate2.day = format2.split("-")[2];
                cloudVideoDate2.month = format2.split("-")[1];
                cloudVideoDate2.monthChinaPattern = this.monthArray[Integer.valueOf(cloudVideoDate2.month).intValue() - 1];
                cloudVideoDate2.year = format2.split("-")[0];
                cloudVideoDate2.timeStamp = j3;
                arrayList.add(cloudVideoDate2);
            }
            this.allDays_list = (CloudVideoDateListView) findViewById(R.id.allDays_list);
            this.allDays_listAdapter = new CloudVideoDateListViewAdapter(arrayList);
            this.allDays_list.setLayoutManager(new LinearLayoutManager(this, 0, false));
            this.allDays_list.setAdapter(this.allDays_listAdapter);
            this.allDays_list.scrollToPosition(this.allDays_listAdapter.getItemCount() - 1);
            CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.allDays_listAdapter;
            cloudVideoDateListViewAdapter.selectedItemPosition = cloudVideoDateListViewAdapter.getItemCount() - 1;
            this.allDays_listAdapter.iItemClickListener = new CloudVideoDateListViewAdapter.IItemClickListener<CloudVideoDate>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass2 */

                public void onItemClick(View view, int i, CloudVideoDate cloudVideoDate) {
                    if (SDCard2Activity.this.mIsMultiSelectMode) {
                        SDCard2Activity.this.sdCardAdapter2.setMultiSelectMode(false);
                        SDCard2Activity.this.setMultiSelectMode(false);
                    }
                    SDCard2Activity.this.allDays_listAdapter.notifyDataSetChanged();
                    SDCard2Activity.this.setData();
                }
            };
        }
    }

    public void setData() {
        List<clu> list;
        List<clu> list2;
        initAllDateList();
        if (!this.mIsMultiSelectMode && this.allDays_listAdapter != null && (list = this.timeItemList) != null && list.size() != 0) {
            CloudVideoDateListViewAdapter cloudVideoDateListViewAdapter = this.allDays_listAdapter;
            int itemPosition = getItemPosition(clu.O00000Oo().format(Long.valueOf(((CloudVideoDate) cloudVideoDateListViewAdapter.getItem(cloudVideoDateListViewAdapter.selectedItemPosition)).timeStamp)));
            clu clu = null;
            if (!(itemPosition == -1 || (list2 = this.timeItemList) == null)) {
                clu = list2.get(itemPosition);
            }
            if (this.sdCardAdapter2 == null) {
                this.sdCardAdapter2 = new SDCardAdapter2(this.today_list_recycler, this, this.mCameraDevice.getDid(), new SDCardAdapter2.OnItemClickListener() {
                    /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass3 */

                    public void onItemClick(int i, int i2) {
                        CloudVideoDate cloudVideoDate = (CloudVideoDate) SDCard2Activity.this.allDays_listAdapter.getItem(SDCard2Activity.this.allDays_listAdapter.selectedItemPosition);
                        String format = clu.O00000Oo().format(Long.valueOf(cloudVideoDate.timeStamp));
                        int itemPosition = SDCard2Activity.this.getItemPosition(format);
                        String str = SDCard2Activity.TAG;
                        gsy.O00000Oo(str, "onItemClick=" + format + "--" + SDCard2Activity.this.getItemPosition(format));
                        Intent intent = new Intent(SDCard2Activity.this, SDCardHourActivity.class);
                        intent.putExtra("timeStamp", cloudVideoDate.timeStamp);
                        intent.putExtra("TimeItemsDays", itemPosition);
                        intent.putExtra("TimeItemsHour", i2);
                        SDCard2Activity.this.startActivity(intent);
                    }

                    public void onItemLongClick() {
                        SDCard2Activity.this.onLongClick();
                    }

                    public void onSelectChanged() {
                        SDCard2Activity.this.refreshSelectTitle();
                    }
                });
                this.today_list_recycler.setAdapter(this.sdCardAdapter2);
            }
            this.sdCardAdapter2.setHideIcon(false);
            this.sdCardAdapter2.update(clu);
            if (clu == null || clu.O0000O0o == null || clu.O0000O0o.size() == 0) {
                this.today_list_recycler.setVisibility(8);
                this.mEditBtn.setVisibility(8);
                this.mEmptyLayout.setVisibility(0);
                return;
            }
            if (!this.mCameraDevice.isReadOnlyShared()) {
                this.mEditBtn.setVisibility(0);
            } else {
                this.mEditBtn.setVisibility(8);
            }
            this.today_list_recycler.setVisibility(0);
            this.mEmptyLayout.setVisibility(8);
        }
    }

    public int getItemPosition(String str) {
        if (this.mCameraDevice.O00000o()) {
            cls cls = this.mCameraSdcardFileManagerEx;
            if (cls != null) {
                return cls.O000000o(str);
            }
            return -1;
        }
        clr clr = this.mCameraSdcardFileManager;
        if (clr != null) {
            return clr.O000000o(str);
        }
        return -1;
    }

    public int getSelectCount() {
        return this.sdCardAdapter2.getSelectCount();
    }

    public int getDataCount() {
        return this.sdCardAdapter2.getItemCount();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.title_bar_more) {
            if (this.mCameraDevice.isReadOnlyShared()) {
                activity();
                gqg.O000000o((int) R.string.auth_fail_read_only);
                return;
            }
            setMultiSelectMode(true);
        } else if (view.getId() == R.id.ivSelectAll) {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_deselect_all_black);
                this.sdCardAdapter2.selectAll(true);
            } else {
                this.mSelectAllShowed = true;
                this.mSelectAllBtn.setImageResource(R.drawable.camera_edit_select_all_black);
                this.sdCardAdapter2.selectAll(false);
            }
            refreshSelectTitle();
        } else if (view.getId() == R.id.ivSelectAllCancel) {
            setMultiSelectMode(false);
        } else if (view.getId() == R.id.select_down) {
            if (!XmPluginHostApi.instance().checkAndRequestPermisson(this, true, null, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                getContext();
                gqg.O000000o((int) R.string.no_write_permission);
                return;
            }
            initProgressDlg();
            List<TimeItem> selectSubItems = this.sdCardAdapter2.getSelectSubItems();
            if (selectSubItems == null || selectSubItems.size() == 0) {
                gqg.O00000Oo((int) R.string.bottom_action_tip);
                return;
            }
            for (TimeItem O00000o0 : selectSubItems) {
                this.mDownloadSdCardFileManager.O00000o0(O00000o0);
            }
            this.mDownloadSdCardFileManager.O000000o();
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(getString(R.string.cs_downloading));
            this.mProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass4 */

                public void onDismiss(DialogInterface dialogInterface) {
                    SDCard2Activity.this.mProgressDialog.setOnDismissListener(null);
                    SDCard2Activity.this.mDownloadSdCardFileManager.O00000o = true;
                }
            });
            this.mProgressDialog.show();
            setMultiSelectMode(false);
        } else if (view.getId() == R.id.select_save) {
            List<TimeItem> selectSubItems2 = this.sdCardAdapter2.getSelectSubItems();
            initProgressDlg();
            cih.O00000Oo(activity(), this.mCameraDevice, selectSubItems2, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass5 */

                public void onSuccess(Void voidR) {
                    if (!SDCard2Activity.this.isFinishing()) {
                        SDCard2Activity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass5.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCard2Activity.this.activity(), (int) R.string.save_sucess, 0).show();
                                SDCard2Activity.this.disProgressDlg();
                                SDCard2Activity.this.setMultiSelectMode(false);
                                if (SDCard2Activity.this.mCameraDevice == null) {
                                    return;
                                }
                                if (SDCard2Activity.this.mCameraDevice.O00000o()) {
                                    if (SDCard2Activity.this.mCameraSdcardFileManagerEx != null) {
                                        SDCard2Activity.this.timeItemList = SDCard2Activity.this.mCameraSdcardFileManagerEx.O0000OOo();
                                        SDCard2Activity.this.setData();
                                    }
                                } else if (SDCard2Activity.this.mCameraSdcardFileManager != null) {
                                    SDCard2Activity.this.timeItemList = SDCard2Activity.this.mCameraSdcardFileManager.O0000OOo();
                                    SDCard2Activity.this.setData();
                                }
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCard2Activity.this.isFinishing()) {
                        SDCard2Activity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass5.AnonymousClass2 */

                            public void run() {
                                SDCard2Activity.this.disProgressDlg();
                                izb.O000000o(SDCard2Activity.this.activity(), (int) R.string.save_failed, 0).show();
                            }
                        });
                    }
                }
            });
        } else if (view.getId() == R.id.select_delete) {
            List<TimeItem> selectSubItems3 = this.sdCardAdapter2.getSelectSubItems();
            initProgressDlg();
            this.mProgressDialog.setCanceledOnTouchOutside(false);
            this.mProgressDialog.setMessage(getString(R.string.deleting));
            cih.O000000o(activity(), this.mCameraDevice, selectSubItems3, this.mProgressDialog, new Callback<Void>() {
                /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass6 */

                public void onSuccess(Void voidR) {
                    if (!SDCard2Activity.this.isFinishing()) {
                        SDCard2Activity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass6.AnonymousClass1 */

                            public void run() {
                                izb.O000000o(SDCard2Activity.this.activity(), (int) R.string.delete_sucess, 0).show();
                                SDCard2Activity.this.disProgressDlg();
                                SDCard2Activity.this.setMultiSelectMode(false);
                                if (SDCard2Activity.this.mCameraDevice == null) {
                                    return;
                                }
                                if (SDCard2Activity.this.mCameraDevice.O00000o()) {
                                    if (SDCard2Activity.this.mCameraSdcardFileManagerEx != null) {
                                        SDCard2Activity.this.timeItemList = SDCard2Activity.this.mCameraSdcardFileManagerEx.O0000OOo();
                                        SDCard2Activity.this.setData();
                                    }
                                } else if (SDCard2Activity.this.mCameraSdcardFileManager != null) {
                                    SDCard2Activity.this.timeItemList = SDCard2Activity.this.mCameraSdcardFileManager.O0000OOo();
                                    SDCard2Activity.this.setData();
                                }
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!SDCard2Activity.this.isFinishing()) {
                        SDCard2Activity.this.runMainThread(new Runnable() {
                            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass6.AnonymousClass2 */

                            public void run() {
                                SDCard2Activity.this.disProgressDlg();
                                izb.O000000o(SDCard2Activity.this.activity(), (int) R.string.delete_failed, 0).show();
                            }
                        });
                    }
                }
            });
        }
    }

    public void onLongClick() {
        if (this.mCameraDevice.isReadOnlyShared()) {
            activity();
            gqg.O000000o((int) R.string.auth_fail_read_only);
        } else if (!this.mIsMultiSelectMode) {
            this.sdCardAdapter2.setMultiSelectMode(true);
            setMultiSelectMode(true, true);
        }
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

    public void setMultiSelectMode(boolean z, boolean z2) {
        super.setMultiSelectMode(z, z2);
        if (z) {
            this.title_bar_top_fl.setVisibility(4);
        } else {
            this.title_bar_top_fl.setVisibility(0);
        }
        this.sdCardAdapter2.setMultiSelectMode(z);
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
        if (this.mCameraDevice != null) {
            this.mDownloadSdCardFileManager.O000000o((clo.O00000Oo) null);
        }
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            this.sdCardAdapter2.setMultiSelectMode(false);
            setMultiSelectMode(false);
            return;
        }
        super.onBackPressed();
    }

    public void onDownloadSuccess(clo.O000000o o000000o, String str) {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass7 */

            public void run() {
                SDCard2Activity.this.disProgressDlg();
            }
        });
    }

    public void onDownloadFailed(clo.O000000o o000000o, String str, int i, String str2) {
        runMainThread(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.sdcard.SDCard2Activity.AnonymousClass8 */

            public void run() {
                SDCard2Activity.this.disProgressDlg();
            }
        });
    }
}
