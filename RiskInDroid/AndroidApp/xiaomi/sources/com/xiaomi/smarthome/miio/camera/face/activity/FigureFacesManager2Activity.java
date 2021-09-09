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
import com.xiaomi.smarthome.miio.camera.face.model.FaceInfoEx;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import com.xiaomi.smarthome.miio.camera.face.widget.FaceRenameDialog;
import java.util.ArrayList;

public class FigureFacesManager2Activity extends FaceSelectActivityNew implements View.OnClickListener, FigureFaceAdapter.ClickCallBack {
    public static final String TAG = "FigureFacesManager2Activity";
    public boolean edited = false;
    public ImageView figureCoverFace;
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
        setContentView((int) R.layout.activity_figure_face_manager2);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        this.figureInfoEx = (FaceInfoEx) getIntent().getExtras().get("figureInfo");
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
        this.figureNameTV.setText(this.figureInfoEx.figureName);
        if (cnx.O000000o().O00000Oo()) {
            updateCoverFace(this.figureCoverFace);
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
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass1 */

            /*  JADX ERROR: Method load error
                jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceAdapter.notifyDataSetChanged():void in method: com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:312)
                	at jadx.core.ProcessClass.process(ProcessClass.java:36)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceAdapter.notifyDataSetChanged():void
                	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
                	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:540)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
                	... 6 more
                */
            public void onSuccess(java.lang.Object r1, java.lang.Object r2) {
                /*
                    r3 = this;
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r4 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    r4.hideLoadDlg()
                    com.xiaomi.smarthome.miio.camera.face.model.FaceIdMetaResult r5 = (com.xiaomi.smarthome.miio.camera.face.model.FaceIdMetaResult) r5
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r4 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceAdapter r4 = r4.mAdapter
                    java.util.ArrayList r0 = new java.util.ArrayList
                    com.xiaomi.smarthome.miio.camera.face.model.FaceInfo[] r1 = r5.faceInfoMetas
                    java.util.List r1 = java.util.Arrays.asList(r1)
                    r0.<init>(r1)
                    r4.setData(r0)
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r4 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    android.widget.TextView r4 = r4.tv_statues
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r0 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    r1 = 2132674633(0x7f1e0849, float:2.1006104E38)
                    java.lang.String r0 = r0.getString(r1)
                    r1 = 1
                    java.lang.Object[] r1 = new java.lang.Object[r1]
                    com.xiaomi.smarthome.miio.camera.face.model.FaceInfo[] r5 = r5.faceInfoMetas
                    int r5 = r5.length
                    java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                    r2 = 0
                    r1[r2] = r5
                    java.lang.String r5 = java.lang.String.format(r0, r1)
                    r4.setText(r5)
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r4 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    com.xiaomi.smarthome.miio.camera.face.adapter.FigureFaceAdapter r4 = r4.mAdapter
                    r4.notifyDataSetChanged()
                    com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity r4 = com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.this
                    r4.refreshSelectTitle()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass1.onSuccess(java.lang.Object, java.lang.Object):void");
            }

            public void onFailure(int i, String str) {
                FigureFacesManager2Activity.this.hideLoadDlg();
                FigureFacesManager2Activity.this.mAdapter.setData(new ArrayList());
            }
        }, this.figureInfoEx.figureId);
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
        final FaceRenameDialog faceRenameDialog = new FaceRenameDialog(this, this.figureInfoEx.figureName);
        faceRenameDialog.setOnNameInputListener(new FaceRenameDialog.OnNameInputListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass2 */

            public void onNameInput(final String str) {
                FaceManagerBaseActivity.mFaceManager.modifyFigure(FigureFacesManager2Activity.this.figureInfoEx.figureId, str, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass2.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        gqg.O00000Oo((int) R.string.action_success);
                        FigureFacesManager2Activity.this.figureInfoEx.figureName = str;
                        FigureFacesManager2Activity.this.figureInfoEx.figureInfo = str;
                        FigureFacesManager2Activity.this.figureNameTV.setText(FigureFacesManager2Activity.this.figureInfoEx.figureName);
                        FigureFacesManager2Activity.this.edited = true;
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
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass3 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass4 */

                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    FigureFacesManager2Activity.this.showDeleteDlg();
                    final boolean z = true;
                    if (FigureFacesManager2Activity.this.mAdapter.getSelectedFaceIds().size() != FigureFacesManager2Activity.this.mAdapter.mData.size() - 1) {
                        z = false;
                    }
                    FaceManagerBaseActivity.mFaceManager.deleteFacesFromFigure(FigureFacesManager2Activity.this.mAdapter.getSelectedFaceIds().toArray(), FigureFacesManager2Activity.this.figureInfoEx.figureId, new FaceManager.IFaceCallback() {
                        /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass4.AnonymousClass1 */

                        public void onSuccess(Object obj, Object obj2) {
                            if (z) {
                                gqg.O00000Oo((int) R.string.delete_sucess);
                                FigureFacesManager2Activity.this.setResult(-1);
                                FigureFacesManager2Activity.this.finish();
                                return;
                            }
                            FigureFacesManager2Activity.this.hideDeleteDlg();
                            FigureFacesManager2Activity.this.showLoadDlg();
                            FigureFacesManager2Activity.this.loadData();
                            FigureFacesManager2Activity.this.updateCoverFace(FigureFacesManager2Activity.this.figureCoverFace);
                            FigureFacesManager2Activity.this.edited = true;
                            gqg.O00000Oo((int) R.string.delete_sucess);
                        }

                        public void onFailure(int i, String str) {
                            FigureFacesManager2Activity.this.hideDeleteDlg();
                            gqg.O00000Oo((int) R.string.delete_failed);
                        }
                    });
                    FigureFacesManager2Activity.this.exitSelectMode();
                }
            });
            builder.O00000oo();
        }
    }

    private void deleteAllDialog() {
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O00000Oo(getString(R.string.face_delete_all_faces_message));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FigureFacesManager2Activity.this.showDeleteDlg();
                FaceManagerBaseActivity.mFaceManager.deleteFigure(FigureFacesManager2Activity.this.figureInfoEx.figureId, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass6.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        FigureFacesManager2Activity.this.hideDeleteDlg();
                        FigureFacesManager2Activity.this.setResult(-1);
                        FigureFacesManager2Activity.this.finish();
                    }

                    public void onFailure(int i, String str) {
                        FigureFacesManager2Activity.this.hideDeleteDlg();
                        gqg.O00000Oo((int) R.string.delete_failed);
                    }
                });
                FigureFacesManager2Activity.this.exitSelectMode();
            }
        });
        builder.O00000oo();
    }

    public void onBackPressed() {
        if (!handleBackPressed()) {
            if (this.edited) {
                Intent intent = new Intent();
                intent.putExtra("renamedFigureName", this.figureInfoEx.figureName);
                setResult(-1, intent);
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
            mFaceManager.addFaceToFigure(intent.getStringExtra("faceId"), this.figureInfoEx.figureId, "", new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FigureFacesManager2Activity.AnonymousClass7 */

                public void onSuccess(Object obj, Object obj2) {
                    FigureFacesManager2Activity.this.loadData();
                    FigureFacesManager2Activity figureFacesManager2Activity = FigureFacesManager2Activity.this;
                    figureFacesManager2Activity.updateCoverFace(figureFacesManager2Activity.figureCoverFace);
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
