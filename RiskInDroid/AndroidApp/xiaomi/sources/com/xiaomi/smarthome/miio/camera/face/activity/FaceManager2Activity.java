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
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayout;
import com.xiaomi.smarthome.camera.view.recycle.RecyclerViewRefreshLayoutEx;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.camera.face.ClickCallback;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceRecycler2Adapter;
import com.xiaomi.smarthome.miio.camera.face.adapter.FaceShownRecentlyRVAdapter;
import com.xiaomi.smarthome.miio.camera.face.model.ClusteringInfos;
import com.xiaomi.smarthome.miio.camera.face.model.FaceInfoEx;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import com.xiaomi.smarthome.miio.camera.face.util.FaceUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceManager2Activity extends FaceSelectActivity implements View.OnClickListener, ClickCallback {
    public static final String TAG = "FaceManager2Activity";
    public Map<Integer, FaceInfoEx> faceLable2FaceInfoEx;
    public Map<String, FaceInfoEx> figureId2FaceInfoEx;
    private ImageView ivTitleBarMore;
    public boolean mIsMultiSelectMode = false;
    public FaceRecycler2Adapter mMarkedAdapter;
    private XQProgressDialog mProgressDlg;
    private XQProgressDialog mPulingDlg;
    public boolean mSelectAllShowed = true;
    public FaceShownRecentlyRVAdapter mShownRecentlyAdapter;
    RecyclerViewRefreshLayoutEx ptrLayout;
    public RecyclerView recyclerViewFaceShown;
    public RecyclerView recyclerViewMarked;
    public RelativeLayout rlEmptyContent;
    private ImageView title_bar_return;
    public TextView tvFaceManagement;
    public TextView tvFaceMarked;

    public void onRecyclerLongClick(Object obj, View view, int i) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_face_manager2);
        gwg.O000000o(findViewById(R.id.title_bar_container));
        initSelectView();
        iniView();
        loadData();
        chr.O0000o00();
    }

    private void iniView() {
        showLoadDlg();
        this.tvFaceMarked = (TextView) findViewById(R.id.tv_face_marked);
        this.tvFaceManagement = (TextView) findViewById(R.id.tv_face_management);
        this.ivTitleBarMore = (ImageView) findViewById(R.id.title_bar_more);
        this.ivTitleBarMore.setVisibility(8);
        this.tvFaceManagement.setOnClickListener(this);
        this.tvFaceMarked.setText(String.format(getString(R.string.face_marked), 0));
        ((TextView) findViewById(R.id.title_bar_title)).setText(getResources().getString(R.string.lowpower_face_manager));
        this.rlEmptyContent = (RelativeLayout) findViewById(R.id.rl_empty_content);
        this.recyclerViewMarked = (RecyclerView) findViewById(R.id.recycle_view_marked);
        this.mMarkedAdapter = new FaceRecycler2Adapter(this, this, mFaceManager);
        this.mMarkedAdapter.setHasStableIds(true);
        this.recyclerViewMarked.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((hd) this.recyclerViewMarked.getItemAnimator()).O0000o00 = false;
        this.recyclerViewMarked.setAnimation(null);
        this.recyclerViewMarked.setAdapter(this.mMarkedAdapter);
        this.ptrLayout = (RecyclerViewRefreshLayoutEx) findViewById(R.id.ptr);
        this.recyclerViewFaceShown = (RecyclerView) findViewById(R.id.recycle_view_face_shown);
        this.mShownRecentlyAdapter = new FaceShownRecentlyRVAdapter(this, this, mFaceManager);
        this.recyclerViewFaceShown.setLayoutManager(new LinearLayoutManager(this, 1, false));
        ((hd) this.recyclerViewFaceShown.getItemAnimator()).O0000o00 = false;
        this.recyclerViewFaceShown.setAnimation(null);
        this.recyclerViewFaceShown.setAdapter(this.mShownRecentlyAdapter);
        this.ptrLayout.setOnPullRefreshListener(new RecyclerViewRefreshLayout.OnPullRefreshListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass1 */

            public void onPullDistance(int i) {
            }

            public void onPullEnable(boolean z) {
            }

            public void onRefresh() {
                if (!FaceManager2Activity.this.isFinishing()) {
                    FaceManager2Activity.this.ptrLayout.setRefreshing(true);
                    FaceManager2Activity.this.loadData();
                }
            }
        });
    }

    public void loadData() {
        if (mFaceManager != null) {
            this.mShownRecentlyAdapter.clearData();
            mFaceManager.getFigures(new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass2 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManager2Activity.this.isFinishing()) {
                        FigureInfos figureInfos = (FigureInfos) obj2;
                        if (figureInfos.figureInfos.size() >= 0) {
                            FaceManager2Activity.this.tvFaceMarked.setText(String.format(FaceManager2Activity.this.getString(R.string.face_marked), Integer.valueOf(figureInfos.figureInfos.size())));
                            if (figureInfos.figureInfos.size() == 0) {
                                FaceManager2Activity.this.tvFaceManagement.setVisibility(8);
                            } else {
                                FaceManager2Activity.this.tvFaceManagement.setVisibility(0);
                            }
                        } else {
                            FaceManager2Activity.this.mEditBtn.setVisibility(8);
                        }
                        String str = FaceManager2Activity.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append(figureInfos.figureInfos.size());
                        gsy.O00000Oo(str, sb.toString());
                        ArrayList arrayList = new ArrayList();
                        Iterator<FigureInfo> it = figureInfos.figureInfos.iterator();
                        while (it.hasNext()) {
                            FigureInfo next = it.next();
                            FaceInfoEx faceInfoEx = new FaceInfoEx();
                            faceInfoEx.figureId = next.figureId;
                            faceInfoEx.coverFaceId = next.coverFaceId;
                            faceInfoEx.figureInfo = next.figureInfo;
                            faceInfoEx.figureName = next.figureName;
                            faceInfoEx.selected = next.selected;
                            arrayList.add(faceInfoEx);
                        }
                        FaceManager2Activity.this.mMarkedAdapter.setData(arrayList);
                        FaceManager2Activity.this.mMarkedAdapter.notifyDataSetChanged();
                        FaceManager2Activity.this.refreshSelectTitle();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FaceManager2Activity.this.isFinishing()) {
                        FaceManager2Activity.this.hideLoadDlg();
                        String str2 = FaceManager2Activity.TAG;
                        civ.O00000o0(str2, i + "--" + str);
                    }
                }
            });
            mFaceManager.getFacesCluster(new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass3 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManager2Activity.this.isFinishing()) {
                        ClusteringInfos clusteringInfos = (ClusteringInfos) obj2;
                        FaceManager2Activity.this.faceLable2FaceInfoEx = new HashMap();
                        FaceManager2Activity.this.figureId2FaceInfoEx = new HashMap();
                        String str = FaceManager2Activity.TAG;
                        gsy.O00000Oo(str, "getFacesCluster: " + clusteringInfos.clusteringInfos.toString());
                        Iterator<FaceInfoEx> it = clusteringInfos.clusteringInfos.iterator();
                        while (it.hasNext()) {
                            FaceInfoEx next = it.next();
                            if (FaceManager2Activity.this.faceLable2FaceInfoEx.containsKey(Integer.valueOf(next.faceLable))) {
                                FaceInfoEx faceInfoEx = FaceManager2Activity.this.faceLable2FaceInfoEx.get(Integer.valueOf(next.faceLable));
                                if (faceInfoEx.figureName == null && next.figureName != null) {
                                    faceInfoEx.figureName = next.figureName;
                                    faceInfoEx.figureId = next.figureId;
                                }
                                if (next.figureId == null || next.figureId.equals(faceInfoEx.figureId)) {
                                    faceInfoEx.faceIds.add(next.faceId);
                                } else if (FaceManager2Activity.this.figureId2FaceInfoEx.containsKey(next.figureId)) {
                                    FaceManager2Activity.this.figureId2FaceInfoEx.get(next.figureId).faceIds.add(next.faceId);
                                } else {
                                    next.faceIds.add(next.faceId);
                                    FaceManager2Activity.this.figureId2FaceInfoEx.put(next.figureId, next);
                                }
                            } else {
                                next.faceIds.add(next.faceId);
                                FaceManager2Activity.this.faceLable2FaceInfoEx.put(Integer.valueOf(next.faceLable), next);
                            }
                        }
                        String str2 = FaceManager2Activity.TAG;
                        gsy.O00000Oo(str2, "getFacesCluster faceLable2FaceInfoEx: " + FaceManager2Activity.this.faceLable2FaceInfoEx.values().toString());
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<Integer, FaceInfoEx> value : FaceManager2Activity.this.faceLable2FaceInfoEx.entrySet()) {
                            FaceInfoEx faceInfoEx2 = (FaceInfoEx) value.getValue();
                            if (faceInfoEx2.figureId == null) {
                                arrayList.add(faceInfoEx2);
                            } else if (FaceManager2Activity.this.figureId2FaceInfoEx.containsKey(faceInfoEx2.figureId)) {
                                FaceManager2Activity.this.figureId2FaceInfoEx.get(faceInfoEx2.figureId).faceIds.addAll(faceInfoEx2.faceIds);
                            } else {
                                FaceManager2Activity.this.figureId2FaceInfoEx.put(faceInfoEx2.figureId, faceInfoEx2);
                            }
                        }
                        String str3 = FaceManager2Activity.TAG;
                        gsy.O00000Oo(str3, "getFacesCluster figureId2FaceInfoEx: " + FaceManager2Activity.this.figureId2FaceInfoEx.values().toString());
                        for (Map.Entry<String, FaceInfoEx> value2 : FaceManager2Activity.this.figureId2FaceInfoEx.entrySet()) {
                            arrayList.add(value2.getValue());
                        }
                        if (arrayList.size() > 0) {
                            String str4 = FaceManager2Activity.TAG;
                            gsy.O00000Oo(str4, "getFacesCluster dupRemovalList: " + arrayList.toString());
                            Collections.sort(arrayList, new Comparator<FaceInfoEx>() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass3.AnonymousClass1 */

                                public int compare(FaceInfoEx faceInfoEx, FaceInfoEx faceInfoEx2) {
                                    if (faceInfoEx.updateTime < faceInfoEx2.updateTime) {
                                        return 1;
                                    }
                                    return faceInfoEx.updateTime > faceInfoEx2.updateTime ? -1 : 0;
                                }
                            });
                            FaceManager2Activity.this.mShownRecentlyAdapter.setData(arrayList);
                            FaceManager2Activity.this.mShownRecentlyAdapter.notifyDataSetChanged();
                        } else {
                            FaceManager2Activity.this.recyclerViewFaceShown.setVisibility(8);
                            FaceManager2Activity.this.rlEmptyContent.setVisibility(0);
                        }
                        FaceManager2Activity.this.ptrLayout.setRefreshing(false);
                        FaceManager2Activity.this.hideLoadDlg();
                    }
                }

                public void onFailure(int i, String str) {
                    if (!FaceManager2Activity.this.isFinishing()) {
                        FaceManager2Activity.this.ptrLayout.setRefreshing(false);
                        FaceManager2Activity.this.hideLoadDlg();
                        String str2 = FaceManager2Activity.TAG;
                        civ.O00000o0(str2, i + "--" + str);
                    }
                }
            });
        }
    }

    private void showAddFacesDialog(String str) {
        if (mFaceManager != null) {
            FaceUtils.processMarkFaces(this, str, mFaceManager, new FaceManager.IFaceCallback() {
                /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass4 */

                public void onSuccess(Object obj, Object obj2) {
                    if (!FaceManager2Activity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_success);
                        FaceManager2Activity.this.recyclerViewMarked.postDelayed(new Runnable() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$FaceManager2Activity$4$3FQiVczKogcaLcH_hoOeQjNfqQ */

                            public final void run() {
                                FaceManager2Activity.AnonymousClass4.this.lambda$onSuccess$0$FaceManager2Activity$4();
                            }
                        }, 1000);
                    }
                }

                public /* synthetic */ void lambda$onSuccess$0$FaceManager2Activity$4() {
                    FaceManager2Activity.this.loadData();
                }

                public void onFailure(int i, String str) {
                    if (!FaceManager2Activity.this.isFinishing()) {
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

    public void onClick(View view) {
        if (view.getId() == R.id.title_bar_return) {
            onBackPressed();
        } else if (view.getId() == R.id.ivSelectAllCancel) {
            if (this.mIsMultiSelectMode) {
                setMultiSelectMode(false);
            }
        } else if (view.getId() == R.id.ivSelectAll) {
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
        } else if (view.getId() == R.id.tv_face_management) {
            Intent intent = new Intent(this, MarkedFaceManagerActivity.class);
            intent.putExtra("extra_device_did", mFaceManager.getDeviceId());
            startActivityForResult(intent, 2);
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
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.O000000o((int) R.string.camera_sure, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                FaceManager2Activity.this.showDeleteDlg();
                FaceManagerBaseActivity.mFaceManager.deleteFigures(new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass6.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!FaceManager2Activity.this.isFinishing()) {
                            FaceManager2Activity.this.hideDeleteDlg();
                            FaceManager2Activity.this.showLoadDlg();
                            FaceManager2Activity.this.loadData();
                            gqg.O00000Oo((int) R.string.delete_sucess);
                        }
                    }

                    public void onFailure(int i, String str) {
                        if (!FaceManager2Activity.this.isFinishing()) {
                            FaceManager2Activity.this.hideDeleteDlg();
                            gqg.O00000Oo((int) R.string.delete_failed);
                        }
                    }
                }, FaceManager2Activity.this.mMarkedAdapter.getSelectedFigureIds().toArray());
                FaceManager2Activity.this.setMultiSelectMode(false);
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
    public void onRecyclerClick(Object obj, View view, int i) {
        FaceInfoEx faceInfoEx;
        if (obj instanceof FaceShownRecentlyRVAdapter.ItemViewHolder) {
            FaceInfoEx faceInfoEx2 = this.mShownRecentlyAdapter.mData.get(i);
            gsy.O000000o(6, "click_recently", faceInfoEx2.toString());
            if (faceInfoEx2 == null) {
                return;
            }
            if (view.getId() != R.id.tv_operation || TextUtils.isEmpty(((TextView) view).getText())) {
                hxi.O00000o.f952O000000o.O000000o("Face_RecentFace_ClickNum", new Object[0]);
                Intent intent = new Intent(this, FigureFacesEventActivity.class);
                intent.putExtra("figureInfo", faceInfoEx2);
                gsy.O000000o(3, "figureInfo", faceInfoEx2.toString());
                startActivityForResult(intent, 0);
                return;
            }
            hxi.O00000o.f952O000000o.O000000o("Face_RecentFaceAdd_ClickNum", new Object[0]);
            if (!TextUtils.isEmpty(faceInfoEx2.coverFaceId)) {
                showAddFacesDialog(faceInfoEx2.coverFaceId);
            } else {
                showAddFacesDialog(faceInfoEx2.faceId);
            }
        } else if (i >= this.mMarkedAdapter.mData.size() - 1) {
            hxi.O00000o.f952O000000o.O000000o("Face_AddFace_ClickNum", new Object[0]);
            setMultiSelectMode(false);
            FaceUtils.showSelectDialog(this, mFaceManager.getDeviceId());
        } else {
            if (!this.mIsMultiSelectMode) {
                String str = this.mMarkedAdapter.mData.get(i).figureId;
                Map<String, FaceInfoEx> map = this.figureId2FaceInfoEx;
                if (map == null || !map.containsKey(str)) {
                    faceInfoEx = this.mMarkedAdapter.mData.get(i);
                } else {
                    faceInfoEx = this.figureId2FaceInfoEx.get(str);
                    faceInfoEx.coverFaceId = this.mMarkedAdapter.mData.get(i).coverFaceId;
                }
                hxi.O00000o.f952O000000o.O000000o("Face_RegisteredFace_ClickNum", new Object[0]);
                Intent intent2 = new Intent(this, FigureFacesEventActivity.class);
                intent2.putExtra("figureInfo", faceInfoEx);
                intent2.putExtra("is_from_manage", true);
                startActivityForResult(intent2, 0);
            }
            refreshSelectTitle();
        }
    }

    public void setMultiSelectMode(boolean z) {
        this.mIsMultiSelectMode = z;
        this.mMarkedAdapter.setSelectedMode(z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 0 || i == 1) {
            if (i2 == -1) {
                showLoadDlg();
            }
            loadData();
        } else if (i != 2) {
            if ((i == 101 || i == 102) && i2 == -1) {
                FaceUtils.processMarkFace(getContext(), intent.getStringExtra("faceId"), mFaceManager, new FaceManager.IFaceCallback() {
                    /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass7 */

                    public void onSuccess(Object obj, Object obj2) {
                        if (!FaceManager2Activity.this.isFinishing()) {
                            gqg.O00000Oo((int) R.string.action_success);
                            FaceManager2Activity.this.recyclerViewMarked.postDelayed(new Runnable() {
                                /* class com.xiaomi.smarthome.miio.camera.face.activity.$$Lambda$FaceManager2Activity$7$kDIWbrjLtgKHZvRw52aabrQOA1U */

                                public final void run() {
                                    FaceManager2Activity.AnonymousClass7.this.lambda$onSuccess$0$FaceManager2Activity$7();
                                }
                            }, 1000);
                        }
                    }

                    public /* synthetic */ void lambda$onSuccess$0$FaceManager2Activity$7() {
                        FaceManager2Activity.this.loadData();
                    }

                    public void onFailure(int i, String str) {
                        if (!FaceManager2Activity.this.isFinishing()) {
                            gqg.O00000Oo((int) R.string.action_fail);
                        }
                    }
                });
            }
        } else if (i2 == -1) {
            loadData();
        }
    }

    private void uploadFileAndMarkFace(String str) {
        gsy.O000000o(3, TAG, "uploadFileAndMarkFace ".concat(String.valueOf(str)));
        mFaceManager.uploadImageFile(this, str, new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass8 */

            public void onSuccess(Object obj, Object obj2) {
                if (!FaceManager2Activity.this.isFinishing()) {
                    try {
                        FaceUtils.processMarkFace(FaceManager2Activity.this.getContext(), ((JSONObject) ((JSONObject) obj).getJSONObject("data").getJSONArray("faceInfoMetas").get(0)).getString("faceId"), FaceManagerBaseActivity.mFaceManager, new FaceManager.IFaceCallback() {
                            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass8.AnonymousClass1 */

                            public void onSuccess(Object obj, Object obj2) {
                                if (!FaceManager2Activity.this.isFinishing()) {
                                    gqg.O00000Oo((int) R.string.action_success);
                                    FaceManager2Activity.this.recyclerViewMarked.postDelayed(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE  
                                          (wrap: androidx.recyclerview.widget.RecyclerView : 0x0015: IGET  (r3v7 androidx.recyclerview.widget.RecyclerView) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity : 0x0013: IGET  (r3v6 com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity) = 
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8 : 0x0011: IGET  (r3v5 com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8$1 A[THIS]) com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.8.1.this$1 com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8)
                                         com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.8.this$0 com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity)
                                         com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.recyclerViewMarked androidx.recyclerview.widget.RecyclerView)
                                          (wrap: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE : 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE.<init>(com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8$1):void type: CONSTRUCTOR)
                                          (1000 long)
                                         type: VIRTUAL call: androidx.recyclerview.widget.RecyclerView.postDelayed(java.lang.Runnable, long):boolean in method: com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.8.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
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
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0019: CONSTRUCTOR  (r4v1 com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE) = (r2v0 'this' com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8$1 A[THIS]) call: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE.<init>(com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8$1):void type: CONSTRUCTOR in method: com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.8.1.onSuccess(java.lang.Object, java.lang.Object):void, dex: classes5.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:122)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:106)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:790)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:730)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 112 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE, state: NOT_LOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:270)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 118 more
                                        */
                                    /*
                                        this = this;
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8 r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass8.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.this
                                        boolean r3 = r3.isFinishing()
                                        if (r3 == 0) goto L_0x000b
                                        return
                                    L_0x000b:
                                        r3 = 2132672708(0x7f1e00c4, float:2.10022E38)
                                        _m_j.gqg.O00000Oo(r3)
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity$8 r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass8.this
                                        com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity r3 = com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.this
                                        androidx.recyclerview.widget.RecyclerView r3 = r3.recyclerViewMarked
                                        com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE r4 = new com.xiaomi.smarthome.miio.camera.face.activity.-$$Lambda$FaceManager2Activity$8$1$8fNwcC_MEialf9PsqIp4sWjilvE
                                        r4.<init>(r2)
                                        r0 = 1000(0x3e8, double:4.94E-321)
                                        r3.postDelayed(r4, r0)
                                        return
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smarthome.miio.camera.face.activity.FaceManager2Activity.AnonymousClass8.AnonymousClass1.onSuccess(java.lang.Object, java.lang.Object):void");
                                }

                                public /* synthetic */ void lambda$onSuccess$0$FaceManager2Activity$8$1() {
                                    FaceManager2Activity.this.loadData();
                                }

                                public void onFailure(int i, String str) {
                                    if (!FaceManager2Activity.this.isFinishing()) {
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
                    if (!FaceManager2Activity.this.isFinishing()) {
                        gqg.O00000Oo((int) R.string.action_fail);
                    }
                }
            });
        }

        public void onDestroy() {
            super.onDestroy();
            FaceRecycler2Adapter faceRecycler2Adapter = this.mMarkedAdapter;
            if (faceRecycler2Adapter != null) {
                faceRecycler2Adapter.destroyDisplayImageOptions();
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
                if (recyclerView.getChildAdapterPosition(view) == FaceManager2Activity.this.mMarkedAdapter.getItemCount() - 1) {
                    rect.bottom = 50;
                }
            }
        }
    }
