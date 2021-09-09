package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.chp;
import _m_j.chr;
import _m_j.civ;
import _m_j.gqg;
import _m_j.gsy;
import _m_j.gwg;
import _m_j.hd;
import _m_j.hxi;
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
import com.xiaomi.smarthome.miio.camera.face.ClickCallback;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecycler3Adapter;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class MarkedFaceManagerActivity extends FaceSelectActivity implements View.OnClickListener, ClickCallback {
    public static final String TAG = "MarkedFaceManagerActivity";
    private LinearLayout layout_select_bottom;
    public FaceRecycler3Adapter mMarkedAdapter;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    public boolean mSelectAllShowed = true;
    public RecyclerView recyclerViewMarked;
    private TextView select_delete;
    private ImageView title_bar_return;
    private TextView tvNoMarkedFace;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_marked_face_manager);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        initSelectView();
        iniView();
        loadData();
        chr.O0000o00();
    }

    private void iniView() {
        this.layout_select_bottom = (LinearLayout) findViewById(R.id.layout_select_bottom);
        this.select_delete = (TextView) findViewById(R.id.select_delete);
        this.select_delete.setOnClickListener(this);
        ((TextView) findViewById(R.id.title_bar_title)).setText(getResources().getString(R.string.lowpower_face_manager));
        this.recyclerViewMarked = (RecyclerView) findViewById(R.id.recycle_view_marked);
        this.mMarkedAdapter = new FaceRecycler3Adapter(this, this, mFaceManager);
        this.mMarkedAdapter.setHasStableIds(true);
        this.recyclerViewMarked.setLayoutManager(new GridLayoutManager(this, 3));
        ((hd) this.recyclerViewMarked.getItemAnimator()).O0000o00 = false;
        this.recyclerViewMarked.setAnimation(null);
        this.recyclerViewMarked.setAdapter(this.mMarkedAdapter);
        this.mEditBtn.setImageResource(R.drawable.icon_edit_state);
    }

    public void loadData() {
        if (mFaceManager != null) {
            mFaceManager.getFigures(new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass1 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        MarkedFaceManagerActivity.this.hideLoadDlg();
                        FigureInfos figureInfos = (FigureInfos) obj2;
                        String str = MarkedFaceManagerActivity.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(figureInfos.figureInfos.size());
                        civ.O000000o(str, sb.toString());
                        MarkedFaceManagerActivity.this.mMarkedAdapter.setData(figureInfos.figureInfos);
                        MarkedFaceManagerActivity markedFaceManagerActivity = MarkedFaceManagerActivity.this;
                        markedFaceManagerActivity.resetImageView(markedFaceManagerActivity.mEditBtn);
                        if (figureInfos.figureInfos.size() == 0) {
                            MarkedFaceManagerActivity.this.mEditBtn.setEnabled(false);
                        } else {
                            MarkedFaceManagerActivity.this.mEditBtn.setEnabled(true);
                        }
                        MarkedFaceManagerActivity.this.mMarkedAdapter.notifyDataSetChanged();
                        MarkedFaceManagerActivity.this.refreshSelectTitle();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        MarkedFaceManagerActivity.this.hideLoadDlg();
                        String str2 = MarkedFaceManagerActivity.TAG;
                        civ.O00000o0(str2, i + "--" + str);
                    }
                }
            });
            mFaceManager.getUnmarkFaces(50, false, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass2 */

                public void onFailure(int i, String str) {
                }

                public void onSuccess(Object obj, Object obj2) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        ArrayList arrayList = (ArrayList) obj2;
                        if (arrayList.size() > 0) {
                            arrayList.get(0);
                        }
                        if (arrayList.size() > 1) {
                            arrayList.get(1);
                        }
                        if (arrayList.size() > 2) {
                            arrayList.get(2);
                        }
                    }
                }
            });
        }
    }

    private void showAddFaceDialog(String str) {
        if (mFaceManager != null) {
            FaceUtils.processMarkFace(this, str, mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass3 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        MarkedFaceManagerActivity.this.recyclerViewMarked.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$MarkedFaceManagerActivity$3$XilNGhuiRpe2k6yPc0zD6L4LX4 */

                            public final void run() {
                                MarkedFaceManagerActivity.AnonymousClass3.this.lambda$onSuccess$0$MarkedFaceManagerActivity$3();
                            }
                        }, 1000);
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$MarkedFaceManagerActivity$3() {
                    MarkedFaceManagerActivity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }

    public void onBackPressed() {
        FaceRecycler3Adapter faceRecycler3Adapter = this.mMarkedAdapter;
        if (faceRecycler3Adapter == null || !faceRecycler3Adapter.getSelectedMode()) {
            setResult(-1);
            super.onBackPressed();
            return;
        }
        setMultiSelectMode(false);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.select_delete) {
            deleteAlertDialog();
        } else if (view.getId() == R.id.ivSelectAllCancel) {
            FaceRecycler3Adapter faceRecycler3Adapter = this.mMarkedAdapter;
            if (faceRecycler3Adapter != null && faceRecycler3Adapter.getSelectedMode()) {
                setMultiSelectMode(false);
            }
        } else if (view.getId() == R.id.title_bar_more) {
            if (mFaceManager != null) {
                if (mFaceManager.getDevice().isReadOnlyShared()) {
                    gqg.O00000Oo((int) R.string.auth_fail_read_only);
                } else if (!this.mMarkedAdapter.getSelectedMode()) {
                    setMultiSelectMode(true);
                } else if (this.mMarkedAdapter.isSelectAll()) {
                    this.mMarkedAdapter.unSelectAll();
                    resetImageView(this.mEditBtn);
                } else {
                    this.mMarkedAdapter.selectAll();
                    hightLightImageView(this.mEditBtn);
                }
            }
        } else if (view.getId() != R.id.ivSelectAll) {
        } else {
            if (this.mSelectAllShowed) {
                this.mSelectAllShowed = false;
                this.mSelectAllBtn.setImageResource(R.drawable.icon_selected);
                this.mMarkedAdapter.selectAll();
                refreshSelectTitle();
                return;
            }
            this.mSelectAllShowed = true;
            this.mSelectAllBtn.setImageResource(R.drawable.icon_unselected);
            this.mMarkedAdapter.unSelectAll();
            refreshSelectTitle();
        }
    }

    private void deleteAlertDialog() {
        if (this.mMarkedAdapter.getSelectedCount() == 0) {
            gqg.O00000Oo((int) R.string.bottom_action_tip);
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o(getString(R.string.face_delete_dialog_title));
        builder.O00000Oo(getString(R.string.face_delete_dialog_message));
        builder.O00000Oo((int) R.string.camera_cancel, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass4 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                MarkedFaceManagerActivity.this.showDeleteDlg();
                FaceManagerBaseActivity.mFaceManager.deleteFigures(new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass5.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!MarkedFaceManagerActivity.this.isFinishing()) {
                            MarkedFaceManagerActivity.this.hideDeleteDlg();
                            MarkedFaceManagerActivity.this.showLoadDlg();
                            MarkedFaceManagerActivity.this.loadData();
                            gqg.O00000Oo((int) R.string.delete_sucess);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!MarkedFaceManagerActivity.this.isFinishing()) {
                            MarkedFaceManagerActivity.this.hideDeleteDlg();
                            gqg.O00000Oo((int) R.string.delete_failed);
                        }
                    }
                }, MarkedFaceManagerActivity.this.mMarkedAdapter.getSelectedFigureIds().toArray());
                MarkedFaceManagerActivity.this.setMultiSelectMode(false);
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
        return this.mMarkedAdapter.getSelectedCount();
    }

    /* access modifiers changed from: protected */
    public int getDataCount() {
        return this.mMarkedAdapter.mData.size();
    }

    public void onRecyclerClick(Object obj, View view, int i) {
        if (i >= this.mMarkedAdapter.mData.size() - 1) {
            hxi.O00000o.f952O000000o.O000000o("Face_AddPhoto_ClickNum", new Object[0]);
            if (this.mMarkedAdapter.mData.size() >= 11) {
                gqg.O00000Oo((int) R.string.figure_max_tips);
                return;
            }
            setMultiSelectMode(false);
            FaceUtils.showSelectDialog(this, mFaceManager.getDeviceId());
            return;
        }
        FaceRecycler3Adapter faceRecycler3Adapter = this.mMarkedAdapter;
        if (faceRecycler3Adapter != null) {
            if (!faceRecycler3Adapter.getSelectedMode()) {
                Intent intent = new Intent(this, FigureFacesManagerActivity.class);
                intent.putExtra("figureInfo", this.mMarkedAdapter.mData.get(i));
                startActivityForResult(intent, 0);
            } else if (this.mMarkedAdapter.isSelectAll()) {
                hightLightImageView(this.mEditBtn);
            } else {
                resetImageView(this.mEditBtn);
            }
        }
        refreshSelectTitle();
    }

    public void onRecyclerLongClick(Object obj, View view, int i) {
        FaceRecycler3Adapter faceRecycler3Adapter = this.mMarkedAdapter;
        if (faceRecycler3Adapter != null && !faceRecycler3Adapter.getSelectedMode()) {
            setMultiSelectMode(true);
        }
        refreshSelectTitle();
    }

    public void setMultiSelectMode(boolean z) {
        if (z) {
            this.layout_select_bottom.setVisibility(0);
            this.mEditBtn.setImageResource(R.drawable.mj_webp_titlebar_all_select_pres);
        } else {
            this.layout_select_bottom.setVisibility(8);
            this.mEditBtn.setImageResource(R.drawable.icon_edit_state);
        }
        this.mMarkedAdapter.setSelectedMode(z);
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
                /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass6 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        MarkedFaceManagerActivity.this.recyclerViewMarked.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$MarkedFaceManagerActivity$6$_99yM93lz0GWYrk24HFdSuKVXHI */

                            public final void run() {
                                MarkedFaceManagerActivity.AnonymousClass6.this.lambda$onSuccess$0$MarkedFaceManagerActivity$6();
                            }
                        }, 1000);
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$MarkedFaceManagerActivity$6() {
                    MarkedFaceManagerActivity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }
    }

    private void uploadFileAndMarkFace(String str) {
        gsy.O00000Oo(TAG, "uploadFileAndMarkFace ".concat(String.valueOf(str)));
        mFaceManager.uploadImageFile(this, str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass7 */

            public void onSuccess(Object obj, Object obj2) {
                if (!MarkedFaceManagerActivity.this.isFinishing()) {
                    try {
                        FaceUtils.processMarkFace(MarkedFaceManagerActivity.this.getContext(), ((JSONObject) ((JSONObject) obj).getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId"), FaceManagerBaseActivity.mFaceManager, new FaceManager.IFaceCallback() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass7.AnonymousClass1 */

                            public void onSuccess(Object obj, Object obj2) {
                                if (!MarkedFaceManagerActivity.this.isFinishing()) {
                                    gqg.O00000Oo((int) R.string.action_success);
                                    MarkedFaceManagerActivity.this.recyclerViewMarked.postDelayed(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE  
                                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0015: IGET  (r3v7 androidx.recyclerview.widget.RecyclerView) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity : 0x0013: IGET  (r3v6 com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7 : 0x0011: IGET  (r3v5 com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7$1 A[THIS]) com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.7.1.this$1 com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7)
                                         com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.7.this$0 com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity)
                                         com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.recyclerViewMarked androidx.recyclerview.widget.RecyclerView)
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM : 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM.<init>(com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7$1):void type: CONSTRUCTOR)
                                          (1000 long)
                                         type: VIRTUAL call: androidx.recyclerview.widget.RecyclerView.postDelayed(java.lang.Runnable, long):boolean in method: com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.7.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM.<init>(com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.7.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 112 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 118 more
                                        */
                                    /*
                                        this = this;
                                        com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7 r3 = com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass7.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity r3 = com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.this
                                        boolean r3 = r3.isFinishing()
                                        if (r3 == 0) goto L_0x000b
                                        return
                                    L_0x000b:
                                        r3 = 2132672708(0x7f1e00c4, float:2.10022E38)
                                        _m_j.gqg.O00000Oo(r3)
                                        com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity$7 r3 = com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass7.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity r3 = com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.this
                                        androidx.recyclerview.widget.RecyclerView r3 = r3.recyclerViewMarked
                                        com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM r4 = new com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$MarkedFaceManagerActivity$7$1$yAkjEcdOE8IhiB4jQAp94H3-kvM
                                        r4.<init>(r2)
                                        r0 = 1000(0x3e8, double:4.94E-321)
                                        r3.postDelayed(r4, r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.camera.face.activity.MarkedFaceManagerActivity.AnonymousClass7.AnonymousClass1.onSuccess(java.lang.Object, java.lang.Object):void");
                                }

                                public /* synthetic */ void lambda$onSuccess$0$MarkedFaceManagerActivity$7$1() {
                                    MarkedFaceManagerActivity.this.loadData();
                                }

                                public void onFailure(int i, String str) {
                                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
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
                    if (!MarkedFaceManagerActivity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }

        public void onDestroy() {
            super.onDestroy();
            FaceRecycler3Adapter faceRecycler3Adapter = this.mMarkedAdapter;
            if (faceRecycler3Adapter != null) {
                faceRecycler3Adapter.destroyDisplayImageOptions();
            }
            chr.O0000o0();
        }

        private void hightLightImageView(ImageView imageView) {
            imageView.setColorFilter(Color.parseColor("#32BAC0"));
        }

        public void resetImageView(ImageView imageView) {
            imageView.clearColorFilter();
        }

        class ItemDecoration extends RecyclerView.O0000Oo {
            private int space;

            public ItemDecoration() {
                this.space = 0;
                this.space = (int) (chp.O00000o0 * 2.0f);
            }

            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.O000OO0o o000OO0o) {
                if (recyclerView.getChildAdapterPosition(view) == MarkedFaceManagerActivity.this.mMarkedAdapter.getItemCount() - 1) {
                    rect.bottom = 50;
                }
            }
        }
    }
