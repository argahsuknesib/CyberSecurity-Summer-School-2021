package com.xiaomi.smarthome.camera.view;

import _m_j.gwg;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.xiaomi.smarthome.R;

public class GuidePage1 extends AlertDialog implements View.OnClickListener {
    public GuidePage1(Context context) {
        super(context);
    }

    public GuidePage1(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public GuidePage1(Context context, int i) {
        super(context, i);
    }

    public void show() {
        super.show();
        init();
        initViews();
    }

    private void init() {
        getWindow().setContentView((int) R.layout.camera_guilde_page_1);
    }

    private void initViews() {
        gwg.O00000Oo(getWindow());
        findViewById(R.id.rlDialogGuidePage1).setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.rlDialogGuidePage1) {
            dismiss();
        }
    }
}
