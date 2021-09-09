package com.xiaomi.smarthome.miio.camera.face.activity;

import _m_j.cnx;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.miio.camera.face.FaceManager;
import com.xiaomi.smarthome.miio.camera.face.model.FaceInfoEx;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfo;
import com.xiaomi.smarthome.miio.camera.face.model.FigureInfos;
import java.util.Iterator;

public abstract class FaceSelectActivityNew extends FaceManagerBaseActivity {
    FaceInfoEx figureInfoEx;
    private boolean isAllSelected;
    private boolean isEditMode;
    private boolean isInit;
    private ImageView mBackView;
    private ImageView mMoreView;
    private View mSelectBottom;
    private TextView mTitleView;
    private Vibrator mVibrator;
    View.OnClickListener onClickListener = new View.OnClickListener() {
        /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceSelectActivityNew.AnonymousClass1 */

        public void onClick(View view) {
            if (view.getId() == R.id.title_bar_return) {
                FaceSelectActivityNew.this.handleBackPressed();
            } else if (view.getId() == R.id.title_bar_more) {
                FaceSelectActivityNew.this.onClickMore();
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract String getPageTitle();

    /* access modifiers changed from: protected */
    public abstract int getSelectCount();

    /* access modifiers changed from: protected */
    public abstract boolean isAllSelected();

    /* access modifiers changed from: protected */
    public abstract void onEnterSelectMode();

    /* access modifiers changed from: protected */
    public abstract void onExitSelectMode();

    /* access modifiers changed from: protected */
    public abstract void onSelectAll();

    /* access modifiers changed from: protected */
    public abstract void onUnSelectAll();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mVibrator = (Vibrator) getSystemService("vibrator");
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void initSelectView() {
        this.mMoreView = (ImageView) findViewById(R.id.title_bar_more);
        this.mTitleView = (TextView) findViewById(R.id.title_bar_title);
        this.mBackView = (ImageView) findViewById(R.id.title_bar_return);
        this.mSelectBottom = findViewById(R.id.layout_select_bottom);
        this.mBackView.setOnClickListener(this.onClickListener);
        this.mMoreView.setOnClickListener(this.onClickListener);
        this.isInit = true;
        exitSelectMode();
    }

    public void onClickMore() {
        if (!this.isEditMode) {
            enterSelectMode();
        } else if (!this.isAllSelected) {
            selectAll();
        } else {
            unSelectAll();
        }
    }

    public void refreshSelectTitle() {
        if (isAllSelected()) {
            this.isAllSelected = true;
            hightLightImageView(this.mMoreView);
        } else {
            this.isAllSelected = false;
            resetImageView(this.mMoreView);
        }
        onRefreshSelectTitle();
    }

    private void onRefreshSelectTitle() {
        int selectCount = getSelectCount();
        if (!this.isEditMode) {
            this.mTitleView.setText(getPageTitle());
        } else if (selectCount == 0) {
            this.mTitleView.setText((int) R.string.select_title_1);
        } else {
            this.mTitleView.setText(getString(R.string.select_title_2, new Object[]{Integer.valueOf(selectCount)}));
        }
    }

    public boolean handleBackPressed() {
        if (!this.isEditMode) {
            return false;
        }
        exitSelectMode();
        return true;
    }

    public void enterSelectMode() {
        this.isEditMode = true;
        this.mBackView.setImageResource(R.drawable.icon_face_cancle);
        this.mMoreView.setImageResource(R.drawable.camera_edit_select_all_black);
        onEnterSelectMode();
        refreshSelectTitle();
        this.mSelectBottom.setVisibility(0);
    }

    public void exitSelectMode() {
        this.isAllSelected = false;
        resetImageView(this.mMoreView);
        this.isEditMode = false;
        this.mBackView.setImageResource(R.drawable.mj_tittlebar_main_device_back);
        this.mMoreView.setImageResource(R.drawable.camera_title_edit_drawable);
        if (!this.isInit) {
            onExitSelectMode();
            refreshSelectTitle();
        }
        if (this.isInit) {
            this.isInit = false;
        }
        this.mSelectBottom.setVisibility(8);
    }

    private void selectAll() {
        this.isAllSelected = true;
        hightLightImageView(this.mMoreView);
        onSelectAll();
        onRefreshSelectTitle();
    }

    private void unSelectAll() {
        this.isAllSelected = false;
        resetImageView(this.mMoreView);
        onUnSelectAll();
        onRefreshSelectTitle();
    }

    private void hightLightImageView(ImageView imageView) {
        imageView.setColorFilter(Color.parseColor("#32BAC0"));
    }

    private void resetImageView(ImageView imageView) {
        imageView.clearColorFilter();
    }

    /* access modifiers changed from: package-private */
    public void updateCoverFace(final ImageView imageView) {
        mFaceManager.getFigures(new FaceManager.IFaceCallback() {
            /* class com.xiaomi.smarthome.miio.camera.face.activity.FaceSelectActivityNew.AnonymousClass2 */

            public void onFailure(int i, String str) {
            }

            public void onSuccess(Object obj, Object obj2) {
                if (!FaceSelectActivityNew.this.isFinishing()) {
                    FigureInfos figureInfos = (FigureInfos) obj2;
                    if (figureInfos.figureInfos.size() > 0) {
                        Iterator<FigureInfo> it = figureInfos.figureInfos.iterator();
                        while (it.hasNext()) {
                            FigureInfo next = it.next();
                            if (FaceSelectActivityNew.this.figureInfoEx.figureId.equals(next.figureId)) {
                                FaceSelectActivityNew.this.figureInfoEx.coverFaceId = next.coverFaceId;
                                if (cnx.O000000o().O00000Oo()) {
                                    cnx.O000000o().O000000o(FaceManagerBaseActivity.mFaceManager.getFaceImg(FaceSelectActivityNew.this.figureInfoEx.coverFaceId), imageView);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
            }
        });
    }
}
