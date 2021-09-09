package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.cnx;
import _m_j.gqg;
import _m_j.gwg;
import _m_j.hd;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FaceIdMetaResult;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.FaceRenameDialog;
import java.util.ArrayList;
import java.util.Arrays;

public class FigureFacesManagerActivity extends FaceSelectActivityNew implements View.OnClickListener, FigureFaceAdapter.ClickCallBack {
    public static final String TAG = "FigureFacesManagerActivity";
    public boolean edited = false;
    private ImageView figureCoverFace;
    public FigureInfo figureInfo;
    public TextView figureNameTV;
    public FigureFaceAdapter mAdapter;
    public boolean mIsMultiSelectMode = false;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    private RecyclerView recyclerView;
    private TextView tvTitle;
    public TextView tv_statues;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_figure_face_manager);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        this.figureInfo = (FigureInfo) getIntent().getExtras().get("figureInfo");
        initSelectView();
        iniView();
        loadData();
    }

    private void iniView() {
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.tvTitle = (TextView) findViewById(R.id.title_bar_title);
        this.tvTitle.setText(getResources().getString(R.string.lowpower_face_manager));
        this.tv_statues = (TextView) findViewById(R.id.tv_statues);
        findViewById(R.id.select_delete).setOnClickListener(this);
        findViewById(R.id.tv_edit_mark).setOnClickListener(this);
        this.figureCoverFace = (ImageView) findViewById(R.id.figure_cover_face);
        this.figureNameTV = (TextView) findViewById(R.id.figure_name_tv);
        this.figureNameTV.setText(this.figureInfo.figureName);
        if (cnx.O000000o().O00000Oo()) {
            cnx.O000000o().O000000o(mFaceManager.getFaceImg(this.figureInfo.coverFaceId), this.figureCoverFace);
        }
        this.recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.mAdapter = new FigureFaceAdapter(this, this, mFaceManager);
        this.mAdapter.setHasStableIds(true);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        ((hd) this.recyclerView.getItemAnimator()).O0000o00 = false;
        this.recyclerView.setAnimation(null);
        this.recyclerView.setAdapter(this.mAdapter);
    }

    public void loadData() {
        mFaceManager.getFigureFaces(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass1 */

            public void onSuccess(Object obj, Object obj2) {
                FigureFacesManagerActivity.this.hideLoadDlg();
                FaceIdMetaResult faceIdMetaResult = (FaceIdMetaResult) obj2;
                FigureFacesManagerActivity.this.mAdapter.setData(new ArrayList(Arrays.asList(faceIdMetaResult.faceInfoMetas)));
                FigureFacesManagerActivity.this.tv_statues.setText(String.format(FigureFacesManagerActivity.this.getString(R.string.figure_face_count_tips), Integer.valueOf(faceIdMetaResult.faceInfoMetas.length)));
                FigureFacesManagerActivity.this.mAdapter.notifyDataSetChanged();
                FigureFacesManagerActivity.this.refreshSelectTitle();
            }

            public void onFailure(int i, String str) {
                FigureFacesManagerActivity.this.hideLoadDlg();
                FigureFacesManagerActivity.this.mAdapter.setData(new ArrayList());
            }
        }, this.figureInfo.figureId);
    }

    public void showLoadDlg() {
        if (this.mPulingDlg == null) {
            this.mPulingDlg = new XQProgressDialog(this);
            this.mPulingDlg.setMessage(getResources().getString(R.string.camera_loading));
            this.mPulingDlg.setCancelable(false);
        }
        this.mPulingDlg.show();
    }

    public void hideLoadDlg() {
        XQProgressDialog xQProgressDialog = this.mPulingDlg;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mPulingDlg.dismiss();
        }
    }

    public void showDeleteDlg() {
        if (this.mProgressDlg == null) {
            this.mProgressDlg = new XQProgressDialog(this);
            this.mProgressDlg.setCancelable(false);
            this.mProgressDlg.setMessage(getResources().getString(R.string.deleting));
        }
        this.mProgressDlg.show();
    }

    public void hideDeleteDlg() {
        XQProgressDialog xQProgressDialog = this.mProgressDlg;
        if (xQProgressDialog != null && xQProgressDialog.isShowing()) {
            this.mProgressDlg.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public int getSelectCount() {
        return this.mAdapter.getSelectedCount();
    }

    /* access modifiers changed from: protected */
    public int getDataCount() {
        return this.mAdapter.getItemCount();
    }

    /* access modifiers changed from: protected */
    public boolean isAllSelected() {
        return this.mAdapter.getSelectedCount() == this.mAdapter.getItemCount() - 1;
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.tv_edit_mark) {
            showRenameDialog();
        } else if (view.getId() == R.id.select_delete) {
            deleteAlertDialog();
        }
    }

    private void showRenameDialog() {
        final FaceRenameDialog faceRenameDialog = new FaceRenameDialog(this, this.figureInfo.figureName);
        faceRenameDialog.setOnNameInputListener(new FaceRenameDialog.OnNameInputListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass2 */

            public void onNameInput(final String str) {
                FaceManagerBaseActivity.mFaceManager.modifyFigure(FigureFacesManagerActivity.this.figureInfo.figureId, str, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        gqg.O00000Oo((int) R.string.action_success);
                        FigureFacesManagerActivity.this.figureInfo.figureName = str;
                        FigureFacesManagerActivity.this.figureInfo.figureInfo = str;
                        FigureFacesManagerActivity.this.figureNameTV.setText(FigureFacesManagerActivity.this.figureInfo.figureName);
                        FigureFacesManagerActivity.this.edited = true;
                        faceRenameDialog.dismiss();
                    }

                    public void onFailure(int i, String str) {
                        if (i != 400303) {
                            gqg.O00000Oo((int) R.string.action_fail);
                        } else {
                            faceRenameDialog.showError();
                        }
                    }
                });
            }
        });
        faceRenameDialog.show();
    }

    private void deleteAlertDialog() {
        if (this.mAdapter.getSelectedCount() == 0) {
            gqg.O00000Oo((int) R.string.bottom_action_tip);
        } else if (isAllSelected()) {
            deleteAllDialog();
        } else {
            MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
            builder.O00000Oo(getString(R.string.face_delete_face_dialog_title));
            builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    FigureFacesManagerActivity.this.showDeleteDlg();
                    final boolean z = true;
                    if (FigureFacesManagerActivity.this.mAdapter.getSelectedFaceIds().size() != FigureFacesManagerActivity.this.mAdapter.mData.size() - 1) {
                        z = false;
                    }
                    FaceManagerBaseActivity.mFaceManager.deleteFacesFromFigure(FigureFacesManagerActivity.this.mAdapter.getSelectedFaceIds().toArray(), FigureFacesManagerActivity.this.figureInfo.figureId, new FaceManager.IFaceCallback() {
                        /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass4.AnonymousClass1 */

                        public void onSuccess(Object obj, Object obj2) {
                            if (z) {
                                gqg.O00000Oo((int) R.string.delete_sucess);
                                FigureFacesManagerActivity.this.setResult(-1);
                                FigureFacesManagerActivity.this.finish();
                                return;
                            }
                            FigureFacesManagerActivity.this.hideDeleteDlg();
                            FigureFacesManagerActivity.this.showLoadDlg();
                            FigureFacesManagerActivity.this.loadData();
                            FigureFacesManagerActivity.this.edited = true;
                            gqg.O00000Oo((int) R.string.delete_sucess);
                        }

                        public void onFailure(int i, String str) {
                            FigureFacesManagerActivity.this.hideDeleteDlg();
                            gqg.O00000Oo((int) R.string.delete_failed);
                        }
                    });
                    FigureFacesManagerActivity.this.exitSelectMode();
                }
            });
            builder.O00000oo();
        }
    }

    private void deleteAllDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(getString(R.string.face_delete_all_faces_message));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FigureFacesManagerActivity.this.showDeleteDlg();
                FaceManagerBaseActivity.mFaceManager.deleteFigure(FigureFacesManagerActivity.this.figureInfo.figureId, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass6.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        FigureFacesManagerActivity.this.hideDeleteDlg();
                        FigureFacesManagerActivity.this.setResult(-1);
                        FigureFacesManagerActivity.this.finish();
                    }

                    public void onFailure(int i, String str) {
                        FigureFacesManagerActivity.this.hideDeleteDlg();
                        gqg.O00000Oo((int) R.string.delete_failed);
                    }
                });
                FigureFacesManagerActivity.this.exitSelectMode();
            }
        });
        builder.O00000oo();
    }

    public void onBackPressed() {
        if (!handleBackPressed()) {
            if (this.edited) {
                setResult(-1);
            }
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onExitSelectMode() {
        this.mAdapter.setSelectedMod(false);
    }

    /* access modifiers changed from: protected */
    public void onEnterSelectMode() {
        FigureFaceAdapter figureFaceAdapter = this.mAdapter;
        if (figureFaceAdapter != null) {
            figureFaceAdapter.setSelectedMod(true);
        }
    }

    /* access modifiers changed from: protected */
    public void onSelectAll() {
        this.mAdapter.selectAll();
    }

    /* access modifiers changed from: protected */
    public void onUnSelectAll() {
        this.mAdapter.unSelectAll();
    }

    /* access modifiers changed from: protected */
    public String getPageTitle() {
        return getString(R.string.lowpower_face_manager);
    }

    public void onRecyclerClick(int i) {
        if (i >= this.mAdapter.mData.size() - 1) {
            exitSelectMode();
            FaceUtils.showSelectDialog(this, mFaceManager.getDeviceId());
            return;
        }
        refreshSelectTitle();
    }

    public void onRecyclerLongClick(int i) {
        enterSelectMode();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if ((i == 101 || i == 102) && i2 == -1) {
            mFaceManager.addFaceToFigure(intent.getStringExtra("faceId"), this.figureInfo.figureId, "", new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManagerActivity.AnonymousClass7 */

                public void onSuccess(Object obj, Object obj2) {
                    FigureFacesManagerActivity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (i == 400305) {
                        gqg.O00000Oo((int) R.string.face_max_tips);
                    } else {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }
}
