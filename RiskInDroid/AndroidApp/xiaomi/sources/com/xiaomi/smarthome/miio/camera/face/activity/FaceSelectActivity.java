package com.xiaomi.smarthome.miio.camera.face.activity;

import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public abstract class FaceSelectActivity extends FaceManagerBaseActivity implements View.OnClickListener {
    public ImageView mEditBtn;
    public boolean mIsMultiSelectMode = false;
    public ImageView mSelectAllBtn;
    public boolean mSelectAllShowed = true;
    public View mSelectBottom;
    public ImageView mSelectCancel;
    public TextView mSelectTitleView;
    public View mSelectTop;
    private Vibrator mVibrator;

    /* access modifiers changed from: protected */
    public abstract int getDataCount();

    /* access modifiers changed from: protected */
    public abstract int getSelectCount();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mVibrator = (Vibrator) getSystemService("vibrator");
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void initSelectView() {
        this.mSelectTitleView = (TextView) findViewById(R.id.select_all_title);
        this.mEditBtn = (ImageView) findViewById(R.id.title_bar_more);
        this.mSelectAllBtn = (ImageView) findViewById(R.id.ivSelectAll);
        this.mSelectCancel = (ImageView) findViewById(R.id.ivSelectAllCancel);
        this.mEditBtn.setImageResource(R.drawable.title_edit_drawable);
        this.mSelectTop = findViewById(R.id.select_all_title_bar);
        this.mSelectBottom = findViewById(R.id.layout_select_bottom);
        this.mSelectAllBtn.setImageResource(R.drawable.mj_webp_titlebar_all_select_pres);
        findViewById(R.id.title_bar_return).setOnClickListener(this);
        this.mEditBtn.setOnClickListener(this);
        this.mSelectAllBtn.setOnClickListener(this);
        this.mSelectCancel.setOnClickListener(this);
    }

    public void setMultiSelectMode(boolean z) {
        setMultiSelectMode(z, false);
    }

    public void setMultiSelectMode(boolean z, boolean z2) {
        if (this.mIsMultiSelectMode != z) {
            if (z) {
                this.mSelectAllShowed = true;
                this.mEditBtn.setVisibility(8);
                this.mSelectTop.setVisibility(0);
                this.mSelectBottom.setVisibility(0);
                if (z2) {
                    this.mVibrator.vibrate(200);
                }
            } else {
                this.mEditBtn.setVisibility(0);
                this.mSelectTop.setVisibility(8);
                this.mSelectBottom.setVisibility(8);
            }
            refreshSelectTitle();
            this.mIsMultiSelectMode = z;
        }
    }

    public void refreshSelectTitle() {
        int selectCount = getSelectCount();
        if (selectCount == 0) {
            this.mSelectTitleView.setText((int) R.string.select_title_1);
            return;
        }
        this.mSelectTitleView.setText(getString(R.string.select_title_2, new Object[]{Integer.valueOf(selectCount)}));
    }

    public void onBackPressed() {
        if (this.mIsMultiSelectMode) {
            setMultiSelectMode(false);
        } else {
            super.onBackPressed();
        }
    }
}
