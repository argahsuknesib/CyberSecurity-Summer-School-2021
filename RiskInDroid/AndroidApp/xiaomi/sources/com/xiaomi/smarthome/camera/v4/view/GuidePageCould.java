package com.xiaomi.smarthome.camera.v4.view;

import _m_j.gwg;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.xiaomi.smarthome.R;

public class GuidePageCould extends AlertDialog implements View.OnClickListener {
    public void setLayoutX(int i) {
    }

    public GuidePageCould(Context context) {
        super(context);
    }

    public GuidePageCould(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public GuidePageCould(Context context, int i) {
        super(context, i);
    }

    public void show() {
        super.show();
        init();
        initViews();
    }

    private void init() {
        getWindow().setContentView((int) R.layout.dialog_guilde_page_cloud);
    }

    private void initViews() {
        gwg.O00000Oo(getWindow());
        findViewById(R.id.rlHomeCloudTip).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.rlHomeCloudTip) {
            dismiss();
        }
    }
}
