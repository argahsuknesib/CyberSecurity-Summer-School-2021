package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.chp;
import _m_j.chr;
import _m_j.civ;
import _m_j.cnx;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hd;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecyclerAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.model.UnmarkedFaceInfo;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceManagerActivity extends FaceSelectActivity implements View.OnClickListener, FaceRecyclerAdapter.ClickCallBack {
    public static final String TAG = "FaceManagerActivity";
    public ImageView ivUnmarkedFace1;
    public ImageView ivUnmarkedFace2;
    public ImageView ivUnmarkedFace3;
    private LinearLayout layout_select_bottom;
    public LinearLayout llUnmarkedFaces;
    public FaceRecyclerAdapter mAdapter;
    public boolean mIsMultiSelectMode = false;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    public boolean mSelectAllShowed = true;
    public RecyclerView recyclerView;
    private TextView select_delete;
    private ImageView title_bar_return;
    public TextView tvFaceMarked;
    private TextView tvFaceUnmarked;
    public TextView tvNoMarkedFace;
    public TextView tvToMore;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_manager);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        initSelectView();
        iniView();
        loadData();
        chr.O0000o00();
    }

    private void iniView() {
        this.tvNoMarkedFace = (TextView) findViewById(R.id.tv_no_unmarked_face);
        this.ivUnmarkedFace1 = (ImageView) findViewById(R.id.iv_unmarked_face1);
        this.ivUnmarkedFace2 = (ImageView) findViewById(R.id.iv_unmarked_face2);
        this.ivUnmarkedFace3 = (ImageView) findViewById(R.id.iv_unmarked_face3);
        this.llUnmarkedFaces = (LinearLayout) findViewById(R.id.ll_unmarked_faces);
        this.layout_select_bottom = (LinearLayout) findViewById(R.id.layout_select_bottom);
        this.select_delete = (TextView) findViewById(R.id.select_delete);
        this.select_delete.setOnClickListener(this);
        this.tvToMore = (TextView) findViewById(R.id.tv_to_more);
        this.tvToMore.setOnClickListener(this);
        this.tvFaceMarked = (TextView) findViewById(R.id.tv_face_marked);
        this.tvFaceUnmarked = (TextView) findViewById(R.id.tv_face_unmarked);
        this.tvFaceMarked.setText(String.format(getString(R.string.face_marked), 0));
        ((TextView) findViewById(R.id.title_bar_title)).setText(getResources().getString(R.string.lowpower_face_manager));
        this.recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        this.mAdapter = new FaceRecyclerAdapter(this, this, mFaceManager);
        this.mAdapter.setHasStableIds(true);
        this.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        ((hd) this.recyclerView.getItemAnimator()).O0000o00 = false;
        this.recyclerView.setAnimation(null);
        this.recyclerView.setAdapter(this.mAdapter);
        this.mEditBtn.setImageResource(R.drawable.icon_edit_state);
    }

    public void loadData() {
        if (mFaceManager != null) {
            mFaceManager.getFigures(new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass1 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        FaceManagerActivity.this.hideLoadDlg();
                        FigureInfos figureInfos = (FigureInfos) obj2;
                        String str = FaceManagerActivity.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(figureInfos.figureInfos.size());
                        civ.O000000o(str, sb.toString());
                        FaceManagerActivity.this.mAdapter.setData(figureInfos.figureInfos);
                        if (figureInfos.figureInfos.size() >= 0) {
                            FaceManagerActivity.this.tvFaceMarked.setText(String.format(FaceManagerActivity.this.getString(R.string.face_marked), Integer.valueOf(figureInfos.figureInfos.size())));
                        } else {
                            FaceManagerActivity.this.mEditBtn.setVisibility(8);
                        }
                        FaceManagerActivity.this.mAdapter.notifyDataSetChanged();
                        FaceManagerActivity.this.refreshSelectTitle();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        FaceManagerActivity.this.hideLoadDlg();
                        String str2 = FaceManagerActivity.TAG;
                        civ.O00000o0(str2, i + "--" + str);
                    }
                }
            });
            mFaceManager.getUnmarkFaces(50, false, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass2 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList.size() > 0) {
                            UnmarkedFaceInfo unmarkedFaceInfo = (UnmarkedFaceInfo) arrayList.get(0);
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceManagerBaseActivity.mFaceManager.getFaceImg(unmarkedFaceInfo.faceId), FaceManagerActivity.this.ivUnmarkedFace1);
                            }
                            FaceManagerActivity.this.tvNoMarkedFace.setVisibility(8);
                            FaceManagerActivity.this.llUnmarkedFaces.setVisibility(0);
                            FaceManagerActivity.this.ivUnmarkedFace1.setTag(unmarkedFaceInfo.faceId);
                            FaceManagerActivity.this.ivUnmarkedFace1.setVisibility(0);
                            FaceManagerActivity.this.ivUnmarkedFace1.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$kg6dZ9cGxeziXfdiD3PM79Upevg */

                                public final void onClick(View view) {
                                    FaceManagerActivity.this.onClick(view);
                                }
                            });
                        } else {
                            FaceManagerActivity.this.tvNoMarkedFace.setVisibility(0);
                            FaceManagerActivity.this.llUnmarkedFaces.setVisibility(8);
                            FaceManagerActivity.this.ivUnmarkedFace1.setVisibility(8);
                        }
                        if (arrayList.size() > 1) {
                            UnmarkedFaceInfo unmarkedFaceInfo2 = (UnmarkedFaceInfo) arrayList.get(1);
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceManagerBaseActivity.mFaceManager.getFaceImg(unmarkedFaceInfo2.faceId), FaceManagerActivity.this.ivUnmarkedFace2);
                            }
                            FaceManagerActivity.this.ivUnmarkedFace2.setVisibility(0);
                            FaceManagerActivity.this.ivUnmarkedFace2.setTag(unmarkedFaceInfo2.faceId);
                            FaceManagerActivity.this.ivUnmarkedFace2.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$kg6dZ9cGxeziXfdiD3PM79Upevg */

                                public final void onClick(View view) {
                                    FaceManagerActivity.this.onClick(view);
                                }
                            });
                        } else {
                            FaceManagerActivity.this.ivUnmarkedFace2.setVisibility(8);
                        }
                        if (arrayList.size() > 2) {
                            UnmarkedFaceInfo unmarkedFaceInfo3 = (UnmarkedFaceInfo) arrayList.get(2);
                            if (cnx.O000000o().O00000Oo()) {
                                cnx.O000000o().O000000o(FaceManagerBaseActivity.mFaceManager.getFaceImg(unmarkedFaceInfo3.faceId), FaceManagerActivity.this.ivUnmarkedFace3);
                            }
                            FaceManagerActivity.this.ivUnmarkedFace3.setVisibility(0);
                            FaceManagerActivity.this.ivUnmarkedFace3.setTag(unmarkedFaceInfo3.faceId);
                            FaceManagerActivity.this.ivUnmarkedFace3.setOnClickListener(new View.OnClickListener() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$kg6dZ9cGxeziXfdiD3PM79Upevg */

                                public final void onClick(View view) {
                                    FaceManagerActivity.this.onClick(view);
                                }
                            });
                            FaceManagerActivity.this.tvToMore.setVisibility(0);
                            return;
                        }
                        FaceManagerActivity.this.tvToMore.setVisibility(8);
                        FaceManagerActivity.this.ivUnmarkedFace3.setVisibility(8);
                    }
                }
            });
        }
    }

    private void showAddFaceDialog(String str) {
        if (mFaceManager != null) {
            FaceUtils.processMarkFace(this, str, mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass3 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        FaceManagerActivity.this.recyclerView.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$FaceManagerActivity$3$ZVNMtNKu7cOwlolYbXMhzTdRrbU */

                            public final void run() {
                                FaceManagerActivity.AnonymousClass3.this.lambda$onSuccess$0$FaceManagerActivity$3();
                            }
                        }, 1000);
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$FaceManagerActivity$3() {
                    FaceManagerActivity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            setMultiSelectMode(false);
        } else {
            super.onBackPressed();
        }
    }

    private void hightLightImageView(ImageView imageView) {
        imageView.setColorFilter(Color.parseColor("#32BAC0"));
    }

    private void resetImageView(ImageView imageView) {
        imageView.clearColorFilter();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.select_delete) {
            deleteAlertDialog();
        } else if (view.getId() == R.id.ivSelectAllCancel) {
            if (this.mIsMultiSelectMode) {
                setMultiSelectMode(false);
            }
        } else if (view.getId() == R.id.title_bar_more) {
            if (mFaceManager != null) {
                if (mFaceManager.getDevice().isReadOnlyShared()) {
                    gqg.O00000Oo((int) R.string.auth_fail_read_only);
                } else if (!this.mAdapter.getSelectedMode()) {
                    setMultiSelectMode(true);
                } else if (this.mAdapter.isSelectAll()) {
                    this.mAdapter.unSelectAll();
                    resetImageView(this.mEditBtn);
                } else {
                    this.mAdapter.selectAll();
                    hightLightImageView(this.mEditBtn);
                }
            }
        } else if (view.getId() == R.id.ivSelectAll) {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.icon_selected);
                this.mAdapter.selectAll();
                refreshSelectTitle();
                return;
            }
            this.mSelectAllShowed = true;
            this.mSelectAllBtn.setImageResource(R.drawable.icon_unselected);
            this.mAdapter.unSelectAll();
            refreshSelectTitle();
        } else if (view.getId() == R.id.tv_to_more) {
            startActivityForResult(new Intent(this, FaceUnmarkedListActivity.class), 1);
        } else if (view.getId() == R.id.iv_unmarked_face1 || view.getId() == R.id.iv_unmarked_face2 || view.getId() == R.id.iv_unmarked_face3) {
            showAddFaceDialog((String) view.getTag());
        }
    }

    private void deleteAlertDialog() {
        if (this.mAdapter.getSelectedCount() == 0) {
            gqg.O00000Oo((int) R.string.bottom_action_tip);
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o(getString(R.string.face_delete_dialog_title));
        builder.O00000Oo(getString(R.string.face_delete_dialog_message));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FaceManagerActivity.this.showDeleteDlg();
                FaceManagerBaseActivity.mFaceManager.deleteFigures(new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass5.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!FaceManagerActivity.this.isFinishing()) {
                            FaceManagerActivity.this.hideDeleteDlg();
                            FaceManagerActivity.this.showLoadDlg();
                            FaceManagerActivity.this.loadData();
                            gqg.O00000Oo((int) R.string.delete_sucess);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!FaceManagerActivity.this.isFinishing()) {
                            FaceManagerActivity.this.hideDeleteDlg();
                            gqg.O00000Oo((int) R.string.delete_failed);
                        }
                    }
                }, FaceManagerActivity.this.mAdapter.getSelectedFigureIds().toArray());
                FaceManagerActivity.this.setMultiSelectMode(false);
            }
        });
        builder.O00000oo();
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
        return this.mAdapter.mData.size();
    }

    public void onRecyclerClick(int i) {
        if (i < this.mAdapter.mData.size() - 1) {
            if (!this.mIsMultiSelectMode) {
                Intent intent = new Intent(this, FigureFacesManagerActivity.class);
                intent.putExtra("figureInfo", this.mAdapter.mData.get(i));
                startActivityForResult(intent, 0);
            } else if (this.mAdapter.getSelectedMode() && this.mAdapter.isSelectAll()) {
                hightLightImageView(this.mEditBtn);
            }
            refreshSelectTitle();
        } else if (this.mAdapter.mData.size() >= 11) {
            gqg.O00000Oo((int) R.string.figure_max_tips);
        } else {
            setMultiSelectMode(false);
            FaceUtils.showSelectDialog(this, mFaceManager.getDeviceId());
        }
    }

    public void onRecyclerLongClick(int i) {
        if (!this.mIsMultiSelectMode) {
            setMultiSelectMode(true);
        }
        refreshSelectTitle();
    }

    public void setMultiSelectMode(boolean z) {
        this.mIsMultiSelectMode = z;
        if (z) {
            this.layout_select_bottom.setVisibility(0);
            this.mEditBtn.setImageResource(R.drawable.mj_webp_titlebar_all_select_pres);
        } else {
            this.layout_select_bottom.setVisibility(8);
            this.mEditBtn.setImageResource(R.drawable.icon_edit_state);
            resetImageView(this.mEditBtn);
        }
        this.mAdapter.setSelectedMod(z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 || i == 1) {
            if (i2 == -1) {
                showLoadDlg();
                loadData();
            }
        } else if ((i == 101 || i == 102) && i2 == -1) {
            FaceUtils.processMarkFace(getContext(), intent.getStringExtra("faceId"), mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass6 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        FaceManagerActivity.this.recyclerView.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$FaceManagerActivity$6$GwyRtVMx6ur0RLEAfUdp9wjKJc */

                            public final void run() {
                                FaceManagerActivity.AnonymousClass6.this.lambda$onSuccess$0$FaceManagerActivity$6();
                            }
                        }, 1000);
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$FaceManagerActivity$6() {
                    FaceManagerActivity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }

    private void uploadFileAndMarkFace(String str) {
        gsy.O00000Oo(TAG, "uploadFileAndMarkFace ".concat(String.valueOf(str)));
        mFaceManager.uploadImageFile(this, str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass7 */

            public void onSuccess(Object obj, Object obj2) {
                if (!FaceManagerActivity.this.isFinishing()) {
                    try {
                        FaceUtils.processMarkFace(FaceManagerActivity.this.getContext(), ((JSONObject) ((JSONObject) obj).getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId"), FaceManagerBaseActivity.mFaceManager, new FaceManager.IFaceCallback() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass7.AnonymousClass1 */

                            public void onSuccess(Object obj, Object obj2) {
                                if (!FaceManagerActivity.this.isFinishing()) {
                                    gqg.O00000Oo((int) R.string.action_success);
                                    FaceManagerActivity.this.recyclerView.postDelayed(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE  
                                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0015: IGET  (r3v7 androidx.recyclerview.widget.RecyclerView) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity : 0x0013: IGET  (r3v6 com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7 : 0x0011: IGET  (r3v5 com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7$1 A[THIS]) com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.7.1.this$1 com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7)
                                         com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.7.this$0 com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity)
                                         com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.recyclerView androidx.recyclerview.widget.RecyclerView)
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98 : 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98.<init>(com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7$1):void type: CONSTRUCTOR)
                                          (1000 long)
                                         type: VIRTUAL call: androidx.recyclerview.widget.RecyclerView.postDelayed(java.lang.Runnable, long):boolean in method: com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.7.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:318)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:678)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:608)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:215)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:208)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:337)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:290)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:259)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                                        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                                        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                                        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:255)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:246)
                                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:226)
                                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:115)
                                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:81)
                                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
                                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98.<init>(com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.7.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 112 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 118 more
                                        */
                                    /*
                                        this = this;
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7 r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass7.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.this
                                        boolean r3 = r3.isFinishing()
                                        if (r3 == 0) goto L_0x000b
                                        return
                                    L_0x000b:
                                        r3 = 2132672708(0x7f1e00c4, float:2.10022E38)
                                        _m_j.gqg.O00000Oo(r3)
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity$7 r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass7.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.this
                                        androidx.recyclerview.widget.RecyclerView r3 = r3.recyclerView
                                        com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98 r4 = new com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManagerActivity$7$1$rzMGKKVklNfM5L-49aND1WH2G98
                                        r4.<init>(r2)
                                        r0 = 1000(0x3e8, double:4.94E-321)
                                        r3.postDelayed(r4, r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.camera.face.activity.FaceManagerActivity.AnonymousClass7.AnonymousClass1.onSuccess(java.lang.Object, java.lang.Object):void");
                                }

                                public /* synthetic */ void lambda$onSuccess$0$FaceManagerActivity$7$1() {
                                    FaceManagerActivity.this.loadData();
                                }

                                public void onFailure(int i, String str) {
                                    if (!FaceManagerActivity.this.isFinishing()) {
                                        gqg.O00000Oo((int) R.string.action_fail);
                                    }
                                }
                            });
                        } catch (JSONException e) {
                            gqg.O00000Oo((int) R.string.action_fail);
                            e.printStackTrace();
                        }
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }

        public void onDestroy() {
            super.onDestroy();
            FaceRecyclerAdapter faceRecyclerAdapter = this.mAdapter;
            if (faceRecyclerAdapter != null) {
                faceRecyclerAdapter.destroyDisplayImageOptions();
            }
            chr.O0000o0();
        }

        class ItemDecoration extends RecyclerView.O0000Oo {
            private int space;

            public ItemDecoration() {
                this.space = 0;
                this.space = (int) (chp.O00000o0 * 2.0f);
            }

            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                if (recyclerView.getChildAdapterPosition(view) == FaceManagerActivity.this.mAdapter.getItemCount() - 1) {
                    rect.bottom = 50;
                }
            }
        }
    }
