package com.xiaomi.smarthome.camera.activity.nas;

import _m_j.ciu;
import _m_j.ft;
import _m_j.gqg;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mijia.camera.nas.NASInfo;
import com.mijia.camera.nas.NASServer;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.CameraBaseActivity;
import com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity;
import com.xiaomi.smarthome.camera.view.CameraPullDownRefreshListView;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import java.util.ArrayList;
import java.util.List;

public class NASDirListActivity extends CameraBaseActivity {
    private SimpleAdapter mAdapter;
    private NASInfo mCurrentInfo;
    public ciu mCurrentNode;
    public List<ciu> mData = new ArrayList();
    private View mEmptyView;
    public Handler mHandler = new Handler(Looper.getMainLooper());
    private ImageView mIcon;
    private CameraPullDownRefreshListView mListView;
    public int mPollCnt = 3;
    public XQProgressDialog mXQProgressDialog;
    public ImageView titleBarReturn;

    public void doCreate(Bundle bundle) {
        super.doCreate(bundle);
        setContentView((int) R.layout.camera_activity_device_smb_discovery_list);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.mCurrentInfo = (NASInfo) intent.getParcelableExtra("data");
        boolean booleanExtra = intent.getBooleanExtra("wait", false);
        this.mCurrentNode = new ciu(this.mCurrentInfo.O00000oo, this.mCurrentInfo.O00000oo.O000000o());
        initView();
        if (booleanExtra) {
            this.mHandler.postDelayed(new Runnable() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass1 */

                public void run() {
                    NASDirListActivity.this.loadNASServerList();
                }
            }, 800);
        } else {
            loadNASServerList();
        }
    }

    private void initView() {
        ((TextView) findViewById(R.id.title_bar_title)).setText((int) R.string.smb_choose_storage_title);
        this.titleBarReturn = (ImageView) findViewById(R.id.title_bar_return);
        this.titleBarReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass2 */

            public void onClick(View view) {
                NASDirListActivity.this.finish();
            }
        });
        findViewById(R.id.title_bar_more).setVisibility(8);
        this.mListView = (CameraPullDownRefreshListView) findViewById(R.id.list);
        this.mListView.setPullDownHeaderVisibility(8);
        this.mAdapter = new SimpleAdapter();
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mEmptyView = findViewById(R.id.white_empty_view);
        this.mEmptyView.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass3 */

            public void onClick(View view) {
                NASDirListActivity.this.loadNASServerList();
            }
        });
        this.mIcon = (ImageView) findViewById(R.id.empty_icon);
        initProgressDialog();
    }

    private void initProgressDialog() {
        this.mXQProgressDialog = new XQProgressDialog(this);
        this.mXQProgressDialog.setMessage(getString(R.string.smb_waiting));
        this.mXQProgressDialog.setCancelable(true);
    }

    public void loadNASServerList() {
        this.mXQProgressDialog.show();
        this.mCurrentNode.f13927O000000o = "";
        this.mCameraDevice.O0000oO0().O000000o(this.mCurrentNode, new Callback<List<ciu>>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass4 */

            public /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                onSuccess((List<ciu>) ((List) obj));
            }

            public void onSuccess(List<ciu> list) {
                if (!NASDirListActivity.this.isFinishing()) {
                    NASDirListActivity.this.mXQProgressDialog.dismiss();
                    if (list != null) {
                        NASDirListActivity.this.mData = list;
                    }
                    NASDirListActivity.this.mHandler.post(new Runnable() {
                        /* class com.xiaomi.smarthome.camera.activity.nas.$$Lambda$NASDirListActivity$4$UMJN6frPlgscjz2h1ICAk6nGJXM */

                        public final void run() {
                            NASDirListActivity.AnonymousClass4.this.lambda$onSuccess$0$NASDirListActivity$4();
                        }
                    });
                }
            }

            public /* synthetic */ void lambda$onSuccess$0$NASDirListActivity$4() {
                if (NASDirListActivity.this.mData.size() == 0) {
                    NASDirListActivity.this.showEmptyView();
                } else {
                    NASDirListActivity.this.showContentView();
                }
            }

            public void onFailure(int i, String str) {
                if (!NASDirListActivity.this.isFinishing()) {
                    NASDirListActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.retrieve_data_fail);
                    NASDirListActivity.this.showErrorView();
                }
            }
        });
    }

    public void showErrorView() {
        this.mEmptyView.setVisibility(0);
        this.mIcon.setImageDrawable(getResources().getDrawable(R.drawable.camera_alarm_common_no_bg));
        ((TextView) this.mEmptyView.findViewById(R.id.white_empty_text)).setText(getString(R.string.smb_retrieve_share_directory_fail));
        this.mListView.setVisibility(8);
    }

    public void showEmptyView() {
        this.mEmptyView.setVisibility(0);
        this.mIcon.setImageDrawable(getResources().getDrawable(R.drawable.camera_smb_empty));
        ((TextView) this.mEmptyView.findViewById(R.id.white_empty_text)).setText(getString(R.string.smb_no_share_directory));
        this.mListView.setVisibility(8);
    }

    public void showContentView() {
        this.mEmptyView.setVisibility(8);
        this.mListView.setVisibility(0);
        this.mAdapter.notifyDataSetChanged();
    }

    class SimpleAdapter extends BaseAdapter {
        public long getItemId(int i) {
            return 0;
        }

        private SimpleAdapter() {
        }

        public int getCount() {
            return NASDirListActivity.this.mData.size();
        }

        public Object getItem(int i) {
            if (i < 0 || i >= NASDirListActivity.this.mData.size()) {
                return null;
            }
            return NASDirListActivity.this.mData.get(i);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.view.ViewGroup, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(NASDirListActivity.this).inflate((int) R.layout.camera_smb_dir_list_item, viewGroup, false);
                viewHolder = new ViewHolder();
                viewHolder.icon = (ImageView) view.findViewById(R.id.device_icon);
                viewHolder.name = (TextView) view.findViewById(R.id.smb_name);
                viewHolder.select = view.findViewById(R.id.select_icon);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            final ciu ciu = NASDirListActivity.this.mData.get(i);
            String str = ciu.O00000Oo;
            viewHolder.name.setText(str);
            view.setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.SimpleAdapter.AnonymousClass1 */

                public void onClick(View view) {
                    NASDirListActivity.this.setNewDir(ciu);
                }
            });
            if (TextUtils.equals(str, NASDirListActivity.this.mCurrentNode.O00000Oo)) {
                viewHolder.select.setVisibility(0);
            } else {
                viewHolder.select.setVisibility(4);
            }
            return view;
        }
    }

    class ViewHolder {
        public ImageView icon;
        public TextView name;
        public View select;

        private ViewHolder() {
        }
    }

    public void deleteOldVideoWithChangeDir(final ciu ciu) {
        if (this.mCameraDevice != null) {
            this.mCameraDevice.O0000oO0().O00000Oo(new Callback<Object>() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass7 */

                public void onSuccess(Object obj) {
                    ciu ciu;
                    if (!NASDirListActivity.this.isFinishing() && (ciu = ciu) != null) {
                        NASDirListActivity.this.changeNASStorageDir(ciu);
                    }
                }

                public void onFailure(int i, String str) {
                    if (!NASDirListActivity.this.isFinishing()) {
                        NASDirListActivity.this.mXQProgressDialog.dismiss();
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean isValid() {
        if (isFinishing()) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 || !isDestroyed()) {
            return true;
        }
        return false;
    }

    public void startPolling(final String str) {
        this.mXQProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass9 */

            public void onCancel(DialogInterface dialogInterface) {
                NASDirListActivity.this.mHandler.removeCallbacksAndMessages(null);
            }
        });
        this.mPollCnt = 5;
        this.mHandler.postDelayed(new Runnable() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass10 */

            public void run() {
                if (NASDirListActivity.this.isValid()) {
                    NASDirListActivity nASDirListActivity = NASDirListActivity.this;
                    nASDirListActivity.mPollCnt--;
                    if (NASDirListActivity.this.mPollCnt < 0) {
                        NASDirListActivity.this.mXQProgressDialog.dismiss();
                        gqg.O000000o((int) R.string.smb_tip_set_fail);
                        return;
                    }
                    NASDirListActivity.this.mCameraDevice.O0000oO0().O000000o(new Callback<NASInfo>() {
                        /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass10.AnonymousClass1 */

                        public void onSuccess(NASInfo nASInfo) {
                            if (nASInfo == null) {
                                NASDirListActivity.this.mHandler.postDelayed(this, 2000);
                            } else if (TextUtils.equals(str, nASInfo.O000000o())) {
                                NASDirListActivity.this.mHandler.post(new Runnable() {
                                    /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass10.AnonymousClass1.AnonymousClass1 */

                                    public void run() {
                                        NASDirListActivity.this.mXQProgressDialog.dismiss();
                                        gqg.O000000o((int) R.string.smb_tip_set_success);
                                        if (TextUtils.isEmpty(NASDirListActivity.this.mCurrentNode.O00000Oo)) {
                                            ft.O000000o(NASDirListActivity.this).O000000o(new Intent("go_smbinfo_clear_top_activity"));
                                            Intent intent = new Intent();
                                            intent.setClass(NASDirListActivity.this, NASInfoActivity.class);
                                            NASDirListActivity.this.startActivity(intent);
                                        }
                                        NASDirListActivity.this.finish();
                                    }
                                });
                            } else {
                                NASDirListActivity.this.mHandler.postDelayed(this, 2000);
                            }
                        }

                        public void onFailure(int i, String str) {
                            if (NASDirListActivity.this.isValid()) {
                                NASDirListActivity.this.mHandler.postDelayed(this, 2000);
                            }
                        }
                    });
                }
            }
        }, 2000);
    }

    public void setNewDir(final ciu ciu) {
        if (TextUtils.isEmpty(ciu.O00000Oo)) {
            gqg.O000000o((int) R.string.smb_tip_empty_dir);
        } else if (!TextUtils.equals(ciu.O00000Oo, this.mCurrentNode.O00000Oo)) {
            if (TextUtils.isEmpty(this.mCurrentNode.O00000Oo)) {
                this.mXQProgressDialog.show();
                changeNASStorageDir(ciu);
                return;
            }
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            this.titleBarReturn.setTag(0);
            builder.O000000o((int) R.string.smb_dialog_change_dir_type_title).O000000o(new String[]{getString(R.string.smb_dialog_change_dir_type_1), getString(R.string.smb_dialog_change_dir_type_3)}, 0, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass6 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    NASDirListActivity.this.titleBarReturn.setTag(Integer.valueOf(i));
                }
            }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O000000o((int) R.string.ok_button, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass5 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    NASDirListActivity.this.mXQProgressDialog.show();
                    Object tag = NASDirListActivity.this.titleBarReturn.getTag();
                    if (tag != null && (tag instanceof Integer)) {
                        if (((Integer) tag).intValue() == 1) {
                            NASDirListActivity.this.deleteOldVideoWithChangeDir(ciu);
                        } else {
                            NASDirListActivity.this.changeNASStorageDir(ciu);
                        }
                    }
                }
            });
            builder.O00000oo();
        }
    }

    public void changeNASStorageDir(final ciu ciu) {
        NASServer nASServer = ciu.O00000o;
        nASServer.O0000O0o = ciu.f13927O000000o;
        this.mCurrentInfo.O00000oo = nASServer;
        this.mCameraDevice.O0000oO0().O000000o(this.mCurrentInfo, new Callback<Object>() {
            /* class com.xiaomi.smarthome.camera.activity.nas.NASDirListActivity.AnonymousClass8 */

            public void onSuccess(Object obj) {
                if (!NASDirListActivity.this.isFinishing()) {
                    NASDirListActivity.this.setResult(-1);
                    NASDirListActivity.this.startPolling(ciu.f13927O000000o);
                }
            }

            public void onFailure(int i, String str) {
                if (!NASDirListActivity.this.isFinishing()) {
                    NASDirListActivity.this.mXQProgressDialog.dismiss();
                    gqg.O000000o((int) R.string.smb_tip_set_fail);
                }
            }
        });
    }
}
