package com.xiaomi.smarthome.camera.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.xiaomi.smarthome.R;

public class SDCardHintDialog extends AlertDialog implements View.OnClickListener {
    private TextView tvIKnow;

    public SDCardHintDialog(Context context) {
        super(context);
    }

    public SDCardHintDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    public SDCardHintDialog(Context context, int i) {
        super(context, i);
    }

    public void show() {
        super.show();
        init();
        initViews();
    }

    private void init() {
        getWindow().setContentView((int) R.layout.camera_sdcard_hint);
    }

    private void initViews() {
        this.tvIKnow = (TextView) findViewById(R.id.tvIKnow);
        this.tvIKnow.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tvIKnow) {
            dismiss();
        }
    }
}
