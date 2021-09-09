package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.cki;
import _m_j.cnx;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hxi;
import _m_j.jdc;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.activity.alarm2.AlarmVideoPlayerActivity;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceEventAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEvent;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEventItem;
import com.xiaomi.smarthome.miio.camera.face.model.FaceEventList;
import com.xiaomi.smarthome.miio.camera.face.model.FaceIdMetaResult;
import com.xiaomi.smarthome.miio.camera.face.model.FaceInfoEx;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class FigureFacesEventActivity extends FaceSelectActivityNew implements View.OnClickListener, FigureFaceEventAdapter.ClickCallBack {
    public static final String TAG = "FigureFacesEventActivity";
    private boolean edited = false;
    public RelativeLayout emptyContent;
    private ImageView figureCoverFace;
    public boolean hasManaged = false;
    boolean isFromManage = false;
    public ImageView ivTitleBarMore;
    public FigureFaceEventAdapter mAdapter;
    public boolean mIsMultiSelectMode = false;
    public int mLastEnd = 0;
    public int mLastStart = 0;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    public SimpleDateFormat mTimeFormaterDay = new SimpleDateFormat("M月d日");
    public SimpleDateFormat mTimeFormaterMinute = new SimpleDateFormat("HH:mm");
    public RecyclerView recyclerView;
    public TextView tvEditMark;
    public TextView tvFigureName;
    public TextView tvStatus;
    private TextView tvTitle;

    private void deleteAlertDialog() {
    }

    /* access modifiers changed from: protected */
    public int getDataCount() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getSelectCount() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public boolean isAllSelected() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onEnterSelectMode() {
    }

    /* access modifiers changed from: protected */
    public void onExitSelectMode() {
    }

    /* access modifiers changed from: protected */
    public void onSelectAll() {
    }

    /* access modifiers changed from: protected */
    public void onUnSelectAll() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_figure_face_event);
        this.mTimeFormaterDay = new SimpleDateFormat(getString(R.string.simple_date_format_mm_dd));
        gwg.O000000o(findViewById(R.id.title_bar_container));
        this.figureInfoEx = (FaceInfoEx) getIntent().getExtras().get("figureInfo");
        if (this.figureInfoEx == null) {
            cki.O00000o(TAG, "figureInfo == null");
        }
        this.isFromManage = getIntent().getBooleanExtra("is_from_manage", false);
        iniView();
    }

    public void onStart() {
        super.onStart();
        if (this.isFromManage) {
            updateCoverFace(this.figureCoverFace);
        }
        loadData();
    }

    private void iniView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.ivTitleBarMore = (ImageView) findViewById(R.id.title_bar_more);
        this.ivTitleBarMore.setImageResource(R.drawable.camera_titlebar_error_report);
        this.ivTitleBarMore.setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.title_bar_title);
        this.tvTitle.setText(getResources().getString(R.string.lowpower_face_manager));
        this.tvStatus = (TextView) findViewById(R.id.tv_statues);
        this.tvEditMark = (TextView) findViewById(R.id.tv_edit_mark);
        this.tvEditMark.setOnClickListener(this);
        this.tvEditMark.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        this.tvEditMark.setBackgroundResource(R.drawable.bg_round_corner_12dp);
        if (!TextUtils.isEmpty(this.figureInfoEx.figureId)) {
            this.tvEditMark.setText((int) R.string.string_face_manager);
        } else {
            this.tvEditMark.setText((int) R.string.add_notes);
        }
        this.figureCoverFace = (ImageView) findViewById(R.id.figure_cover_face);
        this.tvFigureName = (TextView) findViewById(R.id.tv_figure_name);
        if (!TextUtils.isEmpty(this.figureInfoEx.figureName)) {
            this.tvFigureName.setText(this.figureInfoEx.figureName);
        } else {
            this.tvFigureName.setText((int) R.string.face_unmarked);
        }
        if (cnx.O000000o().O00000Oo()) {
            if (this.isFromManage || TextUtils.isEmpty(this.figureInfoEx.faceId)) {
                cnx.O000000o().O000000o(mFaceManager.getFaceImg(this.figureInfoEx.coverFaceId), this.figureCoverFace);
            } else {
                cnx.O000000o().O000000o(mFaceManager.getFaceImg(this.figureInfoEx.faceId), this.figureCoverFace);
            }
        }
        this.emptyContent = (RelativeLayout) findViewById(R.id.rl_empty_content);
        this.recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.mAdapter = new FigureFaceEventAdapter(this, this, mFaceManager, TextUtils.isEmpty(this.figureInfoEx.figureName) ? null : this.figureInfoEx.figureName);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        this.recyclerView.setAnimation(null);
        this.recyclerView.setAdapter(this.mAdapter);
    }

    public String getCurFaceIds() {
        String[] strArr;
        String[] strArr2 = new String[this.figureInfoEx.faceIds.size()];
        this.figureInfoEx.faceIds.toArray(strArr2);
        this.mLastEnd = Math.min(this.mLastStart + 100, strArr2.length);
        int i = this.mLastEnd;
        int i2 = this.mLastStart;
        if (i <= i2 || (strArr = (String[]) Arrays.copyOfRange(strArr2, i2, i)) == null) {
            return null;
        }
        int length = strArr.length;
        if (strArr == null) {
            return null;
        }
        int i3 = length + 0;
        if (i3 <= 0) {
            return "";
        }
        jdc jdc = new jdc(i3 * ((strArr[0] == null ? 16 : strArr[0].toString().length()) + 1));
        for (int i4 = 0; i4 < length; i4++) {
            if (i4 > 0) {
                jdc.O000000o(",");
            }
            if (strArr[i4] != null) {
                String str = strArr[i4];
                if (str == null) {
                    jdc.O000000o();
                } else {
                    jdc.O000000o(str.toString());
                }
            }
        }
        return jdc.toString();
    }

    public void getFaceEvt() {
        if (this.figureInfoEx.faceIds == null) {
            this.emptyContent.setVisibility(0);
            this.recyclerView.setVisibility(8);
            return;
        }
        String curFaceIds = getCurFaceIds();
        if (curFaceIds != null) {
            mFaceManager.getClusterEvent(curFaceIds, this.figureInfoEx.figureId, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesEventActivity.AnonymousClass1 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        ArrayList<FaceEvent> arrayList = ((FaceEventList) obj2).thirdPartPlayUnits;
                        Iterator<FaceEvent> it = arrayList.iterator();
                        while (it.hasNext()) {
                            cki.O00000o("onSuccess_getFacesEvent", it.next().toString());
                        }
                        if (arrayList.size() > 0) {
                            String format = FigureFacesEventActivity.this.mTimeFormaterDay.format(Long.valueOf(arrayList.get(0).createTime));
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(new FaceEventItem(format, null));
                            Iterator<FaceEvent> it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                FaceEvent next = it2.next();
                                String format2 = FigureFacesEventActivity.this.mTimeFormaterDay.format(Long.valueOf(next.createTime));
                                if (!format2.equals(format)) {
                                    arrayList2.add(new FaceEventItem(format2, null));
                                    format = format2;
                                }
                                arrayList2.add(new FaceEventItem(FigureFacesEventActivity.this.mTimeFormaterMinute.format(Long.valueOf(next.createTime)), next));
                            }
                            Iterator it3 = arrayList2.iterator();
                            while (it3.hasNext()) {
                                cki.O00000o("faceEventItem", ((FaceEventItem) it3.next()).toString());
                            }
                            FigureFacesEventActivity.this.ivTitleBarMore.setEnabled(true);
                            if (FigureFacesEventActivity.this.mLastStart == 0) {
                                FigureFacesEventActivity.this.mAdapter.setData(arrayList2);
                            } else {
                                FigureFacesEventActivity.this.mAdapter.addData(arrayList2);
                            }
                            FigureFacesEventActivity figureFacesEventActivity = FigureFacesEventActivity.this;
                            figureFacesEventActivity.mLastStart = figureFacesEventActivity.mLastEnd;
                            if (FigureFacesEventActivity.this.getCurFaceIds() != null) {
                                FigureFacesEventActivity.this.getFaceEvt();
                            }
                        } else if (FigureFacesEventActivity.this.mAdapter.getItemCount() == 0) {
                            FigureFacesEventActivity.this.updateWhenEmpty();
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        FigureFacesEventActivity.this.emptyContent.setVisibility(0);
                        FigureFacesEventActivity.this.recyclerView.setVisibility(8);
                        gqg.O00000Oo("获取数据失败，请重试");
                    }
                }
            });
        } else {
            updateWhenEmpty();
        }
    }

    public void loadData() {
        if (mFaceManager != null) {
            mFaceManager.getFigureFaces(new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesEventActivity.AnonymousClass2 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        FigureFacesEventActivity.this.hideLoadDlg();
                        FigureFacesEventActivity.this.tvStatus.setVisibility(0);
                        FigureFacesEventActivity.this.tvStatus.setText(String.format(FigureFacesEventActivity.this.getString(R.string.figure_face_count_tips), Integer.valueOf(((FaceIdMetaResult) obj2).faceInfoMetas.length)));
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        FigureFacesEventActivity.this.hideLoadDlg();
                        FigureFacesEventActivity.this.tvStatus.setVisibility(8);
                    }
                }
            }, this.figureInfoEx.figureId);
            this.mLastStart = 0;
            this.mLastEnd = 0;
            getFaceEvt();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateWhenEmpty() {
        this.emptyContent.setVisibility(0);
        this.recyclerView.setVisibility(8);
        this.mAdapter.setShowReportError(false);
        this.ivTitleBarMore.setImageResource(R.drawable.camera_titlebar_error_report);
        this.ivTitleBarMore.setEnabled(false);
    }

    public void hideLoadDlg() {
        XQProgressDialog xQProgressDialog = this.mPulingDlg;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mPulingDlg.dismiss();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_edit_mark) {
            if (!TextUtils.isEmpty(this.figureInfoEx.figureId)) {
                Intent intent = new Intent(this, FigureFacesManager2Activity.class);
                intent.putExtra("figureInfo", this.figureInfoEx);
                startActivityForResult(intent, 1001);
            } else if (!TextUtils.isEmpty(this.figureInfoEx.coverFaceId)) {
                showAddFaceDialog(this.figureInfoEx.coverFaceId);
            } else {
                showAddFaceDialog(this.figureInfoEx.faceId);
            }
        } else if (view.getId() == R.id.select_delete) {
            deleteAlertDialog();
        } else if (view.getId() != R.id.title_bar_more) {
        } else {
            if (this.mAdapter.getShowReportError()) {
                hxi.O00000o.f952O000000o.O000000o("Face_Errors_ClickNum", new Object[0]);
                this.mAdapter.setShowReportError(false);
                this.ivTitleBarMore.setImageResource(R.drawable.camera_titlebar_error_report);
                return;
            }
            this.mAdapter.setShowReportError(true);
            this.ivTitleBarMore.setImageResource(R.drawable.camera_titlebar_report_finish);
        }
    }

    public void onBackPressed() {
        if (this.mAdapter.getShowReportError()) {
            this.mAdapter.setShowReportError(false);
            this.ivTitleBarMore.setImageResource(R.drawable.camera_titlebar_error_report);
            return;
        }
        if (this.hasManaged) {
            setResult(-1);
        }
        if (!handleBackPressed()) {
            if (this.edited) {
                setResult(-1);
            }
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public String getPageTitle() {
        return getString(R.string.lowpower_face_manager);
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
    public void onRecyclerClick(int i) {
        if (i >= 0 && i < this.mAdapter.mData.size()) {
            hxi.O00000o.f952O000000o.O000000o("Face_RecentVedio_ClickNum", new Object[0]);
            Intent intent = new Intent(getContext(), AlarmVideoPlayerActivity.class);
            FaceEvent faceEvent = this.mAdapter.mData.get(i).item;
            intent.putExtra("extra_device_did", mFaceManager.getDeviceId());
            intent.putExtra("fileId", faceEvent.fileId);
            intent.putExtra("isAlarm", false);
            intent.putExtra("createTime", faceEvent.createTime);
            intent.putExtra("offset", faceEvent.offset);
            intent.putExtra("position", i);
            intent.putExtra("startDuration", faceEvent.startDuration);
            intent.putExtra("skipPwd", true);
            if (!TextUtils.isEmpty(this.figureInfoEx.figureName)) {
                intent.putExtra("faceName", this.figureInfoEx.figureName);
            }
            startActivityForResult(intent, 1002);
        }
    }

    public void onRecyclerLongClick(int i) {
        enterSelectMode();
    }

    public void onAdapterDataChange() {
        if (1 == this.mAdapter.getItemCount()) {
            this.mAdapter.clear();
            updateWhenEmpty();
            return;
        }
        this.ivTitleBarMore.setEnabled(true);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        int intExtra;
        super.onActivityResult(i, i2, intent);
        if (i == 101 || i == 102) {
            if (i2 == -1) {
                mFaceManager.addFaceToFigure(intent.getStringExtra("faceId"), this.figureInfoEx.figureId, "", new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesEventActivity.AnonymousClass3 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!FigureFacesEventActivity.this.isFinishing()) {
                            FigureFacesEventActivity.this.loadData();
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!FigureFacesEventActivity.this.isFinishing()) {
                            if (i == 400305) {
                                gqg.O00000Oo((int) R.string.face_max_tips);
                            } else {
                                gqg.O00000Oo((int) R.string.action_fail);
                            }
                        }
                    }
                });
            }
        } else if (i != 1001) {
            if (i == 1002 && i2 == -1 && intent != null && (intExtra = intent.getIntExtra("position", -1)) >= 0) {
                this.mAdapter.mData.remove(intExtra);
                this.mAdapter.notifyDataSetChanged();
            }
        } else if (i2 != -1) {
        } else {
            if (intent == null) {
                setResult(-1);
                finish();
                return;
            }
            this.hasManaged = true;
            if (intent.hasExtra("renamedFigureName")) {
                this.tvFigureName.setText(intent.getStringExtra("renamedFigureName"));
            }
        }
    }

    private void showAddFaceDialog(final String str) {
        if (mFaceManager != null) {
            FaceUtils.processMarkFaces(this, str, mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesEventActivity.AnonymousClass4 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        String str = str;
                        if (str.indexOf(",") >= 0) {
                            String str2 = str;
                            str = str2.substring(0, str2.indexOf(","));
                        }
                        FaceManagerBaseActivity.mFaceManager.getFigureByMarkedFace(str, new FaceManager.IFaceCallback() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesEventActivity.AnonymousClass4.AnonymousClass1 */

                            public void onFailure(int i, String str) {
                            }

                            public void onSuccess(Object obj, Object obj2) {
                                if (!FigureFacesEventActivity.this.isFinishing()) {
                                    FigureInfo figureInfo = (FigureInfo) obj2;
                                    FigureFacesEventActivity.this.figureInfoEx.figureId = figureInfo.figureId;
                                    FigureFacesEventActivity.this.figureInfoEx.figureName = figureInfo.figureName;
                                    FigureFacesEventActivity.this.tvFigureName.setText(figureInfo.figureName);
                                    if (!TextUtils.isEmpty(FigureFacesEventActivity.this.figureInfoEx.figureId)) {
                                        FigureFacesEventActivity.this.tvEditMark.setText((int) R.string.string_face_manager);
                                    } else {
                                        FigureFacesEventActivity.this.tvEditMark.setText((int) R.string.add_notes);
                                    }
                                    FigureFacesEventActivity.this.hasManaged = true;
                                    FigureFacesEventActivity.this.mAdapter.setName(FigureFacesEventActivity.this.figureInfoEx.figureName);
                                    FigureFacesEventActivity.this.mAdapter.notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FigureFacesEventActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }
}
